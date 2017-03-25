package com.pengsheng.eims.basic.action;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.pengsheng.eims.basic.mgr.GoodsImgLeaveMsgMgr;
import com.pengsheng.eims.basic.persistence.GoodsImgLeaveMsgPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class GoodsImgLeaveMsgAction extends BaseAction  {

	private PersonPermissionMgr personPermissionMgr;
	private GoodsImgLeaveMsgPo goodsImgLeaveMsgPo;
	private List<GoodsImgLeaveMsgPo> goodsImgLeaveMsgList;
	private List<GoodsImgLeaveMsgPo> goodsImgLeaveMsgWordList;
	private GoodsImgLeaveMsgMgr goodsImgLeaveMsgMgr;
	private File[] upload;
	private String savePath;
	private String[] uploadFileName;
	private String[] uploadContentType;
	
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
	public File[] getUpload() {
		return upload;
	}
	public void setUpload(File[] upload) {
		this.upload = upload;
	}
	public List<GoodsImgLeaveMsgPo> getGoodsImgLeaveMsgList() {
		return goodsImgLeaveMsgList;
	}
	public void setGoodsImgLeaveMsgList(
			List<GoodsImgLeaveMsgPo> goodsImgLeaveMsgList) {
		this.goodsImgLeaveMsgList = goodsImgLeaveMsgList;
	}
	public List<GoodsImgLeaveMsgPo> getGoodsImgLeaveMsgWordList() {
		return goodsImgLeaveMsgWordList;
	}
	public void setGoodsImgLeaveMsgWordList(
			List<GoodsImgLeaveMsgPo> goodsImgLeaveMsgWordList) {
		this.goodsImgLeaveMsgWordList = goodsImgLeaveMsgWordList;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public GoodsImgLeaveMsgPo getGoodsImgLeaveMsgPo() {
		return goodsImgLeaveMsgPo;
	}
	public void setGoodsImgLeaveMsgPo(GoodsImgLeaveMsgPo goodsImgLeaveMsgPo) {
		this.goodsImgLeaveMsgPo = goodsImgLeaveMsgPo;
	}
	public GoodsImgLeaveMsgMgr getGoodsImgLeaveMsgMgr() {
		return goodsImgLeaveMsgMgr;
	}
	public void setGoodsImgLeaveMsgMgr(GoodsImgLeaveMsgMgr goodsImgLeaveMsgMgr) {
		this.goodsImgLeaveMsgMgr = goodsImgLeaveMsgMgr;
	}
	
    /**
     * 初始化查询物资信息
     */	
	public String initGoodsImgLeaveMsgSel() throws Exception {
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
     * 查询物资信息
     */	
	public String selGoodsImgLeaveMsg() throws Exception {
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
		
		String startDate = Utility.getName(request.getParameter("startDate"));
		String endDate = Utility.getName(request.getParameter("endDate"));
		String lmstartDate = Utility.getName(request.getParameter("lmstartDate"));
		String lmendDate = Utility.getName(request.getParameter("lmendDate"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodsContent = Utility.getName(request.getParameter("goodsContent"));
		
		goodsImgLeaveMsgPo = new GoodsImgLeaveMsgPo();
		goodsImgLeaveMsgPo.setCmrlmstartdate(startDate);  // 上传起始时间
		goodsImgLeaveMsgPo.setCmrlmenddate(endDate);  // 上传截止时间		
		goodsImgLeaveMsgPo.setCmrlmestartdate(lmstartDate);  // 留言起始时间
		goodsImgLeaveMsgPo.setCmrlmeenddate(lmendDate);  // 留言截止时间
		goodsImgLeaveMsgPo.setCmrlmGoodsName(goodsName);  // 商品名称
		goodsImgLeaveMsgPo.setCmrlmGoodsContent(goodsContent);  // 商品简介
		
		request.setAttribute("startDate",startDate);
		request.setAttribute("endDate",endDate);
		request.setAttribute("lmstartDate",lmstartDate);
		request.setAttribute("lmendDate",lmendDate);
		request.setAttribute("goodsName",goodsName);
		request.setAttribute("goodsContent",goodsContent);
		
		int count = goodsImgLeaveMsgMgr.getGoodsImgLeaveMsgCount(goodsImgLeaveMsgPo);
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
			goodsImgLeaveMsgList = goodsImgLeaveMsgMgr.getGoodsImgLeaveMsgList(goodsImgLeaveMsgPo, page.getStart(), page.getPageSize());			
			request.setAttribute(Pagination.PAGINATION, page);
		}
		
		return SUCCESS;
	}

    /**
     * 初始化新增物资信息
     */	
	public String initGoodsImgLeaveMsgInsert() throws Exception {
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
     * 新增物资信息
     */	
	public String insertGoodsImgLeaveMsg() throws Exception {
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

		goodsImgLeaveMsgPo.setCmrlmpersonid(createPerson);
		goodsImgLeaveMsgPo.setCmrlmdepartmentid(personInfoPo.getDepartmentID());
		
		goodsImgLeaveMsgMgr.insertGoodsImgLeaveMsg(goodsImgLeaveMsgPo,upload,ServletActionContext.getServletContext().getRealPath(this.getSavePath()), this.getUploadFileName(), this.getUploadContentType());
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
    /**
     * 初始化修改物资信息
     */	
	public String initGoodsImgLeaveUpdate() throws Exception {
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
		
		goodsImgLeaveMsgPo = new GoodsImgLeaveMsgPo();
		goodsImgLeaveMsgPo.setCmrlmid(hid);
		
		goodsImgLeaveMsgPo = goodsImgLeaveMsgMgr.getGoodsImgLeaveMsgDetail(goodsImgLeaveMsgPo);
		
		return SUCCESS;
	}
	
    /**
     * 修改物资信息
     */	
	public String updateGoodsImgLeave() throws Exception {
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
		
		goodsImgLeaveMsgMgr.updateGoodsImgLeaveMsg(goodsImgLeaveMsgPo);		
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
    /**
     * 初始化删除物资信息
     */	
	public String initGoodsImgLeaveDelete() throws Exception {
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
		
		goodsImgLeaveMsgPo = new GoodsImgLeaveMsgPo();
		goodsImgLeaveMsgPo.setCmrlmid(hid);
		
		goodsImgLeaveMsgPo = goodsImgLeaveMsgMgr.getGoodsImgLeaveMsgDetail(goodsImgLeaveMsgPo);
		
		return SUCCESS;
	}
	
    /**
     * 删除物资信息
     */	
	public String deleteGoodsImgLeave() throws Exception {
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
		
		goodsImgLeaveMsgMgr.deleteGoodsImgLeaveMsg(goodsImgLeaveMsgPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
    /**
     * 初始化留言详细
     */	
	public String initGoodsImgLeaveDetail() throws Exception {
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
		String startdate = Utility.getName(request.getParameter("startdate")).trim();
		String enddate = Utility.getName(request.getParameter("enddate")).trim();
		
		goodsImgLeaveMsgPo = new GoodsImgLeaveMsgPo();
		goodsImgLeaveMsgPo.setCmrlmid(hid);
		goodsImgLeaveMsgPo.setCmrlmestartdate(startdate);
		goodsImgLeaveMsgPo.setCmrlmeenddate(enddate);		
		
		goodsImgLeaveMsgList = goodsImgLeaveMsgMgr.getGoodsImgLeaveMsgListDetail(goodsImgLeaveMsgPo);
		
		goodsImgLeaveMsgPo = goodsImgLeaveMsgMgr.getGoodsImgLeaveMsgDetail(goodsImgLeaveMsgPo);
		
		return SUCCESS;
	}
	
    /**
     * 初始化留言
     */	
	public String initGoodsImgLeaveMsgWord() throws Exception {
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
		
		goodsImgLeaveMsgPo = new GoodsImgLeaveMsgPo();
		goodsImgLeaveMsgPo.setCmrlmid(hid);
		
		goodsImgLeaveMsgPo = goodsImgLeaveMsgMgr.getGoodsImgLeaveMsgDetail(goodsImgLeaveMsgPo);
		
		return SUCCESS;
	}
	
    /**
     * 新增留言
     */	
	public String insertGoodsImgLeaveMsgWord() throws Exception {
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

		goodsImgLeaveMsgPo.setCmrlmepersonid(createPerson);
		goodsImgLeaveMsgPo.setCmrlmedepartmentid(personInfoPo.getDepartmentID());
		
		goodsImgLeaveMsgMgr.insertGoodsImgLeaveMsgWord(goodsImgLeaveMsgPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	
}
