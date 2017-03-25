package com.pengsheng.weixin.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.ChuzhikaMgr;
import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.storage.mgr.InTransitMgr;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.mgr.ConfigurationMgr;
import com.pengsheng.weixin.mgr.WeiXinCmsContentMgr;
import com.pengsheng.weixin.mgr.WeiXinDataConfigMgr;
import com.pengsheng.weixin.mgr.WeiXinRegisterDepartmentMgr;
import com.pengsheng.weixin.persistence.ConfigurationPo;
import com.pengsheng.weixin.persistence.WeiXinCmsContentPo;
import com.pengsheng.weixin.persistence.WeiXinDataConfigPo;
import com.pengsheng.weixin.persistence.WeiXinRegisterDepartmentPo;

public class WeiXinPersonCenterAction extends BaseAction {

	private ChuzhikaMgr chuzhikaMgr;
	private CustomerInfoMgr customerInfoMgr;
	private ConfigurationMgr configurationMgr;
	private InTransitMgr inTransitMgr;
	private WeiXinDataConfigMgr weiXinDataConfigMgr;
	private WeiXinCmsContentMgr weiXinCmsContentMgr;
	private WeiXinRegisterDepartmentMgr weiXinRegisterDepartmentMgr;
	
	/**
	 * 初始化微信个人中心
	 */
	public String initPersonCenterSel() throws Exception {
				
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
		
		int count = inTransitMgr.getWeiXinDingzhiDaiqujingCount(customerInfoPo.getSmecicustomerid());
		request.setAttribute("count", count);
		
		ChuzhikaPo chuzhikaPo = new ChuzhikaPo();
		chuzhikaPo= chuzhikaMgr.selectChuzhikaJifenByCustomerID(customerInfoPo.getSmecicustomerid());
		request.setAttribute("chuzhikaPo", chuzhikaPo);
		
		WeiXinDataConfigPo weiXinDataConfigPo = weiXinDataConfigMgr.getWeiXinDataConfigPo();
		
		request.setAttribute("customerInfoPo", customerInfoPo);
		request.setAttribute("weiXinDataConfigPo", weiXinDataConfigPo);
		
		ConfigurationPo configurationPo = configurationMgr.getConfigurationDetail();
		
		//个人中心下方的导航是否显示
		request.getSession().setAttribute("personcenterisshow", configurationPo.getWcrpersoncenterisshow());
		//个人中心菜单中我的病例是否显示
		request.getSession().setAttribute("mycasehistoryisshow", configurationPo.getWcrmycasehistoryisshow());
		//个人中心首页是显示会员剩余积分还是储值卡余额
		request.setAttribute("jifenorchuzhi", configurationPo.getWcrjifenorchuzhi());
		
		return SUCCESS;
	}
	
	/**
	 * 初始化联系我们
	 */
	public String initContactUsSel() throws Exception {
				
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
		
		//根据微信公众号原始ID取得联系我们信息
		String toUserName = (String) session.get("toUserName");
		
		WeiXinRegisterDepartmentPo weiXinRegisterDepartmentPo = new WeiXinRegisterDepartmentPo();
		weiXinRegisterDepartmentPo.setWrdaccount(toUserName);
		weiXinRegisterDepartmentPo = weiXinRegisterDepartmentMgr.getWeiXinRegisterDepartmentPo(weiXinRegisterDepartmentPo);
		request.setAttribute("weiXinRegisterDepartmentPo", weiXinRegisterDepartmentPo);
		//根据微信公众号原始ID取得联系我们信息
		
		WeiXinDataConfigPo weiXinDataConfigPo = weiXinDataConfigMgr.getWeiXinDataConfigPo();
		request.setAttribute("weiXinDataConfigPo", weiXinDataConfigPo);

		return SUCCESS;
	}
	
	/**
	 * 初始化最新活动
	 */
	public String initNewActivitySel() throws Exception {
				
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
		
		WeiXinDataConfigPo weiXinDataConfigPo =  weiXinDataConfigMgr.getWeiXinDataConfigPo();
		WeiXinCmsContentPo po = new WeiXinCmsContentPo();	
		po.setWcmsctypeid(weiXinDataConfigPo.getWdcnewactivity());

		List<WeiXinCmsContentPo> newsContentList = weiXinCmsContentMgr
				.selectWeiXinCmsContentListForView(po);
		
		request.setAttribute("newsContentList", newsContentList);
		
		return SUCCESS;
	}
	
	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}

	public ConfigurationMgr getConfigurationMgr() {
		return configurationMgr;
	}

	public void setConfigurationMgr(ConfigurationMgr configurationMgr) {
		this.configurationMgr = configurationMgr;
	}

	public InTransitMgr getInTransitMgr() {
		return inTransitMgr;
	}

	public void setInTransitMgr(InTransitMgr inTransitMgr) {
		this.inTransitMgr = inTransitMgr;
	}

	public WeiXinDataConfigMgr getWeiXinDataConfigMgr() {
		return weiXinDataConfigMgr;
	}

	public void setWeiXinDataConfigMgr(WeiXinDataConfigMgr weiXinDataConfigMgr) {
		this.weiXinDataConfigMgr = weiXinDataConfigMgr;
	}

	public WeiXinCmsContentMgr getWeiXinCmsContentMgr() {
		return weiXinCmsContentMgr;
	}

	public void setWeiXinCmsContentMgr(WeiXinCmsContentMgr weiXinCmsContentMgr) {
		this.weiXinCmsContentMgr = weiXinCmsContentMgr;
	}

	public WeiXinRegisterDepartmentMgr getWeiXinRegisterDepartmentMgr() {
		return weiXinRegisterDepartmentMgr;
	}

	public void setWeiXinRegisterDepartmentMgr(
			WeiXinRegisterDepartmentMgr weiXinRegisterDepartmentMgr) {
		this.weiXinRegisterDepartmentMgr = weiXinRegisterDepartmentMgr;
	}

	public ChuzhikaMgr getChuzhikaMgr() {
		return chuzhikaMgr;
	}

	public void setChuzhikaMgr(ChuzhikaMgr chuzhikaMgr) {
		this.chuzhikaMgr = chuzhikaMgr;
	}

}
