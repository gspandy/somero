package com.jzx.bda.somero.mysql.persistent.dao;

import java.util.List;

import com.jzx.bda.somero.mysql.persistent.entity.ServicePara;

public interface ServiceMapper {
	/*
	 * 新增加一个应用,返回值为主键 ID 操作失败，返回null
	 */
	void addService(ServicePara servicePara);

	// 根据name查找ServicePara
	ServicePara getService(String name, Integer appId);

	/* 删除一个应用 */
	void deleteService(ServicePara servicePara);

	/* 更新应用信息 */
	void updateService(ServicePara servicePara);

	/*
	 * 获得一个应用实体， 操作失败或数据库没有相应数据，返回null
	 */
	ServicePara getOneService(String id);

	// 删除所有
	void deleteAll();

	// 根据appId查找
	List<ServicePara> get(Integer appId);
}
