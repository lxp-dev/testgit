package com.pengsheng.eims.components.dao;

import java.util.List;

import com.pengsheng.eims.basic.dao.impl.TechnologyTypePo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.basic.persistence.VarietyPo;

public interface VarietyDao {

	/**
	 * 得到品种
	 * 
	 * @param varietyPo
	 * @return
	 */
	public VarietyPo getVarietyPo(VarietyPo varietyPo);

	/**
	 * 取所有品种
	 * 
	 * @param varietyPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<VarietyPo> getVarietys(VarietyPo varietyPo, int start, int size);

	/**
	 * 品种总数
	 * 
	 * @param varietyPo
	 * @return
	 */
	public int getVarietysCount(VarietyPo varietyPo);

	/**
	 * 增加品种
	 * 
	 * @param varietyPo
	 */
	public void insertVariety(VarietyPo varietyPo);
	/**
	 * 更新品种
	 * 
	 * @param varietyPo
	 */
	public void updateVariety(VarietyPo varietyPo);

	/**
	 * 删除品种
	 * 
	 * @param varietyPo
	 *            品种
	 */
	public void delVariety(VarietyPo varietyPo);

	/**
	 * 取商品类别集合
	 * 
	 * @return
	 */
	public List<GoodsCategoryPo> getGoodsCategorys();
	
	/**
	 * 取工艺类型 quyanping
	 */
	public List<TechnologyTypePo> getTechnologyType();
	
	/**
	 * 品种使用率
	 * @param goodsInfoPo
	 * @return
	 */
	public int getGoodsInfos(GoodsInfoPo goodsInfoPo);
	
	/**
	 * 查询透视分析表的总行数
	 * 
	 * @return
	 */
	public int getSalesGoodsCount(GoodsInfoPo goodsInfoPo);
	
	/**
	 * 查询透视分析表数据
	 * 
	 * @return
	 */
	public List<GoodsInfoPo> getSalesGoodsList(GoodsInfoPo goodsInfoPo, int start, int size);
	
	/**
	 * 按部门查询透视分析表数据
	 * 
	 * @return
	 */
	public List<GoodsInfoPo> getSalesGoodsByDepartment(GoodsInfoPo goodsInfoPo);
	
	/**
	 * 查询所有销售门店
	 * 
	 * @return
	 */
	public List<DepartmentsPo> getSalesDepartmentList();
}
