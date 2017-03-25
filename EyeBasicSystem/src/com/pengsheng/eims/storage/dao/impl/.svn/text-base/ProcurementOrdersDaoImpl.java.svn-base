package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.StatusModulePo;
import com.pengsheng.eims.storage.dao.ProcurementOrdersDao;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersEntryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ProcurementOrdersDaoImpl extends BaseJdbcDaoSupport implements
		ProcurementOrdersDao {

	public List<GoodsCategoryPo> getGoodsCategorys() {

		String sql = "select B_GC_ID as bgcid,B_GC_GoodsCategoryName as bgcgoodscategoryname from B_GoodsCategory order by B_GC_Order ";

		return queryForObjectList(sql, null, GoodsCategoryPo.class);
	}

	public void insertProcurementOrdersEntry(
			ProcurementOrdersEntryPo procurementOrdersEntryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();

		buffer.append("INSERT INTO C_ST_PoEntry ");
		buffer.append("(C_ST_PE_ID ");
		buffer.append(",C_ST_PE_PurchaseOrderID ");
		buffer.append(",C_ST_PE_OrderNumber ");
		buffer.append(", C_ST_PE_goodsID ");
		buffer.append(",C_ST_PE_Remark ");
		buffer.append(") ");
		buffer.append("VALUES (?, ?, ?, UPPER(?), ? )");

		List<String> params = new ArrayList<String>();
		params.add(uuid.getInstance().generate());
		params.add(procurementOrdersEntryPo.getCstpepurchaseorderid());
		params.add(procurementOrdersEntryPo.getCstpeordernumber());
		params.add(procurementOrdersEntryPo.getCstpegoodsid());
		params.add(procurementOrdersEntryPo.getCstperemark());

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}

	public void insertProcurementOrders(ProcurementOrdersPo procurementOrdersPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();

		buffer.append("INSERT INTO C_ST_PO ");
		buffer.append("(C_ST_P_ID ");
		buffer.append(",C_ST_P_BillTypeId ");
		buffer.append(",C_ST_P_BillDate ");
		buffer.append(",C_ST_P_SupplierId ");
		buffer.append(",C_ST_P_GoodsCategory ");
		buffer.append(",C_ST_P_ApplyBillID ");
		if ("1".equals(Utility.getName(procurementOrdersPo.getCstpauditstate()))) {
			buffer.append(",C_ST_P_AuditPerson ");
			buffer.append(",C_ST_P_AuditDate ");
		}
		buffer.append(",C_ST_P_AuditState ");
		buffer.append(",C_ST_P_CreatePerson ");
		buffer.append(",C_ST_P_CreateDate ");
		buffer.append(",C_ST_P_Remark,C_ST_P_Flag,C_ST_P_TakeAddress,C_ST_P_TakePerson,C_ST_P_TakePhone,C_ST_P_TakeFax,C_ST_P_DepartmentID) ");

		List<String> params = new ArrayList<String>();

		if ("1".equals(Utility.getName(procurementOrdersPo.getCstpauditstate()))) {
			buffer.append("VALUES (?, ?, getdate(), ?, ?, ?, ? ,  GETDATE(), ?, ?, GETDATE(), ? ,0,?,?,?,?,?)");

			params.add(procurementOrdersPo.getCstpid());
			params.add(procurementOrdersPo.getCstpbilltypeid());
			params.add(procurementOrdersPo.getCstpsupplierid());
			params.add(procurementOrdersPo.getCstpgoodscategory());
			params.add(procurementOrdersPo.getCshaaabillid());
			params.add(procurementOrdersPo.getCstpauditperson());
			params.add(procurementOrdersPo.getCstpauditstate());
			params.add(procurementOrdersPo.getCstpcreateperson());
			params.add(procurementOrdersPo.getCstpremark());			
			params.add(Utility.getName(procurementOrdersPo.getCstpordersdeliveryaddress()));
			params.add(Utility.getName(procurementOrdersPo.getCstpordersdeliveryperson()));
			params.add(Utility.getName(procurementOrdersPo.getCstpordersdeliveryphone()));
			params.add(Utility.getName(procurementOrdersPo.getCstpordersdeliveryfax()));
			params.add(Utility.getName(procurementOrdersPo.getCstpdepartmentid()));
			
		} else {
			buffer.append("VALUES (?, ?, ?, ?, ?, ? , ?, ?, GETDATE(), ? ,0,?,?,?,?,?)");

			params.add(procurementOrdersPo.getCstpid());
			params.add(procurementOrdersPo.getCstpbilltypeid());
			params.add(procurementOrdersPo.getCstpbilldate());
			params.add(procurementOrdersPo.getCstpsupplierid());
			params.add(procurementOrdersPo.getCstpgoodscategory());
			params.add(procurementOrdersPo.getCshaaabillid());
			params.add(procurementOrdersPo.getCstpauditstate());
			params.add(procurementOrdersPo.getCstpcreateperson());
			params.add(procurementOrdersPo.getCstpremark());
			params.add(Utility.getName(procurementOrdersPo.getCstpordersdeliveryaddress()));
			params.add(Utility.getName(procurementOrdersPo.getCstpordersdeliveryperson()));
			params.add(Utility.getName(procurementOrdersPo.getCstpordersdeliveryphone()));
			params.add(Utility.getName(procurementOrdersPo.getCstpordersdeliveryfax()));
			params.add(Utility.getName(procurementOrdersPo.getCstpdepartmentid()));
		}

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	//新增申请表
	public void insertProcurementOrdersStatus(ProcurementOrdersPo procurementOrdersPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("insert into C_SHA_Status (C_SHA_StatusUUID,C_SHA_StatusOrderID) ");
		sb.append("values(?,?)");
		params.add(this.uuid.generate());
		params.add(procurementOrdersPo.getCstpid());
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	//插入申请表
	public void updateProcurementOrdersStatus(ProcurementOrdersPo procurementOrdersPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("UPDATE C_SHA_Status ");
		sb.append("SET ");
		sb.append("C_SHA_StatusOrderID = ? ");
		params.add(procurementOrdersPo.getCstpid());
		if(!"".equals(Utility.getName(procurementOrdersPo.getCshaaadepartmentid()))){
			sb.append(",C_SHA_StatusDepartmentID = ? ");
			params.add(procurementOrdersPo.getCshaaadepartmentid());
		}
		sb.append("WHERE C_SHA_StatusApplyBillID = ?");
		params.add(procurementOrdersPo.getCshaaabillid());

		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	//反添加调拨申请的状态（对于采购订单）
	public void insertProcurementApplyStatus(ProcurementOrdersPo procurementOrdersPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("UPDATE C_SHA_ApplyAllocation ");
		sb.append("SET ");
		sb.append("C_SHA_AA_OrderStatus = '1' ");
		sb.append("WHERE C_SHA_AA_billID = ? ");
		params.add(procurementOrdersPo.getCshaaabillid());

		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public int getProcurementOroderCount(ProcurementOrdersPo procurementOrdersPo) {

		StringBuffer sb = new StringBuffer();

		sb.append("select count(C_ST_P_ID) from C_ST_Po left join B_Departments on C_ST_P_DepartmentID = B_DP_DepartmentID ");
		sb.append(" where 1 = 1 ");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(procurementOrdersPo.getCstpcompanyid()));	
		}
		
		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpid()))) {
			sb.append("and C_ST_P_ID like '%'+ ? +'%' ");//quyanping 

			params.add(procurementOrdersPo.getCstpid());
		}

		if (!"".equals(Utility.getName(procurementOrdersPo
				.getCstpgoodscategory()))) {
			sb.append("and C_ST_P_GoodsCategory = ? ");

			params.add(procurementOrdersPo.getCstpgoodscategory());
		}

		if (!""
				.equals(Utility
						.getName(procurementOrdersPo.getCstpsupplierid()))) {
			sb.append("and C_ST_P_SupplierId = ? ");

			params.add(procurementOrdersPo.getCstpsupplierid());
		}

		if (!""
				.equals(Utility
						.getName(procurementOrdersPo.getCstpauditstate()))) {
			sb.append("and C_ST_P_AuditState = ? ");

			params.add(procurementOrdersPo.getCstpauditstate());
		}

		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpstarttime()))
				&& !"".equals(Utility.getName(procurementOrdersPo
						.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_CreateDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_P_CreateDate, 23) <= ? ");

			params.add(procurementOrdersPo.getCstpstarttime());
			params.add(procurementOrdersPo.getCstpendtime());
		} else if (!"".equals(Utility.getName(procurementOrdersPo
				.getCstpstarttime()))
				&& "".equals(Utility.getName(procurementOrdersPo
						.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_CreateDate, 23) >= ? ");

			params.add(procurementOrdersPo.getCstpstarttime());
		} else if ("".equals(Utility.getName(procurementOrdersPo.getCstpstarttime()))&& !"".equals(Utility.getName(procurementOrdersPo.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_CreateDate, 23) <= ? ");

			params.add(procurementOrdersPo.getCstpendtime());
		}

		// 创建人
		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpcreateperson()))) {
			sb.append(" and C_ST_P_CreatePerson = ? ");
			params.add(procurementOrdersPo.getCstpcreateperson());
		}
		
		if(!"".equals(Utility.getName(procurementOrdersPo.getCstpremark()))){
			sb.append("and C_ST_P_Remark like '%' + ? + '%' ");
			params.add(procurementOrdersPo.getCstpremark());
		}

		// 审核人
		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpauditperson()))) {
			sb.append(" and C_ST_P_AuditPerson = ? ");
			params.add(procurementOrdersPo.getCstpauditperson());
		}
		
		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpgoodsname()))) {
			sb.append(" and C_ST_P_ID in ( ");
			
			sb.append("SELECT DISTINCT C_ST_PE_PurchaseOrderID ");
			sb.append("FROM   C_ST_PoEntry ");
			sb.append("       INNER JOIN B_GoodsInfo ");
			sb.append("         ON C_ST_PE_goodsID = B_GI_GoodsID ");
			sb.append("WHERE  B_GI_ViewGoodsName LIKE '%'+?+'%' ");
			
			sb.append(" ) ");
			params.add(procurementOrdersPo.getCstpgoodsname());
		}

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	public List<ProcurementOrdersPo> getProcurementOroderList(
			ProcurementOrdersPo procurementOrdersPo, int start, int size) {

		StringBuffer sb = new StringBuffer();

		List<String> params = new ArrayList<String>();
		int countPage = start + size;

		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from (select ROW_NUMBER() ");
		sb.append("Over(order by C_ST_P_CreateDate desc) as 'rowNum', ");
		sb.append("C_ST_P_ID as CSTPID, C_ST_P_CreateDate as CSTPBillDate, C_ST_P_AuditDate as cstpauditdate,C_ST_P_flag as cstpflag,");
		sb.append("B_SP_SupplierName as BSPSupplierName, C_ST_P_Remark as cstpremark,");
		sb.append("B_GC_GoodsCategoryName as BGCGoodsCategoryName, ");
		sb.append("C_ST_P_AuditState as CSTPAuditState, ");
		sb.append("a.personName as createPersonName, ");
		sb.append("b.personName as auditPersonName ");
		sb.append("from C_ST_PO ");
		sb.append("left join (select ID,personName from SYS_PersonInfo) a on C_ST_P_CreatePerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo) b on C_ST_P_AuditPerson=b.ID ");
		sb.append("inner join B_GoodsCategory on B_GC_ID = C_ST_P_GoodsCategory ");
		sb.append("inner join B_Supplier on B_SP_ID = C_ST_P_SupplierId left join B_Departments on C_ST_P_DepartmentID = B_DP_DepartmentID ");
		sb.append("where 1 = 1 ");

		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(procurementOrdersPo.getCstpcompanyid()));	
		}

		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpid()))) {
			sb.append("and C_ST_P_ID like'%' + ? + '%' ");//quyanping

			params.add(procurementOrdersPo.getCstpid());
		}

		if (!"".equals(Utility.getName(procurementOrdersPo
				.getCstpgoodscategory()))) {
			sb.append("and C_ST_P_GoodsCategory = ? ");

			params.add(procurementOrdersPo.getCstpgoodscategory());
		}

		if (!""
				.equals(Utility
						.getName(procurementOrdersPo.getCstpsupplierid()))) {
			sb.append("and C_ST_P_SupplierId = ? ");

			params.add(procurementOrdersPo.getCstpsupplierid());
		}

		if (!""
				.equals(Utility
						.getName(procurementOrdersPo.getCstpauditstate()))) {
			sb.append("and C_ST_P_AuditState = ? ");

			params.add(procurementOrdersPo.getCstpauditstate());
		}

		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpstarttime()))
				&& !"".equals(Utility.getName(procurementOrdersPo
						.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_CreateDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_P_CreateDate, 23) <= ? ");

			params.add(procurementOrdersPo.getCstpstarttime());
			params.add(procurementOrdersPo.getCstpendtime());
		} else if (!"".equals(Utility.getName(procurementOrdersPo
				.getCstpstarttime()))
				&& "".equals(Utility.getName(procurementOrdersPo
						.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_CreateDate, 23) >= ? ");

			params.add(procurementOrdersPo.getCstpstarttime());
		} else if ("".equals(Utility.getName(procurementOrdersPo
				.getCstpstarttime()))
				&& !"".equals(Utility.getName(procurementOrdersPo
						.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_CreateDate, 23) <= ? ");

			params.add(procurementOrdersPo.getCstpendtime());
		}

		// 创建人
		if (!"".equals(Utility.getName(procurementOrdersPo
				.getCstpcreateperson()))) {
			sb.append(" and C_ST_P_CreatePerson = ? ");
			params.add(procurementOrdersPo.getCstpcreateperson());
		}
		
		if(!"".equals(Utility.getName(procurementOrdersPo.getCstpremark()))){
			sb.append("and C_ST_P_Remark like '%' + ? + '%' ");
			params.add(procurementOrdersPo.getCstpremark());
		}

		// 审核人
		if (!"".equals(Utility
				.getName(procurementOrdersPo.getCstpauditperson()))) {
			sb.append(" and C_ST_P_AuditPerson = ? ");
			params.add(procurementOrdersPo.getCstpauditperson());
		}
		
		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpgoodsname()))) {
			sb.append(" and C_ST_P_ID in ( ");
			
			sb.append("SELECT DISTINCT C_ST_PE_PurchaseOrderID ");
			sb.append("FROM   C_ST_PoEntry ");
			sb.append("       INNER JOIN B_GoodsInfo ");
			sb.append("         ON C_ST_PE_goodsID = B_GI_GoodsID ");
			sb.append("WHERE  B_GI_ViewGoodsName LIKE '%'+?+'%' ");
			
			sb.append(" ) ");
			params.add(procurementOrdersPo.getCstpgoodsname());
		}
		
		sb.append(") table1 where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append("set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),
				ProcurementOrdersPo.class);
	}

	public void delProcurementOrders(String id) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM C_ST_PO WHERE C_ST_P_ID = ?");

		List<String> params = new ArrayList<String>();
		params.add(id);

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void delProcurementOrdersEntry(String id) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer
				.append("DELETE FROM C_ST_PoEntry WHERE C_ST_PE_PurchaseOrderID = ?");

		List<String> params = new ArrayList<String>();
		params.add(id);

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public ProcurementOrdersPo getProcurementOrders(
			ProcurementOrdersPo procurementOrdersPo) {

		StringBuffer sb = new StringBuffer();
		sb.append("select top 1 ");
		sb.append("C_ST_P_ID as CSTPID, C_ST_P_BillDate as cstpcreatedate, ");
		sb.append("B_SP_SupplierName as BSPSupplierName, ");
		sb.append("C_ST_P_SupplierId as cstpsupplierid,C_ST_P_AuditDate as cstpauditdate, ");
		sb.append("B_GC_GoodsCategoryName as BGCGoodsCategoryName, ");
		sb.append("C_ST_P_AuditState as CSTPAuditState, ");
		sb.append("C_ST_P_ApplyBillID as cshaaabillid, ");
		sb.append("C_ST_P_GoodsCategory as cstpgoodscategory, ");
		sb.append("a.personName as createPersonName, C_ST_P_Remark as CSTPRemark ,C_ST_P_TakeAddress as cstpordersdeliveryaddress,C_ST_P_TakePerson as cstpordersdeliveryperson,C_ST_P_TakePhone as cstpordersdeliveryphone,C_ST_P_TakeFax as cstpordersdeliveryfax, ");
		sb.append("b.personName as auditPersonName from C_ST_PO ");
		sb.append("left join (select ID,personName from SYS_PersonInfo) a on C_ST_P_CreatePerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo) b on C_ST_P_AuditPerson=b.ID ");
		sb.append("inner join B_GoodsCategory on B_GC_ID = C_ST_P_GoodsCategory ");
		sb.append("inner join B_Supplier on B_SP_ID = C_ST_P_SupplierId ");
		sb.append("where C_ST_P_ID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(procurementOrdersPo.getCstpid());

		return (ProcurementOrdersPo) queryForObject(sb.toString(), params.toArray(), ProcurementOrdersPo.class);
	}
	
	public List<ProcurementOrdersEntryPo> getProcurementOrdersEntryApplyList(ProcurementOrdersPo po)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT C_SHA_AAE_billId as cstpeid, ");
		sb.append(" UPPER(C_SHA_AAE_goodsId) as cstpegoodsid, ");
		sb.append("B_GI_Spec as bgispec, ");
		sb.append("B_GI_Color as bgicolor, ");
		sb.append("B_GI_Sph as bgisph, ");
		sb.append("B_GI_Cyl as bgicyl, ");
		sb.append("B_GI_Axis as bgiaxis, ");
		sb.append("B_GI_Curvature1 as bgicurvature1, ");
		sb.append("B_GI_Curvature2 as bgicurvature2, ");
		sb.append("B_GI_Dia as bgidia, ");
		sb.append("B_GI_ViewGoodsName as bgigoodsname, ");
		sb.append(" UPPER(B_GI_GoodsBarCode) as bgiGoodsBarCode, ");
		sb.append("B_GI_FrameMaterialType    AS bgiframematerialtype , ");
		sb.append("B_FM_Name    AS bgiframematerialtypename , ");
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
		sb.append("B_GI_StealthClass     AS bgistealthclass , ");
		sb.append("C_SHA_AAE_requirementQuantity as cstpeordernumber ");
		sb.append("FROM C_SHA_ApplyAllocationEntry INNER JOIN ");
		sb.append("B_GoodsInfo ON C_SHA_AAE_goodsId = B_GoodsInfo.B_GI_GoodsID ");
		sb.append("left join B_FrameMaterial ON B_FrameMaterial.B_FM_ID = B_GoodsInfo.B_GI_FrameMaterialType ");
		sb.append("where C_SHA_AAE_billId = ? ");
		if (!"".equals(Utility.getName(po.getCstpgoodscategory()))) {
			sb.append(" and B_GI_GoodsCategoryID = ? ");
		}
		if (!"".equals(Utility.getName(po.getCstpsupplierid()))) {
			sb.append(" and B_GI_SupplierID = ? ");
		}
		if (!"".equals(Utility.getName(po.getCstpbrandid()))) {
			sb.append(" and B_GI_BrandID = ? ");
		}
		sb.append(" order by C_SHA_AAE_goodsId ");

		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getCshaaabillid()));
		if (!"".equals(Utility.getName(po.getCstpgoodscategory()))) {
			params.add(Utility.getName(po.getCstpgoodscategory()));
		}
		if (!"".equals(Utility.getName(po.getCstpsupplierid()))) {
			params.add(Utility.getName(po.getCstpsupplierid()));
		}
		if (!"".equals(Utility.getName(po.getCstpbrandid()))) {
			params.add(Utility.getName(po.getCstpbrandid()));
		}

		return queryForObjectList(sb.toString(), params.toArray(),ProcurementOrdersEntryPo.class);
	}

	public List<ProcurementOrdersEntryPo> getProcurementOrdersEntryList(
			ProcurementOrdersEntryPo procurementOrdersEntryPo) {

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT C_ST_PE_ID 		as cstpeid, ");
		sb.append("C_ST_PE_PurchaseOrderID 	as cstpepurchaseorderid, ");
		sb.append("C_ST_PE_OrderNumber 		as cstpeordernumber, ");
		sb.append(" UPPER(C_ST_PE_goodsID) 			as cstpegoodsid, ");
		sb.append(" UPPER(dbo.getbarcode(B_GI_BarCodeFlag,B_GI_GoodsID,B_GI_GoodsBarCode,convert(varchar(10),getdate(),120),?)) 		as bgiGoodsBarCode, ");
		sb.append("B_GI_Spec 				as bgispec, ");
		sb.append("case ");
		sb.append("when B_GI_GoodsCategoryID = '8' then isnull(B_GI_Color,'')+isnull(B_GI_Sph,'') ");
		sb.append("when B_GI_GoodsCategoryID <> '8' then isnull(B_GI_Color,'') ");
		sb.append("end 				as bgicolor, ");
		sb.append("B_GI_Sph 				as bgisph, ");
		sb.append("B_GI_Cyl 				as bgicyl, ");
		sb.append("B_GI_Axis 				as bgiaxis, ");
		sb.append("B_GI_CostPrice 			as bgicostprice, ");
		sb.append("B_GI_RetailPrice 		as bgiretailprice, ");
		sb.append("B_GI_TaxRate 			as bgitaxrate, ");
		sb.append("B_GI_NotTaxRate 			as bginottaxrate, ");
		sb.append("B_GI_Curvature1 			as bgicurvature1, ");
		sb.append("B_GI_Curvature2 			as bgicurvature2, ");
		sb.append("B_GI_Dia 				as bgidia, ");
		sb.append("B_GI_ViewGoodsName 			as bgigoodsname, ");
		sb.append("B_SP_SupplierName 		as bspsuppliername, ");
		sb.append("B_SP_ID 					as bspid, ");
		sb.append("C_ST_PE_OrderNumber 		as cstpeordernumber, ");
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
		sb.append("B_GI_StealthClass     AS bgistealthclass , ");
		sb.append("B_BD_Place			 	as bgisource, ");
		sb.append("C_ST_PE_Remark 			as CSTPERemark, ");
		sb.append("B_BD_BrandName 			as cstpebrandname, ");
		sb.append("isnull(B_BD_RegistrationNum,'') 			as bgiregistrationnum ");
		sb.append("FROM C_ST_PoEntry INNER JOIN ");
		sb.append("B_GoodsInfo ON C_ST_PE_goodsID = B_GoodsInfo.B_GI_GoodsID ");
		sb.append("left join B_FrameMaterial on B_FrameMaterial.B_FM_ID = B_GoodsInfo.B_GI_FrameMaterialType ");
		sb.append("INNER JOIN B_Supplier ON B_GI_SupplierID = B_SP_ID ");
		sb.append("INNER JOIN B_Brand ON substring(C_ST_PE_goodsID,6,2) = B_BD_ID and substring(C_ST_PE_goodsID,3,2) = B_BD_SupplierID ");
		sb.append("where C_ST_PE_PurchaseOrderID = ? order by C_ST_PE_goodsID ");

		List<String> params = new ArrayList<String>();
		params.add(procurementOrdersEntryPo.getCstpebillid());
		params.add(procurementOrdersEntryPo.getCstpepurchaseorderid());

		return queryForObjectList(sb.toString(), params.toArray(),
				ProcurementOrdersEntryPo.class);
	}

	public void updateProcurementOrders(ProcurementOrdersPo procurementOrdersPo) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("UPDATE C_ST_PO ");
		sb.append("SET ");
		sb.append("C_ST_P_SupplierId = ?, ");
		sb.append("C_ST_P_GoodsCategory = ?, ");
		sb.append("C_ST_P_ApplyBillID = ?, ");
		params.add(procurementOrdersPo.getCstpsupplierid());
		params.add(procurementOrdersPo.getCstpgoodscategory());
		params.add(procurementOrdersPo.getCshaaabillid());
		if ("1".equals(Utility.getName(procurementOrdersPo.getCstpauditstate()))) {
			sb.append("C_ST_P_AuditPerson = ?, ");
			sb.append("C_ST_P_AuditState = ?, ");
			sb.append("C_ST_P_AuditDate = GETDATE(), ");

			params.add(procurementOrdersPo.getCstpauditperson());
			params.add(procurementOrdersPo.getCstpauditstate());
		}
		sb.append("C_ST_P_Remark = ?,C_ST_P_TakeAddress=?,C_ST_P_TakePerson=?,C_ST_P_TakePhone=?,C_ST_P_TakeFax=? ");
		sb.append("WHERE C_ST_P_ID = ?");

		params.add(procurementOrdersPo.getCstpremark());
		params.add(Utility.getName(procurementOrdersPo.getCstpordersdeliveryaddress()));
		params.add(Utility.getName(procurementOrdersPo.getCstpordersdeliveryperson()));
		params.add(Utility.getName(procurementOrdersPo.getCstpordersdeliveryphone()));
		params.add(Utility.getName(procurementOrdersPo.getCstpordersdeliveryfax()));
		params.add(procurementOrdersPo.getCstpid());

		getJdbcTemplate().update(sb.toString(), params.toArray());

	}
	
	public void pOimportOrders(String poID){
		String sql = "exec SP_POimportOrders ? ";
		
		getJdbcTemplate().update(sql, new String[]{poID});
	}

	//是否开启订单系统
	public StatusModulePo OrdersStatus(String ModuleID) {
		List<String> params = new ArrayList<String>();
		String sql = "select F_OCS_SettingID as fsmstatusid,F_OCS_StatusSetting as fsmstatuscode from F_OpenCloseSetting";
		 sql += " where F_OCS_SettingID=? ";
			params.add(ModuleID);
		return (StatusModulePo) queryForObject(sql, params.toArray(), StatusModulePo.class);
	}
	
	public GoodsInfoPo selectDimensionPo(String goodsid,String v) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("Select  ");
		sb.append("UPPER(B_GI_GoodsID) as bgigoodsid, ");
		sb.append("UPPER(dbo.getbarcode3(B_GI_BarCodeFlag,B_GI_GoodsID,B_GI_GoodsBarCode,convert(varchar(10),getdate(),120))) as bgigoodsbarcode, ");
		sb.append("UPPER(dbo.getbarcode3(B_GI_BarCodeFlag,B_GI_GoodsID,B_GI_GoodsBarCode,convert(varchar(10),getdate(),120))) as bgipcbarcode, ");
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
		sb.append("? as bgigoodsquantity, ");
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
		
		params.add(v);
		params.add(goodsid);
		
		return (GoodsInfoPo) queryForObject(sb.toString(), params.toArray(), GoodsInfoPo.class);
	}
	public GoodsInfoPo selectDimensionPo(String goodsid,String v,String billID) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("Select  ");
		sb.append(" UPPER(B_GI_GoodsID) as bgigoodsid, ");
		sb.append(" UPPER(dbo.getbarcode(B_GI_BarCodeFlag,B_GI_GoodsID,B_GI_GoodsBarCode,convert(varchar(10),getdate(),120),?)) as bgigoodsbarcode, ");
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
		sb.append("? as bgigoodsquantity, ");
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
		sb.append("B_BD_Place as bgisource ");
		sb.append("from B_GoodsInfo ");
		sb.append("inner join B_Supplier on B_GI_SupplierID = B_SP_ID ");
		sb.append("inner join B_Brand on B_GI_SupplierID = B_BD_SupplierID and B_GI_BrandID = B_BD_ID ");
		sb.append("left join B_FrameMaterial on B_FM_ID = B_GI_FrameMaterialType ");
		sb.append("where B_GI_GoodsID = ? ");

		params.add(billID);
		params.add(v);
		params.add(goodsid);
		
		return (GoodsInfoPo) queryForObject(sb.toString(), params.toArray(), GoodsInfoPo.class);
	}
	
	/**
	 * 得到订单中所有的品种
	 */
	public List<GoodsInfoPo> getProBrand(String billID){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT B_BD_ID as bgibrandid, ");
		sb.append("       B_BD_brandName as bgibrandname ");
		sb.append("FROM   C_ST_PoEntry ");
		sb.append("       INNER JOIN B_GOODSINFO ");
		sb.append("         ON B_GI_GOODSID = C_ST_PE_goodsID ");
		sb.append("       INNER JOIN B_Brand ");
		sb.append("         ON B_BD_ID = B_GI_BrandID ");
		sb.append("            AND B_BD_SupplierID = B_GI_SupplierID ");
		sb.append("WHERE  C_ST_PE_PurchaseOrderID = ?  and B_GI_isCustomize <> 'D' ");
		sb.append("GROUP  BY B_BD_ID, ");
		sb.append("          B_BD_brandName ");
		
		params.add(Utility.getName(billID));
		
		return queryForObjectList(sb.toString(),params.toArray(),GoodsInfoPo.class);
	}
	
}
