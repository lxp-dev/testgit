package com.pengsheng.eims.components.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.WarehouseConfigurationMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.components.mgr.WindowFinishesGlassesMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class WindowFinishedGlassesAction extends BaseAction {
	private List<GoodsInfoPo> finishedGlassesList;

	private WindowFinishesGlassesMgr windowFinishesGlassesMgr;

	private WarehouseConfigurationMgr warehouseConfigurationMgr;

	private WarehouseConfigurationPo po;

	private GoodsInfoPo goodsInfoPo;
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

	public GoodsInfoPo getGoodsInfoPo() {
		return goodsInfoPo;
	}

	public void setGoodsInfoPo(GoodsInfoPo goodsInfoPo) {
		this.goodsInfoPo = goodsInfoPo;
	}

	public List<GoodsInfoPo> getFinishedGlassesList() {
		return finishedGlassesList;
	}

	public void setFinishedGlassesList(List<GoodsInfoPo> finishedGlassesList) {
		this.finishedGlassesList = finishedGlassesList;
	}

	public WindowFinishesGlassesMgr getWindowFinishesGlassesMgr() {
		return windowFinishesGlassesMgr;
	}

	public void setWindowFinishesGlassesMgr(
			WindowFinishesGlassesMgr windowFinishesGlassesMgr) {
		this.windowFinishesGlassesMgr = windowFinishesGlassesMgr;
	}

	public WarehouseConfigurationMgr getWarehouseConfigurationMgr() {
		return warehouseConfigurationMgr;
	}

	public void setWarehouseConfigurationMgr(
			WarehouseConfigurationMgr warehouseConfigurationMgr) {
		this.warehouseConfigurationMgr = warehouseConfigurationMgr;
	}

	public WarehouseConfigurationPo getPo() {
		return po;
	}

	public void setPo(WarehouseConfigurationPo po) {
		this.po = po;
	}

	/**
	 * 初始化查询
	 * 
	 * @return
	 */
	public String initFinishedGlassesSel() {

		return SUCCESS;
	}

	/**
	 * 查询成品镜信息
	 * 
	 * @return
	 */
	public String selectFinishedGlasses() {

		// 得到当前登录人的部门 根据部门取出仓位
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String departmentId = personInfoPo.getDepartmentID();

		po = new WarehouseConfigurationPo();
		po.setBwcdeptid(departmentId);

		po = warehouseConfigurationMgr.getWarehouseConfiguration(po);

		String goodsId = Utility.getName(request.getParameter("goodsId"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String supplierId = Utility.getName(request.getParameter("supplierId"));
		String brandId = Utility.getName(request.getParameter("brandId"));

		String supplierName = Utility.getName(request
				.getParameter("supplierName"));
		String brandName = Utility.getName(request.getParameter("brandName"));

		String bgifinishedglassestype = Utility.getName(request
				.getParameter("bgifinishedglassestype"));

		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(goodsId);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgisupplierid(supplierId);
		goodsInfoPo.setBgibrandid(brandId);
		goodsInfoPo.setBgisuppliername(supplierName);
		goodsInfoPo.setBgibrandname(brandName);
		goodsInfoPo.setBgiwarehouseid(po.getBwcstockid5());
		goodsInfoPo.setBgifinishedglassestype(bgifinishedglassestype);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		// 查询及分页
		int count = windowFinishesGlassesMgr
				.getFinishedGlassesCount(goodsInfoPo);
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
			finishedGlassesList = windowFinishesGlassesMgr
					.selectFinishedGlasses(goodsInfoPo, page.getStart(), page
							.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			finishedGlassesList = null;
		}

		return SUCCESS;
	}

	/**
	 * 根据商品条码查询商品
	 * 
	 * @return
	 */
	public String selecFinishedtByGoodsbarcode() {

		// 得到当前登录人的部门 根据部门取出仓位
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String departmentId = personInfoPo.getDepartmentID();

		po = new WarehouseConfigurationPo();
		po.setBwcdeptid(departmentId);

		po = warehouseConfigurationMgr.getWarehouseConfiguration(po);
		request.setAttribute("pcBarcode", Utility.getName(request.getParameter("bgigoodsbarcode")));
		String bgigoodsbarcode = Utility.getName(request.getParameter("bgigoodsbarcode")).length()<18?"":Utility.getName(request.getParameter("bgigoodsbarcode").substring(0,18)); //批号
		
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgiwarehouseid(po.getBwcstockid8());
		goodsInfoPo.setBgigoodsbarcode(bgigoodsbarcode);

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		// 查询及分页
		int count = windowFinishesGlassesMgr
				.getCountByGoodsbarcode(goodsInfoPo);
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
			finishedGlassesList = windowFinishesGlassesMgr
					.getListByGoodsbarcode(goodsInfoPo, page.getStart(), page
							.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			finishedGlassesList = null;
		}
		return SUCCESS;
	}

}
