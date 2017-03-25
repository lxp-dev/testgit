package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.storage.dao.AdjustmentPriceDao;
import com.pengsheng.eims.storage.persistence.AdjustmentPriceEntryPo;
import com.pengsheng.eims.storage.persistence.AdjustmentPricePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class AdjustmentPriceDaoImpl extends BaseJdbcDaoSupport implements
		AdjustmentPriceDao {

	
	public void adjustmentPriceDelete(AdjustmentPricePo adjustmentPricePo) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("delete from C_PR_AdjustmentPrice ");
		List<String> params = new ArrayList<String>();
		if (!"".equals(adjustmentPricePo.getCprapbillid())) {
			sb.append("where C_PR_AP_billID=?");
			params.add(adjustmentPricePo.getCprapbillid());
		}

		getJdbcTemplate().update(sb.toString(), params.toArray());

	}

	
	public void adjustmentPriceInsert(AdjustmentPricePo adjustmentPricePo) {
		
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb1.append("INSERT INTO C_PR_ADJUSTMENTPRICE(C_PR_AP_billID");
		if (!Utility.getName(adjustmentPricePo.getCprapeffectivedate()).equals("")) {
			sb1.append(",C_PR_AP_effectiveDate");
		}		
		sb1.append(",C_PR_AP_createPerson");
		sb1.append(",C_PR_AP_createDate");
		sb1.append(",C_PR_AP_AuditState");
		sb1.append(",C_PR_AP_effectiveState");
		sb1.append(",C_PR_AP_Flag");
		sb1.append(",C_PR_AP_SupplierID");
		sb1.append(",C_PR_AP_BrandID");
		if (!Utility.getName(adjustmentPricePo.getCprapeffectivedate()).equals("")) {
			sb2.append(" VALUES(?,?,?,getdate(),?,?,?,?,?");
		}else{
			sb2.append(" VALUES(?,?,getdate(),?,?,?,?,?");
		}
		
		params.add(adjustmentPricePo.getCprapbillid());		
		if (!Utility.getName(adjustmentPricePo.getCprapeffectivedate()).equals("")) {
			params.add(Utility.getName(adjustmentPricePo.getCprapeffectivedate()));
		}
		params.add(adjustmentPricePo.getCprapcreateperson());	
		params.add(adjustmentPricePo.getCprapauditstate());	
		
		params.add(Utility.getName(adjustmentPricePo.getCprapeffectiveState()));
		params.add(adjustmentPricePo.getCprapflag());
		params.add(Utility.getName(adjustmentPricePo.getCprapsupplierid()));
		params.add(Utility.getName(adjustmentPricePo.getCprapbrandid()));
		if ("1".equals(adjustmentPricePo.getCprapauditstate())) {
			sb1.append(",C_PR_AP_AuditPerson");
			sb1.append(",C_PR_AP_AuditDate");
			sb2.append(",?");
			sb2.append(",getdate()");
			params.add(adjustmentPricePo.getCprapauditperson());
		}
		if (adjustmentPricePo.getCprapremark() != null) {
			sb1.append(",C_PR_AP_remark");
			sb2.append(",?");
			params.add(adjustmentPricePo.getCprapremark());
		}
		sb1.append(",C_PR_AP_WhichPrice ");
		sb2.append(",?");
		params.add(adjustmentPricePo.getCprapwhichprice());
		
		getJdbcTemplate().update(sb1.toString() + ")" + sb2.toString() + ")",params.toArray());

	}

	
	public void adjustmentPriceUpdate(AdjustmentPricePo adjustmentPricePo) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("UPDATE C_PR_AdjustmentPrice");
		sb.append(" SET ");
		sb.append(" C_PR_AP_Flag = ?");		
		sb.append(",C_PR_AP_remark = ?");
		sb.append(",C_PR_AP_SupplierID = ?");		
		sb.append(",C_PR_AP_BrandID = ?");
		params.add(adjustmentPricePo.getCprapflag());		
		params.add(adjustmentPricePo.getCprapremark());
		params.add(Utility.getName(adjustmentPricePo.getCprapsupplierid()));		
		params.add(Utility.getName(adjustmentPricePo.getCprapbrandid()));
		if (!Utility.getName(adjustmentPricePo.getCprapeffectivedate()).equals("")) {
			sb.append(" ,C_PR_AP_effectiveDate = ?");
			params.add(adjustmentPricePo.getCprapeffectivedate());
		}else{
			sb.append(" ,C_PR_AP_effectiveDate = NULL ");
		}
		if("1".equals(adjustmentPricePo.getCprapauditstate())){
			sb.append(" ,C_PR_AP_AuditPerson = ?");
			sb.append(" ,C_PR_AP_AuditDate = getdate()");
			sb.append(",C_PR_AP_AuditState = ?");
			sb.append(",C_PR_AP_effectiveState = ? ");
			
			params.add(adjustmentPricePo.getCprapauditperson());		
			params.add("1");
			params.add(adjustmentPricePo.getCprapeffectiveState());
		}
		
		sb.append(",C_PR_AP_WhichPrice = ? ");
		params.add(adjustmentPricePo.getCprapwhichprice());
		
		sb.append(" where C_PR_AP_billID=?");
		params.add(adjustmentPricePo.getCprapbillid());
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}

	
	public void adjustmentPriceEntryInsert(
			AdjustmentPriceEntryPo adjustmentPriceEntryPo) {
		
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb1.append("INSERT INTO C_PR_AdjustmentPriceEntry(C_PR_APE_ID");
		sb1.append(",C_PR_APE_billID");
		sb1.append(",C_PR_APE_goodsID");
		sb1.append(",C_PR_APE_barCode");
		sb1.append(",C_PR_APE_goodsName");
		sb1.append(",C_PR_APE_costPrice");
		sb1.append(",C_PR_APE_AdPrice");
		params.add(this.uuid.generate());
		params.add(adjustmentPriceEntryPo.getCprapebillid());
		params.add(adjustmentPriceEntryPo.getCprapegoodsid());
		params.add(adjustmentPriceEntryPo.getCprapegoodsbarcode());
		params.add(adjustmentPriceEntryPo.getCprapegoodsname());
		if("".equals(Utility.getName(adjustmentPriceEntryPo.getCprapecostprice()))){
			sb2.append("VALUES(?,?,?,?,?,null,?");
		}else{
			sb2.append("VALUES(?,?,?,?,?,?,?");
			params.add(adjustmentPriceEntryPo.getCprapecostprice());
		}
		params.add(adjustmentPriceEntryPo.getCprapeadprice());
		getJdbcTemplate().update(sb1.toString() + ")" + sb2.toString() + ")",
				params.toArray());
	}

	
	public int getAdjuestmentPriceCount(AdjustmentPricePo adjustmentPricePo) {
		StringBuffer sb = new StringBuffer();
		
		//TODO add by ZK query for goodsName begin
		sb.append(" SELECT COUNT(C_PR_AP_billID) FROM ( ");		
		sb.append(" select C_PR_AdjustmentPrice.C_PR_AP_billID from C_PR_AdjustmentPrice ");
		sb.append(" INNER JOIN C_PR_AdjustmentPriceEntry ON C_PR_AdjustmentPriceEntry.C_PR_APE_billID = C_PR_AP_billID ");
		sb.append(" where 1=1 ");
		List<String> params = new ArrayList<String>();
		
		//TODO add by ZK query for goodsName begin
		if(!"".equals(adjustmentPricePo.getGoodsName())) {
			sb.append(" AND C_PR_APE_goodsName LIKE '%' + ? + '%' ");
			params.add(adjustmentPricePo.getGoodsName());
		}
		// add by ZK query for goodsName end
		if (!"".equals(Utility.getName(adjustmentPricePo.getCprapbillid()))) {
			sb.append(" and C_PR_AP_billID like ?");
			params.add("%"+adjustmentPricePo.getCprapbillid()+"%");
		}
		if (!"".equals(Utility.getName(adjustmentPricePo.getCprapwhichprice()))) {
			sb.append(" and C_PR_AP_WhichPrice = ? ");
			params.add(adjustmentPricePo.getCprapwhichprice());
		}
		if (!"".equals(Utility.getName(adjustmentPricePo.getCprapcreateperson()))) {
			sb.append(" and C_PR_AP_createperson=? ");
			params.add(adjustmentPricePo.getCprapcreateperson());
		}

		if (!"".equals(Utility.getName(adjustmentPricePo.getCprapcreatestartdate()))&& !"".equals(Utility.getName(adjustmentPricePo.getCprapcreateenddate()))) {
			sb.append(" and convert(varchar(10), C_PR_AP_createDate, 23) >= ? ");
			params.add(adjustmentPricePo.getCprapcreatestartdate());
			sb.append(" and convert(varchar(10), C_PR_AP_createDate, 23) <= ? ");
			params.add(adjustmentPricePo.getCprapcreateenddate());
		} else if (!"".equals(Utility.getName(adjustmentPricePo.getCprapcreatestartdate()))&& "".equals(Utility.getName(adjustmentPricePo.getCprapcreateenddate()))) {
			sb.append(" and convert(varchar(10), C_PR_AP_createDate, 23) >= ? ");
			params.add(adjustmentPricePo.getCprapcreatestartdate());

		} else if ("".equals(Utility.getName(adjustmentPricePo.getCprapcreatestartdate()))&& !"".equals(Utility.getName(adjustmentPricePo.getCprapcreateenddate()))) {
			sb.append(" and convert(varchar(10), C_PR_AP_createDate, 23) <= ? ");
			params.add(adjustmentPricePo.getCprapcreateenddate());
		}

		if (!"".equals(Utility.getName(adjustmentPricePo.getCprapeffectivedate()))&& !"".equals(Utility.getName(adjustmentPricePo.getCprapeffectivedate()))) {
			sb.append(" and convert(varchar(10), C_PR_AP_effectiveDate, 23) >= ? ");
			params.add(adjustmentPricePo.getCprapeffectivedate());
			sb.append(" and convert(varchar(10), C_PR_AP_effectiveDate, 23) <= ? ");
			params.add(adjustmentPricePo.getCprapeffectivedate());
		} else if (!"".equals(Utility.getName(adjustmentPricePo.getCprapeffectivedate()))&& "".equals(Utility.getName(adjustmentPricePo.getCprapeffectivedate()))) {
			sb.append(" and convert(varchar(10), C_PR_AP_effectiveDate, 23) >= ? ");
			params.add(adjustmentPricePo.getCprapcreatedate());

		} else if ("".equals(Utility.getName(adjustmentPricePo.getCprapeffectivedate()))&& !"".equals(Utility.getName(adjustmentPricePo.getCprapeffectivedate()))) {
			sb.append(" and convert(varchar(10), C_PR_AP_effectiveDate, 23) <= ? ");
			params.add(adjustmentPricePo.getCprapeffectivedate());
		}

		if (!"".equals(Utility.getName(adjustmentPricePo.getCprapauditperson()))) {
			sb.append(" and C_PR_AP_auditperson=? ");
			params.add(adjustmentPricePo.getCprapauditperson());
		}

		if (!"".equals(Utility.getName(adjustmentPricePo.getCprapauditstate()))) {
			sb.append(" and C_PR_AP_auditstate=? ");
			params.add(adjustmentPricePo.getCprapauditstate());
		}

		if (!"".equals(Utility.getName(adjustmentPricePo.getCprapeffectivestate()))) {
			sb.append(" and C_PR_AP_effectivestate=? ");
			params.add(adjustmentPricePo.getCprapeffectivestate());
		}
		
		sb.append(" GROUP BY C_PR_AdjustmentPrice.C_PR_AP_billID ) AS t1");

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	
	public List<AdjustmentPricePo> getAdjuestmentPriceList(
			AdjustmentPricePo adjustmentPricePo, int start, int size) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.cprapremark,temp.cprapauditstate,temp.cprapeffectivestate,temp.cprapbillid,temp.cprapeffectivedate,temp.cprapcreatedate,temp.cprapcreatePerson,temp.cprapauditPerson,temp.cprapcreatePersonname,temp.cprapauditPersonname,temp.cprapremark,temp.cprapwhichprice as cprapwhichprice from");
		sb.append("(select ROW_NUMBER() Over(order by C_PR_AdjustmentPrice.C_PR_AP_createDate desc)");
		sb.append(" as rowNum,c_pr_ap_effectivestate as cprapeffectivestate,c_pr_ap_remark as cprapremark,c_pr_ap_auditstate as cprapauditstate,c_pr_ap_billid as cprapbillid,C_PR_AP_effectiveDate as cprapeffectivedate,C_PR_AP_createdate as cprapcreatedate,C_PR_AP_createPerson as cprapcreatePerson,a.personname as cprapcreatePersonname,C_PR_AP_auditPerson as cprapauditPerson ");
		sb.append(", b.personname as cprapauditPersonname,C_PR_AP_WhichPrice as cprapwhichprice from C_PR_AdjustmentPrice");
		sb.append(" left join (select ID,personName from SYS_PersonInfo) a on C_PR_AdjustmentPrice.C_PR_AP_createPerson=a.id");
		sb.append(" left join (select id,personname from sys_personinfo) b on C_PR_AdjustmentPrice.C_PR_AP_auditPerson=b.id ");
		if(!"".equals(adjustmentPricePo.getGoodsName())) {
			sb.append(" INNER JOIN C_PR_AdjustmentPriceEntry ON C_PR_AdjustmentPriceEntry.C_PR_APE_billID = C_PR_AdjustmentPrice.C_PR_AP_billID ");
		}
		sb.append("where 1=1");
		//TODO add by ZK query for goodsName begin
		if(!"".equals(adjustmentPricePo.getGoodsName())) {
			sb.append(" and C_PR_APE_goodsName LIKE '%' + ? + '%' ");
			params.add(adjustmentPricePo.getGoodsName());
		}
		// add by ZK query for goodsName end
		
		if (!"".equals(Utility.getName(adjustmentPricePo.getCprapbillid()))) {
			sb.append(" and c_pr_ap_billid like ? ");
			params.add("%"+adjustmentPricePo.getCprapbillid()+"%");
		}
		
		if (!"".equals(Utility.getName(adjustmentPricePo.getCprapwhichprice()))) {
			sb.append(" and C_PR_AP_WhichPrice = ? ");
			params.add(adjustmentPricePo.getCprapwhichprice());
		}

		if (!"".equals(Utility.getName(adjustmentPricePo.getCprapcreateperson()))) {
			sb.append(" and C_PR_AP_createPerson=? ");
			params.add(adjustmentPricePo.getCprapcreateperson());
		}
		if (!"".equals(Utility.getName(adjustmentPricePo.getCprapeffectivestartdate()))&& !"".equals(Utility.getName(adjustmentPricePo.getCprapeffectiveenddate()))) {
			sb.append(" and convert(varchar(10), C_PR_AP_effectiveDate, 23) >= ? ");
			sb.append(" and convert(varchar(10), C_PR_AP_effectiveDate, 23) <= ? ");

			params.add(adjustmentPricePo.getCprapeffectivestartdate());
			params.add(adjustmentPricePo.getCprapeffectiveenddate());
		} else if (!"".equals(Utility.getName(adjustmentPricePo.getCprapeffectivestartdate()))&& "".equals(Utility.getName(adjustmentPricePo.getCprapeffectiveenddate()))) {
			sb.append(" and convert(varchar(10), C_PR_AP_effectiveDate, 23) >= ? ");
			params.add(adjustmentPricePo.getCprapeffectivestartdate());

		} else if ("".equals(Utility.getName(adjustmentPricePo.getCprapeffectivestartdate()))&& !"".equals(Utility.getName(adjustmentPricePo.getCprapeffectiveenddate()))) {
			sb.append(" and convert(varchar(10), C_PR_AP_effectiveDate, 23) <= ? ");
			params.add(adjustmentPricePo.getCprapeffectiveenddate());
		}

		if (!"".equals(Utility.getName(adjustmentPricePo.getCprapcreatestartdate()))&& !"".equals(Utility.getName(adjustmentPricePo.getCprapcreateenddate()))) {
			sb.append(" and convert(varchar(10), C_PR_AP_createdate, 23) >= ? ");
			params.add(adjustmentPricePo.getCprapcreatestartdate());
			sb.append(" and convert(varchar(10), C_PR_AP_createdate, 23) <= ? ");
			params.add(adjustmentPricePo.getCprapcreateenddate());
		} else if (!"".equals(Utility.getName(adjustmentPricePo.getCprapcreatestartdate()))&& "".equals(Utility.getName(adjustmentPricePo.getCprapcreateenddate()))) {
			sb.append(" and convert(varchar(10), C_PR_AP_createdate, 23) >= ? ");
			params.add(adjustmentPricePo.getCprapcreatestartdate());

		} else if ("".equals(Utility.getName(adjustmentPricePo.getCprapcreatestartdate()))&& !"".equals(Utility.getName(adjustmentPricePo.getCprapcreateenddate()))) {
			sb.append(" and convert(varchar(10), C_PR_AP_createdate, 23) <= ? ");
			params.add(adjustmentPricePo.getCprapcreateenddate());
		}

		if (!"".equals(Utility.getName(adjustmentPricePo.getCprapauditperson()))) {
			sb.append(" and C_PR_AP_auditPerson=? ");
			params.add(adjustmentPricePo.getCprapauditperson());
		}

		if (!"".equals(Utility.getName(adjustmentPricePo.getCprapauditstate()))) {
			sb.append(" and C_PR_AP_AuditState = ? ");
			params.add(adjustmentPricePo.getCprapauditstate());
		}

		if (!"".equals(Utility.getName(adjustmentPricePo
				.getCprapeffectivestate()))) {
			sb.append(" and C_PR_AP_effectiveState=? ");
			params.add(adjustmentPricePo.getCprapeffectivestate());
		}
		
		if(!"".equals(adjustmentPricePo.getGoodsName())) {
			sb.append(" GROUP BY c_pr_ap_billid,C_PR_AP_createDate,C_PR_AP_effectiveState,C_PR_AP_remark,C_PR_AP_AuditState,C_PR_AP_effectiveDate, ");
			sb.append("C_PR_AP_createPerson,a.personName,C_PR_AP_AuditPerson,b.personname,C_PR_AP_WhichPrice");
		}
		
		sb.append("  ) temp where rowNum > " + start + " and rowNum <= " + countPage +" ");

		sb.append(" set rowcount 0");

		return getJdbcTemplate().queryForList(sb.toString(), params.toArray());
	}

	
	public void adjustmentPriceEntryDelete(AdjustmentPricePo adjustmentPricePo) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("delete from C_PR_AdjustmentPriceEntry ");
		List<String> params = new ArrayList<String>();
		if (!"".equals(adjustmentPricePo.getCprapbillid())) {
			sb.append(" where C_PR_APE_billID=?");
			params.add(adjustmentPricePo.getCprapbillid());
		}
		getJdbcTemplate().update(sb.toString(), params.toArray());

	}

	public AdjustmentPricePo getAdjuestmentPrice(
			AdjustmentPricePo adjustmentPricePo) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("select top 1  temp.cprapremark,temp.cprapauditstate,datediff(dd,getdate(),cprapeffectivedate) as cprapeffecticestate,temp.cprapsupplierid,temp.cprapbrandid,temp.cprapbillid,temp.cprapeffectivedate,temp.cprapcreatedate,temp.cprapcreatePerson,temp.cprapauditPerson,temp.cprapcreatePersonname,temp.cprapbrandidname,temp.cprapsupplieridname,temp.cprapauditPersonname,temp.cprapflag,temp.cprapwhichprice as cprapwhichprice from");
		sb.append("(select ROW_NUMBER() Over(order by C_PR_AdjustmentPrice.C_PR_AP_createDate desc,C_PR_AdjustmentPrice.C_PR_AP_billID desc)");
		sb.append(" as rowNum,c_pr_ap_remark as cprapremark ,c_pr_ap_auditstate as cprapauditstate,c_pr_ap_billid as cprapbillid,convert(varchar(16),C_PR_AP_effectiveDate,120) as cprapeffectivedate,C_PR_AP_createdate as cprapcreatedate,C_PR_AP_createPerson as cprapcreatePerson,a.personname as cprapcreatePersonname,C_PR_AP_auditPerson as cprapauditPerson ");
		sb.append(", b.personname as cprapauditPersonname,C_PR_AP_BrandID as cprapbrandid ,C_PR_AP_SupplierID as cprapsupplierid,(select B_SP_SupplierName from B_Supplier where B_SP_ID= C_PR_AP_SupplierID) as cprapsupplieridname,(select B_BD_brandName from B_Brand where B_BD_SupplierID= C_PR_AP_SupplierID and B_BD_ID=C_PR_AP_BrandID) as cprapbrandidname ,isnull(C_PR_AP_Flag,'0') as cprapflag,C_PR_AP_WhichPrice as cprapwhichprice  from  C_PR_AdjustmentPrice");
		sb.append(" left join (select ID,personName from SYS_PersonInfo) a on C_PR_AdjustmentPrice.C_PR_AP_createPerson=a.id");
		sb.append(" left join (select id,personname from sys_personinfo) b on C_PR_AdjustmentPrice.C_PR_AP_auditPerson=b.id ) temp");
		sb.append(" where temp.cprapbillid=?");
		
		List<String> params = new ArrayList<String>();
		params.add(adjustmentPricePo.getCprapbillid());
		return (AdjustmentPricePo) this.queryForObject(sb.toString(), params
				.toArray(), AdjustmentPricePo.class);
	}

	public List<AdjustmentPriceEntryPo> getAdjuestmentPriceEntryList(
			AdjustmentPricePo adjustmentPricePo) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("SELECT C_PR_APE_ID as cprapeid");
		sb.append(" ,C_PR_APE_billID as cprapebillid");
		sb.append(" ,C_PR_APE_goodsID as cprapegoodsid");
		sb.append(" ,C_PR_APE_barCode as cprapegoodsbarcode");
		sb.append(" ,C_PR_APE_goodsName as cprapegoodsname");
		sb.append(" ,C_PR_APE_costPrice as cprapecostprice");
		sb.append(" ,C_PR_APE_AdPrice as cprapeadprice");
		sb.append(" ,B_BD_brandName as cprapebbdbrandname");
		sb.append(" ,b_gi_spec as cprapebbdspec");
		sb.append(" FROM C_PR_AdjustmentPriceEntry");
		sb.append(" inner join b_goodsinfo on b_gi_goodsid=C_PR_APE_goodsID");
		sb.append(" inner join b_supplier on b_gi_supplierid=B_SP_ID");
		sb.append(" inner join b_brand on b_gi_brandid=B_BD_ID and B_BD_SupplierID=B_SP_ID");
		sb.append(" where C_PR_APE_billID=?");
		
		List<String> params = new ArrayList<String>();
		params.add(adjustmentPricePo.getCprapbillid());
		return getJdbcTemplate().queryForList(sb.toString(), params.toArray());
	}
	
	/**
	 * 按品种获取商品
	 * */
	public List<AdjustmentPriceEntryPo> getAdjuestmentPriceEntryList(BrandPo brandPo){
		StringBuffer sb = new StringBuffer();
		
		List<String> params = new ArrayList<String>();
		
		sb.append("select B_GI_GoodsID as cprapegoodsid,B_GI_GoodsBarCode as cprapegoodsbarcode,B_GI_ViewGoodsName as cprapegoodsname,");
		if("1".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailprice     AS cprapecostprice, ");
		}
		if("2".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpricea     AS cprapecostprice, ");
		}
		if("3".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpriceb     AS cprapecostprice, ");
		}
		if("4".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpricec     AS cprapecostprice, ");
		}
		if("5".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpriced     AS cprapecostprice, ");
		}
		if("6".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpricee     AS cprapecostprice, ");
		}
		if("7".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpricef     AS cprapecostprice, ");
		}
		if("8".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpriceg     AS cprapecostprice, ");
		}
		if("9".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpriceh     AS cprapecostprice, ");
		}
		if("10".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpricei     AS cprapecostprice, ");
		}
		sb.append("? as cprapebillid,? as cprapeadprice ");
		sb.append(" from B_GoodsInfo inner join B_Supplier on B_SP_ID=B_GI_SupplierID ");
		sb.append("inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID where 1=1 ");
		sb.append("and B_GI_GoodsCategoryID=? and B_GI_SupplierID=? and B_GI_BrandID=? ");
		params.add(brandPo.getBbdremark());
		params.add(brandPo.getBbdmaxretailPrice());
		params.add(brandPo.getBspcategoryid());
		params.add(brandPo.getBbdsupplierid());
		params.add(brandPo.getBbdid());
		
		if("".equals(Utility.getName(brandPo.getBbdretailprice()))){
			if("1".equals(brandPo.getBbdwhichretail())){
				sb.append("and b_gi_retailprice is null ");
			}
			if("2".equals(brandPo.getBbdwhichretail())){
				sb.append("and b_gi_retailpricea is null ");
			}
			if("3".equals(brandPo.getBbdwhichretail())){
				sb.append("and b_gi_retailpriceb is null ");
			}
			if("4".equals(brandPo.getBbdwhichretail())){
				sb.append("and b_gi_retailpricec is null ");
			}
			if("5".equals(brandPo.getBbdwhichretail())){
				sb.append("and b_gi_retailpriced is null ");
			}
			if("6".equals(brandPo.getBbdwhichretail())){
				sb.append("and b_gi_retailpricee is null ");
			}
			if("7".equals(brandPo.getBbdwhichretail())){
				sb.append("and b_gi_retailpricef is null ");
			}
			if("8".equals(brandPo.getBbdwhichretail())){
				sb.append("and b_gi_retailpriceg is null ");
			}
			if("9".equals(brandPo.getBbdwhichretail())){
				sb.append("and b_gi_retailpriceh is null ");
			}
			if("10".equals(brandPo.getBbdwhichretail())){
				sb.append("and b_gi_retailpricei is null ");
			}
		}else{
			if("1".equals(brandPo.getBbdwhichretail())){
				sb.append("and b_gi_retailprice=? ");
			}
			if("2".equals(brandPo.getBbdwhichretail())){
				sb.append("and b_gi_retailpricea=? ");
			}
			if("3".equals(brandPo.getBbdwhichretail())){
				sb.append("and b_gi_retailpriceb=? ");
			}
			if("4".equals(brandPo.getBbdwhichretail())){
				sb.append("and b_gi_retailpricec=? ");
			}
			if("5".equals(brandPo.getBbdwhichretail())){
				sb.append("and b_gi_retailpriced=? ");
			}
			if("6".equals(brandPo.getBbdwhichretail())){
				sb.append("and b_gi_retailpricee=? ");
			}
			if("7".equals(brandPo.getBbdwhichretail())){
				sb.append("and b_gi_retailpricef=? ");
			}
			if("8".equals(brandPo.getBbdwhichretail())){
				sb.append("and b_gi_retailpriceg=? ");
			}
			if("9".equals(brandPo.getBbdwhichretail())){
				sb.append("and b_gi_retailpriceh=? ");
			}
			if("10".equals(brandPo.getBbdwhichretail())){
				sb.append("and b_gi_retailpricei=? ");
			}
			params.add(brandPo.getBbdretailprice());
		}

		return queryForObjectList(sb.toString(), params.toArray(),AdjustmentPriceEntryPo.class);
	}
	public GoodsInfoPo selectDimensionPo(String goodsid,String v,String whichretail) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("Select  ");
		sb.append("B_GI_GoodsID as bgigoodsid, ");
		sb.append("B_GI_GoodsBarCode+'00000000' as bgigoodsbarcode, ");
		sb.append("B_GI_ViewGoodsName as bgigoodsname, ");
		sb.append("B_GI_GoodsCategoryID as bgigoodscategoryid,  ");
		sb.append("B_GI_SupplierID as bgisupplierid,  ");
		sb.append("B_SP_SupplierName as bgisuppliername,  ");
		sb.append("B_GI_BrandID as bgibrandid,  ");
		sb.append("B_BD_brandName as bgibrandname,  ");
		sb.append("B_GI_CostPrice as bgicostprice,  ");
		sb.append("B_GI_WholesalePrice as bgiwholesaleprice,  ");
		if("1".equals(whichretail)){
			sb.append(" b_gi_retailprice     AS bgiretailprice, ");
		}
		if("2".equals(whichretail)){
			sb.append(" b_gi_retailpricea     AS bgiretailprice, ");
		}
		if("3".equals(whichretail)){
			sb.append(" b_gi_retailpriceb     AS bgiretailprice, ");
		}
		if("4".equals(whichretail)){
			sb.append(" b_gi_retailpricec     AS bgiretailprice, ");
		}
		if("5".equals(whichretail)){
			sb.append(" b_gi_retailpriced     AS bgiretailprice, ");
		}
		if("6".equals(whichretail)){
			sb.append(" b_gi_retailpricee     AS bgiretailprice, ");
		}
		if("7".equals(whichretail)){
			sb.append(" b_gi_retailpricef     AS bgiretailprice, ");
		}
		if("8".equals(whichretail)){
			sb.append(" b_gi_retailpriceg     AS bgiretailprice, ");
		}
		if("9".equals(whichretail)){
			sb.append(" b_gi_retailpriceh     AS bgiretailprice, ");
		}
		if("10".equals(whichretail)){
			sb.append(" b_gi_retailpricei     AS bgiretailprice, ");
		}
		sb.append("B_GI_Spec as bgispec,");
		sb.append("? as bgiwhichretail, ");
		sb.append("cast (? as numeric(18, 2)) as bgiretailpricenow ");
		sb.append("from B_GoodsInfo ");
		sb.append("inner join B_Supplier on B_GI_SupplierID = B_SP_ID ");
		sb.append("inner join B_Brand on B_GI_SupplierID = B_BD_SupplierID and B_GI_BrandID = B_BD_ID ");
		sb.append("where B_GI_GoodsID = ? ");
		params.add(whichretail);
		params.add(v);
		params.add(goodsid);
		
		return (GoodsInfoPo) queryForObject(sb.toString(), params.toArray(), GoodsInfoPo.class);
	}
	
	/**
	 * 零售价调价单立即生效
	 */
	public void updateAdjustmentPrice(AdjustmentPricePo adjustmentPricePo){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if("1".equals(adjustmentPricePo.getCprapwhichprice())){
			sb.append(" update b_goodsinfo set B_GI_RetailPrice=C_PR_APE_AdPrice ");
		}
		if("2".equals(adjustmentPricePo.getCprapwhichprice())){
			sb.append(" update b_goodsinfo set B_GI_RetailPricea=C_PR_APE_AdPrice ");
		}
		if("3".equals(adjustmentPricePo.getCprapwhichprice())){
			sb.append(" update b_goodsinfo set B_GI_RetailPriceb=C_PR_APE_AdPrice ");
		}
		if("4".equals(adjustmentPricePo.getCprapwhichprice())){
			sb.append(" update b_goodsinfo set B_GI_RetailPricec=C_PR_APE_AdPrice ");
		}
		if("5".equals(adjustmentPricePo.getCprapwhichprice())){
			sb.append(" update b_goodsinfo set B_GI_RetailPriced=C_PR_APE_AdPrice ");
		}
		if("6".equals(adjustmentPricePo.getCprapwhichprice())){
			sb.append(" update b_goodsinfo set B_GI_RetailPricee=C_PR_APE_AdPrice ");
		}
		if("7".equals(adjustmentPricePo.getCprapwhichprice())){
			sb.append(" update b_goodsinfo set B_GI_RetailPricef=C_PR_APE_AdPrice ");
		}
		if("8".equals(adjustmentPricePo.getCprapwhichprice())){
			sb.append(" update b_goodsinfo set B_GI_RetailPriceg=C_PR_APE_AdPrice ");
		}
		if("9".equals(adjustmentPricePo.getCprapwhichprice())){
			sb.append(" update b_goodsinfo set B_GI_RetailPriceh=C_PR_APE_AdPrice ");
		}
		if("10".equals(adjustmentPricePo.getCprapwhichprice())){
			sb.append(" update b_goodsinfo set B_GI_RetailPricei=C_PR_APE_AdPrice ");
		}

		sb.append(" from b_goodsinfo inner join C_PR_AdjustmentPriceEntry on B_GI_GoodsID = C_PR_APE_goodsID where C_PR_APE_billID = ? ");
		
		params.add(adjustmentPricePo.getCprapbillid());
		
		if("1".equals(adjustmentPricePo.getCprapwhichprice())){
			sb.append(" update B_GoodsInfo_FlySheet set B_GI_RetailPrice=C_PR_APE_AdPrice ");
		}
		if("2".equals(adjustmentPricePo.getCprapwhichprice())){
			sb.append(" update B_GoodsInfo_FlySheet set B_GI_RetailPricea=C_PR_APE_AdPrice ");
		}
		if("3".equals(adjustmentPricePo.getCprapwhichprice())){
			sb.append(" update B_GoodsInfo_FlySheet set B_GI_RetailPriceb=C_PR_APE_AdPrice ");
		}
		if("4".equals(adjustmentPricePo.getCprapwhichprice())){
			sb.append(" update B_GoodsInfo_FlySheet set B_GI_RetailPricec=C_PR_APE_AdPrice ");
		}
		if("5".equals(adjustmentPricePo.getCprapwhichprice())){
			sb.append(" update B_GoodsInfo_FlySheet set B_GI_RetailPriced=C_PR_APE_AdPrice ");
		}
		if("6".equals(adjustmentPricePo.getCprapwhichprice())){
			sb.append(" update B_GoodsInfo_FlySheet set B_GI_RetailPricee=C_PR_APE_AdPrice ");
		}
		if("7".equals(adjustmentPricePo.getCprapwhichprice())){
			sb.append(" update B_GoodsInfo_FlySheet set B_GI_RetailPricef=C_PR_APE_AdPrice ");
		}
		if("8".equals(adjustmentPricePo.getCprapwhichprice())){
			sb.append(" update B_GoodsInfo_FlySheet set B_GI_RetailPriceg=C_PR_APE_AdPrice ");
		}
		if("9".equals(adjustmentPricePo.getCprapwhichprice())){
			sb.append(" update B_GoodsInfo_FlySheet set B_GI_RetailPriceh=C_PR_APE_AdPrice ");
		}
		if("10".equals(adjustmentPricePo.getCprapwhichprice())){
			sb.append(" update B_GoodsInfo_FlySheet set B_GI_RetailPricei=C_PR_APE_AdPrice ");
		}

		sb.append(" from b_goodsinfo inner join C_PR_AdjustmentPriceEntry on B_GI_GoodsID = C_PR_APE_goodsID where C_PR_APE_billID = ? ");
		
		params.add(adjustmentPricePo.getCprapbillid());
		
		sb.append(" update C_PR_AdjustmentPrice set C_PR_AP_effectiveState = '1',C_PR_AP_effectiveDate = getdate() where C_PR_AP_billID = ? ");
		
		params.add(adjustmentPricePo.getCprapbillid());
		
		getJdbcTemplate().update(sb.toString(),params.toArray());	
	}
	
	/**
	 * 成本价调价单立即生效
	 */
	public void updateCostPrice(AdjustmentPricePo adjustmentPricePo){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" update B_GoodsInfo set B_GI_CostPrice = C_PR_ACE_AdPrice,B_GI_NotTaxRate = cast(( C_PR_ACE_AdPrice / (1+cast(B_GI_TaxRate as numeric(18 , 2)) * 0.01)) as numeric(18 , 6)) ");
		sb.append(" from b_goodsinfo inner join C_PR_AdcostPriceEntry on B_GI_GoodsID = C_PR_ACE_goodsID where C_PR_ACE_billID = ? ");
		
		params.add(adjustmentPricePo.getCprapbillid());
		
		sb.append(" update C_PR_AdcostPrice set C_PR_AC_effectiveState = '1',C_PR_AC_effectiveDate = getdate() where C_PR_AC_billID = ? ");
		
		params.add(adjustmentPricePo.getCprapbillid());
		
		getJdbcTemplate().update(sb.toString(),params.toArray());	
	}
	
	/**
	 * 批发价调价单立即生效
	 */
	public void updateWholesalePrice(AdjustmentPricePo adjustmentPricePo){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" update B_GoodsInfo set B_GI_WholesalePrice=C_PR_WPE_AdPrice ");
		sb.append(" from b_goodsinfo inner join C_PR_WholesalePriceEntry on B_GI_GoodsID = C_PR_WPE_goodsID where C_PR_WPE_billID = ? ");
		
		params.add(adjustmentPricePo.getCprapbillid());
		
		sb.append(" update C_PR_WholesalePrice set C_PR_WP_effectiveState = '1',C_PR_WP_effectiveDate = getdate() where C_PR_WP_billID = ? ");
		
		params.add(adjustmentPricePo.getCprapbillid());
		
		getJdbcTemplate().update(sb.toString(),params.toArray());	
	}
	
}
