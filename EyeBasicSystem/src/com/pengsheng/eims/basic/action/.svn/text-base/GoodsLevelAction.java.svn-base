package com.pengsheng.eims.basic.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.pengsheng.eims.basic.dao.GoodsLevelDao;
import com.pengsheng.eims.basic.dao.impl.GoodsLevelDaoImpl;
import com.pengsheng.eims.basic.mgr.GoodsLevelMgr;
import com.pengsheng.eims.basic.persistence.GoodsLevelPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.mgr.WorkTypeMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.system.persistence.WorkTypePo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class GoodsLevelAction extends BaseAction {

	//注入商品级别Mgr
	private GoodsLevelMgr goodsLevelMgr;

	//页面List
	private List list;
	
	//页面Po
	private GoodsLevelPo goodsLevelPo; 
	
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterPo systemParameterPo;
	private SystemParameterMgr systemParameterMgr;
	
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}
	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}
	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}
	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}
	
	public GoodsLevelMgr getGoodsLevelMgr() {
		return goodsLevelMgr;
	}
	public void setGoodsLevelMgr(GoodsLevelMgr goodsLevelMgr) {
		this.goodsLevelMgr = goodsLevelMgr;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public GoodsLevelPo getGoodsLevelPo() {
		return goodsLevelPo;
	}
	public void setGoodsLevelPo(GoodsLevelPo goodsLevelPo) {
		this.goodsLevelPo = goodsLevelPo;
	}
	//查询
	public String initGoodsLevelList() throws Exception 
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
			
			GoodsLevelPo po = new GoodsLevelPo();
			
			//根据查询条件返回相应的结果集数量
			int count = goodsLevelMgr.getGoodsLevelCount(po);
			
			//查询结果>0 查询出结果
			if (count > 0) {
				
				systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
				int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
				//页面显示数量
				int perPage = 0;
				
				//获取页面参数  
				//perPage:页面显示数量
				//如果不为空获取当前参数的值
				if (request.getParameter("perPage") != null) {
					perPage = new Integer((String) request.getParameter("perPage"))
							.intValue();
				} else if (request.getParameter("perPageNo") != null) {
					//如果
					if (!request.getParameter("perPageNo").equals("")) {
						perPage = new Integer((String) request
								.getParameter("perPageNo")).intValue();
					} else {
						perPage = fsppageno;
					}
				} else {
					perPage = fsppageno;
				}
				
				//
				Pagination page = new Pagination(request, count, perPage);
				
				//根据查询条件返回相应的结果集
				list = goodsLevelMgr.getGoodsLevelList(po, page.getStart(), page.getPageSize());

				request.setAttribute(Pagination.PAGINATION, page);
				
			} else { //否则查询结果为NULL
				
				list = null;
			
			}
			
			return SUCCESS;
		}
			
	
	
	//新增
	public String initInsertGoodsLevel() throws Exception   
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
		return SUCCESS;
	}
	public String insertGoodsLevel() throws Exception   
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
			logPo.setsLogContent("商品级别：" + Utility.getName(goodsLevelPo.getBglid()) + "新增!");
			
			
			//查询商品级别ID是否存在
			int flag = goodsLevelMgr.getGoodsLevelId(goodsLevelPo);

			int flagName=goodsLevelMgr.getGoodsLevelName(goodsLevelPo);
			

			//清空message
			this.clearMessages();
			
			//如果结果为0，ID不存在继续执行
			if(flag == 0)
			{
				if(flagName==0)
				{
					goodsLevelMgr.insertGoodsLevel(goodsLevelPo,logPo);			
					this.addActionMessage(getText("struts.messages.insert.sucess"));
					request.setAttribute("flag",GlobalConstants.OPENUPDATE);
					return SUCCESS;
				}else
				{
					this.addActionMessage(getText("商品级别名称重复!"));
					request.setAttribute("flag",GlobalConstants.OPENUPDATE);
					return ERROR;
				}
				
						
			}else{//否则弹出消息			
				this.addActionMessage(getText("struts.messages.repeat"));
				request.setAttribute("flag",GlobalConstants.OPENUPDATE);
				return ERROR;
			}
	}
	//修改
	public String initUpdateGoodsLevel() throws Exception 
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
			GoodsLevelPo param = new GoodsLevelPo();
			param.setBglid(request.getParameter("hid"));
		    
			goodsLevelPo = goodsLevelMgr.getGoodsLevelPo(param);

			return SUCCESS;
	}
	public String updateGoodsLevel() throws Exception 
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
			logPo.setsLogOpID("3");    // 3 表示修改
			logPo.setsLogContent("商品级别：" + Utility.getName(goodsLevelPo.getBglid()) + "修改!");
	
			
	//	int flagName=goodsLevelMgr.getGoodsLevelNameUpdate(goodsLevelPo);
			
	//	int flagDiscount = goodsLevelMgr.getGoodsLevelDiscountUpdate(goodsLevelPo);
			this.clearMessages();
			 goodsLevelMgr.updateGoodsLevel(goodsLevelPo,logPo);	
			 this.addActionMessage(getText("struts.messages.update.sucess"));		
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);	
			return SUCCESS;
		 
	}
	public String initDeleteGoodsLevel() throws Exception   //deleteGoodsLevel
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
			GoodsLevelPo param = new GoodsLevelPo();
			param.setBglid(request.getParameter("hid"));
			
			goodsLevelPo = goodsLevelMgr.getGoodsLevelPo(param);
		return SUCCESS;
	}
	
	public String deleteGoodsLevel() throws Exception 
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
			GoodsLevelPo param = new GoodsLevelPo();
			param.setBglid(Utility.getName(request.getParameter("hid")));
			
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(personInfoPo.getId());
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 模块ID
			logPo.setsLogOpID("2");    // 2 表示删除
			logPo.setsLogContent("商品级别：" + Utility.getName(request.getParameter("hid")) + "删除!");
			
			//查询商品级别在goods表中是否已经使用
			int flag =0; 
			
			//清空message
			this.clearMessages();
			
			//如果结果为0，ID不存在继续执行
			if(flag == 0){
				
				//删除商品级别
				goodsLevelMgr.deleteGoodsLevel(param,logPo);
				
				this.addActionMessage(getText("struts.messages.delete.sucess"));
				
			}else{//否则弹出消息			
				this.addActionMessage(getText("商品级别删除失败!"));
					
			}
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
			
		}
	
}
