package com.jzx.bda.somero.mysql.persistent.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.jzx.bda.somero.mysql.persistent.dao.ServiceMapper;
import com.jzx.bda.somero.mysql.persistent.entity.ServicePara;

public class ServiceMapperImpl implements ServiceMapper {
	private SqlSessionTemplate sqlSession;

	@Override
	public void addService(ServicePara servicePara) {
		sqlSession.insert("addService", servicePara);
	}

	@Override
	public ServicePara getService(String name, Integer appId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("appId", appId);
		return (ServicePara) sqlSession.selectOne("getServiceByName", map);
	}

	@Override
	public void deleteService(ServicePara servicePara) {
		sqlSession.delete("deleteService", servicePara);
	}

	@Override
	public void updateService(ServicePara servicePara) {
		sqlSession.update("updateService", servicePara);
	}

	@Override
	public ServicePara getOneService(String id) {
		return (ServicePara) sqlSession.selectOne("getServiceById", id);
	}

	@Override
	public void deleteAll() {
		sqlSession.delete("deleteAllService");
	}

	@Override
	public List<ServicePara> get(Integer appId) {
		return sqlSession.selectList("getServiceByAppId", appId);
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

}
