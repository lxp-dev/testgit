package com.pengsheng.eims.system.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.dao.MemberManagementDao;
import com.pengsheng.eims.system.mgr.MemberManagementMgr;
import com.pengsheng.eims.system.persistence.DiscountShortcutKeysDetailsPo;
import com.pengsheng.eims.system.persistence.MaxDiscountPo;
import com.pengsheng.eims.system.persistence.MemberManagementDiscountPo;
import com.pengsheng.eims.system.persistence.MemberManagementDiscountSetUpDetailsPo;
import com.pengsheng.eims.system.persistence.MemberManagementPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class MemberManagementMgrImpl extends BaseJdbcDaoSupport implements MemberManagementMgr {

	private MemberManagementDao memberManagementDao;
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public MemberManagementDao getMemberManagementDao() {
		return memberManagementDao;
	}

	public void setMemberManagementDao(MemberManagementDao memberManagementDao) {
		this.memberManagementDao = memberManagementDao;
	}

	public void insertMemberManagement(MemberManagementPo po,LogisticsLogPo logPo) {
		if (Utility.getName(po.getFmmsetdefault()).equals("1")){
			memberManagementDao.updateMemberManagementDefault(po);
		}
		memberManagementDao.insertMemberManagement(po);
		
		for(int i=1; i<10; i++){
			MemberManagementDiscountPo memberManagementDiscountPo = new MemberManagementDiscountPo();
			
			if(i==3 || i==4){
				//-------------------成品------------------------
				String id = this.uuid.generate();
				memberManagementDiscountPo.setFmdid(id);
				memberManagementDiscountPo.setFmdgoodscategoryid(i+"");
		        memberManagementDiscountPo.setFmdiscustomize("0");
		        memberManagementDiscountPo.setFmdsupplierid("");
		        memberManagementDiscountPo.setFmdbrandid("");
		        memberManagementDiscountPo.setFmdgoodsid("");
		        memberManagementDiscountPo.setFmdgoodsname("");
		        memberManagementDiscountPo.setFmddiscount(po.getFmmdiscount());
		        memberManagementDiscountPo.setFmdgoodscategoryname("");
		        memberManagementDiscountPo.setFmdsuppliername("");
		        memberManagementDiscountPo.setFmdbrandname("");
		        memberManagementDiscountPo.setFmdmembermanagementid(po.getFmmid());
		        
				memberManagementDao.insertMemberManagementDiscountSet(memberManagementDiscountPo);
				memberManagementDao.insertMemberManagementSetDefaultDiscount(memberManagementDiscountPo);	
				//-------------------成品------------------------
				//-------------------定制------------------------
				id = this.uuid.generate();
				memberManagementDiscountPo.setFmdid(id);
				memberManagementDiscountPo.setFmdgoodscategoryid(i+"");
		        memberManagementDiscountPo.setFmdiscustomize("D");
		        memberManagementDiscountPo.setFmdsupplierid("");
		        memberManagementDiscountPo.setFmdbrandid("");
		        memberManagementDiscountPo.setFmdgoodsid("");
		        memberManagementDiscountPo.setFmdgoodsname("");
		        memberManagementDiscountPo.setFmddiscount(po.getFmmdiscount());
		        memberManagementDiscountPo.setFmdgoodscategoryname("");
		        memberManagementDiscountPo.setFmdsuppliername("");
		        memberManagementDiscountPo.setFmdbrandname("");
		        memberManagementDiscountPo.setFmdmembermanagementid(po.getFmmid());
		        
				memberManagementDao.insertMemberManagementDiscountSet(memberManagementDiscountPo);
				memberManagementDao.insertMemberManagementSetDefaultDiscount(memberManagementDiscountPo);	
				//-------------------定制------------------------
			}else{
				String id = this.uuid.generate();
				memberManagementDiscountPo.setFmdid(id);
				memberManagementDiscountPo.setFmdgoodscategoryid(i+"");
		        memberManagementDiscountPo.setFmdiscustomize("");
		        memberManagementDiscountPo.setFmdsupplierid("");
		        memberManagementDiscountPo.setFmdbrandid("");
		        memberManagementDiscountPo.setFmdgoodsid("");
		        memberManagementDiscountPo.setFmdgoodsname("");
		        memberManagementDiscountPo.setFmddiscount(po.getFmmdiscount());
		        memberManagementDiscountPo.setFmdgoodscategoryname("");
		        memberManagementDiscountPo.setFmdsuppliername("");
		        memberManagementDiscountPo.setFmdbrandname("");
		        memberManagementDiscountPo.setFmdmembermanagementid(po.getFmmid());
		        
				memberManagementDao.insertMemberManagementDiscountSet(memberManagementDiscountPo);
				memberManagementDao.insertMemberManagementSetDefaultDiscount(memberManagementDiscountPo);			
			}
		}
		
		logisticsLogDao.insertLog(logPo);
	}
	
	public void updateMemberManagement(MemberManagementPo po,LogisticsLogPo logPo) {
		
		if (Utility.getName(po.getFmmsetdefault()).equals("1")){
			memberManagementDao.updateMemberManagementDefault(po);
		}
		memberManagementDao.updateMemberManagement(po);
		
		for(int i=1; i<10; i++){
			MemberManagementDiscountPo countpo = new MemberManagementDiscountPo();
			countpo.setFmdmembermanagementid(po.getFmmid());
			countpo.setFmdgoodscategoryid(i+"");
			int count = memberManagementDao.getMemberManagementDiscountCategoryCount(countpo);
			
			MemberManagementDiscountPo memberManagementDiscountPo = new MemberManagementDiscountPo();
			memberManagementDiscountPo.setFmdgoodscategoryid(i+"");
	        memberManagementDiscountPo.setFmdiscustomize("");
	        memberManagementDiscountPo.setFmdsupplierid("");
	        memberManagementDiscountPo.setFmdbrandid("");
	        memberManagementDiscountPo.setFmdgoodsid("");
	        memberManagementDiscountPo.setFmdgoodsname("");
	        memberManagementDiscountPo.setFmddiscount(po.getFmmdiscount());
	        memberManagementDiscountPo.setFmdgoodscategoryname("");
	        memberManagementDiscountPo.setFmdsuppliername("");
	        memberManagementDiscountPo.setFmdbrandname("");
	        memberManagementDiscountPo.setFmdmembermanagementid(po.getFmmid());
	        
			if(count > 0){
				if(po.getFmmisupdate().equals("1")){
					memberManagementDao.updateMemberManagementDiscount(memberManagementDiscountPo);
				}
			} else {
				memberManagementDao.insertMemberManagementDiscountSet(memberManagementDiscountPo);
			}
		}
		
		logisticsLogDao.insertLog(logPo);
	}
	
	public void deleteMemberManagement(MemberManagementPo po,LogisticsLogPo logPo) {
		
		memberManagementDao.deleteMemberManagement(po);
		
		MemberManagementDiscountPo discountPo = new MemberManagementDiscountPo();
		discountPo.setFmdmembermanagementid(po.getFmmid());
		
		memberManagementDao.deleteMemberManagementDiscountSet(discountPo);
		logisticsLogDao.insertLog(logPo);
	}
	
	public MemberManagementPo getMemberManagement(MemberManagementPo po) {
		
		return memberManagementDao.getMemberManagement(po);
	}
	
	public List<MemberManagementPo> getMemberManagementList() {
		
		return memberManagementDao.getMemberManagementList();
	}
	public int getMemberManagementName(MemberManagementPo po) 
	{
		return memberManagementDao.getMemberManagementName(po);
	}
	
	public int getMemberManagementNameUpdate(MemberManagementPo po) 
	{
		return memberManagementDao.getMemberManagementNameUpdate(po);
	}
	public int getMemberManagementCount(MemberManagementPo po) 
	{
		return memberManagementDao.getMemberManagementCount(po);
	}
	
	public List getMemberList(MemberManagementPo po, int start, int size) 
	{
		return memberManagementDao.getMemberList(po, start, size);
	}
	/**
	 * 查询最大折扣设置列表
	 */
	public List<MemberManagementDiscountPo> getMemberManagementDiscountSetList(MemberManagementDiscountPo po, int start, int size){
		return memberManagementDao.getMemberManagementDiscountSetList(po, start, size);
	}
/**
	 * 查询会员卡类型折扣设置总数
	 */
	public int getMemberManagementDiscountSetCount(MemberManagementDiscountPo po){
		return memberManagementDao.getMemberManagementDiscountSetCount(po);
	}
	/**
	 * 折扣编号是否存在
	 * 
	 */
	public int isExistMemberManagementDiscountSet(MemberManagementDiscountPo po){
		return memberManagementDao.isExistMemberManagementDiscountSet(po);
	}
	/**
	 * 增加折扣设置
	 * 
	 */
	public void insertMemberManagementDiscountSet(MemberManagementDiscountPo po,MemberManagementDiscountSetUpDetailsPo mpo){
		String id = this.uuid.generate();
		po.setFmdid(id);
		memberManagementDao.insertMemberManagementDiscountSet(po);
		if(mpo != null){
			for(int i=0; i<mpo.getFmddgoodslevels().length; i++){
				MemberManagementDiscountSetUpDetailsPo idpo = new MemberManagementDiscountSetUpDetailsPo();
				idpo.setFmddsetupid(id);
				idpo.setFmddgoodslevel(mpo.getFmddgoodslevels()[i]);
				idpo.setFmdddiscount(mpo.getFmdddiscounts()[i]);
				memberManagementDao.insertMemberManagementDiscountSetUpDetails(idpo);
			}
		}
	}
	
	/**
	 * 折扣设置详细
	 * 
	 */
	public MemberManagementDiscountPo getMemberManagementDiscountSetDetail(MemberManagementDiscountPo po){
		return memberManagementDao.getMemberManagementDiscountSetDetail(po);
	}
	/**
	 * 折扣设置修改
	 * 
	 */
	public void updateMemberManagementDiscount(MemberManagementDiscountPo po,MemberManagementDiscountSetUpDetailsPo mpo) {
		memberManagementDao.updateMemberManagementDiscount(po);
		
		memberManagementDao.deleteMemberManagementDiscountSetUpDetailss(po.getFmdid());
		
		if(mpo != null){
			for(int i=0; i<mpo.getFmddgoodslevels().length; i++){
				MemberManagementDiscountSetUpDetailsPo idpo = new MemberManagementDiscountSetUpDetailsPo();
				idpo.setFmddsetupid(po.getFmdid());
				idpo.setFmddgoodslevel(mpo.getFmddgoodslevels()[i]);
				idpo.setFmdddiscount(mpo.getFmdddiscounts()[i]);
				memberManagementDao.insertMemberManagementDiscountSetUpDetails(idpo);
			}
		}
	}
	/**
	 * 删除折扣设置
	 * 
	 */
	public void deleteMemberManagementDiscountSet(MemberManagementDiscountPo po){
		memberManagementDao.deleteMemberManagementDiscountSet(po);
	}
	public void updateBathMemberManagementDiscountSet(MemberManagementDiscountPo po){
		String[] ids = Utility.getName(po.getFmdid()).split(",");
		for (int i = 0; i < ids.length; i++){
			MemberManagementDiscountPo tmp = new MemberManagementDiscountPo();
			tmp.setFmdid(ids[i]);
			tmp.setFmddiscount(po.getFmddiscount());
			
			memberManagementDao.updateMemberManagementDiscountBatch(tmp);
		}
	}
	public void deleteBathMemberManagementDiscountSet(MemberManagementDiscountPo po){
		String[] ids = Utility.getName(po.getFmdid()).split(",");
		for (int i = 0; i < ids.length; i++){
			MemberManagementDiscountPo tmp = new MemberManagementDiscountPo();
			tmp.setFmdid(ids[i]);
			tmp.setFmddiscount(po.getFmddiscount());
			
			memberManagementDao.deleteMemberManagementDiscountSet(tmp);
		}
	}
	
	/**
	 * 会员卡类型是否使用
	 */
	public int isUseMemberManagement(MemberManagementPo po){
		return memberManagementDao.isUseMemberManagement(po);
	}
	
	/**
	 * 判断会员卡积分是否重复
	 */
	public int getMemberCardIntegralArea(MemberManagementPo po){
		return memberManagementDao.getMemberCardIntegralArea(po);
	}
	
	public void insertMemberManagementDiscountSetUpDetails(MemberManagementDiscountSetUpDetailsPo po){
		memberManagementDao.insertMemberManagementDiscountSetUpDetails(po);
	}
	
	public List<MemberManagementDiscountSetUpDetailsPo> selectMemberManagementDiscountSetUpDetails(MemberManagementDiscountSetUpDetailsPo po){
		return memberManagementDao.selectMemberManagementDiscountSetUpDetails(po);
	}
	
	public void deleteMemberManagementDiscountSetUpDetailss(String pid){
		memberManagementDao.deleteMemberManagementDiscountSetUpDetailss(pid);
	}
}
