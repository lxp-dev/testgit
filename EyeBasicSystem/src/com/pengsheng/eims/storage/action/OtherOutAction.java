package com.pengsheng.eims.storage.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.mgr.InTransitDetailsMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.OtherOutMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class OtherOutAction extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;	
	private WarehouseMgr warehouseMgr;	
	private DepartmentsMgr departmentsMgr;	
	private OtherOutMgr otherOutMgr;	
	private InventoryPo inventoryPo;	
	private GoodsInfoTempPo goodsInfoTempPo;	
	private List<InventoryEntryPo> inventoryEntryList;		
	private List<InventoryPo> otherOutList;	
	private List<WarehousePo> warehouseList;	
	private List<DepartmentsPo> departmentsList;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private InTransitDetailsMgr inTransitDetailsMgr;
	private String isFirstExec;
	
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

	public InTransitDetailsMgr getInTransitDetailsMgr() {
		return inTransitDetailsMgr;
	}

	public void setInTransitDetailsMgr(InTransitDetailsMgr inTransitDetailsMgr) {
		this.inTransitDetailsMgr = inTransitDetailsMgr;
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
	 * 初始化其它出库查询
	 */
	public String initOtherOutSel()throws Exception{
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
		
		//取得登陆人允许操作的仓位&部门 Begin	
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		warehouseList=warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);		
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selOtherOut";
		}
			
		return SUCCESS;
	}
	/**
	 * 查询其它出库
	 */
	public String selOtherOut()throws Exception{
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
		
		//取查询条件
		String billID=Utility.getName(request.getParameter("billID"));
		String startTime=Utility.getName(request.getParameter("startTime"));
		String endTime=Utility.getName(request.getParameter("endTime"));
		String departmentid = Utility.getName(request.getParameter("cstidepartmentid"));
		String outstockID=Utility.getName(request.getParameter("cstioutstockid"));
		String auditState=Utility.getName(request.getParameter("auditState"));
		String createPersonName=Utility.getName(request.getParameter("createPersonName"));
		String cstpcreateperson=Utility.getName(request.getParameter("cstpcreateperson"));
		String auditPersonName=Utility.getName(request.getParameter("auditPersonName"));
		String cstpauditperson=Utility.getName(request.getParameter("cstpauditperson"));
		//将查询条件存入PO 
		InventoryPo po=new InventoryPo();
		po.setCstibillid(billID);
		po.setCstistartTime(startTime);
		po.setCstiendTime(endTime);
		po.setCstioutstockid(outstockID);
		po.setCstiauditstate(auditState);
		po.setCstidepartmentid(departmentid);
		po.setCsticreatepersonname(createPersonName);
		po.setCsticreateperson(cstpcreateperson);
		po.setCstiauditpersonname(auditPersonName);
		po.setCstiauditperson(cstpauditperson);
		
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
		
		int count=otherOutMgr.getOtherOutCount(po);
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
	    otherOutList=otherOutMgr.getOtherOutList(po,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			otherOutList = null;
		}		
		
		request.setAttribute("billID",billID);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("outstockID",outstockID);
		request.setAttribute("departmentid",departmentid);
		request.setAttribute("auditState",auditState);
		request.setAttribute("createPersonName", createPersonName);
		request.setAttribute("cstpcreateperson", cstpcreateperson);
		request.setAttribute("auditPersonName", auditPersonName);
		request.setAttribute("cstpauditperson", cstpauditperson);
		
		//取得登陆人允许操作的仓位&部门 Begin	
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		warehouseList=warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);
		//取得登陆人允许操作的仓位&部门 End

		return SUCCESS;
	}
	/**
	 * 初始化其它出库新增
	 */
	public String initOtherOutInsert()throws Exception{
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
		
		inventoryPo=new InventoryPo();		
		inventoryPo.setCstibillid("OTO"+GenerateNumber.getInstance().getGenerageNumber());
		
		//取得登陆人允许操作的仓位&部门 Begin		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		warehouseList=warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);
		
		return SUCCESS;
	}
	/**
	 * 新增其它出库
	 */
	public String insertOtherOut()throws Exception{
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
		
		//判断是否选中审核复选框
        if("".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditstate("0");
        }
        if("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditperson(inventoryPo.getCsticreateperson());
        }
        
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("其他出库单:" + inventoryPo.getCstibillid() + "新增!");
		
		int lenth=goodsInfoTempPo.getGoodsid().length;
		inventoryEntryList=new ArrayList<InventoryEntryPo>();
		int count = 0;
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String goodsID = null;
		BigDecimal sNum = null;
		BigDecimal dNum = null;
		
		for(int i=0;i<lenth;i++){
			goodsID = goodsInfoTempPo.getGoodsid()[i];
			inventoryPo.setCstigoodscategory(goodsID.substring(0, 1));
			
			InventoryEntryPo inventoryEntryPo=new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
			inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);			
			inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
			inventoryEntryPo.setCstieoutstockid(inventoryPo.getCstioutstockid());			
			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);//单位成本(不含税)
			inventoryEntryPo.setCstienottaxrateamount(goodsInfoTempPo.getNottaxrateamount()[i]);//成本合计(不含税)			
			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);//含税单价
			inventoryEntryPo.setCstiecostpriceamount(goodsInfoTempPo.getCostpriceamount()[i]);//价税合计			
			inventoryEntryPo.setCstietaxamount(goodsInfoTempPo.getTaxamount()[i]);//税额合计				
			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);//税率			
			inventoryEntryPo.setCstieoutstorageflag("1");
			if (Utility.getName(systemParameterPo.getFspsalestype()).equals("0")){ //不允许负库存销售
				int goodsNums = 0;
				if (!Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3") ){ //使用条码
					if (Utility.getName(systemParameterPo.getFspstealtheffective()).equals("0") || (!goodsID.substring(0,1).equals("4") && !goodsID.substring(0,1).equals("5"))){ //不用批号
						goodsNums += inTransitDetailsMgr.getStorageNumByNotBatch(inventoryEntryPo);
					}
					if (!Utility.getName(systemParameterPo.getFspstealtheffective()).equals("0") && (goodsID.substring(0,1).equals("4") || goodsID.substring(0,1).equals("5"))){ //使用批号
						goodsNums += inTransitDetailsMgr.getStorageNumByBatch(inventoryEntryPo);
					}
				}
				if (Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3")){ //不使用条码
					goodsNums = inTransitDetailsMgr.getStorageNumByGoodsID(inventoryEntryPo);
				}
				
				sNum = new BigDecimal(goodsNums);
				dNum = new BigDecimal(inventoryEntryPo.getCstiegoodsquantity());
				sNum = sNum.subtract(dNum);
				if (sNum.intValue() <= 0){
					count = 1;
					inventoryPo.setCstiauditstate("0");
					inventoryPo.setCstiauditperson("");
					inventoryEntryPo.setCstieoutstorageflag("0");
				}
				
				sNum = null;
				dNum = null;
			}
			inventoryEntryList.add(inventoryEntryPo);
		}
		
		otherOutMgr.insertOtherOut(inventoryPo, inventoryEntryList,logPo);
		
		this.clearMessages();
		if (count > 0){
			this.addActionMessage(getText("新增成功!\\n部分商品库存不足,未能出库!"));
		}else{
			this.addActionMessage(getText("struts.messages.insert.sucess"));
		}		
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

	/**
	 * 销售其它详细
	 */
	public String initOtherOutDetails()throws Exception{
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
		
		String id=Utility.getName(request.getParameter("hid"));
		inventoryPo =new InventoryPo();
		inventoryPo.setCstibillid(id);
		inventoryPo=otherOutMgr.getOtherOut(inventoryPo);
		inventoryEntryList=otherOutMgr.getOtherOutEntryList(inventoryPo);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化其它出库修改
	 */
	public String initOtherOutUpdate()throws Exception{
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
		
		String id=Utility.getName(request.getParameter("hid"));
		inventoryPo =new InventoryPo();
		inventoryPo.setCstibillid(id);
		inventoryPo=otherOutMgr.getOtherOut(inventoryPo);
		inventoryEntryList=otherOutMgr.getOtherOutEntryList(inventoryPo);
		
		return SUCCESS;
	}
	/**
	 * 修改其它出库
	 */
	public String updateOtherOut()throws Exception{
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

        if("".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditstate("0");
        }
        if("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditperson(personInfoPo.getId());
        }

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("其他出库单:" + inventoryPo.getCstibillid() + "修改!");
		
		int lenth=goodsInfoTempPo.getGoodsid().length;
		inventoryEntryList=new ArrayList<InventoryEntryPo>();
		int count = 0;
		String goodsID = null;
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		BigDecimal sNum = null;
		BigDecimal dNum = null;
		
		for(int i=0;i<lenth;i++){
			goodsID = goodsInfoTempPo.getGoodsid()[i];
			
			InventoryEntryPo inventoryEntryPo=new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
			inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);//单位成本(不含税)
			inventoryEntryPo.setCstienottaxrateamount(goodsInfoTempPo.getNottaxrateamount()[i]);//成本合计(不含税)			
			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);//含税单价
			inventoryEntryPo.setCstiecostpriceamount(goodsInfoTempPo.getCostpriceamount()[i]);//价税合计			
			inventoryEntryPo.setCstietaxamount(goodsInfoTempPo.getTaxamount()[i]);//税额合计				
			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);//税率
			inventoryEntryPo.setCstieoutstorageflag("1");
			if (Utility.getName(systemParameterPo.getFspsalestype()).equals("0")){ //不允许负库存销售
				int goodsNums = 0;
				if (!Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3") ){ //使用条码
					if (Utility.getName(systemParameterPo.getFspstealtheffective()).equals("0") || (!goodsID.substring(0,1).equals("4") && !goodsID.substring(0,1).equals("5"))){ //不用批号
						goodsNums += inTransitDetailsMgr.getStorageNumByNotBatch(inventoryEntryPo);
					}
					if (!Utility.getName(systemParameterPo.getFspstealtheffective()).equals("0") && (goodsID.substring(0,1).equals("4") || goodsID.substring(0,1).equals("5"))){ //使用批号
						goodsNums += inTransitDetailsMgr.getStorageNumByBatch(inventoryEntryPo);
					}
				}
				if (Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3")){ //不使用条码
					goodsNums = inTransitDetailsMgr.getStorageNumByGoodsID(inventoryEntryPo);
				}
				
				sNum = new BigDecimal(goodsNums);
				dNum = new BigDecimal(inventoryEntryPo.getCstiegoodsquantity());
				sNum = sNum.subtract(dNum);
				if (sNum.intValue() <= 0){
					count = 1;
					inventoryPo.setCstiauditstate("0");
					inventoryPo.setCstiauditperson("");
					inventoryEntryPo.setCstieoutstorageflag("0");
				}
				
				sNum = null;
				dNum = null;

			}
			
			inventoryEntryList.add(inventoryEntryPo);
		}
		otherOutMgr.updateOtherOut(inventoryPo, inventoryEntryList,logPo);
		
		this.clearMessages();
		if (count > 0){
			this.addActionMessage(getText("修改成功!\\n部分商品库存不足,未能出库!"));
		}else{
			this.addActionMessage(getText("struts.messages.update.sucess"));
		}		
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	/**
	 * 初始化其它出库删除
	 */
	public String initOtherOutDelete()throws Exception{
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
		
		String id=Utility.getName(request.getParameter("hid"));
		InventoryPo po=new InventoryPo();
		po.setCstibillid(id);
		inventoryPo=otherOutMgr.getOtherOut(po);
		
		return SUCCESS;
	}
	/**
	 * 删除其它出库
	 */
	public String deleteOtherOut()throws Exception{
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
		
		String id=Utility.getName(request.getParameter("hid"));
		InventoryPo po=new InventoryPo();
		po.setCstibillid(id);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("其他出库单:" + id + "删除!");
		
		otherOutMgr.deleteOtherOut(po,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}
	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}
	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}
	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}
	public OtherOutMgr getOtherOutMgr() {
		return otherOutMgr;
	}
	public void setOtherOutMgr(OtherOutMgr otherOutMgr) {
		this.otherOutMgr = otherOutMgr;
	}
	public InventoryPo getInventoryPo() {
		return inventoryPo;
	}
	public void setInventoryPo(InventoryPo inventoryPo) {
		this.inventoryPo = inventoryPo;
	}
	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}
	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}
	public List<InventoryEntryPo> getInventoryEntryList() {
		return inventoryEntryList;
	}
	public void setInventoryEntryList(List<InventoryEntryPo> inventoryEntryList) {
		this.inventoryEntryList = inventoryEntryList;
	}
	public List<WarehousePo> getWarehouseList() {
		return warehouseList;
	}
	public void setWarehouseList(List<WarehousePo> warehouseList) {
		this.warehouseList = warehouseList;
	}
	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}
	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}
	public List<InventoryPo> getOtherOutList() {
		return otherOutList;
	}
	public void setOtherOutList(List<InventoryPo> otherOutList) {
		this.otherOutList = otherOutList;
	}
}
