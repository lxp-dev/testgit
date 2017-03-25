package com.pengsheng.eims.yklogistics.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.yklogistics.dao.CalDao;
import com.pengsheng.eims.logistics.persistence.LCTCostingTempPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class CalDaoImpl extends BaseJdbcDaoSupport implements CalDao {
	
	public void realCalStorageDel() {
		StringBuffer sb = new StringBuffer();
		sb.append("delete from L_CT_CurrentMonthCostingTemp");
		List<String> params = new ArrayList<String>();
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void realCalStorage(String date) {		
		StringBuffer sb = new StringBuffer();
		sb.append("exec costAccount ");
		List<String> params = new ArrayList<String>();
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}

	public void moniCalRetrun() {
		StringBuffer sb = new StringBuffer();	
		sb.append("update L_CT_CurrentMonthCostingTemp set L_CT_CT_BackFillTaxRate = L_CT_CT_Goodsnottaxrateamount / L_CT_CT_GoodsQuantity ");
		sb.append("  where L_CT_CT_GoodsQuantity <> 0");
		List<String> params = new ArrayList<String>();
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	//查询成本
	@SuppressWarnings("unchecked")
	public List<InventoryEntryPo> selRealCal(String date) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select C_ST_IE_BillID as cstiebillid,C_ST_IE_GoodsId as cstiegoodsid,L_CT_CT_BackFillTaxRate as cstienottaxrate ");
		sb.append("  from C_ST_InventoryEntry inner join L_CT_CurrentMonthCostingTemp on C_ST_IE_GoodsId=L_CT_CT_GoodsID");
		sb.append("       inner join C_ST_Inventory on C_ST_I_BillID=C_ST_IE_BillID ");
		sb.append("  where convert(varchar(7),C_ST_I_billDate,120)=? and C_ST_I_BillTypeId in ('8','5','6') and isnull(C_ST_I_VoucherType,0) != '1'");
		sb.append("  union all ");
		sb.append("select C_ST_IE_BillID as cstiebillid,C_ST_IE_GoodsId as cstiegoodsid,L_CT_CT_BackFillTaxRate as cstienottaxrate ");
		sb.append("  from C_ST_InventoryEntry inner join L_CT_CurrentMonthCostingTemp on C_ST_IE_GoodsId=L_CT_CT_GoodsID");
		sb.append("       inner join C_ST_Inventory on C_ST_I_BillID=C_ST_IE_BillID ");
		sb.append("  where convert(varchar(7),C_ST_I_AuditDate,120)=? and C_ST_I_BillTypeId='3' and isnull(C_ST_I_VoucherType,0) != '1'");
		
		params.add(date);
		params.add(date);
		
		return queryForObjectList(sb.toString(), params.toArray(), InventoryEntryPo.class);
	}
	
	//回填成本
	public void realCalRetrun(InventoryEntryPo po) {
		StringBuffer sb = new StringBuffer();	
		sb.append("update C_ST_InventoryEntry set C_ST_IE_NotTaxRate=? ");
		sb.append(" where C_ST_IE_BillID=? and C_ST_IE_GoodsId=? ");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getCstienottaxrate());
//		params.add(po.getCstienottaxrate());
		params.add(po.getCstiebillid());
		params.add(po.getCstiegoodsid());
		
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	public void updateNotTaxRateAmount(InventoryEntryPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("update C_ST_InventoryEntry set C_ST_IE_NotTaxRateAmount=round((C_ST_IE_GoodsQuantity*C_ST_IE_NotTaxRate),2) ");
		sb.append(" where C_ST_IE_BillID=? and C_ST_IE_GoodsId=? ");
		
		params.add(po.getCstiebillid());
		params.add(po.getCstiegoodsid());
		
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}

	public List<LCTCostingTempPo> getResultList(GoodsInfoPo goodsInfoPo,int start ,int size) {
		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select * from ( ");	
		sb.append("SELECT ROW_NUMBER() Over(ORDER BY L_CT_CT_ID) AS rowNum,L_CT_CT_GoodsID as lctctgoodsid,L_CT_CT_GoodsQuantity as lctctgoodsquantity,L_CT_CT_BackFillTaxRate as lctctbackfilltaxrate,L_CT_CT_goodsnottaxrateamount as lctctgoodsnottaxrateamount,b_gi_goodsname as bgigoodsname FROM L_CT_CurrentMonthCostingTemp inner join b_goodsinfo on b_gi_goodsid=L_CT_CT_GoodsID WHERE 1=1 ");
		
		List<String> params = new ArrayList<String>();
		if(!"".equals(Utility.getName(goodsInfoPo.getBgisupplierid()))){
			sb.append("and b_gi_supplierid=? ");
			params.add(goodsInfoPo.getBgisupplierid());
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getBgibrandid()))){
			sb.append("and b_gi_brandid=? ");
			params.add(goodsInfoPo.getBgibrandid());
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getBgigoodsname()))){
			sb.append("and L_CT_CT_GoodsID like '%' + ? + '%' ");
			params.add(goodsInfoPo.getBgigoodsname());
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getBgiflag()))){
			if(!"1".equals(Utility.getName(goodsInfoPo.getBgiflag()))){
				sb.append(" and L_CT_CT_GoodsQuantity < 0 ");
			}else{
				sb.append(" and L_CT_CT_GoodsQuantity >= 0 ");
			}
		}
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= " + countPage);
		sb.append(" set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(), LCTCostingTempPo.class);
	}
	
	public int getResultCount(GoodsInfoPo goodsInfoPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT count(L_CT_CT_GoodsID) FROM L_CT_CurrentMonthCostingTemp inner join b_goodsinfo on b_gi_goodsid=L_CT_CT_GoodsID WHERE 1=1 ");
		List<String> params = new ArrayList<String>();
		if(!"".equals(Utility.getName(goodsInfoPo.getBgisupplierid()))){
			sb.append("and b_gi_supplierid=? ");
			params.add(goodsInfoPo.getBgisupplierid());
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getBgibrandid()))){
			sb.append("and b_gi_brandid=? ");
			params.add(goodsInfoPo.getBgibrandid());
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getBgigoodsname()))){
			sb.append("and L_CT_CT_GoodsID like '%' + ? + '%' ");
			params.add(goodsInfoPo.getBgigoodsname());
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getBgiflag()))){
			if(!"1".equals(Utility.getName(goodsInfoPo.getBgiflag()))){
				sb.append(" and L_CT_CT_GoodsQuantity <= 0 ");
			}else{
				sb.append(" and L_CT_CT_GoodsQuantity > 0 ");
			}
		}
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	public int getLastMonthDataCount(){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT count(L_CT_CT_GoodsID) FROM L_CT_LastMonthCostingTemp ");
		List<String> params = new ArrayList<String>();		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	public void delLastMonth(){
		StringBuffer sb = new StringBuffer();
		sb.append("delete from L_CT_LastMonthCostingTemp");
		List<String> params = new ArrayList<String>();
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void fromCurrentToLastMonth(){
		StringBuffer sb = new StringBuffer();
		sb.append("insert into L_CT_LastMonthCostingTemp select * from L_CT_CurrentMonthCostingTemp ");
		List<String> params = new ArrayList<String>();
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void fromCurrentToHistory(){
		StringBuffer sb = new StringBuffer();
		sb.append("insert into L_CT_HistoryCostingTemp select * from L_CT_CurrentMonthCostingTemp");
		List<String> params = new ArrayList<String>();
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void delHistoryMonth(String date){
		StringBuffer sb = new StringBuffer();
		sb.append("delete from L_CT_HistoryCostingTemp where L_CT_CT_Date=?");
		List<String> params = new ArrayList<String>();
		params.add(date);
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public int selCurrentDate(String date){
		StringBuffer sb = new StringBuffer();
		sb.append("select count(L_CT_CT_ID) from L_CT_CurrentMonthCostingTemp where L_CT_CT_Date=? ");
		List<String> params = new ArrayList<String>();
		params.add(date);
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}	
	
	public int selLastDate(String date){
		StringBuffer sb = new StringBuffer();
		sb.append("select count(L_CT_CT_ID) from L_CT_LastMonthCostingTemp where L_CT_CT_Date = ? ");
		List<String> params = new ArrayList<String>();
		params.add(getLastMonth(date));
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	private String getLastMonth(String date) {		
		int lastTime = Integer.valueOf(date.substring(5,7)) - 1;
		if (lastTime < 10){
			date = date.substring(0,5)+"0"+lastTime;
		}else{
			date = date.substring(0,5)+lastTime;
		}
		return date;
	}
	
	/**
	 *  更新基础信息的商品的平均成本
	 */
	public void updateGoodsAverageNotTaxRate(){

	}
} 
