package com.jzx.bda.somero.mysql.persistent.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.jzx.bda.somero.mysql.persistent.dao.ServiceIdGenMapper;
import com.jzx.bda.somero.mysql.persistent.entity.ServiceIdGen;

public class ServiceIdGenMapperImpl implements ServiceIdGenMapper {

	@Override
	public void updateServiceIdGen(ServiceIdGen serviceIdGen) {
		sqlSession.update("updateServiceIdGen", serviceIdGen);
	}

	@Override
	public ServiceIdGen getServiceIdGen() {
		return (ServiceIdGen) sqlSession.selectOne("getServiceIdGen");
	}

	private SqlSessionTemplate sqlSession;

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
}
