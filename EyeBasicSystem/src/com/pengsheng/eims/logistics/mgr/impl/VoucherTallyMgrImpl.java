/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : VoucherTallyMgrImpl.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2011-02-11
**/
package com.pengsheng.eims.logistics.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.dao.VoucherDao;
import com.pengsheng.eims.logistics.dao.VoucherTallyDao;
import com.pengsheng.eims.logistics.mgr.VoucherTallyMgr;
import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.SubjectPo;
import com.pengsheng.eims.logistics.persistence.VoucherEntryPo;
import com.pengsheng.eims.logistics.persistence.VoucherPo;
import com.pengsheng.eims.logistics.persistence.VoucherTallyPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public class VoucherTallyMgrImpl implements VoucherTallyMgr {
	
	private VoucherTallyDao voucherTallyDao = null;
	private VoucherDao voucherDao = null;
	private LogisticsLogDao logisticsLogDao = null;
	
	/**
	 * Description：根据参数判断记账凭证是否存在
	 * @param     ：凭证ID
	 * @return    ：返回记账凭证列表
	 */
	public List<VoucherTallyPo> getVoucherTallyByID(String voucherID){
		return voucherTallyDao.getVoucherTallyByID(voucherID);		
	}	
	
	/**
	 * Description：新增记账凭证信息
	 * @param     ：记账凭证实体
	 */
	public void insertVoucherTally(List<VoucherTallyPo> poList,LogisticsLogPo logPo){
		Iterator<VoucherTallyPo> it = poList.iterator();
		while(it.hasNext()){
			VoucherTallyPo po = (VoucherTallyPo)it.next();
			voucherTallyDao.insertVoucherTally(po);
		}
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * Description：根据凭证ID查询单据（发票）、商品
	 * @param     ：凭证明细实体
	 * @return    ：返回单据（发票）、商品的列表
	 */
	public List<VoucherEntryPo> getBillsAndGoods(VoucherEntryPo po){		
		return voucherTallyDao.getBillsAndGoods(po);
	}
	
	/**
	 * Description：查询暂估商品成本合计
	 * @param     ：单据号
	 * @return    ：返回暂估商品成本合计的字符串格式
	 */
	public String getNotTaxRateAmount(String billID){
		return voucherTallyDao.getNotTaxRateAmount(billID);
	}
	public VoucherEntryPo getPercentThreeNotTaxRateAmount(VoucherEntryPo po){
		return voucherTallyDao.getPercentThreeNotTaxRateAmount(po);
	}
	public VoucherEntryPo getPercentThreeReversalNotTaxRateAmount(VoucherEntryPo po){
		return voucherTallyDao.getPercentThreeReversalNotTaxRateAmount(po);
	}
	public String getOtherGoodsNotTaxRateAmount(String billID,String otherGoodsBigClass){
		return voucherTallyDao.getOtherGoodsNotTaxRateAmount(billID,otherGoodsBigClass);
	}
	
	/**
	 * Description：查询暂估商品成本合计
	 * @param     ：凭证号
	 * @return    ：返回暂估商品成本合计的字符串格式
	 */
	public String getNotTaxRateAmount(String voucherID,String typeID){
		return voucherTallyDao.getNotTaxRateAmount(voucherID,typeID);
	}
	
	/**
	 * Description：查询冲回中的核销商品的成本合计
	 * @param     ：凭证明细实体
	 * @return    ：返回冲回中的核销商品的成本合计的字符串格式
	 */
	public VoucherEntryPo getReversalNotTaxRateAmountByBillID(VoucherEntryPo po){		
		return voucherTallyDao.getReversalNotTaxRateAmountByBillID(po);
	}
	
	/**
	 * Description：查询冲回中的核销商品的成本合计
	 * @param     ：凭证明细实体
	 * @return    ：返回冲回中的核销商品的成本合计的字符串格式列表
	 */
	public VoucherEntryPo getReversalNotTaxRateAmountByInvoiceID(VoucherEntryPo po){
		return voucherTallyDao.getReversalNotTaxRateAmountByInvoiceID(po);
	}
	
	/**
	 * Description：查询发票中的核销商品成本合计
	 * @param     ：发票号
	 * @return    ：返回发票中的核销商品成本合计的字符串格式
	 */
	public String getInvoiceNotTaxRateAmount(String billID){
		return voucherTallyDao.getInvoiceNotTaxRateAmount(billID);
	}
	
	/**
	 * Description：查询未核销核销商品成本合计
	 * @param     ：凭证明细实体
	 * @return    ：返回未核销核销商品成本合计的字符串格式
	 */
	public String getNotInvoiceNotTaxRateAmount(VoucherEntryPo po){
		return voucherTallyDao.getNotInvoiceNotTaxRateAmount(po);
	}
	
	/**
	 * Description：查询成本合计、税额合计、价税合计
	 * @param     ：发票号
	 * @return    ：返回符合条件的成本合计、税额合计、价税合计的列表
	 */
	public List<InvoiceEntryPo> getAmounts(String billID){
		return voucherTallyDao.getAmounts(billID);
	}
	
	/**
	 * Description：根据参数修改凭证信息
	 * @param     ：凭证实体
	 */
	public void updateVoucherByID(VoucherPo voucherPo,List<VoucherTallyPo> poList,LogisticsLogPo logPo){
		voucherTallyDao.updateVoucherByID(voucherPo);
		
		voucherDao.deleteVoucherTallyByID(voucherPo.getsLvvID());
		
		Iterator<VoucherTallyPo> it = poList.iterator();
		while(it.hasNext()){
			VoucherTallyPo po = (VoucherTallyPo)it.next();			
			voucherTallyDao.insertVoucherTally(po);
		}
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * Description：根据参数查询经办人、结算方式
	 * @param     ：凭证实体
	 * @return    : 符合条件的经办人、结算方式
	 */
	public VoucherPo getBalanceMethodAndHandlePerson(String voucherID){
		return voucherTallyDao.getBalanceMethodAndHandlePerson(voucherID);
	}
	
	/**
	 * Description：根据参数查询凭证模板
	 * @param     ：凭证实体
	 * @return    : 符合条件的凭证模板
	 */
	public List<VoucherTallyPo> getVoucherTempletByID(String voucherTypeID){
		return voucherTallyDao.getVoucherTempletByID(voucherTypeID);
	}	

	/**
	 * Description：根据参数查询凭证模板可以被替换的部分
	 * @param     ：科目主键
	 * @return    : 符合条件的凭证模板
	 */
	public List<VoucherTallyPo> getReplaceVoucherTempletByID(String id){
		return voucherTallyDao.getReplaceVoucherTempletByID(id);
	}
	
	/**
	 * Description：根据参数查询商品类型
	 * @param     ：id     科目主键
	 * @param     ：typeID 被替换的科目主键
	 * @return    : 符合条件的商品类型
	 */
	public String getGoodsCategoryByID(String id,String subjectID){
		return voucherTallyDao.getGoodsCategoryByID(id,subjectID);
	}
	
	/**
	 * Description：根据参数查询商品的销售收入
	 * @param     ：shopCode     店号
	 * @param     ：salesDate    销售日期
	 * @return    : 符合条件的商品销售收入
	 */
	public String getSalesValueByID(String shopCode,String salesDate,String typeID){
		return voucherTallyDao.getSalesValueByID(shopCode,salesDate,typeID);
	}
	public String getSalesValueByID(String billID){
		return voucherTallyDao.getSalesValueByID(billID);
	}
	public String getSalesValueByID(String billID,String typeID){
		return voucherTallyDao.getSalesValueByID(billID,typeID);
	}
	
	/**
	 * Description：根据参数查询商品的销售日期和店号
	 * @param     ：销售单号
	 * @return    : 符合条件的商品的销售日期和店号
	 */
	public InventoryPo getSalesDateAndShopCode(String billID){
		return voucherTallyDao.getSalesDateAndShopCode(billID);
	}	
	
	/**
	 * Description：根据参数查询科目
	 * @param     ：科目实体
	 * @return    : 符合条件的科目列表
	 */
	public List<SubjectPo> getSubjectList(SubjectPo po,int start,int size){
	    return voucherTallyDao.getSubjectList(po,start,size);
	}
	
	/**
	 * Description：根据参数查询科目总数
	 * @param     ：科目实体
	 * @return    : 符合条件的科目总数
	 */
	public int getSubjectCount(SubjectPo po){
		return voucherTallyDao.getSubjectCount(po);
	}
	
	/**
	 * Description：根据参数查询店号
	 * @param     ：凭证明细实体
	 * @return    : 符合条件的店号
	 */
	public DepartmentsPo getShopCode(VoucherEntryPo po){
		return voucherTallyDao.getShopCode(po);
	}
	public DepartmentsPo getInwarehouseName(VoucherEntryPo po){
		return voucherTallyDao.getInwarehouseName(po);
	}
	public DepartmentsPo getOutwarehouseName(VoucherEntryPo po){
		return voucherTallyDao.getOutwarehouseName(po);
	}
	
	/**
	 * Description：创建付款单凭证
	 * @param     ：voucherID 凭证号
	 * @param     ：supplierName 摘要
	 * @param     ：voucherType 凭证类型
	 * @return    : 符合条件的凭证模板
	 */
	public List<VoucherTallyPo> getVoucherTallyByID(VoucherPo po,String supplierName){
		return voucherTallyDao.getVoucherTallyByID(po,supplierName);
	}
	
	/**
	 * Description：根据科目查询凭证模板总数
	 * @param     ：科目实体
	 * @return    : 符合条件的总数
	 */
	public int getVoucherTemplateCount(String voucherType){
	    return 	voucherTallyDao.getVoucherTemplateCount(voucherType);
	}
	
	/**
	 * Description：根据参数查询科目
	 * @param     ：科目实体
	 * @return    : 符合条件的科目列表
	 */
	public SubjectPo getSubjectDetail(SubjectPo po){
		return 	voucherTallyDao.getSubjectDetail(po);
	}
	
	public VoucherDao getVoucherDao() {
		return voucherDao;
	}
	public void setVoucherDao(VoucherDao voucherDao) {
		this.voucherDao = voucherDao;
	}
	public VoucherTallyDao getVoucherTallyDao() {
		return voucherTallyDao;
	}
	public void setVoucherTallyDao(VoucherTallyDao voucherTallyDao) {
		this.voucherTallyDao = voucherTallyDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
}
