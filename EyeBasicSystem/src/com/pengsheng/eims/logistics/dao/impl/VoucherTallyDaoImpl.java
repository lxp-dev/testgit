/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : VoucherTallyDaoImpl.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2011-02-11
**/
package com.pengsheng.eims.logistics.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.dao.VoucherTallyDao;
import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.SubjectPo;
import com.pengsheng.eims.logistics.persistence.VoucherEntryPo;
import com.pengsheng.eims.logistics.persistence.VoucherPo;
import com.pengsheng.eims.logistics.persistence.VoucherTallyPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class VoucherTallyDaoImpl extends BaseJdbcDaoSupport implements VoucherTallyDao {
	
	/**
	 * Description：根据参数判断凭证模板是否存在
	 * @param     ：凭证ID
	 * @return    ：返回凭证模板列表
	 */
	@SuppressWarnings("unchecked")
	public List<VoucherTallyPo> getVoucherTallyByID(String voucherID){
		StringBuffer sb = new StringBuffer();
		sb.append("select L_S_S_ID as sLssID,L_VT_VT_OrderID as sLvtvtOrderID,L_VT_VT_BalanceDirection as sLvtsBalanceDirection,L_VT_VT_Resume as sLvtvtResume,(L_S_S_SubjectID+''+L_S_S_SubjectName) as sLvtvtSubjectName,L_VT_VT_DebitMoney as sLvtvtDebitMoney,L_VT_VT_LenderMoney as sLvtvtLenderMoney ");
		sb.append("  from L_VT_VoucherTally inner join L_S_Subject on L_VT_VT_SubjectName=L_S_S_ID where L_VT_VT_VoucherID=? order by L_VT_VT_OrderID ");
		
		List<String> params = new ArrayList<String>();
		params.add(voucherID);
		
		return queryForObjectList(sb.toString(),params.toArray(),VoucherTallyPo.class);
	}
	
	/**
	 * Description：新增记账凭证信息
	 * @param     ：记账凭证实体
	 */
	public void insertVoucherTally(VoucherTallyPo po){
		StringBuffer sb = new StringBuffer();
		sb.append("insert into L_VT_VoucherTally (L_VT_VT_ID,L_VT_VT_VoucherID,L_VT_VT_BalanceDirection,L_VT_VT_Resume,L_VT_VT_SubjectName,L_VT_VT_DebitMoney,L_VT_VT_LenderMoney,L_VT_VT_OrderID) values(?,?,?,?,?,?,?,?)");
		
		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(po.getsLvtvtVoucherID());
		params.add(po.getsLvtsBalanceDirection());
		params.add(po.getsLvtvtResume());
		params.add(po.getsLvtvtSubjectID());
		if (!"".equals(Utility.getName(po.getsLvtvtDebitMoney()))){
			params.add(Utility.getName(po.getsLvtvtDebitMoney()));	
		}else{
			params.add("0");	
		}
		if (!"".equals(Utility.getName(po.getsLvtvtLenderMoney()))){
			params.add(Utility.getName(po.getsLvtvtLenderMoney()));
		}else{
			params.add("0");	
		}
		params.add(Utility.getName(po.getsLvtvtOrderID()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * Description：根据凭证ID查询单据（发票）、商品
	 * @param     ：凭证明细实体
	 * @return    ：返回单据（发票）、商品的列表
	 */
	@SuppressWarnings("unchecked")
	public List<VoucherEntryPo> getBillsAndGoods(VoucherEntryPo po){
		StringBuffer sb = new StringBuffer();
		sb.append("select L_VE_VE_BillID as sLveveBillID,L_VE_VE_GoodsID as sLveveGoodsID from L_VE_VoucherEntry where L_VE_VE_VoucherID=?");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getsLveveVoucherID());
		
		return queryForObjectList(sb.toString(), params.toArray(),VoucherEntryPo.class);
	}
	
	/**
	 * Description：查询暂估商品成本合计
	 * @param     ：单据号
	 * @return    ：返回暂估商品成本合计的字符串格式
	 */
	public String getNotTaxRateAmount(String billID){
		StringBuffer sb = new StringBuffer();
		sb.append("select top 1  cast(isnull(sum(cast(C_ST_IE_NotTaxRateAmount as numeric(18,2))),0) as numeric(18,2)) from C_ST_InventoryEntry where C_ST_IE_BillID=? "); 
		
		List<String> params = new ArrayList<String>();
		params.add(billID);
		
		return (String)getJdbcTemplate().queryForObject(sb.toString(), params.toArray(),String.class);
	}
	public String getOtherGoodsNotTaxRateAmount(String billID,String otherGoodsBigClass){
		StringBuffer sb = new StringBuffer();
		sb.append("select top 1 cast(isnull(sum(C_ST_IE_NotTaxRateAmount),0) as numeric(18,2)) from C_ST_InventoryEntry inner join B_GoodsInfo on C_ST_IE_GoodsId=B_GI_GoodsID "); 
		sb.append(" where C_ST_IE_BillID=? and B_GI_OtherGoodsBigClass=? "); 
		
		List<String> params = new ArrayList<String>();
		params.add(billID);
		params.add(otherGoodsBigClass);
		
		return (String)getJdbcTemplate().queryForObject(sb.toString(), params.toArray(),String.class);
	}
	
	/**
	 * Description：查询暂估商品成本合计
	 * @param     ：凭证号
	 * @return    ：返回暂估商品成本合计的字符串格式
	 */
	public String getNotTaxRateAmount(String voucherID,String typeID){
		StringBuffer sb = new StringBuffer();
		sb.append("select top 1  cast(isnull(sum(L_VE_VE_NotTaxRateAmount),0) as numeric(18,2)) from L_VE_VoucherEntry left join B_GoodsInfo on L_VE_VE_GoodsID=B_GI_GoodsID where L_VE_VE_VoucherID=? ");
		
		List<String> params = new ArrayList<String>();
		params.add(voucherID);
		
		String goodsCategoryID = Utility.getName(typeID);
		if (!"".endsWith(goodsCategoryID)){
			if (goodsCategoryID.length() == 1){
				if (!goodsCategoryID.equalsIgnoreCase("D")){
					sb.append(" and substring(L_VE_VE_GoodsID,1,1)=?");
					params.add(goodsCategoryID);
				}else{
					sb.append(" and B_GI_OtherGoodsBigClass='D'");
				}				
			}else{
				sb.append(" and B_GI_OtherGoodsBigClass=? and B_GI_OtherGoodsSmallClass=?");
				params.add(goodsCategoryID.substring(0,goodsCategoryID.indexOf(".")));
				params.add(goodsCategoryID.substring(goodsCategoryID.indexOf(".")+1,goodsCategoryID.length()));
			}
		}else{
			sb.append(" and L_VE_VE_GoodsID=? ");
			params.add("");
		}
		
		return (String)getJdbcTemplate().queryForObject(sb.toString(), params.toArray(),String.class);
	}
	
	public VoucherEntryPo getPercentThreeNotTaxRateAmount(VoucherEntryPo po){
		StringBuffer sb = new StringBuffer();
		sb.append("select top 1  cast(isnull(sum(C_ST_IE_NotTaxRateAmount),0) as numeric(18,2)) as sNotTaxRateAmount,isnull(sum(C_ST_IE_TaxAmount),0) as sTaxAmount from C_ST_InventoryEntry where C_ST_IE_BillID=? and C_ST_IE_GoodsId=? "); 
		
		List<String> params = new ArrayList<String>();
		params.add(po.getsLveveBillID());
		params.add(po.getsLveveGoodsID());
		
		return (VoucherEntryPo)queryForObject(sb.toString(), params.toArray(),VoucherEntryPo.class);
	}
	
	public VoucherEntryPo getPercentThreeReversalNotTaxRateAmount(VoucherEntryPo po){
		StringBuffer sb = new StringBuffer();
		sb.append("select top 1  cast(isnull(sum(L_IE_RE_NotTaxRateAmount),0) as numeric(18,2)) as sNotTaxRateAmount from L_RE_ReversalEntry where L_IE_RE_InvoiceID=? and L_IE_RE_GoodsID=? ");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getsLveveBillID());
		params.add(po.getsLveveGoodsID());
		
		return (VoucherEntryPo)queryForObject(sb.toString(), params.toArray(),VoucherEntryPo.class);
	}
	
	/**
	 * Description：查询冲回中的核销商品的成本合计
	 * @author    ：SZK
	 * @param     ：凭证明细实体
	 * @return    ：返回冲回中的核销商品的成本合计的字符串格式
	 */
	public VoucherEntryPo getReversalNotTaxRateAmountByBillID(VoucherEntryPo po){
		StringBuffer sb = new StringBuffer();
		sb.append("select top 1  cast(abs(isnull(sum(L_IE_IE_NotTaxRateAmount),0)) as numeric(18,2)) as sNotTaxRateAmount,abs(isnull(sum(L_IE_IE_TaxAmount),0)) as sTaxAmount from L_IE_InvoiceEntry where L_IE_IE_BillID=? and L_IE_IE_GoodsID=? ");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getsLveveBillID());
		params.add(po.getsLveveGoodsID());
		return (VoucherEntryPo)queryForObject(sb.toString(), params.toArray(),VoucherEntryPo.class);
	}
	
	/**
	 * Description：查询冲回中的核销商品的成本合计
	 * @author    ：SZK
	 * @param     ：凭证明细实体
	 * @return    ：返回冲回中的核销商品的成本合计的字符串格式列表
	 */	
	public VoucherEntryPo getReversalNotTaxRateAmountByInvoiceID(VoucherEntryPo po){
		StringBuffer sb = new StringBuffer();
		sb.append("select top 1  isnull(sum(L_IE_RE_NotTaxRateAmount),0) as sNotTaxRateAmount,isnull(sum(L_IE_RE_TaxAmount),0) as sTaxAmount from L_RE_ReversalEntry where L_IE_RE_InvoiceID=? ");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getsLveveBillID());
		
		return (VoucherEntryPo)queryForObject(sb.toString(), params.toArray(),VoucherEntryPo.class);
	}
	
	/**
	 * Description：查询发票中的核销商品成本合计
	 * @param     ：发票号
	 * @return    ：返回发票中的核销商品成本合计的字符串格式
	 */
	public String getInvoiceNotTaxRateAmount(String billID){
		StringBuffer sb = new StringBuffer();
		sb.append("select top 1  isnull(sum(L_IE_IE_NotTaxRateAmount),0) from L_IE_InvoiceEntry where L_IE_IE_InvoiceID=?" ); 
		
		List<String> params = new ArrayList<String>();
		params.add(billID);
		
		return (String)getJdbcTemplate().queryForObject(sb.toString(), params.toArray(),String.class);
	}
	
	/**
	 * Description：查询未核销核销商品成本合计
	 * @param     ：凭证明细实体
	 * @return    ：返回未核销核销商品成本合计的字符串格式
	 */
	public String getNotInvoiceNotTaxRateAmount(VoucherEntryPo po){ 
		StringBuffer sb = new StringBuffer();
		sb.append("select top 1  isnull(sum((C_ST_IE_GoodsQuantity-C_ST_IE_checkquantity)*C_ST_IE_NotTaxRate),0) ");
		sb.append(" from C_ST_InventoryEntry where C_ST_IE_BillID=? and C_ST_IE_GoodsId=? ");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getsLveveBillID());
		params.add(po.getsLveveGoodsID());
		
		return (String)getJdbcTemplate().queryForObject(sb.toString(), params.toArray(),String.class);
	}
	
	/**
	 * Description：查询成本合计、税额合计、价税合计
	 * @param     ：发票号
	 * @return    ：返回符合条件的成本合计、税额合计、价税合计的列表
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceEntryPo> getAmounts(String billID){
		StringBuffer sb = new StringBuffer();
		sb.append("select isnull(sum(L_IE_IE_NotTaxRateAmount),0) as lieienottaxrateamount,isnull(sum(L_IE_IE_TaxAmount),0) as lieietaxamount,isnull(sum(L_IE_IE_CostPriceAmount),0) as lieiecostpriceamount ");
		sb.append(" from L_IE_InvoiceEntry where L_IE_IE_InvoiceID=? ");
		
		List<String> params = new ArrayList<String>();
		params.add(billID);
		
		return queryForObjectList(sb.toString(), params.toArray(),InvoiceEntryPo.class);
	}
	
	/**
	 * Description：修改记账凭证
	 * @param     ：记账凭证实体
	 */
	public void updateVoucherTallyByID(VoucherTallyPo po){
		StringBuffer sb = new StringBuffer();
		sb.append("update L_VT_VoucherTally set L_VT_VT_DebitMoney=?,L_VT_VT_LenderMoney=? where L_VT_VT_ID=?");
		
		List<String> params = new ArrayList<String>();	
		params.add(po.getsLvtvtDebitMoney());		
		params.add(po.getsLvtvtLenderMoney());	
		params.add(po.getsLvtvtID());
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * Description：根据参数修改凭证信息
	 * @param     ：凭证实体
	 */
	public void updateVoucherByID(VoucherPo voucherPo){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("update L_V_Voucher set ");
		if (!"".equals(Utility.getName(voucherPo.getsLvvDate()))){
			sb.append("L_V_V_Date=?,");
			params.add(voucherPo.getsLvvDate());
		}
		sb.append("L_V_V_HandlePersonID=?,L_V_V_BalanceMethod=? where L_V_V_ID=?");
		params.add(Utility.getName(voucherPo.getsLvvHandlePersonID()));
		params.add(Utility.getName(voucherPo.getsLvvBalanceMethod()));
		params.add(voucherPo.getsLvvID());
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * Description：根据参数查询经办人、结算方式
	 * @param     ：凭证实体
	 * @return    : 符合条件的经办人、结算方式
	 */
	public VoucherPo getBalanceMethodAndHandlePerson(String voucherID){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("select top 1  L_V_V_BalanceMethod as sLvvBalanceMethod,L_V_V_HandlePersonID as sLvvHandlePersonID from L_V_Voucher where L_V_V_ID=?");
		params.add(voucherID);
		
		return (VoucherPo)queryForObject(sb.toString(), params.toArray(),VoucherPo.class);
	}
	
	/**
	 * Description：根据参数查询凭证模板
	 * @param     ：凭证实体
	 * @return    : 符合条件的凭证模板
	 */
	@SuppressWarnings("unchecked")
	public List<VoucherTallyPo> getVoucherTempletByID(String voucherTypeID){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("select L_S_S_ID as sLssID,L_VT_VT_OrderID as sLvtvtOrderID,L_VT_VT_VoucherTypeID as sLvtvtVoucherTypeID,L_VT_VT_BalanceDirection as sLvtsBalanceDirection,L_S_S_SubjectID as sLvtvtSubjectID,L_S_S_SubjectName as sLvtvtSubjectName,isnull(L_VT_VT_HBConstant,0) as sLvtsHBConstant,isnull(L_VT_VT_isReplace,'0') as sLvtvtIsReplace ");
		sb.append(" from L_VT_VoucherTemplet inner join L_S_Subject on L_VT_VT_SubjectID=L_S_S_ID ");
		sb.append(" where L_VT_VT_VoucherTypeID=? order by L_VT_VT_OrderID ");
		params.add(voucherTypeID);
		
		return queryForObjectList(sb.toString(), params.toArray(),VoucherTallyPo.class);
	}
	
	/**
	 * Description：根据参数查询凭证模板可以被替换的部分
	 * @param     ：科目主键
	 * @return    : 符合条件的凭证模板
	 */
	@SuppressWarnings("unchecked")
	public List<VoucherTallyPo> getReplaceVoucherTempletByID(String id){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("select L_S_S_ID as sLssID,L_S_S_SubjectID as sLvtvtSubjectID,L_S_S_SubjectName as sLvtvtSubjectName from L_S_Subject where L_S_S_ID in ( ");
		sb.append(" select L_R_R_SubjectID from L_R_Replace where L_S_S_ID=?)");
		params.add(id);
		
		return queryForObjectList(sb.toString(), params.toArray(),VoucherTallyPo.class);
	}
	
	/**
	 * Description：根据参数查询商品类型
	 * @param     ：id     科目主键
	 * @param     ：typeID 被替换的科目主键
	 * @return    : 符合条件的商品类型
	 */
	public String getGoodsCategoryByID(String id,String subjectID){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("select top 1  isnull(L_R_R_TypeID,'0') from L_R_Replace ");
		sb.append(" where L_S_S_ID=? and L_R_R_SubjectID=?");
		params.add(id);
		params.add(subjectID);
		
		return (String)getJdbcTemplate().queryForObject(sb.toString(), params.toArray(),String.class);
	}
	
	/**
	 * Description：根据参数查询商品的销售收入
	 * @param     ：shopCode     店号
	 * @param     ：salesDate    销售日期
	 * @return    : 符合条件的商品销售收入
	 */
	public String getSalesValueByID(String shopCode,String salesDate,String typeID){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select top 1  isnull(sum(isnull(S_SE_SD_SalesValue,0)),0) from S_SE_SalesDetail inner join S_SE_SalesBasic on S_SE_SD_SalesID=S_SE_SB_SalesID ");
		sb.append(" where S_SE_SB_ShopCode=? and substring(CONVERT(varchar(10),S_SE_SB_SalesDatetime,120),1,10)=? ");
		
		params.add(Utility.getName(shopCode));
		params.add(Utility.getName(salesDate));
		if (!"".equals(Utility.getName(typeID))){
			if (!Utility.getName(typeID).startsWith("p")){
				sb.append(" and substring(S_SE_SD_SalesItemID,1,1)=? ");
				params.add(Utility.getName(typeID));
			}
		}
			
		return (String)getJdbcTemplate().queryForObject(sb.toString(), params.toArray(),String.class);
	}
	
	public String getSalesValueByID(String billID){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select top 1  isnull(sum(C_ST_IE_CostPriceAmount),0) from  C_ST_InventoryEntry where C_ST_IE_BillID=? ");
		
		params.add(Utility.getName(billID));
		return (String)getJdbcTemplate().queryForObject(sb.toString(), params.toArray(),String.class);
	}
	
	public String getSalesValueByID(String billID,String typeID){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if (typeID.equals("10")){
			sb.append("select top 1  isnull(sum(C_ST_IE_CostPriceAmount),0) from C_ST_InventoryEntry where C_ST_IE_BillID=? and C_ST_IE_GoodsId like '%附加%' ");
			params.add(Utility.getName(billID));
		}else{
			sb.append("select top 1  isnull(sum(C_ST_IE_CostPriceAmount),0) from C_ST_InventoryEntry where C_ST_IE_BillID=? and substring(C_ST_IE_GoodsId,1,1)=? ");
			params.add(Utility.getName(billID));
			params.add(Utility.getName(typeID));
		}
		
		return (String)getJdbcTemplate().queryForObject(sb.toString(), params.toArray(),String.class);
	}
	
	/**
	 * Description：根据参数查询商品的销售日期和店号
	 * @param     ：销售单号
	 * @return    : 符合条件的商品的销售日期和店号
	 */
	public InventoryPo getSalesDateAndShopCode(String billID){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("select distinct substring(CONVERT(varchar(10),C_ST_I_billDate,120),1,10) as cstibilldate,C_ST_I_DepartmentId as cstidepartmentid from C_ST_Inventory ");
		sb.append(" inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		sb.append(" where C_ST_I_BillID=? ");
		params.add(billID);
		
		return (InventoryPo)queryForObject(sb.toString(), params.toArray(),InventoryPo.class);
	}	
	
	/**
	 * Description：根据参数查询科目
	 * @param     ：科目实体
	 * @return    : 符合条件的科目列表
	 */
	@SuppressWarnings("unchecked")
	public List<SubjectPo> getSubjectList(SubjectPo po,int start,int size){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.sLssID as sLssID,temp.sLssSubjectID as sLssSubjectID,temp.sLssSubjectName as sLssSubjectName from (");
		sb.append("select ROW_NUMBER() Over(order by L_S_S_ID) as rowNum,L_S_S_ID as sLssID,L_S_S_SubjectID as sLssSubjectID,L_S_S_SubjectName as sLssSubjectName from L_S_Subject where L_S_S_SubjectID is not null and L_S_S_SubjectID<>'' and L_S_S_Flag='1' ");		
		if (!"".equals(Utility.getName(po.getsLssSubjectID()))){
			sb.append(" and L_S_S_SubjectID like '%' + ? + '%' ");
			params.add(po.getsLssSubjectID());
		}
		if (!"".equals(Utility.getName(po.getsLssSubjectName()))){
			sb.append(" and L_S_S_SubjectName like ? ");
			params.add("%"+po.getsLssSubjectName()+"%");
		}
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(),SubjectPo.class);
	}
	
	/**
	 * Description：根据参数查询科目总数
	 * @param     ：科目实体
	 * @return    : 符合条件的科目总数
	 */
	public int getSubjectCount(SubjectPo po){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(L_S_S_ID) from L_S_Subject where L_S_S_SubjectID is not null and L_S_S_SubjectID<>'' and L_S_S_Flag='1' ");		
		if (!"".equals(Utility.getName(po.getsLssSubjectID()))){
			sb.append(" and L_S_S_SubjectID like '%' + ? + '%' ");
			params.add(po.getsLssSubjectID());
		}
		if (!"".equals(Utility.getName(po.getsLssSubjectName()))){
			sb.append(" and L_S_S_SubjectName like ? ");
			params.add("%"+po.getsLssSubjectName()+"%");
		}
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}	
	
	/**
	 * Description：根据参数查询店号
	 * @param     ：凭证明细实体
	 * @return    : 符合条件的店号
	 */
	public DepartmentsPo getShopCode(VoucherEntryPo po){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("select top 1  B_DP_DepartmentID as bdpdepartmentid,B_DP_DepartmentName as bdpdepartmentname from B_Departments ");	
		sb.append("   where B_DP_DepartmentID = ( ");
		sb.append(" select top 1 C_ST_I_SupplierId from C_ST_Inventory where C_ST_I_BillID=? )");
		params.add(po.getsLveveBillID());
		
		return (DepartmentsPo)queryForObject(sb.toString(), params.toArray(),DepartmentsPo.class);
	}
	
	public DepartmentsPo getInwarehouseName(VoucherEntryPo po){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("select B_WH_warehouseName as bdpdepartmentname from B_Warehouse where B_WH_ID in ( ");	
		sb.append("  select top 1 C_ST_I_InStockId from C_ST_Inventory where C_ST_I_BillTypeId='5' and C_ST_I_BillID=? )");
		params.add(po.getsLveveBillID());
		
		return (DepartmentsPo)queryForObject(sb.toString(), params.toArray(),DepartmentsPo.class);
	}
	
	public DepartmentsPo getOutwarehouseName(VoucherEntryPo po){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("select B_WH_warehouseName as bdpdepartmentname from B_Warehouse where B_WH_ID in ( ");	
		sb.append("  select top 1 C_ST_I_OutStockId from C_ST_Inventory where C_ST_I_BillTypeId='6' and C_ST_I_BillID=? )");
		params.add(po.getsLveveBillID());
		
		return (DepartmentsPo)queryForObject(sb.toString(), params.toArray(),DepartmentsPo.class);
	}
	
	/**
	 * Description：创建付款单凭证
	 * @param     ：voucherID 凭证号
	 * @param     ：supplierName 摘要
	 * @param     ：voucherType 凭证类型
	 * @return    : 符合条件的凭证模板
	 */
	public List<VoucherTallyPo> getVoucherTallyByID(VoucherPo vpo,String supplierName){
		
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
				
		sb.append(" exec sp_createVoucherTally ?,?,?,?,?,? ");
		
		params.add(Utility.getName(vpo.getsLvvID()));
		params.add(Utility.getName(supplierName));
		params.add(Utility.getName(vpo.getsLvvVoucherTypeID()));  		
		params.add(Utility.getName(vpo.getsLvvDepartmentID()));
		params.add(Utility.getName(vpo.getsLvvDateLowerLimit()));  // 起始日期
		params.add(Utility.getName(vpo.getsLvvDateTopLimit()));   // 截止日期
		
		return queryForObjectList(sb.toString(), params.toArray(),VoucherTallyPo.class);
	}
	
	/**
	 * Description：根据科目查询凭证模板总数
	 * @param     ：科目实体
	 * @return    : 符合条件的总数
	 */
	public int getVoucherTemplateCount(String voucherType){
		
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(L_VT_VT_ID) from L_VT_VoucherTemplet inner join L_S_Subject on L_VT_VT_SubjectID=L_S_S_ID where L_VT_VT_VoucherTypeID=? ");		

		params.add(voucherType);
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * Description：根据参数查询科目
	 * @param     ：科目实体
	 * @return    : 符合条件的科目列表
	 */
	public SubjectPo getSubjectDetail(SubjectPo po){
		
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();

		sb.append("select temp.sLssID as sLssID,temp.sLssSubjectID as sLssSubjectID,temp.sLssSubjectName as sLssSubjectName from (");
		sb.append("select L_S_S_ID as sLssID,L_S_S_SubjectID as sLssSubjectID,L_S_S_SubjectName as sLssSubjectName from L_S_Subject where L_S_S_SubjectID is not null and L_S_S_SubjectID<>'' and L_S_S_Flag='1' ");		
		
		if (!"".equals(Utility.getName(po.getsLssSubjectID()))){
			sb.append(" and L_S_S_SubjectID like '%' + ? + '%' ");
			params.add(po.getsLssSubjectID());
		}
		if (!"".equals(Utility.getName(po.getsLssSubjectName()))){
			sb.append(" and L_S_S_SubjectName like ? ");
			params.add("%"+po.getsLssSubjectName()+"%");
		}
		sb.append(" ) temp ");

		return (SubjectPo)queryForObject(sb.toString(), params.toArray(),SubjectPo.class);
	}
	
}
