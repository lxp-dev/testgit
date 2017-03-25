/**
 * 
 */
package com.pengsheng.eims.components.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.WarehouseConfigurationMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.components.mgr.ConLensMgr;
import com.pengsheng.eims.components.mgr.SellLensMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

/**
 * @author Liuqian
 * 
 */
public class ConLensAction extends BaseAction {
	private GoodsInfoPo goodsInfoPo;

	private GoodsInfoTempPo goodsInfoTempPo;
	private ConLensMgr conLensMgr;

	
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

	private List<GoodsInfoPo> goodsList;

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

	public ConLensMgr getConLensMgr() {
		return conLensMgr;
	}

	public void setConLensMgr(ConLensMgr conLensMgr) {
		this.conLensMgr = conLensMgr;
	}

	/**
	 * 隐形商品开窗
	 * 
	 * @return
	 */
	public String initConLensSel() {
		String sph = Utility.getName(request.getParameter("sph"));
		String cyl = Utility.getName(request.getParameter("cyl"));
		String add = Utility.getName(request.getParameter("add"));
		String materialType = Utility.getName(request.getParameter("materialType"));// 镜片材质，玻璃树脂
		String glassFlag = Utility.getName(request.getParameter("glassFlag"));

		request.setAttribute("sph", "".equals(sph)?"0.00":sph);
		request.setAttribute("cyl", "".equals(cyl)?"0.00":cyl);
		request.setAttribute("add", add);
		request.setAttribute("materialType", materialType);
		request.setAttribute("glassFlag", glassFlag);
		request.setAttribute("syjp",request.getParameter("syjp"));
		
		return SUCCESS;
	}

	/**
	 * 查询隐形镜片
	 * 
	 * @return
	 */
	public String conLensSel() {
		
		WarehouseConfigurationPo warehouseConfigurationPo = new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(((PersonInfoPo)session.get("person")).getDepartmentID());

		warehouseConfigurationPo = warehouseConfigurationMgr
				.getWarehouseConfiguration(warehouseConfigurationPo);
		String goodsbarcode=Utility.getName(request.getParameter("bgigoodsbarcode")).length()<18?Utility.getName(request.getParameter("bgigoodsbarcode")):Utility.getName(request.getParameter("bgigoodsbarcode")).substring(0,18);
		if("0".equals(Utility.getName(request
				.getParameter("iscustomize")))){
			goodsInfoTempPo= new GoodsInfoTempPo();
			goodsInfoTempPo.setSph(Utility.getName(request
					.getParameter("sph")));
			goodsInfoTempPo.setCyl(Utility.getName(request
					.getParameter("cyl")));
			goodsInfoTempPo.setIscustomize("0");
			goodsInfoTempPo.setLensgoodsbarcode(goodsbarcode);
		}else{
			goodsInfoTempPo = new GoodsInfoTempPo();
			goodsInfoTempPo.setSupplierid(Utility.getName(request
					.getParameter("supplierID")));
			goodsInfoTempPo.setIscustomize(Utility.getName(request
					.getParameter("iscustomize")));
			goodsInfoTempPo.setBrandid(Utility.getName(request
					.getParameter("brandID")));
			goodsInfoTempPo.setSph(Utility.getName(request
					.getParameter("sph")));
			goodsInfoTempPo.setCyl(Utility.getName(request
					.getParameter("cyl")));
			goodsInfoTempPo.setAdd(Utility.getName(request
					.getParameter("add")));
			goodsInfoTempPo.setMaterialtype(Utility.getName(request
					.getParameter("materialType")));
			goodsInfoTempPo.setGlassFlag(Utility.getName(request
					.getParameter("glassFlag")));			
			goodsInfoTempPo.setLensgoodsid(Utility.getName(request
					.getParameter("goodsID")));			
			goodsInfoTempPo.setLensgoodsname(Utility.getName(request
						.getParameter("goodsName")));	
			goodsInfoTempPo.setGoodsnames(Utility.getName(request
					.getParameter("goodsName")));
		}
		if(request.getParameter("syjp")!=null){
			//goodsInfoTempPo.setBrandname("R".equals(request.getParameter("glassFlag"))?request.getParameter("syjp").split(",")[0]:request.getParameter("syjp").split(",")[0]);
			goodsInfoTempPo.setLensgoodsname("R".equals(request.getParameter("glassFlag"))?request.getParameter("syjp").split(",")[0]:request.getParameter("syjp").split(",")[0]);
		}
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		int count = this.conLensMgr.getConLensCount(goodsInfoTempPo,warehouseConfigurationPo);
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
			goodsList = this.conLensMgr.getConLensList(goodsInfoTempPo,warehouseConfigurationPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}

		request.setAttribute("pcBarcode", Utility.getName(request.getParameter("bgigoodsbarcode")));
		request.setAttribute("supplierID", Utility.getName(request
				.getParameter("supplierID")));
		request.setAttribute("brandID", Utility.getName(request
				.getParameter("brandID")));
		request.setAttribute("supplierName", Utility.getName(request
				.getParameter("supplierName")));
		request.setAttribute("brandName", Utility.getName(request
				.getParameter("brandName")));
		request.setAttribute("goodsID", Utility.getName(request
				.getParameter("goodsID")));
		request.setAttribute("goodsName", Utility.getName(request
				.getParameter("goodsName")));
		request.setAttribute("sph", Utility.getName(request
				.getParameter("sph")));
		request.setAttribute("add", Utility.getName(request
				.getParameter("add")));
		request.setAttribute("cyl", Utility.getName(request
				.getParameter("cyl")));
		request.setAttribute("materialType", Utility.getName(request
				.getParameter("materialType")));
		request.setAttribute("glassFlag", Utility.getName(request
				.getParameter("glassFlag")));
		request.setAttribute("syjp", request.getParameter("syjp"));
		request.setAttribute("iscustomize", Utility.getName(request
				.getParameter("iscustomize")));
		request.setAttribute("goodsbarcode", goodsbarcode);
		return SUCCESS;
	}

}
