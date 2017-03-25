package com.pengsheng.eims.bjtrhistory.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.pengsheng.eims.bjtrhistory.dao.MydriasisBjtrDao;
import com.pengsheng.eims.bjtrhistory.persistence.MydriasisPo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;
import com.pengsheng.eims.system.persistence.RegisteredPrintDetailsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class MydriasisBjtrDaoImpl extends BaseJdbcDaoSupport implements
		MydriasisBjtrDao {

	public int getMydriasisCount(MydriasisPo po) {

		StringBuffer sb = new StringBuffer();
		sb
				.append("select count(S_ME_CustomerInfo.S_ME_CI_CustomerID) from S_OP_Mydriasis ");
		sb
				.append("inner join S_ME_CustomerInfo on S_OP_Mydriasis.S_OP_MD_FCustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		sb.append("where 1=1 ");
		if (!"".equals(Utility.getName(po.getSopmdcustomername()))) {
			sb.append("and S_ME_CI_Name like '%" + po.getSopmdcustomername()
					+ "%' ");
		}
		if (!"".equals(Utility.getName(po.getSopmdcustomerpostcode()))) {
			sb.append("and S_ME_CI_MemberId like'%" + po.getSopmdcustomerpostcode()
					+ "%' ");//quyanping
		}
		if(!"".equals(Utility.getName(po.getSopmdendTime()))){
			sb.append("and convert(varchar(10) , s_op_md_visiontime , 23) <= '" + po.getSopmdendTime()+"' ");
		}
		
		if(!"".equals(Utility.getName(po.getSopmdstartTime()))){
			sb.append("and convert(varchar(10) , s_op_md_visiontime , 23) >= '" + po.getSopmdstartTime()+"' ");
		}
		
		

		return getJdbcTemplate().queryForInt(sb.toString());
	}

	public List<MydriasisPo> getMydriasisList(MydriasisPo po, int start,
			int size) {

		StringBuffer sb = new StringBuffer();

		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select *");
		sb
				.append(" from(select ROW_NUMBER() Over(order by S_OP_Mydriasis.S_OP_MD_VisionTime desc) as rowNum,");
		sb
				.append("S_ME_CustomerInfo.S_ME_CI_CustomerID as sopmdfcustomerid,S_ME_CustomerInfo.S_ME_CI_MemberId as sopmdcustomerpostcode,");
		sb
				.append("S_ME_CustomerInfo.S_ME_CI_Name as sopmdcustomername,S_ME_CustomerInfo.S_ME_CI_Sex as sopmdcustomersex,");
		sb
				.append("year(getdate()) - year(S_ME_CustomerInfo.S_ME_CI_Birthday) as sopmdcustomerage,S_OP_Mydriasis.S_OP_MD_ID as sopmdid,");
		sb
				.append("S_ME_CustomerInfo.S_ME_CI_Phone as sopmdcustomerphone,S_OP_MD_VisionTime as sopmdvisiontime from S_OP_Mydriasis ");
		sb
				.append("inner join S_ME_CustomerInfo on S_OP_Mydriasis.S_OP_MD_FCustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		sb.append("where 1=1 ");
		if (!"".equals(Utility.getName(po.getSopmdcustomername()))) {
			sb.append(" and S_ME_CI_Name like '%" + po.getSopmdcustomername()
					+ "%' ");
		}
		if (!"".equals(Utility.getName(po.getSopmdcustomerpostcode()))) {
			sb.append(" and S_ME_CI_MemberId like'%" + po.getSopmdcustomerpostcode()
					+ "%' ");//quyanping
		}
		if(!"".equals(Utility.getName(po.getSopmdendTime()))){
			sb.append(" and convert(varchar(10) , s_op_md_visiontime , 23) <= '" + po.getSopmdendTime()+"' ");
		}
		
		if(!"".equals(Utility.getName(po.getSopmdstartTime()))){
			sb.append(" and convert(varchar(10) , s_op_md_visiontime , 23) >= '" + po.getSopmdstartTime()+"' ");
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), null, MydriasisPo.class);
	}

	public void insertMydriasis(MydriasisPo po) {

		StringBuffer sb = new StringBuffer();

		sb
				.append("insert into S_OP_Mydriasis(S_OP_MD_ID,S_OP_MD_FCustomerID,S_OP_MD_ShopCode,S_OP_MD_FamilyHistory");
		sb
				.append(",S_OP_MD_GeneralInspection,S_OP_MD_FundusInspection,S_OP_MD_FIop,S_OP_MD_Anaesthetic");
		sb
				.append(",S_OP_MD_RightGlassesVision,S_OP_MD_LeftGlassesVision,S_OP_MD_RightNakedVision,S_OP_MD_LeftNakedVision");
		sb
				.append(",S_OP_MD_RightNearVision,S_OP_MD_LeftNearVision,S_OP_MD_MydriasisPersonID,S_OP_MD_VisionTime,S_OP_MD_OptType,S_OP_MD_SubmitExpenseID)");
		sb.append("values('" + this.uuid.generate() + "','"
				+ po.getSopmdfcustomerid() + "','" + po.getSopmdshopcode()
				+ "','" + po.getSopmdfamilyhistory() + "'");
		sb.append(",'" + po.getSopmdgeneralinspection() + "','"
				+ po.getSopmdfundusinspection() + "','" + po.getSopmdfiop()
				+ "','" + po.getSopmdanaesthetic() + "'");
		sb.append(",'" + po.getSopmdrightglassesvision() + "','"
				+ po.getSopmdleftglassesvision() + "','"
				+ po.getSopmdrightnakedvision() + "','"
				+ po.getSopmdleftnakedvision() + "'");
		sb.append(",'" + po.getSopmdrightnearvision() + "','"
				+ po.getSopmdleftnearvision() + "','"
				+ po.getSopmdmydriasispersonid() + "',getdate(),'"+po.getSopmdopttype()+"','"+po.getSopmdsubmitexpenseid()+"')");

		getJdbcTemplate().update(sb.toString());
	}

	public MydriasisPo getMydriasis(MydriasisPo po) {

		StringBuffer sb = new StringBuffer();
		sb
				.append("select top 1  S_ME_CustomerInfo.S_ME_CI_CustomerID as sopmdfcustomerid,S_OP_Mydriasis.S_OP_MD_ID as sopmdid ");
		sb
				.append(",S_ME_CustomerInfo.S_ME_CI_MemberId as sopmdcustomerpostcode,S_ME_CustomerInfo.S_ME_CI_Name as sopmdcustomername");
		sb
				.append(",S_OP_Mydriasis.S_OP_MD_FamilyHistory as sopmdfamilyhistory,S_OP_Mydriasis.S_OP_MD_GeneralInspection as sopmdgeneralinspection");
		sb
				.append(",S_OP_Mydriasis.S_OP_MD_FundusInspection as sopmdfundusinspection,S_OP_Mydriasis.S_OP_MD_FIop as sopmdfiop");
		sb
				.append(",S_OP_Mydriasis.S_OP_MD_Anaesthetic as sopmdanaesthetic,S_OP_Mydriasis.S_OP_MD_RightGlassesVision as sopmdrightglassesvision");
		sb
				.append(",S_OP_Mydriasis.S_OP_MD_LeftGlassesVision as sopmdleftglassesvision,S_OP_Mydriasis.S_OP_MD_RightNakedVision as sopmdrightnakedvision");
		sb
				.append(",S_OP_Mydriasis.S_OP_MD_LeftNakedVision as sopmdleftnakedvision,S_OP_Mydriasis.S_OP_MD_RightNearVision as sopmdrightnearvision");
		sb
				.append(",S_OP_Mydriasis.S_OP_MD_LeftNearVision as sopmdleftnearvision,S_OP_Mydriasis.S_OP_MD_MydriasisPersonID as sopmdmydriasispersonid");
		sb
				.append(",SYS_PersonInfo.personName as sopmdmydriasispersonname,S_OP_MD_VisionTime as sopmdvisiontime ");
		sb.append(",S_OP_MD_OptType as sopmdopttype,S_OP_MD_SubmitExpenseID as sopmdsubmitexpenseid ");
		sb.append("from S_OP_Mydriasis ");
		sb
				.append("inner join S_ME_CustomerInfo on S_OP_Mydriasis.S_OP_MD_FCustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		sb
				.append("inner join SYS_PersonInfo on S_OP_Mydriasis.S_OP_MD_MydriasisPersonID=SYS_PersonInfo.ID ");
		sb.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getSopmdfcustomerid()))){
			sb.append(" and S_ME_CustomerInfo.S_ME_CI_CustomerID='"+po.getSopmdfcustomerid()+"' ");
		}
		
		if(!"".equals(Utility.getName(po.getSopmdid()))){
			sb.append(" and S_OP_MD_ID='"+po.getSopmdid()+"' ");
		}
		
		if(!"".equals(Utility.getName(po.getSopmdmemberid()))){
			sb.append(" and S_ME_CustomerInfo.S_ME_CI_MemberId='"+po.getSopmdmemberid()+"' ");
		}
		
		sb.append(" order by S_OP_Mydriasis.S_OP_MD_VisionTime desc ");
		return (MydriasisPo) queryForObject(sb.toString(), null,
				MydriasisPo.class);
	}

	/**
	 * 根据条件查询
	 * 
	 * @param po
	 * @return
	 */
	public RegisteredCategoryPo getChargePut(RegisteredCategoryPo po) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询费用提交数量
	 * 
	 * @param po
	 * @return
	 */
	public int getChargePutCount(RegisteredCategoryPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select count(F_RC_Money) from F_RegisteredCategory ");
		sb.append("where F_RC_Flag='1' ");

		if (!"".equals(Utility.getName(po.getFrcfeetype()))) {
			sb.append(" and F_RC_FeeType=? ");
			params.add(po.getFrcfeetype());
		}
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 显示费用提交信息并分页
	 * 
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<RegisteredCategoryPo> getChargePutList(RegisteredCategoryPo po,
			int start, int size) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select F_RC_ID as frcid, F_RC_RegisteredName as frcregisteredname,F_RC_Money as frcmoney from ");
		sb.append("(select ROW_NUMBER() Over(order by F_RegisteredCategory.F_RC_orderType) as rowNum, ");
		sb.append("F_RC_ID ,");
		sb.append("F_RC_RegisteredName ,");
		sb.append("F_RC_Money ");
		sb.append("from F_RegisteredCategory  where F_RC_Flag='1' AND F_RC_AmountType = '1' ");

		if (!"".equals(Utility.getName(po.getFrcfeetype()))) {
			sb.append(" and F_RC_FeeType=? ");
			params.add(po.getFrcfeetype());
		}
		sb.append(" )temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(),
				RegisteredCategoryPo.class);
	}

	/**
	 * 修改费用提交
	 * 
	 * @param po
	 */
	public void updateRegisteredCategory(RegisteredCategoryPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("update F_RegisteredCategory set ");
		sb.append(" F_RC_Money= ? ");
		params.add(po.getFrcmoney());
		sb.append(" where F_RC_ID= ? ");
		params.add(po.getFrcid());
		getJdbcTemplate().update(sb.toString(), params.toArray());

	}

	/**
	 * 修改挂号明细表
	 * 
	 * @param po
	 */
	public void urpateRegisteredPrintDetails(RegisteredPrintDetailsPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("update F_RegisteredPrintDetails set ");

		sb.append("F_RPD_Price= ? ");
		params.add(po.getFrpdprice());
		sb.append("where F_RPD_ID= ? ");
		params.add(po.getFrpdid());
		getJdbcTemplate().update(sb.toString(), params.toArray());

	}

	/**
	 * 新增挂号明细表信息
	 * 
	 * @param po
	 */
	public void insertRegisteredDetails(RegisteredDetailsPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("insert into S_CR_RegisteredDetails ");
		
		sb.append("(S_CR_RD_ID,");
		sb.append("S_CR_RD_DetailsID,");
		sb.append("S_CR_RD_CustomerID,");
		sb.append("S_CR_RD_ShopCode,");
		sb.append("S_CR_RD_RegisteredID,");
		sb.append("S_CR_RD_Flag,");
		sb.append("S_CR_RD_Money,");
		sb.append("S_CR_RD_OptDate,");
		sb.append("S_CR_RD_Register,");
		sb.append("S_CR_RD_Casher,");
		sb.append("S_CR_RD_CasherDate,");
		sb.append("S_CR_RD_AmountType,");
		sb.append("S_CR_RD_CheckPerson ) ");
		
		sb.append("select replace(newid(), '-', ''), ?, ?, ?, f_RC_id, '0', F_RC_Money, getdate(),?,");
		sb.append("null,null,?,? from F_RegisteredCategory where f_RC_id in (");

		List<String> params = new ArrayList<String>();
		params.add(po.getScrrddetailsid());
		params.add(po.getScrrdcustomerid());
		params.add(po.getScrrdshopcode());
		params.add(po.getScrrdregister());
		params.add(po.getScrrdamounttype());
		params.add(po.getScrrdcheckperson());

		for (int i = 0; i < po.getChk().length; i++) {
			sb.append("?,");
			params.add(po.getChk()[i]);
		}

		getJdbcTemplate().update(
				sb.toString().substring(0, sb.toString().length() - 1) + ")",
				params.toArray());
	}
}
