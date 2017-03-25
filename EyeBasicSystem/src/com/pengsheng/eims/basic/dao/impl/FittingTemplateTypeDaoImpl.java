package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.FittingTemplateTypeDao;
import com.pengsheng.eims.basic.persistence.FittingTemplateTypePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class FittingTemplateTypeDaoImpl extends BaseJdbcDaoSupport implements FittingTemplateTypeDao {

	/**
	 *  查询单据模版类型List
	 */
	public List<FittingTemplateTypePo> getFittingTemplateTypeList(FittingTemplateTypePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select B_FT_T_ID as bfttid, ");
		buffer.append("B_FT_T_Name as bfttname, ");
		buffer.append("a.B_FT_ID as bftid, ");
		buffer.append("B_FT_Server as bftserver, ");
		buffer.append("B_FT_FileName as bftfilename, ");	
		buffer.append("B_FT_TemplateName as bftname, ");
		buffer.append("B_FT_T_Showtype as bfttshowtype, ");
		buffer.append("isnull(B_FT_FIleUrl,'') as bftfileurl ");	
		buffer.append(" from B_FittingTemplate_Type a");
		buffer.append(" left join B_FittingTemplate b on a.B_FT_ID=b.B_FT_ID");
		buffer.append(" where 1 = 1 ");
		buffer.append(" order by orderby");

		return queryForObjectList(buffer.toString(), params.toArray(), FittingTemplateTypePo.class);
	}
	
	/**
	 *  查询单据模版类型PO
	 */
	public FittingTemplateTypePo getFittingTemplateTypePo(String typeID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select B_FT_T_ID as bfttid, ");
		buffer.append("B_FT_T_Name as bfttname, ");
		buffer.append("isnull(a.B_FT_ID,'') as bftid, ");
		buffer.append("b.B_FT_Server as bftserver, ");	
		buffer.append("B_FT_T_Showtype as bfttshowtype, ");		
		buffer.append("B_FT_FileName as bftfilename ");		
	
		buffer.append(" from B_FittingTemplate_Type a ");
		buffer.append(" left join B_FittingTemplate b on a.B_FT_ID=b.B_FT_ID");
		buffer.append(" where B_FT_T_ID = ? order by orderby");
		
		params.add(Utility.getName(typeID));
		
		return (FittingTemplateTypePo) this.queryForObject(buffer.toString(), params.toArray(), FittingTemplateTypePo.class);
	}

	/**
	 *  配置模版打开方式
	 */
	public void updateFittingTemplateTypeShowtype(String typeID,String showType){		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_FittingTemplate_Type set B_FT_T_Showtype= ? ");		
		buffer.append(" where B_FT_T_ID = ? ");
		
		params.add(showType);
		params.add(typeID);		

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 *  配置模版类型对应的报表
	 */
	public void updateFittingTemplateTypePo(FittingTemplateTypePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" update B_FittingTemplate_Type set B_FT_ID = ? ");
		
		buffer.append(" where B_FT_T_ID = ? ");
		params.add(Utility.getName(po.getBftid()));
		params.add(Utility.getName(po.getBfttid()));		

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}