package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;

import com.pengsheng.eims.storage.dao.ConsignProcessWaitDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.mgr.ConsignProcessWaitMgr;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.storage.persistence.VerificationPo;
import com.pengsheng.eims.util.tools.Utility;

public class ConsignProcessWaitMgrImpl implements ConsignProcessWaitMgr {

	private ConsignProcessWaitDao consignProcessWaitDao;
	
	private StrogeChangeDao strogeChangeDao;
	
	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}

	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
	}

	public ConsignProcessWaitDao getConsignProcessWaitDao() {
		return consignProcessWaitDao;
	}

	public void setConsignProcessWaitDao(ConsignProcessWaitDao consignProcessWaitDao) {
		this.consignProcessWaitDao = consignProcessWaitDao;
	}

	/**
	 * 委外信息数量
	 * @param consignProcessOrderPo
	 * @return
	 */
	public int getConsignProcessOrderCount(
			ConsignProcessOrderPo consignProcessOrderPo) {
		// TODO Auto-generated method stub
		return consignProcessWaitDao.getConsignProcessOrderCount(consignProcessOrderPo);
	}

	/**
	 * 委外商品详细信息数量
	 * @param consignProcessOrderDetailsPo
	 * @return
	 */
	public int getConsignProcessOrderDetailsCount(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo) {
		// TODO Auto-generated method stub
		return consignProcessWaitDao.getConsignProcessOrderDetailsCount(consignProcessOrderDetailsPo);
	}

	/**
	 * 委外商品详细信息 分页  更新页面表体
	 * @param consignProcessOrderDetailsPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ConsignProcessOrderDetailsPo> getConsignProcessOrderDetailsList(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo,
			int start, int size) {
		// TODO Auto-generated method stub
		return consignProcessWaitDao.getConsignProcessOrderDetailsList(consignProcessOrderDetailsPo, start, size);
	}

	/**
	 * 委外查询表体信息  分页
	 * @param consignProcessOrderPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ConsignProcessOrderPo> getConsignProcessOrderList(
			ConsignProcessOrderPo consignProcessOrderPo, int start, int size) {
		// TODO Auto-generated method stub
		return consignProcessWaitDao.getConsignProcessOrderList(consignProcessOrderPo, start, size);
	}

	/**
	 * 主表(委外收货主表)中插入表头的信息   ConsignProcessReceiptPo
	 * 从表(委外收货明细表)中插入表体的信息   List<ConsignProcessReceiptDetailsPo>
	 * @param consignProcessReceiptPo
	 * @param list
	 */
	public void insertConsignProcessWaitAll(
			ConsignProcessReceiptPo consignProcessReceiptPo,
			List<ConsignProcessReceiptDetailsPo> list) {
		// TODO Auto-generated method stub
		consignProcessWaitDao.insertConsignProcessReceipt(consignProcessReceiptPo);
		
		for (ConsignProcessReceiptDetailsPo consignProcessReceiptDetailsPo : list) {

			consignProcessReceiptDetailsPo.setCstcprdinstockid(consignProcessReceiptPo.getCstcprinstockid());// 收入仓位
			consignProcessWaitDao.insertConsignProcessReceiptDetails(consignProcessReceiptDetailsPo);// 单据明细表
			VerificationPo verificationPo = new VerificationPo();
			verificationPo.setCstvpinid(consignProcessReceiptPo.getCstcprreceiptbillid());
			verificationPo.setCstvpoid(consignProcessReceiptPo.getCstcprsourcebillid());
			verificationPo.setCstvgoodsid(consignProcessReceiptDetailsPo.getCstcprdgoodsid());
			verificationPo.setCstvbarcode(consignProcessReceiptDetailsPo.getCstcprdbarcode());
			verificationPo.setCstvnum(consignProcessReceiptDetailsPo.getCstcprdnum());
			verificationPo.setCstvorderdetailsid(consignProcessReceiptDetailsPo.getCstcprdorderdetailsid());

			consignProcessWaitDao.insertVerification(verificationPo);// 核销表

			if ("1".equals(Utility.getName(consignProcessReceiptPo
					.getCstcprauditstate()))) {
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(consignProcessReceiptDetailsPo.getCstcprdgoodsid());
				changePo.setCshscgoodsbarcode(consignProcessReceiptDetailsPo.getCstcprdbarcode());
				changePo.setCshscstockid(consignProcessReceiptDetailsPo.getCstcprdinstockid());
				changePo.setCshscgoodsquantity(consignProcessReceiptDetailsPo.getCstcprdnum());
				changePo.setCshsccostprice(consignProcessReceiptDetailsPo.getCstcprdcostprice());
				changePo.setCshscnottaxrate(consignProcessReceiptDetailsPo.getCstcprdnottaxrate());
				changePo.setCshscchangeid(consignProcessReceiptPo
						.getCstcprreceiptbillid());
				strogeChangeDao.insertStrogeChange(changePo);// 商品库存当月库存变更表

				consignProcessWaitDao.buildInventory(consignProcessReceiptPo.getCstcprreceiptbillid());
				consignProcessWaitDao.buildInventoryEntry(consignProcessReceiptPo.getCstcprreceiptbillid());
			}

		}
		
	}

}
