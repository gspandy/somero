package com.jzx.bda.somero.benchmark.exp1;

import com.jzx.bda.somero.service.impl.ServiceC;

public class StartC {
	public static void main(String[] args) throws Exception {
		new ServiceC().startUp(args);
		Thread.sleep(Long.MAX_VALUE);
	}
}
