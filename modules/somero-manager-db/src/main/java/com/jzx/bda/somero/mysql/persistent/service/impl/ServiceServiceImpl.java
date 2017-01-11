package com.jzx.bda.somero.mysql.persistent.service.impl;

import java.util.List;

import com.jzx.bda.somero.mysql.persistent.dao.AppMapper;
import com.jzx.bda.somero.mysql.persistent.dao.ServiceMapper;
import com.jzx.bda.somero.mysql.persistent.entity.AppPara;
import com.jzx.bda.somero.mysql.persistent.entity.ServicePara;
import com.jzx.bda.somero.mysql.persistent.service.ServiceIdGenService;
import com.jzx.bda.somero.mysql.persistent.service.ServiceService;

public class ServiceServiceImpl implements ServiceService {

	@Override
	public synchronized String getServiceId(String serviceName, String appName) {
		AppPara appPara = appMapper.getApp(appName);
		if (appPara == null) {
			throw new RuntimeException("在获取service标识之前不可能没有对应的App!");
		} else {
			ServicePara service = serviceMapper.getService(serviceName, appPara.getId());
			if (service == null) {
				service = new ServicePara();
				service.setId(serviceIdGenService.getNewServiceId());
				service.setName(serviceName);
				service.setAppId(appPara.getId());
				serviceMapper.addService(service);
				return service.getId();
			} else {
				return service.getId();
			}
		}
	}

	@Override
	public List<ServicePara> get(Integer appId) {
		return serviceMapper.get(appId);
	}

	private ServiceMapper serviceMapper;
	private AppMapper appMapper;
	private ServiceIdGenService serviceIdGenService;

	public void setServiceMapper(ServiceMapper serviceMapper) {
		this.serviceMapper = serviceMapper;
	}

	public void setAppMapper(AppMapper appMapper) {
		this.appMapper = appMapper;
	}

	public void setServiceIdGenService(ServiceIdGenService serviceIdGenService) {
		this.serviceIdGenService = serviceIdGenService;
	}
}
