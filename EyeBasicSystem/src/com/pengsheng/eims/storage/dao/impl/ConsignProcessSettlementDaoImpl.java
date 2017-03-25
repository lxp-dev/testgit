package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.storage.dao.ConsignProcessSettlementDao;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ConsignProcessSettlementDaoImpl extends BaseJdbcDaoSupport
		implements ConsignProcessSettlementDao {

	/**
	 * 查询委外收货结算数量
	 * 
	 * @param po
	 * @return
	 */
	public int getConsignProcessSettlementCount(InventoryPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select count(distinct C_ST_Inventory.C_ST_I_BillID) from C_ST_Inventory ");
		
		if(!"".equals(Utility.getName(po.getCstigoodsname())) || !"".equals(Utility.getName(po.getCstigoodscategory())) || !"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append(" inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID inner join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID ");
		}
		
		sb.append("inner join B_Supplier on C_ST_I_SupplierId=B_SP_ID "); // 内联制造商表
		sb.append("inner join B_Warehouse on C_ST_I_InStockId=B_Warehouse.B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID "); // 左外联仓位表
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_I_FinanceAuditPerson=b.ID "); // 左外人员表
		sb.append("where C_ST_I_AuditState='1' "); // 审核状态为已审核
		sb.append("and C_ST_I_BillTypeId in('9')"); // 1、采购收货单PIN；7、其他入库
													// OTI；9、委外收货单CPIN
		if (!"".equals(Utility.getName(po.getCsticompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCsticompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getCstiinstockid()))){
		    sb.append(" and C_ST_I_InStockId = ? ");
			params.add(Utility.getName(po.getCstiinstockid()));	
		}
		
		if (!"".equals(Utility.getName(po.getCstibillid()))) { // 单据编号查询
			sb.append("and C_ST_I_BillID like '%'+ ? +'%' ");//quyanping
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) { // 订单编号查询
			sb.append("and C_ST_I_DeliveryID like '%' + ? + '%' ");//quyanping
			params.add(po.getCstisourcebillid());
		}

		if (!"".equals(Utility.getName(po.getCstisupplierid()))) { // 制造商查询
			sb.append("and C_ST_I_SupplierId= ? ");
			params.add(po.getCstisupplierid());
		}

		if (!"".equals(Utility.getName(po.getCstifinanceauditstate()))) { // 财务审核状态查询
			if("0".equals(Utility.getName(po.getCstifinanceauditstate())))
			{
				sb.append("and (C_ST_I_FinanceAuditState= ? or C_ST_I_FinanceAuditState is null) ");
			}else
			{
				sb.append("and C_ST_I_FinanceAuditState= ?  ");
			}
			
			params.add(po.getCstifinanceauditstate());
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) { // 财务审核日期查询
			sb
					.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) >= ? ");
			sb
					.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) <= ? ");
			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());

		} else if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& "".equals(Utility.getName(po.getCstiendTime()))) {
			sb
					.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) >=  ? ");
			params.add(po.getCstistartTime());
		} else if ("".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb
					.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) <= ? ");
			params.add(po.getCstiendTime());
		}

		if (!"".equals(Utility.getName(po.getCstifinanceauditperson()))) {// 财务审核人查询
			sb.append("and C_ST_I_FinanceAuditPerson=?");
			params.add(po.getCstifinanceauditperson());
		}
		if(!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsname()));
		}
		if(!"".equals(Utility.getName(po.getCstigoodscategory()))){
			sb.append("and B_GI_GoodsCategoryID= ? ");
			params.add(Utility.getName(po.getCstigoodscategory()));
		}
		if(!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("and C_ST_IE_GoodsId like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsid()));
		}
		if (!"".equals(Utility.getName(po.getCstifinanceauditpersonname()))) {// 财务审核人查询
			sb.append("and b.personName like '%' + ? + '%' ");
			params.add(po.getCstifinanceauditpersonname());
		}
		if(!"".equals(Utility.getName(po.getCreatestarttime())) && !"".equals(Utility.getName(po.getCreateendtime()))){		//财务审核日期查询
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= '"+po.getCreatestarttime()+"' ");
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= '"+po.getCreateendtime()+"' ");
		}else if(!"".equals(Utility.getName(po.getCreatestarttime())) && "".equals(Utility.getName(po.getCreateendtime()))){
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= '"+po.getCreatestarttime()+"' ");
		}else if("".equals(Utility.getName(po.getCreatestarttime())) && !"".equals(Utility.getName(po.getCreateendtime()))){
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= '"+po.getCreateendtime()+"' ");
		}	
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 显示委外收货结算主表信息并分页
	 * 
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> getConsignProcessSettlementList(InventoryPo po,
			int start, int size) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");

		sb.append("select * from(select ROW_NUMBER() ");
		sb.append("Over(order by cstibilldate desc) as rowNum,* from ( select distinct ");
		sb.append("C_ST_I_BillID as cstibillid,"); // 单据编号
		sb.append("C_ST_I_SourceBillId as cstisourcebillid,"); // 订单号
		sb.append("C_ST_I_BillTypeId as cstibilltypeid,"); // 单据类型
		sb.append("C_ST_I_billDate as cstibilldate,"); // 单据日期
		sb.append("B_Warehouse.B_WH_warehouseName as cstiinstockname,"); // 仓位名称
		sb.append("C_ST_I_FinanceAuditState as cstifinanceauditstate,"); // 财务结算审核状态
		sb.append("b.personName as cstifinanceauditpersonname ,"); // 财务结算审核人姓名
		sb.append("B_SP_SupplierName as cstisuppliername,"); // 制造商名称
		sb.append("C_ST_I_DeliveryID as deliveryID,");
		sb.append("C_ST_I_FinanceAuditDate as cstifinanceauditdate "); // 财务结算审核日期
		sb.append("from C_ST_Inventory ");
		
		if(!"".equals(Utility.getName(po.getCstigoodsname())) || !"".equals(Utility.getName(po.getCstigoodscategory())) || !"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append(" inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID inner join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID ");
		}
		
		sb.append("inner join B_Supplier on C_ST_I_SupplierId=B_SP_ID "); // 内联制造商表
		sb.append("inner join B_Warehouse on C_ST_I_InStockId=B_Warehouse.B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID "); // 左外联仓位表
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_I_FinanceAuditPerson=b.ID "); // 左外人员表
		sb.append("where C_ST_I_AuditState='1' "); // 审核状态为已审核
		sb.append("and C_ST_I_BillTypeId in('9')"); // 1、采购收货单PIN；7、其他入库
													// OTI；9、委外收货单CPIN
		if (!"".equals(Utility.getName(po.getCsticompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCsticompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getCstiinstockid()))){
		    sb.append(" and C_ST_I_InStockId = ? ");
			params.add(Utility.getName(po.getCstiinstockid()));	
		}
		
		if (!"".equals(Utility.getName(po.getCstibillid()))) { // 单据编号查询
			sb.append("and C_ST_I_BillID like '%'+ ? +'%'  ");//quyanping
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) { // 订单编号查询
			sb.append("and C_ST_I_DeliveryID like '%'+ ? +'%' ");//quyanping
			params.add(po.getCstisourcebillid());
		}

		if (!"".equals(Utility.getName(po.getCstisupplierid()))) { // 制造商查询
			sb.append("and C_ST_I_SupplierId= ? ");
			params.add(po.getCstisupplierid());
		}
		if(!"".equals(Utility.getName(po.getCreatestarttime())) && !"".equals(Utility.getName(po.getCreateendtime()))){		//财务审核日期查询
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= '"+po.getCreatestarttime()+"' ");
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= '"+po.getCreateendtime()+"' ");
		}else if(!"".equals(Utility.getName(po.getCreatestarttime())) && "".equals(Utility.getName(po.getCreateendtime()))){
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= '"+po.getCreatestarttime()+"' ");
		}else if("".equals(Utility.getName(po.getCreatestarttime())) && !"".equals(Utility.getName(po.getCreateendtime()))){
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= '"+po.getCreateendtime()+"' ");
		}	
		if (!"".equals(Utility.getName(po.getCstifinanceauditstate()))) { // 财务审核状态查询
			if("0".equals(Utility.getName(po.getCstifinanceauditstate())))
			{
				sb.append("and (C_ST_I_FinanceAuditState= ? or C_ST_I_FinanceAuditState is null) ");
			}else
			{
				sb.append("and C_ST_I_FinanceAuditState= ?  ");
			}
			params.add(po.getCstifinanceauditstate());
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) { // 财务审核日期查询
			sb
					.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) >= ? ");
			sb
					.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) <= ? ");
			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());
		} else if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& "".equals(Utility.getName(po.getCstiendTime()))) {
			sb
					.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) >=  ? ");
			params.add(po.getCstistartTime());
		} else if ("".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb
					.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) <= ? ");
			params.add(po.getCstiendTime());
		}

		if (!"".equals(Utility.getName(po.getCstifinanceauditperson()))) {// 财务审核人查询
			sb.append("and C_ST_I_FinanceAuditPerson= ? ");
			params.add(po.getCstifinanceauditperson());
		}
		if(!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsname()));
		}
		if(!"".equals(Utility.getName(po.getCstigoodscategory()))){
			sb.append("and B_GI_GoodsCategoryID= ? ");
			params.add(Utility.getName(po.getCstigoodscategory()));
		}
		if(!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("and C_ST_IE_GoodsId like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsid()));
		}
		if (!"".equals(Utility.getName(po.getCstifinanceauditpersonname()))) {// 财务审核人查询
			sb.append("and b.personName like '%' + ? + '%' ");
			params.add(po.getCstifinanceauditpersonname());
		}
		
		sb.append(" ) temp ) temp where rowNum > " + start + " and rowNum <= "
				+ (start + size));
		sb.append("set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),
				InventoryPo.class);
	}

	/**
	 * 委外收货结算业务单明细表信息
	 * 
	 * @param po
	 * @return qiyue
	 */
	public List<InventoryEntryPo> getConsignProcessSettlementDetailsList(
			InventoryPo po) {
		StringBuffer sb = new StringBuffer();

		sb.append("select C_ST_IE_ID as cstieid,"); // UUID主键
		sb.append("C_ST_IE_GoodsId as cstiegoodsid,"); // 商品代码
		sb.append("B_GoodsInfo.B_GI_ViewGoodsName as cstiegoodsname,"); // 商品名称
		sb.append("C_ST_IE_GoodsQuantity as cstiegoodsquantity,"); // 商品数量
		sb.append("B_GoodsInfo.B_GI_Spec as cstiespec,"); // 商品规格
		sb.append("C_ST_IE_NotTaxRate as cstienottaxrate,"); // 单位成本(不含税)
		sb.append("C_ST_IE_NotTaxRateAmount as cstienottaxrateamount,"); // 成本合计(不含税)
		sb.append("C_ST_IE_TaxRate as cstietaxrate,"); // 税率
		sb.append("C_ST_IE_CostPrice as cstiecostprice,"); // 含税单价
		sb.append("C_ST_IE_CostPriceAmount as cstiecostpriceamount,"); // 价税合计
		sb.append("C_ST_IE_TaxAmount as cstietaxamount,"); // 税额合计
		sb.append("C_ST_IE_InStockId as cstieinstockid,"); // 收入仓位
		sb.append("C_ST_IE_BarCode as cstiebarcode "); // 商品条码

		sb.append("from C_ST_InventoryEntry ");
		sb
				.append("inner join B_GoodsInfo on C_ST_InventoryEntry.C_ST_IE_GoodsId=B_GoodsInfo.B_GI_GoodsID "); // 左外商品信息表
		List<String> params = new ArrayList<String>();
		sb.append("where C_ST_IE_BillID= ? "); // 根据单据编号查询
		params.add(po.getCstibillid());
		return queryForObjectList(sb.toString(), params.toArray(),
				InventoryEntryPo.class);
	}

	/**
	 * 委外收货结算详细
	 * 
	 * @param po
	 * @return
	 */
	public InventoryPo getConsignProcessSettlement(InventoryPo po) {
		StringBuffer sb = new StringBuffer();
		sb.append("select top 1  C_ST_I_BillID as cstibillid,"); // 单据编号
		sb.append("C_ST_I_SourceBillId as cstisourcebillid,"); // 订单号
		sb.append("C_ST_I_billDate as cstibilldate,C_ST_I_DeliveryID as deliveryID, "); // 单据日期
		sb.append("C_ST_I_SupplierId as cstisupplierid,"); // 所属制造商编号
		sb.append("B_Supplier.B_SP_SupplierName as cstisuppliername,"); // 所属制造商名称
		sb.append("C_ST_I_BillTypeId as cstibilltypeid,"); // 入库类型
		sb.append("C_ST_I_InStockId as cstiinstockid,"); // 入库仓位编号
		sb.append("B_Warehouse.B_WH_warehouseName as cstiinstockname,"); // 入库仓位名称
		sb.append("a.personName as csticreatepersonname,"); // 制单人名称
		sb.append("b.personName as cstiauditpersonname,"); // 入库审核人名称
		sb.append("C_ST_I_AuditDate as cstiauditdate,"); // 入库审核日期
		sb.append("C_ST_I_FinanceAuditPerson as cstifinanceauditperson,"); // 财务结算审核人
		sb.append("C_ST_I_FinanceAuditState as cstifinanceauditstate,"); // 财务结算审核状态
		sb.append("C_ST_I_FinanceAuditDate as cstifinanceauditdate,"); // 财务结算审核日期
		sb.append("C_ST_I_Remark as cstiremark "); // 备注

		sb.append("from C_ST_Inventory ");

		sb.append("inner join B_Supplier on C_ST_I_SupplierId=B_SP_ID "); // 内联制造商表
		sb
				.append("inner join B_Warehouse on C_ST_I_InStockId=B_Warehouse.B_WH_ID "); // 左外联仓位表

		sb
				.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_I_createPerson=a.ID ");// 左外人员表,制单人
		sb
				.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_I_AuditPerson=b.ID "); // 左外人员表,审核人
		List<String> params = new ArrayList<String>();

		sb.append("where C_ST_I_BillID= ? ");
		params.add(po.getCstibillid());
		return (InventoryPo) queryForObject(sb.toString(), params.toArray(),
				InventoryPo.class);
	}

	/**
	 * 修改委外收货结算主表信息
	 * 
	 * @param po
	 */
	public void updateConsignProcessSettlement(InventoryPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("update C_ST_Inventory set ");

		sb.append("C_ST_I_FinanceAuditState= ? ");
		if ("1".equals(po.getCstifinanceauditstate())) {
			sb.append(",C_ST_I_FinanceAuditPerson= ? ");
			sb.append(",C_ST_I_FinanceAuditDate= getdate() ");
		}
		
		sb.append(" where C_ST_Inventory.C_ST_I_BillID= ? ");		
		params.add(po.getCstifinanceauditstate());
		if ("1".equals(po.getCstifinanceauditstate())) {
			params.add(po.getCstifinanceauditperson());
		}
		params.add(po.getCstibillid());

		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	/**
	 * 修改委外收货结算明细表信息
	 * 
	 * @param po
	 */
	public void updateConsignProcessSettlementDetails(InventoryEntryPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("update C_ST_InventoryEntry set ");

		sb.append("C_ST_IE_NotTaxRate= ? ,");
		sb.append("C_ST_IE_NotTaxRateAmount= ? ,");
		sb.append("C_ST_IE_CostPrice=? ,");
		sb.append("C_ST_IE_CostPriceAmount=? ,");
		sb.append("C_ST_IE_TaxRate=? ,");
		if (!"".equals(Utility.getName(po.getBgcretailPrice()))){
			sb.append("C_ST_IE_RetailPrice= ?, ");
		}
		sb.append("C_ST_IE_TaxAmount= ? ");
		sb.append(" where C_ST_IE_ID= ? ");
		
		params.add(po.getCstienottaxrate());
		params.add(po.getCstienottaxrateamount());
		params.add(po.getCstiecostprice());
		params.add(po.getCstiecostpriceamount());
		params.add(po.getCstietaxrate());
		if (!"".equals(Utility.getName(po.getBgcretailPrice()))){
			params.add(Utility.getName(po.getBgcretailPrice()));
		}
		params.add(po.getCstietaxamount());
		params.add(po.getCstieid());

		getJdbcTemplate().update(sb.toString(), params.toArray());

	}
}
