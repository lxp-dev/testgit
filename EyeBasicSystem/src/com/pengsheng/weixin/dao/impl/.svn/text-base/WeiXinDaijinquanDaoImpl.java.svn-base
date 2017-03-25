package com.pengsheng.weixin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinDaijinquanDao;
import com.pengsheng.weixin.persistence.DaijinquanPo;

public class WeiXinDaijinquanDaoImpl extends BaseJdbcDaoSupport implements WeiXinDaijinquanDao {
	
	
	public void insertStoredValueCardFlag(DaijinquanPo daijinquanPo){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("INSERT INTO W_StoredValueCardFlag ");
		sb.append("            (W_C_Uuid, ");
		sb.append("             W_C_Flag, ");
		sb.append("             W_C_Price) ");
		sb.append("VALUES      (?, ");
		sb.append("             ?, ");
		sb.append("             ?) ");
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(daijinquanPo.getWcflag()));
		params.add(Utility.getName(daijinquanPo.getWcprice()));
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	/**
	 * 根据openID新增代金券
	 */
	public void insertDaijinquanByOpenID(CashCouponPo po){
		
		
		StringBuffer sb = new StringBuffer();
		sb.append("insert into B_CashCoupon(B_CC_ID,B_CC_Card,B_CC_Amount, ");
		sb.append("B_CC_BeginDate,B_CC_EndDate,B_CC_Type,B_CC_Expense,B_CC_Mark,B_CC_CardPerson,B_CC_CardDate,B_CC_UseFlag,B_CC_openID,B_CC_wxflag) ");
		sb.append("values(?,?,?,getdate(),getdate()+30,?,?,?,?,getdate(),?,?,'1') ");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(po.getBcccard()));
		params.add(Utility.getName(po.getBccamount()));
		params.add(Utility.getName("1, 2, 3, 4, 5"));
		params.add(Utility.getName("0"));
		params.add(Utility.getName(po.getBccmark()));
		params.add(Utility.getName(po.getBcccardperson()));
		params.add("0");
		params.add(Utility.getName(po.getBccopenid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	/**
	 * 根据openID判断之前是否使用过代金券
	 */
	public int getDaijinquanCountByOpenID(String openID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(B_CC_ID) from B_CashCoupon where B_CC_openID = ? and isnull(B_CC_UseFlag,'') <> '1' and B_CC_Amount = (select W_C_Price from W_StoredValueCardFlag)");
		
		params.add(Utility.getName(openID));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 根据openID获取使用过代金券
	 */
	public CashCouponPo getDaijinquanIngoByOpenID(String openID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 B_CC_Card as bcccard,B_CC_Amount as bccamount from B_CashCoupon where B_CC_openID = ? and isnull(B_CC_UseFlag,'') <> '1' and B_CC_Amount = (select W_C_Price from W_StoredValueCardFlag)");

		params.add(Utility.getName(openID));
		
		return (CashCouponPo) queryForObject(buffer.toString(),params.toArray(),CashCouponPo.class);
	}
	
	public void deleteStoredValueCardFlag(DaijinquanPo daijinquanPo){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("delete from  W_StoredValueCardFlag ");
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	public DaijinquanPo selectStoredValueCardFlagPo(DaijinquanPo daijinquanPo){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT top 1 W_C_Uuid as wcuuid, ");
		sb.append("       W_C_Flag as wcflag, ");
		sb.append("       W_C_Price as wcprice  ");
		sb.append("FROM   W_StoredValueCardFlag ");
		return (DaijinquanPo)queryForObject(sb.toString(), params.toArray(), DaijinquanPo.class);
	}
	
	public CashCouponPo getCashCouponW() {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select top 1 B_CC_Card as bcccard, ");
		sb.append("B_CC_Amount as bccamount ");
		sb.append("from B_CashCoupon where 1=1 and B_CC_UseFlag='0'  ");
		sb.append("and B_CC_wxflag='1' and isnull(B_CC_openID,'')=''  ");
		sb.append("and convert(varchar(10),B_CC_BeginDate,120)<=convert(varchar(10),getdate(),120) "); 
		sb.append("and convert(varchar(10),B_CC_EndDate,120)>=convert(varchar(10),getdate(),120)  ");

		return (CashCouponPo)queryForObject(sb.toString(), params.toArray(), CashCouponPo.class);
	}
	
	public void updateCashCouponW(CashCouponPo cashCouponPo) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update B_CashCoupon set  B_CC_openID = ? ");
		sb.append("where B_CC_Card =? ");
		
		params.add(Utility.getName(cashCouponPo.getBccopenid()));
		params.add(Utility.getName(cashCouponPo.getBcccard()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
		
	}

}
