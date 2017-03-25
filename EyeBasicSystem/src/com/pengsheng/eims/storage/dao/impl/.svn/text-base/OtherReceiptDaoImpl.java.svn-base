package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.storage.dao.OtherReceiptDao;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersEntryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.eims.storage.persistence.VerificationPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class OtherReceiptDaoImpl extends BaseJdbcDaoSupport implements OtherReceiptDao {

	/**
	 * 查询其它入库管理数量
	 * @param po
	 * @return
	 */
	public int getOtherReceiptCount(InventoryPo po) {
		
		StringBuffer sb=new StringBuffer();
		List<String> params =new ArrayList<String>();
		sb.append("select count(distinct C_ST_Inventory.C_ST_I_BillID) from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID inner join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID ");
		sb.append("inner join B_Warehouse on C_ST_Inventory.C_ST_I_InStockId=B_Warehouse.B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID where C_ST_Inventory.C_ST_I_BillTypeId='7'");
		
		if (!"".equals(Utility.getName(po.getCsticompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCsticompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getCstibillid()))){
//			sb.append("and C_ST_Inventory.C_ST_I_BillID='"+po.getCstibillid()+"' ");
			sb.append("and C_ST_Inventory.C_ST_I_BillID like '%'+ ?+'%' ");//quyanping
			params.add(po.getCstibillid());
		}
		if(!"".equals(Utility.getName(po.getCstisourcebillid()))){
//			sb.append("and C_ST_Inventory.C_ST_I_SourceBillId='"+po.getCstisourcebillid()+"' ");
			sb.append("and C_ST_Inventory.C_ST_I_SourceBillId like '%'+ ?+'%' ");//quyanping
			params.add(po.getCstisourcebillid());
		}
		if(!"".equals(Utility.getName(po.getCstibilltypeid()))){
//			sb.append("and C_ST_Inventory.C_ST_I_BillTypeId='"+po.getCstibilltypeid()+"' ");
			sb.append("and C_ST_Inventory.C_ST_I_BillTypeId= ? ");
			params.add(po.getCstibilltypeid());
		}
		if(!"".equals(Utility.getName(po.getCstiinstockid()))){
//			sb.append("and C_ST_Inventory.C_ST_I_InStockId='"+po.getCstiinstockid()+"' ");
			sb.append("and C_ST_Inventory.C_ST_I_InStockId= ? ");
			params.add(po.getCstiinstockid());
		}
		if(!"".equals(Utility.getName(po.getCstiauditstate()))){
//			sb.append("and C_ST_Inventory.C_ST_I_AuditState='"+po.getCstiauditstate()+"' ");
			sb.append("and C_ST_Inventory.C_ST_I_AuditState= ? ");
			params.add(po.getCstiauditstate());
		}
		if(!"".equals(Utility.getName(po.getCstistartTime())) && !"".equals(Utility.getName(po.getCstiendTime()))){
//			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= '"+po.getCstistartTime()+"' ");
//			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= '"+po.getCstiendTime()+"' ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());
		}else if(!"".equals(Utility.getName(po.getCstistartTime())) && "".equals(Utility.getName(po.getCstiendTime()))){
//			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= '"+po.getCstistartTime()+"' ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());
		}else if("".equals(Utility.getName(po.getCstistartTime())) && !"".equals(Utility.getName(po.getCstiendTime()))){
//			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= '"+po.getCstiendTime()+"' ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <=  ? ");
			params.add(po.getCstiendTime());
		}
		
		if(!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsname()));
		}
		
		if(!"".equals(Utility.getName(po.getCsticreateperson()))){
			sb.append("and C_ST_I_createPerson = ? ");
			params.add(Utility.getName(po.getCsticreateperson()));
		}
		
		if(!"".equals(Utility.getName(po.getCstiauditperson()))){
			sb.append("and C_ST_I_AuditPerson = ? ");
			params.add(Utility.getName(po.getCstiauditperson()));
		}
		
//		return getJdbcTemplate().queryForInt(sb.toString());
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	/**
	 * 遍历其它入库管理信息并分页
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> getOtherReceiptList(InventoryPo po,
			int start, int size) {
		
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select * from ( select ROW_NUMBER() Over(order by temp.cstibilldate desc) as rowNum,temp.cstibillid as cstibillid,temp.cstisourcebillid as cstisourcebillid,temp.cstibilltypeid as cstibilltypeid,");
		sb.append("temp.cstibilldate as cstibilldate,temp.cstiauditdate as cstiauditdate,temp.cstiinstockname as cstiinstockname,");
		sb.append("temp.cstiauditstate as cstiauditstate,temp.csticreatepersonname as csticreatepersonname,temp.cstiauditpersonname as cstiauditpersonname ");
		sb.append("from(select distinct C_ST_Inventory.C_ST_I_BillID as cstibillid,C_ST_Inventory.C_ST_I_SourceBillId as cstisourcebillid,C_ST_Inventory.C_ST_I_BillTypeId as cstibilltypeid,");
		sb.append("C_ST_Inventory.C_ST_I_billDate as cstibilldate,C_ST_Inventory.C_ST_I_AuditDate as cstiauditdate,B_Warehouse.B_WH_warehouseName as cstiinstockname,");
		sb.append("C_ST_Inventory.C_ST_I_AuditState as cstiauditstate,a.personName as csticreatepersonname,b.personName as cstiauditpersonname from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID inner join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID ");
		sb.append("inner join B_Warehouse on C_ST_Inventory.C_ST_I_InStockId=B_Warehouse.B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID where C_ST_Inventory.C_ST_I_BillTypeId='7' ");
		
		if (!"".equals(Utility.getName(po.getCsticompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCsticompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getCstibillid()))){
//			sb.append("and C_ST_Inventory.C_ST_I_BillID='"+po.getCstibillid()+"' ");
			sb.append("and C_ST_Inventory.C_ST_I_BillID like '%'+ ?+'%' ");//quyanping
			params.add(po.getCstibillid());
		}
		if(!"".equals(Utility.getName(po.getCstisourcebillid()))){
//			sb.append("and C_ST_Inventory.C_ST_I_SourceBillId='"+po.getCstisourcebillid()+"' ");
			sb.append("and C_ST_Inventory.C_ST_I_SourceBillId like '%'+ ?+'%' ");//quyanping
			params.add(po.getCstisourcebillid());
		}
		if(!"".equals(Utility.getName(po.getCstibilltypeid()))){
//			sb.append("and C_ST_Inventory.C_ST_I_BillTypeId='"+po.getCstibilltypeid()+"' ");
			sb.append("and C_ST_Inventory.C_ST_I_BillTypeId= ? ");
			params.add(po.getCstibilltypeid());
		}
		if(!"".equals(Utility.getName(po.getCstiinstockid()))){
//			sb.append("and C_ST_Inventory.C_ST_I_InStockId='"+po.getCstiinstockid()+"' ");
			sb.append("and C_ST_Inventory.C_ST_I_InStockId=  ? ");
			params.add(po.getCstiinstockid());
		}
		if(!"".equals(Utility.getName(po.getCstiauditstate()))){
//			sb.append("and C_ST_Inventory.C_ST_I_AuditState='"+po.getCstiauditstate()+"' ");
			sb.append("and C_ST_Inventory.C_ST_I_AuditState= ? ");
			params.add(po.getCstiauditstate());
		}
		if(!"".equals(Utility.getName(po.getCstistartTime())) && !"".equals(Utility.getName(po.getCstiendTime()))){
//			sb.append("and conver(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= '"+po.getCstistartTime()+"' ");
//			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= '"+po.getCstiendTime()+"' ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >=  ? ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <=  ? ");
			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());
		}else if(!"".equals(Utility.getName(po.getCstistartTime())) && "".equals(Utility.getName(po.getCstiendTime()))){
//			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= '"+po.getCstistartTime()+"' ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= ?  ");
			params.add(po.getCstistartTime());
		}else if("".equals(Utility.getName(po.getCstistartTime())) && !"".equals(Utility.getName(po.getCstiendTime()))){
//			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= '"+po.getCstiendTime()+"' ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <=  ? ");
			params.add(po.getCstiendTime());

		}	
		if(!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstigoodsname()));
		}
		
		if(!"".equals(Utility.getName(po.getCsticreateperson()))){
			sb.append("and C_ST_I_createPerson = ? ");
			params.add(Utility.getName(po.getCsticreateperson()));
		}
		
		if(!"".equals(Utility.getName(po.getCstiauditperson()))){
			sb.append("and C_ST_I_AuditPerson = ? ");
			params.add(Utility.getName(po.getCstiauditperson()));
		}
		
		sb.append(" ) temp ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
//		return queryForObjectList(sb.toString(), null, InventoryPo.class);
		return queryForObjectList(sb.toString(), params.toArray(),
				InventoryPo.class);
	}
	/**
	 * 新增其他入库管理信息
	 * @param po
	 */
	public void insertOtherReceipt(InventoryPo po) {
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		List<String> params =new ArrayList<String>();
		sb1.append("insert into C_ST_Inventory(C_ST_I_BillID,C_ST_I_BillTypeId,C_ST_I_billDate,C_ST_I_GoodsCategory,");
		sb1.append("C_ST_I_SupplierId,C_ST_I_InStockId,");
		sb1.append("C_ST_I_DepartmentId,C_ST_I_createPerson,C_ST_I_AuditState,C_ST_I_Remark,");
		sb1.append("C_ST_I_InvoiceState ");
//		sb2.append("'"+po.getCstibillid()+"','"+po.getCstibilltypeid()+"','"+po.getCstibilldate()+"',");
//		sb2.append("'"+po.getCstisupplierid()+"','"+po.getCstiinstockid()+"','"+po.getCstidepartmentid()+"',");
//		sb2.append("'"+po.getCsticreateperson()+"','"+po.getCstiauditstate()+"','"+po.getCstiremark()+"'");
		sb2.append("?,?,getdate(),");
		params.add(po.getCstibillid());
		params.add(po.getCstibilltypeid());
		sb2.append("?,?,?,?,");
		params.add(po.getCstigoodscategory());
		params.add(po.getCstisupplierid());
		params.add(po.getCstiinstockid());
		params.add(po.getCstidepartmentid());
		sb2.append("?,?,?,'0' ");
		params.add(po.getCsticreateperson());
		params.add(po.getCstiauditstate());
		params.add(po.getCstiremark());
		if(!"".equals(Utility.getName(po.getCstiauditperson()))){
			sb1.append(",C_ST_I_AuditPerson,C_ST_I_AuditDate,C_ST_I_FinanceAuditState");
//			sb2.append(",'"+po.getCstiauditperson()+"',getdate(),'0'");
			sb2.append(",?,getdate(),'0'");
			params.add(po.getCstiauditperson());
		}
		if(!"".equals(Utility.getName(po.getCstisourcebillid()))){
			sb1.append(",C_ST_I_SourceBillId");
//			sb2.append(",'"+po.getCstisourcebillid()+"'");
			sb2.append(",?");
			params.add(po.getCstisourcebillid());
		}
		String sql=sb1.toString()+")values("+sb2.toString()+")";
//		getJdbcTemplate().update(sql);
		getJdbcTemplate().update(sql, params.toArray());
	}
	/**
	 * 新增其他入库管理明细表信息
	 * @param po
	 */
	public void insertOtherReceiptEntry(InventoryEntryPo po) {
		
//		String sql="insert into C_ST_InventoryEntry(C_ST_IE_ID,C_ST_IE_BillID,C_ST_IE_GoodsId,C_ST_IE_GoodsQuantity," +
//				"C_ST_IE_NotTaxRate,C_ST_IE_TaxRate,C_ST_IE_CostPrice," +
//				"C_ST_IE_InStockId,C_ST_IE_BarCode,C_ST_IE_WarehousingDate) " +
//				"values('"+this.uuid.generate()+"','"+po.getCstiebillid()+"','"+po.getCstiegoodsid()+"','"+po.getCstiegoodsquantity()+"'," +
//				"'"+po.getCstienottaxrate()+"','"+po.getCstietaxrate()+"','"+po.getCstiecostprice()+"'," +
//			    "'"+po.getCstieinstockid()+"','"+po.getCstiebarcode()+"',getdate())";
//		
//		getJdbcTemplate().update(sql);
		
		StringBuffer sb=new StringBuffer();
		sb.append("insert into C_ST_InventoryEntry");
		sb.append("(C_ST_IE_ID,C_ST_IE_BillID,C_ST_IE_GoodsId,C_ST_IE_GoodsQuantity,");
		sb.append("C_ST_IE_NotTaxRate,C_ST_IE_TaxRate,C_ST_IE_CostPrice,");
		sb.append("C_ST_IE_InStockId,C_ST_IE_BarCode,C_ST_IE_WarehousingDate,C_ST_IE_InvoiceState ");
		sb.append(")");
		sb.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,getdate(),'0' )");
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
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	/**
	 * 新增核销表
	 */
	public void insertVerification(VerificationPo po) {
		
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		List<String> params=new ArrayList<String>();
		sb1.append("insert into C_ST_Verification(C_ST_V_PinID,C_ST_V_GoodsId,C_ST_V_BarCode,C_ST_V_Num,C_ST_V_Datetime,C_ST_V_UUID");
//		sb2.append("'"+po.getCstvpinid()+"','"+po.getCstvgoodsid()+"','"+po.getCstvbarcode()+"','"+po.getCstvnum()+"',getdate()");
		sb2.append("?,?,?,?,getdate(),?");
		params.add(po.getCstvpinid());
		params.add(po.getCstvgoodsid());
		params.add(po.getCstvbarcode());
		params.add(po.getCstvnum());
		params.add(this.uuid.generate());
		
		if(!"".equals(Utility.getName(po.getCstvpoid()))){
			sb1.append(",C_ST_V_PoID");
//			sb2.append(",'"+po.getCstvpoid()+"'");
			sb2.append(",?");
			params.add(po.getCstvpoid());
		}
		String sql=sb1.toString()+")values("+sb2.toString()+")";
//		getJdbcTemplate().update(sql);
		getJdbcTemplate().update(sql, params.toArray());
	}
	/**
	 * 修改其他入库管理
	 * @param po
	 */
	public void updateOtherReceipt(InventoryPo po) {
		
		StringBuffer sb=new StringBuffer();
		List<String> params= new ArrayList<String>();
//		sb.append("update C_ST_Inventory set C_ST_I_InStockId='"+po.getCstiinstockid()+"',");
		sb.append("update C_ST_Inventory set C_ST_I_InStockId= ? ,");
		params.add(po.getCstiinstockid());
//		sb.append("C_ST_I_AuditState='"+po.getCstiauditstate()+"',C_ST_I_Remark='"+po.getCstiremark()+"' ");
		sb.append("C_ST_I_AuditState= ? ,C_ST_I_Remark= ?  ");
		params.add(po.getCstiauditstate());
		params.add(po.getCstiremark());
		if(!"".equals(Utility.getName(po.getCstiauditperson()))){
//			sb.append(",C_ST_I_AuditPerson='"+po.getCstiauditperson()+"',C_ST_I_AuditDate=getdate(),C_ST_I_FinanceAuditState='0'");
			sb.append(",C_ST_I_AuditPerson= ? ,C_ST_I_AuditDate=getdate(),C_ST_I_FinanceAuditState='0'");
			params.add(po.getCstiauditperson());
		}
//		sb.append(" where C_ST_Inventory.C_ST_I_BillID='"+po.getCstibillid()+"'");
		sb.append(" where C_ST_Inventory.C_ST_I_BillID= ? ");
		params.add(po.getCstibillid());
//		getJdbcTemplate().update(sb.toString());
		getJdbcTemplate().update(sb.toString(), params.toArray());
		
	}
	/**
	 * 查询其他入库管理
	 */
	public InventoryPo getOtherReceipt(InventoryPo po) {
		
		StringBuffer sb=new StringBuffer();	
		sb.append("select top 1  C_ST_I_BillID as cstibillid,C_ST_I_BillTypeId as cstibilltypeid,C_ST_I_SourceBillId as cstisourcebillid,C_ST_I_billDate as cstibilldate,C_ST_I_InStockId as cstiinstockid,B_Warehouse.B_WH_warehouseName as cstiinstockname,");
		sb.append("C_ST_I_GoodsCategory as cstigoodscategory,C_ST_I_SupplierId as cstisupplierid,B_Supplier.B_SP_SupplierName as cstisuppliername,C_ST_I_PurchseWayId as cstipurchsewayid,C_ST_I_DayLimit as cstidaylimit,");
		sb.append("C_ST_I_DepartmentId as cstidepartmentid,C_ST_I_createPerson as csticreateperson,C_ST_I_AuditPerson as cstiauditperson,a.personName as csticreatepersonname,b.personName as cstiauditpersonname,C_ST_I_AuditState as cstiauditstate,");
		sb.append("C_ST_I_AuditDate as cstiauditdate,C_ST_I_Remark as cstiremark from C_ST_Inventory ");
		sb.append("inner join B_Supplier on C_ST_Inventory.C_ST_I_SupplierId=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Warehouse on C_ST_Inventory.C_ST_I_InStockId=B_Warehouse.B_WH_ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID ");
//		sb.append("where C_ST_I_BillID='"+po.getCstibillid()+"'");
		List<String> params=new ArrayList<String>();
		sb.append("where C_ST_I_BillID= ? ");
		params.add(po.getCstibillid());
//		return (InventoryPo)queryForObject(sb.toString(), null, InventoryPo.class);
		return (InventoryPo) queryForObject(sb.toString(), params
				.toArray(), InventoryPo.class);
	}
	/**
	 * 查询其他入库管理详情
	 * @param po
	 * @return
	 */
	public List<InventoryEntryPo> getOtherReceiptEntryList(InventoryPo po) {
		
		StringBuffer sb=new StringBuffer();	
		sb.append("select B_GoodsInfo.B_GI_GoodsID as cstiegoodsid,C_ST_InventoryEntry.C_ST_IE_BarCode as cstiebarcode,");
		sb.append("B_GoodsInfo.B_GI_CostPrice as cstiecostprice,B_GoodsInfo.B_GI_NotTaxRate as cstienottaxrate,");
		sb.append("B_GoodsInfo.B_GI_TaxRate as cstietaxrate,B_GoodsInfo.B_GI_ViewGoodsName as cstiegoodsname,B_GoodsInfo.B_GI_Spec as cstiespec,");
		sb.append("B_GoodsInfo.B_GI_Color as cstiecolor,B_GoodsInfo.B_GI_Sph as cstiesph,B_GoodsInfo.B_GI_Cyl as cstiecyl,B_GoodsInfo.B_GI_Axis as cstieaxis,");
		sb.append("B_Unit.B_UT_unitName as cstieunitname,");
		sb.append("B_GoodsInfo.B_GI_Curvature1 as cstiecurvature1,B_GoodsInfo.B_GI_Dia as cstiedia,C_ST_InventoryEntry.C_ST_IE_GoodsQuantity as cstiegoodsquantity from C_ST_InventoryEntry ");
		sb.append("inner join B_GoodsInfo on C_ST_InventoryEntry.C_ST_IE_GoodsId=B_GoodsInfo.B_GI_GoodsID ");
		sb.append("left join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id ");
//		sb.append("where C_ST_InventoryEntry.C_ST_IE_BillID='"+po.getCstibillid()+"'");		
		sb.append("where C_ST_InventoryEntry.C_ST_IE_BillID=  ? ");		
		List<String> params =new ArrayList<String>();
		params.add(po.getCstibillid());
//		return queryForObjectList(sb.toString(), null, InventoryEntryPo.class);
		return queryForObjectList(sb.toString(), params.toArray(),
				InventoryEntryPo.class);
	}
	/**
	 * 删除其他入库管理
	 * @param po
	 */
	public void deleteOtherReceipt(InventoryPo po) {
		
//		String sql="delete from C_ST_Inventory where C_ST_I_BillID='"+po.getCstibillid()+"'";		
//		getJdbcTemplate().update(sql);	
		StringBuffer sb=new StringBuffer();
		sb.append("delete from C_ST_Inventory where C_ST_I_BillID= ? ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	/**
	 * 删除其他入库管理明细表
	 * @param po
	 */
	public void deleteOtherReceiptEntry(InventoryPo po) {
		
//		String sql="delete from C_ST_InventoryEntry where C_ST_IE_BillID='"+po.getCstibillid()+"'";		
//		getJdbcTemplate().update(sql);	
		StringBuffer sb=new StringBuffer();
		sb.append("delete from C_ST_InventoryEntry where C_ST_IE_BillID= ? ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	/**
	 * 删除核销表
	 * @param po
	 */
	public void deleteVerification(InventoryPo po) {
		
//		String sql="delete from C_ST_Verification where C_ST_V_PinID='"+po.getCstibillid()+"'";		
//		getJdbcTemplate().update(sql);	
		StringBuffer sb = new StringBuffer();
		sb.append("delete from C_ST_Verification where C_ST_V_PinID=  ? ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
}
