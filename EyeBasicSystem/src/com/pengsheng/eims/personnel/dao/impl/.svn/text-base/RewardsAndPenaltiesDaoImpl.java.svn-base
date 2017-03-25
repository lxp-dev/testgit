package com.pengsheng.eims.personnel.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.personnel.dao.RewardsAndPenaltiesDao;
import com.pengsheng.eims.personnel.persistence.MonthWagePo;
import com.pengsheng.eims.personnel.persistence.RewardsAndPenaltiesPo;
import com.pengsheng.eims.personnel.persistence.TrainContentPo;
import com.pengsheng.eims.personnel.persistence.WagePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class RewardsAndPenaltiesDaoImpl  extends BaseJdbcDaoSupport implements RewardsAndPenaltiesDao
{
	public void deleteRewardsAndPenaltiesPo(RewardsAndPenaltiesPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" delete from M_RewardsAndPenalties where M_RP_RewardsAndPenaltiesID = ? ");
		
		params.add(po.getMrprewardsandpenaltiesid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}


	public int getRewardsAndPenaltiesCount(RewardsAndPenaltiesPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("SELECT Count(*) ");
		buffer.append("FROM   M_RewardsAndPenalties ");
		buffer.append("       LEFT JOIN dbo.SYS_PersonInfo AS jcp ");
		buffer.append("         ON jcp.id = M_RP_Personid ");
		buffer.append("       LEFT JOIN dbo.SYS_PersonInfo AS cp ");
		buffer.append("         ON cp.id = M_RP_CreatPersonID ");
		buffer.append("WHERE  1 = 1 ");
		
		if (!"".equals(Utility.getName(po.getPersonname()))) {
			buffer.append("       AND jcp.personName LIKE '%'+?+'%' ");
			params.add(po.getPersonname());
		}
		
		if (!"".equals(Utility.getName(po.getPersonid()))) {
			buffer.append("       AND M_RP_Personid = ? ");
			params.add(po.getPersonid());
		}
		
		if (!"".equals(Utility.getName(po.getCreatpersonname()))) {
			buffer.append("       AND cp.personName LIKE '%'+?+'%' ");
			params.add(po.getCreatpersonname());
		}
		
		if (!"".equals(Utility.getName(po.getCreatpersonid()))) {
			buffer.append("       AND M_RP_CreatPersonID = ? ");
			params.add(po.getCreatpersonid());
		}
		
		if (!"".equals(Utility.getName(po.getRewardsorpenalties()))) {
			buffer.append("       AND M_RP_RewardsOrPenalties = ? ");
			params.add(po.getRewardsorpenalties());
		}
		
		if (!"".equals(Utility.getName(po.getRewardsandpenaltiesid()))) {
			buffer.append("       AND M_RP_RewardsAndPenaltiesID LIKE '%'+?+'%' ");
			params.add(po.getRewardsandpenaltiesid());
		}
		
		if (!"".equals(Utility.getName(po.getBgncreatdate()))) {
			buffer.append("       AND CONVERT(VARCHAR(10), M_RP_CreatDate, 23) >= ? ");
			params.add(po.getBgncreatdate());
		}
		
		if (!"".equals(Utility.getName(po.getEndcreatdate()))) {
			buffer.append("       AND CONVERT(VARCHAR(10), M_RP_CreatDate, 23) <= ? ");
			params.add(po.getEndcreatdate());
		}
		
		if (!"".equals(Utility.getName(po.getRemark()))) {
			buffer.append("       AND M_RP_Remark LIKE '%'+?+'%' ");
			params.add(po.getRemark());
		}

		return getJdbcTemplate().queryForInt(buffer.toString(),	params.toArray());
	}

	public RewardsAndPenaltiesPo getRewardsAndPenaltiesPo(
			RewardsAndPenaltiesPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select ");
		buffer.append("M_RP_UUID	as	mrpuuid, ");
		buffer.append("M_RP_RewardsAndPenaltiesID	as	mrprewardsandpenaltiesid, ");
		buffer.append("M_RP_Personid	as	mrppersonid, ");
		buffer.append("jcp.personName	as	mrppersonname, ");
		buffer.append("M_RP_RewardsOrPenalties	as mrprewardsorpenalties, ");
		buffer.append("M_RP_RewardsOrPenaltiesNum	as	mrprewardsorpenaltiesnum, ");
		buffer.append("M_RP_Remark	as	mrpremark, ");
		buffer.append("M_RP_CreatPersonID	as	mrpcreatpersonid, ");
		buffer.append("cp.personName	as	mrpcreatpersonname, ");
		buffer.append("M_RP_CreatDate	as	mrpcreatdate, ");
		buffer.append("M_RP_RewardsReason	as	mrprewardsreason, ");
		buffer.append("M_RP_PenaltiesReason	as	mrppenaltiesreason ");
		buffer.append("FROM   M_RewardsAndPenalties ");
		buffer.append("       LEFT JOIN dbo.SYS_PersonInfo AS jcp ");
		buffer.append("         ON jcp.id = M_RP_Personid ");
		buffer.append("       LEFT JOIN dbo.SYS_PersonInfo AS cp ");
		buffer.append("         ON cp.id = M_RP_CreatPersonID ");
		buffer.append("WHERE  1 = 1 ");
		
		if (!"".equals(Utility.getName(po.getPersonname()))) {
			buffer.append("       AND jcp.personName LIKE '%'+?+'%' ");
			params.add(po.getPersonname());
		}
		
		if (!"".equals(Utility.getName(po.getPersonid()))) {
			buffer.append("       AND M_RP_Personid = ? ");
			params.add(po.getPersonid());
		}
		
		if (!"".equals(Utility.getName(po.getPersonname()))) {
			buffer.append("       AND cp.personName LIKE '%'+?+'%' ");
			params.add(po.getPersonname());
		}
		
		if (!"".equals(Utility.getName(po.getCreatpersonid()))) {
			buffer.append("       AND M_RP_CreatPersonID = ? ");
			params.add(po.getCreatpersonid());
		}
		
		if (!"".equals(Utility.getName(po.getRewardsorpenalties()))) {
			buffer.append("       AND M_RP_RewardsOrPenalties = ? ");
			params.add(po.getRewardsorpenalties());
		}
		
		if (!"".equals(Utility.getName(po.getRewardsandpenaltiesid()))) {
			buffer.append("       AND M_RP_RewardsAndPenaltiesID LIKE '%'+?+'%' ");
			params.add(po.getRewardsandpenaltiesid());
		}
		
		if (!"".equals(Utility.getName(po.getBgncreatdate()))) {
			buffer.append("       AND CONVERT(VARCHAR(10), M_RP_CreatDate, 23) >= ? ");
			params.add(po.getBgncreatdate());
		}
		
		if (!"".equals(Utility.getName(po.getEndcreatdate()))) {
			buffer.append("       AND CONVERT(VARCHAR(10), M_RP_CreatDate, 23) <= ? ");
			params.add(po.getEndcreatdate());
		}
		
		if (!"".equals(Utility.getName(po.getRemark()))) {
			buffer.append("       AND M_RP_Remark LIKE '%'+?+'%' ");
			params.add(po.getRemark());
		}
		
		return (RewardsAndPenaltiesPo) queryForObject(buffer.toString(), params
				.toArray(), RewardsAndPenaltiesPo.class);
	}

	public void insertRewardsAndPenaltiesPo(RewardsAndPenaltiesPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO M_RewardsAndPenalties ");
		buffer.append("            (M_RP_UUID, ");
		buffer.append("             M_RP_RewardsAndPenaltiesID, ");
		buffer.append("             M_RP_Personid, ");
		buffer.append("             M_RP_RewardsOrPenalties, ");
		buffer.append("             M_RP_RewardsOrPenaltiesNum, ");
		buffer.append("             M_RP_Remark, ");
		buffer.append("             M_RP_CreatPersonID, ");
		buffer.append("             M_RP_CreatDate, ");
		buffer.append("             M_RP_RewardsReason, ");
		buffer.append("             M_RP_PenaltiesReason) ");
		buffer.append("VALUES     ( ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("     getdate(), ");
		buffer.append("             ?, ");
		buffer.append("             ? ) ");	
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(po.getMrprewardsandpenaltiesid()));
		params.add(Utility.getName(po.getMrppersonid()));
		params.add(Utility.getName(po.getMrprewardsorpenalties()));
		params.add(Utility.getName(po.getMrprewardsorpenaltiesnum()));
		params.add(Utility.getName(po.getMrpremark()));
		params.add(Utility.getName(po.getMrpcreatpersonid()));
		params.add(Utility.getName(po.getMrprewardsreason()));
		params.add(Utility.getName(po.getMrppenaltiesreason()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void updateRewardsAndPenaltiesPo(RewardsAndPenaltiesPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("Update M_RewardsAndPenalties set ");
		buffer.append("             M_RP_Personid = ?, ");
		buffer.append("             M_RP_RewardsOrPenalties = ?, ");
		buffer.append("             M_RP_RewardsOrPenaltiesNum = ?, ");
		buffer.append("             M_RP_Remark = ?, ");
		buffer.append("             M_RP_RewardsReason = ?, ");
		buffer.append("             M_RP_PenaltiesReason = ? ");
		buffer.append("Where M_RP_RewardsAndPenaltiesID = ? ");
		
		
		params.add(Utility.getName(po.getMrppersonid()));
		params.add(Utility.getName(po.getMrprewardsorpenalties()));
		params.add(Utility.getName(po.getMrprewardsorpenaltiesnum()));
		params.add(Utility.getName(po.getMrpremark()));
		params.add(Utility.getName(po.getMrprewardsreason()));
		params.add(Utility.getName(po.getMrppenaltiesreason()));
		
		params.add(Utility.getName(po.getMrprewardsandpenaltiesid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}


	public List<RewardsAndPenaltiesPo> getRewardsAndPenalties(
			RewardsAndPenaltiesPo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select * from ( ");
		buffer.append("select ROW_NUMBER() Over(order by M_RP_CreatDate desc) as rowNum, ");
		buffer.append("M_RP_UUID	as	mrpuuid, ");
		buffer.append("M_RP_RewardsAndPenaltiesID	as	mrprewardsandpenaltiesid, ");
		buffer.append("M_RP_Personid	as	mrppersonid, ");
		buffer.append("jcp.personName	as	mrppersonname, ");
		buffer.append("M_RP_RewardsOrPenalties	as	mrprewardsorpenalties, ");
		buffer.append("M_RP_RewardsOrPenaltiesNum	as	mrprewardsorpenaltiesnum, ");
		buffer.append("M_RP_Remark	as	mrpremark, ");
		buffer.append("M_RP_CreatPersonID	as	mrpcreatpersonid, ");
		buffer.append("cp.personName	as	mrpcreatpersonname, ");
		buffer.append("M_RP_CreatDate	as	mrpcreatdate, ");
		buffer.append("M_RP_RewardsReason	as	mrprewardsreason, ");
		buffer.append("M_RP_PenaltiesReason	as	mrppenaltiesreason ");
		buffer.append("FROM   M_RewardsAndPenalties ");
		buffer.append("       LEFT JOIN dbo.SYS_PersonInfo AS jcp ");
		buffer.append("         ON jcp.id = M_RP_Personid ");
		buffer.append("       LEFT JOIN dbo.SYS_PersonInfo AS cp ");
		buffer.append("         ON cp.id = M_RP_CreatPersonID ");
		buffer.append("WHERE  1 = 1 ");
		
		if (!"".equals(Utility.getName(po.getPersonname()))) {
			buffer.append("       AND jcp.personName LIKE '%'+?+'%' ");
			params.add(po.getPersonname());
		}
		
		if (!"".equals(Utility.getName(po.getPersonid()))) {
			buffer.append("       AND M_RP_Personid = ? ");
			params.add(po.getPersonid());
		}
		
		if (!"".equals(Utility.getName(po.getCreatpersonname()))) {
			buffer.append("       AND cp.personName LIKE '%'+?+'%' ");
			params.add(po.getCreatpersonname());
		}
		
		if (!"".equals(Utility.getName(po.getCreatpersonid()))) {
			buffer.append("       AND M_RP_CreatPersonID = ? ");
			params.add(po.getCreatpersonid());
		}
		
		if (!"".equals(Utility.getName(po.getRewardsorpenalties()))) {
			buffer.append("       AND M_RP_RewardsOrPenalties = ? ");
			params.add(po.getRewardsorpenalties());
		}
		
		if (!"".equals(Utility.getName(po.getRewardsandpenaltiesid()))) {
			buffer.append("       AND M_RP_RewardsAndPenaltiesID LIKE '%'+?+'%' ");
			params.add(po.getRewardsandpenaltiesid());
		}
		
		if (!"".equals(Utility.getName(po.getBgncreatdate()))) {
			buffer.append("       AND CONVERT(VARCHAR(10), M_RP_CreatDate, 23) >= ? ");
			params.add(po.getBgncreatdate());
		}
		
		if (!"".equals(Utility.getName(po.getEndcreatdate()))) {
			buffer.append("       AND CONVERT(VARCHAR(10), M_RP_CreatDate, 23) <= ? ");
			params.add(po.getEndcreatdate());
		}
		
		if (!"".equals(Utility.getName(po.getRemark()))) {
			buffer.append("       AND M_RP_Remark LIKE '%'+?+'%' ");
			params.add(po.getRemark());
		}
		
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), params.toArray(),
				RewardsAndPenaltiesPo.class);
	}
}
