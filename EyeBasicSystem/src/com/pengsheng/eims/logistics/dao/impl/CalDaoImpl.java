package com.pengsheng.eims.logistics.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.dao.CalDao;
import com.pengsheng.eims.logistics.persistence.AutoCostAccountPo;
import com.pengsheng.eims.logistics.persistence.LCTCostingTempPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class CalDaoImpl extends BaseJdbcDaoSupport implements CalDao {
	
	public void realCalStorageDel() {
		StringBuffer sb = new StringBuffer();
		sb.append("delete from L_CT_CurrentMonthCostingTemp");
		List<String> params = new ArrayList<String>();
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void realCalStorage(String date,String flag) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if (flag.equals("2")){
			sb.append("exec costAccount_costprice ? ");
		}else{
			sb.append("exec costAccount ? ");
		}	
		
		params.add(date);
		
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
		sb.append("  where isnull(C_ST_I_IsFillCostPrice,'') <> '1' and C_ST_I_AuditState = '1' and C_ST_I_BillTypeId in ('5','6','3','4') ");
//		sb.append("  union all ");
//		sb.append("select C_ST_IE_BillID as cstiebillid,C_ST_IE_GoodsId as cstiegoodsid,L_CT_CT_BackFillTaxRate as cstienottaxrate ");
//		sb.append("  from C_ST_InventoryEntry inner join L_CT_CurrentMonthCostingTemp on C_ST_IE_GoodsId=L_CT_CT_GoodsID");
//		sb.append("       inner join C_ST_Inventory on C_ST_I_BillID=C_ST_IE_BillID ");
//		sb.append("  where convert(varchar(7),C_ST_I_AuditDate,120)=? and C_ST_I_BillTypeId in ('3','4') ");
		sb.append("  union all ");
		sb.append("select C_ST_IE_BillID as cstiebillid,C_ST_IE_GoodsId as cstiegoodsid,L_CT_CT_BackFillTaxRate as cstienottaxrate ");
		sb.append("  from C_ST_InventoryEntry inner join L_CT_CurrentMonthCostingTemp on C_ST_IE_GoodsId=L_CT_CT_GoodsID");
		sb.append("       inner join C_ST_Inventory on C_ST_I_BillID=C_ST_IE_BillID ");
		sb.append("  where isnull(C_ST_I_IsFillCostPrice,'') <> '1' and C_ST_I_AuditState = '1' and C_ST_I_FinanceAuditState = '1' and C_ST_I_BillTypeId='8' ");
		
//		params.add(date);
//		params.add(date);
//		params.add(date);
		
		return queryForObjectList(sb.toString(),null, InventoryEntryPo.class);
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
	
	public void updateInventoryFillCostPrice(InventoryEntryPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("update C_ST_Inventory set C_ST_I_IsFillCostPrice='1' ");
		sb.append(" where C_ST_I_BillID=? ");
		
		params.add(po.getCstiebillid());
		
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}

	public List<LCTCostingTempPo> getResultList(GoodsInfoPo goodsInfoPo,int start ,int size) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select * from ( ");	
		sb.append("SELECT ROW_NUMBER() Over(ORDER BY L_CT_CT_Date,L_CT_CT_GoodsID) AS rowNum,L_CT_CT_Date as lctctdate,L_CT_CT_GoodsID as lctctgoodsid,L_CT_CT_GoodsQuantity as lctctgoodsquantity,L_CT_CT_BackFillTaxRate as lctctbackfilltaxrate,L_CT_CT_goodsnottaxrateamount as lctctgoodsnottaxrateamount,b_gi_goodsname as bgigoodsname FROM L_CT_HistoryCostingTemp inner join b_goodsinfo on b_gi_goodsid=L_CT_CT_GoodsID WHERE 1=1 ");
	
		if(!"".equals(Utility.getName(goodsInfoPo.getBgigoodscategoryid()))){
			sb.append("and B_GI_GoodsCategoryID=? ");
			params.add(Utility.getName(goodsInfoPo.getBgigoodscategoryid()));
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getBgisupplierid()))){
			sb.append("and b_gi_supplierid=? ");
			params.add(Utility.getName(goodsInfoPo.getBgisupplierid()));
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getBgibrandid()))){
			sb.append("and b_gi_brandid=? ");
			params.add(Utility.getName(goodsInfoPo.getBgibrandid()));
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getBgigoodsid()))){
			sb.append("and L_CT_CT_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(goodsInfoPo.getBgigoodsid()));
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getBgigoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(goodsInfoPo.getBgigoodsname()));
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getSettleaccountsdate()))){
			sb.append("and L_CT_CT_Date = ? ");
			params.add(Utility.getName(goodsInfoPo.getSettleaccountsdate()));
		}
		
		if(!"".equals(Utility.getName(goodsInfoPo.getBgicompanyid()))){
			sb.append("and L_CT_CT_CompanyID = ? ");
			params.add(Utility.getName(goodsInfoPo.getBgicompanyid()));
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= " + countPage);
		sb.append(" set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(), LCTCostingTempPo.class);
	}
	
	public int getResultCount(GoodsInfoPo goodsInfoPo) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT count(L_CT_CT_GoodsID) FROM L_CT_HistoryCostingTemp inner join b_goodsinfo on b_gi_goodsid=L_CT_CT_GoodsID WHERE 1=1 ");
		
		if(!"".equals(Utility.getName(goodsInfoPo.getBgigoodscategoryid()))){
			sb.append("and B_GI_GoodsCategoryID=? ");
			params.add(Utility.getName(goodsInfoPo.getBgigoodscategoryid()));
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getBgisupplierid()))){
			sb.append("and b_gi_supplierid=? ");
			params.add(Utility.getName(goodsInfoPo.getBgisupplierid()));
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getBgibrandid()))){
			sb.append("and b_gi_brandid=? ");
			params.add(Utility.getName(goodsInfoPo.getBgibrandid()));
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getBgigoodsid()))){
			sb.append("and L_CT_CT_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(goodsInfoPo.getBgigoodsid()));
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getBgigoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(goodsInfoPo.getBgigoodsname()));
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getSettleaccountsdate()))){
			sb.append("and L_CT_CT_Date = ? ");
			params.add(Utility.getName(goodsInfoPo.getSettleaccountsdate()));
		}
		
		if(!"".equals(Utility.getName(goodsInfoPo.getBgicompanyid()))){
			sb.append("and L_CT_CT_CompanyID = ? ");
			params.add(Utility.getName(goodsInfoPo.getBgicompanyid()));
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
		sb.append("insert into L_CT_LastMonthCostingTemp(L_CT_CT_ID,L_CT_CT_Date,L_CT_CT_GoodsID,L_CT_CT_GoodsQuantity,L_CT_CT_Goodsnottaxrateamount,L_CT_CT_BackFillTaxRate) select L_CT_CT_ID,L_CT_CT_Date,L_CT_CT_GoodsID,L_CT_CT_GoodsQuantity,L_CT_CT_Goodsnottaxrateamount,L_CT_CT_BackFillTaxRate from L_CT_CurrentMonthCostingTemp ");
		List<String> params = new ArrayList<String>();
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void fromCurrentToHistory(){
		StringBuffer sb = new StringBuffer();
		sb.append("insert into L_CT_HistoryCostingTemp(L_CT_CT_ID,L_CT_CT_Date,L_CT_CT_GoodsID,L_CT_CT_GoodsQuantity,L_CT_CT_Goodsnottaxrateamount,L_CT_CT_BackFillTaxRate) select L_CT_CT_ID,L_CT_CT_Date,L_CT_CT_GoodsID,L_CT_CT_GoodsQuantity,L_CT_CT_Goodsnottaxrateamount,L_CT_CT_BackFillTaxRate from L_CT_CurrentMonthCostingTemp");
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
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("exec L_updateGoodsAverageNotTaxRate ");
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void fromLastMonthToCurrentMonth(){
		StringBuffer sb = new StringBuffer();
		sb.append("insert into L_CT_CurrentMonthCostingTemp(L_CT_CT_ID,L_CT_CT_Date,L_CT_CT_GoodsID,L_CT_CT_GoodsQuantity,L_CT_CT_Goodsnottaxrateamount,L_CT_CT_BackFillTaxRate) select L_CT_CT_ID,L_CT_CT_Date,L_CT_CT_GoodsID,L_CT_CT_GoodsQuantity,L_CT_CT_Goodsnottaxrateamount,L_CT_CT_BackFillTaxRate from L_CT_LastMonthCostingTemp ");
		List<String> params = new ArrayList<String>();
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 自动进行加权平均计算
	 */
	public void autoCostAccount(String companyID,List<String> dateList){
		
		StringBuffer sb = null;
		List<String> params = null;
		
		for (String str : dateList){
			
			sb = new StringBuffer();
			params = new ArrayList<String>();
			
			sb.append("insert into L_AT_AutoCostAccount(L_AT_CA_ID,L_AT_CA_CreateDate,L_AT_CA_PaymentDay,L_AT_CA_Flag,L_AT_CA_CompanyID) values(?,getdate(),?,'0',?) ");
			
			params.add(this.uuid.generate());
			params.add(str);
			params.add(companyID);
		}
		
		getJdbcTemplate().update(sb.toString(),params.toArray());		
	}
	
	/**
	 * 初始化查看成本回填单据
	 */
	public int getCostResultBillCount(InventoryPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(cstibillid) from ( ");
		sb.append("select distinct cstibillid,cstibilltypeid,cstidepartmentname,cstibilldate,csticreatepersonname,cstiauditdate,cstiauditpersonname from ( ");
		sb.append("select distinct C_ST_I_BillID as cstibillid,C_ST_I_BillTypeId as cstibilltypeid,B_DP_DepartmentName as cstidepartmentname, ");
		sb.append("       convert(varchar(10),C_ST_I_billDate,120) as cstibilldate,a.personname as csticreatepersonname, ");
		sb.append("       convert(varchar(10),C_ST_I_AuditDate,120) as cstiauditdate,b.personname as cstiauditpersonname ");
		sb.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		sb.append("       left join SYS_PersonInfo a on C_ST_I_createPerson=a.id ");
		sb.append("       left join SYS_PersonInfo b on C_ST_I_AuditPerson=b.id ");
		sb.append("       left join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID ");
		sb.append("       left join B_Departments on C_ST_I_DepartmentId=B_DP_DepartmentID ");
		sb.append("  where C_ST_I_BillTypeId='3' and C_ST_I_AuditState='1' ");		
		if (!"".equals(Utility.getName(po.getCstigoodscategory()))){
			sb.append("  and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getCstigoodscategory()));
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))){
			sb.append("  and B_GI_SupplierID = ? ");
			params.add(Utility.getName(po.getCstisupplierid()));
		}
		if (!"".equals(Utility.getName(po.getCstibrandid()))){
			sb.append("  and B_GI_BrandID = ? ");
			params.add(Utility.getName(po.getCstibrandid()));
		}
		if (!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("  and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsid()));
		}
		if (!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("  and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsname()));
		}
		if (!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append("  and C_ST_I_BillID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstibillid()));
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))){
			sb.append("  and convert(varchar(10),C_ST_I_billDate,120) >= ? ");
			params.add(Utility.getName(po.getCstistartTime()));
		}
		if (!"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("  and convert(varchar(10),C_ST_I_billDate,120) <= ?  ");
			params.add(Utility.getName(po.getCstiendTime()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditstartdate()))){
			sb.append("  and convert(varchar(10),C_ST_I_AuditDate,120) >= ? ");
			params.add(Utility.getName(po.getCstiauditstartdate()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditenddate()))){
			sb.append("  and convert(varchar(10),C_ST_I_AuditDate,120) <= ?  ");
			params.add(Utility.getName(po.getCstiauditenddate()));
		}		
		if (!"".equals(Utility.getName(po.getCsticreateperson()))){
			sb.append("  and C_ST_I_createPerson = ? ");
			params.add(Utility.getName(po.getCsticreateperson()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))){
			sb.append("  and C_ST_I_AuditPerson = ? ");
			params.add(Utility.getName(po.getCstiauditperson()));
		}
		if (!"".equals(Utility.getName(po.getCstiisfillcostprice()))){
			sb.append("  and isnull(C_ST_I_IsFillCostPrice,'0') = ? ");
			params.add(Utility.getName(po.getCstiisfillcostprice()));
		}	
		sb.append("union all ");
		sb.append("select distinct C_ST_I_BillID as cstibillid,C_ST_I_BillTypeId as cstibilltypeid,B_WH_warehouseName as cstidepartmentname, ");
		sb.append("       convert(varchar(10),C_ST_I_billDate,120) as cstibilldate,a.personname as csticreatepersonname, ");
		sb.append("       convert(varchar(10),C_ST_I_AuditDate,120) as cstiauditdate,b.personname as cstiauditpersonname ");
		sb.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		sb.append("       left join SYS_PersonInfo a on C_ST_I_createPerson=a.id ");
		sb.append("       left join SYS_PersonInfo b on C_ST_I_AuditPerson=b.id ");
		sb.append("       left join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID ");
		sb.append("       left join B_Warehouse on C_ST_I_InStockId=B_WH_ID ");
		sb.append("  where C_ST_I_BillTypeId='5' and C_ST_I_AuditState='1' ");		
		if (!"".equals(Utility.getName(po.getCstigoodscategory()))){
			sb.append("  and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getCstigoodscategory()));
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))){
			sb.append("  and B_GI_SupplierID = ? ");
			params.add(Utility.getName(po.getCstisupplierid()));
		}
		if (!"".equals(Utility.getName(po.getCstibrandid()))){
			sb.append("  and B_GI_BrandID = ? ");
			params.add(Utility.getName(po.getCstibrandid()));
		}
		if (!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("  and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsid()));
		}
		if (!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("  and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsname()));
		}
		if (!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append("  and C_ST_I_BillID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstibillid()));
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))){
			sb.append("  and convert(varchar(10),C_ST_I_billDate,120) >= ? ");
			params.add(Utility.getName(po.getCstistartTime()));
		}
		if (!"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("  and convert(varchar(10),C_ST_I_billDate,120) <= ?  ");
			params.add(Utility.getName(po.getCstiendTime()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditstartdate()))){
			sb.append("  and convert(varchar(10),C_ST_I_AuditDate,120) >= ? ");
			params.add(Utility.getName(po.getCstiauditstartdate()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditenddate()))){
			sb.append("  and convert(varchar(10),C_ST_I_AuditDate,120) <= ?  ");
			params.add(Utility.getName(po.getCstiauditenddate()));
		}		
		if (!"".equals(Utility.getName(po.getCsticreateperson()))){
			sb.append("  and C_ST_I_createPerson = ? ");
			params.add(Utility.getName(po.getCsticreateperson()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))){
			sb.append("  and C_ST_I_AuditPerson = ? ");
			params.add(Utility.getName(po.getCstiauditperson()));
		}	
		if (!"".equals(Utility.getName(po.getCstiisfillcostprice()))){
			sb.append("  and isnull(C_ST_I_IsFillCostPrice,'0') = ? ");
			params.add(Utility.getName(po.getCstiisfillcostprice()));
		}	
		sb.append("union all ");
		sb.append("select distinct C_ST_I_BillID as cstibillid,C_ST_I_BillTypeId as cstibilltypeid,B_WH_warehouseName as cstidepartmentname, ");
		sb.append("       convert(varchar(10),C_ST_I_billDate,120) as cstibilldate,a.personname as csticreatepersonname, ");
		sb.append("       convert(varchar(10),C_ST_I_AuditDate,120) as cstiauditdate,b.personname as cstiauditpersonname ");
		sb.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		sb.append("       left join SYS_PersonInfo a on C_ST_I_createPerson=a.id ");
		sb.append("       left join SYS_PersonInfo b on C_ST_I_AuditPerson=b.id ");
		sb.append("       left join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID ");
		sb.append("       left join B_Warehouse on C_ST_I_OutStockId=B_WH_ID ");
		sb.append("  where C_ST_I_BillTypeId='6' and C_ST_I_AuditState='1' ");		
		if (!"".equals(Utility.getName(po.getCstigoodscategory()))){
			sb.append("  and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getCstigoodscategory()));
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))){
			sb.append("  and B_GI_SupplierID = ? ");
			params.add(Utility.getName(po.getCstisupplierid()));
		}
		if (!"".equals(Utility.getName(po.getCstibrandid()))){
			sb.append("  and B_GI_BrandID = ? ");
			params.add(Utility.getName(po.getCstibrandid()));
		}
		if (!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("  and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsid()));
		}
		if (!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("  and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsname()));
		}
		if (!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append("  and C_ST_I_BillID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstibillid()));
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))){
			sb.append("  and convert(varchar(10),C_ST_I_billDate,120) >= ? ");
			params.add(Utility.getName(po.getCstistartTime()));
		}
		if (!"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("  and convert(varchar(10),C_ST_I_billDate,120) <= ?  ");
			params.add(Utility.getName(po.getCstiendTime()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditstartdate()))){
			sb.append("  and convert(varchar(10),C_ST_I_AuditDate,120) >= ? ");
			params.add(Utility.getName(po.getCstiauditstartdate()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditenddate()))){
			sb.append("  and convert(varchar(10),C_ST_I_AuditDate,120) <= ?  ");
			params.add(Utility.getName(po.getCstiauditenddate()));
		}		
		if (!"".equals(Utility.getName(po.getCsticreateperson()))){
			sb.append("  and C_ST_I_createPerson = ? ");
			params.add(Utility.getName(po.getCsticreateperson()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))){
			sb.append("  and C_ST_I_AuditPerson = ? ");
			params.add(Utility.getName(po.getCstiauditperson()));
		}
		if (!"".equals(Utility.getName(po.getCstiisfillcostprice()))){
			sb.append("  and isnull(C_ST_I_IsFillCostPrice,'0') = ? ");
			params.add(Utility.getName(po.getCstiisfillcostprice()));
		}	
		sb.append("union all ");
		sb.append("select distinct C_ST_I_BillID as cstibillid,C_ST_I_BillTypeId as cstibilltypeid,B_DP_DepartmentName as cstidepartmentname, ");
		sb.append("       convert(varchar(10),C_ST_I_billDate,120) as cstibilldate,a.personname as csticreatepersonname, ");
		sb.append("       convert(varchar(10),C_ST_I_FinanceAuditDate,120) as cstiauditdate,b.personname as cstiauditpersonname ");
		sb.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		sb.append("       left join SYS_PersonInfo a on C_ST_I_createPerson=a.id ");
		sb.append("       left join SYS_PersonInfo b on C_ST_I_FinanceAuditPerson=b.id ");
		sb.append("       left join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID ");
		sb.append("       left join B_Departments on C_ST_I_SupplierId=B_DP_DepartmentID ");
		sb.append("  where C_ST_I_BillTypeId='8' and C_ST_I_AuditState='1' and C_ST_I_FinanceAuditState='1' ");		
		if (!"".equals(Utility.getName(po.getCstigoodscategory()))){
			sb.append("  and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getCstigoodscategory()));
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))){
			sb.append("  and B_GI_SupplierID = ? ");
			params.add(Utility.getName(po.getCstisupplierid()));
		}
		if (!"".equals(Utility.getName(po.getCstibrandid()))){
			sb.append("  and B_GI_BrandID = ? ");
			params.add(Utility.getName(po.getCstibrandid()));
		}
		if (!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("  and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsid()));
		}
		if (!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("  and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsname()));
		}
		if (!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append("  and C_ST_I_BillID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstibillid()));
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))){
			sb.append("  and convert(varchar(10),C_ST_I_billDate,120) >= ? ");
			params.add(Utility.getName(po.getCstistartTime()));
		}
		if (!"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("  and convert(varchar(10),C_ST_I_billDate,120) <= ?  ");
			params.add(Utility.getName(po.getCstiendTime()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditstartdate()))){
			sb.append("  and convert(varchar(10),C_ST_I_FinanceAuditDate,120) >= ? ");
			params.add(Utility.getName(po.getCstiauditstartdate()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditenddate()))){
			sb.append("  and convert(varchar(10),C_ST_I_FinanceAuditDate,120) <= ?  ");
			params.add(Utility.getName(po.getCstiauditenddate()));
		}		
		if (!"".equals(Utility.getName(po.getCsticreateperson()))){
			sb.append("  and C_ST_I_createPerson = ? ");
			params.add(Utility.getName(po.getCsticreateperson()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))){
			sb.append("  and C_ST_I_FinanceAuditPerson = ? ");
			params.add(Utility.getName(po.getCstiauditperson()));
		}
		if (!"".equals(Utility.getName(po.getCstiisfillcostprice()))){
			sb.append("  and isnull(C_ST_I_IsFillCostPrice,'0') = ? ");
			params.add(Utility.getName(po.getCstiisfillcostprice()));
		}
		sb.append(")temp where 1=1 ");
		if (!"".equals(Utility.getName(po.getCstibilltypeid()))){
			sb.append("  and cstibilltypeid = ? ");
			params.add(Utility.getName(po.getCstibilltypeid()));
		}
		sb.append(")temp ");
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查看成本回填单据
	 */
	public List<InventoryPo> getCostResultBillList(InventoryPo po,int start , int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select * from ( ");	
		sb.append("SELECT ROW_NUMBER() Over(ORDER BY cstiauditdate desc) AS rowNum,");
		sb.append(" cstibillid,cstibilltypeid,cstidepartmentname,cstibilldate,csticreatepersonname,cstiauditdate,cstiauditpersonname from ( ");
		sb.append("select distinct cstibillid,cstibilltypeid,cstidepartmentname,cstibilldate,csticreatepersonname,cstiauditdate,cstiauditpersonname from ( ");
		sb.append("select distinct C_ST_I_BillID as cstibillid,C_ST_I_BillTypeId as cstibilltypeid,B_DP_DepartmentName as cstidepartmentname, ");
		sb.append("       convert(varchar(10),C_ST_I_billDate,120) as cstibilldate,a.personname as csticreatepersonname, ");
		sb.append("       convert(varchar(10),C_ST_I_AuditDate,120) as cstiauditdate,b.personname as cstiauditpersonname ");
		sb.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		sb.append("       left join SYS_PersonInfo a on C_ST_I_createPerson=a.id ");
		sb.append("       left join SYS_PersonInfo b on C_ST_I_AuditPerson=b.id ");
		sb.append("       left join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID ");
		sb.append("       left join B_Departments on C_ST_I_DepartmentId=B_DP_DepartmentID ");
		sb.append("  where C_ST_I_BillTypeId='3' and C_ST_I_AuditState='1' ");		
		if (!"".equals(Utility.getName(po.getCstigoodscategory()))){
			sb.append("  and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getCstigoodscategory()));
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))){
			sb.append("  and B_GI_SupplierID = ? ");
			params.add(Utility.getName(po.getCstisupplierid()));
		}
		if (!"".equals(Utility.getName(po.getCstibrandid()))){
			sb.append("  and B_GI_BrandID = ? ");
			params.add(Utility.getName(po.getCstibrandid()));
		}
		if (!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("  and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsid()));
		}
		if (!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("  and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsname()));
		}
		if (!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append("  and C_ST_I_BillID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstibillid()));
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))){
			sb.append("  and convert(varchar(10),C_ST_I_billDate,120) >= ? ");
			params.add(Utility.getName(po.getCstistartTime()));
		}
		if (!"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("  and convert(varchar(10),C_ST_I_billDate,120) <= ?  ");
			params.add(Utility.getName(po.getCstiendTime()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditstartdate()))){
			sb.append("  and convert(varchar(10),C_ST_I_AuditDate,120) >= ? ");
			params.add(Utility.getName(po.getCstiauditstartdate()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditenddate()))){
			sb.append("  and convert(varchar(10),C_ST_I_AuditDate,120) <= ?  ");
			params.add(Utility.getName(po.getCstiauditenddate()));
		}		
		if (!"".equals(Utility.getName(po.getCsticreateperson()))){
			sb.append("  and C_ST_I_createPerson = ? ");
			params.add(Utility.getName(po.getCsticreateperson()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))){
			sb.append("  and C_ST_I_AuditPerson = ? ");
			params.add(Utility.getName(po.getCstiauditperson()));
		}		
		if (!"".equals(Utility.getName(po.getCstiisfillcostprice()))){
			sb.append("  and isnull(C_ST_I_IsFillCostPrice,'0') = ? ");
			params.add(Utility.getName(po.getCstiisfillcostprice()));
		}	
		sb.append("union all ");
		sb.append("select distinct C_ST_I_BillID as cstibillid,C_ST_I_BillTypeId as cstibilltypeid,B_WH_warehouseName as cstidepartmentname, ");
		sb.append("       convert(varchar(10),C_ST_I_billDate,120) as cstibilldate,a.personname as csticreatepersonname, ");
		sb.append("       convert(varchar(10),C_ST_I_AuditDate,120) as cstiauditdate,b.personname as cstiauditpersonname ");
		sb.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		sb.append("       left join SYS_PersonInfo a on C_ST_I_createPerson=a.id ");
		sb.append("       left join SYS_PersonInfo b on C_ST_I_AuditPerson=b.id ");
		sb.append("       left join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID ");
		sb.append("       left join B_Warehouse on C_ST_I_InStockId=B_WH_ID ");
		sb.append("  where C_ST_I_BillTypeId='5' and C_ST_I_AuditState='1' ");		
		if (!"".equals(Utility.getName(po.getCstigoodscategory()))){
			sb.append("  and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getCstigoodscategory()));
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))){
			sb.append("  and B_GI_SupplierID = ? ");
			params.add(Utility.getName(po.getCstisupplierid()));
		}
		if (!"".equals(Utility.getName(po.getCstibrandid()))){
			sb.append("  and B_GI_BrandID = ? ");
			params.add(Utility.getName(po.getCstibrandid()));
		}
		if (!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("  and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsid()));
		}
		if (!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("  and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsname()));
		}
		if (!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append("  and C_ST_I_BillID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstibillid()));
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))){
			sb.append("  and convert(varchar(10),C_ST_I_billDate,120) >= ? ");
			params.add(Utility.getName(po.getCstistartTime()));
		}
		if (!"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("  and convert(varchar(10),C_ST_I_billDate,120) <= ?  ");
			params.add(Utility.getName(po.getCstiendTime()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditstartdate()))){
			sb.append("  and convert(varchar(10),C_ST_I_AuditDate,120) >= ? ");
			params.add(Utility.getName(po.getCstiauditstartdate()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditenddate()))){
			sb.append("  and convert(varchar(10),C_ST_I_AuditDate,120) <= ?  ");
			params.add(Utility.getName(po.getCstiauditenddate()));
		}		
		if (!"".equals(Utility.getName(po.getCsticreateperson()))){
			sb.append("  and C_ST_I_createPerson = ? ");
			params.add(Utility.getName(po.getCsticreateperson()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))){
			sb.append("  and C_ST_I_AuditPerson = ? ");
			params.add(Utility.getName(po.getCstiauditperson()));
		}	
		if (!"".equals(Utility.getName(po.getCstiisfillcostprice()))){
			sb.append("  and isnull(C_ST_I_IsFillCostPrice,'0') = ? ");
			params.add(Utility.getName(po.getCstiisfillcostprice()));
		}	
		sb.append("union all ");
		sb.append("select distinct C_ST_I_BillID as cstibillid,C_ST_I_BillTypeId as cstibilltypeid,B_WH_warehouseName as cstidepartmentname, ");
		sb.append("       convert(varchar(10),C_ST_I_billDate,120) as cstibilldate,a.personname as csticreatepersonname, ");
		sb.append("       convert(varchar(10),C_ST_I_AuditDate,120) as cstiauditdate,b.personname as cstiauditpersonname ");
		sb.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		sb.append("       left join SYS_PersonInfo a on C_ST_I_createPerson=a.id ");
		sb.append("       left join SYS_PersonInfo b on C_ST_I_AuditPerson=b.id ");
		sb.append("       left join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID ");
		sb.append("       left join B_Warehouse on C_ST_I_OutStockId=B_WH_ID ");
		sb.append("  where C_ST_I_BillTypeId='6' and C_ST_I_AuditState='1' ");		
		if (!"".equals(Utility.getName(po.getCstigoodscategory()))){
			sb.append("  and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getCstigoodscategory()));
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))){
			sb.append("  and B_GI_SupplierID = ? ");
			params.add(Utility.getName(po.getCstisupplierid()));
		}
		if (!"".equals(Utility.getName(po.getCstibrandid()))){
			sb.append("  and B_GI_BrandID = ? ");
			params.add(Utility.getName(po.getCstibrandid()));
		}
		if (!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("  and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsid()));
		}
		if (!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("  and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsname()));
		}
		if (!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append("  and C_ST_I_BillID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstibillid()));
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))){
			sb.append("  and convert(varchar(10),C_ST_I_billDate,120) >= ? ");
			params.add(Utility.getName(po.getCstistartTime()));
		}
		if (!"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("  and convert(varchar(10),C_ST_I_billDate,120) <= ?  ");
			params.add(Utility.getName(po.getCstiendTime()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditstartdate()))){
			sb.append("  and convert(varchar(10),C_ST_I_AuditDate,120) >= ? ");
			params.add(Utility.getName(po.getCstiauditstartdate()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditenddate()))){
			sb.append("  and convert(varchar(10),C_ST_I_AuditDate,120) <= ?  ");
			params.add(Utility.getName(po.getCstiauditenddate()));
		}		
		if (!"".equals(Utility.getName(po.getCsticreateperson()))){
			sb.append("  and C_ST_I_createPerson = ? ");
			params.add(Utility.getName(po.getCsticreateperson()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))){
			sb.append("  and C_ST_I_AuditPerson = ? ");
			params.add(Utility.getName(po.getCstiauditperson()));
		}
		if (!"".equals(Utility.getName(po.getCstiisfillcostprice()))){
			sb.append("  and isnull(C_ST_I_IsFillCostPrice,'0') = ? ");
			params.add(Utility.getName(po.getCstiisfillcostprice()));
		}	
		sb.append("union all ");
		sb.append("select distinct C_ST_I_BillID as cstibillid,C_ST_I_BillTypeId as cstibilltypeid,B_DP_DepartmentName as cstidepartmentname, ");
		sb.append("       convert(varchar(10),C_ST_I_billDate,120) as cstibilldate,a.personname as csticreatepersonname, ");
		sb.append("       convert(varchar(10),C_ST_I_FinanceAuditDate,120) as cstiauditdate,b.personname as cstiauditpersonname ");
		sb.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		sb.append("       left join SYS_PersonInfo a on C_ST_I_createPerson=a.id ");
		sb.append("       left join SYS_PersonInfo b on C_ST_I_FinanceAuditPerson=b.id ");
		sb.append("       left join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID ");
		sb.append("       left join B_Departments on C_ST_I_SupplierId=B_DP_DepartmentID ");
		sb.append("  where C_ST_I_BillTypeId='8' and C_ST_I_AuditState='1' and C_ST_I_FinanceAuditState='1' ");		
		if (!"".equals(Utility.getName(po.getCstigoodscategory()))){
			sb.append("  and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getCstigoodscategory()));
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))){
			sb.append("  and B_GI_SupplierID = ? ");
			params.add(Utility.getName(po.getCstisupplierid()));
		}
		if (!"".equals(Utility.getName(po.getCstibrandid()))){
			sb.append("  and B_GI_BrandID = ? ");
			params.add(Utility.getName(po.getCstibrandid()));
		}
		if (!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("  and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsid()));
		}
		if (!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("  and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsname()));
		}
		if (!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append("  and C_ST_I_BillID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstibillid()));
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))){
			sb.append("  and convert(varchar(10),C_ST_I_billDate,120) >= ? ");
			params.add(Utility.getName(po.getCstistartTime()));
		}
		if (!"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("  and convert(varchar(10),C_ST_I_billDate,120) <= ?  ");
			params.add(Utility.getName(po.getCstiendTime()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditstartdate()))){
			sb.append("  and convert(varchar(10),C_ST_I_FinanceAuditDate,120) >= ? ");
			params.add(Utility.getName(po.getCstiauditstartdate()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditenddate()))){
			sb.append("  and convert(varchar(10),C_ST_I_FinanceAuditDate,120) <= ?  ");
			params.add(Utility.getName(po.getCstiauditenddate()));
		}		
		if (!"".equals(Utility.getName(po.getCsticreateperson()))){
			sb.append("  and C_ST_I_createPerson = ? ");
			params.add(Utility.getName(po.getCsticreateperson()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))){
			sb.append("  and C_ST_I_FinanceAuditPerson = ? ");
			params.add(Utility.getName(po.getCstiauditperson()));
		}
		if (!"".equals(Utility.getName(po.getCstiisfillcostprice()))){
			sb.append("  and isnull(C_ST_I_IsFillCostPrice,'0') = ? ");
			params.add(Utility.getName(po.getCstiisfillcostprice()));
		}	
		sb.append(")temp where 1=1 ");
		if (!"".equals(Utility.getName(po.getCstibilltypeid()))){
			sb.append("  and cstibilltypeid = ? ");
			params.add(Utility.getName(po.getCstibilltypeid()));
		}
		
		sb.append(" )temp ) temp where rowNum > " + start + " and rowNum <= " + countPage);
		sb.append(" set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(), InventoryPo.class);
	}
	
	/**
	 * 成本回填单据
	 */
	public void updateBillAvgCostByCal(String date){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("exec usp_updateBillAvgCostByCal ? ");
		
		params.add(date);
		
		getJdbcTemplate().update(sb.toString(),params.toArray());		
	}
	
	public void realCalStorage(List<AutoCostAccountPo> acaList,String flag,String companyID,String htbillflag){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		for (AutoCostAccountPo acapo : acaList){
			
			sb.append("exec usp_costAccount ?,?,? ");    // 计算加权平均成本
			
			params.add(acapo.getLatcapaymentday());
			params.add(companyID);
			params.add(flag);
			
			if (!"".equals(htbillflag)){
				
				sb.append("exec usp_updateBillAvgCostByCal ?,? ");    // 回填单据
				
				params.add(acapo.getLatcapaymentday());
				params.add(companyID);
			}
			
	    }
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void updateBillAvgCostByCal(String date,String companyID){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("exec usp_Company_updateBillAvgCostByCal ?,? ");
		
		params.add(date);
		params.add(companyID);
		
		getJdbcTemplate().update(sb.toString(),params.toArray());	
	}
	
	/**
	 * 自动进行成本计算完成
	 */
	public void autoCostAccountFinish(List<AutoCostAccountPo> acaList,String companyID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		for (AutoCostAccountPo acapo : acaList){
			buffer.append("update L_AT_AutoCostAccount set L_AT_CA_ExecDate=getdate(),L_AT_CA_Flag='1' where L_AT_CA_PaymentDay=? ");
			
			params.add(acapo.getLatcapaymentday()); 
			
			if (!"".equals(companyID)){
				buffer.append(" and L_AT_CA_CompanyID = ? ");
				params.add(companyID); 
			}
		}
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void updateAccountPeriodSet(String companyID,String year,String month){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if (!"".equals(companyID)){
			buffer.append("delete from L_SA_SwitchAmount where L_SA_CompanyID = ? ");
			
			buffer.append("insert into L_SA_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth,L_SA_CompanyID) ");
			buffer.append("  values (1,?,'01','0',?) ");
			buffer.append("insert into L_SA_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth,L_SA_CompanyID) ");
			buffer.append("  values (2,?,'02','0',?) ");
			buffer.append("insert into L_SA_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth,L_SA_CompanyID) ");
			buffer.append("  values (3,?,'03','0',?) ");
			buffer.append("insert into L_SA_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth,L_SA_CompanyID) ");
			buffer.append("  values (4,?,'04','0',?) ");
			buffer.append("insert into L_SA_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth,L_SA_CompanyID) ");
			buffer.append("  values (5,?,'05','0',?) ");
			buffer.append("insert into L_SA_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth,L_SA_CompanyID) ");
			buffer.append("  values (6,?,'06','0',?) ");
			buffer.append("insert into L_SA_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth,L_SA_CompanyID) ");
			buffer.append("  values (7,?,'07','0',?) ");
			buffer.append("insert into L_SA_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth,L_SA_CompanyID) ");
			buffer.append("  values (8,?,'08','0',?) ");
			buffer.append("insert into L_SA_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth,L_SA_CompanyID) ");
			buffer.append("  values (9,?,'09','0',?) ");
			buffer.append("insert into L_SA_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth,L_SA_CompanyID) ");
			buffer.append("  values (10,?,'10','0',?) ");
			buffer.append("insert into L_SA_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth,L_SA_CompanyID) ");
			buffer.append("  values (11,?,'11','0',?) ");
			buffer.append("insert into L_SA_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth,L_SA_CompanyID) ");
			buffer.append("  values (12,?,'12','0',?) ");
						
			buffer.append("update top (1) L_SA_SwitchAmount set L_SA_CurrentMonth = '1' where L_SA_CompanyID = ? and L_SA_Month = ? ");
			
			params.add(companyID);
			
			params.add(year); 
			params.add(companyID);
			params.add(year);	
			params.add(companyID);
			params.add(year);  
			params.add(companyID);
			params.add(year);
			params.add(companyID);
			params.add(year); 
			params.add(companyID);
			params.add(year);
			params.add(companyID);
			params.add(year);
			params.add(companyID);
			params.add(year); 
			params.add(companyID);
			params.add(year); 
			params.add(companyID);
			params.add(year); 
			params.add(companyID);
			params.add(year); 
			params.add(companyID);
			params.add(year); 
			params.add(companyID);

			params.add(companyID); 
			params.add(month); 
			
		}else{
			buffer.append("delete from L_SA_ALL_SwitchAmount ");
			
			buffer.append("insert into L_SA_ALL_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth) ");
			buffer.append("  values (1,?,'01','0') ");
			buffer.append("insert into L_SA_ALL_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth) ");
			buffer.append("  values (2,?,'02','0') ");
			buffer.append("insert into L_SA_ALL_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth) ");
			buffer.append("  values (3,?,'03','0') ");
			buffer.append("insert into L_SA_ALL_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth) ");
			buffer.append("  values (4,?,'04','0') ");
			buffer.append("insert into L_SA_ALL_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth) ");
			buffer.append("  values (5,?,'05','0') ");
			buffer.append("insert into L_SA_ALL_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth) ");
			buffer.append("  values (6,?,'06','0') ");
			buffer.append("insert into L_SA_ALL_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth) ");
			buffer.append("  values (7,?,'07','0') ");
			buffer.append("insert into L_SA_ALL_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth) ");
			buffer.append("  values (8,?,'08','0') ");
			buffer.append("insert into L_SA_ALL_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth) ");
			buffer.append("  values (9,?,'09','0') ");
			buffer.append("insert into L_SA_ALL_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth) ");
			buffer.append("  values (10,?,'10','0') ");
			buffer.append("insert into L_SA_ALL_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth) ");
			buffer.append("  values (11,?,'11','0') ");
			buffer.append("insert into L_SA_ALL_SwitchAmount (L_SA_ID,L_SA_Year,L_SA_Month,L_SA_CurrentMonth) ");
			buffer.append("  values (12,?,'12','0') ");
						
			buffer.append("update top (1) L_SA_ALL_SwitchAmount set L_SA_CurrentMonth = '1' where L_SA_Month = ? ");
			
			params.add(year); 
			params.add(year); 
			params.add(year); 
			params.add(year);
			params.add(year); 
			params.add(year);
			params.add(year); 
			params.add(year);
			params.add(year); 
			params.add(year);
			params.add(year); 
			params.add(year); 
			
			params.add(month);
		}
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	
} 
