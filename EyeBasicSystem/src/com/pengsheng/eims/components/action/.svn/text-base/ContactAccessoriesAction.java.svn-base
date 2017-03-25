package com.pengsheng.eims.components.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.WarehouseConfigurationMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.components.mgr.ContactAccessoriesMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class ContactAccessoriesAction extends BaseAction {
	
	private ContactAccessoriesMgr contactAccessoriesMgr;
	
	private GoodsInfoPo goodsInfoPo;
	
	private List<GoodsInfoPo> contactList;
	
	private WarehouseConfigurationMgr warehouseConfigurationMgr;
	
	private WarehouseConfigurationPo po;
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
	public WarehouseConfigurationPo getPo() {
		return po;
	}

	public void setPo(WarehouseConfigurationPo po) {
		this.po = po;
	}

	public WarehouseConfigurationMgr getWarehouseConfigurationMgr() {
		return warehouseConfigurationMgr;
	}

	public void setWarehouseConfigurationMgr(
			WarehouseConfigurationMgr warehouseConfigurationMgr) {
		this.warehouseConfigurationMgr = warehouseConfigurationMgr;
	}

	public ContactAccessoriesMgr getContactAccessoriesMgr() {
		return contactAccessoriesMgr;
	}

	public void setContactAccessoriesMgr(ContactAccessoriesMgr contactAccessoriesMgr) {
		this.contactAccessoriesMgr = contactAccessoriesMgr;
	}

	public GoodsInfoPo getGoodsInfoPo() {
		return goodsInfoPo;
	}

	public void setGoodsInfoPo(GoodsInfoPo goodsInfoPo) {
		this.goodsInfoPo = goodsInfoPo;
	}

	public List<GoodsInfoPo> getContactList() {
		return contactList;
	}

	public void setContactList(List<GoodsInfoPo> contactList) {
		this.contactList = contactList;
	}

	/**
	 * 初始化辅料中隐形辅料开窗
	 * @return
	 */
	public String initContactAccessoriesSel(){
		
		return SUCCESS;
	}
	
	/**
	 * 查询隐形辅料商品
	 * @return
	 */
	public String selectContactAccessories(){
		
		//得到当前登录人的部门  根据部门取出仓位
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		String departmentId = personInfoPo.getDepartmentID();
		
		po=new WarehouseConfigurationPo();
		po.setBwcdeptid(departmentId);
		
		po = warehouseConfigurationMgr.getWarehouseConfiguration(po);
		
		String goodsId=Utility.getName(request.getParameter("goodsId"));
		String goodsName=Utility.getName(request.getParameter("goodsName"));
		String supplierId=Utility.getName(request.getParameter("supplierId"));
		String brandId=Utility.getName(request.getParameter("brandId"));
		
		String supplierName=Utility.getName(request.getParameter("supplierName"));
		String brandName=Utility.getName(request.getParameter("brandName"));
		
		goodsInfoPo=new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(goodsId);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgisupplierid(supplierId);
		goodsInfoPo.setBgibrandid(brandId);
		goodsInfoPo.setBgisuppliername(supplierName);
		goodsInfoPo.setBgibrandname(brandName);
		goodsInfoPo.setBgiwarehouseid(po.getBwcstockid5());
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		//查询及分页
		int count = contactAccessoriesMgr.getContactAccessoriesCount(goodsInfoPo);
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
			contactList=contactAccessoriesMgr.contactAccessoriesList(goodsInfoPo , page.getStart() , page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			contactList = null;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 根据商品条码查询商品
	 * @return
	 */
	public String selectContactByGoodsbarcode(){
		
		//得到当前登录人的部门  根据部门取出仓位
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		String departmentId = personInfoPo.getDepartmentID();
		
		po=new WarehouseConfigurationPo();
		po.setBwcdeptid(departmentId);
		
		po = warehouseConfigurationMgr.getWarehouseConfiguration(po);
		
		request.setAttribute("pcBarcode", Utility.getName(request.getParameter("bgigoodsbarcode")));
		String bgigoodsbarcode = Utility.getName(request.getParameter("bgigoodsbarcode")).length()<18?"":Utility.getName(request.getParameter("bgigoodsbarcode").substring(0,18)); //批号
		
		goodsInfoPo=new GoodsInfoPo();
		goodsInfoPo.setBgiwarehouseid(po.getBwcstockid7());
		goodsInfoPo.setBgigoodsbarcode(bgigoodsbarcode);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		//查询及分页
		int count = contactAccessoriesMgr.getCountByGoodsbarcode(goodsInfoPo);
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
			contactList=contactAccessoriesMgr.getListByGoodsbarcode(goodsInfoPo , page.getStart() , page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			contactList = null;
		}
		return SUCCESS;
	}

}
