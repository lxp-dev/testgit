package com.pengsheng.eims.member.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.member.dao.MemberUpGradeDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.UpgradeRecordPo;
import com.pengsheng.eims.system.persistence.MemberManagementPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class MemberUpGradeDaoImpl extends BaseJdbcDaoSupport implements MemberUpGradeDao {

	/**
	 * 查询会员卡升级信息数量
	 * @param customerInfoPo
	 * @return
	 */
	public int getMemberUpGradeCount(CustomerInfoPo customerInfoPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select  count(S_ME_CI_MemberId) ");
		buffer.append("from S_ME_CustomerInfo ");
		buffer.append("inner join F_MemberManagement on S_ME_CI_CardType = F_MM_ID ");
		buffer.append("where S_ME_CI_Integral  >= F_MM_UP and isnull(F_MM_UpgradeCard,'')<>'' ");
		
		if(!"".equals(Utility.getName(customerInfoPo.getSmecimemberid()))){
			buffer.append("and S_ME_CI_MemberId like '%' + ? ");
			params.add(customerInfoPo.getSmecimemberid());
		}
		
		if(!"".equals(Utility.getName(customerInfoPo.getSmeciname()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(customerInfoPo.getSmeciname());
		}
		
		if(!"".equals(Utility.getName(customerInfoPo.getSmecicardtype()))){
			buffer.append("and S_ME_CI_CardType = ? ");
			params.add(customerInfoPo.getSmecicardtype());
		}
		
		if (!"".equals(Utility.getName(customerInfoPo.getFmmup()))&& !"".equals(Utility.getName(customerInfoPo.getFmmdown()))) {
			buffer.append("and S_ME_CI_Integral  >= ? ");
			buffer.append("and S_ME_CI_Integral  <= ? ");

			params.add(customerInfoPo.getFmmup());
			params.add(customerInfoPo.getFmmdown());
		} else if (!"".equals(Utility.getName(customerInfoPo.getFmmup()))&& "".equals(Utility.getName(customerInfoPo.getFmmdown()))) {
			buffer.append("and S_ME_CI_Integral  >= ? ");

			params.add(customerInfoPo.getFmmup());
		} else if ("".equals(Utility.getName(customerInfoPo.getFmmup()))&& !"".equals(Utility.getName(customerInfoPo.getFmmdown()))) {
			buffer.append("and S_ME_CI_Integral  <= ? ");

			params.add(customerInfoPo.getFmmdown());
		}
		
		if(customerInfoPo.getSmecishoplist() != null && customerInfoPo.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = customerInfoPo.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 查询会员卡升级记录信息数量
	 * @param customerInfoPo
	 * @return
	 */
	public int getUpGradeRecordCount(UpgradeRecordPo po) {

		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select  count(S_ME_CU_ID) ");
		buffer.append("from S_ME_CustomerUpgrade ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CU_CustomerID = S_ME_CI_CustomerID ");
		buffer.append("inner join F_MemberManagement a on S_ME_CU_CurrentCardType = a.F_MM_ID ");
		buffer.append("inner join F_MemberManagement b on S_ME_CU_LastCardType = b.F_MM_ID ");		
		buffer.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getSmecumemberid()))){
			buffer.append("and S_ME_CU_MemberId like '%' + ? + '%' ");
			params.add(Utility.getName(po.getSmecumemberid()));
		}
		
		if(!"".equals(Utility.getName(po.getSmecucustomername()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getSmecucustomername()));
		}
		
		if(!"".equals(Utility.getName(po.getSmecubgnupgradedate()))){
			buffer.append("and convert(varchar(10),S_ME_CU_UpgradeDate,120) >= ? ");
			params.add(Utility.getName(po.getSmecubgnupgradedate()));
		}
		
		if(!"".equals(Utility.getName(po.getSmecuendupgradedate()))){
			buffer.append("and convert(varchar(10),S_ME_CU_UpgradeDate,120) <= ? ");
			params.add(Utility.getName(po.getSmecuendupgradedate()));
		}
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	/**
	 * 查询会员卡升级信息
	 * @param customerInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<CustomerInfoPo> selectMemberUpGrade(CustomerInfoPo customerInfoPo, int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by S_ME_CI_MemberId) as rowNum, ");
		
		buffer.append("S_ME_CI_MemberId as smecimemberid , S_ME_CI_CardType as smecicardtype , ");
		buffer.append("S_ME_CI_Integral as smeciintegral , S_ME_CI_Name as smeciname , ");
		buffer.append("S_ME_CI_Sex as smecisex , F_MM_MemberName as fmmmembername ");
		buffer.append("from S_ME_CustomerInfo ");
		buffer.append("inner join F_MemberManagement on S_ME_CI_CardType = F_MM_ID ");
		buffer.append("where S_ME_CI_Integral  >= F_MM_UP and isnull(F_MM_UpgradeCard,'')<>'' ");
		
		if(!"".equals(Utility.getName(customerInfoPo.getSmecimemberid()))){
			buffer.append("and S_ME_CI_MemberId like '%' + ? ");
			params.add(customerInfoPo.getSmecimemberid());
		}
		
		if(!"".equals(Utility.getName(customerInfoPo.getSmeciname()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(customerInfoPo.getSmeciname());
		}
		
		if(!"".equals(Utility.getName(customerInfoPo.getSmecicardtype()))){
			buffer.append("and S_ME_CI_CardType = ? ");
			params.add(customerInfoPo.getSmecicardtype());
		}
		
		if (!"".equals(Utility.getName(customerInfoPo.getFmmup()))&& !"".equals(Utility.getName(customerInfoPo.getFmmdown()))) {
			buffer.append("and S_ME_CI_Integral  >= ? ");
			buffer.append("and S_ME_CI_Integral  <= ? ");

			params.add(customerInfoPo.getFmmup());
			params.add(customerInfoPo.getFmmdown());
		} else if (!"".equals(Utility.getName(customerInfoPo.getFmmup()))&& "".equals(Utility.getName(customerInfoPo.getFmmdown()))) {
			buffer.append("and S_ME_CI_Integral  >= ? ");

			params.add(customerInfoPo.getFmmup());
		} else if ("".equals(Utility.getName(customerInfoPo.getFmmup()))&& !"".equals(Utility.getName(customerInfoPo.getFmmdown()))) {
			buffer.append("and S_ME_CI_Integral  <= ? ");

			params.add(customerInfoPo.getFmmdown());
		}
		
		if(customerInfoPo.getSmecishoplist() != null && customerInfoPo.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = customerInfoPo.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , CustomerInfoPo.class);
	}
	
	/**
	 * 会员自动升级
	 */
	public List<CustomerInfoPo> selectMemberUpGrade(CustomerInfoPo customerInfoPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append(" select S_ME_CI_MemberId as smecimemberid from S_ME_CustomerInfo ");
		buffer.append("  inner join F_MemberManagement on S_ME_CI_CardType = F_MM_ID ");
		buffer.append("  where S_ME_CI_Integral  >= F_MM_UP and isnull(F_MM_UpgradeCard,'')<>'' ");
		
		return queryForObjectList(buffer.toString() , params.toArray() , CustomerInfoPo.class);
	}

	/**
	 * 查询会员卡升级信息
	 * @param customerInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<UpgradeRecordPo> selectUpGradeRecordList(UpgradeRecordPo po, int start, int size) {

		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by S_ME_CU_UpgradeDate desc) as rowNum,S_ME_CU_ID as smecuid, ");
		
		buffer.append("S_ME_CU_MemberId as smecumemberid , S_ME_CU_IntegralChange as smecuintegralchange,");
		buffer.append("S_ME_CU_LastIntegral as smeculastintegral , S_ME_CI_Name as smecucustomername , ");
		buffer.append("b.F_MM_MemberName as smeculastcardname , a.F_MM_MemberName as smecucurrentcardname,convert(varchar(16),S_ME_CU_UpgradeDate,120) as smecuupgradedate ");
		buffer.append("from S_ME_CustomerUpgrade ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CU_CustomerID = S_ME_CI_CustomerID ");
		buffer.append("inner join F_MemberManagement a on S_ME_CU_CurrentCardType = a.F_MM_ID ");
		buffer.append("inner join F_MemberManagement b on S_ME_CU_LastCardType = b.F_MM_ID ");
		buffer.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getSmecumemberid()))){
			buffer.append("and S_ME_CU_MemberId like '%' + ? + '%' ");
			params.add(Utility.getName(po.getSmecumemberid()));
		}
		
		if(!"".equals(Utility.getName(po.getSmecucustomername()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getSmecucustomername()));
		}
		
		if(!"".equals(Utility.getName(po.getSmecubgnupgradedate()))){
			buffer.append("and convert(varchar(10),S_ME_CU_UpgradeDate,120) >= ? ");
			params.add(Utility.getName(po.getSmecubgnupgradedate()));
		}
		
		if(!"".equals(Utility.getName(po.getSmecuendupgradedate()))){
			buffer.append("and convert(varchar(10),S_ME_CU_UpgradeDate,120) <= ? ");
			params.add(Utility.getName(po.getSmecuendupgradedate()));
		}
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , UpgradeRecordPo.class);
	}
	
	/**
	 * 查询会员卡升级记录详细信息
	 * @param customerInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public UpgradeRecordPo getUpGradeRecordDetail(UpgradeRecordPo po){

		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
	
		buffer.append("select S_ME_CU_ID as smecuid,S_ME_CU_MemberId as smecumemberid , S_ME_CU_IntegralChange as smecuintegralchange,");
		buffer.append("S_ME_CU_LastIntegral as smeculastintegral , S_ME_CI_Name as smecucustomername , S_ME_CU_CurrentIntegral as smecucurrentintegral,");
		buffer.append("b.F_MM_MemberName as smeculastcardname , a.F_MM_MemberName as smecucurrentcardname,convert(varchar(16),S_ME_CU_UpgradeDate,120) as smecuupgradedate, ");
		buffer.append("d.B_DP_DepartmentName as smecushopcodename,c.personname as smecupersonname,S_ME_CU_Flag as smecuflag from S_ME_CustomerUpgrade ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CU_CustomerID = S_ME_CI_CustomerID ");
		buffer.append("left join F_MemberManagement a on S_ME_CU_CurrentCardType = a.F_MM_ID ");
		buffer.append("left join F_MemberManagement b on S_ME_CU_LastCardType = b.F_MM_ID ");
		buffer.append("left join SYS_PersonInfo c on S_ME_CU_Person = c.id ");
		buffer.append("left join B_Departments d on S_ME_CU_ShopCode = d.B_DP_DepartmentID ");
		buffer.append("where S_ME_CU_ID=? ");

		params.add(Utility.getName(po.getSmecuid()));
		
		return (UpgradeRecordPo)queryForObject(buffer.toString(), params.toArray(),UpgradeRecordPo.class);
	}
	
	/**
	 * 更新需要升级的会员卡
	 * @param customerInfoPo
	 */
	public void updateMemberUpGrade(UpgradeRecordPo po) {

		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("update S_ME_CustomerInfo set S_ME_CI_CardType=? where S_ME_CI_CustomerID=? ");
		
		params.add(Utility.getName(po.getSmeculastcardid()));
		params.add(Utility.getName(po.getSmecucustomerid()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 查询会员卡类型
	 * @param memberManagementPo
	 * @return
	 */
	public List<MemberManagementPo> getMemberManageMentList(
			MemberManagementPo memberManagementPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		
		buffer.append("select F_MM_ID as fmmid , ");
		buffer.append("F_MM_MemberName as fmmmembername ");
		buffer.append("from F_MemberManagement ");
		
		return queryForObjectList(buffer.toString() , null , MemberManagementPo.class);
	}

	/**
	 * 新增会员卡升级记录
	 * 
	 * @param customerInfoPo
	 */
	public void insertUpGradeRecord(UpgradeRecordPo po){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into S_ME_CustomerUpgrade(S_ME_CU_ID,S_ME_CU_CustomerID,S_ME_CU_MemberId,S_ME_CU_UpgradeDate,S_ME_CU_CurrentCardType,S_ME_CU_CurrentIntegral, ");
		buffer.append("S_ME_CU_LastCardType,S_ME_CU_IntegralChange,S_ME_CU_LastIntegral,S_ME_CU_ShopCode,S_ME_CU_Person,S_ME_CU_Flag) ");
		buffer.append(" values(?,?,?,getdate(),?,?,?,?,?,?,?,?) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getSmecucustomerid()));
		params.add(Utility.getName(po.getSmecumemberid()));
		params.add(Utility.getName(po.getSmecucurrentcardid()));
		params.add(Utility.getName(po.getSmecucurrentintegral()));
		params.add(Utility.getName(po.getSmeculastcardid()));
		params.add(Utility.getName(po.getSmecuintegralchange()));		
		params.add(Utility.getName(po.getSmeculastintegral()));
		params.add(Utility.getName(po.getSmecushopcode()));
		params.add(Utility.getName(po.getSmecupersonid()));
		params.add(Utility.getName(po.getSmecuflag()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	/**
	 * 查询会员信息
	 * 
	 * @param customerInfoPo
	 */
	public CustomerInfoPo selectCustomerInfo(CustomerInfoPo po){

		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
	
		buffer.append("select top 1 S_ME_CI_CustomerID as smecicustomerid,S_ME_CI_MemberId as smecimemberid,S_ME_CI_CardType as smecicardtype,S_ME_CI_Integral as smeciintegral ");
		buffer.append(" from S_ME_CustomerInfo ");
		buffer.append("where S_ME_CI_CustomerID=? ");

		params.add(Utility.getName(po.getSmecicustomerid()));
		
		return (CustomerInfoPo)queryForObject(buffer.toString(), params.toArray(),CustomerInfoPo.class);
	}
	
	/**
	 * 查询会员卡升级后的会员卡类型和扣除积分
	 * 
	 * @param customerInfoPo
	 */
	public CustomerInfoPo selectUpgradeCardInfo(CustomerInfoPo po){

		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
	
		buffer.append("select top 1 F_MM_UpgradeCard as smecicardtype,isnull(F_MM_Integral,'0') as smeciintegral from F_MemberManagement where F_MM_ID=? ");

		params.add(Utility.getName(po.getSmecicardtype()));
		
		return (CustomerInfoPo)queryForObject(buffer.toString(), params.toArray(),CustomerInfoPo.class);
	}
	
	/**
	 * 更新会员积分
	 * 
	 * @param po
	 */
	public void updateCustomerInfo(UpgradeRecordPo po){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("update top (1) S_ME_CustomerInfo set S_ME_CI_Integral=? where S_ME_CI_CustomerID=? ");
		
		params.add(Utility.getName(po.getSmeculastintegral()));
		params.add(Utility.getName(po.getSmecucustomerid()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	/**
	 * 会员卡直接升级
	 */
	public void updateMemberCardTypeUpGrade(CustomerInfoPo po){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("update top (1) S_ME_CustomerInfo set S_ME_CI_CardType=? where S_ME_CI_CustomerID=? ");		
		
		params.add(Utility.getName(po.getSmecicardtype()));
		params.add(Utility.getName(po.getSmecicustomerid()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
}
