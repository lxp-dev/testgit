/**
 * 
 */
package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GiftsPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.dao.WindowPersonDiscountDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.AccSalesDao;
import com.pengsheng.eims.sales.dao.ConSalesDao;
import com.pengsheng.eims.sales.mgr.AccSalesMgr;
import com.pengsheng.eims.sales.mgr.ConSalesMgr;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;

/**
 * @author Liuqian
 * 
 */
public class AccSalesMgrImpl implements AccSalesMgr {
	private LogisticsLogDao logisticsLogDao;
	private WindowPersonDiscountDao windowPersonDiscountDao;
	private WarehouseMgr warehouseMgr;
	
	
	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public WindowPersonDiscountDao getWindowPersonDiscountDao() {
		return windowPersonDiscountDao;
	}

	public void setWindowPersonDiscountDao(
			WindowPersonDiscountDao windowPersonDiscountDao) {
		this.windowPersonDiscountDao = windowPersonDiscountDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	
	private AccSalesDao accSalesDao;


	public AccSalesDao getAccSalesDao() {
		return accSalesDao;
	}

	public void setAccSalesDao(AccSalesDao accSalesDao) {
		this.accSalesDao = accSalesDao;
	}

	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po) {
		return accSalesDao.getCustomerInfo(po);
	}


	public void insertSalesBasic(SalesBasicPo salesBasicPo,SalesDetailPo salesDetailPo,GiftsPo giftsPo,InTransitPo inTransitPo,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		this.accSalesDao.insertSalesBasic(salesBasicPo);
		
		
		if("2".equals(salesBasicPo.getSsesbdiscounttype())){
			windowPersonDiscountDao.updateSpecialDiscountNumber(salesBasicPo.getSsesbdiscountperson());
		}
		/*
		 * 商品插入销售明细
		 */
		String nowdepartmentid = salesBasicPo.getSsesbshopcode();
		DepartmentsPo outdepartment = new DepartmentsPo();
		WarehousePo outwarehouse = new WarehousePo();
		
		for(int i=1;i<salesDetailPo.getSsesdsalesitemids().length;i++){
			SalesDetailPo temp= new SalesDetailPo();
			temp.setSsesdsalesid(salesDetailPo.getSsesdsalesid());
			temp.setSsesdsalesitemid(salesDetailPo.getSsesdsalesitemids()[i]);
			outwarehouse.setBwhid(salesDetailPo.getSsesdstockids()[i]);
			outdepartment = warehouseMgr.getDepartments(outwarehouse);
			
			String outdepartmentid = outdepartment.getBdpdepartmentid();
			
			if(nowdepartmentid.trim().equals(outdepartmentid.trim())){
				temp.setSsesditemid(salesDetailPo.getSsesditemids()[i]);
			}else{
				temp.setSsesditemid("");
			}
			
			
			temp.setSsesdstockid(salesDetailPo.getSsesdstockids()[i]);
			temp.setSsesdsalesitemname(salesDetailPo.getSsesdsalesitemnames()[i]);
			temp.setSsesdsprice(salesDetailPo.getSsesdsprices()[i]);
			temp.setSsesdnumber(salesDetailPo.getSsesdnumbers()[i]);
			temp.setSsesdunitprice(salesDetailPo.getSsesdunitprices()[i]);
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
			this.accSalesDao.insertSalesDetail(temp);
		}
		
		this.accSalesDao.insertIntrnsitInfo(inTransitPo);
	}
	


}
