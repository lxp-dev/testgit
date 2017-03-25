package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.MemberOriginPo;

public interface MemberOriginDao {
	/**
	 * 新增会员来源
	 * @param po
	 */
	public void insertMemberOriginPo(MemberOriginPo po);
	
	/**
	 * 更新会员来源
	 * @param po
	 */
	public void updateMemberOriginPo(MemberOriginPo po);
	
	/**
	 * 删除会员来源
	 * @param po
	 */
	public void deleteMemberOriginPo(MemberOriginPo po);
	
	/**
	 * 查询会员Po
	 * @param po
	 * @return
	 */
	public MemberOriginPo selectMemberOriginPo(MemberOriginPo po);
	
	
	/**
	 * 查询会员List
	 * @param po
	 * @return
	 */
	public List<MemberOriginPo> selectMemberOriginList();
	/**
	 * 查询会员数量
	 * @param po
	 * @return
	 */
	public int getMemberOriginsCount();
	/**
	 * 查询会员List
	 * @param po
	 * @return
	 */
	public List<MemberOriginPo> getMemberOriginsList(int start, int size) ;
	/**
	 * 查询会员count
	 * @param po
	 * @return
	 */
	public int selectMemberOriginCount(MemberOriginPo po);
	/**
	 * 添加时查询来源名称是否重复
	 * @param po
	 * @return
	 */
	public int selectMemberOriginName(MemberOriginPo po);
	/**
	 * 修改时时查询来源名称是否重复
	 * @param po
	 * @return
	 */
	public int selectMemberOriginNameUpdate(MemberOriginPo po);
}
