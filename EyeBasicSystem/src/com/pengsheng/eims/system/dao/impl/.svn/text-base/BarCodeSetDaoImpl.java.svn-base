package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.system.dao.BarCodeSetDao;
import com.pengsheng.eims.system.persistence.BarCodeSetPo;
import com.pengsheng.eims.system.persistence.MaxDiscountPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class BarCodeSetDaoImpl extends BaseJdbcDaoSupport implements BarCodeSetDao {

	
	public int getBarCodeSetCount(BarCodeSetPo barCodeSetPo) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select count(F_BCS_ID) from F_BarCodeSet where 1=1 ");		
	
		if(!"".equals(Utility.getName(barCodeSetPo.getFbcsgoodscategoryid()))){					
		    sb.append("and F_BCS_GoodsCategoryID = ?  ");
		    params.add(Utility.getName(barCodeSetPo.getFbcsgoodscategoryid()));
		}
		if(!"".equals(Utility.getName(barCodeSetPo.getFbcsiscustomize()))){					
			sb.append("and F_BCS_Iscustomize = ?  ");
		    params.add(Utility.getName(barCodeSetPo.getFbcsiscustomize()));
		}
		if(!"".equals(Utility.getName(barCodeSetPo.getFbcssupplierid()))){					
			sb.append("and F_BCS_SupplierID = ?  ");
		    params.add(Utility.getName(barCodeSetPo.getFbcssupplierid()));
		}
		if(!"".equals(Utility.getName(barCodeSetPo.getFbcsbrandid()))){					
			sb.append("and F_BCS_BrandID = ?  ");
		    params.add(Utility.getName(barCodeSetPo.getFbcsbrandid()));
		}
		if(!"".equals(Utility.getName(barCodeSetPo.getFbcsgoodsid()))){					
			sb.append("and F_BCS_GoodsID = ?  ");
		    params.add(Utility.getName(barCodeSetPo.getFbcsgoodsid()));
		}
		if (!"".equals(Utility.getName(barCodeSetPo.getFbcsgoodsname()))){
			sb.append(" and F_BCS_GoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(barCodeSetPo.getFbcsgoodsname()));
		}

		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	public List<BarCodeSetPo> getBarCodeSetList(BarCodeSetPo barCodeSetPo,
			int start, int size) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append(" select fbcsid as fbcsid,fbcsgoodscategoryid as fbcsgoodscategoryid,fbcsgoodscategoryname as fbcsgoodscategoryname,fbcsiscustomize as fbcsiscustomize,fbcssupplierid as fbcssupplierid,fbcssuppliername as fbcssuppliername,fbcsbrandid as fbcsbrandid,fbcsbrandname as fbcsbrandname,fbcsgoodsid as fbcsgoodsid,fbcsgoodsname as fbcsgoodsname,fbcsbarcodeflag as fbcsbarcodeflag ");
		sb.append(" from (select ROW_NUMBER() Over(order by F_BCS_GoodsCategoryID,F_BCS_SupplierID,F_BCS_BrandID) as rowNum,F_BCS_ID as fbcsid,F_BCS_GoodsCategoryID as fbcsgoodscategoryid,F_BCS_GoodsCategoryName as fbcsgoodscategoryname,F_BCS_Iscustomize as fbcsiscustomize, ");	
		sb.append(" F_BCS_SupplierID as fbcssupplierid,F_BCS_SupplierName as fbcssuppliername,F_BCS_BrandID as fbcsbrandid,F_BCS_BrandName as fbcsbrandname,F_BCS_GoodsID as fbcsgoodsid,F_BCS_GoodsName as fbcsgoodsname,F_BCS_BarCodeFlag as fbcsbarcodeflag ");
		sb.append(" from F_BarCodeSet where 1=1  ");

		if(!"".equals(Utility.getName(barCodeSetPo.getFbcsgoodscategoryid()))){					
		    sb.append("and F_BCS_GoodsCategoryID = ?  ");
		    params.add(Utility.getName(barCodeSetPo.getFbcsgoodscategoryid()));
		}
		if(!"".equals(Utility.getName(barCodeSetPo.getFbcsiscustomize()))){					
			sb.append("and F_BCS_Iscustomize = ?  ");
		    params.add(Utility.getName(barCodeSetPo.getFbcsiscustomize()));
		}
		if(!"".equals(Utility.getName(barCodeSetPo.getFbcssupplierid()))){					
			sb.append("and F_BCS_SupplierID = ?  ");
		    params.add(Utility.getName(barCodeSetPo.getFbcssupplierid()));
		}
		if(!"".equals(Utility.getName(barCodeSetPo.getFbcsbrandid()))){					
			sb.append("and F_BCS_BrandID = ?  ");
		    params.add(Utility.getName(barCodeSetPo.getFbcsbrandid()));
		}
		if(!"".equals(Utility.getName(barCodeSetPo.getFbcsgoodsid()))){					
			sb.append("and F_BCS_GoodsID = ?  ");
		    params.add(Utility.getName(barCodeSetPo.getFbcsgoodsid()));
		}
		if (!"".equals(Utility.getName(barCodeSetPo.getFbcsgoodsname()))){
			sb.append(" and F_BCS_GoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(barCodeSetPo.getFbcsgoodsname()));
		}
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0 ");
		
		return queryForObjectList(sb.toString(), params.toArray(),BarCodeSetPo.class);
	}
	
	public void insertBarCodeSet(BarCodeSetPo barCodeSetPo) {
		
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into F_BarCodeSet(   ");
		sb.append("F_BCS_ID, 					");
		sb.append("F_BCS_GoodsCategoryID,        ");
		sb.append("F_BCS_GoodsCategoryName,            ");
		sb.append("F_BCS_Iscustomize,             ");
		sb.append("F_BCS_SupplierID,                ");
		sb.append("F_BCS_SupplierName,                ");
		sb.append("F_BCS_BrandID,              ");
		sb.append("F_BCS_BrandName,            ");
		sb.append("F_BCS_GoodsID,      ");
		sb.append("F_BCS_GoodsName,           ");
		sb.append("F_BCS_BarCodeFlag              ");
		sb.append("    )values(?,?,?,?,?,?,?,?,?,?,?)         ");

		params.add (Utility.getName(this.uuid.generate()));
        params.add (Utility.getName(barCodeSetPo.getFbcsgoodscategoryid()));
        params.add (Utility.getName(barCodeSetPo.getFbcsgoodscategoryname()));
        params.add (Utility.getName(barCodeSetPo.getFbcsiscustomize()));
        params.add (Utility.getName(barCodeSetPo.getFbcssupplierid()));
        params.add (Utility.getName(barCodeSetPo.getFbcssuppliername()));
        params.add (Utility.getName(barCodeSetPo.getFbcsbrandid()));
        params.add (Utility.getName(barCodeSetPo.getFbcsbrandname()));
        params.add (Utility.getName(barCodeSetPo.getFbcsgoodsid()));
        params.add (Utility.getName(barCodeSetPo.getFbcsgoodsname()));
        params.add (Utility.getName(barCodeSetPo.getFbcsbarcodeflag()));
        
        getJdbcTemplate().update(sb.toString(),params.toArray());		
		
	}
	
	public void updateBarCodeSet(BarCodeSetPo barCodeSetPo) {
		
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update F_BarCodeSet set F_BCS_BarCodeFlag=? where F_BCS_ID=? ");

		params.add (Utility.getName(barCodeSetPo.getFbcsbarcodeflag()));
		params.add (Utility.getName(barCodeSetPo.getFbcsid()));
        
        getJdbcTemplate().update(sb.toString(),params.toArray());
		
	}
	
	public void deleteBarCodeSet(BarCodeSetPo barCodeSetPo) {
		
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from F_BarCodeSet where F_BCS_ID=? ");

		params.add (Utility.getName(barCodeSetPo.getFbcsid()));
        
        getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	
	public void insertBarCodeSetForGoods(BarCodeSetPo barCodeSetPo) {
		
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update B_GoodsInfo set B_GI_BarCodeFlag=? where 1=1 ");

		params.add (Utility.getName(barCodeSetPo.getFbcsbarcodeflag()));
		
		if(!"".equals(Utility.getName(barCodeSetPo.getFbcsgoodscategoryid()))){					
		    sb.append("and B_GI_GoodsCategoryID = ?  ");
		    params.add(Utility.getName(barCodeSetPo.getFbcsgoodscategoryid()));
		}
		if(!"".equals(Utility.getName(barCodeSetPo.getFbcsiscustomize()))){					
		    sb.append("and B_GI_isCustomize = ?  ");
		    params.add(Utility.getName(barCodeSetPo.getFbcsiscustomize()));
		}
		if(!"".equals(Utility.getName(barCodeSetPo.getFbcssupplierid()))){					
		    sb.append("and B_GI_SupplierID = ?  ");
		    params.add(Utility.getName(barCodeSetPo.getFbcssupplierid()));
		}
		if(!"".equals(Utility.getName(barCodeSetPo.getFbcsbrandid()))){					
		    sb.append("and B_GI_BrandID = ?  ");
		    params.add(Utility.getName(barCodeSetPo.getFbcsbrandid()));
		}
		if(!"".equals(Utility.getName(barCodeSetPo.getFbcsgoodsid()))){					
		    sb.append("and B_GI_GoodsID = ?  ");
		    params.add(Utility.getName(barCodeSetPo.getFbcsgoodsid()));
		}
        getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	
	public int isBarCodeSet(BarCodeSetPo barCodeSetPo) {		
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(F_BCS_ID) from F_BarCodeSet ");
		sb.append("where 1=1 ");
		if(!"".equals(Utility.getName(barCodeSetPo.getFbcsgoodscategoryid()))){					
		    sb.append("and F_BCS_GoodsCategoryID = ?  ");
		    params.add(Utility.getName(barCodeSetPo.getFbcsgoodscategoryid()));
		}
		if(!"".equals(Utility.getName(barCodeSetPo.getFbcsiscustomize()))){					
			sb.append("and F_BCS_Iscustomize = ?  ");
		    params.add(Utility.getName(barCodeSetPo.getFbcsiscustomize()));
		}
		if(!"".equals(Utility.getName(barCodeSetPo.getFbcssupplierid()))){					
			sb.append("and F_BCS_SupplierID = ?  ");
		    params.add(Utility.getName(barCodeSetPo.getFbcssupplierid()));
		}
		if(!"".equals(Utility.getName(barCodeSetPo.getFbcsbrandid()))){					
			sb.append("and F_BCS_BrandID = ?  ");
		    params.add(Utility.getName(barCodeSetPo.getFbcsbrandid()));
		}
		if(!"".equals(Utility.getName(barCodeSetPo.getFbcsgoodsid()))){					
			sb.append("and F_BCS_GoodsID = ?  ");
		    params.add(Utility.getName(barCodeSetPo.getFbcsgoodsid()));
		}		
	
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());

	}
	
	
	public BarCodeSetPo getBarCodeSetPo(BarCodeSetPo barCodeSetPo) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" select F_BCS_ID as fbcsid,F_BCS_GoodsCategoryID as fbcsgoodscategoryid,F_BCS_GoodsCategoryName as fbcsgoodscategoryname,F_BCS_Iscustomize as fbcsiscustomize, ");	
		sb.append(" F_BCS_SupplierID as fbcssupplierid,F_BCS_SupplierName as fbcssuppliername,F_BCS_BrandID as fbcsbrandid,F_BCS_BrandName as fbcsbrandname,F_BCS_GoodsID as fbcsgoodsid,F_BCS_GoodsName as fbcsgoodsname,F_BCS_BarCodeFlag as fbcsbarcodeflag ");
		sb.append(" from F_BarCodeSet where F_BCS_ID = ?  ");
		
		params.add(barCodeSetPo.getFbcsid());
		
		return (BarCodeSetPo)queryForObject(sb.toString(), params.toArray(),BarCodeSetPo.class);
	}
	
}
