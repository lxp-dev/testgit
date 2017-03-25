package com.pengsheng.eims.storage.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.dao.OtherOutDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.mgr.OtherOutMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.util.tools.Utility;

public class OtherOutMgrImpl implements OtherOutMgr {
	
	private OtherOutDao otherOutDao;
	private LogisticsLogDao logisticsLogDao;	
	private StrogeChangeDao strogeChangeDao;

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}

	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
	}

	public OtherOutDao getOtherOutDao() {
		return otherOutDao;
	}

	public void setOtherOutDao(OtherOutDao otherOutDao) {
		this.otherOutDao = otherOutDao;
	}

	public int getOtherOutCount(InventoryPo po) {
		
		return otherOutDao.getOtherOutCount(po);
	}
	public List<InventoryPo> getOtherOutList(InventoryPo po, int start, int size) {
		
		return otherOutDao.getOtherOutList(po, start, size);
	}	
	public List<InventoryEntryPo> getOtherOutEntryList(InventoryPo po) {
		
		return otherOutDao.getOtherOutEntryList(po);
	}
	
	/**
	 * 新增其他出库插入业务及业务明细表中
	 */
	public void insertOtherOut(InventoryPo po, List<InventoryEntryPo> list,LogisticsLogPo logPo) {
		
		otherOutDao.insertOtherOut(po);// 单据主表

		Iterator<InventoryEntryPo> it = list.iterator();
		while (it.hasNext()) {
			InventoryEntryPo entryPo = it.next();
			entryPo.setCstieoutstockid(po.getCstioutstockid());// 发出仓位
			otherOutDao.insertOtherOutEntry(entryPo);// 单据明细表
			if("1".equals(Utility.getName(po.getCstiauditstate()))){
				StrogeChangePo changePo=new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiebarcode());
				changePo.setCshscstockid(entryPo.getCstieoutstockid());
				changePo.setCshscgoodsquantity("-"+entryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChange(changePo);//商品库存当月库存变更表
			}
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
		
	}
	/**
	 * 更新业务及业务明细表中的数据
	 */
	public void updateOtherOut(InventoryPo po, List<InventoryEntryPo> list,LogisticsLogPo logPo) {
		
		otherOutDao.updateOtherOut(po);//单据主表
		otherOutDao.deleteOtherOutEntry(po);//删除单据明细表

		Iterator<InventoryEntryPo> it=list.iterator();
		while(it.hasNext()){
			InventoryEntryPo entryPo=it.next();
			entryPo.setCstieoutstockid(po.getCstioutstockid());//收入仓位			
			otherOutDao.insertOtherOutEntry(entryPo);//单据明细表
			if("1".equals(Utility.getName(po.getCstiauditstate()))){
				StrogeChangePo changePo=new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiebarcode());
				changePo.setCshscstockid(entryPo.getCstieoutstockid());
				changePo.setCshscgoodsquantity("-"+entryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChange(changePo);//商品库存当月库存变更表
			}
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	/**
	 * 删除业务表中数据
	 */
	public void deleteOtherOut(InventoryPo po,LogisticsLogPo logPo) {
		
		otherOutDao.deleteOtherOut(po);
		otherOutDao.deleteOtherOutEntry(po);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	/**
	 * 得到业务表中数据的个数
	 */
	public InventoryPo getOtherOut(InventoryPo po) {
		
		return otherOutDao.getOtherOut(po);
	}

}
