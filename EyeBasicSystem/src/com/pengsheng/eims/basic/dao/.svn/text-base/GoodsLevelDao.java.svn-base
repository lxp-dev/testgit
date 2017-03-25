package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsLevelPo;


/**
 * GoodsLevelDao  商品级别
 * 
 * @author GuanZiGang
 * @version 1.0
 */
public interface GoodsLevelDao {

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 商品级别数量
	 */
	public int getGoodsLevelCount(GoodsLevelPo po);

	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 商品级别结果集
	 */
	public List<GoodsLevelPo> getGoodsLevelList(GoodsLevelPo po,int start, int size);

	/**
	 * 查询商品级别的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 商品级别详细信息
	 */
	public GoodsLevelPo getGoodsLevelPo(GoodsLevelPo po);
	/**
	 * 查询商品级别ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getGoodsLevelId(GoodsLevelPo po);
	
	/**
	 * 添加时查询商品级别名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getGoodsLevelName(GoodsLevelPo po) ;
	
	/**
	 * 修改时查询级别名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getGoodsLevelNameUpdate(GoodsLevelPo po) ;
	/**
	 * 查询商品默认折扣
	 * @param po
	 * @return
	 */
	
	public int getGoodsLevelDiscountUpdate(GoodsLevelPo po);
	
	/**
	 * 查询商品级别在goods表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getGoodsLevelWithGoods(GoodsLevelPo po);
	
	
	/**
	 * 新增商品级别
	 * 
	 * @param po 商品级别po
	 * @return void
	 */
	public void insertGoodsLevel(GoodsLevelPo po);
	
	/**
	 * 修改商品级别
	 * 
	 * @param po 商品级别po
	 * @return void
	 */
	public void updateGoodsLevel(GoodsLevelPo po);
	
	/**
	 * 删除商品级别
	 * 
	 * @param po 商品级别po
	 * @return void
	 */
	public void deleteGoodsLevel(GoodsLevelPo po);
	
	
}
