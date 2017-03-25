/**
 * 
 */
package com.pengsheng.eims.components.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.components.mgr.WindowGoodsMgr;
import com.pengsheng.eims.components.mgr.WindowInspectionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

/**
 * @author canying123initWindowInspectionNormalOpen.action
 * 
 */
public class WindowInspectionAction extends BaseAction {
	private GoodsInfoTempPo goodsInfoTempPo;
	
	private WindowInspectionMgr windowInspectionMgr;
	
	private GoodsInfoPo goodsInfoPo ;
	
	private List<GoodsInfoPo> goodsList;
	
	private SupplierMgr supplierMgr;
	
	private WindowGoodsMgr windowGoodsMgr;
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
	public SupplierMgr getSupplierMgr() {
		return supplierMgr;
	}
	public void setSupplierMgr(SupplierMgr supplierMgr) {
		this.supplierMgr = supplierMgr;
	}
	public WindowGoodsMgr getWindowGoodsMgr() {
		return windowGoodsMgr;
	}
	public void setWindowGoodsMgr(WindowGoodsMgr windowGoodsMgr) {
		this.windowGoodsMgr = windowGoodsMgr;
	}
	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}
	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}
	
	public WindowInspectionMgr getWindowInspectionMgr() {
		return windowInspectionMgr;
	}
	public void setWindowInspectionMgr(WindowInspectionMgr windowInspectionMgr) {
		this.windowInspectionMgr = windowInspectionMgr;
	}
	
	public GoodsInfoPo getGoodsInfoPo() {
		return goodsInfoPo;
	}
	
	public void setGoodsInfoPo(GoodsInfoPo goodsInfoPo) {
		this.goodsInfoPo = goodsInfoPo;
	}
	public List<GoodsInfoPo> getGoodsList() {
		return goodsList;
	}
	
	public void setGoodsList(List<GoodsInfoPo> goodsList) {
		this.goodsList = goodsList;
	}
	
	
	
 	public String selWindowInspectionNormalOpen(){
 		String supplierID=request.getParameter("supplierID");
 		String brandID=request.getParameter("brandID");
 		String brandName=request.getParameter("brandName");
 		String supplierName=request.getParameter("supplierName");
 		String glassType=request.getParameter("glassType");
 		String goodscategoryID=request.getParameter("goodscategoryID");
 		goodsInfoPo = new GoodsInfoPo();
 		goodsInfoPo.setBgisupplierid(supplierID);
 		goodsInfoPo.setBgibrandid(brandID);
 		goodsInfoPo.setBgibrandname(brandName);
 		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
 		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		int count=this.windowInspectionMgr.getWindowInspectionNormolCount(goodsInfoPo);
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
			goodsList = this.windowInspectionMgr.getWindowInspectionNormolList(goodsInfoPo,
					page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}		
		request.setAttribute("glassType", glassType);
		request.setAttribute("goodscategoryID",goodscategoryID);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("brandID",brandID);
		request.setAttribute("brandName",brandName);
		return SUCCESS;
	}
 	public String initWindowInspectionNormalOpen(){
 		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
 		String glassType=request.getParameter("glassType");
 		String goodscategoryID=request.getParameter("goodscategoryID");
 		String xzindex = request.getParameter("xzindex");
 		request.setAttribute("xzindex", xzindex);
 		request.setAttribute("glassType", glassType);
 		request.setAttribute("goodscategoryID", goodscategoryID);
 		return SUCCESS;
 	}
 	
 	public String initWindowInspectionOtherOpen(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
		
		request.setAttribute("departmenttype",personInfoPo.getDepartmenttype() );
		/** ********************** 权限设置 ***************************** */
		
 		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
 		String sopipballglass=request.getParameter("sopipballglass");
 		String sopippostglass=request.getParameter("sopippostglass");
 		String side=request.getParameter("side");
 		request.setAttribute("side", side);
 		request.setAttribute("sopipballglass", sopipballglass);
 		request.setAttribute("sopippostglass", sopippostglass);
 		String xzindex = request.getParameter("xzindex");
 		request.setAttribute("xzindex", xzindex); 		
 		String glassType=request.getParameter("glassType");
 		String goodscategoryID=request.getParameter("goodscategoryID");
 		request.setAttribute("glassType", glassType);
 		request.setAttribute("goodscategoryID", goodscategoryID);
 		return SUCCESS;
 	} 	
 	
 	public String selWindowInspectionOtherOpen(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
		
		request.setAttribute("departmenttype",personInfoPo.getDepartmenttype() );
		/** ********************** 权限设置 ***************************** */
		
 		String glassType=request.getParameter("glassType");
 		String goodscategoryID=request.getParameter("goodscategoryID");
 		String side=request.getParameter("side");
 		request.setAttribute("side", side);
 		String supplierID=request.getParameter("supplierID");
 		String supplierName=request.getParameter("supplierName");
 		
 		String brandID=request.getParameter("brandID");
 		String brandName=request.getParameter("brandName");
 		String goodsname=request.getParameter("goodsname");
 		String sopipballglass=request.getParameter("sopipballglass");
 		String sopippostglass=request.getParameter("sopippostglass");
 		String xzindex = request.getParameter("xzindex");
 		request.setAttribute("xzindex", xzindex);
 		goodsInfoPo = new GoodsInfoPo();
 		goodsInfoPo.setBgisupplierid(supplierID == null || supplierID.equals("") ? "" : supplierID);
 		goodsInfoPo.setBgibrandid(brandID == null || brandID.equals("") ? "" : brandID);
 		goodsInfoPo.setBgibrandname(brandName == null || brandName.equals("") ? "" : brandName);
 		goodsInfoPo.setBgigoodscategoryid(goodscategoryID); 		
 		goodsInfoPo.setBgisph(Utility.getName(sopipballglass));
 		goodsInfoPo.setBgicyl(Utility.getName(sopippostglass));
 		goodsInfoPo.setBgigoodsname(goodsname);
 		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		int count=this.windowInspectionMgr.getWindowInspectionOtherCount(goodsInfoPo);
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
			goodsList = this.windowInspectionMgr.getWindowInspectionOtherList(goodsInfoPo,page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}	
		
		request.setAttribute("glassType", glassType);
		request.setAttribute("goodscategoryID",goodscategoryID);
		request.setAttribute("supplierID",supplierID == null || supplierID.equals("") ? "" : supplierID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("brandID",brandID == null || brandID.equals("") ? "" : brandID);
		request.setAttribute("brandName",brandName == null || brandName.equals("") ? "" : brandName);
 		request.setAttribute("sopipballglass", sopipballglass);
 		request.setAttribute("sopippostglass", sopippostglass);
 		request.setAttribute("goodsname", goodsname);
		
		return SUCCESS;
 	}
 	
 	
 	public String initWindowInspectionStealOpen(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
		
		request.setAttribute("departmenttype",personInfoPo.getDepartmenttype() );
		/** ********************** 权限设置 ***************************** */
		
		String goodscategoryID=Utility.getName(request.getParameter("goodscategoryID"));
		String categoryID_open=Utility.getName(request.getParameter("categoryID_open"));
		String supplierID=Utility.getName(request.getParameter("supplierID_open"));
		String xzindex=Utility.getName(request.getParameter("xzindex"));
		String setwhich = Utility.getName(request.getParameter("setwhich"));
		String glassType = Utility.getName(request.getParameter("glassType"));
		
		if(!"".equals(Utility.getName(supplierID))){
			SupplierPo supplierPo=new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo=supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName",supplierPo.getBspsuppliername());
		}
		
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID_open",supplierID);
		request.setAttribute("categoryID_open",categoryID_open);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("xzindex",xzindex);
		request.setAttribute("setwhich",setwhich);
		request.setAttribute("glassType",glassType);
		
		return SUCCESS;
 	}
 	public String selWindowInspectionStealOpen(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
		
		request.setAttribute("departmenttype",personInfoPo.getDepartmenttype() );
		/** ********************** 权限设置 ***************************** */
		
 		String goodsID=Utility.getName(request.getParameter("goodsID"));
		String goodsName=Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID=Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID=Utility.getName(request.getParameter("supplierID"));
		String glassType=request.getParameter("glassType");
		request.setAttribute("glassType", glassType);
		String supplierName=Utility.getName(request.getParameter("supplierName"));
		String brandID=Utility.getName(request.getParameter("brandID"));
		String brandName=Utility.getName(request.getParameter("brandName"));
		String xzindex = Utility.getName(request.getParameter("xzindex"));
		String setwhich = Utility.getName(request.getParameter("setwhich"));
		String categoryID_open=Utility.getName(request.getParameter("categoryID_open"));
		
		request.setAttribute("setwhich",setwhich);
		request.setAttribute("xzindex", xzindex);
		request.setAttribute("supplierName",supplierName);		
		if ("".equals(goodscategoryID)) {			
			goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
			request.setAttribute("categoryID_open", goodscategoryID);
		}	
		if ("".equals(supplierID)) {			
			supplierID = Utility.getName(request.getParameter("supplierID_open"));
			if(!"".equals(Utility.getName(supplierID))){
				SupplierPo supplierPo=new SupplierPo();
				supplierPo.setBspid(supplierID);
				supplierPo=supplierMgr.getSupplier(supplierPo);
				request.setAttribute("supplierName",supplierPo.getBspsuppliername());
			}
			request.setAttribute("supplierID_open", supplierID);
		}		
		GoodsInfoPo goodsInfoPo=new GoodsInfoPo();
		
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgigoodscategoryid("5");
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		int count=windowGoodsMgr.getGoodsSingleCount(goodsInfoPo);
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
	    goodsList=windowGoodsMgr.getGoodsSingleList(goodsInfoPo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			goodsList = null;
		}		
		
		request.setAttribute("goodsID",goodsID);
		request.setAttribute("goodsName",goodsName);
		request.setAttribute("goodscategoryID",goodscategoryID);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("brandID",brandID);
		request.setAttribute("brandName",brandName);
		request.setAttribute("categoryID_open",categoryID_open);
		
		return SUCCESS;
 	}



}
