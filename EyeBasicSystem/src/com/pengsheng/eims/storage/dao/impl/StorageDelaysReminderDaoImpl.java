package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.sales.persistence.DelaysReminderPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.dao.StorageDelaysReminderDao;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class StorageDelaysReminderDaoImpl extends BaseJdbcDaoSupport implements
		StorageDelaysReminderDao {
	/**
	 * 误期查询-误期提醒信息数量
	 */
	public int getStoragetDelaysRemindertCount(DelaysReminderPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("select count(S_SE_DR_ID)  ");

		buffer.append("from S_SE_DelaysReminder ");

		buffer
				.append("inner join B_Departments on S_SE_DelaysReminder.S_SE_DR_ShopCode = B_Departments.B_DP_DepartmentID ");
		buffer
				.append("left join SYS_PersonInfo audit on S_SE_DR_AuditPerson=audit.ID ");
		buffer
				.append("left join SYS_PersonInfo notice on S_SE_DR_NoticePerson=notice.ID ");
		buffer
				.append("inner join S_SE_SalesBasic on S_SE_DelaysReminder.S_SE_DR_SalesID = S_SE_SalesBasic.S_SE_SB_SalesID ");
		buffer
				.append("inner join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		buffer.append("where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getSsedrsalesid()))) { // 配镜单号
			buffer.append("and S_SE_DR_SalesID like '%' + ? + '%' ");//quyanping
			params.add(po.getSsedrsalesid());
		}

		if (!"".equals(Utility.getName(po.getSsedrcustomerName()))) { // 顾客姓名
			buffer.append("and S_ME_CI_Name  like '%' + ? + '%'  ");
			params.add(po.getSsedrcustomerName());
		}

		// 原取镜日期
		if (!"".equals(Utility.getName(po.getSsedrmirrorcheckstartdate()))
				&& !"".equals(Utility.getName(po.getSsedrmirrorcheckenddate()))) { // 财务审核日期查询
			buffer
					.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) >= ? ");
			buffer
					.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) <= ? ");
			params.add(po.getSsedrmirrorcheckstartdate());
			params.add(po.getSsedrmirrorcheckenddate());
		} else if (!"".equals(Utility
				.getName(po.getSsedrmirrorcheckstartdate()))
				&& "".equals(Utility.getName(po.getSsedrmirrorcheckenddate()))) {
			buffer
					.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) >=  ? ");
			params.add(po.getSsedrmirrorcheckstartdate());
		} else if (""
				.equals(Utility.getName(po.getSsedrmirrorcheckstartdate()))
				&& !"".equals(Utility.getName(po.getSsedrmirrorcheckenddate()))) {
			buffer
					.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) <= ? ");
			params.add(po.getSsedrmirrorcheckenddate());
		}

		// 预计取镜日期
		if (!"".equals(Utility.getName(po.getSsedrexpectedcheckstartdate()))
				&& !"".equals(Utility
						.getName(po.getSsedrexpectedcheckenddate()))) { // 财务审核日期查询
			buffer
					.append("and convert(varchar(10), S_SE_DR_ExpectedCheckDate, 23) >= ? ");
			buffer
					.append("and convert(varchar(10), S_SE_DR_ExpectedCheckDate, 23) <= ? ");
			params.add(po.getSsedrexpectedcheckstartdate());
			params.add(po.getSsedrexpectedcheckenddate());
		} else if (!"".equals(Utility.getName(po
				.getSsedrexpectedcheckstartdate()))
				&& ""
						.equals(Utility.getName(po
								.getSsedrexpectedcheckenddate()))) {
			buffer
					.append("and convert(varchar(10), S_SE_DR_ExpectedCheckDate, 23) >=  ? ");
			params.add(po.getSsedrexpectedcheckstartdate());
		} else if ("".equals(Utility.getName(po
				.getSsedrexpectedcheckstartdate()))
				&& !"".equals(Utility
						.getName(po.getSsedrexpectedcheckenddate()))) {
			buffer
					.append("and convert(varchar(10), S_SE_DR_ExpectedCheckDate, 23) <= ? ");
			params.add(po.getSsedrexpectedcheckenddate());
		}

		if (!"".equals(Utility.getName(po.getSsedrnoticeperson()))) { // 通知人
			buffer.append("and notice.personName like '%' + ? + '%' ");
			params.add(po.getSsedrnoticeperson());
		}

		// 通知日期
		if (!"".equals(Utility.getName(po.getSsedrnoticestartdate()))
				&& !"".equals(Utility.getName(po.getSsedrnoticeenddate()))) { // 财务审核日期查询
			buffer
					.append("and convert(varchar(10), S_SE_DR_NoticeDate, 23) >= ? ");
			buffer
					.append("and convert(varchar(10), S_SE_DR_NoticeDate, 23) <= ? ");
			params.add(po.getSsedrnoticestartdate());
			params.add(po.getSsedrnoticeenddate());
		} else if (!"".equals(Utility.getName(po.getSsedrnoticestartdate()))
				&& "".equals(Utility.getName(po.getSsedrnoticeenddate()))) {
			buffer
					.append("and convert(varchar(10), S_SE_DR_NoticeDate, 23) >=  ? ");
			params.add(po.getSsedrnoticestartdate());
		} else if ("".equals(Utility.getName(po.getSsedrnoticestartdate()))
				&& !"".equals(Utility.getName(po.getSsedrnoticeenddate()))) {
			buffer
					.append("and convert(varchar(10), S_SE_DR_NoticeDate, 23) <= ? ");
			params.add(po.getSsedrnoticeenddate());
		}

		if (!"".equals(Utility.getName(po.getSsedrnoticestatus()))) { // 通知状态
			buffer.append("and S_SE_DR_NoticeStatus = ?  ");
			params.add(po.getSsedrnoticestatus());
		}

		return getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());
	}

	/**
	 * 误期查询-遍历误期提醒信息
	 */
	public List<DelaysReminderPo> getStorageDelaysRemindertList(
			DelaysReminderPo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from(select ROW_NUMBER() Over ");
		buffer.append("(order by S_SE_DR_MirrorCheckDate desc) as rowNum, ");
		buffer.append("S_SE_DR_ID as ssedrid, ");
		buffer.append("S_SE_DR_SalesID as ssedrsalesid, ");
		buffer.append("B_DP_DepartmentName as ssedrshopcode, ");
		buffer.append("S_ME_CI_CustomerID as ssedrcustomerid, ");
		buffer.append("S_ME_CI_Name as ssedrname, ");
		buffer.append("S_SE_DR_MirrorCheckDate as ssedrmirrorcheckdate, ");
		buffer.append("S_SE_DR_ExpectedCheckDate as ssedrexpectedcheckdate, ");
		buffer.append("S_SE_DR_CausesDelays as ssedrcausesdelays, ");
		buffer.append("audit.personName as ssedrauditperson, ");
		buffer.append("S_SE_DR_AuditDate as ssedrauditdate, ");
		buffer.append("S_SE_DR_AuditStatus as ssedrauditstatus, ");
		buffer.append("notice.personName as ssedrnoticeperson, ");
		buffer.append("S_SE_DR_NoticeDate as ssedrnoticedate, ");
		buffer.append("S_SE_DR_NoticeStatus as ssedrnoticestatus, ");
		buffer.append("S_SE_DR_CreateDate as ssedrCreatedate ");
		buffer.append("from S_SE_DelaysReminder ");

		buffer
				.append("inner join B_Departments on S_SE_DelaysReminder.S_SE_DR_ShopCode = B_Departments.B_DP_DepartmentID ");
		buffer
				.append("left join SYS_PersonInfo audit on S_SE_DR_AuditPerson=audit.ID ");
		buffer
				.append("left join SYS_PersonInfo notice on S_SE_DR_NoticePerson=notice.ID ");
		buffer
				.append("inner join S_SE_SalesBasic on S_SE_DelaysReminder.S_SE_DR_SalesID = S_SE_SalesBasic.S_SE_SB_SalesID ");
		buffer
				.append("inner join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		buffer.append("where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getSsedrsalesid()))) { // 配镜单号
			buffer.append("and S_SE_DR_SalesID like '%' + ? + '%'  ");//quyanping
			params.add(po.getSsedrsalesid());
		}

		if (!"".equals(Utility.getName(po.getSsedrcustomerName()))) { // 顾客姓名
			buffer.append("and S_ME_CI_Name  like '%' + ? + '%'  ");
			params.add(po.getSsedrcustomerName());
		}

		// 原取镜日期
		if (!"".equals(Utility.getName(po.getSsedrmirrorcheckstartdate()))
				&& !"".equals(Utility.getName(po.getSsedrmirrorcheckenddate()))) { // 财务审核日期查询
			buffer
					.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) >= ? ");
			buffer
					.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) <= ? ");
			params.add(po.getSsedrmirrorcheckstartdate());
			params.add(po.getSsedrmirrorcheckenddate());
		} else if (!"".equals(Utility
				.getName(po.getSsedrmirrorcheckstartdate()))
				&& "".equals(Utility.getName(po.getSsedrmirrorcheckenddate()))) {
			buffer
					.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) >=  ? ");
			params.add(po.getSsedrmirrorcheckstartdate());
		} else if (""
				.equals(Utility.getName(po.getSsedrmirrorcheckstartdate()))
				&& !"".equals(Utility.getName(po.getSsedrmirrorcheckenddate()))) {
			buffer
					.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) <= ? ");
			params.add(po.getSsedrmirrorcheckenddate());
		}

		// 预计取镜日期
		if (!"".equals(Utility.getName(po.getSsedrexpectedcheckstartdate()))
				&& !"".equals(Utility
						.getName(po.getSsedrexpectedcheckenddate()))) { // 财务审核日期查询
			buffer
					.append("and convert(varchar(10), S_SE_DR_ExpectedCheckDate, 23) >= ? ");
			buffer
					.append("and convert(varchar(10), S_SE_DR_ExpectedCheckDate, 23) <= ? ");
			params.add(po.getSsedrexpectedcheckstartdate());
			params.add(po.getSsedrexpectedcheckenddate());
		} else if (!"".equals(Utility.getName(po
				.getSsedrexpectedcheckstartdate()))
				&& ""
						.equals(Utility.getName(po
								.getSsedrexpectedcheckenddate()))) {
			buffer
					.append("and convert(varchar(10), S_SE_DR_ExpectedCheckDate, 23) >=  ? ");
			params.add(po.getSsedrexpectedcheckstartdate());
		} else if ("".equals(Utility.getName(po
				.getSsedrexpectedcheckstartdate()))
				&& !"".equals(Utility
						.getName(po.getSsedrexpectedcheckenddate()))) {
			buffer
					.append("and convert(varchar(10), S_SE_DR_ExpectedCheckDate, 23) <= ? ");
			params.add(po.getSsedrexpectedcheckenddate());
		}

		if (!"".equals(Utility.getName(po.getSsedrnoticeperson()))) { // 通知人
			buffer.append("and notice.personName like '%' + ? + '%' ");
			params.add(po.getSsedrnoticeperson());
		}

		// 通知日期
		if (!"".equals(Utility.getName(po.getSsedrnoticestartdate()))
				&& !"".equals(Utility.getName(po.getSsedrnoticeenddate()))) { // 财务审核日期查询
			buffer
					.append("and convert(varchar(10), S_SE_DR_NoticeDate, 23) >= ? ");
			buffer
					.append("and convert(varchar(10), S_SE_DR_NoticeDate, 23) <= ? ");
			params.add(po.getSsedrnoticestartdate());
			params.add(po.getSsedrnoticeenddate());
		} else if (!"".equals(Utility.getName(po.getSsedrnoticestartdate()))
				&& "".equals(Utility.getName(po.getSsedrnoticeenddate()))) {
			buffer
					.append("and convert(varchar(10), S_SE_DR_NoticeDate, 23) >=  ? ");
			params.add(po.getSsedrnoticestartdate());
		} else if ("".equals(Utility.getName(po.getSsedrnoticestartdate()))
				&& !"".equals(Utility.getName(po.getSsedrnoticeenddate()))) {
			buffer
					.append("and convert(varchar(10), S_SE_DR_NoticeDate, 23) <= ? ");
			params.add(po.getSsedrnoticeenddate());
		}

		if (!"".equals(Utility.getName(po.getSsedrnoticestatus()))) { // 通知状态
			buffer.append("and S_SE_DR_NoticeStatus = ?  ");
			params.add(po.getSsedrnoticestatus());
		}

		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ (start + size));
		buffer.append("set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(),
				DelaysReminderPo.class);
	}

	/**
	 * 取出销售单中右眼镜片信息
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1  S_SE_SB_OrdersType as ssesborderstype , ");
		buffer.append("S_SE_SB_BallGlassOD as ssesbballglassod , ");
		buffer.append("S_SE_SB_PostGlassOD as ssesbpostglassod , ");
		buffer.append("S_SE_SB_AxesOD as ssesbaxesod , ");
		buffer.append("S_SE_SB_ADDOD as ssesbaddod , ");
		buffer.append("S_SE_SB_ArriseGlassOD1 as ssesbarriseglassod , ");
		buffer.append("S_SE_SB_BasisOD1 as ssesbbasisod , ");
		buffer.append("S_SE_SB_PrismOD as ssesbprismod , ");
		buffer.append("S_SE_SB_InterHighOD as ssesbinterhighod , ");
		buffer.append("S_SE_SB_InterDistanceOD as ssesbinterdistanceod , ");
		buffer.append("S_SE_SB_FarVAOD as ssesbfarvaod , ");
		buffer.append("S_SE_SB_CloseVAOD as ssesbclosevaod ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("where S_SE_SB_SalesID = ? ");

		params.add(salesBasicPo.getSsesbsalesid());

		return (SalesBasicPo) queryForObject(buffer.toString(), params
				.toArray(), SalesBasicPo.class);
	}

	/**
	 * 取出销售单中左眼镜片信息
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1  S_SE_SB_OrdersType as ssesborderstype , ");
		buffer.append("S_SE_SB_BallGlassOS as ssesbballglassos , ");
		buffer.append("S_SE_SB_PostGlassOS as ssesbpostglassos , ");
		buffer.append("S_SE_SB_AxesOS as ssesbaxesos , ");
		buffer.append("S_SE_SB_ADDOS as ssesbaddos , ");
		buffer.append("S_SE_SB_ArriseGlassOS1 as ssesbarriseglassos , ");
		buffer.append("S_SE_SB_BasisOS1 as ssesbbasisos , ");
		buffer.append("S_SE_SB_PrismOS as ssesbprismos , ");
		buffer.append("S_SE_SB_InterHighOS as ssesbinterhighos , ");
		buffer.append("S_SE_SB_InterDistanceOS as ssesbinterdistanceos , ");
		buffer.append("S_SE_SB_FarVAOS as ssesbfarvaos , ");
		buffer.append("S_SE_SB_CloseVAOS as ssesbclosevaos ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("where S_SE_SB_SalesID = ? ");

		params.add(salesBasicPo.getSsesbsalesid());

		return (SalesBasicPo) queryForObject(buffer.toString(), params
				.toArray(), SalesBasicPo.class);
	}

	/**
	 *误期登记新增误期信息
	 */
	public void insertDelaysRemindert(DelaysReminderPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into S_SE_DelaysReminder ");
		buffer.append("(S_SE_DR_ID , ");
		buffer.append("S_SE_DR_SalesID , ");
		buffer.append("S_SE_DR_ShopCode , ");
		buffer.append("S_SE_DR_MirrorCheckDate, ");
		buffer.append("S_SE_DR_ExpectedCheckDate, ");
		// buffer.append("S_SE_DR_NoticeDate, ");
		// buffer.append("S_SE_DR_NoticePerson, ");

		// if ("1".equals(Utility.getName(po.getSsedrauditstatus()))) {
		buffer.append("S_SE_DR_AuditDate, ");
		buffer.append("S_SE_DR_AuditPerson, ");
		// }

		buffer.append("S_SE_DR_AuditStatus,");
		buffer.append("S_SE_DR_CausesDelays,  ");
		buffer.append("S_SE_DR_NoticeStatus ) ");

		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(po.getSsedrsalesid());
		params.add(po.getSsedrshopcode());
		params.add(po.getSsedrmirrorcheckdate());
		params.add(po.getSsedrexpectedcheckdate());
		// params.add(po.getSsedrnoticeperson());
		// params.add(po.getSsedrnoticedate());

		// if ("1".equals(Utility.getName(po.getSsedrauditstatus()))) {
		buffer.append("values (?, ?, ?, ?, ?, GETDATE(), ?, ?, ?, 0 ) ");
		params.add(po.getSsedrauditperson());

		// } else {
		// buffer.append("values (?, ?, ?, ?, ?, ?, ? ) ");
		// }

		params.add(po.getSsedrauditstatus());
		params.add(po.getSsedrcausesdelays());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 删除误期查询
	 */
	public void deleteStorageDelaysRemindert(String id) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from S_SE_DelaysReminder where S_SE_DR_ID = ?");

		List<String> params = new ArrayList<String>();
		params.add(id);

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}

	/**
	 * 查询误期信息
	 */
	public DelaysReminderPo getStorageDelaysRemindert(DelaysReminderPo po) {

		// StringBuffer buffer = new StringBuffer();
		// buffer.append("Select S_SE_DR_ID as ssedrid, ");
		// buffer.append("S_SE_DR_SalesID as ssedrsalesid, ");
		// buffer.append("B_DP_DepartmentName as ssedrshopcode, ");
		// buffer.append("S_ME_CI_CustomerID as ssedrcustomerid, ");
		// buffer.append("S_SE_DR_MirrorCheckDate as ssedrmirrorcheckdate, ");
		// buffer.append("S_SE_DR_ExpectedCheckDate as ssedrexpectedcheckdate, ");
		// buffer.append("S_SE_DR_CausesDelays as ssedrcausesdelays, ");
		// buffer.append("personName as ssedrauditperson, ");
		// buffer.append("S_SE_DR_AuditDate as ssedrauditdate, ");
		// buffer.append("S_SE_DR_AuditStatus as ssedrauditstatus, ");
		// buffer.append("personName as ssedrnoticeperson, ");
		// buffer.append("S_SE_DR_NoticeDate as ssedrnoticedate, ");
		// buffer.append("S_SE_DR_NoticeStatus as ssedrnoticestatus, ");
		// buffer.append("S_SE_DR_CreateDate as ssedrCreatedate ");
		// buffer.append("from S_SE_DelaysReminder ");
		//
		// buffer.append("inner join B_Departments on S_SE_DelaysReminder.S_SE_DR_ShopCode = B_Departments.B_DP_DepartmentID ");
		// buffer.append("left join SYS_PersonInfo on S_SE_DelaysReminder.S_SE_DR_AuditPerson=SYS_PersonInfo.ID ");
		// buffer.append("inner join S_SE_SalesBasic on S_SE_DelaysReminder.S_SE_DR_SalesID = S_SE_SalesBasic.S_SE_SB_SalesID ");
		// buffer.append("inner join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		// buffer.append("where S_SE_DR_ID =  ?  ");
		// List<String> params = new ArrayList<String>();
		// params.add(po.getSsedrid());
		//
		// return (DelaysReminderPo) queryForObject(buffer.toString(), params
		// .toArray(), DelaysReminderPo.class);
		return null;
	}

	/**
	 * 查询订单误期信息数量
	 */
	public int getOrderDelaysRemindertCount(DelaysReminderPo delaysReminderPo) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("select count(S_SE_DR_ID)  ");

		buffer.append("from orders.orders.dbo.C_ST_DelaysReminder ");
		buffer.append("inner join orders.orders.dbo.B_Departments ");
		buffer.append("on S_SE_DR_customer=B_DP_DepartmentID ");
		buffer.append("and B_DP_Type = 1 ");
		buffer.append("where 1=1 ");

		if (!"".equals(Utility.getName(delaysReminderPo.getSsedrsalesid()))) { // 配镜单号
			buffer.append("and S_SE_DR_SalesID like '%' + ? ");
			params.add(delaysReminderPo.getSsedrsalesid());
		}

		if (!""
				.equals(Utility
						.getName(delaysReminderPo.getSsedrcustomerName()))) { // 所属客户名称
			buffer.append("and B_DP_DepartmentName like '%' + ? + '%'  ");
			params.add(delaysReminderPo.getSsedrcustomerName());
		}

		// 原取镜日期
		if (!"".equals(Utility.getName(delaysReminderPo
				.getSsedrmirrorcheckstartdate()))
				&& !"".equals(Utility.getName(delaysReminderPo
						.getSsedrmirrorcheckenddate()))) { // 财务审核日期查询
			buffer
					.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) >= ? ");
			buffer
					.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) <= ? ");
			params.add(delaysReminderPo.getSsedrmirrorcheckstartdate());
			params.add(delaysReminderPo.getSsedrmirrorcheckenddate());
		} else if (!"".equals(Utility.getName(delaysReminderPo
				.getSsedrmirrorcheckstartdate()))
				&& "".equals(Utility.getName(delaysReminderPo
						.getSsedrmirrorcheckenddate()))) {
			buffer
					.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) >=  ? ");
			params.add(delaysReminderPo.getSsedrmirrorcheckstartdate());
		} else if ("".equals(Utility.getName(delaysReminderPo
				.getSsedrmirrorcheckstartdate()))
				&& !"".equals(Utility.getName(delaysReminderPo
						.getSsedrmirrorcheckenddate()))) {
			buffer
					.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) <= ? ");
			params.add(delaysReminderPo.getSsedrmirrorcheckenddate());
		}

		return getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());
	}

	/**
	 * 显示订单误期信息
	 */
	public List<DelaysReminderPo> getOrderDelaysRemindertList(
			DelaysReminderPo delaysReminderPo, int start, int size) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer
				.append("select * from(select ROW_NUMBER() Over (order by S_SE_DR_MirrorCheckDate desc) as rowNum, ");
		buffer.append("S_SE_DR_ID as ssedrid, ");
		buffer.append("S_SE_DR_SalesID as ssedrsalesid, ");
		buffer.append("S_SE_DR_customer as ssedrcustomer, ");
		buffer.append("B_DP_DepartmentName as ssedrcustomername, ");
		buffer.append("S_SE_DR_MirrorCheckDate as ssedrmirrorcheckdate ");
		buffer.append("from orders.orders.dbo.C_ST_DelaysReminder ");

		buffer
				.append("inner join orders.orders.dbo.B_Departments on S_SE_DR_customer=B_DP_DepartmentID and B_DP_Type = 1 ");
		buffer.append("where 1=1 ");

		if (!"".equals(Utility.getName(delaysReminderPo.getSsedrsalesid()))) { // 配镜单号
			buffer.append("and S_SE_DR_SalesID like '%' + ? ");
			params.add(delaysReminderPo.getSsedrsalesid());
		}

		if (!""
				.equals(Utility
						.getName(delaysReminderPo.getSsedrcustomerName()))) { // 所属客户名称
			buffer.append("and B_DP_DepartmentName like '%' + ? + '%'  ");
			params.add(delaysReminderPo.getSsedrcustomerName());
		}

		// 原取镜日期
		if (!"".equals(Utility.getName(delaysReminderPo
				.getSsedrmirrorcheckstartdate()))
				&& !"".equals(Utility.getName(delaysReminderPo
						.getSsedrmirrorcheckenddate()))) { // 财务审核日期查询
			buffer
					.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) >= ? ");
			buffer
					.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) <= ? ");
			params.add(delaysReminderPo.getSsedrmirrorcheckstartdate());
			params.add(delaysReminderPo.getSsedrmirrorcheckenddate());
		} else if (!"".equals(Utility.getName(delaysReminderPo
				.getSsedrmirrorcheckstartdate()))
				&& "".equals(Utility.getName(delaysReminderPo
						.getSsedrmirrorcheckenddate()))) {
			buffer
					.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) >=  ? ");
			params.add(delaysReminderPo.getSsedrmirrorcheckstartdate());
		} else if ("".equals(Utility.getName(delaysReminderPo
				.getSsedrmirrorcheckstartdate()))
				&& !"".equals(Utility.getName(delaysReminderPo
						.getSsedrmirrorcheckenddate()))) {
			buffer
					.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) <= ? ");
			params.add(delaysReminderPo.getSsedrmirrorcheckenddate());
		}

		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ (start + size));
		buffer.append("set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(),
				DelaysReminderPo.class);
	}

	/**
	 * 查询销售结帐基表信息
	 */
	public SalesBasicPo getSalesBasic(SalesBasicPo po) {

		StringBuffer buffer = new StringBuffer();

		buffer.append("select top 1 ");

		buffer.append("S_SE_SB_SalesID as ssesbsalesid, ");
		buffer.append("B_DP_DepartmentID as ssesbshopcode , ");
		buffer.append("B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("S_ME_CI_Name as ssedrcustomerName , ");
		buffer.append("S_ME_CI_CustomerID as ssesbcustomerid , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata ");
		buffer.append("from S_SE_SalesBasic  ");

		buffer
				.append("inner join B_Departments on S_SE_SB_ShopCode = B_Departments.B_DP_DepartmentID ");
		buffer
				.append("inner join S_ME_CustomerInfo on S_SE_SB_CustomerID = S_ME_CI_CustomerID ");
		buffer.append("where S_SE_SB_SalesID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(po.getSsesbsalesid());

		return (SalesBasicPo) queryForObject(buffer.toString(), params
				.toArray(), SalesBasicPo.class);
	}

	public void delaysReminderUpdate(String salesID) {
		String sql = "exec SP_DelaysReminderUpdate ? ";

		getJdbcTemplate().update(sql, new String[] { salesID });
	}
}
