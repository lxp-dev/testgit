package com.pengsheng.weixin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.IntegralAddandSubPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinIntegralSelectDao;
import com.pengsheng.weixin.persistence.WeiXinIntegralSelectPo;

public class WeiXinIntegralSelectDaoImpl extends BaseJdbcDaoSupport implements WeiXinIntegralSelectDao {

	
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelectList(WeiXinIntegralSelectPo po, int start,int size) {

		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select * from ( ");
		sb.append("SELECT Row_number() OVER( ORDER BY W_IE_CreatDate DESC) AS rowNum,W_IE_ID as wieid, ");
		sb.append("       W_IE_CustomerID as wiecustomerid, ");
		sb.append("       S_ME_CI_Name as wiecustomername,");
		sb.append("       W_IE_OpenID as wieopenid, ");
		sb.append("       W_IE_CreatDate as wiecreatdate, ");
		sb.append("       W_IE_Flag as wieflag, ");
		sb.append("       W_IE_ExchangeDate as wieexchangedate, ");
		sb.append("       W_IE_PersonID as wiepersonid, ");
		sb.append("       personName as wiepersonname, ");
		sb.append("       W_IE_DepartmentID as wiedepartmentid, ");
		sb.append("       B_DP_DepartmentName as wiedepartmentname,");
		sb.append("       W_IE_GoodsID as wiegoodsid, ");
		sb.append("       W_IE_Integral as wieintegral, ");
		sb.append("       S_ME_CI_Phone as wiephone, ");
		sb.append("       B_GI_GoodsName as wiegoodname  ");
		sb.append("FROM   W_IntegralExchange ");
		sb.append("       LEFT JOIN dbo.S_ME_CustomerInfo ");
		sb.append("         ON S_ME_CI_CustomerID = W_IE_CustomerID ");
		sb.append("       LEFT JOIN dbo.SYS_PersonInfo ");
		sb.append("         ON ID = W_IE_PersonID ");
		sb.append("       LEFT JOIN dbo.B_Departments ");
		sb.append("         ON B_DP_DepartmentID = W_IE_DepartmentID ");
		sb.append("       LEFT JOIN dbo.B_GoodsInfo ");
		sb.append("         ON B_GI_GoodsID = W_IE_GoodsID where 1=1");
		if(po != null){
			if(!"".equals(Utility.getName(po.getWiecustomername()))){
				sb.append(" and S_ME_CI_Name like '%'+?+'%' ");
				params.add(po.getWiecustomername());
			}
			if(!"".equals(Utility.getName(po.getWieid()))){
				sb.append(" and W_IE_ID = ? ");
				params.add(po.getWieid());
			}
			if(!"".equals(Utility.getName(po.getWiephone()))){
				sb.append(" and S_ME_CI_Phone like '%'+?+'%' ");
				params.add(po.getWiephone());
			}
			if(!"".equals(Utility.getName(po.getWiedepartmentid()))){
				sb.append(" and W_IE_DepartmentID = ?  ");
				params.add(po.getWiedepartmentid());
			}
			if(!"".equals(Utility.getName(po.getWieflag()))){
				sb.append(" and W_IE_Flag = ?  ");
				params.add(po.getWieflag());
			}
			if(!"".equals(Utility.getName(po.getStartTime())) && !"".equals(Utility.getName(po.getEndTime()))){
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) >= ? ");
				params.add(po.getStartTime());
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) <= ? ");
				params.add(po.getEndTime());
			}else if(!"".equals(Utility.getName(po.getStartTime())) && "".equals(Utility.getName(po.getEndTime()))){
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) >= ? ");
				params.add(po.getStartTime());
				
			}else if("".equals(Utility.getName(po.getStartTime())) && !"".equals(Utility.getName(po.getEndTime()))){
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) <= ? ");
				params.add(po.getEndTime());
			}
			if(!"".equals(Utility.getName(po.getStartTimeGive())) && !"".equals(Utility.getName(po.getEndTimeGive()))){
				sb.append("and convert(varchar(10), W_IE_ExchangeDate, 23) >= ? ");
				params.add(po.getStartTimeGive());
				sb.append("and convert(varchar(10), W_IE_ExchangeDate, 23) <= ? ");
				params.add(po.getEndTimeGive());
			}else if(!"".equals(Utility.getName(po.getStartTimeGive())) && "".equals(Utility.getName(po.getEndTimeGive()))){
				sb.append("and convert(varchar(10), W_IE_ExchangeDate, 23) >= ? ");
				params.add(po.getStartTimeGive());
				
			}else if("".equals(Utility.getName(po.getStartTimeGive())) && !"".equals(Utility.getName(po.getEndTimeGive()))){
				sb.append("and convert(varchar(10), W_IE_ExchangeDate, 23) <= ? ");
				params.add(po.getEndTimeGive());
			}
		}
		sb.append("  ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), WeiXinIntegralSelectPo.class);
	}
	
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelectList(WeiXinIntegralSelectPo po) {

		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT W_IE_ID as wieid, ");
		sb.append("       W_IE_Flag as wieflag, ");
		sb.append("       W_IE_CreatDate as wiecreatdate, ");
		sb.append("       W_IE_PersonID as wiepersonid, ");
		sb.append("       W_IE_DepartmentID as wiedepartmentid, ");
		sb.append("       B_DP_DepartmentName as wiedepartmentname,");
		sb.append("       W_IE_GoodsID as wiegoodsid, ");
		sb.append("       W_IE_Integral as wieintegral ");

		sb.append("FROM   W_IntegralExchange ");
		sb.append("       LEFT JOIN dbo.B_Departments ");
		sb.append("         ON B_DP_DepartmentID = W_IE_DepartmentID ");
		
		sb.append(" where W_IE_CustomerID = ? order by W_IE_CreatDate desc");
		
		params.add(po.getWiecustomerid());
		
		return queryForObjectList(sb.toString(), params.toArray(), WeiXinIntegralSelectPo.class);
	}
	
	public int getWeiXinIntegralSelectCount(WeiXinIntegralSelectPo po) {
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT count(W_IE_ID) ");
		sb.append("FROM   W_IntegralExchange ");
		sb.append("       LEFT JOIN dbo.S_ME_CustomerInfo ");
		sb.append("         ON S_ME_CI_CustomerID = W_IE_CustomerID ");
		sb.append("       LEFT JOIN dbo.SYS_PersonInfo ");
		sb.append("         ON ID = W_IE_PersonID ");
		sb.append("       LEFT JOIN dbo.B_Departments ");
		sb.append("         ON B_DP_DepartmentID = W_IE_DepartmentID ");
		sb.append("       LEFT JOIN dbo.B_GoodsInfo ");
		sb.append("         ON B_GI_GoodsID = W_IE_GoodsID  where 1=1 ");
		if(po != null){
			if(!"".equals(Utility.getName(po.getWiecustomername()))){
				sb.append(" and S_ME_CI_Name like '%'+?+'%' ");
				params.add(po.getWiecustomername());
			}
			if(!"".equals(Utility.getName(po.getWieid()))){
				sb.append(" and W_IE_ID = ? ");
				params.add(po.getWieid());
			}
			if(!"".equals(Utility.getName(po.getWiephone()))){
				sb.append(" and S_ME_CI_Phone like '%'+?+'%' ");
				params.add(po.getWiephone());
			}
			if(!"".equals(Utility.getName(po.getWiedepartmentid()))){
				sb.append(" and W_IE_DepartmentID = ?  ");
				params.add(po.getWiedepartmentid());
			}
			if(!"".equals(Utility.getName(po.getWieflag()))){
				sb.append(" and W_IE_Flag = ?  ");
				params.add(po.getWieflag());
			}
			if(!"".equals(Utility.getName(po.getStartTime())) && !"".equals(Utility.getName(po.getEndTime()))){
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) >= ? ");
				params.add(po.getStartTime());
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) <= ? ");
				params.add(po.getEndTime());
			}else if(!"".equals(Utility.getName(po.getStartTime())) && "".equals(Utility.getName(po.getEndTime()))){
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) >= ? ");
				params.add(po.getStartTime());
				
			}else if("".equals(Utility.getName(po.getStartTime())) && !"".equals(Utility.getName(po.getEndTime()))){
				sb.append("and convert(varchar(10), W_IE_CreatDate, 23) <= ? ");
				params.add(po.getEndTime());
			}
			if(!"".equals(Utility.getName(po.getStartTimeGive())) && !"".equals(Utility.getName(po.getEndTimeGive()))){
				sb.append("and convert(varchar(10), W_IE_ExchangeDate, 23) >= ? ");
				params.add(po.getStartTimeGive());
				sb.append("and convert(varchar(10), W_IE_ExchangeDate, 23) <= ? ");
				params.add(po.getEndTimeGive());
			}else if(!"".equals(Utility.getName(po.getStartTimeGive())) && "".equals(Utility.getName(po.getEndTimeGive()))){
				sb.append("and convert(varchar(10), W_IE_ExchangeDate, 23) >= ? ");
				params.add(po.getStartTimeGive());
				
			}else if("".equals(Utility.getName(po.getStartTimeGive())) && !"".equals(Utility.getName(po.getEndTimeGive()))){
				sb.append("and convert(varchar(10), W_IE_ExchangeDate, 23) <= ? ");
				params.add(po.getEndTimeGive());
			}
		}
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 获取积分兑换顾客信息
	 * @param po
	 * @return
	 */
	public CustomerInfoPo selectCustomerInfoPo(CustomerInfoPo po) {

		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT S_ME_CI_CustomerID        AS smecicustomerid, ");
		sb.append("       S_ME_CI_Name              AS smeciname, ");
		sb.append("       S_ME_CI_Sex               AS smecisex, ");
		sb.append("       S_ME_CI_Birthday          AS smecibirthday, ");
		sb.append("       S_ME_CI_Email             AS smeciemail, ");
		sb.append("       S_ME_CI_Address           AS smeciaddress, ");
		sb.append("       S_ME_CI_Zone              AS smecizone, ");
		sb.append("       S_ME_CI_PostCode          AS smecipostcode, ");
		sb.append("       S_ME_CI_Phone             AS smeciphone, ");
		sb.append("       S_ME_CI_MemberId          AS smecimemberid, ");
		sb.append("       isnull(S_ME_CI_Integral,0) AS smeciintegral, ");
		sb.append("       S_ME_CI_CardType          AS smecicardtype, ");
		sb.append("       S_ME_CI_ShopCode          AS smecishopcode, ");
		sb.append("       S_ME_CI_RegisterDate      AS smeciregisterdate, ");
		sb.append("       S_ME_CI_Register          AS smeciregister, ");
		sb.append("       S_ME_CI_UpdateDate        AS smeciupdatedate, ");
		sb.append("       S_ME_CI_Updater           AS smeciupdater, ");
		sb.append("       S_ME_CI_CustomerType      AS smecicustomertype, ");
		sb.append("       S_ME_CI_work              AS smeciwork, ");
		sb.append("       S_ME_CI_QqNumber          AS smeciqqnumber, ");
		sb.append("       S_ME_CI_Interest          AS smeciinterest, ");
		sb.append("       S_ME_CI_MemberOrigin      AS smecimemberorigin, ");
		sb.append("       S_ME_CI_ConsumptionNumber AS smeciconsumptionnumber, ");
		sb.append("       S_ME_CI_ConsumptionPrice  AS smeciconsumptionprice, ");
		sb.append("       S_ME_CI_MemberPicPath     AS smecimemberpicpath, ");
		sb.append("       S_ME_CI_Phone2            AS smeciphone2, ");
		sb.append("       S_ME_CI_Phone3            AS smeciphone3, ");
		sb.append("       S_ME_CI_Sourcecard        AS smecisourcecard, ");
		sb.append("       S_ME_CI_IdentityCard      AS smeciidentitycard, ");
		sb.append("       S_ME_CI_PersonType        AS smecipersontype, ");
		sb.append("       S_ME_CI_OpenID            AS smeciopenid ");
		sb.append("FROM   S_ME_CustomerInfo ");
		sb.append("WHERE  S_ME_CI_OpenID = ? ");
		params.add(po.getSmeciopenid());
		
		return (CustomerInfoPo)queryForObject(sb.toString(), params.toArray(), CustomerInfoPo.class);
	}
	
	/**
	 * 获取积分兑换商品信息
	 * @param po
	 * @return
	 */
	public List<GoodsInfoPo> selectIntegralConvertGoodsList(GoodsInfoPo po) {

		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT F_IR_GoodsEasyName       	AS bgigoodsname, ");
		sb.append("       B_GI_GoodsID              AS bgigoodsid, ");
		sb.append("       F_IR_IntegralCount        AS bgiIntegralCount, ");
		sb.append("       isnull(F_IR_PicUrl,'')	AS bgipicurl, ");
		sb.append("       Row_number() OVER( ORDER BY B_GI_GoodsID) AS cstpeid ");
		sb.append("FROM   F_IntegralExchange ");
		sb.append("INNER JOIN B_GoodsInfo ON B_GI_GoodsID = F_IR_GoodsID ");
		sb.append("WHERE  F_IR_Flag = 1 ");
		
		return queryForObjectList(sb.toString(), params.toArray(), GoodsInfoPo.class);
	}
	
	/**
	 * 获取积分兑换商品信息
	 * @param po
	 * @return
	 */
	public GoodsInfoPo selectIntegralConvertGoods(GoodsInfoPo po){

		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT F_IR_GoodsEasyName        	AS bgigoodsname, ");
		sb.append("       B_GI_GoodsID              AS bgigoodsid, ");
		sb.append("       F_IR_IntegralCount        AS bgiIntegralCount, ");
		sb.append("       Row_number() OVER( ORDER BY B_GI_GoodsID) AS cstpeid ");
		sb.append("FROM   F_IntegralExchange ");
		sb.append("INNER JOIN B_GoodsInfo ON B_GI_GoodsID = F_IR_GoodsID ");
		sb.append("WHERE  F_IR_Flag = 1 and F_IR_GoodsID =?");
		
		params.add (po.getBgigoodsid());
		
		return (GoodsInfoPo) queryForObject(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}
	
	/**
	 * 增加积分兑换设置
	 * 
	 */
	public void insertWXIntegralExchangeSet(WeiXinIntegralSelectPo po){
		
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into W_IntegralExchange( ");
		sb.append("W_IE_ID, ");
		sb.append("W_IE_CustomerID, ");
		sb.append("W_IE_OpenID, ");
		sb.append("W_IE_CreatDate, ");
		sb.append("W_IE_Flag, ");
		sb.append("W_IE_GoodsID, ");
		sb.append("W_IE_Integral, ");
		sb.append("W_IE_DepartmentID, ");
		sb.append("W_IE_GoodsNumber) ");

		sb.append(" values (?,?,?,getdate(),?,?,?,?,?)         ");
		
		params.add (this.uuid.generate());
        params.add (Utility.getName(po.getWiecustomerid()));
        params.add (Utility.getName(po.getWieopenid()));
        params.add (Utility.getName(po.getWieflag()));
        params.add (Utility.getName(po.getWiegoodsid()));
        params.add (Utility.getName(po.getWieintegral()));
        params.add (Utility.getName(po.getWiedepartmentid()));
        params.add (Utility.getName(po.getWiegoodsnumber()));
        
        getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void insertLog(WeiXinIntegralSelectPo po){
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		varname1.append("INSERT INTO [dbo].[W_IntegralExchangeLog] ");
		varname1.append("            ([W_IL_UUID], ");
		varname1.append("             [W_IL_openID], ");
		varname1.append("             [W_IL_Datetime], ");
		varname1.append("             [W_IL_DepartmentID], ");
		varname1.append("             [W_IL_IntegralNum], ");
		varname1.append("             [W_IL_Flag], ");
		varname1.append("             [W_IL_GoodsId]) ");
		varname1.append("VALUES      (?, ");
		varname1.append("             ?, ");
		varname1.append("             Getdate(), ");
		varname1.append("             ?, ");
		varname1.append("             ?, ");
		varname1.append("             1, ");
		varname1.append("             ?) ");
		params.add (this.uuid.generate());
        params.add (Utility.getName(po.getWieopenid()));
        params.add (Utility.getName(po.getWiedepartmentid()));
        params.add (Utility.getName(po.getWiegoodsnumber()));
        params.add (Utility.getName(po.getWiegoodsid()));
        getJdbcTemplate().update(varname1.toString(),params.toArray());
	}
	/**
	 * 插入积分增减
	 * @param po
	 */
	public void insertIntegralAddandSubPo(IntegralAddandSubPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO S_ME_IntegralAddandSub ");
		buffer.append("            (S_ME_AS_UUID, ");
		buffer.append("             S_ME_AS_YIntegral, ");
		buffer.append("             S_ME_AS_CIntegral, ");
		buffer.append("             S_ME_AS_XIntegral, ");
		buffer.append("             S_ME_AS_DoDate, ");
		buffer.append("             S_ME_AS_Remark, ");
		buffer.append("             S_ME_AS_AddOrSub,S_ME_AS_CustomerID) ");
		buffer.append("VALUES      ( ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              getdate(), ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getSmeasyintegral()));
		if("".equals(Utility.getName(po.getSmeascintegral()))){
			params.add("0");
		}else{
			params.add(Utility.getName(po.getSmeascintegral()));
		}
		params.add(Utility.getName(po.getSmeasxintegral()));
		params.add(Utility.getName(po.getSmeasremark()));
		params.add(Utility.getName(po.getSmeasaddorsub()));
		params.add(Utility.getName(po.getSmeascustomerid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 更新会员积分
	 */
	public void updateCustomerInfoIntegral(CustomerInfoPo po) {
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update S_ME_CustomerInfo set ");
		buffer.append("S_ME_CI_Integral= ? ");
		buffer.append(" WHERE S_ME_CI_OpenID = ? ");
		
		params.add(po.getSmeciintegral());
		params.add(po.getSmeciopenid());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	public int  selectInGoodsNum(String openID,String goodsid){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("SELECT Isnull(SUM(W_IL_IntegralNum), 0)");
		buffer.append("FROM   dbo.W_IntegralExchangeLog ");
		buffer.append("WHERE  W_IL_openID = ? ");
		buffer.append("       AND W_IL_GoodsId = ?  ");
		params.add(openID);
		params.add(goodsid);
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	public int  selectDepIsClosed(String depID){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("SELECT B_DP_IsClosed ");
		buffer.append("FROM   dbo.B_Departments ");
		buffer.append("WHERE  B_DP_DepartmentID = ? ");
		params.add(depID);
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
}
