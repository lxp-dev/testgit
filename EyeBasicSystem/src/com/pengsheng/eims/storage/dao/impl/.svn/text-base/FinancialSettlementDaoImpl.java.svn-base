package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.storage.dao.FinancialSettlementDao;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class FinancialSettlementDaoImpl extends BaseJdbcDaoSupport  implements FinancialSettlementDao {

	/**
	 * 财务结算详细
	 * @param po
	 * @return
	 */
	public InventoryPo getFinancialSettlement(InventoryPo po) {
		StringBuffer sb=new StringBuffer();	
		
		sb.append("select top 1  C_ST_I_BillID as cstibillid,");	//单据编号
		sb.append("C_ST_I_SourceBillId as cstisourcebillid,");	//订单号 
		sb.append("C_ST_I_billDate as cstibilldate,C_ST_I_DeliveryID as deliveryID,");	
		sb.append("C_ST_I_SupplierId as cstisupplierid,");	//所属制造商编号
		sb.append("B_Supplier.B_SP_SupplierName as cstisuppliername,");	//所属制造商名称
		sb.append("C_ST_I_BillTypeId as cstibilltypeid,");	//入库类型
		sb.append("C_ST_I_InStockId as cstiinstockid,");	//入库仓位编号
		sb.append("B_Warehouse.B_WH_warehouseName as cstiinstockname,");	//入库仓位名称
		sb.append("a.personName as csticreatepersonname,");	//制单人名称
		sb.append("b.personName as cstiauditpersonname,");	//入库审核人名称
		sb.append("C_ST_I_AuditDate as cstiauditdate,");	//入库审核日期
		sb.append("C_ST_I_FinanceAuditPerson as cstifinanceauditperson,");	//财务结算审核人
		sb.append("C_ST_I_FinanceAuditState as cstifinanceauditstate,");	//财务结算审核状态
		sb.append("C_ST_I_FinanceAuditDate as cstifinanceauditdate,");	//财务结算审核日期
		sb.append("C_ST_I_Remark as cstiremark ");	//备注
		
		sb.append("from C_ST_Inventory ");
		
		sb.append("inner join B_Supplier on C_ST_I_SupplierId=B_SP_ID ");	//内联制造商表
		sb.append("inner join B_Warehouse on C_ST_I_InStockId=B_Warehouse.B_WH_ID ");	//左外联仓位表
		
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_I_createPerson=a.ID ");//左外人员表,制单人
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_I_AuditPerson=b.ID ");	//左外人员表,审核人
		
		sb.append("where C_ST_I_BillID='"+po.getCstibillid()+"'");
	
		return (InventoryPo)queryForObject(sb.toString(), null, InventoryPo.class);
	}

	/**
	 * 查询采购收货结算数量
	 * @param po
	 * @return
	 */
	public int getFinancialSettlementCount(InventoryPo po) {
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(distinct C_ST_Inventory.C_ST_I_BillID) from C_ST_Inventory ");
	
		if(!"".equals(Utility.getName(po.getCstigoodsname())) || !"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
			sb.append("inner join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID ");
		}		

		sb.append("inner join B_Supplier on C_ST_I_SupplierId=B_SP_ID ");	//内联制造商表
		sb.append("inner join B_Warehouse on C_ST_I_InStockId=B_Warehouse.B_WH_ID ");	//左外联仓位表
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_I_FinanceAuditPerson=b.ID ");	//左外人员表
		sb.append("left join SYS_PersonInfo r on C_ST_I_AuditPerson=r.ID ");	//左外人员表
		
		sb.append(" left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");	
		
		sb.append("where C_ST_I_AuditState='1' ");	//审核状态为已审核
		sb.append("and C_ST_I_BillTypeId in('1')");	//1、采购收货单PIN；7、其他入库 OTI；9、委外收货单CPIN
		
		if (!"".equals(Utility.getName(po.getCsticompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCsticompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getCstiauditpersonname()))){	//单据编号查询
			sb.append("and r.personName like'%"+po.getCstiauditpersonname()+"%' ");//quyanping
		}
		if(!"".equals(Utility.getName(po.getCstibillid()))){	//单据编号查询
			sb.append("and C_ST_I_BillID like'%"+po.getCstibillid()+"%' ");//quyanping
		}
		if(!"".equals(Utility.getName(po.getCstisourcebillid()))){	//订单编号查询
			sb.append("and C_ST_I_SourceBillId like'%"+po.getCstisourcebillid()+"%' ");//quyanping
		}		
		if(!"".equals(Utility.getName(po.getCstibilltypeid()))){	//单据类型查询
			sb.append("and C_ST_I_BillTypeId='"+po.getCstibilltypeid()+"' ");
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {	//制造商查询
			sb.append("and C_ST_I_SupplierId='"+po.getCstisupplierid()+"' ");
		}
		if(!"".equals(Utility.getName(po.getCstigoodscategory()))){
			sb.append("and C_ST_I_GoodsCategory='"+po.getCstigoodscategory()+"' ");
		}
		if(!"".equals(Utility.getName(po.getCstiinstockid()))){		//收入仓位查询
			sb.append("and C_ST_I_InStockId='"+po.getCstiinstockid()+"' ");
		}
		if(!"".equals(Utility.getName(po.getCstifinanceauditstate()))){		//财务审核状态查询
			sb.append("and C_ST_I_FinanceAuditState='"+po.getCstifinanceauditstate()+"' ");
		}
		if(!"".equals(Utility.getName(po.getCstistartTime())) && !"".equals(Utility.getName(po.getCstiendTime()))){		//财务审核日期查询
			sb.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) >= '"+po.getCstistartTime()+"' ");
			sb.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) <= '"+po.getCstiendTime()+"' ");
		}else if(!"".equals(Utility.getName(po.getCstistartTime())) && "".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) >= '"+po.getCstistartTime()+"' ");
		}else if("".equals(Utility.getName(po.getCstistartTime())) && !"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) <= '"+po.getCstiendTime()+"' ");
		}	
		if(!"".equals(Utility.getName(po.getCreatestarttime())) && !"".equals(Utility.getName(po.getCreateendtime()))){		//财务审核日期查询
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= '"+po.getCreatestarttime()+"' ");
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= '"+po.getCreateendtime()+"' ");
		}else if(!"".equals(Utility.getName(po.getCreatestarttime())) && "".equals(Utility.getName(po.getCreateendtime()))){
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= '"+po.getCreatestarttime()+"' ");
		}else if("".equals(Utility.getName(po.getCreatestarttime())) && !"".equals(Utility.getName(po.getCreateendtime()))){
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= '"+po.getCreateendtime()+"' ");
		}	
		if(!"".equals(Utility.getName(po.getCstifinanceauditperson()))){//财务审核人查询
			sb.append("and C_ST_I_FinanceAuditPerson='"+po.getCstifinanceauditperson()+"'");
		}
		if(!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + '"+Utility.getName(po.getCstigoodsname())+"' + '%' ");
		}
		if(!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("and C_ST_IE_GoodsId like '%' + '"+Utility.getName(po.getCstigoodsid())+"' + '%' ");
		}
		if(!"".equals(Utility.getName(po.getCstifinanceauditpersonname()))){//财务审核人查询
			sb.append("and b.personName like '%' + '"+po.getCstifinanceauditpersonname()+"' + '%' ");
		}
		if(!"".equals(Utility.getName(po.getDeliveryID()))){//财务审核人查询
			sb.append("and C_ST_I_DeliveryID like '%' + '"+po.getDeliveryID()+"' + '%' ");
		}
		if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
			sb.append("and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
		}
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

	/**
	 * 遍历财务结算信息
	 * @param po
	 * @return
	 */
	public List<InventoryEntryPo> getFinancialSettlementEntryList(InventoryPo po) {
		StringBuffer sb=new StringBuffer();	
		sb.append("select C_ST_IE_ID as cstieid,");		//UUID主键
		sb.append("C_ST_IE_GoodsId as cstiegoodsid,");	//商品代码
		sb.append("B_GoodsInfo.B_GI_ViewGoodsName as cstiegoodsname,");	//商品名称
		sb.append("C_ST_IE_GoodsQuantity as cstiegoodsquantity,");	//商品数量
		sb.append("B_GoodsInfo.B_GI_Spec as cstiespec,");	//商品规格			
		sb.append("C_ST_IE_NotTaxRate as cstienottaxrate,");	//单位成本(不含税)
		sb.append("B_GoodsInfo.B_GI_RetailPrice as bgcretailPrice,");//零售价
		sb.append("C_ST_IE_NotTaxRateAmount as cstienottaxrateamount,");	//成本合计(不含税)
		sb.append("C_ST_IE_TaxRate as cstietaxrate,");	//税率
		sb.append("C_ST_IE_CostPrice as cstiecostprice,");	//含税单价
		sb.append("C_ST_IE_CostPriceAmount as cstiecostpriceamount,");	//价税合计
		sb.append("C_ST_IE_TaxAmount as cstietaxamount,");	//税额合计		
		sb.append("C_ST_IE_InStockId as cstieinstockid,");	//收入仓位	
		sb.append("C_ST_IE_BarCode as cstiebarcode ");	//商品条码
		
		sb.append("from C_ST_InventoryEntry ");
		sb.append("inner join B_GoodsInfo on C_ST_InventoryEntry.C_ST_IE_GoodsId=B_GoodsInfo.B_GI_GoodsID ");	//左外商品信息表
		
		sb.append("where C_ST_IE_BillID='"+po.getCstibillid()+"'");		//根据单据编号查询	
		
		return queryForObjectList(sb.toString(), null, InventoryEntryPo.class);
	}

	
	
	/**
	 * 查询财务结算
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	
	public List<InventoryPo> getFinancialSettlementList(InventoryPo po,
			int start, int size) {
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");

		sb.append("select * from(select ROW_NUMBER() ");
		sb.append("Over(order by cstibilldate desc) as rowNum,* from ( select distinct ");
		sb.append("C_ST_I_BillID as cstibillid,");	//单据编号
		sb.append("C_ST_I_DeliveryID as deliveryID,");
		sb.append("C_ST_I_SourceBillId as cstisourcebillid,");	//订单号 
		sb.append("C_ST_I_BillTypeId as cstibilltypeid,");	//单据类型
		sb.append("C_ST_I_billDate as cstibilldate,");	//单据日期
		sb.append("B_Warehouse.B_WH_warehouseName as cstiinstockname,");	//仓位名称
		sb.append("C_ST_I_FinanceAuditState as cstifinanceauditstate,");	//财务结算审核状态
		sb.append("b.personName as cstifinanceauditpersonname ,");	//财务结算审核人姓名
		sb.append("B_SP_SupplierName as cstisuppliername,");	//制造商名称
		sb.append("B_GC_GoodsCategoryName as cstigoodscategoryname,");
		sb.append("C_ST_I_FinanceAuditDate as cstifinanceauditdate ");	//财务结算审核日期
		sb.append("from C_ST_Inventory ");
	
		if(!"".equals(Utility.getName(po.getCstigoodsname())) || !"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
			sb.append("inner join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID ");
		}	
		
		sb.append("inner join B_Supplier on C_ST_I_SupplierId=B_SP_ID ");	//内联制造商表
		sb.append("inner join B_Warehouse on C_ST_I_InStockId=B_Warehouse.B_WH_ID ");	//左外联仓位表
		sb.append("left join B_GoodsCategory on B_GC_ID = C_ST_I_GoodsCategory ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_I_FinanceAuditPerson=b.ID ");	//左外人员表
		sb.append("left join SYS_PersonInfo r on C_ST_I_AuditPerson=r.ID ");
		
		sb.append(" left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");	
		
		sb.append("where C_ST_I_AuditState='1' ");	//审核状态为已审核
		sb.append("and C_ST_I_BillTypeId in('1')");	//1、采购收货单PIN；7、其他入库 OTI；9、委外收货单CPIN
		
		if (!"".equals(Utility.getName(po.getCsticompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCsticompanyid()));	
		}
	
		if(!"".equals(Utility.getName(po.getCstiauditpersonname()))){
			sb.append("and r.personName like'%"+po.getCstiauditpersonname()+"%' ");
		}
		if(!"".equals(Utility.getName(po.getCstibillid()))){	//单据编号查询
			sb.append("and C_ST_I_BillID like'%"+po.getCstibillid()+"%' ");//quyanping
		}
		if(!"".equals(Utility.getName(po.getCstisourcebillid()))){	//订单编号查询
			sb.append("and C_ST_I_SourceBillId like'%"+po.getCstisourcebillid()+"%' ");//quyanping
		}			
		if(!"".equals(Utility.getName(po.getCstibilltypeid()))){	//单据类型查询
			sb.append("and C_ST_I_BillTypeId='"+po.getCstibilltypeid()+"' ");
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {	//制造商查询
			sb.append("and C_ST_I_SupplierId='"+po.getCstisupplierid()+"' ");
		}		
		if(!"".equals(Utility.getName(po.getCstigoodscategory()))){
			sb.append("and C_ST_I_GoodsCategory='"+po.getCstigoodscategory()+"' ");
		}
		if(!"".equals(Utility.getName(po.getCstiinstockid()))){		//收入仓位查询
			sb.append("and C_ST_I_InStockId='"+po.getCstiinstockid()+"' ");
		}
		if(!"".equals(Utility.getName(po.getCstifinanceauditstate()))){		//财务审核状态查询
			sb.append("and C_ST_I_FinanceAuditState='"+po.getCstifinanceauditstate()+"' ");
		}
		if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
			sb.append("and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
		}
		if(!"".equals(Utility.getName(po.getCstistartTime())) && !"".equals(Utility.getName(po.getCstiendTime()))){		//财务审核日期查询
			sb.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) >= '"+po.getCstistartTime()+"' ");
			sb.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) <= '"+po.getCstiendTime()+"' ");
		}else if(!"".equals(Utility.getName(po.getCstistartTime())) && "".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) >= '"+po.getCstistartTime()+"' ");
		}else if("".equals(Utility.getName(po.getCstistartTime())) && !"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) <= '"+po.getCstiendTime()+"' ");
		}	
		if(!"".equals(Utility.getName(po.getCreatestarttime())) && !"".equals(Utility.getName(po.getCreateendtime()))){		//财务审核日期查询
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= '"+po.getCreatestarttime()+"' ");
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= '"+po.getCreateendtime()+"' ");
		}else if(!"".equals(Utility.getName(po.getCreatestarttime())) && "".equals(Utility.getName(po.getCreateendtime()))){
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= '"+po.getCreatestarttime()+"' ");
		}else if("".equals(Utility.getName(po.getCreatestarttime())) && !"".equals(Utility.getName(po.getCreateendtime()))){
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= '"+po.getCreateendtime()+"' ");
		}	
		if(!"".equals(Utility.getName(po.getCstifinanceauditperson()))){//财务审核人查询
			sb.append("and C_ST_I_FinanceAuditPerson='"+po.getCstifinanceauditperson()+"'");
		}
		if(!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + '"+Utility.getName(po.getCstigoodsname())+"' + '%' ");
		}
		if(!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("and C_ST_IE_GoodsId like '%' + '"+Utility.getName(po.getCstigoodsid())+"' + '%' ");
		}
		if(!"".equals(Utility.getName(po.getCstifinanceauditpersonname()))){//财务审核人查询
			sb.append("and b.personName like '%' + '"+po.getCstifinanceauditpersonname()+"' + '%' ");
		}
		if(!"".equals(Utility.getName(po.getDeliveryID()))){
			sb.append("and C_ST_I_DeliveryID like '%' + '"+po.getDeliveryID()+"' + '%' ");
		}
		
		sb.append(" )temp ) temp where rowNum > "+start+" and rowNum <= "+ (start + size));
		sb.append("set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(), InventoryPo.class);
	}

	
	
	/**
	 * 修改财务结算
	 * @param po
	 */
	public void updateFinancialSettlement(InventoryPo po) {
		StringBuffer sb=new StringBuffer();
		sb.append("update C_ST_Inventory set ");
		
		sb.append("C_ST_I_FinanceAuditPerson='"+po.getCstifinanceauditperson()+"',");
		sb.append("C_ST_I_FinanceAuditState='"+po.getCstifinanceauditstate()+"',");
		sb.append("C_ST_I_FinanceAuditDate=getdate() ");
		
		sb.append(" where C_ST_Inventory.C_ST_I_BillID='"+po.getCstibillid()+"' ");
		getJdbcTemplate().update(sb.toString());
	}
	
	/**
	 * 修改财务结算(批发收货)
	 * @param po
	 */
	public void updateStoreFinancialSettlement(InventoryPo po) {
		StringBuffer sb=new StringBuffer();
		sb.append("update C_ST_Inventory set ");
		
		sb.append("C_ST_I_FinanceAuditPerson='"+po.getCstifinanceauditperson()+"',");
		sb.append("C_ST_I_FinanceAuditState='"+po.getCstifinanceauditstate()+"',");
		sb.append("C_ST_I_FinanceAuditDate=getdate() ");
		
		sb.append(" where C_ST_I_StoreReceiptID = '"+po.getCstibillid()+"' ");
		getJdbcTemplate().update(sb.toString());
	}

	/**
	 * 修改业务单明细表信息
	 * @param po
	 */
	public void updateFinancialSettlementEntry(InventoryEntryPo po) {
		
		StringBuffer sb=new StringBuffer();
		sb.append("update C_ST_InventoryEntry set ");
		
		sb.append("C_ST_IE_NotTaxRate='"+po.getCstienottaxrate()+"',");		
		sb.append("C_ST_IE_NotTaxRateAmount='"+po.getCstienottaxrateamount()+"',");
		sb.append("C_ST_IE_CostPrice='"+po.getCstiecostprice()+"',");
		sb.append("C_ST_IE_CostPriceAmount='"+po.getCstiecostpriceamount()+"',");
		sb.append("C_ST_IE_TaxRate='"+po.getCstietaxrate()+"',");
		if (!"".equals(Utility.getName(po.getBgcretailPrice()))){
			sb.append("C_ST_IE_RetailPrice='"+po.getBgcretailPrice()+"',");
		}
		sb.append("C_ST_IE_TaxAmount='"+po.getCstietaxamount()+"'");
		
		sb.append(" where C_ST_IE_ID='"+po.getCstieid()+"'");
		getJdbcTemplate().update(sb.toString());
	}
	
	/**
	 * 批量财务结算
	 * @param po
	 */
	public void insertFinancialSettlementBatch(InventoryPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update C_ST_Inventory set ");		
		sb.append("C_ST_I_FinanceAuditPerson = ?, ");		
		sb.append("C_ST_I_FinanceAuditState = '1', ");	
		sb.append("C_ST_I_FinanceAuditDate = getdate() ");		
		sb.append(" where C_ST_I_BillID = ? ");	
		
		params.add(Utility.getName(po.getCstifinanceauditperson()));
		params.add(Utility.getName(po.getCstibillid()));		
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 批量财务结算
	 * @param po
	 */
	public void insertFinancialSettlementEntryBatch(InventoryPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update C_ST_InventoryEntry set ");		
		sb.append("C_ST_IE_NotTaxRateAmount = cast((C_ST_IE_GoodsQuantity * C_ST_IE_NotTaxRate) as numeric(30,2)), ");		
		sb.append("C_ST_IE_CostPriceAmount = cast((C_ST_IE_GoodsQuantity * C_ST_IE_CostPrice) as numeric(30,2)), ");	
		sb.append("C_ST_IE_TaxAmount = (cast((C_ST_IE_GoodsQuantity * C_ST_IE_CostPrice) as numeric(30,2)) - cast((C_ST_IE_GoodsQuantity * C_ST_IE_NotTaxRate) as numeric(30,2))) ");		
		sb.append(" where C_ST_IE_BillID = ? ");	

		params.add(Utility.getName(po.getCstibillid()));		
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}


}
