package com.pengsheng.eims.hydsycasehistory.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.hydsycasehistory.dao.RefractiveHydsyDao;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;
import com.pengsheng.eims.hydsycasehistory.persistence.RefractivePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class RefractiveHydsyDaoImpl extends BaseJdbcDaoSupport implements RefractiveHydsyDao {
	
	public void insertRefractivePo(RefractivePo refractivePo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" insert into S_OP_Refractive ( ");
		buffer.append(" S_OP_R_ID, ");
		params.add(this.uuid.generate());
		buffer.append(" S_OP_R_CustomerID, ");
		params.add(refractivePo.getSoprcustomerid());
		buffer.append(" S_OP_R_RefractiverID, ");
		params.add(refractivePo.getSoprrefractiverid());
		buffer.append(" S_OP_R_OptometryBasicID, ");
		params.add(refractivePo.getSoproptometrybasicid());
		buffer.append(" S_OP_R_OptometryID, ");
		params.add(refractivePo.getSoproptometryid());
		//瞳孔距离(右)
		if(!"".equals(Utility.getName(refractivePo.getSoprcheckpdod()))){
			buffer.append(" S_OP_R_CheckPDOD, ");
			params.add(refractivePo.getSoprcheckpdod());
		}
		//瞳孔距离(左)
		if(!"".equals(Utility.getName(refractivePo.getSoprcheckpdos()))){
			buffer.append(" S_OP_R_CheckPDOS, ");
			params.add(refractivePo.getSoprcheckpdos());
		}
		//裸眼视力(右)
		if(!"".equals(Utility.getName(refractivePo.getSoprnakedod()))){
			buffer.append(" S_OP_R_NakedOD, ");
			params.add(refractivePo.getSoprnakedod());
		}
		//裸眼视力(左)
		if(!"".equals(Utility.getName(refractivePo.getSoprnakedos()))){
			buffer.append(" S_OP_R_NakedOS, ");
			params.add(refractivePo.getSoprnakedos());
		}
		buffer.append(" S_OP_R_DiffusePupil, ");
		params.add(Utility.getName(refractivePo.getSoprdiffusepupil()));
		buffer.append(" S_OP_R_CheckBallGlassOD, ");
		params.add(Utility.getName(refractivePo.getSoprcheckballglassod()));
		buffer.append(" S_OP_R_CheckBallGlassOS, ");
		params.add(Utility.getName(refractivePo.getSoprcheckballglassos()));
		buffer.append(" S_OP_R_CheckPostGlassOD, ");
		params.add(Utility.getName(refractivePo.getSoprcheckpostglassod()));
		buffer.append(" S_OP_R_CheckPostGlassOS, ");
		params.add(Utility.getName(refractivePo.getSoprcheckpostglassos()));
		//检影轴向(右)
		if(!"".equals(Utility.getName(refractivePo.getSoprcheckaxesod()))){
			buffer.append(" S_OP_R_CheckAxesOD, ");
			params.add(refractivePo.getSoprcheckaxesod());
		}
		//检影轴向(左)
		if(!"".equals(Utility.getName(refractivePo.getSoprcheckaxesos()))){
			buffer.append(" S_OP_R_CheckAxesOS, ");
			params.add(refractivePo.getSoprcheckaxesos());
		}
		//试镜球镜(右)
		if(!"".equals(Utility.getName(refractivePo.getSoprtestballglassod()))){
			buffer.append(" S_OP_R_TestBallGlassOD, ");
			params.add(refractivePo.getSoprtestballglassod());
		}
		//试镜球镜(左)
		if(!"".equals(Utility.getName(refractivePo.getSoprtestballglassos()))){	
			buffer.append(" S_OP_R_TestBallGlassOS, ");
			params.add(refractivePo.getSoprtestballglassos());
		}
		//试镜柱镜(右)
		if(!"".equals(Utility.getName(refractivePo.getSoprtestpostglassod()))){
			buffer.append(" S_OP_R_TestPostGlassOD, ");
			params.add(refractivePo.getSoprtestpostglassod());
		}
		//试镜柱镜(左)
		if(!"".equals(Utility.getName(refractivePo.getSoprtestpostglassos()))){
			buffer.append(" S_OP_R_TestPostGlassOS, ");
			params.add(refractivePo.getSoprtestpostglassos());
		}
		//试镜轴向(右)
		if(!"".equals(Utility.getName(refractivePo.getSoprtestaxesod()))){
			buffer.append(" S_OP_R_TestAxesOD, ");
			params.add(refractivePo.getSoprtestaxesod());
		}
		//试镜轴向(左)
		if(!"".equals(Utility.getName(refractivePo.getSoprtestaxesos()))){
			buffer.append(" S_OP_R_TestAxesOS, ");
			params.add(refractivePo.getSoprtestaxesos());
		}
		//试镜VA(右)
		if(!"".equals(Utility.getName(refractivePo.getSoprtestvaod()))){
			buffer.append(" S_OP_R_TestVAOD, ");
			params.add(refractivePo.getSoprtestvaod());
		}
		//试镜VA(左)
		if(!"".equals(Utility.getName(refractivePo.getSoprtestvaos()))){
			buffer.append(" S_OP_R_TestVAOS, ");
			params.add(refractivePo.getSoprtestvaos());
		}
		//客观屈光球镜(右)
		if(!"".equals(Utility.getName(refractivePo.getSoproaballglassod()))){
			buffer.append(" S_OP_R_OABallGlassOD, ");
			params.add(refractivePo.getSoproaballglassod());
		}
		//客观屈光球镜(左)
		if(!"".equals(Utility.getName(refractivePo.getSoproaballglassos()))){
			buffer.append(" S_OP_R_OABallGlassOS, ");
			params.add(refractivePo.getSoproaballglassos());
		}
		//客观屈光柱镜(右)
		if(!"".equals(Utility.getName(refractivePo.getSoproapostglassod()))){
			buffer.append(" S_OP_R_OAPostGlassOD, ");
			params.add(refractivePo.getSoproapostglassod());
		}
		//客观屈光柱镜(左)
		if(!"".equals(Utility.getName(refractivePo.getSoproapostglassos()))){
			buffer.append(" S_OP_R_OAPostGlassOS, ");
			params.add(refractivePo.getSoproapostglassos());
		}
		//客观屈光轴向(右)
		if(!"".equals(Utility.getName(refractivePo.getSoproaaxesod()))){
			buffer.append(" S_OP_R_OAAxesOD, ");
			params.add(refractivePo.getSoproaaxesod());
		}
		//客观屈光轴向(左)
		if(!"".equals(Utility.getName(refractivePo.getSoproaaxesos()))){
			buffer.append(" S_OP_R_OAAxesOS, ");
			params.add(refractivePo.getSoproaaxesos());
		}
		//客观屈光VA(右)
		if(!"".equals(Utility.getName(refractivePo.getSoproavaod()))){
			buffer.append(" S_OP_R_OAVAOD, ");
			params.add(refractivePo.getSoproavaod());
		}
		//客观屈光VA(左)
		if(!"".equals(Utility.getName(refractivePo.getSoproavaos()))){
			buffer.append(" S_OP_R_OAVAOS, ");
			params.add(refractivePo.getSoproavaos());
		}
		//单眼终点红/绿试验(右)
		if(!"".equals(Utility.getName(refractivePo.getSoprredgreenod()))){
			buffer.append(" S_OP_R_RedGreenOD, ");
			params.add(refractivePo.getSoprredgreenod());
		}
		//单眼终点红/绿试验(左)
		if(!"".equals(Utility.getName(refractivePo.getSoprredgreenos()))){
			buffer.append(" S_OP_R_RedGreenOS, ");
			params.add(refractivePo.getSoprredgreenos());
		}
		//单眼前+1.00D后模糊视力(右)
		if(!"".equals(Utility.getName(refractivePo.getSoproneod()))){
			buffer.append(" S_OP_R_OneOD, ");
			params.add(refractivePo.getSoproneod());
		}
		//单眼前+1.00D后模糊视力(左)
		if(!"".equals(Utility.getName(refractivePo.getSoproneos()))){
			buffer.append(" S_OP_R_OneOS, ");
			params.add(refractivePo.getSoproneos());
		}
		//(右)球镜(双眼平衡结果)
		if(!"".equals(Utility.getName(refractivePo.getSoprdbalballglassod()))){
			buffer.append(" S_OP_R_DBalBallGlassOD, ");
			params.add(refractivePo.getSoprdbalballglassod());
		}
		//(左)球镜(双眼平衡结果)
		if(!"".equals(Utility.getName(refractivePo.getSoprdbalballglassos()))){
			buffer.append(" S_OP_R_DBalBallGlassOS, ");
			params.add(refractivePo.getSoprdbalballglassos());
		}
		//(右)柱镜(双眼平衡结果)
		if(!"".equals(Utility.getName(refractivePo.getSoprdbalpostglassod()))){
			buffer.append(" S_OP_R_DBalPostGlassOD, ");
			params.add(refractivePo.getSoprdbalpostglassod());
		}
		//(左)柱镜(双眼平衡结果)
		if(!"".equals(Utility.getName(refractivePo.getSoprdbalpostglassos()))){
			buffer.append(" S_OP_R_DBalPostGlassOS, ");
			params.add(refractivePo.getSoprdbalpostglassos());
		}
		//(右)轴向(双眼平衡结果)
		if(!"".equals(Utility.getName(refractivePo.getSoprdbalaxesod()))){
			buffer.append(" S_OP_R_DBalAxesOD, ");
			params.add(refractivePo.getSoprdbalaxesod());
		}
		//(左)轴向(双眼平衡结果)
		if(!"".equals(Utility.getName(refractivePo.getSoprdbalaxesos()))){
			buffer.append(" S_OP_R_DBalAxesOS, ");
			params.add(refractivePo.getSoprdbalaxesos());
		}
		//双眼平衡结果三棱镜右眼1
		if(!"".equals(Utility.getName(refractivePo.getSoprdbalarriseglassod()))){
			buffer.append(" S_OP_R_DBalArriseGlassOD, ");
			params.add(refractivePo.getSoprdbalarriseglassod());
		}
		//双眼平衡结果三棱镜左眼1
		if(!"".equals(Utility.getName(refractivePo.getSoprdbalarriseglassos()))){
			buffer.append(" S_OP_R_DBalArriseGlassOS, ");
			params.add(refractivePo.getSoprdbalarriseglassos());
		}
		//双眼平衡结果基底右眼1
		if(!"".equals(Utility.getName(refractivePo.getSoprdbalbasisod()))){
			buffer.append(" S_OP_R_DBalBasisOD, ");
			params.add(refractivePo.getSoprdbalbasisod());
		}
		//双眼平衡结果基底左眼1
		if(!"".equals(Utility.getName(refractivePo.getSoprdbalbasisos()))){
			buffer.append(" S_OP_R_DBalBasisOS, ");
			params.add(refractivePo.getSoprdbalbasisos());
		}
		//(右)远用瞳距(双眼平衡结果)
		if(!"".equals(Utility.getName(refractivePo.getSoprdbalinterhighod()))){
			buffer.append(" S_OP_R_DBalInterHighOD, ");
			params.add(refractivePo.getSoprdbalinterhighod());
		}
		//(左)远用瞳距(双眼平衡结果)
		if(!"".equals(Utility.getName(refractivePo.getSoprdbalinterhighos()))){
			buffer.append(" S_OP_R_DBalInterHighOS, ");
			params.add(refractivePo.getSoprdbalinterhighos());
		}
		//(右)近用瞳距(双眼平衡结果)
		if(!"".equals(Utility.getName(refractivePo.getSoprdbalinterdistanceod()))){
			buffer.append(" S_OP_R_DBalInterDistanceOD, ");
			params.add(refractivePo.getSoprdbalinterdistanceod());
		}
		//(左)近用瞳距(双眼平衡结果)
		if(!"".equals(Utility.getName(refractivePo.getSoprdbalinterdistanceos()))){
			buffer.append(" S_OP_R_DBalInterDistanceOS, ");
			params.add(refractivePo.getSoprdbalinterdistanceos());
		}
		//(右)VA(双眼平衡结果)
		if(!"".equals(Utility.getName(refractivePo.getSoprdbalvaod()))){
			buffer.append(" S_OP_R_DBalVAOD, ");
			params.add(refractivePo.getSoprdbalvaod());
		}
		//(左)VA(双眼平衡结果)
		if(!"".equals(Utility.getName(refractivePo.getSoprdbalvaos()))){
			buffer.append(" S_OP_R_DBalVAOS, ");
			params.add(refractivePo.getSoprdbalvaos());
		}
		//Add(右)
		if(!"".equals(Utility.getName(refractivePo.getSopraddod()))){
			buffer.append(" S_OP_R_AddOD, ");
			params.add(refractivePo.getSopraddod());
		}
		//Add(左)
		if(!"".equals(Utility.getName(refractivePo.getSopraddos()))){
			buffer.append(" S_OP_R_AddOS, ");
			params.add(refractivePo.getSopraddos());
		}
		//双眼平衡结果方法
		if(!"".equals(Utility.getName(refractivePo.getSoprdoublebalanceway()))){
			buffer.append(" S_OP_R_DoubleBalanceWay, ");
			params.add(refractivePo.getSoprdoublebalanceway());
		}
		//平衡红/绿眼
		if(!"".equals(Utility.getName(refractivePo.getSoprdoublebalancerg()))){
			buffer.append(" S_OP_R_DoubleBalanceRG, ");
			params.add(refractivePo.getSoprdoublebalancerg());
		}
		//主导眼
		if(!"".equals(Utility.getName(refractivePo.getSoprleadingeye ()))){
			buffer.append(" S_OP_R_LeadingEye, ");
			params.add(refractivePo.getSoprleadingeye());
		}
		//右眼瞳高
		if(!"".equals(Utility.getName(refractivePo.getSoprpupilheightod ()))){
			buffer.append(" S_OP_R_PupilHeightOD, ");
			params.add(refractivePo.getSoprpupilheightod());
		}
		//左眼瞳高
		if(!"".equals(Utility.getName(refractivePo.getSoprpupilheightos ()))){
			buffer.append(" S_OP_R_PupilHeightOS, ");
			params.add(refractivePo.getSoprpupilheightos());
		}
		
		//主诉
		if(!"".equals(Utility.getName(refractivePo.getSoprcustomersay()))){
			buffer.append(" S_OP_R_CustomerSay, ");
			params.add(refractivePo.getSoprcustomersay());
		}
		
		//配镜需求
		if(!"".equals(Utility.getName(refractivePo.getSoprgoals()))){
			buffer.append(" S_OP_R_Goals, ");
			params.add(refractivePo.getSoprgoals());
		}
		
		//检查日期
		buffer.append(" S_OP_R_Inspection_date, ");
		params.add(refractivePo.getSoprinspectiondate());
		//部门
		buffer.append(" S_OP_R_shopcode ) values (");
		params.add(refractivePo.getSoprshopcode());
		
		String param = new String();
		for (String  paramsStr: params) {
			param += "'"+paramsStr+"',";
		}
		param = param.replaceFirst(",$", "");
		buffer.append(param + ") ");
		getJdbcTemplate().update(buffer.toString());
	}
	
	public void updateRefractive(RefractivePo refractivePo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" update  S_OP_Refractive set ");
		buffer.append(" S_OP_R_RefractiverID = ?, ");
		params.add(Utility.getName(refractivePo.getSoprrefractiverid()));
		//瞳孔距离(右)
		buffer.append(" S_OP_R_CheckPDOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoprcheckpdod()));

		//瞳孔距离(左)
		buffer.append(" S_OP_R_CheckPDOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoprcheckpdos()));
			
		//裸眼视力(右)
		buffer.append(" S_OP_R_NakedOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoprnakedod()));

		//裸眼视力(左)
		buffer.append(" S_OP_R_NakedOS = ?, ");
		params.add(Utility.getName(Utility.getName(refractivePo.getSoprnakedos())));

		buffer.append(" S_OP_R_DiffusePupil = ?, ");
		params.add(Utility.getName(refractivePo.getSoprdiffusepupil()));
		
		buffer.append(" S_OP_R_CheckBallGlassOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoprcheckballglassod()));
		
		buffer.append(" S_OP_R_CheckBallGlassOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoprcheckballglassos()));
		
		buffer.append(" S_OP_R_CheckPostGlassOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoprcheckpostglassod()));
		
		buffer.append(" S_OP_R_CheckPostGlassOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoprcheckpostglassos()));
		
		//检影轴向(右)
		buffer.append(" S_OP_R_CheckAxesOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoprcheckaxesod()));

		//检影轴向(左)
		buffer.append(" S_OP_R_CheckAxesOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoprcheckaxesos()));

		//试镜球镜(右)
		buffer.append(" S_OP_R_TestBallGlassOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoprtestballglassod()));

		//试镜球镜(左)
		buffer.append(" S_OP_R_TestBallGlassOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoprtestballglassos()));

		//试镜柱镜(右)
		buffer.append(" S_OP_R_TestPostGlassOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoprtestpostglassod()));

		//试镜柱镜(左)
		buffer.append(" S_OP_R_TestPostGlassOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoprtestpostglassos()));

		//试镜轴向(右)
		buffer.append(" S_OP_R_TestAxesOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoprtestaxesod()));

		//试镜轴向(左)
		buffer.append(" S_OP_R_TestAxesOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoprtestaxesos()));

		//试镜VA(右)
		buffer.append(" S_OP_R_TestVAOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoprtestvaod()));

		//试镜VA(左)
		buffer.append(" S_OP_R_TestVAOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoprtestvaos()));

		//客观屈光球镜(右)
		buffer.append(" S_OP_R_OABallGlassOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoproaballglassod()));

		//客观屈光球镜(左)
		buffer.append(" S_OP_R_OABallGlassOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoproaballglassos()));

		//客观屈光柱镜(右)
		buffer.append(" S_OP_R_OAPostGlassOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoproapostglassod()));
		
		//客观屈光柱镜(左)
		buffer.append(" S_OP_R_OAPostGlassOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoproapostglassos()));
			
		//客观屈光轴向(右)
		buffer.append(" S_OP_R_OAAxesOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoproaaxesod()));

		//客观屈光轴向(左)
		buffer.append(" S_OP_R_OAAxesOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoproaaxesos()));

		//客观屈光VA(右)
		buffer.append(" S_OP_R_OAVAOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoproavaod()));
			
		//客观屈光VA(左)
		buffer.append(" S_OP_R_OAVAOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoproavaos()));
			
		//单眼终点红/绿试验(右)
		buffer.append(" S_OP_R_RedGreenOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoprredgreenod()));

		//单眼终点红/绿试验(左)
		buffer.append(" S_OP_R_RedGreenOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoprredgreenos()));
			
		//单眼前+1.00D后模糊视力(右)
		buffer.append(" S_OP_R_OneOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoproneod()));
		
		//单眼前+1.00D后模糊视力(左)
		buffer.append(" S_OP_R_OneOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoproneos()));
			
		//(右)球镜(双眼平衡结果)
		buffer.append(" S_OP_R_DBalBallGlassOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoprdbalballglassod()));
		//(左)球镜(双眼平衡结果)
		buffer.append(" S_OP_R_DBalBallGlassOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoprdbalballglassos()));

		//(右)柱镜(双眼平衡结果)
		buffer.append(" S_OP_R_DBalPostGlassOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoprdbalpostglassod()));

		//(左)柱镜(双眼平衡结果)
		buffer.append(" S_OP_R_DBalPostGlassOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoprdbalpostglassos()));
			
		//(右)轴向(双眼平衡结果)
		buffer.append(" S_OP_R_DBalAxesOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoprdbalaxesod()));

		//(左)轴向(双眼平衡结果)
		buffer.append(" S_OP_R_DBalAxesOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoprdbalaxesos()));
			
		//双眼平衡结果三棱镜右眼1
		buffer.append(" S_OP_R_DBalArriseGlassOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoprdbalarriseglassod()));

		//双眼平衡结果三棱镜左眼1
		buffer.append(" S_OP_R_DBalArriseGlassOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoprdbalarriseglassos()));
			
		//双眼平衡结果基底右眼1
		buffer.append(" S_OP_R_DBalBasisOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoprdbalbasisod()));

		//双眼平衡结果基底左眼1
		buffer.append(" S_OP_R_DBalBasisOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoprdbalbasisos()));

		//(右)远用瞳距(双眼平衡结果)
		buffer.append(" S_OP_R_DBalInterHighOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoprdbalinterhighod()));

		//(左)远用瞳距(双眼平衡结果)
		buffer.append(" S_OP_R_DBalInterHighOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoprdbalinterhighos()));

		//(右)近用瞳距(双眼平衡结果)
		buffer.append(" S_OP_R_DBalInterDistanceOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoprdbalinterdistanceod()));
			
		//(左)近用瞳距(双眼平衡结果)
		buffer.append(" S_OP_R_DBalInterDistanceOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoprdbalinterdistanceos()));

		//(右)VA(双眼平衡结果)
		buffer.append(" S_OP_R_DBalVAOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoprdbalvaod()));

		//(左)VA(双眼平衡结果)
		buffer.append(" S_OP_R_DBalVAOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoprdbalvaos()));

		//Add(右)
		buffer.append(" S_OP_R_AddOD = ?, ");
		params.add(Utility.getName(refractivePo.getSopraddod()));

		//Add(左)
		buffer.append(" S_OP_R_AddOS = ?, ");
		params.add(Utility.getName(refractivePo.getSopraddos()));

		//双眼平衡结果方法
		buffer.append(" S_OP_R_DoubleBalanceWay = ?, ");
		params.add(Utility.getName(refractivePo.getSoprdoublebalanceway()));
		
		//平衡红/绿眼
		buffer.append(" S_OP_R_DoubleBalanceRG = ?, ");
		params.add(Utility.getName(refractivePo.getSoprdoublebalancerg()));
		
		//主导眼
		buffer.append(" S_OP_R_LeadingEye = ?, ");
		params.add(Utility.getName(refractivePo.getSoprleadingeye ()));
		
		//右眼瞳高
		buffer.append(" S_OP_R_PupilHeightOD = ?, ");
		params.add(Utility.getName(refractivePo.getSoprpupilheightod()));
		
		//左眼瞳高
		buffer.append(" S_OP_R_PupilHeightOS = ?, ");
		params.add(Utility.getName(refractivePo.getSoprpupilheightos()));
		
		//检查日期
		buffer.append(" S_OP_R_Inspection_date = getdate(), ");
		//部门
		buffer.append(" S_OP_R_shopcode = ?, ");
		params.add(Utility.getName(refractivePo.getSoprshopcode()));
		
		//部门
		buffer.append(" S_OP_R_CustomerSay = ?, ");
		params.add(Utility.getName(refractivePo.getSoprcustomersay()));
		
		//部门
		buffer.append(" S_OP_R_Goals = ? ");
		params.add(Utility.getName(refractivePo.getSoprgoals()));
		
		buffer.append(" where S_OP_R_OptometryID = ? ");
		params.add(Utility.getName(refractivePo.getSoproptometryid()));
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void updateOptometry(OptometryPo po) {
		
		  StringBuffer sb= new StringBuffer();
		  sb.append("update S_OP_Optometry set");
	      sb.append(" S_OP_OY_RecipeUpdateTime= getdate() ");
	      sb.append(",S_OP_OY_Updateuserid = ? ");
	      sb.append("where S_OP_OY_OptometryID = ? ");
	      
	      List<String> params=new ArrayList<String>();
			
			params.add(po.getSopoyupdateuserid());
			params.add(po.getSopoyoptometryid());
			
			getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 更新验光基表
	 * @param optometryBasicPo
	 */
	public void updateOptometryBasic(OptometryBasicPo po) {
		StringBuffer sb=new StringBuffer();
		List<String> params=new ArrayList<String>();
		sb.append("update S_OP_OptometryBasic set ");
		sb.append("S_OP_OB_MedicalEndTime = getdate() ");
		sb.append("where S_OP_OB_OptometryBasicID = ? ");
		
		params.add(po.getSopoboptometrybasicid());
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
		
	}
	
	public int getRefractiveCount(OptometryPo optometryPo) {    
		
		  StringBuffer sb= new StringBuffer();
		  sb.append("select count(S_OP_R_OptometryID) from S_OP_Refractive where S_OP_R_OptometryID=?");
	      
	      List<String> params=new ArrayList<String>();
	      params.add(optometryPo.getSopoyoptometryid());
	      return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 显示屈光检查
	 * 
	 * @param po
	 * @return
	 */
	public RefractivePo getRefractive(RefractivePo po) {

		StringBuffer sb = new StringBuffer();
		
		sb.append("SELECT top 1 ");
		sb.append("S_OP_R_CustomerID as soprcustomerid ");
		sb.append(",S_OP_R_OptometryBasicID as soproptometrybasicid ");
		sb.append(",S_OP_R_OptometryID as soproptometryid ");
		sb.append(",S_OP_R_CheckPDOD as soprcheckpdod ");
		sb.append(",S_OP_R_CheckPDOS as soprcheckpdos  ");
		sb.append(",S_OP_R_NakedOD as soprnakedod ");
		sb.append(",S_OP_R_NakedOS as soprnakedos ");
		sb.append(",S_OP_R_DiffusePupil as soprdiffusepupil  ");
		sb.append(",S_OP_R_CheckBallGlassOD as soprcheckballglassod ");
		sb.append(",S_OP_R_CheckBallGlassOS as soprcheckballglassos ");
		sb.append(",S_OP_R_CheckPostGlassOD  as soprcheckpostglassod ");
		sb.append(",S_OP_R_CheckPostGlassOS as soprcheckpostglassos ");
		sb.append(",S_OP_R_CheckAxesOD as soprcheckaxesod ");
		sb.append(",S_OP_R_CheckAxesOS as soprcheckaxesos ");
		sb.append(",S_OP_R_TestBallGlassOD as soprtestballglassod  ");
		sb.append(",S_OP_R_TestBallGlassOS as soprtestballglassos  ");
		sb.append(",S_OP_R_TestPostGlassOD as soprtestpostglassod  ");
		sb.append(",S_OP_R_TestPostGlassOS as soprtestpostglassos ");
		sb.append(",S_OP_R_TestAxesOD as soprtestaxesod ");
		sb.append(",S_OP_R_TestAxesOS as soprtestaxesos ");
		sb.append(",S_OP_R_TestVAOD as soprtestvaod ");
		sb.append(",S_OP_R_TestVAOS as soprtestvaos ");
		sb.append(",S_OP_R_OABallGlassOD as soproaballglassod ");
		sb.append(",S_OP_R_OABallGlassOS as soproaballglassos ");
		sb.append(",S_OP_R_OAPostGlassOD as soproapostglassod ");
		sb.append(",S_OP_R_OAPostGlassOS as soproapostglassos ");
		sb.append(",S_OP_R_OAAxesOD as soproaaxesod ");
		sb.append(",S_OP_R_OAAxesOS as soproaaxesos ");
		sb.append(",S_OP_R_OAVAOD  as soproavaod ");
		sb.append(",S_OP_R_OAVAOS as soproavaos ");
		sb.append(",S_OP_R_RedGreenOD as soprredgreenod ");
		sb.append(",S_OP_R_RedGreenOS as soprredgreenos ");
		sb.append(",S_OP_R_OneOD  as soproneod ");
		sb.append(",S_OP_R_OneOS as soproneos ");
		sb.append(",S_OP_R_DBalBallGlassOD 		as soprdbalballglassod ");
		sb.append(",S_OP_R_DBalBallGlassOS 		as soprdbalballglassos ");
		sb.append(",S_OP_R_DBalPostGlassOD 		as soprdbalpostglassod ");
		sb.append(",S_OP_R_DBalPostGlassOS 		as soprdbalpostglassos ");
		sb.append(",S_OP_R_DBalAxesOD 			as soprdbalaxesod ");
		sb.append(",S_OP_R_DBalAxesOS 			as soprdbalaxesos ");
		sb.append(",S_OP_R_DBalArriseGlassOD 	as soprdbalarriseglassod ");
		sb.append(",S_OP_R_DBalArriseGlassOS 	as soprdbalarriseglassos ");
		sb.append(",S_OP_R_DBalBasisOD 			as soprdbalbasisod ");
		sb.append(",S_OP_R_DBalBasisOS 			as soprdbalbasisos ");
		sb.append(",S_OP_R_DBalInterHighOD 		as soprdbalinterhighod ");
		sb.append(",S_OP_R_DBalInterHighOS 		as soprdbalinterhighos ");
		sb.append(",S_OP_R_DBalInterDistanceOD 	as soprdbalinterdistanceod ");
		sb.append(",S_OP_R_DBalInterDistanceOS 	as soprdbalinterdistanceos ");
		sb.append(",S_OP_R_DBalVAOD 			as soprdbalvaod ");
		sb.append(",S_OP_R_DBalVAOS 			as soprdbalvaos ");
		sb.append(",S_OP_R_AddOD 				as sopraddod ");
		sb.append(",S_OP_R_AddOS  				as sopraddos ");
		sb.append(",S_OP_R_DoubleBalanceWay  	as soprdoublebalanceway ");
		sb.append(",S_OP_R_DoubleBalanceRG 		as soprdoublebalancerg ");
		sb.append(",S_OP_R_LeadingEye 			as soprleadingeye ");
		sb.append(",S_OP_R_Inspection_date 		as soprinspectiondate ");
		sb.append(",S_OP_R_shopcode 			as soprshopcode ");
		sb.append(",S_OP_R_PupilHeightOD 		as soprpupilheightod ");
		sb.append(",S_OP_R_PupilHeightOS 		as soprpupilheightos ");
		sb.append(",S_OP_R_CustomerSay 				as soprcustomersay ");
		sb.append(",S_OP_R_Goals					as soprgoals ");
		sb.append("FROM S_OP_Refractive  ");
		sb.append("where S_OP_R_OptometryID= ?");
		List<String> params = new ArrayList();
		params.add(po.getSoproptometryid());
		return (RefractivePo) queryForObject(sb.toString(), params.toArray(),
				RefractivePo.class);
		
	}
	

}
