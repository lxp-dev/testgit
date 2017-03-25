package com.pengsheng.eims.casehistory.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.casehistory.dao.GlassesHistoryNDao;
import com.pengsheng.eims.casehistory.persistence.HisInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class GlassesHistoryNDaoImpl extends BaseJdbcDaoSupport implements GlassesHistoryNDao {

	/**
	 * 查询戴镜史信息
	 * @param hisInfoPo
	 * @return
	 */
	public void deleteGlassesHistory(HisInfoPo hisInfoPo) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("delete from S_OP_HisInfo ");
		buffer.append("where S_OP_HI_FCustomerID = ? ");	
		
		params.add(hisInfoPo.getSophifcustomerid());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 新增戴镜史信息
	 * @param hisInfoPo
	 */
	public void insertGlassesHistory(HisInfoPo hisInfoPo) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into S_OP_HisInfo(S_OP_HI_ID ");
		params.add(this.uuid.generate());
		
		buffer.append(",S_OP_HI_FCustomerID  ");
		params.add(Utility.getName(hisInfoPo.getSophifcustomerid()));
		
		buffer.append(",S_OP_HI_FGlassesType  ");
		params.add(Utility.getName(hisInfoPo.getSophifglassestype()));
		
		buffer.append(",S_OP_HI_FGlassesM  "); 
		params.add(Utility.getName(hisInfoPo.getSophifglassesm()));
		
		buffer.append(",S_OP_HI_FGlassesKind  "); 
		params.add(Utility.getName(hisInfoPo.getSophifglasseskind()));
		
		buffer.append(",S_OP_HI_FGlassesC  "); 
		params.add(Utility.getName(hisInfoPo.getSophifglassesc()));
		
		buffer.append(",S_OP_HI_FGlassesAge  ");
		params.add(Utility.getName(hisInfoPo.getSophifglassesage()));
		
		buffer.append(",S_OP_HI_FContactLensM  "); 
		params.add(Utility.getName(hisInfoPo.getSophifcontactlensm()));
		
		buffer.append(",S_OP_HI_FContactLensBrand  "); 
		params.add(Utility.getName(hisInfoPo.getSophifcontactlensbrand()));
		
		buffer.append(",S_OP_HI_FContactLensC  ");
		params.add(Utility.getName(hisInfoPo.getSophifcontactlensc()));
		
		buffer.append(",S_OP_HI_FContactLensAge  "); 
		params.add(Utility.getName(hisInfoPo.getSophifcontactlensage()));
		
		buffer.append(",S_OP_HI_FEyeIllHis1  "); 
		buffer.append(",S_OP_HI_FEyeIllHis2  ");
		buffer.append(",S_OP_HI_FEyeIllHis3  ");
		params.add(Utility.getName(hisInfoPo.getSophifeyeillhis1()));
		params.add(Utility.getName(hisInfoPo.getSophifeyeillhis2()));
		params.add(Utility.getName(hisInfoPo.getSophifeyeillhis3()));
		
		buffer.append(",S_OP_HI_FInheritHis  "); 
		params.add(Utility.getName(hisInfoPo.getSophifinherithis()));
		
		buffer.append(",S_OP_HI_FSensitiveHis  ");
		params.add(Utility.getName(hisInfoPo.getSophifsensitivehis()));
		
		buffer.append(",S_OP_HI_FUserName ");
		params.add(Utility.getName(hisInfoPo.getSophifusername()));
		
		buffer.append(",S_OP_HI_BallOD	");
		buffer.append(",S_OP_HI_BallOS	");
		params.add(Utility.getName(hisInfoPo.getSophiballod()));
		params.add(Utility.getName(hisInfoPo.getSophiballos()));
		
		buffer.append(",S_OP_HI_PostOD	");
		buffer.append(",S_OP_HI_PostOS	");
		params.add(Utility.getName(hisInfoPo.getSophipostod()));
		params.add(Utility.getName(hisInfoPo.getSophipostos()));
		
		buffer.append(",S_OP_HI_AxesOD	");
		buffer.append(",S_OP_HI_AxesOS	");
		params.add(Utility.getName(hisInfoPo.getSophiaxesod()));
		params.add(Utility.getName(hisInfoPo.getSophiaxesos()));
		
		buffer.append(",S_OP_HI_AddOD	");
		buffer.append(",S_OP_HI_AddOS	");
		params.add(Utility.getName(hisInfoPo.getSophiaddod()));
		params.add(Utility.getName(hisInfoPo.getSophiaddos()));
		
		buffer.append(",S_OP_HI_ArriseOD	");
		buffer.append(",S_OP_HI_ArriseOS	");
		params.add(Utility.getName(hisInfoPo.getSophiarriseod()));
		params.add(Utility.getName(hisInfoPo.getSophiarriseos()));
		
		buffer.append(",S_OP_HI_BasisOD	");
		buffer.append(",S_OP_HI_BasisOS	");
		params.add(Utility.getName(hisInfoPo.getSophibasisod()));
		params.add(Utility.getName(hisInfoPo.getSophibasisos()));
		buffer.append(",S_OP_HI_InterHighOD	");
		buffer.append(",S_OP_HI_InterHighOS	");
		params.add(Utility.getName(hisInfoPo.getSophiinterhighod()));
		params.add(Utility.getName(hisInfoPo.getSophiinterhighos()));
		
		buffer.append(",S_OP_HI_YDiameterOD	");
		buffer.append(",S_OP_HI_YDiameterOS	");
		params.add(Utility.getName(hisInfoPo.getSophiydiameterod()));
		params.add(Utility.getName(hisInfoPo.getSophiydiameteros()));
		
		buffer.append(",S_OP_HI_YCamberOD	");
		buffer.append(",S_OP_HI_YCamberOS	");
		params.add(Utility.getName(hisInfoPo.getSophiycamberod()));
		params.add(Utility.getName(hisInfoPo.getSophiycamberos()));
		
		buffer.append(",S_OP_HI_YDiameterODA	");
		buffer.append(",S_OP_HI_YDiameterOSA	");
		params.add(Utility.getName(hisInfoPo.getSophiydiameteroda()));
		params.add(Utility.getName(hisInfoPo.getSophiydiameterosa()));
		
		buffer.append(",S_OP_HI_YCamberODA	");
		buffer.append(",S_OP_HI_YCamberOSA	");
		params.add(Utility.getName(hisInfoPo.getSophiycamberoda()));
		params.add(Utility.getName(hisInfoPo.getSophiycamberosa()));
		
		buffer.append(",S_OP_HI_BallODA	");
		buffer.append(",S_OP_HI_BallOSA	");
		params.add(Utility.getName(hisInfoPo.getSophiballoda()));
		params.add(Utility.getName(hisInfoPo.getSophiballosa()));
		
		buffer.append(",S_OP_HI_PostODA	");
		buffer.append(",S_OP_HI_PostOSA	");
		params.add(Utility.getName(hisInfoPo.getSophipostoda()));
		params.add(Utility.getName(hisInfoPo.getSophipostosa()));
		
		buffer.append(",S_OP_HI_AxesODA	");
		buffer.append(",S_OP_HI_AxesOSA	");
		params.add(Utility.getName(hisInfoPo.getSophiaxesoda()));
		params.add(Utility.getName(hisInfoPo.getSophiaxesosa()));
		
		buffer.append(",S_OP_HI_AddODA	");
		buffer.append(",S_OP_HI_AddOSA	");
		params.add(Utility.getName(hisInfoPo.getSophiaddoda()));
		params.add(Utility.getName(hisInfoPo.getSophiaddosa()));
		
		buffer.append(",S_OP_HI_ArriseODA	");
		buffer.append(",S_OP_HI_ArriseOSA	");
		params.add(Utility.getName(hisInfoPo.getSophiarriseoda()));
		params.add(Utility.getName(hisInfoPo.getSophiarriseosa()));
		
		buffer.append(",S_OP_HI_BasisODA	");
		buffer.append(",S_OP_HI_BasisOSA	");
		params.add(Utility.getName(hisInfoPo.getSophibasisoda()));
		params.add(Utility.getName(hisInfoPo.getSophibasisosa()));
		
		buffer.append(",S_OP_HI_InterHighODA	");
		buffer.append(",S_OP_HI_InterHighOSA	");
		params.add(Utility.getName(hisInfoPo.getSophiinterhighoda()));
		params.add(Utility.getName(hisInfoPo.getSophiinterhighosa()));
		
		buffer.append(",S_OP_HI_VAOD	");
		buffer.append(",S_OP_HI_VAOS	");
		params.add(Utility.getName(hisInfoPo.getSophivaod()));
		params.add(Utility.getName(hisInfoPo.getSophivaos()));
		
		buffer.append(",S_OP_HI_VAODA	");
		buffer.append(",S_OP_HI_VAOSA	");
		params.add(Utility.getName(hisInfoPo.getSophivaoda()));
		params.add(Utility.getName(hisInfoPo.getSophivaosa()));
		
		buffer.append(",S_OP_HI_FDateTime ");
		buffer.append(" ) values ( ");
		buffer.append("? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? ");
		buffer.append(",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ");
		buffer.append(",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ");
		buffer.append(",?,?,?,?,getdate()) ");
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 查询戴镜史信息
	 * @param hisInfoPo
	 * @return
	 */
	public HisInfoPo selectGlassesHistory(HisInfoPo hisInfoPo) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  S_OP_HI_ID as sophiid , S_OP_HI_FCustomerID as sophifcustomerid , ");
		buffer.append("S_OP_HI_FGlassesType as sophifglassestype , S_OP_HI_FGlassesM as sophifglassesm , ");
		buffer.append("S_OP_HI_FGlassesKind as sophifglasseskind , S_OP_HI_FGlassesC as sophifglassesc , ");
		buffer.append("S_OP_HI_FGlassesAge as sophifglassesage , S_OP_HI_FContactLensM as sophifcontactlensm , ");
		buffer.append("S_OP_HI_FContactLensBrand as sophifcontactlensbrand , S_OP_HI_FContactLensC as sophifcontactlensc , ");
		buffer.append("S_OP_HI_FContactLensAge as sophifcontactlensage , S_OP_HI_FEyeIllHis1 as sophifeyeillhis1 , ");
		buffer.append("S_OP_HI_FEyeIllHis2 as sophifeyeillhis2 , S_OP_HI_FEyeIllHis3 as sophifeyeillhis3 , ");
		buffer.append("S_OP_HI_FInheritHis as sophifinherithis , S_OP_HI_FSensitiveHis as sophifsensitivehis ");
		buffer.append(",S_OP_HI_BallOD	as sophiballod ");
		buffer.append(",S_OP_HI_BallOS	as sophiballos ");
		buffer.append(",S_OP_HI_PostOD	as sophipostod ");
		buffer.append(",S_OP_HI_PostOS	as sophipostos ");
		buffer.append(",S_OP_HI_AxesOD	as sophiaxesod ");
		buffer.append(",S_OP_HI_AxesOS	as sophiaxesos ");
		buffer.append(",S_OP_HI_AddOD	as sophiaddod ");
		buffer.append(",S_OP_HI_AddOS	as sophiaddos ");
		buffer.append(",S_OP_HI_ArriseOD	as sophiarriseod ");
		buffer.append(",S_OP_HI_ArriseOS	as sophiarriseos ");
		buffer.append(",S_OP_HI_BasisOD	as sophibasisod ");
		buffer.append(",S_OP_HI_BasisOS	as sophibasisos ");
		buffer.append(",S_OP_HI_InterHighOD	as sophiinterhighod ");
		buffer.append(",S_OP_HI_InterHighOS	as sophiinterhighos ");
		
		buffer.append(",S_OP_HI_YDiameterOD		as sophiydiameterod ");
		buffer.append(",S_OP_HI_YDiameterOS		as sophiydiameteros ");
		buffer.append(",S_OP_HI_YCamberOD		as sophiycamberod ");
		buffer.append(",S_OP_HI_YCamberOS		as sophiycamberos ");
		
		buffer.append(",S_OP_HI_YDiameterODa	as sophiydiameteroda ");
		buffer.append(",S_OP_HI_YDiameterOSa	as sophiydiameterosa ");
		buffer.append(",S_OP_HI_YCamberODa		as sophiycamberoda ");
		buffer.append(",S_OP_HI_YCamberOSa		as sophiycamberosa ");
		buffer.append(",S_OP_HI_BallODa			as sophiballoda ");
		buffer.append(",S_OP_HI_BallOSa			as sophiballosa ");
		buffer.append(",S_OP_HI_PostODa			as sophipostoda ");
		buffer.append(",S_OP_HI_PostOSa			as sophipostosa ");
		buffer.append(",S_OP_HI_AxesODa			as sophiaxesoda ");
		buffer.append(",S_OP_HI_AxesOSa			as sophiaxesosa ");
		buffer.append(",S_OP_HI_AddODa			as sophiaddoda ");
		buffer.append(",S_OP_HI_AddOSa			as sophiaddosa ");
		buffer.append(",S_OP_HI_ArriseODa		as sophiarriseoda ");
		buffer.append(",S_OP_HI_ArriseOSa		as sophiarriseosa ");
		buffer.append(",S_OP_HI_BasisODa			as sophibasisoda ");
		buffer.append(",S_OP_HI_BasisOSa			as sophibasisosa ");
		buffer.append(",S_OP_HI_InterHighODa		as sophiinterhighoda ");
		buffer.append(",S_OP_HI_InterHighOSa		as sophiinterhighosa ");
		
		buffer.append(",S_OP_HI_VAOD	as sophivaod	");
		buffer.append(",S_OP_HI_VAOS	as sophivaos	");
		buffer.append(",S_OP_HI_VAODA	as sophivaoda	");
		buffer.append(",S_OP_HI_VAOSA	as sophivaosa	");
		
		buffer.append("from S_OP_HisInfo ");
		buffer.append("where S_OP_HI_FCustomerID = ? ");
		buffer.append("order by S_OP_HI_FDateTime desc ");
		
		params.add(hisInfoPo.getSophifcustomerid());
		
		return (HisInfoPo) queryForObject(buffer.toString() , params.toArray() , HisInfoPo.class);
	}
		
	/**
	 * 更新戴镜史信息
	 * @param hisInfoPo
	 */
	public void updateGlassesHistory(HisInfoPo hisInfoPo) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("update S_OP_HisInfo set ");
		buffer.append("S_OP_HI_BallOD = ?	");
		buffer.append(",S_OP_HI_BallOS = ?	");
		buffer.append(",S_OP_HI_PostOD = ?	");
		buffer.append(",S_OP_HI_PostOS = ?	");
		buffer.append(",S_OP_HI_AxesOD = ?	");
		buffer.append(",S_OP_HI_AxesOS = ?	");
		buffer.append(",S_OP_HI_AddOD = ?	");
		buffer.append(",S_OP_HI_AddOS = ?	");
		buffer.append(",S_OP_HI_ArriseOD = ?	");
		buffer.append(",S_OP_HI_ArriseOS = ?	");
		buffer.append(",S_OP_HI_BasisOD = ?	");
		buffer.append(",S_OP_HI_BasisOS = ?	");
		buffer.append(",S_OP_HI_InterHighOD = ?	");
		buffer.append(",S_OP_HI_InterHighOS = ?	");
		buffer.append(",S_OP_HI_YDiameterOD = ?		");
		buffer.append(",S_OP_HI_YDiameterOS = ?		");
		buffer.append(",S_OP_HI_YCamberOD 	= ?		");
		buffer.append(",S_OP_HI_YCamberOS	= ?	");
		buffer.append(",S_OP_HI_YDiameterODA = ?		");
		buffer.append(",S_OP_HI_YDiameterOSA = ?		");
		buffer.append(",S_OP_HI_YCamberODA = ?		");
		buffer.append(",S_OP_HI_YCamberOSA = ?		");
		buffer.append(",S_OP_HI_BallODA = ?		");
		buffer.append(",S_OP_HI_BallOSA = ?		");
		buffer.append(",S_OP_HI_PostODA = ?		");
		buffer.append(",S_OP_HI_PostOSA	 = ?	");
		buffer.append(",S_OP_HI_AxesODA = ?		");
		buffer.append(",S_OP_HI_AxesOSA	 = ?	");
		buffer.append(",S_OP_HI_AddODA	 = ?	");
		buffer.append(",S_OP_HI_AddOSA = ?		");
		buffer.append(",S_OP_HI_ArriseODA = ?		");
		buffer.append(",S_OP_HI_ArriseOSA = ?		");
		buffer.append(",S_OP_HI_BasisODA = ?		");
		buffer.append(",S_OP_HI_BasisOSA = ?		");
		buffer.append(",S_OP_HI_InterHighODA = ?		");
		buffer.append(",S_OP_HI_InterHighOSA = ?		");
		buffer.append(",S_OP_HI_VAOD	= ? ");
		buffer.append(",S_OP_HI_VAOS	= ? ");
		buffer.append(",S_OP_HI_VAODA	= ? ");
		buffer.append(",S_OP_HI_VAOSA	= ? ");
		buffer.append("where S_OP_HI_FCustomerID = ? ");

		params.add(Utility.getName(hisInfoPo.getSophiballod()));
		params.add(Utility.getName(hisInfoPo.getSophiballos()));
		params.add(Utility.getName(hisInfoPo.getSophipostod()));
		params.add(Utility.getName(hisInfoPo.getSophipostos()));
		params.add(Utility.getName(hisInfoPo.getSophiaxesod()));
		params.add(Utility.getName(hisInfoPo.getSophiaxesos()));
		params.add(Utility.getName(hisInfoPo.getSophiaddod()));
		params.add(Utility.getName(hisInfoPo.getSophiaddos()));
		params.add(Utility.getName(hisInfoPo.getSophiarriseod()));
		params.add(Utility.getName(hisInfoPo.getSophiarriseos()));
		params.add(Utility.getName(hisInfoPo.getSophibasisod()));
		params.add(Utility.getName(hisInfoPo.getSophibasisos()));
		params.add(Utility.getName(hisInfoPo.getSophiinterhighod()));
		params.add(Utility.getName(hisInfoPo.getSophiinterhighos()));
		params.add(Utility.getName(hisInfoPo.getSophifcustomerid()));
		

		params.add(Utility.getName(hisInfoPo.getSophiydiameterod()));
		params.add(Utility.getName(hisInfoPo.getSophiydiameteros()));
		params.add(Utility.getName(hisInfoPo.getSophiycamberod()));
		params.add(Utility.getName(hisInfoPo.getSophiycamberos()));
		
		params.add(Utility.getName(hisInfoPo.getSophiballoda()));
		params.add(Utility.getName(hisInfoPo.getSophiballosa()));
		params.add(Utility.getName(hisInfoPo.getSophipostoda()));
		params.add(Utility.getName(hisInfoPo.getSophipostosa()));
		params.add(Utility.getName(hisInfoPo.getSophiaxesoda()));
		params.add(Utility.getName(hisInfoPo.getSophiaxesosa()));
		params.add(Utility.getName(hisInfoPo.getSophiaddoda()));
		params.add(Utility.getName(hisInfoPo.getSophiaddosa()));
		params.add(Utility.getName(hisInfoPo.getSophiarriseoda()));
		params.add(Utility.getName(hisInfoPo.getSophiarriseosa()));
		params.add(Utility.getName(hisInfoPo.getSophibasisoda()));
		params.add(Utility.getName(hisInfoPo.getSophibasisosa()));
		params.add(Utility.getName(hisInfoPo.getSophiinterhighoda()));
		params.add(Utility.getName(hisInfoPo.getSophiinterhighosa()));
		params.add(Utility.getName(hisInfoPo.getSophiydiameteroda()));
		params.add(Utility.getName(hisInfoPo.getSophiydiameterosa()));
		params.add(Utility.getName(hisInfoPo.getSophiycamberoda()));
		params.add(Utility.getName(hisInfoPo.getSophiycamberosa()));
		
		params.add(Utility.getName(hisInfoPo.getSophivaod()));
		params.add(Utility.getName(hisInfoPo.getSophivaos()));
		params.add(Utility.getName(hisInfoPo.getSophivaoda()));
		params.add(Utility.getName(hisInfoPo.getSophivaosa()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
		
	}
	
	

}
