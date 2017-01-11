package com.jzx.bda.somero.agent;

import java.util.List;

/**
 * dubbo注册服务接口
 */
public interface RegisterService {
	public boolean registerService(String name, List<String> services);

	/* 更新注册信息 */
	boolean registerService(String appName, String serviceName);
}
