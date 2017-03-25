package com.pengsheng.eims.personnel.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.mgr.SchedulingMgr;
import com.pengsheng.eims.personnel.persistence.SchedulingDayPo;
import com.pengsheng.eims.personnel.persistence.SchedulingMonthPo;
import com.pengsheng.eims.personnel.persistence.SchedulingPersonDayPo;
import com.pengsheng.eims.personnel.persistence.SchedulingPersonDayPos;
import com.pengsheng.eims.personnel.persistence.SchedulingPersonPo;
import com.pengsheng.eims.personnel.persistence.SchedulingPersonPos;
import com.pengsheng.eims.personnel.persistence.ShiftMaintainPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonDepartmentsPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class SchedulingAction extends BaseAction
{
	private SchedulingMgr schedulingMgr;
	private PersonPermissionMgr personPermissionMgr;
	private SchedulingDayPo schedulingDayPo;	
	private List<SchedulingPersonPo> schedulingPersonPos;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private List<SchedulingMonthPo> schedulingMonthPos;
	private List<SchedulingDayPo> schedulingDayPos;
	private SchedulingMonthPo schedulingMonthPo;
	private SchedulingPersonPos  schedulingPersonPo;
	private List<PersonInfoPo> personInfos;
	private List<ShiftMaintainPo> shiftMaintainPos;
	private List<DepartmentsPo> departmentsList; 
	private DepartmentsMgr departmentsMgr;
	private SchedulingPersonDayPo schedulingPersonDayPo;
	private  List<SchedulingPersonDayPo> schedulingPersonDayPos;
	private SchedulingPersonPo spersonPo;
	public String initSchedulingMonthSel() 
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "monthScheduling";
		}
				
		return SUCCESS;
	}
	public String selSchedulingMonths()
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

		SchedulingMonthPo po = new SchedulingMonthPo();
		
		po.setMsmnumber(Utility.getName(request.getParameter("number")));
		//po.setMsmdepartmentid(Utility.getName(request.getParameter("departmentid")));
		po.setMsmcreatepersonname(Utility.getName(request.getParameter("createPerson")));
		//po.setMsmcreatedatebegin(Utility.getName(request.getParameter("createBegin")));
		//po.setMsmcreatedateend(Utility.getName(request.getParameter("createEnd")));
		po.setMsmexaminepersonname(Utility.getName(request.getParameter("examinePerson")));
		//po.setMsmexaminedatebegin(Utility.getName(request.getParameter("examineBegin")));
		//po.setMsmexaminedateend(Utility.getName(request.getParameter("examineEnd")));
	
//		//审核
//		String id=Utility.getName(request.getParameter("id"));
//		if(null!=id && !"".equals(id))
//		{
//			MonthWagePo mmp=wageMgr.getMonthWagePoById(id);
//			wageMgr.updateMonthWagePo(mmp);
//		}
		
		request.setAttribute("number", request.getParameter("number"));
		//request.setAttribute("departmentid", request.getParameter("departmentid"));
		//request.setAttribute("departmentname", request.getParameter("departmentname"));
		request.setAttribute("createPerson", request.getParameter("createPerson"));
		//request.setAttribute("createBegin", request.getParameter("createBegin"));
		//request.setAttribute("createEnd", request.getParameter("createEnd"));
		request.setAttribute("examinePerson", request.getParameter("examinePerson"));
		//request.setAttribute("examineBegin", request.getParameter("examineBegin"));
		//request.setAttribute("examineEnd", request.getParameter("examineEnd"));
	
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

		int count = schedulingMgr.getSchedulingMonthCount(po);

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

			schedulingMonthPos = schedulingMgr.getSchedulingMonths(po, page.getStart(), page.getPageSize());			
			
			request.setAttribute(Pagination.PAGINATION, page);
		}		
		return SUCCESS;
	}
	
	public String initSchedulingDaySel() 
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

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */		
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsList = departmentsMgr.getDepartments(deppo);	
		
		return SUCCESS;
	}

	public String selSchedulingDays() 
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

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		SchedulingPersonPo po = new SchedulingPersonPo();
		
//		po.setMsdnumber(Utility.getName(request.getParameter("number")));
//		po.setMsddepartmentid(Utility.getName(request.getParameter("departmentid")));
//		po.setMsdexaminestate(Utility.getName(request.getParameter("state")));		
		po.setMsdyear(Utility.getName(request.getParameter("year")));
		po.setMsdmonth(Utility.getName(request.getParameter("month")));
		po.setMsppersonid(Utility.getName(request.getParameter("personNumber")));
		po.setMsppersonname(Utility.getName(request.getParameter("personName")));
		po.setDepartmentids(Utility.getName(request.getParameter("departmentid")));
//		request.setAttribute("number", request.getParameter("number"));
//		request.setAttribute("departmentid", request.getParameter("departmentid"));
//		request.setAttribute("departmentname", request.getParameter("departmentname"));
//		request.setAttribute("state", request.getParameter("state"));
		request.setAttribute("year", request.getParameter("year"));
		request.setAttribute("month", request.getParameter("month"));
		request.setAttribute("personNumber", request.getParameter("personNumber"));
		request.setAttribute("personName", request.getParameter("personName"));
		request.setAttribute("departmentname", request.getParameter("departmentname"));
		request.setAttribute("departmentid", request.getParameter("departmentid"));
		
//		DepartmentsPo deppo=new DepartmentsPo();
//		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
//		deppo.setBdptype(personInfoPo.getDepartmenttype());
//		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
//		departmentsList = departmentsMgr.getDepartments(deppo);	
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());		
		
		
		int count = schedulingMgr.getSchedulingPersonPoCount(po);
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
			
			SchedulingMonthPo ssp=new SchedulingMonthPo();
			ssp.setMsmyear(po.getMsdyear());
			ssp.setMsmmonth(po.getMsdmonth());			
			schedulingMonthPo =schedulingMgr.getSchedulingMonthPoByMonth(ssp);
			if(schedulingMonthPo!=null)
			{
				schedulingDayPos = schedulingMgr.getSchedulingDays(Utility.getName(schedulingMonthPo.getMsmuuid()));			
				schedulingPersonDayPos=	schedulingMgr.getSchedulingPersonDays(Utility.getName(schedulingMonthPo.getMsmuuid()),1);
			}
						
			schedulingPersonPos = schedulingMgr.getSchedulingPersonPos(po, page.getStart(), page.getPageSize());
		
			request.setAttribute(Pagination.PAGINATION, page);
		}

		
		return SUCCESS;
	}
	
	public String selSchedulingMonthDetails() 
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

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		SchedulingDayPo po = new SchedulingDayPo();
		
		po.setMsdsmuuid(Utility.getName(request.getParameter("hid")));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());		
		schedulingMonthPo = schedulingMgr.getSchedulingMonthPo(Utility.getName(request.getParameter("hid")));
		

		shiftMaintainPos=schedulingMgr.getShiftMaintainPos();

		schedulingDayPos = schedulingMgr.getSchedulingDays(Utility.getName(request.getParameter("hid")));
		schedulingPersonPos = schedulingMgr.getSchedulingPersons(Utility.getName(request.getParameter("hid")));
		schedulingPersonDayPos=	schedulingMgr.getSchedulingPersonDays(Utility.getName(request.getParameter("hid")),1);
		return SUCCESS;
	}
	
	public String initSchedulingDayPoInsert() 
	{
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
		String tj=Utility.getName(request.getParameter("tj"));
		if(tj.equals("1"))
		{	
			request.setAttribute("month", schedulingDayPo.getMsdmonth());
	        request.setAttribute("year", schedulingDayPo.getMsdyear());
			if(!schedulingDayPo.getMsdyear().equals("") && !schedulingDayPo.getMsdmonth().equals(""))
			{
				int year=Integer.parseInt(schedulingDayPo.getMsdyear());
				int month=Integer.parseInt(schedulingDayPo.getMsdmonth());
											        
				Calendar  a = Calendar.getInstance();  
		        a.set(Calendar.YEAR, year);  
		        a.set(Calendar.MONTH, month - 1);  
		        a.set(Calendar.DATE, 1);  
		        a.roll(Calendar.DATE, -1);  
		        int maxDate = a.get(Calendar.DATE); 
		        ArrayList dat= new ArrayList();
		        for(int i=1;i<=maxDate;i++)
		        {
		        	dat.add(i);
		        }
		        request.setAttribute("dat", dat);
		        
		        String[] ids=spersonPo.getPersonids().split(",");
		        String[] names=spersonPo.getPersonNames().split(",");
		        personInfos=new ArrayList<PersonInfoPo>();
		        if(null!=ids && ids.length>0)
		        {
		        	int tp=ids.length;
		        	for(int j=0;j<tp;j++)
		        	{
		        		PersonInfoPo po=new PersonInfoPo();
		        		po.setPersonName(names[j]);
		        		po.setId(ids[j]);
		        		personInfos.add(po);
		        	}
		        }
				
			}
			
	        
			//personInfos=schedulingMgr.getPersonInfoByDept(schedulingDayPo.getMsddepartmentid());
			shiftMaintainPos=schedulingMgr.getShiftMaintainPos();
		}else
		{
			schedulingDayPo=new SchedulingDayPo();
			schedulingDayPo.setMsdnumber("HR"+GenerateNumber.getInstance().getGenerageNumber());
			schedulingDayPo.setMsdcreatepersonname(personInfoPo.getPersonName());		
			SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyy-MM-dd"); 		
			String temp= numHeadFormat.format(new Date());
			schedulingDayPo.setMsdcreatedate(temp);			
		}
		
		
		return SUCCESS;
	}
	
	public String initSchedulingDayPoUpdate() 
	{
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
		
		personInfos=schedulingMgr.getPersonInfoByDept(schedulingDayPo.getMsddepartmentid());
		shiftMaintainPos=schedulingMgr.getShiftMaintainPos();
		
		return SUCCESS;
	}
	
	public String initSchedulingDay() 
	{
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
		
		
		
		return SUCCESS;
	}
				  
	public String insertSchedulingDayPo() throws Exception 
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("部门：" + Utility.getName(schedulingDayPo.getMsddepartmentname()) + "排班新增!" );
		
		schedulingDayPo.setMsdcreatepersonid(personInfoPo.getId());
		String perid=Utility.getName(request.getParameter("perid"));
		String ctype=Utility.getName(request.getParameter("ctype"));
		
		SchedulingMonthPo smpo=new SchedulingMonthPo();		
		smpo.setMsmyear(schedulingDayPo.getMsdyear());
		smpo.setMsmmonth(schedulingDayPo.getMsdmonth());
		smpo.setMsmdepartmentid(schedulingDayPo.getMsddepartmentid());

		//查询人员是否重复
		int tem=schedulingMgr.getSchedulingMonthPoRepeat(smpo);
		int state=0;
		if(tem>0)
		{
			schedulingMonthPo=schedulingMgr.getSchedulingMonthPoByMonth(smpo);
			state=Integer.parseInt(schedulingMonthPo.getMsmexaminestate());			
		}
		//flag=schedulingMgr.getSchedulingDayPoRepeat(schedulingDayPo);
		
		
		//清空message
		this.clearMessages();
		
				

		//如果结果为0，ID不存在继续执行
		if(state==0)
		{	
				
				schedulingPersonPos=new ArrayList<SchedulingPersonPo>();
				schedulingPersonDayPos=new ArrayList<SchedulingPersonDayPo>();
				if(ctype.equals("1"))
				{
					int year=Integer.parseInt(schedulingDayPo.getMsdyear());
					int month=Integer.parseInt(schedulingDayPo.getMsdmonth());
					Calendar  a = Calendar.getInstance();  
			        a.set(Calendar.YEAR, year);  
			        a.set(Calendar.MONTH, month - 1);  
			        a.set(Calendar.DATE, 1);  
			        a.roll(Calendar.DATE, -1);  
			        int maxDate = a.get(Calendar.DATE); 
			        
			        String[] tep=perid.split(",");
			        			        
					int familyCount=tep.length;
					for(int b=0;b<familyCount;b++)
					{
						if(!tep[b].equals(""))
						{
							SchedulingPersonPo pf=new SchedulingPersonPo();
							pf.setMsppersonid(tep[b]);
//							pf.setMspshiftuuid(schedulingPersonPo.getMspshiftuuid()[b]);
//							pf.setMspremark(schedulingPersonPo.getMspremark()[b]);																		
							schedulingPersonPos.add(pf);	
							
							for(int x=1;x<=maxDate;x++)
					        {
								String om="sm"+x;
								
					        	String[] sm=request.getParameterValues(om);
					        	String usm="";
					        	String usmname="";	
					        	if(null!=sm && sm.length>0)
					        	{
					        		int temp=sm.length;
					        		for(int j=0;j<temp;j++)
					        		{
					        			ShiftMaintainPo shiftMaintainPo =schedulingMgr.getShiftMaintainPo(sm[j]);					        			
					        			
					        			if(j==temp-1)
					        			{
					        				usm+=sm[j];
					        				usmname+=shiftMaintainPo.getMsmshiftName();
					        			}
					        			else
					        			{
					        				usm+=sm[j]+",";
					        				usmname+=shiftMaintainPo.getMsmshiftName()+",";
					        			}
					        		}
					        	}
					        	
					        	SchedulingPersonDayPo spp=new SchedulingPersonDayPo();
					        	spp.setMspdsduuid(x+"");
					        	spp.setMspdspuuid(pf.getMsppersonid());
					        	spp.setMspdshiftuuid(usm);
					        	spp.setMspdshiftname(usmname);
					        	
					        	schedulingPersonDayPos.add(spp);
					        }
						}												
					}
				}else
				{
					if(null!=schedulingPersonPo)
					{
						int year=Integer.parseInt(schedulingDayPo.getMsdyear());
						int month=Integer.parseInt(schedulingDayPo.getMsdmonth());
						Calendar  a = Calendar.getInstance();  
				        a.set(Calendar.YEAR, year);  
				        a.set(Calendar.MONTH, month - 1);  
				        a.set(Calendar.DATE, 1);  
				        a.roll(Calendar.DATE, -1);  
				        int maxDate = a.get(Calendar.DATE); 
				        			        
						int familyCount=schedulingPersonPo.getMsppersonid().length;
						for(int b=0;b<familyCount;b++)
						{
							SchedulingPersonPo pf=new SchedulingPersonPo();
							pf.setMsppersonid(schedulingPersonPo.getMsppersonid()[b]);
	//						pf.setMspshiftuuid(schedulingPersonPo.getMspshiftuuid()[b]);
	//						pf.setMspremark(schedulingPersonPo.getMspremark()[b]);																		
							schedulingPersonPos.add(pf);	
							
							for(int x=1;x<=maxDate;x++)
					        {
								String om="sm"+pf.getMsppersonid()+"y"+x;
								
					        	String[] sm=request.getParameterValues(om);
					        	String usm="";
					        	String usmname="";		
					        	if(null!=sm && sm.length>0)
					        	{
					        		int temp=sm.length;
					        		for(int j=0;j<temp;j++)
					        		{
					        			ShiftMaintainPo shiftMaintainPo =schedulingMgr.getShiftMaintainPo(sm[j]);					        			
					        			
					        			if(j==temp-1)
					        			{
					        				usm+=sm[j];
					        				usmname+=shiftMaintainPo.getMsmshiftName();
					        			}
					        			else
					        			{
					        				usm+=sm[j]+",";
					        				usmname+=shiftMaintainPo.getMsmshiftName()+",";
					        			}
					        			
					        		}
					        	}
					        	
					        	SchedulingPersonDayPo spp=new SchedulingPersonDayPo();
					        	spp.setMspdsduuid(x+"");
					        	spp.setMspdspuuid(pf.getMsppersonid());
					        	spp.setMspdshiftuuid(usm);
					        	spp.setMspdshiftname(usmname);
					        	schedulingPersonDayPos.add(spp);
					        }
							
						}
					}
				}				
				schedulingMgr.insertSchedulingDayPo(schedulingDayPo,schedulingPersonPos,schedulingPersonDayPos,logPo)	;	
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				request.setAttribute("flag",GlobalConstants.OPENUPDATE);
				return SUCCESS;				
			
		}else
		{
			int year=Integer.parseInt(schedulingDayPo.getMsdyear());
			int month=Integer.parseInt(schedulingDayPo.getMsdmonth());
			Calendar  a = Calendar.getInstance();  
	        a.set(Calendar.YEAR, year);  
	        a.set(Calendar.MONTH, month - 1);  
	        a.set(Calendar.DATE, 1);  
	        a.roll(Calendar.DATE, -1);  
	        int maxDate = a.get(Calendar.DATE); 
	        ArrayList dat= new ArrayList();
	        for(int i=1;i<=maxDate;i++)
	        {
	        	dat.add(i);
	        }
	        request.setAttribute("dat", dat);
	        request.setAttribute("month", month);
	        request.setAttribute("year", year);
	        String[] ids=spersonPo.getPersonids().split(",");
	        String[] names=spersonPo.getPersonNames().split(",");
	        personInfos=new ArrayList<PersonInfoPo>();
	        if(null!=ids && ids.length>0)
	        {
	        	int tp=ids.length;
	        	for(int j=0;j<tp;j++)
	        	{
	        		PersonInfoPo po=new PersonInfoPo();
	        		po.setPersonName(names[j]);
	        		po.setId(ids[j]);
	        		personInfos.add(po);
	        	}
	        }
	        
			//personInfos=schedulingMgr.getPersonInfoByDept(schedulingDayPo.getMsddepartmentid());
			shiftMaintainPos=schedulingMgr.getShiftMaintainPos();
			this.addActionMessage(getText(schedulingMonthPo.getMsmmonth()+"月排班已审核不可录入！"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			
			return "error";
		}

	}
	
	

	
	public String initUpdateSchedulingDayPo() throws Exception 
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
		
		
		shiftMaintainPos=schedulingMgr.getShiftMaintainPos();
		spersonPo = schedulingMgr.getSchedulingPersonById(Utility.getName(request.getParameter("hid")));
		schedulingDayPos = schedulingMgr.getSchedulingDays(Utility.getName(spersonPo.getMspsmuuid()));
		schedulingPersonDayPos=	schedulingMgr.getSchedulingPersonDays(Utility.getName(spersonPo.getMspuuid()),2);
		
		
		return SUCCESS;
	}

	public String updateSchedulingDayPo() throws Exception 
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("人员：" + Utility.getName(spersonPo.getMsppersonid()) + "排班更新!" );
		

		schedulingMonthPo=schedulingMgr.getSchedulingMonthPo(spersonPo.getMspsmuuid());
		schedulingPersonDayPos=new ArrayList<SchedulingPersonDayPo>();
				
		int year=Integer.parseInt(schedulingMonthPo.getMsmyear());
		int month=Integer.parseInt(schedulingMonthPo.getMsmmonth());
		Calendar  a = Calendar.getInstance();  
        a.set(Calendar.YEAR, year);  
        a.set(Calendar.MONTH, month - 1);  
        a.set(Calendar.DATE, 1);  
        a.roll(Calendar.DATE, -1);  
        int maxDate = a.get(Calendar.DATE);        
        			        
			
				
		for(int x=1;x<=maxDate;x++)
        {
			String om="sm"+x;
			
        	String[] sm=request.getParameterValues(om);
        	String dayid=request.getParameter("kk"+x);
        	String usm="";
        	String usmname="";
        	if(null!=sm && sm.length>0)
        	{
        		int temp=sm.length;
        		for(int j=0;j<temp;j++)
        		{
        			ShiftMaintainPo shiftMaintainPo =schedulingMgr.getShiftMaintainPo(sm[j]);
        			if(j==temp-1)
        			{
        				usm+=sm[j];
        				usmname+=shiftMaintainPo.getMsmshiftName();
        			}
        			else
        			{
        				usm+=sm[j]+",";
        				usmname+=shiftMaintainPo.getMsmshiftName()+",";
        			}
        		}
        	}
        	
        	SchedulingPersonDayPo spp=new SchedulingPersonDayPo();
        	spp.setMspdsduuid(dayid);
        	spp.setMspdspuuid(spersonPo.getMspuuid());
        	spp.setMspdshiftuuid(usm);
        	spp.setMspdshiftname(usmname);
        	spp.setMspdsmuuid(spersonPo.getMspsmuuid());
        	
        	schedulingPersonDayPos.add(spp);
	
        }		
		schedulingMgr.updateSchedulingPersonDay(schedulingPersonDayPos,logPo)	;	
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		return SUCCESS;				
			
		

	}
	
	
	public String initSchedulingDayDetails() throws Exception 
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
		shiftMaintainPos=schedulingMgr.getShiftMaintainPos();

		schedulingDayPos = schedulingMgr.getSchedulingDays(Utility.getName(request.getParameter("hid")));
		schedulingPersonPos = schedulingMgr.getSchedulingPersons(Utility.getName(request.getParameter("hid")));
		schedulingPersonDayPos=	schedulingMgr.getSchedulingPersonDays(Utility.getName(request.getParameter("hid")),1);
		return SUCCESS;
	}
	
	public String initDeleteSchedulingDayPo() throws Exception {
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
		
		spersonPo = schedulingMgr.getSchedulingPersonById(Utility.getName(request.getParameter("hid")));
		
		return SUCCESS;
	}
	
	public String deleteSchedulingDayPo() throws Exception {
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
		
		spersonPo = schedulingMgr.getSchedulingPersonById(Utility.getName(request.getParameter("hid")));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("排班人员为" + Utility.getName(spersonPo.getMsppersonid()) + "的单据删除!");
		
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		schedulingMgr.deleteSchedulingDayPo(spersonPo.getMspuuid(), logPo);	
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		
		return SUCCESS;
	}
	
	public String initUpdateSchedulingDayPoWithExamine() throws Exception {
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

		schedulingDayPo = schedulingMgr.selectSchedulingDayPo(Utility.getName(request.getParameter("hid")));
		
		return SUCCESS;
	}
	
	public String updateSchedulingDayPoWithExamine() throws Exception {
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
		
		schedulingDayPo = schedulingMgr.selectSchedulingDayPo(Utility.getName(request.getParameter("hid")));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("日排班编号为" + Utility.getName(schedulingDayPo.getMsdnumber()) + "的单据审核!");
		
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		schedulingDayPo.setMsdexaminepersonid(createPerson);
		
		schedulingMgr.updateSchedulingDayPoWithExamine(schedulingDayPo, logPo);	
		this.addActionMessage(getText("struts.messages.update.sucess"));
		
		return SUCCESS;
	}
	
	/**
	 * 汇总排班表
	 * @return
	 * @throws Exception
	 */
	public String insertSchedulingMonthPo() throws Exception {
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
		
		SchedulingMonthPo po = new SchedulingMonthPo();
		
		po.setMsmnumber("PB"+GenerateNumber.getInstance().getGenerageNumber());
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 2 表示删除
		logPo.setsLogContent("月排班编号为:" + Utility.getName(po.getMsmnumber()) + "的单据生成!");
		
		String departmentid = Utility.getName(request.getParameter("departmentid"));
		String year = Utility.getName(request.getParameter("year"));
		String month = Utility.getName(request.getParameter("month"));
		String bills = Utility.getName(request.getParameter("bills"));
		String[] billlist = bills.trim().split(",");
		
		po.setMsmdepartmentid(departmentid);
		po.setMsmyear(year);
		po.setMsmmonth(month);
		po.setMsmcreatepersonid(createPerson);
		
		schedulingDayPos = new ArrayList<SchedulingDayPo>();
		
		for(int i=0; i<billlist.length; i++){
			SchedulingDayPo dayPo = new SchedulingDayPo();
			dayPo.setMsduuid(billlist[i]);
			schedulingDayPos.add(dayPo);
		}
		
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		schedulingMgr.insertSchedulingMonthPo(po, schedulingDayPos, logPo);	
		this.addActionMessage(getText("struts.messages.update.sucess"));
		
		return SUCCESS;
	}
	
	public String initDeleteSchedulingMonthPo() throws Exception {
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

		schedulingMonthPo = schedulingMgr.getSchedulingMonthPo(Utility.getName(request.getParameter("hid")));
		
		return SUCCESS;
	}
	
	public String deleteSchedulingMonthPo() throws Exception {
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
		
		schedulingMonthPo = schedulingMgr.getSchedulingMonthPo(Utility.getName(request.getParameter("hid")));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("月排班编号为" + Utility.getName(schedulingMonthPo.getMsmnumber()) + "的单据删除!");
		
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		schedulingMgr.deleteSchedulingMonthPo(Utility.getName(request.getParameter("hid")), logPo);	
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		
		return SUCCESS;
	}
	
	
	public String initAuditSchedulingMonthPo() throws Exception {
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

		schedulingMonthPo = schedulingMgr.getSchedulingMonthPo(Utility.getName(request.getParameter("hid")));
		
		return SUCCESS;
	}
	
	public String auditSchedulingMonthPo() throws Exception {
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
		
		schedulingMonthPo = schedulingMgr.getSchedulingMonthPo(Utility.getName(request.getParameter("hid")));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("月排班编号为" + Utility.getName(schedulingMonthPo.getMsmnumber()) + "的单据审核!");
		
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		schedulingMonthPo.setMsmexaminepersonid(createPerson);
		
		schedulingMgr.updateSchedulingMonthPoWithExamine(schedulingMonthPo, logPo);	
		this.addActionMessage(getText("struts.messages.update.sucess"));
		
		return SUCCESS;
	}
	
	public SchedulingMgr getSchedulingMgr() {
		return schedulingMgr;
	}
	public void setSchedulingMgr(SchedulingMgr schedulingMgr) {
		this.schedulingMgr = schedulingMgr;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public SchedulingDayPo getSchedulingDayPo() {
		return schedulingDayPo;
	}
	public void setSchedulingDayPo(SchedulingDayPo schedulingDayPo) {
		this.schedulingDayPo = schedulingDayPo;
	}
	public List<SchedulingPersonPo> getSchedulingPersonPos() {
		return schedulingPersonPos;
	}
	public void setSchedulingPersonPos(List<SchedulingPersonPo> schedulingPersonPos) {
		this.schedulingPersonPos = schedulingPersonPos;
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
	public String getIsFirstExec() {
		return isFirstExec;
	}
	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}
	public List<SchedulingMonthPo> getSchedulingMonthPos() {
		return schedulingMonthPos;
	}
	public void setSchedulingMonthPos(List<SchedulingMonthPo> schedulingMonthPos) {
		this.schedulingMonthPos = schedulingMonthPos;
	}
	public List<SchedulingDayPo> getSchedulingDayPos() {
		return schedulingDayPos;
	}
	public void setSchedulingDayPos(List<SchedulingDayPo> schedulingDayPos) {
		this.schedulingDayPos = schedulingDayPos;
	}
	public SchedulingMonthPo getSchedulingMonthPo() {
		return schedulingMonthPo;
	}
	public void setSchedulingMonthPo(SchedulingMonthPo schedulingMonthPo) {
		this.schedulingMonthPo = schedulingMonthPo;
	}
	public SchedulingPersonPos getSchedulingPersonPo() {
		return schedulingPersonPo;
	}
	public void setSchedulingPersonPo(SchedulingPersonPos schedulingPersonPo) {
		this.schedulingPersonPo = schedulingPersonPo;
	}
	public List<PersonInfoPo> getPersonInfos() {
		return personInfos;
	}
	public void setPersonInfos(List<PersonInfoPo> personInfos) {
		this.personInfos = personInfos;
	}
	public List<ShiftMaintainPo> getShiftMaintainPos() {
		return shiftMaintainPos;
	}
	public void setShiftMaintainPos(List<ShiftMaintainPo> shiftMaintainPos) {
		this.shiftMaintainPos = shiftMaintainPos;
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
	public SchedulingPersonDayPo getSchedulingPersonDayPo() {
		return schedulingPersonDayPo;
	}
	public void setSchedulingPersonDayPo(SchedulingPersonDayPo schedulingPersonDayPo) {
		this.schedulingPersonDayPo = schedulingPersonDayPo;
	}
	public List<SchedulingPersonDayPo> getSchedulingPersonDayPos() {
		return schedulingPersonDayPos;
	}
	public void setSchedulingPersonDayPos(
			List<SchedulingPersonDayPo> schedulingPersonDayPos) {
		this.schedulingPersonDayPos = schedulingPersonDayPos;
	}
	public SchedulingPersonPo getSpersonPo() {
		return spersonPo;
	}
	public void setSpersonPo(SchedulingPersonPo spersonPo) {
		this.spersonPo = spersonPo;
	}
	
	
}
