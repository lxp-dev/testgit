package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.ContractPo;

public interface ContractDao {

	/**
	 * 查询制造商合同的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getContractCount(ContractPo po);
	
	/**
	 * 
	 * 遍历制造商合同并实现分页
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ContractPo> getContractList(ContractPo po,int start, int size);

	/**
	 * 查询制造商合同信息
	 * 
	 * @param po
	 * @return
	 */
	public ContractPo getContract(ContractPo po);

	/**
	 * 新增制造商合同信息
	 * 
	 * @param po
	 * @param logPo
	 */
	public void insertContract(ContractPo po);

	/**
	 * 修改制造商合同信息
	 * 
	 * @param po
	 * @param logPo
	 */
	public void updateContract(ContractPo po);

	/**
	 * 删除制造商合同信息
	 * 
	 * @param po
	 * @param logPo
	 */
	public void deleteContract(ContractPo po);
	
}
