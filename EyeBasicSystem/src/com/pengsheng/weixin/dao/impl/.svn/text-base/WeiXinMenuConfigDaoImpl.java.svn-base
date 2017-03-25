package com.pengsheng.weixin.dao.impl;

import java.util.List;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinMenuConfigDao;
import com.pengsheng.weixin.persistence.WeiXinMenuPo;
import com.pengsheng.weixin.persistence.WeiXinMenuTypePo;

public class WeiXinMenuConfigDaoImpl extends BaseJdbcDaoSupport implements WeiXinMenuConfigDao{

	public WeiXinMenuPo getWeiXinMenuPo() {
		StringBuffer  sb = new StringBuffer();
		
		sb.append("SELECT W_MC_ID1              AS wmcid1, ");
		sb.append("       W_MC_Name1            AS wmcname1, ");
		sb.append("       W_MC_ID2            AS wmcid2, ");
		sb.append("       W_MC_Name2            AS wmcname2, ");
		sb.append("       W_MC_ID3            AS wmcid3, ");
		sb.append("       W_MC_Name3            AS wmcname3, ");		
		sb.append("       W_MC_ID11            AS wmcid11, ");
		sb.append("       W_MC_Name11            AS wmcname11, ");
		sb.append("       W_MC_ID12            AS wmcid12, ");
		sb.append("       W_MC_Name12            AS wmcname12, ");
		sb.append("       W_MC_ID13            AS wmcid13, ");
		sb.append("       W_MC_Name13            AS wmcname13, ");
		sb.append("       W_MC_ID14            AS wmcid14, ");
		sb.append("       W_MC_Name14            AS wmcname14, ");
		sb.append("       W_MC_ID15            AS wmcid15, ");
		sb.append("       W_MC_Name15            AS wmcname15, ");	
		sb.append("       W_MC_ID21            AS wmcid21, ");
		sb.append("       W_MC_Name21            AS wmcname21, ");
		sb.append("       W_MC_ID22            AS wmcid22, ");
		sb.append("       W_MC_Name22            AS wmcname22, ");
		sb.append("       W_MC_ID23            AS wmcid23, ");
		sb.append("       W_MC_Name23            AS wmcname23, ");
		sb.append("       W_MC_ID24            AS wmcid24, ");
		sb.append("       W_MC_Name24            AS wmcname24, ");
		sb.append("       W_MC_ID25            AS wmcid25, ");
		sb.append("       W_MC_Name25            AS wmcname25, ");		
		sb.append("       W_MC_ID31            AS wmcid31, ");
		sb.append("       W_MC_Name31            AS wmcname31, ");
		sb.append("       W_MC_ID32            AS wmcid32, ");
		sb.append("       W_MC_Name32            AS wmcname32, ");
		sb.append("       W_MC_ID33            AS wmcid33, ");
		sb.append("       W_MC_Name33            AS wmcname33, ");
		sb.append("       W_MC_ID34            AS wmcid34, ");
		sb.append("       W_MC_Name34            AS wmcname34, ");
		sb.append("       W_MC_ID35            AS wmcid35, ");
		sb.append("       W_MC_Name35            AS wmcname35, ");
	
		sb.append("       isnull(W_MC_Flag1,'0')             AS wmcflag1, ");
		sb.append("       isnull(W_MC_Flag11,'0')            AS wmcflag11, ");
		sb.append("       isnull(W_MC_Flag12,'0')            AS wmcflag12, ");
		sb.append("       isnull(W_MC_Flag13,'0')            AS wmcflag13, ");
		sb.append("       isnull(W_MC_Flag14,'0')            AS wmcflag14, ");
		sb.append("       isnull(W_MC_Flag15,'0')            AS wmcflag15, ");
		sb.append("       isnull(W_MC_Flag2,'0')             AS wmcflag2, ");
		sb.append("       isnull(W_MC_Flag21,'0')            AS wmcflag21, ");
		sb.append("       isnull(W_MC_Flag22,'0')            AS wmcflag22, ");
		sb.append("       isnull(W_MC_Flag23,'0')            AS wmcflag23, ");
		sb.append("       isnull(W_MC_Flag24,'0')            AS wmcflag24, ");
		sb.append("       isnull(W_MC_Flag25,'0')            AS wmcflag25, ");
		sb.append("       isnull(W_MC_Flag3,'0')             AS wmcflag3, ");
		sb.append("       isnull(W_MC_Flag31,'0')            AS wmcflag31, ");
		sb.append("       isnull(W_MC_Flag32,'0')            AS wmcflag32, ");
		sb.append("       isnull(W_MC_Flag33,'0')            AS wmcflag33, ");
		sb.append("       isnull(W_MC_Flag34,'0')            AS wmcflag34, ");
		sb.append("       isnull(W_MC_Flag35,'0')            AS wmcflag35, ");
		
		sb.append("       isnull(W_MC_TypeID1,'0')             AS wmctypeid1, ");
		sb.append("       isnull(W_MC_TypeID11,'0')            AS wmctypeid11, ");
		sb.append("       isnull(W_MC_TypeID12,'0')            AS wmctypeid12, ");
		sb.append("       isnull(W_MC_TypeID13,'0')            AS wmctypeid13, ");
		sb.append("       isnull(W_MC_TypeID14,'0')            AS wmctypeid14, ");
		sb.append("       isnull(W_MC_TypeID15,'0')            AS wmctypeid15, ");
		sb.append("       isnull(W_MC_TypeID2,'0')             AS wmctypeid2, ");
		sb.append("       isnull(W_MC_TypeID21,'0')            AS wmctypeid21, ");
		sb.append("       isnull(W_MC_TypeID22,'0')            AS wmctypeid22, ");
		sb.append("       isnull(W_MC_TypeID23,'0')            AS wmctypeid23, ");
		sb.append("       isnull(W_MC_TypeID24,'0')            AS wmctypeid24, ");
		sb.append("       isnull(W_MC_TypeID25,'0')            AS wmctypeid25, ");
		sb.append("       isnull(W_MC_TypeID3,'0')             AS wmctypeid3, ");
		sb.append("       isnull(W_MC_TypeID31,'0')            AS wmctypeid31, ");
		sb.append("       isnull(W_MC_TypeID32,'0')            AS wmctypeid32, ");
		sb.append("       isnull(W_MC_TypeID33,'0')            AS wmctypeid33, ");
		sb.append("       isnull(W_MC_TypeID34,'0')            AS wmctypeid34, ");
		sb.append("       isnull(W_MC_TypeID35,'0')            AS wmctypeid35, ");
		
		sb.append("       isnull(W_MC_Content1,'')             AS wmccontent1, ");
		sb.append("       isnull(W_MC_Content11,'')            AS wmccontent11, ");
		sb.append("       isnull(W_MC_Content12,'')            AS wmccontent12, ");
		sb.append("       isnull(W_MC_Content13,'')            AS wmccontent13, ");
		sb.append("       isnull(W_MC_Content14,'')            AS wmccontent14, ");
		sb.append("       isnull(W_MC_Content15,'')            AS wmccontent15, ");
		sb.append("       isnull(W_MC_Content2,'')             AS wmccontent2, ");
		sb.append("       isnull(W_MC_Content21,'')            AS wmccontent21, ");
		sb.append("       isnull(W_MC_Content22,'')            AS wmccontent22, ");
		sb.append("       isnull(W_MC_Content23,'')            AS wmccontent23, ");
		sb.append("       isnull(W_MC_Content24,'')            AS wmccontent24, ");
		sb.append("       isnull(W_MC_Content25,'')            AS wmccontent25, ");
		sb.append("       isnull(W_MC_Content3,'')             AS wmccontent3, ");
		sb.append("       isnull(W_MC_Content31,'')            AS wmccontent31, ");
		sb.append("       isnull(W_MC_Content32,'')            AS wmccontent32, ");
		sb.append("       isnull(W_MC_Content33,'')            AS wmccontent33, ");
		sb.append("       isnull(W_MC_Content34,'')            AS wmccontent34, ");
		sb.append("       isnull(W_MC_Content35,'')            AS wmccontent35 ");		
		
		sb.append("       FROM   W_Menu_Config ");
		sb.append("       WHERE  1 = 1 ");
		
		return (WeiXinMenuPo) queryForObject(sb.toString(), null, WeiXinMenuPo.class);
	}

	public void updateWeiXinMenuPo(WeiXinMenuPo po) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();

		buffer.append("update W_Menu_Config set ");
		buffer.append("W_MC_Name1 = '"+ Utility.getName(po.getWmcname1()) +"',");
		buffer.append("W_MC_Name11 = '"+ Utility.getName(po.getWmcname11()) +"',");
		buffer.append("W_MC_Name12 = '"+ Utility.getName(po.getWmcname12()) +"',");
		buffer.append("W_MC_Name13 = '"+ Utility.getName(po.getWmcname13()) +"',");
		buffer.append("W_MC_Name14 = '"+ Utility.getName(po.getWmcname14()) +"',");
		buffer.append("W_MC_Name15 = '"+ Utility.getName(po.getWmcname15()) +"',");
		buffer.append("W_MC_Name2 = '"+ Utility.getName(po.getWmcname2()) +"',");
		buffer.append("W_MC_Name21 = '"+ Utility.getName(po.getWmcname21()) +"',");
		buffer.append("W_MC_Name22 = '"+ Utility.getName(po.getWmcname22()) +"',");
		buffer.append("W_MC_Name23 = '"+ Utility.getName(po.getWmcname23()) +"',");
		buffer.append("W_MC_Name24 = '"+ Utility.getName(po.getWmcname24()) +"',");
		buffer.append("W_MC_Name25 = '"+ Utility.getName(po.getWmcname25()) +"',");
		buffer.append("W_MC_Name3 = '"+ Utility.getName(po.getWmcname3()) +"',");
		buffer.append("W_MC_Name31 = '"+ Utility.getName(po.getWmcname31()) +"',");
		buffer.append("W_MC_Name32 = '"+ Utility.getName(po.getWmcname32()) +"',");
		buffer.append("W_MC_Name33 = '"+ Utility.getName(po.getWmcname33()) +"',");
		buffer.append("W_MC_Name34 = '"+ Utility.getName(po.getWmcname34()) +"',");
		buffer.append("W_MC_Name35 = '"+ Utility.getName(po.getWmcname35()) +"',");	
		
		buffer.append("W_MC_Flag1 = '"+ Utility.getName(po.getWmcflag1()) +"',");
		buffer.append("W_MC_Flag11 = '"+ Utility.getName(po.getWmcflag11()) +"',");
		buffer.append("W_MC_Flag12 = '"+ Utility.getName(po.getWmcflag12()) +"',");
		buffer.append("W_MC_Flag13 = '"+ Utility.getName(po.getWmcflag13()) +"',");
		buffer.append("W_MC_Flag14 = '"+ Utility.getName(po.getWmcflag14()) +"',");
		buffer.append("W_MC_Flag15 = '"+ Utility.getName(po.getWmcflag15()) +"',");
		buffer.append("W_MC_Flag2 = '"+ Utility.getName(po.getWmcflag2()) +"',");
		buffer.append("W_MC_Flag21 = '"+ Utility.getName(po.getWmcflag21()) +"',");
		buffer.append("W_MC_Flag22 = '"+ Utility.getName(po.getWmcflag22()) +"',");
		buffer.append("W_MC_Flag23 = '"+ Utility.getName(po.getWmcflag23()) +"',");
		buffer.append("W_MC_Flag24 = '"+ Utility.getName(po.getWmcflag24()) +"',");
		buffer.append("W_MC_Flag25 = '"+ Utility.getName(po.getWmcflag25()) +"',");
		buffer.append("W_MC_Flag3 = '"+ Utility.getName(po.getWmcflag3()) +"',");
		buffer.append("W_MC_Flag31 = '"+ Utility.getName(po.getWmcflag31()) +"',");
		buffer.append("W_MC_Flag32 = '"+ Utility.getName(po.getWmcflag32()) +"',");
		buffer.append("W_MC_Flag33 = '"+ Utility.getName(po.getWmcflag33()) +"',");
		buffer.append("W_MC_Flag34 = '"+ Utility.getName(po.getWmcflag34()) +"',");
		buffer.append("W_MC_Flag35 = '"+ Utility.getName(po.getWmcflag35()) +"'");
		
		getJdbcTemplate().update(buffer.toString());
	}

	public void updateWeiXinMenuDetail(String menuID,String typeID,String weburl) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("update W_Menu_Config set ");
		if(menuID.equals("1")){
			buffer.append("W_MC_TypeID1 = '"+ typeID +"',W_MC_Content1 = '"+ weburl +"'");
		}else if(menuID.equals("11")){
			buffer.append("W_MC_TypeID11 = '"+ typeID +"',W_MC_Content11 = '"+ weburl +"'");
		}else if(menuID.equals("12")){
			buffer.append("W_MC_TypeID12 = '"+ typeID +"',W_MC_Content12 = '"+ weburl +"'");
		}else if(menuID.equals("13")){
			buffer.append("W_MC_TypeID13 = '"+ typeID +"',W_MC_Content13 = '"+ weburl +"'");
		}else if(menuID.equals("14")){
			buffer.append("W_MC_TypeID14 = '"+ typeID +"',W_MC_Content14 = '"+ weburl +"'");
		}else if(menuID.equals("15")){
			buffer.append("W_MC_TypeID15 = '"+ typeID +"',W_MC_Content15 = '"+ weburl +"'");
		}else if(menuID.equals("2")){
			buffer.append("W_MC_TypeID2 = '"+ typeID +"',W_MC_Content2 = '"+ weburl +"'");
		}else if(menuID.equals("21")){
			buffer.append("W_MC_TypeID21 = '"+ typeID +"',W_MC_Content21 = '"+ weburl +"'");
		}else if(menuID.equals("22")){
			buffer.append("W_MC_TypeID22 = '"+ typeID +"',W_MC_Content22 = '"+ weburl +"'");
		}else if(menuID.equals("23")){
			buffer.append("W_MC_TypeID23 = '"+ typeID +"',W_MC_Content23 = '"+ weburl +"'");
		}else if(menuID.equals("24")){
			buffer.append("W_MC_TypeID24 = '"+ typeID +"',W_MC_Content24 = '"+ weburl +"'");
		}else if(menuID.equals("25")){
			buffer.append("W_MC_TypeID25 = '"+ typeID +"',W_MC_Content25 = '"+ weburl +"'");
		}else if(menuID.equals("3")){
			buffer.append("W_MC_TypeID3 = '"+ typeID +"',W_MC_Content3 = '"+ weburl +"'");
		}else if(menuID.equals("31")){
			buffer.append("W_MC_TypeID31 = '"+ typeID +"',W_MC_Content31 = '"+ weburl +"'");
		}else if(menuID.equals("32")){
			buffer.append("W_MC_TypeID32 = '"+ typeID +"',W_MC_Content32 = '"+ weburl +"'");
		}else if(menuID.equals("33")){
			buffer.append("W_MC_TypeID33 = '"+ typeID +"',W_MC_Content33 = '"+ weburl +"'");
		}else if(menuID.equals("34")){
			buffer.append("W_MC_TypeID34 = '"+ typeID +"',W_MC_Content34 = '"+ weburl +"'");
		}else if(menuID.equals("35")){
			buffer.append("W_MC_TypeID35 = '"+ typeID +"',W_MC_Content35 = '"+ weburl +"'");
		}
		
		getJdbcTemplate().update(buffer.toString());
	}

	public void insertWeiXinMenuPo(WeiXinMenuPo po) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("INSERT INTO W_Menu_Config ");
		buffer.append("           (W_MC_ID1 ");
		buffer.append("            ,W_MC_Name1 ");
		buffer.append("            ,W_MC_ID2 ");
		buffer.append("            ,W_MC_Name2 ");
		buffer.append("            ,W_MC_ID3 ");
		buffer.append("            ,W_MC_Name3 ");
		buffer.append("            ,W_MC_ID11 ");
		buffer.append("            ,W_MC_Name11 ");
		buffer.append("            ,W_MC_ID12 ");
		buffer.append("            ,W_MC_Name12 ");
		buffer.append("            ,W_MC_ID13 ");
		buffer.append("            ,W_MC_Name13 ");
		buffer.append("            ,W_MC_ID14 ");
		buffer.append("            ,W_MC_Name14 ");
		buffer.append("            ,W_MC_ID15 ");
		buffer.append("            ,W_MC_Name15 ");
		buffer.append("            ,W_MC_ID21 ");
		buffer.append("            ,W_MC_Name21 ");
		buffer.append("            ,W_MC_ID22 ");
		buffer.append("            ,W_MC_Name22 ");
		buffer.append("            ,W_MC_ID23 ");
		buffer.append("            ,W_MC_Name23 ");
		buffer.append("            ,W_MC_ID24 ");
		buffer.append("            ,W_MC_Name24 ");
		buffer.append("            ,W_MC_ID25 ");
		buffer.append("            ,W_MC_Name25 ");
		buffer.append("            ,W_MC_ID31 ");
		buffer.append("            ,W_MC_Name31 ");
		buffer.append("            ,W_MC_ID32 ");
		buffer.append("            ,W_MC_Name32 ");
		buffer.append("            ,W_MC_ID33 ");
		buffer.append("            ,W_MC_Name33 ");
		buffer.append("            ,W_MC_ID34 ");
		buffer.append("            ,W_MC_Name34 ");
		buffer.append("            ,W_MC_ID35 ");
		buffer.append("            ,W_MC_Name35 ");
		buffer.append("            ,W_MC_Flag1 ");
		buffer.append("            ,W_MC_Flag11 ");
		buffer.append("            ,W_MC_Flag12 ");
		buffer.append("            ,W_MC_Flag13 ");
		buffer.append("            ,W_MC_Flag14 ");
		buffer.append("            ,W_MC_Flag15 ");
		buffer.append("            ,W_MC_Flag2 ");
		buffer.append("            ,W_MC_Flag21 ");
		buffer.append("            ,W_MC_Flag22 ");
		buffer.append("            ,W_MC_Flag23 ");
		buffer.append("            ,W_MC_Flag24 ");
		buffer.append("            ,W_MC_Flag25 ");
		buffer.append("            ,W_MC_Flag3 ");
		buffer.append("            ,W_MC_Flag31 ");
		buffer.append("            ,W_MC_Flag32 ");
		buffer.append("            ,W_MC_Flag33 ");
		buffer.append("            ,W_MC_Flag34 ");
		buffer.append("            ,W_MC_Flag35 ");
		
		buffer.append("            ,W_MC_TypeID1 ");
		buffer.append("            ,W_MC_TypeID11 ");
		buffer.append("            ,W_MC_TypeID12 ");
		buffer.append("            ,W_MC_TypeID13 ");
		buffer.append("            ,W_MC_TypeID14 ");
		buffer.append("            ,W_MC_TypeID15 ");
		buffer.append("            ,W_MC_TypeID2 ");
		buffer.append("            ,W_MC_TypeID21 ");
		buffer.append("            ,W_MC_TypeID22 ");
		buffer.append("            ,W_MC_TypeID23 ");
		buffer.append("            ,W_MC_TypeID24 ");
		buffer.append("            ,W_MC_TypeID25 ");	
		buffer.append("            ,W_MC_TypeID3 ");
		buffer.append("            ,W_MC_TypeID31 ");
		buffer.append("            ,W_MC_TypeID32 ");
		buffer.append("            ,W_MC_TypeID33 ");
		buffer.append("            ,W_MC_TypeID34 ");
		buffer.append("            ,W_MC_TypeID35 ");		
		
		buffer.append("            ,W_MC_Content1 ");
		buffer.append("            ,W_MC_Content11 ");
		buffer.append("            ,W_MC_Content12 ");
		buffer.append("            ,W_MC_Content13 ");
		buffer.append("            ,W_MC_Content14 ");
		buffer.append("            ,W_MC_Content15 ");
		buffer.append("            ,W_MC_Content2 ");
		buffer.append("            ,W_MC_Content21 ");
		buffer.append("            ,W_MC_Content22 ");
		buffer.append("            ,W_MC_Content23 ");
		buffer.append("            ,W_MC_Content24 ");
		buffer.append("            ,W_MC_Content25 ");	
		buffer.append("            ,W_MC_Content3 ");
		buffer.append("            ,W_MC_Content31 ");
		buffer.append("            ,W_MC_Content32 ");
		buffer.append("            ,W_MC_Content33 ");
		buffer.append("            ,W_MC_Content34 ");
		buffer.append("            ,W_MC_Content35 ");		
		buffer.append("            ) ");
		buffer.append("     VALUES( ");
        buffer.append("              '"+ Utility.getName(po.getWmcid1()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcname1()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcid2()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcname2()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcid3()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcname3()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcid11()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcname11()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcid12()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcname12()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcid13()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcname13()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcid14()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcname14()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcid15()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcname15()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcid21()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcname21()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcid22()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcname22()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcid23()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcname23()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcid24()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcname24()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcid25()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcname25()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcid31()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcname31()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcid32()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcname32()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcid33()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcname33()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcid34()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcname34()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcid35()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcname35()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcflag1()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcflag11()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcflag12()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcflag13()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcflag14()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcflag15()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcflag2()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcflag21()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcflag22()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcflag23()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcflag24()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcflag25()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcflag3()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcflag31()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcflag32()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcflag33()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcflag34()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmcflag35()) +"', ");
        
        buffer.append("              '"+ Utility.getName(po.getWmctypeid1()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmctypeid11()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmctypeid12()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmctypeid13()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmctypeid14()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmctypeid15()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmctypeid2()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmctypeid21()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmctypeid22()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmctypeid23()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmctypeid24()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmctypeid25()) +"', ");    
        buffer.append("              '"+ Utility.getName(po.getWmctypeid3()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmctypeid31()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmctypeid32()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmctypeid33()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmctypeid34()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmctypeid35()) +"', ");    
        
        buffer.append("              '"+ Utility.getName(po.getWmccontent1()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmccontent11()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmccontent12()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmccontent13()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmccontent14()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmccontent15()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmccontent2()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmccontent21()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmccontent22()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmccontent23()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmccontent24()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmccontent25()) +"', ");    
        buffer.append("              '"+ Utility.getName(po.getWmccontent3()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmccontent31()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmccontent32()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmccontent33()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmccontent34()) +"', ");
        buffer.append("              '"+ Utility.getName(po.getWmccontent35()) +"' ");         
		buffer.append("              ) ");
		
		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 * 获取所有MenuType
	 * @param po
	 */
	public List<WeiXinMenuTypePo> getWeiXinMenuTypeList(){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("SELECT W_M_T_ID      AS wmtid, ");
		buffer.append(" W_M_T_Name    		AS wmtname, ");
		buffer.append(" W_M_T_ButtonType    AS wmtbuttontype, ");
		buffer.append(" W_M_T_Description   AS wmtdescription ");
		
		buffer.append("FROM   W_Menu_Type ");
		
		buffer.append("order by W_M_T_Orderby ");
		
		return queryForObjectList(buffer.toString(), null, WeiXinMenuTypePo.class);		
	}
}
