package com.pengsheng.eims.sales.dao;

import java.util.List;

import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;

public interface OptometryInformationDao {
	
	/**
	 * 得到顾客验光基表
	 * 
	 * @param customerID
	 * @param start
	 * @param size
	 * @return
	 */
	public List<OptometryBasicPo> getcustomerOptometryBasics(String customerID,
			int start, int size);

	/**
	 * 得到顾客所有验光基表明细
	 * 
	 * @param customerID
	 * @return
	 */
	public int getcustomerOptometryBasicCount(String customerID);

	/**
	 * 得到所有顾客验光病历,验光基表对应的
	 * 
	 * @return
	 */
	public List<OptometryPo> getcustomerOptometrys(String basicID);
	
	/**
	 * 得到验光基表对象
	 * 
	 * @param optometryBasicID
	 * @return
	 */
	public OptometryBasicPo getOptometryBasicPo(String optometryBasicID);

	/**
	 * 取验光基表下有几个验光病历
	 * 
	 * @param optometryBasicID
	 * @return
	 */
	public int getOptometryCount(String optometryBasicID);

}
