/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : PayMentBillMgr.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2012-05-04
**/
package com.pengsheng.eims.logistics.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.logistics.persistence.InOrOutComeTypePo;
import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.PayMentBillEntryPo;
import com.pengsheng.eims.logistics.persistence.PayMentBillPo;
import com.pengsheng.eims.logistics.persistence.VoucherEntryPo;
import com.pengsheng.eims.logistics.persistence.VoucherPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface PayMentBillMgr{
	
	/**
	 * 查询付款单总数
	 */
	public int getPayMentBillCount(PayMentBillPo po);

	/**
	 * 查询付款单列表
	 */
	public List<PayMentBillPo> getPayMentBillList(PayMentBillPo po,int start,int size);
	
	/**
	 * 新增付款单
	 */
	public void insertPayMentBill(PayMentBillPo po,List<PayMentBillEntryPo> epo,LogisticsLogPo logPo);
	
	/**
	 * 修改付款单
	 */
	public void updatePayMentBill(PayMentBillPo po,List<PayMentBillEntryPo> epo,LogisticsLogPo logPo);
	
	/**
	 * 删除付款单
	 */
	public void deletePayMentBill(PayMentBillPo po,LogisticsLogPo logPo);
	
	/**
	 * 反审核付款单
	 */
	public boolean auditUnPayMentBill(PayMentBillPo po,LogisticsLogPo logPo);
	
	/**
	 * 查询付款单详情
	 */
	public PayMentBillPo getPayMentBillDetail(PayMentBillPo po);
	
	/**
	 * 查询付款单明细详情
	 */
	public List<PayMentBillEntryPo> getPayMentBillEntryDetail(PayMentBillPo po);
	
	/**
	 * 查询发票总数
	 */
	public int getInvoiceCount(PayMentBillPo po);
	
	/**
	 * 获取发票列表
	 */
	public List<InvoiceEntryPo> getInvoiceList(PayMentBillPo po,int start,int size);
	
	/**
	 * 查询付款单凭证总数
	 */
	public int getVoucherCount(VoucherPo po);
	
	/**
	 * 查询付款单凭证
	 */
	public List<VoucherPo> getVoucherList(VoucherPo po,int start,int size);
	
	/**
	 * 删除付款单凭证
	 */
	public void deleteVoucher(VoucherPo po,LogisticsLogPo logPo);
	
	/**
	 * 新增付款单凭证
	 */
	public void insertVoucher(VoucherPo po,List<VoucherEntryPo> voucherEntryList,LogisticsLogPo logPo);
	
	/**
	 * 修改付款单凭证
	 */
	public void updateVoucher(VoucherPo po,LogisticsLogPo logPo);
	
	/**
	 * Description：获取付款单凭证明细
	 * @param     ：凭证明细实体
	 */
	public List<VoucherEntryPo> getPayMentVoucherEntryDetail(VoucherPo po);
	
	/**
	 * Description：获取付款单凭证
	 * @param     ：凭证明细实体
	 */
	public VoucherPo getPayMentVoucherDetail(VoucherPo po);

	/**
	 * 查询其他付款单总数
	 */
	public int getPayMentBillOtherCount(PayMentBillPo po);

	/**
	 * 查询其他付款单列表
	 */
	public List<PayMentBillPo> getPayMentBillOtherList(PayMentBillPo po,int start,int size);
	
	/**
	 * 新增其他付款单
	 */
	public void insertPayMentBillOther(PayMentBillPo po,List<PayMentBillEntryPo> epo,LogisticsLogPo logPo);
	
	/**
	 * 修改其他付款单
	 */
	public void updatePayMentBillOther(PayMentBillPo po,List<PayMentBillEntryPo> epo,LogisticsLogPo logPo);
	
	/**
	 * 删除其他付款单
	 */
	public void deletePayMentBillOther(PayMentBillPo po,LogisticsLogPo logPo);
	
	/**
	 * 反审核其他付款单
	 */
	public boolean auditUnPayMentBillOther(PayMentBillPo po,LogisticsLogPo logPo);
	
	/**
	 * 查询其他付款单详情
	 */
	public PayMentBillPo getPayMentBillOtherDetail(PayMentBillPo po);
	
	/**
	 * 查询其他付款单明细详情
	 */
	public List<PayMentBillEntryPo> getPayMentBillOtherEntryDetail(PayMentBillPo po);
	
	/**
	 * 查询收支类别总数
	 */
	public int getInOrOutComeTypeCount(InOrOutComeTypePo po);

	/**
	 * 查询收支类别列表
	 */
	public List<InOrOutComeTypePo> getInOrOutComeTypeList(InOrOutComeTypePo po,int start,int size);
	
	/**
	 * 新增收支类别
	 */
	public void insertInOrOutComeType(InOrOutComeTypePo po,LogisticsLogPo logPo);
	
	/**
	 * 修改收支类别
	 */
	public void updateInOrOutComeType(InOrOutComeTypePo po,LogisticsLogPo logPo);
	
	/**
	 * 删除收支类别
	 */
	public void deleteInOrOutComeType(InOrOutComeTypePo po,LogisticsLogPo logPo);
	
	/**
	 * 查询收支类别详情
	 */
	public InOrOutComeTypePo getInOrOutComeTypeDetail(InOrOutComeTypePo po);

	/**
	 * 查询收支类别是否存在
	 */
	public int isExistsInOrOutComeType(InOrOutComeTypePo po);
	
	/**
	 * 查询制造商总数
	 */
	public int getSupplierCurrentAccountCount(SupplierPo po);
	
	/**
	 * 查询各制造商往来账总金额
	 */
	public List<SupplierPo> getSupplierCurrentAccountList(SupplierPo po,int start,int size);

	/**
	 * 查询制造商往来账明细
	 */
	public List<InventoryPo> getSupplierCurrentAccountDetail(SupplierPo po);
	
	/**
	 * 查询制造商期初金额
	 */
	public String getSupplierBeginningAccount(SupplierPo po);
	
	/**
	 * 查询制造商期末金额
	 */
	public String getSupplierEndAccount(SupplierPo po);

	/**
	 * 查询付款单(简)总数
	 */
	public int getPayMentBillSimpleCount(PayMentBillPo po);

	/**
	 * 查询付款单(简)列表
	 */
	public List<PayMentBillPo> getPayMentBillSimpleList(PayMentBillPo po,int start,int size);
	
	/**
	 * 查询付款单(简)列表（开窗）
	 */
	public List<PayMentBillPo> getPayMentBillSimpleOpenList(PayMentBillPo po,int start,int size);
	
	/**
	 * 新增付款单(简)
	 */
	public void insertPayMentBillSimple(PayMentBillPo po,List<PayMentBillEntryPo> epo,LogisticsLogPo logPo);
	
	/**
	 * 修改付款单(简)
	 */
	public void updatePayMentBillSimple(PayMentBillPo po,List<PayMentBillEntryPo> epo,LogisticsLogPo logPo);
	
	/**
	 * 删除付款单(简)
	 */
	public void deletePayMentBillSimple(PayMentBillPo po,LogisticsLogPo logPo);
	
	/**
	 * 反审核付款单(简)
	 */
	public boolean auditUnPayMentBillSimple(PayMentBillPo po,LogisticsLogPo logPo);
	
	/**
	 * 查询付款单(简)详情
	 */
	public PayMentBillPo getPayMentBillSimpleDetail(PayMentBillPo po);
	
	/**
	 * 查询付款单(简)明细详情
	 */
	public List<PayMentBillEntryPo> getPayMentBillSimpleEntryDetail(PayMentBillPo po);
	
	/**
	 * 查询采购单据总数
	 */
	public int getProcurementBillCount(PayMentBillPo po);

	/**
	 * 查询采购单据列表
	 */
	public List<PayMentBillPo> getProcurementBillList(PayMentBillPo po,int start,int size);
		
	/**
	 * 查询预付款单总数
	 */
	public int getAdvancePayMentBillCount(PayMentBillPo po);

	/**
	 * 查询预付款单列表
	 */
	public List<PayMentBillPo> getAdvancePayMentBillList(PayMentBillPo po,int start,int size);
	
	/**
	 * 查询所有制造商期末金额
	 */
	public String getSupplierAccount(SupplierPo po);
	
	/**
	 * 部分审核付款单
	 */
	public void partAuditPayMentBill(PayMentBillPo po,LogisticsLogPo logPo);
	
}
