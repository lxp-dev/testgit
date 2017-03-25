package com.pengsheng.eims.personnel.dao.impl;

import java.util.List;

import com.pengsheng.eims.personnel.dao.TrainContentDao;
import com.pengsheng.eims.personnel.persistence.TrainContentPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class TrainContentDaoImpl extends BaseJdbcDaoSupport implements TrainContentDao
{
	public int selectTrainContentCount(TrainContentPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( m_tc_uuid ) ");
		buffer.append("   from m_trainContent");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	public void deleteTrainContentPo(TrainContentPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" delete from m_trainContent where m_tc_uuid = '"+Utility.getName(po.getMtcuuid())+"'");
		getJdbcTemplate().update(buffer.toString());
	}

	
	public void insertTrainContentPo(TrainContentPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into m_trainContent ");
		buffer.append("(");
		buffer.append("m_tc_uuid ");
		buffer.append(",m_tc_Contentnumber  ");
		buffer.append(",m_tc_Contentname) ");
		buffer.append("values (");
		buffer.append("'" + this.uuid.generate() + "',");
		buffer.append("'" + po.getMtccontentNumber()+ "',");
		buffer.append("'" + po.getMtccontentName() + "'");
		buffer.append(")");

		getJdbcTemplate().update(buffer.toString());
	}
	
	public List<TrainContentPo> selectTrainContentList(TrainContentPo po, int start, int size) {				
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by  m_tc_uuid) as rowNum, m_tc_uuid as mtcuuid, m_tc_Contentnumber as mtccontentNumber, m_tc_Contentname as mtccontentName from m_trainContent");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,
				TrainContentPo.class);
	}

	
	public TrainContentPo selectTrainContentPo(TrainContentPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" m_tc_uuid as mtcuuid, ");
		buffer.append(" m_tc_Contentnumber as mtccontentNumber, ");
		buffer.append(" m_tc_Contentname as mtccontentName ");
		buffer.append(" FROM m_trainContent ");
		buffer.append(" WHERE ");
		buffer.append("m_tc_uuid = '" + po.getMtcuuid() + "'");
		return (TrainContentPo)queryForObject(buffer.toString(), null, TrainContentPo.class);
	}
	
	public int getTrainContentPoId(TrainContentPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( m_tc_uuid )");
		buffer.append("   from m_trainContent where m_tc_Contentnumber = '"+Utility.getName(po.getMtccontentNumber())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	public int getTrainContentPoName(TrainContentPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( m_tc_uuid )");
		buffer.append("   from m_trainContent where m_tc_Contentname = '"+Utility.getName(po.getMtccontentName())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	public int getTrainContentPoIdUpdate(TrainContentPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( m_tc_uuid )");
		buffer.append("   from m_trainContent where m_tc_Contentnumber = '"+Utility.getName(po.getMtccontentNumber())+"' and m_tc_uuid <> '"+Utility.getName(po.getMtcuuid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	public int getTrainContentPoNameUpdate(TrainContentPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( m_tc_uuid )");
		buffer.append("   from m_trainContent where m_tc_Contentname = '"+Utility.getName(po.getMtccontentName())+"' and m_tc_uuid <> '"+Utility.getName(po.getMtcuuid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	public void updateTrainContentPo(TrainContentPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" UPDATE m_trainContent");
		buffer.append("  SET  m_tc_Contentnumber = '"+Utility.getName(po.getMtccontentNumber())+"' , ");
		buffer.append(" m_tc_Contentname = '"+Utility.getName(po.getMtccontentName())+"'");
		buffer.append("  WHERE m_tc_uuid = '"+Utility.getName(po.getMtcuuid())+"'");
		
		getJdbcTemplate().update(buffer.toString());
	}
}
