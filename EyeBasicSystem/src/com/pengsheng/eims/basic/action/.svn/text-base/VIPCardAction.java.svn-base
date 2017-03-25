package com.pengsheng.eims.basic.action;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.mgr.VIPCardMgr;
import com.pengsheng.eims.basic.persistence.GoodsLevelPo;
import com.pengsheng.eims.basic.persistence.VIPCardDetailsPo;
import com.pengsheng.eims.basic.persistence.VIPCardPo;
import com.pengsheng.eims.basic.persistence.VIPGoodsBindPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class VIPCardAction extends BaseAction{
	
	private List<VIPCardPo> vipCardPos;
	private List<VIPCardDetailsPo> vipCardDetailsPos;
	private VIPCardPo vipCardPo;
	private VIPCardDetailsPo vipCardDetailsPo;
	private VIPCardMgr vipCardMgr;
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private String savePath;
	private String fileName;
	private String contentType;
	private InputStream inputStream;
	private BrandMgr brandMgr;
	private List<GoodsLevelPo> selectGoodsLevelList;
	private List<VIPGoodsBindPo> vbpoList;
	
	public List<VIPGoodsBindPo> getVbpoList() {
		return vbpoList;
	}

	public void setVbpoList(List<VIPGoodsBindPo> vbpoList) {
		this.vbpoList = vbpoList;
	}

	public List<VIPCardDetailsPo> getVipCardDetailsPos() {
		return vipCardDetailsPos;
	}

	public void setVipCardDetailsPos(List<VIPCardDetailsPo> vipCardDetailsPos) {
		this.vipCardDetailsPos = vipCardDetailsPos;
	}

	public VIPCardDetailsPo getVipCardDetailsPo() {
		return vipCardDetailsPo;
	}

	public void setVipCardDetailsPo(VIPCardDetailsPo vipCardDetailsPo) {
		this.vipCardDetailsPo = vipCardDetailsPo;
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

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
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
	
	public String initSelectVIPCard() throws Exception {
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selVIPCards";
		}
		return SUCCESS;
	}
	
	public String selectVIPCard() throws Exception {
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
		
		VIPCardPo po = new VIPCardPo();
		
		String ssevcidt = Utility.getName(request.getParameter("ssevcidt"));
		String ssevcdowntimet = Utility.getName(request.getParameter("ssevcdowntimet"));
		String ssevcuptimet = Utility.getName(request.getParameter("ssevcuptimet"));
		String ssevcdiscountt = Utility.getName(request.getParameter("ssevcdiscountt"));
		String ssevccreatpersonid = Utility.getName(request.getParameter("ssevccreatpersonid"));
		String ssevccreatpersonname = Utility.getName(request.getParameter("ssevccreatpersonname"));
		String ssevccustomername = Utility.getName(request.getParameter("ssevccustomername"));
		String ssevcidcard = Utility.getName(request.getParameter("ssevcidcard"));
		String ssevcbegindate = Utility.getName(request.getParameter("ssevcbegindate"));
		String ssevcenddate = Utility.getName(request.getParameter("ssevcenddate"));
		
		po.setSsevcidt(ssevcidt);
		po.setSsevcdowntimet(ssevcdowntimet);
		po.setSsevcuptimet(ssevcuptimet);
		po.setSsevcdiscountt(ssevcdiscountt);
		po.setSsevccreatpersonid(ssevccreatpersonid);
		po.setSsevccreatpersonname(ssevccreatpersonname);
		po.setSsevccustomername(ssevccustomername);
		po.setSsevcidcard(ssevcidcard);
		po.setSsevcbegindate(ssevcbegindate);
		po.setSsevcenddate(ssevcenddate);
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
		int count = vipCardMgr.selectVIPCardCount(po);
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
			vipCardPos = vipCardMgr.selectVIPCardList(po,page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			vipCardPos = null;
		}
		
		request.setAttribute("ssevccustomername", ssevccustomername);
		request.setAttribute("ssevcidcard", ssevcidcard);
		request.setAttribute("ssevcbegindate", ssevcbegindate);
		request.setAttribute("ssevcenddate", ssevcenddate);
		request.setAttribute("ssevcidt", ssevcidt);
		request.setAttribute("ssevcdowntimet", ssevcdowntimet);
		request.setAttribute("ssevcuptimet", ssevcuptimet);
		request.setAttribute("ssevcdiscountt", ssevcdiscountt);
		request.setAttribute("ssevccreatpersonid", ssevccreatpersonid);
		request.setAttribute("ssevccreatpersonname", ssevccreatpersonname);
		
		return SUCCESS;
	}
	
	public String initInsertVIPCard() throws Exception {
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
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		return SUCCESS;
	}
	
	public String initInsertVIPCards() throws Exception {
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
		
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyMMdd");
		String cardid1 = "V"+numHeadFormat.format(new Date());
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		request.setAttribute("cardid1", cardid1);
		
		return SUCCESS;
	}
	
	public String insertVIPCard() throws Exception {
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
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		VIPCardPo po = new VIPCardPo();
		
		po.setSsevcidt(vipCardPo.getSsevcid());
		
		int count = vipCardMgr.selectVIPCardCount(po);
		
		if(count > 0){
			this.clearMessages();
			this.addActionMessage("该卡号已被使用！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return "error";
		}else{
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(createPerson);
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 表示模块名称 
			logPo.setsLogOpID("1");    // 表示状态
			logPo.setsLogContent("打折卡："+vipCardPo.getSsevcid()+"新增！");
			
			vipCardPo.setSsevccreatpersonid(createPerson);
			
			String[] goodsTypeArray = request.getParameterValues("goodsType"); 
			List<VIPGoodsBindPo> vlist = new ArrayList<VIPGoodsBindPo>();
			
			if (goodsTypeArray != null){
				for (int i = 0; i < goodsTypeArray.length; i++){
					if (!goodsTypeArray[i].equals("0")){   // 排除"全选"
						VIPGoodsBindPo vpo = new VIPGoodsBindPo();
						vpo.setSsevbVipcardID(vipCardPo.getSsevcid());
						vpo.setSsevbgoodscategory(goodsTypeArray[i]);
						
						vlist.add(vpo);	
					}
				}
			}

			vipCardMgr.insertVIPCardPo(vipCardPo,vipCardDetailsPo,vlist,logPo);
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
	}
	
	public String insertVIPCards() throws Exception {
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
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		String ssevcid1 = Utility.getName(request.getParameter("ssevcid1"));
		String ssevcid2_tmp = Utility.getName(request.getParameter("ssevcid2")).trim();	
		String lastNum = "";
		
		BigDecimal ssevcid2 = new BigDecimal(ssevcid2_tmp);
		BigDecimal cardnumber = new BigDecimal(Utility.getName(request.getParameter("cardnumber")).trim());		
		BigDecimal movenumber = new BigDecimal(0);//计数器
		BigDecimal area = new BigDecimal(1);//步长
		List<VIPCardPo> vipCardList = new ArrayList<VIPCardPo>();
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("打折卡批号:"+ssevcid1+"新增,共:"+cardnumber.toString()+"张！");
		
		for(int i = 0; i < cardnumber.intValue(); i++){			
			VIPCardPo po = new VIPCardPo();
			po.setSsevcidt(ssevcid1 + addZero(ssevcid2.add(movenumber).toString(),ssevcid2_tmp.length()));
			po.setSsevcid(ssevcid1 + addZero(ssevcid2.add(movenumber).toString(),ssevcid2_tmp.length()));
			lastNum =  addZero(ssevcid2.add(movenumber).toString(),ssevcid2_tmp.length());
			
			int count = vipCardMgr.selectVIPCardCount(po);
			if(count > 0){
				i--;
			}else{
                po.setSsevcdiscount(Utility.getName(vipCardPo.getSsevcdiscount()));
                po.setSsevccustomername(Utility.getName(vipCardPo.getSsevccustomername()));              
                po.setSsevcidcard(Utility.getName(vipCardPo.getSsevcidcard()));
                po.setSsevccardpassword(Utility.getName(vipCardPo.getSsevccardpassword()));
                po.setSsevccreatpersonid(createPerson);
                po.setSsevcdowntime(Utility.getName(vipCardPo.getSsevcdowntime()));
                po.setSsevcuptime(Utility.getName(vipCardPo.getSsevcuptime()));
                po.setSsevcusecount(Utility.getName(vipCardPo.getSsevcusecount()));
                
                vipCardList.add(po);
			}
			movenumber = movenumber.add(area);
		}
		
		this.clearMessages();
		if (vipCardList.size() > 0){
			
			String[] goodsTypeArray = request.getParameterValues("goodsType"); 
			List<VIPGoodsBindPo> vlist = new ArrayList<VIPGoodsBindPo>();
			
			if (goodsTypeArray != null){
				for (int i = 0; i < goodsTypeArray.length; i++){
					if (!goodsTypeArray[i].equals("0")){   // 排除"全选"
						VIPGoodsBindPo vpo = new VIPGoodsBindPo();
						vpo.setSsevbgoodscategory(goodsTypeArray[i]);
						
						vlist.add(vpo);	
					}
				}
			}
			
			vipCardMgr.insertBatchVIPCard(vipCardList,vipCardDetailsPo,vlist,logPo);
			
			this.addActionMessage(getText("从卡号:" + ssevcid1 + ssevcid2_tmp + " 至 " + ssevcid1 + lastNum + " ,共 " + cardnumber.toString() + " 张\\n新增成功!"));
		}else{
			this.addActionMessage(getText("该批号打折卡新增失败!"));
		}		
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	private String addZero(String str,int size){
		
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < (size-str.length()); i++){
			buffer.append("0");
		}
		
		return buffer.toString() + str;
	}
	
	public String initUpdateVIPCard() throws Exception {
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
		
		VIPCardPo po = new VIPCardPo();
		String ssevcidt = Utility.getName(request.getParameter("ssevcidt"));
		po.setSsevcidt(ssevcidt);
		
		VIPCardDetailsPo dpo = new VIPCardDetailsPo();
		dpo.setSsevcdvipcardid(ssevcidt);
		
		vipCardPo = vipCardMgr.selectVIPCardDetail(po);
		vipCardDetailsPos = vipCardMgr.selectVIPCardDetails(dpo);
		vbpoList = vipCardMgr.selectVIPCardBindGoodsType(po);
		
		return SUCCESS;
	}
	
	public String updateVIPCard() throws Exception {
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
		
		VIPCardPo po = new VIPCardPo();
		po.setSsevcidt(vipCardPo.getSsevcnewid());
		
		if(!"".equals(Utility.getName(vipCardMgr.selectVIPCardPo(po).getSsevcid()))){
			this.clearMessages();
			this.addActionMessage("该卡已被使用！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return "error";
		}		
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("打折卡："+vipCardPo.getSsevcid()+"更新！");
		vipCardPo.setSsevcidt(vipCardPo.getSsevcid());
		
		String[] goodsTypeArray = request.getParameterValues("goodsType"); 
		List<VIPGoodsBindPo> vlist = new ArrayList<VIPGoodsBindPo>();
		
		if (goodsTypeArray != null){
			for (int i = 0; i < goodsTypeArray.length; i++){
				if (!goodsTypeArray[i].equals("0")){   // 排除"全选"
					VIPGoodsBindPo vpo = new VIPGoodsBindPo();
					if(!"".equals(Utility.getName(vipCardPo.getIschangecard()))){
						vpo.setSsevbVipcardID(vipCardPo.getSsevcnewid());
					}else{
						vpo.setSsevbVipcardID(vipCardPo.getSsevcidt());
					}
					vpo.setSsevbgoodscategory(goodsTypeArray[i]);
					
					vlist.add(vpo);	
				}
			}
		}
		
		vipCardMgr.updateVIPCardPo(vipCardPo,vipCardDetailsPo,vlist,logPo);
		
		this.clearMessages();
		this.addActionMessage("更新成功！");
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public String initDeleteVIPCard() throws Exception {
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
		
		VIPCardPo po = new VIPCardPo();
		
		String ssevcidt = Utility.getName(request.getParameter("ssevcidt"));
		
		request.setAttribute("ssevcidt", ssevcidt);
		
		return SUCCESS;
	}
	
	public String deleteVIPCard() throws Exception {
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
		
		VIPCardPo po = new VIPCardPo();
		
		String ssevcidt = Utility.getName(request.getParameter("ssevcidt"));
		
		po.setSsevcidt(ssevcidt);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("打折卡："+ssevcidt+"删除！");
		
		vipCardMgr.deleteVIPCardPo(po,logPo);
		
		this.clearMessages();
		this.addActionMessage("删除成功！");
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public String initReplaceVIPCard() throws Exception {
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
		
		VIPCardPo po = new VIPCardPo();
		
		String ssevcidt = Utility.getName(request.getParameter("ssevcidt"));
		String ssevccardpassword = Utility.getName(request.getParameter("ssevccardpassword"));
		
		po.setSsevcidt(ssevcidt);
		
		vipCardPo = vipCardMgr.selectVIPCardPo(po);
		
		VIPCardPo po1 = new VIPCardPo();
		VIPCardPo newpo = new VIPCardPo();
		
		po1.setSsevcidt(ssevcidt);
		po1.setSsevccardpassword(ssevccardpassword);
		
		request.setAttribute("ssevcidt", ssevcidt);
		request.setAttribute("ssevccardpassword", ssevccardpassword);
		
		if("".equals(Utility.getName(vipCardPo.getSsevccardpassword()))){
			request.setAttribute("pwd","0");
		}else{
			request.setAttribute("pwd","1");
		}
		
		if(!"".equals(ssevccardpassword)){
			newpo = vipCardMgr.selectVIPCardPo(po1);
			if("".equals(Utility.getName(newpo.getSsevcid()))){
				this.clearMessages();
				this.addActionMessage("密码错误！");
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			}else{
				request.setAttribute("login","1");
			}
		}
		
		return SUCCESS;
		
	}
	
	public String replaceVIPCard() throws Exception {
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
		
		VIPCardPo po = new VIPCardPo();
		
		String ssevcidt = Utility.getName(request.getParameter("ssevcidt"));
		String ssevccardpassword = Utility.getName(request.getParameter("ssevccardpassword"));
		String ssevcnewid = Utility.getName(request.getParameter("ssevcnewid"));
		String ssevccardnewpassword = Utility.getName(request.getParameter("ssevccardnewpassword"));
		
		po.setSsevcidt(ssevcidt);
		po.setSsevccardpassword(ssevccardpassword);
		po.setSsevcnewid(ssevcnewid);
		po.setSsevccardnewpassword(ssevccardnewpassword);
		
		vipCardPo = vipCardMgr.selectVIPCardPo(po);
		
		request.setAttribute("ssevcidt", ssevcidt);
		
		VIPCardPo newpo = new VIPCardPo();
		VIPCardPo po1 = new VIPCardPo();
		
		po1.setSsevcidt(ssevcnewid);
		
		newpo = vipCardMgr.selectVIPCardPo(po1);
		
		if("".equals(Utility.getName(vipCardPo.getSsevccardpassword()))){
			request.setAttribute("pwd","0");
		}else{
			request.setAttribute("pwd","1");
		}
		
		if(!"".equals(Utility.getName(newpo.getSsevcid()))){
			this.clearMessages();
			this.addActionMessage("该卡已被使用！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return "error";
		}else if("".equals(Utility.getName(vipCardPo.getSsevcid()))){
			this.clearMessages();
			this.addActionMessage("密码错误！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return "error";
		}else{
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(createPerson);
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 表示模块名称 
			logPo.setsLogOpID("1");    // 表示状态
			logPo.setsLogContent("打折卡："+ssevcidt+"更换！");
			
			vipCardMgr.updateVIPCardID(po, logPo);
			
			this.clearMessages();
			this.addActionMessage("更换成功！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}
	}
	
	/**
	 * 导出打折卡号
	 * 
	 * @return
	 * @throws Exception
	 */
	public String exportVipCard() throws Exception {
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
		
		setFileName(java.net.URLEncoder.encode("打折卡号.xls", "UTF-8"));		
		
		String ssevcidt = Utility.getName(request.getParameter("ssevcidt"));
		String ssevcdowntimet = Utility.getName(request.getParameter("ssevcdowntimet"));
		String ssevcuptimet = Utility.getName(request.getParameter("ssevcuptimet"));
		String ssevcdiscountt = Utility.getName(request.getParameter("ssevcdiscountt"));
		String ssevccreatpersonid = Utility.getName(request.getParameter("ssevccreatpersonid"));
		String ssevccreatpersonname = Utility.getName(request.getParameter("ssevccreatpersonname"));
		String ssevccustomername = Utility.getName(request.getParameter("ssevccustomername"));
		String ssevcidcard = Utility.getName(request.getParameter("ssevcidcard"));
		String ssevcbegindate = Utility.getName(request.getParameter("ssevcbegindate"));
		String ssevcenddate = Utility.getName(request.getParameter("ssevcenddate"));
		
		VIPCardPo po = new VIPCardPo();
		po.setSsevcidt(ssevcidt);
		po.setSsevcdowntimet(ssevcdowntimet);
		po.setSsevcuptimet(ssevcuptimet);
		po.setSsevcdiscountt(ssevcdiscountt);
		po.setSsevccreatpersonid(ssevccreatpersonid);
		po.setSsevccreatpersonname(ssevccreatpersonname);
		po.setSsevccustomername(ssevccustomername);
		po.setSsevcidcard(ssevcidcard);
		po.setSsevcbegindate(ssevcbegindate);
		po.setSsevcenddate(ssevcenddate);
		
		try {
			inputStream = vipCardMgr.insertExportExcel(po);
		} catch (Exception e) {
			System.out.println("打折卡号导出失败：" + e.getMessage());
		}
			
		return SUCCESS;
	}
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public List<VIPCardPo> getVipCardPos() {
		return vipCardPos;
	}
	public void setVipCardPos(List<VIPCardPo> vipCardPos) {
		this.vipCardPos = vipCardPos;
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

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
}
