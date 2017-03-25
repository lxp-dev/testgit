package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.PutOptometryOrderDao;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class PutOptometryOrderDaoImpl extends BaseJdbcDaoSupport implements
		PutOptometryOrderDao {

	/**
	 * 根据配镜单号查询顾客信息
	 */
	public CustomerInfoPo getCustmorInfo(CustomerInfoPo customerInfoPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer
				.append("select top 1  S_ME_CI_Name as smeciname , S_ME_CI_Sex as smecisex , ");
		buffer
				.append("S_ME_CI_Birthday as smecibirthday , S_ME_CI_MemberId as smecimemberid , ");
		buffer.append("S_ME_CI_CustomerID as smecicustomerid ");
		buffer.append("from S_ME_CustomerInfo ");
		buffer
				.append("inner join S_SE_SalesBasic on S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("where 1=1 ");

		if (!"".equals(Utility.getName(customerInfoPo.getFmmsalesid()))) {
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(customerInfoPo.getFmmsalesid());
		}

		buffer.append("and S_SE_SB_ValueFlag = 1 ");
		
		if(customerInfoPo.getSmecishoplist() != null && customerInfoPo.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = customerInfoPo.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}

		return (CustomerInfoPo) queryForObject(buffer.toString(), params
				.toArray(), CustomerInfoPo.class);
	}
	
	public CustomerInfoPo getCustmorInfoFinished(CustomerInfoPo customerInfoPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer
				.append("select top 1  S_ME_CI_Name as smeciname , S_ME_CI_Sex as smecisex , ");
		buffer
				.append("S_ME_CI_Birthday as smecibirthday , S_ME_CI_MemberId as smecimemberid , ");
		buffer.append("S_ME_CI_CustomerID as smecicustomerid ");
		buffer.append("from S_ME_CustomerInfo ");
		buffer
				.append("inner join S_SE_SalesBasic_Finished on S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("where 1=1 ");

		if (!"".equals(Utility.getName(customerInfoPo.getFmmsalesid()))) {
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(customerInfoPo.getFmmsalesid());
		}

		buffer.append("and S_SE_SB_ValueFlag = 1 ");
		
		if(customerInfoPo.getSmecishoplist() != null && customerInfoPo.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = customerInfoPo.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}

		return (CustomerInfoPo) queryForObject(buffer.toString(), params
				.toArray(), CustomerInfoPo.class);
	}

	/**
	 * 得到打印配镜单数量
	 */
	public int getPutOptometryOrderCount(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select sum(count1) from (  ");
		buffer.append("select count(S_SE_SB_SalesID) as count1 ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join SYS_PersonInfo as s on s.ID = S_SE_SB_SalerID ");
		buffer.append("left join SYS_PersonInfo as p on p.ID = S_SE_SB_PosID ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CI_CustomerID = S_SE_SB_CustomerID ");		
		buffer.append("where 1=1 ");

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))) {
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcustomerid()))) {
			buffer.append("and S_ME_CI_CustomerID = ? ");
			params.add(salesBasicPo.getSsesbcustomerid());
		}
		buffer.append("and S_SE_SB_ValueFlag = '1' ");
		buffer.append(" union all ");
		buffer.append("select count(S_SE_SB_SalesID) as count1 ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("inner join SYS_PersonInfo as s on s.ID = S_SE_SB_SalerID ");
		buffer.append("left join SYS_PersonInfo as p on p.ID = S_SE_SB_PosID ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CI_CustomerID = S_SE_SB_CustomerID ");		
		buffer.append("where 1=1 ");

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))) {
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcustomerid()))) {
			buffer.append("and S_ME_CI_CustomerID = ? ");
			params.add(salesBasicPo.getSsesbcustomerid());
		}
		buffer.append("and S_SE_SB_ValueFlag = '1' ");		
		buffer.append(" )t ");

		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}

	/**
	 * 得到打印镜单信息
	 */
	public List<SalesBasicPo> selectPutOptometryOrder(
			SalesBasicPo salesBasicPo, int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by ssesbsalesdatetime desc) as rowNum,* from ( ");

		buffer
				.append("select S_SE_SB_SalesID as ssesbsalesid , S_SE_SB_PriceSum as ssesbpricesum , S_SE_SB_SalesDatetime as ssesbsalesdatetime, ");
		buffer
				.append("S_SE_SB_SalesValue as ssesbsalesvalue , S_SE_SB_ArrearsValue as ssesbarrearsvalue , ");
		buffer
				.append("S_SE_SB_SalerID as ssesbsalerid , s.personName as ssesbsalerName , ");
		buffer
				.append("S_SE_SB_PosID as ssesbposid , p.personName as ssesbposName , ");
		buffer.append("S_SE_SB_CheckoutFlag as ssesbcheckoutflag,s_se_sb_orderstype as ssesborderstype,isnull(S_SE_SB_WithdrawFlag,'') as ssesbwithdrawflag ");
		buffer.append("from S_SE_SalesBasic ");
		buffer
				.append("inner join SYS_PersonInfo as s on s.ID = S_SE_SB_SalerID ");
		buffer
				.append("left join SYS_PersonInfo as p on p.ID = S_SE_SB_PosID ");
		buffer
				.append("inner join S_ME_CustomerInfo on S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		
		buffer.append("where 1=1 ");

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))) {
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcustomerid()))) {
			buffer.append("and S_ME_CI_CustomerID = ? ");
			params.add(salesBasicPo.getSsesbcustomerid());
		}

		buffer.append("and S_SE_SB_ValueFlag = 1 ");
		buffer.append(" union all ");		
		buffer
				.append("select S_SE_SB_SalesID as ssesbsalesid , S_SE_SB_PriceSum as ssesbpricesum , S_SE_SB_SalesDatetime as ssesbsalesdatetime, ");
		buffer
				.append("S_SE_SB_SalesValue as ssesbsalesvalue , S_SE_SB_ArrearsValue as ssesbarrearsvalue , ");
		buffer
				.append("S_SE_SB_SalerID as ssesbsalerid , s.personName as ssesbsalerName , ");
		buffer
				.append("S_SE_SB_PosID as ssesbposid , p.personName as ssesbposName , ");
		buffer.append("S_SE_SB_CheckoutFlag as ssesbcheckoutflag,s_se_sb_orderstype as ssesborderstype,isnull(S_SE_SB_WithdrawFlag,'') as ssesbwithdrawflag ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer
				.append("inner join SYS_PersonInfo as s on s.ID = S_SE_SB_SalerID ");
		buffer
				.append("left join SYS_PersonInfo as p on p.ID = S_SE_SB_PosID ");
		buffer
				.append("inner join S_ME_CustomerInfo on S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		
		buffer.append("where 1=1 ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))) {
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcustomerid()))) {
			buffer.append("and S_ME_CI_CustomerID = ? ");
			params.add(salesBasicPo.getSsesbcustomerid());
		}
		
		buffer.append("and S_SE_SB_ValueFlag = 1 ");

		buffer.append(" ) temp ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(),
				SalesBasicPo.class);
	}

}
