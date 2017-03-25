package com.pengsheng.weixin.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinRegisterDepartmentDao;
import com.pengsheng.weixin.persistence.WeiXinRegisterDepartmentPo;

public class WeiXinRegisterDepartmentDaoImpl extends BaseJdbcDaoSupport implements WeiXinRegisterDepartmentDao{

	public void deleteWeiXinRegisterDepartment(WeiXinRegisterDepartmentPo po) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("DELETE FROM W_RegisterDepartment ");
		sb.append("WHERE  W_RD_ID = '"+ Utility.getName(po.getWrdid()) +"' ");
		
		getJdbcTemplate().update(sb.toString());
	}

	public void insertWeiXinRegisterDepartment(WeiXinRegisterDepartmentPo po) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("INSERT INTO W_RegisterDepartment ");
		sb.append("            (W_RD_ID, ");
		sb.append("             W_RD_Account, ");
		sb.append("             W_RD_DepartmentID, ");
		sb.append("             W_CR_AppId, ");
		sb.append("             W_CR_AppSecret) ");
		sb.append("VALUES      ('"+ this.uuid.generate() +"', ");
		sb.append("             '"+ Utility.getName(po.getWrdaccount()) +"', ");
		sb.append("             '"+ Utility.getName(po.getWrddepartmentid()) +"',");
		sb.append("             '"+ Utility.getName(po.getWrdappid()) +"',");
		sb.append("             '"+ Utility.getName(po.getWrdappsecret()) +"')");
		
		getJdbcTemplate().update(sb.toString());
	}

	public int selectWeiXinRegisterDepartmentCount(WeiXinRegisterDepartmentPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT COUNT(W_RD_ID) ");
		sb.append("FROM   W_RegisterDepartment ");
		sb.append("WHERE  1 = 1 ");
		
		if(!"".equals(Utility.getName(po.getWrdaccount()))) {
			sb.append("       AND W_RD_Account like '%' + ?+'%' ");
			params.add(Utility.getName(po.getWrdaccount()));
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	public List<WeiXinRegisterDepartmentPo> selectWeiXinRegisterDepartments(
			WeiXinRegisterDepartmentPo po, int start, int size) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		
		sb.append("SET ROWCOUNT " + countPage + " ");
		
		sb.append("SELECT * ");
		sb.append("FROM   (SELECT Row_number() OVER(ORDER BY W_RD_ID) AS rownum, ");
		sb.append("               W_RD_ID                             AS wrdid, ");
		sb.append("               W_RD_Account                        AS wrdaccount, ");
		sb.append("               W_RD_DepartmentID                   AS wrddepartmentid, ");
		sb.append("               B_DP_DepartmentName                 AS wrddepartmentname, ");
		sb.append("               B_DP_FullName                    	  AS wrdcompanyname, ");
		sb.append("               W_CR_AppId                 		  AS wrdappid, ");
		sb.append("               W_CR_AppSecret                	  AS wrdappsecret ");
		sb.append("        FROM   W_RegisterDepartment ");
		sb.append("        left join B_Departments on W_RD_DepartmentID = B_DP_DepartmentID ");
		sb.append("        WHERE  1 = 1 ");
		
		if(!"".equals(Utility.getName(po.getWrdaccount()))) {
			sb.append("       AND W_RD_Account like '%' + ?+'%' ");
			params.add(Utility.getName(po.getWrdaccount()));
		}
		
		sb.append(") t1 WHERE rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" SET ROWCOUNT 0 ");
		
		return queryForObjectList(sb.toString(), params.toArray(), WeiXinRegisterDepartmentPo.class);
	}
	
	public List<WeiXinRegisterDepartmentPo> selectWeiXinRegisterDepartments() {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("SELECT 		  W_RD_ID                             AS wrdid, ");
		sb.append("               B_DP_FullName                    	  AS wrdcompanyname ");

		sb.append("        FROM   W_RegisterDepartment ");
		sb.append("        left join B_Departments on W_RD_DepartmentID = B_DP_DepartmentID ");
		sb.append("        WHERE  1 = 1 ");
		
		return queryForObjectList(sb.toString(), params.toArray(), WeiXinRegisterDepartmentPo.class);
	}

	public void updateWeiXinRegisterDepartment(WeiXinRegisterDepartmentPo po) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("UPDATE W_RegisterDepartment ");
		sb.append("SET    W_RD_Account = '"+ Utility.getName(po.getWrdaccount()) +"', ");
		sb.append("       W_RD_DepartmentID = '"+ Utility.getName(po.getWrddepartmentid()) +"', ");
		sb.append("       W_CR_AppId = '"+ Utility.getName(po.getWrdappid()) +"', ");
		sb.append("       W_CR_AppSecret = '"+ Utility.getName(po.getWrdappsecret()) +"' ");
		sb.append("WHERE  W_RD_ID = '"+ Utility.getName(po.getWrdid()) +"' ");
		
		getJdbcTemplate().update(sb.toString());
	}

	public WeiXinRegisterDepartmentPo getWeiXinRegisterDepartmentPo(WeiXinRegisterDepartmentPo po) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT top 1 ");
		sb.append("               W_RD_ID                             AS wrdid, ");
		sb.append("               W_RD_Account                        AS wrdaccount, ");
		sb.append("               W_RD_DepartmentID                   AS wrddepartmentid, ");
		sb.append("               B_DP_DepartmentName                 AS wrddepartmentname, ");
		sb.append("               B_DP_FullName                       AS wrdcompanyname, ");
		sb.append("               B_DP_LocationX+','+B_DP_LocationY   AS wrdcompanyxy, ");
		sb.append("               W_CR_AppId   						  AS wrdappid, ");
		sb.append("               W_CR_AppSecret   					  AS wrdappsecret ");
		
		sb.append("       FROM   W_RegisterDepartment ");
		sb.append("       left join B_Departments on W_RD_DepartmentID = B_DP_DepartmentID ");
		sb.append("       WHERE  1 = 1 ");
		
		if(!"".equals(Utility.getName(po.getWrdid()))) {
			sb.append("       AND W_RD_ID=? ");
			params.add(Utility.getName(po.getWrdid()));
		}
		
		if(!"".equals(Utility.getName(po.getWrdaccount()))) {
			sb.append("       AND W_RD_Account =? ");
			params.add(Utility.getName(po.getWrdaccount()));
		}
		
		return (WeiXinRegisterDepartmentPo) queryForObject(sb.toString(), params.toArray(), WeiXinRegisterDepartmentPo.class);
	}	
}
