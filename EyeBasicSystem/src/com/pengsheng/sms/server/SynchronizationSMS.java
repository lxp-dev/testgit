package com.pengsheng.sms.server;

import com.pengsheng.sms.server.dao.SmsServiceDao;
import com.pengsheng.sms.server.dao.impl.SmsServiceDaoImpl;
import com.pengsheng.sms.server.persistence.SmsPo;

public class SynchronizationSMS {

	// private IRmiService accountService;
//
//	public static SynchronizationSMS getInstance() {
//		return new SynchronizationSMS();
//	}

	public void insertSMS(SmsPo smsPo) throws Exception {
		SmsServiceDao smsServiceDao = new SmsServiceDaoImpl();

//		try {
//			smsServiceDao.open();
//			
//			smsServiceDao.insertSMS(smsPo);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally{
//			smsServiceDao.close();
//		}
	}

//	/**
//	 * @param args
//	 * @throws Exception
//	 */
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//
//		SmsPo smsPo = new SmsPo();
//		smsPo.setFromid("");
//		smsPo.setPhone("0000");
//		smsPo.setSmsid("10");
//		smsPo.setContent("aaa");
//
//		SynchronizationSMS.getInstance().insertSMS(smsPo);
//	}
}
