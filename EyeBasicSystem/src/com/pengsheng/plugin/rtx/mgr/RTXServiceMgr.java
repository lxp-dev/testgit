package com.pengsheng.plugin.rtx.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface RTXServiceMgr {
	/**
	 * 得到所有部门
	 * 
	 * @return
	 */
	public List<DepartmentsPo> getDepartments();
	/**
	 * 得到所有人员
	 * 
	 * @return
	 */
	public List<PersonInfoPo> getPersons();	
	/**
	 * 得到一个部门的所有人员
	 * 
	 * @return
	 */
	public List<PersonInfoPo> getPersonsBydepartmentid(String departmentid);
	
	/**
	 * RTX集成系统登录
	 * @param personInfo
	 * @return
	 */
	public PersonInfoPo getPerson(PersonInfoPo personInfo);

}
