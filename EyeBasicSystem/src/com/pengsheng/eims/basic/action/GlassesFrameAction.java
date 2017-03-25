package com.pengsheng.eims.basic.action;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.pengsheng.eims.basic.dao.impl.TechnologyTypePo;
import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.mgr.ColorMgr;
import com.pengsheng.eims.basic.mgr.GlassesFrameMgr;
import com.pengsheng.eims.basic.mgr.LensFinishedMgr;
import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.mgr.OtherGoodsMgr;
import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.persistence.ColorPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsLevelPo;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.basic.persistence.PhotoPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.basic.persistence.UnitPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
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
import com.pengsheng.eims.util.web.Pagination;

/**
 * 镜架类action
 */
public class GlassesFrameAction extends BaseAction {
	private BrandMgr brandMgr;
	private List<PhotoPo> photolist;	
	private List<GoodsInfoPo> photoslist;	
	private List<ColorPo> colorList;	
	private ColorMgr colorMgr;
	private List<TechnologyTypePo> teachnologyList;
	private List<FrameMaterialPo> frameMaterialList;
	private VarietyMgr varietyMgr;
	private List<GoodsLevelPo> selectGoodsLevelList;
	private List<OptionParamPo> optionParamPolist;
	private OptionParamMgr optionParamMgr;
	
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

	public VarietyMgr getVarietyMgr() {
		return varietyMgr;
	}

	public void setVarietyMgr(VarietyMgr varietyMgr) {
		this.varietyMgr = varietyMgr;
	}

	public List<TechnologyTypePo> getTeachnologyList() {
		return teachnologyList;
	}

	public void setTeachnologyList(List<TechnologyTypePo> teachnologyList) {
		this.teachnologyList = teachnologyList;
	}

	public List<FrameMaterialPo> getFrameMaterialList() {
		return frameMaterialList;
	}

	public void setFrameMaterialList(List<FrameMaterialPo> frameMaterialList) {
		this.frameMaterialList = frameMaterialList;
	}

	public List<ColorPo> getColorList() {
		return colorList;
	}

	public void setColorList(List<ColorPo> colorList) {
		this.colorList = colorList;
	}

	public List<GoodsInfoPo> getPhotoslist() {
		return photoslist;
	}

	public void setPhotoslist(List<GoodsInfoPo> photoslist) {
		this.photoslist = photoslist;
	}

	public List<PhotoPo> getPhotolist() {
		return photolist;
	}

	public void setPhotolist(List<PhotoPo> photolist) {
		this.photolist = photolist;
	}

	public ColorMgr getColorMgr() {
		return colorMgr;
	}

	public void setColorMgr(ColorMgr colorMgr) {
		this.colorMgr = colorMgr;
	}


	// 文件标题
	private String fileTitle;
	// 用File数组来封装多个上传文件域对象
	private File[] upload;
	// 用String数组来封装多个上传文件名
	private String[] uploadFileName;
	// 用String数组来封装多个上传文件类型
	private String[] uploadContentType;
	// 保存文件的目录路径(通过依赖注入)
	private String savePath;

	public String getFileTitle() {
		return fileTitle;
	}

	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getDelFileID() {
		return delFileID;
	}

	public void setDelFileID(String delFileID) {
		this.delFileID = delFileID;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}


	private String delFileID;

	private String fileName;

	private String contentType;

	private InputStream inputStream;
	
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
		
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


	private PersonPermissionMgr personPermissionMgr;

	private GlassesFrameMgr glassesFrameMgr;

	private GoodsInfoPo goodsInfoPo;

	private List<GoodsInfoPo> glassesFrameList;

	private List<FrameMaterialPo> frameMateriallist;
	private FrameMaterialMgr frameMaterialMgr;
	
	
	private List<UnitPo> unitList;
	


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


	private UnitMgr unitMgr;

	private TeachnologyTypeMgr teachnologyTypeMgr;

	private List<TeachnologyTypePo> teachnologyTypeList;
	
	private OtherGoodsMgr otherGoodsMgr;
	private LensFinishedMgr lensFinishedMgr;
	private SupplierMgr supplierMgr;	
	
	public SupplierMgr getSupplierMgr() {
		return supplierMgr;
	}
	public void setSupplierMgr(SupplierMgr supplierMgr) {
		this.supplierMgr = supplierMgr;
	}	
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

	public TeachnologyTypeMgr getTeachnologyTypeMgr() {
		return teachnologyTypeMgr;
	}

	public void setTeachnologyTypeMgr(TeachnologyTypeMgr teachnologyTypeMgr) {
		this.teachnologyTypeMgr = teachnologyTypeMgr;
	}

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}

	public List<UnitPo> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<UnitPo> unitList) {
		this.unitList = unitList;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public GlassesFrameMgr getGlassesFrameMgr() {
		return glassesFrameMgr;
	}

	public void setGlassesFrameMgr(GlassesFrameMgr glassesFrameMgr) {
		this.glassesFrameMgr = glassesFrameMgr;
	}

	public GoodsInfoPo getGoodsInfoPo() {
		return goodsInfoPo;
	}

	public void setGoodsInfoPo(GoodsInfoPo goodsInfoPo) {
		this.goodsInfoPo = goodsInfoPo;
	}

	public List<GoodsInfoPo> getGlassesFrameList() {
		return glassesFrameList;
	}

	public void setGlassesFrameList(List<GoodsInfoPo> glassesFrameList) {
		this.glassesFrameList = glassesFrameList;
	}

	/**
	 * 初始化镜架类查询
	 */
	public String initGlassesFrameSel() throws Exception {

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
			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
				this.setIsFirstExec("1");
				return "selGlassesFrame";
			}
			
		teachnologyList = varietyMgr.getTechnologyType();
		frameMaterialList = frameMaterialMgr.getFrameMaterialList();

		return SUCCESS;
	}

	/**
	 * 查询镜架类
	 */
	public String selGlassesFrame() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		if(!"".equals(Utility.getName(personInfoPo.getSyspsupplierid()))){
			supplierID = Utility.getName(personInfoPo.getSyspsupplierid());
			supplierName = Utility.getName(personInfoPo.getSyspsuppliername());
		}
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String bgiretailbeginprice=Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice=Utility.getName(request.getParameter("bgiretailendprice"));
		String isClosed=Utility.getName(request.getParameter("isClosed"));
		String bgicostbeginprice="";
		String bgicostendprice="";
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		
		String bgispecjj=Utility.getName(request.getParameter("bgispecjj"));
		String bgicolorjj=Utility.getName(request.getParameter("bgicolorjj"));
		String bgiframesizejj=Utility.getName(request.getParameter("bgiframesizejj"));
		String bgitechnologytypeid=Utility.getName(request.getParameter("bgitechnologytypeid"));
		String bgiframematerialtype=Utility.getName(request.getParameter("bgiframematerialtype"));
		String bgipayfeeid = Utility.getName(request.getParameter("bgipayfeeid"));
		String bgiissetflag = Utility.getName(request.getParameter("bgiissetflag"));

		request.setAttribute("bgispecjj", bgispecjj);
		request.setAttribute("bgicolorjj", bgicolorjj);
		request.setAttribute("bgiframesizejj",bgiframesizejj);
		request.setAttribute("bgitechnologytypeid", bgitechnologytypeid);
		request.setAttribute("bgiframematerialtype", bgiframematerialtype);
		request.setAttribute("bgipayfeeid", bgipayfeeid);
		request.setAttribute("bgiissetflag", bgiissetflag);
		
		goodsInfoPo = new GoodsInfoPo();

		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgiretailbeginprice(bgiretailbeginprice);
		goodsInfoPo.setBgiretailendprice(bgiretailendprice);
		goodsInfoPo.setBgiflag(isClosed);
		goodsInfoPo.setBgiwhichretail(whichretail);
		goodsInfoPo.setBgiismendretail(select_retail);
		
		goodsInfoPo.setBgispec(bgispecjj);
		goodsInfoPo.setBgicolor(bgicolorjj);
		goodsInfoPo.setBgiframesize(bgiframesizejj);		
		goodsInfoPo.setBgitechnologytypeid(bgitechnologytypeid);
		goodsInfoPo.setBgiframematerialtype(bgiframematerialtype);
		goodsInfoPo.setBgipayfeeid(bgipayfeeid);
		goodsInfoPo.setBgiissetflag(bgiissetflag);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1")){
			this.setIsFirstExec("0");
			request.setAttribute("showhider", (Utility.getName(systemParameterPo.getFspshowchange()).equals("3") ? "0" : "2"));
		}else{	
			String showchange = Utility.getName(systemParameterPo.getFspselectovershowchange());
			if (showchange.equals("0")){
				request.setAttribute("showhider","0");
			}else{
				request.setAttribute("showhider", "2");
			}
		}
		
		if("1".equals(permissionPo.getKeyf()))
		{
			bgicostbeginprice=Utility.getName(request.getParameter("bgicostbeginprice"));
			goodsInfoPo.setBgicostbeginprice(bgicostbeginprice);
			bgicostendprice=Utility.getName(request.getParameter("bgicostendprice"));
			goodsInfoPo.setBgicostendprice(bgicostendprice);
		}
		
		int count = glassesFrameMgr.getGlassesFrameCount(goodsInfoPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request
							.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, count, perPage);
			glassesFrameList = glassesFrameMgr.getGlassesFrameList(goodsInfoPo,
					page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			glassesFrameList = null;
		}

		request.setAttribute("goodsID", goodsID);
		request.setAttribute("isClosed", isClosed);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandName", brandName);
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);
		if("1".equals(permissionPo.getKeyf()))
		{
			request.setAttribute("bgicostbeginprice", bgicostbeginprice);
			request.setAttribute("bgicostendprice", bgicostendprice);
		}
		

		//加载树中制造商
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));

		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		if (goodsTree.equals("1")){
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName",Utility.getName(supplierPo.getBspsuppliername()));
		}
		
		teachnologyList = varietyMgr.getTechnologyType();
		frameMaterialList = frameMaterialMgr.getFrameMaterialList();
		
		//收费项目列表
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	/**
	 * 初始化镜架类新增
	 */
	public String initGlassesFrameInsert() throws Exception {

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

		goodsInfoPo = new GoodsInfoPo();
		unitList = unitMgr.getUnitList();
		colorList = colorMgr.getColorList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		teachnologyTypeList = teachnologyTypeMgr.getTeachnologyTypeList();

		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		if (goodsTree.equals("1"))
		{
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			goodsInfoPo.setBgisuppliername(Utility.getName(supplierPo.getBspsuppliername()));
		}		
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandname(brandName);
		goodsInfoPo.setBgibrandid(brandID);
		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	/**
	 * 新增镜架类
	 */
	public String insertGlassesFrame() throws Exception {
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
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();
		colorList = colorMgr.getColorList();
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("镜架:" + goodsInfoPo.getBgigoodsid() + "新增!");
		
		GoodsInfoPo po = glassesFrameMgr.getGlassesFrame(goodsInfoPo);
		GoodsInfoPo po1 = glassesFrameMgr.getGlassesFrameCode(goodsInfoPo);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String[] goodsnametype = systemParameterPo.getFspcjj().trim().split(",");
		String viewgoodsname = goodsInfoPo.getBgigoodsname();
		for(int i=0; i<goodsnametype.length; i++){
			if(goodsnametype[i].trim().equals("B_GI_SupplierSpec")){
				viewgoodsname = viewgoodsname + "-厂家型号:"+goodsInfoPo.getBgisupplierspec();
			} else if(goodsnametype[i].trim().equals("B_GI_Spec")){
				viewgoodsname = viewgoodsname + "-型号:"+goodsInfoPo.getBgispec();
			} else if(goodsnametype[i].trim().equals("B_GI_SupplierColor")){
				viewgoodsname = viewgoodsname + "-厂家色号:"+goodsInfoPo.getBgisuppliercolor();
			} else if(goodsnametype[i].trim().equals("B_GI_Color1")){
				viewgoodsname = viewgoodsname + "-色号:"+goodsInfoPo.getBgicolor();
			} else if(goodsnametype[i].trim().equals("B_GI_Color")){
				if(!"".equals(Utility.getName(goodsInfoPo.getBgichinesecolor()))){
					ColorPo tcolorPo = new ColorPo();
					tcolorPo.setBcid(goodsInfoPo.getBgichinesecolor().trim());
					ColorPo colorPo = colorMgr.getColor(tcolorPo);
					if(!"".equals(Utility.getName(colorPo.getBccolorname()))){
						viewgoodsname = viewgoodsname + "-颜色:"+colorPo.getBccolorname();
					}
				}
			}else if(goodsnametype[i].trim().equals("B_GI_FrameMaterialType")){
				FrameMaterialPo param = new FrameMaterialPo();
				param.setBfmid(goodsInfoPo.getBgiframematerialtype());
				if(!"".equals(Utility.getName(frameMaterialMgr.getFrameMaterialPo(param).getBfmname()))){
					viewgoodsname = viewgoodsname + "-材质:"+ frameMaterialMgr.getFrameMaterialPo(param).getBfmname();
				}
			}else if(goodsnametype[i].trim().equals("B_GI_Sph")){
				viewgoodsname = viewgoodsname + "-球镜:"+goodsInfoPo.getBgisph();
			} else if(goodsnametype[i].trim().equals("B_GI_Cyl")){
				viewgoodsname = viewgoodsname + "-柱镜:"+goodsInfoPo.getBgicyl();
			}else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
				viewgoodsname = viewgoodsname + "-标价:"+goodsInfoPo.getBgiretailprice();
			}else if(goodsnametype[i].trim().equals("B_GI_FrameSize")){
				viewgoodsname = viewgoodsname + "-尺寸："+goodsInfoPo.getBgiframesize();
			}
		}
		goodsInfoPo.setBgiviewgoodsname(viewgoodsname);
		
		request.setAttribute("defaultdiscountvalue", goodsInfoPo.getBgidefaultdiscountvalue());
		
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		if(!"".equals(Utility.getName(personInfoPo.getSyspsupplierid()))){
			goodsInfoPo.setBgisupplierid(Utility.getName(personInfoPo.getSyspsupplierid()));
			goodsInfoPo.setBgisuppliername(Utility.getName(personInfoPo.getSyspsuppliername()));
		}
		
		this.clearMessages();
		if (po.getBgigoodsid() == null) {
			if(po1.getBgigoodsbarcode()==null) {
				goodsInfoPo.setBgigoodscategoryid("1");
				goodsInfoPo.setBginottaxrate(getNottaxrate(goodsInfoPo.getBgicostprice(), goodsInfoPo.getBgitaxrate()));
				goodsInfoPo.setBgiflag("1");
				
				glassesFrameMgr.insertGlassesFrame(goodsInfoPo,logPo);				
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				if(goodsTree.equals("1")) {		
					request.setAttribute("flag", GlobalConstants.OPENUPDATE7);
					return "rtree";
				} else {
					request.setAttribute("goodsInfoPo", goodsInfoPo);
					unitList = unitMgr.getUnitList();
					teachnologyTypeList = teachnologyTypeMgr.getTeachnologyTypeList();		
					return SUCCESS;
				}
			} else {
				this.addActionMessage(getText("商品条码重复"));
				request.setAttribute("goodsInfoPo", goodsInfoPo);
				unitList = unitMgr.getUnitList();
				teachnologyTypeList = teachnologyTypeMgr.getTeachnologyTypeList();		
				request.setAttribute("parent", parent);
				request.setAttribute("goodsTree", goodsTree);
				return SUCCESS;
			}
		} else  {
			this.addActionMessage(getText("struts.messages.repeat"));
			request.setAttribute("goodsInfoPo", goodsInfoPo);
			unitList = unitMgr.getUnitList();
			teachnologyTypeList = teachnologyTypeMgr.getTeachnologyTypeList();	
			request.setAttribute("parent", parent);
			request.setAttribute("goodsTree", goodsTree);
			return SUCCESS;
		}
		
	}
	
	/**
	 * 初始化镜架类详细
	 */
	public String initGlassesFrameDetails() throws Exception {

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
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);

		goodsInfoPo = glassesFrameMgr.getGlassesFrame(goodsInfoPo);
		unitList = unitMgr.getUnitList();

		teachnologyTypeList = teachnologyTypeMgr.getTeachnologyTypeList();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	/**
	 * 初始化镜架类修改
	 */
	public String initGlassesFrameUpdate() throws Exception {

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

		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);

		goodsInfoPo = glassesFrameMgr.getGlassesFrame(goodsInfoPo);
		colorList = colorMgr.getColorList();
		unitList = unitMgr.getUnitList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		teachnologyTypeList = teachnologyTypeMgr.getTeachnologyTypeList();

		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	/**
	 * 修改镜架类
	 */
	public String updateGlassesFrame() throws Exception {
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
		GoodsInfoPo vgoodspo = glassesFrameMgr.getGlassesFrame(goodsInfoPo);
		String[] goodsnametype = systemParameterPo.getFspcjj().trim().split(",");
		String viewgoodsname = goodsInfoPo.getBgigoodsname();
		for(int i=0; i<goodsnametype.length; i++){
			if(goodsnametype[i].trim().equals("B_GI_SupplierSpec")){
				viewgoodsname = viewgoodsname + "-厂家型号:"+goodsInfoPo.getBgisupplierspec();
			} else if(goodsnametype[i].trim().equals("B_GI_Spec")){
				viewgoodsname = viewgoodsname + "-型号:"+goodsInfoPo.getBgispec();
			} else if(goodsnametype[i].trim().equals("B_GI_SupplierColor")){
				viewgoodsname = viewgoodsname + "-厂家色号:"+goodsInfoPo.getBgisuppliercolor();
			} else if(goodsnametype[i].trim().equals("B_GI_Color1")){
				viewgoodsname = viewgoodsname + "-色号:"+goodsInfoPo.getBgicolor();
			} else if(goodsnametype[i].trim().equals("B_GI_Color")){
				if(!"".equals(Utility.getName(goodsInfoPo.getBgichinesecolor()))){
					ColorPo tcolorPo = new ColorPo();
					tcolorPo.setBcid(goodsInfoPo.getBgichinesecolor().trim());
					ColorPo colorPo = colorMgr.getColor(tcolorPo);
					if(!"".equals(Utility.getName(colorPo.getBccolorname()))){
						viewgoodsname = viewgoodsname + "-颜色："+colorPo.getBccolorname();
					}
				}
			} else if(goodsnametype[i].trim().equals("B_GI_FrameMaterialType")){
				FrameMaterialPo param = new FrameMaterialPo();
				param.setBfmid(goodsInfoPo.getBgiframematerialtype());
				if(!"".equals(Utility.getName(frameMaterialMgr.getFrameMaterialPo(param).getBfmname()))){
					viewgoodsname = viewgoodsname + "-材质："+ frameMaterialMgr.getFrameMaterialPo(param).getBfmname();
				}
			} else if(goodsnametype[i].trim().equals("B_GI_Sph")){
				viewgoodsname = viewgoodsname + "-球镜："+vgoodspo.getBgisph();
			} else if(goodsnametype[i].trim().equals("B_GI_Cyl")){
				viewgoodsname = viewgoodsname + "-柱镜："+vgoodspo.getBgicyl();
			} else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
				viewgoodsname = viewgoodsname + "-标价："+goodsInfoPo.getBgiretailprice();
			} else if(goodsnametype[i].trim().equals("B_GI_FrameSize")){
				viewgoodsname = viewgoodsname + "-尺寸："+goodsInfoPo.getBgiframesize();
			}
		}
		goodsInfoPo.setBgiviewgoodsname(viewgoodsname);
		
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		colorList = colorMgr.getColorList();
		goodsInfoPo.setBginottaxrate(getNottaxrate(goodsInfoPo
				.getBgicostprice(), goodsInfoPo.getBgitaxrate()));
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("镜架:" + goodsInfoPo.getBgigoodsid() + "修改!");
		glassesFrameMgr.updateGlassesFrame(goodsInfoPo,logPo);
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		if(goodsTree.equals("1"))
		{
			if(parent.equals("1"))
			{
				request.setAttribute("flag", GlobalConstants.OPENUPDATE7);
			}else
			{
				request.setAttribute("flag", GlobalConstants.OPENUPDATE9);
			}
		}else
		{
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		}

		return SUCCESS;
	}
	

	/**
	 * 初始化镜架类图片修改
	 */
	public String initGlassesFramePhotoUpdate() throws Exception {

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

		String goodsid = Utility.getName(request.getParameter("goodsid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(goodsid);
		photolist = glassesFrameMgr.getPhotoList(goodsInfoPo);
		return SUCCESS;
	}
	
	/**
	 * 初始化镜架类图片预览
	 */
	public String initGlassesFramePhotoDetail() throws Exception {

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

		String goodsid = Utility.getName(request.getParameter("goodsid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(goodsid);
		photolist = glassesFrameMgr.getPhotoList(goodsInfoPo);
		return SUCCESS;
	}
	
	/**
	 * 初始化商品图片预览
	 */
	public String initPictureShowSel() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String goodsID = Utility.getName(request.getParameter("goodsID"));	
		String bgigoodscategoryid = Utility.getName(request.getParameter("bgigoodscategoryid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodscategoryid(bgigoodscategoryid);
		
		//图片总数
		int count =glassesFrameMgr.getPhotoListAllCount(goodsInfoPo);
		//分页
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request
							.getParameter("perPageNo")).intValue();
				} else {
					perPage = 10;
				}
			} else {
				perPage = 10;
			}
			Pagination page = new Pagination(request, count, perPage);
			//获取图片信息并分页
			photoslist = glassesFrameMgr.getPhotoListAll(goodsInfoPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}
		
		
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("bgigoodscategoryid", bgigoodscategoryid);
		return SUCCESS;
	}
	
	/**
	 * 初始化单个商品图片预览
	 */
	public String selPictureShow() throws Exception {

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

		String goodsid = Utility.getName(request.getParameter("goodsid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(goodsid);
		photolist = glassesFrameMgr.getPhotoList(goodsInfoPo);
		return SUCCESS;
	}
	
	/**
	 * 插入镜架类图片修改
	 */
	public String updateGlassesFramePhoto() throws Exception {

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
		
		glassesFrameMgr.insertGlassesFramePhoto(goodsInfoPo,upload,ServletActionContext.getServletContext().getRealPath(this.getSavePath()), this.getUploadFileName(), this.getUploadContentType());
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);	
		return SUCCESS;
	}

	/**
	 * 初始化图片删除
	 */
	public String initGlassesFramePhotoDelete() throws Exception {
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
		String deleteID = Utility.getName(request.getParameter("deleteID"));
		String actionUrl = Utility.getName(request.getParameter("actionUrl"));
		request.setAttribute("deleteID", deleteID);
		request.setAttribute("actionUrl", actionUrl);
				
		return SUCCESS;
	}

	/**
	 * 图片删除
	 */
	public String deleteGlassesFramePhoto() throws Exception {
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
		String deleteID = Utility.getName(request.getParameter("deleteID"));
		glassesFrameMgr.deleteGlassesFramePhoto(ServletActionContext.getServletContext().getRealPath(this.getSavePath()), deleteID);
		request.setAttribute("flag", GlobalConstants.REFRESH);
		return SUCCESS;
	}
	
	/**
	 * 初始化镜架类删除
	 */
	public String initGlassesFrameDelete() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);

		int num = otherGoodsMgr.getGoodsNumber(goodsInfoPo);
		request.setAttribute("num", num);
		
		goodsInfoPo = glassesFrameMgr.getGlassesFrame(goodsInfoPo);
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));

		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		return SUCCESS;
	}

	/**
	 * 删除镜架类
	 */
	public String deleteGlassesFrame() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("镜架:" + goodsInfoPo.getBgigoodsid() + "删除!");
		
		int flag = lensFinishedMgr.getGoodsCount(goodsInfoPo);
		this.clearMessages();
		if (flag == 0) {
			glassesFrameMgr.deleteGlassesFrame(goodsInfoPo,logPo);
			this.addActionMessage(getText("struts.messages.delete.sucess"));
			if(goodsTree.equals("1"))
			{
				if(parent.equals("1"))
				{
					request.setAttribute("flag", GlobalConstants.OPENUPDATE7);
				}else
				{
					request.setAttribute("flag", GlobalConstants.OPENUPDATE9);
				}
			}else
			{
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			}
			
		} else {
			this.addActionMessage(getText("存在商品库存或业务单据,删除失败!"));
			request.setAttribute("parent", parent);
			request.setAttribute("goodsTree", goodsTree);
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		}
		return SUCCESS;
	}

	/**
	 * 初始化镜架类停用
	 */
	public String initGlassesFrameDisable() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);

		goodsInfoPo = glassesFrameMgr.getGlassesFrame(goodsInfoPo);

		return SUCCESS;
	}

	/**
	 * 停用镜架类
	 */
	public String disableGlassesFrame() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);
		goodsInfoPo.setBgiflag("0");
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("39");    // 表示状态
		logPo.setsLogContent("镜架:" + goodsInfoPo.getBgigoodsid() + "停用!");
		glassesFrameMgr.updateGlassesFrameDisable(goodsInfoPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化镜架类启用
	 */
	public String initGlassesFrameAble() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);

		goodsInfoPo = glassesFrameMgr.getGlassesFrame(goodsInfoPo);

		return SUCCESS;
	}

	/**
	 * 启用镜架类
	 */
	public String ableGlassesFrame() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);
		goodsInfoPo.setBgiflag("1");
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("38");    // 表示状态
		logPo.setsLogContent("镜架:" + goodsInfoPo.getBgigoodsid() + "启用!");
		glassesFrameMgr.updateGlassesFrameDisable(goodsInfoPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 计算单位成本
	 */
	private String getNottaxrate(String costPrice, String taxRate) {

		BigDecimal nottaxrate = new BigDecimal("0");
		BigDecimal rate = new BigDecimal(taxRate).divide(new BigDecimal("100"),
				2, BigDecimal.ROUND_HALF_UP);
		rate = new BigDecimal("1").add(rate);
		nottaxrate = new BigDecimal(costPrice).divide(rate, 6,
				BigDecimal.ROUND_HALF_UP);

		return nottaxrate.toString();
	}

	/**
	 * 生成商品条码
	 */
	private String getGoodsbarcode(String goodsID) {

		String goodsbarcode = "";
		String[] goodsid = goodsID.split("\\.");
		for (int i = 0; i < goodsid.length; i++) {
			goodsbarcode = goodsbarcode + goodsid[i];
		}
		return goodsbarcode;
	}

	public List<TeachnologyTypePo> getTeachnologyTypeList() {
		return teachnologyTypeList;
	}

	public void setTeachnologyTypeList(
			List<TeachnologyTypePo> teachnologyTypeList) {
		this.teachnologyTypeList = teachnologyTypeList;
	}
	
	/**
	 * 初始化镜架类停用
	 */
	public String initDisableAllWhole() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);

		goodsInfoPo = glassesFrameMgr.getGlassesFrame(goodsInfoPo);

		return SUCCESS;
	}

	/**
	 * 停用镜架类
	 */
	public String disableAllWhole() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);
		goodsInfoPo.setBgiflag("0");
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("39");    // 表示状态
		logPo.setsLogContent(goodsInfoPo.getBgigoodsid() + "批发停用!");
		glassesFrameMgr.updateAllWholeDisable(goodsInfoPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化镜架类启用
	 */
	public String initAbleAllWhole() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);

		goodsInfoPo = glassesFrameMgr.getGlassesFrame(goodsInfoPo);

		return SUCCESS;
	}

	/**
	 * 启用镜架类
	 */
	public String ableAllWhole() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);
		goodsInfoPo.setBgiflag("1");
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("38");    // 表示状态
		logPo.setsLogContent(goodsInfoPo.getBgigoodsid() + "批发启用!");
		glassesFrameMgr.updateAllWholeDisable(goodsInfoPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	/**
	 * 初始化批量销售停用启用
	 */
	public String initGoodsSalesAbleBatch() throws Exception {
		
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
		
		String hid = Utility.getName(request.getParameter("hid"));
		String type = Utility.getName(request.getParameter("type"));
		
		request.setAttribute("hid",hid);
		request.setAttribute("type",type);
		
		return SUCCESS;
	}
	
	/**
	 * 批量销售停用启用
	 */
	public String updateGoodsSalesAbleBatch() throws Exception {
		
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
		
		String hid = Utility.getName(request.getParameter("hid"));
		String type = Utility.getName(request.getParameter("type"));

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("38");    // 表示状态
		logPo.setsLogContent("商品批量销售"+ (type.equals("1") ? "启用：" : "停用："));
		
		List<GoodsInfoPo> goodsInfoList = new ArrayList<GoodsInfoPo>();
		if (hid.indexOf(",") >= 0){
			int count = hid.split(",").length;
			String[] idArray = hid.split(",");
			
			for (int i = 0; i < count; i++){
				GoodsInfoPo gpo = new GoodsInfoPo();
				gpo.setBgigoodsid(idArray[i]);
				gpo.setBgiflag(type);
				
				goodsInfoList.add(gpo);
			}
			
		}

        if (goodsInfoList.size() > 0){
        	glassesFrameMgr.updateGlassesFrameDisableBatch(goodsInfoList,logPo);
        }	

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化批量批发价停用启用
	 */
	public String initGoodsWholePriceAbleBatch() throws Exception {
		
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
		
		String hid = Utility.getName(request.getParameter("hid"));
		String type = Utility.getName(request.getParameter("type"));
		
		request.setAttribute("hid",hid);
		request.setAttribute("type",type);
		
		return SUCCESS;
	}
	
	/**
	 * 批量批发价停用启用
	 */
	public String updateGoodsWholePriceAbleBatch() throws Exception {
		
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
				
		String hid = Utility.getName(request.getParameter("hid"));
		String type = Utility.getName(request.getParameter("type"));

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("38");    // 表示状态
		logPo.setsLogContent("商品批量批发价"+ (type.equals("1") ? "启用：" : "停用："));
		
		List<GoodsInfoPo> goodsInfoList = new ArrayList<GoodsInfoPo>();
		if (hid.indexOf(",") >= 0){
			int count = hid.split(",").length;
			String[] idArray = hid.split(",");
			
			for (int i = 0; i < count; i++){
				GoodsInfoPo gpo = new GoodsInfoPo();
				gpo.setBgigoodsid(idArray[i]);
				gpo.setBgiflag(type);
				
				goodsInfoList.add(gpo);
			}
			
		}

        if (goodsInfoList.size() > 0){
        	glassesFrameMgr.updateAllWholeDisableBatch(goodsInfoList,logPo);
        }	

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	/**
	 * 初始化批量删除
	 */
	public String initGoodsInfoDeleteBatch() throws Exception {
		
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
		
		String hid = Utility.getName(request.getParameter("hid"));
		
		request.setAttribute("hid",hid);
		
		return SUCCESS;
	}
	
	/**
	 * 批量删除
	 */
	public String deleteGoodsInfoBatch() throws Exception {
		
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
				
		String hid = Utility.getName(request.getParameter("hid"));

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("38");    // 表示状态
		logPo.setsLogContent("商品批量删除：");
		
		int count = 0;
		List<GoodsInfoPo> goodsInfoList = new ArrayList<GoodsInfoPo>();
		if (hid.indexOf(",") >= 0){
			count = hid.split(",").length;
			String[] idArray = hid.split(",");
			
			for (int i = 0; i < count; i++){
				GoodsInfoPo gpo = new GoodsInfoPo();
				gpo.setBgigoodsid(idArray[i]);
				
				int flag = lensFinishedMgr.getGoodsCount(gpo);
				if (flag == 0){
					goodsInfoList.add(gpo);
				}
				
			}
			
		}

        if (goodsInfoList.size() > 0){
        	glassesFrameMgr.deleteGlassesFrameBatch(goodsInfoList,logPo);
        }
        
        String msg = "";
        if (goodsInfoList.size() == 0){
        	msg = "商品删除失败!";
        }else if (goodsInfoList.size() == count){
        	msg = "商品删除成功!";
        }else{
        	msg = "部分商品删除失败!";
        }        

		this.clearMessages();
		this.addActionMessage(msg);
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
}
