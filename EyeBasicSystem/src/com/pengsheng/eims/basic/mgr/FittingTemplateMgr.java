package com.pengsheng.eims.basic.mgr;

import java.io.File;
import java.util.List;

import com.pengsheng.eims.basic.persistence.FittingTemplatePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.CompanyNamePo;

public interface FittingTemplateMgr {

	/**
	 *  查询打印单据样式总数
	 */
	public int getPrintBillTemplateCount(FittingTemplatePo po);
		
	/**
	 *  查询打印单据样式列表
	 */
	public List<FittingTemplatePo> getPrintBillTemplateList(FittingTemplatePo po,int start,int size);
	
	/**
	 *  查询打印单据样式信息
	 */
	public FittingTemplatePo getPrintBillTemplateDetail(FittingTemplatePo po);
	
	/**
	 *  新增打印单据样式
	 */
	public void insertPrintBillTemplate(FittingTemplatePo po,File[] upload, String filePath, String[] fFullName,String picPath,LogisticsLogPo logPo);
	
	/**
	 *  修改打印单据样式
	 */
	public void updatePrintBillTemplate(FittingTemplatePo po,File[] upload, String filePath, String[] fFullName,String picPath,LogisticsLogPo logPo);
	
	/**
	 *  删除打印单据样式
	 */
	public void deletePrintBillTemplate(FittingTemplatePo po,LogisticsLogPo logPo);
	
	/**
	 *  停用启用打印单据样式
	 */
	public void updatePrintBillTemplateEnable(FittingTemplatePo po,LogisticsLogPo logPo);
	
	/**
	 *  查询打印单据样式列表
	 */
	public List<FittingTemplatePo> getPrintBillTemplateList(FittingTemplatePo po);
	
}
