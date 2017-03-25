package com.pengsheng.mall.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.mall.dao.MallTypeLargeDao;
import com.pengsheng.mall.po.MallTypeLargePo;


public class MallTypeLargeDaoImpl extends BaseJdbcDaoSupport implements MallTypeLargeDao{

	public void deleteMallTypeLargePo(MallTypeLargePo po) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from Mall_TypeLarge where M_TL_ID = '"+ po.getMtlid() +"'");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public void insertMallTypeLargePo(MallTypeLargePo po) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("INSERT INTO Mall_TypeLarge ");
		buffer.append("            (M_TL_ID, ");
		buffer.append("             M_TL_Name, ");
		buffer.append("             M_TL_Picurl, ");
		buffer.append("             M_TL_Datetime) ");
		buffer.append("VALUES      ( '"+ this.uuid.generate() +"', ");
		buffer.append("              '"+ Utility.getName(po.getMtlname()) +"', ");		
		buffer.append("              '"+ Utility.getName(po.getMtlpicurl()) +"',");
		buffer.append("              getdate()) ");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public MallTypeLargePo getMallTypeLargePo(MallTypeLargePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT TOP 1 M_TL_ID      				AS mtlid, ");
		buffer.append("             M_TL_Name    				AS mtlname, ");
		buffer.append("             isnull(M_TL_Picurl,'')   	AS mtlpicurl, ");
		buffer.append("             M_TL_Datetime   			AS mtldatetime ");

		buffer.append("FROM   Mall_TypeLarge ");

		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getMtlid()))){
			buffer.append("AND M_TL_ID = ? ");
			params.add(Utility.getName(po.getMtlid()));
		}
		
		if(!"".equals(Utility.getName(po.getMtlname()))){
			buffer.append("AND M_TL_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getMtlname()));
		}
		
		return (MallTypeLargePo) queryForObject(buffer.toString(), params.toArray(), MallTypeLargePo.class);
	}

	public void updateMallTypeLargePo(MallTypeLargePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("Update Mall_TypeLarge set ");
		buffer.append("             M_TL_Name = ?, ");
		buffer.append("             M_TL_Picurl = ?, ");
		buffer.append("             M_TL_Datetime = getdate() ");

		buffer.append("where M_TL_ID = ? ");
		
		params.add(Utility.getName(po.getMtlname()));
		params.add(Utility.getName(po.getMtlpicurl()));
		params.add(Utility.getName(po.getMtlid()));				
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public int getMallTypeLargePoCount(MallTypeLargePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT count(*) ");
		buffer.append("FROM   Mall_TypeLarge ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getMtlname()))){
			buffer.append("AND M_TL_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getMtlname()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public List<MallTypeLargePo> getMallTypeLargePoList(
			MallTypeLargePo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		
		buffer.append("SELECT	    * from( ");
		buffer.append("SELECT	    ROW_NUMBER() Over(order by M_TL_ID desc) as rowNum, ");
		buffer.append("             M_TL_ID    					AS mtlid, ");
		buffer.append("             M_TL_Name    				AS mtlname, ");
		buffer.append("             isnull(M_TL_Picurl,'')   	AS mtlpicurl, ");
		buffer.append("             M_TL_Datetime   			AS mtldatetime ");
		
		buffer.append("FROM   Mall_TypeLarge ");

		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getMtlname()))){
			buffer.append("AND M_TL_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getMtlname()));
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), MallTypeLargePo.class);
	}
	
	public List<MallTypeLargePo> getMallTypeLargePoList(MallTypeLargePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT	    M_TL_ID    		AS mtlid, ");
		buffer.append("             M_TL_Name   	AS mtlname, ");
		buffer.append("             M_TL_Picurl   	AS mtlpicurl ");
		
		buffer.append("FROM   Mall_TypeLarge ");

		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getMtlname()))){
			buffer.append("AND M_TL_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getMtlname()));
		}
		
		return queryForObjectList(buffer.toString(), params.toArray(), MallTypeLargePo.class);
	}
}
