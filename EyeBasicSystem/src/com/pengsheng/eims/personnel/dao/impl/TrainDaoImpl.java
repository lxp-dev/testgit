package com.pengsheng.eims.personnel.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.personnel.dao.TrainDao;
import com.pengsheng.eims.personnel.persistence.MonthWagePo;
import com.pengsheng.eims.personnel.persistence.TrainPo;
import com.pengsheng.eims.personnel.persistence.TrainContentPo;
import com.pengsheng.eims.personnel.persistence.WagePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class TrainDaoImpl  extends BaseJdbcDaoSupport implements TrainDao
{
	public void deleteTrainPo(TrainPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" delete from M_Train where M_T_TrainID = ? ");
		
		params.add(po.getMttrainid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void deleteTrainResultsPo(TrainPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" delete from M_TrainResults where M_TP_TrainID = ? ");
		
		params.add(po.getMttrainid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public int getTrainCount(TrainPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("SELECT Count(*) ");
		buffer.append("FROM   M_Train ");
		buffer.append("       LEFT JOIN dbo.SYS_PersonInfo AS cp ");
		buffer.append("         ON cp.id = M_T_CreatPersonID ");
		buffer.append("WHERE  1 = 1 ");
		
		if (!"".equals(Utility.getName(po.getTrainpersonid()))) {
			buffer.append("       AND M_T_TrainPersonID  = ? ");
			params.add(po.getTrainpersonid());
		}
		
		if (!"".equals(Utility.getName(po.getTrainpersonname()))) {
			buffer.append("       AND pp.personName LIKE '%'+?+'%' ");
			params.add(po.getTrainpersonname());
		}
		
		if (!"".equals(Utility.getName(po.getPbgncreatdate()))) {
			buffer.append("       AND CONVERT(VARCHAR(10), M_T_TrainDate, 23) >= ? ");
			params.add(po.getPbgncreatdate());
		}
		
		if (!"".equals(Utility.getName(po.getPendcreatdate()))) {
			buffer.append("       AND CONVERT(VARCHAR(10), M_T_TrainDate, 23) <= ? ");
			params.add(po.getPendcreatdate());
		}
		
		if (!"".equals(Utility.getName(po.getTrainid()))) {
			buffer.append("       AND M_T_TrainID LIKE '%'+?+'%' ");
			params.add(po.getTrainid());
		}
		
		if (!"".equals(Utility.getName(po.getTraintittle()))) {
			buffer.append("       AND M_T_TrainTittle like '%' + ? + '%' ");
			params.add(po.getTraintittle());
		}
		
		if (!"".equals(Utility.getName(po.getCreatpersonname()))) {
			buffer.append("       AND cp.personName LIKE '%'+?+'%' ");
			params.add(po.getCreatpersonname());
		}
		
		if (!"".equals(Utility.getName(po.getCreatpersonid()))) {
			buffer.append("       AND M_T_CreatPersonID = ? ");
			params.add(po.getCreatpersonid());
		}
		
		if (!"".equals(Utility.getName(po.getBgncreatdate()))) {
			buffer.append("       AND CONVERT(VARCHAR(10), M_T_CreatDate, 23) >= ? ");
			params.add(po.getBgncreatdate());
		}
		
		if (!"".equals(Utility.getName(po.getEndcreatdate()))) {
			buffer.append("       AND CONVERT(VARCHAR(10), M_T_CreatDate, 23) <= ? ");
			params.add(po.getEndcreatdate());
		}
		
		if (!"".equals(Utility.getName(po.getRemark()))) {
			buffer.append("       AND M_T_Remark LIKE '%'+?+'%' ");
			params.add(po.getRemark());
		}

		return getJdbcTemplate().queryForInt(buffer.toString(),	params.toArray());
	}

	public TrainPo getTrainPo(
			TrainPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("select top 1 ");
		buffer.append("M_T_UUID 			as mtuuid, ");
		buffer.append("M_T_TrainID 			as mttrainid, ");
		buffer.append("M_T_CreatPersonID 	as mtcreatpersonid, ");
		buffer.append("cp.personName		as mtcreatpersonname, ");
		buffer.append("M_T_TrainPersonID 	as mttrainpersonid, ");
		buffer.append("M_T_TrainDate		as mttraindate, ");
		buffer.append("M_T_CreatDate 		as mtcreatdate, ");
		buffer.append("M_T_TrainTittle 		as mttraintittle, ");
		buffer.append("M_T_TrainContent		as mttraincontent, ");
		buffer.append("M_T_Remark 			as mtremark ");
		buffer.append("FROM   M_Train ");
		buffer.append("LEFT JOIN dbo.SYS_PersonInfo AS cp ON cp.id = M_T_CreatPersonID ");
		buffer.append("WHERE  1 = 1 ");
		
		if (!"".equals(Utility.getName(po.getTrainpersonid()))) {
			buffer.append("       AND M_T_TrainPersonID  = ? ");
			params.add(po.getTrainpersonid());
		}
		
		if (!"".equals(Utility.getName(po.getTrainpersonname()))) {
			buffer.append("       AND pp.personName LIKE '%'+?+'%' ");
			params.add(po.getTrainpersonname());
		}
		
		if (!"".equals(Utility.getName(po.getPbgncreatdate()))) {
			buffer.append("       AND CONVERT(VARCHAR(10), M_T_TrainDate, 23) >= ? ");
			params.add(po.getPbgncreatdate());
		}
		
		if (!"".equals(Utility.getName(po.getPendcreatdate()))) {
			buffer.append("       AND CONVERT(VARCHAR(10), M_T_TrainDate, 23) <= ? ");
			params.add(po.getPendcreatdate());
		}
		
		if (!"".equals(Utility.getName(po.getTrainid()))) {
			buffer.append("       AND M_T_TrainID LIKE '%'+?+'%' ");
			params.add(po.getTrainid());
		}
		
		if (!"".equals(Utility.getName(po.getTraintittle()))) {
			buffer.append("       AND M_T_TrainTittle like '%' + ? + '%' ");
			params.add(po.getTraintittle());
		}
		
		if (!"".equals(Utility.getName(po.getCreatpersonname()))) {
			buffer.append("       AND cp.personName LIKE '%'+?+'%' ");
			params.add(po.getCreatpersonname());
		}
		
		if (!"".equals(Utility.getName(po.getCreatpersonid()))) {
			buffer.append("       AND M_T_CreatPersonID = ? ");
			params.add(po.getCreatpersonid());
		}
		
		if (!"".equals(Utility.getName(po.getBgncreatdate()))) {
			buffer.append("       AND CONVERT(VARCHAR(10), M_T_CreatDate, 23) >= ? ");
			params.add(po.getBgncreatdate());
		}
		
		if (!"".equals(Utility.getName(po.getEndcreatdate()))) {
			buffer.append("       AND CONVERT(VARCHAR(10), M_T_CreatDate, 23) <= ? ");
			params.add(po.getEndcreatdate());
		}
		
		if (!"".equals(Utility.getName(po.getRemark()))) {
			buffer.append("       AND M_T_Remark LIKE '%'+?+'%' ");
			params.add(po.getRemark());
		}
		
		return (TrainPo) queryForObject(buffer.toString(), params
				.toArray(), TrainPo.class);
	}

	public void insertTrainPo(TrainPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO M_Train ");
		buffer.append("            (M_T_UUID, ");
		buffer.append("             M_T_TrainID, ");
		buffer.append("             M_T_TrainPersonID, ");
		buffer.append("             M_T_TrainDate, ");
		buffer.append("             M_T_CreatPersonID, ");
		buffer.append("             M_T_CreatDate, ");
		buffer.append("             M_T_TrainTittle, ");
		buffer.append("             M_T_TrainContent, ");
		buffer.append("             M_T_Remark) ");
		buffer.append("VALUES      (?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("     getdate(), ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?) ");
		
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(po.getMttrainid()));
		params.add(Utility.getName(po.getMttrainpersonid()));
		params.add(Utility.getName(po.getMttraindate()));
		params.add(Utility.getName(po.getMtcreatpersonid()));
		params.add(Utility.getName(po.getMttraintittle()));
		params.add(Utility.getName(po.getMttraincontent()));
		params.add(Utility.getName(po.getMtremark()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void updateTrainPo(TrainPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("Update M_Train set ");
		buffer.append("       M_T_TrainTittle = ?, ");
		buffer.append("       M_T_TrainPersonID = ?, ");
		buffer.append("       M_T_TrainDate = ?, ");
		buffer.append("       M_T_TrainContent = ?, ");
		buffer.append("       M_T_Remark = ? ");
		buffer.append("Where  M_T_TrainID = ? ");
		
		params.add(Utility.getName(po.getMttraintittle()));
		params.add(Utility.getName(po.getMttrainpersonid()));
		params.add(Utility.getName(po.getMttraindate()));
		params.add(Utility.getName(po.getMttraincontent()));
		params.add(Utility.getName(po.getMtremark()));
		
		params.add(Utility.getName(po.getMttrainid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void updateTrainResultsPo(TrainPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("Update M_TrainResults ");
		buffer.append("             M_TP_PersonID, ");
		buffer.append("             M_TP_Results ");
		buffer.append("VALUES      (?, ");
		buffer.append("             ?) ");
		buffer.append("Where  M_TP_TrainID = ? ");
		buffer.append("  And  M_TP_PersonID = ? ");
		
		params.add(Utility.getName(po.getMtppersonid()));
		params.add(Utility.getName(po.getMtpresults()));
		
		params.add(Utility.getName(po.getMtptrainid()));
		params.add(Utility.getName(po.getMtppersonid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public List<TrainPo> getTrains(
			TrainPo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select * from ( ");
		buffer.append("select ROW_NUMBER() Over(order by M_T_CreatDate desc) as rowNum, ");
		buffer.append("M_T_UUID 			as mtuuid, ");
		buffer.append("M_T_TrainID 			as mttrainid, ");
		buffer.append("M_T_CreatPersonID 	as mtcreatpersonid, ");
		buffer.append("cp.personName		as mtcreatpersonname, ");
		buffer.append("M_T_TrainPersonID 	as mttrainpersonid, ");
		buffer.append("pp.personName		as mttrainpersonname, ");
		buffer.append("M_T_TrainDate		as mttraindate, ");
		buffer.append("M_T_CreatDate 		as mtcreatdate, ");
		buffer.append("M_T_TrainTittle 		as mttraintittle, ");
		buffer.append("M_T_TrainContent		as mttraincontent, ");
		buffer.append("M_T_Remark 			as mtremark ");
		buffer.append("FROM   M_Train ");
		buffer.append("       LEFT JOIN dbo.SYS_PersonInfo AS cp ");
		buffer.append("         ON cp.id = M_T_CreatPersonID ");
		buffer.append("       LEFT JOIN dbo.SYS_PersonInfo AS pp ");
		buffer.append("         ON pp.id = M_T_TrainPersonID ");
		buffer.append("WHERE  1 = 1 ");
		
		if (!"".equals(Utility.getName(po.getTrainpersonid()))) {
			buffer.append("       AND M_T_TrainPersonID  = ? ");
			params.add(po.getTrainpersonid());
		}
		
		if (!"".equals(Utility.getName(po.getTrainpersonname()))) {
			buffer.append("       AND pp.personName LIKE '%'+?+'%' ");
			params.add(po.getTrainpersonname());
		}
		
		if (!"".equals(Utility.getName(po.getPbgncreatdate()))) {
			buffer.append("       AND CONVERT(VARCHAR(10), M_T_TrainDate, 23) >= ? ");
			params.add(po.getPbgncreatdate());
		}
		
		if (!"".equals(Utility.getName(po.getPendcreatdate()))) {
			buffer.append("       AND CONVERT(VARCHAR(10), M_T_TrainDate, 23) <= ? ");
			params.add(po.getPendcreatdate());
		}
		
		if (!"".equals(Utility.getName(po.getTrainid()))) {
			buffer.append("       AND M_T_TrainID LIKE '%'+?+'%' ");
			params.add(po.getTrainid());
		}
		
		if (!"".equals(Utility.getName(po.getTraintittle()))) {
			buffer.append("       AND M_T_TrainTittle like '%' + ? + '%' ");
			params.add(po.getTraintittle());
		}
		
		if (!"".equals(Utility.getName(po.getCreatpersonname()))) {
			buffer.append("       AND cp.personName LIKE '%'+?+'%' ");
			params.add(po.getCreatpersonname());
		}
		
		if (!"".equals(Utility.getName(po.getCreatpersonid()))) {
			buffer.append("       AND M_T_CreatPersonID = ? ");
			params.add(po.getCreatpersonid());
		}
		
		if (!"".equals(Utility.getName(po.getBgncreatdate()))) {
			buffer.append("       AND CONVERT(VARCHAR(10), M_T_CreatDate, 23) >= ? ");
			params.add(po.getBgncreatdate());
		}
		
		if (!"".equals(Utility.getName(po.getEndcreatdate()))) {
			buffer.append("       AND CONVERT(VARCHAR(10), M_T_CreatDate, 23) <= ? ");
			params.add(po.getEndcreatdate());
		}
		
		if (!"".equals(Utility.getName(po.getRemark()))) {
			buffer.append("       AND M_T_Remark LIKE '%'+?+'%' ");
			params.add(po.getRemark());
		}
		
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), params.toArray(),
				TrainPo.class);
	}
	
	public List<TrainPo> getTrainResults(TrainPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select ");
		buffer.append("M_TP_UUID 			as mtpuuid, ");
		buffer.append("M_TP_TrainID 		as mtptrainid, ");
		buffer.append("M_TP_PersonID 		as mtppersonid, ");
		buffer.append("personName 			as mtppersonName, ");
		buffer.append("M_TP_Results			as mtpresults ");
		buffer.append("FROM   M_TrainResults ");
		buffer.append("LEFT JOIN dbo.SYS_PersonInfo ON id = M_TP_PersonID ");
		buffer.append("WHERE M_TP_TrainID = ? ");
		
		params.add(po.getTrainid());
		
		return this.queryForObjectList(buffer.toString(), params.toArray(),
				TrainPo.class);
	}


	public void insertTrainResultsPo(TrainPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO M_TrainResults ");
		buffer.append("            (M_TP_UUID, ");
		buffer.append("             M_TP_TrainID, ");
		buffer.append("             M_TP_PersonID, ");
		buffer.append("             M_TP_Results) ");
		buffer.append("VALUES      (?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?) ");
		
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(po.getMtptrainid()));
		params.add(Utility.getName(po.getMtppersonid()));
		params.add(Utility.getName(po.getMtpresults()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}
