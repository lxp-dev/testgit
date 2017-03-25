package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.storage.dao.ProcurementWaitDao;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.eims.storage.persistence.VerificationPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ProcurementWaitDaoImpl extends BaseJdbcDaoSupport implements ProcurementWaitDao {

	/**
	 * 得到待收货信息总数
	 */
	public int getProcurementWaitCount(ProcurementOrdersPo procurementOrdersPo) {
		StringBuffer buffer=new StringBuffer();
		
		buffer.append("select count(distinct C_ST_P_ID) from C_ST_Po ");
		
		if(!"".equals(Utility.getName(procurementOrdersPo.getCstpgoodsname())) || !"".equals(Utility.getName(procurementOrdersPo.getCstpgoodsid()))){
			buffer.append("inner join C_ST_PoEntry on C_ST_P_ID=C_ST_PE_PurchaseOrderID ");
			buffer.append("inner join B_GoodsInfo on C_ST_PE_goodsID=B_GI_GoodsID ");
		}
		//buffer.append("inner join B_GoodsCategory on B_GC_ID = C_ST_P_GoodsCategory ");
		buffer.append("inner join B_Supplier on B_SP_ID = C_ST_P_SupplierId left join B_Departments on C_ST_P_DepartmentID = B_DP_DepartmentID ");
		
		buffer.append("left join (select ID,personName from SYS_PersonInfo) cr on C_ST_P_CreatePerson=cr.ID ");
		buffer.append("left join (select ID,personName from SYS_PersonInfo) au on C_ST_P_AuditPerson=au.ID ");		
		buffer.append("where 1 = 1 and C_ST_P_AuditState=1 and C_ST_P_flag='0' ");
		buffer.append("  and C_ST_P_ID not in(select C_ST_I_SourceBillId from dbo.C_ST_Inventory where C_ST_I_SourceBillId is not null) ");
		
		List<String> params=new ArrayList<String>();
		
		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(procurementOrdersPo.getCstpcompanyid()));	
		}
		
		//条件查询
		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpid()))) {
			buffer.append("and C_ST_P_ID like '%'+ ?+'%' ");//quyanping
			params.add(procurementOrdersPo.getCstpid());
		}
		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpgoodscategory()))) {
			buffer.append("and C_ST_P_GoodsCategory = ? ");
			params.add(procurementOrdersPo.getCstpgoodscategory());
		}
		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpsupplierid()))) {
			buffer.append("and C_ST_P_SupplierId = ? ");
			params.add(procurementOrdersPo.getCstpsupplierid());
		}

		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpstarttime()))
				&& !"".equals(Utility.getName(procurementOrdersPo
						.getCstpendtime()))) {
			buffer.append("and convert(varchar(10), C_ST_P_CreateDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), C_ST_P_CreateDate, 23) <= ? ");
			params.add(procurementOrdersPo.getCstpstarttime());
			params.add(procurementOrdersPo.getCstpendtime());
		} else if (!"".equals(Utility.getName(procurementOrdersPo
				.getCstpstarttime()))&& "".equals(Utility.getName(procurementOrdersPo.getCstpendtime()))) {
			buffer.append("and convert(varchar(10), C_ST_P_CreateDate, 23) >= ? ");
			params.add(procurementOrdersPo.getCstpstarttime());
		} else if ("".equals(Utility.getName(procurementOrdersPo
				.getCstpstarttime()))
				&& !"".equals(Utility.getName(procurementOrdersPo
						.getCstpendtime()))) {
			buffer.append("and convert(varchar(10), C_ST_P_CreateDate, 23) <= ? ");
			params.add(procurementOrdersPo.getCstpendtime());
		}
		if(!"".equals(Utility.getName(procurementOrdersPo.getCstpcreateperson()))){
			buffer.append("and C_ST_P_CreatePerson=? ");
			params.add(procurementOrdersPo.getCstpcreateperson());
		}
		if(!"".equals(Utility.getName(procurementOrdersPo.getCstpauditperson()))){
			buffer.append("and C_ST_P_AuditPerson=? ");
			params.add(procurementOrdersPo.getCstpauditperson());
		}
		if(!"".equals(Utility.getName(procurementOrdersPo.getCstpgoodsname()))){
			buffer.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(procurementOrdersPo.getCstpgoodsname()));
		}
		if(!"".equals(Utility.getName(procurementOrdersPo.getCstpgoodsid()))){
			buffer.append("and C_ST_PE_goodsID like '%' + ? + '%' ");
			params.add(Utility.getName(procurementOrdersPo.getCstpgoodsid()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	/**
	 * 得到待收货信息
	 */
	public List<ProcurementOrdersPo> getProcurementWaitList(ProcurementOrdersPo procurementOrdersPo,
			int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		

		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by CSTPBillDate desc) as rowNum,* from ( ");	
		
		buffer.append("select distinct C_ST_P_ID as CSTPID, C_ST_P_CreateDate as CSTPBillDate, C_ST_P_AuditDate as cstpauditdate, C_ST_P_GoodsCategory as cstpgoodscategory, ");
		buffer.append("B_SP_SupplierName as BSPSupplierName, B_SP_ID as cstpsupplierid, cr.personName as createPersonName, ");
		buffer.append("au.personName as auditPersonName from C_ST_Po ");
		
		if(!"".equals(Utility.getName(procurementOrdersPo.getCstpgoodsname())) || !"".equals(Utility.getName(procurementOrdersPo.getCstpgoodsid()))){
			buffer.append("inner join C_ST_PoEntry on C_ST_P_ID=C_ST_PE_PurchaseOrderID ");
			buffer.append("inner join B_GoodsInfo on C_ST_PE_goodsID=B_GI_GoodsID ");
		}		
		
		buffer.append("left join (select ID,personName from SYS_PersonInfo) cr on C_ST_P_CreatePerson=cr.ID ");
		buffer.append("left join (select ID,personName from SYS_PersonInfo) au on C_ST_P_AuditPerson=au.ID ");
		//buffer.append("inner join B_GoodsCategory on B_GC_ID = C_ST_P_GoodsCategory ");
		buffer.append("inner join B_Supplier on B_SP_ID = C_ST_P_SupplierId left join B_Departments on C_ST_P_DepartmentID = B_DP_DepartmentID ");
		buffer.append("where 1 = 1 and C_ST_P_AuditState=1 and C_ST_P_flag='0' ");
		buffer.append("  and C_ST_P_ID not in(select C_ST_I_SourceBillId from dbo.C_ST_Inventory where C_ST_I_SourceBillId is not null) ");
		
		List<String> params=new ArrayList<String>();
		
		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(procurementOrdersPo.getCstpcompanyid()));	
		}
		
		//条件查询
		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpid()))) {
			buffer.append("and C_ST_P_ID like '%'+ ?+'%' ");//quyanping
			params.add(procurementOrdersPo.getCstpid());
		}
		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpgoodscategory()))) {
			buffer.append("and C_ST_P_GoodsCategory = ? ");
			params.add(procurementOrdersPo.getCstpgoodscategory());
		}
		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpsupplierid()))) {
			buffer.append("and C_ST_P_SupplierId = ? ");
			params.add(procurementOrdersPo.getCstpsupplierid());
		}
		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpstarttime()))
				&& !"".equals(Utility.getName(procurementOrdersPo
						.getCstpendtime()))) {
			buffer.append("and convert(varchar(10), C_ST_P_CreateDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), C_ST_P_CreateDate, 23) <= ? ");
			params.add(procurementOrdersPo.getCstpstarttime());
			params.add(procurementOrdersPo.getCstpendtime());
		} else if (!"".equals(Utility.getName(procurementOrdersPo
				.getCstpstarttime()))&& "".equals(Utility.getName(procurementOrdersPo.getCstpendtime()))) {
			buffer.append("and convert(varchar(10), C_ST_P_CreateDate, 23) >= ? ");
			params.add(procurementOrdersPo.getCstpstarttime());
		} else if ("".equals(Utility.getName(procurementOrdersPo
				.getCstpstarttime()))
				&& !"".equals(Utility.getName(procurementOrdersPo
						.getCstpendtime()))) {
			buffer.append("and convert(varchar(10), C_ST_P_CreateDate, 23) <= ? ");
			params.add(procurementOrdersPo.getCstpendtime());
		}
		if(!"".equals(Utility.getName(procurementOrdersPo.getCstpcreateperson()))){
			buffer.append("and C_ST_P_CreatePerson=? ");
			params.add(procurementOrdersPo.getCstpcreateperson());
		}
		if(!"".equals(Utility.getName(procurementOrdersPo.getCstpauditperson()))){
			buffer.append("and C_ST_P_AuditPerson=? ");
			params.add(procurementOrdersPo.getCstpauditperson());
		}
		if(!"".equals(Utility.getName(procurementOrdersPo.getCstpgoodsname()))){
			buffer.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(procurementOrdersPo.getCstpgoodsname()));
		}
		if(!"".equals(Utility.getName(procurementOrdersPo.getCstpgoodsid()))){
			buffer.append("and C_ST_PE_goodsID like '%' + ? + '%' ");
			params.add(Utility.getName(procurementOrdersPo.getCstpgoodsid()));
		}
		
		buffer.append(" )temp ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(),ProcurementOrdersPo.class);
	}

	/**
	 * 转单信息的数量
	 */
	public int getProcurementInventoryEntryCount(
			InventoryEntryPo inventoryEntryPo) {
		// TODO Auto-generated method stub
		//查询总数商品
		StringBuffer buffer=new StringBuffer();
		
		buffer.append("select count(B_GoodsInfo.B_GI_GoodsID)");
		buffer.append("from(select b.goodsid,b.goodsquantity from( ");
		buffer.append("select a.cstpid,a.goodsid,sum(a.goodsquantity) as goodsquantity ");
		buffer.append("from(select C_ST_PE_PurchaseOrderID as cstpid,C_ST_PE_goodsID as goodsid, ");
		buffer.append("C_ST_PE_OrderNumber as goodsquantity from C_ST_PoEntry ");
		buffer.append("inner join C_ST_PO ON C_ST_P_ID = C_ST_PE_PurchaseOrderID and C_ST_P_AuditState = 1 ");
		buffer.append("union all select C_ST_V_PoID as cstpid,C_ST_V_GoodsId as goodsid,-C_ST_V_Num as goodsquantity ");
		buffer.append("from C_ST_Verification ");
		buffer.append("inner join C_ST_PO ON C_ST_P_ID = C_ST_V_PoID ");
		buffer.append(")a group by a.goodsid,a.cstpid ");
		buffer.append(")b where b.goodsquantity>0 and b.cstpid= ? )c ");
		buffer.append("inner join B_GoodsInfo on B_GoodsInfo.b_gi_goodsid=c.goodsid ");
		
		List<String> params = new ArrayList<String>();
		
		params.add(inventoryEntryPo.getCstiebillid());
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	/**
	 * 转单信息的详细信息
	 */
	public List<InventoryEntryPo> getProcurementInventoryEntryList(
			InventoryEntryPo inventoryEntryPo) {
		StringBuffer buffer=new StringBuffer();
		
		buffer.append("SELECT B_GoodsInfo.B_GI_GoodsID      AS cstiegoodsid, ");
		buffer.append("       B_GoodsInfo.B_GI_GoodsBarCode AS cstiebarcode, ");
		buffer.append("       UPPER(dbo.getbarcode(B_GoodsInfo.B_GI_BarCodeFlag,B_GoodsInfo.B_GI_GoodsID,B_GoodsInfo.B_GI_GoodsBarCode,convert(varchar(10),getdate(),120),?)) AS cstiepcbarcode, ");
		buffer.append("       B_GoodsInfo.B_GI_CostPrice    AS cstiecostprice, ");
		buffer.append("       B_GoodsInfo.B_GI_NotTaxRate   AS cstienottaxrate, ");
		buffer.append("       B_GoodsInfo.B_GI_TaxRate      AS cstietaxrate, ");
		buffer.append("       B_GoodsInfo.B_GI_ViewGoodsName    AS cstiegoodsname, ");
		buffer.append("       B_GoodsInfo.B_GI_Spec         AS cstiespec, ");
		buffer.append("       case ");
		buffer.append("       when B_GI_GoodsCategoryID = '8' then isnull(B_GI_Color,'')+isnull(B_GI_Sph,'') ");
		buffer.append("       when B_GI_GoodsCategoryID <> '8' then isnull(B_GI_Color,'') end ");
		buffer.append("       AS cstiecolor, ");
		buffer.append("       B_GoodsInfo.B_GI_Sph          AS cstiesph, ");
		buffer.append("       B_GoodsInfo.B_GI_Cyl          AS cstiecyl, ");
		buffer.append("       B_GoodsInfo.B_GI_Axis         AS cstieaxis, ");
		buffer.append("       B_GoodsInfo.B_GI_Curvature1   AS cstiecurvature1, ");
		buffer.append("       B_GoodsInfo.B_GI_Dia          AS cstiedia, ");
		buffer.append("       B_GoodsInfo.B_GI_retailprice          AS bgiretailprice, ");
		buffer.append("B_GoodsInfo.B_GI_FrameMaterialType    AS bgiframematerialtype , ");
		buffer.append("B_FrameMaterial.B_FM_Name    AS bgiframematerialtypename , ");
		buffer.append("B_GoodsInfo.B_GI_FrameSize     AS bgiframesize , ");
		buffer.append("B_GoodsInfo.B_GI_AccessoriesType     AS bgiaccessoriestype , ");
		buffer.append("B_GoodsInfo.B_GI_Capacity     AS bgicapacity , ");
		buffer.append("B_GoodsInfo.B_GI_CapacityEntry     AS bgicapacityentry , ");
		buffer.append("B_GoodsInfo.B_GI_SupplierColor     AS bgisuppliercolor , ");	
		buffer.append("B_GoodsInfo.B_GI_BelowPlusLuminosity     AS bgibelowplusluminosity, ");
		buffer.append("B_GoodsInfo.B_GI_Refractive     AS bgirefractive , ");
		buffer.append("B_GoodsInfo.B_GI_isMutiLuminosity     AS bgiismutiluminosity , ");
		buffer.append("B_GoodsInfo.B_GI_EyeGlassMaterialType     AS bgieyeglassmaterialtype , ");
		buffer.append("B_GoodsInfo.B_GI_UseType     AS bgiusetype , ");
		buffer.append("B_GoodsInfo.B_GI_StealthClass     AS bgistealthclass , ");
		buffer.append("       c.goodsquantity               AS cstiegoodsquantity, ");
		buffer.append("       B_BD_brandName               AS cstiebrandname, ");
		buffer.append("       B_BD_Place	               AS cstiesource, ");
		buffer.append("       isnull(B_BD_RegistrationNum,'')	               AS cstieregistrationnum ");
		buffer.append("FROM   (SELECT C_ST_PE_PurchaseOrderID AS cstpid, ");
		buffer.append("               C_ST_PE_goodsID         AS goodsid, ");
		buffer.append("               C_ST_PE_OrderNumber     AS goodsquantity ");
		buffer.append("        FROM   C_ST_PoEntry ");
		buffer.append("               INNER JOIN C_ST_PO ");
		buffer.append("                 ON C_ST_P_ID = C_ST_PE_PurchaseOrderID ");
		buffer.append("                    AND C_ST_P_AuditState = 1 ");
		buffer.append("                    AND C_ST_P_flag = 0 ");
		buffer.append("                    AND C_ST_PE_PurchaseOrderID = ? )c ");
		buffer.append("       INNER JOIN B_GoodsInfo ");
		buffer.append("         ON B_GoodsInfo.b_gi_goodsid = c.goodsid ");
		buffer.append("		  INNER JOIN B_Brand ON B_GI_BrandID = B_BD_ID and B_GI_SupplierID = B_BD_SupplierID ");
		buffer.append(" left join B_FrameMaterial on B_FrameMaterial.B_FM_ID = B_GoodsInfo.B_GI_FrameMaterialType ");
		
		List<String> params = new ArrayList<String>();
		
		params.add(Utility.getName(inventoryEntryPo.getBillid()));
		params.add(Utility.getName(inventoryEntryPo.getCstiebillid()));	
		
		return queryForObjectList(buffer.toString(), params.toArray(),InventoryEntryPo.class);
	}

	/**
	 * 新增采购收货主表
	 * @param po InventoryPo
	 */	
	public void insertProcurementInventoryPo(InventoryPo inventoryPo) {
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		sb1.append("insert into C_ST_Inventory(C_ST_I_BillID,C_ST_I_BillTypeId,C_ST_I_DeliveryID,C_ST_I_billDate,C_ST_I_GoodsCategory,");
		sb1.append("C_ST_I_SupplierId,C_ST_I_InStockId,");
		sb1.append("C_ST_I_DepartmentId,C_ST_I_createPerson,C_ST_I_AuditState,C_ST_I_Remark,C_ST_I_SubSupplierId");		
		sb2.append("?,?,?,getdate(),?,?,?,?,?,?,?,?");
		
		List<String> params = new ArrayList<String>();
		
		params.add(inventoryPo.getCstibillid());	
		params.add(inventoryPo.getCstibilltypeid());
		params.add(Utility.getName(inventoryPo.getDeliveryID()));	
		params.add(inventoryPo.getCstigoodscategory());
		params.add(inventoryPo.getCstisupplierid());
		params.add(inventoryPo.getCstiinstockid());
		params.add(inventoryPo.getCstidepartmentid());
		params.add(inventoryPo.getCsticreateperson());
		params.add(inventoryPo.getCstiauditstate());
		params.add(inventoryPo.getCstiremark());
		params.add(inventoryPo.getCstisubsupplierid());
		
		if(!"".equals(Utility.getName(inventoryPo.getCstiauditperson()))){
			sb1.append(",C_ST_I_AuditPerson,C_ST_I_AuditDate,C_ST_I_FinanceAuditState,C_ST_I_AllocationStatus ");
			sb2.append(",?,getdate(),'0','1' ");
			params.add(inventoryPo.getCstiauditperson());
		}
		if(!"".equals(Utility.getName(inventoryPo.getCstisourcebillid()))){
			sb1.append(",C_ST_I_SourceBillId");
			sb2.append(",?");
			params.add(inventoryPo.getCstisourcebillid());
		}
		String sql=sb1.toString()+")values("+sb2.toString()+")";
		getJdbcTemplate().update(sql, params.toArray());
	}
	
	/**
	 * 新增采购收货明细表
	 * @param po InventoryPo
	 */	
	public void insertProcurementInventoryEntryPo(InventoryEntryPo inventoryEntryPo) {
		
		String sql="insert into C_ST_InventoryEntry(C_ST_IE_ID,C_ST_IE_BillID,C_ST_IE_GoodsId,C_ST_IE_GoodsQuantity," +
				"C_ST_IE_NotTaxRate,C_ST_IE_TaxRate,C_ST_IE_CostPrice," +
				"C_ST_IE_InStockId,C_ST_IE_BarCode,C_ST_IE_WarehousingDate,C_ST_IE_GuaranteePeriod,C_ST_IE_Batch,C_ST_IE_RegistrationNum ) " +
				"values(?,?,?,?,?,?,?,?,?,getdate(),?,?,?)";		
		
		List<String> params = new ArrayList<String>();
		
		params.add(this.uuid.generate());	
		params.add(inventoryEntryPo.getCstiebillid());	
		params.add(inventoryEntryPo.getCstiegoodsid());
		params.add(inventoryEntryPo.getCstiegoodsquantity());
		params.add(inventoryEntryPo.getCstienottaxrate());
		params.add(inventoryEntryPo.getCstietaxrate());
		params.add(inventoryEntryPo.getCstiecostprice());
		params.add(inventoryEntryPo.getCstieinstockid());
		params.add(inventoryEntryPo.getCstiebarcode());
		params.add(inventoryEntryPo.getCstieguaranteeperiod());
		params.add(inventoryEntryPo.getCstiebatch());
		params.add(Utility.getName(inventoryEntryPo.getCstieregistrationnum()));
		
		getJdbcTemplate().update(sql, params.toArray());
		
	}
	
	/**
	 * 新增核销表
	 * @param po VerificationPo
	 */	
	public void insertVerification(VerificationPo po) {
		
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		sb1.append("insert into C_ST_Verification(C_ST_V_PinID,C_ST_V_GoodsId,C_ST_V_BarCode,C_ST_V_Num,C_ST_V_Datetime,C_ST_V_UUID");
		sb2.append("?,?,?,?,getdate(),?");		
		
		List<String> params = new ArrayList<String>();
		
		params.add(po.getCstvpinid());	
		params.add(po.getCstvgoodsid());	
		params.add(po.getCstvbarcode());
		params.add(po.getCstvnum());
		params.add(this.uuid.generate());
		
		if(!"".equals(Utility.getName(po.getCstvpoid()))){
			sb1.append(",C_ST_V_PoID");
			sb2.append(",?");
			params.add(po.getCstvpoid());
		}
		String sql=sb1.toString()+")values("+sb2.toString()+")";
		getJdbcTemplate().update(sql, params.toArray());
		
	}
	

}
