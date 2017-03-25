package com.pengsheng.eims.basic.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.pengsheng.eims.basic.mgr.TrainingCoursesMgr;
import com.pengsheng.eims.basic.persistence.TrainingCoursesPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class TrainingCoursesAction extends BaseAction implements ServletRequestAware,
		SessionAware {
	
	private PersonPermissionMgr personPermissionMgr;
	private TrainingCoursesPo trainingCoursesPo;
	private List<TrainingCoursesPo> trainingCoursesList;
	private TrainingCoursesMgr trainingCoursesMgr;
	private File[] upload;	
	private String savePath;
	private String[] uploadFileName;
	private String[] uploadContentType;
	private InputStream inputStream;
	private String fileName;
	private String contentType;
	public static final String UTF_8 = "UTF-8";
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

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public TrainingCoursesMgr getTrainingCoursesMgr() {
		return trainingCoursesMgr;
	}

	public void setTrainingCoursesMgr(TrainingCoursesMgr trainingCoursesMgr) {
		this.trainingCoursesMgr = trainingCoursesMgr;
	}

	public List<TrainingCoursesPo> getTrainingCoursesList() {
		return trainingCoursesList;
	}

	public void setTrainingCoursesList(List<TrainingCoursesPo> trainingCoursesList) {
		this.trainingCoursesList = trainingCoursesList;
	}

	public TrainingCoursesPo getTrainingCoursesPo() {
		return trainingCoursesPo;
	}

	public void setTrainingCoursesPo(TrainingCoursesPo trainingCoursesPo) {
		this.trainingCoursesPo = trainingCoursesPo;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public String initTrainingCoursesSel(){

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
		
		request.setAttribute("verification", 0);
		return SUCCESS;
	}
	public String initTrainingCoursesSels(){

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
		request.setAttribute("verification", 1);
		return SUCCESS;
	}
	public String selectTrainingCourses(){

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
		int count = trainingCoursesMgr.getTrainingCoursesCount(trainingCoursesPo);

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
					perPage = 10;
				}
			} else {
				perPage = 10;
			}
			Pagination page = new Pagination(request, count, perPage);
			request.setAttribute("verification", 0);
			trainingCoursesList = trainingCoursesMgr.selectTrainingCoursesList(trainingCoursesPo, page
					.getStart(), page.getPageSize());
			
		
			request.setAttribute(Pagination.PAGINATION, page);
		}

		return SUCCESS;
	}
	public String selectTrainingCoursess(){
		
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

		trainingCoursesPo.setKprpersonid(personInfoPo.getId());
		trainingCoursesPo.setKprroleid(personInfoPo.getRoleid());
		int count = trainingCoursesMgr.getTrainingCoursesCount(trainingCoursesPo);
		
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
					perPage = 10;
				}
			} else {
				perPage = 10;
			}
			Pagination page = new Pagination(request, count, perPage);
			trainingCoursesList = trainingCoursesMgr.selectTrainingCoursesList(trainingCoursesPo, page
					.getStart(), page.getPageSize());
			
			
			request.setAttribute(Pagination.PAGINATION, page);
		}
		request.setAttribute("verification", 1);
		
		return SUCCESS;
	}
	
	public String initTrainingCoursesInsert(){
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
	
	public String insertTrainingCourses(){
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
		
		trainingCoursesPo.setKprroleid(request.getParameter("rolID"));
		trainingCoursesPo.setKprpersonid(request.getParameter("perID"));
		trainingCoursesPo.setKjbcreaseperson(personInfoPo.getId());
		trainingCoursesPo.setKjbdepartmentsid(personInfoPo.getDepartmentID());
		trainingCoursesMgr.insertTrainingCourses(trainingCoursesPo,upload,ServletActionContext.getServletContext().getRealPath(this.getSavePath()), this.getUploadFileName(), this.getUploadContentType());
		
		this.clearMessages();
		this.addActionMessage(getText("新增成功!"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	public String initTrainingCoursesUpdate(){
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
		String hid = Utility.getName(request.getParameter("hid")).trim();
		request.setAttribute("hid",hid);
		trainingCoursesPo=new TrainingCoursesPo();
		trainingCoursesPo.setKprid(hid);
		trainingCoursesPo.setKjbid(hid);
		trainingCoursesList=trainingCoursesMgr.getTrainingCoursesPR(trainingCoursesPo);
		trainingCoursesPo=trainingCoursesMgr.getTrainingCoursesPo(trainingCoursesPo);
		String perID="";
		String perNAME="";
		String rolID="";
		String rolNAME="";
		for(TrainingCoursesPo trainingCoursesPo:trainingCoursesList){
			if(!"".equals(Utility.getName(trainingCoursesPo.getKprpersonid()))){
				perID=perID+","+trainingCoursesPo.getKprpersonid();
			}
			if(!"".equals(Utility.getName(trainingCoursesPo.getKprpersonname()))){
				perNAME=perNAME+","+trainingCoursesPo.getKprpersonname();
			}
			if(!"".equals(Utility.getName(trainingCoursesPo.getKprroleid()))){
				rolID=rolID+","+trainingCoursesPo.getKprroleid();
			}
			if(!"".equals(Utility.getName(trainingCoursesPo.getKprrolename()))){
				rolNAME=rolNAME+","+trainingCoursesPo.getKprrolename();
			}
		}
		request.setAttribute("perID", perID.substring(perID.indexOf(",")+1,perID.length()));
		request.setAttribute("perNAME", perNAME.substring(perID.indexOf(",")+1,perNAME.length()));
		request.setAttribute("rolID", rolID.substring(rolID.indexOf(",")+1,rolID.length()));
		request.setAttribute("rolNAME", rolNAME.substring(rolID.indexOf(",")+1,rolNAME.length()));
		return SUCCESS;
	}
	public String updateTrainingCourses(){
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
		String hid = Utility.getName(request.getParameter("hid")).trim();
		trainingCoursesPo=new TrainingCoursesPo();
		trainingCoursesPo.setKjbid(hid);
		trainingCoursesPo.setKprroleid(request.getParameter("rolID"));
		trainingCoursesPo.setKprpersonid(request.getParameter("perID"));
		trainingCoursesPo.setKjbcoursesname(request.getParameter("kjbcoursesname"));
		trainingCoursesPo.setKjbcoursescontent(request.getParameter("kjbcoursescontent"));
		trainingCoursesPo.setKjbspeechpersonname(request.getParameter("kjbspeechpersonname"));
		trainingCoursesMgr.insertTrainingCoursesPr(trainingCoursesPo);
		this.clearMessages();
		this.addActionMessage(getText("修改成功!"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	/**
	 * 下载附件
	 * 
	 * @return
	 * @throws Exception
	 */
	public String exportNoticeFile() throws Exception {
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
		String hid = Utility.getName(request.getParameter("hid")).trim();
		trainingCoursesPo=new TrainingCoursesPo();
		trainingCoursesPo.setKjbid(hid);
		TrainingCoursesPo po=new TrainingCoursesPo();
		po=trainingCoursesMgr.getTrainingCoursesPo(trainingCoursesPo);
		fileName = new String(po.getKjbtvname().getBytes(), "ISO8859-1");
		this.contentType = po.getKjbcontenttype();
		inputStream = new FileInputStream(ServletActionContext.getServletContext().getRealPath(this.getSavePath()) + File.separator + Utility.getName(po.getKjbtvurl()));
		return SUCCESS;
	}
	public void IsNoUplod() throws Exception{
		PrintWriter out;
		String message="0";
		String hid = Utility.getName(request.getParameter("hid")).trim();
		trainingCoursesPo=new TrainingCoursesPo();
		trainingCoursesPo.setKjbid(hid);
		TrainingCoursesPo po=new TrainingCoursesPo();
		po=trainingCoursesMgr.getTrainingCoursesPo(trainingCoursesPo);
		fileName = new String(po.getKjbtvname().getBytes(), "ISO8859-1");
		this.contentType = po.getKjbcontenttype();
		File f=new File(ServletActionContext.getServletContext().getRealPath(this.getSavePath()) + File.separator + Utility.getName(po.getKjbtvurl()));
		if(!f.exists()&&!f.isFile()){
			message="1";
		}
		out = response.getWriter();
		out.print(message);
		out.close();
	}
	public String initDeleteTrainingCourses(){
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
		String hid = Utility.getName(request.getParameter("hid")).trim();
		trainingCoursesPo=new TrainingCoursesPo();
		trainingCoursesPo.setKjbid(hid);
		trainingCoursesPo=trainingCoursesMgr.getTrainingCoursesPo(trainingCoursesPo);
		return SUCCESS;
	}
	public String deleteTrainingCourses(){
		
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
	String hid = Utility.getName(request.getParameter("hid")).trim();
	trainingCoursesPo=new TrainingCoursesPo();
	trainingCoursesPo.setKjbid(hid);
	trainingCoursesMgr.deleteTrainingCourses(trainingCoursesPo);
	this.clearMessages();
	this.addActionMessage(getText("删除成功!"));

	request.setAttribute("flag", GlobalConstants.OPENUPDATE);
	return SUCCESS;
	}
	
	
	public String initPriceListSel(){
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
		
		return SUCCESS;
	}
	
	public String priceListSel(){
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
		
		String startDate = Utility.getName(request.getParameter("startDate"));
		String endDate = Utility.getName(request.getParameter("endDate"));
		String jcontent = Utility.getName(request.getParameter("jcontent"));
		
		trainingCoursesPo = new TrainingCoursesPo();
		trainingCoursesPo.setStratDate(startDate);
		trainingCoursesPo.setEndDate(endDate);
		trainingCoursesPo.setKjbcoursescontent(jcontent);
		
		request.setAttribute("startDate",startDate);
		request.setAttribute("endDate",endDate);
		request.setAttribute("jcontent",jcontent);
		
		int count = trainingCoursesMgr.getPriceListCount(trainingCoursesPo);
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
					perPage = 10;
				}
			} else {
				perPage = 10;
			}
			Pagination page = new Pagination(request, count, perPage);
			trainingCoursesList = trainingCoursesMgr.selectPriceList(trainingCoursesPo, page.getStart(), page.getPageSize());			
			request.setAttribute(Pagination.PAGINATION, page);
		}
		
		return SUCCESS;
	}
	
	public String initPriceListInsert(){
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
		
		return SUCCESS;
	}
	
	public String insertPriceList(){
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

		trainingCoursesPo.setKjbcreaseperson(personInfoPo.getId());
		trainingCoursesPo.setKjbdepartmentsid(personInfoPo.getDepartmentID());
		
		trainingCoursesMgr.insertPriceList(trainingCoursesPo,upload,ServletActionContext.getServletContext().getRealPath(this.getSavePath()), this.getUploadFileName(), this.getUploadContentType());
		
		this.clearMessages();
		this.addActionMessage(getText("新增成功!"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public String exportPriceListFile() throws Exception {
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
		
		String hid = Utility.getName(request.getParameter("hid")).trim();
		trainingCoursesPo=new TrainingCoursesPo();
		trainingCoursesPo.setKjbid(hid);
		
		TrainingCoursesPo po=new TrainingCoursesPo();
		po=trainingCoursesMgr.getPriceListPo(trainingCoursesPo);

		fileName = new String(po.getKjbtvname().getBytes(), "ISO8859-1");
		this.contentType = po.getKjbcontenttype();
		inputStream = new FileInputStream(ServletActionContext.getServletContext().getRealPath(this.getSavePath()) + File.separator + Utility.getName(po.getKjbtvurl()));

		return SUCCESS;
	}
	
	public String initPriceListDelete(){
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
		
		String hid = Utility.getName(request.getParameter("hid")).trim();
		trainingCoursesPo=new TrainingCoursesPo();
		trainingCoursesPo.setKjbid(hid);
		
		trainingCoursesPo=trainingCoursesMgr.getPriceListPo(trainingCoursesPo);
		
		return SUCCESS;
	}
	
	public String deletePriceList(){
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
		
		String hid = Utility.getName(request.getParameter("hid")).trim();
		trainingCoursesPo=new TrainingCoursesPo();
		trainingCoursesPo.setKjbid(hid);
		
		trainingCoursesMgr.deletePriceList(trainingCoursesPo);
		
		this.clearMessages();
		this.addActionMessage(getText("删除成功!"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public String initPriceListUpdate(){
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
		
		String hid = Utility.getName(request.getParameter("hid")).trim();
		trainingCoursesPo=new TrainingCoursesPo();
		trainingCoursesPo.setKjbid(hid);
		
		trainingCoursesPo=trainingCoursesMgr.getPriceListPo(trainingCoursesPo);
		
		return SUCCESS;
	}
	
	public String updatePriceList(){
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
		
		String hid = Utility.getName(request.getParameter("hid")).trim();
		
		trainingCoursesPo=new TrainingCoursesPo();
		trainingCoursesPo.setKjbid(hid);
		trainingCoursesPo.setKjbcoursescontent(request.getParameter("kjbcoursescontent"));
		
		trainingCoursesMgr.updatePriceList(trainingCoursesPo);
		
		this.clearMessages();
		this.addActionMessage(getText("修改成功!"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public void IsNoPriceListUplod() throws Exception {
		PrintWriter out;
		String message="0";
		String hid = Utility.getName(request.getParameter("hid")).trim();
		
		trainingCoursesPo=new TrainingCoursesPo();
		trainingCoursesPo.setKjbid(hid);
		TrainingCoursesPo po=new TrainingCoursesPo();
		po=trainingCoursesMgr.getPriceListPo(trainingCoursesPo);
		
		fileName = new String(po.getKjbtvname().getBytes(), "ISO8859-1");
		this.contentType = po.getKjbcontenttype();
		File f=new File(ServletActionContext.getServletContext().getRealPath(this.getSavePath()) + File.separator + Utility.getName(po.getKjbtvurl()));
		if(!f.exists()&&!f.isFile()){
			message="1";
		}
		out = response.getWriter();
		out.print(message);
		out.close();
	}
	
}
