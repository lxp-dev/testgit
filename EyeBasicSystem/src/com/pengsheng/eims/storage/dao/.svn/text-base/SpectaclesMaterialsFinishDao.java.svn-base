package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;

public interface SpectaclesMaterialsFinishDao {

	/**
	 * 查询配镜已发料信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getSpectaclesMaterialsFinishCount(SalesBasicPo salesBasicPo);
	
	/**
	 * 查询配镜已发料信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectSpectaclesMaterialsFinish(SalesBasicPo salesBasicPo , int start , int size);
	
	/**
	 * 得到订单及顾客信息 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getSalesDetailInfo(SalesBasicPo salesBasicPo);
	public SalesBasicPo getSalesDetailInfoFinished(SalesBasicPo salesBasicPo);
	
	/**
	 * 取出销售单中右眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo);
	public SalesBasicPo getODDetailInfoFinished(SalesBasicPo salesBasicPo);
	
	/**
	 * 取出销售单中左眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo);
	public SalesBasicPo getOSDetailInfoFinished(SalesBasicPo salesBasicPo);
	
	/**
	 * 得到销售单中商品个数
	 * @param salesDetailPo
	 * @return
	 */
	public int getGoodsDetailCount(SalesDetailPo salesDetailPo);
	
	/**
	 * 得到销售单中商品信息
	 * @param salesDetailPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesDetailPo> selectGoodsDetailInfo(SalesDetailPo salesDetailPo, int start , int size);
	
	/**
	 * 得到销售单中商品信息
	 * @param salesDetailPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesDetailPo> selectGoodsDetailInfoes(SalesDetailPo salesDetailPo);
	public List<SalesDetailPo> selectGoodsDetailInfoesFinished(SalesDetailPo salesDetailPo);
	
	/**
	 * 查询已打印发料单的总数
	 */
	public int getPrintSpectaclesMaterialsBillFinishCount(SalesBasicPo salesBasicPo);
	
	/**
	 * 查询已打印发料单
	 */
	public List<SalesBasicPo> selectPrintSpectaclesMaterialsBillFinish(SalesBasicPo salesBasicPo , int start , int size);
	
	/**
	 * 更新发料单打印状态
	 */
	public void updatePrintSpectaclesMaterialsBillStatus(SalesBasicPo salesBasicPo);
	
	/**
	 * 更新发料单流水号
	 */
	public void updatePrintSpectaclesMaterialsBillSerialNumber(SalesBasicPo salesBasicPo);
	
}
