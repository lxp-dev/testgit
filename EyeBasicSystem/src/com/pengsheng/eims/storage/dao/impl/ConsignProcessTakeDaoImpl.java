package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.dao.ConsignProcessTakeDao;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;
import com.pengsheng.eims.storage.persistence.InventoryTempEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryTempPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.storage.persistence.StrogeLogPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ConsignProcessTakeDaoImpl extends BaseJdbcDaoSupport implements ConsignProcessTakeDao {
	/**
	 * 取委外订单主表
	 * 
	 */
	public ConsignProcessReceiptPo getConsignProcessReceipt(
			ConsignProcessReceiptPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		
		sb.append("SELECT TOP 1 S_ME_CI_Name                   AS cstcprcustomername, ");
		sb.append("             S_ME_CI_MemberId               AS cstcprcustomercardnumber, ");
		sb.append("             C_ST_CPR_ReceiptBillId         AS cstcprreceiptbillid, ");
		sb.append("             C_ST_CPR_SourceBillId          AS cstcprsourcebillid, ");
		sb.append("             C_ST_CPR_BillDate              AS cstcprbilldate, ");
		sb.append("             C_ST_CPR_SupplierId            AS cstcprsupplierid, ");
		sb.append("             B_Warehouse.B_WH_warehouseName AS cstcprinstockname, ");
		sb.append("             C_ST_CPR_Salesid               AS cstcprsalesid, ");
		sb.append("             C_ST_CPR_GoodsCategory         AS cstcprgoodscategory, ");
		sb.append("             C_ST_CPR_SupplierId            AS cstcprsupplierid, ");
		sb.append("             B_Supplier.B_SP_SupplierName   AS cstcprsuppliername, ");
		sb.append("             C_ST_CPR_DepartmentId          AS cstcprdepartmentid, ");
		sb.append("             C_ST_CPR_CreatePerson          AS cstcprcreateperson, ");
		sb.append("             C_ST_CPR_AuditPerson           AS cstcprauditperson, ");
		sb.append("             a.personName                   AS cstcprcreatepersonname, ");
		sb.append("             b.personName                   AS cstcprauditpersonname, ");
		sb.append("             C_ST_CPR_AuditState            AS cstcprauditstate, ");
		sb.append("             C_ST_CPR_AuditDate             AS cstcprauditdate, ");
		sb.append("             C_ST_CPR_WaybillID             AS cstcprwaybillid, ");
		sb.append("             C_ST_CPR_Remark                AS cstcprremark, ");
		sb.append("             B_DP_DepartmentName                AS cstcprshopcodename ");
		sb.append("FROM   C_ST_ConsignProcessReceipt ");
		sb.append("       INNER JOIN B_Supplier ");
		sb.append("         ON C_ST_CPR_SupplierId = B_Supplier.B_SP_ID ");
		sb.append("       INNER JOIN B_Warehouse ");
		sb.append("         ON C_ST_CPR_InStockId = B_Warehouse.B_WH_ID ");
		sb.append("       LEFT JOIN uview_SalesBasic ");
		sb.append("         ON S_SE_SB_SalesID = C_ST_CPR_Salesid ");
		sb.append("       LEFT JOIN S_ME_CustomerInfo ");
		sb.append("         ON S_SE_SB_CustomerID = S_ME_CI_CustomerID ");
		sb.append("       LEFT JOIN (SELECT ID, ");
		sb.append("                         personName ");
		sb.append("                  FROM   SYS_PersonInfo)a ");
		sb.append("         ON C_ST_CPR_CreatePerson = a.ID ");
		sb.append("       LEFT JOIN (SELECT ID, ");
		sb.append("                         personName ");
		sb.append("                  FROM   SYS_PersonInfo)b ");
		sb.append("         ON C_ST_CPR_AuditPerson = b.ID ");		
		sb.append("       LEFT JOIN B_Departments ");
		sb.append("         ON S_SE_SB_ShopCode = B_DP_DepartmentID ");		
		
		sb.append("WHERE  1=1 ");
		if(!"".equals(Utility.getName(po.getCstcprreceiptbillid()))){
			sb.append("  and C_ST_CPR_ReceiptBillId = ? ");
			params.add(po.getCstcprreceiptbillid());
		}
		
		if(!"".equals(Utility.getName(po.getCstcprsalesid()))){
			sb.append("  and C_ST_CPR_Salesid = ? ");
			params.add(po.getCstcprsalesid());
		}
		
		

		return (ConsignProcessReceiptPo) queryForObject(sb.toString(), params
				.toArray(), ConsignProcessReceiptPo.class);
	}

	/**
	 * 取委外订单明细
	 * 
	 */
	public List<ConsignProcessReceiptDetailsPo> getConsignProcessReceiptEntryList(
			ConsignProcessReceiptPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		
		sb.append("select B_GoodsInfo.B_GI_GoodsID as cstcprdgoodsid, ");
		sb.append("C_ST_CPRD_BarCode as cstcprdbarcode, ");
		sb.append("B_GoodsInfo.B_GI_CostPrice as cstcprdcostprice, ");
		sb.append("B_GoodsInfo.B_GI_NotTaxRate as cstcprdnottaxrate, ");
		sb.append("B_GoodsInfo.B_GI_TaxRate as cstcprdtaxrate, ");
		sb.append("B_GoodsInfo.B_GI_ViewGoodsName as cstcprdgoodsname, ");
		sb.append("B_GoodsInfo.B_GI_Spec as cstcprdspec, ");
		sb.append("B_GoodsInfo.B_GI_Color as cstcprdcolor,");
		sb.append("C_ST_CPOD_BallGlass as cstcprdsph, ");
		sb.append("C_ST_CPOD_PostGlass as cstcprdcyl, ");
		sb.append("B_GoodsInfo.B_GI_Axis as cstcprdaxis, ");
		sb.append("C_ST_CPOD_EyeCurvature as cstcprdcurvature, ");
		sb.append("B_GoodsInfo.B_GI_Dia as cstcprddia, ");
		sb.append("C_ST_CPRD_Num as cstcprdnum, ");
		sb.append("C_ST_CPRD_OrderDetailsID as cstcprdorderdetailsid, ");
		sb.append("B_GI_RetailPrice as cstcpretailprice, ");		
		sb.append("isnull(C_ST_CPRD_Guaranteeperiod,'') as cstcpguaranteeperiod, ");
		sb.append("isnull(C_ST_CPRD_Batch,'') as cstcpbatch, ");
		sb.append("isnull(C_ST_CPRD_RegistrationNum,'') as cstcpregistrationnum ");		
		sb.append("from C_ST_ConsignProcessReceiptDetails ");
		sb.append("inner join B_GoodsInfo ");
		sb.append("on C_ST_CPRD_GoodsID=B_GoodsInfo.B_GI_GoodsID ");
		sb.append("inner join C_ST_ConsignProcessOrderDetails ");
		sb.append("ON C_ST_CPRD_OrderDetailsID = C_ST_CPOD_Id ");

		sb.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getCstcprreceiptbillid()))){
			sb.append("  and C_ST_CPRD_ReceiptBillD= ? ");
			params.add(po.getCstcprreceiptbillid());
		}
		
		if(!"".equals(Utility.getName(po.getCstcprsalesid()))){
			sb.append("  and C_ST_CPOD_GlassesBillID = ? ");
			params.add(po.getCstcprsalesid());
		}

		return queryForObjectList(sb.toString(), params.toArray(),
				ConsignProcessReceiptDetailsPo.class);
	}
	
	/**
	 * 得到委外收货单数量
	 * 
	 */
	public int getConsignProcessReceiptCount(ConsignProcessReceiptPo po) {

		StringBuffer sb = new StringBuffer();

		List<String> params = new ArrayList<String>();

		sb.append("select count(distinct C_ST_CPR_ReceiptBillId) ");
		sb.append("from C_ST_ConsignProcessReceipt inner join C_ST_ConsignProcessReceiptDetails on C_ST_CPR_ReceiptBillId=C_ST_CPRD_ReceiptBillD inner join B_GoodsInfo on C_ST_CPRD_GoodsID=B_GI_GoodsID ");
		
		if(!"".equals(Utility.getName(po.getSalesdjsbm()))){
			sb.append(" left join S_SE_SalesBasic on S_SE_SB_SalesID = C_ST_CPR_Salesid ");
		}		
		
		sb.append("inner join B_Warehouse ");
		sb.append("on C_ST_CPR_InStockId=B_Warehouse.B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a ");
		sb.append("on C_ST_CPR_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b ");
		sb.append("on C_ST_CPR_AuditPerson=b.ID where 1=1 ");

		if (!"".equals(Utility.getName(po.getCstcprcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCstcprcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getSalesdjsbm()))){
			sb.append("and S_SE_SB_Djsbm like '%' + ? +'%'");
			params.add(po.getSalesdjsbm());
		}
		
		if (!"".equals(Utility.getName(po.getCstcprreceiptbillid()))) {
			sb.append("and C_ST_CPR_ReceiptBillId  like '%' + ? +'%' ");
			params.add(po.getCstcprreceiptbillid());
		}
		if (!"".equals(Utility.getName(po.getCstcprsourcebillid()))) {
			sb.append("and C_ST_CPR_Salesid like '%' + ? + '%' ");
			params.add(po.getCstcprsourcebillid());
		}

		if (!"".equals(Utility.getName(po.getCstcprinstockid()))) {
			sb.append("and C_ST_CPR_InStockId= ? ");
			params.add(po.getCstcprinstockid());
		}
		if (!"".equals(Utility.getName(po.getCstcprauditstate()))) {
			sb.append("and C_ST_CPR_AuditState= ? ");
			params.add(po.getCstcprauditstate());
		}
		if (!"".equals(Utility.getName(po.getCstcprstartTime()))
				&& !"".equals(Utility.getName(po.getCstcprendTime()))) {
			sb.append("and convert(varchar(10), C_ST_CPR_BillDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_CPR_BillDate, 23) <= ? ");
			params.add(po.getCstcprstartTime());
			params.add(po.getCstcprendTime());
		} else if (!"".equals(Utility.getName(po.getCstcprstartTime()))
				&& "".equals(Utility.getName(po.getCstcprendTime()))) {
			sb.append("and convert(varchar(10), C_ST_CPR_BillDate, 23) >= ? ");
			params.add(po.getCstcprstartTime());
		} else if ("".equals(Utility.getName(po.getCstcprstartTime()))
				&& !"".equals(Utility.getName(po.getCstcprendTime()))) {
			sb.append("and convert(varchar(10), C_ST_CPR_BillDate, 23) <= ? ");
			params.add(po.getCstcprendTime());
		}
		if (!"".equals(Utility.getName(po.getCstcprauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstcprauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_CPR_AuditDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_CPR_AuditDate, 23) <= ? ");
			params.add(po.getCstcprauditstartdate());
			params.add(po.getCstcprauditenddate());
		} else if (!"".equals(Utility.getName(po.getCstcprauditstartdate()))
				&& "".equals(Utility.getName(po.getCstcprauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_CPR_AuditDate, 23) >= ? ");
			params.add(po.getCstcprauditstartdate());
		} else if ("".equals(Utility.getName(po.getCstcprauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstcprauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_CPR_AuditDate, 23) <= ? ");
			params.add(po.getCstcprauditenddate());
		}
		if (!"".equals(Utility.getName(po.getCstcprauditperson()))) {// 审核人
			sb.append("and b.personName= ? ");
			params.add(po.getCstcprauditperson());
		}
		if (!"".equals(Utility.getName(po.getCstcprcreateperson()))) {// 制单人
			sb.append(" and a.personName= ? ");
			params.add(po.getCstcprcreateperson());
		}
		if(!"".equals(Utility.getName(po.getCstcprgoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstcprgoodsname()));
		}
		if(!"".equals(Utility.getName(po.getCstcprremark()))){
			sb.append("and C_ST_CPR_Remark like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstcprremark()));
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 取所有委外收货单
	 * 
	 */
	public List<ConsignProcessReceiptPo> getConsignProcessReceiptList(
			ConsignProcessReceiptPo po, int start, int size) {

		StringBuffer sb = new StringBuffer();

		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from( ");
		sb.append("select ROW_NUMBER() Over( ");
		sb.append("order by cstcprbilldate desc) as rowNum, ");
		sb.append(" * from ( select distinct ");
		sb.append("C_ST_CPR_ReceiptBillId as cstcprreceiptbillid, ");
		sb.append("C_ST_CPR_SourceBillId as cstcprsourcebillid, ");
		sb.append("C_ST_CPR_Salesid as cstcprsalesid, ");
		sb.append("C_ST_CPR_BillDate as cstcprbilldate, ");
		sb.append("C_ST_CPR_AuditDate as cstcprauditdate, ");
		sb.append("B_WH_warehouseName as cstcprinstockname, ");
		sb.append("C_ST_CPR_AuditState as cstcprauditstate, ");
		sb.append("B_SP_SupplierName as cstcprsuppliername , ");
		sb.append("a.personName as cstcprcreatepersonname, ");
		sb.append("b.personName as cstcprauditpersonname, ");
		sb.append("C_ST_CPR_Remark as cstcprremark ");
		
		sb.append("from C_ST_ConsignProcessReceipt inner join C_ST_ConsignProcessReceiptDetails on C_ST_CPR_ReceiptBillId=C_ST_CPRD_ReceiptBillD inner join B_GoodsInfo on C_ST_CPRD_GoodsID=B_GI_GoodsID ");
		
		if(!"".equals(Utility.getName(po.getSalesdjsbm()))){
			sb.append(" left join S_SE_SalesBasic on S_SE_SB_SalesID = C_ST_CPR_Salesid ");
		}	
		
		sb.append("inner join B_Supplier on B_Supplier.B_SP_ID = C_ST_CPR_SupplierId ");
		sb.append("inner join B_Warehouse ");
		sb.append("on C_ST_CPR_InStockId=B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a ");
		sb.append("on C_ST_CPR_CreatePerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b ");
		sb.append("on C_ST_CPR_AuditPerson=b.ID ");
		sb.append("where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getCstcprcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCstcprcompanyid()));	
		}

		if(!"".equals(Utility.getName(po.getSalesdjsbm()))){
			sb.append("and S_SE_SB_Djsbm like '%' + ? +'%'");
			params.add(po.getSalesdjsbm());
		}
		
		if (!"".equals(Utility.getName(po.getCstcprreceiptbillid()))) {
			sb.append("and C_ST_CPR_ReceiptBillId like '%' + ? +'%'  ");
			params.add(po.getCstcprreceiptbillid());
		}
		if (!"".equals(Utility.getName(po.getCstcprsourcebillid()))) {
			sb.append("and C_ST_CPR_Salesid like '%' + ? +'%' ");
			params.add(po.getCstcprsourcebillid());
		}

		if (!"".equals(Utility.getName(po.getCstcprinstockid()))) {
			sb.append("and C_ST_CPR_InStockId= ? ");
			params.add(po.getCstcprinstockid());
		}
		if (!"".equals(Utility.getName(po.getCstcprauditstate()))) {
			sb.append("and C_ST_CPR_AuditState= ? ");
			params.add(po.getCstcprauditstate());
		}
		if (!"".equals(Utility.getName(po.getCstcprstartTime()))
				&& !"".equals(Utility.getName(po.getCstcprendTime()))) {
			sb.append("and convert(varchar(10), C_ST_CPR_BillDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_CPR_BillDate, 23) <= ? ");
			params.add(po.getCstcprstartTime());
			params.add(po.getCstcprendTime());
		} else if (!"".equals(Utility.getName(po.getCstcprstartTime()))
				&& "".equals(Utility.getName(po.getCstcprendTime()))) {
			sb.append("and convert(varchar(10), C_ST_CPR_BillDate, 23) >= ? ");
			params.add(po.getCstcprstartTime());
		} else if ("".equals(Utility.getName(po.getCstcprstartTime()))
				&& !"".equals(Utility.getName(po.getCstcprendTime()))) {
			sb.append("and convert(varchar(10), C_ST_CPR_BillDate, 23) <= ? ");
			params.add(po.getCstcprendTime());
		}
		if (!"".equals(Utility.getName(po.getCstcprauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstcprauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_CPR_AuditDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_CPR_AuditDate, 23) <= ? ");
			params.add(po.getCstcprauditstartdate());
			params.add(po.getCstcprauditenddate());
		} else if (!"".equals(Utility.getName(po.getCstcprauditstartdate()))
				&& "".equals(Utility.getName(po.getCstcprauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_CPR_AuditDate, 23) >= ? ");
			params.add(po.getCstcprauditstartdate());
		} else if ("".equals(Utility.getName(po.getCstcprauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstcprauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_CPR_AuditDate, 23) <= ? ");
			params.add(po.getCstcprauditenddate());
		}
		if (!"".equals(Utility.getName(po.getCstcprauditperson()))) {// 审核人
			sb.append("and b.personName= ? ");
			params.add(po.getCstcprauditperson());
		}
		if (!"".equals(Utility.getName(po.getCstcprcreateperson()))) {// 制单人
			sb.append(" and a.personName= ? ");
			params.add(po.getCstcprcreateperson());
		}
		if(!"".equals(Utility.getName(po.getCstcprgoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstcprgoodsname()));
		}
		if(!"".equals(Utility.getName(po.getCstcprremark()))){
			sb.append("and C_ST_CPR_Remark like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstcprremark()));
		}

		sb.append(" ) temp ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),
				ConsignProcessReceiptPo.class);
	}
	
	/**
	 * 得到顾客信息
	 * @param consignProcessOrderDetailsPo
	 * @return
	 */
	public ConsignProcessOrderDetailsPo getCustomer(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1 C_ST_CPOD_customerName as cstcpodcustomername , ");
		buffer.append("S_ME_CI_Phone as cstcpocustomertel , ");
		buffer.append("C_ST_CPOD_GlassesBillID as cstcpodglassesbillid , ");
		buffer.append("C_ST_CPOD_ArrivedDate as cstcpodarriveddate , ");
		buffer.append("C_ST_CPOD_BillType as cstcpodbilltype , ");
		buffer.append("C_ST_CPOD_OrderBillD as cstcpodorderbilld , ");
		buffer.append("C_ST_CPO_SupplierId as cstcposupplierid , ");
		buffer.append("C_ST_CPO_OrderGoodsCategory as cstcpogoodscategory , ");
		buffer.append("B_SP_SupplierName as cstcposuppliername, ");
		buffer.append("B_DP_DepartmentName as cstcpdptname ");
		buffer.append("from C_ST_ConsignProcessOrderDetails ");
		buffer.append("left join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_customerID ");
		buffer.append("left join S_SE_SalesBasic on C_ST_CPOD_GlassesBillID = S_SE_SB_SalesID left join B_Departments on S_SE_SB_ShopCode = B_DP_DepartmentID ");
		buffer.append("inner join C_ST_ConsignProcessOrder on C_ST_ConsignProcessOrder.C_ST_CPO_OrderBillId = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_OrderBillD ");
		buffer.append("inner join B_Supplier on B_Supplier.B_SP_ID = C_ST_ConsignProcessOrder.C_ST_CPO_SupplierId ");
		buffer.append("where C_ST_CPOD_GlassesBillID = ? and C_ST_CPOD_State = '0' ");
		
		buffer.append("group by C_ST_CPOD_customerName , S_ME_CI_Phone , ");
		buffer.append("C_ST_CPOD_GlassesBillID , C_ST_CPOD_ArrivedDate , C_ST_CPOD_BillType , ");
		buffer.append("C_ST_CPOD_OrderBillD , B_SP_SupplierName , ");
		buffer.append("C_ST_CPO_SupplierId , C_ST_CPO_OrderGoodsCategory,B_DP_DepartmentName ");
		
		params.add(consignProcessOrderDetailsPo.getCstcpodglassesbillid());
		
		return (ConsignProcessOrderDetailsPo) queryForObject(buffer.toString() , params.toArray() , ConsignProcessOrderDetailsPo.class);
	}

	/**
	 * 得到商品信息 柱镜、球镜等
	 * @param consignProcessOrderDetailsPo
	 * @return
	 */
	public List<ConsignProcessOrderDetailsPo> getGoods(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select C_ST_CPOD_GlassFlag as cstcpodglassflag , ");
		buffer.append("B_GI_GoodsId 			as cstcpodgoodsid , ");
		buffer.append("B_GI_ViewGoodsName 		as cstcpogoodsname , ");
		buffer.append("C_ST_CPOD_BallGlass 		as cstcpodballglass , ");
		buffer.append("C_ST_CPOD_PostGlass 		as cstcpodpostglass , ");
		buffer.append("C_ST_CPOD_Axes 			as cstcpodaxes , ");
		buffer.append("C_ST_CPOD_Add 			as cstcpodadd , ");
		buffer.append("C_ST_CPOD_ArriseGlass 	as cstcpodarriseglass , ");
		buffer.append("C_ST_CPOD_Basis 			as cstcpodbasis , ");
		buffer.append("C_ST_CPOD_Requirement 	as cstcpodrequirement , ");
		buffer.append("C_ST_CPOD_Num 			as cstcpodnum, ");
		buffer.append("B_GI_RetailPrice 		as cstcpretailprice ");
		buffer.append("from C_ST_ConsignProcessOrderDetails ");
		buffer.append("inner join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_GoodsID ");
		buffer.append("where C_ST_CPOD_GlassesBillID = ? ");
		
		params.add(consignProcessOrderDetailsPo.getCstcpodglassesbillid());
		
		return queryForObjectList(buffer.toString() , params.toArray() , ConsignProcessOrderDetailsPo.class);
	}

	/**
	 * 得到商品信息 代码、批号、收入仓位
	 * @param consignProcessOrderDetailsPo
	 * @return
	 */
	public List<ConsignProcessOrderDetailsPo> getGoodsWarehouse(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select B_GI_ViewGoodsName as cstcpogoodsname , ");
		buffer.append("C_ST_CPOD_GlassFlag as cstcpodglassflag , ");
		buffer.append("C_ST_CPOD_GoodsID as cstcpodgoodsid , ");
		buffer.append("C_ST_CPOD_Num as cstcpodnum , ");
		buffer.append("B_GI_NotTaxRate as cstcponottaxrate , ");
		buffer.append("B_GI_TaxRate as cstcpotaxrate , ");
		buffer.append("B_GI_CostPrice as cstcpocostprice , ");
		buffer.append("C_ST_CPOD_Id as cstcpodid, ");
		buffer.append("C_ST_CPOD_SalesID as cstcpodsalesid, ");
		buffer.append("B_GI_RetailPrice as cstcpretailprice, ");
		buffer.append("isnull(B_BD_RegistrationNum,'') as cstcpregistrationnum ");
		buffer.append("from C_ST_ConsignProcessOrderDetails ");
		buffer.append("inner join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_GoodsID ");
		buffer.append("inner join B_Brand on B_BD_ID = B_GI_BrandID and B_BD_SupplierID = B_GI_SupplierID ");
		buffer.append("where C_ST_CPOD_GlassesBillID = ? ");
		
		params.add(consignProcessOrderDetailsPo.getCstcpodglassesbillid());
		
		return queryForObjectList(buffer.toString() , params.toArray() , ConsignProcessOrderDetailsPo.class);
	}

	/**
	 * 得到仓位信息
	 * @param warehousePo
	 * @return
	 */
	public List<WarehousePo> getWarehouse(WarehousePo warehousePo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select B_WH_ID as bwhid , ");
		buffer.append("B_WH_warehouseName as bwhwarehouseName ");
		buffer.append("from B_Warehouse left join B_Departments on B_WH_deptID = B_DP_DepartmentID where B_WH_IsClosed=0 ");
		
		if (!"".equals(Utility.getName(warehousePo.getBwhcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(warehousePo.getBwhcompanyid()));	
		}
		
		return queryForObjectList(buffer.toString() , params.toArray() , WarehousePo.class);
	}

	/**
	 * 委外订单开窗查询，回带订单号及配镜单
	 * @param consignProcessOrderDetailsPo
	 * @return
	 */
	public int getSalesid(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("declare @InTransit varchar(10) ");
		buffer.append("set @InTransit = (SELECT DISTINCT inTransit FROM Ufn_currentintransittab('4')) ");
		buffer.append("select count(countnumber) from ( ");
		buffer.append("select count(C_ST_CPOD_OrderBillD) as countnumber ");
		buffer.append("from C_ST_ConsignProcessOrderDetails ");
		buffer.append("inner join C_ST_ConsignProcessOrder on C_ST_ConsignProcessOrder.C_ST_CPO_OrderBillId = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_OrderBillD ");
		buffer.append("inner join B_Supplier on B_Supplier.B_SP_ID = C_ST_ConsignProcessOrder.C_ST_CPO_SupplierId ");
		buffer.append("inner join B_Brand on B_BD_ID = substring(C_ST_CPOD_GoodsID,6,2) and substring(C_ST_CPOD_GoodsID,3,2) = B_BD_SupplierID ");
		buffer.append("left outer join uview_SalesBasic on S_SE_SB_SalesID = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_GlassesBillID ");
		buffer.append("left join B_Departments on S_SE_SB_ShopCode = B_DP_DepartmentID  ");
		buffer.append("where C_ST_CPOD_State = '0' and C_ST_CPO_AuditState = '1' and (S_SE_SB_InTransit = @InTransit or C_ST_CPOD_OrderType = 'W' ) ");
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpcompanyid()))){
			buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getCstcpcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpobrandid()))){
			buffer.append("and B_BD_ID = ? ");
			params.add(consignProcessOrderDetailsPo.getCstcpobrandid());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodballglass()))){
			buffer.append("and C_ST_CPOD_BallGlass = ? ");
			params.add(consignProcessOrderDetailsPo.getCstcpodballglass());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodpostglass()))){
			buffer.append("and C_ST_CPOD_PostGlass = ? ");
			params.add(consignProcessOrderDetailsPo.getCstcpodpostglass());
		}
		
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodglassesbillid()))){
			buffer.append("and C_ST_CPOD_GlassesBillID like '%' + ? +'%' ");//quyanping
			params.add(consignProcessOrderDetailsPo.getCstcpodglassesbillid());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodorderbilld()))){
			buffer.append("and C_ST_CPOD_OrderBillD like '%' + ? +'%' ");//quyanping
			params.add(consignProcessOrderDetailsPo.getCstcpodorderbilld());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcposupplierid()))){
			buffer.append("and C_ST_CPO_SupplierId = ? ");
			params.add(consignProcessOrderDetailsPo.getCstcposupplierid());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodordertype()))){
			buffer.append("and C_ST_CPOD_OrderType = ? ");
			params.add(consignProcessOrderDetailsPo.getCstcpodordertype());
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedstart()))	
				&& !"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedend()))) {
			buffer.append("and convert(varchar(10), C_ST_CPOD_ArrivedDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), C_ST_CPOD_ArrivedDate, 23) <= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodarrivedstart());
			params.add(consignProcessOrderDetailsPo.getCstcpodarrivedend());
		} else if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedstart())) 
				&& "".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedend()))) {
			buffer.append("and convert(varchar(10), C_ST_CPOD_ArrivedDate, 23) >= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodarrivedstart());
		} else if ("".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedstart())) 
				&& !"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedend()))) {
			buffer.append("and convert(varchar(10), C_ST_CPOD_ArrivedDate, 23) <= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodarrivedend());
		}

		
		buffer.append("group by C_ST_CPOD_OrderBillD , C_ST_CPOD_GlassesBillID , ");
		buffer.append("C_ST_CPOD_OrderType , C_ST_CPO_SupplierId , B_SP_SupplierName , ");
		buffer.append("C_ST_CPOD_customerID , C_ST_CPOD_customerName ) a ");
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	
	/**
	 * 委外订单开窗查询配镜单
	 * @param consignProcessOrderDetailsPo
	 * @return
	 */
	public int getSalesids(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("declare @InTransit varchar(10) ");
		buffer.append("set @InTransit = (SELECT DISTINCT inTransit FROM Ufn_currentintransittab('4')) ");
		
		buffer.append("select count(countnumber) from ( ");
		buffer.append("select count(C_ST_CPOD_OrderBillD) as countnumber ");
		buffer.append("from C_ST_ConsignProcessOrderDetails ");
		buffer.append("inner join C_ST_ConsignProcessOrder on C_ST_ConsignProcessOrder.C_ST_CPO_OrderBillId = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_OrderBillD left join B_GoodsInfo on C_ST_CPOD_GoodsID=B_GI_GoodsID ");
		buffer.append("left join B_Supplier on B_Supplier.B_SP_ID = C_ST_ConsignProcessOrder.C_ST_CPO_SupplierId ");
		buffer.append("left join B_Brand on B_BD_ID = substring(C_ST_CPOD_GoodsID,6,2) and substring(C_ST_CPOD_GoodsID,3,2) = B_BD_SupplierID ");
		buffer.append("left join S_SE_SalesBasic on S_SE_SalesBasic.S_SE_SB_SalesID = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_GlassesBillID ");
		buffer.append(" inner join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("where C_ST_CPOD_State = '0' and C_ST_CPO_AuditState = '1' and (S_SE_SB_InTransit = @InTransit or C_ST_CPOD_OrderType = 'W' ) ");
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getCstcpcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpoddepartmentid()))){
			buffer.append("and S_SE_SalesBasic.S_SE_SB_ShopCode = ? ");
			params.add(consignProcessOrderDetailsPo.getCstcpoddepartmentid());
		}	
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getSalesdjsbm()))){
			buffer.append("and S_SE_SB_Djsbm like '%' + ? +'%'");
			params.add(consignProcessOrderDetailsPo.getSalesdjsbm());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getSalesdjsbm()))){
			buffer.append("and S_SE_SB_Djsbm like '%' + ? +'%'");
			params.add(consignProcessOrderDetailsPo.getSalesdjsbm());
		}	
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodglassesbillid()))){
			buffer.append("and C_ST_CPOD_GlassesBillID like '%' + ? +'%' ");//quyanping
			params.add(consignProcessOrderDetailsPo.getCstcpodglassesbillid());
		}
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcposupplierid()))){
			buffer.append("and C_ST_CPO_SupplierId = ? ");
			params.add(consignProcessOrderDetailsPo.getCstcposupplierid());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodbilltype()))){
			buffer.append("and C_ST_CPO_OrderGoodsCategory = ? ");
			params.add(consignProcessOrderDetailsPo.getCstcpodbilltype());
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdatetime()))	
				&& !"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_PosDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodsalesdatetime());
			params.add(consignProcessOrderDetailsPo.getCstcpodsalesdateendtime());
		} else if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdatetime())) 
				&& "".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_PosDatetime, 23) >= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodsalesdatetime());
		} else if ("".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdatetime())) 
				&& !"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodsalesdateendtime());
		}
		
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedstart()))	
				&& !"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedend()))) {
			buffer.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodarrivedstart());
			params.add(consignProcessOrderDetailsPo.getCstcpodarrivedend());
		} else if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedstart())) 
				&& "".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedend()))) {
			buffer.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) >= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodarrivedstart());
		} else if ("".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedstart())) 
				&& !"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedend()))) {
			buffer.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodarrivedend());
		}
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodgoodsname()))){
			buffer.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getCstcpodgoodsname()));
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodballglass()))){
			buffer.append("and C_ST_CPOD_BallGlass = ? ");//quyanping
			params.add(consignProcessOrderDetailsPo.getCstcpodballglass());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodpostglass()))){
			buffer.append("and C_ST_CPOD_PostGlass = ? ");//quyanping
			params.add(consignProcessOrderDetailsPo.getCstcpodpostglass());
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getMaxSph()))) {
			buffer.append(" and ((replace(isnull(S_SE_SB_BallGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOD,',','') as float) <= cast( ? as float)) or (replace(isnull(S_SE_SB_BallGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOS,',','') as float) <= cast( ? as float))) ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMaxSph()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMaxSph()));
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getMinSph())) && "".equals(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()))) {
			buffer.append(" and ((replace(isnull(S_SE_SB_BallGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOD,',','') as float) = cast( ? as float)) or (replace(isnull(S_SE_SB_BallGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOS,',','') as float) = cast( ? as float))) ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinSph()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinSph()));
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getMaxCyl()))) {
			buffer.append(" and ((replace(isnull(S_SE_SB_PostGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOD,',','') as float) <= cast( ? as float)) or (replace(isnull(S_SE_SB_PostGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOS,',','') as float) <= cast( ? as float))) ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMaxCyl()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMaxCyl()));
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getMinCyl())) && "".equals(Utility.getName(consignProcessOrderDetailsPo.getMinSph()))) {
			buffer.append(" and ((replace(isnull(S_SE_SB_PostGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOD,',','') as float) = cast( ? as float)) or (replace(isnull(S_SE_SB_PostGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOS,',','') as float) = cast( ? as float))) ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()));
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getMinSph())) && !"".equals(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()))) {
			buffer.append(" and (((replace(isnull(S_SE_SB_BallGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOD,',','') as float) = cast( ? as float))and (replace(isnull(S_SE_SB_PostGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOD,',','') as float) = cast( ? as float))) or (replace(isnull(S_SE_SB_BallGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOS,',','') as float) = cast( ? as float))and(replace(isnull(S_SE_SB_PostGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOS,',','') as float) = cast( ? as float))) ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinSph()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinSph()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()));
		}
		
		buffer.append("group by C_ST_CPOD_OrderBillD , C_ST_CPOD_GlassesBillID , ");
		buffer.append("C_ST_CPOD_OrderType , C_ST_CPO_SupplierId , B_SP_SupplierName , ");
		buffer.append("C_ST_CPOD_customerID , C_ST_CPOD_customerName,B_Departments.B_DP_DepartmentName,S_SE_SalesBasic.S_SE_SB_TakeGlassData,S_SE_SalesBasic.S_SE_SB_SalesDatetime,C_ST_CPO_OrderGoodsCategory  ) a ");
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	/**
	 * 委外订单开窗查询配镜单
	 * @param consignProcessOrderDetailsPo
	 * @return
	 */
	public int getSalesidsW(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("declare @b varchar(10) ");
		
		buffer.append("select count(countnumber) from ( ");
		buffer.append("select count(C_ST_CPOD_OrderBillD) as countnumber ");
		buffer.append("from C_ST_ConsignProcessOrderDetails ");
		buffer.append("left join C_ST_ConsignProcessOrder on C_ST_ConsignProcessOrder.C_ST_CPO_OrderBillId = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_OrderBillD inner join B_GoodsInfo on C_ST_CPOD_GoodsID=B_GI_GoodsID ");
		buffer.append("left join B_Supplier on B_Supplier.B_SP_ID = C_ST_ConsignProcessOrder.C_ST_CPO_SupplierId ");
		buffer.append("left join B_Brand on B_BD_ID = substring(C_ST_CPOD_GoodsID,6,2) and substring(C_ST_CPOD_GoodsID,3,2) = B_BD_SupplierID ");
		buffer.append("left outer join uview_SalesBasic S_SE_SalesBasic on S_SE_SalesBasic.S_SE_SB_SalesID = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_SalesBillID ");
		buffer.append("left join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("where C_ST_CPOD_State = '0' and C_ST_CPO_AuditState = '1' and C_ST_CPOD_OrderType = 'W' ");
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getCstcpcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpoddepartmentid()))){
			buffer.append("and S_SE_SalesBasic.S_SE_SB_ShopCode = ? ");
			params.add(consignProcessOrderDetailsPo.getCstcpoddepartmentid());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getSalesdjsbm()))){
			buffer.append("and S_SE_SB_Djsbm like '%' + ? +'%'");
			params.add(consignProcessOrderDetailsPo.getSalesdjsbm());
		}

		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcporemark()))){
			buffer.append("and C_ST_CPO_Remark like '%'+ ? +'%' ");
			params.add(consignProcessOrderDetailsPo.getCstcporemark());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodglassesbillid()))){
			buffer.append("and (C_ST_CPOD_GlassesBillID like '%' + ? +'%' or C_ST_CPOD_SalesBillID like '%' + ? +'%' )");
			params.add(consignProcessOrderDetailsPo.getCstcpodglassesbillid());
			params.add(consignProcessOrderDetailsPo.getCstcpodglassesbillid());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcposupplierid()))){
			buffer.append("and C_ST_CPO_SupplierId = ? ");
			params.add(consignProcessOrderDetailsPo.getCstcposupplierid());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodbilltype()))){
			buffer.append("and C_ST_CPO_OrderGoodsCategory = ? ");
			params.add(consignProcessOrderDetailsPo.getCstcpodbilltype());
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdatetime()))	
				&& !"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_PosDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodsalesdatetime());
			params.add(consignProcessOrderDetailsPo.getCstcpodsalesdateendtime());
		} else if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdatetime())) 
				&& "".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_PosDatetime, 23) >= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodsalesdatetime());
		} else if ("".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdatetime())) 
				&& !"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodsalesdateendtime());
		}
		
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedstart()))	
				&& !"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedend()))) {
			buffer.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodarrivedstart());
			params.add(consignProcessOrderDetailsPo.getCstcpodarrivedend());
		} else if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedstart())) 
				&& "".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedend()))) {
			buffer.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) >= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodarrivedstart());
		} else if ("".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedstart())) 
				&& !"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedend()))) {
			buffer.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodarrivedend());
		}
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodgoodsname()))){
			buffer.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getCstcpodgoodsname()));
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getMaxSph()))) {
			buffer.append(" and ((replace(isnull(S_SE_SB_BallGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOD,',','') as float) <= cast( ? as float)) or (replace(isnull(S_SE_SB_BallGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOS,',','') as float) <= cast( ? as float))) ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMaxSph()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMaxSph()));
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getMinSph())) && "".equals(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()))) {
			buffer.append(" and ((replace(isnull(S_SE_SB_BallGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOD,',','') as float) = cast( ? as float)) or (replace(isnull(S_SE_SB_BallGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOS,',','') as float) = cast( ? as float))) ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinSph()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinSph()));
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getMaxCyl()))) {
			buffer.append(" and ((replace(isnull(S_SE_SB_PostGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOD,',','') as float) <= cast( ? as float)) or (replace(isnull(S_SE_SB_PostGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOS,',','') as float) <= cast( ? as float))) ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMaxCyl()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMaxCyl()));
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getMinCyl())) && "".equals(Utility.getName(consignProcessOrderDetailsPo.getMinSph()))) {
			buffer.append(" and ((replace(isnull(S_SE_SB_PostGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOD,',','') as float) = cast( ? as float)) or (replace(isnull(S_SE_SB_PostGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOS,',','') as float) = cast( ? as float))) ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()));
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getMinSph())) && !"".equals(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()))) {
			buffer.append(" and (((replace(isnull(S_SE_SB_BallGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOD,',','') as float) = cast( ? as float))and (replace(isnull(S_SE_SB_PostGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOD,',','') as float) = cast( ? as float))) or (replace(isnull(S_SE_SB_BallGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOS,',','') as float) = cast( ? as float))and(replace(isnull(S_SE_SB_PostGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOS,',','') as float) = cast( ? as float))) ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinSph()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinSph()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()));
		}
				
		buffer.append("group by C_ST_CPOD_OrderBillD , C_ST_CPOD_GlassesBillID , ");
		buffer.append("C_ST_CPOD_OrderType , C_ST_CPO_SupplierId , B_SP_SupplierName , ");
		buffer.append("C_ST_CPOD_customerID , C_ST_CPOD_customerName,B_Departments.B_DP_DepartmentName,S_SE_SalesBasic.S_SE_SB_TakeGlassData,S_SE_SalesBasic.S_SE_SB_SalesDatetime,C_ST_CPO_OrderGoodsCategory  ) a ");
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	

	/**
	 * 委外订单开窗查询，回带订单号及配镜单
	 * @param consignProcessOrderDetailsPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ConsignProcessOrderDetailsPo> selectSalesid(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo,
			int start, int size) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		buffer.append("declare @InTransit varchar(10) ");
		buffer.append("set @InTransit = (SELECT DISTINCT inTransit FROM Ufn_currentintransittab('4')) ");
		
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by C_ST_CPOD_OrderBillD desc) as rowNum, ");
		
		buffer.append("C_ST_CPOD_OrderBillD as cstcpodorderbilld , ");
		buffer.append("C_ST_CPOD_GlassesBillID as cstcpodglassesbillid , ");
		buffer.append("C_ST_CPOD_OrderType as cstcpodordertype , ");
		buffer.append("C_ST_CPO_SupplierId as cstcposupplierid , ");
		buffer.append("B_SP_SupplierName as cstcposuppliername , ");
		buffer.append("C_ST_CPOD_customerID as cstcpodcustomerid , ");
		buffer.append("C_ST_CPOD_customerName as cstcpodcustomername ");
		buffer.append("from C_ST_ConsignProcessOrderDetails ");
		buffer.append("inner join C_ST_ConsignProcessOrder on C_ST_ConsignProcessOrder.C_ST_CPO_OrderBillId = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_OrderBillD ");
		buffer.append("inner join B_Supplier on B_Supplier.B_SP_ID = C_ST_ConsignProcessOrder.C_ST_CPO_SupplierId ");
		buffer.append("inner join B_Brand on B_BD_ID = substring(C_ST_CPOD_GoodsID,6,2) and substring(C_ST_CPOD_GoodsID,3,2) = B_BD_SupplierID ");
		
		buffer.append("left outer join uview_SalesBasic on S_SE_SB_SalesID = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_GlassesBillID ");
		buffer.append("left join B_Departments on S_SE_SB_ShopCode = B_DP_DepartmentID  ");
		buffer.append("where C_ST_CPOD_State = '0' and C_ST_CPO_AuditState = '1' and (S_SE_SB_InTransit = @InTransit or C_ST_CPOD_OrderType = 'W' ) ");
	
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpcompanyid()))){
			buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getCstcpcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpobrandid()))){
			buffer.append("and B_BD_ID = ? ");
			params.add(consignProcessOrderDetailsPo.getCstcpobrandid());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodballglass()))){
			buffer.append("and C_ST_CPOD_BallGlass = ? ");//quyanping
			params.add(consignProcessOrderDetailsPo.getCstcpodballglass());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodpostglass()))){
			buffer.append("and C_ST_CPOD_PostGlass = ? ");//quyanping
			params.add(consignProcessOrderDetailsPo.getCstcpodpostglass());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodglassesbillid()))){
			buffer.append("and C_ST_CPOD_GlassesBillID like '%' + ? +'%' ");//quyanping
			params.add(consignProcessOrderDetailsPo.getCstcpodglassesbillid());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodorderbilld()))){
			buffer.append("and C_ST_CPOD_OrderBillD like '%' + ? +'%' ");//quyanping
			params.add(consignProcessOrderDetailsPo.getCstcpodorderbilld());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcposupplierid()))){
			buffer.append("and C_ST_CPO_SupplierId = ? ");
			params.add(consignProcessOrderDetailsPo.getCstcposupplierid());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodordertype()))){
			buffer.append("and C_ST_CPOD_OrderType = ? ");
			params.add(consignProcessOrderDetailsPo.getCstcpodordertype());
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedstart()))	
				&& !"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedend()))) {
			buffer.append("and convert(varchar(10), C_ST_CPOD_ArrivedDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), C_ST_CPOD_ArrivedDate, 23) <= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodarrivedstart());
			params.add(consignProcessOrderDetailsPo.getCstcpodarrivedend());
		} else if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedstart())) 
				&& "".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedend()))) {
			buffer.append("and convert(varchar(10), C_ST_CPOD_ArrivedDate, 23) >= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodarrivedstart());
		} else if ("".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedstart())) 
				&& !"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodarrivedend()))) {
			buffer.append("and convert(varchar(10), C_ST_CPOD_ArrivedDate, 23) <= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodarrivedend());
		}
		
		buffer.append("group by C_ST_CPOD_OrderBillD , C_ST_CPOD_GlassesBillID , ");
		buffer.append("C_ST_CPOD_OrderType , C_ST_CPO_SupplierId , B_SP_SupplierName , ");
		buffer.append("C_ST_CPOD_customerID , C_ST_CPOD_customerName ");
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , ConsignProcessOrderDetailsPo.class);
	}
	
	
	/**
	 * 委外订单开窗查询配镜单
	 * @param consignProcessOrderDetailsPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ConsignProcessOrderDetailsPo> selectSalesids(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo,
			int start, int size) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("declare @InTransit varchar(10) ");
		buffer.append("set @InTransit = (SELECT DISTINCT inTransit FROM Ufn_currentintransittab('4')) ");
		
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by C_ST_CPOD_OrderBillD desc) as rowNum, ");
		
		buffer.append("C_ST_CPOD_OrderBillD as cstcpodorderbilld , ");
		buffer.append("C_ST_CPOD_GlassesBillID as cstcpodglassesbillid , ");
		buffer.append("C_ST_CPOD_OrderType as cstcpodordertype , ");
		buffer.append("C_ST_CPO_SupplierId as cstcposupplierid , ");
		buffer.append("B_SP_SupplierName as cstcposuppliername , ");
		buffer.append("C_ST_CPOD_customerID as cstcpodcustomerid , ");
		buffer.append("C_ST_CPOD_customerName as cstcpodcustomername, ");
		buffer.append(" B_Departments.B_DP_DepartmentName                      as cstcpoddepartmentname,");
		buffer.append(" S_SE_SalesBasic.S_SE_SB_TakeGlassData                  as cstcpodarriveddate,");
		buffer.append(" S_SE_SalesBasic.S_SE_SB_PosDatetime                  as cstcpodsalesdatetime,");
		buffer.append(" C_ST_CPO_OrderGoodsCategory                            as cstcpogoodscategory, ");
		buffer.append(" S_ME_CI_Name                            as cstcpodmembername ");
		buffer.append("from C_ST_ConsignProcessOrderDetails ");
		buffer.append("inner join C_ST_ConsignProcessOrder on C_ST_ConsignProcessOrder.C_ST_CPO_OrderBillId = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_OrderBillD left join B_GoodsInfo on C_ST_CPOD_GoodsID=B_GI_GoodsID ");
		buffer.append("left join B_Supplier on B_Supplier.B_SP_ID = C_ST_ConsignProcessOrder.C_ST_CPO_SupplierId ");
		buffer.append("left join B_Brand on B_BD_ID = substring(C_ST_CPOD_GoodsID,6,2) and substring(C_ST_CPOD_GoodsID,3,2) = B_BD_SupplierID ");
		
		buffer.append("left outer join S_SE_SalesBasic on S_SE_SalesBasic.S_SE_SB_SalesID = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_GlassesBillID ");
		buffer.append("left outer join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		buffer.append(" inner join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("where C_ST_CPOD_State = '0' and C_ST_CPO_AuditState = '1' and (S_SE_SB_InTransit = @InTransit or C_ST_CPOD_OrderType = 'W' ) ");
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getCstcpcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpoddepartmentid()))){
			buffer.append("and S_SE_SalesBasic.S_SE_SB_ShopCode = ? ");
			params.add(consignProcessOrderDetailsPo.getCstcpoddepartmentid());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getSalesdjsbm()))){
			buffer.append("and S_SE_SB_Djsbm like '%' + ? +'%'");
			params.add(consignProcessOrderDetailsPo.getSalesdjsbm());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodglassesbillid()))){
			buffer.append("and C_ST_CPOD_GlassesBillID like '%' + ? +'%' ");//quyanping
			params.add(consignProcessOrderDetailsPo.getCstcpodglassesbillid());
		}
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcposupplierid()))){
			buffer.append("and C_ST_CPO_SupplierId = ? ");
			params.add(consignProcessOrderDetailsPo.getCstcposupplierid());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodbilltype()))){
			buffer.append("and C_ST_CPO_OrderGoodsCategory = ? ");
			params.add(consignProcessOrderDetailsPo.getCstcpodbilltype());
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdatetime()))	
				&& !"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_PosDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodsalesdatetime());
			params.add(consignProcessOrderDetailsPo.getCstcpodsalesdateendtime());
		} else if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdatetime())) 
				&& "".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_PosDatetime, 23) >= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodsalesdatetime());
		} else if ("".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdatetime())) 
				&& !"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodsalesdateendtime());
		}
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodgoodsname()))){
			buffer.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getCstcpodgoodsname()));
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodballglass()))){
			buffer.append("and C_ST_CPOD_BallGlass = ? ");//quyanping
			params.add(consignProcessOrderDetailsPo.getCstcpodballglass());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodpostglass()))){
			buffer.append("and C_ST_CPOD_PostGlass = ? ");//quyanping
			params.add(consignProcessOrderDetailsPo.getCstcpodpostglass());
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getMaxSph()))) {
			buffer.append(" and ((replace(isnull(S_SE_SB_BallGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOD,',','') as float) <= cast( ? as float)) or (replace(isnull(S_SE_SB_BallGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOS,',','') as float) <= cast( ? as float))) ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMaxSph()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMaxSph()));
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getMinSph())) && "".equals(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()))) {
			buffer.append(" and ((replace(isnull(S_SE_SB_BallGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOD,',','') as float) = cast( ? as float)) or (replace(isnull(S_SE_SB_BallGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOS,',','') as float) = cast( ? as float))) ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinSph()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinSph()));
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getMaxCyl()))) {
			buffer.append(" and ((replace(isnull(S_SE_SB_PostGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOD,',','') as float) <= cast( ? as float)) or (replace(isnull(S_SE_SB_PostGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOS,',','') as float) <= cast( ? as float))) ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMaxCyl()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMaxCyl()));
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getMinCyl())) && "".equals(Utility.getName(consignProcessOrderDetailsPo.getMinSph()))) {
			buffer.append(" and ((replace(isnull(S_SE_SB_PostGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOD,',','') as float) = cast( ? as float)) or (replace(isnull(S_SE_SB_PostGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOS,',','') as float) = cast( ? as float))) ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()));
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getMinSph())) && !"".equals(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()))) {
			buffer.append(" and (((replace(isnull(S_SE_SB_BallGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOD,',','') as float) = cast( ? as float))and (replace(isnull(S_SE_SB_PostGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOD,',','') as float) = cast( ? as float))) or (replace(isnull(S_SE_SB_BallGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOS,',','') as float) = cast( ? as float))and(replace(isnull(S_SE_SB_PostGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOS,',','') as float) = cast( ? as float))) ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinSph()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinSph()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()));
		}
		
		buffer.append("group by C_ST_CPOD_OrderBillD , C_ST_CPOD_GlassesBillID , ");
		buffer.append("C_ST_CPOD_OrderType , C_ST_CPO_SupplierId , B_SP_SupplierName , ");
		buffer.append("C_ST_CPOD_customerID , C_ST_CPOD_customerName,B_Departments.B_DP_DepartmentName,S_SE_SalesBasic.S_SE_SB_TakeGlassData,S_SE_SalesBasic.S_SE_SB_PosDatetime,C_ST_CPO_OrderGoodsCategory,S_ME_CI_Name ");
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , ConsignProcessOrderDetailsPo.class);
	}
	
	/**
	 * 委外订单开窗查询配镜单
	 * @param consignProcessOrderDetailsPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ConsignProcessOrderDetailsPo> selectSalesidsW(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo,
			int start, int size) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("declare @b varchar(10) ");
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by C_ST_CPOD_OrderBillD desc) as rowNum, ");
		
		buffer.append("C_ST_CPOD_OrderBillD as cstcpodorderbilld , ");
		buffer.append("C_ST_CPOD_GlassesBillID as cstcpodglassesbillid , ");
		buffer.append("C_ST_CPOD_OrderType as cstcpodordertype , ");
		buffer.append("C_ST_CPO_SupplierId as cstcposupplierid , ");
		buffer.append("B_SP_SupplierName as cstcposuppliername , ");
		buffer.append("C_ST_CPOD_customerID as cstcpodcustomerid , ");
		buffer.append("C_ST_CPOD_customerName as cstcpodcustomername, ");
		buffer.append(" B_Departments.B_DP_DepartmentName     as cstcpoddepartmentname,");
		buffer.append(" S_SE_SalesBasic.S_SE_SB_TakeGlassData as cstcpodarriveddate,");
		buffer.append(" S_SE_SalesBasic.S_SE_SB_PosDatetime as cstcpodsalesdatetime,");
		buffer.append(" C_ST_CPO_OrderGoodsCategory           as cstcpogoodscategory, ");
		buffer.append(" C_ST_CPO_Remark                       as cstcporemark,S_ME_CI_Name as cstcpodmembername ");
		buffer.append("from C_ST_ConsignProcessOrderDetails ");
		buffer.append("left join C_ST_ConsignProcessOrder on C_ST_ConsignProcessOrder.C_ST_CPO_OrderBillId = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_OrderBillD inner join B_GoodsInfo on C_ST_CPOD_GoodsID=B_GI_GoodsID ");
		buffer.append("left join B_Supplier on B_Supplier.B_SP_ID = C_ST_ConsignProcessOrder.C_ST_CPO_SupplierId ");
		buffer.append("left join B_Brand on B_BD_ID = substring(C_ST_CPOD_GoodsID,6,2) and substring(C_ST_CPOD_GoodsID,3,2) = B_BD_SupplierID ");
		
		buffer.append("left outer join uview_SalesBasic S_SE_SalesBasic on S_SE_SalesBasic.S_SE_SB_SalesID = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_SalesBillID ");
		buffer.append("left outer join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CI_CustomerID ");
		buffer.append(" left join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("where C_ST_CPOD_State = '0' and C_ST_CPO_AuditState = '1' and C_ST_CPOD_OrderType = 'W' ");
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getCstcpcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpoddepartmentid()))){
			buffer.append("and S_SE_SalesBasic.S_SE_SB_ShopCode = ? ");
			params.add(consignProcessOrderDetailsPo.getCstcpoddepartmentid());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getSalesdjsbm()))){
			buffer.append("and S_SE_SB_Djsbm like '%' + ? +'%'");
			params.add(consignProcessOrderDetailsPo.getSalesdjsbm());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcporemark()))){
			buffer.append("and C_ST_CPO_Remark like '%'+ ? +'%' ");
			params.add(consignProcessOrderDetailsPo.getCstcporemark());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodglassesbillid()))){
			buffer.append("and (C_ST_CPOD_GlassesBillID like '%' + ? +'%' or C_ST_CPOD_SalesBillID like '%' + ? +'%' )");
			params.add(consignProcessOrderDetailsPo.getCstcpodglassesbillid());
			params.add(consignProcessOrderDetailsPo.getCstcpodglassesbillid());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcposupplierid()))){
			buffer.append("and C_ST_CPO_SupplierId = ? ");
			params.add(consignProcessOrderDetailsPo.getCstcposupplierid());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodbilltype()))){
			buffer.append("and C_ST_CPO_OrderGoodsCategory = ? ");
			params.add(consignProcessOrderDetailsPo.getCstcpodbilltype());
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdatetime()))	
				&& !"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodsalesdatetime());
			params.add(consignProcessOrderDetailsPo.getCstcpodsalesdateendtime());
		} else if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdatetime())) 
				&& "".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodsalesdatetime());
		} else if ("".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdatetime())) 
				&& !"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(consignProcessOrderDetailsPo.getCstcpodsalesdateendtime());
		}
		if(!"".equals(Utility.getName(consignProcessOrderDetailsPo.getCstcpodgoodsname()))){
			buffer.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getCstcpodgoodsname()));
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getMaxSph()))) {
			buffer.append(" and ((replace(isnull(S_SE_SB_BallGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOD,',','') as float) <= cast( ? as float)) or (replace(isnull(S_SE_SB_BallGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOS,',','') as float) <= cast( ? as float))) ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMaxSph()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMaxSph()));
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getMinSph())) && "".equals(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()))) {
			buffer.append(" and ((replace(isnull(S_SE_SB_BallGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOD,',','') as float) = cast( ? as float)) or (replace(isnull(S_SE_SB_BallGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOS,',','') as float) = cast( ? as float))) ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinSph()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinSph()));
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getMaxCyl()))) {
			buffer.append(" and ((replace(isnull(S_SE_SB_PostGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOD,',','') as float) <= cast( ? as float)) or (replace(isnull(S_SE_SB_PostGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOS,',','') as float) <= cast( ? as float))) ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMaxCyl()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMaxCyl()));
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getMinCyl())) && "".equals(Utility.getName(consignProcessOrderDetailsPo.getMinSph()))) {
			buffer.append(" and ((replace(isnull(S_SE_SB_PostGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOD,',','') as float) = cast( ? as float)) or (replace(isnull(S_SE_SB_PostGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOS,',','') as float) = cast( ? as float))) ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()));
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderDetailsPo.getMinSph())) && !"".equals(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()))) {
			buffer.append(" and (((replace(isnull(S_SE_SB_BallGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOD,',','') as float) = cast( ? as float))and (replace(isnull(S_SE_SB_PostGlassOD,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOD,',','') as float) = cast( ? as float))) or (replace(isnull(S_SE_SB_BallGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_BallGlassOS,',','') as float) = cast( ? as float))and(replace(isnull(S_SE_SB_PostGlassOS,''),',','')<>'' and cast(replace(S_SE_SB_PostGlassOS,',','') as float) = cast( ? as float))) ");
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinSph()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinSph()));
			params.add(Utility.getName(consignProcessOrderDetailsPo.getMinCyl()));
		}
		
		
		buffer.append("group by C_ST_CPOD_OrderBillD , C_ST_CPOD_GlassesBillID , ");
		buffer.append("C_ST_CPOD_OrderType , C_ST_CPO_SupplierId , B_SP_SupplierName , ");
		buffer.append("C_ST_CPOD_customerID ,C_ST_CPO_Remark, C_ST_CPOD_customerName,B_Departments.B_DP_DepartmentName,S_SE_SB_TakeGlassData,S_SE_SB_PosDatetime,C_ST_CPO_OrderGoodsCategory,S_ME_CI_Name ");
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , ConsignProcessOrderDetailsPo.class);
	}

	/**
	 * 更新销售单主表在途
	 * @param salesid
	 */
	public void updateSalesBasic(String salesid,String intransit) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("update S_SE_SalesBasic ");
		buffer.append("set S_SE_SB_InTransit= ? ");
		buffer.append("where S_SE_SB_SalesID= ? ");
		
		params.add(intransit);
		params.add(salesid);
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
		
		
	}
	
	/**
	 * 更新委外订单表收货状态
	 * @param salesid
	 */
	public void updateSalesStatus(String salesid) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("update C_ST_ConsignProcessOrderDetails ");
		buffer.append("set C_ST_CPOD_State='1' ");
		buffer.append("where C_ST_CPOD_GlassesBillID= ? ");
		
		params.add(salesid);
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
		
		
	}

	/**
	 * 新增收货主表
	 * @param consignProcessReceiptPo
	 */
	public void insertReceipt(ConsignProcessReceiptPo consignProcessReceiptPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into C_ST_ConsignProcessReceipt( ");
		buffer.append("C_ST_CPR_ReceiptBillId , C_ST_CPR_SourceBillId , C_ST_CPR_Salesid,");
		buffer.append("C_ST_CPR_BillDate , C_ST_CPR_GoodsCategory , ");
		buffer.append("C_ST_CPR_SupplierId , C_ST_CPR_InStockId , ");
		buffer.append("C_ST_CPR_DepartmentId , C_ST_CPR_CreatePerson , ");
		buffer.append("C_ST_CPR_AuditPerson , C_ST_CPR_AuditDate , ");
		buffer.append("C_ST_CPR_AuditState , C_ST_CPR_State , ");
		buffer.append("C_ST_CPR_Remark,C_ST_CPR_WaybillID,C_ST_CPR_SubSupplierId ) values ( ");
		buffer.append("? , ? , ? , getdate() , ? , ? , ? , ? , ? , ? , getdate() , '1' , '0' , ? , ? , ? ) ");
		
		params.add(consignProcessReceiptPo.getCstcprreceiptbillid());
		params.add(consignProcessReceiptPo.getCstcprsourcebillid());
		params.add(consignProcessReceiptPo.getCstcprsalesid());
		params.add(consignProcessReceiptPo.getCstcprgoodscategory());
		params.add(consignProcessReceiptPo.getCstcprsupplierid());
		params.add(consignProcessReceiptPo.getCstcprinstockid());
		params.add(consignProcessReceiptPo.getCstcprdepartmentid());
		params.add(consignProcessReceiptPo.getCstcprcreateperson());
		params.add(consignProcessReceiptPo.getCstcprauditperson());
		params.add(Utility.getName(consignProcessReceiptPo.getCstcprremark()));
		params.add(Utility.getName(consignProcessReceiptPo.getCstcprwaybillid()));
		params.add(Utility.getName(consignProcessReceiptPo.getCstcprsubsupplierid()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
		
	}

	/**
	 * 新增收货明细表
	 * @param consignProcessReceiptDetailsPo
	 */
	public void insertReceiptDetails(
			ConsignProcessReceiptDetailsPo consignProcessReceiptDetailsPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into C_ST_ConsignProcessReceiptDetails( ");
		buffer.append("C_ST_CPRD_Id , ");
		buffer.append("C_ST_CPRD_ReceiptBillD , ");
		buffer.append("C_ST_CPRD_OrderDetailsID , ");
		buffer.append("C_ST_CPRD_GoodsID , ");
		buffer.append("C_ST_CPRD_BarCode , ");
		buffer.append("C_ST_CPRD_Num , ");
		buffer.append("C_ST_CPRD_InStockId , ");
		buffer.append("C_ST_CPRD_NotTaxRate , ");
		buffer.append("C_ST_CPRD_TaxRate , ");
		buffer.append("C_ST_CPRD_CostPrice,  ");		
		buffer.append("C_ST_CPRD_Guaranteeperiod,  ");
		buffer.append("C_ST_CPRD_Batch,  ");
		buffer.append("C_ST_CPRD_RegistrationNum  ");
		
		buffer.append(" ) values(? , ? , ? , ? , ? , ? , ? , ? , ? , ?, ? , ? , ? ) ");
		
		params.add(this.uuid.generate());
		params.add(consignProcessReceiptDetailsPo.getCstcprdreceiptbilld());
		params.add(consignProcessReceiptDetailsPo.getCstcprdorderdetailsid());
		params.add(consignProcessReceiptDetailsPo.getCstcprdgoodsid());
		params.add(consignProcessReceiptDetailsPo.getCstcprdbarcode());
		params.add(consignProcessReceiptDetailsPo.getCstcprdnum());
		params.add(consignProcessReceiptDetailsPo.getCstcprdinstockid());
		params.add(consignProcessReceiptDetailsPo.getCstcprdnottaxrate());
		params.add(consignProcessReceiptDetailsPo.getCstcprdtaxrate());
		params.add(consignProcessReceiptDetailsPo.getCstcprdcostprice());		
		params.add(Utility.getName(consignProcessReceiptDetailsPo.getCstcpguaranteeperiod()));
		params.add(Utility.getName(consignProcessReceiptDetailsPo.getCstcpbatch()));
		params.add(Utility.getName(consignProcessReceiptDetailsPo.getCstcpregistrationnum()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
		
	}

	/**
	 * 新增在途明细表
	 * @param inTransitPo
	 */
	public void insertIntransit(InTransitPo inTransitPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
			
		buffer.append("insert into S_SE_InTransit( ");
		buffer.append("S_SE_IT_ID , S_SE_IT_SalesID , S_SE_IT_State , ");
		buffer.append("S_SE_IT_Date , S_SE_IT_CreatePerson , S_SE_IT_Department,S_SE_IT_YsalesID ) ");
		buffer.append("values (? , ? , ? , getdate() , ? , ? , ?) ");
		
		params.add(this.uuid.generate());
		params.add(inTransitPo.getSseitsalesid());
		params.add(inTransitPo.getSseitstate());
		params.add(inTransitPo.getSseitcreateperson());
		params.add(inTransitPo.getSseitdepartment());
		params.add(Utility.getName(inTransitPo.getSseitysalesid()));		
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
		
	}

	/**
	 * 新增当月库存变更表
	 * @param strogeChangePo
	 */
	public void insertStrogeChange(StrogeChangePo strogeChangePo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into C_SH_StorageChange (C_SH_SC_GoodsBarCode , C_SH_SC_GoodsId , C_SH_SC_StockId , ");
		buffer.append("C_SH_SC_GoodsQuantity , C_SH_SC_CostPrice , C_SH_SC_NotTaxRate , ");
		buffer.append("C_SH_SC_WarehousingDate , C_SH_SC_ChangeID, C_SH_SC_UUID) ");
		buffer.append("values(? , ? , ? , ? , ? , ? , getdate() , ?, ?) ");
		
		params.add(strogeChangePo.getCshscgoodsbarcode());
		params.add(strogeChangePo.getCshscgoodsid());
		params.add(strogeChangePo.getCshscstockid());
		params.add(strogeChangePo.getCshscgoodsquantity());
		params.add(strogeChangePo.getCshsccostprice());
		params.add(strogeChangePo.getCshscnottaxrate());
		params.add(strogeChangePo.getCshscchangeid());
		params.add(this.uuid.generate());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 新增当月库存日志表
	 * @param strogeLogPo
	 */
	public void insertStrogeLog(StrogeLogPo strogeLogPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into C_SH_StorageLog( ");
		buffer.append("C_SH_SL_GoodsBarCode , ");
		buffer.append("C_SH_SL_GoodsId , ");
		buffer.append("C_SH_SL_StockId , ");
		buffer.append("C_SH_SL_GoodsQuantity , ");
		buffer.append("C_SH_SL_CostPrice , ");
		buffer.append("C_SH_SL_NotTaxRate , ");
		buffer.append("C_SH_SL_WarehousingDate , ");
		buffer.append("C_SH_SL_Month , ");
		buffer.append("C_SH_SL_ChangeID,C_SH_SL_UUID ) ");
		buffer.append("values(? , ? , ? , ? , ? , ? , getdate() , month(getdate()) , ?, ?) ");
		
		params.add(strogeLogPo.getCshslgoodsbarcode());
		params.add(strogeLogPo.getCshslgoodsid());
		params.add(strogeLogPo.getCshslstockid());
		params.add(strogeLogPo.getCshslgoodsquantity());
		params.add(strogeLogPo.getCshslcostprice());
		params.add(strogeLogPo.getCshslnottaxrate());
		params.add(strogeLogPo.getCshslchangeid());
		params.add(this.uuid.generate());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 业务临时表
	 * @param inventoryTempPo
	 */
	public void insertInventoryTemp(InventoryTempPo inventoryTempPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into C_ST_InventoryTemp( ");
		buffer.append("C_ST_IT_BillID , ");
		buffer.append("C_ST_IT_BillTypeId , ");
		buffer.append("C_ST_IT_SourceBillId , ");
		buffer.append("C_ST_IT_DeliveryID , ");
		buffer.append("C_ST_IT_billDate , ");
		buffer.append("C_ST_IT_SupplierId , ");
		buffer.append("C_ST_IT_InStockId , ");
		buffer.append("C_ST_IT_DepartmentId , ");
		buffer.append("C_ST_IT_createPerson , ");
		buffer.append("C_ST_IT_AuditPerson , ");
		buffer.append("C_ST_IT_AuditState , ");
		buffer.append("C_ST_IT_AuditDate , ");
		buffer.append("C_ST_IT_flag,C_ST_IT_SubSupplierId ) ");
		buffer.append("values(? , ? , ? , ? , getdate() , ? , ? , ? , ? , ? , '1' , getdate() , ?, ? ) ");
		
		params.add(inventoryTempPo.getCstitbillid());
		params.add(inventoryTempPo.getCstitbilltypeid());
		params.add(inventoryTempPo.getCstitsourcebillid());
		params.add(Utility.getName(inventoryTempPo.getCstitdeliveryid()));
		params.add(inventoryTempPo.getCstitsupplierid());
		params.add(inventoryTempPo.getCstitinstockid());
		params.add(inventoryTempPo.getCstitdepartmentid());
		params.add(inventoryTempPo.getCstitcreateperson());
		params.add(inventoryTempPo.getCstitauditperson());
		params.add(Utility.getName(inventoryTempPo.getCstitflag()).equals("") ? "0" : Utility.getName(inventoryTempPo.getCstitflag()));
		params.add(Utility.getName(inventoryTempPo.getCstitsubsupplierid()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 业务明细临时表
	 * @param inventoryTempEntryPo
	 */
	public void insertInventoryTempEntry(
			InventoryTempEntryPo inventoryTempEntryPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into C_ST_InventoryTempEntry( ");
		buffer.append("C_ST_IET_ID , ");
		buffer.append("C_ST_IET_BillID , ");
		buffer.append("C_ST_IET_GoodsId , ");
		buffer.append("C_ST_IET_GoodsQuantity , ");
		buffer.append("C_ST_IET_NotTaxRate , ");
		buffer.append("C_ST_IET_TaxRate , ");
		buffer.append("C_ST_IET_CostPrice , ");
		buffer.append("C_ST_IET_InStockId , ");
		buffer.append("C_ST_IET_BarCode , ");
		buffer.append("C_ST_IET_WarehousingDate )");
		buffer.append("values(? , ? , ? , ? , ? , ? , ? , ? , ? , getdate() ) ");
		
		params.add(this.uuid.generate());
		params.add(inventoryTempEntryPo.getCstietbillid());
		params.add(inventoryTempEntryPo.getCstietgoodsid());
		params.add(inventoryTempEntryPo.getCstietgoodsquantity());
		params.add(inventoryTempEntryPo.getCstietnottaxrate());
		params.add(inventoryTempEntryPo.getCstiettaxrate());
		params.add(inventoryTempEntryPo.getCstietcostprice());
		params.add(inventoryTempEntryPo.getCstietinstockid());
		params.add(inventoryTempEntryPo.getCstietbarcode());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 向订单系统回写信息
	 * @param consignProcessReceiptPo
	 */
	public void insertOrdersInfo(String deliveryid , String ordersid , String personid) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("exec SP_ConsignimportReceiptUpdate ? , ? , ? ");
		
		params.add(ordersid);
		params.add(deliveryid);
		params.add(personid);
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 得到订单系统发货信息数量
	 * @param consignProcessReceiptPo
	 * @return
	 */
	public int getdeliveryCount(ConsignProcessReceiptPo consignProcessReceiptPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select count(C_ST_D_ID) ");
		buffer.append("from Orders.orders.dbo.C_ST_Delivery ");
		buffer.append("inner join Orders.orders.dbo.B_Departments on B_DP_DepartmentID = C_ST_D_SupplierID ");
		buffer.append("inner join Orders.orders.dbo.C_ST_Po on C_ST_P_ID = C_ST_D_PoID ");
		buffer.append("where C_ST_P_BillTypeId = '2' and C_ST_P_AuditState = '7' ");
		
		if(!"".equals(Utility.getName(consignProcessReceiptPo.getCstcprsalesid()))){
			buffer.append("and C_ST_P_SalseID like '%' + ? +'%' ");//quyanping
			params.add(consignProcessReceiptPo.getCstcprsalesid());
		}
		
		if(!"".equals(Utility.getName(consignProcessReceiptPo.getCstcprordersdeliveryid()))){
			buffer.append("and C_ST_D_ID like '%' + ? +'%' ");//quyanping
			params.add(consignProcessReceiptPo.getCstcprordersdeliveryid());
		}
		
		if (!"".equals(Utility.getName(consignProcessReceiptPo.getCstcprdeliverystart()))
				&& !"".equals(Utility.getName(consignProcessReceiptPo.getCstcprdeliveryend()))) {
			buffer.append("and convert(varchar(10), C_ST_D_BillDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), C_ST_D_BillDate, 23) <= ? ");

			params.add(consignProcessReceiptPo.getCstcprdeliverystart());
			params.add(consignProcessReceiptPo.getCstcprdeliveryend());
		} else if (!"".equals(Utility.getName(consignProcessReceiptPo.getCstcprdeliverystart())) 
				&& "".equals(Utility.getName(consignProcessReceiptPo.getCstcprdeliveryend()))) {
			buffer.append("and convert(varchar(10), C_ST_D_BillDate, 23) >= ? ");

			params.add(consignProcessReceiptPo.getCstcprdeliverystart());
		} else if ("".equals(Utility.getName(consignProcessReceiptPo.getCstcprdeliverystart())) 
				&& !"".equals(Utility.getName(consignProcessReceiptPo.getCstcprdeliveryend()))) {
			buffer.append("and convert(varchar(10), C_ST_D_BillDate, 23) <= ? ");

			params.add(consignProcessReceiptPo.getCstcprdeliveryend());
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 得到订单系统发货信息
	 * @param consignProcessReceiptPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ConsignProcessReceiptPo> selectdeliveryList(
			ConsignProcessReceiptPo consignProcessReceiptPo, int start, int size) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by C_ST_D_BillDate desc) as rowNum, ");
		
		buffer.append("C_ST_D_ID as cstcprordersdeliveryid , ");
		buffer.append("C_ST_D_PoID as cstcprsourcebillid ,  ");
		buffer.append("C_ST_P_SalseID as cstcprsalesid , ");
		buffer.append("C_ST_D_BillDate as cstcprbilldate , ");
		buffer.append("C_ST_D_SupplierID as cstcprsupplierid , ");
		buffer.append("B_DP_DepartmentName as cstcprsuppliername ");
		buffer.append("from Orders.orders.dbo.C_ST_Delivery ");
		buffer.append("inner join Orders.orders.dbo.B_Departments on B_DP_DepartmentID = C_ST_D_SupplierID ");
		buffer.append("inner join Orders.orders.dbo.C_ST_Po on C_ST_P_ID = C_ST_D_PoID ");
		buffer.append("where C_ST_P_BillTypeId = '2' and C_ST_P_AuditState = '7' ");
		
		if(!"".equals(Utility.getName(consignProcessReceiptPo.getCstcprsalesid()))){
			buffer.append("and C_ST_P_SalseID like '%' + ? +'%' ");//quyanping
			params.add(consignProcessReceiptPo.getCstcprsalesid());
		}
		
		if(!"".equals(Utility.getName(consignProcessReceiptPo.getCstcprordersdeliveryid()))){
			buffer.append("and C_ST_D_ID like '%' + ? +'%' ");//quyanping
			params.add(consignProcessReceiptPo.getCstcprordersdeliveryid());
		}
		
		if (!"".equals(Utility.getName(consignProcessReceiptPo.getCstcprdeliverystart()))
				&& !"".equals(Utility.getName(consignProcessReceiptPo.getCstcprdeliveryend()))) {
			buffer.append("and convert(varchar(10), C_ST_D_BillDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), C_ST_D_BillDate, 23) <= ? ");

			params.add(consignProcessReceiptPo.getCstcprdeliverystart());
			params.add(consignProcessReceiptPo.getCstcprdeliveryend());
		} else if (!"".equals(Utility.getName(consignProcessReceiptPo.getCstcprdeliverystart())) 
				&& "".equals(Utility.getName(consignProcessReceiptPo.getCstcprdeliveryend()))) {
			buffer.append("and convert(varchar(10), C_ST_D_BillDate, 23) >= ? ");

			params.add(consignProcessReceiptPo.getCstcprdeliverystart());
		} else if ("".equals(Utility.getName(consignProcessReceiptPo.getCstcprdeliverystart())) 
				&& !"".equals(Utility.getName(consignProcessReceiptPo.getCstcprdeliveryend()))) {
			buffer.append("and convert(varchar(10), C_ST_D_BillDate, 23) <= ? ");

			params.add(consignProcessReceiptPo.getCstcprdeliveryend());
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , ConsignProcessReceiptPo.class);
	}
	
	/**
	 * 更新销售基表中隐形订做片的商品条码
	 * @param salesDetailPo
	 */
	public void updateDetailsBarcode(SalesDetailPo salesDetailPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("update S_SE_SalesDetail ");
		buffer.append("set S_SE_SD_ItemID = ? , ");
		buffer.append("S_SE_SD_Updatetime = getdate(), ");		
		buffer.append("S_SE_SD_Guaranteeperiod = ?, ");
		buffer.append("S_SE_SD_Batch = ?, ");
		buffer.append("S_SE_SD_RegistrationNum = ? ");		
		buffer.append("where S_SE_SD_SalesID = ? ");
		buffer.append("and S_SE_SD_SalesItemID = ? ");
		buffer.append("and S_SE_SD_GlassFlag = ? ");
		
		params.add(salesDetailPo.getSsesditemid());		
		params.add(Utility.getName(salesDetailPo.getSsesdguaranteeperiod()));
		params.add(Utility.getName(salesDetailPo.getSsesdbatch()));
		params.add(Utility.getName(salesDetailPo.getSsesdregistrationnum()));
		params.add(salesDetailPo.getSsesdsalesid());
		params.add(salesDetailPo.getSsesdsalesitemid());
		params.add(salesDetailPo.getSsesdglassflag());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 更新订单明细表到货状态
	 * @param salesid
	 */
	public void updateConsignProcessOrdersDetailsState(String salesid) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("update C_ST_ConsignProcessOrderDetails ");
		buffer.append("set C_ST_CPOD_State = '1' ");
		buffer.append("where C_ST_CPOD_GlassesBillID = ? ");
		
		params.add(salesid);
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 查询配镜单的镜盒镜布
	 * @param salesid
	 */
	public List<SalesDetailPo> getSalesDetailPoForAccessories(String salesid) {
		
		StringBuffer sb=new StringBuffer();
		sb.append("select S_SE_SD_SalesItemID as ssesdsalesitemid,S_SE_SD_ItemID as ssesditemid,S_SE_SD_StockId as ssesdstockid,");
		sb.append("S_SE_SD_Number as ssesdnumber,S_SE_SD_UnitPrice as ssesdunitprice,S_SE_SD_CostsPrive as ssesdcostsprive,S_SE_SD_SalesID as ssesdsalesid ");
		sb.append(" from S_SE_SalesDetail ");
		sb.append(" where S_SE_SD_SalesID= ? and substring(S_SE_SD_SalesItemID,1,1)='2' and S_SE_SD_LargessFlag='1'");
		List<String> params=new ArrayList<String>();
		params.add(salesid);
		
		return queryForObjectList(sb.toString() , params.toArray() , SalesDetailPo.class);
	}
	/**
	 * 查询在途明细表
	 * @param inTransitPo top1
	 */
	public InTransitPo getIntransitPo(InTransitPo inTransitPo){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select S_SE_IT_ID as sseitid,S_SE_IT_SalesID as sseitsalesid ");
		buffer.append(",S_SE_IT_State as sseitstate,S_SE_IT_Date as sseitdate ");
		buffer.append(",S_SE_IT_CreatePerson as sseitcreateperson,S_SE_IT_Department as sseitdepartment ");
		buffer.append(",S_SE_IT_YsalesID as sseitysalesid from S_SE_InTransit where S_SE_IT_SalesID = ? ");
		
		params.add(inTransitPo.getSseitsalesid());
		
		return (InTransitPo)queryForObject(buffer.toString() , params.toArray() , InTransitPo.class);
	}
	
	/**
	 * 业务临时表
	 * @param inventoryTempPo
	 */
	public void insertInventory(InventoryTempPo inventoryTempPo){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("INSERT INTO C_ST_Inventory (C_ST_I_BillID,C_ST_I_BillTypeId,C_ST_I_SourceBillId,C_ST_I_DeliveryID,C_ST_I_billDate ");
		buffer.append("           ,C_ST_I_InStockId,C_ST_I_SupplierId,C_ST_I_DepartmentId,C_ST_I_createPerson,C_ST_I_AuditPerson,C_ST_I_AuditState ");
		buffer.append("           ,C_ST_I_AuditDate,C_ST_I_FinanceAuditState,C_ST_I_InvoiceState,C_ST_I_Remark,C_ST_I_SubSupplierId) ");
		buffer.append("SELECT C_ST_CPR_ReceiptBillId,'9',C_ST_CPR_Salesid,C_ST_CPR_WaybillID,C_ST_CPR_BillDate,C_ST_CPR_InStockId ");
		buffer.append("      ,C_ST_CPR_SupplierId,C_ST_CPR_DepartmentId,C_ST_CPR_CreatePerson,C_ST_CPR_AuditPerson,C_ST_CPR_AuditState ");
		buffer.append("      ,C_ST_CPR_AuditDate,0,0,C_ST_CPR_Remark,C_ST_CPR_SubSupplierId ");
		buffer.append("  FROM C_ST_ConsignProcessReceipt where C_ST_CPR_ReceiptBillId = ? ");
		
		params.add(Utility.getName(inventoryTempPo.getCstitbillid()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	/**
	 * 业务明细临时表
	 * @param inventoryTempEntryPo
	 */
	public void insertInventoryEntry(InventoryTempPo inventoryTempPo){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("INSERT INTO C_ST_InventoryEntry (C_ST_IE_ID,C_ST_IE_BillID,C_ST_IE_GoodsId,C_ST_IE_GoodsQuantity,C_ST_IE_NotTaxRate, ");
		buffer.append("           C_ST_IE_NotTaxRateAmount,C_ST_IE_TaxRate,C_ST_IE_CostPrice,C_ST_IE_TaxAmount ");
		buffer.append("           ,C_ST_IE_CostPriceAmount,C_ST_IE_InStockId,C_ST_IE_BarCode,C_ST_IE_WarehousingDate ");
		buffer.append("           ,C_ST_IE_Remark,C_ST_IE_InvoiceState,C_ST_IE_checkquantity,C_ST_IE_OutStorageFlag ");
		buffer.append("           ,C_ST_IE_RetailPrice) ");
		buffer.append("SELECT C_ST_CPRD_Id,C_ST_CPRD_ReceiptBillD,C_ST_CPRD_GoodsID,C_ST_CPRD_Num,B_GI_NotTaxRate ");
		buffer.append("      ,cast((B_GI_NotTaxRate * C_ST_CPRD_Num) as numeric(30,2)),B_GI_TaxRate,B_GI_CostPrice ");
		buffer.append("      ,(cast((B_GI_CostPrice * C_ST_CPRD_Num) as numeric(30,2))-cast((B_GI_NotTaxRate * C_ST_CPRD_Num) as numeric(30,2))) ");
		buffer.append("      ,cast((B_GI_CostPrice * C_ST_CPRD_Num) as numeric(30,2)) ");
		buffer.append("      ,C_ST_CPRD_InStockId,C_ST_CPRD_BarCode,getdate(),'',0,0,'',B_GI_RetailPrice ");
		buffer.append("  FROM C_ST_ConsignProcessReceiptDetails inner join B_GoodsInfo on C_ST_CPRD_GoodsID=B_GI_GoodsID ");
		buffer.append("  where C_ST_CPRD_ReceiptBillD = ? ");
		
		params.add(Utility.getName(inventoryTempPo.getCstitbillid()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
		
	}
	
	
	public SalesBasicPo getSalesBasicPo(String salesID) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid,S_SE_SB_ShopCode as ssesbshopcode from S_SE_SalesBasic ");
		buffer.append(" where S_SE_SB_SalesID=? ");
		
		params.add(salesID);
		
		return (SalesBasicPo)queryForObject(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}
	
	/**
	 * 查询镜片商品是否一个订制片一个成品片
	 * @param consignProcessReceiptPo
	 * @return
	 */
	public List<ConsignProcessOrderDetailsPo> selectGlassesIsDandC(ConsignProcessOrderDetailsPo po) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select ");
		buffer.append("S_SE_SD_SalesItemID 			as cstcpodgoodsid , ");
		buffer.append("B_GI_isCustomize 			as cstcpiscustomize  ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join B_GoodsInfo on S_SE_SD_SalesItemID = B_GI_GoodsID ");
		buffer.append("where S_SE_SD_SalesID = ? ");
		buffer.append("and B_GI_SupplierID <> 'ZZ' ");
		buffer.append("and B_GI_GoodsCategoryID = '3' ");
		
		params.add(po.getCstcpodglassesbillid());
		
		return queryForObjectList(buffer.toString() , params.toArray() , ConsignProcessOrderDetailsPo.class);
	}
	
	/**
	 * 查询配镜单中的镜架、太阳镜、老花镜
	 */
	public List<ConsignProcessOrderDetailsPo> getFrameGoods(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select S_SE_SD_GlassFlag     as cstcpodglassflag , ");
		buffer.append("S_SE_SD_SalesItemID 			as cstcpodgoodsid , ");
		buffer.append("S_SE_SD_SalesItemName 		as cstcpogoodsname , ");
		buffer.append("S_SE_SD_Number 			    as cstcpodnum, ");
		buffer.append("B_GI_RetailPrice 		    as cstcpretailprice ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join B_GoodsInfo on B_GI_GoodsID = S_SE_SD_SalesItemID ");
		buffer.append("where S_SE_SD_SalesID = ? and B_GI_GoodsCategoryID in ('1','6','8') ");
		
		params.add(Utility.getName(consignProcessOrderDetailsPo.getCstcpodglassesbillid()));
		
		return queryForObjectList(buffer.toString() , params.toArray() , ConsignProcessOrderDetailsPo.class);
	}
	
}
