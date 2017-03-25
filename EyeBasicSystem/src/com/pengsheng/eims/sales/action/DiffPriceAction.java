package com.pengsheng.eims.sales.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.AdditionalCDetailMgr;
import com.pengsheng.eims.sales.mgr.DiffPriceMgr;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesPostBasicPo;
import com.pengsheng.eims.sales.persistence.SalesPostDetailPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class DiffPriceAction extends BaseAction{
	
	private PersonPermissionMgr personPermissionMgr;
	
	private SalesBasicPo salesBasicPo;
	
	private CustomerInfoPo customerInfoPo;
	
	private List<SalesBasicPo> diffPriceList;

	private DiffPriceMgr diffPriceMgr;
	
	private AdditionalCDetailMgr additionalCDetailMgr;
	
	private SalesPostDetailPo salesPostDetailPo;
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public SalesPostDetailPo getSalesPostDetailPo() {
		return salesPostDetailPo;
	}

	public void setSalesPostDetailPo(SalesPostDetailPo salesPostDetailPo) {
		this.salesPostDetailPo = salesPostDetailPo;
	}

	public AdditionalCDetailMgr getAdditionalCDetailMgr() {
		return additionalCDetailMgr;
	}

	public void setAdditionalCDetailMgr(AdditionalCDetailMgr additionalCDetailMgr) {
		this.additionalCDetailMgr = additionalCDetailMgr;
	}
	private List<SalesDetailPo> salesDetailList;
	
	private List<AdditionalCDetailPo> additionalList;
	
	public List<AdditionalCDetailPo> getAdditionalList() {
		return additionalList;
	}

	public void setAdditionalList(List<AdditionalCDetailPo> additionalList) {
		this.additionalList = additionalList;
	}

	public DiffPriceMgr getDiffPriceMgr() {
		return diffPriceMgr;
	}

	public void setDiffPriceMgr(DiffPriceMgr diffPriceMgr) {
		this.diffPriceMgr = diffPriceMgr;
	}

	public List<SalesDetailPo> getSalesDetailList() {
		return salesDetailList;
	}

	public void setSalesDetailList(List<SalesDetailPo> salesDetailList) {
		this.salesDetailList = salesDetailList;
	}

	public List<SalesBasicPo> getDiffPriceList() {
		return diffPriceList;
	}

	public void setDiffPriceList(List<SalesBasicPo> diffPriceList) {
		this.diffPriceList = diffPriceList;
	}

	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}
	
	/*
	 * 初始化退差价
	 */
	public String initDiffPrice() throws Exception{
		if (customerInfoPo != null
				&& StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())||!Utility.getName(request.getParameter("salesid")).equals("")) {
			String memberID=Utility.getName(customerInfoPo.getSmecimemberid());
			String salesid = request.getParameter("salesid");
			SalesBasicPo sbpo = new SalesBasicPo();
			CustomerInfoPo cpo = new CustomerInfoPo();
			sbpo.setSsesbsalerid(salesid);
			cpo.setSmecimemberid(memberID);
			customerInfoPo = diffPriceMgr.getCustomerInfo(cpo,sbpo);
			
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday()
						.substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR)
						- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmdown(Integer.toString(age));
			}

			request.setAttribute("salesID", Utility.getName(request.getParameter("salesID")));
			if (customerInfoPo != null
					&& StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())||!Utility.getName(request.getParameter("salesID")).equals("")) {
				SalesBasicPo temp = new SalesBasicPo();
				temp.setSsesbsalesid(Utility.getName(request.getParameter("salesID")));
				temp.setSsesbcustomerid(Utility.getName(customerInfoPo.getSmecicustomerid()));
				
				//取得当前顾客的销售信息
				diffPriceList=diffPriceMgr.getDiffPrices(temp,((PersonInfoPo)session.get("person")).getDepartmentID());
			}
			
		}
		return SUCCESS;
	}

	/*
	 * 
	 * 开窗
	 */
	public String diffPriceOpen() throws Exception{
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String salesID=Utility.getName(request.getParameter("salesID"));
		String customerID = Utility.getName(request.getParameter("customerID"));
		request.setAttribute("customerID",customerID);
		String newsalesID = "X" + personInfoPo.getDepartmentID()
		+ personInfoPo.getMachinery() + numHeadFormat.format(new Date());
		salesBasicPo=this.diffPriceMgr.getSalesBasicPo(salesID);
		salesDetailList=this.diffPriceMgr.getSalesDetail(salesID);
		additionalList=this.additionalCDetailMgr.getAdditionalCDetailPos(salesID);
		request.setAttribute("newsalesID", newsalesID);
		request.setAttribute("salesID", salesID);
		return SUCCESS;
	}
	/*
	 * 退差价缴费提交
	 */
	public String diffPrice() throws Exception{
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		String createrid = personInfoPo.getId();
		String shopcode = personInfoPo.getDepartmentID();
		String stockid = diffPriceMgr.getWarehouse(shopcode).getBwhid();
		String salesID = request.getParameter("salesID");
		String newsalesID = request.getParameter("newsalesid");
		String[] discountrate = request.getParameterValues("salesPostDetailPo.ssespddiscountrate");
		String[] discountnum =request.getParameterValues("salesPostDetailPo.ssespddiscountnum");
		String[] salesvalue = request.getParameterValues("salesPostDetailPo.ssespdsalesvalue");
		String salesvalueB = request.getParameter("ssespbnewpsalsvalue");
		String discountrateB = request.getParameter("ssespbnewdiscountrate");
		String discountnumB = (Float.parseFloat(request.getParameter("ssespbpostvalue"))+Float.parseFloat(request.getParameter("zhekou")))+"";
		int count = discountrate.length;
		List<SalesDetailPo> salesDetailPos = diffPriceMgr.getSalesDetails(salesID);
		for (int i = 0; i < count; i++) {
			salesDetailPos.get(i).setSsesdsalesid(salesID);
			salesDetailPos.get(i).setSsesdstockid(stockid);
			salesDetailPos.get(i).setSsesddiscountrate(discountrate[i]);
			salesDetailPos.get(i).setSsesddiscountnum(discountnum[i]);
			salesDetailPos.get(i).setSsesdsalesvalue(salesvalue[i]);
		}
		SalesBasicPo salesBasicPo = new SalesBasicPo();
		salesBasicPo.setSsesbsalesid(salesID);
		salesBasicPo.setSsesbsalesvalue(salesvalueB);
		salesBasicPo.setSsesbdiscountrate(discountrateB);
		salesBasicPo.setSsesbdiscountnum(discountnumB);
		salesBasicPo.setSsesbwithdrawpersonid(createrid);
		
		InTransitPo inTransitPo = new InTransitPo();
		inTransitPo.setSseitsalesid(salesID);
		inTransitPo.setSseitcreateperson(createrid);
		inTransitPo.setSseitdepartment(shopcode);
		
		SalesPostBasicPo postBasicPo = new SalesPostBasicPo();
		postBasicPo.setSsespbcreater(createrid);
		postBasicPo.setSsespbsalesid(salesID);
		postBasicPo.setSsespbnewsalesid(newsalesID);
		
		diffPriceMgr.insertPost(salesBasicPo, salesDetailPos, inTransitPo,postBasicPo, newsalesID);
		
//		this.diffPriceMgr.insertBasic(salesPostBasicPo,salesPostDetailPo);
		
		/*
		 * 更新顾客基本资料表中的会员积分
		 */
		String customerID = Utility.getName(request.getParameter("customerID").toString());
		float ssespbpostvalue = Float.valueOf(Utility.getName(request.getParameter("ssespbpostvalue").toString()));
		this.diffPriceMgr.updateCustomerIntegral(customerID,ssespbpostvalue);
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	/*
	 * 查看退差价。
	 */
	public String diffPriceSel() throws Exception{
		String salesID=Utility.getName(request.getParameter("salesID"));
		
		salesBasicPo=this.diffPriceMgr.getSalesBasicPo(salesID);
		salesDetailList=this.diffPriceMgr.getSalesDetail(salesID);
		additionalList=this.additionalCDetailMgr.getAdditionalCDetailPos(salesID);
		return SUCCESS;
	}

}
