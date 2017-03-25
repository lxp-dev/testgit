package com.pengsheng.weixin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.frame.dao.LoginDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.SetMealMgr;
import com.pengsheng.eims.sales.persistence.IntegralAddandSubPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.IntegralPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;
import com.pengsheng.weixin.mgr.WeiXinIntegralSelectMgr;
import com.pengsheng.weixin.persistence.WeiXinIntegralSelectPo;

public class WeiXinIntegralSelectAction  extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;	
	private WeiXinIntegralSelectMgr weiXinIntegralSelectMgr;
	private WeiXinIntegralSelectPo weiXinIntegralSelectPo;
	private List<WeiXinIntegralSelectPo> weiXinIntegralSelectPoList;
	private WarehouseMgr warehouseMgr;
	private DepartmentsMgr departmentsMgr;
	private List<WarehousePo> warehouseList;
	private List<DepartmentsPo> departmentsList;
	private CustomerInfoPo customerInfoPo;
	private List<GoodsInfoPo> goodsInfoPos;
	private CompanyNamePo companyNamePo;
	private LoginDao loginDao;
	private SetMealMgr setMealMgr;
	private IntegralPo integralPo;
	public SetMealMgr getSetMealMgr() {
		return setMealMgr;
	}
	public void setSetMealMgr(SetMealMgr setMealMgr) {
		this.setMealMgr = setMealMgr;
	}
	public IntegralPo getIntegralPo() {
		return integralPo;
	}
	public void setIntegralPo(IntegralPo integralPo) {
		this.integralPo = integralPo;
	}
	public List<GoodsInfoPo> getGoodsInfoPos() {
		return goodsInfoPos;
	}
	public void setGoodsInfoPos(List<GoodsInfoPo> goodsInfoPos) {
		this.goodsInfoPos = goodsInfoPos;
	}
	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}
	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}
	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}
	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}
	public List<WarehousePo> getWarehouseList() {
		return warehouseList;
	}
	public void setWarehouseList(List<WarehousePo> warehouseList) {
		this.warehouseList = warehouseList;
	}
	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}
	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}
	public WeiXinIntegralSelectPo getWeiXinIntegralSelectPo() {
		return weiXinIntegralSelectPo;
	}
	public void setWeiXinIntegralSelectPo(
			WeiXinIntegralSelectPo weiXinIntegralSelectPo) {
		this.weiXinIntegralSelectPo = weiXinIntegralSelectPo;
	}
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelectPoList() {
		return weiXinIntegralSelectPoList;
	}
	public void setWeiXinIntegralSelectPoList(
			List<WeiXinIntegralSelectPo> weiXinIntegralSelectPoList) {
		this.weiXinIntegralSelectPoList = weiXinIntegralSelectPoList;
	}
	public WeiXinIntegralSelectMgr getWeiXinIntegralSelectMgr() {
		return weiXinIntegralSelectMgr;
	}
	public void setWeiXinIntegralSelectMgr(
			WeiXinIntegralSelectMgr weiXinIntegralSelectMgr) {
		this.weiXinIntegralSelectMgr = weiXinIntegralSelectMgr;
	}
	public String getIsFirstExec() {
		return isFirstExec;
	}
	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
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
	
	public String initWeiXinIntegralSelectSel(){
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
		systemParameterPo = systemParameterMgr.getSystemParameterPo();		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "weiXinIntegralSelectSel";
		}
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		warehouseList = warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);
		// 取得登陆人允许操作的仓位&部门 End
		return SUCCESS;
	}
	
	public String weiXinIntegralSelectSel(){
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
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		warehouseList = warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);
		// 取得登陆人允许操作的仓位&部门 End
		
		systemParameterPo = systemParameterMgr.getSystemParameterPo();
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
//		if(null==weiXinIntegralSelectPo){
//			weiXinIntegralSelectPo=new WeiXinIntegralSelectPo();
//		}
//		weiXinIntegralSelectPo.setWiedepartmentid(personInfoPo.getDepartmentID());
		int count=weiXinIntegralSelectMgr.getWeiXinIntegralSelectCount(weiXinIntegralSelectPo);
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
	    weiXinIntegralSelectPoList=weiXinIntegralSelectMgr.getWeiXinIntegralSelectList(weiXinIntegralSelectPo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			weiXinIntegralSelectPoList = null;
		}
		return SUCCESS;
	}
	
	public String weiXinIntegralConvertView(){
		
		CompanyNamePo cpo = new CompanyNamePo();
		companyNamePo = loginDao.getCompanyInfo(cpo);	
		
		departmentsList = departmentsMgr.getDepartments("1","0");
		
		String openID = Utility.getName(request.getParameter("openID"));
		
		CustomerInfoPo po = new CustomerInfoPo();
		po.setSmeciopenid(openID);
		
		customerInfoPo = weiXinIntegralSelectMgr.selectCustomerInfoPo(po);
		
		goodsInfoPos = weiXinIntegralSelectMgr.selectIntegralConvertGoodsList(null);
		
		request.setAttribute("openID", openID);
		
		return SUCCESS;
	}
	
	public void IntegralSelectGoodsNum() throws IOException{
		String message="0";
		PrintWriter out;
		String openID=request.getParameter("hid");
		String goodsid=request.getParameter("goodsid");
		int goodsNum=Integer.parseInt(request.getParameter("goodsNum"));
		int selectInGoodsNum = weiXinIntegralSelectMgr.selectInGoodsNum(openID, goodsid);
		integralPo=new IntegralPo();
		integralPo.setFirGoodsID(goodsid);
		integralPo = setMealMgr.getIntegralExchangeSetDetail(integralPo);
		int personNum=Integer.parseInt(integralPo.getFirpersonnum());
		int goodsSumNum=Integer.parseInt(integralPo.getFirgoodssumnum());
		if((goodsSumNum-selectInGoodsNum)>0){
			if(goodsNum<=personNum&&goodsNum<=(goodsSumNum-selectInGoodsNum)){
				message="1";
			}
		}
		int selectDepIsClosed = weiXinIntegralSelectMgr.selectDepIsClosed(request.getParameter("depID"));
		if(selectDepIsClosed!=0){
			message="2";
		}
		out = response.getWriter();
		out.print(message);
		out.close();
	}
	
	public String updateWeiXinIntegralConvertView(){
		
		String openID = Utility.getName(request.getParameter("xopenid"));
		request.setAttribute("openID", openID);
		
		CompanyNamePo po = new CompanyNamePo();
		companyNamePo = loginDao.getCompanyInfo(po);	
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName("微信用户openID"+weiXinIntegralSelectPo.getWieopenid());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult("");
		logPo.setsLogOpID("2");
		logPo.setsLogContent("微信积分兑换新增!");
		
		String customerid = Utility.getName(request.getParameter("xcustomerid"));
		String openid = Utility.getName(request.getParameter("xopenid"));
		String yintegral = Utility.getName(request.getParameter("xyintegral"));
		String cintegral = Utility.getName(request.getParameter("xcintegral"));
		String goodsid = Utility.getName(request.getParameter("xgoodsid"));
		String integral = Utility.getName(request.getParameter("xintegral"));
		String goodsnumber = Utility.getName(request.getParameter("xgoodsnumber"));
		String wiedepartmentid = Utility.getName(request.getParameter("wiedepartmentid"));
		
		BigDecimal byintegral = new BigDecimal(yintegral);
		BigDecimal bcintegral = new BigDecimal("-"+cintegral);		
		
		CustomerInfoPo tcpo = new CustomerInfoPo();
		tcpo.setSmeciopenid(openid);
		CustomerInfoPo iscpo = weiXinIntegralSelectMgr.selectCustomerInfoPo(tcpo);
		
		BigDecimal xyintegral = new BigDecimal(iscpo.getSmeciintegral());
		if(xyintegral.compareTo(bcintegral) == -1){
			String url = "''weiXinIntegralConvertView.action?hid={0}&openID="+request.getParameter("openID")+"''"; 
			List<String> params = new ArrayList<String>(); 
			params.add(request.getParameter("departments")); 
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			
			this.clearMessages();
			this.addActionMessage(getText("所用积分不足!"));
			request.setAttribute("flag", GlobalConstants.INSERT);
			return SUCCESS;
		}
		
		WeiXinIntegralSelectPo wpo = new WeiXinIntegralSelectPo();
		
		wpo.setWiecustomerid(customerid);
        wpo.setWieopenid(openid);
        wpo.setWieflag("0");
        wpo.setWiegoodsid(goodsid);
        wpo.setWieintegral(integral);
        wpo.setWiegoodsnumber(goodsnumber);
        wpo.setWiedepartmentid(wiedepartmentid);
        
        
        IntegralAddandSubPo ipo = new IntegralAddandSubPo();
        
        ipo.setSmeasyintegral(yintegral);
        ipo.setSmeascintegral("-"+cintegral);
		ipo.setSmeasxintegral((byintegral.add(bcintegral))+"");
		ipo.setSmeasremark("微信积分兑换！");
		ipo.setSmeasaddorsub("7");
		ipo.setSmeascustomerid(customerid);
		
		
		CustomerInfoPo cpo = new CustomerInfoPo();
		
		cpo.setSmeciintegral((byintegral.add(bcintegral))+"");
		cpo.setSmeciopenid(openid);
		
		weiXinIntegralSelectMgr.insertIntegralSelectPo(wpo, ipo, cpo, logPo);
		
		DepartmentsPo dpo = new DepartmentsPo();
		dpo.setBdpdepartmentid(wiedepartmentid);
		dpo = departmentsMgr.getDepartment(dpo);
		request.setAttribute("dpo", dpo);
		
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		request.setAttribute("url", "'weiXinIntegralConvertView.action?openID="+openID+"'");
		
		this.clearMessages();
		this.addActionMessage("兑换成功！");
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}
	
	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}
	
	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}
	public CompanyNamePo getCompanyNamePo() {
		return companyNamePo;
	}
	public void setCompanyNamePo(CompanyNamePo companyNamePo) {
		this.companyNamePo = companyNamePo;
	}
	public LoginDao getLoginDao() {
		return loginDao;
	}
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
}
