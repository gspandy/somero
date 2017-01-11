package com.jzx.bda.somero.mysql.persistent.dao;

import java.util.List;

import com.jzx.bda.somero.mysql.persistent.entity.AppPara;

public interface AppMapper {
	/* 新增加一个应用 */
	void addApp(AppPara appPara);

	// 根据name查找AppPara
	AppPara getApp(String name);

	/* 删除一个应用 */
	void deleteApp(AppPara appPara);

	/* 更新应用信息 */
	void updateApp(AppPara appPara);

	/* 获得一个应用实体 */
	AppPara getOneApp(Integer id);

	// 删除所有
	void deleteAll();

	// 获得所有
	List<AppPara> getAll();
}
