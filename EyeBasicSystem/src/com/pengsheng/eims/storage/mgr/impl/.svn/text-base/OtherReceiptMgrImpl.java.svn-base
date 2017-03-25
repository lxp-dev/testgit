package com.pengsheng.eims.storage.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.storage.dao.OtherReceiptDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.mgr.OtherReceiptMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.storage.persistence.VerificationPo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class OtherReceiptMgrImpl implements OtherReceiptMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}


	private OtherReceiptDao otherReceiptDao;

	private StrogeChangeDao strogeChangeDao;

	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}

	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
	}

	public OtherReceiptDao getOtherReceiptDao() {
		return otherReceiptDao;
	}

	public void setOtherReceiptDao(OtherReceiptDao otherReceiptDao) {
		this.otherReceiptDao = otherReceiptDao;
	}

	public int getOtherReceiptCount(InventoryPo po) {

		return otherReceiptDao.getOtherReceiptCount(po);
	}

	public List<InventoryPo> getOtherReceiptList(InventoryPo po, int start,
			int size) {

		return otherReceiptDao.getOtherReceiptList(po, start, size);
	}

	/**
	 * 新增其它入库
	 */
	public void insertOtherReceipt(InventoryPo po, List<InventoryEntryPo> list,LogisticsLogPo logPo) {

		otherReceiptDao.insertOtherReceipt(po);// 单据主表
		Iterator<InventoryEntryPo> it = list.iterator();
		while (it.hasNext()) {
			InventoryEntryPo entryPo = it.next();
			entryPo.setCstieinstockid(po.getCstiinstockid());// 收入仓位
//			StrogeChangePo changePoTemp = new StrogeChangePo();
//			changePoTemp.setCshscgoodsid(entryPo.getCstiegoodsid());
//			changePoTemp.setCshscrksj(entryPo.getCstierksj());
//			
//			GoodsInfoPo goodsInfoPo=strogeChangeDao.getGoodsInfoPoBarCode(entryPo.getCstiegoodsid());
//			changePoTemp.setCshscbarcodeflag(goodsInfoPo.getBgirksj());
//			changePoTemp.setCshscgoodsbarcode(goodsInfoPo.getBgigoodsbarcode());
//			
//			changePoTemp=strogeChangeDao.getStrogeChangePoBarCode(changePoTemp);
//			if("4".equals(changePoTemp.getCshscgoodsbarcode().substring(1))||"5".equals(changePoTemp.getCshscgoodsbarcode().substring(1))){
//				entryPo.setCstiepcbarcode(changePoTemp.getCshscgoodsbarcode());
//			}
			
			otherReceiptDao.insertOtherReceiptEntry(entryPo);// 单据明细表
			VerificationPo verificationPo = new VerificationPo();
			verificationPo.setCstvpinid(po.getCstibillid());
			verificationPo.setCstvpoid(po.getCstisourcebillid());
			verificationPo.setCstvgoodsid(entryPo.getCstiegoodsid());
			verificationPo.setCstvbarcode(entryPo.getCstiebarcode());
			verificationPo.setCstvnum(entryPo.getCstiegoodsquantity());

			otherReceiptDao.insertVerification(verificationPo);// 核销表
			if ("1".equals(Utility.getName(po.getCstiauditstate()))) {
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiebarcode());
				changePo.setCshscstockid(entryPo.getCstieinstockid());
				changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChange(changePo);// 商品库存当月库存变更表
			}
			
			if("1".equals(Utility.getName(po.getCstiauditstate()))){
				StrogeChangePo changePo=new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiebarcode());
				changePo.setCshscstockid(entryPo.getCstieinstockid());
				changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				changePo.setCshscrksj(entryPo.getCstierksj());
				strogeChangeDao.insertStrogeChangeLog(changePo,entryPo.getCstiepcbarcode());//商品库存库存变更日志表
				strogeChangeDao.insertStrogeChangeLogTemp(changePo, entryPo.getCstiepcbarcode());// 商品库存当月库存变更表(9张新表)
			}

		}
		logisticsLogDao.insertLog(logPo); 
	}

	public InventoryPo getOtherReceipt(InventoryPo po) {

		return otherReceiptDao.getOtherReceipt(po);
	}

	public List<InventoryEntryPo> getOtherReceiptEntryList(InventoryPo po) {

		return otherReceiptDao.getOtherReceiptEntryList(po);
	}

	/**
	 * 修改其它入库
	 */
	public void updateOtherReceipt(InventoryPo po, List<InventoryEntryPo> list,LogisticsLogPo logPo) {

		otherReceiptDao.updateOtherReceipt(po);// 单据主表
		otherReceiptDao.deleteOtherReceiptEntry(po);// 删除单据明细表
		otherReceiptDao.deleteVerification(po);// 删除核销表
		Iterator<InventoryEntryPo> it = list.iterator();
		while (it.hasNext()) {
			InventoryEntryPo entryPo = it.next();
			entryPo.setCstieinstockid(po.getCstiinstockid());// 收入仓位
//			StrogeChangePo changePoTemp = new StrogeChangePo();
//			changePoTemp.setCshscgoodsid(entryPo.getCstiegoodsid());
//			changePoTemp.setCshscrksj(entryPo.getCstierksj());
//			
//			GoodsInfoPo goodsInfoPo=strogeChangeDao.getGoodsInfoPoBarCode(entryPo.getCstiegoodsid());
//			changePoTemp.setCshscbarcodeflag(goodsInfoPo.getBgirksj());
//			changePoTemp.setCshscgoodsbarcode(goodsInfoPo.getBgigoodsbarcode());
//			
//			changePoTemp=strogeChangeDao.getStrogeChangePoBarCode(changePoTemp);
//			if("4".equals(changePoTemp.getCshscgoodsbarcode().substring(1))||"5".equals(changePoTemp.getCshscgoodsbarcode().substring(1))){
//				entryPo.setCstiepcbarcode(changePoTemp.getCshscgoodsbarcode());
//			}

			otherReceiptDao.insertOtherReceiptEntry(entryPo);// 单据明细表
			VerificationPo verificationPo = new VerificationPo();
			verificationPo.setCstvpinid(po.getCstibillid());
			verificationPo.setCstvpoid(po.getCstisourcebillid());
			verificationPo.setCstvgoodsid(entryPo.getCstiegoodsid());
			verificationPo.setCstvbarcode(entryPo.getCstiebarcode());
			verificationPo.setCstvnum(entryPo.getCstiegoodsquantity());

			otherReceiptDao.insertVerification(verificationPo);// 核销表
			if ("1".equals(Utility.getName(po.getCstiauditstate()))) {
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiegoodsid().replace(".", ""));
				changePo.setCshscstockid(entryPo.getCstieinstockid());
				changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChange(changePo);// 商品库存当月库存变更表
			}
			
			if("1".equals(Utility.getName(po.getCstiauditstate()))){
				StrogeChangePo changePo=new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiegoodsid().replace(".", ""));
				changePo.setCshscstockid(entryPo.getCstieinstockid());
				changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				changePo.setCshscrksj(entryPo.getCstierksj());
				strogeChangeDao.insertStrogeChangeLog(changePo,entryPo.getCstiepcbarcode());//商品库存库存变更日志表
				strogeChangeDao.insertStrogeChangeLogTemp(changePo, entryPo.getCstiepcbarcode());// 商品库存当月库存变更表(9张新表)
			}

		}
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 删除其它入库
	 */
	public void deleteOtherReceipt(InventoryPo po,LogisticsLogPo logPo) {

		otherReceiptDao.deleteOtherReceipt(po);// 单据主表
		otherReceiptDao.deleteOtherReceiptEntry(po);// 删除单据明细表
		otherReceiptDao.deleteVerification(po);// 删除核销表
		logisticsLogDao.insertLog(logPo); //添加日志

	}

}
