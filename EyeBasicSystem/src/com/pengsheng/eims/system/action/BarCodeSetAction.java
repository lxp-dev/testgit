package com.pengsheng.eims.system.action;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.BarCodeSetMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.BarCodeSetPo;
import com.pengsheng.eims.system.persistence.MaxDiscountDetailsPo;
import com.pengsheng.eims.system.persistence.MaxDiscountPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class BarCodeSetAction extends BaseAction{
	
	private PersonPermissionMgr personPermissionMgr;
	
	private SystemParameterMgr systemParameterMgr;
	
	private SystemParameterPo systemParameterPo;
	
	private String isFirstExec;
	
	private BarCodeSetMgr barCodeSetMgr;
	
	private BarCodeSetPo barCodeSetPo;
	
	private List<BarCodeSetPo> barCodeSetList;
		
	public List<BarCodeSetPo> getBarCodeSetList() {
		return barCodeSetList;
	}


	public void setBarCodeSetList(List<BarCodeSetPo> barCodeSetList) {
		this.barCodeSetList = barCodeSetList;
	}


	public BarCodeSetMgr getBarCodeSetMgr() {
		return barCodeSetMgr;
	}


	public void setBarCodeSetMgr(BarCodeSetMgr barCodeSetMgr) {
		this.barCodeSetMgr = barCodeSetMgr;
	}


	public BarCodeSetPo getBarCodeSetPo() {
		return barCodeSetPo;
	}


	public void setBarCodeSetPo(BarCodeSetPo barCodeSetPo) {
		this.barCodeSetPo = barCodeSetPo;
	}


	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}


	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
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


	/**
	 * 初始化商品条码批号维护查询
	 * @return
	 * @throws Exception
	 */
	public String initBarCodeSetSel() throws Exception {
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

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "barCodeSetSel";
		}
		
		return SUCCESS;
	}
	/**
	 * 商品条码批号维护查询
	 * @return
	 * @throws Exception
	 */
	public String barCodeSetSel() throws Exception {
		
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
		
		String goodsCategoryID = Utility.getName(request.getParameter("goodsCategoryID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		
		request.setAttribute("goodsCategoryID",goodsCategoryID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("brandName",brandName);
		request.setAttribute("brandID",brandID);
		request.setAttribute("goodsID",goodsID);
		request.setAttribute("goodsName",goodsName);
		
		barCodeSetPo = new BarCodeSetPo();
		if (goodsCategoryID.startsWith("3") || goodsCategoryID.startsWith("4")){
			barCodeSetPo.setFbcsiscustomize(goodsCategoryID.split("_")[1]);
			barCodeSetPo.setFbcsgoodscategoryid(goodsCategoryID.split("_")[0]);				
		}else{
			barCodeSetPo.setFbcsgoodscategoryid(goodsCategoryID);
		}
		
		barCodeSetPo.setFbcssupplierid(supplierID);
		barCodeSetPo.setFbcsbrandid(brandID);
		barCodeSetPo.setFbcsgoodsid(goodsID);
		barCodeSetPo.setFbcsgoodsname(goodsName);
		
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
		int count = barCodeSetMgr.getBarCodeSetCount(barCodeSetPo);
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
			barCodeSetList = barCodeSetMgr.getBarCodeSetList(barCodeSetPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			barCodeSetList = null;
		}

	
		return SUCCESS;
	}
	
	/**
	 * 初始化商品条码批号维护新增
	 * @return
	 * @throws Exception
	 */
	public String initBarCodeSetInsert() throws Exception {
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
	 * 商品条码批号维护新增
	 * @return
	 * @throws Exception
	 */
	public String insertBarCodeSet() throws Exception {
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
		if (barCodeSetPo.getFbcsgoodscategoryid().equals("3-0")){
			barCodeSetPo.setFbcsgoodscategoryname("成品片");				
		}
		if (barCodeSetPo.getFbcsgoodscategoryid().equals("3-D")){
			barCodeSetPo.setFbcsgoodscategoryname("订做片");				
		}
		if (barCodeSetPo.getFbcsgoodscategoryid().equals("4-0")){
			barCodeSetPo.setFbcsgoodscategoryname("隐形成品片");				
		}
		if (barCodeSetPo.getFbcsgoodscategoryid().equals("4-D")){
			barCodeSetPo.setFbcsgoodscategoryname("隐形订做片");				
		}
		if (barCodeSetPo.getFbcsgoodscategoryid().equals("1")){
			barCodeSetPo.setFbcsgoodscategoryname("镜架");				
		}
		if (barCodeSetPo.getFbcsgoodscategoryid().equals("2")){
			barCodeSetPo.setFbcsgoodscategoryname("配件");				
		}
		if (barCodeSetPo.getFbcsgoodscategoryid().equals("5")){
			barCodeSetPo.setFbcsgoodscategoryname("隐形护理液");				
		}
		if (barCodeSetPo.getFbcsgoodscategoryid().equals("6")){
			barCodeSetPo.setFbcsgoodscategoryname("太阳镜");				
		}
		if (barCodeSetPo.getFbcsgoodscategoryid().equals("7")){
			barCodeSetPo.setFbcsgoodscategoryname("耗材");				
		}
		if (barCodeSetPo.getFbcsgoodscategoryid().equals("8")){
			barCodeSetPo.setFbcsgoodscategoryname("老花镜");				
		}
		if (barCodeSetPo.getFbcsgoodscategoryid().equals("9")){
			barCodeSetPo.setFbcsgoodscategoryname("视光");				
		}			
		if (barCodeSetPo.getFbcsgoodscategoryid().startsWith("3") || barCodeSetPo.getFbcsgoodscategoryid().startsWith("4")){
			barCodeSetPo.setFbcsiscustomize(barCodeSetPo.getFbcsgoodscategoryid().split("-")[1]);
			barCodeSetPo.setFbcsgoodscategoryid(barCodeSetPo.getFbcsgoodscategoryid().split("-")[0]);				
		}
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("商品条码批号设置:" + Utility.getName(barCodeSetPo.getFbcsgoodscategoryname()) + "新增!");
		
		int count = barCodeSetMgr.isBarCodeSet(barCodeSetPo);
		if (count == 0){

			barCodeSetMgr.insertBarCodeSet(barCodeSetPo, logPo);
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));		
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
		}else{
			this.clearMessages();
			this.addActionMessage(getText("商品条码批号设置不能重复!"));
			
			return "NoRepeat";
		}
		
		return SUCCESS;
	}
	/**
	 * 初始化商品条码批号维护更新
	 * @return
	 * @throws Exception
	 */
	public String initBarCodeSetUpdate() throws Exception {
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		BarCodeSetPo barCodePo = new BarCodeSetPo();
		barCodePo.setFbcsid(Utility.getName(request.getParameter("hid")));
		
		barCodeSetPo = barCodeSetMgr.getBarCodeSetPo(barCodePo);
		
		return SUCCESS;
	}
	/**
	 * 商品条码批号维护更新
	 * @return
	 * @throws Exception
	 */
	public String updateBarCodeSet() throws Exception {
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
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("最大折扣设置：" + Utility.getName(barCodeSetPo.getFbcsid()) +"修改!");
		
		barCodeSetMgr.updateBarCodeSet(barCodeSetPo, logPo);		
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;

	}	
	/**
	 * 初始化商品条码批号维护删除
	 * @return
	 * @throws Exception
	 */
	public String initBarCodeSetDelete() throws Exception {
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
		
		BarCodeSetPo barCodePo = new BarCodeSetPo();
		barCodePo.setFbcsid(Utility.getName(request.getParameter("hid")));
		
		barCodeSetPo = barCodeSetMgr.getBarCodeSetPo(barCodePo);
		
		return SUCCESS;
	}	
	/**
	 * 商品条码批号维护删除
	 * @return
	 * @throws Exception
	 */
	public String deleteBarCodeSet() throws Exception {
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
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("最大折扣设置：" + Utility.getName(barCodeSetPo.getFbcsid()) + "删除!");
		
		barCodeSetMgr.deleteBarCodeSet(barCodeSetPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		
		return SUCCESS;
	}
	/**
	 * 初始化商品条码批号维护批量更新
	 * @return
	 * @throws Exception
	 */
	public String initBarCodeBatchSetUpdate() throws Exception {
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
	 * 商品条码批号维护批量更新
	 * @return
	 * @throws Exception
	 */
	public String updateBarCodeBatchSet() throws Exception {
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
	 * 初始化商品条码批号维护批量删除
	 * @return
	 * @throws Exception
	 */
	public String initBarCodeBatchSetDelete() throws Exception {
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
	 * 商品条码批号维护批量删除
	 * @return
	 * @throws Exception
	 */
	public String deleteBarCodeBatchSet() throws Exception {
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
	
}
