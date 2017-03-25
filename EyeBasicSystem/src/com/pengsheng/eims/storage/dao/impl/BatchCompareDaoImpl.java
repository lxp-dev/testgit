package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.storage.dao.BatchCompareDao;
import com.pengsheng.eims.storage.persistence.BatchComparePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class BatchCompareDaoImpl extends BaseJdbcDaoSupport implements BatchCompareDao{

	public void insertBatchComparePo(BatchComparePo po) {
		StringBuffer  buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO C_SH_BatchCompare ");
		buffer.append("            (C_SH_BC_UUID, ");
		buffer.append("             C_SH_BC_Barcode, ");
		buffer.append("             C_SH_BC_GuaranteePeriod, ");
		buffer.append("             C_SH_BC_Batch, ");
		buffer.append("             C_SH_BC_SimpleBatch, ");
		buffer.append("             C_SH_BC_RegistrationNum) ");
		buffer.append("VALUES     ( ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ? ) ");
		
		params.add(this.uuid.generate());
		params.add(po.getCshbcbarcode());
		params.add(po.getCshbcguaranteeperiod());
		params.add(po.getCshbcbatch());
		params.add(po.getCshbcsimplebatch());
		params.add(Utility.getName(po.getCshregistrationnum()));
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}

	public BatchComparePo selectBatchComparePo(BatchComparePo po) {
		StringBuffer  buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT top 1 C_SH_BC_UUID as cshbcuuid, ");
		buffer.append("       C_SH_BC_Barcode as cshbcbarcode, ");
		buffer.append("       C_SH_BC_GuaranteePeriod as cshbcguaranteeperiod, ");
		buffer.append("       C_SH_BC_Batch as cshbcbatch, ");
		buffer.append("       C_SH_BC_SimpleBatch as cshbcsimplebatch ");
		buffer.append("FROM   C_SH_BatchCompare ");
		buffer.append("WHERE  C_SH_BC_Barcode like '%'+?+'%' ");
		params.add(po.getCshbcbarcode().substring(0, 24));
		if(!"".equals(Utility.getName(po.getCshbcbatch()))){
			buffer.append("       AND C_SH_BC_Batch = ? ");
			params.add(po.getCshbcbatch());
		}
		buffer.append("order by C_SH_BC_SimpleBatch desc");
		
		return (BatchComparePo)queryForObject(buffer.toString(), params.toArray(), BatchComparePo.class);
	}

}
