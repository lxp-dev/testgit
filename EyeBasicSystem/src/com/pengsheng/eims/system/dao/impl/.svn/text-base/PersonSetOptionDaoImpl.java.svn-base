package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.system.dao.PersonSetOptionDao;
import com.pengsheng.eims.system.persistence.PersonSetOptionPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class PersonSetOptionDaoImpl extends BaseJdbcDaoSupport implements PersonSetOptionDao {
	/**
	 * 查询个人登录参数设置<PersonSetOptionPo>；
	 * * @param String personId; 员工ID
	 */
	public PersonSetOptionPo selectPersonSetOptionPo(String personId){
		StringBuffer  buffer = new StringBuffer();
		List<String>  params = new ArrayList<String>();
		buffer.append("SELECT F_PSO_ID     AS fpsoid, ");
		buffer.append("       F_PSO_PersonId AS fpsopersonid, ");
		buffer.append("       F_PSO_HideTop  AS fpsohidetop, ");
		buffer.append("       F_PSO_ReminderWindowId  AS fpsoreminderwindowid, ");
		buffer.append("       isnull(F_PSO_DivFrameType,'1')  AS fpsodivframetype ");
		buffer.append("FROM   F_PersonSetOption ");
		buffer.append("WHERE  F_PSO_PersonId = ? ");
		
		params.add(Utility.getName(personId));
		
		return (PersonSetOptionPo) queryForObject(buffer.toString(), params.toArray(), PersonSetOptionPo.class);
	}
	
	/**
	 * 插入个人登录参数设置;
	 * * @param PersonSetOptionPo personSetOptionPo; 个人登录参数设置PO
	 */
	public void insertPersonSetOptionPo(PersonSetOptionPo personSetOptionPo){
		StringBuffer  buffer = new StringBuffer();
		List<String>  params = new ArrayList<String>();
		
		buffer.append("INSERT INTO F_PersonSetOption ");
		buffer.append("            (F_PSO_ID, ");
		buffer.append("             F_PSO_PersonId, ");
		buffer.append("             F_PSO_HideTop, ");
		buffer.append("             F_PSO_DivFrameType, ");
		buffer.append("             F_PSO_ReminderWindowId) ");
		buffer.append("VALUES     (?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(personSetOptionPo.getFpsopersonid()));
		params.add(Utility.getName(personSetOptionPo.getFpsohidetop()));
		if(Utility.getName(personSetOptionPo.getFpsodivframetype()).equals("")){
			personSetOptionPo.setFpsodivframetype("0");
		}
		params.add(Utility.getName(personSetOptionPo.getFpsodivframetype()));
		params.add(Utility.getName(personSetOptionPo.getFpsoreminderwindowid()));
			
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除个人登录参数设置;
	 * * @param String personId; 员工ID
	 */
	public void deletePersonSetOptionPo(String personId){
		StringBuffer  buffer = new StringBuffer();
		List<String>  params = new ArrayList<String>();
		
		buffer.append("delete from F_PersonSetOption ");
		buffer.append("where F_PSO_PersonId = ? ");
		
		params.add(Utility.getName(personId));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}
