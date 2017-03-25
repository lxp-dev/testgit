/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : VoucherDao.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2011-02-11
**/
package com.pengsheng.eims.logistics.dao;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.AutoCostAccountPo;
import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.InvoicePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.SalesShopPo;
import com.pengsheng.eims.logistics.persistence.VoucherEntryPo;
import com.pengsheng.eims.logistics.persistence.VoucherPo;
import com.pengsheng.eims.logistics.persistence.VoucherTallyPo;
import com.pengsheng.eims.logistics.persistence.VoucherTypePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface VoucherDao {
	/**
	 * Description：根据参数查询父类凭证类型是当前参数的详细信息
	 * @param     ：父类凭证类型ID
	 * @return    ：返回符合条件的凭证类型列表
	 */
	public List<VoucherTypePo> getVoucherTypeByID(String parentID);
	
	/**
	 * Description：根据参数查询凭证总数
	 * @param     ：凭证实体
	 * @return    ：返回符合条件的凭证总数
	 */
	public int getVoucherCount(VoucherPo po);
	
	/**
	 * Description：根据参数查询凭证信息
	 * @param     ：VoucherPo 凭证实体
	 * @param     ：start 开始行数
	 * @param     ：size  每页显示行数
	 * @return    ：返回符合条件的凭证信息列表
	 */
	public List<VoucherPo> getVoucherList(VoucherPo po,int start, int size);	
	
	/**
	 * Description：根据参数查询凭证信息
	 * @param     ：VoucherPo 凭证实体
	 * @return    ：返回符合条件的凭证信息列表
	 */
	public List<VoucherPo> getVoucherList(VoucherPo po);
	
	/**
	 * Description：根据参数查询其父类凭证类型ID
	 * @param     ：凭证ID
	 * @return    ：返回符合条件的凭证类型列表
	 */
	public List<VoucherTypePo> getVoucherParentTypeByID(String voucherID);
	
	/**
	 * Description：根据参数删除凭证信息
	 * @param     ：凭证ID
	 */
	public void deleteVoucherByID(String voucherID);
	
	/**
	 * Description：根据参数删除凭证明细信息
	 * @param     ：凭证ID
	 */
	public void deleteVoucherEntryByID(String voucherID);
	
	/**
	 * Description：根据参数删除记账凭证信息
	 * @param     ：凭证ID
	 */
	public void deleteVoucherTallyByID(String voucherID);
	
	/**
	 * Description：根据参数修改凭证信息
	 * @param     ：凭证ID
	 */
	public void updateVoucherByID(VoucherPo voucherPo);
	
	/**
	 * Description：根据参数修改凭证明细信息
	 * @param     ：凭证ID
	 */
	public void updateVoucherEntryByID(VoucherEntryPo po);
	
	/**
	 * Description：根据参数查询其父类凭证类型名称
	 * @param     ：凭证ID
	 * @return    ：返回符合条件的凭证类型类型名称
	 */
	public String getVoucherTypeName(String id);
	
	/**
	 * Description：根据参数查询凭证明细(单据)信息总数
	 * @param     ：凭证明细实体
	 * @return    ：返回符合条件的凭证明细(单据)信息总数
	 */	
	public int getVoucherEntryByBillsCount(VoucherEntryPo po);
	
	/**
	 * Description：根据参数查询凭证明细(单据)信息
	 * @param     ：VoucherEntryPo 凭证明细实体
	 * @param     ：start 开始行数
	 * @param     ：size  每页显示行数
	 * @return    ：返回符合条件的凭证明细(单据)信息列表
	 */
	public List<VoucherEntryPo> getVoucherEntryByBillsList(VoucherEntryPo po,int start, int size);
	
	/**
	 * Description：根据参数查询凭证明细(单据)信息
	 * @param     ：VoucherEntryPo 凭证明细实体
	 * @return    ：返回符合条件的凭证明细(单据)信息列表
	 */
	public List<VoucherEntryPo> getVoucherEntryByBillsList(VoucherEntryPo po);
	
	/**
	 * Description：新增凭证
	 * @param     ：凭证实体
	 */
	public void insertVoucher(VoucherPo po);
	
	/**
	 * Description：新增凭证明细
	 * @param     ：凭证明细实体
	 */
	public void insertVoucherEntry(VoucherEntryPo po);
	public VoucherPo selVoucherAmount(VoucherPo po);
	public void updateVoucherAmount(VoucherPo po);
	
	/**
	 * Description：查询发票基本信息
	 * @param     ：凭证号
	 * @param     ：start 开始行数
	 * @param     ：size  每页显示行数
     * @return    ：返回符合条件的发票列表
	 */
	public List<VoucherEntryPo> getInvoiceList(String voucherID,int start, int size);
	
	/**
	 * Description：查询发票基本信息
	 * @param     ：凭证号
     * @return    ：返回符合条件的发票列表
	 */
	public List<VoucherEntryPo> getInvoiceList(String voucherID);
	
	/**Description：符合条件的发票总数
	 * @param     ：凭证号
     * @return    ：返回符合条件的发票总数
	 */
	public int getInvoiceCount(String voucherID);
	
	/**
	 * Description：查询符合条件的冲回记录总数
	 * @param     ：凭证号
     * @return    ：返回符合条件的冲回记录总数
	 */
	public int getReversalCount(String voucherID);	

	/**
	 * Description：查询符合条件的冲回明细信息
	 * @param     ：冲回实体
	 * @param     ：start 开始行数
	 * @param     ：size  每页显示行数
     * @return    ：返回符合条件的冲回明细信息
	 */
	public List<InvoiceEntryPo> getReversalEntryPoList(InvoiceEntryPo po,int start, int size);
	public List<InvoiceEntryPo> getReversalEntryPoList(InvoiceEntryPo po);
	
	/**
	 * Description：查询符合条件的冲回明细总数
	 * @param     ：冲回实体
     * @return    ：返回符合条件的冲回明细总数
	 */
	public int getReversalEntryCount(InvoiceEntryPo po);
	
	/**
	 * Description：查询冲回基本信息
	 * @param     ：冲回号
     * @return    ：返回符合条件的冲回信息
	 */
	public InvoicePo getReversalPo(InvoicePo po);	
	
	/**
	 * Description：查询冲回基本信息
	 * @param     ：凭证号
	 * @param     ：start 开始行数
	 * @param     ：size  每页显示行数
     * @return    ：返回符合条件的冲回列表
	 */
	public List<VoucherEntryPo> getReversalList(String voucherID,int start, int size);
	
	/**
	 * Description：查询冲回基本信息
	 * @param     ：凭证号
     * @return    ：返回符合条件的冲回列表
	 */
	public List<VoucherEntryPo> getReversalList(String voucherID);
	
	/**
	 * Description：根据单据号得到商品明细信息
	 * @param     ：单据号数组
	 * @return    ：返回符合条件的商品明细列表
	 */
	public List<VoucherEntryPo> getBillGoods(VoucherEntryPo po);
	public List<VoucherEntryPo> getOtherInAndOutStorageBillGoods(VoucherEntryPo po);
	public List<VoucherEntryPo> getSalesBillGoods(VoucherEntryPo po);
	
	/**
	 * Description：根据单据号得到商品明细信息
	 * @param     ：单据号数组
	 * @return    ：返回符合条件的商品明细列表
	 */
	public List<VoucherEntryPo> getCheckStorgeBillGoods(VoucherEntryPo po);
	
	/**
	 * Description：根据单据号锁定单据
	 * @param     ：凭证明细实体
	 */
	public void lockBills(VoucherEntryPo voucherEntryPo,String type);
	
	/**
	 * Description：根据发票号锁定发票
	 * @param     ：凭证明细实体
	 */
	public void lockInvoices(VoucherEntryPo voucherEntryPo);
	
	/**
	 * Description：根据冲回号锁定冲回记录
	 * @param     ：凭证明细实体
	 */
	public void lockReversals(VoucherEntryPo voucherEntryPo);
	
	/**
	 * Description：根据发票号锁定单据
	 * @param     ：凭证明细实体
	 */
	public void lockBillsByInvoiceID(VoucherEntryPo po);
	
	/**
	 * Description：根据冲回号锁定单据
	 * @param     ：凭证明细实体
	 */
	public void lockBillsByReversalID(VoucherEntryPo po);
	
	/**
	 * Description：根据审核人ID查询审核人名称
	 * @param     ：审核人ID
	 * @return    : 返回审核人名称
	 */
	public String getAuditPersonNameByID(String auditPersonID);
	
	/**
	 * Description：根据发票号查询核销的商品代码
	 * @param     ：发票号
	 * @return    : 返回商品代码
	 */
	public List<VoucherEntryPo> getGoodsIdByInvoiceID(String invoiceID);
	
	/**
	 * Description：根据冲回号查询核销的商品代码
	 * @param     ：冲回号
	 * @return    : 返回商品代码
	 */
	public List<VoucherEntryPo> getGoodsIdByReversalID(String reversalID);
	
	/**
	 * Description：根据发票号查询发票信息
	 * @param     ：旧发票列表
     * @param     ：发票号数组
	 * @return    : 返回发票信息
	 */
	public List<VoucherEntryPo> getInvoiceListByID(VoucherEntryPo po);
	
	
	/**
	 * Description：根据冲回号查询冲回信息
	 * @param     ：voucherEntryList 旧冲回列表
     * @param     ：bills 冲回号数组
	 * @return    : 返回冲回信息
	 */
	public List<VoucherEntryPo> getReversalListByID(VoucherEntryPo po);
	
	/**
	 * Description：根据发票号查询成本合计、价税合计、税额合计
	 * @param     ：发票号
	 * @return    : 返回发票的成本合计、价税合计、税额合计
	 */
	public VoucherPo getAmountByInvoiceID(String invoiceID);
	
	/**
	 * Description：根据冲回号查询成本合计、价税合计、税额合计
	 * @param     ：冲回号
	 * @return    : 返回冲回的成本合计、价税合计、税额合计
	 */
	public VoucherPo getAmountByReversalID(String reversalID);	
	
	/**
	 * Description：根据单据号解锁单据
	 * @param     ：凭证明细实体
	 */
	public void notLockBills(String voucherID,String voucherType);
	
	/**
	 * Description：根据发票号解锁发票
	 * @param     ：凭证明细实体
	 */
	public void notLockInvoices(String voucherID);
	
	/**
	 * Description：根据冲回号解锁冲回记录
	 * @param     ：凭证明细实体
	 */
	public void notLockReversals(String voucherID);	
	
	/**
	 * Description：根据发票号解锁单据
	 * @param     ：凭证号
	 */
	public void notLockBillByInvoiceID(String voucherID);
	
	/**
	 * Description：根据冲回号解锁单据
	 * @param     ：凭证号
	 */
	public void notLockBillByReversalID(String voucherID);
	
	/**
	 * Description：根据凭证号查询凭证类型
	 * @param     ：凭证号
	 * @return    : 返回凭证类型
	 */
	public String getVoucherTypeByVoucherID(String voucherID);	
	
	/**
	 * Description：查询所有门店
	 * @return    : 返回所有门店
	 */
	public List<SalesShopPo> getSalesShopList();	
	
	/**
	 * Description：凭证过账(新中大)
	 * @param     ：凭证号
	 */
	public void voucherPosting(String vouchersID,String companyID,String flag);
	
	/**
	 * Description：凭证过账(用友)
	 * @param     ：凭证号
	 */
	public void yy_VoucherPosting(String vouchersID);
	
	/**
	 * Description：修改凭证过账标识
	 * @param     ：凭证号
	 */
	public void updateVoucherPosting(String voucherID);
	
	/**
	 * 得到业务表信息数量
	 * @param invoicePo
	 * @return
	 */
	public int getSelectBillCount(InventoryPo inventoryPo);
	
	/**
	 * 查询业务表信息List
	 * @param invoicePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> selectSelectBill(InventoryPo inventoryPo , int start , int size);	
	
	/**
	 * 得到发票和冲回信息数量
	 * @param invoicePo
	 * @return
	 */
	public int getSelInvoiceAndReversalCount(InventoryPo po);
	
	/**
	 * 查询发票和冲回信息List
	 * @param invoicePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> selInvoiceAndReversal(InventoryPo po , int start , int size);
	
	/**
	 * 新增出库凭证
	 * @param po
	 * @return
	 */
	public void insertOutStrogeVoucher(VoucherPo po);
	public void insertOutStrogeVoucherEntry(VoucherEntryPo po);
	
	/**
	 * 查询出库凭证
	 * @param invoicePo
	 * @return
	 */
	public List<VoucherPo> selOutStrogeVoucher(VoucherPo po,int start,int size);
	
	/**
	 * 查询出库凭证总数
	 * @param invoicePo
	 * @return
	 */
	public int selOutStrogeVoucherCount(VoucherPo po);
	
	/**
	 * 查询出库成本和销售收入
	 * @param invoicePo
	 * @return
	 */
	public VoucherEntryPo getOutStrogeAmount(String voucherPo);
	
	/**
	 * 查询当前账期
	 */
	public VoucherPo selCurrentAccountPeriod(String companyID);
	
	/**
	 * 开关账
	 */
	public void switchAmount(String month,String flag,String companyID);
	
	/**
	 * 查询未作账的单据总数
	 */
	public int selBillWhetherSettleAccountsCount(String date,String billType);
	
	/**
	 * 查询未作账的单据列表
	 */
	public List<InventoryEntryPo> selBillWhetherSettleAccounts(String date,String billType,int start,int size);
	
	/**
	 * 查询销售出库凭证总数
	 */
	public int getSalesOutStorageVoucherCount(VoucherPo po);
	
	/**
	 * 查询销售出库凭证列表
	 */
	public List<VoucherEntryPo> getSalesOutStorageVoucherList(VoucherPo po,int start,int size);
	public List<VoucherEntryPo> getSalesOutStorageVoucherList(VoucherPo po);
	
	/**
	 * 修改销售出库凭证
	 */
	public void updateSalesOutStorageVoucher(VoucherPo po);
	
	/**
	 * 获取当前需要传输的财物软件的路径
	 */
	public String getCurrentFinanceSoftwarePath();
	
/*********************************************************************************************/
	
	/**
	 * Description：根据参数查询记账凭证总数
	 * @param     ：凭证实体
	 * @return    ：返回符合条件的记账凭证总数
	 */
	public int getVoucherTallyCount(VoucherPo po);
	
	/**
	 * Description：根据参数查询记账凭证信息
	 * @param     ：VoucherPo 凭证实体
	 * @param     ：start 开始行数
	 * @param     ：size  每页显示行数
	 * @return    ：返回符合条件的记账凭证信息列表
	 */
	public List<VoucherPo> getVoucherTallyList(VoucherPo po,int start, int size);
	
	/**
	 * 新增记账凭证
	 */
	public void insertVoucherTally(VoucherPo po);
	
	/**
	 * 新增记账凭证
	 */
	public void insertVoucherTallyEntry(VoucherTallyPo voucherTallyPo);
	
	/**
	 * 修改记账凭证
	 */
	public void updateVoucherTally(VoucherPo po);
	
	/**
	 * 反审核记账凭证
	 */
	public void auditVoucherTally(VoucherPo po);
	
	/**
	 * 获取记账凭证
	 */
	public VoucherPo getVoucherTallyDetail(VoucherPo po);
	
	/**
	 * 获取记账凭证明细
	 */
	public List<VoucherTallyPo> getVoucherTallyEntryDetail(VoucherPo po);
	
	/**
	 * 判断是否过进行成本计算
	 */
	public int isCostAccount();
	
	/**
	 * Description：获取存在凭证模板的凭证类型
	 */
	public List<VoucherTypePo> getVoucherTypeByExitsID();
	
	/**
	 * 查询成本计算日志
	 */
	public List<AutoCostAccountPo> selectAutoCostAccountList(String companyID);
	
	/**
	 * 根据当前日期查询所属账期
	 */
	public String getCurrentAccountPeriodByDate(String companyID);
	
	/**
	 * 查询当前账期是否做过成本计算
	 */
	public int getCurrZqCbjsCount(String date,String companyID);
	
}
