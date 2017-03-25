package com.pengsheng.eims.components.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.components.mgr.InTransitDetailsMgr;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.sales.persistence.SpecialPDetailPo;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class InTransitDetailsAction extends BaseAction {
	
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private List<SalesDetailPo> returngoodsInfoList;
	private OptionParamMgr optionParamMgr;	
	private List<OptionParamPo> optionParamPolist;
	
	public OptionParamMgr getOptionParamMgr() {
		return optionParamMgr;
	}

	public void setOptionParamMgr(OptionParamMgr optionParamMgr) {
		this.optionParamMgr = optionParamMgr;
	}

	public List<OptionParamPo> getOptionParamPolist() {
		return optionParamPolist;
	}

	public void setOptionParamPolist(List<OptionParamPo> optionParamPolist) {
		this.optionParamPolist = optionParamPolist;
	}

	public List<SalesDetailPo> getReturngoodsInfoList() {
		return returngoodsInfoList;
	}

	public void setReturngoodsInfoList(List<SalesDetailPo> returngoodsInfoList) {
		this.returngoodsInfoList = returngoodsInfoList;
	}

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

	private SalesBasicPo salesBasicPo;

	private List<SalesBasicPo> salesBasicList;

	private InTransitDetailsMgr inTransitDetailsMgr;

	private InTransitPo inTransitPo;

	private List<InTransitPo> inTransitStateList;
	
	private List<InTransitPo> rInTransitStateList;
	
	private List<SalesLogPo> salesLogList;
	
	public List<SalesLogPo> getSalesLogList() {
		return salesLogList;
	}

	public void setSalesLogList(List<SalesLogPo> salesLogList) {
		this.salesLogList = salesLogList;
	}

	public List<InTransitPo> getrInTransitStateList() {
		return rInTransitStateList;
	}

	public void setrInTransitStateList(List<InTransitPo> rInTransitStateList) {
		this.rInTransitStateList = rInTransitStateList;
	}

	private SalesBasicPo salesODPo;

	private SalesBasicPo salesOSPo;

	private List<SalesDetailPo> goodsInfoList;

	private List<AdditionalCDetailPo> addititonalCDetailList;

	private List<SpecialPDetailPo> specialPDetailList;

	public List<SpecialPDetailPo> getSpecialPDetailList() {
		return specialPDetailList;
	}

	public void setSpecialPDetailList(List<SpecialPDetailPo> specialPDetailList) {
		this.specialPDetailList = specialPDetailList;
	}

	public List<AdditionalCDetailPo> getAddititonalCDetailList() {
		return addititonalCDetailList;
	}

	public void setAddititonalCDetailList(
			List<AdditionalCDetailPo> addititonalCDetailList) {
		this.addititonalCDetailList = addititonalCDetailList;
	}

	public SalesBasicPo getSalesODPo() {
		return salesODPo;
	}

	public void setSalesODPo(SalesBasicPo salesODPo) {
		this.salesODPo = salesODPo;
	}

	public SalesBasicPo getSalesOSPo() {
		return salesOSPo;
	}

	public void setSalesOSPo(SalesBasicPo salesOSPo) {
		this.salesOSPo = salesOSPo;
	}

	public List<SalesDetailPo> getGoodsInfoList() {
		return goodsInfoList;
	}

	public void setGoodsInfoList(List<SalesDetailPo> goodsInfoList) {
		this.goodsInfoList = goodsInfoList;
	}

	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}

	public List<SalesBasicPo> getSalesBasicList() {
		return salesBasicList;
	}

	public void setSalesBasicList(List<SalesBasicPo> salesBasicList) {
		this.salesBasicList = salesBasicList;
	}

	public InTransitPo getInTransitPo() {
		return inTransitPo;
	}

	public void setInTransitPo(InTransitPo inTransitPo) {
		this.inTransitPo = inTransitPo;
	}

	public List<InTransitPo> getInTransitStateList() {
		return inTransitStateList;
	}

	public void setInTransitStateList(List<InTransitPo> inTransitStateList) {
		this.inTransitStateList = inTransitStateList;
	}

	public InTransitDetailsMgr getInTransitDetailsMgr() {
		return inTransitDetailsMgr;
	}

	public void setInTransitDetailsMgr(InTransitDetailsMgr inTransitDetailsMgr) {
		this.inTransitDetailsMgr = inTransitDetailsMgr;
	}

	/**
	 * 初始化在途查询页面
	 */
	public String initInTransitDetailsSel() {

		String salesId = Utility.getName(request.getParameter("hid"));
		request.setAttribute("ssesbsalesid", salesId);
		SalesBasicPo salesPo = new SalesBasicPo();
		salesPo.setSsesbsalesid(salesId);
		salesBasicPo = inTransitDetailsMgr.getSalesBasicInfo(salesPo);
		inTransitStateList = intransitUpdate(salesBasicPo);
		
		//查询重订信息
		rInTransitStateList = inTransitDetailsMgr.getOldInTransitState(salesId);
		
		request.setAttribute("mdpsName",inTransitDetailsMgr.getPsNameInfo(salesId,"1"));   // 门店配送人员姓名
		
		if (Utility.getName(salesBasicPo.getSsesborderstype()).equals("4")){
			request.setAttribute("yxpsName",inTransitDetailsMgr.getPsNameInfo(salesId,"3"));   // 隐形配送人员姓名
		}
		if (Utility.getName(salesBasicPo.getSsesborderstype()).equals("1") || Utility.getName(salesBasicPo.getSsesborderstype()).equals("2")){
			request.setAttribute("jgpsName",inTransitDetailsMgr.getPsNameInfo(salesId,"2"));   // 加工配送人员姓名
		}
		
		return SUCCESS;
	}

	/**
	 * 显示顾客详细信息
	 */
	public String selectInTransitDetails() throws Exception {
				
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPoTmp.setFopparentid("24");
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		String salesId = Utility.getName(request.getParameter("hid"));
		 
		request.setAttribute("ssesbsalesid", salesId);
		SalesBasicPo salesPo = new SalesBasicPo();
		// 顾客详细信息
		salesPo.setSsesbsalesid(salesId);
		 
		salesBasicPo = inTransitDetailsMgr.getSalesBasicInfo(salesPo);
		
		SalesBasicPo ODPo = new SalesBasicPo();
		ODPo.setSsesbsalesid(salesId);

		SalesBasicPo OSPo = new SalesBasicPo();
		OSPo.setSsesbsalesid(salesId);

		// 右眼信息
		salesODPo = new SalesBasicPo();
		salesODPo = inTransitDetailsMgr.getODDetailInfo(ODPo);

		// 左眼信息
		salesOSPo = new SalesBasicPo();
		salesOSPo = inTransitDetailsMgr.getOSDetailInfo(OSPo);

		// 商品详细信息List
		SalesDetailPo salesDetailPo = new SalesDetailPo();
		salesDetailPo.setSsesdsalesid(salesId);

		goodsInfoList = inTransitDetailsMgr.getGoodsInfo(salesDetailPo);

		// 附加费用List
		AdditionalCDetailPo additionalCDetailPo = new AdditionalCDetailPo();
		additionalCDetailPo.setSsesalesid(salesId);

		addititonalCDetailList = inTransitDetailsMgr.getAddititonalCDetail(additionalCDetailPo);

		// 特殊加工要求List
		SpecialPDetailPo specialPDetailPo = new SpecialPDetailPo();
		specialPDetailPo.setSsesdsalesid(salesId);

		specialPDetailList = inTransitDetailsMgr.getSpecialPDetail(specialPDetailPo);

		//套餐主题去重
		List<String> strList = new ArrayList<String>();
		int count = 0;
		for (SalesDetailPo spo : goodsInfoList){
			for (int i = 0; i < strList.size(); i++){
				if (Utility.getName(spo.getSsesdsetmealtitle()).equals(strList.get(i))){
					count = 1;
					break;
				}
			}
			
			if (count == 0){
				strList.add(Utility.getName(spo.getSsesdsetmealtitle()));
			}
		}	
		
		//套餐主题
		StringBuffer buffer = new StringBuffer();
		for (String str : strList){
			buffer.append(str+",");
		}
		
		if (buffer.length() >= 1){
			buffer.delete( buffer.length()-1, buffer.length());
		}
		
		salesBasicPo.setSsesbsetmealtitle(buffer.toString());
		
		String goodsID = Utility.getName(request.getParameter("goodsID"));//库存综合查询，流水里面的单据明细，商品重点显示。
		request.setAttribute("goodsID", goodsID);	
		return SUCCESS;
	}
	
	/**
	 * 显示商品明细出库信息
	 */
	public String selectGoodsOut() throws Exception {
		String salesId = Utility.getName(request.getParameter("hid"));
		request.setAttribute("ssesbsalesid", salesId);
		SalesBasicPo salesPo = new SalesBasicPo();
		// 顾客详细信息
		salesPo.setSsesbsalesid(salesId);
		salesBasicPo = inTransitDetailsMgr.getSalesBasicInfo(salesPo);

		SalesBasicPo ODPo = new SalesBasicPo();
		ODPo.setSsesbsalesid(salesId);

		SalesBasicPo OSPo = new SalesBasicPo();
		OSPo.setSsesbsalesid(salesId);

		// 商品详细信息List
		SalesDetailPo salesDetailPo = new SalesDetailPo();
		salesDetailPo.setSsesdsalesid(salesId);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		goodsInfoList = inTransitDetailsMgr.getGoodsInfo(salesDetailPo);
		
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
				.getInTransitState(salesBasicPo.getSsesbsalesid());

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
				if(temp1.getOrderssalesid().equals("")){
					temp1.setSseitintransitname("委外订单");
				}else{
					temp1.setSseitintransitname("委外订单【<a href=\" javascript:void(0);\" onclick=\"print('"+ temp1.getOrderssalesid() +"')\">"+ temp1.getOrderssalesid() +"</a>】");
				}				
			}

			if ("5".equals(temp1.getSseitstate())) {
				temp1.setSseitintransitname("<a href=\" javascript:void(0);\" onclick=\"details('"+ temp1.getSseitsalesid() +"')\">委外收货</a>");
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
	
	/**
	 * 显示销售单结款记录
	 */
	public String selectSalesLog() throws Exception {

		String salesId = Utility.getName(request.getParameter("hid"));
		request.setAttribute("ssesbsalesid", salesId);
		SalesBasicPo salesPo = new SalesBasicPo();
		// 顾客详细信息
		salesPo.setSsesbsalesid(salesId);
		salesBasicPo = inTransitDetailsMgr.getSalesBasicInfo(salesPo);

		SalesBasicPo ODPo = new SalesBasicPo();
		ODPo.setSsesbsalesid(salesId);

		SalesBasicPo OSPo = new SalesBasicPo();
		OSPo.setSsesbsalesid(salesId);

		// 销售单结款记录List
		SalesLogPo salesLogPo = new SalesLogPo();
		salesLogList = inTransitDetailsMgr.getSalesLog(salesId);

		// 特殊加工要求List
		SpecialPDetailPo specialPDetailPo = new SpecialPDetailPo();
		specialPDetailPo.setSsesdsalesid(salesId);
		specialPDetailList = inTransitDetailsMgr.getSpecialPDetail(specialPDetailPo);
		
		return SUCCESS;
	}
	
	/**
	 * 显示顾客详细信息
	 */
	public String selectInTransitDetails2() throws Exception {

		String salesId = Utility.getName(request.getParameter("hid"));
		String flag = Utility.getName(request.getParameter("flag"));
		String date = Utility.getName(request.getParameter("date"));
		
		request.setAttribute("ssesbsalesid", salesId);
		request.setAttribute("flag", flag);
		request.setAttribute("date", date);
		
		SalesBasicPo salesPo = new SalesBasicPo();
		// 顾客详细信息
		salesPo.setSsesbsalesid(salesId);
		salesBasicPo = inTransitDetailsMgr.getCustomerInfo(salesPo);

		// 商品详细信息List
		SalesDetailPo salesDetailPo = new SalesDetailPo();
		salesDetailPo.setSsesdsalesid(salesId);

		goodsInfoList = inTransitDetailsMgr.getGoodsInfo(salesDetailPo);
		List<SalesLogPo> salesLogList1 = inTransitDetailsMgr.getSalesLog(salesId);
		salesLogList = new ArrayList<SalesLogPo>();
				
		if (flag.equals("5")){
			for (int i = 0; i < salesLogList1.size(); i++){
				if (salesLogList1.get(i).getSseslpaymenttype().equals("3") && salesLogList1.get(i).getSseslconsumptionid().equals("2")){
					salesLogList.add(salesLogList1.get(i));
				}
			}
		}else{
			for (int i = 0; i < salesLogList1.size(); i++){
				if (salesLogList1.get(i).getSseslconsumptionid().equals("2")){
					salesLogList.add(salesLogList1.get(i));
				}
			}
		}
				
		return SUCCESS;
	}
	/**
	 * 显示顾客详细信息
	 */
	public String selectInTransitDetails3() throws Exception {

		String salesId = Utility.getName(request.getParameter("hid"));
		String flag = Utility.getName(request.getParameter("flag"));
		String date = Utility.getName(request.getParameter("date"));
		
		request.setAttribute("ssesbsalesid", salesId);
		request.setAttribute("flag", flag);
		request.setAttribute("date", date);
		
		SalesBasicPo salesPo = new SalesBasicPo();
		// 顾客详细信息
		salesPo.setSsesbsalesid(salesId);
		salesBasicPo = inTransitDetailsMgr.getCustomerInfo(salesPo);

		// 商品详细信息List
		SalesDetailPo salesDetailPo = new SalesDetailPo();
		salesDetailPo.setSsesdsalesid(salesId);

		goodsInfoList = inTransitDetailsMgr.getGoodsInfo(salesDetailPo);
		List<SalesLogPo> salesLogList1 = inTransitDetailsMgr.getSalesLog(salesId);
		salesLogList = new ArrayList<SalesLogPo>();
				
		if (flag.equals("5")){
			for (int i = 0; i < salesLogList1.size(); i++){
				if (salesLogList1.get(i).getSseslpaymenttype().equals("3") && salesLogList1.get(i).getSseslconsumptionid().equals("2")){
					salesLogList.add(salesLogList1.get(i));
				}
			}
		}else{
			for (int i = 0; i < salesLogList1.size(); i++){
				if (salesLogList1.get(i).getSseslconsumptionid().equals("2")){
					salesLogList.add(salesLogList1.get(i));
				}
			}
		}
				
		return SUCCESS;
	}
}
