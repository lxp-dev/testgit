package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.storage.dao.WholesalePriceDao;
import com.pengsheng.eims.storage.persistence.StrogeLogPo;
import com.pengsheng.eims.storage.persistence.WholesalePriceEntryPo;
import com.pengsheng.eims.storage.persistence.WholesalePricePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class WholesalePriceDaoImpl extends BaseJdbcDaoSupport implements
		WholesalePriceDao {

	
	public void wholesalePriceDelete(WholesalePricePo wholesalePricePo) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("delete from C_PR_WholesalePrice ");
		List<String> params = new ArrayList<String>();
		if (!"".equals(wholesalePricePo.getCprwpbillid())) {
			sb.append("where C_PR_WP_billID=?");
			params.add(wholesalePricePo.getCprwpbillid());
		}
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public void wholesalePriceInsert(WholesalePricePo wholesalePricePo) {
		
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb1.append("INSERT INTO C_PR_WholesalePrice(C_PR_WP_billID");
		if (!Utility.getName(wholesalePricePo.getCprwpeffectivedate()).equals("")) {
			sb1.append(",C_PR_WP_effectiveDate");
		}		
		sb1.append(",C_PR_WP_createPerson");
		sb1.append(",C_PR_WP_createDate");
		sb1.append(",C_PR_WP_AuditState");
		sb1.append(",C_PR_WP_effectiveState,C_PR_WP_Flag,C_PR_WP_SupplierID,C_PR_WP_BrandID");		
		if (!Utility.getName(wholesalePricePo.getCprwpeffectivedate()).equals("")) {
			sb2.append(" VALUES(?,?,?,getdate(),?,?,?,?,?");
		}else{
			sb2.append(" VALUES(?,?,getdate(),?,?,?,?,?");
		}
		
		params.add(wholesalePricePo.getCprwpbillid());		
		if (!Utility.getName(wholesalePricePo.getCprwpeffectivedate()).equals("")) {
			params.add(Utility.getName(wholesalePricePo.getCprwpeffectivedate()));
		}
		params.add(wholesalePricePo.getCprwpcreateperson());
		params.add(wholesalePricePo.getCprwpauditstate());	
		
		params.add(Utility.getName(wholesalePricePo.getCprwpeffectiveState()));
		params.add(wholesalePricePo.getCprwpflag());
		params.add(Utility.getName(wholesalePricePo.getCprwpsupplierid()));
		params.add(Utility.getName(wholesalePricePo.getCprwpbrandid()));
		if ("1".equals(wholesalePricePo.getCprwpauditstate())) {
			sb1.append(",C_PR_WP_AuditPerson");
			sb1.append(",C_PR_WP_AuditDate");
			sb2.append(",?");
			sb2.append(",getdate() ");
			params.add(wholesalePricePo.getCprwpauditperson());
		}
		if (wholesalePricePo.getCprwpremark() != null) {
			sb1.append(",C_PR_WP_remark");
			sb2.append(",?");
			params.add(wholesalePricePo.getCprwpremark());
		}
		
		getJdbcTemplate().update(sb1.toString() + ")" + sb2.toString() + ")",params.toArray());

	}

	
	public void wholesalePriceUpdate(WholesalePricePo wholesalePricePo) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("UPDATE C_PR_WholesalePrice");
		sb.append(" SET ");
		sb.append(" C_PR_WP_Flag = ?");		
		sb.append(",C_PR_WP_remark = ?");
		sb.append(",C_PR_WP_SupplierID = ?");		
		sb.append(",C_PR_WP_BrandID = ?");
		params.add(wholesalePricePo.getCprwpflag());		
		params.add(wholesalePricePo.getCprwpremark());
		params.add(Utility.getName(wholesalePricePo.getCprwpsupplierid()));		
		params.add(Utility.getName(wholesalePricePo.getCprwpbrandid()));
		if (!Utility.getName(wholesalePricePo.getCprwpeffectivedate()).equals("")) {
			sb.append(" ,C_PR_WP_effectiveDate = ?");
			params.add(wholesalePricePo.getCprwpeffectivedate());
		}else{
			sb.append(" ,C_PR_WP_effectiveDate = NULL ");
		}
		if("1".equals(wholesalePricePo.getCprwpauditstate())){
			sb.append(" ,C_PR_WP_AuditPerson = ?");
			sb.append(" ,C_PR_WP_AuditDate = getdate()");
			sb.append(",C_PR_WP_AuditState = ?");
			sb.append(",C_PR_WP_effectiveState = ? ");
			
			params.add(wholesalePricePo.getCprwpauditperson());		
			params.add("1");
			params.add(wholesalePricePo.getCprwpeffectiveState());
		}
		
		sb.append(" where C_PR_WP_billID=?");
		params.add(wholesalePricePo.getCprwpbillid());
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}

	
	public void wholesalePriceEntryInsert(
			WholesalePriceEntryPo wholesalePriceEntryPo) {
		
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb1.append("INSERT INTO C_PR_WholesalePriceEntry(C_PR_WPE_ID");
		sb1.append(",C_PR_WPE_billID");
		sb1.append(",C_PR_WPE_goodsID");
		sb1.append(",C_PR_WPE_barCode");
		sb1.append(",C_PR_WPE_goodsName");
		sb1.append(",C_PR_WPE_costPrice");
		sb1.append(",C_PR_WPE_AdPrice");
		sb2.append("VALUES(?,?,?,?,?,?,?");
		params.add(this.uuid.generate());
		params.add(wholesalePriceEntryPo.getCprwpebillid());
		params.add(wholesalePriceEntryPo.getCprwpegoodsid());
		params.add(wholesalePriceEntryPo.getCprwpegoodsbarcode());
		params.add(wholesalePriceEntryPo.getCprwpegoodsname());
		params.add(wholesalePriceEntryPo.getCprwpecostprice());
		params.add(wholesalePriceEntryPo.getCprwpeadprice());
		getJdbcTemplate().update(sb1.toString() + ")" + sb2.toString() + ")",
				params.toArray());
	}

	
	public int getWholesalePriceCount(WholesalePricePo wholesalePricePo) {
		StringBuffer sb = new StringBuffer();
		//TODO add by ZK query for goodsName
		sb.append("  SELECT COUNT(C_PR_WP_billID) FROM ( ");
		sb.append("select C_PR_WholesalePrice.C_PR_WP_billID from C_PR_WholesalePrice ");
		sb.append(" INNER JOIN C_PR_WholesalePriceEntry ON C_PR_WholesalePriceEntry.C_PR_WPE_billID = C_PR_WP_billID ");
		sb.append(" where 1=1 ");

		List<String> params = new ArrayList<String>();
		
		if(!"".equals(wholesalePricePo.getGoodsName())) {
			sb.append(" AND C_PR_WPE_goodsName LIKE '%' + ? + '%' ");
			params.add(wholesalePricePo.getGoodsName());
		}
		
		if (!"".equals(Utility.getName(wholesalePricePo.getCprwpbillid()))) {
			sb.append(" and C_PR_WP_billID like ? ");
			params.add("%"+wholesalePricePo.getCprwpbillid()+"%");
		}

		if (!"".equals(Utility
				.getName(wholesalePricePo.getCprwpcreateperson()))) {
			sb.append(" and C_PR_WP_createperson=? ");
			params.add(wholesalePricePo.getCprwpcreateperson());
		}

		if (!"".equals(Utility.getName(wholesalePricePo
				.getCprwpcreatestartdate()))
				&& !"".equals(Utility.getName(wholesalePricePo
						.getCprwpcreateenddate()))) {
			sb.append(" and convert(varchar(10), C_PR_WP_createDate, 23) >= ? ");
			params.add(wholesalePricePo.getCprwpcreatestartdate());
			sb.append(" and convert(varchar(10), C_PR_WP_createDate, 23) <= ? ");
			params.add(wholesalePricePo.getCprwpcreateenddate());
		} else if (!"".equals(Utility.getName(wholesalePricePo
				.getCprwpcreatestartdate()))
				&& "".equals(Utility.getName(wholesalePricePo
						.getCprwpcreateenddate()))) {
			sb.append(" and convert(varchar(10), C_PR_WP_createDate, 23) >= ? ");
			params.add(wholesalePricePo.getCprwpcreatestartdate());

		} else if ("".equals(Utility.getName(wholesalePricePo
				.getCprwpcreatestartdate()))
				&& !"".equals(Utility.getName(wholesalePricePo
						.getCprwpcreateenddate()))) {
			sb.append(" and convert(varchar(10), C_PR_WP_createDate, 23) <= ? ");
			params.add(wholesalePricePo.getCprwpcreateenddate());
		}

		if (!"".equals(Utility.getName(wholesalePricePo
				.getCprwpeffectivedate()))
				&& !"".equals(Utility.getName(wholesalePricePo
						.getCprwpeffectivedate()))) {
			sb
					.append(" and convert(varchar(10), C_PR_WP_effectiveDate, 23) >= ? ");
			params.add(wholesalePricePo.getCprwpeffectivedate());
			sb
					.append(" and convert(varchar(10), C_PR_WP_effectiveDate, 23) <= ? ");
			params.add(wholesalePricePo.getCprwpeffectivedate());
		} else if (!"".equals(Utility.getName(wholesalePricePo
				.getCprwpeffectivedate()))
				&& "".equals(Utility.getName(wholesalePricePo
						.getCprwpeffectivedate()))) {
			sb
					.append(" and convert(varchar(10), C_PR_WP_effectiveDate, 23) >= ? ");
			params.add(wholesalePricePo.getCprwpcreatedate());

		} else if ("".equals(Utility.getName(wholesalePricePo
				.getCprwpeffectivedate()))
				&& !"".equals(Utility.getName(wholesalePricePo
						.getCprwpeffectivedate()))) {
			sb
					.append(" and convert(varchar(10), C_PR_WP_effectiveDate, 23) <= ? ");
			params.add(wholesalePricePo.getCprwpeffectivedate());
		}

		if (!""
				.equals(Utility
						.getName(wholesalePricePo.getCprwpauditperson()))) {
			sb.append(" and C_PR_WP_auditperson=? ");
			params.add(wholesalePricePo.getCprwpauditperson());
		}

		if (!"".equals(Utility.getName(wholesalePricePo.getCprwpauditstate()))) {
			sb.append(" and C_PR_WP_auditstate=? ");
			params.add(wholesalePricePo.getCprwpauditstate());
		}

		if (!"".equals(Utility.getName(wholesalePricePo
				.getCprwpeffectivestate()))) {
			sb.append(" and C_PR_WP_effectivestate=? ");
			params.add(wholesalePricePo.getCprwpeffectivestate());
		}
		
		sb.append("  GROUP BY C_PR_WP_billID ) AS t1 ");

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	
	public List<WholesalePricePo> getWholesalePriceList(
			WholesalePricePo wholesalePricePo, int start, int size) {
		
		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		
		sb.append("select temp.cprwpremark,temp.cprwpauditstate,temp.cprwpeffectivestate,temp.cprwpbillid,temp.cprwpeffectivedate,temp.cprwpcreatedate,temp.cprwpcreatePerson,temp.cprwpauditPerson,temp.cprwpcreatePersonname,temp.cprwpauditPersonname,temp.cprwpremark from");
		sb.append("(select ROW_NUMBER() Over(order by C_PR_WholesalePrice.C_PR_WP_createDate desc)");
		sb.append(" as rowNum,c_pr_wp_effectivestate as cprwpeffectivestate,c_pr_wp_remark as cprwpremark,c_pr_wp_auditstate as cprwpauditstate,c_pr_wp_billid as cprwpbillid,C_PR_WP_effectiveDate as cprwpeffectivedate,C_PR_WP_createdate as cprwpcreatedate,C_PR_WP_createPerson as cprwpcreatePerson,a.personname as cprwpcreatePersonname,C_PR_WP_auditPerson as cprwpauditPerson ");
		sb.append(", b.personname as cprwpauditPersonname from C_PR_WholesalePrice");
		sb.append(" left join (select ID,personName from SYS_PersonInfo) a on C_PR_WholesalePrice.C_PR_WP_createPerson=a.id");
		sb.append(" left join (select id,personname from sys_personinfo) b on C_PR_WholesalePrice.C_PR_WP_auditPerson=b.id");
		
		List<String> params = new ArrayList<String>();
		
		//add by ZK query for goodsName
		if(!"".equals(wholesalePricePo.getGoodsName())) {
			sb.append(" INNER JOIN C_PR_WholesalePriceEntry ON C_PR_WholesalePriceEntry.C_PR_WPE_billID = C_PR_WP_billID ");
			sb.append(" WHERE C_PR_WPE_goodsName LIKE '%' + ? + '%' ");
			params.add(wholesalePricePo.getGoodsName());
			sb.append(" GROUP BY c_pr_wp_effectivestate,c_pr_wp_remark,c_pr_wp_auditstate,c_pr_wp_billid,C_PR_WP_effectiveDate, ");
			sb.append(" C_PR_WP_createdate,C_PR_WP_createPerson,a.personname,C_PR_WP_auditPerson,b.personname ");
		}
		
		sb.append("  ) temp where rowNum > " + start + " and rowNum <= " + countPage);


		if (!"".equals(Utility.getName(wholesalePricePo.getCprwpbillid()))) {
			sb.append(" and temp.cprwpbillid like ? ");
			params.add("%"+wholesalePricePo.getCprwpbillid()+"%");
		}

		if (!"".equals(Utility.getName(wholesalePricePo.getCprwpcreateperson()))) {
			sb.append(" and temp.cprwpcreateperson=? ");
			params.add(wholesalePricePo.getCprwpcreateperson());
		}
		if (!"".equals(Utility.getName(wholesalePricePo.getCprwpeffectivestartdate()))&& !"".equals(Utility.getName(wholesalePricePo.getCprwpeffectiveenddate()))) {
			sb
					.append(" and convert(varchar(10), temp.CPRWPeffectiveDate, 23) >= ? ");
			sb
					.append(" and convert(varchar(10), temp.CPRWPeffectiveDate, 23) <= ? ");

			params.add(wholesalePricePo.getCprwpeffectivestartdate());
			params.add(wholesalePricePo.getCprwpeffectiveenddate());
		} else if (!"".equals(Utility.getName(wholesalePricePo
				.getCprwpeffectivestartdate()))
				&& "".equals(Utility.getName(wholesalePricePo
						.getCprwpeffectiveenddate()))) {
			sb
					.append(" and convert(varchar(10), temp.CPRAPeffectiveDate, 23) >= ? ");
			params.add(wholesalePricePo.getCprwpeffectivestartdate());

		} else if ("".equals(Utility.getName(wholesalePricePo
				.getCprwpeffectivestartdate()))
				&& !"".equals(Utility.getName(wholesalePricePo
						.getCprwpeffectiveenddate()))) {
			sb
					.append(" and convert(varchar(10), temp.CPRAPeffectiveDate, 23) <= ? ");
			params.add(wholesalePricePo.getCprwpeffectiveenddate());
		}

		if (!"".equals(Utility.getName(wholesalePricePo
				.getCprwpcreatestartdate()))
				&& !"".equals(Utility.getName(wholesalePricePo
						.getCprwpcreateenddate()))) {
			sb
					.append(" and convert(varchar(10), temp.cprwpcreatedate, 23) >= ? ");
			params.add(wholesalePricePo.getCprwpcreatestartdate());
			sb
					.append(" and convert(varchar(10), temp.cprwpcreatedate, 23) <= ? ");
			params.add(wholesalePricePo.getCprwpcreateenddate());
		} else if (!"".equals(Utility.getName(wholesalePricePo
				.getCprwpcreatestartdate()))
				&& "".equals(Utility.getName(wholesalePricePo
						.getCprwpcreateenddate()))) {
			sb
					.append(" and convert(varchar(10), temp.cprwpcreatedate, 23) >= ? ");
			params.add(wholesalePricePo.getCprwpcreatestartdate());

		} else if ("".equals(Utility.getName(wholesalePricePo
				.getCprwpcreatestartdate()))
				&& !"".equals(Utility.getName(wholesalePricePo
						.getCprwpcreateenddate()))) {
			sb
					.append(" and convert(varchar(10), temp.cprwpcreatedate, 23) <= ? ");
			params.add(wholesalePricePo.getCprwpcreateenddate());
		}

		if (!"".equals(Utility
						.getName(wholesalePricePo.getCprwpauditperson()))) {
			sb.append(" and temp.cprwpauditPerson=? ");
			params.add(wholesalePricePo.getCprwpauditperson());
		}

		if (!"".equals(Utility.getName(wholesalePricePo.getCprwpauditstate()))) {
			sb.append(" and temp.cprwpauditstate=? ");
			params.add(wholesalePricePo.getCprwpauditstate());
		}

		if (!"".equals(Utility.getName(wholesalePricePo
				.getCprwpeffectivestate()))) {
			sb.append(" and temp.cprwpeffectivestate=? ");
			params.add(wholesalePricePo.getCprwpeffectivestate());
		}

		sb.append(" set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),WholesalePricePo.class);
	}

	
	public void wholesalePriceEntryDelete(WholesalePricePo wholesalePricePo) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("delete from C_PR_WholesalePriceEntry ");
		List<String> params = new ArrayList<String>();
		if (!"".equals(wholesalePricePo.getCprwpbillid())) {
			sb.append(" where C_PR_WPE_billID=?");
			params.add(wholesalePricePo.getCprwpbillid());
		}
		getJdbcTemplate().update(sb.toString(), params.toArray());

	}

	public WholesalePricePo getWholesalePrice(
			WholesalePricePo wholesalePricePo) {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("select top 1  temp.cprwpremark,temp.cprwpauditstate,datediff(dd,getdate(),cprwpeffectivedate) as cprwpeffecticestate,temp.cprwpbrandid,temp.cprwpsupplierid,temp.cprwpsupplieridname,temp.cprwpbillid,temp.cprwpeffectivedate,temp.cprwpcreatedate,temp.cprwpcreatePerson,temp.cprwpauditPerson,temp.cprwpcreatePersonname,temp.cprwpbrandidname,temp.cprwpauditPersonname,temp.cprwpflag from");
		sb.append("(select ROW_NUMBER() Over(order by C_PR_WholesalePrice.C_PR_WP_createDate desc,C_PR_WholesalePrice.C_PR_WP_billID desc)");
		sb.append(" as rowNum,c_pr_wp_remark as cprwpremark ,C_PR_WP_SupplierID as cprwpsupplierid,C_PR_WP_BrandID as cprwpbrandid,c_pr_wp_auditstate as cprwpauditstate,c_pr_wp_billid as cprwpbillid,C_PR_WP_effectiveDate as cprwpeffectivedate,C_PR_WP_createdate as cprwpcreatedate,C_PR_WP_createPerson as cprwpcreatePerson,a.personname as cprwpcreatePersonname,C_PR_WP_auditPerson as cprwpauditPerson ");
		sb.append(", b.personname as cprwpauditPersonname ,(select B_SP_SupplierName from B_Supplier where B_SP_ID= C_PR_WP_SupplierID) as cprwpsupplieridname,(select B_BD_brandName from B_Brand where B_BD_SupplierID= C_PR_WP_SupplierID and B_BD_ID=C_PR_WP_BrandID) as cprwpbrandidname ,isnull(C_PR_WP_Flag,'0') as cprwpflag  from  C_PR_WholesalePrice");
		sb.append(" left join (select ID,personName from SYS_PersonInfo) a on C_PR_WholesalePrice.C_PR_WP_createPerson=a.id");
		sb.append(" left join (select id,personname from sys_personinfo) b on C_PR_WholesalePrice.C_PR_WP_auditPerson=b.id ) temp");
		sb.append(" where temp.cprwpbillid=?");
		
		List<String> params = new ArrayList<String>();
		params.add(wholesalePricePo.getCprwpbillid());
		return (WholesalePricePo) this.queryForObject(sb.toString(), params
				.toArray(), WholesalePricePo.class);
	}

	public List<WholesalePriceEntryPo> getWholesalePriceEntryList(
			WholesalePricePo wholesalePricePo) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("SELECT C_PR_WPE_ID as cprwpeid");
		sb.append(" ,C_PR_WPE_billID as cprwpebillid");
		sb.append(" ,C_PR_WPE_goodsID as cprwpegoodsid");
		sb.append(" ,C_PR_WPE_barCode as cprwpegoodsbarcode");
		sb.append(" ,C_PR_WPE_goodsName as cprwpegoodsname");
		sb.append(" ,C_PR_WPE_costPrice as cprwpecostprice");
		sb.append(" ,C_PR_WPE_AdPrice as cprwpeadprice");
		sb.append(" ,B_BD_brandName as cprwpebbdbrandname");
		sb.append(" ,b_gi_spec as cprwpebbdspec");
		sb.append(" FROM C_PR_WholesalePriceEntry ");
		sb.append(" inner join b_goodsinfo on b_gi_goodsid=C_PR_WPE_goodsID");
		sb.append(" inner join b_supplier on b_gi_supplierid=B_SP_ID");
		sb.append(" inner join b_brand on b_gi_brandid=B_BD_ID and B_BD_SupplierID=B_SP_ID");
		sb.append(" where C_PR_WPE_billID=?");
		
		List<String> params = new ArrayList<String>();
		params.add(wholesalePricePo.getCprwpbillid());
		return getJdbcTemplate().queryForList(sb.toString(), params.toArray());
	}
	/**
	 * 获取批发调价单明细List
	 */
	public List<WholesalePriceEntryPo> getWholesalePriceEntryList(BrandPo brandPo){
		StringBuffer sb = new StringBuffer();
		
		List<String> params = new ArrayList<String>();
		
		sb.append("select B_GI_GoodsID as cprwpegoodsid,B_GI_GoodsBarCode as cprwpegoodsbarcode,B_GI_ViewGoodsName as cprwpegoodsname,B_GI_WholesalePrice as cprwpecostprice,");
		sb.append("? as cprwpebillid,? as cprwpeadprice ");
		sb.append(" from B_GoodsInfo inner join B_Supplier on B_SP_ID=B_GI_SupplierID ");
		sb.append("inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID where 1=1 ");
		sb.append("and B_GI_GoodsCategoryID=? and B_GI_SupplierID=? and B_GI_BrandID=? ");
		sb.append("and isnull(B_GI_WholesalePrice,0)=? ");
		
		params.add(brandPo.getBbdremark());
		params.add(brandPo.getBbdmaxretailPrice());
		params.add(brandPo.getBspcategoryid());
		params.add(brandPo.getBbdsupplierid());
		params.add(brandPo.getBbdid());
		params.add(brandPo.getBbdwholesaleprice());

		return queryForObjectList(sb.toString(), params.toArray(),WholesalePriceEntryPo.class);
	}
}
