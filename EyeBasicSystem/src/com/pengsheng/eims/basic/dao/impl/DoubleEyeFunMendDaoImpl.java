package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.DoubleEyeFunMendDao;
import com.pengsheng.eims.basic.persistence.DoubleEyeFunMendPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class DoubleEyeFunMendDaoImpl extends BaseJdbcDaoSupport implements DoubleEyeFunMendDao{
	public void deleteDoubleEyeFunMendPo() {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" Delete from B_DoubleEyeFunMend ");		
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public void insertDoubleEyeFunMendPo(DoubleEyeFunMendPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" insert into B_DoubleEyeFunMend ");
		sb.append(" ( ");
		sb.append("  B_DM_Farhetelevel ");
		sb.append(" ,B_DM_Closehetelevel ");
		sb.append(" ,B_DM_Farheteuprightness ");
		sb.append(" ,B_DM_Closeheteuprightness ");
		sb.append(" ,B_DM_Testbig ");
		sb.append(" ,B_DM_Testsmall ");
		sb.append(" ,B_DM_Aca ");
		sb.append(" ,B_DM_Bcc ");
		sb.append(" ,B_DM_Positiveaccpra ");
		sb.append(" ,B_DM_Positiveaccpraodos ");
		sb.append(" ,B_DM_Negativeaccnra ");
		sb.append(" ,B_DM_Negativeaccnraodos ");
		sb.append(" ,B_DM_Addodos ");
		sb.append(" ,B_DM_Faramaleveln ");
		sb.append(" ,B_DM_Faramalbu ");
		sb.append(" ,B_DM_Faramabu ");
		sb.append(" ,B_DM_Faramalevelp ");
		sb.append(" ,B_DM_Faramalbd ");
		sb.append(" ,B_DM_Faramabd ");
		sb.append(" ,B_DM_Closeamaleveln ");
		sb.append(" ,B_DM_Closeamalbu ");
		sb.append(" ,B_DM_Closeamabu ");
		sb.append(" ,B_DM_Closeamalevelp ");
		sb.append(" ,B_DM_Closeamalbd ");
		sb.append(" ,B_DM_Closeamabd ");
		sb.append(" ) ");
		sb.append(" values ");
		sb.append(" ( ");
		sb.append("  ? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ,? ");
		sb.append(" ) ");
		
		params.add(Utility.getName(po.getBdmfarhetelevel()));
		params.add(Utility.getName(po.getBdmclosehetelevel()));
		params.add(Utility.getName(po.getBdmfarheteuprightness()));
		params.add(Utility.getName(po.getBdmcloseheteuprightness()));
		params.add(Utility.getName(po.getBdmtestbig()));
		params.add(Utility.getName(po.getBdmtestsmall()));
		params.add(Utility.getName(po.getBdmaca()));
		params.add(Utility.getName(po.getBdmbcc()));
		params.add(Utility.getName(po.getBdmpositiveaccpra()));
		params.add(Utility.getName(po.getBdmpositiveaccpraodos()));
		params.add(Utility.getName(po.getBdmnegativeaccnra()));
		params.add(Utility.getName(po.getBdmnegativeaccnraodos()));
		params.add(Utility.getName(po.getBdmaddodos()));
		params.add(Utility.getName(po.getBdmfaramaleveln()));
		params.add(Utility.getName(po.getBdmfaramalbu()));
		params.add(Utility.getName(po.getBdmfaramabu()));
		params.add(Utility.getName(po.getBdmfaramalevelp()));
		params.add(Utility.getName(po.getBdmfaramalbd()));
		params.add(Utility.getName(po.getBdmfaramabd()));
		params.add(Utility.getName(po.getBdmcloseamaleveln()));
		params.add(Utility.getName(po.getBdmcloseamalbu()));
		params.add(Utility.getName(po.getBdmcloseamabu()));
		params.add(Utility.getName(po.getBdmcloseamalevelp()));
		params.add(Utility.getName(po.getBdmcloseamalbd()));
		params.add(Utility.getName(po.getBdmcloseamabd()));

		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public DoubleEyeFunMendPo selectDoubleEyeFunMendPo() {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select ");
		sb.append(" B_DM_Farhetelevel  			as bdmfarhetelevel        	");
		sb.append(",B_DM_Closehetelevel  		as bdmclosehetelevel      	");
		sb.append(",B_DM_Farheteuprightness  	as bdmfarheteuprightness  	");
		sb.append(",B_DM_Closeheteuprightness  	as bdmcloseheteuprightness	");
		sb.append(",B_DM_Testbig  				as bdmtestbig             	");
		sb.append(",B_DM_Testsmall  			as bdmtestsmall           	");
		sb.append(",B_DM_Aca  					as bdmaca                 	");
		sb.append(",B_DM_Bcc  					as bdmbcc                 	");
		sb.append(",B_DM_Positiveaccpra  		as bdmpositiveaccpra      	");
		sb.append(",B_DM_Positiveaccpraodos  	as bdmpositiveaccpraodos  	");
		sb.append(",B_DM_Negativeaccnra  		as bdmnegativeaccnra      	");
		sb.append(",B_DM_Negativeaccnraodos  	as bdmnegativeaccnraodos  	");
		sb.append(",B_DM_Addodos  				as bdmaddodos             	");
		sb.append(",B_DM_Faramaleveln  			as bdmfaramaleveln        	");
		sb.append(",B_DM_Faramalbu  			as bdmfaramalbu           	");
		sb.append(",B_DM_Faramabu  				as bdmfaramabu            	");
		sb.append(",B_DM_Faramalevelp  			as bdmfaramalevelp        	");
		sb.append(",B_DM_Faramalbd  			as bdmfaramalbd           	");
		sb.append(",B_DM_Faramabd  				as bdmfaramabd            	");
		sb.append(",B_DM_Closeamaleveln  		as bdmcloseamaleveln      	");
		sb.append(",B_DM_Closeamalbu  			as bdmcloseamalbu         	");
		sb.append(",B_DM_Closeamabu  			as bdmcloseamabu          	");
		sb.append(",B_DM_Closeamalevelp  		as bdmcloseamalevelp      	");
		sb.append(",B_DM_Closeamalbd  			as bdmcloseamalbd         	");
		sb.append(",B_DM_Closeamabd  			as bdmcloseamabd          	");
		sb.append(" from B_DoubleEyeFunMend ");
		
		
		return (DoubleEyeFunMendPo) queryForObject(sb.toString(), params.toArray(),DoubleEyeFunMendPo.class);
	}
}
