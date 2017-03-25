package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.VIPCardDao;
import com.pengsheng.eims.basic.persistence.ContractPo;
import com.pengsheng.eims.basic.persistence.VIPCardDetailsPo;
import com.pengsheng.eims.basic.persistence.VIPCardPo;
import com.pengsheng.eims.basic.persistence.VIPGoodsBindPo;
import com.pengsheng.eims.system.persistence.DiscountShortcutKeysDetailsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class VIPCardDaoImpl extends BaseJdbcDaoSupport implements VIPCardDao{

	public void deleteVIPCardPo(VIPCardPo vipCardPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("DELETE FROM S_SE_VIPCard ");
		buffer.append("WHERE  S_SE_VC_ID = ? ");
		
		params.add(vipCardPo.getSsevcidt());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void insertVIPCardPo(VIPCardPo vipCardPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO S_SE_VIPCard ");
		buffer.append("            (S_SE_VC_ID, ");
		buffer.append("             S_SE_VC_Discount, ");
		buffer.append("             S_SE_VC_DownTime, ");
		buffer.append("             S_SE_VC_UpTime, ");
		buffer.append("             S_SE_VC_Date, ");
		buffer.append("             S_SE_VC_CreatPersonId, ");
		buffer.append("             S_SE_VC_CustomerName, ");
		buffer.append("             S_SE_VC_CardPassword, ");
		buffer.append("             S_SE_VC_UseCount, ");
		buffer.append("             S_SE_VC_IDCard) ");
		buffer.append("VALUES     ( ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             getdate(), ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?) ");
		
		params.add(vipCardPo.getSsevcid());
		params.add(vipCardPo.getSsevcdiscount());
		params.add(vipCardPo.getSsevcdowntime());
		params.add(vipCardPo.getSsevcuptime());
		params.add(vipCardPo.getSsevccreatpersonid());
		params.add(Utility.getName(vipCardPo.getSsevccustomername()));
		if("".equals(Utility.getName(vipCardPo.getSsevccardpassword()))){
			params.add("");
		}else{
			params.add(vipCardPo.getSsevccardpassword());
		}
		if("".equals(Utility.getName(vipCardPo.getSsevcusecount()))){
			params.add("");
		}else{
			params.add(Utility.getName(vipCardPo.getSsevcusecount()));			
		}

		params.add(Utility.getName(vipCardPo.getSsevcidcard()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public int selectVIPCardCount(VIPCardPo vipCardPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT COUNT(*) ");
		buffer.append("FROM   S_SE_VIPCard ");
		buffer.append("       INNER JOIN dbo.SYS_PersonInfo ");
		buffer.append("         ON S_SE_VC_CreatPersonId = ID ");
		buffer.append("WHERE  1 = 1 ");
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevccustomername()))){
			buffer.append("       AND S_SE_VC_CustomerName like '%'+?+'%' ");
			params.add(vipCardPo.getSsevccustomername());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevcidcard()))){
			buffer.append("       AND S_SE_VC_IDCard like '%'+?+'%' ");
			params.add(vipCardPo.getSsevcidcard());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevcbegindate()))){
			buffer.append("       AND convert(varchar(10),S_SE_VC_Date,23) >= ? ");
			params.add(vipCardPo.getSsevcbegindate());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevcenddate()))){
			buffer.append("       AND convert(varchar(10),S_SE_VC_Date,23) <= ? ");
			params.add(vipCardPo.getSsevcenddate());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevcidt()))){
			buffer.append("       AND S_SE_VC_ID like '%'+?+'%' ");
			params.add(vipCardPo.getSsevcidt());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevcdiscountt()))){
			buffer.append("       AND S_SE_VC_Discount = ? ");
			params.add(vipCardPo.getSsevcdiscountt());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevcdowntimet()))){
			buffer.append("       AND CONVERT(VARCHAR(10), S_SE_VC_DownTime, 23) >= ? ");
			params.add(vipCardPo.getSsevcdowntimet());
		}

		if(!"".equals(Utility.getName(vipCardPo.getSsevcuptimet()))){
			buffer.append("       AND CONVERT(VARCHAR(10), S_SE_VC_UpTime, 23) <= ? ");
			params.add(vipCardPo.getSsevcuptimet());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevccreatpersonid()))){
			buffer.append("       AND id like '%'+?+'%' ");
			params.add(vipCardPo.getSsevccreatpersonid());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevccreatpersonname()))){
			buffer.append("       AND personName LIKE '%'+?+'%' ");
			params.add(vipCardPo.getSsevccreatpersonname());
		}
		
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}

	public List<VIPCardPo> selectVIPCardList(VIPCardPo vipCardPo, int start,int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("SELECT * from( ");
		buffer.append("SELECT ROW_NUMBER() Over(order by S_SE_VC_Date desc) as rowNum, ");
		buffer.append("       S_SE_VC_ID            AS ssevcid, ");
		buffer.append("       S_SE_VC_Discount      AS ssevcdiscount, ");
		buffer.append("       S_SE_VC_DownTime      AS ssevcdowntime, ");
		buffer.append("       S_SE_VC_UpTime        AS ssevcuptime, ");
		buffer.append("       S_SE_VC_Date          AS ssevcdate, ");
		buffer.append("       S_SE_VC_CreatPersonId AS ssevccreatpersonid, ");
		buffer.append("       personName            AS ssevccreatpersonname, ");
		buffer.append("       S_SE_VC_CustomerName  AS ssevccustomername, ");
		buffer.append("       S_SE_VC_CardPassword  AS ssevccardpassword, ");
		buffer.append("       S_SE_VC_UseCount  AS ssevcusecount, ");
		buffer.append("       S_SE_VC_IDCard        AS ssevcidcard ");
		buffer.append("FROM   S_SE_VIPCard ");
		buffer.append("       INNER JOIN dbo.SYS_PersonInfo ");
		buffer.append("         ON S_SE_VC_CreatPersonId = ID ");
		buffer.append("WHERE  1 = 1 ");
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevccustomername()))){
			buffer.append("       AND S_SE_VC_CustomerName like '%'+?+'%' ");
			params.add(vipCardPo.getSsevccustomername());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevcidcard()))){
			buffer.append("       AND S_SE_VC_IDCard like '%'+?+'%' ");
			params.add(vipCardPo.getSsevcidcard());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevcbegindate()))){
			buffer.append("       AND convert(varchar(10),S_SE_VC_Date,23) >= ? ");
			params.add(vipCardPo.getSsevcbegindate());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevcenddate()))){
			buffer.append("       AND convert(varchar(10),S_SE_VC_Date,23) <= ? ");
			params.add(vipCardPo.getSsevcenddate());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevcidt()))){
			buffer.append("       AND S_SE_VC_ID like '%'+?+'%' ");
			params.add(vipCardPo.getSsevcidt());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevcdiscountt()))){
			buffer.append("       AND S_SE_VC_Discount = ? ");
			params.add(vipCardPo.getSsevcdiscountt());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevcdowntimet()))){
			buffer.append("       AND CONVERT(VARCHAR(10), S_SE_VC_DownTime, 23) >= ? ");
			params.add(vipCardPo.getSsevcdowntimet());
		}

		if(!"".equals(Utility.getName(vipCardPo.getSsevcuptimet()))){
			buffer.append("       AND CONVERT(VARCHAR(10), S_SE_VC_UpTime, 23) <= ? ");
			params.add(vipCardPo.getSsevcuptimet());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevccreatpersonid()))){
			buffer.append("       AND id like '%'+?+'%' ");
			params.add(vipCardPo.getSsevccreatpersonid());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevccreatpersonname()))){
			buffer.append("       AND personName LIKE '%'+?+'%' ");
			params.add(vipCardPo.getSsevccreatpersonname());
		}
		
		buffer.append(" ) temp where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append("set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), VIPCardPo.class);
	}

	/**
	 * 查询VIP卡List
	 * @param vipCardPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<VIPCardPo> selectVIPCardList(VIPCardPo vipCardPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" SELECT S_SE_VC_ID            AS ssevcid, ");
		buffer.append("       S_SE_VC_Discount      AS ssevcdiscount, ");
		buffer.append("       S_SE_VC_DownTime      AS ssevcdowntime, ");
		buffer.append("       S_SE_VC_UpTime        AS ssevcuptime, ");
		buffer.append("       S_SE_VC_Date          AS ssevcdate, ");
		buffer.append("       S_SE_VC_CreatPersonId AS ssevccreatpersonid, ");
		buffer.append("       personName            AS ssevccreatpersonname, ");
		buffer.append("       S_SE_VC_CustomerName  AS ssevccustomername, ");
		buffer.append("       S_SE_VC_CardPassword  AS ssevccardpassword, ");
		buffer.append("       S_SE_VC_UseCount  AS ssevcusecount, ");
		buffer.append("       S_SE_VC_IDCard        AS ssevcidcard ");
		buffer.append("FROM   S_SE_VIPCard ");
		buffer.append("       INNER JOIN dbo.SYS_PersonInfo ");
		buffer.append("         ON S_SE_VC_CreatPersonId = ID ");
		buffer.append("WHERE  1 = 1 ");
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevccustomername()))){
			buffer.append("       AND S_SE_VC_CustomerName like '%'+?+'%' ");
			params.add(vipCardPo.getSsevccustomername());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevcidcard()))){
			buffer.append("       AND S_SE_VC_IDCard like '%'+?+'%' ");
			params.add(vipCardPo.getSsevcidcard());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevcbegindate()))){
			buffer.append("       AND convert(varchar(10),S_SE_VC_Date,120) >= ? ");
			params.add(vipCardPo.getSsevcbegindate());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevcenddate()))){
			buffer.append("       AND convert(varchar(10),S_SE_VC_Date,120) <= ? ");
			params.add(vipCardPo.getSsevcenddate());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevcidt()))){
			buffer.append("       AND S_SE_VC_ID like '%'+?+'%' ");
			params.add(vipCardPo.getSsevcidt());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevcdiscountt()))){
			buffer.append("       AND S_SE_VC_Discount = ? ");
			params.add(vipCardPo.getSsevcdiscountt());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevcdowntimet()))){
			buffer.append("       AND CONVERT(VARCHAR(10), S_SE_VC_DownTime, 120) >= ? ");
			params.add(vipCardPo.getSsevcdowntimet());
		}

		if(!"".equals(Utility.getName(vipCardPo.getSsevcuptimet()))){
			buffer.append("       AND CONVERT(VARCHAR(10), S_SE_VC_UpTime,120) <= ? ");
			params.add(vipCardPo.getSsevcuptimet());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevccreatpersonid()))){
			buffer.append("       AND id like '%'+?+'%' ");
			params.add(vipCardPo.getSsevccreatpersonid());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevccreatpersonname()))){
			buffer.append("       AND personName LIKE '%'+?+'%' ");
			params.add(vipCardPo.getSsevccreatpersonname());
		}
		
		return queryForObjectList(buffer.toString(), params.toArray(), VIPCardPo.class);
	}
	
	public VIPCardPo selectVIPCardPo(VIPCardPo vipCardPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if(!Utility.getName(vipCardPo.getGoodslevel()).equals("")){
			buffer.append("SELECT S_SE_VC_ID            AS ssevcid, ");
			buffer.append("       S_SE_VCD_Discount     AS ssevcdiscount, ");
			buffer.append("       S_SE_VC_DownTime      AS ssevcdowntime, ");
			buffer.append("       S_SE_VC_UpTime        AS ssevcuptime, ");
			buffer.append("       S_SE_VC_Date          AS ssevcdate, ");
			buffer.append("       S_SE_VC_CreatPersonId AS ssevccreatpersonid, ");
			buffer.append("       personName            AS ssevccreatpersonname, ");
			buffer.append("       S_SE_VC_CustomerName  AS ssevccustomername, ");
			buffer.append("       S_SE_VC_CardPassword  AS ssevccardpassword, ");
			buffer.append("       S_SE_VC_UseCount  AS ssevcusecount, ");
			buffer.append("       S_SE_VC_IDCard        AS ssevcidcard, ");
			buffer.append("       dbo.getVipBindGoodsType(S_SE_VC_ID)        AS ssevcgoodstype ");
			buffer.append("FROM   S_SE_VIPCard ");
			buffer.append("       INNER JOIN dbo.SYS_PersonInfo ");
			buffer.append("         ON S_SE_VC_CreatPersonId = ID ");
			buffer.append("       LEFT JOIN S_SE_VIPCardDetails ");
			buffer.append("         ON S_SE_VC_ID = S_SE_VCD_VIPCardID ");
			buffer.append("WHERE  1 = 1 ");
			buffer.append("       AND S_SE_VC_ID = ? ");
			
			params.add(vipCardPo.getSsevcidt());
			
			if(!"".equals(Utility.getName(vipCardPo.getGoodslevel()))){
				buffer.append("       AND S_SE_VCD_GoodsLevel = ? ");
				params.add(vipCardPo.getGoodslevel());
			}
			buffer.append("and ((datediff(day, S_SE_VC_DownTime, getdate()) >= 0  and datediff(day, S_SE_VC_UpTime, getdate()) <= 0) ");  
			buffer.append("or  (S_SE_VC_DownTime ='' and S_SE_VC_UpTime ='') ) ");
	        buffer.append("and (isnull(S_SE_VC_UseCount,'')='' or S_SE_VC_UseCount>0) ");
	        
		}else{
			buffer.append("SELECT S_SE_VC_ID            AS ssevcid, ");
			buffer.append("       S_SE_VC_Discount      AS ssevcdiscount, ");
			buffer.append("       S_SE_VC_DownTime      AS ssevcdowntime, ");
			buffer.append("       S_SE_VC_UpTime        AS ssevcuptime, ");
			buffer.append("       S_SE_VC_Date          AS ssevcdate, ");
			buffer.append("       S_SE_VC_CreatPersonId AS ssevccreatpersonid, ");
			buffer.append("       personName            AS ssevccreatpersonname, ");
			buffer.append("       S_SE_VC_CustomerName  AS ssevccustomername, ");
			buffer.append("       S_SE_VC_CardPassword  AS ssevccardpassword, ");
			buffer.append("       S_SE_VC_UseCount  AS ssevcusecount, ");
			buffer.append("       S_SE_VC_IDCard        AS ssevcidcard, ");
			buffer.append("       dbo.getVipBindGoodsType(S_SE_VC_ID)        AS ssevcgoodstype ");
			buffer.append("FROM   S_SE_VIPCard ");
			buffer.append("       INNER JOIN dbo.SYS_PersonInfo ");
			buffer.append("         ON S_SE_VC_CreatPersonId = ID ");
			buffer.append("WHERE  1 = 1 ");
			buffer.append("       AND S_SE_VC_ID = ? ");
			params.add(vipCardPo.getSsevcidt());
		}
		
		if(!"".equals(Utility.getName(vipCardPo.getSsevccardpassword()))){
			buffer.append("       AND S_SE_VC_CardPassword = ? ");
			params.add(vipCardPo.getSsevccardpassword());
		}
		buffer.append("and ((datediff(day, S_SE_VC_DownTime, getdate()) >= 0  and datediff(day, S_SE_VC_UpTime, getdate()) <= 0) ");  
		buffer.append("or  (S_SE_VC_DownTime ='' and S_SE_VC_UpTime ='') ) ");
        buffer.append("and (isnull(S_SE_VC_UseCount,'')='' or S_SE_VC_UseCount>0) ");
		
		return (VIPCardPo)queryForObject(buffer.toString(), params.toArray(), VIPCardPo.class);
	}
	
	public VIPCardPo selectVIPCardDetail(VIPCardPo vipCardPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if(!Utility.getName(vipCardPo.getGoodslevel()).equals("")){
			buffer.append("SELECT S_SE_VC_ID            AS ssevcid, ");
			buffer.append("       S_SE_VCD_Discount     AS ssevcdiscount, ");
			buffer.append("       S_SE_VC_DownTime      AS ssevcdowntime, ");
			buffer.append("       S_SE_VC_UpTime        AS ssevcuptime, ");
			buffer.append("       S_SE_VC_Date          AS ssevcdate, ");
			buffer.append("       S_SE_VC_CreatPersonId AS ssevccreatpersonid, ");
			buffer.append("       personName            AS ssevccreatpersonname, ");
			buffer.append("       S_SE_VC_CustomerName  AS ssevccustomername, ");
			buffer.append("       S_SE_VC_CardPassword  AS ssevccardpassword, ");
			buffer.append("       S_SE_VC_UseCount  AS ssevcusecount, ");
			buffer.append("       S_SE_VC_IDCard        AS ssevcidcard, ");
			buffer.append("       dbo.getVipBindGoodsType(S_SE_VC_ID)        AS ssevcgoodstype ");
			buffer.append("FROM   S_SE_VIPCard ");
			buffer.append("       INNER JOIN dbo.SYS_PersonInfo ");
			buffer.append("         ON S_SE_VC_CreatPersonId = ID ");
			buffer.append("       LEFT JOIN S_SE_VIPCardDetails ");
			buffer.append("         ON S_SE_VC_ID = S_SE_VCD_VIPCardID ");
			buffer.append("WHERE  1 = 1 ");
			buffer.append("       AND S_SE_VC_ID = ? ");
			
			params.add(vipCardPo.getSsevcidt());
	        
		}else{
			buffer.append("SELECT S_SE_VC_ID            AS ssevcid, ");
			buffer.append("       S_SE_VC_Discount      AS ssevcdiscount, ");
			buffer.append("       S_SE_VC_DownTime      AS ssevcdowntime, ");
			buffer.append("       S_SE_VC_UpTime        AS ssevcuptime, ");
			buffer.append("       S_SE_VC_Date          AS ssevcdate, ");
			buffer.append("       S_SE_VC_CreatPersonId AS ssevccreatpersonid, ");
			buffer.append("       personName            AS ssevccreatpersonname, ");
			buffer.append("       S_SE_VC_CustomerName  AS ssevccustomername, ");
			buffer.append("       S_SE_VC_CardPassword  AS ssevccardpassword, ");
			buffer.append("       S_SE_VC_UseCount  AS ssevcusecount, ");
			buffer.append("       S_SE_VC_IDCard        AS ssevcidcard, ");
			buffer.append("       dbo.getVipBindGoodsType(S_SE_VC_ID)        AS ssevcgoodstype ");
			buffer.append("FROM   S_SE_VIPCard ");
			buffer.append("       INNER JOIN dbo.SYS_PersonInfo ");
			buffer.append("         ON S_SE_VC_CreatPersonId = ID ");
			buffer.append("WHERE  1 = 1 ");
			buffer.append("       AND S_SE_VC_ID = ? ");
			params.add(vipCardPo.getSsevcidt());
		}
		
		return (VIPCardPo)queryForObject(buffer.toString(), params.toArray(), VIPCardPo.class);
	}

	public void updateVIPCardPo(VIPCardPo vipCardPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("UPDATE S_SE_VIPCard ");
		buffer.append("SET ");
		buffer.append("       S_SE_VC_Discount = ?, ");
		buffer.append("       S_SE_VC_DownTime = ?, ");
		buffer.append("       S_SE_VC_UpTime = ?, ");
		buffer.append("       S_SE_VC_CustomerName = ?, ");
		buffer.append("       S_SE_VC_CardPassword = ?, ");

		buffer.append("       S_SE_VC_IDCard = ? ");
		buffer.append("WHERE  S_SE_VC_ID = ? ");
		
		params.add(vipCardPo.getSsevcdiscount());
		params.add(vipCardPo.getSsevcdowntime());
		params.add(vipCardPo.getSsevcuptime());
		params.add(vipCardPo.getSsevccustomername());
		if("".equals(Utility.getName(vipCardPo.getSsevccardpassword()))){
			params.add("");
		}else{
			params.add(vipCardPo.getSsevccardpassword());
		}

		params.add(vipCardPo.getSsevcidcard());
		params.add(vipCardPo.getSsevcid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void updateVIPCardID(VIPCardPo vipCardPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("UPDATE S_SE_VIPCard ");
		buffer.append("SET ");
		buffer.append("       S_SE_VC_ID = ?, ");
		buffer.append("       S_SE_VC_CardPassword = ? ");
		buffer.append("WHERE  S_SE_VC_ID = ? ");
		
		params.add(vipCardPo.getSsevcnewid());
		params.add(vipCardPo.getSsevccardnewpassword());
		params.add(vipCardPo.getSsevcidt());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void insertVIPCardDetails(VIPCardDetailsPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into S_SE_VIPCardDetails (");
		buffer.append(" S_SE_VCD_UUID, ");
		buffer.append(" S_SE_VCD_VIPCardID, ");
		buffer.append(" S_SE_VCD_GoodsLevel, ");
		buffer.append(" S_SE_VCD_Discount ");
		buffer.append(" )values( ");
		buffer.append(" ?, ");
		buffer.append(" ?, ");
		buffer.append(" ?, ");
		buffer.append(" ? ");
		buffer.append(" ) ");
		
		params.add(this.uuid.generate());
		params.add(po.getSsevcdvipcardid());
		params.add(po.getSsevcdgoodslevel());
		params.add(po.getSsevcddiscount());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public List<VIPCardDetailsPo> selectVIPCardDetails(VIPCardDetailsPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select ");
		buffer.append("	S_SE_VCD_UUID 					as ssevcduuid, ");
		buffer.append(" S_SE_VCD_VIPCardID				as ssevcdvipcardid, ");
		buffer.append(" S_SE_VCD_GoodsLevel				as ssevcdgoodslevel, ");
		buffer.append(" B_GL_Name						as ssevcdgoodslevelname, ");
		buffer.append(" S_SE_VCD_Discount				as ssevcddiscount ");
		buffer.append(" from S_SE_VIPCardDetails ");
		buffer.append(" left join B_GoodsLevel on S_SE_VCD_GoodsLevel = B_GL_UUID");
		buffer.append(" where S_SE_VCD_VIPCardID = ? ");
		
		params.add(po.getSsevcdvipcardid());

		return queryForObjectList(buffer.toString(), params.toArray(),VIPCardDetailsPo.class);
	}
	
	public void deleteVIPCardDetails(String pid) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" delete from S_SE_VIPCardDetails ");
		buffer.append(" where S_SE_VCD_VIPCardID = ? ");
		
		params.add(pid);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void insertVIPCardBindGoodsType(VIPGoodsBindPo vpo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into S_SE_VIPGoodsBind (");
		buffer.append(" S_SE_VB_ID, ");
		buffer.append(" S_SE_VB_VipCardID, ");
		buffer.append(" S_SE_VB_GoodsCategory, ");
		buffer.append(" S_SE_VB_GoodsProperty, ");
		buffer.append(" S_SE_VB_GoodsPropertyValue ");
		buffer.append(" )values( ");
		buffer.append(" ?, ");
		buffer.append(" ?, ");
		buffer.append(" ?, ");
		buffer.append(" ?, ");
		buffer.append(" ? ");
		buffer.append(" ) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(vpo.getSsevbVipcardID()));
		params.add(Utility.getName(vpo.getSsevbgoodscategory()));
		params.add(Utility.getName(vpo.getSsevbgoodsproperty()));
		params.add(Utility.getName(vpo.getSsevbgoodspropertyvalue()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public List<VIPGoodsBindPo> selectVIPCardBindGoodsType(VIPCardPo vipCardPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select ");
		buffer.append(" S_SE_VB_ID as ssevbid, ");
		buffer.append(" S_SE_VB_VipCardID as ssevbVipcardID, ");
		buffer.append(" S_SE_VB_GoodsCategory as ssevbgoodscategory, ");
		buffer.append(" S_SE_VB_GoodsProperty as ssevbgoodsproperty, ");
		buffer.append(" S_SE_VB_GoodsPropertyValue as ssevbgoodspropertyvalue ");
		buffer.append(" from S_SE_VIPGoodsBind ");
		buffer.append(" where S_SE_VB_VipCardID = ? ");
		
		params.add(Utility.getName(vipCardPo.getSsevcidt()));

		return queryForObjectList(buffer.toString(), params.toArray(),VIPGoodsBindPo.class);
	}
	
	public void deleteVIPCardBindGoodsType(VIPCardPo vipCardPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" delete from S_SE_VIPGoodsBind ");
		buffer.append(" where S_SE_VB_VipCardID = ? ");

		params.add(Utility.getName(vipCardPo.getSsevcidt()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void updateVIPCardIDBindGoodsType(VIPCardPo vipCardPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("UPDATE S_SE_VIPGoodsBind ");
		buffer.append("SET ");
		buffer.append("       S_SE_VB_VipCardID = ? ");
		buffer.append("WHERE  S_SE_VB_VipCardID = ? ");
		
		params.add(vipCardPo.getSsevcnewid());
		params.add(vipCardPo.getSsevcidt());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
}
