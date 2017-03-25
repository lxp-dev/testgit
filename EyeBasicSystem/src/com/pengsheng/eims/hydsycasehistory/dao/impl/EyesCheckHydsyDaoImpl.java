package com.pengsheng.eims.hydsycasehistory.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.hydsycasehistory.dao.EyesCheckHydsyDao;
import com.pengsheng.eims.hydsycasehistory.persistence.EyesCheckPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class EyesCheckHydsyDaoImpl extends BaseJdbcDaoSupport implements EyesCheckHydsyDao {

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
		
		if(!"".equals(Utility.getName(po.getSopecpersonid()))){
			sb.append("and S_OP_EC_PersonID='"+po.getSopecpersonid()+"' ");
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
		
		if(!"".equals(Utility.getName(po.getSopecpersonid()))){
			sb.append("and S_OP_EC_PersonID='"+po.getSopecpersonid()+"' ");
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
		sb.append(",S_OP_EC_AllergyHistory1 ");
		sb.append(",S_OP_DE_FarHeteLevel,S_OP_DE_FarHeteLevelIO,S_OP_DE_FarHeteUprightness,S_OP_DE_FarHeteUprightnessUD ");
		sb.append(",S_OP_DE_CloseHeteLevel,S_OP_DE_CloseHeteLevelIO,S_OP_DE_CloseHeteUprightness,S_OP_DE_CloseHeteUprightnessUD ");		
		sb.append("      ,S_OP_DE_Apparatusod ");
		sb.append("      ,S_OP_DE_Apparatusos ");
		sb.append("      ,S_OP_DE_Hctearfilmgradeod1 ");
		sb.append("      ,S_OP_DE_Hctearfilmgradeos1 ");
		sb.append("      ,S_OP_DE_Hcschirme5od ");
		sb.append("      ,S_OP_DE_Hcschirme5os ");
		sb.append("      ,S_OP_DE_Hcbu7od ");
		sb.append("      ,S_OP_DE_Hcbu7os ");
		sb.append("      ,S_OP_DE_Rcustomersay ");
		sb.append("      ,S_OP_DE_Glasstypes ");
		sb.append("      ,S_OP_DE_Touchglass ");
		sb.append("      ,S_OP_DE_Traintypes ");
		sb.append("      ,S_OP_DE_Operation ");
		sb.append("      ,S_OP_DE_Refractiveerror,S_OP_DE_IllsType,S_OP_DE_IllsConent ");	
		sb.append("      ,S_OP_DE_ZD_QGBZ ");
		sb.append("      ,S_OP_DE_ZD_RS ");
		sb.append("      ,S_OP_DE_ZD_XS ");
		sb.append("      ,S_OP_DE_ZD_QT ");
		sb.append(" ) values('"+id+"','"+po.getSopeccustomerid()+"','"+po.getSopecshopcode()+"','"+po.getSopecsurfaceeyeod()+"'");
		sb.append(",'"+po.getSopecsurfaceeyeos()+"','"+po.getSopeccongestiveod()+"','"+po.getSopeccongestiveos()+"','"+po.getSopecnippleod()+"'");
		sb.append(",'"+po.getSopecnippleos()+"','"+po.getSopeccornealod()+"','"+po.getSopeccornealos()+"','"+po.getSopechyphemaod()+"'");
		sb.append(",'"+po.getSopectearosod()+"','"+po.getSopectearosos()+"','"+po.getSopeciopselod()+"','"+po.getSopeciopselos()+"'");
		sb.append(",'"+po.getSopechyphemaos()+"','"+po.getSopecirisod()+"','"+po.getSopecirisos()+"','"+po.getSopeccrystalod()+"'");
		sb.append(",'"+po.getSopeccrystalos()+"','"+po.getSopecfundusod()+"','"+po.getSopecfundusos()+"','"+po.getSopeccampaignod()+"'");
		sb.append(",'"+po.getSopeccampaignos()+"','"+po.getSopeccolorod()+"','"+po.getSopeccoloros()+"','"+po.getSopeciopod()+"'");
		sb.append(",'"+po.getSopeciopos()+"','"+po.getSopecpersonid()+"',getdate()");
		sb.append(",?,?,?,?,?,?,?,?,?,?,?,?,?,? ");
		sb.append(",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
		
		params.add(Utility.getName(po.getSopecfruit()));
		params.add(Utility.getName(po.getSopecills()));
		params.add(Utility.getName(po.getSopecillhistory1()));
		params.add(Utility.getName(po.getSopecillhistory2()));
		params.add(Utility.getName(po.getSopecillhistory3()));
		params.add(Utility.getName(po.getSopecheredityhistory1()));
		params.add(Utility.getName(po.getSopecallergyhistory1()));		
		params.add(Utility.getName(po.getSopdefarhetelevel()));
		params.add(Utility.getName(po.getSopdefarhetelevelio()));
		params.add(Utility.getName(po.getSopdefarheteuprightness()));
		params.add(Utility.getName(po.getSopdefarheteuprightnessud()));
		params.add(Utility.getName(po.getSopdeclosehetelevel()));
		params.add(Utility.getName(po.getSopdeclosehetelevelio()));
		params.add(Utility.getName(po.getSopdecloseheteuprightness()));
		params.add(Utility.getName(po.getSopdecloseheteuprightnessud()));
		
		params.add(Utility.getName(po.getSopecapparatusod()));		
		params.add(Utility.getName(po.getSopecapparatusos()));		
		params.add(Utility.getName(po.getSophctearfilmgradeod1()));		
		params.add(Utility.getName(po.getSophctearfilmgradeos1()));		
		params.add(Utility.getName(po.getSophcschirme5od()));		
		params.add(Utility.getName(po.getSophcschirme5os()));		
		params.add(Utility.getName(po.getSophcbu7od()));		
		params.add(Utility.getName(po.getSophcbu7os()));		
		params.add(Utility.getName(po.getSoprcustomersay()));		
		params.add(Utility.getName(po.getSopipglasstypes()));		
		params.add(Utility.getName(po.getSopiptouchglass()));		
		params.add(Utility.getName(po.getSopiptraintypes()));		
		params.add(Utility.getName(po.getSopioperation()));		
		params.add(Utility.getName(po.getSoperefractiveerror()));

		params.add(Utility.getName(po.getSopecillstype()));
		params.add(Utility.getName(po.getSopecillsConent()));
		
		params.add(Utility.getName(po.getSopdezdqgbz()));
		params.add(Utility.getName(po.getSopdezdrs()));
		params.add(Utility.getName(po.getSopdezdxs()));
		params.add(Utility.getName(po.getSopdezdqt()));
		
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
		sb.append("select top 1  S_ME_CustomerInfo.S_ME_CI_CustomerID as sopeccustomerid,S_ME_CustomerInfo.S_ME_CI_MemberId as sopeccustomerpostcode");
		sb.append(",S_ME_CustomerInfo.S_ME_CI_Name as sopeccustomername,S_OP_EC_SurfaceEyeOD as sopecsurfaceeyeod");
		sb.append(",S_OP_EC_SurfaceEyeOS as sopecsurfaceeyeos,S_OP_EC_CongestiveOD as sopeccongestiveod");
		sb.append(",S_OP_EC_CongestiveOS as sopeccongestiveos,S_OP_EC_NippleOD as sopecnippleod");
		sb.append(",S_OP_EC_NippleOS as sopecnippleos,S_OP_EC_CornealOD as sopeccornealod");
		sb.append(",S_OP_EC_CornealOS as sopeccornealos,S_OP_EC_TearosOD as sopectearosod");
		sb.append(",S_OP_EC_TearosOS as sopectearosos,S_OP_EC_HyphemaOD as sopechyphemaod");
		sb.append(",S_OP_EC_HyphemaOS as sopechyphemaos,S_OP_EC_IrisOD as sopecirisod");
		sb.append(",S_OP_EC_IrisOS as sopecirisos,S_OP_EC_CrystalOD as sopeccrystalod");
		sb.append(",S_OP_EC_CrystalOS as sopeccrystalos,S_OP_EC_FundusOD as sopecfundusod");
		sb.append(",S_OP_EC_FundusOS as sopecfundusos,S_OP_EC_CampaignOD as sopeccampaignod");
		sb.append(",S_OP_EC_CampaignOS 			as sopeccampaignos");
		sb.append(",S_OP_EC_ColorOD 			as sopeccolorod");
		sb.append(",S_OP_EC_ColorOS 			as sopeccoloros");
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
		sb.append(",S_OP_DE_FarHeteLevel 	as sopdefarhetelevel ");	
		sb.append(",S_OP_DE_FarHeteLevelIO 	as sopdefarhetelevelio ");	
		sb.append(",S_OP_DE_FarHeteUprightness 	as sopdefarheteuprightness ");	
		sb.append(",S_OP_DE_FarHeteUprightnessUD 	as sopdefarheteuprightnessud ");	
		sb.append(",S_OP_DE_CloseHeteLevel 	as sopdeclosehetelevel ");	
		sb.append(",S_OP_DE_CloseHeteLevelIO 	as sopdeclosehetelevelio ");	
		sb.append(",S_OP_DE_CloseHeteUprightness 	as sopdecloseheteuprightness ");	
		sb.append(",S_OP_DE_CloseHeteUprightnessUD 	as sopdecloseheteuprightnessud ");		
		sb.append(",S_OP_DE_Apparatusod 	as sopecapparatusod ");
		sb.append(",S_OP_DE_Apparatusos 	as sopecapparatusos ");	
		sb.append(",S_OP_DE_Hctearfilmgradeod1 	as sophctearfilmgradeod1 ");	
		sb.append(",S_OP_DE_Hctearfilmgradeos1 	as sophctearfilmgradeos1 ");	
		sb.append(",S_OP_DE_Hcschirme5od 	as sophcschirme5od ");	
		sb.append(",S_OP_DE_Hcschirme5os 	as sophcschirme5os ");	
		sb.append(",S_OP_DE_Hcbu7od 	as sophcbu7od ");	
		sb.append(",S_OP_DE_Hcbu7os 	as sophcbu7os ");	
		sb.append(",S_OP_DE_Rcustomersay 	as soprcustomersay ");	
		sb.append(",S_OP_DE_Glasstypes 	as sopipglasstypes ");	
		sb.append(",S_OP_DE_Touchglass 	as sopiptouchglass ");	
		sb.append(",S_OP_DE_Traintypes 	as sopiptraintypes ");	
		sb.append(",S_OP_DE_Operation	as sopioperation ");
		sb.append(",S_OP_DE_Refractiveerror 	as soperefractiveerror ");		
		sb.append(",S_OP_DE_IllsType 	as sopecillstype ");
		sb.append(",S_OP_DE_IllsConent 	as sopecillsConent ");	
		sb.append(",S_OP_DE_ZD_QGBZ 	as sopdezdqgbz ");	
		sb.append(",S_OP_DE_ZD_RS 	as sopdezdrs ");	
		sb.append(",S_OP_DE_ZD_XS 	as sopdezdxs ");	
		sb.append(",S_OP_DE_ZD_QT 	as sopdezdqt ");	
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
