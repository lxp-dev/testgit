package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;

public interface AdditionalCDetailMgr {

	/**插入附加费用
	 * @param inTransitPo
	 */
	public void insertAdditionalCDetail(AdditionalCDetailPo additionalCDetailPo);
	
	public List<AdditionalCDetailPo> getAdditionalCDetailPos(String salesID);
}
