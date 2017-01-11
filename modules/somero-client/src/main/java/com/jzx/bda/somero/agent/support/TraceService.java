package com.jzx.bda.somero.agent.support;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jzx.bda.somero.Span;
import com.jzx.bda.somero.agent.CollectorService;
import com.jzx.bda.somero.agent.RegisterService;
import com.jzx.bda.somero.dubbomonitor.LeaderService;
import com.jzx.bda.somero.dubbomonitor.SomeroService;

public class TraceService implements RegisterService, CollectorService {

	private static final Logger logger = LoggerFactory.getLogger(TraceService.class);

	private LeaderService leaderService;
	private SomeroService someroService;
	private Map<String, String> registerInfo;
	public static final String APP_NAME = "applicationName";
	public static final String SEED = "seed";
	private boolean isRegister = false;

	public boolean isRegister() {
		return isRegister;
	}

	@Override
	public void sendSpan(List<Span> spanList) {
		// fixme try-catch性能影响？
		try {
			someroService.push(spanList);
		} catch (Exception e) {
			logger.warn("Trace data push failure~");
		}
	}

	@Override
	public boolean registerService(String name, List<String> services) {
		try {
			this.registerInfo = leaderService.registerClient(name, services);
		} catch (Exception e) {
			logger.warn("[Somero] Client global config-info cannot regist into the somero system");
		}
		if (registerInfo != null) {
			logger.info("[Somero] Global registry option is ok!");
			isRegister = true;
		}
		return isRegister;
	}

	/* 更新注册信息 */
	@Override
	public boolean registerService(String appName, String serviceName) {
		logger.info(appName + " " + serviceName);
		String serviceId = null;
		try {
			serviceId = leaderService.registerClient(appName, serviceName);
		} catch (Exception e) {
			logger.warn("[Somero] client cannot regist service <" + serviceName + "> into the somero system");
		}
		if (serviceId != null) {
			logger.info("[Somero] Registry [" + serviceName + "] option is ok!");
			registerInfo.put(serviceName, serviceId); // 更新本地注册信息
			return true;
		} else
			return false;
	}

	public LeaderService getLeaderService() {
		return leaderService;
	}

	public void setLeaderService(LeaderService leaderService) {
		this.leaderService = leaderService;
	}

	public SomeroService getSomeroService() {
		return someroService;
	}

	public void setSomeroService(SomeroService someroService) {
		this.someroService = someroService;
	}

	public String getServiceId(String service) {
		if (isRegister && registerInfo.containsKey(service))
			return registerInfo.get(service);
		else
			return null;
	}

	public Long getSeed() {
		String s = null;
		if (isRegister) {
			s = registerInfo.get(SEED);
			return Long.valueOf(s);
		}
		return null;
	}
}
