package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.fr.report.core.A.U;
import com.pengsheng.eims.storage.dao.TakeOutDao;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class TakeOutDaoImpl extends BaseJdbcDaoSupport  implements TakeOutDao {

	public InventoryPo getSalesOut(InventoryPo po) {
		StringBuffer sb=new StringBuffer();	
		
		sb.append("select top 1 ");
		
		sb.append("C_ST_I_BillID as cstibillid,");
		sb.append("C_ST_I_SourceBillId as cstisourcebillid,");
		sb.append("C_ST_I_billDate as cstibilldate,");
		sb.append("C_ST_I_OutStockId as cstioutstockid,");
		sb.append("house.B_WH_warehouseName as cstioutstockname,");
		sb.append("C_ST_I_SupplierId as cstisupplierid,");
		sb.append("B_Customer.B_CT_CustomerName as cstisuppliername,");
		sb.append("C_ST_I_DepartmentId as cstidepartmentid,");
		//sb.append("B_DP_DepartmentName as cstidepartmentname,");
		sb.append("C_ST_I_createPerson as csticreateperson,");
		sb.append("C_ST_I_AuditPerson as cstiauditperson,");
		sb.append("a.personName as csticreatepersonname,");
		sb.append("b.personName as cstiauditpersonname,");
		sb.append("C_ST_I_AuditState as cstiauditstate,");
		sb.append("C_ST_I_AuditDate as cstiauditdate,");
		sb.append("C_ST_I_Remark as cstiremark,");
		sb.append("C_ST_I_TakeType as cstitaketype, ");
		sb.append("case ");
		sb.append("when C_ST_I_TakeType = '1' then (select B_DP_DepartmentName from B_departments where B_DP_DepartmentID=C_ST_I_DepartmentId) ");
		sb.append("when C_ST_I_TakeType = '2' then (select B_FS_StoreName from B_Franchisee where B_FS_StoreID=C_ST_I_DepartmentId) ");
		sb.append("end as cstidepartmentname ");
		sb.append(" from C_ST_TakeInventory ");
		sb.append("left join B_Customer on C_ST_TakeInventory.C_ST_I_SupplierId=B_Customer.B_CT_ID ");
		
		sb.append("left join (select B_WH_ID , B_WH_warehouseName from B_Warehouse ) house ");
		sb.append("on house.B_WH_ID = C_ST_TakeInventory.C_ST_I_OutStockId ");
		
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_TakeInventory.C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_TakeInventory.C_ST_I_AuditPerson=b.ID ");
		
		sb.append("where C_ST_I_BillID='"+po.getCstibillid()+"'");
		
		return (InventoryPo)queryForObject(sb.toString(), null, InventoryPo.class);
	}

	public List<InventoryEntryPo> getSalesOutEntryList(InventoryPo po) {
		StringBuffer sb=new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("select ");
		sb.append("C_ST_IE_ID as cstieid,");
		sb.append("C_ST_IE_GoodsId as cstiegoodsid,");
		sb.append("B_GoodsInfo.B_GI_ViewGoodsName as cstiegoodsname,");
		sb.append("C_ST_IE_GoodsQuantity as cstiegoodsquantity,");
		sb.append("B_GoodsInfo.B_GI_Spec as cstiespec,");		
		sb.append("C_ST_IE_NotTaxRate as cstienottaxrate,");
		sb.append("C_ST_IE_NotTaxRateAmount as cstienottaxrateamount,");
		sb.append("C_ST_IE_TaxRate as cstietaxrate,");
		sb.append("C_ST_IE_CostPrice as cstiecostprice,");
		sb.append("C_ST_IE_CostPriceAmount as cstiecostpriceamount,");
		sb.append("C_ST_IE_TaxAmount as cstietaxamount,");		
		sb.append("C_ST_IE_OutStockId as cstieoutstockid,");
		sb.append("C_ST_IE_BarCode as cstiebarcode,");
		sb.append("C_ST_IE_WarehousingDate as cstiewarehousingdate,isnull(C_ST_IE_OutStorageFlag,'1') as cstieoutstorageflag, ");
		sb.append("C_ST_IE_TakePrice as cstietakeprice,");
		sb.append("C_ST_IE_TakePriceAmount as cstietakepriceamount, ");
		sb.append("isnull(kucun.GoodsQuantity,0)+isnull(zaitu.GoodsNum,0) as cstiemaxquantity ");
		sb.append(" from C_ST_TakeInventoryEntry ");
		sb.append("left join B_GoodsInfo on C_ST_TakeInventoryEntry.C_ST_IE_GoodsId=B_GoodsInfo.B_GI_GoodsID ");
		
		sb.append("LEFT JOIN (SELECT		 C_SH_SL_GoodsBarCode  AS GoodsBarCode, ");
		sb.append("        isnull(sum(C_SH_Sl_GoodsQuantity),0) AS GoodsQuantity, ");
		sb.append("        C_SH_Sl_StockId       AS StockId ");
		sb.append(" FROM   C_SH_StorageLog ");
		sb.append(" WHERE  1 = 1 ");
		sb.append(" AND C_SH_SL_StockId = (select C_ST_I_OutStockId from C_ST_TakeInventory where C_ST_I_BillID = ?) ");
		params.add(po.getCstibillid());
		sb.append(" GROUP  BY C_SH_SL_GoodsBarCode, ");
		sb.append("   C_SH_Sl_StockId) kucun ");
		sb.append(" ON C_ST_IE_BarCode = kucun.GoodsBarCode ");
		sb.append(" LEFT JOIN (SELECT C_SH_TSE_GoodsBarCode  AS GoodsBarCode, ");
		sb.append(" isnull(SUM(C_SH_TSE_GoodsNum),0) AS GoodsNum ");
        sb.append(" FROM   C_SH_InTransitStorageEntry ");
        sb.append(" WHERE  1 = 1 ");
        sb.append("        AND C_SH_TSE_OUTStockID = (select C_ST_I_OutStockId from C_ST_TakeInventory where C_ST_I_BillID = ?) ");
        params.add(po.getCstibillid());
        if (!"".equals(Utility.getName(po.getCstibillid()))) {
			sb.append(" and C_SH_TSE_BillID <> ? ");
			params.add(po.getCstibillid());
		}
        sb.append(" GROUP  BY C_SH_TSE_GoodsBarCode)zaitu ");
        sb.append("ON C_ST_IE_BarCode = zaitu.GoodsBarCode ");
		
		sb.append("where C_ST_IE_BillID='"+po.getCstibillid()+"'");		
		
		return queryForObjectList(sb.toString(), params.toArray(), InventoryEntryPo.class);
	}

	public int getSalesOutCount(InventoryPo po) {
		
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(distinct C_ST_TakeInventory.C_ST_I_BillID) from C_ST_TakeInventory ");
		
		sb.append("inner join C_ST_TakeInventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		sb.append("left join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID ");
	
		sb.append("left join B_Warehouse on C_ST_I_OutStockId=B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");		
		sb.append("left join (select B_WH_ID , B_WH_warehouseName from B_Warehouse ) house ");
		sb.append("on house.B_WH_ID = C_ST_TakeInventory.C_ST_I_OutStockId ");		
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_TakeInventory.C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_TakeInventory.C_ST_I_AuditPerson=b.ID where 1=1 and C_ST_I_BillTypeId='3'");
		
		if (!"".equals(Utility.getName(po.getCsticompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCsticompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append("and C_ST_I_BillID like '%"+po.getCstibillid()+"%' ");//quyanping
		}
//		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
//			sb.append("and C_ST_I_SupplierId='"+po.getCstisupplierid()+"' ");
//		}
		if(!"".equals(Utility.getName(po.getCstioutstockid()))){
			sb.append("and C_ST_I_OutStockId='"+po.getCstioutstockid()+"' ");
		}
		if(!"".equals(Utility.getName(po.getCstidepartmentid()))){
			sb.append("and C_ST_I_DepartmentId='"+po.getCstidepartmentid()+"' ");
		}		
		if(!"".equals(Utility.getName(po.getCstiauditstate()))){
			sb.append("and C_ST_I_AuditState='"+po.getCstiauditstate()+"' ");
		}
		if(!"".equals(Utility.getName(po.getCstistartTime())) && !"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= '"+po.getCstistartTime()+"' ");
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= '"+po.getCstiendTime()+"' ");
		}else if(!"".equals(Utility.getName(po.getCstistartTime())) && "".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= '"+po.getCstistartTime()+"' ");
		}else if("".equals(Utility.getName(po.getCstistartTime())) && !"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= '"+po.getCstiendTime()+"' ");
		}	
		if(!"".equals(Utility.getName(po.getCstiremark()))){
			sb.append("and C_ST_I_Remark like '%"+po.getCstiremark()+"%' ");
		}
		if(!"".equals(Utility.getName(po.getCstitaketype()))){
			sb.append("and C_ST_I_TakeType = '"+po.getCstitaketype()+"' ");
		}
		
		if(!"".equals(Utility.getName(po.getCstisupplierid()))){
			sb.append("and B_GI_SupplierID = '"+Utility.getName(po.getCstisupplierid())+"' ");
		}
		if(!"".equals(Utility.getName(po.getCstibrandid()))){
			sb.append("and B_GI_BrandID = '"+Utility.getName(po.getCstibrandid())+"' ");
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

	public List<InventoryPo> getSalesOutList(InventoryPo po,
			int start, int size) {
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from(select ROW_NUMBER() ");
		sb.append("Over(order by cstibilldate desc) as rowNum,* from ( ");
		sb.append("select distinct C_ST_I_BillID as cstibillid,");
		sb.append("C_ST_I_BillTypeId as cstibilltypeid,");
		sb.append("C_ST_I_billDate as cstibilldate,");
		sb.append("C_ST_I_AuditDate as cstiauditdate,");
		sb.append("house.B_WH_warehouseName as cstioutstockname,");
		sb.append("C_ST_I_AuditState as cstiauditstate,");
		sb.append("a.personName as csticreatepersonname,");
		sb.append("b.personName as cstiauditpersonname,");
//		sb.append("B_CT_CustomerName as cstisuppliername,");
		sb.append("case ");
		sb.append("when C_ST_I_TakeType = '1' then (select B_DP_DepartmentName from B_departments where B_DP_DepartmentID=C_ST_I_DepartmentId) ");
		sb.append("when C_ST_I_TakeType = '2' then (select B_FS_StoreName from B_Franchisee where B_FS_StoreID=C_ST_I_DepartmentId) ");
		sb.append("end as cstidepartmentname, ");
		sb.append("C_ST_TakeInventory.C_ST_I_Remark as cstiremark");
		
		sb.append(" from C_ST_TakeInventory ");
		sb.append("inner join C_ST_TakeInventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		sb.append("left join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID ");
		
		sb.append("left join B_Warehouse on C_ST_I_OutStockId=B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID  ");		
		sb.append("left join (select B_WH_ID , B_WH_warehouseName from B_Warehouse ) house ");
		sb.append("on house.B_WH_ID = C_ST_TakeInventory.C_ST_I_OutStockId ");		
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_I_AuditPerson=b.ID");
		
		sb.append(" where 1=1 and C_ST_I_BillTypeId='3'");
		
		if (!"".equals(Utility.getName(po.getCsticompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCsticompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append("and C_ST_I_BillID like '%"+po.getCstibillid()+"%' ");//quyanping
		}
		if (!"".equals(Utility.getName(po.getCstidepartmentid()))) {
			sb.append("and C_ST_I_DepartmentId='"+po.getCstidepartmentid()+"' ");
		}
//		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
//			sb.append("and C_ST_I_SupplierId='"+po.getCstisupplierid()+"' ");
//		}		
		if(!"".equals(Utility.getName(po.getCstioutstockid()))){
			sb.append("and C_ST_I_OutStockId='"+po.getCstioutstockid()+"' ");
		}
		if(!"".equals(Utility.getName(po.getCstidepartmentid()))){
			sb.append("and C_ST_I_DepartmentId='"+po.getCstidepartmentid()+"' ");
		}				
		if(!"".equals(Utility.getName(po.getCstiauditstate()))){
			sb.append("and C_ST_I_AuditState='"+po.getCstiauditstate()+"' ");
		}
		if(!"".equals(Utility.getName(po.getCstistartTime())) && !"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= '"+po.getCstistartTime()+"' ");
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= '"+po.getCstiendTime()+"' ");
		}else if(!"".equals(Utility.getName(po.getCstistartTime())) && "".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= '"+po.getCstistartTime()+"' ");
		}else if("".equals(Utility.getName(po.getCstistartTime())) && !"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= '"+po.getCstiendTime()+"' ");
		}	
		if(!"".equals(Utility.getName(po.getCstiremark()))){
			sb.append("and C_ST_I_Remark like '%"+po.getCstiremark()+"%' ");
		}
		if(!"".equals(Utility.getName(po.getCstitaketype()))){
			sb.append("and C_ST_I_TakeType = '"+po.getCstitaketype()+"' ");
		}
		if(!"".equals(Utility.getName(po.getCstisupplierid()))){
			sb.append("and B_GI_SupplierID = '"+Utility.getName(po.getCstisupplierid())+"' ");
		}
		if(!"".equals(Utility.getName(po.getCstibrandid()))){
			sb.append("and B_GI_BrandID = '"+Utility.getName(po.getCstibrandid())+"' ");
		}
		
		sb.append(" )temp ) temp where rowNum > "+start+" and rowNum <= "+ (start + size));
		sb.append("set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), InventoryPo.class);
	}

	public void updateSalesOut(InventoryPo po) {
		StringBuffer sb=new StringBuffer();
		sb.append("update C_ST_TakeInventory set ");
		
		sb.append("C_ST_I_InStockId='"+Utility.getName(po.getCstiinstockid())+"',");
		sb.append("C_ST_I_AuditState='"+po.getCstiauditstate()+"',");
		sb.append("C_ST_I_FinanceAuditState='"+po.getCstifinanceauditstate()+"',");
		sb.append("C_ST_I_Remark='"+po.getCstiremark()+"' ");
		if(!"".equals(Utility.getName(po.getCstiauditperson()))){
			sb.append(",C_ST_I_AuditPerson='"+po.getCstiauditperson()+"',C_ST_I_AuditDate=getdate()");
		}
		
		if(!"".equals(Utility.getName(po.getCstisourcebillid()))){
			sb.append(",C_ST_I_SourceBillId='"+po.getCstisourcebillid()+"' ");
		}
		
		sb.append(" where C_ST_TakeInventory.C_ST_I_BillID='"+po.getCstibillid()+"'");
		getJdbcTemplate().update(sb.toString());
	}
	
	//反添加负调拨的状态（对于销售出库新增）
	public void insertAllocationStatus(InventoryPo inventoryPo) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("UPDATE C_SHA_Allocation ");
		sb.append("SET ");
		sb.append("C_SHA_A_SalesOutStatus = '1' ");
		sb.append("WHERE C_SHA_A_billID = ? ");
		params.add(inventoryPo.getCstisourcebillid());

		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public void insertSalesOut(InventoryPo po) {
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		sb1.append("insert into C_ST_TakeInventory(");
		sb1.append("C_ST_I_BillID,");
		sb1.append("C_ST_I_BillTypeId,");
		sb1.append("C_ST_I_billDate,");
		sb1.append("C_ST_I_SupplierId,");
		sb1.append("C_ST_I_OutStockId,");
		sb1.append("C_ST_I_DepartmentId,");
		sb1.append("C_ST_I_createPerson,");
		sb1.append("C_ST_I_AuditState,");
		sb1.append("C_ST_I_FinanceAuditState,");
		sb1.append("C_ST_I_Remark");
		
		sb2.append("'"+po.getCstibillid()+"',");
		sb2.append("'3',");
		sb2.append("getdate(),");
		sb2.append("'"+po.getCstisupplierid()+"',");
		sb2.append("'"+po.getCstioutstockid()+"',");
		sb2.append("'"+po.getCstidepartmentid()+"',");
		sb2.append("'"+po.getCsticreateperson()+"',");
		sb2.append("'"+po.getCstiauditstate()+"',");
		sb2.append("'"+po.getCstifinanceauditstate()+"',");
		sb2.append("'"+po.getCstiremark()+"'");
		if(!"".equals(Utility.getName(po.getCstiauditperson()))){
			sb1.append(",C_ST_I_AuditPerson,C_ST_I_AuditDate");
			sb2.append(",'"+po.getCstiauditperson()+"',getdate()");
		}
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			sb1.append(",C_ST_I_SourceBillId");
			sb2.append(",'"+po.getCstisourcebillid()+"'");
		}
		
		sb1.append(",C_ST_I_TakeType");
		sb2.append(",'"+po.getCstitaketype()+"'");
		
		String sql=sb1.toString()+")values("+sb2.toString()+")";
		getJdbcTemplate().update(sql);
	}
	
	public void insertSalesOutEntry(InventoryEntryPo po) {
		
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
				
		sb.append("insert into C_ST_TakeInventoryEntry(");
		sb.append("C_ST_IE_ID,");
		sb.append("C_ST_IE_BillID,");
		sb.append("C_ST_IE_GoodsId,");
		sb.append("C_ST_IE_BarCode,");
		sb.append("C_ST_IE_GoodsQuantity,");
		sb.append("C_ST_IE_NotTaxRate,");
		sb.append("C_ST_IE_NotTaxRateAmount,");
		sb.append("C_ST_IE_TaxRate,");
		sb.append("C_ST_IE_CostPrice,");
		sb.append("C_ST_IE_CostPriceAmount,");
		sb.append("C_ST_IE_TaxAmount,");
		sb.append("C_ST_IE_OutStockId,");
		sb.append("C_ST_IE_WarehousingDate,");
		sb.append("C_ST_IE_OutStorageFlag, ");
		sb.append("C_ST_IE_TakePrice, ");
		sb.append("C_ST_IE_TakePriceAmount ");
		sb.append(") values(");
		
		sb.append("'"+this.uuid.generate()+"',");
		sb.append("'"+po.getCstiebillid()+"',");
		sb.append("'"+po.getCstiegoodsid()+"',");
		sb.append("'"+po.getCstiebarcode()+"',");
		sb.append("'"+po.getCstiegoodsquantity()+"',");
		sb.append("'"+po.getCstienottaxrate()+"',");
		sb.append("'"+po.getCstienottaxrateamount()+"',");
		sb.append("'"+po.getCstietaxrate()+"',");
		sb.append("'"+po.getCstiecostprice()+"',");
		sb.append("'"+po.getCstiecostpriceamount()+"',");
		sb.append("'"+po.getCstietaxamount()+"',");
		sb.append("'"+po.getCstieoutstockid()+"',");
		sb.append("getdate(),?,?,?)");
		
		params.add(Utility.getName(po.getCstieoutstorageflag()));
		params.add(Utility.getName(po.getCstietakeprice()));
		params.add(Utility.getName(po.getCstietakepriceamount()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void deleteSalesOut(InventoryPo po) {		
		String sql="delete from C_ST_TakeInventory where C_ST_I_BillID='"+po.getCstibillid()+"'";		
		getJdbcTemplate().update(sql);		
	}
	public void deleteSalesOutEntry(InventoryPo po) {		
		String sql="delete from C_ST_TakeInventoryEntry where C_ST_IE_BillID='"+po.getCstibillid()+"'";		
		getJdbcTemplate().update(sql);		
	}
	
	//查询负调拨商品信息
	public List<InventoryEntryPo> getReallocationList(InventoryPo po) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("SELECT  C_SHA_AE_goodsId as cstiegoodsid, B_GI_Spec as cstiespec,");
		sb.append("B_GI_CostPrice*0 as cstiecostprice,B_GI_NotTaxRate as cstienottaxrate,");
		sb.append("B_GI_TaxRate as cstietaxrate,");
		sb.append("cast(isnull(C_SHA_AE_allocationQuantity*B_GI_NotTaxRate,0) as numeric(18,2)) as cstienottaxrateamount,");
		sb.append("B_GI_ViewGoodsName as cstiegoodsname, B_UT_unitName as cstieunitname, ");
		sb.append("C_SHA_AE_allocationQuantity as cstiegoodsquantity, B_GI_GoodsBarCode+'00000000' as cstiebarcode ");
		sb.append("FROM C_SHA_AllocationEntry  ");
		sb.append("INNER JOIN B_GoodsInfo ON C_SHA_AE_goodsId = B_GoodsInfo.B_GI_GoodsID  ");
		sb.append("inner join B_Unit on B_GI_UnitId=B_UT_id  ");
		sb.append("where C_SHA_AE_billId = ?  ");
		sb.append("order by C_SHA_AE_goodsId  ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCstisourcebillid());

		return queryForObjectList(sb.toString(), params.toArray(),InventoryEntryPo.class);
	}
	
	
	/**
	 * 新增业务单据的商品条码
	 * 
	 * @param poID
	 */
	public void insertGoodsBarCode(AllocationBarcodePo allocationBarcodePo){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into C_ST_TakeInventoryBarCode(C_ST_IB_ID,C_ST_IB_BillID,C_ST_IB_GoodsID,C_ST_IB_GoodsBarcode) ");
		sb.append("values(?,?,?,?)");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(allocationBarcodePo.getCshabbillid()));
		params.add(Utility.getName(allocationBarcodePo.getCshabgoodsid()));
		params.add(Utility.getName(allocationBarcodePo.getCshabgoodsbarcode()));
				
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 删除业务单据的商品条码
	 * 
	 * @param poID
	 */
	public void deleteGoodsBarCode(InventoryPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from C_ST_TakeInventoryBarCode where C_ST_IB_BillID=? ");
		
		params.add(Utility.getName(po.getCstibillid()));
				
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 获取业务单据商品条码
	 * @param po
	 * @return
	 */
	public List<AllocationBarcodePo> getInventoryBarcode(InventoryPo po){
		
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("select C_ST_IB_GoodsID as cshabgoodsid,C_ST_IB_GoodsBarcode as cshabgoodsbarcode from C_ST_TakeInventoryBarCode where C_ST_IB_BillID=? ");
		params.add(Utility.getName(po.getCstibillid()));
		
		return queryForObjectList(sb.toString(), params.toArray(), AllocationBarcodePo.class);
	}
	
	/**
	 *  新增领用出库在途库存
	 */
	public void insertTakeOutInTransitStorage(InventoryPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("INSERT INTO C_SH_InTransitStorageEntry(C_SH_TSE_ID,C_SH_TSE_DepartmentType,C_SH_TSE_ModuleID,C_SH_TSE_EntryID ");
		sb.append("           ,C_SH_TSE_BillID,C_SH_TSE_GoodsID,C_SH_TSE_GoodsBarCode,C_SH_TSE_GoodsNum,C_SH_TSE_InStockID,C_SH_TSE_OutStockID,C_SH_TSE_InOrOutStock) ");
		
		sb.append("select newid() as a1,C_ST_I_DepartmentId as a2,'lyck' as a3,C_ST_IE_ID as a4,C_ST_IE_BillID as a5,C_ST_IE_GoodsId as a6, ");
		sb.append("       isnull(C_ST_IE_BarCode,'') as a7,-isnull(C_ST_IE_GoodsQuantity,0) as a8,'' as a9,C_ST_IE_OutStockId as a10,'2' as a11 ");
		sb.append("  from C_ST_TakeInventory inner join C_ST_TakeInventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		sb.append("  where C_ST_I_BillTypeId='3' and isnull(C_ST_I_AuditState,'')='0' and C_ST_IE_BillID=? and substring(C_ST_IE_GoodsId,9,1)<>'D'");
		
		params.add(Utility.getName(po.getCstibillid()));
				
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
}
