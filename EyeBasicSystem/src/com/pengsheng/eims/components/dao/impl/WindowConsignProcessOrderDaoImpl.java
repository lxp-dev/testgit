package com.pengsheng.eims.components.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.components.dao.WindowConsignProcessOrderDao;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;
import com.pengsheng.eims.storage.persistence.SalesTempPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
/**
 * 委外管理的开窗dao实现类
 */
public class WindowConsignProcessOrderDaoImpl extends BaseJdbcDaoSupport implements
		WindowConsignProcessOrderDao {
	/**
	 * 委外订单的销售单数量
	 * @param po 销售单po
	 * @return int 数量
	 */
	public int getSalesBasicForConsignProcessCount(SalesBasicPo po) {
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT DISTINCT inTransit into #dpt FROM ufn_currentintransittab('3') ");
		
		sb.append("select count(S_SE_SalesBasic.S_SE_SB_SalesID) from S_SE_SalesDetail ");
		sb.append("inner join S_SE_SalesBasic on S_SE_SalesDetail.S_SE_SD_SalesID=S_SE_SalesBasic.S_SE_SB_SalesID left join B_Departments on S_SE_SB_ShopCode = B_DP_DepartmentID ");
		sb.append("inner join B_GoodsInfo on S_SE_SalesDetail.S_SE_SD_SalesItemID=B_GoodsInfo.B_GI_GoodsID ");
		sb.append("inner join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		sb.append("where 1=1 and B_GI_isCustomize = 'D' and B_GoodsInfo.B_GI_SupplierID='"+po.getSsesbsupplierid()+"' ");
		sb.append(" and S_SE_SB_InTransit in (SELECT inTransit FROM #dpt) ");
		sb.append("and S_SE_SalesBasic.S_SE_SB_OrdersType='"+po.getSsesborderstype()+"' ");
		sb.append("and (S_SE_SalesDetail.S_SE_SD_GlassFlag='R' OR S_SE_SalesDetail.S_SE_SD_GlassFlag='L') ");
		
		if (!"".equals(Utility.getName(po.getSsesbcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getSsesbcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getSsesbshopcode()))){
			sb.append("and S_SE_SalesBasic.S_SE_SB_ShopCode='"+po.getSsesbshopcode()+"' ");
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){
			sb.append("and S_SE_SalesBasic.S_SE_SB_SalesID like '%' + '"+po.getSsesbsalesid()+"' + '%' ");
		}
		if(!"".equals(Utility.getName(po.getSsesbdragstype()))){
			sb.append("and S_SE_SalesBasic.S_SE_SB_DragsType='"+po.getSsesbdragstype()+"' ");
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_SalesDatetime, 23) >= '"+po.getSsesbsalesdatestarttime()+"' ");
			sb.append("and convert(varchar(10),S_SE_SalesBasic.S_SE_SB_SalesDatetime, 23) <= '"+po.getSsesbsalesdateendtime()+"' ");
		}else if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && "".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_SalesDatetime, 23) >= '"+po.getSsesbsalesdatestarttime()+"' ");
		}else if("".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10),S_SE_SalesBasic.S_SE_SB_SalesDatetime, 23) <= '"+po.getSsesbsalesdateendtime()+"' ");
		}
		if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) >= '"+po.getSsesbtakeglassstartdata()+"'" );
			sb.append("and convert(varchar(10),S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) <= '"+po.getSsesbtakeglassenddata()+"'" );
		}else if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) >= '"+po.getSsesbtakeglassstartdata()+"'" );
		}else if("".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10),S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) <= '"+po.getSsesbtakeglassenddata()+"'" );
		}
		
		sb.append(" drop table #dpt ");
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 未生成委外订单的销售单数量
	 * @param po 销售单po
	 * @return int 数量
	 */
	public int getSalesBasicForConsignProcessCount1(SalesBasicPo po) {
		StringBuffer sb=new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(distinct S_SE_SB_SalesID) from ( ");
		sb.append("select S_SE_SalesBasic.S_SE_SB_SalesID as S_SE_SB_SalesID  from S_SE_SalesDetail ");
		sb.append("inner join S_SE_SalesBasic on S_SE_SalesDetail.S_SE_SD_SalesID=S_SE_SalesBasic.S_SE_SB_SalesID ");
		sb.append("inner join B_GoodsInfo on S_SE_SalesDetail.S_SE_SD_SalesItemID=B_GoodsInfo.B_GI_GoodsID ");
		sb.append("inner join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		sb.append("inner JOIN B_Supplier ON B_Supplier.B_SP_ID= B_GoodsInfo.B_GI_SupplierID ");
		sb.append("INNER JOIN B_Departments ON B_Departments.B_DP_DepartmentID = S_SE_SalesBasic.S_SE_SB_ShopCode ");
		sb.append("left join C_ST_ConsignProcessOrderDetails on S_SE_SalesBasic.S_SE_SB_SalesID = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_GlassesBillID ");
		sb.append("where C_ST_ConsignProcessOrderDetails.C_ST_CPOD_GlassesBillID is null and (B_GoodsInfo.B_GI_GoodsCategoryID='3' or B_GoodsInfo.B_GI_GoodsCategoryID='4') and B_GI_SupplierID<>'ZZ' ");
		sb.append(" and S_SE_SalesBasic.S_SE_SB_OrdersType in ('2','4') ");
		
		sb.append(" and S_SE_SB_InTransit in (SELECT DISTINCT inTransit FROM Ufn_currentintransittab('3')) ");
		
		if (!"".equals(Utility.getName(po.getSsesbcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getSsesbcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getSsesbsupplierid())))
		{
			sb.append(" and B_GoodsInfo.B_GI_SupplierID='"+po.getSsesbsupplierid()+"'  ");
		}
		if(!"".equals(Utility.getName(po.getSsesborderstype())))
		{
			sb.append("and S_SE_SalesBasic.S_SE_SB_OrdersType='"+po.getSsesborderstype()+"' ");
		}
		if(!"".equals(Utility.getName(po.getDjsbm()))){
			sb.append("and S_SE_SalesBasic.S_SE_SB_Djsbm like '%"+po.getDjsbm()+"%' ");
		}		
		if(!"".equals(Utility.getName(po.getSsesbshopcode( )))){
			sb.append("and S_SE_SalesBasic.S_SE_SB_ShopCode='"+po.getSsesbshopcode()+"' ");
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){
			sb.append("and S_SE_SalesBasic.S_SE_SB_SalesID like '%' + '"+po.getSsesbsalesid()+"' + '%' ");
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_PosDatetime, 23) >= '"+po.getSsesbsalesdatestarttime()+"' ");
			sb.append("and convert(varchar(10),S_SE_SalesBasic.S_SE_SB_PosDatetime, 23) <= '"+po.getSsesbsalesdateendtime()+"' ");
		}else if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && "".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_PosDatetime, 23) >= '"+po.getSsesbsalesdatestarttime()+"' ");
		}else if("".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10),S_SE_SalesBasic.S_SE_SB_PosDatetime, 23) <= '"+po.getSsesbsalesdateendtime()+"' ");
		}
		if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) >= '"+po.getSsesbtakeglassstartdata()+"'" );
			sb.append("and convert(varchar(10),S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) <= '"+po.getSsesbtakeglassenddata()+"'" );
		}else if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) >= '"+po.getSsesbtakeglassstartdata()+"'" );
		}else if("".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10),S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) <= '"+po.getSsesbtakeglassenddata()+"'" );
		}
		if(!"".equals(Utility.getName(po.getSsesbgoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + '"+Utility.getName(po.getSsesbgoodsname())+"' + '%' ");
		}
		
		sb.append("group by  S_SE_SalesBasic.S_SE_SB_TakeGlassData ,S_SE_SalesBasic.S_SE_SB_SalesID , " );
		sb.append("S_ME_CustomerInfo.S_ME_CI_Name, " );
		sb.append(" S_SE_SalesBasic.S_SE_SB_OrdersType, " );
		sb.append("B_Departments.B_DP_DepartmentName,B_Supplier.B_SP_ID, " );
		sb.append("B_Supplier.B_SP_SupplierName,S_SE_SalesBasic.S_SE_SB_PosDatetime  " );
		
		sb.append(" ) temp " );
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 *未生成委外订单的销售单list
	 * @param po 销售单po
	 * @param start
	 * @param size
	 * @return list ConsignProcessOrderDetailsPo的list
	 */	
	public List<ConsignProcessOrderDetailsPo> getSalesBasicForConsignProcessList1(
			SalesBasicPo po, int start, int size) {
		
		StringBuffer sb=new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;

		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select * ");		
		sb.append("from(select ROW_NUMBER() Over(order by cstcpoddepartmentname desc) as rowNum,* from ( ");
		sb.append("select S_SE_SalesBasic.S_se_sb_takeglassdata AS cstcpodarriveddate, ");	
		sb.append("S_SE_SalesBasic.S_SE_SB_SalesID AS cstcpodglassesbillid, S_ME_CustomerInfo.S_ME_CI_Name AS cstcpodcustomername, ");
		sb.append("S_SE_SalesBasic.S_SE_SB_OrdersType AS cstcpodbilltype, B_Departments.B_DP_DepartmentName AS cstcpoddepartmentname, ");
		sb.append("B_Supplier.B_SP_ID AS cstcposupplierid, B_Supplier.B_SP_SupplierName AS cstcposuppliername, ");
		sb.append("S_SE_SalesBasic.S_SE_SB_PosDatetime AS cstcpodsalesdatetime,S_SE_SB_InTransit ");
		sb.append("FROM S_SE_SalesDetail ");
		
		sb.append("INNER JOIN S_SE_SalesBasic ON S_SE_SalesDetail.S_SE_SD_SalesID = S_SE_SalesBasic.S_SE_SB_SalesID ");
		sb.append("INNER JOIN B_GoodsInfo ON S_SE_SalesDetail.S_SE_SD_SalesItemID = B_GoodsInfo.B_GI_GoodsID ");
		sb.append("INNER JOIN B_Supplier ON B_Supplier.B_SP_ID= B_GoodsInfo.B_GI_SupplierID ");
		sb.append("INNER JOIN S_ME_CustomerInfo ON S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		sb.append("INNER JOIN B_Departments ON B_Departments.B_DP_DepartmentID = S_SE_SalesBasic.S_SE_SB_ShopCode ");
		sb.append("left join C_ST_ConsignProcessOrderDetails on S_SE_SalesBasic.S_SE_SB_SalesID = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_GlassesBillID ");
		
		sb.append("WHERE C_ST_ConsignProcessOrderDetails.C_ST_CPOD_GlassesBillID is null and  (B_GoodsInfo.B_GI_GoodsCategoryID='3' or B_GoodsInfo.B_GI_GoodsCategoryID='4') and B_GI_SupplierID<>'ZZ' ");
		sb.append(" and S_SE_SalesBasic.S_SE_SB_OrdersType in ('2','4') ");
		
		if (!"".equals(Utility.getName(po.getSsesbcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getSsesbcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getSsesbsupplierid())))
		{
			sb.append(" and B_GoodsInfo.B_GI_SupplierID='"+po.getSsesbsupplierid()+"'  ");
		}
		if(!"".equals(Utility.getName(po.getSsesborderstype())))
		{
			sb.append("and S_SE_SalesBasic.S_SE_SB_OrdersType='"+po.getSsesborderstype()+"' ");
		}
		if(!"".equals(Utility.getName(po.getDjsbm()))){
			sb.append("and S_SE_SalesBasic.S_SE_SB_Djsbm like '%"+po.getDjsbm()+"%' ");
		}		
		if(!"".equals(Utility.getName(po.getSsesbshopcode()))){
			sb.append("and S_SE_SalesBasic.S_SE_SB_ShopCode='"+po.getSsesbshopcode()+"' ");
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){
			sb.append("and S_SE_SalesBasic.S_SE_SB_SalesID like '%' + '"+po.getSsesbsalesid()+"' + '%' ");
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_PosDatetime, 23) >= '"+po.getSsesbsalesdatestarttime()+"' ");
			sb.append("and convert(varchar(10),S_SE_SalesBasic.S_SE_SB_PosDatetime, 23) <= '"+po.getSsesbsalesdateendtime()+"' ");
		}else if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && "".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_PosDatetime, 23) >= '"+po.getSsesbsalesdatestarttime()+"' ");
		}else if("".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10),S_SE_SalesBasic.S_SE_SB_PosDatetime, 23) <= '"+po.getSsesbsalesdateendtime()+"' ");
		}
		if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) >= '"+po.getSsesbtakeglassstartdata()+"'" );
			sb.append("and convert(varchar(10),S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) <= '"+po.getSsesbtakeglassenddata()+"'" );
		}else if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) >= '"+po.getSsesbtakeglassstartdata()+"'" );
		}else if("".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10),S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) <= '"+po.getSsesbtakeglassenddata()+"'" );
		}
		if(!"".equals(Utility.getName(po.getSsesbgoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + '"+Utility.getName(po.getSsesbgoodsname())+"' + '%' ");
		}
		
		sb.append("group by  S_SE_SalesBasic.S_SE_SB_TakeGlassData ,S_SE_SalesBasic.S_SE_SB_SalesID , " );
		sb.append("S_ME_CustomerInfo.S_ME_CI_Name, " );
		sb.append(" S_SE_SalesBasic.S_SE_SB_OrdersType, " );
		sb.append("B_Departments.B_DP_DepartmentName,B_Supplier.B_SP_ID, " );
		sb.append("B_Supplier.B_SP_SupplierName,S_SE_SalesBasic.S_SE_SB_PosDatetime,S_SE_SB_InTransit  " );
		
		sb.append(" )temp where S_SE_SB_InTransit in (SELECT DISTINCT inTransit FROM Ufn_currentintransittab('3'))) temp");		
		sb.append("  where rowNum > "+start+" and rowNum <= "+ countPage);
		
		sb.append(" set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(), ConsignProcessOrderDetailsPo.class);
	}
	
	public List<SupplierPo> getSuppliersalse(DepartmentsPo departmentsPo)
	{
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("select B_SP_ID AS bspid,B_SP_SupplierName AS bspsuppliername,B_SP_ForShort as bspfroshort from S_SE_SalesBasic ");
		varname1.append(" inner join  S_SE_SalesDetail ON S_SE_SalesDetail.S_SE_SD_SalesID = S_SE_SalesBasic.S_SE_SB_SalesID ");
		varname1.append(" inner join B_GoodsInfo on S_SE_SalesDetail.S_SE_SD_SalesItemID=B_GoodsInfo.B_GI_GoodsID ");
		varname1.append(" inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		varname1.append(" left join B_Departments on S_SE_SB_ShopCode = B_DP_DepartmentID  ");
		varname1.append("left join C_ST_ConsignProcessOrderDetails on S_SE_SalesBasic.S_SE_SB_SalesID = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_GlassesBillID ");
		varname1.append(" WHERE C_ST_ConsignProcessOrderDetails.C_ST_CPOD_GlassesBillID is null ");
		varname1.append(" and S_SE_SB_InTransit in (SELECT DISTINCT inTransit FROM Ufn_currentintransittab('3')) ");
		varname1.append("and S_SE_SalesBasic.S_SE_SB_OrdersType in ('2','4')  ");
		varname1.append(" AND substring(S_SE_SalesDetail.S_SE_SD_SalesItemID,1,1) IN ( '3', '4' ) ");
		varname1.append("AND B_SP_ID <> 'zz'  ");
		
		if (!"".equals(Utility.getName(departmentsPo.getBdpcompanysid()))){
			varname1.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(departmentsPo.getBdpcompanysid()));	
		}
		
		varname1.append("group by B_SP_ID,B_SP_SupplierName,B_SP_ForShort ");
		varname1.append("ORDER  BY B_SP_SupplierName ");	
		
		return queryForObjectList(varname1.toString(),params.toArray(), SupplierPo.class);
	}
	
	public List<SupplierPo> getSupplierOrdersalse()
	{
		StringBuffer  varname1 = new StringBuffer();
		varname1.append("SELECT DISTINCT inTransit into #dpt FROM ufn_currentintransittab('4') ");
		varname1.append("select B_SP_ID AS bspid,B_SP_SupplierName AS bspsuppliername,B_SP_ForShort as bspfroshort  from C_ST_ConsignProcessOrderDetails  ");
		varname1.append("inner join C_ST_ConsignProcessOrder on C_ST_ConsignProcessOrder.C_ST_CPO_OrderBillId = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_OrderBillD  ");
		varname1.append("inner join B_Supplier on B_Supplier.B_SP_ID = C_ST_ConsignProcessOrder.C_ST_CPO_SupplierId  ");
		varname1.append("inner join B_Brand on B_BD_ID = substring(C_ST_CPOD_GoodsID,6,2) and substring(C_ST_CPOD_GoodsID,3,2) = B_BD_SupplierID  ");		
		varname1.append("left  join S_SE_SalesBasic on S_SE_SalesBasic.S_SE_SB_SalesID = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_GlassesBillID  ");
		varname1.append("inner join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SalesBasic.S_SE_SB_ShopCode  ");
		varname1.append("where C_ST_CPOD_State = '0' and C_ST_CPO_AuditState = '1'  ");
		varname1.append(" and (S_SE_SB_InTransit in (SELECT inTransit FROM #dpt) or C_ST_CPOD_OrderType = 'W') ");
		varname1.append("group by B_SP_ID,B_SP_SupplierName,B_SP_ForShort ");
		varname1.append("ORDER  BY B_SP_SupplierName ");
		
		return queryForObjectList(varname1.toString(), null, SupplierPo.class);
	}
	
	public List<SupplierPo> getSupplierOrdersalse(DepartmentsPo departmentsPo)
	{
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("SELECT DISTINCT inTransit into #dpt FROM ufn_currentintransittab('4') ");
		varname1.append("select B_SP_ID AS bspid,B_SP_SupplierName AS bspsuppliername,B_SP_ForShort as bspfroshort  from C_ST_ConsignProcessOrderDetails  ");
		varname1.append("inner join C_ST_ConsignProcessOrder on C_ST_ConsignProcessOrder.C_ST_CPO_OrderBillId = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_OrderBillD  ");
		varname1.append("inner join B_Supplier on B_Supplier.B_SP_ID = C_ST_ConsignProcessOrder.C_ST_CPO_SupplierId  ");
		varname1.append("inner join B_Brand on B_BD_ID = substring(C_ST_CPOD_GoodsID,6,2) and substring(C_ST_CPOD_GoodsID,3,2) = B_BD_SupplierID  ");		
		varname1.append("left  join S_SE_SalesBasic on S_SE_SalesBasic.S_SE_SB_SalesID = C_ST_ConsignProcessOrderDetails.C_ST_CPOD_GlassesBillID  ");
		varname1.append("inner join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SalesBasic.S_SE_SB_ShopCode  ");
		varname1.append("where C_ST_CPOD_State = '0' and C_ST_CPO_AuditState = '1'  ");
		varname1.append(" and (S_SE_SB_InTransit in (SELECT inTransit FROM #dpt) or C_ST_CPOD_OrderType = 'W') ");
		
		if (!"".equals(Utility.getName(departmentsPo.getBdpcompanysid()))){
			varname1.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(departmentsPo.getBdpcompanysid()));	
		}
		
		varname1.append("group by B_SP_ID,B_SP_SupplierName,B_SP_ForShort ");
		varname1.append("ORDER  BY B_SP_SupplierName ");
		
		return queryForObjectList(varname1.toString(), params.toArray(), SupplierPo.class);
	}
	
	
	/**
	 * 委外订单的销售单list
	 * @param po 销售单po
	 * @param start
	 * @param size
	 * @return list ConsignProcessOrderDetailsPo的list
	 */	
	public List<ConsignProcessOrderDetailsPo> getSalesBasicForConsignProcessList(
			SalesBasicPo po, int start, int size) {
		StringBuffer sb=new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		sb.append("SELECT DISTINCT inTransit into #dpt FROM ufn_currentintransittab('3') ");
		
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select * ");		
		sb.append("from(select ROW_NUMBER() Over(order by S_SE_SalesBasic.S_SE_SB_SalesID desc) as rowNum,S_SE_SD_ID as cstcpodsalesid,S_SE_SalesBasic.S_SE_SB_TakeGlassData as cstcpodarriveddate,S_ME_CustomerInfo.S_ME_CI_CustomerID as cstcpodcustomerid,");
		sb.append("S_SE_SalesBasic.S_SE_SB_SalesID as cstcpodglassesbillid,S_ME_CustomerInfo.S_ME_CI_Name as cstcpodcustomername,S_SE_SalesDetail.S_SE_SD_SalesItemID as cstcpodgoodsid,S_SE_SalesDetail.S_SE_SD_ItemID as cstcpodgoodsbarcode,");
		sb.append("S_SE_SalesBasic.S_SE_SB_OrdersType as cstcpodbilltype,S_SE_SalesDetail.S_SE_SD_GlassFlag as cstcpodglassflag,S_SE_SalesDetail.S_SE_SD_SalesItemName as cstcpodgoodsname,S_SE_SalesDetail.S_SE_SD_Number as cstcpodnum,");
		sb.append("CASE WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag='R' THEN S_SE_SalesBasic.S_SE_SB_BallGlassOD ELSE S_SE_SalesBasic.S_SE_SB_BallGlassOS END AS cstcpodballglass,");
		
		sb.append("CASE WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = 'R' THEN S_SE_SalesBasic.S_SE_SB_InterHighOD  ELSE S_SE_SalesBasic.S_SE_SB_InterHighOS  END AS cstcpodinter,");
		sb.append("CASE WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = 'R' THEN S_SE_SalesBasic.S_SE_SB_InterDistanceOD ELSE S_SE_SalesBasic.S_SE_SB_InterDistanceOS  END  AS cstcpodinterdistance,");

		
		sb.append("CASE WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag='R' THEN S_SE_SalesBasic.S_SE_SB_PostGlassOD ELSE S_SE_SalesBasic.S_SE_SB_PostGlassOS END AS cstcpodpostglass,");
		sb.append("CASE WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag='R' THEN S_SE_SalesBasic.S_SE_SB_AxesOD ELSE S_SE_SalesBasic.S_SE_SB_AxesOS END AS cstcpodaxes,");
		sb.append("CASE WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag='R' THEN S_SE_SalesBasic.S_SE_SB_ADDOD ELSE S_SE_SalesBasic.S_SE_SB_ADDOS END AS cstcpodadd,");
		sb.append("CASE WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag='R' THEN S_SE_SalesBasic.S_SE_SB_ArriseGlassOD1 ELSE S_SE_SalesBasic.S_SE_SB_ArriseGlassOS1 END AS cstcpodarriseglass,");
		sb.append("CASE WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag='R' THEN S_SE_SalesBasic.S_SE_SB_BasisOD1 ELSE S_SE_SalesBasic.S_SE_SB_BasisOS1 END AS cstcpodbasis,");
		sb.append("CASE WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag='R' THEN S_SE_SalesBasic.S_SE_SB_EyeCurvatureOD1 ELSE S_SE_SalesBasic.S_SE_SB_EyeCurvatureOS1 END AS cstcpodeyecurvature,");
		sb.append("CASE WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag='R' THEN S_SE_SalesBasic.S_SE_SB_DiameterOD ELSE S_SE_SalesBasic.S_SE_SB_DiameterOS END AS cstcpoddiameter,");
		sb.append("(SELECT dbo.getRequirement(S_SE_SalesBasic.S_SE_SB_SalesID)) AS cstcpodrequirement, ");
		sb.append("CASE ");
		sb.append("WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = 'R' THEN (SELECT dbo.Getrequirement2(S_SE_SalesBasic.S_SE_SB_SalesID,'l')) ");
		sb.append("WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = 'l' THEN (SELECT dbo.Getrequirement2(S_SE_SalesBasic.S_SE_SB_SalesID,'r')) ");
		sb.append("END  AS cstcpodrequirement1 ,");
		sb.append("CASE ");
		sb.append("WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = 'R' THEN (SELECT dbo.Getrequirementsid(S_SE_SalesBasic.S_SE_SB_SalesID,'R')) ");
		sb.append("WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = 'l' THEN (SELECT dbo.Getrequirementsid(S_SE_SalesBasic.S_SE_SB_SalesID,'l')) ");
		sb.append("WHEN S_SE_SalesDetail.S_SE_SD_GlassFlag = '' THEN (SELECT dbo.Getrequirementsid(S_SE_SalesBasic.S_SE_SB_SalesID,'p')) ");
		sb.append("END AS cstcpodrequirement2,S_SE_SB_DragsType as cstcpoddragstype ");
		sb.append("from S_SE_SalesDetail ");
		sb.append("inner join S_SE_SalesBasic on S_SE_SalesDetail.S_SE_SD_SalesID=S_SE_SalesBasic.S_SE_SB_SalesID left join B_Departments on S_SE_SB_ShopCode = B_DP_DepartmentID ");
		sb.append("inner join B_GoodsInfo on S_SE_SalesDetail.S_SE_SD_SalesItemID=B_GoodsInfo.B_GI_GoodsID ");
		sb.append("inner join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		sb.append("where 1=1 and B_GI_isCustomize = 'D' and  B_GoodsInfo.B_GI_SupplierID='"+po.getSsesbsupplierid()+"' ");
		sb.append(" and S_SE_SB_InTransit in (SELECT inTransit FROM #dpt) ");
		sb.append("and S_SE_SalesBasic.S_SE_SB_OrdersType='"+po.getSsesborderstype()+"' ");
		sb.append("and (S_SE_SalesDetail.S_SE_SD_GlassFlag='R' OR S_SE_SalesDetail.S_SE_SD_GlassFlag='L') ");
		
		if (!"".equals(Utility.getName(po.getSsesbcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getSsesbcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getSsesbshopcode()))){
			sb.append("and S_SE_SalesBasic.S_SE_SB_ShopCode='"+po.getSsesbshopcode()+"' ");
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){
			sb.append("and S_SE_SalesBasic.S_SE_SB_SalesID like '%' + '"+po.getSsesbsalesid()+"' + '%' ");
		}
		if(!"".equals(Utility.getName(po.getSsesbdragstype()))){
			sb.append("and S_SE_SalesBasic.S_SE_SB_DragsType='"+po.getSsesbdragstype()+"' ");
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_SalesDatetime, 23) >= '"+po.getSsesbsalesdatestarttime()+"' ");
			sb.append("and convert(varchar(10),S_SE_SalesBasic.S_SE_SB_SalesDatetime, 23) <= '"+po.getSsesbsalesdateendtime()+"' ");
		}else if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && "".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_SalesDatetime, 23) >= '"+po.getSsesbsalesdatestarttime()+"' ");
		}else if("".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10),S_SE_SalesBasic.S_SE_SB_SalesDatetime, 23) <= '"+po.getSsesbsalesdateendtime()+"' ");
		}
		if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) >= '"+po.getSsesbtakeglassstartdata()+"'" );
			sb.append("and convert(varchar(10),S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) <= '"+po.getSsesbtakeglassenddata()+"'" );
		}else if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10), S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) >= '"+po.getSsesbtakeglassstartdata()+"'" );
		}else if("".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10),S_SE_SalesBasic.S_SE_SB_TakeGlassData, 23) <= '"+po.getSsesbtakeglassenddata()+"'" );
		}
		sb.append(" ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		
		sb.append(" drop table #dpt ");
		
		return queryForObjectList(sb.toString(), params.toArray(), ConsignProcessOrderDetailsPo.class);
	}
	
	
	
	
	/**
	 * 委外订单的商品数量
	 * @param po GoodsInfoPo
	 * @return int 数量
	 */		
	public int getGoodsForConsignProcessCount(GoodsInfoPo po) {
		StringBuffer sb=new StringBuffer();
		sb.append("select count(B_GoodsInfo.B_GI_GoodsID)  from B_GoodsInfo ");
		sb.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
//		sb.append("inner join B_Variety on B_GoodsInfo.B_GI_VarietyID=B_Variety.B_VY_ID and B_GoodsInfo.B_GI_BrandID=B_Variety.B_VY_BrandID and B_GoodsInfo.B_GI_SupplierID=B_Variety.B_VY_SupplierID and B_GoodsInfo.B_GI_GoodsCategoryID=B_Variety.B_VY_GcID ");
		sb.append("inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id ");
		sb.append("where B_GoodsInfo.B_GI_Flag='1' ");
		sb.append("and B_GoodsInfo.B_GI_GoodsCategoryID='"+po.getBgigoodscategoryid()+"' ");
		sb.append("and B_GoodsInfo.B_GI_isCustomize='D' ");
		sb.append("and B_GoodsInfo.B_GI_SupplierID='"+po.getBgisupplierid()+"' ");
		if(!"".equals(Utility.getName(po.getBgigoodsid()))){
			sb.append(" and B_GoodsInfo.B_GI_GoodsID='"+po.getBgigoodsid()+"'");
		}
		if(!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%"+po.getBgigoodsname()+"%'");
		}
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append("and B_GoodsInfo.B_GI_BrandID='"+po.getBgibrandid()+"' ");
		}
		if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append("and B_GI_EyeGlassMaterialType='"+po.getBgieyeglassmaterialtype()+"' ");
		}
		if(!"".equals(Utility.getName(po.getBgisph()))){
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_SphUL,120)>="+po.getBgisph()+" ");
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_SphUP,120)<="+po.getBgisph()+" ");		
		}
		if(!"".equals(Utility.getName(po.getBgicyl()))){
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_CylUL,120)>="+po.getBgicyl()+" ");
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_CylUP,120)<="+po.getBgicyl()+" ");		
		}
		if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_BelowPlusLuminosityUL,120)>="+po.getBgibelowplusluminosity()+" ");
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_BelowPlusLuminosityUP,120)<="+po.getBgibelowplusluminosity()+" ");		
		}
		
		if(!"".equals(Utility.getName(po.getBgicurvature1()))){
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_Curvature1UL,120)>="+po.getBgicurvature1()+" ");
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_Curvature1UP,120)<="+po.getBgicurvature1()+" ");		
		}
		if(!"".equals(Utility.getName(po.getBgicurvature2()))){
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_Curvature2UL,120)>="+po.getBgicurvature2()+" ");
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_Curvature2UP,120)<="+po.getBgicurvature2()+" ");		
		}
		if(!"".equals(Utility.getName(po.getBgidia()))){
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_DiaUL,120)>="+po.getBgidia()+" ");
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_DiaUP,120)<="+po.getBgidia()+" ");		
		}
		return getJdbcTemplate().queryForInt(sb.toString());
	}
	/**
	 * 委外订单的商品list
	 * @param po GoodsInfoPo
	 * @param start
	 * @param size
	 * @return list ConsignProcessOrderDetailsPo的list
	 */	
	public List<ConsignProcessOrderDetailsPo> getGoodsForConsignProcessList(GoodsInfoPo po,
			int start, int size) {
		StringBuffer sb=new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from");
		sb.append("(select ROW_NUMBER() Over(order by B_GoodsInfo.B_GI_GoodsID) as rowNum,");
		sb.append("B_GoodsInfo.B_GI_GoodsID as cstcpodgoodsid,B_GoodsInfo.B_GI_ViewGoodsName as cstcpodgoodsname,");
		sb.append("B_Unit.B_UT_unitName as cstcpounitname,B_GoodsInfo.B_GI_Spec as cstcpobgispec,");
		sb.append("B_GoodsInfo.B_GI_RetailPrice as cstcporetailprice  from B_GoodsInfo ");
		sb.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
//		sb.append("inner join B_Variety on B_GoodsInfo.B_GI_VarietyID=B_Variety.B_VY_ID and B_GoodsInfo.B_GI_BrandID=B_Variety.B_VY_BrandID and B_GoodsInfo.B_GI_SupplierID=B_Variety.B_VY_SupplierID and B_GoodsInfo.B_GI_GoodsCategoryID=B_Variety.B_VY_GcID ");
		sb.append("inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id ");
		sb.append("where B_GoodsInfo.B_GI_Flag='1' ");
		sb.append("and B_GoodsInfo.B_GI_GoodsCategoryID='"+po.getBgigoodscategoryid()+"' ");
		sb.append("and B_GoodsInfo.B_GI_isCustomize='D' ");
		sb.append("and B_GoodsInfo.B_GI_SupplierID='"+po.getBgisupplierid()+"' ");
		if(!"".equals(Utility.getName(po.getBgigoodsid()))){
			sb.append(" and B_GoodsInfo.B_GI_GoodsID='"+po.getBgigoodsid()+"'");
		}
		if(!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%"+po.getBgigoodsname()+"%'");
		}
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append("and B_GoodsInfo.B_GI_BrandID='"+po.getBgibrandid()+"' ");
		}

		if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append("and B_GI_EyeGlassMaterialType='"+po.getBgieyeglassmaterialtype()+"' ");
		}
		if(!"".equals(Utility.getName(po.getBgisph()))){
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_SphUL,120)>="+po.getBgisph()+" ");
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_SphUP,120)<="+po.getBgisph()+" ");		
		}
		if(!"".equals(Utility.getName(po.getBgicyl()))){
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_CylUL,120)>="+po.getBgicyl()+" ");
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_CylUP,120)<="+po.getBgicyl()+" ");		
		}
		if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_BelowPlusLuminosityUL,120)>="+po.getBgibelowplusluminosity()+" ");
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_BelowPlusLuminosityUP,120)<="+po.getBgibelowplusluminosity()+" ");		
		}	
		
		if(!"".equals(Utility.getName(po.getBgicurvature1()))){
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_Curvature1UL,120)>="+po.getBgicurvature1()+" ");
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_Curvature1UP,120)<="+po.getBgicurvature1()+" ");		
		}
		if(!"".equals(Utility.getName(po.getBgicurvature2()))){
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_Curvature2UL,120)>="+po.getBgicurvature2()+" ");
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_Curvature2UP,120)<="+po.getBgicurvature2()+" ");		
		}
		if(!"".equals(Utility.getName(po.getBgidia()))){
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_DiaUL,120)>="+po.getBgidia()+" ");
			sb.append("and convert(numeric(12,2),B_GoodsInfo.B_GI_DiaUP,120)<="+po.getBgidia()+" ");		
		}
		sb.append(" ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), null, ConsignProcessOrderDetailsPo.class);
	}
	/**
	 * 外部的委外订单的数量
	 * @param po ConsignProcessOrderDetailsPo
	 * @return int 数量
	 */	
	public int getGoodsForConsignProcessReceiptCount(
			ConsignProcessOrderDetailsPo po) {
		StringBuffer sb=new StringBuffer();
		sb.append("select count(C_ST_CPOD_GlassesBillID) from C_ST_ConsignProcessReceiptDetails ");
		sb.append(" inner join C_ST_ConsignProcessReceipt on C_ST_CPR_ReceiptBillId=C_ST_CPRD_ReceiptBillD ");
		sb.append(" inner join C_ST_ConsignProcessOrderDetails on C_ST_ConsignProcessOrderDetails.C_ST_CPOD_Id=C_ST_ConsignProcessReceiptDetails.C_ST_CPRD_OrderDetailsID ");
		sb.append(" inner join B_GoodsInfo on C_ST_CPRD_GoodsID=B_GI_GoodsID");
		sb.append(" where C_ST_CPOD_OrderType='W'");
		sb.append(" and C_ST_CPR_AuditState='1'");
		List<String> params = new ArrayList<String>();

		if(!"".equals(Utility.getName(po.getCstcpodglassesbillid()))){
			sb.append(" and C_ST_CPOD_GlassesBillID=?");			
			params.add(po.getCstcpodglassesbillid());
		}

		sb.append(" and C_ST_CPOD_GlassesBillID not in(select distinct C_ST_DE_GlassesBillId from C_ST_DeliverEntry ");

		if(!"".equals(Utility.getName(po.getCstcpodglassesbillid()))){
			sb.append(" where C_ST_DE_GlassesBillId=?");			
			params.add(po.getCstcpodglassesbillid());
		}
		sb.append(")");
		if(!"".equals(Utility.getName(po.getCstcpodarrivedstart())) && !"".equals(Utility.getName(po.getCstcpodarrivedend()))){
			sb.append(" and convert(varchar(10), C_ST_CPR_BillDate, 23) >= ? ");
			sb.append(" and convert(varchar(10),C_ST_CPR_BillDate, 23) <= ? ");
			params.add(po.getCstcpodarrivedstart());
			params.add(po.getCstcpodarrivedend());
		}else if(!"".equals(Utility.getName(po.getCstcpodarrivedstart())) && "".equals(Utility.getName(po.getCstcpodarrivedend()))){
			sb.append(" and convert(varchar(10), C_ST_CPR_BillDate, 23) >= ? ");
			params.add(po.getCstcpodarrivedstart());
		}else if("".equals(Utility.getName(po.getCstcpodarrivedstart())) && !"".equals(Utility.getName(po.getCstcpodarrivedend()))){
			sb.append(" and convert(varchar(10),C_ST_CPR_BillDate, 23) <= ? ");
			params.add(po.getCstcpodarrivedend());
		}

		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	/**
	 * 外部的委外订单的list
	 * @param po ConsignProcessOrderDetailsPo
	 * @param start
	 * @param size
	 * @return list ConsignProcessOrderDetailsPo的list
	 */	
	public List<ConsignProcessOrderDetailsPo> getGoodsForConsignProcessReceiptList(
			ConsignProcessOrderDetailsPo po, int start, int size) {
		
		StringBuffer sb=new StringBuffer();
		
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * ");
		sb.append(" from(select ROW_NUMBER() ");
		sb.append("Over(order by C_ST_CPOD_GlassesBillID,C_ST_CPOD_GlassFlag desc) as rowNum,");		
		sb.append("C_ST_CPOD_GlassesBillID as cstcpodglassesbillid,");
		sb.append("C_ST_CPRD_ReceiptBillD as cstcprdreceiptbilld,C_ST_CPRD_OrderDetailsID as cstcpodid,");
		sb.append("C_ST_CPOD_GlassFlag as cstcpodglassflag,C_ST_CPRD_GoodsID as cstcpodgoodsid,");
		sb.append("C_ST_CPRD_BarCode as cstcpodgoodsbarcode,B_GI_ViewGoodsName as cstcpodgoodsname,");
		sb.append("C_ST_CPOD_BallGlass as cstcpodballglass,C_ST_CPOD_PostGlass as cstcpodpostglass,");
		sb.append("C_ST_CPOD_Axes as cstcpodaxes,C_ST_CPOD_Add as cstcpodadd,");
		sb.append("C_ST_CPOD_ArriseGlass as cstcpodarriseglass,C_ST_CPOD_Basis as cstcpodbasis,");
		sb.append("C_ST_CPOD_EyeCurvature as cstcpodeyecurvature,C_ST_CPOD_Diameter as cstcpoddiameter,");
		sb.append("C_ST_CPOD_Requirement as cstcpodrequirement,C_ST_CPOD_customerName as cstcpodcustomername,");
		sb.append("C_ST_CPRD_Num as cstcpodnum from C_ST_ConsignProcessReceiptDetails ");
		sb.append(" inner join C_ST_ConsignProcessReceipt on C_ST_CPR_ReceiptBillId=C_ST_CPRD_ReceiptBillD ");
		sb.append(" inner join C_ST_ConsignProcessOrderDetails on C_ST_ConsignProcessOrderDetails.C_ST_CPOD_Id=C_ST_ConsignProcessReceiptDetails.C_ST_CPRD_OrderDetailsID ");
		sb.append(" inner join B_GoodsInfo on C_ST_CPRD_GoodsID=B_GI_GoodsID");
		sb.append(" where C_ST_CPOD_OrderType='W'");
		sb.append(" and C_ST_CPR_AuditState='1'");

		List<String> params = new ArrayList<String>();		

		if(!"".equals(Utility.getName(po.getCstcpodglassesbillid()))){
			sb.append(" and C_ST_CPOD_GlassesBillID=?");			
			params.add(po.getCstcpodglassesbillid());
		}

		sb.append(" and C_ST_CPOD_GlassesBillID not in(select distinct C_ST_DE_GlassesBillId from C_ST_DeliverEntry ");

		if(!"".equals(Utility.getName(po.getCstcpodglassesbillid()))){
			sb.append(" where C_ST_DE_GlassesBillId=?");			
			params.add(po.getCstcpodglassesbillid());
		}
		sb.append(")");
		if(!"".equals(Utility.getName(po.getCstcpodarrivedstart())) && !"".equals(Utility.getName(po.getCstcpodarrivedend()))){
			sb.append(" and convert(varchar(10), C_ST_CPR_BillDate, 23) >= ? ");
			sb.append(" and convert(varchar(10),C_ST_CPR_BillDate, 23) <= ? ");
			params.add(po.getCstcpodarrivedstart());
			params.add(po.getCstcpodarrivedend());
		}else if(!"".equals(Utility.getName(po.getCstcpodarrivedstart())) && "".equals(Utility.getName(po.getCstcpodarrivedend()))){
			sb.append(" and convert(varchar(10), C_ST_CPR_BillDate, 23) >= ? ");
			params.add(po.getCstcpodarrivedstart());
		}else if("".equals(Utility.getName(po.getCstcpodarrivedstart())) && !"".equals(Utility.getName(po.getCstcpodarrivedend()))){
			sb.append(" and convert(varchar(10),C_ST_CPR_BillDate, 23) <= ? ");
			params.add(po.getCstcpodarrivedend());
		}		
		sb.append(" ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		
		
		return queryForObjectList(sb.toString(), params.toArray(), ConsignProcessOrderDetailsPo.class);
	}
	
	/**
	 * 外部的委外收货单的数量
	 * @param po ConsignProcessReceiptPo
	 * @return int 数量
	 */		
	public int getConsignProcessReceiptCount(ConsignProcessReceiptPo po){
		
		StringBuffer sb=new StringBuffer();
		sb.append("select count(distinct(C_ST_CPR_ReceiptBillId))");
		sb.append(" from C_ST_ConsignProcessReceipt ");
		sb.append(" inner join C_ST_ConsignProcessReceiptDetails on C_ST_CPR_ReceiptBillId=C_ST_CPRD_ReceiptBillD");
		sb.append(" left join (select ID,personName from SYS_PersonInfo) a on C_ST_CPR_CreatePerson=a.ID");
		sb.append(" left join (select ID,personName from SYS_PersonInfo) b on C_ST_CPR_AuditPerson=b.ID");
		sb.append(" where C_ST_CPR_AuditState='1'");
		sb.append(" and C_ST_CPR_ReceiptBillId not in(select distinct C_ST_DE_ReceiptBillId from C_ST_DeliverEntry )");
		
		
		List<String> params = new ArrayList<String>();
		
		if(!"".equals(Utility.getName(po.getCstcprreceiptbillid()))){
			sb.append("and C_ST_CPR_ReceiptBillId=? ");
			params.add(po.getCstcprreceiptbillid());
		}
		if(!"".equals(Utility.getName(po.getCstcprstartTime())) && !"".equals(Utility.getName(po.getCstcprendTime()))){
			sb.append("and convert(varchar(10), C_ST_CPR_BillDate, 23) >= ? ");
			sb.append("and convert(varchar(10),C_ST_CPR_BillDate, 23) <= ? ");
			params.add(po.getCstcprstartTime());
			params.add(po.getCstcprendTime());
		}else if(!"".equals(Utility.getName(po.getCstcprstartTime())) && "".equals(Utility.getName(po.getCstcprendTime()))){
			sb.append("and convert(varchar(10), C_ST_CPR_BillDate, 23) >= ? ");
			params.add(po.getCstcprstartTime());
		}else if("".equals(Utility.getName(po.getCstcprstartTime())) && !"".equals(Utility.getName(po.getCstcprendTime()))){
			sb.append("and convert(varchar(10),C_ST_CPR_BillDate, 23) <= ? ");
			params.add(po.getCstcprendTime());
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	/**
	 * 外部的委外收货单的list
	 * @param po ConsignProcessReceiptPo
	 * @param start
	 * @param size
	 * @return list ConsignProcessReceiptPo的list
	 */	
	public List<ConsignProcessReceiptPo> getConsignProcessReceiptList(ConsignProcessReceiptPo po,int start, int size){
		
		
		StringBuffer sb=new StringBuffer();
		
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * ");
		sb.append(" from(select  ROW_NUMBER() Over(order by cstcprbilldate desc) as rowNum,*");		
		sb.append(" from(select distinct C_ST_CPR_ReceiptBillId as cstcprreceiptbillid,C_ST_CPR_SourceBillId as cstcprsourcebillid,");
		sb.append(" C_ST_CPR_BillDate as cstcprbilldate,a.personName as cstcprcreatepersonname,b.personName as cstcprauditpersonname");
		sb.append(" from C_ST_ConsignProcessReceipt ");
		sb.append(" inner join C_ST_ConsignProcessReceiptDetails on C_ST_CPR_ReceiptBillId=C_ST_CPRD_ReceiptBillD");
		sb.append(" left join (select ID,personName from SYS_PersonInfo) a on C_ST_CPR_CreatePerson=a.ID");
		sb.append(" left join (select ID,personName from SYS_PersonInfo) b on C_ST_CPR_AuditPerson=b.ID");
		sb.append(" where C_ST_CPR_AuditState='1'");
		sb.append(" and C_ST_CPR_ReceiptBillId not in(select distinct C_ST_DE_ReceiptBillId from C_ST_DeliverEntry )");
		
		
		List<String> params = new ArrayList<String>();
		
		if(!"".equals(Utility.getName(po.getCstcprreceiptbillid()))){
			sb.append("and C_ST_CPR_ReceiptBillId=? ");
			params.add(po.getCstcprreceiptbillid());
		}
		if(!"".equals(Utility.getName(po.getCstcprstartTime())) && !"".equals(Utility.getName(po.getCstcprendTime()))){
			sb.append("and convert(varchar(10), C_ST_CPR_BillDate, 23) >= ? ");
			sb.append("and convert(varchar(10),C_ST_CPR_BillDate, 23) <= ? ");
			params.add(po.getCstcprstartTime());
			params.add(po.getCstcprendTime());
		}else if(!"".equals(Utility.getName(po.getCstcprstartTime())) && "".equals(Utility.getName(po.getCstcprendTime()))){
			sb.append("and convert(varchar(10), C_ST_CPR_BillDate, 23) >= ? ");
			params.add(po.getCstcprstartTime());
		}else if("".equals(Utility.getName(po.getCstcprstartTime())) && !"".equals(Utility.getName(po.getCstcprendTime()))){
			sb.append("and convert(varchar(10),C_ST_CPR_BillDate, 23) <= ? ");
			params.add(po.getCstcprendTime());
		}
		
		sb.append(" )t) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(),ConsignProcessReceiptPo.class);
	}
	
	/**
	 * 委外订单的销售单数量
	 * @param po 销售单po
	 * @return int 数量
	 */	
	public int getSalesForConsignProcessCount(SalesBasicPo po){		
		
		StringBuffer sb=new StringBuffer();		
		List<String> params = new ArrayList<String>();

		sb.append("select sum(count1) from ( ");
		sb.append("select count(S_SE_SB_SalesID) as count1 ");
		sb.append("from S_SE_SalesBasic left join S_ME_CustomerInfo on S_ME_CI_CustomerID=S_SE_SB_CustomerID left join B_Departments on S_SE_SB_ShopCode = B_DP_DepartmentID ");
		sb.append("where 1=1 ");
		sb.append("and S_SE_SB_OrdersType=? ");		
		params.add(po.getSsesborderstype());
		
		if (!"".equals(Utility.getName(po.getSsesbcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getSsesbcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getSsesbshopcode()))){
			sb.append("and S_SE_SB_ShopCode=? ");
			params.add(po.getSsesbshopcode());
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){
			sb.append("and S_SE_SB_SalesID  like '%' + ? +'%'");
			params.add(po.getSsesbsalesid());			
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			sb.append("and convert(varchar(10),S_SE_SB_PosDatetime, 23) <= ? ");
			params.add(po.getSsesbsalesdatestarttime());
			params.add(po.getSsesbsalesdateendtime());				
		}else if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && "".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			params.add(po.getSsesbsalesdatestarttime());
		}else if("".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10),S_SE_SB_PosDatetime, 23) <= ? ");
			params.add(po.getSsesbsalesdateendtime());			
		}
		if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ?" );
			sb.append("and convert(varchar(10),S_SE_SB_TakeGlassData, 23) <= ?" );
			params.add(po.getSsesbtakeglassstartdata());
			params.add(po.getSsesbtakeglassenddata());	
		}else if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ?" );
			params.add(po.getSsesbtakeglassstartdata());
		}else if("".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10),S_SE_SB_TakeGlassData, 23) <= ?" );
			params.add(po.getSsesbtakeglassenddata());	
		}
		sb.append(" union all ");
		sb.append("select count(S_SE_SB_SalesID) as count1 ");
		sb.append("from S_SE_SalesBasic_Finished left join S_ME_CustomerInfo on S_ME_CI_CustomerID=S_SE_SB_CustomerID ");
		sb.append("where 1=1 ");
		sb.append("and S_SE_SB_OrdersType=? ");		
		params.add(po.getSsesborderstype());
		if(!"".equals(Utility.getName(po.getSsesbshopcode()))){
			sb.append("and S_SE_SB_ShopCode=? ");
			params.add(po.getSsesbshopcode());
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){
			sb.append("and S_SE_SB_SalesID  like '%' + ? +'%'");
			params.add(po.getSsesbsalesid());			
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			sb.append("and convert(varchar(10),S_SE_SB_PosDatetime, 23) <= ? ");
			params.add(po.getSsesbsalesdatestarttime());
			params.add(po.getSsesbsalesdateendtime());				
		}else if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && "".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			params.add(po.getSsesbsalesdatestarttime());
		}else if("".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10),S_SE_SB_PosDatetime, 23) <= ? ");
			params.add(po.getSsesbsalesdateendtime());			
		}
		if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ?" );
			sb.append("and convert(varchar(10),S_SE_SB_TakeGlassData, 23) <= ?" );
			params.add(po.getSsesbtakeglassstartdata());
			params.add(po.getSsesbtakeglassenddata());	
		}else if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ?" );
			params.add(po.getSsesbtakeglassstartdata());
		}else if("".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10),S_SE_SB_TakeGlassData, 23) <= ?" );
			params.add(po.getSsesbtakeglassenddata());	
		}
		sb.append(" )t " );
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	/**
	 * 委外订单的销售单list
	 * @param po 销售单po
	 * @return list
	 */	
	public List<SalesBasicPo> getSalesForConsignProcessList(SalesBasicPo po,int start, int size){		
		
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from (select ROW_NUMBER() ");
		sb.append("Over(order by ssesbposdatetime desc) as 'rowNum',* from (  ");		
		sb.append("select S_SE_SB_SalesID as ssesbsalesid,S_SE_SB_ShopCode as ssesbshopcode,S_ME_CI_MemberId as ssesbMemberId,S_ME_CI_Name as ssesbpersonName,   ");
		sb.append("S_ME_CI_Phone as ssesbphone,S_SE_SB_TakeGlassData as ssesbtakeglassdata,S_SE_SB_PosDatetime as ssesbposdatetime,S_SE_SB_SalesValue as ssesbsalesvalue ");
		sb.append("from S_SE_SalesBasic left join S_ME_CustomerInfo on S_ME_CI_CustomerID=S_SE_SB_CustomerID left join B_Departments on S_SE_SB_ShopCode = B_DP_DepartmentID ");
		sb.append("where 1=1 ");
		sb.append("and S_SE_SB_OrdersType=? ");		
		params.add(po.getSsesborderstype());
		
		if (!"".equals(Utility.getName(po.getSsesbcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getSsesbcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getSsesbshopcode()))){
			sb.append("and S_SE_SB_ShopCode=? ");
			params.add(po.getSsesbshopcode());
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){
			sb.append("and S_SE_SB_SalesID  like '%' + ? +'%'");
			params.add(po.getSsesbsalesid());			
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			sb.append("and convert(varchar(10),S_SE_SB_PosDatetime, 23) <= ? ");
			params.add(po.getSsesbsalesdatestarttime());
			params.add(po.getSsesbsalesdateendtime());				
		}else if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && "".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			params.add(po.getSsesbsalesdatestarttime());
		}else if("".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10),S_SE_SB_PosDatetime, 23) <= ? ");
			params.add(po.getSsesbsalesdateendtime());			
		}
		if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ?" );
			sb.append("and convert(varchar(10),S_SE_SB_TakeGlassData, 23) <= ?" );
			params.add(po.getSsesbtakeglassstartdata());
			params.add(po.getSsesbtakeglassenddata());	
		}else if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ?" );
			params.add(po.getSsesbtakeglassstartdata());
		}else if("".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10),S_SE_SB_TakeGlassData, 23) <= ?" );
			params.add(po.getSsesbtakeglassenddata());	
		}	
		sb.append(" union all ");
		sb.append("select S_SE_SB_SalesID as ssesbsalesid,S_SE_SB_ShopCode as ssesbshopcode,S_ME_CI_MemberId as ssesbMemberId,S_ME_CI_Name as ssesbpersonName,   ");
		sb.append("S_ME_CI_Phone as ssesbphone,S_SE_SB_TakeGlassData as ssesbtakeglassdata,S_SE_SB_PosDatetime as ssesbposdatetime,S_SE_SB_SalesValue as ssesbsalesvalue ");
		sb.append("from S_SE_SalesBasic_Finished left join S_ME_CustomerInfo on S_ME_CI_CustomerID=S_SE_SB_CustomerID ");
		sb.append("where 1=1 ");
		sb.append("and S_SE_SB_OrdersType=? ");		
		params.add(po.getSsesborderstype());
		if(!"".equals(Utility.getName(po.getSsesbshopcode()))){
			sb.append("and S_SE_SB_ShopCode=? ");
			params.add(po.getSsesbshopcode());
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){
			sb.append("and S_SE_SB_SalesID  like '%' + ? +'%'");
			params.add(po.getSsesbsalesid());			
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			sb.append("and convert(varchar(10),S_SE_SB_PosDatetime, 23) <= ? ");
			params.add(po.getSsesbsalesdatestarttime());
			params.add(po.getSsesbsalesdateendtime());				
		}else if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && "".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			params.add(po.getSsesbsalesdatestarttime());
		}else if("".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			sb.append("and convert(varchar(10),S_SE_SB_PosDatetime, 23) <= ? ");
			params.add(po.getSsesbsalesdateendtime());			
		}
		if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ?" );
			sb.append("and convert(varchar(10),S_SE_SB_TakeGlassData, 23) <= ?" );
			params.add(po.getSsesbtakeglassstartdata());
			params.add(po.getSsesbtakeglassenddata());	
		}else if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ?" );
			params.add(po.getSsesbtakeglassstartdata());
		}else if("".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			sb.append("and convert(varchar(10),S_SE_SB_TakeGlassData, 23) <= ?" );
			params.add(po.getSsesbtakeglassenddata());	
		}		
		
		sb.append(" ) temp ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),SalesBasicPo.class);
	}
	/**
	 * 委外订单的销售单PO
	 * @param po 销售单po
	 * @return PO
	 */	
	public SalesTempPo getSalesForConsignProcessPo(SalesBasicPo po){
		
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("select S_ME_CI_Name as ssesbcustomername,* from  ");
		sb.append("(select S_SE_SB_SalesID as ssesbsalesid,S_SE_SB_ShopCode as ssesbshopcode,S_SE_SB_CustomerID as ssesbcustomerid,S_SE_SB_TakeGlassData as ssesbtakeglassdata ");
		sb.append(",S_SE_SB_SalesDatetime as ssesbsalesdatetime,S_SE_SB_OrdersType as ssesborderstype,S_SE_SB_BallGlassOD as ssesbballglassod,S_SE_SB_BallGlassOS as ssesbballglassos ");
		sb.append(",S_SE_SB_PostGlassOD as ssesbpostglassod,S_SE_SB_PostGlassOS as ssesbpostglassos,S_SE_SB_AxesOD as ssesbaxesod,S_SE_SB_AxesOS as ssesbaxesos ");
		sb.append(",S_SE_SB_ADDOD as ssesbaddod,S_SE_SB_ADDOS as ssesbaddos,S_SE_SB_ArriseGlassOD1 as ssesbarriseglassod1,S_SE_SB_ArriseGlassOS1 as ssesbarriseglassos1 ");
		sb.append(",S_SE_SB_BasisOD1 as ssesbbasisod1,S_SE_SB_BasisOS1 as ssesbbasisos1,S_SE_SB_InterHighOD as ssesbinterhighod,S_SE_SB_InterHighOS as ssesbinterhighos ");
		sb.append(",S_SE_SB_InterDistanceOD as ssesbinterdistanceod,S_SE_SB_InterDistanceOS as ssesbinterdistanceos,S_SE_SB_FarVAOD as ssesbfarvaod,S_SE_SB_FarVAOS as ssesbfarvaos ");
		sb.append(",S_SE_SB_CloseVAOD as ssesbclosevaod,S_SE_SB_CloseVAOS as ssesbclosevaos,S_SE_SB_DignosisRe as ssesbdignosisre,S_SE_SB_EyeCurvatureOD1 as ssesbeyecurvatureod1 ");
		sb.append(",S_SE_SB_EyeCurvatureOS1 as ssesbeyecurvatureos1,S_SE_SB_DiameterOD as ssesbdiameterod,S_SE_SB_DiameterOS as ssesbdiameteros ");
		sb.append(",dbo.getRequirement(S_SE_SB_SalesID) as requirement ");
		sb.append(" from S_SE_SalesBasic where S_SE_SB_SalesID=?)sb ");
		params.add(po.getSsesbsalesid());
		sb.append("left join (select S_SE_SD_SalesID as ssesdsalesidod,S_SE_SD_SalesItemID as ssesdsalesitemidod,S_SE_SD_ItemID as ssesditemidod ");
		sb.append(",S_SE_SD_SalesItemName as ssesdsalesitemnameod,S_SE_SD_SalesValue as ssesdsalesvalueod,S_SE_SD_Number as ssesdnumberod,B_GI_EyeGlassMaterialType as bgieyeglassmaterialtypeod,");
		sb.append("'R' as glassmaterialtypeod from S_SE_SalesDetail ");
		sb.append("inner join B_GoodsInfo on S_SE_SD_SalesItemID=B_GI_GoodsID and B_GI_isCustomize = 'D'  ");
		sb.append("where S_SE_SD_SalesID=? and S_SE_SD_GlassFlag='R' ");
		params.add(po.getSsesbsalesid());
		sb.append(")sd1 on sb.ssesbsalesid=sd1.ssesdsalesidod  ");
		sb.append("left join (select S_SE_SD_SalesID as ssesdsalesidos,S_SE_SD_SalesItemID as ssesdsalesitemidos,S_SE_SD_ItemID as ssesditemidos ");
		sb.append(",S_SE_SD_SalesItemName as ssesdsalesitemnameos,S_SE_SD_SalesValue as ssesdsalesvalueos,S_SE_SD_Number as ssesdnumberos,B_GI_EyeGlassMaterialType as bgieyeglassmaterialtypeos,");
		sb.append("'L' as glassmaterialtypeos from S_SE_SalesDetail ");
		sb.append("inner join B_GoodsInfo on S_SE_SD_SalesItemID=B_GI_GoodsID and B_GI_isCustomize = 'D' ");
		sb.append("where S_SE_SD_SalesID=? and S_SE_SD_GlassFlag='L' ");
		params.add(po.getSsesbsalesid());
		sb.append(")sd2 on sb.ssesbsalesid=sd2.ssesdsalesidos  ");
		sb.append("left join S_ME_CustomerInfo on sb.ssesbcustomerid=S_ME_CI_CustomerID ");

		return (SalesTempPo)queryForObject(sb.toString(), params.toArray(),SalesTempPo.class);
	}
	
	public SalesTempPo getSalesForConsignProcessPoFinished(SalesBasicPo po){
		
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("select S_ME_CI_Name as ssesbcustomername,* from  ");
		sb.append("(select S_SE_SB_SalesID as ssesbsalesid,S_SE_SB_ShopCode as ssesbshopcode,S_SE_SB_CustomerID as ssesbcustomerid,S_SE_SB_TakeGlassData as ssesbtakeglassdata ");
		sb.append(",S_SE_SB_SalesDatetime as ssesbsalesdatetime,S_SE_SB_OrdersType as ssesborderstype,S_SE_SB_BallGlassOD as ssesbballglassod,S_SE_SB_BallGlassOS as ssesbballglassos ");
		sb.append(",S_SE_SB_PostGlassOD as ssesbpostglassod,S_SE_SB_PostGlassOS as ssesbpostglassos,S_SE_SB_AxesOD as ssesbaxesod,S_SE_SB_AxesOS as ssesbaxesos ");
		sb.append(",S_SE_SB_ADDOD as ssesbaddod,S_SE_SB_ADDOS as ssesbaddos,S_SE_SB_ArriseGlassOD1 as ssesbarriseglassod1,S_SE_SB_ArriseGlassOS1 as ssesbarriseglassos1 ");
		sb.append(",S_SE_SB_BasisOD1 as ssesbbasisod1,S_SE_SB_BasisOS1 as ssesbbasisos1,S_SE_SB_InterHighOD as ssesbinterhighod,S_SE_SB_InterHighOS as ssesbinterhighos ");
		sb.append(",S_SE_SB_InterDistanceOD as ssesbinterdistanceod,S_SE_SB_InterDistanceOS as ssesbinterdistanceos,S_SE_SB_FarVAOD as ssesbfarvaod,S_SE_SB_FarVAOS as ssesbfarvaos ");
		sb.append(",S_SE_SB_CloseVAOD as ssesbclosevaod,S_SE_SB_CloseVAOS as ssesbclosevaos,S_SE_SB_DignosisRe as ssesbdignosisre,S_SE_SB_EyeCurvatureOD1 as ssesbeyecurvatureod1 ");
		sb.append(",S_SE_SB_EyeCurvatureOS1 as ssesbeyecurvatureos1,S_SE_SB_DiameterOD as ssesbdiameterod,S_SE_SB_DiameterOS as ssesbdiameteros ");
		sb.append(",dbo.getRequirement(S_SE_SB_SalesID) as requirement ");
		sb.append(" from S_SE_SalesBasic_Finished where S_SE_SB_SalesID=?)sb ");
		params.add(po.getSsesbsalesid());
		sb.append("left join (select S_SE_SD_SalesID as ssesdsalesidod,S_SE_SD_SalesItemID as ssesdsalesitemidod,S_SE_SD_ItemID as ssesditemidod ");
		sb.append(",S_SE_SD_SalesItemName as ssesdsalesitemnameod,S_SE_SD_SalesValue as ssesdsalesvalueod,S_SE_SD_Number as ssesdnumberod,B_GI_EyeGlassMaterialType as bgieyeglassmaterialtypeod,");
		sb.append("'R' as glassmaterialtypeod from S_SE_SalesDetail_Finished ");
		sb.append("inner join B_GoodsInfo on S_SE_SD_SalesItemID=B_GI_GoodsID and B_GI_isCustomize = 'D'  ");
		sb.append("where S_SE_SD_SalesID=? and S_SE_SD_GlassFlag='R' ");
		params.add(po.getSsesbsalesid());
		sb.append(")sd1 on sb.ssesbsalesid=sd1.ssesdsalesidod  ");
		sb.append("left join (select S_SE_SD_SalesID as ssesdsalesidos,S_SE_SD_SalesItemID as ssesdsalesitemidos,S_SE_SD_ItemID as ssesditemidos ");
		sb.append(",S_SE_SD_SalesItemName as ssesdsalesitemnameos,S_SE_SD_SalesValue as ssesdsalesvalueos,S_SE_SD_Number as ssesdnumberos,B_GI_EyeGlassMaterialType as bgieyeglassmaterialtypeos,");
		sb.append("'L' as glassmaterialtypeos from S_SE_SalesDetail_Finished ");
		sb.append("inner join B_GoodsInfo on S_SE_SD_SalesItemID=B_GI_GoodsID and B_GI_isCustomize = 'D' ");
		sb.append("where S_SE_SD_SalesID=? and S_SE_SD_GlassFlag='L' ");
		params.add(po.getSsesbsalesid());
		sb.append(")sd2 on sb.ssesbsalesid=sd2.ssesdsalesidos  ");
		sb.append("left join S_ME_CustomerInfo on sb.ssesbcustomerid=S_ME_CI_CustomerID ");

		return (SalesTempPo)queryForObject(sb.toString(), params.toArray(),SalesTempPo.class);
	}
	
}
