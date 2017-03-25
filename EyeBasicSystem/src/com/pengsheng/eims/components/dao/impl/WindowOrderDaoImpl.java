package com.pengsheng.eims.components.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.components.dao.WindowOrderDao;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * 订单开窗dao实现类
 */
public class WindowOrderDaoImpl extends BaseJdbcDaoSupport implements
		WindowOrderDao {
	/**
	 * 采购订单的未核销商品数量
	 * 
	 * @param po
	 *            订单po
	 * @return int 数量
	 */
	public int getProcurementOrdersCount(ProcurementOrdersPo po) {

		StringBuffer sb = new StringBuffer();

		List<String> params = new ArrayList<String>();

		sb
				.append("select count(c.goodsid) from(select b.cstpid,b.goodsid,sum(b.goodsquantity) as goodsquantity from( ");
		sb
				.append("select ROW_NUMBER() Over(order by a.goodsid) as num,a.cstpid as cstpid,a.goodsid as goodsid,a.goodsquantity as goodsquantity from( ");
		sb
				.append("select C_ST_PE_PurchaseOrderID as cstpid,C_ST_PE_goodsID as goodsid,C_ST_PE_OrderNumber as goodsquantity from C_ST_PoEntry ");
		sb
				.append(" inner join C_ST_PO ON C_ST_P_ID = C_ST_PE_PurchaseOrderID and C_ST_P_AuditState = 1 ");
		sb.append(" where C_ST_PoEntry.C_ST_PE_PurchaseOrderID=? ");
		sb
				.append("union all select C_ST_V_PoID as cstpid,C_ST_V_GoodsId as goodsid,-C_ST_V_Num as goodsquantity from C_ST_Verification ");
		sb.append("  inner join C_ST_PO ON C_ST_P_ID = C_ST_V_PoID ");

		sb.append(" where C_ST_V_PoID=? )a)b  group by b.goodsid,b.cstpid)c ");
		sb.append("inner join C_ST_PO on c.cstpid=C_ST_P_ID ");
		sb
				.append("inner join B_GoodsInfo on c.goodsid=B_GoodsInfo.B_GI_GoodsID ");
		sb
				.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb
				.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		// sb
		// .append("inner join B_Variety on B_GoodsInfo.B_GI_VarietyID=B_Variety.B_VY_ID and B_GoodsInfo.B_GI_BrandID=B_Variety.B_VY_BrandID and B_GoodsInfo.B_GI_SupplierID=B_Variety.B_VY_SupplierID and B_GoodsInfo.B_GI_GoodsCategoryID=B_Variety.B_VY_GcID ");
		sb
				.append("inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id  ");
		sb
				.append("where c.goodsquantity>0 and C_ST_P_BillTypeId=?  and C_ST_P_SupplierId=? ");

		params.add(po.getCstpid());
		params.add(po.getCstpid());
		params.add(po.getCstpbilltypeid());
		params.add(po.getCstpsupplierid());

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 采购订单的未核销商品list
	 * 
	 * @param po
	 *            订单po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsInfoPo> getProcurementOrdersList(ProcurementOrdersPo po,
			int start, int size) {

		StringBuffer sb = new StringBuffer();

		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
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
		sb
				.append("from(select ROW_NUMBER() Over(order by B_GoodsInfo.B_GI_GoodsID) as rowNum,");
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

		sb.append(" where C_ST_PoEntry.C_ST_PE_PurchaseOrderID=?  ");
		sb
				.append("union all select C_ST_V_PoID as cstpid,C_ST_V_GoodsId as goodsid,-C_ST_V_Num as goodsquantity from C_ST_Verification ");
		sb.append("  inner join C_ST_PO ON C_ST_P_ID = C_ST_V_PoID ");

		sb.append("where C_ST_V_PoID=?  )a)b  group by b.goodsid,b.cstpid)c ");
		sb.append("inner join C_ST_PO on c.cstpid=C_ST_P_ID ");
		sb
				.append("inner join B_GoodsInfo on c.goodsid=B_GoodsInfo.B_GI_GoodsID ");
		sb
				.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb
				.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		// sb
		// .append("inner join B_Variety on B_GoodsInfo.B_GI_VarietyID=B_Variety.B_VY_ID and B_GoodsInfo.B_GI_BrandID=B_Variety.B_VY_BrandID and B_GoodsInfo.B_GI_SupplierID=B_Variety.B_VY_SupplierID and B_GoodsInfo.B_GI_GoodsCategoryID=B_Variety.B_VY_GcID ");
		sb
				.append("inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id  ");
		sb
				.append("where c.goodsquantity>0 and C_ST_P_BillTypeId=?  and C_ST_P_SupplierId=?  ");
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");

		params.add(po.getCstpid());
		params.add(po.getCstpid());
		params.add(po.getCstpbilltypeid());
		params.add(po.getCstpsupplierid());

		return queryForObjectList(sb.toString(), params.toArray(),
				GoodsInfoPo.class);
	}

	/**
	 * 未核销的采购订单数量
	 * 
	 * @param po
	 *            订单po
	 * @return int 数量
	 */
	public int getProcurementOrdersForCount(ProcurementOrdersPo po) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(C_ST_P_ID) from C_ST_Po left join B_Departments on C_ST_P_DepartmentID = B_DP_DepartmentID ");
		sb.append(" where 1 = 1 and C_ST_P_AuditState=1 ");
		
		if (!"".equals(Utility.getName(po.getCstpcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCstpcompanyid()));	
		}
		
		sb.append(" and C_ST_P_ID in( ");
		sb.append(" select distinct b.cstpid from( ");
		sb
				.append(" select a.cstpid,a.goodsid,sum(a.goodsquantity) as goodsquantity ");
		sb
				.append(" from(select C_ST_PE_PurchaseOrderID as cstpid,C_ST_PE_goodsID as goodsid, ");
		sb.append(" C_ST_PE_OrderNumber as goodsquantity from C_ST_PoEntry ");
		sb
				.append(" inner join C_ST_PO ON C_ST_P_ID = C_ST_PE_PurchaseOrderID and C_ST_P_AuditState = 1 ");
		sb.append("  union all select C_ST_V_PoID as cstpid,C_ST_V_GoodsId as goodsid,-C_ST_V_Num as goodsquantity ");
		sb.append("  from C_ST_Verification ");
		sb.append("  inner join C_ST_PO ON C_ST_P_ID = C_ST_V_PoID ");
		sb.append(" )a group by a.goodsid,a.cstpid ");
		sb.append(" )b where b.goodsquantity>0 )");

		if (!"".equals(Utility.getName(po.getCstpid()))) {
			sb.append("and C_ST_P_ID like '%' + ? + '%' ");

			params.add(po.getCstpid());
		}

		if (!"".equals(Utility.getName(po.getCstpgoodscategory()))) {
			sb.append("and C_ST_P_GoodsCategory = ? ");

			params.add(po.getCstpgoodscategory());
		}

		if (!"".equals(Utility.getName(po.getCstpsupplierid()))) {
			sb.append("and C_ST_P_SupplierId = ? ");

			params.add(po.getCstpsupplierid());
		}

		if (!"".equals(Utility.getName(po.getCstpstarttime()))
				&& !"".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) <= ? ");

			params.add(po.getCstpstarttime());
			params.add(po.getCstpendtime());
		} else if (!"".equals(Utility.getName(po.getCstpstarttime()))
				&& "".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) >= ? ");

			params.add(po.getCstpstarttime());
		} else if ("".equals(Utility.getName(po.getCstpstarttime()))
				&& !"".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) <= ? ");

			params.add(po.getCstpendtime());
		}

		// 创建人
		if (!"".equals(Utility.getName(po.getCreatePersonName()))) {
			sb.append(" and C_ST_P_CreatePerson ");
			sb.append(" IN (select ID from SYS_PersonInfo ");
			sb.append(" where personName like '%' + ? + '%') ");
			params.add(po.getCreatePersonName());
		}

		// 审核人
		if (!"".equals(Utility.getName(po.getAuditPersonName()))) {
			sb.append(" and ````C_ST_P_AuditPerson  ");
			sb.append(" IN (select ID from SYS_PersonInfo ");
			sb.append(" where personName like '%' + ? + '%') ");
			params.add(po.getAuditPersonName());
		}
//		if (!"".equals(Utility.getName(po.getCstpbilltypeid()))) {
//			sb.append(" and C_ST_P_BillTypeId = ? ");
//			params.add(po.getCstpbilltypeid());
//		}
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	
	/**
	 * 隐形未核销的采购订单数量
	 * 
	 * @param po
	 *            订单po
	 * @return int 数量
	 */
	public int getProcurementOrdersForyxCount(ProcurementOrdersPo po) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(C_ST_P_ID) from C_ST_Po left join B_Departments on C_ST_P_DepartmentID = B_DP_DepartmentID ");
		sb.append(" where 1 = 1 and C_ST_P_AuditState=1 ");
		
		if (!"".equals(Utility.getName(po.getCstpcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCstpcompanyid()));	
		}
		
		sb.append(" and C_ST_P_ID in( ");
		sb.append(" select distinct b.cstpid from( ");
		sb
				.append(" select a.cstpid,a.goodsid,sum(a.goodsquantity) as goodsquantity ");
		sb
				.append(" from(select C_ST_PE_PurchaseOrderID as cstpid,C_ST_PE_goodsID as goodsid, ");
		sb.append(" C_ST_PE_OrderNumber as goodsquantity from C_ST_PoEntry ");
		sb
				.append(" inner join C_ST_PO ON C_ST_P_ID = C_ST_PE_PurchaseOrderID and C_ST_P_AuditState = 1 ");
		sb.append("  union all select C_ST_V_PoID as cstpid,C_ST_V_GoodsId as goodsid,-C_ST_V_Num as goodsquantity ");
		sb.append("  from C_ST_Verification ");
		sb.append("  inner join C_ST_PO ON C_ST_P_ID = C_ST_V_PoID ");
		sb.append(" )a group by a.goodsid,a.cstpid ");
		sb.append(" )b where b.goodsquantity>0  ) and C_ST_P_GoodsCategory in('4','5') ");

		if (!"".equals(Utility.getName(po.getCstpid()))) {
			sb.append("and C_ST_P_ID like '%' + ? + '%' ");

			params.add(po.getCstpid());
		}

		if (!"".equals(Utility.getName(po.getCstpgoodscategory()))) {
			sb.append("and C_ST_P_GoodsCategory = ? ");

			params.add(po.getCstpgoodscategory());
		}

		if (!"".equals(Utility.getName(po.getCstpsupplierid()))) {
			sb.append("and C_ST_P_SupplierId = ? ");

			params.add(po.getCstpsupplierid());
		}

		if (!"".equals(Utility.getName(po.getCstpstarttime()))
				&& !"".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) <= ? ");

			params.add(po.getCstpstarttime());
			params.add(po.getCstpendtime());
		} else if (!"".equals(Utility.getName(po.getCstpstarttime()))
				&& "".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) >= ? ");

			params.add(po.getCstpstarttime());
		} else if ("".equals(Utility.getName(po.getCstpstarttime()))
				&& !"".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) <= ? ");

			params.add(po.getCstpendtime());
		}

		// 创建人
		if (!"".equals(Utility.getName(po.getCreatePersonName()))) {
			sb.append(" and C_ST_P_CreatePerson ");
			sb.append(" IN (select ID from SYS_PersonInfo ");
			sb.append(" where personName like '%' + ? + '%') ");
			params.add(po.getCreatePersonName());
		}

		// 审核人
		if (!"".equals(Utility.getName(po.getAuditPersonName()))) {
			sb.append(" and ````C_ST_P_AuditPerson  ");
			sb.append(" IN (select ID from SYS_PersonInfo ");
			sb.append(" where personName like '%' + ? + '%') ");
			params.add(po.getAuditPersonName());
		}
//		if (!"".equals(Utility.getName(po.getCstpbilltypeid()))) {
//			sb.append(" and C_ST_P_BillTypeId = ? ");
//			params.add(po.getCstpbilltypeid());
//		}
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 未核销的采购订单list
	 * 
	 * @param po
	 *            订单po
	 * @param start
	 * @param size
	 * @return list 订单list
	 */
	public List<ProcurementOrdersPo> getProcurementOrdersForList(
			ProcurementOrdersPo po, int start, int size) {

		StringBuffer sb = new StringBuffer();

		List<String> params = new ArrayList<String>();
		int countPage = start + size;

		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from (select ROW_NUMBER() ");
		sb.append("Over(order by C_ST_P_BillDate desc) as 'rowNum', ");
		sb.append("C_ST_P_ID as CSTPID, C_ST_P_BillDate as CSTPBillDate, ");
		sb.append("B_SP_SupplierName as BSPSupplierName, ");
		sb.append("B_SP_ID as cstpsupplierid, ");
		sb.append("B_GC_GoodsCategoryName as bgcgoodscategoryname, ");
		sb.append("C_ST_P_AuditState as CSTPAuditState, ");
		sb.append("a.personName as createPersonName, ");
		sb.append("b.personName as auditPersonName from C_ST_PO left join B_Departments on C_ST_P_DepartmentID = B_DP_DepartmentID ");

		sb
				.append("left join (select ID,personName from SYS_PersonInfo) a on C_ST_P_CreatePerson=a.ID ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo) b on C_ST_P_AuditPerson=b.ID ");
		sb
				.append("inner join B_GoodsCategory on B_GC_ID = C_ST_P_GoodsCategory ");
		sb.append("inner join B_Supplier on B_SP_ID = C_ST_P_SupplierId ");
		sb.append("where 1 = 1 and C_ST_P_AuditState=1 ");
		
		if (!"".equals(Utility.getName(po.getCstpcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCstpcompanyid()));	
		}
		
		sb.append(" and C_ST_P_ID in( ");
		sb.append(" select distinct b.cstpid from( ");
		sb
				.append(" select a.cstpid,a.goodsid,sum(a.goodsquantity) as goodsquantity ");
		sb
				.append(" from(select C_ST_PE_PurchaseOrderID as cstpid,C_ST_PE_goodsID as goodsid, ");
		sb.append(" C_ST_PE_OrderNumber as goodsquantity from C_ST_PoEntry ");
		sb
				.append(" inner join C_ST_PO ON C_ST_P_ID = C_ST_PE_PurchaseOrderID and C_ST_P_AuditState = 1 ");
		sb.append("  union all select C_ST_V_PoID as cstpid,C_ST_V_GoodsId as goodsid,-C_ST_V_Num as goodsquantity ");
		sb.append("  from C_ST_Verification ");
		sb.append("  inner join C_ST_PO ON C_ST_P_ID = C_ST_V_PoID ");
		sb.append(" )a group by a.goodsid,a.cstpid ");
		sb.append(" )b where b.goodsquantity>0 )");

		if (!"".equals(Utility.getName(po.getCstpid()))) {
			sb.append("and C_ST_P_ID like '%' + ? + '%' ");

			params.add(po.getCstpid());
		}

		if (!"".equals(Utility.getName(po.getCstpgoodscategory()))) {
			sb.append("and C_ST_P_GoodsCategory = ? ");

			params.add(po.getCstpgoodscategory());
		}

		if (!"".equals(Utility.getName(po.getCstpsupplierid()))) {
			sb.append("and C_ST_P_SupplierId = ? ");

			params.add(po.getCstpsupplierid());
		}

		if (!"".equals(Utility.getName(po.getCstpstarttime()))
				&& !"".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) <= ? ");

			params.add(po.getCstpstarttime());
			params.add(po.getCstpendtime());
		} else if (!"".equals(Utility.getName(po.getCstpstarttime()))
				&& "".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) >= ? ");

			params.add(po.getCstpstarttime());
		} else if ("".equals(Utility.getName(po.getCstpstarttime()))
				&& !"".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) <= ? ");

			params.add(po.getCstpendtime());
		}

		// 创建人
		if (!"".equals(Utility.getName(po.getCreatePersonName()))) {
			sb.append(" and C_ST_P_CreatePerson ");
			sb.append(" IN (select ID from SYS_PersonInfo ");
			sb.append(" where personName like '%' + ? + '%') ");
			params.add(po.getCreatePersonName());
		}

		// 审核人
		if (!"".equals(Utility.getName(po.getAuditPersonName()))) {
			sb.append(" and C_ST_P_AuditPerson ");
			sb.append(" IN (select ID from SYS_PersonInfo ");
			sb.append(" where personName like '%' + ? + '%') ");
			params.add(po.getAuditPersonName());
		}
//		if (!"".equals(Utility.getName(po.getCstpbilltypeid()))) {
//			sb.append(" and C_ST_P_BillTypeId = ? ");
//			params.add(po.getCstpbilltypeid());
//		}
		sb.append(") table1 where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append("set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),
				ProcurementOrdersPo.class);
	}
	
	/**
	 * 隐形未核销的采购订单list
	 * 
	 * @param po
	 *            订单po
	 * @param start
	 * @param size
	 * @return list 订单list
	 */
	public List<ProcurementOrdersPo> getProcurementOrdersForyxList(
			ProcurementOrdersPo po, int start, int size) {

		StringBuffer sb = new StringBuffer();

		List<String> params = new ArrayList<String>();
		int countPage = start + size;

		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from (select ROW_NUMBER() ");
		sb.append("Over(order by C_ST_P_BillDate desc) as 'rowNum', ");
		sb.append("C_ST_P_ID as CSTPID, C_ST_P_BillDate as CSTPBillDate, ");
		sb.append("B_SP_SupplierName as BSPSupplierName, ");
		sb.append("B_SP_ID as cstpsupplierid, ");
		sb.append("B_GC_GoodsCategoryName as bgcgoodscategoryname, ");
		sb.append("C_ST_P_AuditState as CSTPAuditState, ");
		sb.append("a.personName as createPersonName, ");
		sb.append("b.personName as auditPersonName from C_ST_PO left join B_Departments on C_ST_P_DepartmentID = B_DP_DepartmentID ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo) a on C_ST_P_CreatePerson=a.ID ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo) b on C_ST_P_AuditPerson=b.ID ");
		sb
				.append("inner join B_GoodsCategory on B_GC_ID = C_ST_P_GoodsCategory ");
		sb.append("inner join B_Supplier on B_SP_ID = C_ST_P_SupplierId ");
		sb.append("where 1 = 1 and C_ST_P_AuditState=1 ");

		if (!"".equals(Utility.getName(po.getCstpcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCstpcompanyid()));	
		}
		
		sb.append(" and C_ST_P_ID in( ");
		sb.append(" select distinct b.cstpid from( ");
		sb
				.append(" select a.cstpid,a.goodsid,sum(a.goodsquantity) as goodsquantity ");
		sb
				.append(" from(select C_ST_PE_PurchaseOrderID as cstpid,C_ST_PE_goodsID as goodsid, ");
		sb.append(" C_ST_PE_OrderNumber as goodsquantity from C_ST_PoEntry ");
		sb
				.append(" inner join C_ST_PO ON C_ST_P_ID = C_ST_PE_PurchaseOrderID and C_ST_P_AuditState = 1 ");
		sb.append("  union all select C_ST_V_PoID as cstpid,C_ST_V_GoodsId as goodsid,-C_ST_V_Num as goodsquantity ");
		sb.append("  from C_ST_Verification ");
		sb.append("  inner join C_ST_PO ON C_ST_P_ID = C_ST_V_PoID ");
		sb.append(" )a group by a.goodsid,a.cstpid ");
		sb.append(" )b where b.goodsquantity>0  ) and C_ST_P_GoodsCategory in('4','5') ");

		if (!"".equals(Utility.getName(po.getCstpid()))) {
			sb.append("and C_ST_P_ID like '%' + ? + '%' ");

			params.add(po.getCstpid());
		}

		if (!"".equals(Utility.getName(po.getCstpgoodscategory()))) {
			sb.append("and C_ST_P_GoodsCategory = ? ");

			params.add(po.getCstpgoodscategory());
		}

		if (!"".equals(Utility.getName(po.getCstpsupplierid()))) {
			sb.append("and C_ST_P_SupplierId = ? ");

			params.add(po.getCstpsupplierid());
		}

		if (!"".equals(Utility.getName(po.getCstpstarttime()))
				&& !"".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) <= ? ");

			params.add(po.getCstpstarttime());
			params.add(po.getCstpendtime());
		} else if (!"".equals(Utility.getName(po.getCstpstarttime()))
				&& "".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) >= ? ");

			params.add(po.getCstpstarttime());
		} else if ("".equals(Utility.getName(po.getCstpstarttime()))
				&& !"".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) <= ? ");

			params.add(po.getCstpendtime());
		}

		// 创建人
		if (!"".equals(Utility.getName(po.getCreatePersonName()))) {
			sb.append(" and C_ST_P_CreatePerson ");
			sb.append(" IN (select ID from SYS_PersonInfo ");
			sb.append(" where personName like '%' + ? + '%') ");
			params.add(po.getCreatePersonName());
		}

		// 审核人
		if (!"".equals(Utility.getName(po.getAuditPersonName()))) {
			sb.append(" and C_ST_P_AuditPerson ");
			sb.append(" IN (select ID from SYS_PersonInfo ");
			sb.append(" where personName like '%' + ? + '%') ");
			params.add(po.getAuditPersonName());
		}
//		if (!"".equals(Utility.getName(po.getCstpbilltypeid()))) {
//			sb.append(" and C_ST_P_BillTypeId = ? ");
//			params.add(po.getCstpbilltypeid());
//		}
		sb.append(") table1 where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append("set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),
				ProcurementOrdersPo.class);
	}
	
	
	/**
	 * 未核销的采购订单数量
	 * 
	 * @param po
	 *            订单po
	 * @return int 数量
	 */
	public int getProcurementOrdersForCount1(ProcurementOrdersPo po) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(C_ST_P_ID) from C_ST_Po left join B_Departments on C_ST_P_DepartmentID = B_DP_DepartmentID ");
		sb.append(" where 1 = 1 and C_ST_P_AuditState=1 ");
		
		if (!"".equals(Utility.getName(po.getCstpcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCstpcompanyid()));	
		}
		
		sb.append(" and C_ST_P_ID in( ");
		sb.append(" select distinct b.cstpid from( ");
		sb
				.append(" select a.cstpid,a.goodsid,sum(a.goodsquantity) as goodsquantity ");
		sb
				.append(" from(select C_ST_PE_PurchaseOrderID as cstpid,C_ST_PE_goodsID as goodsid, ");
		sb.append(" C_ST_PE_OrderNumber as goodsquantity from C_ST_PoEntry ");
		sb
				.append(" inner join C_ST_PO ON C_ST_P_ID = C_ST_PE_PurchaseOrderID and C_ST_P_AuditState = 1 ");
		sb.append("  union all select C_ST_V_PoID as cstpid,C_ST_V_GoodsId as goodsid,-C_ST_V_Num as goodsquantity ");
		sb.append("  from C_ST_Verification ");
		sb.append("  inner join C_ST_PO ON C_ST_P_ID = C_ST_V_PoID ");
		sb.append(" )a group by a.goodsid,a.cstpid ");
		sb.append(" )b where b.goodsquantity<=0 ) ");
		if(po.getFspstealtheffective().equals("1") || po.getFspstealtheffective().equals("2") ){
			sb.append(" and C_ST_P_GoodsCategory not in('4','5') ");
		}
		
		if (!"".equals(Utility.getName(po.getCstpid()))) {
			sb.append("and C_ST_P_ID like '%' + ? + '%' ");

			params.add(po.getCstpid());
		}

		if (!"".equals(Utility.getName(po.getCstpgoodscategory()))) {
			sb.append("and C_ST_P_GoodsCategory = ? ");

			params.add(po.getCstpgoodscategory());
		}

		if (!"".equals(Utility.getName(po.getCstpsupplierid()))) {
			sb.append("and C_ST_P_SupplierId = ? ");

			params.add(po.getCstpsupplierid());
		}

		if (!"".equals(Utility.getName(po.getCstpstarttime()))
				&& !"".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) <= ? ");

			params.add(po.getCstpstarttime());
			params.add(po.getCstpendtime());
		} else if (!"".equals(Utility.getName(po.getCstpstarttime()))
				&& "".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) >= ? ");

			params.add(po.getCstpstarttime());
		} else if ("".equals(Utility.getName(po.getCstpstarttime()))
				&& !"".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) <= ? ");

			params.add(po.getCstpendtime());
		}

		// 创建人
		if (!"".equals(Utility.getName(po.getCreatePersonName()))) {
			sb.append(" and C_ST_P_CreatePerson ");
			sb.append(" IN (select ID from SYS_PersonInfo ");
			sb.append(" where personName like '%' + ? + '%') ");
			params.add(po.getCreatePersonName());
		}

		// 审核人
		if (!"".equals(Utility.getName(po.getAuditPersonName()))) {
			sb.append(" and ````C_ST_P_AuditPerson  ");
			sb.append(" IN (select ID from SYS_PersonInfo ");
			sb.append(" where personName like '%' + ? + '%') ");
			params.add(po.getAuditPersonName());
		}
//		if (!"".equals(Utility.getName(po.getCstpbilltypeid()))) {
//			sb.append(" and C_ST_P_BillTypeId = ? ");
//			params.add(po.getCstpbilltypeid());
//		}
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	
	/**
	 * 未核销的隐形采购订单数量
	 * 
	 * @param po
	 *            隐形订单po
	 * @return int 数量
	 */
	public int getProcurementOrdersForyxCount1(ProcurementOrdersPo po) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(C_ST_P_ID) from C_ST_Po left join B_Departments on C_ST_P_DepartmentID = B_DP_DepartmentID ");
		sb.append(" where 1 = 1 and C_ST_P_AuditState=1 ");
		
		if (!"".equals(Utility.getName(po.getCstpcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCstpcompanyid()));	
		}
		
		sb.append(" and C_ST_P_ID in( ");
		sb.append(" select distinct b.cstpid from( ");
		sb
				.append(" select a.cstpid,a.goodsid,sum(a.goodsquantity) as goodsquantity ");
		sb
				.append(" from(select C_ST_PE_PurchaseOrderID as cstpid,C_ST_PE_goodsID as goodsid, ");
		sb.append(" C_ST_PE_OrderNumber as goodsquantity from C_ST_PoEntry ");
		sb
				.append(" inner join C_ST_PO ON C_ST_P_ID = C_ST_PE_PurchaseOrderID and C_ST_P_AuditState = 1 ");
		sb.append("  union all select C_ST_V_PoID as cstpid,C_ST_V_GoodsId as goodsid,-C_ST_V_Num as goodsquantity ");
		sb.append("  from C_ST_Verification ");
		sb.append("  inner join C_ST_PO ON C_ST_P_ID = C_ST_V_PoID ");
		sb.append(" )a group by a.goodsid,a.cstpid ");
		sb.append(" )b where b.goodsquantity<=0  )  and C_ST_P_GoodsCategory in('4','5') ");

		if (!"".equals(Utility.getName(po.getCstpid()))) {
			sb.append("and C_ST_P_ID like '%' + ? + '%' ");

			params.add(po.getCstpid());
		}

		if (!"".equals(Utility.getName(po.getCstpgoodscategory()))) {
			sb.append("and C_ST_P_GoodsCategory = ? ");

			params.add(po.getCstpgoodscategory());
		}

		if (!"".equals(Utility.getName(po.getCstpsupplierid()))) {
			sb.append("and C_ST_P_SupplierId = ? ");

			params.add(po.getCstpsupplierid());
		}

		if (!"".equals(Utility.getName(po.getCstpstarttime()))
				&& !"".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) <= ? ");

			params.add(po.getCstpstarttime());
			params.add(po.getCstpendtime());
		} else if (!"".equals(Utility.getName(po.getCstpstarttime()))
				&& "".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) >= ? ");

			params.add(po.getCstpstarttime());
		} else if ("".equals(Utility.getName(po.getCstpstarttime()))
				&& !"".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) <= ? ");

			params.add(po.getCstpendtime());
		}

		// 创建人
		if (!"".equals(Utility.getName(po.getCreatePersonName()))) {
			sb.append(" and C_ST_P_CreatePerson ");
			sb.append(" IN (select ID from SYS_PersonInfo ");
			sb.append(" where personName like '%' + ? + '%') ");
			params.add(po.getCreatePersonName());
		}

		// 审核人
		if (!"".equals(Utility.getName(po.getAuditPersonName()))) {
			sb.append(" and ````C_ST_P_AuditPerson  ");
			sb.append(" IN (select ID from SYS_PersonInfo ");
			sb.append(" where personName like '%' + ? + '%') ");
			params.add(po.getAuditPersonName());
		}
//		if (!"".equals(Utility.getName(po.getCstpbilltypeid()))) {
//			sb.append(" and C_ST_P_BillTypeId = ? ");
//			params.add(po.getCstpbilltypeid());
//		}
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 已核销的采购订单list
	 * 
	 * @param po
	 *            订单po
	 * @param start
	 * @param size
	 * @return list 订单list
	 */
	public List<ProcurementOrdersPo> getProcurementOrdersForList1(
			ProcurementOrdersPo po, int start, int size) {

		StringBuffer sb = new StringBuffer();

		List<String> params = new ArrayList<String>();
		int countPage = start + size;

		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from (select ROW_NUMBER() ");
		sb.append("Over(order by C_ST_P_BillDate desc) as 'rowNum', ");
		sb.append("C_ST_P_ID as CSTPID, C_ST_P_BillDate as CSTPBillDate, ");
		sb.append("B_SP_SupplierName as BSPSupplierName, ");
		sb.append("B_SP_ID as cstpsupplierid, ");
		sb.append("B_GC_GoodsCategoryName as bgcgoodscategoryname, ");
		sb.append("C_ST_P_AuditState as CSTPAuditState, ");
		sb.append("a.personName as createPersonName, ");
		sb.append("b.personName as auditPersonName from C_ST_PO left join B_Departments on C_ST_P_DepartmentID = B_DP_DepartmentID ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo) a on C_ST_P_CreatePerson=a.ID ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo) b on C_ST_P_AuditPerson=b.ID ");
		sb
				.append("inner join B_GoodsCategory on B_GC_ID = C_ST_P_GoodsCategory ");
		sb.append("inner join B_Supplier on B_SP_ID = C_ST_P_SupplierId ");
		sb.append("where 1 = 1 and C_ST_P_AuditState=1 ");
		
		if (!"".equals(Utility.getName(po.getCstpcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCstpcompanyid()));	
		}
		
		sb.append(" and C_ST_P_ID in( ");
		sb.append(" select distinct b.cstpid from( ");
		sb
				.append(" select a.cstpid,a.goodsid,sum(a.goodsquantity) as goodsquantity ");
		sb
				.append(" from(select C_ST_PE_PurchaseOrderID as cstpid,C_ST_PE_goodsID as goodsid, ");
		sb.append(" C_ST_PE_OrderNumber as goodsquantity from C_ST_PoEntry ");
		sb
				.append(" inner join C_ST_PO ON C_ST_P_ID = C_ST_PE_PurchaseOrderID and C_ST_P_AuditState = 1 ");
		sb.append("  union all select C_ST_V_PoID as cstpid,C_ST_V_GoodsId as goodsid,-C_ST_V_Num as goodsquantity ");
		sb.append("  from C_ST_Verification ");
		sb.append("  inner join C_ST_PO ON C_ST_P_ID = C_ST_V_PoID ");
		sb.append(" )a group by a.goodsid,a.cstpid ");
		sb.append(" )b where b.goodsquantity<=0 )");
		if(po.getFspstealtheffective().equals("1") || po.getFspstealtheffective().equals("2") ){
			sb.append(" and C_ST_P_GoodsCategory not in('4','5') ");
		}
		
		if (!"".equals(Utility.getName(po.getCstpid()))) {
			sb.append("and C_ST_P_ID like '%' + ? + '%' ");

			params.add(po.getCstpid());
		}

		if (!"".equals(Utility.getName(po.getCstpgoodscategory()))) {
			sb.append("and C_ST_P_GoodsCategory = ? ");

			params.add(po.getCstpgoodscategory());
		}

		if (!"".equals(Utility.getName(po.getCstpsupplierid()))) {
			sb.append("and C_ST_P_SupplierId = ? ");

			params.add(po.getCstpsupplierid());
		}

		if (!"".equals(Utility.getName(po.getCstpstarttime()))
				&& !"".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) <= ? ");

			params.add(po.getCstpstarttime());
			params.add(po.getCstpendtime());
		} else if (!"".equals(Utility.getName(po.getCstpstarttime()))
				&& "".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) >= ? ");

			params.add(po.getCstpstarttime());
		} else if ("".equals(Utility.getName(po.getCstpstarttime()))
				&& !"".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) <= ? ");

			params.add(po.getCstpendtime());
		}

		// 创建人
		if (!"".equals(Utility.getName(po.getCreatePersonName()))) {
			sb.append(" and C_ST_P_CreatePerson ");
			sb.append(" IN (select ID from SYS_PersonInfo ");
			sb.append(" where personName like '%' + ? + '%') ");
			params.add(po.getCreatePersonName());
		}

		// 审核人
		if (!"".equals(Utility.getName(po.getAuditPersonName()))) {
			sb.append(" and C_ST_P_AuditPerson ");
			sb.append(" IN (select ID from SYS_PersonInfo ");
			sb.append(" where personName like '%' + ? + '%') ");
			params.add(po.getAuditPersonName());
		}
//		if (!"".equals(Utility.getName(po.getCstpbilltypeid()))) {
//			sb.append(" and C_ST_P_BillTypeId = ? ");
//			params.add(po.getCstpbilltypeid());
//		}
		sb.append(") table1 where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append("set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),
				ProcurementOrdersPo.class);
	}
	
	/**
	 * 已核销的采购订单list
	 * 
	 * @param po
	 *            订单po
	 * @param start
	 * @param size
	 * @return list 订单list
	 */
	public List<ProcurementOrdersPo> getProcurementOrdersForyxList1(ProcurementOrdersPo po, int start, int size) {

		StringBuffer sb = new StringBuffer();

		List<String> params = new ArrayList<String>();
		int countPage = start + size;

		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from (select ROW_NUMBER() ");
		sb.append("Over(order by C_ST_P_BillDate desc) as 'rowNum', ");
		sb.append("C_ST_P_ID as CSTPID, C_ST_P_BillDate as CSTPBillDate, ");
		sb.append("B_SP_SupplierName as BSPSupplierName, ");
		sb.append("B_SP_ID as cstpsupplierid, ");
		sb.append("B_GC_GoodsCategoryName as bgcgoodscategoryname, ");
		sb.append("C_ST_P_AuditState as CSTPAuditState, ");
		sb.append("a.personName as createPersonName, ");
		sb.append("b.personName as auditPersonName from C_ST_PO left join B_Departments on C_ST_P_DepartmentID = B_DP_DepartmentID ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo) a on C_ST_P_CreatePerson=a.ID ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo) b on C_ST_P_AuditPerson=b.ID ");
		sb
				.append("inner join B_GoodsCategory on B_GC_ID = C_ST_P_GoodsCategory ");
		sb.append("inner join B_Supplier on B_SP_ID = C_ST_P_SupplierId ");
		sb.append("where 1 = 1 and C_ST_P_AuditState=1 ");
		
		if (!"".equals(Utility.getName(po.getCstpcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCstpcompanyid()));	
		}
		
		sb.append(" and C_ST_P_ID in( ");
		sb.append(" select distinct b.cstpid from( ");
		sb
				.append(" select a.cstpid,a.goodsid,sum(a.goodsquantity) as goodsquantity ");
		sb
				.append(" from(select C_ST_PE_PurchaseOrderID as cstpid,C_ST_PE_goodsID as goodsid, ");
		sb.append(" C_ST_PE_OrderNumber as goodsquantity from C_ST_PoEntry ");
		sb
				.append(" inner join C_ST_PO ON C_ST_P_ID = C_ST_PE_PurchaseOrderID and C_ST_P_AuditState = 1 ");
		sb.append("  union all select C_ST_V_PoID as cstpid,C_ST_V_GoodsId as goodsid,-C_ST_V_Num as goodsquantity ");
		sb.append("  from C_ST_Verification ");
		sb.append("  inner join C_ST_PO ON C_ST_P_ID = C_ST_V_PoID ");
		sb.append(" )a group by a.goodsid,a.cstpid ");
		sb.append(" )b where b.goodsquantity<=0 ) and C_ST_P_GoodsCategory in('4','5') ");

		if (!"".equals(Utility.getName(po.getCstpid()))) {
			sb.append("and C_ST_P_ID like '%' + ? + '%' ");

			params.add(po.getCstpid());
		}

		if (!"".equals(Utility.getName(po.getCstpgoodscategory()))) {
			sb.append("and C_ST_P_GoodsCategory = ? ");

			params.add(po.getCstpgoodscategory());
		}

		if (!"".equals(Utility.getName(po.getCstpsupplierid()))) {
			sb.append("and C_ST_P_SupplierId = ? ");

			params.add(po.getCstpsupplierid());
		}

		if (!"".equals(Utility.getName(po.getCstpstarttime()))
				&& !"".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) <= ? ");

			params.add(po.getCstpstarttime());
			params.add(po.getCstpendtime());
		} else if (!"".equals(Utility.getName(po.getCstpstarttime()))
				&& "".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) >= ? ");

			params.add(po.getCstpstarttime());
		} else if ("".equals(Utility.getName(po.getCstpstarttime()))
				&& !"".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_P_BillDate, 23) <= ? ");

			params.add(po.getCstpendtime());
		}

		// 创建人
		if (!"".equals(Utility.getName(po.getCreatePersonName()))) {
			sb.append(" and C_ST_P_CreatePerson ");
			sb.append(" IN (select ID from SYS_PersonInfo ");
			sb.append(" where personName like '%' + ? + '%') ");
			params.add(po.getCreatePersonName());
		}

		// 审核人
		if (!"".equals(Utility.getName(po.getAuditPersonName()))) {
			sb.append(" and C_ST_P_AuditPerson ");
			sb.append(" IN (select ID from SYS_PersonInfo ");
			sb.append(" where personName like '%' + ? + '%') ");
			params.add(po.getAuditPersonName());
		}
//		if (!"".equals(Utility.getName(po.getCstpbilltypeid()))) {
//			sb.append(" and C_ST_P_BillTypeId = ? ");
//			params.add(po.getCstpbilltypeid());
//		}
		sb.append(") table1 where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append("set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),
				ProcurementOrdersPo.class);
	}

	/**
	 * 委外订单的未核销商品数量
	 * 
	 * @param po
	 *            订单po
	 * @return int 数量
	 */
	public int getConsignProcessOrderCount(ConsignProcessOrderPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select count(goodsid) from( ");
		sb.append("select b.CSTCPODOrderBillD, ");
		sb.append("b.goodsid, ");
		sb.append("sum(b.goodsquantity) as goodsquantity, ");

		sb.append("bgisph, ");
		sb.append("bgicyl, ");
		sb.append("bgiaxis, ");
		sb.append("bgicurvature, ");
		sb.append("bgidia ,");
		sb.append("cstcpodid ");

		sb.append("from( ");
		sb.append("select ROW_NUMBER() Over(order by a.goodsid) as num, ");
		sb.append("a.CSTCPODId, ");
		sb.append("a.CSTCPODOrderBillD as CSTCPODOrderBillD, ");
		sb.append("a.goodsid as goodsid, ");
		sb.append("a.goodsquantity as goodsquantity, ");

		sb.append("bgisph, ");
		sb.append("bgicyl, ");
		sb.append("bgiaxis, ");
		sb.append("bgicurvature, ");
		sb.append("bgidia ");

		sb.append("from(  ");
		sb.append("select C_ST_CPOD_Id as CSTCPODId, ");
		sb.append("C_ST_CPOD_OrderBillD as CSTCPODOrderBillD, ");
		sb.append("C_ST_CPOD_GoodsID as goodsid, ");
		sb.append("C_ST_CPOD_Num as goodsquantity, ");

		sb.append("C_ST_CPOD_BallGlass as bgisph, ");
		sb.append("C_ST_CPOD_PostGlass as bgicyl, ");
		sb.append("C_ST_CPOD_Axes as bgiaxis, ");
		sb.append("C_ST_CPOD_EyeCurvature as bgicurvature, ");
		sb.append("C_ST_CPOD_Diameter as bgidia ");

		sb.append("from C_ST_ConsignProcessOrderDetails  ");
		sb.append("inner join C_ST_ConsignProcessOrder ");
		sb.append("ON C_ST_CPO_OrderBillId = C_ST_CPOD_OrderBillD  ");
		sb.append("where C_ST_CPOD_OrderBillD= ? ");
		sb.append("union all  ");
		sb.append("select C_ST_CPOD_Id as CSTCPODId, ");
		sb.append("C_ST_V_PoID as CSTCPODOrderBillD, ");
		sb.append("C_ST_V_GoodsId as goodsid, ");
		sb.append("-C_ST_V_Num as goodsquantity,  ");

		sb.append("C_ST_CPOD_BallGlass as bgisph, ");
		sb.append("C_ST_CPOD_PostGlass as bgicyl, ");
		sb.append("C_ST_CPOD_Axes as bgiaxis, ");
		sb.append("C_ST_CPOD_EyeCurvature as bgicurvature, ");
		sb.append("C_ST_CPOD_Diameter as bgidia ");

		sb.append("from C_ST_Verification  ");
		sb.append("inner join C_ST_ConsignProcessOrderDetails ");
		sb.append("ON C_ST_V_OrderDetailsID = C_ST_CPOD_Id ");
		sb.append("inner join C_ST_ConsignProcessOrder ");
		sb.append("ON C_ST_CPO_OrderBillId = C_ST_CPOD_OrderBillD  ");

		sb.append("where C_ST_V_PoID= ? ");
		sb.append(")a)b ");
		sb.append("group by CSTCPODId, b.goodsid, ");
		sb.append("b.CSTCPODOrderBillD, bgisph, bgicyl, ");
		sb.append("bgiaxis, bgicurvature, bgidia)c ");

		sb.append("inner join B_GoodsInfo  ");
		sb.append("on c.goodsid=B_GoodsInfo.B_GI_GoodsID ");

		sb.append("where c.goodsquantity>0 and B_GI_SupplierID = ?");

		List<String> params = new ArrayList<String>();
		params.add(po.getCstcpoorderbillid());
		params.add(po.getCstcpoorderbillid());
		params.add(po.getCstcposupplierid());

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 委外订单的未核销商品list
	 * 
	 * @param po
	 *            订单po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsInfoPo> getConsignProcessOrderList(
			ConsignProcessOrderPo po, int start, int size) {

		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from( ");
		sb
				.append("select ROW_NUMBER() Over(order by B_GoodsInfo.B_GI_GoodsID) as rowNum, ");
		sb.append("cstcpodid,c.CSTCPODOrderBillD as CSTCPODOrderBillD, ");
		sb.append("c.goodsid as bgigoodsid, ");
		sb
				.append("c.goodsquantity as bgigoodsquantity,B_GI_ViewGoodsName as bgigoodsname, ");
		sb.append("B_Supplier.B_SP_SupplierName as bgisuppliername, ");
		sb.append("B_GoodsInfo.B_GI_Spec as bgispec, ");
		sb.append("B_GoodsInfo.B_GI_Color as bgicolor, ");
		sb.append("bgisph, ");
		sb.append("bgicyl, ");
		sb.append("bgiaxis, ");
		sb.append("bgicurvature as bgicurvature1, ");
		sb.append("bgidia, ");
		sb.append("B_GoodsInfo.B_GI_TaxRate as bgitaxrate, ");
		sb.append("B_GoodsInfo.B_GI_GoodsBarCode as bgigoodsbarcode, ");
		sb.append("B_Brand.B_BD_brandName as bgibrandname, ");
		// sb.append("B_Variety.B_VY_VarietyName as bgivarietyname, ");
		sb.append("B_Unit.B_UT_unitName as bgiunitname, ");
		sb.append("B_GoodsInfo.B_GI_RetailPrice as bgiretailprice, ");
		sb.append("B_GoodsInfo.B_GI_CostPrice as bgicostprice, ");
		sb.append("B_GoodsInfo.B_GI_NotTaxRate as bginottaxrate ");
		sb.append("from( ");
		sb.append("select b.CSTCPODOrderBillD, ");
		sb.append("b.goodsid, ");
		sb.append("sum(b.goodsquantity) as goodsquantity, ");

		sb.append("bgisph, ");
		sb.append("bgicyl, ");
		sb.append("bgiaxis, ");
		sb.append("bgicurvature, ");
		sb.append("bgidia, ");
		sb.append("cstcpodid ");

		sb.append("from( ");
		sb.append("select ROW_NUMBER() Over(order by a.goodsid) as num, ");
		sb.append("a.CSTCPODId, ");
		sb.append("a.CSTCPODOrderBillD as CSTCPODOrderBillD, ");
		sb.append("a.goodsid as goodsid, ");
		sb.append("a.goodsquantity as goodsquantity, ");

		sb.append("bgisph, ");
		sb.append("bgicyl, ");
		sb.append("bgiaxis, ");
		sb.append("bgicurvature, ");
		sb.append("bgidia ");

		sb.append("from(  ");
		sb.append("select C_ST_CPOD_Id as CSTCPODId, ");
		sb.append("C_ST_CPOD_OrderBillD as CSTCPODOrderBillD, ");
		sb.append("C_ST_CPOD_GoodsID as goodsid, ");
		sb.append("C_ST_CPOD_Num as goodsquantity, ");

		sb.append("C_ST_CPOD_BallGlass as bgisph, ");
		sb.append("C_ST_CPOD_PostGlass as bgicyl, ");
		sb.append("C_ST_CPOD_Axes as bgiaxis, ");
		sb.append("C_ST_CPOD_EyeCurvature as bgicurvature, ");
		sb.append("C_ST_CPOD_Diameter as bgidia ");

		sb.append("from C_ST_ConsignProcessOrderDetails  ");
		sb.append("inner join C_ST_ConsignProcessOrder ");
		sb.append("ON C_ST_CPO_OrderBillId = C_ST_CPOD_OrderBillD  ");
		sb.append("where C_ST_CPOD_OrderBillD= ? ");
		sb.append("union all  ");
		sb.append("select C_ST_CPOD_Id as CSTCPODId, ");
		sb.append("C_ST_V_PoID as CSTCPODOrderBillD, ");
		sb.append("C_ST_V_GoodsId as goodsid, ");
		sb.append("-C_ST_V_Num as goodsquantity,  ");

		sb.append("C_ST_CPOD_BallGlass as bgisph, ");
		sb.append("C_ST_CPOD_PostGlass as bgicyl, ");
		sb.append("C_ST_CPOD_Axes as bgiaxis, ");
		sb.append("C_ST_CPOD_EyeCurvature as bgicurvature, ");
		sb.append("C_ST_CPOD_Diameter as bgidia ");

		sb.append("from C_ST_Verification  ");
		sb.append("inner join C_ST_ConsignProcessOrderDetails ");
		sb.append("ON C_ST_V_OrderDetailsID = C_ST_CPOD_Id ");
		sb.append("inner join C_ST_ConsignProcessOrder ");
		sb.append("ON C_ST_CPO_OrderBillId = C_ST_CPOD_OrderBillD  ");

		sb.append("where C_ST_V_PoID= ? ");
		sb.append(")a)b ");
		sb.append("group by CSTCPODId, b.goodsid, ");
		sb.append("b.CSTCPODOrderBillD, bgisph, bgicyl, ");
		sb.append("bgiaxis, bgicurvature, bgidia)c ");

		sb.append("inner join B_GoodsInfo  ");
		sb.append("on c.goodsid=B_GoodsInfo.B_GI_GoodsID ");
		sb.append("inner join B_Supplier ");
		sb.append("on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand ");
		sb.append("on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  ");
		sb.append("B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		// sb.append("inner join B_Variety ");
		// sb.append("on B_GoodsInfo.B_GI_VarietyID=B_Variety.B_VY_ID and ");
		// sb.append("B_GoodsInfo.B_GI_BrandID=B_Variety.B_VY_BrandID and ");
		// sb.append("B_GI_SupplierID=B_VY_SupplierID and  ");
		// sb.append("B_GI_GoodsCategoryID=B_VY_GcID ");
		sb.append("inner join B_Unit  ");
		sb.append("on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id ");
		sb.append("where c.goodsquantity>0 and B_GI_SupplierID = ?");
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");

		List<String> params = new ArrayList<String>();
		// params.add(po.getCstcposupplierid());
		params.add(po.getCstcpoorderbillid());
		// params.add(po.getCstcposupplierid());
		params.add(po.getCstcpoorderbillid());
		params.add(po.getCstcposupplierid());

		return queryForObjectList(sb.toString(), params.toArray(),
				GoodsInfoPo.class);
	}

	/**
	 * 未核销的委外订单数量
	 * 
	 * @param po
	 *            订单po
	 * @return int 数量
	 */
	public int getConsignProcessOrderForCount(
			ConsignProcessOrderPo consignProcessOrderPo) {
		StringBuffer sb = new StringBuffer();

		sb.append("select count(C_ST_CPO_OrderBillId) ");
		sb.append("from C_ST_ConsignProcessOrder ");
		sb.append(" where 1 = 1 ");
		sb.append(" and C_ST_CPO_OrderBillId in(");
		sb.append(" select distinct cstcpodorderbilld ");
		sb
				.append(" from( select b.CSTCPODOrderBillD as cstcpodorderbilld, b.goodsid as goodsid, sum(b.goodsquantity) as goodsquantity,cstcpodid  ");
		sb
				.append(" from( select ROW_NUMBER() Over(order by a.goodsid) as num, a.CSTCPODId, a.CSTCPODOrderBillD as CSTCPODOrderBillD, a.goodsid as goodsid, a.goodsquantity as goodsquantity ");
		sb
				.append("  from(  select C_ST_CPOD_Id as CSTCPODId, C_ST_CPOD_OrderBillD as CSTCPODOrderBillD, C_ST_CPOD_GoodsID as goodsid, C_ST_CPOD_Num as goodsquantity ");
		sb
				.append("  from C_ST_ConsignProcessOrderDetails inner join C_ST_ConsignProcessOrder ON C_ST_CPO_OrderBillId = C_ST_CPOD_OrderBillD where C_ST_CPO_AuditState='1' union all ");
		sb
				.append("   select C_ST_V_OrderDetailsID as CSTCPODId, C_ST_V_PoID as CSTCPODOrderBillD, C_ST_V_GoodsId as goodsid, -C_ST_V_Num as goodsquantity from C_ST_Verification ");
		sb
				.append("  inner join C_ST_ConsignProcessOrder ON C_ST_CPO_OrderBillId = C_ST_V_PoID)a)b ");
		sb.append(" group by CSTCPODId, b.goodsid, b.CSTCPODOrderBillD)c ");
		sb
				.append(" inner join B_GoodsInfo  on c.goodsid=B_GoodsInfo.B_GI_GoodsID ");
		sb.append(" where c.goodsquantity>0)");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(consignProcessOrderPo
				.getCstcpoorderbillid()))) {
			sb.append("and C_ST_CPO_OrderBillId= ? ");

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

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 未核销的委外订单list
	 * 
	 * @param po
	 *            订单po
	 * @param start
	 * @param size
	 * @return list 订单list
	 */
	public List<ConsignProcessOrderPo> getConsignProcessOrderForList(
			ConsignProcessOrderPo consignProcessOrderPo, int start, int size) {

		StringBuffer sb = new StringBuffer();

		List<String> params = new ArrayList<String>();
		int countPage = start + size;

		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from (select ROW_NUMBER() ");
		sb.append("Over(order by C_ST_CPO_BillDate desc) as 'rowNum', ");
		sb.append("C_ST_CPO_OrderBillId as CSTCPOOrderBillId, ");
		sb.append("C_ST_CPO_BillDate as CSTCPOBillDate, ");
		sb.append("B_SP_SupplierName as BSPSupplierName, ");
		sb.append("B_GC_GoodsCategoryName as BGCGoodsCategoryName, ");
		sb.append("C_ST_CPO_AuditState as CSTCPOAuditState, ");
		sb.append("a.personName as createPersonName, ");
		sb.append("b.personName as auditPersonName ");
		sb.append("from C_ST_ConsignProcessOrder ");
		sb.append("left join (select ID,personName from SYS_PersonInfo) a ");
		sb.append("on C_ST_CPO_CreatePerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo) b ");
		sb.append("on C_ST_CPO_AuditPerson=b.ID ");
		sb.append("inner join B_GoodsCategory ");
		sb.append("on B_GC_ID = C_ST_CPO_OrderGoodsCategory ");
		sb.append("inner join B_Supplier on B_SP_ID = C_ST_CPO_SupplierId ");
		sb.append("where 1 = 1 ");
		sb.append(" and C_ST_CPO_OrderBillId in(");
		sb.append(" select distinct cstcpodorderbilld ");
		sb
				.append(" from( select b.CSTCPODOrderBillD as cstcpodorderbilld, b.goodsid as goodsid, sum(b.goodsquantity) as goodsquantity,cstcpodid  ");
		sb
				.append(" from( select ROW_NUMBER() Over(order by a.goodsid) as num, a.CSTCPODId, a.CSTCPODOrderBillD as CSTCPODOrderBillD, a.goodsid as goodsid, a.goodsquantity as goodsquantity ");
		sb
				.append("  from(  select C_ST_CPOD_Id as CSTCPODId, C_ST_CPOD_OrderBillD as CSTCPODOrderBillD, C_ST_CPOD_GoodsID as goodsid, C_ST_CPOD_Num as goodsquantity ");
		sb
				.append("  from C_ST_ConsignProcessOrderDetails inner join C_ST_ConsignProcessOrder ON C_ST_CPO_OrderBillId = C_ST_CPOD_OrderBillD where C_ST_CPO_AuditState='1' union all ");
		sb
				.append("   select C_ST_V_OrderDetailsID as CSTCPODId, C_ST_V_PoID as CSTCPODOrderBillD, C_ST_V_GoodsId as goodsid, -C_ST_V_Num as goodsquantity from C_ST_Verification ");
		sb
				.append("  inner join C_ST_ConsignProcessOrder ON C_ST_CPO_OrderBillId = C_ST_V_PoID)a)b ");
		sb.append(" group by CSTCPODId, b.goodsid, b.CSTCPODOrderBillD)c ");
		sb
				.append(" inner join B_GoodsInfo  on c.goodsid=B_GoodsInfo.B_GI_GoodsID ");
		sb.append(" where c.goodsquantity>0)");

		if (!"".equals(Utility.getName(consignProcessOrderPo
				.getCstcpoorderbillid()))) {
			sb.append("and C_ST_CPO_OrderBillId= ? ");

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

		sb.append(") table1 where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append("set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),
				ConsignProcessOrderPo.class);
	}

	/**
	 * 取订单系统发货单已发货
	 * 
	 * @param po
	 *            订单po
	 * @return int 数量
	 */
	public int getInvoiceForCount(ProcurementOrdersPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("SELECT count(C_ST_D_PoID) ");
		sb.append("FROM orders.orders.dbo.C_ST_Po INNER JOIN ");
		sb.append("orders.orders.dbo.C_ST_Delivery ON ");
		sb.append("C_ST_P_ID = C_ST_D_PoID ");
		sb
				.append("where 1 = 1 and C_ST_D_AuditState = 2 and C_ST_P_AuditState = 7 ");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(po.getCstpid()))) {
			sb.append("and C_ST_D_ID like '%' + ? ");
			params.add(po.getCstpid());
		}

		if (!"".equals(Utility.getName(po.getCstpsupplierid()))) {
			sb.append("and C_ST_D_SupplierID = ? ");

			params.add(po.getCstpsupplierid());
		}

		// 公司别名
		if (!"".equals(Utility.getName(po.getCstpcustomerid()))) {
			sb.append("and C_ST_D_CustomerID = ? ");

			params.add(po.getCstpcustomerid());
		}

		if (!"".equals(Utility.getName(po.getCstpstarttime()))
				&& !"".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_D_BillDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_D_BillDate, 23) <= ? ");

			params.add(po.getCstpstarttime());
			params.add(po.getCstpendtime());
		} else if (!"".equals(Utility.getName(po.getCstpstarttime()))
				&& "".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_D_BillDate, 23) >= ? ");

			params.add(po.getCstpstarttime());
		} else if ("".equals(Utility.getName(po.getCstpstarttime()))
				&& !"".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_D_BillDate, 23) <= ? ");

			params.add(po.getCstpendtime());
		}

		if (!"".equals(Utility.getName(po.getCstpbilltypeid()))) {
			sb.append(" and C_ST_P_BillTypeId = ? ");
			params.add(po.getCstpbilltypeid());
		}

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 未核销的采购订单list
	 * 
	 * @param po
	 *            订单po
	 * @param start
	 * @param size
	 * @return list 订单list
	 */
	public List<ProcurementOrdersPo> getInvoiceForList(ProcurementOrdersPo po,
			int start, int size) {

		StringBuffer sb = new StringBuffer();

		List<String> params = new ArrayList<String>();
		int countPage = start + size;

		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from (select ROW_NUMBER() ");
		sb.append("Over(order by C_ST_P_BillDate desc) as 'rowNum', ");
		sb.append("C_ST_P_ID AS CSTPID, C_ST_D_ID as cstpdeliveryid, ");
		sb.append("C_ST_D_BillDate AS CSTPBillDate, ");
		sb.append("B_DP_DepartmentName AS BSPSupplierName, ");
		sb.append("C_ST_P_AuditState AS CSTPAuditState, ");
		sb.append("a.personName AS createPersonName, ");
		sb.append("b.personName AS auditPersonName ");
		sb.append("FROM orders.orders.dbo.C_ST_Po INNER JOIN ");
		sb.append("orders.orders.dbo.C_ST_Delivery ON C_ST_P_ID = C_ST_D_PoID AND ");
		sb.append("C_ST_P_ID = C_ST_D_PoID ");
		sb.append("INNER JOIN orders.orders.dbo.B_Departments ON ");
		sb.append("C_ST_P_SupplierID = B_DP_DepartmentID ");
		sb.append("AND B_DP_Type = 2 ");
		sb.append("INNER JOIN orders.orders.dbo.SYS_PersonInfo a ON ");
		sb.append("C_ST_D_CreatePerson = a.ID ");
		sb.append("INNER JOIN orders.orders.dbo.SYS_PersonInfo b ON ");
		sb.append("C_ST_D_AuditPerson = b.ID ");
		sb.append("where C_ST_D_AuditState = '2' ");
		sb.append("and C_ST_P_AuditState = 7 ");

		if (!"".equals(Utility.getName(po.getCstpid()))) {
			sb.append("and C_ST_D_ID like '%' + ? ");
			params.add(po.getCstpid());
		}

		if (!"".equals(Utility.getName(po.getCstpsupplierid()))) {
			sb.append("and C_ST_D_SupplierID = ? ");

			params.add(po.getCstpsupplierid());
		}

		// 公司别名
		if (!"".equals(Utility.getName(po.getCstpcustomerid()))) {
			sb.append("and C_ST_D_CustomerID = ? ");

			params.add(po.getCstpcustomerid());
		}

		if (!"".equals(Utility.getName(po.getCstpstarttime()))
				&& !"".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_D_BillDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_D_BillDate, 23) <= ? ");

			params.add(po.getCstpstarttime());
			params.add(po.getCstpendtime());
		} else if (!"".equals(Utility.getName(po.getCstpstarttime()))
				&& "".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_D_BillDate, 23) >= ? ");

			params.add(po.getCstpstarttime());
		} else if ("".equals(Utility.getName(po.getCstpstarttime()))
				&& !"".equals(Utility.getName(po.getCstpendtime()))) {
			sb.append("and convert(varchar(10), C_ST_D_BillDate, 23) <= ? ");

			params.add(po.getCstpendtime());
		}

		if (!"".equals(Utility.getName(po.getCstpbilltypeid()))) {
			sb.append(" and C_ST_P_BillTypeId = ? ");
			params.add(po.getCstpbilltypeid());
		}

		sb.append(") table1 where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append("set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),
				ProcurementOrdersPo.class);
	}

}
