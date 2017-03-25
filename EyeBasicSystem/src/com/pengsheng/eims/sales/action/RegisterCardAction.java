package com.pengsheng.eims.sales.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;



import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.RegisterCardMgr;
import com.pengsheng.eims.sales.persistence.RechargeRecordPo;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

import com.pengsheng.eims.util.basicaction.BaseAction;

import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class RegisterCardAction extends BaseAction {
	
	private RegisterCardMgr registerCardMgr;
	
	private RechargeRecordPo rechargeRecordPo;
	
	private List<RechargeRecordPo> rechargeRecordPoList;
	
	private CustomerInfoMgr customerInfoMgr;
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
	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}
	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}
	public List<RechargeRecordPo> getRechargeRecordPoList() {
		return rechargeRecordPoList;
	}
	public void setRechargeRecordPoList(List<RechargeRecordPo> rechargeRecordPoList) {
		this.rechargeRecordPoList = rechargeRecordPoList;
	}
	public RechargeRecordPo getRechargeRecordPo() {
		return rechargeRecordPo;
	}
	public void setRechargeRecordPo(RechargeRecordPo rechargeRecordPo) {
		this.rechargeRecordPo = rechargeRecordPo;
	}
	public RegisterCardMgr getRegisterCardMgr() {
		return registerCardMgr;
	}
	public void setRegisterCardMgr(RegisterCardMgr registerCardMgr) {
		this.registerCardMgr = registerCardMgr;
	}
	/**
	 * 显示刷卡记录
	 * @return
	 * @throws Exception
	 */
	public String selectRegisterCard()throws Exception{

		CustomerInfoPo customerInfoPo=new CustomerInfoPo();
		if(!Utility.getName(request.getParameter("customerID")).equals("")){
			customerInfoPo.setSmecicustomerid(request.getParameter("customerID"));
		}
		if (customerInfoPo != null) {
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
				request.setAttribute("customerID", customerInfoPo.getSmecicustomerid());
			}
		if (StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {
			
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
			int count = registerCardMgr.getRegisterCardCount(customerInfoPo.getSmecicustomerid());//刷卡记录数量
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
				//列出刷卡记录信息
				rechargeRecordPoList = registerCardMgr.getRegisterCardList(customerInfoPo.getSmecicustomerid(),page.getStart(),page.getPageSize());
				request.setAttribute(Pagination.PAGINATION, page);
			} else {
				rechargeRecordPoList = null;
			}
		}
		return SUCCESS;
	}

}
