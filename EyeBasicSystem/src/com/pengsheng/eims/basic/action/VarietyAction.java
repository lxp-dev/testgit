package com.pengsheng.eims.basic.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.VarietyPo;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class VarietyAction extends BaseAction {

	private VarietyMgr varietyMgr;

	private BrandMgr brandMgr;

	private List<GoodsCategoryPo> goodsCategorys;

	private List<VarietyPo> varietys;

	private VarietyPo varietyPo;

	private BrandPo brandPo;
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

	public VarietyMgr getVarietyMgr() {
		return varietyMgr;
	}

	public void setVarietyMgr(VarietyMgr varietyMgr) {
		this.varietyMgr = varietyMgr;
	}

	public BrandMgr getBrandMgr() {
		return brandMgr;
	}

	public void setBrandMgr(BrandMgr brandMgr) {
		this.brandMgr = brandMgr;
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}

	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}

	public List<VarietyPo> getVarietys() {
		return varietys;
	}

	public void setVarietys(List<VarietyPo> varietys) {
		this.varietys = varietys;
	}

	public VarietyPo getVarietyPo() {
		return varietyPo;
	}

	public void setVarietyPo(VarietyPo varietyPo) {
		this.varietyPo = varietyPo;
	}

	public BrandPo getBrandPo() {
		return brandPo;
	}

	public void setBrandPo(BrandPo brandPo) {
		this.brandPo = brandPo;
	}

	/**
	 * 查询页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initVarietySel() throws Exception {

		goodsCategorys = varietyMgr.getGoodsCategorys();

		return SUCCESS;
	}

	/**
	 * 查询页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selVariety() throws Exception {

		VarietyPo varietyPo = new VarietyPo();
		varietyPo.setBvyid(request.getParameter("selbvyid"));
		varietyPo.setBvyvarietyname(request.getParameter("selbvyvarietyname"));
		varietyPo.setBvybrandid(request.getParameter("selbvybrandid"));
		varietyPo.setBvysupplierid(request.getParameter("selsupplierID"));
		varietyPo.setBvygcid(request.getParameter("selbvygcid"));

		// if (!"".equals(varietyPo.getBvybrandid())) {
		// BrandPo brandPo = new BrandPo();
		// brandPo.setBbdid(varietyPo.getBvybrandid());
		// brandPo.setBbdsupplierid(varietyPo.getBbdsupplierid());
		//
		// brandPo = brandMgr.getBrandPo(brandPo);
		// request.setAttribute("selbrandName", brandPo.getBbdbrandname());
		// }
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = varietyMgr.getVarietysCount(varietyPo);

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

			varietys = varietyMgr.getVarietys(varietyPo, page.getStart(), page
					.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		}

		goodsCategorys = varietyMgr.getGoodsCategorys();

		setRequest();

		return SUCCESS;
	}

	/**
	 * 新增页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initVarietyInsert() throws Exception {

		goodsCategorys = varietyMgr.getGoodsCategorys();

		return SUCCESS;
	}

	/**
	 * 新增品种
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insertVariety() throws Exception {

		VarietyPo temp = new VarietyPo();
		temp.setBvyid(varietyPo.getBvyid());
		temp.setBvybrandid(varietyPo.getBvybrandid());
		temp.setBvysupplierid(varietyPo.getBvysupplierid());
		temp.setBvygcid(varietyPo.getBvygcid());

		goodsCategorys = varietyMgr.getGoodsCategorys();

		// 判断品种重复
		if (!"".equals(Utility
				.getName(varietyMgr.getVarietyPo(temp).getBvyid()))) {

			// brandPo = new BrandPo();
			// brandPo.setBbdid(temp.getBvybrandid());
			//
			// brandPo = brandMgr.getBrandPo(brandPo);

			this.clearMessages();
			this.addActionMessage(getText("no.repeat"));

			return "NoRepeat";
		}

		// 新增品种
		varietyMgr.insertVariety(varietyPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 更新品种初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initVarietyUpdate() throws Exception {

		goodsCategorys = varietyMgr.getGoodsCategorys();

		varietyPo = new VarietyPo();
		varietyPo.setBvyid(request.getParameter("hid"));
		varietyPo.setBvybrandid(request.getParameter("brandid"));
		varietyPo.setBvysupplierid(request.getParameter("bvysupplierid"));
		varietyPo.setBvygcid(request.getParameter("bvygcid"));

		varietyPo = varietyMgr.getVarietyPo(varietyPo);

		/**
		 * 品种PO
		 */
		BrandPo temp = new BrandPo();
		temp.setBbdid(varietyPo.getBvybrandid());
		temp.setBbdsupplierid(varietyPo.getBvysupplierid());

		varietyPo.setBbdbrandname(brandMgr.getBrandPo(temp).getBbdbrandname());

		return SUCCESS;
	}

	/**
	 * 更新品种
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateVariety() throws Exception {

		// 更新品种
		varietyMgr.updateVariety(varietyPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 刪除页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initVarietyDelete() throws Exception {

		varietyPo = new VarietyPo();
		varietyPo.setBvyid(request.getParameter("hid"));
		varietyPo.setBvybrandid(request.getParameter("brandid"));
		varietyPo.setBvysupplierid(request.getParameter("bvysupplierid"));
		varietyPo.setBvygcid(request.getParameter("bvygcid"));

		varietyPo = varietyMgr.getVarietyPo(varietyPo);

		return SUCCESS;
	}

	/**
	 * 刪除品种
	 * 
	 * @return
	 * @throws Exception
	 */
	public String varietyDelete() throws Exception {

		VarietyPo varietyPo = new VarietyPo();
		varietyPo.setBvyid(request.getParameter("hid"));
		varietyPo.setBvybrandid(request.getParameter("brandid"));
		varietyPo.setBvysupplierid(request.getParameter("bvysupplierid"));
		varietyPo.setBvygcid(request.getParameter("bvygcid"));

		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgibrandid(varietyPo.getBvybrandid());
//		goodsInfoPo.setBgivarietyid(varietyPo.getBvyid());

		// 判断品种已经使用
		if (varietyMgr.getGoodsInfos(goodsInfoPo) > 0) {

			this.clearMessages();
			this.addActionMessage(getText("data.have.been.used.remove.failed"));

			return "dataUsed";
		}

		// 删除品种
		varietyMgr.delVariety(varietyPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	private void setRequest() {
		request.setAttribute("selbvyid", request.getParameter("selbvyid"));
		request.setAttribute("selbvyvarietyname", request
				.getParameter("selbvyvarietyname"));
		request.setAttribute("selsupplierID", request
				.getParameter("selsupplierID"));
		request.setAttribute("selbvybrandid", request
				.getParameter("selbvybrandid"));
		request.setAttribute("selbrandName", request
				.getParameter("selbrandName"));
		request.setAttribute("selbvygcid", request.getParameter("selbvygcid"));

	}

}
