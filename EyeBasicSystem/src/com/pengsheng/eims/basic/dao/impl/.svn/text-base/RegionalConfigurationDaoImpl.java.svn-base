package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.RegionalConfigurationDao;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;

import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class RegionalConfigurationDaoImpl extends BaseJdbcDaoSupport implements
		RegionalConfigurationDao {

	public DepartmentsPo getDepartment(DepartmentsPo departmentsPo) {
		// TODO Auto-generated method stub

		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  B_DP_DepartmentID as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName  as BDPDepartmentName ");
		buffer.append(",B_DP_Type as BDPType ");
		buffer.append(",B_DP_RegID as bdpregid ");
		buffer.append("FROM B_Departments ");
		buffer.append("WHERE 1 = 1 ");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(departmentsPo.getBdpdepartmentid()))) {
			buffer.append("AND B_DP_DepartmentID = ? ");
			params.add(departmentsPo.getBdpdepartmentid());
		}

		if (!"".equals(Utility.getName(departmentsPo.getBdptype()))) {
			buffer.append("AND B_DP_Type = ? ");
			params.add(departmentsPo.getBdptype());
		}

		return (DepartmentsPo) queryForObject(buffer.toString(), params
				.toArray(), DepartmentsPo.class);
	}

	public List<DepartmentsPo> getMendianQuyuList(DepartmentsPo departmentsPo) {
		StringBuffer buffer = new StringBuffer();
		buffer
				.append("select B_Departments.B_DP_DepartmentID as bdpdepartmentid");
		buffer
				.append("       ,B_Departments.B_DP_DepartmentName as bdpdepartmentname");
		buffer.append("       ,B_Departments.B_DP_Type as bdptype");
		buffer.append("       ,d.regID as bdpregID,d.regName as bdpregName");
		buffer.append("   from B_Departments left join");
		buffer.append("   (select B_Departments.B_DP_DepartmentID as regID");
		buffer.append("       ,B_Departments.B_DP_DepartmentName as regName");
		buffer.append("    	from B_Departments");
		buffer.append("    )d on d.regID=B_Departments.B_DP_RegID");
		buffer.append("   where 1=1");
		if (!"".equals(Utility.getName(departmentsPo.getBdptype()))) {
			buffer.append(" and B_DP_Type='" + departmentsPo.getBdptype() + "'");
		}
		if (!"".equals(Utility.getName(departmentsPo.getBdpregid()))) {
			buffer.append(" and B_DP_RegID='" + departmentsPo.getBdpregid() + "'");
		}
		if (!"".equals(Utility.getName(departmentsPo.getBdpregname()))) {
			if ("yes".equals(Utility.getName(departmentsPo.getBdpregname()))) {
				buffer.append(" and B_Departments.B_DP_RegID is not null");
			} else if ("no".equals(Utility.getName(departmentsPo.getBdpregname()))) {
				buffer.append(" and B_Departments.B_DP_RegID is null");
			}
		}

		return queryForObjectList(buffer.toString(), null, DepartmentsPo.class);
	}
	

	public int getMendianQuyusCount(DepartmentsPo departmentsPo) 
	{
			StringBuffer buffer = new StringBuffer();
			buffer.append(" select count(B_Departments.B_DP_DepartmentID)");
			buffer.append("   from B_Departments left join");
			buffer.append("   (select B_Departments.B_DP_DepartmentID as regID");
			buffer.append("       ,B_Departments.B_DP_DepartmentName as regName");
			buffer.append("    	from B_Departments");
			buffer.append("    )d on d.regID=B_Departments.B_DP_RegID");
			buffer.append("   where 1=1");
			if (!"".equals(Utility.getName(departmentsPo.getBdptype()))) {
				buffer.append(" and B_DP_Type='" + departmentsPo.getBdptype() + "'");
			}
			if (!"".equals(Utility.getName(departmentsPo.getBdpregid()))) {
				buffer.append(" and B_DP_RegID='" + departmentsPo.getBdpregid() + "'");
			}
			if (!"".equals(Utility.getName(departmentsPo.getBdpregname()))) {
				if ("yes".equals(Utility.getName(departmentsPo.getBdpregname()))) {
					buffer.append(" and B_Departments.B_DP_RegID is not null");
				} else if ("no".equals(Utility.getName(departmentsPo.getBdpregname()))) {
					buffer.append(" and B_Departments.B_DP_RegID is null");
				}
			}
			if (!"".equals(Utility.getName(departmentsPo.getBdpcompanysid()))) {
				buffer.append(" AND B_DP_CompanysID = '" + Utility.getName(departmentsPo.getBdpcompanysid()) + "'");
			}			
			
			return getJdbcTemplate().queryForInt(buffer.toString());
		}


	public List<DepartmentsPo> getMendianQuyusList(DepartmentsPo departmentsPo, int start, int size) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(" select * from (");
			buffer.append(" select ROW_NUMBER() Over(order by B_Departments.B_DP_DepartmentID) as rowNum ");
			
			buffer.append("       ,B_Departments.B_DP_DepartmentID as bdpdepartmentid");
			buffer.append("       ,B_Departments.B_DP_DepartmentName as bdpdepartmentname");
			buffer.append("       ,B_Departments.B_DP_Type as bdptype");
			buffer.append("       ,d.regID as bdpregID,d.regName as bdpregName");
			buffer.append("   from B_Departments left join");
			buffer.append("   (select B_Departments.B_DP_DepartmentID as regID");
			buffer.append("       ,B_Departments.B_DP_DepartmentName as regName");
			buffer.append("    	from B_Departments");
			buffer.append("    )d on d.regID=B_Departments.B_DP_RegID");
			buffer.append("   where 1=1");
			if (!"".equals(Utility.getName(departmentsPo.getBdptype()))) {
				buffer.append(" and B_DP_Type='" + departmentsPo.getBdptype() + "'");
			}
			if (!"".equals(Utility.getName(departmentsPo.getBdpregid()))) {
				buffer.append(" and B_DP_RegID='" + departmentsPo.getBdpregid() + "'");
			}
			if (!"".equals(Utility.getName(departmentsPo.getBdpregname()))) {
				if ("yes".equals(Utility.getName(departmentsPo.getBdpregname()))) {
					buffer.append(" and B_Departments.B_DP_RegID is not null");
				} else if ("no".equals(Utility.getName(departmentsPo.getBdpregname()))) {
					buffer.append(" and B_Departments.B_DP_RegID is null");
				}
			}
			if (!"".equals(Utility.getName(departmentsPo.getBdpcompanysid()))) {
				buffer.append(" AND B_DP_CompanysID = '" + Utility.getName(departmentsPo.getBdpcompanysid()) + "'");
			}	
			
			buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
			return this.queryForObjectList(buffer.toString(), null,DepartmentsPo.class);
		}

	public List<DepartmentsPo> getQuyuList(DepartmentsPo po) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer
				.append("select B_DP_DepartmentID as bdpdepartmentid");
		buffer
				.append("       ,B_DP_DepartmentName as bdpdepartmentname");
		buffer.append("       ,B_DP_Type as bdptype");
		buffer.append("   from B_Departments");
		buffer.append("   where B_DP_Type='2' ");	
		
		if (!"".equals(Utility.getName(po.getBdpcompanysid()))) {
			buffer.append("AND B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBdpcompanysid()));
		}

		return queryForObjectList(buffer.toString(),params.toArray(), DepartmentsPo.class);
	}

	public void updateDepartment(DepartmentsPo departmentsPo) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE B_Departments ");
		buffer.append("SET B_DP_RegID = ? ");
		buffer.append("WHERE B_DP_DepartmentID = ?");

		List<String> params = new ArrayList<String>();

		params.add(departmentsPo.getBdpregid());
		params.add(departmentsPo.getBdpdepartmentid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}
