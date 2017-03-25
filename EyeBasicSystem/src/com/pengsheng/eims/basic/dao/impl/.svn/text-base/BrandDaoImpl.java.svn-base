package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.BrandDao;
import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsLevelPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.system.persistence.FuctionTreeNode;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class BrandDaoImpl extends BaseJdbcDaoSupport implements BrandDao {

	public List<BrandPo> getAjaxBrands_ByName(BrandPo brandPo){
		StringBuffer buffer = new StringBuffer();
		buffer.append("select distinct B_BD_GoodsCategory+'.'+B_BD_SupplierID+'.'+B_BD_ID as bbdid,B_BD_brandName as bbdbrandname from B_Brand ");

		List<String> params = new ArrayList<String>();

		buffer.append("where 1=1 ");

		// 商品类别
		if (!"".equals(Utility.getName(brandPo.getBspcategoryid()))) {
			buffer.append(" and B_BD_GoodsCategory = ? ");
			params.add(brandPo.getBspcategoryid());
		}

		// 制造商代码
		if (!"".equals(Utility.getName(brandPo.getBbdsupplierid()))) {
			buffer.append(" and B_BD_SupplierID = ? ");
			params.add(brandPo.getBbdsupplierid());
		}
		
		// 品种名称
		if (!"".equals(Utility.getName(brandPo.getBbdbrandname()))) {
			buffer.append(" and B_BD_brandName like '%' + ? + '%' or B_BD_MnemonicCode like '%' + ? + '%' ");
			params.add(brandPo.getBbdbrandname());
			params.add(brandPo.getBbdbrandname());
		}
		return queryForObjectList(buffer.toString(), params.toArray(),BrandPo.class);
	}
	
	public List<BrandPo> getBrands(BrandPo brandPo, int start, int size) {
		
		StringBuffer buffer = new StringBuffer();

		int countPage = start + size;

		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by B_SP_CategoryID, B_BD_ID) as 'rowNum', ");
		buffer.append("B_BD_ID as bbdid ");
		buffer.append(",B_BD_brandName as bbdbrandname ");
		buffer.append(",B_BD_SupplierID as bbdsupplierid, ");
		buffer.append("B_SP_SupplierName as bspsuppliername, ");
		buffer.append("B_SP_CategoryID as bspcategoryid, ");
		buffer.append("B_BD_GoodsCategory as bbdgoodscategory, ");
		buffer.append("B_GC_GoodsCategoryName as bgcgoodscategoryname, ");
		buffer.append("B_BD_SalesStatue as bbdsalesstatue,B_BD_Settlement AS bbdsettlement,B_BD_SettlementMonth AS bbdsettlementmonth ");
		buffer.append(" from b_brand ");
		buffer.append("inner join B_Supplier ON B_Supplier.B_SP_ID = B_BD_SupplierID ");
		buffer.append("left join B_GoodsCategory on B_GC_ID = B_BD_GoodsCategory ");

		buffer.append(" where 1 = 1 and B_BD_SupplierID<>'ZZ' ");

		// 品种代码
		if (!"".equals(Utility.getName(brandPo.getBbdid()))) {
			buffer.append(" and B_BD_ID like '%' + ? + '%' ");
			params.add(brandPo.getBbdid());
		}

		// 品种名称
		if (!"".equals(Utility.getName(brandPo.getBbdbrandname()))) {
			buffer.append(" and B_BD_brandName like '%' + ? + '%' ");
			params.add(brandPo.getBbdbrandname());
		}

		// 制造商代码
		if (!"".equals(Utility.getName(brandPo.getBbdsupplierid()))) {
			buffer.append(" and B_BD_SupplierID = ? ");
			params.add(brandPo.getBbdsupplierid());
		}

		// 商品类别
		if (!"".equals(Utility.getName(brandPo.getBspcategoryid()))) {
			buffer.append(" and B_BD_GoodsCategory = ? ");
			params.add(brandPo.getBspcategoryid());
		}

		// 品种速记码
		if (!"".equals(Utility.getName(brandPo.getBbdmnemoniccode()))) {
			buffer.append(" and B_BD_MnemonicCode like '%' + ? + '%' ");
			params.add(brandPo.getBbdmnemoniccode());
		}
		if (!"".equals(Utility.getName(brandPo.getBbdsalesstatue()))) {
			buffer.append(" and B_BD_SalesStatue=? ");
			params.add(Utility.getName(brandPo.getBbdsalesstatue()));
		}
		
		if (!"".equals(Utility.getName(brandPo.getBbdsettlement()))) {
			if("empty".equals(Utility.getName(brandPo.getBbdsettlement()))){
				buffer.append(" and isnull(B_BD_Settlement,'') = '' ");
			}else{
				buffer.append(" and B_BD_Settlement=? ");
				params.add(Utility.getName(brandPo.getBbdsettlement()));
			}
		}
		
		if("2".equals(Utility.getName(brandPo.getBbdissetflag()))){
        	buffer.append(" and isnull(B_BD_PayFeeID,'') = '' ");
        }
        
        if("3".equals(Utility.getName(brandPo.getBbdissetflag()))){
        	if (!"".equals(Utility.getName(brandPo.getBbdpayfeeid()))){
        		buffer.append(" and isnull(B_BD_PayFeeID,'') = ? ");
        		params.add(Utility.getName(brandPo.getBbdpayfeeid()));
        	}else{
        		buffer.append(" and isnull(B_BD_PayFeeID,'') <> '' ");
        	}
        } 
		
		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(), BrandPo.class);
	}

	public int getBrandsCount(BrandPo brandPo) {
		
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		buffer.append("select count(B_BD_ID) from b_brand ");
		buffer.append("inner join B_Supplier ON B_Supplier.B_SP_ID = B_BD_SupplierID ");
		buffer.append("left join B_GoodsCategory on B_GC_ID = B_BD_GoodsCategory ");

		buffer.append(" where 1 = 1 and B_BD_SupplierID<>'ZZ' ");

		// 品种代码
		if (!"".equals(Utility.getName(brandPo.getBbdid()))) {
			buffer.append(" and B_BD_ID like '%' + ? + '%' ");
			params.add(brandPo.getBbdid());
		}

		// 品种名称
		if (!"".equals(Utility.getName(brandPo.getBbdbrandname()))) {
			buffer.append(" and B_BD_brandName like '%' + ? + '%' ");
			params.add(brandPo.getBbdbrandname());
		}

		// 制造商代码
		if (!"".equals(Utility.getName(brandPo.getBbdsupplierid()))) {
			buffer.append(" and B_BD_SupplierID = ? ");
			params.add(brandPo.getBbdsupplierid());
		}

		// 商品类别
		if (!"".equals(Utility.getName(brandPo.getBspcategoryid()))) {
			buffer.append(" and B_BD_GoodsCategory = ? ");
			params.add(brandPo.getBspcategoryid());
		}

		// 品种速记码
		if (!"".equals(Utility.getName(brandPo.getBbdmnemoniccode()))) {
			buffer.append(" and B_BD_MnemonicCode like '%' + ? + '%' ");
			params.add(brandPo.getBbdmnemoniccode());
		}

		if (!"".equals(Utility.getName(brandPo.getBbdsalesstatue()))) {
			buffer.append(" and B_BD_SalesStatue=? ");
			params.add(Utility.getName(brandPo.getBbdsalesstatue()));
		}
		
		if (!"".equals(Utility.getName(brandPo.getBbdsettlement()))) {
			if("empty".equals(Utility.getName(brandPo.getBbdsettlement()))){
				buffer.append(" and isnull(B_BD_Settlement,'') = '' ");
			}else{
				buffer.append(" and B_BD_Settlement=? ");
				params.add(Utility.getName(brandPo.getBbdsettlement()));
			}
		}
		
        if("2".equals(Utility.getName(brandPo.getBbdissetflag()))){
        	buffer.append(" and isnull(B_BD_PayFeeID,'') = '' ");
        }
        
        if("3".equals(Utility.getName(brandPo.getBbdissetflag()))){
        	if (!"".equals(Utility.getName(brandPo.getBbdpayfeeid()))) {
        		buffer.append(" and isnull(B_BD_PayFeeID,'') = ? ");
        		params.add(Utility.getName(brandPo.getBbdpayfeeid()));
        	}else{
        		buffer.append(" and isnull(B_BD_PayFeeID,'') <> '' ");
        	}
        } 

		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public BrandPo getBrandPo(BrandPo brandPo) {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select top 1 ");
		buffer.append("B_BD_ID as bbdid ");
		buffer.append(",B_BD_MnemonicCode as bbdmnemoniccode ");
		buffer.append(",B_BD_brandName as bbdbrandname ");
		buffer.append(",B_BD_SupplierID as bbdsupplierid ");
		buffer.append(",B_BD_Place as bbdplace ");
		buffer.append(",B_SP_SupplierName as bspsuppliername ");
		buffer.append(",B_BD_GoodsCategory as bbdgoodscategory ");
		buffer.append(",B_GC_GoodsCategoryName as bgcgoodscategoryname ");
		buffer.append(",B_BD_Refractive as bbdrefractive ");
		buffer.append(",B_BD_SalesStatue as bbdsalesstatue ");
		buffer.append(",B_BD_DistributionMethods as bbddistributionmethods ");
		buffer.append(",B_BD_Unit as bbdunit,B_UT_unitName as bbdunitname ");
		buffer.append(",B_FM_Name as bbdframematerialtypename ");
		buffer.append(",B_BD_FrameMaterialType as bbdframematerialtype ");
		buffer.append(",B_BD_MaterialClass as bbdmaterialclass ");
		buffer.append(",B_BD_LuminosityClass as bbdluminosityclass ");
		buffer.append(",B_BD_GradualClass as bbdgradualclass ");
		buffer.append(",B_BD_FunctionClass as bbdfunctionclass ");
		buffer.append(",B_BD_UseType as bbdusetype ");
		buffer.append(",B_BD_StealthClass as bbdstealthclass ");
		buffer.append(",B_BD_Settlement AS bbdsettlement ");
		buffer.append(",B_BD_SettlementMonth AS bbdsettlementmonth ");
		buffer.append(",B_BD_DefaultDiscount AS bbddefaultdiscount ");
		buffer.append(",B_BD_BarCodeFlag AS bbdbarcodeflag ");
		buffer.append(",B_GL_Name			 AS bbddefaultdiscountname ");
		buffer.append(",B_BD_Promotion			 AS bbdpromotion ");
		buffer.append(",isnull(B_BD_RegistrationNum,'')			 AS bbdregistrationnum ");
		buffer.append(",B_BD_PayFeeID			 AS bbdpayfeeid ");
		buffer.append(" from b_brand ");
		buffer.append(" left join B_GoodsCategory on B_GC_ID = B_BD_GoodsCategory ");
		buffer.append(" left join B_Unit on B_BD_Unit = B_UT_id ");
		buffer.append(" left join B_FrameMaterial on B_BD_FrameMaterialType = B_FM_ID ");
		buffer.append(" left join B_Supplier on B_SP_ID = B_BD_SupplierID ");
		buffer.append(" left join B_GoodsLevel on B_BD_DefaultDiscount = B_GL_UUID ");
		buffer.append(" where 1 = 1");

		List<String> params = new ArrayList<String>();

		// 品种代码
		if (!"".equals(Utility.getName(brandPo.getBbdid()))) {
			buffer.append(" and B_BD_ID=? ");
			params.add(Utility.getName(brandPo.getBbdid()));
		}

		// 品种名称
		if (!"".equals(Utility.getName(brandPo.getBbdbrandname()))) {
			buffer.append(" and B_BD_brandName like '%' + ? + '%' ");
			params.add(brandPo.getBbdbrandname());
		}

		// 制造商代码
		if (!"".equals(Utility.getName(brandPo.getBbdsupplierid()))) {
			buffer.append(" and B_BD_SupplierID = ? ");
			params.add(brandPo.getBbdsupplierid());
		}

		return (BrandPo) this.queryForObject(buffer.toString(), params.toArray(), BrandPo.class);
	}

	public void delBrand(BrandPo brandPo) {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("DELETE FROM B_Brand ");
		buffer.append("WHERE B_BD_ID = ? ");
		buffer.append(" AND B_BD_SupplierID = ?");

		List<String> params = new ArrayList<String>();
		params.add(brandPo.getBbdid());
		params.add(brandPo.getBbdsupplierid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void insertBrand(BrandPo brandPo) {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("INSERT INTO B_Brand ");
		buffer.append("(B_BD_ID ");
		buffer.append(",B_BD_MnemonicCode ");
		buffer.append(",B_BD_brandName ");
		buffer.append(",B_BD_SupplierID ");
		buffer.append(",B_BD_Place ");
		buffer.append(",B_BD_GoodsCategory ");
		buffer.append(",B_BD_Refractive ");
		buffer.append(",B_BD_SalesStatue ");		
		buffer.append(",B_BD_Unit,B_BD_FrameMaterialType,B_BD_MaterialClass,B_BD_LuminosityClass,B_BD_GradualClass,B_BD_FunctionClass,B_BD_UseType,B_BD_StealthClass,B_BD_Settlement,B_BD_SettlementMonth ");
		buffer.append(",B_BD_DefaultDiscount,B_BD_BarCodeFlag,B_BD_Promotion,B_BD_RegistrationNum ");
		buffer.append(",B_BD_PayFeeID) ");
		
		buffer.append("VALUES (?, ?, ?, ?, ?, ?, ?, '1', ?, ?, ?, ?, ?,?,?,?,?,?,?,? ");
		if (!"".equals(Utility.getName(brandPo.getBbdpromotion()))){
			buffer.append(" ,? ");
		}else{
			buffer.append(" ,NULL ");
		}		
		buffer.append(" ,?   ");
		buffer.append(" ,? ) ");

		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(brandPo.getBbdid()));
		params.add(Utility.getName(brandPo.getBbdmnemoniccode()));
		params.add(Utility.getName(brandPo.getBbdbrandname()));
		params.add(Utility.getName(brandPo.getBbdsupplierid()));
		params.add(Utility.getName(brandPo.getBbdplace()));
		params.add(Utility.getName(brandPo.getBbdgoodscategory()));
		params.add(Utility.getName(brandPo.getBbdrefractive()));
		params.add(Utility.getName(brandPo.getBbdunit()));		
		params.add(Utility.getName(brandPo.getBbdframematerialtype()));
		params.add(Utility.getName(brandPo.getBbdmaterialclass()));
		params.add(Utility.getName(brandPo.getBbdluminosityclass()));
		params.add(Utility.getName(brandPo.getBbdgradualclass()));
		params.add(Utility.getName(brandPo.getBbdfunctionclass()));
		params.add(Utility.getName(brandPo.getBbdusetype()));
		params.add(Utility.getName(brandPo.getBbdstealthclass()));
		params.add(Utility.getName(brandPo.getBbdsettlement()));
		params.add(Utility.getName(brandPo.getBbdsettlementmonth()));
		params.add(Utility.getName(brandPo.getBbddefaultdiscount()));
		params.add(Utility.getName(brandPo.getBbdbarcodeflag()));
		if (!"".equals(Utility.getName(brandPo.getBbdpromotion()))){
			params.add(Utility.getName(brandPo.getBbdpromotion()));
		}
		params.add(Utility.getName(brandPo.getBbdregistrationnum()));
		params.add(Utility.getName(brandPo.getBbdpayfeeid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}

	public void updateBrand(BrandPo brandPo) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("UPDATE B_Brand ");
		buffer.append("SET B_BD_brandName = ? ");
		buffer.append(",B_BD_MnemonicCode = ? ");
		buffer.append(",B_BD_Place = ? ");
		buffer.append(",B_BD_Unit=?,B_BD_Refractive=? ");
		buffer.append(",B_BD_FrameMaterialType = ?,B_BD_MaterialClass=?,B_BD_LuminosityClass=?,B_BD_GradualClass=?,B_BD_FunctionClass=?,B_BD_UseType=?,B_BD_StealthClass=?,B_BD_Settlement=?,B_BD_SettlementMonth=?,B_BD_BarCodeFlag=? ");
		params.add(brandPo.getBbdbrandname());
		params.add(brandPo.getBbdmnemoniccode());
		params.add(brandPo.getBbdplace());
		params.add(Utility.getName(brandPo.getBbdunit()));
		params.add(Utility.getName(brandPo.getBbdrefractive()));
		params.add(Utility.getName(brandPo.getBbdframematerialtype()));
		params.add(Utility.getName(brandPo.getBbdmaterialclass()));
		params.add(Utility.getName(brandPo.getBbdluminosityclass()));
		params.add(Utility.getName(brandPo.getBbdgradualclass()));
		params.add(Utility.getName(brandPo.getBbdfunctionclass()));
		params.add(Utility.getName(brandPo.getBbdusetype()));
		params.add(Utility.getName(brandPo.getBbdstealthclass()));
		params.add(Utility.getName(brandPo.getBbdsettlement()));
		params.add(Utility.getName(brandPo.getBbdsettlementmonth()));
		params.add(Utility.getName(brandPo.getBbdbarcodeflag()));
		
		if(!"".equals(Utility.getName(brandPo.getBbddefaultdiscount()))){
			buffer.append(",B_BD_DefaultDiscount = ? ");
			params.add(Utility.getName(brandPo.getBbddefaultdiscount()));
		}
		
		if(!"".equals(Utility.getName(brandPo.getBbdpromotion()))){
			buffer.append(",B_BD_Promotion = ? ");
			params.add(Utility.getName(brandPo.getBbdpromotion()));
		}else{
			buffer.append(",B_BD_Promotion = NULL ");
		}
		
		buffer.append(",B_BD_RegistrationNum = ? ");
		params.add(Utility.getName(brandPo.getBbdregistrationnum()));
		
		buffer.append(",B_BD_PayFeeID = ? ");
		params.add(Utility.getName(brandPo.getBbdpayfeeid()));
		
		buffer.append("WHERE B_BD_ID = ? ");
		buffer.append("AND B_BD_SupplierID = ?");
		
		params.add(brandPo.getBbdid());
		params.add(brandPo.getBbdsupplierid());
		
		if("1".equals(Utility.getName(brandPo.getUpdateGoodsDefaultDiscount()))){
			buffer.append(" UPDATE B_GoodsInfo ");
			buffer.append("SET B_GI_DefaultDiscountValue = ? ");
			buffer.append("WHERE B_GI_BrandID = ? ");
			buffer.append("  AND B_GI_SupplierID = ?");
			
			params.add(Utility.getName(brandPo.getBbddefaultdiscount()));
			params.add(brandPo.getBbdid());
			params.add(brandPo.getBbdsupplierid());
		}

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public SupplierPo getSupplier(SupplierPo po) {

		StringBuffer buffer = new StringBuffer();

		buffer.append("select top 1  B_SP_ID as bspid,B_SP_SupplierName as bspsuppliername,B_SP_ContactPerson as bspcontactperson,");
		buffer.append("B_SP_ContactPhone as bspcontactphone,B_SP_Fax as bspfax,B_SP_Address as bspaddress,");
		buffer.append("B_SP_Remark as bspremark,B_SP_CategoryID as bspcategoryid,");
		buffer.append("B_SP_Flag as bspflag from B_Supplier where 1=1");

		List<String> params = new ArrayList<String>();

		// 制造商代码
		if (!"".equals(Utility.getName(po.getBspid()))) {
			buffer.append(" and B_SP_ID = ? ");
			params.add(po.getBspid());
		}

		return (SupplierPo) queryForObject(buffer.toString(), params.toArray(),
				SupplierPo.class);
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {

		String sql = "select B_GC_ID as bgcid,B_GC_GoodsCategoryName as bgcgoodscategoryname from B_GoodsCategory  order by B_GC_Order";

		return queryForObjectList(sql, null, GoodsCategoryPo.class);
	}


	public int getGoodsCount(BrandPo brandPo) {
		
		StringBuffer sb = new StringBuffer();
		
		List<String> params = new ArrayList<String>();
		 sb.append("select count(b_gi_goodsid) from b_goodsinfo where 1=1 ");
		 if(brandPo.getBbdsupplierid()!=null&&brandPo.getBbdid()!=null){
			 sb.append("and b_gi_supplierid=? ");
			 sb.append("and b_gi_brandid=? ");
			 params.add(brandPo.getBbdsupplierid());
			 params.add(brandPo.getBbdid());
			 
		 }
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

	/**
	 * Description :修改品种状态（停用启用）
	 * @param：BrandPo 品种信息伴实体	 
	 * @return :品种信息的列表
	 **/
	public void brandEnbledUpdate(BrandPo brandPo){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("UPDATE B_Brand SET B_BD_SalesStatue = ? ");
		buffer.append(" WHERE B_BD_ID = ? ");
		buffer.append(" AND B_BD_SupplierID = ?");

		List<String> params = new ArrayList<String>();

		params.add(Utility.getName(brandPo.getBbdsalesstatue()));
		params.add(Utility.getName(brandPo.getBbdid()));
		params.add(brandPo.getBbdsupplierid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}
	
	/**
	 * Description :修改商品状态（停用启用）
	 * @param：BrandPo 品种信息伴实体
	 **/
	public void goodsEnbledUpdate(BrandPo brandPo){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("UPDATE B_GoodsInfo SET B_GI_Flag = ? ");
		buffer.append(" WHERE B_GI_BrandID = ? ");
		buffer.append(" AND B_GI_SupplierID = ?");

		List<String> params = new ArrayList<String>();

		params.add(Utility.getName(brandPo.getBbdsalesstatue()));		
		params.add(Utility.getName(brandPo.getBbdid()));
		params.add(Utility.getName(brandPo.getBbdsupplierid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}
	
	/**
	 * 更新品种下商品的名称
	 * 
	 * @param brandPo
	 */
	public void updateGoodsNameByBrand(BrandPo brandPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("UPDATE B_GoodsInfo SET B_GI_GoodsName = ? ");
		buffer.append(" WHERE B_GI_BrandID = ? ");
		buffer.append(" AND B_GI_SupplierID = ?");
		
		params.add(Utility.getName(brandPo.getBbdbrandname()));		
		params.add(Utility.getName(brandPo.getBbdid()));
		params.add(Utility.getName(brandPo.getBbdsupplierid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 更新品种下商品的默认折扣
	 * 
	 * @param brandPo
	 */
	public void updateGoodsNameByDefaultDiscount(BrandPo brandPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("UPDATE B_GoodsInfo SET B_GI_DefaultDiscountValue = ? ");
		buffer.append(" WHERE B_GI_BrandID = ? ");
		buffer.append(" AND B_GI_SupplierID = ?");
		
		params.add(Utility.getName(brandPo.getBbddefaultdiscount()));		
		params.add(Utility.getName(brandPo.getBbdid()));
		params.add(Utility.getName(brandPo.getBbdsupplierid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 取所有商品类型(组织结构)
	 * 
	 * @return
	 */
	public List<FuctionTreeNode> getGoodsCategoryTree(String nodeId,String hrefTarget,String href,String isClosed){
		
		List<String> params = new ArrayList<String>();
		
		String sql="select ('T_'+B_GC_ID) as id,B_GC_GoodsCategoryName as [text],'false' as leaf,? as hrefTarget,('selSupplier.action?moduleID='+?+'&goodsTree=1&goodsCategoryID='+B_GC_ID) as href from B_GoodsCategory ";
		
		params.add(hrefTarget);
		params.add(href);
		
		return queryForObjectList(sql, params.toArray(), FuctionTreeNode.class);	
	}
	
	/**
	 * 根据商品类型查询制造商(组织结构)
	 * 
	 * @return
	 */
	public List<FuctionTreeNode> getSupplierByGoodsCategoryTree(String nodeId,String hrefTarget,String href,String isClosed){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select distinct ('S_'+?+'_'+B_SP_ID) as id,B_SP_SupplierName as [text],'false' as leaf,? as hrefTarget,('selSupplierTree.action?moduleID='+?+'&supplierID='+B_SP_ID+'&parent=1&goodsTree=1&supplierName='+B_SP_SupplierName+'&goodsCategoryID='+?) as href from B_Supplier where B_SP_CategoryID like '%' + ? + '%' and B_SP_ID<>'ZZ' ");
		
		params.add(nodeId);
		params.add(hrefTarget);
		params.add(href);
		params.add(Utility.getName(nodeId.split("_")[1]));
		params.add(Utility.getName(nodeId.split("_")[1]));
		
		return queryForObjectList(buffer.toString(), params.toArray(), FuctionTreeNode.class);		
	}
	
	/**
	 * 根据制造商查询品种(组织结构)
	 * 
	 * @return
	 */
	public List<FuctionTreeNode> getBrandBySupplierTree(String nodeId,String hrefTarget,String href,String isClosed,String fspshowsupplier){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		if("1".equals(fspshowsupplier)){
			buffer.append("select distinct ('B_'+?+'_'+B_BD_ID) as id,B_BD_brandName as [text],'false' as leaf,'true' as singleClickExpand,? as hrefTarget,('selBrandTree.action?moduleID='+?+'&selbbdid='+B_BD_ID+'&selbbdsupplierid='+B_BD_SupplierID+'&selbspcategoryid='+B_BD_GoodsCategory+'&selbbdbrandname='+B_BD_brandName+'&goodsTree=1&selbspsuppliername='+B_SP_SupplierName) as href from B_Brand inner join B_Supplier on B_SP_ID=B_BD_SupplierID where B_BD_SupplierID=? and B_BD_GoodsCategory=?  ");
			params.add(nodeId);
			params.add(hrefTarget);
			params.add(href);
			params.add(Utility.getName(nodeId.split("_")[3]));
			params.add(Utility.getName(nodeId.split("_")[2]));
		}else
		{
			buffer.append("select distinct ('B_S_'+?+'_'+B_BD_SupplierID+'_'+B_BD_ID) as id,B_BD_brandName as [text],'false' as leaf,'true' as singleClickExpand,? as hrefTarget,('selBrandTree.action?moduleID='+?+'&selbbdid='+B_BD_ID+'&selbbdsupplierid='+B_BD_SupplierID+'&selbspcategoryid='+B_BD_GoodsCategory+'&selbbdbrandname='+B_BD_brandName+'&goodsTree=1&selbspsuppliername='+B_SP_SupplierName) as href from B_Brand inner join B_Supplier on B_SP_ID=B_BD_SupplierID where 'T_'+B_BD_GoodsCategory=? and B_SP_ID<>'ZZ' ");
			params.add(nodeId);
			params.add(hrefTarget);
			params.add(href);
			params.add(nodeId);
		}
		return queryForObjectList(buffer.toString(), params.toArray(), FuctionTreeNode.class);	
	}
	
	/**
	 * 根据品种查询商品(组织结构)
	 * 
	 * @return
	 */
	public List<FuctionTreeNode> getGoodsByBrandTree(String nodeId,String hrefTarget,String href,String isClosed){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select distinct ('G_'+?+'_'+B_GI_GoodsID+'_'+isnull(B_GI_isCustomize,'0')) as id,B_GI_GoodsName as [text],'true' as leaf,? as hrefTarget,");
		
		buffer.append("( ");
		buffer.append("case B_GI_GoodsCategoryID ");
		buffer.append("    when '1' then 'selGlassesFrame.action?moduleID='+?+'&goodsTree=1&goodsID='+B_GI_GoodsID+'&goodsName='+B_GI_GoodsName+'&whichretail=1&select_retail=1' ");
		buffer.append("    when '2' then 'selGlassesAccessories.action?moduleID='+?+'&goodsTree=1&goodsID='+B_GI_GoodsID+'&goodsName='+B_GI_GoodsName+'&whichretail=1&select_retail=1'  ");
		buffer.append("    when '3' then (case B_GI_isCustomize when '0' then 'selLensFinished.action?moduleID='+?+'&goodsTree=1&goodsID='+B_GI_GoodsID+'&goodsName='+B_GI_GoodsName+'&whichretail=1&select_retail=1' else 'selLensCustom.action?moduleID='+?+'&goodsTree=1&goodsID='+B_GI_GoodsID+'&goodsName='+B_GI_GoodsName+'&whichretail=1&select_retail=1' end )  ");
		buffer.append("    when '4' then (case B_GI_isCustomize when '0' then 'selStealthFinished.action?moduleID='+?+'&goodsID='+B_GI_GoodsID+'&goodsTree=1&goodsName='+B_GI_GoodsName+'&whichretail=1&select_retail=1' else 'selStealthCustomLenses.action?moduleID='+?+'&goodsTree=1&goodsID='+B_GI_GoodsID+'&goodsName='+B_GI_GoodsName+'&whichretail=1&select_retail=1' end )   ");
		buffer.append("    when '5' then 'selStealthAccessories.action?moduleID='+?+'&goodsTree=1&goodsID='+B_GI_GoodsID+'&goodsName='+B_GI_GoodsName+'&whichretail=1&select_retail=1' ");
		buffer.append("    when '6' then 'selGlassesFinish.action?moduleID='+?+'&goodsTree=1&goodsID='+B_GI_GoodsID+'&goodsName='+B_GI_GoodsName+'&whichretail=1&select_retail=1' ");
		buffer.append("    when '7' then 'selOtherGoods.action?moduleID='+?+'&goodsTree=1&goodsID='+B_GI_GoodsID+'&goodsName='+B_GI_GoodsName+'&whichretail=1&select_retail=1' ");
		buffer.append("    when '8' then 'selPresbyopicGlasses.action?moduleID='+?+'&goodsTree=1&goodsID='+B_GI_GoodsID+'&goodsName='+B_GI_GoodsName+'&whichretail=1&select_retail=1' ");
		buffer.append("    when '9' then 'selVisualOptics.action?moduleID='+?+'&goodsTree=1&goodsID='+B_GI_GoodsID+'&goodsName='+B_GI_GoodsName+'&whichretail=1&select_retail=1' ");
		buffer.append("end   ");
		buffer.append(") as href from B_GoodsInfo where B_GI_GoodsCategoryID=? and B_GI_SupplierID=? and B_GI_BrandID=? ");
		
		params.add(nodeId);
		params.add(hrefTarget);
		params.add(href);
		params.add(href);
		params.add(href);
		params.add(href);
		params.add(href);
		params.add(href);
		params.add(href);
		params.add(href);
		params.add(href);
		params.add(href);
		params.add(href);
		params.add(Utility.getName(nodeId.split("_")[3]));
		params.add(Utility.getName(nodeId.split("_")[4]));
		params.add(Utility.getName(nodeId.split("_")[5]));
		
		return queryForObjectList(buffer.toString(), params.toArray(), FuctionTreeNode.class);	
	}
	/**
	 * 更具树形获取商品信息
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> getGoodsTree(GoodsInfoPo po, int start, int size){
		int countPage = start + size;
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from (select ROW_NUMBER() ");
		sb.append("Over(order by B_GI_GoodsID) as 'rowNum', ");
		sb.append("       B_GI_GoodsID         AS bgigoodsid, ");
		sb.append("       B_GI_GoodsBarCode    AS bgigoodsBarCode, ");
		sb.append("       B_GI_GoodsName       AS bgigoodsname, ");
		sb.append("       B_BD_brandName       AS bgibrandname, ");
		sb.append("       B_UT_unitName        AS bgiunitname, ");
		sb.append("       B_GI_isCustomize        AS bgiiscustomize, ");
		sb.append("       B_GI_Flag            AS bgiflag, ");
		sb.append("       B_GI_RetailPrice     AS bgiretailprice ");
		sb.append("FROM   B_GoodsInfo ");
		sb.append("       LEFT JOIN B_Unit ");
		sb.append("         ON B_GI_UnitId = B_UT_id ");
		sb.append(" left join B_Brand on B_BD_SupplierID=B_GI_SupplierID and B_BD_ID=B_GI_BrandID ");
		sb.append("WHERE  1=1 ");
		// 系列代码
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append("  AND B_GI_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}

		// 品种代码
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" AND B_GI_BrandID = ? ");
			params.add(po.getBgibrandid());
		}
		// 定制
		if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
			sb.append(" AND B_GI_isCustomize = ? ");
			params.add(po.getBgiiscustomize());
		}

	
		sb.append(") table1 where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append("set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), GoodsInfoPo.class);
		
	}
	
	
	/**
	 * 更具树获取商品数量
	 * @param po
	 * @return
	 */
	public int getGoodsTreeCount(GoodsInfoPo po) {
		
		StringBuffer sb = new StringBuffer();
		
		List<String> params = new ArrayList<String>();
		sb.append("SELECT COUNT(B_GI_GoodsID) ");
		sb.append("FROM   B_GoodsInfo ");
		sb.append("       LEFT JOIN B_Unit ");
		sb.append("         ON B_GI_UnitId = B_UT_id ");
		sb.append("WHERE  1=1 ");
		// 系列代码
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append("  AND B_GI_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}

		// 品种代码
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" AND B_GI_BrandID = ? ");
			params.add(po.getBgibrandid());
		}

		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 获取商品等级LIST
	 * @param po
	 * @return
	 */
	public List<GoodsLevelPo> selectGoodsLevelList(GoodsLevelPo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select ");
		sb.append("B_GL_UUID 		as bgluuid, ");
		sb.append("B_GL_ID 			as bglid, ");
		sb.append("B_GL_Name		as bglname, ");
		sb.append("B_GL_Discount 	as bgldiscount, ");
		sb.append("B_GL_CategoryID	as bglcategoryid ");
		sb.append("from B_GoodsLevel ");
		sb.append("order by B_GL_ID ");
	
		return queryForObjectList(sb.toString(), params.toArray(), GoodsLevelPo.class);
	}
}
