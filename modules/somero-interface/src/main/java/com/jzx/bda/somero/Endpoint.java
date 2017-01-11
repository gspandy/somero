package com.jzx.bda.somero;

import java.io.Serializable;

public class Endpoint implements Serializable {
	private static final long serialVersionUID = -6250394438119880062L;
	private String ip;
	private Integer port;

	public Endpoint() {

	}

	public Endpoint(String ip, Integer port, String serviceName) {
		this.ip = ip;
		this.port = port;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "Endpoint{" + "ip='" + ip + '\'' + ", port=" + port + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Endpoint))
			return false;
		Endpoint endpoint = (Endpoint) o;
		if (!ip.equals(endpoint.ip))
			return false;
		if (!port.equals(endpoint.port))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int result = ip.hashCode();
		result = 31 * result + port.hashCode();
		return result;
	}
}
