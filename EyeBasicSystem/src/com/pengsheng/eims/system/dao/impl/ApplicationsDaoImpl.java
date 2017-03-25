package com.pengsheng.eims.system.dao.impl;

import java.util.List;

import com.pengsheng.eims.system.dao.ApplicationsDao;
import com.pengsheng.eims.system.persistence.ApplicationsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class ApplicationsDaoImpl extends BaseJdbcDaoSupport implements
		ApplicationsDao {

	public List<ApplicationsPo> getSysApplicationsList() {

		String sqlString = "select * from  SYS_Applications";
		return queryForObjectList(sqlString, null, ApplicationsPo.class);
	}

	public ApplicationsPo getSysApplications(
			ApplicationsPo whereSysApplicationsPo) {
		StringBuffer buffer = new StringBuffer(
				"select top 1  * from  SYS_Applications where 1=1");

		if (whereSysApplicationsPo != null
				&& !whereSysApplicationsPo.getApplicationID().equals("")) {
			buffer.append(" and applicationID='"
					+ whereSysApplicationsPo.getApplicationID() + "'");
		}

		ApplicationsPo returnSysApplicationsPo = (ApplicationsPo) queryForObject(
				buffer.toString(), null, ApplicationsPo.class);
		return returnSysApplicationsPo;
	}

	public void insertSysApplications(ApplicationsPo sysApplicationsPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO SYS_Applications");
		buffer.append(" (applicationID");
		buffer.append(" ,applicationAppName");
		buffer.append(" ,applicationAppDescription");
		buffer.append(" ,applicationAppUrl)");
		buffer.append("      VALUES");
		buffer.append(" ('" + this.uuid.generate() + "'");
		buffer.append(" ,'" + sysApplicationsPo.getApplicationAppName() + "'");
		buffer.append(" ,'" + sysApplicationsPo.getApplicationAppDescription()
				+ "'");
		buffer.append(" ,'" + sysApplicationsPo.getApplicationAppUrl() + "')");

		getJdbcTemplate().update(buffer.toString());
	}

	public void updateSysApplications(ApplicationsPo sysApplicationsPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update SYS_Applications set");
		buffer.append(" applicationAppName='"
				+ sysApplicationsPo.getApplicationAppName() + "'");
		buffer.append(" ,applicationAppDescription='"
				+ sysApplicationsPo.getApplicationAppDescription() + "'");
		buffer.append(" ,applicationAppUrl='"
				+ sysApplicationsPo.getApplicationAppUrl() + "'");
		buffer.append("      where applicationID='"
				+ sysApplicationsPo.getApplicationID() + "'");
		// System.out.println(buffer.toString());
		getJdbcTemplate().update(buffer.toString());
	}

	public void deleteSysApplications(ApplicationsPo sysApplicationsPo) {
		String sqlString = "delete from SYS_Applications  where applicationID='"
				+ sysApplicationsPo.getApplicationID() + "'";
		// System.out.println(sqlString);
		getJdbcTemplate().execute(sqlString);
	}

}