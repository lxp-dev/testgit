package com.pengsheng.mall.mgr;

import java.util.List;

import com.pengsheng.mall.po.MallShoppingCartPo;
import com.pengsheng.mall.po.MallShoppingOrderPo;

public interface MallShoppingOrderMgr {

	/**
	 * 获取商城订单总记录数
	 * @param po
	 * @return
	 */
	public int getMallShoppingOrderPoCount(MallShoppingOrderPo po);
	
	/**
	 * 获取商城订单列表
	 * @param po
	 */
	public List<MallShoppingOrderPo> getMallShoppingOrderPoList(MallShoppingOrderPo po, int start, int size);
	
	/**
	 * 新增商城订单
	 * @param po
	 * @return
	 */
	public void insertMallShoppingOrderPo(List<MallShoppingCartPo> list);

	/**
	 * 删除商城订单
	 * @param po
	 * @return
	 */
	public void deleteMallShoppingOrderPo(MallShoppingOrderPo po);

	/**
	 * 更新商城订单
	 * @param po
	 * @return
	 */
	public void updateMallShoppingOrderPo(MallShoppingOrderPo po);

	/**
	 * 获取商城订单对象
	 * @param po
	 * @return
	 */
	public MallShoppingOrderPo getMallShoppingOrderPo(MallShoppingOrderPo po);
}
