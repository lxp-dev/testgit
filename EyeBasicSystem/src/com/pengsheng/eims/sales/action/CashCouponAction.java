package com.pengsheng.eims.sales.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.mgr.CashCouponMgr;
import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class CashCouponAction extends BaseAction{
	
	private PersonPermissionMgr personPermissionMgr;
	
	private CashCouponPo cashCouponPo;
	
	private CashCouponMgr cashCouponMgr;	
	
	private SystemParameterMgr systemParameterMgr;
	
	private SystemParameterPo systemParameterPo;
	
	private List<CashCouponPo> cashCouponList;
	
	private String isFirstExec;
	
	
	
	public String getIsFirstExec() {
		return isFirstExec;
	}


	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}


	public List<CashCouponPo> getCashCouponList() {
		return cashCouponList;
	}


	public void setCashCouponList(List<CashCouponPo> cashCouponList) {
		this.cashCouponList = cashCouponList;
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


	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}


	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}


	/**
	 * 查询页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initCashCouponSel() throws Exception {
		
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
			return "selCashCoupon";
		}

		return SUCCESS;
	}
	/**
	 * 查询页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selCashCoupon() throws Exception {
		
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
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		String amount1=Utility.getName(request.getParameter("amount1"));
		String amount2=Utility.getName(request.getParameter("amount2"));
		String useflag=Utility.getName(request.getParameter("useflag"));
		String carddate1=Utility.getName(request.getParameter("carddate1"));
		String carddate2=Utility.getName(request.getParameter("carddate2"));
		String usedate1=Utility.getName(request.getParameter("usedate1"));
		String usedate2=Utility.getName(request.getParameter("usedate2"));
		String cardbegindate=Utility.getName(request.getParameter("cardbegindate"));
		String cardenddate=Utility.getName(request.getParameter("cardenddate"));
		
		String usecustomer=Utility.getName(request.getParameter("usecustomer"));
		
		String card=Utility.getName(request.getParameter("card"));
		String[] type1=request.getParameterValues("cardtype");
		String cardtype="";
		if(type1!=null){
		for(int i=0;i<type1.length;i++){
			if("".equals(cardtype)){
				cardtype=type1[i];
			}else{
				if(!cardtype.contains(type1[i])){
				  cardtype=cardtype+", "+type1[i];
				}
			}			
		  }
		}

		cashCouponPo=new CashCouponPo();
		cashCouponPo.setBccuseamount1(amount1);
		cashCouponPo.setBccuseamount2(amount2);
		cashCouponPo.setBccuseflag(useflag);
		cashCouponPo.setBcccarddate1(carddate1);
		cashCouponPo.setBcccarddate2(carddate2);	
		cashCouponPo.setBccusedate1(usedate1);
		cashCouponPo.setBccusedate2(usedate2);
		cashCouponPo.setBccbegindate(cardbegindate);
		cashCouponPo.setBccenddate(cardenddate);
		cashCouponPo.setBcccard(card);
		cashCouponPo.setBcctype(cardtype);
		cashCouponPo.setBcccustomer(usecustomer);
		
		request.setAttribute("amount1",amount1);
		request.setAttribute("amount2",amount2);
		request.setAttribute("useflag",useflag);
		request.setAttribute("carddate1",carddate1);
		request.setAttribute("carddate2",carddate2);
		request.setAttribute("usedate1",usedate1);
		request.setAttribute("usedate2",usedate2);
		request.setAttribute("cardbegindate",cardbegindate);
		request.setAttribute("cardenddate",cardenddate);
		request.setAttribute("card",card);
		request.setAttribute("cardtype",cardtype);
		request.setAttribute("usecustomer",usecustomer);
		
		int count=cashCouponMgr.getCashCouponCount(cashCouponPo);
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
	    cashCouponList=cashCouponMgr.getCashCouponList(cashCouponPo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			cashCouponList = null;
		}	
		return SUCCESS;
	}
	/**
	 * 新增页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initCashCouponInsert() throws Exception {
		
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
		

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String createDate = currMouthFirstDay.format(calendar.getTime());			
        request.setAttribute("createDate",createDate);

		return SUCCESS;
	}
	
	/**
	 * 新增页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insertCashCoupon() throws Exception {
		
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("1");    		// 表示状态
		logPo.setsLogContent("代金券:" + cashCouponPo.getBcccard() + "新增!");
		
		int count=cashCouponMgr.selectCashCoupon(cashCouponPo);
		
		if(count>0){
			this.clearMessages();
			this.addActionMessage("该卡号已被使用！");

			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return "NoRepeat";
		}else{
			cashCouponPo.setBcccardperson(createPerson);
			cashCouponMgr.insertCashCoupon(cashCouponPo, logPo);
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));

			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}

	}
	/**
	 * 修改页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initCashCouponUpdate() throws Exception {
		
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
		
		String id = Utility.getName(request.getParameter("bid"));
		CashCouponPo couponPo=new CashCouponPo();
		couponPo.setBccid(id);
		cashCouponPo=cashCouponMgr.getCashCoupon(couponPo);
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String createDate = currMouthFirstDay.format(calendar.getTime());			
        request.setAttribute("createDate",createDate);

		return SUCCESS;
	}
	
	/**
	 * 修改页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateCashCoupon() throws Exception {
		
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("3");    		// 表示状态
		logPo.setsLogContent("代金券:" + cashCouponPo.getBcccard() + "充值!");
		
		cashCouponPo.setBcccardperson(createPerson);
		cashCouponMgr.updateCashCoupon(cashCouponPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	/**
	 * 删除页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initCashCouponDelete() throws Exception {
		
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
		String id = Utility.getName(request.getParameter("bid"));
		CashCouponPo couponPo=new CashCouponPo();
		couponPo.setBccid(id);
		cashCouponPo=cashCouponMgr.getCashCouponDelete(couponPo);

		return SUCCESS;
	}
	
	/**
	 * 删除页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteCashCoupon() throws Exception {
		
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
		
		String card = Utility.getName(request.getParameter("card"));
		/** ********************** 权限设置 ***************************** */
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("代金券:" + card + "删除!");
		String id = Utility.getName(request.getParameter("bid"));
		CashCouponPo couponPo=new CashCouponPo();
		couponPo.setBccid(id);
		cashCouponMgr.deleteCashCoupon(couponPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	/**
	 * 初始化批量删除
	 */
	public String initCashCouponDeleteBatch() throws Exception {
		
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
		
		String hid = Utility.getName(request.getParameter("hid"));
		
		request.setAttribute("hid",hid);
		
		return SUCCESS;
	}
	
	/**
	 * 批量删除
	 */
	public String deleteCashCouponBatch() throws Exception {
		
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
				
		String hid = Utility.getName(request.getParameter("hid"));

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("38");    // 表示状态
		logPo.setsLogContent("代金券批量删除！");

		cashCouponMgr.deleteCashCouponBatch(hid, logPo);

		this.clearMessages();
		this.addActionMessage("代金券批量删除成功!");
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 修改页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initCashCouponDetails() throws Exception {
		
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
		
		String id = Utility.getName(request.getParameter("bid"));
		CashCouponPo couponPo=new CashCouponPo();
		couponPo.setBccid(id);
		cashCouponPo=cashCouponMgr.getCashCoupon(couponPo);

		return SUCCESS;
	}	
	/**
	 * 批量新增页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initCashCouponInserts() throws Exception {
		
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
//		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyMMdd");
//		String djq1 = "DJ"+numHeadFormat.format(new Date());
//		
//		Calendar calendar = Calendar.getInstance();
//		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
//		String createDate = currMouthFirstDay.format(calendar.getTime());			
//        request.setAttribute("createDate",createDate);
//
//		request.setAttribute("djq1", djq1);

		return SUCCESS;
	}
	
	/**
	 * 批量新增页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insertsCashCoupon() throws Exception {
		
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
		
		String djq1 = Utility.getName(request.getParameter("djq1"));  //批号
		String djq2_tmp = Utility.getName(request.getParameter("djq2")).trim();		
		String lastNum = "";
		
		BigDecimal djq2 = new BigDecimal(djq2_tmp);
		BigDecimal cardnumber = new BigDecimal(Utility.getName(request.getParameter("cardnumber")).trim());		
		BigDecimal movenumber = new BigDecimal(0);//计数器
		BigDecimal area = new BigDecimal(1);//步长
		cashCouponList = new ArrayList<CashCouponPo>();
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent(" 代金券批号:"+djq1+"新增,共:"+cardnumber.toString()+"张！");
		
		int cardcount=0;
		String errorCard = "";//已经被使用的代金券号
		String cardString = "";//用,号拼装代金券号
		
		for(int i = 0; i < cardnumber.intValue(); i++){
			
			if(cardString.equals("")){
				cardString = (djq1 + addZero(djq2.add(movenumber).toString(),djq2_tmp.length()));
			}else{
				cardString = cardString + "," + (djq1 + addZero(djq2.add(movenumber).toString(),djq2_tmp.length()));
			}
			
			CashCouponPo couponPo=new CashCouponPo();
			couponPo.setBcccard(djq1 + addZero(djq2.add(movenumber).toString(),djq2_tmp.length()));
			lastNum = addZero(djq2.add(movenumber).toString(),djq2_tmp.length());

			couponPo.setBccamount(cashCouponPo.getBccamount());
			couponPo.setBccbegindate(cashCouponPo.getBccbegindate());
			couponPo.setBccenddate(cashCouponPo.getBccenddate());
			couponPo.setBccexpense(cashCouponPo.getBccexpense());
			couponPo.setBcctype(cashCouponPo.getBcctype());
			couponPo.setBccmark(cashCouponPo.getBccmark());
			couponPo.setBcccardperson(createPerson);
			couponPo.setBccwxflag(cashCouponPo.getBccwxflag());
            
            cashCouponList.add(couponPo);
			movenumber = movenumber.add(area);
		}
		
		List<CashCouponPo> IsExistCashCouponList = new ArrayList<CashCouponPo>();
		IsExistCashCouponList = cashCouponMgr.getCashCouponListIsExist(cardString);
		
		Iterator<CashCouponPo> it = IsExistCashCouponList.iterator();
		while(it.hasNext()){
			errorCard = errorCard + it.next().getBcccard() + "\\n";
		}
		
		this.clearMessages();
		if (errorCard.length() == 0){
			cashCouponMgr.insertBatchCashCoupon(cashCouponList,logPo);
			this.addActionMessage(getText("从卡号:" + djq1 + djq2_tmp + " 至 " + djq1 + lastNum + "\\n新增成功!"));
		}else{
			request.setAttribute("djq1", djq1);
			request.setAttribute("djq2", djq2_tmp);
			request.setAttribute("cardnumber", cardnumber);
			this.addActionMessage(getText("由于以下代金券号码已经在系统中使用：\\n"+errorCard+"新增失败！!"));
			return "NoRepeat";
		}
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;

	}
	
	private String addZero(String str,int size){
		
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < (size-str.length()); i++){
			buffer.append("0");
		}
		
		return buffer.toString() + str;
	}
}
