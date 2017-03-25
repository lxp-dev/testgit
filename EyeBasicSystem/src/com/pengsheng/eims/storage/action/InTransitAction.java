package com.pengsheng.eims.storage.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.StatusModulePo;
import com.pengsheng.eims.components.mgr.InTransitDetailsMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.dao.ProcurementOrdersDao;
import com.pengsheng.eims.storage.mgr.InTransitMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class InTransitAction extends BaseAction {
	
	private List<DepartmentsPo> deptList;
	
	private List<SalesBasicPo> salesBasicList;

	private SalesBasicPo po;
	
	private PersonPermissionMgr personPermissionMgr;
	
	private List<DepartmentsPo> departmentsList;
	
	private DepartmentsMgr departmentsMgr;
	
	private SalesBasicPo salesBasicPo;	
	
	private List<InTransitPo> inTransitList;	
	
	private ProcurementOrdersDao procurementOrdersDao;
	
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
		
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

	public ProcurementOrdersDao getProcurementOrdersDao() {
		return procurementOrdersDao;
	}
	public void setProcurementOrdersDao(ProcurementOrdersDao procurementOrdersDao) {
		this.procurementOrdersDao = procurementOrdersDao;
	}
	
	public List<InTransitPo> getInTransitList() {
		return inTransitList;
	}

	public void setInTransitList(List<InTransitPo> inTransitList) {
		this.inTransitList = inTransitList;
	}

	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
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

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public SalesBasicPo getPo() {
		return po;
	}

	public void setPo(SalesBasicPo po) {
		this.po = po;
	}

	public List<SalesBasicPo> getSalesBasicList() {
		return salesBasicList;
	}

	public void setSalesBasicList(List<SalesBasicPo> salesBasicList) {
		this.salesBasicList = salesBasicList;
	}

	private InTransitMgr inTransitMgr;
	private InTransitDetailsMgr inTransitDetailsMgr;
	
	public InTransitDetailsMgr getInTransitDetailsMgr() {
		return inTransitDetailsMgr;
	}

	public void setInTransitDetailsMgr(InTransitDetailsMgr inTransitDetailsMgr) {
		this.inTransitDetailsMgr = inTransitDetailsMgr;
	}

	private DepartmentsPo departmentsPo;
	
	public DepartmentsPo getDepartmentsPo() {
		return departmentsPo;
	}

	public void setDepartmentsPo(DepartmentsPo departmentsPo) {
		this.departmentsPo = departmentsPo;
	}

	public InTransitMgr getInTransitMgr() {
		return inTransitMgr;
	}

	public void setInTransitMgr(InTransitMgr inTransitMgr) {
		this.inTransitMgr = inTransitMgr;
	}

	public List<DepartmentsPo> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<DepartmentsPo> deptList) {
		this.deptList = deptList;
	}

	/**
	 * 初始化在途查询页面
	 */
	public String initInTransitSel(){	
		
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
		
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			departmentsList = this.getShopCodeListByCompany(systemParameterPo,personInfoPo);
		}else{			
			departmentsList = departmentsMgr.getDepartments(null,null,"");
		}
		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "tranSel";
		}
		request.setAttribute("personInfoPo", personInfoPo);
		return SUCCESS;
	}
	/**
	 * 查看在途信息
	 * @return
	 * @throws Exception
	 */
    public String selectInTransit()throws Exception{
    	
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
		
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			departmentsList = this.getShopCodeListByCompany(systemParameterPo,personInfoPo);
		}else{			
			departmentsList = departmentsMgr.getDepartments(null,null,"");
		}	
		
    	//查询条件memberid
		String selcstpsupplierid = Utility.getName(request.getParameter("selcstpsupplierid"));
		String selbspsuppliername = Utility.getName(request.getParameter("selbspsuppliername"));
		
		String chooseflag=Utility.getName(request.getParameter("chooseflag"));
		String memberid=Utility.getName(request.getParameter("memberid"));
    	String salesid=Utility.getName(request.getParameter("salesid"));
    	String oldSalesID="";
    	String customerName=Utility.getName(request.getParameter("customerName"));
    	String shopcode=Utility.getName(request.getParameter("departmentid"));
    	String salesdatestarttime=Utility.getName(request.getParameter("salesdatestarttime"));
    	String salesdateendtime=Utility.getName(request.getParameter("salesdateendtime"));    	
    	String takeglassstartdata=Utility.getName(request.getParameter("takeglassstartdata"));
    	String takeglassenddata=Utility.getName(request.getParameter("takeglassenddata"));
    	String worrytype=Utility.getName(request.getParameter("worrytype"));    
    	String intransittype=Utility.getName(request.getParameter("intransittype")); 
    	String intransittype2=Utility.getName(request.getParameter("intransittype2")); 
    	String intransit=Utility.getName(request.getParameter("intransit"));  
    	String intransit2=Utility.getName(request.getParameter("intransit2")); 
    	String posdatestarttime=Utility.getName(request.getParameter("posdatestarttime"));
    	String posdateendtime=Utility.getName(request.getParameter("posdateendtime"));  
    	String customerphone=Utility.getName(request.getParameter("customerphone"));
    	String checkout=Utility.getName(request.getParameter("checkout"));
    	String outpricestrattime=Utility.getName(request.getParameter("outpricestarttime"));
    	String outpriceendtime=Utility.getName(request.getParameter("outpriceendtime"));    	
    	String setmealtype=Utility.getName(request.getParameter("setmealtype"));
    	String setmealtitle=Utility.getName(request.getParameter("setmealtitle"));
    	String usesetmeal=Utility.getName(request.getParameter("usesetmeal"));
    	String salerID=Utility.getName(request.getParameter("salerID"));    	
    	String intransittype3=Utility.getName(request.getParameter("intransittype3")); 
    	String intransittype4=Utility.getName(request.getParameter("intransittype4")); 
    	String intransit3=Utility.getName(request.getParameter("intransit3"));  
    	String intransit4=Utility.getName(request.getParameter("intransit4"));
    	String yjzt = Utility.getName(request.getParameter("yjzt")); 
    	String djsbm = Utility.getName(request.getParameter("djsbm")); 
    	String ordertype = Utility.getName(request.getParameter("ordertype")); 
    	String salesremark = Utility.getName(request.getParameter("salesremark")); 
    	
    	if(salesid!=null&&!salesid.equals("")&&(salesid.substring(0, 1).equalsIgnoreCase("W")||salesid.substring(0, 1).equalsIgnoreCase("R")||salesid.substring(0, 1).equalsIgnoreCase("B"))){    
    		oldSalesID = salesid;
    		salesid = inTransitDetailsMgr.getOldSalesID(salesid).getSseitysalesid();
    		if(salesid==null||salesid.equals("")){
    			salesid=oldSalesID;
    		}
    	}
    	
    	SalesBasicPo po=new SalesBasicPo();
    	po.setSsesbphone(customerphone);
    	po.setSsesbordertype(ordertype);
    	po.setSsesbsalesid(salesid);
    	po.setSsesbcustomerid(customerName);
    	po.setSsesbshopcode(shopcode);
    	po.setSsesbsalesdatestarttime(salesdatestarttime);
    	po.setSsesbsalesdateendtime(salesdateendtime);
    	po.setSsesbtakeglassstartdata(takeglassstartdata);
    	po.setSsesbtakeglassenddata(takeglassenddata);
    	po.setSsesbdepid(personInfoPo.getDepartmentID());
    	po.setSsesbdepartmenttype(personInfoPo.getDepartmenttype());
    	po.setSsesbchooseflag(chooseflag);
    	po.setSsesbMemberId(memberid);
    	po.setSsesbworrytype(worrytype);
    	po.setPosdatestarttime(posdatestarttime);
    	po.setPosdateendtime(posdateendtime);
    	po.setSsesbcheckoutflag(checkout);
    	po.setSsesbsalerid(salerID);
    	po.setSsesbintransitfinished(yjzt);
    	po.setDjsbm(djsbm);
    	po.setSsesbsupplierid(selcstpsupplierid);
    	if (yjzt.equals("1")){
        	po.setSsesbintransit(intransit);
        	po.setSsesbintransittype(intransittype);
        	po.setSsesbintransit2(intransit2);
        	po.setSsesbintransittype2(intransittype2);
    	}else{
        	po.setSsesbintransit(intransit3);
        	po.setSsesbintransittype(intransittype3);
        	po.setSsesbintransit2(intransit4);
        	po.setSsesbintransittype2(intransittype4);
        	
        	po.setOutpricestrattime(outpricestrattime);
        	po.setOutpriceendtime(outpriceendtime);
    	}
    	
    	if (usesetmeal.equals("1")){
    		po.setSsesbsetmealtitle(setmealtitle);
    		po.setSsesbsetmealtype(setmealtype);    		
    	}
    	po.setSsesbusesetmealflag(usesetmeal);		
		po.setSsesbsalesremark(salesremark);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setSmecishoplist(departmentsList);
		}		

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
    	
    	//查询分页
    	int count = inTransitMgr.getInTransitCount(po);
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
		    salesBasicList=inTransitMgr.getInTransitList(po, page.getStart(),page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			salesBasicList = null;
		}
		
		//显示查询条件
		request.setAttribute("salesid", salesid);
		if(oldSalesID!=null&&!oldSalesID.equals("")&&oldSalesID.substring(0, 1).equals("W")){    
    		request.setAttribute("salesid", oldSalesID);
    	}
		
		request.setAttribute("selcstpsupplierid", selcstpsupplierid);
		request.setAttribute("selbspsuppliername", selbspsuppliername);
		request.setAttribute("customerphone", customerphone);
		request.setAttribute("departmentid", shopcode);
		request.setAttribute("customerName", customerName);
		request.setAttribute("ssesbsalesdatestarttime", salesdatestarttime);
		request.setAttribute("ssesbsalesdateendtime",salesdateendtime);
		request.setAttribute("ssesbtakeglassstartdata", takeglassstartdata);
		request.setAttribute("ssesbtakeglassenddata", takeglassenddata);
		request.setAttribute("smecimemberid", memberid);
		request.setAttribute("chooseflag", chooseflag);
		request.setAttribute("personInfoPo", personInfoPo);
		request.setAttribute("worrytype", worrytype);
		request.setAttribute("posdatestarttime", posdatestarttime);
		request.setAttribute("posdateendtime",posdateendtime);
		request.setAttribute("checkout",checkout);
		request.setAttribute("usesetmeal",usesetmeal);
		request.setAttribute("setmealtype",setmealtype);
		request.setAttribute("setmealtitle",setmealtitle);
		request.setAttribute("salerID",salerID);	
		request.setAttribute("djsbm", djsbm);
		request.setAttribute("yjzt", yjzt);	
		request.setAttribute("ordertype", ordertype);
		request.setAttribute("salesremark", salesremark);
		
    	if (yjzt.equals("1")){
    		request.setAttribute("intransittype", intransittype);
    		request.setAttribute("intransit2", intransit2);
    		request.setAttribute("intransit", intransit);
    		request.setAttribute("intransittype2", intransittype2);
    	}else{
    		request.setAttribute("intransittype3", intransittype3);
    		request.setAttribute("intransit3", intransit3);
    		request.setAttribute("intransittype4", intransittype4);
    		request.setAttribute("intransit4", intransit4);
    		request.setAttribute("outpricestrattime",outpricestrattime);
    		request.setAttribute("outpriceendtime",outpriceendtime);
    	}	
				
		return SUCCESS;
    }
	/**
	 * 初始化在途状态修改
	 */
	public String initInTransitUpdateSel(){		
		
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
		
		return SUCCESS;
	}	
	/**
	 * 在途状态修改查询
	 */
	public String selectInTransitUpdate(){		
		
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
		
		String salesID = Utility.getName(request.getParameter("salesID"));
		
		SalesBasicPo basicPo=new SalesBasicPo();		
		basicPo.setSsesbsalesid(salesID);
		basicPo.setSsesbreturnbillflag(Utility.getName(permissionPo.getKeyb()));
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			basicPo.setSsesbcompanyid(personInfoPo.getPersoncompanyid());
		}
		
		salesBasicPo = inTransitMgr.getInTransit(basicPo);
		
		if(!Utility.getName(salesBasicPo.getSsesbsalesid()).equals("")){
			inTransitList = getInTransitList(salesBasicPo);
		}else{
			this.clearMessages();
			this.addActionMessage(getText("配镜单号输入有误,请重新输入!"));
		}
		
		return SUCCESS;
	}
	/**
	 * 在途状态修改
	 */
	public String inTransitUpdate(){
		
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
		
		String salesID = Utility.getName(request.getParameter("salesID"));
		String intransit = Utility.getName(request.getParameter("intransit"));
		String newIntransit = Utility.getName(request.getParameter("newIntransit"));
		String orderType = Utility.getName(request.getParameter("orderType"));
		String departmentID=personInfoPo.getDepartmentID();
		String message = "";
		
		inTransitList = getUpdateInTransitList(salesID,orderType,intransit,newIntransit,createPerson,departmentID);
		
		InTransitPo inTransitPo=new InTransitPo();
		
		inTransitPo.setSseitsalesid(salesID);
		inTransitPo.setSseitstate(newIntransit);
		inTransitPo.setSseitcreateperson(createPerson);
		inTransitPo.setSseitidordetype(orderType);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("配镜单:"+salesID + "在途状态修改为:"+newIntransit+"!");
		
		if (!newIntransit.equals("")){
			message = "更新成功";
			inTransitMgr.updateInTransit(systemParameterPo,inTransitPo, inTransitList, logPo);
		}else{
			message = "更新失败";
		}
				
		this.clearMessages();
		this.addActionMessage(getText(message));
		
		return SUCCESS;
	}
//查询剩下在途状态	
	public List<InTransitPo> getInTransitList(SalesBasicPo basicPo){
		
		List<InTransitPo> inTransitTempList =new ArrayList<InTransitPo>();

		// 销售完成
		if (salesBasicPo.getSsesborderstype().matches("[12345]")
				&& Integer.parseInt(salesBasicPo.getSsesbintransit()) < 1) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("1");
			temp1.setSseitintransitname("销售完成");
			inTransitTempList.add(temp1);
		}
		// 银台已交费
		if (salesBasicPo.getSsesborderstype().matches("[12345]")
				&& Integer.parseInt(salesBasicPo.getSsesbintransit()) < 2) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("2");
			temp1.setSseitintransitname("银台结款");
			inTransitTempList.add(temp1);
		}
		// 销售门店向仓储配送中
		if (salesBasicPo.getSsesborderstype().matches("[124]")
				&& Integer.parseInt(salesBasicPo.getSsesbintransit()) < 3 && inTransitDetailsMgr.getInTransitFlag("3").equals("1")) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("3");
			temp1.setSseitintransitname("门店配送");
			inTransitTempList.add(temp1);
		}
		// 已生成委外订单
		if (salesBasicPo.getSsesborderstype().matches("[24]")
				&& Integer.parseInt(salesBasicPo.getSsesbintransit()) < 4) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("4");
			temp1.setSseitintransitname("委外订单");
			inTransitTempList.add(temp1);
		}
		
		// 委外配镜单到货
		if (salesBasicPo.getSsesborderstype().matches("[24]")
				&& Integer.parseInt(salesBasicPo.getSsesbintransit()) < 5) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("5");
			temp1.setSseitintransitname("委外收货");
			inTransitTempList.add(temp1);
		}
		// 库房发料
		if (salesBasicPo.getSsesborderstype().matches("[12]")
				&& Integer.parseInt(salesBasicPo.getSsesbintransit()) < 6) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("6");
			temp1.setSseitintransitname("配镜发料");
			inTransitTempList.add(temp1);
		}
		// 初验
		if (salesBasicPo.getSsesborderstype().matches("[12]")
				&& Integer.parseInt(salesBasicPo.getSsesbintransit()) < 7 && inTransitDetailsMgr.getInTransitFlag("7").equals("1")) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("7");
			temp1.setSseitintransitname("加工初验");
			inTransitTempList.add(temp1);
		}
		
		// 领料加工中
		if (salesBasicPo.getSsesborderstype().matches("[12]")
				&& Integer.parseInt(salesBasicPo.getSsesbintransit()) < 8 && inTransitDetailsMgr.getInTransitFlag("8").equals("1")) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("8");
			temp1.setSseitintransitname("加工师加工");
			inTransitTempList.add(temp1);
		}
		// 加工检验合格
		if (salesBasicPo.getSsesborderstype().matches("[12]")
				&& Integer.parseInt(salesBasicPo.getSsesbintransit()) < 9 && inTransitDetailsMgr.getInTransitFlag("9").equals("1")) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("9");
			temp1.setSseitintransitname("加工检验");
			inTransitTempList.add(temp1);
		}
		// 向销售门店配送中
		if (salesBasicPo.getSsesborderstype().matches("[12]")
				&& Integer.parseInt(salesBasicPo.getSsesbintransit()) < 10 && inTransitDetailsMgr.getInTransitFlag("10").equals("1")) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("10");
			temp1.setSseitintransitname("加工配送");
			inTransitTempList.add(temp1);
		}
		// 隐形订做到货配送中
		if (salesBasicPo.getSsesborderstype().matches("[4]")
				&& Integer.parseInt(salesBasicPo.getSsesbintransit()) < 11 && inTransitDetailsMgr.getInTransitFlag("11").equals("1")) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("11");
			temp1.setSseitintransitname("隐形配送");
			inTransitTempList.add(temp1);
		}
		// 取镜处--待顾客取镜
		if (salesBasicPo.getSsesborderstype().matches("[124]")
				&& Integer.parseInt(salesBasicPo.getSsesbintransit()) < 12) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("12");
			temp1.setSseitintransitname("取镜处收货");
			inTransitTempList.add(temp1);
		}
	
		// 顾客已取镜
		if (salesBasicPo.getSsesborderstype().matches("[12345]")
				&& Integer.parseInt(salesBasicPo.getSsesbintransit()) < 13) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("13");
			temp1.setSseitintransitname("顾客取镜");
			inTransitTempList.add(temp1);
		}
		
		return inTransitTempList;
	}
	
//查询区间段内的在途状态	
	public List<InTransitPo> getUpdateInTransitList(String salesID,String orderType,String intransit,String newIntransit,String createPerson,String departmentID){
		
		List<InTransitPo> inTransitTempList =new ArrayList<InTransitPo>();
		
		// 销售完成
		if (orderType.matches("[12345]")
				&& Integer.parseInt(intransit) < 1 && Integer.parseInt(newIntransit) >= 1) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitsalesid(salesID);
			temp1.setSseitstate("1");
			temp1.setSseitintransitname("销售完成");
			temp1.setSseitcreateperson(createPerson);
			temp1.setSseitdepartment(departmentID); 
			inTransitTempList.add(temp1);
		}
		// 银台已交费
		if (orderType.matches("[12345]")
				&& Integer.parseInt(intransit) < 2 && Integer.parseInt(newIntransit) >= 2) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitsalesid(salesID);
			temp1.setSseitstate("2");
			temp1.setSseitintransitname("银台结款");
			temp1.setSseitcreateperson(createPerson);
			temp1.setSseitdepartment(departmentID); 
			inTransitTempList.add(temp1);
		}
		// 销售门店向仓储配送中
		if (orderType.matches("[124]")
				&& Integer.parseInt(intransit) < 3 && Integer.parseInt(newIntransit) >= 3) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitsalesid(salesID);
			temp1.setSseitstate("3");
			temp1.setSseitintransitname("门店配送");
			temp1.setSseitcreateperson(createPerson);
			temp1.setSseitdepartment(departmentID); 
			inTransitTempList.add(temp1);
		}
		// 已生成委外订单
		if (orderType.matches("[24]")
				&& Integer.parseInt(intransit) < 4 && Integer.parseInt(newIntransit) >= 4) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitsalesid(salesID);
			temp1.setSseitstate("4");
			temp1.setSseitintransitname("委外订单");
			temp1.setSseitcreateperson(createPerson);
			temp1.setSseitdepartment(departmentID); 
			inTransitTempList.add(temp1);
		}
		
		// 委外配镜单到货
		if (orderType.matches("[24]")
				&& Integer.parseInt(intransit) < 5 && Integer.parseInt(newIntransit) >= 5) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitsalesid(salesID);
			temp1.setSseitstate("5");
			temp1.setSseitintransitname("委外收货");
			temp1.setSseitcreateperson(createPerson);
			temp1.setSseitdepartment(departmentID); 
			inTransitTempList.add(temp1);
		}
		// 库房发料
		if (orderType.matches("[12]")
				&& Integer.parseInt(intransit) < 6 && Integer.parseInt(newIntransit) >= 6) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitsalesid(salesID);
			temp1.setSseitstate("6");
			temp1.setSseitintransitname("配镜发料");
			temp1.setSseitcreateperson(createPerson);
			temp1.setSseitdepartment(departmentID); 
			inTransitTempList.add(temp1);
		}
		// 初验
		if (orderType.matches("[12]")
				&& Integer.parseInt(intransit) < 7 && Integer.parseInt(newIntransit) >= 7) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitsalesid(salesID);
			temp1.setSseitstate("7");
			temp1.setSseitintransitname("加工初验");
			temp1.setSseitcreateperson(createPerson);
			temp1.setSseitdepartment(departmentID); 
			inTransitTempList.add(temp1);
		}
		// 领料加工中
		if (orderType.matches("[12]")
				&& Integer.parseInt(intransit) < 8 && Integer.parseInt(newIntransit) >= 8) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitsalesid(salesID);
			temp1.setSseitstate("8");
			temp1.setSseitintransitname("加工师加工");
			temp1.setSseitcreateperson(createPerson);
			temp1.setSseitdepartment(departmentID); 
			inTransitTempList.add(temp1);
		}
		// 加工检验合格
		if (orderType.matches("[12]")
				&& Integer.parseInt(intransit) < 9 && Integer.parseInt(newIntransit) >= 9) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitsalesid(salesID);
			temp1.setSseitstate("9");
			temp1.setSseitintransitname("加工检验");
			temp1.setSseitcreateperson(createPerson);
			temp1.setSseitdepartment(departmentID); 
			inTransitTempList.add(temp1);
		}
		// 向销售门店配送中
		if (orderType.matches("[12]")
				&& Integer.parseInt(intransit) < 10 && Integer.parseInt(newIntransit) >= 10) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitsalesid(salesID);
			temp1.setSseitstate("10");
			temp1.setSseitintransitname("加工配送");
			temp1.setSseitcreateperson(createPerson);
			temp1.setSseitdepartment(departmentID); 
			inTransitTempList.add(temp1);
		}
		// 隐形订做到货配送中
		if (orderType.matches("[4]")
				&& Integer.parseInt(intransit) < 11 && Integer.parseInt(newIntransit) >= 11) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitsalesid(salesID);
			temp1.setSseitstate("11");
			temp1.setSseitintransitname("隐形配送");
			temp1.setSseitcreateperson(createPerson);
			temp1.setSseitdepartment(departmentID); 
			inTransitTempList.add(temp1);
		}
		// 取镜处--待顾客取镜
		if (orderType.matches("[124]")
				&& Integer.parseInt(intransit) < 12 && Integer.parseInt(newIntransit) >= 12) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitsalesid(salesID);
			temp1.setSseitstate("12");
			temp1.setSseitintransitname("取镜处收货");
			temp1.setSseitcreateperson(createPerson);
			temp1.setSseitdepartment(departmentID); 
			inTransitTempList.add(temp1);
		}
		// 顾客已取镜
		if (orderType.matches("[12345]")
				&& Integer.parseInt(intransit) < 13 && Integer.parseInt(newIntransit) >= 13) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitsalesid(salesID);
			temp1.setSseitstate("13");
			temp1.setSseitintransitname("顾客取镜");
			temp1.setSseitcreateperson(createPerson);
			temp1.setSseitdepartment(departmentID); 
			inTransitTempList.add(temp1);
		}
		
		return inTransitTempList;
	}
}
