package com.pengsheng.weixin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.ConfigurationDao;
import com.pengsheng.weixin.persistence.ConfigurationPo;
import com.pengsheng.weixin.persistence.WeiXinIntegralSelectPo;
import com.pengsheng.weixin.persistence.WeiXinMenuCreateReturnCodePo;

public class ConfigurationDaoImpl extends BaseJdbcDaoSupport implements ConfigurationDao {

	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	
	/**
	 * 查询微信配置管理信息
	 */
	public ConfigurationPo getConfigurationDetail(){
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("select top 1 W_CR_ID as wcrid");
		buffer.append(",W_CR_Url as wcrurl");
		buffer.append(",W_CR_Token as wcrtoken");
		buffer.append(",W_CR_KF_Type as wcrkftype");
		buffer.append(",W_CR_KF_URL as wcrkfurl");
		buffer.append(",W_CR_RegisterType as wcrregistertype");
		buffer.append(",W_CR_PingjiaType as wcrpingjiatype");
		buffer.append(",W_CR_YQHYSJF_Type as wcryqhysjftype");
		buffer.append(",W_CR_Personcenter_Isshow as wcrpersoncenterisshow");
		buffer.append(",W_CR_Mycasehistory_Isshow as wcrmycasehistoryisshow");
		buffer.append(",W_CR_JifenOrChuzhi as wcrjifenorchuzhi");
		buffer.append(" from W_Configuration ");

		return (ConfigurationPo) queryForObject(buffer.toString(), null,ConfigurationPo.class);
	}
	
	/**
	 * 新增微信配置管理信息
	 */
	public void insertConfigurationInfo(ConfigurationPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into W_Configuration (W_CR_ID,W_CR_Url,W_CR_Token,W_CR_KF_Type,W_CR_KF_URL,W_CR_RegisterType,W_CR_PingjiaType,W_CR_YQHYSJF_Type,W_CR_Personcenter_Isshow,W_CR_Mycasehistory_Isshow,W_CR_JifenOrChuzhi) values (? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?) ");
		
		params.add(uuid.generate());
		params.add(Utility.getName(po.getWcrurl()));
		params.add(Utility.getName(po.getWcrtoken()));
		params.add(Utility.getName(po.getWcrkftype()));
		params.add(Utility.getName(po.getWcrkfurl()));
		params.add(Utility.getName(po.getWcrregistertype()));
		params.add(Utility.getName(po.getWcrpingjiatype()));
		params.add(Utility.getName(po.getWcryqhysjftype()));
		params.add(Utility.getName(po.getWcrpersoncenterisshow()));
		params.add(Utility.getName(po.getWcrmycasehistoryisshow()));
		params.add(Utility.getName(po.getWcrjifenorchuzhi()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除微信配置管理信息
	 */
	public void deleteConfigurationInfo(){
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from W_Configuration ");
		
		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 * 根据openID查询顾客信息
	 */
	public CustomerInfoPo getCustomerInfoByOpenID(CustomerInfoPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 cast(isnull(S_ME_CI_ConsumptionPrice,0) as numeric(18,2)) as smeciconsumptionprice,S_ME_CI_OpenID as openid,S_ME_CI_CustomerID as smecicustomerid,S_ME_CI_Name as smeciname,S_ME_CI_Sex as smecisex,convert(varchar(10),S_ME_CI_Birthday,120) as smecibirthday,S_ME_CI_Zone as smecizone,S_ME_CI_Phone as smeciphone,S_ME_CI_Address as smeciaddress,S_ME_CI_Integral as smeciintegral,isnull(S_ME_CI_MemberId,'') as smecimemberid ");
		buffer.append(",isnull(S_ME_CI_MemberPicPath,'') as  memberPicPath,S_ME_CI_TJRPhone as  smecitjrphone");
		buffer.append(" from S_ME_CustomerInfo where 1=1 and isnull(S_ME_CI_Sourcecard,'') = '' ");
		
		if (!"".equals(Utility.getName(po.getOpenid()))){
			buffer.append(" and S_ME_CI_OpenID = ?  ");
			params.add(Utility.getName(po.getOpenid()));
		}
		
		if (!"".equals(Utility.getName(po.getSmecicustomerid()))){
			buffer.append(" and S_ME_CI_CustomerID = ? ");
			params.add(Utility.getName(po.getSmecicustomerid()));
		}
		
		if (!"".equals(Utility.getName(po.getSmeciphone()))){
			buffer.append(" and S_ME_CI_Phone = ? ");
			params.add(Utility.getName(po.getSmeciphone()));
		}
		
		if (!"".equals(Utility.getName(po.getSmeciflag()))){
			buffer.append(" and S_ME_CI_Flag = ? ");
			params.add(Utility.getName(po.getSmeciflag()));
		}		
		
		return (CustomerInfoPo) queryForObject(buffer.toString(), params.toArray(),CustomerInfoPo.class);
	}
	
	/**
	 * 修改顾客信息
	 */
	public void updateCustomerInfoByOpenID(CustomerInfoPo po){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update S_ME_CustomerInfo set ");
		buffer.append("S_ME_CI_Name= ? ,");
		buffer.append("S_ME_CI_Sex= ? ,");
		buffer.append("S_ME_CI_Birthday= ? ,");	
//		buffer.append("S_ME_CI_Zone= ? ,");	
//		buffer.append("S_ME_CI_Phone= ? ,");	
		buffer.append("S_ME_CI_Address= ? ");		
		
		
		
		buffer.append(" WHERE S_ME_CI_CustomerID= ? ");
		
		params.add(po.getSmeciname());
		params.add(po.getSmecisex());
		params.add(po.getSmecibirthday());
//		params.add(po.getSmecizone());
//		params.add(po.getSmeciphone());		
		params.add(Utility.getName(po.getSmeciaddress()));		
		params.add(po.getSmecicustomerid());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}	
	
	/**
	 * 修改顾客信息
	 */
	public void updateCustomerInfoWeixinPic(String openID,String picUrl){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update S_ME_CustomerInfo set ");
		buffer.append("S_ME_CI_MemberPicPath= ? ");
		
		buffer.append(" WHERE S_ME_CI_OpenID= ? ");
		
		params.add(picUrl);	
		params.add(openID);
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}	
	
	/**
	 * 解绑微信Openid
	 */
	public void updateClearOpenId(String customerID){
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update S_ME_CustomerInfo set ");
		buffer.append("S_ME_CI_OpenID= '' ");		
		
		buffer.append(" WHERE S_ME_CI_CustomerID= ? ");
		
		params.add(customerID);
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	/**
	 * 根据电话查询是否是老客户
	 */
	public int getCustomerCountByPhone(CustomerInfoPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(S_ME_CI_Phone) from S_ME_CustomerInfo where S_ME_CI_Phone = ? and Isnull(S_ME_CI_Sourcecard, '') = ''");
		
		params.add(Utility.getName(po.getSmeciphone()));	
		
		if (!"".equals(Utility.getName(po.getSmeciflag()))){
			buffer.append(" and S_ME_CI_Flag = ? ");
			params.add(Utility.getName(po.getSmeciflag()));	
		}

		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	/**
	 * 更新老客户openid
	 */
	public void updateCustomerOpenID(CustomerInfoPo po){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update top (1) S_ME_CustomerInfo set S_ME_CI_OpenID = ?,S_ME_CI_UpdateDate=getdate() ");
		params.add(Utility.getName(po.getOpenid()));
		
		if(!"".equals(Utility.getName(po.getSmecitjrphone()))){
			buffer.append(" ,S_ME_CI_TJRPhone = ? ");
			params.add(po.getSmecitjrphone());
		}
		
		buffer.append(" where S_ME_CI_Phone = ? and Isnull(S_ME_CI_Sourcecard, '') = ''");
		params.add(Utility.getName(po.getSmeciphone()));	
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	/**
	 * 新增客户
	 */
	public void insertCustomerOpenID(CustomerInfoPo po){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("declare @memberID varchar(100),@memberCardID varchar(100) ");
		buffer.append("select top 1 @memberCardID = F_MM_ID from F_MemberManagement where F_MM_IsDefault = '1'  ");
		buffer.append("SET @memberID = 'weixin' + ? ");
		params.add(Utility.getName(po.getSmeciphone()));
		
		buffer.append("insert into S_ME_CustomerInfo (S_ME_CI_CustomerID,S_ME_CI_Name,S_ME_CI_Phone,S_ME_CI_MemberId,S_ME_CI_OpenID,S_ME_CI_Integral,S_ME_CI_CardType,S_ME_CI_RegisterDate,S_ME_CI_Flag,S_ME_CI_ShopCode,S_ME_CI_TJRPhone,S_ME_CI_Zone) values(?,'微信注册',?,@memberID,?,0,@memberCardID,getdate(),'1',?,?,?) ");
		
		params.add(uuid.generate());
		params.add(Utility.getName(po.getSmeciphone()));	
		params.add(Utility.getName(po.getOpenid()));
		params.add(Utility.getName(po.getSmecishopcode()));
		params.add(Utility.getName(po.getSmecitjrphone()));
		params.add(Utility.getName(po.getSmecizone()));
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	/**
	 * 查询会员积分兑换的商品总数
	 */
	public int getIntegralExchangeCountByCustomer(CustomerInfoPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(*) from ( ");
		buffer.append("select convert(varchar(10),W_IE_CreatDate,120) as wiecreatdate,B_GI_GoodsName as wiegoodname,W_IE_Flag as wieflag from W_IntegralExchange inner join B_GoodsInfo on W_IE_GoodsID = B_GI_GoodsID where W_IE_CustomerID = ? ");
		buffer.append(")t1 ");
		
		params.add(Utility.getName(po.getSmecicustomerid()));	
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	/**
	 * 查询会员积分兑换的商品总数
	 */
	public List<WeiXinIntegralSelectPo> getIntegralExchangeListByCustomer(CustomerInfoPo po,int start,int size){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from(select ROW_NUMBER() Over (order by wiecreatdate desc) as rowNum,* from ( ");
		buffer.append("select convert(varchar(10),W_IE_CreatDate,120) as wiecreatdate,B_GI_GoodsName as wiegoodname,W_IE_Flag as wieflag from W_IntegralExchange inner join B_GoodsInfo on W_IE_GoodsID = B_GI_GoodsID where W_IE_CustomerID = ? ");
		buffer.append(" ) temp )temp where rowNum > "+start+" and rowNum <= "+ (start + size));
		buffer.append("set rowcount 0");
		
		params.add(Utility.getName(po.getSmecicustomerid()));	
		
		return queryForObjectList(buffer.toString(), params.toArray(),WeiXinIntegralSelectPo.class);
	}
	
	/**
	 * 查询会员消费的配镜单
	 */
	public List<SalesBasicPo> getSalesBillInfoByCustomer(CustomerInfoPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select S_SE_SB_SalesID as ssesbsalesid,B_DP_DepartmentName as ssesbshopName,S_SE_SB_OrdersType as ssesborderstype,convert(varchar(10),S_SE_SB_SalesDatetime,120) as ssesbsalesdatetime ");
		buffer.append("  from uview_SalesBasic inner join B_Departments on S_SE_SB_ShopCode = B_DP_DepartmentID ");
		buffer.append("  where S_SE_SB_CustomerID = ? ");
		buffer.append("        and convert(varchar(10),S_SE_SB_SalesDatetime,120) >= convert(varchar(10),DATEADD(yy, -1, GETDATE() ) ,120) ");
		buffer.append("  order by S_SE_SB_SalesDatetime desc ");

		params.add(Utility.getName(po.getSmecicustomerid()));	
		
		return queryForObjectList(buffer.toString(), params.toArray(),SalesBasicPo.class);
	}

	/**
	 * 查询会员消费的定制配镜单
	 */
	public List<SalesBasicPo> getDzSalesBillInfoByCustomer(CustomerInfoPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select S_SE_SB_SalesID as ssesbsalesid,B_DP_DepartmentName as ssesbshopName,S_SE_SB_OrdersType as ssesborderstype,convert(varchar(10),S_SE_SB_SalesDatetime,120) as ssesbsalesdatetime ");
		buffer.append("  from uview_SalesBasic inner join B_Departments on S_SE_SB_ShopCode = B_DP_DepartmentID ");
		buffer.append("  where S_SE_SB_CustomerID = ? ");
		//buffer.append("        and S_SE_SB_OrdersType in ('2','4') ");
		buffer.append("  order by S_SE_SB_SalesDatetime desc ");

		params.add(Utility.getName(po.getSmecicustomerid()));	
		
		return queryForObjectList(buffer.toString(), params.toArray(),SalesBasicPo.class);
	}
	
	/**
	 * 查询会员消费的配镜单的商品
	 */
	public List<SalesDetailPo> getSalesBillDetailByCustomer(CustomerInfoPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select S_SE_SD_SalesItemName as ssesdsalesitemname,S_SE_SD_Number as ssesdnumber,S_SE_SD_SalesValue as ssesdsalesvalue ");
		buffer.append("from uview_SalesDetail where S_SE_SD_SalesID = ? ");
		
		params.add(Utility.getName(po.getFmmsalesid()));
		
		return queryForObjectList(buffer.toString(), params.toArray(),SalesDetailPo.class);
	}
	
	/**
	 * 根据配镜单号查询在途
	 */
	public SalesBasicPo getSalesBillByCustomer(CustomerInfoPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid,B_DP_DepartmentName as ssesbshopName,convert(varchar(10),S_SE_SB_SalesDatetime,120) as ssesbsalesdatetime,S_SE_SB_OrdersType as ssesborderstype,S_SE_SB_InTransit as ssesbintransit ");
		buffer.append("from uview_SalesBasic inner join B_Departments on S_SE_SB_ShopCode = B_DP_DepartmentID where S_SE_SB_SalesID = ? ");
		
		params.add(Utility.getName(po.getFmmsalesid()));
		
		return (SalesBasicPo) queryForObject(buffer.toString(), params.toArray(),SalesBasicPo.class);
	}
	
	/**
	 * 创建为新菜单后，根据返回值获得中文说明
	 */
	public WeiXinMenuCreateReturnCodePo getCreateMenuReturnTitle(String returnCode){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select W_M_T_ID as wmtid,W_M_T_Title as wmttitle ");
		buffer.append("from W_Menu_CreateReturnCode where W_M_T_ID = '"+ returnCode +"' ");
		
		return (WeiXinMenuCreateReturnCodePo) queryForObject(buffer.toString(), null,WeiXinMenuCreateReturnCodePo.class);
	}
}
