/**
 * 
 */
package com.pengsheng.eims.sales.dao;

import java.util.List;
import java.util.Map;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesRecipeNumViewPo;
import com.pengsheng.eims.sales.persistence.ToMailPo;

/**
 * @author Liuqian
 * 
 */
public interface FrameSalesDao {

	/**
	 * 取顾客会员信息
	 * 
	 * @param po
	 *            会员号或顾客号
	 * @return
	 */
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
	public void insertSalesBasic(SalesBasicPo salesBasicPo);

	/**
	 * 插入明细表
	 * 
	 * @param salesDetailPo
	 */
	public void insertSalesDetail(SalesDetailPo salesDetailPo);
	
	public void insertIntrnsitInfo(InTransitPo inTransitPo) ;
	
	public void insertCustomize(SalesBasicPo salesBasicPo);
	
	/**
	 * 获取全部类型的验光信息
	 * @param customerID
	 * @return
	 */
	public List<InspectionPo> getInspectionPosAll(String customerID);
	
	public CustomerInfoPo getAjaxCustomerDiscount(GoodsInfoPo po);
	
	public CustomerInfoPo getCustomerFType(CustomerInfoPo po);
	
	/**
	 * 根据会员ID或会员卡号查看该会员是否存在
	 */
	public int getCustomerInfoCount(CustomerInfoPo po);

	/**
	 * 删除处方显示数量
	 */
	public void deleteSalesRecipeNumView();
	
	/**
	 * 更新处方显示数量
	 */
	public void updateSalesRecipeNumView(SalesRecipeNumViewPo po);
	
	/**
	 * 查询处方显示数量
	 */
	public List<SalesRecipeNumViewPo> getSalesRecipeNumViewList();

	public CustomerInfoPo getMemberType(String customerID);
	
	/**
	 * 销售页面根据会员号，按不同的处方类型查询最近几次的处方
	 */
	public List<InspectionPo> getInspectionRecipeListByType(InspectionPo ipo);
	
	/**
	 * 按不同的处方类型查询最近几次的处方
	 */
	public List<InspectionPo> getInspectionRecipeCountByType(InspectionPo ipo);
	
	/**
	 *  销售页面根据会员号，按不同的处方类型查询最近几次的处方
	 */
	public List<InspectionPo> getInspectionRecipeList(List<SalesRecipeNumViewPo> list,InspectionPo ipo);	
	
	/**
	 * 查看是否设置过销售页面需要显示的处方数量
	 */
	public int getInspectionRecipeCount(InspectionPo ipo);
	
	public void updateVipCardAdd(String vipcard);
	
	public void updateVipCardSub(String vipcard);	
	
	/**
	 * 销售页面新增邮寄信息
	 */
	public void insertToMail(ToMailPo toMailPo);
	

}
