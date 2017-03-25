package com.pengsheng.eims.basic.dao;

import java.util.List;
import com.pengsheng.eims.basic.persistence.OptionParamPo;

public interface OptionParamDao {
	
	/**
	 * 取下拉值主数据List
	 * @return
	 */
	public List<OptionParamPo> getOptionParamMaxList() ;
	
	/**
	 * 取下拉值主数据List
	 * @return
	 */
	public List<OptionParamPo> getOptionParamList(OptionParamPo po,int start, int size);
	
	/**
	 * 取下拉值数量
	 * @return
	 */
	public int getOptionParamCount(OptionParamPo po)  ;
	
	/**
	 * 取下拉值子数据List
	 * 
	 * @param optionParamPo
	 *            所属主Po 
	 * @return
	 */
	public List<OptionParamPo> getOptionParamMinList(OptionParamPo optionParamPo);	

	/**
	 * 取指定下拉值主数据/子数据
	 * @return
	 */
	public OptionParamPo getOptionParam(OptionParamPo optionParamPo);

	/**
	 * 插入下拉值主数据/子数据
	 * 
	 * @param optionParamPo
	 *           下拉值主数据/子数据集
	 */
	public void insertOptionParam(OptionParamPo optionParamPo);

	/**
	 * 更新下拉值主数据/子数据
	 * 
	 * @param optionParamPo
	 *            下拉值主数据/子数据集
	 */
	public void updateOptionParam(OptionParamPo optionParamPo);

	/**
	 * 删除下拉值主数据/子数据
	 * 
	 * @param optionParamPo
	 *            下拉值主数据/子数据集
	 */
	public void deleteOptionParam(OptionParamPo optionParamPo);
	/**
	 * 添加时判断下拉值ID 是否重复
	 * @return
	 */
	public int getOptionParamID(OptionParamPo optionParamPo);		
	/**
	 * 添加时判断下拉值子数据名称 是否重复
	 * @return
	 */
	public int getOptionParamName(OptionParamPo optionParamPo);
	/**
	 * 修改时判断下拉值子数据名称 是否重复
	 * @return
	 */
	public int getOptionParamNameUpdate(OptionParamPo optionParamPo) ;
}
