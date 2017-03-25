/**
 * 
 */
package com.pengsheng.eims.components.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.components.dao.CustomerOptometryDao;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

/**
 * @author Liuqian
 * 
 */
public class CustomerOptometryDaoImpl extends BaseJdbcDaoSupport implements
		CustomerOptometryDao {


	public OptometryPo getOptometryPo(String optometryID) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1 ");
		buffer.append("S_OP_OY_OptometryID as sopoyoptometryid ");
		buffer.append(",S_OP_OY_OptometryBasicID as sopoyoptometrybasicid ");
		buffer.append(",S_OP_OY_ShopCode as sopoyshopcode ");
		buffer.append(",S_OP_OY_CustomerID as sopoycustomerid ");
		buffer.append(",S_OP_OY_PersonID as sopoypersonid ");
		buffer.append(",S_OP_OY_Time as sopoytime ");
		buffer.append(",S_OP_OY_RecipeUpdateTime as sopoyrecipeupdatetime ");
		buffer.append(",S_OP_OY_Flag as sopoyflag ");
		buffer.append(",S_OP_OY_Updateuserid as sopoyupdateuserid ");
		buffer.append(",personName as sopoypersonname ");
		buffer.append(",S_OP_OY_isInternal as sopoyisinternal ");
		buffer.append("FROM S_OP_Optometry ");
		buffer.append("INNER JOIN ");
		buffer.append("SYS_PersonInfo ON S_OP_OY_PersonID = SYS_PersonInfo.ID ");
		buffer.append("WHERE S_OP_OY_OptometryID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(optometryID);

		return (OptometryPo) this.queryForObject(buffer.toString(), params
				.toArray(), OptometryPo.class);
	}

}
