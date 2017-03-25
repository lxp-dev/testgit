package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.ChuzhikaLogPo;
import com.pengsheng.eims.basic.persistence.ChuzhikaPo;

public interface ChuzhikaDao {
	/**
	 * 新增储值卡
	 * @param chuzhikaPo
	 */
	public void insertChuzhika(ChuzhikaPo chuzhikaPo);
	
	public void updateChuzhikaIsShowHide(ChuzhikaPo chuzhikaPo);
	public void insertChuZhiKaLogInformation(ChuzhikaLogPo po);
	public void insertChuZhiKaLogInformation(List<ChuzhikaLogPo> poList);
	
	/**
	 * 删除储值卡
	 * @param chuzhikaPo
	 */
	public void deleteChuzhika(ChuzhikaPo chuzhikaPo);
	
	/**
	 * 更新储值卡
	 * @param chuzhikaPo
	 */
	public void updateChuzhika(ChuzhikaPo chuzhikaPo);
	
	/**
	 * 更新储值卡充值
	 * @param chuzhikaPo
	 */
	public void updateChuzhikaChongzhi(ChuzhikaPo chuzhikaPo);
	
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
	 * 查询储值卡
	 * @param chuzhikaPo
	 * @return
	 */
	public List<ChuzhikaPo> selectChuzhikas(ChuzhikaPo chuzhikaPo, int start, int size);
	
	/**
	 * 查询储值卡
	 * @param chuzhikaPo
	 * @return
	 */
	public List<ChuzhikaPo> selectChuzhikas(ChuzhikaPo chuzhikaPo);
	
	/**
	 * 查询储值po
	 * @param chuzhikaPo
	 * @return
	 */
	public ChuzhikaPo selectChuzhika(ChuzhikaPo chuzhikaPo);
	
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
	public void deleteChuzhikaBatch(String cardString);
	
	/**
	 * 删除储值卡
	 * @param chuzhikaPo
	 */
	public void deleteChuzhikaLog(ChuzhikaPo chuzhikaPo);		
	
	public List<ChuzhikaLogPo> selectChuzhikadel(ChuzhikaLogPo chuzhikaLogPo);
	public void deleteChuzhikaLogBySalesBillID(ChuzhikaLogPo chuzhikaLogPo);	
	
	/**
	 * 批量停用启用储值卡
	 */
	public void updateChuzhikaEnableBatch(ChuzhikaPo cpo);
	
	/**
	 *  退款时获取上一次微信赠送的信息
	 */
	public ChuzhikaLogPo selectChuzhikaLogsPoByCustomerIDAndSalesBillID(ChuzhikaLogPo po);
}
