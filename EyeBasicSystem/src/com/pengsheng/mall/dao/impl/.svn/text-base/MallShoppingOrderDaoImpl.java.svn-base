package com.pengsheng.mall.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.mall.dao.MallShoppingOrderDao;
import com.pengsheng.mall.po.MallShoppingOrderPo;

public class MallShoppingOrderDaoImpl extends BaseJdbcDaoSupport implements MallShoppingOrderDao{

	public void deleteMallShoppingOrderPo(MallShoppingOrderPo po) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from Mall_ShoppingOrder where M_SO_ID = '"+ po.getMsoid() +"'");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public void insertMallShoppingOrderPo(MallShoppingOrderPo po) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("INSERT INTO Mall_ShoppingOrder ");
		buffer.append("            (M_SO_ID, ");
		buffer.append("             M_SO_Openid, ");
		buffer.append("             M_SO_Smallid, ");
		buffer.append("             M_SO_Color, ");
		buffer.append("             M_SO_Spec, ");
		buffer.append("             M_SO_Count, ");
		buffer.append("             M_SO_PriceSum, ");
		buffer.append("             M_SO_Datetime, ");
		buffer.append("             M_SO_State, ");
		buffer.append("             M_SO_UpdateDatetime) ");
		buffer.append("VALUES      ( '"+ this.uuid.generate() +"', ");
		buffer.append("              '"+ Utility.getName(po.getMsoopenid()) +"', ");		
		buffer.append("              '"+ Utility.getName(po.getMsosmallid()) +"',");
		buffer.append("              '"+ Utility.getName(po.getMsocolor()) +"',");
		buffer.append("              '"+ Utility.getName(po.getMsospec()) +"',");
		buffer.append("              '"+ Utility.getName(po.getMsocount()) +"',");
		buffer.append("              '"+ Utility.getName(po.getMsopricesum()) +"',");
		buffer.append("              getdate(), ");
		buffer.append("              '"+ Utility.getName(po.getMsostate()) +"',");
		buffer.append("              getdate()) ");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public MallShoppingOrderPo getMallShoppingOrderPo(MallShoppingOrderPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT TOP 1 M_SO_ID      				AS msoid, ");
		buffer.append("             M_SO_Openid    				AS msoopenid, ");
		buffer.append("             M_SO_Smallid			   	AS msosmallid, ");
		buffer.append("             M_TS_Name			   		AS msosmallname, ");
		buffer.append("             isnull(M_TS_Picurl,'')   	AS msosmallpicurl, ");
		buffer.append("             M_SO_Color			   		AS msocolor, ");
		buffer.append("             M_SO_Spec			   		AS msospec, ");
		buffer.append("             M_SO_Count			   		AS msocount, ");
		buffer.append("             M_SO_PriceSum			   	AS msopricesum, ");
		buffer.append("             M_SO_Datetime   			AS msodatetime, ");
		buffer.append("             M_SO_State   				AS msostate, ");
		buffer.append("             M_SO_UpdateDatetime   		AS msoupdatedatetime ");

		buffer.append("FROM   Mall_ShoppingOrder ");
		buffer.append("left Mall_TypeSmall on M_SO_Smallid=M_TS_ID ");

		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getMsoid()))){
			buffer.append("AND M_SO_ID = ? ");
			params.add(Utility.getName(po.getMsoid()));
		}
		
		return (MallShoppingOrderPo) queryForObject(buffer.toString(), params.toArray(), MallShoppingOrderPo.class);
	}

	public void updateMallShoppingOrderPo(MallShoppingOrderPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("Update Mall_ShoppingOrder set ");
		buffer.append("             M_SO_State = ?, ");
		buffer.append("             M_SO_UpdateDatetime = getdate() ");

		buffer.append("where M_SO_ID = ? ");
		
		params.add(Utility.getName(po.getMsostate()));
		params.add(Utility.getName(po.getMsoid()));				
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public int getMallShoppingOrderPoCount(MallShoppingOrderPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(M_SO_ID) ");
		buffer.append("FROM   Mall_ShoppingOrder ");
		
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getMsoopenid()))){
			buffer.append("AND M_SO_Openid = ? ");
			params.add(Utility.getName(po.getMsoopenid()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public List<MallShoppingOrderPo> getMallShoppingOrderPoList(MallShoppingOrderPo po, int start, int size) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		
		buffer.append("SELECT	    * from( ");
		buffer.append("SELECT	    ROW_NUMBER() Over(order by M_SO_Datetime desc) as rowNum, ");
		buffer.append("			    M_SO_ID      				AS msoid, ");
		buffer.append("             M_SO_Openid    				AS msoopenid, ");
		buffer.append("             S_ME_CI_Name    			AS msocustomername, ");
		buffer.append("             M_SO_Smallid			   	AS msosmallid, ");
		buffer.append("             M_TS_Name			   		AS msosmallname, ");
		buffer.append("             isnull(M_TS_Picurl,'')   	AS msosmallpicurl, ");
		buffer.append("             M_SO_Color			   		AS msocolor, ");
		buffer.append("             M_SO_Spec			   		AS msospec, ");
		buffer.append("             M_SO_Count			   		AS msocount, ");
		buffer.append("             M_SO_PriceSum			   	AS msopricesum, ");
		buffer.append("             M_SO_Datetime   			AS msodatetime, ");
		buffer.append("             M_SO_State   				AS msostate, ");
		buffer.append("             M_SO_UpdateDatetime   		AS msoupdatedatetime ");
		
		buffer.append("FROM   Mall_ShoppingOrder ");
		buffer.append("left join Mall_TypeSmall on M_SO_Smallid=M_TS_ID ");
		buffer.append("left join S_ME_CustomerInfo on S_ME_CI_OpenID = M_SO_Openid ");
		
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getMsoopenid()))){
			buffer.append("AND M_SO_Openid = ? ");
			params.add(Utility.getName(po.getMsoopenid()));
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), MallShoppingOrderPo.class);
	}
}