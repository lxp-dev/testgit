package com.pengsheng.eims.storage.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.sales.dao.GuitarManagementDao;
import com.pengsheng.eims.sales.persistence.InTransitStorageEntryPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageTypePo;
import com.pengsheng.eims.storage.dao.OtherDatabaseManagementDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.mgr.OtherDatabaseManagementMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.storage.persistence.VerificationPo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class OtherDatabaseManagementMgrImpl implements
		OtherDatabaseManagementMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	private GuitarManagementDao guitarManagementDao;
	private InTransitDetailsDao inTransitDetailsDao = null;
	private OtherDatabaseManagementDao otherDatabaseManagementDao;
	private StrogeChangeDao strogeChangeDao;
	
	public GuitarManagementDao getGuitarManagementDao() {
		return guitarManagementDao;
	}
	public void setGuitarManagementDao(GuitarManagementDao guitarManagementDao) {
		this.guitarManagementDao = guitarManagementDao;
	}
	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}
	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	public OtherDatabaseManagementDao getOtherDatabaseManagementDao() {
		return otherDatabaseManagementDao;
	}
	public void setOtherDatabaseManagementDao(
			OtherDatabaseManagementDao otherDatabaseManagementDao) {
		this.otherDatabaseManagementDao = otherDatabaseManagementDao;
	}	
	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}
	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
	}

	/**
	 * 删除其它出库
	 */
	public void deleteOtherDatabaseManagement(InventoryPo po,LogisticsLogPo logPo) {
		otherDatabaseManagementDao.deleteOtherDatabaseManagementEntry(po);//删除单据明细表
		otherDatabaseManagementDao.deleteOtherDatabaseManagement(po);//单据主表
		otherDatabaseManagementDao.deleteVerification(po);//删除核销表
		
		InTransitStorageEntryPo outipo = new InTransitStorageEntryPo();		
		outipo.setCshtsebillid(Utility.getName(po.getCstibillid()));			
		guitarManagementDao.deleteInTransitStroge(outipo);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 获取其它出库的po
	 */
	public InventoryPo getOtherDatabaseManagement(InventoryPo po) {
		
		return otherDatabaseManagementDao.getOtherDatabaseManagement(po);
	}

	/**
	 * 获取其它出库的数量
	 */
	public int getOtherDatabaseManagementCount(InventoryPo po) {
		
		return otherDatabaseManagementDao.getOtherDatabaseManagementCount(po);
	}

	/**
	 *  获取其它出库明细表的list
	 */
	public List<InventoryEntryPo> getOtherDatabaseManagementEntryList(
			InventoryPo po) {
		
		return otherDatabaseManagementDao.getOtherDatabaseManagementEntryList(po);
	}

	/**
	 * 获取其它出库的list
	 */
	public List<InventoryPo> getOtherDatabaseManagementList(InventoryPo po,
			int start, int size) {
		
		return otherDatabaseManagementDao.getOtherDatabaseManagementList(po, start, size);
	}

//	/**
//	 *  新增其它出库主表
//	 */
//	public void insertOtherDatabaseManagement(InventoryPo po,
//			List<InventoryEntryPo> list) {
//		
//		otherDatabaseManagementDao.insertOtherDatabaseManagement(po);//单据主表
//		Iterator<InventoryEntryPo> it=list.iterator();
//		while(it.hasNext()){
//			InventoryEntryPo entryPo=it.next();
//			entryPo.setCstieinstockid(po.getCstiinstockid());//收入仓位
//			otherDatabaseManagementDao.insertOtherDatabaseManagementEntry(entryPo);//单据明细表
//			VerificationPo verificationPo=new VerificationPo();
//			verificationPo.setCstvpinid(po.getCstibillid());
//			verificationPo.setCstvpoid(po.getCstisourcebillid());
//			verificationPo.setCstvgoodsid(entryPo.getCstiegoodsid());
//			verificationPo.setCstvbarcode(entryPo.getCstiebarcode());
//			verificationPo.setCstvnum(entryPo.getCstiegoodsquantity());
//			
//			if ("1".equals(Utility.getName(po.getCstiauditstate()))&&!"".equals(Utility.getName(po.getCstisourcebillid()))) {
//				otherDatabaseManagementDao.insertVerification(verificationPo);//核销表
//			}
//
//			if("1".equals(Utility.getName(po.getCstiauditstate()))){
//				StrogeChangePo changePo=new StrogeChangePo();
//				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());//商品代码
//				//changePo.setCshscgoodsbarcode(entryPo.getCstiebarcode());//条码
//				changePo.setCshscstockid(entryPo.getCstieinstockid());//入库仓位
//				changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity());//数量
//				//changePo.setCshsccostprice(entryPo.getCstiecostprice());
//				//changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
//				changePo.setCshscchangeid(po.getCstibillid());
//				strogeChangeDao.insertStrogeChange(changePo);//商品库存当月库存变更表
//			}
//
//		}
//		
//	}
	
	/**
	 *  新增其它出库主表
	 */
	public void insertOtherDatabaseManagement(InventoryPo po,
			List<InventoryEntryPo> list,LogisticsLogPo logPo1) {
		
		otherDatabaseManagementDao.insertOtherDatabaseManagement(po);//单据主表
		Iterator<InventoryEntryPo> it=list.iterator();
		while(it.hasNext()){
			InventoryEntryPo entryPo=it.next();
			entryPo.setCstieoutstockid(po.getCstioutstockid());//发出仓位
			otherDatabaseManagementDao.insertOtherDatabaseManagementEntry(entryPo);//单据明细表
			VerificationPo verificationPo=new VerificationPo();
			verificationPo.setCstvpinid(po.getCstibillid());
			verificationPo.setCstvpoid(po.getCstisourcebillid());
			verificationPo.setCstvgoodsid(entryPo.getCstiegoodsid());
			verificationPo.setCstvbarcode(entryPo.getCstiebarcode());
			verificationPo.setCstvnum(entryPo.getCstiegoodsquantity());
			
			if ("1".equals(Utility.getName(po.getCstiauditstate()))&&!"".equals(Utility.getName(po.getCstisourcebillid()))) {
				otherDatabaseManagementDao.insertVerification(verificationPo);//核销表
			}
			
			if("1".equals(Utility.getName(po.getCstiauditstate()))){
				StrogeChangePo changePo=new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiebarcode());
				changePo.setCshscstockid(entryPo.getCstieoutstockid());
				
				if("-".equals(entryPo.getCstiegoodsquantity().toString().substring(0, 1))){
					changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity().substring(1));
				}else{
					changePo.setCshscgoodsquantity("-"+entryPo.getCstiegoodsquantity());
				}
				
				//changePo.setCshscgoodsquantity("-"+entryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChange(changePo);//商品库存当月库存变更表
			}
			
			if("1".equals(Utility.getName(po.getCstiauditstate()))){
				StrogeChangePo logPo=new StrogeChangePo();
				logPo.setCshscgoodsid(entryPo.getCstiegoodsid());
				logPo.setCshscstockid(entryPo.getCstieoutstockid());
				
				if("-".equals(entryPo.getCstiegoodsquantity().toString().substring(0, 1))){
					logPo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity().substring(1));
				}else{
					logPo.setCshscgoodsquantity("-"+entryPo.getCstiegoodsquantity());
				}
				
				//logPo.setCshscgoodsquantity("-"+entryPo.getCstiegoodsquantity());
				logPo.setCshsccostprice(entryPo.getCstiecostprice());
				logPo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				logPo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChangeLog(logPo,entryPo.getCstiebarcode());//商品库存当月库存变更表
				strogeChangeDao.insertStrogeChangeLogTemp(logPo, Utility.getName(entryPo.getCstiebarcode()));// 商品库存当月库存变更表(9张新表)
			}

		}
		
		InTransitStorageTypePo inTransitStorageTypePo = inTransitDetailsDao.getInTransitStorageSwitch("qtck"); // qtck 其他出库
		if (Utility.getName(inTransitStorageTypePo.getCshstinenabled()).equals("1")){
			
			InTransitStorageEntryPo outipo = new InTransitStorageEntryPo();		
			outipo.setCshtsebillid(Utility.getName(po.getCstibillid()));			
			guitarManagementDao.deleteInTransitStroge(outipo);
			
			if(!"1".equals(Utility.getName(po.getCstiauditstate()))){
				otherDatabaseManagementDao.insertOtherOutInTransitStorage(po);
			}			
		}
		
		logisticsLogDao.insertLog(logPo1); //添加日志
	}

	///////////////////原代码////////////////////////
//	/**
//	 *  新增其它出库主表
//	 */
//	public void insertOtherDatabaseManagement(InventoryPo po,
//			List<InventoryEntryPo> list) {
//		
//		otherDatabaseManagementDao.insertOtherDatabaseManagement(po);//单据主表
//		Iterator<InventoryEntryPo> it=list.iterator();
//		while(it.hasNext()){
//			InventoryEntryPo entryPo=it.next();
//			entryPo.setCstieinstockid(po.getCstiinstockid());//收入仓位
//			otherDatabaseManagementDao.insertOtherDatabaseManagementEntry(entryPo);//单据明细表
//			VerificationPo verificationPo=new VerificationPo();
//			verificationPo.setCstvpinid(po.getCstibillid());
//			verificationPo.setCstvpoid(po.getCstisourcebillid());
//			verificationPo.setCstvgoodsid(entryPo.getCstiegoodsid());
//			verificationPo.setCstvbarcode(entryPo.getCstiebarcode());
//			verificationPo.setCstvnum(entryPo.getCstiegoodsquantity());
//			
//			if ("1".equals(Utility.getName(po.getCstiauditstate()))&&!"".equals(Utility.getName(po.getCstisourcebillid()))) {
//				otherDatabaseManagementDao.insertVerification(verificationPo);//核销表
//			}
//
//			if("1".equals(Utility.getName(po.getCstiauditstate()))){
//				StrogeChangePo changePo=new StrogeChangePo();
//				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
//				changePo.setCshscgoodsbarcode(entryPo.getCstiebarcode());
//				changePo.setCshscstockid(entryPo.getCstieinstockid());
//				changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity());
//				changePo.setCshsccostprice(entryPo.getCstiecostprice());
//				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
//				changePo.setCshscchangeid(po.getCstibillid());
//				strogeChangeDao.insertStrogeChange(changePo);//商品库存当月库存变更表
//			}
//
//		}
//		
//	}
	///////////////////////////////////////////
	/**
	 * 修改其它出库
	 */
	public void updateOtherDatabaseManagement(InventoryPo po,
			List<InventoryEntryPo> list,LogisticsLogPo logPo1) {
		otherDatabaseManagementDao.updateOtherDatabaseManagement(po);//单据主表
		otherDatabaseManagementDao.deleteOtherDatabaseManagementEntry(po);//删除单据明细表
		otherDatabaseManagementDao.deleteVerification(po);//删除核销表
		Iterator<InventoryEntryPo> it=list.iterator();
		while(it.hasNext()){
			InventoryEntryPo entryPo=it.next();
			entryPo.setCstieoutstockid(po.getCstioutstockid());//发出仓位
			//entryPo.setCstieinstockid(po.getCstiinstockid()); //领用部门
			
			otherDatabaseManagementDao.insertOtherDatabaseManagementEntry(entryPo);//单据明细表
			VerificationPo verificationPo=new VerificationPo();
			verificationPo.setCstvpinid(po.getCstibillid());
			verificationPo.setCstvpoid(po.getCstisourcebillid());
			verificationPo.setCstvgoodsid(entryPo.getCstiegoodsid());
			verificationPo.setCstvbarcode(entryPo.getCstiebarcode());
			verificationPo.setCstvnum(entryPo.getCstiegoodsquantity());
			
			if ("1".equals(Utility.getName(po.getCstiauditstate()))&&!"".equals(Utility.getName(po.getCstisourcebillid()))) {
				otherDatabaseManagementDao.insertVerification(verificationPo);//核销表
			}
			
			if("1".equals(Utility.getName(po.getCstiauditstate()))){
				StrogeChangePo changePo=new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiebarcode());
				changePo.setCshscstockid(entryPo.getCstieoutstockid());
				if("-".equals(entryPo.getCstiegoodsquantity().toString().substring(0, 1))){
					changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity().substring(1));
				}else{
					changePo.setCshscgoodsquantity("-"+entryPo.getCstiegoodsquantity());
				}
				//changePo.setCshscgoodsquantity("-"+entryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChange(changePo);//商品库存当月库存变更表
			}
			if("1".equals(Utility.getName(po.getCstiauditstate()))){
				StrogeChangePo logPo=new StrogeChangePo();
				logPo.setCshscgoodsid(entryPo.getCstiegoodsid());
				logPo.setCshscstockid(entryPo.getCstieoutstockid());
				if("-".equals(entryPo.getCstiegoodsquantity().toString().substring(0, 1))){
					logPo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity().substring(1));
				}else{
					logPo.setCshscgoodsquantity("-"+entryPo.getCstiegoodsquantity());
				}
				//logPo.setCshscgoodsquantity("-"+entryPo.getCstiegoodsquantity());
				logPo.setCshsccostprice(entryPo.getCstiecostprice());
				logPo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				logPo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChangeLog(logPo,entryPo.getCstiebarcode());//商品库存当月库存变更表
				strogeChangeDao.insertStrogeChangeLogTemp(logPo, Utility.getName(entryPo.getCstiebarcode()));// 商品库存当月库存变更表(9张新表)
			}
		}
		
		InTransitStorageTypePo inTransitStorageTypePo = inTransitDetailsDao.getInTransitStorageSwitch("qtck"); // qtck 其他出库
		if (Utility.getName(inTransitStorageTypePo.getCshstinenabled()).equals("1")){
			
			InTransitStorageEntryPo outipo = new InTransitStorageEntryPo();		
			outipo.setCshtsebillid(Utility.getName(po.getCstibillid()));			
			guitarManagementDao.deleteInTransitStroge(outipo);
			
			if(!"1".equals(Utility.getName(po.getCstiauditstate()))){
				otherDatabaseManagementDao.insertOtherOutInTransitStorage(po);
			}			
		}
		
		logisticsLogDao.insertLog(logPo1); //添加日志
	}

}
