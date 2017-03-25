package com.pengsheng.eims.quartz.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.pengsheng.eims.quartz.dao.DownloadJobDao;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Tools;

public class DownloadJobDaoImpl extends BaseJdbcDaoSupport implements DownloadJobDao{
	public static Properties oracleDriver= Tools.getProperty("/config/", "arjdbc.properties");	
	private static String ip = oracleDriver.getProperty("jdbc.ip");
	private static String user = oracleDriver.getProperty("jdbc.username");
	private static String pwd = oracleDriver.getProperty("jdbc.password");
	
	public void updateCostprice(){
		StringBuffer sb=new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("update  B_GoodsInfo set ");
		sb.append(" B_GoodsInfo.B_GI_CostPrice = JT.B_GI_CostPrice ");
		sb.append(",B_GoodsInfo.B_GI_NotTaxRate = JT.B_GI_NotTaxRate ");
		sb.append("from B_GoodsInfo JM ");
		sb.append("inner join openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.B_GoodsInfo) JT on JT.B_GI_GoodsID = JM.B_GI_GoodsID "); 
		sb.append("		and (isnull(JT.B_GI_CostPrice,0) <> isnull(JM.B_GI_CostPrice,0) or isnull(JT.B_GI_NotTaxRate,0)<>isnull(JM.B_GI_NotTaxRate,0)) ");
		
		sb.append("update  B_Brand set ");
		sb.append(" B_Brand.B_BD_PayFeeID = JT.B_BD_PayFeeID ");
		sb.append("from B_Brand JM ");
		sb.append("inner join openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.B_Brand) JT on JT.B_BD_ID = JM.B_BD_ID "); 
		sb.append("		and (isnull(JT.B_BD_PayFeeID,'') <> isnull(JM.B_BD_PayFeeID,'')) ");
		
		sb.append("update  B_GoodsInfo set ");
		sb.append("B_GoodsInfo.B_GI_PayFeeID = JT.B_GI_PayFeeID ");
		sb.append("from B_GoodsInfo JM ");
		sb.append("inner join openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.B_GoodsInfo) JT on JT.B_GI_GoodsID = JM.B_GI_GoodsID "); 
		sb.append("		and isnull(JT.B_GI_PayFeeID,'') <> isnull(JM.B_GI_PayFeeID,'') ");
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void uploadCustomerInfo(){
		StringBuffer sb=new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.S_ME_CustomerInfo) ( ");
		sb.append(" S_ME_CI_CustomerID             ");
		sb.append(",S_ME_CI_Name                   ");
		sb.append(",S_ME_CI_Sex                    ");
		sb.append(",S_ME_CI_Birthday               ");
		sb.append(",S_ME_CI_Email                  ");
		sb.append(",S_ME_CI_Address                ");
		sb.append(",S_ME_CI_Zone                   ");
		sb.append(",S_ME_CI_PostCode               ");
		sb.append(",S_ME_CI_Phone                  ");
		sb.append(",S_ME_CI_MemberId               ");
		sb.append(",S_ME_CI_Integral               ");
		sb.append(",S_ME_CI_CardType               ");
		sb.append(",S_ME_CI_ShopCode               ");
		sb.append(",S_ME_CI_RegisterDate           ");
		sb.append(",S_ME_CI_Register               ");
		sb.append(",S_ME_CI_UpdateDate             ");
		sb.append(",S_ME_CI_Updater                ");
		sb.append(",S_ME_CI_CustomerType           ");
		sb.append(",S_ME_CI_work                   ");
		sb.append(",S_ME_CI_QqNumber               ");
		sb.append(",S_ME_CI_Interest               ");
		sb.append(",S_ME_CI_MemberOrigin           ");
		sb.append(",S_ME_CI_ConsumptionNumber      ");
		sb.append(",S_ME_CI_ConsumptionPrice       ");
		sb.append(",S_ME_CI_MemberPicPath          ");
		sb.append(",S_ME_CI_Phone2                 ");
		sb.append(",S_ME_CI_Phone3                 ");
		sb.append(",S_ME_CI_Sourcecard             ");
		sb.append(",S_ME_CI_IdentityCard           ");
		sb.append(",S_ME_CI_PersonType             ");
		sb.append(",S_ME_CI_OpenID                 ");
		sb.append(",S_ME_CI_Remark                 ");
		sb.append(",S_ME_CI_FCustomerId            ");
		sb.append(",S_ME_CI_Flag                   ");
		sb.append(",S_ME_CI_CredentialsType        ");
		sb.append(",S_ME_CI_ModelworkersCode       ");
		sb.append(",S_ME_CI_Area1                  ");
		sb.append(",S_ME_CI_Area2                  ");
		sb.append(",S_ME_CI_Area3                  ");
		sb.append(",S_ME_CI_Area4                  ");
		sb.append(",S_ME_CI_Area5                  ");
		sb.append(",S_ME_CI_LevelUpDate            ");
		sb.append(",S_ME_CI_TJRPhone               ");
		sb.append(",S_ME_CI_School                 ");
		sb.append(",S_ME_CI_Class                  ");
		sb.append(",S_ME_CI_Grade                  ");
		sb.append(",S_ME_CI_RegionID               ");
		sb.append(") ");
		sb.append("select ");
		sb.append(" S_ME_CI_CustomerID             ");
		sb.append(",S_ME_CI_Name                   ");
		sb.append(",S_ME_CI_Sex                    ");
		sb.append(",S_ME_CI_Birthday               ");
		sb.append(",S_ME_CI_Email                  ");
		sb.append(",S_ME_CI_Address                ");
		sb.append(",S_ME_CI_Zone                   ");
		sb.append(",S_ME_CI_PostCode               ");
		sb.append(",S_ME_CI_Phone                  ");
		sb.append(",S_ME_CI_MemberId               ");
		sb.append(",S_ME_CI_Integral               ");
		sb.append(",S_ME_CI_CardType               ");
		sb.append(",S_ME_CI_ShopCode               ");
		sb.append(",S_ME_CI_RegisterDate           ");
		sb.append(",S_ME_CI_Register               ");
		sb.append(",S_ME_CI_UpdateDate             ");
		sb.append(",S_ME_CI_Updater                ");
		sb.append(",S_ME_CI_CustomerType           ");
		sb.append(",S_ME_CI_work                   ");
		sb.append(",S_ME_CI_QqNumber               ");
		sb.append(",S_ME_CI_Interest               ");
		sb.append(",S_ME_CI_MemberOrigin           ");
		sb.append(",S_ME_CI_ConsumptionNumber      ");
		sb.append(",S_ME_CI_ConsumptionPrice       ");
		sb.append(",S_ME_CI_MemberPicPath          ");
		sb.append(",S_ME_CI_Phone2                 ");
		sb.append(",S_ME_CI_Phone3                 ");
		sb.append(",S_ME_CI_Sourcecard             ");
		sb.append(",S_ME_CI_IdentityCard           ");
		sb.append(",S_ME_CI_PersonType             ");
		sb.append(",S_ME_CI_OpenID                 ");
		sb.append(",S_ME_CI_Remark                 ");
		sb.append(",S_ME_CI_FCustomerId            ");
		sb.append(",S_ME_CI_Flag                   ");
		sb.append(",S_ME_CI_CredentialsType        ");
		sb.append(",S_ME_CI_ModelworkersCode       ");
		sb.append(",S_ME_CI_Area1                  ");
		sb.append(",S_ME_CI_Area2                  ");
		sb.append(",S_ME_CI_Area3                  ");
		sb.append(",S_ME_CI_Area4                  ");
		sb.append(",S_ME_CI_Area5                  ");
		sb.append(",S_ME_CI_LevelUpDate            ");
		sb.append(",S_ME_CI_TJRPhone               ");
		sb.append(",S_ME_CI_School                 ");
		sb.append(",S_ME_CI_Class                  ");
		sb.append(",S_ME_CI_Grade                  ");
		sb.append(",(select top 1 J_R_ID from J_Region) ");
		sb.append("from S_ME_CustomerInfo ");
		sb.append("where isnull(S_ME_CI_IsUpload,'') <> '1' ");
		
		sb.append("update S_ME_CustomerInfo set ");
		sb.append("S_ME_CI_IsUpload = '1' ");
		sb.append("where isnull(S_ME_CI_IsUpload,'') <> '1' ");
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
}
