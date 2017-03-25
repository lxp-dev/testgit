package com.pengsheng.plugin.rtx.action;

import java.util.Iterator;
import java.util.List;

import rtx.RTXSvrApi;
import rtx.Signauth;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.frame.mgr.LoginMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.plugin.rtx.mgr.RTXServiceMgr;

public class RTXServiceAction extends BaseAction {
	
	private RTXServiceMgr rtxServiceMgr;

	private SystemParameterMgr systemParameterMgr;
	private LoginMgr loginMgr;
	private SystemParameterPo systemParameterPo;	
	private List<DepartmentsPo> departmentList = null;
	private String errorFlag;
	
	public List<DepartmentsPo> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<DepartmentsPo> departmentList) {
		this.departmentList = departmentList;
	}
	
	public String getErrorFlag() {
		return errorFlag;
	}

	public void setErrorFlag(String errorFlag) {
		this.errorFlag = errorFlag;
	}

	public RTXServiceMgr getRtxServiceMgr() {
		return rtxServiceMgr;
	}

	public void setRtxServiceMgr(RTXServiceMgr rtxServiceMgr) {
		this.rtxServiceMgr = rtxServiceMgr;
	}
		
	public String initRtxLogin() throws Exception {
		return SUCCESS;
	}
	
	public String initDepartment() throws Exception {

		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String personID = Utility.getName(request.getParameter("personID"));
		String departmentName = Utility.getName(request.getParameter("departmentName"));
		String departmentType = Utility.getName(request.getParameter("departmentType"));

		PersonInfoPo personInfo=new PersonInfoPo();
		personInfo.setId(personID);
		personInfo = rtxServiceMgr.getPerson(personInfo);						
		if (personInfo.getId() != null) {
			if (personInfo.getUserState().matches("[0]")) { // 当前状态0:正常 1:删除
				String address = request.getRemoteAddr();
				String machineCode = this.getMachineCode(address);
				personInfo.setMachinery(machineCode);
				session.put("person", personInfo);			
				request.setAttribute("departmentID", departmentID);
				request.setAttribute("departmentName", departmentName);
				request.setAttribute("departmentType", departmentType);				
			} else {
				this.errorFlag="1";
				this.addActionMessage(this.getText("person.not.error"));
				return ERROR;
			}
		} else {
			this.errorFlag="1";
			this.addActionMessage(this.getText("personid.password.error"));
			return ERROR;
		}	
		
		return SUCCESS;
	}
	
	public String rtxLogin() throws Exception {
		String signStr=request.getParameter("user");
		String sign=request.getParameter("sign");
		PersonInfoPo personInfo=new PersonInfoPo();
		personInfo.setId(signStr);

		
		try {
			if (signStr != null && signStr != "") {				   
				systemParameterPo = systemParameterMgr.getSystemParameterPo();

				if(systemParameterPo.getFsprtx().equals("1")&&systemParameterPo.getFspserverip()!=null&&!systemParameterPo.getFspserverip().equals("")){
					Signauth signObj = new Signauth();
					boolean bRet = signObj.auth(signStr, sign, systemParameterPo.getFspserverip());
					if (bRet) {
						personInfo = rtxServiceMgr.getPerson(personInfo);						
						if (personInfo.getId() != null) {
							if (personInfo.getUserState().matches("[0]")) { // 当前状态0:正常 1:删除
								String address = request.getRemoteAddr();
								session.put("person", personInfo);								
							} else {
								this.errorFlag="1";
								this.addActionMessage(this.getText("person.not.error"));
								return ERROR;
							}
						} else {
							this.errorFlag="1";
							this.addActionMessage(this.getText("personid.password.error"));
							return ERROR;
						}						
						departmentList = loginMgr.getDepartmentsByPerson(personInfo);
						request.setAttribute("loginPersonName",Utility.getName(personInfo.getPersonName()));
						request.setAttribute("personID",Utility.getName(signStr));
						return SUCCESS;
					} else {
					    //失败，跳转到CMS登录界面
//					    System.out.println("验证失败!");
//					    System.out.println("fail:"+sign);
						this.errorFlag="1";
						this.addActionMessage(this.getText("personid.password.error"));
						return ERROR;
					}
				}else
				{
					this.errorFlag="1";
					this.addActionMessage("未配置RTX服务器IP");
					return ERROR;
				}				
			}
		} catch (Exception ex) {
//			System.out.println("出错了" + ex.getMessage());
			this.errorFlag="1";
			this.addActionMessage(this.getText("personid.password.error"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	public LoginMgr getLoginMgr() {
		return loginMgr;
	}

	public void setLoginMgr(LoginMgr loginMgr) {
		this.loginMgr = loginMgr;
	}

	private String getMachineCode(String args) {
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

	/**
	 * 初始化同步组织架构信息页面
	 */
	public String initSyncOrganizationalStructure() throws Exception {
		systemParameterPo = systemParameterMgr.getSystemParameterPo();
		if(systemParameterPo.getFsprtx().equals("1")&&systemParameterPo.getFspserverip()!=null&&!systemParameterPo.getFspserverip().equals("")){
			RTXSvrApi  RtxsvrapiObj = new RTXSvrApi();
			if( RtxsvrapiObj.Init()){
				request.setAttribute("key", "0");
				request.setAttribute("text", "即时通讯(RTX)数据同步接口正常开启中。");
				RtxsvrapiObj.UnInit();
			}else{
				request.setAttribute("key", "1");
				request.setAttribute("text", "即时通讯(RTX)数据同步接口未正常开启，请检查相关配置。");
			}
		}else{
			request.setAttribute("key", "1");
			request.setAttribute("text", "系统设置了不可启用即时通讯(RTX)服务。");
		}
		
		return SUCCESS;
	}
	/**
	 * 同步组织架构信息
	 */
	public String syncOrganizationalStructure() throws Exception {
		
		//1、删除RTX服务器组织架构数据
		String pdeptId= "0";
    	String depts[] = null;
    	int iRet = -1;
    	
    	RTXSvrApi  RtxsvrapiObj = new RTXSvrApi();        		
    	if( RtxsvrapiObj.Init())
    	{   
    		depts = RtxsvrapiObj.getChildDepts(pdeptId);
    		if (depts != null)
    		{
    			String users[] = null;
    			
    			for (  int i = 0 ; i< depts.length;i ++)
    			{
    				iRet = RtxsvrapiObj.deleteDept(depts[i],"1");
    	    		
    	    		if (iRet == 0)
    	    		{
    	    			System.out.println("RTX--删除部门成功："+depts[i]);
    	    			
    	    		}
    	    		else 
    	    		{
    	    			System.out.println("RTX--删除部门失败："+depts[i]);
    	    		}
    			}
    		}
    		else 
    		{
    			System.out.println("RTX--该部门没有子部门");
    			
    		}
    	}
    	//1、删除RTX服务器组织架构数据

    	//2、RTX 初始化参数    	
    	String deptId= "";
    	String DeptName = "";
    	String DetpInfo = "";    	
    	String ParentDeptId = "0";
    	//2、RTX 初始化参数
    	
		List<DepartmentsPo> list = rtxServiceMgr.getDepartments();
		Iterator it = list.iterator();
		while(it.hasNext()){
			DepartmentsPo departmentsPo = (DepartmentsPo)it.next();					
			deptId = departmentsPo.getBdpdepartmentid();
				System.out.println(departmentsPo.getBdpdepartmentname());
				DeptName = departmentsPo.getBdpdepartmentname();
				
				//3、RTX 添加部门信息
				
				iRet = RtxsvrapiObj.addDept("1"+deptId,DetpInfo,DeptName,ParentDeptId);
				if (iRet==0)
	    		{
	    			System.out.println("RTX--部门添加成功："+DeptName);
	    		}
	    		else 
	    		{
	    			System.out.println("RTX--部门添加失败："+DeptName);
	    		}

		}
				
		
		//5、配置每一个用户的所在部门，同时更新用户详细信息
		List<PersonInfoPo> personInfos =  rtxServiceMgr.getPersons();
		Iterator personInfoIt = personInfos.iterator();
		while(personInfoIt.hasNext()){
			PersonInfoPo personInfoPo = (PersonInfoPo)personInfoIt.next();
			//4、RTX 添加人员信息
			iRet =RtxsvrapiObj.addUser(personInfoPo.getId(),"0",personInfoPo.getPersonName(),personInfoPo.getPassword());
			iRet =RtxsvrapiObj.SetUserSimpleInfoEx(personInfoPo.getId(),personInfoPo.getDepartmentID(), personInfoPo.getPersonName(), personInfoPo.getEmail(), ""+(Integer.parseInt(personInfoPo.getSex())-1), personInfoPo.getPhone(), personInfoPo.getPhone(), personInfoPo.getPassword());
	    	if (iRet==0)
    		{
	    		System.out.println("RTX--设置用户详细信息成功："+personInfoPo.getId()+"/"+personInfoPo.getPersonName());
    		}
    		else 
    		{
    			System.out.println("RTX--设置用户详细信息失败"+personInfoPo.getId()+"/"+personInfoPo.getPersonName());
    		}
		}			
		
		//5、RTX 关闭连接
    	RtxsvrapiObj.UnInit();
    	//5、RTX 关闭连接
		return SUCCESS;
	}

}
