package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.system.dao.DiscountShortcutKeysDao;
import com.pengsheng.eims.system.persistence.DiscountShortcutKeysDetailsPo;
import com.pengsheng.eims.system.persistence.DiscountShortcutKeysPo;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PersonDiscountDetailsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class DiscountShortcutKeysDaoImpl extends BaseJdbcDaoSupport implements DiscountShortcutKeysDao {
	
	public void deleteDiscountShortcutKeys(DiscountShortcutKeysPo po) {
		String sqlString = "delete from F_DiscountShortcutKeys where F_DK_ID = ? ";
		List<String> params = new ArrayList<String>();
		params.add(po.getFdkid());

		getJdbcTemplate().update(sqlString, params.toArray());
	}

	
	public DiscountShortcutKeysPo getDiscountShortcutKeysPo(DiscountShortcutKeysPo po) {
	StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if(!Utility.getName(po.getFdkgoodslevel()).equals("")){
			varname1.append("SELECT top 1 F_DK_ID       AS fdkid, ");
			varname1.append("       F_DK_KeyName      	AS fdkkeyname, ");
			varname1.append("       F_DKD_Discount    	AS fdkkeyvalues, ");
			varname1.append("       F_DK_Enable       	AS fdkenable, ");
			varname1.append("       F_DK_DiscountCode 	AS fdkdiscountcode, ");
			varname1.append("       F_DK_IsShow       	AS fdkisshow ");
			varname1.append("FROM   F_DiscountShortcutKeys ");
			varname1.append("left join F_DiscountShortcutKeysDetails on F_DKD_DiscountKeysID = F_DK_ID ");
			varname1.append("WHERE  1=1 ");
			varname1.append("  and F_DKD_GoodsLevel = ? ");
			params.add(po.getFdkgoodslevel());
		}else{
			varname1.append("SELECT top 1 F_DK_ID       AS fdkid, ");
			varname1.append("       F_DK_KeyName      	AS fdkkeyname, ");
			varname1.append("       F_DK_KeyValues    	AS fdkkeyvalues, ");
			varname1.append("       F_DK_Enable       	AS fdkenable, ");
			varname1.append("       F_DK_DiscountCode 	AS fdkdiscountcode, ");
			varname1.append("       F_DK_IsShow       	AS fdkisshow ");
			varname1.append("FROM   F_DiscountShortcutKeys ");
			varname1.append("WHERE  1=1 ");
		}
		
		if(!"".equals(Utility.getName(po.getFdkid()))){
			varname1.append("  and  F_DK_ID = ? ");
			params.add(po.getFdkid());
		}
	
		if(!"".equals(Utility.getName(po.getFdkdiscountcode()))){
			varname1.append("  and  F_DK_DiscountCode = ? ");
			params.add(po.getFdkdiscountcode());
		}
		
		return (DiscountShortcutKeysPo) queryForObject(varname1.toString(),params.toArray(), DiscountShortcutKeysPo.class);
	}
	/*
	 * 
	 * 添加时判断打折码是否重复
	 * 
	 */
	public int getShortcutKeysPoId(DiscountShortcutKeysPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( F_DK_ID )");
		buffer.append("   from F_DiscountShortcutKeys where F_DK_DiscountCode = '"+Utility.getName(po.getFdkdiscountcode())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	/*
	 * 
	 * 添加时判断快捷键名称是否重复
	 * 
	 */
	public int getShortcutKeysPoName(DiscountShortcutKeysPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( F_DK_ID )");
		buffer.append("   from F_DiscountShortcutKeys where F_DK_KeyName = '"+Utility.getName(po.getFdkkeyname())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	/*
	 * 
	 * 修改时判断打折码是否重复
	 * 
	 */
	public int getShortcutKeysPoIdUpdate(DiscountShortcutKeysPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( F_DK_ID )");
		buffer.append("   from F_DiscountShortcutKeys where F_DK_DiscountCode = '"+Utility.getName(po.getFdkdiscountcode())+"' and F_DK_ID <> '"+Utility.getName(po.getFdkid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	/*
	 * 
	 * 修改时判断快捷键名称是否重复
	 * 
	 */
	public int getShortcutKeysPoNameUpdate(DiscountShortcutKeysPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( F_DK_ID )");
		buffer.append("   from F_DiscountShortcutKeys where F_DK_KeyName = '"+Utility.getName(po.getFdkkeyname())+"' and F_DK_ID <> '"+Utility.getName(po.getFdkid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	
	
	
	
	public List<DiscountShortcutKeysPo> getDiscountShortcutKeysPoList() {
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("SELECT F_DK_ID        AS fdkid, ");
		varname1.append("       F_DK_KeyName   AS fdkkeyname, ");
		varname1.append("       F_DK_KeyValues AS fdkkeyvalues, ");
		varname1.append("       F_DK_Enable    AS fdkenable, ");
		varname1.append("       F_DK_DiscountCode AS fdkdiscountcode, ");
		varname1.append("       F_DK_IsShow    AS fdkisshow ");
		varname1.append("FROM   F_DiscountShortcutKeys ");
		
		return queryForObjectList(varname1.toString(),params.toArray(), DiscountShortcutKeysPo.class);

	}

	
	public void insertDiscountShortcutKeys(DiscountShortcutKeysPo po) {
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("INSERT INTO F_DiscountShortcutKeys ");
		varname1.append("            (F_DK_ID, ");
		varname1.append("             F_DK_KeyName, ");
		varname1.append("             F_DK_KeyValues, ");
		varname1.append("             F_DK_Enable, ");
		varname1.append("             F_DK_DiscountCode, ");
		varname1.append("             F_DK_IsShow) ");
		varname1.append("VALUES     (?, ");
		varname1.append("            ?, ");
		varname1.append("            ?, ");
		varname1.append("            ?, ");
		varname1.append("            ?, ");
		varname1.append("            ?) ");
		
		params.add(po.getFdkid());
		params.add(po.getFdkkeyname());
		params.add(po.getFdkkeyvalues());
		params.add(po.getFdkenable());
		params.add(po.getFdkdiscountcode());
		params.add(po.getFdkisshow());
		
		getJdbcTemplate().update(varname1.toString(), params.toArray());

	}

	
	public void updateDiscountShortcutKeys(DiscountShortcutKeysPo po) {
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("UPDATE F_DiscountShortcutKeys ");
		varname1.append("SET    F_DK_KeyName = ?, ");
		varname1.append("       F_DK_KeyValues = ?, ");
		varname1.append("       F_DK_Enable = ?, ");
		varname1.append("       F_DK_IsShow = ?, ");
		varname1.append("       F_DK_DiscountCode = ? ");
		varname1.append("WHERE  F_DK_ID = ? ");
		
		params.add(po.getFdkkeyname());
		params.add(po.getFdkkeyvalues());
		params.add(po.getFdkenable());
		params.add(po.getFdkisshow());
		params.add(po.getFdkdiscountcode());
		params.add(po.getFdkid());
		
		getJdbcTemplate().update(varname1.toString(), params.toArray());
	}
	
	public void updateDiscountShortcutKeysEnable(DiscountShortcutKeysPo po) {
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("UPDATE F_DiscountShortcutKeys ");
		varname1.append("SET    F_DK_Enable = ? ");
		varname1.append("WHERE  F_DK_ID = ? ");
		
		params.add(po.getFdkenable());
		params.add(po.getFdkid());
		
		getJdbcTemplate().update(varname1.toString(), params.toArray());
	}
	
	public void updateDiscountShortcutKeysIsShow(DiscountShortcutKeysPo po) {
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("UPDATE F_DiscountShortcutKeys ");
		varname1.append("SET    F_DK_IsShow = ? ");
		varname1.append("WHERE  F_DK_ID = ? ");
		
		params.add(po.getFdkisshow());
		params.add(po.getFdkid());
		
		getJdbcTemplate().update(varname1.toString(), params.toArray());
	}
	
	public List<DiscountShortcutKeysPo> getEnableDiscountShortcutKeysPoList(String isshow) {
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("SELECT F_DK_ID        AS fdkid, ");
		varname1.append("       F_DK_KeyName   AS fdkkeyname, ");
		varname1.append("       F_DK_KeyValues AS fdkkeyvalues, ");
		varname1.append("       F_DK_Enable    AS fdkenable, ");
		varname1.append("       F_DK_DiscountCode AS fdkdiscountcode, ");
		varname1.append("       F_DK_IsShow    AS fdkisshow ");
		varname1.append("FROM   F_DiscountShortcutKeys ");
		varname1.append("WHERE  F_DK_Enable = '1' ");
		
		if(!"".equals(isshow)){
			varname1.append("AND  F_DK_IsShow = '1' ");
		}
		
		return queryForObjectList(varname1.toString(),params.toArray(), DiscountShortcutKeysPo.class);
	}
	
	public void insertDiscountShortcutKeysDetails(DiscountShortcutKeysDetailsPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into F_DiscountShortcutKeysDetails (");
		buffer.append(" F_DKD_UUID, ");
		buffer.append(" F_DKD_DiscountKeysID, ");
		buffer.append(" F_DKD_GoodsLevel, ");
		buffer.append(" F_DKD_Discount ");
		buffer.append(" )values( ");
		buffer.append(" ?, ");
		buffer.append(" ?, ");
		buffer.append(" ?, ");
		buffer.append(" ? ");
		buffer.append(" ) ");
		
		params.add(this.uuid.generate());
		params.add(po.getFdkddiscountkeysid());
		params.add(po.getFdkdgoodslevel());
		params.add(po.getFdkddiscount());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public List<DiscountShortcutKeysDetailsPo> selectDiscountShortcutKeysDetails(DiscountShortcutKeysDetailsPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select ");
		buffer.append("	F_DKD_UUID 					as fdkduuid, ");
		buffer.append(" F_DKD_DiscountKeysID		as fdkdpersonid, ");
		buffer.append(" F_DKD_GoodsLevel			as fdkdgoodslevel, ");
		buffer.append(" B_GL_Name					as fdkdgoodslevelname, ");
		buffer.append(" F_DKD_Discount				as fdkddiscount ");
		buffer.append(" from F_DiscountShortcutKeysDetails ");
		buffer.append(" left join B_GoodsLevel on F_DKD_GoodsLevel = B_GL_UUID");
		buffer.append(" where F_DKD_DiscountKeysID = ? ");
		
		params.add(po.getFdkddiscountkeysid());

		return queryForObjectList(buffer.toString(), params.toArray(),DiscountShortcutKeysDetailsPo.class);
	}
	
	public void deleteDiscountShortcutKeysDetails(String pid) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" delete from F_DiscountShortcutKeysDetails ");
		buffer.append(" where F_DKD_DiscountKeysID = ? ");
		
		params.add(pid);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}
