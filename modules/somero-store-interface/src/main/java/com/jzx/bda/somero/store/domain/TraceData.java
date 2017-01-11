package com.jzx.bda.somero.store.domain;

import com.jzx.bda.somero.store.domain.base.Page;

public class TraceData extends Page {
	private static final long serialVersionUID = -8561040412104876090L;
	private String serviceId;
	private String startTime;
	private String endTime;
	private Integer durationMin;
	private Integer durationMax;
	
	public TraceData(){
		
	}
	
	public TraceData(String serviceId){
		this.serviceId="010001";
		this.startTime="1463018090942";
		this.endTime="1463018319188";
		this.durationMin=0;
		this.durationMax=10000000;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getDurationMin() {
		return durationMin;
	}

	public void setDurationMin(Integer durationMin) {
		this.durationMin = durationMin;
	}

	public Integer getDurationMax() {
		return durationMax;
	}

	public void setDurationMax(Integer durationMax) {
		this.durationMax = durationMax;
	}

}
