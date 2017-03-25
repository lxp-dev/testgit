package com.pengsheng.eims.components.action;

import java.util.List;

import com.pengsheng.eims.components.mgr.SpecialRequirementsOpenMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SpecialRequirementsPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class SpecialRequirementsOpenAction extends BaseAction {
	private SpecialRequirementsOpenMgr specialRequirementsOpenMgr;

	public SpecialRequirementsOpenMgr getSpecialRequirementsOpenMgr() {
		return specialRequirementsOpenMgr;
	}
	public void setSpecialRequirementsOpenMgr(
			SpecialRequirementsOpenMgr specialRequirementsOpenMgr) {
		this.specialRequirementsOpenMgr = specialRequirementsOpenMgr;
	}
	private List<SpecialRequirementsPo> speList;
	
	public List<SpecialRequirementsPo> getSpeList() {
		return speList;
	}
	public void setSpeList(List<SpecialRequirementsPo> speList) {
		this.speList = speList;
	}
	private SpecialRequirementsPo po;
	
	public SpecialRequirementsPo getPo() {
		return po;
	}
	public void setPo(SpecialRequirementsPo po) {
		this.po = po;
	}
	/**
	 * 初始化特殊加工要求
	 */
	public String initSpecialRequirementsInsertOpen() throws Exception {		
		
		String customerID=Utility.getName(request.getParameter("customerID"));
		po=new SpecialRequirementsPo();
		//查询特殊加工要求数量
		int count=specialRequirementsOpenMgr.getSpecialRequirementsCount(po);
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
					perPage = 50;
				}
			} else {
				perPage = 50;
			}
	    Pagination page = new Pagination(request, count, perPage);
	    speList=specialRequirementsOpenMgr.geSpecialRequirementsList(po,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			speList = null;
		}		
		return SUCCESS;
	}

	/**
	 * 显示特殊加工要求信息
	 */
	public String selSpecialRequirementsOpen() throws Exception {	
		
		String customerID=Utility.getName(request.getParameter("customerID"));
	    po = new SpecialRequirementsPo();
	    //查询特殊加工要求数量
		int count=specialRequirementsOpenMgr.getSpecialRequirementsCount(po);
		//根据数量进行分页,默认50条信息为一页
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
					perPage = 50;
				}
			} else {
				perPage = 50;
			}
	    Pagination page = new Pagination(request, count, perPage);
	    //遍历特殊加工要求信息
	    speList=specialRequirementsOpenMgr.geSpecialRequirementsList(po,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			speList = null;
		}		
		return SUCCESS;
	}
}
