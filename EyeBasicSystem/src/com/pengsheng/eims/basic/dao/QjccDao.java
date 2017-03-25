package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.QjccPo;
import com.pengsheng.eims.basic.persistence.QjccTypePo;

public interface QjccDao {
	
	public List<QjccTypePo> getQjccTypeList(); 	
	
	public List<QjccTypePo> getQjccTypeMinList(QjccTypePo qjccTypePo); 
	
	public void insertQjcc(QjccPo qjccPo);
	
	public QjccPo getQjccPo(QjccPo qjccPo);
	
	public int getQjccCount(QjccPo qjccPo);
	
	public List<QjccPo> getQjccList(QjccPo qjccPo, int start, int size);
	
	public void updateQjcc(QjccPo qjccPo);
	
	public void deleteQjcc(QjccPo qjccPo);
}
