package com.pengsheng.weixin.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.casehistory.mgr.InspectionNMgr;
import com.pengsheng.eims.components.mgr.InTransitDetailsMgr;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.mgr.ConfigurationMgr;
import com.pengsheng.weixin.mgr.WeiXinCmsContentMgr;
import com.pengsheng.weixin.mgr.WeiXinCmsTypeMgr;
import com.pengsheng.weixin.mgr.WeiXinDataConfigMgr;
import com.pengsheng.weixin.persistence.WeiXinCmsContentPo;
import com.pengsheng.weixin.persistence.WeiXinDataConfigPo;

public class WeiXinMsgCenterAction extends BaseAction {

	private CustomerInfoMgr customerInfoMgr;
	private ConfigurationMgr configurationMgr;
	private InTransitDetailsMgr inTransitDetailsMgr;
	private WeiXinCmsTypeMgr weiXinCmsTypeMgr;
	private WeiXinCmsContentMgr weiXinCmsContentMgr;
	private InspectionNMgr inspectionNMgr;
	private WeiXinDataConfigMgr weiXinDataConfigMgr;

	
	/**
	 * 初始化微信消息中心
	 */
	public String initMsgCenterSel() throws Exception {
		
		String openID = Utility.getName(request.getParameter("openID"));
		request.setAttribute("openID", openID);
		
		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);	
		
		if(customerInfoPo==null || Utility.getName(customerInfoPo.getSmecicustomerid()).equals("")){					
			return "weiXinMemberBindSel";
		}
		
		WeiXinDataConfigPo weiXinDataConfigPo = weiXinDataConfigMgr.getWeiXinDataConfigPo();
		request.setAttribute("weiXinDataConfigPo", weiXinDataConfigPo);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化复查提醒
	 */
	public String initWeiXinFuchaSel() {
		
		String openID = Utility.getName(request.getParameter("openID"));
		request.setAttribute("openID", openID);
		
		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);	
		
		if(customerInfoPo==null || Utility.getName(customerInfoPo.getSmecicustomerid()).equals("")){					
			return "weiXinMemberBindSel";
		}
		
		List<CustomerInfoPo> list1 = new ArrayList<CustomerInfoPo>();
		List<CustomerInfoPo> list2 = new ArrayList<CustomerInfoPo>();
		List list11 = new ArrayList();
		List list22 = new ArrayList();
		
		CustomerInfoPo tmpCustomerInfoPo = new CustomerInfoPo();
		tmpCustomerInfoPo.setSmecicustomerid(customerInfoPo.getSmecicustomerid());
		list1 = customerInfoMgr.getWeixinCustomerInfoList(tmpCustomerInfoPo);
		
		Iterator<CustomerInfoPo> it1 = list1.iterator();
		while(it1.hasNext()){
			list11.add(inspectionNMgr.getLastInspectionPo(it1.next().getSmecicustomerid()));
		}
		
		tmpCustomerInfoPo = new CustomerInfoPo();
		tmpCustomerInfoPo.setSmecisourcecard(customerInfoPo.getSmecimemberid());
		list2 = customerInfoMgr.getWeixinCustomerInfoList(tmpCustomerInfoPo);
		
		Iterator<CustomerInfoPo> it2 = list2.iterator();
		while(it2.hasNext()){
			list22.add(inspectionNMgr.getLastInspectionPo(it2.next().getSmecicustomerid()));
		}
		
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.setAttribute("list11", list11);
		request.setAttribute("list22", list22);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化定制片配镜单查询
	 */
	public String initWeiXinDzSalesBillSel() {
		
		String openID = Utility.getName(request.getParameter("openID"));
		request.setAttribute("openID", openID);
		
		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);	
		
		if(customerInfoPo==null || Utility.getName(customerInfoPo.getSmecicustomerid()).equals("")){					
			return "weiXinMemberBindSel";
		}
		
		List<SalesBasicPo> salesBasicList = configurationMgr.getDzSalesBillInfoByCustomer(customerInfoPo);

		request.setAttribute("salesBasicList",salesBasicList);
		return SUCCESS;
	}
	
	/**
	 * 初始化定制片配镜单查询
	 */
	public String initWeiXinDzSalesBillInTransitSel() {
		
		String openID = Utility.getName(request.getParameter("openID"));
		request.setAttribute("openID", openID);
		
		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);	
		
		if(customerInfoPo==null || Utility.getName(customerInfoPo.getSmecicustomerid()).equals("")){					
			return "weiXinMemberBindSel";
		}
		
		String salesBillID = Utility.getName(request.getParameter("salesBillID"));
		customerInfoPo.setFmmsalesid(salesBillID);
		SalesBasicPo salesBasicPo = configurationMgr.getSalesBillByCustomer(customerInfoPo);

		List<InTransitPo> inTransitStateList = new ArrayList();
		inTransitStateList = intransitUpdate(salesBasicPo);
		
		request.setAttribute("inTransitStateList",inTransitStateList);
		request.setAttribute("salesBillID", salesBillID);
		return SUCCESS;
	}
	
	/**
	 * 初始化最新技术文章
	 */
	public String initNewsContentSel() {
		
		String openID = Utility.getName(request.getParameter("openID"));
		request.setAttribute("openID", openID);
		
		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);	
		
		if(customerInfoPo==null || Utility.getName(customerInfoPo.getSmecicustomerid()).equals("")){					
			return "weiXinMemberBindSel";
		}
		
		WeiXinDataConfigPo weiXinDataConfigPo =  weiXinDataConfigMgr.getWeiXinDataConfigPo();
		WeiXinCmsContentPo po = new WeiXinCmsContentPo();	
		po.setWcmsctypeid(weiXinDataConfigPo.getWdcnewcmstype());

		List<WeiXinCmsContentPo> newsContentList = weiXinCmsContentMgr
				.selectWeiXinCmsContentListForView(po);
		
		request.setAttribute("newsContentList", newsContentList);

		return SUCCESS;
	}
	
	/**
	 * 查询在途点
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	private List<InTransitPo> intransitUpdate(SalesBasicPo salesBasicPo) {

		List<InTransitPo> tempList = inTransitDetailsMgr
				.getWeiXinInTransitState(salesBasicPo.getSsesbsalesid());

		for (int i = 0; i < tempList.size(); i++) {
			InTransitPo temp1 = tempList.get(i);
			temp1.setSseitstateflag("1");

			if ("1".equals(temp1.getSseitstate())) {
				temp1.setSseitintransitname("销售完成");
			}

			// 银台已交费
			if ("1".equals(temp1.getSseitstate())) {
				temp1.setSseitintransitname("销售完成");
			}
			if ("2".equals(temp1.getSseitstate())) {
				temp1.setSseitintransitname("银台结款");
			}

			if ("3".equals(temp1.getSseitstate())) {
				temp1.setSseitintransitname("门店配送");
			}

			if ("4".equals(temp1.getSseitstate())) {
				temp1.setSseitintransitname("委外订单");			
			}

			if ("5".equals(temp1.getSseitstate())) {
				temp1.setSseitintransitname("委外收货");
			}

			if ("6".equals(temp1.getSseitstate())) {
				temp1.setSseitintransitname("配镜发料");
			}
			if ("7".equals(temp1.getSseitstate())) {
				temp1.setSseitintransitname("加工初验");
			}

			if ("8".equals(temp1.getSseitstate())) {
				temp1.setSseitintransitname("加工师加工");
			}

			if ("9".equals(temp1.getSseitstate())) {
				temp1.setSseitintransitname("加工检验");
			}

			if ("10".equals(temp1.getSseitstate())) {
				temp1.setSseitintransitname("加工配送");
			}

			if ("11".equals(temp1.getSseitstate())) {
				temp1.setSseitintransitname("隐形配送");
			}

			if ("12".equals(temp1.getSseitstate())) {
				temp1.setSseitintransitname("取镜处收货");
			}

			if ("13".equals(temp1.getSseitstate())) {
				temp1.setSseitintransitname("顾客取镜");
			}

			if ("14".equals(temp1.getSseitstate())) {
				temp1.setSseitintransitname("顾客退货");
			}

			if (tempList.size() == i + 1) {
				temp1.setSseitstateflag("2");
			}
		}

		String intransitCurrentString = salesBasicPo.getSsesbintransit();

		// 销售完成
		if (salesBasicPo.getSsesborderstype().matches("[12345]")
				&& Integer.parseInt(intransitCurrentString) < 1) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("1");
			temp1.setSseitintransitname("销售完成");
			temp1.setSseitstateflag("0");
			tempList.add(temp1);
		}
		// 银台已交费
		if (salesBasicPo.getSsesborderstype().matches("[12345]")
				&& Integer.parseInt(intransitCurrentString) < 2) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("2");
			temp1.setSseitintransitname("银台结款");
			temp1.setSseitstateflag("0");
			tempList.add(temp1);
		}

		if (salesBasicPo.getSsesborderstype().matches("[124]")
				&& Integer.parseInt(intransitCurrentString) < 3 && inTransitDetailsMgr.getInTransitFlag("3").equals("1")) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("3");
			temp1.setSseitintransitname("门店配送");
			temp1.setSseitstateflag("0");
			tempList.add(temp1);
		}

		if (salesBasicPo.getSsesborderstype().matches("[24]")
				&& Integer.parseInt(intransitCurrentString) < 4) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("4");
			temp1.setSseitintransitname("委外订单");
			temp1.setSseitstateflag("0");
			tempList.add(temp1);
		}

		if (salesBasicPo.getSsesborderstype().matches("[24]")
				&& Integer.parseInt(intransitCurrentString) < 5) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("5");
			temp1.setSseitintransitname("委外收货");
			temp1.setSseitstateflag("0");
			tempList.add(temp1);
		}

		if (salesBasicPo.getSsesborderstype().matches("[12]")
				&& Integer.parseInt(intransitCurrentString) < 6) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("6");
			temp1.setSseitintransitname("配镜发料");
			temp1.setSseitstateflag("0");
			tempList.add(temp1);
		}
		
		if (salesBasicPo.getSsesborderstype().matches("[12]")
				&& Integer.parseInt(intransitCurrentString) < 7 && inTransitDetailsMgr.getInTransitFlag("7").equals("1")) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("7");
			temp1.setSseitintransitname("加工初验");
			temp1.setSseitstateflag("0");
			tempList.add(temp1);
		}
		
		if (salesBasicPo.getSsesborderstype().matches("[12]")
				&& Integer.parseInt(intransitCurrentString) < 8 && inTransitDetailsMgr.getInTransitFlag("8").equals("1")) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("8");
			temp1.setSseitintransitname("加工师加工");
			temp1.setSseitstateflag("0");
			tempList.add(temp1);
		}

		if (salesBasicPo.getSsesborderstype().matches("[12]")
				&& Integer.parseInt(intransitCurrentString) < 9 && inTransitDetailsMgr.getInTransitFlag("9").equals("1")) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("9");
			temp1.setSseitintransitname("加工检验");
			temp1.setSseitstateflag("0");
			tempList.add(temp1);
		}

		if (salesBasicPo.getSsesborderstype().matches("[12]")
				&& Integer.parseInt(intransitCurrentString) < 10 && inTransitDetailsMgr.getInTransitFlag("10").equals("1")) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("10");
			temp1.setSseitintransitname("加工配送");
			temp1.setSseitstateflag("0");
			tempList.add(temp1);
		}

		if (salesBasicPo.getSsesborderstype().matches("[4]")
				&& Integer.parseInt(intransitCurrentString) < 11 && inTransitDetailsMgr.getInTransitFlag("11").equals("1")) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("11");
			temp1.setSseitintransitname("隐形配送");
			temp1.setSseitstateflag("0");
			tempList.add(temp1);
		}

		if (salesBasicPo.getSsesborderstype().matches("[124]")
				&& Integer.parseInt(intransitCurrentString) < 12) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("12");
			temp1.setSseitintransitname("取镜处收货");
			temp1.setSseitstateflag("0");
			tempList.add(temp1);
		}

		if (salesBasicPo.getSsesborderstype().matches("[12345]")
				&& Integer.parseInt(intransitCurrentString) < 13) {
			InTransitPo temp1 = new InTransitPo();
			temp1.setSseitstate("13");
			temp1.setSseitintransitname("顾客取镜");
			temp1.setSseitstateflag("0");
			tempList.add(temp1);
		}

		return tempList;
	}
	
	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}

	public ConfigurationMgr getConfigurationMgr() {
		return configurationMgr;
	}

	public void setConfigurationMgr(ConfigurationMgr configurationMgr) {
		this.configurationMgr = configurationMgr;
	}

	public InTransitDetailsMgr getInTransitDetailsMgr() {
		return inTransitDetailsMgr;
	}

	public void setInTransitDetailsMgr(InTransitDetailsMgr inTransitDetailsMgr) {
		this.inTransitDetailsMgr = inTransitDetailsMgr;
	}

	public WeiXinCmsTypeMgr getWeiXinCmsTypeMgr() {
		return weiXinCmsTypeMgr;
	}

	public void setWeiXinCmsTypeMgr(WeiXinCmsTypeMgr weiXinCmsTypeMgr) {
		this.weiXinCmsTypeMgr = weiXinCmsTypeMgr;
	}

	public WeiXinCmsContentMgr getWeiXinCmsContentMgr() {
		return weiXinCmsContentMgr;
	}

	public void setWeiXinCmsContentMgr(WeiXinCmsContentMgr weiXinCmsContentMgr) {
		this.weiXinCmsContentMgr = weiXinCmsContentMgr;
	}

	public InspectionNMgr getInspectionNMgr() {
		return inspectionNMgr;
	}

	public void setInspectionNMgr(InspectionNMgr inspectionNMgr) {
		this.inspectionNMgr = inspectionNMgr;
	}

	public WeiXinDataConfigMgr getWeiXinDataConfigMgr() {
		return weiXinDataConfigMgr;
	}

	public void setWeiXinDataConfigMgr(WeiXinDataConfigMgr weiXinDataConfigMgr) {
		this.weiXinDataConfigMgr = weiXinDataConfigMgr;
	}
}
