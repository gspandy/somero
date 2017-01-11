package com.jzx.bda.somero.mysql.persistent.entity;

public class Trace {

	private Integer id;
	private Long time;
	private Long traceId;
	private Integer duration;
	private String service;

	// 查询用
	private String annValue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Long getTraceId() {
		return traceId;
	}

	public void setTraceId(Long traceId) {
		this.traceId = traceId;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getAnnValue() {
		return annValue;
	}

	public void setAnnValue(String annValue) {
		this.annValue = annValue;
	}
}
