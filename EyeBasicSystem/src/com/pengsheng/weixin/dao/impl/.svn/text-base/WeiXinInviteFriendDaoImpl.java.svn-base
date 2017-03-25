package com.pengsheng.weixin.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinInviteFriendDao;
import com.pengsheng.weixin.persistence.WeiXinLuckDrawPo;
import com.pengsheng.weixin.persistence.WeixinInviteFriendLogPo;

public class WeiXinInviteFriendDaoImpl extends BaseJdbcDaoSupport implements WeiXinInviteFriendDao{

	public void updateWeiXinInviteFriendLog(WeixinInviteFriendLogPo po) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("UPDATE W_InviteFriend_Log ");
		sb.append("SET    W_IF_L_IsConfirm = '"+ Utility.getName(po.getWiflisconfirm()) +"' ");

		sb.append("WHERE  W_IF_L_ID = '"+ Utility.getName(po.getWiflid()) +"' ");
		
		getJdbcTemplate().update(sb.toString());
	}

	public void insertWeiXinInviteFriendLogPo(WeixinInviteFriendLogPo po) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("INSERT INTO W_InviteFriend_Log ");
		sb.append("            (W_IF_L_ID, ");
		sb.append("             W_IF_L_CustomerId, ");
		sb.append("             W_IF_L_ToUserPhone, ");
		sb.append("             W_IF_L_ToUserName, ");
		sb.append("             W_IF_L_CreateTime, ");
		sb.append("             W_IF_L_IsConfirm) ");
		sb.append("VALUES      ('"+ this.uuid.generate() +"', ");
		sb.append("             '"+ Utility.getName(po.getWiflcustomerid()) +"', ");
		sb.append("             '"+ Utility.getName(po.getWifltouserphone()) +"', ");
		sb.append("             '"+ Utility.getName(po.getWifltousername()) +"', ");
		sb.append("             getdate(), ");
		sb.append("             '"+ Utility.getName(po.getWiflisconfirm()) +"') ");
		
		getJdbcTemplate().update(sb.toString());
	}

	public int selectWeiXinInviteFriendLogCount(WeixinInviteFriendLogPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT COUNT(W_IF_L_ID) ");
		sb.append("FROM   W_InviteFriend_Log ");
		sb.append("WHERE  1 = 1 ");
		
		if(!"".equals(Utility.getName(po.getWifltouserphone()))) {
			sb.append("       AND W_IF_L_ToUserPhone=? ");
			params.add(Utility.getName(po.getWifltouserphone()));
		}
		
		if(!"".equals(Utility.getName(po.getWifltousername()))) {
			sb.append("       AND W_IF_L_ToUserName LIKE '%' + ? + '%' ");
			params.add(Utility.getName(po.getWifltousername()));
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	public List<WeixinInviteFriendLogPo> selectWeiXinInviteFriendLogList(
			WeixinInviteFriendLogPo po, int start, int size) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		
		sb.append("SET ROWCOUNT " + countPage + " ");
		
		sb.append("SELECT * ");
		sb.append("FROM   (SELECT Row_number() OVER(ORDER BY W_IF_L_ID) AS rownum, ");
		sb.append("               W_IF_L_ID                             	AS wiflid, ");
		sb.append("               W_IF_L_CustomerId                         AS wiflcustomerid, ");
		sb.append("               S_ME_CustomerInfo.S_ME_CI_Name            AS wiflcustomername, ");
		sb.append("               W_IF_L_ToUserPhone                        AS wifltouserphone, ");
		sb.append("               W_IF_L_ToUserName                         AS wifltousername, ");
		sb.append("               W_IF_L_CreateTime                         AS wiflcreatetime, ");
		sb.append("               isnull(W_IF_L_IsConfirm,'0')              AS wiflisconfirm ");
		sb.append("        FROM   W_InviteFriend_Log ");
		sb.append("        left join S_ME_CustomerInfo on S_ME_CI_CustomerID = W_IF_L_CustomerId ");
		sb.append("        WHERE  1 = 1 ");

		if(!"".equals(Utility.getName(po.getWifltouserphone()))) {
			sb.append("       AND W_IF_L_ToUserPhone=? ");
			params.add(Utility.getName(po.getWifltouserphone()));
		}
		
		if(!"".equals(Utility.getName(po.getWifltousername()))) {
			sb.append("       AND W_IF_L_ToUserName LIKE '%' + ? + '%' ");
			params.add(Utility.getName(po.getWifltousername()));
		}
		
		sb.append(") t1 WHERE rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" order by wiflcreatetime desc ");
		sb.append(" SET ROWCOUNT 0 ");
		
		return queryForObjectList(sb.toString(), params.toArray(), WeixinInviteFriendLogPo.class);
	}	
	
	/**
	 * 判断被邀请顾客是否赠送积分
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public WeixinInviteFriendLogPo selectWeiXinInviteFriendLogCheck(WeixinInviteFriendLogPo po) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT ");
		sb.append("		W_IF_L_ID				as wiflid,");
		sb.append("		W_IF_L_CustomerId		as wiflcustomerid,");
		sb.append("		W_IF_L_ToUserPhone		as wifltouserphone,");
		sb.append("		W_IF_L_ToUserName		as wifltousername,");
		sb.append("		W_IF_L_CreateTime		as wiflcreatetime,");
		sb.append("		W_IF_L_IsConfirm		as wiflisconfirm ");
		sb.append("FROM   W_InviteFriend_Log ");
		sb.append("WHERE 1=1 ");
		if("".equals(Utility.getName(po.getWiflisconfirm()))){
			sb.append("  AND W_IF_L_IsConfirm <> '1' ");
		}else{
			sb.append("  AND W_IF_L_IsConfirm = '1' ");
		}
		
		sb.append("  AND W_IF_L_ToUserPhone = ? ");
		params.add(Utility.getName(po.getWifltouserphone()));
//		sb.append("  AND W_IF_L_ToUserName = ? ");
//		params.add(Utility.getName(po.getWifltousername()));
		
		return (WeixinInviteFriendLogPo)queryForObject(sb.toString(), params.toArray(), WeixinInviteFriendLogPo.class);
	}	
}
