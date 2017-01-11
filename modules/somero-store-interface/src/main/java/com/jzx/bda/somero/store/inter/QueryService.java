package com.jzx.bda.somero.store.inter;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jzx.bda.somero.store.domain.TraceData;

public interface QueryService {

	JSONArray getTracesByDuration(String serviceId, Long startTime, int sum, int durationMin, int durationMax);

	JSONArray getTracesByEx(String serviceId, Long startTime, int sum);

	JSONObject getTraceInfo(Long traceId);

	// update by 2016-06-03
	List<Object> getTracesByDuration(TraceData traceData);
	// update by 2016-06-03
	int getTracesByDurationCount(TraceData traceData);
}
