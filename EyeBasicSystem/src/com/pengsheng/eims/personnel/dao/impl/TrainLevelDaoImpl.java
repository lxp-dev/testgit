package com.pengsheng.eims.personnel.dao.impl;

import java.util.List;

import com.pengsheng.eims.personnel.dao.TrainLevelDao;
import com.pengsheng.eims.personnel.persistence.PostPo;
import com.pengsheng.eims.personnel.persistence.TrainLevelPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class TrainLevelDaoImpl extends BaseJdbcDaoSupport implements TrainLevelDao 
{

	public int selectTrainLevelCount(TrainLevelPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( m_tl_uuid ) ");
		buffer.append("   from m_trainlevel");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	public void deleteTrainLevelPo(TrainLevelPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" delete from m_trainlevel where m_tl_uuid = '"+Utility.getName(po.getMtluuid())+"'");
		getJdbcTemplate().update(buffer.toString());
	}

	
	public void insertTrainLevelPo(TrainLevelPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into m_trainlevel ");
		buffer.append("(");
		buffer.append("m_tl_uuid ");
		buffer.append(",m_tl_levelnumber  ");
		buffer.append(",m_tl_levelname) ");
		buffer.append("values (");
		buffer.append("'" + this.uuid.generate() + "',");
		buffer.append("'" + po.getMtllevelNumber()+ "',");
		buffer.append("'" + po.getMtllevelName() + "'");
		buffer.append(")");

		getJdbcTemplate().update(buffer.toString());
	}
	
	public List<TrainLevelPo> selectTrainLevelList(TrainLevelPo po, int start, int size) {				
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by  m_tl_uuid) as rowNum, m_tl_uuid as mtluuid, m_tl_levelnumber as mtllevelNumber, m_tl_levelname as mtllevelName from m_trainlevel");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,
				TrainLevelPo.class);
	}

	
	public TrainLevelPo selectTrainLevelPo(TrainLevelPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" m_tl_uuid as mtluuid, ");
		buffer.append(" m_tl_levelnumber as mtllevelNumber, ");
		buffer.append(" m_tl_levelname as mtllevelName ");
		buffer.append(" FROM m_trainlevel ");
		buffer.append(" WHERE ");
		buffer.append("m_tl_uuid = '" + po.getMtluuid() + "'");
		return (TrainLevelPo)queryForObject(buffer.toString(), null, TrainLevelPo.class);
	}
	
	public int getTrainLevelPoId(TrainLevelPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( m_tl_uuid )");
		buffer.append("   from m_trainlevel where m_tl_levelnumber = '"+Utility.getName(po.getMtllevelNumber())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	public int getTrainLevelPoName(TrainLevelPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( m_tl_uuid )");
		buffer.append("   from m_trainlevel where m_tl_levelname = '"+Utility.getName(po.getMtllevelName())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	public int getTrainLevelPoIdUpdate(TrainLevelPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( m_tl_uuid )");
		buffer.append("   from m_trainlevel where m_tl_levelnumber = '"+Utility.getName(po.getMtllevelNumber())+"' and m_tl_uuid <> '"+Utility.getName(po.getMtluuid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	public int getTrainLevelPoNameUpdate(TrainLevelPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( m_tl_uuid )");
		buffer.append("   from m_trainlevel where m_tl_levelname = '"+Utility.getName(po.getMtllevelName())+"' and m_tl_uuid <> '"+Utility.getName(po.getMtluuid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	public void updateTrainLevelPo(TrainLevelPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" UPDATE m_trainlevel");
		buffer.append("  SET  m_tl_levelnumber = '"+Utility.getName(po.getMtllevelNumber())+"' , ");
		buffer.append(" m_tl_levelname = '"+Utility.getName(po.getMtllevelName())+"'");
		buffer.append("  WHERE m_tl_uuid = '"+Utility.getName(po.getMtluuid())+"'");
		
		getJdbcTemplate().update(buffer.toString());
	}
}
