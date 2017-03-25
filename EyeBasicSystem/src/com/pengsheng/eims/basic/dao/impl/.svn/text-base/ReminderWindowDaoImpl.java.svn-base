package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.pengsheng.eims.basic.dao.ReminderWindowDao;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.ReminderWindowPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * 提醒窗口管理DaoImpl
 * @author moyongsheng 2014 11 14
 *
 */
public class ReminderWindowDaoImpl extends BaseJdbcDaoSupport implements ReminderWindowDao {
	
	/**
	 * 查询所有提醒信息List<ReminderWindowPo>；
	 */
	public List<ReminderWindowPo> getAllReminderWindows(){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
				
		buffer.append("SELECT F_RWS_ID               AS frwsid, ");
		buffer.append("       F_RWS_Name             AS frwsname, ");
		buffer.append("       F_RWS_Content          AS frwscontent, ");
		buffer.append("       F_RWS_Moudleid         AS frwsmoudleid, ");
		buffer.append("       F_RWS_Departmenttypeid AS frwsdepartmenttypeid, ");
		buffer.append("       F_RWS_Roleid           AS frwsroleid, ");
		buffer.append("       F_RWS_Ischecked        AS frwsischecked ");
		buffer.append("FROM   F_ReminderWindow ");

		return queryForObjectList(buffer.toString(), params.toArray(), ReminderWindowPo.class);
	}
	
	/**
	 * 查询某部门类型和角色，取交集能访问的提醒信息List<ReminderWindowPo>；
	 * @param String departmenttypeid: 部门类型ID;String roleid: 角色ID;
	 */
	public List<ReminderWindowPo> getJiaojiReminderWindowsByDepartmenttypeidAndRoleid(String departmenttypeid,String roleid){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
				
		buffer.append("SELECT F_RWS_ID               AS frwsid, ");
		buffer.append("       F_RWS_Name             AS frwsname, ");
		buffer.append("       F_RWS_Content          AS frwscontent, ");
		buffer.append("       F_RWS_Moudleid         AS frwsmoudleid, ");
		buffer.append("       F_RWS_Departmenttypeid AS frwsdepartmenttypeid, ");
		buffer.append("       F_RWS_Roleid           AS frwsroleid, ");
		buffer.append("       F_RWS_Ischecked        AS frwsischecked ");
		buffer.append("FROM   F_ReminderWindow ");
		buffer.append("WHERE  F_RWS_ID IN(SELECT frwsid ");
		buffer.append("                   FROM   (SELECT F_RWS_ID AS frwsid ");
		buffer.append("                           FROM   F_ReminderWindow ");
		buffer.append("                           WHERE  ( '%,' + F_RWS_Departmenttypeid + ',%' LIKE '%,' + ? + ',%' ) ");
		buffer.append("                           UNION ALL ");
		buffer.append("                           SELECT F_RWS_ID AS frwsid ");
		buffer.append("                           FROM   F_ReminderWindow AS F_ReminderWindow_1 ");
		buffer.append("                           WHERE  ( '%,' + F_RWS_Roleid + ',%' LIKE '%,' + ? + ',%' ) ");
		buffer.append("                                   OR ( Isnull(F_RWS_Roleid, '') = '' ))t ");
		buffer.append("                   GROUP  BY frwsid ");
		buffer.append("                   HAVING COUNT(frwsid) > 1) ");
		
		params.add(Utility.getName(departmenttypeid));
		params.add(Utility.getName(roleid));

		return queryForObjectList(buffer.toString(), params.toArray(), ReminderWindowPo.class);
	}
	
	/**
	 * 查询某部门类型能访问的提醒信息List<ReminderWindowPo>；
	 * @param String departmenttypeid; 部门类型ID
	 */
	public List<ReminderWindowPo> getReminderWindowsByDepartmenttypeid(String departmenttypeid){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
				
		buffer.append("SELECT F_RWS_ID               AS frwsid, ");
		buffer.append("       F_RWS_Name             AS frwsname, ");
		buffer.append("       F_RWS_Content          AS frwscontent, ");
		buffer.append("       F_RWS_Moudleid         AS frwsmoudleid, ");
		buffer.append("       F_RWS_Departmenttypeid AS frwsdepartmenttypeid, ");
		buffer.append("       F_RWS_Roleid           AS frwsroleid, ");
		buffer.append("       F_RWS_Ischecked        AS frwsischecked ");
		buffer.append("FROM   F_ReminderWindow ");
		
		buffer.append("WHERE ('%,' + F_RWS_Departmenttypeid + ',%') LIKE ('%,' + ? + ',%')");
		
		params.add(Utility.getName(departmenttypeid));

		return queryForObjectList(buffer.toString(), params.toArray(), ReminderWindowPo.class);
	}
	
	/**
	 * 查询某角色能访问的提醒信息List<ReminderWindowPo>；
	 * @param String roleid; 角色ID
	 */
	public List<ReminderWindowPo> getReminderWindowsByRoleid(String roleid){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
				
		buffer.append("SELECT F_RWS_ID               AS frwsid, ");
		buffer.append("       F_RWS_Name             AS frwsname, ");
		buffer.append("       F_RWS_Content          AS frwscontent, ");
		buffer.append("       F_RWS_Moudleid         AS frwsmoudleid, ");
		buffer.append("       F_RWS_Departmenttypeid AS frwsdepartmenttypeid, ");
		buffer.append("       F_RWS_Roleid           AS frwsroleid, ");
		buffer.append("       F_RWS_Ischecked        AS frwsischecked ");
		buffer.append("FROM   F_ReminderWindow ");
		buffer.append("WHERE ('%,' + F_RWS_Departmenttypeid + ',%') LIKE ('%,' + ? + ',%')");
		
		params.add(Utility.getName(roleid));

		return queryForObjectList(buffer.toString(), params.toArray(), ReminderWindowPo.class);
	}
	/**
	 * 查询提醒信息PO<ReminderWindowPo>；
	 * @param String id; 提醒信息ID
	 */
	public ReminderWindowPo getRemainderWindowByid(String id){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
				
		buffer.append("SELECT F_RWS_ID               AS frwsid, ");
		buffer.append("       F_RWS_Name             AS frwsname, ");
		buffer.append("       F_RWS_Content          AS frwscontent, ");
		buffer.append("       F_RWS_Moudleid         AS frwsmoudleid, ");
		buffer.append("       isnull(F_RWS_Departmenttypeid,'') AS frwsdepartmenttypeid, ");
		buffer.append("       isnull(F_RWS_Roleid,'')           AS frwsroleid, ");
		buffer.append("       F_RWS_Ischecked        AS frwsischecked ");
		buffer.append("FROM   F_ReminderWindow ");
		buffer.append("WHERE  F_RWS_ID = ?");
		
		params.add(Utility.getName(id));
		
		return (ReminderWindowPo) queryForObject(buffer.toString(), params.toArray(),ReminderWindowPo.class);
	}	
	
	/**
	 * 更新提醒信息PO<ReminderWindowPo>；
	 * @param ReminderWindowPo reminderWindowPo; 提醒信息PO
	 */
	public void updateReminderWindow(ReminderWindowPo reminderWindowPo){
		StringBuffer buffer = new StringBuffer();

		buffer.append("update F_ReminderWindow set F_RWS_Departmenttypeid = ? , F_RWS_Roleid = ?");
		buffer.append(" where F_RWS_ID = ?");

		List<String> params = new ArrayList<String>();
		params.add(reminderWindowPo.getFrwsdepartmenttypeid());
		params.add(reminderWindowPo.getFrwsroleid());
		params.add(reminderWindowPo.getFrwsid());
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}	
}
