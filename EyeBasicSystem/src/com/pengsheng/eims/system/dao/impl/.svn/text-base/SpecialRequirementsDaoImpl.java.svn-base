package com.pengsheng.eims.system.dao.impl;

import java.util.List;

import com.pengsheng.eims.sales.persistence.SalesSpecialPo;
import com.pengsheng.eims.system.dao.SpecialRequirementsDao;
import com.pengsheng.eims.system.persistence.AdditionalCostsPo;
import com.pengsheng.eims.system.persistence.SpecialRequirementsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class SpecialRequirementsDaoImpl extends BaseJdbcDaoSupport implements SpecialRequirementsDao {

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 特殊加工要求数量
	 */
	public int getSpecialRequirementsCount(SpecialRequirementsPo po){
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(F_SR_ID)");
		buffer.append("   from F_SpecialRequirements");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 特殊加工要求结果集
	 */
	public List getSpecialRequirementsList(SpecialRequirementsPo po,int start, int size){
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by F_SR_ID) as rowNum");
		buffer.append(" ,F_SR_ID as fsrid");
		buffer.append(" ,F_SR_Name as fsrname");
//		buffer.append(" ,F_SR_Flag as fsrflag");
		buffer.append(" from F_SpecialRequirements ");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,
				SpecialRequirementsPo.class);
	}
	
	/**
	 * 得到所有加工要求
	 * 
	 * @param 
	 * @return List 
	 */
	public List<SpecialRequirementsPo> getSpecialRequirementsList(){
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select ");
		buffer.append(" F_SR_ID as fsrid");
		buffer.append(" ,F_SR_Name as fsrname");
//		buffer.append(" ,F_SR_Flag as fsrflag");
		buffer.append(" from F_SpecialRequirements ");
		return this.queryForObjectList(buffer.toString(), null,
				SpecialRequirementsPo.class);
	}
	
	/**
	 * 得到所有特殊加工要求
	 * 
	 * @param 
	 * @return List 
	 */
	public List<SalesSpecialPo> getSpecialRequirements1List(String status){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(" select ");
		buffer.append(" PROD_CD as prodcd");
		buffer.append(" ,PROD_LOCAL as prodlocal");
		buffer.append(" from B_ProdInfo ");
		if(("R".equals(status))||("L".equals(status))){
			status="D";
		}else if("P".equals(status)){
			status="P";
		}
		buffer.append(" where PROD_STSTUS = '"+status+"' ");
		
		return this.queryForObjectList(buffer.toString(), null,
				SalesSpecialPo.class);
	}

	/**
	 * 查询特殊加工要求的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 特殊加工要求详细信息
	 */
	public SpecialRequirementsPo getSpecialRequirementsPo(SpecialRequirementsPo po){
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select top 1 ");
		buffer.append("  F_SR_ID as fsrid");
		buffer.append(" ,F_SR_Name as fsrname");
		buffer.append(" from F_SpecialRequirements ");
		buffer.append(" where F_SR_ID = '"+Utility.getName(po.getFsrid())+"'");
		return (SpecialRequirementsPo) queryForObject(buffer.toString(), null, SpecialRequirementsPo.class);
	}
	
	/**
	 * 查询特殊加工要求ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getSpecialRequirementsId(SpecialRequirementsPo po){
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(F_SR_ID)");
		buffer.append("   from F_SpecialRequirements where F_SR_ID = '"+Utility.getName(po.getFsrid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	/**
	 * 添加时查询特殊加工要求名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getSpecialRequirementsName(SpecialRequirementsPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(F_SR_ID)");
		buffer.append("   from F_SpecialRequirements where F_SR_Name = '"+Utility.getName(po.getFsrname())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	/**
	 * 修改时查询特殊加工要求名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getSpecialRequirementsNameUpdate(SpecialRequirementsPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(F_SR_ID)");
		buffer.append("   from F_SpecialRequirements where F_SR_Name = '"+Utility.getName(po.getFsrname())+"' and F_SR_ID <> '"+Utility.getName(po.getFsrid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	
	/**
	 * 查询特殊加工要求在   表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getTSpecialRequirementsWithGoods(SpecialRequirementsPo po){
		return 0;
	}
	
	
	/**
	 * 新增特殊加工要求
	 * 
	 * @param po 特殊加工要求po
	 * @return void
	 */
	public void insertSpecialRequirements(SpecialRequirementsPo po){
		StringBuffer buffer = new StringBuffer();
		buffer.append(" insert into F_SpecialRequirements");
		buffer.append("            (F_SR_ID");
		buffer.append("            ,F_SR_Name)");
		buffer.append("      values");
		buffer.append("            ('"+Utility.getName(po.getFsrid())+"'");
		buffer.append("            ,'"+Utility.getName(po.getFsrname())+"')");
		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 * 修改特殊加工要求
	 * 
	 * @param po 特殊加工要求po
	 * @return void
	 */
	public void updateSpecialRequirements(SpecialRequirementsPo po){
		StringBuffer buffer = new StringBuffer();
		buffer.append(" update F_SpecialRequirements");
		buffer.append("    set");
		buffer.append("        F_SR_Name = '"+Utility.getName(po.getFsrname())+"'");
		buffer.append("  where F_SR_ID = '"+Utility.getName(po.getFsrid())+"'");
		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 * 删除特殊加工要求
	 * 
	 * @param po 特殊加工要求po
	 * @return void
	 */
	public void deleteSpecialRequirements(SpecialRequirementsPo po){
		StringBuffer buffer = new StringBuffer();
		buffer.append(" delete from F_SpecialRequirements where F_SR_ID = '"+Utility.getName(po.getFsrid())+"'");
		getJdbcTemplate().update(buffer.toString());
	}

}
