/**
 * 
 */
package com.pengsheng.eims.components.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.util.profiling.UtilTimerStack;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.components.mgr.CustomerOptometryMgr;
import com.pengsheng.eims.components.mgr.SellLensMgr;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.HealthCheckPo;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
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
public class SellStealthLensAction extends BaseAction {
	private GoodsInfoPo goodsInfoPo;
	private GoodsInfoTempPo goodsInfoTempPo;
	private SellLensMgr sellLensMgr;
	private List<GoodsInfoPo> goodsList;
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
	
	public String initSellStealthLensSel(){
		String sph=Utility.getName(request.getParameter("sph"));
		String cyl=Utility.getName(request.getParameter("cyl"));
		String add=Utility.getName(request.getParameter("add"));
		String materialType=Utility.getName(request.getParameter("materialType"));//镜片材质，玻璃树脂
		String glassFlag=Utility.getName(request.getParameter("glassFlag"));
		goodsInfoTempPo=new GoodsInfoTempPo();
		goodsInfoTempPo.setSph(sph.equals("")?"0.00":sph);
		goodsInfoTempPo.setAdd(add);
		goodsInfoTempPo.setCyl(cyl.equals("")?"0.00":cyl);
		goodsInfoTempPo.setMaterialtype(materialType);
		goodsInfoTempPo.setGlassFlag(glassFlag);
		return SUCCESS;
	}
	public String sellStealthLensSel(){
		goodsInfoTempPo.setSupplierid(Utility.getName(request.getParameter("supplierID")));
		goodsInfoTempPo.setBrandid(Utility.getName(request.getParameter("brandID")));
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count=this.sellLensMgr.getSellLensCount(goodsInfoTempPo);
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
	    goodsList=this.sellLensMgr.getSellLensList(goodsInfoTempPo, page.getStart(), page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			goodsList = null;
		}
		
		
		request.setAttribute("supplierID", Utility.getName(request.getParameter("supplierID")));
		request.setAttribute("brandID", Utility.getName(request.getParameter("brandID")));
		request.setAttribute("supplierName",Utility.getName(request.getParameter("supplierName")) );
		request.setAttribute("brandName",Utility.getName(request.getParameter("brandName")) );
		return SUCCESS;
	}
	
}
