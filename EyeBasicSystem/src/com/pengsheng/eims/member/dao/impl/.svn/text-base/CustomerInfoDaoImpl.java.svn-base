package com.pengsheng.eims.member.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.MemberExportPo;
import com.pengsheng.eims.system.persistence.MemberManagementPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Tools;
import com.pengsheng.eims.util.tools.Utility;

public class CustomerInfoDaoImpl extends BaseJdbcDaoSupport implements CustomerInfoDao {
	
	public static Properties oracleDriver= Tools.getProperty("/config/", "arjdbc.properties");
	private static String ip = oracleDriver.getProperty("jdbc.ip");
	private static String user = oracleDriver.getProperty("jdbc.username");
	private static String pwd = oracleDriver.getProperty("jdbc.password");

	/**
	 * 查询会员信息
	 */
	public CustomerInfoPo getCustomerInfo(
			CustomerInfoPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("SELECT top 1 ");
		
		buffer.append("S_ME_CustomerInfo.S_ME_CI_CustomerID                       as smecicustomerid,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Name                             as smeciname,");
		buffer.append("year(getdate())-year(S_ME_CustomerInfo.S_ME_CI_Birthday)   as fmmage,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Sex                              as smecisex,");
		buffer.append("convert(varchar(10),S_ME_CustomerInfo.S_ME_CI_Birthday,23) as smecibirthday,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Email                            as smeciemail,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Address                          as smeciaddress,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Zone                             as smecizone,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_PostCode                         as smecipostcode,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Phone                            as smeciphone,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_MemberId as smecimemberid,S_ME_CustomerInfo.S_ME_CI_CardType as smecicardtype,");
		
		buffer.append("case ");
		buffer.append("	when isnull(S_ME_CustomerInfo.S_ME_CI_FCustomerId,'') <> '' then c1.S_ME_CI_Integral  ");
		buffer.append(" when isnull(S_ME_CustomerInfo.S_ME_CI_FCustomerId,'') = ''  then isnull(S_ME_CustomerInfo.S_ME_CI_Integral,0) ");
		buffer.append("end                                                                                     as smeciintegral,");
		
		buffer.append("S_ME_CustomerInfo.S_ME_CI_ShopCode as smecishopcode,S_ME_CustomerInfo.S_ME_CI_Remark    as smeciremark,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_CustomerType                                                  as smecicustomertype,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_work as smeciwork,B_WorkType.B_WT_Name as smeciworkname,S_ME_CustomerInfo.S_ME_CI_IdentityCard as smeidentitycard,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_PersonType                                                    as smecipersontype,");
		buffer.append("B_PT_Name                                                                               as smecipersontypename,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_QqNumber                                                      as smeciqqnumber,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Interest                                                      as smeciinterest,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_MemberOrigin as smecimemberorigin,B_MemberOrigin.B_MO_Name    as smecimemberoriginname, ");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_RegisterDate                                                  as smeciregisterdate,");
		buffer.append("F_MM_MemberName                                                                         as fmmmembername,");
		buffer.append("F_MM_UP                                                                                 as fmmup,");
		buffer.append("F_MM_DOWN                                                                               as fmmdown,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_MemberPicPath                                                 as memberPicPath,");
		buffer.append("F_MM_Discount                                                                           as fmmdiscount,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Phone2                                                        as smeciphone2,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Phone3                                                        as smeciphone3,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Sourcecard                                                    as smecisourcecard,");
		buffer.append("B_DP_DepartmentName                                                                     as smecishopcode,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_ConsumptionNumber                                             as smeciconsumptionnumber,");
		buffer.append("cast(isnull(S_ME_CustomerInfo.S_ME_CI_ConsumptionPrice,0) as numeric(18,2))             as smeciconsumptionprice, ");
		buffer.append("isnull(S_ME_CustomerInfo.S_ME_CI_FCustomerId,'')                                        as smecifcustomerid, ");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_ModelworkersCode                                              as smecimodelworkerscode, ");		
		buffer.append("c1.S_ME_CI_Name                                                                         as smecifmemberidname, ");

		buffer.append("isnull(S_ME_CustomerInfo.S_ME_CI_Area1,'') as smeciarea1, ");
		buffer.append("isnull(S_ME_CustomerInfo.S_ME_CI_Area2,'') as smeciarea2, ");
		buffer.append("isnull(S_ME_CustomerInfo.S_ME_CI_Area3,'') as smeciarea3, ");
		buffer.append("isnull(S_ME_CustomerInfo.S_ME_CI_Area4,'') as smeciarea4, ");
		buffer.append("isnull(S_ME_CustomerInfo.S_ME_CI_Area5,'') as smeciarea5, ");
		buffer.append("isnull(f1.F_A_Name,'')                     as smeciarea1name, ");
		buffer.append("isnull(f2.F_A_Name,'')                     as smeciarea2name, ");
		buffer.append("isnull(f3.F_A_Name,'')                     as smeciarea3name, ");
		buffer.append("isnull(f4.F_A_Name,'')                     as smeciarea4name, ");
		buffer.append("isnull(f5.F_A_Name,'')                     as smeciarea5name, ");		
		buffer.append("c1.S_ME_CI_MemberId                        as smecifmemberid, ");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_TJRPhone         as smecitjrphone ");
		
		if(!"".equals(Utility.getName(po.getSmecicustomerid()))){
			buffer.append(",(select count(*) from S_ME_CustomerInfo where S_ME_CI_FCustomerId = ?)             as isnullfcustomerid ");
			params.add(po.getSmecicustomerid());
		}
		
		buffer.append("FROM S_ME_CustomerInfo ");
		buffer.append("left join F_MemberManagement on F_MemberManagement.F_MM_ID=S_ME_CustomerInfo.S_ME_CI_CardType ");
		buffer.append("left join B_WorkType on B_WorkType.B_WT_ID=S_ME_CustomerInfo.S_ME_CI_work ");
		buffer.append("left join B_MemberOrigin on B_MemberOrigin.B_MO_ID=S_ME_CustomerInfo.S_ME_CI_MemberOrigin ");
		buffer.append("left join B_Departments on S_ME_CustomerInfo.S_ME_CI_ShopCode=B_DP_DepartmentID  ");  
		buffer.append("left join B_PersonType on S_ME_CustomerInfo.S_ME_CI_PersonType = B_PT_ID  ");  
		buffer.append("LEFT JOIN S_ME_CustomerInfo c1 ON c1.S_ME_CI_CustomerId = S_ME_CustomerInfo.S_ME_CI_FCustomerId "); 
		
		buffer.append("LEFT JOIN F_Area f1 ON f1.F_A_ID = S_ME_CustomerInfo.S_ME_CI_Area1 and f1.F_A_Level='1' ");
		buffer.append("LEFT JOIN F_Area f2 ON f2.F_A_ID = S_ME_CustomerInfo.S_ME_CI_Area2 and f2.F_A_Level='2' "); 
		buffer.append("LEFT JOIN F_Area f3 ON f3.F_A_ID = S_ME_CustomerInfo.S_ME_CI_Area3 and f3.F_A_Level='3' "); 
		buffer.append("LEFT JOIN F_Area f4 ON f4.F_A_ID = S_ME_CustomerInfo.S_ME_CI_Area4 and f4.F_A_Level='4' "); 
		buffer.append("LEFT JOIN F_Area f5 ON f5.F_A_ID = S_ME_CustomerInfo.S_ME_CI_Area5 and f5.F_A_Level='5' "); 
		
		buffer.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getSmecicustomerid()))){
			buffer.append("and S_ME_CustomerInfo.S_ME_CI_CustomerID = ? ");
			params.add(po.getSmecicustomerid());
		}
		if(!"".equals(Utility.getName(po.getSmecimemberid()))){
			buffer.append("and S_ME_CustomerInfo.S_ME_CI_MemberId = ? ");
			params.add(po.getSmecimemberid());
		}		
		if(!"".equals(Utility.getName(po.getOpenid()))){
			buffer.append("and S_ME_CustomerInfo.S_ME_CI_OpenID = ? ");
			params.add(po.getOpenid());
		}			
		if(!"".equals(Utility.getName(po.getSmeciflag()))){
			buffer.append(" and S_ME_CustomerInfo.S_ME_CI_Flag = ? ");
			params.add(po.getSmeciflag());
		}
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CustomerInfo.S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		return (CustomerInfoPo) queryForObject(buffer.toString(), params.toArray(),
				CustomerInfoPo.class);
	}
	
	
	/**
	 * 获取主子卡全部销售金额
	 */
	public CustomerInfoPo getALLsalesvalues(String salesid) {
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("SELECT ");
		buffer.append("cast(sum(isnull(c1.S_ME_CI_ConsumptionPrice,0)+isnull(c2.S_ME_CI_ConsumptionPrice,0)) as numeric(18,2)) as smeciconsumptionprice ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("LEFT JOIN S_ME_CustomerInfo c1 ON c1.S_ME_CI_CustomerId = S_SE_SalesBasic.S_SE_SB_CustomerID "); 
		buffer.append("LEFT JOIN S_ME_CustomerInfo c2 ON c2.S_ME_CI_CustomerId = c1.S_ME_CI_FCustomerId "); 
		buffer.append("where 1=1 ");
		buffer.append("and S_SE_SB_SalesID = ? ");
		
		params.add(Utility.getName(salesid));
		
		return (CustomerInfoPo) queryForObject(buffer.toString(), params.toArray(),
				CustomerInfoPo.class);
	}
	
	/**
	 * 查询会员信息
	 */
	public int getCustomerInfoCount2(CustomerInfoPo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("SELECT count(S_ME_CI_CustomerID) ");
		buffer.append(" FROM S_ME_CustomerInfo ");
		buffer.append("left join F_MemberManagement on F_MemberManagement.F_MM_ID=S_ME_CustomerInfo.S_ME_CI_CardType ");
		buffer.append("left join B_WorkType on B_WorkType.B_WT_ID=S_ME_CustomerInfo.S_ME_CI_work ");
		buffer.append("left join B_MemberOrigin on B_MemberOrigin.B_MO_ID=S_ME_CustomerInfo.S_ME_CI_MemberOrigin ");
		buffer.append("left join  B_Departments on S_ME_CI_ShopCode=B_DP_DepartmentID  ");  
		
		buffer.append("  where 1=1 ");
		if(!"".equals(Utility.getName(po.getSmecicustomerid()))){
			buffer.append("and S_ME_CI_CustomerID = ? ");
			params.add(po.getSmecicustomerid());
		}
		if(!"".equals(Utility.getName(po.getSmecimemberid()))){
			buffer.append("and S_ME_CI_MemberId = ? ");
			params.add(po.getSmecimemberid());
		}		
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	/**
	 * 查询会员信息
	 */
	public CustomerInfoPo getCustomerInfocall(CustomerInfoPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("SELECT top 1 ");
		
		buffer.append("S_ME_CI_CustomerID as smecicustomerid,");
		buffer.append("S_ME_CI_Name       as smeciname,");
		buffer.append("S_ME_CI_Sex        as smecisex,");
		buffer.append("S_ME_CI_Birthday   as smecibirthday,");
		buffer.append("S_ME_CI_Email      as smeciemail,");
		buffer.append("S_ME_CI_Address    as smeciaddress,");
		buffer.append("S_ME_CI_Zone       as smecizone,");
		buffer.append("S_ME_CI_Area1      as smeciarea1, ");
		buffer.append("S_ME_CI_Area2      as smeciarea2, ");
		buffer.append("S_ME_CI_Area3      as smeciarea3, ");
		buffer.append("S_ME_CI_Area4      as smeciarea4, ");
		buffer.append("S_ME_CI_Area5      as smeciarea5, ");		
		buffer.append("S_ME_CI_PostCode   as smecipostcode,");
		buffer.append("S_ME_CI_Phone      as smeciphone,");
		buffer.append("S_ME_CI_MemberId   as smecimemberid,");
		buffer.append("S_ME_CI_Integral   as smeciintegral,");
		buffer.append("S_ME_CI_ShopCode   as smecishopcode,");
		
		buffer.append("F_MM_MemberName    as fmmmembername,");
		buffer.append("F_MM_UP            as fmmup,");
		buffer.append("F_MM_DOWN          as fmmdown,");
		buffer.append("F_MM_Discount      as fmmdiscount");
		
		buffer.append(" FROM S_ME_CustomerInfo ");
		buffer.append("inner join F_MemberManagement on F_MemberManagement.F_MM_ID=S_ME_CustomerInfo.S_ME_CI_CardType ");
		
		buffer.append(" where 1=1 ");
		
		if("".equals(Utility.getName(po.getSmecisourcecard()))){
			buffer.append(" and isnull(S_ME_CI_Sourcecard,'')='' and (");
			buffer.append(" S_ME_CI_Phone in(?,?,?) ");
			buffer.append(" or S_ME_CI_Phone2 in(?,?,?) ");
			buffer.append(" or S_ME_CI_Phone3 in(?,?,?) ");
			
			if(!"".equals(Utility.getName(po.getSmeciphone()))){
				if("1".equals(po.getSmeciphone().substring(0, 1))&&po.getSmeciphone().length() == 11){
					params.add(po.getSmeciphone());
				}else{
					params.add("nophone");
				}
			}else{
				params.add("nophone");
			}
			
			if(!"".equals(Utility.getName(po.getSmeciphone2()))){
				if("1".equals(po.getSmeciphone2().substring(0, 1))&&po.getSmeciphone2().length() == 11){
					params.add(po.getSmeciphone2());
				}else{
					params.add("nophone");
				}
			}else{
				params.add("nophone");
			}
			
			if(!"".equals(Utility.getName(po.getSmeciphone3()))){
				if("1".equals(po.getSmeciphone3().substring(0, 1))&&po.getSmeciphone3().length() == 11){
					params.add(po.getSmeciphone3());
				}else{
					params.add("nophone");
				}
			}else{
				params.add("nophone");
			}
			
			if(!"".equals(Utility.getName(po.getSmeciphone()))){
				if("1".equals(po.getSmeciphone().substring(0, 1))&&po.getSmeciphone().length() == 11){
					params.add(po.getSmeciphone());
				}else{
					params.add("nophone");
				}
			}else{
				params.add("nophone");
			}
			
			if(!"".equals(Utility.getName(po.getSmeciphone2()))){
				if("1".equals(po.getSmeciphone2().substring(0, 1))&&po.getSmeciphone2().length() == 11){
					params.add(po.getSmeciphone2());
				}else{
					params.add("nophone");
				}
			}else{
				params.add("nophone");
			}
			
			if(!"".equals(Utility.getName(po.getSmeciphone3()))){
				if("1".equals(po.getSmeciphone3().substring(0, 1))&&po.getSmeciphone3().length() == 11){
					params.add(po.getSmeciphone3());
				}else{
					params.add("nophone");
				}
			}else{
				params.add("nophone");
			}
			
			if(!"".equals(Utility.getName(po.getSmeciphone()))){
				if("1".equals(po.getSmeciphone().substring(0, 1))&&po.getSmeciphone().length() == 11){
					params.add(po.getSmeciphone());
				}else{
					params.add("nophone");
				}
			}else{
				params.add("nophone");
			}
			
			if(!"".equals(Utility.getName(po.getSmeciphone2()))){
				if("1".equals(po.getSmeciphone2().substring(0, 1))&&po.getSmeciphone2().length() == 11){
					params.add(po.getSmeciphone2());
				}else{
					params.add("nophone");
				}
			}else{
				params.add("nophone");
			}
			
			if(!"".equals(Utility.getName(po.getSmeciphone3()))){
				if("1".equals(po.getSmeciphone3().substring(0, 1))&&po.getSmeciphone3().length() == 11){
					params.add(po.getSmeciphone3());
				}else{
					params.add("nophone");
				}
			}else{
				params.add("nophone");
			}
			
			buffer.append(" )");
			
			if(!"".equals(Utility.getName(po.getSmecimemberid()))){
				buffer.append(" or S_ME_CI_MemberId = ? ");
				params.add(Utility.getName(po.getSmecimemberid()));
			}
		}else{
			if(!"".equals(Utility.getName(po.getSmecimemberid()))){
				buffer.append(" and S_ME_CI_MemberId = ? ");
				params.add(Utility.getName(po.getSmecimemberid()));
			}			
		}
		
		if("0".equals(Utility.getName(po.getSmeciiscustomerid()))){
			buffer.append(" and S_ME_CI_CustomerID <> ? ");
			params.add(Utility.getName(po.getSmecicustomerid()));
		}
		
		return (CustomerInfoPo) queryForObject(buffer.toString(), params.toArray(),CustomerInfoPo.class);
	}

	/**
	 * 查询会员信息通过电话
	 */
	public int getCustomerInfoByPhone(CustomerInfoPo po){

		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
	
		buffer.append(" SELECT count(S_ME_CI_CustomerID) FROM S_ME_CustomerInfo where 1=1 ");
		
		if("".equals(Utility.getName(po.getSmecisourcecard()))){
			buffer.append(" and isnull(S_ME_CI_Sourcecard,'')='' and (");
			buffer.append(" S_ME_CI_Phone in (?,?,?) ");
			buffer.append(" or S_ME_CI_Phone2 in (?,?,?) ");
			buffer.append(" or S_ME_CI_Phone3 in (?,?,?) ");
			
			if(!"".equals(Utility.getName(po.getSmeciphone()))){
				if("1".equals(po.getSmeciphone().substring(0, 1))&&po.getSmeciphone().length() == 11){
					params.add(po.getSmeciphone());
				}else{
					params.add("nophone");
				}
			}else{
				params.add("nophone");
			}
			
			if(!"".equals(Utility.getName(po.getSmeciphone2()))){
				if("1".equals(po.getSmeciphone2().substring(0, 1))&&po.getSmeciphone2().length() == 11){
					params.add(po.getSmeciphone2());
				}else{
					params.add("nophone");
				}
			}else{
				params.add("nophone");
			}
			
			if(!"".equals(Utility.getName(po.getSmeciphone3()))){
				if("1".equals(po.getSmeciphone3().substring(0, 1))&&po.getSmeciphone3().length() == 11){
					params.add(po.getSmeciphone3());
				}else{
					params.add("nophone");
				}
			}else{
				params.add("nophone");
			}
			
			if(!"".equals(Utility.getName(po.getSmeciphone()))){
				if("1".equals(po.getSmeciphone().substring(0, 1))&&po.getSmeciphone().length() == 11){
					params.add(po.getSmeciphone());
				}else{
					params.add("nophone");
				}
			}else{
				params.add("nophone");
			}
			
			if(!"".equals(Utility.getName(po.getSmeciphone2()))){
				if("1".equals(po.getSmeciphone2().substring(0, 1))&&po.getSmeciphone2().length() == 11){
					params.add(po.getSmeciphone2());
				}else{
					params.add("nophone");
				}
			}else{
				params.add("nophone");
			}
			
			if(!"".equals(Utility.getName(po.getSmeciphone3()))){
				if("1".equals(po.getSmeciphone3().substring(0, 1))&&po.getSmeciphone3().length() == 11){
					params.add(po.getSmeciphone3());
				}else{
					params.add("nophone");
				}
			}else{
				params.add("nophone");
			}
			
			if(!"".equals(Utility.getName(po.getSmeciphone()))){
				if("1".equals(po.getSmeciphone().substring(0, 1))&&po.getSmeciphone().length() == 11){
					params.add(po.getSmeciphone());
				}else{
					params.add("nophone");
				}
			}else{
				params.add("nophone");
			}
			
			if(!"".equals(Utility.getName(po.getSmeciphone2()))){
				if("1".equals(po.getSmeciphone2().substring(0, 1))&&po.getSmeciphone2().length() == 11){
					params.add(po.getSmeciphone2());
				}else{
					params.add("nophone");
				}
			}else{
				params.add("nophone");
			}
			
			if(!"".equals(Utility.getName(po.getSmeciphone3()))){
				if("1".equals(po.getSmeciphone3().substring(0, 1))&&po.getSmeciphone3().length() == 11){
					params.add(po.getSmeciphone3());
				}else{
					params.add("nophone");
				}
			}else{
				params.add("nophone");
			}
			
			buffer.append(" )");
		}else{
			if(!"".equals(Utility.getName(po.getSmecimemberid()))){
				buffer.append(" and S_ME_CI_MemberId = ? ");
				params.add(Utility.getName(po.getSmecimemberid()));
			}			
		}
		
		if("0".equals(Utility.getName(po.getSmeciiscustomerid()))){
			buffer.append(" and S_ME_CI_CustomerID <> ? ");
			params.add(Utility.getName(po.getSmecicustomerid()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
		
	}

	/**
	 * 查询会员信息数量
	 */
	public int getCustomerInfoCount(CustomerInfoPo po) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select count(S_ME_CI_CustomerID) ");
		buffer.append(" from S_ME_CustomerInfo ");	
		buffer.append("  where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getIntegralmin())) && !"".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral >= ? ");
			buffer.append("and S_ME_CI_Integral <= ? ");
			params.add(po.getIntegralmin());
			params.add(po.getIntegralmax());
		} else if (!"".equals(Utility.getName(po.getIntegralmin()))&& "".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral >= ? ");
			params.add(po.getIntegralmin());
		} else if ("".equals(Utility.getName(po.getIntegralmin()))&& !"".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral <= ? ");
			params.add(po.getIntegralmax());
		}
		
		if(!"".equals(Utility.getName(po.getSmecishopcode()))){
			buffer.append("and S_ME_CI_ShopCode= ? ");
			params.add(po.getSmecishopcode());
		}

		if(!"".equals(Utility.getName(po.getSmeciopenid()))){
			if("1".equals(Utility.getName(po.getSmeciopenid()))){
				buffer.append("and isnull(S_ME_CI_OpenID,'') <> '' ");
			}
			if("0".equals(Utility.getName(po.getSmeciopenid()))){
				buffer.append("and isnull(S_ME_CI_OpenID,'') = '' ");
			}
		}
		if(!"".equals(Utility.getName(po.getSmecicustomerid()))){
			buffer.append("and S_ME_CI_CustomerID= ? ");
			params.add(po.getSmecicustomerid());
		}
		if(!"".equals(Utility.getName(po.getSmeciname()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(po.getSmeciname());
		}
		if(!"".equals(Utility.getName(po.getSmecisex()))){
			buffer.append("and S_ME_CI_Sex= ? ");
			params.add(po.getSmecisex());
		}
		if(!"".equals(Utility.getName(po.getSmeciphone()))){
			buffer.append("and (S_ME_CI_Phone like '%' + ? + '%' or S_ME_CI_Phone2 like '%' + ? + '%' or S_ME_CI_Phone3 like '%' + ? + '%')");
			params.add(po.getSmeciphone());
			params.add(po.getSmeciphone());
			params.add(po.getSmeciphone());
		}
		if(!"".equals(Utility.getName(po.getSmecimemberid()))){
			buffer.append("and S_ME_CI_MemberId like '%' + ? + '%' ");
			params.add(po.getSmecimemberid());
		}
		
		if(!"".equals(Utility.getName(po.getSmeciflag()))){
			buffer.append("and S_ME_CI_Flag = '"+ po.getSmeciflag() +"' ");
		}
		
		if(!"".equals(Utility.getName(po.getIsnullfcustomerid()))){//查询主卡字段为空的会员
			buffer.append("and isnull(S_ME_CI_FCustomerId,'')='' ");
		}
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}

		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	
	/**
	 * 查询高级会员信息数量
	 */
	public int getCustomerInfoCount1(CustomerInfoPo po) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select count(S_ME_CI_CustomerID) from( ");
		buffer.append(" select S_ME_CI_CustomerID ");
		buffer.append(" from S_ME_CustomerInfo ");	
		buffer.append(" left join F_MemberManagement on F_MemberManagement.F_MM_ID=S_ME_CustomerInfo.S_ME_CI_CardType ");
		
		if(!"".equals(Utility.getName(po.getSalsepersonname()))||!"".equals(Utility.getName(po.getSalestype()))||!"".equals(Utility.getName(po.getStarttimes()))||!"".equals(Utility.getName(po.getEndtimes()))||!"".equals(Utility.getName(po.getPricemin()))||!"".equals(Utility.getName(po.getPricemax()))||!"".equals(Utility.getName(po.getBbdstealthclass()))||!"".equals(Utility.getName(po.getBbdusetype()))||!"".equals(Utility.getName(po.getBbdfunctionclass()))||!"".equals(Utility.getName(po.getBbdluminosityclass()))||!"".equals(Utility.getName(po.getBbdrefractive()))||!"".equals(Utility.getName(po.getBbdmaterialclass()))||!"".equals(Utility.getName(po.getBbdframematerialtype()))||!"".equals(Utility.getName(po.getSelcstpsupplierid())) ||!"".equals(Utility.getName(po.getBrandID()))||!"".equals(Utility.getName(po.getGoodsid()))||!"".equals(Utility.getName(po.getTechnologytypeid()))){
			buffer.append(" left join uview_SalesBasic on S_SE_SB_CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");
			buffer.append(" left join uview_SalesDetail on S_SE_SD_SalesID=S_SE_SB_SalesID ");
			buffer.append(" left join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID = S_SE_SD_SalesItemID ");
		}	
		if(!"".equals(Utility.getName(po.getHuifangcishu()))){//回访次数查询
			buffer.append(" left join  (select count(S_SE_SB_CustomerID) as hfCiShu,S_SE_SB_CustomerID as CustomerID  from S_ME_CustomerVisit LEFT JOIN uview_SalesBasic ON S_SE_SB_SalesID = S_ME_CV_SalesID group by S_SE_SB_CustomerID ) as t1 on t1.CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		}
		
		buffer.append("  where 1=1 ");
		if(!"".equals(Utility.getName(po.getSmeciaddress()))){
			buffer.append(" and replace(S_ME_CI_Zone, ' ', '') like '%' + ? + '%' ");
			params.add(Utility.getName(po.getSmeciaddress()));
		}
		
		if("1".equals(Utility.getName(po.getPhoneflag()))){
			buffer.append("and (");
			buffer.append("(substring(S_ME_CI_Phone,1,1)='1' ");
			buffer.append("and len(S_ME_CI_Phone)=11) ");
			
			buffer.append("or (substring(S_ME_CI_Phone2,1,1)='1' ");
			buffer.append("and len(S_ME_CI_Phone2)=11) ");
			
			buffer.append("or (substring(S_ME_CI_Phone3,1,1)='1' ");
			buffer.append("and len(S_ME_CI_Phone3)=11) ");
			
			buffer.append(") ");
		}
		if(!"".equals(Utility.getName(po.getSalsepersonname()))){
			buffer.append(" and (select personName from dbo.SYS_PersonInfo where ID=S_SE_SB_SalerID ) like '%' + ? + '%'");
			params.add(po.getSalsepersonname());
		}
		
		if(!"".equals(Utility.getName(po.getHuifangcishu()))){
			buffer.append(" and isnull(t1.hfCiShu,0)= ? ");
			params.add(po.getHuifangcishu());
		}
		if(!"".equals(Utility.getName(po.getSmecishopcode()))){
			
			buffer.append("and S_ME_CI_ShopCode in ( ? ");
			
			String[] array = Utility.getName(po.getSmecishopcode()).split(",");
			params.add(array[0]);
			for (int i = 1; i < array.length; i++){
				buffer.append(" ,? ");
				params.add(array[i]);
			}
			buffer.append(" ) ");
		}
		if(!"".equals(Utility.getName(po.getSalestype()))){
			
			buffer.append("and S_SE_SB_OrdersType in ( ? ");
			
			String[] array = Utility.getName(po.getSalestype()).split(",");
			params.add(array[0]);
			for (int i = 1; i < array.length; i++){
				buffer.append(" ,? ");
				params.add(array[i]);
			}
			buffer.append(" ) ");
		}
		if(!"".equals(Utility.getName(po.getSmecicustomerid()))){
			buffer.append("and S_ME_CI_CustomerID= ? ");
			params.add(po.getSmecicustomerid());
		}
		
		if(!"".equals(Utility.getName(po.getSmeciinterest()))){
			String[] interests=po.getSmeciinterest().split(",");
			buffer.append(" and ( S_ME_CI_interest like '%' + ? + '%' ");
			params.add(interests[0]);
			for(int i=1;i<interests.length;i++){
				buffer.append(" or S_ME_CI_interest like '%' + ? + '%' ");
				params.add(interests[i]);
			}
			buffer.append(")");

		}
		
		if(!"".equals(Utility.getName(po.getSmeciarea1()))){
			buffer.append(" and S_ME_CI_Area1 = ? ");
			params.add(Utility.getName(po.getSmeciarea1()));
		}
		
		if(!"".equals(Utility.getName(po.getSmeciarea2()))){
			buffer.append(" and S_ME_CI_Area2 = ? ");
			params.add(Utility.getName(po.getSmeciarea2()));
		}
		
		if(!"".equals(Utility.getName(po.getSmeciarea3()))){
			buffer.append(" and S_ME_CI_Area3 = ? ");
			params.add(Utility.getName(po.getSmeciarea3()));
		}
		
		if(!"".equals(Utility.getName(po.getSmeciarea4()))){
			buffer.append(" and S_ME_CI_Area4 = ? ");
			params.add(Utility.getName(po.getSmeciarea4()));
		}
		
		if(!"".equals(Utility.getName(po.getSmeciarea5()))){
			buffer.append(" and S_ME_CI_Area5 = ? ");
			params.add(Utility.getName(po.getSmeciarea5()));
		}
		
		if(!"".equals(Utility.getName(po.getSmeciname()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(po.getSmeciname());
		}
		if(!"".equals(Utility.getName(po.getSmecisex()))){
			buffer.append("and S_ME_CI_Sex= ? ");
			params.add(po.getSmecisex());
		}
		if(!"".equals(Utility.getName(po.getSmeciphone()))){
			buffer.append("and (S_ME_CI_Phone like '%' + ? + '%' or S_ME_CI_Phone2 like '%' + ? + '%' or S_ME_CI_Phone3 like '%' + ? + '%')");
			params.add(po.getSmeciphone());
			params.add(po.getSmeciphone());
			params.add(po.getSmeciphone());
		}
		if(!"".equals(Utility.getName(po.getSmecimemberid()))){
			buffer.append("and S_ME_CI_MemberId like '%' + ? + '%' ");
			params.add(po.getSmecimemberid());
		}
		if(!"".equals(Utility.getName(po.getSmeciagemin()))){
			buffer.append("and year(getdate())-year(S_ME_CI_Birthday) >= ? ");
			params.add(po.getSmeciagemin());
		}
		if(!"".equals(Utility.getName(po.getSmeciagemax()))){
			buffer.append("and year(getdate())-year(S_ME_CI_Birthday) <= ? ");
			params.add(po.getSmeciagemax());
		}
		if (!"".equals(Utility.getName(po.getStarttime()))	&& !"".equals(Utility.getName(po.getEndtime()))) {
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) <= ? ");
			params.add(po.getStarttime());
			params.add(po.getEndtime());
		} else if (!"".equals(Utility.getName(po.getStarttime()))&& "".equals(Utility.getName(po.getEndtime()))) {
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) >= ? ");
			params.add(po.getStarttime());
		} else if ("".equals(Utility.getName(po.getStarttime()))&& !"".equals(Utility.getName(po.getEndtime()))) {
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) <= ? ");
			params.add(po.getEndtime());
		}
		if (!"".equals(Utility.getName(po.getSrStartTime()))	&& !"".equals(Utility.getName(po.getSrEndTime()))) {
			buffer.append("and substring(convert(varchar(10),S_ME_CI_Birthday,23),6,10) >= ? ");
			buffer.append("and substring(convert(varchar(10),S_ME_CI_Birthday,23),6,10) <= ? ");
			params.add(po.getSrStartTime());
			params.add(po.getSrEndTime());
		} else if (!"".equals(Utility.getName(po.getSrStartTime()))&& "".equals(Utility.getName(po.getSrEndTime()))) {
			buffer.append("and substring(convert(varchar(10),S_ME_CI_Birthday,23),6,10) >= ? ");
			params.add(po.getSrStartTime());
		} else if ("".equals(Utility.getName(po.getSrStartTime()))&& !"".equals(Utility.getName(po.getSrEndTime()))) {
			buffer.append("and substring(convert(varchar(10),S_ME_CI_Birthday,23),6,10) <= ? ");
			params.add(po.getSrEndTime());
		}
		if (!"".equals(Utility.getName(po.getStarttimes()))	&& !"".equals(Utility.getName(po.getEndtimes()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(po.getStarttimes());
			params.add(po.getEndtimes());
		} else if (!"".equals(Utility.getName(po.getStarttimes()))&& "".equals(Utility.getName(po.getEndtimes()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			params.add(po.getStarttimes());
		} else if ("".equals(Utility.getName(po.getStarttimes()))&& !"".equals(Utility.getName(po.getEndtimes()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(po.getEndtimes());
		}
		
		if (!"".equals(Utility.getName(po.getIntegralmin())) && !"".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral >= ? ");
			buffer.append("and S_ME_CI_Integral <= ? ");
			params.add(po.getIntegralmin());
			params.add(po.getIntegralmax());
		} else if (!"".equals(Utility.getName(po.getIntegralmin()))&& "".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral >= ? ");
			params.add(po.getIntegralmin());
		} else if ("".equals(Utility.getName(po.getIntegralmin()))&& !"".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral <= ? ");
			params.add(po.getIntegralmax());
		}
		
		if (!"".equals(Utility.getName(po.getNumbermin())) && !"".equals(Utility.getName(po.getNumbermax()))) {
			buffer.append("and S_ME_CI_ConsumptionNumber >= cast(? as int) ");
			buffer.append("and S_ME_CI_ConsumptionNumber <= cast(? as int) ");
			params.add(po.getNumbermin());
			params.add(po.getNumbermax());
		} else if (!"".equals(Utility.getName(po.getNumbermin()))&& "".equals(Utility.getName(po.getNumbermax()))) {
			buffer.append("and S_ME_CI_ConsumptionNumber >= cast(? as int) ");
			params.add(po.getNumbermin());
		} else if ("".equals(Utility.getName(po.getNumbermin()))&& !"".equals(Utility.getName(po.getNumbermax()))) {
			buffer.append("and S_ME_CI_ConsumptionNumber <= cast(? as int) ");
			params.add(po.getNumbermax());
		}
		if(!"".equals(Utility.getName(po.getSmeciopenid()))){
			if("1".equals(Utility.getName(po.getSmeciopenid()))){
				buffer.append("and isnull(S_ME_CI_OpenID,'') <> '' ");
			}
			if("0".equals(Utility.getName(po.getSmeciopenid()))){
				buffer.append("and isnull(S_ME_CI_OpenID,'') = '' ");
			}
		}
		if (!"".equals(Utility.getName(po.getPricemin())) && !"".equals(Utility.getName(po.getPricemax()))) {
			buffer.append("and S_SE_SB_SalesValue >= ? ");
			buffer.append("and S_SE_SB_SalesValue <= ? ");
			params.add(po.getPricemin());
			params.add(po.getPricemax());
		} else if (!"".equals(Utility.getName(po.getPricemin()))&& "".equals(Utility.getName(po.getPricemax()))) {
			buffer.append("and S_SE_SB_SalesValue >= ? ");
			params.add(po.getPricemin());
		} else if ("".equals(Utility.getName(po.getPricemin()))&& !"".equals(Utility.getName(po.getPricemax()))) {
			buffer.append("and S_SE_SB_SalesValue <= ? ");
			params.add(po.getPricemax());
		}
		
		if (!"".equals(Utility.getName(po.getAllpricemin())) && !"".equals(Utility.getName(po.getAllpricemax()))) {
			buffer.append("and S_ME_CI_ConsumptionPrice >= ? ");
			buffer.append("and S_ME_CI_ConsumptionPrice <= ? ");
			params.add(po.getAllpricemin());
			params.add(po.getAllpricemax());
		} else if (!"".equals(Utility.getName(po.getAllpricemin()))&& "".equals(Utility.getName(po.getAllpricemax()))) {
			buffer.append("and S_ME_CI_ConsumptionPrice >= ? ");
			params.add(po.getAllpricemin());
		} else if ("".equals(Utility.getName(po.getAllpricemin()))&& !"".equals(Utility.getName(po.getAllpricemax()))) {
			buffer.append("and S_ME_CI_ConsumptionPrice <= ? ");
			params.add(po.getAllpricemax());
		}
		
		if(!"".equals(Utility.getName(po.getSelcstpsupplierid()))){
			buffer.append("and B_GoodsInfo.B_GI_SupplierID= ? ");
			params.add(po.getSelcstpsupplierid());
		}
		if(!"".equals(Utility.getName(po.getPersontype()))){
			buffer.append("and S_ME_CI_PersonType= ? ");
			params.add(po.getPersontype());
		}
		if(!"".equals(Utility.getName(po.getBrandID()))){
			buffer.append("and B_GoodsInfo.B_GI_BrandID= ? ");
			params.add(po.getBrandID());
		}
		if(!"".equals(Utility.getName(po.getGoodsid()))){
			buffer.append("and B_GoodsInfo.B_GI_GoodsID= ? ");
			params.add(po.getGoodsid());
		}
		if(!"".equals(Utility.getName(po.getTechnologytypeid()))){
			buffer.append("and B_GoodsInfo.B_GI_frameProcessCraftType= ? ");
			params.add(po.getTechnologytypeid());
		}
		if(!"".equals(Utility.getName(po.getBbdframematerialtype()))){
			buffer.append("and B_GoodsInfo.B_GI_FrameMaterialType= ? ");
			params.add(po.getBbdframematerialtype());
		}
		if(!"".equals(Utility.getName(po.getBbdmaterialclass()))){
			buffer.append("and B_GoodsInfo.B_GI_EyeGlassMaterialType= ? ");
			params.add(po.getBbdmaterialclass());
		}
		if(!"".equals(Utility.getName(po.getBbdrefractive()))){
			buffer.append("and B_GoodsInfo.B_GI_Refractive= ? ");
			params.add(po.getBbdrefractive());
		}
		if(!"".equals(Utility.getName(po.getBbdluminosityclass()))){
			buffer.append("and B_GoodsInfo.B_GI_isMutiLuminosity= ? ");
			params.add(po.getBbdluminosityclass());
		}
		if(!"".equals(Utility.getName(po.getBbdfunctionclass()))){
			buffer.append("and B_GoodsInfo.B_GI_FunctionClass= ? ");
			params.add(po.getBbdfunctionclass());
		}
		if(!"".equals(Utility.getName(po.getBbdusetype()))){
			buffer.append("and B_GoodsInfo.B_GI_UseType= ? ");
			params.add(po.getBbdusetype());
		}
		if(!"".equals(Utility.getName(po.getBbdstealthclass()))){
			buffer.append("and B_GoodsInfo.B_GI_StealthClass= ? ");
			params.add(po.getBbdstealthclass());
		}
		
		if(!"".equals(Utility.getName(po.getSmeciwork()))){
			buffer.append("and S_ME_CI_work = ? ");
			params.add(Utility.getName(po.getSmeciwork()));
		}	
	
		if(!"".equals(Utility.getName(po.getSmecimemberorigin()))){
			
			buffer.append("and ( S_ME_CI_MemberOrigin like '%' + ? + '%' ");
			
			String[] array = Utility.getName(po.getSmecimemberorigin()).split(",");
			params.add(array[0]);
			for (int i = 1; i < array.length; i++){
				buffer.append(" or S_ME_CI_MemberOrigin like '%' + ? + '%' ");
				params.add(array[i]);
			}
			buffer.append(" ) ");
		}
		
		if(!"".equals(Utility.getName(po.getSmeciflag()))){
			buffer.append("and S_ME_CI_Flag = ? ");
			params.add(po.getSmeciflag());
		}

		
		if(!"".equals(Utility.getName(po.getSmecicardtype()))){
			buffer.append("and S_ME_CI_CardType = '"+ po.getSmecicardtype() +"' ");
		}	
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		if(!"".equals(Utility.getName(po.getSmeciremark()))){
			buffer.append(" and S_ME_CI_Remark like '%' + ? + '%' ");
			params.add(Utility.getName(po.getSmeciremark()));
		}
		
		buffer.append(" group by S_ME_CI_CustomerID)temp ");

		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	/**
	 * 遍历高级会员信息
	 */
	public List<CustomerInfoPo> getCustomerInfoList1(CustomerInfoPo po,
			int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from(select ROW_NUMBER() ");
		buffer.append("Over(order by S_ME_CI_CustomerID desc) as rowNum,");
		
		buffer.append("S_ME_CI_CustomerID as smecicustomerid,");
		buffer.append("S_ME_CI_Name as smeciname,");
		buffer.append("S_ME_CI_Sex as smecisex,");
		buffer.append("S_ME_CI_Birthday as smecibirthday,");
		buffer.append("S_ME_CI_Phone as smeciphone,");
		buffer.append("S_ME_CI_MemberId as smecimemberid,");
		buffer.append("S_ME_CI_Integral as smeciintegral,");
		buffer.append("F_MM_MemberName as fmmmembername,");
		buffer.append("F_MM_UP as fmmup,");
		buffer.append("F_MM_DOWN as fmmdown,");
		buffer.append("F_MM_Discount as fmmdiscount,");
		buffer.append("S_ME_CI_Remark as smeciremark");
		
		buffer.append(" from S_ME_CustomerInfo ");	
		buffer.append(" left join F_MemberManagement on F_MemberManagement.F_MM_ID=S_ME_CustomerInfo.S_ME_CI_CardType ");
		
		if(!"".equals(Utility.getName(po.getSalsepersonname()))||!"".equals(Utility.getName(po.getSalestype()))||!"".equals(Utility.getName(po.getStarttimes()))||!"".equals(Utility.getName(po.getEndtimes()))||!"".equals(Utility.getName(po.getPricemin()))||!"".equals(Utility.getName(po.getPricemax()))||!"".equals(Utility.getName(po.getBbdstealthclass()))||!"".equals(Utility.getName(po.getBbdusetype()))||!"".equals(Utility.getName(po.getBbdfunctionclass()))||!"".equals(Utility.getName(po.getBbdluminosityclass()))||!"".equals(Utility.getName(po.getBbdrefractive()))||!"".equals(Utility.getName(po.getBbdmaterialclass()))||!"".equals(Utility.getName(po.getBbdframematerialtype()))||!"".equals(Utility.getName(po.getSelcstpsupplierid())) ||!"".equals(Utility.getName(po.getBrandID()))||!"".equals(Utility.getName(po.getGoodsid()))||!"".equals(Utility.getName(po.getTechnologytypeid()))){
			buffer.append(" left join uview_SalesBasic on S_SE_SB_CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");
			buffer.append(" left join uview_SalesDetail on S_SE_SD_SalesID=S_SE_SB_SalesID ");
			buffer.append(" left join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID = S_SE_SD_SalesItemID ");
		}	
		if(!"".equals(Utility.getName(po.getHuifangcishu()))){//回访次数查询
			buffer.append(" left join  (select count(S_SE_SB_CustomerID) as hfCiShu,S_SE_SB_CustomerID as CustomerID  from S_ME_CustomerVisit LEFT JOIN uview_SalesBasic ON S_SE_SB_SalesID = S_ME_CV_SalesID group by S_SE_SB_CustomerID ) as t1 on t1.CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		}
		
		buffer.append("  where 1=1 ");		
		if("1".equals(Utility.getName(po.getPhoneflag()))){
			buffer.append("and (");
			buffer.append("(substring(S_ME_CI_Phone,1,1)='1' ");
			buffer.append("and len(S_ME_CI_Phone)=11) ");
			
			buffer.append("or (substring(S_ME_CI_Phone2,1,1)='1' ");
			buffer.append("and len(S_ME_CI_Phone2)=11) ");
			
			buffer.append("or (substring(S_ME_CI_Phone3,1,1)='1' ");
			buffer.append("and len(S_ME_CI_Phone3)=11) ");
			
			buffer.append(") ");
		}
		if(!"".equals(Utility.getName(po.getSalsepersonname()))){
			buffer.append(" and (select personName from dbo.SYS_PersonInfo where ID=S_SE_SB_SalerID ) like '%' + ? + '%'");
			params.add(po.getSalsepersonname());
		}
		
		if(!"".equals(Utility.getName(po.getHuifangcishu()))){
			buffer.append(" and isnull(t1.hfCiShu,0)= ? ");
			params.add(po.getHuifangcishu());
		}
		if(!"".equals(Utility.getName(po.getSmecishopcode()))){
			
			buffer.append("and S_ME_CI_ShopCode in ( ? ");
			
			String[] array = Utility.getName(po.getSmecishopcode()).split(",");
			params.add(array[0]);
			for (int i = 1; i < array.length; i++){
				buffer.append(" ,? ");
				params.add(array[i]);
			}
			buffer.append(" ) ");
		}
		if(!"".equals(Utility.getName(po.getSalestype()))){
			
			buffer.append("and S_SE_SB_OrdersType in ( ? ");
			
			String[] array = Utility.getName(po.getSalestype()).split(",");
			params.add(array[0]);
			for (int i = 1; i < array.length; i++){
				buffer.append(" ,? ");
				params.add(array[i]);
			}
			buffer.append(" ) ");
		}
		if(!"".equals(Utility.getName(po.getSmecicustomerid()))){
			buffer.append("and S_ME_CI_CustomerID= ? ");
			params.add(po.getSmecicustomerid());
		}
		
		if(!"".equals(Utility.getName(po.getSmeciinterest()))){
			String[] interests=po.getSmeciinterest().split(",");
			buffer.append(" and ( S_ME_CI_interest like '%' + ? + '%' ");
			params.add(interests[0]);
			for(int i=1;i<interests.length;i++){
				buffer.append(" or S_ME_CI_interest like '%' + ? + '%' ");
				params.add(interests[i]);
			}
			buffer.append(")");

		}
		if(!"".equals(Utility.getName(po.getSmeciname()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(po.getSmeciname());
		}
		if(!"".equals(Utility.getName(po.getSmecisex()))){
			buffer.append("and S_ME_CI_Sex= ? ");
			params.add(po.getSmecisex());
		}
		if(!"".equals(Utility.getName(po.getSmeciphone()))){
			buffer.append("and (S_ME_CI_Phone like '%' + ? + '%' or S_ME_CI_Phone2 like '%' + ? + '%' or S_ME_CI_Phone3 like '%' + ? + '%')");
			params.add(po.getSmeciphone());
			params.add(po.getSmeciphone());
			params.add(po.getSmeciphone());
		}
		if(!"".equals(Utility.getName(po.getSmecimemberid()))){
			buffer.append("and S_ME_CI_MemberId like '%' + ? + '%' ");
			params.add(po.getSmecimemberid());
		}
		if(!"".equals(Utility.getName(po.getSmeciagemin()))){
			buffer.append("and year(getdate())-year(S_ME_CI_Birthday) >= ? ");
			params.add(po.getSmeciagemin());
		}
		if(!"".equals(Utility.getName(po.getSmeciagemax()))){
			buffer.append("and year(getdate())-year(S_ME_CI_Birthday) <= ? ");
			params.add(po.getSmeciagemax());
		}
		if (!"".equals(Utility.getName(po.getStarttime()))	&& !"".equals(Utility.getName(po.getEndtime()))) {
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) <= ? ");
			params.add(po.getStarttime());
			params.add(po.getEndtime());
		} else if (!"".equals(Utility.getName(po.getStarttime()))&& "".equals(Utility.getName(po.getEndtime()))) {
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) >= ? ");
			params.add(po.getStarttime());
		} else if ("".equals(Utility.getName(po.getStarttime()))&& !"".equals(Utility.getName(po.getEndtime()))) {
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) <= ? ");
			params.add(po.getEndtime());
		}
		if (!"".equals(Utility.getName(po.getSrStartTime()))	&& !"".equals(Utility.getName(po.getSrEndTime()))) {
			buffer.append("and substring(convert(varchar(10),S_ME_CI_Birthday,23),6,10) >= ? ");
			buffer.append("and substring(convert(varchar(10),S_ME_CI_Birthday,23),6,10) <= ? ");
			params.add(po.getSrStartTime());
			params.add(po.getSrEndTime());
		} else if (!"".equals(Utility.getName(po.getSrStartTime()))&& "".equals(Utility.getName(po.getSrEndTime()))) {
			buffer.append("and substring(convert(varchar(10),S_ME_CI_Birthday,23),6,10) >= ? ");
			params.add(po.getSrStartTime());
		} else if ("".equals(Utility.getName(po.getSrStartTime()))&& !"".equals(Utility.getName(po.getSrEndTime()))) {
			buffer.append("and substring(convert(varchar(10),S_ME_CI_Birthday,23),6,10) <= ? ");
			params.add(po.getSrEndTime());
		}
		if (!"".equals(Utility.getName(po.getStarttimes()))	&& !"".equals(Utility.getName(po.getEndtimes()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(po.getStarttimes());
			params.add(po.getEndtimes());
		} else if (!"".equals(Utility.getName(po.getStarttimes()))&& "".equals(Utility.getName(po.getEndtimes()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			params.add(po.getStarttimes());
		} else if ("".equals(Utility.getName(po.getStarttimes()))&& !"".equals(Utility.getName(po.getEndtimes()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(po.getEndtimes());
		}
		
		if (!"".equals(Utility.getName(po.getIntegralmin())) && !"".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral >= ? ");
			buffer.append("and S_ME_CI_Integral <= ? ");
			params.add(po.getIntegralmin());
			params.add(po.getIntegralmax());
		} else if (!"".equals(Utility.getName(po.getIntegralmin()))&& "".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral >= ? ");
			params.add(po.getIntegralmin());
		} else if ("".equals(Utility.getName(po.getIntegralmin()))&& !"".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral <= ? ");
			params.add(po.getIntegralmax());
		}
		
		if (!"".equals(Utility.getName(po.getNumbermin())) && !"".equals(Utility.getName(po.getNumbermax()))) {
			buffer.append("and S_ME_CI_ConsumptionNumber >= cast(? as int) ");
			buffer.append("and S_ME_CI_ConsumptionNumber <= cast(? as int) ");
			params.add(po.getNumbermin());
			params.add(po.getNumbermax());
		} else if (!"".equals(Utility.getName(po.getNumbermin()))&& "".equals(Utility.getName(po.getNumbermax()))) {
			buffer.append("and S_ME_CI_ConsumptionNumber >= cast(? as int) ");
			params.add(po.getNumbermin());
		} else if ("".equals(Utility.getName(po.getNumbermin()))&& !"".equals(Utility.getName(po.getNumbermax()))) {
			buffer.append("and S_ME_CI_ConsumptionNumber <= cast(? as int) ");
			params.add(po.getNumbermax());
		}
		if(!"".equals(Utility.getName(po.getSmeciopenid()))){
			if("1".equals(Utility.getName(po.getSmeciopenid()))){
				buffer.append("and isnull(S_ME_CI_OpenID,'') <> '' ");
			}
			if("0".equals(Utility.getName(po.getSmeciopenid()))){
				buffer.append("and isnull(S_ME_CI_OpenID,'') = '' ");
			}
		}
		if (!"".equals(Utility.getName(po.getPricemin())) && !"".equals(Utility.getName(po.getPricemax()))) {
			buffer.append("and S_SE_SB_SalesValue >= ? ");
			buffer.append("and S_SE_SB_SalesValue <= ? ");
			params.add(po.getPricemin());
			params.add(po.getPricemax());
		} else if (!"".equals(Utility.getName(po.getPricemin()))&& "".equals(Utility.getName(po.getPricemax()))) {
			buffer.append("and S_SE_SB_SalesValue >= ? ");
			params.add(po.getPricemin());
		} else if ("".equals(Utility.getName(po.getPricemin()))&& !"".equals(Utility.getName(po.getPricemax()))) {
			buffer.append("and S_SE_SB_SalesValue <= ? ");
			params.add(po.getPricemax());
		}
		
		if (!"".equals(Utility.getName(po.getAllpricemin())) && !"".equals(Utility.getName(po.getAllpricemax()))) {
			buffer.append("and S_ME_CI_ConsumptionPrice >= ? ");
			buffer.append("and S_ME_CI_ConsumptionPrice <= ? ");
			params.add(po.getAllpricemin());
			params.add(po.getAllpricemax());
		} else if (!"".equals(Utility.getName(po.getAllpricemin()))&& "".equals(Utility.getName(po.getAllpricemax()))) {
			buffer.append("and S_ME_CI_ConsumptionPrice >= ? ");
			params.add(po.getAllpricemin());
		} else if ("".equals(Utility.getName(po.getAllpricemin()))&& !"".equals(Utility.getName(po.getAllpricemax()))) {
			buffer.append("and S_ME_CI_ConsumptionPrice <= ? ");
			params.add(po.getAllpricemax());
		}
		
		if(!"".equals(Utility.getName(po.getSelcstpsupplierid()))){
			buffer.append("and B_GoodsInfo.B_GI_SupplierID= ? ");
			params.add(po.getSelcstpsupplierid());
		}
		if(!"".equals(Utility.getName(po.getPersontype()))){
			buffer.append("and S_ME_CI_PersonType= ? ");
			params.add(po.getPersontype());
		}
		if(!"".equals(Utility.getName(po.getBrandID()))){
			buffer.append("and B_GoodsInfo.B_GI_BrandID= ? ");
			params.add(po.getBrandID());
		}
		if(!"".equals(Utility.getName(po.getGoodsid()))){
			buffer.append("and B_GoodsInfo.B_GI_GoodsID= ? ");
			params.add(po.getGoodsid());
		}
		if(!"".equals(Utility.getName(po.getTechnologytypeid()))){
			buffer.append("and B_GoodsInfo.B_GI_frameProcessCraftType= ? ");
			params.add(po.getTechnologytypeid());
		}
		if(!"".equals(Utility.getName(po.getBbdframematerialtype()))){
			buffer.append("and B_GoodsInfo.B_GI_FrameMaterialType= ? ");
			params.add(po.getBbdframematerialtype());
		}
		if(!"".equals(Utility.getName(po.getBbdmaterialclass()))){
			buffer.append("and B_GoodsInfo.B_GI_EyeGlassMaterialType= ? ");
			params.add(po.getBbdmaterialclass());
		}
		if(!"".equals(Utility.getName(po.getBbdrefractive()))){
			buffer.append("and B_GoodsInfo.B_GI_Refractive= ? ");
			params.add(po.getBbdrefractive());
		}
		if(!"".equals(Utility.getName(po.getBbdluminosityclass()))){
			buffer.append("and B_GoodsInfo.B_GI_isMutiLuminosity= ? ");
			params.add(po.getBbdluminosityclass());
		}
		if(!"".equals(Utility.getName(po.getBbdfunctionclass()))){
			buffer.append("and B_GoodsInfo.B_GI_FunctionClass= ? ");
			params.add(po.getBbdfunctionclass());
		}
		if(!"".equals(Utility.getName(po.getBbdusetype()))){
			buffer.append("and B_GoodsInfo.B_GI_UseType= ? ");
			params.add(po.getBbdusetype());
		}
		if(!"".equals(Utility.getName(po.getBbdstealthclass()))){
			buffer.append("and B_GoodsInfo.B_GI_StealthClass= ? ");
			params.add(po.getBbdstealthclass());
		}
		
		if(!"".equals(Utility.getName(po.getSmeciwork()))){
			buffer.append("and S_ME_CI_work = ? ");
			params.add(Utility.getName(po.getSmeciwork()));
		}	
	
		if(!"".equals(Utility.getName(po.getSmecimemberorigin()))){
			
			buffer.append("and ( S_ME_CI_MemberOrigin like '%' + ? + '%' ");
			
			String[] array = Utility.getName(po.getSmecimemberorigin()).split(",");
			params.add(array[0]);
			for (int i = 1; i < array.length; i++){
				buffer.append(" or S_ME_CI_MemberOrigin like '%' + ? + '%' ");
				params.add(array[i]);
			}
			buffer.append(" ) ");
		}
		
		if(!"".equals(Utility.getName(po.getSmeciaddress()))){
			buffer.append(" and replace(S_ME_CI_Zone, ' ', '') like '%' + ? + '%' ");
			params.add(Utility.getName(po.getSmeciaddress()));
		}
		
		if(!"".equals(Utility.getName(po.getSmeciarea1()))){
			buffer.append(" and S_ME_CI_Area1 = ? ");
			params.add(Utility.getName(po.getSmeciarea1()));
		}
		
		if(!"".equals(Utility.getName(po.getSmeciarea2()))){
			buffer.append(" and S_ME_CI_Area2 = ? ");
			params.add(Utility.getName(po.getSmeciarea2()));
		}
		
		if(!"".equals(Utility.getName(po.getSmeciarea3()))){
			buffer.append(" and S_ME_CI_Area3 = ? ");
			params.add(Utility.getName(po.getSmeciarea3()));
		}
		
		if(!"".equals(Utility.getName(po.getSmeciarea4()))){
			buffer.append(" and S_ME_CI_Area4 = ? ");
			params.add(Utility.getName(po.getSmeciarea4()));
		}
		
		if(!"".equals(Utility.getName(po.getSmeciarea5()))){
			buffer.append(" and S_ME_CI_Area5 = ? ");
			params.add(Utility.getName(po.getSmeciarea5()));
		}
		
		if(!"".equals(Utility.getName(po.getSmeciflag()))){
			buffer.append("and S_ME_CI_Flag = ? ");
			params.add(po.getSmeciflag());
		}

		
		if(!"".equals(Utility.getName(po.getSmecicardtype()))){
			buffer.append("and S_ME_CI_CardType = '"+ po.getSmecicardtype() +"' ");
		}	
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		if(!"".equals(Utility.getName(po.getSmeciremark()))){
			buffer.append(" and S_ME_CI_Remark like '%' + ? + '%' ");
			params.add(Utility.getName(po.getSmeciremark()));
		}

		buffer.append(" group by S_ME_CI_CustomerID,S_ME_CI_Name,S_ME_CI_Sex,S_ME_CI_Birthday,S_ME_CI_Email, ");
		buffer.append(" S_ME_CI_Address,S_ME_CI_Zone,S_ME_CI_PostCode,S_ME_CI_Phone,S_ME_CI_Phone2,S_ME_CI_Phone3,S_ME_CI_MemberId, ");
		buffer.append(" S_ME_CI_Integral,S_ME_CI_ShopCode,F_MM_MemberName,F_MM_UP,F_MM_DOWN,F_MM_Discount,S_ME_CI_Remark,S_ME_CI_Sourcecard ");
		buffer.append(" ) temp where rowNum > "+start+" and rowNum <= "+ (start + size));
		buffer.append("set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , CustomerInfoPo.class);
	}
	
	
	public List<CustomerInfoPo> exportCustomerInfo(CustomerInfoPo po)
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select * from(select ROW_NUMBER() ");
		buffer.append("Over(order by S_ME_CI_CustomerID desc) as rowNum,");
		
		buffer.append("S_ME_CI_CustomerID as smecicustomerid,");
		buffer.append("S_ME_CI_Name as smeciname,");
		buffer.append("S_ME_CI_Sex as smecisex,");
		buffer.append("convert(varchar(10),S_ME_CI_Birthday,120) as smecibirthday,");
		buffer.append("S_ME_CI_Email as smeciemail,");
		buffer.append("S_ME_CI_Address as smeciaddress,");
		buffer.append("S_ME_CI_Zone as smecizone,");
		buffer.append("S_ME_CI_Area1 as smeciarea1, ");
		buffer.append("S_ME_CI_Area2 as smeciarea2, ");
		buffer.append("S_ME_CI_Area3 as smeciarea3, ");
		buffer.append("S_ME_CI_Area4 as smeciarea4, ");
		buffer.append("S_ME_CI_Area5 as smeciarea5, ");		
		buffer.append("S_ME_CI_PostCode as smecipostcode,");
		buffer.append("S_ME_CI_Phone as smeciphone,");
		buffer.append("S_ME_CI_Phone2 as smeciphone2,");
		buffer.append("S_ME_CI_Phone3 as smeciphone3,");
		buffer.append("S_ME_CI_MemberId as smecimemberid,");
		buffer.append("S_ME_CI_Integral as smeciintegral,");
		buffer.append("S_ME_CI_ShopCode as smecishopcode,S_ME_CI_QqNumber as smeciqqnumber,isnull(B_WT_Name,'') as smeciworkname,isnull(B_MO_Name,'') as smecimemberoriginname,dbo.getInterestNameList(isnull(S_ME_CI_Interest,'')) as smeciinterest,");
		
		buffer.append("F_MM_MemberName as fmmmembername,");
		buffer.append("F_MM_UP as fmmup,");
		buffer.append("F_MM_DOWN as fmmdown,");
		buffer.append("F_MM_Discount as fmmdiscount,S_ME_CI_Remark as smeciremark");
		
		buffer.append(" from S_ME_CustomerInfo ");	
		buffer.append("left join F_MemberManagement on F_MemberManagement.F_MM_ID=S_ME_CustomerInfo.S_ME_CI_CardType ");
		
		buffer.append(" left join uview_SalesBasic on S_SE_SB_CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		buffer.append(" left join uview_SalesDetail on S_SE_SD_SalesID=S_SE_SB_SalesID ");
		buffer.append(" left join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID = S_SE_SD_SalesItemID ");
		
		buffer.append(" left join B_WorkType on B_WT_ID = S_ME_CI_work ");
		buffer.append(" left join B_MemberOrigin on S_ME_CI_MemberOrigin = B_MO_ID ");
		
		buffer.append("  where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getSmeciaddress()))){
			buffer.append(" and replace(S_ME_CI_Zone, ' ', '') like '%' + ? + '%' ");
			params.add(Utility.getName(po.getSmeciaddress()));
		}
		
		if("1".equals(Utility.getName(po.getPhoneflag()))){
			buffer.append("and (");
			buffer.append("(substring(S_ME_CI_Phone,1,1)='1' ");
			buffer.append("and len(S_ME_CI_Phone)=11) ");
			
			buffer.append("or (substring(S_ME_CI_Phone2,1,1)='1' ");
			buffer.append("and len(S_ME_CI_Phone2)=11) ");
			
			buffer.append("or (substring(S_ME_CI_Phone3,1,1)='1' ");
			buffer.append("and len(S_ME_CI_Phone3)=11) ");
			
			buffer.append(") ");
		}
		if(!"".equals(Utility.getName(po.getSalsepersonname()))){
			buffer.append(" and (select personName from dbo.SYS_PersonInfo where ID=S_SE_SB_SalerID ) like '%' + ? + '%'");
			params.add(po.getSalsepersonname());
		}
		
		if(!"".equals(Utility.getName(po.getHuifangcishu()))){
			buffer.append(" and isnull(t1.hfCiShu,0)= ? ");
			params.add(po.getHuifangcishu());
		}
		if(!"".equals(Utility.getName(po.getSmecishopcode()))){
			
			buffer.append("and S_ME_CI_ShopCode in ( ? ");
			
			String[] array = Utility.getName(po.getSmecishopcode()).split(",");
			params.add(array[0]);
			for (int i = 1; i < array.length; i++){
				buffer.append(" ,? ");
				params.add(array[i]);
			}
			buffer.append(" ) ");
		}
		if(!"".equals(Utility.getName(po.getSalestype()))){
			
			buffer.append("and S_SE_SB_OrdersType in ( ? ");
			
			String[] array = Utility.getName(po.getSalestype()).split(",");
			params.add(array[0]);
			for (int i = 1; i < array.length; i++){
				buffer.append(" ,? ");
				params.add(array[i]);
			}
			buffer.append(" ) ");
		}
		if(!"".equals(Utility.getName(po.getSmecicustomerid()))){
			buffer.append("and S_ME_CI_CustomerID= ? ");
			params.add(po.getSmecicustomerid());
		}
		
		if(!"".equals(Utility.getName(po.getSmeciinterest()))){
			String[] interests=po.getSmeciinterest().split(",");
			buffer.append(" and ( S_ME_CI_interest like '%' + ? + '%' ");
			params.add(interests[0]);
			for(int i=1;i<interests.length;i++){
				buffer.append(" or S_ME_CI_interest like '%' + ? + '%' ");
				params.add(interests[i]);
			}
			buffer.append(")");

		}
		if(!"".equals(Utility.getName(po.getSmeciname()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(po.getSmeciname());
		}
		if(!"".equals(Utility.getName(po.getSmecisex()))){
			buffer.append("and S_ME_CI_Sex= ? ");
			params.add(po.getSmecisex());
		}
		if(!"".equals(Utility.getName(po.getSmeciphone()))){
			buffer.append("and (S_ME_CI_Phone like '%' + ? + '%' or S_ME_CI_Phone2 like '%' + ? + '%' or S_ME_CI_Phone3 like '%' + ? + '%')");
			params.add(po.getSmeciphone());
			params.add(po.getSmeciphone());
			params.add(po.getSmeciphone());
		}
		if(!"".equals(Utility.getName(po.getSmecimemberid()))){
			buffer.append("and S_ME_CI_MemberId like '%' + ? + '%' ");
			params.add(po.getSmecimemberid());
		}
		if(!"".equals(Utility.getName(po.getSmeciagemin()))){
			buffer.append("and year(getdate())-year(S_ME_CI_Birthday) >= ? ");
			params.add(po.getSmeciagemin());
		}
		if(!"".equals(Utility.getName(po.getSmeciagemax()))){
			buffer.append("and year(getdate())-year(S_ME_CI_Birthday) <= ? ");
			params.add(po.getSmeciagemax());
		}
		if (!"".equals(Utility.getName(po.getStarttime()))	&& !"".equals(Utility.getName(po.getEndtime()))) {
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) <= ? ");
			params.add(po.getStarttime());
			params.add(po.getEndtime());
		} else if (!"".equals(Utility.getName(po.getStarttime()))&& "".equals(Utility.getName(po.getEndtime()))) {
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) >= ? ");
			params.add(po.getStarttime());
		} else if ("".equals(Utility.getName(po.getStarttime()))&& !"".equals(Utility.getName(po.getEndtime()))) {
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) <= ? ");
			params.add(po.getEndtime());
		}
		if (!"".equals(Utility.getName(po.getSrStartTime()))	&& !"".equals(Utility.getName(po.getSrEndTime()))) {
			buffer.append("and substring(convert(varchar(10),S_ME_CI_Birthday,23),6,10) >= ? ");
			buffer.append("and substring(convert(varchar(10),S_ME_CI_Birthday,23),6,10) <= ? ");
			params.add(po.getSrStartTime());
			params.add(po.getSrEndTime());
		} else if (!"".equals(Utility.getName(po.getSrStartTime()))&& "".equals(Utility.getName(po.getSrEndTime()))) {
			buffer.append("and substring(convert(varchar(10),S_ME_CI_Birthday,23),6,10) >= ? ");
			params.add(po.getSrStartTime());
		} else if ("".equals(Utility.getName(po.getSrStartTime()))&& !"".equals(Utility.getName(po.getSrEndTime()))) {
			buffer.append("and substring(convert(varchar(10),S_ME_CI_Birthday,23),6,10) <= ? ");
			params.add(po.getSrEndTime());
		}
		if (!"".equals(Utility.getName(po.getStarttimes()))	&& !"".equals(Utility.getName(po.getEndtimes()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(po.getStarttimes());
			params.add(po.getEndtimes());
		} else if (!"".equals(Utility.getName(po.getStarttimes()))&& "".equals(Utility.getName(po.getEndtimes()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			params.add(po.getStarttimes());
		} else if ("".equals(Utility.getName(po.getStarttimes()))&& !"".equals(Utility.getName(po.getEndtimes()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(po.getEndtimes());
		}
		
		if (!"".equals(Utility.getName(po.getIntegralmin())) && !"".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral >= ? ");
			buffer.append("and S_ME_CI_Integral <= ? ");
			params.add(po.getIntegralmin());
			params.add(po.getIntegralmax());
		} else if (!"".equals(Utility.getName(po.getIntegralmin()))&& "".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral >= ? ");
			params.add(po.getIntegralmin());
		} else if ("".equals(Utility.getName(po.getIntegralmin()))&& !"".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral <= ? ");
			params.add(po.getIntegralmax());
		}
		
		if (!"".equals(Utility.getName(po.getNumbermin())) && !"".equals(Utility.getName(po.getNumbermax()))) {
			buffer.append("and S_ME_CI_ConsumptionNumber >= cast(? as int) ");
			buffer.append("and S_ME_CI_ConsumptionNumber <= cast(? as int) ");
			params.add(po.getNumbermin());
			params.add(po.getNumbermax());
		} else if (!"".equals(Utility.getName(po.getNumbermin()))&& "".equals(Utility.getName(po.getNumbermax()))) {
			buffer.append("and S_ME_CI_ConsumptionNumber >= cast(? as int) ");
			params.add(po.getNumbermin());
		} else if ("".equals(Utility.getName(po.getNumbermin()))&& !"".equals(Utility.getName(po.getNumbermax()))) {
			buffer.append("and S_ME_CI_ConsumptionNumber <= cast(? as int) ");
			params.add(po.getNumbermax());
		}
		if(!"".equals(Utility.getName(po.getSmeciopenid()))){
			if("1".equals(Utility.getName(po.getSmeciopenid()))){
				buffer.append("and isnull(S_ME_CI_OpenID,'') <> '' ");
			}
			if("0".equals(Utility.getName(po.getSmeciopenid()))){
				buffer.append("and isnull(S_ME_CI_OpenID,'') = '' ");
			}
		}
		if (!"".equals(Utility.getName(po.getPricemin())) && !"".equals(Utility.getName(po.getPricemax()))) {
			buffer.append("and S_SE_SB_SalesValue >= ? ");
			buffer.append("and S_SE_SB_SalesValue <= ? ");
			params.add(po.getPricemin());
			params.add(po.getPricemax());
		} else if (!"".equals(Utility.getName(po.getPricemin()))&& "".equals(Utility.getName(po.getPricemax()))) {
			buffer.append("and S_SE_SB_SalesValue >= ? ");
			params.add(po.getPricemin());
		} else if ("".equals(Utility.getName(po.getPricemin()))&& !"".equals(Utility.getName(po.getPricemax()))) {
			buffer.append("and S_SE_SB_SalesValue <= ? ");
			params.add(po.getPricemax());
		}
		
		if (!"".equals(Utility.getName(po.getAllpricemin())) && !"".equals(Utility.getName(po.getAllpricemax()))) {
			buffer.append("and S_ME_CI_ConsumptionPrice >= ? ");
			buffer.append("and S_ME_CI_ConsumptionPrice <= ? ");
			params.add(po.getAllpricemin());
			params.add(po.getAllpricemax());
		} else if (!"".equals(Utility.getName(po.getAllpricemin()))&& "".equals(Utility.getName(po.getAllpricemax()))) {
			buffer.append("and S_ME_CI_ConsumptionPrice >= ? ");
			params.add(po.getAllpricemin());
		} else if ("".equals(Utility.getName(po.getAllpricemin()))&& !"".equals(Utility.getName(po.getAllpricemax()))) {
			buffer.append("and S_ME_CI_ConsumptionPrice <= ? ");
			params.add(po.getAllpricemax());
		}
		
		if(!"".equals(Utility.getName(po.getSelcstpsupplierid()))){
			buffer.append("and B_GoodsInfo.B_GI_SupplierID= ? ");
			params.add(po.getSelcstpsupplierid());
		}
		if(!"".equals(Utility.getName(po.getPersontype()))){
			buffer.append("and S_ME_CI_PersonType= ? ");
			params.add(po.getPersontype());
		}
		if(!"".equals(Utility.getName(po.getBrandID()))){
			buffer.append("and B_GoodsInfo.B_GI_BrandID= ? ");
			params.add(po.getBrandID());
		}
		if(!"".equals(Utility.getName(po.getGoodsid()))){
			buffer.append("and B_GoodsInfo.B_GI_GoodsID= ? ");
			params.add(po.getGoodsid());
		}
		if(!"".equals(Utility.getName(po.getTechnologytypeid()))){
			buffer.append("and B_GoodsInfo.B_GI_frameProcessCraftType= ? ");
			params.add(po.getTechnologytypeid());
		}
		if(!"".equals(Utility.getName(po.getBbdframematerialtype()))){
			buffer.append("and B_GoodsInfo.B_GI_FrameMaterialType= ? ");
			params.add(po.getBbdframematerialtype());
		}
		if(!"".equals(Utility.getName(po.getBbdmaterialclass()))){
			buffer.append("and B_GoodsInfo.B_GI_EyeGlassMaterialType= ? ");
			params.add(po.getBbdmaterialclass());
		}
		if(!"".equals(Utility.getName(po.getBbdrefractive()))){
			buffer.append("and B_GoodsInfo.B_GI_Refractive= ? ");
			params.add(po.getBbdrefractive());
		}
		if(!"".equals(Utility.getName(po.getBbdluminosityclass()))){
			buffer.append("and B_GoodsInfo.B_GI_isMutiLuminosity= ? ");
			params.add(po.getBbdluminosityclass());
		}
		if(!"".equals(Utility.getName(po.getBbdfunctionclass()))){
			buffer.append("and B_GoodsInfo.B_GI_FunctionClass= ? ");
			params.add(po.getBbdfunctionclass());
		}
		if(!"".equals(Utility.getName(po.getBbdusetype()))){
			buffer.append("and B_GoodsInfo.B_GI_UseType= ? ");
			params.add(po.getBbdusetype());
		}
		if(!"".equals(Utility.getName(po.getBbdstealthclass()))){
			buffer.append("and B_GoodsInfo.B_GI_StealthClass= ? ");
			params.add(po.getBbdstealthclass());
		}
		
		if(!"".equals(Utility.getName(po.getSmeciwork()))){
			buffer.append("and S_ME_CI_work = ? ");
			params.add(Utility.getName(po.getSmeciwork()));
		}	
	
		if(!"".equals(Utility.getName(po.getSmecimemberorigin()))){
			
			buffer.append("and ( S_ME_CI_MemberOrigin like '%' + ? + '%' ");
			
			String[] array = Utility.getName(po.getSmecimemberorigin()).split(",");
			params.add(array[0]);
			for (int i = 1; i < array.length; i++){
				buffer.append(" or S_ME_CI_MemberOrigin like '%' + ? + '%' ");
				params.add(array[i]);
			}
			buffer.append(" ) ");
		}
		
		if(!"".equals(Utility.getName(po.getSmeciflag()))){
			buffer.append("and S_ME_CI_Flag = ? ");
			params.add(po.getSmeciflag());
		}

		
		if(!"".equals(Utility.getName(po.getSmecicardtype()))){
			buffer.append("and S_ME_CI_CardType = '"+ po.getSmecicardtype() +"' ");
		}	
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		if(!"".equals(Utility.getName(po.getSmeciremark()))){
			buffer.append(" and S_ME_CI_Remark like '%' + ? + '%' ");
			params.add(Utility.getName(po.getSmeciremark()));
		}
		
		buffer.append(" group by S_ME_CI_CustomerID,S_ME_CI_Name,S_ME_CI_Sex,S_ME_CI_Birthday,S_ME_CI_Email, ");
		buffer.append(" S_ME_CI_Address,S_ME_CI_Zone,S_ME_CI_Area1,S_ME_CI_Area2,S_ME_CI_Area3,S_ME_CI_Area4,S_ME_CI_Area5,S_ME_CI_PostCode,S_ME_CI_Phone,S_ME_CI_Phone2,S_ME_CI_Phone3,S_ME_CI_MemberId, ");
		buffer.append(" S_ME_CI_Integral,S_ME_CI_ShopCode,S_ME_CI_QqNumber,isnull(B_WT_Name,''),isnull(B_MO_Name,''),dbo.getInterestNameList(isnull(S_ME_CI_Interest,'')),F_MM_MemberName,F_MM_UP,F_MM_DOWN,F_MM_Discount,S_ME_CI_Remark ");
		buffer.append(" ) temp ");

		return queryForObjectList(buffer.toString() , params.toArray() , CustomerInfoPo.class);
	}
	/**
	 * 遍历高级会员信息
	 */
	public List<CustomerInfoPo> getCustomerInfoListMessage(CustomerInfoPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();

		buffer.append("select * from(select ROW_NUMBER() ");
		buffer.append("Over(order by S_ME_CI_CustomerID desc) as rowNum,");
		
		buffer.append("S_ME_CI_CustomerID as smecicustomerid,");
		buffer.append("S_ME_CI_Name as smeciname,");
		buffer.append("S_ME_CI_Sex as smecisex,");
		buffer.append("S_ME_CI_Birthday as smecibirthday,");
		buffer.append("S_ME_CI_Email as smeciemail,");
		buffer.append("S_ME_CI_Address as smeciaddress,");
		buffer.append("S_ME_CI_Zone as smecizone,");
	
		buffer.append("S_ME_CI_PostCode as smecipostcode,");
		buffer.append("S_ME_CI_Phone as smeciphone,");
		buffer.append("S_ME_CI_MemberId as smecimemberid,");
		buffer.append("S_ME_CI_Integral as smeciintegral,");
		buffer.append("S_ME_CI_ShopCode as smecishopcode,");
		
		buffer.append("F_MM_MemberName as fmmmembername,");
		buffer.append("F_MM_UP as fmmup,");
		buffer.append("F_MM_DOWN as fmmdown,");
		buffer.append("F_MM_Discount as fmmdiscount");
		
		buffer.append(" from S_ME_CustomerInfo ");	
		buffer.append(" left join F_MemberManagement on F_MemberManagement.F_MM_ID=S_ME_CustomerInfo.S_ME_CI_CardType ");
		
		if(!"".equals(Utility.getName(po.getSalsepersonname()))||!"".equals(Utility.getName(po.getSalestype()))||!"".equals(Utility.getName(po.getStarttimes()))||!"".equals(Utility.getName(po.getEndtimes()))||!"".equals(Utility.getName(po.getPricemin()))||!"".equals(Utility.getName(po.getPricemax()))||!"".equals(Utility.getName(po.getBbdstealthclass()))||!"".equals(Utility.getName(po.getBbdusetype()))||!"".equals(Utility.getName(po.getBbdfunctionclass()))||!"".equals(Utility.getName(po.getBbdluminosityclass()))||!"".equals(Utility.getName(po.getBbdrefractive()))||!"".equals(Utility.getName(po.getBbdmaterialclass()))||!"".equals(Utility.getName(po.getBbdframematerialtype()))||!"".equals(Utility.getName(po.getSelcstpsupplierid())) ||!"".equals(Utility.getName(po.getBrandID()))||!"".equals(Utility.getName(po.getGoodsid()))||!"".equals(Utility.getName(po.getTechnologytypeid()))){
			buffer.append(" left join uview_SalesBasic on S_SE_SB_CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");
			buffer.append(" left join uview_SalesDetail on S_SE_SD_SalesID=S_SE_SB_SalesID ");
			buffer.append(" left join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID = S_SE_SD_SalesItemID ");
		}	
		if(!"".equals(Utility.getName(po.getHuifangcishu()))){//回访次数查询
			buffer.append(" left join  (select count(S_SE_SB_CustomerID) as hfCiShu,S_SE_SB_CustomerID as CustomerID  from S_ME_CustomerVisit LEFT JOIN uview_SalesBasic ON S_SE_SB_SalesID = S_ME_CV_SalesID group by S_SE_SB_CustomerID ) as t1 on t1.CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		}
		
		buffer.append("  where 1=1 ");		
		
		if(!"".equals(Utility.getName(po.getSmeciaddress()))){
			buffer.append(" and replace(S_ME_CI_Zone, ' ', '') like '%' + ? + '%' ");
			params.add(Utility.getName(po.getSmeciaddress()));
		}
		
		if("1".equals(Utility.getName(po.getPhoneflag()))){
			buffer.append("and (");
			buffer.append("(substring(S_ME_CI_Phone,1,1)='1' ");
			buffer.append("and len(S_ME_CI_Phone)=11) ");
			
			buffer.append("or (substring(S_ME_CI_Phone2,1,1)='1' ");
			buffer.append("and len(S_ME_CI_Phone2)=11) ");
			
			buffer.append("or (substring(S_ME_CI_Phone3,1,1)='1' ");
			buffer.append("and len(S_ME_CI_Phone3)=11) ");
			
			buffer.append(") ");
		}
		if(!"".equals(Utility.getName(po.getSalsepersonname()))){
			buffer.append(" and (select personName from dbo.SYS_PersonInfo where ID=S_SE_SB_SalerID ) like '%' + ? + '%'");
			params.add(po.getSalsepersonname());
		}
		
		if(!"".equals(Utility.getName(po.getHuifangcishu()))){
			buffer.append(" and isnull(t1.hfCiShu,0)= ? ");
			params.add(po.getHuifangcishu());
		}
		if(!"".equals(Utility.getName(po.getSmecishopcode()))){
			
			buffer.append("and S_ME_CI_ShopCode in ( ? ");
			
			String[] array = Utility.getName(po.getSmecishopcode()).split(",");
			params.add(array[0]);
			for (int i = 1; i < array.length; i++){
				buffer.append(" ,? ");
				params.add(array[i]);
			}
			buffer.append(" ) ");
		}
		if(!"".equals(Utility.getName(po.getSalestype()))){
			
			buffer.append("and S_SE_SB_OrdersType in ( ? ");
			
			String[] array = Utility.getName(po.getSalestype()).split(",");
			params.add(array[0]);
			for (int i = 1; i < array.length; i++){
				buffer.append(" ,? ");
				params.add(array[i]);
			}
			buffer.append(" ) ");
		}
		if(!"".equals(Utility.getName(po.getSmecicustomerid()))){
			buffer.append("and S_ME_CI_CustomerID= ? ");
			params.add(po.getSmecicustomerid());
		}
		
		if(!"".equals(Utility.getName(po.getSmeciinterest()))){
			String[] interests=po.getSmeciinterest().split(",");
			buffer.append(" and ( S_ME_CI_interest like '%' + ? + '%' ");
			params.add(interests[0]);
			for(int i=1;i<interests.length;i++){
				buffer.append(" or S_ME_CI_interest like '%' + ? + '%' ");
				params.add(interests[i]);
			}
			buffer.append(")");

		}
		if(!"".equals(Utility.getName(po.getSmeciname()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(po.getSmeciname());
		}
		if(!"".equals(Utility.getName(po.getSmecisex()))){
			buffer.append("and S_ME_CI_Sex= ? ");
			params.add(po.getSmecisex());
		}
		if(!"".equals(Utility.getName(po.getSmeciphone()))){
			buffer.append("and (S_ME_CI_Phone like '%' + ? + '%' or S_ME_CI_Phone2 like '%' + ? + '%' or S_ME_CI_Phone3 like '%' + ? + '%')");
			params.add(po.getSmeciphone());
			params.add(po.getSmeciphone());
			params.add(po.getSmeciphone());
		}
		if(!"".equals(Utility.getName(po.getSmecimemberid()))){
			buffer.append("and S_ME_CI_MemberId like '%' + ? + '%' ");
			params.add(po.getSmecimemberid());
		}
		if(!"".equals(Utility.getName(po.getSmeciagemin()))){
			buffer.append("and year(getdate())-year(S_ME_CI_Birthday) >= ? ");
			params.add(po.getSmeciagemin());
		}
		if(!"".equals(Utility.getName(po.getSmeciagemax()))){
			buffer.append("and year(getdate())-year(S_ME_CI_Birthday) <= ? ");
			params.add(po.getSmeciagemax());
		}
		if (!"".equals(Utility.getName(po.getStarttime()))	&& !"".equals(Utility.getName(po.getEndtime()))) {
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) <= ? ");
			params.add(po.getStarttime());
			params.add(po.getEndtime());
		} else if (!"".equals(Utility.getName(po.getStarttime()))&& "".equals(Utility.getName(po.getEndtime()))) {
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) >= ? ");
			params.add(po.getStarttime());
		} else if ("".equals(Utility.getName(po.getStarttime()))&& !"".equals(Utility.getName(po.getEndtime()))) {
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) <= ? ");
			params.add(po.getEndtime());
		}
		if (!"".equals(Utility.getName(po.getSrStartTime()))	&& !"".equals(Utility.getName(po.getSrEndTime()))) {
			buffer.append("and substring(convert(varchar(10),S_ME_CI_Birthday,23),6,10) >= ? ");
			buffer.append("and substring(convert(varchar(10),S_ME_CI_Birthday,23),6,10) <= ? ");
			params.add(po.getSrStartTime());
			params.add(po.getSrEndTime());
		} else if (!"".equals(Utility.getName(po.getSrStartTime()))&& "".equals(Utility.getName(po.getSrEndTime()))) {
			buffer.append("and substring(convert(varchar(10),S_ME_CI_Birthday,23),6,10) >= ? ");
			params.add(po.getSrStartTime());
		} else if ("".equals(Utility.getName(po.getSrStartTime()))&& !"".equals(Utility.getName(po.getSrEndTime()))) {
			buffer.append("and substring(convert(varchar(10),S_ME_CI_Birthday,23),6,10) <= ? ");
			params.add(po.getSrEndTime());
		}
		if (!"".equals(Utility.getName(po.getStarttimes()))	&& !"".equals(Utility.getName(po.getEndtimes()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(po.getStarttimes());
			params.add(po.getEndtimes());
		} else if (!"".equals(Utility.getName(po.getStarttimes()))&& "".equals(Utility.getName(po.getEndtimes()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			params.add(po.getStarttimes());
		} else if ("".equals(Utility.getName(po.getStarttimes()))&& !"".equals(Utility.getName(po.getEndtimes()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(po.getEndtimes());
		}
		
		if (!"".equals(Utility.getName(po.getIntegralmin())) && !"".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral >= ? ");
			buffer.append("and S_ME_CI_Integral <= ? ");
			params.add(po.getIntegralmin());
			params.add(po.getIntegralmax());
		} else if (!"".equals(Utility.getName(po.getIntegralmin()))&& "".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral >= ? ");
			params.add(po.getIntegralmin());
		} else if ("".equals(Utility.getName(po.getIntegralmin()))&& !"".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral <= ? ");
			params.add(po.getIntegralmax());
		}
		
		if (!"".equals(Utility.getName(po.getNumbermin())) && !"".equals(Utility.getName(po.getNumbermax()))) {
			buffer.append("and S_ME_CI_ConsumptionNumber >= cast(? as int) ");
			buffer.append("and S_ME_CI_ConsumptionNumber <= cast(? as int) ");
			params.add(po.getNumbermin());
			params.add(po.getNumbermax());
		} else if (!"".equals(Utility.getName(po.getNumbermin()))&& "".equals(Utility.getName(po.getNumbermax()))) {
			buffer.append("and S_ME_CI_ConsumptionNumber >= cast(? as int) ");
			params.add(po.getNumbermin());
		} else if ("".equals(Utility.getName(po.getNumbermin()))&& !"".equals(Utility.getName(po.getNumbermax()))) {
			buffer.append("and S_ME_CI_ConsumptionNumber <= cast(? as int) ");
			params.add(po.getNumbermax());
		}
		if(!"".equals(Utility.getName(po.getSmeciopenid()))){
			if("1".equals(Utility.getName(po.getSmeciopenid()))){
				buffer.append("and isnull(S_ME_CI_OpenID,'') <> '' ");
			}
			if("0".equals(Utility.getName(po.getSmeciopenid()))){
				buffer.append("and isnull(S_ME_CI_OpenID,'') = '' ");
			}
		}
		if (!"".equals(Utility.getName(po.getPricemin())) && !"".equals(Utility.getName(po.getPricemax()))) {
			buffer.append("and S_SE_SB_SalesValue >= ? ");
			buffer.append("and S_SE_SB_SalesValue <= ? ");
			params.add(po.getPricemin());
			params.add(po.getPricemax());
		} else if (!"".equals(Utility.getName(po.getPricemin()))&& "".equals(Utility.getName(po.getPricemax()))) {
			buffer.append("and S_SE_SB_SalesValue >= ? ");
			params.add(po.getPricemin());
		} else if ("".equals(Utility.getName(po.getPricemin()))&& !"".equals(Utility.getName(po.getPricemax()))) {
			buffer.append("and S_SE_SB_SalesValue <= ? ");
			params.add(po.getPricemax());
		}
		
		if (!"".equals(Utility.getName(po.getAllpricemin())) && !"".equals(Utility.getName(po.getAllpricemax()))) {
			buffer.append("and S_ME_CI_ConsumptionPrice >= ? ");
			buffer.append("and S_ME_CI_ConsumptionPrice <= ? ");
			params.add(po.getAllpricemin());
			params.add(po.getAllpricemax());
		} else if (!"".equals(Utility.getName(po.getAllpricemin()))&& "".equals(Utility.getName(po.getAllpricemax()))) {
			buffer.append("and S_ME_CI_ConsumptionPrice >= ? ");
			params.add(po.getAllpricemin());
		} else if ("".equals(Utility.getName(po.getAllpricemin()))&& !"".equals(Utility.getName(po.getAllpricemax()))) {
			buffer.append("and S_ME_CI_ConsumptionPrice <= ? ");
			params.add(po.getAllpricemax());
		}
		
		if(!"".equals(Utility.getName(po.getSelcstpsupplierid()))){
			buffer.append("and B_GoodsInfo.B_GI_SupplierID= ? ");
			params.add(po.getSelcstpsupplierid());
		}
		if(!"".equals(Utility.getName(po.getPersontype()))){
			buffer.append("and S_ME_CI_PersonType= ? ");
			params.add(po.getPersontype());
		}
		if(!"".equals(Utility.getName(po.getBrandID()))){
			buffer.append("and B_GoodsInfo.B_GI_BrandID= ? ");
			params.add(po.getBrandID());
		}
		if(!"".equals(Utility.getName(po.getGoodsid()))){
			buffer.append("and B_GoodsInfo.B_GI_GoodsID= ? ");
			params.add(po.getGoodsid());
		}
		if(!"".equals(Utility.getName(po.getTechnologytypeid()))){
			buffer.append("and B_GoodsInfo.B_GI_frameProcessCraftType= ? ");
			params.add(po.getTechnologytypeid());
		}
		if(!"".equals(Utility.getName(po.getBbdframematerialtype()))){
			buffer.append("and B_GoodsInfo.B_GI_FrameMaterialType= ? ");
			params.add(po.getBbdframematerialtype());
		}
		if(!"".equals(Utility.getName(po.getBbdmaterialclass()))){
			buffer.append("and B_GoodsInfo.B_GI_EyeGlassMaterialType= ? ");
			params.add(po.getBbdmaterialclass());
		}
		if(!"".equals(Utility.getName(po.getBbdrefractive()))){
			buffer.append("and B_GoodsInfo.B_GI_Refractive= ? ");
			params.add(po.getBbdrefractive());
		}
		if(!"".equals(Utility.getName(po.getBbdluminosityclass()))){
			buffer.append("and B_GoodsInfo.B_GI_isMutiLuminosity= ? ");
			params.add(po.getBbdluminosityclass());
		}
		if(!"".equals(Utility.getName(po.getBbdfunctionclass()))){
			buffer.append("and B_GoodsInfo.B_GI_FunctionClass= ? ");
			params.add(po.getBbdfunctionclass());
		}
		if(!"".equals(Utility.getName(po.getBbdusetype()))){
			buffer.append("and B_GoodsInfo.B_GI_UseType= ? ");
			params.add(po.getBbdusetype());
		}
		if(!"".equals(Utility.getName(po.getBbdstealthclass()))){
			buffer.append("and B_GoodsInfo.B_GI_StealthClass= ? ");
			params.add(po.getBbdstealthclass());
		}
		
		if(!"".equals(Utility.getName(po.getSmeciwork()))){
			buffer.append("and S_ME_CI_work = ? ");
			params.add(Utility.getName(po.getSmeciwork()));
		}	
	
		if(!"".equals(Utility.getName(po.getSmecimemberorigin()))){
			
			buffer.append("and ( S_ME_CI_MemberOrigin like '%' + ? + '%' ");
			
			String[] array = Utility.getName(po.getSmecimemberorigin()).split(",");
			params.add(array[0]);
			for (int i = 1; i < array.length; i++){
				buffer.append(" or S_ME_CI_MemberOrigin like '%' + ? + '%' ");
				params.add(array[i]);
			}
			buffer.append(" ) ");
		}
		
		if(!"".equals(Utility.getName(po.getSmeciflag()))){
			buffer.append("and S_ME_CI_Flag = ? ");
			params.add(po.getSmeciflag());
		}

		
		if(!"".equals(Utility.getName(po.getSmecicardtype()))){
			buffer.append("and S_ME_CI_CardType = '"+ po.getSmecicardtype() +"' ");
		}	
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		buffer.append(" group by S_ME_CI_CustomerID,S_ME_CI_Name,S_ME_CI_Sex,S_ME_CI_Birthday,S_ME_CI_Email, ");
		buffer.append(" S_ME_CI_Address,S_ME_CI_Zone,S_ME_CI_PostCode,S_ME_CI_Phone,S_ME_CI_MemberId, ");
		buffer.append(" S_ME_CI_Integral,S_ME_CI_ShopCode,F_MM_MemberName,F_MM_UP,F_MM_DOWN,F_MM_Discount ");
		buffer.append(" ) temp ");
		
		return queryForObjectList(buffer.toString() , params.toArray() , CustomerInfoPo.class);
	}
	/**
	 * 遍历会员信息
	 */
	public List<CustomerInfoPo> getCustomerInfoList(CustomerInfoPo po,
			int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from(select ROW_NUMBER() ");
		buffer.append("Over(order by S_ME_CI_RegisterDate desc) as rowNum,");
		
		buffer.append("S_ME_CI_CustomerID as smecicustomerid,");
		buffer.append("S_ME_CI_Name as smeciname,");
		buffer.append("S_ME_CI_Sex as smecisex,");
		buffer.append("S_ME_CI_Birthday as smecibirthday,");
		buffer.append("isnull(S_ME_CI_Flag,'1') as smeciflag, ");
		buffer.append("S_ME_CI_Phone as smeciphone,");
		buffer.append("S_ME_CI_MemberId as smecimemberid,");
		buffer.append("S_ME_CI_Integral as smeciintegral,");
		buffer.append("F_MM_MemberName as fmmmembername, ");
		buffer.append("S_ME_CI_FCustomerId as smecifcustomerid ");
		buffer.append(" from S_ME_CustomerInfo ");	
		buffer.append(" left join F_MemberManagement on F_MemberManagement.F_MM_ID=S_ME_CustomerInfo.S_ME_CI_CardType ");
		
	
		buffer.append("  where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getIntegralmin())) && !"".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral >= ? ");
			buffer.append("and S_ME_CI_Integral <= ? ");
			params.add(po.getIntegralmin());
			params.add(po.getIntegralmax());
		} else if (!"".equals(Utility.getName(po.getIntegralmin()))&& "".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral >= ? ");
			params.add(po.getIntegralmin());
		} else if ("".equals(Utility.getName(po.getIntegralmin()))&& !"".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral <= ? ");
			params.add(po.getIntegralmax());
		}
		if(!"".equals(Utility.getName(po.getSmecishopcode()))){
			buffer.append("and S_ME_CI_ShopCode= ? ");
			params.add(po.getSmecishopcode());
		}
		if(!"".equals(Utility.getName(po.getSmeciopenid()))){
			if("1".equals(Utility.getName(po.getSmeciopenid()))){
				buffer.append("and isnull(S_ME_CI_OpenID,'') <> '' ");
			}
			if("0".equals(Utility.getName(po.getSmeciopenid()))){
				buffer.append("and isnull(S_ME_CI_OpenID,'') = '' ");
			}
		}
		if(!"".equals(Utility.getName(po.getSmecicustomerid()))){
			buffer.append("and S_ME_CI_CustomerID= ? ");
			params.add(po.getSmecicustomerid());
		}
		if(!"".equals(Utility.getName(po.getSmeciname()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(po.getSmeciname());
		}
		if(!"".equals(Utility.getName(po.getSmecisex()))){
			buffer.append("and S_ME_CI_Sex= ? ");
			params.add(po.getSmecisex());
		}
		if(!"".equals(Utility.getName(po.getSmeciphone()))){
			buffer.append("and (S_ME_CI_Phone like '%' + ? + '%' or S_ME_CI_Phone2 like '%' + ? + '%' or S_ME_CI_Phone3 like '%' + ? + '%')");
			params.add(po.getSmeciphone());
			params.add(po.getSmeciphone());
			params.add(po.getSmeciphone());
		}
		if(!"".equals(Utility.getName(po.getSmecimemberid()))){
			buffer.append("and S_ME_CI_MemberId like '%' + ? + '%' ");
			params.add(po.getSmecimemberid());
		}
		if(!"".equals(Utility.getName(po.getSmeciagemin()))){
			buffer.append("and year(getdate())-year(S_ME_CI_Birthday) >= ? ");
			params.add(po.getSmeciagemin());
		}
		if(!"".equals(Utility.getName(po.getSmeciagemax()))){
			buffer.append("and year(getdate())-year(S_ME_CI_Birthday) <= ? ");
			params.add(po.getSmeciagemax());
		}
		
		if(!"".equals(Utility.getName(po.getSmeciflag()))){
			buffer.append("and S_ME_CI_Flag = '"+ po.getSmeciflag() +"' ");
		}		
		
		if(!"".equals(Utility.getName(po.getIsnullfcustomerid()))){//查询主卡字段为空的会员
			buffer.append("and isnull(S_ME_CI_FCustomerId,'')='' ");
		}
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		buffer.append(" ) temp where rowNum > "+start+" and rowNum <= "+ (start + size));
		buffer.append("set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , CustomerInfoPo.class);
	}

	/**
	 * 新增会员信息
	 */
	public void insertCustomerInfo(CustomerInfoPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO S_ME_CustomerInfo ");
		buffer.append("            (S_ME_CI_CustomerID, ");
		buffer.append("             S_ME_CI_Name, ");
		buffer.append("             S_ME_CI_Sex, ");
		buffer.append("             S_ME_CI_Birthday, ");
		buffer.append("             S_ME_CI_Email, ");
		buffer.append("             S_ME_CI_Address, ");
		buffer.append("             S_ME_CI_Zone, ");
		buffer.append("             S_ME_CI_PostCode, ");
		buffer.append("             S_ME_CI_Phone, ");
		buffer.append("             S_ME_CI_MemberId, ");
		buffer.append("             S_ME_CI_Integral, ");
		buffer.append("             S_ME_CI_CardType, ");
		buffer.append("             S_ME_CI_ShopCode, ");
		buffer.append("             S_ME_CI_RegisterDate, ");
		buffer.append("             S_ME_CI_Register, ");
		buffer.append("             S_ME_CI_UpdateDate, ");
		buffer.append("             S_ME_CI_Updater, ");
		buffer.append("             S_ME_CI_CustomerType, ");
		buffer.append("             S_ME_CI_work, ");
		buffer.append("             S_ME_CI_QqNumber, ");
		buffer.append("             S_ME_CI_Interest, ");
		buffer.append("             S_ME_CI_MemberOrigin, ");
		if(po.getMemberPicPath()!=null&&!po.getMemberPicPath().equals("")){
			buffer.append("             S_ME_CI_MemberPicPath, ");
		}
		buffer.append("             S_ME_CI_ConsumptionNumber, ");
		buffer.append("             S_ME_CI_ConsumptionPrice, ");
		buffer.append("             S_ME_CI_Phone2, ");
		buffer.append("             S_ME_CI_Phone3, ");
		buffer.append("             S_ME_CI_Sourcecard, ");
		buffer.append("             S_ME_CI_IdentityCard, ");
		buffer.append("             S_ME_CI_PersonType, ");
		buffer.append("             S_ME_CI_Remark, ");
		buffer.append("             S_ME_CI_FCustomerId, ");
		buffer.append("             S_ME_CI_Flag, ");
		buffer.append("             S_ME_CI_ModelworkersCode, ");
		buffer.append("             S_ME_CI_Area1, ");
		buffer.append("             S_ME_CI_Area2, ");
		buffer.append("             S_ME_CI_Area3, ");
		buffer.append("             S_ME_CI_Area4, ");
		buffer.append("             S_ME_CI_Area5, ");
		buffer.append("             S_ME_CI_LevelUpDate, ");
		buffer.append("             S_ME_CI_TJRPhone) ");
		buffer.append("select       ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		if ("".equals(Utility.getName(po.getSmecicardtype()))){
			buffer.append("             (SELECT TOP 1 F_MM_ID FROM F_MemberManagement WHERE F_MM_IsDefault = '1'), ");
		}else{
			buffer.append("             ?, ");
		}		
		buffer.append("             ?, ");
		buffer.append("             getdate(), ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		if(po.getMemberPicPath()!=null&&!po.getMemberPicPath().equals("")){
			buffer.append("             ?, ");
		}			
		buffer.append("             ?,  ");	
		buffer.append("             ?,  ");
		buffer.append("             ?,  ");
		buffer.append("             ?,  ");
		buffer.append("             ?,  ");
		buffer.append("             ?,  ");
		buffer.append("             ?,  ");
		buffer.append("             ?,  ");
		buffer.append("             ?,'1',?,?,?,?,?,?,getdate(),?");
		
		if("".equals(Utility.getName(po.getSmecicustomerid()))){  // 顾客号
			params.add(this.uuid.generate());
		}else{
			params.add(po.getSmecicustomerid());
		}
		params.add(Utility.getName(po.getSmeciname().trim()));    // 姓名
		params.add(Utility.getName(po.getSmecisex()));            // 性别
		params.add(Utility.getName(po.getSmecibirthday()));       // 生日
		params.add(Utility.getName(po.getSmeciemail()));          // email
		params.add(Utility.getName(po.getSmeciaddress()));        // 地址
		params.add(Utility.getName(po.getSmecizone()));           // 区域名称
		params.add(Utility.getName(po.getSmecipostcode()));       // 邮编
		params.add(Utility.getName(po.getSmeciphone()));          // 联系电话1
		params.add(Utility.getName(po.getSmecimemberid()));       // 会员卡号
		params.add(Utility.getName(po.getSmeciintegral()));       // 积分
		if (!"".equals(Utility.getName(po.getSmecicardtype()))){  // 卡片类型
			params.add(Utility.getName(po.getSmecicardtype()));
		}
		params.add(Utility.getName(po.getSmecishopcode()));       // 店号
		params.add(Utility.getName(po.getSmeciregister()));       // 注册人员
		params.add(Utility.getName(po.getSmeciupdatedate()));     // 更新时间
		params.add(Utility.getName(po.getSmeciupdater()));		  // 更新人员
		params.add(Utility.getName(po.getSmecicustomertype()));   // 顾客类型	
		params.add(Utility.getName(po.getSmeciwork()));           // 职业
		params.add(Utility.getName(po.getSmeciqqnumber()));       // QQ号
		params.add(Utility.getName(po.getSmeciinterest()));       // 兴趣爱好
		params.add(Utility.getName(po.getSmecimemberorigin()));   // 来源
		if(po.getMemberPicPath()!=null&&!po.getMemberPicPath().equals("")){
			params.add(Utility.getName(po.getMemberPicPath()));   //照片路径
		}
		params.add("0");
		params.add("0.00");
		params.add(Utility.getName(po.getSmeciphone2()));
		params.add(Utility.getName(po.getSmeciphone3()));
		params.add(Utility.getName(po.getSmecisourcecard()));     //关联卡对应顾客卡号
		params.add(Utility.getName(po.getSmeidentitycard()));     // 身份证
		params.add(Utility.getName(po.getSmecipersontype()));     // 人群分类ID
		params.add(Utility.getName(po.getSmeciremark()));
		params.add(Utility.getName(po.getSmecifcustomerid()));
		params.add(Utility.getName(po.getSmecimodelworkerscode()));
		
		params.add(Utility.getName(po.getSmeciarea1()));
		params.add(Utility.getName(po.getSmeciarea2()));
		params.add(Utility.getName(po.getSmeciarea3()));
		params.add(Utility.getName(po.getSmeciarea4()));
		params.add(Utility.getName(po.getSmeciarea5()));
		params.add(Utility.getName(po.getSmecitjrphone()));       //推荐人手机号

		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	/**
	 * 修改会员信息
	 */
	public void updateCustomerInfo(CustomerInfoPo po) {
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update S_ME_CustomerInfo set ");
		buffer.append("S_ME_CI_Name= ? ,");
		buffer.append("S_ME_CI_Sex= ? ,");
		buffer.append("S_ME_CI_Birthday= ? ,");
		buffer.append("S_ME_CI_Email= ? ,");
		buffer.append("S_ME_CI_Address= ? ,");
		buffer.append("S_ME_CI_Zone= ? ,");
		buffer.append("S_ME_CI_PostCode= ? ,");
		buffer.append("S_ME_CI_Phone= ? ,");
		buffer.append("S_ME_CI_MemberId= ? , ");
		buffer.append("S_ME_CI_UpdateDate= getdate() , ");
		buffer.append("S_ME_CI_Updater= ? ,");
		buffer.append("S_ME_CI_CustomerType= ? ,");
		buffer.append("S_ME_CI_work= ? ,");
		buffer.append("S_ME_CI_QqNumber= ? ,");
		buffer.append("S_ME_CI_Interest= ? ,");
		if(po.getMemberPicPath()!=null&&!po.getMemberPicPath().equals("")){
			buffer.append("S_ME_CI_MemberPicPath= ? ,");
		}
		if(!Utility.getName(po.getSmecicardtype()).equals("")){
			buffer.append("S_ME_CI_CardType= ? ,");
		}	
		buffer.append("S_ME_CI_MemberOrigin= ?, ");
		buffer.append("S_ME_CI_Phone2 = ?, ");
		buffer.append("S_ME_CI_Phone3 = ?, ");
		buffer.append("S_ME_CI_Sourcecard = ?, ");
		buffer.append("S_ME_CI_IdentityCard = ?, ");
		buffer.append("S_ME_CI_PersonType = ?, ");
		buffer.append("S_ME_CI_Remark=?,  ");
		buffer.append("S_ME_CI_FCustomerId=?,  ");
		buffer.append("S_ME_CI_ModelworkersCode=?,  ");
		buffer.append("S_ME_CI_Area1=?,  ");	
		buffer.append("S_ME_CI_Area2=?,  ");
		buffer.append("S_ME_CI_Area3=?,  ");
		buffer.append("S_ME_CI_Area4=?,  ");
		buffer.append("S_ME_CI_Area5=?  ");		
		buffer.append(" WHERE S_ME_CI_CustomerID= ? ");
		
		params.add(po.getSmeciname());
		params.add(po.getSmecisex());
		params.add(po.getSmecibirthday());
		params.add(po.getSmeciemail());
		params.add(po.getSmeciaddress());
		params.add(po.getSmecizone());
		params.add(po.getSmecipostcode());
		params.add(po.getSmeciphone());
		params.add(po.getSmecimemberid());
		params.add(po.getSmeciupdater());
		
		params.add(Utility.getName(po.getSmecicustomertype()));
		params.add(Utility.getName(po.getSmeciwork()));
		params.add(Utility.getName(po.getSmeciqqnumber()));
		params.add(Utility.getName(po.getSmeciinterest()));
		if(po.getMemberPicPath()!=null&&!po.getMemberPicPath().equals("")){
			params.add(po.getMemberPicPath());
		}
		if(!Utility.getName(po.getSmecicardtype()).equals("")){
			params.add(Utility.getName(po.getSmecicardtype()));
		}
		params.add(Utility.getName(po.getSmecimemberorigin()));
		params.add(Utility.getName(po.getSmeciphone2()));
		params.add(Utility.getName(po.getSmeciphone3()));
		params.add(Utility.getName(po.getSmecisourcecard()));
		params.add(Utility.getName(po.getSmeidentitycard()));
		params.add(Utility.getName(po.getSmecipersontype()));
		params.add(Utility.getName(po.getSmeciremark()));
		params.add(Utility.getName(po.getSmecifcustomerid()));
		params.add(Utility.getName(po.getSmecimodelworkerscode()));
		
		params.add(Utility.getName(po.getSmeciarea1()));
		params.add(Utility.getName(po.getSmeciarea2()));
		params.add(Utility.getName(po.getSmeciarea3()));
		params.add(Utility.getName(po.getSmeciarea4()));
		params.add(Utility.getName(po.getSmeciarea5()));
		
		params.add(po.getSmecicustomerid());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 修改会员关联卡电话为主卡电话,关联卡关联主卡卡号为最新修改主卡卡号
	 * @param po
	 */
	public void updateCustomerInfoPhone(String oldCardId,String cardId,String phone){
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update S_ME_CustomerInfo set ");
		buffer.append("S_ME_CI_Phone= ?, ");
		buffer.append("S_ME_CI_Sourcecard= ? ");
		buffer.append(" WHERE S_ME_CI_Sourcecard= ? ");
		
		params.add(phone);
		params.add(cardId);
		params.add(oldCardId);
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	/**
	 * 删除会员信息
	 */
	public void deleteCustomerInfo(CustomerInfoPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
		buffer.append("DELETE FROM S_ME_CustomerInfo");
		buffer.append(" WHERE ");
		buffer.append("S_ME_CI_CustomerID= ? ");
		
		params.add(po.getSmecicustomerid());

		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 判断重复
	 * @param po
	 * @return
	 */
	public int getCount(CustomerInfoPo po) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select count(S_ME_CI_CustomerID) ");
	
		buffer.append("from S_ME_CustomerInfo ");	
		buffer.append("inner join F_MemberManagement on F_MemberManagement.F_MM_ID=S_ME_CustomerInfo.S_ME_CI_CardType ");
		
		buffer.append("where S_ME_CI_MemberId = ? ");
		
		params.add(po.getSmecimemberid());
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	public int getCount() {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("SELECT count(F_MM_ID) FROM F_MemberManagement WHERE F_MM_IsDefault = '1' ");	
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	/**
	 * 更新会员积分
	 */
	public void updateCustomerInfoIntegral(CustomerInfoPo po) {
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update S_ME_CustomerInfo set ");
		buffer.append("S_ME_CI_Integral= ? ");
		buffer.append(" WHERE ");	
		buffer.append("S_ME_CI_MemberId= ? ");
		
		params.add(po.getSmeciintegral());
		params.add(po.getSmecimemberid());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	/**
	 * 查询会员卡类型
	 */
	public List<MemberManagementPo> getMemberCardTypeList(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select F_MM_ID as fmmid,F_MM_MemberName as fmmmembername from F_MemberManagement order by cast(F_MM_IsDefault as float) desc ");

		return this.queryForObjectList(buffer.toString(), null,MemberManagementPo.class);
	}
	
	/**
	 * 查询顾客是否可以删除
	 * @param po
	 * @return
	 */
	public int selectCustomerInfoIsDelete(CustomerInfoPo po){
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("SELECT sum(custemercount) ");
		buffer.append("FROM   (SELECT COUNT(S_SE_SB_CustomerID) AS custemercount ");
		buffer.append("        FROM   uview_SalesBasic ");//销售
		buffer.append("        WHERE  S_SE_SB_CustomerID = ? ");
		buffer.append("        UNION ALL ");
		buffer.append("        SELECT COUNT(S_ME_CI_CustomerID) AS custemercount ");
		buffer.append("        FROM   S_ME_CustomerInfo ");//是否有子卡
		buffer.append("        WHERE  S_ME_CI_FCustomerId = ? ");
		buffer.append("        UNION ALL ");
		buffer.append("        SELECT COUNT(S_OP_OB_CustomerID) AS custemercount ");
		buffer.append("        FROM   S_OP_OptometryBasic ");//验光
		buffer.append("        WHERE  S_OP_OB_CustomerID = ? ");
		buffer.append("        UNION ALL ");
		buffer.append("        SELECT COUNT(S_OP_MD_FCustomerID) AS custemercount ");
		buffer.append("        FROM   S_OP_Mydriasis ");//散瞳
		buffer.append("        WHERE  S_OP_MD_FCustomerID = ? ");
		buffer.append("        UNION ALL ");
		buffer.append("        SELECT COUNT(S_OP_EC_CustomerID) AS custemercount ");
		buffer.append("        FROM   S_OP_EyesCheck ");//眼部健康检查
		buffer.append("        WHERE  S_OP_EC_CustomerID = ? ");
		buffer.append("        UNION ALL ");
		buffer.append("        SELECT COUNT(C_ST_CZK_CustomerID) AS custemercount ");
		buffer.append("        FROM   C_ST_Chuzhika ");//储值卡主表
		buffer.append("        WHERE  C_ST_CZK_CustomerID = ? ");
		buffer.append("        UNION ALL ");
		buffer.append("        SELECT COUNT(S_ME_AS_CustomerID) AS custemercount ");
		buffer.append("        FROM   S_ME_ChuAddandSub ");//储值卡记录
		buffer.append("        WHERE  S_ME_AS_CustomerID = ? ");
		buffer.append("        UNION ALL ");
		buffer.append("        SELECT COUNT(S_ME_AS_CustomerID) AS custemercount ");
		buffer.append("        FROM   S_ME_IntegralAddandSub ");//积分赠送明细表
		buffer.append("        WHERE  S_ME_AS_CustomerID = ? ");
		buffer.append("        UNION ALL ");
		buffer.append("        SELECT COUNT(*) AS custemercount ");
		buffer.append("        FROM   S_CR_RegisteredDetails ");
		buffer.append("        WHERE  S_CR_RD_CustomerID = ?)TEMP ");
		
		params.add(po.getSmecicustomerid());
		params.add(po.getSmecicustomerid());
		params.add(po.getSmecicustomerid());
		params.add(po.getSmecicustomerid());
		params.add(po.getSmecicustomerid());
		params.add(po.getSmecicustomerid());
		params.add(po.getSmecicustomerid());
		params.add(po.getSmecicustomerid());
		params.add(po.getSmecicustomerid());
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	/**
	 * 清空指定会员积分
	 */
	public void updateCustomerInfoAppointCredit(CustomerInfoPo po) {
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update S_ME_CustomerInfo set ");
		buffer.append("S_ME_CI_Integral = '0' ");
		buffer.append("WHERE ");	
		buffer.append("S_ME_CI_CustomerID = ? ");
		
		params.add(po.getSmecicustomerid());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	/**
	 * 清空所有会员积分
	 */
	public void updateCustomerInfoAllCredit() {
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update S_ME_CustomerInfo set ");
		buffer.append("S_ME_CI_Integral = '0' ");
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	/**
	 * 获取会员导出属性的总数
	 */
	public int getCustomerInfoForExport(){
		
		StringBuffer buffer=new StringBuffer();

		buffer.append("  select count(B_ME_ID) from B_MemberExport where B_ME_ExportFlag='1' ");
		
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	/**
	 * 获取会员导出属性的列表
	 */
	public List<MemberExportPo> getCustomerInfoForExportList(String flag){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select B_ME_ID as bmeid,B_ME_PropertyID as bmepropertyid,B_ME_PropertyName as bmepropertyname,B_ME_ExportFlag as bmeexportflag from B_MemberExport where 1=1 ");
        if (!"".equals(Utility.getName(flag))){
        	buffer.append(" and B_ME_ExportFlag = ? ");
        	params.add(Utility.getName(flag));
        }
        buffer.append(" order by B_ME_Order  ");	
		
		return this.queryForObjectList(buffer.toString(), params.toArray(),MemberExportPo.class);
	}
	
	/**
	 * 更新会员导出配置项
	 */
	public void updateCustomerExportInfoProperty(MemberExportPo po){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" update top (1) B_MemberExport set B_ME_ExportFlag = ? where B_ME_ID = ? ");

		params.add(Utility.getName(po.getBmeexportflag()));
		params.add(Utility.getName(po.getBmeid()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	public List<CustomerInfoPo> selectGXList(CustomerInfoPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select ");
		buffer.append("S_ME_CI_MemberId as smecimemberid, ");
		buffer.append("S_ME_CI_Name as smeciname ");
		buffer.append("from S_ME_CustomerInfo ");
		buffer.append("where S_ME_CustomerInfo.S_ME_CI_FCustomerId = ? ");
		
		params.add(po.getSmecicustomerid());
		
		return queryForObjectList(buffer.toString() , params.toArray() , CustomerInfoPo.class);
	}
	
	/**
	 * 会员启用停用
	 */
	public void updateCustomerEnable(CustomerInfoPo cpo){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" update top (1) S_ME_CustomerInfo set S_ME_CI_Flag = ? where S_ME_CI_CustomerID = ? ");

		params.add(Utility.getName(cpo.getSmeciflag()));
		params.add(Utility.getName(cpo.getSmecicustomerid()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	

	/**
	 * 查询会员信息
	 */
	public CustomerInfoPo getCustomerInfoByH() 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("SELECT top 1 ");
		buffer.append("S_ME_CI_CustomerID as smecicustomerid,");
		buffer.append("S_ME_CI_MemberId as smecimemberid");
		buffer.append(" FROM S_ME_CustomerInfo ");
		buffer.append("  where S_ME_CI_MemberId like 'H%' and len(S_ME_CI_MemberId) = 11  order by  S_ME_CI_MemberId desc");
		
		return (CustomerInfoPo) queryForObject(buffer.toString(), params.toArray(),
				CustomerInfoPo.class);
	}
	
	/**
	 * 查询所有会员积分（用于清除所有会员积分)
	 */
	public List<CustomerInfoPo> getCustomerInfo_Integral_List(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select S_ME_CI_CustomerID as smecicustomerid,S_ME_CI_MemberId as smecimemberid,S_ME_CI_Integral as smeciintegral from S_ME_CustomerInfo ");

		return this.queryForObjectList(buffer.toString(), null,CustomerInfoPo.class);
	}
	
	/**
	 * 只有待结款的单子才能调用
	 */
	public CustomerInfoPo getCustomerInfoNoFinished(CustomerInfoPo po) {

		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("SELECT top 1 ");		
		buffer.append("S_ME_CustomerInfo.S_ME_CI_CustomerID as smecicustomerid,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Name as smeciname,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_MemberId as smecimemberid,");	
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Sex as smecisex,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Phone as smeciphone,");
		buffer.append("case ");
		buffer.append("	when isnull(S_ME_CustomerInfo.S_ME_CI_FCustomerId,'') <> '' then c1.S_ME_CI_Integral  ");
		buffer.append(" when isnull(S_ME_CustomerInfo.S_ME_CI_FCustomerId,'') = ''  then isnull(S_ME_CustomerInfo.S_ME_CI_Integral,0) ");
		buffer.append("end as smeciintegral ");		
		buffer.append("FROM S_ME_CustomerInfo ");
		buffer.append("LEFT JOIN S_ME_CustomerInfo c1 ON c1.S_ME_CI_CustomerId = S_ME_CustomerInfo.S_ME_CI_FCustomerId "); 		
		buffer.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getSmecicustomerid()))){
			buffer.append("and S_ME_CustomerInfo.S_ME_CI_CustomerID = ? ");
			params.add(po.getSmecicustomerid());
		}
		if(!"".equals(Utility.getName(po.getSmecimemberid()))){
			buffer.append("and S_ME_CustomerInfo.S_ME_CI_MemberId = ? ");
			params.add(po.getSmecimemberid());
		}		
		
		if(!"".equals(Utility.getName(po.getSmeciflag()))){
			buffer.append(" and S_ME_CustomerInfo.S_ME_CI_Flag = ? ");
			params.add(po.getSmeciflag());
		}
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CustomerInfo.S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		return (CustomerInfoPo) queryForObject(buffer.toString(), params.toArray(),CustomerInfoPo.class);	
	}
	
	public CustomerInfoPo getCustomerInfo2(CustomerInfoPo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("SELECT top 1 S_ME_CI_CustomerID as smecicustomerid,S_ME_CI_Name as smeciname,S_ME_CI_Sex as smecisex,S_ME_CI_Integral as smeciintegral FROM S_ME_CustomerInfo ");
		buffer.append(" where S_ME_CI_CustomerID = ? ");
		
		params.add(Utility.getName(po.getSmecicustomerid()));
			
		return (CustomerInfoPo) queryForObject(buffer.toString(), params.toArray(),CustomerInfoPo.class);
	}
	
	public List<CustomerInfoPo> getWeixinCustomerInfoList(CustomerInfoPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();

		buffer.append("select S_ME_CI_CustomerID as smecicustomerid,");
		buffer.append("S_ME_CI_Name as smeciname,S_ME_CI_Sourcecard as smecisourcecard ");

		buffer.append(" from S_ME_CustomerInfo ");	
		
		buffer.append("  where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getSmecicustomerid()))){
			buffer.append("and S_ME_CI_CustomerID= ? ");
			params.add(po.getSmecicustomerid());
		}
		if(!"".equals(Utility.getName(po.getSmecisourcecard()))){
			buffer.append("and S_ME_CI_Sourcecard= ? ");
			params.add(po.getSmecisourcecard());
		}
		return queryForObjectList(buffer.toString() , params.toArray() , CustomerInfoPo.class);
	}
	
	/**
	 * 查询会员信息数量
	 */
	public int getCustomerInfoDownloadCount(CustomerInfoPo po) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select count(S_ME_CI_CustomerID) ");
		buffer.append(" from openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.S_ME_CustomerInfo) ");	
		buffer.append("  where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getIntegralmin())) && !"".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral >= ? ");
			buffer.append("and S_ME_CI_Integral <= ? ");
			params.add(po.getIntegralmin());
			params.add(po.getIntegralmax());
		} else if (!"".equals(Utility.getName(po.getIntegralmin()))&& "".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral >= ? ");
			params.add(po.getIntegralmin());
		} else if ("".equals(Utility.getName(po.getIntegralmin()))&& !"".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral <= ? ");
			params.add(po.getIntegralmax());
		}
		
		if(!"".equals(Utility.getName(po.getSmecishopcode()))){
			buffer.append("and S_ME_CI_ShopCode= ? ");
			params.add(po.getSmecishopcode());
		}

		if(!"".equals(Utility.getName(po.getSmeciopenid()))){
			if("1".equals(Utility.getName(po.getSmeciopenid()))){
				buffer.append("and isnull(S_ME_CI_OpenID,'') <> '' ");
			}
			if("0".equals(Utility.getName(po.getSmeciopenid()))){
				buffer.append("and isnull(S_ME_CI_OpenID,'') = '' ");
			}
		}
		if(!"".equals(Utility.getName(po.getSmecicustomerid()))){
			buffer.append("and S_ME_CI_CustomerID= ? ");
			params.add(po.getSmecicustomerid());
		}
		if(!"".equals(Utility.getName(po.getSmeciname()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(po.getSmeciname());
		}
		if(!"".equals(Utility.getName(po.getSmecisex()))){
			buffer.append("and S_ME_CI_Sex= ? ");
			params.add(po.getSmecisex());
		}
		if(!"".equals(Utility.getName(po.getSmeciphone()))){
			buffer.append("and (S_ME_CI_Phone like '%' + ? + '%' or S_ME_CI_Phone2 like '%' + ? + '%' or S_ME_CI_Phone3 like '%' + ? + '%')");
			params.add(po.getSmeciphone());
			params.add(po.getSmeciphone());
			params.add(po.getSmeciphone());
		}
		if(!"".equals(Utility.getName(po.getSmecimemberid()))){
			buffer.append("and S_ME_CI_MemberId like '%' + ? + '%' ");
			params.add(po.getSmecimemberid());
		}
		
		if(!"".equals(Utility.getName(po.getIsnullfcustomerid()))){//查询主卡字段为空的会员
			buffer.append("and isnull(S_ME_CI_FCustomerId,'')='' ");
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	/**
	 * 获取集团端顾客信息List
	 */
	public List<CustomerInfoPo> getCustomerInfoDownloadList(CustomerInfoPo po,
			int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from(select ROW_NUMBER() ");
		buffer.append("Over(order by S_ME_CI_RegisterDate desc) as rowNum,");
		buffer.append("S_ME_CI_CustomerID as smecicustomerid,");
		buffer.append("S_ME_CI_Name as smeciname,");
		buffer.append("S_ME_CI_Sex as smecisex,");
		buffer.append("S_ME_CI_Birthday as smecibirthday,");
		buffer.append("isnull(S_ME_CI_Flag,'1') as smeciflag, ");
		buffer.append("S_ME_CI_Phone as smeciphone,");
		buffer.append("S_ME_CI_MemberId as smecimemberid,");
		buffer.append("S_ME_CI_Integral as smeciintegral,");
		buffer.append("S_ME_CI_FCustomerId as smecifcustomerid ");
		buffer.append(" from openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.S_ME_CustomerInfo) ");	
	
		buffer.append("  where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getIntegralmin())) && !"".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral >= ? ");
			buffer.append("and S_ME_CI_Integral <= ? ");
			params.add(po.getIntegralmin());
			params.add(po.getIntegralmax());
		} else if (!"".equals(Utility.getName(po.getIntegralmin()))&& "".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral >= ? ");
			params.add(po.getIntegralmin());
		} else if ("".equals(Utility.getName(po.getIntegralmin()))&& !"".equals(Utility.getName(po.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral <= ? ");
			params.add(po.getIntegralmax());
		}
		if(!"".equals(Utility.getName(po.getSmecishopcode()))){
			buffer.append("and S_ME_CI_ShopCode= ? ");
			params.add(po.getSmecishopcode());
		}
		if(!"".equals(Utility.getName(po.getSmeciopenid()))){
			if("1".equals(Utility.getName(po.getSmeciopenid()))){
				buffer.append("and isnull(S_ME_CI_OpenID,'') <> '' ");
			}
			if("0".equals(Utility.getName(po.getSmeciopenid()))){
				buffer.append("and isnull(S_ME_CI_OpenID,'') = '' ");
			}
		}
		if(!"".equals(Utility.getName(po.getSmecicustomerid()))){
			buffer.append("and S_ME_CI_CustomerID= ? ");
			params.add(po.getSmecicustomerid());
		}
		if(!"".equals(Utility.getName(po.getSmeciname()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(po.getSmeciname());
		}
		if(!"".equals(Utility.getName(po.getSmecisex()))){
			buffer.append("and S_ME_CI_Sex= ? ");
			params.add(po.getSmecisex());
		}
		if(!"".equals(Utility.getName(po.getSmeciphone()))){
			buffer.append("and (S_ME_CI_Phone like '%' + ? + '%' or S_ME_CI_Phone2 like '%' + ? + '%' or S_ME_CI_Phone3 like '%' + ? + '%')");
			params.add(po.getSmeciphone());
			params.add(po.getSmeciphone());
			params.add(po.getSmeciphone());
		}
		if(!"".equals(Utility.getName(po.getSmecimemberid()))){
			buffer.append("and S_ME_CI_MemberId like '%' + ? + '%' ");
			params.add(po.getSmecimemberid());
		}
		if(!"".equals(Utility.getName(po.getSmeciagemin()))){
			buffer.append("and year(getdate())-year(S_ME_CI_Birthday) >= ? ");
			params.add(po.getSmeciagemin());
		}
		if(!"".equals(Utility.getName(po.getSmeciagemax()))){
			buffer.append("and year(getdate())-year(S_ME_CI_Birthday) <= ? ");
			params.add(po.getSmeciagemax());
		}
		
		if(!"".equals(Utility.getName(po.getIsnullfcustomerid()))){//查询主卡字段为空的会员
			buffer.append("and isnull(S_ME_CI_FCustomerId,'')='' ");
		}
		
		buffer.append(" ) temp where rowNum > "+start+" and rowNum <= "+ (start + size));
		buffer.append("set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , CustomerInfoPo.class);
	}
	
	/**
	 * 查询会员信息
	 */
	public CustomerInfoPo getCustomerInfoDownload(CustomerInfoPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("SELECT top 1 ");
		
		buffer.append("S_ME_CustomerInfo.S_ME_CI_CustomerID as smecicustomerid,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Name as smeciname,");
		buffer.append("year(getdate())-year(S_ME_CustomerInfo.S_ME_CI_Birthday) as fmmage,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Sex as smecisex,");
		buffer.append("convert(varchar(10),S_ME_CustomerInfo.S_ME_CI_Birthday,23) as smecibirthday,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Email as smeciemail,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Address as smeciaddress,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Zone as smecizone,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_PostCode as smecipostcode,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Phone as smeciphone,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_MemberId as smecimemberid,S_ME_CustomerInfo.S_ME_CI_CardType as smecicardtype,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_ShopCode as smecishopcode,S_ME_CustomerInfo.S_ME_CI_Remark as smeciremark,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_CustomerType as smecicustomertype,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_work as smeciwork,S_ME_CustomerInfo.S_ME_CI_IdentityCard as smeidentitycard,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_PersonType as smecipersontype,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_QqNumber as smeciqqnumber,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Interest as smeciinterest,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_MemberOrigin as smecimemberorigin, ");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_RegisterDate as smeciregisterdate,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_MemberPicPath as memberPicPath,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Phone2 as smeciphone2,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Phone3 as smeciphone3,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Sourcecard as smecisourcecard,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_ConsumptionNumber as smeciconsumptionnumber,");
		buffer.append("cast(isnull(S_ME_CustomerInfo.S_ME_CI_ConsumptionPrice,0) as numeric(18,2)) as smeciconsumptionprice, ");
		buffer.append("isnull(S_ME_CustomerInfo.S_ME_CI_FCustomerId,'') as smecifcustomerid, ");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_ModelworkersCode as smecimodelworkerscode, ");		
		buffer.append("isnull(S_ME_CustomerInfo.S_ME_CI_Area1,'') as smeciarea1, ");
		buffer.append("isnull(S_ME_CustomerInfo.S_ME_CI_Area2,'') as smeciarea2, ");
		buffer.append("isnull(S_ME_CustomerInfo.S_ME_CI_Area3,'') as smeciarea3, ");
		buffer.append("isnull(S_ME_CustomerInfo.S_ME_CI_Area4,'') as smeciarea4, ");
		buffer.append("isnull(S_ME_CustomerInfo.S_ME_CI_Area5,'') as smeciarea5, ");
		buffer.append("isnull(f1.F_A_Name,'') as smeciarea1name, ");
		buffer.append("isnull(f2.F_A_Name,'') as smeciarea2name, ");
		buffer.append("isnull(f3.F_A_Name,'') as smeciarea3name, ");
		buffer.append("isnull(f4.F_A_Name,'') as smeciarea4name, ");
		buffer.append("isnull(f5.F_A_Name,'') as smeciarea5name, ");		
		buffer.append("S_ME_CustomerInfo.S_ME_CI_TJRPhone as smecitjrphone ");
		buffer.append("FROM openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.S_ME_CustomerInfo) S_ME_CustomerInfo ");
		buffer.append("LEFT JOIN F_Area f1 ON f1.F_A_ID = S_ME_CustomerInfo.S_ME_CI_Area1 and f1.F_A_Level='1' ");
		buffer.append("LEFT JOIN F_Area f2 ON f2.F_A_ID = S_ME_CustomerInfo.S_ME_CI_Area2 and f2.F_A_Level='2' "); 
		buffer.append("LEFT JOIN F_Area f3 ON f3.F_A_ID = S_ME_CustomerInfo.S_ME_CI_Area3 and f3.F_A_Level='3' "); 
		buffer.append("LEFT JOIN F_Area f4 ON f4.F_A_ID = S_ME_CustomerInfo.S_ME_CI_Area4 and f4.F_A_Level='4' "); 
		buffer.append("LEFT JOIN F_Area f5 ON f5.F_A_ID = S_ME_CustomerInfo.S_ME_CI_Area5 and f5.F_A_Level='5' "); 
		
		buffer.append("where 1=1 ");
		
		buffer.append("and S_ME_CustomerInfo.S_ME_CI_MemberId = ? ");
		params.add(po.getSmecimemberid());
		
		return (CustomerInfoPo) queryForObject(buffer.toString(), params.toArray(),CustomerInfoPo.class);
	}
	
	/**
	 * 打开远程连接服务
	 * @param po
	 * @return
	 */
	public void openWork(){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("exec sp_configure 'show advanced options',1 ");
		sb.append("reconfigure ");
		sb.append("exec sp_configure 'Ad Hoc Distributed Queries',1 ");
		sb.append("reconfigure ");
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 关闭远程连接服务
	 * @param po
	 * @return
	 */
	public void closeWork(){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("exec sp_configure 'Ad Hoc Distributed Queries',0 ");
		sb.append("reconfigure ");
		sb.append("exec sp_configure 'show advanced options',0 ");
		sb.append("reconfigure ");
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}

	public int getCuInfo(CustomerInfoPo cpo) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select count(S_ME_CI_CustomerID) ");
	
		buffer.append("from S_ME_CustomerInfo ");	
		
		buffer.append("where S_ME_CI_CustomerID = ? ");
		
		params.add(cpo.getSmecicustomerid());
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	public void updteCustCard(CustomerInfoPo cpo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		buffer.append(" update  S_ME_CustomerInfo set S_ME_CI_MemberId = newid() where S_ME_CI_MemberId = ? ");

		params.add(Utility.getName(cpo.getSmecimemberid()));
	
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	public void updteCurCustCard(CustomerInfoPo cpo) {

		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" update  S_ME_CustomerInfo set S_ME_CI_MemberId = ?  where S_ME_CI_CustomerID = ? ");

		params.add(Utility.getName(cpo.getSmecimemberid()));
		params.add(Utility.getName(cpo.getSmecicustomerid()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	
		
	
}

    /**
     * HIS模块判断会员手机号是否重复
     */
	public CustomerInfoPo getCustPhoneInfo(CustomerInfoPo cpo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1 " +
				        " S_ME_CI_CustomerID   as smecicustomerid "
	 				   +" ,S_ME_CI_MemberId    as smecimemberid ");
	
		buffer.append(" from S_ME_CustomerInfo ");	
		
		buffer.append(" where S_ME_CI_Phone = ? ");
		
		params.add(cpo.getSmeciphone());
		
		return (CustomerInfoPo) queryForObject(buffer.toString(), params.toArray(),CustomerInfoPo.class);
	}
}