package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.InspectionDao;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.sun.faces.renderkit.html_basic.HtmlBasicRenderer.Param;

public class InspectionDaoImpl extends BaseJdbcDaoSupport implements
		InspectionDao {

	public void inspectionInsert(InspectionPo inspectionPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO S_OP_Inspection ");
		sb.append("(S_OP_IP_ID ");
		sb.append(",S_OP_IP_CustomerID ");
		sb.append(",S_OP_IP_OptometryBasicID ");
		sb.append(",S_OP_IP_OptometryID ");
		sb.append(",S_OP_IP_GlassType ");
		sb.append(",S_OP_IP_BallGlassOD ");
		sb.append(",S_OP_IP_BallGlassOS ");
		sb.append(",S_OP_IP_PostGlassOD ");
		sb.append(",S_OP_IP_PostGlassOS ");
		sb.append(",S_OP_IP_AxesOD ");
		sb.append(",S_OP_IP_AxesOS ");
		sb.append(",S_OP_IP_ADDOD ");
		sb.append(",S_OP_IP_ADDOS ");
		sb.append(",S_OP_IP_ArriseGlassOD1 ");
		sb.append(",S_OP_IP_ArriseGlassOS1 ");
		sb.append(",S_OP_IP_BasisOD1 ");
		sb.append(",S_OP_IP_basisOS1 ");
		sb.append(",S_OP_IP_PrismOD ");
		sb.append(",S_OP_IP_PrismOS ");
		sb.append(",S_OP_IP_InterHighOD ");
		sb.append(",S_OP_IP_InterHighOS ");
		sb.append(",S_OP_IP_InterDistanceOD ");
		sb.append(",S_OP_IP_InterDistanceOS ");
		sb.append(",S_OP_IP_FarVAOD ");
		sb.append(",S_OP_IP_FarVAOS ");
		sb.append(",S_OP_IP_CloseVAOD ");
		sb.append(",S_OP_IP_CloseVAOS ");
		sb.append(",S_OP_IP_EyeCurvatureOD1 ");
		sb.append(",S_OP_IP_EyeCurvatureOD2 ");
		sb.append(",S_OP_IP_EyeCurvatureOS1 ");
		sb.append(",S_OP_IP_EyeCurvatureOS2 ");
		sb.append(",S_OP_IP_DiameterOD ");
		sb.append(",S_OP_IP_DiameterOS ");
		sb.append(",S_OP_IP_ConLenVAOD ");
		sb.append(",S_OP_IP_ConLenVAOS ");
		sb.append(",S_OP_IP_CommendGlasses ");
		sb.append(",S_OP_IP_suggestFrame ");
		sb.append(",S_OP_IP_frameHeight ");
		sb.append(",S_OP_IP_GlassMaterial ");
		sb.append(",S_OP_IP_RecipeType ");
		sb.append(",S_OP_IP_DisposeManner ");
		sb.append(",S_OP_IP_DignosisRe ");
		sb.append(",S_OP_IP_ConRecipeType ");
		sb.append(",S_OP_IP_SecCheckDate ");
		sb.append(" ,S_OP_IP_UserName ");
		sb.append(",S_OP_IP_Flag ");
		sb.append(",S_OP_IP_conlenOSNum ");
		sb.append(",S_OP_IP_conlenODNum ");
		sb.append(",S_OP_IP_middleDistance ");
		sb.append(",S_OP_IP_commendCardWater ");
		sb.append(",S_OP_IP_printflag");
		sb.append(",S_OP_IP_CheckDate");
		sb.append(",S_OP_IP_Source");
		sb.append(",S_OP_IP_PupilheightOD");
		sb.append(",S_OP_IP_PupilheightOS");
		sb.append(",S_OP_IP_ExamineDoctor");
		sb.append(" )VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'0',?,?,?,?,?)");
		List<String> params = new ArrayList<String>();
		
		if(!"".equals(Utility.getName(inspectionPo.getSopipid()))){
			params.add(Utility.getName(inspectionPo.getSopipid()));
		}else{
			params.add(this.uuid.generate());
		}
		params.add(Utility.getName(inspectionPo.getSopipcustomerid()));
		params.add(Utility.getName(inspectionPo.getSopipoptometrybasicid()));
		params.add(Utility.getName(inspectionPo.getSopipoptometryid()));
		params.add(Utility.getName(inspectionPo.getSopipglasstype()));
		params.add(Utility.getName(inspectionPo.getSopipballglassod()));
		params.add(Utility.getName(inspectionPo.getSopipballglassos()));
		params.add(Utility.getName(inspectionPo.getSopippostglassod()));
		params.add(Utility.getName(inspectionPo.getSopippostglassos()));
		params.add(Utility.getName(inspectionPo.getSopipaxesod()));
		params.add(Utility.getName(inspectionPo.getSopipaxesos()));
		params.add(Utility.getName(inspectionPo.getSopipaddod()));
		params.add(Utility.getName(inspectionPo.getSopipaddos()));
		params.add(Utility.getName(inspectionPo.getSopiparriseglassod1()));
		params.add(Utility.getName(inspectionPo.getSopiparriseglassos1()));
		params.add(Utility.getName(inspectionPo.getSopipbasisod1()));
		params.add(Utility.getName(inspectionPo.getSopipbasisos1()));
		params.add(Utility.getName(inspectionPo.getSopipprismod()));
		params.add(Utility.getName(inspectionPo.getSopipprismos()));
		params.add(Utility.getName(inspectionPo.getSopipinterhighod()));
		params.add(Utility.getName(inspectionPo.getSopipinterhighos()));
		params.add(Utility.getName(inspectionPo.getSopipinterdistanceod()));
		params.add(Utility.getName(inspectionPo.getSopipinterdistanceos()));
		params.add(Utility.getName(inspectionPo.getSopipfarvaod()));
		params.add(Utility.getName(inspectionPo.getSopipfarvaos()));
		params.add(Utility.getName(inspectionPo.getSopipclosevaod()));
		params.add(Utility.getName(inspectionPo.getSopipclosevaos()));
		params.add(Utility.getName(inspectionPo.getSopipeyecurvatureod1()));
		params.add(Utility.getName(inspectionPo.getSopipeyecurvatureod2()));
		params.add(Utility.getName(inspectionPo.getSopipeyecurvatureos1()));
		params.add(Utility.getName(inspectionPo.getSopipeyecurvatureos2()));
		params.add(Utility.getName(inspectionPo.getSopipdiameterod()));
		params.add(Utility.getName(inspectionPo.getSopipdiameteros()));
		params.add(Utility.getName(inspectionPo.getSopipconlenvaod()));
		params.add(Utility.getName(inspectionPo.getSopipconlenvaos()));
		params.add(Utility.getName(inspectionPo.getSopipcommendglasses()));
		params.add(Utility.getName(inspectionPo.getSopipsuggestframe()));
		params.add(Utility.getName(inspectionPo.getSopipframeheight()));
		params.add(Utility.getName(inspectionPo.getSopipglassmaterial()));
		params.add(Utility.getName(inspectionPo.getSopiprecipetype()));
		params.add(Utility.getName(inspectionPo.getSopipdisposemanner()));
		params.add(Utility.getName(inspectionPo.getSopipdignosisre()));
		params.add(Utility.getName(inspectionPo.getSopipconrecipetype()));
		params.add(Utility.getName(inspectionPo.getSopipseccheckdate()));
		params.add(Utility.getName(inspectionPo.getSopipusername()));
		params.add(Utility.getName(inspectionPo.getSopipflag()));
		params.add(Utility.getName(inspectionPo.getSopipconlenosnum()));
		params.add(Utility.getName(inspectionPo.getSopipconlenodnum()));
		params.add(Utility.getName(inspectionPo.getSopipmiddledistance()));
		params.add(Utility.getName(inspectionPo.getSopipcommendcardwater()));
		params.add(Utility.getName(inspectionPo.getSopiptime()));
		params.add(Utility.getName(inspectionPo.getSopipsource()));
		params.add(Utility.getName(inspectionPo.getSopippupilheightod()));
		params.add(Utility.getName(inspectionPo.getSopippupilheightos()));
		params.add(Utility.getName(inspectionPo.getSopipexaminedoctor()));

		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public List<InspectionPo> getInspectionList(InspectionPo inspectionPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT S_OP_IP_ID as sopipid ,");
		sb.append("S_OP_IP_CustomerID as sopipcustomerid ,");
		sb.append("S_OP_IP_OptometryBasicID as   sopipoptometrybasicid ,");
		sb.append("S_OP_IP_OptometryID as sopipoptometryid, ");
		sb.append("S_OP_IP_GlassType as  sopipglasstype, ");
		sb.append("S_OP_IP_BallGlassOD as sopipballglassod ,");
		sb.append("S_OP_IP_BallGlassOS as sopipballglassos ,");
		sb.append("S_OP_IP_PostGlassOD as sopippostglassod, ");
		sb.append("S_OP_IP_PostGlassOS as sopippostglassos, ");
		sb.append("S_OP_IP_AxesOD as sopipaxesod ,");
		sb.append("S_OP_IP_AxesOS as sopipaxesos ,");
		sb.append("S_OP_IP_ADDOD as sopipaddod, ");
		sb.append("S_OP_IP_ADDOS as sopipaddos ,");
		sb.append("S_OP_IP_ArriseGlassOD1 as sopiparriseglassod1 ,");
		sb.append("S_OP_IP_ArriseGlassOS1 as sopiparriseglassos1 ,");
		sb.append("S_OP_IP_BasisOD1 as   sopipbasisod1, ");
		sb.append("S_OP_IP_BasisOS1 as   sopipbasisos1, ");
		sb.append("S_OP_IP_PrismOD as sopipprismod ,");
		sb.append("S_OP_IP_PrismOS as sopipprismos ,");
		sb.append("S_OP_IP_InterHighOD as sopipinterhighod ,");
		sb.append("S_OP_IP_InterHighOS as sopipinterhighos ,");
		sb.append("S_OP_IP_InterDistanceOD as sopipinterdistanceod ,");
		sb.append("S_OP_IP_InterDistanceOS as sopipinterdistanceos, ");
		sb.append("S_OP_IP_FarVAOD as sopipfarvaod ,");
		sb.append("S_OP_IP_FarVAOS as sopipfarvaos ,");
		sb.append("S_OP_IP_CloseVAOD as  sopipclosevaod ,");
		sb.append("S_OP_IP_CloseVAOS as  sopipclosevaos ,");
		sb.append("S_OP_IP_EyeCurvatureOD1 as sopipeyecurvatureod1 ,");
		sb.append("S_OP_IP_EyeCurvatureOD2 as sopipeyecurvatureod2 ,");
		sb.append("S_OP_IP_EyeCurvatureOS1 as sopipeyecurvatureos1 ,");
		sb.append("S_OP_IP_EyeCurvatureOS2 as sopipeyecurvatureos2 ,");
		sb.append("S_OP_IP_DiameterOD as sopipdiameterod ,");
		sb.append("S_OP_IP_DiameterOS as sopipdiameteros ,");
		sb.append("S_OP_IP_ConLenVAOD as sopipconlenvaod ,");
		sb.append("S_OP_IP_ConLenVAOS as sopipconlenvaos ,");
		sb.append("S_OP_IP_CommendGlasses as sopipcommendglasses ,");
		sb.append("S_OP_IP_suggestFrame as   sopipsuggestframe ,");
		sb.append("S_OP_IP_frameHeight as sopipframeheight ,");
		sb.append("S_OP_IP_GlassMaterial as  sopipglassmaterial ,");
		sb.append("S_OP_IP_RecipeType as sopiprecipetype ,");
		sb.append("S_OP_IP_DisposeManner as  sopipdisposemanner ,");
		sb.append("S_OP_IP_DignosisRe as sopipdignosisre ,");
		sb.append("S_OP_IP_ConRecipeType as  sopipconrecipetype ,");
		sb.append("S_OP_IP_SecCheckDate as   sopipseccheckdate ,");
		sb.append("S_OP_IP_SubVisitUnit as   sopipsubvisitunit ,");
		sb.append("S_OP_IP_UserName as   sopipusername, ");
		sb.append("S_OP_IP_Flag as  sopipflag ,");
		sb.append("S_OP_IP_conlenOSNum as sopipconlenosnum,  ");
		sb.append("S_OP_IP_conlenODNum as sopipconlenodnum,");
		sb.append("S_OP_IP_middleDistance as sopipmiddledistance,");
		sb.append("S_OP_IP_commendCardWater as sopipcommendcardwater,  ");
		sb.append("S_OP_IP_PupilheightOD as sopippupilheightod,  ");
		sb.append("S_OP_IP_PupilheightOS as sopippupilheightos,  ");
		sb.append("S_OP_IP_ExamineDoctor as sopipexaminedoctor,  ");
		sb.append("isnull(a.personName,'') as sopipexaminedoctorname,  ");
		sb.append("S_OP_IP_CheckDate as sopiptime  ");
		
		sb.append(" FROM S_OP_Inspection left join SYS_PersonInfo a on a.id = S_OP_IP_ExamineDoctor ");
		List<String> params = new ArrayList<String>();
		sb.append(" where S_OP_IP_OptometryID=? order by s_op_ip_glasstype");
		params.add(inspectionPo.getSopipoptometryid());
		return this.queryForObjectList(sb.toString(), params.toArray(), InspectionPo.class);

	}

	
	public void inspectionUpdate(InspectionPo inspectionPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("update S_OP_Inspection ");
		sb.append("set S_OP_IP_GlassType =?");
		sb.append(",S_OP_IP_BallGlassOD =?");
		sb.append(",S_OP_IP_BallGlassOS =?");
		sb.append(",S_OP_IP_PostGlassOD =?");
		sb.append(",S_OP_IP_PostGlassOS =?");
		sb.append(",S_OP_IP_AxesOD =?");
		sb.append(",S_OP_IP_AxesOS =?");
		sb.append(",S_OP_IP_ADDOD =?");
		sb.append(",S_OP_IP_ADDOS =?");
		sb.append(",S_OP_IP_ArriseGlassOD1 =?");
		sb.append(",S_OP_IP_ArriseGlassOS1 =?");
		sb.append(",S_OP_IP_BasisOD1 =?");
		sb.append(",S_OP_IP_basisOS1 =?");
		sb.append(",S_OP_IP_PrismOD =?");
		sb.append(",S_OP_IP_PrismOS =?");
		sb.append(",S_OP_IP_InterHighOD =?");
		sb.append(",S_OP_IP_InterHighOS =?");
		sb.append(",S_OP_IP_InterDistanceOD =?");
		sb.append(",S_OP_IP_InterDistanceOS =?");
		sb.append(",S_OP_IP_FarVAOD =?");
		sb.append(",S_OP_IP_FarVAOS =?");
		sb.append(",S_OP_IP_CloseVAOD =?");
		sb.append(",S_OP_IP_CloseVAOS =?");
		sb.append(",S_OP_IP_EyeCurvatureOD1 =?");
		sb.append(",S_OP_IP_EyeCurvatureOD2 =?");
		sb.append(",S_OP_IP_EyeCurvatureOS1 =?");
		sb.append(",S_OP_IP_EyeCurvatureOS2 =?");
		sb.append(",S_OP_IP_DiameterOD =?");
		sb.append(",S_OP_IP_DiameterOS =?");
		sb.append(",S_OP_IP_ConLenVAOD =?");
		sb.append(",S_OP_IP_ConLenVAOS =?");
		sb.append(",S_OP_IP_CommendGlasses =?");
		sb.append(",S_OP_IP_suggestFrame =?");
		sb.append(",S_OP_IP_frameHeight =?");
		sb.append(",S_OP_IP_GlassMaterial =?");
		sb.append(",S_OP_IP_RecipeType =?");
		sb.append(",S_OP_IP_DisposeManner =?");
		sb.append(",S_OP_IP_DignosisRe =?");
		sb.append(",S_OP_IP_ConRecipeType =?");
		sb.append(",S_OP_IP_SecCheckDate =?");
		sb.append(",S_OP_IP_UserName =?");
		sb.append(",S_OP_IP_Flag =?");
		sb.append(",S_OP_IP_conlenOSNum =?");
		sb.append(",S_OP_IP_conlenODNum =?");
		sb.append(",S_OP_IP_middleDistance =?");
		sb.append(",S_OP_IP_commendCardWater=?"); 
		sb.append(",S_OP_IP_CheckDate = getDate()");
		sb.append(",S_OP_IP_PupilheightOD = ?");
		sb.append(",S_OP_IP_PupilheightOS = ?");
		sb.append(" where S_OP_IP_OptometryID=?");
		List<String> params = new ArrayList<String>();
		
		params.add(Utility.getName(inspectionPo.getSopipglasstype()));
		params.add(Utility.getName(inspectionPo.getSopipballglassos()));
		params.add(Utility.getName(inspectionPo.getSopippostglassod()));
		params.add(Utility.getName(inspectionPo.getSopippostglassos()));
		params.add(Utility.getName(inspectionPo.getSopipaxesod()));
		params.add(Utility.getName(inspectionPo.getSopipaxesos()));
		params.add(Utility.getName(inspectionPo.getSopipaddod()));
		params.add(Utility.getName(inspectionPo.getSopipaddos()));
		params.add(Utility.getName(inspectionPo.getSopiparriseglassod1()));
		params.add(Utility.getName(inspectionPo.getSopiparriseglassos1()));
		params.add(Utility.getName(inspectionPo.getSopipbasisod1()));
		params.add(Utility.getName(inspectionPo.getSopipbasisos1()));
		params.add(Utility.getName(inspectionPo.getSopipprismod()));
		params.add(Utility.getName(inspectionPo.getSopipprismos()));
		params.add(Utility.getName(inspectionPo.getSopipinterhighod()));
		params.add(Utility.getName(inspectionPo.getSopipinterhighos()));
		params.add(Utility.getName(inspectionPo.getSopipinterdistanceod()));
		params.add(Utility.getName(inspectionPo.getSopipinterdistanceos()));
		params.add(Utility.getName(inspectionPo.getSopipfarvaod()));
		params.add(Utility.getName(inspectionPo.getSopipfarvaos()));
		params.add(Utility.getName(inspectionPo.getSopipclosevaod()));
		params.add(Utility.getName(inspectionPo.getSopipclosevaos()));
		params.add(Utility.getName(inspectionPo.getSopipeyecurvatureod1()));
		params.add(Utility.getName(inspectionPo.getSopipeyecurvatureod2()));
		params.add(Utility.getName(inspectionPo.getSopipeyecurvatureos1()));
		params.add(Utility.getName(inspectionPo.getSopipeyecurvatureos2()));
		params.add(Utility.getName(inspectionPo.getSopipdiameterod()));
		params.add(Utility.getName(inspectionPo.getSopipdiameteros()));
		params.add(Utility.getName(inspectionPo.getSopipconlenvaod()));
		params.add(Utility.getName(inspectionPo.getSopipconlenvaos()));
		params.add(Utility.getName(inspectionPo.getSopipcommendglasses()));
		params.add(Utility.getName(inspectionPo.getSopipsuggestframe()));
		params.add(Utility.getName(inspectionPo.getSopipframeheight()));
		params.add(Utility.getName(inspectionPo.getSopipglassmaterial()));
		params.add(Utility.getName(inspectionPo.getSopiprecipetype()));
		params.add(Utility.getName(inspectionPo.getSopipdisposemanner()));
		params.add(Utility.getName(inspectionPo.getSopipdignosisre()));
		params.add(Utility.getName(inspectionPo.getSopipconrecipetype()));
		params.add(Utility.getName(inspectionPo.getSopipseccheckdate()));
		params.add(Utility.getName(inspectionPo.getSopipusername()));
		params.add(Utility.getName(inspectionPo.getSopipflag()));
		params.add(Utility.getName(inspectionPo.getSopipconlenosnum()));
		params.add(Utility.getName(inspectionPo.getSopipconlenodnum()));
		params.add(Utility.getName(inspectionPo.getSopipmiddledistance()));
		params.add(Utility.getName(inspectionPo.getSopipcommendcardwater()));
		params.add(Utility.getName(inspectionPo.getSopippupilheightod()));
		params.add(Utility.getName(inspectionPo.getSopippupilheightos()));
		
		params.add(Utility.getName(inspectionPo.getSopipoptometryid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	public void inspectionDelete(InspectionPo inspectionPo){
		StringBuffer sb = new StringBuffer();
		sb.append("delete from S_OP_Inspection where S_OP_IP_OptometryID=?");
		List<String> params = new ArrayList<String>();
		params.add(inspectionPo.getSopipoptometryid());
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}


	public int getInspectionCount(OptometryPo optometryPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(S_OP_IP_ID) from S_OP_Inspection where S_OP_IP_OptometryID=?");
		List<String> params = new ArrayList<String>();
		params.add(optometryPo.getSopoyoptometryid());
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	public void inspectionprint(String id){
		StringBuffer sb = new StringBuffer();
		sb.append("update S_OP_Inspection set S_OP_IP_PrintFlag = '1' where S_OP_IP_OptometryID = ?");
		List<String> params = new ArrayList<String>();
		params.add(id);
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void updateInspectionFlag(String id){
		StringBuffer sb = new StringBuffer();
		sb.append("update S_OP_Optometry set S_OP_OY_Flag = '1' where S_OP_OY_OptometryID = ?");
		List<String> params = new ArrayList<String>();
		params.add(id);
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public CustomerInfoPo getCustomerInfo(String id){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 S_OP_IP_CustomerID as smecicustomerid,S_ME_CI_Name as smeciname,S_ME_CI_Sex as smecisex,convert(varchar(10),S_OP_OY_Time,120) as smecioptometrydate,S_OP_IP_SecCheckDate as smecifurtherdate,isnull(B_DP_DepartmentName,'') as smecioptometrydpt,isnull(B_DP_Phone,'') as smeciphone from S_OP_Inspection  ");
		buffer.append("  inner join S_OP_Optometry on S_OP_OY_OptometryBasicID=S_OP_IP_OptometryBasicID and S_OP_OY_OptometryID=S_OP_IP_OptometryID ");
		buffer.append("  inner join S_ME_CustomerInfo on S_OP_IP_CustomerID=S_ME_CI_CustomerID ");
		buffer.append("  inner join B_Departments on S_OP_OY_ShopCode=B_DP_DepartmentID ");
		buffer.append(" where S_OP_IP_OptometryID = ? ");
		buffer.append("and (");
		buffer.append("(substring(S_ME_CI_Phone,1,1)='1' ");
		buffer.append("and len(S_ME_CI_Phone)=11) ");		
		buffer.append("or (substring(S_ME_CI_Phone2,1,1)='1' ");
		buffer.append("and len(S_ME_CI_Phone2)=11) ");		
		buffer.append("or (substring(S_ME_CI_Phone3,1,1)='1' ");
		buffer.append("and len(S_ME_CI_Phone3)=11) ");		
		buffer.append(") ");
		
		params.add(id);
		
		return (CustomerInfoPo) queryForObject(buffer.toString(), params.toArray(),CustomerInfoPo.class);
	}
	
}
