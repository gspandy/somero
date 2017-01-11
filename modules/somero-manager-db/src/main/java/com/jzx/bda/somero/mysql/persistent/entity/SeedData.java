package com.jzx.bda.somero.mysql.persistent.entity;

import java.io.Serializable;

public class SeedData implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer value;

	// getter and setter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof SeedData))
			return false;

		SeedData seedData = (SeedData) o;

		if (!id.equals(seedData.id))
			return false;
		if (!value.equals(seedData.value))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + value.hashCode();
		return result;
	}
}
