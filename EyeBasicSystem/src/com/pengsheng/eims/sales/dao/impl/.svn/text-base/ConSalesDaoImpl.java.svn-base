/**
 * 
 */
package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.ConSalesDao;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author Liuqian
 * 
 */
public class ConSalesDaoImpl extends BaseJdbcDaoSupport implements
		ConSalesDao {

	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1 ");

		buffer.append("S_ME_CI_CustomerID as smecicustomerid,");
		buffer.append("S_ME_CI_Name as smeciname,");
		buffer.append("S_ME_CI_Sex as smecisex,");
		buffer.append("S_ME_CI_Birthday as smecibirthday,");
		buffer.append("S_ME_CI_Email as smeciemail,");
		buffer.append("S_ME_CI_Address as smeciaddress,");
		buffer.append("S_ME_CI_Zone as smecizone,");
		buffer.append("S_ME_CI_PostCode as smecipostcode,");
		buffer.append("S_ME_CI_Phone as smeciphone,");
		buffer.append("S_ME_CI_MemberId as smecimemberid,");
		buffer.append("S_ME_CI_Integral as smeciintegral,");
		buffer.append("S_ME_CI_ShopCode as smecishopcode,");

		buffer.append("F_MM_MemberName as fmmmembername,");
		buffer.append("F_MM_UP as fmmup,");
		buffer.append("F_MM_DOWN as fmmdown,");
		buffer.append("F_MM_Discount as fmmdiscount");

		buffer.append(" FROM S_ME_CustomerInfo ");
		buffer.append("left join F_MemberManagement a ");
		buffer.append("on F_MM_ID =S_ME_CI_CardType ");

		buffer.append("  where 1=1 ");
		if (!"".equals(Utility.getName(po.getSmecicustomerid()))) {
			buffer.append("and S_ME_CI_CustomerID = '"
					+ po.getSmecicustomerid() + "'");
		}
		if (!"".equals(Utility.getName(po.getSmecimemberid()))) {
			buffer.append("and S_ME_CI_MemberId = '" + po.getSmecimemberid()
					+ "'");
		}

		return (CustomerInfoPo) queryForObject(buffer.toString(), null,
				CustomerInfoPo.class);
	}


	public List<InspectionPo> getInspectionPos(String customerID) {
		// TODO Auto-generated method stub

		StringBuffer buffer = new StringBuffer();
		buffer.append("select top 1 ");
		buffer.append("personName as sopipersonname ");
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
		buffer.append(", S_OP_IP_commendcardwater as sopipcommendcardwater  ");
		buffer.append("from S_OP_Inspection ");
		buffer.append(" inner join  S_OP_Optometry ON S_OP_OY_OptometryID = S_OP_IP_OptometryID and S_OP_OY_Flag = '1' and S_OP_OY_CustomerID = ? ");
		buffer.append(" inner join SYS_PersonInfo ");
		buffer.append("ON SYS_PersonInfo.id = S_OP_OY_PersonID ");
		buffer.append("where  S_OP_ip_glasstype = '4' order by S_OP_OY_Time desc ");

		List<String> params = new ArrayList<String>();
		params.add(customerID);

		return queryForObjectList(buffer.toString(), params.toArray(),
				InspectionPo.class);
	}


	public void insertSalesBasic(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO S_SE_SalesBasic ");
		sb.append("values(?,?,?,?,?,?,?,getdate(),?,?,?,");
		sb.append("?,?,?,?,?,?,?,?,?,?,");
		sb.append("?,?,?,?,?,?,?,?,?,?,");
		sb.append("?,?,?,?,?,null,?,?,?,?,");
		sb.append("null,?,?,?,?,?,?,?,?,?,");
		sb.append("?,?,?,null,?,?,?,null,?,?,?");
		sb.append(",null,null,null,null,null,?");
		sb.append(",?,?,'')");//2012/2/2 零折

		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid         ()));
		params.add(Utility.getName(salesBasicPo.getSsesbshopcode        ()));
		params.add(Utility.getName(salesBasicPo.getSsesbcustomerid      ()));
		params.add(Utility.getName(salesBasicPo.getSsesboptid           ()));
		params.add(Utility.getName(salesBasicPo.getSsesboptometryid     ()));
		params.add(Utility.getName(salesBasicPo.getSsesbinspectionid    ()));
		params.add(Utility.getName(salesBasicPo.getSsesbtakeglassdata   ()));
		params.add(Utility.getName(salesBasicPo.getSsesborderstype      ()));
		params.add(Utility.getName(salesBasicPo.getSsesbballglassod     ()));
		params.add(Utility.getName(salesBasicPo.getSsesbballglassos     ()));
		params.add(Utility.getName(salesBasicPo.getSsesbpostglassod     ()));
		params.add(Utility.getName(salesBasicPo.getSsesbpostglassos     ()));
		params.add(Utility.getName(salesBasicPo.getSsesbaxesod          ()));
		params.add(Utility.getName(salesBasicPo.getSsesbaxesos          ()));
		params.add(Utility.getName(salesBasicPo.getSsesbaddod           ()));
		params.add(Utility.getName(salesBasicPo.getSsesbaddos           ()));
		params.add(Utility.getName(salesBasicPo.getSsesbarriseglassod   ()));
		params.add(Utility.getName(salesBasicPo.getSsesbarriseglassos   ()));
		params.add(Utility.getName(salesBasicPo.getSsesbbasisod         ()));
		params.add(Utility.getName(salesBasicPo.getSsesbbasisos         ()));
		params.add(Utility.getName(salesBasicPo.getSsesbprismod         ()));
		params.add(Utility.getName(salesBasicPo.getSsesbprismos         ()));
		params.add(Utility.getName(salesBasicPo.getSsesbinterhighod     ()));
		params.add(Utility.getName(salesBasicPo.getSsesbinterhighos     ()));
		params.add(Utility.getName(salesBasicPo.getSsesbinterdistanceod ()));
		params.add(Utility.getName(salesBasicPo.getSsesbinterdistanceos ()));
		params.add(Utility.getName(salesBasicPo.getSsesbfarvaod         ()));
		params.add(Utility.getName(salesBasicPo.getSsesbfarvaos         ()));
		params.add(Utility.getName(salesBasicPo.getSsesbclosevaod       ()));
		params.add(Utility.getName(salesBasicPo.getSsesbclosevaos       ()));
		params.add(Utility.getName(salesBasicPo.getSsesbrecipetype      ()));
		params.add(Utility.getName(salesBasicPo.getSsesbdignosisre      ()));
		params.add(Utility.getName(salesBasicPo.getSsesbdiameterod      ()));
		params.add(Utility.getName(salesBasicPo.getSsesbdiameteros      ()));
		params.add(Utility.getName(salesBasicPo.getSsesbconrecipetype   ()));
		params.add(Utility.getName(salesBasicPo.getSsesbsubvisitunit    ()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalestype       ()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalerid         ()));
		params.add(Utility.getName(salesBasicPo.getSsesblryid           ()));
		params.add(Utility.getName(salesBasicPo.getSsesbposid           ()));
		params.add(Utility.getName(salesBasicPo.getSsesbpricesum        ().trim()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesvalue      ().trim()));
		params.add(Utility.getName(salesBasicPo.getSsesbeyecurvatureod1 ()));
		params.add(Utility.getName(salesBasicPo.getSsesbeyecurvatureod2 ()));
		params.add(Utility.getName(salesBasicPo.getSsesbeyecurvatureos1 ()));
		params.add(Utility.getName(salesBasicPo.getSsesbeyecurvatureos2 ()));
		params.add(Utility.getName(salesBasicPo.getSsesbdiscountrate    ().trim()));
		params.add(Utility.getName(salesBasicPo.getSsesbdiscountnum     ().trim()));
		params.add(Utility.getName(salesBasicPo.getSsesbpsalsvalue      ().trim()));
		params.add(Utility.getName(salesBasicPo.getSsesbarrearsvalue    ().trim()));
		params.add(Utility.getName(salesBasicPo.getSsesblocation        ()));
		params.add(Utility.getName(salesBasicPo.getSsesbvalueflag       ()));
		params.add(Utility.getName(salesBasicPo.getSsesbcheckoutflag    ()));
		params.add(Utility.getName(salesBasicPo.getSsesbintransit       ()));
		params.add(Utility.getName(salesBasicPo.getSsesbwithdrawflag    ()));
		params.add(Utility.getName(salesBasicPo.getSsesbwithdrawpersonid()));
		params.add(Utility.getName(salesBasicPo.getSsesbmovementtype    ()));
		

		params.add(Utility.getName(salesBasicPo.getSsesbrenums          ().trim()));
		params.add(Utility.getName(salesBasicPo.getSsesbdiscounttype()));//2012/2/2 零折
		params.add(Utility.getName(salesBasicPo.getSsesbdiscountperson()));	//2012/2/2 零折
//		params.add(Utility.getName(salesBasicPo.getSsesbdragstype()));	
		
		this.getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	
	public void insertSalesDetail(SalesDetailPo salesDetailPo) {
		// TODO Auto-generated method stub
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
		buffer.append(",S_SE_SD_LargessFlag,S_SE_SD_Renums) ");
		buffer.append("VALUES ");
		buffer.append("(?, ?, ?, ?, ?, ?, ?, ? ");
		buffer.append(", ?, ?, ?, ?, ?, ?, ?, ? ");
		buffer.append(", ?, getdate(), ? , ?)");

		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(salesDetailPo.getSsesdsalesid());
		params.add(salesDetailPo.getSsesdsalesitemid());
		params.add(salesDetailPo.getSsesditemid());
		params.add(salesDetailPo.getSsesdstockid());
		params.add(salesDetailPo.getSsesdsalesitemname());
		params.add(salesDetailPo.getSsesdsprice());
		params.add(salesDetailPo.getSsesdnumber());
		params.add(salesDetailPo.getSsesdunitprice());
		params.add(salesDetailPo.getSsesdcostsprive());
		params.add(salesDetailPo.getSsesdpricesum());
		params.add(salesDetailPo.getSsesdsalesvalue());
		params.add(salesDetailPo.getSsesddiscountrate());
		params.add(salesDetailPo.getSsesddiscountnum());
		params.add(salesDetailPo.getSsesdgooddescribe());
		params.add(salesDetailPo.getSsesdglassflag());
		params.add(salesDetailPo.getSsesdcommoditiesflag());
		params.add(salesDetailPo.getSsesdlargessflag());
		params.add(salesDetailPo.getSsesdrenum());

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 根据销售单号将信息插入在途明细表中
	 * @param inTransitPo
	 */
	public void insertIntrnsitInfo(InTransitPo inTransitPo) {
		// TODO Auto-generated method stub
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
}