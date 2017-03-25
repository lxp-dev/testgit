package com.pengsheng.eims.basic.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.pengsheng.eims.basic.mgr.ContractMgr;
import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.persistence.ContractPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class ContractAction extends BaseAction {

	private PersonPermissionMgr personPermissionMgr;
	
	private ContractMgr contractMgr;
	
	private SupplierMgr supplierMgr;
	
	private ContractPo contractPo;
	
	private List<ContractPo> contractList;

	// 用File数组来封装多个上传文件域对象
	private File[] upload;

	// 用String数组来封装多个上传文件类型
	private String[] uploadContentType;

	// 用String数组来封装多个上传文件名
	private String[] uploadFileName;

	// 保存文件的目录路径(通过依赖注入)
	private String savePath;

	// 文件标题
	private String fileName;

	// 文件类型
	private String contentType;

	private InputStream inputStream;
	
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	
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
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public ContractMgr getContractMgr() {
		return contractMgr;
	}

	public void setContractMgr(ContractMgr contractMgr) {
		this.contractMgr = contractMgr;
	}

	public ContractPo getContractPo() {
		return contractPo;
	}

	public void setContractPo(ContractPo contractPo) {
		this.contractPo = contractPo;
	}

	public List<ContractPo> getContractList() {
		return contractList;
	}

	public void setContractList(List<ContractPo> contractList) {
		this.contractList = contractList;
	}

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
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

	// 对于配置中的 ${fileName}, 获得下载保存时的文件名
	public String getFileName() throws Exception {
		return new String(fileName.getBytes(), "ISO8859-1");
		// return fileName;
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

	// 获得下载文件的内容，可以直接读入一个物理文件或从数据库中获取内容
	public InputStream getInputStream() throws Exception {
		return inputStream;
	}

//	/**
//	 * 初始化制造商合同查询
//	 */
//	public String initContractSel() throws Exception {
//		
//		/** ********************** 权限设置 ***************************** */
//		String moduleID = Utility.getName(request.getParameter("moduleID"));
//		request.setAttribute("moduleID", moduleID);
//		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
//		String createPerson = personInfoPo.getId();
//
//		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
//		personPermissionPo.setApplicationID("1");
//		personPermissionPo.setModuleID(moduleID);
//		personPermissionPo.setPersonID(createPerson);
//
//		PersonPermissionPo permissionPo = personPermissionMgr
//				.getPersonPermission(personPermissionPo);// 模块权限获取
//
//		request.setAttribute("permissionPo", permissionPo);
//		/** ********************** 权限设置 ***************************** */
//		
//		String id = Utility.getName(request.getParameter("hid"));
//		
//		request.setAttribute("hid", id);
//		
//		String flag = Utility.getName(request.getParameter("flag"));
//		
//		request.setAttribute("flag", flag);
//		
//		return SUCCESS;
//	}

	/**
	 * 查询制造商
	 */
	public String selContract() throws Exception {
		
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

		String id = Utility.getName(request.getParameter("hid"));		
		request.setAttribute("hid", id);		
		String flag = Utility.getName(request.getParameter("flag"));		
		request.setAttribute("flag", flag);
		
		SupplierPo tpo = new SupplierPo();
		tpo.setBspid(id);
		SupplierPo supplierPo = supplierMgr.getSupplier(tpo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		request.setAttribute("supplierPo", supplierPo);
		
		contractPo = new ContractPo();
		contractPo.setBctsupplierid(id);
		int count = contractMgr.getContractCount(contractPo);
		
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
			contractList = contractMgr.getContractList(contractPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			contractList = null;
		}

		return SUCCESS;
	}

	/**
	 * 初始化制造商合同新增
	 */
	public String initContractInsert() throws Exception {
		
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

		String supplierID = Utility.getName(request.getParameter("hid"));
		request.setAttribute("hid",supplierID);
		
		return SUCCESS;
	}

	/**
	 * 新增制造商合同
	 */
	public String insertContract() throws Exception {
		
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("1");    		// 表示状态
		logPo.setsLogContent("制造商合同:" + contractPo.getBctcontracttitle() + "新增!");
					
		String supplierID = Utility.getName(request.getParameter("hid"));
		contractPo.setBctsupplierid(supplierID);
		
		contractMgr.insertContract(contractPo, createPerson, upload,ServletActionContext.getServletContext().getRealPath(this.getSavePath()), this.getUploadFileName(), this.getUploadContentType(), logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	* Description :查询某一制造商合同的详细信息
	* @return :制造商合同详情页面
	*/
	public String contractDetail() throws Exception {

		String bctid = Utility.getName(request.getParameter("hid"));

		contractPo = new ContractPo();

		contractPo.setBctid(bctid);
		contractPo = contractMgr.getContract(contractPo);

		File file = new File(ServletActionContext.getServletContext().getRealPath(this.getSavePath()) + File.separator + contractPo.getDocumentUrl());
		if (file.exists() && file.isFile()){
			contractPo.setDocumentUrl((this.getSavePath() + File.separator + contractPo.getDocumentUrl()).replace("\\", "/"));
		}else{
			contractPo.setDocumentUrl("");
		}
		
		return SUCCESS;
	}

	/**
	* Description :下载合同附件
	* @return :下载弹窗
	*/
	public String downloadDoc() throws Exception {

		String bctid = Utility.getName(request.getParameter("bctid"));

		contractPo = new ContractPo();

		contractPo.setBctid(bctid);
		contractPo = contractMgr.getContract(contractPo);

		fileName = contractPo.getSaveFileName();

		this.contentType = contractPo.getContentType();

		inputStream = new FileInputStream(ServletActionContext.getServletContext().getRealPath(this.getSavePath()) + File.separator + contractPo.getDocumentUrl());

		return SUCCESS;
	}

	/**
	 * 初始化制造商合同修改
	 */
	public String initContractUpdate() throws Exception {
		
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
		
		String bctid = Utility.getName(request.getParameter("hid"));

		contractPo = new ContractPo();

		contractPo.setBctid(bctid);
		contractPo = contractMgr.getContract(contractPo);

		return SUCCESS;
	}

	/**
	 * 修改制造商合同
	 * 
	 */
	public String updateContract() throws Exception {
		
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
		logPo.setsLogContent("制造商合同:" + contractPo.getBctcontracttitle() + "修改!");
		
		contractMgr.updateContract(contractPo, createPerson, upload,ServletActionContext.getServletContext().getRealPath(this.getSavePath()), this.getUploadFileName(), this.getUploadContentType(), logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

	/**
	 * 初始化制造商合同删除
	 */
	public String initContractDelete() throws Exception {
		
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

		String bctid = Utility.getName(request.getParameter("hid"));

		contractPo = new ContractPo();

		contractPo.setBctid(bctid);
		contractPo = contractMgr.getContract(contractPo);

		return SUCCESS;
	}

	/**
	 * 删除制造商合同
	 */
	public String deleteContract() throws Exception {
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

		String bctid = Utility.getName(request.getParameter("hid"));

		contractPo = new ContractPo();

		contractPo.setBctid(bctid);
		contractPo = contractMgr.getContract(contractPo);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("2");    		// 表示状态
		logPo.setsLogContent("制造商合同:" + contractPo.getBctcontracttitle() + "删除!");
		
		contractMgr.deleteContract(contractPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	public SupplierMgr getSupplierMgr() {
		return supplierMgr;
	}

	public void setSupplierMgr(SupplierMgr supplierMgr) {
		this.supplierMgr = supplierMgr;
	}

}
