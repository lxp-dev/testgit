package com.pengsheng.eims.sales.action;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.basic.persistence.NoteTypePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;
import com.pengsheng.eims.sales.mgr.ShopCodeTakeMgr;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.storage.persistence.StrogeLogPo;
import com.pengsheng.eims.system.mgr.BillKeyMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class ShopCodeTakeAction extends BaseAction {

	private ShopCodeTakeMgr shopCodeTakeMgr;

	private List<SalesBasicPo> shopCodeTakeList;

	private PersonPermissionMgr personPermissionMgr;

	private SmsRecordPo smsRecordPo;

	private CustomerInfoPo customerInfoPo;

	private SmsSetPo smsSetPo;
	private BillKeyMgr billKeyMgr;
	private SalesBasicPo salesBasicPo;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private UnitMgr unitMgr;
	private PersonInfoMgr personInfoMgr;
	private List<PersonInfoPo> personInfoPos;
	
	
	
	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}

	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}

	public List<PersonInfoPo> getPersonInfoPos() {
		return personInfoPos;
	}

	public void setPersonInfoPos(List<PersonInfoPo> personInfoPos) {
		this.personInfoPos = personInfoPos;
	}

	public BillKeyMgr getBillKeyMgr() {
		return billKeyMgr;
	}

	public void setBillKeyMgr(BillKeyMgr billKeyMgr) {
		this.billKeyMgr = billKeyMgr;
	}

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
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
	
	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}

	public SmsSetPo getSmsSetPo() {
		return smsSetPo;
	}

	public void setSmsSetPo(SmsSetPo smsSetPo) {
		this.smsSetPo = smsSetPo;
	}

	public SmsRecordPo getSmsRecordPo() {
		return smsRecordPo;
	}

	public void setSmsRecordPo(SmsRecordPo smsRecordPo) {
		this.smsRecordPo = smsRecordPo;
	}

	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public ShopCodeTakeMgr getShopCodeTakeMgr() {
		return shopCodeTakeMgr;
	}

	public void setShopCodeTakeMgr(ShopCodeTakeMgr shopCodeTakeMgr) {
		this.shopCodeTakeMgr = shopCodeTakeMgr;
	}

	public List<SalesBasicPo> getShopCodeTakeList() {
		return shopCodeTakeList;
	}

	public void setShopCodeTakeList(List<SalesBasicPo> shopCodeTakeList) {
		this.shopCodeTakeList = shopCodeTakeList;
	}

	/**
	 * 初始化门店取镜查询
	 * 
	 * @return
	 */
	public String initShopCodeTakeSel() {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "shopCodeSel";
		}
		return SUCCESS;
	}

	/**
	 * 门店取镜查询
	 * 
	 * @return
	 */
	public String selectShopCodeTake() {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		// 得到部门Id
		// PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		String departmentId = personInfoPo.getDepartmentID();

		String ssesbsalesid = Utility.getName(request.getParameter("shopsalesid"));
		String ssesbsalesdatestarttime = Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
		String ssesbsalesdateendtime = Utility.getName(request.getParameter("ssesbsalesdateendtime"));
		String ssesbpersonName = Utility.getName(request.getParameter("shoppersonName"));
		String memberid=Utility.getName(request.getParameter("memberid"));
		String djsbm=Utility.getName(request.getParameter("djsbm"));
		String psbillid=Utility.getName(request.getParameter("psbillid"));
		
		SalesBasicPo salesPo = new SalesBasicPo();
		salesPo.setSsesblocation(departmentId);
		salesPo.setSsesbsalesid(ssesbsalesid);
		salesPo.setSsesbsalesdatestarttime(ssesbsalesdatestarttime);
		salesPo.setSsesbsalesdateendtime(ssesbsalesdateendtime);
		salesPo.setSsesbpersonName(ssesbpersonName);
		salesPo.setSsesbMemberId(memberid);
		salesPo.setDjsbm(djsbm);
		salesPo.setSsesbdistributionid(psbillid);

		request.setAttribute("shopsalesid", ssesbsalesid);
		request.setAttribute("ssesbsalesdatestarttime",	ssesbsalesdatestarttime);
		request.setAttribute("ssesbsalesdateendtime", ssesbsalesdateendtime);
		request.setAttribute("shoppersonName", ssesbpersonName);
		request.setAttribute("memberid", memberid);
		request.setAttribute("djsbm", djsbm);
		request.setAttribute("psbillid", psbillid);
		
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
		// 总数、分页
		int count = shopCodeTakeMgr.getShopCodeTakeCount(salesPo);
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
			// 取详细信息
			shopCodeTakeList = shopCodeTakeMgr.selectShopCodeTake(salesPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			shopCodeTakeList = null;
		}

		return SUCCESS;
	}

	/**
	 * 门店取镜确认
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String initInsertInTranit() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		String sales = Utility.getName(request.getParameter("sales"));
		String salesType = Utility.getName(request.getParameter("salesType"));
		
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		NoteTypePo npo=unitMgr.getNoteTypePo("6");
		NoteTemplatePo po2 = new NoteTemplatePo();
		po2.setBntname("6");
		po2.setBntautosend("1");
		NoteTemplatePo noteTemplatePo = unitMgr.getNoteTemplateType(po2);
		
		request.setAttribute("first", systemParameterPo.getFspshortmessage());
		request.setAttribute("second", npo.getBntautosend());
		request.setAttribute("content", noteTemplatePo.getBntcontent());
		request.setAttribute("sales", sales);
		request.setAttribute("salesType", salesType);
		return SUCCESS;
	}
	
	
	/**
	 * 门店取镜确认
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String insertInTranit() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		String departmentId = personInfoPo.getDepartmentID();
		
		String ssesbsalesid = Utility.getName(request.getParameter("sales"));
		
		int istake = billKeyMgr.selectProcurementOrderForType("12",ssesbsalesid);
		if(istake == 1){
			this.clearMessages();
			this.addActionMessage("此配镜单已收货，不能进行重复操作！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		
		String goodsSalesType = Utility.getName(request.getParameter("salesType"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 修改
		logPo.setsLogContent("门店取镜销售单："+ssesbsalesid+" 修改");

		// 获取客户名称和电话
		customerInfoPo = shopCodeTakeMgr.getCustomerInfo(ssesbsalesid);
//		smsSetPo = shopCodeTakeMgr.getSmsSet();
//
//		String flag = Utility.getName(smsSetPo.getFssremindflag());
//
//		// 短信记录表
//		SmsRecordPo smsRecordPo = new SmsRecordPo();
//		smsRecordPo.setFsrreceiptperson(customerInfoPo.getSmeciname());// 接收人员
//		smsRecordPo.setFsrreceipttel(customerInfoPo.getSmeciphone());// 接收人员电话
//		smsRecordPo.setFsrsendperson(personInfoPo.getId());// 发送人员
//		smsRecordPo.setFsrsendperson(personInfoPo.getBdpdepartmentname());// 发送人员
		
//		String isSend = Utility.getName(request.getParameter("isSend"));
//		String content = Utility.getName(request.getParameter("content"));
//		SmsRecordPo smsRecordPo=new SmsRecordPo();
//		smsRecordPo.setFsrsendcontext(content);
		
		//获取到镜提醒时间
		salesBasicPo=shopCodeTakeMgr.getSalesBasic(ssesbsalesid);
		
//		String[] text = smsSetPo.getFssremindcontent().split("/D");
//		String time = salesBasicPo.getSsesbsalesdatetime();
////		String customerName = customerInfoPo.getSmeciname();//客户名称
//		String departmentName = personInfoPo.getBdpdepartmentname();
//		for (int i = 0; i < text.length; i++) {
//			String sms = text[0] +time + text[1] + departmentName + text[2] ;
//			smsRecordPo.setFsrsendcontext(sms);// 发送内容
//		}
		// 插入在途明细表信息
		InTransitPo inTransitPo = new InTransitPo();
		inTransitPo.setSseitsalesid(ssesbsalesid);
		inTransitPo.setSseitdepartment(departmentId);
		inTransitPo.setSseitcreateperson(createPerson);
		// 更新销售基表在途
		SalesBasicPo salesPo = new SalesBasicPo();
		salesPo.setSsesbsalesid(ssesbsalesid);
		// 取商品信息

		SendNotePo snpo = new SendNotePo();
		snpo.setSnpersonid(personInfoPo.getId());
		snpo.setSndepartmentid(personInfoPo.getDepartmentID());
		snpo.setSnnotetypeid("6");
		snpo.setSncustomerid(Utility.getName(customerInfoPo.getSmecicustomerid()));
		snpo.setSnbillid(ssesbsalesid);
		
		shopCodeTakeMgr.insertShopCodeTake(snpo, inTransitPo, salesPo,goodsSalesType,customerInfoPo,personInfoPo,logPo);
		
		String salesid = Utility.getName(request.getParameter("shopsalesid"));
		String ssesbsalesdatestarttime = Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
		String ssesbsalesdateendtime = Utility.getName(request.getParameter("ssesbsalesdateendtime"));
		String ssesbpersonName = Utility.getName(request.getParameter("shoppersonName"));
		
		request.setAttribute("shopsalesid", salesid);
		request.setAttribute("ssesbsalesdatestarttime",	ssesbsalesdatestarttime);
		request.setAttribute("ssesbsalesdateendtime", ssesbsalesdateendtime);
		request.setAttribute("shoppersonName", ssesbpersonName);

		String url = "''selectShopCodeTake.action?moduleID={0}''";
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(moduleID));
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));			
		request.setAttribute("flag",  GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	public String initInsertInTranitBulk() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		String sales = Utility.getName(request.getParameter("sales"));
		String salesType = Utility.getName(request.getParameter("salesType"));
		
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		NoteTypePo npo=unitMgr.getNoteTypePo("6");
		NoteTemplatePo po2 = new NoteTemplatePo();
		po2.setBntname("6");
		po2.setBntautosend("1");
		NoteTemplatePo noteTemplatePo = unitMgr.getNoteTemplateType(po2);
		
		request.setAttribute("first", systemParameterPo.getFspshortmessage());
		request.setAttribute("second", npo.getBntautosend());
		request.setAttribute("content", noteTemplatePo.getBntcontent());
		request.setAttribute("sales", sales);
		request.setAttribute("salesType", salesType);
		
		personInfoPos = personInfoMgr.getModulePersoninfoPoList("S0505",personInfoPo.getDepartmentID());
		return SUCCESS;
	}
	
	
	/**
	 * 门店取镜确认
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String insertInTranitBulk() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		String departmentId = personInfoPo.getDepartmentID();
		
		String[] salesids = request.getParameter("salesids").split(",");
		String[] memberids = request.getParameter("memberids").split(",");
		String ssesbsalerid = Utility.getName(request.getParameter("salerid"));
		
		String errorsalesid = "以下销售单号：\\n";
		String errortype = "";
		for (int i = 0; i < salesids.length; i++){
			int istake = billKeyMgr.selectProcurementOrderForType("12",salesids[i]);
			if(istake == 1){
				errorsalesid = errorsalesid + salesids[i]+"\\n";
				errortype = "1";
			}
		}
		if(errortype.equals("1")){
			this.clearMessages();
			this.addActionMessage(errorsalesid+"已收货，不能进行重复操作！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		
		
		String goodsSalesType = Utility.getName(request.getParameter("salesType"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 修改


		// 获取客户名称和电话
		customerInfoPo = new CustomerInfoPo();
//		smsSetPo = shopCodeTakeMgr.getSmsSet();
//
//		String flag = Utility.getName(smsSetPo.getFssremindflag());
//
//		// 短信记录表
//		SmsRecordPo smsRecordPo = new SmsRecordPo();
//		smsRecordPo.setFsrreceiptperson(customerInfoPo.getSmeciname());// 接收人员
//		smsRecordPo.setFsrreceipttel(customerInfoPo.getSmeciphone());// 接收人员电话
//		smsRecordPo.setFsrsendperson(personInfoPo.getId());// 发送人员
//		smsRecordPo.setFsrsendperson(personInfoPo.getBdpdepartmentname());// 发送人员
		
//		String isSend = Utility.getName(request.getParameter("isSend"));
//		String content = Utility.getName(request.getParameter("content"));
//		SmsRecordPo smsRecordPo=new SmsRecordPo();
//		smsRecordPo.setFsrsendcontext(content);
		
//		//获取到镜提醒时间
//		salesBasicPo=shopCodeTakeMgr.getSalesBasic(ssesbsalesid);
		
//		String[] text = smsSetPo.getFssremindcontent().split("/D");
//		String time = salesBasicPo.getSsesbsalesdatetime();
////		String customerName = customerInfoPo.getSmeciname();//客户名称
//		String departmentName = personInfoPo.getBdpdepartmentname();
//		for (int i = 0; i < text.length; i++) {
//			String sms = text[0] +time + text[1] + departmentName + text[2] ;
//			smsRecordPo.setFsrsendcontext(sms);// 发送内容
//		}
		// 插入在途明细表信息
		InTransitPo inTransitPo = new InTransitPo();

		inTransitPo.setSseitdepartment(departmentId);

		// 更新销售基表在途
		SalesBasicPo salesPo = new SalesBasicPo();

		// 取商品信息

		SendNotePo snpo = new SendNotePo();
		snpo.setSnpersonid(personInfoPo.getId());
		snpo.setSndepartmentid(personInfoPo.getDepartmentID());
		snpo.setSnnotetypeid("6");
		snpo.setSncustomerid(Utility.getName(customerInfoPo.getSmecicustomerid()));

		
		shopCodeTakeMgr.insertShopCodeTakeBulk(salesids,memberids,snpo, inTransitPo, salesPo,goodsSalesType,customerInfoPo,personInfoPo,logPo,ssesbsalerid);
		
		String salesid = Utility.getName(request.getParameter("shopsalesid"));
		String ssesbsalesdatestarttime = Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
		String ssesbsalesdateendtime = Utility.getName(request.getParameter("ssesbsalesdateendtime"));
		String ssesbpersonName = Utility.getName(request.getParameter("shoppersonName"));
		
		request.setAttribute("shopsalesid", salesid);
		request.setAttribute("ssesbsalesdatestarttime",	ssesbsalesdatestarttime);
		request.setAttribute("ssesbsalesdateendtime", ssesbsalesdateendtime);
		request.setAttribute("shoppersonName", ssesbpersonName);

		String url = "''selectShopCodeTake.action?moduleID={0}''";
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(moduleID));
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));			
		request.setAttribute("flag",  GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
}
