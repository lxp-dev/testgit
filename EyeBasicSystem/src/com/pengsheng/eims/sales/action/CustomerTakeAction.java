package com.pengsheng.eims.sales.action;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.basic.persistence.NoteTypePo;
import com.pengsheng.eims.components.mgr.InTransitDetailsMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.sales.mgr.CustomerTakeMgr;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.TakeMsgPo;
import com.pengsheng.eims.system.mgr.BillKeyMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class CustomerTakeAction extends BaseAction {

	private SalesBasicPo salesBasicPo;	
	private CustomerTakeMgr customerTakeMgr;	
	private List<SalesBasicPo> customerTakeList;	
	private List<TakeMsgPo> takeMsgList;
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private UnitMgr unitMgr	;
	private BillKeyMgr billKeyMgr;
	private InTransitDetailsMgr inTransitDetailsMgr;
	private List<SalesDetailPo> goodsInfoList;
	private PersonInfoMgr personInfoMgr;
	private List<PersonInfoPo> personInfoPos;
	private TakeMsgPo takeMsgPo;
	
	
	
	public List<PersonInfoPo> getPersonInfoPos() {
		return personInfoPos;
	}

	public void setPersonInfoPos(List<PersonInfoPo> personInfoPos) {
		this.personInfoPos = personInfoPos;
	}

	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}

	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}

	public InTransitDetailsMgr getInTransitDetailsMgr() {
		return inTransitDetailsMgr;
	}

	public void setInTransitDetailsMgr(InTransitDetailsMgr inTransitDetailsMgr) {
		this.inTransitDetailsMgr = inTransitDetailsMgr;
	}

	public List<SalesDetailPo> getGoodsInfoList() {
		return goodsInfoList;
	}

	public void setGoodsInfoList(List<SalesDetailPo> goodsInfoList) {
		this.goodsInfoList = goodsInfoList;
	}

	public BillKeyMgr getBillKeyMgr() {
		return billKeyMgr;
	}

	public void setBillKeyMgr(BillKeyMgr billKeyMgr) {
		this.billKeyMgr = billKeyMgr;
	}

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public CustomerTakeMgr getCustomerTakeMgr() {
		return customerTakeMgr;
	}

	public void setCustomerTakeMgr(CustomerTakeMgr customerTakeMgr) {
		this.customerTakeMgr = customerTakeMgr;
	}

	public List<SalesBasicPo> getCustomerTakeList() {
		return customerTakeList;
	}

	public void setCustomerTakeList(List<SalesBasicPo> customerTakeList) {
		this.customerTakeList = customerTakeList;
	}

	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}

	/**
	 * 初始化顾客取镜
	 * @return
	 */
	public String initCustomerTakeSel(){
		
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "takeSel";
		}
		return SUCCESS;
	}
	
	/**
	 * 查询顾客取镜信息
	 * @return
	 */
	public String selectCustomerTake(){
		
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
		
		
		//得到部门Id
//		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		String departmentId = personInfoPo.getDepartmentID();
		
		String ssesbsalesid=Utility.getName(request.getParameter("shopsalesid"));
		String ssesbsalesdatestarttime=Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
		String ssesbsalesdateendtime=Utility.getName(request.getParameter("ssesbsalesdateendtime"));
		String ssesbpersonName=Utility.getName(request.getParameter("shoppersonName"));
		String memberId=Utility.getName(request.getParameter("memberId"));
		String djsbm=Utility.getName(request.getParameter("djsbm"));
		
		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesblocation(departmentId);
		salesPo.setSsesbsalesid(ssesbsalesid);
		salesPo.setSsesbsalesdatestarttime(ssesbsalesdatestarttime);
		salesPo.setSsesbsalesdateendtime(ssesbsalesdateendtime);
		salesPo.setSsesbpersonName(ssesbpersonName);
		salesPo.setSsesbMemberId(memberId);
		salesPo.setDjsbm(djsbm);
		
		request.setAttribute("shopsalesid", ssesbsalesid);
		request.setAttribute("ssesbsalesdatestarttime", ssesbsalesdatestarttime);
		request.setAttribute("ssesbsalesdateendtime", ssesbsalesdateendtime);
		request.setAttribute("shoppersonName", ssesbpersonName);
		request.setAttribute("memberId", memberId);
		request.setAttribute("djsbm", djsbm);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1")){
			this.setIsFirstExec("0");
			request.setAttribute("showhider", (Utility.getName(systemParameterPo.getFspshowchange()).equals("3") ? "0" : "2"));
		}else{	
			String showchange = Utility.getName(systemParameterPo.getFspselectovershowchange());
			if (showchange.equals("0")){
				request.setAttribute("showhider","0");
			}else{
				request.setAttribute("showhider", "2");
			}
		}
		//总数、分页
		int count=customerTakeMgr.getCustomerTakeCount(salesPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request
							.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
	    Pagination page = new Pagination(request, count, perPage);
	    //取详细信息
	    customerTakeList=customerTakeMgr.selectCustomerTake(salesPo , page.getStart() , page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			customerTakeList = null;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始化顾客取镜
	 * @return
	 */
	public String initTakeMsgSel(){
		
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "takeMsgSel";
		}
		return SUCCESS;
	}
	
	/**
	 * 查询顾客取镜信息
	 * @return
	 */
	public String takeMsgSel(){
		
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

		TakeMsgPo takeMsgPo = new TakeMsgPo();
		String page_salesid=Utility.getName(request.getParameter("page_salesid"));
		String page_name=Utility.getName(request.getParameter("page_name"));
		String page_phone=Utility.getName(request.getParameter("page_phone"));
		String page_identitycard=Utility.getName(request.getParameter("page_identitycard"));
		String page_starttime=Utility.getName(request.getParameter("page_starttime"));
		String page_endtime=Utility.getName(request.getParameter("page_endtime"));
		String page_remark=Utility.getName(request.getParameter("page_remark"));
		
		takeMsgPo.setSalesid(page_salesid);
		takeMsgPo.setName(page_name);
		takeMsgPo.setPhone(page_phone);
		takeMsgPo.setIdentitycard(page_identitycard);
		takeMsgPo.setPagestarttime(page_starttime);
		takeMsgPo.setPageendtime(page_endtime);
		takeMsgPo.setRemark(page_remark);
		
		request.setAttribute("page_salesid", page_salesid);
		request.setAttribute("page_name", page_name);
		request.setAttribute("page_phone", page_phone);
		request.setAttribute("page_identitycard", page_identitycard);
		request.setAttribute("page_starttime", page_starttime);
		request.setAttribute("page_endtime", page_endtime);
		request.setAttribute("page_remark", page_remark);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1")){
			this.setIsFirstExec("0");
			request.setAttribute("showhider", (Utility.getName(systemParameterPo.getFspshowchange()).equals("3") ? "0" : "2"));
		}else{	
			String showchange = Utility.getName(systemParameterPo.getFspselectovershowchange());
			if (showchange.equals("0")){
				request.setAttribute("showhider","0");
			}else{
				request.setAttribute("showhider", "2");
			}
		}
		//总数、分页
		int count=customerTakeMgr.getTakeMsgCount(takeMsgPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request
							.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
	    Pagination page = new Pagination(request, count, perPage);
	    //取详细信息
	    takeMsgList=customerTakeMgr.selectTakeMsgList(takeMsgPo , page.getStart() , page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			takeMsgList = null;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 顾客取镜信息插入在途明细表中
	 * @return
	 */
	public String initInsertCustInTranit(){
		
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
		
		String departmentId = personInfoPo.getDepartmentID();
		
		String sales=Utility.getName(request.getParameter("sales"));
		String ssesbMemberId=Utility.getName(request.getParameter("ssesbMemberId"));
		request.setAttribute("sales", sales);
		request.setAttribute("ssesbMemberId", ssesbMemberId);
	
		return SUCCESS;
	}
	/**
	 * 顾客取镜信息插入在途明细表中
	 * @return
	 */
	public String insertCustInTranit(){
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
		
		String departmentId = personInfoPo.getDepartmentID();
		String ssesbsalesid=Utility.getName(request.getParameter("sales"));
		
		String chkValue = Utility.getName(request.getParameter("chkValue"));
		String name = Utility.getName(request.getParameter("name"));
		String telphone = Utility.getName(request.getParameter("telphone"));
		String identitycard = Utility.getName(request.getParameter("identitycard"));
		String remark = Utility.getName(request.getParameter("remark"));
		
		
		
		int istake = billKeyMgr.selectProcurementOrderForType("13",ssesbsalesid);
		if(istake == 1){
			this.clearMessages();
			this.addActionMessage("该配镜单已取镜，不能进行重复操作！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
																   
		String ssesbMemberId=Utility.getName(request.getParameter("ssesbMemberId"));
		
/***********************************************************************************************************/		
		
		
		// 商品详细信息List
		SalesDetailPo salesDetailPo = new SalesDetailPo();
		salesDetailPo.setSsesdsalesid(ssesbsalesid);
		goodsInfoList = inTransitDetailsMgr.getGoodsInfo(salesDetailPo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		NoteTypePo npo=unitMgr.getNoteTypePo("13");
		NoteTemplatePo ntp=new NoteTemplatePo();
		if(systemParameterPo.getFspshortmessage().equals("1") || systemParameterPo.getFspshortmessage().equals("2"))
		{
			if(Utility.getName(npo.getBntautosend()).equals("1"))
			{
				NoteTemplatePo po2 = new NoteTemplatePo();
				po2.setBntname("13");
				po2.setBntautosend("1");
				NoteTemplatePo noteTemplatePo = unitMgr.getNoteTemplateType(po2);
				ntp=unitMgr.getNoteTemplateDetail(noteTemplatePo);
			}
		}

		InTransitPo inTransitPo=new InTransitPo();
		inTransitPo.setSseitsalesid(ssesbsalesid);
		inTransitPo.setSseitdepartment(departmentId);
		inTransitPo.setSseitcreateperson(createPerson);
		
		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesbsalesid(ssesbsalesid);
		SalesBasicPo salesBaPo = inTransitDetailsMgr.getCustomerInfo(salesPo);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); 	// 模块ID
		logPo.setsLogOpID("3");    		// 修改
		logPo.setsLogContent("配镜单："+ssesbsalesid+"顾客已取镜!");
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		if(chkValue.equals("1")){
			takeMsgPo = new TakeMsgPo();
			takeMsgPo.setName(name);
			takeMsgPo.setPhone(telphone);
			takeMsgPo.setIdentitycard(identitycard);
			takeMsgPo.setRemark(remark);
			takeMsgPo.setSalesid(ssesbsalesid);
		}
		
		String message = customerTakeMgr.insertCustomerTakeCheck(inTransitPo, salesBaPo,ntp,goodsInfoList,personInfoPo,ssesbMemberId,logPo,systemParameterPo,takeMsgPo);
		
		String salesid=Utility.getName(request.getParameter("shopsalesid"));
		String ssesbsalesdatestarttime=Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
		String ssesbsalesdateendtime=Utility.getName(request.getParameter("ssesbsalesdateendtime"));
		String ssesbpersonName=Utility.getName(request.getParameter("shoppersonName"));
		String memberId=Utility.getName(request.getParameter("memberId"));
		
		request.setAttribute("shopsalesid", salesid);
		request.setAttribute("ssesbsalesdatestarttime", ssesbsalesdatestarttime);
		request.setAttribute("ssesbsalesdateendtime", ssesbsalesdateendtime);
		request.setAttribute("shoppersonName", ssesbpersonName);
		request.setAttribute("memberId", memberId);
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(moduleID));
		String url = "''selectCustomerTake.action?moduleID={0}''";
		
		this.clearMessages();
		this.addActionMessage(message);
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));			
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 顾客取镜信息插入在途明细表中
	 * @return
	 */
	public String initInsertCustInTranitBulk(){
		
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
		
		String departmentId = personInfoPo.getDepartmentID();
		
		personInfoPos = personInfoMgr.getModulePersoninfoPoList("S0506",personInfoPo.getDepartmentID());
				
		return SUCCESS;
	}
	/**
	 * 顾客取镜信息插入在途明细表中
	 * @return
	 */
	public String insertCustInTranitBulk(){
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
		
		String departmentId = personInfoPo.getDepartmentID();
		String[] salesids = request.getParameter("salesids").split(",");
		String[] memberids = request.getParameter("memberids").split(",");
		String ssesbsalerid = Utility.getName(request.getParameter("salerid"));
		
		String errorsalesid = "以下销售单号：\\n";
		String errortype = "";
		for (int i = 0; i < salesids.length; i++){
			int istake = billKeyMgr.selectProcurementOrderForType("13",salesids[i]);
			if(istake == 1){
				errorsalesid = errorsalesid + salesids[i]+"\\n";
				errortype = "1";
			}
		}
		if(errortype.equals("1")){
			this.clearMessages();
			this.addActionMessage(errorsalesid+"已被取镜，不能进行重复操作！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); 	// 模块ID
		logPo.setsLogOpID("3");    		// 修改
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		NoteTypePo npo=unitMgr.getNoteTypePo("13");
		NoteTemplatePo ntp=new NoteTemplatePo();
		if(systemParameterPo.getFspshortmessage().equals("1") || systemParameterPo.getFspshortmessage().equals("2"))
		{
			if(npo.getBntautosend().equals("1")){
				NoteTemplatePo po2 = new NoteTemplatePo();
				po2.setBntname("13");
				po2.setBntautosend("1");
				NoteTemplatePo noteTemplatePo = unitMgr.getNoteTemplateType(po2);
				ntp=unitMgr.getNoteTemplateDetail(noteTemplatePo);
			}
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String message = customerTakeMgr.insertCustomerTakeBulkCheck(salesids,memberids,ntp,personInfoPo,ssesbsalerid,systemParameterPo,logPo);
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(moduleID));
		String url = "''selectCustomerTake.action?moduleID={0}''";
		
		this.clearMessages();
		this.addActionMessage(message);
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));			
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

	public TakeMsgPo getTakeMsgPo() {
		return takeMsgPo;
	}

	public void setTakeMsgPo(TakeMsgPo takeMsgPo) {
		this.takeMsgPo = takeMsgPo;
	}

	public List<TakeMsgPo> getTakeMsgList() {
		return takeMsgList;
	}

	public void setTakeMsgList(List<TakeMsgPo> takeMsgList) {
		this.takeMsgList = takeMsgList;
	}
}
