package com.pengsheng.eims.basic.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.pengsheng.eims.basic.dao.NoticeDao;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.NoticeFilePo;
import com.pengsheng.eims.basic.persistence.NoticePo;
import com.pengsheng.eims.basic.persistence.NoticeStaffViewPo;
import com.pengsheng.eims.basic.persistence.RepairsCostPo;
import com.pengsheng.eims.basic.persistence.StoresSalesPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * 公告管理Dao
 * @author sxh
 *
 */
public class NoticeDaoImpl extends BaseJdbcDaoSupport implements NoticeDao {
	/**
	 * 删除公告
	 */
	public void deleteNotice(NoticePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("DELETE FROM dbo.B_Notice ");
		buffer.append("WHERE  B_NE_UUID = ? ");
		
		params.add(Utility.getName(po.getBneuuid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除公告查看人的子表
	 */
	public void deleteNoticeStaffViewPo(NoticePo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("DELETE FROM B_NoticeStaffView ");
		buffer.append("WHERE  B_NSV_NoticeId = ? ");
		
		params.add(Utility.getName(po.getBneuuid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 新增公告
	 */
	public void insertNotice(NoticePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO dbo.B_Notice ");
		buffer.append("            (B_NE_UUID, ");
		buffer.append("             B_NE_Title, ");
		buffer.append("             B_NE_PublishDate, ");
		buffer.append("             B_NE_PublishPerson, ");
		buffer.append("             B_NE_DepartmentID, ");
		buffer.append("             B_NE_IsSticky, ");
		buffer.append("             B_NE_AddHTML,B_NE_Flag,B_NE_AuditState,B_NE_NoticeType,B_NE_CompanyID) ");
		buffer.append("VALUES     (?, ");
		buffer.append("            ?, ");
		buffer.append("    getdate(), ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?,'1','0',?,?) ");
		
		params.add(Utility.getName(po.getBneuuid()));
		params.add(Utility.getName(po.getBnetitle()));
		params.add(Utility.getName(po.getBnepublishperson()));
		params.add(Utility.getName(po.getBnedepartmentid()));
		params.add(Utility.getName(po.getBneissticky()));
		params.add(Utility.getName(po.getBneaddhtml()));
		params.add(Utility.getName(po.getBnetypeid()));
		params.add(Utility.getName(po.getBnecompanyid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 加载部门CheckBox
	 */
	public List<DepartmentsPo> selectDepartmentList(NoticePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
				
		buffer.append("SELECT B_DP_DepartmentID as bdpdepartmentid, ");
		buffer.append("       B_DP_DepartmentName as bdpdepartmentname ");
		buffer.append("FROM   dbo.B_Departments ");
		buffer.append("WHERE  B_DP_Type = '1' and B_DP_IsClosed <> '1' ");
		
		if(!"".equals(Utility.getName(po.getBnedepartmentid())))
		{
			buffer.append("and  B_DP_DepartmentID in ( ");
			
			String[] paramlist = po.getBnedepartmentid().split(",");
			String tem="";
			for (int i = 0; i < paramlist.length; i++) 
			{				
				tem+="'"+paramlist[i].toString().trim()+"',";								
			}
			tem=tem.substring(0,tem.length()-1);

			buffer.append(tem);
			
			buffer.append(" )");
		}
		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	
	
	/**
	 * 加载部门
	 */
	public List<DepartmentsPo> getDepartmentsList(String id) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
				
		buffer.append("SELECT B_DP_DepartmentID as bdpdepartmentid, ");
		buffer.append("       B_DP_DepartmentName as bdpdepartmentname ");
		buffer.append("FROM   dbo.B_Departments ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(id)))
		{
			buffer.append("and  B_DP_DepartmentID in ( ");
			
			String[] paramlist = id.split(",");
			String tem="";
			for (int i = 0; i < paramlist.length; i++) 
			{				
				tem+="'"+paramlist[i].toString().trim()+"',";								
			}
			tem=tem.substring(0,tem.length()-1);

			buffer.append(tem);
			
			buffer.append(" )");
		}
		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	/**
	 * 查询公告Count
	 */
	public int selectNoticeCount(NoticePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		
		buffer.append("SELECT count(*) ");	
		buffer.append("FROM   dbo.B_Notice ");
		buffer.append("inner join SYS_PersonInfo on B_NE_PublishPerson = ID ");
		buffer.append("WHERE  1 = 1 ");
		
		if (!"".equals(Utility.getName(po.getBnecompanyid()))){
			buffer.append(" and B_NE_CompanyID = ? ");
			params.add(Utility.getName(po.getBnecompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getBneauditstate()))){
			buffer.append("       AND B_NE_AuditState=? ");
			params.add(Utility.getName(po.getBneauditstate()));
		}
		if(!"".equals(Utility.getName(po.getBneflag()))){
			buffer.append("       AND B_NE_Flag=? ");
			params.add(Utility.getName(po.getBneflag()));
		}
		
		if(!"".equals(Utility.getName(po.getBnesearchtitle()))){
			buffer.append("       AND B_NE_Title LIKE '%' +?+ '%' ");
			params.add(po.getBnesearchtitle());
		}
		
		if(!"".equals(Utility.getName(po.getBnedepartmentid()))){
			buffer.append("       AND B_NE_DepartmentID LIKE '%' +?+ '%' ");
			params.add(po.getBnedepartmentid());
		}
		
		if(!"".equals(Utility.getName(po.getBnesearchpublishdatebegin()))){
			buffer.append("       AND CONVERT(VARCHAR(10), B_NE_PublishDate, 23) >= ? ");
			params.add(po.getBnesearchpublishdatebegin());
		}
		
		if(!"".equals(Utility.getName(po.getBnesearchpublishdateend()))){
			buffer.append("       AND CONVERT(VARCHAR(10), B_NE_PublishDate, 23) <= ? ");
			params.add(po.getBnesearchpublishdateend());
		}
		
		if(!"".equals(Utility.getName(po.getBnesearchpublishperson()))){
			buffer.append("       AND B_NE_PublishPerson = ? ");
			params.add(po.getBnesearchpublishperson());
		}
		
		if(!"".equals(Utility.getName(po.getBnetypeid()))){
			buffer.append("       AND B_NE_NoticeType = ? ");
			params.add(Utility.getName(po.getBnetypeid()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 查询公告List
	 */
	public List<NoticePo> selectNoticeList(NoticePo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by B_NE_IsSticky desc , B_NE_PublishDate desc) as 'rowNum', ");
		buffer.append("       B_NE_UUID          AS bneuuid, ");
		buffer.append("       B_NE_Title         AS bnetitle, ");
		buffer.append("       Convert(varchar(16),B_NE_PublishDate,120)   AS bnepublishdate, ");
		buffer.append("       B_NE_PublishPerson AS bnepublishperson, ");
		buffer.append("       b.personName		 AS bnepublishpersonname, ");
		buffer.append("       B_NE_DepartmentID  AS bnedepartmentid, ");
		buffer.append("       B_NE_DocumentUrl   AS bnesavefilename, ");
		buffer.append("       B_NE_ContentType   AS bnecontenttype, ");
		buffer.append("       B_NE_SaveFileName  AS bnedocumenturl,B_NE_NoticeType as bnetypeid,isnull(B_NT_NoticeTypeName,'') as bnetypename,  ");
		buffer.append("       B_NE_IsSticky  AS bneissticky,(select count(B_NSV_UUID) from B_NoticeStaffView where B_NSV_NoticeId=B_NE_UUID) as bnecount, ");
		buffer.append("       B_NE_AddHTML       AS bneaddhtml,isnull(a.personName,'') as bneauditpersonname,B_NE_AuditPerson as bneauditperson,isnull(B_NE_AuditState,0) as bneauditstate,convert(varchar(16),B_NE_AuditDate,120) as bneauditdate,isnull(B_NE_Flag,'1') as bneflag ");
		buffer.append("FROM   dbo.B_Notice ");
		buffer.append("inner join SYS_PersonInfo b on B_NE_PublishPerson = b.ID ");
		buffer.append("left join SYS_PersonInfo a on B_NE_AuditPerson = a.ID ");
		buffer.append("left join B_NoticeType on B_NE_NoticeType=B_NT_NoticeTypeID ");
		buffer.append("WHERE  1 = 1 ");
		
		if (!"".equals(Utility.getName(po.getBnecompanyid()))){
			buffer.append(" and B_NE_CompanyID = ? ");
			params.add(Utility.getName(po.getBnecompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getBneauditstate()))){
			buffer.append("       AND B_NE_AuditState=? ");
			params.add(Utility.getName(po.getBneauditstate()));
		}
		if(!"".equals(Utility.getName(po.getBneflag()))){
			buffer.append("       AND B_NE_Flag=? ");
			params.add(Utility.getName(po.getBneflag()));
		}
		if(!"".equals(Utility.getName(po.getBnesearchtitle()))){
			buffer.append("       AND B_NE_Title LIKE '%' +?+ '%' ");
			params.add(po.getBnesearchtitle());
		}
		
		if(!"".equals(Utility.getName(po.getBnedepartmentid()))){
			buffer.append("       AND B_NE_DepartmentID LIKE '%' +?+ '%' ");
			params.add(po.getBnedepartmentid());
		}
		
		if(!"".equals(Utility.getName(po.getBnesearchpublishdatebegin()))){
			buffer.append("       AND CONVERT(VARCHAR(10), B_NE_PublishDate, 23) >= ? ");
			params.add(po.getBnesearchpublishdatebegin());
		}
		
		if(!"".equals(Utility.getName(po.getBnesearchpublishdateend()))){
			buffer.append("       AND CONVERT(VARCHAR(10), B_NE_PublishDate, 23) <= ? ");
			params.add(po.getBnesearchpublishdateend());
		}
		
		if(!"".equals(Utility.getName(po.getBnesearchpublishperson()))){
			buffer.append("       AND B_NE_PublishPerson = ? ");
			params.add(po.getBnesearchpublishperson());
		}
		
		if(!"".equals(Utility.getName(po.getBnetypeid()))){
			buffer.append("       AND B_NE_NoticeType = ? ");
			params.add(Utility.getName(po.getBnetypeid()));
		}
		
		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), NoticePo.class);
	}
	
	/**
	 * 更新公告信息
	 */
	public void updateNotice(NoticePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("UPDATE dbo.B_Notice ");
		buffer.append("SET ");
		buffer.append("       B_NE_PublishDate = getdate(), ");
		buffer.append("       B_NE_DepartmentID = ?, ");		
		buffer.append("       B_NE_Title = ?, ");	
		buffer.append("       B_NE_IsSticky = ?, ");
		buffer.append("       B_NE_NoticeType = ?, ");
		buffer.append("       B_NE_AddHTML = ? ");
		buffer.append("WHERE  B_NE_UUID = ? ");
		
		params.add(Utility.getName(po.getBnedepartmentid()));
		params.add(Utility.getName(po.getBnetitle()));
		params.add(Utility.getName(po.getBneissticky()));
		params.add(Utility.getName(po.getBnetypeid()));
		params.add(Utility.getName(po.getBneaddhtml()));
		params.add(Utility.getName(po.getBneuuid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 查询公告Po
	 * @param po
	 * @return
	 */
	public NoticePo selectNoticePo(NoticePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 ");
		buffer.append("       B_NE_UUID          AS bneuuid, ");
		buffer.append("       B_NE_Title         AS bnetitle, ");
		buffer.append("       convert(varchar(16),B_NE_PublishDate,120)   AS bnepublishdate, ");
		buffer.append("       B_NE_AuditDate   AS bneauditdate, ");
		buffer.append("       B_NE_PublishPerson AS bnepublishperson, ");
		buffer.append("       b.personName		 AS bnepublishpersonname, ");
		buffer.append("       B_NE_DepartmentID  AS bnedepartmentid, ");
		buffer.append("       B_NE_DocumentUrl   AS bnedocumenturl, ");
		buffer.append("       B_NE_ContentType   AS bnecontenttype, ");
		buffer.append("       B_NE_SaveFileName  AS bnesavefilename, ");
		buffer.append("       B_NE_IsSticky  AS bneissticky,B_NE_NoticeType as bnetypeid,isnull(B_NT_NoticeTypeName,'') as bnetypename, ");
		buffer.append("       B_NE_AddHTML       AS bneaddhtml,isnull(a.personName,'') as bneauditpersonname,B_NE_AuditPerson as bneauditperson,isnull(B_NE_AuditState,0) as bneauditstate,convert(varchar(16),B_NE_AuditDate,120) as bneauditdate,isnull(B_NE_Flag,'1') as bneflag ");
		buffer.append("FROM   dbo.B_Notice ");
		buffer.append("inner join SYS_PersonInfo b on B_NE_PublishPerson = b.ID ");
		buffer.append("left join SYS_PersonInfo a on B_NE_AuditPerson = a.ID ");
		buffer.append("left join B_NoticeType on B_NE_NoticeType=B_NT_NoticeTypeID ");
		buffer.append("WHERE  B_NE_UUID = ? ");
		
		params.add(po.getBneuuid());
		
		return (NoticePo)queryForObject(buffer.toString(), params.toArray(), NoticePo.class);
	}
	
	
	/**
	 * 新增公告查看人
	 */
	public void insertNoticeStaffViewPo(NoticeStaffViewPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO B_NoticeStaffView ");
		buffer.append("            (B_NSV_UUID, ");
		buffer.append("           	 B_NSV_PersonId, ");
		buffer.append("             B_NSV_NoticeId, ");
		buffer.append("             B_NSV_ViewDate,B_NSV_FirstViewDate) ");
		buffer.append("VALUES     (?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("    getdate(),getdate()) ");		
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(po.getBnsvpersonid()));
		params.add(Utility.getName(po.getBnsvnoticeid()));	
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 判断员工是否查看过公告
	 */
	public int getNoticeStaffViewCount(NoticeStaffViewPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(B_NSV_UUID) from B_NoticeStaffView where B_NSV_PersonId=? and B_NSV_NoticeId=? ");

		params.add(Utility.getName(po.getBnsvpersonid()));
		params.add(Utility.getName(po.getBnsvnoticeid()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 更新员工是否查看过公告
	 */
	public void updateNoticeStaffView(NoticeStaffViewPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update top (1) B_NoticeStaffView set B_NSV_ViewDate=getdate() where B_NSV_PersonId=? and B_NSV_NoticeId=? ");

		params.add(Utility.getName(po.getBnsvpersonid()));
		params.add(Utility.getName(po.getBnsvnoticeid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	//查询公告所有查看过的人总数
	public int getViewNoticePersonCount(NoticePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(id) from (select distinct ID,personName,convert(varchar(16),B_NSV_FirstViewDate,120) as firstViewDate,convert(varchar(16),B_NSV_ViewDate,120) as lastViewDate ");
		buffer.append("  from B_NoticeStaffView inner join SYS_PersonInfo on B_NSV_PersonId=id where B_NSV_NoticeId=? )temp ");
		
		params.add(Utility.getName(po.getBneuuid()));

		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	//查询公告所有查看过的人列表
	public List<PersonInfoPo> getPersonList(NoticePo po,int start, int size){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() Over(order by id) as 'rowNum',* from ( ");
		
		buffer.append("select distinct ID as id,personName as personName,convert(varchar(16),B_NSV_FirstViewDate,120) as firstViewDate,convert(varchar(16),B_NSV_ViewDate,120) as lastViewDate ");
		buffer.append("  from B_NoticeStaffView inner join SYS_PersonInfo on B_NSV_PersonId=id where B_NSV_NoticeId=? ");
		
		buffer.append(" ) table1 )temp where rowNum > " + start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");
		
		params.add(Utility.getName(po.getBneuuid()));

		return queryForObjectList(buffer.toString(), params.toArray(),PersonInfoPo.class);
	}
	
	/**
	 *  上传多文件附件
	 */
	public void insertNoticeFile(NoticePo po){																																																	
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO B_NoticeFile ");
		buffer.append("            (B_NF_ID, ");
		buffer.append("             B_NF_NoticeID, ");
		buffer.append("             B_NF_UploadDate, ");
		buffer.append("             B_NF_UploadPerson, ");
		buffer.append("             B_NF_UploadDptID, ");
		buffer.append("             B_NF_DocumentUrl, ");
		buffer.append("             B_NF_ContentType, ");
		buffer.append("             B_NF_SaveFileName) ");
		buffer.append("VALUES     (?, ");
		buffer.append("            ?, ");
		buffer.append("    getdate(), ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?) ");
		
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(po.getBneuuid()));		
		params.add(Utility.getName(po.getBnepublishperson()));
		params.add(Utility.getName(po.getBnedepartmentid()));
		params.add(Utility.getName(po.getDocumentUrl()));
		params.add(Utility.getName(po.getContentType()));
		params.add(Utility.getName(po.getSaveFileName()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 *  删除上传的附件(按公告删除)
	 */
	public void deleteNoticeFile(NoticePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from B_NoticeFile ");
		if (!"".equals(Utility.getName(po.getBneuuid()))){
			buffer.append("  where B_NF_NoticeID=? ");
			params.add(Utility.getName(po.getBneuuid()));
		}
	
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 *  删除上传的附件(按附件删除)
	 */
	public void deleteNoticeFile(NoticeFilePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from B_NoticeFile where B_NF_ID=? ");
		params.add(Utility.getName(po.getBnfuuid()));
	
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 审核公告
	 */
	public void updateNoticeAudit(NoticePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_Notice set B_NE_AuditPerson=?,B_NE_AuditState='1',B_NE_AuditDate=getdate() where B_NE_UUID=? ");
		params.add(Utility.getName(po.getBnepublishperson()));
		params.add(Utility.getName(po.getBneuuid()));
	
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 启用停用公告
	 */
	public void updateNoticeEnable(NoticePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_Notice set B_NE_Flag=? where B_NE_UUID=? ");
		
		params.add(Utility.getName(po.getBneflag()));
		params.add(Utility.getName(po.getBneuuid()));
	
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 修改公告发布部门
	 */
	public void updateNoticeDpt(NoticePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_Notice set B_NE_DepartmentID=? where B_NE_UUID=? ");
		
		params.add(Utility.getName(po.getBnedepartmentid()));
		params.add(Utility.getName(po.getBneuuid()));
	
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 查询公告附件
	 * @param po
	 * @return
	 */
	public List<NoticeFilePo> selectNoticeFile(NoticePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		buffer.append(" select B_NF_ID as bnfuuid, ");
		buffer.append("             B_NF_NoticeID as bnfnoticeid, ");
		buffer.append("             B_NF_UploadDate as bnfpublishdate, ");
		buffer.append("             B_NF_UploadPerson as bnfpublishperson, ");
		buffer.append("             B_NF_UploadDptID as bnfdepartmentid, ");
		buffer.append("             B_NF_DocumentUrl as bnfdocumenturl, ");
		buffer.append("             B_NF_ContentType as bnfcontenttype, ");
		buffer.append("             B_NF_SaveFileName as bnfsavefilename from B_NoticeFile where 1=1 ");

		if (!"".equals(Utility.getName(po.getBneuuid()))){
			buffer.append("  and B_NF_NoticeID=? ");
			params.add(Utility.getName(po.getBneuuid()));
		}
		
		return queryForObjectList(buffer.toString(), params.toArray(),NoticeFilePo.class);
	}
	
	/**
	 * 下载公告附件
	 * @param po
	 * @return
	 */
	public NoticeFilePo selectNoticeFile(NoticeFilePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		buffer.append(" select top 1 B_NF_ID as bnfuuid, ");
		buffer.append("             B_NF_NoticeID as bnfnoticeid, ");
		buffer.append("             B_NF_UploadDate as bnfpublishdate, ");
		buffer.append("             B_NF_UploadPerson as bnfpublishperson, ");
		buffer.append("             B_NF_UploadDptID as bnfdepartmentid, ");
		buffer.append("             B_NF_DocumentUrl as bnfdocumenturl, ");
		buffer.append("             B_NF_ContentType as bnfcontenttype, ");
		buffer.append("             B_NF_SaveFileName as bnfsavefilename from B_NoticeFile where 1=1 ");

		if (!"".equals(Utility.getName(po.getBnfuuid()))){
			buffer.append("  and B_NF_ID=? ");
			params.add(Utility.getName(po.getBnfuuid()));
		}
		
		return (NoticeFilePo)queryForObject(buffer.toString(), params.toArray(), NoticeFilePo.class);
	}
		
	/**
	 * 插入公告类型
	 * @param po
	 */
	public void insertNoticeType(NoticePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into B_NoticeType(B_NT_NoticeTypeID,B_NT_NoticeTypeName) values(?,?) ");
		
		params.add(Utility.getName(po.getBnetypeid()));
		params.add(Utility.getName(po.getBnetypename()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 更新公告类型
	 * @param po
	 */
	public void updateNoticeType(NoticePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update top (1) B_NoticeType set B_NT_NoticeTypeName = ? where B_NT_NoticeTypeID = ? ");		
		
		params.add(Utility.getName(po.getBnetypename()));
		params.add(Utility.getName(po.getBnetypeid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除公告类型
	 * @param po
	 */
	public void deleteNoticeType(NoticePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete top (1) from B_NoticeType where B_NT_NoticeTypeID = ? ");		

		params.add(Utility.getName(po.getBnetypeid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
		
	/**
	 * 查询公告类型的总数
	 * @param po
	 * @return
	 */
	public int getNoticeTypeCount(NoticePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();		
		
		buffer.append("SELECT count(B_NT_NoticeTypeID) FROM   B_NoticeType where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getBnetypeid()))){
			buffer.append("       AND B_NT_NoticeTypeID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBnetypeid()));
		}
		if(!"".equals(Utility.getName(po.getBnetypename()))){
			buffer.append("       AND B_NT_NoticeTypeName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBnetypename()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 查询公告类型的列表
	 * @param po
	 * @return
	 */
	public List<NoticePo> getNoticeTypeList(NoticePo po, int start, int size){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();		
		int countPage = start + size;
		
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by B_NT_NoticeTypeName) as 'rowNum', ");
	    buffer.append("B_NT_NoticeTypeID as bnetypeid,B_NT_NoticeTypeName as bnetypename,(select count(B_NE_UUID) from B_Notice where B_NE_NoticeType=B_NT_NoticeTypeID) as bnecount FROM  B_NoticeType where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getBnetypeid()))){
			buffer.append(" AND B_NT_NoticeTypeID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBnetypeid()));
		}
		if(!"".equals(Utility.getName(po.getBnetypename()))){
			buffer.append(" AND B_NT_NoticeTypeName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBnetypename()));
		}
		
		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");
				
		return queryForObjectList(buffer.toString(), params.toArray(), NoticePo.class);
	}
	
	/**
	 * 查询公告类型的明细
	 * @param po
	 * @return
	 */
	public NoticePo getNoticeTypeDetail(NoticePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

	    buffer.append("select top 1 B_NT_NoticeTypeID as bnetypeid,B_NT_NoticeTypeName as bnetypename FROM  B_NoticeType where B_NT_NoticeTypeID = ? ");
		
		params.add(Utility.getName(po.getBnetypeid()));
		
		return (NoticePo)queryForObject(buffer.toString(), params.toArray(), NoticePo.class);
	}
	
	/**
	 * 查询公告类型的列表
	 * @param po
	 * @return
	 */
	public List<NoticePo> getNoticeTypeList(){
		
		StringBuffer buffer = new StringBuffer();	

	    buffer.append("select B_NT_NoticeTypeID as bnetypeid,B_NT_NoticeTypeName as bnetypename from  B_NoticeType ");
				
		return queryForObjectList(buffer.toString(),null, NoticePo.class);
	}

	public int getStoresSalesAmountCount(String departmentID, String totalType, String companyID) {
		Date date=new Date();//取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE,-1);//把日期往后增加一天.整数往后推,负数往前移动
		date=calendar.getTime(); //这个时间就是日期往后推一天的结果
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		
		List<String> params = new ArrayList<String>();
		StringBuffer  sb = new StringBuffer();
		if(null == totalType || "".equals(totalType) || "1".equals(totalType)) {
			sb.append("SELECT top 4 ");
			sb.append("		  count(*) ");
			sb.append("FROM   B_Departments ");
			sb.append("       LEFT JOIN (SELECT R_SD_DSE_ShopCode, ");
			sb.append("                         SUM(CAST(R_SD_DSE_GoodsAmount AS NUMERIC(20, 2))) AS SalseValue ");
			sb.append("                  FROM   R_RC_DaySalesEntry ");
			sb.append("                  WHERE  Datediff(DAY, '" + dateString + "', R_SD_DSE_Date) >= 0 ");
			sb.append("                         AND Datediff(DAY, '" + dateString + "', R_SD_DSE_Date) <= 0 ");
			sb.append("                  GROUP  BY R_SD_DSE_ShopCode) sales ");
			sb.append("         ON R_SD_DSE_ShopCode = B_DP_Departmentid ");
			sb.append("       LEFT JOIN (SELECT TEMP.S_SE_SB_ShopCode          AS ShopCode, ");
			sb.append("                         Isnull(SUM(TEMP.amount), 0.00) AS amount ");
			sb.append("                  FROM   (SELECT s_se_sb_posid, ");
			sb.append("                                 CAST(S_SE_SB_Additional AS DECIMAL(18, 2)) AS amount, ");
			sb.append("                                 S_SE_SB_ShopCode ");
			sb.append("                          FROM   uview_SalesBasic ");
			sb.append("                          WHERE  1 = 1 ");
			sb.append("                                 AND s_se_sb_ValueFlag = '1' ");
			sb.append("                                 AND CONVERT(VARCHAR(10), s_se_sb_PosDatetime, 23) >= '" + dateString + "' ");
			sb.append("                                 AND CONVERT(VARCHAR(10), s_se_sb_PosDatetime, 23) <= '" + dateString + "' ");
			sb.append("                          UNION ALL ");
			sb.append("                          SELECT S_SE_SB_WithdrawPersonID                    AS posid, ");
			sb.append("                                 -CAST(S_SE_SB_Additional AS DECIMAL(18, 2)) AS amount, ");
			sb.append("                                 S_SE_SB_ShopCode ");
			sb.append("                          FROM   uview_SalesBasic ");
			sb.append("                          WHERE  1 = 1 ");
			sb.append("                                 AND s_se_sb_ValueFlag = '1' ");
			sb.append("                                 AND CONVERT(VARCHAR(10), S_SE_SB_WithdrawDate, 23) >= '" + dateString + "' ");
			sb.append("                                 AND CONVERT(VARCHAR(10), S_SE_SB_WithdrawDate, 23) <= '" + dateString + "' ");
			sb.append("                                 AND s_se_sb_withdrawflag = 1)TEMP ");
			sb.append("                  GROUP  BY S_SE_SB_ShopCode) adds ");
			sb.append("         ON adds.ShopCode = B_DP_Departmentid ");
			sb.append("	WHERE  B_DP_Type = '1' ");
			sb.append("       AND B_DP_IsClosed = '0' ");
			if(null != departmentID && !"".equals(departmentID)) {
				sb.append("               AND B_DP_DepartmentID = ? ");
				params.add(departmentID);
			}
			
			if(!"".equals(companyID)) {
				sb.append("               AND B_DP_CompanysID = ? ");
				params.add(companyID);
			}
			
			
		} else if("2".equals(totalType)) {
			sb.append("SELECT top 4 ");
			sb.append("       count(*) ");
			sb.append("FROM   dbo.B_Departments ");
			sb.append("       LEFT JOIN(SELECT R_SD_DSE_ShopCode, ");
			sb.append("                        SUM(CAST(R_SD_DSE_GoodsAmount AS NUMERIC(20, 2))) AS SalseValue ");
			sb.append("                 FROM   R_RC_DaySalesEntry_AppendArrears ");
			sb.append("                 WHERE  Datediff(DAY, '" + dateString + "', R_SD_DSE_Date) >= 0 ");
			sb.append("                        AND Datediff(DAY, '" + dateString + "', R_SD_DSE_Date) <= 0 ");
			sb.append("                        AND R_SD_DSE_ShopCode = '01' ");
			sb.append("                 GROUP  BY R_SD_DSE_ShopCode)sales ");
			sb.append("         ON sales.R_SD_DSE_ShopCode = B_DP_Departmentid ");
			sb.append("       LEFT JOIN(SELECT Isnull(SUM(TEMP.amount), 0.00) AS amount, ");
			sb.append("                        TEMP.S_SE_SB_ShopCode          AS ShopCode ");
			sb.append("                 FROM   (SELECT CAST(Isnull(S_SE_SB_Additional, '0.0')AS DECIMAL(18, 2)) AS amount, ");
			sb.append("                                S_SE_SB_ShopCode ");
			sb.append("                         FROM   uview_SalesBasic ");
			sb.append("                         WHERE  1 = 1 ");
			sb.append("                                AND S_SE_SB_CheckoutFlag = '0' ");
			sb.append("                                AND S_SE_SB_ArrearsAppendDate IS NULL ");
			sb.append("                                AND s_se_sb_ValueFlag = '1' ");
			sb.append("                                AND CONVERT(VARCHAR(10), s_se_sb_PosDatetime, 23) >= '" + dateString + "' ");
			sb.append("                                AND CONVERT(VARCHAR(10), s_se_sb_PosDatetime, 23) <= '" + dateString + "' ");
			sb.append("                         UNION ALL ");
			sb.append("                         SELECT CAST(Isnull(S_SE_SB_Additional, '0.0')AS DECIMAL(18, 2)) AS amount, ");
			sb.append("                                S_SE_SB_ShopCode ");
			sb.append("                         FROM   uview_SalesBasic ");
			sb.append("                         WHERE  1 = 1 ");
			sb.append("                                AND S_SE_SB_CheckoutFlag = '0' ");
			sb.append("                                AND s_se_sb_ValueFlag = '1' ");
			sb.append("                                AND CONVERT(VARCHAR(10), S_SE_SB_ArrearsAppendDate, 23) >= '" + dateString + "' ");
			sb.append("                                AND CONVERT(VARCHAR(10), S_SE_SB_ArrearsAppendDate, 23) <= '" + dateString + "' ");
			sb.append("                         UNION ALL ");
			sb.append("                         SELECT CAST('-' + CAST(Isnull(S_SE_SB_Additional, '0.0') AS VARCHAR(32)) AS DECIMAL(18, 2)) AS amount, ");
			sb.append("                                S_SE_SB_ShopCode ");
			sb.append("                         FROM   uview_SalesBasic ");
			sb.append("                         WHERE  1 = 1 ");
			sb.append("                                AND S_SE_SB_CheckoutFlag = '0' ");
			sb.append("                                AND s_se_sb_ValueFlag = '1' ");
			sb.append("                                AND CONVERT(VARCHAR(10), S_SE_SB_WithdrawDate, 23) >= '" + dateString + "' ");
			sb.append("                                AND CONVERT(VARCHAR(10), S_SE_SB_WithdrawDate, 23) <= '" + dateString + "' ");
			sb.append("                                AND s_se_sb_withdrawflag = 1 ");
			sb.append("                         UNION ALL ");
			sb.append("                         SELECT -CAST(CAST(Isnull(S_SE_SB_Additional, '0.0') AS VARCHAR(32)) AS DECIMAL(18, 2)) AS amount, ");
			sb.append("                                S_SE_SB_ShopCode ");
			sb.append("                         FROM   uview_SalesBasic ");
			sb.append("                         WHERE  1 = 1 ");
			sb.append("                                AND S_SE_SB_CheckoutFlag = '0' ");
			sb.append("                                AND S_SE_SB_ArrearsAppendDate IS NOT NULL ");
			sb.append("                                AND s_se_sb_ValueFlag = '1' ");
			sb.append("                                AND CONVERT(VARCHAR(10), S_SE_SB_WithdrawDate, 23) >= '" + dateString + "' ");
			sb.append("                                AND CONVERT(VARCHAR(10), S_SE_SB_WithdrawDate, 23) <= '" + dateString + "' ");
			sb.append("                                AND s_se_sb_withdrawflag = 1)TEMP ");
			sb.append("                 GROUP  BY S_SE_SB_ShopCode) adds ");
			sb.append("         ON adds.ShopCode = B_DP_Departmentid ");
			sb.append("WHERE  B_DP_Type = '1' ");
			sb.append("       AND B_DP_IsClosed = '0' ");
			if(null != departmentID && !"".equals(departmentID)) {
				sb.append("               AND B_DP_DepartmentID = ? ");
				params.add(departmentID);
			}
			
			if(!"".equals(companyID)) {
				sb.append("               AND B_DP_CompanysID = ? ");
				params.add(companyID);
			}
			
		} else if("3".equals(totalType)) {
			sb.append("SELECT count(*) from( ");
			sb.append("SELECT TOP 4 ");
			sb.append("       B_DP_DepartmentName			AS storesName, ");
			sb.append("       '" + dateString + "'          AS salesDate, ");
			sb.append("       SUM(CAST(salesvalue AS NUMERIC(20, 2))) 			AS salesAmount ");
			sb.append("FROM  (SELECT S_SE_SL_ShopCode                           AS ShopCode, ");
			sb.append("              SUM(CAST(S_SE_SL_Price AS NUMERIC(18, 2))) AS salesvalue ");
			sb.append("       FROM   S_SE_SalesLog ");
			sb.append("       WHERE  S_SE_SL_Type = '1' ");
			sb.append("              AND S_SE_SL_PaymentType IN ( '1', '2', '3' ) ");
			sb.append("              AND CONVERT(VARCHAR(10), S_SE_SL_DateTime, 23) >= '" + dateString + "' ");
			sb.append("              AND CONVERT(VARCHAR(10), S_SE_SL_DateTime, 23) <= '" + dateString + "' ");
			sb.append("       GROUP  BY S_SE_SL_ShopCode ");
			sb.append("       UNION ALL ");
			sb.append("       SELECT S_SE_SL_ShopCode, ");
			sb.append("              -SUM(CAST(S_SE_SL_Price AS NUMERIC(18, 2))) ");
			sb.append("       FROM   S_SE_SalesLog ");
			sb.append("       WHERE  S_SE_SL_Type = '1' ");
			sb.append("              AND S_SE_SL_PaymentType IN ( '4', '5' ) ");
			sb.append("              AND CONVERT(VARCHAR(10), S_SE_SL_DateTime, 23) >= '" + dateString + "' ");
			sb.append("              AND CONVERT(VARCHAR(10), S_SE_SL_DateTime, 23) <= '" + dateString + "' ");
			sb.append("       GROUP  BY S_SE_SL_ShopCode)TEMP ");
			sb.append("      INNER JOIN B_Departments ");
			sb.append("        ON ShopCode = B_DP_Departmentid ");
			sb.append("WHERE  B_DP_Type = '1' ");
			sb.append("       AND B_DP_IsClosed = '0' ");
			if(null != departmentID && !"".equals(departmentID)) {
				sb.append("               AND B_DP_DepartmentID = ? ");
				params.add(departmentID);
			}
			
			if(!"".equals(companyID)) {
				sb.append("               AND B_DP_CompanysID = ? ");
				params.add(companyID);
			}
			
			sb.append("GROUP  BY ShopCode, ");
			sb.append("          B_DP_DepartmentName) temp ");
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	public List<StoresSalesPo> getStoresSalesAmountList(String departmentID, String totalType, String companyID) {
		Date date=new Date();//取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE,-1);//把日期往后增加一天.整数往后推,负数往前移动
		date=calendar.getTime(); //这个时间就是日期往后推一天的结果
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		
		List<String> params = new ArrayList<String>();
		StringBuffer  sb = new StringBuffer();
		if(null == totalType || "".equals(totalType) || "1".equals(totalType)) {
			sb.append("SELECT top 4 ");
			sb.append("		  B_DP_Departmentid						AS storesID, ");
			sb.append("       B_DP_DepartmentName					AS storesName, ");
			sb.append("               '" + dateString + "'          AS salesDate, ");
			sb.append("       sales.SalseValue + adds.amount 		AS salesAmount ");
			sb.append("FROM   B_Departments ");
			sb.append("       LEFT JOIN (SELECT R_SD_DSE_ShopCode, ");
			sb.append("                         SUM(CAST(R_SD_DSE_GoodsAmount AS NUMERIC(20, 2))) AS SalseValue ");
			sb.append("                  FROM   R_RC_DaySalesEntry ");
			sb.append("                  WHERE  Datediff(DAY, '" + dateString + "', R_SD_DSE_Date) >= 0 ");
			sb.append("                         AND Datediff(DAY, '" + dateString + "', R_SD_DSE_Date) <= 0 ");
			sb.append("                  GROUP  BY R_SD_DSE_ShopCode) sales ");
			sb.append("         ON R_SD_DSE_ShopCode = B_DP_Departmentid ");
			sb.append("       LEFT JOIN (SELECT TEMP.S_SE_SB_ShopCode          AS ShopCode, ");
			sb.append("                         Isnull(SUM(TEMP.amount), 0.00) AS amount ");
			sb.append("                  FROM   (SELECT s_se_sb_posid, ");
			sb.append("                                 CAST(S_SE_SB_Additional AS DECIMAL(18, 2)) AS amount, ");
			sb.append("                                 S_SE_SB_ShopCode ");
			sb.append("                          FROM   uview_SalesBasic ");
			sb.append("                          WHERE  1 = 1 ");
			sb.append("                                 AND s_se_sb_ValueFlag = '1' ");
			sb.append("                                 AND CONVERT(VARCHAR(10), s_se_sb_PosDatetime, 23) >= '" + dateString + "' ");
			sb.append("                                 AND CONVERT(VARCHAR(10), s_se_sb_PosDatetime, 23) <= '" + dateString + "' ");
			sb.append("                          UNION ALL ");
			sb.append("                          SELECT S_SE_SB_WithdrawPersonID                    AS posid, ");
			sb.append("                                 -CAST(S_SE_SB_Additional AS DECIMAL(18, 2)) AS amount, ");
			sb.append("                                 S_SE_SB_ShopCode ");
			sb.append("                          FROM   uview_SalesBasic ");
			sb.append("                          WHERE  1 = 1 ");
			sb.append("                                 AND s_se_sb_ValueFlag = '1' ");
			sb.append("                                 AND CONVERT(VARCHAR(10), S_SE_SB_WithdrawDate, 23) >= '" + dateString + "' ");
			sb.append("                                 AND CONVERT(VARCHAR(10), S_SE_SB_WithdrawDate, 23) <= '" + dateString + "' ");
			sb.append("                                 AND s_se_sb_withdrawflag = 1)TEMP ");
			sb.append("                  GROUP  BY S_SE_SB_ShopCode) adds ");
			sb.append("         ON adds.ShopCode = B_DP_Departmentid ");
			sb.append("	WHERE  B_DP_Type = '1' ");
			sb.append("       AND B_DP_IsClosed = '0' ");
			if(null != departmentID && !"".equals(departmentID)) {
				sb.append("               AND B_DP_DepartmentID = ? ");
				params.add(departmentID);
			}
			
			if(!"".equals(companyID)) {
				sb.append("               AND B_DP_CompanysID = ? ");
				params.add(companyID);
			}
			
			sb.append("ORDER  BY sales.SalseValue + adds.amount DESC ");
		} else if("2".equals(totalType)) {
			sb.append("SELECT top 4  B_DP_Departmentid			AS storesID, ");
			sb.append("       B_DP_DepartmentName				AS storesName, ");
			sb.append("       '" + dateString + "'          	AS salesDate, ");
			sb.append("       Isnull(sales.SalseValue + adds.amount, '0.00') AS salesAmount ");
			sb.append("FROM   dbo.B_Departments ");
			sb.append("       LEFT JOIN(SELECT R_SD_DSE_ShopCode, ");
			sb.append("                        SUM(CAST(R_SD_DSE_GoodsAmount AS NUMERIC(20, 2))) AS SalseValue ");
			sb.append("                 FROM   R_RC_DaySalesEntry_AppendArrears ");
			sb.append("                 WHERE  Datediff(DAY, '" + dateString + "', R_SD_DSE_Date) >= 0 ");
			sb.append("                        AND Datediff(DAY, '" + dateString + "', R_SD_DSE_Date) <= 0 ");
			sb.append("                 GROUP  BY R_SD_DSE_ShopCode)sales ");
			sb.append("         ON sales.R_SD_DSE_ShopCode = B_DP_Departmentid ");
			sb.append("       LEFT JOIN(SELECT Isnull(SUM(TEMP.amount), 0.00) AS amount, ");
			sb.append("                        TEMP.S_SE_SB_ShopCode          AS ShopCode ");
			sb.append("                 FROM   (SELECT CAST(Isnull(S_SE_SB_Additional, '0.0')AS DECIMAL(18, 2)) AS amount, ");
			sb.append("                                S_SE_SB_ShopCode ");
			sb.append("                         FROM   uview_SalesBasic ");
			sb.append("                         WHERE  1 = 1 ");
			sb.append("                                AND S_SE_SB_CheckoutFlag = '0' ");
			sb.append("                                AND S_SE_SB_ArrearsAppendDate IS NULL ");
			sb.append("                                AND s_se_sb_ValueFlag = '1' ");
			sb.append("                                AND CONVERT(VARCHAR(10), s_se_sb_PosDatetime, 23) >= '" + dateString + "' ");
			sb.append("                                AND CONVERT(VARCHAR(10), s_se_sb_PosDatetime, 23) <= '" + dateString + "' ");
			sb.append("                         UNION ALL ");
			sb.append("                         SELECT CAST(Isnull(S_SE_SB_Additional, '0.0')AS DECIMAL(18, 2)) AS amount, ");
			sb.append("                                S_SE_SB_ShopCode ");
			sb.append("                         FROM   uview_SalesBasic ");
			sb.append("                         WHERE  1 = 1 ");
			sb.append("                                AND S_SE_SB_CheckoutFlag = '0' ");
			sb.append("                                AND s_se_sb_ValueFlag = '1' ");
			sb.append("                                AND CONVERT(VARCHAR(10), S_SE_SB_ArrearsAppendDate, 23) >= '" + dateString + "' ");
			sb.append("                                AND CONVERT(VARCHAR(10), S_SE_SB_ArrearsAppendDate, 23) <= '" + dateString + "' ");
			sb.append("                         UNION ALL ");
			sb.append("                         SELECT CAST('-' + CAST(Isnull(S_SE_SB_Additional, '0.0') AS VARCHAR(32)) AS DECIMAL(18, 2)) AS amount, ");
			sb.append("                                S_SE_SB_ShopCode ");
			sb.append("                         FROM   uview_SalesBasic ");
			sb.append("                         WHERE  1 = 1 ");
			sb.append("                                AND S_SE_SB_CheckoutFlag = '0' ");
			sb.append("                                AND s_se_sb_ValueFlag = '1' ");
			sb.append("                                AND CONVERT(VARCHAR(10), S_SE_SB_WithdrawDate, 23) >= '" + dateString + "' ");
			sb.append("                                AND CONVERT(VARCHAR(10), S_SE_SB_WithdrawDate, 23) <= '" + dateString + "' ");
			sb.append("                                AND s_se_sb_withdrawflag = 1 ");
			sb.append("                         UNION ALL ");
			sb.append("                         SELECT -CAST(CAST(Isnull(S_SE_SB_Additional, '0.0') AS VARCHAR(32)) AS DECIMAL(18, 2)) AS amount, ");
			sb.append("                                S_SE_SB_ShopCode ");
			sb.append("                         FROM   uview_SalesBasic ");
			sb.append("                         WHERE  1 = 1 ");
			sb.append("                                AND S_SE_SB_CheckoutFlag = '0' ");
			sb.append("                                AND S_SE_SB_ArrearsAppendDate IS NOT NULL ");
			sb.append("                                AND s_se_sb_ValueFlag = '1' ");
			sb.append("                                AND CONVERT(VARCHAR(10), S_SE_SB_WithdrawDate, 23) >= '" + dateString + "' ");
			sb.append("                                AND CONVERT(VARCHAR(10), S_SE_SB_WithdrawDate, 23) <= '" + dateString + "' ");
			sb.append("                                AND s_se_sb_withdrawflag = 1)TEMP ");
			sb.append("                 GROUP  BY S_SE_SB_ShopCode) adds ");
			sb.append("         ON adds.ShopCode = B_DP_Departmentid ");
			sb.append("WHERE  B_DP_Type = '1' ");
			sb.append("       AND B_DP_IsClosed = '0' ");
			if(null != departmentID && !"".equals(departmentID)) {
				sb.append("               AND B_DP_DepartmentID = ? ");
				params.add(departmentID);
			}
			
			if(!"".equals(companyID)) {
				sb.append("               AND B_DP_CompanysID = ? ");
				params.add(companyID);
			}
			
			sb.append("ORDER  BY sales.SalseValue + adds.amount DESC ");
		} else if("3".equals(totalType)) {
			sb.append("SELECT TOP 4 ShopCode				AS storesID, ");
			sb.append("       B_DP_DepartmentName			AS storesName, ");
			sb.append("       '" + dateString + "'          AS salesDate, ");
			sb.append("       SUM(CAST(salesvalue AS NUMERIC(20, 2))) 			AS salesAmount ");
			sb.append("FROM  (SELECT S_SE_SL_ShopCode                           AS ShopCode, ");
			sb.append("              SUM(CAST(S_SE_SL_Price AS NUMERIC(18, 2))) AS salesvalue ");
			sb.append("       FROM   S_SE_SalesLog ");
			sb.append("       WHERE  S_SE_SL_Type = '1' ");
			sb.append("              AND S_SE_SL_PaymentType IN ( '1', '2', '3' ) ");
			sb.append("              AND CONVERT(VARCHAR(10), S_SE_SL_DateTime, 23) >= '" + dateString + "' ");
			sb.append("              AND CONVERT(VARCHAR(10), S_SE_SL_DateTime, 23) <= '" + dateString + "' ");
			sb.append("       GROUP  BY S_SE_SL_ShopCode ");
			sb.append("       UNION ALL ");
			sb.append("       SELECT S_SE_SL_ShopCode, ");
			sb.append("              -SUM(CAST(S_SE_SL_Price AS NUMERIC(18, 2))) ");
			sb.append("       FROM   S_SE_SalesLog ");
			sb.append("       WHERE  S_SE_SL_Type = '1' ");
			sb.append("              AND S_SE_SL_PaymentType IN ( '4', '5' ) ");
			sb.append("              AND CONVERT(VARCHAR(10), S_SE_SL_DateTime, 23) >= '" + dateString + "' ");
			sb.append("              AND CONVERT(VARCHAR(10), S_SE_SL_DateTime, 23) <= '" + dateString + "' ");
			sb.append("       GROUP  BY S_SE_SL_ShopCode)TEMP ");
			sb.append("      INNER JOIN B_Departments ");
			sb.append("        ON ShopCode = B_DP_Departmentid ");
			sb.append("WHERE  B_DP_Type = '1' ");
			sb.append("       AND B_DP_IsClosed = '0' ");
			if(null != departmentID && !"".equals(departmentID)) {
				sb.append("               AND B_DP_DepartmentID = ? ");
				params.add(departmentID);
			}
			
			if(!"".equals(companyID)) {
				sb.append("               AND B_DP_CompanysID = ? ");
				params.add(companyID);
			}
			
			sb.append("GROUP  BY ShopCode, ");
			sb.append("          B_DP_DepartmentName ");
			sb.append("ORDER  BY SUM(CAST(salesvalue AS NUMERIC(20, 2))) DESC ");
		}
		
		return queryForObjectList(sb.toString(), params.toArray(), StoresSalesPo.class);
	}
	
	/**
	 * 查询维修项的明细
	 * @param po
	 * @return
	 */
	public RepairsCostPo getRepairsCostDetail(RepairsCostPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 ");
		buffer.append("       F_RC_ID as frcid,F_RC_RegisteredName as frcname,F_RC_InMoney as frcinmoney,F_RC_OutMoney as frcoutmoney ");
		buffer.append("FROM   F_RepairsCost ");
		buffer.append("WHERE  F_RC_ID = ? ");
		
		params.add(Utility.getName(po.getFrcid()));
		
		return (RepairsCostPo)queryForObject(buffer.toString(), params.toArray(), RepairsCostPo.class);
	}
	
	/**
	 * 插入维修项
	 * @param po
	 */
	public void insertRepairsCost(RepairsCostPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO F_RepairsCost (F_RC_ID,F_RC_RegisteredName,F_RC_InMoney,F_RC_OutMoney) ");
		buffer.append(" VALUES (?,?,?,?) ");
		
		params.add(Utility.getName(po.getFrcid()));
		params.add(Utility.getName(po.getFrcname()));
		params.add(Utility.getName(po.getFrcinmoney()));
		params.add(Utility.getName(po.getFrcoutmoney()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 更新维修项
	 * @param po
	 */
	public void updateRepairsCost(RepairsCostPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("UPDATE F_RepairsCost ");
		buffer.append("SET ");
		buffer.append("       F_RC_RegisteredName = ?, ");
		buffer.append("       F_RC_InMoney = ?, ");		
		buffer.append("       F_RC_OutMoney = ? ");	
		buffer.append("WHERE  F_RC_ID = ? ");

		params.add(Utility.getName(po.getFrcname()));
		params.add(Utility.getName(po.getFrcinmoney()));
		params.add(Utility.getName(po.getFrcoutmoney()));
		params.add(Utility.getName(po.getFrcid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除维修项
	 * @param po
	 */
	public void deleteRepairsCost(RepairsCostPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("DELETE FROM F_RepairsCost ");
		buffer.append("WHERE  F_RC_ID = ? ");
		
		params.add(Utility.getName(po.getFrcid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 查询维修项的总数
	 * @param po
	 * @return
	 */
	public int getRepairsCostCount(RepairsCostPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();		
		
		buffer.append("SELECT count(*) ");
		buffer.append("FROM   F_RepairsCost ");
		buffer.append("WHERE  1 = 1 ");
		
		if(!"".equals(Utility.getName(po.getFrcid()))){
			buffer.append("       AND F_RC_ID LIKE '%' +?+ '%' ");
			params.add(Utility.getName(po.getFrcid()));
		}
		
		if(!"".equals(Utility.getName(po.getFrcname()))){
			buffer.append("       AND F_RC_RegisteredName LIKE '%' +?+ '%' ");
			params.add(Utility.getName(po.getFrcname()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 查询维修项的列表
	 * @param po
	 * @return
	 */
	public List<RepairsCostPo> getRepairsCostList(RepairsCostPo po, int start, int size){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by F_RC_RegisteredName desc) as 'rowNum', ");
		buffer.append("       F_RC_ID as frcid,F_RC_RegisteredName as frcname,F_RC_InMoney as frcinmoney,F_RC_OutMoney as frcoutmoney,(select count(S_CR_RD_ID) from S_CR_RepairsCostDetails where S_CR_RD_RegisteredID=F_RC_ID) as frccount ");
		buffer.append("FROM   F_RepairsCost ");
		buffer.append("WHERE  1 = 1 ");
		
		if(!"".equals(Utility.getName(po.getFrcid()))){
			buffer.append("       AND F_RC_ID LIKE '%' +?+ '%' ");
			params.add(Utility.getName(po.getFrcid()));
		}
		
		if(!"".equals(Utility.getName(po.getFrcname()))){
			buffer.append("       AND F_RC_RegisteredName LIKE '%' +?+ '%' ");
			params.add(Utility.getName(po.getFrcname()));
		}
		
		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), RepairsCostPo.class);
	}
	
		
}
