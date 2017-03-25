package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import com.pengsheng.eims.basic.dao.SupplierDao;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.dao.ConsignProcessOrderDao;
import com.pengsheng.eims.storage.dao.ProcurementOrdersDao;
import com.pengsheng.eims.storage.mgr.ConsignProcessOrderMgr;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderPo;
import com.pengsheng.eims.basic.persistence.StatusModulePo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class ConsignProcessOrderMgrImpl implements ConsignProcessOrderMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private ConsignProcessOrderDao consignProcessOrderDao;
	private ProcurementOrdersDao procurementOrdersDao;


	public ProcurementOrdersDao getProcurementOrdersDao() {
		return procurementOrdersDao;
	}

	public void setProcurementOrdersDao(
			ProcurementOrdersDao procurementOrdersDao) {
		this.procurementOrdersDao = procurementOrdersDao;
	}

	private SupplierDao supplierDao;

	public ConsignProcessOrderDao getConsignProcessOrderDao() {
		return consignProcessOrderDao;
	}

	public void setConsignProcessOrderDao(
			ConsignProcessOrderDao consignProcessOrderDao) {
		this.consignProcessOrderDao = consignProcessOrderDao;
	}

	public SupplierDao getSupplierDao() {
		return supplierDao;
	}

	public void setSupplierDao(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {
		// TODO Auto-generated method stub
		return consignProcessOrderDao.getGoodsCategorys();
	}
	public ConsignProcessOrderPo searchSaleReam(String id){
		return consignProcessOrderDao.searchSaleReam(id);
	}
	public int getConsignProcessOrderCount(
			ConsignProcessOrderPo consignProcessOrderPo) {
		// TODO Auto-generated method stub
		return consignProcessOrderDao
				.getConsignProcessOrderCount(consignProcessOrderPo);
	}

	public List<ConsignProcessOrderPo> getConsignProcessOrderList(
			ConsignProcessOrderPo consignProcessOrderPo, int start, int size) {
		// TODO Auto-generated method stub
		return consignProcessOrderDao.getConsignProcessOrderList(
				consignProcessOrderPo, start, size);
	}

	public ConsignProcessOrderPo getConsignProcessOrder(
			ConsignProcessOrderPo consignProcessOrderPo) {
		// TODO Auto-generated method stub
		return consignProcessOrderDao
				.getConsignProcessOrder(consignProcessOrderPo);
	}
	
	public ConsignProcessOrderPo getConsignProcessOrderSeles(
			ConsignProcessOrderPo consignProcessOrderPo) {
		// TODO Auto-generated method stub
		return consignProcessOrderDao.getConsignProcessOrderSeles(consignProcessOrderPo);
	}

	public List<ConsignProcessOrderDetailsPo> getConsignProcessOrderDetailsList(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo) {
		// TODO Auto-generated method stub
		return consignProcessOrderDao
				.getConsignProcessOrderDetailsList(consignProcessOrderDetailsPo);
	}
	
	public List<ConsignProcessOrderDetailsPo> getConsignProcessOrderSelesDetailsList(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo) {
		return consignProcessOrderDao.getConsignProcessOrderSelesDetailsList(consignProcessOrderDetailsPo);
	}

	public void insertConsignProcessOrder(
			ConsignProcessOrderPo consignProcessOrderPo,
			List<ConsignProcessOrderDetailsPo> consignProcessOrderDetails,
			SalesBasicPo salesBasicPo, InTransitPo tmpInTransitPo,LogisticsLogPo logPo) {
		// TODO Auto-generated method stub
		consignProcessOrderDao.insertConsignProcessOrder(consignProcessOrderPo);

		if (consignProcessOrderDetails != null) {
			for (ConsignProcessOrderDetailsPo po : consignProcessOrderDetails) {
				InTransitPo inTransitPo = new InTransitPo();
				BeanUtils.copyProperties(tmpInTransitPo, inTransitPo);

				// 更新在途
				if ("N".equals(po.getCstcpodordertype())&& "1".equals(consignProcessOrderPo.getCstcpoauditstate())) {

					if (!po.getCstcpodglassesbillid().equals(//去重
							salesBasicPo.getSsesbsalesid())) {

						salesBasicPo.setSsesbsalesid(po
								.getCstcpodglassesbillid());
						inTransitPo.setSseitsalesid(salesBasicPo
								.getSsesbsalesid());

						consignProcessOrderDao.updateMaterialsInTransit(salesBasicPo);
						consignProcessOrderDao.insertIntrnsitInfo(inTransitPo);
					}
				}else if("W".equals(po.getCstcpodordertype())&& "1".equals(consignProcessOrderPo.getCstcpoauditstate()) && ("W".equals(po.getCstcpodglassesbillid().substring(0, 1))||"R".equals(po.getCstcpodglassesbillid().substring(0, 1))||"B".equals(po.getCstcpodglassesbillid().substring(0, 1)))){//重订单在途处理

					if (!po.getCstcpodglassesbillid().equals(//去重
							salesBasicPo.getSsesbsalesid())) {

						salesBasicPo.setSsesbsalesid(po
								.getCstcpodglassesbillid());
						inTransitPo.setSseitsalesid(po
								.getCstcpodglassesbillid());//外部配镜单号
						inTransitPo.setSseitysalesid(po.getCstcpodsalesbillid());//原单号
						inTransitPo.setSseitstate("1");
						consignProcessOrderDao.insertIntrnsitInfo(inTransitPo);
					}
				}

				consignProcessOrderDao.insertConsignProcessOrderDetails(po);
			}
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public void updateConsignProcessOrder(
			ConsignProcessOrderPo consignProcessOrderPo,
			List<ConsignProcessOrderDetailsPo> consignProcessOrderDetails,
			SalesBasicPo salesBasicPo, InTransitPo inTransitPo,LogisticsLogPo logPo) {
		// TODO Auto-generated method stub
		/**
		 * 删除订单明细
		 */
		consignProcessOrderDao
				.delConsignProcessOrderDetails(consignProcessOrderPo
						.getCstcpoorderbillid());

		/**
		 * 更新订单主表
		 */
		consignProcessOrderDao.updateConsignProcessOrder(consignProcessOrderPo);

		/**
		 * 更新订单明细
		 */
		if (consignProcessOrderDetails != null) {
			for (ConsignProcessOrderDetailsPo po : consignProcessOrderDetails) {

				// 更新在途
				if ("N".equals(po.getCstcpodordertype())
						&& "1".equals(consignProcessOrderPo
								.getCstcpoauditstate())) {

					if (!po.getCstcpodglassesbillid().equals(
							salesBasicPo.getSsesbsalesid())) {

						salesBasicPo.setSsesbsalesid(po
								.getCstcpodglassesbillid());
						inTransitPo.setSseitsalesid(salesBasicPo
								.getSsesbsalesid());

						consignProcessOrderDao
								.updateMaterialsInTransit(salesBasicPo);
						consignProcessOrderDao.insertIntrnsitInfo(inTransitPo);
					}
				}else if("W".equals(po.getCstcpodordertype())
						&& "1".equals(consignProcessOrderPo
								.getCstcpoauditstate()) && ("W".equals(po.getCstcpodglassesbillid().substring(0, 1))||"R".equals(po.getCstcpodglassesbillid().substring(0, 1))||"B".equals(po.getCstcpodglassesbillid().substring(0, 1)))){//重订单在途处理

					if (!po.getCstcpodglassesbillid().equals(//去重
							salesBasicPo.getSsesbsalesid())) {

						salesBasicPo.setSsesbsalesid(po
								.getCstcpodglassesbillid());
						inTransitPo.setSseitsalesid(po
								.getCstcpodglassesbillid());//外部配镜单号
						inTransitPo.setSseitysalesid(po.getCstcpodsalesbillid());//原单号
						inTransitPo.setSseitstate("1");
						consignProcessOrderDao.insertIntrnsitInfo(inTransitPo);
					}
				}


				consignProcessOrderDao.insertConsignProcessOrderDetails(po);
			}
		}	
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public void delConsignProcessOrder(String id,LogisticsLogPo logPo) {
		consignProcessOrderDao.delConsignProcessOrder(id);
		consignProcessOrderDao.delConsignProcessOrderDetails(id);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

}
