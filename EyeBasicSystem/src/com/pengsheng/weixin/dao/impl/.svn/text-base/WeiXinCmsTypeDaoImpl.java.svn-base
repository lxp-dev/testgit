package com.pengsheng.weixin.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinCmsTypeDao;
import com.pengsheng.weixin.persistence.WeiXinCmsTypePo;

public class WeiXinCmsTypeDaoImpl extends BaseJdbcDaoSupport implements WeiXinCmsTypeDao{

	public void deleteWeiXinCmsType(WeiXinCmsTypePo po) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("DELETE FROM W_CMS_Type ");
		sb.append("WHERE  W_CMS_T_ID = '"+ Utility.getName(po.getWcmstid()) +"' ");
		
		getJdbcTemplate().update(sb.toString());
	}

	public void insertWeiXinCmsType(WeiXinCmsTypePo po) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("INSERT INTO W_CMS_Type ");
		sb.append("            (W_CMS_T_ID, ");
		sb.append("             W_CMS_T_Name, ");
		sb.append("             W_CMS_T_CreateDate) ");
		sb.append("VALUES      ('"+ this.uuid.generate() +"', ");
		sb.append("             '"+ Utility.getName(po.getWcmstname()) +"', ");
		sb.append("             getdate()) ");
		
		getJdbcTemplate().update(sb.toString());
	}

	public int selectWeiXinCmsTypeCount(WeiXinCmsTypePo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT COUNT(W_CMS_T_ID) ");
		sb.append("FROM   W_CMS_Type ");
		sb.append("WHERE  1 = 1 ");
		
		if(!"".equals(Utility.getName(po.getWcmstid()))) {
			sb.append("       AND W_CMS_T_ID=? ");
			params.add(Utility.getName(po.getWcmstid()));
		}
		
		if(!"".equals(Utility.getName(po.getWcmstname()))) {
			sb.append("       AND W_CMS_T_Name LIKE '%' + ? + '%' ");
			params.add(Utility.getName(po.getWcmstname()));
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	public List<WeiXinCmsTypePo> selectWeiXinCmsTypes(
			WeiXinCmsTypePo po, int start, int size) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		
		sb.append("SET ROWCOUNT " + countPage + " ");
		
		sb.append("SELECT * ");
		sb.append("FROM   (SELECT Row_number() OVER(ORDER BY W_CMS_T_ID) AS rownum, ");
		sb.append("               W_CMS_T_ID                             AS wcmstid, ");
		sb.append("               W_CMS_T_Name                           AS wcmstname, ");
		sb.append("               W_CMS_T_CreateDate                     AS wcmstcreatedate ");
		sb.append("        FROM   W_CMS_Type ");
		sb.append("        WHERE  1 = 1 ");

		if(!"".equals(Utility.getName(po.getWcmstname()))) {
			sb.append("               AND W_CMS_T_Name LIKE '%' + ? + '%' ");
			params.add(Utility.getName(po.getWcmstname()));
		}
		
		sb.append(") t1 WHERE rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" SET ROWCOUNT 0 ");
		
		return queryForObjectList(sb.toString(), params.toArray(), WeiXinCmsTypePo.class);
	}

	public void updateWeiXinCmsType(WeiXinCmsTypePo po) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("UPDATE W_CMS_Type ");
		sb.append("SET    W_CMS_T_Name = '"+ Utility.getName(po.getWcmstname()) +"', ");
		sb.append("       W_CMS_T_CreateDate = getdate() ");
		sb.append("WHERE  W_CMS_T_ID = '"+ Utility.getName(po.getWcmstid()) +"' ");
		
		getJdbcTemplate().update(sb.toString());
	}

	public List<WeiXinCmsTypePo> getWeiXinCmsTypeList(
			WeiXinCmsTypePo po) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT W_CMS_T_ID              AS wcmstid, ");
		sb.append("       W_CMS_T_Name            AS wcmstname, ");
		sb.append("       W_CMS_T_CreateDate      AS wcmstcreatedate ");
		sb.append("       FROM   W_CMS_Type ");
		sb.append("       WHERE  1 = 1 ");
		
		if(!"".equals(Utility.getName(po.getWcmstid()))) {
			sb.append("               AND W_CMS_T_ID =? ");
			params.add(Utility.getName(po.getWcmstid()));
		}

		if(!"".equals(Utility.getName(po.getWcmstname()))) {
			sb.append("               AND W_CMS_T_Name LIKE '%' + ? + '%' ");
			params.add(Utility.getName(po.getWcmstname()));
		}
		
		return queryForObjectList(sb.toString(), params.toArray(), WeiXinCmsTypePo.class);
	}

	public WeiXinCmsTypePo getWeiXinCmsTypePo(WeiXinCmsTypePo po) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT top 1 W_CMS_T_ID              AS wcmstid, ");
		sb.append("       W_CMS_T_Name            AS wcmstname, ");
		sb.append("       W_CMS_T_CreateDate      AS wcmstcreatedate ");
		sb.append("       FROM   W_CMS_Type ");
		sb.append("       WHERE  1 = 1 ");
		
		if(!"".equals(Utility.getName(po.getWcmstid()))) {
			sb.append("               AND W_CMS_T_ID =? ");
			
			String[] id = po.getWcmstid().split("\\|");
			if(id.length == 3){
				po.setWcmstid(id[2]);
			}
			
			params.add(Utility.getName(po.getWcmstid()));
		}

		if(!"".equals(Utility.getName(po.getWcmstname()))) {
			sb.append("               AND W_CMS_T_Name LIKE '%' + ? + '%' ");
			params.add(Utility.getName(po.getWcmstname()));
		}
		
		return (WeiXinCmsTypePo) queryForObject(sb.toString(), params.toArray(), WeiXinCmsTypePo.class);
	}	
}
