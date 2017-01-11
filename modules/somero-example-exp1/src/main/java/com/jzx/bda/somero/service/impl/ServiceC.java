package com.jzx.bda.somero.service.impl;

import com.jzx.bda.somero.service.impl.support.AbstractService;
import com.jzx.bda.somero.service.inter.InterfaceC;

public class ServiceC extends AbstractService implements InterfaceC {
	/**
	 * 绑定一个配置文件 ，用于启动服务
	 * 
	 * @return
	 */
	protected String[] getConfigLocations() {
		String[] location = { "classpath*:dubbo-service-C.xml" };
		return location;
	}

	@Override
	public Object functionC(Object... objects) {
		return "C";
	}
}
