package com.pengsheng.eims.sales.action;

import java.text.SimpleDateFormat;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.mgr.GiftsMgr;
import com.pengsheng.eims.basic.mgr.MailingListMgr;
import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.mgr.WarehouseConfigurationMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.ForeignRecipelPo;
import com.pengsheng.eims.basic.persistence.GiftsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.MailingListPo;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.components.mgr.WindowPersonDiscountMgr;
import com.pengsheng.eims.frame.mgr.LoginMgr;
import com.pengsheng.eims.logistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.AdditionalCDetailMgr;
import com.pengsheng.eims.sales.mgr.FrameSalesMgr;
import com.pengsheng.eims.sales.mgr.InspectionMgr;
import com.pengsheng.eims.sales.mgr.SpecialPDetailMgr;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesRecipeNumViewPo;
import com.pengsheng.eims.sales.persistence.SalesSpecialPo;
import com.pengsheng.eims.sales.persistence.SpecialPDetailPo;
import com.pengsheng.eims.sales.persistence.ToMailPo;
import com.pengsheng.eims.system.mgr.AdditionalCostsMgr;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.DiscountShortcutKeysMgr;
import com.pengsheng.eims.system.mgr.PersonDiscountMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SpecialRequirementsMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.AdditionalCostsPo;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.DiscountShortcutKeysPo;
import com.pengsheng.eims.system.persistence.PersonDiscountDetailsPo;
import com.pengsheng.eims.system.persistence.PersonDiscountPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SpecialRequirementsPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class FrameSalesAction extends BaseAction {
	
	private List<SalesSpecialPo> special1List;
	private SalesSpecialPo salesSpecialPo;
	private DiscountShortcutKeysMgr discountShortcutKeysMgr;
	private InspectionMgr inspectionMgr;
	private PersonPermissionMgr personPermissionMgr;
	private FrameSalesMgr frameSalesMgr;
	private CustomerInfoPo customerInfoPo;
	private List<InspectionPo> inspectionPos;
	private SalesBasicPo salesBasicPo;
	private DepartmentsMgr departmentsMgr;
	private List<DepartmentsPo> departmentsList;
	private List<GiftsPo> giftsList;
	private GiftsMgr giftsMgr;
	private SpecialRequirementsMgr specialRequirementsMgr;
	private AdditionalCostsMgr additionalCostsMgr;
	private List<AdditionalCostsPo> additionalCostsList;
	private SalesDetailPo salesDetailPo;
	private GiftsPo giftsPo;
	private SpecialRequirementsPo specialRequirementsPo;
	private AdditionalCostsPo additionalCostsPo;
	private WarehouseConfigurationMgr warehouseConfigurationMgr;
	private AdditionalCDetailMgr additionalCDetailMgr;
	private SpecialPDetailMgr specialPDetailMgr;
	private SpecialPDetailPo specialPDetailPo;
	private AdditionalCDetailPo additionalCDetailPo;
	private PersonInfoPo personInfoPo; 
	private LoginMgr loginMgr;
	private WindowPersonDiscountMgr windowPersonDiscountMgr;
	private LogisticsLogMgr logisticsLogMgr = null;
	private List<SpecialRequirementsPo> specialList;
	private List<PersonInfoPo> personInfoPos;
	private List<PersonInfoPo> yishiPersonInfoPos;	
	private List<PersonInfoPo> optometryPersonInfoPos;
	private PersonInfoMgr personInfoMgr;
	private CompanyNameMgr companyNameMgr;
	private CompanyNamePo companyNamePo;
	private UnitMgr unitMgr;
	private List<ForeignRecipelPo> foreignRecipelPos;
	private SystemParameterPo systemParameterPo;
	private SystemParameterMgr systemParameterMgr;
	private List<DiscountShortcutKeysPo> discountShortcutKeysPolist;
	private List<OptionParamPo> optionParamPolist;
	private OptionParamMgr optionParamMgr;
	private CustomerInfoPo customerInfoPo2;
	private ToMailPo toMailPo;
	private MailingListMgr mailingListMgr;
	private List<MailingListPo> mailingList;
	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	private PersonDiscountMgr personDiscountMgr; 
	
	public String initFrameSales() throws Exception {
		/*
		 * 生成销售单号
		 */
		PersonInfoPo loginPersonInfoPo = (PersonInfoPo)session.get("person");
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String salseID = "X" + loginPersonInfoPo.getDepartmentID() + loginPersonInfoPo.getMachinery() + numHeadFormat.format(new Date());
		
		request.setAttribute("salseID", salseID);
		
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		personInfoPos = personInfoMgr.getModulePersoninfoPoList(moduleID,loginPersonInfoPo.getDepartmentID());
		
		request.setAttribute("moduleID", moduleID);
		
		if (customerInfoPo != null
				&& StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			request.removeAttribute("salseSuccessMsg");
			customerInfoPo.setSmecicustomerid("");
			customerInfoPo = frameSalesMgr.getCustomerInfo(customerInfoPo,loginPersonInfoPo);
			
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday()
						.substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR)
						- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmdown(Integer.toString(age));
			}

			// 取顾客最新验光记录
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {
				inspectionPos = frameSalesMgr.getInspectionPos(customerInfoPo
						.getSmecicustomerid());
			}
		}

		
		//框镜销售，取镜地点填充 , 所有门店
		departmentsList=departmentsMgr.getDepartments("1");
		
		//赠品填充
		GiftsPo giftsPo = new GiftsPo();
		giftsPo.setBgsflag("1");
		giftsList=giftsMgr.getGifts(giftsPo);
		
		//加工填充
		
		specialList=specialRequirementsMgr.getSpecialRequirementsList();
		
		//附加费填充
		additionalCostsList=additionalCostsMgr.getAdditionalCostsList();
		
		//打折快捷键填充
		discountShortcutKeysPolist = discountShortcutKeysMgr.getEnableDiscountShortcutKeysPoList("1");

		// 得到系统参数的信息
		companyNamePo = companyNameMgr.getCompanyName(companyNamePo);
		
		return SUCCESS;
	}
	/**
	 * 结算。 
	 * @return
	 */
	public String frameSalse(){
		
		//生成配镜单号
		PersonInfoPo personInfoPo = new PersonInfoPo();
		personInfoPo.setId(salesBasicPo.getSsesbsalerid());
		personInfoPo=personInfoMgr.getPersonInfo(personInfoPo);
		PersonInfoPo loginPersonInfoPo = (PersonInfoPo) session.get("person");
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		personInfoPos = personInfoMgr.getModulePersoninfoPoList(moduleID,loginPersonInfoPo.getDepartmentID());
		
		request.setAttribute("moduleID", moduleID);
		
		String salseID = request.getParameter("salseID");
		//销售 ,m 基表填充
		salesBasicPo.setSsesbsalesid(salseID);
		salesBasicPo.setSsesbshopcode(loginPersonInfoPo.getDepartmentID());
		salesBasicPo.setSsesbcustomerid(customerInfoPo.getSmecicustomerid());
		salesBasicPo.setSsesbsalerid(personInfoPo.getId());
		salesBasicPo.setSsesbintransit("1"); //在途。
		salesBasicPo.setSsesbvalueflag("0");
		salesBasicPo.setSsesbpostglassod(Utility.getName(salesBasicPo.getSsesbpostglassod()).equals("")?"0.00":salesBasicPo.getSsesbpostglassod());
		salesBasicPo.setSsesbpostglassos(Utility.getName(salesBasicPo.getSsesbpostglassos()).equals("")?"0.00":salesBasicPo.getSsesbpostglassos());
		salesBasicPo.setSsesbsalestype("".equals(Utility.getName(salesBasicPo.getSsesboptometryid()))?"2":"1");//销售类型 内方外方
		salesBasicPo.setSsesbdiscountrate(Utility.getName(salesBasicPo.getSsesbdiscountrate()).equals("")?"1.00":salesBasicPo.getSsesbdiscountrate());
		salesBasicPo.setSsesbarrearsvalue(Utility.getName(salesBasicPo.getSsesbarrearsvalue()).equals("")?"0.00":salesBasicPo.getSsesbarrearsvalue());
		salesBasicPo.setSsesbpsalsvalue(Utility.getName(salesBasicPo.getSsesbpsalsvalue()).equals("")?"0.00":salesBasicPo.getSsesbpsalsvalue());
		salesBasicPo.setSsesbinterhighod(salesBasicPo.getSsesbinterhighod()!=null?salesBasicPo.getSsesbinterhighod().split(",")[0]:"");
		salesBasicPo.setSsesbinterhighos(salesBasicPo.getSsesbinterhighos()!=null?salesBasicPo.getSsesbinterhighos().split(",")[0]:"");
		salesBasicPo.setSsesbinterdistanceod(salesBasicPo.getSsesbinterdistanceod()!=null?salesBasicPo.getSsesbinterdistanceod().split(",")[0]:"");
		salesBasicPo.setSsesbinterdistanceos(salesBasicPo.getSsesbinterdistanceos()!=null?salesBasicPo.getSsesbinterdistanceos().split(",")[0]:"");
		
		
		String createPerson = personInfoPo.getId(); 
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); //模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("框镜配镜单："+salseID+" 新增");
		
		
		/*
		 * 
		 * 订单类型及出仓设置
		 */
		WarehouseConfigurationPo tempWarehouseConfigurationPo = new WarehouseConfigurationPo();
		tempWarehouseConfigurationPo.setBwcdeptid(loginPersonInfoPo.getDepartmentID());
		WarehouseConfigurationPo warehouseConfigurationPo=warehouseConfigurationMgr.getWarehouseConfiguration(tempWarehouseConfigurationPo);
		salesBasicPo.setSsesborderstype("1");
		String[] ssesdstockids=new String[50];
		for(int i=1;i<salesDetailPo.getIscustomizes().length;i++){

			String goodstype = salesDetailPo.getSsesdsalesitemids()[i].substring(0, 1); 
			if("1".equals(goodstype)){
				ssesdstockids[i] = warehouseConfigurationPo.getBwcstockid1();				//镜架出仓
			}else if("2".equals(goodstype)){
				ssesdstockids[i] = warehouseConfigurationPo.getBwcstockid2();				//镜架辅料出仓
			}else if("3".equals(goodstype)){
				if("D".equals(salesDetailPo.getSsesdsalesitemids()[i].substring(8, 9))){
					ssesdstockids[i] = warehouseConfigurationPo.getBwcstockid4();			//成品镜片出仓
				}else if("0".equals(salesDetailPo.getIscustomizes()[i])){
					ssesdstockids[i] = warehouseConfigurationPo.getBwcstockid3();			//成品订制镜片出仓
				}else{
					ssesdstockids[i]=warehouseConfigurationPo.getBwcstockid3();				//自带
				}
			}
			
			if("D".equals(salesDetailPo.getIscustomizes()[i])){
				salesBasicPo.setSsesborderstype("2");
			}
			
			salesDetailPo.setSsesdstockids(ssesdstockids);
			
		}
		
		//赠品填充
		giftsPo.setBgsstockid(warehouseConfigurationPo.getBwcstockid10());
		
		
		//销售明细填充
		
		salesDetailPo.setSsesdsalesid(salseID);
		
		
		//加工插入
		String[] sesdrequirement=specialPDetailPo.getSsesdrequirement().split(",");
		for(int i=1;i<sesdrequirement.length;i++){
			SpecialPDetailPo temp = new SpecialPDetailPo();
			temp.setSsesdsalesid(salseID);
			temp.setSsesdrequirement(sesdrequirement[i]);
			specialPDetailMgr.insertSpecialPDetail(temp);
		}
		
		//附加费用插入
		String[] sseadditionalid=additionalCDetailPo.getSseadditionalid().split(",");
		String[] ssenumber = additionalCDetailPo.getSsenumber().split(",");
		for(int i=1;i<sseadditionalid.length;i++){
			AdditionalCDetailPo temp = new AdditionalCDetailPo();
			temp.setSsesalesid(salseID);
			temp.setSseadditionalid(sseadditionalid[i].trim());
			temp.setSsenumber(ssenumber[i].trim());
			additionalCDetailMgr.insertAdditionalCDetail(temp);
		}
		
		InTransitPo inTransitPo=new InTransitPo();
		inTransitPo.setSseitsalesid(salseID);
		inTransitPo.setSseitdepartment(loginPersonInfoPo.getDepartmentID());
		inTransitPo.setSseitcreateperson(personInfoPo.getId());
		
		//frameSalesMgr.insertSalesBasic(salesBasicPo,salesDetailPo,giftsPo,inTransitPo,logPo);
		
		/*
		 * 外方保存
		 */
		String recipetype = Utility.getName(request.getParameter("recipetype"));
		String nwtype = Utility.getName(request.getParameter("nwtype")); 
		if("".equals(nwtype)){
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			
			String customerID=Utility.getName(customerInfoPo.getSmecicustomerid());// 顾客号
			String optometryBasicID = "O" + loginPersonInfoPo.getDepartmentID() + loginPersonInfoPo.getMachinery() + format.format(new Date());//验光基表ID
			String optometryID = "Y" + loginPersonInfoPo.getDepartmentID() + loginPersonInfoPo.getMachinery() + format.format(new Date());// 验光号
			SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd" + " " + "HH:mm:ss"); 
			String nowTime = tempDate.format(new Date()); //取得当前日期 
			
			String optometryPerson = Utility.getName(request.getParameter("optometryPerson"));
			OptometryPo opo = new OptometryPo();
			opo.setSopoyoptometryid(optometryID);
			opo.setSopoyoptometrybasicid(optometryBasicID);
			opo.setSopoycustomerid(customerID);
			opo.setSopoyshopcode(loginPersonInfoPo.getDepartmentID());
			opo.setSopoypersonid(optometryPerson);
			opo.setSopoytime(nowTime);
			opo.setSopoyflag("1");
			opo.setSopoyupdateuserid("");
			opo.setSopoyrecipeupdatetime("");
			
			if("wbygs".equals(optometryPerson)){
				opo.setSopoyisinternal("W");
			}else{
				opo.setSopoyisinternal("");
			}
			
			OptometryBasicPo obpo = new OptometryBasicPo();
			obpo.setSopobcustomerid(customerID);
			obpo.setSopobcustomername(customerInfoPo.getSmeciname());
			obpo.setSopobmedicalendtime(nowTime);
			obpo.setSopobmedicalstarttime(nowTime);
			obpo.setSopoboptometrybasicid(optometryBasicID);
			
			List<InspectionPo> ipos = new ArrayList<InspectionPo>();
			InspectionPo ipo = new InspectionPo();
			ipo.setSopipcustomerid(customerInfoPo.getSmeciname());
			ipo.setSopipoptometrybasicid(optometryBasicID);
			ipo.setSopipoptometryid(optometryID);
			ipo.setSopipusername(optometryPerson);
			if("1".equals(recipetype)){
				ipo.setSopipglasstype("1");
			}
			if("2".equals(recipetype)){
				ipo.setSopipglasstype("2");
			}
			if("3".equals(recipetype)){
				ipo.setSopipglasstype("3");
			}
			if("4".equals(recipetype)){
				ipo.setSopipglasstype("4");
			}
			
			ipo.setSopipballglassod(salesBasicPo.getSsesbballglassod());
			ipo.setSopipballglassos(salesBasicPo.getSsesbballglassos());
			ipo.setSopippostglassod(salesBasicPo.getSsesbpostglassod());
			ipo.setSopippostglassos(salesBasicPo.getSsesbpostglassos());
			ipo.setSopipaxesod(salesBasicPo.getSsesbaxesod());
			ipo.setSopipaxesos(salesBasicPo.getSsesbaxesos());
			ipo.setSopiparriseglassod1(salesBasicPo.getSsesbarriseglassod());
			ipo.setSopiparriseglassos1(salesBasicPo.getSsesbarriseglassos());
			ipo.setSopipbasisod1(salesBasicPo.getSsesbbasisod());
			ipo.setSopipbasisos1(salesBasicPo.getSsesbbasisos());
			ipo.setSopipinterhighod(salesBasicPo.getSsesbinterhighod());
			ipo.setSopipinterhighos(salesBasicPo.getSsesbinterhighos());
			ipo.setSopipinterdistanceod(salesBasicPo.getSsesbinterdistanceod());
			ipo.setSopipinterdistanceos(salesBasicPo.getSsesbinterdistanceos());
			ipo.setSopipfarvaod(salesBasicPo.getSsesbfarvaod());
			ipo.setSopipfarvaos(salesBasicPo.getSsesbfarvaos());
			ipo.setSopipclosevaod(salesBasicPo.getSsesbclosevaod());
			ipo.setSopipclosevaos(salesBasicPo.getSsesbclosevaos());
			
			ipo.setSopipeyecurvatureod1(salesBasicPo.getSsesbeyecurvatureod1());
			ipo.setSopipeyecurvatureos1(salesBasicPo.getSsesbeyecurvatureos1());
			ipo.setSopipeyecurvatureod2(salesBasicPo.getSsesbeyecurvatureod2());
			ipo.setSopipeyecurvatureos2(salesBasicPo.getSsesbeyecurvatureos2());
			ipo.setSopipdiameterod(salesBasicPo.getSsesbdiameterod());
			ipo.setSopipdiameteros(salesBasicPo.getSsesbdiameteros());
			ipo.setSopipconlenvaod(salesBasicPo.getSsesbconlenvaod());
			ipo.setSopipconlenvaos(salesBasicPo.getSsesbconlenvaos());
			
			ipos.add(ipo);
			LogisticsLogPo logPo1 = new LogisticsLogPo();
			logPo1.setsLogName(createPerson);
			logPo1.setsLogIP(request.getRemoteAddr());
			logPo1.setsLogResult(moduleID); // 模块ID
			logPo1.setsLogOpID("1");    // 1 表示新增
			logPo1.setsLogContent("框镜外方录入验光号："+optometryID+" 新增");
			inspectionMgr.inspectionInsert(ipos,opo,obpo,logPo1);
		
		
		}
		
		/*
		 * 销售成功开窗
		 */
		String salseSuccessMsg="顾客:"+customerInfoPo.getSmeciname()+"  销售单"+salseID+"提交成功";
		request.setAttribute("url", "'initFrameSales.action?moduleID="+moduleID+"'");
		this.clearMessages();
		this.addActionMessage(getText(salseSuccessMsg));
		request.setAttribute("flag", GlobalConstants.MOVE);
		return SUCCESS;
	}
	
	public String initSalesAll() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo loginPersonInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = loginPersonInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		//将该部门对应的配镜单模版赋值到systemParameterPo
		systemParameterPo = systemParameterMgr.getSystemParameterPoDepartmentBillTemplate(systemParameterPo,loginPersonInfoPo.getDepartmentID());
		
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String salseID = "X" + loginPersonInfoPo.getDepartmentID() + loginPersonInfoPo.getMachinery() + numHeadFormat.format(new Date());		
		request.setAttribute("salseID", salseID);
		
		String optometryID = "Y" + loginPersonInfoPo.getDepartmentID() + loginPersonInfoPo.getMachinery() + numHeadFormat.format(new Date());// 验光号
		request.setAttribute("optometryID", optometryID);

		personInfoPos = personInfoMgr.getModulePersoninfoPoList("S0301",loginPersonInfoPo.getDepartmentID());
		yishiPersonInfoPos = personInfoMgr.getPersonInfosByDepartmentid("");//获得医师下拉框List
		
		optometryPersonInfoPos = personInfoMgr.getModulePersoninfoPoList("S0203",loginPersonInfoPo.getDepartmentID());

		request.setAttribute("customerprinttype", request.getParameter("customerprinttype"));
		
		if (customerInfoPo != null&& StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			request.setAttribute("begin", "1");
			request.removeAttribute("salseSuccessMsg");
			customerInfoPo.setSmecicustomerid("");
			customerInfoPo.setSmeciflag("1");
			customerInfoPo = frameSalesMgr.getCustomerInfo(customerInfoPo,loginPersonInfoPo);
			
			if(!"".equals(Utility.getName(customerInfoPo.getSmecifcustomerid()))){
				CustomerInfoPo cpo = frameSalesMgr.getCustomerFType(customerInfoPo);
				customerInfoPo.setSmecicardtype(cpo.getSmecicardtype());
				customerInfoPo.setFmmmembername(cpo.getFmmmembername());
			}
			
			
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday()
						.substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmdown(Integer.toString(age));
			}			

			// 取顾客最新验光记录
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {
				inspectionPos = frameSalesMgr.getInspectionPosAll(customerInfoPo.getSmecicustomerid());
			}
			
			if("".equals(Utility.getName(customerInfoPo.getSmeciname())))
			{
				request.setAttribute("wbd", "卡号不存在");
			}else{
				request.setAttribute("wbd", "");
			}
		}
		
		if (customerInfoPo == null){
			customerInfoPo = new CustomerInfoPo();
			customerInfoPo.setSmeciisfavorable("0");
		}
		
		request.setAttribute("arg0", request.getParameter("arg0"));
		if (!"".equals(Utility.getName(request.getParameter("regMemberID")))) {
			request.setAttribute("regMemberID", request.getParameter("regMemberID"));
		}
		
		//框镜销售，取镜地点填充 , 所有门店
		departmentsList=departmentsMgr.getDepartments("1","0");
		
		//赠品填充
		GiftsPo giftsPo = new GiftsPo();
		giftsPo.setBgsflag("1");
		giftsPo.setBgsauditstate("1");
		giftsPo.setBgsdepartments(loginPersonInfoPo.getDepartmentID());
		giftsPo.setBdpisshow("1");
		giftsPo.setBdpsalestype(Utility.getName(systemParameterPo.getFspsalestype()));
		giftsList = giftsMgr.getGifts(giftsPo);
		
		// 控制赠品一行2个快捷键
		BigDecimal departmentCount = new BigDecimal(giftsList.size());     // 赠品总数
		departmentCount = departmentCount.divide(new BigDecimal(2),1);	   // 一行2列
		double rowCount = departmentCount.add(new BigDecimal(1)).doubleValue();
		request.setAttribute("rowCount",Math.round(rowCount));             // 计算总行数
		
		//加工填充		
		specialList=specialRequirementsMgr.getSpecialRequirementsList();
		
		//附加费填充
		String[] supplierids = {""};
		additionalCostsList = additionalCostsMgr.getAdditionalCostsListForAjax(supplierids);
		
		//打折快捷键填充
		discountShortcutKeysPolist = discountShortcutKeysMgr.getEnableDiscountShortcutKeysPoList("0");

		// 得到系统参数的信息		
		foreignRecipelPos = unitMgr.getForeignRecipelList();
		
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(loginPersonInfoPo.getDepartmentID());
		
		DepartmentsPo departmentsPo = departmentsMgr.getDepartment(po);
		
		request.setAttribute("departmentsPo", departmentsPo);
				
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
		request.setAttribute("logindepartmentid", loginPersonInfoPo.getDepartmentID());
		request.setAttribute("retain", systemParameterPo.getFspretained());
		return SUCCESS;
	}
	
	/**
	 * 结算。 
	 * @return
	 */
	public String salesAll(){
		//生成配镜单号
		PersonInfoPo personInfoPo = new PersonInfoPo();
		personInfoPo.setId(salesBasicPo.getSsesbsalerid());
		personInfoPo=personInfoMgr.getPersonInfo(personInfoPo);
		PersonInfoPo loginPersonInfoPo = (PersonInfoPo) session.get("person");
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		personInfoPos = personInfoMgr.getModulePersoninfoPoList(moduleID,loginPersonInfoPo.getDepartmentID());
		request.setAttribute("moduleID", moduleID);
		
		String salseID = request.getParameter("salseID");
		//销售 ,m 基表填充
		salesBasicPo.setSsesbsalesid(salseID);
		salesBasicPo.setSsesbshopcode(loginPersonInfoPo.getDepartmentID());
		salesBasicPo.setSsesbcustomerid(customerInfoPo.getSmecicustomerid());
		salesBasicPo.setSsesbsalerid(personInfoPo.getId());
		salesBasicPo.setSsesbintransit("1"); //在途。
		salesBasicPo.setSsesbvalueflag("0");
		
		salesBasicPo.setSsesbpostglassod(Utility.getName(salesBasicPo.getSsesbpostglassod()).equals("")?"0.00":salesBasicPo.getSsesbpostglassod());
		salesBasicPo.setSsesbpostglassos(Utility.getName(salesBasicPo.getSsesbpostglassos()).equals("")?"0.00":salesBasicPo.getSsesbpostglassos());
		salesBasicPo.setSsesbdiscountrate(Utility.getName(salesBasicPo.getSsesbdiscountrate()).equals("")?"1.00":salesBasicPo.getSsesbdiscountrate());
		salesBasicPo.setSsesbarrearsvalue(Utility.getName(salesBasicPo.getSsesbarrearsvalue()).equals("")?"0.00":salesBasicPo.getSsesbarrearsvalue());
		salesBasicPo.setSsesbpsalsvalue(Utility.getName(salesBasicPo.getSsesbpsalsvalue()).equals("")?"0.00":salesBasicPo.getSsesbpsalsvalue());
		salesBasicPo.setSsesbinterhighod(salesBasicPo.getSsesbinterhighod()!=null?salesBasicPo.getSsesbinterhighod().split(",")[0]:"");
		salesBasicPo.setSsesbinterhighos(salesBasicPo.getSsesbinterhighos()!=null?salesBasicPo.getSsesbinterhighos().split(",")[0]:"");
		salesBasicPo.setSsesbinterdistanceod(salesBasicPo.getSsesbinterdistanceod()!=null?salesBasicPo.getSsesbinterdistanceod().split(",")[0]:"");
		salesBasicPo.setSsesbinterdistanceos(salesBasicPo.getSsesbinterdistanceos()!=null?salesBasicPo.getSsesbinterdistanceos().split(",")[0]:"");
		salesBasicPo.setSsesbpupilheightod(salesBasicPo.getSsesbpupilheightod()!=null?salesBasicPo.getSsesbpupilheightod().split(",")[0]:"");
		salesBasicPo.setSsesbpupilheightos(salesBasicPo.getSsesbpupilheightos()!=null?salesBasicPo.getSsesbpupilheightos().split(",")[0]:"");
		salesBasicPo.setSsesblryid(loginPersonInfoPo.getId());
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(loginPersonInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); //模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("框镜配镜单："+salseID+" 新增");
		
		/*
		 * 订单类型及出仓设置
		 */
		salesBasicPo.setSsesborderstype("5");
		String isSaveBallGlassType = ""; 		
		for(int i=0;i<salesDetailPo.getSsesdsalesitemids().length;i++){
			if(!"".equals(salesDetailPo.getSsesdsalesitemids()[i])){
				if("3".equals(salesDetailPo.getSsesdsalesitemids()[i].substring(0,1))||"4".equals(salesDetailPo.getSsesdsalesitemids()[i].substring(0,1))||"8".equals(salesDetailPo.getSsesdsalesitemids()[i].substring(0,1)) ){
					isSaveBallGlassType = "1";
				}
			}
			if(!"".equals(salesDetailPo.getSsesdsalesitemids()[i])&&!"2".equals(salesBasicPo.getSsesborderstype())&&!"4".equals(salesBasicPo.getSsesborderstype())){
				salesDetailPo.setSsesdcommoditiesflag(salesDetailPo.getSsesdsalesitemids()[i].substring(0,1));
				if("D".equals(Utility.getName(salesDetailPo.getIscustomizes()[i])) && "3".equals(salesDetailPo.getSsesdsalesitemids()[i].substring(0,1))){
					salesBasicPo.setSsesborderstype("2");
				}else if(!"D".equals(Utility.getName(salesDetailPo.getIscustomizes()[i])) && "3".equals(salesDetailPo.getSsesdsalesitemids()[i].substring(0,1))){
					salesBasicPo.setSsesborderstype("1");
				}else if("D".equals(Utility.getName(salesDetailPo.getIscustomizes()[i])) && "4".equals(salesDetailPo.getSsesdsalesitemids()[i].substring(0,1))){
					salesBasicPo.setSsesborderstype("4");
				}else if(!"D".equals(Utility.getName(salesDetailPo.getIscustomizes()[i])) && "4".equals(salesDetailPo.getSsesdsalesitemids()[i].substring(0,1))){
					salesBasicPo.setSsesborderstype("3");
				}	
			}
		}
		
		if( "".equals(isSaveBallGlassType) ){
			salesBasicPo.setSsesbballglassod("");
			salesBasicPo.setSsesbballglassos("");
		}
		
		//销售明细填充
		
		salesDetailPo.setSsesdsalesid(salseID);
		
		//加工插入
		String[] sesdrequirement=specialPDetailPo.getSsesdrequirement().split(",");
		List<SpecialPDetailPo> specialPDetailList = new ArrayList<SpecialPDetailPo>();
		for(int i=1;i<sesdrequirement.length;i++){
			SpecialPDetailPo temp = new SpecialPDetailPo();
			temp.setSsesdsalesid(salseID);
			temp.setSsesdrequirement(sesdrequirement[i]);
			specialPDetailList.add(temp);
		}
		
		//附加费用插入
		String[] sseadditionalid=additionalCDetailPo.getSseadditionalid().split(",");
		String[] ssenumber = additionalCDetailPo.getSsenumber().split(",");
		List<AdditionalCDetailPo> additionalCDetailList = new ArrayList<AdditionalCDetailPo>();
		for(int i=1;i<sseadditionalid.length;i++){
			AdditionalCDetailPo temp = new AdditionalCDetailPo();
			temp.setSsesalesid(salseID);
			temp.setSseadditionalid(sseadditionalid[i].trim());
			temp.setSsenumber(ssenumber[i].trim());
			additionalCDetailList.add(temp);
		}
		
		InTransitPo inTransitPo=new InTransitPo();
		inTransitPo.setSseitsalesid(salseID);
		inTransitPo.setSseitdepartment(loginPersonInfoPo.getDepartmentID());
		inTransitPo.setSseitcreateperson(personInfoPo.getId());
		
		/*
		 * 处方保存
		 */
		String recipetype = Utility.getName(request.getParameter("recipetype"));
		String nwtype = Utility.getName(request.getParameter("nwtype")); 
		String optometryPersonID = Utility.getName(request.getParameter("optometryPersonID")); 
		if("wbygs".equals(optometryPersonID)){
			salesBasicPo.setSsesbsalestype("2");
		}else{
			salesBasicPo.setSsesbsalestype("1");
		}
		if (salesBasicPo.getSsesborderstype().equals("5")){
			salesBasicPo.setSsesbsalestype("3");
		}
		
		List<InspectionPo> ipos = new ArrayList<InspectionPo>();
		OptometryPo opo = null;
		OptometryBasicPo obpo = null;	

		if("".equals(nwtype) && !salesBasicPo.getSsesborderstype().equals("5")){
			
			opo = new OptometryPo();
			obpo = new OptometryBasicPo();	
			
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			String customerID=Utility.getName(customerInfoPo.getSmecicustomerid());// 顾客号
			String optometryBasicID = "O" + loginPersonInfoPo.getDepartmentID() + loginPersonInfoPo.getMachinery() + format.format(new Date());//验光基表ID
			String optometryID = Utility.getName(request.getParameter("optometryID"));
			String uuid = UUIDHexGenerator.getInstance().generate();
			salesBasicPo.setSsesboptid(optometryBasicID);
			salesBasicPo.setSsesboptometryid(optometryID);
			salesBasicPo.setSsesbinspectionid(uuid);
			
			opo.setSopoyoptometryid(optometryID);
			opo.setSopoyoptometrybasicid(optometryBasicID);
			opo.setSopoycustomerid(customerID);
			opo.setSopoyshopcode(loginPersonInfoPo.getDepartmentID());
			opo.setSopoypersonid(optometryPersonID);
			opo.setSopoytime(salesBasicPo.getSsesbopdatetime());
			opo.setSopoyrecipeupdatetime(salesBasicPo.getSsesbopdatetime());
			
			if("5".equals(salesBasicPo.getSsesborderstype())){
				opo.setSopoyflag("0");
			}else{
				opo.setSopoyflag("1");
			}
			opo.setSopoyupdateuserid("");
			
			if("wbygs".equals(optometryPersonID)){
				opo.setSopoyisinternal("W");
			}else{
				opo.setSopoyisinternal("");
			}
						
			obpo.setSopobcustomerid(customerID);
			obpo.setSopobcustomername(customerInfoPo.getSmeciname());
			obpo.setSopobmedicalendtime(salesBasicPo.getSsesbopdatetime());
			obpo.setSopobmedicalstarttime(salesBasicPo.getSsesbopdatetime());
			obpo.setSopoboptometrybasicid(optometryBasicID);			
			
			InspectionPo ipo = new InspectionPo();			
			ipo.setSopipcustomerid(customerID);
			ipo.setSopipoptometrybasicid(optometryBasicID);
			ipo.setSopipoptometryid(optometryID);
			ipo.setSopipusername(optometryPersonID);
			ipo.setSopipglasstype(recipetype);
			ipo.setSopipid(uuid);			
			ipo.setSopipballglassod(salesBasicPo.getSsesbballglassod());
			ipo.setSopipballglassos(salesBasicPo.getSsesbballglassos());
			ipo.setSopippostglassod(salesBasicPo.getSsesbpostglassod());
			ipo.setSopippostglassos(salesBasicPo.getSsesbpostglassos());
			ipo.setSopipaxesod(salesBasicPo.getSsesbaxesod());
			ipo.setSopipaxesos(salesBasicPo.getSsesbaxesos());
			ipo.setSopiparriseglassod1(salesBasicPo.getSsesbarriseglassod());
			ipo.setSopiparriseglassos1(salesBasicPo.getSsesbarriseglassos());
			ipo.setSopipbasisod1(salesBasicPo.getSsesbbasisod());
			ipo.setSopipbasisos1(salesBasicPo.getSsesbbasisos());
			ipo.setSopipinterhighod(salesBasicPo.getSsesbinterhighod());
			ipo.setSopipinterhighos(salesBasicPo.getSsesbinterhighos());
			ipo.setSopipinterdistanceod(salesBasicPo.getSsesbinterdistanceod());
			ipo.setSopipinterdistanceos(salesBasicPo.getSsesbinterdistanceos());
			ipo.setSopipfarvaod(salesBasicPo.getSsesbfarvaod());
			ipo.setSopipfarvaos(salesBasicPo.getSsesbfarvaos());
			ipo.setSopipclosevaod(salesBasicPo.getSsesbclosevaod());
			ipo.setSopipclosevaos(salesBasicPo.getSsesbclosevaos());
			ipo.setSopipsource(salesBasicPo.getSsesbopsource());
			ipo.setSopiptime(salesBasicPo.getSsesbopdatetime());
			ipo.setSopipeyecurvatureod1(salesBasicPo.getSsesbeyecurvatureod1());
			ipo.setSopipeyecurvatureod2(salesBasicPo.getSsesbeyecurvatureod2());
			ipo.setSopipeyecurvatureos1(salesBasicPo.getSsesbeyecurvatureos1());
			ipo.setSopipeyecurvatureos2(salesBasicPo.getSsesbeyecurvatureos2());
			ipo.setSopipdiameterod(salesBasicPo.getSsesbdiameterod());
			ipo.setSopipdiameteros(salesBasicPo.getSsesbdiameteros());
			ipo.setSopipconlenvaod(salesBasicPo.getSsesbconlenvaod());
			ipo.setSopipconlenvaos(salesBasicPo.getSsesbconlenvaos());
			ipo.setSopipdignosisre(salesBasicPo.getSsesbdignosisre());
			ipos.add(ipo);
		}
		
		frameSalesMgr.insertSalesBasic(salesBasicPo,salesDetailPo,giftsPo,inTransitPo,specialPDetailList,additionalCDetailList,ipos,opo,obpo,nwtype,logPo);
		/*
		 * 销售成功开窗
		 */
		
		DepartmentsPo dpo = new DepartmentsPo();
		dpo.setBdpdepartmentid(loginPersonInfoPo.getDepartmentID());
		DepartmentsPo departmentsPo = departmentsMgr.getDepartment(dpo);
		
		if("1".equals(departmentsPo.getBdpsalestype())){
			String salseSuccessMsg="顾客:"+customerInfoPo.getSmeciname()+"  销售单"+salseID+"提交成功";
			request.setAttribute("url", "'selGuitarManagementOpen.action?moduleID=S0402&hid="+salseID+"&autopay=1&memberId="+customerInfoPo.getSmecimemberid()+"&ssesborderstype="+salesBasicPo.getSsesborderstype()+"'");
			this.clearMessages();
			this.addActionMessage(getText(salseSuccessMsg));
			request.setAttribute("flag", GlobalConstants.MOVE);
		}else{
			String salseSuccessMsg="顾客:"+customerInfoPo.getSmeciname()+"  销售单"+salseID+"提交成功";
			request.setAttribute("url", "'initSalesAll.action?moduleID="+moduleID+"'");
			this.clearMessages();
			this.addActionMessage(getText(salseSuccessMsg));
			request.setAttribute("flag", GlobalConstants.MOVE);
		}
		
		
		return SUCCESS;
	}
	
	
	public String initChangeSaleser() throws Exception{
		return SUCCESS;
	}
	public String changeSaleser() throws Exception{
		String fpdpersonid=Utility.getName(request.getParameter("fpdpersonid"));
		String fpdpersonpassword=Utility.getName(request.getParameter("fpdpersonpassword"));
		
		personInfoPo=new PersonInfoPo();
		personInfoPo.setId(fpdpersonid);
		personInfoPo.setPassword(fpdpersonpassword);
		
		request.setAttribute("fpdpersonid", fpdpersonid);
		request.setAttribute("fpdpersonpassword", fpdpersonpassword);
		
		personInfoPo = loginMgr.getPerson(intoObject());
		
		if (personInfoPo.getId() != null) {
			if(!"1".equals(personInfoPo.getDepartmenttype())){
				if (personInfoPo.getUserState().matches("[0]")) { // 当前状态0:正常 1:删除
	
					return SUCCESS;
				} else {
					this.addActionMessage(this.getText("person.not.error"));
					return ERROR;
				}
			}else{
				if (personInfoPo.getUserState().matches("[0]")&&((PersonInfoPo)session.get("person")).getDepartmentID().equals(personInfoPo.getDepartmentID())) { // 当前状态0:正常 1:删除
					if("店长".equals(personInfoPo.getRolename())||"主任".equals(personInfoPo.getRolename())||Utility.getName(personInfoPo.getRolename()).contains("营业")){
						session.clear();
						String address = request.getRemoteAddr();
						String machineCode = FrameSalesAction.getMachineCode(address);
						personInfoPo.setMachinery(machineCode);
						session.put("person", personInfoPo);
						request.setAttribute("flag", GlobalConstants.OPENUPDATE5);
						request.setAttribute("saleser", personInfoPo.getPersonName());
						return SUCCESS;
					}else{
						this.addActionMessage(this.getText("你现在的角色是"+personInfoPo.getRolename()+",请确认您有销售权限!"));
						return ERROR;
					}
				} else {
					personInfoPo=null;
					this.addActionMessage(this.getText("personid.password.error"));
					return ERROR;
				}
			}
		} else {
			personInfoPo=null;
			this.addActionMessage(this.getText("personid.password.error"));
			return ERROR;
		}
	}
	public String changeSaleserCard() throws Exception{
		//验证打折人员
		String cardid=Utility.getName(request.getParameter("cardid"));
		
		personInfoPo=new PersonInfoPo();
		personInfoPo.setCardid(cardid);
		
		request.setAttribute("cardid", cardid);
		
		personInfoPo = loginMgr.cardLogin(personInfoPo);
		
		
		if (personInfoPo.getId() != null) {
		
			if (personInfoPo.getUserState().matches("[0]")&&((PersonInfoPo)session.get("person")).getDepartmentID().equals(personInfoPo.getDepartmentID())) { // 当前状态0:正常 1:删除
				if("店长".equals(personInfoPo.getRolename())||"主任".equals(personInfoPo.getRolename())||Utility.getName(personInfoPo.getRolename()).contains("营业")){
					session.clear();
					String address = request.getRemoteAddr();
					String machineCode = FrameSalesAction.getMachineCode(address);
					personInfoPo.setMachinery(machineCode);
					session.put("person", personInfoPo);
					request.setAttribute("flag", GlobalConstants.OPENUPDATE5);
					return SUCCESS;
				}else{
					this.addActionMessage(this.getText("你现在的角色是"+personInfoPo.getRolename()+",请确认您有销售权限!"));
					return ERROR;
				}
				
			} else {
				personInfoPo=null;
				this.addActionMessage(this.getText("personid.password.error"));
				return ERROR;
			}
		} else {
			personInfoPo=null;
			this.addActionMessage(this.getText("card.password.error"));
			return ERROR;
		}
	}
	public String initChangeSaleserCard() throws Exception{
		return SUCCESS;
	}
	/**
	 * 验证登录人
	 * @return
	 */
	public PersonInfoPo intoObject() {
		String fpdpersonid=Utility.getName(request.getParameter("fpdpersonid"));
		String fpdpersonpassword=Utility.getName(request.getParameter("fpdpersonpassword"));
		
		PersonInfoPo info = new PersonInfoPo();
		info.setId(fpdpersonid);
		info.setPassword(fpdpersonpassword);
		return info;
	}
	
	private static String getMachineCode(String args) {
		if (args == null) {
			return "";
		}
		String[] ips = args.split("\\.");
		String code = ips[3];

		int number = Integer.parseInt(code);
		String hex = Integer.toHexString(number).toUpperCase();
		int length = hex.length();
		if (length < 2) {
			hex = "0" + hex;
		}
		return hex;
	}
	
	/**
	 * 取得Ajax数据
	 */
	public void getAjaxSpecial() throws Exception {
		
		String fnpid = Utility.getName(request.getParameter("specialType1"));
		PrintWriter out;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();

		if (fnpid.equals("")) {
			out.println("<option value=''>请选择特殊加工要求(0)</option>");
		} else {
			SalesSpecialPo tmp = new SalesSpecialPo();
			tmp.setProdststus(fnpid);
			special1List = specialRequirementsMgr.getSpecialRequirements1List(tmp.getProdststus());
			Iterator it = special1List.iterator();
			out.println("<option value=''>请选择特殊加工要求("
					+ special1List.size() + ")</option>");
			if (it.hasNext()) {
				while (it.hasNext()) {
					SalesSpecialPo tmpPo = (SalesSpecialPo) it
							.next();
					out.println("<option value='" + tmpPo.getProdcd() + "'>"
							+ tmpPo.getProdlocal() + "</option>");
				}
			}
		}
		out.close();
	}
	
	/**
	 * 取得Ajax数据
	 */
	public void getAjaxAdditionalCosts() throws Exception {
		String[] fnpid = Utility.getName(request.getParameter("supplierids")).split(",");
		PrintWriter out;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();

		if (fnpid.equals("")) {
			out.println("<option value=''>----请选择----</option>");
		} else {
			additionalCostsList = additionalCostsMgr.getAdditionalCostsListForAjax(fnpid);
			Iterator it = additionalCostsList.iterator();
			out.println("<option value=''>----请选择----</option>");
			if (it.hasNext()) {
				while (it.hasNext()) {
					AdditionalCostsPo tmpPo = (AdditionalCostsPo) it
							.next();
					out.println("<option value='" + tmpPo.getFacid()+","+ tmpPo.getFacamount() + "'>"
							+ tmpPo.getFacname() + "</option>");
				}
			}
		}
		out.close();
	}
	
	/**
	 * 取得Ajax数据
	 */
	public void getAjaxCustomerDiscount() throws Exception {
		String categoryid = Utility.getName(request.getParameter("categoryid"));
		String supplierid = Utility.getName(request.getParameter("supplierid"));
		String brandid = Utility.getName(request.getParameter("brandid"));
		String goodsid = Utility.getName(request.getParameter("goodsid"));
		//String iscustomize = Utility.getName(request.getParameter("iscustomize"));
		String cardtype = Utility.getName(request.getParameter("cardtype"));

		GoodsInfoPo po = new GoodsInfoPo();
		po.setBgigoodscategoryid(categoryid);
		po.setBgisupplierid(supplierid);
		po.setBgibrandid(brandid);
		po.setBgigoodsid(goodsid);
		//po.setBgiiscustomize(iscustomize);
		po.setCustomercardtype(cardtype);
		
		PrintWriter out;
		
		response.setContentType("charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();		
		CustomerInfoPo cpo = frameSalesMgr.getAjaxCustomerDiscount(po);
	
		out.println(cpo.getFmmdiscount());
		out.close();
	}
	
	/**
	 * 取得Ajax数据
	 */
	public void getAjaxCustomerDiscountNew() throws Exception {
		String categoryid = Utility.getName(request.getParameter("categoryid"));
		String supplierid = Utility.getName(request.getParameter("supplierid"));
		String brandid = Utility.getName(request.getParameter("brandid"));
		String goodsid = Utility.getName(request.getParameter("goodsid"));
		String cardtype = Utility.getName(request.getParameter("cardtype"));
		String shopcode = Utility.getName(request.getParameter("shopcode"));

		GoodsInfoPo po = new GoodsInfoPo();
		po.setBgigoodscategoryid(categoryid);
		po.setBgisupplierid(supplierid);
		po.setBgibrandid(brandid);
		po.setBgigoodsid(goodsid);
		po.setCustomercardtype(cardtype);
		po.setBgishopcode(shopcode);
		
		PrintWriter out;
		
		response.setContentType("charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();
		
		CustomerInfoPo cpo = frameSalesMgr.getAjaxCustomerDiscount(po);
		
		if (cpo == null || Utility.getName(cpo.getFmmdiscount()).equals("")){
			po.setBgishopcode("");
			cpo = frameSalesMgr.getAjaxCustomerDiscount(po);
		}
		
		out.println(cpo.getFmmdiscount());
		out.close();
	}
	
	/**
	 *  初始化门店销售
	 */
	public String initShopSalesMain() throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo loginPersonInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = loginPersonInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		if (Utility.getName(systemParameterPo.getFspdefaultmemberid()).equals("")){
			systemParameterPo.setFspdefaultmemberid("");
		}
		
		DepartmentsPo dpo = new DepartmentsPo();
		dpo.setBdpdepartmentid(loginPersonInfoPo.getDepartmentID());
		dpo = departmentsMgr.getDepartment(dpo);
		
		if (Utility.getName(dpo.getBdpsalestype()).equals("1")){  // 验光+销售+收银
			systemParameterPo = systemParameterMgr.getSystemParameterPoDepartmentBillTemplate(systemParameterPo,Utility.getName(loginPersonInfoPo.getDepartmentID()));
		}
		//判断跳转哪个界面
		String isGO = Utility.getName(request.getParameter("isGO"));
		if("".equals(isGO)){
		if("2".equals(systemParameterPo.getFsphisflag())){//系统连接HIS
			
			if("0".equals(loginPersonInfoPo.getBdplinkhisflag())&&"initSCIHISsaomaWin.action".equals(loginPersonInfoPo.getBdpreadcardform())){
				request.setAttribute("isGO","0");//现有是界面
			}else{
				request.setAttribute("isGO","1");//读卡扫码界面
			}
		}else if("0".equals(systemParameterPo.getFsphisflag())){//系统不连接HIS
			
			 if("initSCIHISsaomaWin.action".equals(loginPersonInfoPo.getBdpreadcardform())){
				 request.setAttribute("isGO","0");//现有是界面
			 }else{
				 request.setAttribute("isGO","1");//读卡界面
			 }
		}
		}

		return SUCCESS;
	}
	
	/**
	 *  初始化辅料销售
	 */
	public String initAccessoriesSalesMain() throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo loginPersonInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = loginPersonInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		request.setAttribute("tid", loginPersonInfoPo.getId());
		request.setAttribute("tname", loginPersonInfoPo.getPersonName());
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		PersonDiscountDetailsPo pdpo=new PersonDiscountDetailsPo();
		pdpo.setFpddpersonid(loginPersonInfoPo.getId());
		if("1".equals(systemParameterPo.getFspisusegoodslevel())){
			List<PersonDiscountDetailsPo> personDiscountDetailsPos = personDiscountMgr.selectPersonDiscountDetail(pdpo);
			loginPersonInfoPo.setPersonDiscountDetailsPos(personDiscountDetailsPos);
		}else{
			PersonDiscountPo discountpo = new PersonDiscountPo();
			discountpo.setFpdpersonid(loginPersonInfoPo.getId());
			PersonDiscountPo personDiscountPo=personDiscountMgr.getPersonDiscount(discountpo);
			loginPersonInfoPo.setPersonDiscount(personDiscountPo.getFpddiscount());
		}
		
		request.setAttribute("loginPersonInfoPo", loginPersonInfoPo);
		
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		request.setAttribute("retain", systemParameterPo.getFspretained());
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo2 = new CustomerInfoPo();
		
		DepartmentsPo dpo = new DepartmentsPo();
		dpo.setBdpdepartmentid(loginPersonInfoPo.getDepartmentID());
		dpo = departmentsMgr.getDepartment(dpo);		
		request.setAttribute("stealthflag",Utility.getName(dpo.getBdpstealthflag()));
		request.setAttribute("printmedicalhistoryflag",Utility.getName(dpo.getBdpprintmedicalhistory()));
		
		request.setAttribute("firstIn","1");
		
		customerInfoPo2.setSmecicustomerid("");
		customerInfoPo2.setSmecimemberid(Utility.getName(systemParameterPo.getFspdefaultmemberid()));
		customerInfoPo2.setSmeciflag("1");
		customerInfoPo2.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,loginPersonInfoPo));
		customerInfoPo2 = frameSalesMgr.getCustomerInfo(customerInfoPo2);
		
		if(!"".equals(Utility.getName(customerInfoPo2.getSmecifcustomerid()))){
			CustomerInfoPo cpo = frameSalesMgr.getCustomerFType(customerInfoPo2);
			customerInfoPo2.setSmecicardtype(cpo.getSmecicardtype());
			customerInfoPo2.setFmmmembername(cpo.getFmmmembername());
		}			

		optometryPersonInfoPos = personInfoMgr.getPersoninfoPoListByJobType("3",loginPersonInfoPo.getDepartmentID(),systemParameterPo);
		
		request.setAttribute("customerprinttype", request.getParameter("customerprinttype"));
	
		if (customerInfoPo == null){
			customerInfoPo = new CustomerInfoPo();
			customerInfoPo.setSmeciisfavorable("0");
		}
		
		request.setAttribute("arg0", request.getParameter("arg0"));
		if (!"".equals(Utility.getName(request.getParameter("regMemberID")))) {
			request.setAttribute("regMemberID", request.getParameter("regMemberID"));
		}
		
		//赠品填充
		GiftsPo giftsPo = new GiftsPo();
		giftsPo.setBgsflag("1");
		giftsPo.setBgsauditstate("1");
		giftsPo.setBgsdepartments(loginPersonInfoPo.getDepartmentID());
		giftsPo.setBdpisshow("1");
		giftsPo.setBdpsalestype(Utility.getName(systemParameterPo.getFspsalestype()));
		giftsList = giftsMgr.getGifts(giftsPo);
		
//		// 控制赠品一行2个快捷键
		BigDecimal departmentCount = new BigDecimal(giftsList.size());     // 赠品总数
		departmentCount = departmentCount.divide(new BigDecimal(2),1);	   // 一行2列
		double rowCount = departmentCount.add(new BigDecimal(1)).doubleValue();
		request.setAttribute("rowCount",Math.round(rowCount));             // 计算总行数
		
		//加工填充		
		specialList=specialRequirementsMgr.getSpecialRequirementsList();
		
		//附加费填充
		String[] supplierids = {""};
		additionalCostsList = additionalCostsMgr.getAdditionalCostsListForAjax(supplierids);
		
		//打折快捷键填充
		discountShortcutKeysPolist = discountShortcutKeysMgr.getEnableDiscountShortcutKeysPoList("1");

		// 得到系统参数的信息		
		foreignRecipelPos = unitMgr.getForeignRecipelList();
		
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(loginPersonInfoPo.getDepartmentID());			
		DepartmentsPo departmentsPo = departmentsMgr.getDepartment(po);			
		request.setAttribute("departmentsPo", departmentsPo);
				
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
		request.setAttribute("logindepartmentid", loginPersonInfoPo.getDepartmentID());
		request.setAttribute("retain", systemParameterPo.getFspretained());
		
		// 辅料销售设置默认的会员卡号后，销售页面点击辅料销售查询默认的会员卡信息后，返回标识位
		request.setAttribute("returnAccessoriesUrl","1");
		
		// 从服务器获取系统时间判断取镜时间
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		request.setAttribute("dqqjsj",tempDate.format(new Date()));
		
		tempDate = new SimpleDateFormat("MM-dd-yyyy HH:mm");
		request.setAttribute("dqqjsj2",tempDate.format(new Date()));		
		
		return SUCCESS;
	}
	
	/**
	 *  门店销售
	 */
	public String queryShopSalesMain() throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo loginPersonInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = loginPersonInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		WarehouseConfigurationPo tempWarehouseConfigurationPo = new WarehouseConfigurationPo();
		tempWarehouseConfigurationPo.setBwcdeptid(loginPersonInfoPo.getDepartmentID());
		WarehouseConfigurationPo warehouseConfigurationPo=warehouseConfigurationMgr.getWarehouseConfiguration(tempWarehouseConfigurationPo);
		
		request.setAttribute("xiaocangww", warehouseConfigurationPo.getBwcxiaocangww());

		if (Utility.getName(permissionPo.getKeyb()).equals("1")){
			yishiPersonInfoPos = personInfoMgr.getPersonInfosByDepartmentid("");//获得医师下拉框List
		}
		
		request.setAttribute("tid", loginPersonInfoPo.getId());
		request.setAttribute("tname", loginPersonInfoPo.getPersonName());
		
		PersonDiscountDetailsPo pdpo=new PersonDiscountDetailsPo();
		pdpo.setFpddpersonid(loginPersonInfoPo.getId());
		if("1".equals(systemParameterPo.getFspisusegoodslevel())){
			List<PersonDiscountDetailsPo> personDiscountDetailsPos = personDiscountMgr.selectPersonDiscountDetail(pdpo);
			loginPersonInfoPo.setPersonDiscountDetailsPos(personDiscountDetailsPos);
		}else{
			PersonDiscountPo discountpo = new PersonDiscountPo();
			discountpo.setFpdpersonid(loginPersonInfoPo.getId());
			PersonDiscountPo personDiscountPo=personDiscountMgr.getPersonDiscount(discountpo);
			loginPersonInfoPo.setPersonDiscount(personDiscountPo.getFpddiscount());
		}
			
		request.setAttribute("loginPersonInfoPo", loginPersonInfoPo);
		
		DepartmentsPo dpo = new DepartmentsPo();
		dpo.setBdpdepartmentid(loginPersonInfoPo.getDepartmentID());
		dpo = departmentsMgr.getDepartment(dpo);
		request.setAttribute("stealthflag",Utility.getName(dpo.getBdpstealthflag()));
		request.setAttribute("printmedicalhistoryflag",Utility.getName(dpo.getBdpprintmedicalhistory()));
		
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		//获取配镜单和订金单
		if (Utility.getName(dpo.getBdpsalestype()).equals("1")){  // 验光+销售+收银
			systemParameterPo = systemParameterMgr.getSystemParameterPoDepartmentBillTemplate(systemParameterPo,Utility.getName(dpo.getBdpdepartmentid()));
		}
		
		// 判断默认的会员卡是否与当前部门同属一个公司
		if (Utility.getName(systemParameterPo.getFspdefaultmemberid()).equals("") || (departmentsMgr.getCustomerCount(Utility.getName(systemParameterPo.getFspdefaultmemberid()),Utility.getName(loginPersonInfoPo.getDepartmentID())) == 0)){
			systemParameterPo.setFspdefaultmemberid("");
		}

		optometryPersonInfoPos = personInfoMgr.getPersoninfoPoListByJobType("3",loginPersonInfoPo.getDepartmentID(),systemParameterPo);

		request.setAttribute("customerprinttype", request.getParameter("customerprinttype"));
		
		if (customerInfoPo != null&& StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			request.setAttribute("begin", "1");
			request.removeAttribute("salseSuccessMsg");
			customerInfoPo.setSmecicustomerid("");
			customerInfoPo.setSmeciflag("1");
			customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,loginPersonInfoPo));
			customerInfoPo = frameSalesMgr.getCustomerInfo(customerInfoPo,loginPersonInfoPo);
			
			if(!"".equals(Utility.getName(customerInfoPo.getSmecifcustomerid()))){
				CustomerInfoPo cpo = frameSalesMgr.getCustomerFType(customerInfoPo);
				customerInfoPo.setSmecicardtype(cpo.getSmecicardtype());
				customerInfoPo.setFmmmembername(cpo.getFmmmembername());
			}
			
			if("".equals(Utility.getName(customerInfoPo.getSmeciname()))){
				request.setAttribute("wbd", "卡号不存在");
			}else{
				request.setAttribute("wbd", "");
			}
			
			if (customerInfoPo.getSmecicustomerid() == null) {
				this.clearMessages();
				this.addActionMessage("查无此会员或该会员卡已被停用!");
				return ERROR;
			}
		}
		
		customerInfoPo2 = new CustomerInfoPo();
		if (!Utility.getName(systemParameterPo.getFspdefaultmemberid()).equals("")) {
			customerInfoPo2.setSmecicustomerid("");
			customerInfoPo2.setSmecimemberid(Utility.getName(systemParameterPo.getFspdefaultmemberid()));
			customerInfoPo2.setSmeciflag("1");
			customerInfoPo2.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,loginPersonInfoPo));
			customerInfoPo2 = frameSalesMgr.getCustomerInfo(customerInfoPo2);
			
			if(!"".equals(Utility.getName(customerInfoPo2.getSmecifcustomerid()))){
				CustomerInfoPo cpo = frameSalesMgr.getCustomerFType(customerInfoPo2);
				customerInfoPo2.setSmecicardtype(cpo.getSmecicardtype());
				customerInfoPo2.setFmmmembername(cpo.getFmmmembername());
			}			
		}
		
		if (customerInfoPo == null){
			customerInfoPo = new CustomerInfoPo();
			customerInfoPo.setSmeciisfavorable("0");
		}
		
		request.setAttribute("arg0", request.getParameter("arg0"));
		if (!"".equals(Utility.getName(request.getParameter("regMemberID")))) {
			request.setAttribute("regMemberID", request.getParameter("regMemberID"));
		}
		
		//赠品填充
		GiftsPo giftsPo = new GiftsPo();
		giftsPo.setBgsflag("1");
		giftsPo.setBgsauditstate("1");
		giftsPo.setBgsdepartments(loginPersonInfoPo.getDepartmentID());
		giftsPo.setBdpisshow("1");
		giftsPo.setBdpsalestype(Utility.getName(systemParameterPo.getFspsalestype()));
		giftsList = giftsMgr.getGifts(giftsPo);
		
		// 控制赠品一行2个快捷键
		BigDecimal departmentCount = new BigDecimal(giftsList.size());     // 赠品总数
		departmentCount = departmentCount.divide(new BigDecimal(2),1);	   // 一行2列
		double rowCount = departmentCount.add(new BigDecimal(1)).doubleValue();
		request.setAttribute("rowCount",Math.round(rowCount));             // 计算总行数
		
		//加工填充		
		specialList=specialRequirementsMgr.getSpecialRequirementsList();
		
		//附加费填充
		String[] supplierids = {""};
		additionalCostsList = additionalCostsMgr.getAdditionalCostsListForAjax(supplierids);
		
		//打折快捷键填充
		discountShortcutKeysPolist = discountShortcutKeysMgr.getEnableDiscountShortcutKeysPoList("1");

		//得到系统参数的信息		
		foreignRecipelPos = unitMgr.getForeignRecipelList();
		
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(loginPersonInfoPo.getDepartmentID());		
		DepartmentsPo departmentsPo = departmentsMgr.getDepartment(po);		
		request.setAttribute("departmentsPo", departmentsPo);
				
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
		request.setAttribute("logindepartmentid", loginPersonInfoPo.getDepartmentID());
		request.setAttribute("retain", systemParameterPo.getFspretained());
		
		// 从服务器获取系统时间判断取镜时间
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		request.setAttribute("dqqjsj",tempDate.format(new Date()));
		
		tempDate = new SimpleDateFormat("MM-dd-yyyy HH:mm");
		request.setAttribute("dqqjsj2",tempDate.format(new Date()));
		
		return SUCCESS;
	}
	
	/**
	 *  初始化查看处方
	 */
	public String initShopSalesRecipel() throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo loginPersonInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = loginPersonInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String customerid = Utility.getName(request.getParameter("customerid"));
		List<SalesRecipeNumViewPo> countList = null;

		inspectionPos = new ArrayList<InspectionPo>();
		
		InspectionPo ipo = new InspectionPo();
		ipo.setSopipcustomerid(customerid);
				
		if (!customerid.equals("")) {
			
			countList = frameSalesMgr.getSalesRecipeNumViewList();
			if(countList!=null && countList.size()>0){
				inspectionPos = frameSalesMgr.getInspectionRecipeList(countList, ipo);
			}
		}
		return SUCCESS;
	}
	
	public String insertShopSalesMain(){

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo loginPersonInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = loginPersonInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		//生成配镜单号
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String salseID = "X" + loginPersonInfoPo.getDepartmentID() + loginPersonInfoPo.getMachinery() + numHeadFormat.format(new Date());
		
		//销售 ,m 基表填充
		salesBasicPo.setSsesbsalesid(salseID);
		salesBasicPo.setSsesbcustomerid(customerInfoPo.getSmecicustomerid());
		salesBasicPo.setSsesbintransit("1"); //在途。
		salesBasicPo.setSsesbvalueflag("0");
		salesBasicPo.setSsesbhardvalueversion(Utility.getName(systemParameterPo.getFspprocessdifficulty())); // 加工难度系数
		
		salesBasicPo.setSsesbpostglassod(Utility.getName(salesBasicPo.getSsesbpostglassod()).equals("")?"0.00":salesBasicPo.getSsesbpostglassod());
		salesBasicPo.setSsesbpostglassos(Utility.getName(salesBasicPo.getSsesbpostglassos()).equals("")?"0.00":salesBasicPo.getSsesbpostglassos());
		salesBasicPo.setSsesbdiscountrate(Utility.getName(salesBasicPo.getSsesbdiscountrate()).equals("")?"1.00":salesBasicPo.getSsesbdiscountrate());
		salesBasicPo.setSsesbarrearsvalue(Utility.getName(salesBasicPo.getSsesbarrearsvalue()).equals("")?"0.00":salesBasicPo.getSsesbarrearsvalue());
		salesBasicPo.setSsesbpsalsvalue(Utility.getName(salesBasicPo.getSsesbpsalsvalue()).equals("")?"0.00":salesBasicPo.getSsesbpsalsvalue());
		salesBasicPo.setSsesbinterhighod(salesBasicPo.getSsesbinterhighod()!=null?salesBasicPo.getSsesbinterhighod().split(",")[0]:"");
		salesBasicPo.setSsesbinterhighos(salesBasicPo.getSsesbinterhighos()!=null?salesBasicPo.getSsesbinterhighos().split(",")[0]:"");
		salesBasicPo.setSsesbinterdistanceod(salesBasicPo.getSsesbinterdistanceod()!=null?salesBasicPo.getSsesbinterdistanceod().split(",")[0]:"");
		salesBasicPo.setSsesbinterdistanceos(salesBasicPo.getSsesbinterdistanceos()!=null?salesBasicPo.getSsesbinterdistanceos().split(",")[0]:"");
		salesBasicPo.setSsesbpupilheightod(salesBasicPo.getSsesbpupilheightod()!=null?salesBasicPo.getSsesbpupilheightod().split(",")[0]:"");
		salesBasicPo.setSsesbpupilheightos(salesBasicPo.getSsesbpupilheightos()!=null?salesBasicPo.getSsesbpupilheightos().split(",")[0]:"");
		salesBasicPo.setSsesblryid(loginPersonInfoPo.getId());
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(loginPersonInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); //模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("框镜配镜单："+salseID+" 新增");
		
		/*
		 * 订单类型及出仓设置
		 */
		salesBasicPo.setSsesborderstype("5");
		String isSaveBallGlassType = ""; 
		if (salesDetailPo != null){
			for(int i=0;i<salesDetailPo.getSsesdsalesitemids().length;i++){
				if(!"".equals(salesDetailPo.getSsesdsalesitemids()[i])){
					if("3".equals(salesDetailPo.getSsesdsalesitemids()[i].substring(0,1))||"4".equals(salesDetailPo.getSsesdsalesitemids()[i].substring(0,1))||"8".equals(salesDetailPo.getSsesdsalesitemids()[i].substring(0,1)) ){
						isSaveBallGlassType = "1";
					}
				}
				if(!"".equals(salesDetailPo.getSsesdsalesitemids()[i])&&!"2".equals(salesBasicPo.getSsesborderstype())&&!"4".equals(salesBasicPo.getSsesborderstype())){
					salesDetailPo.setSsesdcommoditiesflag(salesDetailPo.getSsesdsalesitemids()[i].substring(0,1));
					if("D".equals(Utility.getName(salesDetailPo.getIscustomizes()[i])) && "3".equals(salesDetailPo.getSsesdsalesitemids()[i].substring(0,1))){
						salesBasicPo.setSsesborderstype("2");
					}else if(!"D".equals(Utility.getName(salesDetailPo.getIscustomizes()[i])) && "3".equals(salesDetailPo.getSsesdsalesitemids()[i].substring(0,1))){
						salesBasicPo.setSsesborderstype("1");
					}else if("D".equals(Utility.getName(salesDetailPo.getIscustomizes()[i])) && "4".equals(salesDetailPo.getSsesdsalesitemids()[i].substring(0,1))){
						salesBasicPo.setSsesborderstype("4");
					}else if(!"D".equals(Utility.getName(salesDetailPo.getIscustomizes()[i])) && "4".equals(salesDetailPo.getSsesdsalesitemids()[i].substring(0,1))){
						salesBasicPo.setSsesborderstype("3");
					}	
				}
			}
		}
		
		if( "".equals(isSaveBallGlassType) ){
			salesBasicPo.setSsesbballglassod("");
			salesBasicPo.setSsesbballglassos("");
		}
		
		//销售明细填充
		if (salesDetailPo != null){
			salesDetailPo.setSsesdsalesid(salseID);
		}
		
		//加工插入
		List<SpecialPDetailPo> specialPDetailList = null;
		if (specialPDetailPo != null){
			String[] sesdrequirement = specialPDetailPo.getSsesdrequirement().split(",");
			specialPDetailList = new ArrayList<SpecialPDetailPo>();
			for(int i=0;i<sesdrequirement.length;i++){
				SpecialPDetailPo temp = new SpecialPDetailPo();
				temp.setSsesdsalesid(salseID);
				temp.setSsesdrequirement(sesdrequirement[i]);
				specialPDetailList.add(temp);
			}
		}
		
		//附加费用插入
		List<AdditionalCDetailPo> additionalCDetailList = null;
		if (additionalCDetailPo != null){
			String[] sseadditionalid = additionalCDetailPo.getSseadditionalid().split(",");
			String[] ssenumber = additionalCDetailPo.getSsenumber().split(",");
			String[] facamount = additionalCDetailPo.getSseamount().split(",");
			String[] facname = additionalCDetailPo.getSsecostsname().split(",");
			
			additionalCDetailList = new ArrayList<AdditionalCDetailPo>();
			for(int i=0;i<sseadditionalid.length;i++){
				AdditionalCDetailPo temp = new AdditionalCDetailPo();
				temp.setSsesalesid(salseID);
				temp.setSseadditionalid(sseadditionalid[i].trim());
				temp.setSsenumber(ssenumber[i].trim());
				temp.setSseamount(facamount[i].trim());
				temp.setSsecostsname(facname[i].trim());
		     
				additionalCDetailList.add(temp);
			}
		}
	
		InTransitPo inTransitPo=new InTransitPo();
		inTransitPo.setSseitsalesid(salseID);
		inTransitPo.setSseitdepartment(loginPersonInfoPo.getDepartmentID());
		inTransitPo.setSseitcreateperson(salesBasicPo.getSsesbsalerid());
		
		/*
		 * 处方保存
		 */
		String recipetype = Utility.getName(request.getParameter("recipetype"));
		String nwtype = Utility.getName(request.getParameter("nwtype")); 
		String optometryPersonID = Utility.getName(request.getParameter("optometryPersonID")); 
		if("wbygs".equals(optometryPersonID)){
			salesBasicPo.setSsesbsalestype("2");
		}else{
			salesBasicPo.setSsesbsalestype("1");
		}
		if (salesBasicPo.getSsesborderstype().equals("5")){
			salesBasicPo.setSsesbsalestype("3");
		}
		salesBasicPo.setSsesbygsid(optometryPersonID);
		
		List<InspectionPo> ipos = new ArrayList<InspectionPo>();
		OptometryPo opo = null;
		OptometryBasicPo obpo = null;	

		if("".equals(nwtype) && !salesBasicPo.getSsesborderstype().equals("5")){
			
			opo = new OptometryPo();
			obpo = new OptometryBasicPo();	

			String customerID = Utility.getName(customerInfoPo.getSmecicustomerid());// 顾客号
			String optometryBasicID = "O" + loginPersonInfoPo.getDepartmentID() + loginPersonInfoPo.getMachinery() + numHeadFormat.format(new Date());//验光基表ID
			String optometryID = "Y" + loginPersonInfoPo.getDepartmentID() + loginPersonInfoPo.getMachinery() + numHeadFormat.format(new Date());// 验光号
			
			String uuid = UUIDHexGenerator.getInstance().generate();
			salesBasicPo.setSsesboptid(optometryBasicID);
			salesBasicPo.setSsesboptometryid(optometryID);
			salesBasicPo.setSsesbinspectionid(uuid);
			
			opo.setSopoyoptometryid(optometryID);
			opo.setSopoyoptometrybasicid(optometryBasicID);
			opo.setSopoycustomerid(customerID);
			opo.setSopoyshopcode(loginPersonInfoPo.getDepartmentID());
			opo.setSopoypersonid(optometryPersonID);
			opo.setSopoytime(salesBasicPo.getSsesbopdatetime());
			opo.setSopoyrecipeupdatetime(salesBasicPo.getSsesbopdatetime());
			
			if("5".equals(salesBasicPo.getSsesborderstype())){
				opo.setSopoyflag("0");
			}else{
				opo.setSopoyflag("1");
			}
			opo.setSopoyupdateuserid("");
			
			if("wbygs".equals(optometryPersonID)){
				opo.setSopoyisinternal("W");
			}else{
				opo.setSopoyisinternal("");
			}
			
			obpo.setSopobcustomerid(customerID);
			obpo.setSopobcustomername(customerInfoPo.getSmeciname());
			obpo.setSopobmedicalendtime(salesBasicPo.getSsesbopdatetime());
			obpo.setSopobmedicalstarttime(salesBasicPo.getSsesbopdatetime());
			obpo.setSopoboptometrybasicid(optometryBasicID);			
			
			InspectionPo ipo = new InspectionPo();			
			ipo.setSopipcustomerid(customerID);
			ipo.setSopipoptometrybasicid(optometryBasicID);
			ipo.setSopipoptometryid(optometryID);
			ipo.setSopipusername(optometryPersonID);
			ipo.setSopipglasstype(recipetype);
			ipo.setSopipid(uuid);			
			ipo.setSopipballglassod(Utility.getName(salesBasicPo.getSsesbballglassod()).replace(",", "").trim());
			ipo.setSopipballglassos(Utility.getName(salesBasicPo.getSsesbballglassos()).replace(",", "").trim());
			ipo.setSopippostglassod(Utility.getName(salesBasicPo.getSsesbpostglassod()).replace(",", "").trim());
			ipo.setSopippostglassos(Utility.getName(salesBasicPo.getSsesbpostglassos()).replace(",", "").trim());
			ipo.setSopipaxesod(Utility.getName(salesBasicPo.getSsesbaxesod()).replace(",", "").trim());
			ipo.setSopipaxesos(Utility.getName(salesBasicPo.getSsesbaxesos()).replace(",", "").trim());
			ipo.setSopiparriseglassod1(Utility.getName(salesBasicPo.getSsesbarriseglassod()).replace(",", "").trim());
			ipo.setSopiparriseglassos1(Utility.getName(salesBasicPo.getSsesbarriseglassos()).replace(",", "").trim());
			ipo.setSopipbasisod1(Utility.getName(salesBasicPo.getSsesbbasisod()).replace(",", "").trim());
			ipo.setSopipbasisos1(Utility.getName(salesBasicPo.getSsesbbasisos()).replace(",", "").trim());
			ipo.setSopipinterhighod(Utility.getName(salesBasicPo.getSsesbinterhighod()).replace(",", "").trim());
			ipo.setSopipinterhighos(Utility.getName(salesBasicPo.getSsesbinterhighos()).replace(",", "").trim());
			ipo.setSopipinterdistanceod(Utility.getName(salesBasicPo.getSsesbinterdistanceod()).replace(",", "").trim());
			ipo.setSopipinterdistanceos(Utility.getName(salesBasicPo.getSsesbinterdistanceos()).replace(",", "").trim());
			ipo.setSopipfarvaod(Utility.getName(salesBasicPo.getSsesbfarvaod()).replace(",", "").trim());
			ipo.setSopipfarvaos(Utility.getName(salesBasicPo.getSsesbfarvaos()).replace(",", "").trim());
			ipo.setSopipclosevaod(Utility.getName(salesBasicPo.getSsesbclosevaod()).replace(",", "").trim());
			ipo.setSopipclosevaos(Utility.getName(salesBasicPo.getSsesbclosevaos()).replace(",", "").trim());
			ipo.setSopipsource(Utility.getName(salesBasicPo.getSsesbopsource()));
			ipo.setSopiptime(Utility.getName(salesBasicPo.getSsesbopdatetime()));
			ipo.setSopipeyecurvatureod1(Utility.getName(salesBasicPo.getSsesbeyecurvatureod1()).replace(",", "").trim());
			ipo.setSopipeyecurvatureod2(Utility.getName(salesBasicPo.getSsesbeyecurvatureod2()).replace(",", "").trim());
			ipo.setSopipeyecurvatureos1(Utility.getName(salesBasicPo.getSsesbeyecurvatureos1()).replace(",", "").trim());
			ipo.setSopipeyecurvatureos2(Utility.getName(salesBasicPo.getSsesbeyecurvatureos2()).replace(",", "").trim());
			ipo.setSopipdiameterod(Utility.getName(salesBasicPo.getSsesbdiameterod()).replace(",", "").trim());
			ipo.setSopipdiameteros(Utility.getName(salesBasicPo.getSsesbdiameteros()).replace(",", "").trim());
			ipo.setSopipconlenvaod(Utility.getName(salesBasicPo.getSsesbconlenvaod()).replace(",", "").trim());
			ipo.setSopipconlenvaos(Utility.getName(salesBasicPo.getSsesbconlenvaos()).replace(",", "").trim());
			ipo.setSopipdignosisre(Utility.getName(salesBasicPo.getSsesbdignosisre()));
			ipos.add(ipo);
		}
		
		if (!"".equals(Utility.getName(toMailPo.getSsetmtomaillistid()))){  // 根据是否填写过邮寄单判断是否新增邮寄信息
			toMailPo.setSsetmuuid(this.uuid.generate());
			toMailPo.setSsetmcustomerid(customerInfoPo.getSmecicustomerid());			
			toMailPo.setSsetmcreatepensonid(createPerson);
			toMailPo.setSsetmcreatepensonname(loginPersonInfoPo.getPersonName());
			toMailPo.setSsetmlinksalesid(salseID);
		}
		
		frameSalesMgr.insertShopSalesMain(salesBasicPo,salesDetailPo,giftsPo,inTransitPo,specialPDetailList,additionalCDetailList,ipos,opo,obpo,nwtype,logPo,toMailPo);
		
		DepartmentsPo dpo = new DepartmentsPo();
		dpo.setBdpdepartmentid(loginPersonInfoPo.getDepartmentID());
		DepartmentsPo departmentsPo = departmentsMgr.getDepartment(dpo);
		
		if("1".equals(departmentsPo.getBdpsalestype())){
			String salseSuccessMsg="顾客:"+customerInfoPo.getSmeciname()+"  销售单"+salseID+"提交成功";
			request.setAttribute("url", "'selGuitarManagementOpen.action?moduleID=S0402&hid="+salseID+"&autopay=3&memberId="+customerInfoPo.getSmecimemberid()+"&ssesborderstype="+salesBasicPo.getSsesborderstype()+"'");
			this.clearMessages();
			this.addActionMessage(getText(salseSuccessMsg));
			request.setAttribute("flag", GlobalConstants.MOVE);
		}else{
			String salseSuccessMsg="顾客:"+customerInfoPo.getSmeciname()+"  销售单"+salseID+"提交成功";
			request.setAttribute("url", "'initShopSalesMain.action?moduleID="+moduleID+"'");
			this.clearMessages();
			this.addActionMessage(getText(salseSuccessMsg));
			request.setAttribute("flag", GlobalConstants.MOVE);
		}		
		
		return SUCCESS;
	}
	
	public void getSalerPersonList() throws Exception {
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		String tid = Utility.getName(request.getParameter("tid"));
		String tdptid = Utility.getName(request.getParameter("tdptid"));
		
		PrintWriter out;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();
		
		if(tdptid.equals("")){
			out.println("<option value=''>----请选择----</option>");
		}else{

			personInfoPos = personInfoMgr.getPersoninfoPoListByJobType("1",tdptid,systemParameterPo);
			Iterator<PersonInfoPo> itp = personInfoPos.iterator();
			while (itp.hasNext()){
				PersonInfoPo ppo = (PersonInfoPo)itp.next();
				if("1".equals(systemParameterPo.getFspisusegoodslevel())){
					out.println("<option value='" + Utility.getName(ppo.getId()) + "' discount= '"+ Utility.getName(ppo.getPersonDiscount()) + "' " + (tid.equals(Utility.getName(ppo.getId())) ? "selected='selected'" : ""));
					
					for(int i=0; i<ppo.getPersonDiscountDetailsPos().size(); i++){
						out.println(" " +ppo.getPersonDiscountDetailsPos().get(i).getFpddgoodslevel()+ "=" +ppo.getPersonDiscountDetailsPos().get(i).getFpdddiscount()+" ");
					}
					
					out.println(">" + Utility.getName(ppo.getPersonName())+"</option>");
				}else{
					out.println("<option value='" + Utility.getName(ppo.getId()) + "' discount= '"+ Utility.getName(ppo.getPersonDiscount()) + "' " + (tid.equals(Utility.getName(ppo.getId())) ? "selected='selected'" : "") + ">" + Utility.getName(ppo.getPersonName()) + "</option>");
				}
			}			
		}
		
		out.close();			
	}
	
	public void getTakeGlassShopCodeList() throws Exception {
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		String tdptid = Utility.getName(request.getParameter("tdptid"));
		
		PrintWriter out;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();
		
		DepartmentsPo tpo = new DepartmentsPo();
		tpo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		departmentsList = departmentsMgr.getDepartmentsByCompanyID(tpo);
		
		for (int i = 0; i < departmentsList.size(); i++){
			DepartmentsPo dpo = departmentsList.get(i);
			out.println("<option takeglassdate='" + Utility.getName(dpo.getBdptakeglassdate()) + "' value='" + Utility.getName(dpo.getBdpdepartmentid()) + "' " + (tdptid.equals(Utility.getName(dpo.getBdpdepartmentid())) ? "selected='selected'" : "") + ">" + Utility.getName(dpo.getBdpdepartmentname()) + "</option>");
		}

		out.close();			
	}
	
	/**
	 * 销售页面初始化邮寄信息
	 */
	public String initMailInfoInsert() throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
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
			
		mailingList = mailingListMgr.getMailingList();
		
		return SUCCESS;
	}
	
	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}

	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}

	public InspectionMgr getInspectionMgr() {
		return inspectionMgr;
	}

	public void setInspectionMgr(InspectionMgr inspectionMgr) {
		this.inspectionMgr = inspectionMgr;
	}

	public DiscountShortcutKeysMgr getDiscountShortcutKeysMgr() {
		return discountShortcutKeysMgr;
	}

	public void setDiscountShortcutKeysMgr(
			DiscountShortcutKeysMgr discountShortcutKeysMgr) {
		this.discountShortcutKeysMgr = discountShortcutKeysMgr;
	}

	public List<DiscountShortcutKeysPo> getDiscountShortcutKeysPolist() {
		return discountShortcutKeysPolist;
	}

	public void setDiscountShortcutKeysPolist(
			List<DiscountShortcutKeysPo> discountShortcutKeysPolist) {
		this.discountShortcutKeysPolist = discountShortcutKeysPolist;
	}

	public SalesSpecialPo getSalesSpecialPo() {
		return salesSpecialPo;
	}

	public void setSalesSpecialPo(SalesSpecialPo salesSpecialPo) {
		this.salesSpecialPo = salesSpecialPo;
	}

	public List<SalesSpecialPo> getSpecial1List() {
		return special1List;
	}

	public void setSpecial1List(List<SalesSpecialPo> special1List) {
		this.special1List = special1List;
	}
	
	public LogisticsLogMgr getLogisticsLogMgr() {
		return logisticsLogMgr;
	}

	public void setLogisticsLogMgr(LogisticsLogMgr logisticsLogMgr) {
		this.logisticsLogMgr = logisticsLogMgr;
	}

	public WindowPersonDiscountMgr getWindowPersonDiscountMgr() {
		return windowPersonDiscountMgr;
	}

	public void setWindowPersonDiscountMgr(
			WindowPersonDiscountMgr windowPersonDiscountMgr) {
		this.windowPersonDiscountMgr = windowPersonDiscountMgr;
	}

	public LoginMgr getLoginMgr() {
		return loginMgr;
	}

	public void setLoginMgr(LoginMgr loginMgr) {
		this.loginMgr = loginMgr;
	}

	public PersonInfoPo getPersonInfoPo() {
		return personInfoPo;
	}

	public void setPersonInfoPo(PersonInfoPo personInfoPo) {
		this.personInfoPo = personInfoPo;
	}
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public SpecialPDetailPo getSpecialPDetailPo() {
		return specialPDetailPo;
	}

	public void setSpecialPDetailPo(SpecialPDetailPo specialPDetailPo) {
		this.specialPDetailPo = specialPDetailPo;
	}

	public AdditionalCDetailPo getAdditionalCDetailPo() {
		return additionalCDetailPo;
	}

	public void setAdditionalCDetailPo(AdditionalCDetailPo additionalCDetailPo) {
		this.additionalCDetailPo = additionalCDetailPo;
	}

	public AdditionalCDetailMgr getAdditionalCDetailMgr() {
		return additionalCDetailMgr;
	}

	public void setAdditionalCDetailMgr(AdditionalCDetailMgr additionalCDetailMgr) {
		this.additionalCDetailMgr = additionalCDetailMgr;
	}

	public SpecialPDetailMgr getSpecialPDetailMgr() {
		return specialPDetailMgr;
	}

	public void setSpecialPDetailMgr(SpecialPDetailMgr specialPDetailMgr) {
		this.specialPDetailMgr = specialPDetailMgr;
	}

	public WarehouseConfigurationMgr getWarehouseConfigurationMgr() {
		return warehouseConfigurationMgr;
	}

	public void setWarehouseConfigurationMgr(
			WarehouseConfigurationMgr warehouseConfigurationMgr) {
		this.warehouseConfigurationMgr = warehouseConfigurationMgr;
	}

	public AdditionalCostsPo getAdditionalCostsPo() {
		return additionalCostsPo;
	}

	public void setAdditionalCostsPo(AdditionalCostsPo additionalCostsPo) {
		this.additionalCostsPo = additionalCostsPo;
	}

	public SpecialRequirementsPo getSpecialRequirementsPo() {
		return specialRequirementsPo;
	}

	public void setSpecialRequirementsPo(SpecialRequirementsPo specialRequirementsPo) {
		this.specialRequirementsPo = specialRequirementsPo;
	}

	public GiftsPo getGiftsPo() {
		return giftsPo;
	}

	public void setGiftsPo(GiftsPo giftsPo) {
		this.giftsPo = giftsPo;
	}

	public SalesDetailPo getSalesDetailPo() {
		return salesDetailPo;
	}

	public void setSalesDetailPo(SalesDetailPo salesDetailPo) {
		this.salesDetailPo = salesDetailPo;
	}

	public AdditionalCostsMgr getAdditionalCostsMgr() {
		return additionalCostsMgr;
	}

	public void setAdditionalCostsMgr(AdditionalCostsMgr additionalCostsMgr) {
		this.additionalCostsMgr = additionalCostsMgr;
	}

	public List<AdditionalCostsPo> getAdditionalCostsList() {
		return additionalCostsList;
	}

	public void setAdditionalCostsList(List<AdditionalCostsPo> additionalCostsList) {
		this.additionalCostsList = additionalCostsList;
	}

	public SpecialRequirementsMgr getSpecialRequirementsMgr() {
		return specialRequirementsMgr;
	}

	public void setSpecialRequirementsMgr(
			SpecialRequirementsMgr specialRequirementsMgr) {
		this.specialRequirementsMgr = specialRequirementsMgr;
	}

	public List<SpecialRequirementsPo> getSpecialList() {
		return specialList;
	}

	public void setSpecialList(List<SpecialRequirementsPo> specialList) {
		this.specialList = specialList;
	}

	public GiftsMgr getGiftsMgr() {
		return giftsMgr;
	}

	public void setGiftsMgr(GiftsMgr giftsMgr) {
		this.giftsMgr = giftsMgr;
	}

	public List<GiftsPo> getGiftsList() {
		return giftsList;
	}

	public void setGiftsList(List<GiftsPo> giftsList) {
		this.giftsList = giftsList;
	}

	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public FrameSalesMgr getFrameSalesMgr() {
		return frameSalesMgr;
	}

	public void setFrameSalesMgr(FrameSalesMgr frameSalesMgr) {
		this.frameSalesMgr = frameSalesMgr;
	}

	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	public List<InspectionPo> getInspectionPos() {
		return inspectionPos;
	}

	public void setInspectionPos(List<InspectionPo> inspectionPos) {
		this.inspectionPos = inspectionPos;
	}

	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}
	
	public List<PersonInfoPo> getPersonInfoPos() {
		return personInfoPos;
	}
	public void setPersonInfoPos(List<PersonInfoPo> personInfoPos) {
		this.personInfoPos = personInfoPos;
	}
	public List<PersonInfoPo> getOptometryPersonInfoPos() {
		return optometryPersonInfoPos;
	}
	public void setOptometryPersonInfoPos(List<PersonInfoPo> optometryPersonInfoPos) {
		this.optometryPersonInfoPos = optometryPersonInfoPos;
	}
	public UnitMgr getUnitMgr() {
		return unitMgr;
	}
	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}
	public List<ForeignRecipelPo> getForeignRecipelPos() {
		return foreignRecipelPos;
	}
	public void setForeignRecipelPos(List<ForeignRecipelPo> foreignRecipelPos) {
		this.foreignRecipelPos = foreignRecipelPos;
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
	public CompanyNameMgr getCompanyNameMgr() {
		return companyNameMgr;
	}
	public void setCompanyNameMgr(CompanyNameMgr companyNameMgr) {
		this.companyNameMgr = companyNameMgr;
	}
	public CompanyNamePo getCompanyNamePo() {
		return companyNamePo;
	}
	public void setCompanyNamePo(CompanyNamePo companyNamePo) {
		this.companyNamePo = companyNamePo;
	}
	public List<PersonInfoPo> getYishiPersonInfoPos() {
		return yishiPersonInfoPos;
	}
	public void setYishiPersonInfoPos(List<PersonInfoPo> yishiPersonInfoPos) {
		this.yishiPersonInfoPos = yishiPersonInfoPos;
	}
	public List<OptionParamPo> getOptionParamPolist() {
		return optionParamPolist;
	}
	public void setOptionParamPolist(List<OptionParamPo> optionParamPolist) {
		this.optionParamPolist = optionParamPolist;
	}
	public OptionParamMgr getOptionParamMgr() {
		return optionParamMgr;
	}
	public void setOptionParamMgr(OptionParamMgr optionParamMgr) {
		this.optionParamMgr = optionParamMgr;
	}
	public CustomerInfoPo getCustomerInfoPo2() {
		return customerInfoPo2;
	}
	public void setCustomerInfoPo2(CustomerInfoPo customerInfoPo2) {
		this.customerInfoPo2 = customerInfoPo2;
	}
	public ToMailPo getToMailPo() {
		return toMailPo;
	}
	public void setToMailPo(ToMailPo toMailPo) {
		this.toMailPo = toMailPo;
	}
	public MailingListMgr getMailingListMgr() {
		return mailingListMgr;
	}
	public void setMailingListMgr(MailingListMgr mailingListMgr) {
		this.mailingListMgr = mailingListMgr;
	}
	public List<MailingListPo> getMailingList() {
		return mailingList;
	}
	public void setMailingList(List<MailingListPo> mailingList) {
		this.mailingList = mailingList;
	}
	public PersonDiscountMgr getPersonDiscountMgr() {
		return personDiscountMgr;
	}
	public void setPersonDiscountMgr(PersonDiscountMgr personDiscountMgr) {
		this.personDiscountMgr = personDiscountMgr;
	}
	
}
