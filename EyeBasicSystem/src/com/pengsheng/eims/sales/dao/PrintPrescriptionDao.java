package com.pengsheng.eims.sales.dao;

import java.util.List;

import com.pengsheng.eims.sales.persistence.InspectionPo;



public interface PrintPrescriptionDao {

	/**
	 * 查看打印处方信息
	 * @param optometryID
	 * @return
	 */
	public List<InspectionPo> getInspectionPos(String customerID);
}
