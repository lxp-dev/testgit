package com.pengsheng.eims.bjtrhistory.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.bjtrhistory.dao.EyesCheckBjtrDao;
import com.pengsheng.eims.bjtrhistory.persistence.EyesCheckPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class EyesCheckBjtrDaoImpl extends BaseJdbcDaoSupport implements EyesCheckBjtrDao {

	public int getEyesCheckCount(EyesCheckPo po) {
				
		StringBuffer sb=new StringBuffer();
		sb.append("select count(S_OP_EyesCheck.S_OP_EC_CustomerID) from S_OP_EyesCheck ");
		sb.append("inner join S_ME_CustomerInfo on S_OP_EyesCheck.S_OP_EC_CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID  ");
		sb.append("where 1=1 ");
		if(!"".equals(Utility.getName(po.getSopeccustomername()))){
			sb.append("and S_ME_CI_Name like '%"+po.getSopeccustomername()+"%' ");
		}
		if(!"".equals(Utility.getName(po.getSopeccustomerpostcode()))){
			sb.append("and S_ME_CI_MemberId='"+po.getSopeccustomerpostcode()+"' ");
		}
		
		
		if(!"".equals(Utility.getName(po.getStartTime()))){
			sb.append(" and convert(varchar(10),S_OP_EC_VisionTime,23)>= '"+po.getStartTime()+"'");
		}
		if(!"".equals(Utility.getName(po.getEndTime()))){
			sb.append(" and convert(varchar(10),S_OP_EC_VisionTime,23)<= '"+po.getEndTime()+"'" );
		}
		
		return getJdbcTemplate().queryForInt(sb.toString());
	}
	public List<EyesCheckPo> getEyesCheckList(EyesCheckPo po, int start,
			int size) {
		StringBuffer sb=new StringBuffer();
		
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select *");
		sb.append(" from(select ROW_NUMBER() Over(order by S_OP_EyesCheck.S_OP_EC_VisionTime desc) as rowNum,");
		sb.append("S_ME_CustomerInfo.S_ME_CI_CustomerID as sopeccustomerid,S_ME_CustomerInfo.S_ME_CI_MemberId as sopeccustomerpostcode,");
		sb.append("S_ME_CustomerInfo.S_ME_CI_Name as sopeccustomername,S_ME_CustomerInfo.S_ME_CI_Sex as sopeccustomersex,");
		sb.append("year(getdate()) - year(S_ME_CustomerInfo.S_ME_CI_Birthday) as sopeccustomerage,S_OP_EyesCheck.S_OP_EC_ID as sopecid,");
		sb.append("S_ME_CustomerInfo.S_ME_CI_Phone as sopeccustomerphone,S_OP_EC_VisionTime as sopecvisiontime from S_OP_EyesCheck ");
		sb.append("inner join S_ME_CustomerInfo on S_OP_EyesCheck.S_OP_EC_CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID  ");
		sb.append("where 1=1 ");
		if(!"".equals(Utility.getName(po.getSopeccustomername()))){
			sb.append(" and S_ME_CI_Name like '%"+po.getSopeccustomername()+"%' ");
		}
		if(!"".equals(Utility.getName(po.getSopeccustomerpostcode()))){
			sb.append(" and S_ME_CI_MemberId='"+po.getSopeccustomerpostcode()+"' ");
		}
		if(!"".equals(Utility.getName(po.getStartTime()))){
			sb.append(" and convert(varchar(10),S_OP_EC_VisionTime,23)>= '"+po.getStartTime()+"' ");
		}
		if(!"".equals(Utility.getName(po.getEndTime()))){
			sb.append(" and convert(varchar(10),S_OP_EC_VisionTime,23)<= '"+po.getEndTime()+"'" );
		}
		sb.append("  ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), null, EyesCheckPo.class);
	}
	public void insertEyesCheck(EyesCheckPo po) {
		StringBuffer sb=new StringBuffer();	
		List<String> params = new ArrayList<String>(); 
		String id = this.uuid.generate();
		
		sb.append("insert into S_OP_EyesCheck(S_OP_EC_ID,S_OP_EC_CustomerID,S_OP_EC_ShopCode,S_OP_EC_SurfaceEyeOD");
		sb.append(",S_OP_EC_SurfaceEyeOS,S_OP_EC_CongestiveOD,S_OP_EC_CongestiveOS,S_OP_EC_NippleOD");
		sb.append(",S_OP_EC_NippleOS,S_OP_EC_CornealOD,S_OP_EC_CornealOS,S_OP_EC_HyphemaOD");
		sb.append(",S_OP_EC_TearosOD,S_OP_EC_TearosOS,S_OP_EC_IOPSELOD,S_OP_EC_IOPSELOS");
		sb.append(",S_OP_EC_HyphemaOS,S_OP_EC_IrisOD,S_OP_EC_IrisOS,S_OP_EC_CrystalOD");
		sb.append(",S_OP_EC_CrystalOS,S_OP_EC_FundusOD,S_OP_EC_FundusOS,S_OP_EC_CampaignOD");
		sb.append(",S_OP_EC_CampaignOS,S_OP_EC_ColorOD,S_OP_EC_ColorOS,S_OP_EC_IOPOD");
		sb.append(",S_OP_EC_IOPOS,S_OP_EC_PersonID,S_OP_EC_VisionTime");
		sb.append(",S_OP_EC_Fruit ");
		sb.append(",S_OP_EC_Ills ");
		sb.append(",S_OP_EC_IllHistory1 ");
		sb.append(",S_OP_EC_IllHistory2 ");
		sb.append(",S_OP_EC_IllHistory3 ");
		sb.append(",S_OP_EC_HeredityHistory1 ");
		sb.append(",S_OP_EC_AllergyHistory1,S_OP_MD_Remark) ");
		sb.append("values('"+id+"','"+po.getSopeccustomerid()+"','"+po.getSopecshopcode()+"','"+po.getSopecsurfaceeyeod()+"'");
		sb.append(",'"+po.getSopecsurfaceeyeos()+"','"+po.getSopeccongestiveod()+"','"+po.getSopeccongestiveos()+"','"+po.getSopecnippleod()+"'");
		sb.append(",'"+po.getSopecnippleos()+"','"+po.getSopeccornealod()+"','"+po.getSopeccornealos()+"','"+po.getSopechyphemaod()+"'");
		sb.append(",'"+po.getSopectearosod()+"','"+po.getSopectearosos()+"','"+po.getSopeciopselod()+"','"+po.getSopeciopselos()+"'");
		sb.append(",'"+po.getSopechyphemaos()+"','"+po.getSopecirisod()+"','"+po.getSopecirisos()+"','"+po.getSopeccrystalod()+"'");
		sb.append(",'"+po.getSopeccrystalos()+"','"+po.getSopecfundusod()+"','"+po.getSopecfundusos()+"','"+po.getSopeccampaignod()+"'");
		sb.append(",'"+po.getSopeccampaignos()+"','"+po.getSopeccolorod()+"','"+po.getSopeccoloros()+"','"+po.getSopeciopod()+"'");
		sb.append(",'"+po.getSopeciopos()+"','"+po.getSopecpersonid()+"',getdate()");
		sb.append(",?,?,?,?,?,?,?,?) ");
		
		params.add(Utility.getName(po.getSopecfruit()));
		params.add(Utility.getName(po.getSopecills()));
		params.add(Utility.getName(po.getSopecillhistory1()));
		params.add(Utility.getName(po.getSopecillhistory2()));
		params.add(Utility.getName(po.getSopecillhistory3()));
		params.add(Utility.getName(po.getSopecheredityhistory1()));
		params.add(Utility.getName(po.getSopecallergyhistory1()));
		params.add(Utility.getName(po.getSopecremark()));
		
		sb.append(" insert into S_OP_Mydriasis( ");
		sb.append(" S_OP_MD_ID, ");
		sb.append(" S_OP_MD_FCustomerID, ");
		sb.append(" S_OP_MD_ShopCode, ");
		sb.append(" S_OP_MD_Anaesthetic,");
		sb.append(" S_OP_MD_IsMydriasis ");
		sb.append(" ) values ( ");
		sb.append(" ?,?,?,?,? ");
		sb.append(" ) ");
		
		params.add(id);
		params.add(Utility.getName(po.getSopeccustomerid()));
		params.add(Utility.getName(po.getSopecshopcode()));
		params.add(Utility.getName(po.getSopecanaesthetic()));
		params.add(Utility.getName(po.getSopecismydriasis()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	public EyesCheckPo getEyesCheck(EyesCheckPo po) {
		StringBuffer sb=new StringBuffer();	
		sb.append("select top 1  S_ME_CustomerInfo.S_ME_CI_CustomerID as sopeccustomerid ");
		sb.append(",S_ME_CustomerInfo.S_ME_CI_MemberId as sopeccustomerpostcode ");
		sb.append(",S_ME_CustomerInfo.S_ME_CI_Name as sopeccustomername ");												    
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_SurfaceEyeOD, ',', '1')) FOR XML PATH('')), 1, 1, '')) AS sopecsurfaceeyeod ");		
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_SurfaceEyeOS, ',', '1')) FOR XML PATH('')), 1, 1, '')) AS sopecsurfaceeyeos ");
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_CongestiveOD, ',', '1')) FOR XML PATH('')), 1, 1, '')) AS sopeccongestiveod ");
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_CongestiveOS, ',', '1')) FOR XML PATH('')), 1, 1, '')) AS sopeccongestiveos ");
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_NippleOD, ',', '1')) FOR XML PATH('')), 1, 1, '')) 		AS sopecnippleod ");
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_NippleOS, ',', '1')) FOR XML PATH('')), 1, 1, '')) 		AS sopecnippleos ");
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_CornealOD, ',', '1')) FOR XML PATH('')), 1, 1, '')) 	AS sopeccornealod ");
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_CornealOS, ',', '1')) FOR XML PATH('')), 1, 1, '')) 	AS sopeccornealos ");
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_TearosOD, ',', '1')) FOR XML PATH('')), 1, 1, '')) 		AS sopectearosod ");
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_TearosOS, ',', '1')) FOR XML PATH('')), 1, 1, '')) 		AS sopectearosos ");
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_HyphemaOD, ',', '1')) FOR XML PATH('')), 1, 1, '')) 	AS sopechyphemaod ");
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_HyphemaOS, ',', '1')) FOR XML PATH('')), 1, 1, '')) 	AS sopechyphemaos ");
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_IrisOD, ',', '1')) FOR XML PATH('')), 1, 1, '')) 		AS sopecirisod ");
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_IrisOS, ',', '1')) FOR XML PATH('')), 1, 1, '')) 		AS sopecirisos ");
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_CrystalOD, ',', '1')) FOR XML PATH('')), 1, 1, '')) 	AS sopeccrystalod ");
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_CrystalOS, ',', '1')) FOR XML PATH('')), 1, 1, '')) 	AS sopeccrystalos ");
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_FundusOD, ',', '1')) FOR XML PATH('')), 1, 1, '')) 		AS sopecfundusod ");
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_FundusOS, ',', '1')) FOR XML PATH('')), 1, 1, '')) 		AS sopecfundusos ");
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_CampaignOD, ',', '1')) FOR XML PATH('')), 1, 1, '')) 	AS sopeccampaignod ");
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_CampaignOS, ',', '1')) FOR XML PATH('')), 1, 1, '')) 	AS sopeccampaignos ");
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_ColorOD, ',', '1')) FOR XML PATH('')), 1, 1, '')) 		AS sopeccolorod ");
		sb.append(",(SELECT F_OP_ParamName=Stuff((SELECT '、'+ F_OP_ParamName FROM F_OptionParam WHERE  F_OP_ParamID IN (SELECT value FROM   dbo.Splitstring(S_OP_EC_ColorOS, ',', '1')) FOR XML PATH('')), 1, 1, '')) 		AS sopeccoloros ");
		sb.append(",S_OP_EC_IOPOD 				as sopeciopod");
	    sb.append(",S_OP_EC_IOPOS 				as sopeciopos");
	    sb.append(",S_OP_EC_IOPSELOD 			as sopeciopselod");
	    sb.append(",S_OP_EC_VisionTime 			as sopecvisiontime ");
		sb.append(",S_OP_EC_IOPSELOS 			as sopeciopselos ");
		sb.append(",S_OP_EC_Fruit		 		as sopecfruit ");
		sb.append(",S_OP_EC_Ills		 		as sopecills ");
		sb.append(",S_OP_EC_IllHistory1	 		as sopecillhistory1 ");
		sb.append(",S_OP_EC_IllHistory2	 		as sopecillhistory2 ");
		sb.append(",S_OP_EC_IllHistory3		 	as sopecillhistory3 ");
		sb.append(",S_OP_EC_HeredityHistory1	as sopecheredityhistory1 ");
		sb.append(",S_OP_EC_AllergyHistory1		as sopecallergyhistory1 ");
		sb.append(",S_OP_MD_Anaesthetic 		as sopecanaesthetic ");
		sb.append(",S_OP_MD_IsMydriasis 		as sopecismydriasis ");
		sb.append(",SYS_PersonInfo.personName 	as sopecpersonname ");	
		sb.append(",isnull(S_OP_MD_Remark,'') 	as sopecremark ");	
		sb.append("from S_OP_EyesCheck ");
		sb.append("inner join S_ME_CustomerInfo on S_OP_EyesCheck.S_OP_EC_CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		sb.append("inner join SYS_PersonInfo on S_OP_EyesCheck.S_OP_EC_PersonID=SYS_PersonInfo.ID ");
		sb.append("left join S_OP_Mydriasis on S_OP_MD_ID = S_OP_EC_ID ");
		sb.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getSmecimemberid()))){
			sb.append(" and S_ME_CustomerInfo.S_ME_CI_MemberId='"+po.getSmecimemberid()+"'");
		}
		
		if(!"".equals(Utility.getName(po.getSopeccustomerid()))){
			sb.append(" and S_ME_CustomerInfo.S_ME_CI_CustomerID='"+po.getSopeccustomerid()+"'");
		}
		
		if(!"".equals(Utility.getName(po.getSopecid()))){
			sb.append(" and S_OP_EC_ID='"+po.getSopecid()+"'");
		}
		
		sb.append(" order by S_OP_EyesCheck.S_OP_EC_VisionTime desc	");

		return (EyesCheckPo)queryForObject(sb.toString(), null, EyesCheckPo.class);
	}
	
	
	
	/**
	 * 查询费用提交数量
	 * @param po
	 * @return
	 */
	public int getEyecChargePutCount(RegisteredCategoryPo po) {
		
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select count(F_RC_Money) from F_RegisteredCategory ");
		sb.append("where F_RC_Flag='1' ");
		
		if(!"".equals(Utility.getName(po.getFrcfeetype()))){
			sb.append(" and F_RC_FeeType=? ");
			params.add(po.getFrcfeetype());
		}
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	/**
	 * 显示费用提交信息并分页
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<RegisteredCategoryPo> getEyesChargePutList(
			RegisteredCategoryPo po, int start, int size) {
		StringBuffer sb=new StringBuffer();
        List<String> params = new ArrayList<String>();
    	int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
        sb.append("select F_RC_Money as frcmoney from ");
		sb.append("(select ROW_NUMBER() Over(order by F_RegisteredCategory.F_RC_orderType ) as rowNum, ");
		sb.append("F_RC_Money ");
		sb.append("from F_RegisteredCategory  where F_RC_Flag='1'");

		if(!"".equals(Utility.getName(po.getFrcfeetype()))){
			sb.append(" and F_RC_FeeType=? ");
			params.add(po.getFrcfeetype());
		}
		sb.append(" )temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(),
				RegisteredCategoryPo.class);
	}
}
