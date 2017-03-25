package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;

import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.dao.SpectaclesMaterialsFinishDao;
import com.pengsheng.eims.storage.mgr.SpectaclesMaterialsFinishMgr;
import com.pengsheng.eims.util.tools.Utility;

public class SpectaclesMaterialsFinishMgrImpl implements
		SpectaclesMaterialsFinishMgr {

	private SpectaclesMaterialsFinishDao spectaclesMaterialsFinishDao;
	private InTransitDetailsDao inTransitDetailsDao;
	
	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}

	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}

	public SpectaclesMaterialsFinishDao getSpectaclesMaterialsFinishDao() {
		return spectaclesMaterialsFinishDao;
	}

	public void setSpectaclesMaterialsFinishDao(
			SpectaclesMaterialsFinishDao spectaclesMaterialsFinishDao) {
		this.spectaclesMaterialsFinishDao = spectaclesMaterialsFinishDao;
	}

	/**
	 * 查询配镜已发料信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getSpectaclesMaterialsFinishCount(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		return spectaclesMaterialsFinishDao.getSpectaclesMaterialsFinishCount(salesBasicPo);
	}

	/**
	 * 查询配镜已发料信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectSpectaclesMaterialsFinish(
			SalesBasicPo salesBasicPo, int start, int size) {
		// TODO Auto-generated method stub
		return spectaclesMaterialsFinishDao.selectSpectaclesMaterialsFinish(salesBasicPo, start, size);
	}

	/**
	 * 取出销售单中右眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo) {
		if (inTransitDetailsDao.getSalesBasicInfoByID(salesBasicPo) == 0){
			return spectaclesMaterialsFinishDao.getODDetailInfoFinished(salesBasicPo);
        }
		return spectaclesMaterialsFinishDao.getODDetailInfo(salesBasicPo);
	}

	/**
	 * 取出销售单中左眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo) {
		if (inTransitDetailsDao.getSalesBasicInfoByID(salesBasicPo) == 0){
			return spectaclesMaterialsFinishDao.getOSDetailInfoFinished(salesBasicPo);
        }
		return spectaclesMaterialsFinishDao.getOSDetailInfo(salesBasicPo);
	}

	/**
	 * 得到订单及顾客信息 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getSalesDetailInfo(SalesBasicPo salesBasicPo) {
		if (inTransitDetailsDao.getSalesBasicInfoByID(salesBasicPo) == 0){			
			return spectaclesMaterialsFinishDao.getSalesDetailInfoFinished(salesBasicPo);
        }
		return spectaclesMaterialsFinishDao.getSalesDetailInfo(salesBasicPo);
	}
	
	/**
	 * 得到销售单中商品个数
	 * @param salesDetailPo
	 * @return
	 */
	public int getGoodsDetailCount(SalesDetailPo salesDetailPo) {
		// TODO Auto-generated method stub
		return spectaclesMaterialsFinishDao.getGoodsDetailCount(salesDetailPo);
	}

	/**
	 * 得到销售单中商品信息
	 * @param salesDetailPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesDetailPo> selectGoodsDetailInfo(
			SalesDetailPo salesDetailPo, int start, int size) {
		// TODO Auto-generated method stub
		return spectaclesMaterialsFinishDao.selectGoodsDetailInfo(salesDetailPo, start, size);
	}
	
	/**
	 * 得到销售单中商品信息
	 * @param salesDetailPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesDetailPo> selectGoodsDetailInfoes(SalesDetailPo salesDetailPo) {
		if (inTransitDetailsDao.getSalesDetailInfoByID(salesDetailPo) == 0){
			return spectaclesMaterialsFinishDao.selectGoodsDetailInfoesFinished(salesDetailPo);
        }
		return spectaclesMaterialsFinishDao.selectGoodsDetailInfoes(salesDetailPo);
	}
	
	/**
	 * 查询已打印发料单的总数
	 */
	public int getPrintSpectaclesMaterialsBillFinishCount(SalesBasicPo salesBasicPo){
		return spectaclesMaterialsFinishDao.getPrintSpectaclesMaterialsBillFinishCount(salesBasicPo);
	}
	
	/**
	 * 查询已打印发料单
	 */
	public List<SalesBasicPo> selectPrintSpectaclesMaterialsBillFinish(SalesBasicPo salesBasicPo , int start , int size){
		return spectaclesMaterialsFinishDao.selectPrintSpectaclesMaterialsBillFinish(salesBasicPo,start,size);
	}
	
	/**
	 * 更新发料单打印状态
	 */
	public void updatePrintSpectaclesMaterialsBillStatus(SalesBasicPo salesBasicPo){
		
		String[] array = Utility.getName(salesBasicPo.getSsesbsalesid()).split(",");
		
		for (int i = 0; i < array.length; i++){
			SalesBasicPo spo = new SalesBasicPo();
			spo.setSsesbsalesid(array[i]);
			
			spectaclesMaterialsFinishDao.updatePrintSpectaclesMaterialsBillStatus(spo);
		}
	}
	
	/**
	 * 更新发料单流水号
	 */
	public void updatePrintSpectaclesMaterialsBillSerialNumber(SalesBasicPo salesBasicPo){
		
		String[] array = Utility.getName(salesBasicPo.getSsesbsalesid()).split(",");
		
		for (int i = 0; i < array.length; i++){
			SalesBasicPo spo = new SalesBasicPo();
			spo.setSsesbsalesid(array[i]);
			spo.setSsesbprintserialnumber(Utility.getName(salesBasicPo.getSsesbprintserialnumber()));
			
			spectaclesMaterialsFinishDao.updatePrintSpectaclesMaterialsBillSerialNumber(spo);
		}
	}

}
