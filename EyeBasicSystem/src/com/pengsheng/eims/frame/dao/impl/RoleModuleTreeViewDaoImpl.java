package com.pengsheng.eims.frame.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.frame.dao.RoleModuleTreeViewDao;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class RoleModuleTreeViewDaoImpl extends BaseJdbcDaoSupport implements
		RoleModuleTreeViewDao {

	public int getRolesWithApplication(String personID, String applicationID) {
		StringBuffer buffer = new StringBuffer();
		buffer
				.append(" select count(*) from sys_personroles where personid = '"
						+ Utility.getName(personID)
						+ "' and moduleApplicationid = '"
						+ Utility.getName(applicationID) + "'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	public List<ModulePo> getChildModules(String applicationID,
			String parentModuleID, PersonInfoPo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select * from ( ");
		buffer.append("select applicationID,sys_module.moduleID,moduleCname, moduleDirectory,");
		buffer.append(" moduleicon,moduleOrderLevel from sys_rolepermission ");
		buffer.append(" inner join sys_module on sys_module.moduleID = ");
		buffer.append(" sys_rolepermission.moduleID and ");
		buffer.append(" sys_module.moduleParentID = ?");
		buffer.append(" where pageKey = 1 and roleID =(select roleID from sys_personroles ");
		buffer.append(" where  personID = ? and moduleApplicationID=?) and departmentType like '%' + ? + '%' and (isnull(setVisitDateFlag,'0') = '0' or isnull(setVisitDateFlag,'') = '') and companyType like '%' + ? + '%'  ");
		
		if(!"".equals(Utility.getName(po.getSyspsupplierid()))){
			buffer.append(" and SYS_M_IsSupplier = '1'  ");
		}
		
		buffer.append("group by applicationID,sys_module.moduleID,moduleCname,  ");
		buffer.append(" moduleDirectory, moduleicon,moduleOrderLevel ");
		buffer.append(" union all ");
		buffer.append("select applicationID,sys_module.moduleID,moduleCname, moduleDirectory,");
		buffer.append(" moduleicon,moduleOrderLevel from sys_rolepermission ");
		buffer.append(" inner join sys_module on sys_module.moduleID = ");
		buffer.append(" sys_rolepermission.moduleID and ");
		buffer.append(" sys_module.moduleParentID = ?");
		buffer.append(" where pageKey = 1 and roleID =(select roleID from sys_personroles ");
		buffer.append(" where  personID = ? and moduleApplicationID=?) and departmentType like '%' + ? + '%' and isnull(setVisitDateFlag,'0') = '1'  and companyType like '%' + ? + '%'  ");
		buffer.append("  and ((isnull(bgnVisitDate,'') <> '' and bgnVisitDate <= substring(convert(varchar(16),getdate(),120),12,5)) or isnull(bgnVisitDate,'') = '') ");
		buffer.append("  and ((isnull(endVisitDate,'') <> '' and endVisitDate >= substring(convert(varchar(16),getdate(),120),12,5)) or isnull(endVisitDate,'') = '') ");
		
		if(!"".equals(Utility.getName(po.getSyspsupplierid()))){
			buffer.append(" and SYS_M_IsSupplier = '1'  ");
		}
		
		buffer.append("group by applicationID,sys_module.moduleID,moduleCname,  ");
		buffer.append(" moduleDirectory, moduleicon,moduleOrderLevel");	
		buffer.append(" )t order by moduleOrderLevel ");

		params.add(parentModuleID);
		params.add(Utility.getName(po.getId()));
		params.add(applicationID);
		params.add(Utility.getName(po.getDepartmenttype()));	
		params.add(Utility.getName(po.getPersoncompanytype()));
		
		params.add(parentModuleID);
		params.add(Utility.getName(po.getId()));
		params.add(applicationID);
		params.add(Utility.getName(po.getDepartmenttype()));
		params.add(Utility.getName(po.getPersoncompanytype()));

		return queryForObjectList(buffer.toString(), params.toArray(),ModulePo.class);
	}

	public List<ModulePo> getRootModules(String applicationID) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("select moduleID ");
		buffer.append(",moduleApplicationID ");
		buffer.append(",moduleParentID ");
		buffer.append(",modulePageCode ");
		buffer.append(",moduleCname ");
		buffer.append(",moduleDirectory ");
		buffer.append(",moduleOrderLevel ");
		buffer.append(",moduleIsSystem ");
		buffer.append(",moduleClose ");
		buffer.append(",moduleIcon ");
		buffer.append(",isUpdate from sys_module where moduleParentID = '0' and moduleApplicationID = ?");
		buffer.append(" order by moduleOrderLevel");

		return queryForObjectList(buffer.toString(),
				new String[] { applicationID }, ModulePo.class);
	}

	public List<ModulePo> getChildProjectModules(String applicationID,
			String parentModuleID, String personID, String projectID) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("select applicationID,sys_module.moduleID,moduleCname, moduleDirectory,");
		buffer.append(" pageValue,pageKey from sys_rolepermission ");
		buffer.append(" inner join sys_module on sys_module.moduleID = ");
		buffer.append(" sys_rolepermission.moduleID and ");
		buffer.append(" sys_module.moduleParentID = ?");
		buffer.append(" where pageKey = 1 and roleID IN (select roleID from pro_projectperson ");

		buffer.append(" where  personID = ? and projectID = ? and moduleApplicationID = ?) ");
		buffer.append(" group by applicationID, sys_module.moduleID, moduleCname ");
		buffer.append(" order by moduleOrderLevel");

		List<String> params = new ArrayList<String>();
		params.add(parentModuleID);
		params.add(personID);
		params.add(projectID);
		params.add(applicationID);

		return queryForObjectList(buffer.toString(), params.toArray(),
				ModulePo.class);
	}

}
