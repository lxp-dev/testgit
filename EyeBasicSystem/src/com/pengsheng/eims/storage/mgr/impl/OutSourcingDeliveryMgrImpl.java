package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.dao.OutSourcingDeliveryDao;
import com.pengsheng.eims.storage.mgr.OutSourcingDeliveryMgr;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;
import com.pengsheng.eims.util.tools.Utility;

public class OutSourcingDeliveryMgrImpl implements OutSourcingDeliveryMgr {

	private OutSourcingDeliveryDao outSourcingDeliveryDao;
	private LogisticsLogDao logisticsLogDao;

	/**
	 * 获取未发料的框镜委外收货单列表
	 */
	public List<SalesBasicPo> getNotMaterialsSalesBillList(ConsignProcessReceiptPo crpo){
		return outSourcingDeliveryDao.getNotMaterialsSalesBillList(crpo);
	}
	
	/**
	 * 委外配送修改
	 */
	public void updateNotMaterialsSalesBill(AllocationPo apo,ConsignProcessReceiptPo crpo,LogisticsLogPo logPo){
		
		String[] billArray = Utility.getName(crpo.getCstcprsalesid()).split(",");
		for (int i = 0; i < billArray.length; i++){
			if (!Utility.getName(billArray[i]).equals("")){
				ConsignProcessReceiptPo po = new ConsignProcessReceiptPo();
				po.setCstcprsalesid(Utility.getName(billArray[i]));
				po.setCstcpralloctionbillid(apo.getCshaabillid());
				
				outSourcingDeliveryDao.updateNotMaterialsSalesBill(po);   // 新增委外配送时调拨单与配镜单对照关系
			}
		}
		
		crpo.setCstcprfaliaostockid(apo.getCshaaoutstockid());

		outSourcingDeliveryDao.insertConsignProcessReceiptToAlloction(apo);
		outSourcingDeliveryDao.insertConsignProcessReceiptToAlloctionEntry(crpo);
        
		logisticsLogDao.insertLog(logPo);
	}

	public OutSourcingDeliveryDao getOutSourcingDeliveryDao() {
		return outSourcingDeliveryDao;
	}

	public void setOutSourcingDeliveryDao(
			OutSourcingDeliveryDao outSourcingDeliveryDao) {
		this.outSourcingDeliveryDao = outSourcingDeliveryDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
}
