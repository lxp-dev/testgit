/**
 * 
 */
package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.AccSalesDao;
import com.pengsheng.eims.sales.dao.CardBillingDao;
import com.pengsheng.eims.sales.dao.ConSalesDao;
import com.pengsheng.eims.sales.dao.FrameSalesDao;
import com.pengsheng.eims.sales.persistence.CardPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.RechargeRecordPo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author Liuqian
 * 
 */
public class CardBillingDaoImpl extends BaseJdbcDaoSupport implements
		CardBillingDao {

	
	/*
	 * 获得非退费的启用特殊检查费用
	 */
	public List<RegisteredCategoryPo> getRcList(int start,int size) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from (select  ROW_NUMBER() Over(order by F_RC_orderType) as rownumber,");
		sb.append("F_RC_RegisteredName as  frcregisteredname,F_RC_Money as  frcmoney,F_RC_ID as  frcid from F_RegisteredCategory ");
		sb.append("where F_RC_FeeType=1 and F_RC_RegisteredType=2 and F_RC_Flag=1 ) temp ");
		sb.append(" where temp.rownumber > "+start+" and temp.rownumber <= "+countPage+" ");
		return getJdbcTemplate().queryForList(sb.toString());
	}
	
	public int getRcCount() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select ");
		sb.append("count(F_RC_RegisteredName)");
		sb.append(" from F_RegisteredCategory where F_RC_FeeType=1 and F_RC_RegisteredType=2 and F_RC_Flag=1");
		return getJdbcTemplate().queryForInt(sb.toString());
	}
	/*
	 * 获得对应角色下所属验光费。
	 */
	public List<RegisteredCategoryPo> getOpto(String agr0) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select ");
		sb.append("F_RC_RegisteredName as  frcregisteredname,");
		sb.append("F_RC_Money as  frcmoney,");
		sb.append("F_RC_ID as  frcid");
		sb.append(" from F_RegisteredCategory where F_RC_FeeType=1 and F_RC_RegisteredType=1 and F_RC_Flag=1 and F_RC_RegisteredName like '%'+?+'%' order by F_RC_orderType");
		List<String> params = new ArrayList<String>();
		params.add(agr0);
		return queryForObjectList(sb.toString(), params.toArray(), RegisteredCategoryPo.class);
	}
	/*
	 * 插入挂号明细
	 */
	public void insertRegisteredDetails(RegisteredDetailsPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("insert into S_CR_RegisteredDetails ");
		sb.append("select replace(newid(), '-', ''), ?, ?, ?, f_RC_id, ?, F_RC_Money, getdate(),?");
		if(po.getScrrdcasher()!=null){
			sb.append(",?, getdate()");
		}else{
			sb.append(",null, null");
		}
		sb.append(" from F_RegisteredCategory where f_RC_id = ? ");

		List<String> params = new ArrayList<String>();
		params.add(po.getScrrddetailsid());
		params.add(po.getScrrdcustomerid());
		params.add(po.getScrrdshopcode());
		params.add(po.getScrrdflag());
		params.add(po.getScrrdregister());
		if(po.getScrrdcasher()!=null){
			params.add(po.getScrrdcasher());
		}
		params.add(po.getScrrdregisterid());

		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	/*
	 * 获得挂号明细
	 */
	public List<RegisteredDetailsPo> getRcdList(String customerID) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT F_RC_ID as scrrdregisterid ");
		buffer.append(", F_RC_RegisteredName as scrrdregistername ");
		buffer.append(", S_CR_RD_ID as scrrdid ");
		buffer.append(", S_CR_RD_Money as scrrdmoney ");
		buffer.append("FROM F_RegisteredCategory ");
		buffer.append("INNER JOIN S_CR_RegisteredDetails ");
		buffer.append("ON F_RC_ID = S_CR_RD_RegisteredID ");
		buffer.append("where S_CR_RD_CustomerID = ? and S_CR_RD_Flag=0 and convert(varchar(10),S_CR_RD_OptDate,112)=convert(varchar(10),getdate(),112)");

		List<String> params = new ArrayList<String>();
		params.add(customerID);

		return this.queryForObjectList(buffer.toString(), params.toArray(),
				RegisteredDetailsPo.class);
	}
	
	public void insertRecord(RechargeRecordPo rechargeRecordPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("insert into S_SE_RechargeRecord values(");
		sb.append("?,?,?,?,?,?,?,getdate(),'-'+?)");
		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add("2");//消费明细标识位2代表验光划卡。
		params.add(rechargeRecordPo.getSserrsourceid());
		params.add(rechargeRecordPo.getSserrcardid());
		params.add(rechargeRecordPo.getSserrcustomerid());
		params.add(rechargeRecordPo.getSserrshopcode());
		params.add(rechargeRecordPo.getSserrcreateperson());
		params.add(rechargeRecordPo.getSserramount());
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public void updateAmount(CardPo cardPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("update S_SE_Card set S_SE_C_AvailableAmount =?,S_SE_C_Amount =? where S_SE_C_CardID=?");
		List<String> params = new ArrayList<String>();
		params.add(cardPo.getSsecavailableamount());
		params.add(cardPo.getSsecamount());
		params.add(cardPo.getSseccardid());
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public void updateRegistered(String registeredID,String casher,String uuid) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("update S_CR_RegisteredDetails set S_CR_RD_Flag=1,S_CR_RD_CasherDate=getdate(),S_CR_RD_Casher=?,S_CR_RD_DetailsID=? where S_CR_RD_ID=?");
		List<String> params = new ArrayList<String>();
		params.add(casher);
		params.add(uuid);
		params.add(registeredID);
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public RolePo getRole(String personID) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select top 1  rolename as rolename from SYS_PersonRoles ");
		sb.append("inner join SYS_Roles on  SYS_PersonRoles.roleID=SYS_Roles.roleID ");
		sb.append("where personid=?");
		List<String> params = new ArrayList<String>();
		params.add(personID);
		return (RolePo) queryForObject(sb.toString(), params.toArray(), RolePo.class);
	}


	public CardPo selCard(CardPo cardPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select top 1  s_se_c_cardid as  sseccardid,s_me_ci_customerid as sseccustomerid,s_me_ci_name as ssecname,s_se_c_availableamount as ssecavailableamount ");
		sb.append(",S_SE_C_Amount  as ssecamount FROM S_SE_Card  inner join S_ME_CustomerInfo ");
		sb.append("on S_ME_CustomerInfo.S_ME_CI_CustomerID=S_SE_Card.S_SE_C_CustomerID ");
		sb.append("where s_se_c_cardid=?");
		List<String> params = new ArrayList<String>();
		params.add(cardPo.getSseccardid());
		return (CardPo) queryForObject(sb.toString(), params.toArray(), CardPo.class);
	}
	

	
}