package com.pengsheng.eims.personnel.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.dao.PostDao;
import com.pengsheng.eims.personnel.mgr.PostMgr;
import com.pengsheng.eims.personnel.persistence.PostPo;

public class PostMgrImpl implements PostMgr{
	
	private PostDao postDao;
    private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
	
	public List<PostPo> getPostMaxList()
	{
		return this.postDao.getPostMaxList();
	}
	
	
	public List<PostPo> getPostList(PostPo po,int start, int size)
	{
		return this.postDao.getPostList(po, start, size);
	}
	
	public int getPostCount(PostPo po)  
	{
		return this.postDao.getPostCount(po);
	}


	public List<PostPo> getPostMinList(
			PostPo postPo) {
		return this.postDao.getPostMinList(postPo);
	}


	public PostPo getPost(
			PostPo postPo) {
		PostPo result = new PostPo();
		result = this.postDao.getPost(postPo);
		if(!result.getMptparented().equals("")){
			PostPo tmp = new PostPo();
			tmp.setMptid(result.getMptparented());
			result.setMptparentedname(this.postDao.getPost(tmp).getMptcontent());
		}
		return result;
	}
	
	public void insertPost(
			PostPo postPo,LogisticsLogPo logPo) {
		this.postDao.insertPost(postPo);
		logisticsLogDao.insertLog(logPo);
	}

	public void updatePost(
			PostPo postPo,LogisticsLogPo logPo) {
		this.postDao.updatePost(postPo);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 添加时判断职称名称 是否重复
	 * @return
	 */
	public int getPostName(PostPo postPo)
	{
		return postDao.getPostName(postPo);
	}
	/**
	 * 修改时判断职称名称 是否重复
	 * @return
	 */
	public int getPostNameUpdate(PostPo postPo) 
	{
		return postDao.getPostNameUpdate(postPo);
	}
		
	public void deletePost(
			PostPo postPo,LogisticsLogPo logPo) {
		this.postDao.deletePost(postPo);
		logisticsLogDao.insertLog(logPo);
	}
	
	public PostDao getPostDao() {
		return postDao;
	}

	public void setPostDao(
			PostDao postDao) {
		this.postDao = postDao;
	}

	public int getBeUsed(PostPo postPo) {
		// TODO Auto-generated method stub
		return postDao.getBeUsed(postPo);
	}
}
