/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : ReceiptMentBillMgr.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2013-04-28
**/
package com.pengsheng.eims.logistics.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.ReceiptMentBillEntryPo;
import com.pengsheng.eims.logistics.persistence.ReceiptMentBillPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.TracPo;

public interface ReceiptMentBillMgr{
	
	/**
	 * 查询收款单总数
	 */
	public int getReceiptMentBillCount(ReceiptMentBillPo po);

	/**
	 * 查询收款单列表
	 */
	public List<ReceiptMentBillPo> getReceiptMentBillList(ReceiptMentBillPo po,int start,int size);
	
	/**
	 * 新增收款单
	 */
	public void insertReceiptMentBill(ReceiptMentBillPo po,List<ReceiptMentBillEntryPo> epo,LogisticsLogPo logPo);
	
	/**
	 * 修改收款单
	 */
	public void updateReceiptMentBill(ReceiptMentBillPo po,List<ReceiptMentBillEntryPo> epo,LogisticsLogPo logPo);
	
	/**
	 * 删除收款单
	 */
	public void deleteReceiptMentBill(ReceiptMentBillPo po,LogisticsLogPo logPo);
	
	/**
	 * 反审核收款单
	 */
	public boolean unAuditReceiptMentBill(ReceiptMentBillPo po,LogisticsLogPo logPo);
	
	/**
	 * 审核收款单
	 */
	public boolean auditReceiptMentBill(ReceiptMentBillPo po,LogisticsLogPo logPo);
	
	/**
	 * 查询收款单详情
	 */
	public ReceiptMentBillPo getReceiptMentBillDetail(ReceiptMentBillPo po);
	
	/**
	 * 查询收款单明细详情
	 */
	public List<ReceiptMentBillEntryPo> getReceiptMentBillEntryDetail(ReceiptMentBillPo po);
	
	/**
	 * 查询客户总数
	 */
	public int getFranchiseeCount(ReceiptMentBillPo po);
	
	/**
	 * 获取客户列表
	 */
	public List<DepartmentsPo> getFranchiseeList(ReceiptMentBillPo po,int start,int size);	

	/**
	 * 查询客户往来账明细
	 */
	public List<InventoryPo> getFranchiseeCurrentAccountDetail(ReceiptMentBillPo po);
	
	
	/**
	 * 查询客户批发调货单总数
	 */
	public int getFranchiseeAllocationBillCount(TracPo po);
	
	/**
	 * 查询客户批发调货单总数
	 */
	public List<TracPo> getFranchiseeAllocationBillList(TracPo po,int start,int size);	
	
	/**
	 * 应收款总余额
	 */
	public String getFranchiseeAccount(ReceiptMentBillPo po);
}
