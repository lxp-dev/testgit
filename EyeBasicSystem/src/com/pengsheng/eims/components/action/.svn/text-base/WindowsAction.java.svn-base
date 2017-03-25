package com.pengsheng.eims.components.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.mgr.CustomerMgr;
import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.CustomerPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.basic.persistence.VarietyPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.mgr.WindowGoodsMgr;
import com.pengsheng.eims.components.mgr.WindowsMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesAreaPo;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.MemberManagementMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.MemberManagementPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class WindowsAction extends BaseAction {

	private WindowsMgr windowsMgr;
	private SupplierMgr supplierMgr;
	private List<GoodsCategoryPo> goodsCategoryList;
	private List<SupplierPo> supplierList;
	private List<BrandPo> brands;
	private List<VarietyPo> varietys;
	private List<GoodsCategoryPo> goodsCategorys;
	private SupplierPo supplierPo;
	private List<CustomerPo> customerList;
	private CustomerMgr customerMgr;
	private DepartmentsMgr departmentsMgr;	
	private List<DepartmentsPo> departmentList = null;
	private PersonPermissionMgr personPermissionMgr = null;	
	private List<InTransitPo> inTransitList = null;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private List<SalesAreaPo> salesAreaList = null;
	private SalesAreaPo salesAreaPo = null;
	private WarehouseMgr warehouseMgr;
	private List<WarehousePo> warehousePos;
	private List<DepartmentsPo> departmentsList;	
	private PersonInfoMgr personInfoMgr;
	private List<PersonInfoPo> persons;
	private List<RolePo> roles;
	private List<DepartmentsPo> departments;
	private List<MemberManagementPo> memberManagementlist;
	private MemberManagementMgr memberManagementMgr;	
	private String isFirstExec;
	private GoodsInfoPo goodsInfoPo;
	private CompanyNameMgr companyNameMgr;
	private WindowGoodsMgr windowGoodsMgr;
	private List<BrandPo> brandlist;
	
	public WindowGoodsMgr getWindowGoodsMgr() {
		return windowGoodsMgr;
	}

	public void setWindowGoodsMgr(WindowGoodsMgr windowGoodsMgr) {
		this.windowGoodsMgr = windowGoodsMgr;
	}

	public List<BrandPo> getBrandlist() {
		return brandlist;
	}

	public void setBrandlist(List<BrandPo> brandlist) {
		this.brandlist = brandlist;
	}

	public CompanyNameMgr getCompanyNameMgr() {
		return companyNameMgr;
	}

	public void setCompanyNameMgr(CompanyNameMgr companyNameMgr) {
		this.companyNameMgr = companyNameMgr;
	}

	public GoodsInfoPo getGoodsInfoPo() {
		return goodsInfoPo;
	}

	public void setGoodsInfoPo(GoodsInfoPo goodsInfoPo) {
		this.goodsInfoPo = goodsInfoPo;
	}

	public List<MemberManagementPo> getMemberManagementlist() {
		return memberManagementlist;
	}

	public void setMemberManagementlist(
			List<MemberManagementPo> memberManagementlist) {
		this.memberManagementlist = memberManagementlist;
	}

	public MemberManagementMgr getMemberManagementMgr() {
		return memberManagementMgr;
	}

	public void setMemberManagementMgr(MemberManagementMgr memberManagementMgr) {
		this.memberManagementMgr = memberManagementMgr;
	}

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}

	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}

	public List<PersonInfoPo> getPersons() {
		return persons;
	}

	public void setPersons(List<PersonInfoPo> persons) {
		this.persons = persons;
	}

	public List<RolePo> getRoles() {
		return roles;
	}

	public void setRoles(List<RolePo> roles) {
		this.roles = roles;
	}

	public List<DepartmentsPo> getDepartments() {
		return departments;
	}

	public void setDepartments(List<DepartmentsPo> departments) {
		this.departments = departments;
	}

	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}

	public List<WarehousePo> getWarehousePos() {
		return warehousePos;
	}

	public void setWarehousePos(List<WarehousePo> warehousePos) {
		this.warehousePos = warehousePos;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public SalesAreaPo getSalesAreaPo() {
		return salesAreaPo;
	}

	public void setSalesAreaPo(SalesAreaPo salesAreaPo) {
		this.salesAreaPo = salesAreaPo;
	}

	public List<SalesAreaPo> getSalesAreaList() {
		return salesAreaList;
	}

	public void setSalesAreaList(List<SalesAreaPo> salesAreaList) {
		this.salesAreaList = salesAreaList;
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
	
	public List<InTransitPo> getInTransitList() {
		return inTransitList;
	}

	public void setInTransitList(List<InTransitPo> inTransitList) {
		this.inTransitList = inTransitList;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public List<CustomerPo> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerPo> customerList) {
		this.customerList = customerList;
	}

	public CustomerMgr getCustomerMgr() {
		return customerMgr;
	}

	public void setCustomerMgr(CustomerMgr customerMgr) {
		this.customerMgr = customerMgr;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public List<DepartmentsPo> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<DepartmentsPo> departmentList) {
		this.departmentList = departmentList;
	}

	public WindowsMgr getWindowsMgr() {
		return windowsMgr;
	}

	public void setWindowsMgr(WindowsMgr windowsMgr) {
		this.windowsMgr = windowsMgr;
	}

	public List<SupplierPo> getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(List<SupplierPo> supplierList) {
		this.supplierList = supplierList;
	}

	public List<BrandPo> getBrands() {
		return brands;
	}

	public void setBrands(List<BrandPo> brands) {
		this.brands = brands;
	}

	public List<VarietyPo> getVarietys() {
		return varietys;
	}

	public void setVarietys(List<VarietyPo> varietys) {
		this.varietys = varietys;
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}

	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}

	public SupplierPo getSupplierPo() {
		return supplierPo;
	}

	public void setSupplierPo(SupplierPo supplierPo) {
		this.supplierPo = supplierPo;
	}

	public String selSupplierOpen() throws Exception {

		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String goodsCategoryID = Utility.getName(request.getParameter("goodsCategoryID"));

		supplierPo = new SupplierPo();
		supplierPo.setBspid(supplierID);
		supplierPo.setBspsuppliername(supplierName);
		supplierPo.setBspcategoryid(goodsCategoryID);

		String isclosed = Utility.getName(request.getParameter("isclosed"));
		request.setAttribute("isclosed",isclosed);
		supplierPo.setBspflag(isclosed);
		
		// 查询条件限制
		if (StringUtils.isNotEmpty(request.getParameter("categoryID_open"))
				&& request.getParameter("categoryID_open").indexOf(",") == -1) {
			goodsCategoryID = Utility.getName(request
					.getParameter("categoryID_open"));

			request.setAttribute("categoryID_open", goodsCategoryID);
			if (StringUtils.isNotEmpty(goodsCategoryID)) {
				supplierPo.setBspcategoryid(request
						.getParameter("categoryID_open"));
			}
		} else if (StringUtils.isNotEmpty(request
				.getParameter("categoryID_open"))) {
			request.setAttribute("categoryID_open", Utility.getName(request
					.getParameter("categoryID_open")));

			if (StringUtils.isEmpty(goodsCategoryID)) {
				supplierPo.setBspcategoryid(request
						.getParameter("categoryID_open"));
			}
		}

		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("goodsCategoryID", goodsCategoryID);

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowsMgr.getSupplierCount(supplierPo);
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
			supplierList = windowsMgr.getSupplierList(supplierPo, page
					.getStart(), page.getPageSize());

			for (SupplierPo supplierPo : supplierList) {
				supplierPo.setBgcgoodscategoryname(supplierPo
						.getBgcgoodscategoryname());

				supplierPo.setBgcgoodscategoryname(supplierPo
						.getBspcategoryid().replaceFirst("[1]", "镜架")
						.replaceFirst("[2]", "配件")
						.replaceFirst("[3]", "镜片")
						.replaceFirst("[4]", "隐形")
						.replaceFirst("[5]","护理液")
						.replaceFirst("[6]", "太阳镜")
						.replaceFirst("[7]", "耗材")
						.replaceFirst("[8]", "老花镜")
						.replaceFirst("[9]", "视光")
				);
			}
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			supplierList = null;
		}

		goodsCategorys = windowsMgr.getGoodsCategorys();

		return SUCCESS;
	}
	/**
	 * 查询商品批发二维表
	 * @return
	 * @throws Exception
	 */
	public String selgalessDWOpen() throws Exception {
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
		request.setAttribute("goodsCategoryID", request.getParameter("categoryID"));
		request.setAttribute("supplierName", request.getParameter("supplierName"));
		request.setAttribute("supplierID", request.getParameter("supplierID"));
		request.setAttribute("brandName", request.getParameter("brandName"));
		request.setAttribute("brandID", request.getParameter("brandID"));
		if(!"".equals(Utility.getName(request.getParameter("ishide")))){
			request.setAttribute("ishide", request.getParameter("ishide"));
		}
		if(!"".equals(Utility.getName(request.getParameter("whichretail")))){
			request.setAttribute("whichretail", request.getParameter("whichretail"));
		}else{
			request.setAttribute("whichretail", "1");
		}
		
		if("0".equals(Utility.getName(permissionPo.getKeyf()))||"".equals(Utility.getName(permissionPo.getKeyf()))){
			if("Wholesale".equals(Utility.getName(request.getParameter("justType")))){
				return "Wholesale";//批发
			}
			return "Retail";
		}
		
		//跳转判断 brgin
		if(!"".equals(Utility.getName(request.getParameter("justType")))){
			if("Retail".equals(Utility.getName(request.getParameter("justType")))){
				return "Retail";//零售
			}
			if("Wholesale".equals(Utility.getName(request.getParameter("justType")))){
				return "Wholesale";//批发
			}
			if("Cost".equals(Utility.getName(request.getParameter("justType")))){
				return "Cost";//成本
			}
		}
		//跳转判断 end
		return SUCCESS;
	}
	
	public String selBrandOpen() throws Exception {
		BrandPo brandPo = new BrandPo();
		brandPo.setBbdid(request.getParameter("selbbdid"));
		brandPo.setBbdbrandname(request.getParameter("selbbdbrandname"));
		brandPo.setBspcategoryid(request.getParameter("selbspcategoryid"));
		brandPo.setBspsuppliername(request.getParameter("selbspsuppliername"));
		brandPo.setBbdsupplierid(request.getParameter("selbbdsupplierid"));

		String selbspcategoryid = brandPo.getBspcategoryid();
		String selbbdsupplierid = brandPo.getBbdsupplierid();
		String selbspsuppliername = brandPo.getBspsuppliername();

		String isclosed = Utility.getName(request.getParameter("isclosed"));
		request.setAttribute("isclosed",isclosed);
		brandPo.setBbdsalesstatue(isclosed);
		
		// 查询条件限制
		if (!"".equals(Utility.getName(request.getParameter("categoryID_open")))) {
			brandPo.setBspcategoryid(Utility.getName(request.getParameter("categoryID_open")));

			selbspcategoryid = brandPo.getBspcategoryid();

			request.setAttribute("categoryID_open", brandPo.getBspcategoryid());
		}
		// 制造商条件限制
		if (!"".equals(Utility.getName(request.getParameter("supplierID_open")))) {
			brandPo.setBbdsupplierid(Utility.getName(request.getParameter("supplierID_open")));

			selbbdsupplierid = brandPo.getBbdsupplierid();

			SupplierPo po = new SupplierPo();
			po.setBspid(selbbdsupplierid);

			po = windowsMgr.getSupplier(po);

			selbspsuppliername = po.getBspsuppliername();

			request.setAttribute("supplierID_open", brandPo.getBbdsupplierid());
		}

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowsMgr.getBrandsCount(brandPo);

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

			brands = windowsMgr.getBrands(brandPo, page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		}

		goodsCategorys = windowsMgr.getGoodsCategorys();
		//库存预警设置新增
		if("0".equals(request.getParameter("arg0"))){
			for(int i=0;i<goodsCategorys.size();i++){
				if("1".equals(goodsCategorys.get(i).getBgcid())){
					goodsCategorys.remove(i);
				}
				if("2".equals(goodsCategorys.get(i).getBgcid())){
					goodsCategorys.remove(i);
				}
				if("5".equals(goodsCategorys.get(i).getBgcid())){
					goodsCategorys.remove(i);
				}
				if("6".equals(goodsCategorys.get(i).getBgcid())){
					goodsCategorys.remove(i);
				}
				if("7".equals(goodsCategorys.get(i).getBgcid())){
					goodsCategorys.remove(i);
				}
				if("8".equals(goodsCategorys.get(i).getBgcid())){
					goodsCategorys.remove(i);
				}
				if("9".equals(goodsCategorys.get(i).getBgcid())){
					goodsCategorys.remove(i);
				}
			}
		}
		
		if("1".equals(request.getParameter("arg0"))){
			for(int i=0;i<goodsCategorys.size();i++){
				if("3".equals(goodsCategorys.get(i).getBgcid())){
					goodsCategorys.remove(i);
				}
				if("4".equals(goodsCategorys.get(i).getBgcid())){
					goodsCategorys.remove(i);
				}
			}
		}
			
		request.setAttribute("selbbdid", request.getParameter("selbbdid"));
		request.setAttribute("selbbdbrandname", request.getParameter("selbbdbrandname"));
		request.setAttribute("selbspcategoryid", selbspcategoryid);
		request.setAttribute("selbbdsupplierid", selbbdsupplierid);
		request.setAttribute("selbspsuppliername", selbspsuppliername);
		request.setAttribute("arg0", request.getParameter("arg0"));
		
		request.setAttribute("showhider", Utility.getName(request.getParameter("showhider")));
		
		return SUCCESS;
	}
	
	public String initSelBrandOpenWithoutSupplier() throws Exception {
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		goodsCategorys = windowsMgr.getGoodsCategorys();
		
		String categoryID_open=Utility.getName(request.getParameter("categoryID_open"));
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		request.setAttribute("categoryID_open", categoryID_open);
		request.setAttribute("showhider", Utility.getName(request.getParameter("showhider")));

		return SUCCESS;
	}
	
	public String selBrandOpenWithoutSupplier() throws Exception {
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierid = Utility.getName(request.getParameter("supplierid"));
		String suppliername = Utility.getName(request.getParameter("suppliername"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String whichretail = Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		String bgiretailbeginprice = Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice = Utility.getName(request.getParameter("bgiretailendprice"));
		
		if (!"".equals(Utility.getName(request.getParameter("categoryID_open")))) {
			goodscategoryID = request.getParameter("categoryID_open");

			request.setAttribute("categoryID_open", request.getParameter("categoryID_open"));
		}
		
		for(int i=0; i<7; i++){
			if(brandID.length()<7){
				brandID = brandID + " ";
			}
		}
		BrandPo brandPo=new BrandPo();
		brandPo.setBspcategoryid(goodscategoryID);
		brandPo.setBbdsupplierid(brandID.substring(2, 4));
		brandPo.setBbdid(brandID.substring(5, 7));
		brandPo.setBbdwhichretail(whichretail);
		brandPo.setBbdismendretail(select_retail);
		brandPo.setBbdminretailPrice(bgiretailbeginprice);
		brandPo.setBbdmaxretailPrice(bgiretailendprice);
		brandPo.setBbdbrandname(brandName);
		
		int count = windowGoodsMgr.getBrandPriceCount(brandPo);

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

			brandlist = windowGoodsMgr.getBrandPriceList(brandPo, page.getStart(), page
					.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		}
		
		
		goodsCategorys = windowsMgr.getGoodsCategorys();
		
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("brandID", brandID.trim());
		request.setAttribute("brandName", brandName);		
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);

		return SUCCESS;
	}
	
	public String initSelPrintBrandOpen() throws Exception {
		goodsCategorys = windowsMgr.getGoodsCategorys();
		request.setAttribute("showhider", Utility.getName(request.getParameter("showhider")));
		return SUCCESS;
	}
	
	public String selPrintBrandOpen() throws Exception {
		BrandPo brandPo = new BrandPo();
		brandPo.setBbdid(request.getParameter("selbbdid"));
		brandPo.setBbdbrandname(request.getParameter("selbbdbrandname"));
		brandPo.setBspcategoryid(request.getParameter("selbspcategoryid"));
		brandPo.setBspsuppliername(request.getParameter("selbspsuppliername"));
		brandPo.setBbdsupplierid(request.getParameter("selbbdsupplierid"));

		String selbspcategoryid = brandPo.getBspcategoryid();
		String selbbdsupplierid = brandPo.getBbdsupplierid();
		String selbspsuppliername = brandPo.getBspsuppliername();

		// 查询条件限制
		if (!"".equals(Utility.getName(request.getParameter("categoryID_open")))) {
			brandPo.setBspcategoryid(Utility.getName(request.getParameter("categoryID_open")));

			selbspcategoryid = brandPo.getBspcategoryid();

			request.setAttribute("categoryID_open", brandPo.getBspcategoryid());
		}
		// 制造商条件限制
		if (!"".equals(Utility.getName(request.getParameter("supplierID_open")))) {
			brandPo.setBbdsupplierid(Utility.getName(request.getParameter("supplierID_open")));

			selbbdsupplierid = brandPo.getBbdsupplierid();

			SupplierPo po = new SupplierPo();
			po.setBspid(selbbdsupplierid);

			po = windowsMgr.getSupplier(po);

			selbspsuppliername = po.getBspsuppliername();

			request.setAttribute("supplierID_open", brandPo.getBbdsupplierid());
		}

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowsMgr.getBrandsCount(brandPo);

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

			brands = windowsMgr.selectPrintBrandPo(brandPo, page.getStart(), page
					.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		}

		goodsCategorys = windowsMgr.getGoodsCategorys();
		//库存预警设置新增
		if("0".equals(request.getParameter("arg0"))){
			for(int i=0;i<goodsCategorys.size();i++){
				if("1".equals(goodsCategorys.get(i).getBgcid())){
					goodsCategorys.remove(i);
				}
				if("2".equals(goodsCategorys.get(i).getBgcid())){
					goodsCategorys.remove(i);
				}
				if("5".equals(goodsCategorys.get(i).getBgcid())){
					goodsCategorys.remove(i);
				}
				if("6".equals(goodsCategorys.get(i).getBgcid())){
					goodsCategorys.remove(i);
				}
				if("7".equals(goodsCategorys.get(i).getBgcid())){
					goodsCategorys.remove(i);
				}
				if("8".equals(goodsCategorys.get(i).getBgcid())){
					goodsCategorys.remove(i);
				}
				if("9".equals(goodsCategorys.get(i).getBgcid())){
					goodsCategorys.remove(i);
				}
			}
		}
		
		if("1".equals(request.getParameter("arg0"))){
			for(int i=0;i<goodsCategorys.size();i++){
				if("3".equals(goodsCategorys.get(i).getBgcid())){
					goodsCategorys.remove(i);
				}
				if("4".equals(goodsCategorys.get(i).getBgcid())){
					goodsCategorys.remove(i);
				}
			}
		}
			
		request.setAttribute("selbbdid", request.getParameter("selbbdid"));
		request.setAttribute("selbbdbrandname", request
				.getParameter("selbbdbrandname"));
		request.setAttribute("selbspcategoryid", selbspcategoryid);
		request.setAttribute("selbbdsupplierid", selbbdsupplierid);
		request.setAttribute("selbspsuppliername", selbspsuppliername);
		request.setAttribute("arg0", request.getParameter("arg0"));
		
		request.setAttribute("showhider", Utility.getName(request.getParameter("showhider")));
		
		return SUCCESS;
	}

	public String selVarietyOpen() throws Exception {

		VarietyPo varietyPo = new VarietyPo();
		varietyPo.setBvyid(Utility.getName(request.getParameter("selbvyid")));
		varietyPo.setBvyvarietyname(Utility.getName(request
				.getParameter("selbvyvarietyname")));
		varietyPo.setBvybrandid(Utility.getName(request
				.getParameter("selbvybrandid")));
		varietyPo.setBvysupplierid(Utility.getName(request
				.getParameter("selsupplierID")));
		varietyPo.setBvygcid(Utility
				.getName(request.getParameter("selbvygcid")));

		String selbspcategoryid = varietyPo.getBvygcid();
		String selbbdsupplierid = varietyPo.getBvysupplierid();
		String selbvybrandid = varietyPo.getBvybrandid();
		String selbbdbrandname = varietyPo.getBvybrandid();

		// 查询条件限制
		if (!""
				.equals(Utility
						.getName(request.getParameter("categoryID_open")))) {
			varietyPo.setBvygcid(Utility.getName(request
					.getParameter("categoryID_open")));

			selbspcategoryid = varietyPo.getBvygcid();

			request.setAttribute("categoryID_open", varietyPo.getBvygcid());
		}

		// 制造商条件限制
		if (!""
				.equals(Utility
						.getName(request.getParameter("supplierID_open")))) {
			varietyPo.setBvysupplierid(Utility.getName(request
					.getParameter("supplierID_open")));

			selbbdsupplierid = varietyPo.getBvysupplierid();

			request.setAttribute("supplierID_open", selbbdsupplierid);
		}

		// 品种条件限制
		if (!"".equals(Utility.getName(request.getParameter("brandID_open")))) {
			varietyPo.setBvybrandid(Utility.getName(request
					.getParameter("brandID_open")));

			selbvybrandid = varietyPo.getBvybrandid();

			BrandPo temp = new BrandPo();
			temp.setBbdid(selbvybrandid);
			temp.setBbdsupplierid(selbbdsupplierid);

			temp = windowsMgr.getBrandPo(temp);

			selbbdbrandname = temp.getBbdbrandname();

			request.setAttribute("brandID_open", varietyPo.getBvybrandid());
		}

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowsMgr.getVarietysCount(varietyPo);

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

			varietys = windowsMgr.getVarietys(varietyPo, page.getStart(), page
					.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		}

		goodsCategorys = windowsMgr.getGoodsCategorys();

		request.setAttribute("selbvyid", Utility.getName(request
				.getParameter("selbvyid")));
		request.setAttribute("selbvyvarietyname", request
				.getParameter("selbvyvarietyname"));
		request.setAttribute("selsupplierID", selbbdsupplierid);
		request.setAttribute("selbvybrandid", selbvybrandid);
		request.setAttribute("selbrandName", selbbdbrandname);
		request.setAttribute("selbvygcid", selbspcategoryid);

		return SUCCESS;
	}

	/**
	 * 初始化客户开窗
	 */
	public String initCustomerOpen() throws Exception {

		return SUCCESS;
	}

	/**
	 * 查询客户开窗
	 */
	public String selCustomerOpen() throws Exception {

		String customerName = Utility.getName(request
				.getParameter("customerName"));
		CustomerPo customerPo = new CustomerPo();
		customerList = customerMgr.getCustomerList(customerPo);
		request.setAttribute("customerName", customerName);
		return SUCCESS;
	}

	/**
	 * 初始化部门查询开窗
	 * @return
	 * @throws Exception
	 */
	public String initDepartmentOpen() throws Exception{
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String mm = Utility.getName(request.getParameter("mm"));
		String departmentType = Utility.getName(request.getParameter("departmentType"));
		String isclosed = Utility.getName(request.getParameter("isclosed"));
		String companyid = Utility.getName(request.getParameter("companyid"));
		String readonlyopen = Utility.getName(request.getParameter("readonlyopen"));
		
		request.setAttribute("departmentType",departmentType);
		request.setAttribute("isclosed", isclosed);
		request.setAttribute("companyid", companyid);
		request.setAttribute("readonlyopen", readonlyopen);
		
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2") || readonlyopen.equals("1")){
			CompanyNamePo tcpo = new CompanyNamePo();
			tcpo.setFcnId(companyid);
			
			CompanyNamePo cpo = companyNameMgr.getCompanyName(tcpo);
			request.setAttribute("cpo", cpo);
		}else{
			List<CompanyNamePo> cpos = companyNameMgr.getCompanyNameForSelect(null);
			request.setAttribute("cpos", cpos);
		}
		
		if(mm.equals("1")){
			return "onlydept";
		}
		else{
			return SUCCESS;
		}		
		
	}
	
	/**
	 * 初始化仓位查询开窗
	 * @return
	 * @throws Exception
	 */
	public String initWarehouseOpen() throws Exception 
	{
		
		if(!"".equals(Utility.getName(request.getParameter("justType")))){
			if("1".equals(Utility.getName(request.getParameter("justType")))){
				request.setAttribute("justType", request.getParameter("justType"));
				return "wd1";
			}
		}
		return SUCCESS;
	}
	
	/**
	 * 部门查询开窗
	 * @return
	 * @throws Exception
	 */
	public String selDepartmentOpen() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String bdpdepartmentid = Utility.getName(request.getParameter("bdpdepartmentid"));
		String bdpdepartmentname = Utility.getName(request.getParameter("bdpdepartmentname"));
		String dpttype = Utility.getName(request.getParameter("bdptype"));
		String departmentType = Utility.getName(request.getParameter("departmentType"));
		String isclosed = Utility.getName(request.getParameter("isclosed"));
		String companyid = Utility.getName(request.getParameter("companyid"));
		String readonlyopen = Utility.getName(request.getParameter("readonlyopen"));
		
		if(!"".equals(departmentType)){
			dpttype = departmentType;
		}
		
		DepartmentsPo departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(bdpdepartmentid);
		departmentsPo.setBdpdepartmentname(bdpdepartmentname);
		departmentsPo.setBdptype(dpttype);
		departmentsPo.setBdpisclosed(isclosed);
		departmentsPo.setBdpcompanysid(companyid);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			departmentsPo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		request.setAttribute("departmentID", bdpdepartmentid);
		request.setAttribute("departmentName", bdpdepartmentname);
		request.setAttribute("departmentType", departmentType);
		request.setAttribute("dpttype", dpttype);
		request.setAttribute("isclosed", isclosed);
		request.setAttribute("companyid", companyid);
		request.setAttribute("readonlyopen", readonlyopen);
		
		CompanyNamePo tcpo = new CompanyNamePo();
		
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2") || readonlyopen.equals("1")){
			if (companyid.equals("")){
				tcpo.setFcnId(personInfoPo.getPersoncompanyid());
			}else{
				tcpo.setFcnId(companyid);
			}			
			
			CompanyNamePo cpo = companyNameMgr.getCompanyName(tcpo);
			request.setAttribute("cpo", cpo);
		}else{
			List<CompanyNamePo> cpos = companyNameMgr.getCompanyNameForSelect(null);
			request.setAttribute("cpos", cpos);
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = departmentsMgr.getDepartmentCount(departmentsPo);
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
			departmentList = departmentsMgr.getDepartmentList(departmentsPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			departmentList = null;
		}
		
		String mm= Utility.getName(request.getParameter("mm"));
		if(mm.equals("1"))
		{
			return "onlydept";
		}
		else
		{
			return SUCCESS;
		}
	}
	/**
	 * 初始化部门查询开窗
	 * @return
	 * @throws Exception
	 */
	public String initDepartmentOpen2() throws Exception{
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String mm = Utility.getName(request.getParameter("mm"));
		String departmentType = Utility.getName(request.getParameter("departmentType"));
		String isclosed = Utility.getName(request.getParameter("isclosed"));
		request.setAttribute("departmentType",departmentType);
		request.setAttribute("isclosed", isclosed);
		
		return SUCCESS;
		
		
	}
	/**
	 * 部门查询开窗
	 * @return
	 * @throws Exception
	 */
	public String selDepartmentOpen2() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String bdpdepartmentid = Utility.getName(request.getParameter("bdpdepartmentid"));
		String bdpdepartmentname = Utility.getName(request.getParameter("bdpdepartmentname"));
		String dpttype = Utility.getName(request.getParameter("bdptype"));
		String departmentType = Utility.getName(request.getParameter("departmentType"));
		String isclosed = Utility.getName(request.getParameter("isclosed"));
		
		if(!"".equals(departmentType)){
			dpttype = departmentType;
		}
		
		DepartmentsPo departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(bdpdepartmentid);
		departmentsPo.setBdpdepartmentname(bdpdepartmentname);
		departmentsPo.setBdptype(dpttype);
		departmentsPo.setBdpisclosed(isclosed);
		
		request.setAttribute("departmentID", bdpdepartmentid);
		request.setAttribute("departmentName", bdpdepartmentname);
		request.setAttribute("departmentType", departmentType);
		request.setAttribute("dpttype", dpttype);
		request.setAttribute("isclosed", isclosed);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = departmentsMgr.getDepartmentCount(departmentsPo);
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
			departmentList = departmentsMgr.getDepartmentList(departmentsPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			departmentList = null;
		}
		
		String mm= Utility.getName(request.getParameter("mm"));

		return SUCCESS;

	}
	/**
	 * 仓位查询开窗
	 * @return
	 * @throws Exception
	 */
	public String selWarehouseOpen() throws Exception {
		String warehouseid = Utility.getName(request.getParameter("warehouseid"));
		String warehousename = Utility.getName(request.getParameter("warehousename"));
		String departmentIDout=Utility.getName(request.getParameter("departmentID"));
		request.setAttribute("warehouseid", warehouseid);
		request.setAttribute("warehousename", warehousename);
		request.setAttribute("departmentIDout", departmentIDout);
		request.setAttribute("ds", request.getParameter("ds"));
		WarehousePo warehousePo = new WarehousePo();
		warehousePo.setBwhid(warehouseid);
		warehousePo.setBwhwarehouseName(warehousename);
		warehousePo.setBwhdeptid(departmentIDout);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = warehouseMgr.getWarehouseCount(warehousePo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, count, perPage);
			warehousePos = warehouseMgr.getWarehouseList(warehousePo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			warehousePos = null;
		}
		
		request.setAttribute("showhider", Utility.getName(request.getParameter("showhider")));
		if(!"".equals(Utility.getName(request.getParameter("justType")))){
			if("1".equals(Utility.getName(request.getParameter("justType")))){
				request.setAttribute("justType", request.getParameter("justType"));
				return "Warehouse1";
			}
		}
		return SUCCESS;
	}
	
	/**
	 * 初始化在途点维护页面
	 * @return
	 * @throws Exception
	 */
	public String initInTransitQuery() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		inTransitList = windowsMgr.selectInTransit();
		
		return SUCCESS;
	}
	
	/**
	 * 初始化在途点停用启用
	 * @return
	 * @throws Exception
	 */
	public String initEnabledInTransit() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String inTransitID = Utility.getName(request.getParameter("inTransitID"));
		String inTransitName = Utility.getName(request.getParameter("inTransitName"));
		String flag = Utility.getName(request.getParameter("flag"));
		
		request.setAttribute("inTransitID",inTransitID);
		request.setAttribute("inTransitName",inTransitName);
		request.setAttribute("flag",flag);
		
		return SUCCESS;
	}
	
	/**
	 * 在途点停用启用
	 * @return
	 * @throws Exception
	 */
	public String enabledInTransit() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String inTransitID = Utility.getName(request.getParameter("inTransitID"));
		String inTransitName = Utility.getName(request.getParameter("inTransitName"));
		String flag = Utility.getName(request.getParameter("flag"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID);
		logPo.setsLogOpID("3");
		logPo.setsLogContent("配镜单在途：" + inTransitName + (flag.equals("0")? "停用 !" : "启用!"));
		
		windowsMgr.updateEnabledInTransit(flag, inTransitID);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public String initScanBarcode()throws Exception{
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String categoryid = request.getParameter(Utility.getName("categoryid"));
		String jm = request.getParameter(Utility.getName("jm"));
		String outstockid = request.getParameter(Utility.getName("outstockid"));
		
		request.setAttribute("categoryid", categoryid);
		request.setAttribute("outstockid", outstockid);
		request.setAttribute("jm", jm);
		
		String indptid = request.getParameter(Utility.getName("indptid"));
		request.setAttribute("indptid", indptid);
		
		return SUCCESS;
	}
	
	public String scanBarcode()throws Exception{
		String scancode = Utility.getName(request.getParameter("scancode"));
		String jm = request.getParameter(Utility.getName("jm"));
		String outstockid = request.getParameter(Utility.getName("outstockid"));
		
		request.setAttribute("outstockid", outstockid);
		String categoryid = request.getParameter(Utility.getName("categoryid"));
		
		request.setAttribute("categoryid", categoryid);
		request.setAttribute("jm", jm);
				
		String indptid = request.getParameter(Utility.getName("indptid"));
		request.setAttribute("indptid", indptid);
		
		GoodsInfoPo tpo = new GoodsInfoPo();
		tpo.setBgigoodsbarcode(scancode);
		tpo.setBgijm(jm);
		tpo.setBgiwarehouseid(outstockid);
		tpo.setBgigoodscategoryid(scancode.substring(0, 1));
		tpo.setBgidepartmentid(indptid);
		
		GoodsInfoPo goodsInfoPo = windowsMgr.getGoodsInfoPo(tpo);
		
		if("".equals(Utility.getName(goodsInfoPo.getBgigoodsid()))){
			goodsInfoPo.setBgigoodsid("nofound");
		}
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("scancode", scancode);
		request.setAttribute("goodsInfoPo", goodsInfoPo);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化价格区间查询（报表）
	 * @return
	 * @throws Exception
	 */
	public String initSalesAreaOpen() throws Exception{
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
		
		request.setAttribute("",Utility.getName(request.getParameter("reportID")));
		goodsCategoryList = supplierMgr.getGoodsCategoryList();
		String goodsCategoryID = Utility.getName(request.getParameter("goodsCategoryID"));
		String typeID = Utility.getName(request.getParameter("typeID"));
		String salesTypeID = Utility.getName(request.getParameter("salesTypeID"));
		
		if("".equals(goodsCategoryID) && "".equals(salesTypeID)) {
			typeID = "1";
			goodsCategoryID = "1";
		}
		if("".equals(goodsCategoryID) && !"".equals(salesTypeID)) {
			typeID = "2";
			goodsCategoryID = null;
		}
		if(!"".equals(goodsCategoryID) && "".equals(salesTypeID)) {
			typeID = "1";
			salesTypeID = null;
		}
		
		request.setAttribute("goodsCategoryID", goodsCategoryID);
		request.setAttribute("typeID", typeID);
		request.setAttribute("salesTypeID", salesTypeID);
		
		return SUCCESS;
	}
	
	/**
	 * 价格区间查询（报表）
	 * @return
	 * @throws Exception
	 */
	public String salesAreaOpen() throws Exception{
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
		
//		String reportID = Utility.getName(request.getParameter("reportID"));
//		String bgnPrice = Utility.getName(request.getParameter("bgnPrice"));
//		String endPrice = Utility.getName(request.getParameter("endPrice"));
//		
//		request.setAttribute("reportID",reportID);
//		request.setAttribute("bgnPrice",bgnPrice);
//		request.setAttribute("endPrice",endPrice);		
//		
//		salesAreaPo = new SalesAreaPo();
//		salesAreaPo.setRsareportid(reportID);
//		salesAreaPo.setRsapricemin(bgnPrice);
//		salesAreaPo.setRsapricemax(endPrice);

		goodsCategoryList = supplierMgr.getGoodsCategoryList();
		String goodsCategoryID = Utility.getName(request.getParameter("goodsCategoryID"));
		String typeID = Utility.getName(request.getParameter("typeID"));
		String salesTypeID = Utility.getName(request.getParameter("salesTypeID"));
		

		if("".equals(goodsCategoryID) && "".equals(salesTypeID)) {
			typeID = "1";
			goodsCategoryID = "1";
		}
		if("".equals(goodsCategoryID) && !"".equals(salesTypeID)) {
			typeID = "2";
			goodsCategoryID = null;
		}
		if(!"".equals(goodsCategoryID) && "".equals(salesTypeID)) {
			typeID = "1";
			salesTypeID = null;
		}
		
		salesAreaList = windowsMgr.selectSalesAreaListAllByGoodsCategoryID(goodsCategoryID, typeID, salesTypeID);

		request.setAttribute("goodsCategoryID", goodsCategoryID);
		request.setAttribute("typeID", typeID);
		request.setAttribute("salesTypeID", salesTypeID);
		
		return SUCCESS;
	}

	public SupplierMgr getSupplierMgr() {
		return supplierMgr;
	}

	public void setSupplierMgr(SupplierMgr supplierMgr) {
		this.supplierMgr = supplierMgr;
	}

	public List<GoodsCategoryPo> getGoodsCategoryList() {
		return goodsCategoryList;
	}

	public void setGoodsCategoryList(List<GoodsCategoryPo> goodsCategoryList) {
		this.goodsCategoryList = goodsCategoryList;
	}
	/**
	 * 部门查询开窗
	 * @return
	 * @throws Exception
	 */
	public String selDepartmentInOrOutStorageOpen() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String bdpdepartmentid = Utility.getName(request.getParameter("bdpdepartmentid"));
		String bdpdepartmentname = Utility.getName(request.getParameter("bdpdepartmentname"));
		String dpttype = Utility.getName(request.getParameter("bdptype"));
		String departmentType = Utility.getName(request.getParameter("departmentType"));
		String isclosed = Utility.getName(request.getParameter("isclosed"));
		
		if(!"".equals(departmentType)){
			dpttype = departmentType;
		}
		
		DepartmentsPo departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(bdpdepartmentid);
		departmentsPo.setBdpdepartmentname(bdpdepartmentname);
		departmentsPo.setBdptype(dpttype);
		departmentsPo.setBdpisclosed(isclosed);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			departmentsPo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		request.setAttribute("departmentID", bdpdepartmentid);
		request.setAttribute("departmentName", bdpdepartmentname);
		request.setAttribute("departmentType", departmentType);
		request.setAttribute("dpttype", dpttype);
		request.setAttribute("isclosed", isclosed);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = departmentsMgr.getDepartmentCount(departmentsPo);
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
			departmentList = departmentsMgr.getDepartmentList(departmentsPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			departmentList = null;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 查询商品批发二维表
	 * @return
	 * @throws Exception
	 */
	public String selectGoodsPriceChange() throws Exception {
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
		request.setAttribute("goodsCategoryID", request.getParameter("categoryID"));
		request.setAttribute("supplierName", request.getParameter("supplierName"));
		request.setAttribute("supplierID", request.getParameter("supplierID"));
		request.setAttribute("brandName", request.getParameter("brandName"));
		request.setAttribute("brandID", request.getParameter("brandID"));
		//跳转判断 brgin
		if(!"".equals(Utility.getName(request.getParameter("justType")))){
			if("Retail".equals(Utility.getName(request.getParameter("justType")))){
				return "Retail";//零售
			}
			if("Wholesale".equals(Utility.getName(request.getParameter("justType")))){
				return "Wholesale";//批发
			}
			if("Cost".equals(Utility.getName(request.getParameter("justType")))){
				return "Cost";//成本
			}
		}
		//跳转判断 end
		return SUCCESS;
	}
	/**
	 * 人员查询开窗
	 * @return
	 * @throws Exception
	 */
	public String initPrePersonSalesOpen() throws Exception {
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
		// 取得所有角色
		roles = personInfoMgr.getRoles();
		
		return SUCCESS;
	}	
	/**
	 * 人员查询开窗
	 * @return
	 * @throws Exception
	 */
	public String selPrePersonSalesOpen() throws Exception {
		
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

		PersonInfoPo personInfo = new PersonInfoPo();
		personInfo.setId(request.getParameter("selId"));
		personInfo.setPersonName(request.getParameter("selPersonName"));
		personInfo.setDepartmentID(request.getParameter("selDepartmentID"));
		personInfo.setRoleid(request.getParameter("selRoleid"));
		personInfo.setIsinvocation(request.getParameter("isinvocation"));

		// 取得所有角色
		roles = personInfoMgr.getRoles();

		// 取所有部门
		departments = departmentsMgr.getDepartments();

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
		
		int count = personInfoMgr.getPersoninfosCount2(personInfo);
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
			persons = personInfoMgr.getPersonInfos2(personInfo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));

		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		request.setAttribute("selId", request.getParameter("selId"));
		request.setAttribute("selPersonName", request
				.getParameter("selPersonName"));
		request.setAttribute("selDepartmentID", request
				.getParameter("selDepartmentID"));
		request.setAttribute("selDepartmentName", Utility.getName(request.getParameter("selDepartmentName")));
		request.setAttribute("selRoleid", request.getParameter("selRoleid"));
		request.setAttribute("isinvocation", request.getParameter("isinvocation"));
		
		return SUCCESS;
	}	
	
	/**
	 * 部门查询开窗
	 * @return
	 * @throws Exception
	 */
	public String selMemberTypeOpen() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		MemberManagementPo po = new MemberManagementPo();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());

		int count = memberManagementMgr.getMemberManagementCount(po);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}			
			Pagination page = new Pagination(request, count, perPage);
			memberManagementlist = memberManagementMgr.getMemberList(po, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);			
		} else {			
			memberManagementlist = null;		
		}

		return SUCCESS;

	}
	
	public String selPersonOpen() {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		PersonInfoPo personInfo = new PersonInfoPo();
		personInfo.setId(request.getParameter("selId"));
		personInfo.setPersonName(request.getParameter("selPersonName"));
		personInfo.setRoleid(request.getParameter("selRoleid"));
		personInfo.setIsinvocation(request.getParameter("isinvocation"));
		personInfo.setDepartmentID(request.getParameter("selDepartmentID"));	
		personInfo.setSex(request.getParameter("selsex"));
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			personInfo.setPersoncompanyid(personInfoPo1.getPersoncompanyid());
		}
		
		RolePo rpo = new RolePo();
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			rpo.setRolecompanyid(personInfoPo1.getPersoncompanyid());
		}
		roles = personInfoMgr.getRolesByCompanyType(rpo);

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

		int count = personInfoMgr.getPersoninfosCount(personInfo);

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

			persons = personInfoMgr.getPersonInfos(personInfo, page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		}		

		request.setAttribute("selId", request.getParameter("selId"));
		request.setAttribute("selPersonName", request
				.getParameter("selPersonName"));
		request.setAttribute("selDepartmentID", request
				.getParameter("selDepartmentID"));
		request.setAttribute("selDepartmentName", Utility.getName(request.getParameter("selDepartmentName")));
		request.setAttribute("selRoleid", request.getParameter("selRoleid"));
		request.setAttribute("isinvocation", request.getParameter("isinvocation"));

		request.setAttribute("selsex", request.getParameter("selsex"));
		request.setAttribute("selzhigongtype", request.getParameter("selzhigongtype"));
		
		return SUCCESS;
	}	
	
	public String initScanGoodsID()throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		return SUCCESS;
	}
	
	public String scanGoodsID()throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
	
		String scancode = Utility.getName(request.getParameter("scancode")).substring(0, 18);
		
		GoodsInfoPo tpo = new GoodsInfoPo();
		tpo.setBgigoodsbarcode(scancode);
		goodsInfoPo = windowsMgr.getWholsGoodsInfoByScan(tpo);
		
		if (goodsInfoPo == null || Utility.getName(goodsInfoPo.getBgigoodsid()).equals("")){
			goodsInfoPo.setBgigoodsid("nofound");
		}
		
		request.setAttribute("scancode", Utility.getName(goodsInfoPo.getBgigoodsid()));
		
		return SUCCESS;
	}
	

}
