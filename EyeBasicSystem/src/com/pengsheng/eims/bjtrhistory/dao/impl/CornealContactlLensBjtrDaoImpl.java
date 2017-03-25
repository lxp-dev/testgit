package com.pengsheng.eims.bjtrhistory.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.bjtrhistory.dao.CornealContactlLensBjtrDao;
import com.pengsheng.eims.bjtrhistory.persistence.CornealContactlLensPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class CornealContactlLensBjtrDaoImpl extends BaseJdbcDaoSupport implements CornealContactlLensBjtrDao
{
	public void cornealContactlLensInsert(CornealContactlLensPo cornealContactlLensPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO S_OP_CornealContactlLens (     ");
		
		sb.append(" S_OP_CL_ID                                "); 
		sb.append(",S_OP_CL_CustomerID                        "); 
		sb.append(",S_OP_CL_OptometryBasicID                  "); 
		sb.append(",S_OP_CL_OptometryID                       "); 
		sb.append(",S_OP_CL_TakeVAOD                          "); 
		sb.append(",S_OP_CL_TakeVAOS                          "); 
		sb.append(",S_OP_CL_TakeAddOD                         "); 
		sb.append(",S_OP_CL_TakeAddOS                         "); 
		sb.append(",S_OP_CL_TakeAddVAOD                       "); 
		sb.append(",S_OP_CL_TakeAddVAOS                       "); 
		sb.append(",S_OP_CL_WhereOD                           "); 
		sb.append(",S_OP_CL_WhereOS                           "); 
		sb.append(",S_OP_CL_MoveOD                            "); 
		sb.append(",S_OP_CL_MoveOS                            "); 
		sb.append(",S_OP_CL_DetakeVAOD                        "); 
		sb.append(",S_OP_CL_DetakeVAOS                        "); 
		sb.append(",S_OP_CL_DetakeAddOD                       "); 
		sb.append(",S_OP_CL_DetakeAddOS                       "); 
		sb.append(",S_OP_CL_DetakeAddVAOD                     "); 
		sb.append(",S_OP_CL_DetakeAddVAOS                     "); 
		sb.append(",S_OP_CL_EyeMOD                            "); 
		sb.append(",S_OP_CL_EyeMOS                            "); 
		sb.append(",S_OP_CL_EyeJmOD                           "); 
		sb.append(",S_OP_CL_EyeJmOS                           "); 
		sb.append(",S_OP_CL_OtherOD                           "); 
		sb.append(",S_OP_CL_OtherOS                           "); 
		sb.append(",S_OP_CL_RemarkOD                          "); 
		sb.append(",S_OP_CL_RemarkOS                          "); 
		sb.append(",S_OP_CL_HealthType                        "); 
		sb.append(",S_OP_CL_Health                            "); 

		
		sb.append(" )VALUES(								  ");
		sb.append("  ?,?,?,?,?,?,?,?,?,?				  	  ");
		sb.append(" ,?,?,?,?,?,?,?,?,?,?				  	  ");
		sb.append(" ,?,?,?,?,?,?,?,?,?,?				  	  ");
		sb.append(" )				  					  	  ");
		List<String> params = new ArrayList<String>();
		
		if(!"".equals(Utility.getName(cornealContactlLensPo.getSopclid()))){
			params.add(Utility.getName(cornealContactlLensPo.getSopclid()));
		}else{
			params.add(this.uuid.generate());
		}
		params.add(Utility.getName(cornealContactlLensPo.getSopclcustomerid()          ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcloptometrybasicid()    ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcloptometryid()         ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcltakevaod()            ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcltakevaos()            ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcltakeaddod()           ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcltakeaddos()           ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcltakeaddvaod()         ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcltakeaddvaos()         ));
		params.add(Utility.getName(cornealContactlLensPo.getSopclwhereod()             ));
		params.add(Utility.getName(cornealContactlLensPo.getSopclwhereos()             ));
		params.add(Utility.getName(cornealContactlLensPo.getSopclmoveod()              ));
		params.add(Utility.getName(cornealContactlLensPo.getSopclmoveos()              ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcldetakevaod()          ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcldetakevaos()          ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcldetakeaddod()         ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcldetakeaddos()         ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcldetakeaddvaod()       ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcldetakeaddvaos()       ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcleyemod()              ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcleyemos()              ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcleyejmod()             ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcleyejmos()             ));
		params.add(Utility.getName(cornealContactlLensPo.getSopclotherod()             ));
		params.add(Utility.getName(cornealContactlLensPo.getSopclotheros()             ));
		params.add(Utility.getName(cornealContactlLensPo.getSopclremarkod()            ));
		params.add(Utility.getName(cornealContactlLensPo.getSopclremarkos()            ));
		params.add(Utility.getName(cornealContactlLensPo.getSopclhealthtype()          ));
		params.add(Utility.getName(cornealContactlLensPo.getSopclhealth()              ));
		

		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public List<CornealContactlLensPo> getCornealContactlLensList(CornealContactlLensPo cornealContactlLensPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		
		sb.append(" S_OP_CL_ID                 as sopclid					          ");
		sb.append(",S_OP_CL_CustomerID         as sopclcustomerid                     ");
		sb.append(",S_OP_CL_OptometryBasicID   as sopcloptometrybasicid               ");
		sb.append(",S_OP_CL_OptometryID        as sopcloptometryid                    ");
		sb.append(",S_OP_CL_TakeVAOD           as sopcltakevaod                       ");
		sb.append(",S_OP_CL_TakeVAOS           as sopcltakevaos                       ");
		sb.append(",S_OP_CL_TakeAddOD          as sopcltakeaddod                      ");
		sb.append(",S_OP_CL_TakeAddOS          as sopcltakeaddos                      ");
		sb.append(",S_OP_CL_TakeAddVAOD        as sopcltakeaddvaod                    ");
		sb.append(",S_OP_CL_TakeAddVAOS        as sopcltakeaddvaos                    ");
		sb.append(",S_OP_CL_WhereOD            as sopclwhereod                        ");
		sb.append(",S_OP_CL_WhereOS            as sopclwhereos                        ");
		sb.append(",S_OP_CL_MoveOD             as sopclmoveod                         ");
		sb.append(",S_OP_CL_MoveOS             as sopclmoveos                         ");
		sb.append(",S_OP_CL_DetakeVAOD         as sopcldetakevaod                     ");
		sb.append(",S_OP_CL_DetakeVAOS         as sopcldetakevaos                     ");
		sb.append(",S_OP_CL_DetakeAddOD        as sopcldetakeaddod                    ");
		sb.append(",S_OP_CL_DetakeAddOS        as sopcldetakeaddos                    ");
		sb.append(",S_OP_CL_DetakeAddVAOD      as sopcldetakeaddvaod                  ");
		sb.append(",S_OP_CL_DetakeAddVAOS      as sopcldetakeaddvaos                  ");
		sb.append(",S_OP_CL_EyeMOD             as sopcleyemod                         ");
		sb.append(",S_OP_CL_EyeMOS             as sopcleyemos                         ");
		sb.append(",S_OP_CL_EyeJmOD            as sopcleyejmod                        ");
		sb.append(",S_OP_CL_EyeJmOS            as sopcleyejmos                        ");
		sb.append(",S_OP_CL_OtherOD            as sopclotherod                        ");
		sb.append(",S_OP_CL_OtherOS            as sopclotheros                        ");
		sb.append(",S_OP_CL_RemarkOD           as sopclremarkod                       ");
		sb.append(",S_OP_CL_RemarkOS           as sopclremarkos                       ");
		sb.append(",S_OP_CL_HealthType         as sopclhealthtype                     ");
		sb.append(",S_OP_CL_Health             as sopclhealth                         ");


		sb.append(" FROM S_OP_CornealContactlLens ");
		List<String> params = new ArrayList<String>();
		sb.append(" where S_OP_CL_OptometryID = ? ");
		params.add(cornealContactlLensPo.getSopcloptometryid());
		return this.queryForObjectList(sb.toString(), params.toArray(), CornealContactlLensPo.class);

	}

	
	public void cornealContactlLensUpdate(CornealContactlLensPo cornealContactlLensPo) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" UPdate S_OP_CornealContactlLens set ");
		
		sb.append(",S_OP_CL_TakeVAOD               = ?           "); 
		sb.append(",S_OP_CL_TakeVAOS               = ?           "); 
		sb.append(",S_OP_CL_TakeAddOD              = ?           "); 
		sb.append(",S_OP_CL_TakeAddOS              = ?           "); 
		sb.append(",S_OP_CL_TakeAddVAOD            = ?           "); 
		sb.append(",S_OP_CL_TakeAddVAOS            = ?           "); 
		sb.append(",S_OP_CL_WhereOD                = ?           "); 
		sb.append(",S_OP_CL_WhereOS                = ?           "); 
		sb.append(",S_OP_CL_MoveOD                 = ?           "); 
		sb.append(",S_OP_CL_MoveOS                 = ?           "); 
		sb.append(",S_OP_CL_DetakeVAOD             = ?           "); 
		sb.append(",S_OP_CL_DetakeVAOS             = ?           "); 
		sb.append(",S_OP_CL_DetakeAddOD            = ?           "); 
		sb.append(",S_OP_CL_DetakeAddOS            = ?           "); 
		sb.append(",S_OP_CL_DetakeAddVAOD          = ?           "); 
		sb.append(",S_OP_CL_DetakeAddVAOS          = ?           "); 
		sb.append(",S_OP_CL_EyeMOD                 = ?           "); 
		sb.append(",S_OP_CL_EyeMOS                 = ?           "); 
		sb.append(",S_OP_CL_EyeJmOD                = ?           "); 
		sb.append(",S_OP_CL_EyeJmOS                = ?           "); 
		sb.append(",S_OP_CL_OtherOD                = ?           "); 
		sb.append(",S_OP_CL_OtherOS                = ?           "); 
		sb.append(",S_OP_CL_RemarkOD               = ?           "); 
		sb.append(",S_OP_CL_RemarkOS               = ?           "); 
		sb.append(",S_OP_CL_HealthType             = ?           "); 
		sb.append(",S_OP_CL_Health                 = ?           "); 
		
		sb.append(" where S_OP_CL_OptometryID = ? ");
		
		
		params.add(Utility.getName(cornealContactlLensPo.getSopcltakevaod()            ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcltakevaos()            ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcltakeaddod()           ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcltakeaddos()           ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcltakeaddvaod()         ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcltakeaddvaos()         ));
		params.add(Utility.getName(cornealContactlLensPo.getSopclwhereod()             ));
		params.add(Utility.getName(cornealContactlLensPo.getSopclwhereos()             ));
		params.add(Utility.getName(cornealContactlLensPo.getSopclmoveod()              ));
		params.add(Utility.getName(cornealContactlLensPo.getSopclmoveos()              ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcldetakevaod()          ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcldetakevaos()          ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcldetakeaddod()         ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcldetakeaddos()         ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcldetakeaddvaod()       ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcldetakeaddvaos()       ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcleyemod()              ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcleyemos()              ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcleyejmod()             ));
		params.add(Utility.getName(cornealContactlLensPo.getSopcleyejmos()             ));
		params.add(Utility.getName(cornealContactlLensPo.getSopclotherod()             ));
		params.add(Utility.getName(cornealContactlLensPo.getSopclotheros()             ));
		params.add(Utility.getName(cornealContactlLensPo.getSopclremarkod()            ));
		params.add(Utility.getName(cornealContactlLensPo.getSopclremarkos()            ));
		params.add(Utility.getName(cornealContactlLensPo.getSopclhealthtype()          ));
		params.add(Utility.getName(cornealContactlLensPo.getSopclhealth()              ));
		
		params.add(Utility.getName(cornealContactlLensPo.getSopcloptometryid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	public void cornealContactlLensDelete(CornealContactlLensPo cornealContactlLensPo){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from S_OP_CornealContactlLens where S_OP_CL_OptometryID = ? ");
		
		params.add(cornealContactlLensPo.getSopcloptometryid());
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}


	public int getCornealContactlLensCount(OptometryPo optometryPo) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(S_OP_CL_ID) from S_OP_CornealContactlLens where S_OP_CL_OptometryID=?");
		
		params.add(optometryPo.getSopoyoptometryid());
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	public void cornealContactlLensprint(String id){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		//sb.append("update S_OP_CornealContactlLens set S_OP_IP_PrintFlag = '1' where S_OP_CL_OptometryID = ?");
		
		params.add(id);
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void updateCornealContactlLensFlag(String id){
		StringBuffer sb = new StringBuffer();
		sb.append("update S_OP_Optometry set S_OP_OY_Flag = '1' where S_OP_OY_OptometryID = ?");
		List<String> params = new ArrayList<String>();
		params.add(id);
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public CustomerInfoPo getCustomerInfo(String id){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 S_OP_IP_CustomerID as smecicustomerid,S_ME_CI_Name as smeciname,S_ME_CI_Sex as smecisex,convert(varchar(10),S_OP_OY_Time,120) as smecioptometrydate,S_OP_IP_SecCheckDate as smecifurtherdate,isnull(B_DP_DepartmentName,'') as smecioptometrydpt,isnull(B_DP_Phone,'') as smeciphone from S_OP_CornealContactlLens  ");
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
