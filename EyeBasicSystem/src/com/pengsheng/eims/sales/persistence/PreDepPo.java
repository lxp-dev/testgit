package com.pengsheng.eims.sales.persistence;

/**
 * 预销售计划部门对象
 * @author ZK
 *
 */
public class PreDepPo {
	private String preDepId;//主键
	private String prePlanId;//对应预销售计划名称表主键
	private String prePlanDepId;//部门ID
	private String departmentName;//部门名称
	
	public String getPreDepId() {
		return preDepId;
	}
	public void setPreDepId(String preDepId) {
		this.preDepId = preDepId;
	}
	public String getPrePlanId() {
		return prePlanId;
	}
	public void setPrePlanId(String prePlanId) {
		this.prePlanId = prePlanId;
	}
	public String getPrePlanDepId() {
		return prePlanDepId;
	}
	public void setPrePlanDepId(String prePlanDepId) {
		this.prePlanDepId = prePlanDepId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
}
