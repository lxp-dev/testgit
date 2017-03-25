package com.pengsheng.eims.sales.mgr.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.pengsheng.eims.logistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.dao.PreSalesDao;
import com.pengsheng.eims.sales.mgr.PreSalesMgr;
import com.pengsheng.eims.sales.persistence.PreBrandPo;
import com.pengsheng.eims.sales.persistence.PreDepPo;
import com.pengsheng.eims.sales.persistence.PrePersonSalesEntryPo;
import com.pengsheng.eims.sales.persistence.PrePersonSalesPo;
import com.pengsheng.eims.sales.persistence.PrePlanPo;
import com.pengsheng.eims.sales.persistence.PreSalesPo;
import com.pengsheng.eims.sales.persistence.PreShopSalesEntryPo;
import com.pengsheng.eims.sales.persistence.PreShopSalesPo;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class PreSalesMgrImpl implements PreSalesMgr {
	
	private PreSalesDao preSalesDao;
	private LogisticsLogMgr logisticsLogMgr;
	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	
	public int deletePreSales(PreSalesPo po, LogisticsLogPo logPo) {
		logisticsLogMgr.insertLog(logPo);
		return preSalesDao.deletePreSales(po);
	}

	public PreSalesPo getPreSalesPo(PreSalesPo po) {
		return preSalesDao.getPreSalesPo(po);
	}

	public int insertPreSales(List<PreSalesPo> poList, LogisticsLogPo logPo) {
		int result = 0;
		for (PreSalesPo po : poList) {
			preSalesDao.insertPreSales(po);
			result++;
		}
		logisticsLogMgr.insertLog(logPo);
		return result;
	}

	public int updatePreSales(PreSalesPo po, LogisticsLogPo logPo) {
		logisticsLogMgr.insertLog(logPo);
		return preSalesDao.updatePreSales(po);
	}
	
	public PreSalesDao getPreSalesDao() {
		return preSalesDao;
	}

	public void setPreSalesDao(PreSalesDao preSalesDao) {
		this.preSalesDao = preSalesDao;
	}

	public LogisticsLogMgr getLogisticsLogMgr() {
		return logisticsLogMgr;
	}

	public void setLogisticsLogMgr(LogisticsLogMgr logisticsLogMgr) {
		this.logisticsLogMgr = logisticsLogMgr;
	}

	public List<PreSalesPo> getIntersectionPreSalesList(PreSalesPo po) {
		return preSalesDao.getIntersectionPreSalesList(po);
	}

	public List<PreSalesPo> getPreSalesPoList(PreSalesPo po, int start, int size) {
		return preSalesDao.getPreSalesPoList(po, start, size);
	}

	public int getPreSalesPoListCount(PreSalesPo po) {
		return preSalesDao.getPreSalesPoListCount(po);
	}

	public void updatePreSalesPoQuantity(String id, String quantity) {
		preSalesDao.updatePreSalesPoQuantity(id, quantity);
	}

	public void deletePrePlanPo(PrePlanPo po) {
		preSalesDao.deletePrePlanPo(po);
	}

	public List<PrePlanPo> getPrePlanPoList(PrePlanPo po, int start, int size) {
		return preSalesDao.getPrePlanPoList(po, start, size);
	}

	public int getPrePlanPoListCount(PrePlanPo po) {
		return preSalesDao.getPrePlanPoListCount(po);
	}

	public void insertPrePlanPo(PrePlanPo po) {
		preSalesDao.insertPrePlanPo(po);
	}

	public void updatePrePlanPo(PrePlanPo po) {
		preSalesDao.updatePrePlanPo(po);
	}

	public PrePlanPo getPrePlanPo(PrePlanPo po) {
		return preSalesDao.getPrePlanPo(po);
	}

	public List<PreDepPo> getPreDepPoList(PrePlanPo po) {
		return preSalesDao.getPreDepPoList(po);
	}

	public List<PreBrandPo> getPreBrandPoList(PreDepPo po) {
		return preSalesDao.getPreBrandPoList(po);
	}

	public void insertPreBrandPo(PreBrandPo po) {
		preSalesDao.insertPreBrandPo(po);
	}

	public void insertPreDepPo(PreDepPo po) {
		preSalesDao.insertPreDepPo(po);
	}

	public void insertPreDepPoAndPreBrandPo(List<PreDepPo> preDepPoList,
			List<PreBrandPo> preBrandPoList) {
		for (PreBrandPo preBrandPo : preBrandPoList) {
			insertPreBrandPo(preBrandPo);
		}
		for (PreDepPo preDepPo : preDepPoList) {
			insertPreDepPo(preDepPo);
		}
	}

	public void deletePreBrandPoByPreDepPoId(PreDepPo po) {
		preSalesDao.deletePreBrandPoByPreDepPoId(po);
	}

	public void deletePreDepPo(PreDepPo po) {
		preSalesDao.deletePreDepPo(po);
	}

	public void deletePreBrandPoByPreDepPoId(List<PreDepPo> poList) {
		for (PreDepPo preDepPo : poList) {
			deletePreBrandPoByPreDepPoId(preDepPo);
		}
	}

	public void deletePreDepPoList(List<PreDepPo> poList) {
		for (PreDepPo preDepPo : poList) {
			deletePreDepPo(preDepPo);
		}
	}

	public void insertPreBrandPoList(List<PreBrandPo> poList) {
		for (PreBrandPo preBrandPo : poList) {
			insertPreBrandPo(preBrandPo);
		}
	}

	public PreDepPo getPreDepPo(PreDepPo po) {
		return preSalesDao.getPreDepPo(po);
	}

	public void updatePreDepPoOverdue() {
		preSalesDao.updatePreDepPoOverdue();
	}
	
	public int insertPreSalesS(PreSalesPo po,LogisticsLogPo logPo){
		logisticsLogMgr.insertLog(logPo);
		return preSalesDao.insertPreSalesS(po);
	}
	
	public PreSalesPo selectPreSalesPoSerialNumber(){
		return preSalesDao.selectPreSalesPoSerialNumber();
	}
	
	/**
	 * 查询门店计划销售金额列表
	 */
	public List<PreShopSalesPo> getPreShopSalesList(PreShopSalesPo po, int start, int size){
		return preSalesDao.getPreShopSalesList(po,start,size);
	}
	
	/**
	 * 查询门店计划销售金额总数
	 */
	public int getPreShopSalesCount(PreShopSalesPo po){
		return preSalesDao.getPreShopSalesCount(po);
	}
	
	/**
	 * 新增门店计划销售金额列表
	 */
	public void insertPreShopSales(List<PreShopSalesPo> poList, LogisticsLogPo logPo){
		
		for (PreShopSalesPo po : poList){
			if (this.getPreShopSalesByIDCount(po) == 0){
				po.setSsepsid(this.uuid.generate());
				preSalesDao.insertPreShopSales(po);
				
				this.insertPreShopSalesEntry(po);
			}			
		}

		logisticsLogMgr.insertLog(logPo);
	}

	/**
	 * 删除门店计划销售金额列表
	 */
	public void deletePreShopSales(PreShopSalesPo po, LogisticsLogPo logPo){
		preSalesDao.deletePreShopSales(po);
		preSalesDao.deletePreShopSalesEntry(po);
		
		logisticsLogMgr.insertLog(logPo);
	}

	/**
	 * 修改门店计划销售金额列表
	 */
	public void updatePreShopSales(PreShopSalesPo po, LogisticsLogPo logPo){
		preSalesDao.updatePreShopSales(po);
		
		preSalesDao.deletePreShopSalesEntry(po);
		this.insertPreShopSalesEntry(po);
		
		logisticsLogMgr.insertLog(logPo);
	}
	
	/**
	 * 查看门店计划销售金额明细
	 */
	public PreShopSalesPo getPreShopSalesDetail(PreShopSalesPo po){
		return preSalesDao.getPreShopSalesDetail(po);
	}
	
	/**
	 * 查看门店计划销售金额是否重复
	 */
	private int getPreShopSalesByIDCount(PreShopSalesPo po){		
		
		String bgnDate = Utility.getName(po.getSsepsprebgndate());  //起始日期
		String endDate = Utility.getName(po.getSsepspreenddate());  //截止日期		

		int count = 0;
		
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		while (bgnDate.compareToIgnoreCase(endDate) <= 0){
		
			po.setSsepspredate(bgnDate);
			count += preSalesDao.getPreShopSalesByIDCount(po);
			if (count > 0){
				return 1;
			}			
			
			try {
				cal.setTime(tempDate.parse(bgnDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}			
			cal.add(Calendar.DATE,1);
			
			bgnDate = tempDate.format(cal.getTime());
		}
		
		return 0;
	}
	
	/**
	 * 新增门店计划销售金额明细
	 */
	private void insertPreShopSalesEntry(PreShopSalesPo po){
		
		String bgnDate = Utility.getName(po.getSsepsprebgndate());  //起始日期
		String endDate = Utility.getName(po.getSsepspreenddate());  //截止日期		

		int count = preSalesDao.getDayAreaCount(po);
		BigDecimal bg = new BigDecimal(Utility.getName(po.getSsepssalesprice()));
		BigDecimal bg2 = new BigDecimal(Utility.getName(po.getSsepssalesprice()));
		bg2 = bg2.divide(new BigDecimal(count),3).setScale(2, BigDecimal.ROUND_HALF_UP);
		int index = 0;		
		BigDecimal bg3 = new BigDecimal(index);
		
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		while (bgnDate.compareToIgnoreCase(endDate) <= 0){
			
			index++;		
			if (index == count){
				bg2 = bg.subtract(bg3);
			}
			bg3 = bg3.add(bg2);	
			
			PreShopSalesEntryPo epo = new PreShopSalesEntryPo();
			epo.setSsepsepreid(Utility.getName(po.getSsepsid()));
			epo.setSsepseshopcode(Utility.getName(po.getSsepsshopcode()));
			epo.setSsepsesalesprice(bg2.toString());
			epo.setSsepsepredate(bgnDate);
			
			preSalesDao.insertPreShopSalesEntry(epo);
			
			try {
				cal.setTime(tempDate.parse(bgnDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			cal.add(Calendar.DATE,1);
			
			bgnDate = tempDate.format(cal.getTime());
		}
		
	}
	/**
	 * 查询人员计划销售金额列表
	 */
	public List<PrePersonSalesPo> getPrePersonSalesList(PrePersonSalesPo po, int start, int size){
		
		return preSalesDao.getPrePersonSalesList(po, start, size);
	}
	
	/**
	 * 查询人员计划销售金额总数
	 */
	public int getPrePersonSalesCount(PrePersonSalesPo po){
		
		return preSalesDao.getPrePersonSalesCount(po);
	}
	
	/**
	 * 新增人员计划销售金额列表
	 */
	public void insertPrePersonSales(List<PrePersonSalesPo> poList, LogisticsLogPo logPo){
		
		for (PrePersonSalesPo po : poList){
			if (this.getPrePersonSalesByIDCount(po) == 0){
				po.setSsepsid(this.uuid.generate());
				preSalesDao.insertPrePersonSales(po);
				
				this.insertPrePersonSalesEntry(po);
			}			
		}

		logisticsLogMgr.insertLog(logPo);
		
	}

	/**
	 * 删除人员计划销售金额列表
	 */
	public void deletePrePersonSales(PrePersonSalesPo po, LogisticsLogPo logPo){
		
		preSalesDao.deletePrePersonSales(po);
		preSalesDao.deletePrePersonSalesEntry(po);
		
		logisticsLogMgr.insertLog(logPo);
	}
	/**
	 * 修改人员计划销售金额列表
	 */
	public void updatePrePersonSales(PrePersonSalesPo po, LogisticsLogPo logPo){
		
		preSalesDao.updatePrePersonSales(po);
		
		preSalesDao.deletePrePersonSalesEntry(po);
		this.insertPrePersonSalesEntry(po);
		
		logisticsLogMgr.insertLog(logPo);
	}	
	
	/**
	 * 查看人员计划销售金额明细
	 */
	public PrePersonSalesPo getPrePersonSalesDetail(PrePersonSalesPo po){
		
		return preSalesDao.getPrePersonSalesDetail(po);
	}
	/**
	 * 查看门店计划销售金额是否重复
	 */
	private int getPrePersonSalesByIDCount(PrePersonSalesPo po){		
		
		String bgnDate = Utility.getName(po.getSsepsprebgndate());  //起始日期
		String endDate = Utility.getName(po.getSsepspreenddate());  //截止日期		

		int count = 0;
		
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		while (bgnDate.compareToIgnoreCase(endDate) <= 0){
		
			po.setSsepspredate(bgnDate);
			count += preSalesDao.getPrePersonSalesByIDCount(po);
			if (count > 0){
				return 1;
			}			
			
			try {
				cal.setTime(tempDate.parse(bgnDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}			
			cal.add(Calendar.DATE,1);
			
			bgnDate = tempDate.format(cal.getTime());
		}
		
		return 0;
	}
	/**
	 * 新增门店计划销售金额明细
	 */
	private void insertPrePersonSalesEntry(PrePersonSalesPo po){
		
		String bgnDate = Utility.getName(po.getSsepsprebgndate());  //起始日期
		String endDate = Utility.getName(po.getSsepspreenddate());  //截止日期		

		int count = preSalesDao.getDayAreaCount2(po);
		BigDecimal bg = new BigDecimal(Utility.getName(po.getSsepssalesprice()));
		BigDecimal bg2 = new BigDecimal(Utility.getName(po.getSsepssalesprice()));
		bg2 = bg2.divide(new BigDecimal(count),3).setScale(2, BigDecimal.ROUND_HALF_UP);
		int index = 0;		
		BigDecimal bg3 = new BigDecimal(index);
		
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		while (bgnDate.compareToIgnoreCase(endDate) <= 0){
			
			index++;		
			if (index == count){
				bg2 = bg.subtract(bg3);
			}
			bg3 = bg3.add(bg2);	
			
			PrePersonSalesEntryPo epo = new PrePersonSalesEntryPo();
			epo.setSsepsepreid(Utility.getName(po.getSsepsid()));
			epo.setSsepseshopcode(Utility.getName(po.getSsepsshopcode()));
			epo.setSsepsepersonid(Utility.getName(po.getSsepspersonid()));
			epo.setSsepsesalesprice(bg2.toString());
			epo.setSsepsepredate(bgnDate);
			
			preSalesDao.insertPrePersonSalesEntry(epo);
			
			try {
				cal.setTime(tempDate.parse(bgnDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			cal.add(Calendar.DATE,1);
			
			bgnDate = tempDate.format(cal.getTime());
		}
		
	}
}
