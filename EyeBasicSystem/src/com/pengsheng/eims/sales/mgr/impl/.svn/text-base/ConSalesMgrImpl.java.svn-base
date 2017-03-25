/**
 * 
 */
package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GiftsPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.ConSalesDao;
import com.pengsheng.eims.sales.mgr.ConSalesMgr;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;

/**
 * @author Liuqian
 * 
 */
public class ConSalesMgrImpl implements ConSalesMgr {
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	
	private ConSalesDao conSalesDao;
 

	public ConSalesDao getConSalesDao() {
		return conSalesDao;
	}

	public void setConSalesDao(ConSalesDao conSalesDao) {
		this.conSalesDao = conSalesDao;
	}

	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po) {
		// TODO Auto-generated method stub
		return conSalesDao.getCustomerInfo(po);
	}

	public List<InspectionPo> getInspectionPos(String customerID) {
		// TODO Auto-generated method stub
		return conSalesDao.getInspectionPos(customerID);
	}

	
	public void insertSalesBasic(SalesBasicPo salesBasicPo,SalesDetailPo salesDetailPo,GiftsPo giftsPo,InTransitPo inTransitPo,LogisticsLogPo logPo ) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		this.conSalesDao.insertSalesBasic(salesBasicPo);
		/*
		 * 商品插入销售明细
		 */
		for(int i=1;i<salesDetailPo.getSsesdsalesitemids().length;i++){
			SalesDetailPo temp= new SalesDetailPo();
			temp.setSsesdsalesid(salesDetailPo.getSsesdsalesid());
			temp.setSsesdsalesitemid(salesDetailPo.getSsesdsalesitemids()[i]);
			temp.setSsesditemid(salesDetailPo.getSsesditemids()[i]);
			temp.setSsesdstockid(salesDetailPo.getSsesdstockids()[i]);
			temp.setSsesdsalesitemname(salesDetailPo.getSsesdsalesitemnames()[i]);
			temp.setSsesdsprice(salesDetailPo.getSsesdsprices()[i]);
			temp.setSsesdnumber(salesDetailPo.getSsesdnumbers()[i]);
			temp.setSsesdunitprice(salesDetailPo.getSsesdunitprices()[i]);
//			temp.setSsesdpricesum(salesDetailPo.getSsesdpricesums()[i]);
			temp.setSsesdpricesum(salesDetailPo.getSsesdpricesums()[i]);
			temp.setSsesdcostsprive(salesDetailPo.getSsesdcostsprives()[i]);
			temp.setSsesdsalesvalue(salesDetailPo.getSsesdsalesvalues()[i]);
			temp.setSsesddiscountrate(salesDetailPo.getSsesddiscountrates()[i]);
			temp.setSsesddiscountnum(salesDetailPo.getSsesddiscountnums()[i]);
			temp.setSsesdgooddescribe(salesDetailPo.getSsesdgooddescribes()[i]);
			temp.setSsesdglassflag(salesDetailPo.getSsesdglassflags()[i]);
			temp.setSsesdcommoditiesflag(salesDetailPo.getSsesdcommoditiesflags()[i]);
			temp.setSsesdrenum(salesDetailPo.getSsesdrenums()[i]);
			temp.setSsesdlargessflag("0");
			temp.setSsesdysvalue(salesDetailPo.getSsesdpricesums()[i]);
			this.conSalesDao.insertSalesDetail(temp);
		}
		this.conSalesDao.insertIntrnsitInfo(inTransitPo);
	}
	
	
	public void insertSalesDetail(SalesDetailPo salesDetailPo,GiftsPo giftsPo) {
		
		/*
		 * 商品插入销售明细
		 */
		for(int i=1;i<salesDetailPo.getSsesdsalesitemids().length;i++){
			SalesDetailPo temp= new SalesDetailPo();
			temp.setSsesdsalesid(salesDetailPo.getSsesdsalesid());
			temp.setSsesdsalesitemid(salesDetailPo.getSsesdsalesitemids()[i]);
			temp.setSsesditemid(salesDetailPo.getSsesditemids()[i]);
			temp.setSsesdstockid(salesDetailPo.getSsesdstockids()[i]);
			temp.setSsesdsalesitemname(salesDetailPo.getSsesdsalesitemnames()[i]);
			temp.setSsesdsprice(salesDetailPo.getSsesdsprices()[i]);
			temp.setSsesdnumber(salesDetailPo.getSsesdnumbers()[i]);
			temp.setSsesdunitprice(salesDetailPo.getSsesdunitprices()[i]);
//			temp.setSsesdpricesum(salesDetailPo.getSsesdpricesums()[i]);
			temp.setSsesdpricesum(salesDetailPo.getSsesdpricesums()[i]);
			temp.setSsesdcostsprive(salesDetailPo.getSsesdcostsprives()[i]);
			temp.setSsesdsalesvalue(salesDetailPo.getSsesdsalesvalues()[i]);
			temp.setSsesddiscountrate(salesDetailPo.getSsesddiscountrates()[i]);
			temp.setSsesddiscountnum(salesDetailPo.getSsesddiscountnums()[i]);
			temp.setSsesdgooddescribe(salesDetailPo.getSsesdgooddescribes()[i]);
			temp.setSsesdglassflag(salesDetailPo.getSsesdglassflags()[i]);
			temp.setSsesdcommoditiesflag(salesDetailPo.getSsesdcommoditiesflags()[i]);
			temp.setSsesdlargessflag("0");
			temp.setSsesdysvalue(salesDetailPo.getSsesdpricesums()[i]);
			this.conSalesDao.insertSalesDetail(temp);
		}
		
		
		
		// TODO Auto-generated method stub
		
	}
	public void insertIntrnsitInfo(InTransitPo inTransitPo) {
		this.conSalesDao.insertIntrnsitInfo(inTransitPo);
	}

}
