package com.jzx.bda.somero.benchmark.exp1.support;

import org.springframework.beans.factory.InitializingBean;

import com.jzx.bda.somero.service.inter.InterfaceA;

public class Trigger implements InitializingBean {
	@Override
	public void afterPropertiesSet() throws InterruptedException {
		Thread.sleep(200);// 服务预热
	}

	/**
	 *
	 * @param num
	 *            调用次数
	 * @param sleepTime
	 *            每次调用后沉默时间
	 */
	public void startWorkWithSleep(int num, long sleepTime) {
		for (int i = 0; i < num; i++) {
			try {
				Object result = rootService.functionA();
				System.out.println("result:" + result);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// getter and setter
	private InterfaceA rootService;

	public void setRootService(InterfaceA rootService) {
		this.rootService = rootService;
	}

}
