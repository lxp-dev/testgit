package com.pengsheng.eims.quartz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.quartz.dao.AdcostPriceJobDao;
import com.pengsheng.eims.storage.persistence.AdcostPriceEntryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class AdcostPriceJobDaoImpl extends BaseJdbcDaoSupport implements AdcostPriceJobDao {

	/**
	 * 更改商品基表销售价格
	 */
	public void adcostPriceEffective(AdcostPriceEntryPo adcostPriceEntryPo) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if (Utility.getName(adcostPriceEntryPo.getCpracenottaxrate()).equals("")){
			sb.append(" update b_goodsinfo set B_GI_CostPrice = ? , B_GI_NotTaxRate =  ");
			sb.append(" (select top 1 cast(( ? / (1+cast(B_GI_TaxRate as numeric(18 , 2)) / 100)) as numeric(18 , 6)) from  b_goodsinfo where B_GI_GoodsID=? ) ");
			sb.append(" where B_GI_GoodsID = ? ");
			
			params.add(adcostPriceEntryPo.getCpraceadprice());
			params.add(adcostPriceEntryPo.getCpraceadprice());
			params.add(adcostPriceEntryPo.getCpracegoodsid());
			params.add(adcostPriceEntryPo.getCpracegoodsid());
		}else{
			sb.append(" update b_goodsinfo set B_GI_CostPrice = ? , B_GI_NotTaxRate = ? where B_GI_GoodsID = ? ");
			
			params.add(adcostPriceEntryPo.getCpraceadprice());
			params.add(Utility.getName(adcostPriceEntryPo.getCpracenottaxrate()));
			params.add(adcostPriceEntryPo.getCpracegoodsid());
		}
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}

	/**
	 * 获取生效调价单明细
	 */
	public List<AdcostPriceEntryPo> getAdcostPriceEffectiveList(String date) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select c_pr_ace_billid as cpracebillid , ");
		sb.append("c_pr_ace_goodsid as cpracegoodsid , ");
		sb.append("c_pr_ace_adprice as cpraceadprice, ");
		sb.append("cast(c_pr_ace_adprice / (1 + (cast(B_GI_TaxRate as numeric(18 , 2)) / 100)) as numeric(18 , 6)) as cpracenottaxrate ");
		sb.append("from C_PR_AdcostPrice ");
		sb.append(" inner join C_PR_AdcostPriceEntry ");
		sb.append(" on C_PR_AdcostPriceEntry.c_pr_ace_billid = C_PR_AdcostPrice.c_pr_ac_billid ");
		sb.append(" inner join B_GoodsInfo ");
		sb.append(" on B_GoodsInfo.B_GI_GoodsID = C_PR_AdcostPriceEntry.c_pr_ace_goodsid ");
		sb.append(" where c_pr_ac_effectivestate = '0' and c_pr_ac_auditstate = '1' and convert(varchar(10),C_PR_AC_effectiveDate,120) = ? and C_PR_AC_Flag='1' ");
		
		params.add(date);
		
		return this.queryForObjectList(sb.toString() , params.toArray() , AdcostPriceEntryPo.class);
		
	}

	/**
	 * 更改调价单生效状态
	 */
	public void updateEffectiveState(AdcostPriceEntryPo adcostPriceEntryPo) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("update C_PR_AdcostPrice set C_PR_AC_effectiveState = 1 where C_PR_AC_billid = ? ");
		
		List<String> params = new ArrayList<String>();
		
		params.add(adcostPriceEntryPo.getCpracebillid());
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
		
	}

}
