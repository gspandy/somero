package com.jzx.bda.somero.service.impl;

import com.jzx.bda.somero.service.impl.support.AbstractService;
import com.jzx.bda.somero.service.inter.InterfaceA;
import com.jzx.bda.somero.service.inter.InterfaceB;

public class ServiceA extends AbstractService implements InterfaceA {
	/**
	 * 绑定一个配置文件 ，用于启动服务
	 * 
	 * @return
	 */
	protected String[] getConfigLocations() {
		String[] location = { "classpath*:dubbo-service-A.xml" };
		return location;
	}

	@Override
	public Object functionA(Object... objects) {
		String myVoice = "A";
		String result = "";
		if (downService != null && downService instanceof InterfaceB) {
			result = ((InterfaceB) downService).functionB(objects, myVoice).toString();
		}
		return myVoice + "--------->" + result;
	}

}
