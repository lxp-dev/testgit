package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.CustomerAgeGroupDao;
import com.pengsheng.eims.basic.persistence.CustomerAgeGroupPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class CustomerAgeGroupDaoImpl extends BaseJdbcDaoSupport implements CustomerAgeGroupDao{

	
	public void deleteCustomerAgeGroupPo(CustomerAgeGroupPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("DELETE FROM B_CustomerAgeGroup ");
		buffer.append("WHERE  B_CG_GoodsCategory = ? ");
		
		params.add(po.getBcggoodscategory());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	
	public void insertCustomerAgeGroupPo(CustomerAgeGroupPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO B_CustomerAgeGroup ");
		buffer.append("            (B_CG_UUID, ");
		buffer.append("             B_CG_AgesMin, ");
		buffer.append("             B_CG_AgesMax, ");
		buffer.append("             B_CG_GoodsCategory, ");
		buffer.append("             B_CG_Remark) ");
		buffer.append("VALUES      ( ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ? ) ");
		
		params.add(this.uuid.generate());
		params.add(po.getBcgagesmin());
		params.add(po.getBcgagesmax());
		params.add(po.getBcggoodscategory());
		params.add(po.getBcgremark());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	
	public int selectCustomerAge(CustomerAgeGroupPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT count(*) ");
		buffer.append("FROM   B_CustomerAgeGroup ");
		buffer.append("WHERE  B_CG_GoodsCategory = ? ");
		
		params.add(po.getBcggoodscategory());
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}

	
	public int selectCustomerAgeGroupCount() {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT count(*) from ( ");
		buffer.append("SELECT B_CG_GoodsCategory,B_CG_Remark ");
		buffer.append("FROM   B_CustomerAgeGroup ");
		buffer.append("WHERE  1=1 ");
		buffer.append("Group by ");
		buffer.append("       B_CG_GoodsCategory, ");
		buffer.append("       B_CG_Remark  ");
		buffer.append(")temp ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}

	
	public List<CustomerAgeGroupPo> selectCustomerAgeGroupList(
			CustomerAgeGroupPo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		
		buffer.append("select * ");
		buffer.append("from( ");
		buffer.append("SELECT ROW_NUMBER() Over(order by B_CG_GoodsCategory) as rowNum, ");
		buffer.append("       B_CG_GoodsCategory	as bcggoodscategory, ");
		buffer.append("       B_GC_GoodsCategoryName as bcggoodscategoryname, ");
		buffer.append("       B_CG_Remark 			as bcgremark ");
		buffer.append("FROM   B_CustomerAgeGroup ");
		buffer.append("Inner join B_GoodsCategory on B_GC_ID = B_CG_GoodsCategory ");
		buffer.append("WHERE  1=1 ");
		buffer.append("Group by ");
		buffer.append("       B_CG_GoodsCategory, ");
		buffer.append("       B_GC_GoodsCategoryName, ");
		buffer.append("       B_CG_Remark  ");
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= " + countPage);
		buffer.append(" set rowcount 0");

		
		return queryForObjectList(buffer.toString(), params.toArray(), CustomerAgeGroupPo.class);
	}

	
	public List<CustomerAgeGroupPo> selectCustomerAgeGroupPos(CustomerAgeGroupPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT B_CG_UUID 			as bcguuid, ");
		buffer.append("       B_CG_AgesMin 			as bcgagesmin, ");
		buffer.append("       B_CG_AgesMax 			as bcgagesmax, ");
		buffer.append("       B_CG_GoodsCategory	as bcggoodscategory, ");
		buffer.append("       B_GC_GoodsCategoryName as bcggoodscategoryname, ");
		buffer.append("       B_CG_Remark 			as bcgremark ");
		buffer.append("FROM   B_CustomerAgeGroup ");
		buffer.append("Inner join B_GoodsCategory on B_GC_ID = B_CG_GoodsCategory ");
		buffer.append("WHERE  B_CG_GoodsCategory = ? ");
		
		params.add(po.getBcggoodscategory());
		
		return queryForObjectList(buffer.toString(), params.toArray(), CustomerAgeGroupPo.class);
	}

	
	public void updateCustomerAgeGroupPo(CustomerAgeGroupPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO B_CustomerAgeGroup ");
		buffer.append("            (B_CG_UUID, ");
		buffer.append("             B_CG_AgesMin, ");
		buffer.append("             B_CG_AgesMax, ");
		buffer.append("             B_CG_GoodsCategory, ");
		buffer.append("             B_CG_Remark) ");
		buffer.append("VALUES      ( ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ? ) ");
		
		params.add(po.getBcgagesmin());
		params.add(po.getBcgagesmax());
		params.add(po.getBcggoodscategory());
		params.add(po.getBcgremark());
		
		params.add(po.getBcguuid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}
