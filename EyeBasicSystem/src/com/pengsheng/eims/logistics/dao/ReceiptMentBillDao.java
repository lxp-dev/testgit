/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : PayMentBillDao.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2012-05-04
**/
package com.pengsheng.eims.logistics.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.persistence.ReceiptMentBillEntryPo;
import com.pengsheng.eims.logistics.persistence.ReceiptMentBillPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.TracPo;

public interface ReceiptMentBillDao {
	
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
	public void insertReceiptMentBill(ReceiptMentBillPo po);
	
	/**
	 * 新增收款单明细
	 */
	public void insertReceiptMentBillEntry(ReceiptMentBillEntryPo epo);
	
	/**
	 * 修改收款单
	 */
	public void updateReceiptMentBill(ReceiptMentBillPo po);
	
	/**
	 * 删除收款单
	 */
	public void deleteReceiptMentBill(ReceiptMentBillPo po);
	
	/**
	 * 删除收款单明细
	 */
	public void deleteReceiptMentBillEntry(ReceiptMentBillPo po);
	
	/**
	 * 反审核收款单
	 */
	public int unAuditReceiptMentBill(ReceiptMentBillPo po);
	
	/**
	 * 审核收款单
	 */
	public int auditReceiptMentBill(ReceiptMentBillPo po);
	
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
	 * 新增客户往来账明细
	 */
	public void insertFranchiseeCurrentAccountDetail(ReceiptMentBillPo po);
	
	/**
	 * 删除客户往来账明细
	 */
	public void deleteFranchiseeCurrentAccountDetail(ReceiptMentBillPo po);
	
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
