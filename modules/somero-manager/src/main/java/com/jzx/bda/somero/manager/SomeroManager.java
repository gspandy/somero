package com.jzx.bda.somero.manager;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SomeroManager {
	public static void main(String[] strings) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "classpath*:somero-manager.xml" });
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