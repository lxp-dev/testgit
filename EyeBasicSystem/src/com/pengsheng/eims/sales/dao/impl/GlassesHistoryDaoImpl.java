package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.sales.dao.GlassesHistoryDao;
import com.pengsheng.eims.sales.persistence.HisInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class GlassesHistoryDaoImpl extends BaseJdbcDaoSupport implements GlassesHistoryDao {

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
		
		buffer.append("insert into S_OP_HisInfo(S_OP_HI_ID , S_OP_HI_FCustomerID , S_OP_HI_FGlassesType , ");
		buffer.append("S_OP_HI_FGlassesM , S_OP_HI_FGlassesKind , S_OP_HI_FGlassesC , S_OP_HI_FGlassesAge , ");
		buffer.append("S_OP_HI_FContactLensM , S_OP_HI_FContactLensBrand , S_OP_HI_FContactLensC , ");
		buffer.append("S_OP_HI_FContactLensAge , S_OP_HI_FEyeIllHis1 , S_OP_HI_FEyeIllHis2 , ");
		buffer.append("S_OP_HI_FEyeIllHis3 , S_OP_HI_FInheritHis , S_OP_HI_FSensitiveHis , ");
		buffer.append("S_OP_HI_FUserName , S_OP_HI_FDateTime ");
		buffer.append(",S_OP_HI_BallOD	");
		buffer.append(",S_OP_HI_BallOS	");
		buffer.append(",S_OP_HI_PostOD	");
		buffer.append(",S_OP_HI_PostOS	");
		buffer.append(",S_OP_HI_AxesOD	");
		buffer.append(",S_OP_HI_AxesOS	");
		buffer.append(",S_OP_HI_AddOD	");
		buffer.append(",S_OP_HI_AddOS	");
		buffer.append(",S_OP_HI_ArriseOD	");
		buffer.append(",S_OP_HI_ArriseOS	");
		buffer.append(",S_OP_HI_BasisOD	");
		buffer.append(",S_OP_HI_BasisOS	");
		buffer.append(",S_OP_HI_InterHighOD	");
		buffer.append(",S_OP_HI_InterHighOS	");
		buffer.append(") values ( ");
		buffer.append("? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , getdate() ");
		buffer.append(",?,?,?,?,?,?,?,?,?,?,?,?,?,? ) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(hisInfoPo.getSophifcustomerid()));
		params.add(Utility.getName(hisInfoPo.getSophifglassestype()));
		params.add(Utility.getName(hisInfoPo.getSophifglassesm()));
		params.add(Utility.getName(hisInfoPo.getSophifglasseskind()));
		params.add(Utility.getName(hisInfoPo.getSophifglassesc()));
		params.add(Utility.getName(hisInfoPo.getSophifglassesage()));
		params.add(Utility.getName(hisInfoPo.getSophifcontactlensm()));
		params.add(Utility.getName(hisInfoPo.getSophifcontactlensbrand()));
		params.add(Utility.getName(hisInfoPo.getSophifcontactlensc()));
		params.add(Utility.getName(hisInfoPo.getSophifcontactlensage()));
		params.add(Utility.getName(hisInfoPo.getSophifeyeillhis1()));
		params.add(Utility.getName(hisInfoPo.getSophifeyeillhis2()));
		params.add(Utility.getName(hisInfoPo.getSophifeyeillhis3()));
		params.add(Utility.getName(hisInfoPo.getSophifinherithis()));
		params.add(Utility.getName(hisInfoPo.getSophifsensitivehis()));
		params.add(Utility.getName(hisInfoPo.getSophifusername()));
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
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
		
	}
	
	

}
