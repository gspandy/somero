package com.jzx.bda.somero.mysql.persistent.dao;

import java.util.List;
import java.util.Map;

import com.jzx.bda.somero.mysql.persistent.entity.Trace;

public interface TraceMapper {

	List<Trace> findTraces(String serviceId, Long startTime, int num);

	List<Trace> findTracesByDuration(String serviceId, Long startTime, int durationMin, int durationMax, int num);

	List<Trace> findTracesEx(String serviceId, Long startTime, int num);

	public void addTrace(Trace t);

	void deleteAllTraces();// 只用于测试

	public List<Trace> queryTracesByDuration(Map map);

	public int queryTracesByDurationCount(Map map);

}
