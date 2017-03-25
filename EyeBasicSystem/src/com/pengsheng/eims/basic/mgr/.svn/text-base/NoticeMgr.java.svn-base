package com.pengsheng.eims.basic.mgr;

import java.io.File;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.NoticeFilePo;
import com.pengsheng.eims.basic.persistence.NoticePo;
import com.pengsheng.eims.basic.persistence.NoticeStaffViewPo;
import com.pengsheng.eims.basic.persistence.RepairsCostPo;
import com.pengsheng.eims.basic.persistence.StoresSalesPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface NoticeMgr {
	/**
	 * 插入公告
	 * @param po
	 */
	public void insertNotice(NoticePo po,File[] upload, String filePath, String[] fFullName,String[] ContentType,LogisticsLogPo logPo);
	
	/**
	 * 更新公告
	 * @param po
	 */
	public void updateNotice(NoticePo po,File[] upload, String filePath, String[] fFullName,String[] ContentType,LogisticsLogPo logPo);
	
	/**
	 * 删除公告
	 * @param po
	 */
	public void deleteNotice(NoticePo po,LogisticsLogPo logPo);
	
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
	
	/**
	 * 删除附件
	 * @param po
	 */
	public void deleteNoticeFile(NoticeFilePo po,LogisticsLogPo logPo);
	
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
	
	public int getViewNoticePersonCount(NoticePo po);
	
	/**
	 * 查询公告所有查看过的人
	 */
	public List<PersonInfoPo> getPersonList(NoticePo po,int start, int size) ;
	
	/**
	 * 加载部门
	 */
	public List<DepartmentsPo> getDepartmentsList(String id) ;
	
	/**
	 * 审核公告
	 */
	public void updateNoticeAudit(NoticePo po,LogisticsLogPo logPo) ;
	
	/**
	 * 启用停用公告
	 */
	public void updateNoticeEnable(NoticePo po,LogisticsLogPo logPo);
	
	/**
	 * 修改公告发布部门
	 */
	public void updateNoticeDpt(NoticePo po,LogisticsLogPo logPo);
	
	/**
	 * 插入公告类型
	 * @param po
	 */
	public void insertNoticeType(NoticePo po,LogisticsLogPo logPo);
	
	/**
	 * 更新公告类型
	 * @param po
	 */
	public void updateNoticeType(NoticePo po,LogisticsLogPo logPo);
	
	/**
	 * 删除公告类型
	 * @param po
	 */
	public void deleteNoticeType(NoticePo po,LogisticsLogPo logPo);
		
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
	public int getStoresSalesAmountCount(String departmentID, String totalType,String companyID);

	/**
	 * 查询销售门店昨天的销售金额
	 */
	public List<StoresSalesPo> getStoresSalesAmountList(String departmentID, String totalType,String companyID);
	
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
	public void insertRepairsCost(RepairsCostPo po,LogisticsLogPo logPo);
	
	/**
	 * 更新维修项
	 * @param po
	 */
	public void updateRepairsCost(RepairsCostPo po,LogisticsLogPo logPo);
	
	/**
	 * 删除维修项
	 * @param po
	 */
	public void deleteRepairsCost(RepairsCostPo po,LogisticsLogPo logPo);
	
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
