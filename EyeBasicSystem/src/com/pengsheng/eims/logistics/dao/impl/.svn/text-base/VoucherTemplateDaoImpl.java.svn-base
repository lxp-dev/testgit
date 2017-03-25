/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : VoucherDaoImpl.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2011-02-11
**/
package com.pengsheng.eims.logistics.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.dao.VoucherTemplateDao;
import com.pengsheng.eims.logistics.persistence.SubjectPo;
import com.pengsheng.eims.logistics.persistence.VoucherTempletPo;
import com.pengsheng.eims.system.persistence.ExportAmountLogPo;
import com.pengsheng.eims.system.persistence.FuctionTreeNode;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class VoucherTemplateDaoImpl extends BaseJdbcDaoSupport implements VoucherTemplateDao {
	
	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	
	/**
	 * 查询科目是否存在
	 */
	public int isExistsSubject(SubjectPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(L_S_S_ID) from L_S_Subject where L_S_S_SubjectID=? ");		
		
		params.add(Utility.getName(po.getsLssSubjectID()));		
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询科目是否存在(更新时)
	 */
	public int isExistsSubjectUpdate(SubjectPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(L_S_S_ID) from L_S_Subject where L_S_S_SubjectID=?  and L_S_S_ID <> '"+Utility.getName(po.getsLssID())+"'");		
		
		params.add(Utility.getName(po.getsLssSubjectID()));		
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询科目总数
	 */
	public int getSubjectCount(SubjectPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(L_S_S_ID)");		
		sb.append(" from L_S_Subject where 1=1 and L_S_S_Flag=1 and L_S_S_IsSubject='1' ");		

		if (!"".equals(Utility.getName(po.getsLssID()))){
			sb.append(" and L_S_S_ID=?");
			params.add(Utility.getName(po.getsLssID()));
		}
		if (!"".equals(Utility.getName(po.getsLssSubjectID()))){
			sb.append(" and L_S_S_SubjectID like '%'+?+'%'");
			params.add(Utility.getName(po.getsLssSubjectID()));
		}
		if (!"".equals(Utility.getName(po.getsLssSubjectName()))){
			sb.append(" and L_S_S_SubjectName like '%'+?+'%' ");
			params.add(Utility.getName(po.getsLssSubjectName()));
		}		
		if (!"".equals(Utility.getName(po.getsLssParentID()))){
			sb.append(" and L_S_S_ParentID=? ");
			params.add(Utility.getName(po.getsLssParentID()));
		}
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

	/**
	 * 查询科目列表
	 */
	public List<SubjectPo> getSubjectList(SubjectPo po,int start,int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.sLssSubjectID as sLssSubjectID,temp.sLssSubjectName as sLssSubjectName,temp.sLssFlag as sLssFlag,temp.sLssID as sLssID ");
		sb.append(" from( select ROW_NUMBER() Over(order by L_S_S_SubjectID ) as rowNum,L_S_S_SubjectID as sLssSubjectID,L_S_S_ID as sLssID,L_S_S_SubjectName as sLssSubjectName,isnull(L_S_S_IsDelete,0) as sLssFlag ");
		sb.append(" from L_S_Subject where 1=1 and L_S_S_Flag=1 and L_S_S_IsSubject='1' ");	
	
		if (!"".equals(Utility.getName(po.getsLssID()))){
			sb.append(" and L_S_S_ID=?");
			params.add(Utility.getName(po.getsLssID()));
		}
		if (!"".equals(Utility.getName(po.getsLssSubjectID()))){
			sb.append(" and L_S_S_SubjectID like '%'+?+'%' ");
			params.add(Utility.getName(po.getsLssSubjectID()));
		}
		if (!"".equals(Utility.getName(po.getsLssSubjectName()))){
			sb.append(" and L_S_S_SubjectName like '%'+?+'%' ");
			params.add(Utility.getName(po.getsLssSubjectName()));
		}
		if (!"".equals(Utility.getName(po.getsLssParentID()))){
			sb.append(" and L_S_S_ParentID=? ");
			params.add(Utility.getName(po.getsLssParentID()));
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" order by temp.sLssSubjectID set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(),SubjectPo.class);
	}
	
	/**
	 * 新增科目
	 */
	public void insertSubject(SubjectPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_S_Subject(L_S_S_ID,L_S_S_SubjectID,L_S_S_SubjectName,L_S_S_Flag,L_S_S_IsDelete,L_S_S_IsSubject,L_S_S_ParentID) ");		
		sb.append(" values(?,?,?,'1','1','1',?)");
			
		params.add(Utility.getName(po.getsLssSubjectID()).trim());
		params.add(Utility.getName(po.getsLssSubjectID()).trim());
		params.add(Utility.getName(po.getsLssSubjectName()).trim());
		if (!"".equals(Utility.getName(po.getsLssParentID()))){
			params.add(Utility.getName(po.getsLssParentID()));
		}else{
			params.add("1");
		}
		
		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	
	/**
	 * 修改科目
	 */
	public void updateSubject(SubjectPo po){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("update L_S_Subject set L_S_S_SubjectID=?,L_S_S_SubjectName=? ");
		sb.append(" where L_S_S_ID=? ");
	
		params.add(Utility.getName(po.getsLssSubjectID()).trim());
		params.add(Utility.getName(po.getsLssSubjectName()).trim());
		params.add(Utility.getName(po.getsLssID()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 删除科目
	 */
	public void deleteSubject(SubjectPo po){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from L_S_Subject where L_S_S_ID=? ");
		
		params.add(Utility.getName(po.getsLssID()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	/**
	 * 查询科目详情
	 */
	public SubjectPo getSubjectDetail(SubjectPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" select top 1 L_S_S_ID as sLssID,L_S_S_SubjectID as sLssSubjectID,L_S_S_SubjectName as sLssSubjectName,dbo.getParentSubjectName(L_S_S_ParentID) as sLssParentID from L_S_Subject where L_S_S_ID=? ");
			
		params.add(Utility.getName(po.getsLssID()));
		
		return (SubjectPo)queryForObject(sb.toString(), params.toArray(),SubjectPo.class);
	}
	
	/**
	 * 验证是否可以继续录入期初信息
	 */
	public int getInitGoodsCount(GoodsInfoPo po){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(L_CT_CT_ID) from L_CT_HistoryCostingTemp ");
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 确定期初商品的信息录入完毕
	 */
	public void initHistoryCosting(){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_CT_HistoryCostingTemp(L_CT_CT_ID,L_CT_CT_Date,L_CT_CT_GoodsID,L_CT_CT_GoodsQuantity,L_CT_CT_Goodsnottaxrateamount,L_CT_CT_BackFillTaxRate) ");
		sb.append(" select L_CT_CT_ID,L_CT_CT_Date,L_CT_CT_GoodsID,L_CT_CT_GoodsQuantity,L_CT_CT_Goodsnottaxrateamount,L_CT_CT_BackFillTaxRate from L_CT_CostingTemplate ");
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 按品种删除期初商品金额和数量(期初备份表)
	 */
	public void deleteInitGoodsAmount_Backup(String companyID,String departmentID){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from L_CT_CostingTemplate where 1 = 1 ");
		
		if (!"".equals(Utility.getName(companyID))){
			sb.append(" and L_CT_CT_CompanyID = ? ");
			params.add(Utility.getName(companyID));
		}
		
		if (!"".equals(Utility.getName(departmentID))){
			sb.append(" and L_CT_CT_DepartmentID = ? ");
			params.add(Utility.getName(departmentID));
		}
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 按品种删除期初商品金额和数量(当月成本计算表)
	 */
	public void deleteInitGoodsAmount_CurrentMonth(String companyID,String departmentID){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from L_CT_CurrentMonthCostingTemp where 1 = 1 ");
		
		if (!"".equals(Utility.getName(companyID))){
			sb.append(" and L_CT_CT_CompanyID = ? ");
			params.add(Utility.getName(companyID));
		}
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	
	/**
	 * 按品种删除期初商品金额和数量(历史成本计算表)
	 */
	public void deleteInitGoodsAmount_History(){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from L_CT_HistoryCostingTemp ");
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 按品种新增期初商品金额和数量(期初备份表)
	 */
	public void insertInitGoodsAmount_Backup(List<GoodsInfoPo> poList,String date,String companyID,String departmentID){
		
		StringBuffer sb = null;		
		List<String> params = null;	
		
		for (GoodsInfoPo po : poList){
			
			sb = new StringBuffer();		
			params = new ArrayList<String>();
			
			sb.append("insert into L_CT_CostingTemplate(L_CT_CT_ID,L_CT_CT_Date,L_CT_CT_GoodsID,L_CT_CT_GoodsQuantity,L_CT_CT_Goodsnottaxrateamount,L_CT_CT_BackFillTaxRate,L_CT_CT_DepartmentID,L_CT_CT_GoodsRateamount,L_CT_CT_BackFillRate,L_CT_CT_CompanyID) ");
			sb.append(" values (newid(),?,?,?,?,0,?,?,0,?) ");

			params.add(date);
			
			params.add(Utility.getName(po.getBgigoodsid()));
			params.add(Utility.getName(po.getBgigoodsquantity()));
			
			if ("1".equals(po.getBgiaverageflag())){
				params.add(Utility.getName(po.getBginottaxrate()));
			}else{
				params.add("0");
			}
			
			params.add(Utility.getName(departmentID));
			
			if ("1".equals(po.getBgiaverageflag())){
				params.add("0");
			}else{
				params.add(Utility.getName(po.getBginottaxrate()));
			}
			
			params.add(Utility.getName(companyID));
			
			getJdbcTemplate().update(sb.toString(), params.toArray());
		}
		
	}
	
	/**
	 * 按品种新增期初商品金额和数量(当月成本计算表)
	 */
	public void insertInitGoodsAmount_CurrentMonth(String companyID,String departmentID,String cbPriceType){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_CT_CurrentMonthCostingTemp(L_CT_CT_ID,L_CT_CT_Date,L_CT_CT_GoodsID,L_CT_CT_GoodsQuantity,L_CT_CT_Goodsnottaxrateamount,L_CT_CT_BackFillTaxRate,L_CT_CT_CompanyID) ");
		sb.append(" select newid(),L_CT_CT_Date,L_CT_CT_GoodsID,L_CT_CT_GoodsQuantity");
		
		if ("1".equals(Utility.getName(cbPriceType))){
			sb.append(",L_CT_CT_Goodsnottaxrateamount,L_CT_CT_BackFillTaxRate");
		}else{
			sb.append(",L_CT_CT_GoodsRateamount,L_CT_CT_BackFillRate");
		}
		
		sb.append(" ,L_CT_CT_CompanyID from L_CT_CostingTemplate where 1 = 1 ");
		
		if (!"".equals(Utility.getName(companyID))){
			sb.append(" and L_CT_CT_CompanyID = ? ");
			params.add(Utility.getName(companyID));
		}
		
		getJdbcTemplate().update(sb.toString(), params.toArray());	
	}
	
	/**
	 * 计算单位成本
	 */
	public void setNotTaxRateAmount_Backup(String companyID,String departmentID){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();

		sb.append("update L_CT_CostingTemplate set L_CT_CT_BackFillTaxRate = cast((L_CT_CT_Goodsnottaxrateamount / L_CT_CT_GoodsQuantity) as numeric(18,6)),L_CT_CT_BackFillRate = cast((L_CT_CT_GoodsRateamount / L_CT_CT_GoodsQuantity) as numeric(18,2)) ");
		sb.append(" where L_CT_CT_GoodsQuantity <> 0 ");
		
		if (!"".equals(Utility.getName(companyID))){
			sb.append(" and L_CT_CT_CompanyID = ? ");
			params.add(Utility.getName(companyID));
		}
		
		if (!"".equals(Utility.getName(departmentID))){
			sb.append(" and L_CT_CT_DepartmentID = ? ");
			params.add(Utility.getName(departmentID));
		}
		
		getJdbcTemplate().update(sb.toString(), params.toArray());		
	}
	
	/**
	 * 获取物流系统期初商品列表
	 */
	public List<GoodsInfoPo> selGoodsInfo(GoodsInfoPo po,String companyID,String departmentID,String date){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select bgigoodsid as bgigoodsid,bgigoodsname as bgigoodsname,isnull(bgispec,'') as bgispec,isnull(bgicolor,'') as bgicolor,isnull(bgisph,'') as bgisph,isnull(bgicyl,'') as bgicyl,isnull(bgithrowingcycle,'') as bgithrowingcycle,bgigoodsquantity as bgigoodsquantity,bgiretailprice as bgiretailprice from ( ");
		buffer.append(" select B_GI_GoodsID as bgigoodsid,B_GI_ViewGoodsName as bgigoodsname,isnull(B_GI_SupplierSpec,'') as bgispec,isnull(B_GI_SupplierColor,'') as bgicolor,isnull(B_GI_Sph,'') as bgisph,isnull(B_GI_Cyl,'') as bgicyl,isnull(B_GI_StealthClass,'') as bgithrowingcycle, ");
		buffer.append(" isnull(B_GI_OtherGoodsBigClass,'') as bgiothergoodsbigclass,isnull(B_GI_OtherGoodsSmallClass,'') as bgiothergoodssmallclass,sum(C_SH_SL_GoodsQuantity) as bgigoodsquantity,isnull(B_GI_RetailPrice,'0.00') as bgiretailprice from B_GoodsInfo inner join C_SH_StorageLog on B_GI_GoodsID=C_SH_SL_GoodsId inner join B_Warehouse on C_SH_SL_StockId=B_WH_ID inner join B_Departments on B_WH_deptID=B_DP_DepartmentID where 1 = 1 ");
		
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			buffer.append(" and B_GI_GoodsCategoryID=? ");
			params.add(Utility.getName(po.getBgigoodscategoryid()));
		}
		
		if (!"".equals(Utility.getName(date))){
			buffer.append(" and convert(varchar(16),C_SH_SL_WarehousingDate,120) < ? ");
			params.add(Utility.getName(date));
		}
		
		if (!"".equals(Utility.getName(companyID))){
			buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(companyID));
		}
		
		if (!"".equals(Utility.getName(departmentID))){
			buffer.append(" and B_DP_DepartmentID = ? ");
			params.add(Utility.getName(departmentID));
		}
		
		buffer.append(" group by B_GI_GoodsID,B_GI_ViewGoodsName,B_GI_SupplierSpec,B_GI_SupplierColor,B_GI_Sph,B_GI_Cyl,B_GI_StealthClass,B_GI_OtherGoodsBigClass,B_GI_OtherGoodsSmallClass,B_GI_RetailPrice ");
		buffer.append(" )temp where bgigoodsquantity<>0 ");
		
		return queryForObjectList(buffer.toString(), params.toArray(),GoodsInfoPo.class);
	}
	
	/**
	 * 获取物流系统期初商品数量和金额
	 */
	public GoodsInfoPo getGoodsSumAndAmount(){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" select sum(L_CT_CT_GoodsQuantity) as bgigoodsquantity,sum(L_CT_CT_Goodsnottaxrateamount) as bginottaxrate from L_CT_CostingTemplate ");
		
		return (GoodsInfoPo)queryForObject(buffer.toString(), params.toArray(),GoodsInfoPo.class);
	}
	
	/**
	 * 查询树形科目
	 */
	public List<FuctionTreeNode> getSubjectTree(String nodeId,String hrefTarget,String href){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		//(case when dbo.getEntrySubjectCount(L_S_S_ID)>0 then 0 else 1 end) as leaf,	
		buffer.append(" select ('S_'+L_S_S_SubjectID+'_'+L_S_S_ID) as id,(L_S_S_SubjectID+' '+L_S_S_SubjectName) as [text],? as hrefTarget,('selSubjectSet.action?moduleID='+?+'&subjectID='+L_S_S_SubjectID+'&subjectName='+L_S_S_SubjectName+'&parentID='+('S_'+L_S_S_SubjectID+'_'+L_S_S_ID)) as href from L_S_Subject where L_S_S_IsSubject='1' and L_S_S_Flag='1' and L_S_S_ParentID=? ");
		buffer.append(" order by L_S_S_SubjectID ");

		params.add(hrefTarget);
		params.add(href);
		params.add(Utility.getName(nodeId.split("_")[2]));
		
		return queryForObjectList(buffer.toString(), params.toArray(), FuctionTreeNode.class);
	}
	
	/**
	 * 更新基础信息中商品的加权平均成本
	 */
	public void updateGoodsInoAvgAmount(String companyID,String cbType){
		
		StringBuffer buffer = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		if (cbType.equals("1")){   // 按所有公司
			buffer.append("update B_GoodsInfo set B_GI_AverageNotTaxRate = isnull(L_CT_CT_BackFillTaxRate,0) ");
			buffer.append("  from B_GoodsInfo left join L_CT_CurrentMonthCostingTemp on B_GI_GoodsID = L_CT_CT_GoodsID ");
		}
		
		if (cbType.equals("2")){   // 按公司
						
			buffer.append(" delete from B_GoodsAveragePrice where 1 = 1 ");
			
			if (!"".equals(Utility.getName(companyID))){
		        buffer.append("  and B_GA_CompanyID = ? ");
		        params.add(Utility.getName(companyID));
			}
			
			buffer.append(" insert into B_GoodsAveragePrice (B_GA_ID,B_GA_CompanyID,B_GA_GoodsID,B_GA_AverageNotTaxRate) ");
			buffer.append(" select newid(),?,L_CT_CT_GoodsID,(cast((sum(L_CT_CT_Goodsnottaxrateamount) / sum(L_CT_CT_GoodsQuantity)) as numeric(18,6))) as L_CT_CT_BackFillTaxRate from L_CT_CurrentMonthCostingTemp where L_CT_CT_CompanyID = ? group by L_CT_CT_GoodsID having sum(L_CT_CT_GoodsQuantity) <> 0 ");
			buffer.append(" union all ");
			buffer.append(" select newid(),?,L_CT_CT_GoodsID,0 as L_CT_CT_BackFillTaxRate from L_CT_CurrentMonthCostingTemp where L_CT_CT_CompanyID = ? group by L_CT_CT_GoodsID having sum(L_CT_CT_GoodsQuantity) = 0 ");
			
			params.add(Utility.getName(companyID));
			params.add(Utility.getName(companyID)); 
			params.add(Utility.getName(companyID));
			params.add(Utility.getName(companyID)); 
			
		}

		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
	/**
	 * 新增凭证模板
	 */
	public void insertVoucherTemplet(VoucherTempletPo tpo){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_VT_VoucherTemplet(L_VT_VT_ID,L_VT_VT_VoucherTypeID,L_VT_VT_OrderID,L_VT_VT_BalanceDirection,L_VT_VT_SubjectID,L_VT_VT_HExpressions,L_VT_VT_HBConstant,L_VT_VT_HBExpressions) values(?,?,?,?,?,?,'1','') ");

		params.add(this.uuid.generate());
		params.add(Utility.getName(tpo.getsLvtvtVoucherTypeID()));
		params.add(Utility.getName(tpo.getsLvtvtorderby()));
		params.add(Utility.getName(tpo.getsLvtvtBalanceDirection()));
		params.add(Utility.getName(tpo.getsLvtvtSubjectID()));
		params.add(Utility.getName(tpo.getsLvtvtHExpressions()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());	
	}
	
	/**
	 * 删除凭证模板
	 */
	public void deleteVoucherTemplet(VoucherTempletPo tpo){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from L_VT_VoucherTemplet where L_VT_VT_VoucherTypeID = ? ");

		params.add(Utility.getName(tpo.getsLvtvtVoucherTypeID()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());	
	}
	
	/**
	 * 查询凭证模板
	 */
	public List<VoucherTempletPo> getVoucherTempletDetail(VoucherTempletPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" select L_VT_VT_BalanceDirection as sLvtvtBalanceDirection,L_VT_VT_SubjectID as sLvtvtSubjectID,L_VT_VT_HExpressions as sLvtvtHExpressions,L_S_S_SubjectID as sLssSubjectID,L_S_S_SubjectName as sLssSubjectName from L_VT_VoucherTemplet ");
		buffer.append(" inner join L_S_Subject on L_VT_VT_SubjectID=L_S_S_ID ");
		buffer.append(" where L_VT_VT_VoucherTypeID = ? order by L_VT_VT_OrderID ");

		params.add(Utility.getName(po.getsLvtvtVoucherTypeID()));
		
		return queryForObjectList(buffer.toString(), params.toArray(), VoucherTempletPo.class);
	}
	
	/**
	 * 查询树形科目
	 */
	public List<FuctionTreeNode> getSubjectOpenTree(String nodeId,String hrefTarget,String href){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" select ('S_'+L_S_S_SubjectID+'_'+L_S_S_ID) as id,(L_S_S_SubjectID+' '+L_S_S_SubjectName) as [text],? as hrefTarget,('selSubject.action?moduleID='+?+'&subjectID='+L_S_S_SubjectID+'&subjectName='+L_S_S_SubjectName+'&subjectOpenTree=1') as href from L_S_Subject where L_S_S_IsSubject='1' and L_S_S_Flag='1' and L_S_S_ParentID=? ");
		buffer.append(" order by L_S_S_SubjectID ");

		params.add(hrefTarget);
		params.add(href);
		params.add(Utility.getName(nodeId.split("_")[2]));
		
		return queryForObjectList(buffer.toString(), params.toArray(), FuctionTreeNode.class);		
	}
	
	/**
	 * 判断科目代码是否存在
	 */
	public int getSubjectByIdCount(SubjectPo po){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(L_S_S_ID) from L_S_Subject where L_S_S_SubjectID = ? ");
		
		params.add(Utility.getName(po.getsLssSubjectID()).trim());
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 新增期初成本导出日志
	 */
	public void insertExportAmountLog(String companyID,String departmentID,String date,String type,String pID){
	
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_ExportAmountLog (L_EL_ID,L_EL_PersonID,L_EL_Date,L_EL_Form,L_EL_InitDate,L_EL_CompanyID,L_EL_DepartmentID) values (?,?,getdate(),?,?,?,?) ");

		params.add(this.uuid.generate());
		params.add(Utility.getName(pID));
		params.add(Utility.getName(type));
		params.add(Utility.getName(date));
		params.add(Utility.getName(companyID));
		params.add(Utility.getName(departmentID));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());			
	}
	
	/**
	 * 查询期初成本导出日志
	 */
	public List<ExportAmountLogPo> getExportAmountLog(String companyID){
	
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select L_EL_ID as lealid,isnull(personName,'') as lealpersonname,convert(varchar(16),L_EL_Date,120) as lealdate,L_EL_Form as lealform,L_EL_InitDate as lealinitdate,isnull(F_CN_Name,'') as lealcompanyname,isnull(B_DP_DepartmentName,'') as lealdepartmentname from L_ExportAmountLog ");
		buffer.append(" left join SYS_PersonInfo on L_EL_PersonID = ID ");
		buffer.append(" left join F_CompanyName on L_EL_CompanyID = F_CN_ID ");
		buffer.append(" left join B_Departments on L_EL_DepartmentID = B_DP_DepartmentID ");	
		
		if (!"".equals(Utility.getName(companyID))){
			buffer.append(" where L_EL_CompanyID = ? ");
			params.add(Utility.getName(companyID));
		}

		buffer.append("order by L_EL_Date desc ");
		
		return queryForObjectList(buffer.toString(),params.toArray(), ExportAmountLogPo.class);	
	}
	
}
