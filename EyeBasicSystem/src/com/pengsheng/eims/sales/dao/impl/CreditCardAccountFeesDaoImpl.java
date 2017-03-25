package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.CreditCardAccountFeesDao;
import com.pengsheng.eims.sales.persistence.CardPo;
import com.pengsheng.eims.sales.persistence.CardRecordPo;
import com.pengsheng.eims.sales.persistence.FeePo;
import com.pengsheng.eims.sales.persistence.RechargeRecordPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class CreditCardAccountFeesDaoImpl extends BaseJdbcDaoSupport implements
		CreditCardAccountFeesDao {

	/**
	 * 新增充值卡消费记录表信息
	 */
	public void insertRechargeRecord(RechargeRecordPo po) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into S_SE_RechargeRecord(");

		buffer.append("S_SE_RR_ID,");
		buffer.append("S_SE_RR_Flag,");
		buffer.append("S_SE_RR_SourceID,");
		buffer.append("S_SE_RR_CardID,");
		buffer.append("S_SE_RR_CustomerID,");
		buffer.append("S_SE_RR_ShopCode,");
		buffer.append("S_SE_RR_CreatePerson, ");
		buffer.append("S_SE_RR_Date, ");
		buffer.append("S_SE_RR_Amount )");
		buffer.append("values(?, ?, ?, ?, ?, ?, ?, getdate(), ? ) ");

		List<String> params = new ArrayList<String>();

		params.add(this.uuid.generate());
	    params.add(po.getSserrflag());
		params.add(po.getSserrsourceid());
		params.add(po.getSserrcardid());
		params.add(po.getSserrcustomerid());
		params.add(po.getSserrshopcode());
		params.add(po.getSserrcreateperson());
		// params.add(po.getSserrdate());
		params.add(po.getSserramount());

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}

	/**
	 * 修改检查充值卡信息
	 */
	public void updateCard(CardPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("update S_SE_Card set S_SE_C_Amount=?,S_SE_C_AvailableAmount=? ");
		sb.append("where  S_SE_C_CustomerID = ? ");

		List<String> params = new ArrayList<String>();

		params.add(po.getSsecamount());
		params.add(po.getSsecavailableamount());
		params.add(po.getSseccustomerid());

		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	/**
	 * 新增顾客信息
	 */
	public void insertCustomerInfo(CustomerInfoPo po) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into S_ME_CustomerInfo ( ");

		buffer.append(" S_ME_CI_CustomerID ,");
		buffer.append(" S_ME_CI_Name ,");
		buffer.append(" S_ME_CI_Sex ,");
		buffer.append(" S_ME_CI_Birthday ,");
		buffer.append(" S_ME_CI_Email ,");
		buffer.append(" S_ME_CI_Address ,");
		buffer.append(" S_ME_CI_Zone ,");
		buffer.append(" S_ME_CI_PostCode ,");
		buffer.append(" S_ME_CI_Phone ,");
		buffer.append(" S_ME_CI_MemberId ,");
		buffer.append(" S_ME_CI_CardType ,");
		buffer.append(" S_ME_CI_ShopCode ,");
		buffer.append(" S_ME_CI_Integral )");
		buffer.append("values(?,?,?,?,?,?,?,?,?,?,?,?,?)");

		String uuid = this.uuid.generate();
		po.setSmecicustomerid(this.uuid.generate());

		params.add(po.getSmecicustomerid());
		params.add(po.getSmeciname());
		params.add(po.getSmecisex());
		params.add(po.getSmecibirthday());
		params.add(po.getSmeciemail());
		params.add(po.getSmeciaddress());
		params.add(po.getSmecizone());
		params.add(po.getSmecipostcode());
		params.add(po.getSmeciphone());
		params.add(po.getSmecimemberid());
		params.add(po.getSmecicardtype());
		params.add(po.getSmecishopcode());
		params.add(po.getSmeciintegral());

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}

	/**
	 * 检查充值卡清零信息
	 */
	public void updateCardClear(CardPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("delete  from S_SE_Card where S_SE_C_CardID = ? ");

		List<String> params = new ArrayList<String>();

		// params.add(po.getSmeciamount());
		params.add(po.getSseccardid());

		getJdbcTemplate().update(sb.toString(), params.toArray());

	}

	/**
	 * 新增检查充值卡信息
	 */
	public void insertCard(CardPo po) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into S_SE_Card( ");

		buffer.append("S_SE_C_ID,");
		buffer.append("S_SE_C_CustomerID,");
		buffer.append("S_SE_C_CardID,");
		buffer.append("S_SE_C_Amount,");
		buffer.append("S_SE_C_AvailableAmount )");

		buffer.append("values(?, ?, ?, ?, ? ) ");

		List<String> params = new ArrayList<String>();

		params.add(this.uuid.generate());
		params.add(po.getSseccustomerid());
		params.add(po.getSseccardid());
		params.add(po.getSsecamount());
		params.add(po.getSsecavailableamount());

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}

	/**
	 * 查询检查充值卡号数量
	 */
	public int getCardCount(String cardid) {

		StringBuffer buffer = new StringBuffer();

		buffer.append("SELECT count(S_SE_C_CardID) ");
		buffer.append("FROM S_SE_Card ");
		buffer.append("WHERE S_SE_C_CardID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(cardid);

		return getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());

	}

	/**
	 * 查询检查充值卡充值
	 */
	public CardPo getCard(CardPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("SELECT top 1 ");
		buffer.append("S_SE_C_ID as ssecid,");
		buffer.append("S_ME_CI_Name as ssecname,");
		buffer.append("S_SE_C_CustomerID as sseccustomerid,");
		buffer.append("S_SE_C_CardID as sseccardid,");
		buffer.append("S_SE_C_Amount as ssecamount,");
		buffer.append("S_SE_C_AvailableAmount as ssecavailableamount ");

		buffer.append(" FROM S_SE_Card ");
		buffer.append(" inner join S_ME_CustomerInfo on S_SE_Card.S_SE_C_CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");

		buffer.append("where 1=1  ");
		if (!"".equals(Utility.getName(po.getSseccustomerid()))) {
			buffer.append("and S_SE_C_CustomerID = ? ");
			params.add(po.getSseccustomerid());
		}
		if (!"".equals(Utility.getName(po.getSseccardid()))) {
			buffer.append("and S_SE_C_CardID = ? ");
			params.add(po.getSseccardid());
		}

		return (CardPo) queryForObject(buffer.toString(), params.toArray(), CardPo.class);
	}

	/**
	 * 查询补卡顾客基本资料
	 */
	public CustomerInfoPo selectCustomerInfo(CustomerInfoPo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("SELECT top 1 ");
		
		buffer.append("S_ME_CI_CustomerID as smecicustomerid ,");
		buffer.append("S_ME_CI_Name as smeciname ,");
		buffer.append("S_ME_CI_Phone as smeciphone ,");
		buffer.append("S_ME_CI_MemberId as smecimemberid ,");
		buffer.append("S_SE_C_CardID as smecicardid ,");
		buffer.append("S_SE_C_Amount as smeciamount ,");
		buffer.append("S_SE_C_AvailableAmount as smeciavailableamount ");
		
		buffer.append(" FROM S_ME_CustomerInfo ");
		buffer.append("inner join  S_SE_Card on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_Card.S_SE_C_CustomerID ");
		
		buffer.append("  where 1=1 ");
		if(!"".equals(Utility.getName(po.getSmecicustomerid()))){
			buffer.append("and S_ME_CI_CustomerID = ? ");
			params.add(po.getSmecicustomerid());
		}
		if(!"".equals(Utility.getName(po.getSmecimemberid()))){
			buffer.append("and S_ME_CI_MemberId = ? ");
			params.add(po.getSmecimemberid());
		}		
		
		return (CustomerInfoPo) queryForObject(buffer.toString(), params.toArray(),
				CustomerInfoPo.class);
	}

	/**
	 * 新增补卡，补卡记录表信息
	 */
	public void insertCardRecordUpCard(CardRecordPo cardRecordPo) {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into S_SE_CardRecord( ");

		buffer.append("S_SE_CR_ID,");
		buffer.append("S_SE_CR_OldCardID,");
		buffer.append("S_SE_CR_CardID,");
		buffer.append("S_SE_CR_CustomerID,");
		buffer.append("S_SE_CR_Amount,");
		buffer.append("S_SE_CR_IdCard, ");
		buffer.append("S_SE_CR_Date, ");
		buffer.append("S_SE_CR_CreatePersonID )");
		buffer.append("values(?, ?, ?, ?, ?, ?, getdate(), ? ) ");

		List<String> params = new ArrayList<String>();

		params.add(this.uuid.generate());
		params.add(cardRecordPo.getSsecroldcardid());
		params.add(cardRecordPo.getSsecrcardid());
		params.add(cardRecordPo.getSsecrcustomerid());
		params.add(cardRecordPo.getSsecramount());
		params.add(cardRecordPo.getSsecridcard());
		// params.add(po.getSserrdate());
		params.add(cardRecordPo.getSsecrcreatePersonid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());

		
	}

	
	
	/**
	 * 新增补卡，充值卡消费表信息--新增退费清零信息
	 */
	public void insertRechargeRecordUpCardClear(RechargeRecordPo rechargeRecordPo) {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into S_SE_RechargeRecord(");

		buffer.append("S_SE_RR_ID,");
		buffer.append("S_SE_RR_Flag,");
		buffer.append("S_SE_RR_SourceID,");
		buffer.append("S_SE_RR_CardID,");
		buffer.append("S_SE_RR_CustomerID,");
		buffer.append("S_SE_RR_ShopCode,");
		buffer.append("S_SE_RR_CreatePerson, ");
		buffer.append("S_SE_RR_Date, ");
		buffer.append("S_SE_RR_Amount )");
		buffer.append("values(?, '4', ?, ?, ?, ?, ?, getdate(), ? ) ");

		List<String> params = new ArrayList<String>();

		params.add(this.uuid.generate());
		// params.add(po.getSserrflag());
		params.add(rechargeRecordPo.getSserrsourceid());
		params.add(rechargeRecordPo.getSserrcardid());
		params.add(rechargeRecordPo.getSserrcustomerid());
		params.add(rechargeRecordPo.getSserrshopcode());
		params.add(rechargeRecordPo.getSserrcreateperson());
		// params.add(po.getSserrdate());
		params.add(rechargeRecordPo.getSserramount());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	/**
	 * 新增补卡，充值卡消费表信息--新增充值信息
	 */
	public void insertRechargeRecordUpCardInsert(RechargeRecordPo rechargeRecordPo) {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into S_SE_RechargeRecord(");
		
		buffer.append("S_SE_RR_ID,");
		buffer.append("S_SE_RR_Flag,");
		buffer.append("S_SE_RR_SourceID,");
		buffer.append("S_SE_RR_CardID,");
		buffer.append("S_SE_RR_CustomerID,");
		buffer.append("S_SE_RR_ShopCode,");
		buffer.append("S_SE_RR_CreatePerson, ");
		buffer.append("S_SE_RR_Date, ");
		buffer.append("S_SE_RR_Amount )");
		buffer.append("values(?, '1', ?, ?, ?, ?, ?, getdate(), ? ) ");
		
		List<String> params = new ArrayList<String>();
		
		params.add(this.uuid.generate());
		// params.add(po.getSserrflag());
		params.add(rechargeRecordPo.getSserrsourceid());
		params.add(rechargeRecordPo.getSserrcardid());
		params.add(rechargeRecordPo.getSserrcustomerid());
		params.add(rechargeRecordPo.getSserrshopcode());
		params.add(rechargeRecordPo.getSserrcreateperson());
		// params.add(po.getSserrdate());
		params.add(rechargeRecordPo.getSserramount());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	/**
	 * 新增补卡，充值卡消费表信息--新增工本费信息
	 */
	public void insertRechargeRecordUpCardFee(RechargeRecordPo rechargeRecordPo) {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into S_SE_RechargeRecord(");
		
		buffer.append("S_SE_RR_ID,");
		buffer.append("S_SE_RR_Flag,");
		buffer.append("S_SE_RR_SourceID,");
		buffer.append("S_SE_RR_CardID,");
		buffer.append("S_SE_RR_CustomerID,");
		buffer.append("S_SE_RR_ShopCode,");
		buffer.append("S_SE_RR_CreatePerson, ");
		buffer.append("S_SE_RR_Date, ");
		buffer.append("S_SE_RR_Amount )");
		buffer.append("values(?, '5', ?, ?, ?, ?, ?, getdate(), ? ) ");
		
		List<String> params = new ArrayList<String>();
		
		params.add(this.uuid.generate());
		// params.add(po.getSserrflag());
		params.add(rechargeRecordPo.getSserrsourceid());
		params.add(rechargeRecordPo.getSserrcardid());
		params.add(rechargeRecordPo.getSserrcustomerid());
		params.add(rechargeRecordPo.getSserrshopcode());
		params.add(rechargeRecordPo.getSserrcreateperson());
		// params.add(po.getSserrdate());
		params.add(rechargeRecordPo.getSserramount());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 修改检查充值卡里的信息
	 */
	public void updateCardUpCard(CardPo cardPo) {

		StringBuffer sb = new StringBuffer();
		sb.append("update S_SE_Card set S_SE_C_CardID= ? ,");
		sb.append("S_SE_C_Amount=? ,");
		sb.append("S_SE_C_AvailableAmount=? ");
		sb.append("where  S_SE_C_CustomerID = ? ");

		List<String> params = new ArrayList<String>();

		params.add(cardPo.getSseccardid());
		params.add(cardPo.getSsecamount());
		params.add(cardPo.getSsecavailableamount());
		params.add(cardPo.getSseccustomerid());

		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	/**
	 * 新建检查充值卡--查询新建检查充值卡顾客基本资料
	 */
	public CustomerInfoPo selectCustomerInfoNew(CustomerInfoPo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("SELECT top 1 ");
		
		buffer.append("S_ME_CI_CustomerID as smecicustomerid ,");
		buffer.append("S_ME_CI_Name as smeciname ,");
		buffer.append("S_ME_CI_MemberId as smecimemberid ,");
		buffer.append("S_ME_CI_Sex as smecisex ,");
		buffer.append("S_ME_CI_Phone as smeciphone ");
		buffer.append(" FROM S_ME_CustomerInfo ");
		buffer.append("  where 1=1 ");
		if(!"".equals(Utility.getName(po.getSmecicustomerid()))){
			buffer.append("and S_ME_CI_CustomerID = ? ");
			params.add(po.getSmecicustomerid());
		}
		if(!"".equals(Utility.getName(po.getSmecimemberid()))){
			buffer.append("and S_ME_CI_MemberId = ? ");
			params.add(po.getSmecimemberid());
		}		
		
		return (CustomerInfoPo) queryForObject(buffer.toString(), params.toArray(),
				CustomerInfoPo.class);
	}

	/**
	 * 新建检查充值卡--新增检查充值卡信息
	 */
	public void insertCardNewInsert(CardPo po) {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into S_SE_Card( ");

		buffer.append("S_SE_C_ID,");
		buffer.append("S_SE_C_CustomerID,");
		buffer.append("S_SE_C_CardID,");
		buffer.append("S_SE_C_Amount,");
		buffer.append("S_SE_C_AvailableAmount )");

		buffer.append("values(?, ?, ?, ?, ? ) ");

		List<String> params = new ArrayList<String>();

		params.add(this.uuid.generate());
		params.add(po.getSseccustomerid());
		params.add(po.getSseccardid());
		params.add(po.getSsecamount());
		params.add(po.getSsecavailableamount());

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}

	/**
	 * 新建检查充值卡--新增充值卡消费表信息
	 */
	public void insertRechargeRecordNewInsert(RechargeRecordPo rechargeRecordPo) {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into S_SE_RechargeRecord(");
		
		buffer.append("S_SE_RR_ID,");
		buffer.append("S_SE_RR_Flag,");
		buffer.append("S_SE_RR_SourceID,");
		buffer.append("S_SE_RR_CardID,");
		buffer.append("S_SE_RR_CustomerID,");
		buffer.append("S_SE_RR_ShopCode,");
		buffer.append("S_SE_RR_CreatePerson, ");
		buffer.append("S_SE_RR_Date, ");
		buffer.append("S_SE_RR_Amount )");
		buffer.append("values(?, '1', ?, ?, ?, ?, ?, getdate(), ? ) ");
		
		List<String> params = new ArrayList<String>();
		
		params.add(this.uuid.generate());
		// params.add(po.getSserrflag());
		params.add(rechargeRecordPo.getSserrsourceid());
		params.add(rechargeRecordPo.getSserrcardid());
		params.add(rechargeRecordPo.getSserrcustomerid());
		params.add(rechargeRecordPo.getSserrshopcode());
		params.add(rechargeRecordPo.getSserrcreateperson());
		// params.add(po.getSserrdate());
		params.add(rechargeRecordPo.getSserramount());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 新建检查充值卡--查询新建检查充值卡号数量
	 */
	public int getCardNewCount(String memberid) {
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("select COUNT(S_SE_C_ID) from S_SE_Card ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CI_CustomerID=S_SE_C_CustomerID ");
		buffer.append("where S_ME_CI_MemberId= ? ");

		List<String> params = new ArrayList<String>();
		params.add(memberid);

		return getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());

	}

	/**
	 * 提取工本费
	 */
	public FeePo getFee() {
		
		
		StringBuffer buffer = new StringBuffer();
        
		buffer.append("select top 1  s_se_f_fee as sseffee from S_SE_Fee");
		
		return (FeePo) queryForObject(buffer.toString(), null,
				FeePo.class);
	}
}
