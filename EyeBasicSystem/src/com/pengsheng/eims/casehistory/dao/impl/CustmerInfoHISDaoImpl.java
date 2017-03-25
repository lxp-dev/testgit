package com.pengsheng.eims.casehistory.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.casehistory.dao.CustmerInfoHISDao;
import com.pengsheng.eims.casehistory.persistence.CustmerInfoHISPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class CustmerInfoHISDaoImpl extends BaseJdbcDaoSupport implements CustmerInfoHISDao{


	public int queryCustHIS(CustmerInfoHISPo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select count(*) from S_HC_CO_HISCustOptometry ");
		buffer.append(" where S_HC_CO_Custmerid =  ?  ");
		buffer.append(" and S_HC_CO_Todayid     =  ?  ");
		
		params.add(Utility.getName(po.getShccocustmerid() ));
		params.add(Utility.getName(po.getShccotodayid()   ));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public void updateCustHIS(CustmerInfoHISPo po) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("update S_HC_CO_HISCustOptometry set   ");
		sb.append(" S_HC_CO_Optometrytime = getDate()    "); 
		sb.append(",S_HC_CO_Isopt   =     ?              "); 
		sb.append(" where  S_HC_CO_Todayid = ?           "); 
		sb.append(" and  S_HC_CO_Custmerid = ?           "); 
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getShccoisopt()   ));
		params.add(Utility.getName(po.getShccotodayid()   ));
		params.add(Utility.getName(po.getShccocustmerid() ));
		 
		getJdbcTemplate().update(sb.toString(), params.toArray());
	} 
	
	public void insertCustHIS(CustmerInfoHISPo po) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO S_HC_CO_HISCustOptometry (  ");
		sb.append(" S_HC_CO_ID                             "); 
		sb.append(",S_HC_CO_Custmerid                      "); 
		sb.append(",S_HC_CO_Optometrytime                  "); 
		sb.append(",S_HC_CO_Todayid                        "); 
		sb.append(",S_HC_CO_Isopt                          "); 
		sb.append(",S_HC_CO_Isrefund                       "); 
		sb.append(" )VALUES( ? ,? ,getDate() ,? , ? , ? )  ");
		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate()                   );
		params.add(Utility.getName(po.getShccocustmerid() ));
		params.add(Utility.getName(po.getShccotodayid()   ));
		params.add(Utility.getName(po.getShccoisopt()     ));
		params.add(Utility.getName(po.getShccoisrefund()  ));
		 
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public int queryTodayIDHIS(CustmerInfoHISPo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select count(*) from S_HC_CO_HISCustOptometry ");
		buffer.append(" where S_HC_CO_Custmerid =  ?  ");
		buffer.append(" and S_HC_CO_Isopt     =  '1'  ");
		
		params.add(Utility.getName(po.getShccotodayid()   ));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}




}
