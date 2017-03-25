/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : VoucherTallyMgrImpl.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2011-02-11
**/
package com.pengsheng.eims.yklogistics.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.yklogistics.dao.LogisticsLogDao;
import com.pengsheng.eims.yklogistics.dao.VoucherDao;
import com.pengsheng.eims.yklogistics.dao.VoucherTallyDao;
import com.pengsheng.eims.yklogistics.mgr.VoucherTallyMgr;
import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.SubjectPo;
import com.pengsheng.eims.logistics.persistence.VoucherEntryPo;
import com.pengsheng.eims.logistics.persistence.VoucherPo;
import com.pengsheng.eims.logistics.persistence.VoucherTallyPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public class VoucherTallyMgrImpl implements VoucherTallyMgr {
	
	private VoucherTallyDao ykvoucherTallyDao = null;
	private VoucherDao ykvoucherDao = null;
	private LogisticsLogDao yklogisticsLogDao = null;
	
	/**
	 * Description：根据参数判断记账凭证是否存在
	 * @param     ：凭证ID
	 * @return    ：返回记账凭证列表
	 */
	public List<VoucherTallyPo> getVoucherTallyByID(String voucherID){
		return ykvoucherTallyDao.getVoucherTallyByID(voucherID);		
	}	
	
	/**
	 * Description：新增记账凭证信息
	 * @param     ：记账凭证实体
	 */
	public void insertVoucherTally(List<VoucherTallyPo> poList,LogisticsLogPo logPo){
		Iterator<VoucherTallyPo> it = poList.iterator();
		while(it.hasNext()){
			VoucherTallyPo po = (VoucherTallyPo)it.next();
			ykvoucherTallyDao.insertVoucherTally(po);
		}
		
		yklogisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * Description：根据凭证ID查询单据（发票）、商品
	 * @param     ：凭证明细实体
	 * @return    ：返回单据（发票）、商品的列表
	 */
	public List<VoucherEntryPo> getBillsAndGoods(VoucherEntryPo po){		
		return ykvoucherTallyDao.getBillsAndGoods(po);
	}
	
	/**
	 * Description：查询暂估商品成本合计
	 * @param     ：单据号
	 * @return    ：返回暂估商品成本合计的字符串格式
	 */
	public String getNotTaxRateAmount(String billID){
		return ykvoucherTallyDao.getNotTaxRateAmount(billID);
	}
	public VoucherEntryPo getPercentThreeNotTaxRateAmount(VoucherEntryPo po){
		return ykvoucherTallyDao.getPercentThreeNotTaxRateAmount(po);
	}
	public VoucherEntryPo getPercentThreeReversalNotTaxRateAmount(VoucherEntryPo po){
		return ykvoucherTallyDao.getPercentThreeReversalNotTaxRateAmount(po);
	}
	public String getOtherGoodsNotTaxRateAmount(String billID,String otherGoodsBigClass){
		return ykvoucherTallyDao.getOtherGoodsNotTaxRateAmount(billID,otherGoodsBigClass);
	}
	
	/**
	 * Description：查询暂估商品成本合计
	 * @param     ：凭证号
	 * @return    ：返回暂估商品成本合计的字符串格式
	 */
	public String getNotTaxRateAmount(String voucherID,String typeID){
		return ykvoucherTallyDao.getNotTaxRateAmount(voucherID,typeID);
	}
	
	/**
	 * Description：查询冲回中的核销商品的成本合计
	 * @param     ：凭证明细实体
	 * @return    ：返回冲回中的核销商品的成本合计的字符串格式
	 */
	public VoucherEntryPo getReversalNotTaxRateAmountByBillID(VoucherEntryPo po){		
		return ykvoucherTallyDao.getReversalNotTaxRateAmountByBillID(po);
	}
	
	/**
	 * Description：查询冲回中的核销商品的成本合计
	 * @param     ：凭证明细实体
	 * @return    ：返回冲回中的核销商品的成本合计的字符串格式列表
	 */
	public VoucherEntryPo getReversalNotTaxRateAmountByInvoiceID(VoucherEntryPo po){
		return ykvoucherTallyDao.getReversalNotTaxRateAmountByInvoiceID(po);
	}
	
	/**
	 * Description：查询发票中的核销商品成本合计
	 * @param     ：发票号
	 * @return    ：返回发票中的核销商品成本合计的字符串格式
	 */
	public String getInvoiceNotTaxRateAmount(String billID){
		return ykvoucherTallyDao.getInvoiceNotTaxRateAmount(billID);
	}
	
	/**
	 * Description：查询未核销核销商品成本合计
	 * @param     ：凭证明细实体
	 * @return    ：返回未核销核销商品成本合计的字符串格式
	 */
	public String getNotInvoiceNotTaxRateAmount(VoucherEntryPo po){
		return ykvoucherTallyDao.getNotInvoiceNotTaxRateAmount(po);
	}
	
	/**
	 * Description：查询成本合计、税额合计、价税合计
	 * @param     ：发票号
	 * @return    ：返回符合条件的成本合计、税额合计、价税合计的列表
	 */
	public List<InvoiceEntryPo> getAmounts(String billID){
		return ykvoucherTallyDao.getAmounts(billID);
	}
	
	/**
	 * Description：根据参数修改凭证信息
	 * @param     ：凭证实体
	 */
	public void updateVoucherByID(VoucherPo voucherPo,List<VoucherTallyPo> poList,LogisticsLogPo logPo){
		ykvoucherTallyDao.updateVoucherByID(voucherPo);
		
		ykvoucherDao.deleteVoucherTallyByID(voucherPo.getsLvvID());
		
		Iterator<VoucherTallyPo> it = poList.iterator();
		while(it.hasNext()){
			VoucherTallyPo po = (VoucherTallyPo)it.next();			
			ykvoucherTallyDao.insertVoucherTally(po);
		}
		
		yklogisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * Description：根据参数查询经办人、结算方式
	 * @param     ：凭证实体
	 * @return    : 符合条件的经办人、结算方式
	 */
	public VoucherPo getBalanceMethodAndHandlePerson(String voucherID){
		return ykvoucherTallyDao.getBalanceMethodAndHandlePerson(voucherID);
	}
	
	/**
	 * Description：根据参数查询凭证模板
	 * @param     ：凭证实体
	 * @return    : 符合条件的凭证模板
	 */
	public List<VoucherTallyPo> getVoucherTempletByID(String voucherTypeID){
		return ykvoucherTallyDao.getVoucherTempletByID(voucherTypeID);
	}	

	/**
	 * Description：根据参数查询凭证模板可以被替换的部分
	 * @param     ：科目主键
	 * @return    : 符合条件的凭证模板
	 */
	public List<VoucherTallyPo> getReplaceVoucherTempletByID(String id){
		return ykvoucherTallyDao.getReplaceVoucherTempletByID(id);
	}
	
	/**
	 * Description：根据参数查询商品类型
	 * @param     ：id     科目主键
	 * @param     ：typeID 被替换的科目主键
	 * @return    : 符合条件的商品类型
	 */
	public String getGoodsCategoryByID(String id,String subjectID){
		return ykvoucherTallyDao.getGoodsCategoryByID(id,subjectID);
	}
	
	/**
	 * Description：根据参数查询商品的销售收入
	 * @param     ：shopCode     店号
	 * @param     ：salesDate    销售日期
	 * @return    : 符合条件的商品销售收入
	 */
	public String getSalesValueByID(String shopCode,String salesDate,String typeID){
		return ykvoucherTallyDao.getSalesValueByID(shopCode,salesDate,typeID);
	}
	public String getSalesValueByID(String billID){
		return ykvoucherTallyDao.getSalesValueByID(billID);
	}
	public String getSalesValueByID(String billID,String typeID){
		return ykvoucherTallyDao.getSalesValueByID(billID,typeID);
	}
	
	/**
	 * Description：根据参数查询商品的销售日期和店号
	 * @param     ：销售单号
	 * @return    : 符合条件的商品的销售日期和店号
	 */
	public InventoryPo getSalesDateAndShopCode(String billID){
		return ykvoucherTallyDao.getSalesDateAndShopCode(billID);
	}	
	
	/**
	 * Description：根据参数查询科目
	 * @param     ：科目实体
	 * @return    : 符合条件的科目列表
	 */
	public List<SubjectPo> getSubjectList(SubjectPo po,int start,int size){
	    return ykvoucherTallyDao.getSubjectList(po,start,size);
	}
	
	/**
	 * Description：根据参数查询科目总数
	 * @param     ：科目实体
	 * @return    : 符合条件的科目总数
	 */
	public int getSubjectCount(SubjectPo po){
		return ykvoucherTallyDao.getSubjectCount(po);
	}
	
	/**
	 * Description：根据参数查询店号
	 * @param     ：凭证明细实体
	 * @return    : 符合条件的店号
	 */
	public DepartmentsPo getShopCode(VoucherEntryPo po){
		return ykvoucherTallyDao.getShopCode(po);
	}
	public DepartmentsPo getInwarehouseName(VoucherEntryPo po){
		return ykvoucherTallyDao.getInwarehouseName(po);
	}
	public DepartmentsPo getOutwarehouseName(VoucherEntryPo po){
		return ykvoucherTallyDao.getOutwarehouseName(po);
	}
	
	public String getPanyingkuiNotTaxRateAmount(String billID){
		return ykvoucherTallyDao.getPanyingkuiNotTaxRateAmount(billID);
	}

	public VoucherTallyDao getYkvoucherTallyDao() {
		return ykvoucherTallyDao;
	}

	public void setYkvoucherTallyDao(VoucherTallyDao ykvoucherTallyDao) {
		this.ykvoucherTallyDao = ykvoucherTallyDao;
	}

	public VoucherDao getYkvoucherDao() {
		return ykvoucherDao;
	}

	public void setYkvoucherDao(VoucherDao ykvoucherDao) {
		this.ykvoucherDao = ykvoucherDao;
	}

	public LogisticsLogDao getYklogisticsLogDao() {
		return yklogisticsLogDao;
	}

	public void setYklogisticsLogDao(LogisticsLogDao yklogisticsLogDao) {
		this.yklogisticsLogDao = yklogisticsLogDao;
	}
		
}
