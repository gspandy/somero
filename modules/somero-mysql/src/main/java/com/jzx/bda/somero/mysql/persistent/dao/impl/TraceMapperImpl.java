package com.jzx.bda.somero.mysql.persistent.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.jzx.bda.somero.mysql.persistent.dao.TraceMapper;
import com.jzx.bda.somero.mysql.persistent.entity.Trace;

public class TraceMapperImpl implements TraceMapper {

	@Override
	public List<Trace> findTraces(String serviceId, Long startTime, int num) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startTime", startTime);
		map.put("num", num);
		map.put("serviceId", serviceId);
		return sqlSession.selectList("findTraces", map);
	}

	@Override
	public List<Trace> findTracesByDuration(String serviceId, Long startTime, int durationMin, int durationMax, int num) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("serviceId", serviceId);
		map.put("startTime", startTime);
		map.put("num", num);
		map.put("durationMin", durationMin);
		map.put("durationMax", durationMax);
		return sqlSession.selectList("findTracesByDuration", map);
	}

	@Override
	public List<Trace> findTracesEx(String serviceId, Long startTime, int num) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startTime", startTime);
		map.put("num", num);
		map.put("serviceId", serviceId);
		return sqlSession.selectList("findTracesEx", map);
	}

	public void addTrace(Trace t) {
		sqlSession.insert("addTrace", t);
	}

	@Override
	public void deleteAllTraces() {
		sqlSession.delete("deleteAllTraces");
	}

	private SqlSessionTemplate sqlSession;

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Trace> queryTracesByDuration(Map map) {
		return sqlSession.selectList("queryTracesByDuration", map);
	}

	@Override
	public int queryTracesByDurationCount(Map map) {
		return sqlSession.selectOne("queryTracesByDurationCount", map);
	}
}
