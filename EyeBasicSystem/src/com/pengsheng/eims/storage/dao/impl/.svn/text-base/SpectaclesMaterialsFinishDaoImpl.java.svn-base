package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.dao.SpectaclesMaterialsFinishDao;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class SpectaclesMaterialsFinishDaoImpl extends BaseJdbcDaoSupport implements
		SpectaclesMaterialsFinishDao {

	/**
	 * 查询配镜已发料信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getSpectaclesMaterialsFinishCount(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select count(S_SE_SB_SalesID) ");
		buffer.append("from uview_SalesBasic ");
		buffer.append("inner join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SB_ShopCode ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID=S_SE_SB_CustomerID ");
		buffer.append("inner join S_SE_InTransit on S_SE_InTransit.S_SE_IT_SalesID=S_SE_SB_SalesID and S_SE_IT_State = '6' ");
		buffer.append("left join SYS_PersonInfo on SYS_PersonInfo.ID=S_SE_InTransit.S_SE_IT_CreatePerson ");
		buffer.append("where 1=1 ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
		}
		 
		//按制造商查询
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsupplierid()))){
			buffer.append("and S_SE_SB_SalesID in ( ");
			buffer.append("select S_SE_SD_SalesID from uview_SalesDetail ");
			buffer.append("inner join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID = S_SE_SD_SalesItemID ");
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
			buffer.append("and S_SE_SB_ShopCode in ");
			buffer.append("(select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) ");
		
			params.add(salesBasicPo.getSsesbdepartmentid());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ?+'%' ");//quyanping
			params.add(salesBasicPo.getSsesbsalesid());
		}
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) 
				&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) 
				&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) 
				&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

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
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesborderstype()))){
			buffer.append("and S_SE_SB_OrdersType = ? ");
			params.add(salesBasicPo.getSsesborderstype());
		}
		else{
			buffer.append("and S_SE_SB_OrdersType in (1, 2) ");
		}
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){	//加急状态
			if("1".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
				buffer.append("and isnull(S_SE_SB_WorryType,'') = '1'  ");
			} 
			if("2".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
				buffer.append("and isnull(S_SE_SB_WorryType,'') = '2'  ");
			}
		} 
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 查询配镜已发料信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectSpectaclesMaterialsFinish(
			SalesBasicPo salesBasicPo, int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by S_SE_SB_PosDatetime desc,S_SE_SB_OrdersType) as rowNum,");
		buffer.append("S_SE_SB_SalesID as ssesbsalesid , S_ME_CI_Name as ssesbpersonName, S_SE_SB_ShopCode as ssesbshopcode,S_SE_SB_CheckoutFlag as ssesbcheckoutflag, ");
		buffer.append("S_SE_SB_OrdersType as ssesborderstype , S_SE_SB_PosDatetime as ssesbsalesdatetime, ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , B_DP_DepartmentName as ssesbshopName, ");
		buffer.append("personName as ssesbmaterialsperson , S_SE_IT_Date as ssesbmaterialsdate,S_SE_SB_WorryType as ssesbworrytype ");
		buffer.append("from uview_SalesBasic ");
		buffer.append("inner join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SB_ShopCode ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID=S_SE_SB_CustomerID ");
		buffer.append("inner join S_SE_InTransit on S_SE_InTransit.S_SE_IT_SalesID=S_SE_SB_SalesID and S_SE_IT_State = '6' ");
		buffer.append("left join SYS_PersonInfo on SYS_PersonInfo.ID=S_SE_InTransit.S_SE_IT_CreatePerson ");
		buffer.append("where 1=1 ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
		}
		
		//按制造商查询
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsupplierid()))){
			buffer.append("and S_SE_SB_SalesID in ( ");
			buffer.append("select S_SE_SD_SalesID from uview_SalesDetail ");
			buffer.append("inner join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID = S_SE_SD_SalesItemID ");
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
			buffer.append("and S_SE_SB_ShopCode in ");
			buffer.append("(select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) ");
		
			params.add(salesBasicPo.getSsesbdepartmentid());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ?+'%' ");//quyanping
			params.add(salesBasicPo.getSsesbsalesid());
		}
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) 
				&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) 
				&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) 
				&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

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
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesborderstype()))){
			buffer.append("and S_SE_SB_OrdersType = ? ");
			params.add(salesBasicPo.getSsesborderstype());
		}
		else{
			buffer.append("and S_SE_SB_OrdersType in (1, 2) ");
		}
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){	//加急状态
			if("1".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
				buffer.append("and isnull(S_SE_SB_WorryType,'') = '1'  ");
			} 
			if("2".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
				buffer.append("and isnull(S_SE_SB_WorryType,'') = '2'  ");
			}
		} 
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}
	
	/**
	 * 得到订单及顾客信息 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getSalesDetailInfo(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  S_SE_SB_SalesID as ssesbsalesid , S_SE_SB_CustomerID as ssesbcustomerid , ");
		buffer.append("S_SE_SB_ShopCode as ssesbshopcode , S_SE_SB_SalesDatetime as ssesbsalesdatetime , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , S_SE_SB_OrdersType as ssesborderstype , ");
		buffer.append("B_DP_DepartmentName as ssesbshopName ,  S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("S_ME_CI_Phone as ssesbphone , S_SE_IT_Date as ssesbmaterialsdate ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join S_SE_InTransit on S_SE_InTransit.S_SE_IT_SalesID=S_SE_SalesBasic.S_SE_SB_SalesID and S_SE_IT_State = '6' ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("inner join B_Departments on B_Departments.B_DP_DepartmentID = S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		return (SalesBasicPo) queryForObject(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}
	
	public SalesBasicPo getSalesDetailInfoFinished(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  S_SE_SB_SalesID as ssesbsalesid , S_SE_SB_CustomerID as ssesbcustomerid , ");
		buffer.append("S_SE_SB_ShopCode as ssesbshopcode , S_SE_SB_SalesDatetime as ssesbsalesdatetime , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , S_SE_SB_OrdersType as ssesborderstype , ");
		buffer.append("B_DP_DepartmentName as ssesbshopName ,  S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("S_ME_CI_Phone as ssesbphone , S_SE_IT_Date as ssesbmaterialsdate ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("inner join S_SE_InTransit on S_SE_InTransit.S_SE_IT_SalesID=S_SE_SB_SalesID and S_SE_IT_State = '6' ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("inner join B_Departments on B_Departments.B_DP_DepartmentID = S_SE_SB_ShopCode ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		return (SalesBasicPo) queryForObject(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}
	
	/**
	 * 取出销售单中右眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  S_SE_SB_OrdersType as ssesborderstype , ");
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
	
	public SalesBasicPo getODDetailInfoFinished(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  S_SE_SB_OrdersType as ssesborderstype , ");
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
		buffer.append("from S_SE_SalesBasic_Finished ");
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
		// TODO Auto-generated method stub
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
	
	public SalesBasicPo getOSDetailInfoFinished(SalesBasicPo salesBasicPo){
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
		buffer.append("from S_SE_SalesBasic_Finished ");
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		buffer.append("S_SE_SD_CostsPrive as ssesdcostsprive , S_SE_SD_UnitPrice as ssesdunitprice ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join B_Warehouse on B_Warehouse.B_WH_ID = S_SE_SalesDetail.S_SE_SD_StockId ");
		buffer.append("where S_SE_SD_SalesID= ? ");
		
		params.add(salesDetailPo.getSsesdsalesid());
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , SalesDetailPo.class);
	}
	
	/**
	 * 得到销售单中商品信息
	 * @param salesDetailPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesDetailPo> selectGoodsDetailInfoes(
			SalesDetailPo salesDetailPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("SELECT S_SE_SD_SalesID       AS ssesdsalesid, ");
		buffer.append("       S_SE_SD_SalesItemID   AS ssesdsalesitemid, ");
		buffer.append("       S_SE_SD_SalesItemName AS ssesdsalesitemname, ");
		buffer.append("       S_SE_SD_GlassFlag     AS ssesdglassflag, ");
		buffer.append("       S_SE_SD_ItemID        AS ssesditemid, ");
		buffer.append("       B_WH_warehouseName    AS ssesdstockname, ");
		buffer.append("       S_SE_SD_StockId       AS ssesdstockid, ");
		buffer.append("       S_SE_SD_Number        AS ssesdnumber, ");
		buffer.append("       S_SE_SD_CostsPrive    AS ssesdcostsprive, ");
		buffer.append("       S_SE_SD_UnitPrice     AS ssesdunitprice, ");
		buffer.append("       S_SE_SD_ID            AS uuid ");
		buffer.append("FROM   S_SE_SalesDetail ");
		buffer.append("       INNER JOIN B_Warehouse ");
		buffer.append("         ON B_Warehouse.B_WH_ID = S_SE_SalesDetail.S_SE_SD_StockId ");
		buffer.append("WHERE  S_SE_SD_SalesID = ? ");
		
		params.add(salesDetailPo.getSsesdsalesid());
		
		return queryForObjectList(buffer.toString() , params.toArray() , SalesDetailPo.class);
	}
	
	public List<SalesDetailPo> selectGoodsDetailInfoesFinished(SalesDetailPo salesDetailPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("SELECT S_SE_SD_SalesID       AS ssesdsalesid, ");
		buffer.append("       S_SE_SD_SalesItemID   AS ssesdsalesitemid, ");
		buffer.append("       S_SE_SD_SalesItemName AS ssesdsalesitemname, ");
		buffer.append("       S_SE_SD_GlassFlag     AS ssesdglassflag, ");
		buffer.append("       S_SE_SD_ItemID        AS ssesditemid, ");
		buffer.append("       B_WH_warehouseName    AS ssesdstockname, ");
		buffer.append("       S_SE_SD_StockId       AS ssesdstockid, ");
		buffer.append("       S_SE_SD_Number        AS ssesdnumber, ");
		buffer.append("       S_SE_SD_CostsPrive    AS ssesdcostsprive, ");
		buffer.append("       S_SE_SD_UnitPrice     AS ssesdunitprice, ");
		buffer.append("       S_SE_SD_ID            AS uuid ");
		buffer.append("FROM   S_SE_SalesDetail_Finished ");
		buffer.append("       INNER JOIN B_Warehouse ");
		buffer.append("         ON B_Warehouse.B_WH_ID = S_SE_SD_StockId ");
		buffer.append("WHERE  S_SE_SD_SalesID = ? ");
		
		params.add(salesDetailPo.getSsesdsalesid());
		
		return queryForObjectList(buffer.toString() , params.toArray() , SalesDetailPo.class);
	}
	
	/**
	 * 查询已打印发料单的总数
	 */
	public int getPrintSpectaclesMaterialsBillFinishCount(SalesBasicPo salesBasicPo){
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select sum(count1) from (  ");
		buffer.append("select count(distinct S_SE_SB_SalesID) as count1 ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID=S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("left join S_SE_InTransit on S_SE_InTransit.S_SE_IT_SalesID=S_SE_SalesBasic.S_SE_SB_SalesID and S_SE_IT_State = '6' ");	
		buffer.append("left join SYS_PersonInfo on SYS_PersonInfo.ID=S_SE_InTransit.S_SE_IT_CreatePerson ");
		buffer.append("where isnull(S_SE_SB_PrintSMFlag,'0')='1' ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
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
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) 
				&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) 
				&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

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
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesborderstype()))){
			buffer.append("and S_SE_SB_OrdersType = ? ");
			params.add(salesBasicPo.getSsesborderstype());
		}
		else{
			buffer.append("and S_SE_SB_OrdersType in (1, 2) ");
		}
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){	//加急状态
			if("1".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
				buffer.append("and isnull(S_SE_SB_WorryType,'') = '1'  ");
			} 
			if("2".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
				buffer.append("and isnull(S_SE_SB_WorryType,'') = '2'  ");
			}
		} 
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbprintserialnumber()))){
			buffer.append("and S_SE_SB_PrintFldID like '%' + ? + '%'");
			params.add(Utility.getName(salesBasicPo.getSsesbprintserialnumber()));
		}
		buffer.append(" union all ");		
		buffer.append("select count(distinct S_SE_SB_SalesID) as count1 ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("inner join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SB_ShopCode ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID=S_SE_SB_CustomerID ");
		buffer.append("left join S_SE_InTransit on S_SE_InTransit.S_SE_IT_SalesID=S_SE_SB_SalesID and S_SE_IT_State = '6' ");	
		buffer.append("left join SYS_PersonInfo on SYS_PersonInfo.ID=S_SE_InTransit.S_SE_IT_CreatePerson ");
		buffer.append("where isnull(S_SE_SB_PrintSMFlag,'0')='1' ");
				
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
		}
		
		//按制造商查询
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsupplierid()))){
			buffer.append("and S_SE_SB_SalesID in ( ");
			buffer.append("select S_SE_SD_SalesID from S_SE_SalesDetail_Finished ");
			buffer.append("inner join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID = S_SE_SD_SalesItemID ");
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
			buffer.append("and S_SE_SB_ShopCode in ");
			buffer.append("(select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) ");
		
			params.add(salesBasicPo.getSsesbdepartmentid());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbprocessdpt()))){
			buffer.append("and S_SE_SB_ShopCode in ");
			buffer.append("(select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) ");
		
			params.add(Utility.getName(salesBasicPo.getSsesbprocessdpt()));
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ?+'%' ");//quyanping
			params.add(salesBasicPo.getSsesbsalesid());
		}
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) 
				&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) 
				&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) 
				&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

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
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesborderstype()))){
			buffer.append("and S_SE_SB_OrdersType = ? ");
			params.add(salesBasicPo.getSsesborderstype());
		}
		else{
			buffer.append("and S_SE_SB_OrdersType in (1, 2) ");
		}
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){	//加急状态
			if("1".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
				buffer.append("and isnull(S_SE_SB_WorryType,'') = '1'  ");
			} 
			if("2".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
				buffer.append("and isnull(S_SE_SB_WorryType,'') = '2'  ");
			}
		} 
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbprintserialnumber()))){
			buffer.append("and S_SE_SB_PrintFldID like '%' + ? + '%'");
			params.add(Utility.getName(salesBasicPo.getSsesbprintserialnumber()));
		}
		buffer.append(" )t ");
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	/**
	 * 查询已打印发料单
	 */
	public List<SalesBasicPo> selectPrintSpectaclesMaterialsBillFinish(SalesBasicPo salesBasicPo , int start , int size){
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		
		if ("2".equals(Utility.getNameNum(salesBasicPo.getSsesborderby()))){			
			buffer.append("order by ssesbshopName desc,ssesbsalesdatetime desc ) as rowNum,* from ( ");
		}else{
			buffer.append("order by ssesbsalesdatetime desc ) as rowNum,* from ( ");
		}		
		
		buffer.append("select distinct S_SE_SB_SalesID as ssesbsalesid , S_ME_CI_Name as ssesbpersonName , S_SE_SB_ShopCode as ssesbshopcode ,S_SE_SB_CheckoutFlag as ssesbcheckoutflag, ");
		buffer.append("S_SE_SB_OrdersType as ssesborderstype , S_SE_SB_PosDatetime as ssesbsalesdatetime , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("personName as ssesbmaterialsperson , convert(varchar(16),S_SE_IT_Date,120) as ssesbmaterialsdate,S_SE_SB_WorryType as ssesbworrytype,isnull(S_SE_SB_PrintFldID,'') as ssesbprintserialnumber ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID=S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("left join S_SE_InTransit on S_SE_InTransit.S_SE_IT_SalesID=S_SE_SalesBasic.S_SE_SB_SalesID and S_SE_IT_State = '6' ");	
		buffer.append("left join SYS_PersonInfo on SYS_PersonInfo.ID=S_SE_InTransit.S_SE_IT_CreatePerson ");
		buffer.append("where isnull(S_SE_SB_PrintSMFlag,'0')='1' ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
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
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) 
				&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) 
				&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

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
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesborderstype()))){
			buffer.append("and S_SE_SB_OrdersType = ? ");
			params.add(salesBasicPo.getSsesborderstype());
		}
		else{
			buffer.append("and S_SE_SB_OrdersType in (1, 2) ");
		}
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){	//加急状态
			if("1".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
				buffer.append("and isnull(S_SE_SB_WorryType,'') = '1'  ");
			} 
			if("2".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
				buffer.append("and isnull(S_SE_SB_WorryType,'') = '2'  ");
			}
		} 
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbprintserialnumber()))){
			buffer.append("and S_SE_SB_PrintFldID like '%' + ? + '%'");
			params.add(Utility.getName(salesBasicPo.getSsesbprintserialnumber()));
		}
		
		buffer.append(" union all ");
		buffer.append("select distinct S_SE_SB_SalesID as ssesbsalesid , S_ME_CI_Name as ssesbpersonName , S_SE_SB_ShopCode as ssesbshopcode ,S_SE_SB_CheckoutFlag as ssesbcheckoutflag, ");
		buffer.append("S_SE_SB_OrdersType as ssesborderstype , S_SE_SB_PosDatetime as ssesbsalesdatetime , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("personName as ssesbmaterialsperson , convert(varchar(16),S_SE_IT_Date,120) as ssesbmaterialsdate,S_SE_SB_WorryType as ssesbworrytype,isnull(S_SE_SB_PrintFldID,'') as ssesbprintserialnumber ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("inner join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SB_ShopCode ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID=S_SE_SB_CustomerID ");
		buffer.append("left join S_SE_InTransit on S_SE_InTransit.S_SE_IT_SalesID=S_SE_SB_SalesID and S_SE_IT_State = '6' ");	
		buffer.append("left join SYS_PersonInfo on SYS_PersonInfo.ID=S_SE_InTransit.S_SE_IT_CreatePerson ");
		buffer.append("where isnull(S_SE_SB_PrintSMFlag,'0')='1' ");
				
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
		}
		
		//按制造商查询
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsupplierid()))){
			buffer.append("and S_SE_SB_SalesID in ( ");
			buffer.append("select S_SE_SD_SalesID from S_SE_SalesDetail_Finished ");
			buffer.append("inner join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID = S_SE_SD_SalesItemID ");
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
			buffer.append("and S_SE_SB_ShopCode in ");
			buffer.append("(select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) ");
		
			params.add(salesBasicPo.getSsesbdepartmentid());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbprocessdpt()))){
			buffer.append("and S_SE_SB_ShopCode in ");
			buffer.append("(select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) ");
		
			params.add(Utility.getName(salesBasicPo.getSsesbprocessdpt()));
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ?+'%' ");//quyanping
			params.add(salesBasicPo.getSsesbsalesid());
		}
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) 
				&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) 
				&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) 
				&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

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
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesborderstype()))){
			buffer.append("and S_SE_SB_OrdersType = ? ");
			params.add(salesBasicPo.getSsesborderstype());
		}
		else{
			buffer.append("and S_SE_SB_OrdersType in (1, 2) ");
		}
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){	//加急状态
			if("1".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
				buffer.append("and isnull(S_SE_SB_WorryType,'') = '1'  ");
			} 
			if("2".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
				buffer.append("and isnull(S_SE_SB_WorryType,'') = '2'  ");
			}
		} 
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbprintserialnumber()))){
			buffer.append("and S_SE_SB_PrintFldID like '%' + ? + '%'");
			params.add(Utility.getName(salesBasicPo.getSsesbprintserialnumber()));
		}
		
		buffer.append(" )temp ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}
	
	/**
	 * 更新发料单打印状态
	 */
	public void updatePrintSpectaclesMaterialsBillStatus(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update top (1) S_SE_SalesBasic set S_SE_SB_PrintSMFlag = '1' where S_SE_SB_SalesID = ? ");

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 更新发料单流水号
	 */
	public void updatePrintSpectaclesMaterialsBillSerialNumber(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update top (1) S_SE_SalesBasic set S_SE_SB_PrintFldID = ? where S_SE_SB_SalesID = ? ");

		params.add(Utility.getName(salesBasicPo.getSsesbprintserialnumber()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

}
