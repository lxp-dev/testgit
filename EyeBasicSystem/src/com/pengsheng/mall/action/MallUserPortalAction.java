package com.pengsheng.mall.action;


import java.util.List;
import java.util.Map;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;
import com.pengsheng.mall.mgr.MallShoppingCartMgr;
import com.pengsheng.mall.mgr.MallShoppingFavoriteMgr;
import com.pengsheng.mall.mgr.MallShoppingOrderMgr;
import com.pengsheng.mall.mgr.MallTypeSmallMgr;
import com.pengsheng.mall.mgr.MallTypeLargeMgr;
import com.pengsheng.mall.po.MallShoppingCartPo;
import com.pengsheng.mall.po.MallShoppingFavoritePo;
import com.pengsheng.mall.po.MallShoppingOrderPo;
import com.pengsheng.mall.po.MallTypeSmallPicPo;
import com.pengsheng.mall.po.MallTypeSmallPo;
import com.pengsheng.mall.po.MallTypeLargePo;

public class MallUserPortalAction  extends BaseAction {
	
	private MallTypeSmallPo mallTypeSmallPo;
	private List<MallTypeSmallPo> mallTypeSmallList;
	private List<MallTypeSmallPicPo> mallTypeSmallPicList;
	private MallTypeSmallMgr mallTypeSmallMgr;
	
	private MallTypeLargeMgr mallTypeLargeMgr;	
	private List<MallTypeLargePo> mallTypeLargeList;
	
	private MallShoppingCartPo mallShoppingCartPo;
	private MallShoppingCartMgr mallShoppingCartMgr;	
	private List<MallShoppingCartPo> mallShoppingCartList;
	
	private List<MallShoppingOrderPo> mallShoppingOrderList;
	private MallShoppingOrderMgr mallShoppingOrderMgr;
	
	private MallShoppingFavoriteMgr mallShoppingFavoriteMgr;	
	private List<MallShoppingFavoritePo> mallShoppingFavoriteList;
	/**
	 * 商城用户Portal商品列表查询
	 */
	public String selectMallGoodsList() throws Exception {
		
		// 得到查询条件
//		String mtsname = Utility.getName(request.getParameter("mtsname"));
//		String mtslargeid = Utility.getName(request.getParameter("mtslargeid"));		
//		String mtsflag = Utility.getName(request.getParameter("mtsflag"));
		
		String openID = (String)request.getSession().getAttribute("openID");

		if(Utility.getName(openID).equals("")){
			openID = Utility.getName(request.getParameter("openID"));
			request.getSession().setAttribute("openID", openID);
		}
		
		if(openID.equals("")){
			openID = "testPerson";
			request.getSession().setAttribute("openID", openID);
		}
		
		request.setAttribute("openID", openID);
		
		MallTypeSmallPo po = new MallTypeSmallPo();

//		po.setMtsname(mtsname);
//		po.setMtslargeid(mtslargeid);
		po.setMtsflag("1");
		
		int fsppageno = 20;	

		// 查询分页
		int count = mallTypeSmallMgr.getMallTypeSmallPoCount(po);
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
			mallTypeSmallList = mallTypeSmallMgr.getMallTypeSmallPoList(po, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			mallTypeSmallList = null;
		}
		
		mallTypeLargeList = mallTypeLargeMgr.getMallTypeLargePoList(new MallTypeLargePo());
		
//		request.setAttribute("mtsname", mtsname);
//		request.setAttribute("mtslargeid", mtslargeid);
//		request.setAttribute("mtsflag", mtsflag);

		return SUCCESS;
	}

	/**
	 * 商城用户Portal商品详情查询
	 */
	public String selectMallGoodsDetail() throws Exception {
		
		// 得到查询条件
		String hid = Utility.getName(request.getParameter("hid"));
		
		MallTypeSmallPo po = new MallTypeSmallPo();
		po.setMtsid(hid);
		mallTypeSmallPo = mallTypeSmallMgr.getMallTypeSmallPo(po);
		mallTypeSmallPicList = mallTypeSmallMgr.getMallTypeSmallPicList(hid);
		
		return SUCCESS;
	}
	
	/**
	 * 商城用户Portal商品图文详情查询
	 */
	public String selectMallGoodsDetailContent() throws Exception {
		
		// 得到查询条件
		String hid = Utility.getName(request.getParameter("hid"));
		String openID = (String)request.getSession().getAttribute("openID");
		request.setAttribute("openID", openID);
		
		MallTypeSmallPo po = new MallTypeSmallPo();
		po.setMtsid(hid);
		mallTypeSmallPo = mallTypeSmallMgr.getMallTypeSmallPo(po);

		return SUCCESS;
	}
	
	/**
	 * 商城用户Portal购物车增加商品
	 */
	public String insertMallShoppingCartPo() throws Exception {
		
		mallShoppingCartMgr.insertMallShoppingCartPo(mallShoppingCartPo);
		
		return SUCCESS;
	}
	
	/**
	 * 商城用户Portal购物车删除商品
	 */
	public String deleteMallShoppingCartPo() throws Exception {
		String hid = Utility.getName(request.getParameter("hid"));
		mallShoppingCartPo = new MallShoppingCartPo();
		mallShoppingCartPo.setMscid(hid);
		mallShoppingCartMgr.deleteMallShoppingCartPo(mallShoppingCartPo);
		
		return SUCCESS;
	}
	
	/**
	 * 商城用户Portal购物车列表
	 */
	public String selectMallShoppingCartList() throws Exception {
		
		String openID = (String)request.getSession().getAttribute("openID");

		// 查询分页		
		Map<String, Object> goodsNums = mallShoppingCartMgr.getMallShoppingCartPoCountByOpenID(openID);
		String count = goodsNums.get("count").toString();
		String priceSum = goodsNums.get("titlenum") != null ? goodsNums.get("titlenum").toString() : "0";
		request.setAttribute("priceSum", priceSum);

		if (Integer.parseInt(count) > 0) {
			mallShoppingCartList = mallShoppingCartMgr.getMallShoppingCartPoListByOpenID(openID);
		} else {
			mallShoppingCartList = null;
		}
		return SUCCESS;
	}
	
	/**
	 * 商城用户Portal收藏夹增加商品
	 */
	public String insertMallShoppingFavoritePo() throws Exception {
		
		String hid = Utility.getName(request.getParameter("hid"));
		String openID = (String)request.getSession().getAttribute("openID");
		
		MallShoppingFavoritePo mallShoppingFavoritePo = new MallShoppingFavoritePo();
		mallShoppingFavoritePo.setMsfsmallid(hid);
		mallShoppingFavoritePo.setMsfopenid(openID);
		mallShoppingFavoriteMgr.insertMallShoppingFavoritePo(mallShoppingFavoritePo);
		request.setAttribute("hid", hid);
		return SUCCESS;
	}
	
	/**
	 * 商城用户Portal收藏夹删除商品
	 */
	public String deleteMallShoppingFavoritePo() throws Exception {
		String hid = Utility.getName(request.getParameter("hid"));
		MallShoppingFavoritePo mallShoppingFavoritePo = new MallShoppingFavoritePo();
		mallShoppingFavoritePo.setMsfid(hid);
		mallShoppingFavoriteMgr.deleteMallShoppingFavoritePo(mallShoppingFavoritePo);
		
		return SUCCESS;
	}
	
	/**
	 * 商城用户Portal收藏夹列表
	 */
	public String selectMallShoppingFavoriteList() throws Exception {
		
		String openID = (String)request.getSession().getAttribute("openID");
		MallShoppingFavoritePo mallShoppingFavoritePo = new MallShoppingFavoritePo();
		mallShoppingFavoritePo.setMsfopenid(openID);
		
		int fsppageno = 10000;
		// 查询分页
		int count = mallShoppingFavoriteMgr.getMallShoppingFavoritePoCount(mallShoppingFavoritePo);
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
			mallShoppingFavoriteList = mallShoppingFavoriteMgr.getMallShoppingFavoritePoList(mallShoppingFavoritePo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			mallShoppingFavoriteList = null;
		}
		return SUCCESS;
	}
	
	/**
	 * 用户中心，初始化列表
	 */
	public String selectUserCenterList() throws Exception {
		
		String openID = (String)request.getSession().getAttribute("openID");
		String userName = Utility.getName(request.getParameter("userName"));
		
		if(Utility.getName(openID).equals("")){
			openID = Utility.getName(request.getParameter("openID"));
			request.getSession().setAttribute("openID", openID);
		}
		
		if(openID.equals("")){
			openID = "testPerson";
			request.getSession().setAttribute("openID", openID);
		}
		
		request.setAttribute("openID", openID);
		request.setAttribute("userName", userName);		
		
		return SUCCESS;
	}
	
	/**
	 * 用户中心，已支付-订单列表
	 */
	public String selectUserCenterOrders() throws Exception {
		
		String openID = (String)request.getSession().getAttribute("openID");
		
		MallShoppingOrderPo po = new MallShoppingOrderPo();
		po.setMsoopenid(openID);
		int fsppageno = 10000;	
		// 查询分页
		int count = mallShoppingOrderMgr.getMallShoppingOrderPoCount(po);
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
			mallShoppingOrderList = mallShoppingOrderMgr.getMallShoppingOrderPoList(po, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			mallShoppingOrderList = null;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 用户中心，未支付-购物车列表
	 */
	public String selectUserCenterShoppingCarts() throws Exception {
		
		String openID = (String)request.getSession().getAttribute("openID");
		
		mallShoppingCartList = mallShoppingCartMgr.getMallShoppingCartPoListByOpenID(openID);
		
		return SUCCESS;
	}
	
	public MallTypeSmallPo getMallTypeSmallPo() {
		return mallTypeSmallPo;
	}

	public void setMallTypeSmallPo(MallTypeSmallPo mallTypeSmallPo) {
		this.mallTypeSmallPo = mallTypeSmallPo;
	}

	public MallTypeSmallMgr getMallTypeSmallMgr() {
		return mallTypeSmallMgr;
	}

	public void setMallTypeSmallMgr(MallTypeSmallMgr mallTypeSmallMgr) {
		this.mallTypeSmallMgr = mallTypeSmallMgr;
	}

	public List<MallTypeSmallPo> getMallTypeSmallList() {
		return mallTypeSmallList;
	}

	public void setMallTypeSmallList(List<MallTypeSmallPo> mallTypeSmallList) {
		this.mallTypeSmallList = mallTypeSmallList;
	}

	public MallTypeLargeMgr getMallTypeLargeMgr() {
		return mallTypeLargeMgr;
	}

	public void setMallTypeLargeMgr(MallTypeLargeMgr mallTypeLargeMgr) {
		this.mallTypeLargeMgr = mallTypeLargeMgr;
	}

	public List<MallTypeLargePo> getMallTypeLargeList() {
		return mallTypeLargeList;
	}

	public void setMallTypeLargeList(List<MallTypeLargePo> mallTypeLargeList) {
		this.mallTypeLargeList = mallTypeLargeList;
	}

	public List<MallTypeSmallPicPo> getMallTypeSmallPicList() {
		return mallTypeSmallPicList;
	}

	public void setMallTypeSmallPicList(
			List<MallTypeSmallPicPo> mallTypeSmallPicList) {
		this.mallTypeSmallPicList = mallTypeSmallPicList;
	}

	public MallShoppingCartMgr getMallShoppingCartMgr() {
		return mallShoppingCartMgr;
	}

	public void setMallShoppingCartMgr(MallShoppingCartMgr mallShoppingCartMgr) {
		this.mallShoppingCartMgr = mallShoppingCartMgr;
	}

	public List<MallShoppingCartPo> getMallShoppingCartList() {
		return mallShoppingCartList;
	}

	public void setMallShoppingCartList(
			List<MallShoppingCartPo> mallShoppingCartList) {
		this.mallShoppingCartList = mallShoppingCartList;
	}

	public MallShoppingCartPo getMallShoppingCartPo() {
		return mallShoppingCartPo;
	}

	public void setMallShoppingCartPo(MallShoppingCartPo mallShoppingCartPo) {
		this.mallShoppingCartPo = mallShoppingCartPo;
	}

	public List<MallShoppingOrderPo> getMallShoppingOrderList() {
		return mallShoppingOrderList;
	}

	public void setMallShoppingOrderList(
			List<MallShoppingOrderPo> mallShoppingOrderList) {
		this.mallShoppingOrderList = mallShoppingOrderList;
	}

	public MallShoppingOrderMgr getMallShoppingOrderMgr() {
		return mallShoppingOrderMgr;
	}

	public void setMallShoppingOrderMgr(MallShoppingOrderMgr mallShoppingOrderMgr) {
		this.mallShoppingOrderMgr = mallShoppingOrderMgr;
	}

	public MallShoppingFavoriteMgr getMallShoppingFavoriteMgr() {
		return mallShoppingFavoriteMgr;
	}

	public void setMallShoppingFavoriteMgr(
			MallShoppingFavoriteMgr mallShoppingFavoriteMgr) {
		this.mallShoppingFavoriteMgr = mallShoppingFavoriteMgr;
	}

	public List<MallShoppingFavoritePo> getMallShoppingFavoriteList() {
		return mallShoppingFavoriteList;
	}

	public void setMallShoppingFavoriteList(
			List<MallShoppingFavoritePo> mallShoppingFavoriteList) {
		this.mallShoppingFavoriteList = mallShoppingFavoriteList;
	}
}
