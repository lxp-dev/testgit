package com.pengsheng.eims.storage.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.util.profiling.UtilTimerStack;
import com.pengsheng.eims.storage.mgr.SmsMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;


public class SmsAction extends BaseAction {
	private SmsMgr smsMgr;
	
	private PersonInfoMgr personInfoMgr;
	
	private List<SmsLertsPo> smsList;
	
	private List<SmsLertsPo> ordersSmsList;
	
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	
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
	public List<SmsLertsPo> getOrdersSmsList() {
		return ordersSmsList;
	}
	public void setOrdersSmsList(List<SmsLertsPo> ordersSmsList) {
		this.ordersSmsList = ordersSmsList;
	}
	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}
	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}
	public SmsMgr getSmsMgr() {
		return smsMgr;
	}
	public void setSmsMgr(SmsMgr smsMgr) {
		this.smsMgr = smsMgr;
	}
	

	
	public List<SmsLertsPo> getSmsList() {
		return smsList;
	}
	public void setSmsList(List<SmsLertsPo> smsList) {
		this.smsList = smsList;
	}
	
	/*
	 * 取得消息数量
	 */
	public void doAjax() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();       
		response.setCharacterEncoding("UTF-8");        
		int count = smsMgr.getSmsCount((PersonInfoPo)session.get("person"),"0");
		PersonInfoPo tempPersonInfoPo=personInfoMgr.getPersonInfo((PersonInfoPo)session.get("person"));
		if(count==0&&!"".equals(Utility.getName(tempPersonInfoPo.getOrderid()))){
//			CustomerContextHolder.setCustomerType(CustomerType.orders);//
			
			count = smsMgr.getOrdersSmsCount(tempPersonInfoPo,"0");
			
//			CustomerContextHolder.setCustomerType(CustomerType.eims);//
		}
		
		response.getWriter().write("{smscount:'"+count+"'}");//消息提醒数量
	}
	
	/*
	 * 消息提醒LIst
	 */
	public String selectSms() throws Exception{
//		CustomerContextHolder.setCustomerType(CustomerType.eims);//
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		int count = smsMgr.getSmsCount((PersonInfoPo)session.get("person"),"0");
		if (count > 0) {
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
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
	    smsList=smsMgr.getSmsList(personInfoPo,page.getStart(),page.getPageSize(),"0");
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			smsList = null;
		}
		//取订单系统消息
		PersonInfoPo tempPersonInfoPo=new PersonInfoPo();
		tempPersonInfoPo.setId(personInfoPo.getId());
		tempPersonInfoPo=personInfoMgr.getPersonInfo(tempPersonInfoPo);
//		CustomerContextHolder.setCustomerType(CustomerType.orders);//
		int ordersCount = "".equals(Utility.getName(tempPersonInfoPo.getOrderid()))?0:smsMgr.getOrdersSmsCount(tempPersonInfoPo,"0");
		if (ordersCount > 0) {
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
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
			
			
	    Pagination page = new Pagination(request, ordersCount, perPage);
	    ordersSmsList=smsMgr.getOrdersSmsList(tempPersonInfoPo,page.getStart(),page.getPageSize(),"0");
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			ordersSmsList = null;
		}
//		CustomerContextHolder.setCustomerType(CustomerType.eims);//
		return SUCCESS;
	}
	/*
	 * 设置为已读
	 */
	public String smsReaded() throws Exception{
//		CustomerContextHolder.setCustomerType(CustomerType.eims);//
		SmsLertsPo smsLertsPo = new SmsLertsPo();
		smsLertsPo.setCstslid(Utility.getName(request.getParameter("readedID")));
		smsMgr.smsReaded(smsLertsPo);
		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		int count = smsMgr.getSmsCount((PersonInfoPo)session.get("person"),"0");
		if (count > 0) {
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
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
	    smsList=smsMgr.getSmsList(personInfoPo,page.getStart(),page.getPageSize(),"0");
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			smsList = null;
		}
		return SUCCESS;
	}
	/*
	 * 订单系统消息设置为已读
	 */
	public String ordersRead() throws Exception{
//		CustomerContextHolder.setCustomerType(CustomerType.eims);//
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		personInfoPo=personInfoMgr.getPersonInfo(personInfoPo);
//		CustomerContextHolder.setCustomerType(CustomerType.orders);//
		SmsLertsPo smsLertsPo = new SmsLertsPo();
		smsLertsPo.setCstslid(Utility.getName(request.getParameter("readedID")));
		smsMgr.smsOrdersReaded(smsLertsPo);
		int count = "".equals(Utility.getName(personInfoPo.getOrderid()))?0:smsMgr.getOrdersSmsCount(personInfoPo,"0");
		if (count > 0) {
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
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
	    smsList=smsMgr.getOrdersSmsList(personInfoPo,page.getStart(),page.getPageSize(),"0");
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			smsList = null;
		}
		
//		CustomerContextHolder.setCustomerType(CustomerType.eims);//
		
		return SUCCESS;
	}
	
	/*
	 * 消息记录
	 */
	public String allSms() throws Exception{
//		CustomerContextHolder.setCustomerType(CustomerType.eims);//
		SmsLertsPo smsLertsPo = new SmsLertsPo();
		smsLertsPo.setCstslid(Utility.getName(request.getParameter("readedID")));
		smsMgr.smsReaded(smsLertsPo);
		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		int count = smsMgr.getSmsCount((PersonInfoPo)session.get("person"),"1");
		if (count > 0) {
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
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
	    smsList=smsMgr.getSmsList(personInfoPo,page.getStart(),page.getPageSize(),"1");
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			smsList = null;
		}
		
		PersonInfoPo tempPersonInfoPo=new PersonInfoPo();
		tempPersonInfoPo.setId(personInfoPo.getId());
		tempPersonInfoPo=personInfoMgr.getPersonInfo(tempPersonInfoPo);
		
//		CustomerContextHolder.setCustomerType(CustomerType.orders);//
		int ordersCount ="".equals(Utility.getName(tempPersonInfoPo.getOrderid()))?0:smsMgr.getOrdersSmsCount(tempPersonInfoPo,"1");
		if (ordersCount > 0) {
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
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
			
			
	    Pagination page = new Pagination(request, ordersCount, perPage);
	    ordersSmsList=smsMgr.getOrdersSmsList(tempPersonInfoPo,page.getStart(),page.getPageSize(),"1");
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			ordersSmsList = null;
		}
//		CustomerContextHolder.setCustomerType(CustomerType.eims);//
		return SUCCESS;
	}

}
