package com.pengsheng.eims.sales.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.FittingTemplateTypeMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.FittingTemplateTypePo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.mgr.WindowsMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.mgr.ProcessDistributionMgr;
import com.pengsheng.eims.sales.persistence.DistributionPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.system.mgr.BillKeyMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;

public class ProcessDistributionAction extends BaseAction {

	private List<WarehousePo> warehouseList;
	private ProcessDistributionMgr processDistributionMgr;
	private SalesBasicPo salesBasicPo;
	private List<SalesBasicPo> saList;
	private PersonPermissionMgr personPermissionMgr;
    private WindowsMgr windowsMgr;	
    private PersonInfoMgr personInfoMgr;
	private FittingTemplateTypeMgr fittingTemplateTypeMgr = null;    
    private BillKeyMgr billKeyMgr;
    
	public BillKeyMgr getBillKeyMgr() {
		return billKeyMgr;
	}
	public void setBillKeyMgr(BillKeyMgr billKeyMgr) {
		this.billKeyMgr = billKeyMgr;
	}
	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}
	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}
	public WindowsMgr getWindowsMgr() {
		return windowsMgr;
	}
	public void setWindowsMgr(WindowsMgr windowsMgr) {
		this.windowsMgr = windowsMgr;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}
	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}
	public List<SalesBasicPo> getSaList() {
		return saList;
	}
	public void setSaList(List<SalesBasicPo> saList) {
		this.saList = saList;
	}

	public ProcessDistributionMgr getProcessDistributionMgr() {
		return processDistributionMgr;
	}
	public void setProcessDistributionMgr(
			ProcessDistributionMgr processDistributionMgr) {
		this.processDistributionMgr = processDistributionMgr;
	}
	public List<WarehousePo> getWarehouseList() {
		return warehouseList;
	}
	public void setWarehouseList(List<WarehousePo> warehouseList) {
		this.warehouseList = warehouseList;
	}
	
	/**
	*查询门店配送信息
	*@return
	*/
	public String initProcessDistributionSel()throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(((PersonInfoPo)session.get("person")).getDepartmentID());	
		salesBasicPo = new SalesBasicPo();
		salesBasicPo.setSsesbshopcode(((PersonInfoPo)session.get("person")).getDepartmentID());
		warehouseList=processDistributionMgr.getWarehouseList(salesBasicPo);
		
		int count = windowsMgr.isEnabledInTransit("10");
		request.setAttribute("InTransitCount", count);
		
		return SUCCESS;
	}
	
	/**
	 * 根据条件查询信息
	 * @return
	 * @throws Exception
	 */
	public String selectProcessDistribution()throws Exception{		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String shopsalesid = Utility.getName(request.getParameter("shopsalesid"));
		String memberId = Utility.getName(request.getParameter("memberId"));
		String shoppersonName = Utility.getName(request.getParameter("shoppersonName"));
		String ssesbsalesdatestarttime = Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
		String ssesbsalesdateendtime = Utility.getName(request.getParameter("ssesbsalesdateendtime"));
		String ssesblocation=Utility.getName(request.getParameter("ssesblocation"));
		String startDate = Utility.getName(request.getParameter("startDate"));
		String endDate = Utility.getName(request.getParameter("endDate"));
		String worrytype = Utility.getName(request.getParameter("worrytype"));
		
		request.setAttribute("shopsalesid",shopsalesid);
		request.setAttribute("memberId",memberId);
		request.setAttribute("shoppersonName",shoppersonName);
		request.setAttribute("ssesbsalesdatestarttime",ssesbsalesdatestarttime);
		request.setAttribute("ssesbsalesdateendtime",ssesbsalesdateendtime);
		request.setAttribute("startDate",startDate);
		request.setAttribute("endDate",endDate);
		request.setAttribute("ssesblocation", ssesblocation);
		request.setAttribute("worrytype", worrytype);
		
		salesBasicPo = new SalesBasicPo();
		salesBasicPo.setSsesbsalesid(shopsalesid);
		salesBasicPo.setSsesbMemberId(memberId);
		salesBasicPo.setSsesbpersonName(shoppersonName);
		salesBasicPo.setSsesbsalesdatestarttime(ssesbsalesdatestarttime);
		salesBasicPo.setSsesbsalesdateendtime(ssesbsalesdateendtime);
		salesBasicPo.setSsesblocation(ssesblocation);
		salesBasicPo.setSsesbtakeglassstartdata(startDate);
		salesBasicPo.setSsesbtakeglassenddata(endDate);
		salesBasicPo.setSsesbworrytype(worrytype);
		salesBasicPo.setSsesbshopcode(personInfoPo.getDepartmentID());
		
		saList=processDistributionMgr.getSalesBasicPos(salesBasicPo);
		
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(((PersonInfoPo)session.get("person")).getDepartmentID());		
		warehouseList=processDistributionMgr.getWarehouseList(salesBasicPo);
		
		request.setAttribute("InTransitCount", Utility.getName(request.getParameter("InTransitCount")));
		
		//获得打印结算单信息----------------------------
		String actionTypeID = "37";
		FittingTemplateTypePo fittingTemplateTypePo = new FittingTemplateTypePo();
		fittingTemplateTypePo = fittingTemplateTypeMgr.getFittingTemplateTypePo(actionTypeID);
		
		request.setAttribute("fittingTemplateTypePo", fittingTemplateTypePo);
		//获得打印结算单信息----------------------------
		
		return SUCCESS;
	}
	
	/**
	 * 修改销售结账基表加工配送状态，
	 */
	public String updateProcessDistribution()throws Exception{
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String personcardid = Utility.getName(request.getParameter("personcardid"));
		
		PersonInfoPo po = new PersonInfoPo();
		po.setCardid(personcardid);
		
		PersonInfoPo ppo = new PersonInfoPo();
		ppo = personInfoMgr.getPersonInfo(po);
		
		if("".equals(Utility.getName(ppo.getId()))){
			this.addActionMessage(getText("不存在该员工信息！")); 
			return "error"; 
		}else{
			String ssesbsalesid= Utility.getName(request.getParameter("ssesbsalesid"));
			String[] ssid=ssesbsalesid.split(",");
			
			String errorsalesid = "以下销售单号：\\n";
			String errortype = "";
			for(int i=0; i<ssid.length; i++){
				int istake = billKeyMgr.selectProcurementOrderForType("10",ssid[i]);
				if(istake == 1){
					errorsalesid = errorsalesid + ssid[i]+"\\n";
					errortype = "1";
				}
			}
			if(errortype.equals("1")){
				this.clearMessages();
				this.addActionMessage(errorsalesid+"已被加工配送，不能进行重复操作！");
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
				
				return SUCCESS;
			}
			
			String personid = Utility.getName(Utility.getName(ppo.getId()));
			saList = new ArrayList<SalesBasicPo>();
			InTransitPo inTransitPo =new InTransitPo();
			DistributionPo distributionPo=new DistributionPo();
			
			inTransitPo.setSseitcreateperson(personInfoPo.getId());
			inTransitPo.setSseitdepartment(personInfoPo.getDepartmentID());//新增在途查询明细表信息
			
			distributionPo.setSdndnlogonperson(createPerson);
			distributionPo.setSdndnPerson(personid);//新增配送记录主表信息和配送记录明细表信息
			distributionPo.setSdndntype("2");//配送类型：加工配送
			distributionPo.setSdndnid("PS"+GenerateNumber.getInstance().getGenerageNumber());   //主键
			distributionPo.setSdndndepartmentid(personInfoPo.getDepartmentID());
			
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(createPerson);
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 模块ID
			logPo.setsLogOpID("31");    // 加工配送
			logPo.setsLogContent("");
			
			processDistributionMgr.updateSalesBasicPos(ssid, inTransitPo, distributionPo,logPo);
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			DepartmentsPo deppo=new DepartmentsPo();
			deppo.setBdpdepartmentid(((PersonInfoPo)session.get("person")).getDepartmentID());
			warehouseList=processDistributionMgr.getWarehouseList(deppo);
			return SUCCESS;
		}
	}
	
	/**
	 * 加载员工卡扫描页
	 */
	public String initPensonJScan() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		return SUCCESS;
	}
	public FittingTemplateTypeMgr getFittingTemplateTypeMgr() {
		return fittingTemplateTypeMgr;
	}
	public void setFittingTemplateTypeMgr(
			FittingTemplateTypeMgr fittingTemplateTypeMgr) {
		this.fittingTemplateTypeMgr = fittingTemplateTypeMgr;
	}
}
