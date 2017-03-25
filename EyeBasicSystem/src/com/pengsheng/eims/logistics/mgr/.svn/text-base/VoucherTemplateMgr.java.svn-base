/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : VoucherTemplateMgr.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2012-05-04
**/
package com.pengsheng.eims.logistics.mgr;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.SubjectPo;
import com.pengsheng.eims.logistics.persistence.VoucherTempletPo;
import com.pengsheng.eims.system.persistence.ExportAmountLogPo;
import com.pengsheng.eims.system.persistence.FuctionTreeNode;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

public interface VoucherTemplateMgr{
	
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
	public void insertSubject(SubjectPo po,LogisticsLogPo logPo);
	
	/**
	 * 批量新增科目
	 */
	public void insertSubjectBatch(SubjectPo po,File[] upload, String filePath, String[] fFullName,String[] ContentType,LogisticsLogPo logPo);
	
	/**
	 * 修改科目
	 */
	public void updateSubject(SubjectPo po,LogisticsLogPo logPo);
	
	/**
	 * 删除科目
	 */
	public void deleteSubject(SubjectPo po,LogisticsLogPo logPo);
	
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
	 * 导入期初商品金额
	 * 
	 * @param brandPo
	 */
	public void insertImportAmountExcel(GoodsInfoPo goodsInfoPo,String sjtype,String companyID,String departmentID,String date,SystemParameterPo spo,File[] upload, String filePath, String[] fFullName,String[] ContentType,String filetemplet,LogisticsLogPo logPo);

	/**
	 * 导出期初商品金额
	 * 
	 * @param personInfoPo
	 */
	public InputStream insertExportAmountExcel(GoodsInfoPo goodsInfoPo,String companyID,String departmentID,String date,String type,String pID,String url,String filename,LogisticsLogPo logPo) throws Exception;
	
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
	public void insertVoucherTemplet(VoucherTempletPo po,List<VoucherTempletPo> tlist,LogisticsLogPo logPo);
	
	/**
	 * 查询凭证模板
	 */
	public List<VoucherTempletPo> getVoucherTempletDetail(VoucherTempletPo po);
	
	/**
	 * 查询树形科目
	 */
	public List<FuctionTreeNode> getSubjectOpenTree(String nodeId,String hrefTarget,String href);
	
	/**
	 * 查询期初成本导出日志
	 */
	public List<ExportAmountLogPo> getExportAmountLog(String companyID);
	
}
