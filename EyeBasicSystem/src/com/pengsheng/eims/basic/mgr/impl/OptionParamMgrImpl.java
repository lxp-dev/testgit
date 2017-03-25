package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.OptionParamDao;
import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public class OptionParamMgrImpl implements OptionParamMgr {
	
	private OptionParamDao optionParamDao;
    private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
	
	public List<OptionParamPo> getOptionParamMaxList()
	{
		return this.optionParamDao.getOptionParamMaxList();
	}
	
	
	public List<OptionParamPo> getOptionParamList(OptionParamPo po,int start, int size)
	{
		return this.optionParamDao.getOptionParamList(po, start, size);
	}
	
	public int getOptionParamCount(OptionParamPo po)  
	{
		return this.optionParamDao.getOptionParamCount(po);
	}


	public List<OptionParamPo> getOptionParamMinList(
			OptionParamPo optionParamPo) {
		return this.optionParamDao.getOptionParamMinList(optionParamPo);
	}


	public OptionParamPo getOptionParam(
			OptionParamPo optionParamPo) {
		OptionParamPo result = new OptionParamPo();
		result = this.optionParamDao.getOptionParam(optionParamPo);
		if(!result.getFopparentid().equals("")){
			OptionParamPo tmp = new OptionParamPo();
			tmp.setFopparamid(result.getFopparentid());
			result.setFopparentname(this.optionParamDao.getOptionParam(tmp).getFopparamname());
		}
		return result;
	}
	
	public void insertOptionParam(
			OptionParamPo optionParamPo,LogisticsLogPo logPo) {
		this.optionParamDao.insertOptionParam(optionParamPo);
		logisticsLogDao.insertLog(logPo);
	}

	public void updateOptionParam(
			OptionParamPo optionParamPo,LogisticsLogPo logPo) {
		this.optionParamDao.updateOptionParam(optionParamPo);
		logisticsLogDao.insertLog(logPo);
	}
	/**
	 * 添加时判断下拉值ID 是否重复
	 * @return
	 */
	public int getOptionParamID(OptionParamPo optionParamPo){
		return optionParamDao.getOptionParamID(optionParamPo);
	}
	/**
	 * 添加时判断下拉值 是否重复
	 * @return
	 */
	public int getOptionParamName(OptionParamPo optionParamPo)
	{
		return optionParamDao.getOptionParamName(optionParamPo);
	}
	/**
	 * 修改时判断下拉值 是否重复
	 * @return
	 */
	public int getOptionParamNameUpdate(OptionParamPo optionParamPo) 
	{
		return optionParamDao.getOptionParamNameUpdate(optionParamPo);
	}
		
	public void deleteOptionParam(
			OptionParamPo optionParamPo,LogisticsLogPo logPo) {
		this.optionParamDao.deleteOptionParam(optionParamPo);
		logisticsLogDao.insertLog(logPo);
	}
	
	public OptionParamDao getOptionParamDao() {
		return optionParamDao;
	}

	public void setOptionParamDao(
			OptionParamDao optionParamDao) {
		this.optionParamDao = optionParamDao;
	}
}
