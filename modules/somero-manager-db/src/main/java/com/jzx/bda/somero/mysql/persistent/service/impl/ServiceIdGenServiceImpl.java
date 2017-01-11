package com.jzx.bda.somero.mysql.persistent.service.impl;

import com.jzx.bda.somero.mysql.persistent.dao.ServiceIdGenMapper;
import com.jzx.bda.somero.mysql.persistent.entity.ServiceIdGen;
import com.jzx.bda.somero.mysql.persistent.service.ServiceIdGenService;

public class ServiceIdGenServiceImpl implements ServiceIdGenService {

	@Override
	public synchronized String getNewServiceId() {
		ServiceIdGen serviceIdGen = serviceIdGenMapper.getServiceIdGen();
		int newTrueId;
		if (serviceIdGen.getMaxId() == serviceIdGen.getIdScope() - 1) {
			newTrueId = 0;
		} else {
			newTrueId = serviceIdGen.getMaxId() + 1;
		}
		int oldHeadId = serviceIdGen.getHead();
		int newHeadId;
		if (oldHeadId == serviceIdGen.getMaxHead()) {
			newHeadId = 1;
		} else {
			newHeadId = oldHeadId + 1;
		}
		int serviceId = newHeadId * serviceIdGen.getIdScope() + newTrueId;
		serviceIdGen.setHead(newHeadId);
		serviceIdGen.setMaxId(newTrueId);
		serviceIdGenMapper.updateServiceIdGen(serviceIdGen);
		int fullLength = String.valueOf(serviceIdGen.getMaxHead() * serviceIdGen.getIdScope()).length();
		if (String.valueOf(serviceId).length() < fullLength) {
			return "0" + String.valueOf(serviceId);// 只限head为2位的
		} else {
			return String.valueOf(serviceId);
		}
	}

	private ServiceIdGenMapper serviceIdGenMapper;

	public void setServiceIdGenMapper(ServiceIdGenMapper serviceIdGenMapper) {
		this.serviceIdGenMapper = serviceIdGenMapper;
	}

}
