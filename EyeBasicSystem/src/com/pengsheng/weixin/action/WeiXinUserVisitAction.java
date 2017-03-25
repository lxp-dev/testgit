package com.pengsheng.weixin.action;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.persistence.ComplaintsTypePo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.casehistory.mgr.InspectionNMgr;
import com.pengsheng.eims.casehistory.persistence.InspectionPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.CustomerComplainMgr;
import com.pengsheng.eims.sales.persistence.CustomerComplainPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.mgr.ConfigurationMgr;
import com.pengsheng.weixin.mgr.WeiXinCmsContentMgr;
import com.pengsheng.weixin.mgr.WeiXinCmsTypeMgr;
import com.pengsheng.weixin.mgr.WeiXinDepartmentsMgr;
import com.pengsheng.weixin.mgr.WeiXinDoctorAppraisalMgr;
import com.pengsheng.weixin.mgr.WeiXinDoctorMgr;
import com.pengsheng.weixin.mgr.WeiXinRegisterDepartmentMgr;
import com.pengsheng.weixin.mgr.WeiXinServiceMgr;
import com.pengsheng.weixin.persistence.ConfigurationPo;
import com.pengsheng.weixin.persistence.WeiXinCmsContentPo;
import com.pengsheng.weixin.persistence.WeiXinCmsTypePo;
import com.pengsheng.weixin.persistence.WeiXinDepartmentPicPo;
import com.pengsheng.weixin.persistence.WeiXinDoctorAppraisalPo;
import com.pengsheng.weixin.persistence.WeiXinDoctorPo;
import com.pengsheng.weixin.persistence.WeiXinRegisterDepartmentPo;
import com.pengsheng.weixin.service.PastUtil;
import com.pengsheng.weixin.util.Distance;

public class WeiXinUserVisitAction extends BaseAction {

	private WeiXinDepartmentsMgr weiXinDepartmentsMgr;
	private DepartmentsPo departmentsPo;
	private List<DepartmentsPo> departmentsList;
	private List<WeiXinDepartmentPicPo> weiXinDepartmentPicList;
	private CompanyNameMgr companyNameMgr;
	private CompanyNamePo companyNamePo;

	private WeiXinCmsContentMgr weiXinCmsContentMgr;
	private WeiXinCmsTypeMgr weiXinCmsTypeMgr;
	private List<WeiXinCmsContentPo> weiXinCmsContentList;
	private List<WeiXinCmsTypePo> weiXinCmsTypeList;
	private WeiXinCmsContentPo weiXinCmsContentPo;

	private WeiXinDoctorMgr weiXinDoctorMgr;
	private WeiXinDoctorPo weiXinDoctorPo;
	private List<WeiXinDoctorPo> weiXinDoctorList;

	private CustomerComplainPo customerComplainPo;
	private List<ComplaintsTypePo> complaintsTypeList;
	private CustomerComplainMgr customerComplainMgr;
	private WeiXinServiceMgr weiXinServiceMgr;
	private UnitMgr unitMgr;
	private ConfigurationMgr configurationMgr;
	private CustomerInfoPo customerInfoPo;
	private List<SalesBasicPo> salesBasicList;
	
	private WeiXinDoctorAppraisalMgr weiXinDoctorAppraisalMgr;
	private WeiXinDoctorAppraisalPo weiXinDoctorAppraisalPo;
	private InspectionNMgr inspectionNMgr;
	
	private WeiXinRegisterDepartmentMgr weiXinRegisterDepartmentMgr;
	private WeiXinRegisterDepartmentPo weiXinRegisterDepartmentPo;
	
	/**
	 * 获取门店信息List
	 */
	public String initWeiXinUserDepartmentsList() throws Exception {
		weiXinRegisterDepartmentPo = new WeiXinRegisterDepartmentPo();
		weiXinRegisterDepartmentPo = weiXinRegisterDepartmentMgr.getWeiXinRegisterDepartmentPo(weiXinRegisterDepartmentPo);
		String jsonResult = PastUtil.getParam(weiXinRegisterDepartmentPo.getWrdappid(), weiXinRegisterDepartmentPo.getWrdappsecret());
		
		ConfigurationPo configurationPo = configurationMgr.getConfigurationDetail();
		
		request.setAttribute("eims_Url", configurationPo.getWcrurl());
		request.setAttribute("jsonResult", jsonResult);
		
		
		return SUCCESS;
	}
	
	/**
	 * 获取门店信息List
	 */
	public String initWeiXinUserDepartmentsListShow() throws Exception {
		
		String locationx = Utility.getName(request.getParameter("locationx"));
		String locationy = Utility.getName(request.getParameter("locationy"));
		
		if(locationx.equals("")){
			locationx = "0";
		}
		if(locationy.equals("")){
			locationy = "0";
		}
		
		departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpissee("0");
		departmentsList = weiXinDepartmentsMgr
				.getDepartmentsList(departmentsPo);

		departmentsList = getDepartmentDistance(departmentsList,locationx,locationy);
		Collections.sort(departmentsList, new Comparator<DepartmentsPo>() {
            public int compare(DepartmentsPo arg0, DepartmentsPo arg1) {
                return arg0.getBdpsdistanceorder().compareTo(arg1.getBdpsdistanceorder());
            }
        });
		
		
		return SUCCESS;
	}

	/**
	 * 获取门店信息List
	 */
	public String initWeiXinUserDepartmentsList2() throws Exception {
		
		String locationx = Utility.getName(request.getParameter("locationx"));
		String locationy = Utility.getName(request.getParameter("locationy"));
		
		departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpissee("0");
		departmentsList = weiXinDepartmentsMgr
				.getDepartmentsList(departmentsPo);

		return SUCCESS;
	}
	
	//获取附近门店
	private List<DepartmentsPo> getDepartmentDistance(List<DepartmentsPo> departmentslist,String locationx,String locationy){
		
		List<DepartmentsPo> resultDepartmentslist = new ArrayList<DepartmentsPo>();
		DepartmentsPo departmentsPo = new DepartmentsPo();
		if(locationx.equals("")){
			locationx="0";
		}
		if(locationy.equals("")){
			locationx="0";
		}	
		
		Iterator<DepartmentsPo> it = departmentslist.iterator();
		while(it.hasNext()){
			departmentsPo = (DepartmentsPo)it.next();
			
			if(!departmentsPo.getBdplocationy().equals("") && !departmentsPo.getBdplocationx().equals("")){
				double distance = Distance.GetDistance(Double.parseDouble(locationy),Double.parseDouble(locationx),Double.parseDouble(departmentsPo.getBdplocationy()),Double.parseDouble(departmentsPo.getBdplocationx()));
				distance = Math.round(distance/100d)/10d;
				departmentsPo.setBdpsdistance(String.valueOf(distance));
				departmentsPo.setBdpsdistanceorder((int)(distance*100));
				
			}else{
				departmentsPo.setBdpsdistance("10000000000");
				departmentsPo.setBdpsdistanceorder(Integer.parseInt("99999999"));
			}
			
			resultDepartmentslist.add(departmentsPo);
		}
		
		return resultDepartmentslist;
	}
	
	/**
	 * 获取门店信息
	 */
	public String initUserDepartmentsDetail() throws Exception {
		String id = Utility.getName(request.getParameter("id"));
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(id);

		String locationx = Utility.getName(request.getParameter("locationx"));
		String locationy = Utility.getName(request.getParameter("locationy"));

		request.setAttribute("locationx", locationx);
		request.setAttribute("locationy", locationy);

		departmentsPo = weiXinDepartmentsMgr.getDepartment(po);
		return SUCCESS;
	}

	/**
	 * 门店实景图View
	 * 
	 * @return
	 */
	public String initUserDepartmentPics() throws Exception {
		String departmentID = Utility.getName(request.getParameter("hid"));

		departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(departmentID);
		departmentsPo = weiXinDepartmentsMgr.getDepartment(departmentsPo);

		weiXinDepartmentPicList = weiXinDepartmentsMgr
				.getDepartmentPicList(departmentID);

		return SUCCESS;
	}

	/**
	 * 门店定位帮助
	 */
	public String initWeiXinDepartmentsHelpView() throws Exception {
		companyNamePo = companyNameMgr.getCompanyName(companyNamePo);
		return SUCCESS;
	}

	/**
	 * 文章信息类型View
	 */
	public String initUserCmsContentTypeList() throws Exception {

		weiXinCmsTypeList = weiXinCmsTypeMgr
				.getWeiXinCmsTypeList(new WeiXinCmsTypePo());

		return SUCCESS;
	}

	/**
	 * 文章信息List
	 */
	public String initUserCmsContentList() throws Exception {
		String openID = Utility.getName(request.getParameter("openID"));
		request.setAttribute("openID", openID);
		
		String type = Utility.getName(request.getParameter("type"));

		WeiXinCmsTypePo weiXinCmsTypePo = new WeiXinCmsTypePo();
		weiXinCmsTypePo.setWcmstid(type);
		weiXinCmsTypePo = weiXinCmsTypeMgr.getWeiXinCmsTypePo(weiXinCmsTypePo);
		request.setAttribute("typeName", weiXinCmsTypePo.getWcmstname());

		WeiXinCmsContentPo po = new WeiXinCmsContentPo();
		po.setWcmsctypeid(type);

		weiXinCmsContentList = weiXinCmsContentMgr
				.selectWeiXinCmsContentListForView(po);

		return SUCCESS;
	}

	/**
	 * 文章信息详细
	 */
	public String initUserCmsContentDetails() throws Exception {
		
		String openID = Utility.getName(request.getParameter("openID"));
		request.setAttribute("openID", openID);
		
//		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
//		customerInfoPo.setOpenid(openID);
//		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);	
//		
//		if(customerInfoPo==null || Utility.getName(customerInfoPo.getSmecicustomerid()).equals("")){					
//			return "weiXinMemberBindSel";
//		}
		
		String hid = Utility.getName(request.getParameter("hid"));

		WeiXinCmsContentPo po = new WeiXinCmsContentPo();
		po.setWcmscid(hid);

		weiXinCmsContentPo = weiXinCmsContentMgr.selectWeiXinCmsContentPo(po);

		return SUCCESS;
	}

	/**
	 * 验光师List
	 */
	public String initUserDepartmentDoctor() throws Exception {

		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
//		if (openID.equals("")) {
//			return "weixinSessionOut";
//		}
		request.setAttribute("openID", openID);


		//微信号对应原始ID写入Session
		String toUserName = Utility.getName(request.getParameter("toUserName"));
		if(!toUserName.equals("")){
			request.getSession().setAttribute("toUserName", toUserName);
		}else if(request.getSession().getAttribute("toUserName")!=null && !request.getSession().getAttribute("toUserName").toString().equals("")){
			toUserName = request.getSession().getAttribute("toUserName").toString();
		}
		//微信号对应原始ID写入Session
		
		String zhenliao = Utility.getName(request.getParameter("zhenliao"));
		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);

//		if (customerInfoPo == null
//				|| Utility.getName(customerInfoPo.getSmecicustomerid()).equals(
//						"")) {
//			return "weiXinMemberBindSel";
//		}
		// openID判断
		
		WeiXinDoctorPo po1 = new WeiXinDoctorPo();
		po1.setWdfirstshow("1");
		po1.setWdzhenliao(zhenliao);
		po1 = weiXinDoctorMgr.selectWeiXinDoctorPo(po1);
		request.setAttribute("po1", po1);
		
		List<WeiXinDoctorPo> po2List = new ArrayList<WeiXinDoctorPo>();
		WeiXinDoctorPo po2 = new WeiXinDoctorPo();
		po2.setWdfirstshow("0");
		po2.setWdzhenliao(zhenliao);
		
		po2List = weiXinDoctorMgr.selectWeiXinDoctorList(po2);
		request.setAttribute("po2List", po2List);

		return SUCCESS;
	}

	/**
	 * 验光师详细
	 */
	public String initUserDepartmentDoctorDetail() throws Exception {

		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
//		if (openID.equals("")) {
//			return "weixinSessionOut";
//		}
		request.setAttribute("openID", openID);

		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);

		if (customerInfoPo == null
				|| Utility.getName(customerInfoPo.getSmecicustomerid()).equals(
						"")) {
			request.setAttribute("yuyueKey", "false");
//			return "weiXinMemberBindSel";
		}
		
		
		// openID判断
		
		String hid = Utility.getName(request.getParameter("hid"));

		WeiXinDoctorPo po = new WeiXinDoctorPo();
		po.setWdpersonid(hid);

		weiXinDoctorPo = weiXinDoctorMgr.selectWeiXinDoctorPo(po);
		List<WeiXinDoctorAppraisalPo> weiXinDoctorAppraisalPoList = new ArrayList<WeiXinDoctorAppraisalPo>();
		weiXinDoctorAppraisalPoList = weiXinDoctorAppraisalMgr.selectWeiXinDoctorAppraisalList(weiXinDoctorPo.getWdpersonid());
		request.setAttribute("weiXinDoctorAppraisalPoList", weiXinDoctorAppraisalPoList);
		
		int appraisalCount = 0;
		appraisalCount = weiXinDoctorAppraisalPoList.size();
		request.setAttribute("appraisalCount", appraisalCount);
		
		InspectionPo inspectionPo = new InspectionPo();
		inspectionPo = inspectionNMgr.getLastInspectionPo(customerInfoPo.getSmecicustomerid(),hid);
		request.setAttribute("inspectionPo", inspectionPo);
		
		int isOK = 0;
		isOK = weiXinDoctorAppraisalMgr.selectWeiXinDoctorAppraisalisOk(inspectionPo.getSopipid());
		request.setAttribute("isOK", isOK);
		
		ConfigurationPo configurationPo = configurationMgr.getConfigurationDetail();
		request.setAttribute("pingjiaType", Utility.getName(configurationPo.getWcrpingjiatype()));
		
		request.setAttribute("customerid", customerInfoPo.getSmecicustomerid());
		
		return SUCCESS;
	}

	/**
	 * 初始化验光师评价新增
	 */
	public String initInsertDoctorAppraisal() throws Exception {

		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if (openID.equals("")) {
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);

		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);

		if (customerInfoPo == null
				|| Utility.getName(customerInfoPo.getSmecicustomerid()).equals(
						"")) {
			return "weiXinMemberBindSel";
		}
		// openID判断
		
		String hid = Utility.getName(request.getParameter("hid"));
		String sopipid = Utility.getName(request.getParameter("sopipid"));
		
		WeiXinDoctorPo po = new WeiXinDoctorPo();
		po.setWdpersonid(hid);

		weiXinDoctorPo = weiXinDoctorMgr.selectWeiXinDoctorPo(po);

		List<WeiXinDoctorAppraisalPo> weiXinDoctorAppraisalPoList = new ArrayList<WeiXinDoctorAppraisalPo>();
		weiXinDoctorAppraisalPoList = weiXinDoctorAppraisalMgr.selectWeiXinDoctorAppraisalList(weiXinDoctorPo.getWdpersonid());
		request.setAttribute("weiXinDoctorAppraisalPoList", weiXinDoctorAppraisalPoList);
		
		int appraisalCount = 0;
		appraisalCount = weiXinDoctorAppraisalMgr.selectWeiXinDoctorAppraisalCount(weiXinDoctorPo.getWdpersonid());
		request.setAttribute("appraisalCount", appraisalCount);
		
		ConfigurationPo configurationPo = configurationMgr.getConfigurationDetail();
		request.setAttribute("pingjiaType", Utility.getName(configurationPo.getWcrpingjiatype()));
		
		int isOK = 0;
		isOK = weiXinDoctorAppraisalMgr.selectWeiXinDoctorAppraisalisOk(sopipid);
		request.setAttribute("isOK", isOK);
		
		request.setAttribute("sopipid", sopipid);
		request.setAttribute("customerid", customerInfoPo.getSmecicustomerid());
		return SUCCESS;
	}
	
	/**
	 * 验光师评价新增
	 */
	public String insertDoctorAppraisal() throws Exception {

		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if (openID.equals("")) {
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);

		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);

		if (customerInfoPo == null
				|| Utility.getName(customerInfoPo.getSmecicustomerid()).equals(
						"")) {
			return "weiXinMemberBindSel";
		}
		// openID判断
		
		ConfigurationPo configurationPo = configurationMgr.getConfigurationDetail();
		int isOK = 0;
		isOK = weiXinDoctorAppraisalMgr.selectWeiXinDoctorAppraisalisOk(weiXinDoctorAppraisalPo.getWdainspectionid());
		if(isOK>0 && configurationPo.getWcrpingjiatype().equals("1")){
			this.clearMessages();
			this.addActionMessage("您已经对本次检查做出过评价！");
		}else{
			weiXinDoctorAppraisalMgr.insertWeiXinDoctorAppraisalPo(weiXinDoctorAppraisalPo);
			this.clearMessages(); 
			this.addActionMessage(getText("struts.messages.insert.sucess"));
		}
		
		String url = "''initUserDepartmentDoctorDetail.action?openID={0}&hid={1}''";
		List<String> params = new ArrayList<String>();
		params.add(openID);
		params.add(weiXinDoctorAppraisalPo.getWdadoctorid());
		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.MOVE);

		return SUCCESS;
	}
	
	/**
	 * 门店发送位置帮助
	 */
	public String initUserDepartmentsHelp() throws Exception {
		return "success";
	}

	/**
	 * 初始化服务建议
	 * @return
	 * @throws Exception
	 */
	public String initUserInsertCustomerComplain() throws Exception {


		String openID = Utility.getName(this.request.getParameter("openID"));
		CustomerComplainPo po = new CustomerComplainPo();
		po.setSmecccustomermemberid(openID);

		customerComplainPo = weiXinServiceMgr.selectCustomerComplainPo(po);

		complaintsTypeList = unitMgr.getComplaintsTypeList();
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr
				.getCustomerInfoByOpenID(this.customerInfoPo);
		salesBasicList = configurationMgr
				.getSalesBillInfoByCustomer(this.customerInfoPo);

		return "success";
	}

	public String userInsertCustomerComplain() {
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String uuid = "TWX" + numHeadFormat.format(new Date());
		customerComplainPo.setSmeccuuid(uuid);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName("weixin");
		logPo.setsLogIP(this.request.getRemoteAddr());
		logPo.setsLogResult("");
		logPo.setsLogOpID("1");
		logPo.setsLogContent("顾客投诉单号：" + this.customerComplainPo.getSmeccuuid()
				+ "（微信）新增！");

		customerComplainPo.setSmeccregisterpersonid("weixin");

		customerComplainPo.setSmechcustomercomplainid(this.customerComplainPo
				.getSmeccuuid());
		customerComplainPo.setSmechhandlepersonid("");

		this.customerComplainMgr.insertCustomerComplainPo(customerComplainPo,
				null, "", null, logPo);


		return "success";
	}

	public WeiXinDepartmentsMgr getWeiXinDepartmentsMgr() {
		return weiXinDepartmentsMgr;
	}

	public void setWeiXinDepartmentsMgr(
			WeiXinDepartmentsMgr weiXinDepartmentsMgr) {
		this.weiXinDepartmentsMgr = weiXinDepartmentsMgr;
	}

	public DepartmentsPo getDepartmentsPo() {
		return departmentsPo;
	}

	public void setDepartmentsPo(DepartmentsPo departmentsPo) {
		this.departmentsPo = departmentsPo;
	}

	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
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

	public List<WeiXinDepartmentPicPo> getWeiXinDepartmentPicList() {
		return weiXinDepartmentPicList;
	}

	public void setWeiXinDepartmentPicList(
			List<WeiXinDepartmentPicPo> weiXinDepartmentPicList) {
		this.weiXinDepartmentPicList = weiXinDepartmentPicList;
	}

	public WeiXinCmsContentMgr getWeiXinCmsContentMgr() {
		return weiXinCmsContentMgr;
	}

	public void setWeiXinCmsContentMgr(WeiXinCmsContentMgr weiXinCmsContentMgr) {
		this.weiXinCmsContentMgr = weiXinCmsContentMgr;
	}

	public WeiXinCmsTypeMgr getWeiXinCmsTypeMgr() {
		return weiXinCmsTypeMgr;
	}

	public void setWeiXinCmsTypeMgr(WeiXinCmsTypeMgr weiXinCmsTypeMgr) {
		this.weiXinCmsTypeMgr = weiXinCmsTypeMgr;
	}

	public List<WeiXinCmsContentPo> getWeiXinCmsContentList() {
		return weiXinCmsContentList;
	}

	public void setWeiXinCmsContentList(
			List<WeiXinCmsContentPo> weiXinCmsContentList) {
		this.weiXinCmsContentList = weiXinCmsContentList;
	}

	public List<WeiXinCmsTypePo> getWeiXinCmsTypeList() {
		return weiXinCmsTypeList;
	}

	public void setWeiXinCmsTypeList(List<WeiXinCmsTypePo> weiXinCmsTypeList) {
		this.weiXinCmsTypeList = weiXinCmsTypeList;
	}

	public WeiXinCmsContentPo getWeiXinCmsContentPo() {
		return weiXinCmsContentPo;
	}

	public void setWeiXinCmsContentPo(WeiXinCmsContentPo weiXinCmsContentPo) {
		this.weiXinCmsContentPo = weiXinCmsContentPo;
	}

	public WeiXinDoctorMgr getWeiXinDoctorMgr() {
		return weiXinDoctorMgr;
	}

	public void setWeiXinDoctorMgr(WeiXinDoctorMgr weiXinDoctorMgr) {
		this.weiXinDoctorMgr = weiXinDoctorMgr;
	}

	public WeiXinDoctorPo getWeiXinDoctorPo() {
		return weiXinDoctorPo;
	}

	public void setWeiXinDoctorPo(WeiXinDoctorPo weiXinDoctorPo) {
		this.weiXinDoctorPo = weiXinDoctorPo;
	}

	public List<WeiXinDoctorPo> getWeiXinDoctorList() {
		return weiXinDoctorList;
	}

	public void setWeiXinDoctorList(List<WeiXinDoctorPo> weiXinDoctorList) {
		this.weiXinDoctorList = weiXinDoctorList;
	}

	public CustomerComplainPo getCustomerComplainPo() {
		return customerComplainPo;
	}

	public void setCustomerComplainPo(CustomerComplainPo customerComplainPo) {
		this.customerComplainPo = customerComplainPo;
	}

	public CustomerComplainMgr getCustomerComplainMgr() {
		return customerComplainMgr;
	}

	public void setCustomerComplainMgr(CustomerComplainMgr customerComplainMgr) {
		this.customerComplainMgr = customerComplainMgr;
	}

	public WeiXinServiceMgr getWeiXinServiceMgr() {
		return weiXinServiceMgr;
	}

	public void setWeiXinServiceMgr(WeiXinServiceMgr weiXinServiceMgr) {
		this.weiXinServiceMgr = weiXinServiceMgr;
	}

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}

	public List<ComplaintsTypePo> getComplaintsTypeList() {
		return complaintsTypeList;
	}

	public void setComplaintsTypeList(List<ComplaintsTypePo> complaintsTypeList) {
		this.complaintsTypeList = complaintsTypeList;
	}

	public ConfigurationMgr getConfigurationMgr() {
		return configurationMgr;
	}

	public void setConfigurationMgr(ConfigurationMgr configurationMgr) {
		this.configurationMgr = configurationMgr;
	}

	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	public List<SalesBasicPo> getSalesBasicList() {
		return salesBasicList;
	}

	public void setSalesBasicList(List<SalesBasicPo> salesBasicList) {
		this.salesBasicList = salesBasicList;
	}

	public WeiXinDoctorAppraisalMgr getWeiXinDoctorAppraisalMgr() {
		return weiXinDoctorAppraisalMgr;
	}

	public void setWeiXinDoctorAppraisalMgr(
			WeiXinDoctorAppraisalMgr weiXinDoctorAppraisalMgr) {
		this.weiXinDoctorAppraisalMgr = weiXinDoctorAppraisalMgr;
	}

	public WeiXinDoctorAppraisalPo getWeiXinDoctorAppraisalPo() {
		return weiXinDoctorAppraisalPo;
	}

	public void setWeiXinDoctorAppraisalPo(
			WeiXinDoctorAppraisalPo weiXinDoctorAppraisalPo) {
		this.weiXinDoctorAppraisalPo = weiXinDoctorAppraisalPo;
	}

	public InspectionNMgr getInspectionNMgr() {
		return inspectionNMgr;
	}

	public void setInspectionNMgr(InspectionNMgr inspectionNMgr) {
		this.inspectionNMgr = inspectionNMgr;
	}

	public WeiXinRegisterDepartmentMgr getWeiXinRegisterDepartmentMgr() {
		return weiXinRegisterDepartmentMgr;
	}

	public void setWeiXinRegisterDepartmentMgr(
			WeiXinRegisterDepartmentMgr weiXinRegisterDepartmentMgr) {
		this.weiXinRegisterDepartmentMgr = weiXinRegisterDepartmentMgr;
	}

	public WeiXinRegisterDepartmentPo getWeiXinRegisterDepartmentPo() {
		return weiXinRegisterDepartmentPo;
	}

	public void setWeiXinRegisterDepartmentPo(
			WeiXinRegisterDepartmentPo weiXinRegisterDepartmentPo) {
		this.weiXinRegisterDepartmentPo = weiXinRegisterDepartmentPo;
	}
}
