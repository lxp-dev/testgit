package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.dao.ConsignProcessOrderDao;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ConsignProcessOrderDaoImpl extends BaseJdbcDaoSupport implements
		ConsignProcessOrderDao {

	public List<GoodsCategoryPo> getGoodsCategorys() {

		String sql = "select B_GC_ID as bgcid,B_GC_GoodsCategoryName as bgcgoodscategoryname from B_GoodsCategory order by B_GC_Order";

		return queryForObjectList(sql, null, GoodsCategoryPo.class);
	}

	public int getConsignProcessOrderCount(
			ConsignProcessOrderPo consignProcessOrderPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select COUNT(C_ST_CPO_OrderBillId) from ( ");
		
		sb.append("select distinct C_ST_CPO_OrderBillId from C_ST_ConsignProcessOrder left join B_Departments on C_ST_CPO_DepartmentID = B_DP_DepartmentID inner join C_ST_ConsignProcessOrderDetails on C_ST_CPO_OrderBillId=C_ST_CPOD_OrderBillD inner join B_GoodsInfo on C_ST_CPOD_GoodsID=B_GI_GoodsID ");
		
		if(!"".equals(Utility.getName(consignProcessOrderPo.getSalesdjsbm()))){
			sb.append(" left join S_SE_SalesBasic on S_SE_SB_SalesID = C_ST_CPOD_GlassesBillID ");
		}		
		
		sb.append(" where 1 = 1 ");

		List<String> params = new ArrayList<String>();
		
		if (!"".equals(Utility.getName(consignProcessOrderPo.getCstcpocompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(consignProcessOrderPo.getCstcpocompanyid()));	
		}

		if (!"".equals(Utility.getName(consignProcessOrderPo.getCstcpoorderbillid()))) {
			sb.append("and C_ST_CPO_OrderBillId like '%' + ? +'%'");//quyanping

			params.add(consignProcessOrderPo.getCstcpoorderbillid());
		}

		if(!"".equals(Utility.getName(consignProcessOrderPo.getSalesdjsbm()))){
			sb.append("and S_SE_SB_Djsbm like '%' + ? +'%'");
			params.add(consignProcessOrderPo.getSalesdjsbm());
		}	
		
		if (!"".equals(Utility.getName(consignProcessOrderPo.getCstcposupplierid()))) {
			sb.append("and C_ST_CPO_SupplierId = ? ");

			params.add(consignProcessOrderPo.getCstcposupplierid());
		}

		if (!"".equals(Utility.getName(consignProcessOrderPo.getCstcpostarttime()))
				&& !"".equals(Utility.getName(consignProcessOrderPo.getCstcpoendtime()))) {
			sb.append("and convert(varchar(10), C_ST_CPO_BillDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_CPO_BillDate, 23) <= ? ");

			params.add(consignProcessOrderPo.getCstcpostarttime());
			params.add(consignProcessOrderPo.getCstcpoendtime());
		} else if (!"".equals(Utility.getName(consignProcessOrderPo.getCstcpostarttime()))
				&& "".equals(Utility.getName(consignProcessOrderPo.getCstcpoendtime()))) {
			sb.append("and convert(varchar(10), C_ST_CPO_BillDate, 23) >= ? ");

			params.add(consignProcessOrderPo.getCstcpostarttime());
		} else if ("".equals(Utility.getName(consignProcessOrderPo
				.getCstcpostarttime()))
				&& !"".equals(Utility.getName(consignProcessOrderPo
						.getCstcpoendtime()))) {
			sb.append("and convert(varchar(10), C_ST_CPO_BillDate, 23) <= ? ");

			params.add(consignProcessOrderPo.getCstcpoendtime());
		}

		// 审核状态
		if (!"".equals(Utility.getName(consignProcessOrderPo
				.getCstcpoauditstate()))) {
			sb.append(" and C_ST_CPO_AuditState = ? ");

			params.add(consignProcessOrderPo.getCstcpoauditstate());
		}

		// 委外订单类型
		if (!"".equals(Utility.getName(consignProcessOrderPo
				.getCstcpoordergoodscategory()))) {
			sb.append(" and C_ST_CPO_OrderGoodsCategory = ? ");

			params.add(consignProcessOrderPo.getCstcpoordergoodscategory());
		}

		// 创建人
		if (!"".equals(Utility.getName(consignProcessOrderPo
				.getCreatePersonName()))) {
			sb.append(" and C_ST_CPO_CreatePerson ");
			sb.append(" IN (select ID from SYS_PersonInfo ");
			sb.append(" where personName like '%' + ? + '%') ");
			params.add(consignProcessOrderPo.getCreatePersonName());
		}

		// 审核人
		if (!"".equals(Utility.getName(consignProcessOrderPo
				.getAuditPersonName()))) {
			sb.append(" and C_ST_CPO_AuditPerson  ");
			sb.append(" IN (select ID from SYS_PersonInfo ");
			sb.append(" where personName like '%' + ? + '%') ");
			params.add(consignProcessOrderPo.getAuditPersonName());
		}
		
		// 配镜单
		if (!"".equals(Utility.getName(consignProcessOrderPo
				.getSalesid()))) {
			sb.append(" and C_ST_CPOD_GlassesBillID  = ? ");
			params.add(consignProcessOrderPo.getSalesid());
		}	

		if(!"".equals(Utility.getName(consignProcessOrderPo.getCstcpogoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(consignProcessOrderPo.getCstcpogoodsname()));
		}
		
		sb.append(" group by C_ST_CPO_OrderBillId )temp ");

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	public ConsignProcessOrderPo searchSaleReam(String id){
		StringBuffer sb = new StringBuffer();

		List<String> params = new ArrayList<String>();
		sb.append("SELECT TOP 1 S_SE_SB_SalesRemark as cstcposalesremark,S_SE_SB_DignosisRe as cstcpodignosisre ");
		sb.append("FROM   dbo.S_SE_SalesBasic ");
		sb.append("WHERE  S_SE_SB_SalesID = ? ");
		params.add(Utility.getName(id));
		return (ConsignProcessOrderPo) queryForObject(sb.toString(), params
				.toArray(), ConsignProcessOrderPo.class);
	}
	public List<ConsignProcessOrderPo> getConsignProcessOrderList(
			ConsignProcessOrderPo consignProcessOrderPo, int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();

		List<String> params = new ArrayList<String>();
		int countPage = start + size;

		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from (select ROW_NUMBER() ");
		sb.append("Over(order by cstcpobilldate desc) as 'rowNum',* from ( select distinct ");
		sb.append("C_ST_CPO_OrderBillId as cstcpoorderbillid, ");
		sb.append("C_ST_CPO_BillDate as cstcpobilldate, ");
		sb.append("B_SP_SupplierName as bspsuppliername, ");
		sb.append("C_ST_CPO_OrderGoodsCategory as cstcpoordergoodscategory, ");
		sb.append("C_ST_CPO_AuditDate as cstcpoauditdate, ");
		sb.append("C_ST_CPO_AuditState as cstcpoauditstate, ");
		sb.append("a.personName as createPersonName, ");
		sb.append("b.personName as auditPersonName ");
		sb.append("from C_ST_ConsignProcessOrder left join B_Departments on B_DP_DepartmentID = C_ST_CPO_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo) a ");
		sb.append("on C_ST_CPO_CreatePerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo) b ");
		sb.append("on C_ST_CPO_AuditPerson=b.ID ");
		sb.append("inner join B_Supplier on B_SP_ID = C_ST_CPO_SupplierId ");
		sb.append(" inner join C_ST_ConsignProcessOrderDetails on C_ST_CPO_OrderBillId= C_ST_CPOD_OrderBillD inner join B_GoodsInfo on C_ST_CPOD_GoodsID=B_GI_GoodsID ");
		
		if(!"".equals(Utility.getName(consignProcessOrderPo.getSalesdjsbm()))){
			sb.append(" left join S_SE_SalesBasic on S_SE_SB_SalesID = C_ST_CPOD_GlassesBillID ");
		}
		
		sb.append("where 1 = 1 ");
		
		if (!"".equals(Utility.getName(consignProcessOrderPo.getCstcpocompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(consignProcessOrderPo.getCstcpocompanyid()));	
		}
		
		// 配镜单
		if (!"".equals(Utility.getName(consignProcessOrderPo
				.getSalesid()))) {
			sb.append("and C_ST_CPOD_GlassesBillID  = ? ");
			params.add(consignProcessOrderPo.getSalesid());
		}


		if(!"".equals(Utility.getName(consignProcessOrderPo.getSalesdjsbm()))){
			sb.append("and S_SE_SB_Djsbm like '%' + ? +'%'");
			params.add(consignProcessOrderPo.getSalesdjsbm());
		}
		
		if (!"".equals(Utility.getName(consignProcessOrderPo
				.getCstcpoorderbillid()))) {
			sb.append("and C_ST_CPO_OrderBillId like '%' + ? +'%' ");

			params.add(consignProcessOrderPo.getCstcpoorderbillid());
		}

		if (!"".equals(Utility.getName(consignProcessOrderPo
				.getCstcposupplierid()))) {
			sb.append("and C_ST_CPO_SupplierId = ? ");

			params.add(consignProcessOrderPo.getCstcposupplierid());
		}

		if (!"".equals(Utility.getName(consignProcessOrderPo
				.getCstcpostarttime()))
				&& !"".equals(Utility.getName(consignProcessOrderPo
						.getCstcpoendtime()))) {
			sb.append("and convert(varchar(10), C_ST_CPO_BillDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_CPO_BillDate, 23) <= ? ");

			params.add(consignProcessOrderPo.getCstcpostarttime());
			params.add(consignProcessOrderPo.getCstcpoendtime());
		} else if (!"".equals(Utility.getName(consignProcessOrderPo
				.getCstcpostarttime()))
				&& "".equals(Utility.getName(consignProcessOrderPo
						.getCstcpoendtime()))) {
			sb.append("and convert(varchar(10), C_ST_CPO_BillDate, 23) >= ? ");

			params.add(consignProcessOrderPo.getCstcpostarttime());
		} else if ("".equals(Utility.getName(consignProcessOrderPo
				.getCstcpostarttime()))
				&& !"".equals(Utility.getName(consignProcessOrderPo
						.getCstcpoendtime()))) {
			sb.append("and convert(varchar(10), C_ST_CPO_BillDate, 23) <= ? ");

			params.add(consignProcessOrderPo.getCstcpoendtime());
		}

		// 审核状态
		if (!"".equals(Utility.getName(consignProcessOrderPo
				.getCstcpoauditstate()))) {
			sb.append(" and C_ST_CPO_AuditState = ? ");

			params.add(consignProcessOrderPo.getCstcpoauditstate());
		}

		// 委外订单类型
		if (!"".equals(Utility.getName(consignProcessOrderPo
				.getCstcpoordergoodscategory()))) {
			sb.append(" and C_ST_CPO_OrderGoodsCategory = ? ");

			params.add(consignProcessOrderPo.getCstcpoordergoodscategory());
		}

		// 创建人
		if (!"".equals(Utility.getName(consignProcessOrderPo
				.getCreatePersonName()))) {
			sb.append(" and C_ST_CPO_CreatePerson ");
			sb.append(" IN (select ID from SYS_PersonInfo ");
			sb.append(" where personName like '%' + ? + '%') ");
			params.add(consignProcessOrderPo.getCreatePersonName());
		}

		// 审核人
		if (!"".equals(Utility.getName(consignProcessOrderPo
				.getAuditPersonName()))) {
			sb.append(" and C_ST_CPO_AuditPerson  ");
			sb.append(" IN (select ID from SYS_PersonInfo ");
			sb.append(" where personName like '%' + ? + '%') ");
			params.add(consignProcessOrderPo.getAuditPersonName());
		}
		
		if(!"".equals(Utility.getName(consignProcessOrderPo.getCstcpogoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(consignProcessOrderPo.getCstcpogoodsname()));
		}
		
		sb.append("group by C_ST_CPO_OrderBillId,C_ST_CPO_BillDate,B_SP_SupplierName,C_ST_CPO_OrderGoodsCategory,C_ST_CPO_AuditDate,");
				sb.append("C_ST_CPO_AuditState,a.personName, b.personName ");
		sb.append(" )table1 ) table1 where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append("set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),ConsignProcessOrderPo.class);
	}

	public void insertConsignProcessOrder(
			ConsignProcessOrderPo consignProcessOrderPo) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("INSERT INTO C_ST_ConsignProcessOrder ");
		buffer.append("(C_ST_CPO_OrderBillId ");
		buffer.append(",C_ST_CPO_BillDate ");
		buffer.append(",C_ST_CPO_OrderGoodsCategory ");
		buffer.append(",C_ST_CPO_SupplierId ");

		if ("1".equals(Utility.getName(consignProcessOrderPo
				.getCstcpoauditstate()))) {
			buffer.append(",C_ST_CPO_AuditPerson ");
			buffer.append(",C_ST_CPO_AuditDate ");
		}

		buffer.append(",C_ST_CPO_AuditState ");
		buffer.append(",C_ST_CPO_CreatePerson ");
		buffer.append(",C_ST_CPO_Remark,C_ST_CPO_TakeAddress,C_ST_CPO_TakePerson,C_ST_CPO_TakePhone,C_ST_CPO_TakeFax,C_ST_CPO_ReSalesRemark,C_ST_CPO_DepartmentID) ");

		List<String> params = new ArrayList<String>();

		if ("1".equals(Utility.getName(consignProcessOrderPo
				.getCstcpoauditstate()))) {
			buffer.append("VALUES (?, GETDATE(), ?, ?, ?, GETDATE(), ?, ?, ?, ?, ?, ?, ?, ? , ? )");

			params.add(consignProcessOrderPo.getCstcpoorderbillid());
			params.add(consignProcessOrderPo.getCstcpoordergoodscategory());
			params.add(consignProcessOrderPo.getCstcposupplierid());
			params.add(consignProcessOrderPo.getCstcpoauditperson());
			params.add(consignProcessOrderPo.getCstcpoauditstate());
			params.add(consignProcessOrderPo.getCstcpocreateperson());
			params.add(consignProcessOrderPo.getCstcporemark());			
			params.add(Utility.getName(consignProcessOrderPo.getCstcpodeliveryaddress()));
			params.add(Utility.getName(consignProcessOrderPo.getCstcpodeliveryperson()));
			params.add(Utility.getName(consignProcessOrderPo.getCstcpodeliveryphone()));
			params.add(Utility.getName(consignProcessOrderPo.getCstcpodeliveryfax()));
			params.add(Utility.getName(consignProcessOrderPo.getCstcporesalesremark()));
			params.add(Utility.getName(consignProcessOrderPo.getCstcpodeparmentid()));
			
		} else {
			buffer.append("VALUES (?, GETDATE(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			params.add(consignProcessOrderPo.getCstcpoorderbillid());
			params.add(consignProcessOrderPo.getCstcpoordergoodscategory());
			params.add(consignProcessOrderPo.getCstcposupplierid());
			params.add(consignProcessOrderPo.getCstcpoauditstate());
			params.add(consignProcessOrderPo.getCstcpocreateperson());
			params.add(consignProcessOrderPo.getCstcporemark());
			params.add(Utility.getName(consignProcessOrderPo.getCstcpodeliveryaddress()));
			params.add(Utility.getName(consignProcessOrderPo.getCstcpodeliveryperson()));
			params.add(Utility.getName(consignProcessOrderPo.getCstcpodeliveryphone()));
			params.add(Utility.getName(consignProcessOrderPo.getCstcpodeliveryfax()));
			params.add(Utility.getName(consignProcessOrderPo.getCstcporesalesremark()));
			params.add(Utility.getName(consignProcessOrderPo.getCstcpodeparmentid()));
		}

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void insertConsignProcessOrderDetails(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();

		buffer.append("INSERT INTO C_ST_ConsignProcessOrderDetails ");
		buffer.append("(C_ST_CPOD_Id ");
		buffer.append(",C_ST_CPOD_OrderBillD ");
		buffer.append(",C_ST_CPOD_GlassesBillID ");
		buffer.append(",C_ST_CPOD_ExpectedDate ");
		buffer.append(",C_ST_CPOD_OrderType ");
		buffer.append(",C_ST_CPOD_customerID ");
		buffer.append(",C_ST_CPOD_customerName ");
		buffer.append(",C_ST_CPOD_BillType ");
		buffer.append(",C_ST_CPOD_GlassFlag ");
		buffer.append(",C_ST_CPOD_GoodsID ");
		buffer.append(",C_ST_CPOD_BallGlass ");
		buffer.append(",C_ST_CPOD_PostGlass ");
		buffer.append(",C_ST_CPOD_Axes ");
		buffer.append(",C_ST_CPOD_Add ");
		buffer.append(",C_ST_CPOD_ArriseGlass ");
		buffer.append(",C_ST_CPOD_Basis ");
		buffer.append(",C_ST_CPOD_EyeCurvature ");
		buffer.append(",C_ST_CPOD_Diameter ");
		buffer.append(",C_ST_CPOD_ArrivedDate ");
		buffer.append(",C_ST_CPOD_Requirement ");
		buffer.append(",C_ST_CPOD_Num ");
		buffer.append(",C_ST_CPOD_State ");
		buffer.append(",C_ST_CPOD_DragsType,C_ST_CPOD_SalesBillID,C_ST_CPOD_SalesID,C_ST_CPOD_Inter,C_ST_CPOD_InterDistance) ");
		buffer.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,?,?,?,?)");

		List<String> params = new ArrayList<String>();

		params.add(uuid.getInstance().generate());
		params.add(consignProcessOrderDetailsPo.getCstcpodorderbilld());
		params.add(consignProcessOrderDetailsPo.getCstcpodglassesbillid());
		params.add(consignProcessOrderDetailsPo.getCstcpodexpecteddate());
		params.add(consignProcessOrderDetailsPo.getCstcpodordertype());
		params.add(consignProcessOrderDetailsPo.getCstcpodcustomerid());
		params.add(consignProcessOrderDetailsPo.getCstcpodcustomername());
		params.add(consignProcessOrderDetailsPo.getCstcpodbilltype());
		params.add(consignProcessOrderDetailsPo.getCstcpodglassflag());
		params.add(consignProcessOrderDetailsPo.getCstcpodgoodsid());
		params.add(consignProcessOrderDetailsPo.getCstcpodballglass());
		params.add(consignProcessOrderDetailsPo.getCstcpodpostglass());
		params.add(consignProcessOrderDetailsPo.getCstcpodaxes());
		params.add(consignProcessOrderDetailsPo.getCstcpodadd());
		params.add(consignProcessOrderDetailsPo.getCstcpodarriseglass());
		params.add(consignProcessOrderDetailsPo.getCstcpodbasis());
		params.add(consignProcessOrderDetailsPo.getCstcpodeyecurvature());
		params.add(consignProcessOrderDetailsPo.getCstcpoddiameter());
		params.add(consignProcessOrderDetailsPo.getCstcpodarriveddate());
		params.add(consignProcessOrderDetailsPo.getCstcpodrequirement());
		params.add(consignProcessOrderDetailsPo.getCstcpodnum());
		params.add(consignProcessOrderDetailsPo.getCstcpodstate());
		params.add(consignProcessOrderDetailsPo.getCstcpoddragstype());
		params.add(consignProcessOrderDetailsPo.getCstcpodsalesbillid());
		params.add(Utility.getName(consignProcessOrderDetailsPo.getCstcpodsalesid()));
		params.add(Utility.getName(consignProcessOrderDetailsPo.getCstcpodinter()));
		params.add(Utility.getName(consignProcessOrderDetailsPo.getCstcpodinterdistance()));
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public ConsignProcessOrderPo getConsignProcessOrder(
			ConsignProcessOrderPo consignProcessOrderPo) {

		StringBuffer sb = new StringBuffer();

		sb.append("SELECT top 1 ");
		sb.append("C_ST_CPO_OrderBillId as CSTCPOOrderBillId, ");
		sb.append("C_ST_CPO_BillDate as CSTCPOBillDate, ");
		sb.append("B_SP_SupplierName as BSPSupplierName, ");
		sb.append("C_ST_CPO_SupplierId as CSTCPOSupplierId, ");
		sb.append("C_ST_CPO_OrderGoodsCategory as CSTCPOOrderGoodsCategory, ");
		sb.append("C_ST_CPO_AuditState as CSTCPOAuditState, ");
		sb.append("a.personName as createPersonName, ");
		sb.append("C_ST_CPO_SalesRemark as cstcposalesremark, ");
		sb.append("C_ST_CPO_Remark as CSTCPORemark ,C_ST_CPO_Dignosisre as cstcpodignosisre, ");
		sb.append("b.personName as auditPersonName,C_ST_CPO_TakeAddress as cstcpodeliveryaddress,C_ST_CPO_TakePerson as cstcpodeliveryperson,C_ST_CPO_TakePhone as cstcpodeliveryphone,C_ST_CPO_TakeFax as cstcpodeliveryfax ");
		sb.append("from C_ST_ConsignProcessOrder ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo) a on C_ST_CPO_CreatePerson=a.ID ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo) b on C_ST_CPO_AuditPerson=b.ID ");
		sb.append("inner join B_Supplier on B_SP_ID = C_ST_CPO_SupplierId ");
		sb.append("where C_ST_CPO_OrderBillId = ? ");

		List<String> params = new ArrayList<String>();
		params.add(consignProcessOrderPo.getCstcpoorderbillid());

		return (ConsignProcessOrderPo) queryForObject(sb.toString(), params
				.toArray(), ConsignProcessOrderPo.class);
	}
	//////////////////////////委外未采购订单新增///////////////////////
	public ConsignProcessOrderPo getConsignProcessOrderSeles(
			ConsignProcessOrderPo consignProcessOrderPo) {

		StringBuffer sb = new StringBuffer();

		sb.append("SELECT top 1 ");
		sb.append("C_ST_CPO_OrderBillId as CSTCPOOrderBillId, ");
		sb.append("C_ST_CPO_BillDate as CSTCPOBillDate, ");
		sb.append("B_SP_SupplierName as BSPSupplierName, ");
		sb.append("C_ST_CPO_SupplierId as CSTCPOSupplierId, ");
		sb.append("C_ST_CPO_OrderGoodsCategory as CSTCPOOrderGoodsCategory, ");
		sb.append("C_ST_CPO_AuditState as CSTCPOAuditState, ");
		sb.append("a.personName as createPersonName, ");
		sb.append("C_ST_CPO_Remark as CSTCPORemark , ");
		sb.append("b.personName as auditPersonName ");
		sb.append("from C_ST_ConsignProcessOrder ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo) a on C_ST_CPO_CreatePerson=a.ID ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo) b on C_ST_CPO_AuditPerson=b.ID ");
		sb.append("inner join B_Supplier on B_SP_ID = C_ST_CPO_SupplierId ");
		sb.append("where C_ST_CPO_OrderBillId = ? ");

		List<String> params = new ArrayList<String>();
		params.add(consignProcessOrderPo.getSalesid());

		return (ConsignProcessOrderPo) queryForObject(sb.toString(), params.toArray(), ConsignProcessOrderPo.class);
	}

	public List<ConsignProcessOrderDetailsPo> getConsignProcessOrderDetailsList(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo) {

		StringBuffer sb = new StringBuffer();

		sb.append("SELECT * ");
		sb.append("FROM   (SELECT C_ST_CPOD_Id            AS CSTCPODId, ");
		sb.append("                        1              AS orderbySX, ");
		sb.append("               C_ST_CPOD_OrderBillD    AS CSTCPODOrderBillD, ");
		sb.append("               C_ST_CPOD_GlassesBillID AS CSTCPODGlassesBillID, ");
		sb.append("               C_ST_CPOD_ExpectedDate  AS CSTCPODExpectedDate, ");
		sb.append("               C_ST_CPOD_OrderType     AS CSTCPODOrderType, ");
		sb.append("               C_ST_CPOD_customerID    AS CSTCPODcustomerID, ");
		sb.append("               C_ST_CPOD_customerName  AS cstcpodcustomername, ");
		sb.append("               C_ST_CPOD_BillType      AS CSTCPODBillType, ");
		sb.append("               C_ST_CPOD_GlassFlag     AS CSTCPODGlassFlag, ");
		sb.append("               C_ST_CPOD_GoodsID       AS CSTCPODGoodsID, ");
		sb.append("               C_ST_CPOD_BallGlass     AS CSTCPODBallGlass, ");
		sb.append("               C_ST_CPOD_PostGlass     AS CSTCPODPostGlass, ");
		sb.append("               C_ST_CPOD_Axes          AS CSTCPODAxes, ");
		sb.append("               C_ST_CPOD_Add           AS CSTCPODAdd, ");
		sb.append("               C_ST_CPOD_ArriseGlass   AS CSTCPODArriseGlass, ");
		sb.append("               isnull(F_OP_ParamName,'')         AS CSTCPODBasis, ");
		sb.append("               C_ST_CPOD_EyeCurvature  AS CSTCPODEyeCurvature, ");
		sb.append("               C_ST_CPOD_Diameter      AS CSTCPODDiameter, ");
		sb.append("               C_ST_CPOD_Inter         AS cstcpodinter, ");
		sb.append("               C_ST_CPOD_InterDistance         AS cstcpodinterdistance, ");
		sb.append("               C_ST_CPOD_ArrivedDate   AS CSTCPODArrivedDate, ");
		sb.append("               C_ST_CPOD_Requirement   AS CSTCPODRequirement, ");
		sb.append("               C_ST_CPOD_Num           AS CSTCPODNum, ");
		sb.append("               C_ST_CPOD_State         AS CSTCPODState, ");
		sb.append("               B_GI_ViewGoodsName      AS cstcpodgoodsname, ");
		sb.append("               C_ST_CPOD_Requirement1  AS cstcpodrequirement1, ");
		sb.append("               C_ST_CPOD_DragsType     AS cstcpoddragstype, ");
		sb.append("               C_ST_CPOD_SalesBillID   AS cstcpodsalesbillid, ");
		sb.append("               C_ST_CPOD_SalesID       AS cstcpodsalesid, ");
		sb.append("               ''                      AS cstcposalesremark, ");
		sb.append("               ''                      AS cstcpodignosisre, ");
		sb.append("               ''                      AS ssesbglasshige, ");
		sb.append("               ''                      AS ssesbglasswigth, ");
		sb.append("               ''                      AS ssesbframemiddlesize, ");
		sb.append("               ''                      AS ssesbgalssroad, ");
		sb.append("               ''                      AS ssesbgiagonalline, ");
		sb.append("               ''                      AS ssesbframeform, ");
		sb.append("               ''                      AS ssesbframedia ");
		sb.append("        FROM   C_ST_ConsignProcessOrderDetails ");
		sb.append("               INNER JOIN B_GoodsInfo ");
		sb.append("                 ON C_ST_CPOD_GoodsID = B_GoodsInfo.B_GI_GoodsID ");
		sb.append("               left join (select F_OP_ParamID,F_OP_ParamName from F_OptionParam where F_OP_ParentID = '24')fo on C_ST_CPOD_Basis = F_OP_ParamID ");   // 获取基底
		sb.append("        WHERE  C_ST_CPOD_OrderBillD = ? ");
		sb.append("        UNION ALL ");
		sb.append("        SELECT DISTINCT ''                      AS CSTCPODId, ");
		sb.append("                        2                       AS orderbySX, ");
		sb.append("                        ''                      AS CSTCPODOrderBillD, ");
		sb.append("                        S_SE_SB_SalesID         AS CSTCPODGlassesBillID, ");
		sb.append("                        ''                      AS CSTCPODExpectedDate, ");
		sb.append("                        ''                      AS CSTCPODOrderType, ");
		sb.append("                        ''                      AS CSTCPODcustomerID, ");
		sb.append("                        ''                      AS cstcpodcustomername, ");
		sb.append("                        ''                      AS CSTCPODBillType, ");
		sb.append("                        ''                      AS CSTCPODGlassFlag, ");
		sb.append("                        ''                      AS CSTCPODGoodsID, ");
		sb.append("                        ''                      AS CSTCPODBallGlass, ");
		sb.append("                        ''                      AS CSTCPODPostGlass, ");
		sb.append("                        ''                      AS CSTCPODAxes, ");
		sb.append("                        ''                      AS CSTCPODAdd, ");
		sb.append("                        ''                      AS CSTCPODArriseGlass, ");
		sb.append("                        ''                      AS CSTCPODBasis, ");
		sb.append("                        ''                      AS CSTCPODEyeCurvature, ");
		sb.append("                        ''                      AS CSTCPODDiameter, ");
		sb.append("                        ''                      AS cstcpodinter, ");
		sb.append("                        ''                      AS cstcpodinterdistance, ");
		sb.append("                        ''                      AS CSTCPODArrivedDate, ");
		sb.append("                        ''                      AS CSTCPODRequirement, ");
		sb.append("                        ''                      AS CSTCPODNum, ");
		sb.append("                        ''                      AS CSTCPODState, ");
		sb.append("                        ''                      AS cstcpodgoodsname, ");
		sb.append("                        ''                      AS cstcpodrequirement1, ");
		sb.append("                        ''                      AS cstcpoddragstype, ");
		sb.append("                        ''                      AS cstcpodsalesbillid, ");
		sb.append("                        ''                      AS cstcpodsalesid, ");
		sb.append("                REPLACE(S_SE_SB_SalesRemark, CHAR(13) + CHAR(10), '') AS cstcposalesremark, ");
		sb.append("                REPLACE(S_SE_SB_DignosisRe, CHAR(13) + CHAR(10), '')  AS cstcpodignosisre, ");
		sb.append("                        S_SE_SB_Glasshige       AS ssesbglasshige, ");
		sb.append("                        S_SE_SB_Glasswigth      AS ssesbglasswigth, ");
		sb.append("                        S_SE_SB_Framemiddlesize AS ssesbframemiddlesize, ");
		sb.append("                        S_SE_SB_Galssroad       AS ssesbgalssroad, ");
		sb.append("                        S_SE_SB_Diagonalline    AS ssesbgiagonalline, ");
		sb.append("                        S_SE_SB_Frameform       AS ssesbframeform, ");
		sb.append("                        S_SE_SB_Framedia       AS ssesbframedia ");
		sb.append("        FROM   dbo.S_SE_SalesBasic ");
		sb.append("               INNER JOIN S_SE_SalesDetail ");
		sb.append("                 ON S_SE_SalesDetail.S_SE_SD_SalesID = S_SE_SalesBasic.S_SE_SB_SalesID ");
		sb.append("        WHERE  S_SE_SB_SalesID IN (SELECT C_ST_CPOD_GlassesBillID ");
		sb.append("                                   FROM   C_ST_ConsignProcessOrderDetails ");
		sb.append("                                   WHERE  C_ST_CPOD_OrderBillD = ? ");
		sb.append("                                   GROUP  BY C_ST_CPOD_GlassesBillID)) AS TEMP order by CSTCPODGlassesBillID,orderbySX,CSTCPODGlassFlag desc ");

		List<String> params = new ArrayList<String>();
		params.add(consignProcessOrderDetailsPo.getCstcpodorderbilld());
		params.add(consignProcessOrderDetailsPo.getCstcpodorderbilld());

		return queryForObjectList(sb.toString(), params.toArray(),
				ConsignProcessOrderDetailsPo.class);
	}
	
	///////////////////////////////委外未采购订单新增////////////////////////////////////////
	public List<ConsignProcessOrderDetailsPo> getConsignProcessOrderSelesDetailsList(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo) {

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * ");
		sb.append("FROM   (SELECT S_SE_SD_ID                                                   AS cstcpodsalesid, ");
		sb.append("               '1'                                                          AS oederbyPx, ");
		sb.append("               S_SE_SalesBasic.S_SE_SB_TakeGlassData                        AS cstcpodarriveddate, ");
		sb.append("               S_ME_CustomerInfo.S_ME_CI_CustomerID                         AS cstcpodcustomerid, ");
		sb.append("               S_SE_SalesBasic.S_SE_SB_SalesID                              AS cstcpodglassesbillid, ");
		sb.append("               S_ME_CustomerInfo.S_ME_CI_Name                               AS cstcpodcustomername, ");
		sb.append("               S_SE_SalesDetail.S_SE_SD_SalesItemID                         AS cstcpodgoodsid, ");
		sb.append("               S_SE_SalesDetail.S_SE_SD_ItemID                              AS cstcpodgoodsbarcode, ");
		sb.append("               S_SE_SalesBasic.S_SE_SB_OrdersType                           AS cstcpodbilltype, ");
		sb.append("               S_SE_SalesDetail.S_SE_SD_GlassFlag                           AS cstcpodglassflag, ");
		sb.append("               S_SE_SalesDetail.S_SE_SD_SalesItemName                       AS cstcpodgoodsname, ");
		sb.append("               S_SE_SalesDetail.S_SE_SD_Number                              AS cstcpodnum, ");
		sb.append("CASE WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = 'R' THEN S_SE_SalesBasic.S_SE_SB_InterHighOD  ELSE S_SE_SalesBasic.S_SE_SB_InterHighOS  END AS cstcpodinter,");
		sb.append("CASE WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = 'R' THEN S_SE_SalesBasic.S_SE_SB_InterDistanceOD ELSE S_SE_SalesBasic.S_SE_SB_InterDistanceOS  END  AS cstcpodinterdistance,");

		sb.append("               CASE ");		
		sb.append("                 WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = 'R' THEN S_SE_SalesBasic.S_SE_SB_BallGlassOD ");
		sb.append("                 ELSE S_SE_SalesBasic.S_SE_SB_BallGlassOS ");
		sb.append("               END                                                          AS cstcpodballglass, ");
		sb.append("               CASE ");
		sb.append("                 WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = 'R' THEN S_SE_SalesBasic.S_SE_SB_PostGlassOD ");
		sb.append("                 ELSE S_SE_SalesBasic.S_SE_SB_PostGlassOS ");
		sb.append("               END                                                          AS cstcpodpostglass, ");
		sb.append("               CASE ");
		sb.append("                 WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = 'R' THEN S_SE_SalesBasic.S_SE_SB_AxesOD ");
		sb.append("                 ELSE S_SE_SalesBasic.S_SE_SB_AxesOS ");
		sb.append("               END                                                          AS cstcpodaxes, ");
		sb.append("               CASE ");
		sb.append("                 WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = 'R' THEN S_SE_SalesBasic.S_SE_SB_ADDOD ");
		sb.append("                 ELSE S_SE_SalesBasic.S_SE_SB_ADDOS ");
		sb.append("               END                                                          AS cstcpodadd, ");
		sb.append("               CASE ");
		sb.append("                 WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = 'R' THEN S_SE_SalesBasic.S_SE_SB_ArriseGlassOD1 ");
		sb.append("                 ELSE S_SE_SalesBasic.S_SE_SB_ArriseGlassOS1 ");
		sb.append("               END                                                          AS cstcpodarriseglass, ");
		sb.append("               CASE ");
		sb.append("                 WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = 'R' THEN isnull(odfo.F_OP_ParamName,'') ");
		sb.append("                 ELSE isnull(osfo.F_OP_ParamName,'') ");
		sb.append("               END                                                          AS cstcpodbasis, ");
		sb.append("               CASE ");
		sb.append("                 WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = 'R' THEN S_SE_SalesBasic.S_SE_SB_EyeCurvatureOD1 ");
		sb.append("                 ELSE S_SE_SalesBasic.S_SE_SB_EyeCurvatureOS1 ");
		sb.append("               END                                                          AS cstcpodeyecurvature, ");
		sb.append("               CASE ");
		sb.append("                 WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = 'R' THEN S_SE_SalesBasic.S_SE_SB_DiameterOD ");
		sb.append("                 ELSE S_SE_SalesBasic.S_SE_SB_DiameterOS ");
		sb.append("               END                                                          AS cstcpoddiameter, ");
		sb.append("               (SELECT dbo.Getrequirement(S_SE_SalesBasic.S_SE_SB_SalesID)) AS cstcpodrequirement, ");
		sb.append("               CASE ");
		sb.append("                 WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = 'R' THEN (SELECT dbo.Getrequirement2(S_SE_SalesBasic.S_SE_SB_SalesID, 'l')) ");
		sb.append("                 WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = 'l' THEN (SELECT dbo.Getrequirement2(S_SE_SalesBasic.S_SE_SB_SalesID, 'r')) ");
		sb.append("               END                                                          AS cstcpodrequirement1, ");
		sb.append("               CASE ");
		sb.append("                 WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = 'R' THEN (SELECT dbo.Getrequirementsid(S_SE_SalesBasic.S_SE_SB_SalesID, 'R')) ");
		sb.append("                 WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = 'l' THEN (SELECT dbo.Getrequirementsid(S_SE_SalesBasic.S_SE_SB_SalesID, 'l')) ");
		sb.append("                 WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = '' THEN (SELECT dbo.Getrequirementsid(S_SE_SalesBasic.S_SE_SB_SalesID, 'p')) ");
		sb.append("               END                                                          AS cstcpodrequirement2, ");
		sb.append("               S_SE_SB_DragsType                                            AS cstcpoddragstype, ");
		sb.append("               ''                                                           AS cstcposalesremark, ");
		sb.append("               ''                                                           AS cstcpodignosisre, ");
		sb.append("               ''                                                           AS ssesbglasshige, ");
		sb.append("               ''                                                           AS ssesbglasswigth, ");
		sb.append("               ''                                                           AS ssesbframemiddlesize, ");
		sb.append("               ''                                                           AS ssesbgalssroad, ");
		sb.append("               ''                                                           AS ssesbgiagonalline, ");
		sb.append("               ''                                                           AS ssesbframeform, ");
		sb.append("               ''                                                           AS ssesbframedia ");
		sb.append("        FROM   S_SE_SalesDetail ");
		sb.append("               INNER JOIN S_SE_SalesBasic ");
		sb.append("                 ON S_SE_SalesDetail.S_SE_SD_SalesID = S_SE_SalesBasic.S_SE_SB_SalesID ");
		sb.append("               INNER JOIN B_GoodsInfo ");
		sb.append("                 ON S_SE_SalesDetail.S_SE_SD_SalesItemID = B_GoodsInfo.B_GI_GoodsID ");
		sb.append("               INNER JOIN S_ME_CustomerInfo ");
		sb.append("                 ON S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		sb.append("               left join (select F_OP_ParamID,F_OP_ParamName from F_OptionParam where F_OP_ParentID = '24')odfo on S_SE_SalesBasic.S_SE_SB_BasisOD1 = odfo.F_OP_ParamID ");   // 获取基底
		sb.append("               left join (select F_OP_ParamID,F_OP_ParamName from F_OptionParam where F_OP_ParentID = '24')osfo on S_SE_SalesBasic.S_SE_SB_BasisOS1 = osfo.F_OP_ParamID ");   // 获取基底
		sb.append("        WHERE  1 = 1 ");
		sb.append("               AND B_GI_isCustomize = 'D' ");
		sb.append("               AND S_SE_SalesDetail.S_SE_SD_SalesID = ? ");
		sb.append("               AND ( S_SE_SalesDetail.S_SE_SD_GlassFlag = 'R' ");
		sb.append("                      OR S_SE_SalesDetail.S_SE_SD_GlassFlag = 'L' ) ");
		sb.append("        UNION ALL ");
		sb.append("        SELECT DISTINCT ''                      AS cstcpodsalesid, ");
		sb.append("                        '2'                     AS oederbyPx, ");
		sb.append("                        ''                      AS cstcpodarriveddate, ");
		sb.append("                        ''                      AS cstcpodcustomerid, ");
		sb.append("                        S_SE_SB_SalesID         AS cstcpodglassesbillid, ");
		sb.append("                        ''                      AS cstcpodcustomername, ");
		sb.append("                        ''                      AS cstcpodgoodsid, ");
		sb.append("                        ''                      AS cstcpodgoodsbarcode, ");
		sb.append("                        ''                      AS cstcpodbilltype, ");
		sb.append("                        ''                      AS cstcpodglassflag, ");
		sb.append("                        ''                      AS cstcpodgoodsname, ");
		sb.append("                        0                       AS cstcpodnum, ");
		sb.append("                        ''                      AS cstcpodinter, ");
		sb.append("                        ''                      AS cstcpodinterdistance, ");
		sb.append("                        ''                      AS cstcpodballglass, ");
		sb.append("                        ''                      AS cstcpodpostglass, ");
		sb.append("                        ''                      AS cstcpodaxes, ");
		sb.append("                        ''                      AS cstcpodadd, ");
		sb.append("                        ''                      AS cstcpodarriseglass, ");
		sb.append("                        ''                      AS cstcpodbasis, ");
		sb.append("                        ''                      AS cstcpodeyecurvature, ");
		sb.append("                        ''                      AS cstcpoddiameter, ");
		sb.append("                        ''                      AS cstcpodrequirement, ");
		sb.append("                        ''                      AS cstcpodrequirement1, ");
		sb.append("                        ''                      AS cstcpodrequirement2, ");
		sb.append("                        ''                      AS cstcpoddragstype, ");
		sb.append("                REPLACE(S_SE_SB_SalesRemark, CHAR(13) + CHAR(10), '') AS cstcposalesremark, ");
		sb.append("                REPLACE(S_SE_SB_DignosisRe, CHAR(13) + CHAR(10), '')  AS cstcpodignosisre, ");
		sb.append("                        S_SE_SB_Glasshige       AS ssesbglasshige, ");
		sb.append("                        S_SE_SB_Glasswigth      AS ssesbglasswigth, ");
		sb.append("                        S_SE_SB_Framemiddlesize AS ssesbframemiddlesize, ");
		sb.append("                        S_SE_SB_Galssroad       AS ssesbgalssroad, ");
		sb.append("                        S_SE_SB_Diagonalline    AS ssesbgiagonalline, ");
		sb.append("                        S_SE_SB_Frameform       AS ssesbframeform, ");
		sb.append("                        S_SE_SB_FrameDia       AS ssesbframedia ");
		sb.append("        FROM   dbo.S_SE_SalesBasic ");
		sb.append("               INNER JOIN S_SE_SalesDetail ");
		sb.append("                 ON S_SE_SalesDetail.S_SE_SD_SalesID = S_SE_SalesBasic.S_SE_SB_SalesID ");
		sb.append("        WHERE  S_SE_SB_SalesID = ?) AS TEMP ");
		sb.append("ORDER  BY cstcpodglassesbillid, ");
		sb.append("          oederbyPx,cstcpodglassflag desc ");
		List<String> params = new ArrayList<String>();
		params.add(consignProcessOrderDetailsPo.getCstcpodglassesbillid());
		params.add(consignProcessOrderDetailsPo.getCstcpodglassesbillid());

		return queryForObjectList(sb.toString(), params.toArray(),ConsignProcessOrderDetailsPo.class);
	}

	public void updateConsignProcessOrder(
			ConsignProcessOrderPo consignProcessOrderPo) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("UPDATE C_ST_ConsignProcessOrder ");
		sb.append("SET ");
		if ("1".equals(Utility.getName(consignProcessOrderPo
				.getCstcpoauditstate()))) {
			sb.append("C_ST_CPO_AuditPerson = ?, ");
			sb.append("C_ST_CPO_AuditState = ?, ");
			sb.append("C_ST_CPO_AuditDate = GETDATE(), ");

			params.add(consignProcessOrderPo.getCstcpoauditperson());
			params.add(consignProcessOrderPo.getCstcpoauditstate());
		}
		sb.append("C_ST_CPO_Remark = ?,C_ST_CPO_TakeAddress=?,C_ST_CPO_TakePerson=?,C_ST_CPO_TakePhone=?,C_ST_CPO_TakeFax=? ");
		sb.append("WHERE C_ST_CPO_OrderBillId = ?");

		params.add(consignProcessOrderPo.getCstcporemark());
		params.add(Utility.getName(consignProcessOrderPo.getCstcpodeliveryaddress()));
		params.add(Utility.getName(consignProcessOrderPo.getCstcpodeliveryperson()));
		params.add(Utility.getName(consignProcessOrderPo.getCstcpodeliveryphone()));
		params.add(Utility.getName(consignProcessOrderPo.getCstcpodeliveryfax()));
		params.add(consignProcessOrderPo.getCstcpoorderbillid());

		getJdbcTemplate().update(sb.toString(), params.toArray());

	}

	public void delConsignProcessOrder(String id) {
		// TODO Auto-generated method stub

		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM C_ST_ConsignProcessOrder ");
		buffer.append("WHERE C_ST_CPO_OrderBillId = ?");

		List<String> params = new ArrayList<String>();
		params.add(id);

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void delConsignProcessOrderDetails(String id) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM C_ST_ConsignProcessOrderDetails ");
		buffer.append("WHERE C_ST_CPOD_OrderBillD = ?");

		List<String> params = new ArrayList<String>();
		params.add(id);

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 更新销售基表中的在途点
	 * 
	 * @param salesDetailPo
	 */
	public void updateMaterialsInTransit(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("update S_SE_SalesBasic ");
		buffer.append("set S_SE_SB_InTransit= ? ");
		buffer.append("where S_SE_SB_SalesID= ? ");

		params.add(salesBasicPo.getSsesbintransit());
		params.add(salesBasicPo.getSsesbsalesid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 根据销售单号将信息插入在途明细表中
	 * 
	 * @param inTransitPo
	 */
	public void insertIntrnsitInfo(InTransitPo inTransitPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into S_SE_InTransit( ");
		buffer.append("S_SE_IT_ID, S_SE_IT_SalesID, S_SE_IT_State ");
		buffer.append(", S_SE_IT_Date, S_SE_IT_CreatePerson ");
		buffer.append(", S_SE_IT_Department,S_SE_IT_YsalesID ) ");
		buffer.append("values (? , ? , ? , getdate() , ? , ?, ?) ");

		params.add(this.uuid.generate());
		params.add(inTransitPo.getSseitsalesid());
		params.add(inTransitPo.getSseitstate());
		params.add(inTransitPo.getSseitcreateperson());
		params.add(inTransitPo.getSseitdepartment());
		params.add(Utility.getName(inTransitPo.getSseitysalesid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void consignimportOrders(String poID) {
		String sql = "exec SP_ConsignimportOrders ? ";

		getJdbcTemplate().update(sql, new String[] { poID });
	}
	
	public void consignimportSpecialDetails(String salesid) {
		StringBuffer  varname1 = new StringBuffer();
		varname1.append("set XACT_ABORT on INSERT INTO orders.orders.dbo.S_SE_SS_SalesSpecial ");
		varname1.append("SELECT * ");
		varname1.append("FROM   S_SE_SS_SalesSpecial ");
		varname1.append("WHERE  S_SE_SS_SalesID = ? ");

		getJdbcTemplate().update(varname1.toString(), new String[] { salesid });
	}
	
	
	
	
	
	
	
	

}
