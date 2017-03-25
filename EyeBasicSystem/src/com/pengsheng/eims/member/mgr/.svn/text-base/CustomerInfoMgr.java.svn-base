package com.pengsheng.eims.member.mgr;

import java.io.InputStream;
import java.util.List;

import com.pengsheng.eims.his.persistence.HisLogPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.MemberExportPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.system.persistence.MemberManagementPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SendNotePo;

public interface CustomerInfoMgr {
	/**
	 * 查询会员信息数量
	 */
	public int getCustomerInfoCount(CustomerInfoPo po);
	public int getCustomerInfoCount2(CustomerInfoPo po);
	public int getCustomerInfoCount1(CustomerInfoPo po);
	/**
	 * 查询会员信息
	 */
	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po,PersonInfoPo ppo);
	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po);
	public CustomerInfoPo getCustomerInfoByH() ;
	
	/**
	 * 导出顾客编号
	 * 
	 * @param personInfoPo
	 */
	public InputStream bulidCustomerInfoExcel(CustomerInfoPo po) throws Exception;
	
	/**
	 * 查询会员是否存在通过电话
	 */
	public CustomerInfoPo getCustomerInfocall(CustomerInfoPo po);
	
	/**
	 * 查询会员是否存在通过电话
	 */
	public int getCustomerInfoByPhone(CustomerInfoPo po);
	
	/**
	 * 遍历会员信息
	 */
	public List<CustomerInfoPo> getCustomerInfoList(CustomerInfoPo po,int start, int size);
	
	/**
	 * 遍历高级会员信息
	 */
	public List<CustomerInfoPo> getCustomerInfoList1(CustomerInfoPo po,int start, int size);
	/**
	 * 新增会员信息
	 */
	public void insertCustomerInfo(CustomerInfoPo po,LogisticsLogPo logPo);
	/**
	 * 修改会员信息
	 */
	public void updateCustomerInfo(CustomerInfoPo po,LogisticsLogPo logPo);
	/**
	 * 删除会员信息
	 */
	public void deleteCustomerInfo(CustomerInfoPo po,LogisticsLogPo logPo);
	
	/**
	 * 判断重复
	 * @param po
	 * @return
	 */
	public int getCount(CustomerInfoPo po);
	
	/**
	 * 判断是否存在
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
	 * 新增发送短信
	 */
	public void insertCustomerInfoMessage(List<CustomerInfoPo> plist,SendNotePo snpo,LogisticsLogPo logPo);
	
	/**
	 * 查询顾客是否可以删除
	 * @param po
	 * @return
	 */
	public int selectCustomerInfoIsDelete(CustomerInfoPo po);
	
	/**
	 * 清空指定会员积分
	 */
	public void updateCustomerInfoAppointCredit(List<CustomerInfoPo> pos,LogisticsLogPo logPo);
	
	/**
	 * 清空所有会员积分
	 */
	public void updateCustomerInfoAllCredit(LogisticsLogPo logPo);
	
	/**
	 * 更新会员导出配置项
	 */
	public void updateCustomerExportInfoProperty(MemberExportPo po,LogisticsLogPo logPo);
	
	/**
	 * 获取会员导出属性的列表
	 */
	public List<MemberExportPo> getCustomerInfoForExportList(String flag);
	
	public List<CustomerInfoPo> selectGXList(CustomerInfoPo po);
	
	/**
	 * 获取主子卡全部销售金额
	 */
	public CustomerInfoPo getALLsalesvalues(String salesid);
	
	/**
	 * 会员启用停用
	 */
	public void updateCustomerEnable(CustomerInfoPo cpo,LogisticsLogPo logPo);
	
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
	public List<CustomerInfoPo> noGetCustomerInfoDownloadList(CustomerInfoPo po,int start, int size);
	
	/**
	 * 查询会员信息数量
	 */
	public int noGetCustomerInfoDownloadCount(CustomerInfoPo po);
	
	/**
	 * 查询会员信息
	 */
	public CustomerInfoPo noGetCustomerInfoDownload(CustomerInfoPo po);
	/**
	 * 连接HIS后判断会员是否存在
	 * @param cpo 条件是 :  顾客号相同视为存在 
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
	public void updteCurCustCard(CustomerInfoPo cpo,LogisticsLogPo logPo);
	
	/**
	 * 新增会员信息
	 */
	public void insertCust(CustomerInfoPo po, LogisticsLogPo logPo);
	/**
	 * HIS模块新增判断电话是否重复
	 * @param cpo
	 * @return
	 */
	public String getCustPhoneInfo(CustomerInfoPo cpo);
}
