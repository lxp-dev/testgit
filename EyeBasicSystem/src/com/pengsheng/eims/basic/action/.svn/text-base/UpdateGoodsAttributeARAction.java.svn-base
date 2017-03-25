package com.pengsheng.eims.basic.action;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.mgr.GlassesAccessoriesMgr;
import com.pengsheng.eims.basic.mgr.GlassesFrameMgr;
import com.pengsheng.eims.basic.mgr.LensFinishedMgr;
import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.mgr.OtherGoodsMgr;
import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.mgr.UpdateGoodsAttributeARMgr;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsLevelPo;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.basic.persistence.RefractiveSetPo;
import com.pengsheng.eims.basic.persistence.UnitPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.ProcurementOrdersMgr;
import com.pengsheng.eims.system.mgr.FrameMaterialMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.mgr.TeachnologyTypeMgr;
import com.pengsheng.eims.system.persistence.FrameMaterialPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.system.persistence.TeachnologyTypePo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

/**
 * 修改商品属性action
 */
public class UpdateGoodsAttributeARAction extends BaseAction {
	private BrandMgr brandMgr;
	private List<GoodsLevelPo> selectGoodsLevelList;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private List<RefractiveSetPo> refractiveSetList = null;
	private ProcurementOrdersMgr procurementOrdersMgr;
	private UpdateGoodsAttributeARMgr updateGoodsAttributeARMgr;
	private List<OptionParamPo> optionParamPolist;
	private OptionParamMgr optionParamMgr;
	
	public UpdateGoodsAttributeARMgr getUpdateGoodsAttributeARMgr() {
		return updateGoodsAttributeARMgr;
	}

	public void setUpdateGoodsAttributeARMgr(
			UpdateGoodsAttributeARMgr updateGoodsAttributeARMgr) {
		this.updateGoodsAttributeARMgr = updateGoodsAttributeARMgr;
	}

	public List<OptionParamPo> getOptionParamPolist() {
		return optionParamPolist;
	}

	public void setOptionParamPolist(List<OptionParamPo> optionParamPolist) {
		this.optionParamPolist = optionParamPolist;
	}

	public OptionParamMgr getOptionParamMgr() {
		return optionParamMgr;
	}

	public void setOptionParamMgr(OptionParamMgr optionParamMgr) {
		this.optionParamMgr = optionParamMgr;
	}

	public BrandMgr getBrandMgr() {
		return brandMgr;
	}

	public void setBrandMgr(BrandMgr brandMgr) {
		this.brandMgr = brandMgr;
	}

	public List<GoodsLevelPo> getSelectGoodsLevelList() {
		return selectGoodsLevelList;
	}

	public void setSelectGoodsLevelList(List<GoodsLevelPo> selectGoodsLevelList) {
		this.selectGoodsLevelList = selectGoodsLevelList;
	}

	public ProcurementOrdersMgr getProcurementOrdersMgr() {
		return procurementOrdersMgr;
	}

	public void setProcurementOrdersMgr(ProcurementOrdersMgr procurementOrdersMgr) {
		this.procurementOrdersMgr = procurementOrdersMgr;
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}

	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}

	private List<GoodsCategoryPo> goodsCategorys;
	
	public List<RefractiveSetPo> getRefractiveSetList() {
		return refractiveSetList;
	}

	public void setRefractiveSetList(List<RefractiveSetPo> refractiveSetList) {
		this.refractiveSetList = refractiveSetList;
	}

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}
	private List<FrameMaterialPo> frameMateriallist;
	private FrameMaterialMgr frameMaterialMgr;
	private TeachnologyTypeMgr teachnologyTypeMgr;

	private List<TeachnologyTypePo> teachnologyTypeList;
	public List<FrameMaterialPo> getFrameMateriallist() {
		return frameMateriallist;
	}

	public void setFrameMateriallist(List<FrameMaterialPo> frameMateriallist) {
		this.frameMateriallist = frameMateriallist;
	}

	public FrameMaterialMgr getFrameMaterialMgr() {
		return frameMaterialMgr;
	}

	public void setFrameMaterialMgr(FrameMaterialMgr frameMaterialMgr) {
		this.frameMaterialMgr = frameMaterialMgr;
	}

	public TeachnologyTypeMgr getTeachnologyTypeMgr() {
		return teachnologyTypeMgr;
	}

	public void setTeachnologyTypeMgr(TeachnologyTypeMgr teachnologyTypeMgr) {
		this.teachnologyTypeMgr = teachnologyTypeMgr;
	}

	public List<TeachnologyTypePo> getTeachnologyTypeList() {
		return teachnologyTypeList;
	}

	public void setTeachnologyTypeList(List<TeachnologyTypePo> teachnologyTypeList) {
		this.teachnologyTypeList = teachnologyTypeList;
	}

	private PersonPermissionMgr personPermissionMgr;

	private GlassesAccessoriesMgr glassesAccessoriesMgr;

	private GoodsInfoPo goodsInfoPo;

	private List<GoodsInfoPo> glassesAccessoriesList;

	private List<UnitPo> unitList;

	private UnitMgr unitMgr;
	
	private GlassesFrameMgr glassesFrameMgr;
	private SupplierMgr supplierMgr;	
	
	public SupplierMgr getSupplierMgr() {
		return supplierMgr;
	}
	public void setSupplierMgr(SupplierMgr supplierMgr) {
		this.supplierMgr = supplierMgr;
	}
	public GlassesFrameMgr getGlassesFrameMgr() {
		return glassesFrameMgr;
	}

	public void setGlassesFrameMgr(GlassesFrameMgr glassesFrameMgr) {
		this.glassesFrameMgr = glassesFrameMgr;
	}

	private OtherGoodsMgr otherGoodsMgr;
	private LensFinishedMgr lensFinishedMgr;
	
	public LensFinishedMgr getLensFinishedMgr() {
		return lensFinishedMgr;
	}

	public void setLensFinishedMgr(LensFinishedMgr lensFinishedMgr) {
		this.lensFinishedMgr = lensFinishedMgr;
	}

	public OtherGoodsMgr getOtherGoodsMgr() {
		return otherGoodsMgr;
	}

	public void setOtherGoodsMgr(OtherGoodsMgr otherGoodsMgr) {
		this.otherGoodsMgr = otherGoodsMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public GlassesAccessoriesMgr getGlassesAccessoriesMgr() {
		return glassesAccessoriesMgr;
	}

	public void setGlassesAccessoriesMgr(
			GlassesAccessoriesMgr glassesAccessoriesMgr) {
		this.glassesAccessoriesMgr = glassesAccessoriesMgr;
	}

	public GoodsInfoPo getGoodsInfoPo() {
		return goodsInfoPo;
	}

	public void setGoodsInfoPo(GoodsInfoPo goodsInfoPo) {
		this.goodsInfoPo = goodsInfoPo;
	}

	public List<GoodsInfoPo> getGlassesAccessoriesList() {
		return glassesAccessoriesList;
	}

	public void setGlassesAccessoriesList(
			List<GoodsInfoPo> glassesAccessoriesList) {
		this.glassesAccessoriesList = glassesAccessoriesList;
	}

	public List<UnitPo> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<UnitPo> unitList) {
		this.unitList = unitList;
	}

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}
	public String initUpdateGoodsAR(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		goodsInfoPo=new GoodsInfoPo();
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		unitList = unitMgr.getUnitList();//单位
		refractiveSetList = unitMgr.getRefractiveSetList();//折射率
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		teachnologyTypeList = teachnologyTypeMgr.getTeachnologyTypeList();
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}
	public String updateGoodsAttributeAR(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		goodsInfoPo=new GoodsInfoPo();
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		unitList = unitMgr.getUnitList();//单位
		refractiveSetList = unitMgr.getRefractiveSetList();//折射率
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		teachnologyTypeList = teachnologyTypeMgr.getTeachnologyTypeList();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		String goodscategoryID=request.getParameter("goodscategoryID");
		String[] goodsid=request.getParameter("updateGoodsID").split(",");
		String brandid=request.getParameter("brandID");//品种
		String supplerid=request.getParameter("supplierID");//系列
		String bgitaxrate="";
		String bgidefaultdiscountvalue="";
		String bgiunitid="";
		String bgibarcodeflag="";
		
		bgitaxrate=request.getParameter("bgitaxrate");//税率
		bgidefaultdiscountvalue=request.getParameter("bgidefaultdiscountvalue");//商品默认折扣率
		bgibarcodeflag=request.getParameter("bgibarcodeflag");//批号
		
		bgiunitid=request.getParameter("bgiunitid");//计量单位
		String bgiframeprocesscrafttype="";
		String bgiframematerialtype="";
		String bgiframesize="";
		String bgiframestyle="";
		if("1".equals(Utility.getName(goodscategoryID))){
			bgiframeprocesscrafttype=request.getParameter("bgiframeprocesscrafttype1");//工艺类型
			bgiframematerialtype=request.getParameter("bgiframematerialtype1");//镜架材质
			bgiframesize=request.getParameter("bgiframesize1");//镜架尺寸
			bgiframestyle=request.getParameter("bgiframestyle1");//镜架款式
		}
		
		String bgirefractive="";
		if("2".equals(Utility.getName(goodscategoryID))){
			bgirefractive=request.getParameter("bgirefractive2");//折射率
		}
		
		String bgieyeglassmaterialtype="";
		String bgiismutiluminosity="";
		String bgigradualclass="";
		String bgifunctionclass="";
		if("3".equals(Utility.getName(goodscategoryID))){
			bgieyeglassmaterialtype=request.getParameter("bgieyeglassmaterialtype3");//材料分类
			bgirefractive=request.getParameter("bgirefractive3");//折射率
			bgiismutiluminosity=request.getParameter("bgiismutiluminosity3");//光度分类
			bgigradualclass=request.getParameter("bgigradualclass3");//渐进分类
			bgifunctionclass=request.getParameter("bgifunctionclass3");// 镜片功能
		}
		
		String bgireturnmax="";
		String bgireturnmin="";
		String bgiusetype="";
		String bgistealthclass="";
		String bgidia="";
		String bgicurvature="";
		String bginumberofdays="";
		String bgicontacttype="";
		if("4".equals(Utility.getName(goodscategoryID))){
			bgireturnmax=request.getParameter("bgireturnmax4");//效期上线
			bgireturnmin=request.getParameter("bgireturnmin4");//效期下线
			bgiusetype=request.getParameter("bgiusetype4");//使用类型
			bgistealthclass=request.getParameter("bgistealthclass4");//抛弃类型
			bginumberofdays=request.getParameter("bginumberofdays4"); //产品可使用天数
			bgidia=request.getParameter("bgidia4");//直径
			bgicurvature=request.getParameter("bgicurvature4");//曲率
			bgicontacttype=request.getParameter("bgicontacttype4");//曲率
			goodsInfoPo.setBgicontacttype(Utility.getName(bgicontacttype));
		}
		
		String bgicapacity="";
		String bgicapacityentry="";
		if("5".equals(Utility.getName(goodscategoryID))){
			bgicapacity=request.getParameter("bgicapacity5");//主容量
			bgicapacityentry=request.getParameter("bgicapacityentry5");//次容量
			bgireturnmax=request.getParameter("bgireturnmax5");//效期上线
			bgireturnmin=request.getParameter("bgireturnmin5");//效期下线
		}
		
		if("6".equals(Utility.getName(goodscategoryID))){
			bgiframesize=request.getParameter("bgiframesize6");//镜架尺寸
			bgiframematerialtype=request.getParameter("bgiframematerialtype6");//功能
			bgiframestyle=request.getParameter("bgiframestyle6");//镜架款式
		}
		
		String bgiothergoodssmallclass="";
		String bgiothergoodsbigclass="";
		if("7".equals(Utility.getName(goodscategoryID))){
			bgiothergoodssmallclass=request.getParameter("bgiothergoodssmallclass7");//其他商品小类
			bgiothergoodsbigclass=request.getParameter("bgiothergoodsbigclass7");//其他商品大类
		}
		
		if("8".equals(Utility.getName(goodscategoryID))){
			bgiframesize=request.getParameter("bgiframesize8");
			bgiframestyle=request.getParameter("bgiframestyle8");//镜架款式
		}
		
		String bgiordercycle="";
		if("3D".equals(Utility.getName(goodscategoryID))){
			bgiordercycle=request.getParameter("bgiordercycle3D");//订货周期
			bgieyeglassmaterialtype=request.getParameter("bgieyeglassmaterialtype3");//材料分类
			bgirefractive=request.getParameter("bgirefractive3");//折射率
			bgiismutiluminosity=request.getParameter("bgiismutiluminosity3");//光度分类
			bgigradualclass=request.getParameter("bgigradualclass3");//渐进分类
			bgifunctionclass=request.getParameter("bgifunctionclass3");// 镜片功能
		}
		
		String bgicurvature1up="";
		String bgicurvature1ul="";
		String bgicurvature2up="";
		String bgicurvature2ul="";
		String bgidia1up="";
		String bgidia1ul="";
		if("4D".equals(Utility.getName(goodscategoryID))){
			bgireturnmax=request.getParameter("bgireturnmax4");//效期上线
			bgireturnmin=request.getParameter("bgireturnmin4");//效期下线
			bgiusetype=request.getParameter("bgiusetype4");//使用类型
			bgiordercycle=request.getParameter("bgiordercycle4D");//订货周期
			bgistealthclass=request.getParameter("bgistealthclass4D");//抛弃类型
			
			bginumberofdays=request.getParameter("bginumberofdays4D"); //产品可使用天数
			bgicurvature1up=request.getParameter("bgicurvature1up4D");//曲率1下限
			bgicurvature1ul=request.getParameter("bgicurvature1ul4D");//曲率1上限
			bgicurvature2up=request.getParameter("bgicurvature2up4D");//曲率1下限
			bgicurvature2ul=request.getParameter("bgicurvature2ul4D");//曲率1上限
			bgidia1up=request.getParameter("bgidia1up4D");//直径1下限
			bgidia1ul=request.getParameter("bgidia1ul4D");//直径1上限
			bgicontacttype=request.getParameter("bgicontacttype4D");//隐形类型
			goodsInfoPo.setBgicontacttypey(Utility.getName(bgicontacttype));
			goodsInfoPo.setBgistealthcustomizetype("2");
		}
		
		if("4R".equals(Utility.getName(goodscategoryID))){
			bgireturnmax=request.getParameter("bgireturnmax4");//效期上线
			bgireturnmin=request.getParameter("bgireturnmin4");//效期下线
			bgiusetype=request.getParameter("bgiusetype4");//使用类型
			bgiordercycle=request.getParameter("bgiordercycle4D");//订货周期
			bgistealthclass=request.getParameter("bgistealthclass4D");//抛弃类型
			
			bginumberofdays=request.getParameter("bginumberofdays4D"); //产品可使用天数
			bgicurvature1up=request.getParameter("bgicurvature1up4D");//曲率1下限
			bgicurvature1ul=request.getParameter("bgicurvature1ul4D");//曲率1上限
			bgicurvature2up=request.getParameter("bgicurvature2up4D");//曲率1下限
			bgicurvature2ul=request.getParameter("bgicurvature2ul4D");//曲率1上限
			bgidia1up=request.getParameter("bgidia1up4D");//直径1下限
			bgidia1ul=request.getParameter("bgidia1ul4D");//直径1上限
			bgicontacttype=request.getParameter("bgicontacttype4R");//隐形类型
			goodsInfoPo.setBgicontacttyped(Utility.getName(bgicontacttype));
			goodsInfoPo.setBgistealthcustomizetype("1");
		}
		
		goodsInfoPo.setBgicurvature1up(Utility.getName(bgicurvature1up));
		goodsInfoPo.setBgicurvature1ul(Utility.getName(bgicurvature1ul));
		goodsInfoPo.setBgicurvature2up(Utility.getName(bgicurvature2up));
		goodsInfoPo.setBgicurvature2ul(Utility.getName(bgicurvature2ul));
		goodsInfoPo.setBgidiaup(Utility.getName(bgidia1up));
		goodsInfoPo.setBgidiaul(Utility.getName(bgidia1ul));
		goodsInfoPo.setBgiordercycle(Utility.getName(bgiordercycle));
		goodsInfoPo.setBgiothergoodssmallclass(Utility.getName(bgiothergoodssmallclass));
		goodsInfoPo.setBgiothergoodsbigclass(Utility.getName(bgiothergoodsbigclass));
		goodsInfoPo.setBgicapacity(Utility.getName(bgicapacity));
		goodsInfoPo.setBgicapacityentry(Utility.getName(bgicapacityentry));
		goodsInfoPo.setBgireturnmax(Utility.getName(bgireturnmax));
		goodsInfoPo.setBgireturnmin(Utility.getName(bgireturnmin));
		goodsInfoPo.setBgiusetype(Utility.getName(bgiusetype));
		goodsInfoPo.setBgistealthclass(Utility.getName(bgistealthclass));
		goodsInfoPo.setBginumberofdays(Utility.getName(bginumberofdays));
		
		goodsInfoPo.setBgidia(Utility.getName(bgidia));
		goodsInfoPo.setBgicurvature1(Utility.getName(bgicurvature));
		goodsInfoPo.setBgieyeglassmaterialtype(Utility.getName(bgieyeglassmaterialtype));
		goodsInfoPo.setBgiismutiluminosity(Utility.getName(bgiismutiluminosity));
		goodsInfoPo.setBgigradualclass(Utility.getName(bgigradualclass));
		goodsInfoPo.setBgifunctionclass(Utility.getName(bgifunctionclass));
		goodsInfoPo.setBgirefractive(Utility.getName(bgirefractive));
		goodsInfoPo.setBgiframeprocesscrafttype(Utility.getName(bgiframeprocesscrafttype));
		goodsInfoPo.setBgiframematerialtype(Utility.getName(bgiframematerialtype));
		goodsInfoPo.setBgiframesize(Utility.getName(bgiframesize));
		goodsInfoPo.setBgitaxrate(Utility.getName(bgitaxrate));
		goodsInfoPo.setBgidefaultdiscountvalue(Utility.getName(bgidefaultdiscountvalue));
		goodsInfoPo.setBgibarcodeflag(Utility.getName(bgibarcodeflag));
		goodsInfoPo.setBgiunitid(Utility.getName(bgiunitid));
		goodsInfoPo.setBgibrandid(Utility.getName(brandid));
		goodsInfoPo.setBgisupplierid(Utility.getName(supplerid));
		goodsInfoPo.setBgigoodscategoryid(Utility.getName(goodscategoryID));
		goodsInfoPo.setBgiframestyle(Utility.getName(bgiframestyle));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("12");    // 退款
		logPo.setsLogContent("修改"+goodsid+" 商品属性");
		
		
		updateGoodsAttributeARMgr.updateGoodsAttribute(goodsInfoPo, goodsid,logPo);
		
		String url = "''initUpdateGoodsAR.action?moduleID={0}''"; 
		List<String> params = new ArrayList<String>(); 
		params.add(moduleID); 
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		
		this.clearMessages();
		this.addActionMessage(getText("修改成功!"));
		request.setAttribute("flag", GlobalConstants.INSERT);
		return SUCCESS;
	}
}
