/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : PayMentBillMgrImpl.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2012-05-04
**/
package com.pengsheng.eims.logistics.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.dao.PayMentBillDao;
import com.pengsheng.eims.logistics.dao.VoucherDao;
import com.pengsheng.eims.logistics.mgr.PayMentBillMgr;
import com.pengsheng.eims.logistics.persistence.InOrOutComeTypePo;
import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.PayMentBillEntryPo;
import com.pengsheng.eims.logistics.persistence.PayMentBillPo;
import com.pengsheng.eims.logistics.persistence.VoucherEntryPo;
import com.pengsheng.eims.logistics.persistence.VoucherPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.tools.Utility;

public class PayMentBillMgrImpl implements PayMentBillMgr {
	
	private PayMentBillDao payMentBillDao = null;
	private LogisticsLogDao logisticsLogDao = null;	
	private VoucherDao voucherDao = null;	
	private InTransitDetailsDao inTransitDetailsDao = null;
	
	/**
	 * 查询付款单总数
	 */
	public int getPayMentBillCount(PayMentBillPo po){
		return payMentBillDao.getPayMentBillCount(po);
	}

	/**
	 * 查询付款单列表
	 */
	public List<PayMentBillPo> getPayMentBillList(PayMentBillPo po,int start,int size){
	    return payMentBillDao.getPayMentBillList(po,start,size);
	}
	
	/**
	 * 新增付款单
	 */
	public void insertPayMentBill(PayMentBillPo po,List<PayMentBillEntryPo> epo,LogisticsLogPo logPo){
		payMentBillDao.insertPayMentBill(po);
		
		Iterator<PayMentBillEntryPo> it = epo.iterator();
		while (it.hasNext()){
			PayMentBillEntryPo payMentBillEntryPo = (PayMentBillEntryPo)it.next();
			payMentBillDao.insertPayMentBillEntry(payMentBillEntryPo);
		}
		
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			inTransitDetailsDao.deleteSupplierDealingEntry(po);
			inTransitDetailsDao.insertSupplierDealingEntry(po);
		}
		if (!"1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			inTransitDetailsDao.deleteSupplierDealingEntry(po);
		}
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 修改付款单
	 */
	public void updatePayMentBill(PayMentBillPo po,List<PayMentBillEntryPo> epo,LogisticsLogPo logPo){
		
		payMentBillDao.updatePayMentBill(po);
		
		payMentBillDao.deletePayMentBillEntry(po);
		
		Iterator<PayMentBillEntryPo> it = epo.iterator();
		while (it.hasNext()){
			PayMentBillEntryPo payMentBillEntryPo = (PayMentBillEntryPo)it.next();
			payMentBillDao.insertPayMentBillEntry(payMentBillEntryPo);
		}
		
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			inTransitDetailsDao.deleteSupplierDealingEntry(po);
			inTransitDetailsDao.insertSupplierDealingEntry(po);
		}
		if (!"1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			inTransitDetailsDao.deleteSupplierDealingEntry(po);
		}
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 删除付款单
	 */
	public void deletePayMentBill(PayMentBillPo po,LogisticsLogPo logPo){
		payMentBillDao.deletePayMentBill(po);
		payMentBillDao.deletePayMentBillEntry(po);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 查询付款单详情
	 */
	public PayMentBillPo getPayMentBillDetail(PayMentBillPo po){
		return payMentBillDao.getPayMentBillDetail(po);
	}
	
	/**
	 * 查询付款单明细详情
	 */
	public List<PayMentBillEntryPo> getPayMentBillEntryDetail(PayMentBillPo po){
		return payMentBillDao.getPayMentBillEntryDetail(po);
	}
	
	/**
	 * 查询发票总数
	 */
	public int getInvoiceCount(PayMentBillPo po){
		return payMentBillDao.getInvoiceCount(po);
	}
	
	/**
	 * 获取发票列表
	 */
	public List<InvoiceEntryPo> getInvoiceList(PayMentBillPo po,int start,int size){
		return payMentBillDao.getInvoiceList(po,start,size);
	}
	
	/**
	 * 查询付款单凭证总数
	 */
	public int getVoucherCount(VoucherPo po){
		return payMentBillDao.getVoucherCount(po);
	}
	
	/**
	 * 查询付款单凭证
	 */
	public List<VoucherPo> getVoucherList(VoucherPo po,int start,int size){
		return payMentBillDao.getVoucherList(po,start,size);
	}
	
	/**
	 * 删除付款单凭证
	 */
	public void deleteVoucher(VoucherPo po,LogisticsLogPo logPo){
		
		po.setsLvvPosting("0"); //表示清除付款单的凭证标志
		payMentBillDao.updatePayMentBillVoucherFlag(po);
		
		voucherDao.deleteVoucherByID(Utility.getName(po.getsLvvID()));
		voucherDao.deleteVoucherEntryByID(Utility.getName(po.getsLvvID()));
		voucherDao.deleteVoucherTallyByID(Utility.getName(po.getsLvvID()));
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 新增付款单凭证
	 */
	public void insertVoucher(VoucherPo po,List<VoucherEntryPo> voucherEntryList,LogisticsLogPo logPo){
		
		voucherDao.insertVoucher(po);
		
		Iterator<VoucherEntryPo> it = voucherEntryList.iterator();
		while(it.hasNext()){
			VoucherEntryPo peo = (VoucherEntryPo)it.next();
			payMentBillDao.insertPayMentBillVoucherEntry(peo);
		}
		
		po.setsLvvPosting("1"); //表示清除付款单的凭证标志
		payMentBillDao.updatePayMentBillVoucherFlag(po);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 修改付款单凭证
	 */
	public void updateVoucher(VoucherPo po,LogisticsLogPo logPo){
		
		voucherDao.updateSalesOutStorageVoucher(po);	
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * Description：获取付款单凭证明细
	 * @param     ：凭证明细实体
	 */
	public List<VoucherEntryPo> getPayMentVoucherEntryDetail(VoucherPo po){
		return payMentBillDao.getPayMentVoucherEntryDetail(po);
	}
	
	/**
	 * Description：获取付款单凭证
	 * @param     ：凭证明细实体
	 */
	public VoucherPo getPayMentVoucherDetail(VoucherPo po){
		return payMentBillDao.getPayMentVoucherDetail(po);
	}
	
	/**
	 * 反审核付款单
	 */
	public boolean auditUnPayMentBill(PayMentBillPo po,LogisticsLogPo logPo){
		if (payMentBillDao.getVoucherCountByPayMentBillID(po)<=0){
			
			payMentBillDao.auditUnPayMentBill(po);
			inTransitDetailsDao.deleteSupplierDealingEntry(po);
			
			logisticsLogDao.insertLog(logPo);
			return true;
		}
		return false;
	}
	
	/**
	 * 部分审核付款单
	 */
	public void partAuditPayMentBill(PayMentBillPo po,LogisticsLogPo logPo){
		
		payMentBillDao.partAuditPayMentBill(po);
		
		inTransitDetailsDao.deleteSupplierDealingEntry(po);
		inTransitDetailsDao.insertSupplierDealingEntry(po);

		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 查询其他付款单总数
	 */
	public int getPayMentBillOtherCount(PayMentBillPo po){
		return payMentBillDao.getPayMentBillOtherCount(po);
	}

	/**
	 * 查询其他付款单列表
	 */
	public List<PayMentBillPo> getPayMentBillOtherList(PayMentBillPo po,int start,int size){
		return payMentBillDao.getPayMentBillOtherList(po,start,size);
	}
	
	/**
	 * 新增其他付款单
	 */
	public void insertPayMentBillOther(PayMentBillPo po,List<PayMentBillEntryPo> epo,LogisticsLogPo logPo){
		payMentBillDao.insertPayMentBillOther(po);
		
		Iterator<PayMentBillEntryPo> it = epo.iterator();
		while (it.hasNext()){
			PayMentBillEntryPo payMentBillEntryPo = (PayMentBillEntryPo)it.next();
			payMentBillDao.insertPayMentBillOtherEntry(payMentBillEntryPo);
		}
		
		
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue())) && !Utility.getName(po.getsLpbpbSupplierID()).equals("")){
			inTransitDetailsDao.deleteSupplierDealingEntry(po);
			inTransitDetailsDao.insertSupplierDealingEntry(po);
		}
		if (!"1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			inTransitDetailsDao.deleteSupplierDealingEntry(po);
		}
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 修改其他付款单
	 */
	public void updatePayMentBillOther(PayMentBillPo po,List<PayMentBillEntryPo> epo,LogisticsLogPo logPo){
		payMentBillDao.updatePayMentBillOther(po);
		
		payMentBillDao.deletePayMentBillEntry(po);
		
		Iterator<PayMentBillEntryPo> it = epo.iterator();
		while (it.hasNext()){
			PayMentBillEntryPo payMentBillEntryPo = (PayMentBillEntryPo)it.next();
			payMentBillDao.insertPayMentBillOtherEntry(payMentBillEntryPo);
		}
		
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue())) && !Utility.getName(po.getsLpbpbSupplierID()).equals("")){
			inTransitDetailsDao.deleteSupplierDealingEntry(po);
			inTransitDetailsDao.insertSupplierDealingEntry(po);
		}
		if (!"1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			inTransitDetailsDao.deleteSupplierDealingEntry(po);
		}
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 删除其他付款单
	 */
	public void deletePayMentBillOther(PayMentBillPo po,LogisticsLogPo logPo){
		
	}
	
	/**
	 * 反审核其他付款单
	 */
	public boolean auditUnPayMentBillOther(PayMentBillPo po,LogisticsLogPo logPo){
		
		payMentBillDao.auditUnPayMentBill(po);
		inTransitDetailsDao.deleteSupplierDealingEntry(po);		

		logisticsLogDao.insertLog(logPo);
		
		return true;
	}
	
	/**
	 * 查询其他付款单详情
	 */
	public PayMentBillPo getPayMentBillOtherDetail(PayMentBillPo po){
		return payMentBillDao.getPayMentBillOtherDetail(po);
	}
	
	/**
	 * 查询其他付款单明细详情
	 */
	public List<PayMentBillEntryPo> getPayMentBillOtherEntryDetail(PayMentBillPo po){
		return payMentBillDao.getPayMentBillOtherEntryDetail(po);
	}
	
	/**
	 * 查询收支类别总数
	 */
	public int getInOrOutComeTypeCount(InOrOutComeTypePo po){
		return payMentBillDao.getInOrOutComeTypeCount(po);
	}

	/**
	 * 查询收支类别列表
	 */
	public List<InOrOutComeTypePo> getInOrOutComeTypeList(InOrOutComeTypePo po,int start,int size){
		return payMentBillDao.getInOrOutComeTypeList(po,start,size);
	}
	
	/**
	 * 新增收支类别
	 */
	public void insertInOrOutComeType(InOrOutComeTypePo po,LogisticsLogPo logPo){
		payMentBillDao.insertInOrOutComeType(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 修改收支类别
	 */
	public void updateInOrOutComeType(InOrOutComeTypePo po,LogisticsLogPo logPo){
		payMentBillDao.updateInOrOutComeType(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 删除收支类别
	 */
	public void deleteInOrOutComeType(InOrOutComeTypePo po,LogisticsLogPo logPo){
		payMentBillDao.deleteInOrOutComeType(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 查询收支类别详情
	 */
	public InOrOutComeTypePo getInOrOutComeTypeDetail(InOrOutComeTypePo po){
		return payMentBillDao.getInOrOutComeTypeDetail(po);
	}

	/**
	 * 查询收支类别是否存在
	 */
	public int isExistsInOrOutComeType(InOrOutComeTypePo po){
		return payMentBillDao.isExistsInOrOutComeType(po);
	}
	
	/**
	 * 查询制造商总数
	 */
	public int getSupplierCurrentAccountCount(SupplierPo po){
		return payMentBillDao.getSupplierCurrentAccountCount(po);
	}
	
	/**
	 * 查询各制造商往来账总金额
	 */
	public List<SupplierPo> getSupplierCurrentAccountList(SupplierPo po,int start,int size){
		return payMentBillDao.getSupplierCurrentAccountList(po,start,size);
	}

	/**
	 * 查询制造商往来账明细
	 */
	public List<InventoryPo> getSupplierCurrentAccountDetail(SupplierPo po){
		return payMentBillDao.getSupplierCurrentAccountDetail(po);
	}
	
	/**
	 * 查询制造商期初金额
	 */
	public String getSupplierBeginningAccount(SupplierPo po){
		return payMentBillDao.getSupplierBeginningAccount(po);
	}
	
	/**
	 * 查询制造商期末金额
	 */
	public String getSupplierEndAccount(SupplierPo po){
		return payMentBillDao.getSupplierEndAccount(po);
	}
	
	/**
	 * 查询付款单(简)总数
	 */
	public int getPayMentBillSimpleCount(PayMentBillPo po){
		return payMentBillDao.getPayMentBillSimpleCount(po);
	}

	/**
	 * 查询付款单(简)列表
	 */
	public List<PayMentBillPo> getPayMentBillSimpleList(PayMentBillPo po,int start,int size){
		return payMentBillDao.getPayMentBillSimpleList(po,start,size);
	}
	
	/**
	 * 查询付款单(简)列表（开窗）
	 */
	public List<PayMentBillPo> getPayMentBillSimpleOpenList(PayMentBillPo po,int start,int size){
		return payMentBillDao.getPayMentBillSimpleOpenList(po,start,size);
	}
	
	/**
	 * 新增付款单(简)
	 */
	public void insertPayMentBillSimple(PayMentBillPo po,List<PayMentBillEntryPo> epo,LogisticsLogPo logPo){
		payMentBillDao.insertPayMentBillSimple(po);
		
		Iterator<PayMentBillEntryPo> it = epo.iterator();
		while (it.hasNext()){
			PayMentBillEntryPo payMentBillEntryPo = (PayMentBillEntryPo)it.next();
			payMentBillDao.insertPayMentBillSimpleEntry(payMentBillEntryPo);
		}
		
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			inTransitDetailsDao.deleteSupplierDealingEntry(po);
			inTransitDetailsDao.insertSupplierDealingEntry(po);
		}
		if (!"1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			inTransitDetailsDao.deleteSupplierDealingEntry(po);
		}
				
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 修改付款单(简)
	 */
	public void updatePayMentBillSimple(PayMentBillPo po,List<PayMentBillEntryPo> epo,LogisticsLogPo logPo){
		payMentBillDao.updatePayMentBillSimple(po);
		
		payMentBillDao.deletePayMentBillEntry(po);
		
		Iterator<PayMentBillEntryPo> it = epo.iterator();
		while (it.hasNext()){
			PayMentBillEntryPo payMentBillEntryPo = (PayMentBillEntryPo)it.next();
			payMentBillDao.insertPayMentBillSimpleEntry(payMentBillEntryPo);
		}
		
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			inTransitDetailsDao.deleteSupplierDealingEntry(po);
			inTransitDetailsDao.insertSupplierDealingEntry(po);
		}
		if (!"1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			inTransitDetailsDao.deleteSupplierDealingEntry(po);
		}
				
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 删除付款单(简)
	 */
	public void deletePayMentBillSimple(PayMentBillPo po,LogisticsLogPo logPo){
		
	}
	
	/**
	 * 反审核付款单(简)
	 */
	public boolean auditUnPayMentBillSimple(PayMentBillPo po,LogisticsLogPo logPo){
		if (payMentBillDao.isExistsAdvancePayMentBill(po)<=0){
			
			payMentBillDao.auditUnPayMentBill(po);
			inTransitDetailsDao.deleteSupplierDealingEntry(po);
			
			logisticsLogDao.insertLog(logPo);
			return true;
		}
		return false;
	}
	
	/**
	 * 查询付款单(简)详情
	 */
	public PayMentBillPo getPayMentBillSimpleDetail(PayMentBillPo po){
		return payMentBillDao.getPayMentBillSimpleDetail(po);
	}
	
	/**
	 * 查询付款单(简)明细详情
	 */
	public List<PayMentBillEntryPo> getPayMentBillSimpleEntryDetail(PayMentBillPo po){
		return payMentBillDao.getPayMentBillSimpleEntryDetail(po);
	}
	
	/**
	 * 查询采购单据总数
	 */
	public int getProcurementBillCount(PayMentBillPo po){
		return payMentBillDao.getProcurementBillCount(po);
	}

	/**
	 * 查询采购单据列表
	 */
	public List<PayMentBillPo> getProcurementBillList(PayMentBillPo po,int start,int size){
		return payMentBillDao.getProcurementBillList(po,start,size);
	}
		
	/**
	 * 查询预付款单总数
	 */
	public int getAdvancePayMentBillCount(PayMentBillPo po){
		return payMentBillDao.getAdvancePayMentBillCount(po);
	}

	/**
	 * 查询预付款单列表
	 */
	public List<PayMentBillPo> getAdvancePayMentBillList(PayMentBillPo po,int start,int size){
		return payMentBillDao.getAdvancePayMentBillList(po,start,size);
	}
	
	/**
	 * 查询所有制造商期末金额
	 */
	public String getSupplierAccount(SupplierPo po){
	    return 	payMentBillDao.getSupplierAccount(po);
	}
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public PayMentBillDao getPayMentBillDao() {
		return payMentBillDao;
	}

	public void setPayMentBillDao(PayMentBillDao payMentBillDao) {
		this.payMentBillDao = payMentBillDao;
	}

	public VoucherDao getVoucherDao() {
		return voucherDao;
	}

	public void setVoucherDao(VoucherDao voucherDao) {
		this.voucherDao = voucherDao;
	}

	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}

	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}
	
}
