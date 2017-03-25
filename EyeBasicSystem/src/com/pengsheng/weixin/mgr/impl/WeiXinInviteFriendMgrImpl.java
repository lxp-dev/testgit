package com.pengsheng.weixin.mgr.impl;

import java.util.List;

import com.pengsheng.weixin.dao.WeiXinInviteFriendDao;
import com.pengsheng.weixin.mgr.WeiXinInviteFriendMgr;
import com.pengsheng.weixin.persistence.WeixinInviteFriendLogPo;

public class WeiXinInviteFriendMgrImpl implements WeiXinInviteFriendMgr {
	
	private WeiXinInviteFriendDao weiXinInviteFriendDao;

	public WeiXinInviteFriendDao getWeiXinInviteFriendDao() {
		return weiXinInviteFriendDao;
	}

	public void setWeiXinInviteFriendDao(WeiXinInviteFriendDao weiXinInviteFriendDao) {
		this.weiXinInviteFriendDao = weiXinInviteFriendDao;
	}

	public void insertWeiXinInviteFriendLogPo(WeixinInviteFriendLogPo po) {
		weiXinInviteFriendDao.insertWeiXinInviteFriendLogPo(po);
	}

	public int selectWeiXinInviteFriendLogCount(WeixinInviteFriendLogPo po) {
		return weiXinInviteFriendDao.selectWeiXinInviteFriendLogCount(po);
	}

	public List<WeixinInviteFriendLogPo> selectWeiXinInviteFriendLogList(
			WeixinInviteFriendLogPo po, int start, int size) {
		return weiXinInviteFriendDao.selectWeiXinInviteFriendLogList(po, start, size);
	}

	public void updateWeiXinInviteFriendLog(WeixinInviteFriendLogPo po) {
		weiXinInviteFriendDao.updateWeiXinInviteFriendLog(po);
	}	
}
