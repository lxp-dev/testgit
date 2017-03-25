package com.pengsheng.mall.dao;

import java.util.List;
import java.util.Map;

import com.pengsheng.mall.po.MallShoppingCartPo;

public interface MallShoppingCartDao {

	/**
	 * 获取商城购物车总记录数
	 * @param po
	 * @return
	 */
	public Map<String, Object> getMallShoppingCartPoCountByOpenID(String openID);
	
	/**
	 * 获取商城购物车列表
	 * @param po
	 */
	public List<MallShoppingCartPo> getMallShoppingCartPoListByOpenID(String openID);
	
	/**
	 * 新增商城购物车
	 * @param po
	 * @return
	 */
	public void insertMallShoppingCartPo(MallShoppingCartPo po);

	/**
	 * 删除商城购物车
	 * @param po
	 * @return
	 */
	public void deleteMallShoppingCartPo(MallShoppingCartPo po);

	/**
	 * 更新商城购物车
	 * @param po
	 * @return
	 */
	public void updateMallShoppingCartPo(MallShoppingCartPo po);

	/**
	 * 获取商城购物车对象
	 * @param po
	 * @return
	 */
	public MallShoppingCartPo getMallShoppingCartPo(MallShoppingCartPo po);
}
