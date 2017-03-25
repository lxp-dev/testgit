package com.pengsheng.eims.hydsycasehistory.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.hydsycasehistory.dao.SpecialCheckHydsyDao;
import com.pengsheng.eims.hydsycasehistory.persistence.HealthCheckPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class SpecialCheckHydsyDaoImpl extends BaseJdbcDaoSupport implements SpecialCheckHydsyDao {

	/**
	 * 查询特殊功能检查
	 */
	public HealthCheckPo getSpecialCheck(HealthCheckPo healthCheckPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1 ");	
		buffer.append("S_OP_HC_ID as sophcid ");                         
		buffer.append(",S_OP_HC_CustomerID as sophccustomerid ");                 
		buffer.append(",S_OP_HC_OptometryBasicID as sophcoptometrybasicid ");           
		buffer.append(",S_OP_HC_OptometryID as sophcoptometryid ");                
		buffer.append(",S_OP_HC_CorneaCurvatureODS1 as sophccorneacurvatureods1 ");        
		buffer.append(",S_OP_HC_CorneaCurvatureODS2 as sophccorneacurvatureods2 ");       
		buffer.append(",S_OP_HC_CorneaCurvatureODF1 as sophccorneacurvatureodf1 ");       
		buffer.append(",S_OP_HC_CorneaCurvatureODF2 as sophccorneacurvatureodf2 ");       
		buffer.append(",S_OP_HC_CorneaCurvatureOSS1 as sophccorneacurvatureoss1 ");       
		buffer.append(",S_OP_HC_CorneaCurvatureOSS2 as sophccorneacurvatureoss2 ");       
		buffer.append(",S_OP_HC_CorneaCurvatureOSF1 as sophccorneacurvatureosf1 ");       
		buffer.append(",S_OP_HC_CorneaCurvatureOSF2 as sophccorneacurvatureosf2 ");       
		buffer.append(",S_OP_HC_EyeAxisOD as sophceyeaxisod ");                 
		buffer.append(",S_OP_HC_EyeAxisOS as sophceyeaxisos ");                 
		buffer.append(",S_OP_HC_AnteriorChamberDeepOD as sophcanteriorchamberdeepod ");     
		buffer.append(",S_OP_HC_AnteriorChamberDeepOS as sophcanteriorchamberdeepos ");     
		buffer.append(",S_OP_HC_LensThicknessOD as sophclensthicknessod ");           
		buffer.append(",S_OP_HC_LensThicknessOS as sophclensthicknessos ");           
		buffer.append(",S_OP_HC_VitreousCavityLengthOD as sophcvitreouscavitylengthod ");    
		buffer.append(",S_OP_HC_VitreousCavityLengthOS as sophcvitreouscavitylengthos ");    
		buffer.append(",S_OP_HC_CornealThicknessOD as sophccornealthicknessod ");        
		buffer.append(",S_OP_HC_CornealThicknessOS as sophccornealthicknessos ");        
		buffer.append(",S_OP_HC_TopographyFKOD as sophctopographyfkod ");            
		buffer.append(",S_OP_HC_TopographyFKOS as sophctopographyfkos ");            
		buffer.append(",S_OP_HC_TopographySKOD as sophctopographyskod ");            
		buffer.append(",S_OP_HC_TopographySKOS as sophctopographyskos ");            
		buffer.append(",S_OP_HC_TopographyASTOD as sophctopographyastod ");           
		buffer.append(",S_OP_HC_TopographyASTOS as sophctopographyastos ");           
		buffer.append(",S_OP_HC_TopographyEOD as sophctopographyeod ");             
		buffer.append(",S_OP_HC_TopographyEOS as sophctopographyeos ");             
		buffer.append(",S_OP_HC_TopographySAIOD as sophctopographysaiod ");           
		buffer.append(",S_OP_HC_TopographySAIOS as sophctopographysaios ");           
		buffer.append(",S_OP_HC_TopographySRIOD as sophctopographysriod ");           
		buffer.append(",S_OP_HC_TopographySRIOS as sophctopographysrios ");           
		buffer.append(",S_OP_HC_TearFilmGradeOD1 as sophctearfilmgradeod1 ");          
		buffer.append(",S_OP_HC_TearFilmGradeOD2 as sophctearfilmgradeod2 ");          
		buffer.append(",S_OP_HC_TearFilmGradeOS1 as sophctearfilmgradeos1 ");          
		buffer.append(",S_OP_HC_TearFilmGradeOS2 as sophctearfilmgradeos2 ");          
		buffer.append(",S_OP_HC_TearFilmOD as sophctearfilmod ");                
		buffer.append(",S_OP_HC_TearFilmOS as sophctearfilmos ");                
		buffer.append(",S_OP_HC_ContrastSensitivityOD as sophccontrastsensitivityod ");     
		buffer.append(",S_OP_HC_ContrastSensitivityOS as sophccontrastsensitivityos ");     
		buffer.append(",S_OP_HC_AberrationOD as sophcaberrationod ");              
		buffer.append(",S_OP_HC_AberrationOS as sophcaberrationos ");              
		buffer.append(",S_OP_HC_DynamicAdjustmentOD as sophcdynamicadjustmentod ");       
		buffer.append(",S_OP_HC_DynamicAdjustmentOS as sophcdynamicadjustmentos ");       
		buffer.append(",S_OP_HC_checkTime as sophcchecktime "); 
		buffer.append(",S_OP_HC_Checker as sophcchecker "); 
		buffer.append(",S_OP_HC_Schirme5OD	         	as sophcschirme5od 	");
		buffer.append(",S_OP_HC_Schirme5OS	         	as sophcschirme5os 	");
		buffer.append(",S_OP_HC_BU7OD	             	as sophcbu7od		");
		buffer.append(",S_OP_HC_BU7OS	             	as sophcbu7os		");
		buffer.append(",S_OP_HC_ThicknessOD	         	as sophcthicknessod ");
		buffer.append(",S_OP_HC_ThicknessOS	         	as sophcthicknessos ");
		buffer.append(",S_OP_HC_AreaOD	             	as sophcareaod		");
		buffer.append(",S_OP_HC_AreaOS	             	as sophcareaos		");
		buffer.append(",S_OP_HC_ScaleOD	             	as sophcscaleod		");
		buffer.append(",S_OP_HC_ScaleOS	             	as sophcscaleos		");
		buffer.append(",S_OP_HC_VariationOD	         	as sophcvariationod ");
		buffer.append(",S_OP_HC_VariationOS	         	as sophcvariationos ");
		buffer.append(",S_OP_HC_PlyOD	             	as sophcplyod 		");
		buffer.append(",S_OP_HC_PlyOS	             	as sophcplyos 		");
		buffer.append(",S_OP_HC_CorneaDiameterOD	        as sophccorneadiameterod 		");
		buffer.append(",S_OP_HC_CorneaDiameterOS	        as sophccorneadiameteros 		");
		
		buffer.append(",S_OP_EC_IOPOD	             	as sopeciopod 		");
		buffer.append(",S_OP_EC_IOPOS	             	as sopeciopos 		");
		buffer.append(",S_OP_EC_IOPSELOD	        as sopeciopselod 		");
		buffer.append(",S_OP_EC_IOPSELOS	        as sopeciopselos 		");
		
		buffer.append("from S_OP_HealthCheck ");
		buffer.append("where S_OP_HC_OptometryID = ? ");
		
		params.add(healthCheckPo.getSophcoptometryid());
		
		return (HealthCheckPo) queryForObject(buffer.toString(), params.toArray(), HealthCheckPo.class);
	}

	/**
	 * 新增特殊功能检查
	 */
	public void insertSpecialCheck(HealthCheckPo healthCheckPo) {
		// TODO Auto-generated method stub
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into S_OP_HealthCheck( ");
		buffer.append("S_OP_HC_ID ");
		buffer.append(",S_OP_HC_CustomerID ");
		buffer.append(",S_OP_HC_OptometryBasicID ");
		buffer.append(",S_OP_HC_OptometryID ");
		buffer.append(",S_OP_HC_CorneaCurvatureODS1 ");
		buffer.append(",S_OP_HC_CorneaCurvatureODS2 ");
		buffer.append(",S_OP_HC_CorneaCurvatureODF1 ");
		buffer.append(",S_OP_HC_CorneaCurvatureODF2 ");
		buffer.append(",S_OP_HC_CorneaCurvatureOSS1 ");
		buffer.append(",S_OP_HC_CorneaCurvatureOSS2 ");
		buffer.append(",S_OP_HC_CorneaCurvatureOSF1 ");
		buffer.append(",S_OP_HC_CorneaCurvatureOSF2 ");
		buffer.append(",S_OP_HC_EyeAxisOD ");
		buffer.append(",S_OP_HC_EyeAxisOS ");
		buffer.append(",S_OP_HC_AnteriorChamberDeepOD ");
		buffer.append(",S_OP_HC_AnteriorChamberDeepOS ");
		buffer.append(",S_OP_HC_LensThicknessOD ");
		buffer.append(",S_OP_HC_LensThicknessOS ");
		buffer.append(",S_OP_HC_VitreousCavityLengthOD ");
		buffer.append(",S_OP_HC_VitreousCavityLengthOS ");
		buffer.append(",S_OP_HC_CornealThicknessOD ");
		buffer.append(",S_OP_HC_CornealThicknessOS ");
		buffer.append(",S_OP_HC_TopographyFKOD ");
		buffer.append(",S_OP_HC_TopographyFKOS ");
		buffer.append(",S_OP_HC_TopographySKOD ");
		buffer.append(",S_OP_HC_TopographySKOS ");
		buffer.append(",S_OP_HC_TopographyASTOD ");
		buffer.append(",S_OP_HC_TopographyASTOS ");
		buffer.append(",S_OP_HC_TopographyEOD ");
		buffer.append(",S_OP_HC_TopographyEOS ");
		buffer.append(",S_OP_HC_TopographySAIOD ");
		buffer.append(",S_OP_HC_TopographySAIOS ");
		buffer.append(",S_OP_HC_TopographySRIOD ");
		buffer.append(",S_OP_HC_TopographySRIOS ");
		buffer.append(",S_OP_HC_TearFilmGradeOD1 ");
		buffer.append(",S_OP_HC_TearFilmGradeOD2 ");
		buffer.append(",S_OP_HC_TearFilmGradeOS1 ");
		buffer.append(",S_OP_HC_TearFilmGradeOS2 ");
		buffer.append(",S_OP_HC_TearFilmOD ");
		buffer.append(",S_OP_HC_TearFilmOS ");
		buffer.append(",S_OP_HC_ContrastSensitivityOD ");
		buffer.append(",S_OP_HC_ContrastSensitivityOS ");
		buffer.append(",S_OP_HC_AberrationOD ");
		buffer.append(",S_OP_HC_AberrationOS ");
		buffer.append(",S_OP_HC_DynamicAdjustmentOD ");
		buffer.append(",S_OP_HC_DynamicAdjustmentOS ");
		buffer.append(",S_OP_HC_CheckTime,S_OP_HC_Checker ");
		
		buffer.append(",S_OP_HC_Schirme5OD	     ");
		buffer.append(",S_OP_HC_Schirme5OS	     ");
		buffer.append(",S_OP_HC_BU7OD	         ");
		buffer.append(",S_OP_HC_BU7OS	         ");
		buffer.append(",S_OP_HC_ThicknessOD	     ");
		buffer.append(",S_OP_HC_ThicknessOS	     ");
		buffer.append(",S_OP_HC_AreaOD	         ");
		buffer.append(",S_OP_HC_AreaOS	         ");
		buffer.append(",S_OP_HC_ScaleOD	         ");
		buffer.append(",S_OP_HC_ScaleOS	         ");
		buffer.append(",S_OP_HC_VariationOD	     ");
		buffer.append(",S_OP_HC_VariationOS	     ");
		buffer.append(",S_OP_HC_PlyOD	         ");
		buffer.append(",S_OP_HC_PlyOS	         ");
		buffer.append(",S_OP_HC_CorneaDiameterOD	 ");
		buffer.append(",S_OP_HC_CorneaDiameterOS	 ");
		
		buffer.append(",S_OP_EC_IOPOD	         ");
		buffer.append(",S_OP_EC_IOPOS	         ");
		buffer.append(",S_OP_EC_IOPSELOD	 ");
		buffer.append(",S_OP_EC_IOPSELOS	 ");		
		
		buffer.append(" ) values ( ? ");							 
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                                                  
		buffer.append(", getdate() ");
		buffer.append(", ? ");
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");                                  
		buffer.append(", ? ");      
		buffer.append(", ? "); 
		buffer.append(", ? ");
		buffer.append(", ? ");                                  
		buffer.append(", ? ");      
		buffer.append(", ? "); 
		buffer.append(", ? "); 		
		buffer.append(", ? )");
		
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(healthCheckPo.getSophccustomerid()));
		params.add(Utility.getName(healthCheckPo.getSophcoptometrybasicid()));
		params.add(Utility.getName(healthCheckPo.getSophcoptometryid()));
		params.add(Utility.getName(healthCheckPo.getSophccorneacurvatureods1()));
		params.add(Utility.getName(healthCheckPo.getSophccorneacurvatureods2()));
		params.add(Utility.getName(healthCheckPo.getSophccorneacurvatureodf1()));
		params.add(Utility.getName(healthCheckPo.getSophccorneacurvatureodf2()));
		params.add(Utility.getName(healthCheckPo.getSophccorneacurvatureoss1()));
		params.add(Utility.getName(healthCheckPo.getSophccorneacurvatureoss2()));
		params.add(Utility.getName(healthCheckPo.getSophccorneacurvatureosf1()));
		params.add(Utility.getName(healthCheckPo.getSophccorneacurvatureosf2()));
		params.add(Utility.getName(healthCheckPo.getSophceyeaxisod()));
		params.add(Utility.getName(healthCheckPo.getSophceyeaxisos()));
		params.add(Utility.getName(healthCheckPo.getSophcanteriorchamberdeepod()));
		params.add(Utility.getName(healthCheckPo.getSophcanteriorchamberdeepos()));
		params.add(Utility.getName(healthCheckPo.getSophclensthicknessod()));
		params.add(Utility.getName(healthCheckPo.getSophclensthicknessos()));
		params.add(Utility.getName(healthCheckPo.getSophcvitreouscavitylengthod()));
		params.add(Utility.getName(healthCheckPo.getSophcvitreouscavitylengthos()));
		params.add(Utility.getName(healthCheckPo.getSophccornealthicknessod()));
		params.add(Utility.getName(healthCheckPo.getSophccornealthicknessos()));
		params.add(Utility.getName(healthCheckPo.getSophctopographyfkod()));
		params.add(Utility.getName(healthCheckPo.getSophctopographyfkos()));
		params.add(Utility.getName(healthCheckPo.getSophctopographyskod()));
		params.add(Utility.getName(healthCheckPo.getSophctopographyskos()));
		params.add(Utility.getName(healthCheckPo.getSophctopographyastod()));
		params.add(Utility.getName(healthCheckPo.getSophctopographyastos()));
		params.add(Utility.getName(healthCheckPo.getSophctopographyeod()));
		params.add(Utility.getName(healthCheckPo.getSophctopographyeos()));
		params.add(Utility.getName(healthCheckPo.getSophctopographysaiod()));
		params.add(Utility.getName(healthCheckPo.getSophctopographysaios()));
		params.add(Utility.getName(healthCheckPo.getSophctopographysriod()));
		params.add(Utility.getName(healthCheckPo.getSophctopographysrios()));
		params.add(Utility.getName(healthCheckPo.getSophctearfilmgradeod1()));
		params.add(Utility.getName(healthCheckPo.getSophctearfilmgradeod2()));
		params.add(Utility.getName(healthCheckPo.getSophctearfilmgradeos1()));
		params.add(Utility.getName(healthCheckPo.getSophctearfilmgradeos2()));
		params.add(Utility.getName(healthCheckPo.getSophctearfilmod()));
		params.add(Utility.getName(healthCheckPo.getSophctearfilmos()));
		params.add(Utility.getName(healthCheckPo.getSophccontrastsensitivityod()));
		params.add(Utility.getName(healthCheckPo.getSophccontrastsensitivityos()));
		params.add(Utility.getName(healthCheckPo.getSophcaberrationod()));
		params.add(Utility.getName(healthCheckPo.getSophcaberrationos()));
		params.add(Utility.getName(healthCheckPo.getSophcdynamicadjustmentod()));
		params.add(Utility.getName(healthCheckPo.getSophcdynamicadjustmentos()));
		params.add(Utility.getName(healthCheckPo.getSophcchecker()));
		
		params.add(Utility.getName(healthCheckPo.getSophcschirme5od()));
		params.add(Utility.getName(healthCheckPo.getSophcschirme5os()));
		params.add(Utility.getName(healthCheckPo.getSophcbu7od()));
		params.add(Utility.getName(healthCheckPo.getSophcbu7os()));
		params.add(Utility.getName(healthCheckPo.getSophcthicknessod()));
		params.add(Utility.getName(healthCheckPo.getSophcthicknessos()));
		params.add(Utility.getName(healthCheckPo.getSophcareaod()));
		params.add(Utility.getName(healthCheckPo.getSophcareaos()));
		params.add(Utility.getName(healthCheckPo.getSophcscaleod()));
		params.add(Utility.getName(healthCheckPo.getSophcscaleos()));
		params.add(Utility.getName(healthCheckPo.getSophcvariationod()));
		params.add(Utility.getName(healthCheckPo.getSophcvariationos()));
		params.add(Utility.getName(healthCheckPo.getSophcplyod()));
		params.add(Utility.getName(healthCheckPo.getSophcplyos()));
		params.add(Utility.getName(healthCheckPo.getSophccorneadiameterod()));
		params.add(Utility.getName(healthCheckPo.getSophccorneadiameteros()));
	
		params.add(Utility.getName(healthCheckPo.getSopeciopod()));
		params.add(Utility.getName(healthCheckPo.getSopeciopos()));
		params.add(Utility.getName(healthCheckPo.getSopeciopselod()));
		params.add(Utility.getName(healthCheckPo.getSopeciopselos()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 更新验光基表
	 */
	public void updateOptometryBasicCheck(OptometryBasicPo optometryBasicPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		buffer.append("update S_OP_OptometryBasic set ");
		buffer.append("S_OP_OB_MedicalEndTime = getdate() ");
		buffer.append("where S_OP_OB_OptometryBasicID = ? ");
		
		params.add(optometryBasicPo.getSopoboptometrybasicid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 更新验光表
	 */
	public void updateOptometryCheck(OptometryPo optometryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("update S_OP_Optometry set ");
		buffer.append("S_OP_OY_RecipeUpdateTime = getdate() , ");
		buffer.append("S_OP_OY_Updateuserid = ? ");
		buffer.append("where S_OP_OY_OptometryID = ? ");
		
		params.add(optometryPo.getSopoyupdateuserid());
		params.add(optometryPo.getSopoyoptometryid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 更新特殊功能检查
	 */
	public void updateSpecialCheck(HealthCheckPo healthCheckPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("update S_OP_HealthCheck set ");
		buffer.append("S_OP_HC_CorneaCurvatureODS1 = ? ");
		buffer.append(",S_OP_HC_CorneaCurvatureODS2 = ? ");
		buffer.append(",S_OP_HC_CorneaCurvatureODF1 = ? ");
		buffer.append(",S_OP_HC_CorneaCurvatureODF2 = ? ");
		buffer.append(",S_OP_HC_CorneaCurvatureOSS1 = ? ");
		buffer.append(",S_OP_HC_CorneaCurvatureOSS2 = ? ");
		buffer.append(",S_OP_HC_CorneaCurvatureOSF1 = ? ");
		buffer.append(",S_OP_HC_CorneaCurvatureOSF2 = ? ");
		buffer.append(",S_OP_HC_EyeAxisOD = ? ");
		buffer.append(",S_OP_HC_EyeAxisOS = ? ");
		buffer.append(",S_OP_HC_AnteriorChamberDeepOD = ? ");
		buffer.append(",S_OP_HC_AnteriorChamberDeepOS = ? ");
		buffer.append(",S_OP_HC_LensThicknessOD = ? ");
		buffer.append(",S_OP_HC_LensThicknessOS = ? ");
		buffer.append(",S_OP_HC_VitreousCavityLengthOD = ? ");
		buffer.append(",S_OP_HC_VitreousCavityLengthOS = ? ");
		buffer.append(",S_OP_HC_CornealThicknessOD = ? ");
		buffer.append(",S_OP_HC_CornealThicknessOS = ? ");
		buffer.append(",S_OP_HC_TopographyFKOD = ? ");
		buffer.append(",S_OP_HC_TopographyFKOS = ? ");
		buffer.append(",S_OP_HC_TopographySKOD = ? ");
		buffer.append(",S_OP_HC_TopographySKOS = ? ");
		buffer.append(",S_OP_HC_TopographyASTOD = ? ");
		buffer.append(",S_OP_HC_TopographyASTOS = ? ");
		buffer.append(",S_OP_HC_TopographyEOD = ? ");
		buffer.append(",S_OP_HC_TopographyEOS = ? ");
		buffer.append(",S_OP_HC_TopographySAIOD = ? ");
		buffer.append(",S_OP_HC_TopographySAIOS = ? ");
		buffer.append(",S_OP_HC_TopographySRIOD = ? ");
		buffer.append(",S_OP_HC_TopographySRIOS = ? ");
		buffer.append(",S_OP_HC_TearFilmGradeOD1 = ? ");
		buffer.append(",S_OP_HC_TearFilmGradeOD2 = ? ");
		buffer.append(",S_OP_HC_TearFilmGradeOS1 = ? ");
		buffer.append(",S_OP_HC_TearFilmGradeOS2 = ? ");
		buffer.append(",S_OP_HC_TearFilmOD =? ");
		buffer.append(",S_OP_HC_TearFilmOS =? ");
		buffer.append(",S_OP_HC_ContrastSensitivityOD = ? ");
		buffer.append(",S_OP_HC_ContrastSensitivityOS = ? ");
		buffer.append(",S_OP_HC_AberrationOD = ? ");
		buffer.append(",S_OP_HC_AberrationOS = ? ");
		buffer.append(",S_OP_HC_DynamicAdjustmentOD = ? ");
		buffer.append(",S_OP_HC_DynamicAdjustmentOS = ? ");
		buffer.append(",S_OP_HC_checkTime = getdate() ");
		buffer.append(",S_OP_HC_Checker = ? ");
		
		buffer.append(",S_OP_HC_Schirme5OD	  = ?   ");
		buffer.append(",S_OP_HC_Schirme5OS	  = ?   ");
		buffer.append(",S_OP_HC_BU7OD	      = ?   ");
		buffer.append(",S_OP_HC_BU7OS	      = ?   ");
		buffer.append(",S_OP_HC_ThicknessOD	  = ?   ");
		buffer.append(",S_OP_HC_ThicknessOS	  = ?   ");
		buffer.append(",S_OP_HC_AreaOD	      = ?   ");
		buffer.append(",S_OP_HC_AreaOS	      = ?   ");
		buffer.append(",S_OP_HC_ScaleOD	      = ?   ");
		buffer.append(",S_OP_HC_ScaleOS	      = ?   ");
		buffer.append(",S_OP_HC_VariationOD	  = ?   ");
		buffer.append(",S_OP_HC_VariationOS	  = ?   ");
		buffer.append(",S_OP_HC_PlyOD	      = ?   ");
		buffer.append(",S_OP_HC_PlyOS	      = ?   ");
		buffer.append(",S_OP_HC_CorneaDiameterOD	      = ?   ");
		buffer.append(",S_OP_HC_CorneaDiameterOS	      = ?   ");

		buffer.append(",S_OP_EC_IOPOD	      = ?   ");
		buffer.append(",S_OP_EC_IOPOS	      = ?   ");
		buffer.append(",S_OP_EC_IOPSELOD	      = ?   ");
		buffer.append(",S_OP_EC_IOPSELOS	      = ?   ");			
		
		buffer.append("where S_OP_HC_OptometryID = ? ");
		
		params.add(Utility.getName(healthCheckPo.getSophccorneacurvatureods1()));
		params.add(Utility.getName(healthCheckPo.getSophccorneacurvatureods2()));
		params.add(Utility.getName(healthCheckPo.getSophccorneacurvatureodf1()));
		params.add(Utility.getName(healthCheckPo.getSophccorneacurvatureodf2()));
		params.add(Utility.getName(healthCheckPo.getSophccorneacurvatureoss1()));
		params.add(Utility.getName(healthCheckPo.getSophccorneacurvatureoss2()));
		params.add(Utility.getName(healthCheckPo.getSophccorneacurvatureosf1()));
		params.add(Utility.getName(healthCheckPo.getSophccorneacurvatureosf2()));
		params.add(Utility.getName(healthCheckPo.getSophceyeaxisod()));
		params.add(Utility.getName(healthCheckPo.getSophceyeaxisos()));
		params.add(Utility.getName(healthCheckPo.getSophcanteriorchamberdeepod()));
		params.add(Utility.getName(healthCheckPo.getSophcanteriorchamberdeepos()));
		params.add(Utility.getName(healthCheckPo.getSophclensthicknessod()));
		params.add(Utility.getName(healthCheckPo.getSophclensthicknessos()));
		params.add(Utility.getName(healthCheckPo.getSophcvitreouscavitylengthod()));
		params.add(Utility.getName(healthCheckPo.getSophcvitreouscavitylengthos()));
		params.add(Utility.getName(healthCheckPo.getSophccornealthicknessod()));
		params.add(Utility.getName(healthCheckPo.getSophccornealthicknessos()));
		params.add(Utility.getName(healthCheckPo.getSophctopographyfkod()));
		params.add(Utility.getName(healthCheckPo.getSophctopographyfkos()));
		params.add(Utility.getName(healthCheckPo.getSophctopographyskod()));
		params.add(Utility.getName(healthCheckPo.getSophctopographyskos()));
		params.add(Utility.getName(healthCheckPo.getSophctopographyastod()));
		params.add(Utility.getName(healthCheckPo.getSophctopographyastos()));
		params.add(Utility.getName(healthCheckPo.getSophctopographyeod()));
		params.add(Utility.getName(healthCheckPo.getSophctopographyeos()));
		params.add(Utility.getName(healthCheckPo.getSophctopographysaiod()));
		params.add(Utility.getName(healthCheckPo.getSophctopographysaios()));
		params.add(Utility.getName(healthCheckPo.getSophctopographysriod()));
		params.add(Utility.getName(healthCheckPo.getSophctopographysrios()));
		params.add(Utility.getName(healthCheckPo.getSophctearfilmgradeod1()));
		params.add(Utility.getName(healthCheckPo.getSophctearfilmgradeod2()));
		params.add(Utility.getName(healthCheckPo.getSophctearfilmgradeos1()));
		params.add(Utility.getName(healthCheckPo.getSophctearfilmgradeos2()));
		params.add(Utility.getName(healthCheckPo.getSophctearfilmod()));
		params.add(Utility.getName(healthCheckPo.getSophctearfilmos()));
		params.add(Utility.getName(healthCheckPo.getSophccontrastsensitivityod()));
		params.add(Utility.getName(healthCheckPo.getSophccontrastsensitivityos()));
		params.add(Utility.getName(healthCheckPo.getSophcaberrationod()));
		params.add(Utility.getName(healthCheckPo.getSophcaberrationos()));
		params.add(Utility.getName(healthCheckPo.getSophcdynamicadjustmentod()));
		params.add(Utility.getName(healthCheckPo.getSophcdynamicadjustmentos()));
		params.add(Utility.getName(healthCheckPo.getSophcchecker()));
		
		params.add(Utility.getName(healthCheckPo.getSophcschirme5od()));
		params.add(Utility.getName(healthCheckPo.getSophcschirme5os()));
		params.add(Utility.getName(healthCheckPo.getSophcbu7od()));
		params.add(Utility.getName(healthCheckPo.getSophcbu7os()));
		params.add(Utility.getName(healthCheckPo.getSophcthicknessod()));
		params.add(Utility.getName(healthCheckPo.getSophcthicknessos()));
		params.add(Utility.getName(healthCheckPo.getSophcareaod()));
		params.add(Utility.getName(healthCheckPo.getSophcareaos()));
		params.add(Utility.getName(healthCheckPo.getSophcscaleod()));
		params.add(Utility.getName(healthCheckPo.getSophcscaleos()));
		params.add(Utility.getName(healthCheckPo.getSophcvariationod()));
		params.add(Utility.getName(healthCheckPo.getSophcvariationos()));
		params.add(Utility.getName(healthCheckPo.getSophcplyod()));
		params.add(Utility.getName(healthCheckPo.getSophcplyos()));
		params.add(Utility.getName(healthCheckPo.getSophccorneadiameterod()));
		params.add(Utility.getName(healthCheckPo.getSophccorneadiameteros()));

		params.add(Utility.getName(healthCheckPo.getSopeciopod()));
		params.add(Utility.getName(healthCheckPo.getSopeciopos()));
		params.add(Utility.getName(healthCheckPo.getSopeciopselod()));
		params.add(Utility.getName(healthCheckPo.getSopeciopselos()));
		
		params.add(healthCheckPo.getSophcoptometryid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	public int getSpecailCheckCount(OptometryPo optometryPo){
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) from S_OP_HealthCheck where S_OP_HC_OptometryID=?");
		List<String> params = new ArrayList<String>();
		params.add(optometryPo.getSopoyoptometryid());
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

}
