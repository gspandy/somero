package com.jzx.bda.somero.mysql.persistent.service;

import java.util.List;

import com.jzx.bda.somero.mysql.persistent.entity.ServicePara;

public interface ServiceService {
	String getServiceId(String serviceName, String appName);

	List<ServicePara> get(Integer appId);
}
