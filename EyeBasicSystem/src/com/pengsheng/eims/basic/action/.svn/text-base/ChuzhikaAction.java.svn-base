package com.pengsheng.eims.basic.action;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.pengsheng.eims.basic.mgr.ChuzhikaMgr;
import com.pengsheng.eims.basic.persistence.ChuzhikaLogPo;
import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class ChuzhikaAction extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;
	private ChuzhikaMgr chuzhikaMgr;
	private ChuzhikaPo chuzhikaPo;
	private ChuzhikaLogPo chuzhikaLogPo;
	private List<ChuzhikaPo> chuzhikaPos;
	private List<ChuzhikaLogPo> chuzhikaLogPos;
	private SystemParameterMgr systemParameterMgr;
	private DepartmentsMgr departmentsMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private String savePath;
	private String fileName;
	private String contentType;
	private InputStream inputStream;
	
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

	public String initChuzhikaSel() throws Exception{
		
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
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpisalldepartments("all");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		List<DepartmentsPo> departmentsList = departmentsMgr.getDepartments(deppo);
		request.setAttribute("departmentsList",departmentsList);
		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "chuzhikas";
		}
		return SUCCESS;
	}
	
	public String initChuzhikaInsert() throws Exception{
		
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
		
		//取得登陆人允许操作的仓位&部门 Begin			
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpisalldepartments("all");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		List<DepartmentsPo> departmentsList = departmentsMgr.getDepartments(deppo);
		request.setAttribute("departmentsList",departmentsList);
		
		return SUCCESS;
	}
	
	public String initChuzhikaInserts() throws Exception{
		
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

		//取得登陆人允许操作的仓位&部门 Begin			
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpisalldepartments("all");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		List<DepartmentsPo> departmentsList = departmentsMgr.getDepartments(deppo);
		request.setAttribute("departmentsList",departmentsList);
		
		return SUCCESS;
	}
	
	public String chuzhikaInsert() throws Exception{
		
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

		chuzhikaPo.setCstczkcreatepersonid(personInfoPo.getId());
		
		int count = chuzhikaMgr.selectChuzhikCount(chuzhikaPo.getCstczkcardid());
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("1");    		// 表示状态
		logPo.setsLogContent("储值卡:" + chuzhikaPo.getCstczkcardid() + "新增!");
		
		if(count>0){
			this.clearMessages();
			this.addActionMessage("该卡号已被使用！");

			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return "NoRepeat";
		}else{
			chuzhikaMgr.insertChuzhika(chuzhikaPo,logPo);
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		
	}
	
	public String chuzhikaInserts() throws Exception{
		
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
		
		String cstczkid1 = Utility.getName(request.getParameter("cstczkid1"));  //批号
		String cstczkid2_tmp = Utility.getName(request.getParameter("cstczkid2")).trim();		
		String lastNum = "";
		
		BigDecimal cstczkid2 = new BigDecimal(cstczkid2_tmp);
		BigDecimal cardnumber = new BigDecimal(Utility.getName(request.getParameter("cardnumber")).trim());		
		BigDecimal movenumber = new BigDecimal(0);//计数器
		BigDecimal area = new BigDecimal(1);//步长
		List<ChuzhikaPo> chuzhikaList = new ArrayList<ChuzhikaPo>();
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("储值卡批号:"+cstczkid1+"新增,共:"+cardnumber.toString()+"张！");
		
		String errorCard = "";//已经被使用的储值卡号
		String cardString = "";//用,号拼装储值卡号
		
		for(int i = 0; i < cardnumber.intValue(); i++){
			
			if(cardString.equals("")){
				cardString = (cstczkid1 + addZero(cstczkid2.add(movenumber).toString(),cstczkid2_tmp.length()));
			}else{
				cardString = cardString + "," + (cstczkid1 + addZero(cstczkid2.add(movenumber).toString(),cstczkid2_tmp.length()));
			}
			
			ChuzhikaPo po = new ChuzhikaPo();
			po.setCstczkcardid(cstczkid1 + addZero(cstczkid2.add(movenumber).toString(),cstczkid2_tmp.length()));
			lastNum = addZero(cstczkid2.add(movenumber).toString(),cstczkid2_tmp.length());
			
			po.setCstczkshifujine(Utility.getName(chuzhikaPo.getCstczkshifujine()));
			po.setCstczkzengsongjine(Utility.getName(chuzhikaPo.getCstczkzengsongjine()));
			po.setCstczkjine(Utility.getName(chuzhikaPo.getCstczkjine()));
            po.setCstczkremark(Utility.getName(chuzhikaPo.getCstczkremark()));
            po.setCstczkcardpassword(Utility.getName(chuzhikaPo.getCstczkcardpassword()));
            po.setCstczkcreatepersonid(createPerson);
            po.setCstczkshopcode(chuzhikaPo.getCstczkshopcode());
			chuzhikaList.add(po);
			movenumber = movenumber.add(area);
		}
		
		List<ChuzhikaPo> IsExistChuzhikaList = new ArrayList<ChuzhikaPo>();
		IsExistChuzhikaList = chuzhikaMgr.getChuzhikaListIsExist(cardString);
		
		Iterator<ChuzhikaPo> it = IsExistChuzhikaList.iterator();
		while(it.hasNext()){
			errorCard = errorCard + it.next().getCstczkcardid() + "\\n";
		}
		
		this.clearMessages();
		
		if (errorCard.length() == 0){
			chuzhikaMgr.insertBatchChuzhika(chuzhikaList,logPo);
			this.addActionMessage(getText("从卡号:" + cstczkid1 + cstczkid2_tmp + " 至 " + cstczkid1 + lastNum + "\\n新增成功!"));
		}else{
			request.setAttribute("cstczkid1", cstczkid1);
			request.setAttribute("cstczkid2", cstczkid2_tmp);
			request.setAttribute("cardnumber", cardnumber);
			this.addActionMessage(getText("由于以下储值卡号码已经在系统中使用：\\n"+errorCard+"新增失败！!"));
			

			//取得登陆人允许操作的仓位&部门 Begin			
			DepartmentsPo deppo=new DepartmentsPo();
			deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
			deppo.setBdptype(personInfoPo.getDepartmenttype());
			deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
			deppo.setBdpisalldepartments("all");
			if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
				deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
			}
			
			List<DepartmentsPo> departmentsList = departmentsMgr.getDepartments(deppo);
			request.setAttribute("departmentsList",departmentsList);
			
			return "NoRepeat";
		}
		
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;		
	}
	
	private String addZero(String str,int size){
		
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < (size-str.length()); i++){
			buffer.append("0");
		}
		
		return buffer.toString() + str;
	}
	
	public String chuzhikaSel() throws Exception{
		
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
		
		
		String cstczkcustomerid = Utility.getName(request.getParameter("cstczkcustomerid"));
		String jiankaEndDate = Utility.getName(request.getParameter("jiankaEndDate"));
		String jiankaStartDate = Utility.getName(request.getParameter("jiankaStartDate"));
		String jiankarenxingming = Utility.getName(request.getParameter("jiankarenxingming"));
		String jiankarenid = Utility.getName(request.getParameter("jiankarenid"));
		String cstczkcardid = Utility.getName(request.getParameter("cstczkcardid"));
		String cstczkcustomername = Utility.getName(request.getParameter("cstczkcustomername"));
		String cstczkcustomername1 = Utility.getName(request.getParameter("cstczkcustomername1"));
		String cstczkidcard = Utility.getName(request.getParameter("cstczkidcard"));
		String cstczkshopcode = Utility.getName(request.getParameter("cstczkshopcode"));
		
		ChuzhikaPo po = new ChuzhikaPo();
		
		po.setCstczkcustomerid(cstczkcustomerid);
		po.setCstczkcustomername(cstczkcustomername);
		po.setPage_createdate_begin(jiankaStartDate);
		po.setPage_createdate_end(jiankaEndDate);
		po.setCstczkcreatepersonname(jiankarenxingming);
		po.setCstczkcreatepersonid(jiankarenid);
		po.setCstczkcardid(cstczkcardid);
		po.setCstczkidcard(cstczkidcard);
		po.setCstczkshopcode(cstczkshopcode);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setCstczkcompanyid(personInfoPo.getPersoncompanyid());
		}
		
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
		
		
		int count=chuzhikaMgr.selectChuzhikasCount(po);
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
	    chuzhikaPos=chuzhikaMgr.selectChuzhikas(po,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			chuzhikaPos = null;
		}
		
		request.setAttribute("cstczkcardid", cstczkcardid);
		request.setAttribute("cstczkcustomername", cstczkcustomername);
		request.setAttribute("cstczkcustomername1", cstczkcustomername1);
		request.setAttribute("cstczkidcard", cstczkidcard);
		request.setAttribute("cstczkcustomerid", cstczkcustomerid);
		request.setAttribute("jiankaEndDate", jiankaEndDate);
		request.setAttribute("jiankaStartDate", jiankaStartDate);
		request.setAttribute("jiankarenxingming", jiankarenxingming);
		request.setAttribute("jiankarenid", jiankarenid);
		request.setAttribute("cstczkshopcode", cstczkshopcode);
		
		//取得登陆人允许操作的仓位&部门 Begin			
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpisalldepartments("all");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		List<DepartmentsPo> departmentsList = departmentsMgr.getDepartments(deppo);
		request.setAttribute("departmentsList",departmentsList);
		
		return SUCCESS;
	}
	
	public String initChuzhikaUpdate() throws Exception{
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
		String id = Utility.getName(request.getParameter("id"));
		
		chuzhikaPo = new ChuzhikaPo();
		chuzhikaPo.setCstczkid(id);		
		chuzhikaPo = chuzhikaMgr.selectChuzhika(chuzhikaPo);
		
		return SUCCESS;
	}
	
	public String chuzhikaUpdate() throws Exception{
		
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
	
		BigDecimal jine=new BigDecimal(Utility.getNameNum(chuzhikaLogPo.getSmeasyintegral())); 
		BigDecimal cjine=new BigDecimal(Utility.getNameNum(chuzhikaLogPo.getSmeascintegral())); 
		BigDecimal salary=jine.add(cjine); 

		chuzhikaLogPo.setSmeasxintegral(salary+"");
		chuzhikaLogPo.setSmeasdopersonid(personInfoPo.getId());
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("3");    		// 表示状态
		logPo.setsLogContent("储值卡:" + chuzhikaLogPo.getSmeaschuzhikaid() + "充值!");
		
		chuzhikaMgr.updateChuzhikaChongzhi(chuzhikaLogPo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public String initChuzhikaUpdate2() throws Exception{
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
		String bid = Utility.getName(request.getParameter("bid"));
		
		ChuzhikaPo po = new ChuzhikaPo();
		po.setCstczkid(bid);
		
		chuzhikaPo = chuzhikaMgr.selectChuzhika(po);
		
		//取得登陆人允许操作的仓位&部门 Begin			
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpisalldepartments("all");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		List<DepartmentsPo> departmentsList = departmentsMgr.getDepartments(deppo);
		request.setAttribute("departmentsList",departmentsList);
		
		return SUCCESS;
	}
	
	public String chuzhikaUpdate2() throws Exception{
		
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("3");    		// 表示状态
		logPo.setsLogContent("储值卡:" + chuzhikaPo.getCstczkid() + "更新!");
		
		//一个会员只能绑定一张储值卡，暂时屏蔽此功能；
//		if(!chuzhikaPo.getCstczkcustomerid().equals("")){
//			int count = chuzhikaMgr.selectCustomerCzkCount(chuzhikaPo.getCstczkid(), chuzhikaPo.getCstczkcustomerid());
//			if(count>0){
//				this.clearMessages();
//				this.addActionMessage("该会员已经绑定了储值卡！");
//
//				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
//				return "NoRepeat";
//			}
//		}
		
		chuzhikaMgr.updateChuzhika(chuzhikaPo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	public String initChuzhikaUpdate3() throws Exception{
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
		String bid = Utility.getName(request.getParameter("bid"));
		String isShowHide=Utility.getName(request.getParameter("isShowHide"));
		
		ChuzhikaPo po = new ChuzhikaPo();
		po.setCstczkid(bid);
		
		chuzhikaPo = chuzhikaMgr.selectChuzhika(po);
		
		request.setAttribute("isShowHide", isShowHide);
		return SUCCESS;
	}
	
	public String chuzhikaUpdate3() throws Exception{
		
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
		String bid = Utility.getName(request.getParameter("bid"));
		String isShowHide=Utility.getName(request.getParameter("isShowHide"));
		chuzhikaPo=new ChuzhikaPo();
		chuzhikaPo.setCstczkid(bid);
		chuzhikaPo.setCstshowandhie(isShowHide);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("3");    		// 表示状态
		if(request.getParameter("isShowHide").equals("1")){
			logPo.setsLogContent("储值卡:" + chuzhikaPo.getCstczkid() + "停用!");
		}else{
			logPo.setsLogContent("储值卡:" + chuzhikaPo.getCstczkid() + "启用!");
		}
		
		chuzhikaMgr.updateChuzhikaIsShowHide(chuzhikaPo, logPo);
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
		return SUCCESS;
		
	}
	
	public String initChuzhikaDel() throws Exception{
		
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
		String id = Utility.getName(request.getParameter("id"));
		chuzhikaPo=new ChuzhikaPo();
		chuzhikaPo.setCstczkid(id);
		chuzhikaPo = chuzhikaMgr.selectChuzhika(chuzhikaPo);
		
		return SUCCESS;
	}
	
	
	public String chuzhikaDel() throws Exception{
		
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
		String id = Utility.getName(request.getParameter("id"));
		request.setAttribute("id", id);
		ChuzhikaPo po = new ChuzhikaPo();
		po.setCstczkid(id);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("2");    		// 表示状态
		logPo.setsLogContent("储值卡:" + id + "删除!");
		
		chuzhikaMgr.deleteChuzhika(po,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));

		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化批量删除
	 */
	public String initChuzhikaDeleteBatch() throws Exception {
		
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
		
		String hid = Utility.getName(request.getParameter("hid"));
		
		request.setAttribute("hid",hid);
		
		return SUCCESS;
	}
	
	/**
	 * 批量删除
	 */
	public String deleteChuzhikaBatch() throws Exception {
		
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
				
		String hid = Utility.getName(request.getParameter("hid"));

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("38");    // 表示状态
		logPo.setsLogContent("储值卡批量删除！");

		chuzhikaMgr.deleteChuzhikaBatch(hid, logPo);

		this.clearMessages();
		this.addActionMessage("储值卡批量删除成功!");
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public String initChuzhikaDetails() throws Exception{
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
		String id = Utility.getName(request.getParameter("id"));
		
		ChuzhikaPo po = new ChuzhikaPo();
		
		po.setCstczkid(id);
		
		chuzhikaPo = chuzhikaMgr.selectChuzhika(po);
		
		chuzhikaLogPos = chuzhikaMgr.selectChuzhikaLogs(id);
		
		return SUCCESS;
	}
	
	public String initReplaceChuzhika() throws Exception {
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
		
		ChuzhikaPo po = new ChuzhikaPo();
		
		String chuzhikaid = Utility.getName(request.getParameter("chuzhikaid"));
		String cstczkcardpassword = Utility.getName(request.getParameter("cstczkcardpassword"));
		
		po.setCstczkid(chuzhikaid);
		
		chuzhikaPo = chuzhikaMgr.selectChuzhika(po);
		
		ChuzhikaPo po1 = new ChuzhikaPo();
		ChuzhikaPo newpo = new ChuzhikaPo();
		
		po1.setCstczkid(chuzhikaid);
		po1.setCstczkcardpassword(cstczkcardpassword);
		
		request.setAttribute("cstczkcardpassword", cstczkcardpassword);
		request.setAttribute("chuzhikaid", chuzhikaid);
		
		if("".equals(Utility.getName(chuzhikaPo.getCstczkcardpassword()))){
			request.setAttribute("pwd","0");
		}else{
			request.setAttribute("pwd","1");
		}
		
		if(!"".equals(cstczkcardpassword)){
			newpo = chuzhikaMgr.selectChuzhika(po1);
			if("".equals(Utility.getName(newpo.getCstczkid()))){
				this.clearMessages();
				this.addActionMessage("密码错误！");
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			}else{
				request.setAttribute("login","1");
			}
		}
		
		return SUCCESS;
	}
	
	public String replaceChuzhika() throws Exception {
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
		
		ChuzhikaPo po = new ChuzhikaPo();
		
//		String chuzhikaid = Utility.getName(request.getParameter("chuzhikaid"));
//		String cstczkcardpassword = Utility.getName(request.getParameter("cstczkcardpassword"));
//		String cstczknewid = Utility.getName(request.getParameter("cstczknewid"));
//		String cstczkcardnewpassword = Utility.getName(request.getParameter("cstczkcardnewpassword"));
//		
//		po.setCstczkid(chuzhikaid);
//		po.setCstczkcardpassword(cstczkcardpassword);
//		po.setCstczknewid(cstczknewid);
//		po.setCstczkcardnewpassword(cstczkcardnewpassword);
//		
//		chuzhikaPo = chuzhikaMgr.selectChuzhika(po);
//		
//		request.setAttribute("chuzhikaid", chuzhikaid);
//		
//		ChuzhikaPo newpo = new ChuzhikaPo();
//		ChuzhikaPo po1 = new ChuzhikaPo();
//		
//		po1.setCstczkid(cstczknewid);
//		
//		newpo = chuzhikaMgr.selectChuzhika(po1);
//		
//		if("".equals(Utility.getName(chuzhikaPo.getCstczkcardpassword()))){
//			request.setAttribute("pwd","0");
//		}else{
//			request.setAttribute("pwd","1");
//		}
//		
//		if(!"".equals(Utility.getName(newpo.getCstczkid()))){
//			this.clearMessages();
//			this.addActionMessage("更换卡已被使用！");
//			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
//			return "error";
//		}else if("".equals(Utility.getName(chuzhikaPo.getCstczkid()))){
//			this.clearMessages();
//			this.addActionMessage("密码错误！");
//			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
//			return "error";
//		}else{
//			LogisticsLogPo logPo = new LogisticsLogPo();
//			logPo.setsLogName(createPerson);
//			logPo.setsLogIP(request.getRemoteAddr());
//			logPo.setsLogResult(moduleID); // 表示模块名称 
//			logPo.setsLogOpID("1");    // 表示状态
//			logPo.setsLogContent("储值卡："+chuzhikaid+"更换！");
//			
//			chuzhikaMgr.updateChuzhikaID(po, logPo);
//			
//			this.clearMessages();
//			this.addActionMessage("更换成功！");
//			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
//			return SUCCESS;
//		}
		
		return SUCCESS;
	}
	
	/**
	 * 导出储值卡号
	 * 
	 * @return
	 * @throws Exception
	 */
	public String exportChuzhiCard() throws Exception {
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
		
		setFileName(java.net.URLEncoder.encode("储值卡号.xls", "UTF-8"));
		
		String cstczkcustomerid = Utility.getName(request.getParameter("cstczkcustomerid"));
		String jiankaEndDate = Utility.getName(request.getParameter("jiankaEndDate"));
		String jiankaStartDate = Utility.getName(request.getParameter("jiankaStartDate"));
		String jiankarenxingming = Utility.getName(request.getParameter("jiankarenxingming"));
		String jiankarenid = Utility.getName(request.getParameter("jiankarenid"));
		String cstczkcardid = Utility.getName(request.getParameter("cstczkcardid"));
		String cstczkcustomername = Utility.getName(request.getParameter("cstczkcustomername"));
		String cstczkidcard = Utility.getName(request.getParameter("cstczkidcard"));
		String cstczkshopcode = Utility.getName(request.getParameter("cstczkshopcode"));
		
		ChuzhikaPo po = new ChuzhikaPo();
		
		po.setCstczkcustomerid(cstczkcustomerid);
		po.setCstczkcustomername(cstczkcustomername);
		po.setPage_createdate_begin(jiankaStartDate);
		po.setPage_createdate_end(jiankaEndDate);
		po.setCstczkcreatepersonname(jiankarenxingming);
		po.setCstczkcreatepersonid(jiankarenid);
		po.setCstczkcardid(cstczkcardid);
		po.setCstczkidcard(cstczkidcard);
		po.setCstczkshopcode(cstczkshopcode);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setCstczkcompanyid(personInfoPo.getPersoncompanyid());
		}
		
		try {
			inputStream = chuzhikaMgr.insertExportExcel(po);
		} catch (Exception e) {
			System.out.println("储值卡号导出失败：" + e.getMessage());
		}
			
		return SUCCESS;
	}
	
	public String initChuzhikaEnable() throws Exception{
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
		
		chuzhikaPo = new ChuzhikaPo();
		chuzhikaPo.setCstshowandhie(Utility.getName(request.getParameter("id")));		
		
		return SUCCESS;
	}
	
	public String updateChuzhikaEnable() throws Exception{
		
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("3");    		// 表示状态
		if(Utility.getName(chuzhikaPo.getCstshowandhie()).equals("1")){
			logPo.setsLogContent("储值卡:" + Utility.getName(chuzhikaPo.getCstczkid()) + "停用!");
		}else{
			logPo.setsLogContent("储值卡:" + Utility.getName(chuzhikaPo.getCstczkid()) + "启用!");
		}
		
		chuzhikaMgr.updateChuzhikaEnableBatch(chuzhikaPo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public ChuzhikaMgr getChuzhikaMgr() {
		return chuzhikaMgr;
	}

	public void setChuzhikaMgr(ChuzhikaMgr chuzhikaMgr) {
		this.chuzhikaMgr = chuzhikaMgr;
	}

	public ChuzhikaPo getChuzhikaPo() {
		return chuzhikaPo;
	}

	public void setChuzhikaPo(ChuzhikaPo chuzhikaPo) {
		this.chuzhikaPo = chuzhikaPo;
	}

	public ChuzhikaLogPo getChuzhikaLogPo() {
		return chuzhikaLogPo;
	}

	public void setChuzhikaLogPo(ChuzhikaLogPo chuzhikaLogPo) {
		this.chuzhikaLogPo = chuzhikaLogPo;
	}
	
	public List<ChuzhikaPo> getChuzhikaPos() {
		return chuzhikaPos;
	}

	public void setChuzhikaPos(List<ChuzhikaPo> chuzhikaPos) {
		this.chuzhikaPos = chuzhikaPos;
	}

	public List<ChuzhikaLogPo> getChuzhikaLogPos() {
		return chuzhikaLogPos;
	}

	public void setChuzhikaLogPos(List<ChuzhikaLogPo> chuzhikaLogPos) {
		this.chuzhikaLogPos = chuzhikaLogPos;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}
	
}
