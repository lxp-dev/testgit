/**
 * 
 */
package com.pengsheng.eims.sales.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.mgr.WarehouseConfigurationMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.logistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.AdditionalCDetailMgr;
import com.pengsheng.eims.sales.mgr.ConSalesMgr;
import com.pengsheng.eims.sales.mgr.InspectionMgr;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.system.mgr.AdditionalCostsMgr;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.DiscountShortcutKeysMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.AdditionalCostsPo;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.DiscountShortcutKeysPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author Liuqian
 * 
 */
public class ConSalesAction extends BaseAction {
	
	private LogisticsLogMgr logisticsLogMgr = null;
	
	private PersonPermissionMgr personPermissionMgr;

	private CustomerInfoPo customerInfoPo;

	private List<InspectionPo> inspectionPos;

	private SalesBasicPo salesBasicPo;
	
	private DepartmentsMgr departmentsMgr;
	
	private List<DepartmentsPo> departmentsList;
	
	private AdditionalCostsMgr additionalCostsMgr;
	
	private List<AdditionalCostsPo> additionalCostsList;
	
	private SalesDetailPo salesDetailPo;
	
	private AdditionalCostsPo additionalCostsPo;
	
	private WarehouseConfigurationMgr warehouseConfigurationMgr;
	
	private AdditionalCDetailMgr additionalCDetailMgr;
	
	private AdditionalCDetailPo additionalCDetailPo;
	
	private ConSalesMgr conSalesMgr;
	
	private DiscountShortcutKeysMgr discountShortcutKeysMgr;
	
	private List<DiscountShortcutKeysPo> discountShortcutKeysPolist;
	
	private InspectionMgr inspectionMgr;
	
	private List<PersonInfoPo> personInfoPos;
	
	private PersonInfoMgr personInfoMgr;

	private CompanyNamePo companyNamePo;
	
	private CompanyNameMgr companyNameMgr;
	
	
	public CompanyNamePo getCompanyNamePo() {
		return companyNamePo;
	}
	public void setCompanyNamePo(CompanyNamePo companyNamePo) {
		this.companyNamePo = companyNamePo;
	}
	public CompanyNameMgr getCompanyNameMgr() {
		return companyNameMgr;
	}
	public void setCompanyNameMgr(CompanyNameMgr companyNameMgr) {
		this.companyNameMgr = companyNameMgr;
	}
	/*
	 * 
	 * 初始化隐形销售
	 */
	public String initConSales() throws Exception {
		/*
		 * 生成销售单号
		 */
		PersonInfoPo loginPersonInfoPo = (PersonInfoPo) session.get("person");
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String salseID = "X" + loginPersonInfoPo.getDepartmentID()
		+ loginPersonInfoPo.getMachinery() + numHeadFormat.format(new Date());
		
		request.setAttribute("salseID", salseID);
		
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		
		personInfoPos = personInfoMgr.getModulePersoninfoPoList(moduleID,loginPersonInfoPo.getDepartmentID());
		request.setAttribute("moduleID", moduleID);

		if (customerInfoPo != null
				&& StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			request.removeAttribute("salseSuccessMsg");
			customerInfoPo.setSmecicustomerid("");
			customerInfoPo = conSalesMgr.getCustomerInfo(customerInfoPo);
			
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday()
						.substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR)
						- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmdown(Integer.toString(age));
			}

			// 取顾客最新验光记录
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {
				inspectionPos = conSalesMgr.getInspectionPos(customerInfoPo
						.getSmecicustomerid());
			}
		}

		
		//框镜销售，取镜地点填充 , 所有门店
		departmentsList=departmentsMgr.getDepartments("1");
		
		
		//附加费填充
		additionalCostsList=additionalCostsMgr.getAdditionalCostsList();
		
		//打折快捷键填充sxh
		discountShortcutKeysPolist = discountShortcutKeysMgr.getEnableDiscountShortcutKeysPoList("1");
		
		// 得到公司名称设定表中的信息
		companyNamePo = companyNameMgr.getCompanyName(companyNamePo);
		
		return SUCCESS;
	}
	/**
	 * 结算。 
	 * @return
	 */
	public String conSalse(){
		PersonInfoPo personInfoPo = new PersonInfoPo();
		personInfoPo.setId(salesBasicPo.getSsesbsalerid());
		personInfoPo=personInfoMgr.getPersonInfo(personInfoPo);
		PersonInfoPo loginPersonInfoPo = (PersonInfoPo) session.get("person");
//		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//		String salseID = "X" + loginPersonInfoPo.getDepartmentID()
//		+ loginPersonInfoPo.getMachinery() + numHeadFormat.format(new Date());
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		personInfoPos = personInfoMgr.getModulePersoninfoPoList(moduleID,loginPersonInfoPo.getDepartmentID());
		
		request.setAttribute("moduleID", moduleID);
		
		String salseID = request.getParameter("salseID");
		//销售基表填充
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
		salesBasicPo.setSsesbrecipetype("4");
		

		String createPerson = personInfoPo.getId(); 
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("隐形销售销售单："+salseID+" 新增");
				
		
		/*
		 * 
		 * 订单类型及出仓设置
		 */
		WarehouseConfigurationPo tempWarehouseConfigurationPo = new WarehouseConfigurationPo();
		tempWarehouseConfigurationPo.setBwcdeptid(loginPersonInfoPo.getDepartmentID());
		WarehouseConfigurationPo warehouseConfigurationPo=warehouseConfigurationMgr.getWarehouseConfiguration(tempWarehouseConfigurationPo);
		salesBasicPo.setSsesborderstype("3");
		String[] ssesdstockids=new String[100];
		for(int i=1;i<salesDetailPo.getIscustomizes().length;i++){
			if("5".equals(salesDetailPo.getSsesdcommoditiesflags()[i])){
				ssesdstockids[i]=warehouseConfigurationPo.getBwcstockid7();  //隐形辅料出仓
			}else if("4".equals(salesDetailPo.getSsesdcommoditiesflags()[i])){
				ssesdstockids[i]=warehouseConfigurationPo.getBwcstockid5();//隐形成品出仓
			}
			if("D".equals(salesDetailPo.getIscustomizes()[i])){
				salesBasicPo.setSsesborderstype("4");
				ssesdstockids[i]=warehouseConfigurationPo.getBwcstockid6();//隐形订做出仓
				salesDetailPo.getSsesditemids()[i]="";
			}
			
			salesDetailPo.setSsesdstockids(ssesdstockids);
		}
		
		
		
		//销售明细填充
		
		salesDetailPo.setSsesdsalesid(salseID);
		
		
		
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
		
		conSalesMgr.insertSalesBasic(salesBasicPo,salesDetailPo,null,inTransitPo,logPo);
		
		
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
			
			OptometryPo opo = new OptometryPo();
			opo.setSopoyoptometryid(optometryID);
			opo.setSopoyoptometrybasicid(optometryBasicID);
			opo.setSopoycustomerid(customerID);
			opo.setSopoyshopcode(loginPersonInfoPo.getDepartmentID());
			opo.setSopoypersonid("wbygs");
			opo.setSopoytime(nowTime);
			opo.setSopoyflag("1");
			opo.setSopoyupdateuserid("");
			opo.setSopoyrecipeupdatetime("");
			opo.setSopoyisinternal("W");
			
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
			ipo.setSopipusername("wbygs");
			ipo.setSopipglasstype("4");
			
			ipo.setSopipballglassod(salesBasicPo.getSsesbballglassod());
			ipo.setSopipballglassos(salesBasicPo.getSsesbballglassos());
			ipo.setSopippostglassod(salesBasicPo.getSsesbpostglassod());
			ipo.setSopippostglassos(salesBasicPo.getSsesbpostglassos());
			ipo.setSopipaxesod(salesBasicPo.getSsesbaxesod());
			ipo.setSopipaxesos(salesBasicPo.getSsesbaxesos());
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
			logPo1.setsLogContent("隐形外方录入验光号："+optometryID+" 新增");
			inspectionMgr.inspectionInsert(ipos,opo,obpo,logPo1);
		
		
		}
		
		
		/*
		 * 销售成功开窗
		 */
		String salseSuccessMsg="顾客:"+customerInfoPo.getSmeciname()+" 销售单"+salseID+"提交成功";
		request.setAttribute("url", "'initConSales.action?moduleID="+moduleID+"'");
		this.clearMessages();
		this.addActionMessage(getText(salseSuccessMsg));
		request.setAttribute("flag", GlobalConstants.MOVE);
		return SUCCESS;
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

	public LogisticsLogMgr getLogisticsLogMgr() {
		return logisticsLogMgr;
	}

	public void setLogisticsLogMgr(LogisticsLogMgr logisticsLogMgr) {
		this.logisticsLogMgr = logisticsLogMgr;
	}
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public ConSalesMgr getConSalesMgr() {
		return conSalesMgr;
	}

	public void setConSalesMgr(ConSalesMgr conSalesMgr) {
		this.conSalesMgr = conSalesMgr;
	}

	public SalesDetailPo getSalesDetailPo() {
		return salesDetailPo;
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
	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}
	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}
}
