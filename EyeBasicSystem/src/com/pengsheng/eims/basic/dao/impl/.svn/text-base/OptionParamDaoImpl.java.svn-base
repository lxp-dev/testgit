package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.OptionParamDao;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;


public class OptionParamDaoImpl extends BaseJdbcDaoSupport implements
OptionParamDao {

	public List<OptionParamPo> getOptionParamMaxList() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT F_OP_ParamID as fopparamid ");
		buffer.append(",F_OP_ParamName  as fopparamname ");
		buffer.append(",F_OP_ModuleID  as fopmoduleid ");
		buffer.append(",(select count(b.F_OP_ParamID) from  F_OptionParam b where b.F_OP_Type='2'  and b.F_OP_ParentID=a.F_OP_ParamID) as minCount ");
		buffer.append("FROM F_OptionParam a ");		
		buffer.append("WHERE F_OP_Type='1'");

		return queryForObjectList(buffer.toString(), null, OptionParamPo.class);
	}
	public List<OptionParamPo> getOptionParamList(OptionParamPo po,int start, int size) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select * from (");
		buffer.append("select ROW_NUMBER() Over(order by F_OP_ParamID) as rowNum, F_OP_ParamID as fopparamid ");
		buffer.append(",F_OP_ParamName  as fopparamname ");
		buffer.append(",F_OP_ParentID  as fopparentid ");
		buffer.append(",F_OP_ModuleID  as fopmoduleid ");	
		buffer.append(",moduleCname  as fopmodulename ");	
		buffer.append(",F_OP_Type  as foptype ");				
		buffer.append(",(select count(b.F_OP_ParamID) from  F_OptionParam b where F_OP_Type = '2'  and b.F_OP_ParentID=a.F_OP_ParamID) as  minCount ");
		buffer.append("FROM F_OptionParam a left join SYS_Module on F_OP_ModuleID = moduleID ");		
		buffer.append("WHERE F_OP_Type='1' ");
		
		if (!"".equals(Utility.getName(po.getFopmoduleid()))){
			buffer.append("   and F_OP_ModuleID = ? ");
			params.add(Utility.getName(po.getFopmoduleid()));
		}
		
		if (!"".equals(Utility.getName(po.getFopparamname()))){
			buffer.append("   and F_OP_ParamName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFopparamname()));
		}
		
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size)+" order by fopmoduleid");
		return queryForObjectList(buffer.toString(), params.toArray(), OptionParamPo.class);
	}
	public int getOptionParamCount(OptionParamPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select count(F_OP_ParamID)");
		buffer.append("   FROM F_OptionParam WHERE F_OP_Type='1' ");
		
		if (!"".equals(Utility.getName(po.getFopmoduleid()))){
			buffer.append("   and F_OP_ModuleID = ? ");
			params.add(Utility.getName(po.getFopmoduleid()));
		}
		
		if (!"".equals(Utility.getName(po.getFopparamname()))){
			buffer.append("   and F_OP_ParamName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFopparamname()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}

	public List<OptionParamPo> getOptionParamMinList(
			OptionParamPo optionParamPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT F_OP_ParamID as fopparamid ");
		buffer.append(",F_OP_ParamName  as fopparamname ");
		buffer.append(",F_OP_ParentID as fopparentid ");
		buffer.append("FROM F_OptionParam ");
		buffer.append("WHERE F_OP_Type='2' ");
		
		//父ID
		if(!"".equals(Utility.getName(optionParamPo.getFopparentid())))
		{
			buffer.append("AND F_OP_ParentID = ? ");
			params.add(optionParamPo.getFopparentid());
		}
		
		return queryForObjectList(buffer.toString(), params.toArray(), OptionParamPo.class);
	}

	public OptionParamPo getOptionParam(
			OptionParamPo optionParamPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  F_OP_ParamID as fopparamid ");
		buffer.append(",F_OP_ParamName  as fopparamname ");
		buffer.append(",F_OP_ParentID as fopparentid ");
		buffer.append(",F_OP_ModuleID as fopmoduleid ");
		buffer.append(",F_OP_Remark as fopremark ");	
		buffer.append(",F_OP_Type as foptype ");		
		buffer.append("FROM F_OptionParam ");
		buffer.append("WHERE F_OP_ParamID = ?");

		List<String> params = new ArrayList<String>();
		params.add(optionParamPo.getFopparamid());
		
		return (OptionParamPo) queryForObject(buffer.toString(), params
				.toArray(), OptionParamPo.class);
	}
	
	public void insertOptionParam(
			OptionParamPo optionParamPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO F_OptionParam ");
		buffer.append("(F_OP_ParamID");
		buffer.append(",F_OP_ParamName");
		buffer.append(",F_OP_ParentID");
		buffer.append(",F_OP_Remark");	
		buffer.append(",F_OP_Type");			
		buffer.append(",F_OP_ModuleID)");
		buffer.append("VALUES (?, ?, ?, ?, ?, ?)");

		List<String> params = new ArrayList<String>();
		params.add(optionParamPo.getFopparamid());
		params.add(optionParamPo.getFopparamname());
		params.add(Utility.getName(optionParamPo.getFopparentid()));
		params.add(optionParamPo.getFopremark());
		params.add(optionParamPo.getFoptype());		
		params.add(optionParamPo.getFopmoduleid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void updateOptionParam(
			OptionParamPo optionParamPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE F_OptionParam ");
		buffer.append("SET F_OP_ParamName = ? ");
		buffer.append(",F_OP_Remark = ? ");
		buffer.append(",F_OP_ModuleID = ? ");		
		buffer.append(" WHERE F_OP_ParamID = ?");

		List<String> params = new ArrayList<String>();

		params.add(optionParamPo.getFopparamname());
		params.add(optionParamPo.getFopremark());
		params.add(optionParamPo.getFopmoduleid());
		params.add(optionParamPo.getFopparamid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void deleteOptionParam(OptionParamPo optionParamPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM F_OptionParam ");
		buffer.append("WHERE F_OP_ParamID = ?");

		List<String> params = new ArrayList<String>();
		params.add(optionParamPo.getFopparamid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	
	public int getOptionParamID(OptionParamPo optionParamPo) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" select count( F_OP_ParamID ) from F_OptionParam where F_OP_ParamID  = ?");
		params.add(optionParamPo.getFopparamid());		
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	public int getOptionParamName(OptionParamPo optionParamPo) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count( F_OP_ParamID )");
		if(optionParamPo.getFoptype().equals("1"))
		{
			buffer.append("  from F_OptionParam where F_OP_Type='1' and F_OP_ParamName = ? ");
			params.add(Utility.getName(optionParamPo.getFopparamname()));
		}else if(optionParamPo.getFoptype().equals("2"))
		{
			buffer.append("  from F_OptionParam where F_OP_Type='2' and F_NP_parented=? and F_OP_ParamName = ? ");

			params.add(Utility.getName(optionParamPo.getFopparentid()));
			params.add(Utility.getName(optionParamPo.getFopparamname()));
		}
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public int getOptionParamNameUpdate(OptionParamPo optionParamPo) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count( F_OP_ParamID )");
		if(optionParamPo.getFoptype().equals("1"))
		{
			buffer.append("   from F_OptionParam where F_OP_Type='1' and F_OP_ParamName = ? and F_OP_ParamID <> ? ");
			params.add(Utility.getName(optionParamPo.getFopparamname()));
			params.add(Utility.getName(optionParamPo.getFopparamid()));
		}else if(optionParamPo.getFoptype().equals("2"))
		{
			buffer.append("   from F_OptionParam where F_OP_Type='2' and F_OP_ParentID=? and F_OP_ParamName = ? and F_OP_ParamID <> ? ");
			params.add(Utility.getName(optionParamPo.getFopparentid()));
			params.add(Utility.getName(optionParamPo.getFopparamname()));
			params.add(Utility.getName(optionParamPo.getFopparamid()));
		}
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
}
