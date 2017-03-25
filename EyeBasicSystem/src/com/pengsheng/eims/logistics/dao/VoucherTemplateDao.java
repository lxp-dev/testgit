/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : VoucherTemplateDao.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2012-05-04
**/
package com.pengsheng.eims.logistics.dao;

import java.util.List;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.SubjectPo;
import com.pengsheng.eims.logistics.persistence.VoucherTempletPo;
import com.pengsheng.eims.system.persistence.ExportAmountLogPo;
import com.pengsheng.eims.system.persistence.FuctionTreeNode;

public interface VoucherTemplateDao{
	/**
	 * 查询科目总数
	 */
	public int getSubjectCount(SubjectPo po);

	/**
	 * 查询科目列表
	 */
	public List<SubjectPo> getSubjectList(SubjectPo po,int start,int size);
	
	/**
	 * 新增科目
	 */
	public void insertSubject(SubjectPo po);
	
	/**
	 * 修改科目
	 */
	public void updateSubject(SubjectPo po);
	
	/**
	 * 删除科目
	 */
	public void deleteSubject(SubjectPo po);

	/**
	 * 查询科目详情
	 */
	public SubjectPo getSubjectDetail(SubjectPo po);
	
	/**
	 * 查询科目是否存在
	 */
	public int isExistsSubject(SubjectPo po);
	/**
	 * 查询科目是否存在(更新时)
	 */
	public int isExistsSubjectUpdate(SubjectPo po);
	
	/**
	 * 按品种删除期初商品金额和数量(期初备份表)
	 */
	public void deleteInitGoodsAmount_Backup(String companyID,String departmentID);
	
	/**
	 * 按品种删除期初商品金额和数量(当月成本计算表)
	 */
	public void deleteInitGoodsAmount_CurrentMonth(String companyID,String departmentID);
	
	/**
	 * 按品种新增期初商品金额和数量
	 */
	public void insertInitGoodsAmount_Backup(List<GoodsInfoPo> poList,String date,String companyID,String departmentID);
	
	/**
	 * 按品种新增期初商品金额和数量(当月成本计算表)
	 */
	public void insertInitGoodsAmount_CurrentMonth(String companyID,String departmentID,String cbPriceType);
	
	/**
	 * 更新基础信息中商品的加权平均成本
	 */
	public void updateGoodsInoAvgAmount(String companyID,String cbType);
	
	/**
	 * 计算单位成本
	 */
	public void setNotTaxRateAmount_Backup(String companyID,String departmentID);
	
	/**
	 * 获取物流系统期初商品列表
	 */
	public List<GoodsInfoPo> selGoodsInfo(GoodsInfoPo goodsInfoPo,String companyID,String departmentID,String date);
	
	/**
	 * 获取物流系统期初商品数量和金额
	 */
	public GoodsInfoPo getGoodsSumAndAmount();
	
	/**
	 * 查询树形科目
	 */
	public List<FuctionTreeNode> getSubjectTree(String nodeId,String hrefTarget,String href);
	
	/**
	 * 新增凭证模板
	 */
	public void insertVoucherTemplet(VoucherTempletPo tpo);
	
	/**
	 * 删除凭证模板
	 */
	public void deleteVoucherTemplet(VoucherTempletPo tpo);
	
	/**
	 * 查询凭证模板
	 */
	public List<VoucherTempletPo> getVoucherTempletDetail(VoucherTempletPo po);
	
	/**
	 * 查询树形科目
	 */
	public List<FuctionTreeNode> getSubjectOpenTree(String nodeId,String hrefTarget,String href);
	
	/**
	 * 判断科目代码是否存在
	 */
	public int getSubjectByIdCount(SubjectPo po);
	
	/**
	 * 新增期初成本导出日志
	 */
	public void insertExportAmountLog(String companyID,String departmentID,String date,String type,String pID);
	
	/**
	 * 查询期初成本导出日志
	 */
	public List<ExportAmountLogPo> getExportAmountLog(String companyID);
	
}
