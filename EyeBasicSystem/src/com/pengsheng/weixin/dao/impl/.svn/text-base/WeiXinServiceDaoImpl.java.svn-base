package com.pengsheng.weixin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.CustomerComplainPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinServiceDao;
import com.pengsheng.weixin.persistence.WeiXinLuckDrawPo;

public class WeiXinServiceDaoImpl extends BaseJdbcDaoSupport implements WeiXinServiceDao {
	
	/**
	 * 获取微信用户在eims系统中的资料
	 * 
	 * @return
	 */
	public CustomerInfoPo getWeiXinCustomer(String openID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 S_ME_CI_CustomerID as smecicustomerid,S_ME_CI_Phone as smeciphone,isnull(S_ME_CI_Integral,0) as smeciintegral,S_ME_CI_Name as smeciname ");
		buffer.append(" from  S_ME_CustomerInfo where S_ME_CI_OpenID=? ");
		
		params.add(openID);		
		
		return (CustomerInfoPo) queryForObject(buffer.toString(), params.toArray(), CustomerInfoPo.class);
	}
	
	/**
	 * 获取销售记录
	 * 
	 * @return
	 */
	public int getSalesCount(String openID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(S_SE_SB_SalesID)  from ");	
		buffer.append("uview_SalesBasic inner join S_ME_CustomerInfo on S_SE_SB_CustomerID=S_ME_CI_CustomerID AND S_ME_CI_OpenID=? ");
		buffer.append("where S_SE_SB_ValueFlag='1' ");
		buffer.append("and convert(varchar(10),S_SE_SB_PosDatetime,23)>=convert(varchar(10),dateadd(year,-1,getdate()),23) ");
		buffer.append("and convert(varchar(10),S_SE_SB_PosDatetime,23)<=convert(varchar(10),getdate(),23) ");
		
		params.add(openID);
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	/**
	 * 获取销售门店信息
	 * 
	 * @return
	 */
	public List<DepartmentsPo> getDepartmentsList(){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select B_DP_DepartmentID as bdpdepartmentid,");
		buffer.append("B_DP_DepartmentName as bdpdepartmentname,");
		buffer.append("B_DP_Phone as bdpphone,");
		buffer.append("B_DP_Address as bdpaddress,");
		buffer.append("B_DP_LocationX as bdplocationx,");
		buffer.append("B_DP_LocationY as bdplocationy,");
		buffer.append("isnull(B_DP_PicUrl,'') as bdppicurl");
		buffer.append(" from B_Departments");
		buffer.append(" where B_DP_Type='1' and B_DP_IsClosed='0' and (B_DP_Issee='0' or B_DP_Issee is null) ");
		buffer.append("order by B_DP_DepartmentID");
		
		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 获取销售门店信息Po
	 * 
	 * @return
	 */
	public DepartmentsPo getDepartmentsPo(DepartmentsPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select B_DP_DepartmentID as bdpdepartmentid,");
		buffer.append("B_DP_DepartmentName as bdpdepartmentname,");
		buffer.append("B_DP_FullName as bdpfullname,");
		buffer.append("B_DP_Phone as bdpphone,");
		buffer.append("B_DP_Address as bdpaddress,");
		buffer.append("B_DP_LocationX as bdplocationx,");
		buffer.append("B_DP_LocationY as bdplocationy,");
		buffer.append("B_DP_PicUrl as bdppicurl,");
		buffer.append("B_DP_SPicUrl as bdpspicurl");
		buffer.append(" from B_Departments");
		buffer.append(" where B_DP_Type='1' and B_DP_IsClosed='0' ");
		
		if(!Utility.getName(po.getBdpdepartmentid()).equals("")){
			buffer.append(" and B_DP_DepartmentID = ? ");
			params.add(po.getBdpdepartmentid());	
		}
		
		buffer.append("order by B_DP_DepartmentID");
		
		return (DepartmentsPo)queryForObject(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 获取会员中奖信息
	 * 
	 * @return
	 */
	public WeiXinLuckDrawPo getLuckDrawPo(String openID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select W_CJ_PrizeSize as wcjprizesize,");
		buffer.append("select case W_CJ_PrizeSize when '1' then '一等奖' ");
		buffer.append(" when '2' then '二等奖' ");
		buffer.append(" when '3' then '三等奖' ");
		buffer.append(" when '4' then '四等奖' ");
		buffer.append(" when '5' then '五等奖' ");
		buffer.append(" end as wcjprizesize, ");
		buffer.append("W_CJ_PrizeGoodName as wcjprizegoodname,");
		buffer.append("W_CJ_WinDate as wcjwindate, ");
		buffer.append("W_CJ_Flag as wcjflag  ");
		buffer.append(" from dbo.W_LuckDraw ");
		buffer.append(" where isnull(W_CJ_PrizeSize,0)<>0 ");
		buffer.append(" and W_CJ_WinDate is not null ");
		buffer.append(" and W_CJ_OpenId=? ");	

		params.add(openID);	
		
		return (WeiXinLuckDrawPo)queryForObject(buffer.toString(), params.toArray(), WeiXinLuckDrawPo.class);
	}
	/**
	 * 获取会员中奖信息列表
	 * 
	 * @return
	 */
	public List<WeiXinLuckDrawPo> getLuckDrawlist(String openID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select W_CJ_PrizeSize as wcjprizesize,");
		buffer.append("select case W_CJ_PrizeSize when '1' then '一等奖' ");
		buffer.append(" when '2' then '二等奖' ");
		buffer.append(" when '3' then '三等奖' ");
		buffer.append(" when '4' then '四等奖' ");
		buffer.append(" when '5' then '五等奖' ");
		buffer.append(" end as wcjprizesize, ");
		buffer.append("W_CJ_PrizeGoodName as wcjprizegoodname,");
		buffer.append("W_CJ_WinDate as wcjwindate, ");
		buffer.append("W_CJ_Flag as wcjflag  ");
		buffer.append(" from dbo.W_LuckDraw ");
		buffer.append(" where isnull(W_CJ_PrizeSize,0)<>0 ");
		buffer.append(" and W_CJ_WinDate is not null ");
		buffer.append(" and W_CJ_OpenId=? ");	

		params.add(openID);	
		
		return queryForObjectList(buffer.toString(), params.toArray(), WeiXinLuckDrawPo.class);
	}

	/**
	 * 获取投诉PO
	 * @param customerComplainPo
	 * @return
	 */
	public CustomerComplainPo selectCustomerComplainPo(CustomerComplainPo customerComplainPo){
	    StringBuffer buffer = new StringBuffer();
	    List params = new ArrayList();

	    buffer.append("SELECT TOP 1 ");
	    buffer.append("             S_ME_CI_MemberId	AS smecccustomermemberid, ");
	    buffer.append("             S_ME_CI_Name		AS	smecccustomername, ");
	    buffer.append("             S_ME_CI_Phone		AS smecccustomerphone, ");
	    buffer.append("             getdate()+2			AS smeccintendhandledate ");
	    buffer.append("FROM   S_ME_CustomerInfo ");
	    buffer.append("WHERE  1=1 ");

	    if (!"".equals(Utility.getName(customerComplainPo.getSmecccustomermemberid()))) {
	      buffer.append("AND  S_ME_CI_OpenID = ? ");
	      params.add(Utility.getName(customerComplainPo.getSmecccustomermemberid()));
	    }

	    return (CustomerComplainPo)queryForObject(buffer.toString(), params.toArray(), CustomerComplainPo.class);
	}
}
