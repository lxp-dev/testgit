package com.pengsheng.eims.casehistory.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.casehistory.dao.ContactGlassNDao;
import com.pengsheng.eims.casehistory.persistence.ContactGlassPo;
import com.pengsheng.eims.casehistory.persistence.OptometryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ContactGlassNDaoImpl extends BaseJdbcDaoSupport implements ContactGlassNDao
{
	public void contactGlassInsert(ContactGlassPo contactGlassPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO S_OP_ContactGlass ");
		
		sb.append("(S_OP_CG_ID ");
		sb.append(",S_OP_CG_CustomerID ");
		sb.append(",S_OP_CG_OptometryBasicID ");
		sb.append(",S_OP_CG_OptometryID ");
		sb.append(",S_OP_CG_TryIn ");
		sb.append(",S_OP_CG_Type ");
		sb.append(",S_OP_CG_BrandOD ");
		sb.append(",S_OP_CG_BrandOS ");
		sb.append(",S_OP_CG_BaseCurveOD ");
		sb.append(",S_OP_CG_BaseCurveOS ");
		sb.append(",S_OP_CG_DiopterOD ");
		sb.append(",S_OP_CG_DiopterOS ");
		sb.append(",S_OP_CG_DegradeOD ");
		sb.append(",S_OP_CG_DegradeOS ");
		sb.append(",S_OP_CG_DiameterOD ");
		sb.append(",S_OP_CG_DiameterOS ");
		sb.append(",S_OP_CG_AdditionalOD ");
		sb.append(",S_OP_CG_AdditionalOS ");
		sb.append(",S_OP_CG_LocationOD ");
		sb.append(",S_OP_CG_LocationOS ");
		sb.append(",S_OP_CG_ActivityOD ");
		sb.append(",S_OP_CG_ActivityOS ");
		sb.append(",S_OP_CG_ZeroDifferenceOD ");
		sb.append(",S_OP_CG_ZeroDifferenceOS ");
		sb.append(",S_OP_CG_SuggestionsOD ");
		sb.append(",S_OP_CG_SuggestionsOS ");
		sb.append(",S_OP_CG_VAOD ");
		sb.append(",S_OP_CG_VAOS ");
		sb.append(",S_OP_CG_CYLOD ");
		sb.append(",S_OP_CG_CYLOS ");
		sb.append(",S_OP_CG_AXEOD ");
		sb.append(",S_OP_CG_AXEOS ");
		sb.append(",S_OP_CG_Remark ");
		sb.append(" )VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		
		List<String> params = new ArrayList<String>();
		
		if(!"".equals(Utility.getName(contactGlassPo.getSopcgid()))){
			params.add(Utility.getName(contactGlassPo.getSopcgid()));
		}else{
			params.add(this.uuid.generate());
		}

		params.add(Utility.getName(contactGlassPo.getSopcgcustomerid()));
		params.add(Utility.getName(contactGlassPo.getSopcgoptometrybasicid()));
		params.add(Utility.getName(contactGlassPo.getSopcgoptometryid()));
		params.add(Utility.getName(contactGlassPo.getSopcgtryin()));
		params.add(Utility.getName(contactGlassPo.getSopcgtype()));
		params.add(Utility.getName(contactGlassPo.getSopcgbrandod()));
		params.add(Utility.getName(contactGlassPo.getSopcgbrandos()));
		params.add(Utility.getName(contactGlassPo.getSopcgbasecurveod()));
		params.add(Utility.getName(contactGlassPo.getSopcgbasecurveos()));
		params.add(Utility.getName(contactGlassPo.getSopcgdiopterod()));
		params.add(Utility.getName(contactGlassPo.getSopcgdiopteros()));
		params.add(Utility.getName(contactGlassPo.getSopcgdegradeod()));
		params.add(Utility.getName(contactGlassPo.getSopcgdegradeos()));
		params.add(Utility.getName(contactGlassPo.getSopcgdiameterod()));
		params.add(Utility.getName(contactGlassPo.getSopcgdiameteros()));
		params.add(Utility.getName(contactGlassPo.getSopcgadditionalod()));
		params.add(Utility.getName(contactGlassPo.getSopcgadditionalos()));
		params.add(Utility.getName(contactGlassPo.getSopcglocationod()));
		params.add(Utility.getName(contactGlassPo.getSopcglocationos()));
		params.add(Utility.getName(contactGlassPo.getSopcgactivityod()));
		params.add(Utility.getName(contactGlassPo.getSopcgactivityos()));
		params.add(Utility.getName(contactGlassPo.getSopcgzerodifferenceod()));
		params.add(Utility.getName(contactGlassPo.getSopcgzerodifferenceos()));
		params.add(Utility.getName(contactGlassPo.getSopcgsuggestionsod()));
		params.add(Utility.getName(contactGlassPo.getSopcgsuggestionsos()));
		params.add(Utility.getName(contactGlassPo.getSopcgvaod()));
		params.add(Utility.getName(contactGlassPo.getSopcgvaos()));
		params.add(Utility.getName(contactGlassPo.getSopcgcylod()));
		params.add(Utility.getName(contactGlassPo.getSopcgcylos()));
		params.add(Utility.getName(contactGlassPo.getSopcgaxeod()));
		params.add(Utility.getName(contactGlassPo.getSopcgaxeos()));
		params.add(Utility.getName(contactGlassPo.getSopcgremark()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public List<ContactGlassPo> getContactGlassList(ContactGlassPo contactGlassPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT S_OP_CG_ID as sopcgid ,");
		sb.append("S_OP_CG_CustomerID as sopcgcustomerid ,");
		sb.append("S_OP_CG_OptometryBasicID as   sopcgoptometrybasicid ,");
		sb.append("S_OP_CG_OptometryID as sopcgoptometryid, ");
		sb.append("S_OP_CG_TryIn as  sopcgtryin, ");
		sb.append("S_OP_CG_Type as sopcgtype ,");
		sb.append("S_OP_CG_BrandOD as sopcgbrandod ,");
		sb.append("S_OP_CG_BrandOS as sopcgbrandos, ");
		sb.append("S_OP_CG_BaseCurveOD as sopcgbasecurveod, ");
		sb.append("S_OP_CG_BaseCurveOS as sopcgbasecurveos ,");
		sb.append("S_OP_CG_DiopterOD as sopcgdiopterod ,");
		sb.append("S_OP_CG_DiopterOS as sopcgdiopteros, ");
		sb.append("S_OP_CG_DegradeOD as sopcgdegradeod ,");
		sb.append("S_OP_CG_DegradeOS as sopcgdegradeos ,");
		sb.append("S_OP_CG_DiameterOD as sopcgdiameterod ,");
		sb.append("S_OP_CG_DiameterOS as   sopcgdiameteros, ");
		sb.append("S_OP_CG_AdditionalOD as   sopcgadditionalod, ");
		sb.append("S_OP_CG_AdditionalOS as sopcgadditionalos ,");
		sb.append("S_OP_CG_LocationOD as sopcglocationod ,");
		sb.append("S_OP_CG_LocationOS as sopcglocationos ,");
		sb.append("S_OP_CG_ActivityOD as sopcgactivityod ,");
		sb.append("S_OP_CG_ActivityOS as sopcgactivityos ,");
		sb.append("S_OP_CG_ZeroDifferenceOD as sopcgzerodifferenceod, ");
		sb.append("S_OP_CG_ZeroDifferenceOS as sopcgzerodifferenceos ,");
		sb.append("S_OP_CG_SuggestionsOD as sopcgsuggestionsod ,");
		sb.append("S_OP_CG_SuggestionsOS as  sopcgsuggestionsos ");
		sb.append(",S_OP_CG_VAOD as sopcgvaod");
		sb.append(",S_OP_CG_VAOS as sopcgvaos");
		sb.append(",S_OP_CG_CYLOD as sopcgcylod");
		sb.append(",S_OP_CG_CYLOS as sopcgcylos");
		sb.append(",S_OP_CG_AXEOD as sopcgaxeod");
		sb.append(",S_OP_CG_AXEOS as sopcgaxeos");
		sb.append(",S_OP_CG_Remark as sopcgremark");
		sb.append(" FROM S_OP_ContactGlass ");
		List<String> params = new ArrayList<String>();
		sb.append(" where S_OP_CG_OptometryID= ? order by S_OP_CG_Type");
		params.add(contactGlassPo.getSopcgoptometryid());
		return this.queryForObjectList(sb.toString(), params.toArray(), ContactGlassPo.class);

	}

	
	public void contactGlassUpdate(ContactGlassPo contactGlassPo) 
	{
		StringBuffer sb = new StringBuffer();
		sb.append("update S_OP_ContactGlass ");
		sb.append("set S_OP_CG_TryIn =?");
		sb.append(",S_OP_CG_Type =?");
		sb.append(",S_OP_CG_BrandOD =?");
		sb.append(",S_OP_CG_BrandOS =?");
		sb.append(",S_OP_CG_BaseCurveOD =?");
		sb.append(",S_OP_CG_BaseCurveOS =?");
		sb.append(",S_OP_CG_DiopterOD =?");
		sb.append(",S_OP_CG_DiopterOS =?");
		sb.append(",S_OP_CG_DegradeOD =?");
		sb.append(",S_OP_CG_DegradeOS =?");
		sb.append(",S_OP_CG_DiameterOD =?");
		sb.append(",S_OP_CG_DiameterOS =?");
		sb.append(",S_OP_CG_AdditionalOD =?");
		sb.append(",S_OP_CG_AdditionalOS =?");
		sb.append(",S_OP_CG_LocationOD =?");
		sb.append(",S_OP_CG_LocationOS =?");
		sb.append(",S_OP_CG_ActivityOD =?");
		sb.append(",S_OP_CG_ActivityOS =?");
		sb.append(",S_OP_CG_ZeroDifferenceOD =?");
		sb.append(",S_OP_CG_ZeroDifferenceOS =?");
		sb.append(",S_OP_CG_SuggestionsOD =?");
		sb.append(",S_OP_CG_SuggestionsOS =?");
		sb.append(",S_OP_CG_VAOD =? ");
		sb.append(",S_OP_CG_VAOS =? ");
		sb.append(",S_OP_CG_CYLOD =? ");
		sb.append(",S_OP_CG_CYLOS =? ");
		sb.append(",S_OP_CG_AXEOD =? ");
		sb.append(",S_OP_CG_AXEOS =? ");
		sb.append(",S_OP_CG_Remark =? ");
		sb.append(" where S_OP_CG_OptometryID=?");
		List<String> params = new ArrayList<String>();
		
		params.add(Utility.getName(contactGlassPo.getSopcgtryin()));
		params.add(Utility.getName(contactGlassPo.getSopcgtype()));
		params.add(Utility.getName(contactGlassPo.getSopcgbrandod()));
		params.add(Utility.getName(contactGlassPo.getSopcgbrandos()));
		params.add(Utility.getName(contactGlassPo.getSopcgbasecurveod()));
		params.add(Utility.getName(contactGlassPo.getSopcgbasecurveos()));
		params.add(Utility.getName(contactGlassPo.getSopcgdiopterod()));
		params.add(Utility.getName(contactGlassPo.getSopcgdiopteros()));
		params.add(Utility.getName(contactGlassPo.getSopcgdegradeod()));
		params.add(Utility.getName(contactGlassPo.getSopcgdegradeos()));
		params.add(Utility.getName(contactGlassPo.getSopcgdiameterod()));
		params.add(Utility.getName(contactGlassPo.getSopcgdiameteros()));
		params.add(Utility.getName(contactGlassPo.getSopcgadditionalod()));
		params.add(Utility.getName(contactGlassPo.getSopcgadditionalos()));
		params.add(Utility.getName(contactGlassPo.getSopcglocationod()));
		params.add(Utility.getName(contactGlassPo.getSopcglocationos()));
		params.add(Utility.getName(contactGlassPo.getSopcgactivityod()));
		params.add(Utility.getName(contactGlassPo.getSopcgactivityos()));
		params.add(Utility.getName(contactGlassPo.getSopcgzerodifferenceod()));
		params.add(Utility.getName(contactGlassPo.getSopcgzerodifferenceos()));
		params.add(Utility.getName(contactGlassPo.getSopcgsuggestionsod()));
		params.add(Utility.getName(contactGlassPo.getSopcgsuggestionsos()));
		params.add(Utility.getName(contactGlassPo.getSopcgvaod()));
		params.add(Utility.getName(contactGlassPo.getSopcgvaos()));
		params.add(Utility.getName(contactGlassPo.getSopcgcylod()));
		params.add(Utility.getName(contactGlassPo.getSopcgcylos()));
		params.add(Utility.getName(contactGlassPo.getSopcgaxeod()));
		params.add(Utility.getName(contactGlassPo.getSopcgaxeos()));
		params.add(Utility.getName(contactGlassPo.getSopcgremark()));
		
		params.add(Utility.getName(contactGlassPo.getSopcgoptometryid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public void contactGlassDelete(ContactGlassPo contactGlassPo){
		StringBuffer sb = new StringBuffer();
		sb.append("delete from S_OP_ContactGlass where S_OP_CG_OptometryID=?");
		List<String> params = new ArrayList<String>();
		params.add(contactGlassPo.getSopcgoptometryid());
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}


	public int getContactGlassCount(OptometryPo optometryPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(S_OP_CG_ID) from S_OP_ContactGlass where S_OP_CG_OptometryID= ? ");
		List<String> params = new ArrayList<String>();
		params.add(optometryPo.getSopoyoptometryid());
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
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
