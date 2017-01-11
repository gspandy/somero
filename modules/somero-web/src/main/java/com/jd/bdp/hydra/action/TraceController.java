package com.jd.bdp.hydra.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jzx.bda.somero.mysql.util.DateUtils;
import com.jzx.bda.somero.store.domain.TraceData;
import com.jzx.bda.somero.store.domain.base.DataGrid;
import com.jzx.bda.somero.store.inter.QueryService;

@Controller("trace")
@RequestMapping("/trace")
public class TraceController {

	@RequestMapping("/getTraceDataGrid")
	@ResponseBody
	public Object getTraceDataGrid(TraceData traceData) {
		DataGrid dataGrid = new DataGrid();
		try {
			traceData.setStartTime(String.valueOf(DateUtils.parse(traceData.getStartTime(), DateUtils.yyyy_MM_dd_HH_mm_EN).getTime()));
			traceData.setEndTime(String.valueOf(DateUtils.parse(traceData.getEndTime(), DateUtils.yyyy_MM_dd_HH_mm_EN).getTime()));
			dataGrid.setRows(queryService.getTracesByDuration(traceData));
			dataGrid.setTotal(queryService.getTracesByDurationCount(traceData));
		} catch (Exception e) {
			e.printStackTrace();
			return dataGrid;
		}
		return dataGrid;
	}

	@RequestMapping("/list/ex/{serviceId}/{startTime}/{sum}")
	@ResponseBody
	public JSONArray getTraces(@PathVariable String serviceId, @PathVariable long startTime, @PathVariable int sum) {
		try {
			return queryService.getTracesByEx(serviceId, startTime, sum);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/getTraceInfo")
	@ResponseBody
	public JSONObject getTrace(String traceId) {
		try {
			return queryService.getTraceInfo(Long.parseLong(traceId));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Autowired
	private QueryService queryService;
}
