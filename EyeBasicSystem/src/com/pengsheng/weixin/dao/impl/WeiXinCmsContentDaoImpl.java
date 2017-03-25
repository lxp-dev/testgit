package com.pengsheng.weixin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.sales.persistence.CustomerComplainPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinCmsContentDao;
import com.pengsheng.weixin.persistence.WeiXinCmsContentPo;

public class WeiXinCmsContentDaoImpl extends BaseJdbcDaoSupport implements WeiXinCmsContentDao{

	public void deleteWeiXinCmsContentPo(WeiXinCmsContentPo po) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from W_CMS_Content where W_CMS_C_ID = '"+ po.getWcmscid() +"'");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public void insertWeiXinCmsContentPo(WeiXinCmsContentPo po) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("INSERT INTO W_CMS_Content ");
		buffer.append("            (W_CMS_C_ID, ");
		buffer.append("             W_CMS_C_Title, ");
		buffer.append("             W_CMS_C_Description, ");
		buffer.append("             W_CMS_C_Content, ");		
		buffer.append("             W_CMS_C_PicUrl, ");
		buffer.append("             W_CMS_C_PicIsShow, ");		
		buffer.append("             W_CMS_C_Flag, ");
		buffer.append("             W_CMS_C_TypeID, ");		
		buffer.append("             W_CMS_C_CreateDate) ");
		buffer.append("VALUES      ( '"+ this.uuid.generate() +"', ");
		buffer.append("              '"+ Utility.getName(po.getWcmsctitle()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWcmscdescription()) +"', ");		
		buffer.append("              '"+ Utility.getName(po.getWcmsccontent()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWcmscpicurl()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWcmscpicisshow()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWcmscflag()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWcmsctypeid()) +"', ");
		buffer.append("              getdate() ) ");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public WeiXinCmsContentPo selectWeiXinCmsContentPo(
			WeiXinCmsContentPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT TOP 1 W_CMS_C_ID      AS wcmscid, ");
		buffer.append("             W_CMS_C_Title    AS wcmsctitle, ");
		buffer.append("             W_CMS_C_Description   AS wcmscdescription, ");
		buffer.append("             W_CMS_C_Content   AS wcmsccontent, ");
		buffer.append("             isnull(W_CMS_C_PicUrl,'') AS wcmscpicurl, ");
		buffer.append("             W_CMS_C_PicIsShow as wcmscpicisshow, ");
		buffer.append("             W_CMS_C_Flag    AS wcmscflag, ");
		buffer.append("             W_CMS_C_TypeID    AS wcmsctypeid, ");
		buffer.append("             W_CMS_T_Name    AS wcmsctypename, ");
		buffer.append("             W_CMS_C_CreateDate    AS wcmsccreatedate ");
		buffer.append("FROM   W_CMS_Content ");
		buffer.append("left join W_CMS_Type on W_CMS_C_TypeID = W_CMS_T_ID ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getWcmscid()))){
			buffer.append("AND W_CMS_C_ID = ? ");
			params.add(Utility.getName(po.getWcmscid()));
		}
		
		if(!"".equals(Utility.getName(po.getWcmsctitle()))){
			buffer.append("AND W_CMS_C_Title = ? ");
			params.add(Utility.getName(po.getWcmsctitle()));
		}
		
		return (WeiXinCmsContentPo) queryForObject(buffer.toString(), params.toArray(), WeiXinCmsContentPo.class);
	}

	public void updateWeiXinCmsContentPo(WeiXinCmsContentPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("Update W_CMS_Content set ");
		buffer.append("             W_CMS_C_Title = ?, ");
		buffer.append("             W_CMS_C_Description = ?, ");
		buffer.append("             W_CMS_C_PicUrl = ?, ");		
		buffer.append("             W_CMS_C_PicIsShow = ?, ");	
		buffer.append("             W_CMS_C_Content = ?, ");
		buffer.append("             W_CMS_C_CreateDate = getdate(), ");
		buffer.append("             W_CMS_C_Flag = ?, ");		
		buffer.append("             W_CMS_C_TypeID = ? ");
		buffer.append("where W_CMS_C_ID = ? ");
		
		params.add(Utility.getName(po.getWcmsctitle()));
		params.add(Utility.getName(po.getWcmscdescription()));
		params.add(Utility.getName(po.getWcmscpicurl()));	
		params.add(Utility.getName(po.getWcmscpicisshow()));	
		params.add(Utility.getName(po.getWcmsccontent()));
		params.add(Utility.getName(po.getWcmscflag()));
		params.add(Utility.getName(po.getWcmsctypeid()));
		params.add(Utility.getName(po.getWcmscid()));		
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void updateWeiXinCmsContentFlag(WeiXinCmsContentPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("Update W_CMS_Content set ");
		buffer.append("             W_CMS_C_Flag = ? ");
		buffer.append("Where W_CMS_C_ID = ? ");
		
		params.add(Utility.getName(po.getWcmscflag()));
		params.add(Utility.getName(po.getWcmscid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public int selectWeiXinCmsContentCount(WeiXinCmsContentPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT count(*) ");
		buffer.append("FROM   W_CMS_Content ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getWcmsctitle()))){
			buffer.append("AND W_CMS_C_Title like '%' + ? + '%' ");
			params.add(Utility.getName(po.getWcmsctitle()));
		}
		
		if(!Utility.getName(po.getWcmsccontent()).equals("")){
			buffer.append("AND  W_CMS_C_Content like '%' + ? + '%' ");
			params.add(Utility.getName(po.getWcmsccontent()));
		}
		
		if(!Utility.getName(po.getWcmscflag()).equals("")){
			buffer.append("AND  W_CMS_C_Flag = ? ");
			params.add(Utility.getName(po.getWcmscflag()));
		}
		
		if(!Utility.getName(po.getWcmsctypeid()).equals("")){
			buffer.append("AND  W_CMS_C_TypeID = ? ");
			params.add(Utility.getName(po.getWcmsctypeid()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public List<WeiXinCmsContentPo> selectWeiXinCmsContentList(
			WeiXinCmsContentPo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		
		buffer.append("SELECT	    * from( ");
		buffer.append("SELECT	    ROW_NUMBER() Over(order by W_CMS_C_CreateDate desc) as rowNum, ");
		buffer.append("             W_CMS_C_ID    AS wcmscid, ");
		buffer.append("             W_CMS_C_Title    AS wcmsctitle, ");
		buffer.append("             W_CMS_C_Description   AS wcmscdescription, ");
		buffer.append("             W_CMS_C_Flag    AS wcmscflag, ");
		buffer.append("             W_CMS_T_Name    AS wcmsctypename, ");
		buffer.append("             W_CMS_C_CreateDate    AS wcmsccreatedate ");
		buffer.append("FROM   W_CMS_Content ");
		buffer.append("left join W_CMS_Type on W_CMS_C_TypeID = W_CMS_T_ID ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getWcmsctitle()))){
			buffer.append("AND W_CMS_C_Title like '%' + ? + '%' ");
			params.add(Utility.getName(po.getWcmsctitle()));
		}
		
		if(!Utility.getName(po.getWcmsccontent()).equals("")){
			buffer.append("AND  W_CMS_C_Content like '%' + ? + '%' ");
			params.add(Utility.getName(po.getWcmsccontent()));
		}
		
		if(!Utility.getName(po.getWcmscflag()).equals("")){
			buffer.append("AND  W_CMS_C_Flag = ? ");
			params.add(Utility.getName(po.getWcmscflag()));
		}
		
		if(!Utility.getName(po.getWcmsctypeid()).equals("")){
			buffer.append("AND  W_CMS_C_TypeID = ? ");
			params.add(Utility.getName(po.getWcmsctypeid()));
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), WeiXinCmsContentPo.class);
	}
	
	public CustomerComplainPo selectCustomerComplainPo(CustomerComplainPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT TOP 1 ");
		buffer.append("             S_ME_CI_MemberId	AS smecccustomermemberid, ");
		buffer.append("             S_ME_CI_Name 		AS smecccustomername, ");
		buffer.append("             S_ME_CI_Phone 		AS smecccustomerphone, ");
		buffer.append("             getdate()+2    		AS smeccintendhandledate ");
		buffer.append("FROM   S_ME_CustomerInfo ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getSmecccustomermemberid()))){
			buffer.append("AND  S_ME_CI_OpenID = ? ");
			params.add(Utility.getName(po.getSmecccustomermemberid()));
		}
		
		return (CustomerComplainPo) queryForObject(buffer.toString(), params.toArray(), CustomerComplainPo.class);
	}
	
	public List<WeiXinCmsContentPo> selectWeiXinCmsContentListForView(WeiXinCmsContentPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT W_CMS_C_ID      AS wcmscid, ");
		buffer.append("             W_CMS_C_Title    AS wcmsctitle, ");
		buffer.append("             W_CMS_C_Description   AS wcmscdescription, ");
		buffer.append("             W_CMS_C_Content   AS wcmsccontent, ");
		buffer.append("             isnull(W_CMS_C_PicUrl,'') AS wcmscpicurl, ");
		buffer.append("             W_CMS_C_Flag    AS wcmscflag, ");
		buffer.append("             W_CMS_C_TypeID    AS wcmsctypeid, ");
		buffer.append("             W_CMS_T_Name    AS wcmsctypename, ");
		buffer.append("             W_CMS_C_CreateDate    AS wcmsccreatedate ");
		buffer.append("FROM   W_CMS_Content ");
		buffer.append("left join W_CMS_Type on W_CMS_C_TypeID = W_CMS_T_ID ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getWcmsctitle()))){
			buffer.append("AND W_CMS_C_Title = ? ");
			params.add(Utility.getName(po.getWcmsctitle()));
		}
		
		if(!Utility.getName(po.getWcmsccontent()).equals("")){
			buffer.append("AND  W_CMS_C_Content like '%' + ? + '%' ");
			params.add(Utility.getName(po.getWcmsccontent()));
		}
		
		if(!Utility.getName(po.getWcmscid()).equals("")){
			buffer.append("AND  W_CMS_C_ID = ? ");
			params.add(Utility.getName(po.getWcmscid()));
		}
		
		if(!Utility.getName(po.getWcmscflag()).equals("")){
			buffer.append("AND  W_CMS_C_Flag = ? ");
			params.add(Utility.getName(po.getWcmscflag()));
		}
		
		if(!Utility.getName(po.getWcmsctypeid()).equals("")){
			buffer.append("AND  W_CMS_C_TypeID = ? ");
			params.add(Utility.getName(po.getWcmsctypeid()));
		}
		
		buffer.append(" order by W_CMS_C_CreateDate desc");
		
		return queryForObjectList(buffer.toString(), params.toArray(), WeiXinCmsContentPo.class);
	}
	
	/**
	 * 获取几条文章的title，并以逗号分割返回
	 * @param ids
	 * @return
	 */
	public String getWeiXinCmsContentTitles(String ids){
		
		String[] id = ids.split("\\|");
		if(id.length == 3){
			ids=id[2];
		}

		StringBuffer buffer = new StringBuffer();
		if(ids.length()>0){
			ids = ids.replaceAll(",", "','");
		}

		buffer.append("SELECT Stuff((SELECT ',' + W_CMS_C_Title ");
		buffer.append("              FROM   W_CMS_Content ");
		buffer.append("              WHERE  W_CMS_C_ID IN ( '" + ids + "' ) ");
		buffer.append("              FOR XML PATH('')), 1, 1, '') ");
		
		return (String) getJdbcTemplate().queryForObject(buffer.toString(),null,String.class);
	}
}
