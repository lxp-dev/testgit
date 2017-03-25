package com.pengsheng.eims.storage.mgr.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.dao.SupplierDao;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.storage.dao.ReturnMerchandiseManagementDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.mgr.ReturnMerchandiseManagementMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.storage.persistence.VerificationPo;
import com.pengsheng.eims.util.tools.Utility;

public class ReturnMerchandiseManagementMgrImpl implements
		ReturnMerchandiseManagementMgr {

	private ReturnMerchandiseManagementDao returnMerchandiseManagementDao;

	private StrogeChangeDao strogeChangeDao;

	private SupplierDao supplierDao;

	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}

	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
	}

	public SupplierDao getSupplierDao() {
		return supplierDao;
	}

	public void setSupplierDao(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}

	public ReturnMerchandiseManagementDao getReturnMerchandiseManagementDao() {
		return returnMerchandiseManagementDao;
	}

	public void setReturnMerchandiseManagementDao(
			ReturnMerchandiseManagementDao returnMerchandiseManagementDao) {
		this.returnMerchandiseManagementDao = returnMerchandiseManagementDao;
	}

	/**
	 * 获取采购商品退货的po
	 */
	public InventoryPo getReturnMerchandiseManagement(InventoryPo po) {

		return returnMerchandiseManagementDao
				.getReturnMerchandiseManagement(po);
	}

	/**
	 * 获取采购商品退货的数量
	 */
	public int getReturnMerchandiseManagementCount(InventoryPo po) {

		return returnMerchandiseManagementDao
				.getReturnMerchandiseManagementCount(po);
	}

	/**
	 * 获取采购商品退货的list
	 */
	public List<InventoryPo> getReturnMerchandiseManagementList(InventoryPo po,
			int start, int size) {

		return returnMerchandiseManagementDao
				.getReturnMerchandiseManagementList(po, start, size);
	}

	/**
	 * 新增采购商品退货主表
	 */
	public void insertReturnMerchandiseManagement(InventoryPo po,
			List<InventoryEntryPo> list) {

		returnMerchandiseManagementDao.insertReturnMerchandiseManagement(po);// 单据主表
		Iterator<InventoryEntryPo> it = list.iterator();
		while (it.hasNext()) {
			InventoryEntryPo entryPo = it.next();
			entryPo.setCstieinstockid(po.getCstiinstockid());// 收入仓位
			returnMerchandiseManagementDao
					.insertReturnMerchandiseManagementEntry(entryPo);// 单据明细表
			VerificationPo verificationPo = new VerificationPo();
			verificationPo.setCstvpinid(po.getCstibillid());
			verificationPo.setCstvpoid(po.getCstisourcebillid());
			verificationPo.setCstvgoodsid(entryPo.getCstiegoodsid());
			verificationPo.setCstvbarcode(entryPo.getCstiebarcode());
			verificationPo.setCstvnum(entryPo.getCstiegoodsquantity());

			if ("1".equals(Utility.getName(po.getCstiauditstate()))
					&& !"".equals(Utility.getName(po.getCstisourcebillid()))) {
				returnMerchandiseManagementDao
						.insertVerification(verificationPo);// 核销表
			}

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

			if ("1".equals(Utility.getName(po.getCstiauditstate()))) {
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiebarcode());
				changePo.setCshscstockid(entryPo.getCstieinstockid());
				changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChangeLog(changePo, entryPo
						.getCstiepcbarcode());// 商品库存当月库存变更表
			}

		}

	}

	/**
	 * 得到业务信息明细表中的采购商品退货信息
	 */
	public List<InventoryEntryPo> getProcurementReturnEntryList(InventoryPo po) {

		return returnMerchandiseManagementDao
				.getReturnMerchandiseManagementEntryList(po);
	}

	/**
	 * 删除采购商品退货单
	 */
	public void deleteReturnMerchandiseManagement(InventoryPo po) {

		returnMerchandiseManagementDao.deleteReturnMerchandiseManagement(po);// 单据主表
		returnMerchandiseManagementDao
				.deleteReturnMerchandiseManagementEntry(po);// 删除单据明细表
		returnMerchandiseManagementDao.deleteVerification(po);// 删除核销表
	}

	/**
	 * 获取采购商品退货明细表的list
	 */
	public List<InventoryEntryPo> getReturnMerchandiseManagementEntryList(
			InventoryPo po) {

		return returnMerchandiseManagementDao
				.getReturnMerchandiseManagementEntryList(po);
	}

	/**
	 * 修改采购商品退货单
	 */
	public void updateReturnMerchandiseManagement(InventoryPo po,
			List<InventoryEntryPo> list) {
		returnMerchandiseManagementDao.updateReturnMerchandiseManagement(po);// 单据主表
		returnMerchandiseManagementDao
				.deleteReturnMerchandiseManagementEntry(po);// 删除单据明细表
		returnMerchandiseManagementDao.deleteVerification(po);// 删除核销表
		Iterator<InventoryEntryPo> it = list.iterator();
		while (it.hasNext()) {
			InventoryEntryPo entryPo = it.next();
			entryPo.setCstieinstockid(po.getCstiinstockid());// 收入仓位

			returnMerchandiseManagementDao
					.insertReturnMerchandiseManagementEntry(entryPo);// 单据明细表
			VerificationPo verificationPo = new VerificationPo();
			verificationPo.setCstvpinid(po.getCstibillid());
			verificationPo.setCstvpoid(po.getCstisourcebillid());
			verificationPo.setCstvgoodsid(entryPo.getCstiegoodsid());
			verificationPo.setCstvbarcode(entryPo.getCstiebarcode());
			verificationPo.setCstvnum(entryPo.getCstiegoodsquantity());

			if ("1".equals(Utility.getName(po.getCstiauditstate()))
					&& !"".equals(Utility.getName(po.getCstisourcebillid()))) {
				returnMerchandiseManagementDao
						.insertVerification(verificationPo);// 核销表
			}

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

		}

	}

}
