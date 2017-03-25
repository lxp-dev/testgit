package com.pengsheng.eims.report.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;

public interface ReportQuartzMgr {

	/**
	 * 查询石英对应的报表
	 * @return
	 */
	public List<ModulePo> getReportInfoByQuartz(ModulePo po);
	
	/**
	 * 重新生成报表时英的数据
	 * @return
	 */
	public void updateReportQuartzData(ModulePo po,LogisticsLogPo logPo) throws Exception;	
	
	/**
	 * 查询时英执行日志总数
	 */
	public int getReportInfoByQuartzCount(QuartzLogPo logPo);
	
	/**
	 * 查询时英执行日志列表
	 */
	public List<QuartzLogPo> getReportInfoByQuartzList(QuartzLogPo logPo,int start,int size);
	
	public FquartzSwitchPo getFquartzSwitchPo(); 
	
	public void updateFquartzSwitch(FquartzSwitchPo fquartzSwitchPo);
	
}
