package com.pengsheng.eims.quartz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.quartz.dao.AdjustmentPriceJobDao;
import com.pengsheng.eims.storage.persistence.AdjustmentPriceEntryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class AdjustmentPriceJobDaoImpl extends BaseJdbcDaoSupport implements AdjustmentPriceJobDao {

	/**
	 * 更改商品基表销售价格
	 */
	public void adjustmentPriceEffective(AdjustmentPriceEntryPo adjustmentPriceEntryPo) {

		StringBuffer sb = new StringBuffer();
		if("1".equals(adjustmentPriceEntryPo.getCprapewhichprice())){
			sb.append(" update b_goodsinfo set B_GI_RetailPrice=? where B_GI_GoodsID=? ");
		}
		if("2".equals(adjustmentPriceEntryPo.getCprapewhichprice())){
			sb.append(" update b_goodsinfo set B_GI_RetailPricea=? where B_GI_GoodsID=? ");
		}
		if("3".equals(adjustmentPriceEntryPo.getCprapewhichprice())){
			sb.append(" update b_goodsinfo set B_GI_RetailPriceb=? where B_GI_GoodsID=? ");
		}
		if("4".equals(adjustmentPriceEntryPo.getCprapewhichprice())){
			sb.append(" update b_goodsinfo set B_GI_RetailPricec=? where B_GI_GoodsID=? ");
		}
		if("5".equals(adjustmentPriceEntryPo.getCprapewhichprice())){
			sb.append(" update b_goodsinfo set B_GI_RetailPriced=? where B_GI_GoodsID=? ");
		}
		if("6".equals(adjustmentPriceEntryPo.getCprapewhichprice())){
			sb.append(" update b_goodsinfo set B_GI_RetailPricee=? where B_GI_GoodsID=? ");
		}
		if("7".equals(adjustmentPriceEntryPo.getCprapewhichprice())){
			sb.append(" update b_goodsinfo set B_GI_RetailPricef=? where B_GI_GoodsID=? ");
		}
		if("8".equals(adjustmentPriceEntryPo.getCprapewhichprice())){
			sb.append(" update b_goodsinfo set B_GI_RetailPriceg=? where B_GI_GoodsID=? ");
		}
		if("9".equals(adjustmentPriceEntryPo.getCprapewhichprice())){
			sb.append(" update b_goodsinfo set B_GI_RetailPriceh=? where B_GI_GoodsID=? ");
		}
		if("10".equals(adjustmentPriceEntryPo.getCprapewhichprice())){
			sb.append(" update b_goodsinfo set B_GI_RetailPricei=? where B_GI_GoodsID=? ");
		}
		List<String> params = new ArrayList<String>();
		params.add(adjustmentPriceEntryPo.getCprapeadprice());
		params.add(adjustmentPriceEntryPo.getCprapegoodsid());
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
		
			
	}
	
	public void updateAdjustmentPriceEffectiveFlySheet(AdjustmentPriceEntryPo adjustmentPriceEntryPo) {

		StringBuffer sb = new StringBuffer();
		if("1".equals(adjustmentPriceEntryPo.getCprapewhichprice())){
			sb.append(" update B_GoodsInfo_FlySheet set B_GI_RetailPrice=? where B_GI_GoodsID=? ");
		}
		if("2".equals(adjustmentPriceEntryPo.getCprapewhichprice())){
			sb.append(" update B_GoodsInfo_FlySheet set B_GI_RetailPricea=? where B_GI_GoodsID=? ");
		}
		if("3".equals(adjustmentPriceEntryPo.getCprapewhichprice())){
			sb.append(" update B_GoodsInfo_FlySheet set B_GI_RetailPriceb=? where B_GI_GoodsID=? ");
		}
		if("4".equals(adjustmentPriceEntryPo.getCprapewhichprice())){
			sb.append(" update B_GoodsInfo_FlySheet set B_GI_RetailPricec=? where B_GI_GoodsID=? ");
		}
		if("5".equals(adjustmentPriceEntryPo.getCprapewhichprice())){
			sb.append(" update B_GoodsInfo_FlySheet set B_GI_RetailPriced=? where B_GI_GoodsID=? ");
		}
		if("6".equals(adjustmentPriceEntryPo.getCprapewhichprice())){
			sb.append(" update B_GoodsInfo_FlySheet set B_GI_RetailPricee=? where B_GI_GoodsID=? ");
		}
		if("7".equals(adjustmentPriceEntryPo.getCprapewhichprice())){
			sb.append(" update B_GoodsInfo_FlySheet set B_GI_RetailPricef=? where B_GI_GoodsID=? ");
		}
		if("8".equals(adjustmentPriceEntryPo.getCprapewhichprice())){
			sb.append(" update B_GoodsInfo_FlySheet set B_GI_RetailPriceg=? where B_GI_GoodsID=? ");
		}
		if("9".equals(adjustmentPriceEntryPo.getCprapewhichprice())){
			sb.append(" update B_GoodsInfo_FlySheet set B_GI_RetailPriceh=? where B_GI_GoodsID=? ");
		}
		if("10".equals(adjustmentPriceEntryPo.getCprapewhichprice())){
			sb.append(" update B_GoodsInfo_FlySheet set B_GI_RetailPricei=? where B_GI_GoodsID=? ");
		}
		List<String> params = new ArrayList<String>();
		params.add(adjustmentPriceEntryPo.getCprapeadprice());
		params.add(adjustmentPriceEntryPo.getCprapegoodsid());
		
		getJdbcTemplate().update(sb.toString(),params.toArray());			
	}
	
	/**
	 * 获取生效调价单明细
	 */
	public List<AdjustmentPriceEntryPo> getAdjustmentPriceEffectiveList(String date){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select c_pr_ape_billid as cprapebillid,c_pr_ape_goodsid as cprapegoodsid,c_pr_ape_adprice as cprapeadprice,C_PR_AP_WhichPrice as cprapewhichprice from C_PR_AdjustmentPrice");
		sb.append(" inner join C_PR_AdjustmentPriceEntry");
		sb.append(" on C_PR_AdjustmentPriceEntry.c_pr_ape_billid=C_PR_AdjustmentPrice.c_pr_ap_billid ");
		sb.append(" where c_pr_ap_effectivestate='0' and c_pr_ap_auditstate='1' and convert(varchar(10),C_PR_AP_effectiveDate,120)=? and C_PR_AP_Flag='1' ");
		
		params.add(date);
		
		return this.queryForObjectList(sb.toString(),params.toArray(),AdjustmentPriceEntryPo.class);
	}
	/**
	 * 更改调价单生效状态
	 */
	public void updateEffectiveState(AdjustmentPriceEntryPo adjustmentPriceEntryPo){
		StringBuffer sb = new StringBuffer();
		sb.append("update C_PR_AdjustmentPrice set C_PR_Ap_effectiveState=1 where C_PR_Ap_billid=? ");
		List<String> params = new ArrayList<String>();
		params.add(adjustmentPriceEntryPo.getCprapebillid());
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
}
