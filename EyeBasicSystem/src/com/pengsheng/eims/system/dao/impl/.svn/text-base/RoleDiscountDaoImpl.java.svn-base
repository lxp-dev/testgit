package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.system.dao.RoleDiscountDao;
import com.pengsheng.eims.system.persistence.DiscountShortcutKeysDetailsPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonRolesPo;
import com.pengsheng.eims.system.persistence.RoleDiscountDetailsPo;
import com.pengsheng.eims.system.persistence.RoleDiscountPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;


public class RoleDiscountDaoImpl extends BaseJdbcDaoSupport implements RoleDiscountDao {

	public int getRoleDiscountCount(RoleDiscountPo po) {
		
		StringBuffer sb=new StringBuffer();		
		sb.append("select count(SYS_Roles.roleID) from SYS_Roles left join F_RoleDiscount on SYS_Roles.roleID=F_RoleDiscount.F_RD_RoleID where 1=1");
		if(!"".equals(Utility.getName(po.getFrdroleid()))){
			sb.append(" and SYS_Roles.roleID='"+po.getFrdroleid()+"'");
		}		
		if(!"".equals(Utility.getName(po.getBegprice()))){
			sb.append(" and cast(F_RD_Discount as float) >= '"+po.getBegprice()+"'");
		}
		if(!"".equals(Utility.getName(po.getEndprice()))){
			sb.append(" and cast(F_RD_Discount as float) <= '"+po.getEndprice()+"'");
		}		
		if (!"".equals(Utility.getName(po.getFrdcompanyid()))){
			sb.append(" and companyID = '"+po.getFrdcompanyid()+"'");
		}
		
		return getJdbcTemplate().queryForInt(sb.toString());
	}
	
	public List<RoleDiscountPo> getRoleDiscountList(RoleDiscountPo po,
			int start, int size) {

		StringBuffer sb=new StringBuffer();		
		sb.append("select temp.roleID as frdroleid,temp.roleName as frdroleName,temp.F_RD_Discount as frddiscount ");
		sb.append(" from(select ROW_NUMBER() Over(order by SYS_Roles.roleID) as rowNum,* ");
		sb.append(" from SYS_Roles left join F_RoleDiscount on SYS_Roles.roleID=F_RoleDiscount.F_RD_RoleID where 1=1");
		if(!"".equals(Utility.getName(po.getFrdroleid()))){
			sb.append(" and SYS_Roles.roleID='"+po.getFrdroleid()+"'");
		}
		if(!"".equals(Utility.getName(po.getBegprice()))){
			sb.append(" and cast(F_RD_Discount as float) >= '"+po.getBegprice()+"'");
		}
		if(!"".equals(Utility.getName(po.getEndprice()))){
			sb.append(" and cast(F_RD_Discount as float) <= '"+po.getEndprice()+"'");
		}
		if (!"".equals(Utility.getName(po.getFrdcompanyid()))){
			sb.append(" and companyID = '"+po.getFrdcompanyid()+"'");
		}
		sb.append(" ) temp where rowNum > "+start+" and rowNum <= "+ (start + size));
		return queryForObjectList(sb.toString(), null, RoleDiscountPo.class);
	}
	
	public List<RolePo> getRoleList(RoleDiscountPo po) {
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select roleID as roleid,roleName as rolename from SYS_Roles where 1 = 1 ");
		
		if (!"".equals(Utility.getName(po.getFrdcompanyid()))){
			sb.append(" and companyID = ? ");
			params.add(Utility.getName(po.getFrdcompanyid()));
		}

		return queryForObjectList(sb.toString(), params.toArray(), RolePo.class);
	}
	
	public RoleDiscountPo getRoleDiscount(RoleDiscountPo po) {
		
		String sql="select top 1  SYS_Roles.roleID as frdroleid,SYS_Roles.roleName as frdroleName,F_RoleDiscount.F_RD_Discount as frddiscount" +
				" from SYS_Roles left join F_RoleDiscount on SYS_Roles.roleID=F_RoleDiscount.F_RD_RoleID where SYS_Roles.roleID='"+po.getFrdroleid()+"'";
		return (RoleDiscountPo)queryForObject(sql, null, RoleDiscountPo.class);
	}
	
	public void insertRoleDiscount(RoleDiscountPo po) {
		
		String sql="insert into F_RoleDiscount(F_RD_RoleID,F_RD_Discount)values('"+po.getFrdroleid()+"','"+po.getFrddiscount()+"')";
		getJdbcTemplate().update(sql);		
	}
	
	public void updateRoleDiscount(RoleDiscountPo po) {
		
		String sql="update F_RoleDiscount set F_RD_RoleID='"+po.getFrdroleid()+"',F_RD_Discount='"+po.getFrddiscount()+"' where F_RD_RoleID='"+po.getFrdroleid()+"'";
		getJdbcTemplate().update(sql);
	}
	
	public RoleDiscountPo getRoleDiscountDetail(RoleDiscountPo po) {
		
		String sql="select top 1  F_RoleDiscount.F_RD_RoleID as frdroleid,F_RoleDiscount.F_RD_Discount as frddiscount from F_RoleDiscount where F_RoleDiscount.F_RD_RoleID='"+po.getFrdroleid()+"'";
        
		return (RoleDiscountPo)queryForObject(sql, null, RoleDiscountPo.class);
	}
	
	public List<PersonRolesPo> getPersonForRole(String roleID) {
		
		String sql="select personID as personID from SYS_PersonRoles where roleID='"+roleID+"' and moduleApplicationID='1'";
		
		return queryForObjectList(sql, null, PersonRolesPo.class);
	}
	
	public List<PersonInfoPo> getPersonInfoByRole(RoleDiscountPo po) {
		StringBuffer  sb = new StringBuffer();
		sb.append(" SELECT personID AS id ");
		sb.append(" FROM   SYS_PersonRoles ");
		sb.append(" WHERE  roleID = ? ");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getFrdroleid());
		
		return queryForObjectList(sb.toString(), params.toArray(), PersonInfoPo.class);
	}
	
	public void insertRoleDiscountDetails(RoleDiscountDetailsPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into F_RoleDiscountDetails (");
		buffer.append(" F_RDD_UUID, ");
		buffer.append(" F_RDD_RoleID, ");
		buffer.append(" F_RDD_GoodsLevel, ");
		buffer.append(" F_RDD_Discount ");
		buffer.append(" )values( ");
		buffer.append(" ?, ");
		buffer.append(" ?, ");
		buffer.append(" ?, ");
		buffer.append(" ? ");
		buffer.append(" ) ");
		
		params.add(this.uuid.generate());
		params.add(po.getFrddroleid());
		params.add(po.getFrddgoodslevel());
		params.add(po.getFrdddiscount());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public List<RoleDiscountDetailsPo> selectRoleDiscountDetails(RoleDiscountDetailsPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select ");
		buffer.append("	F_RDD_UUID 					as frdduuid, ");
		buffer.append(" F_RDD_RoleID				as frddroleid, ");
		buffer.append(" F_RDD_GoodsLevel			as frddgoodslevel, ");
		buffer.append(" B_GL_Name					as frddgoodslevelname, ");
		buffer.append(" F_RDD_Discount				as frdddiscount ");
		buffer.append(" from F_RoleDiscountDetails ");
		buffer.append(" left join B_GoodsLevel on F_RDD_GoodsLevel = B_GL_UUID");
		buffer.append(" where F_RDD_RoleID = ? ");
		
		params.add(po.getFrddroleid());

		return queryForObjectList(buffer.toString(), params.toArray(),RoleDiscountDetailsPo.class);
	}
	
	public void deleteRoleDiscountDetails(String pid) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" delete from F_RoleDiscountDetails ");
		buffer.append(" where F_RDD_RoleID = ? ");
		
		params.add(pid);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}
