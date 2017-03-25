package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

public interface SpectaclesMaterialsMgr {

	/**
	 * 查询配镜发料信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getSpectaclesMaterialsCount(SalesBasicPo salesBasicPo);
	
	/**
	 * 查询配镜发料信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectSpectaclesMaterials(SalesBasicPo salesBasicPo , int start , int size);
	
	/**
	 * 得到订单及顾客信息 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getSalesDetailInfo(SalesBasicPo salesBasicPo);
	
	/**
	 * 取出销售单中右眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo);
	
	/**
	 * 取出销售单中左眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo);
	
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
	
	/**
	 * 新增发料信息
	 * @param inTransitPo
	 * @param salesPo
	 * @param goodsid
	 * @param stockid
	 * @param number
	 * @param costsprive
	 * @param unitprice
	 * @param goodsCode
	 * @param salesId
	 */
	public void insertMaterials(SystemParameterPo systemParameterPo,InTransitPo inTransitPo , SalesBasicPo salesPo , String[] goodsid , 
			String[] stockid , String[] number , String[] costsprive , String[] unitprice , 
			String[] goodsCode , String salesId,LogisticsLogPo logPo,String[] ssesdid);
	
	/**
	 * 得到部门列表
	 * @param departmentsPo
	 * @return
	 */
	public List<DepartmentsPo> getdepartment(DepartmentsPo departmentsPo);	
	
	/**
	 * 发料时判断销售单在途
	 * @param String
	 * @return
	 */
	public int selectIsSend(String salesid);
	
	/**
	 * 查询未打印发料单的总数
	 */
	public int getPrintSpectaclesMaterialsBillCount(SalesBasicPo salesBasicPo);
	
	/**
	 * 查询未打印发料单
	 */
	public List<SalesBasicPo> selectPrintSpectaclesMaterialsBill(SalesBasicPo salesBasicPo , int start , int size);	
	
	/**
	 * 批量新增发料信息
	 */
	public void insertMaterialsBatch(SystemParameterPo systemParameterPo,InTransitPo inTransitPo,List<SalesBasicPo> poList,LogisticsLogPo logPo);
	
	/**
	 * 获取发料商品
	 */
	public List<SalesDetailPo> selectGoodsDetailInfo(SalesBasicPo po);	
	
}
