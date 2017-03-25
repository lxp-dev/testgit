package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.WarehouseDao;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.dao.NonconformingDao;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.NonconformingEntryPo;
import com.pengsheng.eims.storage.persistence.NonconformingPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class NonconformingDaoImpl extends BaseJdbcDaoSupport implements
		NonconformingDao {

	/**
	 * 得到不合格品数量
	 */
	public int getNonconformingCount(NonconformingPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("select count(C_SHA_N_billID) ");

		sb.append(" from C_SHA_Nonconforming ");
		sb.append("inner join B_Departments on C_SHA_N_DepartmentID = B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_N_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_N_AuditPerson=b.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)c on C_SHA_N_ConsignPerson=c.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)d on C_SHA_N_Responsibility=d.ID ");

		sb.append("  where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getCshancompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCshancompanyid()));	
		}
		
		if (!"3".equals(Utility.getName(po.getCshandepartmentname().split(",")[0].trim()))&&!"".equals(Utility.getName(po.getCshandepartmentname().split(",")[0].trim()))) {
			if("2".equals(Utility.getName(po.getCshandepartmentname().split(",")[0].trim()))){//加工區域
				sb.append(" and C_SHA_N_DepartmentID in (select b_dp_departmentid from b_departments where B_DP_RegID=? or C_SHA_N_DepartmentID = ?) ");
				params.add(po.getCshandepartmentname().split(",")[1].trim());//代指部門類別
				params.add(po.getCshandepartmentname().split(",")[1].trim());//操作人所在部门
			}else{//門店本身
				sb.append(" and C_SHA_N_DepartmentID=? ");
				params.add(po.getCshandepartmentname().split(",")[1].trim());//代指部門類別
			}
			
		}
				
		if (!"".equals(Utility.getName(po.getIscustomize()))) { 
		    sb.append("and C_SHA_N_billID in ( "); 
		    sb.append("select C_SHA_NE_billID from C_SHA_NonconformingEntry "); 
		    sb.append(" inner join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID = C_SHA_NonconformingEntry.C_SHA_NE_goodsID "); 
			if (!"".equals(Utility.getName(po.getCshansupplierid()))) {
				sb.append("where B_GI_SupplierID = ? ");
				params.add(po.getCshansupplierid());
			}
		    // 按品种查找 
		    if (!"".equals(Utility.getName(po.getIscustomize()))) { 
		    	sb.append("and B_GI_GoodsCategoryID = ? "); //quyanping2011-05-25  sb.append("and B_GI_BrandID = ? "); 
		    	params.add(po.getIscustomize()); 
		    }
			
		    sb.append(") ");
		}
		
		if (!"".equals(Utility.getName(po.getCshanconsignmode()))) { 
		    sb.append("and C_SHA_N_billID in ( "); 
		    sb.append("select C_SHA_NE_billID from C_SHA_NonconformingEntry "); 
		    if (!"".equals(Utility.getName(po.getCshanconsignmode()))) {
				sb.append("where C_SHA_NE_consignMode= ? ");
				params.add(po.getCshanconsignmode());
			}
		    sb.append(") ");
		}

		if (!"".equals(Utility.getName(po.getCshanbillid()))) {
			sb.append("and C_SHA_N_billID like '%'+?+'%' ");//quyanping
			params.add(po.getCshanbillid());
		}
		if (!"".equals(Utility.getName(po.getCshandepartmentid()))) {
			sb.append("and C_SHA_N_DepartmentID= ? ");
			params.add(po.getCshandepartmentid());
		}
		
		if (!"".equals(Utility.getName(po.getCshanauditstate()))) {
			if ("1".equals(Utility.getName(po.getCshanauditstate()))) {
				sb.append("and C_SHA_N_AuditState <> '0' ");
			}
			
			if ("0".equals(Utility.getName(po.getCshanauditstate()))) {
				sb.append("and C_SHA_N_AuditState = '0' ");
			}
			
			if ("notdo".equals(Utility.getName(po.getCshanauditstate()))) {
				sb.append("and C_SHA_N_AuditState = '1' ");
				sb.append("and C_SHA_N_AuditState <> '2' ");
			}
		}

		if (!"".equals(Utility.getName(po.getCshanstartTime()))
				&& !"".equals(Utility.getName(po.getCshanendTime()))) {
			sb.append("and convert(varchar(10), C_SHA_N_createDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_SHA_N_createDate, 23) <= ? ");

			params.add(po.getCshanstartTime());
			params.add(po.getCshanendTime());
		} else if (!"".equals(Utility.getName(po.getCshanstartTime()))
				&& "".equals(Utility.getName(po.getCshanendTime()))) {
			sb.append("and convert(varchar(10), C_SHA_N_createDate, 23) >= ? ");

			params.add(po.getCshanstartTime());
		} else if ("".equals(Utility.getName(po.getCshanstartTime()))
				&& !"".equals(Utility.getName(po.getCshanendTime()))) {
			sb.append("and convert(varchar(10), C_SHA_N_createDate, 23) <= ? ");
			params.add(po.getCshanendTime());
		}

		if (!"".equals(Utility.getName(po.getCshancreatepersonname()))) {
			sb.append("and a.personName like '%'+?+'%' ");
			params.add(po.getCshancreatepersonname());
		}
		if (!"".equals(Utility.getName(po.getCshanauditpersonname()))) {
			sb.append("and b.personName like '%'+?+'%' ");
			params.add(po.getCshanauditpersonname());
		}
		if (!"".equals(Utility.getName(po.getCshanlinkbillID()))) {
			sb.append("and C_SHA_N_linkBillID like '%'+?+'%' ");
			params.add(po.getCshanlinkbillID());
		}
		if (!"".equals(Utility.getName(po.getCshanresponsibilityperson()))) {
			sb.append("and d.personName like '%'+?+'%' ");
			params.add(po.getCshanresponsibilityperson());
		}
		
		if (!"".equals(Utility.getName(po.getCshanchulistate()))) {
			if ("2".equals(Utility.getName(po.getCshanchulistate()))) {
				sb.append(" and isnull(C_SHA_N_AuditState,'') = '2' ");
				
			}else{
				sb.append(" and isnull(C_SHA_N_AuditState,'') <> '2' ");
			}
		}

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 得到不合格品信息
	 */
	public List<NonconformingPo> getNonconformingList(NonconformingPo po,
			int start, int size) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from(select ROW_NUMBER() ");
		sb.append("Over(order by C_SHA_N_billID desc) as rowNum,");

		sb.append("C_SHA_N_billID as cshanbillid,");
		sb.append("C_SHA_N_DepartmentID as cshandepartmentid,");
		sb.append("B_DP_DepartmentName as cshandepartmentname,");
		sb.append("C_SHA_N_createPerson as cshancreateperson,");
		sb.append("a.personName as cshancreatepersonname,");
		sb.append("b.personName as cshanauditpersonname,");
		sb.append("C_SHA_N_createDate as cshancreatedate,");
		sb.append("C_SHA_N_AuditPerson as cshanauditperson,");
		sb.append("C_SHA_N_AuditDate as cshanauditdate,");
		sb.append("C_SHA_N_AuditState as cshanauditstate,");
		sb.append("C_SHA_N_consignMode as cshanconsignmode,");
		sb.append("C_SHA_N_ConsignPerson as cshanconsignperson,");
		sb.append("c.personName as cshanconsignpersonname,");
		sb.append("d.personName as cshanresponsibilityperson,");
		sb.append("C_SHA_N_ConsignDate as cshanconsigndate");
		sb.append(" from C_SHA_Nonconforming ");
		sb
				.append("inner join B_Departments on C_SHA_N_DepartmentID = B_DP_DepartmentID ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_N_createPerson=a.ID ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_N_AuditPerson=b.ID ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo)c on C_SHA_N_ConsignPerson=c.ID ");
		
		sb.append("left join (select ID,personName from SYS_PersonInfo)d on C_SHA_N_Responsibility=d.ID ");
		sb.append("  where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getCshancompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCshancompanyid()));	
		}
		
		if (!"3".equals(Utility.getName(po.getCshandepartmentname().split(",")[0].trim()))&&!"".equals(Utility.getName(po.getCshandepartmentname().split(",")[0].trim()))) {
			if("2".equals(Utility.getName(po.getCshandepartmentname().split(",")[0].trim()))){//加工區域
				sb.append(" and C_SHA_N_DepartmentID in (select b_dp_departmentid from b_departments where B_DP_RegID=? or b_dp_departmentid= ?) ");
				params.add(po.getCshandepartmentname().split(",")[1].trim());//代指部門類別
				params.add(po.getCshandepartmentname().split(",")[1].trim());//本身所在门店
			}else{//門店本身
				sb.append(" and C_SHA_N_DepartmentID=? ");
				params.add(po.getCshandepartmentname().split(",")[1].trim());//代指部門類別
			}
		}	
		
		if (!"".equals(Utility.getName(po.getIscustomize()))) { 
		    sb.append("and C_SHA_N_billID in ( "); 
		    sb.append("select C_SHA_NE_billID from C_SHA_NonconformingEntry "); 
		    sb.append("inner join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID = C_SHA_NonconformingEntry.C_SHA_NE_goodsID"); 
		    sb.append(" inner join B_GoodsCategory on B_GoodsInfo.B_GI_GoodsCategoryID=B_GoodsCategory.B_GC_ID ");//quyanping2011-5-25
			if (!"".equals(Utility.getName(po.getCshansupplierid()))) {
				sb.append("where B_GI_SupplierID = ? ");
				params.add(po.getCshansupplierid());
			}
		    // 按品种查找 
		    if (!"".equals(Utility.getName(po.getIscustomize()))) { 
		    	sb.append(" and B_GI_GoodsCategoryID = ? "); //quyanping2011-5-25   源代码： sb.append("and B_GI_BrandID = ? ");
		    	params.add(po.getIscustomize());
		    }
		  
		    sb.append(") ");
		}
		if (!"".equals(Utility.getName(po.getCshanconsignmode()))) { 
		    sb.append("and C_SHA_N_billID in ( "); 
		    sb.append("select C_SHA_NE_billID from C_SHA_NonconformingEntry "); 
		    if (!"".equals(Utility.getName(po.getCshanconsignmode()))) {
				sb.append("where C_SHA_NE_consignMode= ? ");
				params.add(po.getCshanconsignmode());
			}
		    sb.append(") ");
		}
		if (!"".equals(Utility.getName(po.getCshanbillid()))) {
			sb.append("and C_SHA_N_billID like '%'+?+'%' ");
			params.add(po.getCshanbillid());
		}
		if (!"".equals(Utility.getName(po.getCshandepartmentid()))) {
			sb.append("and C_SHA_N_DepartmentID= ? ");
			params.add(po.getCshandepartmentid());
		}
		if (!"".equals(Utility.getName(po.getCshanauditstate()))) {
			if ("1".equals(Utility.getName(po.getCshanauditstate()))) {
				sb.append("and C_SHA_N_AuditState <> '0' ");
			}
			
			if ("0".equals(Utility.getName(po.getCshanauditstate()))) {
				sb.append("and C_SHA_N_AuditState = '0' ");
			}
			
			if ("notdo".equals(Utility.getName(po.getCshanauditstate()))) {
				sb.append("and C_SHA_N_AuditState = '1' ");
				sb.append("and C_SHA_N_AuditState <> '2' ");
			}
		}
		if (!"".equals(Utility.getName(po.getCshanstartTime()))
				&& !"".equals(Utility.getName(po.getCshanendTime()))) {
			sb.append("and convert(varchar(10), C_SHA_N_createDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_SHA_N_createDate, 23) <= ? ");

			params.add(po.getCshanstartTime());
			params.add(po.getCshanendTime());
		} else if (!"".equals(Utility.getName(po.getCshanstartTime()))
				&& "".equals(Utility.getName(po.getCshanendTime()))) {
			sb.append("and convert(varchar(10), C_SHA_N_createDate, 23) >= ? ");

			params.add(po.getCshanstartTime());
		} else if ("".equals(Utility.getName(po.getCshanstartTime()))
				&& !"".equals(Utility.getName(po.getCshanendTime()))) {
			sb.append("and convert(varchar(10), C_SHA_N_createDate, 23) <= ? ");

			params.add(po.getCshanendTime());
		}
		if (!"".equals(Utility.getName(po.getCshancreatepersonname()))) {
			sb.append("and a.personName like '%'+?+'%' ");
			params.add(po.getCshancreatepersonname());
		}
		if (!"".equals(Utility.getName(po.getCshanauditpersonname()))) {
			sb.append("and b.personName like '%'+?+'%' ");
			params.add(po.getCshanauditpersonname());
		}
		if (!"".equals(Utility.getName(po.getCshanlinkbillID()))) {
			sb.append("and C_SHA_N_linkBillID like '%'+?+'%' ");
			params.add(po.getCshanlinkbillID());
		}
		if (!"".equals(Utility.getName(po.getCshanresponsibilityperson()))) {
			sb.append("and d.personName like '%'+?+'%' ");
			params.add(po.getCshanresponsibilityperson());
		}
		
		if (!"".equals(Utility.getName(po.getCshanchulistate()))) {
			if ("2".equals(Utility.getName(po.getCshanchulistate()))) {
				sb.append(" and isnull(C_SHA_N_AuditState,'') = '2' ");
				
			}else{
				sb.append(" and isnull(C_SHA_N_AuditState,'') <> '2' ");
			}
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ (start + size));
		sb.append("set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(),
				NonconformingPo.class);
	}

	/**
	 * 得到不合格品详细商品信息
	 */
	public List<NonconformingEntryPo> getNonconformingEntryList(
			NonconformingPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("select C_SHA_NE_ID as cshaneid,S_SE_SD_GlassFlag as leftorright,");
		sb.append("C_SHA_NE_billID as cshanebillid,");
		sb.append("C_SHA_NE_goodsID as cshanegoodsid,");
		sb.append("C_SHA_NE_BarCode as cshanebarcode,");
		sb.append("C_SHA_NE_goodsName as cshanegoodsname,");
		sb.append("C_SHA_NE_goodsType as cshanegoodstype,");
		sb.append("C_SHA_NE_reasons1 as cshanereasons1,");
		sb.append("C_SHA_NE_reasons2 as cshanereasons2,");
		sb.append("a.F_NP_content as cshanereasons1name,");
		sb.append("b.F_NP_content as cshanereasons2name,");
		sb.append("C_SHA_NE_remark as cshaneremark,");
		sb.append("C_SHA_NE_consignMode as cshaneconsignmode, ");
		sb.append("B_GoodsInfo.B_GI_isCustomize as iscustomize, ");
		sb.append("S_SE_SD_SalesValue as cshanesalesvalue, ");
		sb.append("C_SHA_NE_SalesDetailID as cshanesalesdetailid, ");
		sb.append("C_SHA_NE_GoodsQuantity as cshanegoodsquantity, ");
		sb.append("case  ");
		sb.append("	when B_DP_WhichRetail = '1' then B_GI_RetailPrice ");
		sb.append("	when B_DP_WhichRetail = '2' then B_GI_RetailPriceA ");
		sb.append("	when B_DP_WhichRetail = '3' then B_GI_RetailPriceB ");
		sb.append("	when B_DP_WhichRetail = '4' then B_GI_RetailPriceC ");
		sb.append("	when B_DP_WhichRetail = '5' then B_GI_RetailPriceD ");
		sb.append("	when B_DP_WhichRetail = '6' then B_GI_RetailPriceE ");
		sb.append("	when B_DP_WhichRetail = '7' then B_GI_RetailPriceF ");
		sb.append("	when B_DP_WhichRetail = '8' then B_GI_RetailPriceG ");
		sb.append("	when B_DP_WhichRetail = '9' then B_GI_RetailPriceH ");
		sb.append("	when B_DP_WhichRetail = '10' then B_GI_RetailPriceI ");
		sb.append("	else B_GI_RetailPrice end AS cshaneretailprice ");
		sb.append(" from C_SHA_NonconformingEntry inner join C_SHA_Nonconforming on C_SHA_NE_billID=C_SHA_N_billID ");
		sb.append(" inner join B_GoodsInfo on C_SHA_NE_goodsID = B_GI_GoodsID ");
		sb.append(" inner join B_Departments on C_SHA_N_DepartmentID = B_DP_DepartmentID ");
		sb.append(" left join (select F_NP_ID,F_NP_content from F_NonconformingProduct)a on C_SHA_NE_reasons1=a.F_NP_ID");
		sb.append(" left join (select F_NP_ID,F_NP_content from F_NonconformingProduct)b on C_SHA_NE_reasons2=b.F_NP_ID");
		sb.append(" left outer join uview_SalesDetail on C_SHA_N_linkBillID=S_SE_SD_SalesID and C_SHA_NE_SalesDetailID = S_SE_SD_ID");
		sb.append(" where C_SHA_NE_billID= ? ");

		params.add(po.getCshanbillid());

		return queryForObjectList(sb.toString(), params.toArray(),
				NonconformingEntryPo.class);
	}

	/**
	 * 根据不合格品ID得到不合格品信息
	 */
	public NonconformingPo getNonconforming(NonconformingPo po) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("select top 1 ");
		sb.append("C_SHA_N_billID as cshanbillid,");
		sb.append("C_SHA_N_DepartmentID as cshandepartmentid,");
		sb.append("B_DP_DepartmentName as cshandepartmentname,");
		sb.append("C_SHA_N_createPerson as cshancreateperson,");
		sb.append("a.personName as cshancreatepersonname,");
		sb.append("b.personName as cshanauditpersonname,");
		sb.append("C_SHA_N_createDate as cshancreatedate,");
		sb.append("C_SHA_N_AuditPerson as cshanauditperson,");
		sb.append("C_SHA_N_AuditDate as cshanauditdate,");
		sb.append("C_SHA_N_AuditState as cshanauditstate,");
		sb.append("C_SHA_N_consignMode as cshanconsignmode,");
		sb.append("C_SHA_N_linkBillID as cshanlinkbillID,");
		sb.append("C_SHA_N_Responsibility as cshanresponsibility , ");
		sb.append("c.personName as cshanresponsibilityperson, ");
		sb.append("C_SHA_N_OutStockID as cshanoutstockid, ");
		sb.append("B_WH_warehouseName as cshanoutstockname, ");
		sb.append("B_DP_WhichRetail as cshanwhichretail ");
		sb.append(" from C_SHA_Nonconforming ");
		sb.append("inner join B_Departments on C_SHA_N_DepartmentID = B_DP_DepartmentID ");
		sb.append("left join B_Warehouse on B_WH_ID = C_SHA_N_OutStockID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_N_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_N_AuditPerson=b.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)c on C_SHA_N_Responsibility=c.ID ");
		sb.append(" where C_SHA_N_billID= ? ");

		params.add(po.getCshanbillid());

		return (NonconformingPo)queryForObject(sb.toString(),params.toArray(), NonconformingPo.class);
	}
	/*
	 * 仓位查询
	 * (non-Javadoc)
	 * @see com.pengsheng.eims.storage.dao.NonconformingDao#getSalesBasicPo(com.pengsheng.eims.storage.persistence.NonconformingPo)
	 */
	public WarehousePo getWarehousePo(String did){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT  top 1   B_WH_ID as bwhid, B_WH_deptID as bwhdeptid, B_WH_warehouseName as bwhwarehouseName ");
		sb.append("FROM         B_Warehouse ");
		sb.append("WHERE     B_WH_deptID = ? ");
		params.add(did);
		
		return (WarehousePo)queryForObject(sb.toString(),params.toArray(), WarehousePo.class);
	}
	
	public SalesBasicPo getSalesBasicPo(NonconformingPo po){
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("SELECT S_SE_SB_BallGlassOD     AS ssesbballglassod, ");
		varname1.append("       S_SE_SB_BallGlassOS     AS ssesbballglassos, ");
		varname1.append("       S_SE_SB_PostGlassOD     AS ssesbpostglassod, ");
		varname1.append("       S_SE_SB_PostGlassOS     AS ssesbpostglassos, ");
		varname1.append("       S_SE_SB_AxesOD          AS ssesbaxesod, ");
		varname1.append("       S_SE_SB_AxesOS          AS ssesbaxesos, ");
		varname1.append("       S_SE_SB_ADDOD           AS ssesbaddod, ");
		varname1.append("       S_SE_SB_ADDOS           AS ssesbaddos, ");
		varname1.append("       S_SE_SB_InterHighOD     AS ssesbinterhighod, ");
		varname1.append("       S_SE_SB_InterHighOS     AS ssesbinterhighos, ");
		varname1.append("       S_SE_SB_InterDistanceOD AS ssesbinterdistanceod, ");
		varname1.append("       S_SE_SB_InterDistanceOS AS ssesbinterdistanceos ");
		varname1.append("FROM   S_SE_SalesBasic ");
		varname1.append("       LEFT JOIN C_SHA_Nonconforming ");
		varname1.append("         ON S_SE_SB_SalesID = C_SHA_N_linkBillID ");
		varname1.append("WHERE  C_SHA_N_billID = ? ");
		
		params.add(po.getCshanbillid());
		
		return (SalesBasicPo)queryForObject(varname1.toString(),params.toArray(), SalesBasicPo.class);
	}
	
	public SalesBasicPo getSalesBasicPoFinished(NonconformingPo po){
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("SELECT S_SE_SB_BallGlassOD     AS ssesbballglassod, ");
		varname1.append("       S_SE_SB_BallGlassOS     AS ssesbballglassos, ");
		varname1.append("       S_SE_SB_PostGlassOD     AS ssesbpostglassod, ");
		varname1.append("       S_SE_SB_PostGlassOS     AS ssesbpostglassos, ");
		varname1.append("       S_SE_SB_AxesOD          AS ssesbaxesod, ");
		varname1.append("       S_SE_SB_AxesOS          AS ssesbaxesos, ");
		varname1.append("       S_SE_SB_ADDOD           AS ssesbaddod, ");
		varname1.append("       S_SE_SB_ADDOS           AS ssesbaddos, ");
		varname1.append("       S_SE_SB_InterHighOD     AS ssesbinterhighod, ");
		varname1.append("       S_SE_SB_InterHighOS     AS ssesbinterhighos, ");
		varname1.append("       S_SE_SB_InterDistanceOD AS ssesbinterdistanceod, ");
		varname1.append("       S_SE_SB_InterDistanceOS AS ssesbinterdistanceos ");
		varname1.append("FROM   S_SE_SalesBasic_Finished ");
		varname1.append("       LEFT JOIN C_SHA_Nonconforming ");
		varname1.append("         ON S_SE_SB_SalesID = C_SHA_N_linkBillID ");
		varname1.append("WHERE  C_SHA_N_billID = ? ");
		
		params.add(po.getCshanbillid());
		
		return (SalesBasicPo)queryForObject(varname1.toString(),params.toArray(), SalesBasicPo.class);
	}

	/**
	 * 信息不合格品信息业务表中
	 */
	public void insertNonconforming(NonconformingPo po) {
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb1.append("insert into C_SHA_Nonconforming(");
		sb1.append("C_SHA_N_billID,");
		sb1.append("C_SHA_N_DepartmentID,");
		sb1.append("C_SHA_N_createPerson,");
		sb1.append("C_SHA_N_createDate,");
		sb1.append("C_SHA_N_AuditState,");
		sb1.append("C_SHA_N_consignMode,");
		sb1.append("C_SHA_N_linkBillID, ");
		sb1.append("C_SHA_N_Responsibility, ");
		sb1.append("C_SHA_N_OutStockID ");
		sb2.append(" ? , ? , ? , getdate() , ? , null , ?, ? ,? ");
		
		params.add(po.getCshanbillid());
		params.add(po.getCshandepartmentid());
		params.add(po.getCshancreateperson());
		params.add(po.getCshanauditstate());
		params.add(po.getCshanlinkbillID());
		params.add(po.getCshanresponsibility());
		params.add(po.getCshanoutstockid());

		if (!"".equals(Utility.getName(po.getCshanauditperson()))) {
			sb1.append(",C_SHA_N_AuditPerson,C_SHA_N_AuditDate");
			sb2.append(", ? , getdate() ");

			params.add(po.getCshanauditperson());
		}

		String sql = sb1.toString() + ")values(" + sb2.toString() + ")";
		getJdbcTemplate().update(sql, params.toArray());
	}

	/**
	 * 新增不合格品信息到不合格品业务详细表中
	 */
	public void insertNonconformingEntry(NonconformingEntryPo po) {
		List<String> params = new ArrayList<String>();
		String sql = "insert into C_SHA_NonconformingEntry(" + "C_SHA_NE_ID,"
				+ "C_SHA_NE_billID," + "C_SHA_NE_goodsID,"
				+ "C_SHA_NE_BarCode," + "C_SHA_NE_goodsName,"
				+ "C_SHA_NE_goodsType," + "C_SHA_NE_reasons1, "
				+ "C_SHA_NE_reasons2, "
				+ "C_SHA_NE_remark,C_SHA_NE_consignMode,C_SHA_NE_SalesDetailID,C_SHA_NE_GoodsQuantity) " +

				"values(? , " + " ? , " + " ? , " + " ? , " + " ? , " + " ? , "
				+ " ? , " + " ? , " + " ? ,?,?,?) ";

		params.add(this.uuid.generate());
		params.add(po.getCshanebillid());
		params.add(po.getCshanegoodsid());
		params.add(po.getCshanebarcode());
		params.add(po.getCshanegoodsname());
		params.add(po.getCshanegoodstype());
		params.add(po.getCshanereasons1());
		params.add(po.getCshanereasons2());
		params.add(po.getCshaneremark());
		params.add(Utility.getName(po.getCshaneconsignmode()));
		params.add(po.getCshanesalesdetailid());
		params.add(Utility.getName(po.getCshanegoodsquantity()));
		
		getJdbcTemplate().update(sql, params.toArray());
	}

	/**
	 * 更新不合格品信息
	 */
	public void updateNonconforming(NonconformingPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("update C_SHA_Nonconforming set ");
		sb.append("C_SHA_N_billID= ? ,");
		sb.append("C_SHA_N_DepartmentID= ? , ");
		sb.append("C_SHA_N_Responsibility = ?, ");
		sb.append("C_SHA_N_OutStockID = ? ");
		params.add(po.getCshanbillid());
		params.add(po.getCshandepartmentid());
		params.add(po.getCshanresponsibility());
		params.add(po.getCshanoutstockid());

		if (!"".equals(Utility.getName(po.getCshanauditperson()))) {
			sb.append(",C_SHA_N_AuditPerson= ? ,");
			sb.append("C_SHA_N_AuditDate=getdate(),");
			sb.append("C_SHA_N_AuditState= ? ");

			params.add(po.getCshanauditperson());
			params.add(po.getCshanauditstate());
		}

		sb.append(" where C_SHA_N_billID= ? ");
		params.add(po.getCshanbillid());
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public void doNonconforming(NonconformingPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("update C_SHA_Nonconforming set ");
		sb.append("C_SHA_N_ConsignPerson=?,C_SHA_N_ConsignDate=getdate(),C_SHA_N_AuditState=2");

		sb.append(" where C_SHA_N_billID= ? ");
		params.add(po.getCshanconsignperson());
		params.add(po.getCshanbillid());
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	/**
	 * 删除不合格品信息
	 */
	public void deleteNonconforming(NonconformingPo po) {
		List<String> params = new ArrayList<String>();

		String sql = "delete from C_SHA_Nonconforming where C_SHA_N_billID= ? ";
		params.add(po.getCshanbillid());
		getJdbcTemplate().update(sql, params.toArray());
	}

	/**
	 * 删除不合格品详细信息
	 */
	public void deleteNonconformingEntry(NonconformingPo po) {
		List<String> params = new ArrayList<String>();

		String sql = "delete from C_SHA_NonconformingEntry where C_SHA_NE_billID= ? ";
		params.add(po.getCshanbillid());
		getJdbcTemplate().update(sql, params.toArray());
	}

	public List<NonconformingPo> getNonconformingList(String shopcode,
			String cshanstartTime, String cshanendTime) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT C_SHA_N_billID as cshanbillid, ");
		buffer.append("B_DP_DepartmentName as cshandepartmentname, ");
		buffer.append("SYS_PersonInfo.personName as cshancreatepersonname, ");
		buffer.append("C_SHA_N_createDate as cshancreatedate ");
		buffer.append("FROM C_SHA_Nonconforming ");
		buffer.append("INNER JOIN B_Departments ON ");
		buffer.append("C_SHA_N_DepartmentID = B_DP_DepartmentID ");
		buffer.append("INNER JOIN SYS_PersonInfo ON ");
		buffer.append("C_SHA_N_createPerson = SYS_PersonInfo.ID ");
		buffer.append("where C_SHA_N_AuditState in (1, 2) and ");
		buffer.append("isnull(C_SHA_N_SumState, '') <> 1 and ");
		buffer.append("C_SHA_N_DepartmentID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(shopcode);

		if (!"".equals(Utility.getName(cshanstartTime))
				&& !"".equals(Utility.getName(cshanendTime))) {
			buffer
					.append("and convert(varchar(10), C_SHA_N_createDate, 23) >= ? ");
			buffer
					.append("and convert(varchar(10), C_SHA_N_createDate, 23) <= ? ");
			params.add(cshanstartTime);
			params.add(cshanendTime);
		} else if (!"".equals(Utility.getName(cshanstartTime))
				&& "".equals(Utility.getName(cshanendTime))) {
			buffer
					.append("and convert(varchar(10), C_SHA_N_createDate, 23) >=  ? ");
			params.add(cshanstartTime);
		} else if ("".equals(Utility.getName(cshanstartTime))
				&& !"".equals(Utility.getName(cshanendTime))) {
			buffer
					.append("and convert(varchar(10), C_SHA_N_createDate, 23) <= ? ");
			params.add(cshanendTime);
		}

		return queryForObjectList(buffer.toString(), params.toArray(),
				NonconformingPo.class);
	}

	public void summaryAllocation(AllocationPo allocationPo) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into C_SHA_Allocation VALUES ");
		buffer.append("(?, getdate(), ?, ?, 'yybbhgpc', '101',  ");
		buffer.append("?, ?, 1, getdate(), null, 0, null, '', 2) ");

		List<String> params = new ArrayList<String>();

		params.add(allocationPo.getCshaabillid());
		params.add(allocationPo.getCshaaoutdepartmentid());
		params.add(allocationPo.getCshaaoutstockid());
		params.add(allocationPo.getCshaacreateperson());
		params.add(allocationPo.getCshaaauditperson());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void summaryAllocationEntry(AllocationPo allocationPo,
			String... billids) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("insert into C_SHA_AllocationEntry ");
		buffer.append("select replace(newid(), '-', ''), ");
		buffer.append("?, C_SHA_NE_goodsID, C_SHA_NE_BarCode, ");
		buffer.append("?, 'yybhgpc', 0, 1 from C_SHA_NonconformingEntry ");
		buffer.append("where C_SHA_NE_billID in (");

		List<String> params = new ArrayList<String>();
		params.add(allocationPo.getCshaabillid());
		params.add(allocationPo.getCshaaoutstockid());

		for (int i = 0; i < billids.length; i++) {
			buffer.append(" ?");
			params.add(billids[i]);

			if (i + 1 != billids.length) {
				buffer.append(" ,");
			} else {
				buffer.append(" )");
			}
		}

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void biilderAllcoactionBarcode(AllocationPo allocationPo,
			String... billids) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("insert into C_SHA_AllocationBarcode ");
		buffer.append("select replace(NEWID(),'-',''),?, C_SHA_NE_goodsID, ");
		buffer.append("C_SHA_NE_BarCode from C_SHA_NonconformingEntry ");
		buffer.append("where C_SHA_NE_billID in (");

		List<String> params = new ArrayList<String>();
		params.add(allocationPo.getCshaabillid());

		for (int i = 0; i < billids.length; i++) {
			buffer.append(" ?");
			params.add(billids[i]);

			if (i + 1 != billids.length) {
				buffer.append(" ,");
			} else {
				buffer.append(" )");
			}
		}
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void updateNonconformingState(String... billids) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("update C_SHA_Nonconforming ");
		buffer.append("set C_SHA_N_SumState = 1 ");
		buffer.append("where C_SHA_N_billID IN ( ");

		List<String> params = new ArrayList<String>();

		for (int i = 0; i < billids.length; i++) {
			buffer.append(" ?");
			params.add(billids[i]);

			if (i + 1 != billids.length) {
				buffer.append(" ,");
			} else {
				buffer.append(" )");
			}
		}

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

}
