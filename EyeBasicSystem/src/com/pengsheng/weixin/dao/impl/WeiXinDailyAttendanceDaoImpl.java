package com.pengsheng.weixin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinDailyAttendanceDao;
import com.pengsheng.weixin.persistence.DailyAttendance;

public class WeiXinDailyAttendanceDaoImpl extends BaseJdbcDaoSupport implements WeiXinDailyAttendanceDao {


	public DailyAttendance selectDailyAttendancePo(DailyAttendance po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT W_DA_UUID as wdauuid , ");
		buffer.append("       W_DA_Integral as wdaintegral ");
		buffer.append("FROM   W_DailyAttendance ");
		buffer.append("WHERE  1 = 1 ");
		
		return (DailyAttendance)queryForObject(buffer.toString(), params.toArray(), DailyAttendance.class);
	}
	
	public void insertDailyAttendanceLogPo(DailyAttendance po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("INSERT INTO W_DailyAttendanceLog ");
		buffer.append("            (W_DL_UUID, ");
		buffer.append("             W_DL_Integral, ");
		buffer.append("             W_DL_CreateDate, ");
		buffer.append("             W_DL_openID) ");
		buffer.append("VALUES      (?, ");
		buffer.append("             ?, ");
		buffer.append("             Getdate(), ");
		buffer.append("             ?) ");
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getWdlintegral()));
		params.add(Utility.getName(po.getWdlopenid()));
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	public void insertDailyAttendancePo(DailyAttendance po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("INSERT INTO W_DailyAttendance ");
		buffer.append("            (W_DA_UUID, ");
		buffer.append("             W_DA_Integral) ");
		buffer.append("VALUES      (?, ");
		buffer.append("             ?) ");
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getWdaintegral()));
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	public void deleteDailyAttendancePo(DailyAttendance po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("DELETE FROM W_DailyAttendance ");
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	public int getDailyAttendanceLogPo(String openId){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("SELECT COUNT(*) ");
		buffer.append("FROM   W_DailyAttendanceLog ");
		buffer.append("WHERE  W_DL_openID = ? ");
		buffer.append("       AND CONVERT(VARCHAR(10), W_DL_CreateDate, 23) = CONVERT(VARCHAR(10), Getdate(), 23) ");
		params.add(Utility.getName(openId));
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	public List<DailyAttendance> getDailyAttendanceSelectList(String openID, int start,int size){
		
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select * from ( ");
		
		sb.append("SELECT ROW_NUMBER() Over(order by W_DL_CreateDate) as rowNum,cast(W_DL_Integral as numeric(18,0)) as wdlintegral, ");
		sb.append("       W_DL_CreateDate as wdlcreatedate, ");
		sb.append("       S_ME_CI_Name as wdlopenid  ");
		sb.append("FROM   W_DailyAttendanceLog ");
		sb.append("       LEFT JOIN S_ME_CustomerInfo ");
		sb.append("         ON W_DL_openID = S_ME_CI_OpenID ");
		sb.append("WHERE  1 = 1 ");
		sb.append("       AND S_ME_CI_OpenID = ? ");
		params.add(Utility.getName(openID));
		sb.append("  ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), DailyAttendance.class);
	}
	public int getWeiXinIntegralSelectCount(String openID) {
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT count(*) ");
		sb.append("FROM   W_DailyAttendanceLog ");
		sb.append("       LEFT JOIN S_ME_CustomerInfo ");
		sb.append("         ON W_DL_openID = S_ME_CI_OpenID ");
		sb.append("WHERE  1 = 1 ");
		sb.append("       AND S_ME_CI_OpenID = ? ");
		params.add(Utility.getName(openID));
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
}
