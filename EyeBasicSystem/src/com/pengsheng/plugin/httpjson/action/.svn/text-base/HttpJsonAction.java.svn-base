package com.pengsheng.plugin.httpjson.action;

import java.util.HashMap;
import java.util.Map;

import com.googlecode.jsonplugin.annotations.JSON;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.plugin.po.CustomerInfoJsonPo;

public class HttpJsonAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private CustomerInfoMgr customerInfoMgr;	
	private Map<String, Object> dataMap;
	private String key = "Just see see";

	/**
	 * 1、根据顾客ID，查询会员基本信息
	 */
	public String getCustomerInfoJson() {
		String customerid = Utility.getName(request.getParameter("customerid"));
		CustomerInfoJsonPo customerInfoJsonPo = new CustomerInfoJsonPo();
		
		dataMap = new HashMap<String, Object>();// dataMap中的数据将会被Struts2转换成JSON字符串，所以这里要先清空其中的数据
		if(customerid.equals("")){
			dataMap.put("result", "error");
			dataMap.put("info", "请传递顾客卡号");
			
		}else{
			CustomerInfoPo customerInfoPo = new CustomerInfoPo();
			customerInfoPo.setSmecimemberid(customerid);
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
			
			customerInfoJsonPo.setName(Utility.getName(customerInfoPo.getSmeciname()));
			customerInfoJsonPo.setSex(Utility.getName(customerInfoPo.getSmecisex()));
			customerInfoJsonPo.setTel(Utility.getName(customerInfoPo.getSmeciphone()));
			customerInfoJsonPo.setBirthday(Utility.getName(customerInfoPo.getSmecibirthday()));
			customerInfoJsonPo.setAddress(Utility.getName(customerInfoPo.getSmecizone()));
			customerInfoJsonPo.setMailcode(Utility.getName(customerInfoPo.getSmecipostcode()));
			customerInfoJsonPo.setJob(Utility.getName(customerInfoPo.getSmeciworkname()));
			
			dataMap.put("result", "success");
			dataMap.put("info", "操作成功");
			dataMap.put("data", customerInfoJsonPo);
		}
		
		dataMap.put("data", customerInfoJsonPo);
		return SUCCESS;
	}
	
	//设置key属性不作为json的内容返回
	@JSON(serialize = false)
	public String getKey() {
		return key;
	}

	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}
}
