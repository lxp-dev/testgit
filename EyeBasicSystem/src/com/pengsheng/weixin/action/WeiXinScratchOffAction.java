package com.pengsheng.weixin.action;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.mgr.ConfigurationMgr;
import com.pengsheng.weixin.mgr.WeiXinLuckDrawSetMgr;
import com.pengsheng.weixin.persistence.WeiXinLuckDrawPo;
import com.pengsheng.weixin.po.Gift;
import com.pengsheng.weixin.util.LotteryUtil;

public class WeiXinScratchOffAction extends BaseAction{
	
	private WeiXinLuckDrawPo weiXinLuckDrawPo;
	private List<WeiXinLuckDrawPo> weiXinLuckDrawList;
	private WeiXinLuckDrawSetMgr weiXinLuckDrawSetMgr;
	private ConfigurationMgr configurationMgr;
	
	/**
	 * 初始化幸运抽奖查询
	 */
	public String initWeiXinScratchOffSel() {
		
		String openID = Utility.getName(request.getParameter("openID"));
		request.setAttribute("openID",openID);
		
		WeiXinLuckDrawPo wpo = new WeiXinLuckDrawPo();
		weiXinLuckDrawPo = weiXinLuckDrawSetMgr.selectWeiXinLuckDrawSet(wpo);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String nowDate = sdf.format(new Date());
		String startDate = weiXinLuckDrawPo.getWcjsactivitiesstratdate();
		String endDate = weiXinLuckDrawPo.getWcjsactivitiesenddate();
		
		Calendar nowCal = Calendar.getInstance();
		Calendar startCal = Calendar.getInstance();
		Calendar endCal = Calendar.getInstance();
		
		try {
			nowCal.setTime(sdf.parse(nowDate));
			startCal.setTime(sdf.parse(startDate));
			endCal.setTime(sdf.parse(endDate));

			if( !(nowCal.getTimeInMillis() >= startCal.getTimeInMillis() && 
					nowCal.getTimeInMillis() <= endCal.getTimeInMillis()) ) {
				request.setAttribute("expired", "expired");
				if(nowCal.getTimeInMillis() < startCal.getTimeInMillis()) {
					request.setAttribute("activity", "活动尚未开始，敬请期待！");
				}
				if(nowCal.getTimeInMillis() > endCal.getTimeInMillis()) {
					request.setAttribute("activity", "活动已结束，谢谢您的关注！");
				}
				return "expired";
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return "expired";
		}
		
		
		wpo.setWcjopenid(openID);
		weiXinLuckDrawList = weiXinLuckDrawSetMgr.selectWeiXinLuckDrawSetList(wpo);
		
		return SUCCESS;
	}
	
	/**
	 * 新增幸运中奖记录
	 */
	public void insertWeiXinLuckDraw()  throws Exception {

		String openID = Utility.getName(request.getParameter("openID"));		
		String memberPhone = Utility.getName(request.getParameter("memberPhone"));
		String prize = Utility.getName(request.getParameter("prize"));
		
		request.setAttribute("openID",openID);
		request.setAttribute("memberPhone",memberPhone);		
		request.setAttribute("prize",prize);
		
		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);
		
		WeiXinLuckDrawPo wpo = new WeiXinLuckDrawPo();
		wpo = weiXinLuckDrawSetMgr.selectWeiXinLuckDrawSet(wpo);
		
		String goodname = "";
		if (prize.equals("1")){
			goodname = Utility.getName(wpo.getWcjsprizesizegoods1());
		}
		if (prize.equals("2")){
			goodname = Utility.getName(wpo.getWcjsprizesizegoods2());
		}
		if (prize.equals("3")){
			goodname = Utility.getName(wpo.getWcjsprizesizegoods3());
		}
		if (prize.equals("4")){
			goodname = Utility.getName(wpo.getWcjsprizesizegoods4());
		}
		if (prize.equals("5")){
			goodname = Utility.getName(wpo.getWcjsprizesizegoods5());
		}
		
		weiXinLuckDrawPo = new WeiXinLuckDrawPo();
		weiXinLuckDrawPo.setWcjphone(memberPhone);
		weiXinLuckDrawPo.setWcjcustomerid(Utility.getName(customerInfoPo.getSmecicustomerid()));
		weiXinLuckDrawPo.setWcjmemberid(Utility.getName(customerInfoPo.getSmecimemberid()));
		weiXinLuckDrawPo.setWcjopenid(openID);
		weiXinLuckDrawPo.setWcjprizesize(prize);
		weiXinLuckDrawPo.setWcjactivitiesstratdate(Utility.getName(wpo.getWcjsactivitiesstratdate()));
		weiXinLuckDrawPo.setWcjactivitiesenddate(Utility.getName(wpo.getWcjsactivitiesenddate()));
		weiXinLuckDrawPo.setWcjprizegoodname(goodname);
		
		weiXinLuckDrawSetMgr.insertWeiXinLuckDraw(weiXinLuckDrawPo);
		weiXinLuckDrawSetMgr.insertWeiXinLuckDrawLog(weiXinLuckDrawPo);
		
		wpo.setWcjopenid(openID);
		weiXinLuckDrawList = weiXinLuckDrawSetMgr.selectWeiXinLuckDrawSetList(wpo);

		PrintWriter out = null;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();
		
		if(weiXinLuckDrawList.size() > 0){
			out.println("<s:iterator value='weiXinLuckDrawList'>");

			Iterator<WeiXinLuckDrawPo> it = weiXinLuckDrawList.iterator();	
			if (it.hasNext()) {
				while (it.hasNext()) {
					WeiXinLuckDrawPo epo = it.next();
					out.println("<tr>");
					out.println("<td width='10%'>" + Utility.getName(epo.getWcjwindate()) + "</td>");
					out.println("<td width='10%'>" + (Utility.getName(epo.getWcjprizesize()) + "等奖") + "</td>");
					out.println("<td width='20%'>" + Utility.getName(epo.getWcjprizegoodname()) + "</td>");
					out.println("<td width='10%'>" + (Utility.getName(epo.getWcjflag()).equals("1") ? "已领取" : "未领取") + "</td>");
					out.println("</tr>");
				}
			}
			
			out.println("</s:iterator>");
		}
		//释放流
		out.flush();
		out.close();

	}
	
	/**
	 * 新增幸运抽奖记录
	 */
	public void insertWeiXinLuckDrawLog() throws Exception {

		String openID = Utility.getName(request.getParameter("openID"));		
		request.setAttribute("openID",openID);
		
		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);

		weiXinLuckDrawPo = new WeiXinLuckDrawPo();
		weiXinLuckDrawPo.setWcjcustomerid(Utility.getName(customerInfoPo.getSmecicustomerid()));
		weiXinLuckDrawPo.setWcjmemberid(Utility.getName(customerInfoPo.getSmecimemberid()));
		weiXinLuckDrawPo.setWcjopenid(openID);
		
		WeiXinLuckDrawPo wpo = new WeiXinLuckDrawPo();
		wpo = weiXinLuckDrawSetMgr.selectWeiXinLuckDrawSet(wpo);
				
		String data = "";
		String errorMsg = "";
		
		//2、从数据库读取设定的奖品数据
		List<Gift> gifts = new ArrayList<Gift>();
		gifts.add(new Gift(1,"1","一等奖",new BigDecimal(Utility.getName(wpo.getWcjsprizesizeprobability1())).multiply(new BigDecimal(0.01)).doubleValue()));
		gifts.add(new Gift(2,"2","二等奖",new BigDecimal(Utility.getName(wpo.getWcjsprizesizeprobability2())).multiply(new BigDecimal(0.01)).doubleValue()));
		gifts.add(new Gift(3,"3","三等奖",new BigDecimal(Utility.getName(wpo.getWcjsprizesizeprobability3())).multiply(new BigDecimal(0.01)).doubleValue()));

		//System.out.println(1-new BigDecimal(Utility.getName(wpo.getWcjsprizesizeprobability1())).multiply(new BigDecimal(0.01)).doubleValue()-new BigDecimal(Utility.getName(wpo.getWcjsprizesizeprobability2())).multiply(new BigDecimal(0.01)).doubleValue()-new BigDecimal(Utility.getName(wpo.getWcjsprizesizeprobability3())).multiply(new BigDecimal(0.01)).doubleValue());
		//如果没有设定奖品，设定一个临时非中奖的伪奖品
		gifts.add(new Gift(4,"gift","gift",1-new BigDecimal(Utility.getName(wpo.getWcjsprizesizeprobability1())).multiply(new BigDecimal(0.01)).doubleValue()-new BigDecimal(Utility.getName(wpo.getWcjsprizesizeprobability2())).multiply(new BigDecimal(0.01)).doubleValue()-new BigDecimal(Utility.getName(wpo.getWcjsprizesizeprobability3())).multiply(new BigDecimal(0.01)).doubleValue()));
		
		//进行概率计算，筛选中奖奖品
		List<Double> orignalRates = new ArrayList<Double>(gifts.size());
		for (Gift gift : gifts) {
			double probability = gift.getProbability();
			if (probability < 0) {
				probability = 0;
			}
			orignalRates.add(probability);
		}
		
		Gift resultGift = null;
		resultGift = gifts.get(LotteryUtil.lottery(orignalRates));
		
		int count = weiXinLuckDrawSetMgr.selectWeiXinLuckDrawLogCount(weiXinLuckDrawPo);    // 抽奖次数
		if (!Utility.getName(wpo.getWcjspersonnumber()).trim().equals("") && (count >= Integer.valueOf(Utility.getName(wpo.getWcjspersonnumber())))){
			errorMsg = "invalid";
		}
		
		count = weiXinLuckDrawSetMgr.selectWeiXinLuckDrawCount(weiXinLuckDrawPo);  // 中奖次数
		if (!Utility.getName(wpo.getWcjspersonlucknumber()).equals("") && (count >= Integer.valueOf(Utility.getName(wpo.getWcjspersonlucknumber())))){
			errorMsg = "getsn";
		}
		
		wpo.setWcjopenid("");
		count = weiXinLuckDrawSetMgr.selectWeiXinLuckDrawLogCount(wpo);    // 抽奖总数
		if (!Utility.getName(wpo.getWcjsdaynumber()).equals("") && (count >= Integer.valueOf(Utility.getName(wpo.getWcjsdaynumber())))){
			errorMsg = "invalid2";
		}
		
		if (errorMsg.equals("")){
			weiXinLuckDrawSetMgr.insertWeiXinLuckDrawLog(weiXinLuckDrawPo);	
		}
				
		//返回页面Reponse信息
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
//		System.out.println("index = " + resultGift.getIndex());
		
		//判断奖品数量
		int goodscount = 0;
		switch(resultGift.getIndex()){
			case 1:
				goodscount = weiXinLuckDrawSetMgr.selectWeiXinLuckDrawCount(1);
				if (goodscount >= Integer.valueOf(Utility.getName(wpo.getWcjsprizesizegoodsnumber1()))){
					resultGift.setIndex(4);
				}
				break;
			case 2:
				goodscount = weiXinLuckDrawSetMgr.selectWeiXinLuckDrawCount(2);
				if (goodscount >= Integer.valueOf(Utility.getName(wpo.getWcjsprizesizegoodsnumber2()))){
					resultGift.setIndex(4);
				}
				break;
			case 3:
				goodscount = weiXinLuckDrawSetMgr.selectWeiXinLuckDrawCount(3);
				if (goodscount >= Integer.valueOf(Utility.getName(wpo.getWcjsprizesizegoodsnumber3()))){
					resultGift.setIndex(4);
				}
				break;
			default:
				resultGift.setIndex(4);
				break;
		}
		
		if(resultGift.equals("gift")){
		    data ="{\"error\":\""+ errorMsg +"\",\"success\":false,\"prizetype\":\"" + resultGift.getIndex() + "\",\"sn\":\"\"}";
		}else{
		    data ="{\"error\":\""+ errorMsg +"\",\"success\":true,\"prizetype\":\"" + resultGift.getIndex() + "\",\"sn\":\"\"}";
		}
        //System.out.println(data);
		out.println(data);
		out.flush();
		out.close();
		
	}

	public WeiXinLuckDrawPo getWeiXinLuckDrawPo() {
		return weiXinLuckDrawPo;
	}

	public void setWeiXinLuckDrawPo(WeiXinLuckDrawPo weiXinLuckDrawPo) {
		this.weiXinLuckDrawPo = weiXinLuckDrawPo;
	}

	public WeiXinLuckDrawSetMgr getWeiXinLuckDrawSetMgr() {
		return weiXinLuckDrawSetMgr;
	}

	public void setWeiXinLuckDrawSetMgr(WeiXinLuckDrawSetMgr weiXinLuckDrawSetMgr) {
		this.weiXinLuckDrawSetMgr = weiXinLuckDrawSetMgr;
	}

	public ConfigurationMgr getConfigurationMgr() {
		return configurationMgr;
	}

	public void setConfigurationMgr(ConfigurationMgr configurationMgr) {
		this.configurationMgr = configurationMgr;
	}

	public List<WeiXinLuckDrawPo> getWeiXinLuckDrawList() {
		return weiXinLuckDrawList;
	}

	public void setWeiXinLuckDrawList(List<WeiXinLuckDrawPo> weiXinLuckDrawList) {
		this.weiXinLuckDrawList = weiXinLuckDrawList;
	}
	
}
