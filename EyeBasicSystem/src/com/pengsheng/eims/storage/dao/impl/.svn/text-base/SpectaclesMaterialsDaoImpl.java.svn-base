package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.dao.SpectaclesMaterialsDao;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class SpectaclesMaterialsDaoImpl extends BaseJdbcDaoSupport implements SpectaclesMaterialsDao {

	/**
	 * 查询配镜发料信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getSpectaclesMaterialsCount(SalesBasicPo salesBasicPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();		
		buffer.append("SELECT DISTINCT inTransit into #dpt FROM ufn_currentintransittab('3') ");
		buffer.append("SELECT DISTINCT inTransit into #dpt2 FROM ufn_currentintransittab('5') ");
		
		buffer.append("select count(S_SE_SB_SalesID) ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID=S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("left join B_WarehouseConfiguration on S_SE_SalesBasic.S_SE_SB_ShopCode=B_WC_deptID ");
		buffer.append("where 1=1 ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
		}
		 
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbspectaclesmaterialsdpt()))){
			buffer.append("and ((S_SE_SB_OrdersType = '1' and B_WC_StockID3 in (select B_WH_ID from B_Warehouse where B_WH_deptID = ? )) or (S_SE_SB_OrdersType = '2' and B_WC_StockID4 in (select B_WH_ID from B_Warehouse where B_WH_deptID = ? ))) ");
			params.add(Utility.getName(salesBasicPo.getSsesbspectaclesmaterialsdpt()));
			params.add(Utility.getName(salesBasicPo.getSsesbspectaclesmaterialsdpt()));
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
			buffer.append("and S_SE_SB_WorryType = ? ");
			params.add(salesBasicPo.getSsesbworrytype());
		}
		if(!"".equals(Utility.getName(salesBasicPo.getDjsbm()))){
			buffer.append("and S_SE_SB_Djsbm = ? ");
			params.add(salesBasicPo.getDjsbm());
		}
		
		//按制造商查询
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsupplierid()))){
			buffer.append("and S_SE_SB_SalesID in ( ");
			buffer.append("select S_SE_SD_SalesID from S_SE_SalesDetail ");
			buffer.append("inner join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID = S_SE_SalesDetail.S_SE_SD_SalesItemID ");
			buffer.append("where B_GI_SupplierID= ? ");
			params.add(salesBasicPo.getSsesbsupplierid());
			
			
			//按品种查找
			if(!"".equals(Utility.getName(salesBasicPo.getSsesbbrandid()))){
				buffer.append("and B_GI_BrandID= ? ");
				params.add(salesBasicPo.getSsesbbrandid());
			}
			buffer.append(") "); 
			
		}
		
		if(!"3".equals(Utility.getName(salesBasicPo.getSsesbdepartmenttype()))){
			buffer.append("and S_SE_SalesBasic.S_SE_SB_ShopCode in ");
			buffer.append("(select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) ");
		
			params.add(salesBasicPo.getSsesbdepartmentid());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ?+'%' ");//quyanping
			params.add(salesBasicPo.getSsesbsalesid());
		}
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))	
				&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))
				&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))
				&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbpersonName());
		}
		
		if("1".equals(Utility.getName(salesBasicPo.getSsesborderstype()))){
			buffer.append("and (S_SE_SB_OrdersType = '1' and S_SE_SB_InTransit in (SELECT inTransit FROM #dpt) ) ");
		}else if("2".equals(Utility.getName(salesBasicPo.getSsesborderstype()))){
			buffer.append("and (S_SE_SB_OrdersType = '2' and S_SE_SB_InTransit in (SELECT inTransit FROM #dpt2) ) ");
		}
		else{
			buffer.append("and ((S_SE_SB_OrdersType = '1' and S_SE_SB_InTransit in (SELECT inTransit FROM #dpt)) ");
			buffer.append("or (S_SE_SB_OrdersType = '2' and S_SE_SB_InTransit in (SELECT inTransit FROM #dpt2) )) ");
		}
		
		buffer.append(" drop table #dpt ");
		buffer.append(" drop table #dpt2 ");
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 查询配镜发料信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectSpectaclesMaterials(
			SalesBasicPo salesBasicPo, int start, int size) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("SELECT DISTINCT inTransit into #dpt FROM ufn_currentintransittab('3') ");
		buffer.append("SELECT DISTINCT inTransit into #dpt2 FROM ufn_currentintransittab('5') ");
		
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by S_SE_SB_SalesDatetime desc , S_SE_SB_OrdersType) as rowNum, ");
		
		buffer.append("S_SE_SB_SalesID as ssesbsalesid , S_ME_CI_Name as ssesbpersonName , S_SE_SB_ShopCode as ssesbshopcode , ");
		buffer.append("S_SE_SB_OrdersType as ssesborderstype , S_SE_SB_SalesDatetime as ssesbsalesdatetime , S_SE_SB_CheckoutFlag as ssesbcheckoutflag, ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , B_DP_DepartmentName as ssesbshopName,S_SE_SB_WorryType as ssesbworrytype ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID=S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("left join B_WarehouseConfiguration on S_SE_SalesBasic.S_SE_SB_ShopCode=B_WC_deptID ");
		buffer.append("where 1=1 ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbspectaclesmaterialsdpt()))){
			buffer.append("and ((S_SE_SB_OrdersType = '1' and B_WC_StockID3 in (select B_WH_ID from B_Warehouse where B_WH_deptID = ? )) or (S_SE_SB_OrdersType = '2' and B_WC_StockID4 in (select B_WH_ID from B_Warehouse where B_WH_deptID = ? ))) ");
			params.add(Utility.getName(salesBasicPo.getSsesbspectaclesmaterialsdpt()));
			params.add(Utility.getName(salesBasicPo.getSsesbspectaclesmaterialsdpt()));
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
			buffer.append("and S_SE_SB_WorryType = ? ");
			params.add(salesBasicPo.getSsesbworrytype());
		}
		if(!"".equals(Utility.getName(salesBasicPo.getDjsbm()))){
			buffer.append("and S_SE_SB_Djsbm = ? ");
			params.add(salesBasicPo.getDjsbm());
		}
		
		//按制造商查询
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsupplierid()))){
			buffer.append("and S_SE_SB_SalesID in ( ");
			buffer.append("select S_SE_SD_SalesID from S_SE_SalesDetail ");
			buffer.append("inner join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID = S_SE_SalesDetail.S_SE_SD_SalesItemID ");
			buffer.append("where B_GI_SupplierID= ? ");
			params.add(salesBasicPo.getSsesbsupplierid());
			
			
			//按品种查找
			if(!"".equals(Utility.getName(salesBasicPo.getSsesbbrandid()))){
				buffer.append("and B_GI_BrandID= ? ");
				params.add(salesBasicPo.getSsesbbrandid());
			}
			buffer.append(") "); 
			
		}
		
		if(!"3".equals(Utility.getName(salesBasicPo.getSsesbdepartmenttype()))){
			buffer.append("and S_SE_SalesBasic.S_SE_SB_ShopCode in ");
			buffer.append("(select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) ");
		
			params.add(salesBasicPo.getSsesbdepartmentid());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ?+'%' ");//quyanping
			params.add(salesBasicPo.getSsesbsalesid());
		}
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))	
				&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))
				&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))
				&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbpersonName());
		}
		
		if("1".equals(Utility.getName(salesBasicPo.getSsesborderstype()))){
			
			buffer.append("and (S_SE_SB_OrdersType = '1' and S_SE_SB_InTransit in (SELECT inTransit FROM #dpt) ) ");
			
		}else if("2".equals(Utility.getName(salesBasicPo.getSsesborderstype()))){
			
			buffer.append("and (S_SE_SB_OrdersType = '2' and S_SE_SB_InTransit in (SELECT inTransit FROM #dpt2) ) ");
			
		}
		else{
			
			buffer.append("and ((S_SE_SB_OrdersType = '1' and S_SE_SB_InTransit in (SELECT inTransit FROM #dpt) ) ");
			buffer.append("or (S_SE_SB_OrdersType = '2' and S_SE_SB_InTransit in (SELECT inTransit FROM #dpt2) )) ");
			
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		buffer.append(" drop table #dpt ");
		buffer.append(" drop table #dpt2 ");
		
		return queryForObjectList(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}

	/**
	 * 取出销售单中右眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1 S_SE_SB_OrdersType as ssesborderstype , ");
		buffer.append("S_SE_SB_BallGlassOD as ssesbballglassod , ");
		buffer.append("S_SE_SB_PostGlassOD as ssesbpostglassod , ");
		buffer.append("S_SE_SB_AxesOD as ssesbaxesod , ");
		buffer.append("S_SE_SB_ADDOD as ssesbaddod , ");
		buffer.append("S_SE_SB_ArriseGlassOD1 as ssesbarriseglassod , ");
		buffer.append("S_SE_SB_BasisOD1 as ssesbbasisod , ");
		buffer.append("S_SE_SB_PrismOD as ssesbprismod , ");
		buffer.append("S_SE_SB_InterHighOD as ssesbinterhighod , ");
		buffer.append("S_SE_SB_InterDistanceOD as ssesbinterdistanceod , ");
		buffer.append("S_SE_SB_FarVAOD as ssesbfarvaod , ");
		buffer.append("S_SE_SB_CloseVAOD as ssesbclosevaod ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		return (SalesBasicPo) queryForObject(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}

	/**
	 * 取出销售单中左眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  S_SE_SB_OrdersType as ssesborderstype , ");
		buffer.append("S_SE_SB_BallGlassOS as ssesbballglassos , ");
		buffer.append("S_SE_SB_PostGlassOS as ssesbpostglassos , ");
		buffer.append("S_SE_SB_AxesOS as ssesbaxesos , ");
		buffer.append("S_SE_SB_ADDOS as ssesbaddos , ");
		buffer.append("S_SE_SB_ArriseGlassOS1 as ssesbarriseglassos , ");
		buffer.append("S_SE_SB_BasisOS1 as ssesbbasisos , ");
		buffer.append("S_SE_SB_PrismOS as ssesbprismos , ");
		buffer.append("S_SE_SB_InterHighOS as ssesbinterhighos , ");
		buffer.append("S_SE_SB_InterDistanceOS as ssesbinterdistanceos , ");
		buffer.append("S_SE_SB_FarVAOS as ssesbfarvaos , ");
		buffer.append("S_SE_SB_CloseVAOS as ssesbclosevaos ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		return (SalesBasicPo) queryForObject(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}

	/**
	 * 得到订单及顾客信息 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getSalesDetailInfo(SalesBasicPo salesBasicPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  S_SE_SB_SalesID as ssesbsalesid , S_SE_SB_CustomerID as ssesbcustomerid , ");
		buffer.append("S_SE_SB_ShopCode as ssesbshopcode , S_SE_SB_SalesDatetime as ssesbsalesdatetime , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , S_SE_SB_OrdersType as ssesborderstype , ");
		buffer.append("B_DP_DepartmentName as ssesbshopName ,  S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("S_ME_CI_Phone as ssesbphone ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("inner join B_Departments on B_Departments.B_DP_DepartmentID = S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		return (SalesBasicPo) queryForObject(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}
	
	/**
	 * 得到销售单中商品个数
	 * @param salesDetailPo
	 * @return
	 */
	public int getGoodsDetailCount(SalesDetailPo salesDetailPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select count(S_SE_SD_SalesID) ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join B_Warehouse on B_Warehouse.B_WH_ID = S_SE_SalesDetail.S_SE_SD_StockId ");
		buffer.append("where S_SE_SD_SalesID= ? ");
		
		params.add(salesDetailPo.getSsesdsalesid());
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 得到销售单中商品信息
	 * @param salesDetailPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesDetailPo> selectGoodsDetailInfo(
			SalesDetailPo salesDetailPo, int start, int size) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by S_SE_SD_SalesID) as rowNum, ");
		
		buffer.append("S_SE_SD_SalesID as ssesdsalesid , S_SE_SD_SalesItemID as ssesdsalesitemid , ");
		buffer.append("S_SE_SD_SalesItemName as ssesdsalesitemname , S_SE_SD_GlassFlag as ssesdglassflag , ");
		buffer.append("S_SE_SD_ItemID as ssesditemid, B_WH_warehouseName as ssesdstockname , ");
		buffer.append("S_SE_SD_StockId as ssesdstockid , S_SE_SD_Number as ssesdnumber , ");
		buffer.append("S_SE_SD_CostsPrive as ssesdcostsprive , S_SE_SD_UnitPrice as ssesdunitprice , ");
		buffer.append("S_SE_SD_LargessFlag as ssesdlargessflag ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join B_Warehouse on B_Warehouse.B_WH_ID = S_SE_SalesDetail.S_SE_SD_StockId ");
		buffer.append("where S_SE_SD_SalesID= ? ");
		
		params.add(salesDetailPo.getSsesdsalesid());
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , SalesDetailPo.class);
	}
	
	
	public List<SalesDetailPo> selectGoodsDetailInfoes(
			SalesDetailPo salesDetailPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select S_SE_SD_ID as ssesdid, "); 
		buffer.append("S_SE_SD_SalesID as ssesdsalesid , S_SE_SD_SalesItemID as ssesdsalesitemid , ");
		buffer.append("S_SE_SD_SalesItemName as ssesdsalesitemname , S_SE_SD_GlassFlag as ssesdglassflag , ");
		buffer.append("S_SE_SD_ItemID as ssesditemid, B_WH_warehouseName as ssesdstockname , ");
		buffer.append("S_SE_SD_StockId as ssesdstockid , S_SE_SD_Number as ssesdnumber ,");
		buffer.append("S_SE_SD_CostsPrive as ssesdcostsprive , S_SE_SD_UnitPrice as ssesdunitprice ,B_GI_BarCodeFlag as rksj, ");
		buffer.append("S_SE_SD_LargessFlag as ssesdlargessflag,UPPER(B_GoodsInfo.B_GI_GoodsBarCode)+'00000000' as goodscode ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join B_Warehouse on B_Warehouse.B_WH_ID = S_SE_SalesDetail.S_SE_SD_StockId ");
		buffer.append("inner join  B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID=S_SE_SalesDetail.S_SE_SD_SalesItemID ");
		
		buffer.append("where S_SE_SD_SalesID= ? order by S_SE_SD_ItemID desc ");
		
		params.add(salesDetailPo.getSsesdsalesid());
		
		return queryForObjectList(buffer.toString() , params.toArray() , SalesDetailPo.class);
	}
	public List<SalesDetailPo> selectGoodsDetailInfoes2(
			SalesDetailPo salesDetailPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select S_SE_SD_ID as ssesdid, "); 
		buffer.append("S_SE_SD_SalesID as ssesdsalesid , S_SE_SD_SalesItemID as ssesdsalesitemid , ");
		buffer.append("S_SE_SD_SalesItemName as ssesdsalesitemname , S_SE_SD_GlassFlag as ssesdglassflag , ");
		buffer.append("S_SE_SD_ItemID as ssesditemid, B_WH_warehouseName as ssesdstockname , ");
		buffer.append("S_SE_SD_StockId as ssesdstockid , S_SE_SD_Number as ssesdnumber ,");
		buffer.append("S_SE_SD_CostsPrive as ssesdcostsprive , S_SE_SD_UnitPrice as ssesdunitprice ,B_GI_BarCodeFlag as rksj, ");
		buffer.append("S_SE_SD_LargessFlag as ssesdlargessflag,UPPER(B_GoodsInfo.B_GI_GoodsBarCode)+'00000000' as goodscode ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join B_Warehouse on B_Warehouse.B_WH_ID = S_SE_SalesDetail.S_SE_SD_StockId ");
		buffer.append("inner join  B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID=S_SE_SalesDetail.S_SE_SD_SalesItemID ");
		
		buffer.append("where S_SE_SD_SalesID= ? and S_SE_SD_LargessFlag='1' and isnull(S_SE_SD_OutStorageFlag,'')<> '1' order by S_SE_SD_ItemID desc ");
		
		params.add(salesDetailPo.getSsesdsalesid());
		
		return queryForObjectList(buffer.toString() , params.toArray() , SalesDetailPo.class);
	}
	/**
	 * 根据销售单号将信息插入在途明细表中
	 * @param inTransitPo
	 */
	public void insertIntrnsitInfo(InTransitPo inTransitPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
			
		buffer.append("insert into S_SE_InTransit( ");
		buffer.append("S_SE_IT_ID , S_SE_IT_SalesID , S_SE_IT_State , ");
		buffer.append("S_SE_IT_Date , S_SE_IT_CreatePerson , S_SE_IT_Department ) ");
		buffer.append("values (? , ? , '6' , getdate() , ? , ?) ");
		
		params.add(this.uuid.generate());
		params.add(inTransitPo.getSseitsalesid());
		params.add(inTransitPo.getSseitcreateperson());
		params.add(inTransitPo.getSseitdepartment());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 根据销售单号将信息插入当月库存变更表中
	 * @param strogeChangePo
	 */
	public void insertStrogeChange(StrogeChangePo strogeChangePo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into C_SH_StorageChange (C_SH_SC_GoodsBarCode , C_SH_SC_GoodsId , C_SH_SC_StockId , ");
		buffer.append("C_SH_SC_GoodsQuantity , C_SH_SC_CostPrice , C_SH_SC_NotTaxRate , ");
		buffer.append("C_SH_SC_WarehousingDate , C_SH_SC_ChangeID ,C_SH_SC_UUID) ");
		buffer.append("values(? , ? , ? , '-'+? , ? , ? , getdate() , ? ,?) ");
		
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
	 * 根据销售单号将信息插入当月库存变更表中
	 * @param strogeChangePo
	 */
	public void insertStrogeChangeLog(StrogeChangePo strogeChangePo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into C_SH_StorageLog (C_SH_Sl_GoodsBarCode , C_SH_Sl_GoodsId , C_SH_Sl_StockId , ");
		buffer.append("C_SH_Sl_GoodsQuantity , C_Sh_Sl_CostPrice , C_SH_Sl_NotTaxRate , ");
		buffer.append("C_SH_Sl_WarehousingDate , C_SH_Sl_ChangeID , C_SH_SL_UUID) ");
		buffer.append("values(? , ? , ? , '-'+? , ? , ? , getdate() , ?, ?) ");
		
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
	 * 更新销售基表中的在途点
	 * @param salesDetailPo
	 */
	public void updateMaterialsInTransit(SalesBasicPo salesBasicPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("update top (1) S_SE_SalesBasic ");
		buffer.append("set S_SE_SB_InTransit= '6' ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbprocessdepartment()))){
			buffer.append(" ,S_SE_SB_ProcessDepartment = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbprocessdepartment()));
		}
		buffer.append("where S_SE_SB_SalesID= ? ");
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 更新销售明细表中商品条码
	 */
	public void updateDetailsBarcode(SalesDetailPo salesDetailPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("update S_SE_SalesDetail ");
		buffer.append("set S_SE_SD_ItemID = ? ,S_SE_SD_StockId=?, ");
		buffer.append("S_SE_SD_Updatetime = getdate() ");
		buffer.append("where S_SE_SD_SalesID = ? ");
		buffer.append("and S_SE_SD_SalesItemID = ? ");
		
		params.add(salesDetailPo.getSsesditemid());
		params.add(salesDetailPo.getSsesdstockid());
		params.add(salesDetailPo.getSsesdsalesid());
		params.add(salesDetailPo.getSsesdsalesitemid());
		
		if (!Utility.getName(salesDetailPo.getSsesdid()).equals("")){
			buffer.append(" and S_SE_SD_ID=? ");
			params.add(Utility.getName(salesDetailPo.getSsesdid()));
		}

		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 得到部门列表
	 * @param departmentsPo
	 * @return
	 */
	public List<DepartmentsPo> getdepartment(DepartmentsPo departmentsPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select B_DP_DepartmentID as bdpdepartmentid , ");
		buffer.append("B_DP_DepartmentName as bdpdepartmentname ");
		buffer.append("from B_Departments ");
		buffer.append("where 1=1 ");
		
		if(!"3".equals(Utility.getName(departmentsPo.getBdptype()))){
			buffer.append("and B_DP_DepartmentID = ? ");
			params.add(departmentsPo.getBdpregid());
		}
		else if("3".equals(Utility.getName(departmentsPo.getBdptype()))){
			buffer.append("and B_DP_Type = '1' ");
		}
		
		if (!"".equals(Utility.getName(departmentsPo.getBdpcompanysid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(departmentsPo.getBdpcompanysid()));	
		}
		
		return queryForObjectList(buffer.toString() , params.toArray() , DepartmentsPo.class);
	}
	
	/**
	 * 发料时判断销售单在途
	 * @param String
	 * @return
	 */
	public int selectIsSend(String salesid) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		buffer.append("SELECT DISTINCT inTransit into #dpt FROM ufn_currentintransittab('3') ");
		buffer.append("SELECT DISTINCT inTransit into #dpt2 FROM ufn_currentintransittab('5') ");
		
		buffer.append("select count(*) from dbo.S_SE_SalesBasic ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		buffer.append("and (S_SE_SB_InTransit in (SELECT inTransit FROM #dpt) or S_SE_SB_InTransit in (SELECT inTransit FROM #dpt2) ) ");
		
		buffer.append(" drop table #dpt ");
		buffer.append(" drop table #dpt2 ");
		
		params.add(salesid);
		
		
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 发料时新增自动调拨单
	 */
    public void inertAutoAllocationToStore(InventoryPo po){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into C_ST_Inventory (C_ST_I_BillID , C_ST_I_BillTypeId ,C_ST_I_SourceBillId, C_ST_I_billDate ,C_ST_I_GoodsCategory, ");
		buffer.append("C_ST_I_InStockId , C_ST_I_OutStockId , C_ST_I_DepartmentId ,C_ST_I_createPerson,C_ST_I_AuditPerson,C_ST_I_AuditState, ");
		buffer.append("C_ST_I_AuditDate , C_ST_I_Remark,C_ST_I_AmountType,C_ST_I_FinanceAuditPerson,C_ST_I_FinanceAuditState,C_ST_I_FinanceAuditDate ) ");
		buffer.append("values(? , ? , ? , getdate() , ? , ? , ?, ?, ?,?,'1',getdate(),?,dbo.ufn_getAmountTypeByDptID(?),?,?,getdate()) ");
		
		params.add(Utility.getName(po.getCstibillid()));
		params.add(Utility.getName(po.getCstibilltypeid()));
		params.add(Utility.getName(po.getCstisourcebillid()));
		params.add(Utility.getName(po.getCstigoodscategory()));
		params.add(Utility.getName(po.getCstiinstockid()));
		params.add(Utility.getName(po.getCstioutstockid()));
		params.add(Utility.getName(po.getCstidepartmentid()));
		params.add(Utility.getName(po.getCsticreateperson()));
		params.add(Utility.getName(po.getCstiauditperson()));
		params.add(Utility.getName(po.getCstiremark()));
		params.add(Utility.getName(po.getCstiinstockid()));		
		params.add(Utility.getName(po.getCstifinanceauditperson()));
		params.add(Utility.getName(po.getCstifinanceauditstate()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
    }
    
	/**
	 * 发料时新增自动调拨单明细
	 */
    public void inertAutoAllocationEntryToStore(InventoryEntryPo po){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into C_ST_InventoryEntry (C_ST_IE_ID , C_ST_IE_BillID , C_ST_IE_GoodsId , ");
		buffer.append("C_ST_IE_GoodsQuantity , C_ST_IE_NotTaxRate , C_ST_IE_NotTaxRateAmount , ");
		buffer.append("C_ST_IE_TaxRate , C_ST_IE_CostPrice , C_ST_IE_TaxAmount,C_ST_IE_CostPriceAmount,C_ST_IE_InStockId,C_ST_IE_OutStockId,C_ST_IE_BarCode,C_ST_IE_WarehousingDate,C_ST_IE_Remark,C_ST_IE_OutStorageFlag,C_ST_IE_GuaranteePeriod,C_ST_IE_Batch,C_ST_IE_RegistrationNum) ");
		buffer.append("values(? , ? , ? , ? , ? , ? , ?, ?, ?,? , ? , ? , ? , getdate() , ? , '1',?,?,?) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getCstiebillid()));
		params.add(Utility.getName(po.getCstiegoodsid()));
		params.add(Utility.getName(po.getCstiegoodsquantity()));		
		params.add(Utility.getName(po.getCstienottaxrate()));
		params.add(Utility.getName(po.getCstienottaxrateamount()));
		params.add(Utility.getName(po.getCstietaxrate()));
		params.add(Utility.getName(po.getCstiecostprice()));	
		params.add(Utility.getName(po.getCstietaxamount()));
		params.add(Utility.getName(po.getCstiecostpriceamount()));
		params.add(Utility.getName(po.getCstieinstockid()));
		params.add(Utility.getName(po.getCstieoutstockid()));
		params.add(Utility.getName(po.getCstiebarcode()));
		params.add(Utility.getName(po.getCstieremark()));		
		params.add(Utility.getName(po.getCstieguaranteeperiod()));
		params.add(Utility.getName(po.getCstiebatch()));
		params.add(Utility.getName(po.getCstieregistrationnum()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
    }
    
	/**
	 * 发料时新增自动调拨单明细条码
	 */
    public void inertAutoAllocationBarcodeToStore(InventoryEntryPo po){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into C_ST_InventoryBarCode (C_ST_IB_ID , C_ST_IB_BillID , C_ST_IB_GoodsID ,C_ST_IB_GoodsBarcode) ");
        buffer.append("values(? , ? , ? , ?) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getCstiebillid()));
		params.add(Utility.getName(po.getCstiegoodsid()));
		params.add(Utility.getName(po.getCstiebarcode()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
    }
    
	/**
	 * 根据调拨单号将信息插入当月库存变更表中
	 * @param strogeChangePo
	 */
	public void insertAutoAllocationStrogeChange(InventoryEntryPo po) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into C_SH_StorageChange (C_SH_SC_GoodsBarCode , C_SH_SC_GoodsId , C_SH_SC_StockId , ");
		buffer.append("C_SH_SC_GoodsQuantity , C_SH_SC_CostPrice , C_SH_SC_NotTaxRate , ");
		buffer.append("C_SH_SC_WarehousingDate , C_SH_SC_ChangeID ,C_SH_SC_UUID) ");
		buffer.append("values(? , ? , ? ,? , ? , ? , getdate() , ? ,?) ");
		
		params.add(Utility.getName(po.getCstiebarcode()).substring(0, 18));
		params.add(Utility.getName(po.getCstiegoodsid()));
		params.add(Utility.getName(po.getCstieinstockid()));
		params.add(Utility.getName(po.getCstiegoodsquantity()));
		params.add(Utility.getName(po.getCstiecostprice()));	
		params.add(Utility.getName(po.getCstienottaxrate()));		
		params.add(Utility.getName(po.getCstiebillid()));		
		params.add(this.uuid.generate());	
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	/**
	 * 根据调拨单号将信息插入当月库存变更表中
	 * @param strogeChangePo
	 */
	public void insertAutoAllocationStrogeChangeLog(InventoryEntryPo po) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into C_SH_StorageLog (C_SH_Sl_GoodsBarCode , C_SH_Sl_GoodsId , C_SH_Sl_StockId ,C_SH_SL_FromStockId, ");
		buffer.append("C_SH_Sl_GoodsQuantity , C_Sh_Sl_CostPrice , C_SH_Sl_NotTaxRate , ");
		buffer.append("C_SH_Sl_WarehousingDate , C_SH_Sl_ChangeID , C_SH_SL_UUID,C_SH_SL_AutoAllocation,C_SH_SL_GuaranteePeriod,C_SH_SL_Batch,C_SH_SL_SalesID) ");
		buffer.append("values(? , ? , ? ,?,? , ? , ? , getdate() , ?, ?,?,?,?,?) ");
		
		params.add(Utility.getName(po.getCstiebarcode()));
		params.add(Utility.getName(po.getCstiegoodsid()));
		params.add(Utility.getName(po.getCstieinstockid()));
		params.add(Utility.getName(po.getCstieoutstockid()));
		params.add(Utility.getName(po.getCstiegoodsquantity()));
		params.add(Utility.getName(po.getCstiecostprice()));	
		params.add(Utility.getName(po.getCstienottaxrate()));		
		params.add(Utility.getName(po.getCstiebillid()));
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getCstieautoallocationflag()));
		params.add(Utility.getName(po.getCstieguaranteeperiod()));
		params.add(Utility.getName(po.getCstiebatch()));
		params.add(Utility.getName(po.getCstiesalesbillid()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	/**
	 * 自动发料生成调拨单（隐藏）
	 */
    public void inertAutoAllocationBillToStore(InventoryPo po){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
        buffer.append("INSERT INTO C_SHA_Allocation ");
        buffer.append("           (C_SHA_A_billID ");
        buffer.append("           ,C_SHA_A_billDate ");
        buffer.append("           ,C_SHA_A_outDepartmentId ");
        buffer.append("           ,C_SHA_A_outStockId ");
        buffer.append("           ,C_SHA_A_inStockId ");
        buffer.append("           ,C_SHA_A_inDepartmentId ");
        buffer.append("           ,C_SHA_A_createPerson ");
        buffer.append("           ,C_SHA_A_auditPerson ");
        buffer.append("           ,C_SHA_A_auditState ");
        buffer.append("           ,C_SHA_A_auditDate ");
        buffer.append("           ,C_SHA_A_consignee ");
        buffer.append("           ,C_SHA_A_consignState ");
        buffer.append("           ,C_SHA_A_consignDate ");
        buffer.append("           ,C_SHA_A_remark ");
        buffer.append("           ,C_SHA_A_flag ");
        buffer.append("           ,C_SHA_A_AutoAllocationFlag,C_SHA_A_StatusBillID,C_SHA_A_AmountType,C_SHA_A_FinanceAuditPerson,C_SHA_A_FinanceAuditState,C_SHA_A_FinanceAuditDate) ");
        buffer.append(" values(?,getdate(),?,?,?,?,?,?,'1',getdate(),'admin','1',getdate(),?,'1','0',?,dbo.ufn_getAmountTypeByDptID(?),?,?,getdate()) ");
		
		params.add(Utility.getName(po.getCstibillid()));
		params.add(getInDepartmentIdByAutoAllocation(Utility.getName(po.getCstioutstockid()))); // 出库部门	
		params.add(Utility.getName(po.getCstioutstockid()));		
		params.add(Utility.getName(po.getCstiinstockid()));
		params.add(getInDepartmentIdByAutoAllocation(Utility.getName(po.getCstiinstockid()))); // 入库部门		
		params.add(Utility.getName(po.getCsticreateperson()));
		params.add(Utility.getName(po.getCsticreateperson()));
		params.add(Utility.getName(po.getCstiremark()));
		params.add(Utility.getName(po.getCstisourcebillid()));
		params.add(Utility.getName(po.getCstiinstockid()));		
		params.add(Utility.getName(po.getCstifinanceauditperson()));
		params.add(Utility.getName(po.getCstifinanceauditstate()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
    }
    
	/**
	 * 自动发料生成调拨单明细（隐藏）
	 */
    public void inertAutoAllocationBillEntryToStore(InventoryEntryPo po){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into C_SHA_AllocationEntry (C_SHA_AE_ID , C_SHA_AE_billId , C_SHA_AE_goodsId ,C_SHA_AE_goodsbarcode,C_SHA_A_outStockId,C_SHA_A_inStockId,C_SHA_AE_requirementQuantity,C_SHA_AE_allocationQuantity,C_SHA_AE_OutStorageFlag,C_SHA_AE_Guaranteeperiod,C_ST_CPRD_Batch,C_SHA_AE_RegistrationNum,C_SHA_AE_NotTaxRate,C_SHA_AE_NotTaxRateAmount,C_SHA_AE_CostPrice,C_SHA_AE_CostPriceAmount) ");
        buffer.append("values(? , ? , ? , ?,? , ? , 0, ?,? , ? , ?,?,? , ? , ?,?) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getCstiebillid()));
		params.add(Utility.getName(po.getCstiegoodsid()));
		params.add(Utility.getName(po.getCstiebarcode()));
		params.add(Utility.getName(po.getCstieoutstockid()));
		params.add(Utility.getName(po.getCstieinstockid()));
		params.add(Utility.getName(po.getCstiegoodsquantity()));
		params.add(Utility.getName(po.getCstieoutstorageflag()).equals("") ? "1" : Utility.getName(po.getCstieoutstorageflag()));		
		params.add(Utility.getName(po.getCstieguaranteeperiod()));
		params.add(Utility.getName(po.getCstiebatch()));
		params.add(Utility.getName(po.getCstieregistrationnum()));		
		params.add(Utility.getName(po.getCstienottaxrate()));
		params.add(Utility.getName(po.getCstienottaxrateamount()));
		params.add(Utility.getName(po.getCstiecostprice()));
		params.add(Utility.getName(po.getCstiecostpriceamount()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
    }
    
	/**
	 * 自动发料生成调拨单条码（隐藏）
	 */
    public void inertAutoAllocationBillBarcodeToStore(InventoryEntryPo po){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into C_SHA_AllocationBarcode (C_SHA_B_UUID , C_SHA_B_billID , C_SHA_B_GoodsID ,C_SHA_B_GoodsBarcode) ");
        buffer.append("values(? , ? , ? , ?) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getCstiebillid()));
		params.add(Utility.getName(po.getCstiegoodsid()));
		params.add(Utility.getName(po.getCstiebarcode()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
    }
    
    /**
     * 获取自动调拨的收入部门
     * @return
     */
    private String getInDepartmentIdByAutoAllocation(String stockid){
    	
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select top 1 isnull(B_WH_deptID,'') from B_Warehouse where B_WH_ID=? ");		
		
		params.add(stockid);
		
		return (String)getJdbcTemplate().queryForObject(sb.toString(), params.toArray(),String.class);
    }
    
	/**
	 * 查询未打印发料单的总数
	 */
	public int getPrintSpectaclesMaterialsBillCount(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();

		buffer.append("SELECT DISTINCT inTransit into #dpt FROM ufn_currentintransittab('3') ");
		buffer.append("SELECT DISTINCT inTransit into #dpt2 FROM ufn_currentintransittab('5') ");
	
		buffer.append("select count(*) from (");
		if ("2".equals(Utility.getName(salesBasicPo.getSsesbqueryclassif()))){
			buffer.append("select S_SE_SD_SalesID,(replace(S_SE_SD_SalesItemID,'.','')+'00000000') as ssesbgoodsbarcode,S_SE_SD_SalesItemName,S_SE_SD_Number,S_SE_SD_GlassFlag,B_GI_Sph,B_GI_Cyl,B_GI_Axis ");
		}else{
			buffer.append("select S_SE_SB_SalesID ");
		}
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID=S_SE_SalesBasic.S_SE_SB_CustomerID ");
		 
		if ("2".equals(Utility.getName(salesBasicPo.getSsesbqueryclassif()))){
			buffer.append("inner join S_SE_SalesDetail on S_SE_SB_SalesID = S_SE_SD_SalesID inner join B_GoodsInfo on S_SE_SD_SalesItemID=B_GI_GoodsID ");
		}
		
		buffer.append("where isnull(S_SE_SB_PrintSMFlag,'0')='0' ");		
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
		}
		
		if ("2".equals(Utility.getName(salesBasicPo.getSsesbqueryclassif()))){
			buffer.append(" and B_GI_GoodsCategoryID='3'  ");
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
			buffer.append("and S_SE_SB_WorryType = ? ");
			params.add(salesBasicPo.getSsesbworrytype());
		}
		
		//按制造商查询
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsupplierid()))){
			buffer.append("and S_SE_SB_SalesID in ( ");
			buffer.append("select S_SE_SD_SalesID from S_SE_SalesDetail ");
			buffer.append("inner join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID = S_SE_SalesDetail.S_SE_SD_SalesItemID ");
			buffer.append("where B_GI_SupplierID= ?  ");
			params.add(salesBasicPo.getSsesbsupplierid());
			
			
			//按品种查找
			if(!"".equals(Utility.getName(salesBasicPo.getSsesbbrandid()))){
				buffer.append("and B_GI_BrandID= ? ");
				params.add(salesBasicPo.getSsesbbrandid());
			}
			buffer.append(") "); 
			
		}
		
		if(!"3".equals(Utility.getName(salesBasicPo.getSsesbdepartmenttype()))){
			buffer.append("and S_SE_SalesBasic.S_SE_SB_ShopCode in ");
			buffer.append("(select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) ");
		
			params.add(salesBasicPo.getSsesbdepartmentid());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbprocessdpt()))){
			buffer.append("and S_SE_SalesBasic.S_SE_SB_ShopCode in ");
			buffer.append("(select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) ");
		
			params.add(Utility.getName(salesBasicPo.getSsesbprocessdpt()));
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ?+'%' ");//quyanping
			params.add(salesBasicPo.getSsesbsalesid());
		}
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))	
				&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))
				&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))
				&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbpersonName());
		}
		
		if("1".equals(Utility.getName(salesBasicPo.getSsesborderstype()))){
			buffer.append("and (S_SE_SB_OrdersType = '1' and S_SE_SB_InTransit in (SELECT inTransit FROM #dpt) ) ");
		}else if("2".equals(Utility.getName(salesBasicPo.getSsesborderstype()))){
			buffer.append("and (S_SE_SB_OrdersType = '2' and S_SE_SB_InTransit in (SELECT inTransit FROM #dpt2)) ");
		}
		else{
			buffer.append("and ((S_SE_SB_OrdersType = '1' and S_SE_SB_InTransit in (SELECT inTransit FROM #dpt)) ");
			buffer.append("or (S_SE_SB_OrdersType = '2' and S_SE_SB_InTransit in (SELECT inTransit FROM #dpt2) )) ");
		}
		buffer.append(" )t ");
		buffer.append(" drop table #dpt ");
		buffer.append(" drop table #dpt2 ");
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	/**
	 * 查询未打印发料单
	 */
	public List<SalesBasicPo> selectPrintSpectaclesMaterialsBill(SalesBasicPo salesBasicPo , int start , int size){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("SELECT DISTINCT inTransit into #dpt FROM ufn_currentintransittab('3') ");
		buffer.append("SELECT DISTINCT inTransit into #dpt2 FROM ufn_currentintransittab('5') ");
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		
		if ("2".equals(Utility.getNameNum(salesBasicPo.getSsesborderby()))){			
			buffer.append("order by B_DP_DepartmentName desc,S_SE_SB_PosDatetime desc) as rowNum, ");
		}else{
			buffer.append("order by S_SE_SB_PosDatetime desc) as rowNum, ");
		}		
		
		buffer.append("S_SE_SB_SalesID as ssesbsalesid , S_ME_CI_Name as ssesbpersonName , S_SE_SB_ShopCode as ssesbshopcode , ");
		buffer.append("S_SE_SB_OrdersType as ssesborderstype , S_SE_SB_PosDatetime as ssesbsalesdatetime , S_SE_SB_CheckoutFlag as ssesbcheckoutflag, ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , B_DP_DepartmentName as ssesbshopName,S_SE_SB_WorryType as ssesbworrytype ");
		
		if ("2".equals(Utility.getName(salesBasicPo.getSsesbqueryclassif()))){
			buffer.append(",(replace(S_SE_SD_SalesItemID,'.','')+'00000000') as ssesbgoodsbarcode,S_SE_SD_SalesItemName as ssesbgoodsname,S_SE_SD_Number as ssesbgoodsnum,S_SE_SD_GlassFlag as ssesbglassflag,B_GI_Sph as ssesbsph,B_GI_Cyl as ssesbcyl,B_GI_Axis as ssesbaxs ");
		}		
		
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID=S_SE_SalesBasic.S_SE_SB_CustomerID ");
		
		if ("2".equals(Utility.getName(salesBasicPo.getSsesbqueryclassif()))){
			buffer.append("inner join S_SE_SalesDetail on S_SE_SB_SalesID = S_SE_SD_SalesID inner join B_GoodsInfo on S_SE_SD_SalesItemID=B_GI_GoodsID ");
		}
		
		buffer.append("where isnull(S_SE_SB_PrintSMFlag,'0')='0' ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
		}
		
		if ("2".equals(Utility.getName(salesBasicPo.getSsesbqueryclassif()))){
			buffer.append(" and B_GI_GoodsCategoryID='3'  ");
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
			buffer.append("and S_SE_SB_WorryType = ? ");
			params.add(salesBasicPo.getSsesbworrytype());
		}
		
		//按制造商查询
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsupplierid()))){
			buffer.append("and S_SE_SB_SalesID in ( ");
			buffer.append("select S_SE_SD_SalesID from S_SE_SalesDetail ");
			buffer.append("inner join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID = S_SE_SalesDetail.S_SE_SD_SalesItemID ");
			buffer.append("where B_GI_SupplierID= ? ");
			params.add(salesBasicPo.getSsesbsupplierid());
			
			
			//按品种查找
			if(!"".equals(Utility.getName(salesBasicPo.getSsesbbrandid()))){
				buffer.append("and B_GI_BrandID= ? ");
				params.add(salesBasicPo.getSsesbbrandid());
			}
			buffer.append(") "); 
			
		}
		
		if(!"3".equals(Utility.getName(salesBasicPo.getSsesbdepartmenttype()))){
			buffer.append("and S_SE_SalesBasic.S_SE_SB_ShopCode in ");
			buffer.append("(select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) ");
		
			params.add(salesBasicPo.getSsesbdepartmentid());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbprocessdpt()))){
			buffer.append("and S_SE_SalesBasic.S_SE_SB_ShopCode in ");
			buffer.append("(select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) ");
		
			params.add(Utility.getName(salesBasicPo.getSsesbprocessdpt()));
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ?+'%' ");//quyanping
			params.add(salesBasicPo.getSsesbsalesid());
		}
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))	
				&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))
				&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))
				&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbpersonName());
		}
		
		if("1".equals(Utility.getName(salesBasicPo.getSsesborderstype()))){
			
			buffer.append("and (S_SE_SB_OrdersType = '1' and S_SE_SB_InTransit in (SELECT inTransit FROM #dpt) ) ");
			
		}else if("2".equals(Utility.getName(salesBasicPo.getSsesborderstype()))){
			
			buffer.append("and (S_SE_SB_OrdersType = '2' and S_SE_SB_InTransit in (SELECT inTransit FROM #dpt2) ) ");
			
		}
		else{
			
			buffer.append("and ((S_SE_SB_OrdersType = '1' and S_SE_SB_InTransit in (SELECT inTransit FROM #dpt) ) ");
			buffer.append("or (S_SE_SB_OrdersType = '2' and S_SE_SB_InTransit in (SELECT inTransit FROM #dpt2) )) ");
			
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		buffer.append(" drop table #dpt ");
		buffer.append(" drop table #dpt2 ");
		
		return queryForObjectList(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}
	
	/**
	 * 批量新增发料信息
	 */
	public void insertMaterialsBatch(SalesBasicPo po){
		
	}
    
	public List<SalesDetailPo> selectGoodsDetailInfo(SalesBasicPo po) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select S_SE_SD_ID as ssesdid, "); 
		buffer.append("S_SE_SD_SalesID as ssesdsalesid , S_SE_SD_SalesItemID as ssesdsalesitemid , ");
		buffer.append("S_SE_SD_SalesItemName as ssesdsalesitemname , S_SE_SD_GlassFlag as ssesdglassflag , ");
		buffer.append("S_SE_SD_ItemID as ssesditemid, B_WH_warehouseName as ssesdstockname , ");
		buffer.append("S_SE_SD_StockId as ssesdstockid , S_SE_SD_Number as ssesdnumber , ");
		buffer.append("S_SE_SD_CostsPrive as ssesdcostsprive , S_SE_SD_UnitPrice as ssesdunitprice , ");
		buffer.append("S_SE_SD_LargessFlag as ssesdlargessflag,UPPER(B_GoodsInfo.B_GI_GoodsBarCode)+'00000000' as goodscode ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join B_Warehouse on B_Warehouse.B_WH_ID = S_SE_SalesDetail.S_SE_SD_StockId ");
		buffer.append("inner join  B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID=S_SE_SalesDetail.S_SE_SD_SalesItemID ");
		
		buffer.append("where S_SE_SD_SalesID= ? and B_GI_GoodsCategoryID='3' order by S_SE_SD_ItemID desc ");
		
		params.add(Utility.getName(po.getSsesbsalesid()));
		
		return queryForObjectList(buffer.toString() , params.toArray() , SalesDetailPo.class);
	}
	
	/**
	 * 根据商品代码查询税率
	 */
	public GoodsInfoPo getGoodsTaxRateByID(String goodsID){
	   	
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 isnull(B_GI_TaxRate,'17') as bgitaxrate from B_GoodsInfo where B_GI_GoodsID=? ");		
		
		params.add(goodsID);
		
		return (GoodsInfoPo) queryForObject(buffer.toString() , params.toArray() , GoodsInfoPo.class);
	}
	
	/**
	 * 根据配送单生成调拨单
	 */
    public void inertAutoAllocationBillByyx(InventoryPo po){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
        buffer.append("INSERT INTO C_SHA_Allocation ");
        buffer.append("           (C_SHA_A_billID ");
        buffer.append("           ,C_SHA_A_billDate ");
        buffer.append("           ,C_SHA_A_outDepartmentId ");
        buffer.append("           ,C_SHA_A_outStockId ");
        buffer.append("           ,C_SHA_A_inStockId ");
        buffer.append("           ,C_SHA_A_inDepartmentId ");
        buffer.append("           ,C_SHA_A_createPerson ");
        buffer.append("           ,C_SHA_A_auditPerson ");
        buffer.append("           ,C_SHA_A_auditState ");
        buffer.append("           ,C_SHA_A_auditDate ");
        buffer.append("           ,C_SHA_A_consignState ");
        buffer.append("           ,C_SHA_A_remark ");
        buffer.append("           ,C_SHA_A_flag ");
        buffer.append("           ,C_SHA_A_StatusBillID,C_SHA_A_AmountType) ");
        buffer.append(" values(?,getdate(),?,?,?,?,?,?,'1',getdate(),'0',?,'1',?,dbo.ufn_getAmountTypeByDptID(?)) ");
		
		params.add(Utility.getName(po.getCstibillid()));
		params.add(getInDepartmentIdByAutoAllocation(Utility.getName(po.getCstioutstockid()))); // 出库部门	
		params.add(Utility.getName(po.getCstioutstockid()));		
		params.add(Utility.getName(po.getCstiinstockid()));
		params.add(getInDepartmentIdByAutoAllocation(Utility.getName(po.getCstiinstockid()))); // 入库部门
		params.add(Utility.getName(po.getCsticreateperson()));
		params.add(Utility.getName(po.getCsticreateperson()));
		params.add(Utility.getName(po.getCstiremark()));
		params.add(Utility.getName(po.getCstisourcebillid()));
		params.add(Utility.getName(po.getCstiinstockid()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
    }
	
}
