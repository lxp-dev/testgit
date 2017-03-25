package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.system.dao.MemberManagementDao;
import com.pengsheng.eims.system.persistence.DiscountShortcutKeysDetailsPo;
import com.pengsheng.eims.system.persistence.MemberManagementDiscountPo;
import com.pengsheng.eims.system.persistence.MemberManagementDiscountSetUpDetailsPo;
import com.pengsheng.eims.system.persistence.MemberManagementPo;

import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class MemberManagementDaoImpl extends BaseJdbcDaoSupport implements MemberManagementDao {

	public void insertMemberManagement(MemberManagementPo po) {
		
		String sql="insert into F_MemberManagement(F_MM_ID,F_MM_MemberName,F_MM_UP,F_MM_DOWN,F_MM_Discount,F_MM_Integral,F_MM_UpgradeCard,F_MM_IsDefault,F_MM_IsFavorable,F_MM_GoodsCategoryID) " +
				"values('"+po.getFmmid()+"','"+po.getFmmmembername()+"','"+po.getFmmup()+"','"+po.getFmmdown()+"','"+po.getFmmdiscount()+"','"+po.getFmmsubintegral()+"','"+po.getFmmtypeid()+"','"+(Utility.getName(po.getFmmsetdefault()).equals("1") ? "1" : "0")+"','"+(Utility.getName(po.getFmmisfavorable()).equals("1") ? "1" : "0")+"','"+Utility.getName(po.getFmmisgoodscategoryid())+"')";

		getJdbcTemplate().update(sql);
	}
	/**
	 * 删除折扣设置
	 * 
	 */
	public void deleteMemberManagementDiscountSet(MemberManagementDiscountPo po){
		
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from F_MemberManagementDiscountSetUp where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getFmdid()))){
			sb.append("and F_MD_ID = ? ");
			params.add (Utility.getName(po.getFmdid()));
		}
		
		if(!"".equals(Utility.getName(po.getFmdmembermanagementid()))){
			sb.append("and F_MD_MemberManagementID = ? ");
			params.add (Utility.getName(po.getFmdmembermanagementid()));
		}
		
        getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	/**
	 * 折扣设置修改
	 * 
	 */
	public void updateMemberManagementDiscount(MemberManagementDiscountPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("update F_MemberManagementDiscountSetUp ");
		sb.append("SET    F_MD_Discount = ? ");		
		sb.append(" ,F_MD_ShopCode = ? ");
		sb.append(" ,F_MD_ShopCodeName = ? ");
		sb.append("WHERE  1=1 ");
		params.add(Utility.getName(po.getFmddiscount()));
		params.add(Utility.getName(po.getFmmisshopcode()));
		params.add(Utility.getName(po.getFmmisshopcodename()));
		
		if(!Utility.getName(po.getFmdid()).equals("")){
			sb.append(" and F_MD_ID = ? ");
			params.add(Utility.getName(po.getFmdid()));
		}
		
		if(!Utility.getName(po.getFmdmembermanagementid()).equals("")){
			sb.append(" and F_MD_MemberManagementID = ? ");
			params.add(Utility.getName(po.getFmdmembermanagementid()));
		}
		
		if(!Utility.getName(po.getFmdgoodscategoryid()).equals("")){
			sb.append(" and F_MD_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getFmdgoodscategoryid()));
		}
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 折扣设置批量修改
	 * 
	 */
	public void updateMemberManagementDiscountBatch(MemberManagementDiscountPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("update F_MemberManagementDiscountSetUp ");
		sb.append("SET    F_MD_Discount = ? ");		
		sb.append("WHERE  1=1 ");
		params.add(Utility.getName(po.getFmddiscount()));
		
		if(!Utility.getName(po.getFmdid()).equals("")){
			sb.append(" and F_MD_ID = ? ");
			params.add(Utility.getName(po.getFmdid()));
		}
		
		if(!Utility.getName(po.getFmdmembermanagementid()).equals("")){
			sb.append(" and F_MD_MemberManagementID = ? ");
			params.add(Utility.getName(po.getFmdmembermanagementid()));
		}
		
		if(!Utility.getName(po.getFmdgoodscategoryid()).equals("")){
			sb.append(" and F_MD_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getFmdgoodscategoryid()));
		}
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 折扣设置详细
	 * 
	 */
	public MemberManagementDiscountPo getMemberManagementDiscountSetDetail(MemberManagementDiscountPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
	    sb.append(" select F_MM_MemberName as  fmdmembermanagementname,F_MD_GoodsID as fmdgoodsid,F_MD_ID as fmdid,F_MD_Iscustomize as fmdiscustomize,(case when F_MD_GoodsCategoryName!='' then F_MD_GoodsCategoryName else B_GC_GoodsCategoryName end) as fmdgoodscategoryname,B_SP_SupplierName as fmdsuppliername,B_BD_brandName as fmdbrandname,B_GI_GoodsName as fmdgoodsname,F_MD_Discount as fmddiscount ");		
	    sb.append(",F_MD_GoodsLevel as fmdgoodslevel ");
	    sb.append(",B_GL_Name		as fmdgoodslevelname ");
	    sb.append(",F_MD_ShopCode		as fmmisshopcode ");
	    sb.append(",dbo.getDepartmentNameByID(F_MD_ShopCode)		as fmmisshopcodename ");	    
	    sb.append(",F_MD_GoodsCategoryID		as fmdgoodscategoryid ");
	    sb.append(",F_MD_SupplierID		as fmdsupplierid ");
	    sb.append(",F_MD_BrandID		as fmdbrandid ");
	    sb.append(",F_MD_GoodsID		as fmdgoodsid ");
	    sb.append(",F_MD_MemberManagementID		as fmdmembermanagementid ");	    
	    sb.append(" from F_MemberManagementDiscountSetUp   ");
		sb.append(" inner join F_MemberManagement  on F_MD_MemberManagementID=F_MM_ID  ");
		sb.append(" left join B_GoodsInfo on B_GI_GoodsID = F_MD_GoodsID ");
		sb.append(" left join B_Supplier on B_SP_ID = F_MD_SupplierID ");
		sb.append(" left join B_Brand on B_BD_ID = F_MD_BrandID and B_BD_SupplierID = F_MD_SupplierID ");
		sb.append(" left join B_GoodsCategory on B_GC_ID = F_MD_GoodsCategoryID ");
		sb.append(" left join B_GoodsLevel on F_MD_GoodsLevel = B_GL_UUID");
		sb.append(" where F_MD_ID = ?  ");

		params.add(Utility.getName(po.getFmdid()));
		
		return (MemberManagementDiscountPo)queryForObject(sb.toString(), params.toArray(),MemberManagementDiscountPo.class);
	}
	/**
	 * 增加折扣设置
	 * 
	 */
	public void insertMemberManagementDiscountSet(MemberManagementDiscountPo po){
		
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into F_MemberManagementDiscountSetUp(F_MD_ID,  ");
		sb.append("F_MD_GoodsCategoryID,                ");
		sb.append("F_MD_Iscustomize,                ");
		sb.append("F_MD_SupplierID,                ");
		sb.append("F_MD_BrandID,                ");
		sb.append("F_MD_GoodsID,                ");
		sb.append("F_MD_GoodsName,                ");
		sb.append("F_MD_Discount, F_MD_GoodsCategoryName, F_MD_SupplierName, F_MD_BrandName,F_MD_MemberManagementID,");	
		sb.append("F_MD_GoodsLevel,F_MD_ShopCode,F_MD_ShopCodeName ");
		sb.append("    )values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)         ");

		params.add (this.uuid.generate());
        params.add (Utility.getName(po.getFmdgoodscategoryid()));
        params.add (Utility.getName(po.getFmdiscustomize()));
        params.add (Utility.getName(po.getFmdsupplierid()));
        params.add (Utility.getName(po.getFmdbrandid()));
        params.add (Utility.getName(po.getFmdgoodsid()));
        params.add (Utility.getName(po.getFmdgoodsname()));
        params.add (Utility.getName(po.getFmddiscount()));
        params.add (Utility.getName(po.getFmdgoodscategoryname()));
        params.add (Utility.getName(po.getFmdsuppliername()));
        params.add (Utility.getName(po.getFmdbrandname()));
        params.add (Utility.getName(po.getFmdmembermanagementid()));
        params.add (Utility.getName(po.getFmdgoodslevel()));
        params.add (Utility.getName(po.getFmmisshopcode()));
        params.add (Utility.getName(po.getFmmisshopcodename()));
        
        getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 增加折扣设置
	 * 
	 */
	public void insertMemberManagementSetDefaultDiscount(MemberManagementDiscountPo po){
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into F_MemberManagementDiscountSetUpDetails( ");
        sb.append("F_MDD_UUID,  ");
		sb.append("F_MDD_SetUpId,                ");
		sb.append("F_MDD_GoodsLevel,             ");
		sb.append("F_MDD_Discount                ");
		sb.append("    )select replace(newid(),'-',''),?,B_GL_UUID,B_GL_Discount from B_GoodsLevel ");
		
		params.add (Utility.getName(po.getFmdid()));
        
        getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 折扣编号是否存在
	 * 
	 */
	public int isExistMemberManagementDiscountSet(MemberManagementDiscountPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select count(F_MD_ID) from F_MemberManagementDiscountSetUp where F_md_GoodsCategoryID=? and F_md_SupplierID=? and F_md_BrandID=? and F_md_GoodsID=? and F_MD_MemberManagementID=? ");
		params.add(Utility.getName(po.getFmdgoodscategoryid()));
		params.add(Utility.getName(po.getFmdsupplierid()));
		params.add(Utility.getName(po.getFmdbrandid()));
		params.add(Utility.getName(po.getFmdgoodsid()));
		params.add(Utility.getName(po.getFmdmembermanagementid()));
		
		if(!"".equals(Utility.getName(po.getFmdiscustomize()))){
			sb.append(" and F_MD_Iscustomize=? ");
			params.add(Utility.getName(po.getFmdiscustomize()));
		}	
		
		if (!"".equals(Utility.getName(po.getFmmisshopcode()))){
			
			String[] array = Utility.getName(po.getFmmisshopcode()).split(",");
			
			sb.append(" and ( charindex((',' + ? + ','),(',' + F_MD_ShopCode + ',')) > 0 ");
			params.add(array[0]);
			
			for (int i = 1; i < array.length; i++){
				sb.append(" or charindex((',' + ? + ','),(',' + F_MD_ShopCode + ',')) > 0 ");
				params.add(array[i]);
			}
			sb.append(" ) ");
		}else{
			sb.append(" and isnull(F_MD_ShopCode,'') = '' ");
		}
		
		if(!"".equals(Utility.getName(po.getFmdid()))){
			sb.append(" and F_MD_ID <> ? ");
			params.add(Utility.getName(po.getFmdid()));
		}
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	/**
	 * 查询最大折扣设置列表
	 */
	public List<MemberManagementDiscountPo> getMemberManagementDiscountSetList(MemberManagementDiscountPo po, int start, int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append(" select fmdid as fmdid, ");
		sb.append(" fmdmembermanagementname as fmdmembermanagementname, ");
		sb.append(" fmdiscustomize as fmdiscustomize, ");
		sb.append(" fmdgoodsid as fmdgoodsid, ");
		sb.append(" fmdgoodscategoryname as fmdgoodscategoryname, ");
		sb.append(" fmdsuppliername as fmdsuppliername, ");
		sb.append(" fmdbrandname as fmdbrandname, ");
		sb.append(" fmdgoodsname as fmdgoodsname, ");
		sb.append(" fmddiscount as fmddiscount,fmmisshopcode as fmmisshopcode,fmmisshopcodename as fmmisshopcodename ");
		sb.append(" from (select ROW_NUMBER() Over(order by F_MD_GoodsCategoryID,F_MD_SupplierID,F_MD_BrandID) as rowNum,F_MM_MemberName as  fmdmembermanagementname,F_MD_GoodsID as fmdgoodsid,F_MD_ID as fmdid,F_MD_Iscustomize as fmdiscustomize, ");
		sb.append(" case  ");
		sb.append(" 	when F_MD_GoodsCategoryID = '3' and F_MD_Iscustomize = '0' then '成品片' ");
		sb.append(" 	when F_MD_GoodsCategoryID = '3' and F_MD_Iscustomize = 'D' then '订做片' ");
		sb.append(" 	when F_MD_GoodsCategoryID = '4' and F_MD_Iscustomize = '0' then '隐形成品片' ");
		sb.append(" 	when F_MD_GoodsCategoryID = '4' and F_MD_Iscustomize = 'D' then '隐形订做片' ");
		sb.append(" 	else B_GC_GoodsCategoryName ");
		sb.append(" end as fmdgoodscategoryname, ");
		sb.append(" B_SP_SupplierName as fmdsuppliername,B_BD_brandName as fmdbrandname,B_GI_GoodsName as fmdgoodsname,F_MD_Discount as fmddiscount, ");	
		sb.append(" F_MD_ShopCode as fmmisshopcode,F_MD_ShopCodeName as fmmisshopcodename   ");
		sb.append(" from F_MemberManagementDiscountSetUp   ");
		sb.append(" inner join F_MemberManagement  on F_MD_MemberManagementID=F_MM_ID  ");
		sb.append(" left join B_GoodsInfo on B_GI_GoodsID = F_MD_GoodsID ");
		sb.append(" left join B_Supplier on B_SP_ID = F_MD_SupplierID ");
		sb.append(" left join B_Brand on B_BD_ID = F_MD_BrandID and B_BD_SupplierID = F_MD_SupplierID ");
		sb.append(" left join B_GoodsCategory on B_GC_ID = F_MD_GoodsCategoryID ");
		sb.append(" where 1=1 ");
		if(!"".equals(Utility.getName(po.getFmdmembermanagementid()))){
			sb.append(" and F_MD_MemberManagementID = ? ");
			params.add(Utility.getName(po.getFmdmembermanagementid()));
		}
		if (!"".equals(Utility.getName(po.getFmdgoodscategoryid()))){
			sb.append(" and F_MD_GoodsCategoryID=? ");
			params.add(Utility.getName(po.getFmdgoodscategoryid()));
		}
		if (!"".equals(Utility.getName(po.getFmdsupplierid()))){
			sb.append(" and F_MD_SupplierID=? ");
			params.add(Utility.getName(po.getFmdsupplierid()));
		}
		if (!"".equals(Utility.getName(po.getFmdbrandid()))){
			sb.append(" and F_MD_BrandID=? ");
			params.add(Utility.getName(po.getFmdbrandid()));
		}
		if (!"".equals(Utility.getName(po.getFmdiscustomize()))){
			sb.append(" and F_MD_Iscustomize=? ");
			params.add(Utility.getName(po.getFmdiscustomize()));
		}
		if (!"".equals(Utility.getName(po.getFmdgoodsid()))){
			sb.append(" and F_MD_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFmdgoodsid()));
		}
		if (!"".equals(Utility.getName(po.getFmdgoodsname()))){
			sb.append(" and B_GI_GoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFmdgoodsname()));
		}
		
		if (!"".equals(Utility.getName(po.getFmmisshopcode()))){
			
			String[] array = Utility.getName(po.getFmmisshopcode()).split(",");
			
			sb.append(" and ( charindex((',' + ? + ','),(',' + F_MD_ShopCode + ',')) > 0 ");
			params.add(array[0]);
			
			for (int i = 1; i < array.length; i++){
				sb.append(" or charindex((',' + ? + ','),(',' + F_MD_ShopCode + ',')) > 0 ");
				params.add(array[i]);
			}
			sb.append(" ) ");
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0 ");
		
		return queryForObjectList(sb.toString(), params.toArray(),MemberManagementDiscountPo.class);
	}
	
	/**
	 * 查询会员卡类型折扣设置总数
	 */
	public int getMemberManagementDiscountSetCount(MemberManagementDiscountPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select count(F_MD_ID) from F_MemberManagementDiscountSetUp ");
		sb.append(" inner join F_MemberManagement  on F_MD_MemberManagementID=F_MM_ID  ");
		sb.append(" left join B_GoodsInfo on B_GI_GoodsID = F_MD_GoodsID ");
		sb.append(" where 1=1 ");

		if(!"".equals(Utility.getName(po.getFmdmembermanagementid()))){
			sb.append(" and F_MD_MemberManagementID = ? ");
			params.add(Utility.getName(po.getFmdmembermanagementid()));
		}
		if (!"".equals(Utility.getName(po.getFmdgoodscategoryid()))){
			sb.append(" and F_MD_GoodsCategoryID=? ");
			params.add(Utility.getName(po.getFmdgoodscategoryid()));
		}
		if (!"".equals(Utility.getName(po.getFmdiscustomize()))){
			sb.append(" and F_MD_Iscustomize=? ");
			params.add(Utility.getName(po.getFmdiscustomize()));
		}
		if (!"".equals(Utility.getName(po.getFmdsupplierid()))){
			sb.append(" and F_MD_SupplierID=? ");
			params.add(Utility.getName(po.getFmdsupplierid()));
		}
		if (!"".equals(Utility.getName(po.getFmdbrandid()))){
			sb.append(" and F_MD_BrandID=? ");
			params.add(Utility.getName(po.getFmdbrandid()));
		}
		if (!"".equals(Utility.getName(po.getFmdgoodsid()))){
			sb.append(" and F_MD_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFmdgoodsid()));
		}
		if (!"".equals(Utility.getName(po.getFmdgoodsname()))){
			sb.append(" and B_GI_GoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFmdgoodsname()));
		}
		if (!"".equals(Utility.getName(po.getFmmisshopcode()))){
			
			String[] array = Utility.getName(po.getFmmisshopcode()).split(",");
			
			sb.append(" and ( charindex((',' + ? + ','),(',' + F_MD_ShopCode + ',')) > 0 ");
			params.add(array[0]);
			
			for (int i = 1; i < array.length; i++){
				sb.append(" or charindex((',' + ? + ','),(',' + F_MD_ShopCode + ',')) > 0 ");
				params.add(array[i]);
			}
			sb.append(" ) ");
		}
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	
	public void updateMemberManagement(MemberManagementPo po) {		
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update F_MemberManagement set F_MM_UpgradeCard=? ");
		params.add(Utility.getName(po.getFmmtypeid()));
	    if (!"".equals(Utility.getName(po.getFmmmembername()))){
	    	buffer.append(" ,F_MM_MemberName=? ");
	    	params.add(Utility.getName(po.getFmmmembername()));	    	
	    }
	    if (!"".equals(Utility.getName(po.getFmmup()))){
	    	buffer.append(" ,F_MM_UP=? ");
	    	params.add(Utility.getName(po.getFmmup()));
	    }
	    if (!"".equals(Utility.getName(po.getFmmdown()))){
	    	buffer.append(" ,F_MM_DOWN=? ");
	    	params.add(Utility.getName(po.getFmmdown()));
	    }
	    if (!"".equals(Utility.getName(po.getFmmdiscount()))){	    	
	    	buffer.append(" ,F_MM_Discount=? ");
	    	params.add(Utility.getName(po.getFmmdiscount()));
	    }
	    if (!"".equals(Utility.getName(po.getFmmsubintegral()))){	    	
	    	buffer.append(" ,F_MM_Integral=? ");
	    	params.add(Utility.getName(po.getFmmsubintegral()));
	    }
	    if ("1".equals(Utility.getName(po.getFmmsetdefault()))){	    	
	    	buffer.append(" ,F_MM_IsDefault='1' ");
	    }else{
	    	buffer.append(" ,F_MM_IsDefault='0' ");
	    }
	    if ("1".equals(Utility.getName(po.getFmmisfavorable()))){	    	
	    	buffer.append(" ,F_MM_IsFavorable='1' ");
	    }else{
	    	buffer.append(" ,F_MM_IsFavorable='0' ");
	    }
	    
	    if (!"".equals(Utility.getName(po.getFmmisgoodscategoryid()))){	    	
	    	buffer.append(" ,F_MM_GoodsCategoryID = ? ");
	    	params.add(Utility.getName(po.getFmmisgoodscategoryid()));
	    }
		
	    buffer.append(" where F_MM_ID=? ");
	    params.add(Utility.getName(po.getFmmid()));		
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void deleteMemberManagement(MemberManagementPo po) {
		
		String sql="delete from F_MemberManagement where F_MM_ID='"+po.getFmmid()+"'";

        getJdbcTemplate().update(sql);
	}
	
	public MemberManagementPo getMemberManagement(MemberManagementPo po) {
		
		String sql="select top 1  F_MM_ID as fmmid,F_MM_MemberName as fmmmembername,F_MM_UP as fmmup,F_MM_DOWN as fmmdown,F_MM_Discount as fmmdiscount,F_MM_UpgradeCard as fmmtypeid,isnull(F_MM_Integral,0) as fmmsubintegral,ISNULL(F_MM_IsDefault,'0') AS fmmsetdefault,ISNULL(F_MM_IsFavorable,'0') AS fmmisfavorable,isnull(F_MM_GoodsCategoryID,'') as fmmisgoodscategoryid from F_MemberManagement where F_MM_ID='"+po.getFmmid()+"' order by F_MM_Discount";
		
		return (MemberManagementPo)queryForObject(sql,null,MemberManagementPo.class);
	}
	
	public int getMemberManagementCount(MemberManagementPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(F_MM_ID)");
		buffer.append("   from F_MemberManagement");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	public List getMemberList(MemberManagementPo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by F_MM_ID) as rowNum,F_MM_ID as fmmid,F_MM_MemberName as fmmmembername,F_MM_UP as fmmup,F_MM_DOWN as fmmdown,F_MM_Discount as fmmdiscount,isnull(temp.memberName,'') as fmmtypeid,ISNULL(F_MM_IsDefault,'0') AS fmmsetdefault,isnull(F_MM_IsFavorable,'0') as fmmisfavorable from F_MemberManagement left join (select mmid,memberName from (select F_MM_ID as mmid,F_MM_MemberName as memberName from F_MemberManagement)temp)temp on F_MM_UpgradeCard=temp.mmid ");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,
				MemberManagementPo.class);
	}
	
	public List<MemberManagementPo> getMemberManagementList() {
		
		String sql="select F_MM_ID as fmmid,F_MM_MemberName as fmmmembername,F_MM_UP as fmmup,F_MM_DOWN as fmmdown,F_MM_Discount as fmmdiscount,F_MM_UpgradeCard as fmmtypeid,F_MM_Integral as fmmsubintegral from F_MemberManagement";
		
		return queryForObjectList(sql,null,MemberManagementPo.class);
	}
	
	
	
	public int getMemberManagementName(MemberManagementPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(F_MM_ID)");
		buffer.append("   from F_MemberManagement where F_MM_MemberName = '"+Utility.getName(po.getFmmmembername())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	public int getMemberManagementNameUpdate(MemberManagementPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(F_MM_ID)");
		buffer.append("   from F_MemberManagement where F_MM_MemberName = '"+Utility.getName(po.getFmmmembername())+"' and F_MM_ID <> '"+Utility.getName(po.getFmmid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	/**
	 * 查询会员卡类型类别折扣是否存在
	 */
	public int getMemberManagementDiscountCategoryCount(MemberManagementDiscountPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select count(F_MD_ID) from F_MemberManagementDiscountSetUp ");
		sb.append(" left join B_GoodsInfo on B_GI_GoodsID = F_MD_GoodsID ");
		sb.append(" where 1=1 ");

		if(!"".equals(Utility.getName(po.getFmdmembermanagementid()))){
			sb.append(" and F_MD_MemberManagementID = ? ");
			params.add(Utility.getName(po.getFmdmembermanagementid()));
		}
		if (!"".equals(Utility.getName(po.getFmdgoodscategoryid()))){
			sb.append(" and F_MD_GoodsCategoryID=? ");
			params.add(Utility.getName(po.getFmdgoodscategoryid()));
		}
		sb.append(" and isnull(F_MD_SupplierID,'') = '' ");
		sb.append(" and isnull(F_MD_BrandID,'') = '' ");
		sb.append(" and isnull(F_MD_GoodsID,'') = '' ");
			
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 会员卡 类型是否使用
	 * 
	 */
	public int isUseMemberManagement(MemberManagementPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select count(*) from S_ME_CustomerInfo where 1=1 ");
		if(!"".equals(Utility.getName(po.getFmmid()))){
			sb.append(" and S_ME_CI_CardType = ? ");
			params.add(Utility.getName(po.getFmmid()));
		}	
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 判断会员卡积分是否重复
	 */
	public int getMemberCardIntegralArea(MemberManagementPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select sum(count1) from ( ");
		buffer.append("select count(F_MM_ID) as count1 from F_MemberManagement where cast(F_MM_DOWN as numeric)<=cast(? as numeric) and ((isnull(F_MM_UP,'')<>'' and cast(F_MM_UP as numeric)>cast(? as numeric)) or isnull(F_MM_UP,'')='')  ");
		if (!"".equals(Utility.getName(po.getFmmup()))){
			buffer.append("union all ");
			buffer.append("select count(F_MM_ID) as count1 from F_MemberManagement where cast(F_MM_DOWN as numeric)<cast(? as numeric) and ((isnull(F_MM_UP,'')<>'' and cast(F_MM_UP as numeric)>cast(? as numeric)) or isnull(F_MM_UP,'')='') ");
		}	
        buffer.append(")temp ");

		params.add(Utility.getName(po.getFmmdown()));
		params.add(Utility.getName(po.getFmmdown()));
		
		if (!"".equals(Utility.getName(po.getFmmup()))){
			params.add(Utility.getName(po.getFmmup()));
			params.add(Utility.getName(po.getFmmup()));
		}
		
		return this.getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	public void updateMemberManagementDefault(MemberManagementPo po) {		
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update F_MemberManagement set F_MM_IsDefault='0' ");
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void insertMemberManagementDiscountSetUpDetails(MemberManagementDiscountSetUpDetailsPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into F_MemberManagementDiscountSetUpDetails (");
		buffer.append(" F_MDD_UUID, ");
		buffer.append(" F_MDD_SetUpId, ");
		buffer.append(" F_MDD_GoodsLevel, ");
		buffer.append(" F_MDD_Discount ");
		buffer.append(" )values( ");
		buffer.append(" ?, ");
		buffer.append(" ?, ");
		buffer.append(" ?, ");
		buffer.append(" ? ");
		buffer.append(" ) ");
		
		params.add(this.uuid.generate());
		params.add(po.getFmddsetupid());
		params.add(po.getFmddgoodslevel());
		params.add(po.getFmdddiscount());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public List<MemberManagementDiscountSetUpDetailsPo> selectMemberManagementDiscountSetUpDetails(MemberManagementDiscountSetUpDetailsPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select ");
		buffer.append("	F_MDD_UUID 					as fmdduuid, 			");
		buffer.append(" F_MDD_SetUpId				as fmddsetupid, 			");
		buffer.append(" B_GL_UUID					as fmddgoodslevel, 		");
		buffer.append(" B_GL_Name					as fmddgoodslevelname, 	");
		buffer.append(" F_MDD_Discount				as fmdddiscount			");
		buffer.append(" from B_GoodsLevel ");
		buffer.append(" left join F_MemberManagementDiscountSetUpDetails on F_MDD_GoodsLevel = B_GL_UUID and F_MDD_SetUpId = ?");
		buffer.append(" order by B_GL_ID ");
		
		params.add(po.getFmddsetupid());

		return queryForObjectList(buffer.toString(), params.toArray(),MemberManagementDiscountSetUpDetailsPo.class);
	}
	
	public void deleteMemberManagementDiscountSetUpDetailss(String pid) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" delete from F_MemberManagementDiscountSetUpDetails ");
		buffer.append(" where F_MDD_SetUpId = ? ");
		
		params.add(pid);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}
