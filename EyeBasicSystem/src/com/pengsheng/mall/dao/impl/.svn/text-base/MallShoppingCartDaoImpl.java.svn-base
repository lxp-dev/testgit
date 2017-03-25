package com.pengsheng.mall.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.mall.dao.MallShoppingCartDao;
import com.pengsheng.mall.po.MallShoppingCartPo;


public class MallShoppingCartDaoImpl extends BaseJdbcDaoSupport implements MallShoppingCartDao{

	public void deleteMallShoppingCartPo(MallShoppingCartPo po) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from Mall_ShoppingCart where M_SC_ID = '"+ po.getMscid() +"'");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public void insertMallShoppingCartPo(MallShoppingCartPo po) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("INSERT INTO Mall_ShoppingCart ");
		buffer.append("            (M_SC_ID, ");
		buffer.append("             M_SC_Openid, ");
		buffer.append("             M_SC_Smallid, ");
		buffer.append("             M_SC_Color, ");
		buffer.append("             M_SC_Spec, ");
		buffer.append("             M_SC_Count, ");
		buffer.append("             M_SC_PriceSum, ");
		buffer.append("             M_SC_Datetime) ");
		buffer.append("VALUES      ( '"+ this.uuid.generate() +"', ");
		buffer.append("              '"+ Utility.getName(po.getMscopenid()) +"', ");		
		buffer.append("              '"+ Utility.getName(po.getMscsmallid()) +"',");
		buffer.append("              '"+ Utility.getName(po.getMsccolor()) +"',");
		buffer.append("              '"+ Utility.getName(po.getMscspec()) +"',");
		buffer.append("              '"+ Utility.getName(po.getMsccount()) +"',");
		buffer.append("              '"+ Utility.getName(po.getMscpricesum()) +"',");
		buffer.append("              getdate()) ");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public MallShoppingCartPo getMallShoppingCartPo(MallShoppingCartPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT TOP 1 M_SC_ID      				AS mscid, ");
		buffer.append("             M_SC_Openid    				AS mscopenid, ");
		buffer.append("             M_SC_Smallid			   	AS mscsmallid, ");
		buffer.append("             M_TS_Name			   		AS mscsmallname, ");
		buffer.append("             isnull(M_TS_Picurl,'')   	AS mscsmallpicurl, ");
		buffer.append("             M_SC_Color			   		AS msccolor, ");
		buffer.append("             M_SC_Spec			   		AS mscspec, ");
		buffer.append("             M_SC_Count			   		AS msccount, ");
		buffer.append("             M_SC_PriceSum			   	AS mscpricesum, ");
		buffer.append("             M_SC_Datetime   			AS mscdatetime ");

		buffer.append("FROM   Mall_ShoppingCart ");
		buffer.append("left Mall_TypeSmall on M_SC_Smallid=M_TS_ID ");

		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getMscid()))){
			buffer.append("AND M_SC_ID = ? ");
			params.add(Utility.getName(po.getMscid()));
		}
		
		return (MallShoppingCartPo) queryForObject(buffer.toString(), params.toArray(), MallShoppingCartPo.class);
	}

	public void updateMallShoppingCartPo(MallShoppingCartPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("Update Mall_ShoppingCart set ");
		buffer.append("             msccount = ?, ");
		buffer.append("             M_SC_PriceSum = ?, ");
		buffer.append("             M_SC_Datetime = getdate() ");

		buffer.append("where M_SC_ID = ? ");
		
		params.add(Utility.getName(po.getMsccount()));
		params.add(Utility.getName(po.getMscpricesum()));
		params.add(Utility.getName(po.getMscid()));				
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public Map<String, Object> getMallShoppingCartPoCountByOpenID(String openID) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(M_SC_ID) as count, SUM(M_SC_PriceSum) as titlenum ");
		buffer.append("FROM   Mall_ShoppingCart ");
		buffer.append("WHERE  M_SC_Openid = '"+ openID +"' ");
		
		return getJdbcTemplate().queryForMap(buffer.toString(), params.toArray());
	}

	public List<MallShoppingCartPo> getMallShoppingCartPoListByOpenID(String openID) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT	    M_SC_ID      				AS mscid, ");
		buffer.append("             M_SC_Openid    				AS mscopenid, ");
		buffer.append("             M_SC_Smallid			   	AS mscsmallid, ");
		buffer.append("             M_TS_Name			   		AS mscsmallname, ");
		buffer.append("             isnull(M_TS_Picurl,'')   	AS mscsmallpicurl, ");
		buffer.append("             M_SC_Color					AS msccolor, ");
		buffer.append("             M_SC_Spec					AS mscspec, ");
		buffer.append("             M_SC_Count			   		AS msccount, ");
		buffer.append("             M_SC_PriceSum			   	AS mscpricesum, ");
		buffer.append("             M_SC_Datetime   			AS mscdatetime ");
		
		buffer.append("FROM   Mall_ShoppingCart ");
		buffer.append("left join Mall_TypeSmall on M_SC_Smallid=M_TS_ID ");

		buffer.append("WHERE  M_SC_Openid = '"+ openID +"' ");
		buffer.append("order by M_SC_Datetime desc ");
		
		
		return queryForObjectList(buffer.toString(), params.toArray(), MallShoppingCartPo.class);
	}
}