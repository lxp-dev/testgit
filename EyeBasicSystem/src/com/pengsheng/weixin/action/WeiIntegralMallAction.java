package com.pengsheng.weixin.action;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.SetMealMgr;
import com.pengsheng.eims.sales.mgr.VenditionInformationMgr;
import com.pengsheng.eims.sales.persistence.IntegralAddandSubPo;
import com.pengsheng.eims.system.persistence.IntegralPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.mgr.ConfigurationMgr;
import com.pengsheng.weixin.mgr.WeiXinCmsContentMgr;
import com.pengsheng.weixin.mgr.WeiXinDataConfigMgr;
import com.pengsheng.weixin.mgr.WeiXinIntegralSelectMgr;
import com.pengsheng.weixin.persistence.WeiXinCmsContentPo;
import com.pengsheng.weixin.persistence.WeiXinDataConfigPo;
import com.pengsheng.weixin.persistence.WeiXinIntegralSelectPo;

public class WeiIntegralMallAction extends BaseAction {

	private ConfigurationMgr configurationMgr;
	private WeiXinIntegralSelectMgr weiXinIntegralSelectMgr;
	private VenditionInformationMgr venditionInformationMgr;
	private SetMealMgr setMealMgr;
	private WeiXinDataConfigMgr weiXinDataConfigMgr;
	private WeiXinCmsContentMgr weiXinCmsContentMgr;
	
	/**
	 * 初始化积分商城首页
	 * 
	 * @return
	 */
	public String initIntegralMallSel() {

		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if (openID.equals("")) {
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);

		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);

		if (customerInfoPo == null
				|| Utility.getName(customerInfoPo.getSmecicustomerid()).equals(
						"")) {
			return "weiXinMemberBindSel";
		}
		// openID判断

		List goodsInfoPos = weiXinIntegralSelectMgr
				.selectIntegralConvertGoodsList(null);

		request.setAttribute("goodsInfoPos", goodsInfoPos);
		request.setAttribute("customerInfoPo", customerInfoPo);
		
		WeiXinDataConfigPo weiXinDataConfigPo = weiXinDataConfigMgr.getWeiXinDataConfigPo();
		request.setAttribute("weiXinDataConfigPo", weiXinDataConfigPo);
		
		return SUCCESS;
	}

	/**
	 * 初始化积分日志
	 * 
	 * @return
	 */
	public String initIntegralLog() {

		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if (openID.equals("")) {
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);

		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr
				.getCustomerInfoByOpenID(customerInfoPo);

		if (customerInfoPo == null
				|| Utility.getName(customerInfoPo.getSmecicustomerid()).equals(
						"")) {
			return "weiXinMemberBindSel";
		}
		// openID判断

		List salesBasicList = venditionInformationMgr
				.getIntegralExpenseList(customerInfoPo.getSmecicustomerid());
		request.setAttribute("salesBasicList", salesBasicList);

		WeiXinDataConfigPo weiXinDataConfigPo = weiXinDataConfigMgr.getWeiXinDataConfigPo();
		request.setAttribute("weiXinDataConfigPo", weiXinDataConfigPo);
		
		return SUCCESS;
	}

	/**
	 * 初始化积分商城商品兑换状态
	 * 
	 * @return
	 */
	public String initIntegralState() {

		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if (openID.equals("")) {
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);

		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr
				.getCustomerInfoByOpenID(customerInfoPo);

		if (customerInfoPo == null
				|| Utility.getName(customerInfoPo.getSmecicustomerid()).equals(
						"")) {
			return "weiXinMemberBindSel";
		}
		// openID判断

		WeiXinIntegralSelectPo weiXinIntegralSelectPo = new WeiXinIntegralSelectPo();
		weiXinIntegralSelectPo.setWiecustomerid(customerInfoPo.getSmecicustomerid());
		
		List integralStateList=weiXinIntegralSelectMgr.getWeiXinIntegralSelectList(weiXinIntegralSelectPo);
		request.setAttribute("integralStateList", integralStateList);

		WeiXinDataConfigPo weiXinDataConfigPo = weiXinDataConfigMgr.getWeiXinDataConfigPo();
		request.setAttribute("weiXinDataConfigPo", weiXinDataConfigPo);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化积分商城商品List页
	 * 
	 * @return
	 */
	public String initIntegralGoodsListSel() {

		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if (openID.equals("")) {
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);

		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr
				.getCustomerInfoByOpenID(customerInfoPo);

		if (customerInfoPo == null
				|| Utility.getName(customerInfoPo.getSmecicustomerid()).equals(
						"")) {
			return "weiXinMemberBindSel";
		}
		// openID判断

		List goodsInfoPos = weiXinIntegralSelectMgr
				.selectIntegralConvertGoodsList(null);
		request.setAttribute("goodsInfoPos", goodsInfoPos);
		request.setAttribute("customerInfoPo", customerInfoPo);
		
		WeiXinDataConfigPo weiXinDataConfigPo = weiXinDataConfigMgr.getWeiXinDataConfigPo();
		request.setAttribute("weiXinDataConfigPo", weiXinDataConfigPo);
		
		return SUCCESS;
	}

	/**
	 * 初始化积分商城商品详细页
	 * 
	 * @return
	 */
	public String initIntegralGoodsDetailSel() {

		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if (openID.equals("")) {
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);

		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr
				.getCustomerInfoByOpenID(customerInfoPo);

		if (customerInfoPo == null
				|| Utility.getName(customerInfoPo.getSmecicustomerid()).equals(
						"")) {
			return "weiXinMemberBindSel";
		}
		// openID判断

		String goodsID = Utility.getName(request.getParameter("goodsID"));

		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo = weiXinIntegralSelectMgr
				.selectIntegralConvertGoods(goodsInfoPo);

		IntegralPo integralPo = new IntegralPo();
		integralPo.setFirGoodsID(goodsID);
		integralPo = setMealMgr.getIntegralExchangeSetDetail(integralPo);
		
		int yiduihuanInt = weiXinIntegralSelectMgr.selectInGoodsNum(openID, goodsID);
		if((Integer.parseInt(integralPo.getFirpersonnum()) - yiduihuanInt)>0){
			integralPo.setFirpersonnum((Integer.parseInt(integralPo.getFirpersonnum()) - yiduihuanInt)+"");
		}else{
			integralPo.setFirpersonnum("0");
		}
		
		String[] departmentIDs = integralPo.getFirdepartmentid().split(",");
		String[] departmentNames = integralPo.getFirdepartmentname().split(",");
		List<DepartmentsPo> departmentPoList = new ArrayList();
		DepartmentsPo tmpDepartmentsPo;
		
		for (int i = 0; i < departmentIDs.length; i++) {
			tmpDepartmentsPo = new DepartmentsPo();
			tmpDepartmentsPo.setBdpdepartmentid(departmentIDs[i]);
			tmpDepartmentsPo.setBdpdepartmentname(departmentNames[i]);
			departmentPoList.add(tmpDepartmentsPo);
		}
		
		request.setAttribute("departmentPoList", departmentPoList);
		request.setAttribute("integralPo", integralPo);
		request.setAttribute("goodsInfoPo", goodsInfoPo);
		request.setAttribute("customerInfoPo", customerInfoPo);
		
		WeiXinDataConfigPo weiXinDataConfigPo = weiXinDataConfigMgr.getWeiXinDataConfigPo();
		request.setAttribute("weiXinDataConfigPo", weiXinDataConfigPo);
		
		return SUCCESS;
	}

	/**
	 * 兑换商品
	 * 
	 * @return
	 */
	public String updateIntegralGoods() {

		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if (openID.equals("")) {
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);

		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr
				.getCustomerInfoByOpenID(customerInfoPo);

		if (customerInfoPo == null
				|| Utility.getName(customerInfoPo.getSmecicustomerid()).equals(
						"")) {
			return "weiXinMemberBindSel";
		}
		// openID判断
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName("微信用户openID"+openID);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult("");
		logPo.setsLogOpID("2");
		logPo.setsLogContent("微信积分兑换新增!");
		
		String yintegral = Utility.getName(request.getParameter("yintegral"));
		String cintegral = Utility.getName(request.getParameter("cintegral"));
		String goodsid = Utility.getName(request.getParameter("goodsID"));
		String integral = Utility.getName(request.getParameter("xintegral"));
		String goodsnumber = Utility.getName(request.getParameter("goodsnumber"));
		String wiedepartmentid = Utility.getName(request.getParameter("wiedepartmentid"));
		
		BigDecimal byintegral = new BigDecimal(yintegral);
		BigDecimal bcintegral = new BigDecimal("-"+cintegral);		
		
		CustomerInfoPo tcpo = new CustomerInfoPo();
		tcpo.setSmeciopenid(openID);
		CustomerInfoPo iscpo = weiXinIntegralSelectMgr.selectCustomerInfoPo(tcpo);
		
		BigDecimal xyintegral = new BigDecimal(iscpo.getSmeciintegral());
		if(xyintegral.compareTo(bcintegral) == -1){
			String url = "''initIntegralGoodsDetailSel.action?goodsID="+ goodsid +"&openID="+openID+"''"; 
			List<String> params = new ArrayList<String>(); 
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			
			this.clearMessages();
			this.addActionMessage(getText("所用积分不足!"));
			request.setAttribute("flag", GlobalConstants.INSERT);
			return SUCCESS;
		}
		
		WeiXinIntegralSelectPo wpo = new WeiXinIntegralSelectPo();
		
		wpo.setWiecustomerid(customerInfoPo.getSmecicustomerid());
        wpo.setWieopenid(openID);
        wpo.setWieflag("0");
        wpo.setWiegoodsid(goodsid);
        wpo.setWieintegral(cintegral);
        wpo.setWiegoodsnumber(goodsnumber);
        wpo.setWiedepartmentid(wiedepartmentid);
        
        
        IntegralAddandSubPo ipo = new IntegralAddandSubPo();
        
        ipo.setSmeasyintegral(yintegral);
        ipo.setSmeascintegral("-"+cintegral);
		ipo.setSmeasxintegral((byintegral.add(bcintegral))+"");
		ipo.setSmeasremark("微信积分兑换！");
		ipo.setSmeasaddorsub("7");
		ipo.setSmeascustomerid(customerInfoPo.getSmecicustomerid());
		
		
		CustomerInfoPo cpo = new CustomerInfoPo();
		
		cpo.setSmeciintegral((byintegral.add(bcintegral))+"");
		cpo.setSmeciopenid(openID);
		
		weiXinIntegralSelectMgr.insertIntegralSelectPo(wpo, ipo, cpo, logPo);
		
		this.clearMessages(); 
		String url = "''updateIntegralGoodsOK.action?openID={0}''";
		List<String> params = new ArrayList<String>();
		params.add(openID);
		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		WeiXinDataConfigPo weiXinDataConfigPo = weiXinDataConfigMgr.getWeiXinDataConfigPo();
		request.setAttribute("weiXinDataConfigPo", weiXinDataConfigPo);
		
		return SUCCESS;
	}
	
	/**
	 * 兑换商品成功
	 */
	public String updateIntegralGoodsOK() throws Exception {

		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if (openID.equals("")) {
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);

		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);

		if (customerInfoPo == null
				|| Utility.getName(customerInfoPo.getSmecicustomerid()).equals(
						"")) {
			return "weiXinMemberBindSel";
		}
		// openID判断
		
		WeiXinDataConfigPo weiXinDataConfigPo = weiXinDataConfigMgr.getWeiXinDataConfigPo();
		request.setAttribute("weiXinDataConfigPo", weiXinDataConfigPo);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化会员协议
	 */
	public String initIntegralGuize() {
		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if (openID.equals("")) {
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);

		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr
				.getCustomerInfoByOpenID(customerInfoPo);

		if (customerInfoPo == null
				|| Utility.getName(customerInfoPo.getSmecicustomerid()).equals(
						"")) {
			return "weiXinMemberBindSel";
		}
		// openID判断
		
		WeiXinDataConfigPo weiXinDataConfigPo =  weiXinDataConfigMgr.getWeiXinDataConfigPo();
		WeiXinCmsContentPo weiXinCmsContentPo = new WeiXinCmsContentPo();
		weiXinCmsContentPo.setWcmscid(weiXinDataConfigPo.getWdcintegralagreement());
		
		weiXinCmsContentPo = weiXinCmsContentMgr.selectWeiXinCmsContentPo(weiXinCmsContentPo);
		
		request.setAttribute("weiXinCmsContentPo", weiXinCmsContentPo);
		return SUCCESS;
	}
	
	public ConfigurationMgr getConfigurationMgr() {
		return configurationMgr;
	}

	public void setConfigurationMgr(ConfigurationMgr configurationMgr) {
		this.configurationMgr = configurationMgr;
	}

	public WeiXinIntegralSelectMgr getWeiXinIntegralSelectMgr() {
		return weiXinIntegralSelectMgr;
	}

	public void setWeiXinIntegralSelectMgr(
			WeiXinIntegralSelectMgr weiXinIntegralSelectMgr) {
		this.weiXinIntegralSelectMgr = weiXinIntegralSelectMgr;
	}

	public VenditionInformationMgr getVenditionInformationMgr() {
		return venditionInformationMgr;
	}

	public void setVenditionInformationMgr(
			VenditionInformationMgr venditionInformationMgr) {
		this.venditionInformationMgr = venditionInformationMgr;
	}

	public SetMealMgr getSetMealMgr() {
		return setMealMgr;
	}

	public void setSetMealMgr(SetMealMgr setMealMgr) {
		this.setMealMgr = setMealMgr;
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

}
