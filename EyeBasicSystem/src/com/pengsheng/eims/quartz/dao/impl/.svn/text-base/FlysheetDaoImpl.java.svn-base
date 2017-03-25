package com.pengsheng.eims.quartz.dao.impl;

import com.pengsheng.eims.quartz.dao.FlysheetDao;
import com.pengsheng.eims.system.persistence.ExternalAccountParameterPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class FlysheetDaoImpl extends BaseJdbcDaoSupport implements FlysheetDao {
	
	/**
	 * 配镜单
	 */
	public void updateSalesBill(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select S_SE_SB_SalesID into #temp from S_SE_SalesBasic ");
		
		buffer.append("INSERT INTO S_SE_SalesBasic ");
		buffer.append("           (S_SE_SB_SalesID ");
		buffer.append("           ,S_SE_SB_ShopCode ");
		buffer.append("           ,S_SE_SB_CustomerID ");
		buffer.append("           ,S_SE_SB_OptID ");
		buffer.append("           ,S_SE_SB_OptometryID ");
		buffer.append("           ,S_SE_SB_InspectionID ");
		buffer.append("           ,S_SE_SB_TakeGlassData ");
		buffer.append("           ,S_SE_SB_SalesDatetime ");
		buffer.append("           ,S_SE_SB_OrdersType ");
		buffer.append("           ,S_SE_SB_BallGlassOD ");
		buffer.append("           ,S_SE_SB_BallGlassOS ");
		buffer.append("           ,S_SE_SB_PostGlassOD ");
		buffer.append("           ,S_SE_SB_PostGlassOS ");
		buffer.append("           ,S_SE_SB_AxesOD ");
		buffer.append("           ,S_SE_SB_AxesOS ");
		buffer.append("           ,S_SE_SB_ADDOD ");
		buffer.append("           ,S_SE_SB_ADDOS ");
		buffer.append("           ,S_SE_SB_ArriseGlassOD1 ");
		buffer.append("           ,S_SE_SB_ArriseGlassOS1 ");
		buffer.append("           ,S_SE_SB_BasisOD1 ");
		buffer.append("           ,S_SE_SB_BasisOS1 ");
		buffer.append("           ,S_SE_SB_PrismOD ");
		buffer.append("           ,S_SE_SB_PrismOS ");
		buffer.append("           ,S_SE_SB_InterHighOD ");
		buffer.append("           ,S_SE_SB_InterHighOS ");
		buffer.append("           ,S_SE_SB_InterDistanceOD ");
		buffer.append("           ,S_SE_SB_InterDistanceOS ");
		buffer.append("           ,S_SE_SB_FarVAOD ");
		buffer.append("           ,S_SE_SB_FarVAOS ");
		buffer.append("           ,S_SE_SB_CloseVAOD ");
		buffer.append("           ,S_SE_SB_CloseVAOS ");
		buffer.append("           ,S_SE_SB_RecipeType ");
		buffer.append("           ,S_SE_SB_DignosisRe ");
		buffer.append("           ,S_SE_SB_DiameterOD ");
		buffer.append("           ,S_SE_SB_DiameterOS ");
		buffer.append("           ,S_SE_SB_ConRecipeType ");
		buffer.append("           ,S_SE_SB_SecCheckDate ");
		buffer.append("           ,S_SE_SB_SubVisitUnit ");
		buffer.append("           ,S_SE_SB_SalesType ");
		buffer.append("           ,S_SE_SB_SalerID ");
		buffer.append("           ,S_SE_SB_Lryid ");
		buffer.append("           ,S_SE_SB_PosDatetime ");
		buffer.append("           ,S_SE_SB_PosID ");
		buffer.append("           ,S_SE_SB_PriceSum ");
		buffer.append("           ,S_SE_SB_SalesValue ");
		buffer.append("           ,S_SE_SB_EyeCurvatureOD1 ");
		buffer.append("           ,S_SE_SB_EyeCurvatureOD2 ");
		buffer.append("           ,S_SE_SB_EyeCurvatureOS1 ");
		buffer.append("           ,S_SE_SB_EyeCurvatureOS2 ");
		buffer.append("           ,S_SE_SB_DiscountRate ");
		buffer.append("           ,S_SE_SB_DiscountNum ");
		buffer.append("           ,S_SE_SB_Psalsvalue ");
		buffer.append("           ,S_SE_SB_ArrearsValue ");
		buffer.append("           ,S_SE_SB_Location ");
		buffer.append("           ,S_SE_SB_ArrivedDate ");
		buffer.append("           ,S_SE_SB_ValueFlag ");
		buffer.append("           ,S_SE_SB_CheckoutFlag ");
		buffer.append("           ,S_SE_SB_InTransit ");
		buffer.append("           ,S_SE_SB_WithdrawDate ");
		buffer.append("           ,S_SE_SB_WithdrawFlag ");
		buffer.append("           ,S_SE_SB_WithdrawPersonID ");
		buffer.append("           ,S_SE_SB_MovementType ");
		buffer.append("           ,S_SE_SB_ArrearsAppendDate ");
		buffer.append("           ,S_SE_SB_ArrearsDate ");
		buffer.append("           ,S_SE_SB_PayCash ");
		buffer.append("           ,S_SE_SB_BankCard ");
		buffer.append("           ,S_SE_SB_StoredCard ");
		buffer.append("           ,S_SE_SB_Renums ");
		buffer.append("           ,S_SE_SB_DiscountType ");
		buffer.append("           ,S_SE_SB_DiscountPerson ");
		buffer.append("           ,S_SE_SB_DragsType ");
		buffer.append("           ,S_SE_SB_PupilHeightOD ");
		buffer.append("           ,S_SE_SB_PupilHeightOS ");
		buffer.append("           ,S_SE_SB_FavorableAmount ");
		buffer.append("           ,S_SE_SB_WorryType ");
		buffer.append("           ,S_SE_SB_Integral ");
		buffer.append("           ,S_SE_SB_SetMealID ");
		buffer.append("           ,S_SE_SB_ExecStandard ");
		buffer.append("           ,S_SE_SB_SalesRemark ");
		buffer.append("           ,S_SE_SB_IntegralPrice ");
		buffer.append("           ,S_SE_SB_SourceSalesID ");
		buffer.append("           ,S_SE_SB_SwapGoodsFlag ");
		buffer.append("           ,S_SE_SB_ProcessDepartment ");
		buffer.append("           ,S_SE_SB_PrintSMFlag ");
		buffer.append("           ,S_SE_SB_Diagonalline ");
		buffer.append("           ,S_SE_SB_Frameform ");
		buffer.append("           ,S_SE_SB_Framemiddlesize ");
		buffer.append("           ,S_SE_SB_Galssroad ");
		buffer.append("           ,S_SE_SB_Glasshige ");
		buffer.append("           ,S_SE_SB_Glasswigth ");
		buffer.append("           ,S_SE_SB_Oldeyesize ");
		buffer.append("           ,S_SE_SB_DueIntegral ");
		buffer.append("           ,S_SE_SB_SetMealName ");
		buffer.append("           ,S_SE_SB_AdditionalName ");
		buffer.append("           ,S_SE_SB_Additional ");
		buffer.append("           ,S_SE_SB_SetMealFlag ");
		buffer.append("           ,S_SE_SB_PrintFldID ");
		buffer.append("           ,S_SE_SB_JFAmount) ");
		buffer.append(" SELECT S_SE_SB_SalesID ");		
		buffer.append("      ,S_SE_SB_ShopCode ");
		buffer.append("      ,S_SE_SB_CustomerID ");
		buffer.append("      ,S_SE_SB_OptID ");
		buffer.append("      ,S_SE_SB_OptometryID ");
		buffer.append("      ,S_SE_SB_InspectionID ");
		buffer.append("      ,S_SE_SB_TakeGlassData ");
		buffer.append("      ,S_SE_SB_SalesDatetime ");
		buffer.append("      ,S_SE_SB_OrdersType ");
		buffer.append("      ,S_SE_SB_BallGlassOD ");
		buffer.append("      ,S_SE_SB_BallGlassOS ");
		buffer.append("      ,S_SE_SB_PostGlassOD ");
		buffer.append("      ,S_SE_SB_PostGlassOS ");
		buffer.append("      ,S_SE_SB_AxesOD ");
		buffer.append("      ,S_SE_SB_AxesOS ");
		buffer.append("      ,S_SE_SB_ADDOD ");
		buffer.append("      ,S_SE_SB_ADDOS ");
		buffer.append("      ,S_SE_SB_ArriseGlassOD1 ");
		buffer.append("      ,S_SE_SB_ArriseGlassOS1 ");
		buffer.append("      ,S_SE_SB_BasisOD1 ");
		buffer.append("      ,S_SE_SB_BasisOS1 ");
		buffer.append("      ,S_SE_SB_PrismOD ");
		buffer.append("      ,S_SE_SB_PrismOS ");
		buffer.append("      ,S_SE_SB_InterHighOD ");
		buffer.append("      ,S_SE_SB_InterHighOS ");
		buffer.append("      ,S_SE_SB_InterDistanceOD ");
		buffer.append("      ,S_SE_SB_InterDistanceOS ");
		buffer.append("      ,S_SE_SB_FarVAOD ");
		buffer.append("      ,S_SE_SB_FarVAOS ");
		buffer.append("      ,S_SE_SB_CloseVAOD ");
		buffer.append("      ,S_SE_SB_CloseVAOS ");
		buffer.append("      ,S_SE_SB_RecipeType ");
		buffer.append("      ,S_SE_SB_DignosisRe ");
		buffer.append("      ,S_SE_SB_DiameterOD ");
		buffer.append("      ,S_SE_SB_DiameterOS ");
		buffer.append("      ,S_SE_SB_ConRecipeType ");
		buffer.append("      ,S_SE_SB_SecCheckDate ");
		buffer.append("      ,S_SE_SB_SubVisitUnit ");
		buffer.append("      ,S_SE_SB_SalesType ");
		buffer.append("      ,S_SE_SB_SalerID ");
		buffer.append("      ,S_SE_SB_Lryid ");
		buffer.append("      ,S_SE_SB_PosDatetime ");
		buffer.append("      ,S_SE_SB_PosID ");
		buffer.append("      ,S_SE_SB_PriceSum ");
		buffer.append("      ,S_SE_SB_SalesValue ");
		buffer.append("      ,S_SE_SB_EyeCurvatureOD1 ");
		buffer.append("      ,S_SE_SB_EyeCurvatureOD2 ");
		buffer.append("      ,S_SE_SB_EyeCurvatureOS1 ");
		buffer.append("      ,S_SE_SB_EyeCurvatureOS2 ");
		buffer.append("      ,S_SE_SB_DiscountRate ");
		buffer.append("      ,S_SE_SB_DiscountNum ");
		buffer.append("      ,S_SE_SB_Psalsvalue ");
		buffer.append("      ,S_SE_SB_ArrearsValue ");
		buffer.append("      ,S_SE_SB_Location ");
		buffer.append("      ,S_SE_SB_ArrivedDate ");
		buffer.append("      ,S_SE_SB_ValueFlag ");
		buffer.append("      ,S_SE_SB_CheckoutFlag ");
		buffer.append("      ,S_SE_SB_InTransit ");
		buffer.append("      ,S_SE_SB_WithdrawDate ");
		buffer.append("      ,S_SE_SB_WithdrawFlag ");
		buffer.append("      ,S_SE_SB_WithdrawPersonID ");
		buffer.append("      ,S_SE_SB_MovementType ");
		buffer.append("      ,S_SE_SB_ArrearsAppendDate ");
		buffer.append("      ,S_SE_SB_ArrearsDate ");
		buffer.append("      ,S_SE_SB_PayCash ");
		buffer.append("      ,S_SE_SB_BankCard ");
		buffer.append("      ,S_SE_SB_StoredCard ");
		buffer.append("      ,S_SE_SB_Renums ");
		buffer.append("      ,S_SE_SB_DiscountType ");
		buffer.append("      ,S_SE_SB_DiscountPerson ");
		buffer.append("      ,S_SE_SB_DragsType ");
		buffer.append("      ,S_SE_SB_PupilHeightOD ");
		buffer.append("      ,S_SE_SB_PupilHeightOS ");
		buffer.append("      ,S_SE_SB_FavorableAmount ");
		buffer.append("      ,S_SE_SB_WorryType ");
		buffer.append("      ,S_SE_SB_Integral ");
		buffer.append("      ,S_SE_SB_SetMealID ");
		buffer.append("      ,S_SE_SB_ExecStandard ");
		buffer.append("      ,S_SE_SB_SalesRemark ");
		buffer.append("      ,S_SE_SB_IntegralPrice ");
		buffer.append("      ,S_SE_SB_SourceSalesID ");
		buffer.append("      ,S_SE_SB_SwapGoodsFlag ");
		buffer.append("      ,S_SE_SB_ProcessDepartment ");
		buffer.append("      ,S_SE_SB_PrintSMFlag ");
		buffer.append("      ,S_SE_SB_Diagonalline ");
		buffer.append("      ,S_SE_SB_Frameform ");
		buffer.append("      ,S_SE_SB_Framemiddlesize ");
		buffer.append("      ,S_SE_SB_Galssroad ");
		buffer.append("      ,S_SE_SB_Glasshige ");
		buffer.append("      ,S_SE_SB_Glasswigth ");
		buffer.append("      ,S_SE_SB_Oldeyesize ");
		buffer.append("      ,S_SE_SB_DueIntegral ");
		buffer.append("      ,S_SE_SB_SetMealName ");
		buffer.append("      ,S_SE_SB_AdditionalName ");
		buffer.append("      ,S_SE_SB_Additional ");
		buffer.append("      ,S_SE_SB_SetMealFlag ");
		buffer.append("      ,S_SE_SB_PrintFldID ");
		buffer.append("      ,S_SE_SB_JFAmount ");
		buffer.append("  FROM S_SE_SalesBasic_FlySheet where S_SE_SB_SalesID not in (select S_SE_SB_SalesID from #temp) ");
		
		buffer.append("drop table #temp ");
		
		getJdbcTemplate().update(buffer.toString());	
	}
	
	/**
	 * 销售商品
	 */
	public void updateSalesGoods(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select S_SE_SD_ID into #temp from S_SE_SalesDetail ");
		
		buffer.append("INSERT INTO S_SE_SalesDetail ");
		buffer.append("           (S_SE_SD_ID ");
		buffer.append("           ,S_SE_SD_SalesID ");
		buffer.append("           ,S_SE_SD_SalesItemID ");
		buffer.append("           ,S_SE_SD_ItemID ");
		buffer.append("           ,S_SE_SD_StockId ");
		buffer.append("           ,S_SE_SD_SalesItemName ");
		buffer.append("           ,S_SE_SD_SPrice ");
		buffer.append("           ,S_SE_SD_Number ");
		buffer.append("           ,S_SE_SD_UnitPrice ");
		buffer.append("           ,S_SE_SD_CostsPrive ");
		buffer.append("           ,S_SE_SD_PriceSum ");
		buffer.append("           ,S_SE_SD_SalesValue ");
		buffer.append("           ,S_SE_SD_DiscountRate ");
		buffer.append("           ,S_SE_SD_DiscountNum ");
		buffer.append("           ,S_SE_SD_GoodDescribe ");
		buffer.append("           ,S_SE_SD_GlassFlag ");
		buffer.append("           ,S_SE_SD_CommoditiesFlag ");
		buffer.append("           ,S_SE_SD_Updatetime ");
		buffer.append("           ,S_SE_SD_LargessFlag ");
		buffer.append("           ,S_SE_SD_Renums ");
		buffer.append("           ,S_SE_SD_DiscountType ");
		buffer.append("           ,S_SE_SD_DiscountSource ");
		buffer.append("           ,S_SE_SD_InStockId ");
		buffer.append("           ,S_SE_SD_Favorable ");
		buffer.append("           ,S_SE_SD_Integral ");
		buffer.append("           ,S_SE_SD_OutStorageFlag ");
		buffer.append("           ,S_SE_SD_InStorageFlag ");
		buffer.append("           ,S_SE_SD_Guaranteeperiod ");
		buffer.append("           ,S_SE_SD_Batch ");
		buffer.append("           ,S_SE_SD_ExchageFlag ");
		buffer.append("           ,S_SE_SD_WithdrawFlag ");
		buffer.append("           ,S_SE_SD_WithdrawDate ");
		buffer.append("           ,S_SE_SD_WithdrawPersonID ");
		buffer.append("           ,S_SE_SD_Setmealid ");
		buffer.append("           ,S_SE_SD_Setmealidno ");
		buffer.append("           ,S_SE_SD_IsHaveStock ");
		buffer.append("           ,S_SE_SD_IsPurchaseCollect ");
		buffer.append("           ,S_SE_SD_IsReturnPurchaseCollect) ");
		buffer.append("SELECT S_SE_SD_ID ");
		buffer.append("      ,S_SE_SD_SalesID ");
		buffer.append("      ,S_SE_SD_SalesItemID ");
		buffer.append("      ,S_SE_SD_ItemID ");
		buffer.append("      ,S_SE_SD_StockId ");
		buffer.append("      ,S_SE_SD_SalesItemName ");
		buffer.append("      ,S_SE_SD_SPrice ");
		buffer.append("      ,S_SE_SD_Number ");
		buffer.append("      ,S_SE_SD_UnitPrice ");
		buffer.append("      ,S_SE_SD_CostsPrive ");
		buffer.append("      ,S_SE_SD_PriceSum ");
		buffer.append("      ,S_SE_SD_SalesValue ");
		buffer.append("      ,S_SE_SD_DiscountRate ");
		buffer.append("      ,S_SE_SD_DiscountNum ");
		buffer.append("      ,S_SE_SD_GoodDescribe ");
		buffer.append("      ,S_SE_SD_GlassFlag ");
		buffer.append("      ,S_SE_SD_CommoditiesFlag ");
		buffer.append("      ,S_SE_SD_Updatetime ");
		buffer.append("      ,S_SE_SD_LargessFlag ");
		buffer.append("      ,S_SE_SD_Renums ");
		buffer.append("      ,S_SE_SD_DiscountType ");
		buffer.append("      ,S_SE_SD_DiscountSource ");
		buffer.append("      ,S_SE_SD_InStockId ");
		buffer.append("      ,S_SE_SD_Favorable ");
		buffer.append("      ,S_SE_SD_Integral ");
		buffer.append("      ,S_SE_SD_OutStorageFlag ");
		buffer.append("      ,S_SE_SD_InStorageFlag ");
		buffer.append("      ,S_SE_SD_Guaranteeperiod ");
		buffer.append("      ,S_SE_SD_Batch ");
		buffer.append("      ,S_SE_SD_ExchageFlag ");
		buffer.append("      ,S_SE_SD_WithdrawFlag ");
		buffer.append("      ,S_SE_SD_WithdrawDate ");
		buffer.append("      ,S_SE_SD_WithdrawPersonID ");
		buffer.append("      ,S_SE_SD_Setmealid ");
		buffer.append("      ,S_SE_SD_Setmealidno ");
		buffer.append("      ,S_SE_SD_IsHaveStock ");
		buffer.append("      ,S_SE_SD_IsPurchaseCollect ");
		buffer.append("      ,S_SE_SD_IsReturnPurchaseCollect ");
		buffer.append("  FROM S_SE_SalesDetail_FlySheet where S_SE_SD_ID not in (select S_SE_SD_ID from #temp) ");
		
		buffer.append("drop table #temp ");
		
		getJdbcTemplate().update(buffer.toString());	
	}
	
	/**
	 * 附加费
	 */
	public void updateAdditionalCDetail(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select S_SE_ID into #temp from S_SE_AdditionalCDetail ");
		
		buffer.append("INSERT INTO S_SE_AdditionalCDetail ");
		buffer.append("           (S_SE_ID ");
		buffer.append("           ,S_SE_SalesID ");
		buffer.append("           ,S_SE_AdditionalID ");
		buffer.append("           ,S_SE_CostsName ");
		buffer.append("           ,S_SE_Amount ");
		buffer.append("           ,S_SE_Number) ");
		buffer.append("SELECT S_SE_ID ");
		buffer.append("      ,S_SE_SalesID ");
		buffer.append("      ,S_SE_AdditionalID ");
		buffer.append("      ,S_SE_CostsName ");
		buffer.append("      ,S_SE_Amount ");
		buffer.append("      ,S_SE_Number ");
		buffer.append("  FROM S_SE_AdditionalCDetail_FlySheet where S_SE_ID not in (select S_SE_ID from #temp) ");
		
		buffer.append("drop table #temp ");
		
		getJdbcTemplate().update(buffer.toString());	
	}
	
	/**
	 * 加工要求
	 */
	public void updateSpecialPDetail(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select S_SE_SD_ID into #temp from S_SE_SpecialPDetail ");
		
		buffer.append("INSERT INTO S_SE_SpecialPDetail ");
		buffer.append("           (S_SE_SD_ID ");
		buffer.append("           ,S_SE_SD_SalesID ");
		buffer.append("           ,S_SE_SD_Requirement) ");
		buffer.append("SELECT S_SE_SD_ID ");
		buffer.append("      ,S_SE_SD_SalesID ");
		buffer.append("      ,S_SE_SD_Requirement ");
		buffer.append("  FROM S_SE_SpecialPDetail_FlySheet where S_SE_SD_ID not in (select S_SE_SD_ID from #temp) ");
		
		buffer.append("drop table #temp ");
		
		getJdbcTemplate().update(buffer.toString());	
	}
	
	/**
	 * 在途	
	 */
	public void updateInTransit(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select S_SE_IT_ID into #temp from S_SE_InTransit ");
		
		buffer.append("INSERT INTO S_SE_InTransit ");
		buffer.append("           (S_SE_IT_ID ");
		buffer.append("           ,S_SE_IT_SalesID ");
		buffer.append("           ,S_SE_IT_State ");
		buffer.append("           ,S_SE_IT_Date ");
		buffer.append("           ,S_SE_IT_CreatePerson ");
		buffer.append("           ,S_SE_IT_Department ");
		buffer.append("           ,S_SE_IT_YsalesID) ");
		buffer.append("SELECT S_SE_IT_ID ");
		buffer.append("      ,S_SE_IT_SalesID ");
		buffer.append("      ,S_SE_IT_State ");
		buffer.append("      ,S_SE_IT_Date ");
		buffer.append("      ,S_SE_IT_CreatePerson ");
		buffer.append("      ,S_SE_IT_Department ");
		buffer.append("      ,S_SE_IT_YsalesID ");
		buffer.append("  FROM S_SE_InTransit_FlySheet where S_SE_IT_ID not in (select S_SE_IT_ID from #temp) ");
	
		buffer.append("drop table #temp ");
		
		getJdbcTemplate().update(buffer.toString());	
	}
	
	/**
	 * 付款记录
	 */
	public void updateSalesLog(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select S_SE_SL_UUID into #temp from S_SE_SalesLog ");
		
		buffer.append("INSERT INTO S_SE_SalesLog ");
		buffer.append("           (S_SE_SL_UUID ");
		buffer.append("           ,S_SE_SL_SalesID ");
		buffer.append("           ,S_SE_SL_PaymentType ");
		buffer.append("           ,S_SE_SL_ConsumptionID ");
		buffer.append("           ,S_SE_SL_Price ");
		buffer.append("           ,S_SE_SL_DateTime ");
		buffer.append("           ,S_SE_SL_Person ");
		buffer.append("           ,S_SE_SL_Orderby ");
		buffer.append("           ,S_SE_SL_SourceID ");
		buffer.append("           ,S_SE_SL_IntegralPrice ");
		buffer.append("           ,S_SE_SL_ShopCode ");
		buffer.append("           ,S_SE_SL_Type) ");
		buffer.append("SELECT S_SE_SL_UUID ");
		buffer.append("      ,S_SE_SL_SalesID ");
		buffer.append("      ,S_SE_SL_PaymentType ");
		buffer.append("      ,S_SE_SL_ConsumptionID ");
		buffer.append("      ,S_SE_SL_Price ");
		buffer.append("      ,S_SE_SL_DateTime ");
		buffer.append("      ,S_SE_SL_Person ");
		buffer.append("      ,S_SE_SL_Orderby ");
		buffer.append("      ,S_SE_SL_SourceID ");
		buffer.append("      ,S_SE_SL_IntegralPrice ");
		buffer.append("      ,S_SE_SL_ShopCode ");
		buffer.append("      ,S_SE_SL_Type ");
		buffer.append("  FROM S_SE_SalesLog_FlySheet where S_SE_SL_UUID not in (select S_SE_SL_UUID from #temp) ");
		
		buffer.append("drop table #temp ");
		
		getJdbcTemplate().update(buffer.toString());	
	}
	
	/**
	 * 当日配镜单
	 */
	public void updateSalesBillToday(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select S_SE_SB_SalesID into #temp from S_SE_SalesBasic_Today ");
		
		buffer.append("INSERT INTO S_SE_SalesBasic_Today ");
		buffer.append("           (S_SE_SB_SalesID ");
		buffer.append("           ,S_SE_SB_ShopCode ");
		buffer.append("           ,S_SE_SB_CustomerID ");
		buffer.append("           ,S_SE_SB_OptID ");
		buffer.append("           ,S_SE_SB_OptometryID ");
		buffer.append("           ,S_SE_SB_InspectionID ");
		buffer.append("           ,S_SE_SB_TakeGlassData ");
		buffer.append("           ,S_SE_SB_SalesDatetime ");
		buffer.append("           ,S_SE_SB_OrdersType ");
		buffer.append("           ,S_SE_SB_BallGlassOD ");
		buffer.append("           ,S_SE_SB_BallGlassOS ");
		buffer.append("           ,S_SE_SB_PostGlassOD ");
		buffer.append("           ,S_SE_SB_PostGlassOS ");
		buffer.append("           ,S_SE_SB_AxesOD ");
		buffer.append("           ,S_SE_SB_AxesOS ");
		buffer.append("           ,S_SE_SB_ADDOD ");
		buffer.append("           ,S_SE_SB_ADDOS ");
		buffer.append("           ,S_SE_SB_ArriseGlassOD1 ");
		buffer.append("           ,S_SE_SB_ArriseGlassOS1 ");
		buffer.append("           ,S_SE_SB_BasisOD1 ");
		buffer.append("           ,S_SE_SB_BasisOS1 ");
		buffer.append("           ,S_SE_SB_PrismOD ");
		buffer.append("           ,S_SE_SB_PrismOS ");
		buffer.append("           ,S_SE_SB_InterHighOD ");
		buffer.append("           ,S_SE_SB_InterHighOS ");
		buffer.append("           ,S_SE_SB_InterDistanceOD ");
		buffer.append("           ,S_SE_SB_InterDistanceOS ");
		buffer.append("           ,S_SE_SB_FarVAOD ");
		buffer.append("           ,S_SE_SB_FarVAOS ");
		buffer.append("           ,S_SE_SB_CloseVAOD ");
		buffer.append("           ,S_SE_SB_CloseVAOS ");
		buffer.append("           ,S_SE_SB_RecipeType ");
		buffer.append("           ,S_SE_SB_DignosisRe ");
		buffer.append("           ,S_SE_SB_DiameterOD ");
		buffer.append("           ,S_SE_SB_DiameterOS ");
		buffer.append("           ,S_SE_SB_ConRecipeType ");
		buffer.append("           ,S_SE_SB_SecCheckDate ");
		buffer.append("           ,S_SE_SB_SubVisitUnit ");
		buffer.append("           ,S_SE_SB_SalesType ");
		buffer.append("           ,S_SE_SB_SalerID ");
		buffer.append("           ,S_SE_SB_Lryid ");
		buffer.append("           ,S_SE_SB_PosDatetime ");
		buffer.append("           ,S_SE_SB_PosID ");
		buffer.append("           ,S_SE_SB_PriceSum ");
		buffer.append("           ,S_SE_SB_SalesValue ");
		buffer.append("           ,S_SE_SB_EyeCurvatureOD1 ");
		buffer.append("           ,S_SE_SB_EyeCurvatureOD2 ");
		buffer.append("           ,S_SE_SB_EyeCurvatureOS1 ");
		buffer.append("           ,S_SE_SB_EyeCurvatureOS2 ");
		buffer.append("           ,S_SE_SB_DiscountRate ");
		buffer.append("           ,S_SE_SB_DiscountNum ");
		buffer.append("           ,S_SE_SB_Psalsvalue ");
		buffer.append("           ,S_SE_SB_ArrearsValue ");
		buffer.append("           ,S_SE_SB_Location ");
		buffer.append("           ,S_SE_SB_ArrivedDate ");
		buffer.append("           ,S_SE_SB_ValueFlag ");
		buffer.append("           ,S_SE_SB_CheckoutFlag ");
		buffer.append("           ,S_SE_SB_InTransit ");
		buffer.append("           ,S_SE_SB_WithdrawDate ");
		buffer.append("           ,S_SE_SB_WithdrawFlag ");
		buffer.append("           ,S_SE_SB_WithdrawPersonID ");
		buffer.append("           ,S_SE_SB_MovementType ");
		buffer.append("           ,S_SE_SB_ArrearsAppendDate ");
		buffer.append("           ,S_SE_SB_ArrearsDate ");
		buffer.append("           ,S_SE_SB_PayCash ");
		buffer.append("           ,S_SE_SB_BankCard ");
		buffer.append("           ,S_SE_SB_StoredCard ");
		buffer.append("           ,S_SE_SB_Renums ");
		buffer.append("           ,S_SE_SB_DiscountType ");
		buffer.append("           ,S_SE_SB_DiscountPerson ");
		buffer.append("           ,S_SE_SB_DragsType ");
		buffer.append("           ,S_SE_SB_PupilHeightOD ");
		buffer.append("           ,S_SE_SB_PupilHeightOS ");
		buffer.append("           ,S_SE_SB_FavorableAmount ");
		buffer.append("           ,S_SE_SB_WorryType ");
		buffer.append("           ,S_SE_SB_Integral ");
		buffer.append("           ,S_SE_SB_SetMealID ");
		buffer.append("           ,S_SE_SB_IntegralPrice ");
		buffer.append("           ,S_SE_SB_SourceSalesID ");
		buffer.append("           ,S_SE_SB_SwapGoodsFlag ");
		buffer.append("           ,S_SE_SB_ExecStandard ");
		buffer.append("           ,S_SE_SB_SalesRemark ");
		buffer.append("           ,S_SE_SB_ProcessDepartment ");
		buffer.append("           ,S_SE_SB_PrintSMFlag) ");
		buffer.append("SELECT S_SE_SB_SalesID ");
		buffer.append("      ,S_SE_SB_ShopCode ");
		buffer.append("      ,S_SE_SB_CustomerID ");
		buffer.append("      ,S_SE_SB_OptID ");
		buffer.append("      ,S_SE_SB_OptometryID ");
		buffer.append("      ,S_SE_SB_InspectionID ");
		buffer.append("      ,S_SE_SB_TakeGlassData ");
		buffer.append("      ,S_SE_SB_SalesDatetime ");
		buffer.append("      ,S_SE_SB_OrdersType ");
		buffer.append("      ,S_SE_SB_BallGlassOD ");
		buffer.append("      ,S_SE_SB_BallGlassOS ");
		buffer.append("      ,S_SE_SB_PostGlassOD ");
		buffer.append("      ,S_SE_SB_PostGlassOS ");
		buffer.append("      ,S_SE_SB_AxesOD ");
		buffer.append("      ,S_SE_SB_AxesOS ");	
		buffer.append("      ,S_SE_SB_ADDOD ");
		buffer.append("      ,S_SE_SB_ADDOS ");
		buffer.append("      ,S_SE_SB_ArriseGlassOD1 ");
		buffer.append("      ,S_SE_SB_ArriseGlassOS1 ");
		buffer.append("      ,S_SE_SB_BasisOD1 ");
		buffer.append("      ,S_SE_SB_BasisOS1 ");
		buffer.append("      ,S_SE_SB_PrismOD ");
		buffer.append("      ,S_SE_SB_PrismOS ");
		buffer.append("      ,S_SE_SB_InterHighOD ");
		buffer.append("      ,S_SE_SB_InterHighOS ");
		buffer.append("      ,S_SE_SB_InterDistanceOD ");
		buffer.append("      ,S_SE_SB_InterDistanceOS ");
		buffer.append("      ,S_SE_SB_FarVAOD ");
		buffer.append("      ,S_SE_SB_FarVAOS ");
		buffer.append("      ,S_SE_SB_CloseVAOD ");
		buffer.append("      ,S_SE_SB_CloseVAOS ");
		buffer.append("      ,S_SE_SB_RecipeType ");
		buffer.append("      ,S_SE_SB_DignosisRe ");
		buffer.append("      ,S_SE_SB_DiameterOD ");
		buffer.append("      ,S_SE_SB_DiameterOS ");
		buffer.append("      ,S_SE_SB_ConRecipeType ");
		buffer.append("      ,S_SE_SB_SecCheckDate ");
		buffer.append("      ,S_SE_SB_SubVisitUnit ");
		buffer.append("      ,S_SE_SB_SalesType ");
		buffer.append("      ,S_SE_SB_SalerID ");
		buffer.append("      ,S_SE_SB_Lryid ");
		buffer.append("      ,S_SE_SB_PosDatetime ");
		buffer.append("      ,S_SE_SB_PosID ");
		buffer.append("      ,S_SE_SB_PriceSum ");
		buffer.append("      ,S_SE_SB_SalesValue ");
		buffer.append("      ,S_SE_SB_EyeCurvatureOD1 ");
		buffer.append("      ,S_SE_SB_EyeCurvatureOD2 ");
		buffer.append("      ,S_SE_SB_EyeCurvatureOS1 ");
		buffer.append("      ,S_SE_SB_EyeCurvatureOS2 ");
		buffer.append("      ,S_SE_SB_DiscountRate ");
		buffer.append("      ,S_SE_SB_DiscountNum ");
		buffer.append("      ,S_SE_SB_Psalsvalue ");
		buffer.append("      ,S_SE_SB_ArrearsValue ");
		buffer.append("      ,S_SE_SB_Location ");
		buffer.append("      ,S_SE_SB_ArrivedDate ");
		buffer.append("      ,S_SE_SB_ValueFlag ");
		buffer.append("      ,S_SE_SB_CheckoutFlag ");
		buffer.append("      ,S_SE_SB_InTransit ");
		buffer.append("      ,S_SE_SB_WithdrawDate ");
		buffer.append("      ,S_SE_SB_WithdrawFlag ");
		buffer.append("      ,S_SE_SB_WithdrawPersonID ");
		buffer.append("      ,S_SE_SB_MovementType ");
		buffer.append("      ,S_SE_SB_ArrearsAppendDate ");
		buffer.append("      ,S_SE_SB_ArrearsDate ");
		buffer.append("      ,S_SE_SB_PayCash ");
		buffer.append("      ,S_SE_SB_BankCard ");
		buffer.append("      ,S_SE_SB_StoredCard ");
		buffer.append("      ,S_SE_SB_Renums ");
		buffer.append("      ,S_SE_SB_DiscountType ");
		buffer.append("      ,S_SE_SB_DiscountPerson ");
		buffer.append("      ,S_SE_SB_DragsType ");
		buffer.append("      ,S_SE_SB_PupilHeightOD ");
		buffer.append("      ,S_SE_SB_PupilHeightOS ");
		buffer.append("      ,S_SE_SB_FavorableAmount ");
		buffer.append("      ,S_SE_SB_WorryType ");
		buffer.append("      ,S_SE_SB_Integral ");
		buffer.append("      ,S_SE_SB_SetMealID ");
		buffer.append("      ,S_SE_SB_IntegralPrice ");
		buffer.append("      ,S_SE_SB_SourceSalesID ");
		buffer.append("      ,S_SE_SB_SwapGoodsFlag ");
		buffer.append("      ,S_SE_SB_ExecStandard ");
		buffer.append("      ,S_SE_SB_SalesRemark ");
		buffer.append("      ,S_SE_SB_ProcessDepartment ");
		buffer.append("      ,S_SE_SB_PrintSMFlag ");
		buffer.append("  FROM S_SE_SalesBasic_Today_FlySheet where S_SE_SB_SalesID not in (select S_SE_SB_SalesID from #temp) ");
		
		buffer.append("drop table #temp ");
		
		getJdbcTemplate().update(buffer.toString());	
	}
	
	/**
	 * 当日销售商品			
	 */
	public void updateSalesGoodsToday(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select S_SE_SD_ID into #temp from S_SE_SalesDetail_Today ");
		
		buffer.append("INSERT INTO S_SE_SalesDetail_Today ");
		buffer.append("           (S_SE_SD_ID ");
		buffer.append("           ,S_SE_SD_SalesID ");
		buffer.append("           ,S_SE_SD_SalesItemID ");
		buffer.append("           ,S_SE_SD_ItemID ");
		buffer.append("           ,S_SE_SD_StockId ");
		buffer.append("           ,S_SE_SD_SalesItemName ");
		buffer.append("           ,S_SE_SD_SPrice ");
		buffer.append("           ,S_SE_SD_Number ");
		buffer.append("           ,S_SE_SD_UnitPrice ");
		buffer.append("           ,S_SE_SD_CostsPrive ");
		buffer.append("           ,S_SE_SD_PriceSum ");
		buffer.append("           ,S_SE_SD_SalesValue ");
		buffer.append("           ,S_SE_SD_DiscountRate ");
		buffer.append("           ,S_SE_SD_DiscountNum ");
		buffer.append("           ,S_SE_SD_GoodDescribe ");
		buffer.append("           ,S_SE_SD_GlassFlag ");
		buffer.append("           ,S_SE_SD_CommoditiesFlag ");
		buffer.append("           ,S_SE_SD_Updatetime ");
		buffer.append("           ,S_SE_SD_LargessFlag ");
		buffer.append("           ,S_SE_SD_Renums ");
		buffer.append("           ,S_SE_SD_DiscountType ");
		buffer.append("           ,S_SE_SD_DiscountSource ");
		buffer.append("           ,S_SE_SD_InStockId ");
		buffer.append("           ,S_SE_SD_Favorable ");
		buffer.append("           ,S_SE_SD_Integral ");
		buffer.append("           ,S_SE_SD_OutStorageFlag ");
		buffer.append("           ,S_SE_SD_InStorageFlag ");
		buffer.append("           ,S_SE_SD_ExchageFlag ");
		buffer.append("           ,S_SE_SD_WithdrawFlag ");
		buffer.append("           ,S_SE_SD_WithdrawDate ");
		buffer.append("           ,S_SE_SD_WithdrawPersonID ");
		buffer.append("           ,S_SE_SD_Guaranteeperiod ");
		buffer.append("           ,S_SE_SD_Batch ");
		buffer.append("           ,S_SE_SD_Setmealid ");
		buffer.append("           ,S_SE_SD_Setmealidno) ");
		buffer.append(" SELECT S_SE_SD_ID ");
		buffer.append("      ,S_SE_SD_SalesID ");
		buffer.append("      ,S_SE_SD_SalesItemID ");
		buffer.append("      ,S_SE_SD_ItemID ");
		buffer.append("      ,S_SE_SD_StockId ");
		buffer.append("      ,S_SE_SD_SalesItemName ");
		buffer.append("      ,S_SE_SD_SPrice ");
		buffer.append("      ,S_SE_SD_Number ");
		buffer.append("      ,S_SE_SD_UnitPrice ");
		buffer.append("      ,S_SE_SD_CostsPrive ");
		buffer.append("      ,S_SE_SD_PriceSum ");
		buffer.append("      ,S_SE_SD_SalesValue ");
		buffer.append("      ,S_SE_SD_DiscountRate ");
		buffer.append("      ,S_SE_SD_DiscountNum ");
		buffer.append("      ,S_SE_SD_GoodDescribe ");
		buffer.append("      ,S_SE_SD_GlassFlag ");
		buffer.append("      ,S_SE_SD_CommoditiesFlag ");
		buffer.append("      ,S_SE_SD_Updatetime ");
		buffer.append("      ,S_SE_SD_LargessFlag ");
		buffer.append("      ,S_SE_SD_Renums ");
		buffer.append("      ,S_SE_SD_DiscountType ");
		buffer.append("      ,S_SE_SD_DiscountSource ");
		buffer.append("      ,S_SE_SD_InStockId ");
		buffer.append("      ,S_SE_SD_Favorable ");
		buffer.append("      ,S_SE_SD_Integral ");
		buffer.append("      ,S_SE_SD_OutStorageFlag ");
		buffer.append("      ,S_SE_SD_InStorageFlag ");
		buffer.append("      ,S_SE_SD_ExchageFlag ");
		buffer.append("      ,S_SE_SD_WithdrawFlag ");
		buffer.append("      ,S_SE_SD_WithdrawDate ");
		buffer.append("      ,S_SE_SD_WithdrawPersonID ");
		buffer.append("      ,S_SE_SD_Guaranteeperiod ");
		buffer.append("      ,S_SE_SD_Batch ");
		buffer.append("      ,S_SE_SD_Setmealid ");
		buffer.append("      ,S_SE_SD_Setmealidno ");
		buffer.append("  FROM S_SE_SalesDetail_Today_FlySheet where S_SE_SD_ID not in (select S_SE_SD_ID from #temp) ");
		
		buffer.append("drop table #temp ");
		
		getJdbcTemplate().update(buffer.toString());	
	}
	
	/**
	 * 当月库存	
	 */
	public void updateStorageChange(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select C_SH_SC_UUID into #temp from C_SH_StorageChange ");
		
		buffer.append("INSERT INTO C_SH_StorageChange ");
		buffer.append("           (C_SH_SC_UUID ");
		buffer.append("           ,C_SH_SC_GoodsBarCode ");
		buffer.append("           ,C_SH_SC_GoodsId ");
		buffer.append("           ,C_SH_SC_StockId ");
		buffer.append("           ,C_SH_SC_GoodsQuantity ");
		buffer.append("           ,C_SH_SC_CostPrice ");
		buffer.append("           ,C_SH_SC_NotTaxRate ");
		buffer.append("           ,C_SH_SC_WarehousingDate ");
		buffer.append("           ,C_SH_SC_ChangeID) ");
		buffer.append("SELECT C_SH_SC_UUID ");
		buffer.append("      ,C_SH_SC_GoodsBarCode ");
		buffer.append("      ,C_SH_SC_GoodsId ");
		buffer.append("      ,C_SH_SC_StockId ");
		buffer.append("      ,C_SH_SC_GoodsQuantity ");
		buffer.append("      ,C_SH_SC_CostPrice ");
		buffer.append("      ,C_SH_SC_NotTaxRate ");
		buffer.append("      ,C_SH_SC_WarehousingDate ");
		buffer.append("      ,C_SH_SC_ChangeID ");
		buffer.append("  FROM C_SH_StorageChange_FlySheet where C_SH_SC_UUID not in (select C_SH_SC_UUID from #temp) ");
		
		buffer.append("drop table #temp ");
		
		getJdbcTemplate().update(buffer.toString());	
	}
	
	/**
	 * 库存流水
	 */
	public void updateStorageLog(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select C_SH_SL_UUID into #temp from C_SH_StorageLog ");
		
		buffer.append("INSERT INTO C_SH_StorageLog ");
		buffer.append("           (C_SH_SL_UUID ");
		buffer.append("           ,C_SH_SL_GoodsBarCode ");
		buffer.append("           ,C_SH_SL_GoodsId ");
		buffer.append("           ,C_SH_SL_StockId ");
		buffer.append("           ,C_SH_SL_FromStockId ");
		buffer.append("           ,C_SH_SL_GoodsQuantity ");
		buffer.append("           ,C_SH_SL_CostPrice ");
		buffer.append("           ,C_SH_SL_NotTaxRate ");
		buffer.append("           ,C_SH_SL_WarehousingDate ");
		buffer.append("           ,C_SH_SL_Month ");
		buffer.append("           ,C_SH_SL_ChangeID ");
		buffer.append("           ,C_SH_SL_GuaranteePeriod ");
		buffer.append("           ,C_SH_SL_Batch ");
		buffer.append("           ,C_SH_SL_AutoAllocation ");
		buffer.append("           ,C_SH_SL_Flag ");
		buffer.append("           ,C_SH_SL_SalesID) ");
		buffer.append("SELECT C_SH_SL_UUID ");
		buffer.append("      ,C_SH_SL_GoodsBarCode ");
		buffer.append("      ,C_SH_SL_GoodsId ");
		buffer.append("      ,C_SH_SL_StockId ");
		buffer.append("      ,C_SH_SL_FromStockId ");
		buffer.append("      ,C_SH_SL_GoodsQuantity ");
		buffer.append("      ,C_SH_SL_CostPrice ");
		buffer.append("      ,C_SH_SL_NotTaxRate ");
		buffer.append("      ,C_SH_SL_WarehousingDate ");
		buffer.append("      ,C_SH_SL_Month ");
		buffer.append("      ,C_SH_SL_ChangeID ");
		buffer.append("      ,C_SH_SL_GuaranteePeriod ");
		buffer.append("      ,C_SH_SL_Batch ");
		buffer.append("      ,C_SH_SL_AutoAllocation ");
		buffer.append("      ,C_SH_SL_Flag ");
		buffer.append("      ,C_SH_SL_SalesID ");
		buffer.append("  FROM C_SH_StorageLog_FlySheet where C_SH_SL_UUID not in (select C_SH_SL_UUID from #temp) ");
	
		buffer.append("drop table #temp ");
		
		getJdbcTemplate().update(buffer.toString());	
	}
	
	/**
	 * 商品信息
	 */
	public void updateGoodsInfo(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select B_GI_GoodsID into #temp from B_GoodsInfo ");
		
		buffer.append("INSERT INTO B_GoodsInfo ");
		buffer.append("           (B_GI_GoodsID ");
		buffer.append("           ,B_GI_GoodsBarCode ");
		buffer.append("           ,B_GI_GoodsName ");
		buffer.append("           ,B_GI_GoodsCategoryID ");
		buffer.append("           ,B_GI_SupplierID ");
		buffer.append("           ,B_GI_BrandID ");
		buffer.append("           ,B_GI_UnitId ");
		buffer.append("           ,B_GI_RetailPrice ");
		buffer.append("           ,B_GI_CostPrice ");
		buffer.append("           ,B_GI_NotTaxRate ");
		buffer.append("           ,B_GI_TaxRate ");
		buffer.append("           ,B_GI_Spec ");
		buffer.append("           ,B_GI_Color ");
		buffer.append("           ,B_GI_isCustomize ");
		buffer.append("           ,B_GI_Sph ");
		buffer.append("           ,B_GI_SphUL ");
		buffer.append("           ,B_GI_SphUP ");
		buffer.append("           ,B_GI_Cyl ");
		buffer.append("           ,B_GI_CylUL ");
		buffer.append("           ,B_GI_CylUP ");
		buffer.append("           ,B_GI_BelowPlusLuminosity ");
		buffer.append("           ,B_GI_BelowPlusLuminosityUL ");
		buffer.append("           ,B_GI_BelowPlusLuminosityUP ");
		buffer.append("           ,B_GI_Axis ");
		buffer.append("           ,B_GI_AxisUL ");
		buffer.append("           ,B_GI_AxisUP ");
		buffer.append("           ,B_GI_Curvature1 ");
		buffer.append("           ,B_GI_Curvature1UL ");
		buffer.append("           ,B_GI_Curvature1UP ");
		buffer.append("           ,B_GI_Curvature2 ");
		buffer.append("           ,B_GI_Curvature2UL ");
		buffer.append("           ,B_GI_Curvature2UP ");
		buffer.append("           ,B_GI_Dia ");
		buffer.append("           ,B_GI_DiaUL ");
		buffer.append("           ,B_GI_DiaUP ");
		buffer.append("           ,B_GI_isMutiLuminosity ");
		buffer.append("           ,B_GI_MutiLuminosityNum ");
		buffer.append("           ,B_GI_MutiLuminosityAddPrice ");
		buffer.append("           ,B_GI_EyeGlassMaterialType ");
		buffer.append("           ,B_GI_isPlating ");
		buffer.append("           ,B_GI_orderCycle ");
		buffer.append("           ,B_GI_FinishedGlassesType ");
		buffer.append("           ,B_GI_frameProcessCraftType ");
		buffer.append("           ,B_GI_CylMin ");
		buffer.append("           ,B_GI_CylDegreeIncrease ");
		buffer.append("           ,B_GI_CylMinAddPrice ");
		buffer.append("           ,B_GI_CylAddPrice ");
		buffer.append("           ,B_GI_PrismAddPrice ");
		buffer.append("           ,B_GI_cyl25CanNotDo ");
		buffer.append("           ,B_GI_ThrowingCycle ");
		buffer.append("           ,B_GI_StealthType ");
		buffer.append("           ,B_GI_OtherGoodsBigClass ");
		buffer.append("           ,B_GI_OtherGoodsSmallClass ");
		buffer.append("           ,B_GI_Flag ");
		buffer.append("           ,B_GI_Refractive ");
		buffer.append("           ,B_GI_FrameMaterialType ");
		buffer.append("           ,B_GI_AverageNotTaxRate ");
		buffer.append("           ,B_GI_ReturnMax ");
		buffer.append("           ,B_GI_ReturnMin ");
		buffer.append("           ,B_GI_WholesalePrice ");
		buffer.append("           ,B_GI_FrameSize ");
		buffer.append("           ,B_GI_MaterialClass ");
		buffer.append("           ,B_GI_LuminosityClass ");
		buffer.append("           ,B_GI_GradualClass ");
		buffer.append("           ,B_GI_FunctionClass ");
		buffer.append("           ,B_GI_UseType ");
		buffer.append("           ,B_GI_StealthClass ");
		buffer.append("           ,B_GI_Capacity ");
		buffer.append("           ,B_GI_CapacityEntry ");
		buffer.append("           ,B_GI_AccessoriesType ");
		buffer.append("           ,B_GI_SupplierColor ");
		buffer.append("           ,B_GI_SunGglassesFun ");
		buffer.append("           ,B_GI_FirstInStorageDate ");
		buffer.append("           ,B_GI_RetailPriceA ");
		buffer.append("           ,B_GI_RetailPriceB ");
		buffer.append("           ,B_GI_RetailPriceC ");
		buffer.append("           ,B_GI_RetailPriceD ");
		buffer.append("           ,B_GI_RetailPriceE ");
		buffer.append("           ,B_GI_RetailPriceF ");
		buffer.append("           ,B_GI_RetailPriceG ");
		buffer.append("           ,B_GI_RetailPriceH ");
		buffer.append("           ,B_GI_RetailPriceI ");
		buffer.append("           ,B_GI_WholeGoodsIsable ");
		buffer.append("           ,B_GI_BrandYear ");
		buffer.append("           ,B_GI_ChineseColor ");
		buffer.append("           ,B_GI_SupplierSpec ");
		buffer.append("           ,B_GI_ViewGoodsName ");
		buffer.append("           ,B_GI_Vsph ");
		buffer.append("           ,B_GI_Vcyl ");
		buffer.append("           ,B_GI_DefaultDiscountValue ");
		buffer.append("           ,B_GI_Numberofdays) ");
		buffer.append("SELECT B_GI_GoodsID ");
		buffer.append("      ,B_GI_GoodsBarCode ");
		buffer.append("      ,B_GI_GoodsName ");
		buffer.append("      ,B_GI_GoodsCategoryID ");
		buffer.append("      ,B_GI_SupplierID ");
		buffer.append("      ,B_GI_BrandID ");
		buffer.append("      ,B_GI_UnitId ");
		buffer.append("      ,B_GI_RetailPrice ");
		buffer.append("      ,B_GI_CostPrice ");
		buffer.append("      ,B_GI_NotTaxRate ");
		buffer.append("      ,B_GI_TaxRate ");
		buffer.append("      ,B_GI_Spec ");
		buffer.append("      ,B_GI_Color ");
		buffer.append("      ,B_GI_isCustomize ");
		buffer.append("      ,B_GI_Sph ");
		buffer.append("      ,B_GI_SphUL ");
		buffer.append("      ,B_GI_SphUP ");
		buffer.append("      ,B_GI_Cyl ");
		buffer.append("      ,B_GI_CylUL ");
		buffer.append("      ,B_GI_CylUP ");
		buffer.append("      ,B_GI_BelowPlusLuminosity ");
		buffer.append("      ,B_GI_BelowPlusLuminosityUL ");
		buffer.append("      ,B_GI_BelowPlusLuminosityUP ");
		buffer.append("      ,B_GI_Axis ");
		buffer.append("      ,B_GI_AxisUL ");
		buffer.append("      ,B_GI_AxisUP ");
		buffer.append("      ,B_GI_Curvature1 ");
		buffer.append("      ,B_GI_Curvature1UL ");
		buffer.append("      ,B_GI_Curvature1UP ");
		buffer.append("      ,B_GI_Curvature2 ");
		buffer.append("      ,B_GI_Curvature2UL ");
		buffer.append("      ,B_GI_Curvature2UP ");
		buffer.append("      ,B_GI_Dia ");
		buffer.append("      ,B_GI_DiaUL ");
		buffer.append("      ,B_GI_DiaUP ");
		buffer.append("      ,B_GI_isMutiLuminosity ");
		buffer.append("      ,B_GI_MutiLuminosityNum ");
		buffer.append("      ,B_GI_MutiLuminosityAddPrice ");
		buffer.append("      ,B_GI_EyeGlassMaterialType ");
		buffer.append("      ,B_GI_isPlating ");
		buffer.append("      ,B_GI_orderCycle ");
		buffer.append("      ,B_GI_FinishedGlassesType ");
		buffer.append("      ,B_GI_frameProcessCraftType ");
		buffer.append("      ,B_GI_CylMin ");
		buffer.append("      ,B_GI_CylDegreeIncrease ");
		buffer.append("      ,B_GI_CylMinAddPrice ");
		buffer.append("      ,B_GI_CylAddPrice ");
		buffer.append("      ,B_GI_PrismAddPrice ");
		buffer.append("      ,B_GI_cyl25CanNotDo ");
		buffer.append("      ,B_GI_ThrowingCycle ");
		buffer.append("      ,B_GI_StealthType ");
		buffer.append("      ,B_GI_OtherGoodsBigClass ");
		buffer.append("      ,B_GI_OtherGoodsSmallClass ");
		buffer.append("      ,B_GI_Flag ");
		buffer.append("      ,B_GI_Refractive ");
		buffer.append("      ,B_GI_FrameMaterialType ");
		buffer.append("      ,B_GI_AverageNotTaxRate ");
		buffer.append("      ,B_GI_ReturnMax ");
		buffer.append("      ,B_GI_ReturnMin ");
		buffer.append("      ,B_GI_WholesalePrice ");
		buffer.append("      ,B_GI_FrameSize ");
		buffer.append("      ,B_GI_MaterialClass ");
		buffer.append("      ,B_GI_LuminosityClass ");
		buffer.append("      ,B_GI_GradualClass ");
		buffer.append("      ,B_GI_FunctionClass ");
		buffer.append("      ,B_GI_UseType ");
		buffer.append("      ,B_GI_StealthClass ");
		buffer.append("      ,B_GI_Capacity ");
		buffer.append("      ,B_GI_CapacityEntry ");
		buffer.append("      ,B_GI_AccessoriesType ");
		buffer.append("      ,B_GI_SupplierColor ");
		buffer.append("      ,B_GI_SunGglassesFun ");
		buffer.append("      ,B_GI_FirstInStorageDate ");
		buffer.append("      ,B_GI_RetailPriceA ");
		buffer.append("      ,B_GI_RetailPriceB ");
		buffer.append("      ,B_GI_RetailPriceC ");
		buffer.append("      ,B_GI_RetailPriceD ");
		buffer.append("      ,B_GI_RetailPriceE ");
		buffer.append("      ,B_GI_RetailPriceF ");
		buffer.append("      ,B_GI_RetailPriceG ");
		buffer.append("      ,B_GI_RetailPriceH ");
		buffer.append("      ,B_GI_RetailPriceI ");
		buffer.append("      ,B_GI_WholeGoodsIsable ");
		buffer.append("      ,B_GI_BrandYear ");
		buffer.append("      ,B_GI_ChineseColor ");
		buffer.append("      ,B_GI_SupplierSpec ");
		buffer.append("      ,B_GI_ViewGoodsName ");
		buffer.append("      ,B_GI_Vsph ");
		buffer.append("      ,B_GI_Vcyl ");
		buffer.append("      ,B_GI_DefaultDiscountValue ");
		buffer.append("      ,B_GI_Numberofdays ");
		buffer.append("  FROM B_GoodsInfo_FlySheet where B_GI_GoodsID not in (select B_GI_GoodsID from #temp) ");
		
		buffer.append("drop table #temp ");
		
		getJdbcTemplate().update(buffer.toString());	
	}
	
	/**
	 * 新增商品信息
	 */
	public void insertGoodsInfo(){
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("select B_GI_GoodsID into #temp from B_GoodsInfo_FlySheet ");
		
		buffer.append("INSERT INTO B_GoodsInfo_FlySheet ");
		buffer.append("           (B_GI_GoodsID ");
		buffer.append("           ,B_GI_GoodsBarCode ");
		buffer.append("           ,B_GI_GoodsName ");
		buffer.append("           ,B_GI_GoodsCategoryID ");
		buffer.append("           ,B_GI_SupplierID ");
		buffer.append("           ,B_GI_BrandID ");
		buffer.append("           ,B_GI_UnitId ");
		buffer.append("           ,B_GI_RetailPrice ");
		buffer.append("           ,B_GI_CostPrice ");
		buffer.append("           ,B_GI_NotTaxRate ");
		buffer.append("           ,B_GI_TaxRate ");
		buffer.append("           ,B_GI_Spec ");
		buffer.append("           ,B_GI_Color ");
		buffer.append("           ,B_GI_isCustomize ");
		buffer.append("           ,B_GI_Sph ");
		buffer.append("           ,B_GI_SphUL ");
		buffer.append("           ,B_GI_SphUP ");
		buffer.append("           ,B_GI_Cyl ");
		buffer.append("           ,B_GI_CylUL ");
		buffer.append("           ,B_GI_CylUP ");
		buffer.append("           ,B_GI_BelowPlusLuminosity ");
		buffer.append("           ,B_GI_BelowPlusLuminosityUL ");
		buffer.append("           ,B_GI_BelowPlusLuminosityUP ");
		buffer.append("           ,B_GI_Axis ");
		buffer.append("           ,B_GI_AxisUL ");
		buffer.append("           ,B_GI_AxisUP ");
		buffer.append("           ,B_GI_Curvature1 ");
		buffer.append("           ,B_GI_Curvature1UL ");
		buffer.append("           ,B_GI_Curvature1UP ");
		buffer.append("           ,B_GI_Curvature2 ");
		buffer.append("           ,B_GI_Curvature2UL ");
		buffer.append("           ,B_GI_Curvature2UP ");
		buffer.append("           ,B_GI_Dia ");
		buffer.append("           ,B_GI_DiaUL ");
		buffer.append("           ,B_GI_DiaUP ");
		buffer.append("           ,B_GI_isMutiLuminosity ");
		buffer.append("           ,B_GI_MutiLuminosityNum ");
		buffer.append("           ,B_GI_MutiLuminosityAddPrice ");
		buffer.append("           ,B_GI_EyeGlassMaterialType ");
		buffer.append("           ,B_GI_isPlating ");
		buffer.append("           ,B_GI_orderCycle ");
		buffer.append("           ,B_GI_FinishedGlassesType ");
		buffer.append("           ,B_GI_frameProcessCraftType ");
		buffer.append("           ,B_GI_CylMin ");
		buffer.append("           ,B_GI_CylDegreeIncrease ");
		buffer.append("           ,B_GI_CylMinAddPrice ");
		buffer.append("           ,B_GI_CylAddPrice ");
		buffer.append("           ,B_GI_PrismAddPrice ");
		buffer.append("           ,B_GI_cyl25CanNotDo ");
		buffer.append("           ,B_GI_ThrowingCycle ");
		buffer.append("           ,B_GI_StealthType ");
		buffer.append("           ,B_GI_OtherGoodsBigClass ");
		buffer.append("           ,B_GI_OtherGoodsSmallClass ");
		buffer.append("           ,B_GI_Flag ");
		buffer.append("           ,B_GI_Refractive ");
		buffer.append("           ,B_GI_FrameMaterialType ");
		buffer.append("           ,B_GI_AverageNotTaxRate ");
		buffer.append("           ,B_GI_ReturnMax ");
		buffer.append("           ,B_GI_ReturnMin ");
		buffer.append("           ,B_GI_WholesalePrice ");
		buffer.append("           ,B_GI_FrameSize ");
		buffer.append("           ,B_GI_MaterialClass ");
		buffer.append("           ,B_GI_LuminosityClass ");
		buffer.append("           ,B_GI_GradualClass ");
		buffer.append("           ,B_GI_FunctionClass ");
		buffer.append("           ,B_GI_UseType ");
		buffer.append("           ,B_GI_StealthClass ");
		buffer.append("           ,B_GI_Capacity ");
		buffer.append("           ,B_GI_CapacityEntry ");
		buffer.append("           ,B_GI_AccessoriesType ");
		buffer.append("           ,B_GI_SupplierColor ");
		buffer.append("           ,B_GI_SunGglassesFun ");
		buffer.append("           ,B_GI_FirstInStorageDate ");
		buffer.append("           ,B_GI_RetailPriceA ");
		buffer.append("           ,B_GI_RetailPriceB ");
		buffer.append("           ,B_GI_RetailPriceC ");
		buffer.append("           ,B_GI_RetailPriceD ");
		buffer.append("           ,B_GI_RetailPriceE ");
		buffer.append("           ,B_GI_RetailPriceF ");
		buffer.append("           ,B_GI_RetailPriceG ");
		buffer.append("           ,B_GI_RetailPriceH ");
		buffer.append("           ,B_GI_RetailPriceI ");
		buffer.append("           ,B_GI_WholeGoodsIsable ");
		buffer.append("           ,B_GI_BrandYear ");
		buffer.append("           ,B_GI_ChineseColor ");
		buffer.append("           ,B_GI_SupplierSpec ");
		buffer.append("           ,B_GI_ViewGoodsName ");
		buffer.append("           ,B_GI_Vsph ");
		buffer.append("           ,B_GI_Vcyl ");
		buffer.append("           ,B_GI_DefaultDiscountValue ");
		buffer.append("           ,B_GI_Numberofdays ");
		buffer.append("           ,B_GI_ContactType ");
		buffer.append("           ,B_GI_BarCodeFlag ");
		buffer.append("           ,B_GI_UnionSphCyl) ");
		buffer.append("SELECT B_GI_GoodsID ");
		buffer.append("      ,B_GI_GoodsBarCode ");
		buffer.append("      ,B_GI_GoodsName ");
		buffer.append("      ,B_GI_GoodsCategoryID ");
		buffer.append("      ,B_GI_SupplierID ");
		buffer.append("      ,B_GI_BrandID ");
		buffer.append("      ,B_GI_UnitId ");
		buffer.append("      ,B_GI_RetailPrice ");
		buffer.append("      ,B_GI_CostPrice ");
		buffer.append("      ,B_GI_NotTaxRate ");
		buffer.append("      ,B_GI_TaxRate ");
		buffer.append("      ,B_GI_Spec ");
		buffer.append("      ,B_GI_Color ");
		buffer.append("      ,B_GI_isCustomize ");
		buffer.append("      ,B_GI_Sph ");
		buffer.append("      ,B_GI_SphUL ");
		buffer.append("      ,B_GI_SphUP ");
		buffer.append("      ,B_GI_Cyl ");
		buffer.append("      ,B_GI_CylUL ");
		buffer.append("      ,B_GI_CylUP ");
		buffer.append("      ,B_GI_BelowPlusLuminosity ");
		buffer.append("      ,B_GI_BelowPlusLuminosityUL ");
		buffer.append("      ,B_GI_BelowPlusLuminosityUP ");
		buffer.append("      ,B_GI_Axis ");
		buffer.append("      ,B_GI_AxisUL ");
		buffer.append("      ,B_GI_AxisUP ");
		buffer.append("      ,B_GI_Curvature1 ");
		buffer.append("      ,B_GI_Curvature1UL ");
		buffer.append("      ,B_GI_Curvature1UP ");
		buffer.append("      ,B_GI_Curvature2 ");
		buffer.append("      ,B_GI_Curvature2UL ");
		buffer.append("      ,B_GI_Curvature2UP ");
		buffer.append("      ,B_GI_Dia ");
		buffer.append("      ,B_GI_DiaUL ");
		buffer.append("      ,B_GI_DiaUP ");
		buffer.append("      ,B_GI_isMutiLuminosity ");
		buffer.append("      ,B_GI_MutiLuminosityNum ");
		buffer.append("      ,B_GI_MutiLuminosityAddPrice ");
		buffer.append("      ,B_GI_EyeGlassMaterialType ");
		buffer.append("      ,B_GI_isPlating ");
		buffer.append("      ,B_GI_orderCycle ");
		buffer.append("      ,B_GI_FinishedGlassesType ");
		buffer.append("      ,B_GI_frameProcessCraftType ");
		buffer.append("      ,B_GI_CylMin ");
		buffer.append("      ,B_GI_CylDegreeIncrease ");
		buffer.append("      ,B_GI_CylMinAddPrice ");
		buffer.append("      ,B_GI_CylAddPrice ");
		buffer.append("      ,B_GI_PrismAddPrice ");
		buffer.append("      ,B_GI_cyl25CanNotDo ");
		buffer.append("      ,B_GI_ThrowingCycle ");
		buffer.append("      ,B_GI_StealthType ");
		buffer.append("      ,B_GI_OtherGoodsBigClass ");
		buffer.append("      ,B_GI_OtherGoodsSmallClass ");
		buffer.append("      ,B_GI_Flag ");
		buffer.append("      ,B_GI_Refractive ");
		buffer.append("      ,B_GI_FrameMaterialType ");
		buffer.append("      ,B_GI_AverageNotTaxRate ");
		buffer.append("      ,B_GI_ReturnMax ");
		buffer.append("      ,B_GI_ReturnMin ");
		buffer.append("      ,B_GI_WholesalePrice ");
		buffer.append("      ,B_GI_FrameSize ");
		buffer.append("      ,B_GI_MaterialClass ");
		buffer.append("      ,B_GI_LuminosityClass ");
		buffer.append("      ,B_GI_GradualClass ");
		buffer.append("      ,B_GI_FunctionClass ");
		buffer.append("      ,B_GI_UseType ");
		buffer.append("      ,B_GI_StealthClass ");
		buffer.append("      ,B_GI_Capacity ");
		buffer.append("      ,B_GI_CapacityEntry ");
		buffer.append("      ,B_GI_AccessoriesType ");
		buffer.append("      ,B_GI_SupplierColor ");
		buffer.append("      ,B_GI_SunGglassesFun ");
		buffer.append("      ,B_GI_FirstInStorageDate ");
		buffer.append("      ,B_GI_RetailPriceA ");
		buffer.append("      ,B_GI_RetailPriceB ");
		buffer.append("      ,B_GI_RetailPriceC ");
		buffer.append("      ,B_GI_RetailPriceD ");
		buffer.append("      ,B_GI_RetailPriceE ");
		buffer.append("      ,B_GI_RetailPriceF ");
		buffer.append("      ,B_GI_RetailPriceG ");
		buffer.append("      ,B_GI_RetailPriceH ");
		buffer.append("      ,B_GI_RetailPriceI ");
		buffer.append("      ,B_GI_WholeGoodsIsable ");
		buffer.append("      ,B_GI_BrandYear ");
		buffer.append("      ,B_GI_ChineseColor ");
		buffer.append("      ,B_GI_SupplierSpec ");
		buffer.append("      ,B_GI_ViewGoodsName ");
		buffer.append("      ,B_GI_Vsph ");
		buffer.append("      ,B_GI_Vcyl ");
		buffer.append("      ,B_GI_DefaultDiscountValue ");
		buffer.append("      ,B_GI_Numberofdays ");
		buffer.append("      ,B_GI_ContactType ");
		buffer.append("      ,B_GI_BarCodeFlag ");
		buffer.append("      ,B_GI_UnionSphCyl ");
		buffer.append("  FROM B_GoodsInfo ");
		buffer.append("  where B_GI_GoodsID not in (select B_GI_GoodsID from #temp) ");
		
		buffer.append("drop table #temp ");
		
		getJdbcTemplate().update(buffer.toString());	
	}
	
	/**
	 * 更新商品零售价
	 */
	public void updateGoodsInfoAdjustmentPrice(ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("update B_GoodsInfo set B_GoodsInfo.B_GI_RetailPrice = b.B_GI_RetailPrice ");
		
		if (!"1".equals(Utility.getName(epo.getFeacastset()))){			
			buffer.append("      ,B_GoodsInfo.B_GI_NotTaxRate = (case dbo.getGoodsMaxDiscount_Flysheet(a.B_GI_GoodsID) when '' then b.B_GI_NotTaxRate else cast((cast((b.B_GI_RetailPrice * dbo.getGoodsMaxDiscount_Flysheet(a.B_GI_GoodsID)) as numeric(30,2)) / (1 + (a.B_GI_TaxRate * 0.01))) as numeric(30,6))  end) ");
			buffer.append("      ,B_GoodsInfo.B_GI_CostPrice = (case dbo.getGoodsMaxDiscount_Flysheet(a.B_GI_GoodsID) when '' then b.B_GI_CostPrice else cast((b.B_GI_RetailPrice * dbo.getGoodsMaxDiscount_Flysheet(a.B_GI_GoodsID)) as numeric(30,2))  end) ");
		}else{
			buffer.append("	,B_GoodsInfo.B_GI_CostPrice = b.B_GI_CostPrice ");
			buffer.append("	,B_GoodsInfo.B_GI_NotTaxRate = b.B_GI_NotTaxRate ");
		}
		
		buffer.append(" from B_GoodsInfo a inner join B_GoodsInfo_FlySheet b on a.B_GI_GoodsID = b.B_GI_GoodsID ");
		buffer.append(" where a.B_GI_SupplierID <> 'ZZ' ");
		
		getJdbcTemplate().update(buffer.toString());			
	}
	
}
