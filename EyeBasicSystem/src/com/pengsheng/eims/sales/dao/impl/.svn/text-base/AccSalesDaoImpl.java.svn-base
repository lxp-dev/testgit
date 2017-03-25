/**
 * 
 */
package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.AccSalesDao;
import com.pengsheng.eims.sales.dao.ConSalesDao;
import com.pengsheng.eims.sales.dao.FrameSalesDao;
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
public class AccSalesDaoImpl extends BaseJdbcDaoSupport implements
		AccSalesDao {

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
		if (po == null){
			buffer.append("and S_ME_CI_MemberId = 'commonMember'");
		}else{
			if (!"".equals(Utility.getName(po.getSmecicustomerid()))) {
				buffer.append("and S_ME_CI_CustomerID = '"
						+ po.getSmecicustomerid() + "'");
			}
			if (!"".equals(Utility.getName(po.getSmecimemberid()))) {
				buffer.append("and S_ME_CI_MemberId = '" + po.getSmecimemberid()
						+ "'");
			}
		}
		return (CustomerInfoPo) queryForObject(buffer.toString(), null,
				CustomerInfoPo.class);
	}

	


	public void insertSalesBasic(SalesBasicPo salesBasicPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO S_SE_SalesBasic ");
		sb.append("values(?,?,?,?,?,null,getdate(),getdate(),?,?,?,");//11
		sb.append("?,?,?,?,?,?,?,?,?,?,");//10
		sb.append("?,?,?,?,?,?,?,?,?,?,");//10
		sb.append("?,?,?,?,?,null,?,?,?,?,");//10
		sb.append("null,?,?,?,?,?,?,?,?,?,");//10
		sb.append("?,?,?,null,?,?,?,null,?,?,?,null,null,'0.00','0.00','0.00',?,?,?,'' ) ");//17
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid         ()));
		params.add(Utility.getName(salesBasicPo.getSsesbshopcode        ()));
		params.add(Utility.getName(salesBasicPo.getSsesbcustomerid      ()));
		params.add(Utility.getName(salesBasicPo.getSsesboptid           ()));
		
		params.add(Utility.getName(salesBasicPo.getSsesboptometryid     ()));
		
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
		params.add(Utility.getName(salesBasicPo.getSsesbpricesum        ()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesvalue      ()));
		params.add(Utility.getName(salesBasicPo.getSsesbeyecurvatureod1 ()));
		params.add(Utility.getName(salesBasicPo.getSsesbeyecurvatureod2 ()));
		params.add(Utility.getName(salesBasicPo.getSsesbeyecurvatureos1 ()));
		params.add(Utility.getName(salesBasicPo.getSsesbeyecurvatureos2 ()));
		params.add(Utility.getName(salesBasicPo.getSsesbdiscountrate    ()));
		params.add(Utility.getName(salesBasicPo.getSsesbdiscountnum     ()));
		params.add(Utility.getName(salesBasicPo.getSsesbpsalsvalue      ()));
		params.add("0.00");
		params.add(Utility.getName(salesBasicPo.getSsesblocation        ()));
		params.add(Utility.getName(salesBasicPo.getSsesbvalueflag       ()));
		params.add("0");
		params.add(Utility.getName(salesBasicPo.getSsesbintransit       ()));
		params.add(Utility.getName(salesBasicPo.getSsesbwithdrawflag    ()));
		params.add(Utility.getName(salesBasicPo.getSsesbwithdrawpersonid()));
		params.add(Utility.getName(salesBasicPo.getSsesbmovementtype    ()));
		if("".equals(Utility.getName(salesBasicPo.getSsesbrenums        ()))){
			params.add("0.00");
		}else{
			params.add(Utility.getName(salesBasicPo.getSsesbrenums      ()));
		}
		
		params.add(Utility.getName(salesBasicPo.getSsesbdiscounttype()));//2012/2/2 零折
		params.add(Utility.getName(salesBasicPo.getSsesbdiscountperson()));	//2012/2/2 零折
		
				
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
		buffer.append(", ?, getdate(), ? ,?)");

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
		if(!"".equals(Utility.getName(salesDetailPo.getSsesdrenum()))){
			params.add(salesDetailPo.getSsesdrenum());
		}else{
			params.add("0.00");
		}
			

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