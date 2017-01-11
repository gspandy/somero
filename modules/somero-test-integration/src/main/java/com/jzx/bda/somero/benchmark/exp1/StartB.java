package com.jzx.bda.somero.benchmark.exp1;

import com.jzx.bda.somero.service.impl.ServiceB;

public class StartB {
	public static void main(String[] args) throws Exception {
		new ServiceB().startUp(args);
		Thread.sleep(Long.MAX_VALUE);
	}
}
