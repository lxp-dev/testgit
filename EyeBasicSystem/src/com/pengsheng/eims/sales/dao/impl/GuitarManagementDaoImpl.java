package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.GuitarManagementDao;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageEntryPo;
import com.pengsheng.eims.sales.persistence.IntegralExchangeEntryPo;
import com.pengsheng.eims.sales.persistence.IntegralExchangePo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.storage.persistence.StrogeLogTempPo;
import com.pengsheng.eims.system.persistence.BankPo;
import com.pengsheng.eims.system.persistence.ExternalAccountParameterPo;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.persistence.WeiXinIntegralSelectPo;

public class GuitarManagementDaoImpl extends BaseJdbcDaoSupport implements
		GuitarManagementDao {
	/**
	 * 根据配镜单号查询顾客信息
	 */
	public CustomerInfoPo getCustmorInfo(CustomerInfoPo customerInfoPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1  s1.S_ME_CI_Name as smeciname, ");
		buffer.append("s1.S_ME_CI_Sex as smecisex , ");
		buffer.append("s1.S_ME_CI_Birthday as smecibirthday, ");
		buffer.append("s1.S_ME_CI_MemberId as smecimemberid, ");
		buffer.append("s1.S_ME_CI_CustomerID as smecicustomerid, ");
		buffer.append("s1.S_ME_CI_Phone as smeciphone, ");
		buffer.append("case ");
		buffer.append(" when isnull(s1.S_ME_CI_FCustomerID,'') <> '' then isnull(s2.S_ME_CI_Integral,0) ");
		buffer.append(" else isnull(s1.S_ME_CI_Integral,0) end as smeciintegral, ");
		buffer.append("S_SE_SB_SalesID as fmmsalesid, ");
		buffer.append("s1.S_ME_CI_ConsumptionPrice as smeciconsumptionprice ");
		buffer.append("from S_ME_CustomerInfo s1 ");
		buffer.append("left join S_ME_CustomerInfo s2 on s2.S_ME_CI_CustomerID = s1.S_ME_CI_FCustomerID ");
		buffer.append("inner join ( ");		
		buffer.append(" select distinct S_SE_SB_SalesID as S_SE_SB_SalesID,S_SE_SB_CustomerID from ( ");
		buffer.append(" select S_SE_SB_SalesID as S_SE_SB_SalesID,S_SE_SB_CustomerID as S_SE_SB_CustomerID from S_SE_SalesBasic ");
		buffer.append(" union all ");
		buffer.append(" select S_SE_SB_SalesID as S_SE_SB_SalesID,S_SE_SB_CustomerID as S_SE_SB_CustomerID from S_SE_SalesBasic_Finished ");
		buffer.append(" )t ");
		buffer.append(")t1 on s1.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		
		buffer.append("where 1=1 ");

		if (!"".equals(Utility.getName(customerInfoPo.getFmmsalesid()))) {
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(customerInfoPo.getFmmsalesid());
		}

		if(!"".equals(Utility.getName(customerInfoPo.getSmeciflag()))){
			buffer.append(" and S_ME_CI_Flag = ? ");
			params.add(customerInfoPo.getSmeciflag());
		}
		
		if(customerInfoPo.getSmecishoplist() != null && customerInfoPo.getSmecishoplist().size() > 0){
			
			buffer.append(" and s1.S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = customerInfoPo.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		return (CustomerInfoPo) queryForObject(buffer.toString(), params
				.toArray(), CustomerInfoPo.class);
	}

	/**
	 * 得到打印镜单信息
	 */
	public List<SalesBasicPo> getSalesBasics(SalesBasicPo salesBasicPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by ssesbsalesid desc) as rowNum,* from ( ");
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid ");
		buffer.append(", S_SE_SB_PriceSum as ssesbpricesum ");
		buffer.append(", S_SE_SB_SalesValue as ssesbsalesvalue ");
		buffer.append(", S_SE_SB_ArrearsValue as ssesbarrearsvalue ");
		buffer.append(", S_SE_SB_DiscountNum as ssesbdiscountnum ");
		buffer.append(", S_SE_SB_Psalsvalue as ssesbpsalsvalue ");
//		buffer.append(", S_SE_SB_SalerID as ssesbsalerid ");
		buffer.append(", s.personName as ssesbsalerName ");
//		buffer.append(", S_SE_SB_PosID as ssesbposid ");
		buffer.append(", S_SE_SB_CheckoutFlag as ssesbcheckoutflag ");
		buffer.append(", S_SE_SB_OrdersType as ssesborderstype ");
		buffer.append(", S_SE_SB_Renums as ssesbrenums ");
//		buffer.append(", (select cast(sum(S_SE_SD_Integral*S_SE_SD_SalesValue) as numeric(18, 2)) from S_SE_SalesDetail where S_SE_SD_SalesID like '%' + ? ) AS ssesbjfamount ");
//		buffer.append(", S_SE_SB_PayCash as ssesbpaycash ");
//		buffer.append(", S_SE_SB_BankCard as ssesbbankcard ");
//		buffer.append(", S_SE_SB_StoredCard as ssesbstoredcard ");
//		buffer.append(", S_SE_SB_IntegralPrice as ssesbintegralprice ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join SYS_PersonInfo as s on s.ID = S_SE_SB_SalerID ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("where 1=1 ");
//		params.add(salesBasicPo.getSsesbsalesid());
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))) {
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcustomerid()))) {
			buffer.append("and S_SE_SB_CustomerID = ? ");
			params.add(salesBasicPo.getSsesbcustomerid());
		}

		// 未收费
		if("1".equals(salesBasicPo.getSsesbcheckoutflag())){
			buffer.append("and S_SE_SB_ValueFlag = 1 ");
		}else{
			buffer.append("and S_SE_SB_ValueFlag = 0 ");
			buffer.append("and S_SE_SB_InTransit = '1' ");
		}
		
		buffer.append(" union all ");
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid ");
		buffer.append(", S_SE_SB_PriceSum as ssesbpricesum ");
		buffer.append(", S_SE_SB_SalesValue as ssesbsalesvalue ");
		buffer.append(", S_SE_SB_ArrearsValue as ssesbarrearsvalue ");
		buffer.append(", S_SE_SB_DiscountNum as ssesbdiscountnum ");
		buffer.append(", S_SE_SB_Psalsvalue as ssesbpsalsvalue ");
//		buffer.append(", S_SE_SB_SalerID as ssesbsalerid ");
		buffer.append(", s.personName as ssesbsalerName ");
//		buffer.append(", S_SE_SB_PosID as ssesbposid ");
		buffer.append(", S_SE_SB_CheckoutFlag as ssesbcheckoutflag ");
		buffer.append(", S_SE_SB_OrdersType as ssesborderstype ");
		buffer.append(", S_SE_SB_Renums as ssesbrenums ");
//		buffer.append(", (select cast(sum(S_SE_SD_Integral*S_SE_SD_SalesValue) as numeric(18, 2)) from S_SE_SalesDetail where S_SE_SD_SalesID like '%' + ? ) AS ssesbjfamount ");
//		buffer.append(", S_SE_SB_PayCash as ssesbpaycash ");
//		buffer.append(", S_SE_SB_BankCard as ssesbbankcard ");
//		buffer.append(", S_SE_SB_StoredCard as ssesbstoredcard ");
//		buffer.append(", S_SE_SB_IntegralPrice as ssesbintegralprice ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("inner join SYS_PersonInfo as s on s.ID = S_SE_SB_SalerID ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("where 1=1 ");
//		params.add(salesBasicPo.getSsesbsalesid());
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))) {
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcustomerid()))) {
			buffer.append("and S_SE_SB_CustomerID = ? ");
			params.add(salesBasicPo.getSsesbcustomerid());
		}

		// 未收费
		if("1".equals(salesBasicPo.getSsesbcheckoutflag())){
			buffer.append("and S_SE_SB_ValueFlag = 1 ");
		}else{
			buffer.append("and S_SE_SB_ValueFlag = 0 ");
			buffer.append("and S_SE_SB_InTransit = '1' ");
		}		
		buffer.append(" )t ");

		return queryForObjectList(buffer.toString(), params.toArray(),
				SalesBasicPo.class);
	}
	
	/**
	 * 得到更新结款方式信息
	 */
	public List<SalesBasicPo> getUpdatePayTypeSalesBasics(SalesBasicPo salesBasicPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select ROW_NUMBER() Over(order by ssesbsalesid desc) as rowNum,* from ( ");
		buffer.append("select S_SE_SL_PaymentType as sseslpaymenttype, ");
		buffer.append("case  ");
		buffer.append("when S_SE_SL_PaymentType = '1' then '全款收费' ");
		buffer.append("when S_SE_SL_PaymentType = '2' then '订金收费' ");
		buffer.append("when S_SE_SL_PaymentType = '3' then '欠款收费' ");
		buffer.append("when S_SE_SL_PaymentType = '4' then '退款' ");
		buffer.append("when S_SE_SL_PaymentType = '5' then '无配镜单退款' ");
		
		buffer.append("end as sseslpaymenttypename, ");
		buffer.append("case  ");
		buffer.append("when S_SE_SL_PaymentType = '1' then S_SE_SB_SalesValue ");
		buffer.append("when S_SE_SL_PaymentType = '2' then S_SE_SB_SalesValue-S_SE_SB_ArrearsValue ");
		buffer.append("when S_SE_SL_PaymentType = '3' then S_SE_SB_ArrearsValue ");
		buffer.append("when S_SE_SL_PaymentType = '4' then S_SE_SB_SalesValue ");
		buffer.append("when S_SE_SL_PaymentType = '5' then S_SE_SB_SalesValue ");
		buffer.append("end as sseslprice, ");
		buffer.append("convert(varchar(16),S_SE_SL_DateTime,21) as ssesldatetime, ");
		buffer.append("S_SE_SB_SalesID as ssesbsalesid ");
		buffer.append(", S_SE_SB_PriceSum as ssesbpricesum ");
		buffer.append(", S_SE_SB_SalesValue as ssesbsalesvalue ");
		buffer.append(", S_SE_SB_ArrearsValue as ssesbarrearsvalue ");
		buffer.append(", S_SE_SB_DiscountNum as ssesbdiscountnum ");
		buffer.append(", S_SE_SB_Psalsvalue as ssesbpsalsvalue ");
		buffer.append(", S_SE_SB_SalerID as ssesbsalerid ");
		buffer.append(", s.personName as ssesbsalerName ");
		buffer.append(", S_SE_SB_PosID as ssesbposid ");
		buffer.append(", S_SE_SB_CheckoutFlag as ssesbcheckoutflag ");
		buffer.append(", S_SE_SB_OrdersType as ssesborderstype ");
		buffer.append(", S_SE_SB_Renums as ssesbrenums ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join SYS_PersonInfo as s on s.ID = S_SE_SB_SalerID ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("INNER JOIN S_SE_SalesLog ON S_SE_SL_SalesID = S_SE_SB_SalesID ");
		buffer.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))) {
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcustomerid()))) {
			buffer.append("and S_SE_SB_CustomerID = ? ");
			params.add(salesBasicPo.getSsesbcustomerid());
		}
		
		if (!"".equals(Utility.getName(salesBasicPo.getSseslpaymenttype()))) {
			buffer.append("and S_SE_SL_PaymentType = ? ");
			params.add(salesBasicPo.getSseslpaymenttype());
		}

		buffer.append("and S_SE_SB_ValueFlag = 1 ");
		
		buffer.append("and DATEDIFF(day,S_SE_SL_DateTime,getdate()) < cast( ? as float) ");
		buffer.append("and DATEDIFF(day,S_SE_SL_DateTime,getdate()) >= cast( '0' as float) ");
		params.add(salesBasicPo.getSsesbupdateguitartype());
		
		buffer.append("and S_SE_SB_InTransit >= 2 ");
		
		buffer.append("group by   ");
		buffer.append("   S_SE_SL_PaymentType, ");
		buffer.append("   S_SE_SB_SalesID, ");
		buffer.append("   S_SE_SB_PriceSum, ");
		buffer.append("   S_SE_SB_SalesValue, ");
		buffer.append("   S_SE_SB_ArrearsValue, ");
		buffer.append("   S_SE_SB_DiscountNum, ");
		buffer.append("   S_SE_SB_Psalsvalue, ");
		buffer.append("   S_SE_SB_SalerID, ");
		buffer.append("   s.personName, ");
		buffer.append("   S_SE_SB_PosID, ");
		buffer.append("   S_SE_SB_CheckoutFlag, ");
		buffer.append("   S_SE_SB_OrdersType, ");
		buffer.append("   convert(varchar(16),S_SE_SL_DateTime,21), ");
		buffer.append("   S_SE_SB_Renums  ");
		
		buffer.append(" union all  "); 
		
		buffer.append("select S_SE_SL_PaymentType as sseslpaymenttype, ");
		buffer.append("case  ");
		buffer.append("when S_SE_SL_PaymentType = '1' then '全款收费' ");
		buffer.append("when S_SE_SL_PaymentType = '2' then '订金收费' ");
		buffer.append("when S_SE_SL_PaymentType = '3' then '欠款收费' ");
		buffer.append("when S_SE_SL_PaymentType = '4' then '退款' ");
		buffer.append("when S_SE_SL_PaymentType = '5' then '无配镜单退款' ");
		buffer.append("end as sseslpaymenttypename, ");
		buffer.append("case  ");
		buffer.append("when S_SE_SL_PaymentType = '1' then S_SE_SB_SalesValue ");
		buffer.append("when S_SE_SL_PaymentType = '2' then S_SE_SB_SalesValue-S_SE_SB_ArrearsValue ");
		buffer.append("when S_SE_SL_PaymentType = '3' then S_SE_SB_ArrearsValue ");
		buffer.append("when S_SE_SL_PaymentType = '4' then S_SE_SB_SalesValue ");
		buffer.append("when S_SE_SL_PaymentType = '5' then S_SE_SB_SalesValue ");
		buffer.append("end as sseslprice, ");
		buffer.append("convert(varchar(16),S_SE_SL_DateTime,21) as ssesldatetime, ");
		buffer.append("S_SE_SB_SalesID as ssesbsalesid ");
		buffer.append(", S_SE_SB_PriceSum as ssesbpricesum ");
		buffer.append(", S_SE_SB_SalesValue as ssesbsalesvalue ");
		buffer.append(", S_SE_SB_ArrearsValue as ssesbarrearsvalue ");
		buffer.append(", S_SE_SB_DiscountNum as ssesbdiscountnum ");
		buffer.append(", S_SE_SB_Psalsvalue as ssesbpsalsvalue ");
		buffer.append(", S_SE_SB_SalerID as ssesbsalerid ");
		buffer.append(", s.personName as ssesbsalerName ");
		buffer.append(", S_SE_SB_PosID as ssesbposid ");
		buffer.append(", S_SE_SB_CheckoutFlag as ssesbcheckoutflag ");
		buffer.append(", S_SE_SB_OrdersType as ssesborderstype ");
		buffer.append(", S_SE_SB_Renums as ssesbrenums ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("inner join SYS_PersonInfo as s on s.ID = S_SE_SB_SalerID ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("INNER JOIN S_SE_SalesLog ON S_SE_SL_SalesID = S_SE_SB_SalesID ");
		buffer.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))) {
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcustomerid()))) {
			buffer.append("and S_SE_SB_CustomerID = ? ");
			params.add(salesBasicPo.getSsesbcustomerid());
		}
		
		if (!"".equals(Utility.getName(salesBasicPo.getSseslpaymenttype()))) {
			buffer.append("and S_SE_SL_PaymentType = ? ");
			params.add(salesBasicPo.getSseslpaymenttype());
		}

		buffer.append("and S_SE_SB_ValueFlag = 1 ");
		
		buffer.append("and DATEDIFF(day,S_SE_SL_DateTime,getdate()) < cast( ? as float) ");
		buffer.append("and DATEDIFF(day,S_SE_SL_DateTime,getdate()) >= cast( '0' as float) ");
		params.add(salesBasicPo.getSsesbupdateguitartype());
		
		buffer.append("and S_SE_SB_InTransit >= 2 ");
		
		buffer.append("group by   ");
		buffer.append("   S_SE_SL_PaymentType, ");
		buffer.append("   S_SE_SB_SalesID, ");
		buffer.append("   S_SE_SB_PriceSum, ");
		buffer.append("   S_SE_SB_SalesValue, ");
		buffer.append("   S_SE_SB_ArrearsValue, ");
		buffer.append("   S_SE_SB_DiscountNum, ");
		buffer.append("   S_SE_SB_Psalsvalue, ");
		buffer.append("   S_SE_SB_SalerID, ");
		buffer.append("   s.personName, ");
		buffer.append("   S_SE_SB_PosID, ");
		buffer.append("   S_SE_SB_CheckoutFlag, ");
		buffer.append("   S_SE_SB_OrdersType, ");
		buffer.append("   convert(varchar(16),S_SE_SL_DateTime,21), ");
		buffer.append("   S_SE_SB_Renums  "); 		
		buffer.append(" )t  "); 

		return queryForObjectList(buffer.toString(), params.toArray(),
				SalesBasicPo.class);
	}

	/**
	 * 根据销售单号将信息插入在途明细表中
	 * 
	 * @param inTransitPo
	 */
	public void insertIntrnsitInfo(InTransitPo inTransitPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into S_SE_InTransit( ");
		buffer.append("S_SE_IT_ID, S_SE_IT_SalesID, S_SE_IT_State ");
		buffer.append(", S_SE_IT_Date, S_SE_IT_CreatePerson ");
		buffer.append(", S_SE_IT_Department ) ");
		buffer.append("values (? , ? , ? , getdate() , ? , ?) ");

		params.add(this.uuid.generate());
		params.add(inTransitPo.getSseitsalesid());
		params.add(inTransitPo.getSseitstate());
		params.add(inTransitPo.getSseitcreateperson());
		params.add(inTransitPo.getSseitdepartment());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 根据销售单号将信息插入当月库存变更表中
	 * 
	 * @param strogeChangePo
	 */
	public void insertStrogeChange(String salesid, String stockid) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into C_SH_StorageChange( ");
		buffer.append("C_SH_SC_UUID,C_SH_SC_GoodsBarCode ");
		buffer.append(", C_SH_SC_GoodsId ");
		buffer.append(", C_SH_SC_StockId ");
		buffer.append(", C_SH_SC_GoodsQuantity ");
		buffer.append(", C_SH_SC_CostPrice ");
		buffer.append(", C_SH_SC_NotTaxRate ");
		buffer.append(", C_SH_SC_WarehousingDate ");
		buffer.append(", C_SH_SC_ChangeID) ");
		buffer.append("(select replace(NEWID(),'-',''),replace(S_SE_SD_SalesItemID,'.','') ");
		buffer.append(", S_SE_SD_SalesItemID ");
		buffer.append(", S_SE_SD_StockId ");
		buffer.append(", '-'+cast(S_SE_SD_Number as varchar) ");
		buffer.append(", S_SE_SD_CostsPrive ");
		buffer.append(", S_SE_SD_UnitPrice ");
		buffer.append(", getdate() ");
		buffer.append(", S_SE_SD_SalesID ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join B_Warehouse ");
		buffer.append("on B_WH_ID = S_SE_SD_StockId ");
		buffer.append("where isnull(S_SE_SD_ItemID, '') <> '' ");
		buffer.append("and substring(S_SE_SD_ItemID,2,2)<> 'zz' ");
		buffer.append("and S_SE_SD_SalesID= ? ");
		buffer.append("and S_SE_SD_StockId= ? ");
		buffer.append(")");

		params.add(salesid);
		params.add(stockid);

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	
	/**
	 * New Sales Change Storge
	 * 2012-12-13
	 * @param strogeChangePo
	 */
	public void insertStrogeChangeNew(String salesid,String warehouseID) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into C_SH_StorageChange( ");
		buffer.append("C_SH_SC_UUID,C_SH_SC_GoodsBarCode ");
		buffer.append(", C_SH_SC_GoodsId ");
		buffer.append(", C_SH_SC_StockId ");
		buffer.append(", C_SH_SC_GoodsQuantity ");
		buffer.append(", C_SH_SC_CostPrice ");
		buffer.append(", C_SH_SC_NotTaxRate ");
		buffer.append(", C_SH_SC_WarehousingDate ");
		buffer.append(", C_SH_SC_ChangeID) ");
		buffer.append("(select replace(NEWID(),'-',''),replace(S_SE_SD_SalesItemID,'.','') ");
		buffer.append(", S_SE_SD_SalesItemID ");
		if (Utility.getName(warehouseID).equals("")){
			buffer.append(", S_SE_SD_StockId ");
		}else{
			buffer.append(", ? ");
		}		
		buffer.append(", -S_SE_SD_Number ");
		buffer.append(", S_SE_SD_CostsPrive ");
		buffer.append(", S_SE_SD_UnitPrice ");
		buffer.append(", getdate() ");
		buffer.append(", S_SE_SD_SalesID ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join B_Warehouse ");
		buffer.append("on B_WH_ID = S_SE_SD_StockId ");
		buffer.append("where isnull(S_SE_SD_ItemID, '') <> '' ");
		buffer.append("and substring(S_SE_SD_ItemID,2,2)<> 'zz' ");
		buffer.append("and S_SE_SD_SalesID= ? and isnull(S_SE_SD_OutStorageFlag,'')<> '1'");
		buffer.append(")");

		if (!Utility.getName(warehouseID).equals("")){
			params.add(Utility.getName(warehouseID));
		}	
		
		params.add(Utility.getName(salesid));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * New Sales Change Storge
	 * 2012-12-13
	 * @param strogeChangePo
	 */
	public void insertStrogeChangeNewNoZengPin(String salesid,String warehouseID) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into C_SH_StorageChange( ");
		buffer.append("C_SH_SC_UUID,C_SH_SC_GoodsBarCode ");
		buffer.append(", C_SH_SC_GoodsId ");
		buffer.append(", C_SH_SC_StockId ");
		buffer.append(", C_SH_SC_GoodsQuantity ");
		buffer.append(", C_SH_SC_CostPrice ");
		buffer.append(", C_SH_SC_NotTaxRate ");
		buffer.append(", C_SH_SC_WarehousingDate ");
		buffer.append(", C_SH_SC_ChangeID) ");
		buffer.append("(select replace(NEWID(),'-',''),replace(S_SE_SD_SalesItemID,'.','') ");
		buffer.append(", S_SE_SD_SalesItemID ");
		if (Utility.getName(warehouseID).equals("")){
			buffer.append(", S_SE_SD_StockId ");
		}else{
			buffer.append(", ? ");
		}		
		buffer.append(", -S_SE_SD_Number ");
		buffer.append(", S_SE_SD_CostsPrive ");
		buffer.append(", S_SE_SD_UnitPrice ");
		buffer.append(", getdate() ");
		buffer.append(", S_SE_SD_SalesID ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join B_Warehouse on B_WH_ID = S_SE_SD_StockId ");
		buffer.append("where isnull(S_SE_SD_ItemID, '') <> '' ");
		buffer.append("and substring(S_SE_SD_ItemID,2,2)<> 'zz' ");
		buffer.append("and S_SE_SD_SalesID= ? and S_SE_SD_LargessFlag = '0' ");
		buffer.append("union all ");
		buffer.append("select replace(NEWID(),'-',''),replace(S_SE_SD_SalesItemID,'.','') ");
		buffer.append(", S_SE_SD_SalesItemID ");
		if (Utility.getName(warehouseID).equals("")){
			buffer.append(", S_SE_SD_StockId ");
		}else{
			buffer.append(", ? ");
		}		
		buffer.append(", -S_SE_SD_Number ");
		buffer.append(", S_SE_SD_CostsPrive ");
		buffer.append(", S_SE_SD_UnitPrice ");
		buffer.append(", getdate() ");
		buffer.append(", S_SE_SD_SalesID ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join B_Warehouse on B_WH_ID = S_SE_SD_StockId ");
		buffer.append("inner join B_Gifts on S_SE_SD_SalesItemID = B_GS_GoodsID ");
		buffer.append("where isnull(S_SE_SD_ItemID, '') <> '' ");
		buffer.append("and substring(S_SE_SD_ItemID,2,2)<> 'zz' ");
		buffer.append("and S_SE_SD_SalesID= ? and S_SE_SD_LargessFlag = '1' and isnull(B_GS_Type,'') <> '2' ");
		
		buffer.append(")");

		if (!Utility.getName(warehouseID).equals("")){
			params.add(Utility.getName(warehouseID));
		}	
		
		params.add(Utility.getName(salesid));

		if (!Utility.getName(warehouseID).equals("")){
			params.add(Utility.getName(warehouseID));
		}	
		
		params.add(Utility.getName(salesid));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 根据销售单号将信息插入当月库存日志表中
	 * 
	 * @param strogeChangePo
	 */
	public void insertStrogeChangeLog(String salesid, String stockid) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into C_SH_StorageLog( ");
		buffer.append("C_SH_Sl_GoodsBarCode ");
		buffer.append(", C_SH_Sl_GoodsId ");
		buffer.append(", C_SH_Sl_StockId ");
		buffer.append(", C_SH_Sl_GoodsQuantity ");
		buffer.append(", C_SH_Sl_CostPrice ");
		buffer.append(", C_SH_Sl_NotTaxRate ");
		buffer.append(", C_SH_Sl_WarehousingDate ");
		buffer.append(", C_SH_Sl_ChangeID,C_SH_Sl_UUID) ");
		buffer.append("(select S_SE_SD_ItemID ");
		buffer.append(", S_SE_SD_SalesItemID ");
		buffer.append(", S_SE_SD_StockId ");
		buffer.append(", '-'+cast(S_SE_SD_Number as varchar) ");
		buffer.append(", S_SE_SD_CostsPrive ");
		buffer.append(", S_SE_SD_UnitPrice ");
		buffer.append(", getdate() ");
		buffer.append(", S_SE_SD_SalesID,replace(NEWID(),'-','') ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join B_Warehouse ");
		buffer.append("on B_WH_ID = S_SE_SD_StockId ");
		buffer.append("where isnull(S_SE_SD_ItemID, '') <> '' ");
		buffer.append("and substring(S_SE_SD_ItemID,2,2)<> 'zz' ");
		buffer.append("and S_SE_SD_SalesID= ? ");
		buffer.append("and S_SE_SD_StockId= ? ");
		buffer.append(")");

		params.add(salesid);
		params.add(stockid);

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * New Sales change stroge
	 * 
	 * @param strogeChangePo
	 */
	public void insertStrogeChangeLogNew(String salesid,String warehouseID) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into C_SH_StorageLog( ");
		buffer.append("C_SH_Sl_GoodsBarCode ");
		buffer.append(", C_SH_Sl_GoodsId ");
		buffer.append(", C_SH_Sl_StockId ");
		buffer.append(", C_SH_Sl_GoodsQuantity ");
		buffer.append(", C_SH_Sl_CostPrice ");
		buffer.append(", C_SH_Sl_NotTaxRate ");
		buffer.append(", C_SH_Sl_WarehousingDate ");
		buffer.append(", C_SH_Sl_ChangeID,C_SH_Sl_UUID,C_SH_SL_GuaranteePeriod,C_SH_SL_Batch) ");
		buffer.append("(select S_SE_SD_ItemID ");
		buffer.append(", S_SE_SD_SalesItemID ");
		if (Utility.getName(warehouseID).equals("")){
			buffer.append(", S_SE_SD_StockId ");
		}else{
			buffer.append(", ? ");
		}	
		buffer.append(", -S_SE_SD_Number ");
		buffer.append(", S_SE_SD_CostsPrive ");
		buffer.append(", S_SE_SD_UnitPrice ");
		buffer.append(", getdate() ");
		buffer.append(", S_SE_SD_SalesID,replace(NEWID(),'-',''),S_SE_SD_Guaranteeperiod,S_SE_SD_Batch ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join B_Warehouse ");
		buffer.append("on B_WH_ID = S_SE_SD_StockId ");
		buffer.append("where isnull(S_SE_SD_ItemID, '') <> '' ");
		buffer.append("and substring(S_SE_SD_ItemID,2,2)<> 'zz' ");
		buffer.append("and S_SE_SD_SalesID= ? and isnull(S_SE_SD_OutStorageFlag,'')<> '1'");
		buffer.append(")");

		if (!Utility.getName(warehouseID).equals("")){
			params.add(Utility.getName(warehouseID));
		}	
		params.add(Utility.getName(salesid));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void insertStrogeChangeLogNewNoZengPin(String salesid,String warehouseID) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into C_SH_StorageLog( ");
		buffer.append("C_SH_Sl_GoodsBarCode ");
		buffer.append(", C_SH_Sl_GoodsId ");
		buffer.append(", C_SH_Sl_StockId ");
		buffer.append(", C_SH_Sl_GoodsQuantity ");
		buffer.append(", C_SH_Sl_CostPrice ");
		buffer.append(", C_SH_Sl_NotTaxRate ");
		buffer.append(", C_SH_Sl_WarehousingDate ");
		buffer.append(", C_SH_Sl_ChangeID,C_SH_Sl_UUID,C_SH_SL_GuaranteePeriod,C_SH_SL_Batch) ");
		buffer.append("(select S_SE_SD_ItemID ");
		buffer.append(", S_SE_SD_SalesItemID ");
		if (Utility.getName(warehouseID).equals("")){
			buffer.append(", S_SE_SD_StockId ");
		}else{
			buffer.append(", ? ");
		}	
		buffer.append(", -S_SE_SD_Number ");
		buffer.append(", S_SE_SD_CostsPrive ");
		buffer.append(", S_SE_SD_UnitPrice ");
		buffer.append(", getdate() ");
		buffer.append(", S_SE_SD_SalesID,replace(NEWID(),'-',''),S_SE_SD_Guaranteeperiod,S_SE_SD_Batch ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join B_Warehouse on B_WH_ID = S_SE_SD_StockId ");
		buffer.append("where isnull(S_SE_SD_ItemID, '') <> '' ");
		buffer.append("and substring(S_SE_SD_ItemID,2,2)<> 'zz' ");
		buffer.append("and S_SE_SD_SalesID= ?  and S_SE_SD_LargessFlag = '0' ");
		buffer.append("union all ");
		buffer.append("select S_SE_SD_ItemID ");
		buffer.append(", S_SE_SD_SalesItemID ");
		if (Utility.getName(warehouseID).equals("")){
			buffer.append(", S_SE_SD_StockId ");
		}else{
			buffer.append(", ? ");
		}	
		buffer.append(", -S_SE_SD_Number ");
		buffer.append(", S_SE_SD_CostsPrive ");
		buffer.append(", S_SE_SD_UnitPrice ");
		buffer.append(", getdate() ");
		buffer.append(", S_SE_SD_SalesID,replace(NEWID(),'-',''),S_SE_SD_Guaranteeperiod,S_SE_SD_Batch ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join B_Warehouse on B_WH_ID = S_SE_SD_StockId ");
		buffer.append("inner join B_Gifts on S_SE_SD_SalesItemID = B_GS_GoodsID ");
		buffer.append("where isnull(S_SE_SD_ItemID, '') <> '' ");
		buffer.append("and substring(S_SE_SD_ItemID,2,2)<> 'zz' ");
		buffer.append("and S_SE_SD_SalesID= ?  and S_SE_SD_LargessFlag = '1' and isnull(B_GS_Type,'')<> '2' ");
		
		buffer.append(")");

		if (!Utility.getName(warehouseID).equals("")){
			params.add(Utility.getName(warehouseID));
		}	
		params.add(Utility.getName(salesid));
		if (!Utility.getName(warehouseID).equals("")){
			params.add(Utility.getName(warehouseID));
		}	
		params.add(Utility.getName(salesid));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public List<StrogeChangePo> getStrogeChangeLogNewTemp(String salesid,
			String warehouseID) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select S_SE_SD_ItemID as cshscgoodsbarcode ");
		buffer.append(", S_SE_SD_SalesItemID as cshscgoodsid ");

		if (Utility.getName(warehouseID).equals("")){
			buffer.append(", S_SE_SD_StockId as cshscstockid ");
		}else{
			buffer.append(", ? as cshscstockid ");
		}
		buffer.append(", '-'+cast(S_SE_SD_Number as varchar) as cshscgoodsquantity ");
		buffer.append(", S_SE_SD_CostsPrive as cshsccostprice");
		buffer.append(", S_SE_SD_UnitPrice as cshscnottaxrate");
		buffer.append(", getdate() as cshscwarehousingdate");
		buffer.append(", S_SE_SD_SalesID as cshscchangeid,replace(NEWID(),'-','') as cshscuuid,S_SE_SD_Guaranteeperiod as cshscguaranteeperiod,S_SE_SD_Batch as cshscBatch ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join B_Warehouse ");
		buffer.append("on B_WH_ID = S_SE_SD_StockId ");
		buffer.append("where isnull(S_SE_SD_ItemID, '') <> '' ");
		buffer.append("and substring(S_SE_SD_ItemID,2,2)<> 'zz' ");
		buffer.append("and S_SE_SD_SalesID= ? ");
		
		if (!Utility.getName(warehouseID).equals("")){
			params.add(Utility.getName(warehouseID));
		}	
		params.add(Utility.getName(salesid));

		return queryForObjectList(buffer.toString(), params.toArray(), StrogeChangePo.class);
	}


	/**
	 * 更新销售基表中的在途点
	 * 
	 * @param salesDetailPo
	 */
	public void updateMaterialsInTransit(SalesBasicPo salesBasicPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("update S_SE_SalesBasic ");
		buffer.append("set S_SE_SB_InTransit= ? ");
		buffer.append(", S_SE_SB_ValueFlag = '1' ");
		buffer.append(", S_SE_SB_PosID = ?,S_SE_SB_FactPosDatetime = getdate(),S_SE_SB_PosDatetime = dbo.ufn_getDayCheckOut() ");
		buffer.append(", S_SE_SB_PayCash = ?,S_SE_SB_BankCard = ? ");
		buffer.append(", S_SE_SB_StoredCard = ?,S_SE_SB_Integral=?,S_SE_SB_IntegralPrice=? ");
		if("1".equals(salesBasicPo.getSsesbcheckoutflag())){
			buffer.append(", S_SE_SB_ArrearsDate = getdate() ");
		}
		buffer.append(",S_SE_SB_DueIntegral=? ");
		buffer.append("where S_SE_SB_SalesID= ? ");

		params.add(Utility.getName(salesBasicPo.getSsesbintransit()));
		params.add(Utility.getName(salesBasicPo.getSsesbposid()));
		params.add(Utility.getName(salesBasicPo.getSsesbpaycash()).equals("") ? "0.00" : Utility.getName(salesBasicPo.getSsesbpaycash()));
		params.add(Utility.getName(salesBasicPo.getSsesbbankcard()).equals("") ? "0.00" : Utility.getName(salesBasicPo.getSsesbbankcard()));
		params.add(Utility.getName(salesBasicPo.getSsesbstoredcard()).equals("") ? "0.00" : Utility.getName(salesBasicPo.getSsesbstoredcard()));
		params.add(Utility.getName(salesBasicPo.getSsesbintegral()).equals("") ? "0" : Utility.getName(salesBasicPo.getSsesbintegral()));
		params.add(Utility.getName(salesBasicPo.getSsesbintegralprice()).equals("") ? "0" : Utility.getName(salesBasicPo.getSsesbintegralprice()));
		params.add(Utility.getName(salesBasicPo.getSsesbjfamount()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void deleteGuitarManagement(String salesID) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM S_SE_SalesBasic ");
		buffer.append("WHERE S_SE_SB_SalesID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(salesID);

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());

	}

	public void deleteGuitarManagementDetail(String salesID) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM S_SE_SalesDetail ");
		buffer.append("WHERE S_SE_SD_SalesID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(salesID);

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void updateCustomerIntegral(String salesID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE S_ME_CustomerInfo ");
		buffer.append("SET S_ME_CI_Integral =  ");
		buffer.append("S_ME_CI_Integral + S_SE_SB_SalesValue ");
		buffer.append("FROM S_ME_CustomerInfo ");
		buffer.append("INNER JOIN ");
		buffer.append("S_SE_SalesBasic ON ");
		buffer.append("S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("WHERE S_SE_SB_SalesID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(salesID);

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void updateCustomerIntegralNew(String salesID,String integral,String count,String price,String fcustomerid){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if(Utility.getName(fcustomerid).equals("")){
			buffer.append("UPDATE S_ME_CustomerInfo ");
			buffer.append("SET S_ME_CI_Integral = S_ME_CI_Integral + " + integral +", ");
			buffer.append("    S_ME_CI_ConsumptionNumber = cast(isnull(S_ME_CI_ConsumptionNumber,'0') as numeric(18,0)) + " + count + ", ");
			buffer.append("    S_ME_CI_ConsumptionPrice = isnull(S_ME_CI_ConsumptionPrice,0) + cast(" + price +" as numeric(18,2)) ");
			buffer.append("FROM S_ME_CustomerInfo ");
			
			buffer.append("left JOIN ");
			buffer.append("uview_SalesBasic ON ");
			buffer.append("S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
			buffer.append("WHERE S_SE_SB_SalesID = ? ");
			params.add(salesID);
			
		}else{
			buffer.append("UPDATE S_ME_CustomerInfo ");
			buffer.append("SET S_ME_CI_Integral = S_ME_CI_Integral + " + integral );
			buffer.append("FROM S_ME_CustomerInfo ");
			buffer.append("WHERE S_ME_CI_CustomerID = ? ");
			params.add(Utility.getName(fcustomerid));
			
			buffer.append("UPDATE S_ME_CustomerInfo ");
			buffer.append("SET ");
			buffer.append("    S_ME_CI_ConsumptionNumber = cast(isnull(S_ME_CI_ConsumptionNumber,'0') as numeric(18,0)) + " + count + ", ");
			buffer.append("    S_ME_CI_ConsumptionPrice = isnull(S_ME_CI_ConsumptionPrice,0) + cast(" + price +" as numeric(18,2)) ");
			buffer.append("FROM S_ME_CustomerInfo ");
			
			if(count.equals("0")){
				buffer.append("WHERE S_ME_CI_CustomerID = ? ");
				params.add(Utility.getName(fcustomerid));
			}else{
				buffer.append("left JOIN ");
				buffer.append("uview_SalesBasic ON ");
				buffer.append("S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
				buffer.append("WHERE S_SE_SB_SalesID = ? ");
				params.add(salesID);
			}
		}

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	public void updateCustomerIntegralNew2(String salesID,String integral,String count,String price,String fcustomerid){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if(Utility.getName(fcustomerid).equals("")){
			buffer.append("UPDATE S_ME_CustomerInfo ");
			buffer.append("SET S_ME_CI_Integral = S_ME_CI_Integral + " + integral +" ");
			buffer.append("FROM S_ME_CustomerInfo ");
			
			if(count.equals("0")){
				buffer.append("WHERE S_ME_CI_CustomerID = ? ");
			}else{
				buffer.append("left JOIN ( ");
				buffer.append(" select S_SE_SB_SalesID,S_SE_SB_CustomerID from ( ");
				buffer.append(" select S_SE_SB_SalesID,S_SE_SB_CustomerID from S_SE_SalesBasic union all ");
				buffer.append(" select S_SE_SB_SalesID,S_SE_SB_CustomerID from S_SE_SalesBasic_Finished ");				
				buffer.append(" )t )t ON S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
				buffer.append("WHERE S_SE_SB_SalesID = ? ");
			}
			
			params.add(salesID);
		}else{
			buffer.append("UPDATE S_ME_CustomerInfo ");
			buffer.append("SET S_ME_CI_Integral = S_ME_CI_Integral + " + integral );
			buffer.append("FROM S_ME_CustomerInfo ");
			buffer.append("WHERE S_ME_CI_CustomerID = ? ");
			params.add(Utility.getName(fcustomerid));
			
		}
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void updateReturnCustomerIntegral(String salesID,String integral){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("UPDATE S_ME_CustomerInfo ");
		buffer.append("SET S_ME_CI_Integral = S_ME_CI_Integral + cast(" + integral +" as float) ");
		buffer.append("FROM S_ME_CustomerInfo ");
		buffer.append("INNER JOIN ");
		buffer.append("S_SE_SalesBasic ON ");
		buffer.append("S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("WHERE S_SE_SB_SalesID = ? ");
		
		List<String> params = new ArrayList<String>();
		params.add(salesID);

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void updateCustomerIntegral(String memberid,String integral){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("declare @id varchar(32) ");
		buffer.append("declare @cid varchar(32) ");
		
		buffer.append("set @id = ? ");
		params.add(memberid);
		
		buffer.append("select  ");
		buffer.append("@cid = S_ME_CI_FCustomerID ");
		buffer.append("from S_ME_CustomerInfo ");
		buffer.append("where S_ME_CI_MemberId = @id ");
		
		buffer.append("if(@cid <> '') ");
		buffer.append("	begin ");
		buffer.append("UPDATE S_ME_CustomerInfo ");
		buffer.append("SET S_ME_CI_Integral = S_ME_CI_Integral - " + integral +" ");
		buffer.append("FROM S_ME_CustomerInfo ");
		buffer.append("WHERE S_ME_CI_CustomerID = @cid ");
		buffer.append("	end ");
		buffer.append("	else ");
		buffer.append("	begin ");
		buffer.append("UPDATE S_ME_CustomerInfo ");
		buffer.append("SET S_ME_CI_Integral = S_ME_CI_Integral - " + integral +" ");
		buffer.append("FROM S_ME_CustomerInfo ");
		buffer.append("WHERE S_ME_CI_MemberId = @id ");
		buffer.append("	end ");
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void updateCustomerIntegrals(String openID,String integral){
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE S_ME_CustomerInfo ");
		buffer.append("SET S_ME_CI_Integral = S_ME_CI_Integral - " + integral +" ");
		buffer.append("FROM S_ME_CustomerInfo ");
		buffer.append("WHERE S_ME_CI_OpenID = ? ");
		
		List<String> params = new ArrayList<String>();
		params.add(openID);

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	public void insertIntegralExchange(IntegralExchangePo integralExchangePo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("declare @id varchar(32) ");
		buffer.append("declare @cid varchar(32) ");
		buffer.append("declare @mid varchar(32) ");
		
		buffer.append("set @id = ? ");
		buffer.append("set @mid = ? ");
		params.add(integralExchangePo.getFilmemberid());
		params.add(integralExchangePo.getFilcustomername());
		
		buffer.append("select  ");
		buffer.append("@cid = S_ME_CI_FCustomerID ");
		buffer.append("from S_ME_CustomerInfo ");
		buffer.append("where S_ME_CI_MemberId = @id ");
		
		buffer.append("if(@cid <> '') ");
		buffer.append("	begin ");
		buffer.append("select  ");
		buffer.append("@id = S_ME_CI_MemberId, ");
		buffer.append("@mid = S_ME_CI_CustomerID ");
		buffer.append("from S_ME_CustomerInfo ");
		buffer.append("where S_ME_CI_CustomerID = @cid ");
		buffer.append("	end ");
		
		buffer.append("insert into F_IntegralExchangeLog ( ");
		buffer.append("F_IL_UUID,F_IL_MemberId,F_IL_IntegralCount,F_IL_PersonID,F_IL_Datetime,F_IL_FactDatetime,F_IL_DepartmentID,F_IL_CustomerID,F_IL_IntegralSum,F_IL_OutStockID,F_IL_InStockID,F_IL_RefundFlag ) ");
		buffer.append("values (?,@id,?,?,dbo.ufn_getDayCheckOut(),getdate(),?,@mid,?,?,?,? )");
		params.add(integralExchangePo.getFiluuid());
		params.add(integralExchangePo.getFilintegralCount());
		params.add(integralExchangePo.getFilpersonid());
		params.add(integralExchangePo.getFildepartmentid());
		params.add(integralExchangePo.getFilintegralsum());		
		params.add(Utility.getName(integralExchangePo.getFilstock()));
		params.add(Utility.getName(integralExchangePo.getFilinstock()));
		params.add(Utility.getName(integralExchangePo.getFilrefundflag()));
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void insertIntegralExchangeEntry(IntegralExchangeEntryPo integralExchangeEntryPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into F_IntegralExchangeLogEntry  ( ");
		buffer.append("F_ILE_GUUID,F_ILE_GoodsID,F_ILE_UUID,F_ILE_GoodsName,F_ILE_IntegralCount,F_ILE_GoodsCode,F_ILE_GoodsNumber,F_ILE_NotTaxRate,F_ILE_CostPrice,F_ILE_AverageNotTaxRate,F_ILE_CostPriceAmount,F_ILE_NotTaxRateAmount,F_ILE_RetailPrice,F_ILE_TaxAmount,F_ILE_OutStockID,F_ILE_InStockID,F_ILE_TaxRate ) ");
		buffer.append("values (newid(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )");
		
		params.add(integralExchangeEntryPo.getFilegoodsid());
		params.add(integralExchangeEntryPo.getFileuuid());
		params.add(integralExchangeEntryPo.getFilegoodsname());
		params.add("-"+Utility.getName(integralExchangeEntryPo.getFileintegralCount()));
		params.add(integralExchangeEntryPo.getFilegoodscode());
		params.add(integralExchangeEntryPo.getFilegoodsnumber()); 	
		params.add(Utility.getName(integralExchangeEntryPo.getFilegoodsnottaxrate()).equals("") ? "0" : Utility.getName(integralExchangeEntryPo.getFilegoodsnottaxrate()));
		params.add(Utility.getName(integralExchangeEntryPo.getFilegoodscostprice()).equals("") ? "0" : Utility.getName(integralExchangeEntryPo.getFilegoodscostprice()));
		params.add(Utility.getName(integralExchangeEntryPo.getFilegoodavgnottaxrate()).equals("") ? "0" : Utility.getName(integralExchangeEntryPo.getFilegoodavgnottaxrate()));
		params.add(Utility.getName(integralExchangeEntryPo.getFilegoodscostpriceamount()).equals("") ? "0" : Utility.getName(integralExchangeEntryPo.getFilegoodscostpriceamount()));
		params.add(Utility.getName(integralExchangeEntryPo.getFilegoodsnottaxrateamount()).equals("") ? "0" : Utility.getName(integralExchangeEntryPo.getFilegoodsnottaxrateamount()));		
		params.add(Utility.getName(integralExchangeEntryPo.getFilegoodsretailprice()).equals("") ? "0" : Utility.getName(integralExchangeEntryPo.getFilegoodsretailprice()));
		params.add(Utility.getName(integralExchangeEntryPo.getFilegoodstaxamount()).equals("") ? "0" : Utility.getName(integralExchangeEntryPo.getFilegoodstaxamount()));			
		params.add(Utility.getName(integralExchangeEntryPo.getFileoutstock()));
		params.add(Utility.getName(integralExchangeEntryPo.getFileinstock()));
		params.add(Utility.getName(integralExchangeEntryPo.getFilegoodstaxrate()).equals("") ? "17" : Utility.getName(integralExchangeEntryPo.getFilegoodstaxrate()));

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void insertCustomize(SalesBasicPo salesBasicPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO S_Se_Customize (s_se_c_salesid,s_se_c_arrearsDate,s_se_c_arrearsValue,s_se_c_customizeValue,s_se_c_FactarrearsDate) ");
		sb.append("select top 1 ?,dbo.ufn_getDayCheckOut(),S_SE_SB_ArrearsValue,S_SE_SB_Psalsvalue,getdate() from s_se_salesbasic where s_se_sb_salesid=? and S_SE_SB_CheckoutFlag='1'");
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid         ()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid         ()));
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 取得结款记录表Po
	 */
	public SalesLogPo getSalesLog(SalesLogPo salesLogPo) {
		List<String> params = new ArrayList<String>();

		StringBuffer  buffer = new StringBuffer();
		buffer.append("SELECT top 1 S_SE_SL_UUID as ssesluuid, ");
		buffer.append("       S_SE_SL_SalesID as sseslsalesid, ");
		buffer.append("       S_SE_SL_PaymentType as sseslpaymenttype, ");
		buffer.append("       S_SE_SL_ConsumptionID as sseslconsumptionid, ");
		buffer.append("       S_SE_SL_Price as sseslprice, ");
		buffer.append("       S_SE_SL_DateTime as ssesldatetime, ");
		buffer.append("       S_SE_SL_Person as sseslperson, ");
		buffer.append("       S_SE_SL_Orderby+1 as sseslorderby ");
		buffer.append("FROM   S_SE_SalesLog ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(salesLogPo.getSseslpaymenttype()))){
			buffer.append("and S_SE_SL_PaymentType = ? ");
			params.add(salesLogPo.getSseslpaymenttype());
		}
		
		buffer.append("and S_SE_SL_SalesID = ? ");
		params.add(salesLogPo.getSseslsalesid());
		
		buffer.append("order by S_SE_SL_DateTime desc ");
		
		return (SalesLogPo) queryForObject(buffer.toString(), params
				.toArray(), SalesLogPo.class);
	}
	
	/**
	 * 取得结款记录表Po
	 */
	public List<SalesLogPo> getSalesLogs(SalesLogPo salesLogPo) {
		List<String> params = new ArrayList<String>();

		StringBuffer  buffer = new StringBuffer();
		buffer.append("SELECT S_SE_SL_UUID as ssesluuid, ");
		buffer.append("       S_SE_SL_SalesID as sseslsalesid, ");
		buffer.append("       S_SE_SL_PaymentType as sseslpaymenttype, ");
		buffer.append("       S_SE_SL_ConsumptionID as sseslconsumptionid, ");
		buffer.append("       S_SE_SL_Price as sseslprice, ");
		buffer.append("       S_SE_SL_DateTime as ssesldatetime, ");
		buffer.append("       S_SE_SL_Person as sseslperson, ");
		buffer.append("       S_SE_SL_Orderby+1 as sseslorderby,S_SE_SL_SourceID as sseslsourceid ");
		buffer.append("FROM   S_SE_SalesLog ");
		buffer.append("WHERE  1=1 and cast(S_SE_SL_Price as numeric(30,2))<>0 ");
		
		if(!"".equals(Utility.getName(salesLogPo.getSseslpaymenttype()))){
			buffer.append("and S_SE_SL_ConsumptionID = ? ");
			params.add(salesLogPo.getSseslpaymenttype());
		}
		
		buffer.append("and S_SE_SL_SalesID = ? ");
		params.add(salesLogPo.getSseslsalesid());
		
		return queryForObjectList(buffer.toString(), params.toArray(), SalesLogPo.class);
	}
	
	/**
	 * 销售日志插入
	 * @param salesLogPo
	 */
	public void insertSalesLog(SalesLogPo salesLogPo) {
		List<String> params = new ArrayList<String>();
		StringBuffer  buffer = new StringBuffer();
		
		buffer.append("INSERT INTO dbo.S_SE_SalesLog ");
		buffer.append("            (S_SE_SL_UUID, ");
		buffer.append("             S_SE_SL_SalesID, ");
		buffer.append("             S_SE_SL_PaymentType, ");
		buffer.append("             S_SE_SL_ConsumptionID,");
		if (!"".equals(Utility.getName(salesLogPo.getSseslintegralprice()))){
			buffer.append("             S_SE_SL_IntegralPrice, ");
		}		
		buffer.append("             S_SE_SL_Price, ");
		buffer.append("             S_SE_SL_DateTime, ");
		buffer.append("             S_SE_SL_FactDateTime, ");
		buffer.append("             S_SE_SL_Person, ");
		buffer.append("             S_SE_SL_Orderby, ");
		buffer.append("             S_SE_SL_SourceID, ");
		buffer.append("             S_SE_SL_ShopCode, ");
		buffer.append("             S_SE_SL_Type) ");
		buffer.append("VALUES      ( ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		if (!"".equals(Utility.getName(salesLogPo.getSseslintegralprice()))){
			buffer.append("              ?, ");
		}
		buffer.append("              ?, ");
		buffer.append("              dbo.ufn_getDayCheckOut(), ");
		buffer.append("              getdate(), ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ? ) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(salesLogPo.getSseslsalesid()));
		params.add(Utility.getName(salesLogPo.getSseslpaymenttype()));
		params.add(Utility.getName(salesLogPo.getSseslconsumptionid()));
		if (!"".equals(Utility.getName(salesLogPo.getSseslintegralprice()))){
			params.add(Utility.getName(salesLogPo.getSseslintegralprice()));
		}
		params.add(Utility.getName(salesLogPo.getSseslprice()));
		params.add(Utility.getName(salesLogPo.getSseslperson()));
		params.add(Utility.getName(salesLogPo.getSseslorderby()));
		params.add(Utility.getName(salesLogPo.getSseslsourceid()));
		params.add(Utility.getName(salesLogPo.getSseslshopcode()));
		params.add(Utility.getName(salesLogPo.getSsesltype()));
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());	
	}
	
	/**
	 * 销售日志插入
	 * @param salesLogPo
	 */
	public void insertSalesLogForUpdatePaymentType(SalesLogPo salesLogPo) {
		List<String> params = new ArrayList<String>();
		StringBuffer  buffer = new StringBuffer();
		
		buffer.append("INSERT INTO dbo.S_SE_SalesLog ");
		buffer.append("            (S_SE_SL_UUID, ");
		buffer.append("             S_SE_SL_SalesID, ");
		buffer.append("             S_SE_SL_PaymentType, ");
		buffer.append("             S_SE_SL_ConsumptionID,");
		if (!"".equals(Utility.getName(salesLogPo.getSseslintegralprice()))){
			buffer.append("             S_SE_SL_IntegralPrice, ");
		}		
		buffer.append("             S_SE_SL_Price, ");
		buffer.append("             S_SE_SL_DateTime, ");
		buffer.append("             S_SE_SL_FactDateTime, ");
		buffer.append("             S_SE_SL_Person, ");
		buffer.append("             S_SE_SL_Orderby, ");
		buffer.append("             S_SE_SL_SourceID, ");
		buffer.append("             S_SE_SL_ShopCode, ");
		buffer.append("             S_SE_SL_Type) ");
		buffer.append("select        ?, ");
		params.add(this.uuid.generate());
		
		buffer.append("              ?, ");
		params.add(Utility.getName(salesLogPo.getSseslsalesid()));
		
		buffer.append("              ?, ");
		params.add(Utility.getName(salesLogPo.getSseslpaymenttype()));
		
		buffer.append("              ?, ");
		params.add(Utility.getName(salesLogPo.getSseslconsumptionid()));
		
		if (!"".equals(Utility.getName(salesLogPo.getSseslintegralprice()))){
			buffer.append("              ?, ");
			params.add(Utility.getName(salesLogPo.getSseslintegralprice()));
		}
		
		buffer.append("              ?, ");
		params.add(Utility.getName(salesLogPo.getSseslprice()));
		
		if ("13".equals(Utility.getName(salesLogPo.getSseslintransit())) || "14".equals(Utility.getName(salesLogPo.getSseslintransit()))){
			if(Utility.getName(salesLogPo.getSseslpaymenttype()).equals("1")){
				buffer.append("          (select top 1 S_SE_SB_PosDatetime from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(salesLogPo.getSseslpaymenttype()).equals("2")){
				buffer.append("          (select top 1 S_SE_SB_PosDatetime from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(salesLogPo.getSseslpaymenttype()).equals("3")){
				buffer.append("          (select top 1 S_SE_SB_ArrearsAppendDate from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(salesLogPo.getSseslpaymenttype()).equals("4")){
				buffer.append("          (select top 1 S_SE_SB_WithdrawDate from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(salesLogPo.getSseslpaymenttype()).equals("5")){
				buffer.append("          (select top 1 S_SE_SB_WithdrawDate from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ?), ");
			}
		}else{
			if(Utility.getName(salesLogPo.getSseslpaymenttype()).equals("1")){
				buffer.append("          (select top 1 S_SE_SB_PosDatetime from dbo.S_SE_SalesBasic where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(salesLogPo.getSseslpaymenttype()).equals("2")){
				buffer.append("          (select top 1 S_SE_SB_PosDatetime from dbo.S_SE_SalesBasic where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(salesLogPo.getSseslpaymenttype()).equals("3")){
				buffer.append("          (select top 1 S_SE_SB_ArrearsAppendDate from dbo.S_SE_SalesBasic where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(salesLogPo.getSseslpaymenttype()).equals("4")){
				buffer.append("          (select top 1 S_SE_SB_WithdrawDate from dbo.S_SE_SalesBasic where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(salesLogPo.getSseslpaymenttype()).equals("5")){
				buffer.append("          (select top 1 S_SE_SB_WithdrawDate from S_SE_SalesBasic where S_SE_SB_SalesID = ?), ");
			}
		}
		
		params.add(Utility.getName(salesLogPo.getSseslsalesid()));
		
		if ("13".equals(Utility.getName(salesLogPo.getSseslintransit())) || "14".equals(Utility.getName(salesLogPo.getSseslintransit()))){
			if(Utility.getName(salesLogPo.getSseslpaymenttype()).equals("1")){
				buffer.append("          (select top 1 S_SE_SB_FactPosDatetime from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(salesLogPo.getSseslpaymenttype()).equals("2")){
				buffer.append("          (select top 1 S_SE_SB_FactPosDatetime from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(salesLogPo.getSseslpaymenttype()).equals("3")){
				buffer.append("          (select top 1 S_SE_SB_FactArrearsAppendDate from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(salesLogPo.getSseslpaymenttype()).equals("4")){
				buffer.append("          (select top 1 S_SE_SB_FactWithdrawDate from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(salesLogPo.getSseslpaymenttype()).equals("5")){
				buffer.append("          (select top 1 S_SE_SB_FactWithdrawDate from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ?), ");
			}
		}else{
			if(Utility.getName(salesLogPo.getSseslpaymenttype()).equals("1")){
				buffer.append("          (select top 1 S_SE_SB_FactPosDatetime from dbo.S_SE_SalesBasic where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(salesLogPo.getSseslpaymenttype()).equals("2")){
				buffer.append("          (select top 1 S_SE_SB_FactPosDatetime from dbo.S_SE_SalesBasic where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(salesLogPo.getSseslpaymenttype()).equals("3")){
				buffer.append("          (select top 1 S_SE_SB_FactArrearsAppendDate from dbo.S_SE_SalesBasic where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(salesLogPo.getSseslpaymenttype()).equals("4")){
				buffer.append("          (select top 1 S_SE_SB_FactWithdrawDate from dbo.S_SE_SalesBasic where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(salesLogPo.getSseslpaymenttype()).equals("5")){
				buffer.append("          (select top 1 S_SE_SB_FactWithdrawDate from dbo.S_SE_SalesBasic where S_SE_SB_SalesID = ?), ");
			}
		}
		
		params.add(Utility.getName(salesLogPo.getSseslsalesid()));
		
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?,  ");
		buffer.append("              ?,  ");
		buffer.append("              ?  ");
		
		
		params.add(Utility.getName(salesLogPo.getSseslperson()));
		params.add(Utility.getName(salesLogPo.getSseslorderby()));
		params.add(Utility.getName(salesLogPo.getSseslsourceid()));
		params.add(Utility.getName(salesLogPo.getSseslshopcode()));
		params.add(Utility.getName(salesLogPo.getSsesltype()));
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());	
	}
	
	/**
	 * 删除日志
	 * @param salesLogPo
	 */
	public void deleteSalesLog(SalesLogPo salesLogPo) {
		List<String> params = new ArrayList<String>();
		StringBuffer  buffer = new StringBuffer();
		
		buffer.append("delete from dbo.S_SE_SalesLog ");
		buffer.append("where S_SE_SL_SalesID = ? ");
		params.add(Utility.getName(salesLogPo.getSseslsalesid()));
		if(!"".equals(salesLogPo.getSseslpaymenttype())){
			buffer.append("and S_SE_SL_PaymentType = ? ");
			params.add(Utility.getName(salesLogPo.getSseslpaymenttype()));
		}
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());	
	}
	
	/**
	 * 删除付款方式
	 * @param salesLogPo
	 */
	public void deleteSalesCrossLog(SalesLogPo salesLogPo) {
		List<String> params = new ArrayList<String>();
		StringBuffer  buffer = new StringBuffer();
		
		buffer.append("delete from S_SE_SalesCrossLog ");
		buffer.append("where S_SE_SL_SalesID = ? ");
		params.add(Utility.getName(salesLogPo.getSseslsalesid()));
		if(!"".equals(salesLogPo.getSseslpaymenttype())){
			buffer.append("and S_SE_SL_PaymentType = ? ");
			params.add(Utility.getName(salesLogPo.getSseslpaymenttype()));
		}
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());	
	}
	
	/**
	 * 新增当天销售数据
	 * @param salesLogPo
	 */
	public void insertSalesBill(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into S_SE_SalesBasic_Today ");
		buffer.append(" (S_SE_SB_SalesID , S_SE_SB_ShopCode , S_SE_SB_CustomerID , S_SE_SB_OptID , S_SE_SB_OptometryID , ");
		buffer.append(" S_SE_SB_InspectionID, S_SE_SB_TakeGlassData , S_SE_SB_SalesDatetime , S_SE_SB_OrdersType , ");
		buffer.append(" S_SE_SB_BallGlassOD , S_SE_SB_BallGlassOS , S_SE_SB_PostGlassOD , S_SE_SB_PostGlassOS , ");
		buffer.append(" S_SE_SB_AxesOD , S_SE_SB_AxesOS , S_SE_SB_ADDOD , S_SE_SB_ADDOS , S_SE_SB_ArriseGlassOD1 , ");
		buffer.append(" S_SE_SB_ArriseGlassOS1 , S_SE_SB_BasisOD1 , S_SE_SB_BasisOS1 , S_SE_SB_PrismOD , S_SE_SB_PrismOS , ");
		buffer.append(" S_SE_SB_InterHighOD , S_SE_SB_InterHighOS , S_SE_SB_InterDistanceOD , S_SE_SB_InterDistanceOS , ");
		buffer.append(" S_SE_SB_FarVAOD , S_SE_SB_FarVAOS , S_SE_SB_CloseVAOD , S_SE_SB_CloseVAOS , S_SE_SB_RecipeType , ");
		buffer.append(" S_SE_SB_DignosisRe , S_SE_SB_DiameterOD , S_SE_SB_DiameterOS , S_SE_SB_ConRecipeType , ");
		buffer.append(" S_SE_SB_SecCheckDate , S_SE_SB_SubVisitUnit , S_SE_SB_SalesType , S_SE_SB_SalerID , ");
		buffer.append(" S_SE_SB_Lryid , S_SE_SB_PosDatetime , S_SE_SB_PosID , S_SE_SB_PriceSum , S_SE_SB_SalesValue , ");
		buffer.append(" S_SE_SB_EyeCurvatureOD1 , S_SE_SB_EyeCurvatureOD2 , S_SE_SB_EyeCurvatureOS1 , S_SE_SB_EyeCurvatureOS2 , ");
		buffer.append(" S_SE_SB_DiscountRate , S_SE_SB_DiscountNum , S_SE_SB_Psalsvalue , S_SE_SB_ArrearsValue , ");
		buffer.append(" S_SE_SB_Location , S_SE_SB_ArrivedDate , S_SE_SB_ValueFlag , S_SE_SB_CheckoutFlag , ");
		buffer.append(" S_SE_SB_InTransit , S_SE_SB_WithdrawDate , S_SE_SB_WithdrawFlag , S_SE_SB_WithdrawPersonID , ");
		buffer.append(" S_SE_SB_MovementType , S_SE_SB_ArrearsAppendDate , S_SE_SB_ArrearsDate , S_SE_SB_PayCash , ");
		buffer.append(" S_SE_SB_BankCard , S_SE_SB_StoredCard , S_SE_SB_Renums , S_SE_SB_DiscountType , S_SE_SB_DiscountPerson , S_SE_SB_DragsType, ");
		buffer.append(" S_SE_SB_PupilHeightOD , S_SE_SB_PupilHeightOS ,S_SE_SB_FavorableAmount,S_SE_SB_WorryType,S_SE_SB_Integral,S_SE_SB_SetMealID,S_SE_SB_ExecStandard,S_SE_SB_SalesRemark,S_SE_SB_SourceSalesID,S_SE_SB_SwapGoodsFlag,S_SE_SB_IntegralPrice,S_SE_SB_ProcessDepartment,S_SE_SB_FactPosDatetime,S_SE_SB_FactWithdrawDate,S_SE_SB_FactArrearsAppendDate) ");
		buffer.append(" select top 1 ");
		buffer.append(" S_SE_SB_SalesID , S_SE_SB_ShopCode , S_SE_SB_CustomerID , S_SE_SB_OptID , S_SE_SB_OptometryID , ");
		buffer.append(" S_SE_SB_InspectionID, S_SE_SB_TakeGlassData , S_SE_SB_SalesDatetime , S_SE_SB_OrdersType , ");
		buffer.append(" S_SE_SB_BallGlassOD , S_SE_SB_BallGlassOS , S_SE_SB_PostGlassOD , S_SE_SB_PostGlassOS , ");
		buffer.append(" S_SE_SB_AxesOD , S_SE_SB_AxesOS , S_SE_SB_ADDOD , S_SE_SB_ADDOS , S_SE_SB_ArriseGlassOD1 , ");
		buffer.append(" S_SE_SB_ArriseGlassOS1 , S_SE_SB_BasisOD1 , S_SE_SB_BasisOS1 , S_SE_SB_PrismOD , S_SE_SB_PrismOS , ");
		buffer.append(" S_SE_SB_InterHighOD , S_SE_SB_InterHighOS , S_SE_SB_InterDistanceOD , S_SE_SB_InterDistanceOS , ");
		buffer.append(" S_SE_SB_FarVAOD , S_SE_SB_FarVAOS , S_SE_SB_CloseVAOD , S_SE_SB_CloseVAOS , S_SE_SB_RecipeType , ");
		buffer.append(" S_SE_SB_DignosisRe , S_SE_SB_DiameterOD , S_SE_SB_DiameterOS , S_SE_SB_ConRecipeType , ");
		buffer.append(" S_SE_SB_SecCheckDate , S_SE_SB_SubVisitUnit , S_SE_SB_SalesType , S_SE_SB_SalerID , ");
		buffer.append(" S_SE_SB_Lryid , S_SE_SB_PosDatetime , S_SE_SB_PosID , S_SE_SB_PriceSum , S_SE_SB_SalesValue , ");
		buffer.append(" S_SE_SB_EyeCurvatureOD1 , S_SE_SB_EyeCurvatureOD2 , S_SE_SB_EyeCurvatureOS1 , S_SE_SB_EyeCurvatureOS2 , ");
		buffer.append(" S_SE_SB_DiscountRate , S_SE_SB_DiscountNum , S_SE_SB_Psalsvalue , S_SE_SB_ArrearsValue , ");
		buffer.append(" S_SE_SB_Location , S_SE_SB_ArrivedDate , S_SE_SB_ValueFlag , S_SE_SB_CheckoutFlag , ");
		buffer.append(" S_SE_SB_InTransit , S_SE_SB_WithdrawDate , S_SE_SB_WithdrawFlag , S_SE_SB_WithdrawPersonID , ");
		buffer.append(" S_SE_SB_MovementType , S_SE_SB_ArrearsAppendDate , S_SE_SB_ArrearsDate , S_SE_SB_PayCash , ");
		buffer.append(" S_SE_SB_BankCard , S_SE_SB_StoredCard , S_SE_SB_Renums , S_SE_SB_DiscountType , S_SE_SB_DiscountPerson , S_SE_SB_DragsType, ");
		buffer.append(" S_SE_SB_PupilHeightOD , S_SE_SB_PupilHeightOS ,S_SE_SB_FavorableAmount,S_SE_SB_WorryType,S_SE_SB_Integral,S_SE_SB_SetMealID,S_SE_SB_ExecStandard,S_SE_SB_SalesRemark,S_SE_SB_SourceSalesID,S_SE_SB_SwapGoodsFlag,S_SE_SB_IntegralPrice,S_SE_SB_ProcessDepartment,S_SE_SB_FactPosDatetime,S_SE_SB_FactWithdrawDate,S_SE_SB_FactArrearsAppendDate ");
		buffer.append(" from S_SE_SalesBasic where S_SE_SB_SalesID=? ");
		buffer.append(" union all ");
		buffer.append(" select top 1 ");
		buffer.append(" S_SE_SB_SalesID , S_SE_SB_ShopCode , S_SE_SB_CustomerID , S_SE_SB_OptID , S_SE_SB_OptometryID , ");
		buffer.append(" S_SE_SB_InspectionID, S_SE_SB_TakeGlassData , S_SE_SB_SalesDatetime , S_SE_SB_OrdersType , ");
		buffer.append(" S_SE_SB_BallGlassOD , S_SE_SB_BallGlassOS , S_SE_SB_PostGlassOD , S_SE_SB_PostGlassOS , ");
		buffer.append(" S_SE_SB_AxesOD , S_SE_SB_AxesOS , S_SE_SB_ADDOD , S_SE_SB_ADDOS , S_SE_SB_ArriseGlassOD1 , ");
		buffer.append(" S_SE_SB_ArriseGlassOS1 , S_SE_SB_BasisOD1 , S_SE_SB_BasisOS1 , S_SE_SB_PrismOD , S_SE_SB_PrismOS , ");
		buffer.append(" S_SE_SB_InterHighOD , S_SE_SB_InterHighOS , S_SE_SB_InterDistanceOD , S_SE_SB_InterDistanceOS , ");
		buffer.append(" S_SE_SB_FarVAOD , S_SE_SB_FarVAOS , S_SE_SB_CloseVAOD , S_SE_SB_CloseVAOS , S_SE_SB_RecipeType , ");
		buffer.append(" S_SE_SB_DignosisRe , S_SE_SB_DiameterOD , S_SE_SB_DiameterOS , S_SE_SB_ConRecipeType , ");
		buffer.append(" S_SE_SB_SecCheckDate , S_SE_SB_SubVisitUnit , S_SE_SB_SalesType , S_SE_SB_SalerID , ");
		buffer.append(" S_SE_SB_Lryid , S_SE_SB_PosDatetime , S_SE_SB_PosID , S_SE_SB_PriceSum , S_SE_SB_SalesValue , ");
		buffer.append(" S_SE_SB_EyeCurvatureOD1 , S_SE_SB_EyeCurvatureOD2 , S_SE_SB_EyeCurvatureOS1 , S_SE_SB_EyeCurvatureOS2 , ");
		buffer.append(" S_SE_SB_DiscountRate , S_SE_SB_DiscountNum , S_SE_SB_Psalsvalue , S_SE_SB_ArrearsValue , ");
		buffer.append(" S_SE_SB_Location , S_SE_SB_ArrivedDate , S_SE_SB_ValueFlag , S_SE_SB_CheckoutFlag , ");
		buffer.append(" S_SE_SB_InTransit , S_SE_SB_WithdrawDate , S_SE_SB_WithdrawFlag , S_SE_SB_WithdrawPersonID , ");
		buffer.append(" S_SE_SB_MovementType , S_SE_SB_ArrearsAppendDate , S_SE_SB_ArrearsDate , S_SE_SB_PayCash , ");
		buffer.append(" S_SE_SB_BankCard , S_SE_SB_StoredCard , S_SE_SB_Renums , S_SE_SB_DiscountType , S_SE_SB_DiscountPerson , S_SE_SB_DragsType, ");
		buffer.append(" S_SE_SB_PupilHeightOD , S_SE_SB_PupilHeightOS ,S_SE_SB_FavorableAmount,S_SE_SB_WorryType,S_SE_SB_Integral,S_SE_SB_SetMealID,S_SE_SB_ExecStandard,S_SE_SB_SalesRemark,S_SE_SB_SourceSalesID,S_SE_SB_SwapGoodsFlag,S_SE_SB_IntegralPrice,S_SE_SB_ProcessDepartment,S_SE_SB_FactPosDatetime,S_SE_SB_FactWithdrawDate,S_SE_SB_FactArrearsAppendDate ");
		buffer.append(" from S_SE_SalesBasic_Finished where S_SE_SB_SalesID=? ");
				
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 新增当天销售数据明细
	 * @param salesLogPo
	 */
	public void insertSalesBillEntry(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO S_SE_SalesDetail_Today ");
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
		buffer.append(",S_SE_SD_InStockId ");
		buffer.append(",S_SE_SD_Favorable ");
		buffer.append(",S_SE_SD_Integral ");
		buffer.append(",S_SE_SD_OutStorageFlag ");
		buffer.append(",S_SE_SD_InStorageFlag ");
		buffer.append(",S_SE_SD_Guaranteeperiod ");
		buffer.append(",S_SE_SD_Batch ");
		buffer.append(",S_SE_SD_WithdrawFlag ");
		buffer.append(",S_SE_SD_WithdrawDate ");
		buffer.append(",S_SE_SD_WithdrawPersonID ");
		buffer.append(",S_SE_SD_Setmealid ");
		buffer.append(",S_SE_SD_Setmealidno ");
		buffer.append(",S_SE_SD_VipCard  ");
		buffer.append(",S_SE_SD_HardValue ");
		buffer.append(",S_SE_SD_RegistrationNum ");
		buffer.append(" )");
		buffer.append(" select  ");
		buffer.append("S_SE_SD_ID ");
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
		buffer.append(",S_SE_SD_InStockId ");
		buffer.append(",S_SE_SD_Favorable ");
		buffer.append(",S_SE_SD_Integral ");
		buffer.append(",S_SE_SD_OutStorageFlag ");
		buffer.append(",S_SE_SD_InStorageFlag ");
		buffer.append(",S_SE_SD_Guaranteeperiod ");
		buffer.append(",S_SE_SD_Batch ");
		buffer.append(",S_SE_SD_WithdrawFlag ");
		buffer.append(",S_SE_SD_WithdrawDate ");
		buffer.append(",S_SE_SD_WithdrawPersonID ");
		buffer.append(",S_SE_SD_Setmealid ");
		buffer.append(",S_SE_SD_Setmealidno ");
		buffer.append(",S_SE_SD_VipCard ");
		buffer.append(",S_SE_SD_HardValue ");
		buffer.append(",S_SE_SD_RegistrationNum ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("where S_SE_SD_SalesID=? ");
		buffer.append(" union all ");
		buffer.append(" select  ");
		buffer.append("S_SE_SD_ID ");
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
		buffer.append(",S_SE_SD_InStockId ");
		buffer.append(",S_SE_SD_Favorable ");
		buffer.append(",S_SE_SD_Integral ");
		buffer.append(",S_SE_SD_OutStorageFlag ");
		buffer.append(",S_SE_SD_InStorageFlag ");
		buffer.append(",S_SE_SD_Guaranteeperiod ");
		buffer.append(",S_SE_SD_Batch ");
		buffer.append(",S_SE_SD_WithdrawFlag ");
		buffer.append(",S_SE_SD_WithdrawDate ");
		buffer.append(",S_SE_SD_WithdrawPersonID ");
		buffer.append(",S_SE_SD_Setmealid ");
		buffer.append(",S_SE_SD_Setmealidno ");
		buffer.append(",S_SE_SD_VipCard ");
		buffer.append(",S_SE_SD_HardValue ");
		buffer.append(",S_SE_SD_RegistrationNum ");
		buffer.append("from S_SE_SalesDetail_Finished ");
		buffer.append("where S_SE_SD_SalesID=? ");
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public int getIntegralExchangeCount(IntegralExchangePo po) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(distinct F_IL_UUID) from F_IntegralExchangeLog inner join F_IntegralExchangeLogEntry on F_IL_UUID=F_ILE_UUID ");
		sb.append("inner join S_ME_CustomerInfo on S_ME_CI_MemberId = F_IL_MemberId ");
		sb.append("where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getFilcustomername()))) {
			sb.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(po.getFilcustomername());
		}
		if (!"".equals(Utility.getName(po.getFilmemberid()))) {
			sb.append("and F_IL_MemberId like '%' + ? + '%'  ");
			params.add(po.getFilmemberid());
		}
		if(!"".equals(Utility.getName(po.getFilenddatetime()))){
			sb.append("and convert(varchar(10) , F_IL_Datetime , 23) <= ? ");
			params.add(po.getFilenddatetime());
		}		
		if(!"".equals(Utility.getName(po.getFilstartdatetime()))){
			sb.append("and convert(varchar(10) , F_IL_Datetime , 23) >= ? ");
			params.add(po.getFilstartdatetime());
		}
		if(!"".equals(Utility.getName(po.getFilgoodsID()))){
			sb.append("and F_ILE_GoodsID like '%' + ? + '%'  ");
			params.add(po.getFilgoodsID());
		}
		if(!"".equals(Utility.getName(po.getFilgoodsName()))){
			sb.append("and F_ILE_GoodsName like '%' + ? + '%'  ");
			params.add(po.getFilgoodsName());
		}
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			sb.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				sb.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			sb.append(" ) ");
		}

		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

	public List<IntegralExchangePo> getIntegralExchangeList(IntegralExchangePo po, int start,int size) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from ( select ROW_NUMBER() Over(order by fildatetime desc) as rowNum, * from ( ");
		sb.append("select distinct S_ME_CustomerInfo.S_ME_CI_MemberId as filmemberid, ");
		sb.append("F_IL_UUID as filuuid, ");
		sb.append("S_ME_CustomerInfo.S_ME_CI_Name as filcustomername, ");
		sb.append("F_IL_Datetime as fildatetime, ");
		sb.append("SYS_PersonInfo.personName as filpersonname, ");
		sb.append("F_IL_IntegralCount as filintegralnumber ");
		sb.append("from F_IntegralExchangeLog  ");
		sb.append("inner join S_ME_CustomerInfo on S_ME_CI_MemberId = F_IL_MemberId ");
		sb.append("inner join SYS_PersonInfo on F_IL_PersonID=ID inner join F_IntegralExchangeLogEntry on F_IL_UUID=F_ILE_UUID ");
		sb.append("where 1=1  ");
		
		if (!"".equals(Utility.getName(po.getFilcustomername()))) {
			sb.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(po.getFilcustomername());
		}
		if (!"".equals(Utility.getName(po.getFilmemberid()))) {
			sb.append("and F_IL_MemberId like '%' + ? + '%'  ");
			params.add(po.getFilmemberid());
		}
		if(!"".equals(Utility.getName(po.getFilenddatetime()))){
			sb.append("and convert(varchar(10) , F_IL_Datetime , 23) <= ? ");
			params.add(po.getFilenddatetime());
		}		
		if(!"".equals(Utility.getName(po.getFilstartdatetime()))){
			sb.append("and convert(varchar(10) , F_IL_Datetime , 23) >= ? ");
			params.add(po.getFilstartdatetime());
		}
		if(!"".equals(Utility.getName(po.getFilgoodsID()))){
			sb.append("and F_ILE_GoodsID like '%' + ? + '%'  ");
			params.add(po.getFilgoodsID());
		}
		if(!"".equals(Utility.getName(po.getFilgoodsName()))){
			sb.append("and F_ILE_GoodsName like '%' + ? + '%'  ");
			params.add(po.getFilgoodsName());
		}
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			sb.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				sb.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			sb.append(" ) ");
		}
			
		sb.append(" )temp ) temp where rowNum > " + start + " and rowNum <= " + countPage);
		sb.append(" set rowcount 0");
		
		return queryForObjectList(sb.toString(),params.toArray(), IntegralExchangePo.class);
	}
	
	public IntegralExchangePo getIntegralExchangeDetail(IntegralExchangePo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select  ");
		sb.append("S_ME_CustomerInfo.S_ME_CI_MemberId as filmemberid, ");
		sb.append("F_IL_UUID as filuuid, ");
		sb.append("S_ME_CustomerInfo.S_ME_CI_Name as filcustomername, ");
		sb.append("F_IL_Datetime as fildatetime, ");
		sb.append("SYS_PersonInfo.personName as filpersonname, ");
		sb.append("F_IL_IntegralCount as filintegralnumber ");
		sb.append("from F_IntegralExchangeLog  ");
		sb.append("inner join S_ME_CustomerInfo on S_ME_CI_MemberId = F_IL_MemberId ");
		sb.append("inner join SYS_PersonInfo on F_IL_PersonID=ID ");
		sb.append("where 1=1 and F_IL_UUID='"+po.getFiluuid()+"'  ");
			
		return (IntegralExchangePo) queryForObject(sb.toString(), null, IntegralExchangePo.class);
	}
	
	public List<IntegralExchangeEntryPo> getIntegralExchangeDetailEntry(IntegralExchangePo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select  ");
		sb.append("F_ILE_GoodsID as filegoodsid, ");
		sb.append("F_ILE_UUID as fileuuid, ");
		sb.append("F_ILE_GoodsName as filegoodsname, ");
		sb.append("F_ILE_IntegralCount as fileintegralCount, ");
		sb.append("F_ILE_GoodsCode as filegoodscode, ");
		sb.append("F_ILE_GoodsNumber as filegoodsnumber ");
		sb.append("from F_IntegralExchangeLogEntry  ");
		sb.append("where 1=1 and F_ILE_UUID='"+po.getFiluuid()+"'  ");
			
		return queryForObjectList(sb.toString(), null, IntegralExchangeEntryPo.class);
	}
	
	/**
	 * 更新商品出入库标志
	 * @param salesid
	 * @param inOrout
	 * @param flag
	 */
	public void updateStrogeChangeFlag(String salesid,String inOrout,String flag){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if (inOrout.equals("out")){
			buffer.append("update S_SE_SalesDetail set S_SE_SD_OutStorageFlag=?,S_SE_SD_Updatetime = getdate() where S_SE_SD_SalesID=? and isnull(S_SE_SD_ItemID,'')<>'' and substring(S_SE_SD_SalesItemID,3,2)<> 'zz' and S_SE_SD_OutStorageFlag ='0' ");
			buffer.append("update S_SE_SalesDetail_Finished set S_SE_SD_OutStorageFlag=?,S_SE_SD_Updatetime = getdate() where S_SE_SD_SalesID=? and isnull(S_SE_SD_ItemID,'')<>'' and substring(S_SE_SD_SalesItemID,3,2)<> 'zz' and S_SE_SD_OutStorageFlag ='0' ");
		}else{
			buffer.append("update S_SE_SalesDetail set S_SE_SD_InStorageFlag=?  where S_SE_SD_SalesID=? and isnull(S_SE_SD_ItemID,'')<>'' and substring(S_SE_SD_SalesItemID,3,2)<> 'zz' ");
			buffer.append("update S_SE_SalesDetail_Finished set S_SE_SD_InStorageFlag=?  where S_SE_SD_SalesID=? and isnull(S_SE_SD_ItemID,'')<>'' and substring(S_SE_SD_SalesItemID,3,2)<> 'zz' ");
		}		
		
		params.add(flag);
		params.add(salesid);
		params.add(flag);
		params.add(salesid);
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void updateStrogeChangeUnFinishedFlag(String salesid,String inOrout,String flag){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if (inOrout.equals("out")){
			buffer.append("update S_SE_SalesDetail set S_SE_SD_OutStorageFlag=?,S_SE_SD_Updatetime = getdate() where S_SE_SD_SalesID=? and isnull(S_SE_SD_ItemID,'')<>'' and substring(S_SE_SD_SalesItemID,3,2)<> 'zz' and S_SE_SD_OutStorageFlag ='0' ");
		}else{
			buffer.append("update S_SE_SalesDetail set S_SE_SD_InStorageFlag=?  where S_SE_SD_SalesID=? and isnull(S_SE_SD_ItemID,'')<>'' and substring(S_SE_SD_SalesItemID,3,2)<> 'zz' ");
		}		
		
		params.add(flag);
		params.add(salesid);
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void updateStrogeChangeUnFinishedFlagNoZengPin(String salesid,String inOrout,String flag,String jiekuanOrFaliao){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if (inOrout.equals("out")){
			if(!jiekuanOrFaliao.equals("jiekuan")){
				buffer.append("update S_SE_SalesDetail ");
				buffer.append(" set S_SE_SD_OutStorageFlag=?,S_SE_SD_Updatetime = getdate() ");
				buffer.append(" From S_SE_SalesDetail S_SE_SalesDetail ");
				buffer.append(" left join B_Gifts on S_SE_SD_SalesItemID = B_GS_GoodsID ");
				buffer.append(" where S_SE_SD_SalesID=? and isnull(S_SE_SD_ItemID,'')<>'' and substring(S_SE_SD_SalesItemID,3,2)<> 'zz' and S_SE_SD_OutStorageFlag ='0'");
			}else{
				buffer.append("update S_SE_SalesDetail ");
				buffer.append(" set S_SE_SD_OutStorageFlag=?,S_SE_SD_Updatetime = getdate() ");
				buffer.append(" From S_SE_SalesDetail ");
				buffer.append(" where S_SE_SD_SalesID=? and isnull(S_SE_SD_ItemID,'')<>'' and substring(S_SE_SD_SalesItemID,3,2)<> 'zz' and S_SE_SD_OutStorageFlag = '0' and S_SE_SD_LargessFlag = '0' ");
				
				buffer.append("update S_SE_SalesDetail ");
				buffer.append(" set S_SE_SD_OutStorageFlag=?,S_SE_SD_Updatetime = getdate() ");
				buffer.append(" From S_SE_SalesDetail ");
				buffer.append(" inner join B_Gifts on S_SE_SD_SalesItemID = B_GS_GoodsID ");
				buffer.append(" where S_SE_SD_SalesID=? and isnull(S_SE_SD_ItemID,'')<>'' and substring(S_SE_SD_SalesItemID,3,2)<> 'zz' and S_SE_SD_OutStorageFlag ='0' and S_SE_SD_LargessFlag = '1' and isnull(B_GS_Type,'')<> '2' ");
				
				params.add(flag);
				params.add(salesid);
			}
		}else{
			buffer.append("update S_SE_SalesDetail set S_SE_SD_InStorageFlag=?  where S_SE_SD_SalesID=? and isnull(S_SE_SD_ItemID,'')<>'' and substring(S_SE_SD_SalesItemID,3,2)<> 'zz' ");
		}		
		
		params.add(flag);
		params.add(salesid);
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void updateStrogeChangeUnFinishedFlagZengPin(String salesid,String inOrout,String flag){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if (inOrout.equals("out")){
			buffer.append("update S_SE_SalesDetail set S_SE_SD_OutStorageFlag=?,S_SE_SD_Updatetime = getdate() where S_SE_SD_SalesID=? and isnull(S_SE_SD_ItemID,'')<>'' and substring(S_SE_SD_SalesItemID,3,2)<> 'zz' and S_SE_SD_OutStorageFlag ='0' and isnull(S_SE_SD_LargessFlag,'') = '1'");
		}else{
			buffer.append("update S_SE_SalesDetail set S_SE_SD_InStorageFlag=?  where S_SE_SD_SalesID=? and isnull(S_SE_SD_ItemID,'')<>'' and substring(S_SE_SD_SalesItemID,3,2)<> 'zz' ");
		}		
		
		params.add(flag);
		params.add(salesid);
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}	
	/**
	 * 删除在途库存
	 * @param po
	 */
	public void deleteInTransitStroge(InTransitStorageEntryPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from C_SH_InTransitStorageEntry where 1=1  ");
		
		buffer.append("and C_SH_TSE_BillID=? ");
		params.add(Utility.getName(po.getCshtsebillid()));
		
		if(!Utility.getName(po.getCshtseentryid()).equals("")){
			buffer.append("and C_SH_TSE_EntryID=? ");
			params.add(Utility.getName(po.getCshtseentryid()));
		}
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());		
	}
	
	/**
	 * 新增在途库存
	 * @param po
	 */
	public void insertInTransitStroge(InTransitStorageEntryPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into C_SH_InTransitStorageEntry (C_SH_TSE_ID,C_SH_TSE_DepartmentType,C_SH_TSE_ModuleID,C_SH_TSE_EntryID,C_SH_TSE_BillID,C_SH_TSE_GoodsID,C_SH_TSE_GoodsBarCode,C_SH_TSE_GoodsNum,C_SH_TSE_InStockID,C_SH_TSE_OutStockID,C_SH_TSE_InOrOutStock) values (?,?,?,?,?,?,?,?,?,?,?) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getCshtsedepartmenttype()));
		params.add(Utility.getName(po.getCshtsemoduleid()));
		params.add(Utility.getName(po.getCshtseentryid()));
		params.add(Utility.getName(po.getCshtsebillid()));
		params.add(Utility.getName(po.getCshtsegoodsID()));
		params.add(Utility.getName(po.getCshtsegoodsbarcode()));
		params.add(Utility.getName(po.getCshtsegoodsNum()));
		params.add(Utility.getName(po.getCshtseinstockid()));
		params.add(Utility.getName(po.getCshtseoutstockid()));
		params.add(Utility.getName(po.getCshtseinoroutStock()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 查询结款或发料、退款后需要删除在途库存的商品
	 */
	public List<InTransitStorageEntryPo> getNotInTransitStorageGoods(String salesid,String inOrout,String flag){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if (inOrout.equals("out")){
			buffer.append(" select S_SE_SD_ID as cshtseentryid,S_SE_SD_SalesID as cshtsebillid,S_SE_SD_SalesItemID as cshtsegoodsID,(case isnull(S_SE_SD_ItemID,'') when '' then (replace(S_SE_SD_SalesItemID,'.','')+'00000000') else isnull(S_SE_SD_ItemID,'') end) as cshtsegoodsbarcode,S_SE_SD_StockId as cshtseoutstockid,-S_SE_SD_Number as cshtsegoodsNum,'2' as cshtseinoroutStock,'1' as cshtsedepartmenttype ");
			buffer.append("   from S_SE_SalesDetail where S_SE_SD_SalesID=? and S_SE_SD_OutStorageFlag=? and substring(S_SE_SD_SalesItemID,3,2)<>'ZZ' ");	
			buffer.append(" union all ");
			buffer.append(" select S_SE_SD_ID as cshtseentryid,S_SE_SD_SalesID as cshtsebillid,S_SE_SD_SalesItemID as cshtsegoodsID,(case isnull(S_SE_SD_ItemID,'') when '' then (replace(S_SE_SD_SalesItemID,'.','')+'00000000') else isnull(S_SE_SD_ItemID,'') end) as cshtsegoodsbarcode,S_SE_SD_StockId as cshtseoutstockid,-S_SE_SD_Number as cshtsegoodsNum,'2' as cshtseinoroutStock,'1' as cshtsedepartmenttype ");
			buffer.append("   from S_SE_SalesDetail_Finished where S_SE_SD_SalesID=? and S_SE_SD_OutStorageFlag=? and substring(S_SE_SD_SalesItemID,3,2)<>'ZZ' ");
		}else{
			buffer.append(" select S_SE_SD_ID as cshtseentryid,S_SE_SD_SalesID as cshtsebillid,S_SE_SD_SalesItemID as cshtsegoodsID,S_SE_SD_ItemID as cshtsegoodsbarcode,S_SE_SD_InStockId as cshtseinstockid,S_SE_SD_Number as cshtsegoodsNum,'1' as cshtseinoroutStock,'1' as cshtsedepartmenttype ");
			buffer.append("   from S_SE_SalesDetail where S_SE_SD_SalesID=? and S_SE_SD_InStorageFlag=? and substring(S_SE_SD_SalesItemID,3,2)<>'ZZ' ");
			buffer.append(" union all ");
			buffer.append(" select S_SE_SD_ID as cshtseentryid,S_SE_SD_SalesID as cshtsebillid,S_SE_SD_SalesItemID as cshtsegoodsID,S_SE_SD_ItemID as cshtsegoodsbarcode,S_SE_SD_InStockId as cshtseinstockid,S_SE_SD_Number as cshtsegoodsNum,'1' as cshtseinoroutStock,'1' as cshtsedepartmenttype ");
			buffer.append("   from S_SE_SalesDetail_Finished where S_SE_SD_SalesID=? and S_SE_SD_InStorageFlag=? and substring(S_SE_SD_SalesItemID,3,2)<>'ZZ' ");	
		}
		
		params.add(salesid);
		params.add(flag);
		params.add(salesid);
		params.add(flag);
		
		return queryForObjectList(buffer.toString(),params.toArray(), InTransitStorageEntryPo.class);
	}
	
	/**
	 * 结款时判断配镜单是否存在
	 */
	public int getSalesBillCount(String salesID){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select sum(count1) from ( ");
		sb.append("select count(S_SE_SB_SalesID) as count1 from S_SE_SalesBasic where S_SE_SB_SalesID=? ");
		sb.append("	union all ");	
		sb.append("select count(S_SE_SB_SalesID) as count1 from S_SE_SalesBasic_Finished where S_SE_SB_SalesID=? ");
		sb.append(" )t ");
		
		params.add(salesID);
		params.add(salesID);
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 门店减少隐形订制片库存
	 * 
	 * @param strogeChangePo
	 */
	public void insertStealthIscustomerStrogeChange(String[] salseid){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO C_SH_StorageChange(C_SH_SC_UUID,C_SH_SC_GoodsBarCode,C_SH_SC_GoodsId,C_SH_SC_StockId,C_SH_SC_GoodsQuantity,C_SH_SC_CostPrice,C_SH_SC_NotTaxRate,C_SH_SC_WarehousingDate,C_SH_SC_ChangeID) ");
		buffer.append("	select replace(newid(),'-',''),left(S_SE_SD_ItemID,18),S_SE_SD_SalesItemID,(select top 1 B_WH_ID from B_Warehouse where B_WH_deptID in (select top 1 S_SE_SB_ShopCode from S_SE_SalesBasic where S_SE_SB_SalesID=S_SE_SD_SalesID)),-S_SE_SD_Number,S_SE_SD_CostsPrive,S_SE_SD_UnitPrice,getdate(),S_SE_SD_SalesID from S_SE_SalesDetail ");
		buffer.append("	  where S_SE_SD_ID in ( ");	
		
		for (int i = 0; i < salseid.length; i++) {
			buffer.append(" ?");
			params.add(salseid[i]);

			if (i + 1 != salseid.length) {
				buffer.append(" ,");
			} else {
				buffer.append(" ) ");
			}
		}
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 门店减少隐形订制片库存
	 * 
	 * @param strogeChangePo
	 */
	public void insertStealthIscustomerStrogeLog(String[] salseid){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO C_SH_StorageLog(C_SH_SL_UUID,C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity,C_SH_SL_CostPrice,C_SH_SL_NotTaxRate,C_SH_SL_WarehousingDate,C_SH_SL_ChangeID) ");
		buffer.append("	select replace(newid(),'-',''),S_SE_SD_ItemID,S_SE_SD_SalesItemID,(select top 1 B_WH_ID from B_Warehouse where B_WH_deptID in (select top 1 S_SE_SB_ShopCode from S_SE_SalesBasic where S_SE_SB_SalesID=S_SE_SD_SalesID)),-S_SE_SD_Number,S_SE_SD_CostsPrive,S_SE_SD_UnitPrice,getdate(),S_SE_SD_SalesID from S_SE_SalesDetail ");
		buffer.append("	  where S_SE_SD_ID in ( ");
		
		for (int i = 0; i < salseid.length; i++) {
			buffer.append(" ?");
			params.add(salseid[i]);

			if (i + 1 != salseid.length) {
				buffer.append(" ,");
			} else {
				buffer.append(" ) ");
			}
		}
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除配镜单后,删除附加费
	 */
	public void deleteSalesBillAdditionalDetail(String salesID) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM S_SE_AdditionalCDetail ");
		buffer.append("WHERE S_SE_SalesID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(salesID);

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除配镜单后,删除特殊加工要求
	 */
	public void deleteSalesBillProcessDetail(String salesID) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM S_SE_SpecialPDetail ");
		buffer.append("WHERE S_SE_SD_SalesID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(salesID);

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除配镜单后,删除在途信息
	 */
	public void deleteSalesBillInTransitDetail(String salesID) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM S_SE_InTransit ");
		buffer.append("WHERE S_SE_IT_SalesID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(salesID);

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 更新实收金额
	 * @param po
	 */
	public void updateSalesValue(SalesBasicPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update S_SE_SalesBasic set S_SE_SB_Psalsvalue = ?, S_SE_SB_CheckoutFlag = ?, S_SE_SB_ArrearsValue = ? where S_SE_SB_SalesID = ? ");
		
		params.add(Utility.getName(po.getSsesbpsalsvalue()));
		params.add(Utility.getName(po.getSsesbcheckoutflag()));
		params.add(Utility.getName(po.getSsesbarrearsvalue()));
		params.add(Utility.getName(po.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());		
	}
	
	/**
	 * 获取现金金额
	 * @param po
	 */
	public List<SalesLogPo> selectCash(SalesBasicPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("select ");
		buffer.append("case  ");
		buffer.append("		when S_SE_SL_ConsumptionID = '1' then '现金' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '2' then '积分' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '3' then '银行卡' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '4' then '储值卡' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '5' then '找零' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '6' then '其他' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '7' then '代金券' ");
		buffer.append("end as sseslconsumptionname, ");
		buffer.append("S_SE_SL_ConsumptionID as sseslconsumptionid, ");
		buffer.append("sum(cast(cast(S_SE_SL_Price as float) as numeric(18,2))) as sseslprice ");
		buffer.append("from S_SE_SalesLog ");
		buffer.append("where S_SE_SL_ConsumptionID = '1' ");
		buffer.append("  and S_SE_SL_SalesID = ? ");
		buffer.append("group by ");
		buffer.append("		S_SE_SL_ConsumptionID ");
		
		params.add(Utility.getName(po.getSsesbsalesid()));
		
		return queryForObjectList(buffer.toString(), params.toArray(), SalesLogPo.class);
	}
	
	/**
	 * 获取积分
	 * @param po
	 */
	public List<SalesLogPo> selectCredit(SalesBasicPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("select ");
		buffer.append("case  ");
		buffer.append("		when S_SE_SL_ConsumptionID = '1' then '现金' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '2' then '积分' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '3' then '银行卡' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '4' then '储值卡' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '5' then '找零' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '6' then '其他' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '7' then '代金券' ");
		buffer.append("end as sseslconsumptionname, ");
		buffer.append("S_SE_SL_ConsumptionID as sseslconsumptionid, ");
		buffer.append("cast(cast(S_SE_SL_IntegralPrice as float) as numeric(18,2)) as sseslprice ");
		buffer.append("from S_SE_SalesLog ");
		buffer.append("where S_SE_SL_ConsumptionID = '2' ");
		buffer.append("  and S_SE_SL_SalesID = ? ");
		
		params.add(Utility.getName(po.getSsesbsalesid()));
		
		return queryForObjectList(buffer.toString(), params.toArray(), SalesLogPo.class);
	}
	
	/**
	 * 获取银行卡
	 * @param po
	 */
	public List<SalesLogPo> selectBankCard(SalesBasicPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("select ");
		buffer.append("case  ");
		buffer.append("		when S_SE_SL_ConsumptionID = '1' then '现金' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '2' then '积分' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '3' then '银行卡' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '4' then '储值卡' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '5' then '找零' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '6' then '其他' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '7' then '代金券' ");
		buffer.append("end as sseslconsumptionname, ");
		buffer.append("B_B_Name as bbname, ");
		buffer.append("S_SE_SL_ConsumptionID as sseslconsumptionid, ");
		buffer.append("cast(cast(S_SE_SL_Price as float) as numeric(18,2)) as sseslprice ");
		buffer.append("from S_SE_SalesLog ");
		buffer.append("left join B_Bank on S_SE_SL_SourceID = B_B_Number ");
		buffer.append("where S_SE_SL_ConsumptionID = '3' ");
		buffer.append("  and S_SE_SL_SalesID = ? ");
		
		params.add(Utility.getName(po.getSsesbsalesid()));
		
		return queryForObjectList(buffer.toString(), params.toArray(), SalesLogPo.class);
	}
	
	/**
	 * 获取储值卡
	 * @param po
	 */
	public List<SalesLogPo> selectPreCard(SalesBasicPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("select ");
		buffer.append("case  ");
		buffer.append("		when S_SE_SL_ConsumptionID = '1' then '现金' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '2' then '积分' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '3' then '银行卡' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '4' then '储值卡' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '5' then '找零' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '6' then '其他' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '7' then '代金券' ");
		buffer.append("end as sseslconsumptionname, ");
		buffer.append("C_ST_CZK_CardID as sseslsourceid, ");;
		buffer.append("S_SE_SL_ConsumptionID as sseslconsumptionid, ");
		buffer.append("cast(cast(S_SE_SL_Price as float) as numeric(18,2)) as sseslprice ");
		buffer.append("from S_SE_SalesLog ");
		buffer.append("left join C_ST_Chuzhika on S_SE_SL_SourceID = C_ST_CZK_ID ");
		buffer.append("where S_SE_SL_ConsumptionID = '4' ");
		buffer.append("  and S_SE_SL_SalesID = ? ");
		
		params.add(Utility.getName(po.getSsesbsalesid()));
		
		return queryForObjectList(buffer.toString(), params.toArray(), SalesLogPo.class);
	}
	/**
	 * 获取代金券
	 * @param po
	 */
	public List<SalesLogPo> selectDjq(SalesBasicPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("select ");
		buffer.append("case  ");
		buffer.append("		when S_SE_SL_ConsumptionID = '1' then '现金' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '2' then '积分' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '3' then '银行卡' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '4' then '储值卡' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '5' then '找零' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '6' then '其他' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '7' then '代金券' ");
		buffer.append("end as sseslconsumptionname, ");
		buffer.append("S_SE_SL_SourceID as sseslsourceid, ");
		buffer.append("B_B_Name as bbname, ");
		buffer.append("S_SE_SL_ConsumptionID as sseslconsumptionid, ");
		buffer.append("cast(cast(S_SE_SL_Price as float) as numeric(18,2)) as sseslprice ");
		buffer.append("from S_SE_SalesLog ");
		buffer.append("left join B_Bank on S_SE_SL_SourceID = B_B_Number ");
		buffer.append("where S_SE_SL_ConsumptionID = '7' ");
		buffer.append("  and S_SE_SL_SalesID = ? ");
		
		params.add(Utility.getName(po.getSsesbsalesid()));
		
		return queryForObjectList(buffer.toString(), params.toArray(), SalesLogPo.class);
	}
	/**
	 * 获取其他
	 * @param po
	 */
	public List<SalesLogPo> selectQt(SalesBasicPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("select ");
		buffer.append("case  ");
		buffer.append("		when S_SE_SL_ConsumptionID = '1' then '现金' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '2' then '积分' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '3' then '银行卡' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '4' then '储值卡' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '5' then '找零' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '6' then '其他' ");
		buffer.append("		when S_SE_SL_ConsumptionID = '7' then '代金券' ");
		buffer.append("end as sseslconsumptionname, ");
		buffer.append("S_SE_SL_SourceID as sseslsourceid, ");
		buffer.append("B_B_Name as bbname, ");
		buffer.append("S_SE_SL_ConsumptionID as sseslconsumptionid, ");
		buffer.append("cast(cast(S_SE_SL_Price as float) as numeric(18,2)) as sseslprice ");
		buffer.append("from S_SE_SalesLog ");
		buffer.append("left join B_Bank on S_SE_SL_SourceID = B_B_Number ");
		buffer.append("where S_SE_SL_ConsumptionID = '6' ");
		buffer.append("  and S_SE_SL_SalesID = ? ");
		
		params.add(Utility.getName(po.getSsesbsalesid()));
		
		return queryForObjectList(buffer.toString(), params.toArray(), SalesLogPo.class);
	}	
	/**
	 * 判断配镜单是否只通过现金或银联卡结款   1：现金   2.银联卡
	 */
	public int getSalesBillPayMentForm(SalesBasicPo po,String flag){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("SET XACT_ABORT ON; ");
		if (flag.equals("1")){
			sb.append("select count(S_SE_SB_SalesID) from wz.cqjy.dbo.S_SE_SalesBasic where S_SE_SB_SalesID = ? ");
		}else{
			sb.append("select count(S_SE_SB_SalesID) from wz.cqjy.dbo.S_SE_SalesBasic_Today where S_SE_SB_SalesID = ? ");
		}	
		
		params.add(Utility.getName(po.getSsesbsalesid()));

		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 判断配镜单中商品是否开票
	 */
	public int getSalesBillGoodsByInvoice(SalesBasicPo po){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("select count(S_SE_SD_ID)  ");
		sb.append("  from S_SE_SalesDetail left join B_Supplier on substring(S_SE_SD_SalesItemID,3,2)=B_SP_ID  ");
		sb.append("  where S_SE_SD_SalesID = ? and isnull(B_SP_MakeInvoiceFlag,'')<>'1'  ");
				
		params.add(Utility.getName(po.getSsesbsalesid()));

		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 外帐新增会员
	 * @param salesLogPo
	 */
	public void insertFlysheetCustomer(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SET XACT_ABORT ON; ");
		buffer.append("declare @membercount numeric(10) ");
		buffer.append("select @membercount = count(S_ME_CI_CustomerID) from " +Utility.getName(epo.getFeaaccessname()) + "." + Utility.getName(epo.getFeaexternalname()) + ".dbo.S_ME_CustomerInfo where S_ME_CI_CustomerID in (select top 1 S_SE_SB_CustomerID from uview_SalesBasic where S_SE_SB_SalesID = ?) ");
		buffer.append(" ");
		buffer.append("if (@membercount = 0) ");
		buffer.append("begin ");
		buffer.append("	INSERT INTO " +Utility.getName(epo.getFeaaccessname()) + "." + Utility.getName(epo.getFeaexternalname()) + ".dbo.S_ME_CustomerInfo ");
		buffer.append("			   (S_ME_CI_CustomerID ");
		buffer.append("			   ,S_ME_CI_Name ");
		buffer.append("			   ,S_ME_CI_Sex ");
		buffer.append("			   ,S_ME_CI_Birthday ");
		buffer.append("			   ,S_ME_CI_Email ");
		buffer.append("			   ,S_ME_CI_Address ");
		buffer.append("			   ,S_ME_CI_Zone ");
		buffer.append("			   ,S_ME_CI_PostCode ");
		buffer.append("			   ,S_ME_CI_Phone ");
		buffer.append("			   ,S_ME_CI_MemberId ");
		buffer.append("			   ,S_ME_CI_Integral ");
		buffer.append("			   ,S_ME_CI_CardType ");
		buffer.append("			   ,S_ME_CI_ShopCode ");
		buffer.append("			   ,S_ME_CI_RegisterDate ");
		buffer.append("			   ,S_ME_CI_Register ");
		buffer.append("			   ,S_ME_CI_UpdateDate ");
		buffer.append("			   ,S_ME_CI_Updater ");
		buffer.append("			   ,S_ME_CI_CustomerType ");
		buffer.append("			   ,S_ME_CI_work ");
		buffer.append("			   ,S_ME_CI_QqNumber ");
		buffer.append("			   ,S_ME_CI_Interest ");
		buffer.append("			   ,S_ME_CI_MemberOrigin ");
		buffer.append("			   ,S_ME_CI_ConsumptionNumber ");
		buffer.append("			   ,S_ME_CI_ConsumptionPrice ");
		buffer.append("			   ,S_ME_CI_MemberPicPath ");
		buffer.append("			   ,S_ME_CI_Phone2 ");
		buffer.append("			   ,S_ME_CI_Phone3 ");
		buffer.append("			   ,S_ME_CI_Sourcecard ");
		buffer.append("			   ,S_ME_CI_IdentityCard ");
		buffer.append("			   ,S_ME_CI_PersonType) ");
		buffer.append("	SELECT S_ME_CI_CustomerID ");
		buffer.append("		  ,S_ME_CI_Name ");
		buffer.append("		  ,S_ME_CI_Sex ");
		buffer.append("		  ,S_ME_CI_Birthday ");
		buffer.append("		  ,S_ME_CI_Email ");
		buffer.append("		  ,S_ME_CI_Address ");
		buffer.append("		  ,S_ME_CI_Zone ");
		buffer.append("		  ,S_ME_CI_PostCode ");
		buffer.append("		  ,S_ME_CI_Phone ");
		buffer.append("		  ,S_ME_CI_MemberId ");
		buffer.append("		  ,S_ME_CI_Integral ");
		buffer.append("		  ,S_ME_CI_CardType ");
		buffer.append("		  ,S_ME_CI_ShopCode ");
		buffer.append("		  ,S_ME_CI_RegisterDate ");
		buffer.append("		  ,S_ME_CI_Register ");
		buffer.append("		  ,S_ME_CI_UpdateDate ");
		buffer.append("		  ,S_ME_CI_Updater ");
		buffer.append("		  ,S_ME_CI_CustomerType ");
		buffer.append("		  ,S_ME_CI_work ");
		buffer.append("		  ,S_ME_CI_QqNumber ");
		buffer.append("		  ,S_ME_CI_Interest ");
		buffer.append("		  ,S_ME_CI_MemberOrigin ");
		buffer.append("		  ,S_ME_CI_ConsumptionNumber ");
		buffer.append("		  ,S_ME_CI_ConsumptionPrice ");
		buffer.append("		  ,S_ME_CI_MemberPicPath ");
		buffer.append("		  ,S_ME_CI_Phone2 ");
		buffer.append("		  ,S_ME_CI_Phone3 ");
		buffer.append("		  ,S_ME_CI_Sourcecard ");
		buffer.append("		  ,S_ME_CI_IdentityCard ");
		buffer.append("		  ,S_ME_CI_PersonType ");
		buffer.append("	  FROM S_ME_CustomerInfo where S_ME_CI_CustomerID in (select top 1 S_SE_SB_CustomerID from uview_SalesBasic where S_SE_SB_SalesID = ?) ");
		buffer.append("end ");

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	
	/**
	 * 外帐新增配镜单信息
	 * @param salesLogPo
	 */
	public void insertFlysheetSalesBill(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("INSERT INTO S_SE_SalesBasic_FlySheet ");
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
		buffer.append("           ,S_SE_SB_JFAmount ");
		buffer.append("           ,S_SE_SB_FrameDia ");
		buffer.append("           ,S_SE_SB_FrameType ");
		buffer.append("           ,S_SE_SB_FrameShape ");
		buffer.append("           ,S_SE_SB_EyeHighOD ");
		buffer.append("           ,S_SE_SB_EyeHighOS ");
		buffer.append("           ,S_SE_SB_FrameHigh ");
		buffer.append("           ,S_SE_SB_FlatWeight ");
		buffer.append("           ,S_SE_SB_NoseWeight ");
		buffer.append("           ,S_SE_SB_YishiID ");
		buffer.append("           ,S_SE_SB_Djsbm) ");
		buffer.append("  SELECT S_SE_SB_SalesID ");
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
		buffer.append("      ,S_SE_SB_FrameDia ");
		buffer.append("      ,S_SE_SB_FrameType ");
		buffer.append("      ,S_SE_SB_FrameShape ");
		buffer.append("      ,S_SE_SB_EyeHighOD ");
		buffer.append("      ,S_SE_SB_EyeHighOS ");
		buffer.append("      ,S_SE_SB_FrameHigh ");
		buffer.append("      ,S_SE_SB_FlatWeight ");
		buffer.append("      ,S_SE_SB_NoseWeight ");
		buffer.append("      ,S_SE_SB_YishiID ");
		buffer.append("      ,S_SE_SB_Djsbm ");
		buffer.append("  FROM S_SE_SalesBasic where S_SE_SB_SalesID = ? ");
		buffer.append(" union all ");
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
		buffer.append("      ,S_SE_SB_FrameDia ");
		buffer.append("      ,S_SE_SB_FrameType ");
		buffer.append("      ,S_SE_SB_FrameShape ");
		buffer.append("      ,S_SE_SB_EyeHighOD ");
		buffer.append("      ,S_SE_SB_EyeHighOS ");
		buffer.append("      ,S_SE_SB_FrameHigh ");
		buffer.append("      ,S_SE_SB_FlatWeight ");
		buffer.append("      ,S_SE_SB_NoseWeight ");
		buffer.append("      ,S_SE_SB_YishiID ");
		buffer.append("      ,S_SE_SB_Djsbm ");
		buffer.append("  FROM S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ? ");

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	
	/**
	 * 外帐新增销售商品明细
	 * @param salesLogPo
	 */
	public void insertFlysheetSalesBillEntry(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("declare @dpt varchar(50) ");
		buffer.append("select top 1 @dpt = S_SE_SB_ShopCode from ( ");
		buffer.append("select top 1 S_SE_SB_ShopCode from S_SE_SalesBasic where S_SE_SB_SalesID = ? ");
		buffer.append("union ");
		buffer.append("select top 1 S_SE_SB_ShopCode from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ? ");
		buffer.append(" )t ");
		
		buffer.append("INSERT INTO S_SE_SalesDetail_FlySheet ");
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
		buffer.append("           ,S_SE_SD_IsReturnPurchaseCollect ");
		buffer.append("           ,S_SE_SD_HardValue ");
		buffer.append("           ,S_SE_SD_VipCard) ");
		buffer.append("SELECT S_SE_SD_ID ");
		buffer.append("      ,S_SE_SD_SalesID ");
		buffer.append("      ,S_SE_SD_SalesItemID ");
		buffer.append("      ,(case isnull(S_SE_SD_ItemID,'') when '' then (replace(S_SE_SD_SalesItemID,'.','')+'00000000') else S_SE_SD_ItemID end) ");
		buffer.append("      ,dbo.getFlysheetOutStockId(S_SE_SD_SalesItemID,S_SE_SD_LargessFlag,@dpt) ");
		buffer.append("      ,S_SE_SD_SalesItemName ");
		buffer.append("      ,S_SE_SD_SPrice ");
		buffer.append("      ,S_SE_SD_Number ");
		if (!"1".equals(Utility.getName(epo.getFeacastset()))){			
			buffer.append("      ,(case dbo.getGoodsMaxDiscount_Flysheet(S_SE_SD_SalesItemID) when '' then S_SE_SD_UnitPrice else cast((cast((S_SE_SD_SPrice * dbo.getGoodsMaxDiscount_Flysheet(S_SE_SD_SalesItemID)) as numeric(30,2)) / (1 + (B_GI_TaxRate * 0.01))) as numeric(30,6))  end) ");
			buffer.append("      ,(case dbo.getGoodsMaxDiscount_Flysheet(S_SE_SD_SalesItemID) when '' then S_SE_SD_CostsPrive else cast((S_SE_SD_SPrice * dbo.getGoodsMaxDiscount_Flysheet(S_SE_SD_SalesItemID)) as numeric(30,2))  end) ");
		}else{
			buffer.append("      ,S_SE_SD_UnitPrice ");
			buffer.append("      ,S_SE_SD_CostsPrive ");
		}
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
		buffer.append("      ,dbo.getFlysheetInStockId(S_SE_SD_SalesItemID,S_SE_SD_LargessFlag,@dpt) ");
		buffer.append("      ,S_SE_SD_Favorable ");
		buffer.append("      ,S_SE_SD_Integral ");
		buffer.append("      ,'1' ");
		buffer.append("      ,S_SE_SD_InStorageFlag ");
		buffer.append("      ,S_SE_SD_Guaranteeperiod ");
		buffer.append("      ,S_SE_SD_Batch ");
		buffer.append("      ,S_SE_SD_ExchageFlag ");
		buffer.append("      ,isnull(S_SE_SB_WithdrawFlag,'0') ");
		buffer.append("      ,S_SE_SD_WithdrawDate ");
		buffer.append("      ,S_SE_SD_WithdrawPersonID ");
		buffer.append("      ,S_SE_SD_Setmealid ");
		buffer.append("      ,S_SE_SD_Setmealidno ");
		buffer.append("      ,S_SE_SD_IsHaveStock ");
		buffer.append("      ,S_SE_SD_IsPurchaseCollect ");
		buffer.append("      ,S_SE_SD_IsReturnPurchaseCollect ");
		buffer.append("      ,S_SE_SD_HardValue ");
		buffer.append("      ,S_SE_SD_VipCard ");
		buffer.append("  FROM S_SE_SalesDetail inner join S_SE_SalesBasic on S_SE_SD_SalesID = S_SE_SB_SalesID inner join B_GoodsInfo on S_SE_SD_SalesItemID = B_GI_GoodsID where S_SE_SD_SalesID = ? ");
		buffer.append(" union all ");	
		buffer.append("SELECT S_SE_SD_ID ");
		buffer.append("      ,S_SE_SD_SalesID ");
		buffer.append("      ,S_SE_SD_SalesItemID ");
		buffer.append("      ,(case isnull(S_SE_SD_ItemID,'') when '' then (replace(S_SE_SD_SalesItemID,'.','')+'00000000') else S_SE_SD_ItemID end) ");
		buffer.append("      ,dbo.getFlysheetOutStockId(S_SE_SD_SalesItemID,S_SE_SD_LargessFlag,@dpt) ");
		buffer.append("      ,S_SE_SD_SalesItemName ");
		buffer.append("      ,S_SE_SD_SPrice ");
		buffer.append("      ,S_SE_SD_Number ");
		if (!"1".equals(Utility.getName(epo.getFeacastset()))){			
			buffer.append("      ,(case dbo.getGoodsMaxDiscount_Flysheet(S_SE_SD_SalesItemID) when '' then S_SE_SD_UnitPrice else cast((cast((S_SE_SD_SPrice * dbo.getGoodsMaxDiscount_Flysheet(S_SE_SD_SalesItemID)) as numeric(30,2)) / (1 + (B_GI_TaxRate * 0.01))) as numeric(30,6))  end) ");
			buffer.append("      ,(case dbo.getGoodsMaxDiscount_Flysheet(S_SE_SD_SalesItemID) when '' then S_SE_SD_CostsPrive else cast((S_SE_SD_SPrice * dbo.getGoodsMaxDiscount_Flysheet(S_SE_SD_SalesItemID)) as numeric(30,2))  end) ");
		}else{
			buffer.append("      ,S_SE_SD_UnitPrice ");
			buffer.append("      ,S_SE_SD_CostsPrive ");
		}
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
		buffer.append("      ,dbo.getFlysheetInStockId(S_SE_SD_SalesItemID,S_SE_SD_LargessFlag,@dpt) ");
		buffer.append("      ,S_SE_SD_Favorable ");
		buffer.append("      ,S_SE_SD_Integral ");
		buffer.append("      ,'1' ");
		buffer.append("      ,S_SE_SD_InStorageFlag ");
		buffer.append("      ,S_SE_SD_Guaranteeperiod ");
		buffer.append("      ,S_SE_SD_Batch ");
		buffer.append("      ,S_SE_SD_ExchageFlag ");
		buffer.append("      ,isnull(S_SE_SB_WithdrawFlag,'0') ");
		buffer.append("      ,S_SE_SD_WithdrawDate ");
		buffer.append("      ,S_SE_SD_WithdrawPersonID ");
		buffer.append("      ,S_SE_SD_Setmealid ");
		buffer.append("      ,S_SE_SD_Setmealidno ");
		buffer.append("      ,S_SE_SD_IsHaveStock ");
		buffer.append("      ,S_SE_SD_IsPurchaseCollect ");
		buffer.append("      ,S_SE_SD_IsReturnPurchaseCollect ");
		buffer.append("      ,S_SE_SD_HardValue ");
		buffer.append("      ,S_SE_SD_VipCard ");
		buffer.append("  FROM S_SE_SalesDetail_Finished inner join S_SE_SalesBasic_Finished on S_SE_SD_SalesID = S_SE_SB_SalesID inner join B_GoodsInfo on S_SE_SD_SalesItemID = B_GI_GoodsID where S_SE_SD_SalesID = ? ");

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	
	/**
	 * 外帐新增付款记录
	 * @param salesLogPo
	 */
	public void insertFlysheetSalesLog(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("INSERT INTO S_SE_SalesLog_FlySheet ");
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
		buffer.append("  FROM S_SE_SalesLog where S_SE_SL_SalesID = ? and S_SE_SL_PaymentType in ('1','2','3') ");

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	
	/**
	 * 外帐新增在途信息
	 * @param salesLogPo
	 */
	public void insertFlysheetSalesBillInTransit(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("INSERT INTO S_SE_InTransit_FlySheet ");
		buffer.append("           (S_SE_IT_ID ");
		buffer.append("           ,S_SE_IT_SalesID ");
		buffer.append("           ,S_SE_IT_State ");
		buffer.append("           ,S_SE_IT_Date ");
		buffer.append("           ,S_SE_IT_CreatePerson ");
		buffer.append("           ,S_SE_IT_Department ");
		buffer.append("           ,S_SE_IT_YsalesID) ");
		buffer.append(" SELECT S_SE_IT_ID ");
		buffer.append("      ,S_SE_IT_SalesID ");
		buffer.append("      ,S_SE_IT_State ");
		buffer.append("      ,S_SE_IT_Date ");
		buffer.append("      ,S_SE_IT_CreatePerson ");
		buffer.append("      ,S_SE_IT_Department ");
		buffer.append("      ,S_SE_IT_YsalesID ");
		buffer.append("  FROM S_SE_InTransit where S_SE_IT_SalesID = ? ");

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	
	/**
	 * 外帐新增附加费
	 * @param salesLogPo
	 */
	public void insertFlysheetSalesAdditionalCDetail(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("INSERT INTO S_SE_AdditionalCDetail_FlySheet ");
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
		buffer.append("  FROM S_SE_AdditionalCDetail where S_SE_SalesID = ? ");

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	
	/**
	 * 外帐新增加工要求
	 * @param salesLogPo
	 */
	public void insertFlysheetSalesSpecialPDetail(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("INSERT INTO S_SE_SpecialPDetail_FlySheet ");
		buffer.append("           (S_SE_SD_ID ");
		buffer.append("           ,S_SE_SD_SalesID ");
		buffer.append("           ,S_SE_SD_Requirement) ");
		buffer.append("SELECT S_SE_SD_ID ");
		buffer.append("      ,S_SE_SD_SalesID ");
		buffer.append("      ,S_SE_SD_Requirement ");
		buffer.append("  FROM S_SE_SpecialPDetail where S_SE_SD_SalesID = ? ");

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	
	/**
	 * 外帐新增当日配镜单信息
	 * @param salesLogPo
	 */
	public void insertFlysheetCurrentSalesBill(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO S_SE_SalesBasic_Today_FlySheet ");
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
		buffer.append("           ,S_SE_SB_JFAmount ");
		buffer.append("           ,S_SE_SB_FrameDia ");
		buffer.append("           ,S_SE_SB_FrameType ");
		buffer.append("           ,S_SE_SB_FrameShape ");
		buffer.append("           ,S_SE_SB_EyeHighOD ");
		buffer.append("           ,S_SE_SB_EyeHighOS ");
		buffer.append("           ,S_SE_SB_FrameHigh ");
		buffer.append("           ,S_SE_SB_FlatWeight ");
		buffer.append("           ,S_SE_SB_NoseWeight ");
		buffer.append("           ,S_SE_SB_YishiID ");
		buffer.append("           ,S_SE_SB_Djsbm) ");
		buffer.append("  SELECT S_SE_SB_SalesID ");
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
		buffer.append("      ,S_SE_SB_FrameDia ");
		buffer.append("      ,S_SE_SB_FrameType ");
		buffer.append("      ,S_SE_SB_FrameShape ");
		buffer.append("      ,S_SE_SB_EyeHighOD ");
		buffer.append("      ,S_SE_SB_EyeHighOS ");
		buffer.append("      ,S_SE_SB_FrameHigh ");
		buffer.append("      ,S_SE_SB_FlatWeight ");
		buffer.append("      ,S_SE_SB_NoseWeight ");
		buffer.append("      ,S_SE_SB_YishiID ");
		buffer.append("      ,S_SE_SB_Djsbm ");
		buffer.append("  FROM S_SE_SalesBasic where S_SE_SB_SalesID = ? ");
		buffer.append(" union all ");
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
		buffer.append("      ,S_SE_SB_FrameDia ");
		buffer.append("      ,S_SE_SB_FrameType ");
		buffer.append("      ,S_SE_SB_FrameShape ");
		buffer.append("      ,S_SE_SB_EyeHighOD ");
		buffer.append("      ,S_SE_SB_EyeHighOS ");
		buffer.append("      ,S_SE_SB_FrameHigh ");
		buffer.append("      ,S_SE_SB_FlatWeight ");
		buffer.append("      ,S_SE_SB_NoseWeight ");
		buffer.append("      ,S_SE_SB_YishiID ");
		buffer.append("      ,S_SE_SB_Djsbm ");
		buffer.append("  FROM S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ? ");

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	
	/**
	 * 外帐新增当日销售商品明细
	 * @param salesLogPo
	 */
	public void insertFlysheetCurrentSalesBillEntry(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("declare @dpt varchar(50) ");
		buffer.append("select top 1 @dpt = S_SE_SB_ShopCode from ( ");
		buffer.append("select top 1 S_SE_SB_ShopCode from S_SE_SalesBasic where S_SE_SB_SalesID = ? ");
		buffer.append("union ");
		buffer.append("select top 1 S_SE_SB_ShopCode from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ? ");
		buffer.append(" )t ");
		
		buffer.append("INSERT INTO S_SE_SalesDetail_Today_FlySheet ");
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
		buffer.append("           ,S_SE_SD_IsReturnPurchaseCollect ");
		buffer.append("           ,S_SE_SD_HardValue ");
		buffer.append("           ,S_SE_SD_VipCard) ");
		buffer.append("SELECT S_SE_SD_ID ");
		buffer.append("      ,S_SE_SD_SalesID ");
		buffer.append("      ,S_SE_SD_SalesItemID ");
		buffer.append("      ,(case isnull(S_SE_SD_ItemID,'') when '' then (replace(S_SE_SD_SalesItemID,'.','')+'00000000') else S_SE_SD_ItemID end) ");
		buffer.append("      ,dbo.getFlysheetOutStockId(S_SE_SD_SalesItemID,S_SE_SD_LargessFlag,@dpt) ");
		buffer.append("      ,S_SE_SD_SalesItemName ");
		buffer.append("      ,S_SE_SD_SPrice ");
		buffer.append("      ,S_SE_SD_Number ");
		if (!"1".equals(Utility.getName(epo.getFeacastset()))){			
			buffer.append("      ,(case dbo.getGoodsMaxDiscount_Flysheet(S_SE_SD_SalesItemID) when '' then S_SE_SD_UnitPrice else cast((cast((S_SE_SD_SPrice * dbo.getGoodsMaxDiscount_Flysheet(S_SE_SD_SalesItemID)) as numeric(30,2)) / (1 + (B_GI_TaxRate * 0.01))) as numeric(30,6))  end) ");
			buffer.append("      ,(case dbo.getGoodsMaxDiscount_Flysheet(S_SE_SD_SalesItemID) when '' then S_SE_SD_CostsPrive else cast((S_SE_SD_SPrice * dbo.getGoodsMaxDiscount_Flysheet(S_SE_SD_SalesItemID)) as numeric(30,2))  end) ");
		}else{
			buffer.append("      ,S_SE_SD_UnitPrice ");
			buffer.append("      ,S_SE_SD_CostsPrive ");
		}
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
		buffer.append("      ,dbo.getFlysheetInStockId(S_SE_SD_SalesItemID,S_SE_SD_LargessFlag,@dpt) ");
		buffer.append("      ,S_SE_SD_Favorable ");
		buffer.append("      ,S_SE_SD_Integral ");
		buffer.append("      ,'1' ");
		buffer.append("      ,S_SE_SD_InStorageFlag ");
		buffer.append("      ,S_SE_SD_Guaranteeperiod ");
		buffer.append("      ,S_SE_SD_Batch ");
		buffer.append("      ,S_SE_SD_ExchageFlag ");
		buffer.append("      ,isnull(S_SE_SB_WithdrawFlag,'0') ");
		buffer.append("      ,S_SE_SD_WithdrawDate ");
		buffer.append("      ,S_SE_SD_WithdrawPersonID ");
		buffer.append("      ,S_SE_SD_Setmealid ");
		buffer.append("      ,S_SE_SD_Setmealidno ");
		buffer.append("      ,S_SE_SD_IsHaveStock ");
		buffer.append("      ,S_SE_SD_IsPurchaseCollect ");
		buffer.append("      ,S_SE_SD_IsReturnPurchaseCollect ");
		buffer.append("      ,S_SE_SD_HardValue ");
		buffer.append("      ,S_SE_SD_VipCard ");
		buffer.append("  FROM S_SE_SalesDetail inner join S_SE_SalesBasic on S_SE_SD_SalesID = S_SE_SB_SalesID inner join B_GoodsInfo on S_SE_SD_SalesItemID = B_GI_GoodsID where S_SE_SD_SalesID = ? ");
		buffer.append(" union all ");	
		buffer.append("SELECT S_SE_SD_ID ");
		buffer.append("      ,S_SE_SD_SalesID ");
		buffer.append("      ,S_SE_SD_SalesItemID ");
		buffer.append("      ,(case isnull(S_SE_SD_ItemID,'') when '' then (replace(S_SE_SD_SalesItemID,'.','')+'00000000') else S_SE_SD_ItemID end) ");
		buffer.append("      ,dbo.getFlysheetOutStockId(S_SE_SD_SalesItemID,S_SE_SD_LargessFlag,@dpt) ");
		buffer.append("      ,S_SE_SD_SalesItemName ");
		buffer.append("      ,S_SE_SD_SPrice ");
		buffer.append("      ,S_SE_SD_Number ");
		if (!"1".equals(Utility.getName(epo.getFeacastset()))){			
			buffer.append("      ,(case dbo.getGoodsMaxDiscount_Flysheet(S_SE_SD_SalesItemID) when '' then S_SE_SD_UnitPrice else cast((cast((S_SE_SD_SPrice * dbo.getGoodsMaxDiscount_Flysheet(S_SE_SD_SalesItemID)) as numeric(30,2)) / (1 + (B_GI_TaxRate * 0.01))) as numeric(30,6))  end) ");
			buffer.append("      ,(case dbo.getGoodsMaxDiscount_Flysheet(S_SE_SD_SalesItemID) when '' then S_SE_SD_CostsPrive else cast((S_SE_SD_SPrice * dbo.getGoodsMaxDiscount_Flysheet(S_SE_SD_SalesItemID)) as numeric(30,2))  end) ");
		}else{
			buffer.append("      ,S_SE_SD_UnitPrice ");
			buffer.append("      ,S_SE_SD_CostsPrive ");
		}
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
		buffer.append("      ,dbo.getFlysheetInStockId(S_SE_SD_SalesItemID,S_SE_SD_LargessFlag,@dpt) ");
		buffer.append("      ,S_SE_SD_Favorable ");
		buffer.append("      ,S_SE_SD_Integral ");
		buffer.append("      ,'1' ");
		buffer.append("      ,S_SE_SD_InStorageFlag ");
		buffer.append("      ,S_SE_SD_Guaranteeperiod ");
		buffer.append("      ,S_SE_SD_Batch ");
		buffer.append("      ,S_SE_SD_ExchageFlag ");
		buffer.append("      ,isnull(S_SE_SB_WithdrawFlag,'0') ");
		buffer.append("      ,S_SE_SD_WithdrawDate ");
		buffer.append("      ,S_SE_SD_WithdrawPersonID ");
		buffer.append("      ,S_SE_SD_Setmealid ");
		buffer.append("      ,S_SE_SD_Setmealidno ");
		buffer.append("      ,S_SE_SD_IsHaveStock ");
		buffer.append("      ,S_SE_SD_IsPurchaseCollect ");
		buffer.append("      ,S_SE_SD_IsReturnPurchaseCollect ");
		buffer.append("      ,S_SE_SD_HardValue ");
		buffer.append("      ,S_SE_SD_VipCard ");
		buffer.append("  FROM S_SE_SalesDetail_Finished inner join S_SE_SalesBasic_Finished on S_SE_SD_SalesID = S_SE_SB_SalesID inner join B_GoodsInfo on S_SE_SD_SalesItemID = B_GI_GoodsID where S_SE_SD_SalesID = ? ");

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	/**
	 * 外帐新增当月库存
	 * @param salesLogPo
	 */
	public void insertFlysheetCurrentStorageChange(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("INSERT INTO C_SH_StorageChange_FlySheet ");
		buffer.append("           (C_SH_SC_UUID ");
		buffer.append("           ,C_SH_SC_GoodsBarCode ");
		buffer.append("           ,C_SH_SC_GoodsId ");
		buffer.append("           ,C_SH_SC_StockId ");
		buffer.append("           ,C_SH_SC_GoodsQuantity ");
		buffer.append("           ,C_SH_SC_CostPrice ");
		buffer.append("           ,C_SH_SC_NotTaxRate ");
		buffer.append("           ,C_SH_SC_WarehousingDate ");
		buffer.append("           ,C_SH_SC_ChangeID) ");
		buffer.append("SELECT S_SE_SD_ID ");
		buffer.append("      ,replace(S_SE_SD_SalesItemID,'.','') ");
		buffer.append("      ,S_SE_SD_SalesItemID ");
		buffer.append("      ,S_SE_SD_StockId ");
		buffer.append("      ,-S_SE_SD_Number ");
		buffer.append("      ,S_SE_SD_CostsPrive ");
		buffer.append("      ,S_SE_SD_UnitPrice ");
		buffer.append("      ,S_SE_SB_PosDatetime ");
		buffer.append("      ,S_SE_SD_SalesID ");
		buffer.append("  FROM S_SE_SalesDetail_FlySheet inner join S_SE_SalesBasic_FlySheet on S_SE_SB_SalesID=S_SE_SD_SalesID where S_SE_SD_SalesID = ? and substring(S_SE_SD_SalesItemID,3,2)<>'ZZ' ");
	
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	/**
	 * 外帐新增库存流水
	 * @param salesLogPo
	 */
	public void insertFlysheetStorageLog(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("INSERT INTO C_SH_StorageLog_FlySheet ");
		buffer.append("           (C_SH_SL_UUID ");
		buffer.append("           ,C_SH_SL_GoodsBarCode ");
		buffer.append("           ,C_SH_SL_GoodsId ");
		buffer.append("           ,C_SH_SL_StockId ");
		buffer.append("           ,C_SH_SL_GoodsQuantity ");
		buffer.append("           ,C_SH_SL_CostPrice ");
		buffer.append("           ,C_SH_SL_NotTaxRate ");
		buffer.append("           ,C_SH_SL_WarehousingDate ");
		buffer.append("           ,C_SH_SL_ChangeID ");
		buffer.append("           ,C_SH_SL_GuaranteePeriod ");
		buffer.append("           ,C_SH_SL_Batch) ");
		buffer.append("SELECT S_SE_SD_ID ");
		buffer.append("      ,S_SE_SD_ItemID ");
		buffer.append("      ,S_SE_SD_SalesItemID ");
		buffer.append("      ,S_SE_SD_StockId ");
		buffer.append("      ,-S_SE_SD_Number ");
		buffer.append("      ,S_SE_SD_CostsPrive ");
		buffer.append("      ,S_SE_SD_UnitPrice ");
		buffer.append("      ,S_SE_SB_PosDatetime ");
		buffer.append("      ,S_SE_SD_SalesID ");
		buffer.append("      ,S_SE_SD_Guaranteeperiod ");
		buffer.append("      ,S_SE_SD_Batch ");
		buffer.append("  FROM S_SE_SalesDetail_FlySheet inner join S_SE_SalesBasic_FlySheet on S_SE_SB_SalesID=S_SE_SD_SalesID where S_SE_SD_SalesID = ? and substring(S_SE_SD_SalesItemID,3,2)<>'ZZ' ");

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	/**
	 * 外帐新增当月库存(退)
	 * @param salesLogPo
	 */
	public void insertFlysheetCurrentStorageChange_Withdraw(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("INSERT INTO C_SH_StorageChange_FlySheet ");
		buffer.append("           (C_SH_SC_UUID ");
		buffer.append("           ,C_SH_SC_GoodsBarCode ");
		buffer.append("           ,C_SH_SC_GoodsId ");
		buffer.append("           ,C_SH_SC_StockId ");
		buffer.append("           ,C_SH_SC_GoodsQuantity ");
		buffer.append("           ,C_SH_SC_CostPrice ");
		buffer.append("           ,C_SH_SC_NotTaxRate ");
		buffer.append("           ,C_SH_SC_WarehousingDate ");
		buffer.append("           ,C_SH_SC_ChangeID) ");
		buffer.append("SELECT (S_SE_SD_ID + '0') ");
		buffer.append("      ,replace(S_SE_SD_SalesItemID,'.','') ");
		buffer.append("      ,S_SE_SD_SalesItemID ");
		buffer.append("      ,S_SE_SD_InStockId ");
		buffer.append("      ,S_SE_SD_Number ");
		buffer.append("      ,S_SE_SD_CostsPrive ");
		buffer.append("      ,S_SE_SD_UnitPrice ");
		buffer.append("      ,S_SE_SB_WithdrawDate ");
		buffer.append("      ,S_SE_SD_SalesID ");
		buffer.append("  FROM S_SE_SalesDetail_FlySheet inner join S_SE_SalesBasic_FlySheet on S_SE_SB_SalesID=S_SE_SD_SalesID where S_SE_SD_SalesID = ? and substring(S_SE_SD_SalesItemID,3,2)<>'ZZ' ");

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	/**
	 * 外帐新增库存流水(退)
	 * @param salesLogPo
	 */
	public void insertFlysheetStorageLog_Withdraw(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("INSERT INTO C_SH_StorageLog_FlySheet ");
		buffer.append("           (C_SH_SL_UUID ");
		buffer.append("           ,C_SH_SL_GoodsBarCode ");
		buffer.append("           ,C_SH_SL_GoodsId ");
		buffer.append("           ,C_SH_SL_StockId ");
		buffer.append("           ,C_SH_SL_GoodsQuantity ");
		buffer.append("           ,C_SH_SL_CostPrice ");
		buffer.append("           ,C_SH_SL_NotTaxRate ");
		buffer.append("           ,C_SH_SL_WarehousingDate ");
		buffer.append("           ,C_SH_SL_ChangeID ");
		buffer.append("           ,C_SH_SL_GuaranteePeriod ");
		buffer.append("           ,C_SH_SL_Batch,C_SH_SL_Flag) ");
		buffer.append("SELECT (S_SE_SD_ID + '0') ");
		buffer.append("      ,S_SE_SD_ItemID ");
		buffer.append("      ,S_SE_SD_SalesItemID ");
		buffer.append("      ,S_SE_SD_InStockId ");
		buffer.append("      ,S_SE_SD_Number ");
		buffer.append("      ,S_SE_SD_CostsPrive ");
		buffer.append("      ,S_SE_SD_UnitPrice ");
		buffer.append("      ,S_SE_SB_WithdrawDate ");
		buffer.append("      ,S_SE_SD_SalesID ");
		buffer.append("      ,S_SE_SD_Guaranteeperiod ");
		buffer.append("      ,S_SE_SD_Batch,'1' ");
		buffer.append("  FROM S_SE_SalesDetail_FlySheet inner join S_SE_SalesBasic_FlySheet on S_SE_SB_SalesID=S_SE_SD_SalesID where S_SE_SD_SalesID = ? and substring(S_SE_SD_SalesItemID,3,2)<>'ZZ' ");

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	/**
	 * 外帐新增配镜单信息(退)
	 * @param salesLogPo
	 */
	public void insertFlysheetSalesBill_Withdraw(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("SET XACT_ABORT ON; ");
		buffer.append("update wz.cqjy.dbo.S_SE_SalesBasic ");
		buffer.append("set S_SE_SB_InTransit= ? ");
		buffer.append(", S_SE_SB_WithdrawDate = GETDATE() ");
		buffer.append(", S_SE_SB_WithdrawFlag = '1' ");
		buffer.append(", S_SE_SB_WithdrawPersonID = ? ");
		buffer.append(", S_SE_SB_CheckoutFlag = '0' ");
		buffer.append("where S_SE_SB_SalesID= ? ");

		params.add(salesBasicPo.getSsesbintransit());
		params.add(salesBasicPo.getSsesbwithdrawpersonid());
		params.add(salesBasicPo.getSsesbsalesid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 外帐新增销售商品明细(退)
	 * @param salesLogPo
	 */
	public void insertFlysheetSalesBillEntry_Withdraw(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("SET XACT_ABORT ON; ");
		buffer.append("update wz.cqjy.dbo.S_SE_SalesDetail set S_SE_SD_InStorageFlag='1',S_SE_SD_Updatetime = getdate()  where S_SE_SD_SalesID=? and substring(S_SE_SD_SalesItemID,3,2)<> 'zz' ");
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 外帐新增付款记录(退)
	 * @param salesLogPo
	 */
	public void insertFlysheetSalesLog_Withdraw(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO S_SE_SalesLog_FlySheet ");
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
		buffer.append("SELECT substring(cast(newid() as varchar(50)),1,32) as S_SE_SL_UUID ");
		buffer.append("      ,S_SE_SL_SalesID ");
		buffer.append("      ,'4' as S_SE_SL_PaymentType   ");
		buffer.append("      ,S_SE_SL_ConsumptionID ");
		buffer.append("      ,S_SE_SL_Price ");
		buffer.append("      ,S_SE_SL_DateTime ");
		buffer.append("      ,S_SE_SL_Person ");
		buffer.append("      ,S_SE_SL_Orderby ");
		buffer.append("      ,S_SE_SL_SourceID ");
		buffer.append("      ,S_SE_SL_IntegralPrice ");
		buffer.append("      ,S_SE_SL_ShopCode ");
		buffer.append("      ,S_SE_SL_Type ");
		buffer.append("  FROM S_SE_SalesLog inner join S_SE_SalesBasic on S_SE_SL_SalesID = S_SE_SB_SalesID where S_SE_SL_SalesID = ? and S_SE_SL_PaymentType in ('1','2','3') ");
		buffer.append("  union all ");		
		buffer.append("SELECT substring(cast(newid() as varchar(50)),1,32) as S_SE_SL_UUID ");
		buffer.append("      ,S_SE_SL_SalesID ");
		buffer.append("      ,'4' as S_SE_SL_PaymentType   ");
		buffer.append("      ,S_SE_SL_ConsumptionID ");
		buffer.append("      ,S_SE_SL_Price ");
		buffer.append("      ,S_SE_SL_DateTime ");
		buffer.append("      ,S_SE_SL_Person ");
		buffer.append("      ,S_SE_SL_Orderby ");
		buffer.append("      ,S_SE_SL_SourceID ");
		buffer.append("      ,S_SE_SL_IntegralPrice ");
		buffer.append("      ,S_SE_SL_ShopCode ");
		buffer.append("      ,S_SE_SL_Type ");
		buffer.append("  FROM S_SE_SalesLog inner join S_SE_SalesBasic_Finished on S_SE_SL_SalesID = S_SE_SB_SalesID where S_SE_SL_SalesID = ? and S_SE_SL_PaymentType in ('1','2','3') ");

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	/**
	 * 外帐新增在途信息(退)
	 * @param salesLogPo
	 */
	public void insertFlysheetSalesBillInTransit_Withdraw(InTransitPo inTransitPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("SET XACT_ABORT ON; ");
		buffer.append("insert into wz.cqjy.dbo.S_SE_InTransit( ");
		buffer.append("S_SE_IT_ID, S_SE_IT_SalesID, S_SE_IT_State ");
		buffer.append(", S_SE_IT_Date, S_SE_IT_CreatePerson ");
		buffer.append(", S_SE_IT_Department ) ");
		buffer.append("values (? , ? , ? , getdate() , ? , ?) ");

		params.add(this.uuid.generate());
		params.add(inTransitPo.getSseitsalesid());
		params.add(inTransitPo.getSseitstate());
		params.add(inTransitPo.getSseitcreateperson());
		params.add(inTransitPo.getSseitdepartment());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 外帐新增当日配镜单信息(退)
	 * @param salesLogPo
	 */
	public void insertFlysheetCurrentSalesBill_Withdraw(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("SET XACT_ABORT ON; ");
		buffer.append("update wz.cqjy.dbo.S_SE_SalesBasic_Today ");
		buffer.append("set S_SE_SB_InTransit= ? ");
		buffer.append(", S_SE_SB_WithdrawDate = GETDATE() ");
		buffer.append(", S_SE_SB_WithdrawFlag = '1' ");
		buffer.append(", S_SE_SB_WithdrawPersonID = ? ");
		buffer.append(", S_SE_SB_CheckoutFlag = '0' ");
		buffer.append("where S_SE_SB_SalesID= ? ");

		params.add(salesBasicPo.getSsesbintransit());
		params.add(salesBasicPo.getSsesbwithdrawpersonid());
		params.add(salesBasicPo.getSsesbsalesid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 外帐新增当日销售商品明细(退)
	 * @param salesLogPo
	 */
	public void insertFlysheetCurrentSalesBillEntry_Withdraw(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("SET XACT_ABORT ON; ");
		buffer.append("update wz.cqjy.dbo.S_SE_SalesDetail_Today set S_SE_SD_InStorageFlag='1',S_SE_SD_Updatetime = getdate()  where S_SE_SD_SalesID=? and substring(S_SE_SD_SalesItemID,3,2)<> 'zz' ");
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 外帐新增当日配镜单信息
	 * @param salesLogPo
	 */
	public void insertFlysheetCurrentSalesBillWithdraw(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SET XACT_ABORT ON; ");
		buffer.append("INSERT INTO wz.cqjy.dbo.S_SE_SalesBasic_Today ");
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
		buffer.append("      ,'1' ");
		buffer.append("      ,'0' ");
		buffer.append("      ,'14' ");
		buffer.append("      ,getdate() ");
		buffer.append("      ,'1' ");
		buffer.append("      ,? ");
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
		buffer.append("  FROM S_SE_SalesBasic where S_SE_SB_SalesID = ? ");

		params.add(Utility.getName(salesBasicPo.getSsesbwithdrawpersonid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	
	/**
	 * 外帐新增当日销售商品明细
	 * @param salesLogPo
	 */
	public void insertFlysheetCurrentSalesBillEntryWithdraw(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SET XACT_ABORT ON; ");
		buffer.append("declare @dpt varchar(50) ");
		buffer.append("select @dpt = S_SE_SB_ShopCode from S_SE_SalesBasic where S_SE_SB_SalesID = ? ");
		buffer.append(" ");
		
		buffer.append("INSERT INTO wz.cqjy.dbo.S_SE_SalesDetail_Today ");
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
		buffer.append("SELECT S_SE_SD_ID ");
		buffer.append("      ,S_SE_SD_SalesID ");
		buffer.append("      ,S_SE_SD_SalesItemID ");
		buffer.append("      ,(case isnull(S_SE_SD_ItemID,'') when '' then (replace(S_SE_SD_SalesItemID,'.','')+'00000000') else S_SE_SD_ItemID end) ");
		buffer.append("      ,dbo.getFlysheetOutStockId(S_SE_SD_SalesItemID,S_SE_SD_LargessFlag,@dpt) ");
		buffer.append("      ,S_SE_SD_SalesItemName ");
		buffer.append("      ,S_SE_SD_SPrice ");
		buffer.append("      ,S_SE_SD_Number ");
		buffer.append("      ,cast((S_SE_SD_SPrice * dbo.getGoodsMaxDiscount_Flysheet(S_SE_SD_SalesItemID)) as numeric(30,6)) ");
		buffer.append("      ,cast((cast((S_SE_SD_SPrice * dbo.getGoodsMaxDiscount_Flysheet(S_SE_SD_SalesItemID)) as numeric(30,6)) * (1 + (B_GI_TaxRate * 0.01))) as numeric(30,2)) ");
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
		buffer.append("      ,dbo.getFlysheetInStockId(S_SE_SD_SalesItemID,S_SE_SD_LargessFlag,@dpt) ");
		buffer.append("      ,S_SE_SD_Favorable ");
		buffer.append("      ,S_SE_SD_Integral ");
		buffer.append("      ,'1' ");
		buffer.append("      ,'1' ");
		buffer.append("      ,S_SE_SD_ExchageFlag ");
		buffer.append("      ,S_SE_SD_WithdrawFlag ");
		buffer.append("      ,S_SE_SD_WithdrawDate ");
		buffer.append("      ,S_SE_SD_WithdrawPersonID ");
		buffer.append("      ,S_SE_SD_Guaranteeperiod ");
		buffer.append("      ,S_SE_SD_Batch ");
		buffer.append("      ,S_SE_SD_Setmealid ");
		buffer.append("      ,S_SE_SD_Setmealidno ");
		buffer.append("  FROM S_SE_SalesDetail inner join B_GoodsInfo on S_SE_SD_SalesItemID = B_GI_GoodsID where S_SE_SD_SalesID = ? ");

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	/**
	 * 查询外帐所需当日销售单
	 * @param salesLogPo
	 */
	public List<SalesBasicPo> getFlysheetSalesBillList(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select billid as ssesbsalesid from ( ");
		buffer.append("select S_SE_SB_SalesID as billid from S_SE_SalesBasic inner join B_Departments_FlySheet on S_SE_SB_ShopCode = B_DP_DepartmentID ");
		buffer.append("  where S_SE_SB_ValueFlag = '1' and S_SE_SB_CheckoutFlag = '0' and B_DP_Type = '1' ");
		buffer.append("  and convert(varchar(10),S_SE_SB_PosDatetime,120) >= ? ");
		buffer.append("  and convert(varchar(10),S_SE_SB_PosDatetime,120) <= ? ");
		buffer.append("union ");
		buffer.append("select S_SE_SB_SalesID as billid from S_SE_SalesBasic inner join B_Departments_FlySheet on S_SE_SB_ShopCode = B_DP_DepartmentID ");
		buffer.append("  where S_SE_SB_ValueFlag = '1' and S_SE_SB_CheckoutFlag = '0' and B_DP_Type = '1' ");
		buffer.append("  and convert(varchar(10),S_SE_SB_ArrearsAppendDate,120) >= ? ");
		buffer.append("  and convert(varchar(10),S_SE_SB_ArrearsAppendDate,120) <= ? ");
		buffer.append("union ");
		buffer.append("select a.S_SE_SB_SalesID as billid from S_SE_SalesBasic a inner join B_Departments_FlySheet b on a.S_SE_SB_ShopCode = b.B_DP_DepartmentID ");
		buffer.append("    inner join S_SE_SalesBasic_FlySheet c on a.S_SE_SB_SalesID = c.S_SE_SB_SalesID ");
		buffer.append("  where a.S_SE_SB_ValueFlag = '1' and a.S_SE_SB_WithdrawFlag = '1' and b.B_DP_Type = '1' ");
		buffer.append("  and convert(varchar(10),a.S_SE_SB_WithdrawDate,120) >= ? ");
		buffer.append("  and convert(varchar(10),a.S_SE_SB_WithdrawDate,120) <= ? ");
		buffer.append("union ");		
		buffer.append("select S_SE_SB_SalesID as billid from S_SE_SalesBasic_Finished inner join B_Departments_FlySheet on S_SE_SB_ShopCode = B_DP_DepartmentID ");
		buffer.append("  where S_SE_SB_ValueFlag = '1' and S_SE_SB_CheckoutFlag = '0' and B_DP_Type = '1' ");
		buffer.append("  and convert(varchar(10),S_SE_SB_PosDatetime,120) >= ? ");
		buffer.append("  and convert(varchar(10),S_SE_SB_PosDatetime,120) <= ? ");
		buffer.append("union ");
		buffer.append("select S_SE_SB_SalesID as billid from S_SE_SalesBasic_Finished inner join B_Departments_FlySheet on S_SE_SB_ShopCode = B_DP_DepartmentID ");
		buffer.append("  where S_SE_SB_ValueFlag = '1' and S_SE_SB_CheckoutFlag = '0' and B_DP_Type = '1' ");
		buffer.append("  and convert(varchar(10),S_SE_SB_ArrearsAppendDate,120) >= ? ");
		buffer.append("  and convert(varchar(10),S_SE_SB_ArrearsAppendDate,120) <= ? ");
		buffer.append("union ");
		buffer.append("select a.S_SE_SB_SalesID as billid from S_SE_SalesBasic_Finished a inner join B_Departments_FlySheet b on a.S_SE_SB_ShopCode = b.B_DP_DepartmentID ");
		buffer.append("    inner join S_SE_SalesBasic_FlySheet c on a.S_SE_SB_SalesID = c.S_SE_SB_SalesID ");
		buffer.append("  where a.S_SE_SB_ValueFlag = '1' and a.S_SE_SB_WithdrawFlag = '1' and b.B_DP_Type = '1' ");
		buffer.append("  and convert(varchar(10),a.S_SE_SB_WithdrawDate,120) >= ? ");
		buffer.append("  and convert(varchar(10),a.S_SE_SB_WithdrawDate,120) <= ? ");		
		buffer.append(")t1 ");
	
		params.add(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()));

		return queryForObjectList(buffer.toString(), params.toArray(),SalesBasicPo.class);
	}
	
	/**
	 * 查询外帐所需当日销售单是否只用现金结款
	 * @param salesLogPo
	 */
	public int getFlysheetSalesBillByXj(SalesBasicPo salesBasicPo){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(S_SE_SL_UUID) from S_SE_SalesLog where S_SE_SL_SalesID = ? and S_SE_SL_PaymentType in ('1','2','3') and S_SE_SL_ConsumptionID not in ('1','3','6') and S_SE_SL_Type = '1' ");

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询外帐所需当日销售单是否使用银联卡结款
	 * @param salesLogPo
	 */
	public int getFlysheetSalesBillByBank(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(S_SE_SL_UUID) from S_SE_SalesLog left join B_Bank on S_SE_SL_SourceID = B_B_Number where S_SE_SL_SalesID = ? and S_SE_SL_PaymentType in ('1','2','3') and S_SE_SL_ConsumptionID in ('3','6') and S_SE_SL_Type = '1' ");
	
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		if (!"".equals(Utility.getName(epo.getFeanocashmothe()))){
			String[] array = Utility.getName(epo.getFeanocashmothe()).split(",");
			sb.append("  and B_B_UUID not in  ( ? ");
			
			params.add(Utility.getName(array[0]));
			for (int i = 1; i < array.length; i++){
				sb.append("  ,? ");
				params.add(Utility.getName(array[i]));
			}
			sb.append(" ) ");			
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 删除外帐所需当日销售单是否使用银联卡结款
	 * @param salesLogPo
	 */
	public void deleteFlysheetSalesBill(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("delete from C_SH_StorageChange_FlySheet where C_SH_SC_ChangeID = ? ");
		buffer.append("delete from C_SH_StorageLog_FlySheet where C_SH_SL_ChangeID = ? ");
		buffer.append("delete from S_SE_AdditionalCDetail_FlySheet where S_SE_SalesID = ? ");
		buffer.append("delete from S_SE_InTransit_FlySheet where S_SE_IT_SalesID = ? ");
		buffer.append("delete from S_SE_SalesBasic_FlySheet where S_SE_SB_SalesID = ? ");
		buffer.append("delete from S_SE_SalesBasic_Today_FlySheet  where S_SE_SB_SalesID = ? ");
		buffer.append("delete from S_SE_SalesDetail_FlySheet  where S_SE_SD_SalesID = ? ");
		buffer.append("delete from S_SE_SalesDetail_Today_FlySheet where S_SE_SD_SalesID = ?  ");
		buffer.append("delete from S_SE_SalesLog_FlySheet where S_SE_SL_SalesID = ?  ");
		buffer.append("delete from S_SE_SpecialPDetail_FlySheet where S_SE_SD_SalesID = ?  ");

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	/**
	 * 查询外帐所需是否是当日销售单
	 * @param salesLogPo
	 */
	public int getFlysheetSalesBillByCurrent(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select sum(isnull(billid,0)) as ssesbsalesid from ( ");
		buffer.append("select count(S_SE_SB_SalesID) as billid from S_SE_SalesBasic where S_SE_SB_ValueFlag = '1' ");
		buffer.append("  and convert(varchar(10),S_SE_SB_PosDatetime,120) = convert(varchar(10),getdate(),120) ");
		buffer.append("  and S_SE_SB_SalesID = ? ");
		buffer.append("union ");
		buffer.append("select count(S_SE_SB_SalesID) as billid from S_SE_SalesBasic where S_SE_SB_ValueFlag = '1' and S_SE_SB_WithdrawFlag = '1' ");
		buffer.append("  and convert(varchar(10),S_SE_SB_WithdrawDate,120) = convert(varchar(10),getdate(),120) ");
		buffer.append("  and S_SE_SB_SalesID = ? ");
		buffer.append("union ");		
		buffer.append("select count(S_SE_SB_SalesID) as billid from S_SE_SalesBasic_Finished where S_SE_SB_ValueFlag = '1' ");
		buffer.append("  and convert(varchar(10),S_SE_SB_PosDatetime,120) = convert(varchar(10),getdate(),120) ");
		buffer.append("  and S_SE_SB_SalesID = ? ");
		buffer.append("union ");
		buffer.append("select count(S_SE_SB_SalesID) as billid from S_SE_SalesBasic_Finished where S_SE_SB_ValueFlag = '1' and S_SE_SB_WithdrawFlag = '1' ");
		buffer.append("  and convert(varchar(10),S_SE_SB_WithdrawDate,120) = convert(varchar(10),getdate(),120) ");
		buffer.append("  and S_SE_SB_SalesID = ? ");		
		buffer.append(")t1 ");
		
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	/**
	 * 外帐所需销售单是否退款
	 * @param salesLogPo
	 */
	public int getFlysheetSalesBillByWithdraw(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select sum(count1) from ( ");
		buffer.append("select count(S_SE_SB_SalesID) as count1 from S_SE_SalesBasic where S_SE_SB_SalesID = ? and S_SE_SB_ValueFlag = '1' and S_SE_SB_WithdrawFlag = '1' ");
		buffer.append("union all ");
		buffer.append("select count(S_SE_SB_SalesID) as count1 from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ? and S_SE_SB_ValueFlag = '1' and S_SE_SB_WithdrawFlag = '1' ");
		buffer.append(" )t ");
		
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	/**
	 * 查询外帐所需当日挂号费
	 * @param salesLogPo
	 */
	public List<RegisteredDetailsPo> getFlysheetRegistrationList(RegisteredDetailsPo rpo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select distinct S_CR_RD_DetailsID as scrrddetailsid from S_CR_RegisteredDetails inner join B_Departments_FlySheet on S_CR_RD_ShopCode = B_DP_DepartmentID ");
		buffer.append("  where S_CR_RD_Flag = '1' and B_DP_Type = '1' ");
		buffer.append("  and convert(varchar(10),S_CR_RD_CasherDate,120) >= ? ");
		buffer.append("  and convert(varchar(10),S_CR_RD_CasherDate,120) <= ? ");
	
		params.add(Utility.getName(rpo.getScrrdcasherbgndate()));
		params.add(Utility.getName(rpo.getScrrdcasherenddate()));

		return queryForObjectList(buffer.toString(), params.toArray(),RegisteredDetailsPo.class);
	}
	
	/**
	 * 查询外帐所需当日挂号费是否只用现金结款
	 * @param salesLogPo
	 */
	public int getFlysheetRegistrationByXj(RegisteredDetailsPo rpo){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(S_SE_SL_UUID) from S_SE_SalesLog where S_SE_SL_SalesID = ? and S_SE_SL_PaymentType in ('6','7') and S_SE_SL_ConsumptionID not in ('1','3','6') and S_SE_SL_Type = '2' ");

		params.add(Utility.getName(rpo.getScrrddetailsid()));
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询外帐所需当日挂号费是否使用银联卡结款
	 * @param salesLogPo
	 */
	public int getFlysheetRegistrationByBank(RegisteredDetailsPo rpo,ExternalAccountParameterPo epo){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(S_SE_SL_UUID) from S_SE_SalesLog left join B_Bank on S_SE_SL_SourceID = B_B_Number where S_SE_SL_SalesID = ? and S_SE_SL_PaymentType in ('6','7') and S_SE_SL_ConsumptionID in ('3','6') and S_SE_SL_Type = '2' ");

		params.add(Utility.getName(rpo.getScrrddetailsid()));
		
		if (!"".equals(Utility.getName(epo.getFeanocashmothe()))){
			String[] array = Utility.getName(epo.getFeanocashmothe()).split(",");
			sb.append("  and B_B_UUID not in  ( ? ");
			
			params.add(Utility.getName(array[0]));
			for (int i = 1; i < array.length; i++){
				sb.append("  ,? ");
				params.add(Utility.getName(array[i]));
			}
			sb.append(" ) ");			
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 删除外帐所需当日挂号费
	 * @param salesLogPo
	 */
	public void deleteFlysheetRegistration(RegisteredDetailsPo rpo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

        buffer.append("delete from S_SE_SalesLog_FlySheet where S_SE_SL_SalesID = ?  ");
		buffer.append("delete from S_CR_RegisteredDetails_FlySheet where S_CR_RD_DetailsID = ?  ");

		params.add(Utility.getName(rpo.getScrrddetailsid()));
		params.add(Utility.getName(rpo.getScrrddetailsid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	/**
	 * 外帐新增挂号类别
	 * @param salesLogPo
	 */
	public void insertFlysheetRegistrationType(RegisteredDetailsPo rpo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SET XACT_ABORT ON; ");
		
		buffer.append("select S_CR_RD_RegisteredID into #registered from S_CR_RegisteredDetails where S_CR_RD_DetailsID = ? and S_CR_RD_RegisteredID not in ( select F_RC_ID from " +Utility.getName(epo.getFeaaccessname()) + "." + Utility.getName(epo.getFeaexternalname()) + ".dbo.F_RegisteredCategory) ");
		
		buffer.append("	INSERT INTO " +Utility.getName(epo.getFeaaccessname()) + "." + Utility.getName(epo.getFeaexternalname()) + ".dbo.F_RegisteredCategory ");
		buffer.append("           (F_RC_ID	");
		buffer.append("           ,F_RC_RegisteredName	");
		buffer.append("           ,F_RC_Money	");
		buffer.append("           ,F_RC_FeeType	");
		buffer.append("           ,F_RC_orderType	");
		buffer.append("           ,F_RC_RegisteredType	");
		buffer.append("           ,F_RC_Flag	");
		buffer.append("           ,F_RC_AmountType)	");
		buffer.append("  SELECT   F_RC_ID	");
		buffer.append("           ,F_RC_RegisteredName	");
		buffer.append("           ,F_RC_Money	");
		buffer.append("           ,F_RC_FeeType	");
		buffer.append("           ,F_RC_orderType	");
		buffer.append("           ,F_RC_RegisteredType	");
		buffer.append("           ,F_RC_Flag	");
		buffer.append("           ,F_RC_AmountType	");
		buffer.append("	  FROM F_RegisteredCategory where F_RC_ID in (select S_CR_RD_RegisteredID from #registered) ");
		
		buffer.append(" drop table #registered ");

		params.add(Utility.getName(rpo.getScrrddetailsid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	/**
	 * 外帐新增挂号费
	 * @param salesLogPo
	 */
	public void insertFlysheetRegistration(RegisteredDetailsPo rpo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("	INSERT INTO S_CR_RegisteredDetails_FlySheet ");
		buffer.append("           (S_CR_RD_ID ");
		buffer.append("           ,S_CR_RD_DetailsID ");
		buffer.append("           ,S_CR_RD_CustomerID ");
		buffer.append("           ,S_CR_RD_ShopCode ");
		buffer.append("           ,S_CR_RD_RegisteredID ");
		buffer.append("           ,S_CR_RD_Flag ");
		buffer.append("           ,S_CR_RD_Money ");
		buffer.append("           ,S_CR_RD_OptDate ");
		buffer.append("           ,S_CR_RD_Register ");
		buffer.append("           ,S_CR_RD_Casher ");
		buffer.append("           ,S_CR_RD_CasherDate ");
		buffer.append("           ,S_CR_RD_AmountType ");
		buffer.append("           ,S_CR_RD_CheckPerson) ");
		buffer.append("SELECT S_CR_RD_ID ");
		buffer.append("      ,S_CR_RD_DetailsID ");
		buffer.append("      ,S_CR_RD_CustomerID ");
		buffer.append("      ,S_CR_RD_ShopCode ");
		buffer.append("      ,S_CR_RD_RegisteredID ");
		buffer.append("      ,S_CR_RD_Flag ");
		buffer.append("      ,S_CR_RD_Money ");
		buffer.append("      ,S_CR_RD_OptDate ");
		buffer.append("      ,S_CR_RD_Register ");
		buffer.append("      ,S_CR_RD_Casher ");
		buffer.append("      ,S_CR_RD_CasherDate ");
		buffer.append("      ,S_CR_RD_AmountType");
	    buffer.append("      ,S_CR_RD_CheckPerson");
	    buffer.append("  FROM S_CR_RegisteredDetails where S_CR_RD_DetailsID = ? " );
	    
		params.add(Utility.getName(rpo.getScrrddetailsid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	/**
	 * 外帐新增挂号费付款记录
	 * @param salesLogPo
	 */
	public void insertFlysheetRegistrationSalesLog(RegisteredDetailsPo rpo,ExternalAccountParameterPo epo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("INSERT INTO S_SE_SalesLog_FlySheet ");
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
		buffer.append("SELECT substring(cast(newid() as varchar(50)),1,32) as S_SE_SL_UUID ");
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
		buffer.append("  FROM S_SE_SalesLog where S_SE_SL_SalesID = ? and S_SE_SL_PaymentType in ( '6','7') and S_SE_SL_Type = '2' ");

		params.add(Utility.getName(rpo.getScrrddetailsid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelectList(WeiXinIntegralSelectPo po, int start,int size) {

		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select * from ( ");
		sb.append("SELECT Row_number() OVER( ORDER BY W_IE_CreatDate DESC) AS rowNum,W_IE_ID as wieid, ");
		sb.append("       W_IE_CustomerID as wiecustomerid, ");
		sb.append("       S_ME_CI_Name as wiecustomername,");
		sb.append("       W_IE_OpenID as wieopenid, ");
		sb.append("       W_IE_CreatDate as wiecreatdate, ");
		sb.append("       W_IE_Flag as wieflag, ");
		sb.append("       W_IE_ExchangeDate as wieexchangedate, ");
		sb.append("       W_IE_PersonID as wiepersonid, ");
		sb.append("       personName as wiepersonname, ");
		sb.append("       W_IE_DepartmentID as wiedepartmentid, ");
		sb.append("       B_DP_DepartmentName as wiedepartmentname,");
		sb.append("       W_IE_GoodsID as wiegoodsid, ");
		sb.append("       W_IE_Integral as wieintegral, ");
		sb.append("       S_ME_CI_Phone as wiephone, ");
		sb.append("       B_GI_GoodsName as wiegoodname,  ");
		sb.append("       S_ME_CI_Flag as wiecustomerenable  ");
		sb.append("FROM   W_IntegralExchange ");
		sb.append("       LEFT JOIN dbo.S_ME_CustomerInfo ");
		sb.append("         ON S_ME_CI_CustomerID = W_IE_CustomerID ");
		sb.append("       LEFT JOIN dbo.SYS_PersonInfo ");
		sb.append("         ON ID = W_IE_PersonID ");
		sb.append("       LEFT JOIN dbo.B_Departments ");
		sb.append("         ON B_DP_DepartmentID = W_IE_DepartmentID ");
		sb.append("       LEFT JOIN dbo.B_GoodsInfo ");
		sb.append("         ON B_GI_GoodsID = W_IE_GoodsID where 1=1");
		if(po != null){
			if(!"".equals(Utility.getName(po.getWiecustomername()))){
				sb.append(" and S_ME_CI_Name like '%'+?+'%' ");
				params.add(po.getWiecustomername());
			}
			if(!"".equals(Utility.getName(po.getWiephone()))){
				sb.append(" and S_ME_CI_Phone like '%'+?+'%' ");
				params.add(po.getWiephone());
			}
			if(!"".equals(Utility.getName(po.getWiedepartmentid()))){
				sb.append(" and W_IE_DepartmentID = ?  ");
				params.add(po.getWiedepartmentid());
			}
			if(!"".equals(Utility.getName(po.getWieflag()))){
				sb.append(" and W_IE_Flag = ?  ");
				params.add(po.getWieflag());
			}
			if(!"".equals(Utility.getName(po.getStartTime())) && !"".equals(Utility.getName(po.getEndTime()))){
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) >= ? ");
				params.add(po.getStartTime());
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) <= ? ");
				params.add(po.getEndTime());
			}else if(!"".equals(Utility.getName(po.getStartTime())) && "".equals(Utility.getName(po.getEndTime()))){
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) >= ? ");
				params.add(po.getStartTime());
				
			}else if("".equals(Utility.getName(po.getStartTime())) && !"".equals(Utility.getName(po.getEndTime()))){
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) <= ? ");
				params.add(po.getEndTime());
			}
			if(!"".equals(Utility.getName(po.getStartTimeGive())) && !"".equals(Utility.getName(po.getEndTimeGive()))){
				sb.append("and convert(varchar(10), W_IE_ExchangeDate, 23) >= ? ");
				params.add(po.getStartTimeGive());
				sb.append("and convert(varchar(10), W_IE_ExchangeDate, 23) <= ? ");
				params.add(po.getEndTimeGive());
			}else if(!"".equals(Utility.getName(po.getStartTimeGive())) && "".equals(Utility.getName(po.getEndTimeGive()))){
				sb.append("and convert(varchar(10), W_IE_ExchangeDate, 23) >= ? ");
				params.add(po.getStartTimeGive());
				
			}else if("".equals(Utility.getName(po.getStartTimeGive())) && !"".equals(Utility.getName(po.getEndTimeGive()))){
				sb.append("and convert(varchar(10), W_IE_ExchangeDate, 23) <= ? ");
				params.add(po.getEndTimeGive());
			}
			if(!"".equals(Utility.getName(po.getWieid()))){
				sb.append(" and W_IE_ID = ? ");
				params.add(po.getWieid());
			}
			
			if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
				
				sb.append(" and S_ME_CI_ShopCode in ( ? ");

				List<DepartmentsPo> dList = po.getSmecishoplist();
				params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

				for (int i = 1; i < dList.size(); i++){
					sb.append(" ,? ");
					params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
				}
				sb.append(" ) ");
			}
		}
		sb.append("  ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), WeiXinIntegralSelectPo.class);
	}
	public int getWeiXinIntegralSelectCount(WeiXinIntegralSelectPo po) {
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT count(W_IE_ID) ");
		sb.append("FROM   W_IntegralExchange ");
		sb.append("       LEFT JOIN dbo.S_ME_CustomerInfo ");
		sb.append("         ON S_ME_CI_CustomerID = W_IE_CustomerID ");
		sb.append("       LEFT JOIN dbo.SYS_PersonInfo ");
		sb.append("         ON ID = W_IE_PersonID ");
		sb.append("       LEFT JOIN dbo.B_Departments ");
		sb.append("         ON B_DP_DepartmentID = W_IE_DepartmentID ");
		sb.append("       LEFT JOIN dbo.B_GoodsInfo ");
		sb.append("         ON B_GI_GoodsID = W_IE_GoodsID  where 1=1 ");
		if(po != null){
			if(!"".equals(Utility.getName(po.getWiecustomername()))){
				sb.append(" and S_ME_CI_Name like '%'+?+'%' ");
				params.add(po.getWiecustomername());
			}
			if(!"".equals(Utility.getName(po.getWiephone()))){
				sb.append(" and S_ME_CI_Phone like '%'+?+'%' ");
				params.add(po.getWiephone());
			}
			if(!"".equals(Utility.getName(po.getWiedepartmentid()))){
				sb.append(" and W_IE_DepartmentID = ?  ");
				params.add(po.getWiedepartmentid());
			}
			if(!"".equals(Utility.getName(po.getWieflag()))){
				sb.append(" and W_IE_Flag = ?  ");
				params.add(po.getWieflag());
			}
			if(!"".equals(Utility.getName(po.getStartTime())) && !"".equals(Utility.getName(po.getEndTime()))){
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) >= ? ");
				params.add(po.getStartTime());
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) <= ? ");
				params.add(po.getEndTime());
			}else if(!"".equals(Utility.getName(po.getStartTime())) && "".equals(Utility.getName(po.getEndTime()))){
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) >= ? ");
				params.add(po.getStartTime());
				
			}else if("".equals(Utility.getName(po.getStartTime())) && !"".equals(Utility.getName(po.getEndTime()))){
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) <= ? ");
				params.add(po.getEndTime());
			}
			if(!"".equals(Utility.getName(po.getStartTimeGive())) && !"".equals(Utility.getName(po.getEndTimeGive()))){
				sb.append("and convert(varchar(10), W_IE_ExchangeDate, 23) >= ? ");
				params.add(po.getStartTimeGive());
				sb.append("and convert(varchar(10), W_IE_ExchangeDate, 23) <= ? ");
				params.add(po.getEndTimeGive());
			}else if(!"".equals(Utility.getName(po.getStartTimeGive())) && "".equals(Utility.getName(po.getEndTimeGive()))){
				sb.append("and convert(varchar(10), W_IE_ExchangeDate, 23) >= ? ");
				params.add(po.getStartTimeGive());
				
			}else if("".equals(Utility.getName(po.getStartTimeGive())) && !"".equals(Utility.getName(po.getEndTimeGive()))){
				sb.append("and convert(varchar(10), W_IE_ExchangeDate, 23) <= ? ");
				params.add(po.getEndTimeGive());
			}
			if(!"".equals(Utility.getName(po.getWieid()))){
				sb.append(" and W_IE_ID = ? ");
				params.add(po.getWieid());
			}
			
			if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
				
				sb.append(" and S_ME_CI_ShopCode in ( ? ");

				List<DepartmentsPo> dList = po.getSmecishoplist();
				params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

				for (int i = 1; i < dList.size(); i++){
					sb.append(" ,? ");
					params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
				}
				sb.append(" ) ");
			}
			
		}
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelect(WeiXinIntegralSelectPo po) {
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT [S_ME_CI_CustomerID] as wiecustomerid,S_ME_CI_Name as  wiecustomername,S_ME_CI_CustomerID as wiecustomerid,S_ME_CI_Integral as wieintegral,S_ME_CI_MemberId as wiememberid  ");
		sb.append("FROM   [dbo].[S_ME_CustomerInfo] ");
		sb.append("WHERE  S_ME_CI_OpenID = ? ");
		params.add(po.getWieopenid());
		return queryForObjectList(sb.toString(), params.toArray(), WeiXinIntegralSelectPo.class);
		
	}
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelectList(WeiXinIntegralSelectPo po) {

		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT W_IE_ID as wieid, ");
		sb.append("       W_IE_CustomerID as wiecustomerid, ");
		sb.append("       S_ME_CI_Name as wiecustomername,");
		sb.append("       B_GI_GoodsBarCode as wiegoodsbarcode,");
		sb.append("       S_ME_CI_MemberId as wiememberid,");
		sb.append("       W_IE_OpenID as wieopenid, ");
		sb.append("       W_IE_GoodsNumber as wiegoodsnumber, ");
		sb.append("       W_IE_CreatDate as wiecreatdate, ");
		sb.append("       W_IE_Flag as wieflag, ");
		sb.append("       W_IE_ExchangeDate as wieexchangedate, ");
		sb.append("       W_IE_PersonID as wiepersonid, ");
		sb.append("       personName as wiepersonname, ");
		sb.append("       W_IE_DepartmentID as wiedepartmentid, ");
		sb.append("       B_DP_DepartmentName as wiedepartmentname,");
		sb.append("       W_IE_GoodsID as wiegoodsid, ");
		sb.append("       W_IE_Integral as wieintegral, ");
		sb.append("       S_ME_CI_Phone as wiephone, ");
		sb.append("       B_GI_GoodsName as wiegoodname  ");
		sb.append("FROM   W_IntegralExchange ");
		sb.append("       LEFT JOIN dbo.S_ME_CustomerInfo ");
		sb.append("         ON S_ME_CI_CustomerID = W_IE_CustomerID ");
		sb.append("       LEFT JOIN dbo.SYS_PersonInfo ");
		sb.append("         ON ID = W_IE_PersonID ");
		sb.append("       LEFT JOIN dbo.B_Departments ");
		sb.append("         ON B_DP_DepartmentID = W_IE_DepartmentID ");
		sb.append("       LEFT JOIN dbo.B_GoodsInfo ");
		sb.append("         ON B_GI_GoodsID = W_IE_GoodsID where 1=1");
		if(po != null){
			if(!"".equals(Utility.getName(po.getWiecustomername()))){
				sb.append(" and S_ME_CI_Name like '%'+?+'%' ");
				params.add(po.getWiecustomername());
			}
			if(!"".equals(Utility.getName(po.getWiephone()))){
				sb.append(" and S_ME_CI_Phone like '%'+?+'%' ");
				params.add(po.getWiephone());
			}
			if(!"".equals(Utility.getName(po.getWiedepartmentid()))){
				sb.append(" and W_IE_DepartmentID = ?  ");
				params.add(po.getWiedepartmentid());
			}
			if(!"".equals(Utility.getName(po.getWieflag()))){
				sb.append(" and W_IE_Flag = ?  ");
				params.add(po.getWieflag());
			}
			if(!"".equals(Utility.getName(po.getStartTime())) && !"".equals(Utility.getName(po.getEndTime()))){
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) >= ? ");
				params.add(po.getStartTime());
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) <= ? ");
				params.add(po.getEndTime());
			}else if(!"".equals(Utility.getName(po.getStartTime())) && "".equals(Utility.getName(po.getEndTime()))){
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) >= ? ");
				params.add(po.getStartTime());
				
			}else if("".equals(Utility.getName(po.getStartTime())) && !"".equals(Utility.getName(po.getEndTime()))){
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) <= ? ");
				params.add(po.getEndTime());
			}
			if(!"".equals(Utility.getName(po.getStartTimeGive())) && !"".equals(Utility.getName(po.getEndTimeGive()))){
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) >= ? ");
				params.add(po.getStartTimeGive());
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) <= ? ");
				params.add(po.getEndTimeGive());
			}else if(!"".equals(Utility.getName(po.getStartTimeGive())) && "".equals(Utility.getName(po.getEndTimeGive()))){
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) >= ? ");
				params.add(po.getStartTimeGive());
				
			}else if("".equals(Utility.getName(po.getStartTimeGive())) && !"".equals(Utility.getName(po.getEndTimeGive()))){
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) <= ? ");
				params.add(po.getEndTimeGive());
			}
			if(!"".equals(Utility.getName(po.getWieid()))){
				sb.append(" and W_IE_ID = ? ");
				params.add(po.getWieid());
			}
		}
		return queryForObjectList(sb.toString(), params.toArray(), WeiXinIntegralSelectPo.class);
	}
	public void updateWeiXinIntegralSelect(WeiXinIntegralSelectPo po){
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("UPDATE W_IntegralExchange ");
		sb.append("SET    [W_IE_Flag] = 1, ");
		sb.append("       [W_IE_ExchangeDate] = Getdate(), ");
		sb.append("       [W_IE_DepartmentID]=?, ");
		sb.append("       [W_IE_PersonID] = ?  ");
		sb.append("WHERE  1 = 1 and W_IE_ID = ?  ");
		params.add(Utility.getName(po.getWiedepartmentid()));
		params.add(Utility.getName(po.getWiepersonid()));
		params.add(Utility.getName(po.getWieid()));
		getJdbcTemplate().update(sb.toString(), params.toArray());	
	}
	
	/**
	 * 更新基表套餐使用标记
	 * @param salesLogPo
	 */
	public void updateSalseBillSetMealFlag(SalesBasicPo salesBasicPo){
		
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update top (1) S_SE_SalesBasic set S_SE_SB_SetMealFlag = ?  ");
		sb.append("  where S_SE_SB_SalesID = ? ");
		
		params.add(Utility.getName(salesBasicPo.getSsesbusesetmealflag()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());	
	}
	
	/**
	 * 将附加费金额更新至基表
	 * @param salesLogPo
	 */
	public void updateSalseBillAdditionalCDetail(SalesBasicPo salesBasicPo){
		
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update top (1) S_SE_SalesBasic set S_SE_SB_Additional = ?  ");
		sb.append("  where S_SE_SB_SalesID = ? ");
		
		params.add(Utility.getName(salesBasicPo.getSsesbadditionPrice()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 将附加费内容以逗号分隔的形式存入基表
	 * @param salesLogPo
	 */
	public void updateSalseBillAdditionalDes(SalesBasicPo salesBasicPo){
		
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update top (1) S_SE_SalesBasic set S_SE_SB_AdditionalName=?  ");
		sb.append("  where S_SE_SB_SalesID = ? ");
		
		params.add(Utility.getName(salesBasicPo.getSsesbadditionname()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 将套餐名称以逗号分隔的形式存入基表
	 * @param salesLogPo
	 */
	public void updateSalseBillSetMealName(SalesBasicPo salesBasicPo){
		
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update top (1) S_SE_SalesBasic set S_SE_SB_SetMealName=?  ");
		sb.append("  where S_SE_SB_SalesID = ? ");
		
		params.add(Utility.getName(salesBasicPo.getSsesbsetmealtitle()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 更新结款方式表
	 * @param salesLogPo
	 */
	public void updateSalesCashForm(SalesLogPo slpo){
		
		List<String> params = new ArrayList<String>();
		StringBuffer  buffer = new StringBuffer();
		
		buffer.append("INSERT INTO S_SE_SalesCrossLog ");
		buffer.append("            (S_SE_SL_UUID, ");
		buffer.append("             S_SE_SL_SalesID,S_SE_SL_ShopCode,S_SE_SL_Type, ");
		buffer.append("             S_SE_SL_PaymentType, ");
		buffer.append("             S_SE_SL_DateTime, ");
		buffer.append("             S_SE_SL_FactDateTime, ");
		buffer.append("             S_SE_SL_Person, ");
		buffer.append("             S_SE_SL_CashPrice, ");	
		buffer.append("             S_SE_SL_IntegralPrice, ");	
		buffer.append("             S_SE_SL_BrankCardPrice, ");	
		buffer.append("             S_SE_SL_PetCardPrice, ");	
		buffer.append("             S_SE_SL_ChitPrice, ");	
		buffer.append("             S_SE_SL_NotCashPrice ");	
		buffer.append("             ) ");
		buffer.append("VALUES      ( ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              dbo.ufn_getDayCheckOut(), ");
		buffer.append("              getdate(), ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ? ) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(slpo.getSseslsalesid()));
		params.add(Utility.getName(slpo.getSseslshopcode()));
		params.add(Utility.getName(slpo.getSsesltype()));		
		params.add(Utility.getName(slpo.getSseslpaymenttype()));
		params.add(Utility.getName(slpo.getSseslperson()));
		params.add(Utility.getName(slpo.getSseslcashprice()));
		params.add(Utility.getName(slpo.getSseslintegralprice()));
		params.add(Utility.getName(slpo.getSseslbankcardprice()));		
		params.add(Utility.getName(slpo.getSseslpetcardprice()));
		params.add(Utility.getName(slpo.getSseslchitprice()));
		params.add(Utility.getName(slpo.getSseslnotcashprice()));
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());	
	}
	
	/**
	 * 更新结款方式表（横向）
	 * @param salesLogPo
	 */
	public void insertSalesCrossLogForUpdatePaymentType(SalesLogPo slpo){
		
		List<String> params = new ArrayList<String>();
		StringBuffer  buffer = new StringBuffer();
		
		buffer.append("INSERT INTO S_SE_SalesCrossLog ");
		buffer.append("            (S_SE_SL_UUID, ");
		buffer.append("             S_SE_SL_SalesID,S_SE_SL_ShopCode,S_SE_SL_Type, ");
		buffer.append("             S_SE_SL_PaymentType, ");
		buffer.append("             S_SE_SL_DateTime, ");
		buffer.append("             S_SE_SL_FactDateTime, ");
		buffer.append("             S_SE_SL_Person, ");
		buffer.append("             S_SE_SL_CashPrice, ");	
		buffer.append("             S_SE_SL_IntegralPrice, ");	
		buffer.append("             S_SE_SL_BrankCardPrice, ");	
		buffer.append("             S_SE_SL_PetCardPrice, ");	
		buffer.append("             S_SE_SL_ChitPrice, ");	
		buffer.append("             S_SE_SL_NotCashPrice ");	
		buffer.append("             ) ");
		buffer.append("select        ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		if ("13".equals(Utility.getName(slpo.getSseslintransit())) || "14".equals(Utility.getName(slpo.getSseslintransit()))){
			if(Utility.getName(slpo.getSseslpaymenttype()).equals("1")){
				buffer.append("          (select top 1 S_SE_SB_PosDatetime from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(slpo.getSseslpaymenttype()).equals("2")){
				buffer.append("          (select top 1 S_SE_SB_PosDatetime from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(slpo.getSseslpaymenttype()).equals("3")){
				buffer.append("          (select top 1 S_SE_SB_ArrearsAppendDate from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(slpo.getSseslpaymenttype()).equals("4")){
				buffer.append("          (select top 1 S_SE_SB_WithdrawDate from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(slpo.getSseslpaymenttype()).equals("5")){
				buffer.append("          (select top 1 S_SE_SB_WithdrawDate from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ?), ");
			}
		}else{
			if(Utility.getName(slpo.getSseslpaymenttype()).equals("1")){
				buffer.append("          (select top 1 S_SE_SB_PosDatetime from dbo.S_SE_SalesBasic where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(slpo.getSseslpaymenttype()).equals("2")){
				buffer.append("          (select top 1 S_SE_SB_PosDatetime from dbo.S_SE_SalesBasic where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(slpo.getSseslpaymenttype()).equals("3")){
				buffer.append("          (select top 1 S_SE_SB_ArrearsAppendDate from dbo.S_SE_SalesBasic where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(slpo.getSseslpaymenttype()).equals("4")){
				buffer.append("          (select top 1 S_SE_SB_WithdrawDate from dbo.S_SE_SalesBasic where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(slpo.getSseslpaymenttype()).equals("5")){
				buffer.append("          (select top 1 S_SE_SB_WithdrawDate from S_SE_SalesBasic where S_SE_SB_SalesID = ?), ");
			}
		}
		
		if ("13".equals(Utility.getName(slpo.getSseslintransit())) || "14".equals(Utility.getName(slpo.getSseslintransit()))){
			if(Utility.getName(slpo.getSseslpaymenttype()).equals("1")){
				buffer.append("          (select top 1 S_SE_SB_FactPosDatetime from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(slpo.getSseslpaymenttype()).equals("2")){
				buffer.append("          (select top 1 S_SE_SB_FactPosDatetime from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(slpo.getSseslpaymenttype()).equals("3")){
				buffer.append("          (select top 1 S_SE_SB_FactArrearsAppendDate from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(slpo.getSseslpaymenttype()).equals("4")){
				buffer.append("          (select top 1 S_SE_SB_FactWithdrawDate from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(slpo.getSseslpaymenttype()).equals("5")){
				buffer.append("          (select top 1 S_SE_SB_FactWithdrawDate from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ?), ");
			}
		}else{
			if(Utility.getName(slpo.getSseslpaymenttype()).equals("1")){
				buffer.append("          (select top 1 S_SE_SB_FactPosDatetime from dbo.S_SE_SalesBasic where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(slpo.getSseslpaymenttype()).equals("2")){
				buffer.append("          (select top 1 S_SE_SB_FactPosDatetime from dbo.S_SE_SalesBasic where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(slpo.getSseslpaymenttype()).equals("3")){
				buffer.append("          (select top 1 S_SE_SB_FactArrearsAppendDate from dbo.S_SE_SalesBasic where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(slpo.getSseslpaymenttype()).equals("4")){
				buffer.append("          (select top 1 S_SE_SB_FactWithdrawDate from dbo.S_SE_SalesBasic where S_SE_SB_SalesID = ?), ");
			}else if(Utility.getName(slpo.getSseslpaymenttype()).equals("5")){
				buffer.append("          (select top 1 S_SE_SB_FactWithdrawDate from dbo.S_SE_SalesBasic where S_SE_SB_SalesID = ?), ");
			}
		}
		
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?  ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(slpo.getSseslsalesid()));
		params.add(Utility.getName(slpo.getSseslshopcode()));
		params.add(Utility.getName(slpo.getSsesltype()));		
		params.add(Utility.getName(slpo.getSseslpaymenttype()));
		params.add(Utility.getName(slpo.getSseslsalesid()));
		params.add(Utility.getName(slpo.getSseslsalesid()));
		params.add(Utility.getName(slpo.getSseslperson()));
		params.add(Utility.getName(slpo.getSseslcashprice()));
		params.add(Utility.getName(slpo.getSseslintegralprice()));
		params.add(Utility.getName(slpo.getSseslbankcardprice()));		
		params.add(Utility.getName(slpo.getSseslpetcardprice()));
		params.add(Utility.getName(slpo.getSseslchitprice()));
		params.add(Utility.getName(slpo.getSseslnotcashprice()));
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());	
	}
	
	/**
	 * 根据非现金结款类型的id查看所属类型
	 * @param salesLogPo
	 */
	public BankPo getNotCashTypeByID(String str){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 B_B_NonCashType as bbtype from B_Bank where B_B_Number = ? ");
		params.add(str);

		return (BankPo) queryForObject(buffer.toString(), params.toArray(), BankPo.class);
	}
	
	/**
	 * 更新汇总采购单据的标识位
	 * @param salesLogPo
	 */
	public void updateFlysheetCollectFlag(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" update S_SE_SalesDetail_FlySheet set S_SE_SD_IsPurchaseCollect = '1' where S_SE_SD_SalesID in (select distinct C_ST_PC_SalesBillID from C_ST_PurchaseCompare where C_ST_PC_IsPurchaseCollect = '1' and C_ST_PC_SalesBillID = ? ) ");
		
		sb.append(" update S_SE_SalesDetail_FlySheet set S_SE_SD_IsReturnPurchaseCollect = '1' where S_SE_SD_SalesID in (select distinct C_ST_PC_SalesBillID from C_ST_PurchaseCompare where C_ST_PC_IsReturnPurchaseCollect = '1' and C_ST_PC_SalesBillID = ? ) ");
		
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 重新执行外帐中的石英
	 * @param salesLogPo
	 */
	public void deleteReportQuartzLog(ModulePo tpo,ExternalAccountParameterPo epo){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SET XACT_ABORT ON; ");

		sb.append(" delete from " + Utility.getName(epo.getFeaaccessname()) + "." + Utility.getName(epo.getFeaexternalname()) + ".dbo.Sys_QE_LR_QuartzLog where Sys_QE_LR_Date = ? and Sys_QE_LR_QuartzID = ? ");

		params.add(Utility.getName(tpo.getReportDate()));
		params.add(Utility.getName(tpo.getReportID()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public CustomerInfoPo selCustomerIntegral(String salesID) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select top 1  S_ME_CI_CustomerID as smecicustomerid, ");
		sb.append("CAST(S_SE_SL_Price AS DECIMAL(18, 2))+S_ME_CI_Integral as smeciintegral ");
		sb.append("from S_ME_IntegralAddandSub ");
		sb.append("inner join S_ME_CustomerInfo on S_ME_CI_CustomerID=S_ME_AS_CustomerID ");
		sb.append("inner join S_SE_SalesLog on S_SE_SL_SalesID=S_ME_AS_SalesBillID ");
		sb.append("where 1=1 ");
		sb.append("and S_SE_SL_ConsumptionID='2' ");
		sb.append("and (S_SE_SL_PaymentType ='1' or S_SE_SL_PaymentType ='2' or S_SE_SL_PaymentType ='3')  ");
		sb.append("and S_SE_SL_SalesID= ? ");
		sb.append("order by S_ME_AS_DoDate desc ");
		
		
		params.add(Utility.getName(salesID));
		return (CustomerInfoPo) queryForObject(sb.toString(), params.toArray(), CustomerInfoPo.class);
	}
	
	public void updateCustomerIntegralNew2(String salesID, String integral) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("UPDATE S_ME_CustomerInfo ");
		buffer.append("SET S_ME_CI_Integral =  ? ");

		buffer.append("WHERE S_ME_CI_CustomerID = ? ");
		
		params.add(integral);
		
		params.add(salesID);

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}
	
	
	public void deleteCustomerIntegral(String salesID) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("DELETE FROM S_ME_IntegralAddandSub ");
		buffer.append("where 1=1 ");
		buffer.append("and S_ME_AS_SalesBillID=? "); 
		
		params.add(salesID);

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}
	
	/**
	 * 查看当前配镜单是否包含双自片
	 */
	public int getZZSupplierClassesBySalesBill(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(S_SE_SD_ID) from S_SE_SalesDetail where S_SE_SD_SalesID = ? and substring(S_SE_SD_SalesItemID,1,4) = '3.ZZ' and S_SE_SD_GlassFlag in ('L','R') ");
		
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	/**
	 * 新增营业员收银员记录
	 */
	public void insertSalerCashierRecord(SalesDetailPo sdpo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO S_SE_SalerCashierRecord ");
		buffer.append("           (S_SE_SCR_ID ");
		buffer.append("           ,S_SE_SCR_SalesID ");
		buffer.append("           ,S_SE_SCR_ShopCode ");
		buffer.append("           ,S_SE_SCR_SalerID ");
		buffer.append("           ,S_SE_SCR_PosID ");
		buffer.append("           ,S_SE_SCR_PosDate ");
		buffer.append("           ,S_SE_SCR_FactPosDate ");
		buffer.append("           ,S_SE_SCR_WithdrawFlag ");
		buffer.append("           ,S_SE_SCR_JjNum ");
		buffer.append("           ,S_SE_SCR_JjPrice ");
		buffer.append("           ,S_SE_SCR_PjNum ");
		buffer.append("           ,S_SE_SCR_PjPrice ");
		buffer.append("           ,S_SE_SCR_PjyxNum ");
		buffer.append("           ,S_SE_SCR_PjyxPrice ");
		buffer.append("           ,S_SE_SCR_CpjpNum ");
		buffer.append("           ,S_SE_SCR_CpjpPrice ");
		buffer.append("           ,S_SE_SCR_DzjpNum ");
		buffer.append("           ,S_SE_SCR_DzjpPrice ");
		buffer.append("           ,S_SE_SCR_YxcpjpNum ");
		buffer.append("           ,S_SE_SCR_YxcpjpPrice ");
		buffer.append("           ,S_SE_SCR_YxdzjpNum ");
		buffer.append("           ,S_SE_SCR_YxdzjpPrice ");
		buffer.append("           ,S_SE_SCR_HlyNum ");
		buffer.append("           ,S_SE_SCR_HlyPrice ");
		buffer.append("           ,S_SE_SCR_TyjNum ");
		buffer.append("           ,S_SE_SCR_TyjPrice ");
		buffer.append("           ,S_SE_SCR_HcNum ");
		buffer.append("           ,S_SE_SCR_HcPrice ");
		buffer.append("           ,S_SE_SCR_LhjNum ");
		buffer.append("           ,S_SE_SCR_LhjPrice ");
		buffer.append("           ,S_SE_SCR_SgNum ");
		buffer.append("           ,S_SE_SCR_SgPrice ");
		buffer.append("           ,S_SE_SCR_AdditionPrice ");
		buffer.append("           ,S_SE_SCR_DiscountPrice ");
		buffer.append("           ,S_SE_SCR_ZzJjNum ");
		buffer.append("           ,S_SE_SCR_ZzJpNum) ");
		buffer.append(" values (?,?,?,?,?,dbo.ufn_getDayCheckOut(),getdate(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(sdpo.getSsesdsalesid()));		
		params.add(Utility.getName(sdpo.getSsesdshopcode()));
		params.add(Utility.getName(sdpo.getSsesdsalerid()));
		params.add(Utility.getName(sdpo.getSsesdposid()));		
		params.add(Utility.getName(sdpo.getSsesdwithdrawflag()));		
		params.add(Utility.getName(sdpo.getSsesdjjnum()));
		params.add(Utility.getName(sdpo.getSsesdjjprice()));		
		params.add(Utility.getName(sdpo.getSsesdpjnum()));
		params.add(Utility.getName(sdpo.getSsesdpjprice()));
		params.add(Utility.getName(sdpo.getSsesdpjyxnum()));
		params.add(Utility.getName(sdpo.getSsesdpjyxprice()));	
		params.add(Utility.getName(sdpo.getSsesdcppnum()));
		params.add(Utility.getName(sdpo.getSsesdcppprice()));		
		params.add(Utility.getName(sdpo.getSsesddzpnum()));
		params.add(Utility.getName(sdpo.getSsesddzpprice()));		
		params.add(Utility.getName(sdpo.getSsesdyxcppnum()));
		params.add(Utility.getName(sdpo.getSsesdyxcppprice()));		
		params.add(Utility.getName(sdpo.getSsesdyxdzpnum()));
		params.add(Utility.getName(sdpo.getSsesdyxdzpprice()));		
		params.add(Utility.getName(sdpo.getSsesdhlynum()));
		params.add(Utility.getName(sdpo.getSsesdhlyprice()));		
		params.add(Utility.getName(sdpo.getSsesdtyjnum()));
		params.add(Utility.getName(sdpo.getSsesdtyjprice()));		
		params.add(Utility.getName(sdpo.getSsesdhcnum()));
		params.add(Utility.getName(sdpo.getSsesdhcprice()));		
		params.add(Utility.getName(sdpo.getSsesdlhjnum()));
		params.add(Utility.getName(sdpo.getSsesdlhjprice()));		
		params.add(Utility.getName(sdpo.getSsesdsgnum()));
		params.add(Utility.getName(sdpo.getSsesdsgprice()));		
		params.add(Utility.getName(sdpo.getSsesdadditionprice()));
		params.add(Utility.getName(sdpo.getSsesddiscountprice()));	
		params.add(Utility.getName(sdpo.getSsesdzzjjnum()));	
		params.add(Utility.getName(sdpo.getSsesdzzjpnum()));

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 新增营业员收银员记录(补齐)
	 */
	public void insertSalerCashierRecord_AppendArrears(SalesDetailPo sdpo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO S_SE_SalerCashierRecord_AppendArrears ");
		buffer.append("           (S_SE_SCR_ID ");
		buffer.append("           ,S_SE_SCR_SalesID ");
		buffer.append("           ,S_SE_SCR_ShopCode ");
		buffer.append("           ,S_SE_SCR_SalerID ");
		buffer.append("           ,S_SE_SCR_PosID ");
		buffer.append("           ,S_SE_SCR_PosDate ");
		buffer.append("           ,S_SE_SCR_FactPosDate ");
		buffer.append("           ,S_SE_SCR_WithdrawFlag ");
		buffer.append("           ,S_SE_SCR_JjNum ");
		buffer.append("           ,S_SE_SCR_JjPrice ");
		buffer.append("           ,S_SE_SCR_PjNum ");
		buffer.append("           ,S_SE_SCR_PjPrice ");
		buffer.append("           ,S_SE_SCR_PjyxNum ");
		buffer.append("           ,S_SE_SCR_PjyxPrice ");
		buffer.append("           ,S_SE_SCR_CpjpNum ");
		buffer.append("           ,S_SE_SCR_CpjpPrice ");
		buffer.append("           ,S_SE_SCR_DzjpNum ");
		buffer.append("           ,S_SE_SCR_DzjpPrice ");
		buffer.append("           ,S_SE_SCR_YxcpjpNum ");
		buffer.append("           ,S_SE_SCR_YxcpjpPrice ");
		buffer.append("           ,S_SE_SCR_YxdzjpNum ");
		buffer.append("           ,S_SE_SCR_YxdzjpPrice ");
		buffer.append("           ,S_SE_SCR_HlyNum ");
		buffer.append("           ,S_SE_SCR_HlyPrice ");
		buffer.append("           ,S_SE_SCR_TyjNum ");
		buffer.append("           ,S_SE_SCR_TyjPrice ");
		buffer.append("           ,S_SE_SCR_HcNum ");
		buffer.append("           ,S_SE_SCR_HcPrice ");
		buffer.append("           ,S_SE_SCR_LhjNum ");
		buffer.append("           ,S_SE_SCR_LhjPrice ");
		buffer.append("           ,S_SE_SCR_SgNum ");
		buffer.append("           ,S_SE_SCR_SgPrice ");
		buffer.append("           ,S_SE_SCR_AdditionPrice ");
		buffer.append("           ,S_SE_SCR_DiscountPrice ");
		buffer.append("           ,S_SE_SCR_ZzJjNum ");
		buffer.append("           ,S_SE_SCR_ZzJpNum) ");
		buffer.append(" values (?,?,?,?,?,dbo.ufn_getDayCheckOut(),getdate(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(sdpo.getSsesdsalesid()));		
		params.add(Utility.getName(sdpo.getSsesdshopcode()));
		params.add(Utility.getName(sdpo.getSsesdsalerid()));
		params.add(Utility.getName(sdpo.getSsesdposid()));		
		params.add(Utility.getName(sdpo.getSsesdwithdrawflag()));		
		params.add(Utility.getName(sdpo.getSsesdjjnum()));
		params.add(Utility.getName(sdpo.getSsesdjjprice()));		
		params.add(Utility.getName(sdpo.getSsesdpjnum()));
		params.add(Utility.getName(sdpo.getSsesdpjprice()));
		params.add(Utility.getName(sdpo.getSsesdpjyxnum()));
		params.add(Utility.getName(sdpo.getSsesdpjyxprice()));	
		params.add(Utility.getName(sdpo.getSsesdcppnum()));
		params.add(Utility.getName(sdpo.getSsesdcppprice()));		
		params.add(Utility.getName(sdpo.getSsesddzpnum()));
		params.add(Utility.getName(sdpo.getSsesddzpprice()));		
		params.add(Utility.getName(sdpo.getSsesdyxcppnum()));
		params.add(Utility.getName(sdpo.getSsesdyxcppprice()));		
		params.add(Utility.getName(sdpo.getSsesdyxdzpnum()));
		params.add(Utility.getName(sdpo.getSsesdyxdzpprice()));		
		params.add(Utility.getName(sdpo.getSsesdhlynum()));
		params.add(Utility.getName(sdpo.getSsesdhlyprice()));		
		params.add(Utility.getName(sdpo.getSsesdtyjnum()));
		params.add(Utility.getName(sdpo.getSsesdtyjprice()));		
		params.add(Utility.getName(sdpo.getSsesdhcnum()));
		params.add(Utility.getName(sdpo.getSsesdhcprice()));		
		params.add(Utility.getName(sdpo.getSsesdlhjnum()));
		params.add(Utility.getName(sdpo.getSsesdlhjprice()));		
		params.add(Utility.getName(sdpo.getSsesdsgnum()));
		params.add(Utility.getName(sdpo.getSsesdsgprice()));		
		params.add(Utility.getName(sdpo.getSsesdadditionprice()));
		params.add(Utility.getName(sdpo.getSsesddiscountprice()));	
		params.add(Utility.getName(sdpo.getSsesdzzjjnum()));	
		params.add(Utility.getName(sdpo.getSsesdzzjpnum()));	
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());		
	}
		
	/**
	 * 根据配镜单号获取整单优惠金额
	 */
	public SalesBasicPo getDiscountpriceByID(SalesBasicPo salesBasicPo){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select top 1 * from ( ");
		sb.append("select (S_SE_SB_PriceSum - S_SE_SB_SalesValue) as ssesbdiscountnum from S_SE_SalesBasic where S_SE_SB_SalesID = ? ");
		sb.append(" union all ");
		sb.append("select (S_SE_SB_PriceSum - S_SE_SB_SalesValue) as ssesbdiscountnum from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ? ");
		sb.append(")t ");
		
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		return (SalesBasicPo) queryForObject(sb.toString(), params.toArray(), SalesBasicPo.class);
	}
	
	/**
	 * 根据配镜单号查看配镜单是否存在附加费
	 */
	public int getAdditionpriceCountByID(SalesBasicPo salesBasicPo){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(S_SE_ID) from S_SE_AdditionalCDetail where S_SE_SalesID = ? ");
	
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 根据配镜单号获取整单附加费
	 */
	public SalesBasicPo getAdditionpriceByID(SalesBasicPo salesBasicPo){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("select top 1 isnull(sum(S_SE_Amount * cast(S_SE_Number as numeric)),0) as ssesbadditionPrice from S_SE_AdditionalCDetail where S_SE_SalesID = ? ");
		
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		return (SalesBasicPo) queryForObject(sb.toString(), params.toArray(), SalesBasicPo.class);
	}
	
	/**
	 * 根据配镜单号获取门店和营业员、收银员
	 */
	public SalesBasicPo getSalesBasicInfoByID(SalesBasicPo salesBasicPo){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select top 1 * from ( ");
		sb.append("select S_SE_SB_SalesID as ssesbsalesid,S_SE_SB_ShopCode as ssesbshopcode,S_SE_SB_SalerID as ssesbsalerid,S_SE_SB_PosID as ssesbposid from S_SE_SalesBasic where S_SE_SB_SalesID = ? ");
		sb.append(" union all ");
		sb.append("select S_SE_SB_SalesID as ssesbsalesid,S_SE_SB_ShopCode as ssesbshopcode,S_SE_SB_SalerID as ssesbsalerid,S_SE_SB_PosID as ssesbposid from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ? ");
		sb.append(")t ");
		
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		return (SalesBasicPo) queryForObject(sb.toString(), params.toArray(), SalesBasicPo.class);
	}
	
	
	public List<SalesDetailPo> getVipCardList(String salesID) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select distinct ssesdvipcard as ssesdvipcard from (select  S_SE_SD_VipCard as ssesdvipcard from S_SE_SalesDetail ");
		sb.append("where S_SE_SD_SalesID= ? ");
		sb.append("union all ");
		sb.append("select  S_SE_SD_VipCard as ssesdvipcard from S_SE_SalesDetail_Finished ");
		sb.append("where S_SE_SD_SalesID= ? )t ");
		
		params.add(Utility.getName(salesID));
		params.add(Utility.getName(salesID));
		
		return queryForObjectList(sb.toString(), params.toArray(), SalesDetailPo.class);
	}
	
	/**
	 * 只有待结款的单子才能调用
	 */
	public SalesBasicPo getSalesBasicsNoFinished(SalesBasicPo salesBasicPo){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by ssesbsalesid desc) as rowNum,* from ( ");
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid ");
		buffer.append(", S_SE_SB_PriceSum as ssesbpricesum ");
		buffer.append(", S_SE_SB_SalesValue as ssesbsalesvalue ");
		buffer.append(", S_SE_SB_ArrearsValue as ssesbarrearsvalue ");
		buffer.append(", S_SE_SB_DiscountNum as ssesbdiscountnum ");
		buffer.append(", S_SE_SB_Psalsvalue as ssesbpsalsvalue ");
		buffer.append(", s.personName as ssesbsalerName ");
		buffer.append(", S_SE_SB_CheckoutFlag as ssesbcheckoutflag ");
		buffer.append(", S_SE_SB_OrdersType as ssesborderstype ");
		buffer.append(", S_SE_SB_Renums as ssesbrenums ");
		buffer.append(", S_SE_SB_CustomerID as ssesbcustomerid ");		
		buffer.append(", isnull(S_ME_CI_FCustomerId,'') as ssesbfcustomerid ");
		buffer.append(", S_SE_SB_DoubleZZflag as ssesbdoublezz ");
		buffer.append(", B_DP_DepartmentName as ssesbshopName,B_DP_Phone as ssesbsalestelphone ");	
		buffer.append(", (select cast(sum(S_SE_SD_Integral*S_SE_SD_SalesValue) as numeric(18, 2)) from S_SE_SalesDetail where S_SE_SD_SalesID like '%' + ? ) AS ssesbjfamount ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join SYS_PersonInfo as s on s.ID = S_SE_SB_SalerID ");
		buffer.append("inner join S_ME_CustomerInfo on S_SE_SB_CustomerID = S_ME_CI_CustomerID ");
		buffer.append("inner join B_Departments on S_SE_SB_ShopCode = B_DP_DepartmentID ");
		buffer.append("where 1=1 ");
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))) {
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcustomerid()))) {
			buffer.append("and S_SE_SB_CustomerID = ? ");
			params.add(salesBasicPo.getSsesbcustomerid());
		}

		// 未收费
		if("1".equals(salesBasicPo.getSsesbcheckoutflag())){
			buffer.append("and S_SE_SB_ValueFlag = 1 ");
		}else{
			buffer.append("and S_SE_SB_ValueFlag = 0 ");
			buffer.append("and S_SE_SB_InTransit = '1' ");
		}

		buffer.append(" )t ");

		return (SalesBasicPo) queryForObject(buffer.toString(), params.toArray(),SalesBasicPo.class);
	}
	
	/**
	 * 只有待结款的单子才能调用
	 */	
	public CustomerInfoPo getCustmorInfoNoFinished(CustomerInfoPo customerInfoPo){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1  s1.S_ME_CI_Name as smeciname, ");
		buffer.append("s1.S_ME_CI_MemberId as smecimemberid, ");
		buffer.append("s1.S_ME_CI_CustomerID as smecicustomerid, ");
		buffer.append("s1.S_ME_CI_Phone as smeciphone, ");
		buffer.append("case ");
		buffer.append(" when isnull(s1.S_ME_CI_FCustomerID,'') <> '' then isnull(s2.S_ME_CI_Integral,0) ");
		buffer.append(" else isnull(s1.S_ME_CI_Integral,0) end as smeciintegral ");
		buffer.append("from S_ME_CustomerInfo s1 ");
		buffer.append("left join S_ME_CustomerInfo s2 on s2.S_ME_CI_CustomerID = s1.S_ME_CI_FCustomerID ");
		buffer.append("inner join ( ");		
		buffer.append(" select distinct S_SE_SB_SalesID as S_SE_SB_SalesID,S_SE_SB_CustomerID as S_SE_SB_CustomerID from S_SE_SalesBasic ");
		buffer.append(")t1 on s1.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		
		buffer.append("where 1=1 ");

		if (!"".equals(Utility.getName(customerInfoPo.getFmmsalesid()))) {
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(customerInfoPo.getFmmsalesid());
		}

		if(!"".equals(Utility.getName(customerInfoPo.getSmeciflag()))){
			buffer.append(" and S_ME_CI_Flag = ? ");
			params.add(customerInfoPo.getSmeciflag());
		}
		
		if(customerInfoPo.getSmecishoplist() != null && customerInfoPo.getSmecishoplist().size() > 0){
			
			buffer.append(" and s1.S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = customerInfoPo.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		return (CustomerInfoPo) queryForObject(buffer.toString(), params.toArray(), CustomerInfoPo.class);	
	}
	
	/**
	 * 查看未结款的单子
	 */
	public List<SalesBasicPo> getSalesBasicNoFinished(SalesBasicPo salesBasicPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by ssesbsalesid desc) as rowNum,* from ( ");
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid ");
		buffer.append(", S_SE_SB_PriceSum as ssesbpricesum ");
		buffer.append(", S_SE_SB_SalesValue as ssesbsalesvalue ");
		buffer.append(", S_SE_SB_ArrearsValue as ssesbarrearsvalue ");
		buffer.append(", S_SE_SB_DiscountNum as ssesbdiscountnum ");
		buffer.append(", S_SE_SB_Psalsvalue as ssesbpsalsvalue ");
		buffer.append(", s.personName as ssesbsalerName ");
		buffer.append(", S_SE_SB_CheckoutFlag as ssesbcheckoutflag ");
		buffer.append(", S_SE_SB_OrdersType as ssesborderstype ");
		buffer.append(", S_SE_SB_Renums as ssesbrenums "); 
		buffer.append(", isnull(n.hisbillcount,0) as ssesbnothisflag ");     // 未收费
		buffer.append(", isnull(h.hisbillcount,0) as ssesbhisflag ");        // 已传递，未作废
		buffer.append(", isnull(p.hisbillcount,0) as ssesbhiscancelflag ");  // 已传递，作废     
		buffer.append(", isnull(m.hisbillcount,0) as ssesbhispayflag ");     // 已收费
		
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join SYS_PersonInfo as s on s.ID = S_SE_SB_SalerID ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		
		buffer.append("left join (select S_HC_CC_Billid,count(S_HC_CC_ID) as hisbillcount from S_HC_CC_HISChargeConfirm group by S_HC_CC_Billid )n on S_SE_SB_SalesID = n.S_HC_CC_Billid ");
		buffer.append("left join (select S_HC_CC_Billid,count(S_HC_CC_ID) as hisbillcount from S_HC_CC_HISChargeConfirm where S_HC_CC_Chargestatus <> '5' group by S_HC_CC_Billid )h on S_SE_SB_SalesID = h.S_HC_CC_Billid ");
		buffer.append("left join (select S_HC_CC_Billid,count(S_HC_CC_ID) as hisbillcount from S_HC_CC_HISChargeConfirm where S_HC_CC_Chargestatus = '5' group by S_HC_CC_Billid )p on S_SE_SB_SalesID = p.S_HC_CC_Billid ");
		buffer.append("left join (select S_HC_CC_Billid,count(S_HC_CC_ID) as hisbillcount from S_HC_CC_HISChargeConfirm where S_HC_CC_Flag = '1' and S_HC_CC_Chargetype in ('1','2') group by S_HC_CC_Billid )m on S_SE_SB_SalesID = m.S_HC_CC_Billid ");
		
		buffer.append("where S_SE_SB_ValueFlag = '0' and S_SE_SB_InTransit = '1' ");
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}		

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))) {
			buffer.append("and S_SE_SB_SalesID = ?  ");
			params.add(salesBasicPo.getSsesbsalesid());
		}

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcustomerid()))) {
			buffer.append("and S_SE_SB_CustomerID = ? ");
			params.add(salesBasicPo.getSsesbcustomerid());
		}

		buffer.append(" )t ");

		return queryForObjectList(buffer.toString(), params.toArray(),SalesBasicPo.class);
	}
	
	/**
	 * 根据配镜单号获取当前配镜单的最新在途
	 * @param po
	 */
	public String getSalesBillInTransit(SalesBasicPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select top 1 S_SE_SB_InTransit from ( ");
		buffer.append(" 	select top 1 S_SE_SB_InTransit from S_SE_SalesBasic where S_SE_SB_SalesID = ? ");
		buffer.append(" 	union all ");
		buffer.append(" 	select top 1 S_SE_SB_InTransit from S_SE_SalesBasic_Finished where S_SE_SB_SalesID = ? ");
		buffer.append(" )t ");
		
		params.add(Utility.getName(po.getSsesbsalesid()));
		params.add(Utility.getName(po.getSsesbsalesid()));
		
		return (String) getJdbcTemplate().queryForObject(buffer.toString(),params.toArray(),String.class);
	}
	
	/**
	 * 删除在途库存
	 * @param po
	 */
	public void deleteInTransitStroge(SalesBasicPo po){
	
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from C_SH_InTransitStorageEntry where C_SH_TSE_EntryID in (  ");
		buffer.append(" select S_SE_SD_ID ");
		buffer.append("   from S_SE_SalesDetail ");
		buffer.append("   where S_SE_SD_SalesID=? and S_SE_SD_OutStorageFlag='1' and substring(S_SE_SD_SalesItemID,3,2)<>'ZZ'  ");
		buffer.append(" )  ");
		
		params.add(Utility.getName(po.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void insertSalesLog(List<SalesLogPo> slList) {
		
		List<String> params = new ArrayList<String>();
		StringBuffer  buffer = new StringBuffer();
		
		for (SalesLogPo salesLogPo : slList){
			if(Math.abs(Float.parseFloat(salesLogPo.getSseslprice()))>0){
				buffer.append("INSERT INTO dbo.S_SE_SalesLog ");
				buffer.append("            (S_SE_SL_UUID, ");
				buffer.append("             S_SE_SL_SalesID, ");
				buffer.append("             S_SE_SL_PaymentType, ");
				buffer.append("             S_SE_SL_ConsumptionID,");
				if (!"".equals(Utility.getName(salesLogPo.getSseslintegralprice()))){
					buffer.append("             S_SE_SL_IntegralPrice, ");
				}		
				buffer.append("             S_SE_SL_Price, ");
				buffer.append("             S_SE_SL_DateTime, ");
				buffer.append("             S_SE_SL_Person, ");
				buffer.append("             S_SE_SL_Orderby, ");
				buffer.append("             S_SE_SL_SourceID, ");
				buffer.append("             S_SE_SL_ShopCode, ");
				buffer.append("             S_SE_SL_FactDateTime, ");
				buffer.append("             S_SE_SL_Type) ");
				buffer.append("VALUES      ( ?, ");
				buffer.append("              ?, ");
				buffer.append("              ?, ");
				buffer.append("              ?, ");
				if (!"".equals(Utility.getName(salesLogPo.getSseslintegralprice()))){
					buffer.append("              ?, ");
				}
				buffer.append("              ?, ");
				buffer.append("              dbo.ufn_getDayCheckOut(), ");
				buffer.append("              ?, ");
				buffer.append("              ?, ");
				buffer.append("              ?, ");
				buffer.append("              ?, ");
				buffer.append("              getdate(), ");
				buffer.append("              ? ) ");
				
				params.add(this.uuid.generate());
				params.add(Utility.getName(salesLogPo.getSseslsalesid()));
				params.add(Utility.getName(salesLogPo.getSseslpaymenttype()));
				params.add(Utility.getName(salesLogPo.getSseslconsumptionid()));
				if (!"".equals(Utility.getName(salesLogPo.getSseslintegralprice()))){
					params.add(Utility.getName(salesLogPo.getSseslintegralprice()));
				}
				params.add(Utility.getName(salesLogPo.getSseslprice()));
				params.add(Utility.getName(salesLogPo.getSseslperson()));
				params.add(Utility.getName(salesLogPo.getSseslorderby()));
				params.add(Utility.getName(salesLogPo.getSseslsourceid()));
				params.add(Utility.getName(salesLogPo.getSseslshopcode()));
				params.add(Utility.getName(salesLogPo.getSsesltype()));						
			}	
		}
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());	
	}
	
	/**
	 * 查询结款或发料、退款后需要删除在途库存的商品
	 */
	public List<InTransitStorageEntryPo> getNotInTransitStorageGoods(String salesid){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" select S_SE_SD_ID as cshtseentryid,S_SE_SD_SalesID as cshtsebillid,S_SE_SD_SalesItemID as cshtsegoodsID,(case isnull(S_SE_SD_ItemID,'') when '' then (replace(S_SE_SD_SalesItemID,'.','')+'00000000') else isnull(S_SE_SD_ItemID,'') end) as cshtsegoodsbarcode,S_SE_SD_StockId as cshtseoutstockid,-S_SE_SD_Number as cshtsegoodsNum,'2' as cshtseinoroutStock,'1' as cshtsedepartmenttype ");
		buffer.append("   from S_SE_SalesDetail where S_SE_SD_SalesID=? and S_SE_SD_OutStorageFlag='0' and substring(S_SE_SD_SalesItemID,3,2)<>'ZZ' and substring(S_SE_SD_SalesItemID,1,1) in ('1','2','5','6','7','8','9') ");	
		buffer.append(" union all ");
		buffer.append(" select S_SE_SD_ID as cshtseentryid,S_SE_SD_SalesID as cshtsebillid,S_SE_SD_SalesItemID as cshtsegoodsID,(case isnull(S_SE_SD_ItemID,'') when '' then (replace(S_SE_SD_SalesItemID,'.','')+'00000000') else isnull(S_SE_SD_ItemID,'') end) as cshtsegoodsbarcode,S_SE_SD_StockId as cshtseoutstockid,-S_SE_SD_Number as cshtsegoodsNum,'2' as cshtseinoroutStock,'1' as cshtsedepartmenttype ");
		buffer.append("   from S_SE_SalesDetail left join B_GoodsInfo on S_SE_SD_SalesItemID=B_GI_GoodsID where S_SE_SD_SalesID=? and S_SE_SD_OutStorageFlag='0' and substring(S_SE_SD_SalesItemID,3,2)<>'ZZ' and substring(S_SE_SD_SalesItemID,1,1) in ('3','4') and B_GI_isCustomize = '0' ");	
		
		params.add(salesid);
		params.add(salesid);
		
		return queryForObjectList(buffer.toString(),params.toArray(), InTransitStorageEntryPo.class);
	}
	
	/**
	 * 更新商品出入库标志
	 * @param salesid
	 * @param inOrout
	 * @param flag
	 */
	public void updateStrogeChangeFlag(StrogeLogTempPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update S_SE_SalesDetail set S_SE_SD_InStorageFlag='1'  			where S_SE_SD_SalesID=? and S_SE_SD_ItemID=? and substring(S_SE_SD_SalesItemID,3,2)<> 'zz' ");
		buffer.append("update S_SE_SalesDetail_Finished set S_SE_SD_InStorageFlag='1'  	where S_SE_SD_SalesID=? and S_SE_SD_ItemID=? and substring(S_SE_SD_SalesItemID,3,2)<> 'zz' ");
		
		params.add(po.getCshslchangeid());
		params.add(po.getCshslgoodsbarcode());
		params.add(po.getCshslchangeid());
		params.add(po.getCshslgoodsbarcode());
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
 
	public void deleteSalesForHISBill(String salesID) {
	
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("delete from S_HC_CC_HISChargeConfirm where S_HC_CC_ID  = ?  ");
		params.add(Utility.getName(salesID));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}
	
}
