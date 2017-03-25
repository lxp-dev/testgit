package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;

import com.pengsheng.eims.storage.dao.ConsignProcessDeliverDao;
import com.pengsheng.eims.storage.mgr.ConsignProcessDeliverMgr;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.DeliverEntryPo;
import com.pengsheng.eims.storage.persistence.DeliverPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
/**
 * 委外送货mgr实现类
 */
public class ConsignProcessDeliverMgrImpl implements ConsignProcessDeliverMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
	private ConsignProcessDeliverDao consignProcessDeliverDao;
	
	public ConsignProcessDeliverDao getConsignProcessDeliverDao() {
		return consignProcessDeliverDao;
	}
	public void setConsignProcessDeliverDao(
			ConsignProcessDeliverDao consignProcessDeliverDao) {
		this.consignProcessDeliverDao = consignProcessDeliverDao;
	}

	/**
	 * 获取委外送货的数量
	 * @param po DeliverPo
	 * @return int 数量
	 */	
	public int getConsignProcessDeliverCount(DeliverPo deliverPo) {
		
		return consignProcessDeliverDao.getConsignProcessDeliverCount(deliverPo);
	}
	/**
	 * 获取委外送货的list
	 * @param po DeliverPo
	 * @param start
	 * @param size 
	 * @return list DeliverPo的list
	 */	
	public List<DeliverPo> getConsignProcessDeliverList(DeliverPo deliverPo,
			int start, int size) {
		
		return consignProcessDeliverDao.getConsignProcessDeliverList(deliverPo, start, size);
	}
	/**
	 * 新增委外送货主表
	 * @param po InventoryPo
	 */	
    public void insertConsignProcessDeliver(DeliverPo deliverPo,
    		List<DeliverEntryPo> deliverEntryPoList,LogisticsLogPo logPo) {
    	   	
    	consignProcessDeliverDao.insertConsignProcessDeliver(deliverPo);//新增委外送货主表
    	
    	for(DeliverEntryPo deliverEntryPo:deliverEntryPoList){   		
    		consignProcessDeliverDao.insertConsignProcessDeliverEntry(deliverEntryPo);//新增委外送货从表
    	}
    	logisticsLogDao.insertLog(logPo); //添加日志
    }
    
	/**
	 * 获取委外送货的主表
	 * @param deliverPo DeliverPo
	 * @return DeliverPo
	 */	
    public DeliverPo getConsignProcessDeliver(DeliverPo deliverPo) {
    	
    	return consignProcessDeliverDao.getConsignProcessDeliver(deliverPo);
    }
    
	/**
	 * 获取委外送货的从表
	 * @param deliverPo DeliverPo
	 * @return list DeliverEntryPo的list
	 */	
    public List<ConsignProcessOrderDetailsPo> getConsignProcessDeliverEntryList(
    		DeliverPo deliverPo) {
    	
    	return consignProcessDeliverDao.getConsignProcessDeliverEntryList(deliverPo);
    }
    
	/**
	 * 修改委外送货表
	 * @param deliverPo DeliverPo
	 * @param deliverEntryPoList List<DeliverEntryPo>
	 */	
    public void updateConsignProcessDeliver(DeliverPo deliverPo,
    		List<DeliverEntryPo> deliverEntryPoList,LogisticsLogPo logPo) {
    	
    	consignProcessDeliverDao.updateConsignProcessDeliver(deliverPo);//修改委外送货主表
    	
    	consignProcessDeliverDao.deleteConsignProcessDeliverEntry(deliverPo);//删除委外送货从表
    	
    	for(DeliverEntryPo deliverEntryPo:deliverEntryPoList){   		
    		consignProcessDeliverDao.insertConsignProcessDeliverEntry(deliverEntryPo);//新增委外送货从表
    	}
    	logisticsLogDao.insertLog(logPo); //添加日志
    }
    
	/**
	 * 删除委外送货表
	 * @param deliverPo DeliverPo
	 */		
    public void deleteConsignProcessDeliver(DeliverPo deliverPo,LogisticsLogPo logPo) {
    	
    	consignProcessDeliverDao.deleteConsignProcessDeliver(deliverPo);//删除委外送货主表
    	consignProcessDeliverDao.deleteConsignProcessDeliverEntry(deliverPo);//删除委外送货从表
    	logisticsLogDao.insertLog(logPo); //添加日志
    }
}
