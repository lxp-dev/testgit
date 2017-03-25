package com.pengsheng.eims.system.dao;

import java.util.List;

import com.pengsheng.eims.system.persistence.ApplicationsPo;

public interface ApplicationsDao {

	/**
	 * 取应用列表
	 * 
	 * @return
	 */
	public List<ApplicationsPo> getSysApplicationsList();

	public ApplicationsPo getSysApplications(
			ApplicationsPo whereSysApplicationsPo);

	public void insertSysApplications(ApplicationsPo sysApplicationsPo);

	public void updateSysApplications(ApplicationsPo sysApplicationsPo);

	public void deleteSysApplications(ApplicationsPo sysApplicationsPo);
}