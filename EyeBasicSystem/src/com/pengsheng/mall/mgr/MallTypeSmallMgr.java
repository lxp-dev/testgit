package com.pengsheng.mall.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.mall.po.MallTypeSmallPicPo;
import com.pengsheng.mall.po.MallTypeSmallPo;

public interface MallTypeSmallMgr {
	/**
	 * 新增商品信息
	 * @param po
	 */
	public void insertMallTypeSmallPo(MallTypeSmallPo po,LogisticsLogPo logPo);
	
	/**
	 * 更新商品信息
	 * @param po
	 */
	public void updateMallTypeSmallPo(MallTypeSmallPo po,LogisticsLogPo logPo);
	
	/**
	 * 更新启用状态
	 * @param po
	 */
	public void updateMallTypeSmallFlag(MallTypeSmallPo po,LogisticsLogPo logPo);
	
	/**
	 * 获得商品信息
	 * @param po
	 */
	public MallTypeSmallPo getMallTypeSmallPo(MallTypeSmallPo po);
	
	/**
	 * 删除商品信息
	 * @param po
	 */
	public void deleteMallTypeSmallPo(MallTypeSmallPo po,LogisticsLogPo logPo);
	
	/**
	 * 获取商品信息条数
	 * @param po
	 * @return
	 */
	public int getMallTypeSmallPoCount(MallTypeSmallPo po);
	
	/**
	 * 获取商品信息List
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<MallTypeSmallPo> getMallTypeSmallPoList(MallTypeSmallPo po, int start,int size);
	
	
	/**
	 * 获取滚动导航图List
	 * 
	 * @param smallID
	 */
	public List<MallTypeSmallPicPo> getMallTypeSmallPicList(String smallID);
	
	/**
	 * 更新滚动导航图
	 * 
	 * @param po
	 */
	public void updateMallTypeSmallPic(MallTypeSmallPo po,LogisticsLogPo logPo);

}
