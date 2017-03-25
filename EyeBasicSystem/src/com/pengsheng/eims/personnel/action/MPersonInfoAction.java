package com.pengsheng.eims.personnel.action;

import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.NonconformingProductPo;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.mgr.EducationMgr;
import com.pengsheng.eims.personnel.mgr.MPersonInfoMgr;
import com.pengsheng.eims.personnel.mgr.PostMgr;
import com.pengsheng.eims.personnel.mgr.SchedulingMgr;
import com.pengsheng.eims.personnel.persistence.EducationPo;
import com.pengsheng.eims.personnel.persistence.EmergencyContactPo;
import com.pengsheng.eims.personnel.persistence.PersonEducationPo;
import com.pengsheng.eims.personnel.persistence.PersonEducationPos;
import com.pengsheng.eims.personnel.persistence.PersonFamilyPo;
import com.pengsheng.eims.personnel.persistence.PersonFamilyPos;
import com.pengsheng.eims.personnel.persistence.PersonInfoPo;
import com.pengsheng.eims.personnel.persistence.PersonWorkPo;
import com.pengsheng.eims.personnel.persistence.PersonWorkPos;
import com.pengsheng.eims.personnel.persistence.PersonnelChangePo;
import com.pengsheng.eims.personnel.persistence.PostPo;
import com.pengsheng.eims.personnel.persistence.SchedulingMonthPo;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.PersonDepartmentsPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class MPersonInfoAction extends BaseAction
{
	private File[] upload;
	private String[] uploadFileName;
	private String savePath;	
	private String result;

	private PersonInfoPo personInfoPo;
	private MPersonInfoMgr mpersonInfoMgr;
	private DepartmentsMgr departmentsMgr;
	private PostMgr postMgr;
	private EducationMgr educationMgr;

	private List<PersonInfoPo> persons;
	private List<RolePo> roles;
	private List<PostPo> postPos;
	private List<PostPo> postPos2;
	private List<EducationPo> educationList;	//学历List
	private List<DepartmentsPo> departments;
	private List<PersonDepartmentsPo> personDepartments;
	private PersonPermissionMgr personPermissionMgr;	
	private PersonWorkPos personWorkPo;
	private List<PersonWorkPo> personWorkPos;
	private PersonFamilyPos personFamilyPo;
	private List<PersonFamilyPo> personFamilyPos;
	private PersonEducationPos personEducationPo;
	private List<PersonEducationPo> personEducationPos;
	private EmergencyContactPo emergencyContactPo;
	private List<PersonnelChangePo> personnelChangePos;
	private PersonnelChangePo personnelChangePo;
	private SchedulingMgr schedulingMgr;
	private SchedulingMonthPo schedulingMonthPo;

	private InputStream inputStream = null;
	private String fileName = null;
	
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private List<PostPo> postMinList; // 不合格品原因List	
	private List<CompanyNamePo> companyNamePos;
	private CompanyNameMgr companyNameMgr;
	

	public String initMPersonInfoSel() {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
		
		// 取得所有角色
		roles = mpersonInfoMgr.getRoles();
		
		// 取所有部门
		departments = departmentsMgr.getDepartments();
		
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "personRedire";
		}
		String isOpen=Utility.getName(request.getParameter("isOpen"));
		if(isOpen.equals("1"))
		{
			return "isOpen";
		}else if(isOpen.equals("2"))
		{
			return "isOpens";
		}
		return SUCCESS;
	}

	/**
	 * 
	 * 
	 */
	public String selMPersonInfo() {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		PersonInfoPo personInfo = new PersonInfoPo();
		personInfo.setId(request.getParameter("selId"));
		personInfo.setPersonName(request.getParameter("selPersonName"));
		personInfo.setRoleid(request.getParameter("selRoleid"));
		personInfo.setIsinvocation(request.getParameter("isinvocation"));
		personInfo.setBeginentrytime(request.getParameter("begintime"));
		personInfo.setEndentrytime(request.getParameter("endtime"));
		personInfo.setDepartmentID(request.getParameter("selDepartmentID"));
		
		personInfo.setSeleducation(request.getParameter("seleducation"));
		personInfo.setBeginlizhi(request.getParameter("beginlizhi"));
		personInfo.setEndlizhi(request.getParameter("endlizhi"));
		personInfo.setBeginhetong(request.getParameter("beginhetong"));
		personInfo.setEndhetong(request.getParameter("endhetong"));
		
		personInfo.setSex(request.getParameter("selsex"));
		personInfo.setZhigongtype(request.getParameter("selzhigongtype"));
		
		personInfo.setBegage(request.getParameter("begage"));
		personInfo.setEndage(request.getParameter("endage"));
		
		personInfo.setBeglengthwork(request.getParameter("beglengthwork"));
		personInfo.setEndlengthwork(request.getParameter("endlengthwork"));

		personInfo.setHetongmanyear(request.getParameter("hetongmanyear"));
		personInfo.setXuqianmanyear(request.getParameter("xuqianmanyear"));		
		
		personInfo.setBeghetongyear(request.getParameter("beghetongyear"));	
		personInfo.setEndhetongyear(request.getParameter("endhetongyear"));	
		personInfo.setHetongmonth(request.getParameter("hetongmonth"));	
		
		
		// 取得所有角色
		roles = mpersonInfoMgr.getRoles();
		
		//取得所有学历
		educationList=educationMgr.getEducationList();

		// 取所有部门
		departments = departmentsMgr.getDepartments();
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

		int count = mpersonInfoMgr.getPersoninfosCount(personInfo);

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

			persons = mpersonInfoMgr.getPersonInfos(personInfo, page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		}		
		setRequest();
		String isOpen=Utility.getName(request.getParameter("isOpen"));
		if(isOpen.equals("1"))
		{
			return "isOpen";
		}else if(isOpen.equals("2"))
		{
			return "isOpens";
		}
		return SUCCESS;
	}
	
	
	public String initMPersonsByMonthSel() {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
		
		// 取得所有角色
		roles = mpersonInfoMgr.getRoles();
		
		// 取所有部门
		departments = departmentsMgr.getDepartments();

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		
		String year=Utility.getName(request.getParameter("year"));
		String month=Utility.getName(request.getParameter("month"));
		SchedulingMonthPo po=new SchedulingMonthPo();
		po.setMsmyear(year);
		po.setMsmmonth(month);
		String smid="";
		schedulingMonthPo =schedulingMgr.getSchedulingMonthPoByMonth(po);
		if(null!=schedulingMonthPo.getMsmuuid())
		{
			smid=schedulingMonthPo.getMsmuuid();
			if(schedulingMonthPo.getMsmexaminestate().equals("1"))
			{
				request.setAttribute("mes", month+"月排班已审核不能再次添加!");
			}else
			{
				request.setAttribute("smid", smid);
				systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
				if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
					this.setIsFirstExec("1");
					return "personRedire";
				}
			}
		}else
		{
			request.setAttribute("smid", smid);
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
				this.setIsFirstExec("1");
				return "personRedire";
			}
		}

		return SUCCESS;
		
	}

	/**
	 * 
	 * 
	 */
	public String selMPersonsByMonth() {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		PersonInfoPo personInfo = new PersonInfoPo();
		personInfo.setId(request.getParameter("selId"));
		personInfo.setPersonName(request.getParameter("selPersonName"));
		personInfo.setRoleid(request.getParameter("selRoleid"));
		personInfo.setIsinvocation(request.getParameter("isinvocation"));
		personInfo.setBeginentrytime(request.getParameter("begintime"));
		personInfo.setEndentrytime(request.getParameter("endtime"));
		personInfo.setDepartmentID(request.getParameter("selDepartmentID"));
		

		// 取得所有角色
		roles = mpersonInfoMgr.getRoles();

		// 取所有部门
		departments = departmentsMgr.getDepartments();
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
		schedulingMonthPo=new SchedulingMonthPo();
		String smid=request.getParameter("smid");
		if(!"".equals(smid))
		{
			schedulingMonthPo.setMsmuuid(smid);
		}
		request.setAttribute("smid", smid);
		int count = mpersonInfoMgr.getPersonsByScheduingMonthCount(personInfo,schedulingMonthPo);

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

			persons = mpersonInfoMgr.getPersonsByScheduingMonth(personInfo,schedulingMonthPo, page.getStart(), page.getPageSize());
		
			request.setAttribute(Pagination.PAGINATION, page);
		}		
		setRequest();
		String isOpen=Utility.getName(request.getParameter("isOpen"));
		
		return SUCCESS;
		
	}

	public String initPersonChangeSel() {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
		
		// 取得所有职务
		postPos= postMgr.getPostMaxList();
		
		// 取所有部门
		departments = departmentsMgr.getDepartments();

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "personchange";
		}
		
		return SUCCESS;
	}

	/**
	 * 
	 * 
	 */
	public String selPersonChanges() 
	{
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		PersonnelChangePo personnelChangePo = new PersonnelChangePo();
		personnelChangePo.setMpcpersonid(request.getParameter("selId"));
		personnelChangePo.setMpcpersonname(request.getParameter("selPersonName"));
		personnelChangePo.setMpcchangetype(request.getParameter("changeType"));
		personnelChangePo.setMpcpostid(request.getParameter("postid"));
		personnelChangePo.setMpcdepartmentID(request.getParameter("selDepartmentID"));
		
		
		request.setAttribute("selId",request.getParameter("selId"));
		request.setAttribute("selPersonName", request.getParameter("selPersonName"));
		request.setAttribute("changeType", request.getParameter("changeType"));
		request.setAttribute("postid", request.getParameter("postid"));
		request.setAttribute("selDepartmentID", request.getParameter("selDepartmentID"));
		request.setAttribute("selDepartmentName", request.getParameter("selDepartmentName"));

		// 取得所有职务
		postPos= postMgr.getPostMaxList();

		// 取所有部门
		departments = departmentsMgr.getDepartments();
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

		int count = mpersonInfoMgr.getPersonnelChangeCount(personnelChangePo);

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

			personnelChangePos = mpersonInfoMgr.getPersonnelChanges(personnelChangePo, page.getStart(), page.getPageSize());

			int tem=personnelChangePos.size();
			for(int i=0;i<tem;i++)
			{
				PersonnelChangePo pc=personnelChangePos.get(i);
				String mm=pc.getMpcchangetype();
				String mm1=mm.replaceAll("1", "部门变动");
				String mm2=mm1.replaceAll("2", "职务变动");
				String mm3=mm2.replaceAll("3", "在职离职变动");
				pc.setMpcchangetype(mm3);
			}
			
			
			request.setAttribute(Pagination.PAGINATION, page);
		}		

		return SUCCESS;
	}

	
	
	
	
	public String initMPersonInfoInsert() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		// 取得所有角色
		roles = mpersonInfoMgr.getRoles();
		//取得所有职务
		postPos=postMgr.getPostMaxList();
		
		//取得所有学历
		educationList=educationMgr.getEducationList();
		
		// 取所有部门
		departments = departmentsMgr.getDepartments();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
		return SUCCESS;
	}

	/**
	 * 人员新增
	 * 
	 * @param personInfoPo
	 */
	public String insertMPersonInfo() 
	{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1= (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String[] departmentIDS = personInfoPo.getDepartmentID().split(",");
		
		personDepartments = new ArrayList<PersonDepartmentsPo>();
		
		for (int i = 0; i < departmentIDS.length; i++) {
			PersonDepartmentsPo personDepartmentsPo = new PersonDepartmentsPo();
			personDepartmentsPo.setPersonID(personInfoPo.getId());
			personDepartmentsPo.setDepartmentID(departmentIDS[i]);
			personDepartments.add(personDepartmentsPo);
		}
		
		PersonInfoPo temp = new PersonInfoPo();
		temp.setId(personInfoPo.getId());
				
		
		temp.setAllocationflag(personInfoPo.getAllocationflag());

		if (!"".equals(Utility.getName(mpersonInfoMgr.getPersonInfo(temp).getId()))) 
		{
			// 取得所有角色
			roles = mpersonInfoMgr.getRoles();
			//取得所有职务
			postPos=postMgr.getPostMaxList();
			// 取所有部门
			departments = departmentsMgr.getDepartments();

			this.clearMessages();
			this.addActionMessage(getText("no.repeat"));
			return "NoRepeat";
		}else
		{
			//员工工作背景
			personWorkPos=new ArrayList<PersonWorkPo>();
			if(null!=personWorkPo )
			{
				int workCount=personWorkPo.getMpwcompany().length;
				for(int a=0;a<workCount;a++)
				{
					PersonWorkPo wp=new PersonWorkPo();
					wp.setMpwstartstoptime(personWorkPo.getMpwstartstoptime()[a]);
					wp.setMpwcompany(personWorkPo.getMpwcompany()[a]);
					wp.setMpwdepartment(personWorkPo.getMpwdepartment()[a]);
					wp.setMpwposition(personWorkPo.getMpwposition()[a]);
					wp.setMpwpost(personWorkPo.getMpwpost()[a]);
					personWorkPos.add(wp);	
				}
			}
			
			//家庭成员
			personFamilyPos=new ArrayList<PersonFamilyPo>();
			if(null!=personFamilyPo)
			{
				int familyCount=personFamilyPo.getMpfrelation().length;
				for(int b=0;b<familyCount;b++)
				{
					PersonFamilyPo pf=new PersonFamilyPo();
					pf.setMpfrelation(personFamilyPo.getMpfrelation()[b]);
					pf.setMpfaddress(personFamilyPo.getMpfaddress()[b]);
					pf.setMpfname(personFamilyPo.getMpfname()[b]);
					pf.setMpfoccupation(personFamilyPo.getMpfoccupation()[b]);
					pf.setMpfphone(personFamilyPo.getMpfphone()[b]);
					personFamilyPos.add(pf);	
				}
			}
			//员工教育培训背景
			personEducationPos=new ArrayList<PersonEducationPo>();
			if(null!=personEducationPo)
			{
				int peCount=personEducationPo.getMpestartstoptime().length;
				for(int c=0;c<peCount;c++)
				{
					PersonEducationPo pe=new PersonEducationPo();
					pe.setMpestartstoptime(personEducationPo.getMpestartstoptime()[c]);
					pe.setMpeuniverstity(personEducationPo.getMpeuniverstity()[c]);
					pe.setMpeeducation(personEducationPo.getMpeeducation()[c]);
					pe.setMpeprofessional(personEducationPo.getMpeprofessional()[c]);	
					personEducationPos.add(pe);	
				}
			}
			
			// 初始化状态
			personInfoPo.setUserState("0");
			personInfoPo.setCreatepersonid(personInfoPo1.getId());
			//添加日志
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(createPerson);
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 表示模块名称 
			logPo.setsLogOpID("1");    // 表示状态
			logPo.setsLogContent("人员 :" + personInfoPo.getId() + "新增!");
			String picturepathid=request.getParameter("picturepathid");
			String positivecardpathid=request.getParameter("positivecardpathid");
			String backcardpathid=request.getParameter("backcardpathid");
			List<String> ss=new ArrayList<String>();
			if(picturepathid.equals("1"))
			{
				ss.add("A");
			}
			if((positivecardpathid.equals("1")))
			{
				ss.add("B");
			}
			if((backcardpathid.equals("1")))
			{
				ss.add("C");
			}
			mpersonInfoMgr.insertPersonInfo(personInfoPo, upload,ss,this.getSavePath(),ServletActionContext.getServletContext().getRealPath(this.getSavePath()), this.getUploadFileName(),personDepartments,personWorkPos,personFamilyPos,personEducationPos,emergencyContactPo,logPo);
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));
	
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
	
			return SUCCESS;
		}
	}

	/**
	 * 初始化更新人员
	 * 
	 * @param personInfoPo
	 */
	public String initMPersonInfoUpdate() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
		
		// 取得所有角色
		roles = mpersonInfoMgr.getRoles();
		
		// 取所有部门
		departments = departmentsMgr.getDepartments();
		
		personInfoPo = new PersonInfoPo();
		personInfoPo.setId(request.getParameter("hid"));
		
		personInfoPo = mpersonInfoMgr.getPersonInfo(personInfoPo);

		//取得所有职务
		postPos=postMgr.getPostMaxList();
		
		PostPo tmpPostPo = new PostPo();
		tmpPostPo.setMptparented(personInfoPo.getPostid());
		if(personInfoPo.getPostid()!=null&&!personInfoPo.getPostid().equals("")){
			postPos2=postMgr.getPostMinList(tmpPostPo);
		}
		
		
		
		//取得所有学历
		educationList=educationMgr.getEducationList();
		
		String tmpString = "";
		if(personInfoPo.getZhuanzhengriqi()!=null&&!personInfoPo.getZhuanzhengriqi().equals("")){
			int gongling =  this.getGongLing(personInfoPo.getZhuanzhengriqi());
			int nian = gongling/12;
			int yue = gongling%12;

			if(nian>0){
				tmpString = nian+" 年";
			}
			if(yue>0){
				tmpString = tmpString+" "+ yue +" 月";
			}
			if(tmpString.equals("")){
				tmpString = "入职不满1个月";
			}
		}else{
			tmpString="入职时间未定义";
		}

		personInfoPo.setLengthwork(tmpString);
		personWorkPos=mpersonInfoMgr.selectPersonWorkPo(personInfoPo.getId());
		personFamilyPos=mpersonInfoMgr.selectPersonFamilyPo(personInfoPo.getId());
		personEducationPos=mpersonInfoMgr.selectPersonEducationPo(personInfoPo.getId());
		emergencyContactPo=mpersonInfoMgr.selectEmergencyContactPo(personInfoPo.getId());
		if(personInfoPo.getRpraddress()!=null){
			request.setAttribute("zones", personInfoPo.getRpraddress().replaceAll(" ", "").split(","));			
		}
		return SUCCESS;
	}

	/**
	 * 更新人员
	 * 
	 * @param personInfoPo
	 */
	public String updateMPersonInfo() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String[] departmentIDS = personInfoPo.getDepartmentID().split(",");
		String[] departmentNameS = personInfoPo.getBdpdepartmentname().split(",");
		
		personDepartments = new ArrayList<PersonDepartmentsPo>();
		
		for (int i = 0; i < departmentIDS.length; i++) {
			PersonDepartmentsPo personDepartmentsPo = new PersonDepartmentsPo();
			personDepartmentsPo.setPersonID(personInfoPo.getId());
			personDepartmentsPo.setDepartmentID(departmentIDS[i]);
			personDepartmentsPo.setDepartmentName(departmentNameS[i]);
			personDepartments.add(personDepartmentsPo);
		}
		
		personInfoPo.setUserState("0");
		
		// 添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("人员 :" + personInfoPo.getId() + "修改!");
		
		//员工工作背景
		personWorkPos=new ArrayList<PersonWorkPo>();
		if(null!=personWorkPo )
		{
			int workCount=personWorkPo.getMpwcompany().length;
			for(int a=0;a<workCount;a++)
			{
				PersonWorkPo wp=new PersonWorkPo();
				wp.setMpwstartstoptime(personWorkPo.getMpwstartstoptime()[a]);
				wp.setMpwcompany(personWorkPo.getMpwcompany()[a]);
				wp.setMpwdepartment(personWorkPo.getMpwdepartment()[a]);
				wp.setMpwposition(personWorkPo.getMpwposition()[a]);
				wp.setMpwpost(personWorkPo.getMpwpost()[a]);
				personWorkPos.add(wp);	
			}
		}
		
		//家庭成员
		personFamilyPos=new ArrayList<PersonFamilyPo>();
		if(null!=personFamilyPo)
		{
			int familyCount=personFamilyPo.getMpfrelation().length;
			for(int b=0;b<familyCount;b++)
			{
				PersonFamilyPo pf=new PersonFamilyPo();
				pf.setMpfrelation(personFamilyPo.getMpfrelation()[b]);
				pf.setMpfaddress(personFamilyPo.getMpfaddress()[b]);
				pf.setMpfname(personFamilyPo.getMpfname()[b]);
				pf.setMpfoccupation(personFamilyPo.getMpfoccupation()[b]);
				pf.setMpfphone(personFamilyPo.getMpfphone()[b]);
				
				
				personFamilyPos.add(pf);	
			}
		}
		//员工教育培训背景
		personEducationPos=new ArrayList<PersonEducationPo>();
		if(null!=personEducationPo)
		{
			int peCount=personEducationPo.getMpestartstoptime().length;
			for(int c=0;c<peCount;c++)
			{
				PersonEducationPo pe=new PersonEducationPo();
				pe.setMpestartstoptime(personEducationPo.getMpestartstoptime()[c]);
				pe.setMpeuniverstity(personEducationPo.getMpeuniverstity()[c]);
				pe.setMpeeducation(personEducationPo.getMpeeducation()[c]);
				pe.setMpeprofessional(personEducationPo.getMpeprofessional()[c]);	
				personEducationPos.add(pe);	
			}
		}
		
		// 初始化状态
		personInfoPo.setUserState("0");
		personInfoPo.setUpdatepersonid(personInfoPo1.getId());
		personInfoPo.setUpdatepersonname(personInfoPo1.getPersonName());
		String picturepathid=request.getParameter("picturepathid");
		String positivecardpathid=request.getParameter("positivecardpathid");
		String backcardpathid=request.getParameter("backcardpathid");
		List<String> ss=new ArrayList<String>();
		if(picturepathid.equals("1"))
		{
			ss.add("A");
		}
		if((positivecardpathid.equals("1")))
		{
			ss.add("B");
		}
		if((backcardpathid.equals("1")))
		{
			ss.add("C");
		}			
		
		mpersonInfoMgr.updatePersonInfo(personInfoPo, upload,ss,this.getSavePath(),ServletActionContext.getServletContext().getRealPath(this.getSavePath()), this.getUploadFileName(),personDepartments,personWorkPos,personFamilyPos,personEducationPos,emergencyContactPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	public String initMPersonInfoDelete() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		personInfoPo = new PersonInfoPo();
		personInfoPo.setId(request.getParameter("hid"));

		personInfoPo = mpersonInfoMgr.getPersonInfo(personInfoPo);

		return SUCCESS;
	}

	public String deleteMPersonInfo() {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("人员 :" + Utility.getName(request.getParameter("hid")) + "删除!");
		
		mpersonInfoMgr.delPerson(Utility.getName(request.getParameter("hid")),logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}

	private void setRequest() {
		request.setAttribute("selId", request.getParameter("selId"));
		request.setAttribute("selPersonName", request
				.getParameter("selPersonName"));
		request.setAttribute("selDepartmentID", request
				.getParameter("selDepartmentID"));
		request.setAttribute("selDepartmentName", Utility.getName(request.getParameter("selDepartmentName")));
		request.setAttribute("selRoleid", request.getParameter("selRoleid"));
		request.setAttribute("isinvocation", request.getParameter("isinvocation"));
		request.setAttribute("begintime", request.getParameter("begintime"));
		request.setAttribute("endtime", request.getParameter("endtime"));
		
		request.setAttribute("seleducation", request.getParameter("seleducation"));
		request.setAttribute("beginlizhi", request.getParameter("beginlizhi"));
		request.setAttribute("endlizhi", request.getParameter("endlizhi"));
		request.setAttribute("beginhetong", request.getParameter("beginhetong"));
		request.setAttribute("endhetong", request.getParameter("endhetong"));
		
		request.setAttribute("selsex", request.getParameter("selsex"));
		request.setAttribute("selzhigongtype", request.getParameter("selzhigongtype"));
		
		request.setAttribute("begage", request.getParameter("begage"));
		request.setAttribute("endage", request.getParameter("endage"));
 
		request.setAttribute("beglengthwork", request.getParameter("beglengthwork"));
		request.setAttribute("endlengthwork", request.getParameter("endlengthwork"));
		
		request.setAttribute("hetongmanyear", request.getParameter("hetongmanyear"));
		request.setAttribute("xuqianmanyear", request.getParameter("xuqianmanyear"));
		
		request.setAttribute("beghetongyear", request.getParameter("beghetongyear"));
		request.setAttribute("endhetongyear", request.getParameter("endhetongyear"));		
		request.setAttribute("hetongmonth", request.getParameter("hetongmonth"));		
	}
	
	public String getPersonRepeat() {
		
		String id = Utility.getName(request.getParameter("id"));
		
		int temp=mpersonInfoMgr.getPersonRepeat(id);
		if(temp>0)
		{
			result="true";
		}else
		{
			result="false";
		}

		return SUCCESS;
	}
	
	public String initUpdateMPersonInfoInvocation() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String cid = Utility.getName(request.getParameter("cid"));
		PersonInfoPo personInfo1 = new PersonInfoPo();
		personInfo1.setId(cid);
		
		PersonInfoPo personInfo = mpersonInfoMgr.getPersonInfo(personInfo1);
		
		request.setAttribute("personInfo", personInfo);
		return SUCCESS;
	}
	
	
	public String updateMPersonInfoInvocation() {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */		
		String invocation = Utility.getName(request.getParameter("invocation"));
		String cid = Utility.getName(request.getParameter("cid"));
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		if("0".equals(invocation)){
			logPo.setsLogOpID("39");    // 停用
			logPo.setsLogContent("人员 :" + cid + "停用!");
		}else if("1".equals(invocation)){
			logPo.setsLogOpID("38");    // 启用
			logPo.setsLogContent("人员 :" + cid + "启用!");
		}
		
		PersonInfoPo personInfoPo1 = new PersonInfoPo();
		personInfoPo1.setIsinvocation(invocation);
		personInfoPo1.setId(cid);
		
		mpersonInfoMgr.isInvocationUpdate(personInfoPo1,logPo);
	
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
	
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}

	public String exportMPersonInfo() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		PersonInfoPo personInfo = new PersonInfoPo();

		personInfo.setId(request.getParameter("selId"));
		personInfo.setPersonName(request.getParameter("selPersonName"));
		personInfo.setRoleid(request.getParameter("selRoleid"));
		personInfo.setIsinvocation(request.getParameter("isinvocation"));
		personInfo.setBeginentrytime(request.getParameter("begintime"));
		personInfo.setEndentrytime(request.getParameter("endtime"));
		personInfo.setDepartmentID(request.getParameter("selDepartmentID"));
		
		personInfo.setSeleducation(request.getParameter("seleducation"));
		personInfo.setBeginlizhi(request.getParameter("beginlizhi"));
		personInfo.setEndlizhi(request.getParameter("endlizhi"));
		personInfo.setBeginhetong(request.getParameter("beginhetong"));
		personInfo.setEndhetong(request.getParameter("endhetong"));
		
		personInfo.setSex(request.getParameter("selsex"));
		personInfo.setZhigongtype(request.getParameter("selzhigongtype"));
		
		personInfo.setBegage(request.getParameter("begage"));
		personInfo.setEndage(request.getParameter("endage"));
				
		personInfo.setBeglengthwork(request.getParameter("beglengthwork"));
		personInfo.setEndlengthwork(request.getParameter("endlengthwork"));		
	    
		setFileName(java.net.URLEncoder.encode("员工信息导出表.xls", "UTF-8"));
		
		try {
			inputStream = mpersonInfoMgr.bulidPersonInfoExcel(personInfo);
		} catch (Exception e) {
			System.out.println("员工信息导出失败：" + e.getMessage());
		}

		return SUCCESS;
	}
	
	/**
	 * 人员详情
	 * @return
	 */
	public String initMPersonInfoDetail(){
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		personInfoPo = new PersonInfoPo();
		personInfoPo.setId(Utility.getName(request.getParameter("selId")));
		
		personInfoPo = mpersonInfoMgr.getPersonInfo(personInfoPo);
		
		String tmpString = "";
		if(personInfoPo.getZhuanzhengriqi()!=null&&!personInfoPo.getZhuanzhengriqi().equals("")){
			int gongling =  this.getGongLing(personInfoPo.getZhuanzhengriqi());
			int nian = gongling/12;
			int yue = gongling%12;

			if(nian>0){
				tmpString = nian+" 年";
			}
			if(yue>0){
				tmpString = tmpString+" "+ yue +" 月";
			}
			if(tmpString.equals("")){
				tmpString = "入职不满1个月";
			}
		}else{
			tmpString="入职时间未定义";
		}
		personInfoPo.setLengthwork(tmpString);
		
		personWorkPos=mpersonInfoMgr.selectPersonWorkPo(personInfoPo.getId());
		personFamilyPos=mpersonInfoMgr.selectPersonFamilyPo(personInfoPo.getId());
		personEducationPos=mpersonInfoMgr.selectPersonEducationPo(personInfoPo.getId());
		emergencyContactPo=mpersonInfoMgr.selectEmergencyContactPo(personInfoPo.getId());
		
		request.setAttribute("warpath", request.getSession().getServletContext().getRealPath("/"));
		
		return SUCCESS;
	}
	
	/**
	 * 人事变动详情
	 * @return
	 */
	public String initPersonnelChangeDetail()
	{
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		
		String id=Utility.getName(request.getParameter("selId"));

		personnelChangePo = mpersonInfoMgr.selectPersonnelChangePo(id);

		String mm=personnelChangePo.getMpcchangetype();
		String mm1=mm.replaceAll("1", "部门变动");
		String mm2=mm1.replaceAll("2", "职务变动");
		String mm3=mm2.replaceAll("3", "在职离职变动");
		personnelChangePo.setMpcchangetype(mm3);
		
		return SUCCESS;
	}
	
	
	/**
	 * 取得Ajax数据
	 */
	public void getPostAjax() throws Exception {

		String mtpid = Utility.getName(request.getParameter("mtpid"));
		PrintWriter out;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();

		if (mtpid.equals("")) {
			out.println("<option value=''>请选择(0)</option>");
		} else {
			PostPo tmp = new PostPo();
			tmp.setMptparented(mtpid);
			postMinList = postMgr
					.getPostMinList(tmp);
			Iterator it = postMinList.iterator();
			out.println("<option value=''>请选择("
					+ postMinList.size() + ")</option>");
			if (it.hasNext()) {
				while (it.hasNext()) {
					PostPo tmpPo = (PostPo) it
							.next();
					out.println("<option value='" + tmpPo.getMptid() + "'>"
							+ tmpPo.getMptcontent() + "</option>");
				}
			}
		}
		out.close();
	}

	
	public PersonInfoPo getPersonInfoPo() {
		return personInfoPo;
	}
	public void setPersonInfoPo(PersonInfoPo personInfoPo) {
		this.personInfoPo = personInfoPo;
	}
	public MPersonInfoMgr getMpersonInfoMgr() {
		return mpersonInfoMgr;
	}
	public void setMpersonInfoMgr(MPersonInfoMgr mpersonInfoMgr) {
		this.mpersonInfoMgr = mpersonInfoMgr;
	}
	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}
	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}
	public List<PersonInfoPo> getPersons() {
		return persons;
	}
	public void setPersons(List<PersonInfoPo> persons) {
		this.persons = persons;
	}
	public List<RolePo> getRoles() {
		return roles;
	}
	public void setRoles(List<RolePo> roles) {
		this.roles = roles;
	}
	public List<DepartmentsPo> getDepartments() {
		return departments;
	}
	public void setDepartments(List<DepartmentsPo> departments) {
		this.departments = departments;
	}
	public List<PersonDepartmentsPo> getPersonDepartments() {
		return personDepartments;
	}
	public void setPersonDepartments(List<PersonDepartmentsPo> personDepartments) {
		this.personDepartments = personDepartments;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	

	public List<PersonWorkPo> getPersonWorkPos() {
		return personWorkPos;
	}

	public void setPersonWorkPos(List<PersonWorkPo> personWorkPos) {
		this.personWorkPos = personWorkPos;
	}

	

	public List<PersonFamilyPo> getPersonFamilyPos() {
		return personFamilyPos;
	}

	public void setPersonFamilyPos(List<PersonFamilyPo> personFamilyPos) {
		this.personFamilyPos = personFamilyPos;
	}



	public List<PersonEducationPo> getPersonEducationPos() {
		return personEducationPos;
	}

	public void setPersonEducationPos(List<PersonEducationPo> personEducationPos) {
		this.personEducationPos = personEducationPos;
	}

	public EmergencyContactPo getEmergencyContactPo() {
		return emergencyContactPo;
	}

	public void setEmergencyContactPo(EmergencyContactPo emergencyContactPo) {
		this.emergencyContactPo = emergencyContactPo;
	}
	public List<PostPo> getPostPos() {
		return postPos;
	}

	public void setPostPos(List<PostPo> postPos) {
		this.postPos = postPos;
	}

	public PersonWorkPos getPersonWorkPo() {
		return personWorkPo;
	}

	public void setPersonWorkPo(PersonWorkPos personWorkPo) {
		this.personWorkPo = personWorkPo;
	}

	public PersonFamilyPos getPersonFamilyPo() {
		return personFamilyPo;
	}

	public void setPersonFamilyPo(PersonFamilyPos personFamilyPo) {
		this.personFamilyPo = personFamilyPo;
	}

	public PersonEducationPos getPersonEducationPo() {
		return personEducationPo;
	}

	public void setPersonEducationPo(PersonEducationPos personEducationPo) {
		this.personEducationPo = personEducationPo;
	}

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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

	public SchedulingMonthPo getSchedulingMonthPo() {
		return schedulingMonthPo;
	}

	public void setSchedulingMonthPo(SchedulingMonthPo schedulingMonthPo) {
		this.schedulingMonthPo = schedulingMonthPo;
	}

	public List<PersonnelChangePo> getPersonnelChangePos() {
		return personnelChangePos;
	}

	public void setPersonnelChangePos(List<PersonnelChangePo> personnelChangePos) {
		this.personnelChangePos = personnelChangePos;
	}

	public PersonnelChangePo getPersonnelChangePo() {
		return personnelChangePo;
	}

	public void setPersonnelChangePo(PersonnelChangePo personnelChangePo) {
		this.personnelChangePo = personnelChangePo;
	}

	public SchedulingMgr getSchedulingMgr() {
		return schedulingMgr;
	}

	public void setSchedulingMgr(SchedulingMgr schedulingMgr) {
		this.schedulingMgr = schedulingMgr;
	}
	
	public PostMgr getPostMgr() {
		return postMgr;
	}

	public void setPostMgr(PostMgr postMgr) {
		this.postMgr = postMgr;
	}	
	
	
	
	public List<PostPo> getPostMinList() {
		return postMinList;
	}

	public void setPostMinList(List<PostPo> postMinList) {
		this.postMinList = postMinList;
	}
	public List<PostPo> getPostPos2() {
		return postPos2;
	}

	public void setPostPos2(List<PostPo> postPos2) {
		this.postPos2 = postPos2;
	}
	public EducationMgr getEducationMgr() {
		return educationMgr;
	}

	public void setEducationMgr(EducationMgr educationMgr) {
		this.educationMgr = educationMgr;
	}
	public List<EducationPo> getEducationList() {
		return educationList;
	}

	public void setEducationList(List<EducationPo> educationList) {
		this.educationList = educationList;
	}


	public String selMPersonInfoGonglingChange() {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		// 取得所有角色
		roles = mpersonInfoMgr.getRoles();
		
		//取得所有学历
		educationList=educationMgr.getEducationList();

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

		int count = mpersonInfoMgr.getGonglingChangePersoninfosCount();

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

			persons = mpersonInfoMgr.getGonglingChangePersonInfos(page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		}		

		String isOpen=Utility.getName(request.getParameter("isOpen"));
		if(isOpen.equals("1"))
		{
			return "isOpen";
		}else if(isOpen.equals("2"))
		{
			return "isOpens";
		}
		return SUCCESS;
	}
	
	private int getGongLing(String dateString){
		//////--------当前时间取得年\月----------------	
		Calendar start = Calendar.getInstance();
	    int startYear = start.get(Calendar.YEAR);
	    int startMonth = start.get(Calendar.MONTH) + 1;
	    //////--------当前时间取得年\月----------------	
	    
		Calendar end = Calendar.getInstance();//获得一个日历的实例   
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
        Date date = null;   
        try{   
            date = sdf.parse(dateString);//初始日期   
        }catch(Exception e){  

        }   
        end.setTime(date);
	    int endMonth = end.get(Calendar.MONTH) + 1;
	    int endYear = end.get(Calendar.YEAR);
		return (startYear-endYear)*12+startMonth-endMonth;
	}

	public List<CompanyNamePo> getCompanyNamePos() {
		return companyNamePos;
	}

	public void setCompanyNamePos(List<CompanyNamePo> companyNamePos) {
		this.companyNamePos = companyNamePos;
	}

	public CompanyNameMgr getCompanyNameMgr() {
		return companyNameMgr;
	}

	public void setCompanyNameMgr(CompanyNameMgr companyNameMgr) {
		this.companyNameMgr = companyNameMgr;
	}
}
