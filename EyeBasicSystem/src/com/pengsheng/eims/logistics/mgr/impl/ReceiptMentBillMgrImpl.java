/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : ReceiptMentBillMgrImpl.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2013-04-28
**/
package com.pengsheng.eims.logistics.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.dao.ReceiptMentBillDao;
import com.pengsheng.eims.logistics.dao.VoucherDao;
import com.pengsheng.eims.logistics.mgr.ReceiptMentBillMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.ReceiptMentBillEntryPo;
import com.pengsheng.eims.logistics.persistence.ReceiptMentBillPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.TracPo;
import com.pengsheng.eims.util.tools.Utility;

public class ReceiptMentBillMgrImpl implements ReceiptMentBillMgr {
	
	private ReceiptMentBillDao receiptMentBillDao = null;
	private LogisticsLogDao logisticsLogDao = null;	
	private VoucherDao voucherDao = null;	
	
	/**
	 * 查询收款单总数
	 */
	public int getReceiptMentBillCount(ReceiptMentBillPo po){
		return receiptMentBillDao.getReceiptMentBillCount(po);
	}

	/**
	 * 查询收款单列表
	 */
	public List<ReceiptMentBillPo> getReceiptMentBillList(ReceiptMentBillPo po,int start,int size){
		return receiptMentBillDao.getReceiptMentBillList(po,start,size);
	}
	
	/**
	 * 新增收款单
	 */
	public void insertReceiptMentBill(ReceiptMentBillPo po,List<ReceiptMentBillEntryPo> epo,LogisticsLogPo logPo){
		
		receiptMentBillDao.insertReceiptMentBill(po);
		
		if (epo != null){
			Iterator<ReceiptMentBillEntryPo> it = epo.iterator();
			while (it.hasNext()){
				ReceiptMentBillEntryPo receiptMentBillEntryPo = (ReceiptMentBillEntryPo)it.next();
				receiptMentBillDao.insertReceiptMentBillEntry(receiptMentBillEntryPo);
			}
		}
		
		if ("1".equals(Utility.getName(po.getsLrbrbAuditStatue()))){
			receiptMentBillDao.deleteFranchiseeCurrentAccountDetail(po);
			receiptMentBillDao.insertFranchiseeCurrentAccountDetail(po);
		}
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 修改收款单
	 */
	public void updateReceiptMentBill(ReceiptMentBillPo po,List<ReceiptMentBillEntryPo> epo,LogisticsLogPo logPo){
		
		receiptMentBillDao.updateReceiptMentBill(po);
		
		receiptMentBillDao.deleteReceiptMentBillEntry(po);
		
		if (epo != null){
			Iterator<ReceiptMentBillEntryPo> it = epo.iterator();
			while (it.hasNext()){
				ReceiptMentBillEntryPo receiptMentBillEntryPo = (ReceiptMentBillEntryPo)it.next();
				receiptMentBillDao.insertReceiptMentBillEntry(receiptMentBillEntryPo);
			}
		}
		
		if ("1".equals(Utility.getName(po.getsLrbrbAuditStatue()))){
			receiptMentBillDao.deleteFranchiseeCurrentAccountDetail(po);
			receiptMentBillDao.insertFranchiseeCurrentAccountDetail(po);
		}
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 删除收款单
	 */
	public void deleteReceiptMentBill(ReceiptMentBillPo po,LogisticsLogPo logPo){
		
		receiptMentBillDao.deleteReceiptMentBill(po);
		receiptMentBillDao.deleteReceiptMentBillEntry(po);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 反审核收款单
	 */
	public boolean unAuditReceiptMentBill(ReceiptMentBillPo po,LogisticsLogPo logPo){
		
		int count = receiptMentBillDao.unAuditReceiptMentBill(po);		
		logisticsLogDao.insertLog(logPo);
		
		if (count == 1){
			return true;
		}else{
			return false;
		}		
	}
	
	/**
	 * 审核收款单
	 */
	public boolean auditReceiptMentBill(ReceiptMentBillPo po,LogisticsLogPo logPo){
		
		int count = receiptMentBillDao.auditReceiptMentBill(po);		
		logisticsLogDao.insertLog(logPo);
		
		if (count == 1){
			return true;
		}else{
			return false;
		}	
	}
	
	/**
	 * 查询收款单详情
	 */
	public ReceiptMentBillPo getReceiptMentBillDetail(ReceiptMentBillPo po){
		return receiptMentBillDao.getReceiptMentBillDetail(po);
	}
	
	/**
	 * 查询收款单明细详情
	 */
	public List<ReceiptMentBillEntryPo> getReceiptMentBillEntryDetail(ReceiptMentBillPo po){
		return receiptMentBillDao.getReceiptMentBillEntryDetail(po);
	}
	
	/**
	 * 查询客户总数
	 */
	public int getFranchiseeCount(ReceiptMentBillPo po){
		return receiptMentBillDao.getFranchiseeCount(po);
	}
	
	/**
	 * 获取客户列表
	 */
	public List<DepartmentsPo> getFranchiseeList(ReceiptMentBillPo po,int start,int size){
		return receiptMentBillDao.getFranchiseeList(po,start,size);
	}

	/**
	 * 查询客户往来账明细
	 */
	public List<InventoryPo> getFranchiseeCurrentAccountDetail(ReceiptMentBillPo po){
		return receiptMentBillDao.getFranchiseeCurrentAccountDetail(po);
	}
	
	
	/**
	 * 查询客户批发调货单总数
	 */
	public int getFranchiseeAllocationBillCount(TracPo po){
		return receiptMentBillDao.getFranchiseeAllocationBillCount(po);
	}
	
	/**
	 * 查询客户批发调货单总数
	 */
	public List<TracPo> getFranchiseeAllocationBillList(TracPo po,int start,int size){
		return receiptMentBillDao.getFranchiseeAllocationBillList(po,start,size);
	}
	
	/**
	 * 应收款总余额
	 */
	public String getFranchiseeAccount(ReceiptMentBillPo po){
		return receiptMentBillDao.getFranchiseeAccount(po);
	}
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	public VoucherDao getVoucherDao() {
		return voucherDao;
	}
	public void setVoucherDao(VoucherDao voucherDao) {
		this.voucherDao = voucherDao;
	}
	public ReceiptMentBillDao getReceiptMentBillDao() {
		return receiptMentBillDao;
	}
	public void setReceiptMentBillDao(ReceiptMentBillDao receiptMentBillDao) {
		this.receiptMentBillDao = receiptMentBillDao;
	}
	
}
