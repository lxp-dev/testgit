package com.pengsheng.eims.system.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.DiscountShortcutKeysDetailsPo;
import com.pengsheng.eims.system.persistence.DiscountShortcutKeysPo;

/**
 * 折扣快捷键维护
 * @author sxh
 *
 */
public interface DiscountShortcutKeysMgr {
	
	public void insertDiscountShortcutKeys(DiscountShortcutKeysPo po,DiscountShortcutKeysDetailsPo dpo,LogisticsLogPo logPo);
	
	public void updateDiscountShortcutKeys(DiscountShortcutKeysPo po,DiscountShortcutKeysDetailsPo dpo,LogisticsLogPo logPo);	
	
	public void deleteDiscountShortcutKeys(DiscountShortcutKeysPo po,LogisticsLogPo logPo);
	
	public DiscountShortcutKeysPo getDiscountShortcutKeysPo(DiscountShortcutKeysPo po);
	
	public List<DiscountShortcutKeysPo> getDiscountShortcutKeysPoList();
	
	public void updateDiscountShortcutKeysEnable(DiscountShortcutKeysPo po,LogisticsLogPo logPo);
	
	public List<DiscountShortcutKeysPo> getEnableDiscountShortcutKeysPoList(String isshow);
	
	public void updateDiscountShortcutKeysIsShow(DiscountShortcutKeysPo po,LogisticsLogPo logPo);
	/*
	 * 
	 * 添加时判断打折码是否重复
	 * 
	 */
	public int getShortcutKeysPoId(DiscountShortcutKeysPo po);
	/*
	 * 
	 * 添加时判断快捷键名称是否重复
	 * 
	 */
	public int getShortcutKeysPoName(DiscountShortcutKeysPo po) ;
	/*
	 * 
	 * 修改时判断打折码是否重复
	 * 
	 */
	public int getShortcutKeysPoIdUpdate(DiscountShortcutKeysPo po) ;
	/*
	 * 
	 * 修改时判断快捷键名称是否重复
	 * 
	 */
	public int getShortcutKeysPoNameUpdate(DiscountShortcutKeysPo po) ;
	
	public List<DiscountShortcutKeysDetailsPo> selectDiscountShortcutKeysDetails(DiscountShortcutKeysDetailsPo po);
}
