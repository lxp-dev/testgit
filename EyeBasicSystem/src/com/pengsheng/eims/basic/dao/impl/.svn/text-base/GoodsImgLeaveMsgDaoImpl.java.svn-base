package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.GoodsImgLeaveMsgDao;
import com.pengsheng.eims.basic.persistence.GoodsImgLeaveMsgPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class GoodsImgLeaveMsgDaoImpl extends BaseJdbcDaoSupport implements GoodsImgLeaveMsgDao {

	public int getGoodsImgLeaveMsgCount(GoodsImgLeaveMsgPo gpo){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(distinct C_MR_LM_ID)   ");
		sb.append("FROM   C_MR_MaterialRecycle left join C_MR_MaterialRecycleLeaveMsg on C_MR_LM_ID = C_MR_LME_MRID ");
		sb.append("       left join SYS_PersonInfo on C_MR_LM_PersonID = ID left join B_Departments on C_MR_LM_DepartmentID = B_DP_DepartmentID ");
		sb.append(" where 1=1 ");
		
		if(null != gpo){
			if(!"".equals(Utility.getName(gpo.getCmrlmstartdate()))){
				sb.append(" and convert(varchar(10),C_MR_LM_Date,23) >= ?");
				params.add(Utility.getName(gpo.getCmrlmstartdate()));
			}
			if(!"".equals(Utility.getName(gpo.getCmrlmenddate()))){
				sb.append(" and convert(varchar(10),C_MR_LM_Date,23) <= ?");
				params.add(Utility.getName(gpo.getCmrlmenddate()));
			}
			if(!"".equals(Utility.getName(gpo.getCmrlmestartdate()))){
				sb.append(" and convert(varchar(10),C_MR_LME_Date,23) >= ?");
				params.add(Utility.getName(gpo.getCmrlmestartdate()));
			}
			if(!"".equals(Utility.getName(gpo.getCmrlmeenddate()))){
				sb.append(" and convert(varchar(10),C_MR_LME_Date,23) <= ?");
				params.add(Utility.getName(gpo.getCmrlmeenddate()));
			}
			
			if(!"".equals(Utility.getName(gpo.getCmrlmGoodsName()))){
				sb.append(" and C_MR_LM_GoodsName like '%' + ? +'%'");
				params.add(Utility.getName(gpo.getCmrlmGoodsName()));
			}
			if(!"".equals(Utility.getName(gpo.getCmrlmGoodsContent()))){
				sb.append(" and C_MR_LM_GoodsContent like '%' + ? +'%'");
				params.add(Utility.getName(gpo.getCmrlmGoodsContent()));
			}
			
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	public List<GoodsImgLeaveMsgPo> getGoodsImgLeaveMsgList(GoodsImgLeaveMsgPo gpo,int start,int size){
		
		StringBuffer  sb = new StringBuffer();
		int countPage = start + size;
		List<String> params = new ArrayList<String>();
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from (select ROW_NUMBER() ");
		sb.append("Over(order by cmrlmdate desc) as 'rowNum', ");
		sb.append("       cmrlmid               AS cmrlmid, ");
		sb.append("       cmrlmpersonname     AS cmrlmpersonname, ");
		sb.append("       cmrlmdate            AS cmrlmdate, ");
		sb.append("       cmrlmGoodsName AS cmrlmGoodsName,cmrlmcontentflag as cmrlmcontentflag from ( ");		
		
		sb.append("SELECT distinct C_MR_LM_ID as cmrlmid");
		sb.append("      ,personname as cmrlmpersonname ");
		sb.append("      ,convert(varchar(16),C_MR_LM_Date,120) as cmrlmdate");
		sb.append("      ,C_MR_LM_GoodsName as cmrlmGoodsName ");
		sb.append("      ,(select count(C_MR_LME_ID) from C_MR_MaterialRecycleLeaveMsg where C_MR_LME_MRID = C_MR_LM_ID and isnull(C_MR_LME_ReadedFlag,'0') = '0') as cmrlmcontentflag ");		
		sb.append("FROM   C_MR_MaterialRecycle left join C_MR_MaterialRecycleLeaveMsg on C_MR_LM_ID = C_MR_LME_MRID ");
		sb.append("       left join SYS_PersonInfo on C_MR_LM_PersonID = ID left join B_Departments on C_MR_LM_DepartmentID = B_DP_DepartmentID ");
		sb.append(" where 1=1 ");
		
		if(null != gpo){
			if(!"".equals(Utility.getName(gpo.getCmrlmstartdate()))){
				sb.append(" and convert(varchar(10),C_MR_LM_Date,23) >= ?");
				params.add(Utility.getName(gpo.getCmrlmstartdate()));
			}
			if(!"".equals(Utility.getName(gpo.getCmrlmenddate()))){
				sb.append(" and convert(varchar(10),C_MR_LM_Date,23) <= ?");
				params.add(Utility.getName(gpo.getCmrlmenddate()));
			}
			if(!"".equals(Utility.getName(gpo.getCmrlmestartdate()))){
				sb.append(" and convert(varchar(10),C_MR_LME_Date,23) >= ?");
				params.add(Utility.getName(gpo.getCmrlmestartdate()));
			}
			if(!"".equals(Utility.getName(gpo.getCmrlmeenddate()))){
				sb.append(" and convert(varchar(10),C_MR_LME_Date,23) <= ?");
				params.add(Utility.getName(gpo.getCmrlmeenddate()));
			}
			
			if(!"".equals(Utility.getName(gpo.getCmrlmGoodsName()))){
				sb.append(" and C_MR_LM_GoodsName like '%' + ? +'%'");
				params.add(Utility.getName(gpo.getCmrlmGoodsName()));
			}
			if(!"".equals(Utility.getName(gpo.getCmrlmGoodsContent()))){
				sb.append(" and C_MR_LM_GoodsContent like '%' + ? +'%'");
				params.add(Utility.getName(gpo.getCmrlmGoodsContent()));
			}
			
		}
		sb.append(") table1 ) table1 where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append("set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(),GoodsImgLeaveMsgPo.class );
	}
	
	public GoodsImgLeaveMsgPo getGoodsImgLeaveMsgDetail(GoodsImgLeaveMsgPo gpo){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT top 1 C_MR_LM_ID as cmrlmid");
		sb.append("      ,C_MR_LM_PersonID as cmrlmpersonid ");
		sb.append("      ,personname as cmrlmpersonname ");
		sb.append("      ,convert(varchar(16),C_MR_LM_Date,120) as cmrlmdate");
		sb.append("      ,C_MR_LM_GoodsName as cmrlmGoodsName ");
		sb.append("      ,C_MR_LM_GoodsContent as cmrlmGoodsContent ");
		sb.append("      ,C_MR_LM_PicName as cmrlmPicName ");
		sb.append("      ,replace(C_MR_LM_PicUrl,'\\','/') as cmrlmPicUrl ");
		sb.append("      ,C_MR_LM_PicType as cmrlmPicType ");
		sb.append("      ,C_MR_LM_DepartmentID as cmrlmdepartmentid ");
		sb.append("      ,B_DP_DepartmentName as cmrlmdepartmentname ");
		sb.append("  FROM C_MR_MaterialRecycle left join SYS_PersonInfo on C_MR_LM_PersonID = ID left join B_Departments on C_MR_LM_DepartmentID = B_DP_DepartmentID ");
		sb.append("  where C_MR_LM_ID = ? order by convert(varchar(16),C_MR_LM_Date,120) desc ");
		
		params.add(Utility.getName(gpo.getCmrlmid()));
		
		return (GoodsImgLeaveMsgPo)queryForObject(sb.toString(), params.toArray(), GoodsImgLeaveMsgPo.class);
	}
	
	public List<GoodsImgLeaveMsgPo> getGoodsImgLeaveMsgListDetail(GoodsImgLeaveMsgPo gpo){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("SELECT C_MR_LME_ID as cmrlmeid");
		sb.append("      ,C_MR_LME_MRID as cmrlmemrid");
		sb.append("      ,convert(varchar(16),C_MR_LME_Date,120) as cmrlmedate");
		sb.append("      ,C_MR_LME_DepartmentID as cmrlmedepartmentid ");
		sb.append("      ,B_DP_DepartmentName as cmrlmedepartmentname");
		sb.append("      ,C_MR_LME_PersonID as cmrlmepersonid ");
		sb.append("      ,personname as cmrlmepersonname ");
		sb.append("      ,C_MR_LME_Content as cmrlmecontent ");
		sb.append("  FROM C_MR_MaterialRecycleLeaveMsg left join SYS_PersonInfo on C_MR_LME_PersonID = ID left join B_Departments on C_MR_LME_DepartmentID = B_DP_DepartmentID ");
		sb.append("  where C_MR_LME_MRID = ? ");
		
		params.add(Utility.getName(gpo.getCmrlmid()));
		
		if (!"".equals(Utility.getName(gpo.getCmrlmestartdate()))){
			sb.append("  and convert(varchar(10),C_MR_LME_Date,120) >= ?  ");
			params.add(Utility.getName(gpo.getCmrlmestartdate()));
		}
		
		if (!"".equals(Utility.getName(gpo.getCmrlmeenddate()))){
			sb.append("  and convert(varchar(10),C_MR_LME_Date,120) <= ?  ");
			params.add(Utility.getName(gpo.getCmrlmeenddate()));
		}
		
		sb.append("  order by convert(varchar(16),C_MR_LME_Date,120) desc ");		
		
		return queryForObjectList(sb.toString(), params.toArray(),GoodsImgLeaveMsgPo.class );
	}
	
	public void insertGoodsImgLeaveMsg(GoodsImgLeaveMsgPo gpo){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("INSERT INTO C_MR_MaterialRecycle ");
		sb.append("            (C_MR_LM_ID, ");
		sb.append("             C_MR_LM_PersonID, ");
		sb.append("             C_MR_LM_Date, ");
		sb.append("             C_MR_LM_GoodsName, ");
		sb.append("             C_MR_LM_GoodsContent, ");
		sb.append("             C_MR_LM_PicName, ");
		sb.append("             C_MR_LM_PicUrl,C_MR_LM_PicType,C_MR_LM_DepartmentID) ");
		sb.append("VALUES      (?, ");
		sb.append("             ?, ");
		sb.append("             getdate(), ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?,?,? ) ");

		params.add(Utility.getName(gpo.getCmrlmid()));
		params.add(Utility.getName(gpo.getCmrlmpersonid()));
		params.add(Utility.getName(gpo.getCmrlmGoodsName()));
		params.add(Utility.getName(gpo.getCmrlmGoodsContent()));
		params.add(Utility.getName(gpo.getCmrlmPicName()));
		params.add(Utility.getName(gpo.getCmrlmPicUrl()));
		params.add(Utility.getName(gpo.getCmrlmPicType()));
		params.add(Utility.getName(gpo.getCmrlmdepartmentid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public void updateGoodsImgLeaveMsg(GoodsImgLeaveMsgPo gpo){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update C_MR_MaterialRecycle set C_MR_LM_GoodsName = ? , C_MR_LM_GoodsContent = ? where C_MR_LM_ID = ? ");
		
		params.add(Utility.getName(gpo.getCmrlmGoodsName()));
		params.add(Utility.getName(gpo.getCmrlmGoodsContent()));
		params.add(Utility.getName(gpo.getCmrlmid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public void deleteGoodsImgLeaveMsg(GoodsImgLeaveMsgPo gpo){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from C_MR_MaterialRecycle where C_MR_LM_ID = ? ");
		
		params.add(Utility.getName(gpo.getCmrlmid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public void deleteGoodsImgLeaveMsgWord(GoodsImgLeaveMsgPo gpo){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from C_MR_MaterialRecycleLeaveMsg where C_MR_LME_MRID = ? ");
		
		params.add(Utility.getName(gpo.getCmrlmid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public void insertGoodsImgLeaveMsgWord(GoodsImgLeaveMsgPo gpo){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("INSERT INTO C_MR_MaterialRecycleLeaveMsg ");
		sb.append("            (C_MR_LME_ID, ");
		sb.append("             C_MR_LME_MRID, ");
		sb.append("             C_MR_LME_Date, ");
		sb.append("             C_MR_LME_DepartmentID, ");
		sb.append("             C_MR_LME_PersonID, ");
		sb.append("             C_MR_LME_Content, ");
		sb.append("             C_MR_LME_ReadedFlag) ");
		sb.append("VALUES      (?, ");
		sb.append("             ?, ");
		sb.append("             getdate(), ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             '0' ) ");

		params.add(Utility.getName(gpo.getCmrlmeid()));
		params.add(Utility.getName(gpo.getCmrlmemrid()));
		params.add(Utility.getName(gpo.getCmrlmedepartmentid()));
		params.add(Utility.getName(gpo.getCmrlmepersonid()));
		params.add(Utility.getName(gpo.getCmrlmecontent()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public void updateGoodsImgLeaveMsgReadedFlag(GoodsImgLeaveMsgPo gpo){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("update C_MR_MaterialRecycleLeaveMsg set C_MR_LME_ReadedFlag = '1' ");
		sb.append("  where C_MR_LME_MRID = ? ");
		
		params.add(Utility.getName(gpo.getCmrlmid()));
		
		if (!"".equals(Utility.getName(gpo.getCmrlmestartdate()))){
			sb.append("  and convert(varchar(10),C_MR_LME_Date,120) >= ?  ");
			params.add(Utility.getName(gpo.getCmrlmestartdate()));
		}
		
		if (!"".equals(Utility.getName(gpo.getCmrlmeenddate()))){
			sb.append("  and convert(varchar(10),C_MR_LME_Date,120) <= ?  ");
			params.add(Utility.getName(gpo.getCmrlmeenddate()));
		}
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
}
