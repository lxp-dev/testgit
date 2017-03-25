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
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.AdjustmentPriceMgr;
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

public class AdjustmentPriceAction extends BaseAction{
	
	private PersonPermissionMgr personPermissionMgr;
	
	private BrandTempPo brandTempPo; 
	
	private List<BrandPo> brandlist;
	
	private BrandPo brandPo;
	
	private List<GoodsInfoPo> goodsInfoPos;
	
    public List<GoodsInfoPo> getGoodsInfoPos() {
		return goodsInfoPos;
	}

	public void setGoodsInfoPos(List<GoodsInfoPo> goodsInfoPos) {
		this.goodsInfoPos = goodsInfoPos;
	}

	private SystemParameterMgr systemParameterMgr;
	
	private SystemParameterPo systemParameterPo;
	
	private String isFirstExec;	
	
	public List<BrandPo> getBrandlist() {
		return brandlist;
	}

	public BrandPo getBrandPo() {
		return brandPo;
	}



	public void setBrandPo(BrandPo brandPo) {
		this.brandPo = brandPo;
	}



	public void setBrandlist(List<BrandPo> brandlist) {
		this.brandlist = brandlist;
	}

	public BrandTempPo getBrandTempPo() {
		return brandTempPo;
	}

	public void setBrandTempPo(BrandTempPo brandTempPo) {
		this.brandTempPo = brandTempPo;
	}

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

	private AdjustmentPriceMgr adjustmentPriceMgr;
	
	public AdjustmentPriceMgr getAdjustmentPriceMgr() {
		return adjustmentPriceMgr;
	}
	public void setAdjustmentPriceMgr(AdjustmentPriceMgr adjustmentPriceMgr) {
		this.adjustmentPriceMgr = adjustmentPriceMgr;
	}
	
	private GoodsInfoTempPo goodsInfoTempPo;
	
	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}
	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}
	
	private AdjustmentPriceEntryPo adjustmentPriceEntryPo;

	public AdjustmentPriceEntryPo getAdjustmentPriceEntryPo() {
		return adjustmentPriceEntryPo;
	}
	public void setAdjustmentPriceEntryPo(
			AdjustmentPriceEntryPo adjustmentPriceEntryPo) {
		this.adjustmentPriceEntryPo = adjustmentPriceEntryPo;
	}

	private List<AdjustmentPriceEntryPo> adjustmentPriceEntryList;
	
	public List<AdjustmentPriceEntryPo> getAdjustmentPriceEntryList() {
		return adjustmentPriceEntryList;
	}
	public void setAdjustmentPriceEntryList(
			List<AdjustmentPriceEntryPo> adjustmentPriceEntryList) {
		this.adjustmentPriceEntryList = adjustmentPriceEntryList;
	}
	
	private List<AdjustmentPricePo> adjustmentPriceList;
	
	public List<AdjustmentPricePo> getAdjustmentPriceList() {
		return adjustmentPriceList;
	}
	public void setAdjustmentPriceList(List<AdjustmentPricePo> adjustmentPriceList) {
		this.adjustmentPriceList = adjustmentPriceList;
	}
	
	private AdjustmentPricePo adjustmentPricePo;
	
	public AdjustmentPricePo getAdjustmentPricePo() {
		return adjustmentPricePo;
	}
	public void setAdjustmentPricePo(AdjustmentPricePo adjustmentPricePo) {
		this.adjustmentPricePo = adjustmentPricePo;
	}
	
	/**
	 * 初始化调价查询页面
	 */
	public String initAdjustmentPriceSel()
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
				return "adjustmentPriceSel";
			}
		
		return SUCCESS;
	}

	/**
	 * 初始化调价更新页面
	 */
	public String initAdjustmentPriceUpdate()
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
		AdjustmentPricePo po = new AdjustmentPricePo();
		po.setCprapbillid(Utility.getName(request.getParameter("bid")));
		
		adjustmentPricePo=adjustmentPriceMgr.getAdjuestmentPrice(po);
		
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		
		request.setAttribute("bid", po.getCprapbillid());
		request.setAttribute("effectiveTime", tempDate.format(calendar.getTime())); //取得当前日期 
		
		adjustmentPriceEntryList=adjustmentPriceMgr.getAdjuestmentPriceEntryList(adjustmentPricePo);
		return SUCCESS;
	}
	/**
	 * 初始化品种调价新增页面（零售价）
	 */
	public String initBrandPriceInsert()
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
		String billID="PC"+GenerateNumber.getInstance().getGenerageNumber();
		
		adjustmentPricePo=new AdjustmentPricePo();
		adjustmentPricePo.setCprapbillid(billID);
		
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		
		request.setAttribute("effectiveTime", tempDate.format(calendar.getTime())); //取得当前日期 
		return SUCCESS;
	}
	/**
	 * 品种调价新增（零售价）
	 */
	public String brandPriceInsert(){
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
		
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd" + " " + "HH:mm:ss"); 
		String nowTime = tempDate.format(new Date()); //取得当前日期 
		
		PersonInfoPo personInfo = (PersonInfoPo) session.get("person");
		
		if(request.getParameter("saveAndAudit")!=null){
			adjustmentPricePo.setCprapauditperson(personInfo.getId());
			adjustmentPricePo.setCprapauditstate("1");
			adjustmentPricePo.setCprapauditdate(nowTime);
		}else{
			adjustmentPricePo.setCprapauditstate("0");
		}
		//组装
		adjustmentPriceEntryList = new ArrayList<AdjustmentPriceEntryPo>();
		for(int i=0;i<brandTempPo.getBrandid().length;i++){
			brandPo=new BrandPo();
			brandPo.setBbdremark(adjustmentPricePo.getCprapbillid());
			brandPo.setBbdid(brandTempPo.getBrandid()[i]);
			brandPo.setBbdsupplierid(brandTempPo.getSupplierid()[i]);
			brandPo.setBspcategoryid(brandTempPo.getCategoryid()[i]);
			brandPo.setBbdretailprice(brandTempPo.getRetailprice()[i]);//零售价
			brandPo.setBbdmaxretailPrice(brandTempPo.getUpdateretailprice()[i]);//调整后零售价
			brandPo.setBbdwhichretail(adjustmentPricePo.getCprapwhichprice());//调整后零售价
			List<AdjustmentPriceEntryPo> adjustmentPriceEntryTempList =adjustmentPriceMgr.getAdjuestmentPriceEntryList(brandPo);
			adjustmentPriceEntryList.addAll(adjustmentPriceEntryTempList);//拼装详细
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent(adjustmentPricePo.getCprapbillid());
		
		if (Utility.getName(adjustmentPricePo.getCprapflag()).equals("0")){  //实时调价
			if(!Utility.getName(request.getParameter("saveAndAudit")).equals("")){
				adjustmentPricePo.setCprapeffectivedate(nowTime);
				adjustmentPricePo.setCprapeffectiveState("1");
			}else{
				adjustmentPricePo.setCprapeffectivedate("");
				adjustmentPricePo.setCprapeffectiveState("0");
			}
		}else{
			adjustmentPricePo.setCprapeffectiveState("0");
		}
		
		adjustmentPricePo.setCprapcreatedate(nowTime);
		adjustmentPricePo.setCprapcreateperson(personInfo.getId());
		adjustmentPricePo.setCprapremark("按品种进行调价");
		//新增零售价调价
		this.adjustmentPriceMgr.insertAdjustmentPrice(adjustmentPricePo,adjustmentPriceEntryList,logPo,systemParameterPo);//
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;

	}


	/**
	 * 初始化调价新增页面
	 */
	public String initAdjustmentPriceInsert()
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
		String billID="PC"+GenerateNumber.getInstance().getGenerageNumber();
		
		adjustmentPricePo=new AdjustmentPricePo();
		adjustmentPricePo.setCprapbillid(billID);
		
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		
		request.setAttribute("effectiveTime", tempDate.format(calendar.getTime())); //取得当前日期 
		return SUCCESS;
	}
	/**
	 * 新增调价单
	 */
	public String adjustmentPriceInsert()
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
		
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd" + " " + "HH:mm:ss"); 
		String nowTime = tempDate.format(new Date()); //取得当前日期 
		
		PersonInfoPo personInfo = (PersonInfoPo) session.get("person");
		
		if(request.getParameter("saveAndAudit")!=null){
			adjustmentPricePo.setCprapauditperson(personInfo.getId());
			adjustmentPricePo.setCprapauditstate("1");
			adjustmentPricePo.setCprapauditdate(nowTime);
		}else{
			adjustmentPricePo.setCprapauditstate("0");
		}
		
		adjustmentPriceEntryList = new ArrayList<AdjustmentPriceEntryPo>();
		for(int i=0;i<goodsInfoTempPo.getGoodsid().length;i++){
			adjustmentPriceEntryPo = new AdjustmentPriceEntryPo();
			adjustmentPriceEntryPo.setCprapebillid(adjustmentPricePo.getCprapbillid());
			adjustmentPriceEntryPo.setCprapegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			adjustmentPriceEntryPo.setCprapecostprice(goodsInfoTempPo.getCostprice()[i]);
			adjustmentPriceEntryPo.setCprapegoodsbarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			adjustmentPriceEntryPo.setCprapegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			adjustmentPriceEntryPo.setCprapeadprice(goodsInfoTempPo.getAdprice()[i]);
			adjustmentPriceEntryList.add(adjustmentPriceEntryPo);
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent(adjustmentPricePo.getCprapbillid());
		
		if (Utility.getName(adjustmentPricePo.getCprapflag()).equals("0")){  //实时调价
			if(!Utility.getName(request.getParameter("saveAndAudit")).equals("")){
				adjustmentPricePo.setCprapeffectivedate(nowTime);
				adjustmentPricePo.setCprapeffectiveState("1");
			}else{
				adjustmentPricePo.setCprapeffectivedate("");
				adjustmentPricePo.setCprapeffectiveState("0");
			}
		}else{
			adjustmentPricePo.setCprapeffectiveState("0");
		}
		
		adjustmentPricePo.setCprapcreatedate(nowTime);
		adjustmentPricePo.setCprapcreateperson(personInfo.getId());
		
		this.adjustmentPriceMgr.insertAdjustmentPrice(adjustmentPricePo,adjustmentPriceEntryList,logPo,systemParameterPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	/**
	 * 初始化调价删除页面
	 */
	public String initAdjustmentPriceDelete()
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
	public String adjustmentPriceDelete()
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
		adjustmentPricePo = new AdjustmentPricePo();
		adjustmentPricePo.setCprapbillid(Utility.getName(request.getParameter("bid")));
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent(adjustmentPricePo.getCprapbillid());

		adjustmentPriceMgr.deleteAdjustmentPrice(adjustmentPricePo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	/**
	 * 初始化调价单明细页面
	 */
	public String initAdjustmentPriceDetails()
	{
		AdjustmentPricePo po = new AdjustmentPricePo();
		po.setCprapbillid(Utility.getName(request.getParameter("bid")));
		
		adjustmentPricePo=adjustmentPriceMgr.getAdjuestmentPrice(po);
		
		adjustmentPriceEntryList=adjustmentPriceMgr.getAdjuestmentPriceEntryList(adjustmentPricePo);
		return SUCCESS;
	}
	
	/**
	 * 查询调价单
	 */
	public String adjustmentPriceSel()
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
		
		adjustmentPricePo=new AdjustmentPricePo();
		adjustmentPricePo.setCprapbillid(Utility.getName(request.getParameter("billID")));
		adjustmentPricePo.setCprapcreatestartdate((Utility.getName(request.getParameter("billStartDate"))));
		adjustmentPricePo.setCprapcreateenddate(Utility.getName(request.getParameter("billEndDate")));
		adjustmentPricePo.setCprapeffectivestartdate(Utility.getName(request.getParameter("effectiveStartDate")));
		adjustmentPricePo.setCprapeffectiveenddate(Utility.getName(request.getParameter("effectiveEndDate")));
		adjustmentPricePo.setCprapcreateperson(Utility.getName(request.getParameter("createPersonID")));
		adjustmentPricePo.setCprapauditperson(Utility.getName(request.getParameter("auditPersonID")));
		adjustmentPricePo.setCprapauditstate(Utility.getName(request.getParameter("auditState")));
		adjustmentPricePo.setCprapeffectivestate(Utility.getName(request.getParameter("effectiveState")));
		adjustmentPricePo.setCprapcreatepersonname(Utility.getName(request.getParameter("createPersonName")));
		adjustmentPricePo.setCprapauditpersonname(Utility.getName(request.getParameter("auditPersonName")));
		adjustmentPricePo.setCprapwhichprice(Utility.getName(request.getParameter("whichretail")));
		//TODO add by ZK for query goodsName begin
		adjustmentPricePo.setGoodsName(Utility.getName(request.getParameter("goodsName")));
		// add by ZK for query goodsName end
		
		request.setAttribute("selBillID",adjustmentPricePo.getCprapbillid());
		request.setAttribute("whichretail",adjustmentPricePo.getCprapwhichprice());
		request.setAttribute("selBillStartDate",adjustmentPricePo.getCprapcreatestartdate());
		request.setAttribute("selBillEndDate",adjustmentPricePo.getCprapcreateenddate());
		request.setAttribute("selEffectiveStartDate",adjustmentPricePo.getCprapeffectivestartdate());
		request.setAttribute("selEffectiveEndDate",adjustmentPricePo.getCprapeffectiveenddate());
		request.setAttribute("createPersonID",adjustmentPricePo.getCprapcreateperson());
		request.setAttribute("auditPersonID",adjustmentPricePo.getCprapauditperson());
		request.setAttribute("selCreatePersonName",adjustmentPricePo.getCprapcreatepersonname());
		request.setAttribute("selAuditPersonName",adjustmentPricePo.getCprapauditpersonname());
		request.setAttribute("selAuditState",adjustmentPricePo.getCprapauditstate());
		request.setAttribute("selEffectiveState",adjustmentPricePo.getCprapeffectivestate());
		//TODO add by ZK for query goodsName begin
		request.setAttribute("goodsName", adjustmentPricePo.getGoodsName());
		// add by ZK for query goodsName begin		
		
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
		
		int count=adjustmentPriceMgr.getAdjuestmentPriceCount(adjustmentPricePo);
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
	    adjustmentPriceList=adjustmentPriceMgr.getAdjuestmentPriceList(adjustmentPricePo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			adjustmentPriceList = null;
		}
		
		return SUCCESS;
	}
	/**
	 * 修改调价单
	 */
	public String adjustmentPriceUpdate() throws Exception {
		
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
		
		adjustmentPricePo.setCprapbillid(Utility.getName(request.getParameter("bid")));
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd" + " " + "HH:mm:ss"); 
		String nowTime = tempDate.format(new Date()); //取得当前日期 
		PersonInfoPo personInfo = (PersonInfoPo) session.get("person");
		
		if(request.getParameter("saveAndAudit")!=null){
			adjustmentPricePo.setCprapauditstate("1");
			adjustmentPricePo.setCprapauditperson(personInfo.getId());
			adjustmentPricePo.setCprapauditdate(nowTime);
		}else{
			adjustmentPricePo.setCprapauditstate("0");
		}
		
		adjustmentPriceEntryList = new ArrayList<AdjustmentPriceEntryPo>();
		for(int i=0;i<goodsInfoTempPo.getGoodsid().length;i++){
			adjustmentPriceEntryPo = new AdjustmentPriceEntryPo();
			adjustmentPriceEntryPo.setCprapebillid(adjustmentPricePo.getCprapbillid());
			adjustmentPriceEntryPo.setCprapegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			adjustmentPriceEntryPo.setCprapecostprice(goodsInfoTempPo.getCostprice()[i]);
			adjustmentPriceEntryPo.setCprapegoodsbarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			adjustmentPriceEntryPo.setCprapegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			adjustmentPriceEntryPo.setCprapeadprice(goodsInfoTempPo.getAdprice()[i]);
			adjustmentPriceEntryList.add(adjustmentPriceEntryPo);
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent(adjustmentPricePo.getCprapbillid());

		if (Utility.getName(adjustmentPricePo.getCprapflag()).equals("0")){  //实时调价
			if(!Utility.getName(request.getParameter("saveAndAudit")).equals("")){
				adjustmentPricePo.setCprapeffectivedate(nowTime);
				adjustmentPricePo.setCprapeffectiveState("1");
			}else{
				adjustmentPricePo.setCprapeffectivedate("");
				adjustmentPricePo.setCprapeffectiveState("0");
			}
		}else{
			adjustmentPricePo.setCprapeffectiveState("0");
		}
		
		adjustmentPriceMgr.updateAdjustmentPrice(adjustmentPricePo,adjustmentPriceEntryList,logPo,systemParameterPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
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
	public String addAdjustmentPrice() throws Exception {
		
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
				AdjustmentPricePo po = new AdjustmentPricePo();
				po.setCprapbillid(Utility.getName(request.getParameter("bid")));
				
				adjustmentPricePo=adjustmentPriceMgr.getAdjuestmentPrice(po);
				
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd"); 
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DATE, 1);
				
				request.setAttribute("bid", po.getCprapbillid());
				request.setAttribute("effectiveTime", tempDate.format(calendar.getTime())); //取得当前日期 

				request.setAttribute("tdgoodsids", request.getParameter("tdgoodsids"));
						request.setAttribute("tdvs", request.getParameter("tdvs"));
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
	
	/**
	 * 初始化调价单立即生效
	 */
	public String initChangePriceBillUpdate() throws Exception {
		
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

		request.setAttribute("id",Utility.getName(request.getParameter("id")));
		request.setAttribute("whichprice",Utility.getName(request.getParameter("whichprice")));
		request.setAttribute("type",Utility.getName(request.getParameter("type")));
		
		return SUCCESS;
	}
	
	/**
	 * 调价单立即生效
	 */
	public String updateChangePriceBill() throws Exception {
		
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
		
		AdjustmentPricePo appo = new AdjustmentPricePo(); 
		appo.setCprapbillid(Utility.getName(request.getParameter("id")));
		appo.setCprapwhichprice(Utility.getName(request.getParameter("whichprice")));

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("调价单：" + appo.getCprapbillid() + " 立即生效!");
		
		adjustmentPriceMgr.updateChangePriceBill(appo,Utility.getName(request.getParameter("type")),logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

}
