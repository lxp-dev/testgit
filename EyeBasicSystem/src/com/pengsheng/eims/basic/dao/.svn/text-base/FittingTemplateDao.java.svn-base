package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.FittingTemplatePo;

public interface FittingTemplateDao {

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
	public void insertPrintBillTemplate(FittingTemplatePo po);
	
	/**
	 *  修改打印单据样式
	 */
	public void updatePrintBillTemplate(FittingTemplatePo po);
	
	/**
	 *  删除打印单据样式
	 */
	public void deletePrintBillTemplate(FittingTemplatePo po);
	
	/**
	 *  停用启用打印单据样式
	 */
	public void updatePrintBillTemplateEnable(FittingTemplatePo po);
	
	/**
	 *  查询打印单据样式列表
	 */
	public List<FittingTemplatePo> getPrintBillTemplateList(FittingTemplatePo po);		
	
	/**
	 *  查询配置的默认配镜单的模版
	 */
	public List<FittingTemplatePo> getBillTemplateList();
	/**
	 *  修改当前使用的打印单据样式
	 */
	public void updateCurrentUsingTemplateByid(String id);
	
	/**
	 *  修改当前使用的打印单据样式:'0'
	 */
	public void updateCurrentUsingTemplateByType(String typeid);
	
}
