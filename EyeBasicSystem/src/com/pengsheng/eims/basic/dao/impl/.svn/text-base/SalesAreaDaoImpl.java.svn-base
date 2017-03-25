package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.SalesAreaDao;
import com.pengsheng.eims.basic.persistence.SalesAreaPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class SalesAreaDaoImpl extends BaseJdbcDaoSupport implements SalesAreaDao {

	public void deleteSalesAreaPo(String id) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_RC_SalesArea where R_RC_SA_ID = ? ");
		
		params.add(id);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void insertSalesAreaPo(SalesAreaPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO R_RC_SalesArea ");
		buffer.append("            (R_RC_SA_ID, ");
		buffer.append("             R_RC_SA_ReportID, ");
		buffer.append("             R_RC_SA_PriceMin, ");
		buffer.append("             R_RC_SA_PriceMax, ");
		buffer.append("             R_RC_SA_PriceMinDes, ");
		buffer.append("             R_RC_SA_PriceMaxDes, ");
		buffer.append("             R_RC_SA_GoodsCategoryID, ");
		buffer.append("             R_RC_SA_SalesType) ");
		buffer.append("VALUES     ( ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             '', ");
		buffer.append("             '', ");
		buffer.append("             ?, ");
		buffer.append("             ? ) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getRrcsareportid()));
		params.add(Utility.getName(po.getRrcsapricemin()));
		params.add(Utility.getName(po.getRrcsapricemax()));
		params.add(Utility.getName(po.getRrcsagoodscategoryid()).equals("") ? "" : po.getRrcsagoodscategoryid());
		params.add(Utility.getName(po.getRrcsasalestype()).equals("") ? "" : po.getRrcsasalestype());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public List<SalesAreaPo> selectSalesAreaListAll(String moduleid) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT R_RC_SA_ID          AS rrcsaid, ");
		buffer.append("       R_RC_SA_ReportID    AS rrcsareportid, ");
		buffer.append("       R_RC_SA_PriceMin    AS rrcsapricemin, ");
		buffer.append("       R_RC_SA_PriceMax    AS rrcsapricemax, ");
		buffer.append("       R_RC_SA_PriceMinDes AS rrcsapricemindes, ");
		buffer.append("       R_RC_SA_PriceMaxDes AS rrcsapricemaxdes, ");
		buffer.append("       R_RC_SA_GoodsCategoryID AS rrcsagoodscategoryid ");
		buffer.append("FROM   R_RC_SalesArea ");
		buffer.append("WHERE  R_RC_SA_ReportID = ? ");
		buffer.append("order by cast(R_RC_SA_PriceMin as float) ");
		
		params.add(moduleid);
		
		return queryForObjectList(buffer.toString(), params.toArray(), SalesAreaPo.class);
	}
	
	public List<SalesAreaPo> selectSalesAreaListAllByGoodsCategoryID(String goodsCategoryID) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT R_RC_SA_ID          AS rrcsaid, ");
		buffer.append("       R_RC_SA_ReportID    AS rrcsareportid, ");
		buffer.append("       R_RC_SA_PriceMin    AS rrcsapricemin, ");
		buffer.append("       R_RC_SA_PriceMax    AS rrcsapricemax, ");
		buffer.append("       R_RC_SA_PriceMinDes AS rrcsapricemindes, ");
		buffer.append("       R_RC_SA_PriceMaxDes AS rrcsapricemaxdes, ");
		buffer.append("       R_RC_SA_GoodsCategoryID AS rrcsagoodscategoryid ");
		buffer.append("FROM   R_RC_SalesArea ");
		buffer.append("WHERE  R_RC_SA_GoodsCategoryID = ? ");
		buffer.append("order by cast(R_RC_SA_PriceMin as float) ");
		
		params.add(goodsCategoryID);
		
		return queryForObjectList(buffer.toString(), params.toArray(), SalesAreaPo.class);
	}
	
	private String fightString(String[] strs) {
		if(null != strs && strs.length > 0) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < strs.length; i++) {
				sb.append("'" + strs[i] + "', ");
			}
			sb = new StringBuffer(sb.substring(0, sb.length() - 2));
			return "(" + sb.toString() + ")";
		}
		return "";
	}
	
	public List<SalesAreaPo> selectSalesAreaListAllByCategoryIDOrSalesType(String[] goodsCategoryID, String[] salesType) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT R_RC_SA_ID              AS rrcsaid, ");
		buffer.append("       R_RC_SA_ReportID        AS rrcsareportid, ");
		buffer.append("       R_RC_SA_PriceMin        AS rrcsapricemin, ");
		buffer.append("       R_RC_SA_PriceMax        AS rrcsapricemax, ");
		buffer.append("       R_RC_SA_PriceMinDes     AS rrcsapricemindes, ");
		buffer.append("       R_RC_SA_PriceMaxDes     AS rrcsapricemaxdes, ");
		buffer.append("       (CASE R_RC_SA_GoodsCategoryID WHEN '' THEN '2' ELSE '1' END) AS orderBy, ");
		buffer.append("       R_RC_SA_SalesType       AS rrcsasalestype, ");
		buffer.append("       ( CASE R_RC_SA_SalesType ");
		buffer.append("           WHEN '1' THEN '框镜成品' ");
		buffer.append("           WHEN '2' THEN '框镜订制' ");
		buffer.append("           WHEN '3' THEN '隐形成品' ");
		buffer.append("           WHEN '4' THEN '隐形订制' ");
		buffer.append("           WHEN '5' THEN '辅料' ");
		buffer.append("           ELSE '' ");
		buffer.append("         END )                 AS salesTypeName, ");
		buffer.append("       R_RC_SA_GoodsCategoryID AS rrcsagoodscategoryid, ");
		buffer.append("       ( CASE R_RC_SA_GoodsCategoryID ");
		buffer.append("           WHEN '1' THEN '镜架' ");
		buffer.append("           WHEN '2' THEN '配件' ");
		buffer.append("           WHEN '3' THEN '镜片' ");
		buffer.append("           WHEN '4' THEN '隐形镜片' ");
		buffer.append("           WHEN '5' THEN '隐形护理液' ");
		buffer.append("           WHEN '6' THEN '太阳镜' ");
		buffer.append("           WHEN '7' THEN '耗材' ");
		buffer.append("           WHEN '8' THEN '老花镜' ");
		buffer.append("           WHEN '9' THEN '视光' ");
		buffer.append("           ELSE '' ");
		buffer.append("         END )                 AS goodsCategoryName ");
		buffer.append("FROM   R_RC_SalesArea ");
		buffer.append("WHERE  1 <> 1 ");
		if(null != goodsCategoryID && goodsCategoryID.length > 0) {
			buffer.append(" OR R_RC_SA_GoodsCategoryID IN " + fightString(goodsCategoryID));
		}
		if(null != salesType && salesType.length > 0) {
			buffer.append(" OR R_RC_SA_SalesType IN " + fightString(salesType));
		}
		buffer.append(" order by orderBy,rrcsagoodscategoryid,rrcsasalestype ");
		
		return queryForObjectList(buffer.toString(), params.toArray(), SalesAreaPo.class);
	}
	/**
	 * 查询价格区间PO
	 * @return
	 */
	public SalesAreaPo selectSalesAreaPo(String id){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT R_RC_SA_ID          AS rrcsaid, ");
		buffer.append("       R_RC_SA_ReportID    AS rrcsareportid, ");
		buffer.append("       R_RC_SA_PriceMin    AS rrcsapricemin, ");
		buffer.append("       R_RC_SA_PriceMax    AS rrcsapricemax, ");
		buffer.append("       R_RC_SA_PriceMinDes AS rrcsapricemindes, ");
		buffer.append("       R_RC_SA_PriceMaxDes AS rrcsapricemaxdes ");
		buffer.append("FROM   R_RC_SalesArea ");
		buffer.append("WHERE  R_RC_SA_ID = ? ");
		
		params.add(id);
		
		return (SalesAreaPo)queryForObject(buffer.toString(), params.toArray(), SalesAreaPo.class);
	}
	
	/**
	 * 确认新增的价格段区间与之前新建的没有重复
	 */
	public int getSalesAreaBeforeCount(SalesAreaPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select sum(count1) from ( ");
		buffer.append("select count(R_RC_SA_ID) as count1 from R_RC_SalesArea where cast(R_RC_SA_PriceMin as numeric)<=cast(? as numeric) and ((isnull(R_RC_SA_PriceMax,'')<>'' and cast(R_RC_SA_PriceMax as numeric)>cast(? as numeric)) or isnull(R_RC_SA_PriceMax,'')='')  and R_RC_SA_GoodsCategoryID=? ");
		if (!"".equals(Utility.getName(po.getRrcsapricemax()))){
			buffer.append("union all ");
			buffer.append("select count(R_RC_SA_ID) as count1 from R_RC_SalesArea where cast(R_RC_SA_PriceMin as numeric)<cast(? as numeric) and ((isnull(R_RC_SA_PriceMax,'')<>'' and cast(R_RC_SA_PriceMax as numeric)>cast(? as numeric)) or isnull(R_RC_SA_PriceMax,'')='')  and R_RC_SA_GoodsCategoryID=? ");
		}	
        buffer.append(")temp ");
		
		params.add(Utility.getName(po.getRrcsapricemin()));
		params.add(Utility.getName(po.getRrcsapricemin()));
		params.add(Utility.getName(po.getRrcsagoodscategoryid()));
		
		if (!"".equals(Utility.getName(po.getRrcsapricemax()))){
			params.add(Utility.getName(po.getRrcsapricemax()));
			params.add(Utility.getName(po.getRrcsapricemax()));
			params.add(Utility.getName(po.getRrcsagoodscategoryid()));	
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	/**
	 * 确认新增的价格段区间与之前新建的没有重复
	 */
	public int getSalesTypeAreaBeforeCount(SalesAreaPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select sum(count1) from ( ");
		buffer.append("select count(R_RC_SA_ID) as count1 from R_RC_SalesArea where cast(R_RC_SA_PriceMin as numeric)<=cast(? as numeric) and ((isnull(R_RC_SA_PriceMax,'')<>'' and cast(R_RC_SA_PriceMax as numeric)>cast(? as numeric)) or isnull(R_RC_SA_PriceMax,'')='')  and R_RC_SA_SalesType=? ");
		if (!"".equals(Utility.getName(po.getRrcsapricemax()))){
			buffer.append("union all ");
			buffer.append("select count(R_RC_SA_ID) as count1 from R_RC_SalesArea where cast(R_RC_SA_PriceMin as numeric)<cast(? as numeric) and ((isnull(R_RC_SA_PriceMax,'')<>'' and cast(R_RC_SA_PriceMax as numeric)>cast(? as numeric)) or isnull(R_RC_SA_PriceMax,'')='')  and R_RC_SA_SalesType=? ");
		}	
        buffer.append(")temp ");
		
		params.add(Utility.getName(po.getRrcsapricemin()));
		params.add(Utility.getName(po.getRrcsapricemin()));
		params.add(Utility.getName(po.getRrcsasalestype()));
		
		if (!"".equals(Utility.getName(po.getRrcsapricemax()))){
			params.add(Utility.getName(po.getRrcsapricemax()));
			params.add(Utility.getName(po.getRrcsapricemax()));
			params.add(Utility.getName(po.getRrcsasalestype()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}

	public int selectSalesAreaListAllByCategoryIDOrSalesTypeCount(
			String[] goodsCategoryID, String[] salesType) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("SELECT COUNT(R_RC_SA_ID)       AS rrcsaid ");
		buffer.append("FROM   R_RC_SalesArea ");
		buffer.append("WHERE  1 <> 1 ");
		if(null != goodsCategoryID && goodsCategoryID.length > 0) {
			buffer.append(" OR R_RC_SA_GoodsCategoryID IN " + fightString(goodsCategoryID));
		}
		if(null != salesType && salesType.length > 0) {
			buffer.append(" OR R_RC_SA_SalesType IN " + fightString(salesType));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public List<SalesAreaPo> selectSalesAreaListAllByCategoryIDOrSalesType(
			String[] goodsCategoryID, String[] salesType, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int pageSize = start + size;
		buffer.append(" SET ROWCOUNT " + size + " ");
		buffer.append(" SELECT * FROM ( SELECT ROW_NUMBER() OVER(ORDER BY R_RC_SA_GoodsCategoryID,R_RC_SA_SalesType,CAST(R_RC_SA_PriceMin AS FLOAT))   AS rowNum, ");
		buffer.append("       R_RC_SA_ID        	  AS rrcsaid, ");
		buffer.append("       R_RC_SA_ReportID        AS rrcsareportid, ");
		buffer.append("       R_RC_SA_PriceMin        AS rrcsapricemin, ");
		buffer.append("       R_RC_SA_PriceMax        AS rrcsapricemax, ");
		buffer.append("       R_RC_SA_PriceMinDes     AS rrcsapricemindes, ");
		buffer.append("       R_RC_SA_PriceMaxDes     AS rrcsapricemaxdes, ");
		buffer.append("       (CASE R_RC_SA_GoodsCategoryID WHEN '' THEN '2' ELSE '1' END) AS orderBy, ");
		buffer.append("       R_RC_SA_SalesType       AS rrcsasalestype, ");
		buffer.append("       ( CASE R_RC_SA_SalesType ");
		buffer.append("           WHEN '1' THEN '框镜成品' ");
		buffer.append("           WHEN '2' THEN '框镜订制' ");
		buffer.append("           WHEN '3' THEN '隐形成品' ");
		buffer.append("           WHEN '4' THEN '隐形订制' ");
		buffer.append("           WHEN '5' THEN '辅料' ");
		buffer.append("           ELSE '' ");
		buffer.append("         END )                 AS salesTypeName, ");
		buffer.append("       R_RC_SA_GoodsCategoryID AS rrcsagoodscategoryid, ");
		buffer.append("       ( CASE R_RC_SA_GoodsCategoryID ");
		buffer.append("           WHEN '1' THEN '镜架' ");
		buffer.append("           WHEN '2' THEN '配件' ");
		buffer.append("           WHEN '3' THEN '镜片' ");
		buffer.append("           WHEN '4' THEN '隐形镜片' ");
		buffer.append("           WHEN '5' THEN '隐形护理液' ");
		buffer.append("           WHEN '6' THEN '太阳镜' ");
		buffer.append("           WHEN '7' THEN '耗材' ");
		buffer.append("           WHEN '8' THEN '老花镜' ");
		buffer.append("           WHEN '9' THEN '视光' ");
		buffer.append("           ELSE '' ");
		buffer.append("         END )                 AS goodsCategoryName ");
		buffer.append("FROM   R_RC_SalesArea ");
		buffer.append("WHERE 1<>1 ");
		if(null != goodsCategoryID && goodsCategoryID.length > 0) {
			buffer.append(" OR R_RC_SA_GoodsCategoryID IN " + fightString(goodsCategoryID));
		}
		if(null != salesType && salesType.length > 0) {
			buffer.append(" OR R_RC_SA_SalesType IN " + fightString(salesType));
		}
		buffer.append(" ) AS t1 WHERE rowNum > " + start + " AND rowNum <= " + pageSize + " ");
		
		return queryForObjectList(buffer.toString(), params.toArray(), SalesAreaPo.class);
	}
	
}
