package com.jzx.bda.somero.mysql.persistent.service;

import java.util.List;

import com.jzx.bda.somero.mysql.persistent.entity.AppPara;

public interface AppService {

	Integer getAppId(String appName);

	List<AppPara> getAll();
}
