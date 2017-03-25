package com.pengsheng.eims.quartz.dao;

import java.util.List;

import com.pengsheng.eims.storage.persistence.AdjustmentPriceEntryPo;

public interface AdjustmentPriceJobDao {
	public void adjustmentPriceEffective(AdjustmentPriceEntryPo adjustmentPriceEntryPo);
	public List<AdjustmentPriceEntryPo> getAdjustmentPriceEffectiveList(String date);
	public void updateEffectiveState(AdjustmentPriceEntryPo adjustmentPriceEntryPo);
	
	public void updateAdjustmentPriceEffectiveFlySheet(AdjustmentPriceEntryPo adjustmentPriceEntryPo);
}
