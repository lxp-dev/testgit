package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.storage.dao.AdcostPriceDao;
import com.pengsheng.eims.storage.persistence.AdcostPriceEntryPo;
import com.pengsheng.eims.storage.persistence.AdcostPricePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class AdcostPriceDaoImpl extends BaseJdbcDaoSupport implements AdcostPriceDao {

	/**
	 * 得到调价单数量
	 */
	public int getAdcostPriceCount(AdcostPricePo adcostPricePo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" SELECT COUNT(C_PR_AC_billID) FROM ( ");
		sb.append("select C_PR_AdcostPrice.C_PR_AC_billID from C_PR_AdcostPrice ");
		sb.append(" INNER JOIN C_PR_AdcostPriceEntry ON C_PR_AdcostPriceEntry.C_PR_ACE_billID = C_PR_AdcostPrice.C_PR_AC_billID ");
		sb.append("  where 1=1 ");
		
		//商品名称
		if(!"".equals(adcostPricePo.getGoodsName())) {
			sb.append(" AND C_PR_ACE_goodsName LIKE '%' + ? + '%'");
			params.add(adcostPricePo.getGoodsName());
		}
		
		//调价单号
		if (!"".equals(Utility.getName(adcostPricePo.getCpracbillid()))) {
			sb.append(" and C_PR_AC_billID like '%' + ? + '%' ");
			params.add(adcostPricePo.getCpracbillid());
		}

		//制单人
		if (!"".equals(Utility.getName(adcostPricePo.getCpraccreateperson()))) {
			sb.append(" and C_PR_AC_createperson = ? ");
			params.add(adcostPricePo.getCpraccreateperson());
		}

		//制单日期
		if (!"".equals(Utility.getName(adcostPricePo.getCpraccreatestartdate()))
				&& !"".equals(Utility.getName(adcostPricePo.getCpraccreateenddate()))) {
			
			sb.append(" and convert(varchar(10), C_PR_AC_createDate, 23) >= ? ");
			params.add(adcostPricePo.getCpraccreatestartdate());
			
			sb.append(" and convert(varchar(10), C_PR_AC_createDate, 23) <= ? ");
			params.add(adcostPricePo.getCpraccreateenddate());
			
		} else if (!"".equals(Utility.getName(adcostPricePo.getCpraccreatestartdate()))
				&& "".equals(Utility.getName(adcostPricePo.getCpraccreateenddate()))) {
			
			sb.append(" and convert(varchar(10), C_PR_AC_createDate, 23) >= ? ");
			params.add(adcostPricePo.getCpraccreatestartdate());

		} else if ("".equals(Utility.getName(adcostPricePo.getCpraccreatestartdate()))
				&& !"".equals(Utility.getName(adcostPricePo.getCpraccreateenddate()))) {
			
			sb.append(" and convert(varchar(10), C_PR_AC_createDate, 23) <= ? ");
			params.add(adcostPricePo.getCpraccreateenddate());
			
		}

		//生效日期
		if (!"".equals(Utility.getName(adcostPricePo.getCpraceffectiveenddate()))&& !"".equals(Utility.getName(adcostPricePo.getCpraceffectivestartdate()))) {
			sb.append(" and convert(varchar(10), C_PR_AC_effectiveDate, 23) >= ? ");
			params.add(adcostPricePo.getCpraceffectivestartdate());
			
			sb.append(" and convert(varchar(10), C_PR_AC_effectiveDate, 23) <= ? ");
			params.add(adcostPricePo.getCpraceffectiveenddate());
			
		} else if (!"".equals(Utility.getName(adcostPricePo	.getCpraceffectivestartdate()))&& "".equals(Utility.getName(adcostPricePo.getCpraceffectiveenddate()))) {
			sb.append(" and convert(varchar(10), C_PR_AC_effectiveDate, 23) >= ? ");
			params.add(adcostPricePo.getCpraceffectivestartdate());
		} else if ("".equals(Utility.getName(adcostPricePo.getCpraceffectivestartdate()))&& !"".equals(Utility.getName(adcostPricePo.getCpraceffectiveenddate()))) {
			sb.append(" and convert(varchar(10), C_PR_AC_effectiveDate, 23) <= ? ");
			params.add(adcostPricePo.getCpraceffectiveenddate());
			
		}
		
		//审核人
		if (!"".equals(Utility.getName(adcostPricePo.getCpracauditperson()))) {
			sb.append(" and C_PR_AC_auditperson = ? ");
			params.add(adcostPricePo.getCpracauditperson());
		}

		
		//审核状态
		if (!"".equals(Utility.getName(adcostPricePo.getCpracauditstate()))) {
			sb.append(" and C_PR_AC_auditstate = ? ");
			params.add(adcostPricePo.getCpracauditstate());
		}

		//生效状态
		if (!"".equals(Utility.getName(adcostPricePo.getCpraceffectivestate()))) {
			sb.append(" and C_PR_AC_effectivestate = ? ");
			params.add(adcostPricePo.getCpraceffectivestate());
		}
		
		sb.append(" GROUP BY C_PR_AC_billID ) AS t1");
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	
	/**
	 * 查询调价单LIst
	 */
	public List<AdcostPricePo> getAdcostPriceList(AdcostPricePo adcostPricePo, int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		
		sb.append(" select temp.cpracremark,temp.cpracauditstate , ");
		sb.append(" temp.cpraceffectivestate,temp.cpracbillid , ");
		sb.append(" temp.cpraceffectivedate,temp.cpraccreatedate, ");
		sb.append(" temp.cpraccreateperson,temp.cpracauditperson, ");
		sb.append(" temp.cpraccreatepersonname,temp.cpracauditpersonname , ");
		sb.append(" temp.cpracremark from( ");
		sb.append(" select ROW_NUMBER() Over(order by C_PR_AdcostPrice.C_PR_AC_createDate desc ) as rowNum , ");
		sb.append(" c_pr_ac_effectivestate as cpraceffectivestate , ");
		sb.append(" c_pr_ac_remark as cpracremark , ");
		sb.append(" c_pr_ac_auditstate as cpracauditstate , ");
		sb.append(" c_pr_ac_billid as cpracbillid , ");
		sb.append(" C_PR_AC_effectiveDate as cpraceffectivedate , ");
		sb.append(" C_PR_AC_createdate as cpraccreatedate , ");
		sb.append(" C_PR_AC_createPerson as cpraccreatePerson , ");
		sb.append(" a.personname as cpraccreatepersonname , ");
		sb.append(" C_PR_AC_auditPerson as cpracauditperson , ");
		sb.append(" b.personname as cpracauditpersonname ");
		sb.append(" from C_PR_AdcostPrice ");
		sb.append(" left join (select ID,personName from SYS_PersonInfo) a ");
		sb.append("	on C_PR_AdcostPrice.C_PR_AC_createPerson=a.id ");
		sb.append(" left join (select id,personname from sys_personinfo) b ");
		sb.append("	on C_PR_AdcostPrice.C_PR_AC_auditPerson=b.id ");
		
		List<String> params = new ArrayList<String>();
		
		//TODO add by ZK query for goodsName
		if(!"".equals(adcostPricePo.getGoodsName())) {
			sb.append(" INNER JOIN C_PR_AdcostPriceEntry ON C_PR_AdcostPriceEntry.C_PR_ACE_billID = C_PR_AdcostPrice.C_PR_AC_billID  ");
			sb.append(" WHERE C_PR_ACE_goodsName LIKE '%' + ? + '%' ");
			params.add(adcostPricePo.getGoodsName());
			sb.append(" GROUP BY c_pr_ac_effectivestate,c_pr_ac_remark,c_pr_ac_auditstate,c_pr_ac_billid,C_PR_AC_effectiveDate, ");
			sb.append(" C_PR_AC_createdate,C_PR_AC_createPerson,a.personname,C_PR_AC_auditPerson,b.personname ");
		}
		
		sb.append(" where 1=1 ");
		
		//调价单号
		if (!"".equals(Utility.getName(adcostPricePo.getCpracbillid()))) {
			sb.append(" and c_pr_ac_billid like '%' + ? + '%' ");
			params.add(adcostPricePo.getCpracbillid());
		}

		//制单人
		if (!"".equals(Utility.getName(adcostPricePo.getCpraccreateperson()))) {
			sb.append(" and C_PR_AC_createPerson = ? ");
			params.add(adcostPricePo.getCpraccreateperson());
		}

		//制单日期
		if (!"".equals(Utility.getName(adcostPricePo.getCpraccreatestartdate()))
				&& !"".equals(Utility.getName(adcostPricePo.getCpraccreateenddate()))) {
			
			sb.append(" and convert(varchar(10), C_PR_AC_createdate, 23) >= ? ");
			params.add(adcostPricePo.getCpraccreatestartdate());
			
			sb.append(" and convert(varchar(10), C_PR_AC_createdate, 23) <= ? ");
			params.add(adcostPricePo.getCpraccreateenddate());
			
		} else if (!"".equals(Utility.getName(adcostPricePo.getCpraccreatestartdate()))
				&& "".equals(Utility.getName(adcostPricePo.getCpraccreateenddate()))) {
			
			sb.append(" and convert(varchar(10), C_PR_AC_createdate, 23) >= ? ");
			params.add(adcostPricePo.getCpraccreatestartdate());

		} else if ("".equals(Utility.getName(adcostPricePo.getCpraccreatestartdate()))
				&& !"".equals(Utility.getName(adcostPricePo.getCpraccreateenddate()))) {
			
			sb.append(" and convert(varchar(10), C_PR_AC_createdate, 23) <= ? ");
			params.add(adcostPricePo.getCpraccreateenddate());
			
		}

		//生效日期
		if (!"".equals(Utility.getName(adcostPricePo.getCpraceffectiveenddate()))&& !"".equals(Utility.getName(adcostPricePo.getCpraceffectivestartdate()))) {
			sb.append(" and convert(varchar(10), C_PR_AC_effectiveDate, 23) >= ? ");
			params.add(adcostPricePo.getCpraceffectivestartdate());
			
			sb.append(" and convert(varchar(10), C_PR_AC_effectiveDate, 23) <= ? ");
			params.add(adcostPricePo.getCpraceffectiveenddate());
			
		} else if (!"".equals(Utility.getName(adcostPricePo	.getCpraceffectivestartdate()))&& "".equals(Utility.getName(adcostPricePo.getCpraceffectiveenddate()))) {
			sb.append(" and convert(varchar(10), C_PR_AC_effectiveDate, 23) >= ? ");
			params.add(adcostPricePo.getCpraceffectivestartdate());
		} else if ("".equals(Utility.getName(adcostPricePo.getCpraceffectivestartdate()))&& !"".equals(Utility.getName(adcostPricePo.getCpraceffectiveenddate()))) {
			sb.append(" and convert(varchar(10), C_PR_AC_effectiveDate, 23) <= ? ");
			params.add(adcostPricePo.getCpraceffectiveenddate());
			
		}
		
		//审核人
		if (!"".equals(Utility.getName(adcostPricePo.getCpracauditperson()))) {
			sb.append(" and C_PR_AC_auditPerson = ? ");
			params.add(adcostPricePo.getCpracauditperson());
		}

		
		//审核状态
		if (!"".equals(Utility.getName(adcostPricePo.getCpracauditstate()))) {
			sb.append(" and c_pr_ac_auditstate = ? ");
			params.add(adcostPricePo.getCpracauditstate());
		}

		//生效状态
		if (!"".equals(Utility.getName(adcostPricePo.getCpraceffectivestate()))) {
			sb.append(" and c_pr_ac_effectivestate = ? ");
			params.add(adcostPricePo.getCpraceffectivestate());
		}
		
		sb.append("  ) temp where rowNum > " + start + " and rowNum <= " + countPage);

		sb.append(" set rowcount 0");

		return getJdbcTemplate().queryForList(sb.toString(), params.toArray());
	}
	
	/**
	 * 新增调价单
	 */
	public void adcostPriceInsert(AdcostPricePo adcostPricePo) {
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb1.append("INSERT INTO C_PR_AdcostPrice(C_PR_AC_billID");
		if (!Utility.getName(adcostPricePo.getCpraceffectivedate()).equals("")) {
			sb1.append(",C_PR_AC_effectiveDate");
		}		
		sb1.append(",C_PR_AC_createPerson");
		sb1.append(",C_PR_AC_createDate");
		sb1.append(",C_PR_AC_AuditState");
		sb1.append(",C_PR_AC_effectiveState,C_PR_AC_Flag,C_PR_AC_SupplierID,C_PR_AC_BrandID");		
		if (!Utility.getName(adcostPricePo.getCpraceffectivedate()).equals("")) {
			sb2.append(" VALUES(?,?,?,getdate(),?,?,?,?,?");
		}else{
			sb2.append(" VALUES(?,?,getdate(),?,?,?,?,?");
		}
		
		params.add(adcostPricePo.getCpracbillid());		
		if (!Utility.getName(adcostPricePo.getCpraceffectivedate()).equals("")) {
			params.add(Utility.getName(adcostPricePo.getCpraceffectivedate()));
		}
		params.add(adcostPricePo.getCpraccreateperson());
		params.add(adcostPricePo.getCpracauditstate());	
		
		params.add(Utility.getName(adcostPricePo.getCpraceffectivestate()));
		params.add(adcostPricePo.getCprapflag());
		params.add(Utility.getName(adcostPricePo.getCpracsupplierid()));
		params.add(Utility.getName(adcostPricePo.getCpracbrandid()));
		if ("1".equals(adcostPricePo.getCpracauditstate())) {
			sb1.append(",C_PR_AC_AuditPerson");
			sb1.append(",C_PR_AC_AuditDate");
			sb2.append(",?");
			sb2.append(",getdate()");
			params.add(adcostPricePo.getCpracauditperson());
		}
		if (adcostPricePo.getCpracremark() != null) {
			sb1.append(",C_PR_AC_remark");
			sb2.append(",?");
			params.add(adcostPricePo.getCpracremark());
		}
		getJdbcTemplate().update(sb1.toString() + ")" + sb2.toString() + ")",params.toArray());
	}

	/**
	 * 新增调价明细
	 */
	public void adcostPriceEntryInsert(AdcostPriceEntryPo adcostPriceEntryPo) {
		// TODO Auto-generated method stub
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb1.append("INSERT INTO C_PR_AdcostPriceEntry (C_PR_ACE_ID ");
		sb1.append(",C_PR_ACE_billID ");
		sb1.append(",C_PR_ACE_goodsID ");
		sb1.append(",C_PR_ACE_barCode ");
		sb1.append(",C_PR_ACE_goodsName ");
		sb1.append(",C_PR_ACE_costPrice ");
		sb1.append(",C_PR_ACE_AdPrice ");
		sb2.append("VALUES(?,?,?,?,?,?,?");
		
		params.add(this.uuid.generate());
		params.add(adcostPriceEntryPo.getCpracebillid());
		params.add(adcostPriceEntryPo.getCpracegoodsid());
		params.add(adcostPriceEntryPo.getCpracegoodsbarcode());
		params.add(adcostPriceEntryPo.getCpracegoodsname());
		params.add(adcostPriceEntryPo.getCpracecostprice());
		params.add(adcostPriceEntryPo.getCpraceadprice());
		
		getJdbcTemplate().update(sb1.toString() + ")" + sb2.toString() + ")",
				params.toArray());
	}
	
	/**
	 * 删除调价单
	 */
	public void adcostPriceDelete(AdcostPricePo adcostPricePo) {
		// TODO Auto-generated method stub
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("delete from C_PR_AdcostPrice ");
		
		List<String> params = new ArrayList<String>();
		
		if (!"".equals(adcostPricePo.getCpracbillid())) {
			sb.append("where C_PR_AC_billID = ? ");
			params.add(adcostPricePo.getCpracbillid());
		}

		getJdbcTemplate().update(sb.toString(), params.toArray());
		
	}

	/**
	 * 删除调价明细
	 */
	public void adcostPriceEntryDelete(AdcostPricePo adcostPricePo) {
		// TODO Auto-generated method stub
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("delete from C_PR_AdcostPriceEntry ");
		
		List<String> params = new ArrayList<String>();
		
		if (!"".equals(adcostPricePo.getCpracbillid())) {
			sb.append("where C_PR_ACE_billID = ? ");
			params.add(adcostPricePo.getCpracbillid());
		}
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
		
	}
	
	/**
	 * 修改调价单
	 */
	public void adcostPriceUpdate(AdcostPricePo adcostPricePo) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("UPDATE C_PR_AdcostPrice");
		sb.append(" SET ");
		sb.append(" C_PR_AC_Flag = ?");		
		sb.append(",C_PR_AC_remark = ?");
		sb.append(",C_PR_AC_SupplierID = ?");		
		sb.append(",C_PR_AC_BrandID = ?");
		params.add(adcostPricePo.getCprapflag());		
		params.add(adcostPricePo.getCpracremark());
		params.add(Utility.getName(adcostPricePo.getCpracsupplierid()));		
		params.add(Utility.getName(adcostPricePo.getCpracbrandid()));
		if (!Utility.getName(adcostPricePo.getCpraceffectivedate()).equals("")) {
			sb.append(" ,C_PR_AC_effectiveDate = ?");
			params.add(Utility.getName(adcostPricePo.getCpraceffectivedate()));
		}else{
			sb.append(" ,C_PR_AC_effectiveDate = NULL ");
		}
		if("1".equals(adcostPricePo.getCpracauditstate())){
			sb.append(" ,C_PR_AC_AuditPerson = ?");
			sb.append(" ,C_PR_AC_AuditDate = getdate()");
			sb.append(",C_PR_AC_AuditState = ?");
			sb.append(",C_PR_AC_effectiveState = ? ");
			
			params.add(Utility.getName(adcostPricePo.getCpracauditperson()));
			params.add("1");
			params.add(Utility.getName(adcostPricePo.getCpraceffectivestate()));
		}
		
		sb.append(" where C_PR_AC_billID=?");
		params.add(adcostPricePo.getCpracbillid());
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}

	/**
	 * 获得调价单实体类
	 */
	public AdcostPricePo getAdcostPrice(AdcostPricePo adcostPricePo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		
		sb.append("select top 1 temp.cpracremark , temp.cpracauditstate , ");
		sb.append("datediff(dd,getdate() , cpraceffectivedate) as cpraceffecticestate , ");
		sb.append("temp.cpracbillid , temp.cpraceffectivedate , ");
		sb.append("temp.cpraccreatedate , temp.cpraccreatePerson ,temp.cpracbrandid,temp.cpracsupplierid,temp.cpracbrandidname,temp.cpracsupplieridname, ");
		sb.append("temp.cpracauditPerson , temp.cpraccreatePersonname , ");
		sb.append("temp.cpracauditPersonname,temp.cprapflag from( ");
		sb.append("select ROW_NUMBER() Over(order by C_PR_AdcostPrice.C_PR_AC_createDate desc , ");
		sb.append("C_PR_AdcostPrice.C_PR_AC_billID desc) as rowNum , ");
		
		sb.append("c_pr_ac_remark as cpracremark ,C_PR_AC_SupplierID as cpracsupplierid,C_PR_AC_BrandID as cpracbrandid, ");
		sb.append("(select B_SP_SupplierName from B_Supplier where B_SP_ID= C_PR_AC_SupplierID) as cpracsupplieridname, ");
		sb.append("(select B_BD_brandName from B_Brand where B_BD_SupplierID= C_PR_AC_SupplierID and B_BD_ID=C_PR_AC_BrandID) as cpracbrandidname , ");
		sb.append("c_pr_ac_auditstate as cpracauditstate , ");
		sb.append("c_pr_ac_billid as cpracbillid , ");
		sb.append("C_PR_AC_effectiveDate as cpraceffectivedate , ");
		sb.append("C_PR_AC_createdate as cpraccreatedate , ");
		sb.append("C_PR_AC_createPerson as cpraccreatePerson , ");
		sb.append("a.personname as cpraccreatepersonname , ");
		sb.append("C_PR_AC_auditPerson as cpracauditperson , ");
		sb.append("b.personname as cpracauditpersonname,isnull(C_PR_AC_Flag,'0') as cprapflag ");
		sb.append("from C_PR_AdcostPrice ");
		sb.append("left join (select ID,personName from SYS_PersonInfo) a ");
		sb.append("	on C_PR_AdcostPrice.C_PR_AC_createPerson=a.id ");
		sb.append("left join (select id,personname from sys_personinfo) b ");
		sb.append("	on C_PR_AdcostPrice.C_PR_AC_auditPerson=b.id ) temp ");
		sb.append("where temp.cpracbillid = ? ");
		
		List<String> params = new ArrayList<String>();
		
		params.add(adcostPricePo.getCpracbillid());
		
		return (AdcostPricePo) this.queryForObject(sb.toString(), params.toArray(), AdcostPricePo.class);
	}
	
	/**
	 * 获取调价单明细List
	 */
	public List<AdcostPriceEntryPo> getAdcostPriceEntryList(AdcostPricePo adcostPricePo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		
		sb.append("SELECT C_PR_ACE_ID as cpraceid ");
		sb.append(", C_PR_ACE_billID as cpracebillid ");
		sb.append(", C_PR_ACE_goodsID as cpracegoodsid ");
		sb.append(", C_PR_ACE_barCode as cpracegoodsbarcode ");
		sb.append(", C_PR_ACE_goodsName as cpracegoodsname ");
		sb.append(", C_PR_ACE_costPrice as cpracecostprice ");
		sb.append(", C_PR_ACE_AdPrice as cpraceadprice ");
		sb.append(", B_BD_brandName as cpracebrandname ");
		sb.append(", b_gi_spec as cpracespec ");
		sb.append("FROM C_PR_AdcostPriceEntry ");
		sb.append("inner join b_goodsinfo on b_gi_goodsid = C_PR_ACE_goodsID ");
		sb.append("inner join b_supplier on b_gi_supplierid = B_SP_ID ");
		sb.append("inner join b_brand on b_gi_brandid = B_BD_ID and B_BD_SupplierID = B_SP_ID ");
		sb.append("where C_PR_ACE_billID = ? ");
		
		List<String> params = new ArrayList<String>();
		params.add(adcostPricePo.getCpracbillid());
		
		return getJdbcTemplate().queryForList(sb.toString(), params.toArray());
	}
	/**
	 * 得到调价明细信息表体
	 * @param adcostPricePo
	 * @return
	 */
	public List<AdcostPriceEntryPo> getAdcostPriceEntryList(BrandPo brandPo){
		
		StringBuffer sb = new StringBuffer();
		
		List<String> params = new ArrayList<String>();
		
		sb.append("select B_GI_GoodsID as cpracegoodsid,B_GI_GoodsBarCode as cpracegoodsbarcode,B_GI_ViewGoodsName as cpracegoodsname,B_GI_CostPrice as cpracecostprice,");
		sb.append("? as cpracebillid,? as cpraceadprice ");
		sb.append(" from B_GoodsInfo inner join B_Supplier on B_SP_ID=B_GI_SupplierID ");
		sb.append("inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID where 1=1 ");
		sb.append("and B_GI_GoodsCategoryID=? and B_GI_SupplierID=? and B_GI_BrandID=? ");
		sb.append("and B_GI_CostPrice=? ");
		
		params.add(brandPo.getBbdremark());
		params.add(brandPo.getBbdmaxretailPrice());
		params.add(brandPo.getBspcategoryid());
		params.add(brandPo.getBbdsupplierid());
		params.add(brandPo.getBbdid());
		params.add(brandPo.getBbdcostprice());

		return queryForObjectList(sb.toString(), params.toArray(),AdcostPriceEntryPo.class);
	}
}
