package com.pengsheng.eims.quartz.dao;

import java.util.List;

import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface AdConsignProcessTakeDao {
	
	/**
	 * 寰楀埌涓氬姟涓存椂琛ㄤ腑渚涘簲鍟唅d
	 * @return
	 */
	public List<InventoryPo> getSupplierid();
	
	/**
	 * 寰楀埌瀵瑰簲渚涘簲鍟嗙殑鏀惰揣鍗昳d
	 * @param supplier
	 * @return
	 */
	public InventoryPo getbillid(String subsupplier,String supplier,String companyID);
	
	/**
	 * 鏇存柊涓存椂琛ㄦ眹鎬绘爣璇嗗瓧娈�
	 * @param supplier
	 */
	public void updateInventoryTemp(String subsupplier,String supplier,String companyID);
	
	/**
	 * 鎻掑叆涓氬姟涓昏〃涓�
	 * @param billis
	 */
	public void insertInventory(String producedid , String billid);
	
	/**
	 * 鏂板涓氬姟鏄庣粏琛�
	 * @param supplierid
	 */
	public void insertInventoryEntry(String subsupplier,String producedid , String supplierid,String companyID);

}
