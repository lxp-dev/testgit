/**
 * 
 */
package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.FrameSalesDao;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesRecipeNumViewPo;
import com.pengsheng.eims.sales.persistence.ToMailPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author Liuqian
 * 
 */
public class FrameSalesDaoImpl extends BaseJdbcDaoSupport implements
		FrameSalesDao {

	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT top 1 ");
		buffer.append("s1.S_ME_CI_CustomerID as smecicustomerid,");
		buffer.append("s1.S_ME_CI_Name as smeciname,");
		buffer.append("s1.S_ME_CI_Sex as smecisex,");
		buffer.append("s1.S_ME_CI_Birthday as smecibirthday,");
		buffer.append("year(getdate())-year(s1.S_ME_CI_Birthday) as fmmage,");
		buffer.append("s1.S_ME_CI_Email as smeciemail,");
		buffer.append("s1.S_ME_CI_Address as smeciaddress,");
		buffer.append("s1.S_ME_CI_Zone as smecizone,");
		buffer.append("s1.S_ME_CI_PostCode as smecipostcode,");
		buffer.append("s1.S_ME_CI_Phone as smeciphone,");
		buffer.append("s1.S_ME_CI_MemberId as smecimemberid,");
		buffer.append("case ");
		buffer.append(" when isnull(s1.S_ME_CI_FCustomerID,'') <> '' then isnull(s2.S_ME_CI_Integral,0) ");
		buffer.append(" else isnull(s1.S_ME_CI_Integral,0) end as smeciintegral, ");
		buffer.append("s1.S_ME_CI_ShopCode as smecishopcode,");
		buffer.append("F_MM_MemberName as fmmmembername,");
		buffer.append("F_MM_UP as fmmup,");
		buffer.append("F_MM_DOWN as fmmdown,");
		buffer.append("F_MM_Discount as fmmdiscount,");
		buffer.append("s1.S_ME_CI_CardType as smecicardtype,isnull(F_MM_IsFavorable,'0') as smeciisfavorable, ");
		buffer.append("s1.S_ME_CI_FCustomerId as smecifcustomerid, ");
		buffer.append("F_MM_GoodsCategoryID as smecigoodscategoryid ");
		buffer.append(" FROM S_ME_CustomerInfo s1 ");
		buffer.append("left join F_MemberManagement a ");
		buffer.append("on F_MM_ID = s1.S_ME_CI_CardType ");
		buffer.append("left join S_ME_CustomerInfo s2 on s2.S_ME_CI_CustomerID = s1.S_ME_CI_FCustomerID ");

		buffer.append("  where 1=1 ");
		if (!"".equals(Utility.getName(po.getSmecicustomerid()))) {
			buffer.append("and s1.S_ME_CI_CustomerID = '"
					+ po.getSmecicustomerid() + "'");
		}
		if (!"".equals(Utility.getName(po.getSmecimemberid()))) {
			buffer.append(" and s1.S_ME_CI_MemberId = '" + po.getSmecimemberid()
					+ "'");
		}
		
		if(!"".equals(Utility.getName(po.getSmeciflag()))){
			buffer.append(" and s1.S_ME_CI_Flag = '" + po.getSmeciflag() + "' ");
		}
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			buffer.append(" and s1.S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}

		return (CustomerInfoPo) queryForObject(buffer.toString(),params.toArray(),CustomerInfoPo.class);
	}


	public List<InspectionPo> getInspectionPos(String customerID) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select personName as sopipersonname ");
		buffer.append(", S_OP_OY_Time as sopiptime ");
		buffer.append(", S_OP_IP_CustomerID as sopipcustomerid  ");
		buffer.append(", S_OP_IP_ID as sopipid  ");
		buffer.append(", S_OP_IP_OptometryBasicID as sopipoptometrybasicid  ");
		buffer.append(", S_OP_IP_OptometryID as sopipoptometryid ");
		buffer.append(", S_OP_IP_GlassType as sopipglasstype  ");
		buffer.append(", S_OP_IP_BallGlassOD as sopipballglassod ");
		buffer.append(", S_OP_IP_BallGlassOS as sopipballglassos ");
		buffer.append(", S_OP_IP_PostGlassOD as sopippostglassod ");
		buffer.append(", S_OP_IP_PostGlassOS as sopippostglassos ");
		buffer.append(", S_OP_IP_AxesOD as sopipaxesod  ");
		buffer.append(", S_OP_IP_AxesOS as sopipaxesos  ");
		buffer.append(", S_OP_IP_ADDOD as sopipaddod ");
		buffer.append(", S_OP_IP_ADDOS as sopipaddos ");
		buffer.append(", S_OP_IP_ArriseGlassOD1 as sopiparriseglassod1 ");
		buffer.append(", S_OP_IP_ArriseGlassOS1 as sopiparriseglassos1 ");
		buffer.append(", S_OP_IP_BasisOD1 as sopipbasisod1 ");
		buffer.append(", S_OP_IP_BasisOS1 as sopipbasisos1 ");
		buffer.append(", S_OP_IP_PrismOD as sopipprismod  ");
		buffer.append(", S_OP_IP_PrismOS as sopipprismos  ");
		buffer.append(", S_OP_IP_InterHighOD as sopipinterhighod ");
		buffer.append(", S_OP_IP_InterHighOS as sopipinterhighos ");
		buffer.append(", S_OP_IP_InterDistanceOD as sopipinterdistanceod ");
		buffer.append(", S_OP_IP_InterDistanceOS as sopipinterdistanceos  ");
		buffer.append(", S_OP_IP_FarVAOD as sopipfarvaod  ");
		buffer.append(", S_OP_IP_FarVAOS as sopipfarvaos  ");
		buffer.append(", S_OP_IP_CloseVAOD as sopipclosevaod  ");
		buffer.append(", S_OP_IP_CloseVAOS as sopipclosevaos  ");
		buffer.append(", S_OP_IP_EyeCurvatureOD1 as sopipeyecurvatureod1 ");
		buffer.append(", S_OP_IP_EyeCurvatureOD2 as sopipeyecurvatureod2  ");
		buffer.append(", S_OP_IP_EyeCurvatureOS1 as sopipeyecurvatureos1  ");
		buffer.append(", S_OP_IP_EyeCurvatureOS2 as sopipeyecurvatureos2  ");
		buffer.append(", S_OP_IP_DiameterOD as sopipdiameterod  ");
		buffer.append(", S_OP_IP_DiameterOS as sopipdiameteros  ");
		buffer.append(", S_OP_IP_ConLenVAOD as sopipconlenvaod  ");
		buffer.append(", S_OP_IP_ConLenVAOS as sopipconlenvaos  ");
		buffer.append(", S_OP_IP_CommendGlasses as sopipcommendglasses ");
		buffer.append(", S_OP_IP_suggestFrame as sopipsuggestframe  ");
		buffer.append(", S_OP_IP_frameHeight as sopipframeheight ");
		buffer.append(", S_OP_IP_GlassMaterial as sopipglassmaterial ");
		buffer.append(", S_OP_IP_RecipeType as sopiprecipetype  ");
		buffer.append(", S_OP_IP_DisposeManner as sopipdisposemanner  ");
		buffer.append(", S_OP_IP_DignosisRe as sopipdignosisre  ");
		buffer.append(", S_OP_IP_ConRecipeType as sopipconrecipetype  ");
		buffer.append(", S_OP_IP_SecCheckDate as sopipseccheckdate  ");
		buffer.append(", S_OP_IP_SubVisitUnit as sopipsubvisitunit  ");
		buffer.append(", S_OP_IP_UserName as sopipusername ");
		buffer.append(", S_OP_IP_Flag as sopipflag  ");
		buffer.append(", S_OP_IP_conlenosnum as sopipconlenosnum ");
		buffer.append(", S_OP_IP_conlenodnum as sopipconlenodnum ");
		buffer.append(", S_OP_IP_middledistance as sopipmiddledistance ");
		buffer.append(", S_OP_IP_commendcardwater as sopipcommendcardwater ");
		buffer.append("from S_OP_Inspection ");
		buffer.append("inner join S_OP_Optometry ON S_OP_OY_OptometryID = S_OP_IP_OptometryID ");
		buffer.append("inner join SYS_PersonInfo ON SYS_PersonInfo.id = S_OP_IP_UserName ");
		buffer.append("where  S_OP_ip_glasstype in ('1','2','3','5') ");
		buffer.append("and S_OP_IP_OptometryID=( ");
		buffer.append("select top 1 S_OP_OY_OptometryID from S_OP_Optometry ");
		buffer.append("where S_OP_OY_CustomerID = ? ");
		buffer.append("and S_OP_OY_Flag = 1 ");
		buffer.append("order by S_OP_OY_Time desc) ");

		List<String> params = new ArrayList<String>();
		params.add(customerID);

		return queryForObjectList(buffer.toString(), params.toArray(),
				InspectionPo.class);
	}
	
	public List<InspectionPo> getInspectionPosAll(String customerID) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select personName as sopipersonname ");
		buffer.append(", S_OP_OY_Time as sopiptime ");
		buffer.append(", S_OP_IP_CustomerID as sopipcustomerid  ");
		buffer.append(", S_OP_IP_ID as sopipid  ");
		buffer.append(", S_OP_IP_OptometryBasicID as sopipoptometrybasicid  ");
		buffer.append(", S_OP_IP_OptometryID as sopipoptometryid ");
		buffer.append(", S_OP_IP_GlassType as sopipglasstype  ");
		buffer.append(", S_OP_IP_BallGlassOD as sopipballglassod ");
		buffer.append(", S_OP_IP_BallGlassOS as sopipballglassos ");
		buffer.append(", S_OP_IP_PostGlassOD as sopippostglassod ");
		buffer.append(", S_OP_IP_PostGlassOS as sopippostglassos ");
		buffer.append(", S_OP_IP_AxesOD as sopipaxesod  ");
		buffer.append(", S_OP_IP_AxesOS as sopipaxesos  ");
		buffer.append(", S_OP_IP_ADDOD as sopipaddod ");
		buffer.append(", S_OP_IP_ADDOS as sopipaddos ");
		buffer.append(", S_OP_IP_ArriseGlassOD1 as sopiparriseglassod1 ");
		buffer.append(", S_OP_IP_ArriseGlassOS1 as sopiparriseglassos1 ");
		buffer.append(", S_OP_IP_BasisOD1 as sopipbasisod1 ");
		buffer.append(", S_OP_IP_BasisOS1 as sopipbasisos1 ");
		buffer.append(", S_OP_IP_PrismOD as sopipprismod  ");
		buffer.append(", S_OP_IP_PrismOS as sopipprismos  ");
		buffer.append(", S_OP_IP_InterHighOD as sopipinterhighod ");
		buffer.append(", S_OP_IP_InterHighOS as sopipinterhighos ");
		buffer.append(", S_OP_IP_InterDistanceOD as sopipinterdistanceod ");
		buffer.append(", S_OP_IP_InterDistanceOS as sopipinterdistanceos  ");
		buffer.append(", S_OP_IP_FarVAOD as sopipfarvaod  ");
		buffer.append(", S_OP_IP_FarVAOS as sopipfarvaos  ");
		buffer.append(", S_OP_IP_CloseVAOD as sopipclosevaod  ");
		buffer.append(", S_OP_IP_CloseVAOS as sopipclosevaos  ");
		buffer.append(", S_OP_IP_EyeCurvatureOD1 as sopipeyecurvatureod1 ");
		buffer.append(", S_OP_IP_EyeCurvatureOD2 as sopipeyecurvatureod2  ");
		buffer.append(", S_OP_IP_EyeCurvatureOS1 as sopipeyecurvatureos1  ");
		buffer.append(", S_OP_IP_EyeCurvatureOS2 as sopipeyecurvatureos2  ");
		buffer.append(", S_OP_IP_DiameterOD as sopipdiameterod  ");
		buffer.append(", S_OP_IP_DiameterOS as sopipdiameteros  ");
		buffer.append(", S_OP_IP_ConLenVAOD as sopipconlenvaod  ");
		buffer.append(", S_OP_IP_ConLenVAOS as sopipconlenvaos  ");
		buffer.append(", S_OP_IP_CommendGlasses as sopipcommendglasses ");
		buffer.append(", S_OP_IP_suggestFrame as sopipsuggestframe  ");
		buffer.append(", S_OP_IP_frameHeight as sopipframeheight ");
		buffer.append(", S_OP_IP_GlassMaterial as sopipglassmaterial ");
		buffer.append(", S_OP_IP_RecipeType as sopiprecipetype  ");
		buffer.append(", S_OP_IP_DisposeManner as sopipdisposemanner  ");
		buffer.append(", S_OP_IP_DignosisRe as sopipdignosisre  ");
		buffer.append(", S_OP_IP_ConRecipeType as sopipconrecipetype  ");
		buffer.append(", S_OP_IP_SecCheckDate as sopipseccheckdate  ");
		buffer.append(", S_OP_IP_SubVisitUnit as sopipsubvisitunit  ");
		buffer.append(", S_OP_IP_UserName as sopipusername ");
		buffer.append(", S_OP_IP_Flag as sopipflag  ");
		buffer.append(", S_OP_IP_conlenosnum as sopipconlenosnum ");
		buffer.append(", S_OP_IP_conlenodnum as sopipconlenodnum ");
		buffer.append(", S_OP_IP_middledistance as sopipmiddledistance ");
		buffer.append(", S_OP_IP_commendcardwater as sopipcommendcardwater ");
		buffer.append(", S_OP_IP_PupilheightOD as sopippupilheightod ");
		buffer.append(", S_OP_IP_PupilheightOS as sopippupilheightos ");
		buffer.append("from S_OP_Inspection ");
		buffer.append("inner join S_OP_Optometry ON S_OP_OY_OptometryID = S_OP_IP_OptometryID ");
		buffer.append("inner join SYS_PersonInfo ON SYS_PersonInfo.id = S_OP_IP_UserName ");
		buffer.append("where S_OP_IP_OptometryID=( ");
		buffer.append("select top 1 S_OP_OY_OptometryID from S_OP_Optometry ");
		buffer.append("where S_OP_OY_CustomerID = ? ");
		buffer.append("and S_OP_OY_Flag = 1 ");
		buffer.append("order by S_OP_OY_Time desc) ");

		List<String> params = new ArrayList<String>();
		params.add(customerID);

		return queryForObjectList(buffer.toString(), params.toArray(),InspectionPo.class);
	}

	public void insertSalesBasic(SalesBasicPo salesBasicPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO S_SE_SalesBasic ");
		sb.append("            (S_SE_SB_SalesID, ");
		sb.append("             S_SE_SB_ShopCode, ");
		sb.append("             S_SE_SB_CustomerID, ");
		sb.append("             S_SE_SB_OptID, ");
		sb.append("             S_SE_SB_OptometryID, ");
		sb.append("             S_SE_SB_InspectionID, ");
		sb.append("             S_SE_SB_TakeGlassData, ");
		sb.append("             S_SE_SB_SalesDatetime, ");
		sb.append("             S_SE_SB_OrdersType, ");
		sb.append("             S_SE_SB_BallGlassOD, ");
		sb.append("             S_SE_SB_BallGlassOS, ");
		sb.append("             S_SE_SB_PostGlassOD, ");
		sb.append("             S_SE_SB_PostGlassOS, ");
		sb.append("             S_SE_SB_AxesOD, ");
		sb.append("             S_SE_SB_AxesOS, ");
		sb.append("             S_SE_SB_ADDOD, ");
		sb.append("             S_SE_SB_ADDOS, ");
		sb.append("             S_SE_SB_ArriseGlassOD1, ");
		sb.append("             S_SE_SB_ArriseGlassOS1, ");
		sb.append("             S_SE_SB_BasisOD1, ");
		sb.append("             S_SE_SB_BasisOS1, ");
		sb.append("             S_SE_SB_PrismOD, ");
		sb.append("             S_SE_SB_PrismOS, ");
		sb.append("             S_SE_SB_InterHighOD, ");
		sb.append("             S_SE_SB_InterHighOS, ");
		sb.append("             S_SE_SB_InterDistanceOD, ");
		sb.append("             S_SE_SB_InterDistanceOS, ");
		sb.append("             S_SE_SB_FarVAOD, ");
		sb.append("             S_SE_SB_FarVAOS, ");
		sb.append("             S_SE_SB_CloseVAOD, ");
		sb.append("             S_SE_SB_CloseVAOS, ");
		sb.append("             S_SE_SB_RecipeType, ");
		sb.append("             S_SE_SB_DignosisRe, ");
		sb.append("             S_SE_SB_DiameterOD, ");
		sb.append("             S_SE_SB_DiameterOS, ");
		sb.append("             S_SE_SB_ConRecipeType, ");
		sb.append("             S_SE_SB_SecCheckDate, ");
		sb.append("             S_SE_SB_SubVisitUnit, ");
		sb.append("             S_SE_SB_SalesType, ");
		sb.append("             S_SE_SB_SalerID, ");
		sb.append("             S_SE_SB_Lryid, ");
		sb.append("             S_SE_SB_PosDatetime, ");
		sb.append("             S_SE_SB_PosID, ");
		sb.append("             S_SE_SB_PriceSum, ");
		sb.append("             S_SE_SB_SalesValue, ");
		sb.append("             S_SE_SB_EyeCurvatureOD1, ");
		sb.append("             S_SE_SB_EyeCurvatureOD2, ");
		sb.append("             S_SE_SB_EyeCurvatureOS1, ");
		sb.append("             S_SE_SB_EyeCurvatureOS2, ");
		sb.append("             S_SE_SB_DiscountRate, ");
		sb.append("             S_SE_SB_DiscountNum, ");
		sb.append("             S_SE_SB_Psalsvalue, ");
		sb.append("             S_SE_SB_ArrearsValue, ");
		sb.append("             S_SE_SB_Location, ");
		sb.append("             S_SE_SB_ArrivedDate, ");
		sb.append("             S_SE_SB_ValueFlag, ");
		sb.append("             S_SE_SB_CheckoutFlag, ");
		sb.append("             S_SE_SB_InTransit, ");
		sb.append("             S_SE_SB_WithdrawDate, ");
		sb.append("             S_SE_SB_WithdrawFlag, ");
		sb.append("             S_SE_SB_WithdrawPersonID, ");
		sb.append("             S_SE_SB_MovementType, ");
		sb.append("             S_SE_SB_ArrearsAppendDate, ");
		sb.append("             S_SE_SB_ArrearsDate, ");
		sb.append("             S_SE_SB_PayCash, ");
		sb.append("             S_SE_SB_BankCard, ");
		sb.append("             S_SE_SB_StoredCard, ");
		sb.append("             S_SE_SB_Renums, ");
		sb.append("             S_SE_SB_DiscountType, ");
		sb.append("             S_SE_SB_DiscountPerson, ");
		sb.append("             S_SE_SB_DragsType, ");
		sb.append("             S_SE_SB_PupilHeightOD, ");
		sb.append("             S_SE_SB_PupilHeightOS, ");
		sb.append("             S_SE_SB_FavorableAmount, ");
		sb.append("             S_SE_SB_WorryType, ");
		sb.append("             S_SE_SB_SalesRemark, ");
		sb.append("             S_SE_SB_SourceSalesID, ");
		sb.append("             S_SE_SB_SwapGoodsFlag, ");
		sb.append("             S_SE_SB_Oldeyesize, ");
		sb.append("             S_SE_SB_Glasshige, ");
		sb.append("             S_SE_SB_Glasswigth, ");
		sb.append("             S_SE_SB_Framemiddlesize, ");
		sb.append("             S_SE_SB_Galssroad, ");
		sb.append("             S_SE_SB_Diagonalline, ");
		sb.append("             S_SE_SB_Frameform,S_SE_SB_FrameDia,S_SE_SB_YishiID,S_SE_SB_Djsbm,S_SE_SB_DoubleZZflag,S_SE_SB_YgsID) ");
		sb.append("VALUES     (?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            Getdate(), ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            NULL, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            NULL, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            NULL, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            NULL, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            NULL, ");
		sb.append("            NULL, ");
		sb.append("            '0', ");
		sb.append("            '0', ");
		sb.append("            '0', ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?,?,?,?,?,?) ");

		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid         ()));
		params.add(Utility.getName(salesBasicPo.getSsesbshopcode        ()));
		params.add(Utility.getName(salesBasicPo.getSsesbcustomerid      ()));
		params.add(Utility.getName(salesBasicPo.getSsesboptid           ()));
		params.add(Utility.getName(salesBasicPo.getSsesboptometryid     ()));
		params.add(Utility.getName(salesBasicPo.getSsesbinspectionid    ()));
		params.add(Utility.getName(salesBasicPo.getSsesbtakeglassdata   ()));
		params.add(Utility.getName(salesBasicPo.getSsesborderstype      ()));
		params.add(Utility.getName(salesBasicPo.getSsesbballglassod     ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbballglassos     ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbpostglassod     ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbpostglassos     ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbaxesod          ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbaxesos          ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbaddod           ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbaddos           ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbarriseglassod   ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbarriseglassos   ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbbasisod         ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbbasisos         ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbprismod         ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbprismos         ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbinterhighod     ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbinterhighos     ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbinterdistanceod ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbinterdistanceos ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbfarvaod         ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbfarvaos         ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbclosevaod       ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbclosevaos       ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbrecipetype      ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbdignosisre      ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbdiameterod      ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbdiameteros      ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbconrecipetype   ()));
		params.add(Utility.getName(salesBasicPo.getSsesbsubvisitunit    ()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalestype       ()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalerid         ()));
		params.add(Utility.getName(salesBasicPo.getSsesblryid           ()));
		params.add(Utility.getName(salesBasicPo.getSsesbposid           ()));
		params.add(Utility.getName(salesBasicPo.getSsesbpricesum        ()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesvalue      ()));
		params.add(Utility.getName(salesBasicPo.getSsesbeyecurvatureod1 ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbeyecurvatureod2 ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbeyecurvatureos1 ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbeyecurvatureos2 ()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbdiscountrate    ()));
		params.add(Utility.getName(salesBasicPo.getSsesbdiscountnum     ()));
		params.add(Utility.getName(salesBasicPo.getSsesbpsalsvalue      ()));
		params.add(Utility.getName(salesBasicPo.getSsesbarrearsvalue    ()));
		params.add(Utility.getName(salesBasicPo.getSsesblocation        ()));
		params.add(Utility.getName(salesBasicPo.getSsesbvalueflag       ()));
		params.add(Utility.getName(salesBasicPo.getSsesbcheckoutflag    ()));
		params.add(Utility.getName(salesBasicPo.getSsesbintransit       ()));
		params.add(Utility.getName(salesBasicPo.getSsesbwithdrawflag    ()));
		params.add(Utility.getName(salesBasicPo.getSsesbwithdrawpersonid()));
		params.add(Utility.getName(salesBasicPo.getSsesbmovementtype    ()));
		if("".equals(Utility.getName(salesBasicPo.getSsesbrenums()))){
			params.add(Utility.getName("0"));
		}else{
			params.add(Utility.getName(salesBasicPo.getSsesbrenums()));
		}
		params.add(Utility.getName(salesBasicPo.getSsesbdiscounttype()));			//2012/2/2 零折
		params.add(Utility.getName(salesBasicPo.getSsesbdiscountperson()));			//2012/2/2 零折
		params.add(Utility.getName(salesBasicPo.getSsesbdragstype()));				//委外类型
		params.add(Utility.getName(salesBasicPo.getSsesbpupilheightod()).replace(",", "").trim());			//右眼瞳高
		params.add(Utility.getName(salesBasicPo.getSsesbpupilheightos()).replace(",", "").trim());			//左眼瞳高
		params.add(Utility.getName(salesBasicPo.getSsesbfavorableamount()));		//加急状态
		params.add(Utility.getName(salesBasicPo.getSsesbworrytype()));				//加急状态
		params.add(Utility.getName(salesBasicPo.getSsesbsalesremark()));				//销售备注
		params.add(Utility.getName(salesBasicPo.getSsesbsourcesalesid()));				//关联原单号
		params.add(Utility.getName(salesBasicPo.getSsesbswapgoodsflag()));				//配镜单类型
		params.add(Utility.getName(salesBasicPo.getSsesboldeyesize()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbglasshige()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbglasswigth()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbframemiddlesize()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbgalssroad()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbdiagonalline()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbframeform()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbframedia()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getSsesbyishiid()).replace(",", "").trim());
		params.add(Utility.getName(salesBasicPo.getDjsbm()));
		params.add(Utility.getName(salesBasicPo.getSsesbdoublezz()));
		params.add(Utility.getName(salesBasicPo.getSsesbygsid()));
		
		this.getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	
	public void insertSalesDetail(SalesDetailPo salesDetailPo) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("INSERT INTO S_SE_SalesDetail ");
		buffer.append("(S_SE_SD_ID ");
		buffer.append(",S_SE_SD_SalesID ");
		buffer.append(",S_SE_SD_SalesItemID ");
		buffer.append(",S_SE_SD_ItemID ");
		buffer.append(",S_SE_SD_StockId ");
		buffer.append(",S_SE_SD_SalesItemName ");
		buffer.append(",S_SE_SD_SPrice ");
		buffer.append(",S_SE_SD_Number ");
		buffer.append(",S_SE_SD_UnitPrice ");
		buffer.append(",S_SE_SD_CostsPrive ");
		buffer.append(",S_SE_SD_PriceSum ");
		buffer.append(",S_SE_SD_SalesValue ");
		buffer.append(",S_SE_SD_DiscountRate ");
		buffer.append(",S_SE_SD_DiscountNum ");
		buffer.append(",S_SE_SD_GoodDescribe ");
		buffer.append(",S_SE_SD_GlassFlag ");
		buffer.append(",S_SE_SD_CommoditiesFlag ");
		buffer.append(",S_SE_SD_Updatetime ");
		buffer.append(",S_SE_SD_LargessFlag ");
		buffer.append(",S_SE_SD_Renums ");
		buffer.append(",S_SE_SD_DiscountType ");
		buffer.append(",S_SE_SD_DiscountSource ");
		buffer.append(",S_SE_SD_Favorable ");
		buffer.append(",S_SE_SD_Integral ");
		buffer.append(",S_SE_SD_OutStorageFlag ");
		buffer.append(",S_SE_SD_InStorageFlag ");
		buffer.append(",S_SE_SD_ExchageFlag");
		buffer.append(",S_SE_SD_Guaranteeperiod ");
		buffer.append(",S_SE_SD_Batch ");
		buffer.append(",S_SE_SD_Setmealid ");
		buffer.append(",S_SE_SD_Setmealidno ");
		buffer.append(",S_SE_SD_VipCard ");
		buffer.append(",S_SE_SD_IsHaveStock,S_SE_SD_HardValue,S_SE_SD_RegistrationNum) ");
		buffer.append("VALUES ");
		buffer.append("(?, ?, ?, ?, ?, ?, ?, ? ");
		buffer.append(", ?, ?, ?, ?, ?, ?, ?, ? ");
		buffer.append(", ?, getdate(), ?, ?, ?, ?, ?,?,'0','0', ?, ? ");
		
		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(Utility.getName(salesDetailPo.getSsesdsalesid()));
		params.add(Utility.getName(salesDetailPo.getSsesdsalesitemid()));
		params.add(Utility.getName(salesDetailPo.getSsesditemid()));
		params.add(Utility.getName(salesDetailPo.getSsesdstockid()));
		params.add(Utility.getName(salesDetailPo.getSsesdsalesitemname()));
		params.add(Utility.getName(salesDetailPo.getSsesdsprice()));
		params.add(Utility.getName(salesDetailPo.getSsesdnumber()));
		params.add(Utility.getName(salesDetailPo.getSsesdunitprice()));
		params.add(Utility.getName(salesDetailPo.getSsesdcostsprive()));
		params.add(Utility.getName(salesDetailPo.getSsesdpricesum()));
		params.add(Utility.getName(salesDetailPo.getSsesdsalesvalue()));
		params.add(Utility.getName(salesDetailPo.getSsesddiscountrate()));
		params.add(Utility.getName(salesDetailPo.getSsesddiscountnum()));
		params.add(Utility.getName(salesDetailPo.getSsesdgooddescribe()));
		params.add(Utility.getName(salesDetailPo.getSsesdglassflag()));
		params.add(Utility.getName(salesDetailPo.getSsesdcommoditiesflag()));
		params.add(Utility.getName(salesDetailPo.getSsesdlargessflag()));
		if("".equals(Utility.getName(salesDetailPo.getSsesdrenum()))){
			params.add("0");
		}else{
			params.add(Utility.getName(salesDetailPo.getSsesdrenum()));
		}
		params.add(Utility.getName(salesDetailPo.getSsesddiscounttype()));
		params.add(Utility.getName(salesDetailPo.getSsesddiscountsource()));
		params.add(Utility.getName(salesDetailPo.getSsesdfavorable()));
		params.add(Utility.getName(salesDetailPo.getSsesintegral()).equals("") ? "0" : Utility.getName(salesDetailPo.getSsesintegral()));
		params.add(Utility.getName(salesDetailPo.getSsesdexchageflag()));

		if(!"".equals(Utility.getName(salesDetailPo.getSsesdguaranteeperiod()))){
			buffer.append(",?");
			params.add(Utility.getName(salesDetailPo.getSsesdguaranteeperiod()));
		}
		if("".equals(Utility.getName(salesDetailPo.getSsesdguaranteeperiod()))){
			buffer.append(",?");
			params.add("");
		}
		if(!"".equals(Utility.getName(salesDetailPo.getSsesdbatch()))){
			buffer.append(",?");
			params.add(Utility.getName(salesDetailPo.getSsesdbatch()));
		}
		if("".equals(Utility.getName(salesDetailPo.getSsesdbatch()))){
			buffer.append(",?");
			params.add("");
		}
		
		buffer.append(",?,?,? ");
		
		if (Utility.getName(salesDetailPo.getSsesdhardvalueversion()).equals("2")){
			buffer.append(" ,dbo.getHardValue(?,?,?,?,?) ");
		}else{
			buffer.append(" ,'0' ");
		}
		
		buffer.append(",dbo.ufn_getRegistrationNum(?,?,?) ");
		buffer.append(" ) ");
		
		params.add(Utility.getName(salesDetailPo.getSsesdsetmealid()));
		params.add(Utility.getName(salesDetailPo.getSsesdsetmealidno()));
		params.add(Utility.getName(salesDetailPo.getSsesdvipcard()));
		params.add(Utility.getName(salesDetailPo.getSsesdishavestock()));
		
		if (Utility.getName(salesDetailPo.getSsesdhardvalueversion()).equals("2")){
			params.add(Utility.getName(salesDetailPo.getSsesdsalesitemid())); // getHardValue()  第一个参数:商品代码
			params.add(Utility.getName(salesDetailPo.getSsesdsph()));     // getHardValue()  第二个参数：球镜
			params.add(Utility.getName(salesDetailPo.getSsesdcyl()));     // getHardValue()  第三个参数：柱镜
			params.add(Utility.getName(salesDetailPo.getSsesdarriseglass()));     // getHardValue()  第四个参数：棱镜度
			params.add(Utility.getName(salesDetailPo.getSsesdzzcount())); // getHardValue()  第五个参数：自片数
		}
		
		params.add(Utility.getName(salesDetailPo.getSsesditemid()));
		params.add(Utility.getName(salesDetailPo.getSsesdguaranteeperiod()));
		params.add(Utility.getName(salesDetailPo.getSsesdbatch()));

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
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
		buffer.append("values (? , ? , '1' , getdate() , ? , ?) ");
		
		params.add(this.uuid.generate());
		params.add(inTransitPo.getSseitsalesid());
		params.add(inTransitPo.getSseitcreateperson());
		params.add(inTransitPo.getSseitdepartment());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}


	public void insertCustomize(SalesBasicPo salesBasicPo) {
		
	}
	

	public CustomerInfoPo getAjaxCustomerDiscount(GoodsInfoPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 F_MD_Discount as fmmdiscount from F_MemberManagementDiscountSetUp ");
		buffer.append(" where 1=1 ");
		
		if(!Utility.getName(po.getCustomercardtype()).equals("")){
			buffer.append("    and F_MD_MemberManagementID = ? ");
			params.add(po.getCustomercardtype());
		}
		
		if(!Utility.getName(po.getBgigoodscategoryid()).equals("")){
			buffer.append("    and F_MD_GoodsCategoryID = ? ");
			params.add(po.getBgigoodscategoryid());
		}else{
			buffer.append("    and isnull(F_MD_GoodsCategoryID,'') = '' ");
		}
		
		if(!Utility.getName(po.getBgisupplierid()).equals("")){
			buffer.append("    and F_MD_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}else{
			buffer.append("    and isnull(F_MD_SupplierID,'') = '' ");
		}
		
		if(!Utility.getName(po.getBgibrandid()).equals("")){
			buffer.append("    and F_MD_BrandID = ? ");
			params.add(po.getBgibrandid());
		}else{
			buffer.append("    and isnull(F_MD_BrandID,'') = '' ");
		}
		
		if(!Utility.getName(po.getBgigoodsid()).equals("")){
			buffer.append("    and F_MD_GoodsID = ? ");
			params.add(po.getBgigoodsid());
		}else{
			buffer.append("    and isnull(F_MD_GoodsID,'') = '' ");
		}

		if(!Utility.getName(po.getBgishopcode()).equals("")){
			buffer.append("    and (',' + F_MD_ShopCode + ',') like '%,' + ? + ',%' ");
			params.add(Utility.getName(po.getBgishopcode()));
		}
		
		return (CustomerInfoPo) queryForObject(buffer.toString(), params.toArray(),
				CustomerInfoPo.class);
	}
	
	public CustomerInfoPo getCustomerFType(CustomerInfoPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1 ");

		buffer.append("F_MM_MemberName as fmmmembername,");
		buffer.append("S_ME_CI_CardType as smecicardtype ");
		buffer.append("FROM S_ME_CustomerInfo ");
		buffer.append("left join F_MemberManagement a ");
		buffer.append("on F_MM_ID = S_ME_CI_CardType ");

		buffer.append("  where 1=1 ");
		if (!"".equals(Utility.getName(po.getSmecicustomerid()))) {
			buffer.append("and S_ME_CI_CustomerId = '"
					+ po.getSmecifcustomerid() + "'");
		}

		return (CustomerInfoPo) queryForObject(buffer.toString(), null,
				CustomerInfoPo.class);
	}
	
	/**
	 * 根据会员ID或会员卡号查看该会员是否存在
	 */
	public int getCustomerInfoCount(CustomerInfoPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT count(S_ME_CI_CustomerID) from S_ME_CustomerInfo "); 
		buffer.append("  where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getSmecicustomerid()))) {
			buffer.append(" and S_ME_CI_CustomerID = ? ");
			params.add(Utility.getName(po.getSmecicustomerid()));
		}
		if (!"".equals(Utility.getName(po.getSmecimemberid()))) {
			buffer.append(" and S_ME_CI_MemberId = ? ");
			params.add(Utility.getName(po.getSmecimemberid()));
		}
		
		return this.getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}

	/**
	 * 删除处方显示数量
	 */
	public void deleteSalesRecipeNumView(){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
			
		buffer.append(" delete from B_RecipeNum ");
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	/**
	 * 更新处方显示数量
	 */
	public void updateSalesRecipeNumView(SalesRecipeNumViewPo po){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
			
		buffer.append("insert into B_RecipeNum (B_RN_ID,B_RN_Num) values (?,?) ");
		
		params.add(Utility.getName(po.getBrnid()));
		params.add(Utility.getName(po.getBrnnum()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	/**
	 * 查询处方显示数量
	 */
	public List<SalesRecipeNumViewPo> getSalesRecipeNumViewList(){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select B_RN_ID as brnid,B_RN_Num as brnnum from B_RecipeNum ");
		
		return queryForObjectList(buffer.toString(), params.toArray(),SalesRecipeNumViewPo.class);
	}
	
	public CustomerInfoPo getMemberType(String customerID) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 S_ME_CI_CustomerID as smecicustomerid,S_ME_CI_CardType as smecicardtype from S_ME_CustomerInfo "); 
		buffer.append("  where 1=1  and S_ME_CI_CustomerID = ?");
		params.add(Utility.getName(customerID));


		return (CustomerInfoPo) queryForObject(buffer.toString(), params.toArray(),
				CustomerInfoPo.class);
	}
		
	/**
	 * 销售页面根据会员号，按不同的处方类型查询最近几次的处方
	 */
	public List<InspectionPo> getInspectionRecipeListByType(InspectionPo ipo) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top " + Utility.getName(ipo.getSopiprecipetypenum()) + " personName as sopipersonname ");
		buffer.append(", S_OP_OY_Time as sopiptime ");
		buffer.append(", S_OP_IP_CustomerID as sopipcustomerid  ");
		buffer.append(", S_OP_IP_ID as sopipid  ");
		buffer.append(", S_OP_IP_OptometryBasicID as sopipoptometrybasicid  ");
		buffer.append(", S_OP_IP_OptometryID as sopipoptometryid ");
		buffer.append(", S_OP_IP_GlassType as sopipglasstype  ");
		buffer.append(", S_OP_IP_BallGlassOD as sopipballglassod ");
		buffer.append(", S_OP_IP_BallGlassOS as sopipballglassos ");
		buffer.append(", S_OP_IP_PostGlassOD as sopippostglassod ");
		buffer.append(", S_OP_IP_PostGlassOS as sopippostglassos ");
		buffer.append(", S_OP_IP_AxesOD as sopipaxesod  ");
		buffer.append(", S_OP_IP_AxesOS as sopipaxesos  ");
		buffer.append(", S_OP_IP_ADDOD as sopipaddod ");
		buffer.append(", S_OP_IP_ADDOS as sopipaddos ");
		buffer.append(", S_OP_IP_ArriseGlassOD1 as sopiparriseglassod1 ");
		buffer.append(", S_OP_IP_ArriseGlassOS1 as sopiparriseglassos1 ");
		buffer.append(", S_OP_IP_BasisOD1 as sopipbasisod1 ");
		buffer.append(", S_OP_IP_BasisOS1 as sopipbasisos1 ");
		buffer.append(", S_OP_IP_PrismOD as sopipprismod  ");
		buffer.append(", S_OP_IP_PrismOS as sopipprismos  ");
		buffer.append(", S_OP_IP_InterHighOD as sopipinterhighod ");
		buffer.append(", S_OP_IP_InterHighOS as sopipinterhighos ");
		buffer.append(", S_OP_IP_InterDistanceOD as sopipinterdistanceod ");
		buffer.append(", S_OP_IP_InterDistanceOS as sopipinterdistanceos  ");
		buffer.append(", S_OP_IP_FarVAOD as sopipfarvaod  ");
		buffer.append(", S_OP_IP_FarVAOS as sopipfarvaos  ");
		buffer.append(", S_OP_IP_CloseVAOD as sopipclosevaod  ");
		buffer.append(", S_OP_IP_CloseVAOS as sopipclosevaos  ");
		buffer.append(", S_OP_IP_EyeCurvatureOD1 as sopipeyecurvatureod1 ");
		buffer.append(", S_OP_IP_EyeCurvatureOD2 as sopipeyecurvatureod2  ");
		buffer.append(", S_OP_IP_EyeCurvatureOS1 as sopipeyecurvatureos1  ");
		buffer.append(", S_OP_IP_EyeCurvatureOS2 as sopipeyecurvatureos2  ");
		buffer.append(", S_OP_IP_DiameterOD as sopipdiameterod  ");
		buffer.append(", S_OP_IP_DiameterOS as sopipdiameteros  ");
		buffer.append(", S_OP_IP_ConLenVAOD as sopipconlenvaod  ");
		buffer.append(", S_OP_IP_ConLenVAOS as sopipconlenvaos  ");
		buffer.append(", S_OP_IP_CommendGlasses as sopipcommendglasses ");
		buffer.append(", S_OP_IP_suggestFrame as sopipsuggestframe  ");
		buffer.append(", S_OP_IP_frameHeight as sopipframeheight ");
		buffer.append(", S_OP_IP_GlassMaterial as sopipglassmaterial ");
		buffer.append(", S_OP_IP_RecipeType as sopiprecipetype  ");
		buffer.append(", S_OP_IP_DisposeManner as sopipdisposemanner  ");
		buffer.append(", S_OP_IP_DignosisRe as sopipdignosisre  ");
		buffer.append(", S_OP_IP_ConRecipeType as sopipconrecipetype  ");
		buffer.append(", S_OP_IP_SecCheckDate as sopipseccheckdate  ");
		buffer.append(", S_OP_IP_SubVisitUnit as sopipsubvisitunit  ");
		buffer.append(", S_OP_IP_UserName as sopipusername ");
		buffer.append(", S_OP_IP_Flag as sopipflag  ");
		buffer.append(", S_OP_IP_conlenosnum as sopipconlenosnum ");
		buffer.append(", S_OP_IP_conlenodnum as sopipconlenodnum ");
		buffer.append(", S_OP_IP_middledistance as sopipmiddledistance ");
		buffer.append(", S_OP_IP_commendcardwater as sopipcommendcardwater ");
		buffer.append(", S_OP_IP_PupilheightOD as sopippupilheightod ");
		buffer.append(", S_OP_IP_PupilheightOS as sopippupilheightos ");
		// 角膜塑形处方参数
		buffer.append(", S_OP_IP_UpKOD	                  as sopipupkod	                    ");
		buffer.append(", S_OP_IP_UpKOS	                  as sopipupkos	                    ");
		buffer.append(", S_OP_IP_DownKOD	              as sopipdownkod	                ");
		buffer.append(", S_OP_IP_DownKOS	              as sopipdownkos	                ");
		buffer.append(", S_OP_IP_EOD	                  as sopipeod	                    ");
		buffer.append(", S_OP_IP_EOS	                  as sopipeos	                    ");
		buffer.append(", S_OP_IP_CornealDiameterOD	      as sopipcornealdiameterod         ");
		buffer.append(", S_OP_IP_CornealDiameterOS	      as sopipcornealdiameteros         ");
		buffer.append(", S_OP_IP_K0OD	                  as sopipk0od	                    ");
		buffer.append(", S_OP_IP_K0OS	                  as sopipk0os	                    ");
		buffer.append(", S_OP_IP_K1OD	                  as sopipk1od	                    ");
		buffer.append(", S_OP_IP_K1OS	                  as sopipk1os	                    ");
		buffer.append(", S_OP_IP_K2OD	                  as sopipk2od	                    ");
		buffer.append(", S_OP_IP_K2OS	                  as sopipk2os	                    ");
		buffer.append(", S_OP_IP_UPcOD	                  as sopipupcod	                    ");
		buffer.append(", S_OP_IP_UPcOS	                  as sopipupcos	                    ");
		buffer.append(", S_OP_IP_DowncOD	              as sopipdowncod	                ");
		buffer.append(", S_OP_IP_DowncOS	              as sopipdowncos	                ");
		buffer.append(", S_OP_OY_OneOrMany	              as sopiponeormany	                ");		// 初验复验标识
		
		buffer.append("from S_OP_Inspection ");
		buffer.append("inner join S_OP_Optometry ON S_OP_OY_OptometryID = S_OP_IP_OptometryID ");
		buffer.append("inner join SYS_PersonInfo ON SYS_PersonInfo.id = S_OP_IP_UserName ");
		buffer.append(" where S_OP_OY_Flag = '1' and S_OP_OY_CustomerID = ? and S_OP_IP_GlassType = ? ");
		
		buffer.append(" order by S_OP_OY_Time desc ");

		params.add(Utility.getName(ipo.getSopipcustomerid()));
		params.add(Utility.getName(ipo.getSopipglasstype()));

		return queryForObjectList(buffer.toString(), params.toArray(),InspectionPo.class);
	}
	
	/**
	 * 按不同的处方类型查询最近几次的处方
	 */
	public List<InspectionPo> getInspectionRecipeCountByType(InspectionPo ipo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select B_RN_ID as sopipglasstype ,B_RN_Num as sopiprecipetypenum from B_RecipeNum where 1=1 ");
		if (!"".equals(Utility.getName(ipo.getSopipglasstype()))){
			buffer.append(" and B_RN_ID = ? ");
			params.add(Utility.getName(ipo.getSopipglasstype()));
		}	

		return queryForObjectList(buffer.toString(), params.toArray(),InspectionPo.class);
	}
	
	/**
	 * 查看是否设置过销售页面需要显示的处方数量
	 */
	public int getInspectionRecipeCount(InspectionPo ipo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(B_RN_ID) from B_RecipeNum where 1=1 ");
		if (!"".equals(Utility.getName(ipo.getSopipglasstype()))){
			buffer.append(" and B_RN_ID = ? ");
			params.add(Utility.getName(ipo.getSopipglasstype()));
		}	

		return this.getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	/**
	 *  销售页面根据会员号，按不同的处方类型查询最近几次的处方
	 */
	public List<InspectionPo> getInspectionRecipeList(List<SalesRecipeNumViewPo> list,InspectionPo ipo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if(list!=null && list.size()>0){
			buffer.append("create table #Mytable(tmpid varchar(50)) ");
			SalesRecipeNumViewPo salesRecipeNumViewPo = new SalesRecipeNumViewPo();
			Iterator<SalesRecipeNumViewPo> it = list.iterator();
			while(it.hasNext()){
				salesRecipeNumViewPo = (SalesRecipeNumViewPo)it.next();
				buffer.append("insert INTO            #Mytable ");
				buffer.append("select top " + salesRecipeNumViewPo.getBrnnum());
				buffer.append(" S_OP_IP_ID AS sopipid  ");
				buffer.append("from S_OP_Inspection ");
				buffer.append("inner join S_OP_Optometry ON S_OP_OY_OptometryID = S_OP_IP_OptometryID ");
				buffer.append(" where S_OP_IP_CustomerID = '"+ ipo.getSopipcustomerid() +"' and S_OP_IP_GlassType = '"+ salesRecipeNumViewPo.getBrnid() +"' ");
				buffer.append(" order by S_OP_OY_Time desc ");			
			 }
			
			buffer.append("select personName as sopipersonname ,S_OP_OY_Time as sopiptime ");
			buffer.append(", S_OP_IP_CustomerID as sopipcustomerid  ");
			buffer.append(", S_OP_IP_ID as sopipid  ");
			buffer.append(", S_OP_IP_OptometryBasicID as sopipoptometrybasicid  ");
			buffer.append(", S_OP_IP_OptometryID as sopipoptometryid ");
			buffer.append(", S_OP_IP_GlassType as sopipglasstype  ");
			buffer.append(", S_OP_IP_BallGlassOD as sopipballglassod ");
			buffer.append(", S_OP_IP_BallGlassOS as sopipballglassos ");
			buffer.append(", S_OP_IP_PostGlassOD as sopippostglassod ");
			buffer.append(", S_OP_IP_PostGlassOS as sopippostglassos ");
			buffer.append(", S_OP_IP_AxesOD as sopipaxesod  ");
			buffer.append(", S_OP_IP_AxesOS as sopipaxesos  ");
			buffer.append(", S_OP_IP_ADDOD as sopipaddod ");
			buffer.append(", S_OP_IP_ADDOS as sopipaddos ");
			buffer.append(", S_OP_IP_ArriseGlassOD1 as sopiparriseglassod1 ");
			buffer.append(", S_OP_IP_ArriseGlassOS1 as sopiparriseglassos1 ");
			buffer.append(", S_OP_IP_BasisOD1 as sopipbasisod1 ");
			buffer.append(", S_OP_IP_BasisOS1 as sopipbasisos1 ");
			buffer.append(", S_OP_IP_PrismOD as sopipprismod  ");
			buffer.append(", S_OP_IP_PrismOS as sopipprismos  ");
			buffer.append(", S_OP_IP_InterHighOD as sopipinterhighod ");
			buffer.append(", S_OP_IP_InterHighOS as sopipinterhighos ");
			buffer.append(", S_OP_IP_InterDistanceOD as sopipinterdistanceod ");
			buffer.append(", S_OP_IP_InterDistanceOS as sopipinterdistanceos  ");
			buffer.append(", S_OP_IP_FarVAOD as sopipfarvaod  ");
			buffer.append(", S_OP_IP_FarVAOS as sopipfarvaos  ");
			buffer.append(", S_OP_IP_CloseVAOD as sopipclosevaod  ");
			buffer.append(", S_OP_IP_CloseVAOS as sopipclosevaos  ");
			buffer.append(", S_OP_IP_EyeCurvatureOD1 as sopipeyecurvatureod1 ");
			buffer.append(", S_OP_IP_EyeCurvatureOD2 as sopipeyecurvatureod2  ");
			buffer.append(", S_OP_IP_EyeCurvatureOS1 as sopipeyecurvatureos1  ");
			buffer.append(", S_OP_IP_EyeCurvatureOS2 as sopipeyecurvatureos2  ");
			buffer.append(", S_OP_IP_DiameterOD as sopipdiameterod  ");
			buffer.append(", S_OP_IP_DiameterOS as sopipdiameteros  ");
			buffer.append(", S_OP_IP_ConLenVAOD as sopipconlenvaod  ");
			buffer.append(", S_OP_IP_ConLenVAOS as sopipconlenvaos  ");
			buffer.append(", S_OP_IP_CommendGlasses as   sopipcommendglassesod ");
			buffer.append(", S_OP_IP_CommendGlassesos as sopipcommendglassesos ");
			buffer.append(", S_OP_IP_suggestFrame as sopipsuggestframe  ");
			buffer.append(", S_OP_IP_frameHeight as sopipframeheight ");
			buffer.append(", S_OP_IP_GlassMaterial as sopipglassmaterial ");
			buffer.append(", S_OP_IP_RecipeType as sopiprecipetype  ");
			buffer.append(", S_OP_IP_DisposeManner as sopipdisposemanner  ");
			buffer.append(", S_OP_IP_DignosisRe as sopipdignosisre  ");
			buffer.append(", S_OP_IP_ConRecipeType as sopipconrecipetype  ");
			buffer.append(", S_OP_IP_SecCheckDate as sopipseccheckdate  ");
			buffer.append(", S_OP_IP_SubVisitUnit as sopipsubvisitunit  ");
			buffer.append(", S_OP_IP_UserName as sopipusername ");
			buffer.append(", S_OP_IP_Flag as sopipflag  ");
			buffer.append(", S_OP_IP_conlenosnum as sopipconlenosnum ");
			buffer.append(", S_OP_IP_conlenodnum as sopipconlenodnum ");
			buffer.append(", S_OP_IP_middledistance as sopipmiddledistance ");
			buffer.append(", S_OP_IP_commendcardwater as sopipcommendcardwater ");
			buffer.append(", S_OP_IP_PupilheightOD as sopippupilheightod ");
			buffer.append(", S_OP_IP_PupilheightOS as sopippupilheightos ");
			// 角膜塑形处方参数
			buffer.append(", S_OP_IP_UpKOD	                  as sopipupkod	                    ");
			buffer.append(", S_OP_IP_UpKOS	                  as sopipupkos	                    ");
			buffer.append(", S_OP_IP_DownKOD	              as sopipdownkod	                ");
			buffer.append(", S_OP_IP_DownKOS	              as sopipdownkos	                ");
			buffer.append(", S_OP_IP_EOD	                  as sopipeod	                    ");
			buffer.append(", S_OP_IP_EOS	                  as sopipeos	                    ");
			buffer.append(", S_OP_IP_CornealDiameterOD	      as sopipcornealdiameterod         ");
			buffer.append(", S_OP_IP_CornealDiameterOS	      as sopipcornealdiameteros         ");
			buffer.append(", S_OP_IP_K0OD	                  as sopipk0od	                    ");
			buffer.append(", S_OP_IP_K0OS	                  as sopipk0os	                    ");
			buffer.append(", S_OP_IP_K1OD	                  as sopipk1od	                    ");
			buffer.append(", S_OP_IP_K1OS	                  as sopipk1os	                    ");
			buffer.append(", S_OP_IP_K2OD	                  as sopipk2od	                    ");
			buffer.append(", S_OP_IP_K2OS	                  as sopipk2os	                    ");
			buffer.append(", S_OP_IP_UPcOD	                  as sopipupcod	                    ");
			buffer.append(", S_OP_IP_UPcOS	                  as sopipupcos	                    ");
			buffer.append(", S_OP_IP_DowncOD	              as sopipdowncod	                ");
			buffer.append(", S_OP_IP_DowncOS	              as sopipdowncos	                ");			
			buffer.append(", S_OP_IP_FamilyTrain	          as sopipfamilytrain	            ");
			buffer.append(", S_OP_IP_Trainroom	              as sopiptrainroom	                ");
			
			buffer.append("from S_OP_Inspection ");
			buffer.append("inner join S_OP_Optometry ON S_OP_OY_OptometryID = S_OP_IP_OptometryID ");
			buffer.append("inner join SYS_PersonInfo ON SYS_PersonInfo.id = S_OP_IP_UserName ");
			buffer.append(" where S_OP_IP_ID in (select tmpid from #Mytable) ");
			buffer.append("order by S_OP_OY_Time desc ");
			
			buffer.append("drop table #Mytable");
		}
		
		return queryForObjectList(buffer.toString(), params.toArray(),InspectionPo.class);
	}
	
	public void updateVipCardAdd(String vipcard) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
			
		buffer.append("update S_SE_VIPCard "); 
		buffer.append("set S_SE_VC_UseCount=S_SE_VC_UseCount-1 ");
		buffer.append("where S_SE_VC_ID=?  ");
		buffer.append("and isnull(S_SE_VC_UseCount,'')<>'' ");
		
		params.add(Utility.getName(vipcard));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
		
	}
	
	public void updateVipCardSub(String vipcard) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
			
		buffer.append("update S_SE_VIPCard "); 
		buffer.append("set S_SE_VC_UseCount=S_SE_VC_UseCount+1 ");
		buffer.append("where S_SE_VC_ID=?  ");
		buffer.append("and isnull(S_SE_VC_UseCount,'')<>'' ");
		
		params.add(Utility.getName(vipcard));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
		
	}
	
	/**
	 * 销售页面新增邮寄信息
	 */
	public void insertToMail(ToMailPo toMailPo){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
			
		buffer.append("INSERT INTO S_SE_ToMail "); 
		buffer.append("           (S_SE_TM_UUID "); 
		buffer.append("           ,S_SE_TM_CustomerID "); 
		buffer.append("           ,S_SE_TM_CustomerName "); 
		buffer.append("           ,S_SE_TM_CustomerPhone "); 
		buffer.append("           ,S_SE_TM_MaiilAudit "); 
		buffer.append("           ,S_SE_TM_LinkSalesID "); 
		buffer.append("           ,S_SE_TM_MaiilAddress "); 		
		buffer.append("           ,S_SE_TM_CreatePensonID "); 
		buffer.append("           ,S_SE_TM_CreatePensonName "); 
		buffer.append("           ,S_SE_TM_CreateDate "); 
		buffer.append("           ,S_SE_TM_LinkMan "); 
		buffer.append("           ,S_SE_TM_ToMailListID "); 
		buffer.append("           ,S_SE_TM_AreaCode "); 
		
		buffer.append("           ,S_SE_TM_Provinces ");
		buffer.append("           ,S_SE_TM_City ");
		buffer.append("           ,S_SE_TM_District ");
		buffer.append("           ,S_SE_TM_Street ");
		buffer.append("           ,S_SE_TM_IsSupport ");
		buffer.append("           ,S_SE_TM_SupportValue) ");
		buffer.append("   values ( ?,?,?,?,'0',?,?,?,?,getdate(),?,?,?,?,?,?,?,?,?) "); 
		
		params.add(Utility.getName(toMailPo.getSsetmuuid()));		
		params.add(Utility.getName(toMailPo.getSsetmcustomerid()));
		params.add(Utility.getName(toMailPo.getSsetmcustomername()));
		params.add(Utility.getName(toMailPo.getSsetmcustomerphone()));
		params.add(Utility.getName(toMailPo.getSsetmlinksalesid()));
		params.add(Utility.getName(toMailPo.getSsetmmaiiladdress()));		
		params.add(Utility.getName(toMailPo.getSsetmcreatepensonid()));
		params.add(Utility.getName(toMailPo.getSsetmcreatepensonname()));		
		params.add(Utility.getName(toMailPo.getSsetmlinkman()));
		params.add(Utility.getName(toMailPo.getSsetmtomaillistid()));
		params.add(Utility.getName(toMailPo.getSsetmareacode()));	
		
		params.add(Utility.getName(toMailPo.getSsetmprovinces()));
		params.add(Utility.getName(toMailPo.getSsetmcity()));
		params.add(Utility.getName(toMailPo.getSsetmdistrict()));
		params.add(Utility.getName(toMailPo.getSsetmstreet()));
		params.add(Utility.getName(toMailPo.getSsetmissupport()));
		params.add(Utility.getName(toMailPo.getSsetmsupportvalue()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	

}