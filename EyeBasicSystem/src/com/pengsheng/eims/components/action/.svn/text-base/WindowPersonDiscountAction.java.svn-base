package com.pengsheng.eims.components.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.VIPCardMgr;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.basic.persistence.VIPCardPo;
import com.pengsheng.eims.components.mgr.WindowPersonDiscountMgr;
import com.pengsheng.eims.frame.mgr.LoginMgr;
import com.pengsheng.eims.sales.mgr.SetMealMgr;
import com.pengsheng.eims.system.mgr.DiscountShortcutKeysMgr;
import com.pengsheng.eims.system.mgr.PersonDiscountMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.DiscountShortcutKeysPo;
import com.pengsheng.eims.system.persistence.MaxDiscountPo;
import com.pengsheng.eims.system.persistence.PersonDiscountDetailsPo;
import com.pengsheng.eims.system.persistence.PersonDiscountPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class WindowPersonDiscountAction extends BaseAction {
	
	private WindowPersonDiscountMgr windowPersonDiscountMgr;	
	private LoginMgr loginMgr;	
	private PersonInfoPo personInfoPo; 	
	private VIPCardMgr vipCardMgr;	
	private VIPCardPo vipCardPo;	
	private PersonPermissionMgr personPermissionMgr;	
	private DiscountShortcutKeysMgr discountShortcutKeysMgr;	
	private DiscountShortcutKeysPo discountShortcutKeysPo;	
	private SystemParameterPo systemParameterPo;	
	private SystemParameterMgr systemParameterMgr;	
	private SetMealMgr setMealMgr;	
	private List<MaxDiscountPo> maxDiscountPos;
	private List<PersonInfoPo> personInfoList;
	private List<RolePo> roleList;	
	private RolePo rolePo;
	private PersonDiscountMgr personDiscountMgr;
	
	public List<PersonInfoPo> getPersonInfoList() {
		return personInfoList;
	}

	public void setPersonInfoList(List<PersonInfoPo> personInfoList) {
		this.personInfoList = personInfoList;
	}

	public List<RolePo> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RolePo> roleList) {
		this.roleList = roleList;
	}

	public RolePo getRolePo() {
		return rolePo;
	}

	public void setRolePo(RolePo rolePo) {
		this.rolePo = rolePo;
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

	public DiscountShortcutKeysMgr getDiscountShortcutKeysMgr() {
		return discountShortcutKeysMgr;
	}

	public void setDiscountShortcutKeysMgr(
			DiscountShortcutKeysMgr discountShortcutKeysMgr) {
		this.discountShortcutKeysMgr = discountShortcutKeysMgr;
	}

	public DiscountShortcutKeysPo getDiscountShortcutKeysPo() {
		return discountShortcutKeysPo;
	}

	public void setDiscountShortcutKeysPo(
			DiscountShortcutKeysPo discountShortcutKeysPo) {
		this.discountShortcutKeysPo = discountShortcutKeysPo;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public VIPCardPo getVipCardPo() {
		return vipCardPo;
	}

	public void setVipCardPo(VIPCardPo vipCardPo) {
		this.vipCardPo = vipCardPo;
	}

	public VIPCardMgr getVipCardMgr() {
		return vipCardMgr;
	}

	public void setVipCardMgr(VIPCardMgr vipCardMgr) {
		this.vipCardMgr = vipCardMgr;
	}

	public PersonInfoPo getPersonInfoPo() {
		return personInfoPo;
	}

	public void setPersonInfoPo(PersonInfoPo personInfoPo) {
		this.personInfoPo = personInfoPo;
	}

	public LoginMgr getLoginMgr() {
		return loginMgr;
	}

	public void setLoginMgr(LoginMgr loginMgr) {
		this.loginMgr = loginMgr;
	}

	public WindowPersonDiscountMgr getWindowPersonDiscountMgr() {
		return windowPersonDiscountMgr;
	}

	public void setWindowPersonDiscountMgr(
			WindowPersonDiscountMgr windowPersonDiscountMgr) {
		this.windowPersonDiscountMgr = windowPersonDiscountMgr;
	}
	
	/**
	 * 初始化员工打折
	 * @return
	 */
	public String initPersonDiscountSelect(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String idorcard = Utility.getName(request.getParameter("idorcard"));
		String firstcheckstr = Utility.getName(request.getParameter("firstcheckstr"));
		request.setAttribute("idorcard", idorcard);
		request.setAttribute("firstcheckstr", firstcheckstr);
		request.setAttribute("arg0", Utility.getName(request.getParameter("arg0"))); //打折类型 1为单品
		request.setAttribute("rownumber", Utility.getName(request.getParameter("rownumber")));//打折行
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String[] systemdiscounttypes = systemParameterPo.getFspalldiscount().split(",");
		
		if(systemdiscounttypes == null){
			systemdiscounttypes = new String[3];
			systemdiscounttypes[0] = "";
			systemdiscounttypes[1] = "";
			systemdiscounttypes[2] = "";
		}else{
			for(int i=0; i<systemdiscounttypes.length; i++){
				if("1".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysvip", systemdiscounttypes[i].trim());
				}else if("2".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysdzm", systemdiscounttypes[i].trim());
				}else if("3".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysyg", systemdiscounttypes[i].trim());
				}
			}
		}
		request.setAttribute("selectC", "2");
		return SUCCESS;
	}
	
	/**
	 * 员工打折
	 * @return
	 */
	public String selectPersonDiscount(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		//验证打折人员
		String fpdpersonid=Utility.getName(request.getParameter("fpdpersonid"));
		String fpdpersonpassword=Utility.getName(request.getParameter("fpdpersonpassword"));
		String idorcard = Utility.getName(request.getParameter("idorcard"));
		String cardid = Utility.getName(request.getParameter("cardid"));
		String firstcheckstr = Utility.getName(request.getParameter("firstcheckstr"));
		
		request.setAttribute("firstcheckstr", firstcheckstr);
		request.setAttribute("idorcard", idorcard);
		request.setAttribute("cardid", cardid);
		request.setAttribute("fpdpersonid", fpdpersonid);
		request.setAttribute("fpdpersonpassword", fpdpersonpassword);
		request.setAttribute("arg0", Utility.getName(request.getParameter("arg0")));
		request.setAttribute("rownumber", Utility.getName(request.getParameter("rownumber")));
		
		personInfoPo=new PersonInfoPo();
		personInfoPo.setId(fpdpersonid);
		personInfoPo.setPassword(fpdpersonpassword);
		personInfoPo.setCardid(cardid);
		
		personInfoPo = loginMgr.getDiscountPerson(intoObject());
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		String[] systemdiscounttypes = systemParameterPo.getFspalldiscount().split(",");
		
		if(systemdiscounttypes == null){
			systemdiscounttypes = new String[3];
			systemdiscounttypes[0] = "";
			systemdiscounttypes[1] = "";
			systemdiscounttypes[2] = "";
		}else{
			for(int i=0; i<systemdiscounttypes.length; i++){
				if("1".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysvip", systemdiscounttypes[i].trim());
				}else if("2".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysdzm", systemdiscounttypes[i].trim());
				}else if("3".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysyg", systemdiscounttypes[i].trim());
				}
			}
		}
		
		if (personInfoPo.getId() != null) {
			if (personInfoPo.getUserState().matches("[0]")) { // 当前状态0:正常 1:删除
				if(systemParameterPo.getFspisusegoodslevel().equals("1")){
					personInfoPo.setGoodslevel(firstcheckstr);
					personInfoPo=windowPersonDiscountMgr.getDiscount(personInfoPo);
				}else{
					personInfoPo=windowPersonDiscountMgr.getDiscount(personInfoPo);
				}
				request.setAttribute("selectC", "1");
				return SUCCESS;
			} else {
				if(!"".equals(Utility.getName(cardid))){
					this.addActionMessage("此员工卡号不存在！");
				}else{
					this.addActionMessage(this.getText("person.not.error"));
				}
				request.setAttribute("selectC", "2");
				return ERROR;
			}
		} else {
			personInfoPo=null;
			
			if(!"".equals(Utility.getName(cardid))){
				this.addActionMessage("此员工卡号不存在！");
			}else{
				this.addActionMessage(this.getText("personid.password.error"));
			}
			request.setAttribute("selectC", "2");
			return ERROR;
		}
		
	}
	/**
	 * VIP打折
	 * @return
	 */
	public String initPersonDiscountCardSelect(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		request.setAttribute("arg0", Utility.getName(request.getParameter("arg0"))); //打折类型 1为单品
		request.setAttribute("rownumber", Utility.getName(request.getParameter("rownumber")));//打折行
		String firstcheckstr = Utility.getName(request.getParameter("firstcheckstr"));
		
		request.setAttribute("firstcheckstr", firstcheckstr);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String[] systemdiscounttypes = systemParameterPo.getFspalldiscount().split(",");
		
		if(systemdiscounttypes == null){
			systemdiscounttypes = new String[3];
			systemdiscounttypes[0] = "";
			systemdiscounttypes[1] = "";
			systemdiscounttypes[2] = "";
		}else{
			for(int i=0; i<systemdiscounttypes.length; i++){
				if("1".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysvip", systemdiscounttypes[i].trim());
				}else if("2".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysdzm", systemdiscounttypes[i].trim());
				}else if("3".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysyg", systemdiscounttypes[i].trim());
				}
			}
		}
		
		return SUCCESS;
	}
	
	/**
	 * VIP打折
	 * @return
	 */
	public String selectPersonDiscountCard(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		//验证打折人员
		String vipid=Utility.getName(request.getParameter("vipid"));
		String textpassword = Utility.getName(request.getParameter("textpassword"));
		String firstcheckstr = Utility.getName(request.getParameter("firstcheckstr"));
		
		request.setAttribute("firstcheckstr", firstcheckstr);
		
		VIPCardPo po = new VIPCardPo();
		
		po.setSsevcidt(vipid);
		request.setAttribute("vipid", vipid);
		request.setAttribute("textpassword", textpassword);
		
		
		
		if(systemParameterPo.getFspisusegoodslevel().equals("1")){
			po.setGoodslevel(firstcheckstr);
			vipCardPo = vipCardMgr.selectVIPCardPo(po);
		}else{
			vipCardPo = vipCardMgr.selectVIPCardPo(po);
		}
		
		request.setAttribute("arg0", Utility.getName(request.getParameter("arg0")));
		request.setAttribute("rownumber", Utility.getName(request.getParameter("rownumber")));
		
		String[] systemdiscounttypes = systemParameterPo.getFspalldiscount().split(",");
		
		if(systemdiscounttypes == null){
			systemdiscounttypes = new String[3];
			systemdiscounttypes[0] = "";
			systemdiscounttypes[1] = "";
			systemdiscounttypes[2] = "";
		}else{
			for(int i=0; i<systemdiscounttypes.length; i++){
				if("1".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysvip", systemdiscounttypes[i].trim());
				}else if("2".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysdzm", systemdiscounttypes[i].trim());
				}else if("3".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysyg", systemdiscounttypes[i].trim());
				}
			}
		}
		
		String[] goodsids = Utility.getName(request.getParameter("goodsids")).trim().split(",");
		MaxDiscountPo tjpoDiscountPo = new MaxDiscountPo();
		MaxDiscountPo poDiscountPo = new MaxDiscountPo();
		maxDiscountPos = new ArrayList<MaxDiscountPo>();
		if(!goodsids.equals("") && goodsids.length>0)
		{
			for(int i=0; i<goodsids.length; i++){
				tjpoDiscountPo.setFmdgoodsid(goodsids[i]);
				poDiscountPo = setMealMgr.selectMaxDiscountSetPo(tjpoDiscountPo);
				if("".equals(Utility.getName(poDiscountPo.getFmdmaxdiscount()))){
					tjpoDiscountPo = new MaxDiscountPo();
					tjpoDiscountPo.setFmdgoodscategoryid(goodsids[i].substring(0,1));
					tjpoDiscountPo.setFmdsupplierid(goodsids[i].substring(2,4));
					tjpoDiscountPo.setFmdbrandid(goodsids[i].substring(5,7));
					poDiscountPo = setMealMgr.selectMaxDiscountSetPo(tjpoDiscountPo);
				}
				if("".equals(Utility.getName(poDiscountPo.getFmdmaxdiscount()))){
					tjpoDiscountPo = new MaxDiscountPo();
					tjpoDiscountPo.setFmdgoodscategoryid(goodsids[i].substring(0,1));
					tjpoDiscountPo.setFmdsupplierid(goodsids[i].substring(2,4));
					poDiscountPo = setMealMgr.selectMaxDiscountSetPo(tjpoDiscountPo);
				}
				if("".equals(Utility.getName(poDiscountPo.getFmdmaxdiscount()))){
					tjpoDiscountPo = new MaxDiscountPo();
					tjpoDiscountPo.setFmdgoodscategoryid(goodsids[i].substring(0,1));
					poDiscountPo = setMealMgr.selectMaxDiscountSetPo(tjpoDiscountPo);
				}
				if("".equals(Utility.getName(poDiscountPo.getFmdmaxdiscount()))){
					poDiscountPo.setFmdgoodsid(goodsids[i]);
					poDiscountPo.setFmdmaxdiscount("n");
				}
				poDiscountPo.setFmdgoodsid(goodsids[i]);
				maxDiscountPos.add(poDiscountPo);
			}
		}
		
		if (!"".equals(Utility.getName(vipCardPo.getSsevcid()))) {
			return SUCCESS;
		} else {
			vipCardPo=null;
			this.addActionMessage("打折卡号不存在或已达使用次数上限或已过期！");
			return ERROR;
		}
		
	}
	
	/**
	 * 验证登录人
	 * @return
	 */
	public PersonInfoPo intoObject() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String fpdpersonid=Utility.getName(request.getParameter("fpdpersonid"));
		String fpdpersonpassword=Utility.getName(request.getParameter("fpdpersonpassword"));
		String cardid = Utility.getName(request.getParameter("cardid"));
		
		PersonInfoPo info = new PersonInfoPo();
		info.setId(fpdpersonid);
		info.setPassword(fpdpersonpassword);
		info.setCardid(cardid);
				
		return info;
	}
	

	/**
	 * 打折码
	 * @return
	 */
	public String initSelectDiscountCard(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		request.setAttribute("arg0", Utility.getName(request.getParameter("arg0"))); //打折类型 1为单品
		request.setAttribute("rownumber", Utility.getName(request.getParameter("rownumber")));//打折行
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String firstcheckstr = Utility.getName(request.getParameter("firstcheckstr"));
		
		request.setAttribute("firstcheckstr", firstcheckstr);
		
		String[] systemdiscounttypes = systemParameterPo.getFspalldiscount().split(",");
		
		if(systemdiscounttypes == null){
			systemdiscounttypes = new String[3];
			systemdiscounttypes[0] = "";
			systemdiscounttypes[1] = "";
			systemdiscounttypes[2] = "";
		}else{
			for(int i=0; i<systemdiscounttypes.length; i++){
				if("1".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysvip", systemdiscounttypes[i].trim());
				}else if("2".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysdzm", systemdiscounttypes[i].trim());
				}else if("3".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysyg", systemdiscounttypes[i].trim());
				}
			}
		}
		
		return SUCCESS;
	}
	
	/**
	 * 打折码
	 * @return
	 */
	public String selectDiscountCard(){
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		//验证打折人员
		String fdkdiscountcode=Utility.getName(request.getParameter("fdkdiscountcode"));
		String firstcheckstr=Utility.getName(request.getParameter("firstcheckstr"));
		
		DiscountShortcutKeysPo po = new DiscountShortcutKeysPo();
		
		po.setFdkdiscountcode(fdkdiscountcode);
		
		request.setAttribute("fdkdiscountcode", fdkdiscountcode);
		
		if(systemParameterPo.getFspisusegoodslevel().equals("1")){
			po.setFdkgoodslevel(firstcheckstr);
			discountShortcutKeysPo = discountShortcutKeysMgr.getDiscountShortcutKeysPo(po);
		}else{
			discountShortcutKeysPo = discountShortcutKeysMgr.getDiscountShortcutKeysPo(po);
		}
		
		request.setAttribute("arg0", Utility.getName(request.getParameter("arg0")));
		request.setAttribute("rownumber", Utility.getName(request.getParameter("rownumber")));
		
		String[] systemdiscounttypes = systemParameterPo.getFspalldiscount().split(",");
		
		if(systemdiscounttypes == null){
			systemdiscounttypes = new String[3];
			systemdiscounttypes[0] = "";
			systemdiscounttypes[1] = "";
			systemdiscounttypes[2] = "";
		}else{
			for(int i=0; i<systemdiscounttypes.length; i++){
				if("1".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysvip", systemdiscounttypes[i].trim());
				}else if("2".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysdzm", systemdiscounttypes[i].trim());
				}else if("3".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysyg", systemdiscounttypes[i].trim());
				}
			}
		}
		String[] goodsids = Utility.getName(request.getParameter("goodsids")).trim().split(",");
		MaxDiscountPo tjpoDiscountPo = new MaxDiscountPo();
		MaxDiscountPo poDiscountPo = new MaxDiscountPo();
		maxDiscountPos = new ArrayList<MaxDiscountPo>();
		if(!goodsids.equals("") && goodsids.length>0)
		{
			for(int i=0; i<goodsids.length; i++){
				tjpoDiscountPo.setFmdgoodsid(goodsids[i]);
				poDiscountPo = setMealMgr.selectMaxDiscountSetPo(tjpoDiscountPo);
				if("".equals(Utility.getName(poDiscountPo.getFmdmaxdiscount()))){
					tjpoDiscountPo = new MaxDiscountPo();
					tjpoDiscountPo.setFmdgoodscategoryid(goodsids[i].substring(0,1));
					tjpoDiscountPo.setFmdsupplierid(goodsids[i].substring(2,4));
					tjpoDiscountPo.setFmdbrandid(goodsids[i].substring(5,7));
					poDiscountPo = setMealMgr.selectMaxDiscountSetPo(tjpoDiscountPo);
				}
				if("".equals(Utility.getName(poDiscountPo.getFmdmaxdiscount()))){
					tjpoDiscountPo = new MaxDiscountPo();
					tjpoDiscountPo.setFmdgoodscategoryid(goodsids[i].substring(0,1));
					tjpoDiscountPo.setFmdsupplierid(goodsids[i].substring(2,4));
					poDiscountPo = setMealMgr.selectMaxDiscountSetPo(tjpoDiscountPo);
				}
				if("".equals(Utility.getName(poDiscountPo.getFmdmaxdiscount()))){
					tjpoDiscountPo = new MaxDiscountPo();
					tjpoDiscountPo.setFmdgoodscategoryid(goodsids[i].substring(0,1));
					poDiscountPo = setMealMgr.selectMaxDiscountSetPo(tjpoDiscountPo);
				}
				if("".equals(Utility.getName(poDiscountPo.getFmdmaxdiscount()))){
					poDiscountPo.setFmdgoodsid(goodsids[i]);
					poDiscountPo.setFmdmaxdiscount("n");
				}
				poDiscountPo.setFmdgoodsid(goodsids[i]);
				maxDiscountPos.add(poDiscountPo);
			}
		}
		if (!"".equals(Utility.getName(discountShortcutKeysPo.getFdkdiscountcode()))&&!"0".equals(Utility.getName(discountShortcutKeysPo.getFdkenable()))) {
			return SUCCESS;
		} else if ("0".equals(Utility.getName(discountShortcutKeysPo.getFdkenable()))) {
			discountShortcutKeysPo=null;
			this.addActionMessage("此员工打折券已停用！");
			return ERROR;
		} else {
			discountShortcutKeysPo=null;
			if(Utility.getName(systemParameterPo.getFspisusegoodslevel()).equals("1")){
				this.addActionMessage("员工打折券不存在或与商品级别不符！");
			}else{
				this.addActionMessage("员工打折券不存在！");
			}
			return ERROR;
		}
		
	}
	
	public String selectPersonList(){
		personInfoPo =new PersonInfoPo();
		personInfoPo.setId(request.getParameter("id"));
		personInfoPo.setPersonName(request.getParameter("personName"));
		personInfoList=windowPersonDiscountMgr.getPersonInfoPoList(personInfoPo);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化一口价
	 * @return
	 */
	public String initSelectQOnePrice(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String idorcard = Utility.getName(request.getParameter("idorcard"));
		String firstcheckstr = Utility.getName(request.getParameter("firstcheckstr"));
		request.setAttribute("idorcard", idorcard);
		request.setAttribute("firstcheckstr", firstcheckstr);
		request.setAttribute("arg0", Utility.getName(request.getParameter("arg0"))); //打折类型 1为单品
		request.setAttribute("rownumber", Utility.getName(request.getParameter("rownumber")));//打折行
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String[] systemdiscounttypes = systemParameterPo.getFspalldiscount().split(",");
		
		if(systemdiscounttypes == null){
			systemdiscounttypes = new String[3];
			systemdiscounttypes[0] = "";
			systemdiscounttypes[1] = "";
			systemdiscounttypes[2] = "";
		}else{
			for(int i=0; i<systemdiscounttypes.length; i++){
				if("1".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysvip", systemdiscounttypes[i].trim());
				}else if("2".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysdzm", systemdiscounttypes[i].trim());
				}else if("3".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysyg", systemdiscounttypes[i].trim());
				}
			}
		}
		request.setAttribute("selectC", "2");
		return SUCCESS;
	}
	
	/**
	 * 一口价
	 * @return
	 */
	public String selectQOnePrice(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		/** ********************** 权限设置 ***************************** */
		//验证打折人员
		String fpdpersonid=Utility.getName(request.getParameter("fpdpersonid"));
		String fpdpersonpassword=Utility.getName(request.getParameter("fpdpersonpassword"));
		String idorcard = Utility.getName(request.getParameter("idorcard"));
		String cardid = Utility.getName(request.getParameter("cardid"));
		String firstcheckstr = Utility.getName(request.getParameter("firstcheckstr"));
		
		request.setAttribute("firstcheckstr", firstcheckstr);
		request.setAttribute("idorcard", idorcard);
		request.setAttribute("cardid", cardid);
		request.setAttribute("fpdpersonid", fpdpersonid);
		request.setAttribute("fpdpersonpassword", fpdpersonpassword);
		request.setAttribute("arg0", Utility.getName(request.getParameter("arg0")));
		request.setAttribute("rownumber", Utility.getName(request.getParameter("rownumber")));
		
		personInfoPo=new PersonInfoPo();
		personInfoPo.setId(fpdpersonid);
		personInfoPo.setPassword(fpdpersonpassword);
		personInfoPo.setCardid(cardid);
		
		personInfoPo = loginMgr.getDiscountPerson(intoObject());
		
		PersonDiscountDetailsPo pdpo=new PersonDiscountDetailsPo();
		pdpo.setFpddpersonid(fpdpersonid);
		if("1".equals(systemParameterPo.getFspisusegoodslevel())){
			List<PersonDiscountDetailsPo> personDiscountDetailsPos = personDiscountMgr.selectPersonDiscountDetail(pdpo);
			personInfoPo.setPersonDiscountDetailsPos(personDiscountDetailsPos);
		}else{
			PersonDiscountPo discountpo = new PersonDiscountPo();
			discountpo.setFpdpersonid(fpdpersonid);
			PersonDiscountPo personDiscountPo=personDiscountMgr.getPersonDiscount(discountpo);
			personInfoPo.setPersonDiscount(personDiscountPo.getFpddiscount());
		}
		
		String[] systemdiscounttypes = systemParameterPo.getFspalldiscount().split(",");
		
		if(systemdiscounttypes == null){
			systemdiscounttypes = new String[3];
			systemdiscounttypes[0] = "";
			systemdiscounttypes[1] = "";
			systemdiscounttypes[2] = "";
		}else{
			for(int i=0; i<systemdiscounttypes.length; i++){
				if("1".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysvip", systemdiscounttypes[i].trim());
				}else if("2".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysdzm", systemdiscounttypes[i].trim());
				}else if("3".equals(systemdiscounttypes[i].trim())){
					request.setAttribute("sysyg", systemdiscounttypes[i].trim());
				}
			}
		}
		
		if (personInfoPo.getId() != null) {
			if (personInfoPo.getUserState().matches("[0]")) { // 当前状态0:正常 1:删除
				request.setAttribute("selectC", "1");
				return SUCCESS;
			} else {
				if(!"".equals(Utility.getName(cardid))){
					this.addActionMessage("此员工卡号不存在！");
				}else{
					this.addActionMessage(this.getText("person.not.error"));
				}
				request.setAttribute("selectC", "2");
				return ERROR;
			}
		} else {
			personInfoPo=null;
			
			if(!"".equals(Utility.getName(cardid))){
				this.addActionMessage("此员工卡号不存在！");
			}else{
				this.addActionMessage(this.getText("personid.password.error"));
			}
			request.setAttribute("selectC", "2");
			return ERROR;
		}
		
	}
	
	public String selectRoleList(){
		if(null !=rolePo){
			rolePo =new RolePo();
		}
		roleList=windowPersonDiscountMgr.getRolePoList(rolePo);
		
		return SUCCESS;
	}

	public SetMealMgr getSetMealMgr() {
		return setMealMgr;
	}

	public void setSetMealMgr(SetMealMgr setMealMgr) {
		this.setMealMgr = setMealMgr;
	}

	public List<MaxDiscountPo> getMaxDiscountPos() {
		return maxDiscountPos;
	}

	public void setMaxDiscountPos(List<MaxDiscountPo> maxDiscountPos) {
		this.maxDiscountPos = maxDiscountPos;
	}

	public PersonDiscountMgr getPersonDiscountMgr() {
		return personDiscountMgr;
	}

	public void setPersonDiscountMgr(PersonDiscountMgr personDiscountMgr) {
		this.personDiscountMgr = personDiscountMgr;
	}
}
