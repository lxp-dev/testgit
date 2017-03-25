package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.ToMailPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface ToMailMgr {
	
	public int getSalesBasicCount(SalesBasicPo po);

	/**
	 * 遍历销售结帐基表信息
	 */
	public List<SalesBasicPo> getSalesBasicList(SalesBasicPo po, int start,int size);
	
	public void updateToMail(ToMailPo toMailPo,LogisticsLogPo logPo);	

	public void insertToMailMessage(ToMailPo toMailPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,LogisticsLogPo logPo);
	public void insertToMail(ToMailPo toMailPo,LogisticsLogPo logPo);
	
	public ToMailPo selectToMailPo(ToMailPo toMailPo);
	
	public int selectToMailPosCount(ToMailPo toMailPo);
	
	public List<ToMailPo> selectToMailPos(ToMailPo toMailPo, int start,int size);
	
	public void deleteToMailPo(ToMailPo toMailPo,LogisticsLogPo logPo);
	
	public void updateToMailDetail(ToMailPo toMailPo,LogisticsLogPo logPo);
	 
	public int getComplainSalesBasicCount(SalesBasicPo po);
	
	public List<SalesBasicPo> getComplainSalesBasicList(SalesBasicPo po, int start,int size);
}
