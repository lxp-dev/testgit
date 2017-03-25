package com.pengsheng.eims.basic.mgr;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.PeriodBeginClearPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

public interface InitSystemMgr{
	
    /**
	 * 导入商品库存
	 * 
	 * @param brandPo
	 */
	public void insertImportExcel(GoodsInfoPo goodsInfoPo,String sjtype,File[] upload, String filePath, String[] fFullName,String[] ContentType,SystemParameterPo spo,String filetemplet,LogisticsLogPo logPo);

	/**
	 * 导出商品信息
	 * 
	 * @param personInfoPo
	 */
	public InputStream insertExportExcel(GoodsInfoPo goodsInfoPo,String url,LogisticsLogPo logPo) throws Exception;
	
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
	public void updatePrintGoodsBarCodeStatus(GoodsInfoPo po,LogisticsLogPo logPo);
	
    /**
	 * 使用商品不含税成本更新加权平均成本
	 * 
	 * @param brandPo
	 */
	public void updateGoodsAvgCost(GoodsInfoPo po,LogisticsLogPo logPo);
	
    /**
	 * 汇总财务期初成本
	 */
	public void insertGoodsAvgCost(String bgndate,String companyID,String departmentID,String cbPriceType,String cbjsType,LogisticsLogPo logPo);
	
    /**
	 * 清除试用数据
	 */
	public void deletePeriodBeginData(PeriodBeginClearPo ppo,LogisticsLogPo logPo);
	
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
	public void updateQccb(GoodsInfoPo po,LogisticsLogPo logPo);
	
    /**
	 * 查询已导入的总成本
	 */
	public GoodsInfoPo getQccbTotal(GoodsInfoPo po);
	
    /**
	 * 根据公司ID查询部门的期初时间
	 */
	public String getQcDateByCompany(String companyID);
	
}
