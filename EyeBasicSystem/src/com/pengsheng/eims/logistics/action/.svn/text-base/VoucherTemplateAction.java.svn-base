/**
* 项目名称 : EIMS财务物流子系统
* 包 名          ：com.pengsheng.eims.logistics.action
* 文件名称 : VoucherTemplateAction.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2012-05-04
*/
package com.pengsheng.eims.logistics.action;

import java.io.File;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.pengsheng.eims.basic.mgr.InitSystemMgr;
import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.SubjectPo;
import com.pengsheng.eims.logistics.persistence.VoucherTempletPo;
import com.pengsheng.eims.logistics.persistence.VoucherTempletTempPo;
import com.pengsheng.eims.logistics.persistence.VoucherTypePo;
import com.pengsheng.eims.logistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.mgr.VoucherMgr;
import com.pengsheng.eims.logistics.mgr.VoucherTemplateMgr;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.ExportAmountLogPo;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.FuctionTreeNode;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class VoucherTemplateAction extends BaseAction {
	
	private VoucherTemplateMgr voucherTemplateMgr = null;
	private LogisticsLogMgr logisticsLogMgr = null;             //日志接口
	private PersonPermissionMgr personPermissionMgr = null;	
	private SubjectPo subjectPo = null;
	private List<SubjectPo> subjectList = null;
	private List<GoodsCategoryPo> goodsCategorys = null;
	private VarietyMgr varietyMgr = null;
	private List<GoodsInfoPo> goodsInfoList = null;
	private List<BrandPo> brandList = null;
	private GoodsInfoPo goodsInfoPo = null;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private List<FuctionTreeNode> menusList;
	private VoucherMgr voucherMgr = null;
	private List<VoucherTypePo> voucherTopIDList = null;        //凭证基本类型列表
	private List<VoucherTypePo> voucherSubsetIDList = null;     //凭证基本具体列表
	private File myFile;
	private File[] upload;
	private String[] uploadContentType;
	private String[] uploadFileName;
	private String savePath;
	private String fileName;
	private String contentType;
	private InputStream inputStream;
	private VoucherTempletTempPo voucherTempletTempPo = null;
	private List<VoucherTempletPo> voucherTempletList = null;
	private ReportQuartzMgr reportQuartzMgr;
	private DepartmentsMgr departmentsMgr;
	private CompanyNameMgr companyNameMgr;
	private List<CompanyNamePo> companyNamePos;
	private FquartzSwitchPo fquartzSwitchPo;
	private List<ExportAmountLogPo> ealpList = null; 
	private InitSystemMgr initSystemMgr = null;
	private String fileTemplet;
	
	/**
	 * Description：初始化查询科目
	 */
	public String initSubjectSel() throws Exception {
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
		/** ********************** 权限设置 ******************************/
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selSubjectSet";
		}
		
		return SUCCESS;
	}
		
	/**
	 * Description：初始化新增科目
	 */
	public String initSubjectInsert() throws Exception {	

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
		/** ********************** 权限设置 ******************************/
		
		String parentSubjectName = Utility.getName(request.getParameter("parentSubjectName"));
		String parentSubjectID = Utility.getName(request.getParameter("parentSubjectID")); 
		String parentID = Utility.getName(request.getParameter("parentID")); 
		String parent = Utility.getName(request.getParameter("parent")); 
		request.setAttribute("parentSubjectName" , parentSubjectName);
		request.setAttribute("parentSubjectID" , parentSubjectID);
		request.setAttribute("parentID" , parentID);
		request.setAttribute("parent" , parent);
		return SUCCESS;
	}
	
	/**
	 * Description：新增科目
	 */
	public String insertSubject() throws Exception {	

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
		/** ********************** 权限设置 ******************************/
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("科目：" + Utility.getName(subjectPo.getsLssSubjectID()+"新增!"));

		request.setAttribute("parentSubjectName",Utility.getName(request.getParameter("parentSubjectName")));
		request.setAttribute("parentID",Utility.getName(request.getParameter("parentID")));
		String parent=Utility.getName(request.getParameter("parent"));
//		System.out.println(parent+"########");
		int count = voucherTemplateMgr.isExistsSubject(subjectPo);
		if (count == 0){
			voucherTemplateMgr.insertSubject(subjectPo,logPo);
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			if(parent.equals("1"))
			{
				request.setAttribute("flag",GlobalConstants.OPENUPDATE9);
			}else
			{
				request.setAttribute("flag",GlobalConstants.OPENUPDATE7);
			}
			
			
			return SUCCESS;
		}else{
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.repeat"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}	
		
		
	}
	
	/**
	 * Description：查询科目
	 */
	public String selSubjectSet() throws Exception {
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
		/** ********************** 权限设置 ******************************/
		
		String subjectID = Utility.getName(request.getParameter("subjectID"));   //科目号		
		String subjectName = Utility.getName(request.getParameter("subjectName"));     //制造商名称
		String parentSubjectName = Utility.getName(request.getParameter("parentSubjectName"));
		String parentSubjectID = Utility.getName(request.getParameter("parentSubjectID"));
		String hid = Utility.getName(request.getParameter("hid"));
		
		subjectPo = new SubjectPo();
		subjectPo.setsLssSubjectID(subjectID);
		subjectPo.setsLssSubjectName(subjectName);
		subjectPo.setsLssParentID(parentSubjectID);
		subjectPo.setsLssID(hid);
		
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
		
		int count = voucherTemplateMgr.getSubjectCount(subjectPo);		
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String)request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}

			Pagination page = new Pagination(request, count, perPage);
			subjectList = voucherTemplateMgr.getSubjectList(subjectPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			subjectList = null;
		}

		if (Utility.getName(request.getParameter("treeFlag")).equals("1")){
			subjectPo = voucherTemplateMgr.getSubjectDetail(subjectPo);
			subjectID = subjectPo.getsLssSubjectID();
			subjectName = subjectPo.getsLssSubjectName();
		}		
		
		request.setAttribute("subjectID" , subjectID);
		request.setAttribute("subjectName" , subjectName);
		request.setAttribute("parentSubjectName" , parentSubjectName);
		request.setAttribute("parentSubjectID" , parentSubjectID);
		
		String parentID = Utility.getName(request.getParameter("parentID")); 
		request.setAttribute("parentID" , parentID);
		String parent = Utility.getName(request.getParameter("parent")); 
		request.setAttribute("parent" , parent);
		
		return SUCCESS;
	}	
	
	/**
	 * Description：初始化修改科目
	 */
	public String initSubjectUpdate() throws Exception {

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
		/** ********************** 权限设置 ******************************/

		String subjectID = Utility.getName(request.getParameter("subjectID"));
		subjectPo = new SubjectPo();
		subjectPo.setsLssID(subjectID);
		
		subjectPo = voucherTemplateMgr.getSubjectDetail(subjectPo);
		
		String parentID = Utility.getName(request.getParameter("parentID")); 
		request.setAttribute("parentID" , parentID);
		String parent = Utility.getName(request.getParameter("parent")); 
		request.setAttribute("parent" , parent);
		return SUCCESS;	
	}
	
	/**
	 * Description：根据参数修改科目
	 */
	public String updateSubject() throws Exception {

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
		/** ********************** 权限设置 ******************************/
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 3 表示修改
		logPo.setsLogContent("科目：" + Utility.getName(subjectPo.getsLssSubjectID()+"修改!"));
		
		request.setAttribute("parentID",Utility.getName(request.getParameter("parentID")));
		
		int count = voucherTemplateMgr.isExistsSubjectUpdate(subjectPo);
		if (count == 0)
		{
			voucherTemplateMgr.updateSubject(subjectPo,logPo);
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.update.sucess"));
			String parent = Utility.getName(request.getParameter("parent"));
			if(parent.equals("1"))
			{
				request.setAttribute("flag",GlobalConstants.OPENUPDATE7);
			}else
			{
				request.setAttribute("flag",GlobalConstants.OPENUPDATE9);
			}		
		}else{
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.repeat"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);			
		}		
		return SUCCESS;
		
	}
	
	/**
	 * Description：初始化删除科目
	 */
	public String initSubjectDelete() throws Exception {

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
		/** ********************** 权限设置 ******************************/
		
		String hid = Utility.getName(request.getParameter("hid"));
		String subjectID = Utility.getName(request.getParameter("subjectID"));
		String subjectName = Utility.getName(request.getParameter("subjectName"));
		
		request.setAttribute("hid",hid);
		request.setAttribute("subjectID",subjectID);
		request.setAttribute("subjectName",subjectName);
		
		String parentID = Utility.getName(request.getParameter("parentID")); 
		request.setAttribute("parentID" , parentID);
		
		return SUCCESS;
	}
	
	/**
	 * Description：根据参数删除凭证
	 */
	public String deleteSubject() throws Exception {

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
		/** ********************** 权限设置 ******************************/
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("科目：" + Utility.getName(subjectPo.getsLssSubjectID()+"删除!"));

		request.setAttribute("parentID",Utility.getName(request.getParameter("parentID")));
		
		voucherTemplateMgr.deleteSubject(subjectPo, logPo);		

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		String parent = Utility.getName(request.getParameter("parent"));
		if(parent.equals("1"))
		{
			request.setAttribute("flag",GlobalConstants.OPENUPDATE7);
		}else
		{
			request.setAttribute("flag",GlobalConstants.OPENUPDATE9);
		}
		
		return SUCCESS;
	}

	/**
	 * Description：初始化批量导入科目
	 */
	public String initBatchInsertSubject() throws Exception {
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
		/** ********************** 权限设置 ******************************/
		
		return SUCCESS;
	}
	
	/**
	 * Description：批量导入科目
	 */
	public String batchInsertSubject() throws Exception {
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
		/** ********************** 权限设置 ******************************/
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("科目批量导入!");
				
		subjectPo = new SubjectPo();
		voucherTemplateMgr.insertSubjectBatch(subjectPo, upload, ServletActionContext.getServletContext().getRealPath(this.getSavePath()), this.getUploadFileName(), this.getUploadContentType(), logPo);
				
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		String url = "''initSubjectSel.action?moduleID={1}''";
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(moduleID));		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE8);
		
		return SUCCESS;
	}

	/**
	 * 初始化导入物流期初商品的查询页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initImportAmountFile() throws Exception {
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

		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
        if (Utility.getName(systemParameterPo.getFspcbjstype()).equals("2")){
        	
        	CompanyNamePo cpo = new CompanyNamePo();
    		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
    			cpo.setFcnId(personInfoPo.getPersoncompanyid());
    		}
        	companyNamePos = companyNameMgr.getCompanyNameForSelect(cpo);
        }else{
        	request.setAttribute("bgnDate", initSystemMgr.getQcDateByCompany(""));	
        }
		
        String companyID = "";
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			companyID = personInfoPo.getPersoncompanyid();
		}
		ealpList = voucherTemplateMgr.getExportAmountLog(companyID);
		
		return SUCCESS;
	}
	
	/**
	 * 导入物流期初商品
	 * 
	 * @return
	 * @throws Exception
	 */
	public String importAmountFile() throws Exception {
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
		
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgiaverageflag(Utility.getName(fquartzSwitchPo.getFqscbjs()));
		
		String dctype = Utility.getName(request.getParameter("dctype"));
		String sjtype = Utility.getName(request.getParameter("sjtype"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String companyID = Utility.getName(request.getParameter("companyID2"));	
		String bgnDate = Utility.getName(request.getParameter("bgnDate"));	
		
		if (dctype.equals("3")){
			companyID = Utility.getName(request.getParameter("companyID"));
		}
		
		voucherTemplateMgr.insertImportAmountExcel(goodsInfoPo,sjtype,companyID,departmentID,bgnDate,systemParameterPo,upload,ServletActionContext.getServletContext().getRealPath(this.getSavePath()), this.getUploadFileName(), this.getUploadContentType(),ServletActionContext.getServletContext().getRealPath(this.getFileTemplet()),logPo);
		
		this.clearMessages(); 
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		String url = "''initImportAmountFile.action?moduleID={0}''";
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(moduleID));
		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化导出物流商品信息页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initExportAmountFile() throws Exception {
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

		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
        if (Utility.getName(systemParameterPo.getFspcbjstype()).equals("2")){
        	
        	CompanyNamePo cpo = new CompanyNamePo();
    		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
    			cpo.setFcnId(personInfoPo.getPersoncompanyid());
    		}
        	companyNamePos = companyNameMgr.getCompanyNameForSelect(cpo);
        }else{
        	request.setAttribute("bgnDate", initSystemMgr.getQcDateByCompany(""));	
        }
	
		return SUCCESS;
	}
	
	/**
	 * 导出物流商品信息页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String exportAmountFile() throws Exception {
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
	
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String companyID = Utility.getName(request.getParameter("companyID2"));	
		String bgnDate = Utility.getName(request.getParameter("bgnDate"));
		String type = Utility.getName(request.getParameter("type"));	
		String ecxelName = "";
		String fileName = "";
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("物流商品信息开始导出" + bgnDate + "库存!");
		
		if (type.equals("1")){   // 如果公司为空，表示按所有公司
			
			fileName = bgnDate + "物流商品信息.xlsx";
			
			setFileName(java.net.URLEncoder.encode(fileName, "UTF-8"));
			
		}else{
						
			DepartmentsPo dpo = new DepartmentsPo();
			
			if (type.equals("2")){   // 如果部门为空，表示按公司导出

				dpo.setBdpcompanysid(companyID);
				
				ecxelName = Utility.getName(departmentsMgr.getDepartment(dpo).getBdpcompanysname());  // 根据部门ID，获取公司名称
								 
			}else{   // 表示按公司、部门导出
				
				companyID = Utility.getName(request.getParameter("companyID"));

				dpo.setBdpdepartmentid(departmentID);
				
				ecxelName = Utility.getName(departmentsMgr.getDepartment(dpo).getBdpdepartmentname());  // 根据部门ID，获取部门名称
				
				type = "3";
			}
			
			fileName = bgnDate + ecxelName + "物流商品信息.xlsx";
			
			setFileName(java.net.URLEncoder.encode(fileName, "UTF-8"));
		}

		try {
			goodsInfoPo = new GoodsInfoPo();
			String url = ServletActionContext.getServletContext().getRealPath(this.getSavePath());
			inputStream = voucherTemplateMgr.insertExportAmountExcel(goodsInfoPo,companyID,departmentID,bgnDate,type,createPerson,url,fileName,logPo);
		} catch (Exception e) {
			System.out.println(bgnDate + ecxelName + "物流商品信息导出失败：" + e.getMessage());
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始化科目树
	 * @return
	 * @throws Exception
	 */
	public String initSubjectTree() throws Exception {
		
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
	
	/**
	 * 查询科目树
	 * @return
	 * @throws Exception
	 */
	public String loadSubjectTree() throws Exception {
		
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

		String nodeId = Utility.getName(request.getParameter("pid"));		
		String hrefTarget = Utility.getName(request.getParameter("hrefTarget"));
		
		menusList = voucherTemplateMgr.getSubjectTree(nodeId,hrefTarget,moduleID);
		
		return SUCCESS;
	}
	
	/**
	 * 查询科目树
	 * @return
	 * @throws Exception
	 */
	public String subjectTree() throws Exception {
		
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

		String hrefTarget = Utility.getName(request.getParameter("hrefTarget"));
		request.setAttribute("hrefTarget",hrefTarget);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化凭证模板查询
	 * @return
	 * @throws Exception
	 */
	public String initVoucherTempletSel() throws Exception {
		
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

		voucherTopIDList = voucherMgr.getVoucherTypeByExitsID();
		
		String fnpid = Utility.getName(request.getParameter("fnpid"));		
		if(!fnpid.equals("")){
			voucherSubsetIDList = voucherMgr.getVoucherTypeByID(fnpid);
		}
		
		request.setAttribute("fnpidpage", fnpid);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化凭证模板新增
	 * @return
	 * @throws Exception
	 */
	public String initVoucherTempletInsert() throws Exception {
		
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
		
		VoucherTempletPo po = new VoucherTempletPo();
		po.setsLvtvtVoucherTypeID(Utility.getName(request.getParameter("voucherTempletID")));
		voucherTempletList = voucherTemplateMgr.getVoucherTempletDetail(po);
		
		request.setAttribute("voucherTempletID",Utility.getName(request.getParameter("voucherTempletID")));
		request.setAttribute("voucherTempletName",Utility.getName(request.getParameter("voucherTempletName")));
		
		return SUCCESS;
	}
	
	/**
	 * 新增凭证模板
	 * @return
	 * @throws Exception
	 */
	public String voucherTempletInsert() throws Exception {
		
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("凭证模板：" + Utility.getName(request.getParameter("voucherTempletName")) + " 修改!");
				
		VoucherTempletPo po = new VoucherTempletPo();
		po.setsLvtvtVoucherTypeID(Utility.getName(request.getParameter("voucherTempletID")));
		
		voucherTempletList = new ArrayList<VoucherTempletPo>();
		for (int i = 0; i < voucherTempletTempPo.getsLvtvtSubjectID().length; i++){
			VoucherTempletPo tpo = new VoucherTempletPo();
			tpo.setsLvtvtVoucherTypeID(po.getsLvtvtVoucherTypeID());
			tpo.setsLvtvtorderby(i + 1 + "");
			tpo.setsLvtvtBalanceDirection( Utility.getName(voucherTempletTempPo.getsLvtvtBalanceDirection()[i]));
			tpo.setsLvtvtSubjectID( Utility.getName(voucherTempletTempPo.getsLvtvtSubjectID()[i]));
			tpo.setsLvtvtHExpressions( Utility.getName(voucherTempletTempPo.getsLvtvtHExpressions()[i]));			
			
			voucherTempletList.add(tpo);
		}
		
		voucherTemplateMgr.insertVoucherTemplet(po,voucherTempletList,logPo);
				
//		this.addActionMessage(getText("struts.messages.insert.sucess"));
//		String url = "''initVoucherTempletSel.action?moduleID={0}''";
//		List<String> params = new ArrayList<String>();
//		params.add(Utility.getName(moduleID));		
//		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
//		request.setAttribute("flag", GlobalConstants.OPENUPDATE8);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 查询科目树
	 * @return
	 * @throws Exception
	 */
	public String loadSubjectOpenTree() throws Exception {
		
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

		String nodeId = Utility.getName(request.getParameter("pid"));		
		String hrefTarget = Utility.getName(request.getParameter("hrefTarget"));
		
		menusList = voucherTemplateMgr.getSubjectOpenTree(nodeId,hrefTarget,moduleID);
		
		return SUCCESS;
	}
	
	public VoucherTemplateMgr getVoucherTemplateMgr() {
		return voucherTemplateMgr;
	}

	public void setVoucherTemplateMgr(VoucherTemplateMgr voucherTemplateMgr) {
		this.voucherTemplateMgr = voucherTemplateMgr;
	}

	public LogisticsLogMgr getLogisticsLogMgr() {
		return logisticsLogMgr;
	}

	public void setLogisticsLogMgr(LogisticsLogMgr logisticsLogMgr) {
		this.logisticsLogMgr = logisticsLogMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public SubjectPo getSubjectPo() {
		return subjectPo;
	}

	public void setSubjectPo(SubjectPo subjectPo) {
		this.subjectPo = subjectPo;
	}

	public List<SubjectPo> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<SubjectPo> subjectList) {
		this.subjectList = subjectList;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
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

	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}

	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}

	public VarietyMgr getVarietyMgr() {
		return varietyMgr;
	}

	public void setVarietyMgr(VarietyMgr varietyMgr) {
		this.varietyMgr = varietyMgr;
	}

	public List<GoodsInfoPo> getGoodsInfoList() {
		return goodsInfoList;
	}

	public void setGoodsInfoList(List<GoodsInfoPo> goodsInfoList) {
		this.goodsInfoList = goodsInfoList;
	}

	public List<BrandPo> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<BrandPo> brandList) {
		this.brandList = brandList;
	}

	public GoodsInfoPo getGoodsInfoPo() {
		return goodsInfoPo;
	}

	public void setGoodsInfoPo(GoodsInfoPo goodsInfoPo) {
		this.goodsInfoPo = goodsInfoPo;
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

	public List<FuctionTreeNode> getMenusList() {
		return menusList;
	}

	public void setMenusList(List<FuctionTreeNode> menusList) {
		this.menusList = menusList;
	}

	public VoucherMgr getVoucherMgr() {
		return voucherMgr;
	}

	public void setVoucherMgr(VoucherMgr voucherMgr) {
		this.voucherMgr = voucherMgr;
	}

	public List<VoucherTypePo> getVoucherTopIDList() {
		return voucherTopIDList;
	}

	public void setVoucherTopIDList(List<VoucherTypePo> voucherTopIDList) {
		this.voucherTopIDList = voucherTopIDList;
	}

	public List<VoucherTypePo> getVoucherSubsetIDList() {
		return voucherSubsetIDList;
	}

	public void setVoucherSubsetIDList(List<VoucherTypePo> voucherSubsetIDList) {
		this.voucherSubsetIDList = voucherSubsetIDList;
	}

	public VoucherTempletTempPo getVoucherTempletTempPo() {
		return voucherTempletTempPo;
	}

	public void setVoucherTempletTempPo(VoucherTempletTempPo voucherTempletTempPo) {
		this.voucherTempletTempPo = voucherTempletTempPo;
	}

	public List<VoucherTempletPo> getVoucherTempletList() {
		return voucherTempletList;
	}

	public void setVoucherTempletList(List<VoucherTempletPo> voucherTempletList) {
		this.voucherTempletList = voucherTempletList;
	}

	public ReportQuartzMgr getReportQuartzMgr() {
		return reportQuartzMgr;
	}

	public void setReportQuartzMgr(ReportQuartzMgr reportQuartzMgr) {
		this.reportQuartzMgr = reportQuartzMgr;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public CompanyNameMgr getCompanyNameMgr() {
		return companyNameMgr;
	}

	public void setCompanyNameMgr(CompanyNameMgr companyNameMgr) {
		this.companyNameMgr = companyNameMgr;
	}

	public List<CompanyNamePo> getCompanyNamePos() {
		return companyNamePos;
	}

	public void setCompanyNamePos(List<CompanyNamePo> companyNamePos) {
		this.companyNamePos = companyNamePos;
	}

	public FquartzSwitchPo getFquartzSwitchPo() {
		return fquartzSwitchPo;
	}

	public void setFquartzSwitchPo(FquartzSwitchPo fquartzSwitchPo) {
		this.fquartzSwitchPo = fquartzSwitchPo;
	}

	public List<ExportAmountLogPo> getEalpList() {
		return ealpList;
	}

	public void setEalpList(List<ExportAmountLogPo> ealpList) {
		this.ealpList = ealpList;
	}

	public InitSystemMgr getInitSystemMgr() {
		return initSystemMgr;
	}

	public void setInitSystemMgr(InitSystemMgr initSystemMgr) {
		this.initSystemMgr = initSystemMgr;
	}

	public String getFileTemplet() {
		return fileTemplet;
	}

	public void setFileTemplet(String fileTemplet) {
		this.fileTemplet = fileTemplet;
	}
	
}
