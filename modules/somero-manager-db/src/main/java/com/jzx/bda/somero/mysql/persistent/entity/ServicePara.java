package com.jzx.bda.somero.mysql.persistent.entity;

import java.io.Serializable;

public class ServicePara implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private Integer appId;// 外键-->app.id

	// getter and setter

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ServicePara))
			return false;

		ServicePara that = (ServicePara) o;

		if (appId != null ? !appId.equals(that.appId) : that.appId != null)
			return false;
		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (name != null ? !name.equals(that.name) : that.name != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (appId != null ? appId.hashCode() : 0);
		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}
}
