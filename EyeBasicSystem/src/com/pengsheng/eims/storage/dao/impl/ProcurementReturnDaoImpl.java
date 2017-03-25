package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.storage.dao.ProcurementReturnDao;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.TracEntryPo;
import com.pengsheng.eims.storage.persistence.TracPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ProcurementReturnDaoImpl extends BaseJdbcDaoSupport implements
		ProcurementReturnDao {

	/**
	 * 得到退货信息单据
	 */
	public InventoryPo getProcurementReturn(InventoryPo po) {
		StringBuffer sb = new StringBuffer();

		sb.append("select top 1  C_ST_I_BillID as cstibillid,C_ST_I_SourceBillId as cstisourcebillid, 	 ");
		sb.append("C_ST_I_billDate as cstibilldate,");
		sb.append("C_ST_I_OutStockId as cstioutstockid,");
		sb.append("B_Warehouse.B_WH_warehouseName as cstioutstockname,");
		sb.append("C_ST_I_SupplierId as cstisupplierid,");
		sb.append("B_Supplier.B_SP_SupplierName as cstisuppliername,");
		sb.append("B_Departments.B_DP_DepartmentName as cstidepartmentname,");
		sb.append("C_ST_I_createPerson as csticreateperson,");
		sb.append("C_ST_I_AuditPerson as cstiauditperson,");
		sb.append("a.personName as csticreatepersonname,");
		sb.append("b.personName as cstiauditpersonname,");
		sb.append("C_ST_I_AuditState as cstiauditstate,");
		sb.append("C_ST_I_AuditDate as cstiauditdate,");
		sb.append("C_ST_I_DeliveryID as deliveryID,");
		sb.append("C_ST_I_Remark as cstiremark");

		sb.append(" from C_ST_Inventory ");
		sb
				.append("inner join B_Supplier on C_ST_Inventory.C_ST_I_SupplierId=B_Supplier.B_SP_ID ");
		sb
				.append("inner join B_Warehouse on C_ST_Inventory.C_ST_I_OutStockId=B_Warehouse.B_WH_ID ");
		sb.append("inner join B_Departments on C_ST_Inventory.C_ST_I_DepartmentId=B_Departments.B_DP_DepartmentID ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID ");

		sb.append("where C_ST_I_BillID=?");

		List<String> params = new ArrayList<String>();

		params.add(po.getCstibillid());

		return (InventoryPo) queryForObject(sb.toString(), params.toArray(),
				InventoryPo.class);
	}

	/**
	 * 得到业务信息明细表中的退货信息
	 */
	public List<InventoryEntryPo> getProcurementReturnEntryList(InventoryPo po) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select C_ST_IE_ID as cstieid, ");
		sb.append("C_ST_InventoryEntry.C_ST_IE_GoodsId as cstiegoodsid, ");
		sb.append("B_GoodsInfo.B_GI_ViewGoodsName as cstiegoodsname, ");
		sb.append("C_ST_IE_GoodsQuantity as cstiegoodsquantity, ");
		sb.append("B_GoodsInfo.B_GI_Spec as cstiespec, ");
		sb.append("isnull(C_ST_InventoryEntry.C_ST_IE_NotTaxRate, ");
		sb.append("isnull(C_ST_InventoryEntry.C_ST_IE_NotTaxRate, B_GI_NotTaxRate )) as cstienottaxrate,"); 
		sb.append("isnull(C_ST_IE_NotTaxRateAmount, ");
		sb.append("convert(numeric(18, 2), isnull(C_ST_InventoryEntry.C_ST_IE_NotTaxRate, B_GI_NotTaxRate ) * C_ST_IE_GoodsQuantity)) as cstienottaxrateamount,");
		sb.append("C_ST_IE_TaxRate as cstietaxrate, ");
		sb.append("isnull(C_ST_InventoryEntry.C_ST_IE_CostPrice, ");
		sb.append("isnull(C_ST_InventoryEntry.C_ST_IE_CostPrice, B_GI_CostPrice )) as cstiecostprice, ");
		sb.append("isnull(C_ST_IE_CostPriceAmount, convert(numeric(18, 2),"); 
		sb.append("isnull(C_ST_InventoryEntry.C_ST_IE_CostPrice, ");
		sb.append("B_GI_CostPrice ) * C_ST_IE_GoodsQuantity)) as cstiecostpriceamount, ");
		sb.append("C_ST_IE_TaxAmount as cstietaxamount, ");
		sb.append("C_ST_IE_OutStockId as cstieoutstockid, ");
		sb.append("C_ST_InventoryEntry.C_ST_IE_BarCode as cstiebarcode, ");
		sb.append("B_Unit.B_UT_unitName as cstieunitname, ");
		sb.append("C_ST_IE_WarehousingDate as cstiewarehousingdate,isnull(C_ST_IE_OutStorageFlag,'1') as cstieoutstorageflag, ");
		sb.append("isnull(kucun.GoodsQuantity,0)+isnull(zaitu.GoodsNum,0) as cstiemaxquantity, ");
		sb.append("isnull(kucun.GoodsQuantity,0)+isnull(zaitu.GoodsNum,0)-C_ST_IE_GoodsQuantity as cstiemaxquantity2 ");
		sb.append("from C_ST_InventoryEntry ");
		sb.append("inner join B_GoodsInfo on C_ST_InventoryEntry.C_ST_IE_GoodsId = B_GI_GoodsID ");
		sb.append("left join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id ");
		
		sb.append(" left join ( ");
		sb.append("		SELECT GoodsId AS GoodsId, ");
		sb.append("		       GoodsBarCode as GoodsBarCode, ");
		sb.append("		       SUM(GoodsQuantity) AS GoodsQuantity, ");
		sb.append("		       StockId 			  AS StockId, ");
		sb.append("		       B_WH_warehouseName AS StockName ");
		sb.append("	 	FROM  (SELECT C_SH_SL_GoodsId        AS GoodsId, ");
		sb.append("		              C_SH_SL_GoodsQuantity AS GoodsQuantity, ");
		sb.append("		              C_SH_SL_StockId       AS StockId, ");
		sb.append("		       '' AS StockName,C_SH_SL_GoodsBarCode as GoodsBarCode ");
		sb.append("		       FROM   C_SH_StorageLog)ktemp ");
		sb.append("		       inner join B_Warehouse on ktemp.StockId = B_WH_ID ");
		if (!"".equals(Utility.getName(po.getCstioutstockid()))) {
			sb.append(" WHERE ktemp.StockId = ? ");
			params.add(po.getCstioutstockid());
		}
		sb.append("		GROUP  BY GoodsId,GoodsBarCode,StockId,B_WH_warehouseName ");
		sb.append(" ) kucun ");
		sb.append(" on B_GI_GoodsID = kucun.GoodsId and C_ST_InventoryEntry.C_ST_IE_BarCode=kucun.GoodsBarCode and kucun.StockId=C_ST_IE_OutStockId");
		sb.append(" left join ( ");
		sb.append(" select C_SH_TSE_GoodsID as GoodsId,sum(C_SH_TSE_GoodsNum) as GoodsNum from C_SH_InTransitStorageEntry ");
		sb.append(" where 1=1 ");
		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			sb.append(" and C_SH_TSE_BillID <> ? ");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstioutstockid()))) {
			sb.append(" and C_SH_TSE_OUTStockID = ? ");
			params.add(po.getCstioutstockid());
		}
		sb.append(" group by C_SH_TSE_GoodsID)zaitu ");
		sb.append(" on B_GI_GoodsID = zaitu.GoodsId ");
		
		sb.append("where C_ST_IE_BillID=? ");

		params.add(po.getCstibillid());

		return queryForObjectList(sb.toString(), params.toArray(),
				InventoryEntryPo.class);
	}

	/**
	 * 得到退后信息的个数
	 */
	public int getProcurementReturnCount(InventoryPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select count(C_ST_I_BillID) from( ");
		sb.append("select  distinct C_ST_I_BillID ");
		sb.append(" from C_ST_Inventory ");
		if(!"".equals(Utility.getName(po.getCstigoodscategory())) || !"".equals(Utility.getName(po.getCstigoodsid())) || !"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append(" inner join C_ST_InventoryEntry on C_ST_IE_BillID=C_ST_I_BillID " );
			sb.append(" inner join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID " );
		}
		sb.append("inner join B_Departments on C_ST_I_DepartmentId = B_DP_DepartmentID ");
		sb.append("inner join B_Supplier on C_ST_I_SupplierId=B_SP_ID ");
		sb.append("inner join B_Warehouse on C_ST_Inventory.C_ST_I_OutStockId=B_Warehouse.B_WH_ID ");
		sb.append("inner join B_Departments dpt on B_WH_deptID = dpt.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_I_FinanceAuditPerson = b.ID");

		List<String> params = new ArrayList<String>();

		sb.append(" where 1=1 and C_ST_I_BillTypeId='2'");
		
		if (!"".equals(Utility.getName(po.getCsticompanyid()))){
		    sb.append(" and dpt.B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCsticompanyid()));	
		}
		
		if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
			sb.append("and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
		}
		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			sb.append("and C_ST_I_BillID like'%'+?+'%' ");//quyanping
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
			sb.append("and C_ST_I_SupplierId=? ");
			params.add(po.getCstisupplierid());
		}
		if(!"".equals(Utility.getName(po.getCstigoodscategory()))){
			sb.append("AND substring(C_ST_IE_GoodsId,1,1)='"+po.getCstigoodscategory()+"' ");
		}
		if (!"".equals(Utility.getName(po.getCstioutstockid()))) {
			sb.append("and C_ST_I_OutStockId=? ");
			params.add(po.getCstioutstockid());
		}
		if (!"".equals(Utility.getName(po.getCstidepartmentid()))) {
			sb.append("and C_ST_I_DepartmentId=? ");
			params.add(po.getCstidepartmentid());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstate()))) {
			sb.append("and C_ST_I_FinanceAuditState = ? ");
			params.add(po.getCstiauditstate());
		}
		
		if(!"".equals(Utility.getName(po.getCstiremark()))){
			sb.append("and C_ST_I_Remark like '%' + ? + '%' ");
			params.add(po.getCstiremark());
		}

		sb.append("and C_ST_I_AuditState= 1 ");

		if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());
		} else if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& "".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());
		} else if ("".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstiendTime());
		}
		
		if (!"".equals(Utility.getName(po.getCstistartTime1()))
				&& !"".equals(Utility.getName(po.getCstiendTime1()))) {
			sb.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) <= ? ");
			params.add(po.getCstistartTime1());
			params.add(po.getCstiendTime1());
		} else if (!"".equals(Utility.getName(po.getCstistartTime1()))
				&& "".equals(Utility.getName(po.getCstiendTime1()))) {
			sb.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) >= ? ");
			params.add(po.getCstistartTime1());
		} else if ("".equals(Utility.getName(po.getCstistartTime1()))
				&& !"".equals(Utility.getName(po.getCstiendTime1()))) {
			sb.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) <= ? ");
			params.add(po.getCstiendTime1());
		}
		
		if (!"".equals(Utility.getName(po.getCsticreateperson()))) {
			sb.append("and C_ST_I_createPerson = ? ");
			params.add(po.getCsticreateperson());
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb.append("and C_ST_I_FinanceAuditPerson = ? ");
			params.add(po.getCstiauditperson());
		}
		if(!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("and C_ST_IE_GoodsId like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsid()));
		}
		if(!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsname()));
		}
		if (!"".equals(Utility.getName(po.getCsticreatepersonname()))) {
			sb.append("and a.personName like '%' + ? + '%' ");
			params.add(po.getCsticreatepersonname());
		}
		if (!"".equals(Utility.getName(po.getCstiauditpersonname()))) {
			sb.append("and b.personName like '%' + ? + '%' ");
			params.add(po.getCstiauditpersonname());
		}
		if(!"".equals(Utility.getName(po.getDeliveryID()))){
			sb.append("and C_ST_I_DeliveryID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getDeliveryID()));
		}
		
		sb.append(")temp");
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 将退货信息放入List<InventoryPo>中
	 */
	public List<InventoryPo> getProcurementReturnList(InventoryPo po,
			int start, int size) {
		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from(select ROW_NUMBER() Over(order by cstiauditdate desc) as rowNum,* from(select distinct  ");
		sb.append("C_ST_I_BillID as cstibillid,");
		sb.append("C_ST_I_BillTypeId as cstibilltypeid,");
		sb.append("C_ST_I_billDate as cstibilldate,");
		sb.append("C_ST_I_FinanceAuditDate as cstiauditdate,");
		sb.append("B_Warehouse.B_WH_warehouseName as cstioutstockname,");
		sb.append("C_ST_I_FinanceAuditState as cstifinanceauditstate,");
		sb.append("C_ST_I_FinanceAuditDate as cstifinanceauditdate,");
		sb.append("a.personName as csticreatepersonname,");
		sb.append("C_ST_I_Remark as cstiremark,");
		sb.append("C_ST_I_DeliveryID as deliveryID,");
		sb.append("b.personName as cstiauditpersonname,");
		sb.append("B_SP_SupplierName as cstisuppliername,");
		sb.append("B_Departments.B_DP_DepartmentName as cstidepartmentname");

		sb.append(" from C_ST_Inventory ");
		if(!"".equals(Utility.getName(po.getCstigoodscategory())) || !"".equals(Utility.getName(po.getCstigoodsid())) || !"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append(" inner join C_ST_InventoryEntry on C_ST_IE_BillID=C_ST_I_BillID " );
			sb.append(" inner join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID " );
		}
		sb.append("inner join B_Departments on C_ST_I_DepartmentId = B_DP_DepartmentID ");
		sb.append("inner join B_Supplier on C_ST_I_SupplierId=B_SP_ID ");
		sb.append("inner join B_Warehouse on C_ST_I_OutStockId=B_Warehouse.B_WH_ID ");
		sb.append("inner join B_Departments dpt on B_WH_deptID = dpt.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_I_FinanceAuditPerson=b.ID");

		sb.append(" where 1=1 and C_ST_I_BillTypeId='2'");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(po.getCsticompanyid()))){
		    sb.append(" and dpt.B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCsticompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			sb.append("and C_ST_I_BillID like'%'+?+'%' ");//quyanping
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
			sb.append("and C_ST_I_SupplierId=? ");
			params.add(po.getCstisupplierid());
		}

		if(!"".equals(Utility.getName(po.getCstigoodscategory()))){
			sb.append("AND substring(C_ST_IE_GoodsId,1,1)='"+po.getCstigoodscategory()+"' ");
		}	
		if (!"".equals(Utility.getName(po.getCstioutstockid()))) {
			sb.append("and C_ST_I_OutStockId=? ");
			params.add(po.getCstioutstockid());
		}
		if (!"".equals(Utility.getName(po.getCstidepartmentid()))) {
			sb.append("and C_ST_I_DepartmentId=? ");
			params.add(po.getCstidepartmentid());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstate()))) {
			sb.append("and C_ST_I_FinanceAuditState = ? ");
			params.add(po.getCstiauditstate());
		}

		if(!"".equals(Utility.getName(po.getCstiremark()))){
			sb.append("and C_ST_I_Remark like '%' + ? + '%' ");
			params.add(po.getCstiremark());
		}
		
		sb.append("and C_ST_I_AuditState= 1 ");

		if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());
		} else if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& "".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());
		} else if ("".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstiendTime());
		}
		
		if (!"".equals(Utility.getName(po.getCstistartTime1()))
				&& !"".equals(Utility.getName(po.getCstiendTime1()))) {
			sb.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) <= ? ");
			params.add(po.getCstistartTime1());
			params.add(po.getCstiendTime1());
		} else if (!"".equals(Utility.getName(po.getCstistartTime1()))
				&& "".equals(Utility.getName(po.getCstiendTime1()))) {
			sb.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) >= ? ");
			params.add(po.getCstistartTime1());
		} else if ("".equals(Utility.getName(po.getCstistartTime1()))
				&& !"".equals(Utility.getName(po.getCstiendTime1()))) {
			sb.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) <= ? ");
			params.add(po.getCstiendTime1());
		}
		
		if (!"".equals(Utility.getName(po.getCsticreateperson()))) {
			sb.append("and C_ST_I_createPerson = ? ");
			params.add(po.getCsticreateperson());
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb.append("and C_ST_I_FinanceAuditPerson = ? ");
			params.add(po.getCstiauditperson());
		}
		if(!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("and C_ST_IE_GoodsId like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsid()));
		}
		if(!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsname()));
		}
		if (!"".equals(Utility.getName(po.getCsticreatepersonname()))) {
			sb.append("and a.personName like '%' + ? + '%' ");
			params.add(po.getCsticreatepersonname());
		}
		if (!"".equals(Utility.getName(po.getCstiauditpersonname()))) {
			sb.append("and b.personName like '%' + ? + '%' ");
			params.add(po.getCstiauditpersonname());
		}
		if(!"".equals(Utility.getName(po.getDeliveryID()))){
			sb.append("and C_ST_I_DeliveryID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getDeliveryID()));
		}
		if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
			sb.append("and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
		}
		sb.append(" ) temp )t where rowNum > " + start + " and rowNum <= "
				+ (start + size));
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(),
				InventoryPo.class);
	}

	/**
	 * 更新商品退货信息
	 */
	public void updateProcurementReturn(InventoryPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("update C_ST_Inventory set ");

		sb.append("C_ST_I_OutStockId= ? , ");
		sb.append("C_ST_I_FinanceAuditState= ? , ");
		sb.append("C_ST_I_Remark= ? ");

		params.add(po.getCstioutstockid());
		params.add(po.getCstifinanceauditstate());
		params.add(Utility.getName(po.getCstiremark()));

		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb.append(",C_ST_I_FinanceAuditPerson = ? ");
			sb.append(",C_ST_I_FinanceAuditDate = getdate()");
			params.add(po.getCstiauditperson());
		}
		sb.append(" where C_ST_Inventory.C_ST_I_BillID= ? ");

		params.add(po.getCstibillid());
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	//查询负调拨商品信息
	public List<InventoryEntryPo> getReallocationList(InventoryPo po) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("SELECT  ");
		sb.append("C_SHA_AE_goodsId as cstiegoodsid, ");
		sb.append("B_GI_Spec as cstiespec,B_GI_CostPrice as cstiecostprice,B_GI_NotTaxRate as cstienottaxrate,B_GI_TaxRate as cstietaxrate, ");
		sb.append("B_GI_ViewGoodsName as cstiegoodsname, ");
		sb.append("B_UT_unitName as cstieunitname, ");
		sb.append("C_SHA_AE_requirementQuantity as cstiegoodsquantity ");
		sb.append("FROM C_SHA_AllocationEntry INNER JOIN ");
		sb.append("B_GoodsInfo ON C_SHA_AE_goodsId = B_GoodsInfo.B_GI_GoodsID inner join B_Unit on B_GI_UnitId=B_UT_id ");
		sb.append("where C_SHA_AE_billId = ? order by C_SHA_AE_goodsId ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCstisourcebillid());

		return queryForObjectList(sb.toString(), params.toArray(),InventoryEntryPo.class);
	}
	
	public List<InventoryEntryPo> getStockGoodsForBrand(InventoryPo po) {
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT B_GI_ViewGoodsName     AS cstiegoodsname, ");
		sb.append("       cstiegoodsid       AS cstiegoodsid, ");
		sb.append("       cstiegoodsquantity AS cstiegoodsquantity, ");
		sb.append("       cstiebarcode       AS cstiebarcode, ");
		sb.append("       B_GI_Spec          AS cstiespec, ");
		sb.append("       B_UT_unitName      AS cstieunitname, ");
		sb.append("       B_GI_CostPrice     AS cstiecostprice, ");
		sb.append("       B_GI_TaxRate       AS cstietaxrate, ");
		sb.append("       B_GI_NotTaxRate    AS cstienottaxrate, ");
		sb.append("       B_SP_SupplierName  AS cstiesupplierName, ");
		sb.append("       B_SP_ID            AS cstiesupplierID, ");
		sb.append("       ?					 AS cstieoutstockid, ");
		sb.append("       cstiemaxquantity   as cstiemaxquantity ");
		params.add(po.getCstioutstockid());
		sb.append("FROM  (SELECT C_SH_SL_GoodsId            AS cstiegoodsid, ");
		sb.append("              C_SH_SL_GoodsBarCode       AS cstiebarcode, ");
		sb.append("              SUM(C_SH_SL_GoodsQuantity) AS cstiegoodsquantity, ");
		sb.append("              SUM(C_SH_SL_GoodsQuantity) AS cstiemaxquantity ");
		sb.append("       FROM   dbo.C_SH_StorageLog ");
		sb.append("       WHERE  C_SH_SL_StockId = ? ");
		sb.append("              AND Substring(C_SH_SL_GoodsId, 1, 7) = ? ");
		sb.append("       GROUP  BY C_SH_SL_GoodsId, ");
		sb.append("                 C_SH_SL_GoodsBarCode) TEMP ");
		sb.append("      INNER JOIN dbo.B_GoodsInfo ");
		sb.append("        ON cstiegoodsid = B_GI_GoodsID ");
		sb.append("      INNER JOIN dbo.B_Unit ");
		sb.append("        ON B_GI_UnitId = B_UT_id ");
		sb.append("      INNER JOIN dbo.B_Supplier ON B_SP_ID = B_GI_SupplierID ");
		sb.append("      WHERE  isnull(cstiegoodsquantity,0) > 0 ");
		params.add(po.getCstioutstockid());
		params.add(po.getCstigoodsid());
		
		return queryForObjectList(sb.toString(), params.toArray(),InventoryEntryPo.class);
	}
	
	public List<TracEntryPo> getStoreStockGoodsForBrand(TracPo po) {
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT B_GI_ViewGoodsName     AS cstiegoodsname, ");
		sb.append("       cstiegoodsid       AS cstiegoodsid, ");
		sb.append("       cstiegoodsquantity AS cstiegoodsquantity, ");
		sb.append("       cstiebarcode       AS cstiebarcode, ");
		sb.append("       B_GI_Spec          AS cstiespec, ");
		sb.append("       B_UT_unitName      AS cstieunitname, ");
		sb.append("       B_GI_CostPrice     AS cstiecostprice, ");
		sb.append("       B_GI_TaxRate       AS cstietaxrate, ");
		sb.append("       B_GI_NotTaxRate    AS cstienottaxrate, ");
		sb.append("       B_SP_SupplierName  AS cstiesupplierName, ");
		sb.append("       B_SP_ID            AS cstiesupplierID, ");
		sb.append("       ?					 AS cstieoutstockid, ");
		params.add(po.getCstioutstockid());
		sb.append("       B_GI_WholesalePrice AS cstiewholesaleprice ");
		sb.append("FROM  (SELECT C_SH_SL_GoodsId            AS cstiegoodsid, ");
		sb.append("              C_SH_SL_GoodsBarCode       AS cstiebarcode, ");
		sb.append("              SUM(C_SH_SL_GoodsQuantity) AS cstiegoodsquantity ");
		sb.append("       FROM   dbo.C_SH_StorageLog ");
		sb.append("       WHERE  C_SH_SL_StockId = ? ");
		sb.append("              AND Substring(C_SH_SL_GoodsId, 1, 7) = ? ");
		sb.append("       GROUP  BY C_SH_SL_GoodsId, ");
		sb.append("                 C_SH_SL_GoodsBarCode) TEMP ");
		sb.append("      INNER JOIN dbo.B_GoodsInfo ");
		sb.append("        ON cstiegoodsid = B_GI_GoodsID ");
		sb.append("      INNER JOIN dbo.B_Unit ");
		sb.append("        ON B_GI_UnitId = B_UT_id ");
		sb.append("      INNER JOIN dbo.B_Supplier ON B_SP_ID = B_GI_SupplierID ");
		sb.append("      WHERE  isnull(cstiegoodsquantity,0) > 0 ");
		params.add(po.getCstioutstockid());
		params.add(po.getCstigoodsid());
		
		return queryForObjectList(sb.toString(), params.toArray(),TracEntryPo.class);
	}
	
	/**
	 * 获取调拨单条码
	 */
	public List<InventoryEntryPo> getAllocationBarcode(String billid) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select C_SHA_B_GoodsBarcode as cstiebarcode ");
		buffer.append("from dbo.C_SHA_AllocationBarcode ");
		buffer.append("where C_SHA_B_billID = ? ");
		
		params.add(billid);
		
		return queryForObjectList(buffer.toString(), params.toArray(), InventoryEntryPo.class);
	}

	/**
	 * 更新商品退货信息
	 */
	public void updateProcurementReturnStorage(InventoryPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("update C_ST_Inventory set ");

		sb.append("C_ST_I_OutStockId = ? , ");
		sb.append("C_ST_I_DeliveryID = ? , ");
		sb.append("C_ST_I_AuditState = ? , ");
		sb.append("C_ST_I_Remark= ? ");

		params.add(po.getCstioutstockid());
		params.add(po.getDeliveryID());
		params.add(po.getCstiauditstate());
		params.add(Utility.getName(po.getCstiremark()));

		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb.append(",C_ST_I_AuditPerson = ? ");
			sb.append(",C_ST_I_AuditDate = getdate()");
			params.add(po.getCstiauditperson());
		}
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			sb.append(",C_ST_I_SourceBillId = ? ");
			params.add(po.getCstisourcebillid());
		}
		sb.append(" where C_ST_Inventory.C_ST_I_BillID= ? ");

		params.add(po.getCstibillid());
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	/**
	 * 得到退后信息的个数
	 */
	public int getProcurementReturnStorageCount(InventoryPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select count(C_ST_I_BillID) from( ");
		sb.append("select  distinct C_ST_I_BillID ");
		sb.append(" from C_ST_Inventory ");		
		if(!"".equals(Utility.getName(po.getCstigoodscategory())) || !"".equals(Utility.getName(po.getCstigoodsid())) || !"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append(" inner join C_ST_InventoryEntry on C_ST_IE_BillID=C_ST_I_BillID " );
			sb.append(" inner join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID " );
		}

		sb.append(" inner join B_Departments on C_ST_I_DepartmentId = B_DP_DepartmentID ");
		sb.append("inner join B_Supplier on C_ST_I_SupplierId=B_SP_ID ");
		sb.append("inner join B_Warehouse on C_ST_Inventory.C_ST_I_OutStockId=B_Warehouse.B_WH_ID ");
		sb.append(" inner join B_Departments dpt on B_WH_deptID = dpt.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID");

		List<String> params = new ArrayList<String>();

		sb.append(" where 1=1 and C_ST_I_BillTypeId='2'");
		
		if (!"".equals(Utility.getName(po.getCsticompanyid()))){
		    sb.append(" and dpt.B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCsticompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			sb.append("and C_ST_I_BillID like '%'+?+'%' ");//quyanping
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
			sb.append("and C_ST_I_SupplierId=? ");
			params.add(po.getCstisupplierid());
		}
		if(!"".equals(Utility.getName(po.getCstigoodscategory()))){
			sb.append("AND substring(C_ST_IE_GoodsId,1,1)='"+po.getCstigoodscategory()+"' ");
		}
		if (!"".equals(Utility.getName(po.getCstioutstockid()))) {
			sb.append("and C_ST_I_OutStockId=? ");
			params.add(po.getCstioutstockid());
		}
		if (!"".equals(Utility.getName(po.getCstidepartmentid()))) {
			sb.append("and C_ST_I_DepartmentId=? ");
			params.add(po.getCstidepartmentid());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstate()))) {
			sb.append("and C_ST_I_AuditState=? ");
			params.add(po.getCstiauditstate());
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());
		} else if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& "".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());
		} else if ("".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstiendTime());
		}
		if (!"".equals(Utility.getName(po.getCsticreateperson()))) {
			sb.append("and C_ST_I_createPerson=? ");
			params.add(po.getCsticreateperson());
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb.append("and C_ST_I_AuditPerson=? ");
			params.add(po.getCstiauditperson());
		}
		if(!"".equals(Utility.getName(po.getCstiremark()))){
			sb.append("and C_ST_I_Remark like '%' + ? + '%' ");
			params.add(po.getCstiremark());
		}
		
		if(!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("and C_ST_IE_GoodsId like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsid()));
		}
		
		if(!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsname()));
		}
		
		if(!"".equals(Utility.getName(po.getDeliveryID()))){
			sb.append("and C_ST_I_DeliveryID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getDeliveryID()));
		}
		
		sb.append(")temp");
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 将退货信息放入List<InventoryPo>中
	 */
	public List<InventoryPo> getProcurementReturnStorageList(InventoryPo po,
			int start, int size) {
		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");

		sb.append("select * from(select ROW_NUMBER() Over(order by cstibilldate desc) as rowNum,* from(select distinct ");
		sb.append("C_ST_I_BillID as cstibillid,");
		sb.append("C_ST_I_BillTypeId as cstibilltypeid,");
		sb.append("C_ST_I_billDate as cstibilldate,");
		sb.append("C_ST_I_DeliveryID as deliveryID,");
		sb.append("C_ST_I_AuditDate as cstiauditdate,");
		sb.append("B_Warehouse.B_WH_warehouseName as cstioutstockname,");
		sb.append("C_ST_I_AuditState as cstiauditstate,");
		sb.append("a.personName as csticreatepersonname,");
		sb.append("b.personName as cstiauditpersonname,");
		sb.append("B_SP_SupplierName as bspsuppliername,");
		sb.append("B_Departments.B_DP_DepartmentName as cstidepartmentname,");
		sb.append("C_ST_I_Remark as cstiremark");
		sb.append(" from C_ST_Inventory ");
		if(!"".equals(Utility.getName(po.getCstigoodscategory())) || !"".equals(Utility.getName(po.getCstigoodsid())) || !"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append(" inner join C_ST_InventoryEntry on C_ST_IE_BillID=C_ST_I_BillID " );
			sb.append(" inner join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID " );
		}

		sb.append("inner join B_Departments on C_ST_I_DepartmentId = B_DP_DepartmentID ");
		sb.append("inner join B_Supplier on C_ST_I_SupplierId=B_SP_ID ");
		sb.append("inner join B_Warehouse on C_ST_I_OutStockId=B_Warehouse.B_WH_ID ");
		sb.append(" inner join B_Departments dpt on B_WH_deptID = dpt.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_I_AuditPerson=b.ID");
		sb.append(" where 1=1 and C_ST_I_BillTypeId='2'");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(po.getCsticompanyid()))){
		    sb.append(" and dpt.B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCsticompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			sb.append("and C_ST_I_BillID like '%'+?+'%' ");//quyanping
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
			sb.append("and C_ST_I_SupplierId=? ");
			params.add(po.getCstisupplierid());
		}
		if(!"".equals(Utility.getName(po.getCstigoodscategory()))){
			sb.append("AND substring(C_ST_IE_GoodsId,1,1)='"+po.getCstigoodscategory()+"' ");
		}
		if (!"".equals(Utility.getName(po.getCstioutstockid()))) {
			sb.append("and C_ST_I_OutStockId=? ");
			params.add(po.getCstioutstockid());
		}
		if (!"".equals(Utility.getName(po.getCstidepartmentid()))) {
			sb.append("and C_ST_I_DepartmentId=? ");
			params.add(po.getCstidepartmentid());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstate()))) {
			sb.append("and C_ST_I_AuditState=? ");
			params.add(po.getCstiauditstate());
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());
		} else if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& "".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());
		} else if ("".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstiendTime());
		}
		if (!"".equals(Utility.getName(po.getCsticreateperson()))) {
			sb.append("and C_ST_I_createPerson=? ");
			params.add(po.getCsticreateperson());
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb.append("and C_ST_I_AuditPerson=? ");
			params.add(po.getCstiauditperson());
		}
		if(!"".equals(Utility.getName(po.getCstiremark()))){
			sb.append("and C_ST_I_Remark like '%' + ? + '%' ");
			params.add(po.getCstiremark());
		}
		
		if(!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("and C_ST_IE_GoodsId like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsid()));
		}
		if(!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsname()));
		}
		if(!"".equals(Utility.getName(po.getDeliveryID()))){
			sb.append("and C_ST_I_DeliveryID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getDeliveryID()));
		}

		sb.append(" ) temp )t where rowNum > " + start + " and rowNum <= "
				+ (start + size));
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(),
				InventoryPo.class);
	}

	/**
	 * 将退货信息插入业务表中
	 */
	public void insertProcurementReturn(InventoryPo po) {
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb1.append("insert into C_ST_Inventory(");
		sb1.append("C_ST_I_BillID,");
		sb1.append("C_ST_I_BillTypeId,C_ST_I_DeliveryID,");
		sb1.append("C_ST_I_billDate,");
		sb1.append("C_ST_I_SupplierId,");
		sb1.append("C_ST_I_OutStockId,");
		sb1.append("C_ST_I_DepartmentId,");
		sb1.append("C_ST_I_createPerson,");
		sb1.append("C_ST_I_AuditState,");
		sb1.append("C_ST_I_Remark,");
		sb1.append("C_ST_I_FinanceAuditState,C_ST_I_InvoiceState,C_ST_I_SubSupplierId");

		sb2.append("? , '2' , ?,getdate() , ? , ? , ? , ? , ? , ?, 0 ,0, ?");
		params.add(po.getCstibillid());
		params.add(Utility.getName(po.getDeliveryID()));
		params.add(po.getCstisupplierid());
		params.add(po.getCstioutstockid());
		params.add(po.getCstidepartmentid());
		params.add(po.getCsticreateperson());
		params.add(po.getCstiauditstate());
		params.add(po.getCstiremark());
		params.add(Utility.getName(po.getCstisubsupplierid()));

		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb1.append(",C_ST_I_AuditPerson,");
			sb1.append("C_ST_I_AuditDate");
			sb2.append(",? ,getdate() ");
			params.add(po.getCstiauditperson());
		}
		
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			sb1.append(",C_ST_I_SourceBillId");
			sb2.append(",?");
			params.add(po.getCstisourcebillid());
		}

		String sql = sb1.toString() + ")values(" + sb2.toString() + ")";
		getJdbcTemplate().update(sql, params.toArray());
	}
	
	//反添加负调拨的状态（对于退货新增）
	public void insertAllocationStatus(InventoryPo inventoryPo) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("UPDATE C_SHA_Allocation ");
		sb.append("SET ");
		sb.append("C_SHA_A_ReturnStatus = '1' ");
		sb.append("WHERE C_SHA_A_billID = ? ");
		params.add(inventoryPo.getCstisourcebillid());

		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	/**
	 * 将退货信息插入业务明细表中
	 */
	public void insertProcurementReturnEntry(InventoryEntryPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("insert into C_ST_InventoryEntry(");

		sb.append("C_ST_IE_ID,");
		sb.append("C_ST_IE_BillID,");
		sb.append("C_ST_IE_GoodsId,");
		sb.append("C_ST_IE_GoodsQuantity,");
		sb.append("C_ST_IE_NotTaxRate,");
		sb.append("C_ST_IE_NotTaxRateAmount,");
		sb.append("C_ST_IE_TaxRate,");
		sb.append("C_ST_IE_CostPrice,");
		sb.append("C_ST_IE_CostPriceAmount,");
		sb.append("C_ST_IE_TaxAmount,");
		sb.append("C_ST_IE_OutStockId,");
		sb.append("C_ST_IE_BarCode,");
		sb.append("C_ST_IE_WarehousingDate,C_ST_Ie_InvoiceState,C_ST_IE_OutStorageFlag,C_ST_IE_RetailPrice ");

		sb.append(") values(");

		sb.append("? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , getdate(),0,?,? ");
		sb.append(")");

		params.add(this.uuid.generate());
		params.add(po.getCstiebillid());
		params.add(po.getCstiegoodsid());
		params.add(po.getCstiegoodsquantity());
		params.add(po.getCstienottaxrate());
		params.add(po.getCstienottaxrateamount());
		params.add(po.getCstietaxrate());
		params.add(po.getCstiecostprice());
		params.add(po.getCstiecostpriceamount());
		params.add(po.getCstietaxamount());
		params.add(po.getCstieoutstockid());
		params.add(po.getCstiepcbarcode());
		params.add(Utility.getName(po.getCstieoutstorageflag()));
		params.add(Utility.getName(po.getBgcretailPrice()).equals("") ? "0.00" : Utility.getName(po.getBgcretailPrice()));

		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	/**
	 * 删除业务单据表中的退货信息
	 */
	public void deleteProcurementReturn(InventoryPo po) {
		List<String> params = new ArrayList<String>();
		String sql = "delete from C_ST_Inventory where C_ST_I_BillID= ? ";
		params.add(po.getCstibillid());
		getJdbcTemplate().update(sql, params.toArray());
	}

	/**
	 * 删除业务单据明细表中的退货信息
	 */
	public void deleteProcurementReturnEntry(InventoryPo po) {
		List<String> params = new ArrayList<String>();
		String sql = "delete from C_ST_InventoryEntry where C_ST_IE_BillID= ? ";
		params.add(po.getCstibillid());
		getJdbcTemplate().update(sql, params.toArray());
	}

	/**
	 * 新增商品退货信息
	 * 
	 * @param po
	 */
	public void insertProcurementReturnStorage(InventoryPo po) {
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb1
				.append("insert into C_ST_Inventory(C_ST_I_BillID,C_ST_I_BillTypeId,C_ST_I_billDate,");
		sb1.append("C_ST_I_SupplierId,C_ST_I_OutStockId,");
		sb1
				.append("C_ST_I_DepartmentId,C_ST_I_createPerson,C_ST_I_AuditState,C_ST_I_Remark");
		// sb2.append("'"+po.getCstibillid()+"','"+po.getCstibilltypeid()+"','"+po.getCstibilldate()+"',");
		// sb2.append("'"+po.getCstisupplierid()+"','"+po.getCstiinstockid()+"','"+po.getCstidepartmentid()+"',");
		// sb2.append("'"+po.getCsticreateperson()+"','"+po.getCstiauditstate()+"','"+po.getCstiremark()+"'");
		sb2.append("?,?,?,");
		params.add(po.getCstibillid());
		params.add(po.getCstibilltypeid());
		params.add(po.getCstibilldate());
		sb2.append("?,?,?,");
		params.add(po.getCstisupplierid());
		params.add(po.getCstioutstockid());
		params.add(po.getCstidepartmentid());
		sb2.append("?,?,?");
		params.add(po.getCsticreateperson());
		params.add(po.getCstiauditstate());
		params.add(po.getCstiremark());

		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb1
					.append(",C_ST_I_AuditPerson,C_ST_I_AuditDate,C_ST_I_FinanceAuditState");
			// sb2.append(",'"+po.getCstiauditperson()+"',getdate(),'0'");
			sb2.append(", ?, getdate(), '0'");
			params.add(po.getCstiauditperson());
		} else {
			sb1.append(",C_ST_I_FinanceAuditState");
			sb2.append(", '0'");
		}

		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			sb1.append(",C_ST_I_SourceBillId");
			// sb2.append(",'"+po.getCstisourcebillid()+"'");
			sb2.append(",?");
			params.add(po.getCstisourcebillid());
		}
		String sql = sb1.toString() + ")values(" + sb2.toString() + ")";
		// getJdbcTemplate().update(sql);
		getJdbcTemplate().update(sql, params.toArray());
	}

	/**
	 * 新增商品退货明细表信息
	 * 
	 * @param po
	 */
	public void insertProcurementReturnEntryStorage(InventoryEntryPo po) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("insert into C_ST_InventoryEntry(");

		sb.append("C_ST_IE_ID,");
		sb.append("C_ST_IE_BillID,");
		sb.append("C_ST_IE_GoodsId,");
		sb.append("C_ST_IE_GoodsQuantity,");
		if (!"".equals(Utility.getName(po.getCstietaxrate()))){
			sb.append("C_ST_IE_TaxRate,");
		}		
		sb.append("C_ST_IE_OutStockId,");
		sb.append("C_ST_IE_BarCode,");
		sb.append("C_ST_IE_WarehousingDate,C_ST_IE_OutStorageFlag ");

		if (!"".equals(Utility.getName(po.getCstienottaxrate()))){
			sb.append(" ,C_ST_IE_NotTaxRate ");
		}
		if (!"".equals(Utility.getName(po.getCstiecostprice()))){
			sb.append(" ,C_ST_IE_CostPrice  ");
		}
		
		sb.append(") values(");

		sb.append("? , ? , ? , ? ");
		if (!"".equals(Utility.getName(po.getCstietaxrate()))){
			sb.append(" , ?  ");
		}
		sb.append(" , ? , ? , getdate(),? ");
		if (!"".equals(Utility.getName(po.getCstienottaxrate()))){
			sb.append(" , ?  ");
		}
		if (!"".equals(Utility.getName(po.getCstiecostprice()))){
			sb.append(" , ?  ");
		}
		sb.append(")");

		params.add(Utility.getName(po.getCstieid()));
		params.add(Utility.getName(po.getCstiebillid()));
		params.add(Utility.getName(po.getCstiegoodsid()));
		params.add(Utility.getName(po.getCstiegoodsquantity()));
		if (!"".equals(Utility.getName(po.getCstietaxrate()))){
			params.add(Utility.getName(po.getCstietaxrate()));
		}		
		params.add(Utility.getName(po.getCstieoutstockid()));
		params.add(Utility.getName(po.getCstiepcbarcode()));
		params.add(Utility.getName(po.getCstieoutstorageflag()));		
		
		if (!"".equals(Utility.getName(po.getCstienottaxrate()))){
			params.add(Utility.getName(po.getCstienottaxrate()));
		}
		if (!"".equals(Utility.getName(po.getCstiecostprice()))){
			params.add(Utility.getName(po.getCstiecostprice()));
		}

		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public void ProcurementReturnimportOrders(String poID){
		String sql = "exec SP_ReturnimportOrders ? ";
		
		getJdbcTemplate().update(sql, new String[]{poID});
	}
	
	/**
	 * 新增业务单据的商品条码
	 * 
	 * @param poID
	 */
	public void insertGoodsBarCode(AllocationBarcodePo allocationBarcodePo){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into C_ST_InventoryBarCode(C_ST_IB_ID,C_ST_IB_BillID,C_ST_IB_GoodsID,C_ST_IB_GoodsBarcode) ");
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
		
		sb.append("delete from C_ST_InventoryBarCode where C_ST_IB_BillID=? ");
		
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
		
		sb.append("select C_ST_IB_GoodsID as cshabgoodsid,C_ST_IB_GoodsBarcode as cshabgoodsbarcode from C_ST_InventoryBarCode where C_ST_IB_BillID=? ");
		params.add(Utility.getName(po.getCstibillid()));
		
		return queryForObjectList(sb.toString(), params.toArray(), AllocationBarcodePo.class);
	}
}
