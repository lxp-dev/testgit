package com.pengsheng.eims.storage.mgr.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.dao.OveragelossesDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.mgr.OveragelossesMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.storage.persistence.VerificationPo;
import com.pengsheng.eims.util.tools.Utility;

public class OveragelossesMgrImpl implements OveragelossesMgr {
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

		
	private OveragelossesDao overagelossesDao;

	private StrogeChangeDao strogeChangeDao;

	public OveragelossesDao getOveragelossesDao() {
		return overagelossesDao;
	}

	public void setOveragelossesDao(OveragelossesDao overagelossesDao) {
		this.overagelossesDao = overagelossesDao;
	}

	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}

	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
	}

	public int getOveragelossesCount(InventoryPo po) {
		return overagelossesDao.getOveragelossesCount(po);
	}

	public List<InventoryPo> getOveragelossesList(InventoryPo po, int start,
			int size) {
		return overagelossesDao.getOveragelossesList(po, start, size);
	}

	public InventoryPo getOveragelosses(InventoryPo po) {
		return overagelossesDao.getOveragelosses(po);
	}
	
	/**
	 * 新增盘盈盘亏单
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void insertOveragelosses(InventoryPo po,List<InventoryEntryPo> list,LogisticsLogPo logPo) {

		overagelossesDao.insertOveragelosses(po);// 单据主表

		Iterator<InventoryEntryPo> it = list.iterator();
		while (it.hasNext()) {
			InventoryEntryPo entryPo = it.next();
			if ("5".equals(Utility.getName(po.getCstibilltypeid()))) {
				entryPo.setCstieinstockid(po.getCstiinstockid());
				entryPo.setCstieoutstockid("");
		    }else if("6".equals(Utility.getName(po.getCstibilltypeid()))){
				entryPo.setCstieinstockid("");
				entryPo.setCstieoutstockid(po.getCstioutstockid());
			}
			// 收入仓位
			overagelossesDao.insertOveragelossesEntry(entryPo);// 单据明细表
			
			if ("1".equals(Utility.getName(po.getCstiauditstate()))) {
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiepcbarcode());
				if("5".equals(Utility.getName(po.getCstibilltypeid())))
				{
					changePo.setCshscstockid(entryPo.getCstieinstockid());
					changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity());
				}else if("6".equals(Utility.getName(po.getCstibilltypeid())))
				{
					changePo.setCshscstockid(entryPo.getCstieoutstockid());
					changePo.setCshscgoodsquantity("-" + entryPo.getCstiegoodsquantity());
				}
				
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChange(changePo);// 商品库存当月库存变更表
			}

			if ("1".equals(Utility.getName(po.getCstiauditstate()))) {
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiepcbarcode());
				if("5".equals(Utility.getName(po.getCstibilltypeid())))
				{
					changePo.setCshscstockid(entryPo.getCstieinstockid());
					changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity());
				}else if("6".equals(Utility.getName(po.getCstibilltypeid())))
				{
					changePo.setCshscstockid(entryPo.getCstieoutstockid());
					changePo.setCshscgoodsquantity("-" + entryPo.getCstiegoodsquantity());
				}
			
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				
				strogeChangeDao.insertStrogeChangeLog(changePo, entryPo
						.getCstiepcbarcode());// 商品库存当月库存变更表
				strogeChangeDao.insertStrogeChangeLogTemp(changePo, entryPo
						.getCstiepcbarcode());// 商品库存当月库存变更表
			}
		}
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public void deleteOveragelosses(InventoryPo po,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		overagelossesDao.deleteOveragelosses(po);
		overagelossesDao.deleteOveragelossesEntry(po);
		
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))){
			if ("5".equals(po.getCstibilltypeid()))
				overagelossesDao.updateCheckStorage(po.getCstisourcebillid(), "0");
			else if ("6".equals(po.getCstibilltypeid())) {
				overagelossesDao.updateCheckStorage(po.getCstisourcebillid(), "1");
			}
		}
	}

	public int getOveragelossesEntryCount(InventoryPo inventoryPo) {
		// TODO Auto-generated method stub
		return overagelossesDao.getOveragelossesEntryCount(inventoryPo);
	}
	
	public int getOveragelossesEntryFactCount(InventoryPo inventoryPo) {
		// TODO Auto-generated method stub
		return overagelossesDao.getOveragelossesEntryFactCount(inventoryPo);
	}

	public List<InventoryEntryPo> getOveragelossesEntryList(InventoryPo po,
			int start, int size) {
		// TODO Auto-generated method stub
		return overagelossesDao.getOveragelossesEntryList(po, start, size);
	}
	
	public List<InventoryEntryPo> getOveragelossesEntryFactList(InventoryPo po,int start, int size) {
		// TODO Auto-generated method stub
		return overagelossesDao.getOveragelossesEntryFactList(po, start, size);
	}

	public void auditOveragelosses(InventoryPo inventoryPo,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志

		overagelossesDao.updateOveragelosses(inventoryPo);

		List<InventoryEntryPo> inventoryEntrys = new ArrayList<InventoryEntryPo>();

		inventoryEntrys = overagelossesDao.getOveragelossesEntrys(inventoryPo);

		for (InventoryEntryPo inventoryEntryPo : inventoryEntrys) {
			StrogeChangePo changePo = new StrogeChangePo();
			changePo.setCshscgoodsid(inventoryEntryPo.getCstiegoodsid());
			changePo.setCshscgoodsbarcode(inventoryEntryPo.getCstiebarcode());

			if ("5".equals(inventoryPo.getCstibilltypeid())) {// 盘盈
				changePo.setCshscstockid(inventoryEntryPo.getCstieinstockid());
				changePo.setCshscgoodsquantity(inventoryEntryPo
						.getCstiegoodsquantity());
			} else if ("6".equals(inventoryPo.getCstibilltypeid())) {// 盘亏
				changePo.setCshscstockid(inventoryEntryPo.getCstieoutstockid());
				changePo.setCshscgoodsquantity("-"
						+ inventoryEntryPo.getCstiegoodsquantity());
			}

			changePo.setCshsccostprice(inventoryEntryPo.getCstiecostprice());
			changePo.setCshscnottaxrate(inventoryEntryPo.getCstienottaxrate());
			changePo.setCshscchangeid(inventoryEntryPo.getCstiebillid());

			strogeChangeDao.insertStrogeChange(changePo);// 商品库存当月库存变更表

			strogeChangeDao.insertStrogeChangeLog(changePo, inventoryEntryPo
					.getCstiebarcode());// 商品库存日志表
			strogeChangeDao.insertStrogeChangeLogTemp(changePo, inventoryEntryPo
					.getCstiebarcode());// 商品库存日志表
		}

	}

}
