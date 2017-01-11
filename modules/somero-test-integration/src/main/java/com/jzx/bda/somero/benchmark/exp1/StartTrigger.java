package com.jzx.bda.somero.benchmark.exp1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jzx.bda.somero.benchmark.exp1.support.Trigger;

public class StartTrigger {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext(new String[] { "classpath*:exp1-trigger-context.xml" });
			context.start();
			Trigger trigger = (Trigger) context.getBean("trigger");
			trigger.startWorkWithSleep(30, 500);
		} catch (Exception e) {
			e.printStackTrace();
			context.stop();
		}

	}
}
