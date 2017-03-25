package com.pengsheng.eims.sales.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.OptometryBasicMgr;
import com.pengsheng.eims.sales.mgr.OptometryInformationMgr;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class OptometryInformationAction extends BaseAction {
	
	private CustomerInfoPo customerInfoPo;

	private OptometryInformationMgr optometryInformationMgr;

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
	public OptometryInformationMgr getOptometryInformationMgr() {
		return optometryInformationMgr;
	}

	public void setOptometryInformationMgr(
			OptometryInformationMgr optometryInformationMgr) {
		this.optometryInformationMgr = optometryInformationMgr;
	}

	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}

	public List<OptometryBasicPo> getOptometryBasics() {
		return optometryBasics;
	}

	public void setOptometryBasics(List<OptometryBasicPo> optometryBasics) {
		this.optometryBasics = optometryBasics;
	}

	private CustomerInfoMgr customerInfoMgr;

	private List<OptometryBasicPo> optometryBasics;


	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	/**
	* 查看验光信息
	*@return
	*/
	public String selectOptometryInformation()throws Exception{
		
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
				int count = optometryInformationMgr.getcustomerOptometryBasicCount(customerInfoPo.getSmecicustomerid());
				if (count > 0) {
					int perPage = 0;
					if (request.getParameter("perPage") != null) {
						perPage = new Integer((String) request
								.getParameter("perPage")).intValue();
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
					optometryBasics = optometryInformationMgr.getcustomerOptometryBasics(customerInfoPo.getSmecicustomerid(), page.getStart(),page.getPageSize());

					for (OptometryBasicPo basic : optometryBasics) {
						basic.setOptometrys(optometryInformationMgr.getcustomerOptometrys(basic.getSopoboptometrybasicid()));
					}
					request.setAttribute(Pagination.PAGINATION, page);
					//request.setAttribute("customerID", customerInfoPo.getSmecicustomerid());
				} else {
					optometryBasics = null;
				}
			}
			
		String dontshow = Utility.getName(request.getParameter("dontshow"));
		request.setAttribute("dontshow", dontshow);
		
		return SUCCESS;
	}
	
}
