package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
/**
 * dao 接口
 */
public interface UpdateGoodsAttributeDao {
	public void updateGoodsAttribute (GoodsInfoPo po);
	public void updateGoodsAttributeNot(GoodsInfoPo po);
}
