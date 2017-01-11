package com.jzx.bda.somero.mysql.persistent.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.jzx.bda.somero.mysql.persistent.dao.AppMapper;
import com.jzx.bda.somero.mysql.persistent.entity.AppPara;

public class AppMapperImpl implements AppMapper {
	private SqlSessionTemplate sqlSession;

	@Override
	public void addApp(AppPara servicePara) {
		sqlSession.insert("addApp", servicePara);
	}

	@Override
	public AppPara getApp(String name) {
		return (AppPara) sqlSession.selectOne("getAppByName", name);
	}

	@Override
	public void deleteApp(AppPara servicePara) {
		sqlSession.delete("deleteApp", servicePara);
	}

	@Override
	public void updateApp(AppPara servicePara) {
		sqlSession.update("updateApp", servicePara);
	}

	@Override
	public AppPara getOneApp(Integer id) {
		return (AppPara) sqlSession.selectOne("getAppById", id);
	}

	@Override
	public void deleteAll() {
		sqlSession.delete("deleteAllApp");
	}

	@Override
	public List<AppPara> getAll() {
		return sqlSession.selectList("getAppAll");
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

}
