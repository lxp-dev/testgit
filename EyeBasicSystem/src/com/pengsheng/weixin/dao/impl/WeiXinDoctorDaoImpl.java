package com.pengsheng.weixin.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinDoctorDao;
import com.pengsheng.weixin.persistence.WeiXinDoctorPo;

public class WeiXinDoctorDaoImpl extends BaseJdbcDaoSupport implements WeiXinDoctorDao{

	public void deleteWeiXinDoctorPo(WeiXinDoctorPo po) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from W_Doctor where W_D_ID = '"+ po.getWdid() +"'");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public void insertWeiXinDoctorPo(WeiXinDoctorPo po) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("INSERT INTO W_Doctor ");
		buffer.append("            (W_D_ID, ");
		buffer.append("             W_D_PersonId, ");
		buffer.append("             W_D_Zhicheng, ");		
		buffer.append("             W_D_Zhiwu, ");
		buffer.append("             W_D_WorkDay, ");
		buffer.append("             W_D_Content, ");
		buffer.append("             W_D_Firstshow, ");
		buffer.append("             W_D_PicUrl, ");
		buffer.append("             W_D_Wangdian, ");		
		buffer.append("             W_D_Zhenliao) ");
		buffer.append("VALUES      ( '"+ this.uuid.generate() +"', ");
		buffer.append("              '"+ Utility.getName(po.getWdpersonid()) +"', ");		
		buffer.append("              '"+ Utility.getName(po.getWdzhicheng()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWdzhiwu()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWdworkday()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWdcontent()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWdfirstshow()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWdpicurl()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWdwangdian()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWdzhenliao()) +"' ");
		buffer.append("             ) ");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public WeiXinDoctorPo selectWeiXinDoctorPo(
			WeiXinDoctorPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT TOP 1 W_D_ID      AS wdid, ");
		buffer.append("             SYS_PersonInfo.id    AS wdpersonid, ");
		buffer.append("             SYS_PersonInfo.sex    AS wdsex, ");
		buffer.append("             W_D_PersonId    AS wdpersonid1, ");
		buffer.append("             W_D_Zhiwu   AS wdzhiwu, ");
		buffer.append("             W_D_Zhicheng   AS wdzhicheng, ");
		buffer.append("             isnull(W_D_PicUrl,'') AS wdpicurl, ");
		buffer.append("             W_D_WorkDay    AS wdworkday, ");
		buffer.append("             W_D_Content    AS wdcontent, ");
		buffer.append("             W_D_Firstshow    AS wdfirstshow, ");
		buffer.append("				personName as wdname, ");
		buffer.append("				dbo.getHaopinglvByDoctorID(SYS_PersonInfo.id) as wdhaopinglv, ");
		buffer.append("				dbo.getDepartmentNameList(SYS_PersonInfo.id) as wddepartmentname, ");
		buffer.append("				W_D_Wangdian as wdwangdian, ");
		buffer.append("				W_D_Zhenliao as wdzhenliao ");
		buffer.append("FROM   SYS_PersonInfo ");
		buffer.append(" left join W_Doctor on W_Doctor.W_D_PersonId = SYS_PersonInfo.id ");

		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getWdid()))){
			buffer.append("AND W_D_ID = ? ");
			params.add(Utility.getName(po.getWdid()));
		}
		if(!"".equals(Utility.getName(po.getWdpersonid()))){
			buffer.append("AND SYS_PersonInfo.id = ? ");
			params.add(Utility.getName(po.getWdpersonid()));
		}
		if(!"".equals(Utility.getName(po.getWdname()))){
			buffer.append("AND personName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getWdname()));
		}		
		if(!"".equals(Utility.getName(po.getWdzhiwu()))){
			buffer.append("AND W_D_Zhiwu like '%' + ? + '%' ");
			params.add(Utility.getName(po.getWdzhiwu()));
		}	
		if(!"".equals(Utility.getName(po.getWdfirstshow()))){
			buffer.append("AND W_D_Firstshow = ? ");
			params.add(Utility.getName(po.getWdfirstshow()));
		}
		if(!"".equals(Utility.getName(po.getWdwangdian()))){
			buffer.append("AND ? in (select str2table from dbo.Strtotable(W_D_Wangdian))");
			params.add(Utility.getName(po.getWdwangdian()));
		}
		if(!"".equals(Utility.getName(po.getWdzhenliao()))){
			buffer.append("AND ? in (select str2table from dbo.Strtotable(W_D_Zhenliao))");
			params.add(Utility.getName(po.getWdzhenliao()));
		}	

		return (WeiXinDoctorPo) queryForObject(buffer.toString(), params.toArray(), WeiXinDoctorPo.class);
	}
	
	/**
	 * 获得验光师信息
	 * @param String personID
	 */
	public WeiXinDoctorPo selectWeiXinDoctorPo(String personID){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("SELECT TOP 1 SYS_PersonInfo.id    AS wdpersonid, ");
		buffer.append("             SYS_PersonInfo.sex    AS wdsex, ");
		buffer.append("				personName as wdname, ");
		buffer.append("				dbo.getHaopinglvByDoctorID(SYS_PersonInfo.id) as wdhaopinglv, ");
		buffer.append("				dbo.getDepartmentNameList(SYS_PersonInfo.id) as wddepartmentname ");
		buffer.append("FROM  SYS_PersonInfo ")	;

		buffer.append("WHERE SYS_PersonInfo.id = '"+ Utility.getName(personID) +"' ");

		return (WeiXinDoctorPo) queryForObject(buffer.toString(), null, WeiXinDoctorPo.class);
	}
	

	public void updateWeiXinDoctorPo(WeiXinDoctorPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("Update W_Doctor set ");
		buffer.append("             W_D_Zhiwu = ?, ");
		buffer.append("             W_D_Zhicheng = ?, ");
		buffer.append("             W_D_PicUrl = ?, ");
		buffer.append("             W_D_WorkDay = ?, ");	
		buffer.append("             W_D_Content = ?, ");
		buffer.append("             W_D_Firstshow = ?, ");
		buffer.append("             W_D_Wangdian = ?, ");
		buffer.append("             W_D_Zhenliao = ? ");
		buffer.append("where W_D_ID = ? ");
		
		params.add(Utility.getName(po.getWdzhiwu()));
		params.add(Utility.getName(po.getWdzhicheng()));
		params.add(Utility.getName(po.getWdpicurl()));
		params.add(Utility.getName(po.getWdworkday()));	
		params.add(Utility.getName(po.getWdcontent()));
		params.add(Utility.getName(po.getWdfirstshow()));
		params.add(Utility.getName(po.getWdwangdian()));
		params.add(Utility.getName(po.getWdzhenliao()));
		params.add(Utility.getName(po.getWdid()));	
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public int selectWeiXinDoctorCount(WeiXinDoctorPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT count(*) ");
		buffer.append("FROM   W_Doctor ");
		buffer.append(" left join SYS_PersonInfo on W_Doctor.W_D_PersonId = SYS_PersonInfo.id ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getWdid()))){
			buffer.append("AND W_D_ID = ? ");
			params.add(Utility.getName(po.getWdid()));
		}
		if(!"".equals(Utility.getName(po.getWdpersonid()))){
			buffer.append("AND SYS_PersonInfo.id = ? ");
			params.add(Utility.getName(po.getWdpersonid()));
		}
		if(!"".equals(Utility.getName(po.getWdname()))){
			buffer.append("AND personName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getWdname()));
		}		
		if(!"".equals(Utility.getName(po.getWdzhiwu()))){
			buffer.append("AND W_D_Zhiwu like '%' + ? + '%' ");
			params.add(Utility.getName(po.getWdzhiwu()));
		}
		if(!"".equals(Utility.getName(po.getWdfirstshow()))){
			buffer.append("AND W_D_Firstshow = ? ");
			params.add(Utility.getName(po.getWdfirstshow()));
		}		
		if(!"".equals(Utility.getName(po.getWdwangdian()))){
			buffer.append("AND ? in (select str2table from dbo.Strtotable(W_D_Wangdian))");
			params.add(Utility.getName(po.getWdwangdian()));
		}
		if(!"".equals(Utility.getName(po.getWdzhenliao()))){
			buffer.append("AND ? in (select str2table from dbo.Strtotable(W_D_Zhenliao))");
			params.add(Utility.getName(po.getWdzhenliao()));
		}	
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public List<WeiXinDoctorPo> selectWeiXinDoctorList(
			WeiXinDoctorPo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		
		buffer.append("SELECT	    * from( ");
		buffer.append("SELECT	    ROW_NUMBER() Over(order by W_D_ID) as rowNum, ");
		buffer.append("             W_D_ID      AS wdid, ");
		buffer.append("             W_D_PersonId    AS wdpersonid, ");
		buffer.append("             SYS_PersonInfo.sex    AS wdsex, ");
		buffer.append("             W_D_Zhiwu   AS wdzhiwu, ");
		buffer.append("             W_D_Zhicheng   AS wdzhicheng, ");
		buffer.append("             isnull(W_D_PicUrl,'') AS wdpicurl, ");
		buffer.append("             W_D_WorkDay    AS wdworkday, ");
		buffer.append("             W_D_Content    AS wdcontent, ");
		buffer.append("             W_D_Firstshow  AS wdfirstshow, ");
		buffer.append("				personName as wdname, ");
		buffer.append("				dbo.getHaopinglvByDoctorID(SYS_PersonInfo.id) as wdhaopinglv, ");
		buffer.append("				dbo.getDepartmentNameList(SYS_PersonInfo.id)  as wddepartmentname ");
		buffer.append("FROM   W_Doctor ");
		buffer.append(" left join SYS_PersonInfo on W_Doctor.W_D_PersonId = SYS_PersonInfo.id ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getWdid()))){
			buffer.append("AND W_D_ID = ? ");
			params.add(Utility.getName(po.getWdid()));
		}
		if(!"".equals(Utility.getName(po.getWdpersonid()))){
			buffer.append("AND SYS_PersonInfo.id = ? ");
			params.add(Utility.getName(po.getWdpersonid()));
		}
		if(!"".equals(Utility.getName(po.getWdname()))){
			buffer.append("AND personName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getWdname()));
		}		
		if(!"".equals(Utility.getName(po.getWdzhiwu()))){
			buffer.append("AND W_D_Zhiwu like '%' + ? + '%' ");
			params.add(Utility.getName(po.getWdzhiwu()));
		}	
		if(!"".equals(Utility.getName(po.getWdfirstshow()))){
			buffer.append("AND W_D_Firstshow = ? ");
			params.add(Utility.getName(po.getWdfirstshow()));
		}	
		if(!"".equals(Utility.getName(po.getWdwangdian()))){
			buffer.append("AND ? in (select str2table from dbo.Strtotable(W_D_Wangdian))");
			params.add(Utility.getName(po.getWdwangdian()));
		}
		if(!"".equals(Utility.getName(po.getWdzhenliao()))){
			buffer.append("AND ? in (select str2table from dbo.Strtotable(W_D_Zhenliao))");
			params.add(Utility.getName(po.getWdzhenliao()));
		}	
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), WeiXinDoctorPo.class);
	}
	
	/**
	 * 获取验光师信息List
	 * @param po
	 * @return
	 */
	public List<WeiXinDoctorPo> selectWeiXinDoctorList(WeiXinDoctorPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT	    W_D_ID      AS wdid, ");
		buffer.append("             W_D_PersonId    AS wdpersonid, ");
		buffer.append("             SYS_PersonInfo.sex    AS wdsex, ");
		buffer.append("             isnull(W_D_Zhiwu,'')   AS wdzhiwu, ");
		buffer.append("             isnull(W_D_Zhicheng,'')   AS wdzhicheng, ");
		buffer.append("             isnull(W_D_PicUrl,'') AS wdpicurl, ");
		buffer.append("             W_D_WorkDay    AS wdworkday, ");
		buffer.append("             isnull(W_D_Content,'')    AS wdcontent, ");
		buffer.append("             W_D_Firstshow  AS wdfirstshow, ");
		buffer.append("				personName as wdname, ");
		buffer.append("				dbo.getHaopinglvByDoctorID(SYS_PersonInfo.id) as wdhaopinglv, ");
		buffer.append("				dbo.getDepartmentNameList(SYS_PersonInfo.id)  as wddepartmentname ");
		buffer.append("FROM   W_Doctor ");
		buffer.append(" left join SYS_PersonInfo on W_Doctor.W_D_PersonId = SYS_PersonInfo.id ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getWdid()))){
			buffer.append("AND W_D_ID = ? ");
			params.add(Utility.getName(po.getWdid()));
		}
		if(!"".equals(Utility.getName(po.getWdpersonid()))){
			buffer.append("AND SYS_PersonInfo.id = ? ");
			params.add(Utility.getName(po.getWdpersonid()));
		}
		if(!"".equals(Utility.getName(po.getWdname()))){
			buffer.append("AND personName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getWdname()));
		}		
		if(!"".equals(Utility.getName(po.getWdzhiwu()))){
			buffer.append("AND W_D_Zhiwu like '%' + ? + '%' ");
			params.add(Utility.getName(po.getWdzhiwu()));
		}	
		if(!"".equals(Utility.getName(po.getWdfirstshow()))){
			buffer.append("AND W_D_Firstshow = ? ");
			params.add(Utility.getName(po.getWdfirstshow()));
		}
		if(!"".equals(Utility.getName(po.getWdwangdian()))){
			buffer.append("AND ? in (select str2table from dbo.Strtotable(W_D_Wangdian))");
			params.add(Utility.getName(po.getWdwangdian()));
		}
		if(!"".equals(Utility.getName(po.getWdzhenliao()))){
			buffer.append("AND ? in (select str2table from dbo.Strtotable(W_D_Zhenliao))");
			params.add(Utility.getName(po.getWdzhenliao()));
		}	
		buffer.append(" order by W_D_Firstshow desc");
		return queryForObjectList(buffer.toString(), params.toArray(), WeiXinDoctorPo.class);
	}
}