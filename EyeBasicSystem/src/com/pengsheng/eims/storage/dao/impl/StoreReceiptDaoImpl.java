package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.storage.dao.ProcurementReceiptDao;
import com.pengsheng.eims.storage.dao.StoreReceiptDao;
import com.pengsheng.eims.storage.persistence.DeliveryDetailPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.eims.storage.persistence.VerificationPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * 客户批发收货dao实现类
 */
public class StoreReceiptDaoImpl extends BaseJdbcDaoSupport implements StoreReceiptDao {
	/**
	 * 获取客户批发收货的数量
	 * 
	 * @param po
	 *            InventoryPo
	 * @return int 数量
	 */
	public int getStoreReceiptCount(InventoryPo po) {
		StringBuffer sb = new StringBuffer();

		sb.append("select count(distinct C_ST_StoreTakeGoods.C_ST_SG_BillID) from C_ST_StoreTakeGoods ");
		//如果没有需要查询商品的条件，就不关联单据明细表和商品资料表  By moyongsheng 2014-12-11
		if (!"".equals(Utility.getName(po.getCstisupplierid()))||!"".equals(Utility.getName(po.getCstigoodsname()))||!"".equals(Utility.getName(po.getCstigoodsid()))) {
			sb.append("inner join C_ST_StoreTakeGoodsEntry on C_ST_SG_BillID=C_ST_SGE_BillID inner join B_GoodsInfo on C_ST_SGE_GoodsId=B_GI_GoodsID ");	
		}
		
		sb.append("inner join B_Warehouse on C_ST_StoreTakeGoods.C_ST_SG_InStockId=B_Warehouse.B_WH_ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_StoreTakeGoods.C_ST_SG_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_StoreTakeGoods.C_ST_SG_AuditPerson=b.ID where C_ST_StoreTakeGoods.C_ST_SG_BillTypeId='1' ");
		
		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			sb.append("and C_ST_StoreTakeGoods.C_ST_SG_BillID like '%' + ? + '%' ");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			sb.append("and C_ST_StoreTakeGoods.C_ST_SG_SourceBillId like '%' + ? + '%' ");
			params.add(po.getCstisourcebillid());
		}
		if (!"".equals(Utility.getName(po.getCstibilltypeid()))) {
			sb.append("and C_ST_StoreTakeGoods.C_ST_SG_BillTypeId=? ");
			params.add(po.getCstibilltypeid());
		}
		if (!"".equals(Utility.getName(po.getCstiinstockid()))) {
			sb.append("and C_ST_StoreTakeGoods.C_ST_SG_InStockId=? ");
			params.add(po.getCstiinstockid());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstate()))) {
			sb.append("and C_ST_StoreTakeGoods.C_ST_SG_AuditState=? ");
			params.add(po.getCstiauditstate());
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_StoreTakeGoods.C_ST_SG_billDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_StoreTakeGoods.C_ST_SG_billDate, 23) <= ? ");
			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());
		} else if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& "".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_StoreTakeGoods.C_ST_SG_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());
		} else if ("".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_StoreTakeGoods.C_ST_SG_billDate, 23) <= ? ");
			params.add(po.getCstiendTime());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_StoreTakeGoods.C_ST_SG_AuditDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_StoreTakeGoods.C_ST_SG_AuditDate, 23) <= ? ");
			params.add(po.getCstiauditstartdate());
			params.add(po.getCstiauditenddate());
		} else if (!"".equals(Utility.getName(po.getCstiauditstartdate()))
				&& "".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_StoreTakeGoods.C_ST_SG_AuditDate, 23) >= ? ");
			params.add(po.getCstiauditstartdate());
		} else if ("".equals(Utility.getName(po.getCstiauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_StoreTakeGoods.C_ST_SG_AuditDate, 23) <= ? ");
			params.add(po.getCstiauditenddate());
		}
		if (!"".equals(Utility.getName(po.getCsticreateperson()))) {
			sb.append("and C_ST_StoreTakeGoods.C_ST_SG_createPerson=? ");
			params.add(po.getCsticreateperson());
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb.append("and C_ST_StoreTakeGoods.C_ST_SG_AuditPerson=? ");
			params.add(po.getCstiauditperson());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
			sb.append("and B_GI_SupplierID = ? ");
			params.add(po.getCstisupplierid());
		}
		if(!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsname()));
		}
		if(!"".equals(Utility.getName(po.getCstigoodscategory()))){
			sb.append("and C_ST_SG_GoodsCategory = ? ");
			params.add(Utility.getName(po.getCstigoodscategory()));
		}
		if(!"".equals(Utility.getName(po.getCstiremark()))){
			sb.append("and C_ST_SG_Remark like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstiremark()));
		}
		if(!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("and C_ST_SGE_GoodsId like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsid()));
		}
		if(!"".equals(Utility.getName(po.getDeliveryID()))){
			sb.append("and C_ST_SG_DeliveryID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getDeliveryID()));
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 获取客户批发收货的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @param start
	 * @param size
	 * @return list InventoryPo的list
	 */
	public List<InventoryPo> getStoreReceiptList(InventoryPo po,
			int start, int size) {

		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from (select ROW_NUMBER() Over(order by temp.cstibilldate desc) as rowNum,temp.cstibillid as cstibillid,temp.cstisourcebillid as cstisourcebillid,temp.cstibilltypeid as cstibilltypeid,");
		sb.append("temp.cstifinanceauditstate as cstifinanceauditstate,temp.deliveryID as deliveryID,temp.cstibilldate as cstibilldate,temp.cstiauditdate as cstiauditdate,temp.cstiinstockname as cstiinstockname,temp.cstigoodscategory as cstigoodscategory,");
		sb.append("temp.cstiauditstate as cstiauditstate,temp.csticreatepersonname as csticreatepersonname,temp.cstiauditpersonname as cstiauditpersonname,temp.cstiremark as cstiremark,temp.cstigoodscategoryname as cstigoodscategoryname ");
		sb.append("from(select distinct C_ST_SG_DeliveryID as deliveryID,C_ST_StoreTakeGoods.C_ST_SG_BillID as cstibillid,C_ST_StoreTakeGoods.C_ST_SG_GoodsCategory as cstigoodscategory,C_ST_StoreTakeGoods.C_ST_SG_SourceBillId as cstisourcebillid,C_ST_StoreTakeGoods.C_ST_SG_BillTypeId as cstibilltypeid,");
		sb.append("C_ST_StoreTakeGoods.C_ST_SG_billDate as cstibilldate,C_ST_StoreTakeGoods.C_ST_SG_AuditDate as cstiauditdate,B_Warehouse.B_WH_warehouseName as cstiinstockname,C_ST_SG_Remark as cstiremark,B_GC_GoodsCategoryName as cstigoodscategoryname,");
		sb.append("C_ST_StoreTakeGoods.C_ST_SG_AuditState as cstiauditstate,a.personName as csticreatepersonname,b.personName as cstiauditpersonname, ");
		sb.append("C_ST_SG_FinanceAuditState as cstifinanceauditstate ");
		sb.append("from C_ST_StoreTakeGoods ");

		//如果没有需要查询商品的条件，就不关联单据明细表和商品资料表  By moyongsheng 2014-12-11
		if (!"".equals(Utility.getName(po.getCstisupplierid()))||!"".equals(Utility.getName(po.getCstigoodsname()))||!"".equals(Utility.getName(po.getCstigoodsid()))) {
			sb.append("inner join C_ST_StoreTakeGoodsEntry on C_ST_SG_BillID=C_ST_SGE_BillID inner join B_GoodsInfo on C_ST_SGE_GoodsId=B_GI_GoodsID ");	
		}
		
		sb.append("inner join B_Warehouse on C_ST_StoreTakeGoods.C_ST_SG_InStockId=B_Warehouse.B_WH_ID ");
		sb.append("left join B_GoodsCategory on B_GC_ID = C_ST_SG_GoodsCategory ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_StoreTakeGoods.C_ST_SG_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_StoreTakeGoods.C_ST_SG_AuditPerson=b.ID where C_ST_StoreTakeGoods.C_ST_SG_BillTypeId='1' ");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			sb.append("and C_ST_StoreTakeGoods.C_ST_SG_BillID like '%' + ? + '%' ");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			sb.append("and C_ST_StoreTakeGoods.C_ST_SG_SourceBillId like '%' + ? + '%' ");
			params.add(po.getCstisourcebillid());
		}
		if (!"".equals(Utility.getName(po.getCstibilltypeid()))) {
			sb.append("and C_ST_StoreTakeGoods.C_ST_SG_BillTypeId=? ");
			params.add(po.getCstibilltypeid());
		}
		if (!"".equals(Utility.getName(po.getCstiinstockid()))) {
			sb.append("and C_ST_StoreTakeGoods.C_ST_SG_InStockId=? ");
			params.add(po.getCstiinstockid());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstate()))) {
			sb.append("and C_ST_StoreTakeGoods.C_ST_SG_AuditState=? ");
			params.add(po.getCstiauditstate());
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_StoreTakeGoods.C_ST_SG_billDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_StoreTakeGoods.C_ST_SG_billDate, 23) <= ? ");
			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());
		} else if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& "".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_StoreTakeGoods.C_ST_SG_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());
		} else if ("".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_StoreTakeGoods.C_ST_SG_billDate, 23) <= ? ");
			params.add(po.getCstiendTime());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_StoreTakeGoods.C_ST_SG_AuditDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_StoreTakeGoods.C_ST_SG_AuditDate, 23) <= ? ");
			params.add(po.getCstiauditstartdate());
			params.add(po.getCstiauditenddate());
		} else if (!"".equals(Utility.getName(po.getCstiauditstartdate()))
				&& "".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_StoreTakeGoods.C_ST_SG_AuditDate, 23) >= ? ");
			params.add(po.getCstiauditstartdate());
		} else if ("".equals(Utility.getName(po.getCstiauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_StoreTakeGoods.C_ST_SG_AuditDate, 23) <= ? ");
			params.add(po.getCstiauditenddate());
		}
		if (!"".equals(Utility.getName(po.getCsticreateperson()))) {
			sb.append("and C_ST_StoreTakeGoods.C_ST_SG_createPerson=? ");
			params.add(po.getCsticreateperson());
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb.append("and C_ST_StoreTakeGoods.C_ST_SG_AuditPerson=? ");
			params.add(po.getCstiauditperson());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
			sb.append("and B_GI_SupplierID = ? ");
			params.add(po.getCstisupplierid());
		}
		if(!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsname()));
		}
		if(!"".equals(Utility.getName(po.getCstigoodscategory()))){
			sb.append("and C_ST_SG_GoodsCategory = ? ");
			params.add(Utility.getName(po.getCstigoodscategory()));
		}
		if(!"".equals(Utility.getName(po.getCstiremark()))){
			sb.append("and C_ST_SG_Remark like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstiremark()));
		}
		if(!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("and C_ST_SGE_GoodsId like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsid()));
		}
		if(!"".equals(Utility.getName(po.getDeliveryID()))){
			sb.append("and C_ST_SG_DeliveryID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getDeliveryID()));
		}
		
		sb.append(" )temp ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(),
				InventoryPo.class);
	}

	/**
	 * 新增客户批发收货主表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void insertStoreReceipt(InventoryPo po) {
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		sb1.append("insert into C_ST_StoreTakeGoods(C_ST_SG_GoodsCategory,C_ST_SG_BillID,C_ST_SG_BillTypeId,C_ST_SG_billDate, ");
		sb1.append("C_ST_SG_SupplierId,C_ST_SG_InStockId, ");
		sb1.append("C_ST_SG_DepartmentId,C_ST_SG_createPerson,C_ST_SG_AuditState,C_ST_SG_Remark, C_ST_SG_DeliveryID,C_ST_SG_InvoiceState");
		sb2.append("?,?,?,getdate(),?,?,?,?,?,?,?,0");

		List<String> params = new ArrayList<String>();

		params.add(po.getCstigoodscategory());
		params.add(po.getCstibillid());
		params.add(po.getCstibilltypeid());
		params.add(po.getCstisupplierid());
		params.add(po.getCstiinstockid());
		params.add(po.getCstidepartmentid());
		params.add(po.getCsticreateperson());
		params.add(po.getCstiauditstate());
		params.add(po.getCstiremark());
		params.add(Utility.getName(po.getDeliveryID()));

		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb1.append(",C_ST_SG_AuditPerson,C_ST_SG_AuditDate,C_ST_SG_FinanceAuditState,C_ST_SG_AllocationStatus");
			sb2.append(",?,getdate(),'0','1' ");
			params.add(po.getCstiauditperson());
		}
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			sb1.append(",C_ST_SG_SourceBillId");
			sb2.append(",?");
			params.add(po.getCstisourcebillid());
		}
		String sql = sb1.toString() + ")values(" + sb2.toString() + ")";
		getJdbcTemplate().update(sql, params.toArray());
	}

	/**
	 * 新增客户批发收货明细表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void insertStoreReceiptEntry(InventoryEntryPo po) {

		String sql = "insert into C_ST_StoreTakeGoodsEntry(C_ST_SGE_ID,C_ST_SGE_BillID,C_ST_SGE_GoodsId,C_ST_SGE_GoodsQuantity,"
			+ "C_ST_SGE_NotTaxRate,C_ST_SGE_TaxRate,C_ST_SGE_CostPrice,"
			+ "C_ST_SGE_InStockId,C_ST_SGE_BarCode,C_ST_SGE_WarehousingDate,C_ST_SGE_InvoiceState,C_ST_SGE_GuaranteePeriod,C_ST_SGE_Batch,C_ST_SGE_RegistrationNum) "
			+ "values(?,?,?,?,?,?,?,?,?,getdate(),0,?,?,?)";

		List<String> params = new ArrayList<String>();

		params.add(this.uuid.generate());
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
	 * 修改客户批发收货主表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void updateStoreReceipt(InventoryPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("update C_ST_StoreTakeGoods set C_ST_SG_InStockId=?,C_ST_SG_DeliveryID = ?,");
		sb.append("C_ST_SG_AuditState=?,C_ST_SG_Remark=? ");

		List<String> params = new ArrayList<String>();

		params.add(po.getCstiinstockid());
		params.add(po.getDeliveryID());
		params.add(po.getCstiauditstate());
		params.add(po.getCstiremark());

		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb
			.append(",C_ST_SG_AuditPerson=?,C_ST_SG_AuditDate=getdate(),C_ST_SG_FinanceAuditState='0',C_ST_SG_AllocationStatus='1' ");
			params.add(po.getCstiauditperson());
		}
		sb.append(" where C_ST_StoreTakeGoods.C_ST_SG_BillID=?");

		params.add(po.getCstibillid());

		getJdbcTemplate().update(sb.toString(), params.toArray());

	}

	/**
	 * 获取客户批发收货的po
	 * 
	 * @param po
	 *            InventoryPo
	 * @return po InventoryPo
	 */
	public InventoryPo getStoreReceipt(InventoryPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("select top 1  C_ST_SG_BillID as cstibillid,C_ST_SG_BillTypeId as cstibilltypeid,C_ST_SG_SourceBillId as cstisourcebillid,C_ST_SG_billDate as cstibilldate,C_ST_SG_InStockId as cstiinstockid,B_Warehouse.B_WH_warehouseName as cstiinstockname,");
		sb.append("C_ST_SG_GoodsCategory as cstigoodscategory,B_GC_GoodsCategoryName as cstigoodscategoryname,C_ST_SG_SupplierId as cstisupplierid,C_ST_SG_PurchseWayId as cstipurchsewayid,C_ST_SG_DayLimit as cstidaylimit,");
		sb.append("C_ST_SG_DepartmentId as cstidepartmentid,C_ST_SG_createPerson as csticreateperson,C_ST_SG_AuditPerson as cstiauditperson,a.personName as csticreatepersonname,b.personName as cstiauditpersonname,C_ST_SG_AuditState as cstiauditstate,");
		sb.append("C_ST_SG_AuditDate as cstiauditdate,C_ST_SG_FinanceAuditState as cstifinanceauditstate,C_ST_SG_Remark as cstiremark, C_ST_SG_DeliveryID as deliveryID from C_ST_StoreTakeGoods ");
		sb.append("inner join B_Warehouse on C_ST_StoreTakeGoods.C_ST_SG_InStockId=B_Warehouse.B_WH_ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_StoreTakeGoods.C_ST_SG_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_StoreTakeGoods.C_ST_SG_AuditPerson=b.ID ");
		sb.append("left join B_GoodsCategory on C_ST_SG_GoodsCategory = B_GC_ID ");
		sb.append("where C_ST_SG_BillID=? ");

		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());

		return (InventoryPo) queryForObject(sb.toString(), params.toArray(),
				InventoryPo.class);
	}

	/**
	 * 获取客户批发收货明细表的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @return list List<InventoryEntryPo>
	 */
	public List<InventoryEntryPo> getStoreReceiptEntryList(InventoryPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select UPPER(B_GoodsInfo.B_GI_GoodsID) as cstiegoodsid,UPPER(C_ST_StoreTakeGoodsEntry.C_ST_SGE_BarCode) as cstiebarcode,");
		
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
		sb.append("B_GoodsInfo.B_GI_Sph as cstiesph,B_GoodsInfo.B_GI_Cyl as cstiecyl,B_GoodsInfo.B_GI_Axis as cstieaxis,C_ST_SGE_GuaranteePeriod as cstieguaranteeperiod , C_ST_SGE_Batch as cstiebatch, ");
		sb.append("B_GoodsInfo.B_GI_Curvature1 as cstiecurvature1,B_GoodsInfo.B_GI_Dia as cstiedia,C_ST_StoreTakeGoodsEntry.C_ST_SGE_GoodsQuantity as cstiegoodsquantity, ");
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
		sb.append("C_ST_SGE_GuaranteePeriod as cstieguaranteeperiod,C_ST_SGE_Batch as cstiebatch,B_BD_Place as cstiesource,isnull(C_ST_SGE_RegistrationNum,'') as cstieregistrationnum from C_ST_StoreTakeGoodsEntry ");
		sb.append("left join B_GoodsInfo on C_ST_StoreTakeGoodsEntry.C_ST_SGE_GoodsId=B_GoodsInfo.B_GI_GoodsID ");
		sb.append("INNER JOIN B_Brand ON substring(B_GI_GoodsID,6,2) = B_BD_ID and substring(B_GI_GoodsID,3,2) = B_BD_SupplierID ");
		sb.append(" left join B_FrameMaterial on B_FrameMaterial.B_FM_ID = B_GoodsInfo.B_GI_FrameMaterialType ");
		sb.append("where C_ST_StoreTakeGoodsEntry.C_ST_SGE_BillID=? order by C_ST_StoreTakeGoodsEntry.C_ST_SGE_GoodsId ");

		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());

		return queryForObjectList(sb.toString(), params.toArray(),
				InventoryEntryPo.class);
	}

	/**
	 * 删除客户批发收货主表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void deleteStoreReceipt(InventoryPo po) {

		String sql = "delete from C_ST_StoreTakeGoods where C_ST_SG_BillID=? ";

		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());

		getJdbcTemplate().update(sql, params.toArray());
	}

	/**
	 * 删除客户批发收货明细表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void deleteStoreReceiptEntry(InventoryPo po) {

		String sql = "delete from C_ST_StoreTakeGoodsEntry where C_ST_SGE_BillID=? ";

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
		String sql = "update C_ST_StoreTakeGoods set C_ST_SG_DeliveryID=? where C_ST_SG_BillID=?";

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
	 * 新增客户批发收货单到状态表
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

	public String updateOrderStoreReceiptState(String id) {
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
	public List<GoodsInfoPo> getStoreOrdersList(ProcurementOrdersPo po) {

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
	public int selectStoreReceiptcount(InventoryPo po) {
		StringBuffer sb=new StringBuffer();

		sb.append("select count(C_SH_SL_GoodsBarCode) from C_SH_StorageLog ");
		sb.append("where C_SH_SL_ChangeID=?");
		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

	//更新客户批发收货标示
	public void updatestatusReceipt(InventoryPo po) {
		StringBuffer sb = new StringBuffer();
		sb.append("update C_ST_StoreTakeGoods set ");
		sb.append("C_ST_SG_AuditState=1");
		sb.append(" where C_ST_StoreTakeGoods.C_ST_SG_BillID=? ");
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
		sb.append("FROM   C_ST_StoreTakeGoodsEntry ");
		sb.append("       INNER JOIN B_GOODSINFO ");
		sb.append("         ON B_GI_GOODSID = C_ST_SGE_GoodsId ");
		sb.append("       INNER JOIN B_Brand ");
		sb.append("         ON B_BD_ID = B_GI_BrandID ");
		sb.append("            AND B_BD_SupplierID = B_GI_SupplierID ");
		sb.append("WHERE  C_ST_SGE_BillID = ?  and B_GI_isCustomize <> 'D' ");
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
	public int selectStoreIsReceipt(String billid) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(*) from C_ST_StoreTakeGoods ");
		sb.append("where C_ST_SG_BillID = ? and C_ST_SG_AuditState = '1' ");
		
		List<String> params = new ArrayList<String>();
		params.add(billid);
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	public int getStoreReceiptIsCustomizeCount(InventoryPo po) {
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT COUNT(B_GI_GOODSID) ");
		sb.append("FROM   C_ST_StoreTakeGoods ");
		sb.append("       INNER JOIN C_ST_StoreTakeGoodsEntry ");
		sb.append("         ON C_ST_SG_BillID = C_ST_SGE_BillID ");
		sb.append("       INNER JOIN B_GOODSINFO ");
		sb.append("         ON B_GI_GOODSID = C_ST_SGE_GoodsId ");
		sb.append("WHERE  C_ST_SG_BillID = ? ");
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
	 * 获取批发导入商品信息
	 */
	public GoodsInfoPo selectImportStorePo(String goodsid) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("Select  ");
		sb.append(" UPPER(B_GI_GoodsID) as bgigoodsid, ");
		sb.append(" UPPER(dbo.getbarcode3(B_GI_BarCodeFlag,B_GI_GoodsID,B_GI_GoodsBarCode,convert(varchar(10),getdate(),120))) as bgigoodsbarcode, ");
		sb.append("B_GI_ViewGoodsName as bgigoodsname, ");
		sb.append("B_GI_GoodsCategoryID as bgigoodscategoryid,  ");
		sb.append("B_GI_SupplierID as bgisupplierid,  ");
		sb.append("B_SP_SupplierName as bgisuppliername,  ");
		sb.append("B_GI_BrandID as bgibrandid,  ");
		sb.append("B_BD_brandName as bgibrandname,  ");
		sb.append("B_GI_CostPrice as bgicostprice,  ");
		sb.append("B_GI_RetailPrice as bgiretailprice,  ");
		sb.append("B_GI_TaxRate as bgitaxrate, ");
		sb.append("B_GI_NotTaxRate as bginottaxrate, ");
		sb.append("B_GI_Spec as bgispec, ");
		sb.append("B_GI_Color as bgicolor, ");
		sb.append("B_GI_Sph as bgisph, ");
		sb.append("B_GI_Cyl as bgicyl, ");
		sb.append("B_GI_Axis as bgiaxis, ");
		sb.append("B_GI_Curvature1 as bgicurvature1, ");
		sb.append("B_GI_Dia as bgidia, ");
		sb.append("B_GI_FrameMaterialType as bgiframematerialtype, ");
		sb.append("B_GI_FrameSize as bgiframesize, ");
		sb.append("B_GI_AccessoriesType as bgiaccessoriestype, ");
		sb.append("B_GI_BelowPlusLuminosity as bgibelowplusluminosity, ");
		sb.append("B_GI_Refractive as bgirefractive, ");
		sb.append("case "); 
		sb.append("when B_GI_isMutiLuminosity = 'M' then '多光' ");
		sb.append("when B_GI_isMutiLuminosity = '0' then '单光' ");
		sb.append("when B_GI_isMutiLuminosity = 'Q' then '其他' ");
		sb.append("when B_GI_isMutiLuminosity = 'K' then '抗疲劳' ");
		sb.append("when B_GI_isMutiLuminosity = 'J' then '渐进' ");
		sb.append("else '' ");
		sb.append("end as bgiismutiluminosity, ");
		sb.append("case "); 
		sb.append("when B_GI_EyeGlassMaterialType = '1' then '树脂' ");
		sb.append("when B_GI_EyeGlassMaterialType = '2' then '玻璃' ");
		sb.append("when B_GI_EyeGlassMaterialType = '3' then 'PC' ");
		sb.append("else '' ");
		sb.append("end as bgieyeglassmaterialtype, ");
		sb.append("B_GI_UseType as bgiusetype, ");
		sb.append("B_GI_StealthClass as bgistealthclass, ");
		sb.append("B_GI_Capacity as bgicapacity, ");
		sb.append("B_GI_CapacityEntry as bgicapacityentry, ");
		sb.append("B_GI_SupplierColor as bgisuppliercolor, ");
		sb.append("B_FM_Name as bgiframematerialtypename, ");
		sb.append("B_BD_Place as bgisource, ");
		sb.append("isnull(B_BD_RegistrationNum,'') as bgiregistrationnum ");
		sb.append("from B_GoodsInfo ");
		sb.append("inner join B_Supplier on B_GI_SupplierID = B_SP_ID ");
		sb.append("inner join B_Brand on B_GI_SupplierID = B_BD_SupplierID and B_GI_BrandID = B_BD_ID ");
		sb.append("left join B_FrameMaterial on B_FM_ID = B_GI_FrameMaterialType ");
		sb.append("where B_GI_GoodsID = ? ");
		
		params.add(goodsid);
		
		return (GoodsInfoPo) queryForObject(sb.toString(), params.toArray(), GoodsInfoPo.class);
	}
	
	/**
	 * 获取批发收货单中的类别与制造商
	 * 
	 * @param po
	 *            InventoryPo
	 * @return list List<InventoryEntryPo>
	 */
	public List<InventoryPo> getStoreCandS(InventoryPo po) {
		StringBuffer sb = new StringBuffer();

		sb.append("SELECT Substring(C_ST_SGE_GoodsId, 1, 1) AS cstigoodscategory, ");
		sb.append("       Substring(C_ST_SGE_GoodsId, 3, 2) AS cstisupplierid, ");
		sb.append("       C_ST_SGE_BillID 					AS cstibillid ");
		sb.append("FROM   C_ST_StoreTakeGoodsEntry ");
		sb.append("WHERE  C_ST_SGE_BillID = ? ");
		sb.append("GROUP  BY Substring(C_ST_SGE_GoodsId, 1, 1), ");
		sb.append("          Substring(C_ST_SGE_GoodsId, 3, 2), ");
		sb.append("          C_ST_SGE_BillID ");

		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());

		return queryForObjectList(sb.toString(), params.toArray(),
				InventoryPo.class);
	}
	
	/**
	 * 获取客户批发收货明细表中某类别某制造商的商品进行采购收货单生成
	 * 
	 * @param po
	 *            InventoryPo
	 * @return list List<InventoryEntryPo>
	 */
	public List<InventoryEntryPo> getStoreG(InventoryPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select 	UPPER(B_GoodsInfo.B_GI_GoodsID) 						as cstiegoodsid, ");
		sb.append("			UPPER(C_ST_SGE_BarCode) 								as cstiebarcode, ");
		
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
		
		sb.append("			B_GoodsInfo.B_GI_CostPrice 								as cstiecostprice, ");
		sb.append("			B_GoodsInfo.B_GI_NotTaxRate 							as cstienottaxrate, ");
		sb.append("			B_GoodsInfo.B_GI_TaxRate 								as cstietaxrate, ");
		sb.append("			B_GoodsInfo.B_GI_ViewGoodsName 							as cstiegoodsname, ");
		sb.append("			B_GoodsInfo.B_GI_Spec 									as cstiespec,");
		sb.append("			case ");
		sb.append("			when B_GI_GoodsCategoryID = '8' 	then isnull(B_GoodsInfo.B_GI_Color,'')+isnull(B_GoodsInfo.B_GI_Sph,'') ");
		sb.append("			when B_GI_GoodsCategoryID <> '8' then isnull(B_GoodsInfo.B_GI_Color,'') end as cstiecolor,");
		sb.append("			B_GoodsInfo.B_GI_Sph as cstiesph, ");
		sb.append("			B_GoodsInfo.B_GI_Cyl as cstiecyl,B_GoodsInfo.B_GI_Axis as cstieaxis,C_ST_SGE_GuaranteePeriod as cstieguaranteeperiod , C_ST_SGE_Batch as cstiebatch, ");
		sb.append("B_GoodsInfo.B_GI_Curvature1 		as cstiecurvature1,B_GoodsInfo.B_GI_Dia as cstiedia,C_ST_StoreTakeGoodsEntry.C_ST_SGE_GoodsQuantity as cstiegoodsquantity, ");
		sb.append("B_GI_FrameMaterialType    		AS bgiframematerialtype , ");
		sb.append("B_GI_FrameSize     				AS bgiframesize , ");
		sb.append("B_GI_AccessoriesType     		AS bgiaccessoriestype , ");
		sb.append("B_GI_Capacity     				AS bgicapacity , ");
		sb.append("B_GI_CapacityEntry     			AS bgicapacityentry , ");
		sb.append("B_GI_SupplierColor     			AS bgisuppliercolor , ");	
		sb.append("B_GI_BelowPlusLuminosity     	AS bgibelowplusluminosity , ");
		sb.append("B_GI_Refractive     				AS bgirefractive , ");
		sb.append("B_GI_isMutiLuminosity     		AS bgiismutiluminosity , ");
		sb.append("B_GI_EyeGlassMaterialType     	AS bgieyeglassmaterialtype , ");
		sb.append("B_GI_UseType     				AS bgiusetype , ");
		sb.append("B_GI_StealthClass     			AS bgistealthclass, ");
		sb.append("C_ST_SGE_GuaranteePeriod 		as cstieguaranteeperiod, ");
		sb.append("C_ST_SGE_Batch 					as cstiebatch, ");
		sb.append("C_ST_SGE_InStockId 				as cstieinstockid, ");
		sb.append("C_ST_SGE_BarCode 				as cstiepcbarcode, ");
		sb.append("C_ST_SGE_ID 						as cstieid, ");
		sb.append("isnull(C_ST_SGE_RegistrationNum,'') as cstieregistrationnum "); 
		sb.append("from C_ST_StoreTakeGoodsEntry ");
		sb.append("left join B_GoodsInfo on C_ST_SGE_GoodsId = B_GI_GoodsID ");
		sb.append("where C_ST_StoreTakeGoodsEntry.C_ST_SGE_BillID = ? ");
		sb.append("  and B_GI_GoodsCategoryID = ? ");
		sb.append("  and substring(B_GI_GoodsID,3,2) = ? ");
		sb.append("order by C_ST_StoreTakeGoodsEntry.C_ST_SGE_GoodsId ");

		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());
		params.add(po.getCstigoodscategory());
		params.add(po.getCstisupplierid());
		
		return queryForObjectList(sb.toString(), params.toArray(),InventoryEntryPo.class);
	}
	
	/**
	 * 财务结算详细
	 * @param po
	 * @return
	 */
	public InventoryPo getStoreFinancialSettlement(InventoryPo po) {
		StringBuffer sb=new StringBuffer();	
		
		sb.append("select top 1  C_ST_SG_BillID as cstibillid,");	//单据编号
		sb.append("C_ST_SG_SourceBillId as cstisourcebillid,");	//订单号 
		sb.append("C_ST_SG_billDate as cstibilldate,C_ST_SG_DeliveryID as deliveryID,");	
		sb.append("C_ST_SG_SupplierId as cstisupplierid,");	//所属制造商编号
		sb.append("B_Supplier.B_SP_SupplierName as cstisuppliername,");	//所属制造商名称
		sb.append("C_ST_SG_BillTypeId as cstibilltypeid,");	//入库类型
		sb.append("C_ST_SG_InStockId as cstiinstockid,");	//入库仓位编号
		sb.append("B_Warehouse.B_WH_warehouseName as cstiinstockname,");	//入库仓位名称
		sb.append("a.personName as csticreatepersonname,");	//制单人名称
		sb.append("b.personName as cstiauditpersonname,");	//入库审核人名称
		sb.append("C_ST_SG_AuditDate as cstiauditdate,");	//入库审核日期
		sb.append("C_ST_SG_FinanceAuditPerson as cstifinanceauditperson,");	//财务结算审核人
		sb.append("C_ST_SG_FinanceAuditState as cstifinanceauditstate,");	//财务结算审核状态
		sb.append("C_ST_SG_FinanceAuditDate as cstifinanceauditdate,");	//财务结算审核日期
		sb.append("C_ST_SG_Remark as cstiremark ");	//备注
		
		sb.append("from C_ST_StoreTakeGoods ");
		
		sb.append("left join B_Supplier on C_ST_SG_SupplierId=B_SP_ID ");	//内联制造商表
		sb.append("inner join B_Warehouse on C_ST_SG_InStockId=B_Warehouse.B_WH_ID ");	//左外联仓位表
		
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_SG_createPerson=a.ID ");//左外人员表,制单人
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_SG_AuditPerson=b.ID ");	//左外人员表,审核人
		
		sb.append("where C_ST_SG_BillID = '"+po.getCstibillid()+"'");
	
		return (InventoryPo)queryForObject(sb.toString(), null, InventoryPo.class);
	}
	
	/**
	 * 遍历财务结算信息
	 * @param po
	 * @return
	 */
	public List<InventoryEntryPo> getStoreFinancialSettlementEntryList(InventoryPo po) {
		StringBuffer sb=new StringBuffer();	
		sb.append("select C_ST_SGE_ID 			as cstieid,");		//UUID主键
		sb.append("C_ST_SGE_GoodsId 			as cstiegoodsid,");	//商品代码
		sb.append("B_GoodsInfo.B_GI_ViewGoodsName as cstiegoodsname,");	//商品名称
		sb.append("C_ST_SGE_GoodsQuantity 		as cstiegoodsquantity,");	//商品数量
		sb.append("B_GoodsInfo.B_GI_Spec 		as cstiespec,");	//商品规格			
		sb.append("C_ST_SGE_NotTaxRate 			as cstienottaxrate,");	//单位成本(不含税)
		sb.append("B_GoodsInfo.B_GI_RetailPrice as bgcretailPrice,");//零售价
		sb.append("C_ST_SGE_NotTaxRateAmount 	as cstienottaxrateamount,");	//成本合计(不含税)
		sb.append("C_ST_SGE_TaxRate 			as cstietaxrate,");	//税率
		sb.append("C_ST_SGE_CostPrice 			as cstiecostprice,");	//含税单价
		sb.append("C_ST_SGE_CostPriceAmount 	as cstiecostpriceamount,");	//价税合计
		sb.append("C_ST_SGE_TaxAmount 			as cstietaxamount,");	//税额合计		
		sb.append("C_ST_SGE_InStockId 			as cstieinstockid,");	//收入仓位	
		sb.append("C_ST_SGE_BarCode 			as cstiebarcode, ");	//商品条码
		sb.append("C_ST_SGE_GuaranteePeriod 	as cstieguaranteeperiod, ");
		sb.append("C_ST_SGE_Batch 				as cstiebatch ");
		sb.append("from C_ST_StoreTakeGoodsEntry ");
		sb.append("inner join B_GoodsInfo on C_ST_StoreTakeGoodsEntry.C_ST_SGE_GoodsId=B_GoodsInfo.B_GI_GoodsID ");	//左外商品信息表
		
		sb.append("where C_ST_SGE_BillID='"+po.getCstibillid()+"'");		//根据单据编号查询	
		
		return queryForObjectList(sb.toString(), null, InventoryEntryPo.class);
	}
	
	/**
	 * 修改财务结算
	 * @param po
	 */
	public void updateStoreFinancialSettlement(InventoryPo po) {
		StringBuffer sb=new StringBuffer();
		sb.append("update C_ST_StoreTakeGoods set ");
		
		sb.append("C_ST_SG_FinanceAuditPerson='"+po.getCstifinanceauditperson()+"',");
		sb.append("C_ST_SG_FinanceAuditState='"+po.getCstifinanceauditstate()+"',");
		sb.append("C_ST_SG_FinanceAuditDate=getdate() ");
		
		sb.append(" where C_ST_SG_BillID='"+po.getCstibillid()+"' ");
		getJdbcTemplate().update(sb.toString());
	}
	
	/**
	 * 根据业务明细查询商品代码
	 */
	public GoodsInfoPo getStoreGoodsInfoByInventoryEntry(InventoryEntryPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select top 1 isnull(B_GI_RetailPrice,0) as bgiretailprice from B_GoodsInfo where B_GI_GoodsID in (select top 1 C_ST_SGE_GoodsId from C_ST_StoreTakeGoodsEntry where C_ST_SGE_ID=? ) ");
	
		params.add(Utility.getName(epo.getCstieid()));
		
		return (GoodsInfoPo) queryForObject(buffer.toString(), params.toArray(), GoodsInfoPo.class);
	}
	
	/**
	 * 修改业务单明细表信息
	 * @param po
	 */
	public void updateStoreFinancialSettlementEntry(InventoryEntryPo po) {
		
		StringBuffer sb=new StringBuffer();
		sb.append("update C_ST_StoreTakeGoodsEntry set ");
		
		sb.append("C_ST_SGE_NotTaxRate='"+po.getCstienottaxrate()+"',");		
		sb.append("C_ST_SGE_NotTaxRateAmount='"+po.getCstienottaxrateamount()+"',");
		sb.append("C_ST_SGE_CostPrice='"+po.getCstiecostprice()+"',");
		sb.append("C_ST_SGE_CostPriceAmount='"+po.getCstiecostpriceamount()+"',");
		sb.append("C_ST_SGE_TaxRate='"+po.getCstietaxrate()+"',");
		if (!"".equals(Utility.getName(po.getBgcretailPrice()))){
			sb.append("C_ST_SGE_RetailPrice='"+po.getBgcretailPrice()+"',");
		}
		sb.append("C_ST_SGE_TaxAmount='"+po.getCstietaxamount()+"'");
		
		sb.append(" where C_ST_SGE_ID='"+po.getCstieid()+"'");
		getJdbcTemplate().update(sb.toString());
	}
	
	/**
	 * 新增业务单据往来明细
	 */
	public void insertStoreSupplierDealingEntry(InventoryPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO L_SC_SupplierAccount(L_SC_SA_ID,L_SC_SA_BillID,L_SC_SA_BillType,L_SC_SA_Date,L_SC_SA_SupplierID ");
		buffer.append("           ,L_SC_SA_SupplierShortName,L_SC_SA_SupplierName,L_SC_SA_NotTaxRateAmount,L_SC_SA_CostPriceAmount,L_SC_SA_DeliveryID) ");
		buffer.append("select newid(),C_ST_SGE_BillID,(case C_ST_SG_BillTypeId when '2' then '采购退货单' when '9' then '委外收货单' else '采购收货单' end), ");
		buffer.append("       C_ST_SG_FinanceAuditDate,C_ST_SG_SupplierId, ");
		buffer.append("       B_SP_SupplierName,B_SP_ForShort,(case C_ST_SG_BillTypeId when '2' then -sum(C_ST_SGE_NotTaxRateAmount) else sum(C_ST_SGE_NotTaxRateAmount) end) ,(case C_ST_SG_BillTypeId when '2' then -sum(C_ST_SGE_CostPriceAmount) else sum(C_ST_SGE_CostPriceAmount) end),isnull(C_ST_SG_DeliveryID,'') ");
		buffer.append("  from C_ST_StoreTakeGoodsEntry inner join C_ST_StoreTakeGoods on C_ST_SGE_BillID=C_ST_SG_BillID ");
		buffer.append("       left join B_Supplier on C_ST_SG_SupplierId=B_SP_ID ");
		buffer.append("  where C_ST_SGE_BillID=? and C_ST_SG_AuditState='1' and C_ST_SG_FinanceAuditState='1' and C_ST_SG_BillTypeId in ('1','2','9') ");
		buffer.append("  group by C_ST_SGE_BillID,C_ST_SG_BillTypeId,C_ST_SG_FinanceAuditDate,C_ST_SG_SupplierId,B_SP_SupplierName,B_SP_ForShort,isnull(C_ST_SG_DeliveryID,'') ");
		
		params.add(Utility.getName(po.getCstibillid()));
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}
	
	/**
	 * 根据单据编号查询商品成本
	 */
	public List<InventoryEntryPo> getStoreStorageCostEntryByBillID(InventoryPo po){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select C_ST_IE_BillID as cstiebillid,C_ST_IE_NotTaxRate as cstienottaxrate,C_ST_IE_CostPrice as cstiecostprice,C_ST_IE_BarCode as cstiebarcode from C_ST_InventoryEntry ");
		buffer.append("inner join C_ST_Inventory on C_ST_I_BillID = C_ST_IE_BillID ");
		buffer.append("where C_ST_I_StoreReceiptID = ? ");
		
		params.add(Utility.getName(po.getCstibillid()));
		
		return queryForObjectList(buffer.toString(), params.toArray(),InventoryEntryPo.class);
	}
	
	/**
	 * 更新库存表的结算成本
	 */
	public void updateStoreStorageCostEntry(InventoryEntryPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update C_SH_StorageLog set C_SH_SL_NotTaxRate = ?,C_SH_SL_CostPrice = ? where C_SH_SL_ChangeID = ? and C_SH_SL_GoodsBarCode = ? ");
				
		params.add(Utility.getName(epo.getCstienottaxrate()));
		params.add(Utility.getName(epo.getCstiecostprice()));
		params.add(Utility.getName(epo.getCstiebillid()));
		params.add(Utility.getName(epo.getCstiebarcode()));

		
		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}
}
