package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.MemberOriginDao;
import com.pengsheng.eims.basic.persistence.MemberOriginPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class MemberOriginDaoImpl extends BaseJdbcDaoSupport implements MemberOriginDao{

	public void deleteMemberOriginPo(MemberOriginPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("DELETE FROM dbo.B_MemberOrigin ");
		buffer.append("WHERE  B_MO_ID = ? ");
		
		params.add(po.getBmoid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void insertMemberOriginPo(MemberOriginPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO dbo.B_MemberOrigin ");
		buffer.append("            (B_MO_ID, ");
		buffer.append("             B_MO_Name) ");
		buffer.append("VALUES     ( ?, ");
		buffer.append("             ? ) ");
		
		params.add(po.getBmoid());
		params.add(po.getBmoname());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public List<MemberOriginPo> selectMemberOriginList() {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT B_MO_ID   AS bmoid, ");
		buffer.append("       B_MO_Name AS bmoname ");
		buffer.append("FROM   dbo.B_MemberOrigin ");
		
		return queryForObjectList(buffer.toString(), null, MemberOriginPo.class);
	}
	public int getMemberOriginsCount() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(B_MO_ID)");
		buffer.append("   from dbo.B_MemberOrigin");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}


	public List<MemberOriginPo> getMemberOriginsList(int start, int size) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by B_MO_ID) as rowNum, B_MO_ID   AS bmoid,B_MO_Name AS bmoname FROM   dbo.B_MemberOrigin ");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,
				MemberOriginPo.class);
	}
	
	public MemberOriginPo selectMemberOriginPo(MemberOriginPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT B_MO_ID   AS bmoid, ");
		buffer.append("       B_MO_Name AS bmoname ");
		buffer.append("FROM   dbo.B_MemberOrigin ");
		buffer.append("WHERE  B_MO_ID = ? ");
		
		params.add(po.getBmoid());
		
		return (MemberOriginPo) queryForObject(buffer.toString(), params.toArray(), MemberOriginPo.class);
	}

	public void updateMemberOriginPo(MemberOriginPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("UPDATE dbo.B_MemberOrigin ");
		buffer.append("SET    B_MO_Name = ? ");
		buffer.append("WHERE  B_MO_ID = ? ");
		
		params.add(po.getBmoname());
		params.add(po.getBmoid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public int selectMemberOriginCount(MemberOriginPo po)
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT count(*) ");
		buffer.append("FROM   dbo.B_MemberOrigin ");
		buffer.append("WHERE  B_MO_ID = ? ");
		
		params.add(po.getBmoid());
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	public int selectMemberOriginName(MemberOriginPo po)
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBmoname()));
		buffer.append(" select count( B_MO_ID )");
		buffer.append("   from dbo.B_MemberOrigin where B_MO_Name = ? ");
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	public int selectMemberOriginNameUpdate(MemberOriginPo po)
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBmoname()));
		params.add(Utility.getName(po.getBmoid()));
		buffer.append(" select count( B_MO_ID )");
		buffer.append("   from dbo.B_MemberOrigin where B_MO_Name = ? and B_MO_ID <> ? ");
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

}
