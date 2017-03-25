package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.ContractDao;
import com.pengsheng.eims.basic.persistence.ContractPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ContractDaoImpl extends BaseJdbcDaoSupport implements ContractDao {

	/**
	 * 查询制造商合同的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getContractCount(ContractPo po) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(B_CT_ID) from B_Contract where B_CT_SupplierID=? ");
		params.add(Utility.getName(po.getBctsupplierid()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());

	}
	
	/**
	 * 
	 * 遍历制造商合同并实现分页
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ContractPo> getContractList(ContractPo po,int start, int size) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select temp.B_CT_ID as bctid, temp.B_CT_ContractTitle as bctcontracttitle, temp.B_CT_ContractContent as bctcontractcontent, ");
		buffer.append("temp.B_CT_ContractStartDate as bctcontractstartdate, temp.B_CT_ContractEndDate as bctcontractenddate, ");
		buffer.append("temp.B_CT_SaveFileName as saveFileName");
		buffer.append(" from(select ROW_NUMBER() Over(order by B_CT_ID) as rowNum, * from B_Contract where B_CT_SupplierID=? ");
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ (start + size));

		params.add(Utility.getName(po.getBctsupplierid()));
		
		return queryForObjectList(buffer.toString(), params.toArray(), ContractPo.class);

	}

	/**
	 * 查询制造商合同信息
	 * 
	 * @param po
	 * @return
	 */
	public ContractPo getContract(ContractPo po) {
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("select top 1 B_CT_ID as bctid, B_CT_ContractTitle as bctcontracttitle, ");
		buffer.append("B_CT_ContractContent as bctcontractcontent, ");
		buffer.append("B_CT_ContractStartDate as bctcontractstartdate, B_CT_ContractEndDate as bctcontractenddate, ");
		buffer.append("B_CT_DocumentUrl as documentUrl, ");
		buffer.append("B_CT_ContentType as contentType, ");
		buffer.append("B_CT_SaveFileName as saveFileName ");
		buffer.append(" from B_Contract where B_CT_ID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(po.getBctid());

		return (ContractPo)queryForObject(buffer.toString(), params.toArray(), ContractPo.class);
	}

	/**
	 * 新增制造商合同信息
	 * 
	 * @param po
	 * @param logPo
	 */
	public void insertContract(ContractPo contractPo) {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("insert into B_Contract ");
		buffer.append("(B_CT_ID ");
		buffer.append(",B_CT_ContractTitle ");
		buffer.append(",B_CT_ContractContent ");
		buffer.append(",B_CT_ContractStartDate ");
		buffer.append(",B_CT_ContractEndDate ");
		buffer.append(",B_CT_DocumentUrl ");
		buffer.append(",B_CT_ContentType ");
		buffer.append(",B_CT_SaveFileName,B_CT_SupplierID) ");
		buffer.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?,?) ");

		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(contractPo.getBctcontracttitle()));
		params.add(Utility.getName(contractPo.getBctcontractcontent()));
		params.add(Utility.getName(contractPo.getBctcontractstartdate()));
		params.add(Utility.getName(contractPo.getBctcontractenddate()));
		params.add(Utility.getName(contractPo.getDocumentUrl()));
		params.add(Utility.getName(contractPo.getContentType()));
		params.add(Utility.getName(contractPo.getSaveFileName()));
		params.add(Utility.getName(contractPo.getBctsupplierid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 修改制造商合同信息
	 * 
	 * @param po
	 * @param logPo
	 */
	public void updateContract(ContractPo po) {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("update B_Contract set ");
		buffer.append("B_CT_ContractTitle = ? ");
		buffer.append(",B_CT_ContractContent = ? ");
		buffer.append(",B_CT_ContractStartDate = ? ");
		buffer.append(",B_CT_ContractEndDate = ? ");
		if (!Utility.getName(po.getSaveFileName()).equals("")) {
			buffer.append(",B_CT_DocumentUrl = ? ");
			buffer.append(",B_CT_ContentType = ? ");
			buffer.append(",B_CT_SaveFileName = ? ");
		}
		buffer.append(" where B_CT_ID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBctcontracttitle()));
		params.add(Utility.getName(po.getBctcontractcontent()));
		params.add(Utility.getName(po.getBctcontractstartdate()));
		params.add(Utility.getName(po.getBctcontractenddate()));
		if (!Utility.getName(po.getSaveFileName()).equals("")) {
			params.add(Utility.getName(po.getDocumentUrl()));
			params.add(Utility.getName(po.getContentType()));
			params.add(Utility.getName(po.getSaveFileName()));
		}
		params.add(Utility.getName(po.getBctid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 删除制造商合同信息
	 * 
	 * @param po
	 * @param logPo
	 */
	public void deleteContract(ContractPo po) {

		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from B_Contract where B_CT_ID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBctid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
}
