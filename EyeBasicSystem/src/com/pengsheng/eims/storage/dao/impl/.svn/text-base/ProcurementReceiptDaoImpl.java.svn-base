package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.storage.dao.ProcurementReceiptDao;
import com.pengsheng.eims.storage.persistence.DeliveryDetailPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.eims.storage.persistence.VerificationPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * 采购收货dao实现类
 */
public class ProcurementReceiptDaoImpl extends BaseJdbcDaoSupport implements
ProcurementReceiptDao {
	/**
	 * 获取采购收货的数量
	 * 
	 * @param po
	 *            InventoryPo
	 * @return int 数量
	 */
	public int getProcurementReceiptCount(InventoryPo po) {
		StringBuffer sb = new StringBuffer();

		sb.append("select count(distinct C_ST_Inventory.C_ST_I_BillID) from C_ST_Inventory ");
		//如果没有需要查询商品的条件，就不关联单据明细表和商品资料表  By moyongsheng 2014-12-11
		if (!"".equals(Utility.getName(po.getCstisupplierid()))||!"".equals(Utility.getName(po.getCstigoodsname()))||!"".equals(Utility.getName(po.getCstigoodsid()))) {
			sb.append("inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID inner join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID ");	
		}
		
		sb.append("inner join B_Warehouse on C_ST_Inventory.C_ST_I_InStockId=B_Warehouse.B_WH_ID ");
		sb.append(" left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID where C_ST_Inventory.C_ST_I_BillTypeId='1' ");
		
		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(po.getCsticompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCsticompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_BillID like '%' + ? + '%' ");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_SourceBillId like '%' + ? + '%' ");
			params.add(po.getCstisourcebillid());
		}
		if (!"".equals(Utility.getName(po.getCstibilltypeid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_BillTypeId=? ");
			params.add(po.getCstibilltypeid());
		}
		if (!"".equals(Utility.getName(po.getCstiinstockid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_InStockId=? ");
			params.add(po.getCstiinstockid());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstate()))) {
			sb.append("and C_ST_Inventory.C_ST_I_AuditState=? ");
			params.add(po.getCstiauditstate());
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());
		} else if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& "".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());
		} else if ("".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstiendTime());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) <= ? ");
			params.add(po.getCstiauditstartdate());
			params.add(po.getCstiauditenddate());
		} else if (!"".equals(Utility.getName(po.getCstiauditstartdate()))
				&& "".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) >= ? ");
			params.add(po.getCstiauditstartdate());
		} else if ("".equals(Utility.getName(po.getCstiauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) <= ? ");
			params.add(po.getCstiauditenddate());
		}
		if (!"".equals(Utility.getName(po.getCsticreateperson()))) {
			sb.append("and C_ST_Inventory.C_ST_I_createPerson=? ");
			params.add(po.getCsticreateperson());
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb.append("and C_ST_Inventory.C_ST_I_AuditPerson=? ");
			params.add(po.getCstiauditperson());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_SupplierId=? ");
			params.add(po.getCstisupplierid());
		}
		if(!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsname()));
		}
		if(!"".equals(Utility.getName(po.getCstigoodscategory()))){
			sb.append("and C_ST_I_GoodsCategory = ? ");
			params.add(Utility.getName(po.getCstigoodscategory()));
		}
		if(!"".equals(Utility.getName(po.getCstiremark()))){
			sb.append("and C_ST_I_Remark like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstiremark()));
		}
		if(!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("and C_ST_IE_GoodsId like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsid()));
		}
		if(!"".equals(Utility.getName(po.getDeliveryID()))){
			sb.append("and C_ST_I_DeliveryID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getDeliveryID()));
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 获取采购收货的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @param start
	 * @param size
	 * @return list InventoryPo的list
	 */
	public List<InventoryPo> getProcurementReceiptList(InventoryPo po,
			int start, int size) {

		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from (select ROW_NUMBER() Over(order by temp.cstibilldate desc) as rowNum,temp.cstibillid as cstibillid,temp.cstisourcebillid as cstisourcebillid,temp.cstibilltypeid as cstibilltypeid,");
		sb.append("temp.deliveryID as deliveryID,temp.cstibilldate as cstibilldate,temp.cstiauditdate as cstiauditdate,temp.cstiinstockname as cstiinstockname,temp.cstigoodscategory as cstigoodscategory,");
		sb.append("temp.cstiauditstate as cstiauditstate,temp.csticreatepersonname as csticreatepersonname,temp.cstiauditpersonname as cstiauditpersonname,temp.cstiremark as cstiremark,temp.cstigoodscategoryname as cstigoodscategoryname ");
		sb.append("from(select distinct C_ST_I_DeliveryID as deliveryID,C_ST_Inventory.C_ST_I_BillID as cstibillid,C_ST_Inventory.C_ST_I_GoodsCategory as cstigoodscategory,C_ST_Inventory.C_ST_I_SourceBillId as cstisourcebillid,C_ST_Inventory.C_ST_I_BillTypeId as cstibilltypeid,");
		sb.append("C_ST_Inventory.C_ST_I_billDate as cstibilldate,C_ST_Inventory.C_ST_I_AuditDate as cstiauditdate,B_Warehouse.B_WH_warehouseName as cstiinstockname,C_ST_I_Remark as cstiremark,B_GC_GoodsCategoryName as cstigoodscategoryname,");
		sb.append("C_ST_Inventory.C_ST_I_AuditState as cstiauditstate,a.personName as csticreatepersonname,b.personName as cstiauditpersonname from C_ST_Inventory ");

		//如果没有需要查询商品的条件，就不关联单据明细表和商品资料表  By moyongsheng 2014-12-11
		if (!"".equals(Utility.getName(po.getCstisupplierid()))||!"".equals(Utility.getName(po.getCstigoodsname()))||!"".equals(Utility.getName(po.getCstigoodsid()))) {
			sb.append("inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID inner join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID ");	
		}
		
		sb.append("inner join B_Warehouse on C_ST_Inventory.C_ST_I_InStockId=B_Warehouse.B_WH_ID ");
		
		sb.append(" left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");

		sb.append("left join B_GoodsCategory on B_GC_ID = C_ST_I_GoodsCategory ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID where C_ST_Inventory.C_ST_I_BillTypeId='1' ");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(po.getCsticompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCsticompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_BillID like '%' + ? + '%' ");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_SourceBillId like '%' + ? + '%' ");
			params.add(po.getCstisourcebillid());
		}
		if (!"".equals(Utility.getName(po.getCstibilltypeid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_BillTypeId=? ");
			params.add(po.getCstibilltypeid());
		}
		if (!"".equals(Utility.getName(po.getCstiinstockid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_InStockId=? ");
			params.add(po.getCstiinstockid());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstate()))) {
			sb.append("and C_ST_Inventory.C_ST_I_AuditState=? ");
			params.add(po.getCstiauditstate());
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());
		} else if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& "".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());
		} else if ("".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstiendTime());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) <= ? ");
			params.add(po.getCstiauditstartdate());
			params.add(po.getCstiauditenddate());
		} else if (!"".equals(Utility.getName(po.getCstiauditstartdate()))
				&& "".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) >= ? ");
			params.add(po.getCstiauditstartdate());
		} else if ("".equals(Utility.getName(po.getCstiauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) <= ? ");
			params.add(po.getCstiauditenddate());
		}
		if (!"".equals(Utility.getName(po.getCsticreateperson()))) {
			sb.append("and C_ST_Inventory.C_ST_I_createPerson=? ");
			params.add(po.getCsticreateperson());
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb.append("and C_ST_Inventory.C_ST_I_AuditPerson=? ");
			params.add(po.getCstiauditperson());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_SupplierId=? ");
			params.add(po.getCstisupplierid());
		}
		if(!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsname()));
		}
		if(!"".equals(Utility.getName(po.getCstigoodscategory()))){
			sb.append("and C_ST_I_GoodsCategory = ? ");
			params.add(Utility.getName(po.getCstigoodscategory()));
		}
		if(!"".equals(Utility.getName(po.getCstiremark()))){
			sb.append("and C_ST_I_Remark like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstiremark()));
		}
		if(!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("and C_ST_IE_GoodsId like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsid()));
		}
		if(!"".equals(Utility.getName(po.getDeliveryID()))){
			sb.append("and C_ST_I_DeliveryID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getDeliveryID()));
		}
		
		sb.append(" )temp ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(),
				InventoryPo.class);
	}

	/**
	 * 新增采购收货主表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void insertProcurementReceipt(InventoryPo po) {
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		sb1.append("insert into C_ST_Inventory(C_ST_I_GoodsCategory,C_ST_I_BillID,C_ST_I_BillTypeId,C_ST_I_billDate,");
		sb1.append("C_ST_I_SupplierId,C_ST_I_InStockId, ");
		sb1.append("C_ST_I_DepartmentId,C_ST_I_createPerson,C_ST_I_AuditState,C_ST_I_Remark, C_ST_I_DeliveryID,C_ST_I_InvoiceState,C_ST_I_SubSupplierId ");
		sb2.append("?,?,?,getdate(),?,?,?,?,?,?,?,0,?");

		List<String> params = new ArrayList<String>();

		params.add(po.getCstigoodscategory());
		params.add(po.getCstibillid());
		params.add(po.getCstibilltypeid());
		params.add(po.getCstisupplierid());   // 制造商
		params.add(po.getCstiinstockid());
		params.add(po.getCstidepartmentid());
		params.add(po.getCsticreateperson());
		params.add(po.getCstiauditstate());
		params.add(po.getCstiremark());
		params.add(Utility.getName(po.getDeliveryID()));
		params.add(Utility.getName(po.getCstisubsupplierid()));  // 供应商

		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb1.append(",C_ST_I_AuditPerson,C_ST_I_AuditDate,C_ST_I_FinanceAuditState,C_ST_I_AllocationStatus");
			sb2.append(",?,getdate(),'0','1' ");
			params.add(po.getCstiauditperson());
		}
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			sb1.append(",C_ST_I_SourceBillId");
			sb2.append(",?");
			params.add(po.getCstisourcebillid());
		}
		if (!"".equals(Utility.getName(po.getCstistorereceiptid()))) {
			sb1.append(",C_ST_I_StoreReceiptID");
			sb2.append(",?");
			params.add(po.getCstistorereceiptid());
		}
		String sql = sb1.toString() + ")values(" + sb2.toString() + ")";
		getJdbcTemplate().update(sql, params.toArray());
	}

	/**
	 * 新增采购收货明细表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void insertProcurementReceiptEntry(InventoryEntryPo po) {

		String sql = "insert into C_ST_InventoryEntry(C_ST_IE_ID,C_ST_IE_BillID,C_ST_IE_GoodsId,C_ST_IE_GoodsQuantity,"
			+ "C_ST_IE_NotTaxRate,C_ST_IE_TaxRate,C_ST_IE_CostPrice,"
			+ "C_ST_IE_InStockId,C_ST_IE_BarCode,C_ST_IE_WarehousingDate,C_ST_Ie_InvoiceState,C_ST_IE_GuaranteePeriod,C_ST_IE_Batch,C_ST_IE_RegistrationNum) "
			+ "values(?,?,?,?,?,?,?,?,?,getdate(),0,?,?,?)";

		List<String> params = new ArrayList<String>();

		params.add(!"".equals(Utility.getName(po.getCstieid())) ? po.getCstieid() : this.uuid.generate());
		params.add(po.getCstiebillid());
		params.add(po.getCstiegoodsid());
		params.add(po.getCstiegoodsquantity());
		params.add(po.getCstienottaxrate());
		params.add(po.getCstietaxrate());
		params.add(po.getCstiecostprice());
		params.add(po.getCstieinstockid());
		params.add(po.getCstiepcbarcode());
		params.add(Utility.getName(po.getCstieguaranteeperiod()));
		params.add(Utility.getName(po.getCstiebatch()));
		params.add(Utility.getName(po.getCstieregistrationnum()));

		getJdbcTemplate().update(sql, params.toArray());

	}

	/**
	 * 新增核销表
	 * 
	 * @param po
	 *            VerificationPo
	 */
	public void insertVerification(VerificationPo po) {

		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		sb1
		.append("insert into C_ST_Verification(C_ST_V_PinID,C_ST_V_GoodsId,C_ST_V_BarCode,C_ST_V_Num,C_ST_V_Datetime,C_ST_V_UUID");
		sb2.append("?,?,?,?,getdate(),?");

		List<String> params = new ArrayList<String>();

		params.add(po.getCstvpinid());
		params.add(po.getCstvgoodsid());
		params.add(po.getCstvbarcode());
		params.add(po.getCstvnum());
		params.add(this.uuid.generate());

		if (!"".equals(Utility.getName(po.getCstvpoid()))) {
			sb1.append(",C_ST_V_PoID");
			sb2.append(",?");
			params.add(po.getCstvpoid());
		}
		String sql = sb1.toString() + ")values(" + sb2.toString() + ")";
		getJdbcTemplate().update(sql, params.toArray());

	}

	/**
	 * 修改采购收货主表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void updateProcurementReceipt(InventoryPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("update C_ST_Inventory set C_ST_I_InStockId=?,C_ST_I_DeliveryID = ?,");
		sb.append("C_ST_I_AuditState=?,C_ST_I_Remark=? ");

		List<String> params = new ArrayList<String>();

		params.add(po.getCstiinstockid());
		params.add(po.getDeliveryID());
		params.add(po.getCstiauditstate());
		params.add(po.getCstiremark());

		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb
			.append(",C_ST_I_AuditPerson=?,C_ST_I_AuditDate=getdate(),C_ST_I_FinanceAuditState='0',C_ST_I_AllocationStatus='1' ");
			params.add(po.getCstiauditperson());
		}
		sb.append(" where C_ST_Inventory.C_ST_I_BillID=?");

		params.add(po.getCstibillid());

		getJdbcTemplate().update(sb.toString(), params.toArray());

	}

	/**
	 * 获取采购收货的po
	 * 
	 * @param po
	 *            InventoryPo
	 * @return po InventoryPo
	 */
	public InventoryPo getProcurementReceipt(InventoryPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("select top 1  C_ST_I_BillID as cstibillid,C_ST_I_BillTypeId as cstibilltypeid,C_ST_I_SourceBillId as cstisourcebillid,C_ST_I_billDate as cstibilldate,C_ST_I_InStockId as cstiinstockid,B_Warehouse.B_WH_warehouseName as cstiinstockname,");
		sb.append("C_ST_I_GoodsCategory as cstigoodscategory,B_GC_GoodsCategoryName as cstigoodscategoryname,C_ST_I_SupplierId as cstisupplierid,B_Supplier.B_SP_SupplierName as cstisuppliername,C_ST_I_PurchseWayId as cstipurchsewayid,C_ST_I_DayLimit as cstidaylimit,");
		sb.append("C_ST_I_DepartmentId as cstidepartmentid,C_ST_I_createPerson as csticreateperson,C_ST_I_AuditPerson as cstiauditperson,a.personName as csticreatepersonname,b.personName as cstiauditpersonname,C_ST_I_AuditState as cstiauditstate,");
		sb.append("C_ST_I_AuditDate as cstiauditdate,C_ST_I_FinanceAuditState as cstifinanceauditstate,C_ST_I_Remark as cstiremark, C_ST_I_DeliveryID as deliveryID from C_ST_Inventory ");
		sb.append("inner join B_Supplier on C_ST_Inventory.C_ST_I_SupplierId=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Warehouse on C_ST_Inventory.C_ST_I_InStockId=B_Warehouse.B_WH_ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID ");
		sb.append("left join B_GoodsCategory on C_ST_I_GoodsCategory = B_GC_ID ");
		sb.append("where C_ST_I_BillID=? ");

		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());

		return (InventoryPo) queryForObject(sb.toString(), params.toArray(),
				InventoryPo.class);
	}

	/**
	 * 获取采购收货明细表的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @return list List<InventoryEntryPo>
	 */
	public List<InventoryEntryPo> getProcurementReceiptEntryList(InventoryPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select UPPER(B_GoodsInfo.B_GI_GoodsID) as cstiegoodsid,UPPER(C_ST_InventoryEntry.c_st_ie_BarCode) as cstiebarcode,");
		
		if("2".equals(po.getCstiwhichretail())){
			sb.append("isnull(B_GI_RetailPriceA,0.00) as cstieretailprice, ");
		}else if("3".equals(po.getCstiwhichretail())){
			sb.append("isnull(B_GI_RetailPriceB,0.00) as cstieretailprice, ");
		}else if("4".equals(po.getCstiwhichretail())){
			sb.append("isnull(B_GI_RetailPriceC,0.00) as cstieretailprice, ");
		}else if("5".equals(po.getCstiwhichretail())){
			sb.append("isnull(B_GI_RetailPriceD,0.00) as cstieretailprice, ");
		}else if("6".equals(po.getCstiwhichretail())){
			sb.append("isnull(B_GI_RetailPrgetE,0.00) as cstieretailprice, ");
		}else if("7".equals(po.getCstiwhichretail())){
			sb.append("isnull(B_GI_RetailPriceF,0.00) as cstieretailprice, ");
		}else if("8".equals(po.getCstiwhichretail())){
			sb.append("isnull(B_GI_RetailPriceG,0.00) as cstieretailprice, ");
		}else if("9".equals(po.getCstiwhichretail())){
			sb.append("isnull(B_GI_RetailPriceH,0.00) as cstieretailprice, ");
		}else if("10".equals(po.getCstiwhichretail())){
			sb.append("isnull(B_GI_RetailPriceI,0.00) as cstieretailprice, ");
		}else{
			sb.append("isnull(B_GI_RetailPrice,0.00) as cstieretailprice, ");
		}
		
		sb.append("B_GoodsInfo.B_GI_CostPrice as cstiecostprice,B_GoodsInfo.B_GI_NotTaxRate as cstienottaxrate,");
		sb.append("B_GoodsInfo.B_GI_TaxRate as cstietaxrate,B_GoodsInfo.B_GI_ViewGoodsName as cstiegoodsname,B_GoodsInfo.B_GI_Spec as cstiespec,");
		sb.append("case ");
		sb.append("when B_GI_GoodsCategoryID = '8' then isnull(B_GoodsInfo.B_GI_Color,'')+isnull(B_GoodsInfo.B_GI_Sph,'') ");
		sb.append("when B_GI_GoodsCategoryID <> '8' then isnull(B_GoodsInfo.B_GI_Color,'') end as cstiecolor,");
		sb.append("B_GoodsInfo.B_GI_Sph as cstiesph,B_GoodsInfo.B_GI_Cyl as cstiecyl,B_GoodsInfo.B_GI_Axis as cstieaxis,C_ST_IE_GuaranteePeriod as cstieguaranteeperiod , C_ST_IE_Batch as cstiebatch, ");
		sb.append("B_GoodsInfo.B_GI_Curvature1 as cstiecurvature1,B_GoodsInfo.B_GI_Dia as cstiedia,C_ST_InventoryEntry.C_ST_IE_GoodsQuantity as cstiegoodsquantity, ");
		sb.append("B_GI_FrameMaterialType    AS bgiframematerialtype , ");
		sb.append("B_FrameMaterial.B_FM_Name    AS bgiframematerialtypename , ");
		sb.append("B_GI_FrameSize     AS bgiframesize , ");
		sb.append("B_GI_AccessoriesType     AS bgiaccessoriestype , ");
		sb.append("B_GI_Capacity     AS bgicapacity , ");
		sb.append("B_GI_CapacityEntry     AS bgicapacityentry , ");
		sb.append("B_GI_SupplierColor     AS bgisuppliercolor , ");	
		sb.append("B_GI_BelowPlusLuminosity     AS bgibelowplusluminosity , ");
		sb.append("B_GI_Refractive     AS bgirefractive , ");
		sb.append("B_GI_isMutiLuminosity     AS bgiismutiluminosity , ");
		sb.append("B_GI_EyeGlassMaterialType     AS bgieyeglassmaterialtype , ");
		sb.append("B_GI_UseType     AS bgiusetype , ");
		sb.append("B_GI_StealthClass     AS bgistealthclass, ");
		sb.append("B_BD_BrandName 			as cstiebrandname, ");
		//sb.append("C_SH_SL_Rksj as cstierksj, ");
		sb.append("C_ST_IE_GuaranteePeriod as cstieguaranteeperiod,C_ST_IE_Batch as cstiebatch,B_BD_Place as cstiesource,isnull(C_ST_IE_RegistrationNum,'') as cstieregistrationnum from C_ST_InventoryEntry ");
		sb.append("left join B_GoodsInfo on C_ST_InventoryEntry.C_ST_IE_GoodsId=B_GoodsInfo.B_GI_GoodsID ");
		sb.append("INNER JOIN B_Brand ON substring(B_GI_GoodsID,6,2) = B_BD_ID and substring(B_GI_GoodsID,3,2) = B_BD_SupplierID ");
		sb.append(" left join B_FrameMaterial on B_FrameMaterial.B_FM_ID = B_GoodsInfo.B_GI_FrameMaterialType ");
		//sb.append(" left join C_SH_StorageLog on C_SH_StorageLog.C_SH_SL_ChangeID = C_ST_InventoryEntry.C_ST_IE_BillID  and C_SH_StorageLog.C_SH_SL_GoodsBarCode=C_ST_InventoryEntry.C_ST_IE_BarCode ");
		sb.append("where C_ST_InventoryEntry.C_ST_IE_BillID=? order by C_ST_InventoryEntry.C_ST_IE_GoodsId ");

		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());

		return queryForObjectList(sb.toString(), params.toArray(),
				InventoryEntryPo.class);
	}

	/**
	 * 删除采购收货主表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void deleteProcurementReceipt(InventoryPo po) {

		String sql = "delete from C_ST_Inventory where C_ST_I_BillID=? ";

		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());

		getJdbcTemplate().update(sql, params.toArray());
	}

	/**
	 * 删除采购收货明细表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void deleteProcurementReceiptEntry(InventoryPo po) {

		String sql = "delete from C_ST_InventoryEntry where C_ST_IE_BillID=? ";

		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());

		getJdbcTemplate().update(sql, params.toArray());
	}

	/**
	 * 删除核销表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void deleteVerification(InventoryPo po) {

		String sql = "delete from C_ST_Verification where C_ST_V_PinID=?";

		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());

		getJdbcTemplate().update(sql, params.toArray());
	}

	/*
	 * 更改采购订单收货标识
	 */
	public void updateOrder(InventoryPo po) {
		String sql = "update C_ST_Po set C_ST_P_flag=1 where C_ST_P_ID=?";

		List<String> params = new ArrayList<String>();
		params.add(po.getCstisourcebillid());
		getJdbcTemplate().update(sql, params.toArray());
	}
	/*
	 * 
	 */
	public void updateOrderDeliveryID(InventoryPo po) {
		String sql = "update C_ST_Inventory set C_ST_I_DeliveryID=? where C_ST_I_BillID=?";

		List<String> params = new ArrayList<String>();
		params.add(po.getCstideliveryid());
		params.add(po.getCstibillid());
		getJdbcTemplate().update(sql, params.toArray());
	}

	/*
	 * 更改调拨流程状态标识
	 */
	public void updateOrderStatus(InventoryPo po) {
		String sql = "update C_SHA_Status set C_SHA_StatusReceiptID=? where C_SHA_StatusOrderID=?";

		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());
		params.add(po.getCstisourcebillid());
		getJdbcTemplate().update(sql, params.toArray());
	}

	/*
	 * 新增采购收货单到状态表
	 */
	public void insertOrderStatus(InventoryPo po) {
		String sql ="insert into C_SHA_Status (C_SHA_StatusUUID,C_SHA_StatusReceiptID) values(?,?) ";
		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(po.getCstibillid());
		getJdbcTemplate().update(sql, params.toArray());
	}

	public String getGoodsBarCode(String goodsId) {
		String goodsBarCode = "";
		goodsBarCode=goodsId+"00000000";
		return goodsBarCode;
	}

	public String updateOrderProcurementReceiptState(String id) {
		String callSQL = "exec SP_ProcurementReceiptUpdate ? ";

		List<String> params = new ArrayList<String>();
		params.add(id);

		this.getJdbcTemplate().update(callSQL, params.toArray());
		return "";
	}

	/**
	 * 采购订单list
	 * 
	 * @param po
	 *            订单po
	 * @param start
	 * @param size
	 * @return list 订单list
	 */
	public List<GoodsInfoPo> getProcurementOrdersList(ProcurementOrdersPo po) {

		StringBuffer sb = new StringBuffer();

		List<String> params = new ArrayList<String>();

		sb
		.append("select temp.cstpid as cstpid,temp.bgigoodsid as bgigoodsid,temp.goodsquantity as bgigoodsquantity,temp.bgigoodsname as bgigoodsname,temp.bgisuppliername as bgisuppliername,");
		sb
		.append("temp.bgisph as bgisph,temp.bgicyl as bgicyl,temp.bgiaxis as bgiaxis,temp.bgicurvature1 as bgicurvature1,");
		sb
		.append("temp.bgidia as bgidia,temp.bgitaxrate as bgitaxrate,temp.bgigoodsbarcode as bgigoodsbarcode,");
		sb
		.append("temp.bgispec as bgispec,temp.bgicolor as bgicolor,temp.bgibrandname as bgibrandname,");
		sb
		.append("temp.bgiunitname as bgiunitname,temp.bgicostprice as bgicostprice,");
		sb
		.append("temp.bgiretailprice as bgiretailprice,temp.bginottaxrate as bginottaxrate,temp.goodsquantity as goodsquantity ");
		sb.append("from(select ");
		sb
		.append("c.cstpid as cstpid,c.goodsid as bgigoodsid,c.goodsquantity,B_GoodsInfo.B_GI_ViewGoodsName as bgigoodsname,");
		sb
		.append("B_Supplier.B_SP_SupplierName as bgisuppliername,B_GoodsInfo.B_GI_Spec as bgispec,");
		sb
		.append("B_GoodsInfo.B_GI_Color as bgicolor,B_GoodsInfo.B_GI_Sph as bgisph,B_GoodsInfo.B_GI_Cyl as bgicyl,");
		sb
		.append("B_GoodsInfo.B_GI_Axis as bgiaxis,B_GoodsInfo.B_GI_Curvature1 as bgicurvature1,B_GoodsInfo.B_GI_Dia as bgidia,");
		sb
		.append("B_GoodsInfo.B_GI_TaxRate as bgitaxrate,B_GoodsInfo.B_GI_GoodsBarCode as bgigoodsbarcode, ");
		sb.append("B_Brand.B_BD_brandName as bgibrandname,");
		sb
		.append("B_Unit.B_UT_unitName as bgiunitname,B_GoodsInfo.B_GI_RetailPrice as bgiretailprice,");
		sb
		.append("B_GoodsInfo.B_GI_CostPrice as bgicostprice,B_GoodsInfo.B_GI_NotTaxRate as bginottaxrate ");
		sb
		.append("from(select b.cstpid,b.goodsid,sum(b.goodsquantity) as goodsquantity from( ");
		sb
		.append("select ROW_NUMBER() Over(order by a.goodsid) as num,a.cstpid as cstpid,a.goodsid as goodsid,a.goodsquantity as goodsquantity from( ");
		sb
		.append("select C_ST_PE_PurchaseOrderID as cstpid,C_ST_PE_goodsID as goodsid,C_ST_PE_OrderNumber as goodsquantity from C_ST_PoEntry ");
		sb
		.append(" inner join C_ST_PO ON C_ST_P_ID = C_ST_PE_PurchaseOrderID and C_ST_P_AuditState = 1 ");

		sb.append(" where C_ST_PoEntry.C_ST_PE_PurchaseOrderID = ? ");
		sb.append(")a)b  group by b.goodsid,b.cstpid)c ");
		sb.append("inner join C_ST_PO on c.cstpid=C_ST_P_ID ");
		sb
		.append("inner join B_GoodsInfo on c.goodsid=B_GoodsInfo.B_GI_GoodsID ");
		sb
		.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb
		.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb
		.append("inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id) temp  ");

		params.add(po.getCstpid());

		return queryForObjectList(sb.toString(), params.toArray(),
				GoodsInfoPo.class);
	}

	public List<DeliveryDetailPo> getDeliverEntryList(String deliverID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT C_ST_DE_ID ");
		buffer.append(",C_ST_DE_DeliveryID as cstdedeliveryid ");
		buffer.append(",C_ST_DE_OrderNumber as cstdeordernumber ");
		buffer.append(",C_ST_DE_DeliveryNumber as cstdedeliverynumber ");
		buffer.append(",C_ST_DE_GoodsName as cstdegoodsname ");
		buffer.append(",C_ST_DE_Spec as cstdespec ");
		buffer.append(",C_ST_DE_Color as cstdecolor ");
		buffer.append(",C_ST_DE_BallGlass as cstdeballglass ");
		buffer.append(",C_ST_DE_PostGlass as cstdepostglass ");
		buffer.append(",C_ST_DE_Axis as cstdeaxis ");
		buffer.append(",C_ST_DE_Add as cstdeadd ");
		buffer.append(",C_ST_DE_ArriseGlass as cstdearriseglass ");
		buffer.append(",C_ST_DE_Basis as cstdebasis ");
		buffer.append(",C_ST_DE_GlassFlag as cstdeglassflag ");
		buffer.append(",C_ST_DE_SalseID as cstdesalseid ");
		buffer.append(",C_ST_DE_GoodsID as cstdegoodsid ");
		buffer.append(",C_ST_DE_Remark as cstderemark ");
		buffer.append("FROM Orders.orders.dbo.C_ST_DeliveryEntry ");
		buffer.append("WHERE C_ST_DE_DeliveryID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(deliverID);

		return queryForObjectList(buffer.toString(), params.toArray(),
				DeliveryDetailPo.class);
	}

	//查询库存数量
	public int selectProcurementReceiptcount(InventoryPo po) {
		StringBuffer sb=new StringBuffer();

		sb.append("select count(C_SH_SL_GoodsBarCode) from C_SH_StorageLog ");
		sb.append("where C_SH_SL_ChangeID=?");
		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

	//更新采购收货标示
	public void updatestatusReceipt(InventoryPo po) {
		StringBuffer sb = new StringBuffer();
		sb.append("update C_ST_Inventory set ");
		sb.append("C_ST_I_AuditState=1");
		sb.append(" where C_ST_Inventory.C_ST_I_BillID=? ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());

		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	/**
	 * Description :获取某一品种的最大最小光度
	 * 
	 * @return :某一品种的最大最小光度
	 */
	public GoodsInfoPo getMaxMinGoods(GoodsInfoPo goodsInfoPo){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("SELECT MAX(CAST(B_GI_Sph AS DECIMAL(18,2))) AS maxSph ");
		buffer.append(",MIN(CAST(B_GI_Sph AS DECIMAL(18,2))) AS minSph ");
		buffer.append(",MAX(CAST(B_GI_Cyl AS DECIMAL(18,2))) AS maxCyl ");
		buffer.append(",MIN(CAST(B_GI_Cyl AS DECIMAL(18,2))) AS minCyl ");
		buffer.append(" FROM B_GoodsInfo ");
		buffer.append("  WHERE SUBSTRING(B_GI_GoodsID,1,1)=? ");
		buffer.append("  AND B_GI_SupplierID=?  ");
		buffer.append(" AND B_GI_BrandID=? ");

		params.add(Utility.getName(goodsInfoPo.getBgigoodscategoryid()));
		params.add(Utility.getName(goodsInfoPo.getBgisupplierid()));		
		params.add(Utility.getName(goodsInfoPo.getBgibrandid()));

		return (GoodsInfoPo)queryForObject(buffer.toString(),params.toArray(),GoodsInfoPo.class);
	}
	/**
	 * Description :获取品种 
	 */
	public List<GoodsInfoPo> getProBrand(String proId){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT B_BD_ID as bgibrandid, ");
		sb.append("       B_BD_brandName as bgibrandname ");
		sb.append("FROM   C_ST_InventoryEntry ");
		sb.append("       INNER JOIN B_GOODSINFO ");
		sb.append("         ON B_GI_GOODSID = C_ST_IE_GoodsId ");
		sb.append("       INNER JOIN B_Brand ");
		sb.append("         ON B_BD_ID = B_GI_BrandID ");
		sb.append("            AND B_BD_SupplierID = B_GI_SupplierID ");
		sb.append("WHERE  C_ST_IE_BillID = ?  and B_GI_isCustomize <> 'D' ");
		sb.append("GROUP  BY B_BD_ID, ");
		sb.append("          B_BD_brandName ");
		params.add(Utility.getName(proId));
		return queryForObjectList(sb.toString(),params.toArray(),GoodsInfoPo.class);
	}
	/**
	 * Description :获取某一品种的二维数组(不涉及库存)
	 * 
	 * @return :某一品种的二维数组
	 */
	public List<GoodsInfoPo> getstringContextGoodsList(GoodsInfoPo goodsInfoPo){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("SELECT ISNULL(temp.stringContext,('{\"x\":'+ISNULL(CAST(CAST((CAST(? AS DECIMAL(18,2))-CAST(replace(b_gi_sphandcyl.B_GI_Sph,'+','') AS DECIMAL(18,2)))/0.25 AS int) as varchar),0) ");
		buffer.append("+',\"y\":'+ISNULL(CAST(CAST((CAST(? AS DECIMAL(18,2))-CAST(b_gi_sphandcyl.B_GI_Cyl AS DECIMAL(18,2)))/0.25 AS int) as varchar),0) ");
		buffer.append("+',\"goodsid\":\"'+'' ");
		buffer.append("+'\"}')) AS stringContext ");
		buffer.append("FROM b_gi_sphandcyl LEFT JOIN ( ");	 

		buffer.append("SELECT B_GI_Sph,B_GI_Cyl,");
		if (!"".equals(Utility.getName(goodsInfoPo.getBgiwarehouseid()))){
			buffer.append("(case ISNULL(temp.goodsquantity,0) when 0 then ('{\"x\":'+ISNULL(CAST(CAST((CAST(? AS DECIMAL(18,2))-CAST(B_GI_Sph AS DECIMAL(18,2)))/0.25 AS int) as varchar),0) ");
			buffer.append("+',\"y\":'+ISNULL(CAST(CAST((CAST(? AS DECIMAL(18,2))-CAST(B_GI_Cyl AS DECIMAL(18,2)))/0.25 AS int) as varchar),0) ");
			buffer.append("+',\"goodsid\":\"'+ISNULL(B_GI_GoodsID,'') ");	
			buffer.append("+'\"}') else ");
		}
		
		buffer.append("('{\"x\":'+ISNULL(CAST(CAST((CAST(? AS DECIMAL(18,2))-CAST(B_GI_Sph AS DECIMAL(18,2)))/0.25 AS int) as varchar),0) ");
		buffer.append("+',\"y\":'+ISNULL(CAST(CAST((CAST(? AS DECIMAL(18,2))-CAST(B_GI_Cyl AS DECIMAL(18,2)))/0.25 AS int) as varchar),0) ");
		buffer.append("+',\"goodsid\":\"'+ISNULL(B_GI_GoodsID,'') ");
		if (!"".equals(Utility.getName(goodsInfoPo.getBgiwarehouseid()))){
			buffer.append("+'\",\"v\":'+cast(ISNULL(temp.goodsquantity,0) as varchar) ");  //库存数量
			buffer.append("+'}') end ) ");
		}else{
			buffer.append("+'\"}') ");
		}
		buffer.append("  AS stringContext ");
		
		buffer.append("FROM B_GoodsInfo ");

		buffer.append("inner JOIN B_Supplier ON B_GI_SupplierID = B_SP_ID ");
		buffer.append("LEFT JOIN B_GoodsCategory  ON B_GI_GoodsCategoryID = B_GC_ID "); 
		buffer.append("inner JOIN B_Brand ON B_GI_BrandID = B_BD_ID AND B_GI_SupplierID = B_BD_SupplierID "); 
		buffer.append("LEFT JOIN B_Unit ON B_GI_UnitId = B_UT_id ");

		if (!"".equals(Utility.getName(goodsInfoPo.getBgiwarehouseid()))){
            buffer.append("LEFT JOIN (select goodsid,isnull(sum(goodsquantity),0) as goodsquantity from ( ");
			buffer.append("select C_SH_SB_GoodsId as goodsid,isnull(sum(C_SH_SB_GoodsQuantity),0) as goodsquantity ");
			buffer.append("  from C_SH_StorageBeginning inner join B_Warehouse on C_SH_SB_StockId=B_WH_ID ");
			buffer.append("  where C_SH_SB_StockId=? ");
			buffer.append("  group by C_SH_SB_GoodsId ");
			buffer.append("union all ");
			buffer.append("select C_SH_SC_GoodsId as goodsid,isnull(sum(C_SH_SC_GoodsQuantity),0) as goodsquantity ");
			buffer.append("  from C_SH_StorageChange inner join B_Warehouse on C_SH_SC_StockId=B_WH_ID ");
			buffer.append("  where C_SH_SC_StockId=? ");
			buffer.append("  group by C_SH_SC_GoodsId ");
			buffer.append(")temp ");
			buffer.append("  group by goodsid having isnull(sum(goodsquantity),0)<>0 ");
			buffer.append(")temp on B_GI_GoodsID=temp.goodsid ");
		}

		buffer.append(" WHERE SUBSTRING(B_GI_GoodsID,1,1) = ? and B_GI_Flag = '1' ");
		buffer.append(" AND B_GI_SupplierID = ? ");
		buffer.append(" AND B_GI_BrandID = ? ");

		buffer.append(" ) temp ON b_gi_sphandcyl.B_GI_Sph=temp.B_GI_Sph AND b_gi_sphandcyl.B_GI_Cyl=temp.B_GI_Cyl ");
		buffer.append(" WHERE CAST(replace(b_gi_sphandcyl.B_GI_Sph,'+','') AS DECIMAL(18,2)) <= ? AND CAST(replace(b_gi_sphandcyl.B_GI_Sph,'+','') AS DECIMAL(18,2)) >= ? ");
		buffer.append(" AND CAST(b_gi_sphandcyl.B_GI_Cyl AS DECIMAL(18,2)) <= ? AND CAST(b_gi_sphandcyl.B_GI_Cyl AS DECIMAL(18,2)) >= ? ");

		params.add(Utility.getName(goodsInfoPo.getMaxSph()));
		params.add(Utility.getName(goodsInfoPo.getMaxCyl()));
		if (!"".equals(Utility.getName(goodsInfoPo.getBgiwarehouseid()))){
			params.add(Utility.getName(goodsInfoPo.getMaxSph()));
			params.add(Utility.getName(goodsInfoPo.getMaxCyl()));
		}

		params.add(Utility.getName(goodsInfoPo.getMaxSph()));
		params.add(Utility.getName(goodsInfoPo.getMaxCyl()));
		if (!"".equals(Utility.getName(goodsInfoPo.getBgiwarehouseid()))){
			params.add(Utility.getName(goodsInfoPo.getBgiwarehouseid()));
			params.add(Utility.getName(goodsInfoPo.getBgiwarehouseid()));
		}
		params.add(Utility.getName(goodsInfoPo.getBgigoodscategoryid()));
		params.add(Utility.getName(goodsInfoPo.getBgisupplierid()));
		params.add(Utility.getName(goodsInfoPo.getBgibrandid()));
		params.add(Utility.getName(goodsInfoPo.getMaxSph()));
		params.add(Utility.getName(goodsInfoPo.getMinSph()));
		params.add(Utility.getName(goodsInfoPo.getMaxCyl()));
		params.add(Utility.getName(goodsInfoPo.getMinCyl()));

		return queryForObjectList(buffer.toString(),params.toArray(),GoodsInfoPo.class);
	}
	
	
	
	/**
	 * 获取采购订单是否收货
	 */
	public int selectProcurementIsReceipt(String billid) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(*) from C_ST_Inventory ");
		sb.append("where C_ST_I_BillID = ? and C_ST_I_AuditState = '1' ");
		
		List<String> params = new ArrayList<String>();
		params.add(billid);
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	public int getProcurementReceiptIsCustomizeCount(InventoryPo po) {
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT COUNT(B_GI_GOODSID) ");
		sb.append("FROM   C_ST_Inventory ");
		sb.append("       INNER JOIN C_ST_InventoryEntry ");
		sb.append("         ON C_ST_I_BillID = C_ST_IE_BillID ");
		sb.append("       INNER JOIN B_GOODSINFO ");
		sb.append("         ON B_GI_GOODSID = C_ST_IE_GoodsId ");
		sb.append("WHERE  C_ST_I_BillID = ? ");
		sb.append("       AND B_GI_isCustomize = 'D' ");
		params.add(Utility.getName(po.getCstibillid()));
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	public void updateGoodsLastInStorageDate(String goodsID){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update B_GoodsInfo set B_GI_LastInStorageDate = getdate() where B_GI_GoodsID = ? ");
		
		params.add(goodsID);

		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 根据公司和制造商查询绑定的供应商
	 */
	public String getSupplierByModeAndCompany(String companyID,String modeID){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" if (select top 1 count(J_CS_SupplierAgentID) from J_Company_Supplier where J_CS_CompanyID = ? and J_CS_SupplierID = ?) > 0 ");
		sb.append(" begin ");		
		sb.append("   select top 1 isnull(J_CS_SupplierAgentID,'') from J_Company_Supplier where J_CS_CompanyID = ? and J_CS_SupplierID = ? ");
		sb.append(" end ");
		sb.append(" else ");
		sb.append(" begin ");		
		sb.append("   select '' ");
		sb.append(" end ");
		
		params.add(Utility.getName(companyID));
		params.add(Utility.getName(modeID));
		params.add(Utility.getName(companyID));
		params.add(Utility.getName(modeID));
		
		return (String)getJdbcTemplate().queryForObject(sb.toString(), params.toArray(),String.class);
	}
	
	
}
