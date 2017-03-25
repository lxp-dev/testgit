package com.pengsheng.mall.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.mall.po.MallAreaPo;

public interface MallAreaMgr {

	/**
	 * 获取商城区域总记录数
	 * @param po
	 * @return
	 */
	public int getMallAreaPoCount(MallAreaPo po);
	
	/**
	 * 获取商城区域列表
	 * @param po
	 */
	public List<MallAreaPo> getMallAreaPoList(MallAreaPo po, int start, int size);
	
	/**
	 * 新增商城区域
	 * @param po
	 * @return
	 */
	public void insertMallAreaPo(MallAreaPo po,
			LogisticsLogPo logPo);

	/**
	 * 删除商城区域
	 * @param po
	 * @return
	 */
	public void deleteMallAreaPo(MallAreaPo po,
			LogisticsLogPo logPo);

	/**
	 * 更新商城区域
	 * @param po
	 * @return
	 */
	public void updateMallAreaPo(MallAreaPo po,
			LogisticsLogPo logPo);

	/**
	 * 获取商城区域对象
	 * @param po
	 * @return
	 */
	public MallAreaPo getMallAreaPo(MallAreaPo po);

	/**
	 * 获取所有商城区域列表
	 * @param po
	 * @return
	 */
	public List<MallAreaPo> getMallAreaPoList(MallAreaPo po);
}
