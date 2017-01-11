package com.jzx.bda.somero.mysql.persistent.dao;

import com.jzx.bda.somero.mysql.persistent.entity.SeedData;

public interface SeedMapper {
	/* 判定是否有该种子值 */
	public boolean hasSeed(Integer value) throws Exception;

	/* 获取数据库中最大的种子值，返回最大的种子值 */
	public Integer getMaxSeedValue() throws Exception;

	// --------------------------------------//

	/* 新增加一个种子 */
	public void addSeed(SeedData seedData) throws Exception;

	/* 删除一个种子 */
	public void deleteSeed(SeedData seedData) throws Exception;

	/* 更新种子信息 */
	public void updateSeed(SeedData seedData) throws Exception;

	/* 获得一个种子实体 */
	public SeedData getOneSeed(Integer id) throws Exception;

	// ---* 版本2的种子逻辑-数据库中只存一行数据（即Max_VALUE）*-----------------------------
	public SeedData findTheSeed() throws Exception;

}
