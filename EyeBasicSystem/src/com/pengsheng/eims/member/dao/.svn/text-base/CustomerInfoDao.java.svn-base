package com.pengsheng.eims.member.dao;

import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.MemberExportPo;
import com.pengsheng.eims.system.persistence.MemberManagementPo;

public interface CustomerInfoDao {
	/**
	 * 查询会员信息数量
	 * @param po
	 * @return
	 */
	public int getCustomerInfoCount(CustomerInfoPo po);
	public int getCustomerInfoCount2(CustomerInfoPo po);
	public int getCustomerInfoCount1(CustomerInfoPo po);
	/**
	 * 查询会员信息
	 * @param po
	 * @return
	 */
	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po);
	public CustomerInfoPo getCustomerInfo2(CustomerInfoPo po);
	
	
	/**
	 * 查询会员信息通过电话
	 * @param po
	 * @return
	 */
	public CustomerInfoPo getCustomerInfocall(CustomerInfoPo po);
	
	/**
	 * 查询会员信息通过电话
	 */
	public int getCustomerInfoByPhone(CustomerInfoPo po);

	/**
	 * 遍历会员信息
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<CustomerInfoPo> getCustomerInfoList(CustomerInfoPo po,int start, int size);
	
	public List<CustomerInfoPo> getCustomerInfoList1(CustomerInfoPo po,int start, int size);
	
	public List<CustomerInfoPo> exportCustomerInfo(CustomerInfoPo po);

	/**
	 * 查询所有会员积分（用于清除所有会员积分)
	 */
	public List<CustomerInfoPo> getCustomerInfo_Integral_List();
	/**
	 * 新增会员信息
	 * @param po
	 */
	public void insertCustomerInfo(CustomerInfoPo po);

	/**
	 * 修改会员信息
	 * @param po
	 */
	public void updateCustomerInfo(CustomerInfoPo po);
	
	/**
	 * 修改会员附属卡电话为主卡电话
	 * @param po
	 */
	public void updateCustomerInfoPhone(String oldCardId,String cardId,String phone);

	/**
	 * 删除会员信息
	 * @param po
	 */
	public void deleteCustomerInfo(CustomerInfoPo po);
	
	/**
	 * 判断重复
	 * @param po
	 * @return
	 */
	public int getCount(CustomerInfoPo po);
	
	/**
	 * 判断是否存在会员卡
	 * @param po
	 * @return
	 */
	public int getCount();
	
	/**
	 * 更新会员积分
	 */
	public void updateCustomerInfoIntegral(CustomerInfoPo po);
	
	/**
	 * 查询会员卡类型
	 */
	public List<MemberManagementPo> getMemberCardTypeList();
	
	/**
	 * 遍历高级会员信息
	 */
	public List<CustomerInfoPo> getCustomerInfoListMessage(CustomerInfoPo po) ;
	
	/**
	 * 查询顾客是否可以删除
	 * @param po
	 * @return
	 */
	public int selectCustomerInfoIsDelete(CustomerInfoPo po);
	
	/**
	 * 清空指定会员积分
	 */
	public void updateCustomerInfoAppointCredit(CustomerInfoPo po);
	
	/**
	 * 清空所有会员积分
	 */
	public void updateCustomerInfoAllCredit();
	
	/**
	 * 获取会员导出属性的总数
	 */
	public int getCustomerInfoForExport();
	
	/**
	 * 获取会员导出属性的列表
	 */
	public List<MemberExportPo> getCustomerInfoForExportList(String flag);
	
	/**
	 * 更新会员导出配置项
	 */
	public void updateCustomerExportInfoProperty(MemberExportPo po);
	
	public List<CustomerInfoPo> selectGXList(CustomerInfoPo po);
	
	/**
	 * 获取主子卡全部销售金额
	 */
	public CustomerInfoPo getALLsalesvalues(String salesid);
	
	/**
	 * 会员启用停用
	 */
	public void updateCustomerEnable(CustomerInfoPo cpo);
	
	/**
	 * 查询会员信息
	 */
	public CustomerInfoPo getCustomerInfoByH() ;
	
	/**
	 * 只有待结款的单子才能调用
	 */
	public CustomerInfoPo getCustomerInfoNoFinished(CustomerInfoPo po) ;
	
	/**
	 * 微信中获得主卡或关联卡信息
	 */
	public List<CustomerInfoPo> getWeixinCustomerInfoList(CustomerInfoPo po);
	
	/**
	 * 获取集团端顾客信息List
	 */
	public List<CustomerInfoPo> getCustomerInfoDownloadList(CustomerInfoPo po,int start, int size);
	
	/**
	 * 查询会员信息数量
	 */
	public int getCustomerInfoDownloadCount(CustomerInfoPo po);
	
	/**
	 * 查询会员信息
	 */
	public CustomerInfoPo getCustomerInfoDownload(CustomerInfoPo po);
	
	/**
	 * 打开远程连接服务
	 * @param po
	 * @return
	 */
	public void openWork();
	
	/**
	 * 关闭远程连接服务
	 * @param po
	 * @return
	 */
	public void closeWork();
	
	/**
	 * 连接HIS后判断会员是否存在
	 * @param cpo  
	 * @return 数字标识
	 */
	public int getCuInfo(CustomerInfoPo cpo);
	/**
	 * 连接HIS后更新顾客号
	 * @param cpo
	 */
	public void updteCustCard(CustomerInfoPo cpo);
	 
	/**
	 * 连接HIS后更新当前患者卡号
	 * @param cpo
	 */
	public void updteCurCustCard(CustomerInfoPo cpo);
	/**
	 * 
	 * HIS会员新增判断会员是否重复
	 * @param cpo
	 */
	public CustomerInfoPo getCustPhoneInfo(CustomerInfoPo cpo);
}
