package com.pengsheng.eims.basic.dao;

import java.util.List;
import com.pengsheng.eims.basic.persistence.ReminderWindowPo;


/**
 * 提醒窗口管理Dao
 * @author moyongsheng 2014 11 14
 *
 */
public interface ReminderWindowDao {

	/**
	 * 查询所有提醒信息List<ReminderWindowPo>；
	 */
	public List<ReminderWindowPo> getAllReminderWindows();
	
	/**
	 * 查询某部门类型和角色，取交集能访问的提醒信息List<ReminderWindowPo>；
	 * @param String departmenttypeid: 部门类型ID;String roleid: 角色ID;
	 */
	public List<ReminderWindowPo> getJiaojiReminderWindowsByDepartmenttypeidAndRoleid(String departmenttypeid,String roleid);
	
	/**
	 * 查询某部门类型能访问的提醒信息List<ReminderWindowPo>；
	 * @param String departmenttypeid; 部门类型ID
	 */
	public List<ReminderWindowPo> getReminderWindowsByDepartmenttypeid(String departmenttypeid);
	
	/**
	 * 查询某角色能访问的提醒信息List<ReminderWindowPo>；
	 * @param String roleid; 角色ID
	 */
	public List<ReminderWindowPo> getReminderWindowsByRoleid(String roleid);
	
	/**
	 * 查询提醒信息PO<ReminderWindowPo>；
	 * @param String id; 提醒信息ID
	 */
	public ReminderWindowPo getRemainderWindowByid(String id);	

	/**
	 * 更新提醒信息PO<ReminderWindowPo>；
	 * @param ReminderWindowPo reminderWindowPo; 提醒信息PO
	 */
	public void updateReminderWindow(ReminderWindowPo reminderWindowPo);
}
