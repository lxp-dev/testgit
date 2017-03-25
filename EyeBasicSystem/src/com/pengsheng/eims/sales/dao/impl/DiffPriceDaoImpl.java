package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.DiffPriceDao;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesPostBasicPo;
import com.pengsheng.eims.sales.persistence.SalesPostDetailPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class DiffPriceDaoImpl extends BaseJdbcDaoSupport implements DiffPriceDao {


	/*
	 * 顾客刷卡
	 */
	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po,SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
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
		buffer.append("on S_ME_CI_Integral between ");
		buffer.append("convert(int, a.F_MM_DOWN) and convert(int, a.F_MM_UP)");
		buffer.append("left join S_SE_SalesBasic on S_SE_SB_CustomerID = S_ME_CI_CustomerID");
		buffer.append("  where 1=1 ");
		if (!"".equals(Utility.getName(po.getSmecicustomerid()))) {
			buffer.append("and S_ME_CI_CustomerID = '"
					+ po.getSmecicustomerid() + "'");
		}
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalerid()))) {
			buffer.append("and S_SE_SB_SalesID = '"+salesBasicPo.getSsesbsalerid()+"'");
		}
			
		if (!"".equals(Utility.getName(po.getSmecimemberid()))) {
			buffer.append("and S_ME_CI_MemberId = '" + po.getSmecimemberid()
					+ "'");
		}

		return (CustomerInfoPo) queryForObject(buffer.toString(), null,
				CustomerInfoPo.class);
	}
	
	/*
	 * (non-Javadoc)得到结款配镜单号
	 * @see com.pengsheng.eims.sales.dao.DiffPriceDao#getDiffPrices(com.pengsheng.eims.sales.persistence.SalesBasicPo)
	 */

	public List<SalesBasicPo> getDiffPrices(SalesBasicPo salesBasicPo,String departmentID) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT S_SE_SB_SalesID as ssesbsalesid,");
		sb.append("S_ME_CI_Name as ssesbpersonName,");
		sb.append("S_SE_SB_CustomerID as ssesbcustomerid,");
		sb.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime,");
		sb.append("S_SE_SB_PriceSum as ssesbpricesum,");
		sb.append("S_SE_SB_SalesValue as ssesbsalesvalue,");
		sb.append("S_SE_SB_DiscountNum as ssesbdiscountnum,");
		sb.append("S_SE_SB_Psalsvalue as ssesbpsalsvalue,");
		sb.append("S_SE_SB_ArrearsValue as ssesbarrearsvalue ");
		sb.append("from s_se_salesbasic ");
		sb.append("inner join S_ME_CustomerInfo on S_ME_CI_CustomerID=S_SE_SB_CustomerID   ");
		sb.append("where S_SE_SB_valueflag='1' and S_SE_SB_InTransit<>'14' and s_se_sb_shopcode=? ");
		
		List<String> params = new ArrayList<String>();
		params.add(departmentID);
		if(!"".equals(salesBasicPo.getSsesbsalesid())){
			sb.append("and S_SE_SB_SalesID=? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		if(!"".equals(salesBasicPo.getSsesbcustomerid())){
			sb.append("and S_SE_SB_CustomerID=? ");
			params.add(salesBasicPo.getSsesbcustomerid());
		}
	
		return queryForObjectList(sb.toString(), params.toArray(), SalesBasicPo.class);
	}
	

	/**
	 * 得到销售结帐基表对象
	 */
	public SalesBasicPo getSalesBasicPo(String salesID) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT top 1  S_SE_SB_SalesID as ssesbsalesid,");
		sb.append("S_ME_CI_Name as ssesbpersonName,");
		sb.append("S_ME_CI_Phone   as ssesbphone  ,");
		sb.append("S_SE_SB_DiscountRate   as ssesbdiscountrate  ,");
		sb.append("S_SE_SB_TakeGlassData   as ssesbtakeglassdata  ,");
		sb.append("B_DP_DepartmentName   as ssesbshopName  ,");
		sb.append("S_SE_SB_CustomerID as ssesbcustomerid,");
		sb.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime,");
		sb.append("S_SE_SB_PriceSum as ssesbpricesum,");
		sb.append("S_SE_SB_SalesValue as ssesbsalesvalue,");
		sb.append("S_SE_SB_DiscountNum as ssesbdiscountnum,");
		sb.append("S_SE_SB_Psalsvalue as ssesbpsalsvalue,");
		sb.append("S_SE_SB_ArrearsValue as ssesbarrearsvalue ");
		sb.append("from s_se_salesbasic inner join S_ME_CustomerInfo on S_ME_CI_CustomerID=S_SE_SB_CustomerID ");
		sb.append("inner join B_Departments on B_DP_DepartmentID=S_SE_SB_ShopCode ");
		sb.append("where S_SE_SB_valueflag='1'  and S_SE_SB_InTransit<>'14' ");
		sb.append("and S_SE_SB_SalesID=?");
		List<String> params = new ArrayList<String>();
		params.add(salesID);
		return (SalesBasicPo) queryForObject(sb.toString(), params.toArray(), SalesBasicPo.class);
	}
	
	/**
	 * 得到所有顾客销售结帐明细表,销售结帐基表对应的
	 */
	public List<SalesDetailPo> getSalesDetail(String ssesdsalesid) {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select ");
		buffer.append("S_SE_SD_ID as ssesdid, ");
		buffer.append("S_SE_SD_SalesItemID as ssesdsalesitemid, ");
		buffer.append("S_SE_SD_SalesItemName as ssesdsalesitemname, ");
		buffer.append("S_SE_SD_SPrice as ssesdsprice, ");
		buffer.append("S_SE_SD_Number as ssesdnumber, ");
		buffer.append("S_SE_SD_PriceSum as ssesdpricesum , ");
		buffer.append("S_SE_SD_DiscountRate as ssesddiscountrate , ");
		buffer.append("S_SE_SD_DiscountNum as ssesddiscountnum , ");
		buffer.append("S_SE_SD_SalesValue as ssesdsalesvalue ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("where S_SE_SD_SalesID= ? ");
	    
	    List<String> params = new ArrayList<String>();
		params.add(ssesdsalesid);

		return queryForObjectList(buffer.toString(), params.toArray(),
				SalesDetailPo.class);
	}
	
	/*
	 * 插入差价基表
	 */
	public void insertBasic(SalesPostBasicPo salesPostBasicPo){
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO S_SE_SalesPostBasic ");
		sb.append("VALUES      (?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             getdate()) ");
		
		List<String> params = new ArrayList<String>();
		
		params.add(this.uuid.generate());
		params.add(salesPostBasicPo.getSsespbsalesid());
		params.add(salesPostBasicPo.getSsespbnewsalesid());
		params.add(salesPostBasicPo.getSsespbcreater());
		
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}
    
	public void updateCustomerIntegral(String customerID,float ssespbpostvalue){
		StringBuffer sb = new StringBuffer();
		sb.append("update S_ME_CustomerInfo set S_ME_CI_Integral = S_ME_CI_Integral - "+ssespbpostvalue);
		sb.append(" where S_ME_CI_CustomerID=?");
		
		List<String> params = new ArrayList<String>();
		params.add(customerID);
		
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	
	/*
	 * 插入差价明细表
	 */
	public void insertDetail(SalesPostDetailPo salesPostDetailPo){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("insert into S_SE_SalesPostDetail");
		sb.append(" select temp1,S_SE_SD_SalesID,S_SE_SD_SalesItemID,S_SE_SD_ItemID,S_SE_SD_StockId,S_SE_SD_SalesItemName,S_SE_SD_SPrice,S_SE_SD_Number,S_SE_SD_UnitPrice,S_SE_SD_CostsPrive,S_SE_SD_PriceSum,S_SE_Sd_SalesValue,S_SE_Sd_DiscountRate,S_SE_Sd_DiscountNum,temp2,temp3,temp4,S_SE_Sd_GoodDescribe,S_SE_Sd_GlassFlag,S_SE_Sd_CommoditiesFlag,S_SE_Sd_LargessFlag from (select ROW_NUMBER() Over(order by S_SE_SD_SalesID) as rownumber,? as temp1,S_SE_SD_SalesID,S_SE_SD_SalesItemID,S_SE_SD_ItemID,S_SE_SD_StockId,S_SE_SD_SalesItemName,S_SE_SD_SPrice,");
		sb.append("S_SE_SD_Number,S_SE_SD_UnitPrice,S_SE_SD_CostsPrive,S_SE_SD_PriceSum,S_SE_Sd_SalesValue,S_SE_Sd_DiscountRate,");
		sb.append("S_SE_Sd_DiscountNum,? as temp2,? as temp3,? as temp4,S_SE_Sd_GoodDescribe,S_SE_Sd_GlassFlag,S_SE_Sd_CommoditiesFlag,");
		sb.append("S_SE_Sd_LargessFlag from S_SE_SalesDetail where S_SE_SD_SalesID=?) temp  where temp.rownumber=?");
		params.add(this.uuid.generate());
		params.add(salesPostDetailPo.getSsespdnewdiscountrate());
		params.add(salesPostDetailPo.getSsespdnewdiscountnum());
		params.add(salesPostDetailPo.getSsespdpostvalue());
		params.add(salesPostDetailPo.getSsespdsalesid());
		params.add(salesPostDetailPo.getSsespdrownumber());

		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	//将退差价单号商品添加到新单号内，更新销售基表S_SE_SalesBasic金额
	public void insertSalesBasic(SalesBasicPo salesBasicPo,String newsalesid) {
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("INSERT INTO S_SE_SalesBasic ");
		varname1.append("SELECT ?, ");
			params.add(newsalesid);
		varname1.append("       S_SE_SB_ShopCode, ");
		varname1.append("       S_SE_SB_CustomerID, ");
		varname1.append("       S_SE_SB_OptID, ");
		varname1.append("       S_SE_SB_OptometryID, ");
		varname1.append("       S_SE_SB_InspectionID, ");
		varname1.append("       Getdate(), ");
		varname1.append("       Getdate(), ");
		varname1.append("       S_SE_SB_OrdersType, ");
		varname1.append("       S_SE_SB_BallGlassOD, ");
		varname1.append("       S_SE_SB_BallGlassOS, ");
		varname1.append("       S_SE_SB_PostGlassOD, ");
		varname1.append("       S_SE_SB_PostGlassOS, ");
		varname1.append("       S_SE_SB_AxesOD, ");
		varname1.append("       S_SE_SB_AxesOS, ");
		varname1.append("       S_SE_SB_ADDOD, ");
		varname1.append("       S_SE_SB_ADDOS, ");
		varname1.append("       S_SE_SB_ArriseGlassOD1, ");
		varname1.append("       S_SE_SB_ArriseGlassOS1, ");
		varname1.append("       S_SE_SB_BasisOD1, ");
		varname1.append("       S_SE_SB_BasisOS1, ");
		varname1.append("       S_SE_SB_PrismOD, ");
		varname1.append("       S_SE_SB_PrismOS, ");
		varname1.append("       S_SE_SB_InterHighOD, ");
		varname1.append("       S_SE_SB_InterHighOS, ");
		varname1.append("       S_SE_SB_InterDistanceOD, ");
		varname1.append("       S_SE_SB_InterDistanceOS, ");
		varname1.append("       S_SE_SB_FarVAOD, ");
		varname1.append("       S_SE_SB_FarVAOS, ");
		varname1.append("       S_SE_SB_CloseVAOD, ");
		varname1.append("       S_SE_SB_CloseVAOS, ");
		varname1.append("       S_SE_SB_RecipeType, ");
		varname1.append("       S_SE_SB_DignosisRe, ");
		varname1.append("       S_SE_SB_DiameterOD, ");
		varname1.append("       S_SE_SB_DiameterOS, ");
		varname1.append("       S_SE_SB_ConRecipeType, ");
		varname1.append("       S_SE_SB_SecCheckDate, ");
		varname1.append("       S_SE_SB_SubVisitUnit, ");
		varname1.append("       S_SE_SB_SalesType, ");
		varname1.append("       S_SE_SB_SalerID, ");
		varname1.append("       S_SE_SB_Lryid, ");
		varname1.append("       Getdate(), ");
		varname1.append("       S_SE_SB_PosID, ");
		varname1.append("       S_SE_SB_PriceSum, ");
		varname1.append("       ?, ");
			params.add(salesBasicPo.getSsesbsalesvalue());
		varname1.append("       S_SE_SB_EyeCurvatureOD1, ");
		varname1.append("       S_SE_SB_EyeCurvatureOD2, ");
		varname1.append("       S_SE_SB_EyeCurvatureOS1, ");
		varname1.append("       S_SE_SB_EyeCurvatureOS2, ");
		varname1.append("       ?, ");
			params.add(salesBasicPo.getSsesbdiscountrate());
		varname1.append("       ?, ");
			params.add(salesBasicPo.getSsesbdiscountnum());
		varname1.append("       S_SE_SB_Psalsvalue, ");
			
		varname1.append("       S_SE_SB_ArrearsValue, ");
		varname1.append("       S_SE_SB_Location, ");
		varname1.append("       Getdate(), ");
		varname1.append("       S_SE_SB_ValueFlag, ");
		varname1.append("       S_SE_SB_CheckoutFlag, ");
		varname1.append("       '13', ");
		varname1.append("       '', ");
		varname1.append("       '', ");
		varname1.append("       '', ");
		varname1.append("       S_SE_SB_MovementType, ");
		varname1.append("       S_SE_SB_ArrearsAppendDate, ");
		varname1.append("       S_SE_SB_ArrearsDate ");
		varname1.append("FROM   S_SE_SalesBasic ");
		varname1.append("WHERE  S_SE_SB_SalesID = ? ");
			params.add(salesBasicPo.getSsesbsalesid());
			
		getJdbcTemplate().update(varname1.toString(),params.toArray());
	}
	//将退差价单号商品添加到新单号内，更新销售明细表S_SE_SalesDetail金额
	public List<SalesDetailPo> getSalesDetails(String oldsalesid) {
		StringBuffer  varname1 = new StringBuffer();
		varname1.append("SELECT S_SE_SD_ID        AS  ssesdid, ");
		varname1.append("       S_SE_SD_SalesID   as  ssesdsalesid, ");
		varname1.append("       S_SE_SD_SalesItemID as ssesdsalesitemid, ");
		varname1.append("       S_SE_SD_ItemID as ssesditemid, ");
		varname1.append("       S_SE_SD_StockId as ssesdstockid, ");
		varname1.append("       S_SE_SD_SalesItemName as ssesdsalesitemname, ");
		varname1.append("       S_SE_SD_SPrice as ssesdsprice, ");
		varname1.append("       S_SE_SD_Number as ssesdnumber,    ");
		varname1.append("       S_SE_SD_UnitPrice as ssesdunitprice, ");
		varname1.append("       S_SE_SD_CostsPrive as ssesdcostsprive, ");
		varname1.append("       S_SE_SD_PriceSum as ssesdpricesum, ");
		varname1.append("       S_SE_SD_SalesValue as ssesdsalesvalue, ");
		varname1.append("       S_SE_SD_DiscountRate as ssesddiscountrate, ");
		varname1.append("       S_SE_SD_DiscountNum as ssesddiscountnum, ");
		varname1.append("       S_SE_SD_GoodDescribe as ssesdgooddescribe, ");
		varname1.append("       S_SE_SD_GlassFlag as ssesdglassflag,S_SE_SD_CommoditiesFlag as ssesdcommoditiesflag, ");
		varname1.append("       S_SE_SD_Updatetime as ssesdupdatetime, ");
		varname1.append("       S_SE_SD_LargessFlag as ssesdlargessflag ");
		varname1.append("FROM   S_SE_SalesDetail ");
		varname1.append("WHERE  S_SE_SD_SalesID = ? ");
		List<String> params = new ArrayList<String>();
		params.add(oldsalesid);
		
		return this.queryForObjectList(varname1.toString(), params.toArray(), SalesDetailPo.class);
		
	}
	
	//将退差价单号商品添加到新单号内，更新销售明细表S_SE_SalesDetail金额
	public void insertSalesDetails(SalesDetailPo salesDetailPo,String newsalesid) {
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("INSERT INTO S_SE_SalesDetail values(");
		varname1.append("       ?, ");
			params.add(this.uuid.generate());
		varname1.append("       ?, ");
			params.add(newsalesid);
		varname1.append("       ?, ");
			params.add(salesDetailPo.getSsesdsalesitemid());
		varname1.append("       ?, ");//ssesditemid
			params.add(salesDetailPo.getSsesditemid());
		varname1.append("       ?, ");//ssesdstockid
			params.add(salesDetailPo.getSsesdstockid());
		varname1.append("       ?, ");//ssesdsalesitemname
			params.add(salesDetailPo.getSsesdsalesitemname());
		varname1.append("       ?, ");//ssesdsprice
			params.add(salesDetailPo.getSsesdsprice());
		varname1.append("       ?, ");//ssesdnumber
			params.add(salesDetailPo.getSsesdnumber());
		varname1.append("       ?, ");//ssesdunitprice
			params.add(salesDetailPo.getSsesdunitprice());
		varname1.append("       ?, ");//ssesdcostsprive
			params.add(salesDetailPo.getSsesdcostsprive());
		varname1.append("       ?, ");//ssesdpricesum
			params.add(salesDetailPo.getSsesdpricesum());
		varname1.append("       ?, ");//ssesdsalesvalue
			params.add(salesDetailPo.getSsesdsalesvalue());
		varname1.append("       ?, ");//ssesddiscountrate
			params.add(salesDetailPo.getSsesddiscountrate());
		varname1.append("       ?, ");//ssesddiscountnum
			params.add(salesDetailPo.getSsesddiscountnum());
		varname1.append("       ?,?, ");//ssesdgooddescribe ssesdglassflag
			params.add(salesDetailPo.getSsesdgooddescribe());
			params.add(salesDetailPo.getSsesdglassflag());
		varname1.append("       ?, ");//ssesdcommoditiesflag
			params.add(salesDetailPo.getSsesdcommoditiesflag());
		varname1.append("       Getdate(), ");
		varname1.append("       ?");//ssesdlargessflag
			params.add(salesDetailPo.getSsesdlargessflag());
		varname1.append(")");
		
		getJdbcTemplate().update(varname1.toString(),params.toArray());
	}
	
	//更新退款标示
	public void updateSalesBasic(SalesBasicPo salesBasicPo) {
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();

		varname1.append("UPDATE S_SE_SalesBasic ");
		varname1.append("SET    S_SE_SB_WithdrawFlag = '1',S_SE_SB_WithdrawDate=getdate(),S_SE_SB_InTransit = '14',S_SE_SB_WithdrawPersonID = ? ");
		varname1.append("WHERE  S_SE_SB_SalesID = ? ");
		params.add(salesBasicPo.getSsesbwithdrawpersonid());
		params.add(salesBasicPo.getSsesbsalesid());
		
		getJdbcTemplate().update(varname1.toString(),params.toArray());
	}
	
	//退货更新第三张库存表(入库)
	public void insertStrogeChange(SalesDetailPo salesDetailPo) {
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("INSERT INTO C_SH_StorageChange ");
		varname1.append("SELECT replace(NEWID(),'-',''),Substring(S_SE_SD_ItemID, 1, 18), ");
		varname1.append("       S_SE_SD_SalesItemID, ");
		varname1.append("       ?, ");
			params.add(salesDetailPo.getSsesdstockid());
		varname1.append("       S_SE_SD_Number, ");
		varname1.append("       S_SE_SD_CostsPrive, ");
		varname1.append("       S_SE_SD_UnitPrice, ");
		varname1.append("       Getdate(), ");
		varname1.append("       ? ");
			params.add(salesDetailPo.getSsesdsalesid());
		varname1.append("FROM   S_SE_SalesDetail ");
		varname1.append("WHERE  S_SE_SD_SalesID = ? ");
			params.add(salesDetailPo.getSsesdsalesid());
		
		getJdbcTemplate().update(varname1.toString(),params.toArray());
	}
	
	//退货更新第三张库存表(出库)
	public void insertOutStrogeChange(SalesDetailPo salesDetailPo,String newsalesid) {
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("INSERT INTO C_SH_StorageChange ");
		varname1.append("SELECT replace(NEWID(),'-',''),Substring(S_SE_SD_ItemID, 1, 18), ");
		varname1.append("       S_SE_SD_SalesItemID, ");
		varname1.append("       ?, ");
			params.add(salesDetailPo.getSsesdstockid());
		varname1.append("       S_SE_SD_Number-2*S_SE_SD_Number, ");
		varname1.append("       S_SE_SD_CostsPrive, ");
		varname1.append("       S_SE_SD_UnitPrice, ");
		varname1.append("       Getdate(), ");
		varname1.append("       ? ");
			params.add(newsalesid);
		varname1.append("FROM   S_SE_SalesDetail ");
		varname1.append("WHERE  S_SE_SD_SalesID = ? ");
			params.add(salesDetailPo.getSsesdsalesid());
		
		getJdbcTemplate().update(varname1.toString(),params.toArray());
	}
	
	//退货更新第四张库存表(入库)
	public void insertStrogeLog(SalesDetailPo salesDetailPo) {
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("INSERT INTO C_SH_StorageLog ");
		varname1.append("SELECT replace(NEWID(),'-',''),Substring(S_SE_SD_ItemID, 1, 18), ");
		varname1.append("       S_SE_SD_SalesItemID, ");
		varname1.append("       ?, ");
			params.add(salesDetailPo.getSsesdstockid());
		varname1.append("       S_SE_SD_Number, ");
		varname1.append("       S_SE_SD_CostsPrive, ");
		varname1.append("       S_SE_SD_UnitPrice, ");
		varname1.append("       Getdate(), '',");
		varname1.append("       ? ,'','' ");
			params.add(salesDetailPo.getSsesdsalesid());
		varname1.append("FROM   S_SE_SalesDetail ");
		varname1.append("WHERE  S_SE_SD_SalesID = ? ");
			params.add(salesDetailPo.getSsesdsalesid());
		
		getJdbcTemplate().update(varname1.toString(),params.toArray());
	}
	
	//退货更新第四张库存表(出库)
	public void insertOutStrogeLog(SalesDetailPo salesDetailPo,String newsalesid) {
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("INSERT INTO C_SH_StorageLog ");
		varname1.append("SELECT replace(NEWID(),'-',''),Substring(S_SE_SD_ItemID, 1, 18), ");
		varname1.append("       S_SE_SD_SalesItemID, ");
		varname1.append("       ?, ");
			params.add(salesDetailPo.getSsesdstockid());
		varname1.append("       S_SE_SD_Number-2*S_SE_SD_Number, ");
		varname1.append("       S_SE_SD_CostsPrive, ");
		varname1.append("       S_SE_SD_UnitPrice, ");
		varname1.append("       Getdate(), '',");
		varname1.append("       ?,'','' ");
			params.add(newsalesid);
		varname1.append("FROM   S_SE_SalesDetail ");
		varname1.append("WHERE  S_SE_SD_SalesID = ? ");
			params.add(salesDetailPo.getSsesdsalesid());
		
		getJdbcTemplate().update(varname1.toString(),params.toArray());
	}
	
	//得到在途List 1,2,13
	public List<InTransitPo> getIntransitInfo(InTransitPo inTransitPo) {
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("SELECT S_SE_IT_SalesID as sseitsalesid,S_SE_IT_State as sseitstate, ");
		varname1.append("       S_SE_IT_CreatePerson as sseitcreateperson, ");
		varname1.append("       S_SE_IT_Department as sseitdepartment ");
		varname1.append("FROM   S_SE_InTransit ");
		varname1.append("WHERE  S_SE_IT_SalesID = ? ");
		varname1.append("       AND S_SE_IT_State IN ( '1', '2', '13' ) ");
			params.add(inTransitPo.getSseitsalesid());
		
		return this.queryForObjectList(varname1.toString(), params.toArray(), InTransitPo.class);
	}
	//插入在途表1,2,13
	public void insertIntransitInfo(InTransitPo inTransitPo,String newsalesid) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
			
		buffer.append("insert into S_SE_InTransit values(");
		buffer.append("       ?,?, ");
		buffer.append("       ?, ");
		buffer.append("       Getdate(), ");
		buffer.append("       ?, ");
		buffer.append("       ? ");
		buffer.append("       ) ");
		params.add(this.uuid.generate());
		params.add(newsalesid);
		params.add(inTransitPo.getSseitstate());
		params.add(inTransitPo.getSseitcreateperson());
		params.add(inTransitPo.getSseitdepartment());
		
//		params.add(inTransitPo.getSseitstate());
//		params.add(inTransitPo.getSseitcreateperson());
//		params.add(inTransitPo.getSseitdepartment());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	//插入原单号在途表14
	public void insertYIntransitInfo(InTransitPo inTransitPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();

		buffer.append("insert into S_SE_InTransit values( ");
		buffer.append("		  ?,?, ");
		buffer.append("       '14', ");
		buffer.append("       Getdate(), ");
		buffer.append("       ?, ");
		buffer.append("       ? )");
		params.add(this.uuid.generate());
		params.add(inTransitPo.getSseitsalesid());
		
		params.add(inTransitPo.getSseitcreateperson());
		params.add(inTransitPo.getSseitdepartment());
//		params.add(inTransitPo.getSseitstate());
//		params.add(inTransitPo.getSseitcreateperson());
//		params.add(inTransitPo.getSseitdepartment());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	public WarehousePo getWarehouse(String deptID) {
 		StringBuffer  varname1 = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		varname1.append("SELECT top 1 B_WH_ID as bwhid, ");
		varname1.append("             B_WH_deptID as bwhdeptid, ");
		varname1.append("             B_WH_warehouseName as bwhwarehouseName ");
		varname1.append("FROM         B_Warehouse ");
		varname1.append("WHERE        B_WH_deptID = ? ");
		params.add(deptID);

		return (WarehousePo) queryForObject(varname1.toString(), params.toArray(),WarehousePo.class);
	}
	
	
	
	public void updateBasic(SalesPostBasicPo salesPostBasicPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("update S_SE_SalesBasic set ");
		sb.append("S_SE_SB_SalesValue=?, ");
		sb.append("S_SE_SB_DiscountRate=?,");
		sb.append("S_SE_SB_DiscountNum=?, ");
		sb.append("S_SE_SB_Psalsvalue=?, ");
		sb.append("S_SE_SB_ArrearsValue=? ");
		sb.append("where S_SE_SB_SalesID=? ");
		
		List<String> params = new ArrayList<String>();
//		params.add(salesPostBasicPo.getSsespbsalesvalue());
//		params.add(salesPostBasicPo.getSsespbnewdiscountrate());
//		params.add(salesPostBasicPo.getSsespbnewdiscountnum());
//		params.add(salesPostBasicPo.getSsespbnewpsalsvalue());
//		params.add(salesPostBasicPo.getSsespbnewarrearsvalue());
//		params.add(salesPostBasicPo.getSsespbsalesid());

	
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	/*
	 * (non-Javadoc)更新销售明细表
	 * @see com.pengsheng.eims.sales.dao.DiffPriceDao#updateDetail(com.pengsheng.eims.sales.persistence.SalesPostDetailPo)
	 */

	public void updateDetail(SalesPostDetailPo salesPostDetailPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("update S_SE_SalesDetail set ");
		sb.append("S_SE_SD_SalesValue=?, ");
		sb.append("S_SE_SD_DiscountRate=?,");
		sb.append("S_SE_SD_DiscountNum=? ");
		sb.append("where S_SE_SD_ID=? ");
		
		List<String> params = new ArrayList<String>();
		params.add(salesPostDetailPo.getSsespdsalesvalue());
		params.add(salesPostDetailPo.getSsespdnewdiscountrate());
		params.add(salesPostDetailPo.getSsespdnewdiscountnum());
		params.add(salesPostDetailPo.getSsespdid());
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}


}
