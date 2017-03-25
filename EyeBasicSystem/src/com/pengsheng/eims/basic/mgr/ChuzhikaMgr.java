package com.pengsheng.eims.basic.mgr;

import java.io.InputStream;
import java.util.List;

import com.pengsheng.eims.basic.persistence.ChuzhikaLogPo;
import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface ChuzhikaMgr {
	/**
	 * 新增储值卡并记录充值信息
	 * @param chuzhikaPo
	 */
	public void insertChuzhika(ChuzhikaPo chuzhikaPo,LogisticsLogPo logPo);
	public void insertBatchChuzhika(List<ChuzhikaPo> chuzhikaList,LogisticsLogPo logPo);
	
	/**
	 * 储值卡启用停用
	 * @param chuzhikaPo
	 */
	public void updateChuzhikaIsShowHide(ChuzhikaPo chuzhikaPo,LogisticsLogPo logPo);
	public void insertChuZhiKaLogInformation(ChuzhikaLogPo po);
	
	/**
	 * 删除储值卡
	 * @param chuzhikaPo
	 */
	public void deleteChuzhika(ChuzhikaPo chuzhikaPo,LogisticsLogPo logPo);
	
	/**
	 * 更新储值卡
	 * @param chuzhikaPo
	 */
	public void updateChuzhika(ChuzhikaPo chuzhikaPo,LogisticsLogPo logPo);
	
	/**
	 * 更新储值卡充值
	 * @param chuzhikaPo
	 */
	public void updateChuzhikaChongzhi(ChuzhikaLogPo chuzhikaLogPo,LogisticsLogPo logPo);
	
	/**
	 * 查询储值卡Po
	 * @param chuzhikaPo
	 * @return
	 */
	public ChuzhikaPo selectChuzhika(ChuzhikaPo chuzhikaPo);
	
	/**
	 * 查询储值卡是否已经存在Count
	 * @param chuzhikaPo
	 * @return
	 */
	public int selectChuzhikCount(String cardID);

	/**
	 * 查询会员是否已经绑定了储值卡
	 * @param chuzhikaPo
	 * @return
	 */
	public int selectCustomerCzkCount(String id,String customerID);
	
	/**
	 * 查询储值卡Count
	 * @param chuzhikaPo
	 * @return
	 */
	public int selectChuzhikasCount(ChuzhikaPo chuzhikaPo);
	
	/**
	 * 查询储值卡List
	 * @param chuzhikaPo
	 * @return
	 */
	public List<ChuzhikaPo> selectChuzhikas(ChuzhikaPo chuzhikaPo, int start, int size);
	
	/**
	 * 批量新增储值卡时，判断哪些储值卡号已经被使用
	 * @param cardString
	 * @return
	 */
	public List<ChuzhikaPo> getChuzhikaListIsExist(String cardString);
	
	/**
	 * 批量删除储值卡
	 * @param cardString
	 * @return
	 */
	public void deleteChuzhikaBatch(String cardString,LogisticsLogPo logPo);
	
	/**
	 * 取得充值记录
	 * @param chuzhikaPo
	 * @return
	 */
	public List<ChuzhikaLogPo> selectChuzhikaLogs(String cardUUID);
	
	/**
	 * 微信--取得会员绑定储值卡余额积分
	 * @param chuzhikaPo
	 * @return
	 */
	public ChuzhikaPo selectChuzhikaJifenByCustomerID(String customerID);
	
	/**
	 * 微信--取得会员绑定储值卡增减记录
	 * @param chuzhikaPo
	 * @return
	 */
	public List<ChuzhikaLogPo> selectChuzhikaLogsByCustomerID(String cardUUID);
	
	/**
	 * 导出储值ID
	 * @param vipCardPo
	 */
	public InputStream insertExportExcel(ChuzhikaPo chuzhikaPo) throws Exception ;
	
	/**
	 * 批量停用启用储值卡
	 */
	public void updateChuzhikaEnableBatch(ChuzhikaPo cpo,LogisticsLogPo logPo);
}
