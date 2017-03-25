package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.Request;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.sales.dao.MydriasisDao;
import com.pengsheng.eims.sales.persistence.MydriasisPo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;
import com.pengsheng.eims.system.persistence.RegisteredPrintDetailsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class MydriasisDaoImpl extends BaseJdbcDaoSupport implements
		MydriasisDao {

	public int getMydriasisCount(MydriasisPo po) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
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
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			sb.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				sb.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			sb.append(" ) ");
		}

		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

	public List<MydriasisPo> getMydriasisList(MydriasisPo po, int start,
			int size) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
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
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			sb.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				sb.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			sb.append(" ) ");
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), MydriasisPo.class);
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
				.append("select top 1  S_ME_CustomerInfo.S_ME_CI_CustomerID as sopmdfcustomerid");
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
		sb.append("from F_RegisteredCategory  where F_RC_Flag='1' ");

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
		params.add(Utility.getName(po.getScrrdamounttype()));
		params.add(Utility.getName(po.getScrrdcheckperson()));

		for (int i = 0; i < po.getChk().length; i++) {
			sb.append("?,");
			params.add(po.getChk()[i]);
		}

		getJdbcTemplate().update(
				sb.toString().substring(0, sb.toString().length() - 1) + ")",
				params.toArray());
	}
	/**
	 * 新增挂号明细表信息流水记录
	 * 
	 * @param po
	 */
	public void insertRegisteredDetailslog(RegisteredDetailsPo po) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("insert into S_CR_RegisteredDetails_log ");
		
		sb.append("(S_CR_ID,");
		sb.append("S_CR_DetailsID,");
		sb.append("S_CR_CustomerID,");
		sb.append("S_CR_ShopCode,");
		sb.append("S_CR_RegisteredID,");
		sb.append("S_CR_Flag,");
		sb.append("S_CR_Money,");
		sb.append("S_CR_OptDate,");
		sb.append("S_CR_Register,");
		sb.append("S_CR_Casher,");
		sb.append("S_CR_CasherDate,");
		sb.append("S_CR_AmountType,");
		sb.append("S_CR_CheckPerson ) ");
		
		sb.append("select replace(newid(), '-', ''), ?, ?, ?, f_RC_id, '0', F_RC_Money, getdate(),?,");
		sb.append("null,null,?,? from F_RegisteredCategory where f_RC_id in (");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getScrrddetailsid());
		params.add(po.getScrrdcustomerid());
		params.add(po.getScrrdshopcode());
		params.add(po.getScrrdregister());
		params.add(Utility.getName(po.getScrrdamounttype()));
		params.add(Utility.getName(po.getScrrdcheckperson()));
		
		for (int i = 0; i < po.getChk().length; i++) {
			sb.append("?,");
			params.add(po.getChk()[i]);
		}
		
		getJdbcTemplate().update(
				sb.toString().substring(0, sb.toString().length() - 1) + ")",
				params.toArray());
	}

 
	public int getNoTollType() {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select count(F_RC_ID) from F_RegisteredCategory where isnull(F_RC_PayFeeID,'') = '' ");
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	 
	/*public List<RegisteredDetailsPo> getRegisteredPo(RegisteredDetailsPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select  ");
		sb.append("  S_CR_ID           as scrrdid         "); // 主键
		sb.append(" ,S_CR_DetailsID    as scrrddetailsid  "); // 挂号流水号
		sb.append(" ,S_CR_CustomerID   as scrrdcustomerid "); // 会员号
		sb.append(" ,S_CR_ShopCode     as scrrdshopcode   "); // 店号
		sb.append(" ,S_CR_RegisteredID as scrrdregisterid "); // 挂号类别ID
		sb.append(" ,F_RC_RegisteredName as scrrdregistername "); // 挂号类别名称
		sb.append(" ,S_CR_Flag         as scrrdflag       "); // 收费标志
		sb.append(" ,S_CR_Money        as scrrdmoney      "); // 挂号金额
		sb.append(" ,convert(varchar(10),S_CR_OptDate,120) as scrrdoptdate    "); // 挂号时间
		sb.append(" ,S_CR_Register     as scrrdregister   "); // 挂号人
		sb.append(" ,S_ME_CI_Name      as scrrdcreatename "); // 挂号人姓名
		sb.append(" ,S_CR_Casher       as scrrdcasher     "); // 收银人
		sb.append(" ,S_CR_CasherDate   as scrrdcasherdate "); // 收银时间
		sb.append(" ,S_CR_AmountType   as scrrdamounttype "); // 检查分类
		sb.append(" ,S_CR_CheckPerson  as scrrdcheckperson ");// 检查人
		
		sb.append(" from S_CR_RegisteredDetails_log ");
		sb.append(" left join  S_ME_CustomerInfo on S_CR_CustomerID  =  S_ME_CI_CustomerID ");
		sb.append(" left join  F_RegisteredCategory on S_CR_RegisteredID  =  F_RC_ID ");
		sb.append(" where   S_CR_DetailsID = ? ");
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getScrrddetailsid()));
		 
		return queryForObjectList(sb.toString(), params.toArray(), RegisteredDetailsPo.class);
	}*/

	 
	public List<RegisteredDetailsPo> getRegisteredList(RegisteredDetailsPo po, int start, int pageSize) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + pageSize;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select *");
		sb.append(" from(select ROW_NUMBER() Over(order by S_CR_ID desc) as scrrdpayfeeno,");
		
		sb.append("  S_CR_ID           as scrrdid         "); // 主键
		sb.append(" ,S_CR_DetailsID    as scrrddetailsid  "); // 挂号流水号
		sb.append(" ,S_CR_CustomerID   as scrrdcustomerid "); // 会员号
		sb.append(" ,S_CR_ShopCode     as scrrdshopcode   "); // 店号
		sb.append(" ,S_CR_RegisteredID as scrrdregisterid "); // 挂号类别ID
		sb.append(" ,F_RC_RegisteredName as scrrdregistername "); // 挂号类别名称
		sb.append(" ,S_CR_Flag         as scrrdflag       "); // 收费标志
		sb.append(" ,S_CR_Money        as scrrdmoney      "); // 挂号金额
		sb.append(" ,convert(varchar(10),S_CR_OptDate,120) as scrrdoptdate    "); // 挂号时间
		sb.append(" ,S_CR_Register     as scrrdregister   "); // 挂号人
		sb.append(" ,S_ME_CI_Name      as scrrdcreatename "); // 挂号人姓名
		sb.append(" ,S_CR_Casher       as scrrdcasher     "); // 收银人
		sb.append(" ,S_CR_CasherDate   as scrrdcasherdate "); // 收银时间
		sb.append(" ,S_CR_AmountType   as scrrdamounttype "); // 检查分类
		sb.append(" ,S_CR_CheckPerson  as scrrdcheckperson ");// 检查人
		
		sb.append(" from S_CR_RegisteredDetails_log ");
		sb.append(" left join  S_ME_CustomerInfo on S_CR_CustomerID  =  S_ME_CI_CustomerID ");
		sb.append(" left join  F_RegisteredCategory on S_CR_RegisteredID  =  F_RC_ID ");
		sb.append(" where   S_CR_DetailsID = ? ");
		
		params.add(Utility.getName(po.getScrrddetailsid()));
		
		sb.append(" ) temp where scrrdpayfeeno > " + start + " and scrrdpayfeeno <= "	+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), RegisteredDetailsPo.class);
	}

	 
	public int getRegisteredCount(RegisteredDetailsPo po) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select count(S_CR_ID) from S_CR_RegisteredDetails_log ");
		sb.append("where S_CR_DetailsID = ? ");

		params.add(Utility.getName(po.getScrrddetailsid()));
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	
}
