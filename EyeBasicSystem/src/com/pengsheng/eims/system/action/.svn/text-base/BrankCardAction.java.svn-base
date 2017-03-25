package com.pengsheng.eims.system.action;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.BrankCardMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.BankPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.BrankCardPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

/**
 * BrankCardAction 银行卡Action
 * 
 * @author GuanZiGang
 * @version 1.0
 */
public class BrankCardAction extends BaseAction implements ServletRequestAware, SessionAware{

	//注入request对象
	private HttpServletRequest request;
	
	//注入seesion对象
	private Map session;
	
	//注入银行卡Mgr
	private BrankCardMgr brankCardMgr;

	//页面List
	private List list;
	
	//页面Po
	private BrankCardPo brankCardPo; 
	
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private List<BankPo> bankPos;
	private BankPo bankPo;
	
	
	public BankPo getBankPo() {
		return bankPo;
	}
	public void setBankPo(BankPo bankPo) {
		this.bankPo = bankPo;
	}
	public List<BankPo> getBankPos() {
		return bankPos;
	}
	public void setBankPos(List<BankPo> bankPos) {
		this.bankPos = bankPos;
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
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public Map getSession() {
		return session;
	}

	public BrankCardPo getBrankCardPo() {
		return brankCardPo;
	}

	public void setBrankCardPo(BrankCardPo brankCardPo) {
		this.brankCardPo = brankCardPo;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public void setSession(Map session) {
		this.session = session;
	}
	
	public BrankCardMgr getBrankCardMgr() {
		return brankCardMgr;
	}

	public void setBrankCardMgr(BrankCardMgr brankCardMgr) {
		this.brankCardMgr = brankCardMgr;
	}

	/**
	 * 查询页面初始化
	 * 
	 * @return 
	 */
	public String initBrankCardList() {
		
		
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
		
		BrankCardPo po = new BrankCardPo();
		
		//根据查询条件返回相应的结果集数量
		int count = brankCardMgr.getBrankCardCount(po);
		
		//查询结果>0 查询出结果
		if (count > 0) {
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
			//页面显示数量
			int perPage = 0;
			
			//获取页面参数  
			//perPage:页面显示数量
			//如果不为空获取当前参数的值
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				//如果
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request
							.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			
			//
			Pagination page = new Pagination(request, count, perPage);
			
			//根据查询条件返回相应的结果集
			list = brankCardMgr.getBrankCardList(po, page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
			
		} else { //否则查询结果为NULL
			
			list = null;
		
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始新增银行卡页面
	 * 
	 * @return
	 */
	public String initInsertBrankCard(){
		
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
	
	
	/**
	 * 新增银行卡
	 * 
	 * @return
	 */
	public String insertBrankCard() {
		
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
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("银行卡：" + Utility.getName(brankCardPo.getBbcid()) + "新增!");
		
		//查询银行卡ID是否存在
		int flag = brankCardMgr.getBrankCardId(brankCardPo);
		int flagName=brankCardMgr.getBrankCardName(brankCardPo);
		int flagCardId=brankCardMgr.getBrankCardCardid(brankCardPo);
		
		//清空message
		this.clearMessages();
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{
			if(flagName==0)
			{
				if(flagCardId==0)
				{
					brankCardMgr.insertBrankCard(brankCardPo,logPo);			
					this.addActionMessage(getText("struts.messages.insert.sucess"));
					request.setAttribute("flag",GlobalConstants.OPENUPDATE);
					return SUCCESS;
				}else
				{
					this.addActionMessage(getText("银行卡卡号重复!"));
					request.setAttribute("flag",GlobalConstants.OPENUPDATE);
					return "error";
				}
				
			}else 
			{
				this.addActionMessage(getText("银行卡名称重复!"));
				request.setAttribute("flag",GlobalConstants.OPENUPDATE);
				return "error";				
			}
			
		}else{//否则弹出消息			
			this.addActionMessage(getText("编码重复!"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			return "error";
		}
		
	}
	
	
	
	/**
	 * 初始修改银行卡页面
	 * 
	 * @return
	 */
	public String initUpdateBrankCard(){
		
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
		
		BrankCardPo param = new BrankCardPo();
		param.setBbcid(request.getParameter("hid"));
		
		brankCardPo = brankCardMgr.getBrankCardPo(param);
		
		return SUCCESS;
	}
	
	
	
	/**
	 * 修改银行卡
	 * 
	 * @return
	 */
	public String updateBrankCard() {
		
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
		logPo.setsLogOpID("3");    // 3 表示修改
		logPo.setsLogContent("银行卡：" + Utility.getName(brankCardPo.getBbcid()) + "修改!");
		
		int flagName=brankCardMgr.getBrankCardNameUpdate(brankCardPo);
		int flagCardId=brankCardMgr.getBrankCardCardidUpdate(brankCardPo);
		//清空message
		this.clearMessages();
		
		//如果结果为0，ID不存在继续执行
		if(flagName==0)
		{
			if(flagCardId==0)
			{
				brankCardMgr.updateBrankCard(brankCardPo,logPo);		
				this.addActionMessage(getText("struts.messages.update.sucess"));		
				request.setAttribute("flag",GlobalConstants.OPENUPDATE);
				
				return SUCCESS;
			}else
			{
				this.addActionMessage(getText("银行卡卡号重复!"));
				request.setAttribute("flag",GlobalConstants.OPENUPDATE);
				return "error";
			}
				
		}else 
		{			
			this.addActionMessage(getText("银行卡名称重复!"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);			
			return "error";				
		}
	}
	
	
	/**
	 * 初始删除银行卡页面
	 * 
	 * @return
	 */
	public String initDeleteBrankCard() {
		
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
		
		BrankCardPo param = new BrankCardPo();
		param.setBbcid(request.getParameter("hid"));
		
		brankCardPo = brankCardMgr.getBrankCardPo(param);
		
		return SUCCESS;
	}
	
	
	
	/**
	 * 删除银行卡
	 * 
	 * @return
	 */
	public String deleteBrankCard() {
		
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
		
		BrankCardPo param = new BrankCardPo();
		param.setBbcid(Utility.getName(request.getParameter("hid")));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("银行卡：" + Utility.getName(request.getParameter("hid")) + "删除!");
		
		//查询银行卡在goods表中是否已经使用
		int flag =brankCardMgr.getBrankCardDepartment(param);
		
		//清空message
		this.clearMessages();
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0){
			
			//删除银行卡
			brankCardMgr.deleteBrankCard(param,logPo);
			
			this.addActionMessage(getText("struts.messages.delete.sucess"));
			
		}else{//否则弹出消息			
			this.addActionMessage(getText("此银行卡已被使用不可删除!"));
				
		}
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
		
	}
	
	//
	
	public String initSelectBankList() throws Exception {
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
		BankPo po = new BankPo();
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		

		int count = brankCardMgr.selectBankCount(po);
		//分页
		if (count > 0) 
		{
			int perPage = 0;
			if (request.getParameter("perPage") != null) 
			{
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) 
			{
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

			bankPos = brankCardMgr.selectBankList(po, page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		} else 
		{ //否则查询结果为NULL
			
			bankPos = null;
		
		}
		
		//request.setAttribute("", )回带条件
		
		return SUCCESS;
	}
	
	
	public String initInsertBankPo() throws Exception {
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
		
		
		
		return SUCCESS;
	}
	
	public String insertBankPo() throws Exception {
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("顾客非现金结款类型：" + Utility.getName(bankPo.getBbnumber()) + "新增!" );
		
	
		int flag = brankCardMgr.getBankPoId(bankPo);
		int flagName=brankCardMgr.getBankPoName(bankPo);
		//清空message
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{	
			if(flagName==0)
			{
				//bankPo.setBbstatistics((!Utility.getName(bankPo.getBbstatistics()).equals("") ? "1" : "0"));
				bankPo.setBbstatistics("1");
				
				brankCardMgr.insertBankPo(bankPo, logPo);		
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				return SUCCESS;	
			}else
			{
				this.addActionMessage(getText("顾客非现金结款类型名称重复"));
				return "error";
			}
		}else
		{//否则弹出消息			
			this.addActionMessage(getText("顾客非现金结款类型编号重复"));
			return "error";
		}

	}
	
	public String initUpdateBankPo() throws Exception {
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
		BankPo param=new BankPo();
		param.setBbuuid(request.getParameter("hid"));
		bankPo=brankCardMgr.selectBankPo(param);
		return SUCCESS;
	}
	
	public String updateBankPo() throws Exception {
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 3 表示修改
		logPo.setsLogContent("顾客非现金结款类型：" + Utility.getName(bankPo.getBbnumber()) + "修改!" );
		
		//查询工艺类型ID是否存在
		int flag = brankCardMgr.getBankPoIdUpdate(bankPo);
		int flagName=brankCardMgr.getBankPoNameUpdate(bankPo);
		//清空message
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{	
			if(flagName==0)
			{
				//bankPo.setBbstatistics((!Utility.getName(bankPo.getBbstatistics()).equals("") ? "1" : "0"));
				bankPo.setBbstatistics("1");
				brankCardMgr.updateBankPo(bankPo, logPo)	;		
				this.addActionMessage(getText("struts.messages.update.sucess"));
				return SUCCESS;	
			}else
			{
				this.addActionMessage(getText("顾客非现金结款类型名称重复！"));
				return "error";
			}
		}else
		{//否则弹出消息			
			this.addActionMessage(getText("顾客非现金结款类型编号重复！"));
			return "error";
		}
		
	}
	
	public String initDeleteBankPo() throws Exception {
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
		BankPo param=new BankPo();
		param.setBbuuid(request.getParameter("hid"));
		bankPo=brankCardMgr.selectBankPo(param);		
		return SUCCESS;
	}
	
	public String deleteBankPo() throws Exception {
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
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("顾客非现金结款类型：" + Utility.getName(request.getParameter("hno")) + "删除!" );
		
		BankPo param=new BankPo();
		param.setBbuuid(request.getParameter("hid"));
		
		
		//查询职务表在其他s表中是否已经使用
		int flag =0 ;
		
		//清空message
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		

		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{	
			brankCardMgr.deleteBankPo(param, logPo);		
			this.addActionMessage(getText("struts.messages.delete.sucess"));
		}else
		{//否则弹出消息			
			this.addActionMessage(getText("顾客非现金结款类型删除失败 ,已被使用！"));
			
		}
		
		return SUCCESS;
	}
	
	
	
}
