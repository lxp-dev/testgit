package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.system.dao.AdditionalCostsDao;
import com.pengsheng.eims.system.persistence.AdditionalCostsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class AdditionalCostsDaoImpl extends BaseJdbcDaoSupport implements AdditionalCostsDao {

	/**
	 * 删除附加费用
	 * 
	 * @param po 附加费用po
	 * @return void
	 */
	public void deleteAdditionalCosts(AdditionalCostsPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" delete from F_AdditionalCosts where F_AC_ID = '"+Utility.getName(po.getFacid())+"'");
		getJdbcTemplate().update(buffer.toString());
	}

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 附加费用数量
	 */
	public int getAdditionalCostsCount(AdditionalCostsPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(F_AC_ID)");
		buffer.append("   from F_AdditionalCosts");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	
	/**
	 * 查询附加费用ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getAdditionalCostsId(AdditionalCostsPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(F_AC_ID)");
		buffer.append("   from F_AdditionalCosts where F_AC_ID = '"+Utility.getName(po.getFacid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	/**
	 * 添加时查询附加费用名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getAdditionalCostsName(AdditionalCostsPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count(F_AC_ID)");
		buffer.append("   from F_AdditionalCosts where F_AC_Name = ? ");
		params.add(Utility.getName(po.getFacname()));
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	/**
	 * 修改时查询附加费用名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getAdditionalCostsNameUpdate(AdditionalCostsPo po)
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count(F_AC_ID)");
		buffer.append("   from F_AdditionalCosts where F_AC_Name = ? and F_AC_ID <> ? ");
		params.add(Utility.getName(po.getFacname()));
		params.add(Utility.getName(po.getFacid()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	
	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 附加费用数量
	 */
	public List getAdditionalCostsList(AdditionalCostsPo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by f_ac_id) as rowNum");
		buffer.append(" ,f_ac_id as facid");
		buffer.append(" ,f_ac_name as facname");
		buffer.append(" ,f_ac_amount as facamount");
		buffer.append(" ,F_AC_SupplierID as facsupplierid");
		buffer.append(" ,B_SP_SupplierName as facsuppliername");
		buffer.append(" from F_AdditionalCosts ");
		buffer.append(" left join B_Supplier on F_AC_SupplierID = B_SP_ID ");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,
				AdditionalCostsPo.class);
	}

	/**
	 * 查询附加费用的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 附加费用详细信息
	 */
	public AdditionalCostsPo getAdditionalCostsPo(AdditionalCostsPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select top 1 ");
		buffer.append("  f_ac_id as facid");
		buffer.append(" ,f_ac_name as facname");
		buffer.append(" ,f_ac_amount as facamount");
		buffer.append(" ,F_AC_SupplierID as facsupplierid");
		buffer.append(" ,B_SP_SupplierName as facsuppliername");
		buffer.append(" ,F_AC_PayFeeID as facpayfeeid");
		buffer.append(" from F_AdditionalCosts ");
		buffer.append(" left join B_Supplier on F_AC_SupplierID = B_SP_ID ");
		buffer.append(" where f_ac_id = '"+Utility.getName(po.getFacid())+"'");
		return (AdditionalCostsPo) queryForObject(buffer.toString(), null, AdditionalCostsPo.class);
	}

	/**
	 * 查询附加费用在   表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getTAdditionalCostsWithGoods(AdditionalCostsPo po) {
		return 0;
	}

	/**
	 * 新增附加费用
	 * 
	 * @param po 附加费用po
	 * @return void
	 */
	public void insertAdditionalCosts(AdditionalCostsPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" insert into f_additionalcosts");
		buffer.append("            (f_ac_id");
		buffer.append("            ,f_ac_name");
		buffer.append("            ,f_ac_amount");
		buffer.append("            ,F_AC_SupplierID");
		buffer.append("            ,F_AC_PayFeeID)");
		buffer.append("      values");
		buffer.append("            (? ");
		buffer.append("            ,? ");
		buffer.append("            ,? ");
		buffer.append("            ,? ");
		buffer.append("            ,?) ");

		params.add(Utility.getName(po.getFacid()));
		params.add(Utility.getName(po.getFacname()));
		params.add(Utility.getName(po.getFacamount()));
		params.add(Utility.getName(po.getFacsupplierid()));
		params.add(Utility.getName(po.getFacpayfeeid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 修改附加费用
	 * 
	 * @param po 附加费用po
	 * @return void
	 */
	public void updateAdditionalCosts(AdditionalCostsPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" update f_additionalcosts");
		buffer.append("    set");
		buffer.append("        f_ac_name = ? ");
		buffer.append("      ,f_ac_amount = ? ");
		buffer.append("      ,F_AC_SupplierID = ? ");
		buffer.append("      ,F_AC_PayFeeID = ? ");
		buffer.append("  where f_ac_id = ? ");
		params.add(Utility.getName(po.getFacname()));
		params.add(Utility.getName(po.getFacamount()));
		params.add(Utility.getName(po.getFacsupplierid()));
		params.add(Utility.getName(po.getFacpayfeeid()));
		params.add(Utility.getName(po.getFacid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public List<AdditionalCostsPo> getAdditionalCostsList() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select ");
		buffer.append(" f_ac_id as facid");
		buffer.append(" ,f_ac_name as facname");
		buffer.append(" ,f_ac_amount as facamount");
		buffer.append(" ,F_AC_SupplierID as facsupplierid");
		buffer.append(" ,B_SP_SupplierName as facsuppliername");
		buffer.append(" from F_AdditionalCosts ");
		buffer.append(" left join B_Supplier on F_AC_SupplierID = B_SP_ID ");
		return this.queryForObjectList(buffer.toString(), null,
				AdditionalCostsPo.class);
	}
	
	public List<AdditionalCostsPo> getAdditionalCostsListForAjax(String[] supplierids) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select ");
		buffer.append(" f_ac_id as facid");
		buffer.append(" ,f_ac_name as facname");
		buffer.append(" ,f_ac_amount as facamount");
		buffer.append(" ,F_AC_SupplierID as facsupplierid");
		buffer.append(" ,B_SP_SupplierName as facsuppliername");
		buffer.append(" from F_AdditionalCosts ");
		buffer.append(" left join B_Supplier on F_AC_SupplierID = B_SP_ID ");
		
		buffer.append(" WHERE 1=1 ");
		buffer.append("   and (F_AC_SupplierID in ( ");
		for(int i=0; i<supplierids.length; i++){
			buffer.append("?,");
			params.add(supplierids[i]);
		}
		StringBuffer buffer1 = new StringBuffer();
		buffer1.append(buffer.substring(0, buffer.length()-1));
		buffer1.append(")");
		buffer1.append("or isnull(F_AC_SupplierID,'') = '' )");
		return this.queryForObjectList(buffer1.toString(), params.toArray(),
				AdditionalCostsPo.class);
	}
}
