package com.pengsheng.eims.report.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.report.dao.LeaderBoardDao;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class LeaderBoardDaoImpl extends BaseJdbcDaoSupport implements LeaderBoardDao {

	/**
	 *   各店独立核算表,查询各个销售门店
	 */
	public List<DepartmentsPo> getEachStoreList(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select B_DP_DepartmentID as bdpdepartmentid,B_DP_DepartmentName as bdpdepartmentname from B_Departments where B_DP_Type='1' and B_DP_IsClosed='0' ");

		return queryForObjectList(buffer.toString(),null,DepartmentsPo.class);
	}
	
	/**
	 *   根据不同的部门参数获取部门列表
	 */
	public List<DepartmentsPo> getDepartmentList(DepartmentsPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select B_DP_DepartmentID as bdpdepartmentid,B_DP_DepartmentName as bdpdepartmentname from B_Departments where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getBdptype()))){
			
			if (Utility.getName(po.getBdptype()).indexOf(",") >= 0){
				buffer.append(" and B_DP_Type in ( ");
				
				String[] bdptypes = Utility.getName(po.getBdptype()).split(",");
				for (int i = 0; i < bdptypes.length; i++){
					buffer.append(" ?, ");
					params.add(Utility.getName(bdptypes[i]));
				}
				buffer.deleteCharAt(buffer.lastIndexOf(","));
				buffer.append(" ) ");
			}else{
				buffer.append(" and B_DP_Type = ? ");
				params.add(Utility.getName(po.getBdptype()));
			}			
		}
		if (!"".equals(Utility.getName(po.getBdpisclosed()))){
			buffer.append(" and B_DP_IsClosed=? ");
			params.add(Utility.getName(po.getBdpisclosed()));
		}
		if (!"".equals(Utility.getName(po.getBdpregid()))){
			buffer.append(" and B_DP_RegID=? ");
			params.add(Utility.getName(po.getBdpregid()));
		}
		if (!"".equals(Utility.getName(po.getBdpdepartmentid()))){
			buffer.append(" and B_DP_DepartmentID=? ");
			params.add(Utility.getName(po.getBdpdepartmentid()));
		}
		if (!"".equals(Utility.getName(po.getBdpcompanysid()))){
			buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBdpcompanysid()));
		}

		return queryForObjectList(buffer.toString(),params.toArray(),DepartmentsPo.class);
	}
	
	/**
	 * 查询商品类别
	 */
	public List<GoodsCategoryPo> getGoodsCategoryList(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select B_GC_ID as bgcid,B_GC_GoodsCategoryName as bgcgoodscategoryname from B_GoodsCategory order by B_GC_Order ");

		return queryForObjectList(buffer.toString(),null,GoodsCategoryPo.class);
	}
	
}
