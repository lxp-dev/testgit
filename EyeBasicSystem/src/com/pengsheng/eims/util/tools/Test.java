package com.pengsheng.eims.util.tools;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String a=SMSUtil.getSmsCount("23468","838A0417E27034CB8D45980CA9B6FBF8");
//		System.out.println(a);
		String uid = "804191";
		String auth = "3a32a7757559edbc56da2a8a011";
		String timeDate="2015-03-30 11:35:00";
		String doResult = "";
		try {
			timeDate=timeDate.replaceAll("/","-");	//日期连接符统一为 "-"
			timeDate = DateTool.getDateStr(DateTool.getDate(timeDate, "yyyy-MM-dd HH:mm"));	//统一日期格式到秒
			timeDate=timeDate.replaceAll("/","-");
			timeDate=timeDate.replaceAll(" ","+");
			timeDate=timeDate.replaceAll(":","%3A");
			
//			实时发送
//			doResult = SMSUtil.getInstance().sendSms(uid,auth,"15222239977", "短信时时2015-04-01 12:29:00", "");
//			定时发送
//			doResult = SMSUtil.getInstance().sendSms(uid,auth,"15222239977", "短信定时接口测试2015-03-30 11:31:00", timeDate);
//			短信条数			
			doResult = SMSUtil.getSmsCount(uid,auth);
			System.out.println(doResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
