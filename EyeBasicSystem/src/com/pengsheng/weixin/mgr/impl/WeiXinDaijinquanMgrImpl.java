package com.pengsheng.weixin.mgr.impl;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.CashCouponDao;
import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.ConfigurationDao;
import com.pengsheng.weixin.dao.WeiXinDaijinquanDao;
import com.pengsheng.weixin.mgr.WeiXinDaijinquanMgr;
import com.pengsheng.weixin.persistence.DaijinquanPo;

public class WeiXinDaijinquanMgrImpl implements WeiXinDaijinquanMgr{
	
	private WeiXinDaijinquanDao weiXinDaijinquanDao;
	private ConfigurationDao configurationDao;	
	private CashCouponDao cashCouponDao;
	
	
	
	public CashCouponDao getCashCouponDao() {
		return cashCouponDao;
	}
	public void setCashCouponDao(CashCouponDao cashCouponDao) {
		this.cashCouponDao = cashCouponDao;
	}
	public ConfigurationDao getConfigurationDao() {
		return configurationDao;
	}
	public void setConfigurationDao(ConfigurationDao configurationDao) {
		this.configurationDao = configurationDao;
	}
	public WeiXinDaijinquanDao getWeiXinDaijinquanDao() {
		return weiXinDaijinquanDao;
	}
	public void setWeiXinDaijinquanDao(WeiXinDaijinquanDao weiXinDaijinquanDao) {
		this.weiXinDaijinquanDao = weiXinDaijinquanDao;
	}

	public void insertStoredValueCardFlag(DaijinquanPo daijinquanPo){
		 weiXinDaijinquanDao.insertStoredValueCardFlag(daijinquanPo);
	}
	

	public CashCouponPo insertCashCouponByOpenID(String openID) {
		
    	CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);		
		customerInfoPo = configurationDao.getCustomerInfoByOpenID(customerInfoPo);
		

		DaijinquanPo tcpo = new DaijinquanPo();		
		CashCouponPo cpo = new CashCouponPo();
		tcpo = weiXinDaijinquanDao.selectStoredValueCardFlagPo(tcpo);
		
		if(Utility.getName(tcpo.getWcflag()).equals("1")){
			int kcount = weiXinDaijinquanDao.getDaijinquanCountByOpenID(openID);
			if (kcount > 0 ){
				
				CashCouponPo kpo = weiXinDaijinquanDao.getDaijinquanIngoByOpenID(openID);			
				cpo.setBcccard(Utility.getName(kpo.getBcccard()));
				cpo.setBccamount(Utility.getName(kpo.getBccamount()));
				cpo.setMemberid(Utility.getName(customerInfoPo.getSmecimemberid()));
				cpo.setBcccustomername(Utility.getName(customerInfoPo.getSmeciname()));
				cpo.setBccopenid(openID);

			}else{
				String bccid = "WXDJQ" + GenerateNumber.getInstance().getGenerageNumber();
				cpo.setBcccard(bccid);
				cpo.setBccamount(Utility.getName(tcpo.getWcprice()).equals("") ? "0.00" : Utility.getName(tcpo.getWcprice()));
				cpo.setMemberid(Utility.getName(customerInfoPo.getSmecimemberid()));
				cpo.setBcccustomername(Utility.getName(customerInfoPo.getSmeciname()));
				cpo.setBccopenid(openID);
				cpo.setBccmark("微信生成代金券");
				weiXinDaijinquanDao.insertDaijinquanByOpenID(cpo);
			}
		}		
		return cpo;
	}
	
	public void deleteStoredValueCardFlag(DaijinquanPo daijinquanPo){
		weiXinDaijinquanDao.deleteStoredValueCardFlag(daijinquanPo);
	}
	
	public DaijinquanPo selectStoredValueCardFlagPo(DaijinquanPo daijinquanPo){
		return weiXinDaijinquanDao.selectStoredValueCardFlagPo(daijinquanPo);
	}
	
	public void InStoredValueCardFlag(DaijinquanPo daijinquanPo){
		weiXinDaijinquanDao.deleteStoredValueCardFlag(daijinquanPo);
		weiXinDaijinquanDao.insertStoredValueCardFlag(daijinquanPo);
	}
}
