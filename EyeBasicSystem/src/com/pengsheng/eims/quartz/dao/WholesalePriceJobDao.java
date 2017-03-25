package com.pengsheng.eims.quartz.dao;

import java.util.List;

import com.pengsheng.eims.storage.persistence.WholesalePriceEntryPo;

public interface WholesalePriceJobDao {
	public void wholesalePriceEffective(WholesalePriceEntryPo wholesalePriceEntryPo);
	public List<WholesalePriceEntryPo> getWholesalePriceEffectiveList(String date);
	public void updateEffectiveState(WholesalePriceEntryPo wholesalePriceEntryPo);
}
