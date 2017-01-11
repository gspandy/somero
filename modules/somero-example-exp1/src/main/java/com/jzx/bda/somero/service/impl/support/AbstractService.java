package com.jzx.bda.somero.service.impl.support;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jzx.bda.somero.service.inter.support.Service;

public abstract class AbstractService implements Service {
	ClassPathXmlApplicationContext context;// 服务Spring上下文
	protected Service downService;// 下游服务

	/**
	 * 获取spring上下文，集中处理
	 *
	 * @return 返回要加载的spring上下文文件位置
	 */
	protected abstract String[] getConfigLocations();

	/**
	 * 开启服务
	 */
	public void startUp(Object... args) throws Exception {
		String[] configs = getConfigLocations();
		context = new ClassPathXmlApplicationContext(configs);
		context.start();
	}

	/**
	 * 关闭服务
	 */
	public void shutDown(Object... args) throws Exception {
		context.stop();
	}

	// getter and setter
	public Service getDownService() {
		return downService;
	}

	public void setDownService(Service downService) {
		this.downService = downService;
	}
}
