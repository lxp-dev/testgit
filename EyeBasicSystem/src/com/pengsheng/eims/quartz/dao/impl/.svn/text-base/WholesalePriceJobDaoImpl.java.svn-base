package com.pengsheng.eims.quartz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.quartz.dao.WholesalePriceJobDao;
import com.pengsheng.eims.storage.persistence.WholesalePriceEntryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class WholesalePriceJobDaoImpl extends BaseJdbcDaoSupport implements WholesalePriceJobDao {

	/**
	 * 更改商品基表销售价格
	 */
	public void wholesalePriceEffective(WholesalePriceEntryPo wholesalePriceEntryPo) {

		StringBuffer sb = new StringBuffer();
	
		sb.append(" update b_goodsinfo set B_GI_WholesalePrice=? where B_GI_GoodsID=? ");
		List<String> params = new ArrayList<String>();
		params.add(wholesalePriceEntryPo.getCprwpeadprice());
		params.add(wholesalePriceEntryPo.getCprwpegoodsid());
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
		
			
	}
	/**
	 * 获取生效调价单明细
	 */
	public List<WholesalePriceEntryPo> getWholesalePriceEffectiveList(String date){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select c_pr_wpe_billid as cprapebillid,c_pr_wpe_goodsid as cprapegoodsid,c_pr_wpe_adprice as cprapeadprice from C_PR_WholesalePrice");
		sb.append(" inner join C_PR_WholesalePriceEntry");
		sb.append(" on C_PR_WholesalePriceEntry.c_pr_wpe_billid=C_PR_WholesalePrice.c_pr_wp_billid ");
		sb.append(" where c_pr_wp_effectivestate='0' and c_pr_wp_auditstate='1' and convert(varchar(10),C_PR_WP_effectiveDate,120)=? and C_PR_WP_Flag='1' ");
		
		params.add(date);
		
		return this.queryForObjectList(sb.toString(),params.toArray(),WholesalePriceEntryPo.class);
	}
	/**
	 * 更改调价单生效状态
	 */
	public void updateEffectiveState(WholesalePriceEntryPo wholesalePriceEntryPo){
		StringBuffer sb = new StringBuffer();
		sb.append("update C_PR_WholesalePrice set C_PR_wp_effectiveState=1 where C_PR_wp_billid=? ");
		List<String> params = new ArrayList<String>();
		params.add(wholesalePriceEntryPo.getCprwpebillid());
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
}
