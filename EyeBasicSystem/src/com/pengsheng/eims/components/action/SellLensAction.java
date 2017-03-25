/**
 * 
 */
package com.pengsheng.eims.components.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.WarehouseConfigurationMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.components.mgr.SellLensMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

/**
 * @author jiangchen
 * 
 */
public class SellLensAction extends BaseAction {
	private GoodsInfoPo goodsInfoPo;

	private GoodsInfoTempPo goodsInfoTempPo;

	private SellLensMgr sellLensMgr;

	private List<GoodsInfoPo> goodsList;
	
	private WarehouseConfigurationMgr warehouseConfigurationMgr;
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
	
	public WarehouseConfigurationMgr getWarehouseConfigurationMgr() {
		return warehouseConfigurationMgr;
	}

	public void setWarehouseConfigurationMgr(
			WarehouseConfigurationMgr warehouseConfigurationMgr) {
		this.warehouseConfigurationMgr = warehouseConfigurationMgr;
	}

	public List<GoodsInfoPo> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsInfoPo> goodsList) {
		this.goodsList = goodsList;
	}

	public GoodsInfoPo getGoodsInfoPo() {
		return goodsInfoPo;
	}

	public void setGoodsInfoPo(GoodsInfoPo goodsInfoPo) {
		this.goodsInfoPo = goodsInfoPo;
	}

	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}

	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}

	public SellLensMgr getSellLensMgr() {
		return sellLensMgr;
	}

	public void setSellLensMgr(SellLensMgr sellLensMgr) {
		this.sellLensMgr = sellLensMgr;
	}
	/*
	 * 查询镜片初始化
	 */
	public String initSellLensSel() {
		String sph = Utility.getName(request.getParameter("sph"));
		String cyl = Utility.getName(request.getParameter("cyl"));
		String add = Utility.getName(request.getParameter("add"));
		String materialType = Utility.getName(request
				.getParameter("materialType"));// 镜片材质，玻璃树脂
		String  glassFlag= Utility.getName(request.getParameter("glassFlag"));
		String  recipeType= Utility.getName(request.getParameter("recipeType"));
		
		request.setAttribute("sph",sph.equals("") ? "0.00" : sph );
		request.setAttribute("cyl",cyl.equals("") ? "0.00" : cyl );
		request.setAttribute("add", add);
		request.setAttribute("materialType",materialType );
		request.setAttribute("glassFlag",glassFlag );
		request.setAttribute("recipeType",recipeType );
		return SUCCESS;
	}
	/*
	 * 查询
	 */
	public String sellLensSel() {
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String sph = Utility.getName(request.getParameter("sph"));
		String cyl = Utility.getName(request.getParameter("cyl"));
		String add = Utility.getName(request.getParameter("add"));
		String materialType = Utility.getName(request
				.getParameter("materialType"));// 镜片材质，玻璃树脂
		String  glassFlag= Utility.getName(request.getParameter("glassFlag"));
		String  recipeType= Utility.getName(request.getParameter("recipeType"));
		goodsInfoTempPo= new GoodsInfoTempPo();
		goodsInfoTempPo.setSph(sph);
		goodsInfoTempPo.setCyl(cyl);
		goodsInfoTempPo.setAdd(add);
		goodsInfoTempPo.setMaterialtype(materialType);
		goodsInfoTempPo.setGlassFlag(glassFlag);
//		if("3".equals(recipeType))
//		{
//			goodsInfoTempPo.setIscustomize(Utility.getName("D"));
//		}else
//		{
		goodsInfoTempPo.setIscustomize(Utility.getName(request.getParameter("iscustomize")));
//		}
		
		goodsInfoTempPo.setSupplierid(Utility.getName(request
				.getParameter("supplierID")));
		goodsInfoTempPo.setBrandid(Utility.getName(request
				.getParameter("brandID")));
		goodsInfoTempPo.setLensgoodsid(Utility.getName(request
				.getParameter("goodsid")));
		goodsInfoTempPo.setLensgoodsname(Utility.getName(request
				.getParameter("goodsname")));
		goodsInfoTempPo.setIsmutiluminosity(Utility.getName(request
				.getParameter("ismutiluminosity")));
		
		WarehouseConfigurationPo tempWarehouseConfigurationPo = new WarehouseConfigurationPo();
		tempWarehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		WarehouseConfigurationPo warehouseConfigurationPo=warehouseConfigurationMgr.getWarehouseConfiguration(tempWarehouseConfigurationPo);
		
		goodsInfoTempPo.setOutstockid(warehouseConfigurationPo.getBwcstockid3());
		goodsInfoTempPo.setOutdstockid(warehouseConfigurationPo.getBwcstockid4());
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = this.sellLensMgr.getSellLensCount(goodsInfoTempPo);
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
			goodsList = this.sellLensMgr.getSellLensList(goodsInfoTempPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}

		request.setAttribute("supplierID", Utility.getName(request
				.getParameter("supplierID")));
		request.setAttribute("brandID", Utility.getName(request
				.getParameter("brandID")));
		request.setAttribute("supplierName", Utility.getName(request
				.getParameter("supplierName")));
		request.setAttribute("brandName", Utility.getName(request
				.getParameter("brandName")));
		request.setAttribute("sph",sph.equals("") ? "0.00" : sph );
		request.setAttribute("cyl",cyl.equals("") ? "0.00" : cyl );
		request.setAttribute("add", add);
		request.setAttribute("materialType",materialType );
		request.setAttribute("glassFlag",glassFlag );
		request.setAttribute("recipeType",recipeType );
		request.setAttribute("iscustomize",Utility.getName(request
				.getParameter("iscustomize")) );
		request.setAttribute("goodsid",Utility.getName(request
				.getParameter("goodsid")) );
		request.setAttribute("goodsname",Utility.getName(request
				.getParameter("goodsname")) );
		request.setAttribute("ismutiluminosity",Utility.getName(request
				.getParameter("ismutiluminosity")) );
		
		return SUCCESS;
	}

}
