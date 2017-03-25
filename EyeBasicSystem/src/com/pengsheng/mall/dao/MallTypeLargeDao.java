package com.pengsheng.mall.dao;

import java.util.List;
import com.pengsheng.mall.po.MallTypeLargePo;

public interface MallTypeLargeDao {

	/**
	 * 获取商城商品类型总记录数
	 * @param po
	 * @return
	 */
	public int getMallTypeLargePoCount(MallTypeLargePo po);
	
	/**
	 * 获取商城商品类型列表
	 * @param po
	 */
	public List<MallTypeLargePo> getMallTypeLargePoList(MallTypeLargePo po, int start, int size);
	
	/**
	 * 新增商城商品类型
	 * @param po
	 * @return
	 */
	public void insertMallTypeLargePo(MallTypeLargePo po);

	/**
	 * 删除商城商品类型
	 * @param po
	 * @return
	 */
	public void deleteMallTypeLargePo(MallTypeLargePo po);

	/**
	 * 更新商城商品类型
	 * @param po
	 * @return
	 */
	public void updateMallTypeLargePo(MallTypeLargePo po);

	/**
	 * 获取商城商品类型对象
	 * @param po
	 * @return
	 */
	public MallTypeLargePo getMallTypeLargePo(MallTypeLargePo po);

	/**
	 * 获取所有商城商品类型列表
	 * @param po
	 * @return
	 */
	public List<MallTypeLargePo> getMallTypeLargePoList(MallTypeLargePo po);
}
