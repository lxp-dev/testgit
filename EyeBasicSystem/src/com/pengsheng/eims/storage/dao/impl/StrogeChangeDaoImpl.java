package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class StrogeChangeDaoImpl extends BaseJdbcDaoSupport implements StrogeChangeDao {

	private SystemParameterDao systemParameterDao = null;
	
	public void insertStrogeChange(StrogeChangePo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into C_SH_StorageChange(C_SH_SC_GoodsBarCode,C_SH_SC_GoodsId,C_SH_SC_StockId,C_SH_SC_GoodsQuantity,C_SH_SC_CostPrice,C_SH_SC_NotTaxRate,C_SH_SC_WarehousingDate,C_SH_SC_ChangeID,C_SH_SC_UUID) ");
		buffer.append(" values(?,?,?,?,?,?,getdate(),?,?) ");
		
		params.add(Utility.getName(po.getCshscgoodsbarcode().toString().substring(0,18)));
		params.add(Utility.getName(po.getCshscgoodsid()));
		params.add(Utility.getName(po.getCshscstockid()));
		params.add(Utility.getName(po.getCshscgoodsquantity()));
		params.add(Utility.getName(getGoodsInfo(po.getCshscgoodsid()).getBgicostprice()));
		params.add(Utility.getName(getGoodsInfo(po.getCshscgoodsid()).getBginottaxrate()));
		params.add(Utility.getName(po.getCshscchangeid()));
		params.add(this.uuid.generate());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void insertStrogeChangeLog(StrogeChangePo po,String pcBarcode) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into C_SH_StorageLog(C_SH_Sl_GoodsBarCode,C_SH_Sl_GoodsId,C_SH_Sl_StockId,C_SH_SL_FromStockId,C_SH_Sl_GoodsQuantity,C_SH_Sl_CostPrice,C_SH_Sl_NotTaxRate,C_SH_Sl_WarehousingDate,C_SH_Sl_ChangeID,C_SH_SL_UUID,C_SH_SL_GuaranteePeriod,C_SH_SL_Batch,C_SH_SL_Rksj) ");
		buffer.append(" values(?,?,?,?,?,?,?,getdate(),?,?,?,?,?) ");
		
		params.add(Utility.getName(pcBarcode));
		params.add(Utility.getName(po.getCshscgoodsid()));
		params.add(Utility.getName(po.getCshscstockid()));
		params.add(Utility.getName(po.getCshscfromstockid()));
		params.add(Utility.getName(po.getCshscgoodsquantity()));

		
		if ("".equals(Utility.getName(po.getCshsccostprice()))){
			params.add(Utility.getName(getGoodsInfo(po.getCshscgoodsid()).getBgicostprice()));
		}else{
			params.add(Utility.getName(po.getCshsccostprice()));
		}
		
		if ("".equals(Utility.getName(po.getCshscnottaxrate()))){
			params.add(Utility.getName(getGoodsInfo(po.getCshscgoodsid()).getBginottaxrate()));
		}else{
			params.add(Utility.getName(po.getCshscnottaxrate()));
		}	
		
		params.add(Utility.getName(po.getCshscchangeid()));
		params.add(this.uuid.generate());
		
		SystemParameterPo po1 = systemParameterDao.getSystemParameterPo();
		if (!Utility.getName(po1.getFspbarcodetype()).equals("3") && !Utility.getName(po1.getFspstealtheffective()).equals("0")){
			if (("4".equals(Utility.getName(pcBarcode).substring(0,1)) || "5".equals(Utility.getName(pcBarcode).substring(0,1))) ){
				GoodsInfoPo gbpo = new GoodsInfoPo();
				gbpo = getGoodsBatchFromBatchCompare(Utility.getName(pcBarcode)); //改为从C_SH_BatchCompare表取出对应的效期、批号
				if(gbpo.getGuaranteeperiod() == null){
					params.add(Utility.getName(po.getCshscguaranteeperiod()));
					params.add(Utility.getName(po.getCshscBatch()));
				}else{
					params.add(gbpo.getGuaranteeperiod());
					params.add(gbpo.getBatch());
				}
			}else{
				params.add(Utility.getName(po.getCshscguaranteeperiod()));
				params.add(Utility.getName(po.getCshscBatch()));
			}
		}else{
			params.add(Utility.getName(po.getCshscguaranteeperiod()));
			params.add(Utility.getName(po.getCshscBatch()));
		}
		params.add(Utility.getName(po.getCshscrksj()));
	
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
		
   	private GoodsInfoPo getGoodsInfo(String goodsID){
   		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1  isnull(B_GI_CostPrice,0) as bgicostprice, ");
		buffer.append("isnull(B_GI_NotTaxRate,0) as bginottaxrate ");
		buffer.append(" from B_GoodsInfo where B_GI_GoodsID=? ");

		params.add(Utility.getName(goodsID));

		return (GoodsInfoPo) queryForObject(buffer.toString(), params.toArray(),GoodsInfoPo.class);
   	}
   	
   	private int getGoodsBatchCount(String goodsBarID){
   		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select count(distinct C_ST_IE_BillID)  from C_ST_InventoryEntry  ");
		buffer.append("  where (C_ST_IE_BillID like 'PIN%' or C_ST_IE_BillID like 'CPIN%') and C_ST_IE_BarCode=? ");

		params.add(Utility.getName(goodsBarID));

		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
   	}
   	
   	public GoodsInfoPo getGoodsBatch(String goodsBarID){
   		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 isnull(C_SH_SL_GuaranteePeriod,'') as guaranteeperiod,isnull(C_SH_SL_Batch,'') as batch from C_SH_StorageLog  ");
		buffer.append("where isnull(C_SH_SL_GuaranteePeriod,'') <> '' and isnull(C_SH_SL_Batch,'') <> '' and C_SH_SL_GoodsBarCode = ? ");

		params.add(Utility.getName(goodsBarID));

		return (GoodsInfoPo) queryForObject(buffer.toString(), params.toArray(),GoodsInfoPo.class);
   	}
   	
   	//根据条码从C_SH_BatchCompare表获取隐形、护理液的有效期和批号
   	public GoodsInfoPo getGoodsBatchFromBatchCompare(String goodsBarID){
   		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 isnull(C_SH_BC_GuaranteePeriod,'') as guaranteeperiod,isnull(C_SH_BC_Batch,'') as batch from C_SH_BatchCompare  ");
		buffer.append("where isnull(C_SH_BC_GuaranteePeriod,'') <> '' and isnull(C_SH_BC_Batch,'') <> '' and C_SH_BC_Barcode = ? ");

		params.add(Utility.getName(goodsBarID));

		return (GoodsInfoPo) queryForObject(buffer.toString(), params.toArray(),GoodsInfoPo.class);
   	}

	public SystemParameterDao getSystemParameterDao() {
		return systemParameterDao;
	}

	public void setSystemParameterDao(SystemParameterDao systemParameterDao) {
		this.systemParameterDao = systemParameterDao;
	}
	public void insertStrogeChangeLogTemp(StrogeChangePo po,String pcBarcode) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if("1".equals(Utility.getName(pcBarcode).substring(0,1))){
			buffer.append("insert into C_SH_StorageLog_JJ ");
		}else if("2".equals(Utility.getName(pcBarcode).substring(0,1))){
			buffer.append("insert into C_SH_StorageLog_PJ ");
		}else if("3".equals(Utility.getName(pcBarcode).substring(0,1))){
			buffer.append("insert into C_SH_StorageLog_JP ");
		}else if("4".equals(Utility.getName(pcBarcode).substring(0,1))){
			buffer.append("insert into C_SH_StorageLog_YX ");
		}else if("5".equals(Utility.getName(pcBarcode).substring(0,1))){
			buffer.append("insert into C_SH_StorageLog_HLY ");
		}else if("6".equals(Utility.getName(pcBarcode).substring(0,1))){
			buffer.append("insert into C_SH_StorageLog_TYJ ");
		}else if("7".equals(Utility.getName(pcBarcode).substring(0,1))){
			buffer.append("insert into C_SH_StorageLog_HC ");
		}else if("8".equals(Utility.getName(pcBarcode).substring(0,1))){
			buffer.append("insert into C_SH_StorageLog_LHJ ");
		}else if("9".equals(Utility.getName(pcBarcode).substring(0,1))){
			buffer.append("insert into C_SH_StorageLog_SG ");
		}
		
		
		buffer.append("(C_SH_Sl_GoodsBarCode,C_SH_Sl_GoodsId,C_SH_Sl_StockId,C_SH_SL_FromStockId,C_SH_Sl_GoodsQuantity,C_SH_Sl_CostPrice,C_SH_Sl_NotTaxRate,C_SH_Sl_WarehousingDate,C_SH_Sl_ChangeID,C_SH_SL_UUID,C_SH_SL_GuaranteePeriod,C_SH_SL_Batch) ");
		buffer.append(" values(?,?,?,?,?,?,?,getdate(),?,?,?,?) ");
		
		params.add(Utility.getName(pcBarcode));
		params.add(Utility.getName(po.getCshscgoodsid()));
		params.add(Utility.getName(po.getCshscstockid()));
		params.add(Utility.getName(po.getCshscfromstockid()));
		params.add(Utility.getName(po.getCshscgoodsquantity()));
		
		if ("".equals(Utility.getName(po.getCshsccostprice()))){
			params.add(Utility.getName(getGoodsInfo(po.getCshscgoodsid()).getBgicostprice()));
		}else{
			params.add(Utility.getName(po.getCshsccostprice()));
		}
		
		if ("".equals(Utility.getName(po.getCshscnottaxrate()))){
			params.add(Utility.getName(getGoodsInfo(po.getCshscgoodsid()).getBginottaxrate()));
		}else{
			params.add(Utility.getName(po.getCshscnottaxrate()));
		}	
		
		params.add(Utility.getName(po.getCshscchangeid()));
		params.add(this.uuid.generate());
		
		SystemParameterPo po1 = systemParameterDao.getSystemParameterPo();
		if (!Utility.getName(po1.getFspbarcodetype()).equals("3") && !Utility.getName(po1.getFspstealtheffective()).equals("0")){
			if (("4".equals(Utility.getName(pcBarcode).substring(0,1)) || "5".equals(Utility.getName(pcBarcode).substring(0,1))) ){
				GoodsInfoPo gbpo = new GoodsInfoPo();
				gbpo = getGoodsBatch(Utility.getName(pcBarcode));
				if(gbpo.getGuaranteeperiod() == null){
					params.add(Utility.getName(po.getCshscguaranteeperiod()));
					params.add(Utility.getName(po.getCshscBatch()));
				}else{
					params.add(gbpo.getGuaranteeperiod());
					params.add(gbpo.getBatch());
				}
			}else{
				params.add(Utility.getName(po.getCshscguaranteeperiod()));
				params.add(Utility.getName(po.getCshscBatch()));
			}
		}else{
			params.add(Utility.getName(po.getCshscguaranteeperiod()));
			params.add(Utility.getName(po.getCshscBatch()));
		}
	
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	
	public StrogeChangePo getStrogeChangePoBarCode(StrogeChangePo po) {
		
   		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1  UPPER(dbo.getbarcode3(?,?,?,?))    AS cshscgoodsbarcode ");

		params.add(Utility.getName(po.getCshscbarcodeflag()));
		params.add(Utility.getName(po.getCshscgoodsid()));
		params.add(Utility.getName(po.getCshscgoodsbarcode()));
		params.add(Utility.getName(po.getCshscrksj()));

		return (StrogeChangePo) queryForObject(buffer.toString(), params.toArray(),StrogeChangePo.class);
	}
	
	
	public GoodsInfoPo getGoodsInfoPoBarCode(String goodsID) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1  B_GI_GoodsBarCode AS bgigoodsbarcode, B_GI_BarCodeFlag as bgirksj ");
		buffer.append(" from B_GoodsInfo where B_GI_GoodsID=? ");

		params.add(Utility.getName(goodsID));

		return (GoodsInfoPo) queryForObject(buffer.toString(), params.toArray(),GoodsInfoPo.class);
	}
	
	public void insertStrogeChangeLogTemp(List<SalesDetailPo> poList,String warehouseID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		for (SalesDetailPo sdpo : poList){
			if ((!Utility.getName(sdpo.getSsesditemid()).equals("")) && (!Utility.getName(sdpo.getSsesdsalesitemid()).substring(2,2).equals("ZZ"))){
				
				if("1".equals(Utility.getName(sdpo.getSsesdsalesitemid()).substring(0,1))){
					buffer.append("insert into C_SH_StorageLog_JJ ");
				}else if("2".equals(Utility.getName(sdpo.getSsesdsalesitemid()).substring(0,1))){
					buffer.append("insert into C_SH_StorageLog_PJ ");
				}else if("3".equals(Utility.getName(sdpo.getSsesdsalesitemid()).substring(0,1))){
					buffer.append("insert into C_SH_StorageLog_JP ");
				}else if("4".equals(Utility.getName(sdpo.getSsesdsalesitemid()).substring(0,1))){
					buffer.append("insert into C_SH_StorageLog_YX ");
				}else if("5".equals(Utility.getName(sdpo.getSsesdsalesitemid()).substring(0,1))){
					buffer.append("insert into C_SH_StorageLog_HLY ");
				}else if("6".equals(Utility.getName(sdpo.getSsesdsalesitemid()).substring(0,1))){
					buffer.append("insert into C_SH_StorageLog_TYJ ");
				}else if("7".equals(Utility.getName(sdpo.getSsesdsalesitemid()).substring(0,1))){
					buffer.append("insert into C_SH_StorageLog_HC ");
				}else if("8".equals(Utility.getName(sdpo.getSsesdsalesitemid()).substring(0,1))){
					buffer.append("insert into C_SH_StorageLog_LHJ ");
				}else if("9".equals(Utility.getName(sdpo.getSsesdsalesitemid()).substring(0,1))){
					buffer.append("insert into C_SH_StorageLog_SG ");
				}
						
				buffer.append("(C_SH_Sl_GoodsBarCode,C_SH_Sl_GoodsId,C_SH_Sl_StockId,C_SH_SL_FromStockId,C_SH_Sl_GoodsQuantity,C_SH_Sl_CostPrice,C_SH_Sl_NotTaxRate,C_SH_Sl_WarehousingDate,C_SH_Sl_ChangeID,C_SH_SL_UUID,C_SH_SL_GuaranteePeriod,C_SH_SL_Batch) ");
				buffer.append(" values(?,?,?,'',?,?,?,getdate(),?,?,?,?) ");
				
				params.add(Utility.getName(sdpo.getSsesditemid()));
				params.add(Utility.getName(sdpo.getSsesdsalesitemid()));
				params.add(warehouseID.equals("") ? Utility.getName(sdpo.getSsesdstockid()) : warehouseID);
				params.add("-" + Utility.getName(sdpo.getSsesdnumber()));
				params.add(Utility.getName(sdpo.getSsesdcostsprive()).equals("") ? "0.00" : Utility.getName(sdpo.getSsesdcostsprive()));
				params.add(Utility.getName(sdpo.getSsesdunitprice()).equals("") ? "0.00" : Utility.getName(sdpo.getSsesdunitprice()));	
				params.add(Utility.getName(sdpo.getSsesdsalesid()));
				params.add(this.uuid.generate());
				params.add(Utility.getName(sdpo.getSsesdguaranteeperiod()));
				params.add(Utility.getName(sdpo.getSsesdbatch()));
			}			
		}
	
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
   	
	/**
	 * 删除库存信息By变更单据号
	 * @param cid
	 */
	public void deleteStockByChangeID(String cid) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" delete from C_SH_StorageChange  where C_SH_SC_ChangeID = ? ");
		
		buffer.append(" delete from C_SH_StorageLog     where C_SH_SL_ChangeID = ? ");
		buffer.append(" delete from C_SH_StorageLog_JJ  where C_SH_SL_ChangeID = ? ");
		buffer.append(" delete from C_SH_StorageLog_PJ  where C_SH_SL_ChangeID = ? ");
		buffer.append(" delete from C_SH_StorageLog_JP  where C_SH_SL_ChangeID = ? ");
		buffer.append(" delete from C_SH_StorageLog_YX  where C_SH_SL_ChangeID = ? ");
		buffer.append(" delete from C_SH_StorageLog_HLY where C_SH_SL_ChangeID = ? ");
		buffer.append(" delete from C_SH_StorageLog_TYJ where C_SH_SL_ChangeID = ? ");
		buffer.append(" delete from C_SH_StorageLog_HC  where C_SH_SL_ChangeID = ? ");
		buffer.append(" delete from C_SH_StorageLog_LHJ where C_SH_SL_ChangeID = ? ");
		buffer.append(" delete from C_SH_StorageLog_SG  where C_SH_SL_ChangeID = ? ");
		
		params.add(cid);
		
		params.add(cid);
		params.add(cid);
		params.add(cid);
		params.add(cid);
		params.add(cid);
		params.add(cid);
		params.add(cid);
		params.add(cid);
		params.add(cid);
		params.add(cid);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}
