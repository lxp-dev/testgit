package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.system.dao.RegisteredCategoryDao;
import com.pengsheng.eims.system.persistence.AdditionalCostsPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;
import com.pengsheng.eims.system.persistence.RegisteredPrintDetailsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * RegisteredCategoryDaoImpl 挂号类型Dao实现类
 * 
 * @author GuanZiGang
 * @version 1.0
 */
public class RegisteredCategoryDaoImpl extends BaseJdbcDaoSupport implements
		RegisteredCategoryDao {

	/**
	 * 新增挂号类型
	 * 
	 * @param po
	 *            挂号类型po
	 * @return void
	 */
	public void insertRegisteredCategory(RegisteredCategoryPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" INSERT INTO f_registeredcategory");
		buffer.append("            (f_rc_id");
		buffer.append("            ,f_rc_registeredname");
		buffer.append("            ,f_rc_money");
		buffer.append("            ,f_rc_feetype");
		buffer.append("            ,f_rc_ordertype");
		buffer.append("            ,f_rc_registeredtype");
		buffer.append("            ,f_rc_flag");
		buffer.append("            ,f_rc_amounttype");
		buffer.append("            ,F_RC_PayFeeID)");
		buffer.append("      VALUES");
		buffer.append("            ('" + Utility.getName(po.getFrcid()) + "'");
		buffer.append("            ,'"
				+ Utility.getName(po.getFrcregisteredname()) + "'");
		buffer.append("            ,'" + Utility.getName(po.getFrcmoney())
				+ "'");
		buffer.append("            ,'" + Utility.getName(po.getFrcfeetype())
				+ "'");
		buffer.append("            ,0");
		buffer.append("            ,'" + Utility.getName(po.getFrcregisteredtype()) + "'");
		// 停用状态
		buffer.append("            ,'0'");
		buffer.append("            ,'" + Utility.getName(po.getFrcamounttype()) + "'");
		buffer.append("            ,'" + Utility.getName(po.getFrcpayfeeid()) + "')");
		
		getJdbcTemplate().update(buffer.toString());
	}

	/**
	 * 检查挂号类型编号是否重复
	 * 
	 * @param po
	 *            挂号类型po
	 * @return int 0:不存在 大于0存在
	 */
	public int searchRegisteredId(RegisteredCategoryPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer
				.append(" select count(*) from F_RegisteredCategory where F_RC_ID = '"
						+ Utility.getName(po.getFrcid()) + "'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	/**
	 * 按条件检索检查费用项目进行管理
	 * 
	 * @param flag
	 *            启用停用标示位 1:启用 0：停用
	 * @param feeType
	 *            收费类型 1:缴费 2：退费
	 * @return List
	 */
	public List getSelValue(String flag, String feeType) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select f_rc_id as frcid");
		buffer.append("       ,f_rc_registeredname as frcregisteredname");
		buffer.append("       ,f_rc_money as frcmoney");
		buffer.append("       ,f_rc_feetype as frcfeetype");
		buffer.append("       ,f_rc_ordertype as frcordertype");
		buffer.append("       ,f_rc_registeredtype as frcregisteredtype");
		buffer.append("       ,f_rc_flag as frcflag");
		buffer.append("       ,F_RC_AmountType as frcamounttype ");
		buffer.append("   from f_registeredcategory");
		buffer.append(" where 1=1");
		// 启用、停用
		buffer.append(" and f_rc_flag = '" + Utility.getName(flag) + "'");
		// 缴费、退费
		buffer.append(" and f_rc_feetype = '" + Utility.getName(feeType) + "'");
		buffer.append(" order by f_rc_ordertype");

//		System.out.println(buffer.toString());
		return this.queryForObjectList(buffer.toString(), null,
				RegisteredCategoryPo.class);
	}

	/**
	 * 挂号类型维护保存
	 * 
	 * @param stop
	 *            停用主键ID
	 * @param start
	 *            启用主键ID
	 * @return void
	 */
	public void saveManagerValue(String[] stop, String[] start) {
		ArrayList list = new ArrayList();
		if (stop != null) {
			for (int i = 0; i < stop.length; i++) {
				list.add(getManagerValueSQL(stop[i], 0, 0));
			}
		}

		if (start != null) {
			for (int i = 0; i < start.length; i++) {
				list.add(getManagerValueSQL(start[i], i, 1));
			}
		}

		getJdbcTemplate().batchUpdate((String[]) list.toArray(new String[0]));
	}

	public String getManagerValueSQL(String val, int order, int flag) {
		// 停用
		if (flag == 0) {
			return "update F_RegisteredCategory set F_RC_Flag = '" + flag
					+ "' where F_RC_ID = '" + val + "'";
		} else {// 启用
			return "update F_RegisteredCategory set F_RC_Flag = '" + flag
					+ "',F_RC_orderType=" + order + " where F_RC_ID = '" + val
					+ "'";
		}

	}

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po
	 *            查询条件
	 * @return int 挂号类型数量
	 */
	public int getRegisteredCategoryCount(RegisteredCategoryPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(f_rc_id)");
		buffer.append("   from f_registeredcategory");
		buffer.append(" where 1=1");

		// 收费类型
		if (!Utility.getName(po.getFrcfeetype()).equals("")) {
			buffer.append(" and f_rc_feetype = '"
					+ Utility.getName(po.getFrcfeetype()) + "'");
		}

		// 挂号类型
		if (!Utility.getName(po.getFrcregisteredtype()).equals("")) {
			buffer.append(" and f_rc_registeredtype='"
					+ Utility.getName(po.getFrcregisteredtype()) + "'");
		}

		// 挂号名称
		if (!Utility.getName(po.getFrcregisteredname()).equals("")) {
			buffer.append(" and f_rc_registeredname like '%"
					+ Utility.getName(po.getFrcregisteredname()) + "%'");
		}

		// 使用状态
		if (!Utility.getName(po.getFrcflag()).equals("")) {
			buffer.append(" and f_rc_flag ='"
					+ Utility.getName(po.getFrcflag()) + "'");
		}

		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po
	 *            查询条件 start 开始数量 size 每页显示数量
	 * @return List 挂号类型结果集
	 */
	public List getRegisteredCategoryList(RegisteredCategoryPo po, int start,
			int size) {
		StringBuffer buffer = new StringBuffer();

		buffer.append(" select * from (");
		buffer
				.append(" select ROW_NUMBER() Over(order by F_RC_Flag,F_RC_FeeType,F_RC_orderType) as rowNum");
		buffer.append("       ,f_rc_id as frcid");
		buffer.append("       ,f_rc_registeredname as frcregisteredname");
		buffer.append("       ,f_rc_money as frcmoney");
		buffer.append("       ,f_rc_feetype as frcfeetype");
		buffer.append("       ,f_rc_ordertype as frcordertype");
		buffer.append("       ,f_rc_registeredtype as frcregisteredtype");
		buffer.append("       ,f_rc_flag as frcflag");
		buffer.append("       ,f_rc_amounttype as frcamounttype ");
		buffer.append("   from f_registeredcategory");
		buffer.append(" where 1=1");

		// 收费类型
		if (!Utility.getName(po.getFrcfeetype()).equals("")) {
			buffer.append(" and f_rc_feetype = '"
					+ Utility.getName(po.getFrcfeetype()) + "'");
		}

		// 挂号类型
		if (!Utility.getName(po.getFrcregisteredtype()).equals("")) {
			buffer.append(" and f_rc_registeredtype='"
					+ Utility.getName(po.getFrcregisteredtype()) + "'");
		}

		// 挂号名称
		if (!Utility.getName(po.getFrcregisteredname()).equals("")) {
			buffer.append(" and f_rc_registeredname like '%"
					+ Utility.getName(po.getFrcregisteredname()) + "%'");
		}

		// 使用状态
		if (!Utility.getName(po.getFrcflag()).equals("")) {
			buffer.append(" and f_rc_flag ='"
					+ Utility.getName(po.getFrcflag()) + "'");
		}

		buffer.append(" ) table1 where rowNum >" + start + " and rowNum <="
				+ (start + size));
		return this.queryForObjectList(buffer.toString(), null,
				RegisteredCategoryPo.class);
	}

	/**
	 * 查询挂号类型的详细信息
	 * 
	 * @param po
	 *            查询条件
	 * @return po 挂号类型详细信息
	 */
	public RegisteredCategoryPo getRegisteredCategoryPo(RegisteredCategoryPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select top 1  f_rc_id as frcid");
		buffer.append("       ,f_rc_registeredname as frcregisteredname");
		buffer.append("       ,f_rc_money as frcmoney");
		buffer.append("       ,f_rc_feetype as frcfeetype");
		buffer.append("       ,f_rc_ordertype as frcordertype");
		buffer.append("       ,f_rc_registeredtype as frcregisteredtype");
		buffer.append("       ,f_rc_flag as frcflag");
		buffer.append("       ,F_RC_AmountType as frcamounttype");
		buffer.append("       ,F_RC_PayFeeID as frcpayfeeid");
		buffer.append("   from f_registeredcategory");
		buffer.append(" where f_rc_id = '" + Utility.getName(po.getFrcid())
				+ "'");
		return (RegisteredCategoryPo) queryForObject(buffer.toString(), null,
				RegisteredCategoryPo.class);
	}

	/**
	 * 更新挂号类型信息
	 * 
	 * @param po
	 *            挂号类型po
	 * @return void
	 */
	public void updateRegisteredCategory(RegisteredCategoryPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" update f_registeredcategory");
		buffer.append("    set f_rc_registeredname = '" + Utility.getName(po.getFrcregisteredname()) + "'");
		buffer.append("       ,f_rc_money = '" + Utility.getName(po.getFrcmoney()) + "'");
		buffer.append("       ,f_rc_feetype = '" + Utility.getName(po.getFrcfeetype()) + "'");
		buffer.append("       ,f_rc_registeredtype = '" + Utility.getName(po.getFrcregisteredtype()) + "'");
		buffer.append("       ,F_RC_AmountType = '" + Utility.getName(po.getFrcamounttype()) + "'");
		buffer.append("       ,F_RC_PayFeeID = '" + Utility.getName(po.getFrcpayfeeid()) + "'");
		buffer.append("  where f_rc_id = '" + Utility.getName(po.getFrcid())
				+ "'");
		getJdbcTemplate().update(buffer.toString());
	}

	/**
	 * 删除挂号类型
	 * 
	 * @param po
	 *            挂号类型po
	 * @return void
	 */
	public void deleteRegisteredCategory(RegisteredCategoryPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" delete from  F_RegisteredCategory where F_RC_ID = '"
				+ Utility.getName(po.getFrcid()) + "'");
		getJdbcTemplate().update(buffer.toString());
	}

	/**
	 * 查询挂号类型在 表中是否已经使用
	 * 
	 * @param po
	 *            查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getRegisteredCategoryWithOther(RegisteredCategoryPo po) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<RegisteredPrintDetailsPo> getRegisteredPrintDetails(
			String registeredID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT ");
		buffer.append("F_RPD_ID as frpdid ");
		buffer.append(",F_RPD_RegisteredID as frpdregisteredid ");
		buffer.append(",F_RPD_ProjectName as frpdprojectname ");
		buffer.append(",F_RPD_Spec as frpdspec ");
		buffer.append(",F_RPD_Unit as frpdunit ");
		buffer.append(",F_RPD_Price as frpdprice ");
		buffer.append(",F_RPD_Number as frpdnumber ");
		buffer.append(",F_RPD_Amount as frpdamount ");
		buffer.append("FROM F_RegisteredPrintDetails ");
		buffer.append("where F_RPD_RegisteredID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(registeredID);

		return queryForObjectList(buffer.toString(), params.toArray(),
				RegisteredPrintDetailsPo.class);
	}

	public void insertRegisteredPrintDetails(
			RegisteredPrintDetailsPo registeredPrintDetailsPo) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO F_RegisteredPrintDetails ");
		buffer.append("(F_RPD_ID ");
		buffer.append(",F_RPD_RegisteredID ");
		buffer.append(",F_RPD_ProjectName ");
		buffer.append(",F_RPD_Spec ");
		buffer.append(",F_RPD_Unit ");
		buffer.append(",F_RPD_Price ");
		buffer.append(",F_RPD_Number ");
		buffer.append(",F_RPD_Amount) ");
		buffer.append("VALUES ");
		buffer.append("(?,?,?");

		List<String> params = new ArrayList<String>();
		params.add(uuid.getInstance().generate());
		params.add(registeredPrintDetailsPo.getFrpdregisteredid());
		params.add(registeredPrintDetailsPo.getFrpdprojectname());

		if (!Utility.getName(registeredPrintDetailsPo.getFrpdspec()).equals("")) {
			buffer.append(", ?");
			params.add(registeredPrintDetailsPo.getFrpdspec());
		} else {
			buffer.append(", null");
		}

		if (!Utility.getName(registeredPrintDetailsPo.getFrpdunit()).equals("")) {
			buffer.append(", ?");
			params.add(registeredPrintDetailsPo.getFrpdunit());
		} else {
			buffer.append(", null");
		}

		if (!Utility.getName(registeredPrintDetailsPo.getFrpdprice())
				.equals("")) {
			buffer.append(", ?");
			params.add(registeredPrintDetailsPo.getFrpdprice());
		} else {
			buffer.append(", null");
		}

		if (!Utility.getName(registeredPrintDetailsPo.getFrpdnumber()).equals(
				"")) {
			buffer.append(", ?");
			params.add(registeredPrintDetailsPo.getFrpdnumber());
		} else {
			buffer.append(", null");
		}

		if (!Utility.getName(registeredPrintDetailsPo.getFrpdamount()).equals(
				"")) {
			buffer.append(", ?");
			params.add(registeredPrintDetailsPo.getFrpdamount());
		} else {
			buffer.append(", null");
		}

		buffer.append(") ");

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void delRegisteredPrintDetails(String registeredID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM F_RegisteredPrintDetails ");
		buffer.append("WHERE F_RPD_RegisteredID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(registeredID);

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}
