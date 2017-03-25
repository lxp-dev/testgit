package com.pengsheng.eims.basic.mgr;

import java.io.InputStream;
import java.util.List;

import com.pengsheng.eims.basic.persistence.VIPCardDetailsPo;
import com.pengsheng.eims.basic.persistence.VIPCardPo;
import com.pengsheng.eims.basic.persistence.VIPGoodsBindPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface VIPCardMgr {
	/**
	 * 新增VIP卡信息
	 * @param vipCardPo
	 */
	public void insertVIPCardPo(VIPCardPo vipCardPo,VIPCardDetailsPo vipCardDetailsPo,List<VIPGoodsBindPo> vlist,LogisticsLogPo logPo);
	public void insertBatchVIPCard(List<VIPCardPo> vipCardList,VIPCardDetailsPo vipCardDetailsPo,List<VIPGoodsBindPo> vlist,LogisticsLogPo logPo);
	
	/**
	 * 修改VIP卡信息
	 * @param vipCardPo
	 */
	public void updateVIPCardPo(VIPCardPo vipCardPo,VIPCardDetailsPo vipCardDetailsPo,List<VIPGoodsBindPo> vlist, LogisticsLogPo logPo);
	
	/**
	 * 查询VIP卡条数
	 * @param vipCardPo
	 */
	public int selectVIPCardCount(VIPCardPo vipCardPo);
	
	/**
	 * 查询VIP卡List
	 * @param vipCardPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<VIPCardPo> selectVIPCardList(VIPCardPo vipCardPo,int start, int size);
	
	/**
	 * 查询VIP卡Po
	 * @param vipCardPo
	 * @return
	 */
	public VIPCardPo selectVIPCardPo(VIPCardPo vipCardPo);
	
	/**
	 * 删除Vip卡
	 * @param vipCardPo
	 */
	public void deleteVIPCardPo(VIPCardPo vipCardPo,LogisticsLogPo logPo);
	
	/**
	 * 修改VIP卡ID
	 * @param vipCardPo
	 */
	public void updateVIPCardID(VIPCardPo vipCardPo,LogisticsLogPo logPo);
	
	/**
	 * 导出VIP卡ID
	 * @param vipCardPo
	 */
	public InputStream insertExportExcel(VIPCardPo vipCardPo) throws Exception ;
	
	public void insertVIPCardDetails(VIPCardDetailsPo po);
	
	public List<VIPCardDetailsPo> selectVIPCardDetails(VIPCardDetailsPo po);
	
	public void deleteVIPCardDetails(String pid);
	
	public List<VIPGoodsBindPo> selectVIPCardBindGoodsType(VIPCardPo vipCardPo);
	
	public VIPCardPo selectVIPCardDetail(VIPCardPo vipCardPo);
	
}
