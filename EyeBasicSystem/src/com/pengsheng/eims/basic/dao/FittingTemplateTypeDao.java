package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.FittingTemplateTypePo;

public interface FittingTemplateTypeDao {

	/**
	 *  查询单据模版类型List
	 */
	public List<FittingTemplateTypePo> getFittingTemplateTypeList(FittingTemplateTypePo po);
	
	/**
	 *  查询单据模版类型PO
	 */
	public FittingTemplateTypePo getFittingTemplateTypePo(String typeID);
	
	/**
	 *  配置模版打开方式
	 */
	public void updateFittingTemplateTypeShowtype(String typeID,String showType);
	
	/**
	 *  配置模版类型对应的报表
	 */
	public void updateFittingTemplateTypePo(FittingTemplateTypePo po);
	
}
