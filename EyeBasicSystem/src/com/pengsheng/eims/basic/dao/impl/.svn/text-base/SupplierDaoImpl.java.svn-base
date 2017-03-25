package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.SupplierDao;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.StatusModulePo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class SupplierDaoImpl extends BaseJdbcDaoSupport implements SupplierDao {

	/**
	 * 查询制造商的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getSupplierCount(SupplierPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select count(B_SP_ID) from B_Supplier where 1=1 and B_SP_ID <> 'ZZ' ");
		
		if (!"".equals(Utility.getName(po.getBspid()))) {
			sb.append(" and B_SP_ID like '%" + po.getBspid() + "%' ");
		}
		if (!"".equals(Utility.getName(po.getBspsuppliername()))) {
			sb.append(" and B_SP_SupplierName like '%" + po.getBspsuppliername() + "%'");
		}
		if (!"".equals(Utility.getName(po.getBspcategoryid()))) {
			sb.append(" and B_SP_CategoryID like '%" + po.getBspcategoryid() + "%'");
		}
		if (!"".equals(Utility.getName(po.getBspsuppliermnemonic()))) {
			sb.append(" and B_SP_SupplierMnemonic like '%" + po.getBspsuppliermnemonic() + "%'");
		}
		if (!"".equals(Utility.getName(po.getBspdistributionmethods()))) {
			sb.append(" and B_SP_DistributionMethods = '" + po.getBspdistributionmethods() + "'");
		}
		if (!"".equals(Utility.getName(po.getBspflag()))) {
			sb.append(" and B_SP_Flag = '" +Utility.getName(po.getBspflag()) + "'");
		}
		if (!"".equals(Utility.getName(po.getBspmakeinvoiceflag()))) {
			sb.append(" and isnull(B_SP_MakeInvoiceFlag,'') = '" +Utility.getName(po.getBspmakeinvoiceflag()) + "'");
		}
		if("1".equals(po.getBsplicencetype())){
			if("0".equals(po.getBsplicencestate())){
				sb.append("		and DATEDIFF (day,getdate(),B_SP_LicenceValidity) > 0 ");
			}else if("1".equals(po.getBsplicencestate())){
				sb.append("		and DATEDIFF (day,getdate(),B_SP_LicenceValidity) <= 0 and isnull(B_SP_LicenceValidity,'') <> '' ");
			}else if("2".equals(po.getBsplicencestate())){
				sb.append("		and isnull(B_SP_LicenceValidity,'') = '' ");
			}
		}else if("2".equals(po.getBsplicencetype())){
			if("0".equals(po.getBsplicencestate())){
				sb.append("		and DATEDIFF (day,getdate(),B_SP_YLicenceValidity) > 0 ");
			}else if("1".equals(po.getBsplicencestate())){
				sb.append("		and DATEDIFF (day,getdate(),B_SP_YLicenceValidity) <= 0 and isnull(B_SP_YLicenceValidity,'') <> '' ");
			}else if("2".equals(po.getBsplicencestate())){
				sb.append("		and isnull(B_SP_YLicenceValidity,'') = '' ");
			}
		}else if("3".equals(po.getBsplicencetype())){
			if("0".equals(po.getBsplicencestate())){
				sb.append("		and DATEDIFF (day,getdate(),B_SP_GLicenceValidity) > 0 ");
			}else if("1".equals(po.getBsplicencestate())){
				sb.append("		and DATEDIFF (day,getdate(),B_SP_GLicenceValidity) <= 0 and isnull(B_SP_GLicenceValidity,'') <> '' ");
			}else if("2".equals(po.getBsplicencestate())){
				sb.append("		and isnull(B_SP_GLicenceValidity,'') = '' ");
			}
		}
		
		return getJdbcTemplate().queryForInt(sb.toString());
	}

	/**
	 * 
	 * 遍历制造商并实现分页
	 * 
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SupplierPo> getSupplierList(SupplierPo po, int start, int size) {

		StringBuffer sb = new StringBuffer();

		sb.append("select temp.B_SP_ID as bspid,temp.B_SP_SupplierName as bspsuppliername,temp.B_SP_ContactPerson as bspcontactperson,");
		sb.append("temp.B_SP_ContactPhone as bspcontactphone,temp.B_SP_Fax as bspfax,temp.B_SP_Address as bspaddress,");
		sb.append("temp.B_SP_Remark as bspremark,temp.B_SP_CategoryID as bspcategoryid,temp.B_SP_Flag as bspflag");
		
		if("1".equals(po.getBsplicencetype())){
			sb.append(",temp.B_SP_LicenceValidity   as bsplicencevalidity ");
			sb.append(",case ");
			sb.append("		when DATEDIFF (day,temp.B_SP_LicenceValidity,getdate()) > 0 then '0' ");
			sb.append(" else '1' end				as bsplicencestate ");
			sb.append(",DATEDIFF (day,getdate(),temp.B_SP_LicenceValidity) as bsplicencedays ");
		}else if("2".equals(po.getBsplicencetype())){
			sb.append(",temp.B_SP_YLicenceValidity  as bsplicencevalidity ");
			sb.append(",case ");
			sb.append("		when DATEDIFF (day,temp.B_SP_YLicenceValidity,getdate()) > 0 then '0' ");
			sb.append(" else '1' end				as bsplicencestate ");
			sb.append(",DATEDIFF (day,getdate(),temp.B_SP_YLicenceValidity) as bsplicencedays ");
		}else if("3".equals(po.getBsplicencetype())){
			sb.append(",temp.B_SP_GLicenceValidity  as bsplicencevalidity ");
			sb.append(",case ");
			sb.append("		when DATEDIFF (day,temp.B_SP_GLicenceValidity,getdate()) > 0 then '0' ");
			sb.append(" else '1' end				as bsplicencestate ");
			sb.append(",DATEDIFF (day,getdate(),temp.B_SP_GLicenceValidity) as bsplicencedays ");
		}
		
		sb.append(" from(select ROW_NUMBER() Over(order by ");

		if (Utility.getName(po.getBspordersupplierid()).equals("2")){
			sb.append(" B_SP_SupplierName ");
		}else{
			sb.append(" B_SP_ID ");
		}
		sb.append(" ) as rowNum,* from B_Supplier where 1=1 and B_SP_ID <> 'ZZ' ");
		
		if (!"".equals(Utility.getName(po.getBspid()))) {
			sb.append(" and B_SP_ID like'%" + po.getBspid() + "%'");
		}
		
		if (!"".equals(Utility.getName(po.getBspsuppliername()))) {
			sb.append(" and B_SP_SupplierName like'%" + po.getBspsuppliername()	+ "%'");
		}
		
		if (!"".equals(Utility.getName(po.getBspcategoryid()))) {
			sb.append(" and B_SP_CategoryID like'%" + po.getBspcategoryid()	+ "%'");
		}
		
		if (!"".equals(Utility.getName(po.getBspsuppliermnemonic()))) {
			sb.append(" and B_SP_SupplierMnemonic like '%" + po.getBspsuppliermnemonic() + "%'");
		}
		
		if (!"".equals(Utility.getName(po.getBspdistributionmethods()))) {
			sb.append(" and B_SP_DistributionMethods = '" + po.getBspdistributionmethods() + "'");
		}
		
		if (!"".equals(Utility.getName(po.getBspflag()))) {
			sb.append(" and B_SP_Flag = '" +Utility.getName(po.getBspflag()) + "'");
		}
		
		if (!"".equals(Utility.getName(po.getBspmakeinvoiceflag()))) {
			sb.append(" and isnull(B_SP_MakeInvoiceFlag,'') = '" +Utility.getName(po.getBspmakeinvoiceflag()) + "'");
		}
		
		if("1".equals(po.getBsplicencetype())){
			if("0".equals(po.getBsplicencestate())){
				sb.append("		and DATEDIFF (day,getdate(),B_SP_LicenceValidity) > 0 ");
			}else if("1".equals(po.getBsplicencestate())){
				sb.append("		and DATEDIFF (day,getdate(),B_SP_LicenceValidity) <= 0 and isnull(B_SP_LicenceValidity,'') <> '' ");
			}else if("2".equals(po.getBsplicencestate())){
				sb.append("		and isnull(B_SP_LicenceValidity,'') = '' ");
			}
		}else if("2".equals(po.getBsplicencetype())){
			if("0".equals(po.getBsplicencestate())){
				sb.append("		and DATEDIFF (day,getdate(),B_SP_YLicenceValidity) > 0 ");
			}else if("1".equals(po.getBsplicencestate())){
				sb.append("		and DATEDIFF (day,getdate(),B_SP_YLicenceValidity) <= 0 and isnull(B_SP_YLicenceValidity,'') <> '' ");
			}else if("2".equals(po.getBsplicencestate())){
				sb.append("		and isnull(B_SP_YLicenceValidity,'') = '' ");
			}
		}else if("3".equals(po.getBsplicencetype())){
			if("0".equals(po.getBsplicencestate())){
				sb.append("		and DATEDIFF (day,getdate(),B_SP_GLicenceValidity) > 0 ");
			}else if("1".equals(po.getBsplicencestate())){
				sb.append("		and DATEDIFF (day,getdate(),B_SP_GLicenceValidity) <= 0 and isnull(B_SP_GLicenceValidity,'') <> '' ");
			}else if("2".equals(po.getBsplicencestate())){
				sb.append("		and isnull(B_SP_GLicenceValidity,'') = '' ");
			}
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ (start + size));

		return queryForObjectList(sb.toString(), null, SupplierPo.class);
	}

	/**
	 * 新增制造商信息
	 * 
	 * @param po
	 */
	public void insertSupplier(SupplierPo po) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into B_Supplier ");
		buffer.append("(B_SP_ID ");
		buffer.append(",B_SP_SupplierName ");
		buffer.append(",B_SP_ContactPerson ");
		buffer.append(",B_SP_ContactPhone ");
		buffer.append(",B_SP_Fax ");
		buffer.append(",B_SP_Address ");
		buffer.append(",B_SP_CategoryID ");
		buffer.append(",B_SP_Flag ");		
		buffer.append(",B_SP_ForShort ");
		buffer.append(",B_SP_LinkMan ");
		buffer.append(",B_SP_LicenceID ");
		buffer.append(",B_SP_LicenceValidity ");
		buffer.append(",B_SP_Settlement ");
		buffer.append(",B_SP_SettlementMonth,B_SP_MakeInvoiceFlag,B_SP_Remark ");
		buffer.append(",B_SP_YLicenceID ");
		buffer.append(",B_SP_YLicenceValidity ");
		buffer.append(",B_SP_GLicenceID ");
		buffer.append(",B_SP_GLicenceValidity ");

		buffer.append(" ) VALUES (?, ?, ?, ?, ?, ?, ?, 1, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
		
		params.add(Utility.getName(po.getBspid()));
		params.add(Utility.getName(po.getBspsuppliername()));
		params.add(Utility.getName(po.getBspcontactperson()));
		params.add(Utility.getName(po.getBspcontactphone()));
		params.add(Utility.getName(po.getBspfax()));
		params.add(Utility.getName(po.getBspaddress()));
		params.add(Utility.getName(po.getBspcategoryid()));
		params.add(Utility.getName(po.getBspfroshort()));
		params.add(Utility.getName(po.getBsplinkmanphonel()));
		params.add(Utility.getName(po.getBsplicenceid()));
		params.add(Utility.getName(po.getBsplicencevalidity()));
		params.add(Utility.getName(po.getBspsettlement()));
		params.add(Utility.getName(po.getBspsettlementmonth()));
		params.add(Utility.getName(po.getBspmakeinvoiceflag()));
		params.add(Utility.getName(po.getBspremark()));
		
		params.add(Utility.getName(po.getBspylicenceid()));
		params.add(Utility.getName(po.getBspylicencevalidity()));
		params.add(Utility.getName(po.getBspglicenceid()));
		params.add(Utility.getName(po.getBspglicencevalidity()));
		
		buffer.append("insert into J_Company_Supplier ");
		buffer.append("(J_CS_ID ");
		buffer.append(",J_CS_CompanyID ");
		buffer.append(",J_CS_SupplierID ");
		buffer.append(",J_CS_SupplierAgentID ");
		buffer.append(",J_CS_QC ");
		buffer.append(",J_CS_YF ");
		buffer.append(",J_CS_ZQ ");
		buffer.append(" ) ");
		buffer.append(" select ");
		buffer.append("  substring(cast(newid() as varchar(50)),1,32) ");
		buffer.append(" ,F_CN_ID ");
		buffer.append(" ,? ");
		buffer.append(" ,? ");
		buffer.append(" ,? ");
		buffer.append(" ,? ");
		buffer.append(" ,? ");
		buffer.append(" from F_CompanyName where 1 = ? ");

		params.add(Utility.getName(po.getBspid()));
		params.add("00"+Utility.getName(po.getBspid()));
		params.add("0.00");
		params.add("0.00");
		params.add("30");
		
		params.add(Utility.getName(po.getBspissyncompanysupplier()));
		
		buffer.append("insert into B_SupplierAgent ");
		buffer.append("(B_SP_ID ");
		buffer.append(",B_SP_SupplierName ");
		buffer.append(",B_SP_ContactPerson ");
		buffer.append(",B_SP_ContactPhone ");
		buffer.append(",B_SP_Fax ");
		buffer.append(",B_SP_Address ");
		buffer.append(",B_SP_CategoryID ");
		buffer.append(",B_SP_Flag ");		
		buffer.append(",B_SP_ForShort ");
		buffer.append(",B_SP_LinkMan ");
		buffer.append(",B_SP_LicenceID ");
		buffer.append(",B_SP_LicenceValidity ");
		buffer.append(",B_SP_Settlement ");
		buffer.append(",B_SP_SettlementMonth,B_SP_MakeInvoiceFlag,B_SP_Remark ");
		buffer.append(",B_SP_LinkSupplierID ");
		buffer.append(",B_SP_YLicenceID ");
		buffer.append(",B_SP_YLicenceValidity ");
		buffer.append(",B_SP_GLicenceID ");
		buffer.append(",B_SP_GLicenceValidity ");
		buffer.append(" ) select ?, ?, ?, ?, ?, ?, ?, 1, ?, ?, ?, ?, ?, ?, ?, ? ,? ,? ,? ,? ,? ");
		buffer.append(" where 1 = ? ");
		
		params.add("00"+Utility.getName(po.getBspid()));
		params.add(Utility.getName(po.getBspsuppliername()));
		params.add(Utility.getName(po.getBspcontactperson()));
		params.add(Utility.getName(po.getBspcontactphone()));
		params.add(Utility.getName(po.getBspfax()));
		params.add(Utility.getName(po.getBspaddress()));
		params.add(Utility.getName(po.getBspcategoryid()));
		params.add(Utility.getName(po.getBspfroshort()));
		params.add(Utility.getName(po.getBsplinkmanphonel()));
		params.add(Utility.getName(po.getBsplicenceid()));
		params.add(Utility.getName(po.getBsplicencevalidity()));
		params.add(Utility.getName(po.getBspsettlement()));
		params.add(Utility.getName(po.getBspsettlementmonth()));
		params.add(Utility.getName(po.getBspmakeinvoiceflag()));
		params.add(Utility.getName(po.getBspremark()));
		params.add(Utility.getName(po.getBspid()));
		params.add(Utility.getName(po.getBspylicenceid()));
		params.add(Utility.getName(po.getBspylicencevalidity()));
		params.add(Utility.getName(po.getBspglicenceid()));
		params.add(Utility.getName(po.getBspglicencevalidity()));
		
		params.add(Utility.getName(po.getBspissyncompanysupplier()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void insertXinZhongDa(SupplierPo po){
		StringBuffer sb = new StringBuffer();
		sb.append("exec [insertXZD] ?,?");

		List<String> params = new ArrayList<String>();
		if (Utility.getName(po.getBspid()).length()==1){
			params.add("000" + po.getBspid());
		}else if (Utility.getName(po.getBspid()).length()==2){
			params.add("00" + po.getBspid());
		}else if (Utility.getName(po.getBspid()).length()==3){
			params.add("0" + po.getBspid());
		}else{
			params.add(po.getBspid());
		}
		params.add(po.getBspsuppliername());
		getJdbcTemplate().update(sb.toString(), params.toArray());		
	}
	
	/**
	 * 修改制造商信息
	 * 
	 * @param po
	 */
	public void updateSupplier(SupplierPo po) {

		StringBuffer buffer = new StringBuffer();
		
		buffer.append("update B_Supplier set ");
		buffer.append(" B_SP_SupplierName = ? ");
		buffer.append(",B_SP_ContactPerson = ? ");
		buffer.append(",B_SP_ContactPhone = ? ");
		buffer.append(",B_SP_Fax = ? ");
		buffer.append(",B_SP_Address = ? ");
		buffer.append(",B_SP_CategoryID = ? ");		
		buffer.append(",B_SP_ForShort = ? ");
		buffer.append(",B_SP_LinkMan = ? ");
		buffer.append(",B_SP_LicenceID = ? ");
		buffer.append(",B_SP_LicenceValidity = ? ");	
		buffer.append(",B_SP_Settlement = ? ");
		buffer.append(",B_SP_SettlementMonth = ? ");
		buffer.append(",B_SP_MakeInvoiceFlag = ? ");
		buffer.append(",B_SP_Remark = ? ");
		buffer.append(",B_SP_YLicenceID = ? ");
		buffer.append(",B_SP_YLicenceValidity = ? ");
		buffer.append(",B_SP_GLicenceID = ? ");
		buffer.append(",B_SP_GLicenceValidity = ? ");

		buffer.append("where B_SP_ID = ? ");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getBspsuppliername());
		params.add(po.getBspcontactperson());
		params.add(po.getBspcontactphone());
		params.add(po.getBspfax());
		params.add(po.getBspaddress());
		params.add(po.getBspcategoryid());
		params.add(Utility.getName(po.getBspfroshort()));
		params.add(Utility.getName(po.getBsplinkmanphonel()));
		params.add(Utility.getName(po.getBsplicenceid()));
		params.add(Utility.getName(po.getBsplicencevalidity()));
		params.add(Utility.getName(po.getBspsettlement()));
		params.add(Utility.getName(po.getBspsettlementmonth()));
		params.add(Utility.getName(po.getBspmakeinvoiceflag()));
		params.add(Utility.getName(po.getBspremark()));
		params.add(Utility.getName(po.getBspylicenceid()));
		params.add(Utility.getName(po.getBspylicencevalidity()));
		params.add(Utility.getName(po.getBspglicenceid()));
		params.add(Utility.getName(po.getBspglicencevalidity()));
		
		params.add(po.getBspid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 修改制造商信息
	 * 
	 * @param po
	 */
	public void updateSupplierAccount(SupplierPo po){

	}
	
	/**
	 * 删除制造商信息
	 * 
	 * @param po
	 */
	public void deleteSupplier(SupplierPo po) {

		String sql = "delete from B_Supplier where B_SP_ID='" + po.getBspid() + "'";

		getJdbcTemplate().update(sql);
	}
	
	/**
	 * 修改制造商信息
	 * 
	 * @param po
	 */
	public void updateSupplierAccount(SupplierPo po,LogisticsLogPo logPo){
		
	}

	/**
	 * 查询制造商信息
	 * 
	 * @param po
	 * @return
	 */
	public SupplierPo getSupplier(SupplierPo po) {
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("select top 1 B_SP_ID as bspid,B_SP_SupplierName as ");
		buffer.append("bspsuppliername,B_SP_ContactPerson as bspcontactperson,");
		buffer.append("B_SP_ContactPhone as bspcontactphone,B_SP_Fax as bspfax,");
		buffer.append("B_SP_Address as bspaddress,");
		buffer.append("B_SP_Remark as bspremark,B_SP_CategoryID as bspcategoryid,");
		buffer.append("B_SP_Flag as bspflag,B_SP_OrderSupplierID as bspordersupplierid, ");
		buffer.append("B_SP_SupplierMnemonic as bspsuppliermnemonic, ");
		buffer.append("B_SP_DistributionMethods as bspdistributionmethods, ");
		buffer.append("B_SP_DocumentUrl 	as documentUrl, ");
		buffer.append("B_SP_ContentType 	as contentType, ");
		buffer.append("B_SP_SaveFileName 	as saveFileName, ");
		buffer.append("B_SP_ValidDateUL 	as bspvaliddateUL, ");
		buffer.append("B_SP_ValidDateUP 	as bspvaliddateUP, ");		
		buffer.append("B_SP_LinkMan 		as bsplinkmanphonel, ");
		buffer.append("B_SP_ForShort 		as bspfroshort, ");
		buffer.append("B_SP_LicenceID 		as bsplicenceid, ");
		buffer.append("B_SP_LicenceValidity as bsplicencevalidity, ");
		buffer.append("B_SP_DealingsAmount  as bspdealingsAmount, ");
		buffer.append("B_SP_Settlement      as bspsettlement, ");
		buffer.append("B_SP_SettlementMonth as bspsettlementmonth, ");
		buffer.append("B_SP_MakeInvoiceFlag as bspmakeinvoiceflag, ");
		buffer.append(" B_SP_YLicenceID		as bspylicenceid		 ");
		buffer.append(",B_SP_YLicenceValidity as bspylicencevalidity	 ");
		buffer.append(",B_SP_GLicenceID 	as bspglicenceid		 ");
		buffer.append(",B_SP_GLicenceValidity as bspglicencevalidity	 ");
		buffer.append(",(select ID from B_Supplier_Person where SYS_P_SupplierID = B_SP_ID) as bspsupplierpersonid ");
		buffer.append(" from B_Supplier where B_SP_ID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(po.getBspid());

		return (SupplierPo)queryForObject(buffer.toString(), params.toArray(), SupplierPo.class);
	}

	/**
	 * 遍历商品类别
	 * 
	 * @return
	 */
	public List<GoodsCategoryPo> getGoodsCategoryList() {
		String sql = "select B_GC_ID as bgcid,B_GC_GoodsCategoryName as bgcgoodscategoryname from B_GoodsCategory order by B_GC_Order";

		return queryForObjectList(sql, null, GoodsCategoryPo.class);
	}

	/**
	 * 修改停用信息
	 * 
	 * @param po
	 */
	public void updateSupplierDisable(SupplierPo po) {

		String sql = "update B_Supplier set B_SP_Flag='" + po.getBspflag()
				+ "' where B_SP_ID='" + po.getBspid() + "'";

		getJdbcTemplate().update(sql);
	}

	/**
	 * 根据制造商ID查找商品数量
	 * 
	 * @param supplierID
	 * @return
	 */
	public int getBrandCount(String supplierID) {
		String sql = "select count(B_BD_ID) from B_Brand where B_BD_SupplierID='"
				+ supplierID + "'";

		return getJdbcTemplate().queryForInt(sql);
	}

	public int getGoodsCount(SupplierPo supplierPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(b_gi_goodsid) from b_goodsinfo where 1=1");
		List<String> params = new ArrayList<String>();
		if (supplierPo.getBspid() != null) {
			sb.append(" and b_gi_supplierid=?");
			params.add(supplierPo.getBspid());
		}
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	//查询兴中大软件开关查询
	public StatusModulePo selectSupplierStaus(String ModuleID) {
		List<String> params = new ArrayList<String>();
		String sql = "select F_SM_StatusID as fsmstatusid,F_SM_StatusCode as fsmstatuscode from F_StatusModule";
		 sql += " where F_SM_StatusModuleID=? ";
			params.add(ModuleID);
		return (StatusModulePo) queryForObject(sql, params.toArray(), StatusModulePo.class);
	}
	
	/**
	 * 修改所属品种的停用启用信息
	 * 
	 * @param po
	 */
	public void updateBrandDisable(SupplierPo supplierPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_Brand set B_BD_SalesStatue=? where B_BD_SupplierID=?");		
		
		params.add(Utility.getName(supplierPo.getBspflag()));
		params.add(Utility.getName(supplierPo.getBspid()));
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}
	
	/**
	 * 修改所属商品的停用启用信息
	 * 
	 * @param po
	 */
	public void updateGoodsDisable(SupplierPo supplierPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_GoodsInfo set B_GI_Flag=? where B_GI_SupplierID=?");		
		
		params.add(Utility.getName(supplierPo.getBspflag()));
		params.add(Utility.getName(supplierPo.getBspid()));
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}

	public void updateBrandSettlementOfSupplier(SupplierPo supplierPo) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("UPDATE B_Brand SET ");
		sb.append("       B_BD_Settlement = ?, ");
		params.add(Utility.getName(supplierPo.getBspsettlement()));
		sb.append("       B_BD_SettlementMonth = ? ");
		params.add(Utility.getName(supplierPo.getBspsettlementmonth()));
		sb.append("WHERE  B_BD_SupplierID = ? ");
		params.add(Utility.getName(supplierPo.getBspid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
}
