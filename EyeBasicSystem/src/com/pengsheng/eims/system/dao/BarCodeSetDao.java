package com.pengsheng.eims.system.dao;

import java.util.List;

import com.pengsheng.eims.system.persistence.BarCodeSetPo;

public interface BarCodeSetDao {
	
	public int getBarCodeSetCount(BarCodeSetPo barCodeSetPo);
	
	public List<BarCodeSetPo> getBarCodeSetList(BarCodeSetPo barCodeSetPo, int start, int size);
	
	public void insertBarCodeSet(BarCodeSetPo barCodeSetPo);
	
	public void updateBarCodeSet(BarCodeSetPo barCodeSetPo);
	
	public void deleteBarCodeSet(BarCodeSetPo barCodeSetPo);	
	
	public int isBarCodeSet(BarCodeSetPo barCodeSetPo);
	
	public void insertBarCodeSetForGoods(BarCodeSetPo barCodeSetPo);
	
	public BarCodeSetPo getBarCodeSetPo(BarCodeSetPo barCodeSetPo);
	
}
