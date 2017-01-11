package com.jzx.bda.somero.agent;

import com.jzx.bda.somero.Span;
import com.jzx.bda.somero.agent.support.TraceService;

/**
 * 数据一部分发送接口
 */
public interface SyncTransfer {
	public Long getTraceId();

	public Long getSpanId();

	public boolean isReady();

	public boolean isServiceReady(String serviceName);

	public void start() throws Exception;

	public String getServiceId(String name);

	public void cancel();

	public void syncSend(Span span);

	public void setTraceService(TraceService traceService);

	public String appName();

}
