package com.jzx.bda.somero.dubbo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.remoting.TimeoutException;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.RpcInvocation;
import com.jzx.bda.somero.BinaryAnnotation;
import com.jzx.bda.somero.Endpoint;
import com.jzx.bda.somero.Span;
import com.jzx.bda.somero.agent.Tracer;
import com.jzx.bda.somero.agent.support.TracerUtils;

/**
 * 过滤器
 */
@Activate(group = { Constants.PROVIDER, Constants.CONSUMER })
public class SomeroFilter implements Filter {

	private static Logger logger = LoggerFactory.getLogger(SomeroFilter.class);

	private Tracer tracer = null;

	// 调用过程拦截
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		// 异步获取serviceId，没获取到不进行采样
		String serviceId = tracer.getServiceId(RpcContext.getContext().getUrl().getServiceInterface());
		if (serviceId == null) {
			Tracer.startTraceWork();
			return invoker.invoke(invocation);
		}

		long start = System.currentTimeMillis();
		RpcContext context = RpcContext.getContext();
		boolean isConsumerSide = context.isConsumerSide();
		Span span = null;
		Endpoint endpoint = null;
		try {
			endpoint = tracer.newEndPoint();
			// endpoint.setServiceName(serviceId);
			endpoint.setIp(context.getLocalAddressString());
			endpoint.setPort(context.getLocalPort());
			if (context.isConsumerSide()) { // 是否是消费者
				Span span1 = tracer.getParentSpan();
				if (span1 == null) { // 为rootSpan
					span = tracer.newSpan(context.getMethodName(), endpoint, serviceId);// 生成rootSpan
				} else {
					span = tracer.genSpan(span1.getTraceId(), span1.getId(), tracer.genSpanId(), context.getMethodName(), span1.isSample(), null);
				}
			} else if (context.isProviderSide()) {
				Long traceId, parentId, spanId;
				traceId = TracerUtils.getAttachmentLong(invocation.getAttachment(TracerUtils.TID));
				parentId = TracerUtils.getAttachmentLong(invocation.getAttachment(TracerUtils.PID));
				spanId = TracerUtils.getAttachmentLong(invocation.getAttachment(TracerUtils.SID));
				boolean isSample = (traceId != null);
				span = tracer.genSpan(traceId, parentId, spanId, context.getMethodName(), isSample, serviceId);
			}
			invokerBefore(invocation, span, endpoint, start);// 记录annotation
			RpcInvocation invocation1 = (RpcInvocation) invocation;
			setAttachment(span, invocation1);// 设置需要向下游传递的参数
			Result result = invoker.invoke(invocation);
			if (result.getException() != null) {
				catchException(result.getException(), endpoint);
			}
			return result;
		} catch (RpcException e) {
			if (e.getCause() != null && e.getCause() instanceof TimeoutException) {
				catchTimeoutException(e, endpoint);
			} else {
				catchException(e, endpoint);
			}
			throw e;
		} finally {
			if (span != null) {
				long end = System.currentTimeMillis();
				invokerAfter(invocation, endpoint, span, end, isConsumerSide);// 调用后记录annotation
			}
		}
	}

	private void catchTimeoutException(RpcException e, Endpoint endpoint) {
		BinaryAnnotation exAnnotation = new BinaryAnnotation();
		exAnnotation.setKey(TracerUtils.EXCEPTION);
		exAnnotation.setValue(e.getMessage());
		exAnnotation.setType("exTimeout");
		exAnnotation.setHost(endpoint);
		tracer.addBinaryAnntation(exAnnotation);
	}

	private void catchException(Throwable e, Endpoint endpoint) {
		BinaryAnnotation exAnnotation = new BinaryAnnotation();
		exAnnotation.setKey(TracerUtils.EXCEPTION);
		exAnnotation.setValue(e.getMessage());
		exAnnotation.setType("ex");
		exAnnotation.setHost(endpoint);
		tracer.addBinaryAnntation(exAnnotation);
	}

	private void setAttachment(Span span, RpcInvocation invocation) {
		if (span.isSample()) {
			invocation.setAttachment(TracerUtils.PID, span.getParentId() != null ? String.valueOf(span.getParentId()) : null);
			invocation.setAttachment(TracerUtils.SID, span.getId() != null ? String.valueOf(span.getId()) : null);
			invocation.setAttachment(TracerUtils.TID, span.getTraceId() != null ? String.valueOf(span.getTraceId()) : null);
		}
	}

	private void invokerAfter(Invocation invocation, Endpoint endpoint, Span span, long end, boolean isConsumerSide) {
		if (isConsumerSide && span.isSample()) {
			tracer.clientReceiveRecord(span, endpoint, end);
		} else {
			if (span.isSample()) {
				tracer.serverSendRecord(span, endpoint, end);
			}
			tracer.removeParentSpan();
		}
	}

	private void invokerBefore(Invocation invocation, Span span, Endpoint endpoint, long start) {
		RpcContext context = RpcContext.getContext();
		if (context.isConsumerSide() && span.isSample()) {
			tracer.clientSendRecord(span, endpoint, start);
		} else if (context.isProviderSide()) {
			if (span.isSample()) {
				tracer.serverReceiveRecord(span, endpoint, start);
			}
			tracer.setParentSpan(span);
		}
	}

	// setter
	public void setTracer(Tracer tracer) {
		this.tracer = tracer;
	}

	/* 加载Filter的时候加载somero配置上下文 */
	static {
		try {
			logger.info("Somero filter is loading somero-config file...");
			String resourceName = "classpath*:somero-config.xml";
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { resourceName });
			logger.info("Somero config context is starting,config file path is:" + resourceName);
			context.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}