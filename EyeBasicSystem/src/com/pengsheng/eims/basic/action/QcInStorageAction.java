package com.pengsheng.eims.basic.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.QcInStorageMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.ProcurementOrdersMgr;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class QcInStorageAction extends BaseAction {
	
	private QcInStorageMgr qcInStorageMgr;
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterPo systemParameterPo;
	private List<GoodsInfoPo> gList;
	private String isFirstExec;
	private GoodsInfoPo goodsInfoPo;
	private CompanyNameMgr companyNameMgr;
	private List<CompanyNamePo> companyNamePos;
	private GoodsInfoTempPo goodsInfoTempPo;
	private DepartmentsMgr departmentsMgr;
	private List<DepartmentsPo> departmentsList;
	private WarehouseMgr warehouseMgr;
	private List<WarehousePo> warehousePoList;
	private ProcurementOrdersMgr procurementOrdersMgr;
	
	public String initQcInStorageSel() throws Exception {
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
		
    	CompanyNamePo cpo = new CompanyNamePo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			cpo.setFcnId(personInfoPo.getPersoncompanyid());
		}
    	companyNamePos = companyNameMgr.getCompanyNameForSelect(cpo);
    	
		return SUCCESS;
	}
	
	public String selQcInStorage() throws Exception {
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
		
    	CompanyNamePo cpo = new CompanyNamePo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			cpo.setFcnId(personInfoPo.getPersoncompanyid());
		}
    	companyNamePos = companyNameMgr.getCompanyNameForSelect(cpo);
    	
    	String companyID = Utility.getName(request.getParameter("companyID"));
    	String dptID = Utility.getName(request.getParameter("dptID"));
    	String warehouseID = Utility.getName(request.getParameter("warehouseID"));
    	String goodsID = Utility.getName(request.getParameter("goodsID"));
    	String goodsName = Utility.getName(request.getParameter("goodsName"));
    	
    	request.setAttribute("companyID",companyID);
    	request.setAttribute("dptID",dptID);
    	request.setAttribute("warehouseID",warehouseID);
    	request.setAttribute("goodsID",goodsID);
    	request.setAttribute("goodsName",goodsName);
    	
    	DepartmentsPo dpo = new DepartmentsPo();
    	
    	if (!companyID.equals("")){    		
    		dpo.setBdpcompanysid(companyID);    
    		
    		departmentsList = departmentsMgr.getDepartments(dpo);
    	}
    	
    	if (!dptID.equals("")){    		
    		dpo.setBdpdepartmentid(dptID);
    		
    		warehousePoList = warehouseMgr.getWarehouseList(dpo);
    	}
    	
    	GoodsInfoPo gpo = new GoodsInfoPo();
    	gpo.setBgicompanyid(companyID);
    	gpo.setBgidepartmentid(dptID);
    	gpo.setBgiwarehouseid(warehouseID);
    	gpo.setBgigoodsid(goodsID);
    	gpo.setBgigoodsname(goodsName);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			gpo.setBgicompanyid(personInfoPo.getPersoncompanyid());
		}
    	
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
 
		int count = qcInStorageMgr.getQcInStorageCount(gpo);
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
			gList = qcInStorageMgr.getQcInStorageList(gpo,page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}
		
		int totalnum = qcInStorageMgr.getQcInStorageSum(gpo);
		request.setAttribute("totalnum",totalnum);
		
		return SUCCESS;
	}
	
	public String initQcInStorageInsert() throws Exception {
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
		
    	CompanyNamePo cpo = new CompanyNamePo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			cpo.setFcnId(personInfoPo.getPersoncompanyid());
		}
    	companyNamePos = companyNameMgr.getCompanyNameForSelect(cpo);
		
		return SUCCESS;
	}
	
	public String initQcInStorageYxInsert() throws Exception {
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
		
    	CompanyNamePo cpo = new CompanyNamePo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			cpo.setFcnId(personInfoPo.getPersoncompanyid());
		}
    	companyNamePos = companyNameMgr.getCompanyNameForSelect(cpo);
		
		return SUCCESS;
	}
	
	public String insertQcInStorage() throws Exception {
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
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("新增非效期商品期初库存!");
				
		int count = goodsInfoTempPo.getGoodsid().length;
		gList = new ArrayList<GoodsInfoPo>();
		
		for (int i = 0; i < count; i++){
			GoodsInfoPo gpo = new GoodsInfoPo();
			gpo.setBgigoodsid(Utility.getName(goodsInfoTempPo.getGoodsid()[i]));
			gpo.setBgigoodsbarcode(Utility.getName(goodsInfoTempPo.getPcbarcode()[i]));
			gpo.setBgiwarehouseid(Utility.getName(request.getParameter("warehouseID")));
			gpo.setBgigoodsquantity(Utility.getName(goodsInfoTempPo.getGoodsquantity()[i]));
			
			gpo.setGuaranteeperiod("");
			gpo.setBatch("");
			
			gList.add(gpo);
		}
		
		qcInStorageMgr.insertQcInStorage(gList, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public String insertQcInStorageYx() throws Exception {
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
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("新增效期商品期初库存!");
				
		int count = goodsInfoTempPo.getGoodsid().length;
		gList = new ArrayList<GoodsInfoPo>();
		
		for (int i = 0; i < count; i++){
			GoodsInfoPo gpo = new GoodsInfoPo();
			gpo.setBgigoodsid(Utility.getName(goodsInfoTempPo.getGoodsid()[i]));
			gpo.setBgigoodsbarcode(Utility.getName(goodsInfoTempPo.getPcbarcode()[i]));
			gpo.setBgiwarehouseid(Utility.getName(request.getParameter("warehouseID")));
			gpo.setBgigoodsquantity(Utility.getName(goodsInfoTempPo.getGoodsquantity()[i]));
			
			gpo.setGuaranteeperiod(Utility.getName(goodsInfoTempPo.getGuaranteeperiod()[i]));
			gpo.setBatch(Utility.getName(goodsInfoTempPo.getBatch()[i]));
			gpo.setBgiregistrationnum(Utility.getName(goodsInfoTempPo.getRegistrationnum()[i]));
		
			gList.add(gpo);
		}
		
		qcInStorageMgr.insertQcInStorageYx(gList, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public String initQcInStorageUpdate() throws Exception {
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
		
		GoodsInfoPo gpo = new GoodsInfoPo();
    	gpo.setBgiwarehouseid(Utility.getName(request.getParameter("wid")));
    	gpo.setBgigoodsbarcode(Utility.getName(request.getParameter("bid")));
    	gpo.setGuaranteeperiod(Utility.getName(request.getParameter("gid")));
    	gpo.setBatch(Utility.getName(request.getParameter("bch")));
    	
		goodsInfoPo = qcInStorageMgr.getQcInStorageInfo(gpo);
		
		return SUCCESS;
	}
	
	public String updateQcInStorage() throws Exception {
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
		
		String qcnum = Utility.getName(request.getParameter("qcnum"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("仓位：【" + Utility.getName(goodsInfoPo.getBgiwarehousename()) + "】中的商品：【" + Utility.getName(goodsInfoPo.getBgigoodsbarcode()) + "】的库存从【" + qcnum +"】修改为【" + Utility.getName(goodsInfoPo.getBgiqcnum()) + "】");

		qcInStorageMgr.updateQcInStorage(goodsInfoPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public String addQcInStorageDimension() throws Exception {
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
		
    	CompanyNamePo cpo = new CompanyNamePo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			cpo.setFcnId(personInfoPo.getPersoncompanyid());
		}
    	companyNamePos = companyNameMgr.getCompanyNameForSelect(cpo);
		
		String[] tdgoodsids = Utility.getName(request.getParameter("tdgoodsids")).split(",");
		String[] tdvs = Utility.getName(request.getParameter("tdvs")).split(",");
		if(goodsInfoTempPo != null){
			for (int i = 0; i < goodsInfoTempPo.getGoodsid().length; i++) {
				tdgoodsids =  insert(tdgoodsids, goodsInfoTempPo.getGoodsid()[i]) ;
				tdvs = insert(tdvs,request.getParameterValues("needNumber") != null ? request.getParameterValues("needNumber")[i]:goodsInfoTempPo.getGoodsquantity()[i]);
			}
		}
		
		List<String> goodsidslist = new ArrayList<String>();
		List<String> vslist = new ArrayList<String>();
		for(int i=0; i< tdgoodsids.length; i++){
			if (!goodsidslist.contains(tdgoodsids[i])){
				goodsidslist.add(tdgoodsids[i].toString());
				vslist.add(tdvs[i].toString());
			}
		}
		
		List<GoodsInfoPo> goodsInfoPos = procurementOrdersMgr.selectDimensionPos(goodsidslist, vslist);
		
		request.setAttribute("goodsInfoPos", goodsInfoPos);
		
		String cstpgoodscategory = Utility.getName(request.getParameter("cstpgoodscategory"));
		String dptID = Utility.getName(request.getParameter("dptID"));
		String companyID = Utility.getName(request.getParameter("companyID"));
		String cstisuppliername = Utility.getName(request.getParameter("cstisuppliername"));
		String cstisupplierid = Utility.getName(request.getParameter("cstisupplierid"));
		String warehouseID = Utility.getName(request.getParameter("warehouseID"));
		String dptName = Utility.getName(request.getParameter("dptName"));
		String warehouseName = Utility.getName(request.getParameter("warehouseName"));
		String ioru = Utility.getName(request.getParameter("ioru"));
		
		request.setAttribute("cstpgoodscategory", cstpgoodscategory);
		request.setAttribute("dptID", dptID);
		request.setAttribute("companyID", companyID);
		request.setAttribute("cstisuppliername", cstisuppliername);
		request.setAttribute("cstisupplierid", cstisupplierid);
		request.setAttribute("warehouseID", warehouseID);
		request.setAttribute("dptName", dptName);
		request.setAttribute("warehouseName", warehouseName);
		
		return ioru;
	}
	
	private static String[] insert(String[] arr, String str){
		int size = arr.length;
		String[] tmp = new String[size + 1];
		System.arraycopy(arr, 0, tmp, 0, size);
		tmp[size] = str;
		return tmp;
	}

	public QcInStorageMgr getQcInStorageMgr() {
		return qcInStorageMgr;
	}

	public void setQcInStorageMgr(QcInStorageMgr qcInStorageMgr) {
		this.qcInStorageMgr = qcInStorageMgr;
	}

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

	public List<GoodsInfoPo> getgList() {
		return gList;
	}

	public void setgList(List<GoodsInfoPo> gList) {
		this.gList = gList;
	}

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public GoodsInfoPo getGoodsInfoPo() {
		return goodsInfoPo;
	}

	public void setGoodsInfoPo(GoodsInfoPo goodsInfoPo) {
		this.goodsInfoPo = goodsInfoPo;
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

	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}

	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public List<WarehousePo> getWarehousePoList() {
		return warehousePoList;
	}

	public void setWarehousePoList(List<WarehousePo> warehousePoList) {
		this.warehousePoList = warehousePoList;
	}

	public ProcurementOrdersMgr getProcurementOrdersMgr() {
		return procurementOrdersMgr;
	}

	public void setProcurementOrdersMgr(ProcurementOrdersMgr procurementOrdersMgr) {
		this.procurementOrdersMgr = procurementOrdersMgr;
	}
	
}
