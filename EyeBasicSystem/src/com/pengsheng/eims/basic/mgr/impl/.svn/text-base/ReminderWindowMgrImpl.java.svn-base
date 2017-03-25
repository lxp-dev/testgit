package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.ReminderWindowDao;
import com.pengsheng.eims.basic.mgr.ReminderWindowMgr;
import com.pengsheng.eims.basic.persistence.ReminderWindowPo;

public class ReminderWindowMgrImpl implements ReminderWindowMgr{
	
	private ReminderWindowDao reminderWindowDao;
	
	/**
	 * 查询所有提醒信息List<ReminderWindowPo>；
	 */
	public List<ReminderWindowPo> getAllReminderWindows(){
		return reminderWindowDao.getAllReminderWindows();
	}
	
	/**
	 * 查询某部门类型和角色，取交集能访问的提醒信息List<ReminderWindowPo>；
	 * @param String departmenttypeid: 部门类型ID;String roleid: 角色ID;
	 */
	public List<ReminderWindowPo> getJiaojiReminderWindowsByDepartmenttypeidAndRoleid(String departmenttypeid,String roleid){
		return reminderWindowDao.getJiaojiReminderWindowsByDepartmenttypeidAndRoleid(departmenttypeid,roleid);
	}
	
	/**
	 * 查询某部门类型能访问的提醒信息List<ReminderWindowPo>；
	 * @param String departmenttypeid; 部门类型ID
	 */
	public List<ReminderWindowPo> getReminderWindowsByDepartmenttypeid(String departmenttypeid){
		return reminderWindowDao.getReminderWindowsByDepartmenttypeid(departmenttypeid);
	}
	
	/**
	 * 查询某角色能访问的提醒信息List<ReminderWindowPo>；
	 * @param String roleid; 角色ID
	 */
	public List<ReminderWindowPo> getReminderWindowsByRoleid(String roleid){
		return reminderWindowDao.getReminderWindowsByRoleid(roleid);
	}
	
	/**
	 * 查询提醒信息PO<ReminderWindowPo>；
	 * @param String id; 提醒信息ID
	 */
	
	/**
	 * 更新提醒信息PO<ReminderWindowPo>；
	 * @param ReminderWindowPo reminderWindowPo; 提醒信息PO
	 */
	public void updateReminderWindow(ReminderWindowPo reminderWindowPo){
		reminderWindowDao.updateReminderWindow(reminderWindowPo);
	}
	
	public ReminderWindowPo getRemainderWindowByid(String id){
		return reminderWindowDao.getRemainderWindowByid(id);
	}	

	public ReminderWindowDao getReminderWindowDao() {
		return reminderWindowDao;
	}

	public void setReminderWindowDao(ReminderWindowDao reminderWindowDao) {
		this.reminderWindowDao = reminderWindowDao;
	}
}
