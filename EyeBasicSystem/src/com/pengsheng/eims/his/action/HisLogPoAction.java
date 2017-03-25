package com.pengsheng.eims.his.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import com.fr.base.core.json.JSONException;
import com.fr.base.core.json.JSONObject;
import com.pengsheng.eims.basic.mgr.LogMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.his.mgr.HisLogPoMgr;
import com.pengsheng.eims.his.mgr.HisParamMgr;
import com.pengsheng.eims.his.persistence.HisLogPo;
import com.pengsheng.eims.his.persistence.HisParamPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class HisLogPoAction extends BaseAction {

	
	private LogMgr logMgr;		
	private HisLogPo hisLogPo;
	private String isFirstExec;
	private HisParamMgr hisParamMgr;
	private HisLogPoMgr hisLogPoMgr;
	private List<ModulePo> moduleList;
	private List<HisLogPo> hisLogPoList;
	private List<HisLogPo> hisLogList;
	private DepartmentsMgr departmentsMgr;	
	private SystemParameterPo systemParameterPo;
	private PersonPermissionMgr personPermissionMgr;
	private List<DepartmentsPo> departmentsList;
	
	
	public HisParamMgr getHisParamMgr() {
		return hisParamMgr;
	}
	public void setHisParamMgr(HisParamMgr hisParamMgr) {
		this.hisParamMgr = hisParamMgr;
	}
	public List<HisLogPo> getHisLogList() {
		return hisLogList;
	}
	public void setHisLogList(List<HisLogPo> hisLogList) {
		this.hisLogList = hisLogList;
	}
	public LogMgr getLogMgr() {
		return logMgr;
	}
	public void setLogMgr(LogMgr logMgr) {
		this.logMgr = logMgr;
	}
	public List<ModulePo> getModuleList() {
		return moduleList;
	}
	public void setModuleList(List<ModulePo> moduleList) {
		this.moduleList = moduleList;
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

	public HisLogPo getHisLogPo() {
		return hisLogPo;
	}

	public void setHisLogPo(HisLogPo hisLogPo) {
		this.hisLogPo = hisLogPo;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public HisLogPoMgr getHisLogPoMgr() {
		return hisLogPoMgr;
	}

	public void setHisLogPoMgr(HisLogPoMgr hisLogPoMgr) {
		this.hisLogPoMgr = hisLogPoMgr;
	}

	public List<HisLogPo> getHisLogPoList() {
		return hisLogPoList;
	}

	public void setHisLogPoList(List<HisLogPo> hisLogPoList) {
		this.hisLogPoList = hisLogPoList;
	}

	
	public String initHisLogDetails() {
 
		String hislogid = Utility.getName(request.getParameter("hid"));
		String billid = Utility.getName(request.getParameter("billid"));
		request.setAttribute("billid", billid);
		request.setAttribute("ssesbsalesid", hislogid);
		HisLogPo hisLogPo = new HisLogPo();
		hisLogPo.setHislogid(hislogid);
		hisLogPo = hisLogPoMgr.getHisLogInfo(hisLogPo);
		 
		//查询HISLOG信息
		
		request.setAttribute("hisLogPo",hisLogPo);   
	 
		return SUCCESS;
	}
	public String initHisLogPo() {
	 
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
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
			return "queryHisLog";
		}

		return SUCCESS;
	}
	
	public String queryHisLog(){
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String phislogdepatmentid = Utility.getName(request.getParameter("hislogdepatmentid"));
		String phislogdepatmentname= Utility.getName(request.getParameter("hislogdepatmentname"));
		String phislogpersonid = Utility.getName(request.getParameter("hislogpersonid"));
		String phisloginterfaceid = Utility.getName(request.getParameter("hisloginterfaceid"));
		String phisloginterfacename = Utility.getName(request.getParameter("hisloginterfacename"));
		String phislogmoduleid = Utility.getName(request.getParameter("hislogmoduleid"));
		String phislogmodulename = Utility.getName(request.getParameter("hislogmodulename"));
		String phislogip = Utility.getName(request.getParameter("hislogip"));

		request.setAttribute("startTime", startTime);             
		request.setAttribute("endTime", endTime);             
		request.setAttribute("phislogdepatmentid", phislogdepatmentid);             
		request.setAttribute("phislogdepatmentname", phislogdepatmentname);             
		request.setAttribute("phislogpersonid", phislogpersonid);             
		request.setAttribute("phisloginterfaceid", phisloginterfaceid);             
		request.setAttribute("phisloginterfacename", phisloginterfacename);             
		request.setAttribute("phislogmoduleid", phislogmoduleid);             
		request.setAttribute("phislogmodulename", phislogmodulename);             
		request.setAttribute("phislogip", phislogip);             
		
		HisLogPo hisLogPo = new HisLogPo();
		
		hisLogPo.setHislogbegindate(startTime); 
		hisLogPo.setHislogenddate(endTime);
		hisLogPo.setHislogdepatmentid(phislogdepatmentid); // 调用部门ID
		hisLogPo.setHislogdepatmentname(phislogdepatmentname); // 调用部门名称
		hisLogPo.setHislogpersonid(phislogpersonid); // 调用人ID
		hisLogPo.setHisloginterfaceid(phisloginterfaceid); // 接口ID
		hisLogPo.setHisloginterfacename(phisloginterfacename); // 接口名称
		hisLogPo.setHislogmoduleid(phislogmoduleid); // 所属模块ID	
		hisLogPo.setHislogmodulename(phislogmodulename);//所属模块名字
		hisLogPo.setHislogip(phislogip);      // IP地址
		
		departmentsList = departmentsMgr.getDepartments("1");
		moduleList = logMgr.getModuleList();	
		hisLogList = hisLogPoMgr.gethisLogList(); 
		
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
		
		// 查询分页
		int count = hisLogPoMgr.getHisLogPoCount(hisLogPo);
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
			hisLogPoList = hisLogPoMgr.getHisLogPoList(hisLogPo, page.getStart(), page.getPageSize());
            String id = "";			
            HisParamPo hisParamPo = new HisParamPo();
            HisParamPo hisParamPo2 = new HisParamPo();
			for(HisLogPo po: hisLogPoList){
				Map<String,Object> map = new HashMap<String,Object>();
				Map<String,Object> map2 = new HashMap<String,Object>();
				  
				try{
					if(po.getHisloginparam().contains("{")&&po.getHisloginparam().contains("}")){
						map = this.toMap(po.getHisloginparam());//入参
					}
					if(po.getHislogreturnparam().contains("{")&&po.getHislogreturnparam().contains("}")){
						map2 = this.toMap(po.getHislogreturnparam());//返回
					}
					
				}catch (Exception e) {
				}
				 
				id = "".equals(Utility.getName((String)map.get("billid"))) ? (String)map2.get("billid") : (String)map.get("billid");
				if(!"".equals(id)){
					hisParamPo.setId(id);
					hisParamPo2 = hisParamMgr.getHisParamPo(hisParamPo);
				}
				 
				po.setHislogbillid(Utility.getName(hisParamPo2.getBillid()));
			}
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			hisLogPoList = null;
		}
		return SUCCESS;
	}
	
	 
    public static Map<String,Object> toMap(String jsonString) throws JSONException {

        JSONObject jsonObject = new JSONObject(jsonString);
        
        Map result = new HashMap();
        Iterator iterator = jsonObject.keys();
        String key = null;
        String value = null;
        
        while (iterator.hasNext()) {

            key = (String) iterator.next();
            value = jsonObject.getString(key);
            result.put(key, value);

        }
        return result;

    }
}
