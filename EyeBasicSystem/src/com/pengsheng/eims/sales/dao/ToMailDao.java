package com.pengsheng.eims.sales.dao;

import java.util.List;

import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.ToMailPo;

public interface ToMailDao {
	
	public int getSalesBasicCount(SalesBasicPo po) ;

	/**
	 * 遍历销售结帐基表信息
	 */
	public List<SalesBasicPo> getSalesBasicList(SalesBasicPo po, int start,int size);
	
	public void updateToMail(ToMailPo toMailPo);
	
	public void insertToMail(ToMailPo toMailPo);
	
	public ToMailPo selectToMailPo(ToMailPo toMailPo);
	
	public int selectToMailPosCount(ToMailPo toMailPo);
	
	public List<ToMailPo> selectToMailPos(ToMailPo toMailPo, int start,int size);
	
	public void updateToMailSend(ToMailPo toMailPo);
	
	public void deleteToMailPo(ToMailPo toMailPo);
	
	public void updateToMailDetail(ToMailPo toMailPo);
	
	public int getComplainSalesBasicCount(SalesBasicPo po);
	
	public List<SalesBasicPo> getComplainSalesBasicList(SalesBasicPo po, int start,int size);
}
