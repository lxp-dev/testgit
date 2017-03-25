package com.pengsheng.weixin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinLuckDrawSetDao;
import com.pengsheng.weixin.persistence.WeiXinLuckDrawPo;

public class WeiXinLuckDrawSetDaoImpl extends BaseJdbcDaoSupport implements WeiXinLuckDrawSetDao {
	
	public List<WeiXinLuckDrawPo> selectWeiXinLuckDrawSetList(WeiXinLuckDrawPo weiXinLuckDrawPo, int start, int size) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * ");
		sb.append(" from(select ROW_NUMBER() ");
		sb.append("Over(order by W_CJ_MemberId desc) as rowNum,");
		sb.append(" 	  W_CJ_Id as wcjid, ");
		sb.append("       W_CJ_MemberId as wcjmemberid, ");
		sb.append("       S_ME_CI_Name as wcjmembername, ");
		sb.append("       W_CJ_Phone as  wcjmemberphone, ");
		sb.append("       W_CJ_ShopId as wcjshopid , ");
		sb.append("       B_DP_DepartmentName as wcjshopname, ");
		sb.append("       W_CJ_PersonId as wcjpersonid, ");
		sb.append("       personName as wcjpersonname, ");
		sb.append("       W_CJ_Flag as wcjflag, ");
		sb.append("       W_CJ_PrizeSize as wcjprizesize, ");
		sb.append("       W_CJ_ActivitiesStratDate as wcjactivitiesstratdate, ");
		sb.append("       W_CJ_WinDate as wcjwindate, ");
		sb.append("       W_CJ_PrizeGoodName as wcjprizegoodname, ");
		sb.append("       W_CJ_GiveGoodsDate as wcjgivegoodsdate , ");
		sb.append("       W_CJ_ActivitiesEndDate as wcjactivitiesenddate  ");
		sb.append("FROM   W_LuckDraw ");
		sb.append("       LEFT JOIN dbo.B_Departments ");
		sb.append("         ON B_DP_DepartmentID = W_CJ_ShopId ");
		sb.append("       LEFT JOIN dbo.S_ME_CustomerInfo ");
		sb.append("         ON S_ME_CI_CustomerID = W_CJ_CustomerId ");
		sb.append("       LEFT JOIN dbo.SYS_PersonInfo ");
		sb.append("         ON ID = W_CJ_PersonId ");
		sb.append("WHERE  1 = 1 and W_CJ_PrizeSize <> 0  and isnull(W_CJ_PrizeSize,'') <> '' ");
		if(null != weiXinLuckDrawPo ){
			if(!"".equals(Utility.getName(weiXinLuckDrawPo.getWcjmemberid()))){
				sb.append(" and W_CJ_MemberId like '%'+?+'%' ");
				params.add(Utility.getName(weiXinLuckDrawPo.getWcjmemberid()));
			}
			if(!"".equals(Utility.getName(weiXinLuckDrawPo.getWcjmembername()))){
				sb.append(" and S_ME_CI_Name like '%'+?+'%' ");	
				params.add(Utility.getName(weiXinLuckDrawPo.getWcjmembername()));
			}
			if(!"".equals(Utility.getName(weiXinLuckDrawPo.getWcjphone()))){
				sb.append(" and W_CJ_Phone like '%'+?+'%' ");
				params.add(Utility.getName(weiXinLuckDrawPo.getWcjphone()));
			}
			if(!"".equals(Utility.getName(weiXinLuckDrawPo.getWcjwinstratdate()))){
				sb.append(" and convert(varchar(10),W_CJ_WinDate,23) >= ? ");	
				params.add(Utility.getName(weiXinLuckDrawPo.getWcjwinstratdate()));
			}
			if(!"".equals(Utility.getName(weiXinLuckDrawPo.getWcjwinstratdate()))){
				sb.append(" and convert(varchar(10),W_CJ_WinDate,23) <= ? ");
				params.add(Utility.getName(weiXinLuckDrawPo.getWcjwinstratdate()));
			}
			if(!"".equals(Utility.getName(weiXinLuckDrawPo.getWcjgivegoodsstratdate()))){
				sb.append(" and convert(varchar(10),W_CJ_GiveGoodsDate,23) >= ? ");
				params.add(Utility.getName(weiXinLuckDrawPo.getWcjgivegoodsstratdate()));
			}
			if(!"".equals(Utility.getName(weiXinLuckDrawPo.getWcjgivegoodsenddate()))){
				sb.append(" and convert(varchar(10),W_CJ_GiveGoodsDate,23) <= ? ");
				params.add(Utility.getName(weiXinLuckDrawPo.getWcjgivegoodsenddate()));
			}
			if(!"".equals(Utility.getName(weiXinLuckDrawPo.getWcjpersonname()))){
				sb.append(" and personName like '%'+?+'%' ");
				params.add(Utility.getName(weiXinLuckDrawPo.getWcjpersonname()));
			}
		}
		sb.append(" ) temp where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append("set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(), WeiXinLuckDrawPo.class);
	}
	
	
	public int selectWeiXinLuckDrawSetCount(WeiXinLuckDrawPo weiXinLuckDrawPo) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT count(W_CJ_Id) ");
		sb.append("FROM   W_LuckDraw ");
		sb.append("       LEFT JOIN dbo.B_Departments ");
		sb.append("         ON B_DP_DepartmentID = W_CJ_ShopId ");
		sb.append("       LEFT JOIN dbo.S_ME_CustomerInfo ");
		sb.append("         ON S_ME_CI_CustomerID = W_CJ_CustomerId ");
		sb.append("       LEFT JOIN dbo.SYS_PersonInfo ");
		sb.append("         ON ID = W_CJ_PersonId ");
		sb.append("WHERE  1 = 1 and W_CJ_PrizeSize <> 0  and isnull(W_CJ_PrizeSize,'') <> ''  ");
		if(null != weiXinLuckDrawPo ){
			if(!"".equals(Utility.getName(weiXinLuckDrawPo.getWcjmemberid()))){
				sb.append(" and W_CJ_MemberId like '%'+?+'%' ");
				params.add(Utility.getName(weiXinLuckDrawPo.getWcjmemberid()));
			}
			if(!"".equals(Utility.getName(weiXinLuckDrawPo.getWcjmembername()))){
				sb.append(" and S_ME_CI_Name like '%'+?+'%' ");	
				params.add(Utility.getName(weiXinLuckDrawPo.getWcjmembername()));
			}
			if(!"".equals(Utility.getName(weiXinLuckDrawPo.getWcjphone()))){
				sb.append(" and W_CJ_Phone like '%'+?+'%' ");
				params.add(Utility.getName(weiXinLuckDrawPo.getWcjphone()));
			}
			if(!"".equals(Utility.getName(weiXinLuckDrawPo.getWcjwinstratdate()))){
				sb.append(" and convert(varchar(10),W_CJ_WinDate,23) >= ? ");	
				params.add(Utility.getName(weiXinLuckDrawPo.getWcjwinstratdate()));
			}
			if(!"".equals(Utility.getName(weiXinLuckDrawPo.getWcjwinstratdate()))){
				sb.append(" and convert(varchar(10),W_CJ_WinDate,23) <= ? ");
				params.add(Utility.getName(weiXinLuckDrawPo.getWcjwinstratdate()));
			}
			if(!"".equals(Utility.getName(weiXinLuckDrawPo.getWcjgivegoodsstratdate()))){
				sb.append(" and convert(varchar(10),W_CJ_GiveGoodsDate,23) >= ? ");
				params.add(Utility.getName(weiXinLuckDrawPo.getWcjgivegoodsstratdate()));
			}
			if(!"".equals(Utility.getName(weiXinLuckDrawPo.getWcjgivegoodsenddate()))){
				sb.append(" and convert(varchar(10),W_CJ_GiveGoodsDate,23) <= ? ");
				params.add(Utility.getName(weiXinLuckDrawPo.getWcjgivegoodsenddate()));
			}
			if(!"".equals(Utility.getName(weiXinLuckDrawPo.getWcjpersonname()))){
				sb.append(" and personName like '%'+?+'%' ");
				params.add(Utility.getName(weiXinLuckDrawPo.getWcjpersonname()));
			}
		}
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	public void updateWeiXinLuckDrawSet(WeiXinLuckDrawPo weiXinLuckDrawPo){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("UPDATE W_LuckDraw ");
		sb.append("SET    W_CJ_ShopId = ?, ");
		sb.append("       W_CJ_PersonId = ?, ");
		sb.append("       W_CJ_Flag = 1, ");
		sb.append("       W_CJ_GiveGoodsDate = Getdate() ");
		sb.append("WHERE  W_CJ_Id = ? ");
		params.add(Utility.getName(weiXinLuckDrawPo.getWcjshopid()));
		params.add(Utility.getName(weiXinLuckDrawPo.getWcjpersonid()));
		params.add(Utility.getName(weiXinLuckDrawPo.getWcjid()));
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	public WeiXinLuckDrawPo selectWeiXinLuckDrawPo(WeiXinLuckDrawPo weiXinLuckDrawPo){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT top 1  ");
		sb.append(" 	  W_CJ_Id as wcjid, ");
		sb.append("       W_CJ_MemberId as wcjmemberid, ");
		sb.append("       S_ME_CI_Name as wcjmembername, ");
		sb.append("       W_CJ_Phone as  wcjmemberphone, ");
		sb.append("       W_CJ_ShopId as wcjshopid , ");
		sb.append("       W_CJ_PersonId as wcjpersonid, ");
		sb.append("       W_CJ_Flag as wcjflag, ");
		sb.append("       W_CJ_PrizeSize as wcjprizesize, ");
		sb.append("       W_CJ_ActivitiesStratDate as wcjactivitiesstratdate, ");
		sb.append("       W_CJ_WinDate as wcjwindate, ");
		sb.append("       W_CJ_PrizeGoodName as wcjprizegoodname, ");
		sb.append("       W_CJ_GiveGoodsDate as wcjgivegoodsdate , ");
		sb.append("       W_CJ_ActivitiesEndDate as wcjactivitiesenddate  ");
		sb.append("FROM   W_LuckDraw ");
		sb.append("       LEFT JOIN dbo.S_ME_CustomerInfo ");
		sb.append("         ON S_ME_CI_CustomerID = W_CJ_CustomerId ");
		sb.append("WHERE  W_CJ_Id = ? ");
		params.add(Utility.getName(weiXinLuckDrawPo.getWcjid()));
		return (WeiXinLuckDrawPo)queryForObject(sb.toString(), params.toArray(), WeiXinLuckDrawPo.class);
	}
	
	public void insertWeiXinLuckDrawSet(WeiXinLuckDrawPo weiXinLuckDrawPo){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("INSERT INTO W_LuckDrawSet ");
		sb.append("            (W_CJS_Id, ");
		sb.append("             W_CJS_ActivitiesStratDate, ");
		sb.append("             W_CJS_ActivitiesEndDate, ");
		sb.append("             W_CJS_Flag, ");
		
		if (!Utility.getName(weiXinLuckDrawPo.getWcjsdaynumber()).equals("")){
			sb.append("             W_CJS_DayNumber, ");	
		}
		if (!Utility.getName(weiXinLuckDrawPo.getWcjspersonnumber()).equals("")){
			sb.append("             W_CJS_PersonNumber, ");
		}
		if (!Utility.getName(weiXinLuckDrawPo.getWcjspersonlucknumber()).equals("")){
			sb.append("             W_CJS_PersonLuckNumber, ");
		}
		
		sb.append("             W_CJS_PrizeSizeGoods1, ");		
		if (!Utility.getName(weiXinLuckDrawPo.getWcjsprizesizegoodsnumber1()).equals("")){
			sb.append("             W_CJS_PrizeSizeGoodsNumber1, ");
		}
		sb.append("             W_CJS_PrizeSizeProbability1, ");
		sb.append("             W_CJS_PrizeSizeGoods2, ");
		if (!Utility.getName(weiXinLuckDrawPo.getWcjsprizesizegoodsnumber2()).equals("")){
			sb.append("             W_CJS_PrizeSizeGoodsNumber2, ");
		}		
		sb.append("             W_CJS_PrizeSizeProbability2, ");
		sb.append("             W_CJS_PrizeSizeGoods3, ");
		if (!Utility.getName(weiXinLuckDrawPo.getWcjsprizesizegoodsnumber3()).equals("")){
			sb.append("             W_CJS_PrizeSizeGoodsNumber3, ");
		}		
		sb.append("             W_CJS_PrizeSizeProbability3) ");
		
		sb.append("VALUES      ('"+ this.uuid.generate() +"', ");
		sb.append("             '"+ weiXinLuckDrawPo.getWcjsactivitiesstratdate() +"', ");
		sb.append("             '"+ weiXinLuckDrawPo.getWcjsactivitiesenddate() +"', ");
		sb.append("             '"+ weiXinLuckDrawPo.getWcjsflag() +"', ");
		
		if (!Utility.getName(weiXinLuckDrawPo.getWcjsdaynumber()).equals("")){
			sb.append("             '"+ weiXinLuckDrawPo.getWcjsdaynumber() +"', ");
		}
		if (!Utility.getName(weiXinLuckDrawPo.getWcjspersonnumber()).equals("")){
			sb.append("             '"+ weiXinLuckDrawPo.getWcjspersonnumber() +"', ");
		}
		if (!Utility.getName(weiXinLuckDrawPo.getWcjspersonlucknumber()).equals("")){
			sb.append("             '"+ weiXinLuckDrawPo.getWcjspersonlucknumber() +"', ");
		}		
		
		sb.append("             '"+ weiXinLuckDrawPo.getWcjsprizesizegoods1() +"', ");
		if (!Utility.getName(weiXinLuckDrawPo.getWcjsprizesizegoodsnumber1()).equals("")){
			sb.append("             '"+ weiXinLuckDrawPo.getWcjsprizesizegoodsnumber1() +"', ");
		}
		sb.append("             '"+ weiXinLuckDrawPo.getWcjsprizesizeprobability1() +"', ");
		sb.append("             '"+ weiXinLuckDrawPo.getWcjsprizesizegoods2() +"', ");
		if (!Utility.getName(weiXinLuckDrawPo.getWcjsprizesizegoodsnumber2()).equals("")){
			sb.append("             '"+ weiXinLuckDrawPo.getWcjsprizesizegoodsnumber2() +"', ");
		}
		sb.append("             '"+ weiXinLuckDrawPo.getWcjsprizesizeprobability2() +"', ");
		sb.append("             '"+ weiXinLuckDrawPo.getWcjsprizesizegoods3() +"', ");
		if (!Utility.getName(weiXinLuckDrawPo.getWcjsprizesizegoodsnumber3()).equals("")){
			sb.append("             '"+ weiXinLuckDrawPo.getWcjsprizesizegoodsnumber3() +"', ");
		}
		sb.append("             '"+ weiXinLuckDrawPo.getWcjsprizesizeprobability3() +"') ");
//		params.add(this.uuid.generate());
//		params.add(Utility.getName(weiXinLuckDrawPo.getWcjsactivitiesstratdate()));
//		params.add(Utility.getName(weiXinLuckDrawPo.getWcjsactivitiesenddate()));
//		params.add(Utility.getName(weiXinLuckDrawPo.getWcjsflag()));
//		params.add(Utility.getName(weiXinLuckDrawPo.getWcjsdaynumber()));
//		params.add(Utility.getName(weiXinLuckDrawPo.getWcjspersonnumber()));
//		params.add(Utility.getName(weiXinLuckDrawPo.getWcjspersonlucknumber()));
//		params.add(Utility.getName(weiXinLuckDrawPo.getWcjsprizesizegoods1()));
//		params.add(Utility.getName(weiXinLuckDrawPo.getWcjsprizesizegoodsnumber1()));
//		params.add(Utility.getName(weiXinLuckDrawPo.getWcjsprizesizeprobability1()));
//		params.add(Utility.getName(weiXinLuckDrawPo.getWcjsprizesizegoods2()));
//		params.add(Utility.getName(weiXinLuckDrawPo.getWcjsprizesizegoodsnumber2()));
//		params.add(Utility.getName(weiXinLuckDrawPo.getWcjsprizesizeprobability2()));
//		params.add(Utility.getName(weiXinLuckDrawPo.getWcjsprizesizegoods3()));
//		params.add(Utility.getName(weiXinLuckDrawPo.getWcjsprizesizegoodsnumber3()));
//		params.add(Utility.getName(weiXinLuckDrawPo.getWcjsprizesizeprobability3()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	public void daleteWeiXinLuckDrawSet(WeiXinLuckDrawPo weiXinLuckDrawPo){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("delete from W_LuckDrawSet ");
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	public WeiXinLuckDrawPo selectWeiXinLuckDrawSet(WeiXinLuckDrawPo weiXinLuckDrawPo){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT top 1 W_CJS_Id as wcjsid, ");
		sb.append("       convert(varchar(10),W_CJS_ActivitiesStratDate,120) as wcjsactivitiesstratdate, ");
		sb.append("       convert(varchar(10),W_CJS_ActivitiesEndDate,120) as wcjsactivitiesenddate, ");
		sb.append("       W_CJS_Flag as wcjsflag, ");
		sb.append("       W_CJS_DayNumber as wcjsdaynumber, ");
		sb.append("       W_CJS_PersonNumber as wcjspersonnumber, ");
		sb.append("       W_CJS_PersonLuckNumber as wcjspersonlucknumber, ");
		sb.append("       W_CJS_PrizeSizeGoods1 as wcjsprizesizegoods1, ");
		sb.append("       W_CJS_PrizeSizeGoodsNumber1 as wcjsprizesizegoodsnumber1,");
		sb.append("       W_CJS_PrizeSizeProbability1 as wcjsprizesizeprobability1, ");
		sb.append("       W_CJS_PrizeSizeGoods2 as wcjsprizesizegoods2, ");
		sb.append("       W_CJS_PrizeSizeGoodsNumber2 as wcjsprizesizegoodsnumber2,");
		sb.append("       W_CJS_PrizeSizeProbability2 as wcjsprizesizeprobability2, ");
		sb.append("       W_CJS_PrizeSizeGoods3 as wcjsprizesizegoods3, ");
		sb.append("       W_CJS_PrizeSizeGoodsNumber3 as wcjsprizesizegoodsnumber3,");
		sb.append("       W_CJS_PrizeSizeProbability3 as wcjsprizesizeprobability3, ");
		sb.append("       W_CJS_PrizeSizeGoods4 as wcjsprizesizegoods4, ");
		sb.append("       W_CJS_PrizeSizeGoodsNumber4 as wcjsprizesizegoodsnumber4,");
		sb.append("       W_CJS_PrizeSizeProbability4 as wcjsprizesizeprobability4, ");
		sb.append("       W_CJS_PrizeSizeGoods5 as wcjsprizesizegoods5, ");
		sb.append("       W_CJS_PrizeSizeGoodsNumber5 as wcjsprizesizegoodsnumber5,");
		sb.append("       W_CJS_PrizeSizeProbability5 as wcjsprizesizeprobability5 ");
		sb.append("FROM   W_LuckDrawSet ");
		return (WeiXinLuckDrawPo)queryForObject(sb.toString(), params.toArray(), WeiXinLuckDrawPo.class);
	}
	
	/**
	 * 新增中奖记录
	 */
	public void insertWeiXinLuckDraw(WeiXinLuckDrawPo weiXinLuckDrawPo){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("INSERT INTO W_LuckDraw ");
		sb.append("           (W_CJ_Id ");
		sb.append("           ,W_CJ_MemberId ");
		sb.append("           ,W_CJ_Flag ");
		sb.append("           ,W_CJ_PrizeSize ");		
		sb.append("           ,W_CJ_ActivitiesStratDate ");		
		sb.append("           ,W_CJ_WinDate ");		
		sb.append("           ,W_CJ_PrizeGoodName ");		
		sb.append("           ,W_CJ_ActivitiesEndDate ");		
		sb.append("           ,W_CJ_CustomerId ");
		sb.append("           ,W_CJ_OpenId ");
		sb.append("           ,W_CJ_Phone) ");
		sb.append("  values (?,?,'0',?,?,getdate(),?,?,?,?,?) ");
		
		params.add(uuid.generate());
		params.add(Utility.getName(weiXinLuckDrawPo.getWcjmemberid()));
		params.add(Utility.getName(weiXinLuckDrawPo.getWcjprizesize()));
		params.add(Utility.getName(weiXinLuckDrawPo.getWcjactivitiesstratdate()));
		params.add(Utility.getName(weiXinLuckDrawPo.getWcjprizegoodname()));
		params.add(Utility.getName(weiXinLuckDrawPo.getWcjactivitiesenddate()));
		params.add(Utility.getName(weiXinLuckDrawPo.getWcjcustomerid()));
		params.add(Utility.getName(weiXinLuckDrawPo.getWcjopenid()));
		params.add(Utility.getName(weiXinLuckDrawPo.getWcjphone()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 新增抽奖记录
	 */
	public void insertWeiXinLuckDrawLog(WeiXinLuckDrawPo weiXinLuckDrawPo){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("INSERT INTO W_LuckDrawLog ");
		sb.append("           (W_LDL_Id ");
		sb.append("           ,W_LDL_MemberId ");
		sb.append("           ,W_LDL_WinDate ");			
		sb.append("           ,W_LDL_CustomerId ");
		sb.append("           ,W_LDL_OpenId) ");
		sb.append("  values (?,?,getdate(),?,?) ");
		
		params.add(uuid.generate());
		params.add(Utility.getName(weiXinLuckDrawPo.getWcjmemberid()));
		params.add(Utility.getName(weiXinLuckDrawPo.getWcjcustomerid()));
		params.add(Utility.getName(weiXinLuckDrawPo.getWcjopenid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 查询中奖记录
	 */
	public List<WeiXinLuckDrawPo> selectWeiXinLuckDrawSetList(WeiXinLuckDrawPo weiXinLuckDrawPo){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" select  isnull(W_CJ_Flag,'0') as wcjflag, ");
		sb.append("       W_CJ_PrizeSize as wcjprizesize, ");
		sb.append("       convert(varchar(16),W_CJ_WinDate,120) as wcjwindate, ");
		sb.append("       W_CJ_PrizeGoodName as wcjprizegoodname ");	
		sb.append("FROM   W_LuckDraw ");
		sb.append("WHERE  W_CJ_OpenId = ? order by W_CJ_WinDate desc ");
		
		params.add(Utility.getName(weiXinLuckDrawPo.getWcjopenid()));
		
		return queryForObjectList(sb.toString(), params.toArray(), WeiXinLuckDrawPo.class);
	}
	
	/**
	 * 查询中奖记录总数
	 */
	public int selectWeiXinLuckDrawLogCount(WeiXinLuckDrawPo weiXinLuckDrawPo) {
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" select count(W_LDL_Id) from W_LuckDrawLog where convert(varchar(10),W_LDL_WinDate,120) = convert(varchar(10),getdate(),120) ");
		
		if (!"".equals(Utility.getName(weiXinLuckDrawPo.getWcjopenid()))){
			sb.append(" and W_LDL_OpenId = ? ");
			params.add(Utility.getName(weiXinLuckDrawPo.getWcjopenid()));			
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	
	/**
	 * 查询中奖记录总数
	 */
	public int selectWeiXinLuckDrawCount(WeiXinLuckDrawPo weiXinLuckDrawPo) {
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" select count(W_CJ_Id) from W_LuckDraw where W_CJ_OpenId = ? ");
		
		params.add(Utility.getName(weiXinLuckDrawPo.getWcjopenid()));		
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	
	/**
	 * 查询中奖总数
	 */
	public int selectWeiXinLuckDrawCount(int index){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" select count(W_CJ_Id) from W_LuckDraw where W_CJ_PrizeSize = ? ");
		
		params.add(String.valueOf(index));		
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	
}
