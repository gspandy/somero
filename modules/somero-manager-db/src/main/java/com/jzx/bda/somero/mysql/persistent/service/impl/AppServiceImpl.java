package com.jzx.bda.somero.mysql.persistent.service.impl;

import java.util.List;

import com.jzx.bda.somero.mysql.persistent.dao.AppMapper;
import com.jzx.bda.somero.mysql.persistent.entity.AppPara;
import com.jzx.bda.somero.mysql.persistent.service.AppService;

public class AppServiceImpl implements AppService {

	@Override
	public synchronized Integer getAppId(String appName) {
		AppPara app = appMapper.getApp(appName);
		if (app == null) {
			app = new AppPara();
			app.setName(appName);
			appMapper.addApp(app);
			return app.getId();
		} else {
			return app.getId();
		}
	}

	@Override
	public List<AppPara> getAll() {
		return appMapper.getAll();
	}

	private AppMapper appMapper;

	public void setAppMapper(AppMapper appMapper) {
		this.appMapper = appMapper;
	}
}
