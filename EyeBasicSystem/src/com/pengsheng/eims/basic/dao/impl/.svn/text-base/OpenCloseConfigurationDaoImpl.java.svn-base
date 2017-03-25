package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.OpenCloseConfigurationDao;
import com.pengsheng.eims.basic.persistence.StatusModulePo;

import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class OpenCloseConfigurationDaoImpl extends BaseJdbcDaoSupport implements
     OpenCloseConfigurationDao {


	public List<StatusModulePo> getStatusList() {

		StringBuffer buffer = new StringBuffer();
		buffer.append("select F_OCS_SettingID as fsmstatusid ");
		buffer.append(",F_OCS_StatusSetting as fsmstatuscode ");
		buffer.append(",F_OCS_StatusContent as fsmstatusremark ");
		buffer.append(" from F_OpenCloseSetting");

		return queryForObjectList(buffer.toString(), null, StatusModulePo.class);
	}

	public void updateStatusModule(StatusModulePo statusModulePo) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE F_OpenCloseSetting ");
		buffer.append("SET F_OCS_StatusSetting = ? ");
		buffer.append("WHERE F_OCS_SettingID = ?");

		List<String> params = new ArrayList<String>();

		params.add(statusModulePo.getFsmstatuscode());
		params.add(statusModulePo.getFsmstatusid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}
