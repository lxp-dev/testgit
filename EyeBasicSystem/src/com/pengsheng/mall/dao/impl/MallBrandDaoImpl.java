package com.pengsheng.mall.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.mall.dao.MallBrandDao;
import com.pengsheng.mall.po.MallBrandPo;


public class MallBrandDaoImpl extends BaseJdbcDaoSupport implements MallBrandDao{

	public void deleteMallBrandPo(MallBrandPo po) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from Mall_Brand where M_B_ID = '"+ po.getMbid() +"'");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public void insertMallBrandPo(MallBrandPo po) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("INSERT INTO Mall_Brand ");
		buffer.append("            (M_B_ID, ");
		buffer.append("             M_B_Name, ");
		buffer.append("             M_B_Picurl, ");
		buffer.append("             M_B_Datetime) ");
		buffer.append("VALUES      ( '"+ this.uuid.generate() +"', ");
		buffer.append("              '"+ Utility.getName(po.getMbname()) +"', ");		
		buffer.append("              '"+ Utility.getName(po.getMbpicurl()) +"',");
		buffer.append("              getdate()) ");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public MallBrandPo getMallBrandPo(MallBrandPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT TOP 1 M_B_ID      				AS mbid, ");
		buffer.append("             M_B_Name    				AS mbname, ");
		buffer.append("             isnull(M_B_Picurl,'')   	AS mbpicurl, ");
		buffer.append("             M_B_Datetime   				AS mbdatetime ");

		buffer.append("FROM   Mall_Brand ");

		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getMbid()))){
			buffer.append("AND M_B_ID = ? ");
			params.add(Utility.getName(po.getMbid()));
		}
		
		if(!"".equals(Utility.getName(po.getMbname()))){
			buffer.append("AND M_B_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getMbname()));
		}
		
		return (MallBrandPo) queryForObject(buffer.toString(), params.toArray(), MallBrandPo.class);
	}

	public void updateMallBrandPo(MallBrandPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("Update Mall_Brand set ");
		buffer.append("             M_B_Name = ?, ");
		buffer.append("             M_B_Picurl = ?, ");
		buffer.append("             M_B_Datetime = getdate() ");

		buffer.append("where M_B_ID = ? ");
		
		params.add(Utility.getName(po.getMbname()));
		params.add(Utility.getName(po.getMbpicurl()));
		params.add(Utility.getName(po.getMbid()));				
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public int getMallBrandPoCount(MallBrandPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT count(*) ");
		buffer.append("FROM   Mall_Brand ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getMbname()))){
			buffer.append("AND M_B_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getMbname()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public List<MallBrandPo> getMallBrandPoList(
			MallBrandPo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		
		buffer.append("SELECT	    * from( ");
		buffer.append("SELECT	    ROW_NUMBER() Over(order by M_B_ID desc) as rowNum, ");
		buffer.append("             M_B_ID    					AS mbid, ");
		buffer.append("             M_B_Name    				AS mbname, ");
		buffer.append("             isnull(M_B_Picurl,'')   	AS mbpicurl, ");
		buffer.append("             M_B_Datetime   				AS mbdatetime ");
		
		buffer.append("FROM   Mall_Brand ");

		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getMbname()))){
			buffer.append("AND M_B_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getMbname()));
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), MallBrandPo.class);
	}
	
	public List<MallBrandPo> getMallBrandPoList(MallBrandPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT	    M_B_ID    	AS mbid, ");
		buffer.append("             M_B_Name    AS mbname, ");
		buffer.append("             M_B_Picurl  AS mbpicurl ");
		
		buffer.append("FROM   Mall_Brand ");

		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getMbname()))){
			buffer.append("AND M_B_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getMbname()));
		}
		
		return queryForObjectList(buffer.toString(), params.toArray(), MallBrandPo.class);
	}
}
