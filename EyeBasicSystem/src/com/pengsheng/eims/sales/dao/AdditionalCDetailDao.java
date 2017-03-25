package com.pengsheng.eims.sales.dao;

import java.util.List;

import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;


public interface AdditionalCDetailDao {

	
	
	/**插入附加费用
	 * @param inTransitPo
	 */
	public void insertAdditionalCDetail(AdditionalCDetailPo additionalCDetailPo);
	
	public List<AdditionalCDetailPo> getAdditionalCDetailPos(String salesID);
}
