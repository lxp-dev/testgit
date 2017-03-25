package com.pengsheng.eims.components.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.logistics.persistence.PayMentBillPo;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageEntryPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageTypePo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.sales.persistence.SpecialPDetailPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class InTransitDetailsDaoImpl extends BaseJdbcDaoSupport implements
		InTransitDetailsDao {

	/**
	 * 显示在途查询信息
	 */
	public List<SalesBasicPo> getSalesBasicDetails(String salesID) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("select ");
		buffer.append("S_SE_SB_SalesID as ssesbsalesid, ");
		buffer.append("B_DP_DepartmentName as ssesbshopcode, ");
		buffer.append("S_ME_CI_Name as ssesbcustomerid, ");
		buffer.append("S_ME_CI_Phone as ssesbphone, ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata, ");
		buffer.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime, ");
		buffer.append("S_SE_SB_SalesValue as ssesbsalesvalue, ");
		buffer.append("S_SE_SB_Psalsvalue as ssesbpsalsvalue  ");
		buffer.append("from S_SE_SalesBasic ");
		buffer
				.append("inner join B_Departments on S_SE_SalesBasic.S_SE_SB_ShopCode = B_Departments.B_DP_DepartmentID ");
		buffer
				.append("inner join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		buffer.append("where S_SE_SB_SalesID = ?  ");
		List<String> params = new ArrayList<String>();
		params.add(salesID);

		return queryForObjectList(buffer.toString(), params.toArray(),
				SalesBasicPo.class);
	}

	/**
	 * 显示在途状态
	 */
	public List<InTransitPo> getInTransitState(String salesid) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("select distinct ");
		buffer.append("S_SE_IT_ID as sseitid, ");
		buffer.append("S_SE_IT_SalesID as sseitsalesid, ");
		buffer.append("S_SE_IT_State as sseitstate, ");
		buffer.append("S_SE_IT_Date as sseitdate, ");
		buffer.append("personName as sseitcreateperson, ");
		buffer.append("isnull(C_ST_CPOD_OrderBillD,'') as orderssalesid ");
		
		buffer.append("from S_SE_InTransit ");

		buffer.append("left join C_ST_ConsignProcessOrderDetails on  S_SE_IT_SalesID = C_ST_CPOD_GlassesBillID ");
		buffer.append("left join C_ST_ConsignProcessOrder on  C_ST_CPO_OrderBillId = C_ST_CPOD_OrderBillD ");
		buffer.append("left join SYS_PersonInfo on S_SE_IT_CreatePerson=SYS_PersonInfo.ID ");
		buffer.append("where 1=1  ");
		buffer.append("and  S_SE_IT_SalesID = ?  ");
		buffer.append("order by sseitdate ");

		List<String> params = new ArrayList<String>();
		params.add(salesid);

		return queryForObjectList(buffer.toString(), params.toArray(),
				InTransitPo.class);
	}

	/**
	 * 显示在途状态
	 */
	public List<InTransitPo> getWeiXinInTransitState(String salesid) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("select distinct ");
		buffer.append("S_SE_IT_ID as sseitid, ");
		buffer.append("S_SE_IT_State as sseitstate, ");
		buffer.append("S_SE_IT_Date as sseitdate ");
		
		buffer.append("from S_SE_InTransit ");

		buffer.append("where 1=1  ");
		buffer.append("and  S_SE_IT_SalesID = ?  ");
		buffer.append("order by sseitdate desc");

		List<String> params = new ArrayList<String>();
		params.add(salesid);

		return queryForObjectList(buffer.toString(), params.toArray(),
				InTransitPo.class);
	}
	
	/**
	 * 得到顾客信息
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getCustomerInfo(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub213
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 S_SE_SB_SalesID as ssesbsalesid , ");
		buffer.append("isnull(S_SE_TM_MaiilAudit,'') as isMail , ");
		buffer.append("S_SE_SB_ShopCode as ssesbshopcode ,S_SE_SB_Location as ssesblocation,(case isnull(S_SE_SB_ProcessDepartment,'') when '' then (select top 1 B_DP_RegID from B_Departments where B_DP_DepartmentID=S_SE_SB_ShopCode) else isnull(S_SE_SB_ProcessDepartment,'') end ) as ssesbprocessdepartment, ");
		buffer.append("b1.B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("b1.B_DP_Phone as ssesbsalestelphone , ");
		buffer.append("b2.B_DP_DepartmentName as ssesbtakeshopname , ");
		buffer.append("(case isnull(S_SE_SB_ProcessDepartment,'') when '' then (select top 1 B_DP_DepartmentName from B_Departments where B_DP_DepartmentID in (select regid from (select top 1 B_DP_RegID as regid from B_Departments where B_DP_DepartmentID=S_SE_SB_ShopCode)temp)) else b3.B_DP_DepartmentName end) as ssesbprocessdepartmentname , ");
		buffer.append("S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("S_SE_SB_RecipeType as ssesbrecipetype , ");
		buffer.append("S_ME_CI_Phone as ssesbphone , ");
		buffer.append("S_SE_SB_OrdersType as ssesborderstype , ");
		buffer.append("S_SE_SB_PosDatetime as ssesbsalesdatetime , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , ");
		buffer.append("S_SE_SB_PriceSum as ssesbpricesum , ");
		buffer.append("S_SE_SB_DiscountNum as ssesbdiscountnum , ");
		buffer.append("S_SE_SB_SalesValue as ssesbsalesvalue , ");
		buffer.append("S_SE_SB_Psalsvalue as ssesbpsalsvalue , S_SE_SB_Djsbm as djsbm,");
		buffer.append("isnull(S_SE_SB_StoredCard,0.00) as ssesbstoredcard , ");
		buffer.append("S_ME_CI_MemberId as ssesbMemberId, ");
		buffer.append("S_SE_SB_InTransit as ssesbintransit,S_SE_SB_PosID as ssesbposid, ");
		buffer.append("(select personName from SYS_PersonInfo where ID=S_SE_SB_SalerID) as ssesbsalerid, ");
		buffer.append("S_SE_SB_WithdrawDate as ssesbwithdrawdate,");
		buffer.append("S_SE_SB_ValueFlag as ssesbvalueflag, ");
		buffer.append("S_SE_SB_ArrearsValue as ssesbarrearsvalue, ");
		buffer.append("S_SE_SB_WithdrawFlag as ssesbwithdrawflag, ");
		buffer.append("S_SE_SB_CheckoutFlag as ssesbcheckoutflag,isnull(S_ME_CI_Integral,'0') as inintrgral, ");
		buffer.append("S_SE_SB_Renums as ssesbrenums,cast(S_SE_SB_Integral as numeric(20)) as ssesbintegral,S_ME_CI_CustomerID as ssesbcustomerid, ");
		buffer.append("S_SE_SB_SalesRemark as ssesbsalesremark,S_SE_SB_DignosisRe as ssesbdignosisre,b1.B_DP_Phone as ssesbsalestelphone,b2.B_DP_Phone as ssesbtaketelphone, ");
		
		buffer.append("(select isnull(sum(cast(isnull(S_ME_AS_CIntegral,0) as float)),0.00) from S_ME_IntegralAddandSub where S_ME_AS_SalesBillID = ?) as ssesbjfamount  ");
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		buffer.append(",S_SE_SB_DueIntegral as ssesbdueintegral ");
		buffer.append(",S_ME_CI_FCustomerId as ssesbfcustomerid ");
		buffer.append(",S_ME_CI_ConsumptionNumber as ssesbsalescount ");
		buffer.append("from S_ME_CustomerInfo ");
		buffer.append("left join S_SE_SalesBasic on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("left join B_Departments b1 on b1.B_DP_DepartmentID = S_SE_SB_ShopCode ");
		buffer.append("left join B_Departments b2 on b2.B_DP_DepartmentID = S_SE_SB_Location ");
		buffer.append("left join B_Departments b3 on b3.B_DP_DepartmentID = S_SE_SB_ProcessDepartment ");
		buffer.append("left join  S_SE_ToMail ON S_SE_SB_SalesID = S_SE_ToMail.S_SE_TM_LinkSalesID ");
		buffer.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbcustomerid()))){
			buffer.append("and S_ME_CI_CustomerID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcustomerid()));
			
		}else if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
			
		}
	
		return (SalesBasicPo) queryForObject(buffer.toString(), params.toArray(), SalesBasicPo.class);
	}
	
	public SalesBasicPo getCustomerInfoFinished(SalesBasicPo salesBasicPo){
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 S_SE_SB_SalesID as ssesbsalesid , ");
		buffer.append("isnull(S_SE_TM_MaiilAudit,'') as isMail , ");
		buffer.append("S_SE_SB_ShopCode as ssesbshopcode ,S_SE_SB_Location as ssesblocation,(case isnull(S_SE_SB_ProcessDepartment,'') when '' then (select top 1 B_DP_RegID from B_Departments where B_DP_DepartmentID=S_SE_SB_ShopCode) else isnull(S_SE_SB_ProcessDepartment,'') end ) as ssesbprocessdepartment, ");
		buffer.append("b1.B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("b1.B_DP_Phone as ssesbsalestelphone , ");
		buffer.append("b2.B_DP_DepartmentName as ssesbtakeshopname , ");
		buffer.append("(case isnull(S_SE_SB_ProcessDepartment,'') when '' then (select top 1 B_DP_DepartmentName from B_Departments where B_DP_DepartmentID in (select regid from (select top 1 B_DP_RegID as regid from B_Departments where B_DP_DepartmentID=S_SE_SB_ShopCode)temp)) else b3.B_DP_DepartmentName end) as ssesbprocessdepartmentname , ");
		buffer.append("S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("S_SE_SB_RecipeType as ssesbrecipetype , ");
		buffer.append("S_ME_CI_Phone as ssesbphone , ");
		buffer.append("S_SE_SB_OrdersType as ssesborderstype , ");
		buffer.append("S_SE_SB_PosDatetime as ssesbsalesdatetime , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , ");
		buffer.append("S_SE_SB_PriceSum as ssesbpricesum , ");
		buffer.append("S_SE_SB_DiscountNum as ssesbdiscountnum , ");
		buffer.append("S_SE_SB_SalesValue as ssesbsalesvalue , ");
		buffer.append("S_SE_SB_Psalsvalue as ssesbpsalsvalue , ");
		buffer.append("isnull(S_SE_SB_StoredCard,0.00) as ssesbstoredcard , ");
		buffer.append("S_ME_CI_MemberId as ssesbMemberId, ");
		buffer.append("S_SE_SB_InTransit as ssesbintransit,S_SE_SB_PosID as ssesbposid, ");
		buffer.append("(select personName from SYS_PersonInfo where ID=S_SE_SB_SalerID) as ssesbsalerid, ");
		buffer.append("S_SE_SB_WithdrawDate as ssesbwithdrawdate,");
		buffer.append("S_SE_SB_ValueFlag as ssesbvalueflag, ");
		buffer.append("S_SE_SB_ArrearsValue as ssesbarrearsvalue, ");
		buffer.append("S_SE_SB_WithdrawFlag as ssesbwithdrawflag, ");
		buffer.append("S_SE_SB_CheckoutFlag as ssesbcheckoutflag,isnull(S_ME_CI_Integral,'0') as inintrgral, ");
		buffer.append("S_SE_SB_Renums as ssesbrenums,cast(S_SE_SB_Integral as numeric(20)) as ssesbintegral,S_ME_CI_CustomerID as ssesbcustomerid, ");
		buffer.append("S_SE_SB_SalesRemark as ssesbsalesremark,S_SE_SB_DignosisRe as ssesbdignosisre,b1.B_DP_Phone as ssesbsalestelphone,b2.B_DP_Phone as ssesbtaketelphone, ");
		
		buffer.append("(select isnull(sum(cast(isnull(S_ME_AS_CIntegral,0) as float)),0.00) from S_ME_IntegralAddandSub where S_ME_AS_SalesBillID = ?) as ssesbjfamount  ");
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		buffer.append(",S_SE_SB_DueIntegral as ssesbdueintegral ");
		buffer.append(",S_ME_CI_FCustomerId as ssesbfcustomerid ");
		buffer.append("from S_ME_CustomerInfo ");
		buffer.append("left join S_SE_SalesBasic_Finished on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("left join B_Departments b1 on b1.B_DP_DepartmentID = S_SE_SB_ShopCode ");
		buffer.append("left join B_Departments b2 on b2.B_DP_DepartmentID = S_SE_SB_Location ");
		buffer.append("left join B_Departments b3 on b3.B_DP_DepartmentID = S_SE_SB_ProcessDepartment ");
		buffer.append("left join  S_SE_ToMail ON S_SE_SB_SalesID = S_SE_ToMail.S_SE_TM_LinkSalesID ");
		buffer.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbcustomerid()))){
			buffer.append("and S_ME_CI_CustomerID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcustomerid()));
			
		}else if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
			
		}
	
		return (SalesBasicPo) queryForObject(buffer.toString(), params.toArray(), SalesBasicPo.class);
	}
	
	/**
	 * 得到顾客信息
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getCustomerInfoByID(SalesBasicPo salesBasicPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1  S_SE_SB_SalesID as ssesbsalesid , ");
		buffer.append("S_SE_TM_MaiilAudit as isMail ,  ");
		buffer.append("S_SE_SB_ShopCode as ssesbshopcode ,S_SE_SB_Location as ssesblocation,(case isnull(S_SE_SB_ProcessDepartment,'') when '' then (select top 1 B_DP_RegID from B_Departments where B_DP_DepartmentID=S_SE_SB_ShopCode) else isnull(S_SE_SB_ProcessDepartment,'') end ) as ssesbprocessdepartment, ");
		buffer.append("b1.B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("b2.B_DP_DepartmentName as ssesbtakeshopname , ");
		buffer.append("(case isnull(S_SE_SB_ProcessDepartment,'') when '' then (select top 1 B_DP_DepartmentName from B_Departments where B_DP_DepartmentID in (select regid from (select top 1 B_DP_RegID as regid from B_Departments where B_DP_DepartmentID=S_SE_SB_ShopCode)temp)) else b3.B_DP_DepartmentName end) as ssesbprocessdepartmentname , ");
		buffer.append("S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("S_SE_SB_RecipeType as ssesbrecipetype , ");
		buffer.append("S_ME_CI_Phone as ssesbphone , ");
		buffer.append("S_SE_SB_OrdersType as ssesborderstype , ");
		buffer.append("S_SE_SB_PosDatetime as ssesbsalesdatetime , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , ");
		buffer.append("S_SE_SB_PriceSum as ssesbpricesum , ");
		buffer.append("S_SE_SB_DiscountNum as ssesbdiscountnum , ");
		buffer.append("S_SE_SB_SalesValue as ssesbsalesvalue , ");
		buffer.append("S_SE_SB_Psalsvalue as ssesbpsalsvalue , ");
		buffer.append("S_ME_CI_MemberId as ssesbMemberId, ");
		buffer.append("S_SE_SB_InTransit as ssesbintransit, ");
		buffer.append("S_SE_SB_WithdrawDate as ssesbwithdrawdate,");
		buffer.append("S_SE_SB_ValueFlag as ssesbvalueflag, ");
		buffer.append("S_SE_SB_ArrearsValue as ssesbarrearsvalue, ");
		buffer.append("S_SE_SB_WithdrawFlag as ssesbwithdrawflag, ");
		buffer.append("S_SE_SB_CheckoutFlag as ssesbcheckoutflag,isnull(S_ME_CI_Integral,'0') as inintrgral, ");
		buffer.append("S_SE_SB_Renums as ssesbrenums,cast(S_SE_SB_Integral as numeric(20)) as ssesbintegral,S_SE_SB_CustomerID as ssesbcustomerid, ");
		buffer.append("S_SE_SB_WithdrawFlag as ssesbwithdrawflag, ");
		buffer.append("S_SE_SB_SalesRemark as ssesbsalesremark,S_SE_SB_DignosisRe as ssesbdignosisre,b1.B_DP_Phone as ssesbsalestelphone,b2.B_DP_Phone as ssesbtaketelphone ");
		buffer.append(",S_ME_CI_FCustomerId as ssesbfcustomerid ");
		buffer.append("from S_ME_CustomerInfo ");
		buffer.append("left join uview_SalesBasic on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("left join B_Departments b1 on b1.B_DP_DepartmentID = S_SE_SB_ShopCode ");
		buffer.append("left join B_Departments b2 on b2.B_DP_DepartmentID = S_SE_SB_Location ");
		buffer.append("left join B_Departments b3 on b3.B_DP_DepartmentID = S_SE_SB_ProcessDepartment ");
		buffer.append("left join S_SE_ToMail ON S_SE_SB_SalesID = S_SE_ToMail.S_SE_TM_LinkSalesID ");
		buffer.append("where 1=1 ");
		
		if(!Utility.getName(salesBasicPo.getSsesbcustomerid()).equals("")){
			buffer.append("and S_ME_CI_CustomerID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcustomerid()));
		}else if(!Utility.getName(salesBasicPo.getSsesbsalesid()).equals("")){
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		}
		
		return (SalesBasicPo) queryForObject(buffer.toString(), params
				.toArray(), SalesBasicPo.class);
	}

	/**
	 * 得到配镜单中商品的详细信息
	 */
	public List<SalesDetailPo> getGoodsInfo(SalesDetailPo salesDetailPo) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select * from ( ");
		buffer.append("select S_SE_SD_ID as ssesdid, ");
		buffer.append("S_SE_SD_ItemID as ssesditemid , ");		
		buffer.append("S_SE_SD_SalesItemID as ssesdsalesitemid , ");
		buffer.append("S_SE_SD_CommoditiesFlag as ssesdcommoditiesflag , ");		
		buffer.append("S_SE_SD_SalesItemName as ssesdsalesitemname , ");
		buffer.append("S_SE_SD_SPrice as ssesdsprice , S_SE_SD_UnitPrice as ssesdunitprice,S_SE_SD_CostsPrive as ssesdcostsprive,");
		buffer.append("S_SE_SD_Number as ssesdnumber , ");
		buffer.append("S_SE_SD_DiscountRate as ssesddiscountrate , ");
		buffer.append("S_SE_SD_DiscountNum as ssesddiscountnum , ");
		buffer.append("S_SE_SD_SalesValue as ssesdsalesvalue , ");
		buffer.append("S_SE_SD_PriceSum as ssesdpricesum , ");
		buffer.append("S_SE_SD_GoodDescribe as ssesdgooddescribe, ");
		buffer.append("S_SE_SD_Renums as ssesdrenum, ");
		buffer.append("S_SE_SD_Instockid as ssesdinstockid,S_SE_SB_WithdrawFlag as ssesdwithdrawflag, ");
		buffer.append("w1.B_WH_warehouseName as ssesdstockname,S_SE_SD_StockId as  ssesdstockid,S_SE_SD_LargessFlag as ssesdlargessflag, ");
		buffer.append("CONVERT(varchar(100), S_SE_SD_Updatetime, 20) as ssesdupdatetime,S_SE_SD_Integral as ssesintegral,S_SE_SD_OutStorageFlag as ssesoutstorageflag,S_SE_SD_InStorageFlag as ssesinstorageflag, ");
		buffer.append("w2.B_WH_warehouseName as ssesdinstockname,S_SE_SB_WithdrawDate as ssesdwithdrawdate,S_SE_SD_Setmealid as ssesdsetmealid,isnull(S_SM_SM_Title,'') as ssesdsetmealtitle, ");		
		buffer.append("isnull(B_GI_isCustomize,'') as ssesdiscustomize,B_GI_SupplierID as ssesdsupplierid,isnull(B_GI_AccessoriesType,'') as ssesdaccessoriestype, ");		
		buffer.append("isnull(S_SE_SD_Guaranteeperiod,'') as ssesdguaranteeperiod,isnull(S_SE_SD_Batch,'') as ssesdbatch,isnull(S_SE_SD_RegistrationNum,'') as ssesdregistrationnum ");
		buffer.append(",case S_SE_SD_GlassFlag when 'F' then 1 when 'R' then 2 when 'L' then 3 else '4' end as orderid ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("left join S_SE_SalesDetail on S_SE_SalesBasic.S_SE_SB_SalesID = S_SE_SalesDetail.S_SE_SD_SalesID ");
		buffer.append("left join B_GoodsInfo on B_GI_GoodsID = S_SE_SD_SalesItemID ");
		buffer.append("left join B_Warehouse w1 on S_SE_SalesDetail.S_SE_SD_StockId = w1.B_WH_ID ");
		buffer.append("left join B_Warehouse w2 on S_SE_SalesDetail.S_SE_SD_Instockid = w2.B_WH_ID ");
		buffer.append("left join S_SM_SetMealRecord s1 on S_SE_SalesDetail.S_SE_SD_Setmealid = s1.S_SM_SM_ID ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		buffer.append("union all ");
		buffer.append("select S_SE_SD_ID as ssesdid, ");
		buffer.append("S_SE_SD_ItemID as ssesditemid , ");		
		buffer.append("S_SE_SD_SalesItemID as ssesdsalesitemid , ");
		buffer.append("S_SE_SD_CommoditiesFlag as ssesdcommoditiesflag , ");		
		buffer.append("S_SE_SD_SalesItemName as ssesdsalesitemname , ");
		buffer.append("S_SE_SD_SPrice as ssesdsprice , S_SE_SD_UnitPrice as ssesdunitprice,S_SE_SD_CostsPrive as ssesdcostsprive,");
		buffer.append("S_SE_SD_Number as ssesdnumber , ");
		buffer.append("S_SE_SD_DiscountRate as ssesddiscountrate , ");
		buffer.append("S_SE_SD_DiscountNum as ssesddiscountnum , ");
		buffer.append("S_SE_SD_SalesValue as ssesdsalesvalue , ");
		buffer.append("S_SE_SD_PriceSum as ssesdpricesum , ");
		buffer.append("S_SE_SD_GoodDescribe as ssesdgooddescribe, ");
		buffer.append("S_SE_SD_Renums as ssesdrenum, ");
		buffer.append("S_SE_SD_Instockid as ssesdinstockid,S_SE_SB_WithdrawFlag as ssesdwithdrawflag, ");
		buffer.append("w1.B_WH_warehouseName as ssesdstockname,S_SE_SD_StockId as  ssesdstockid,S_SE_SD_LargessFlag as ssesdlargessflag, ");
		buffer.append("CONVERT(varchar(100), S_SE_SD_Updatetime, 20) as ssesdupdatetime,S_SE_SD_Integral as ssesintegral,S_SE_SD_OutStorageFlag as ssesoutstorageflag,S_SE_SD_InStorageFlag as ssesinstorageflag, ");
		buffer.append("w2.B_WH_warehouseName as ssesdinstockname,S_SE_SB_WithdrawDate as ssesdwithdrawdate,S_SE_SD_Setmealid as ssesdsetmealid,isnull(S_SM_SM_Title,'') as ssesdsetmealtitle, ");		
		buffer.append("isnull(B_GI_isCustomize,'') as ssesdiscustomize,B_GI_SupplierID as ssesdsupplierid,isnull(B_GI_AccessoriesType,'') as ssesdaccessoriestype, ");	
		buffer.append("isnull(S_SE_SD_Guaranteeperiod,'') as ssesdguaranteeperiod,isnull(S_SE_SD_Batch,'') as ssesdbatch,isnull(S_SE_SD_RegistrationNum,'') as ssesdregistrationnum ");
		buffer.append(",case S_SE_SD_GlassFlag when 'F' then 1 when 'R' then 2 when 'L' then 3 else '4' end as orderid ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("left join S_SE_SalesDetail_Finished on S_SE_SB_SalesID = S_SE_SD_SalesID ");
		buffer.append("left join B_GoodsInfo on B_GI_GoodsID = S_SE_SD_SalesItemID ");
		buffer.append("left join B_Warehouse w1 on S_SE_SD_StockId = w1.B_WH_ID ");
		buffer.append("left join B_Warehouse w2 on S_SE_SD_Instockid = w2.B_WH_ID ");
		buffer.append("left join S_SM_SetMealRecord s1 on S_SE_SD_Setmealid = s1.S_SM_SM_ID ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		buffer.append(")temp ");
		buffer.append("order by temp.orderid ");
		
		params.add(salesDetailPo.getSsesdsalesid());
		params.add(salesDetailPo.getSsesdsalesid());
		
		return queryForObjectList(buffer.toString(), params.toArray(),SalesDetailPo.class);
	}
	
	public List<SalesDetailPo> getGoodsInfoFinished(SalesDetailPo salesDetailPo){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select * from ( ");
		buffer.append("select S_SE_SD_ID as ssesdid, ");
		buffer.append("S_SE_SD_ItemID as ssesditemid , ");		
		buffer.append("S_SE_SD_SalesItemID as ssesdsalesitemid , ");
		buffer.append("S_SE_SD_CommoditiesFlag as ssesdcommoditiesflag , ");
		buffer.append("S_SE_SD_SalesItemName as ssesdsalesitemname , ");
		buffer.append("S_SE_SD_SPrice as ssesdsprice , S_SE_SD_UnitPrice as ssesdunitprice,S_SE_SD_CostsPrive as ssesdcostsprive,");
		buffer.append("S_SE_SD_Number as ssesdnumber , ");
		buffer.append("S_SE_SD_DiscountRate as ssesddiscountrate , ");
		buffer.append("S_SE_SD_DiscountNum as ssesddiscountnum , ");
		buffer.append("S_SE_SD_SalesValue as ssesdsalesvalue , ");
		buffer.append("S_SE_SD_PriceSum as ssesdpricesum , ");
		buffer.append("S_SE_SD_GoodDescribe as ssesdgooddescribe, ");
		buffer.append("S_SE_SD_Renums as ssesdrenum, ");
		buffer.append("S_SE_SD_Instockid as ssesdinstockid,S_SE_SB_WithdrawFlag as ssesdwithdrawflag, ");
		buffer.append("w1.B_WH_warehouseName as ssesdstockname,S_SE_SD_StockId as  ssesdstockid,S_SE_SD_LargessFlag as ssesdlargessflag, ");
		buffer.append("CONVERT(varchar(100), S_SE_SD_Updatetime, 20) as ssesdupdatetime,S_SE_SD_Integral as ssesintegral,S_SE_SD_OutStorageFlag as ssesoutstorageflag,S_SE_SD_InStorageFlag as ssesinstorageflag, ");
		buffer.append("w2.B_WH_warehouseName as ssesdinstockname,S_SE_SB_WithdrawDate as ssesdwithdrawdate,S_SE_SD_Setmealid as ssesdsetmealid,isnull(S_SM_SM_Title,'') as ssesdsetmealtitle, ");		
		buffer.append("isnull(B_GI_isCustomize,'') as ssesdiscustomize,B_GI_SupplierID as ssesdsupplierid,isnull(B_GI_AccessoriesType,'') as ssesdaccessoriestype, ");	
		buffer.append("isnull(S_SE_SD_Guaranteeperiod,'') as ssesdguaranteeperiod,isnull(S_SE_SD_Batch,'') as ssesdbatch,isnull(S_SE_SD_RegistrationNum,'') as ssesdregistrationnum ");
		buffer.append(",case S_SE_SD_GlassFlag when 'F' then 1 when 'R' then 2 when 'L' then 3 else '4' end as orderid ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("left join S_SE_SalesDetail_Finished on S_SE_SB_SalesID = S_SE_SD_SalesID ");
		buffer.append("left join B_GoodsInfo on B_GI_GoodsID = S_SE_SD_SalesItemID ");
		buffer.append("left join B_Warehouse w1 on S_SE_SD_StockId = w1.B_WH_ID ");
		buffer.append("left join B_Warehouse w2 on S_SE_SD_Instockid = w2.B_WH_ID ");
		buffer.append("left join S_SM_SetMealRecord s1 on S_SE_SD_Setmealid = s1.S_SM_SM_ID ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		buffer.append(")temp ");
		buffer.append("order by temp.orderid ");

		params.add(salesDetailPo.getSsesdsalesid());
		
		return queryForObjectList(buffer.toString(), params.toArray(),SalesDetailPo.class);
	}
	
	/**
	 * 得到配镜单中商品的详细信息
	 */
	public List<SalesDetailPo> getReturnGoodsInfo(SalesDetailPo salesDetailPo) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select S_SE_SD_SalesItemID as ssesdsalesitemid , ");
		buffer.append("S_SE_SD_ItemID as ssesditemid , ");
		buffer.append("S_SE_SD_SalesItemName as ssesdsalesitemname , ");
		buffer.append("S_SE_SD_SPrice as ssesdsprice , ");
		buffer.append("S_SE_SD_Number as ssesdnumber , ");
		buffer.append("S_SE_SD_PriceSum as ssesdpricesum , ");
		buffer.append("S_SE_SD_DiscountRate as ssesddiscountrate , ");
		buffer.append("S_SE_SD_DiscountNum as ssesddiscountnum , ");
		buffer.append("S_SE_SD_SalesValue as ssesdsalesvalue , ");
		buffer.append("S_SE_SD_GoodDescribe as ssesdgooddescribe, ");
		buffer.append("S_SE_SD_LargessFlag as ssesdlargessflag, ");
		buffer.append("S_SE_SD_Renums as ssesdrenum, ");
		buffer.append("B_WH_warehouseName as ssesdstockname,S_SE_SD_UnitPrice as ssesdunitprice,S_SE_SD_CostsPrive as ssesdcostsprive, ");
		buffer.append("CONVERT(varchar(100), S_SE_SD_Updatetime, 20) as ssesdupdatetime,S_SE_SD_InStockId as ssesdinstockid,S_SE_SD_StockId as ssesdstockid ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join S_SE_SalesBasic on S_SE_SalesBasic.S_SE_SB_SalesID = S_SE_SalesDetail.S_SE_SD_SalesID ");
		buffer.append("inner join B_Warehouse on S_SE_SalesDetail.S_SE_SD_StockId = B_Warehouse.B_WH_ID ");
		buffer.append("where S_SE_SD_SalesID = ? AND Substring(S_SE_SD_SalesItemID, 3, 2) <> 'zz' and S_SE_SD_ItemID <> '' ");
		buffer.append("union all ");
		buffer.append("select S_SE_SD_SalesItemID as ssesdsalesitemid , ");
		buffer.append("S_SE_SD_ItemID as ssesditemid , ");
		buffer.append("S_SE_SD_SalesItemName as ssesdsalesitemname , ");
		buffer.append("S_SE_SD_SPrice as ssesdsprice , ");
		buffer.append("S_SE_SD_Number as ssesdnumber , ");
		buffer.append("S_SE_SD_PriceSum as ssesdpricesum , ");
		buffer.append("S_SE_SD_DiscountRate as ssesddiscountrate , ");
		buffer.append("S_SE_SD_DiscountNum as ssesddiscountnum , ");
		buffer.append("S_SE_SD_SalesValue as ssesdsalesvalue , ");
		buffer.append("S_SE_SD_GoodDescribe as ssesdgooddescribe, ");
		buffer.append("S_SE_SD_LargessFlag as ssesdlargessflag, ");
		buffer.append("S_SE_SD_Renums as ssesdrenum, ");
		buffer.append("B_WH_warehouseName as ssesdstockname,S_SE_SD_UnitPrice as ssesdunitprice,S_SE_SD_CostsPrive as ssesdcostsprive, ");
		buffer.append("CONVERT(varchar(100), S_SE_SD_Updatetime, 20) as ssesdupdatetime,S_SE_SD_InStockId as ssesdinstockid,S_SE_SD_StockId as ssesdstockid ");
		buffer.append("from S_SE_SalesDetail_Finished ");
		buffer.append("inner join S_SE_SalesBasic_Finished on S_SE_SB_SalesID = S_SE_SD_SalesID ");
		buffer.append("inner join B_Warehouse on S_SE_SD_StockId = B_Warehouse.B_WH_ID ");
		buffer.append("where S_SE_SD_SalesID = ? AND Substring(S_SE_SD_SalesItemID, 3, 2) <> 'zz' and S_SE_SD_ItemID <> '' ");
		
		params.add(salesDetailPo.getSsesdsalesid());
		params.add(salesDetailPo.getSsesdsalesid());

		return queryForObjectList(buffer.toString(), params.toArray(),SalesDetailPo.class);
	}

	/**
	 * 取出销售单中右眼镜片信息
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1  S_SE_SB_OrdersType as ssesborderstype , ");
		buffer.append("S_SE_SB_BallGlassOD as ssesbballglassod , ");
		buffer.append("S_SE_SB_PostGlassOD as ssesbpostglassod , ");
		buffer.append("S_SE_SB_AxesOD as ssesbaxesod , ");
		buffer.append("S_SE_SB_ADDOD as ssesbaddod , ");
		buffer.append("S_SE_SB_ArriseGlassOD1 as ssesbarriseglassod , ");
		buffer.append("S_SE_SB_BasisOD1 as ssesbbasisod , ");
		buffer.append("S_SE_SB_PrismOD as ssesbprismod , ");
		buffer.append("S_SE_SB_InterHighOD as ssesbinterhighod, ");
		buffer.append("S_SE_SB_InterDistanceOD as ssesbinterdistanceod, ");
		buffer.append("S_SE_SB_FarVAOD as ssesbfarvaod, ");
		buffer.append("S_SE_SB_CloseVAOD as ssesbclosevaod, ");
		buffer.append("S_SE_SB_EyeCurvatureOD1 as ssesbeyecurvatureod1, ");
		buffer.append("S_SE_SB_DiameterOD as ssesbdiameterod, ");
		buffer.append("S_SE_SB_Oldeyesize as ssesboldeyesize, ");
		buffer.append("S_SE_SB_Glasshige as ssesbglasshige, ");
		buffer.append("S_SE_SB_Glasswigth as ssesbglasswigth, ");
		buffer.append("S_SE_SB_Framemiddlesize as ssesbframemiddlesize, ");
		buffer.append("S_SE_SB_Galssroad as ssesbgalssroad, ");
		buffer.append("S_SE_SB_Diagonalline as ssesbdiagonalline, ");
		buffer.append("S_SE_SB_Frameform as ssesbframeform, ");
		
		buffer.append(" (select top 1 isnull(B_GI_isCustomize,'') from S_SE_SalesDetail inner join B_GoodsInfo on S_SE_SD_SalesItemID=B_GI_GoodsID ");
		buffer.append(" where S_SE_SD_SalesID=? and S_SE_SD_CommoditiesFlag in ('3','4') and S_SE_SD_GlassFlag='R') as ssesbdragstype ");
		
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("where S_SE_SB_SalesID = ? ");

		params.add(salesBasicPo.getSsesbsalesid());
		params.add(salesBasicPo.getSsesbsalesid());

		return (SalesBasicPo) queryForObject(buffer.toString(), params.toArray(), SalesBasicPo.class);
	}
	
	public SalesBasicPo getODDetailInfoFinished(SalesBasicPo salesBasicPo){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1  S_SE_SB_OrdersType as ssesborderstype , ");
		buffer.append("S_SE_SB_BallGlassOD as ssesbballglassod , ");
		buffer.append("S_SE_SB_PostGlassOD as ssesbpostglassod , ");
		buffer.append("S_SE_SB_AxesOD as ssesbaxesod , ");
		buffer.append("S_SE_SB_ADDOD as ssesbaddod , ");
		buffer.append("S_SE_SB_ArriseGlassOD1 as ssesbarriseglassod , ");
		buffer.append("S_SE_SB_BasisOD1 as ssesbbasisod , ");
		buffer.append("S_SE_SB_PrismOD as ssesbprismod , ");
		buffer.append("S_SE_SB_InterHighOD as ssesbinterhighod, ");
		buffer.append("S_SE_SB_InterDistanceOD as ssesbinterdistanceod, ");
		buffer.append("S_SE_SB_FarVAOD as ssesbfarvaod, ");
		buffer.append("S_SE_SB_CloseVAOD as ssesbclosevaod, ");
		buffer.append("S_SE_SB_EyeCurvatureOD1 as ssesbeyecurvatureod1, ");
		buffer.append("S_SE_SB_DiameterOD as ssesbdiameterod, ");
		buffer.append("S_SE_SB_Oldeyesize as ssesboldeyesize, ");
		buffer.append("S_SE_SB_Glasshige as ssesbglasshige, ");
		buffer.append("S_SE_SB_Glasswigth as ssesbglasswigth, ");
		buffer.append("S_SE_SB_Framemiddlesize as ssesbframemiddlesize, ");
		buffer.append("S_SE_SB_Galssroad as ssesbgalssroad, ");
		buffer.append("S_SE_SB_Diagonalline as ssesbdiagonalline, ");
		buffer.append("S_SE_SB_Frameform as ssesbframeform, ");
		
		buffer.append(" (select top 1 isnull(B_GI_isCustomize,'') from S_SE_SalesDetail_Finished inner join B_GoodsInfo on S_SE_SD_SalesItemID=B_GI_GoodsID ");
		buffer.append(" where S_SE_SD_SalesID=? and S_SE_SD_CommoditiesFlag in ('3','4') and S_SE_SD_GlassFlag='R') as ssesbdragstype ");
		
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("where S_SE_SB_SalesID = ? ");

		params.add(salesBasicPo.getSsesbsalesid());
		params.add(salesBasicPo.getSsesbsalesid());

		return (SalesBasicPo) queryForObject(buffer.toString(), params.toArray(), SalesBasicPo.class);
	}
	
	public int getDetailCount(SalesBasicPo salesBasicPo,String GlassFlag){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select count(S_SE_SD_SalesID) ");
		buffer.append("from S_SE_SalesBasic inner join S_SE_SalesDetail on S_SE_SB_SalesID = S_SE_SD_SalesID inner join B_GoodsInfo on S_SE_SD_SalesItemID=B_GI_GoodsID ");
		buffer.append("where S_SE_SB_SalesID = ? and S_SE_SD_GlassFlag = ? and S_SE_SD_CommoditiesFlag in ('3','4') ");

		params.add(salesBasicPo.getSsesbsalesid());
		params.add(GlassFlag);
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	public int getDetailCount(SalesBasicPo salesBasicPo){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select count(S_SE_SD_SalesID) ");
		buffer.append("from S_SE_SalesBasic inner join S_SE_SalesDetail on S_SE_SB_SalesID = S_SE_SD_SalesID inner join B_GoodsInfo on S_SE_SD_SalesItemID=B_GI_GoodsID ");
		buffer.append("where S_SE_SB_SalesID = ? and S_SE_SD_CommoditiesFlag in ('1') ");

		params.add(salesBasicPo.getSsesbsalesid());
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	public int getDetailCount(SalesDetailPo salesDetailPo){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select count(S_SE_SD_SalesID) ");
		buffer.append("from S_SE_SalesBasic inner join S_SE_SalesDetail on S_SE_SB_SalesID = S_SE_SD_SalesID inner join B_GoodsInfo on S_SE_SD_SalesItemID=B_GI_GoodsID ");
		buffer.append("where S_SE_SB_SalesID = ? ");

		params.add(salesDetailPo.getSsesdsalesid());
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	/**
	 * 取出销售单中左眼镜片信息
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

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
		buffer.append("S_SE_SB_CloseVAOS as ssesbclosevaos,S_SE_SB_EyeCurvatureOS1 as ssesbeyecurvatureos1,S_SE_SB_DiameterOS as ssesbdiameteros, ");
		
		buffer.append(" (select top 1 isnull(B_GI_isCustomize,'') from S_SE_SalesDetail inner join B_GoodsInfo on S_SE_SD_SalesItemID=B_GI_GoodsID ");
		buffer.append(" where S_SE_SD_SalesID=? and S_SE_SD_CommoditiesFlag in ('3','4') and S_SE_SD_GlassFlag='L') as ssesbdragstype ");
		
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("where S_SE_SB_SalesID = ? ");

		params.add(salesBasicPo.getSsesbsalesid());
		params.add(salesBasicPo.getSsesbsalesid());

		return (SalesBasicPo) queryForObject(buffer.toString(), params.toArray(), SalesBasicPo.class);
	}

	public SalesBasicPo getOSDetailInfoFinished(SalesBasicPo salesBasicPo){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

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
		buffer.append("S_SE_SB_CloseVAOS as ssesbclosevaos,S_SE_SB_EyeCurvatureOS1 as ssesbeyecurvatureos1,S_SE_SB_DiameterOS as ssesbdiameteros, ");
		
		buffer.append(" (select top 1 isnull(B_GI_isCustomize,'') from S_SE_SalesDetail_Finished inner join B_GoodsInfo on S_SE_SD_SalesItemID=B_GI_GoodsID ");
		buffer.append(" where S_SE_SD_SalesID=? and S_SE_SD_CommoditiesFlag in ('3','4') and S_SE_SD_GlassFlag='L') as ssesbdragstype ");
		
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("where S_SE_SB_SalesID = ? ");

		params.add(salesBasicPo.getSsesbsalesid());
		params.add(salesBasicPo.getSsesbsalesid());

		return (SalesBasicPo) queryForObject(buffer.toString(), params.toArray(), SalesBasicPo.class);
	}
	
	/**
	 * 取得附加费用
	 */
	public List<AdditionalCDetailPo> getAddititonalCDetail(
			AdditionalCDetailPo additionalCDetailPo) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select S_SE_SalesID as ssesalesid , ");
		buffer.append("S_SE_CostsName as ssecostsname , ");
		buffer.append("S_SE_Amount as sseamount, ");
		buffer.append("S_SE_Number as ssenumber, ");
		buffer.append("S_SE_Amount*S_SE_Number as ssesum ");
		buffer.append("from S_SE_AdditionalCDetail ");
		buffer.append("where S_SE_SalesID = ? ");

		params.add(additionalCDetailPo.getSsesalesid());

		return queryForObjectList(buffer.toString(), params.toArray(),
				AdditionalCDetailPo.class);
	}

	/**
	 * 取得特殊加工要求
	 */
	public List<SpecialPDetailPo> getSpecialPDetail(
			SpecialPDetailPo specialPDetailPo) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select S_SE_SD_SalesID as ssesdsalesid , ");
		buffer.append("S_SE_SD_Requirement as ssesdrequirement ");
		buffer.append("from S_SE_SpecialPDetail ");
		buffer.append("where S_SE_SD_SalesID = ? ");

		params.add(specialPDetailPo.getSsesdsalesid());

		return queryForObjectList(buffer.toString(), params.toArray(),
				SpecialPDetailPo.class);
	}

	/**
	 * 取得重订配镜单的原单号
	 */
	public InTransitPo getOldSalesID(String rSalesID) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 S_SE_IT_YsalesID as sseitysalesid ");
		buffer.append("from S_SE_InTransit ");
		buffer.append("where S_SE_IT_SalesID = '" + rSalesID + "' ");
		return (InTransitPo) queryForObject(buffer.toString(), null,
				InTransitPo.class);
	}

	/**
	 * 根据重订配镜单的原单号显示重订在途状态
	 * 
	 * @param salesid
	 * @return
	 */
	public List<InTransitPo> getOldInTransitState(String salesid) {

		StringBuffer buffer = new StringBuffer();
		buffer
				.append("SELECT a.C_ST_CPO_ReSalesRemark as cstcporesalesremark,a.C_ST_CPOD_OrderBillD as orderssalesid,a.S_SE_IT_YsalesID AS sseitysalesid, a.S_SE_IT_SalesID AS sseitsalesid, SYS_PersonInfo.personName AS sseitcreateperson, a.S_SE_IT_State AS sseitstate,CONVERT(varchar(100), a.S_SE_IT_Date, 20) as sseitdate ");
		buffer
				.append("FROM (SELECT C_ST_CPO_ReSalesRemark,C_ST_CPOD_OrderBillD,S_SE_IT_YsalesID, S_SE_IT_SalesID, S_SE_IT_CreatePerson, S_SE_IT_State,S_SE_IT_Date ");
		buffer.append("FROM S_SE_InTransit ");
		buffer.append("inner join C_ST_ConsignProcessOrderDetails on  S_SE_IT_SalesID = C_ST_CPOD_GlassesBillID ");
		buffer.append("inner join C_ST_ConsignProcessOrder on  C_ST_CPO_OrderBillId = C_ST_CPOD_OrderBillD ");
		buffer.append("WHERE (S_SE_IT_YsalesID = ?) ");
		buffer
				.append("GROUP BY C_ST_CPO_ReSalesRemark,C_ST_CPOD_OrderBillD,S_SE_IT_YsalesID, S_SE_IT_SalesID, S_SE_IT_State, S_SE_IT_CreatePerson, S_SE_IT_Date) AS a ");
		buffer
				.append("INNER JOIN SYS_PersonInfo ON a.S_SE_IT_CreatePerson = SYS_PersonInfo.ID order by sseitstate asc");

		List<String> params = new ArrayList<String>();
		params.add(salesid);

		return queryForObjectList(buffer.toString(), params.toArray(),
				InTransitPo.class);
	}

	/**
	 * 取得配镜单付款信息
	 * 
	 * @param salesid
	 * @return
	 */
	public List<SalesLogPo> getSalesLog(String salesid) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT ROW_NUMBER() Over(order by S_SE_SL_DateTime,S_SE_SL_PaymentType) as sseslorderby,");
		buffer.append("S_SE_SL_UUID as ssesluuid");
		buffer.append(",S_SE_SL_SalesID       as sseslsalesid");
		buffer.append(",S_SE_SL_PaymentType   as sseslpaymenttype");
		buffer.append(",S_SE_SL_ConsumptionID as sseslconsumptionid");
		buffer.append(",CAST(S_SE_SL_Price AS DECIMAL(18, 2))        as sseslprice ");
		buffer.append(",CAST(S_SE_SL_IntegralPrice AS DECIMAL(18, 2)) as sseslintegralprice ");
		buffer.append(",CONVERT(varchar(16), S_SE_SL_DateTime, 20)      as ssesldatetime");
		buffer.append(",CONVERT(varchar(16), S_SE_SL_FactDateTime, 20)      as sseslfactdatetime");
		buffer.append(",SYS_PersonInfo.personName        as sseslperson ");
		buffer.append(",B_B_Name as bbname");
		buffer.append(" FROM         S_SE_SalesLog");
		buffer.append(" INNER JOIN SYS_PersonInfo ON S_SE_SL_Person = SYS_PersonInfo.ID ");
		buffer.append(" left join S_SE_PayDetails on S_SE_PD_SourceBillID=S_SE_SL_SalesID ");
		buffer.append(" LEFT JOIN B_Bank ON B_B_Number = S_SE_SL_SourceID ");
		buffer.append(" where S_SE_SL_SalesID = ? and cast(S_SE_SL_Price as numeric(18,2))<>0 ");		

		List<String> params = new ArrayList<String>();
		params.add(salesid);

		return queryForObjectList(buffer.toString(), params.toArray(),
				SalesLogPo.class);
	}
	
	/**
	 * 判断当前在途状态是否启用
	 * @param inTransitID
	 * @return
	 */
	public String getInTransitFlag(String inTransitID){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 S_SE_SIT_Flag from S_SE_SetInTransit where S_SE_SIT_ID=? order by S_SE_SIT_OrderID ");
		params.add(inTransitID);
		
		return (String) getJdbcTemplate().queryForObject(buffer.toString(),params.toArray(),String.class);
	}
	
	/**
	 *  使用条码非带批号商品判断是否有库存（负库存出库）
	 */
	public int getStorageNumByNotBatch(InventoryEntryPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select sum(num) from ( ");
		buffer.append("select isnull(sum(C_SH_SB_GoodsQuantity),0) as num from C_SH_StorageBeginning ");
		buffer.append("  where C_SH_SB_StockId=? and C_SH_SB_GoodsId=? and C_SH_SB_GoodsBarCode=? ");
		buffer.append("union all ");
		buffer.append("select isnull(sum(C_SH_SC_GoodsQuantity),0) as num from C_SH_StorageChange ");
		buffer.append("  where C_SH_SC_StockId=? and C_SH_SC_GoodsId=? and C_SH_SC_GoodsBarCode=? ");
		buffer.append("union all ");
		buffer.append("select isnull(sum(C_SH_TSE_GoodsNum),0) as num from C_SH_InTransitStorageEntry ");
		buffer.append("  where C_SH_TSE_OutStockID = ? and C_SH_TSE_GoodsID=? and C_SH_TSE_GoodsBarCode=? and C_SH_TSE_InOrOutStock='2' ");
		
		params.add(Utility.getName(po.getCstieoutstockid()));
		params.add(Utility.getName(po.getCstiegoodsid()));
		params.add(Utility.getName(po.getCstiebarcode()).length() > 18 ? Utility.getName(po.getCstiebarcode()).substring(0,18) : Utility.getName(po.getCstiebarcode()));
		params.add(Utility.getName(po.getCstieoutstockid()));
		params.add(Utility.getName(po.getCstiegoodsid()));
		params.add(Utility.getName(po.getCstiebarcode()).length() > 18 ? Utility.getName(po.getCstiebarcode()).substring(0,18) : Utility.getName(po.getCstiebarcode()));
	
		params.add(Utility.getName(po.getCstieoutstockid()));
		params.add(Utility.getName(po.getCstiegoodsid()));
		params.add(Utility.getName(po.getCstiebarcode()));
		
		if(!Utility.getName(po.getCstiebillid()).equals("")){
			buffer.append("    and C_SH_TSE_BillID <> ? ");
			params.add(Utility.getName(po.getCstiebillid()));	
		}
		if(!Utility.getName(po.getCstieisexitsintransit()).equals("")){
			buffer.append("    and 1=0 ");	
		}
		
		buffer.append(")temp  ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	/**
	 *  使用条码非带批号商品判断是否有库存（负库存出库）
	 */
	public int getStorageNumByNotBatch2(InventoryEntryPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select sum(num) from ( ");
		buffer.append("select isnull(sum(C_SH_SL_GoodsQuantity),0) as num from C_SH_StorageLog ");
		buffer.append("  where C_SH_SL_StockId=? and C_SH_SL_GoodsId=? and C_SH_SL_GoodsBarCode=? ");
		buffer.append("union all ");
		buffer.append("select isnull(sum(C_SH_TSE_GoodsNum),0) as num from C_SH_InTransitStorageEntry ");
		buffer.append("  where C_SH_TSE_OutStockID = ? and C_SH_TSE_GoodsID=? and C_SH_TSE_GoodsBarCode=? and C_SH_TSE_InOrOutStock='2' ");
		
		params.add(Utility.getName(po.getCstieoutstockid()));
		params.add(Utility.getName(po.getCstiegoodsid()));
		params.add(Utility.getName(po.getCstiebarcode()));
	
		params.add(Utility.getName(po.getCstieoutstockid()));
		params.add(Utility.getName(po.getCstiegoodsid()));
		params.add(Utility.getName(po.getCstiebarcode()));
		
		if(!Utility.getName(po.getCstiebillid()).equals("")){
			buffer.append("    and C_SH_TSE_BillID <> ? ");
			params.add(Utility.getName(po.getCstiebillid()));	
		}
		if(!Utility.getName(po.getCstieisexitsintransit()).equals("")){
			buffer.append("    and 1=0 ");	
		}
		
		buffer.append(")temp  ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 *  使用条码带批号商品判断是否有库存（负库存出库）
	 */
	public int getStorageNumByBatch(InventoryEntryPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select sum(num) from ( ");
		buffer.append("select isnull(sum(C_SH_SL_GoodsQuantity),0) as num from C_SH_StorageLog ");
		buffer.append("  where C_SH_SL_StockId=? and C_SH_SL_GoodsId=? and C_SH_SL_GoodsBarCode=? ");
		buffer.append("union all ");
		buffer.append("select isnull(sum(C_SH_TSE_GoodsNum),0) as num from C_SH_InTransitStorageEntry ");
		buffer.append("  where C_SH_TSE_OutStockID=? and C_SH_TSE_GoodsID=? and C_SH_TSE_GoodsBarCode=? and C_SH_TSE_InOrOutStock='2' ");
		
		params.add(Utility.getName(po.getCstieoutstockid()));
		params.add(Utility.getName(po.getCstiegoodsid()));
		params.add(Utility.getName(po.getCstiebarcode()));
		
		params.add(Utility.getName(po.getCstieoutstockid()));
		params.add(Utility.getName(po.getCstiegoodsid()));
		params.add(Utility.getName(po.getCstiebarcode()));	
		
		if(!Utility.getName(po.getCstiebillid()).equals("")){
			buffer.append("    and C_SH_TSE_BillID <> ? ");
			params.add(Utility.getName(po.getCstiebillid()));	
		}
		
		buffer.append(")temp  ");
		
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 *  不使用条码（负库存出库）
	 */
	public int getStorageNumByGoodsID(InventoryEntryPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select sum(num) from ( ");
		buffer.append("select isnull(sum(C_SH_SB_GoodsQuantity),0) as num from C_SH_StorageBeginning ");
		buffer.append("  where C_SH_SB_StockId=? and C_SH_SB_GoodsId=? ");
		buffer.append("union all ");
		buffer.append("select isnull(sum(C_SH_SC_GoodsQuantity),0) as num from C_SH_StorageChange ");
		buffer.append("  where C_SH_SC_StockId=? and C_SH_SC_GoodsId=? ");
		buffer.append("union all ");
		buffer.append(" select isnull(sum(C_SH_TSE_GoodsNum),0) as num from C_SH_InTransitStorageEntry ");
		buffer.append(" where C_SH_TSE_OUTStockID = ? and C_SH_TSE_GoodsID = ? ");
		
		params.add(Utility.getName(po.getCstieoutstockid()));
		params.add(Utility.getName(po.getCstiegoodsid()));	
		params.add(Utility.getName(po.getCstieoutstockid()));
		params.add(Utility.getName(po.getCstiegoodsid()));
		params.add(Utility.getName(po.getCstieoutstockid()));
		params.add(Utility.getName(po.getCstiegoodsid()));
		
		if(!Utility.getName(po.getCstiebillid()).equals("")){
			buffer.append("    and C_SH_TSE_BillID <> ? ");
			params.add(Utility.getName(po.getCstiebillid()));	
		}
		if(!Utility.getName(po.getCstieisexitsintransit()).equals("")){
			buffer.append("    and 1=0 ");	
		}
		
		buffer.append(" )temp ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 *  根据仓位获取所在门店
	 */
	public DepartmentsPo getDepartmentByWarehouse(InventoryPo po){		
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 B_WH_deptID as bdpdepartmentid from B_Warehouse where B_WH_ID=? ");
		
		params.add(Utility.getName(po.getCstioutstockid()));
		
		return (DepartmentsPo) queryForObject(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 *  根据商品代码(除隐形外)判断是否使用批号
	 */
	public GoodsCategoryPo getGoodsContainBatch(InventoryEntryPo po){
		return null;
	}
	
	/**
	 *  判断当前模块是否参与在途库存的计算
	 */
	public InTransitStorageTypePo getInTransitStorageSwitch(String moduleID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 C_SH_ST_ID as cshstid,C_SH_ST_ModuleName as cshstmodulename,C_SH_ST_InEnabled as cshstinenabled,C_SH_ST_InDelete as cshstindelete from C_SH_InTransitStorageType where C_SH_ST_ID=? ");
		
		params.add(Utility.getName(moduleID));
		
		return (InTransitStorageTypePo) queryForObject(buffer.toString(), params.toArray(), InTransitStorageTypePo.class);
	}
	
	/**
	 * 获取商品的在途库存（使用条码）
	 */
	public InTransitStorageEntryPo getGoodsInTransitStorageNum(String goodsID,String goodsBarCode,String bgiwarehouseid){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select C_SH_TSE_GoodsID as cshtsegoodsID,C_SH_TSE_GoodsBarCode as cshtsegoodsbarcode,abs(isnull(sum(C_SH_TSE_GoodsNum),0)) as cshtsegoodsNum ");
		buffer.append(" from C_SH_InTransitStorageEntry where C_SH_TSE_DepartmentType in ('1') and C_SH_TSE_GoodsID=? and ((isnull(C_SH_TSE_GoodsBarCode,'')<>'' and C_SH_TSE_GoodsBarCode=?) or isnull(C_SH_TSE_GoodsBarCode,'')='')  ");
		buffer.append(" and (C_SH_TSE_InStockID=? or C_SH_TSE_OutStockID=?) ");
		buffer.append(" group by C_SH_TSE_GoodsID,C_SH_TSE_GoodsBarCode ");
		
		params.add(Utility.getName(goodsID));
		params.add(Utility.getName(goodsBarCode));
		params.add(Utility.getName(bgiwarehouseid));
		params.add(Utility.getName(bgiwarehouseid));
		
		return (InTransitStorageEntryPo) queryForObject(buffer.toString(), params.toArray(), InTransitStorageEntryPo.class);
	}
	
	/**
	 * 获取商品的在途库存（不使用条码）
	 */
	public InTransitStorageEntryPo getGoodsInTransitStorageNum(String goodsID,String bgiwarehouseid){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select C_SH_TSE_GoodsID as cshtsegoodsID,abs(sum(C_SH_TSE_GoodsNum)) as cshtsegoodsNum ");
		buffer.append(" from C_SH_InTransitStorageEntry where C_SH_TSE_DepartmentType in ('1') and C_SH_TSE_GoodsID=? ");
		buffer.append(" and (C_SH_TSE_InStockID=? or C_SH_TSE_OutStockID=?) ");
		buffer.append(" group by C_SH_TSE_GoodsID ");
		
		params.add(Utility.getName(goodsID));
		params.add(Utility.getName(bgiwarehouseid));
		params.add(Utility.getName(bgiwarehouseid));
		
		return (InTransitStorageEntryPo) queryForObject(buffer.toString(), params.toArray(), InTransitStorageEntryPo.class);
	}
	
	/**
	 * 根据商品代码查询商品信息
	 */
	public GoodsInfoPo getSalesGoodsInfo(String goodsID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select top 1 B_GI_GoodsCategoryID as bgigoodscategoryid,B_GI_SupplierID as bgisupplierid,isnull(B_GI_TaxRate,17) as bgitaxrate,isnull(B_GI_isCustomize,'') as bgiiscustomize,isnull(B_GI_NotTaxRate,0) as bginottaxrate,isnull(B_GI_CostPrice,0) as bgicostprice,isnull(B_GI_RetailPrice,0) as bgiretailprice,isnull(B_GI_WholesalePrice,0) as bgiwholesaleprice from B_GoodsInfo where B_GI_GoodsID=? ");
	
		params.add(Utility.getName(goodsID));
		
		return (GoodsInfoPo) queryForObject(buffer.toString(), params.toArray(), GoodsInfoPo.class);
	}
	
	/**
	 * 获取需要做自动调拨的商品
	 */
	public List<SalesDetailPo> getAutoAllocationGoodsList(SalesDetailPo salesDetailPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select S_SE_SD_ID as ssesdid,S_SE_SD_SalesItemID as ssesdsalesitemid,S_SE_SD_ItemID as ssesditemid,S_SE_SD_StockId as ssesdstockid,S_SE_SD_Number as ssesdnumber,S_SE_SD_UnitPrice as ssesdunitprice,S_SE_SD_CostsPrive as ssesdcostsprive,isnull(S_SE_SD_Guaranteeperiod,'') as ssesdguaranteeperiod,isnull(S_SE_SD_Batch,'') as ssesdbatch,isnull(S_SE_SD_RegistrationNum,'') as ssesdregistrationnum from S_SE_SalesDetail  ");
		
		if ("D".equals(Utility.getName(salesDetailPo.getSsesdiscustomize()))){
			buffer.append(" inner join B_GoodsInfo on S_SE_SD_SalesItemID = B_GI_GoodsID ");
		}
		
		buffer.append(" where S_SE_SD_SalesID=? ");
		
		if ("D".equals(Utility.getName(salesDetailPo.getSsesdiscustomize()))){
			buffer.append(" and B_GI_isCustomize = 'D' ");
		}

		if ("1".equals(Utility.getName(salesDetailPo.getSsesdlargessflag()))){
			buffer.append(" and S_SE_SD_LargessFlag='1' ");
		}else{
			buffer.append(" and S_SE_SD_LargessFlag<>'1' ");
		}
		
		params.add(Utility.getName(Utility.getName(salesDetailPo.getSsesdsalesid())));
		
		if (!"".equals(Utility.getName(salesDetailPo.getSsesdcommoditiesflag()))){
			buffer.append(" and S_SE_SD_CommoditiesFlag=? ");
			params.add(Utility.getName(Utility.getName(salesDetailPo.getSsesdcommoditiesflag())));
		}
		buffer.append(" order by S_SE_SD_StockId ");
		
		return queryForObjectList(buffer.toString(), params.toArray(),SalesDetailPo.class);
	}
	
	/**
	 * 得到配镜单中商品的详细信息
	 */
	public List<SalesDetailPo> getSalesGoodsInfo(SalesDetailPo salesDetailPo) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select S_SE_SD_SalesItemID as ssesdsalesitemid , ");
		buffer.append("S_SE_SD_ItemID as ssesditemid , ");		
		buffer.append("sum(S_SE_SD_Number) as ssesdnumber , ");
		buffer.append("S_SE_SD_StockId as  ssesdstockid ");
		buffer.append("from S_SE_SalesDetail ");
		if (!"".equals(Utility.getName(salesDetailPo.getSsesdiscustomize()))){
			buffer.append(" inner join B_GoodsInfo on S_SE_SD_SalesItemID=B_GI_GoodsID ");
		}
		buffer.append("where S_SE_SD_SalesID = ? ");

		params.add(salesDetailPo.getSsesdsalesid());
		
		if (!"".equals(Utility.getName(salesDetailPo.getSsesdcommoditiesflag()))){
			if (Utility.getName(salesDetailPo.getSsesdcommoditiesflag()).indexOf(",") >= 0){
				buffer.append(" and S_SE_SD_CommoditiesFlag in ( ");
				
				String[] bdptypes = Utility.getName(salesDetailPo.getSsesdcommoditiesflag()).split(",");
				for (int i = 0; i < bdptypes.length; i++){
					buffer.append(" ?, ");
					params.add(Utility.getName(bdptypes[i]));
				}
				buffer.deleteCharAt(buffer.lastIndexOf(","));
				buffer.append(" )  ");
			}else{
				buffer.append(" and S_SE_SD_CommoditiesFlag = ? ");
				params.add(Utility.getName(salesDetailPo.getSsesdcommoditiesflag()));
			}
		}
		if (!"".equals(Utility.getName(salesDetailPo.getSsesdiscustomize()))){
			buffer.append(" and isnull(B_GI_isCustomize,'0')=? ");
			params.add(Utility.getName(salesDetailPo.getSsesdiscustomize()));
		}
		buffer.append(" group by S_SE_SD_SalesItemID,S_SE_SD_ItemID,S_SE_SD_StockId ");
				
		return queryForObjectList(buffer.toString(), params.toArray(),SalesDetailPo.class);
	}
	/**
	 * 得到配镜单中商品的详细信息
	 */
	public List<SalesDetailPo> getSalesGoodsInfo2(SalesDetailPo salesDetailPo) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select S_SE_SD_SalesItemID as ssesdsalesitemid , ");
		buffer.append("S_SE_SD_ItemID as ssesditemid , ");		
		buffer.append("sum(S_SE_SD_Number) as ssesdnumber , ");
		buffer.append("B_GI_BarCodeFlag as rksj, ");
		buffer.append("S_SE_SD_StockId as  ssesdstockid ");
		buffer.append("from S_SE_SalesDetail ");
		if (!"".equals(Utility.getName(salesDetailPo.getSsesdiscustomize()))){
			buffer.append(" inner join B_GoodsInfo on S_SE_SD_SalesItemID=B_GI_GoodsID ");
		}
		buffer.append("where S_SE_SD_SalesID = ? and S_SE_SD_ItemID <>'' ");

		params.add(salesDetailPo.getSsesdsalesid());
		
		if (!"".equals(Utility.getName(salesDetailPo.getSsesdcommoditiesflag()))){
			if (Utility.getName(salesDetailPo.getSsesdcommoditiesflag()).indexOf(",") >= 0){
				buffer.append(" and S_SE_SD_CommoditiesFlag in ( ");
				
				String[] bdptypes = Utility.getName(salesDetailPo.getSsesdcommoditiesflag()).split(",");
				for (int i = 0; i < bdptypes.length; i++){
					buffer.append(" ?, ");
					params.add(Utility.getName(bdptypes[i]));
				}
				buffer.deleteCharAt(buffer.lastIndexOf(","));
				buffer.append(" )  ");
			}else{
				buffer.append(" and S_SE_SD_CommoditiesFlag = ? ");
				params.add(Utility.getName(salesDetailPo.getSsesdcommoditiesflag()));
			}
		}
		if (!"".equals(Utility.getName(salesDetailPo.getSsesdiscustomize()))){
			buffer.append(" and isnull(B_GI_isCustomize,'0')=? ");
			params.add(Utility.getName(salesDetailPo.getSsesdiscustomize()));
		}
		buffer.append(" group by S_SE_SD_SalesItemID,S_SE_SD_ItemID,S_SE_SD_StockId,B_GI_BarCodeFlag ");
				
		return queryForObjectList(buffer.toString(), params.toArray(),SalesDetailPo.class);
	}
	
	/**
	 * 新增业务单据往来明细
	 */
	public void insertSupplierDealingEntry(InventoryPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO L_SC_SupplierAccount(L_SC_SA_ID,L_SC_SA_BillID,L_SC_SA_BillType,L_SC_SA_Date,L_SC_SA_SupplierID ");
		buffer.append("           ,L_SC_SA_SupplierShortName,L_SC_SA_SupplierName,L_SC_SA_NotTaxRateAmount,L_SC_SA_CostPriceAmount,L_SC_SA_DeliveryID,L_SC_SA_SubSupplierID) ");
		
		buffer.append("select newid(),C_ST_IE_BillID,(case C_ST_I_BillTypeId when '2' then '采购退货单' when '9' then '委外收货单' else '采购收货单' end), ");
		buffer.append("       C_ST_I_FinanceAuditDate,C_ST_I_SupplierId, ");
		buffer.append("       B_SP_SupplierName,B_SP_ForShort,(case C_ST_I_BillTypeId when '2' then -sum(C_ST_IE_NotTaxRateAmount) else sum(C_ST_IE_NotTaxRateAmount) end) ,(case C_ST_I_BillTypeId when '2' then -sum(C_ST_IE_CostPriceAmount) else sum(C_ST_IE_CostPriceAmount) end),isnull(C_ST_I_DeliveryID,'') ");
		buffer.append("       ,isnull(C_ST_I_SubSupplierId,'') ");
		
		buffer.append("  from C_ST_InventoryEntry inner join C_ST_Inventory on C_ST_IE_BillID=C_ST_I_BillID ");
		buffer.append("       left join B_Supplier on C_ST_I_SupplierId=B_SP_ID ");
		buffer.append("  where C_ST_IE_BillID=? and C_ST_I_AuditState='1' and C_ST_I_FinanceAuditState='1' and C_ST_I_BillTypeId in ('1','2','9') ");
		buffer.append("  group by C_ST_IE_BillID,C_ST_I_BillTypeId,C_ST_I_FinanceAuditDate,C_ST_I_SupplierId,B_SP_SupplierName,B_SP_ForShort,isnull(C_ST_I_DeliveryID,''),isnull(C_ST_I_SubSupplierId,'') ");
	
		params.add(Utility.getName(po.getCstibillid()));
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}
	
	/**
	 * 删除往来明细
	 */
	public void deleteSupplierDealingEntry(PayMentBillPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete top (1) from L_SC_SupplierAccount where L_SC_SA_BillID in ( ? ");
				
		String[] bills = Utility.getName(po.getsLpbpbID()).split(",");
		params.add(Utility.getName(bills[0]));
		
		for (int i = 1; i < bills.length; i++){
			buffer.append(" ,? ");
			params.add(Utility.getName(bills[i]));
		}
		buffer.append(" ) ");
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}
	
	/**
	 * 新增付款单往来明细
	 */
	public void insertSupplierDealingEntry(PayMentBillPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		String[] bills = Utility.getName(po.getsLpbpbID()).split(",");
		
		buffer.append("INSERT INTO L_SC_SupplierAccount(L_SC_SA_ID,L_SC_SA_BillID,L_SC_SA_BillType,L_SC_SA_Date,L_SC_SA_SupplierID ");
		buffer.append("           ,L_SC_SA_SupplierShortName,L_SC_SA_SupplierName,L_SC_SA_PayMentAmount,L_SC_SA_PrePayAmount,L_SC_SA_SupplierSubAmount,L_SC_SA_ManualAmount,L_SC_SA_SubSupplierID) ");
		
		buffer.append("select newid(),L_PB_PB_ID,'付款单',L_PB_PB_AuditDate,");
		buffer.append("       L_PB_PB_SupplierID,B_SP_SupplierName,B_SP_ForShort,-L_PB_PB_CurrentPayedMentAmount,0,0,0,L_PB_PB_SubSupplierID ");
		buffer.append("  from L_PB_PB_PaymentBill left join B_SupplierAgent on L_PB_PB_SubSupplierID=B_SP_ID ");
		buffer.append("  where L_PB_PB_AuditStatue='1' and L_PB_PB_PaymentType in ('1','2') and L_PB_PB_ID in ( ? ");		

		params.add(Utility.getName(bills[0]));
		
		for (int i = 1; i < bills.length; i++){
			buffer.append(" ,? ");
			params.add(Utility.getName(bills[i]));
		}
		buffer.append(" ) union all ");
		
		buffer.append("select newid(),L_PB_PB_ID,'预付款',L_PB_PB_AuditDate,");
		buffer.append("       L_PB_PB_SupplierID,B_SP_SupplierName,B_SP_ForShort,0,-L_PB_PB_PayedMentAmount,0,0,L_PB_PB_SubSupplierID ");
		buffer.append("  from L_PB_PB_PaymentBill left join B_SupplierAgent on L_PB_PB_SubSupplierID=B_SP_ID ");
		buffer.append("  where L_PB_PB_AuditStatue='1' and L_PB_PB_PaymentType='3' and L_PB_PB_ID in ( ? ");		

		params.add(Utility.getName(bills[0]));
		
		for (int i = 1; i < bills.length; i++){
			buffer.append(" ,? ");
			params.add(Utility.getName(bills[i]));
		}
		buffer.append(" ) union all ");
		
		buffer.append("select newid(),L_PB_PB_ID,'厂商减账',L_PB_PB_AuditDate,");
		buffer.append("       L_PB_PB_SupplierID,B_SP_SupplierName,B_SP_ForShort,0,0,-L_PB_PB_PayedMentAmount,0,L_PB_PB_SubSupplierID ");
		buffer.append("  from L_PB_PB_PaymentBill left join B_SupplierAgent on L_PB_PB_SubSupplierID=B_SP_ID ");
		buffer.append("  where L_PB_PB_AuditStatue='1' and L_PB_PB_PaymentType='6' and L_PB_PB_ID in ( ? ");		

		params.add(Utility.getName(bills[0]));
		
		for (int i = 1; i < bills.length; i++){
			buffer.append(" ,? ");
			params.add(Utility.getName(bills[i]));
		}
		buffer.append(" ) union all ");
		
		buffer.append("select newid(),L_PB_PB_ID,'调账',L_PB_PB_AuditDate,");
		buffer.append("       L_PB_PB_SupplierID,B_SP_SupplierName,B_SP_ForShort,0,0,0,-L_PB_PB_PayedMentAmount,L_PB_PB_SubSupplierID ");
		buffer.append("  from L_PB_PB_PaymentBill left join B_SupplierAgent on L_PB_PB_SubSupplierID=B_SP_ID ");
		buffer.append("  where L_PB_PB_AuditStatue='1' and L_PB_PB_PaymentType='7' and L_PB_PB_ID in ( ? ");		

		params.add(Utility.getName(bills[0]));
		
		for (int i = 1; i < bills.length; i++){
			buffer.append(" ,? ");
			params.add(Utility.getName(bills[i]));
		}
		buffer.append(" ) ");
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}
	
	/**
	 * 根据业务明细查询商品代码
	 */
	public GoodsInfoPo getGoodsInfoByInventoryEntry(InventoryEntryPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select top 1 isnull(B_GI_RetailPrice,0) as bgiretailprice from B_GoodsInfo where B_GI_GoodsID in (select top 1 C_ST_IE_GoodsId from C_ST_InventoryEntry where C_ST_IE_ID=? ) ");
	
		params.add(Utility.getName(epo.getCstieid()));
		
		return (GoodsInfoPo) queryForObject(buffer.toString(), params.toArray(), GoodsInfoPo.class);
	}
	
	/**
	 * 根据配镜单查询委外收货仓位
	 */
	public String getSalesGoodsInWarehouse(String billid){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 C_ST_CPRD_InStockId from C_ST_ConsignProcessReceiptDetails where C_ST_CPRD_OrderDetailsID in ( ");
		buffer.append(" select C_ST_CPOD_Id from C_ST_ConsignProcessOrderDetails where C_ST_CPOD_SalesID=?) ");
		
		params.add(billid);
		
		return (String) getJdbcTemplate().queryForObject(buffer.toString(),params.toArray(),String.class);
	}
	
	/**
	 * 更新库存表的结算成本
	 */
	public void updateStorageCostEntry(InventoryEntryPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update C_SH_StorageLog set C_SH_SL_NotTaxRate = ?,C_SH_SL_CostPrice = ? where C_SH_SL_ChangeID = ? and C_SH_SL_GoodsBarCode = ? ");
				
		params.add(Utility.getName(epo.getCstienottaxrate()));
		params.add(Utility.getName(epo.getCstiecostprice()));
		params.add(Utility.getName(epo.getCstiebillid()));
		params.add(Utility.getName(epo.getCstiebarcode()));

		
		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}
	
	/**
	 * 根据单据编号查询商品成本
	 */
	public List<InventoryEntryPo> getStorageCostEntryByBillID(InventoryPo po){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select C_ST_IE_BillID as cstiebillid,C_ST_IE_NotTaxRate as cstienottaxrate,C_ST_IE_CostPrice as cstiecostprice,C_ST_IE_BarCode as cstiebarcode from C_ST_InventoryEntry ");
		buffer.append("   where C_ST_IE_BillID = ? ");
		
		params.add(Utility.getName(po.getCstibillid()));
				
		return queryForObjectList(buffer.toString(), params.toArray(),InventoryEntryPo.class);
	}	
	
	public int getSalesBasicInfoByID(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(S_SE_SB_SalesID) from S_SE_SalesBasic where S_SE_SB_SalesID = ? ");

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	public int getSalesDetailInfoByID(SalesDetailPo sdpo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(S_SE_SD_SalesID) from S_SE_SalesDetail where S_SE_SD_SalesID = ? ");

		params.add(Utility.getName(sdpo.getSsesdsalesid()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	public SalesBasicPo getSalesBasicInfo(SalesBasicPo salesBasicPo) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 S_SE_SB_SalesID as ssesbsalesid , ");
		buffer.append("isnull(S_SE_TM_MaiilAudit,'') as isMail , ");
		buffer.append("S_SE_SB_ShopCode as ssesbshopcode ,S_SE_SB_Location as ssesblocation,(case isnull(S_SE_SB_ProcessDepartment,'') when '' then (select top 1 B_DP_RegID from B_Departments where B_DP_DepartmentID=S_SE_SB_ShopCode) else isnull(S_SE_SB_ProcessDepartment,'') end ) as ssesbprocessdepartment, ");
		buffer.append("b1.B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("b1.B_DP_Phone as ssesbsalestelphone , ");
		buffer.append("b2.B_DP_DepartmentName as ssesbtakeshopname , ");
		buffer.append("(case isnull(S_SE_SB_ProcessDepartment,'') when '' then (select top 1 B_DP_DepartmentName from B_Departments where B_DP_DepartmentID in (select regid from (select top 1 B_DP_RegID as regid from B_Departments where B_DP_DepartmentID=S_SE_SB_ShopCode)temp)) else b3.B_DP_DepartmentName end) as ssesbprocessdepartmentname , ");
		buffer.append("S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("S_SE_SB_RecipeType as ssesbrecipetype , ");
		buffer.append("S_ME_CI_Phone as ssesbphone , ");
		buffer.append("S_SE_SB_OrdersType as ssesborderstype , ");
		buffer.append("S_SE_SB_PosDatetime as ssesbsalesdatetime , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , ");
		buffer.append("S_SE_SB_PriceSum as ssesbpricesum , ");
		buffer.append("S_SE_SB_DiscountNum as ssesbdiscountnum , ");
		buffer.append("S_SE_SB_SalesValue as ssesbsalesvalue , ");
		buffer.append("S_SE_SB_Psalsvalue as ssesbpsalsvalue , S_SE_SB_Djsbm as djsbm,");
		buffer.append("isnull(S_SE_SB_StoredCard,0.00) as ssesbstoredcard , ");
		buffer.append("S_ME_CI_MemberId as ssesbMemberId, ");
		buffer.append("S_SE_SB_InTransit as ssesbintransit,S_SE_SB_PosID as ssesbposid, ");
		buffer.append("(select personName from SYS_PersonInfo where ID=S_SE_SB_SalerID) as ssesbsalerid, ");
		buffer.append("S_SE_SB_WithdrawDate as ssesbwithdrawdate,");
		buffer.append("S_SE_SB_ValueFlag as ssesbvalueflag, ");
		buffer.append("S_SE_SB_ArrearsValue as ssesbarrearsvalue, ");
		buffer.append("S_SE_SB_WithdrawFlag as ssesbwithdrawflag, ");
		buffer.append("S_SE_SB_CheckoutFlag as ssesbcheckoutflag,isnull(S_ME_CI_Integral,'0') as inintrgral, ");
		buffer.append("S_SE_SB_Renums as ssesbrenums,cast(S_SE_SB_Integral as numeric(20)) as ssesbintegral,S_ME_CI_CustomerID as ssesbcustomerid, ");
		buffer.append("S_SE_SB_SalesRemark as ssesbsalesremark,S_SE_SB_DignosisRe as ssesbdignosisre,b1.B_DP_Phone as ssesbsalestelphone,b2.B_DP_Phone as ssesbtaketelphone, ");
		
		buffer.append("(select isnull(sum(cast(isnull(S_ME_AS_CIntegral,0) as float)),0.00) from S_ME_IntegralAddandSub where S_ME_AS_SalesBillID = ?) as ssesbjfamount  ");
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		buffer.append(",S_SE_SB_DueIntegral as ssesbdueintegral ");
		buffer.append(",S_ME_CI_FCustomerId as ssesbfcustomerid ");		
		buffer.append(",S_SE_SB_Oldeyesize as ssesboldeyesize ");
		buffer.append(",S_SE_SB_Glasshige as ssesbglasshige ");
		buffer.append(",S_SE_SB_Glasswigth as ssesbglasswigth ");
		buffer.append(",S_SE_SB_Framemiddlesize as ssesbframemiddlesize ");
		buffer.append(",S_SE_SB_Galssroad as ssesbgalssroad ");
		buffer.append(",S_SE_SB_Diagonalline as ssesbdiagonalline ");
		buffer.append(",S_SE_SB_Frameform as ssesbframeform ");		
		buffer.append(",S_SE_SB_FactPosDatetime as ssesbfactposdatetime ");	
		buffer.append(",S_SE_SB_FactWithdrawDate as ssesbfactwithdrawdate ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("left join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("left join B_Departments b1 on b1.B_DP_DepartmentID = S_SE_SB_ShopCode ");
		buffer.append("left join B_Departments b2 on b2.B_DP_DepartmentID = S_SE_SB_Location ");
		buffer.append("left join B_Departments b3 on b3.B_DP_DepartmentID = S_SE_SB_ProcessDepartment ");
		buffer.append("left join  S_SE_ToMail ON S_SE_SB_SalesID = S_SE_ToMail.S_SE_TM_LinkSalesID ");
		buffer.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbcustomerid()))){
			buffer.append("and S_ME_CI_CustomerID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcustomerid()));
			
		}else if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
			
		}
	
		return (SalesBasicPo) queryForObject(buffer.toString(), params.toArray(), SalesBasicPo.class);
	}
	
	public SalesBasicPo getSalesBasicInfoFinished(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 S_SE_SB_SalesID as ssesbsalesid , ");
		buffer.append("isnull(S_SE_TM_MaiilAudit,'') as isMail , ");
		buffer.append("S_SE_SB_ShopCode as ssesbshopcode ,S_SE_SB_Location as ssesblocation,(case isnull(S_SE_SB_ProcessDepartment,'') when '' then (select top 1 B_DP_RegID from B_Departments where B_DP_DepartmentID=S_SE_SB_ShopCode) else isnull(S_SE_SB_ProcessDepartment,'') end ) as ssesbprocessdepartment, ");
		buffer.append("b1.B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("b1.B_DP_Phone as ssesbsalestelphone , ");
		buffer.append("b2.B_DP_DepartmentName as ssesbtakeshopname , ");
		buffer.append("(case isnull(S_SE_SB_ProcessDepartment,'') when '' then (select top 1 B_DP_DepartmentName from B_Departments where B_DP_DepartmentID in (select regid from (select top 1 B_DP_RegID as regid from B_Departments where B_DP_DepartmentID=S_SE_SB_ShopCode)temp)) else b3.B_DP_DepartmentName end) as ssesbprocessdepartmentname , ");
		buffer.append("S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("S_SE_SB_RecipeType as ssesbrecipetype , ");
		buffer.append("S_ME_CI_Phone as ssesbphone , ");
		buffer.append("S_SE_SB_OrdersType as ssesborderstype , ");
		buffer.append("S_SE_SB_PosDatetime as ssesbsalesdatetime , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , ");
		buffer.append("S_SE_SB_PriceSum as ssesbpricesum , ");
		buffer.append("S_SE_SB_DiscountNum as ssesbdiscountnum , ");
		buffer.append("S_SE_SB_SalesValue as ssesbsalesvalue , ");
		buffer.append("S_SE_SB_Psalsvalue as ssesbpsalsvalue , S_SE_SB_Djsbm as djsbm,");
		buffer.append("isnull(S_SE_SB_StoredCard,0.00) as ssesbstoredcard , ");
		buffer.append("S_ME_CI_MemberId as ssesbMemberId, ");
		buffer.append("S_SE_SB_InTransit as ssesbintransit,S_SE_SB_PosID as ssesbposid, ");
		buffer.append("(select personName from SYS_PersonInfo where ID=S_SE_SB_SalerID) as ssesbsalerid, ");
		buffer.append("S_SE_SB_WithdrawDate as ssesbwithdrawdate,");
		buffer.append("S_SE_SB_ValueFlag as ssesbvalueflag, ");
		buffer.append("S_SE_SB_ArrearsValue as ssesbarrearsvalue, ");
		buffer.append("S_SE_SB_WithdrawFlag as ssesbwithdrawflag, ");
		buffer.append("S_SE_SB_CheckoutFlag as ssesbcheckoutflag,isnull(S_ME_CI_Integral,'0') as inintrgral, ");
		buffer.append("S_SE_SB_Renums as ssesbrenums,cast(S_SE_SB_Integral as numeric(20)) as ssesbintegral,S_ME_CI_CustomerID as ssesbcustomerid, ");
		buffer.append("S_SE_SB_SalesRemark as ssesbsalesremark,S_SE_SB_DignosisRe as ssesbdignosisre,b1.B_DP_Phone as ssesbsalestelphone,b2.B_DP_Phone as ssesbtaketelphone, ");
		
		buffer.append("(select isnull(sum(cast(isnull(S_ME_AS_CIntegral,0) as float)),0.00) from S_ME_IntegralAddandSub where S_ME_AS_SalesBillID = ?) as ssesbjfamount  ");
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		buffer.append(",S_SE_SB_DueIntegral as ssesbdueintegral ");
		buffer.append(",S_ME_CI_FCustomerId as ssesbfcustomerid ");
		buffer.append(",S_SE_SB_Oldeyesize as ssesboldeyesize ");
		buffer.append(",S_SE_SB_Glasshige as ssesbglasshige ");
		buffer.append(",S_SE_SB_Glasswigth as ssesbglasswigth ");
		buffer.append(",S_SE_SB_Framemiddlesize as ssesbframemiddlesize ");
		buffer.append(",S_SE_SB_Galssroad as ssesbgalssroad ");
		buffer.append(",S_SE_SB_Diagonalline as ssesbdiagonalline ");
		buffer.append(",S_SE_SB_Frameform as ssesbframeform ");			
		buffer.append(",S_SE_SB_FactPosDatetime as ssesbfactposdatetime ");	
		buffer.append(",S_SE_SB_FactWithdrawDate as ssesbfactwithdrawdate ");			
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("left join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("left join B_Departments b1 on b1.B_DP_DepartmentID = S_SE_SB_ShopCode ");
		buffer.append("left join B_Departments b2 on b2.B_DP_DepartmentID = S_SE_SB_Location ");
		buffer.append("left join B_Departments b3 on b3.B_DP_DepartmentID = S_SE_SB_ProcessDepartment ");
		buffer.append("left join  S_SE_ToMail ON S_SE_SB_SalesID = S_SE_ToMail.S_SE_TM_LinkSalesID ");
		buffer.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbcustomerid()))){
			buffer.append("and S_ME_CI_CustomerID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcustomerid()));
			
		}else if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
			
		}
	 
		return (SalesBasicPo) queryForObject(buffer.toString(), params.toArray(), SalesBasicPo.class);
	}
	
	/**
	 * 只有待结款的单子才能调用
	 */
	public List<SalesDetailPo> getGoodsInfoNoFinished(SalesDetailPo salesDetailPo){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select S_SE_SD_SalesItemID as ssesdsalesitemid , ");
		buffer.append("S_SE_SD_SalesItemName as ssesdsalesitemname , ");
		buffer.append("S_SE_SD_SPrice as ssesdsprice , ");
		buffer.append("S_SE_SD_Number as ssesdnumber , ");
		buffer.append("S_SE_SD_PriceSum as ssesdpricesum , ");
		buffer.append("S_SE_SD_DiscountRate as ssesddiscountrate , ");
		buffer.append("S_SE_SD_DiscountNum as ssesddiscountnum , ");
		buffer.append("S_SE_SD_Renums as ssesdrenum, ");
		buffer.append("S_SE_SD_SalesValue as ssesdsalesvalue , ");
		buffer.append("S_SE_SD_Integral as ssesintegral ");	
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("left join S_SE_SalesDetail on S_SE_SalesBasic.S_SE_SB_SalesID = S_SE_SalesDetail.S_SE_SD_SalesID ");
		buffer.append("where S_SE_SB_SalesID = ? and isnull(S_SE_SD_OutStorageFlag,'')<> '1'");

		params.add(salesDetailPo.getSsesdsalesid());
		
		return queryForObjectList(buffer.toString(), params.toArray(),SalesDetailPo.class);	
	}
	
	public List<SalesDetailPo> getGoodsInfoNoFinished2(SalesDetailPo salesDetailPo){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select ");
		buffer.append("S_SE_SD_SalesItemID as ssesdsalesitemid,S_SE_SD_GlassFlag as ssesdglassflag, ");
		buffer.append("S_SE_SD_CommoditiesFlag as ssesdcommoditiesflag , ");	
		buffer.append("B_GI_SupplierID as ssesdsupplierid, ");	
		buffer.append("isnull(B_GI_AccessoriesType,'') as ssesdaccessoriestype, ");	
		buffer.append("S_SE_SD_Number as ssesdnumber , ");
		buffer.append("S_SE_SD_SalesValue as ssesdsalesvalue , ");
		buffer.append("isnull(B_GI_isCustomize,'') as ssesdiscustomize, ");			
		buffer.append("isnull(S_SE_SD_ItemID,'') as ssesditemid , ");		
		buffer.append("S_SE_SD_StockId as  ssesdstockid,S_SE_SD_SalesID as ssesdsalesid, ");
		buffer.append("S_SE_SD_UnitPrice as ssesdunitprice,S_SE_SD_CostsPrive as ssesdcostsprive,S_SE_SD_Guaranteeperiod as ssesdguaranteeperiod,S_SE_SD_Batch as ssesdbatch ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join S_SE_SalesDetail on S_SE_SB_SalesID = S_SE_SD_SalesID ");
		buffer.append("inner join B_GoodsInfo on B_GI_GoodsID = S_SE_SD_SalesItemID ");
		buffer.append("where S_SE_SB_SalesID = ? and isnull(S_SE_SD_OutStorageFlag,'') <> '1'");

		params.add(Utility.getName(salesDetailPo.getSsesdsalesid()));
	
		return queryForObjectList(buffer.toString(), params.toArray(),SalesDetailPo.class);	
	}

	/**
	 * 不包含赠品的销售明细
	 * @param salesDetailPo
	 * @return
	 */
	public List<SalesDetailPo> getGoodsInfoNoFinished2NoZengPin(SalesDetailPo salesDetailPo){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select ");
		buffer.append("S_SE_SD_SalesItemID as ssesdsalesitemid,S_SE_SD_GlassFlag as ssesdglassflag, ");
		buffer.append("S_SE_SD_CommoditiesFlag as ssesdcommoditiesflag , ");	
		buffer.append("B_GI_SupplierID as ssesdsupplierid, ");	
		buffer.append("isnull(B_GI_AccessoriesType,'') as ssesdaccessoriestype, ");	
		buffer.append("S_SE_SD_Number as ssesdnumber , ");
		buffer.append("S_SE_SD_SalesValue as ssesdsalesvalue , ");
		buffer.append("isnull(B_GI_isCustomize,'') as ssesdiscustomize, ");			
		buffer.append("isnull(S_SE_SD_ItemID,'') as ssesditemid , ");		
		buffer.append("S_SE_SD_StockId as  ssesdstockid,S_SE_SD_SalesID as ssesdsalesid, ");
		buffer.append("S_SE_SD_UnitPrice as ssesdunitprice,S_SE_SD_CostsPrive as ssesdcostsprive,S_SE_SD_Guaranteeperiod as ssesdguaranteeperiod,S_SE_SD_Batch as ssesdbatch ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join S_SE_SalesDetail on S_SE_SB_SalesID = S_SE_SD_SalesID ");
		buffer.append("inner join B_GoodsInfo on B_GI_GoodsID = S_SE_SD_SalesItemID ");
		buffer.append("where S_SE_SB_SalesID = ? and S_SE_SD_LargessFlag = '0' ");
		buffer.append(" union all ");
		buffer.append("select ");
		buffer.append("S_SE_SD_SalesItemID as ssesdsalesitemid,S_SE_SD_GlassFlag as ssesdglassflag, ");
		buffer.append("S_SE_SD_CommoditiesFlag as ssesdcommoditiesflag , ");	
		buffer.append("B_GI_SupplierID as ssesdsupplierid, ");	
		buffer.append("isnull(B_GI_AccessoriesType,'') as ssesdaccessoriestype, ");	
		buffer.append("S_SE_SD_Number as ssesdnumber , ");
		buffer.append("S_SE_SD_SalesValue as ssesdsalesvalue , ");
		buffer.append("isnull(B_GI_isCustomize,'') as ssesdiscustomize, ");			
		buffer.append("isnull(S_SE_SD_ItemID,'') as ssesditemid , ");		
		buffer.append("S_SE_SD_StockId as  ssesdstockid,S_SE_SD_SalesID as ssesdsalesid, ");
		buffer.append("S_SE_SD_UnitPrice as ssesdunitprice,S_SE_SD_CostsPrive as ssesdcostsprive,S_SE_SD_Guaranteeperiod as ssesdguaranteeperiod,S_SE_SD_Batch as ssesdbatch ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join S_SE_SalesDetail on S_SE_SB_SalesID = S_SE_SD_SalesID ");
		buffer.append("inner join B_GoodsInfo on B_GI_GoodsID = S_SE_SD_SalesItemID ");
		buffer.append("inner join B_Gifts on S_SE_SD_SalesItemID = B_GS_GoodsID ");		
		buffer.append("where S_SE_SB_SalesID = ? and S_SE_SD_LargessFlag = '1' and isnull(B_GS_Type,'') <> '2' ");

		params.add(Utility.getName(salesDetailPo.getSsesdsalesid()));
		params.add(Utility.getName(salesDetailPo.getSsesdsalesid()));
	
		return queryForObjectList(buffer.toString(), params.toArray(),SalesDetailPo.class);	
	}
	
	public SalesBasicPo getCustomerInfo2(String customerID) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 isnull(S_ME_CI_Integral,'0') as inintrgral ");
		buffer.append(",S_ME_CI_MemberId as ssesbMemberId ");
		buffer.append(",S_ME_CI_CustomerID as ssesbcustomerid ");
		buffer.append(",isnull(S_ME_CI_ConsumptionNumber,'0') as ssesbsalescount ");
		buffer.append("from S_ME_CustomerInfo ");
		buffer.append("where S_ME_CI_CustomerID = ? ");
		
		params.add(Utility.getName(customerID));
	
		return (SalesBasicPo) queryForObject(buffer.toString(), params.toArray(), SalesBasicPo.class);
	}
	
	public SalesBasicPo getCustomerInfo3(String customerID) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 isnull(S_ME_CI_Integral,'0') as inintrgral ");
		buffer.append(",S_ME_CI_MemberId as ssesbMemberId ");
		buffer.append(",S_ME_CI_CustomerID as ssesbcustomerid ");
		buffer.append("from S_ME_CustomerInfo ");
		buffer.append("where S_ME_CI_FCustomerId = ? ");
		
		params.add(Utility.getName(customerID));
	
		return (SalesBasicPo) queryForObject(buffer.toString(), params.toArray(), SalesBasicPo.class);
	}
	
	
	/**
	 * 获取取镜门店列表
	 */
	public List<SalesBasicPo> getLocationShopCodeList(String[] salesBillArray){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select S_SE_SB_SalesID as ssesbsalesid,S_SE_SB_Location as ssesblocation from S_SE_SalesBasic ");		
		buffer.append("where S_SE_SB_SalesID in ( ");
		
		int count = salesBillArray.length;
		for (int i = 0; i < count; i++){
			buffer.append(" ? , ");
			params.add(Utility.getName(salesBillArray[i]));
		}
		
		buffer.append(" '' ) order by S_SE_SB_Location ");
	
		return queryForObjectList(buffer.toString(), params.toArray(),SalesBasicPo.class);	
	}
	
	/**
	 * 根据配镜单号获取配送人员姓名
	 */
	public String getPsNameInfo(String salesid,String psType){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 isnull(personName,'') as psname  ");
		buffer.append("  from S_DN_Distribution inner join S_DN_DistributionEntry on S_DN_DN_ID = S_DN_DE_DistributionID ");
		buffer.append("       left join SYS_PersonInfo on S_DN_DN_Person = id ");
		buffer.append("  where S_DN_DE_SalesID = ? and S_DN_DN_Type = ? ");
		
		params.add(Utility.getName(salesid));
		params.add(Utility.getName(psType));
		
		return (String) getJdbcTemplate().queryForObject(buffer.toString(),params.toArray(),String.class);		
	}
	
	/**
	 * 根据配镜单号获取配送人员姓名数量
	 */
	public int getPsNameInfoCount(String salesid,String psType){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(personName)  ");
		buffer.append("  from S_DN_Distribution inner join S_DN_DistributionEntry on S_DN_DN_ID = S_DN_DE_DistributionID ");
		buffer.append("       left join SYS_PersonInfo on S_DN_DN_Person = id ");
		buffer.append("  where S_DN_DE_SalesID = ? and S_DN_DN_Type = ? ");
		
		params.add(Utility.getName(salesid));
		params.add(Utility.getName(psType));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
}
