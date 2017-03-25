package com.pengsheng.eims.system.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.CorrectingErrorsDao;
import com.pengsheng.eims.basic.dao.FittingTemplateDao;
import com.pengsheng.eims.basic.persistence.CorrectingErrorsPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.FittingTemplatePo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.dao.SystemClearDao;
import com.pengsheng.eims.system.dao.DepartmentsDao;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.Utility;

public class SystemParameterMgrImpl implements SystemParameterMgr{
	
	private SystemParameterDao systemParameterDao;
	private DepartmentsDao departmentsDao;
	private SystemClearDao systemClearDao;
	private LogisticsLogDao logisticsLogDao;
	private FittingTemplateDao fittingTemplateDao;
	private CorrectingErrorsDao correctingErrorsDao = null;
	
	/**
	 * 得到DB系统时间；
	 * @param po
	 */
	public String getDBSystemData(){
		return systemParameterDao.getDBSystemData();
	}
	
	/**
	 * 新增系统参数信息
	 * @param po
	 */
	public void insertSystemParameter(SystemParameterPo po,LogisticsLogPo logPo){
		systemParameterDao.insertSystemParameter(po);
		
		systemClearDao.deleteSystemOnLineDate();
		systemClearDao.updateSystemOnLineDate(Utility.getName(po.getFspsystemonlinedate()));
		
		CorrectingErrorsPo cpo = new CorrectingErrorsPo();
		cpo.setCerrisdelete(Utility.getName(po.getFspintransitstorageflag()));
		correctingErrorsDao.deleteGoodsTransitStorage(cpo);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 更新系统参数信息
	 * @param po
	 */
	public void updateSystemParameter(SystemParameterPo po,LogisticsLogPo logPo){
		systemParameterDao.updateSystemParameter(po);
		systemParameterDao.deleteTextPhone(po);
		
		String[] phones = po.getFsptextphone().split(",");
		
		for(int i=0; i<phones.length; i++){
			systemParameterDao.insertTextPhone(phones[i]);
		}
		
		systemClearDao.deleteSystemOnLineDate();
		systemClearDao.updateSystemOnLineDate(Utility.getName(po.getFspsystemonlinedate()));
		
		CorrectingErrorsPo cpo = new CorrectingErrorsPo();
		cpo.setCerrisdelete(Utility.getName(po.getFspintransitstorageflag()));
		correctingErrorsDao.deleteGoodsTransitStorage(cpo);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 更新商品规则
	 * @param po
	 */
	public void updateGoodsViewName(SystemParameterPo po,LogisticsLogPo logPo){
		systemParameterDao.updateSystemParameter(po);
		systemParameterDao.updateGoodsViewName(po);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 查询系统参数信息
	 * @return
	 */
	public SystemParameterPo getSystemParameterPo(){
		return systemParameterDao.getSystemParameterPo();
	}
	
	/**
	 * 将部门对应的配镜单模版插入到SystemParameterPo中
	 * @return
	 */
	public SystemParameterPo getSystemParameterPoDepartmentBillTemplate(SystemParameterPo systemParameterPo,String departmentID){
		List<FittingTemplatePo> poList = fittingTemplateDao.getBillTemplateList();
		DepartmentsPo departmentsPo = departmentsDao.getBillTemplate(departmentID);	

		for (int i = 0; i < poList.size(); i++){	
			if (poList.get(i).getBfttype().equals("1")){ // 框镜
				if(Utility.getName(departmentsPo.getBdpkjid()).equals("")){
					systemParameterPo.setFspsalesbillstyle1(Utility.getName(poList.get(i).getBftid()));
					systemParameterPo.setFspsalesbillstyleurl1(Utility.getName(poList.get(i).getBftfileurl()));
					systemParameterPo.setFspsalesbillremark1(Utility.getName(poList.get(i).getBftremark()));
					systemParameterPo.setFspsalesbillname1(Utility.getName(poList.get(i).getBftfilename()));
					systemParameterPo.setFspsalesbillserver1(Utility.getName(poList.get(i).getBftserver()));			
				}else{
					systemParameterPo.setFspsalesbillstyle1(Utility.getName(departmentsPo.getBdpkjid()));
					systemParameterPo.setFspsalesbillstyleurl1(Utility.getName(departmentsPo.getBdpkjurl()));
					systemParameterPo.setFspsalesbillremark1(Utility.getName(departmentsPo.getBdpkjremark()));
					systemParameterPo.setFspsalesbillname1(Utility.getName(departmentsPo.getBdpkjfilename()));
					systemParameterPo.setFspsalesbillserver1(Utility.getName(departmentsPo.getBdpkjserver()));					
				}
			}
			if (poList.get(i).getBfttype().equals("2")){ // 隐形
				if(Utility.getName(departmentsPo.getBdpyxid()).equals("")){
					systemParameterPo.setFspsalesbillstyle3(Utility.getName(poList.get(i).getBftid()));
					systemParameterPo.setFspsalesbillstyleurl3(Utility.getName(poList.get(i).getBftfileurl()));
					systemParameterPo.setFspsalesbillremark3(Utility.getName(poList.get(i).getBftremark()));
					systemParameterPo.setFspsalesbillname3(Utility.getName(poList.get(i).getBftfilename()));	
					systemParameterPo.setFspsalesbillserver3(Utility.getName(poList.get(i).getBftserver()));
				}else{
					systemParameterPo.setFspsalesbillstyle3(Utility.getName(departmentsPo.getBdpyxid()));
					systemParameterPo.setFspsalesbillstyleurl3(Utility.getName(departmentsPo.getBdpyxurl()));
					systemParameterPo.setFspsalesbillremark3(Utility.getName(departmentsPo.getBdpyxremark()));
					systemParameterPo.setFspsalesbillname3(Utility.getName(departmentsPo.getBdpyxfilename()));	
					systemParameterPo.setFspsalesbillserver3(Utility.getName(departmentsPo.getBdpyxserver()));	
				}
			}
			
			if (poList.get(i).getBfttype().equals("3")){ // 辅料
				if(Utility.getName(departmentsPo.getBdpflid()).equals("")){
					systemParameterPo.setFspsalesbillstyle5(Utility.getName(poList.get(i).getBftid()));
					systemParameterPo.setFspsalesbillstyleurl5(Utility.getName(poList.get(i).getBftfileurl()));
					systemParameterPo.setFspsalesbillremark5(Utility.getName(poList.get(i).getBftremark()));
					systemParameterPo.setFspsalesbillname5(Utility.getName(poList.get(i).getBftfilename()));
					systemParameterPo.setFspsalesbillserver5(Utility.getName(poList.get(i).getBftserver()));
				}else{
					systemParameterPo.setFspsalesbillstyle5(Utility.getName(departmentsPo.getBdpflid()));
					systemParameterPo.setFspsalesbillstyleurl5(Utility.getName(departmentsPo.getBdpflurl()));
					systemParameterPo.setFspsalesbillremark5(Utility.getName(departmentsPo.getBdpflremark()));
					systemParameterPo.setFspsalesbillname5(Utility.getName(departmentsPo.getBdpflfilename()));
					systemParameterPo.setFspsalesbillserver5(Utility.getName(departmentsPo.getBdpflserver()));					
				}
			}			

			if (poList.get(i).getBfttype().equals("4")){ // 订金单
				if(Utility.getName(departmentsPo.getBdpdjdid()).equals("")){
					systemParameterPo.setFspsubscriptionbillstyle(Utility.getName(poList.get(i).getBftid()));
					systemParameterPo.setFspsubscriptionbillstyleurl(Utility.getName(poList.get(i).getBftfileurl()));
					systemParameterPo.setFspsubscriptionbillremark(Utility.getName(poList.get(i).getBftremark()));
					systemParameterPo.setFspsubscriptionbillname(Utility.getName(poList.get(i).getBftfilename()));
					systemParameterPo.setFspsubscriptionbillserver(Utility.getName(poList.get(i).getBftserver()));
				}else{
					systemParameterPo.setFspsubscriptionbillstyle(Utility.getName(departmentsPo.getBdpdjdid()));
					systemParameterPo.setFspsubscriptionbillstyleurl(Utility.getName(departmentsPo.getBdpdjdurl()));
					systemParameterPo.setFspsubscriptionbillremark(Utility.getName(departmentsPo.getBdpdjdremark()));
					systemParameterPo.setFspsubscriptionbillname(Utility.getName(departmentsPo.getBdpdjdfilename()));
					systemParameterPo.setFspsubscriptionbillserver(Utility.getName(departmentsPo.getBdpdjdserver()));							
				}		
			}
			
			if (poList.get(i).getBfttype().equals("5")){ // 挂号单
				if(Utility.getName(departmentsPo.getBdpghdid()).equals("")){
					systemParameterPo.setFspregisterbillstyle(Utility.getName(poList.get(i).getBftid()));
					systemParameterPo.setFspregisterbillstyleurl(Utility.getName(poList.get(i).getBftfileurl()));
					systemParameterPo.setFspregisterbillremark(Utility.getName(poList.get(i).getBftremark()));
					systemParameterPo.setFspregisterbillname(Utility.getName(poList.get(i).getBftfilename()));
					systemParameterPo.setFspregisterbillserver(Utility.getName(poList.get(i).getBftserver()));					
				}else{
					systemParameterPo.setFspregisterbillstyle(Utility.getName(departmentsPo.getBdpghdid()));
					systemParameterPo.setFspregisterbillstyleurl(Utility.getName(departmentsPo.getBdpghdurl()));
					systemParameterPo.setFspregisterbillremark(Utility.getName(departmentsPo.getBdpghdremark()));
					systemParameterPo.setFspregisterbillname(Utility.getName(departmentsPo.getBdpghdfilename()));
					systemParameterPo.setFspregisterbillserver(Utility.getName(departmentsPo.getBdpghdserver()));				
				}				
			}
			if (poList.get(i).getBfttype().equals("41")){ // 退框镜
				if(Utility.getName(departmentsPo.getBdptkjid()).equals("")){
					systemParameterPo.setFspsalesbillstyle1tui(Utility.getName(poList.get(i).getBftid()));
					systemParameterPo.setFspsalesbillstyleurl1tui(Utility.getName(poList.get(i).getBftfileurl()));
					systemParameterPo.setFspsalesbillremark1tui(Utility.getName(poList.get(i).getBftremark()));
					systemParameterPo.setFspsalesbillname1tui(Utility.getName(poList.get(i).getBftfilename()));
					systemParameterPo.setFspsalesbillserver1tui(Utility.getName(poList.get(i).getBftserver()));
				}else{
					systemParameterPo.setFspsalesbillstyle1tui(Utility.getName(departmentsPo.getBdptkjid()));
					systemParameterPo.setFspsalesbillstyleurl1tui(Utility.getName(departmentsPo.getBdptkjurl()));
					systemParameterPo.setFspsalesbillremark1tui(Utility.getName(departmentsPo.getBdptkjremark()));
					systemParameterPo.setFspsalesbillname1tui(Utility.getName(departmentsPo.getBdptkjfilename()));
					systemParameterPo.setFspsalesbillserver1tui(Utility.getName(departmentsPo.getBdptkjserver()));						
				}				
			}
			if (poList.get(i).getBfttype().equals("42")){ // 退隐形
				if(Utility.getName(departmentsPo.getBdptyxid()).equals("")){
					systemParameterPo.setFspsalesbillstyle3tui(Utility.getName(poList.get(i).getBftid()));
					systemParameterPo.setFspsalesbillstyleurl3tui(Utility.getName(poList.get(i).getBftfileurl()));
					systemParameterPo.setFspsalesbillremark3tui(Utility.getName(poList.get(i).getBftremark()));
					systemParameterPo.setFspsalesbillname3tui(Utility.getName(poList.get(i).getBftfilename()));	
					systemParameterPo.setFspsalesbillserver3tui(Utility.getName(poList.get(i).getBftserver()));						
				}else{
					systemParameterPo.setFspsalesbillstyle3tui(Utility.getName(departmentsPo.getBdptyxid()));
					systemParameterPo.setFspsalesbillstyleurl3tui(Utility.getName(departmentsPo.getBdptyxurl()));
					systemParameterPo.setFspsalesbillremark3tui(Utility.getName(departmentsPo.getBdptyxremark()));
					systemParameterPo.setFspsalesbillname3tui(Utility.getName(departmentsPo.getBdptyxfilename()));	
					systemParameterPo.setFspsalesbillserver3tui(Utility.getName(departmentsPo.getBdptyxserver()));
				}				
			}
			if (poList.get(i).getBfttype().equals("43")){ // 退辅料
				if(Utility.getName(departmentsPo.getBdptflid()).equals("")){
					systemParameterPo.setFspsalesbillstyle5tui(Utility.getName(poList.get(i).getBftid()));
					systemParameterPo.setFspsalesbillstyleurl5tui(Utility.getName(poList.get(i).getBftfileurl()));
					systemParameterPo.setFspsalesbillremark5tui(Utility.getName(poList.get(i).getBftremark()));
					systemParameterPo.setFspsalesbillname5tui(Utility.getName(poList.get(i).getBftfilename()));
					systemParameterPo.setFspsalesbillserver5tui(Utility.getName(poList.get(i).getBftserver()));					
				}else{
					systemParameterPo.setFspsalesbillstyle5tui(Utility.getName(departmentsPo.getBdptflid()));
					systemParameterPo.setFspsalesbillstyleurl5tui(Utility.getName(departmentsPo.getBdptflurl()));
					systemParameterPo.setFspsalesbillremark5tui(Utility.getName(departmentsPo.getBdptflremark()));
					systemParameterPo.setFspsalesbillname5tui(Utility.getName(departmentsPo.getBdptflfilename()));
					systemParameterPo.setFspsalesbillserver5tui(Utility.getName(departmentsPo.getBdptflserver()));
				}			
			}				
		}
		
		return systemParameterPo;
	}

	/**
	 * 查询条码样式坐标
	 * @param po
	 * @return
	 */
	public List<SystemParameterPo> selectBarcodeCoordinate(SystemParameterPo po){
		return systemParameterDao.selectBarcodeCoordinate(po);
	}
	
	/**
	 * 更新指定行的数据
	 * @param po
	 */
	public void updateBarcodeCoordinate(List<SystemParameterPo> pos){
		for(int i=0; i<pos.size(); i++){
			systemParameterDao.updateBarcodeCoordinate(pos.get(i));
		}
	}
	
	/**
	 * 更新某个商品类型的打印样式
	 * @param po
	 */
	public void updateBarcodeCoordinate(String categoryid,String style){
		systemParameterDao.updateCategoryBarcodeType(categoryid, style);
	}
	
	/**
	 * 查询使用过的零售价
	 */
	public List<DepartmentsPo> selectDepartmentsPoForWhichretail(){
		return systemParameterDao.selectDepartmentsPoForWhichretail();
	}
	
	public SystemClearDao getSystemClearDao() {
		return systemClearDao;
	}

	public void setSystemClearDao(SystemClearDao systemClearDao) {
		this.systemClearDao = systemClearDao;
	}

	public SystemParameterDao getSystemParameterDao() {
		return systemParameterDao;
	}

	public void setSystemParameterDao(SystemParameterDao systemParameterDao) {
		this.systemParameterDao = systemParameterDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public FittingTemplateDao getFittingTemplateDao() {
		return fittingTemplateDao;
	}

	public void setFittingTemplateDao(FittingTemplateDao fittingTemplateDao) {
		this.fittingTemplateDao = fittingTemplateDao;
	}

	public CorrectingErrorsDao getCorrectingErrorsDao() {
		return correctingErrorsDao;
	}

	public void setCorrectingErrorsDao(CorrectingErrorsDao correctingErrorsDao) {
		this.correctingErrorsDao = correctingErrorsDao;
	}

	public DepartmentsDao getDepartmentsDao() {
		return departmentsDao;
	}

	public void setDepartmentsDao(DepartmentsDao departmentsDao) {
		this.departmentsDao = departmentsDao;
	}	
	
}
