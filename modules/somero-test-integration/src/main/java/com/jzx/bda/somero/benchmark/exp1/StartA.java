package com.jzx.bda.somero.benchmark.exp1;

import com.jzx.bda.somero.service.impl.ServiceA;

public class StartA {
	public static void main(String[] args) throws Exception {
		new ServiceA().startUp(args);
		Thread.sleep(Long.MAX_VALUE);
	}
}
