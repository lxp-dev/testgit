/**
 * 
 */
package com.pengsheng.eims.sales.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.mgr.WarehouseConfigurationMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.logistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.AccSalesMgr;
import com.pengsheng.eims.sales.mgr.AdditionalCDetailMgr;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.system.mgr.AdditionalCostsMgr;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
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
public class AccSalesAction extends BaseAction {

	private PersonPermissionMgr personPermissionMgr;
	
	private CustomerInfoPo customerInfoPo;

	private List<InspectionPo> inspectionPos;

	private SalesBasicPo salesBasicPo;
	
	private AdditionalCostsMgr additionalCostsMgr;
	
	private List<AdditionalCostsPo> additionalCostsList;
	
	private SalesDetailPo salesDetailPo;
	
	private AdditionalCostsPo additionalCostsPo;
	
	private WarehouseConfigurationMgr warehouseConfigurationMgr;
	
	private AdditionalCDetailMgr additionalCDetailMgr;
	
	private AdditionalCDetailPo additionalCDetailPo;
	
	private AccSalesMgr accSalesMgr;
	
	private WarehouseMgr warehouseMgr; 
	
	private DiscountShortcutKeysMgr discountShortcutKeysMgr;
	
	private List<DiscountShortcutKeysPo> discountShortcutKeysPolist;
	
	private LogisticsLogMgr logisticsLogMgr = null;
	
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
	 * 初始化辅料销售
	 */
	public String initAccSales() throws Exception {
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

		if (customerInfoPo != null && StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			request.removeAttribute("salseSuccessMsg");
			customerInfoPo.setSmecicustomerid("");
			customerInfoPo = accSalesMgr.getCustomerInfo(customerInfoPo);
			
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday()
						.substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR)
						- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmdown(Integer.toString(age));
			}

		}else{
			customerInfoPo = accSalesMgr.getCustomerInfo(null);			
		}
		
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
	public String accSalse(){
		//生成配镜单号
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
		
		//王磊06/27
		salesBasicPo.setSsesblocation(loginPersonInfoPo.getDepartmentID());
		//王磊06/27
		
		salesBasicPo.setSsesbcustomerid(customerInfoPo.getSmecicustomerid());
		salesBasicPo.setSsesbsalerid(personInfoPo.getId());
		salesBasicPo.setSsesbintransit("1"); //在途。
		salesBasicPo.setSsesbvalueflag("0");
		salesBasicPo.setSsesbsalestype("");//销售类型 内方外方
		salesBasicPo.setSsesbdiscountrate(Utility.getName(salesBasicPo.getSsesbdiscountrate()).equals("")?"1.00":salesBasicPo.getSsesbdiscountrate());
		salesBasicPo.setSsesbarrearsvalue(Utility.getName(salesBasicPo.getSsesbarrearsvalue()).equals("")?"0.00":salesBasicPo.getSsesbarrearsvalue());
		salesBasicPo.setSsesbpsalsvalue(Utility.getName(salesBasicPo.getSsesbpsalsvalue()).equals("")?"0.00":salesBasicPo.getSsesbpsalsvalue());
		salesBasicPo.setSsesbsalestype("3");
		
		String createPerson = personInfoPo.getId(); 
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID 
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("辅料销售销售单："+salseID+" 新增");
		
		/*
		 * 
		 * 订单类型及出仓设置
		 */
		WarehouseConfigurationPo tempWarehouseConfigurationPo = new WarehouseConfigurationPo();
		tempWarehouseConfigurationPo.setBwcdeptid(loginPersonInfoPo.getDepartmentID());
		WarehouseConfigurationPo warehouseConfigurationPo=warehouseConfigurationMgr.getWarehouseConfiguration(tempWarehouseConfigurationPo);
		salesBasicPo.setSsesborderstype("5");
		String[] ssesdstockids=new String[100];
		for(int i=1;i<salesDetailPo.getSsesdcommoditiesflags().length;i++){
			if("5".equals(salesDetailPo.getSsesdcommoditiesflags()[i])){
				ssesdstockids[i]=warehouseConfigurationPo.getBwcstockid7();  //隐形辅料出仓
			}else if("2".equals(salesDetailPo.getSsesdcommoditiesflags()[i])){
				ssesdstockids[i]=warehouseConfigurationPo.getBwcstockid2();//镜架辅料出仓
			}else if("7".equals(salesDetailPo.getSsesdcommoditiesflags()[i])){
				ssesdstockids[i]=warehouseConfigurationPo.getBwcstockid9();//其他商品出仓
			}else if("6".equals(salesDetailPo.getSsesdcommoditiesflags()[i])){
				ssesdstockids[i]=warehouseConfigurationPo.getBwcstockid8();//成镜出仓
			}else if("1".equals(salesDetailPo.getSsesdcommoditiesflags()[i])){
				ssesdstockids[i]=warehouseConfigurationPo.getBwcstockid1();//镜架出仓
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
		
		accSalesMgr.insertSalesBasic(salesBasicPo,salesDetailPo,null,inTransitPo,logPo);
		
		
		/*
		 * 销售成功开窗
		 */
		
		String salseSuccessMsg="顾客:"+customerInfoPo.getSmeciname()+"  销售单"+salseID+"提交成功";
		request.setAttribute("url", "'initAccSales.action?moduleID="+moduleID+"'");
		this.clearMessages();
		this.addActionMessage(getText(salseSuccessMsg));
		request.setAttribute("flag", GlobalConstants.MOVE);
		return SUCCESS;
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

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public AccSalesMgr getAccSalesMgr() {
		return accSalesMgr;
	}

	public void setAccSalesMgr(AccSalesMgr accSalesMgr) {
		this.accSalesMgr = accSalesMgr;
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
	
	public LogisticsLogMgr getLogisticsLogMgr() {
		return logisticsLogMgr;
	}

	public void setLogisticsLogMgr(LogisticsLogMgr logisticsLogMgr) {
		this.logisticsLogMgr = logisticsLogMgr;
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
