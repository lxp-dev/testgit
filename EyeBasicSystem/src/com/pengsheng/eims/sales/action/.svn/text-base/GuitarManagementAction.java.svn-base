/**
 * 
 */
package com.pengsheng.eims.sales.action;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.mgr.ChuzhikaMgr;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.mgr.WarehouseConfigurationMgr;
import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.basic.persistence.NoteTypePo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.components.mgr.InTransitDetailsMgr;
import com.pengsheng.eims.his.mgr.HisMgr;
import com.pengsheng.eims.his.mgr.HisParamMgr;
import com.pengsheng.eims.his.persistence.HisParamPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.sales.mgr.ArrearsMgr;
import com.pengsheng.eims.sales.mgr.CashCouponMgr;
import com.pengsheng.eims.sales.mgr.GuitarManagementMgr;
import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.system.mgr.BillKeyMgr;
import com.pengsheng.eims.system.mgr.BrankCardMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.ExternalAccountParameterMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SendNoteMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.BankPo;
import com.pengsheng.eims.system.persistence.BrankCardPo;
import com.pengsheng.eims.system.persistence.ExternalAccountParameterPo;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.persistence.ConfigurationPo;
import com.pengsheng.weixin.persistence.WeixinInviteFriendLogPo;

public class GuitarManagementAction extends BaseAction {
	
	private GuitarManagementMgr guitarManagementMgr;
	private CustomerInfoMgr customerInfoMgr;
	private CustomerInfoPo customerInfoPo;
	private List<SalesBasicPo> salesBasicPos;	
	private ChuzhikaPo chuzhikaPo;	
	private ChuzhikaMgr chuzhikaMgr;	
	private SalesBasicPo salesBasicPo;	
	private ArrearsMgr arrearsMgr;	
	private List<BrankCardPo> brankCardPos;	
	private List<BankPo> bankPos;
	private List<BankPo> otherbankPos;
	private BrankCardMgr brankCardMgr;	
	private SystemParameterMgr systemParameterMgr;	
	private SystemParameterPo systemParameterPo;	
	private DepartmentsMgr departmentsMgr;
	private UnitMgr unitMgr;
	private PersonPermissionMgr personPermissionMgr;
	private WarehouseConfigurationMgr warehouseConfigurationMgr; 
	private WarehouseConfigurationPo warehouseConfigurationPo; 
	private BillKeyMgr billKeyMgr;
	private InTransitDetailsMgr inTransitDetailsMgr;
	private List<SalesDetailPo> salesDetailPos;
	private ExternalAccountParameterMgr externalAccountParameterMgr = null;
	private CashCouponMgr cashCouponMgr;
	private CashCouponPo cashCouponPo;
	private List<SalesDetailPo> goodsInfoList;
	private SendNoteMgr sendNoteMgr;
	private ReportQuartzMgr reportQuartzMgr;
	private FquartzSwitchPo fquartzSwitchPo;
	private HisMgr hisMgr;
	private HisParamMgr hisParamMgr;
	
	
	public HisParamMgr getHisParamMgr() {
		return hisParamMgr;
	}
	public void setHisParamMgr(HisParamMgr hisParamMgr) {
		this.hisParamMgr = hisParamMgr;
	}
	public HisMgr getHisMgr() {
		return hisMgr;
	}
	public void setHisMgr(HisMgr hisMgr) {
		this.hisMgr = hisMgr;
	}
	public ReportQuartzMgr getReportQuartzMgr() {
		return reportQuartzMgr;
	}
	public void setReportQuartzMgr(ReportQuartzMgr reportQuartzMgr) {
		this.reportQuartzMgr = reportQuartzMgr;
	}

	public FquartzSwitchPo getFquartzSwitchPo() {
		return fquartzSwitchPo;
	}

	public void setFquartzSwitchPo(FquartzSwitchPo fquartzSwitchPo) {
		this.fquartzSwitchPo = fquartzSwitchPo;
	}

	public SendNoteMgr getSendNoteMgr() {
		return sendNoteMgr;
	}

	public void setSendNoteMgr(SendNoteMgr sendNoteMgr) {
		this.sendNoteMgr = sendNoteMgr;
	}

	public List<SalesDetailPo> getGoodsInfoList() {
		return goodsInfoList;
	}

	public void setGoodsInfoList(List<SalesDetailPo> goodsInfoList) {
		this.goodsInfoList = goodsInfoList;
	}

	public CashCouponPo getCashCouponPo() {
		return cashCouponPo;
	}

	public void setCashCouponPo(CashCouponPo cashCouponPo) {
		this.cashCouponPo = cashCouponPo;
	}

	public CashCouponMgr getCashCouponMgr() {
		return cashCouponMgr;
	}

	public void setCashCouponMgr(CashCouponMgr cashCouponMgr) {
		this.cashCouponMgr = cashCouponMgr;
	}

	public List<BankPo> getOtherbankPos() {
		return otherbankPos;
	}

	public void setOtherbankPos(List<BankPo> otherbankPos) {
		this.otherbankPos = otherbankPos;
	}

	public ExternalAccountParameterMgr getExternalAccountParameterMgr() {
		return externalAccountParameterMgr;
	}

	public void setExternalAccountParameterMgr(
			ExternalAccountParameterMgr externalAccountParameterMgr) {
		this.externalAccountParameterMgr = externalAccountParameterMgr;
	}

	public List<SalesDetailPo> getSalesDetailPos() {
		return salesDetailPos;
	}

	public void setSalesDetailPos(List<SalesDetailPo> salesDetailPos) {
		this.salesDetailPos = salesDetailPos;
	}

	public InTransitDetailsMgr getInTransitDetailsMgr() {
		return inTransitDetailsMgr;
	}

	public void setInTransitDetailsMgr(InTransitDetailsMgr inTransitDetailsMgr) {
		this.inTransitDetailsMgr = inTransitDetailsMgr;
	}

	public BillKeyMgr getBillKeyMgr() {
		return billKeyMgr;
	}

	public void setBillKeyMgr(BillKeyMgr billKeyMgr) {
		this.billKeyMgr = billKeyMgr;
	}

	public List<BankPo> getBankPos() {
		return bankPos;
	}

	public void setBankPos(List<BankPo> bankPos) {
		this.bankPos = bankPos;
	}

	public WarehouseConfigurationPo getWarehouseConfigurationPo() {
		return warehouseConfigurationPo;
	}

	public void setWarehouseConfigurationPo(
			WarehouseConfigurationPo warehouseConfigurationPo) {
		this.warehouseConfigurationPo = warehouseConfigurationPo;
	}

	public WarehouseConfigurationMgr getWarehouseConfigurationMgr() {
		return warehouseConfigurationMgr;
	}

	public void setWarehouseConfigurationMgr(
			WarehouseConfigurationMgr warehouseConfigurationMgr) {
		this.warehouseConfigurationMgr = warehouseConfigurationMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
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

	public List<BrankCardPo> getBrankCardPos() {
		return brankCardPos;
	}

	public void setBrankCardPos(List<BrankCardPo> brankCardPos) {
		this.brankCardPos = brankCardPos;
	}

	public BrankCardMgr getBrankCardMgr() {
		return brankCardMgr;
	}

	public void setBrankCardMgr(BrankCardMgr brankCardMgr) {
		this.brankCardMgr = brankCardMgr;
	}

	public ArrearsMgr getArrearsMgr() {
		return arrearsMgr;
	}

	public void setArrearsMgr(ArrearsMgr arrearsMgr) {
		this.arrearsMgr = arrearsMgr;
	}

	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}

	public ChuzhikaPo getChuzhikaPo() {
		return chuzhikaPo;
	}

	public void setChuzhikaPo(ChuzhikaPo chuzhikaPo) {
		this.chuzhikaPo = chuzhikaPo;
	}

	public ChuzhikaMgr getChuzhikaMgr() {
		return chuzhikaMgr;
	}

	public void setChuzhikaMgr(ChuzhikaMgr chuzhikaMgr) {
		this.chuzhikaMgr = chuzhikaMgr;
	}

	public GuitarManagementMgr getGuitarManagementMgr() {
		return guitarManagementMgr;
	}

	public void setGuitarManagementMgr(GuitarManagementMgr guitarManagementMgr) {
		this.guitarManagementMgr = guitarManagementMgr;
	}

	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}

	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	public List<SalesBasicPo> getSalesBasicPos() {
		return salesBasicPos;
	}

	public void setSalesBasicPos(List<SalesBasicPo> salesBasicPos) {
		this.salesBasicPos = salesBasicPos;
	}

	public String initGuitarManagement() {
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
		//将该部门对应的配镜单模版赋值到systemParameterPo
		systemParameterPo = systemParameterMgr.getSystemParameterPoDepartmentBillTemplate(systemParameterPo,personInfoPo.getDepartmentID());

		request.setAttribute("departmentID", personInfoPo.getDepartmentID());
		request.setAttribute("tid", personInfoPo.getId());
		
		return SUCCESS;
	}

	public String selGuitarManagement() {
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
		
		String memberId = Utility.getName(request.getParameter("smecimemberid"));
		String salesid = Utility.getName(request.getParameter("fmmsalesid"));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setSmecimemberid(memberId);
		customerInfoPo.setFmmsalesid(salesid);
		customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
		
		request.setAttribute("smecimemberid", memberId);
		request.setAttribute("fmmsalesid", salesid);
		request.setAttribute("departmentID", personInfoPo.getDepartmentID());
		request.setAttribute("tid", personInfoPo.getId());

		if (StringUtils.isNotEmpty(salesid)) {
			customerInfoPo = guitarManagementMgr.getCustmorInfoNoFinished(customerInfoPo);
			request.setAttribute("salesID", Utility.getName(request.getParameter("salesID")));

		} else if (StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			customerInfoPo = customerInfoMgr.getCustomerInfoNoFinished(customerInfoPo);
		}

		if (StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {
			
			SalesBasicPo salesBasicPo = new SalesBasicPo();
			salesBasicPo.setSsesbshopcode(personInfoPo.getDepartmentID());
			salesBasicPo.setSsesbsalesid(salesid);			
			salesBasicPo.setSsesbcustomerid(customerInfoPo.getSmecicustomerid());
			
			salesBasicPos = guitarManagementMgr.getSalesBasicNoFinished(salesBasicPo);
		}
		
		return SUCCESS;
	}

	public String insertGuitarManagement() {
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
		salesBasicPo.setSsesbshopcode(personInfoPo.getDepartmentID());
		
		String salseID = Utility.getName(request.getParameter("salseID"));
		int istake = billKeyMgr.selectProcurementOrderForType("2",salseID);
		if(istake == 1){
			this.clearMessages();
			this.addActionMessage("该配镜单已结款，不能进行重复操作！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		
		String orderType = Utility.getName(request.getParameter("ssesborderstype"));    // 销售类型
		String checkoutFlag = Utility.getName(request.getParameter("checkoutFlag"));    // 欠款状态
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		NoteTemplatePo ntp = null;
		SendNotePo snpo = null;
		SendNotePo snpo2 = null;
		
		if(systemParameterPo.getFspshortmessage().equals("1") || systemParameterPo.getFspshortmessage().equals("2")){  // 判断是否开启短信

			List<NoteTemplatePo> ntpoList = sendNoteMgr.getSendNoteTemplateCount();  // 返回3行记录			
			
			if (Integer.valueOf(ntpoList.get(0).getBnttypecount()) > 0){
				NoteTemplatePo po2 = new NoteTemplatePo();
				po2.setBntname("13");    // 隐形效期
				po2.setBntautosend("1");
				NoteTemplatePo noteTemplatePo = unitMgr.getNoteTemplateType(po2);
				ntp = unitMgr.getNoteTemplateDetail(noteTemplatePo);
			}
			
			if (Integer.valueOf(ntpoList.get(1).getBnttypecount()) > 0){
				snpo = new SendNotePo();
				snpo.setSnpersonid(personInfoPo.getId());
				snpo.setSndepartmentid(personInfoPo.getDepartmentID());
				snpo.setSnnotetypeid("9");
				snpo.setSnbillid(salseID);  // 结款
			}

			if (Integer.valueOf(ntpoList.get(2).getBnttypecount()) > 0){
				snpo2 = new SendNotePo();
				snpo2.setSnpersonid(personInfoPo.getId());
				snpo2.setSndepartmentid(personInfoPo.getDepartmentID());
				snpo2.setSnbillid(salseID);
				snpo2.setSnnotetypeid("12");   // 结款订制片
			}
		}
		
		SalesBasicPo sales = new SalesBasicPo();
		sales.setSsesbsalesid(salseID);
		sales.setSsesbjfamount(Utility.getName(request.getParameter("jfsumcount")));
		sales.setSsesborderstype(orderType);
		sales.setSsesbcheckoutflag(checkoutFlag);
		sales.setSsesbposid(personInfoPo.getId());
		sales.setSsesbsalesvalue(Utility.getName(request.getParameter("salseValue")));
		sales.setSsesbMemberId(Utility.getName(request.getParameter("smecimemberid")));
		// Mgr参数
		sales.setSsesbcustomerid(Utility.getName(salesBasicPo.getSsesbcustomerid()));
		sales.setSsesbfcustomerid(Utility.getName(salesBasicPo.getSsesbfcustomerid()));	
		sales.setSsesbshopcode(Utility.getName(salesBasicPo.getSsesbshopcode()));
		sales.setSsesbshopName(Utility.getName(salesBasicPo.getSsesbshopName()));
		sales.setSsesbsalestelphone(Utility.getName(salesBasicPo.getSsesbsalestelphone()));
		sales.setSsesbpsalsvalue(Utility.getName(salesBasicPo.getSsesbpsalsvalue()));
		sales.setSsesbdoublezz(Utility.getName(salesBasicPo.getSsesbdoublezz()));
		
		int xjType = Utility.getName(systemParameterPo.getFspcollecttype()).indexOf("1");   // 现金
		int jfType = Utility.getName(systemParameterPo.getFspcollecttype()).indexOf("2");   // 积分
		int yhkType = Utility.getName(systemParameterPo.getFspcollecttype()).indexOf("3");  // 银行卡
		int czkType = Utility.getName(systemParameterPo.getFspcollecttype()).indexOf("4");  // 储值卡
		int djqType = Utility.getName(systemParameterPo.getFspcollecttype()).indexOf("7");  // 代金券
		int qtType = Utility.getName(systemParameterPo.getFspcollecttype()).indexOf("6");   // 其他付款
		
		String[] xjvs = null;    // 现金
		String[] jfvs = null;   // 积分
		String[] yhkvs = null;  // 银行卡金额
		String[] yhkts = null;  // 银行ID
		String[] czkvs = null;  // 储值卡金额
		String[] czkids = null;   // 储值卡号
		String[] czkyes = null;   // 储值卡余额		 
		String[] qtvs = null;  // 其他金额
		String[] qtts = null;	// 其他付款方式ID
		String[] djqvs = null;   // 代金券金额
		String[] djqids = null;  // 代金券号
		List<SalesLogPo> salesLogPos = new ArrayList<SalesLogPo>();   // 付款方式列表
		List<ChuzhikaPo> czklist = null;    // 储值卡消费记录列表
		List<CashCouponPo> djqlist = null;  // 代金券消费记录列表
		BigDecimal bigd = null;     // 银行卡 + 代金券  + 其他付款的总金额
		
		if (xjType >= 0){
			bigd = new BigDecimal("0.00");
			xjvs = request.getParameterValues("xjv");    // 现金			
			
			if(xjvs != null){
				for(int i=0; i<xjvs.length; i++){
					BigDecimal bigd2 = new BigDecimal(xjvs[i]);
					SalesLogPo salesLogPo = new SalesLogPo();
					salesLogPo.setSseslsalesid(salseID);
					if("1".equals(Utility.getName(checkoutFlag))){
						salesLogPo.setSseslpaymenttype("2");
					}else{
						salesLogPo.setSseslpaymenttype("1");
					}
					salesLogPo.setSseslconsumptionid("1");
					salesLogPo.setSseslsourceid("");
					salesLogPo.setSseslprice(xjvs[i]);
					salesLogPo.setSseslperson(personInfoPo.getId());
					salesLogPo.setSseslorderby("");
					salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
					salesLogPo.setSsesltype("1");
					
					salesLogPos.add(salesLogPo);
					
					bigd = bigd.add(bigd2);
				}
			}
			
			sales.setSsesbpaycash(bigd.toString());
		}else{
			sales.setSsesbpaycash("0.00");
		}
		
		if (jfType >= 0){
			jfvs = request.getParameterValues("jfv");    // 积分

			if(jfvs != null){
				BigDecimal jftotal = new BigDecimal("0");
				BigDecimal jfdktotal = null;
				
				if (!"".equals(Utility.getName(systemParameterPo.getFspexchangeintegral()).trim())){
					jfdktotal = new BigDecimal(Utility.getName(systemParameterPo.getFspexchangeintegral()));
				}else{
					jfdktotal = new BigDecimal("0.00");
				}
				
				for(int i=0; i<jfvs.length; i++){
					BigDecimal bigd2 = new BigDecimal(jfvs[i]);
					SalesLogPo salesLogPo = new SalesLogPo();
					salesLogPo.setSseslsalesid(salseID);
					if("1".equals(Utility.getName(checkoutFlag))){
						salesLogPo.setSseslpaymenttype("2");
					}else{
						salesLogPo.setSseslpaymenttype("1");
					}
					salesLogPo.setSseslconsumptionid("2");
					salesLogPo.setSseslsourceid("");
					salesLogPo.setSseslprice(jfvs[i]);
					salesLogPo.setSseslperson(personInfoPo.getId());
					salesLogPo.setSseslorderby("");
					salesLogPo.setSseslintegralprice(jfdktotal.multiply(bigd2).setScale(2, BigDecimal.ROUND_HALF_UP).toString());	
					salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
					salesLogPo.setSsesltype("1");
					
					salesLogPos.add(salesLogPo);
					
					jftotal = jftotal.add(bigd2);
				}
				
				sales.setNowintegral(jftotal.toString());
				sales.setSsesbintegralprice(jfdktotal.multiply(jftotal).setScale(2, BigDecimal.ROUND_HALF_UP).toString());	
			}else{
				sales.setNowintegral("0");
				sales.setSsesbintegralprice("0.00");
			}		
		}else{
			sales.setNowintegral("0");
			sales.setSsesbintegralprice("0.00");				
		}

		BigDecimal yhktotal = null; 
		if ((yhkType >= 0) || (djqType >= 0) || (qtType >= 0)){
			yhktotal = new BigDecimal("0.00");
		}
		
		if (yhkType >= 0){			
			yhkvs = request.getParameterValues("yhkv");  // 银行卡金额			

			if(yhkvs != null){
				yhkts = request.getParameterValues("yhkt");  // 银行ID
				
				for(int i=0; i<yhkvs.length; i++){
					BigDecimal bigd2 = new BigDecimal(yhkvs[i]);
					SalesLogPo salesLogPo = new SalesLogPo();
					salesLogPo.setSseslsalesid(salseID);
					if("1".equals(Utility.getName(checkoutFlag))){
						salesLogPo.setSseslpaymenttype("2");
					}else{
						salesLogPo.setSseslpaymenttype("1");
					}
					salesLogPo.setSseslconsumptionid("3");
					salesLogPo.setSseslsourceid(yhkts[i]);
					salesLogPo.setSseslprice(yhkvs[i]);
					salesLogPo.setSseslperson(personInfoPo.getId());
					salesLogPo.setSseslorderby("");
					salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
					salesLogPo.setSsesltype("1");
					
					salesLogPos.add(salesLogPo);
					
					yhktotal = yhktotal.add(bigd2);
				}	
			}
		}

        if (qtType >= 0){
    		qtvs = request.getParameterValues("qtv");  // 其他金额
    		
    		if(qtvs != null){
    			qtts = request.getParameterValues("qtt");	// 其他付款方式ID
    			
        		for(int i=0; i<qtvs.length; i++){
        			BigDecimal bigd2 = new BigDecimal(qtvs[i]);
        			SalesLogPo salesLogPo = new SalesLogPo();
        			salesLogPo.setSseslsalesid(salseID);
        			if("1".equals(Utility.getName(checkoutFlag))){
        				salesLogPo.setSseslpaymenttype("2");
        			}else{
        				salesLogPo.setSseslpaymenttype("1");
        			}
        			salesLogPo.setSseslconsumptionid("6");
        			salesLogPo.setSseslsourceid(qtts[i]);
        			salesLogPo.setSseslprice(qtvs[i]);
        			salesLogPo.setSseslperson(personInfoPo.getId());
        			salesLogPo.setSseslorderby("");
        			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
        			salesLogPo.setSsesltype("1");
        			
        			salesLogPos.add(salesLogPo);
        			yhktotal = yhktotal.add(bigd2);
        		}
    		}
        }
		
		if (djqType >= 0){
			djqvs = request.getParameterValues("djqv");   // 代金券金额		
			
			if(djqvs != null){
				djqids = request.getParameterValues("djqid");  // 代金券号
				djqlist = new ArrayList<CashCouponPo>();
				
				for(int i=0; i<djqvs.length; i++){
					BigDecimal bigd2 = new BigDecimal(djqvs[i]);
					SalesLogPo salesLogPo = new SalesLogPo();
					salesLogPo.setSseslsalesid(salseID);
					if("1".equals(Utility.getName(checkoutFlag))){
						salesLogPo.setSseslpaymenttype("2");
					}else{
						salesLogPo.setSseslpaymenttype("1");
					}
					salesLogPo.setSseslconsumptionid("7");
					salesLogPo.setSseslsourceid(djqids[i]);
					salesLogPo.setSseslprice(djqvs[i]);
					salesLogPo.setSseslperson(personInfoPo.getId());
					salesLogPo.setSseslorderby("");
					salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
					salesLogPo.setSsesltype("1");
					
					salesLogPos.add(salesLogPo);
					yhktotal = yhktotal.add(bigd2);
					
					if(Float.parseFloat(djqvs[i]) > 0){
						CashCouponPo couponPo=new CashCouponPo();

						couponPo.setBcccard(djqids[i]);
						couponPo.setBccuseperson(personInfoPo.getId());
						couponPo.setBccuseflag("1");
						couponPo.setBccuseamount(djqvs[i]);
						
						couponPo.setBcccustomer(Utility.getName(salesBasicPo.getSsesbcustomerid()));
						
						djqlist.add(couponPo);
					}
				}
			}
		}
		
		if (yhktotal == null){
			sales.setSsesbbankcard("0.00");
		}else{
			sales.setSsesbbankcard(yhktotal.toString());
		}		
		
		if (czkType >= 0){
			czkvs = request.getParameterValues("czkv");  // 储值卡金额			
			
			if(czkvs != null){
				czkids = request.getParameterValues("czkid");   // 储值卡号
				czkyes = request.getParameterValues("czkye");   // 储值卡余额
				czklist = new ArrayList<ChuzhikaPo>();			
				BigDecimal czktotal = new BigDecimal("0.00");
				
				for(int i=0; i<czkvs.length; i++){			
					BigDecimal bigd2 = new BigDecimal(czkvs[i]);
					SalesLogPo salesLogPo = new SalesLogPo();
					salesLogPo.setSseslsalesid(salseID);
					if("1".equals(Utility.getName(checkoutFlag))){
						salesLogPo.setSseslpaymenttype("2");
					}else{
						salesLogPo.setSseslpaymenttype("1");
					}
					salesLogPo.setSseslconsumptionid("4");
					salesLogPo.setSseslsourceid(czkids[i]);
					salesLogPo.setSseslprice(czkvs[i]);
					salesLogPo.setSseslperson(personInfoPo.getId());
					salesLogPo.setSseslorderby("");
					salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
					salesLogPo.setSsesltype("1");
					
					salesLogPos.add(salesLogPo);
					czktotal = czktotal.add(bigd2);
					
					if(Float.parseFloat(czkvs[i]) > 0){
						ChuzhikaPo po = new ChuzhikaPo();
						po.setCstczkchongzhijine("-"+czkvs[i]);
						po.setCstczkjiankaren(personInfoPo.getId());
						po.setCstczkjine(czkyes[i]);
						po.setCstczkid(czkids[i]);
						po.setCstczkllinkbillid(salseID);
						po.setCstczklyue(czkyes[i]);
						po.setCstczksalesamount(Utility.getName(czkvs[i]).equals("") ? "0.00" : Utility.getName(czkvs[i]));
						po.setCstczksalesstore(personInfoPo.getDepartmentID());
						po.setCstczksalesdate("1");
						
						czklist.add(po);
					}
				}
				
				sales.setSsesbstoredcard(czktotal.toString());	
			}else{
				sales.setSsesbstoredcard("0.00");	
			}
		
		}else{
			sales.setSsesbstoredcard("0.00");	
		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 新增
		logPo.setsLogContent("配镜单："+request.getParameter("salseID")+" 结款!");
		
		InTransitPo inTransitPo = new InTransitPo();
		inTransitPo.setSseitsalesid(sales.getSsesbsalesid());
		inTransitPo.setSseitdepartment(personInfoPo.getDepartmentID());
		inTransitPo.setSseitcreateperson(personInfoPo.getId());
		
		String url ="";
		String print = "1";   // 控制是否打印配镜单和订金单
		String msg = "";      //提示信息
		String autopay = Utility.getName(request.getParameter("autopay"));
		String returnUrl = Utility.getName(request.getParameter("returnUrl"));
		
		int count = guitarManagementMgr.getSalesBillCount(Utility.getName(sales.getSsesbsalesid()));  //判断配镜单是否被删除
		if (count > 0){
			int fukucun = 1;
			if ("0".equals(Utility.getName(systemParameterPo.getFspsalestype()))){  //不允许负库存销售
				fukucun = guitarManagementMgr.getNegativeStockBySalesGoods(Utility.getName(sales.getSsesbsalesid()), systemParameterPo,"1",new ArrayList<SalesDetailPo>()); // 负库存验证
			}
			if (fukucun > 0){
				ConfigurationPo weixin = (ConfigurationPo)session.get("weixin");
				WeixinInviteFriendLogPo weixinpo = new WeixinInviteFriendLogPo();
				if("1".equals(weixin.getWcryqhysjftype())){
					String cphone = Utility.getName(request.getParameter("cphone"));
					weixinpo.setWifltouserphone(cphone);
				}
				guitarManagementMgr.insertSalesGutiar(sales,salesLogPos, inTransitPo,czklist,djqlist,snpo,snpo2,personInfoPo,ntp,logPo,systemParameterPo,jfType,czkType,djqType,weixinpo);
				msg = "缴费成功!";
			}else{
				print = "0";
				msg = "结款失败!\\n部分销售商品库存不足,请及时补库。";
				autopay = "";
			}	
		}else{
			print = "0";
			msg = "配镜单已被删除,缴费失败!";
		}

		if("1".equals(personInfoPo.getDptsalestype()) && !"".equals(autopay)){
			if (autopay.equals("2")){
				url = "'" + returnUrl + "?moduleID="+moduleID+"'";	
				request.setAttribute("flag","openUpdate3");
			}else if (autopay.equals("3")){
				url = "'initShopSalesMain.action?moduleID="+moduleID+"&print="+print+"&pssesborderstype="+orderType
				+"&psalseID="+request.getParameter("salseID")+"&pcheckoutFlag="+request.getParameter("checkoutFlag")+"'";
				
				request.setAttribute("flag", GlobalConstants.MOVE);
			}else{
				url = "'initSalesAll.action?moduleID="+moduleID+"&print="+print+"&pssesborderstype="+orderType
				+"&psalseID="+request.getParameter("salseID")+"&pcheckoutFlag="+request.getParameter("checkoutFlag")+"'";
				
				request.setAttribute("flag", GlobalConstants.MOVE);
			}
			
			this.clearMessages();
			this.addActionMessage(getText(msg));
			request.setAttribute("url", url);
		}else{
			url = "'initGuitarManagement.action?smecimemberid="
				+ request.getParameter("smecimemberid") + "&print="+print+"&ssesborderstype="+orderType
				+"&salseID="+request.getParameter("salseID")+"&checkoutFlag="+request.getParameter("checkoutFlag")+"&moduleID=" + moduleID + "'";
			
			this.clearMessages();
			this.addActionMessage(getText(msg));
			request.setAttribute("url", url);
			request.setAttribute("flag","openUpdate3");
		}

		return SUCCESS;
	}

	/**
	 * 删除初始化页面
	 * 
	 * @return
	 */
	public String initGuitarManagementDelete() {
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
		
		request.setAttribute("salesid",Utility.getName(request.getParameter("salesid")));

		return SUCCESS;

	}

	/**
	 * 删除销售单
	 * 
	 */
	public String deleteGuitarManagement() {
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
		
		String salesid = Utility.getName(request.getParameter("hid"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID);
		logPo.setsLogOpID("2");
		logPo.setsLogContent("配镜单："+ salesid +" 删除!");		
		
		SalesBasicPo spo = new SalesBasicPo();
		spo.setSsesbsalesid(salesid);
        salesBasicPos = guitarManagementMgr.getSalesBasics(spo);
        
        HisParamPo  po = new HisParamPo();
        po.setBillid(salesid);
        
        
        String msg = "";
        if (salesBasicPos.size() > 0){
        	guitarManagementMgr.deleteGuitarManagement(salesid,logPo);
        	hisParamMgr.deleteHisParam(po);
        	
        	msg = "struts.messages.delete.sucess";
        }else{
        	msg = "此配镜单已结款,不能删除!";
        }		
		
		this.clearMessages();
		this.addActionMessage(getText(msg));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	/**
	 * 结款弹窗
	 * @return
	 */
	public String selGuitarManagementOpen() {
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

		// 得到当前登录人的部门 根据部门取出仓位
		String departmentId = personInfoPo.getDepartmentID();
		String memberId = Utility.getName(request.getParameter("memberId"));
		String hid = Utility.getName(request.getParameter("hid"));
		String ssesborderstype = Utility.getName(request.getParameter("ssesborderstype"));
		String autopay = Utility.getName(request.getParameter("autopay"));
		String returnUrl = Utility.getName(request.getParameter("returnUrl"));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setSmecimemberid(memberId);
		customerInfoPo.setFmmsalesid(hid);

		request.setAttribute("autopay", autopay);
		request.setAttribute("returnUrl", returnUrl);
		request.setAttribute("moduleID", moduleID);
		request.setAttribute("smecimemberid", memberId);
		request.setAttribute("hid", hid);
		request.setAttribute("ssesborderstype",ssesborderstype);

		if (!Utility.getName(systemParameterPo.getFspminintegral()).equals("0") && !Utility.getName(systemParameterPo.getFspminintegral()).equals("")){
			String allsalesvalues = customerInfoMgr.getALLsalesvalues(hid).getSmeciconsumptionprice();
			request.setAttribute("allsalesvalues",allsalesvalues);
		}else{
			request.setAttribute("allsalesvalues","0");
		}
		
		if (StringUtils.isNotEmpty(hid)) {
			// 按配镜单号查询顾客信息
			customerInfoPo = guitarManagementMgr.getCustmorInfoNoFinished(customerInfoPo);
			request.setAttribute("hid", Utility.getName(request.getParameter("hid")));

		} else if (StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			// 查询顾客信息
			customerInfoPo = customerInfoMgr.getCustomerInfoNoFinished(customerInfoPo);
		}

		if (StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {
			
			SalesBasicPo tbpo = new SalesBasicPo();
			tbpo.setSsesbshopcode(departmentId);
			tbpo.setSsesbsalesid(hid);			
			tbpo.setSsesbcustomerid(customerInfoPo.getSmecicustomerid());
			
			salesBasicPo = guitarManagementMgr.getSalesBasicsNoFinished(tbpo);			
			
			if("2".equals(systemParameterPo.getFspupdatecredittype())){
				
				SalesDetailPo salesDetailPo = new SalesDetailPo();
				salesDetailPo.setSsesdsalesid(hid);
				
				salesDetailPos = inTransitDetailsMgr.getGoodsInfoNoFinished(salesDetailPo);
			}
		}
		
		List<BankPo> bankList = brankCardMgr.getNonCashBankList();
		bankPos = new ArrayList<BankPo>();
		otherbankPos = new ArrayList<BankPo>();
		
		for (int i = 0; i < bankList.size(); i++){
			if (bankList.get(i) != null){
				if (Utility.getName(bankList.get(i).getBbtype()).equals("2")){
					bankPos.add(bankList.get(i));
				}else{
					otherbankPos.add(bankList.get(i));
				}	
			}
		}
		
		return SUCCESS;
	}
	
	/**
	 * 储值卡弹窗
	 * @return
	 */
	public String initCzkOpen() {
		//得到当前登录人的部门 根据部门取出仓位
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		String salseValue = Utility.getName(request.getParameter("salseValue"));
		String indexid = Utility.getName(request.getParameter("indexid"));
		String returntype=Utility.getName(request.getParameter("returntype"));
		request.setAttribute("moduleID", moduleID);
		request.setAttribute("salseValue", salseValue);
		request.setAttribute("indexid", indexid);
		request.setAttribute("returntype", returntype);
		return SUCCESS;
	}
	
	
	
	/**
	 * 储值卡查询
	 * @return
	 */
	public String selCzkPo() {
		//得到当前登录人的部门 根据部门取出仓位
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String departmentId = personInfoPo.getDepartmentID();
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		String indexid = Utility.getName(request.getParameter("indexid"));
		String returntype=Utility.getName(request.getParameter("returntype"));
		request.setAttribute("moduleID", moduleID);
		request.setAttribute("indexid", indexid);
		request.setAttribute("returntype", returntype);
		String czkcardid = Utility.getName(request.getParameter("czkcardid"));
		request.setAttribute("czkid", czkcardid);
		
		String salseValue = Utility.getName(request.getParameter("salseValue"));
		request.setAttribute("salseValue", salseValue);
		
		ChuzhikaPo po = new ChuzhikaPo();
		po.setCstczkcardid(czkcardid);
		po.setCstshowandhie("0");
		chuzhikaPo = chuzhikaMgr.selectChuzhika(po);
		return SUCCESS;
	}
	/**
	 * 储值卡弹窗
	 * @return
	 */
	public String initCzkOpen2() {
		//得到当前登录人的部门 根据部门取出仓位
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		String salseValue = Utility.getName(request.getParameter("salseValue"));
		String indexid = Utility.getName(request.getParameter("indexid"));
		String returntype=Utility.getName(request.getParameter("returntype"));
		request.setAttribute("moduleID", moduleID);
		request.setAttribute("salseValue", salseValue);
		request.setAttribute("indexid", indexid);
		request.setAttribute("returntype", returntype);
		return SUCCESS;
	}
	
	
	
	/**
	 * 储值卡查询
	 * @return
	 */
	public String selCzkPo2() {
		//得到当前登录人的部门 根据部门取出仓位
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String departmentId = personInfoPo.getDepartmentID();
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		String indexid = Utility.getName(request.getParameter("indexid"));
		String returntype=Utility.getName(request.getParameter("returntype"));
		request.setAttribute("moduleID", moduleID);
		request.setAttribute("indexid", indexid);
		request.setAttribute("returntype", returntype);
		String cstczkcardid = Utility.getName(request.getParameter("cstczkcardid"));
		request.setAttribute("cstczkcardid", cstczkcardid);
		
		String salseValue = Utility.getName(request.getParameter("salseValue"));
		request.setAttribute("salseValue", salseValue);
		
		String salesid = Utility.getName(request.getParameter("salesid"));
		request.setAttribute("salesid", salesid);
		
		ChuzhikaPo po = new ChuzhikaPo();
		po.setCstczkcardid(cstczkcardid);
		po.setCstshowandhie("0");
		po.setSalesid(salesid);
//		chuzhikaPo = chuzhikaMgr.selectChuzhika2(po);
		chuzhikaPo = chuzhikaMgr.selectChuzhika(po);
		return SUCCESS;
	}
	/**
	 * 代金券弹窗
	 * @return
	 */
	public String initDjqOpen() {
		//得到当前登录人的部门 根据部门取出仓位
		String moduleID = Utility.getName(request.getParameter("moduleID"));

		String indexid = Utility.getName(request.getParameter("indexid"));

		request.setAttribute("moduleID", moduleID);

		request.setAttribute("indexid", indexid);

		return SUCCESS;
	}
	
	
	
	/**
	 * 代金券查询
	 * @return
	 */
	public String selDjqPo() {
		//得到当前登录人的部门 根据部门取出仓位
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String departmentId = personInfoPo.getDepartmentID();
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		String indexid = Utility.getName(request.getParameter("indexid"));
		
		String orderType = Utility.getName(request.getParameter("orderType"));
		
		String salesValue = Utility.getName(request.getParameter("salesValue"));

		String cctype="";
		if(orderType.equals("1")||orderType.equals("2")){
			cctype="1";
		}else if(orderType.equals("3")||orderType.equals("4")){
			cctype="2";
		}else if(orderType.equals("5")){
			cctype="3";
		}else if(orderType.equals("8")){
			cctype="5";
		}else if(orderType.equals("7")){
			cctype="4";
		}else{
			cctype=orderType;
		}

		request.setAttribute("moduleID", moduleID);
		request.setAttribute("indexid", indexid);

		String djqid = Utility.getName(request.getParameter("djqid"));
		request.setAttribute("djqid", djqid);

		
        CashCouponPo couponPo=new CashCouponPo();
        couponPo.setBcccard(djqid);
        
        if("".equals(salesValue)){
        	salesValue="0.00";
        }
        cashCouponPo=cashCouponMgr.getCashCouponPo(couponPo); 
        if(cashCouponPo.getBcccard()!=null){
          if(!cashCouponPo.getBcctype().contains(cctype)){
        	cashCouponPo=new CashCouponPo();
			this.addActionMessage(getText("此代金券的消费类型不适用!"));
			return SUCCESS;
          }else if(Float.valueOf(cashCouponPo.getBccexpense())>=Float.valueOf(salesValue)){
          	cashCouponPo=new CashCouponPo();
			this.addActionMessage(getText("此代金券未达到使用限制的金额!"));
			return SUCCESS;
            }
        }else{
        	this.addActionMessage(getText("无此代金券或代金券已过期!"));
        }
		return SUCCESS;
	}
	/**
	 * 代金券弹窗
	 * @return
	 */
	public String initDjqOpen2() {
		//得到当前登录人的部门 根据部门取出仓位
		String moduleID = Utility.getName(request.getParameter("moduleID"));

		String indexid = Utility.getName(request.getParameter("indexid"));

		request.setAttribute("moduleID", moduleID);

		request.setAttribute("indexid", indexid);

		return SUCCESS;
	}
	
	
	
	/**
	 * 代金券查询
	 * @return
	 */
	public String selDjqPo2() {
		//得到当前登录人的部门 根据部门取出仓位
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String departmentId = personInfoPo.getDepartmentID();
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		String indexid = Utility.getName(request.getParameter("indexid"));

		request.setAttribute("moduleID", moduleID);
		request.setAttribute("indexid", indexid);

		String djqid = Utility.getName(request.getParameter("djqid"));
		request.setAttribute("djqid", djqid);

		
        CashCouponPo couponPo=new CashCouponPo();
        couponPo.setBcccard(djqid);
        
        cashCouponPo=cashCouponMgr.getCashCouponPo2(couponPo);                  
        
		return SUCCESS;
	}
	/**
	 * 代金券弹窗
	 * @return
	 */
	public String initDjqOpen3() {
		//得到当前登录人的部门 根据部门取出仓位
		String moduleID = Utility.getName(request.getParameter("moduleID"));

		String indexid = Utility.getName(request.getParameter("indexid"));
		
		String customerid = Utility.getName(request.getParameter("customerid"));
		
        List<CashCouponPo> cashCouponList=cashCouponMgr.getCashCouponList2(customerid); 

		request.setAttribute("moduleID", moduleID);
		request.setAttribute("indexid", indexid);
		request.setAttribute("customerid", customerid);
		request.setAttribute("cashCouponList", cashCouponList);
		

		return SUCCESS;
	}
	
	
	
	/**
	 * 代金券查询
	 * @return
	 */
	public String selDjqPo3() {
		//得到当前登录人的部门 根据部门取出仓位
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String departmentId = personInfoPo.getDepartmentID();
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		String indexid = Utility.getName(request.getParameter("indexid"));
		String customerid = Utility.getName(request.getParameter("customerid"));

		request.setAttribute("moduleID", moduleID);
		request.setAttribute("indexid", indexid);
		request.setAttribute("customerid", customerid);

		String djqid = Utility.getName(request.getParameter("djqid"));
		request.setAttribute("djqid", djqid);
		
        List<CashCouponPo> cashCouponList=cashCouponMgr.getCashCouponList2(customerid); 
		request.setAttribute("cashCouponList", cashCouponList);
		
        CashCouponPo couponPo=new CashCouponPo();
        couponPo.setBcccard(djqid);
        
        cashCouponPo=cashCouponMgr.getCashCouponPo2(couponPo);  
                
        
		return SUCCESS;
	}
	/**
	 * 代金券弹窗
	 * @return
	 */
	public String initDjqOpen4() {
		//得到当前登录人的部门 根据部门取出仓位
		String moduleID = Utility.getName(request.getParameter("moduleID"));

		String indexid = Utility.getName(request.getParameter("indexid"));
		
		String customerid = Utility.getName(request.getParameter("customerid"));
		
        List<CashCouponPo> cashCouponList=cashCouponMgr.getCashCouponList3(customerid); 

		request.setAttribute("moduleID", moduleID);
		request.setAttribute("indexid", indexid);
		request.setAttribute("customerid", customerid);
		request.setAttribute("cashCouponList", cashCouponList);
		

		return SUCCESS;
	}
	
	
	
	/**
	 * 代金券查询
	 * @return
	 */
	public String selDjqPo4() {
		//得到当前登录人的部门 根据部门取出仓位
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String departmentId = personInfoPo.getDepartmentID();
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		String indexid = Utility.getName(request.getParameter("indexid"));
		String customerid = Utility.getName(request.getParameter("customerid"));

		request.setAttribute("moduleID", moduleID);
		request.setAttribute("indexid", indexid);
		request.setAttribute("customerid", customerid);

		String djqid = Utility.getName(request.getParameter("djqid"));
		request.setAttribute("djqid", djqid);
		
        List<CashCouponPo> cashCouponList=cashCouponMgr.getCashCouponList3(customerid); 
		request.setAttribute("cashCouponList", cashCouponList);
		
        CashCouponPo couponPo=new CashCouponPo();
        couponPo.setBcccard(djqid);
        
        cashCouponPo=cashCouponMgr.getCashCouponPo2(couponPo);  
                
        
		return SUCCESS;
	}
	/**
	 * 代金券弹窗
	 * @return
	 */
	public String initDjqOpen5() {
		//得到当前登录人的部门 根据部门取出仓位
		String moduleID = Utility.getName(request.getParameter("moduleID"));

		String indexid = Utility.getName(request.getParameter("indexid"));

		request.setAttribute("moduleID", moduleID);

		request.setAttribute("indexid", indexid);

		return SUCCESS;

	}
	
	
	
	/**
	 * 代金券查询
	 * @return
	 */
	public String selDjqPo5() {
		//得到当前登录人的部门 根据部门取出仓位
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String departmentId = personInfoPo.getDepartmentID();
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		String indexid = Utility.getName(request.getParameter("indexid"));
		
		String orderType = Utility.getName(request.getParameter("orderType"));
		
		String salesValue = Utility.getName(request.getParameter("salesValue"));

		String cctype="";
		if(orderType.equals("1")||orderType.equals("2")){
			cctype="1";
		}else if(orderType.equals("3")||orderType.equals("4")){
			cctype="2";
		}else if(orderType.equals("5")){
			cctype="3";
		}else if(orderType.equals("8")){
			cctype="5";
		}else if(orderType.equals("7")){
			cctype="4";
		}else{
			cctype=orderType;
		}

		request.setAttribute("moduleID", moduleID);
		request.setAttribute("indexid", indexid);

		String djqid = Utility.getName(request.getParameter("djqid"));
		request.setAttribute("djqid", djqid);
		
		String salesid = Utility.getName(request.getParameter("salesid"));
		request.setAttribute("salesid", salesid);

		
        CashCouponPo couponPo=new CashCouponPo();
        couponPo.setBcccard(djqid);
        couponPo.setSalesid(salesid);
        
        if("".equals(salesValue)){
        	salesValue="0.00";
        }
        cashCouponPo=cashCouponMgr.getCashCouponPogg(couponPo); 
        if(cashCouponPo.getBcccard()!=null){
          if(!cashCouponPo.getBcctype().contains(cctype)){
        	cashCouponPo=new CashCouponPo();
			this.addActionMessage(getText("此代金券的消费类型不适用!"));
			return SUCCESS;
          }else if(Float.valueOf(cashCouponPo.getBccexpense())>=Float.valueOf(salesValue)){
          	cashCouponPo=new CashCouponPo();
			this.addActionMessage(getText("此代金券未达到使用限制的金额!"));
			return SUCCESS;
            }
        }else{
        	this.addActionMessage(getText("无此代金券或代金券已过期!"));
        }
		return SUCCESS; 

	}
	
	public String initUpdateSalesValueOpen() {
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
		
		String salesid = Utility.getName(request.getParameter("salesid"));
		
		SalesBasicPo sbpo = new SalesBasicPo();
		sbpo.setSsesbshopcode("");
		sbpo.setSsesbsalesid(salesid);
		sbpo.setSsesbcustomerid("");
		
		salesBasicPo = guitarManagementMgr.getSalesBasics(sbpo).get(0);
		
		return SUCCESS;
	}
	
	public String updateSalesValue() {
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
		
		SalesBasicPo sbpo = new SalesBasicPo();
		
		String ssesbsalesid = Utility.getName(request.getParameter("ssesbsalesid"));
		String ssesbsalesvalue = Utility.getName(request.getParameter("ssesbsalesvalue"));
		String ssesbpsalsvalue = Utility.getName(request.getParameter("ssesbpsalsvalue"));
		String yssesbpsalsvalue = Utility.getName(request.getParameter("yssesbpsalsvalue"));
		
		Float ssesbarrearsvalue = Float.parseFloat(ssesbsalesvalue) - Float.parseFloat(ssesbpsalsvalue);
		
		sbpo.setSsesbsalesid(ssesbsalesid);
		sbpo.setSsesbpsalsvalue(ssesbpsalsvalue);
		sbpo.setSsesbarrearsvalue(ssesbarrearsvalue+"");
		if(Float.parseFloat(ssesbsalesvalue) == Float.parseFloat(ssesbpsalsvalue)){
			sbpo.setSsesbcheckoutflag("0");
		}else{
			sbpo.setSsesbcheckoutflag("1");
		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID);
		logPo.setsLogOpID("2");
		logPo.setsLogContent("配镜单："+ ssesbsalesid +" 实收金额被修改。原实收金额为:"+yssesbpsalsvalue+";现实收金额为："+ssesbpsalsvalue+"。");		
		
		guitarManagementMgr.updateSalesValue(sbpo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public String initUpdatePayType() {
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
		
		// 得到当前登录人的部门 根据部门取出仓位
//		SalesBasicPo salesBasicPotemp = new SalesBasicPo();
//		salesBasicPotemp.setSsesbposid(personInfoPo.getId());
//		salesBasicPotemp.setSsesbshopcode(personInfoPo.getDepartmentID());
//		
//		salesBasicPo = arrearsMgr.getArrearsValues(salesBasicPotemp); 
//		request.setAttribute("moduleID", moduleID);
		
		return SUCCESS;
	}

	public String selUpdatePayType() {
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

		// 得到当前登录人的部门 根据部门取出仓位
		String departmentId = personInfoPo.getDepartmentID();
		
		WarehouseConfigurationPo wpo = new WarehouseConfigurationPo();
		wpo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = warehouseConfigurationMgr.getWarehouseConfiguration(wpo);
		
		request.setAttribute("bwcflag", Utility.getName(warehouseConfigurationPo.getBwcdeptid()));
		
//		SalesBasicPo salesBasicPotemp = new SalesBasicPo();
//		salesBasicPotemp.setSsesbposid(personInfoPo.getId());
//		salesBasicPotemp.setSsesbshopcode(personInfoPo.getDepartmentID());
//		
//		salesBasicPo = arrearsMgr.getArrearsValues(salesBasicPotemp); 
		
		String memberId = Utility.getName(request.getParameter("smecimemberid"));
		String salesid = Utility.getName(request.getParameter("fmmsalesid"));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setSmecimemberid(memberId);
		customerInfoPo.setFmmsalesid(salesid);
		customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
		
		request.setAttribute("smecimemberid", memberId);
		request.setAttribute("fmmsalesid", salesid);

		if (StringUtils.isNotEmpty(salesid)) {
			// 按配镜单号查询顾客信息
			customerInfoPo = guitarManagementMgr.getCustmorInfo(customerInfoPo);
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday()
						.substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR)
						- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmage(Integer.toString(age));
			}

			request.setAttribute("salesID", Utility.getName(request
					.getParameter("salesID")));

		} else if (StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			// 查询顾客信息
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
			// 年龄
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday()
						.substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR)
						- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmage(Integer.toString(age));
			}
		}

		SalesBasicPo salesBasicPo = new SalesBasicPo();
		salesBasicPo.setSsesbshopcode(departmentId);
		salesBasicPo.setSsesbsalesid(salesid);
		salesBasicPo.setSsesbupdateguitartype(systemParameterPo.getFspupdateguitartype());

		if (StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {
			salesBasicPo
					.setSsesbcustomerid(customerInfoPo.getSmecicustomerid());
			salesBasicPos = guitarManagementMgr.getUpdatePayTypeSalesBasics(salesBasicPo);
		}
		
		return SUCCESS;
	}
	
	/**
	 * 结款弹窗
	 * @return
	 */
	public String initInsertUpdatePayType() {
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

		// 得到当前登录人的部门 根据部门取出仓位
		String departmentId = personInfoPo.getDepartmentID();
		String memberId = Utility.getName(request.getParameter("memberId"));
		String hid = Utility.getName(request.getParameter("hid"));
		String ssesborderstype = Utility.getName(request.getParameter("ssesborderstype"));
		String autopay = Utility.getName(request.getParameter("autopay"));
		String sseslpaymenttype = Utility.getName(request.getParameter("sseslpaymenttype"));
		
		request.setAttribute("autopay", autopay);
		request.setAttribute("sseslpaymenttype", sseslpaymenttype);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setSmecimemberid(memberId);
		customerInfoPo.setFmmsalesid(hid);

		request.setAttribute("moduleID", moduleID);
		request.setAttribute("smecimemberid", memberId);
		request.setAttribute("hid", hid);
		request.setAttribute("ssesborderstype",ssesborderstype);
		
		if (StringUtils.isNotEmpty(hid)) {
			// 按配镜单号查询顾客信息
			customerInfoPo = guitarManagementMgr.getCustmorInfo(customerInfoPo);
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday()
						.substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR)
						- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmage(Integer.toString(age));
			}

			request.setAttribute("hid", Utility.getName(request
					.getParameter("hid")));

		} else if (StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			// 查询顾客信息
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
			// 年龄
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday()
						.substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR)
						- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmage(Integer.toString(age));
			}
		}

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		SalesBasicPo salesBasicPo = new SalesBasicPo();
		salesBasicPo.setSsesbshopcode(departmentId);
		salesBasicPo.setSsesbsalesid(hid);
		salesBasicPo.setSsesbupdateguitartype(systemParameterPo.getFspupdateguitartype());
		salesBasicPo.setSseslpaymenttype(sseslpaymenttype);

		if (StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {
			salesBasicPo.setSsesbcustomerid(customerInfoPo.getSmecicustomerid());
			salesBasicPos = guitarManagementMgr.getUpdatePayTypeSalesBasics(salesBasicPo);
		}
		
		bankPos = brankCardMgr.getOnlyBankList();
		
		otherbankPos=brankCardMgr.getOtherBankList();

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		NoteTypePo npo=unitMgr.getNoteTypePo("9");
		NoteTemplatePo po2 = new NoteTemplatePo();
		po2.setBntname("9");
		po2.setBntautosend("1");
		NoteTemplatePo noteTemplatePo = unitMgr.getNoteTemplateType(po2);
		
		request.setAttribute("first", systemParameterPo.getFspshortmessage());
		request.setAttribute("second", npo.getBntautosend());
		request.setAttribute("content", noteTemplatePo.getBntcontent());	
		
		return SUCCESS;
	}

	public String insertUpdatePayType() {
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
		
		String orderType = request.getParameter("ssesborderstype");
		String checkoutFlag = Utility.getName(request.getParameter("checkoutFlag"));
		String smecimemberid = Utility.getName(request.getParameter("smecimemberid"));
		String sseslpaymenttype = Utility.getName(request.getParameter("sseslpaymenttype"));
		
		SalesBasicPo sales = new SalesBasicPo();
		sales.setSsesbsalesid(request.getParameter("salseID"));
		sales.setSsesborderstype(orderType);
		sales.setSsesbcheckoutflag(checkoutFlag);
		sales.setSsesbposid(personInfoPo.getId());
		sales.setSseslpaymenttype(sseslpaymenttype);
		sales.setSsesbshopcode(personInfoPo.getDepartmentID());
		
		String[] xjvs = request.getParameterValues("xjv");
		String[] jfvs = request.getParameterValues("jfv");
		String[] yhkvs = request.getParameterValues("yhkv");
		String[] yhkts = request.getParameterValues("yhkt");
		String[] czkvs = request.getParameterValues("czkv");
		String[] czkids = request.getParameterValues("czkid");
		String[] czkyes = request.getParameterValues("czkye");
		String[] qtvs = request.getParameterValues("qtv");
		String[] qtts = request.getParameterValues("qtt");
		String[] djqvs = request.getParameterValues("djqv");
		String[] djqids = request.getParameterValues("djqid");
		
		List<SalesLogPo> salesLogPos = new ArrayList<SalesLogPo>();
		
		BigDecimal bigd = new BigDecimal("0.00");
		if(xjvs == null){
			xjvs = new String[0];
		}
		for(int i=0; i<xjvs.length; i++){
			BigDecimal bigd2 = new BigDecimal(xjvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(request.getParameter("salseID"));
			if("1".equals(Utility.getName(checkoutFlag))){
				salesLogPo.setSseslpaymenttype("2");
			}else{
				salesLogPo.setSseslpaymenttype("1");
			}
			salesLogPo.setSseslconsumptionid("1");
			salesLogPo.setSseslsourceid("");
			salesLogPo.setSseslprice(xjvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			
			salesLogPos.add(salesLogPo);
			
			bigd = bigd.add(bigd2);
		}		
		sales.setSsesbpaycash(bigd.toString());
		
		BigDecimal jftotal = new BigDecimal("0");
		if(jfvs == null){
			jfvs = new String[0];
		}
		BigDecimal jfdktotal = null;
		if (!"".equals(Utility.getName(systemParameterPo.getFspexchangeintegral()).trim())){
			jfdktotal = new BigDecimal(Utility.getName(systemParameterPo.getFspexchangeintegral()));
		}else{
			jfdktotal = new BigDecimal("0.00");
		}
		for(int i=0; i<jfvs.length; i++){
			BigDecimal bigd2 = new BigDecimal(jfvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(request.getParameter("salseID"));
			if("1".equals(Utility.getName(checkoutFlag))){
				salesLogPo.setSseslpaymenttype("2");
			}else{
				salesLogPo.setSseslpaymenttype("1");
			}
			salesLogPo.setSseslconsumptionid("2");
			salesLogPo.setSseslsourceid("");
			salesLogPo.setSseslprice(jfvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslintegralprice(jfdktotal.multiply(bigd2).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			
			salesLogPos.add(salesLogPo);
			
			jftotal = jftotal.add(bigd2);
		}
		sales.setNowintegral(jftotal.toString());
		sales.setSsesbintegralprice(jfdktotal.multiply(jftotal).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		
		BigDecimal yhktotal = new BigDecimal("0.00");
		//银行卡
		if(yhkvs == null){
			yhkvs = new String[0];
		}		
		for(int i=0; i<yhkvs.length; i++){
			BigDecimal bigd2 = new BigDecimal(yhkvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(request.getParameter("salseID"));
			if("1".equals(Utility.getName(checkoutFlag))){
				salesLogPo.setSseslpaymenttype("2");
			}else{
				salesLogPo.setSseslpaymenttype("1");
			}
			salesLogPo.setSseslconsumptionid("3");
			salesLogPo.setSseslsourceid(yhkts[i]);
			salesLogPo.setSseslprice(yhkvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			
			salesLogPos.add(salesLogPo);
			yhktotal = yhktotal.add(bigd2);
		}
		//其他
		if(qtvs == null){
			qtvs = new String[0];
		}		
		for(int i=0; i<qtvs.length; i++){
			BigDecimal bigd2 = new BigDecimal(qtvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(request.getParameter("salseID"));
			if("1".equals(Utility.getName(checkoutFlag))){
				salesLogPo.setSseslpaymenttype("2");
			}else{
				salesLogPo.setSseslpaymenttype("1");
			}
			salesLogPo.setSseslconsumptionid("6");
			salesLogPo.setSseslsourceid(qtts[i]);
			salesLogPo.setSseslprice(qtvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			
			salesLogPos.add(salesLogPo);
			yhktotal = yhktotal.add(bigd2);
		}		
	    //代金券
		if(djqvs == null){
			djqvs = new String[0];
		}
		for(int i=0; i<djqvs.length; i++){
			BigDecimal bigd2 = new BigDecimal(djqvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(request.getParameter("salseID"));
			if("1".equals(Utility.getName(checkoutFlag))){
				salesLogPo.setSseslpaymenttype("2");
			}else{
				salesLogPo.setSseslpaymenttype("1");
			}
			salesLogPo.setSseslconsumptionid("7");
			salesLogPo.setSseslsourceid(djqids[i]);
			salesLogPo.setSseslprice(djqvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			
			salesLogPos.add(salesLogPo);
			yhktotal = yhktotal.add(bigd2);
		}
		sales.setSsesbbankcard(yhktotal.toString());
		
		BigDecimal czktotal = new BigDecimal("0.00");
		if(czkvs == null){
			czkvs = new String[0];
		}
		for(int i=0; i<czkvs.length; i++){
			BigDecimal bigd2 = new BigDecimal(czkvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(request.getParameter("salseID"));
			if("1".equals(Utility.getName(checkoutFlag))){
				salesLogPo.setSseslpaymenttype("2");
			}else{
				salesLogPo.setSseslpaymenttype("1");
			}
			salesLogPo.setSseslconsumptionid("4");
			salesLogPo.setSseslsourceid(czkids[i]);
			salesLogPo.setSseslprice(czkvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			
			salesLogPos.add(salesLogPo);
			czktotal = czktotal.add(bigd2);
		}
		sales.setSsesbstoredcard(czktotal.toString());
		
		//现金合计 = 现金 - 找零
		BigDecimal zltotal = new BigDecimal(Utility.getName(request.getParameter("zl")));
		bigd = bigd.subtract(zltotal);
		bigd = bigd.setScale(2, BigDecimal.ROUND_HALF_UP);
		sales.setSsesbpaycash(bigd.toString());
			
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		
		List<ChuzhikaPo> czklist = new ArrayList<ChuzhikaPo>();
		for(int i=0; i<czkvs.length; i++){
			if(Float.parseFloat(czkvs[i]) > 0){
				ChuzhikaPo po = new ChuzhikaPo();
				po.setCstczkchongzhijine("-"+czkvs[i]);
				po.setCstczkjiankaren(personInfoPo.getId());
				po.setCstczkjine(czkyes[i]);
				po.setCstczkid(czkids[i]);
				po.setCstczkllinkbillid(request.getParameter("salseID"));
				po.setCstczklyue(czkyes[i]);
				po.setCstczksalesamount(Utility.getName(czkvs[i]).equals("") ? "0.00" : Utility.getName(czkvs[i]));
				po.setCstczksalesstore(personInfoPo.getDepartmentID());
				po.setCstczksalesdate("1");
				
				czklist.add(po);
			}
		}
		CustomerInfoPo customerInfoPo=new CustomerInfoPo();
		customerInfoPo.setSmecimemberid(smecimemberid);
		CustomerInfoPo customerPo=customerInfoMgr.getCustomerInfo(customerInfoPo);
		//代金券
		List<CashCouponPo> djqlist = new ArrayList<CashCouponPo>();
		for(int i=0; i<djqvs.length; i++){
			if(Float.parseFloat(djqvs[i]) > 0){
				CashCouponPo couponPo=new CashCouponPo();

				couponPo.setBcccard(djqids[i]);
				couponPo.setBccuseperson(personInfoPo.getId());
				couponPo.setBccuseflag("1");
				couponPo.setBccuseamount(djqvs[i]);
				couponPo.setBcccustomer(customerPo.getSmecicustomerid());
				
				djqlist.add(couponPo);
			}
		}
		sales.setSsesbsalesvalue(Utility.getName(request.getParameter("salseValue")));		
		
		InTransitPo inTransitPo = new InTransitPo();
		inTransitPo.setSseitsalesid(sales.getSsesbsalesid());
		inTransitPo.setSseitdepartment(personInfoPo.getDepartmentID());
		inTransitPo.setSseitcreateperson(personInfoPo.getId());
		
		logPo.setsLogOpID("1");    // 1 新增
		logPo.setsLogContent("配镜单："+request.getParameter("salseID")+" 变更结款方式!");
		
		String isSend = Utility.getName(request.getParameter("isSend"));
		String content = Utility.getName(request.getParameter("content"));
		SmsRecordPo smsRecordPo=new SmsRecordPo();
		smsRecordPo.setFsrsendcontext(content);
		
		String url ="";
		String print = "1";   // 控制是否打印配镜单和订金单
		String msg = "";      //提示信息
		String autopay = Utility.getName(request.getParameter("autopay"));
		
		guitarManagementMgr.updatePayType(sales,salesLogPos, inTransitPo,czklist,djqlist,smsRecordPo,isSend,personInfoPo,smecimemberid,logPo,systemParameterPo );
		msg = "缴费成功!";
		
		DepartmentsPo dpo = new DepartmentsPo();
		dpo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		DepartmentsPo departmentsPo = departmentsMgr.getDepartment(dpo);		

		url = "'initUpdatePayType.action?smecimemberid="
			+ request.getParameter("smecimemberid") + "&print="+print+"&ssesborderstype="+orderType
			+"&salseID="+request.getParameter("salseID")+"&checkoutFlag="+request.getParameter("checkoutFlag")+"&moduleID=" + moduleID + "'";
		
		this.clearMessages();
		this.addActionMessage(getText(msg));
		request.setAttribute("url", url);
		request.setAttribute("flag","openUpdate3");

		return SUCCESS;
	}
	
	/**
	 * 初始化手工传递配镜单
	 */
	public String initSalesGutiarFlysheetInsert() {
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

		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		
		return SUCCESS;
	}
	
	/**
	 * 手工传递配镜单
	 */
	public String insertSalesGutiarFlysheet() {
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
		
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 新增
		logPo.setsLogContent("传递配镜单!");
		
		String bgnDate = Utility.getName(request.getParameter("startTime"));
		String endDate = Utility.getName(request.getParameter("endTime"));
		
		SalesBasicPo spo = new SalesBasicPo();
		spo.setSsesbsalesdatestarttime(bgnDate);
		spo.setSsesbsalesdateendtime(endDate);
		
		ExternalAccountParameterPo epo = new ExternalAccountParameterPo();
		epo = externalAccountParameterMgr.getExternalAccountParameterPo(epo);
		
		String msg = "传递成功!";
		if (Utility.getName(epo.getFeaaccessname()).equals("") || Utility.getName(epo.getFeaaccessname()).equals("")){
			msg = "请先配置传递配镜单所需参数!";
		}else{
			try {
				guitarManagementMgr.insertSalesDataAndQuartz_Flysheet(spo,epo,logPo);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				msg = "传递失败!";
			}
		}
	
		this.clearMessages();
		this.addActionMessage(msg);
		request.setAttribute("url", "'initSalesGutiarFlysheetInsert.action?moduleID="+moduleID+"'");
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}
	
	public void getArrearsValuesToo() throws Exception {
		String tid = Utility.getName(request.getParameter("tid"));
		String tdptid = Utility.getName(request.getParameter("tdptid"));
		
		PrintWriter out;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();
		
		if(tid.equals("")){
			out.println("您个人当日配镜收银累计实收金额：0.00 ");
		}else{
			
			SalesBasicPo salesBasicPotemp = new SalesBasicPo();
			salesBasicPotemp.setSsesbposid(tid);
			salesBasicPotemp.setSsesbshopcode(tdptid);
			
			salesBasicPo = arrearsMgr.getArrearsValuesToo(salesBasicPotemp); 

			out.println("您个人当日配镜收银累计实收金额：" + (Utility.getName(salesBasicPo.getSsesbpsalsvalue()).equals("") ? "0.00" : Utility.getName(salesBasicPo.getSsesbpsalsvalue())));
		}
		
		out.close();			
	}
	
	/**
	 * 初始化向HIS系统提交待交费信息
	 */
	public String initSalesNotChargeInfoToHisInsert() {
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
		
		String hid = Utility.getName(request.getParameter("hid"));
		String checkoutflag = Utility.getName(request.getParameter("checkoutflag"));
		
		request.setAttribute("hid",hid);
		request.setAttribute("checkoutflag",checkoutflag);
		
		List<SalesDetailPo> sdpList = hisMgr.getSalesDetailNotSetPayFeeList(hid);
		String errorMsg = "";
		
		if (sdpList.size() > 0){
			for (SalesDetailPo sdpo : sdpList){
				errorMsg = errorMsg + Utility.getName(sdpo.getSsesdsalesitemid()) + "  " + Utility.getName(sdpo.getSsesdsalesitemname()) + "\\n";
			}
		}
		
		if (!errorMsg.equals("")){
			errorMsg = "以下商品未设置收费项目：\\n" + errorMsg;            
		}
		request.setAttribute("errorMsg",errorMsg);

		return SUCCESS;
	}
	
	/**
	 * 向HIS系统提交待交费信息
	 */
	public String insertSalesNotChargeInfoToHis() {
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 新增
		logPo.setsLogContent("配镜单：【" + Utility.getName(salesBasicPo.getSsesbsalesid()) + "】向HIS系统提交待交费信息！");
		logPo.setsLogDepartmentID(personInfoPo.getDepartmentID());
		
		String checkoutflag = "1";
		if ("1".equals(Utility.getName(salesBasicPo.getSsesbcheckoutflag()))){
			checkoutflag = "2";
		}
		
		hisMgr.insertSalesNotChargeInfoToHis(Utility.getName(salesBasicPo.getSsesbsalesid()), "1", checkoutflag, personInfoPo,logPo);  // 1.全款   2.订金    3.补齐   4.退款
	
		this.clearMessages();
		this.addActionMessage(getText("提交成功！"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
		
}
