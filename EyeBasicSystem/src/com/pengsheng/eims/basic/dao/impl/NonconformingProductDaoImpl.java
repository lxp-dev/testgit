package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.NonconformingProductDao;
import com.pengsheng.eims.basic.persistence.NonconformingProductPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;


public class NonconformingProductDaoImpl extends BaseJdbcDaoSupport implements
NonconformingProductDao {

	public List<NonconformingProductPo> getNonconformingProductMaxList() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT F_NP_ID as fnpid ");
		buffer.append(",F_NP_content  as fnpcontent ");
		buffer.append(",F_NP_deptId  as fnpdeptid ");
		buffer.append(",(select count(b.F_NP_ID) from  F_NonconformingProduct b where b.F_NP_deptId = '2'  and b.F_NP_parented=a.F_NP_ID) as minCount ");
		buffer.append("FROM F_NonconformingProduct a ");		
		buffer.append("WHERE F_NP_deptId = '1'");

		return queryForObjectList(buffer.toString(), null, NonconformingProductPo.class);
	}
	public List<NonconformingProductPo> getNonconformingProductList(NonconformingProductPo po,int start, int size) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append("select ROW_NUMBER() Over(order by F_NP_ID) as rowNum, F_NP_ID as fnpid ");
		buffer.append(",F_NP_content  as fnpcontent ");
		buffer.append(",F_NP_deptId  as fnpdeptid ");
		buffer.append(",(select count(b.F_NP_ID) from  F_NonconformingProduct b where b.F_NP_deptId = '2'  and b.F_NP_parented=a.F_NP_ID) as  minCount ");
		buffer.append("FROM F_NonconformingProduct a ");		
		buffer.append("WHERE F_NP_deptId = '1'");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return queryForObjectList(buffer.toString(), null, NonconformingProductPo.class);
	}
	public int getNonconformingProductCount(NonconformingProductPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(F_NP_ID)");
		buffer.append("   FROM F_NonconformingProduct a  WHERE F_NP_deptId = '1'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	public List<NonconformingProductPo> getNonconformingProductMinList(
			NonconformingProductPo nonconformingProductPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT F_NP_ID as fnpid ");
		buffer.append(",F_NP_content  as fnpcontent ");
		buffer.append(",F_NP_deptId  as fnpdeptid ");
		buffer.append(",F_NP_parented  as fnpparented ");
		buffer.append("FROM F_NonconformingProduct ");
		buffer.append("WHERE  F_NP_deptId ='2' ");

		List<String> params = new ArrayList<String>();
		
		if (!"".equals(Utility.getName(nonconformingProductPo.getFnpparented()))){
			buffer.append(" AND F_NP_parented = ? ");
			params.add(Utility.getName(nonconformingProductPo.getFnpparented()));
		}
		
		return queryForObjectList(buffer.toString(), params.toArray(), NonconformingProductPo.class);
	}

	public NonconformingProductPo getNonconformingProduct(
			NonconformingProductPo nonconformingProductPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  F_NP_ID as fnpid ");
		buffer.append(",F_NP_content  as fnpcontent ");
		buffer.append(",F_NP_deptId  as fnpdeptid ");
		buffer.append(",F_NP_parented  as fnpparented ");
		buffer.append("FROM F_NonconformingProduct ");
		buffer.append("WHERE F_NP_ID = ?");

		List<String> params = new ArrayList<String>();
		params.add(nonconformingProductPo.getFnpid());
		
		return (NonconformingProductPo) queryForObject(buffer.toString(), params
				.toArray(), NonconformingProductPo.class);
	}
	
	public void insertNonconformingProduct(
			NonconformingProductPo nonconformingProductPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO F_NonconformingProduct ");
		buffer.append("(F_NP_ID");
		buffer.append(",F_NP_content");
		buffer.append(",F_NP_parented");
		buffer.append(",F_NP_deptId)");
		buffer.append("VALUES (?, ?, ?, ?)");

		List<String> params = new ArrayList<String>();
		params.add(nonconformingProductPo.getFnpid());
		params.add(nonconformingProductPo.getFnpcontent());
		params.add(Utility.getName(nonconformingProductPo.getFnpparented()));
		params.add(nonconformingProductPo.getFnpdeptid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void updateNonconformingProduct(
			NonconformingProductPo nonconformingProductPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE F_NonconformingProduct ");
		buffer.append("SET F_NP_content = ? ");
		buffer.append("WHERE F_NP_ID = ?");

		List<String> params = new ArrayList<String>();

		params.add(nonconformingProductPo.getFnpcontent());
		params.add(nonconformingProductPo.getFnpid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void deleteNonconformingProduct(NonconformingProductPo nonconformingProductPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM F_NonconformingProduct ");
		buffer.append("WHERE F_NP_ID = ?");

		List<String> params = new ArrayList<String>();
		params.add(nonconformingProductPo.getFnpid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	
	public int getNonconformingProductName(NonconformingProductPo nonconformingProductPo) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count( F_NP_ID )");
		if(nonconformingProductPo.getFnpdeptid().equals("1"))
		{
			buffer.append("   from F_NonconformingProduct where F_NP_deptId=1 and F_NP_content = ? ");
			params.add(Utility.getName(nonconformingProductPo.getFnpcontent()));
		}else
		{
			buffer.append("   from F_NonconformingProduct where F_NP_deptId=2 and F_NP_parented=? and F_NP_content = ? ");

			params.add(Utility.getName(nonconformingProductPo.getFnpparented()));
			params.add(Utility.getName(nonconformingProductPo.getFnpcontent()));
		}
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public int getNonconformingProductNameUpdate(NonconformingProductPo nonconformingProductPo) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count( F_NP_ID )");
		if(nonconformingProductPo.getFnpdeptid().equals("1"))
		{
			buffer.append("   from F_NonconformingProduct where F_NP_deptId=1 and F_NP_content = ? and F_NP_ID <> ? ");
			params.add(Utility.getName(nonconformingProductPo.getFnpcontent()));
			params.add(Utility.getName(nonconformingProductPo.getFnpid()));
		}else
		{
			buffer.append("   from F_NonconformingProduct where F_NP_deptId=2 and F_NP_parented=? and F_NP_content = ? and F_NP_ID <> ? ");
			params.add(Utility.getName(nonconformingProductPo.getFnpparented()));
			params.add(Utility.getName(nonconformingProductPo.getFnpcontent()));
			params.add(Utility.getName(nonconformingProductPo.getFnpid()));
		}
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
}
