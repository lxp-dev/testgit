package com.pengsheng.mall.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.mall.dao.MallAreaDao;
import com.pengsheng.mall.po.MallAreaPo;


public class MallAreaDaoImpl extends BaseJdbcDaoSupport implements MallAreaDao{

	public void deleteMallAreaPo(MallAreaPo po) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from Mall_Area where M_A_ID = '"+ po.getMaid() +"'");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public void insertMallAreaPo(MallAreaPo po) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("INSERT INTO Mall_Area ");
		buffer.append("            (M_A_ID, ");
		buffer.append("             M_A_Name, ");
		buffer.append("             M_A_Picurl, ");
		buffer.append("             M_A_Datetime) ");
		buffer.append("VALUES      ( '"+ this.uuid.generate() +"', ");
		buffer.append("              '"+ Utility.getName(po.getManame()) +"', ");		
		buffer.append("              '"+ Utility.getName(po.getMapicurl()) +"',");
		buffer.append("              getdate()) ");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public MallAreaPo getMallAreaPo(MallAreaPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT TOP 1 M_A_ID      				AS maid, ");
		buffer.append("             M_A_Name    				AS maname, ");
		buffer.append("             isnull(M_A_Picurl,'')   	AS mapicurl, ");
		buffer.append("             M_A_Datetime   				AS madatetime ");

		buffer.append("FROM   Mall_Area ");

		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getMaid()))){
			buffer.append("AND M_A_ID = ? ");
			params.add(Utility.getName(po.getMaid()));
		}
		
		if(!"".equals(Utility.getName(po.getManame()))){
			buffer.append("AND M_A_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getManame()));
		}
		
		return (MallAreaPo) queryForObject(buffer.toString(), params.toArray(), MallAreaPo.class);
	}

	public void updateMallAreaPo(MallAreaPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("Update Mall_Area set ");
		buffer.append("             M_A_Name = ?, ");
		buffer.append("             M_A_Picurl = ?, ");
		buffer.append("             M_A_Datetime = getdate() ");

		buffer.append("where M_A_ID = ? ");
		
		params.add(Utility.getName(po.getManame()));
		params.add(Utility.getName(po.getMapicurl()));
		params.add(Utility.getName(po.getMaid()));				
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public int getMallAreaPoCount(MallAreaPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT count(*) ");
		buffer.append("FROM   Mall_Area ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getManame()))){
			buffer.append("AND M_A_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getManame()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public List<MallAreaPo> getMallAreaPoList(
			MallAreaPo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		
		buffer.append("SELECT	    * from( ");
		buffer.append("SELECT	    ROW_NUMBER() Over(order by M_A_ID desc) as rowNum, ");
		buffer.append("             M_A_ID    					AS maid, ");
		buffer.append("             M_A_Name    				AS maname, ");
		buffer.append("             isnull(M_A_Picurl,'')   	AS mapicurl, ");
		buffer.append("             M_A_Datetime   				AS madatetime ");
		
		buffer.append("FROM   Mall_Area ");

		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getManame()))){
			buffer.append("AND M_A_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getManame()));
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), MallAreaPo.class);
	}
	
	public List<MallAreaPo> getMallAreaPoList(MallAreaPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT	    M_A_ID    	AS maid, ");
		buffer.append("             M_A_Name    AS maname, ");
		buffer.append("             M_A_Picurl  AS mapicurl ");
		
		buffer.append("FROM   Mall_Area ");

		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getManame()))){
			buffer.append("AND M_A_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getManame()));
		}
		
		return queryForObjectList(buffer.toString(), params.toArray(), MallAreaPo.class);
	}
}
