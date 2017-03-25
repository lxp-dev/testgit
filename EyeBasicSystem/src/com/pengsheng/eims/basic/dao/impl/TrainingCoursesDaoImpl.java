package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.TrainingCoursesDao;
import com.pengsheng.eims.basic.persistence.TrainingCoursesPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class TrainingCoursesDaoImpl extends BaseJdbcDaoSupport implements TrainingCoursesDao {
	
	public void deleteTrainingCourses(TrainingCoursesPo po){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("delete from K_TrainingCourses where 1=1 ");
		if(!"".equals(Utility.getName(po.getKjbid()))){
			sb.append(" and K_JB_Id = ? ");
			params.add(po.getKjbid());
		}
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	public void deleteTrainingCoursesPR(TrainingCoursesPo po){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("delete from K_TrainingCoursesPR where 1=1 ");
		if(!"".equals(Utility.getName(po.getKjbid()))){
			sb.append(" and K_PR_ID = ? ");
			params.add(po.getKjbid());
		}
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	public void insertTrainingCourses(TrainingCoursesPo po){
		StringBuffer  sb = new StringBuffer();
		sb.append("INSERT INTO K_TrainingCourses ");
		sb.append("            (K_JB_Id, ");
		sb.append("             K_JB_CreasePerson, ");
		sb.append("             K_JB_SpeechPersonName, ");
		sb.append("             K_JB_CoursesName, ");
		sb.append("             K_JB_CoursesContent, ");
		sb.append("             K_JB_TVUrl, ");
		sb.append("             K_JB_CreaseDate,K_JB_DepartmentsId,K_JB_TVName,K_JB_ContentType) ");
		sb.append("VALUES      (?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             getdate(),?,?,? ) ");
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getKjbid()));
		params.add(Utility.getName(po.getKjbcreaseperson()));
		params.add(Utility.getName(po.getKjbspeechpersonname()));
		params.add(Utility.getName(po.getKjbcoursesname()));
		params.add(Utility.getName(po.getKjbcoursescontent()));
		params.add(Utility.getName(po.getKjbtvurl()));
		params.add(Utility.getName(po.getKjbdepartmentsid()));
		params.add(Utility.getName(po.getKjbtvname()));
		params.add(Utility.getName(po.getKjbcontenttype()));
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	public void updateTrainingCourses(TrainingCoursesPo po){
		StringBuffer  sb = new StringBuffer();
		sb.append("UPDATE K_TrainingCourses ");
		sb.append("SET    K_JB_SpeechPersonName = ?, ");
		sb.append("       K_JB_CoursesName = ?, ");
		sb.append("       K_JB_CoursesContent = ? ");
		sb.append("WHERE  K_JB_Id = ? ");
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getKjbspeechpersonname()));
		params.add(Utility.getName(po.getKjbcoursesname()));
		params.add(Utility.getName(po.getKjbcoursescontent()));
		params.add(Utility.getName(po.getKjbid()));
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	public List<TrainingCoursesPo> selectTrainingCoursesList(TrainingCoursesPo po,int start, int size){
		StringBuffer  sb = new StringBuffer();
		int countPage = start + size;
		List<String> params = new ArrayList<String>();
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from (select ROW_NUMBER() ");
		sb.append("Over(order by K_JB_CreaseDate) as 'rowNum', ");
		sb.append("       K_JB_Id               AS kjbid, ");
		sb.append("       K_JB_CreasePerson     AS kjbcreaseperson, ");
		sb.append("       personName            AS kjbcreasepersonname, ");
		sb.append("       K_JB_SpeechPersonName AS kjbspeechpersonname, ");
		sb.append("       K_JB_CoursesName      AS kjbcoursesname, ");
		sb.append("       K_JB_CoursesContent   AS kjbcoursescontent, ");
		sb.append("       K_JB_TVUrl            AS kjbtvurl, K_JB_TVName as kjbtvname, ");
		sb.append("       K_JB_CreaseDate       AS kjbcreasedate ");
		sb.append("FROM   K_TrainingCourses ");
		sb.append("       LEFT JOIN dbo.SYS_PersonInfo ");
		sb.append("         ON ID = K_JB_CreasePerson ");
		sb.append(" where 1=1 ");
		if(null != po){
			if(!"".equals(Utility.getName(po.getStratDate()))){
				sb.append(" and convert(varchar(10),K_JB_CreaseDate,23) >= ?");
				params.add(po.getStratDate());
			}
			if(!"".equals(Utility.getName(po.getEndDate()))){
				sb.append(" and convert(varchar(10),K_JB_CreaseDate,23) <= ?");
				params.add(po.getEndDate());
			}
			if(!"".equals(Utility.getName(po.getKjbspeechpersonname()))){
				sb.append(" and K_JB_SpeechPersonName like '%' + ? +'%'");
				params.add(po.getKjbspeechpersonname());
			}
			if(!"".equals(Utility.getName(po.getKjbcoursesname()))){
				sb.append(" and K_JB_CoursesName like '%' + ? +'%'");
				params.add(po.getKjbcoursesname());
			}
			if(!"".equals(Utility.getName(po.getKjbcoursescontent()))){
				sb.append(" and K_JB_CoursesContent like '%' + ? +'%'");
				params.add(po.getKjbcoursescontent());
			}
			if(!"".equals(Utility.getName(po.getKprpersonid()))&&!"".equals(Utility.getName(po.getKprroleid()))){
				sb.append(" and (select count(*) from dbo.K_TrainingCoursesPR where  K_PR_ID=K_JB_Id and (K_PR_RoleID =? or K_PR_PersonID = ?) ) <> 0 ");
				params.add(po.getKprroleid());
				params.add(po.getKprpersonid());
			}
			if("".equals(Utility.getName(po.getKprpersonid()))&&!"".equals(Utility.getName(po.getKprroleid()))){
				sb.append(" and (select count(*) from dbo.K_TrainingCoursesPR where  K_PR_ID=K_JB_Id and K_PR_RoleID =?  ) <> 0 ");
				params.add(po.getKprroleid());
			}
			if(!"".equals(Utility.getName(po.getKprpersonid()))&&"".equals(Utility.getName(po.getKprroleid()))){
				sb.append(" and (select count(*) from dbo.K_TrainingCoursesPR where  K_PR_ID=K_JB_Id and  K_PR_PersonID = ? ) <> 0 ");
				params.add(po.getKprpersonid());
			}
		}
		sb.append(") table1 where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append("set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(),TrainingCoursesPo.class );
	}
	public int getTrainingCoursesCount(TrainingCoursesPo po){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("       select count(K_JB_Id)   ");
		sb.append("FROM   K_TrainingCourses ");
		sb.append("       LEFT JOIN dbo.SYS_PersonInfo ");
		sb.append("         ON ID = K_JB_CreasePerson ");
		sb.append(" where 1=1 ");
		if(null != po){
			if(!"".equals(Utility.getName(po.getStratDate()))){
				sb.append(" and convert(varchar(10),K_JB_CreaseDate,23) >= ?");
				params.add(po.getStratDate());
			}
			if(!"".equals(Utility.getName(po.getEndDate()))){
				sb.append(" and convert(varchar(10),K_JB_CreaseDate,23) <= ?");
				params.add(po.getEndDate());
			}
			if(!"".equals(Utility.getName(po.getKjbspeechpersonname()))){
				sb.append(" and K_JB_SpeechPersonName like '%' + ? +'%'");
				params.add(po.getKjbspeechpersonname());
			}
			if(!"".equals(Utility.getName(po.getKjbcoursesname()))){
				sb.append(" and K_JB_CoursesName like '%' + ? +'%'");
				params.add(po.getKjbcoursesname());
			}
			if(!"".equals(Utility.getName(po.getKjbcoursescontent()))){
				sb.append(" and K_JB_CoursesContent like '%' + ? +'%'");
				params.add(po.getKjbcoursescontent());
			}
			if(!"".equals(Utility.getName(po.getKprpersonid()))&&!"".equals(Utility.getName(po.getKprroleid()))){
				sb.append(" and (select count(*) from dbo.K_TrainingCoursesPR where  K_PR_ID=K_JB_Id and (K_PR_RoleID =? or K_PR_PersonID = ?) ) <> 0 ");
				params.add(po.getKprroleid());
				params.add(po.getKprpersonid());
			}
			if("".equals(Utility.getName(po.getKprpersonid()))&&!"".equals(Utility.getName(po.getKprroleid()))){
				sb.append(" and (select count(*) from dbo.K_TrainingCoursesPR where  K_PR_ID=K_JB_Id and K_PR_RoleID =?  ) <> 0 ");
				params.add(po.getKprroleid());
			}
			if(!"".equals(Utility.getName(po.getKprpersonid()))&&"".equals(Utility.getName(po.getKprroleid()))){
				sb.append(" and (select count(*) from dbo.K_TrainingCoursesPR where  K_PR_ID=K_JB_Id and  K_PR_PersonID = ? ) <> 0 ");
				params.add(po.getKprpersonid());
			}
			
		}
		return getJdbcTemplate().queryForInt(sb.toString(),
				params.toArray());
	}
	public TrainingCoursesPo getTrainingCoursesPo(TrainingCoursesPo po){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT top 1   ");
		sb.append("       K_JB_Id               AS kjbid, ");
		sb.append("       K_JB_CoursesName      AS kjbcoursesname,K_JB_CoursesName as kjbcoursesname,K_JB_CoursesContent as kjbcoursescontent, ");
		sb.append("       K_JB_TVUrl            AS kjbtvurl, K_JB_TVName as kjbtvname,K_JB_ContentType as kjbcontenttype,K_JB_SpeechPersonName as kjbspeechpersonname ");
		sb.append("FROM   K_TrainingCourses ");
		sb.append("WHERE  K_JB_Id = ? ");
		params.add(po.getKjbid());
		return (TrainingCoursesPo)queryForObject(sb.toString(), params.toArray(), TrainingCoursesPo.class);
	}
	public int  Verification (String id,String roleid){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT COUNT(*) ");
		sb.append("FROM   K_TrainingCoursesPR ");
		sb.append("WHERE  K_PR_PersonID = ? ");
		sb.append("        OR K_PR_RoleID = ? ");
		params.add(id);
		params.add(Utility.getName(roleid));
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	public  List<TrainingCoursesPo> getTrainingCoursesPR(TrainingCoursesPo po){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT K_PR_ID as kprid, ");
		sb.append("       K_PR_PersonID as kprpersonid, ");
		sb.append("       K_PR_RoleID as kprroleid, ");
		sb.append("       roleName as kprrolename, ");
		sb.append("       personName as kprpersonname ");
		sb.append("FROM   K_TrainingCoursesPR ");
		sb.append("       LEFT JOIN dbo.SYS_PersonInfo ");
		sb.append("         ON K_PR_PersonID = ID ");
		sb.append("       LEFT JOIN dbo.SYS_Roles ");
		sb.append("         ON K_PR_RoleID = roleID ");
		sb.append("WHERE  1 = 1 ");
		sb.append("       AND K_PR_ID = ? ");
		params.add(po.getKprid());
		return queryForObjectList(sb.toString(), params.toArray(),TrainingCoursesPo.class );
	}
	public void insertTTrainingCoursePerson(TrainingCoursesPo po){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("INSERT INTO K_TrainingCoursesPR ");
		sb.append("            (K_PR_UUID, ");
		sb.append("             K_PR_ID, ");
		sb.append("             K_PR_PersonID, ");
		sb.append("             K_PR_RoleID,K_PR_Flag) ");
		sb.append("VALUES      (?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             NULL,1) ");
		params.add(this.uuid.generate());
		params.add(po.getKprid());
		params.add(po.getKprpersonid());
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	public void insertTTrainingCourseRole(TrainingCoursesPo po){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("INSERT INTO K_TrainingCoursesPR ");
		sb.append("            (K_PR_UUID, ");
		sb.append("             K_PR_ID, ");
		sb.append("             K_PR_PersonID, ");
		sb.append("             K_PR_RoleID,K_PR_Flag) ");
		sb.append("VALUES      (?, ");
		sb.append("             ?, ");
		sb.append("             NULL, ");
		sb.append("             ?,0) ");
		params.add(this.uuid.generate());
		params.add(po.getKprid());
		params.add(po.getKprroleid());
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public List<TrainingCoursesPo> selectPriceList(TrainingCoursesPo po,int start, int size){
		
		StringBuffer  sb = new StringBuffer();
		int countPage = start + size;
		List<String> params = new ArrayList<String>();
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from (select ROW_NUMBER() ");
		sb.append("Over(order by J_PL_CreateDate) as 'rowNum', ");
		sb.append("       J_PL_Id               AS kjbid, ");
		sb.append("       J_PL_CreatePerson     AS kjbcreaseperson, ");
		sb.append("       personName            AS kjbcreasepersonname, ");
		sb.append("       J_PL_Content   AS kjbcoursescontent, ");
		sb.append("       J_PL_TVUrl            AS kjbtvurl, J_PL_TVName as kjbtvname, ");
		sb.append("       J_PL_CreateDate       AS kjbcreasedate ");
		sb.append("FROM   J_PriceList ");
		sb.append("       LEFT JOIN dbo.SYS_PersonInfo ");
		sb.append("         ON ID = J_PL_CreatePerson ");
		sb.append(" where 1=1 ");
		if(null != po){
			if(!"".equals(Utility.getName(po.getStratDate()))){
				sb.append(" and convert(varchar(10),J_PL_CreateDate,23) >= ?");
				params.add(po.getStratDate());
			}
			if(!"".equals(Utility.getName(po.getEndDate()))){
				sb.append(" and convert(varchar(10),J_PL_CreateDate,23) <= ?");
				params.add(po.getEndDate());
			}
			if(!"".equals(Utility.getName(po.getKjbcoursescontent()))){
				sb.append(" and J_PL_Content like '%' + ? +'%'");
				params.add(po.getKjbcoursescontent());
			}
		}
		sb.append(") table1 where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append("set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(),TrainingCoursesPo.class );
	}

	public int getPriceListCount(TrainingCoursesPo po){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(J_PL_Id)   ");
		sb.append("FROM   J_PriceList ");
		sb.append("       LEFT JOIN dbo.SYS_PersonInfo ");
		sb.append("         ON ID = J_PL_CreatePerson ");
		sb.append(" where 1=1 ");
		if(null != po){
			if(!"".equals(Utility.getName(po.getStratDate()))){
				sb.append(" and convert(varchar(10),J_PL_CreateDate,23) >= ?");
				params.add(po.getStratDate());
			}
			if(!"".equals(Utility.getName(po.getEndDate()))){
				sb.append(" and convert(varchar(10),J_PL_CreateDate,23) <= ?");
				params.add(po.getEndDate());
			}
			if(!"".equals(Utility.getName(po.getKjbcoursescontent()))){
				sb.append(" and J_PL_Content like '%' + ? +'%'");
				params.add(po.getKjbcoursescontent());
			}
		
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	public void deletePriceList(TrainingCoursesPo po){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from J_PriceList where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getKjbid()))){
			sb.append(" and J_PL_Id = ? ");
			params.add(po.getKjbid());
		}
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public void insertPriceList(TrainingCoursesPo po){
		
		StringBuffer  sb = new StringBuffer();
		sb.append("INSERT INTO J_PriceList ");
		sb.append("            (J_PL_Id, ");
		sb.append("             J_PL_CreatePerson, ");
		sb.append("             J_PL_Content, ");
		sb.append("             J_PL_TVUrl, ");
		sb.append("             J_PL_CreateDate,J_PL_DepartmentsId,J_PL_TVName,J_PL_ContentType) ");
		sb.append("VALUES      (?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             getdate(),?,?,? ) ");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getKjbid()));
		params.add(Utility.getName(po.getKjbcreaseperson()));
		params.add(Utility.getName(po.getKjbcoursescontent()));
		params.add(Utility.getName(po.getKjbtvurl()));
		params.add(Utility.getName(po.getKjbdepartmentsid()));
		params.add(Utility.getName(po.getKjbtvname()));
		params.add(Utility.getName(po.getKjbcontenttype()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public void updatePriceList(TrainingCoursesPo po){
		
		StringBuffer  sb = new StringBuffer();
		
		sb.append("UPDATE J_PriceList ");
		sb.append("SET    J_PL_Content = ? ");
		sb.append("WHERE  J_PL_Id = ? ");
		
		List<String> params = new ArrayList<String>();

		params.add(Utility.getName(po.getKjbcoursescontent()));
		params.add(Utility.getName(po.getKjbid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public TrainingCoursesPo getPriceListPo(TrainingCoursesPo po){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT top 1   ");
		sb.append("       J_PL_Id               AS kjbid, ");
		sb.append("       J_PL_Content as kjbcoursescontent, ");
		sb.append("       J_PL_TVUrl            AS kjbtvurl, J_PL_TVName as kjbtvname,J_PL_ContentType as kjbcontenttype ");
		sb.append("FROM   J_PriceList ");
		sb.append("WHERE  J_PL_Id = ? ");
		
		params.add(Utility.getName(po.getKjbid()));
		
		return (TrainingCoursesPo)queryForObject(sb.toString(), params.toArray(), TrainingCoursesPo.class);
	}
	
}
