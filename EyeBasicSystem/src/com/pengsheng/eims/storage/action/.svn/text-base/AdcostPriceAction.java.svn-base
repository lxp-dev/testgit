package com.pengsheng.eims.storage.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.BrandTempPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.AdcostPriceMgr;
import com.pengsheng.eims.storage.mgr.AdjustmentPriceMgr;
import com.pengsheng.eims.storage.persistence.AdcostPriceEntryPo;
import com.pengsheng.eims.storage.persistence.AdcostPricePo;
import com.pengsheng.eims.storage.persistence.AdjustmentPriceEntryPo;
import com.pengsheng.eims.storage.persistence.AdjustmentPricePo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class AdcostPriceAction extends BaseAction {
	
	private BrandTempPo brandTempPo; 
	
	private BrandPo brandPo;
	
	private List<GoodsInfoPo> goodsInfoPos;
	
	private AdjustmentPriceMgr adjustmentPriceMgr;
	
	public AdjustmentPriceMgr getAdjustmentPriceMgr() {
		return adjustmentPriceMgr;
	}
	public void setAdjustmentPriceMgr(AdjustmentPriceMgr adjustmentPriceMgr) {
		this.adjustmentPriceMgr = adjustmentPriceMgr;
	}
	
    public List<GoodsInfoPo> getGoodsInfoPos() {
		return goodsInfoPos;
	}

	public void setGoodsInfoPos(List<GoodsInfoPo> goodsInfoPos) {
		this.goodsInfoPos = goodsInfoPos;
	}
	
	public BrandPo getBrandPo() {
		return brandPo;
	}

	public void setBrandPo(BrandPo brandPo) {
		this.brandPo = brandPo;
	}
	private List<BrandPo> brandlist;
	
	private PersonPermissionMgr personPermissionMgr;
	
	private GoodsInfoTempPo goodsInfoTempPo;
	
	private AdcostPriceMgr adcostPriceMgr;
	
	private List<AdcostPricePo> adcostPriceList;
	
	private AdcostPricePo adcostPricePo;
	
	private List<AdcostPriceEntryPo> adcostPriceEntryList;
	
	private AdcostPriceEntryPo adcostPriceEntryPo;
	
    private SystemParameterMgr systemParameterMgr;
	
	private SystemParameterPo systemParameterPo;
	
	private String isFirstExec;
	
	public String getIsFirstExec() {
		return isFirstExec;
	}

	public BrandTempPo getBrandTempPo() {
		return brandTempPo;
	}



	public void setBrandTempPo(BrandTempPo brandTempPo) {
		this.brandTempPo = brandTempPo;
	}



	public List<BrandPo> getBrandlist() {
		return brandlist;
	}



	public void setBrandlist(List<BrandPo> brandlist) {
		this.brandlist = brandlist;
	}



	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
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

		
	public AdcostPriceEntryPo getAdcostPriceEntryPo() {
		return adcostPriceEntryPo;
	}

	public void setAdcostPriceEntryPo(AdcostPriceEntryPo adcostPriceEntryPo) {
		this.adcostPriceEntryPo = adcostPriceEntryPo;
	}

	public List<AdcostPriceEntryPo> getAdcostPriceEntryList() {
		return adcostPriceEntryList;
	}

	public void setAdcostPriceEntryList(
			List<AdcostPriceEntryPo> adcostPriceEntryList) {
		this.adcostPriceEntryList = adcostPriceEntryList;
	}

	public AdcostPricePo getAdcostPricePo() {
		return adcostPricePo;
	}

	public void setAdcostPricePo(AdcostPricePo adcostPricePo) {
		this.adcostPricePo = adcostPricePo;
	}

	public List<AdcostPricePo> getAdcostPriceList() {
		return adcostPriceList;
	}

	public void setAdcostPriceList(List<AdcostPricePo> adcostPriceList) {
		this.adcostPriceList = adcostPriceList;
	}

	public AdcostPriceMgr getAdcostPriceMgr() {
		return adcostPriceMgr;
	}

	public void setAdcostPriceMgr(AdcostPriceMgr adcostPriceMgr) {
		this.adcostPriceMgr = adcostPriceMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}

	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}

	/**
	 * 初始化调价查询页面
	 * @return
	 */
	public String initcostPriceSel(){
		
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
				return "selectcostPrice";
			}
		
		return SUCCESS;
	}
	
	/**
	 * 查询调价信息
	 * @return
	 */
	public String selectcostPrice(){
		
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
		
		AdcostPricePo adcostPricePo = new AdcostPricePo();
		
		//单号
		String billid = Utility.getName(request.getParameter("billID"));
		
		//单据日期
		String billidstartdate = Utility.getName(request.getParameter("billStartDate"));
		String billidenddate = Utility.getName(request.getParameter("billEndDate"));
		
		//生效日期
		String effectiveStartDate = Utility.getName(request.getParameter("effectiveStartDate"));
		String effectiveEndDate = Utility.getName(request.getParameter("effectiveEndDate"));
		
		//制单人
		String createpersonid = Utility.getName(request.getParameter("createPersonID"));
		
		//审核人
		String auditpersonid = Utility.getName(request.getParameter("auditPersonID"));
		
		//审核状态
		String auditstate = Utility.getName(request.getParameter("auditState"));
		
		//生效状态
		String effectivestate = Utility.getName(request.getParameter("effectiveState"));
		
		//制单人姓名
		String createpersonname = Utility.getName(request.getParameter("createPersonName"));
		
		//审核人姓名
		String auditpersonname = Utility.getName(request.getParameter("auditPersonName"));
		
		// 商品名称 add by ZK
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		
		
		adcostPricePo.setCpracbillid(billid);
		adcostPricePo.setCpraccreatestartdate(billidstartdate);
		adcostPricePo.setCpraccreateenddate(billidenddate);
		adcostPricePo.setCpraceffectivestartdate(effectiveStartDate);
		adcostPricePo.setCpraceffectiveenddate(effectiveEndDate);
		adcostPricePo.setCpraccreateperson(createpersonid);
		adcostPricePo.setCpracauditperson(auditpersonid);
		adcostPricePo.setCpracauditstate(auditstate);
		adcostPricePo.setCpraceffectivestate(effectivestate);
		adcostPricePo.setCpraccreatepersonname(createpersonname);
		adcostPricePo.setCpracauditpersonname(auditpersonname);
		adcostPricePo.setGoodsName(goodsName);
		
		
		request.setAttribute("selBillID",billid);
		request.setAttribute("selBillStartDate",billidstartdate);
		request.setAttribute("selBillEndDate",billidenddate);
		request.setAttribute("selEffectiveStartDate",effectiveStartDate);
		request.setAttribute("selEffectiveEndDate",effectiveEndDate);
		request.setAttribute("createPersonID",createpersonid);
		request.setAttribute("auditPersonID",auditpersonid);
		request.setAttribute("selCreatePersonName",createpersonname);
		request.setAttribute("selAuditPersonName",auditpersonname);
		request.setAttribute("selAuditState",auditstate);
		request.setAttribute("selEffectiveState",effectivestate);
		request.setAttribute("goodsName", goodsName);
		
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
		
		int count=adcostPriceMgr.getAdcostPriceCount(adcostPricePo);
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
	    adcostPriceList=adcostPriceMgr.getAdcostPriceList(adcostPricePo , page.getStart() , page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			adcostPriceList = null;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始化调价新增页面
	 */
	public String initcostPriceInsert(){
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
		
		String billID="AC"+GenerateNumber.getInstance().getGenerageNumber();
		
		adcostPricePo = new AdcostPricePo();
		adcostPricePo.setCpracbillid(billID);
		
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		
		request.setAttribute("effectiveTime", tempDate.format(calendar.getTime())); //取得当前日期 
		
		return SUCCESS;
	}
	
	/**
	 * 新增调价单
	 */
	public String adcostPriceInsert(){
		
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
		
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd" + " " + "HH:mm:ss"); 
		String nowTime = tempDate.format(new Date()); //取得当前日期 
		PersonInfoPo personInfo = (PersonInfoPo) session.get("person");
		
		if(request.getParameter("saveAndAudit")!=null){
			adcostPricePo.setCpracauditperson(personInfo.getId());
			adcostPricePo.setCpracauditstate("1");
			adcostPricePo.setCpracauditdate(nowTime);
		}else{
			adcostPricePo.setCpracauditstate("0");
		}
		
		adcostPriceEntryList = new ArrayList<AdcostPriceEntryPo>();
		
		for(int i=0;i<goodsInfoTempPo.getGoodsid().length;i++){
			adcostPriceEntryPo = new AdcostPriceEntryPo();
			
			adcostPriceEntryPo.setCpracebillid(adcostPricePo.getCpracbillid());
			adcostPriceEntryPo.setCpracegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			adcostPriceEntryPo.setCpracecostprice(goodsInfoTempPo.getCostprice()[i]);
			adcostPriceEntryPo.setCpracegoodsbarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			adcostPriceEntryPo.setCpracegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			adcostPriceEntryPo.setCpraceadprice(goodsInfoTempPo.getAdprice()[i]);
			adcostPriceEntryList.add(adcostPriceEntryPo);
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent(adcostPricePo.getCpracbillid());
		
		adcostPricePo.setCpraccreatedate(nowTime);
		adcostPricePo.setCpraccreateperson(personInfo.getId());
		
		if (Utility.getName(adcostPricePo.getCprapflag()).equals("0")){  //实时调价
			if(!Utility.getName(request.getParameter("saveAndAudit")).equals("")){
				adcostPricePo.setCpraceffectivedate(nowTime);
				adcostPricePo.setCpraceffectivestate("1");
			}else{
				adcostPricePo.setCpraceffectivedate("");
				adcostPricePo.setCpraceffectivestate("0");
			}
		}else{
			adcostPricePo.setCpraceffectivestate("0");
		}
		
		this.adcostPriceMgr.insertAdcostPrice(adcostPricePo, adcostPriceEntryList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
		
	}
	
	/**
	 * 初始化调价更新页面
	 */
	public String initcostPriceUpdate(){
		
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
		
		AdcostPricePo po = new AdcostPricePo();
		po.setCpracbillid(Utility.getName(request.getParameter("bid")));
		
		adcostPricePo=adcostPriceMgr.getAdcostPrice(po);
		
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		
		request.setAttribute("bid", po.getCpracbillid());
		request.setAttribute("effectiveTime", tempDate.format(calendar.getTime())); //取得当前日期 
		
		adcostPriceEntryList=adcostPriceMgr.getAdcostPriceEntryList(po);
		
		return SUCCESS;
	}
	
	/**
	 * 修改调价单
	 */
	public String adcostPriceUpdate(){
		
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
		
		adcostPricePo.setCpracbillid(Utility.getName(request.getParameter("bid")));
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd" + " " + "HH:mm:ss"); 
		String nowTime = tempDate.format(new Date()); //取得当前日期 
		PersonInfoPo personInfo = (PersonInfoPo) session.get("person");
		
		if(request.getParameter("saveAndAudit")!=null){			
			adcostPricePo.setCpracauditstate("1");
			adcostPricePo.setCpracauditperson(personInfo.getId());
			adcostPricePo.setCpracauditdate(nowTime);
		}else{
			adcostPricePo.setCpracauditstate("0");
		}
		
		adcostPriceEntryList = new ArrayList<AdcostPriceEntryPo>();
		
		for(int i=0;i<goodsInfoTempPo.getGoodsid().length;i++){
			
			adcostPriceEntryPo = new AdcostPriceEntryPo();
			adcostPriceEntryPo.setCpracebillid(adcostPricePo.getCpracbillid());
			adcostPriceEntryPo.setCpracegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			adcostPriceEntryPo.setCpracecostprice(goodsInfoTempPo.getCostprice()[i]);
			adcostPriceEntryPo.setCpracegoodsbarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			adcostPriceEntryPo.setCpracegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			adcostPriceEntryPo.setCpraceadprice(goodsInfoTempPo.getAdprice()[i]);
			
			adcostPriceEntryList.add(adcostPriceEntryPo);
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent(adcostPricePo.getCpracbillid());
		
		if (Utility.getName(adcostPricePo.getCprapflag()).equals("0")){  //实时调价
			if(!Utility.getName(request.getParameter("saveAndAudit")).equals("")){
				adcostPricePo.setCpraceffectivedate(nowTime);
				adcostPricePo.setCpraceffectivestate("1");
			}else{
				adcostPricePo.setCpraceffectivedate("");
				adcostPricePo.setCpraceffectivestate("0");
			}
		}else{
			adcostPricePo.setCpraceffectivestate("0");
		}
		
		adcostPriceMgr.updateAdcostPrice(adcostPricePo, adcostPriceEntryList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
		
	}
	
	/**
	 * 初始化调价删除页面
	 */
	public String initAdcostPriceDelete(){
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
		
		request.setAttribute("bid", request.getParameter("bid"));
		
		return SUCCESS;
	}
	
	/**
	 * 删除调价单
	 */
	public String adcostPriceDelete(){
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
		
		adcostPricePo = new AdcostPricePo();
		adcostPricePo.setCpracbillid(Utility.getName(request.getParameter("bid")));
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent(adcostPricePo.getCpracbillid());
		
		adcostPriceMgr.deleteAdcostPrice(adcostPricePo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化调价单详细页面
	 */
	public String initAdcostPriceDetails(){
		
		AdcostPricePo po = new AdcostPricePo();
		po.setCpracbillid(Utility.getName(request.getParameter("bid")));
		
		adcostPricePo=adcostPriceMgr.getAdcostPrice(po);
		
		adcostPriceEntryList=adcostPriceMgr.getAdcostPriceEntryList(po);
		
		return SUCCESS;
	}
	/**
	 * 初始化品种调价新增页面(成本)
	 */
	public String initBrandPriceInsert2()
	{
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
		String billID="AC"+GenerateNumber.getInstance().getGenerageNumber();
		
		adcostPricePo = new AdcostPricePo();
		adcostPricePo.setCpracbillid(billID);
		
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		
		request.setAttribute("effectiveTime", tempDate.format(calendar.getTime())); //取得当前日期 
		
		return SUCCESS;
	}
	/**
	 * 品种调价新增（成本）
	 */
	public String brandPriceInsert2()
	{

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
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd" + " " + "HH:mm:ss"); 
		String nowTime = tempDate.format(new Date()); //取得当前日期 
		PersonInfoPo personInfo = (PersonInfoPo) session.get("person");
		
		if(request.getParameter("saveAndAudit")!=null){
			adcostPricePo.setCpracauditperson(personInfo.getId());
			adcostPricePo.setCpracauditstate("1");
			adcostPricePo.setCpracauditdate(nowTime);
		}else{
			adcostPricePo.setCpracauditstate("0");
		}
		
		
		//组装
		adcostPriceEntryList = new ArrayList<AdcostPriceEntryPo>();
		for(int i=0;i<brandTempPo.getBrandid().length;i++){
			brandPo=new BrandPo();
			brandPo.setBbdremark(adcostPricePo.getCpracbillid());
			brandPo.setBbdid(brandTempPo.getBrandid()[i]);
			brandPo.setBbdsupplierid(brandTempPo.getSupplierid()[i]);
			brandPo.setBspcategoryid(brandTempPo.getCategoryid()[i]);
			brandPo.setBbdcostprice(brandTempPo.getCostprice()[i]);//成本价
			brandPo.setBbdmaxretailPrice(brandTempPo.getUpdatecostprice()[i]);//调整后成本价
			List<AdcostPriceEntryPo> adcostPriceEntryTempList =adcostPriceMgr.getAdcostPriceEntryList(brandPo);
			adcostPriceEntryList.addAll(adcostPriceEntryTempList);//拼装详细
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent(adcostPricePo.getCpracbillid());
		
		adcostPricePo.setCpraccreatedate(nowTime);
		adcostPricePo.setCpraccreateperson(personInfo.getId());
		
		if (Utility.getName(adcostPricePo.getCprapflag()).equals("0")){  //实时调价
			if(!Utility.getName(request.getParameter("saveAndAudit")).equals("")){
				adcostPricePo.setCpraceffectivedate(nowTime);
				adcostPricePo.setCpraceffectivestate("1");
			}else{
				adcostPricePo.setCpraceffectivedate("");
				adcostPricePo.setCpraceffectivestate("0");
			}
		}else{
			adcostPricePo.setCpraceffectivestate("0");
		}
		adcostPricePo.setCpracremark("按品种进行调价");
		this.adcostPriceMgr.insertAdcostPrice(adcostPricePo, adcostPriceEntryList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;

	}
	/**
	 * 查询商品信息
	 * 2013-08-03
	 * yangyang
	 * @return
	 * @throws Exception
	 */
	public String addAdcostPrice() throws Exception {
		
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
		
		String[] tdgoodsids = Utility.getName(request.getParameter("tdgoodsids")).split(",");
		String[] tdvs = Utility.getName(request.getParameter("tdvs")).split(",");
		if(goodsInfoTempPo != null){
			for (int i = 0; i < goodsInfoTempPo.getGoodsid().length; i++) {
				tdgoodsids =  insert(tdgoodsids, goodsInfoTempPo.getGoodsid()[i]) ;
				tdvs = insert(tdvs,goodsInfoTempPo.getAdprice()[i]);
			}
		}
		
		List<String> goodsidslist = new ArrayList<String>();
		List<String> vslist = new ArrayList<String>();
		for(int i=0; i< tdgoodsids.length; i++){
			if (!goodsidslist.contains(tdgoodsids[i])){
				goodsidslist.add(tdgoodsids[i].toString());
				vslist.add(tdvs[i].toString());
			}
		}
		
		goodsInfoPos= adjustmentPriceMgr.selectDimensionPos(goodsidslist, vslist,request.getParameter("whichretails"));
		if(!"".equals(Utility.getName(request.getParameter("justType")))){
			if("update".equals(Utility.getName(request.getParameter("justType")))){
				AdcostPricePo po = new AdcostPricePo();
				po.setCpracbillid(Utility.getName(request.getParameter("bid")));
				
				adcostPricePo=adcostPriceMgr.getAdcostPrice(po);
				
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd"); 
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DATE, 1);
				
				request.setAttribute("bid", po.getCpracbillid());
				request.setAttribute("effectiveTime", tempDate.format(calendar.getTime())); //取得当前日期 
				request.setAttribute("tdgoodsids", request.getParameter("tdgoodsids"));
				request.setAttribute("tdvs", request.getParameter("tdvs"));

				adcostPriceEntryList=adcostPriceMgr.getAdcostPriceEntryList(po);
				return "UPDATE";
			}
		}
		
		return SUCCESS;
	} 

	private static String[] insert(String[] arr, String str){
		int size = arr.length;
		String[] tmp = new String[size + 1];
		System.arraycopy(arr, 0, tmp, 0, size);
		tmp[size] = str;
		return tmp;
	}
}
