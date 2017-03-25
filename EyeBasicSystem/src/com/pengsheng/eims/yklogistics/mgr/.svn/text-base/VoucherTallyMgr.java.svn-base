/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : VoucherTallyMgr.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2011-02-11
**/
package com.pengsheng.eims.yklogistics.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.SubjectPo;
import com.pengsheng.eims.logistics.persistence.VoucherEntryPo;
import com.pengsheng.eims.logistics.persistence.VoucherPo;
import com.pengsheng.eims.logistics.persistence.VoucherTallyPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface VoucherTallyMgr {
	
	/**
	 * Description：根据参数判断记账凭证是否存在
	 * @param     ：凭证ID
	 * @return    ：返回记账凭证列表
	 */
	public List<VoucherTallyPo> getVoucherTallyByID(String voucherID);
	
	/**
	 * Description：新增记账凭证信息
	 * @param     ：记账凭证实体
	 */
	public void insertVoucherTally(List<VoucherTallyPo> poList,LogisticsLogPo logPo);
	
	/**
	 * Description：根据凭证ID查询单据（发票）、商品
	 * @param     ：凭证明细实体
	 * @return    ：返回单据（发票）、商品的列表
	 */
	public List<VoucherEntryPo> getBillsAndGoods(VoucherEntryPo po);
	
	/**
	 * Description：查询暂估商品成本合计
	 * @param     ：凭证明细实体
	 * @return    ：返回暂估商品成本合计的字符串格式
	 */
	public String getNotTaxRateAmount(String billID);
	public VoucherEntryPo getPercentThreeNotTaxRateAmount(VoucherEntryPo po);
	public VoucherEntryPo getPercentThreeReversalNotTaxRateAmount(VoucherEntryPo po);
	public String getOtherGoodsNotTaxRateAmount(String billID,String otherGoodsBigClass);
	
	/**
	 * Description：查询暂估商品成本合计
	 * @param     ：凭证号
	 * @return    ：返回暂估商品成本合计的字符串格式
	 */
	public String getNotTaxRateAmount(String voucherID,String typeID);
	
	/**
	 * Description：查询冲回中的核销商品的成本合计
	 * @param     ：凭证明细实体
	 * @return    ：返回冲回中的核销商品的成本合计的字符串格式
	 */
	public VoucherEntryPo getReversalNotTaxRateAmountByBillID(VoucherEntryPo po);
	
	/**
	 * Description：查询冲回中的核销商品的成本合计
	 * @param     ：凭证明细实体
	 * @return    ：返回冲回中的核销商品的成本合计的字符串格式列表
	 */
	public VoucherEntryPo getReversalNotTaxRateAmountByInvoiceID(VoucherEntryPo po);
	
	/**
	 * Description：查询发票中的核销商品成本合计
	 * @param     ：发票号
	 * @return    ：返回发票中的核销商品成本合计的字符串格式
	 */
	public String getInvoiceNotTaxRateAmount(String billID);
	
	/**
	 * Description：查询未核销核销商品成本合计
	 * @param     ：凭证明细实体
	 * @return    ：返回未核销核销商品成本合计的字符串格式
	 */
	public String getNotInvoiceNotTaxRateAmount(VoucherEntryPo po);
	
	/**
	 * Description：查询成本合计、税额合计、价税合计
	 * @param     ：发票号
	 * @return    ：返回符合条件的成本合计、税额合计、价税合计的列表
	 */
	public List<InvoiceEntryPo> getAmounts(String billID);
	
	/**
	 * Description：根据参数修改凭证信息
	 * @param     ：凭证实体
	 */
	public void updateVoucherByID(VoucherPo voucherPo,List<VoucherTallyPo> poList,LogisticsLogPo logPo);
	
	/**
	 * Description：根据参数查询经办人、结算方式
	 * @param     ：凭证实体
	 * @return    : 符合条件的经办人、结算方式
	 */
	public VoucherPo getBalanceMethodAndHandlePerson(String voucherID);
	
	/**
	 * Description：根据参数查询凭证模板
	 * @param     ：凭证实体
	 * @return    : 符合条件的凭证模板
	 */
	public List<VoucherTallyPo> getVoucherTempletByID(String voucherTypeID);
	
	/**
	 * Description：根据参数查询凭证模板可以被替换的部分
	 * @param     ：科目主键
	 * @return    : 符合条件的凭证模板
	 */
	public List<VoucherTallyPo> getReplaceVoucherTempletByID(String id);
	
	/**
	 * Description：根据参数查询商品类型
	 * @param     ：id     科目主键
	 * @param     ：typeID 被替换的科目主键
	 * @return    : 符合条件的商品类型
	 */
	public String getGoodsCategoryByID(String id,String subjectID);
	
	/**
	 * Description：根据参数查询商品的销售收入
	 * @param     ：shopCode     店号
	 * @param     ：salesDate    销售日期
	 * @return    : 符合条件的商品销售收入
	 */
	public String getSalesValueByID(String shopCode,String salesDate,String typeID);
	public String getSalesValueByID(String billID);
	public String getSalesValueByID(String billID,String typeID);
	
	/**
	 * Description：根据参数查询商品的销售日期和店号
	 * @param     ：销售单号
	 * @return    : 符合条件的商品的销售日期和店号
	 */
	public InventoryPo getSalesDateAndShopCode(String billID);
	
	/**
	 * Description：根据参数查询科目
	 * @param     ：科目实体
	 * @return    : 符合条件的科目列表
	 */
	public List<SubjectPo> getSubjectList(SubjectPo po,int start,int size);	
	
	/**
	 * Description：根据参数查询科目总数
	 * @param     ：科目实体
	 * @return    : 符合条件的科目总数
	 */
	public int getSubjectCount(SubjectPo po);	
	
	/**
	 * Description：根据参数查询店号
	 * @param     ：凭证明细实体
	 * @return    : 符合条件的店号
	 */
	public DepartmentsPo getShopCode(VoucherEntryPo po);
	public DepartmentsPo getInwarehouseName(VoucherEntryPo po);
	public DepartmentsPo getOutwarehouseName(VoucherEntryPo po);
	
	/**
	 * Description：获取盘盈盘亏的总成本
	 * @param     ：凭证号
	 * @return    : 
	 */	
	public String getPanyingkuiNotTaxRateAmount(String billID);
	
}
