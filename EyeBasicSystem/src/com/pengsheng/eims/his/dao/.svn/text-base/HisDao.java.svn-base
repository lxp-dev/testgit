package com.pengsheng.eims.his.dao;

import java.util.List;

import com.pengsheng.eims.his.persistence.HisParamPo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;

public interface HisDao {

	public SalesBasicPo getSalesBasicInfo(String billid);
	
	public List<SalesDetailPo> getSalesDetailInfoList(String billid);
	
	public RegisteredDetailsPo getRegisteredInfo(String billid);

	public List<RegisteredDetailsPo> getRegisteredDetailInfoList(String billid);

	public int getCustomerOptometryStateByHis(String memberid, String todayoutpatientid);

	public List<SalesDetailPo> getSalesDetailNotSetPayFeeList(String billid);

	public void updateCustOptStaOKByHis(HisParamPo hisParamPo);
	
	public int getCustomerIsrefundStateByHis(String memberid, String todayoutpatientid);

	public int getChargeCount(HisParamPo po);

}
