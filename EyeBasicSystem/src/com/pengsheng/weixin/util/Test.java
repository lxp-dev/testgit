package com.pengsheng.weixin.util;

import net.sf.json.JSONObject;

import com.pengsheng.weixin.msgtemplatepo.TemplateBase;
import com.pengsheng.weixin.msgtemplatepo.TemplateEntityservicesOrder;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new Test().taskOrderMessage("wxec2143f83840f9e6", "d4624c36b6795d1d99dcf0547af5443d", "oyEB1uP03x2lBotC3SSuH1Cxypd8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 推送微信服务点评消息
	 * 
	 * @param detail
	 * @return
	 */
	public static void taskOrderMessage(String appId, String appSecret, String openId) throws Exception {

		TemplateBase temp = new TemplateBase();
		TemplateEntityservicesOrder data = new TemplateEntityservicesOrder();
		
		data.setFirst("您的眼镜已经加工完成，可以取镜。", "#173177");
		data.setKeyword1("X1274720161118115250", null);
		data.setKeyword2("师大店", null);
		data.setKeyword3("2016年7月21日 18:36", null);
		data.setRemark("如非本人取货或有其他疑问，请尽快与我们联系：022-1111111", null);
		temp.setData(data);
		temp.setTemplate_id("L68_V9vEA5rNv0WdhTGPfCjt4BzogNApv8rECDA8l10");
		temp.setTouser(openId);
		temp.setTopcolor("#FFFFFF");
		temp.setUrl("http://weixin.qq.com/download");
		
		String jsonTempl = JSONObject.fromObject(temp).toString();

		String accessToken = WeixinUtil
				.getAccessToken(appId, appSecret).getToken();
		String outPrint = WeixinNewUtil.sendTemplateMsg(jsonTempl,
				accessToken);
		System.out.println(outPrint);
	}
}
