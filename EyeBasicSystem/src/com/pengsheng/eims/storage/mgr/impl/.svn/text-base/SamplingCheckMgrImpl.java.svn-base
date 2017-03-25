package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.dao.SamplingCheckDao;
import com.pengsheng.eims.storage.dao.WorkingCheckDao;
import com.pengsheng.eims.storage.mgr.SamplingCheckMgr;
import com.pengsheng.eims.storage.mgr.WorkingCheckMgr;
import com.pengsheng.eims.storage.persistence.MistakePo;
import com.pengsheng.eims.storage.persistence.WorkingCheckPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.tools.Utility;

public class SamplingCheckMgrImpl implements SamplingCheckMgr {
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	
	
	private SamplingCheckDao samplingCheckDao;

	public SamplingCheckDao getSamplingCheckDao() {
		return samplingCheckDao;
	}

	public void setSamplingCheckDao(SamplingCheckDao samplingCheckDao) {
		this.samplingCheckDao = samplingCheckDao;
	}

	/**
	 * 得到检验信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getWorkingCheckCount(SalesBasicPo salesBasicPo) {
		return samplingCheckDao.getWorkingCheckCount(salesBasicPo);
	}

	/**
	 * 得到检验信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectWorkingCheck(SalesBasicPo salesBasicPo,
			int start, int size) {
		return samplingCheckDao.selectWorkingCheck(salesBasicPo, start, size);
	}

	/**
	 * 得到顾客信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getCustomerInfo(SalesBasicPo salesBasicPo) {
		return samplingCheckDao.getCustomerInfo(salesBasicPo);
	}

	/**
	 * 取出销售单中右眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo) {
		return samplingCheckDao.getODDetailInfo(salesBasicPo);
	}

	/**
	 * 取出销售单中左眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo) {
		return samplingCheckDao.getOSDetailInfo(salesBasicPo);
	}

	/**
	 * 取加工师下拉列表
	 * @param personInfoPo
	 * @return
	 */
	public List<PersonInfoPo> getWorkingChenkPerson(PersonInfoPo personInfoPo) {
		return samplingCheckDao.getWorkingChenkPerson(personInfoPo);
	}


	public MistakePo getMistakeODPo(SalesBasicPo salesBasicPo) {
		MistakePo mistakePo = new MistakePo();
		String odsphmistake=samplingCheckDao.getMistakeSphPo(salesBasicPo, "fmtodsphmistake").getFmtodsphmistake();
		mistakePo.setFmtodsphmistake(odsphmistake);
		String odcylmistake=samplingCheckDao.getMistakeCylPo(salesBasicPo, "fmtodcylmistake").getFmtodcylmistake();
		mistakePo.setFmtodcylmistake(odcylmistake);
		
		String odaxesmistake=samplingCheckDao.getMistakeAxesODPo(salesBasicPo, "fmtodaxesmistake").getFmtodaxesmistake();
		mistakePo.setFmtodaxesmistake(odaxesmistake);
		
		String odaddmistake=samplingCheckDao.getMistakeAddODPo(salesBasicPo, "fmtodaddmistake").getFmtodaddmistake();
		mistakePo.setFmtodaddmistake(odaddmistake);
		
		
		String odtjmistake=samplingCheckDao.getMistakeTjPo(salesBasicPo, "fmtodtjmistake").getFmtodtjmistake();
		mistakePo.setFmtodtjmistake(odtjmistake);
		
		String odscmistake=samplingCheckDao.getMistakeSCPo(salesBasicPo, "fmtodsphandcylmistake").getFmtodsphandcylmistake();
		mistakePo.setFmtodsphandcylmistake(odscmistake);
		return mistakePo;
	}
	
	public MistakePo getMistakeOSPo(SalesBasicPo salesBasicPo) {
		MistakePo mistakePo = new MistakePo();
		String ossphmistake=samplingCheckDao.getMistakeSphPo(salesBasicPo, "fmtossphmistake").getFmtossphmistake();
		mistakePo.setFmtossphmistake(ossphmistake);
		String oscylmistake=samplingCheckDao.getMistakeCylPo(salesBasicPo, "fmtoscylmistake").getFmtoscylmistake();
		mistakePo.setFmtoscylmistake(oscylmistake);
		
		String osaxesmistake=samplingCheckDao.getMistakeAxesOSPo(salesBasicPo, "fmtosaxesmistake").getFmtosaxesmistake();
		mistakePo.setFmtosaxesmistake(osaxesmistake);
		
		String osaddmistake=samplingCheckDao.getMistakeAddOSPo(salesBasicPo, "fmtosaddmistake").getFmtosaddmistake();
		mistakePo.setFmtosaddmistake(osaddmistake);
		
		String ostjmistake=samplingCheckDao.getMistakeTjPo(salesBasicPo, "fmtostjmistake").getFmtostjmistake();
		mistakePo.setFmtostjmistake(ostjmistake);
		String osscmistake=samplingCheckDao.getMistakeSCPo(salesBasicPo, "fmtossphandcylmistake").getFmtossphandcylmistake();
		mistakePo.setFmtossphandcylmistake(osscmistake);
		return mistakePo;
	}

	/**
	 * 新增检验信息
	 * @param inTransitPo
	 * @param salesPo
	 * @param workingCheckPo
	 */
	public void insertWorkingCheck(InTransitPo inTransitPo,
			SalesBasicPo salesPo, WorkingCheckPo workingCheckPo,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		samplingCheckDao.insertWorkingCheck(workingCheckPo);
		samplingCheckDao.updateWorkingCheckIsSampled(workingCheckPo.getPchcksalesid());
	}
	
	/**
	 * 获取上次检验记录
	 * @param inTransitPo
	 * @param salesPo
	 * @param workingCheckPo
	 */
	public WorkingCheckPo getLastWorkingCheckPo(SalesBasicPo salesBasicPo){
		return samplingCheckDao.getLastWorkingCheckPo(salesBasicPo);
	}
	
	/**
	 * 检验单详细
	 * @param salesBasicPo
	 * @return
	 */
	public WorkingCheckPo getWorkingCheckPo(String salesid){
		return samplingCheckDao.getWorkingCheckPo(salesid);
	}
	
	/**
	 * 更新检验单抽检状态
	 * @param salesid
	 */
	public void updateWorkingCheckIsSampled(String salesid){
		samplingCheckDao.updateWorkingCheckIsSampled(salesid);
	}
}
