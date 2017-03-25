package com.pengsheng.weixin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinAutoReplyDao;
import com.pengsheng.weixin.persistence.WeiXinAutoReplyPo;

public class WeiXinAutoReplyDaoImpl extends BaseJdbcDaoSupport implements WeiXinAutoReplyDao{

	public void insertWeiXinAutoReply(WeiXinAutoReplyPo po) {
		StringBuffer sb = new StringBuffer();
		sb.append("insert W_AutoReply values(");
		sb.append("'"+ Utility.getName(po.getWartitlegz()) +"','"+ Utility.getName(po.getWartitlehf()) +"' ");
		sb.append(")");
		getJdbcTemplate().update(sb.toString());
	}

	public void deleteWeiXinAutoReply() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("delete from W_AutoReply ");
		
		getJdbcTemplate().update(sb.toString());
	}
	
	public WeiXinAutoReplyPo getWeiXinAutoReplyPo() {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT W_AR_Title_GZ              AS wartitlegz, ");
		sb.append("       W_AR_Title_HF            AS wartitlehf  ");
		sb.append("       FROM   W_AutoReply ");
		sb.append("       WHERE  1 = 1 ");
		
		return (WeiXinAutoReplyPo) queryForObject(sb.toString(), params.toArray(), WeiXinAutoReplyPo.class);
	}	
}
