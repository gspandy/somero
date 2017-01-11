package com.jzx.bda.somero.collector;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SomeroCollector {
	public static void main(String[] strings) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "classpath*:dubbo-somero-provider.xml" });
		context.start();
		while (true) {
			try {
				Thread.sleep(Long.MAX_VALUE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}