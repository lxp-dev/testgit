package com.pengsheng.weixin.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.casehistory.mgr.InspectionNMgr;
import com.pengsheng.eims.casehistory.mgr.RefractiveNMgr;
import com.pengsheng.eims.casehistory.persistence.InspectionPo;
import com.pengsheng.eims.casehistory.persistence.RefractivePo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.mgr.ConfigurationMgr;
import com.pengsheng.weixin.mgr.WeiXinDataConfigMgr;
import com.pengsheng.weixin.persistence.WeiXinDataConfigPo;

public class WeiXinMyCaseHistoryAction extends BaseAction {

	private CustomerInfoMgr customerInfoMgr;
	private RefractiveNMgr refractiveNMgr;
	private OptionParamMgr optionParamMgr;;
	private InspectionNMgr inspectionNMgr;
	private ConfigurationMgr configurationMgr;
	private WeiXinDataConfigMgr weiXinDataConfigMgr;
	
	
	/**
	 * 初始化微信我的病例
	 */
	public String initMyCaseHistorySel() throws Exception {
		
		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if(openID.equals("")){
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);
		
		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);	
		
		if(customerInfoPo==null || Utility.getName(customerInfoPo.getSmecicustomerid()).equals("")){					
			return "weiXinMemberBindSel";
		}
		// openID判断
		
		List<CustomerInfoPo> list1 = new ArrayList<CustomerInfoPo>();
		List<CustomerInfoPo> list2 = new ArrayList<CustomerInfoPo>();
		
		CustomerInfoPo tmpCustomerInfoPo = new CustomerInfoPo();
		tmpCustomerInfoPo.setSmecicustomerid(customerInfoPo.getSmecicustomerid());
		list1 = customerInfoMgr.getWeixinCustomerInfoList(tmpCustomerInfoPo);
		
		tmpCustomerInfoPo = new CustomerInfoPo();
		tmpCustomerInfoPo.setSmecisourcecard(customerInfoPo.getSmecimemberid());
		list2 = customerInfoMgr.getWeixinCustomerInfoList(tmpCustomerInfoPo);
		
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		
		WeiXinDataConfigPo weiXinDataConfigPo = weiXinDataConfigMgr.getWeiXinDataConfigPo();
		request.setAttribute("weiXinDataConfigPo", weiXinDataConfigPo);
		return SUCCESS;
	}
	
	/**
	 * 初始化微信我的病例-最新屈光
	 */
	public String initWeiXinNewRefractionSel() throws Exception {
		
		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if(openID.equals("")){
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);
		
		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);	
		
		if(customerInfoPo==null || Utility.getName(customerInfoPo.getSmecicustomerid()).equals("")){					
			return "weiXinMemberBindSel";
		}
		// openID判断
		
		String tmpCustomerID = Utility.getName(request.getParameter("tmpCustomerID"));
		
		RefractivePo refractivePo = new RefractivePo();
		refractivePo = refractiveNMgr.getLastRefractive(tmpCustomerID);
		
		request.setAttribute("refractivePo", refractivePo);
		return SUCCESS;
	}

	/**
	 * 初始化微信我的病例-最新诊疗信息
	 */
	public String initWeiXinNewZhenliaoSel() throws Exception {
		
		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if(openID.equals("")){
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);
		
		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);	
		
		if(customerInfoPo==null || Utility.getName(customerInfoPo.getSmecicustomerid()).equals("")){					
			return "weiXinMemberBindSel";
		}
		// openID判断	
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		List<OptionParamPo> optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		String tmpCustomerID = Utility.getName(request.getParameter("tmpCustomerID"));
		InspectionPo inspectionPo = new InspectionPo();
		inspectionPo = inspectionNMgr.getLastInspectionPo(tmpCustomerID);
		
		request.setAttribute("inspectionPo", inspectionPo);
		request.setAttribute("optionParamPolist", optionParamPolist);
		return SUCCESS;
	}
	
	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}

	public RefractiveNMgr getRefractiveNMgr() {
		return refractiveNMgr;
	}

	public void setRefractiveNMgr(RefractiveNMgr refractiveNMgr) {
		this.refractiveNMgr = refractiveNMgr;
	}

	public OptionParamMgr getOptionParamMgr() {
		return optionParamMgr;
	}

	public void setOptionParamMgr(OptionParamMgr optionParamMgr) {
		this.optionParamMgr = optionParamMgr;
	}

	public InspectionNMgr getInspectionNMgr() {
		return inspectionNMgr;
	}

	public void setInspectionNMgr(InspectionNMgr inspectionNMgr) {
		this.inspectionNMgr = inspectionNMgr;
	}

	public ConfigurationMgr getConfigurationMgr() {
		return configurationMgr;
	}

	public void setConfigurationMgr(ConfigurationMgr configurationMgr) {
		this.configurationMgr = configurationMgr;
	}

	public WeiXinDataConfigMgr getWeiXinDataConfigMgr() {
		return weiXinDataConfigMgr;
	}

	public void setWeiXinDataConfigMgr(WeiXinDataConfigMgr weiXinDataConfigMgr) {
		this.weiXinDataConfigMgr = weiXinDataConfigMgr;
	}

}
