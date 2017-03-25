package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.sales.dao.CustomerTakeDao;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.TakeMsgPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class CustomerTakeDaoImpl extends BaseJdbcDaoSupport implements
		CustomerTakeDao {

	/**
	 * 得到顾客取镜信息数量
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public int getCustomerTakeCount(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select count(S_SE_SB_SalesID) ");
		buffer.append("from S_SE_SalesBasic ");
		buffer
				.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("where S_SE_SB_Location = ? ");
		buffer.append("and S_SE_SB_InTransit='12' ");
		buffer.append("and S_SE_SB_OrdersType in ('1','2','3','4','5') ");

		params.add(salesBasicPo.getSsesblocation());

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))) {
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		if(!"".equals(Utility.getName(salesBasicPo.getDjsbm()))){
			buffer.append("and S_SE_SB_Djsbm = ? ");
			params.add(salesBasicPo.getDjsbm());
		}

		if (!"".equals(Utility.getName(salesBasicPo
				.getSsesbsalesdatestarttime()))
				&& !"".equals(Utility.getName(salesBasicPo
						.getSsesbsalesdateendtime()))) {
			buffer
					.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			buffer
					.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo
				.getSsesbsalesdatestarttime()))
				&& "".equals(Utility.getName(salesBasicPo
						.getSsesbsalesdateendtime()))) {
			buffer
					.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo
				.getSsesbsalesdatestarttime()))
				&& !"".equals(Utility.getName(salesBasicPo
						.getSsesbsalesdateendtime()))) {
			buffer
					.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))) {
			buffer.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(salesBasicPo.getSsesbpersonName());
		}

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbMemberId()))) {
			buffer.append("and S_ME_CI_MemberId like '%' + ? ");
			params.add(salesBasicPo.getSsesbMemberId());
		}

		return getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());
	}

	/**
	 * 配镜单信息插入在途表中
	 * 
	 * @param inTransitPo
	 */
	public void insertCustInTransit(InTransitPo inTransitPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into S_SE_InTransit (S_SE_IT_ID , ");
		buffer.append("S_SE_IT_SalesID , S_SE_IT_State , ");
		buffer
				.append("S_SE_IT_Date , S_SE_IT_CreatePerson , S_SE_IT_Department) ");
		buffer.append("values (? , ? , 13 , getdate() , ? , ?) ");

		params.add(this.uuid.generate());
		params.add(inTransitPo.getSseitsalesid());
		params.add(inTransitPo.getSseitcreateperson());
		params.add(inTransitPo.getSseitdepartment());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 得到顾客取镜信息
	 * 
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectCustomerTake(SalesBasicPo salesBasicPo,
			int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by S_SE_SB_TakeGlassData desc) as rowNum, ");

		buffer
				.append("S_SE_SB_SalesID as ssesbsalesid , S_SE_SB_TakeGlassData as ssesbtakeglassdata , ");
		buffer
				.append("S_SE_SB_PosDatetime as ssesbsalesdatetime , S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("S_ME_CI_Phone as ssesbphone ,S_ME_CI_MemberId as ssesbMemberId ,");
		buffer
				.append("S_SE_SB_CheckoutFlag as ssesbcheckoutflag , S_SE_SB_ArrearsValue as ssesbarrearsvalue ");
		buffer.append("from S_SE_SalesBasic ");
		buffer
				.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("where S_SE_SB_Location = ? ");
		buffer.append("and S_SE_SB_InTransit='12' ");
		buffer.append("and S_SE_SB_OrdersType in ('1','2','3','4','5') ");

		params.add(salesBasicPo.getSsesblocation());

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))) {
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		if(!"".equals(Utility.getName(salesBasicPo.getDjsbm()))){
			buffer.append("and S_SE_SB_Djsbm = ? ");
			params.add(salesBasicPo.getDjsbm());
		}

		if (!"".equals(Utility.getName(salesBasicPo
				.getSsesbsalesdatestarttime()))
				&& !"".equals(Utility.getName(salesBasicPo
						.getSsesbsalesdateendtime()))) {
			buffer
					.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			buffer
					.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo
				.getSsesbsalesdatestarttime()))
				&& "".equals(Utility.getName(salesBasicPo
						.getSsesbsalesdateendtime()))) {
			buffer
					.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo
				.getSsesbsalesdatestarttime()))
				&& !"".equals(Utility.getName(salesBasicPo
						.getSsesbsalesdateendtime()))) {
			buffer
					.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))) {
			buffer.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(salesBasicPo.getSsesbpersonName());
		}

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbMemberId()))) {
			buffer.append("and S_ME_CI_MemberId like '%' + ? ");
			params.add(salesBasicPo.getSsesbMemberId());
		}

		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(),
				SalesBasicPo.class);
	}

	/**
	 * 更新销售基表中的在途信息
	 * 
	 * @param salesBasicPo
	 */
	public void updateCustInTransit(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("update S_SE_SalesBasic ");
		buffer.append("set S_SE_SB_InTransit='13' ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		
		buffer.append("update S_SE_SalesBasic_Finished ");
		buffer.append("set S_SE_SB_InTransit='13' ");
		buffer.append("where S_SE_SB_SalesID = ? ");

		params.add(salesBasicPo.getSsesbsalesid());
		params.add(salesBasicPo.getSsesbsalesid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 关联销售明细表查询商品信息
	 * 
	 * @param salesDetailPo
	 * @return
	 */
	public List<SalesDetailPo> getGoodsDetailInfoNoFinished(SalesDetailPo salesDetailPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select S_SE_SD_SalesItemID as ssesdsalesitemid , S_SE_SD_ItemID as ssesditemid ,S_SE_SD_StockId as ssesdstockid , ");
		buffer.append(" S_SE_SD_Number as ssesdnumber , ");
		buffer.append("S_SE_SD_CostsPrive as ssesdcostsprive , S_SE_SD_UnitPrice as ssesdunitprice , ");
		buffer.append("S_SE_SD_SalesID as ssesdsalesid ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join S_SE_SalesBasic on S_SE_SalesBasic.S_SE_SB_SalesID=S_SE_SalesDetail.S_SE_SD_SalesID ");
		buffer.append("inner join B_GoodsInfo on S_SE_SD_SalesItemID = B_GI_GoodsID ");
		buffer.append("where B_GI_GoodsCategoryID <> '3' ");
		buffer.append("and S_SE_SD_SalesID = ? ");
		
		params.add(Utility.getName(salesDetailPo.getSsesdsalesid()));
		if (!"".equals(Utility.getName(salesDetailPo.getSsesdiscustomize()))){
			buffer.append(" and B_GI_isCustomize = ? ");
			params.add(Utility.getName(salesDetailPo.getSsesdiscustomize()));			
		}
		
		if (!"".equals(Utility.getName(salesDetailPo.getSsesdcommoditiesflag()))){
			buffer.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(salesDetailPo.getSsesdcommoditiesflag()));			
		}
		
		return queryForObjectList(buffer.toString(), params.toArray(),SalesDetailPo.class);
	}
	
	/**
	 * 关联销售明细表查询商品信息
	 * 
	 * @param salesDetailPo
	 * @return
	 */
	public List<SalesDetailPo> getGoodsDetailInfo(SalesDetailPo salesDetailPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select S_SE_SD_SalesItemID as ssesdsalesitemid , S_SE_SD_ItemID as ssesditemid ,S_SE_SD_StockId as ssesdstockid , ");
		buffer.append("B_WH_ID as ssesdstockid , S_SE_SD_Number as ssesdnumber , ");
		buffer.append("S_SE_SD_CostsPrive as ssesdcostsprive , S_SE_SD_UnitPrice as ssesdunitprice , ");
		buffer.append("S_SE_SD_SalesID as ssesdsalesid ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join S_SE_SalesBasic on S_SE_SalesBasic.S_SE_SB_SalesID=S_SE_SalesDetail.S_SE_SD_SalesID ");
		buffer.append("inner join B_Warehouse on B_WH_deptID = S_SE_SB_Location ");
		buffer.append("inner join B_GoodsInfo on S_SE_SD_SalesItemID = B_GI_GoodsID ");
		buffer.append("where B_GI_GoodsCategoryID <> '3' ");
		buffer.append("and S_SE_SD_SalesID = ? ");
		
		params.add(Utility.getName(salesDetailPo.getSsesdsalesid()));
		if (!"".equals(Utility.getName(salesDetailPo.getSsesdiscustomize()))){
			buffer.append(" and B_GI_isCustomize = ? ");
			params.add(Utility.getName(salesDetailPo.getSsesdiscustomize()));			
		}
		
		if (!"".equals(Utility.getName(salesDetailPo.getSsesdcommoditiesflag()))){
			buffer.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(salesDetailPo.getSsesdcommoditiesflag()));			
		}
		
		buffer.append(" union all ");		
		buffer.append("select S_SE_SD_SalesItemID as ssesdsalesitemid , S_SE_SD_ItemID as ssesditemid ,S_SE_SD_StockId as ssesdstockid , ");
		buffer.append("B_WH_ID as ssesdstockid , S_SE_SD_Number as ssesdnumber , ");
		buffer.append("S_SE_SD_CostsPrive as ssesdcostsprive , S_SE_SD_UnitPrice as ssesdunitprice , ");
		buffer.append("S_SE_SD_SalesID as ssesdsalesid ");
		buffer.append("from S_SE_SalesDetail_Finished ");
		buffer.append("inner join S_SE_SalesBasic_Finished on S_SE_SB_SalesID=S_SE_SD_SalesID ");
		buffer.append("inner join B_Warehouse on B_WH_deptID = S_SE_SB_Location ");
		buffer.append("inner join B_GoodsInfo on S_SE_SD_SalesItemID = B_GI_GoodsID ");
		buffer.append("where B_GI_GoodsCategoryID <> '3' ");
		buffer.append("and S_SE_SD_SalesID = ? ");
		
		params.add(Utility.getName(salesDetailPo.getSsesdsalesid()));
		if (!"".equals(Utility.getName(salesDetailPo.getSsesdiscustomize()))){
			buffer.append(" and B_GI_isCustomize = ? ");
			params.add(Utility.getName(salesDetailPo.getSsesdiscustomize()));			
		}
		
		if (!"".equals(Utility.getName(salesDetailPo.getSsesdcommoditiesflag()))){
			buffer.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(salesDetailPo.getSsesdcommoditiesflag()));			
		}
		
		return queryForObjectList(buffer.toString(), params.toArray(),SalesDetailPo.class);
	}
	
	/**
	 * 得到销售结帐基表对象
	 */
	public SalesBasicPo getSalesBasicPo(String salesID) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT top 1 * from ( ");
		sb.append("SELECT S_SE_SB_SalesID as ssesbsalesid,S_SE_SB_ShopCode as ssesbshopcode,");
		sb.append("S_SE_SB_DiscountRate as ssesbdiscountrate, ");
		sb.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata, ");
		sb.append("S_SE_SB_CustomerID as ssesbcustomerid,");
		sb.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime,");
		sb.append("S_SE_SB_PriceSum as ssesbpricesum,");
		sb.append("S_SE_SB_SalesValue as ssesbsalesvalue,");
		sb.append("S_SE_SB_DiscountNum as ssesbdiscountnum,");
		sb.append("S_SE_SB_Psalsvalue as ssesbpsalsvalue,");
		sb.append("S_SE_SB_ArrearsValue as ssesbarrearsvalue ");
		sb.append("from s_se_salesbasic ");
		sb.append("where (S_SE_SB_OrdersType = 3 or S_SE_SB_OrdersType = 4 or S_SE_SB_OrdersType = 5) and S_SE_SB_SalesID = ? ");
		sb.append(" union all ");
		sb.append("SELECT S_SE_SB_SalesID as ssesbsalesid, S_SE_SB_ShopCode as ssesbshopcode,");
		sb.append("S_SE_SB_DiscountRate as ssesbdiscountrate, ");
		sb.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata, ");
		sb.append("S_SE_SB_CustomerID as ssesbcustomerid,");
		sb.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime,");
		sb.append("S_SE_SB_PriceSum as ssesbpricesum,");
		sb.append("S_SE_SB_SalesValue as ssesbsalesvalue,");
		sb.append("S_SE_SB_DiscountNum as ssesbdiscountnum,");
		sb.append("S_SE_SB_Psalsvalue as ssesbpsalsvalue,");
		sb.append("S_SE_SB_ArrearsValue as ssesbarrearsvalue ");
		sb.append("from S_SE_SalesBasic_Finished ");
		sb.append("where (S_SE_SB_OrdersType = 3 or S_SE_SB_OrdersType = 4 or S_SE_SB_OrdersType = 5) and S_SE_SB_SalesID = ? ");
		sb.append(" )t ");
		
		List<String> params = new ArrayList<String>();
		params.add(salesID);
		params.add(salesID);
		
		return (SalesBasicPo) queryForObject(sb.toString(), params.toArray(),SalesBasicPo.class);
	}
	
	/**
	 * 得到商品信息表
	 */
	public GoodsInfoPo getGoodsInfoPo(String id) 
	{
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT top 1  B_GI_GoodsID as bgigoodsid, ");
		sb.append("B_GI_StealthClass as bgistealthclass, ");
		sb.append("B_GI_GoodsName as bgigoodsname, ");
		sb.append("B_GI_isCustomize as bgiiscustomize, ");
		sb.append("B_GI_Numberofdays as bginumberofdays ");
		sb.append(" from B_GoodsInfo where B_GI_GoodsID= ?");

		List<String> params = new ArrayList<String>();
		params.add(id);
		return (GoodsInfoPo) queryForObject(sb.toString(), params.toArray(),
				GoodsInfoPo.class);
	}
	
	/**
	 * 将配镜单送至已完结的表中
	 */
	public void insertSalesBasicFinished(String salesID){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("INSERT INTO S_SE_SalesBasic_Finished ");
		sb.append("           (S_SE_SB_SalesID ");		
		sb.append("           ,S_SE_SB_ShopCode ");
		sb.append("           ,S_SE_SB_CustomerID ");
		sb.append("           ,S_SE_SB_OptID ");
		sb.append("           ,S_SE_SB_OptometryID ");
		sb.append("           ,S_SE_SB_InspectionID ");		
		sb.append("           ,S_SE_SB_TakeGlassData ");
		sb.append("           ,S_SE_SB_SalesDatetime ");
		sb.append("           ,S_SE_SB_OrdersType ");
		sb.append("           ,S_SE_SB_BallGlassOD ");
		sb.append("           ,S_SE_SB_BallGlassOS ");		
		sb.append("           ,S_SE_SB_PostGlassOD ");
		sb.append("           ,S_SE_SB_PostGlassOS ");
		sb.append("           ,S_SE_SB_AxesOD ");
		sb.append("           ,S_SE_SB_AxesOS ");
		sb.append("           ,S_SE_SB_ADDOD ");		
		sb.append("           ,S_SE_SB_ADDOS ");
		sb.append("           ,S_SE_SB_ArriseGlassOD1 ");
		sb.append("           ,S_SE_SB_ArriseGlassOS1 ");
		sb.append("           ,S_SE_SB_BasisOD1 ");
		sb.append("           ,S_SE_SB_BasisOS1 ");		
		sb.append("           ,S_SE_SB_PrismOD ");
		sb.append("           ,S_SE_SB_PrismOS ");
		sb.append("           ,S_SE_SB_InterHighOD ");
		sb.append("           ,S_SE_SB_InterHighOS ");
		sb.append("           ,S_SE_SB_InterDistanceOD ");		
		sb.append("           ,S_SE_SB_InterDistanceOS ");
		sb.append("           ,S_SE_SB_FarVAOD ");
		sb.append("           ,S_SE_SB_FarVAOS ");
		sb.append("           ,S_SE_SB_CloseVAOD ");
		sb.append("           ,S_SE_SB_CloseVAOS ");		
		sb.append("           ,S_SE_SB_RecipeType ");
		sb.append("           ,S_SE_SB_DignosisRe ");
		sb.append("           ,S_SE_SB_DiameterOD ");
		sb.append("           ,S_SE_SB_DiameterOS ");
		sb.append("           ,S_SE_SB_ConRecipeType ");		
		sb.append("           ,S_SE_SB_SecCheckDate ");
		sb.append("           ,S_SE_SB_SubVisitUnit ");
		sb.append("           ,S_SE_SB_SalesType ");
		sb.append("           ,S_SE_SB_SalerID ");
		sb.append("           ,S_SE_SB_Lryid ");		
		sb.append("           ,S_SE_SB_PosDatetime ");
		sb.append("           ,S_SE_SB_PosID ");
		sb.append("           ,S_SE_SB_PriceSum ");
		sb.append("           ,S_SE_SB_SalesValue ");
		sb.append("           ,S_SE_SB_EyeCurvatureOD1 ");		
		sb.append("           ,S_SE_SB_EyeCurvatureOD2 ");
		sb.append("           ,S_SE_SB_EyeCurvatureOS1 ");
		sb.append("           ,S_SE_SB_EyeCurvatureOS2 ");
		sb.append("           ,S_SE_SB_DiscountRate ");
		sb.append("           ,S_SE_SB_DiscountNum ");		
		sb.append("           ,S_SE_SB_Psalsvalue ");
		sb.append("           ,S_SE_SB_ArrearsValue ");
		sb.append("           ,S_SE_SB_Location ");
		sb.append("           ,S_SE_SB_ArrivedDate ");
		sb.append("           ,S_SE_SB_ValueFlag ");		
		sb.append("           ,S_SE_SB_CheckoutFlag ");
		sb.append("           ,S_SE_SB_InTransit ");
		sb.append("           ,S_SE_SB_WithdrawDate ");
		sb.append("           ,S_SE_SB_WithdrawFlag ");
		sb.append("           ,S_SE_SB_WithdrawPersonID ");		
		sb.append("           ,S_SE_SB_MovementType ");
		sb.append("           ,S_SE_SB_ArrearsAppendDate ");
		sb.append("           ,S_SE_SB_ArrearsDate ");
		sb.append("           ,S_SE_SB_PayCash ");
		sb.append("           ,S_SE_SB_BankCard ");		
		sb.append("           ,S_SE_SB_StoredCard ");
		sb.append("           ,S_SE_SB_Renums ");
		sb.append("           ,S_SE_SB_DiscountType ");
		sb.append("           ,S_SE_SB_DiscountPerson ");
		sb.append("           ,S_SE_SB_DragsType ");		
		sb.append("           ,S_SE_SB_PupilHeightOD ");
		sb.append("           ,S_SE_SB_PupilHeightOS ");
		sb.append("           ,S_SE_SB_FavorableAmount ");
		sb.append("           ,S_SE_SB_WorryType ");
		sb.append("           ,S_SE_SB_Integral ");		
		sb.append("           ,S_SE_SB_SetMealID ");
		sb.append("           ,S_SE_SB_ExecStandard ");
		sb.append("           ,S_SE_SB_SalesRemark ");
		sb.append("           ,S_SE_SB_IntegralPrice ");
		sb.append("           ,S_SE_SB_SourceSalesID ");		
		sb.append("           ,S_SE_SB_SwapGoodsFlag ");
		sb.append("           ,S_SE_SB_ProcessDepartment ");
		sb.append("           ,S_SE_SB_PrintSMFlag ");
		sb.append("           ,S_SE_SB_Diagonalline ");
		sb.append("           ,S_SE_SB_Frameform ");		
		sb.append("           ,S_SE_SB_Framemiddlesize ");
		sb.append("           ,S_SE_SB_Galssroad ");
		sb.append("           ,S_SE_SB_Glasshige ");
		sb.append("           ,S_SE_SB_Glasswigth ");
		sb.append("           ,S_SE_SB_Oldeyesize ");		
		sb.append("           ,S_SE_SB_DueIntegral ");
		sb.append("           ,S_SE_SB_SetMealName ");
		sb.append("           ,S_SE_SB_AdditionalName ");
		sb.append("           ,S_SE_SB_Additional ");
		sb.append("           ,S_SE_SB_SetMealFlag ");		
		sb.append("           ,S_SE_SB_PrintFldID ");
		sb.append("           ,S_SE_SB_JFAmount ");
		sb.append("           ,S_SE_SB_FrameDia ");
		sb.append("           ,S_SE_SB_FrameType ");
		sb.append("           ,S_SE_SB_FrameShape ");		
		sb.append("           ,S_SE_SB_EyeHighOD ");
		sb.append("           ,S_SE_SB_EyeHighOS ");
		sb.append("           ,S_SE_SB_FrameHigh ");
		sb.append("           ,S_SE_SB_FlatWeight ");
		sb.append("           ,S_SE_SB_NoseWeight ");		
		sb.append("           ,S_SE_SB_YishiID ");
		sb.append("           ,S_SE_SB_Djsbm ");
		sb.append("           ,S_SE_SB_DoubleZZflag ");
		sb.append("           ,S_SE_SB_YgsID ");		
		sb.append("           ,S_SE_SB_FactPosDatetime ");
		sb.append("           ,S_SE_SB_FactWithdrawDate ");
		sb.append("           ,S_SE_SB_FactArrearsAppendDate) ");
		
		sb.append("SELECT S_SE_SB_SalesID ");
		sb.append("      ,S_SE_SB_ShopCode ");
		sb.append("      ,S_SE_SB_CustomerID ");		
		sb.append("      ,S_SE_SB_OptID ");
		sb.append("      ,S_SE_SB_OptometryID ");
		sb.append("      ,S_SE_SB_InspectionID ");
		sb.append("      ,S_SE_SB_TakeGlassData ");
		sb.append("      ,S_SE_SB_SalesDatetime ");		
		sb.append("      ,S_SE_SB_OrdersType ");
		sb.append("      ,S_SE_SB_BallGlassOD ");
		sb.append("      ,S_SE_SB_BallGlassOS ");
		sb.append("      ,S_SE_SB_PostGlassOD ");
		sb.append("      ,S_SE_SB_PostGlassOS ");		
		sb.append("      ,S_SE_SB_AxesOD ");
		sb.append("      ,S_SE_SB_AxesOS ");
		sb.append("      ,S_SE_SB_ADDOD ");
		sb.append("      ,S_SE_SB_ADDOS ");
		sb.append("      ,S_SE_SB_ArriseGlassOD1 ");		
		sb.append("      ,S_SE_SB_ArriseGlassOS1 ");
		sb.append("      ,S_SE_SB_BasisOD1 ");
		sb.append("      ,S_SE_SB_BasisOS1 ");
		sb.append("      ,S_SE_SB_PrismOD ");
		sb.append("      ,S_SE_SB_PrismOS ");		
		sb.append("      ,S_SE_SB_InterHighOD ");
		sb.append("      ,S_SE_SB_InterHighOS ");
		sb.append("      ,S_SE_SB_InterDistanceOD ");
		sb.append("      ,S_SE_SB_InterDistanceOS ");
		sb.append("      ,S_SE_SB_FarVAOD ");		
		sb.append("      ,S_SE_SB_FarVAOS ");
		sb.append("      ,S_SE_SB_CloseVAOD ");
		sb.append("      ,S_SE_SB_CloseVAOS ");
		sb.append("      ,S_SE_SB_RecipeType ");
		sb.append("      ,S_SE_SB_DignosisRe ");		
		sb.append("      ,S_SE_SB_DiameterOD ");
		sb.append("      ,S_SE_SB_DiameterOS ");
		sb.append("      ,S_SE_SB_ConRecipeType ");
		sb.append("      ,S_SE_SB_SecCheckDate ");
		sb.append("      ,S_SE_SB_SubVisitUnit ");		
		sb.append("      ,S_SE_SB_SalesType ");
		sb.append("      ,S_SE_SB_SalerID ");
		sb.append("      ,S_SE_SB_Lryid ");
		sb.append("      ,S_SE_SB_PosDatetime ");
		sb.append("      ,S_SE_SB_PosID ");		
		sb.append("      ,S_SE_SB_PriceSum ");
		sb.append("      ,S_SE_SB_SalesValue ");
		sb.append("      ,S_SE_SB_EyeCurvatureOD1 ");
		sb.append("      ,S_SE_SB_EyeCurvatureOD2 ");
		sb.append("      ,S_SE_SB_EyeCurvatureOS1 ");		
		sb.append("      ,S_SE_SB_EyeCurvatureOS2 ");
		sb.append("      ,S_SE_SB_DiscountRate ");
		sb.append("      ,S_SE_SB_DiscountNum ");
		sb.append("      ,S_SE_SB_Psalsvalue ");
		sb.append("      ,S_SE_SB_ArrearsValue ");		
		sb.append("      ,S_SE_SB_Location ");
		sb.append("      ,S_SE_SB_ArrivedDate ");
		sb.append("      ,S_SE_SB_ValueFlag ");
		sb.append("      ,S_SE_SB_CheckoutFlag ");
		sb.append("      ,S_SE_SB_InTransit ");		
		sb.append("      ,S_SE_SB_WithdrawDate ");
		sb.append("      ,S_SE_SB_WithdrawFlag ");
		sb.append("      ,S_SE_SB_WithdrawPersonID ");
		sb.append("      ,S_SE_SB_MovementType ");
		sb.append("      ,S_SE_SB_ArrearsAppendDate ");		
		sb.append("      ,S_SE_SB_ArrearsDate ");
		sb.append("      ,S_SE_SB_PayCash ");
		sb.append("      ,S_SE_SB_BankCard ");
		sb.append("      ,S_SE_SB_StoredCard ");
		sb.append("      ,S_SE_SB_Renums ");		
		sb.append("      ,S_SE_SB_DiscountType ");
		sb.append("      ,S_SE_SB_DiscountPerson ");
		sb.append("      ,S_SE_SB_DragsType ");
		sb.append("      ,S_SE_SB_PupilHeightOD ");
		sb.append("      ,S_SE_SB_PupilHeightOS ");		
		sb.append("      ,S_SE_SB_FavorableAmount ");
		sb.append("      ,S_SE_SB_WorryType ");
		sb.append("      ,S_SE_SB_Integral ");
		sb.append("      ,S_SE_SB_SetMealID ");
		sb.append("      ,S_SE_SB_ExecStandard ");		
		sb.append("      ,S_SE_SB_SalesRemark ");
		sb.append("      ,S_SE_SB_IntegralPrice ");
		sb.append("      ,S_SE_SB_SourceSalesID ");
		sb.append("      ,S_SE_SB_SwapGoodsFlag ");
		sb.append("      ,S_SE_SB_ProcessDepartment ");		
		sb.append("      ,S_SE_SB_PrintSMFlag ");
		sb.append("      ,S_SE_SB_Diagonalline ");
		sb.append("      ,S_SE_SB_Frameform ");
		sb.append("      ,S_SE_SB_Framemiddlesize ");
		sb.append("      ,S_SE_SB_Galssroad ");		
		sb.append("      ,S_SE_SB_Glasshige ");
		sb.append("      ,S_SE_SB_Glasswigth ");
		sb.append("      ,S_SE_SB_Oldeyesize ");		
		sb.append("      ,S_SE_SB_DueIntegral ");
		sb.append("      ,S_SE_SB_SetMealName ");
		sb.append("      ,S_SE_SB_AdditionalName ");
		sb.append("      ,S_SE_SB_Additional ");
		sb.append("      ,S_SE_SB_SetMealFlag ");
		sb.append("      ,S_SE_SB_PrintFldID ");
		sb.append("      ,S_SE_SB_JFAmount ");
		sb.append("      ,S_SE_SB_FrameDia ");
		sb.append("      ,S_SE_SB_FrameType ");
		sb.append("      ,S_SE_SB_FrameShape ");
		sb.append("      ,S_SE_SB_EyeHighOD ");
		sb.append("      ,S_SE_SB_EyeHighOS ");
		sb.append("      ,S_SE_SB_FrameHigh ");
		sb.append("      ,S_SE_SB_FlatWeight ");
		sb.append("      ,S_SE_SB_NoseWeight ");
		sb.append("      ,S_SE_SB_YishiID ");
		sb.append("      ,S_SE_SB_Djsbm ");
		sb.append("      ,S_SE_SB_DoubleZZflag ");
		sb.append("      ,S_SE_SB_YgsID ");
		sb.append("      ,S_SE_SB_FactPosDatetime ");
		sb.append("      ,S_SE_SB_FactWithdrawDate ");
		sb.append("      ,S_SE_SB_FactArrearsAppendDate ");
		sb.append("  FROM S_SE_SalesBasic ");
		sb.append("  where S_SE_SB_SalesID = ? ");

		params.add(salesID);
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 将配镜单明细送至已完结的表中
	 */
	public void insertSalesDetailFinished(String salesID){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("INSERT INTO S_SE_SalesDetail_Finished ");
		sb.append("           (S_SE_SD_ID ");
		sb.append("           ,S_SE_SD_SalesID ");
		sb.append("           ,S_SE_SD_SalesItemID ");
		sb.append("           ,S_SE_SD_ItemID ");
		sb.append("           ,S_SE_SD_StockId ");
		sb.append("           ,S_SE_SD_SalesItemName ");
		sb.append("           ,S_SE_SD_SPrice ");
		sb.append("           ,S_SE_SD_Number ");
		sb.append("           ,S_SE_SD_UnitPrice ");
		sb.append("           ,S_SE_SD_CostsPrive ");
		sb.append("           ,S_SE_SD_PriceSum ");
		sb.append("           ,S_SE_SD_SalesValue ");
		sb.append("           ,S_SE_SD_DiscountRate ");
		sb.append("           ,S_SE_SD_DiscountNum ");
		sb.append("           ,S_SE_SD_GoodDescribe ");
		sb.append("           ,S_SE_SD_GlassFlag ");
		sb.append("           ,S_SE_SD_CommoditiesFlag ");
		sb.append("           ,S_SE_SD_Updatetime ");
		sb.append("           ,S_SE_SD_LargessFlag ");
		sb.append("           ,S_SE_SD_Renums ");
		sb.append("           ,S_SE_SD_DiscountType ");
		sb.append("           ,S_SE_SD_DiscountSource ");
		sb.append("           ,S_SE_SD_InStockId ");
		sb.append("           ,S_SE_SD_Favorable ");
		sb.append("           ,S_SE_SD_Integral ");
		sb.append("           ,S_SE_SD_OutStorageFlag ");
		sb.append("           ,S_SE_SD_InStorageFlag ");
		sb.append("           ,S_SE_SD_Guaranteeperiod ");
		sb.append("           ,S_SE_SD_Batch ");
		sb.append("           ,S_SE_SD_ExchageFlag ");
		sb.append("           ,S_SE_SD_WithdrawFlag ");
		sb.append("           ,S_SE_SD_WithdrawDate ");
		sb.append("           ,S_SE_SD_WithdrawPersonID ");
		sb.append("           ,S_SE_SD_Setmealid ");
		sb.append("           ,S_SE_SD_Setmealidno ");
		sb.append("           ,S_SE_SD_IsHaveStock ");
		sb.append("           ,S_SE_SD_IsPurchaseCollect ");
		sb.append("           ,S_SE_SD_IsReturnPurchaseCollect ");
		sb.append("           ,S_SE_SD_VipCard ");
		sb.append("           ,S_SE_SD_HardValue ");
		sb.append("           ,S_SE_SD_RegistrationNum) ");
		sb.append("SELECT S_SE_SD_ID ");
		sb.append("      ,S_SE_SD_SalesID ");
		sb.append("      ,S_SE_SD_SalesItemID ");
		sb.append("      ,S_SE_SD_ItemID ");
		sb.append("      ,S_SE_SD_StockId ");
		sb.append("      ,S_SE_SD_SalesItemName ");
		sb.append("      ,S_SE_SD_SPrice ");
		sb.append("      ,S_SE_SD_Number ");
		sb.append("      ,S_SE_SD_UnitPrice ");
		sb.append("      ,S_SE_SD_CostsPrive ");
		sb.append("      ,S_SE_SD_PriceSum ");
		sb.append("      ,S_SE_SD_SalesValue ");
		sb.append("      ,S_SE_SD_DiscountRate ");
		sb.append("      ,S_SE_SD_DiscountNum ");
		sb.append("      ,S_SE_SD_GoodDescribe ");
		sb.append("      ,S_SE_SD_GlassFlag ");
		sb.append("      ,S_SE_SD_CommoditiesFlag ");
		sb.append("      ,S_SE_SD_Updatetime ");
		sb.append("      ,S_SE_SD_LargessFlag ");
		sb.append("      ,S_SE_SD_Renums ");
		sb.append("      ,S_SE_SD_DiscountType ");
		sb.append("      ,S_SE_SD_DiscountSource ");
		sb.append("      ,S_SE_SD_InStockId ");
		sb.append("      ,S_SE_SD_Favorable ");
		sb.append("      ,S_SE_SD_Integral ");
		sb.append("      ,S_SE_SD_OutStorageFlag ");
		sb.append("      ,S_SE_SD_InStorageFlag ");
		sb.append("      ,S_SE_SD_Guaranteeperiod ");
		sb.append("      ,S_SE_SD_Batch ");
		sb.append("      ,S_SE_SD_ExchageFlag ");
		sb.append("      ,S_SE_SD_WithdrawFlag ");
		sb.append("      ,S_SE_SD_WithdrawDate ");
		sb.append("      ,S_SE_SD_WithdrawPersonID ");
		sb.append("      ,S_SE_SD_Setmealid ");
		sb.append("      ,S_SE_SD_Setmealidno ");
		sb.append("      ,S_SE_SD_IsHaveStock ");
		sb.append("      ,S_SE_SD_IsPurchaseCollect ");
		sb.append("      ,S_SE_SD_IsReturnPurchaseCollect ");
		sb.append("      ,S_SE_SD_VipCard ");
		sb.append("      ,S_SE_SD_HardValue ");
		sb.append("      ,S_SE_SD_RegistrationNum ");
		sb.append("  FROM S_SE_SalesDetail ");
		sb.append("  where S_SE_SD_SalesID = ? ");
		
		params.add(salesID);
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 将配镜单送至已完结的表中
	 */
	public void deleteSalesBasic(String salesID){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from S_SE_SalesBasic where S_SE_SB_SalesID = ? ");

		params.add(salesID);
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 将配镜单明细送至已完结的表中
	 */
	public void deleteSalesDetail(String salesID){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from S_SE_SalesDetail where S_SE_SD_SalesID = ? ");

		params.add(salesID);
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public void insertTakeMsg(TakeMsgPo takeMsgPo){
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into S_SE_Sales_TakeMsg (id,S_SE_ST_SalesID,S_SE_ST_Phone,S_SE_ST_Name,S_SE_ST_IdentityCard,S_SE_ST_Remark,S_SE_ST_updateDate) ");
		buffer.append("values (? , ? , ? , ? , ? , ? , getdate()) ");

		params.add(this.uuid.generate());
		params.add(takeMsgPo.getSalesid());
		params.add(takeMsgPo.getPhone());
		params.add(takeMsgPo.getName());
		params.add(takeMsgPo.getIdentitycard());
		params.add(takeMsgPo.getRemark());

		getJdbcTemplate().update(buffer.toString(), params.toArray());		
	}	
	
	public int getTakeMsgCount(TakeMsgPo takeMsgPo){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT count(S_SE_ST_SalesID) ");
		sb.append("FROM   S_SE_Sales_TakeMsg ");
		sb.append("       INNER JOIN S_SE_InTransit ");
		sb.append("         ON S_SE_IT_SalesID = S_SE_ST_SalesID ");
		sb.append("       LEFT JOIN SYS_PersonInfo p ");
		sb.append("         ON S_SE_IT_CreatePerson = p.ID ");
		sb.append("       LEFT JOIN B_Departments d ");
		sb.append("         ON S_SE_IT_Department = d.B_DP_DepartmentID ");
		sb.append("WHERE  S_SE_IT_State = '13' ");
		
		if (!"".equals(Utility.getName(takeMsgPo.getSalesid()))) {
			sb.append("and S_SE_ST_SalesID like '%' + ? + '%' ");
			params.add(takeMsgPo.getSalesid());
		}

		if (!"".equals(Utility.getName(takeMsgPo.getName()))) {
			sb.append("and S_SE_ST_Name like '%' + ? + '%' ");
			params.add(takeMsgPo.getName());
		}
		
		if (!"".equals(Utility.getName(takeMsgPo.getPhone()))) {
			sb.append("and S_SE_ST_Phone like '%' + ? + '%' ");
			params.add(takeMsgPo.getPhone());
		}

		if (!"".equals(Utility.getName(takeMsgPo.getIdentitycard()))) {
			sb.append("and S_SE_ST_IdentityCard like '%' + ? + '%' ");
			params.add(takeMsgPo.getIdentitycard());
		}
		
		if (!"".equals(Utility.getName(takeMsgPo.getPagestarttime()))) {
			sb.append("and convert(varchar(10), S_SE_ST_updateDate, 23) >= ? ");
			params.add(takeMsgPo.getPagestarttime());
		}
		
		if (!"".equals(Utility.getName(takeMsgPo.getPageendtime()))) {
			sb.append("and convert(varchar(10), S_SE_ST_updateDate, 23) <= ? ");
			params.add(takeMsgPo.getPageendtime());
		}

		if (!"".equals(Utility.getName(takeMsgPo.getRemark()))) {
			sb.append("and S_SE_ST_Remark like '%' + ? + '%' ");
			params.add(takeMsgPo.getRemark());
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(),
				params.toArray());
	}
	public List<TakeMsgPo> selectTakeMsgList(TakeMsgPo takeMsgPo , int start , int size){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT S_SE_ST_SalesID as salesid, ");
		sb.append("       S_SE_ST_Name as name, ");
		sb.append("       S_SE_ST_Phone as phone, ");
		sb.append("       S_SE_ST_IdentityCard as identitycard, ");
		sb.append("       S_SE_ST_updateDate as updateDate, ");
		sb.append("       S_SE_ST_Remark as remark, ");
		sb.append("       p.personName as doperson, ");
		sb.append("       B_DP_DepartmentName as dodepartmentname ");
		sb.append("FROM   S_SE_Sales_TakeMsg ");
		sb.append("       INNER JOIN S_SE_InTransit ");
		sb.append("         ON S_SE_IT_SalesID = S_SE_ST_SalesID ");
		sb.append("       LEFT JOIN SYS_PersonInfo p ");
		sb.append("         ON S_SE_IT_CreatePerson = p.ID ");
		sb.append("       LEFT JOIN B_Departments d ");
		sb.append("         ON S_SE_IT_Department = d.B_DP_DepartmentID ");
		sb.append("WHERE  S_SE_IT_State = '13' ");
		
		if (!"".equals(Utility.getName(takeMsgPo.getSalesid()))) {
			sb.append("and S_SE_ST_SalesID like '%' + ? + '%' ");
			params.add(takeMsgPo.getSalesid());
		}

		if (!"".equals(Utility.getName(takeMsgPo.getName()))) {
			sb.append("and S_SE_ST_Name like '%' + ? + '%' ");
			params.add(takeMsgPo.getName());
		}
		
		if (!"".equals(Utility.getName(takeMsgPo.getPhone()))) {
			sb.append("and S_SE_ST_Phone like '%' + ? + '%' ");
			params.add(takeMsgPo.getPhone());
		}

		if (!"".equals(Utility.getName(takeMsgPo.getIdentitycard()))) {
			sb.append("and S_SE_ST_IdentityCard like '%' + ? + '%' ");
			params.add(takeMsgPo.getIdentitycard());
		}
		
		if (!"".equals(Utility.getName(takeMsgPo.getPagestarttime()))) {
			sb.append("and convert(varchar(10), S_SE_ST_updateDate, 23) >= ? ");
			params.add(takeMsgPo.getPagestarttime());
		}
		
		if (!"".equals(Utility.getName(takeMsgPo.getPageendtime()))) {
			sb.append("and convert(varchar(10), S_SE_ST_updateDate, 23) <= ? ");
			params.add(takeMsgPo.getPageendtime());
		}

		if (!"".equals(Utility.getName(takeMsgPo.getRemark()))) {
			sb.append("and S_SE_ST_Remark like '%' + ? + '%' ");
			params.add(takeMsgPo.getRemark());
		}
		
		return queryForObjectList(sb.toString(), params.toArray(),
				TakeMsgPo.class);
	}
	
}
