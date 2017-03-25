package com.pengsheng.eims.personnel.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.personnel.dao.PostDao;
import com.pengsheng.eims.personnel.persistence.PostPo;


import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class PostDaoImpl extends BaseJdbcDaoSupport implements PostDao{

	public List<PostPo> getPostMaxList() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT M_PT_ID as mptid ");
		buffer.append(",M_PT_content  as mptcontent ");
		buffer.append(",M_PT_deptId  as mptdeptid ");
		buffer.append(",(select count(b.M_PT_ID) from  M_Post b where b.M_PT_deptId = '2'  and b.M_PT_parented=a.M_PT_ID) as minCount ");
		buffer.append("FROM M_Post a ");		
		buffer.append("WHERE M_PT_deptId = '1'");

		return queryForObjectList(buffer.toString(), null, PostPo.class);
	}
	public List<PostPo> getPostList(PostPo po,int start, int size) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append("select ROW_NUMBER() Over(order by M_PT_ID) as rowNum, M_PT_ID as mptid ");
		buffer.append(",M_PT_content  as mptcontent ");
		buffer.append(",M_PT_deptId  as mptdeptid ");
		buffer.append(",(select count(b.M_PT_ID) from  M_Post b where b.M_PT_deptId = '2'  and b.M_PT_parented=a.M_PT_ID) as  minCount ");
		buffer.append("FROM M_Post a ");		
		buffer.append("WHERE M_PT_deptId = '1'");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return queryForObjectList(buffer.toString(), null, PostPo.class);
	}
	public int getPostCount(PostPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(M_PT_ID)");
		buffer.append("   FROM M_Post a  WHERE M_PT_deptId = '1'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	public List<PostPo> getPostMinList(
			PostPo postPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT M_PT_ID as mptid ");
		buffer.append(",M_PT_content  as mptcontent ");
		buffer.append(",M_PT_deptId  as mptdeptid ");
		buffer.append(",M_PT_parented  as mptparented ");
		buffer.append(",M_PT_Salary  as mptsalary ");		
		buffer.append("FROM M_Post ");
		buffer.append("WHERE  M_PT_deptId ='2' AND M_PT_parented = ?");

		List<String> params = new ArrayList<String>();
		params.add(postPo.getMptparented());
		
		return queryForObjectList(buffer.toString(), params.toArray(), PostPo.class);
	}

	public PostPo getPost(
			PostPo postPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  M_PT_ID as mptid ");
		buffer.append(",M_PT_content  as mptcontent ");
		buffer.append(",M_PT_deptId  as mptdeptid ");
		buffer.append(",M_PT_parented  as mptparented ");
		buffer.append(",M_PT_Salary  as mptsalary ");		
		buffer.append("FROM M_Post ");
		buffer.append("WHERE M_PT_ID = ?");

		List<String> params = new ArrayList<String>();
		params.add(postPo.getMptid());
		
		return (PostPo) queryForObject(buffer.toString(), params
				.toArray(), PostPo.class);
	}
	
	public void insertPost(
			PostPo postPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO M_Post ");
		buffer.append("(M_PT_ID");
		buffer.append(",M_PT_content");
		buffer.append(",M_PT_parented");
		buffer.append(",M_PT_deptId");
		buffer.append(",M_PT_Salary)");		
		buffer.append("VALUES (?, ?, ?, ?, ?)");

		List<String> params = new ArrayList<String>();
		params.add(postPo.getMptid());
		params.add(postPo.getMptcontent());
		params.add(Utility.getName(postPo.getMptparented()));
		params.add(postPo.getMptdeptid());
		params.add(postPo.getMptsalary());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void updatePost(
			PostPo postPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE M_Post ");
		buffer.append("SET M_PT_content = ? ");
		buffer.append(",M_PT_Salary = ? ");		
		buffer.append("WHERE M_PT_ID = ?");

		List<String> params = new ArrayList<String>();

		params.add(postPo.getMptcontent());
		params.add(postPo.getMptsalary());		
		params.add(postPo.getMptid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void deletePost(PostPo postPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM M_Post ");
		buffer.append("WHERE M_PT_ID = ?");

		List<String> params = new ArrayList<String>();
		params.add(postPo.getMptid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	
	public int getPostName(PostPo postPo) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count( M_PT_ID )");
		if(postPo.getMptdeptid().equals("1"))
		{
			buffer.append("   from M_Post where M_PT_deptId=1 and M_PT_content = ? ");
			params.add(Utility.getName(postPo.getMptcontent()));
		}else
		{
			buffer.append("   from M_Post where M_PT_deptId=2 and M_PT_parented=? and M_PT_content = ? ");

			params.add(Utility.getName(postPo.getMptparented()));
			params.add(Utility.getName(postPo.getMptcontent()));
		}
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public int getPostNameUpdate(PostPo postPo) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count( M_PT_ID )");
		if(postPo.getMptdeptid().equals("1"))
		{
			buffer.append("   from M_Post where M_PT_deptId=1 and M_PT_content = ? and M_PT_ID <> ? ");
			params.add(Utility.getName(postPo.getMptcontent()));
			params.add(Utility.getName(postPo.getMptid()));
		}else
		{
			buffer.append("   from M_Post where M_PT_deptId=2 and M_PT_parented=? and M_PT_content = ? and M_PT_ID <> ? ");
			params.add(Utility.getName(postPo.getMptparented()));
			params.add(Utility.getName(postPo.getMptcontent()));
			params.add(Utility.getName(postPo.getMptid()));
		}
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public int getBeUsed(PostPo postPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT count(ID) FROM SYS_PersonInfo ");
		buffer.append("WHERE postID = ? or titleOfTechnicalPost=?");

		List<String> params = new ArrayList<String>();
		params.add(postPo.getMptid());
		params.add(postPo.getMptid());
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}	
}
