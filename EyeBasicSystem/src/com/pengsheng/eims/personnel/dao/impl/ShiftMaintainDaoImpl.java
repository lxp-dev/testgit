package com.pengsheng.eims.personnel.dao.impl;

import java.util.List;

import com.pengsheng.eims.personnel.dao.ShiftMaintainDao;
import com.pengsheng.eims.personnel.persistence.ShiftMaintainPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ShiftMaintainDaoImpl extends BaseJdbcDaoSupport implements ShiftMaintainDao
{
	public int selectShiftMaintainCount(ShiftMaintainPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( m_sm_uuid) ");
		buffer.append("   from m_ShiftMaintain");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	public void deleteShiftMaintainPo(ShiftMaintainPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" delete from m_ShiftMaintain where m_sm_uuid = '"+Utility.getName(po.getMsmuuid())+"'");
		getJdbcTemplate().update(buffer.toString());
	}

	
	public void insertShiftMaintainPo(ShiftMaintainPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into m_ShiftMaintain ");
		buffer.append("(");
		buffer.append("m_sm_uuid ");
		buffer.append(",m_sm_shiftnumber  ");
		buffer.append(",m_sm_shiftname ");
		buffer.append(",m_sm_worklong ");
		buffer.append(",m_sm_workbegin ");
		buffer.append(",m_sm_workend) ");
		buffer.append("values (");
		buffer.append("'" + this.uuid.generate() + "',");
		buffer.append("'" + po.getMsmshiftNumber()+ "',");
		buffer.append("'" + po.getMsmshiftName()+ "',");
		buffer.append("'" + po.getMsmworkLong()+ "',");
		buffer.append("'" + po.getMsmworkBegin()+ "',");
		buffer.append("'" + po.getMsmworkEnd() + "'");
		buffer.append(")");

		getJdbcTemplate().update(buffer.toString());
	}
	
	public List<ShiftMaintainPo> selectShiftMaintainList(ShiftMaintainPo po, int start, int size) {				
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by  m_sm_uuid) as rowNum, m_sm_uuid as msmuuid, m_sm_shiftnumber as msmshiftNumber, m_sm_shiftname as msmshiftName,m_sm_worklong as msmworkLong,m_sm_workbegin as msmworkBegin,m_sm_workend as msmworkEnd from m_ShiftMaintain");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,
				ShiftMaintainPo.class);
	}

	
	public ShiftMaintainPo selectShiftMaintainPo(ShiftMaintainPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" m_sm_uuid as msmuuid, ");
		buffer.append(" m_sm_shiftnumber as msmshiftNumber, ");
		buffer.append(" m_sm_shiftname as msmshiftName, ");
		buffer.append(" m_sm_worklong as msmworkLong, ");
		buffer.append(" m_sm_workbegin as msmworkBegin, ");
		buffer.append(" m_sm_workend as msmworkEnd ");
		buffer.append(" FROM m_ShiftMaintain ");
		buffer.append(" WHERE ");
		buffer.append("m_sm_uuid = '" + po.getMsmuuid() + "'");
		return (ShiftMaintainPo)queryForObject(buffer.toString(), null, ShiftMaintainPo.class);
	}
	
	public int getShiftMaintainPoId(ShiftMaintainPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( m_sm_uuid )");
		buffer.append("   from m_ShiftMaintain where m_sm_shiftnumber = '"+Utility.getName(po.getMsmshiftNumber())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	public int getShiftMaintainPoName(ShiftMaintainPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( m_sm_uuid )");
		buffer.append("   from m_ShiftMaintain where m_sm_shiftname = '"+Utility.getName(po.getMsmshiftName())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	public int getShiftMaintainPoIdUpdate(ShiftMaintainPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( m_sm_uuid )");
		buffer.append("   from m_ShiftMaintain where m_sm_shiftnumber = '"+Utility.getName(po.getMsmshiftNumber())+"' and m_sm_uuid <> '"+Utility.getName(po.getMsmuuid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	public int getShiftMaintainPoNameUpdate(ShiftMaintainPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( m_sm_uuid )");
		buffer.append("   from m_ShiftMaintain where m_sm_shiftname = '"+Utility.getName(po.getMsmshiftName())+"' and m_sm_uuid <> '"+Utility.getName(po.getMsmuuid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	public void updateShiftMaintainPo(ShiftMaintainPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" UPDATE m_ShiftMaintain");
		buffer.append("  SET  m_sm_shiftnumber = '"+Utility.getName(po.getMsmshiftNumber())+"' , ");
		buffer.append("  m_sm_shiftname = '"+Utility.getName(po.getMsmshiftName())+"' , ");
		buffer.append("  m_sm_worklong = '"+Utility.getName(po.getMsmworkLong())+"' , ");
		buffer.append("  m_sm_workbegin = '"+Utility.getName(po.getMsmworkBegin())+"' , ");
		buffer.append(" m_sm_workend = '"+Utility.getName(po.getMsmworkEnd())+"'");
		buffer.append("  WHERE m_sm_uuid = '"+Utility.getName(po.getMsmuuid())+"'");
		
		getJdbcTemplate().update(buffer.toString());
	}
}
