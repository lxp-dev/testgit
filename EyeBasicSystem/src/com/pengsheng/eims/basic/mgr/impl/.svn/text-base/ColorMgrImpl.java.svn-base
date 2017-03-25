package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.ColorDao;
import com.pengsheng.eims.basic.mgr.ColorMgr;
import com.pengsheng.eims.basic.persistence.ComplaintsTypePo;
import com.pengsheng.eims.basic.persistence.ForeignRecipelPo;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.basic.persistence.NoteTypePo;
import com.pengsheng.eims.basic.persistence.RefractiveSetPo;
import com.pengsheng.eims.basic.persistence.ColorPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.util.tools.Utility;

public class ColorMgrImpl implements ColorMgr {

	private ColorDao colorDao;
	private LogisticsLogDao logisticsLogDao;
	
	public void deleteColor(ColorPo colorPo,LogisticsLogPo logPo) {
		this.colorDao.deleteColor(colorPo);
		logisticsLogDao.insertLog(logPo);
	}

	public ColorPo getColor(ColorPo colorPo) {
		return this.colorDao.getColor(colorPo);
	}

	public List<ColorPo> getColorList() {
		return this.colorDao.getColorList();
	}
	
	public int getColorCount() 
	{
		return this.colorDao.getColorCount();
	}	
	public List<ColorPo> getColorsList(int start, int size) 
	{
		return this.colorDao.getColorsList(start, size);
	}

	public void insertColor(ColorPo colorPo,LogisticsLogPo logPo) {
		this.colorDao.insertColor(colorPo);
		logisticsLogDao.insertLog(logPo);
	}

	public void updateColor(ColorPo colorPo,LogisticsLogPo logPo) {
		this.colorDao.updateColor(colorPo);
		logisticsLogDao.insertLog(logPo);
	}

	public int getColorName(ColorPo po)
	{
		return colorDao.getColorName(po);
	}
	public int getColorNameUpdate(ColorPo po)
	{
		return colorDao.getColorNameUpdate(po);
	}
	
	public ColorDao getColorDao() {
		return colorDao;
	}

	public void setColorDao(ColorDao colorDao) {
		this.colorDao = colorDao;
	}

	public int getGoodsCount(ColorPo colorPo) {
		return this.colorDao.getGoodsCount(colorPo);
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public ColorPo getFrameStyle(ColorPo colorPo){
		return colorDao.getFrameStyle(colorPo);
	}
}
