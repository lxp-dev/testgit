package com.pengsheng.weixin.action;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.components.mgr.WindowsMgr;
import com.pengsheng.eims.frame.dao.LoginDao;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.GuitarManagementMgr;
import com.pengsheng.eims.sales.mgr.VenditionInformationMgr;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.system.mgr.SendNoteMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;
import com.pengsheng.weixin.mgr.ConfigurationMgr;
import com.pengsheng.weixin.mgr.WeiXinAutoReplyMgr;
import com.pengsheng.weixin.mgr.WeiXinCmsContentMgr;
import com.pengsheng.weixin.mgr.WeiXinDataConfigMgr;
import com.pengsheng.weixin.mgr.WeiXinRegisterDepartmentMgr;
import com.pengsheng.weixin.persistence.WeiXinCmsContentPo;
import com.pengsheng.weixin.persistence.WeiXinDataConfigPo;
import com.pengsheng.weixin.persistence.WeiXinIntegralSelectPo;
import com.pengsheng.weixin.persistence.WeiXinRegisterDepartmentPo;
import com.pengsheng.weixin.util.SendWeChatMessage;

public class MemberBindAction extends BaseAction {

	private ConfigurationMgr configurationMgr;
	private CustomerInfoPo customerInfoPo;
	private List<WeiXinIntegralSelectPo> weiXinIntegralSelectList;
	private List<SalesBasicPo> salesBasicList;
	private List<SalesDetailPo> salesDetailList;
	private SalesBasicPo salesBasicPo;
	private WindowsMgr windowsMgr;	
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;	
	private CompanyNamePo companyNamePo;
	private LoginDao loginDao;
	private VenditionInformationMgr venditionInformationMgr;
	private GuitarManagementMgr guitarManagementMgr;
	private WeiXinIntegralSelectPo weiXinIntegralSelectPo;
	private CustomerInfoMgr customerInfoMgr;
	private WeiXinDataConfigMgr weiXinDataConfigMgr;
	private WeiXinCmsContentMgr weiXinCmsContentMgr;
	private WeiXinRegisterDepartmentMgr weiXinRegisterDepartmentMgr;
	private SendNoteMgr sendNoteMgr;	
	private WeiXinAutoReplyMgr weiXinAutoReplyMgr;
	
	public WeiXinIntegralSelectPo getWeiXinIntegralSelectPo() {
		return weiXinIntegralSelectPo;
	}

	public void setWeiXinIntegralSelectPo(
			WeiXinIntegralSelectPo weiXinIntegralSelectPo) {
		this.weiXinIntegralSelectPo = weiXinIntegralSelectPo;
	}

	public GuitarManagementMgr getGuitarManagementMgr() {
		return guitarManagementMgr;
	}

	public void setGuitarManagementMgr(GuitarManagementMgr guitarManagementMgr) {
		this.guitarManagementMgr = guitarManagementMgr;
	}

	

	public VenditionInformationMgr getVenditionInformationMgr() throws Exception {
		return venditionInformationMgr;
	}

	public void setVenditionInformationMgr(
			VenditionInformationMgr venditionInformationMgr) {
		this.venditionInformationMgr = venditionInformationMgr;
	}
	
	/**
	 * 发送一条多客服消息给访问者
	 * @throws UnsupportedEncodingException
	 */
	public void getDuokefuAjax() throws UnsupportedEncodingException{
		String openID = Utility.getName(request.getParameter("openID"));
		String hfString = Utility.getName(weiXinAutoReplyMgr.getWeiXinAutoReplyPo().getWartitlehf());
		
		if(hfString.equals("")){
			hfString = "很高兴为您服务，请问您想咨询什么？";
		}
		if(!openID.equals("")){		
			
			//根据微信公众号原始ID取得联系我们信息
			String toUserName = (String) session.get("toUserName");
			
			WeiXinRegisterDepartmentPo weiXinRegisterDepartmentPo = new WeiXinRegisterDepartmentPo();
			weiXinRegisterDepartmentPo.setWrdaccount(toUserName);
			weiXinRegisterDepartmentPo = weiXinRegisterDepartmentMgr.getWeiXinRegisterDepartmentPo(weiXinRegisterDepartmentPo);
			//根据微信公众号原始ID取得联系我们信息
			
			new SendWeChatMessage().sendMessage(weiXinRegisterDepartmentPo.getWrdappid(),weiXinRegisterDepartmentPo.getWrdappsecret(),openID,hfString);
		}
		
	}
	/**
	 * 初始化会员绑定
	 */
	public String initWeiXinMemberBindSel() {
		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if(openID.equals("")){
//			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);
		
		String toUserName = Utility.getName(request.getParameter("toUserName"));
		if(toUserName.equals("") && session.get("toUserName")!=null && !session.get("toUserName").toString().equals("")){
			toUserName = session.get("toUserName").toString();
		}
		
		if(toUserName.equals("")){
//			return "weixinSessionOut";
		}
		request.setAttribute("toUserName", toUserName);
		
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);	
		
		if(customerInfoPo!=null && !Utility.getName(customerInfoPo.getSmecicustomerid()).equals("")){					
			return "personCenter";
		}
		// openID判断
		
		
		request.setAttribute("registertype", Utility.getName(configurationMgr.getConfigurationDetail().getWcrregistertype()));
		request.setAttribute("input1", Utility.getName(request.getParameter("input1")));
		request.setAttribute("checkCode", Utility.getName(request.getParameter("checkCode")));
		request.setAttribute("memberPhone", Utility.getName(request.getParameter("memberPhone")));

		return SUCCESS;
	}

	/**
	 * 初始化会员协议
	 */
	public String initWeiXinMemberAgreementSel() {
		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if(openID.equals("")){
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);
		
		String toUserName = Utility.getName(request.getParameter("toUserName"));
		if(toUserName.equals("")){
			return "weixinSessionOut";
		}
		request.setAttribute("toUserName", toUserName);
		// openID判断
		
		WeiXinDataConfigPo weiXinDataConfigPo =  weiXinDataConfigMgr.getWeiXinDataConfigPo();
		WeiXinCmsContentPo weiXinCmsContentPo = new WeiXinCmsContentPo();
		weiXinCmsContentPo.setWcmscid(weiXinDataConfigPo.getWdcregistagreement());

		request.setAttribute("input1", Utility.getName(request.getParameter("input1")));
		request.setAttribute("checkCode", Utility.getName(request.getParameter("checkCode")));
		request.setAttribute("memberPhone", Utility.getName(request.getParameter("memberPhone")));
		request.setAttribute("tjrPhone", Utility.getName(request.getParameter("tjrPhone")));
		
		weiXinCmsContentPo = weiXinCmsContentMgr.selectWeiXinCmsContentPo(weiXinCmsContentPo);
		request.setAttribute("weiXinCmsContentPo", weiXinCmsContentPo);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化会员详细信息
	 */
	public String initWeiXinMemberInfoDetail() {
		
		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if(openID.equals("")){
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);
		
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);	
		
		if(customerInfoPo==null || Utility.getName(customerInfoPo.getSmecicustomerid()).equals("")){					
			return "weiXinMemberBindSel";
		}
		// openID判断	
		
		// 计算年龄
		if (!Utility.getName(customerInfoPo.getSmecicustomerid()).equals("")){
			if (Utility.getName(customerInfoPo.getSmecibirthday()).length() >= 4){
				String birthdayYear = Utility.getName(customerInfoPo.getSmecibirthday()).substring(0,4);
				int age = Calendar.getInstance().get(Calendar.YEAR)- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmage(Integer.toString(age));
			}else{
				customerInfoPo.setFmmage("");
			}
		}
		WeiXinDataConfigPo weiXinDataConfigPo =  weiXinDataConfigMgr.getWeiXinDataConfigPo();
		WeiXinCmsContentPo weiXinCmsContentPo = new WeiXinCmsContentPo();
		weiXinCmsContentPo.setWcmscid(weiXinDataConfigPo.getWdcregistagreement());
		
		request.setAttribute("lxhxID", weiXinDataConfigPo.getWdclxhx());
		request.setAttribute("customerInfoPo", customerInfoPo);
		
		return SUCCESS;
	}
	
	/**
	 * 发送验证短信
	 */
	public void sendMsgAjax() {
		String phone = Utility.getName(request.getParameter("phone"));
		String code = Utility.getName(request.getParameter("code"));

		SendNotePo snpo = new SendNotePo();
		snpo.setSncustomertelphone(phone);
		snpo.setSnnotecontent("验证码："+code);
		snpo.setSnpersonid("");
		snpo.setSnnotetypeid("16");
		snpo.setSnsenddate("");
		snpo.setSnpersonid("");
		sendNoteMgr.sendNote(snpo);
	}
	
	/**
	 * 会员绑定
	 */
	public String insertWeiXinMemberBindInfo() {
		
		String openID = Utility.getName(request.getParameter("openID"));		
		String memberPhone = Utility.getName(request.getParameter("memberPhone"));
		String toUserName = Utility.getName(request.getParameter("toUserName"));
		String tjrPhone = Utility.getName(request.getParameter("tjrPhone"));
		if(toUserName.equals("")){
			return "weixinSessionOut";
		}
		
		request.setAttribute("openID",openID);
		
		systemParameterPo = systemParameterMgr.getSystemParameterPo();
		
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo.setSmeciphone(memberPhone);
		customerInfoPo.setSmecitjrphone(tjrPhone);
		customerInfoPo.setSmecizone(systemParameterPo.getFspcustomeraddress());
		
		//根据微信公众号原始ID判断注册到哪个部门
		WeiXinRegisterDepartmentPo weiXinRegisterDepartmentPo = new WeiXinRegisterDepartmentPo();
		weiXinRegisterDepartmentPo.setWrdaccount(toUserName);
		weiXinRegisterDepartmentPo = weiXinRegisterDepartmentMgr.getWeiXinRegisterDepartmentPo(weiXinRegisterDepartmentPo);
		customerInfoPo.setSmecishopcode(Utility.getName(weiXinRegisterDepartmentPo.getWrddepartmentid()));
		//根据微信公众号原始ID判断注册到哪个部门
		
		if (!memberPhone.trim().equals("")){
			int count = configurationMgr.getCustomerCountByPhone(customerInfoPo);
			if (count == 0){
				configurationMgr.insertCustomerOpenID(customerInfoPo);
			}else{
				customerInfoPo.setSmeciflag("1");
				count = configurationMgr.getCustomerCountByPhone(customerInfoPo);
				if (count > 0){
					configurationMgr.updateCustomerOpenID(customerInfoPo);
				}				
			}	
		}
		
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);		
		
		// 计算年龄
		if (!Utility.getName(customerInfoPo.getSmecicustomerid()).equals("")){
			if (Utility.getName(customerInfoPo.getSmecibirthday()).length() >= 4){
				String birthdayYear = Utility.getName(customerInfoPo.getSmecibirthday()).substring(0,4);
				int age = Calendar.getInstance().get(Calendar.YEAR)- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmage(Integer.toString(age));
			}else{
				customerInfoPo.setFmmage("");
			}
		}else{
			this.clearMessages(); 
			String url = "''initWeiXinMemberBindSel.action?openID={0}''";
			List<String> params = new ArrayList<String>();	
			params.add(openID);
			
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.MOVE);
			
			return ERROR;
		}
		
		WeiXinDataConfigPo weiXinDataConfigPo = weiXinDataConfigMgr.getWeiXinDataConfigPo();
		request.setAttribute("weiXinDataConfigPo", weiXinDataConfigPo);
		
		request.getSession().setAttribute("sessionPersonCenterCustomerID", customerInfoPo.getSmecicustomerid());
		request.getSession().setAttribute("openID", openID);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化修改会员信息
	 */
	public String initWeiXinMemberBindInfoUpdate() {
		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if(openID.equals("")){
//			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);
		
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);	
		
		if(customerInfoPo==null || Utility.getName(customerInfoPo.getSmecicustomerid()).equals("")){					
//			return "weiXinMemberBindSel";
		}
		// openID判断			
		
		// 计算年龄
		if (!Utility.getName(customerInfoPo.getSmecicustomerid()).equals("")){
			if (Utility.getName(customerInfoPo.getSmecibirthday()).length() >= 4){
				String birthdayYear = Utility.getName(customerInfoPo.getSmecibirthday()).substring(0,4);
				int age = Calendar.getInstance().get(Calendar.YEAR)- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmage(Integer.toString(age));
			}else{
				customerInfoPo.setFmmage("");
			}
						
			//年龄下拉列表
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			int endy = Integer.parseInt(sdf.format(new Date()));
			int beginy = endy-100;
				
			request.setAttribute("endy", endy);
			request.setAttribute("beginy", beginy);
			
			//生日下拉列表
			String birthday=Utility.getName(customerInfoPo.getSmecibirthday());
			
			if (birthday.length() >= 4){
				String year = birthday.substring(0 , 4);
				String month = birthday.substring(5 , 7);
				String day = birthday.substring(8 , 10);
				
				if(Integer.valueOf(Utility.getName(day)) < 10){
					day = day.substring(1);
				}
				
				request.setAttribute("year", year);
				request.setAttribute("month", month.startsWith("0") ? month.substring(1) : month);
				request.setAttribute("day", day.startsWith("0") ? day.substring(1) : day);
//				request.setAttribute("zones", customerInfoPo.getSmecizone().replaceAll(" ", "").split(","));
			}
		}
		
		request.setAttribute("customerInfoPo", customerInfoPo);
		return SUCCESS;
	}
	
	/**
	 * 修改会员绑定信息
	 */
	public String updateWeiXinMemberBindInfo() {	
		
		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if(openID.equals("")){
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);
		
		CustomerInfoPo tmpcustomerInfoPo = new CustomerInfoPo();
		tmpcustomerInfoPo.setOpenid(openID);
		tmpcustomerInfoPo = configurationMgr.getCustomerInfoByOpenID(tmpcustomerInfoPo);	
		
		if(tmpcustomerInfoPo==null || Utility.getName(tmpcustomerInfoPo.getSmecicustomerid()).equals("")){					
			return "weiXinMemberBindSel";
		}
		// openID判断
		
		String year = Utility.getName(request.getParameter("birthYear"));
		String month = Utility.getName(request.getParameter("birthMonth"));
		String day = Utility.getName(request.getParameter("birthday"));	

		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("day", day);
		
		if (month.length() == 1){
			month = "0" + month;
		}
		if (day.length() == 1){
			day = "0" + day;
		}
		
		String birthday = year + "-" + month + "-" + day;
		customerInfoPo.setOpenid(openID);
//		customerInfoPo.setSmecisex(Utility.getName(request.getParameter("sex")));		
		customerInfoPo.setSmecibirthday(birthday);
		
		configurationMgr.updateCustomerInfoByOpenID(customerInfoPo);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);
		
		// 计算年龄
		if (!Utility.getName(customerInfoPo.getSmecicustomerid()).equals("")){
			if (Utility.getName(customerInfoPo.getSmecibirthday()).length() >= 4){
				String birthdayYear = Utility.getName(customerInfoPo.getSmecibirthday()).substring(0,4);
				int age = Calendar.getInstance().get(Calendar.YEAR)- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmage(Integer.toString(age));
			}else{
				customerInfoPo.setFmmage("");
			}
		}
		
		return SUCCESS;
	}
	
	/**
	 * 解绑手机号
	 */
	public String updateClearOpenId() {	
		
		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if(openID.equals("")){
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);
		
		CustomerInfoPo tmpcustomerInfoPo = new CustomerInfoPo();
		tmpcustomerInfoPo.setOpenid(openID);
		tmpcustomerInfoPo = configurationMgr.getCustomerInfoByOpenID(tmpcustomerInfoPo);	
		
		if(tmpcustomerInfoPo==null || Utility.getName(tmpcustomerInfoPo.getSmecicustomerid()).equals("")){					
			return "weiXinMemberBindSel";
		}
		// openID判断
		
		configurationMgr.updateClearOpenId(tmpcustomerInfoPo.getSmecicustomerid());
		
		this.clearMessages(); 
		String url = "''initWeiXinMemberBindSel.action?openID={0}&toUserName={1}''";
		List<String> params = new ArrayList<String>();	
		params.add(openID);
		params.add(session.get("toUserName").toString());
		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化积分查询
	 */
	public String initWeiXinMemberIntegralSel() {
		
		String openID = Utility.getName(request.getParameter("openID"));
		request.setAttribute("openID",openID);
		
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);
		
		int count = configurationMgr.getIntegralExchangeCountByCustomer(customerInfoPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null){
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = 20;
				}
			} else {
				perPage = 20;
			}
			Pagination page = new Pagination(request, count, perPage);
			weiXinIntegralSelectList = configurationMgr.getIntegralExchangeListByCustomer(customerInfoPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{			
			weiXinIntegralSelectList = null;		
		}
		
		CompanyNamePo po = new CompanyNamePo();
		companyNamePo = loginDao.getCompanyInfo(po);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化配镜单查询
	 */
	public String initWeiXinSalesBillSel() {
		
		String openID = Utility.getName(request.getParameter("openID"));
		request.setAttribute("openID",openID);
		
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);
		
		salesBasicList = configurationMgr.getSalesBillInfoByCustomer(customerInfoPo);
		
		SalesBasicPo salesBasicPo = null;
		if(salesBasicList.size() > 0) {
			salesBasicPo = salesBasicList.get(0);
		}
		request.setAttribute("salesBasicPo",salesBasicPo);
		
		CompanyNamePo po = new CompanyNamePo();
		companyNamePo = loginDao.getCompanyInfo(po);
		
		return SUCCESS;
	}
	
	/**
	 * 配镜单明细查看
	 */
	public String initWeiXinSalesBillDetailSel() {
		
		String openID = Utility.getName(request.getParameter("openID"));
		request.setAttribute("openID",openID);
		
		String salesBillID = Utility.getName(request.getParameter("salesBillID"));
		request.setAttribute("salesBillID",salesBillID);
		
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo.setFmmsalesid(salesBillID);
		
		salesBasicPo = configurationMgr.getSalesBillByCustomer(customerInfoPo);
		salesDetailList = configurationMgr.getSalesBillDetailByCustomer(customerInfoPo);
			
		int inTransit = 0;
		systemParameterPo = systemParameterMgr.getSystemParameterPo();
		
		switch(Integer.valueOf(Utility.getName(salesBasicPo.getSsesbintransit()))){
			case 1:
//				salesBasicPo.setSsesbintransit2("当前状态为销售完成,将要进行银台结款操作。");
				salesBasicPo.setSsesbintransit2("您的配镜单已经创建成功,请至银台缴费");
				break;
			case 2:				
				inTransit = windowsMgr.isEnabledInTransit("3");				
				if (inTransit > 0){					
					if (Utility.getName(salesBasicPo.getSsesborderstype()).equals("3") || Utility.getName(salesBasicPo.getSsesborderstype()).equals("5")){						
						if (Utility.getName(systemParameterPo.getFspsalesintransit()).equals("1")){
//							salesBasicPo.setSsesbintransit2("当前状态为银台结款,将要进行取镜处收货操作。");
//							salesBasicPo.setSsesbintransit2("银台已结款,商品已经取走");
							salesBasicPo.setSsesbintransit2("您订购的商品已经取走。");
							
						}else{
//							salesBasicPo.setSsesbintransit2("当前状态为银台结款,将要进行顾客取镜操作。");
//							salesBasicPo.setSsesbintransit2("银台已结款,请至取镜处取商品");
							salesBasicPo.setSsesbintransit2("您的配镜单已经缴费成功,请至取镜处取商品。");
						}
					}else{
//						salesBasicPo.setSsesbintransit2("当前状态为银台结款,将要进行门店配送操作。");
//						salesBasicPo.setSsesbintransit2("银台已结款,门店将下单备货");
						salesBasicPo.setSsesbintransit2("您的配镜单已经缴费成功,门店将下单备货。");
					}
				}else{
					if (Utility.getName(salesBasicPo.getSsesborderstype()).equals("2") || Utility.getName(salesBasicPo.getSsesborderstype()).equals("4")){
//						salesBasicPo.setSsesbintransit2("当前状态为银台结款,将要进行委外订单操作。");
//						salesBasicPo.setSsesbintransit2("银台已结款,门店将下单备货");
						salesBasicPo.setSsesbintransit2("您的配镜单已经缴费成功,门店将下单备货。");
					}else if (Utility.getName(salesBasicPo.getSsesborderstype()).equals("3") || Utility.getName(salesBasicPo.getSsesborderstype()).equals("5")){
						if (Utility.getName(systemParameterPo.getFspsalesintransit()).equals("1")){
//							salesBasicPo.setSsesbintransit2("当前状态为银台结款,将要进行取镜处收货操作。");
//							salesBasicPo.setSsesbintransit2("银台已结款,商品已经取走");
							salesBasicPo.setSsesbintransit2("您订购的商品已经取走。");
							
						}else{
//							salesBasicPo.setSsesbintransit2("当前状态为银台结款,将要进行顾客取镜操作。");
//							salesBasicPo.setSsesbintransit2("银台已结款,请至取镜处取商品。");
							salesBasicPo.setSsesbintransit2("您的配镜单已经缴费成功,请至取镜处取商品。");
						}
					}else{
//						salesBasicPo.setSsesbintransit2("当前状态为银台结款,将要进行镜片发料操作。");
//						salesBasicPo.setSsesbintransit2("银台已结款,门店将下单备货");
						salesBasicPo.setSsesbintransit2("您的配镜单已经缴费成功,门店将下单备货。");
					}
				}
				
				break;
			case 3:
				if (Utility.getName(salesBasicPo.getSsesborderstype()).equals("2") || Utility.getName(salesBasicPo.getSsesborderstype()).equals("4")){
//					salesBasicPo.setSsesbintransit2("当前状态为门店配送,将要进行委外订单操作。");
//					salesBasicPo.setSsesbintransit2("门店配送,商品即将备货");
					salesBasicPo.setSsesbintransit2("您订购的商品即将备货。");
				}else{
//					salesBasicPo.setSsesbintransit2("当前状态为门店配送,将要进行镜片发料操作。");
//					salesBasicPo.setSsesbintransit2("门店配送,商品即将备货");
					salesBasicPo.setSsesbintransit2("您订购的商品即将备货。");
				}
				
				break;
			case 4:
//				salesBasicPo.setSsesbintransit2("当前状态为委外订单,将要进行委外收货操作。");
//				salesBasicPo.setSsesbintransit2("您订购的商品正在备货,委外收货");
				salesBasicPo.setSsesbintransit2("您订购的商品正在备货。");
				break;
			case 5:
				if (Utility.getName(salesBasicPo.getSsesborderstype()).equals("2")){
//					salesBasicPo.setSsesbintransit2("当前状态为委外收货,将要进行镜片发料操作。");
//					salesBasicPo.setSsesbintransit2("您订购的商品已经到货,商品检验");
					salesBasicPo.setSsesbintransit2("您订购的商品已经到货,即将进行检验。");
				}else{
//					salesBasicPo.setSsesbintransit2("当前状态为委外收货,将要进行隐形配送操作。");
//					salesBasicPo.setSsesbintransit2("您订购的商品已经到货，送至取镜门店");
					salesBasicPo.setSsesbintransit2("您订购的商品已经到货,即将送至取镜门店。");
				}
				
				break;
			case 6:				
				inTransit = windowsMgr.isEnabledInTransit("7");
				if (inTransit > 0){
//					salesBasicPo.setSsesbintransit2("当前状态为镜片发料,将要进行加工初检操作。");
//					salesBasicPo.setSsesbintransit2("您订购的商品即将开始加工,加工初检");
					salesBasicPo.setSsesbintransit2("您订购的商品即将开始加工。");
					break;
				}
				
				inTransit = windowsMgr.isEnabledInTransit("8");
				if (inTransit > 0){
//					salesBasicPo.setSsesbintransit2("当前状态为镜片发料,将要进行加工师加工操作。");
//					salesBasicPo.setSsesbintransit2("您订购的商品即将开始加工,加工师加工");
					salesBasicPo.setSsesbintransit2("您订购的商品即将开始加工。");
					break;
				}
				
				inTransit = windowsMgr.isEnabledInTransit("9");
				if (inTransit > 0){
//					salesBasicPo.setSsesbintransit2("当前状态为镜片发料,将要进行加工检验操作。");
//					salesBasicPo.setSsesbintransit2("您订购的商品已经加工完成,加工检验");
					salesBasicPo.setSsesbintransit2("您订购的商品已经加工完成,即将检验。");
					break;
				}
				
				inTransit = windowsMgr.isEnabledInTransit("10");
				if (inTransit > 0){
//					salesBasicPo.setSsesbintransit2("当前状态为镜片发料,将要进行加工配送操作。");
//					salesBasicPo.setSsesbintransit2("您订购的商品已经检验完成,加工配送");
					salesBasicPo.setSsesbintransit2("您订购的商品已经检验完成,即将送至取镜门店。");
					break;
				}
				
				inTransit = windowsMgr.isEnabledInTransit("12");
				if (inTransit > 0){
//					salesBasicPo.setSsesbintransit2("当前状态为镜片发料,将要进行取镜处收货操作。");
//					salesBasicPo.setSsesbintransit2("您订购的商品正送至取镜门店,请至取镜处收货");
					salesBasicPo.setSsesbintransit2("您订购的商品正送至取镜门店。");
					break;
				}
				
			case 7:
				inTransit = windowsMgr.isEnabledInTransit("8");
				if (inTransit > 0){
//					salesBasicPo.setSsesbintransit2("当前状态为加工初检,将要进行加工师加工操作。");
//					salesBasicPo.setSsesbintransit2("您订购的商品即将开始加工,加工师加工");
					salesBasicPo.setSsesbintransit2("您订购的商品即将开始加工。");
					break;
				}
				
				inTransit = windowsMgr.isEnabledInTransit("9");
				if (inTransit > 0){
//					salesBasicPo.setSsesbintransit2("当前状态为加工初检,将要进行加工检验操作。");
//					salesBasicPo.setSsesbintransit2("您订购的商品已经加工完成,加工检验");
					salesBasicPo.setSsesbintransit2("您订购的商品已经加工完成,即将检验。");
					break;
				}
				
				inTransit = windowsMgr.isEnabledInTransit("10");
				if (inTransit > 0){
//					salesBasicPo.setSsesbintransit2("当前状态为加工初检,将要进行加工配送操作。");
//					salesBasicPo.setSsesbintransit2("您订购的商品已经检验完成,即将送至取镜门店");
					salesBasicPo.setSsesbintransit2("您订购的商品已经检验完成,即将送至取镜门店。");
					break;
				}
				
				inTransit = windowsMgr.isEnabledInTransit("12");
				if (inTransit > 0){
//					salesBasicPo.setSsesbintransit2("当前状态为加工初检,将要进行取镜处收货操作。");
//					salesBasicPo.setSsesbintransit2("您订购的商品正送至取镜门店,取镜处收货");
					salesBasicPo.setSsesbintransit2("您订购的商品正送至取镜门店。");
					break;
				}

			case 8:
				
				inTransit = windowsMgr.isEnabledInTransit("9");
				if (inTransit > 0){
//					salesBasicPo.setSsesbintransit2("当前状态为加工师加工,将要进行加工检验操作。");
//					salesBasicPo.setSsesbintransit2("您订购的商品已经加工完成,加工检验");
					salesBasicPo.setSsesbintransit2("您订购的商品已经加工完成,即将检验。");
					break;
				}
				
				inTransit = windowsMgr.isEnabledInTransit("10");
				if (inTransit > 0){
//					salesBasicPo.setSsesbintransit2("当前状态为加工师加工,将要进行加工配送操作。");
//					salesBasicPo.setSsesbintransit2("您订购的商品已经检验完成,即将送至取镜门店");
					salesBasicPo.setSsesbintransit2("您订购的商品已经检验完成,即将送至取镜门店。");
					break;
				}
				
				inTransit = windowsMgr.isEnabledInTransit("12");
				if (inTransit > 0){
//					salesBasicPo.setSsesbintransit2("当前状态为加工师加工,将要进行取镜处收货操作。");
//					salesBasicPo.setSsesbintransit2("您订购的商品正送至取镜门店,取镜处收货");
					salesBasicPo.setSsesbintransit2("您订购的商品正送至取镜门店。");
					break;
				}

			case 9:
				inTransit = windowsMgr.isEnabledInTransit("10");
				if (inTransit > 0){
//					salesBasicPo.setSsesbintransit2("当前状态为加工检验,将要进行加工配送操作。");
//					salesBasicPo.setSsesbintransit2("您订购的商品已经加工完成,即将送至取镜门店");
					salesBasicPo.setSsesbintransit2("您订购的商品已经加工完成,即将送至取镜门店。");
					break;
				}
				
				inTransit = windowsMgr.isEnabledInTransit("12");
				if (inTransit > 0){
//					salesBasicPo.setSsesbintransit2("当前状态为加工检验,将要进行取镜处收货操作。");
//					salesBasicPo.setSsesbintransit2("您订购的商品正送至取镜门店,取镜处收货");
					salesBasicPo.setSsesbintransit2("您订购的商品正送至取镜门店。");
					break;
				}

			case 10:
//				salesBasicPo.setSsesbintransit2("当前状态为加工配送,将要进行取镜处收货操作。");
//				salesBasicPo.setSsesbintransit2("您订购的商品正送至取镜门店,取镜处收货");
				salesBasicPo.setSsesbintransit2("您订购的商品正送至取镜门店。");
				break;
			case 11:
//				salesBasicPo.setSsesbintransit2("当前状态为隐形配送,将要进行取镜处收货操作。");
//				salesBasicPo.setSsesbintransit2("您订购的商品正送至取镜门店,取镜处收货");
				salesBasicPo.setSsesbintransit2("您订购的商品正送至取镜门店。");
				break;
			case 12:
//				salesBasicPo.setSsesbintransit2("当前状态为取镜处收货,将要进行顾客取镜操作。");
//				salesBasicPo.setSsesbintransit2("您订购的商品已至取镜门店,请取镜");
				salesBasicPo.setSsesbintransit2("您订购的商品已至取镜门店,请取镜。");
				break;
			case 13:
//				salesBasicPo.setSsesbintransit2("当前状态为顾客取镜。");
//				salesBasicPo.setSsesbintransit2("您订购的商品已经取镜,");
				salesBasicPo.setSsesbintransit2("您订购的商品已经取镜。");
				break;
			case 14:
//				salesBasicPo.setSsesbintransit2("当前状态为顾客退货。");
//				salesBasicPo.setSsesbintransit2("您订购的商品已经退款,");
				salesBasicPo.setSsesbintransit2("您订购的商品已经退款。");
				break;
			default:
				salesBasicPo.setSsesbintransit2(",");
		}
		
		CompanyNamePo po = new CompanyNamePo();
		companyNamePo = loginDao.getCompanyInfo(po);
		
		return SUCCESS;
	}

	/**
	 * 初始化积分查询
	 */
	public String initWeiXinMemberIntegralSelLog() {
		String openID = Utility.getName(request.getParameter("openID"));
		request.setAttribute("openID",openID);
		String dontshow = "1";
		request.setAttribute("dontshow", dontshow);
		
		weiXinIntegralSelectPo=new WeiXinIntegralSelectPo();
		weiXinIntegralSelectPo.setWieopenid(openID);
		weiXinIntegralSelectPo=guitarManagementMgr.getWeiXinIntegralSelect(weiXinIntegralSelectPo).get(0);
		
		systemParameterPo = systemParameterMgr.getSystemParameterPo();
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());		
		
		//获取品种总数
		int count = venditionInformationMgr.getIntegralExpenseCount(weiXinIntegralSelectPo.getWiecustomerid());
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
			salesBasicList = venditionInformationMgr.getIntegralExpenseList(weiXinIntegralSelectPo.getWiecustomerid(), page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			salesBasicList = null;
		}
		return SUCCESS;
	}
	public ConfigurationMgr getConfigurationMgr() {
		return configurationMgr;
	}
	public void setConfigurationMgr(ConfigurationMgr configurationMgr) {
		this.configurationMgr = configurationMgr;
	}
	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}
	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelectList() {
		return weiXinIntegralSelectList;
	}
	public void setWeiXinIntegralSelectList(
			List<WeiXinIntegralSelectPo> weiXinIntegralSelectList) {
		this.weiXinIntegralSelectList = weiXinIntegralSelectList;
	}

	public List<SalesBasicPo> getSalesBasicList() {
		return salesBasicList;
	}

	public void setSalesBasicList(List<SalesBasicPo> salesBasicList) {
		this.salesBasicList = salesBasicList;
	}

	public List<SalesDetailPo> getSalesDetailList() {
		return salesDetailList;
	}

	public void setSalesDetailList(List<SalesDetailPo> salesDetailList) {
		this.salesDetailList = salesDetailList;
	}

	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}

	public WindowsMgr getWindowsMgr() {
		return windowsMgr;
	}

	public void setWindowsMgr(WindowsMgr windowsMgr) {
		this.windowsMgr = windowsMgr;
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

	public CompanyNamePo getCompanyNamePo() {
		return companyNamePo;
	}

	public void setCompanyNamePo(CompanyNamePo companyNamePo) {
		this.companyNamePo = companyNamePo;
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
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

	public SendNoteMgr getSendNoteMgr() {
		return sendNoteMgr;
	}

	public void setSendNoteMgr(SendNoteMgr sendNoteMgr) {
		this.sendNoteMgr = sendNoteMgr;
	}

	public WeiXinAutoReplyMgr getWeiXinAutoReplyMgr() {
		return weiXinAutoReplyMgr;
	}

	public void setWeiXinAutoReplyMgr(WeiXinAutoReplyMgr weiXinAutoReplyMgr) {
		this.weiXinAutoReplyMgr = weiXinAutoReplyMgr;
	}
	
	
	
}
