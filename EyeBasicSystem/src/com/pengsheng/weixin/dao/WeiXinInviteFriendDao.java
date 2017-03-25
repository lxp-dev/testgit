package com.pengsheng.weixin.dao;

import java.util.List;
import com.pengsheng.weixin.persistence.WeixinInviteFriendLogPo;

public interface WeiXinInviteFriendDao {

	/**
	 * 获取邀请好友总记录数
	 * @param po
	 * @return
	 */
	public int selectWeiXinInviteFriendLogCount(WeixinInviteFriendLogPo po);
	
	/**
	 * 获取邀请好友总记录数
	 * @param po
	 */
	public List<WeixinInviteFriendLogPo> selectWeiXinInviteFriendLogList(WeixinInviteFriendLogPo po, int start, int size);
	
	/**
	 * 新增邀请好友
	 * @param po
	 * @return
	 */
	public void insertWeiXinInviteFriendLogPo(WeixinInviteFriendLogPo po);
	
	/**
	 * 修改邀请好友
	 * @param po
	 * @return
	 */
	public void updateWeiXinInviteFriendLog(WeixinInviteFriendLogPo po);
	
	/**
	 * 判断被邀请顾客是否赠送积分
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public WeixinInviteFriendLogPo selectWeiXinInviteFriendLogCheck(WeixinInviteFriendLogPo po);
}
