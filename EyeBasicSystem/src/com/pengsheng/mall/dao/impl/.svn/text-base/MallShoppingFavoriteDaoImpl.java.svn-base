package com.pengsheng.mall.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.mall.dao.MallShoppingFavoriteDao;
import com.pengsheng.mall.po.MallShoppingFavoritePo;

public class MallShoppingFavoriteDaoImpl extends BaseJdbcDaoSupport implements MallShoppingFavoriteDao{

	public void deleteMallShoppingFavoritePo(MallShoppingFavoritePo po) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from Mall_ShoppingFavorite where M_SF_ID = '"+ po.getMsfid() +"'");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public void insertMallShoppingFavoritePo(MallShoppingFavoritePo po) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("INSERT INTO Mall_ShoppingFavorite ");
		buffer.append("            (M_SF_ID, ");
		buffer.append("             M_SF_Openid, ");
		buffer.append("             M_SF_Smallid, ");
		buffer.append("             M_SF_Datetime) ");
		buffer.append("VALUES      ( '"+ this.uuid.generate() +"', ");
		buffer.append("              '"+ Utility.getName(po.getMsfopenid()) +"', ");		
		buffer.append("              '"+ Utility.getName(po.getMsfsmallid()) +"',");
		buffer.append("              getdate()) ");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public int getMallShoppingFavoritePoCount(MallShoppingFavoritePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(M_SF_ID) ");
		buffer.append("FROM   Mall_ShoppingFavorite ");
		
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getMsfopenid()))){
			buffer.append("AND M_SF_Openid = ? ");
			params.add(Utility.getName(po.getMsfopenid()));
		}

		if(!"".equals(Utility.getName(po.getMsfsmallid()))){
			buffer.append("AND M_SF_Smallid = ? ");
			params.add(Utility.getName(po.getMsfsmallid()));
		}
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public List<MallShoppingFavoritePo> getMallShoppingFavoritePoList(MallShoppingFavoritePo po, int start, int size) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		
		buffer.append("SELECT	    * from( ");
		buffer.append("SELECT	    ROW_NUMBER() Over(order by M_SF_Datetime desc) as rowNum, ");
		buffer.append("			    M_SF_ID      				AS msfid, ");
		buffer.append("             M_SF_Openid    				AS msfopenid, ");
		buffer.append("             M_SF_Smallid			   	AS msfsmallid, ");
		buffer.append("             M_TS_Name			   		AS msfsmallname, ");
		buffer.append("             M_TS_PriceNew			   	AS msfpricesum, ");
		buffer.append("             isnull(M_TS_Picurl,'')   	AS msfsmallpicurl, ");
		buffer.append("             M_SF_Datetime   			AS msfdatetime ");
		
		buffer.append("FROM   Mall_ShoppingFavorite ");
		buffer.append("left join Mall_TypeSmall on M_SF_Smallid=M_TS_ID ");
		
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getMsfopenid()))){
			buffer.append("AND M_SF_Openid = ? ");
			params.add(Utility.getName(po.getMsfopenid()));
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), MallShoppingFavoritePo.class);
	}
}