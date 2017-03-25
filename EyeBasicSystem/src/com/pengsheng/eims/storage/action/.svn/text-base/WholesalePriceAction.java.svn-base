package com.pengsheng.eims.storage.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.BrandTempPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.AdjustmentPriceMgr;
import com.pengsheng.eims.storage.mgr.WholesalePriceMgr;
import com.pengsheng.eims.storage.persistence.AdcostPricePo;
import com.pengsheng.eims.storage.persistence.WholesalePriceEntryPo;
import com.pengsheng.eims.storage.persistence.WholesalePricePo;
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

public class WholesalePriceAction extends BaseAction{
	
	private BrandTempPo brandTempPo; 
	
	private BrandPo brandPo;

	private List<BrandPo> brandlist;
	
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
	public BrandTempPo getBrandTempPo() {
		return brandTempPo;
	}

	public void setBrandTempPo(BrandTempPo brandTempPo) {
		this.brandTempPo = brandTempPo;
	}

	public BrandPo getBrandPo() {
		return brandPo;
	}

	public void setBrandPo(BrandPo brandPo) {
		this.brandPo = brandPo;
	}

	public List<BrandPo> getBrandlist() {
		return brandlist;
	}

	public void setBrandlist(List<BrandPo> brandlist) {
		this.brandlist = brandlist;
	}

	private PersonPermissionMgr personPermissionMgr;
	
    private SystemParameterMgr systemParameterMgr;
	
	private SystemParameterPo systemParameterPo;
	
	private String isFirstExec;
	
	public String getIsFirstExec() {
		return isFirstExec;
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

	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	private WholesalePriceMgr wholesalePriceMgr;
	
	public WholesalePriceMgr getWholesalePriceMgr() {
		return wholesalePriceMgr;
	}
	public void setWholesalePriceMgr(WholesalePriceMgr wholesalePriceMgr) {
		this.wholesalePriceMgr = wholesalePriceMgr;
	}
	
	private GoodsInfoTempPo goodsInfoTempPo;
	
	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}
	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}
	
	private WholesalePriceEntryPo wholesalePriceEntryPo;

	public WholesalePriceEntryPo getWholesalePriceEntryPo() {
		return wholesalePriceEntryPo;
	}
	public void setWholesalePriceEntryPo(
			WholesalePriceEntryPo wholesalePriceEntryPo) {
		this.wholesalePriceEntryPo = wholesalePriceEntryPo;
	}

	private List<WholesalePriceEntryPo> wholesalePriceEntryList;
	
	public List<WholesalePriceEntryPo> getWholesalePriceEntryList() {
		return wholesalePriceEntryList;
	}
	public void setWholesalePriceEntryList(
			List<WholesalePriceEntryPo> wholesalePriceEntryList) {
		this.wholesalePriceEntryList = wholesalePriceEntryList;
	}
	
	private List<WholesalePricePo> wholesalePriceList;
	
	public List<WholesalePricePo> getWholesalePriceList() {
		return wholesalePriceList;
	}
	public void setWholesalePriceList(List<WholesalePricePo> wholesalePriceList) {
		this.wholesalePriceList = wholesalePriceList;
	}
	
	private WholesalePricePo wholesalePricePo;
	
	public WholesalePricePo getWholesalePricePo() {
		return wholesalePricePo;
	}
	public void setWholesalePricePo(WholesalePricePo wholesalePricePo) {
		this.wholesalePricePo = wholesalePricePo;
	}
	
	/**
	 * 初始化调价查询页面
	 */
	public String initWholesalePriceSel()
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
		
		 systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
				this.setIsFirstExec("1");
				return "wholesalePriceSel";
			}
		
		return SUCCESS;
	}

	/**
	 * 初始化调价更新页面
	 */
	public String initWholesalePriceUpdate()
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
		WholesalePricePo po = new WholesalePricePo();
		po.setCprwpbillid(Utility.getName(request.getParameter("bid")));
		
		wholesalePricePo=wholesalePriceMgr.getWholesalePrice(po);
		
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		
		request.setAttribute("bid", po.getCprwpbillid());
		request.setAttribute("effectiveTime", tempDate.format(calendar.getTime())); //取得当前日期 
		
		wholesalePriceEntryList=wholesalePriceMgr.getWholesalePriceEntryList(wholesalePricePo);
		return SUCCESS;
	}
	/**
	 * 初始化调价新增页面
	 */
	public String initWholesalePriceInsert()
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
		String billID="WP"+GenerateNumber.getInstance().getGenerageNumber();
		
		wholesalePricePo=new WholesalePricePo();
		wholesalePricePo.setCprwpbillid(billID);
		
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		
		request.setAttribute("effectiveTime", tempDate.format(calendar.getTime())); //取得当前日期 
		return SUCCESS;
	}
	/**
	 * 新增调价单
	 */
	public String wholesalePriceInsert()
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
			wholesalePricePo.setCprwpauditperson(personInfo.getId());
			wholesalePricePo.setCprwpauditstate("1");
			wholesalePricePo.setCprwpauditdate(nowTime);
		}else{
			wholesalePricePo.setCprwpauditstate("0");
		}
		
		wholesalePriceEntryList = new ArrayList<WholesalePriceEntryPo>();
		for(int i=0;i<goodsInfoTempPo.getGoodsid().length;i++){
			wholesalePriceEntryPo = new WholesalePriceEntryPo();
			wholesalePriceEntryPo.setCprwpebillid(wholesalePricePo.getCprwpbillid());
			wholesalePriceEntryPo.setCprwpegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			wholesalePriceEntryPo.setCprwpecostprice(goodsInfoTempPo.getCostprice()[i]);
			wholesalePriceEntryPo.setCprwpegoodsbarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			wholesalePriceEntryPo.setCprwpegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			wholesalePriceEntryPo.setCprwpeadprice(goodsInfoTempPo.getAdprice()[i]);
			wholesalePriceEntryList.add(wholesalePriceEntryPo);
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent(wholesalePricePo.getCprwpbillid());
		
		if (Utility.getName(wholesalePricePo.getCprwpflag()).equals("0")){  //实时调价
			if(!Utility.getName(request.getParameter("saveAndAudit")).equals("")){
				wholesalePricePo.setCprwpeffectivedate(nowTime);
				wholesalePricePo.setCprwpeffectiveState("1");
			}else{
				wholesalePricePo.setCprwpeffectivedate("");
				wholesalePricePo.setCprwpeffectiveState("0");
			}
		}else{
			wholesalePricePo.setCprwpeffectiveState("0");
		}
		
		wholesalePricePo.setCprwpcreatedate(nowTime);
		wholesalePricePo.setCprwpcreateperson(personInfo.getId());
		
		this.wholesalePriceMgr.insertWholesalePrice(wholesalePricePo,wholesalePriceEntryList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	/**
	 * 初始化调价删除页面
	 */
	public String initWholesalePriceDelete()
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
		request.setAttribute("bid", request.getParameter("bid"));
		return SUCCESS;
	}
	/**
	 * 删除调价单
	 */
	public String wholesalePriceDelete()
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
		wholesalePricePo = new WholesalePricePo();
		wholesalePricePo.setCprwpbillid(Utility.getName(request.getParameter("bid")));
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent(wholesalePricePo.getCprwpbillid());

		wholesalePriceMgr.deleteWholesalePrice(wholesalePricePo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	/**
	 * 初始化调价单明细页面
	 */
	public String initWholesalePriceDetails()
	{
		WholesalePricePo po = new WholesalePricePo();
		po.setCprwpbillid(Utility.getName(request.getParameter("bid")));
		
		wholesalePricePo=wholesalePriceMgr.getWholesalePrice(po);
		
		wholesalePriceEntryList=wholesalePriceMgr.getWholesalePriceEntryList(wholesalePricePo);
		return SUCCESS;
	}
	
	/**
	 * 查询调价单
	 */
	public String wholesalePriceSel()
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
		
		wholesalePricePo=new WholesalePricePo();
		wholesalePricePo.setCprwpbillid(Utility.getName(request.getParameter("billID")));
		wholesalePricePo.setCprwpcreatestartdate((Utility.getName(request.getParameter("billStartDate"))));
		wholesalePricePo.setCprwpcreateenddate(Utility.getName(request.getParameter("billEndDate")));
		wholesalePricePo.setCprwpeffectivestartdate(Utility.getName(request.getParameter("effectiveStartDate")));
		wholesalePricePo.setCprwpeffectiveenddate(Utility.getName(request.getParameter("effectiveEndDate")));
		wholesalePricePo.setCprwpcreateperson(Utility.getName(request.getParameter("createPersonID")));
		wholesalePricePo.setCprwpauditperson(Utility.getName(request.getParameter("auditPersonID")));
		wholesalePricePo.setCprwpauditstate(Utility.getName(request.getParameter("auditState")));
		wholesalePricePo.setCprwpeffectivestate(Utility.getName(request.getParameter("effectiveState")));
		wholesalePricePo.setCprwpcreatepersonname(Utility.getName(request.getParameter("createPersonName")));
		wholesalePricePo.setCprwpauditpersonname(Utility.getName(request.getParameter("auditPersonName")));
		//TODO add by ZK query for goodsName
		wholesalePricePo.setGoodsName(Utility.getName(request.getParameter("goodsName")));
		
		request.setAttribute("selBillID",wholesalePricePo.getCprwpbillid());
		request.setAttribute("selBillStartDate",wholesalePricePo.getCprwpcreatestartdate());
		request.setAttribute("selBillEndDate",wholesalePricePo.getCprwpcreateenddate());
		request.setAttribute("selEffectiveStartDate",wholesalePricePo.getCprwpeffectivestartdate());
		request.setAttribute("selEffectiveEndDate",wholesalePricePo.getCprwpeffectiveenddate());
		request.setAttribute("selCreatePersonID",wholesalePricePo.getCprwpcreateperson());
		request.setAttribute("selAuditPersonID",wholesalePricePo.getCprwpauditperson());
		request.setAttribute("selCreatePersonName",wholesalePricePo.getCprwpcreatepersonname());
		request.setAttribute("selAuditPersonName",wholesalePricePo.getCprwpauditpersonname());
		request.setAttribute("selAuditState",wholesalePricePo.getCprwpauditstate());
		request.setAttribute("selEffectiveState",wholesalePricePo.getCprwpeffectivestate());
		request.setAttribute("goodsName", wholesalePricePo.getGoodsName());
		
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
		
		int count=wholesalePriceMgr.getWholesalePriceCount(wholesalePricePo);
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
	    wholesalePriceList=wholesalePriceMgr.getWholesalePriceList(wholesalePricePo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			wholesalePriceList = null;
		}
		
		return SUCCESS;
	}
	/**
	 * 修改调价单
	 */
	public String wholesalePriceUpdate() throws Exception {
		
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
		
		wholesalePricePo.setCprwpbillid(Utility.getName(request.getParameter("bid")));
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd" + " " + "HH:mm:ss"); 
		String nowTime = tempDate.format(new Date()); //取得当前日期 
		PersonInfoPo personInfo = (PersonInfoPo) session.get("person");
		
		if(request.getParameter("saveAndAudit")!=null){
			wholesalePricePo.setCprwpauditstate("1");
			wholesalePricePo.setCprwpauditperson(personInfo.getId());
			wholesalePricePo.setCprwpauditdate(nowTime);
		}else{
			wholesalePricePo.setCprwpauditstate("0");
		}
		
		wholesalePriceEntryList = new ArrayList<WholesalePriceEntryPo>();
		for(int i=0;i<goodsInfoTempPo.getGoodsid().length;i++){
			wholesalePriceEntryPo = new WholesalePriceEntryPo();
			wholesalePriceEntryPo.setCprwpebillid(wholesalePricePo.getCprwpbillid());
			wholesalePriceEntryPo.setCprwpegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			wholesalePriceEntryPo.setCprwpecostprice(goodsInfoTempPo.getCostprice()[i]);
			wholesalePriceEntryPo.setCprwpegoodsbarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			wholesalePriceEntryPo.setCprwpegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			wholesalePriceEntryPo.setCprwpeadprice(goodsInfoTempPo.getAdprice()[i]);
			wholesalePriceEntryList.add(wholesalePriceEntryPo);
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent(wholesalePricePo.getCprwpbillid());

		if (Utility.getName(wholesalePricePo.getCprwpflag()).equals("0")){  //实时调价
			if(!Utility.getName(request.getParameter("saveAndAudit")).equals("")){
				wholesalePricePo.setCprwpeffectivedate(nowTime);
				wholesalePricePo.setCprwpeffectiveState("1");
			}else{
				wholesalePricePo.setCprwpeffectivedate("");
				wholesalePricePo.setCprwpeffectiveState("0");
			}
		}else{
			wholesalePricePo.setCprwpeffectiveState("0");
		}
		
		wholesalePriceMgr.updateWholesalePrice(wholesalePricePo,wholesalePriceEntryList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	/**
	 * 初始化品种调价新增页面（批发价）
	 */
	public String initBrandPriceInsert3()
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
		String billID="WP"+GenerateNumber.getInstance().getGenerageNumber();
		
		wholesalePricePo=new WholesalePricePo();
		wholesalePricePo.setCprwpbillid(billID);
		
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		
		request.setAttribute("effectiveTime", tempDate.format(calendar.getTime())); //取得当前日期 
		return SUCCESS;
	}
	/**
	 * 品种调价新增（批发价）
	 */
	public String brandPriceInsert3()
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
			wholesalePricePo.setCprwpauditperson(personInfo.getId());
			wholesalePricePo.setCprwpauditstate("1");
			wholesalePricePo.setCprwpauditdate(nowTime);
		}else{
			wholesalePricePo.setCprwpauditstate("0");
		}
		//组装
		wholesalePriceEntryList = new ArrayList<WholesalePriceEntryPo>();
		for(int i=0;i<brandTempPo.getBrandid().length;i++){
			brandPo=new BrandPo();
			brandPo.setBbdremark(wholesalePricePo.getCprwpbillid());
			brandPo.setBbdid(brandTempPo.getBrandid()[i]);
			brandPo.setBbdsupplierid(brandTempPo.getSupplierid()[i]);
			brandPo.setBspcategoryid(brandTempPo.getCategoryid()[i]);
			brandPo.setBbdwholesaleprice(brandTempPo.getWholesaleprice()[i]);//批发价
			brandPo.setBbdmaxretailPrice(brandTempPo.getUpdatewholesaleprice()[i]);//调整后批发价
			List<WholesalePriceEntryPo> wholesalePriceEntryTempList =wholesalePriceMgr.getWholesalePriceEntryList(brandPo);
			wholesalePriceEntryList.addAll(wholesalePriceEntryTempList);//拼装详细
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent(wholesalePricePo.getCprwpbillid());
		
		if (Utility.getName(wholesalePricePo.getCprwpflag()).equals("0")){  //实时调价
			if(!Utility.getName(request.getParameter("saveAndAudit")).equals("")){
				wholesalePricePo.setCprwpeffectivedate(nowTime);
				wholesalePricePo.setCprwpeffectiveState("1");
			}else{
				wholesalePricePo.setCprwpeffectivedate("");
				wholesalePricePo.setCprwpeffectiveState("0");
			}
		}else{
			wholesalePricePo.setCprwpeffectiveState("0");
		}
		
		wholesalePricePo.setCprwpcreatedate(nowTime);
		wholesalePricePo.setCprwpcreateperson(personInfo.getId());
		wholesalePricePo.setCprwpremark("按品种进行调价");
		
		this.wholesalePriceMgr.insertWholesalePrice(wholesalePricePo,wholesalePriceEntryList,logPo);
		
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
	public String addWholesalePrice() throws Exception {
		
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
				WholesalePricePo po = new WholesalePricePo();
				po.setCprwpbillid(Utility.getName(request.getParameter("bid")));
				
				wholesalePricePo=wholesalePriceMgr.getWholesalePrice(po);
				
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd"); 
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DATE, 1);
				
				request.setAttribute("bid", po.getCprwpbillid());
				request.setAttribute("effectiveTime", tempDate.format(calendar.getTime())); //取得当前日期 

				request.setAttribute("tdgoodsids", request.getParameter("tdgoodsids"));
						request.setAttribute("tdvs", request.getParameter("tdvs"));
				wholesalePriceEntryList=wholesalePriceMgr.getWholesalePriceEntryList(wholesalePricePo);
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
