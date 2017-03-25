package com.pengsheng.eims.system.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.system.persistence.DiscountShortcutKeysDetailsPo;
import com.pengsheng.eims.system.persistence.DiscountShortcutKeysPo;

/**
 * 折扣快捷鍵Dao
 * @author sxh
 *
 */
public interface DiscountShortcutKeysDao {

	public void insertDiscountShortcutKeys(DiscountShortcutKeysPo po);
	
	public void updateDiscountShortcutKeys(DiscountShortcutKeysPo po);	
	
	public void deleteDiscountShortcutKeys(DiscountShortcutKeysPo po);
	
	public DiscountShortcutKeysPo getDiscountShortcutKeysPo(DiscountShortcutKeysPo po);
	
	public List<DiscountShortcutKeysPo> getDiscountShortcutKeysPoList();
	
	public void updateDiscountShortcutKeysEnable(DiscountShortcutKeysPo po);
	
	public List<DiscountShortcutKeysPo> getEnableDiscountShortcutKeysPoList(String isshow);
	
	public void updateDiscountShortcutKeysIsShow(DiscountShortcutKeysPo po);
	/*
	 * 
	 * 添加时判断打折码是否重复
	 * 
	 */
	public int getShortcutKeysPoId(DiscountShortcutKeysPo po) ;
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
	
	public void insertDiscountShortcutKeysDetails(DiscountShortcutKeysDetailsPo po);
	
	public List<DiscountShortcutKeysDetailsPo> selectDiscountShortcutKeysDetails(DiscountShortcutKeysDetailsPo po);
	
	public void deleteDiscountShortcutKeysDetails(String pid);
}
