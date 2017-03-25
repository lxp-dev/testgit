package com.pengsheng.eims.components.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.WarehouseConfigurationMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.components.mgr.SelectGoodsByGoodsbarcodeMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class SelectGoodsByGoodsbarcodeAction extends BaseAction {

	private SelectGoodsByGoodsbarcodeMgr selectGoodsByGoodsbarcodeMgr;
	
	private GoodsInfoPo goodsInfoPo;
	
	private List<GoodsInfoPo> byGoodsbarcodeList;
	
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
	
	public SelectGoodsByGoodsbarcodeMgr getSelectGoodsByGoodsbarcodeMgr() {
		return selectGoodsByGoodsbarcodeMgr;
	}

	public void setSelectGoodsByGoodsbarcodeMgr(
			SelectGoodsByGoodsbarcodeMgr selectGoodsByGoodsbarcodeMgr) {
		this.selectGoodsByGoodsbarcodeMgr = selectGoodsByGoodsbarcodeMgr;
	}

	public GoodsInfoPo getGoodsInfoPo() {
		return goodsInfoPo;
	}

	public void setGoodsInfoPo(GoodsInfoPo goodsInfoPo) {
		this.goodsInfoPo = goodsInfoPo;
	}

	public List<GoodsInfoPo> getByGoodsbarcodeList() {
		return byGoodsbarcodeList;
	}

	public void setByGoodsbarcodeList(List<GoodsInfoPo> byGoodsbarcodeList) {
		this.byGoodsbarcodeList = byGoodsbarcodeList;
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
	 * 初始化商品条码查询页面
	 * @return
	 */
	public String initGoodsByGoodsbarcodeSel(){
		
		return SUCCESS;
	}
	
	/**
	 * 根据商品条码查询商品
	 * @return
	 */
	public String selectGoodsByGoodsbarcode(){
		
		//得到当前登录人的部门  根据部门取出仓位
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		String departmentId = personInfoPo.getDepartmentID();
		
		po=new WarehouseConfigurationPo();
		po.setBwcdeptid(departmentId);
		
		po = warehouseConfigurationMgr.getWarehouseConfiguration(po);
		
		String bgigoodsbarcode=Utility.getName(request.getParameter("bgigoodsbarcode"));
		
		goodsInfoPo=new GoodsInfoPo();
		goodsInfoPo.setBgigoodsbarcode(bgigoodsbarcode);
		goodsInfoPo.setBgiwarehouseid(po.getBwcstockid5());
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		//查询及分页
		int count = selectGoodsByGoodsbarcodeMgr.goodsByGoodsbarcodeCount(goodsInfoPo);
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
			byGoodsbarcodeList=selectGoodsByGoodsbarcodeMgr.selectGoodsByGoodsbarcode(goodsInfoPo , page.getStart() , page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			byGoodsbarcodeList = null;
		}
		
		return SUCCESS;
	}
}
