package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.PeriodBeginClearPo;

public interface InitSystemDao{
	
    /**
	 * 导入商品库存
	 * 
	 * @param brandPo
	 */
	public void insertStorageGoods_Log(List<GoodsInfoPo> poList);
	
    /**
	 * 导入商品库存
	 * 
	 * @param brandPo
	 */
	public void insertStorageGoods_Change(List<GoodsInfoPo> poList);
	
    /**
	 * 查询需要导出的商品信息
	 * 
	 * @param brandPo
	 */
	public List<GoodsInfoPo> selGoodsInfo(GoodsInfoPo po);
	
    /**
	 * 查询商品是否存在
	 * 
	 * @param brandPo
	 */
	public int getGoodsCount(GoodsInfoPo po);
	
    /**
	 * 查询需要打印条码的商品信息总数
	 * 
	 * @param brandPo
	 */
	public int getPrintGoodsBarCodeCount(GoodsInfoPo po);
	
    /**
	 * 查询需要打印条码的商品信息
	 * 
	 * @param brandPo
	 */
	public List<GoodsInfoPo> getPrintGoodsBarCodeList(GoodsInfoPo po,int start,int size);
	
    /**
	 * 更新库存表，为已打印条码的商品打上标记
	 * 
	 * @param brandPo
	 */
	public void updatePrintGoodsBarCodeStatus(GoodsInfoPo po);
	
    /**
	 * 使用商品不含税成本更新加权平均成本
	 * 
	 * @param brandPo
	 */
	public void updateGoodsAvgCost(GoodsInfoPo po);
	
	public GoodsCategoryPo getGoodsCategorys(String id);
	
    /**
	 * 汇总财务期初成本
	 */
	public void insertGoodsAvgCost(String bgndate,String companyID,String departmentID,String cbPriceType,String cbjsType);
	
    /**
	 * 清除试用数据
	 */
	public void deletePeriodBeginData(PeriodBeginClearPo ppo);
	
    /**
	 * 导入商品库存
	 * 
	 * @param brandPo
	 */
	public void insertStorageGoods_Collect();
	
    /**
	 * 删除商品库存
	 * 
	 * @param brandPo
	 */
	public void deleteStorageGoods_Log(String warehouseid);
	
    /**
	 * 删除商品库存
	 * 
	 * @param brandPo
	 */
	public void deleteStorageGoods_Beginning(String warehouseid);
	
    /**
	 * 删除商品库存
	 * 
	 * @param brandPo
	 */
	public void deleteStorageGoods_Change(String warehouseid);
	
    /**
	 * 清空成本计算
	 */
	public void deleteGoodsAvgCost(String companyID,String departmentID);
	
    /**
	 * 新增试用数据日志
	 */
	public void insertPeriodBeginDataLog(PeriodBeginClearPo ppo);
	
    /**
	 * 查看试用数据
	 */
	public List<PeriodBeginClearPo> selectPeriodBeginData();
	
    /**
	 * 查询期初成本的总数
	 */
	public int getQccbCount(GoodsInfoPo po);
	
    /**
	 * 查询期初成本的列表
	 */
	public List<GoodsInfoPo> getQccbList(GoodsInfoPo po,int start,int size);
	
    /**
	 * 查询商品的期初成本
	 */
	public GoodsInfoPo getQccbDetail(GoodsInfoPo po);
	
    /**
	 * 修改商品的期初成本
	 */
	public void updateQccb(GoodsInfoPo po);
	
    /**
	 * 查询已导入的总成本
	 */
	public GoodsInfoPo getQccbTotal(GoodsInfoPo po);
	
    /**
	 * 根据公司ID查询部门的期初时间
	 */
	public String getQcDateByCompany(String companyID);
	
}
