package com.pengsheng.eims.system.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentTypePo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.system.persistence.BrankCardPo;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.FuctionTreeNode;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface DepartmentsDao {

	/**
	 * 取所有部门
	 * 
	 * @return
	 */
	public List<DepartmentsPo> getAllDepartments(DepartmentsPo po);
	public List<DepartmentsPo> getAllDepartments();
	
	public List<DepartmentsPo> getDepartments();
	public List<DepartmentsPo> getDepartments(DepartmentsPo po);
	public List<DepartmentsPo> getDepartments2(DepartmentsPo po);
	
	public List<DepartmentsPo> getDepartmentwheres(DepartmentsPo po);

	/**
	 * 取指定部门
	 * @param departmentsPo 部门参数集
	 * @return
	 */
	public DepartmentsPo getDepartment(DepartmentsPo departmentsPo);
	
	/**
	 * 插入部门
	 * @param departmentsPo 部门对象
	 */
	public void insertDepartment(DepartmentsPo departmentsPo);
	
	/**
	 * 更新部门
	 * @param departmentsPo
	 */
	public void updateDepartment(DepartmentsPo departmentsPo);
	
	/**
	 * 初始化各部门打印单据为系统默认设置模版
	 * 
	 */
	public void updateDepartmentDefaultBill();
	
	/**
	 * 删除部门
	 * @param departmentID 部门编号
	 */
	public void deleteDepartment(String departmentID);
	public List<DepartmentsPo> getDepartments(String[] departmenttype, String isClosed, String companyID);
	/**
	 * 取所有部门
	 * 
	 * @return
	 */
	public List<DepartmentsPo> getDepartmentsForRegional(DepartmentsPo po);
	
	public DepartmentsPo getDepartmentForStorage();
	
	
	/**
	 * 取所有部门 根据部门类型
	 * 
	 * @return
	 */
	public List<DepartmentsPo> getDepartments(String departmenttype);
	
	/**
	 * 取所有部门根据本门类型
	 * 
	 * @return
	 */
	public List<DepartmentsPo> getDepartments(String departmenttype,String isclosed);
	
	/**
	 * 查询部门的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getDepartmentCount(DepartmentsPo po);
	
	/**
	 * 查询部门列表
	 * 
	 * @param po
	 * @return
	 */
	public List<DepartmentsPo> getDepartmentList(DepartmentsPo po,int start,int size);
	
	/**
	 * 设置默认仓位
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public int getDefaultWarehouseByDptCount(WarehouseConfigurationPo warehouseConfigurationPo);
	
	/**
	 * 修改默认仓位
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public void updateDefaultWarehouse(WarehouseConfigurationPo warehouseConfigurationPo);
	
	/**
	 * 新增默认仓位
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public void insertDefaultWarehouse(WarehouseConfigurationPo warehouseConfigurationPo);
	
	/**
	 * 获取默认仓位
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public WarehouseConfigurationPo getDefaultWarehouseByDpt(WarehouseConfigurationPo warehouseConfigurationPo);
	
	/**
	 * 获取出仓仓位
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public WarehouseConfigurationPo getOutWarehouseByDpt(WarehouseConfigurationPo warehouseConfigurationPo);
	
	/**
	 * 获取默认仓位名称
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public WarehouseConfigurationPo getDefaultWarehouse(WarehouseConfigurationPo warehouseConfigurationPo);
	
	/**
	 * 获取退款仓位
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public WarehouseConfigurationPo getInWarehouseByDpt(WarehouseConfigurationPo warehouseConfigurationPo);
	
	/**
	 * 停用启用部门
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public void usingDepartment(DepartmentsPo departmentsPo);
	
	/**
	 * 停用启用部门下的仓位
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public void usingWarehouse(DepartmentsPo departmentsPo);
	
	/**
	 * 根据部门ID查询所属仓位
	 */
	public List<WarehousePo> getWarehouseByDpt(DepartmentsPo departmentsPo);
	
	/**
	 * 根据部门ID查询是否存在所属的仓位和人员
	 */
	public int getWarehouseOrPersonCountByDpt(String departmentID);
	
	/**
	 * 删除部门与人员的对应关系
	 */
	public void deleteDptPersonRelationship(String departmentID);
	
	/**
	 * 查询所有门店和配送部门
	 */
	public List<DepartmentsPo> getSalesAndStorageDepartment();
	
	public List<DepartmentsPo> getSalesAndStorageDepartment(DepartmentsPo departmentsPo);
	
	/**
	 * 取所有部门(组织结构)
	 * 
	 * @return
	 */
	public List<FuctionTreeNode> getDepartmentsTree(String nodeId,String hrefTarget,String href,String isClosed,String companyID);
	
	/**
	 * 根据部门编号查询人员(组织结构)
	 * 
	 * @return
	 */
	public List<FuctionTreeNode> getPersonByDptTree(String nodeId,String hrefTarget,String href,String isPerson,String companyID);
	
	/**
	 * 根据部门编号查询角色(组织结构)
	 * 
	 * @return
	 */
	public List<FuctionTreeNode> getRoleByDptTree(String nodeId,String hrefTarget,String href,String isPerson,String companyID);
	/**
	 * 根据部门编号查询人员(组织结构)(没有角色)
	 * 
	 * @return
	 */
	public List<FuctionTreeNode> getPersonTree(String nodeId,String hrefTarget,String href,String isPerson,String companyID);
	
	/**
	 * 取所有银行卡名称
	 * 
	 * @return
	 */
	public List<BrankCardPo> getBankCardList();
		
	/**
	 * 查询客户的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getFranchiseeCount(DepartmentsPo po);
	
	/**
	 * 查询客户列表
	 * 
	 * @param po
	 * @return
	 */
	public List<DepartmentsPo> getFranchiseeList(DepartmentsPo po,int start,int size);	

	/**
	 * 插入客户
	 * 
	 * @param departmentsPo
	 */
	public void insertFranchisee(DepartmentsPo departmentsPo);

	/**
	 * 更新客户
	 * 
	 * @param departmentsPo
	 */
	public void updateFranchisee(DepartmentsPo departmentsPo);

	/**
	 * 删除客户
	 * 
	 * @param departmentID
	 */
	public void deleteFranchisee(String departmentID);	

	/**
	 * 取指定客户
	 * 
	 * @param departmentsPo
	 *            部门参数集
	 * @return
	 */
	public DepartmentsPo getFranchisee(DepartmentsPo departmentsPo);
	
	/**
	 * 为默认人员新增部门
	 * @param departmentsPo 部门对象
	 */
	public void insertPersonDepartment(DepartmentsPo departmentsPo);
	
	/**
	 * 删除部门设置的默认仓位
	 */
	public void deleteDefaultWarehouseByDpt(String departmentID);
	
	/**
	 * 删除部门设置的出仓仓位
	 */
	public void deleteOutWarehouseByDpt(String departmentID);
	
	/**
	 * 删除部门设置的退款仓位
	 */
	public void deleteInWarehouseByDpt(String departmentID);
	
	/**
	 * 删除部门下的所属仓位
	 */
	public void deleteWarehouseByDpt(String departmentID);
	
	/**
	 * 调拨查询页面使用
	 */
	public List<DepartmentsPo> getDepartmentsList(DepartmentsPo po);
	
	/**
	 * 取部门对应的配镜单模版
	 */
	public DepartmentsPo getBillTemplate(String departmentID);
	
	/**
	 * 更新部门对应的配镜单模版
	 */
	public void updateBillTemplate(DepartmentsPo po);
	
	/**
	 * 启用停用客户
	 */
	public void updateFranchiseeEnable(DepartmentsPo po);	
	
	public String getDepartmentByWarehouseID(String warehouseid);

	/**
	 * 根据部门ID查询相同公司的部门
	 */
	public List<DepartmentsPo> getDepartmentListByCompany(String departmentID);
	
	/**
	 * 根据部门ID查询其他公司的部门
	 */
	public List<DepartmentsPo> getDepartmentListByOtherCompany(String departmentID);
	
	/**
	 * 根据部门ID查询当前公司
	 */
	public CompanyNamePo getCompanyInfoByDpt(String departmentID);
	
	/**
	 * 查询当前会员卡号与部门是同属一个公司
	 */
	public int getCustomerCount(String memberID,String departmentID);

	/**
	 * 查询部门表所有信息(通过登录人员取出人员公司下的部门)
	 */
	public List<DepartmentsPo> getDepartments(PersonInfoPo po);
	
	/**
	 * 根据公司ID查询公司下的部门ID（报表使用）
	 */
	public List<DepartmentsPo> getDepartmentIDByCompanysID(DepartmentsPo po);
	
	/**
	 * 取得当前公司下的所有门店
	 * 
	 * @return
	 */
	public List<DepartmentsPo> getDepartmentsByCompanyID(DepartmentsPo po);
	
	public List<WarehousePo> getWarehouseByDptCompany(DepartmentsPo departmentsPo);
	
	/**
	 * 查询所有部门
	 */
	public List<DepartmentsPo> getDepartmentsInfo(DepartmentsPo po);
	
	/**
	 * 取总公司库房
	 */
	public List<DepartmentsPo> getParentCompanyDepartments(String flag);
	
	/**
	 * 获取部门类型
	 */
	public List<DepartmentTypePo> getDepartmentTypeList();
	
	/**
	 * 设置部门期初日期和上线日期
	 */
	public void updateDepartmentDate(DepartmentsPo po);
	
	/**
	 * 获取门店配置的HIS信息
	 */
	public DepartmentsPo getDepartmentSetHisInfo(String departmentID);
	
	/**
	 * 更新门店配置的HIS信息
	 */
	public void updateDepartmentSetHisInfo(DepartmentsPo po);
	
}
