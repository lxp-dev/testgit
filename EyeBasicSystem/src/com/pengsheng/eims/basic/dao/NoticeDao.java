package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.NoticeFilePo;
import com.pengsheng.eims.basic.persistence.NoticePo;
import com.pengsheng.eims.basic.persistence.NoticeStaffViewPo;
import com.pengsheng.eims.basic.persistence.RepairsCostPo;
import com.pengsheng.eims.basic.persistence.StoresSalesPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

/**
 * 公告管理Dao
 * @author sxh 2012 10 13
 *
 */
public interface NoticeDao {
	
	/**
	 * 插入公告
	 * @param po
	 */
	public void insertNotice(NoticePo po);
	
	/**
	 * 更新公告
	 * @param po
	 */
	public void updateNotice(NoticePo po);
	
	/**
	 * 删除公告
	 * @param po
	 */
	public void deleteNotice(NoticePo po);
	/**
	 * 删除公告查看人的子表
	 */
	public void deleteNoticeStaffViewPo(NoticePo po) ;
	
	/**
	 * 查询公告count
	 * @param po
	 * @return
	 */
	public int selectNoticeCount(NoticePo po);
	
	/**
	 * 查询公告list
	 * @param po
	 * @return
	 */
	public List<NoticePo> selectNoticeList(NoticePo po, int start, int size);
	
	/**
	 * 获取所有门店信息
	 * @param po
	 * @return
	 */
	public List<DepartmentsPo> selectDepartmentList(NoticePo po);
	
	/**
	 * 查询公告Po
	 * @param po
	 * @return
	 */
	public NoticePo selectNoticePo(NoticePo po);

	/**
	 * 查询公告附件
	 * @param po
	 * @return
	 */
	public List<NoticeFilePo> selectNoticeFile(NoticePo po);
	
	/**
	 * 下载公告附件
	 * @param po
	 * @return
	 */
	public NoticeFilePo selectNoticeFile(NoticeFilePo po);
	
	public int getViewNoticePersonCount(NoticePo po);
	
	/**
	 * 查询公告所有查看过的人
	 * @param po
	 * @return
	 */
	public List<PersonInfoPo> getPersonList(NoticePo po,int start, int size) ;
	/**
	 * 新增公告查看人
	 */
	public void insertNoticeStaffViewPo(NoticeStaffViewPo po) ;
	
	/**
	 * 判断员工是否查看过公告
	 */
	public int getNoticeStaffViewCount(NoticeStaffViewPo po);
	
	/**
	 * 更新员工是否查看过公告
	 */
	public void updateNoticeStaffView(NoticeStaffViewPo po);
	
	/**
	 * 加载部门
	 */
	public List<DepartmentsPo> getDepartmentsList(String id) ;
	
	/**
	 *  上传多文件附件
	 */
	public void insertNoticeFile(NoticePo po);
	
	/**
	 *  删除上传的附件
	 */
	public void deleteNoticeFile(NoticePo po);
	
	/**
	 *  删除上传的附件
	 */
	public void deleteNoticeFile(NoticeFilePo po);
	
	/**
	 * 审核公告
	 */
	public void updateNoticeAudit(NoticePo po) ;
	
	/**
	 * 修改公告发布部门
	 */
	public void updateNoticeDpt(NoticePo po);
	
	/**
	 * 启用停用公告
	 */
	public void updateNoticeEnable(NoticePo po);
	
	
	/**
	 * 插入公告类型
	 * @param po
	 */
	public void insertNoticeType(NoticePo po);
	
	/**
	 * 更新公告类型
	 * @param po
	 */
	public void updateNoticeType(NoticePo po);
	
	/**
	 * 删除公告类型
	 * @param po
	 */
	public void deleteNoticeType(NoticePo po);
		
	/**
	 * 查询公告类型的总数
	 * @param po
	 * @return
	 */
	public int getNoticeTypeCount(NoticePo po);
	
	/**
	 * 查询公告类型的列表
	 * @param po
	 * @return
	 */
	public List<NoticePo> getNoticeTypeList(NoticePo po, int start, int size);
	
	/**
	 * 查询公告类型的明细
	 * @param po
	 * @return
	 */
	public NoticePo getNoticeTypeDetail(NoticePo po);
	
	/**
	 * 查询公告类型的列表
	 * @param po
	 * @return
	 */
	public List<NoticePo> getNoticeTypeList();

	/**
	 * 查询销售门店昨天的销售金额(获取记录数量)
	 */
	public int getStoresSalesAmountCount(String departmentID, String totalType, String companyID);

	/**
	 * 查询销售门店昨天的销售金额
	 */
	public List<StoresSalesPo> getStoresSalesAmountList(String departmentID, String totalType, String companyID);
	
	/**
	 * 查询维修项的明细
	 * @param po
	 * @return
	 */
	public RepairsCostPo getRepairsCostDetail(RepairsCostPo po);
	
	/**
	 * 插入维修项
	 * @param po
	 */
	public void insertRepairsCost(RepairsCostPo po);
	
	/**
	 * 更新维修项
	 * @param po
	 */
	public void updateRepairsCost(RepairsCostPo po);
	
	/**
	 * 删除维修项
	 * @param po
	 */
	public void deleteRepairsCost(RepairsCostPo po);
	
	/**
	 * 查询维修项的总数
	 * @param po
	 * @return
	 */
	public int getRepairsCostCount(RepairsCostPo po);
	
	/**
	 * 查询维修项的列表
	 * @param po
	 * @return
	 */
	public List<RepairsCostPo> getRepairsCostList(RepairsCostPo po, int start, int size);
	
}
