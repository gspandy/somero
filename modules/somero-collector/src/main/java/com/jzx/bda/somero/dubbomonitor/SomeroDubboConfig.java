package com.jzx.bda.somero.dubbomonitor;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SomeroDubboConfig {
	private static final Logger logger = LoggerFactory.getLogger(SomeroDubboConfig.class);

	public static Properties loadConfig(String conf) {
		try {
			InputStream in = SomeroDubboConfig.class.getClassLoader().getResourceAsStream(conf);
			Properties p = new Properties();
			p.load(in);
			return p;
		} catch (Exception e) {
			logger.error("Can't load config file  fail : \n" + e.getStackTrace());
		}
		return null;
	}
}
