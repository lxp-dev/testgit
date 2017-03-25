package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
/**
 * mgr 接口
 */
public interface UpdateGoodsAttributeARMgr {
	public void updateGoodsAttribute(GoodsInfoPo po,String[] goodsid,LogisticsLogPo logPo) ;
}
