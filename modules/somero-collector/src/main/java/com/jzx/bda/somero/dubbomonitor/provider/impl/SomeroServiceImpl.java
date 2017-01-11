package com.jzx.bda.somero.dubbomonitor.provider.impl;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jzx.bda.somero.Span;
import com.jzx.bda.somero.dubbomonitor.SomeroDubboConfig;
import com.jzx.bda.somero.dubbomonitor.SomeroService;
import com.jzx.bda.somero.util.ObjectUtils;
import com.taobao.metamorphosis.Message;
import com.taobao.metamorphosis.client.MessageSessionFactory;
import com.taobao.metamorphosis.client.MetaClientConfig;
import com.taobao.metamorphosis.client.MetaMessageSessionFactory;
import com.taobao.metamorphosis.client.producer.MessageProducer;
import com.taobao.metamorphosis.client.producer.SendResult;
import com.taobao.metamorphosis.exception.MetaClientException;
import com.taobao.metamorphosis.utils.ZkUtils;

public class SomeroServiceImpl implements SomeroService {
	private static final Logger log = LoggerFactory.getLogger(SomeroServiceImpl.class);
	private MessageProducer messageProducer = null;
	private String topic;
	private final int bufferSize = 1024;
	private Properties config = loadConfig();

	private void createMessageProducer() throws Exception {
		final MetaClientConfig metaClientConfig = new MetaClientConfig();
		final ZkUtils.ZKConfig zkConfig = new ZkUtils.ZKConfig();
		// 设置zookeeper地址
		zkConfig.zkConnect = config.getProperty("metaq.zk");
		zkConfig.zkRoot = config.getProperty("metaq.zk.root");
		metaClientConfig.setZkConfig(zkConfig);

		// New session factory,强烈建议使用单例
		MessageSessionFactory sessionFactory = new MetaMessageSessionFactory(metaClientConfig);
		// create producer,强烈建议使用单例
		messageProducer = sessionFactory.createProducer();
		this.topic = config.getProperty("metaq.topic");
		messageProducer.setDefaultTopic(topic);
		// publish topic
		messageProducer.publish(topic);
	}

	private Properties loadConfig() {
		return SomeroDubboConfig.loadConfig("metaq.prop");
	}

	public SomeroServiceImpl() throws Exception {
		createMessageProducer();
	}

	@Override
	public boolean push(List<Span> span) {
		boolean rs = false;
		if (span != null) {
			byte[] b = ObjectUtils.toPBBytes(span);
			try {
				SendResult sendResult = messageProducer.sendMessage(new Message(topic, b));
				if (sendResult.isSuccess()) {
					rs = true;
				}
			} catch (MetaClientException e) {
				e.printStackTrace(); // To change body of catch statement use
										// File | Settings | File Templates.
			} catch (InterruptedException e) {
				e.printStackTrace(); // To change body of catch statement use
										// File | Settings | File Templates.
			} finally {

			}
		}
		return rs;
	}
}