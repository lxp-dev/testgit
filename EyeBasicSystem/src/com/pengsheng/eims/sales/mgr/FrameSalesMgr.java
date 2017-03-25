/**
 * 
 */
package com.pengsheng.eims.sales.mgr;

import java.util.List;
import java.util.Map;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.basic.persistence.GiftsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesRecipeNumViewPo;
import com.pengsheng.eims.sales.persistence.SpecialPDetailPo;
import com.pengsheng.eims.sales.persistence.ToMailPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

/**
 * @author Liuqian
 * 
 */
public interface FrameSalesMgr {

	/**
	 * 取顾客会员信息
	 * 
	 * @param po
	 *            会员号或顾客号
	 * @return
	 */
	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po,PersonInfoPo ppo);
	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po);

	/**
	 * 得到最新一条验光病历表，检查结论
	 * 
	 * @param customerID
	 * @return
	 */
	public List<InspectionPo> getInspectionPos(String customerID);
	/**
	 * 插入配镜主表
	 * 
	 * @param salesBasicPo
	 */
	public void insertSalesBasic(SalesBasicPo salesBasicPo,SalesDetailPo salesDetailPo,GiftsPo giftsPo,InTransitPo inTransitPo,List<SpecialPDetailPo> specialPDetailList,List<AdditionalCDetailPo> additionalCDetailList,List<InspectionPo> inspectionPos,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,String nwtype,LogisticsLogPo logPo);
	public void insertShopSalesMain(SalesBasicPo salesBasicPo,SalesDetailPo salesDetailPo,GiftsPo giftsPo,InTransitPo inTransitPo,List<SpecialPDetailPo> specialPDetailList,List<AdditionalCDetailPo> additionalCDetailList,List<InspectionPo> inspectionPos,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,String nwtype,LogisticsLogPo logPo,ToMailPo toMailPo);

	/**
	 * 获取全部类型的验光信息
	 * @param customerID
	 * @return
	 */
	public List<InspectionPo> getInspectionPosAll(String customerID);
	
	public CustomerInfoPo getAjaxCustomerDiscount(GoodsInfoPo po);
	
	public CustomerInfoPo getCustomerFType(CustomerInfoPo po);
	
	/**
	 * 根据会员卡号查询HIS系统是否存在会员
	 */
	public void getHisCustomerInfoCount(CustomerInfoPo po,PersonInfoPo ppo);
	
	/**
	 * 更新处方显示数量
	 */
	public void updateSalesRecipeNumView(List<SalesRecipeNumViewPo> poList,LogisticsLogPo logPo);
	
	/**
	 * 查询处方显示数量
	 */
	public List<SalesRecipeNumViewPo> getSalesRecipeNumViewList();
	
	/**
	 * 销售页面根据会员号，按不同的处方类型查询最近几次的处方
	 */
	public List<InspectionPo> getInspectionRecipeListByType(InspectionPo ipo);
	
	/**
	 * 按不同的处方类型查询最近几次的处方
	 */
	public List<InspectionPo> getInspectionRecipeCountByType(InspectionPo ipo);
	
	/**
	 * 查看是否设置过销售页面需要显示的处方数量
	 */
	public int getInspectionRecipeCount(InspectionPo ipo);
	
	/**
	 *  销售页面根据会员号，按不同的处方类型查询最近几次的处方
	 */
	public List<InspectionPo> getInspectionRecipeList(List<SalesRecipeNumViewPo> list,InspectionPo ipo);	
}
