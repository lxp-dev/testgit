package com.pengsheng.weixin.action;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SendNoteMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;
import com.pengsheng.weixin.mgr.ConfigurationMgr;
import com.pengsheng.weixin.mgr.WeiXinCmsContentMgr;
import com.pengsheng.weixin.mgr.WeiXinDataConfigMgr;
import com.pengsheng.weixin.mgr.WeiXinInviteFriendMgr;
import com.pengsheng.weixin.persistence.WeiXinCmsContentPo;
import com.pengsheng.weixin.persistence.WeiXinDataConfigPo;
import com.pengsheng.weixin.persistence.WeiXinRegisterDepartmentPo;
import com.pengsheng.weixin.persistence.WeixinInviteFriendLogPo;

public class WeiXinInviteFriendAction extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterPo systemParameterPo;
	private SystemParameterMgr systemParameterMgr; 
	private String isFirstExec;
	
	private ConfigurationMgr configurationMgr;
	private WeixinInviteFriendLogPo weixinInviteFriendLogPo;
	private List<WeixinInviteFriendLogPo> weixinInviteFriendLogList;
	private WeiXinDataConfigMgr weiXinDataConfigMgr;
	private WeiXinCmsContentMgr weiXinCmsContentMgr;
	private SendNoteMgr sendNoteMgr;	
	private WeiXinInviteFriendMgr weiXinInviteFriendMgr;
	
	/**
	 * 初始化邀请好友查询
	 */
	public String initWeiXinInviteFriendSelect() throws Exception {
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

		systemParameterPo = systemParameterMgr.getSystemParameterPo();		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "formingSel";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 查询邀请好友
	 */
	public String selectWeiXinInviteFriend() throws Exception {
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
		systemParameterPo = systemParameterMgr.getSystemParameterPo();
		
		// 得到查询条件
		String page_wifltouserphone = Utility.getName(request.getParameter("page_wifltouserphone"));
		String page_wifltousername = Utility.getName(request.getParameter("page_wifltousername"));
		request.setAttribute("page_wifltouserphone", page_wifltouserphone);
		request.setAttribute("page_wifltousername", page_wifltousername);
		
		WeixinInviteFriendLogPo po = new WeixinInviteFriendLogPo();
		po.setWifltouserphone(page_wifltouserphone);
		po.setWifltousername(page_wifltousername);
		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1")){
			this.setIsFirstExec("0");
			request.setAttribute("showhider", (Utility.getName(systemParameterPo.getFspshowchange()).equals("3") ? "0" : "2"));
		}else{	
			String showchange = Utility.getName(systemParameterPo.getFspselectovershowchange());
			if (showchange.equals("0")){
				request.setAttribute("showhider","0");
			}else{
				request.setAttribute("showhider", "2");
			}
		}

		// 查询分页
		int count = weiXinInviteFriendMgr.selectWeiXinInviteFriendLogCount(po);
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
			weixinInviteFriendLogList = weiXinInviteFriendMgr.selectWeiXinInviteFriendLogList(po, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			weixinInviteFriendLogList = null;
		}

		return SUCCESS;
	}
	
	/**
	 * 初始化邀请好友
	 */
	public String initWeiXinInviteFriend() throws Exception {
		
		String openID = Utility.getName(request.getParameter("openID"));
		request.setAttribute("openID", openID);
		
		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);	
		
		if(customerInfoPo==null || Utility.getName(customerInfoPo.getSmecicustomerid()).equals("")){					
			return "weiXinMemberBindSel";
		}
		

		request.setAttribute("customerInfoPo", customerInfoPo);
		return SUCCESS;
	}

	/**
	 * 初始化邀请好友确认
	 */
	public String initWeiXinInviteFriendConfirm() throws Exception {
		
		String openID = Utility.getName(request.getParameter("openID"));
		request.setAttribute("openID", openID);
		
		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);	
		
		if(customerInfoPo==null || Utility.getName(customerInfoPo.getSmecicustomerid()).equals("")){					
			return "weiXinMemberBindSel";
		}
		
		WeiXinDataConfigPo weiXinDataConfigPo =  weiXinDataConfigMgr.getWeiXinDataConfigPo();
		WeiXinCmsContentPo weiXinCmsContentPo = new WeiXinCmsContentPo();
		weiXinCmsContentPo.setWcmscid(weiXinDataConfigPo.getWdcyqhy());
		
		weiXinCmsContentPo = weiXinCmsContentMgr.selectWeiXinCmsContentPo(weiXinCmsContentPo);
		
		request.setAttribute("yqhytitle", Utility.getName(weiXinCmsContentPo.getWcmsccontent()));
		return SUCCESS;
	}

	/**
	 * 初始化邀请好友发送短信页
	 */
	public String initWeiXinInviteFriendSend() throws Exception {
		
		String openID = Utility.getName(request.getParameter("openID"));
		request.setAttribute("openID", openID);
		
		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);	
		
		if(customerInfoPo==null || Utility.getName(customerInfoPo.getSmecicustomerid()).equals("")){					
			return "weiXinMemberBindSel";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 邀请好友发送短信
	 */
	public String sendWeiXinInviteFriend() throws Exception {
		
		String openID = Utility.getName(request.getParameter("openID"));
		request.setAttribute("openID", openID);
		
		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);	
		
		if(customerInfoPo==null || Utility.getName(customerInfoPo.getSmecicustomerid()).equals("")){		
			WeiXinDataConfigPo weiXinDataConfigPo = weiXinDataConfigMgr.getWeiXinDataConfigPo();
			request.setAttribute("weiXinDataConfigPo", weiXinDataConfigPo);
			
			return "weiXinMemberBindSel";
		}
		
		if(customerInfoPo.getSmeciconsumptionprice().equals("0.00")){
			WeiXinDataConfigPo weiXinDataConfigPo = weiXinDataConfigMgr.getWeiXinDataConfigPo();
			request.setAttribute("weiXinDataConfigPo", weiXinDataConfigPo);
			
			request.setAttribute("errorFlag", "1");
			return ERROR;
		}
		
		CustomerInfoPo customerInfoPo1 = new CustomerInfoPo();
		customerInfoPo1.setSmeciphone(weixinInviteFriendLogPo.getWifltouserphone());
		customerInfoPo1 = configurationMgr.getCustomerInfoByOpenID(customerInfoPo1);	
		if(customerInfoPo1!=null && !Utility.getName(customerInfoPo1.getSmecicustomerid()).equals("") && !Utility.getName(customerInfoPo1.getSmeciconsumptionprice()).equals("0.00")){
			WeiXinDataConfigPo weiXinDataConfigPo = weiXinDataConfigMgr.getWeiXinDataConfigPo();
			request.setAttribute("weiXinDataConfigPo", weiXinDataConfigPo);
			
			request.setAttribute("errorFlag", "2");
			return ERROR;
		}
			
		weixinInviteFriendLogPo.setWiflcustomerid(customerInfoPo.getSmecicustomerid());
		weixinInviteFriendLogPo.setWiflisconfirm("0");
		weiXinInviteFriendMgr.insertWeiXinInviteFriendLogPo(weixinInviteFriendLogPo);
		
		//发送短信
		String sendMsg = "亲爱的" + weixinInviteFriendLogPo.getWifltousername()+"：您的好友";
		
		if(!Utility.getName(customerInfoPo.getSmeciname()).equals("")){					
			sendMsg = sendMsg + customerInfoPo.getSmeciname();
			if(!Utility.getName(customerInfoPo.getSmeciphone()).equals("")){					
				sendMsg = sendMsg + "(手机号为：" + customerInfoPo.getSmeciphone() + ")";
			}
		}
		
		NoteTemplatePo noteTemplatePo = new NoteTemplatePo(); 
		noteTemplatePo.setBnttypeid("18");
		noteTemplatePo = sendNoteMgr.getSendNoteTemplate(noteTemplatePo);  // 查询当前模块的短信模板	
		
		sendMsg = sendMsg + noteTemplatePo.getBntcontent();
		SendNotePo snpo = new SendNotePo();
		snpo.setSncustomertelphone(weixinInviteFriendLogPo.getWifltouserphone());
		snpo.setSnnotecontent(sendMsg);
		snpo.setSnpersonid("");
		snpo.setSnnotetypeid("18");
		snpo.setSnsenddate("");
		snpo.setSnpersonid("");
		sendNoteMgr.sendNote(snpo);
		//发送短信
		
		this.clearMessages(); 
		String url = "''initSendWeiXinInviteFriendOK.action?openID={0}&byqrxm={1}&byqrdh={2}&yqrxm={3}&yqrdh={4}&yqrq={5}&toUserName={6}''";
		List<String> params = new ArrayList<String>();
		params.add(openID);
		params.add(weixinInviteFriendLogPo.getWifltousername());
		params.add(weixinInviteFriendLogPo.getWifltouserphone());
		params.add(customerInfoPo.getSmeciname());
		params.add(customerInfoPo.getSmeciphone());
		
		
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		params.add(df.format(date));
		params.add(request.getSession().getAttribute("toUserName").toString());
		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}
	
	/**
	 * 邀请好友发送短信成功
	 */
	public String initSendWeiXinInviteFriendOK() throws Exception {

		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		String byqrxm = Utility.getName(request.getParameter("byqrxm"));
		String byqrdh = Utility.getName(request.getParameter("byqrdh"));
		String yqrxm = Utility.getName(request.getParameter("yqrxm"));
		String yqrdh = Utility.getName(request.getParameter("yqrdh"));
		String yqrq = Utility.getName(request.getParameter("yqrq"));
		String toUserName = Utility.getName(request.getParameter("toUserName"));
		
		if (openID.equals("")) {
			return "weixinSessionOut";
		}

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
		
		WeiXinCmsContentPo weiXinCmsContentPo = new WeiXinCmsContentPo();
		weiXinCmsContentPo.setWcmscid(weiXinDataConfigPo.getWdcyqhysuccess());
		
		weiXinCmsContentPo = weiXinCmsContentMgr.selectWeiXinCmsContentPo(weiXinCmsContentPo);
		
		String yqhysuccessstr = weiXinCmsContentPo.getWcmsccontent();
		yqhysuccessstr = yqhysuccessstr.replace("[被邀请人姓名]", byqrxm);
		yqhysuccessstr = yqhysuccessstr.replace("[被邀请人电话]", byqrdh);
		yqhysuccessstr = yqhysuccessstr.replace("[邀请人姓名]", yqrxm);
		yqhysuccessstr = yqhysuccessstr.replace("[邀请人电话]", yqrdh);
		yqhysuccessstr = yqhysuccessstr.replace("[邀请日期]", yqrq);
		
		request.setAttribute("yqhysuccessstr", yqhysuccessstr);
		request.setAttribute("toUserName", toUserName);
		return SUCCESS;
	}
	
	
	public ConfigurationMgr getConfigurationMgr() {
		return configurationMgr;
	}

	public void setConfigurationMgr(ConfigurationMgr configurationMgr) {
		this.configurationMgr = configurationMgr;
	}

	public WeixinInviteFriendLogPo getWeixinInviteFriendLogPo() {
		return weixinInviteFriendLogPo;
	}

	public void setWeixinInviteFriendLogPo(
			WeixinInviteFriendLogPo weixinInviteFriendLogPo) {
		this.weixinInviteFriendLogPo = weixinInviteFriendLogPo;
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

	public SendNoteMgr getSendNoteMgr() {
		return sendNoteMgr;
	}

	public void setSendNoteMgr(SendNoteMgr sendNoteMgr) {
		this.sendNoteMgr = sendNoteMgr;
	}

	public WeiXinInviteFriendMgr getWeiXinInviteFriendMgr() {
		return weiXinInviteFriendMgr;
	}

	public void setWeiXinInviteFriendMgr(WeiXinInviteFriendMgr weiXinInviteFriendMgr) {
		this.weiXinInviteFriendMgr = weiXinInviteFriendMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public List<WeixinInviteFriendLogPo> getWeixinInviteFriendLogList() {
		return weixinInviteFriendLogList;
	}

	public void setWeixinInviteFriendLogList(
			List<WeixinInviteFriendLogPo> weixinInviteFriendLogList) {
		this.weixinInviteFriendLogList = weixinInviteFriendLogList;
	}
}
