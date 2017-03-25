package com.pengsheng.mall.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.mall.dao.MallTypeSmallDao;
import com.pengsheng.mall.po.MallTypeSmallPicPo;
import com.pengsheng.mall.po.MallTypeSmallPo;

public class MallTypeSmallDaoImpl extends BaseJdbcDaoSupport implements MallTypeSmallDao{

	public void deleteMallTypeSmallPo(MallTypeSmallPo po) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from Mall_TypeSmall where M_TS_ID = '"+ po.getMtsid() +"'");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public void insertMallTypeSmallPo(MallTypeSmallPo po) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("INSERT INTO Mall_TypeSmall ");
		buffer.append("            (M_TS_ID, ");
		buffer.append("             M_TS_Name, ");
		buffer.append("             M_TS_Content, ");
		buffer.append("             M_TS_Picurl, ");
		buffer.append("             M_TS_Flag, ");
		buffer.append("             M_TS_LargeID, ");
		buffer.append("             M_TS_BrandID, ");
		buffer.append("             M_TS_AreaID, ");
		buffer.append("             M_TS_PriceOld, ");
		buffer.append("             M_TS_PriceNew, ");
		buffer.append("             M_TS_StockCount, ");
		buffer.append("             M_TS_SaleCount, ");
		buffer.append("             M_TS_Color, ");
		buffer.append("             M_TS_Spec, ");		
		buffer.append("             M_TS_Datetime ");		
		buffer.append("             ) ");
		buffer.append("VALUES      ( '"+ this.uuid.generate() +"', ");
		buffer.append("              '"+ Utility.getName(po.getMtsname()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getMtscontent()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getMtspicurl()) +"', ");	
		buffer.append("              '"+ Utility.getName(po.getMtsflag()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getMtslargeid()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getMtsbrandid()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getMtsareaid()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getMtspriceold()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getMtspricenew()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getMtsstockcount()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getMtssalecount()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getMtscolor()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getMtsspec()) +"', ");		
		buffer.append("              getdate() ");
		buffer.append("              ) ");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public MallTypeSmallPo getMallTypeSmallPo(
			MallTypeSmallPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT TOP 1 M_TS_ID      			AS mtsid, ");
		buffer.append("             M_TS_Name    			AS mtsname, ");
		buffer.append("             M_TS_Content    		AS mtscontent, ");
		buffer.append("             isnull(M_TS_Picurl,'') 	AS mtspicurl, ");
		buffer.append("             M_TS_Flag    			AS mtsflag, ");
		buffer.append("             M_TS_LargeID    		AS mtslargeid, ");
		buffer.append("             M_TS_BrandID    		AS mtsbrandid, ");
		buffer.append("             M_TS_AreaID    			AS mtsareaid, ");
		buffer.append("             M_TL_Name    			AS mtslargename, ");
		buffer.append("             M_B_Name    			AS mtsbrandname, ");
		buffer.append("             M_A_Name    			AS mtsareaname, ");
		buffer.append("             M_TS_PriceOld    		AS mtspriceold, ");
		buffer.append("             M_TS_PriceNew    		AS mtspricenew, ");
		buffer.append("             M_TS_StockCount    		AS mtsstockcount, ");
		buffer.append("             M_TS_SaleCount    		AS mtssalecount, ");	
		buffer.append("             M_TS_Color    			AS mtscolor, ");
		buffer.append("             M_TS_Spec    			AS mtsspec, ");		
		buffer.append("             M_TS_Datetime    		AS mtsdatetime ");

		buffer.append("FROM   Mall_TypeSmall ");
		buffer.append("left join Mall_TypeLarge on M_TS_LargeID = M_TL_ID ");
		buffer.append("left join Mall_Brand on M_TS_BrandID = M_B_ID ");
		buffer.append("left join Mall_Area on M_TS_AreaID = M_A_ID ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getMtsid()))){
			buffer.append("AND M_TS_ID = ? ");
			params.add(Utility.getName(po.getMtsid()));
		}
		
		if(!"".equals(Utility.getName(po.getMtsname()))){
			buffer.append("AND M_TS_Name = ? ");
			params.add(Utility.getName(po.getMtsname()));
		}
		
		return (MallTypeSmallPo) queryForObject(buffer.toString(), params.toArray(), MallTypeSmallPo.class);
	}

	public void updateMallTypeSmallPo(MallTypeSmallPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("Update Mall_TypeSmall set ");
		buffer.append("             M_TS_Name = ?, ");
		buffer.append("             M_TS_Content = ?, ");
		buffer.append("             M_TS_Picurl = ?, ");	
		buffer.append("             M_TS_Flag = ?, ");
		buffer.append("             M_TS_LargeID = ?, ");
		buffer.append("             M_TS_BrandID = ?, ");
		buffer.append("             M_TS_AreaID = ?, ");
		buffer.append("             M_TS_PriceOld = ?, ");
		buffer.append("             M_TS_PriceNew = ?, ");
		buffer.append("             M_TS_StockCount = ?, ");
		buffer.append("             M_TS_SaleCount = ?, ");	
		buffer.append("             M_TS_Color = ?, ");
		buffer.append("             M_TS_Spec = ?, ");				
		buffer.append("             M_TS_Datetime = getdate() ");
		buffer.append("where M_TS_ID = ? ");
		
		params.add(Utility.getName(po.getMtsname()));
		params.add(Utility.getName(po.getMtscontent()));
		params.add(Utility.getName(po.getMtspicurl()));
		params.add(Utility.getName(po.getMtsflag()));
		params.add(Utility.getName(po.getMtslargeid()));
		params.add(Utility.getName(po.getMtsbrandid()));
		params.add(Utility.getName(po.getMtsareaid()));
		params.add(Utility.getName(po.getMtspriceold()));
		params.add(Utility.getName(po.getMtspricenew()));
		params.add(Utility.getName(po.getMtsstockcount()));
		params.add(Utility.getName(po.getMtssalecount()));	
		params.add(Utility.getName(po.getMtscolor()));
		params.add(Utility.getName(po.getMtsspec()));			
		params.add(Utility.getName(po.getMtsid()));		
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void updateMallTypeSmallFlag(MallTypeSmallPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("Update Mall_TypeSmall set ");
		buffer.append("             M_TS_Flag = ? ");
		buffer.append("Where M_TS_ID = ? ");
		
		params.add(Utility.getName(po.getMtsflag()));
		params.add(Utility.getName(po.getMtsid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public int getMallTypeSmallPoCount(MallTypeSmallPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT count(M_TS_ID) ");
		buffer.append("FROM   Mall_TypeSmall ");
		
		buffer.append("left join Mall_TypeLarge on M_TS_LargeID = M_TL_ID ");
		buffer.append("left join Mall_Brand on M_TS_BrandID = M_B_ID ");
		buffer.append("left join Mall_Area on M_TS_AreaID = M_A_ID ");
		
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getMtsname()))){
			buffer.append("AND M_TS_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getMtsname()));
		}
		
		if(!Utility.getName(po.getMtslargeid()).equals("")){
			buffer.append("AND  M_TS_LargeID = ? ");
			params.add(Utility.getName(po.getMtslargeid()));
		}

		if(!Utility.getName(po.getMtsbrandid()).equals("")){
			buffer.append("AND  M_TS_BrandID = ? ");
			params.add(Utility.getName(po.getMtsbrandid()));
		}
		
		if(!Utility.getName(po.getMtsareaid()).equals("")){
			buffer.append("AND  M_TS_AreaID = ? ");
			params.add(Utility.getName(po.getMtsareaid()));
		}
		
		if(!Utility.getName(po.getMtsflag()).equals("")){
			buffer.append("AND  M_TS_Flag = ? ");
			params.add(Utility.getName(po.getMtsflag()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public List<MallTypeSmallPo> getMallTypeSmallPoList(
			MallTypeSmallPo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		
		buffer.append("SELECT	    * from( ");
		buffer.append("SELECT	    ROW_NUMBER() Over(order by M_TS_ID desc) as rowNum, ");
		buffer.append("             M_TS_ID   				AS mtsid, ");
		buffer.append("             M_TS_Name    			AS mtsname, ");
		buffer.append("             M_TS_Content    		AS mtscontent, ");
		buffer.append("             isnull(M_TS_Picurl,'') 	AS mtspicurl, ");
		buffer.append("             M_TS_Flag    			AS mtsflag, ");
		buffer.append("             M_TS_LargeID    		AS mtsbrandid, ");
		buffer.append("             M_TS_BrandID    		AS mtsareaid, ");
		buffer.append("             M_TS_AreaID    			AS mtslargeid, ");
		buffer.append("             M_TL_Name    			AS mtslargename, ");
		buffer.append("             M_B_Name    			AS mtsbrandname, ");
		buffer.append("             M_A_Name    			AS mtsareaname, ");
		buffer.append("             M_TS_PriceOld    		AS mtspriceold, ");
		buffer.append("             M_TS_PriceNew    		AS mtspricenew, ");		
		buffer.append("             M_TS_StockCount    		AS mtsstockcount, ");
		buffer.append("             M_TS_SaleCount    		AS mtssalecount, ");
		buffer.append("             M_TS_Color    			AS mtscolor, ");
		buffer.append("             M_TS_Spec    			AS mtsspec, ");			
		buffer.append("             M_TS_Datetime    		AS mtsdatetime ");
		
		buffer.append("FROM   Mall_TypeSmall ");
		buffer.append("left join Mall_TypeLarge on M_TS_LargeID = M_TL_ID ");
		buffer.append("left join Mall_Brand on M_TS_BrandID = M_B_ID ");
		buffer.append("left join Mall_Area on M_TS_AreaID = M_A_ID ");
		
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getMtsname()))){
			buffer.append("AND M_TS_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getMtsname()));
		}
		
		if(!Utility.getName(po.getMtslargeid()).equals("")){
			buffer.append("AND  M_TS_LargeID = ? ");
			params.add(Utility.getName(po.getMtslargeid()));
		}

		if(!Utility.getName(po.getMtsbrandid()).equals("")){
			buffer.append("AND  M_TS_BrandID = ? ");
			params.add(Utility.getName(po.getMtsbrandid()));
		}
		
		if(!Utility.getName(po.getMtsareaid()).equals("")){
			buffer.append("AND  M_TS_AreaID = ? ");
			params.add(Utility.getName(po.getMtsareaid()));
		}
		
		if(!Utility.getName(po.getMtsflag()).equals("")){
			buffer.append("AND  M_TS_Flag = ? ");
			params.add(Utility.getName(po.getMtsflag()));
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), MallTypeSmallPo.class);
	}
	
	/**
	 * 获取滚动导航图List
	 * 
	 * @param smallID
	 */
	public List<MallTypeSmallPicPo> getMallTypeSmallPicList(String smallID){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT M_TS_P_ID 		   		AS mtspid, ");
		sb.append("       M_TS_P_SmallID    		AS mtspsmallid, ");
		sb.append("       isnull(M_TS_P_Picurl,'')	AS mtsppicUrl ");
		sb.append("FROM   Mall_TypeSmallPic ");		
		sb.append("WHERE  M_TS_P_SmallID = '"+ smallID +"' ");
		
		return queryForObjectList(sb.toString(), null, MallTypeSmallPicPo.class);
	}
	
	/**
	 * 上传滚动导航图
	 * 
	 * @param WeiXinDepartmentPicPo
	 */
	public void insertMallTypeSmallPic(MallTypeSmallPicPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert Mall_TypeSmallPic(M_TS_P_ID,M_TS_P_SmallID,M_TS_P_Picurl) values(?,?,?)");
				
		params.add(this.uuid.generate());
		params.add(po.getMtspsmallid());
		params.add(po.getMtsppicUrl());
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除滚动导航图
	 * 
	 * @param smallID
	 */
	public void deleteMallTypeSmallPic(String smallID){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("delete from Mall_TypeSmallPic where M_TS_P_SmallID='"+ smallID +"' ");
		getJdbcTemplate().update(buffer.toString());
		
	}
}
