package com.pengsheng.eims.system.action;

import java.math.BigDecimal;
import java.util.List;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.persistence.GoodsLevelPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.MemberManagementMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.MemberManagementDiscountPo;
import com.pengsheng.eims.system.persistence.MemberManagementDiscountSetUpDetailsPo;
import com.pengsheng.eims.system.persistence.MemberManagementPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class MemberManagementAction extends BaseAction{
	private BrandMgr brandMgr;
	private List<GoodsLevelPo> selectGoodsLevelList;
	private List<MemberManagementPo> list;	
	private MemberManagementMgr memberManagementMgr;	
	private MemberManagementPo memberManagementPo;	
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private MemberManagementDiscountPo memberManagementDiscountPo;
	private List<MemberManagementDiscountPo> memberManagementDiscountlist;
	private MemberManagementDiscountSetUpDetailsPo memberManagementDiscountSetUpDetailsPo;
	private List<MemberManagementDiscountSetUpDetailsPo> memberManagementDiscountSetUpDetailsPos;
	
	public List<MemberManagementDiscountSetUpDetailsPo> getMemberManagementDiscountSetUpDetailsPos() {
		return memberManagementDiscountSetUpDetailsPos;
	}

	public void setMemberManagementDiscountSetUpDetailsPos(
			List<MemberManagementDiscountSetUpDetailsPo> memberManagementDiscountSetUpDetailsPos) {
		this.memberManagementDiscountSetUpDetailsPos = memberManagementDiscountSetUpDetailsPos;
	}

	public MemberManagementDiscountSetUpDetailsPo getMemberManagementDiscountSetUpDetailsPo() {
		return memberManagementDiscountSetUpDetailsPo;
	}

	public void setMemberManagementDiscountSetUpDetailsPo(
			MemberManagementDiscountSetUpDetailsPo memberManagementDiscountSetUpDetailsPo) {
		this.memberManagementDiscountSetUpDetailsPo = memberManagementDiscountSetUpDetailsPo;
	}

	public BrandMgr getBrandMgr() {
		return brandMgr;
	}

	public void setBrandMgr(BrandMgr brandMgr) {
		this.brandMgr = brandMgr;
	}

	public List<GoodsLevelPo> getSelectGoodsLevelList() {
		return selectGoodsLevelList;
	}

	public void setSelectGoodsLevelList(List<GoodsLevelPo> selectGoodsLevelList) {
		this.selectGoodsLevelList = selectGoodsLevelList;
	}

	public List<MemberManagementDiscountPo> getMemberManagementDiscountlist() {
		return memberManagementDiscountlist;
	}

	public void setMemberManagementDiscountlist(
			List<MemberManagementDiscountPo> memberManagementDiscountlist) {
		this.memberManagementDiscountlist = memberManagementDiscountlist;
	}

	public MemberManagementDiscountPo getMemberManagementDiscountPo() {
		return memberManagementDiscountPo;
	}

	public void setMemberManagementDiscountPo(
			MemberManagementDiscountPo memberManagementDiscountPo) {
		this.memberManagementDiscountPo = memberManagementDiscountPo;
	}

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public UUIDHexGenerator getUuid() {
		return uuid;
	}

	public void setUuid(UUIDHexGenerator uuid) {
		this.uuid = uuid;
	}

	private String isFirstExec;
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public MemberManagementMgr getMemberManagementMgr() {
		return memberManagementMgr;
	}

	public void setMemberManagementMgr(MemberManagementMgr memberManagementMgr) {
		this.memberManagementMgr = memberManagementMgr;
	}
	
	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	
	/**
	 * 初始化会员卡类别新增
	 */
	public String initMemberManagementInsert()throws Exception{
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
		
		list = memberManagementMgr.getMemberManagementList();
		memberManagementPo=new MemberManagementPo();
		
		return SUCCESS;
	}
	
	/**
	 * 新增会员卡类别
	 */
	public String insertMemberManagement()throws Exception{
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
		
		memberManagementPo.setFmmid(uuid.generate());
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("会员卡:" + memberManagementPo.getFmmid() + "新增!");
		
		int flagname = memberManagementMgr.getMemberManagementName(memberManagementPo);
		int count = memberManagementMgr.getMemberCardIntegralArea(memberManagementPo);
		this.clearMessages();
		
		list = memberManagementMgr.getMemberManagementList();
		
		if(flagname ==0 && count == 0){			
			memberManagementMgr.insertMemberManagement(memberManagementPo,logPo);		
			
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);		
			return SUCCESS;
		}else{
			this.addActionMessage(getText("会员卡类型名称或积分范围重复!"));
			return "error";
		}
		
	}
	
	/**
	 * 初始化会员卡类别修改
	 */
	public String initMemberManagementUpdate()throws Exception{
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
		
		String id=Utility.getName(request.getParameter("hid"));
		MemberManagementPo po=new MemberManagementPo();
		po.setFmmid(id);
		memberManagementPo=memberManagementMgr.getMemberManagement(po);
		
		list = memberManagementMgr.getMemberManagementList();
		
		return SUCCESS;
	}
	
	/**
	 * 修改会员卡类别
	 */
	public String updateMemberManagement()throws Exception{
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("会员卡:" + memberManagementPo.getFmmid() + "修改!");
		
		String isupdate = Utility.getName(request.getParameter("isupdate"));
		memberManagementPo.setFmmisupdate(isupdate);
		
		String setdefault = Utility.getName(request.getParameter("setdefault"));
		memberManagementPo.setFmmsetdefault(setdefault);
		
		String setisfavorable = Utility.getName(request.getParameter("setisfavorable"));
		memberManagementPo.setFmmisfavorable(setisfavorable);
		
		int flagname=memberManagementMgr.getMemberManagementNameUpdate(memberManagementPo);
		int count = memberManagementMgr.getMemberCardIntegralArea(memberManagementPo);

		MemberManagementPo po = new MemberManagementPo();
		po.setFmmid(Utility.getName(memberManagementPo.getFmmid()));
		po = memberManagementMgr.getMemberManagement(po);
		
		if ((Utility.getName(po.getFmmdown()).equals(Utility.getName(memberManagementPo.getFmmdown())) && 
				Utility.getName(po.getFmmup()).equals(Utility.getName(memberManagementPo.getFmmup())))){
			count = 0;
		}
		
		this.clearMessages();
		
		list = memberManagementMgr.getMemberManagementList();
		
		boolean isRepeatArea = false;
		boolean isIntersect = false;
		int modifyFmmDown = new BigDecimal(memberManagementPo.getFmmdown()).intValue();
		int modifyFmmUp = new BigDecimal(memberManagementPo.getFmmup()).intValue();
		for (MemberManagementPo memPo : list) {
			if(!memPo.getFmmid().equals(memberManagementPo.getFmmid())) {
				int fmmDown = new BigDecimal(memPo.getFmmdown()).intValue();
				int fmmUp = new BigDecimal(memPo.getFmmup()).intValue();
				if((fmmDown <= modifyFmmDown) && (modifyFmmUp <= fmmUp)) {
					isRepeatArea = true;
					break;
				}
				if((modifyFmmDown > fmmDown && modifyFmmDown < fmmUp) ||
						(modifyFmmUp > fmmDown && modifyFmmUp < fmmUp)) {
					isIntersect = true;
					break;
				}
			}
		}
		
		if((flagname == 0 && count == 0) || !(isRepeatArea || isIntersect)){
			memberManagementMgr.updateMemberManagement(memberManagementPo,logPo);
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);		
			return SUCCESS;
		}else {
			this.addActionMessage(getText("会员卡类型名称或积分范围重复!"));
			return "error";
		}
		
		
	}
	
	/**
	 * 查询会员卡类别
	 */
	public String selMemberManagement()throws Exception{

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

		MemberManagementPo po = new MemberManagementPo();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());

		int count = memberManagementMgr.getMemberManagementCount(po);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}			
			Pagination page = new Pagination(request, count, perPage);
			list = memberManagementMgr.getMemberList(po, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);			
		} else {			
			list = null;		
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始化会员卡类别删除
	 */
	public String initMemberManagementDelete()throws Exception{
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
		
		String id=Utility.getName(request.getParameter("hid"));
		MemberManagementPo po=new MemberManagementPo();
		po.setFmmid(id);
		memberManagementPo=memberManagementMgr.getMemberManagement(po);

		return SUCCESS;
	}
	
	/**
	 * 删除会员卡类别
	 */
	public String deleteMemberManagement()throws Exception{
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
		
		String id=Utility.getName(request.getParameter("hid"));
		MemberManagementPo po=new MemberManagementPo();
		po.setFmmid(id);
		
		int count = memberManagementMgr.isUseMemberManagement(po);
		if(count == 0){
			//添加日志
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(createPerson);
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 表示模块名称 
			logPo.setsLogOpID("2");    // 表示状态
			logPo.setsLogContent("会员卡:" + id + "删除!");
			
			memberManagementMgr.deleteMemberManagement(po,logPo);
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.delete.sucess"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}else{
			this.clearMessages();
			this.addActionMessage("会员卡类型已被使用，删除失败！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}
	}
	
	/**
	 * 初始化设置会员卡类别升级次序
	 */
	public String initMemberManagementUpgrade()throws Exception{

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
		
		String hid = Utility.getName(request.getParameter("hid"));
		String hcount = Utility.getName(request.getParameter("hcount"));
		request.setAttribute("hid",hid);
		request.setAttribute("hcount",hcount);
		
		list = memberManagementMgr.getMemberManagementList();

		return SUCCESS;
	}
	
	/**
	 * 设置会员卡类别升级次序
	 */
	public String memberManagementUpgrade()throws Exception{

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
				
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("会员卡类型:" + memberManagementPo.getFmmid() +" 升级至 "+memberManagementPo.getFmmtypeid());
		
		memberManagementMgr.updateMemberManagement(memberManagementPo,logPo);
		
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	/**
	 * 会员卡折扣设置初始化
	 * @return
	 * @throws Exception
	 */
	
	public String initMemberManagementDiscountUpdate()throws Exception{

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
		request.setAttribute("membermanagementhid", request.getParameter("membermanagementhid"));
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "memberManagementDiscountSels";
		}
		
		return SUCCESS;
	}
	/**
	 * 会员卡折扣设置
	 * @return
	 * @throws Exception
	 */
	public String memberManagementDiscountSel() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String goodsCategoryID = Utility.getName(request.getParameter("goodsCategoryID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String membermanagementhid=Utility.getName(request.getParameter("membermanagementhid"));		
		String bdpdepartmentname=Utility.getName(request.getParameter("bdpdepartmentname"));
		String bdpdepartmentID=Utility.getName(request.getParameter("bdpdepartmentID"));
		
		request.setAttribute("goodsCategoryID",goodsCategoryID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("brandName",brandName);
		request.setAttribute("brandID",brandID);
		request.setAttribute("goodsID",goodsID);
		request.setAttribute("goodsName",goodsName);
		request.setAttribute("membermanagementhid", membermanagementhid);
		request.setAttribute("bdpdepartmentname", bdpdepartmentname);
		request.setAttribute("bdpdepartmentID", bdpdepartmentID);
		
		memberManagementDiscountPo = new MemberManagementDiscountPo();
		if (goodsCategoryID.startsWith("3") || goodsCategoryID.startsWith("4")){
			memberManagementDiscountPo.setFmdiscustomize(goodsCategoryID.split("_")[1]);
			memberManagementDiscountPo.setFmdgoodscategoryid(goodsCategoryID.split("_")[0]);				
		}else{
			memberManagementDiscountPo.setFmdgoodscategoryid(goodsCategoryID);
		}
		
		memberManagementDiscountPo.setFmdsupplierid(supplierID);
		memberManagementDiscountPo.setFmdbrandid(brandID);
		memberManagementDiscountPo.setFmdgoodsid(goodsID);
		memberManagementDiscountPo.setFmdgoodsname(goodsName);
		memberManagementDiscountPo.setFmdmembermanagementid(membermanagementhid);
		memberManagementDiscountPo.setFmmisshopcode(bdpdepartmentID);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
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
		
		int count =memberManagementMgr.getMemberManagementDiscountSetCount(memberManagementDiscountPo);
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
			memberManagementDiscountlist = memberManagementMgr.getMemberManagementDiscountSetList(memberManagementDiscountPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			memberManagementDiscountlist = null;
		}
	
		return SUCCESS;
	}
	
	/**
	 * 初始化会员卡类型折扣设置新增
	 * @return
	 * @throws Exception
	 */
	public String initMemberManagementDiscountSetInsert() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		request.setAttribute("membermanagementhid", request.getParameter("membermanagementhid"));
		return SUCCESS;
	}
	/**
	 * 折扣设置新增
	 * @return
	 * @throws Exception
	 */
	public String insertMemberManagementDiscountSet() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		if (memberManagementDiscountPo.getFmdgoodscategoryid().equals("3-0")){
			memberManagementDiscountPo.setFmdgoodscategoryname("成品片");				
		}
		if (memberManagementDiscountPo.getFmdgoodscategoryid().equals("3-D")){
			memberManagementDiscountPo.setFmdgoodscategoryname("订做片");				
		}
		if (memberManagementDiscountPo.getFmdgoodscategoryid().equals("4-0")){
			memberManagementDiscountPo.setFmdgoodscategoryname("隐形成品片");				
		}
		if (memberManagementDiscountPo.getFmdgoodscategoryid().equals("4-D")){
			memberManagementDiscountPo.setFmdgoodscategoryname("隐形订做片");				
		}
		if (memberManagementDiscountPo.getFmdgoodscategoryid().equals("1")){
			memberManagementDiscountPo.setFmdgoodscategoryname("镜架");				
		}
		if (memberManagementDiscountPo.getFmdgoodscategoryid().equals("2")){
			memberManagementDiscountPo.setFmdgoodscategoryname("配件");				
		}
		if (memberManagementDiscountPo.getFmdgoodscategoryid().equals("5")){
			memberManagementDiscountPo.setFmdgoodscategoryname("护理液");				
		}
		if (memberManagementDiscountPo.getFmdgoodscategoryid().equals("6")){
			memberManagementDiscountPo.setFmdgoodscategoryname("太阳镜");				
		}
		if (memberManagementDiscountPo.getFmdgoodscategoryid().equals("7")){
			memberManagementDiscountPo.setFmdgoodscategoryname("耗材");				
		}
		if (memberManagementDiscountPo.getFmdgoodscategoryid().equals("8")){
			memberManagementDiscountPo.setFmdgoodscategoryname("老花镜");				
		}
		if (memberManagementDiscountPo.getFmdgoodscategoryid().equals("9")){
			memberManagementDiscountPo.setFmdgoodscategoryname("视光");				
		}			
		if (memberManagementDiscountPo.getFmdgoodscategoryid().startsWith("3") || memberManagementDiscountPo.getFmdgoodscategoryid().startsWith("4")){
			memberManagementDiscountPo.setFmdiscustomize(memberManagementDiscountPo.getFmdgoodscategoryid().split("-")[1]);
			memberManagementDiscountPo.setFmdgoodscategoryid(memberManagementDiscountPo.getFmdgoodscategoryid().split("-")[0]);				
		}
		memberManagementDiscountPo.setFmdmembermanagementid(request.getParameter("membermanagementhid"));
		request.setAttribute("membermanagementhid", request.getParameter("membermanagementhid"));
		
		
		memberManagementDiscountPo.setFmmisshopcode(Utility.getName(request.getParameter("bdpdepartmentID")));
		memberManagementDiscountPo.setFmmisshopcodename(Utility.getName(request.getParameter("bdpdepartmentname")));
		
		int count = memberManagementMgr.isExistMemberManagementDiscountSet(memberManagementDiscountPo);
		if (count == 0){

			memberManagementMgr.insertMemberManagementDiscountSet(memberManagementDiscountPo,memberManagementDiscountSetUpDetailsPo);
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));		
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
		}else{
			this.clearMessages();
			this.addActionMessage(getText("折扣设置不能重复!"));
			
			return "NoRepeat";
		}

		return SUCCESS;
	}
	
	/**
	 * 初始化折扣设置更新
	 * @return
	 * @throws Exception
	 */
	public String initMemberManagementDiscountSetUpdate() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		memberManagementDiscountPo=new MemberManagementDiscountPo();
		memberManagementDiscountPo.setFmdid(Utility.getName(request.getParameter("hid")));
		
		MemberManagementDiscountSetUpDetailsPo dpo = new MemberManagementDiscountSetUpDetailsPo();
		dpo.setFmddsetupid(Utility.getName(request.getParameter("hid")));
		
		memberManagementDiscountPo = memberManagementMgr.getMemberManagementDiscountSetDetail(memberManagementDiscountPo);
		memberManagementDiscountSetUpDetailsPos = memberManagementMgr.selectMemberManagementDiscountSetUpDetails(dpo);
		
		return SUCCESS;
	}
	/**
	 * 折扣设置更新
	 * @return
	 * @throws Exception
	 */
	public String updateMemberManagementDiscountSet() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		memberManagementDiscountPo.setFmmisshopcode(Utility.getName(request.getParameter("bdpdepartmentID")));
		memberManagementDiscountPo.setFmmisshopcodename(Utility.getName(request.getParameter("bdpdepartmentname")));
		
		int count = memberManagementMgr.isExistMemberManagementDiscountSet(memberManagementDiscountPo);
		if (count == 0){

			memberManagementMgr.updateMemberManagementDiscount(memberManagementDiscountPo,memberManagementDiscountSetUpDetailsPo);		
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
		}else{
			this.clearMessages();
			this.addActionMessage(getText("折扣设置不能重复!"));
			
			return "NoRepeat";
		}
		
		return SUCCESS;
	}	
	/**
	 * 折扣设置删除
	 * @return
	 * @throws Exception
	 */
	public String initMemberManagementDiscountSetDelete() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String hid = Utility.getName(request.getParameter("hid"));
		request.setAttribute("hid",hid);
		
		return SUCCESS;
	}
	/**
	 * 删除折扣设置
	 * @return
	 * @throws Exception
	 */
	public String deleteMemberManagementDiscountSet() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		memberManagementMgr.deleteMemberManagementDiscountSet(memberManagementDiscountPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;	
	}
	/**
	 * 初始化折扣设置批量修改
	 * @return
	 * @throws Exception
	 */
	public String initMemberManagementDiscountSetBatchUpdate() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String hid = Utility.getName(request.getParameter("hid"));
		request.setAttribute("hid",hid);
		
		return SUCCESS;
	}
	/**
	 * 批量修改折扣设置
	 * @return
	 * @throws Exception
	 */
	public String updateBatchMemberManagementDiscountSet() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		memberManagementMgr.updateBathMemberManagementDiscountSet(memberManagementDiscountPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;	
	}
	/**
	 * 初始化折扣设置批量删除
	 * @return
	 * @throws Exception
	 */
	public String initMemberManagementDiscountSetBatchDelete() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String hid = Utility.getName(request.getParameter("hid"));
		request.setAttribute("hid",hid);
		
		return SUCCESS;
	}
	/**
	 * 批量修改折扣设置
	 * @return
	 * @throws Exception
	 */
	public String deleteBatchMemberManagementDiscountSet() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		memberManagementMgr.deleteBathMemberManagementDiscountSet(memberManagementDiscountPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;	
	}
	public List<MemberManagementPo> getList() {
		return list;
	}

	public void setList(List<MemberManagementPo> list) {
		this.list = list;
	}

	public MemberManagementPo getMemberManagementPo() {
		return memberManagementPo;
	}

	public void setMemberManagementPo(MemberManagementPo memberManagementPo) {
		this.memberManagementPo = memberManagementPo;
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
	
}
