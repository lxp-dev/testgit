package com.pengsheng.eims.basic.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsLevelPo;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.basic.persistence.RefractiveSetPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.basic.persistence.UnitPo;
import com.pengsheng.eims.basic.persistence.VarietyPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.FrameMaterialMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.mgr.TeachnologyTypeMgr;
import com.pengsheng.eims.system.persistence.FrameMaterialPo;
import com.pengsheng.eims.system.persistence.FuctionTreeNode;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.system.persistence.TeachnologyTypePo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

/**
 * 品种action1
 */
public class BrandAction extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;
	private List<GoodsLevelPo> selectGoodsLevelList;
	private BrandMgr brandMgr;
	private VarietyMgr varietyMgr;
	private List<BrandPo> brands;
	private List<GoodsCategoryPo> goodsCategorys;
	private BrandPo brandPo;
	private TeachnologyTypeMgr teachnologyTypeMgr;
	private List<TeachnologyTypePo> teachnologyTypeList;
	private List<FuctionTreeNode> menusList;
	private List<RefractiveSetPo> refractiveSetList = null;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private SupplierMgr supplierMgr;
	private FrameMaterialMgr frameMaterialMgr = null;	
	private List<FrameMaterialPo> frameMateriallist = null;
	private List<GoodsInfoPo> goodsInfoList;	
	
	private List<OptionParamPo> optionParamPolist;
	private OptionParamMgr optionParamMgr;
	
	public List<GoodsLevelPo> getSelectGoodsLevelList() {
		return selectGoodsLevelList;
	}

	public void setSelectGoodsLevelList(List<GoodsLevelPo> selectGoodsLevelList) {
		this.selectGoodsLevelList = selectGoodsLevelList;
	}

	public List<GoodsInfoPo> getGoodsInfoList() {
		return goodsInfoList;
	}

	public void setGoodsInfoList(List<GoodsInfoPo> goodsInfoList) {
		this.goodsInfoList = goodsInfoList;
	}

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

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public SupplierMgr getSupplierMgr() {
		return supplierMgr;
	}

	public void setSupplierMgr(SupplierMgr supplierMgr) {
		this.supplierMgr = supplierMgr;
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

	// 用File数组来封装多个上传文件域对象
	private File myFile;	
	// 用File数组来封装多个上传文件域对象
	private File[] upload;
	// 用String数组来封装多个上传文件类型
	private String[] uploadContentType;
	// 用String数组来封装多个上传文件名
	private String[] uploadFileName;
	// 保存文件的目录路径(通过依赖注入)
	private String savePath;
	// 文件标题
	private String fileName;
	// 文件类型
	private String contentType;
	private InputStream inputStream;
	private List<UnitPo> unitList;
	private UnitMgr unitMgr;
	
	
	public List<RefractiveSetPo> getRefractiveSetList() {
		return refractiveSetList;
	}

	public void setRefractiveSetList(List<RefractiveSetPo> refractiveSetList) {
		this.refractiveSetList = refractiveSetList;
	}

	public List<FuctionTreeNode> getMenusList() {
		return menusList;
	}

	public void setMenusList(List<FuctionTreeNode> menusList) {
		this.menusList = menusList;
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

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	// 对于配置中的 ${fileName}, 获得下载保存时的文件名
	public String getFileName() throws Exception {
		return new String(fileName.getBytes(), "ISO8859-1");
		// return fileName;
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

	// 获得下载文件的内容，可以直接读入一个物理文件或从数据库中获取内容
	public InputStream getInputStream() throws Exception {
		return inputStream;
	}

	public BrandMgr getBrandMgr() {
		return brandMgr;
	}

	public void setBrandMgr(BrandMgr brandMgr) {
		this.brandMgr = brandMgr;
	}

	public VarietyMgr getVarietyMgr() {
		return varietyMgr;
	}

	public void setVarietyMgr(VarietyMgr varietyMgr) {
		this.varietyMgr = varietyMgr;
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}

	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}

	public List<BrandPo> getBrands() {
		return brands;
	}

	public void setBrands(List<BrandPo> brands) {
		this.brands = brands;
	}

	public BrandPo getBrandPo() {
		return brandPo;
	}

	public void setBrandPo(BrandPo brandPo) {
		this.brandPo = brandPo;
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

	/**
	 * 查询页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initBrandSel() throws Exception {
		
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
		
		//获取商品类别
		goodsCategorys = brandMgr.getGoodsCategorys();
		
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
				
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selBrand";
		}

		return SUCCESS;
	}

	/**
	 * 查询页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selBrand() throws Exception {
		
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
		 
		BrandPo brandPo = new BrandPo();
		brandPo.setBbdid(request.getParameter("selbbdid"));
		brandPo.setBbdbrandname(request.getParameter("selbbdbrandname"));
		brandPo.setBspcategoryid(request.getParameter("selbspcategoryid"));
		
		brandPo.setBbdpayfeeid(request.getParameter("bbdpayfeeid"));
		brandPo.setBbdissetflag(Utility.getName(request.getParameter("bbdissetflag")));
		
		if(!"".equals(Utility.getName(personInfoPo.getSyspsupplierid()))){
			brandPo.setBspsuppliername(Utility.getName(personInfoPo.getSyspsuppliername()));
			brandPo.setBbdsupplierid(Utility.getName(personInfoPo.getSyspsupplierid()));
		}else{
			brandPo.setBspsuppliername(request.getParameter("selbspsuppliername"));
			brandPo.setBbdsupplierid(request.getParameter("selbbdsupplierid"));
		}
		
		brandPo.setBbdmnemoniccode(Utility.getName(request.getParameter("bbdmnemoniccode")));
		brandPo.setBbdsalesstatue(Utility.getName(request.getParameter("isClosed")));
		brandPo.setBbdsettlement(Utility.getName(request.getParameter("settlement")));
		
		request.setAttribute("settlement", Utility.getName(request.getParameter("settlement")));
		request.setAttribute("bbdpayfeeid", Utility.getName(request.getParameter("bbdpayfeeid")));
		request.setAttribute("bbdissetflag", Utility.getName(request.getParameter("bbdissetflag")));
		
		String goodsCategoryID = Utility.getName(request.getParameter("selbspcategoryid"));
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
		
		//获取品种总数
		int count = brandMgr.getBrandsCount(brandPo);
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
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, count, perPage);
			//获取品种信息并分页
			brands = brandMgr.getBrands(brandPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}
		//得到商品类型
		goodsCategorys = brandMgr.getGoodsCategorys();	
		
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		setRequest();
		String cateid= Utility.getName(request.getParameter("cateid"));
		
		if("".equals(cateid))
		{
			cateid=goodsCategoryID;
		}
		request.setAttribute("cateid", cateid);
		//加载树中制造商
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		request.setAttribute("goodsTree", goodsTree);
		String parent = Utility.getName(request.getParameter("parent"));
		request.setAttribute("parent", parent);
		if (goodsTree.equals("1")){
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(brandPo.getBbdsupplierid());
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("selbspsuppliername",Utility.getName(supplierPo.getBspsuppliername()));
		}
		
		return SUCCESS;
	}

	/**
	 * 新增页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initBrandInsert() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		String selbbdsupplierid = Utility.getName(request.getParameter("selbbdsupplierid"));
		String selbspcategoryid = Utility.getName(request.getParameter("selbspcategoryid"));
		String selbspsuppliername = Utility.getName(request.getParameter("selbspsuppliername"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		
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
		teachnologyTypeList = teachnologyTypeMgr.getTeachnologyTypeList();
		unitList = unitMgr.getUnitList();
		refractiveSetList = unitMgr.getRefractiveSetList();
		
		brandPo = new BrandPo();

		if(goodsTree.equals("1")){
			brandPo.setBspcategoryid(selbspcategoryid);
			brandPo.setBbdsupplierid(selbbdsupplierid);
			brandPo.setBspsuppliername(selbspsuppliername);
			request.setAttribute("goodsTree", "1");
		}
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();
		request.setAttribute("bspcategoryid",brandPo.getBspcategoryid());	
		
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		return SUCCESS;
	}

	/**
	 * 新增品种
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insertBrand() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
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
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		BrandPo temp = new BrandPo();
		temp.setBbdid(brandPo.getBbdid());
		temp.setBbdsupplierid(brandPo.getBbdsupplierid());
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("品种:" + temp.getBbdsupplierid()+"."+temp.getBbdid()+Utility.getName(brandPo.getBbdbrandname()) + "新增!");
		
		String bspcategoryid = Utility.getName(request.getParameter("bspcategoryid"));
		request.setAttribute("bspcategoryid",bspcategoryid);
		
		String registrationnum = "";		
		if (Utility.getName(brandPo.getBbdgoodscategory()).equals("4")){
			registrationnum = Utility.getName(request.getParameter("registrationnum"));
		}		
		if (Utility.getName(brandPo.getBbdgoodscategory()).equals("5")){
			registrationnum = Utility.getName(request.getParameter("registrationnum2"));
		}		
		brandPo.setBbdregistrationnum(registrationnum);   // 注册证号
		
		// 判断品种重复
		if (!"".equals(Utility.getName(brandMgr.getBrandPo(temp).getBbdid()))) {
			request.setAttribute("bspcategoryid", request.getParameter("bspcategoryid"));//获取制造商类别
			teachnologyTypeList = teachnologyTypeMgr.getTeachnologyTypeList();
			frameMateriallist = frameMaterialMgr.getFrameMaterialList();
			unitList = unitMgr.getUnitList();
			refractiveSetList = unitMgr.getRefractiveSetList();
			request.setAttribute("bbdgoodscategory",brandPo.getBbdgoodscategory());
			request.setAttribute("errormsg","品种代码已重复!");
			brandPo.setBspcategoryid(brandPo.getBbdgoodscategory());
			brandPo.setBbdunit(brandPo.getBbdunit());
			brandPo.setBbdframematerialtype(brandPo.getBbdframematerialtype());
			brandPo.setBbdusetype(brandPo.getBbdusetype());
			brandPo.setBbdstealthclass(brandPo.getBbdstealthclass());
			brandPo.setBbdmaterialclass(brandPo.getBbdmaterialclass());
			brandPo.setBbdrefractive(brandPo.getBbdrefractive());
			brandPo.setBbdluminosityclass(brandPo.getBbdluminosityclass());
			brandPo.setBbdgradualclass(brandPo.getBbdgradualclass());
			
			request.setAttribute("goodsTree",goodsTree);
			return "NoRepeat";
		}
		
		if(!"".equals(Utility.getName(personInfoPo.getSyspsupplierid()))){
			brandPo.setBspsuppliername(personInfoPo.getSyspsuppliername());
			brandPo.setBbdsupplierid(personInfoPo.getSyspsupplierid());
		}
		
		// 新增品种
		brandMgr.insertBrand(brandPo, createPerson, upload,ServletActionContext.getServletContext().getRealPath(this.getSavePath()), this.getUploadFileName(), this.getUploadContentType(),logPo);

		if(goodsTree.equals("1")){
			request.setAttribute("flag", GlobalConstants.OPENUPDATE7);
		}else{
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);		
		}		
		return SUCCESS;
	}

	/**
	* Description :查询某一品种的详细信息
	* @return :品种详情页面
	*/
	public String brandDetail() throws Exception {
		
		brandPo = new BrandPo();
		brandPo.setBbdid(Utility.getName(request.getParameter("hid")));
		brandPo.setBbdsupplierid(Utility.getName(request.getParameter("bbdsupplierid")));
		brandPo = brandMgr.getBrandPo(brandPo);

		/**
		 * 制造商PO
		 */
		SupplierPo supplierPo = new SupplierPo();
		supplierPo.setBspid(brandPo.getBbdsupplierid());

		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		brandPo.setBspsuppliername(brandMgr.getSupplier(supplierPo).getBspsuppliername());
		
		return SUCCESS;
	}
	
	/**
	* Description :下载品种logo
	* @return :下载弹窗
	*/
	public String downloadFile() throws Exception {

		brandPo = new BrandPo();
		brandPo.setBbdid(Utility.getName(request.getParameter("bbdid")));
		brandPo.setBbdsupplierid(Utility.getName(request.getParameter("bbdsupplierid")));
		brandPo = brandMgr.getBrandPo(brandPo);

		fileName = brandPo.getSaveFileName();

		this.contentType = brandPo.getContentType();

		inputStream = new FileInputStream(ServletActionContext.getServletContext().getRealPath(this.getSavePath()) + File.separator + brandPo.getDocumentUrl());

		// 和 Servlet 中不一样，这里我们不需对输出的中文转码为 ISO8859-1
		// inputStream = new ByteArrayInputStream("Struts2 文件下载测试".getBytes());

		return SUCCESS;
	}

	/**
	 * 更新品种初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initBrandUpdate() throws Exception {
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
		brandPo = new BrandPo();
		brandPo.setBbdid(request.getParameter("hid"));
		brandPo.setBbdsupplierid(request.getParameter("bbdsupplierid"));
		brandPo = brandMgr.getBrandPo(brandPo);

		/**
		 * 制造商PO
		 */
		SupplierPo supplierPo = new SupplierPo();
		supplierPo.setBspid(brandPo.getBbdsupplierid());

		brandPo.setBspsuppliername(brandMgr.getSupplier(supplierPo)
				.getBspsuppliername());

		File file = new File(ServletActionContext.getServletContext().getRealPath(this.getSavePath()) + File.separator + brandPo.getDocumentUrl());
		if (file.exists() && file.isFile()){
			brandPo.setDocumentUrl((this.getSavePath() + File.separator + brandPo.getDocumentUrl()).replace("\\", "/"));
		}else{
			brandPo.setDocumentUrl("");
		}
		
		unitList = unitMgr.getUnitList();
		refractiveSetList = unitMgr.getRefractiveSetList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		String parent = Utility.getName(request.getParameter("parent"));
		request.setAttribute("goodsTree", goodsTree);
		request.setAttribute("parent", parent);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp); 

		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		return SUCCESS;
	}

	/**
	 * 更新品种
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateBrand() throws Exception {
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("品种:" + brandPo.getBbdsupplierid()+"."+brandPo.getBbdid()+brandPo.getBbdbrandname() + "修改!");
		
		// 更新品种
		brandMgr.updateBrand(brandPo,logPo,systemParameterPo);

				
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		String parent = Utility.getName(request.getParameter("parent"));
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
	 * 刪除页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initBrandDelete() throws Exception {
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

		brandPo = new BrandPo();
		brandPo.setBbdid(request.getParameter("hid"));
		brandPo.setBbdsupplierid(request.getParameter("bbdsupplierid"));
		brandPo = brandMgr.getBrandPo(brandPo);
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		String parent = Utility.getName(request.getParameter("parent"));
		request.setAttribute("goodsTree", goodsTree);
		request.setAttribute("parent", parent);
		return SUCCESS;
	}

	/**
	 * 刪除品种
	 * 
	 * @return
	 * @throws Exception
	 */
	public String brandDelete() throws Exception {
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
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		String parent = Utility.getName(request.getParameter("parent"));
		VarietyPo varietyPo = new VarietyPo();
		varietyPo.setBvybrandid(request.getParameter("hid"));
		varietyPo.setBvysupplierid(request.getParameter("bvysupplierid"));

		// 判断品种已经使用
		if (!"".equals(Utility.getName(varietyMgr.getVarietyPo(varietyPo)
				.getBvybrandid()))) {

			this.clearMessages();
			this.addActionMessage(getText("data.have.been.used.remove.failed"));
			request.setAttribute("goodsTree", goodsTree);
			request.setAttribute("parent",parent );
			return "dataUsed";
		}

		// 删除品种
		BrandPo temp = new BrandPo();
		temp.setBbdid(Utility.getName(request.getParameter("hid")));
		temp.setBbdsupplierid(Utility.getName(request
				.getParameter("bvysupplierid")));
		brandPo=temp;
		int count=brandMgr.getGoodsCount(temp);
		if(count>0){
			
			this.clearMessages();
			this.addActionMessage(getText("data.have.been.used.remove.failed"));
			request.setAttribute("goodsTree", goodsTree);
			request.setAttribute("parent",parent );
			return "dataUsed";
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("品种:" + temp.getBbdsupplierid()+"."+temp.getBbdid() + "删除!");
		
		brandMgr.delBrand(temp,logPo);
		
		this.clearMessages();
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

		return SUCCESS;
	}

	/**
	 * 初始化品种停用
	 */
	public String initBrandEnbled() throws Exception {
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

		brandPo = new BrandPo();
		brandPo.setBbdid(request.getParameter("hid"));
		brandPo.setBbdsupplierid(request.getParameter("bbdsupplierid"));
		brandPo = brandMgr.getBrandPo(brandPo);

		String bbdsalesstatue = Utility.getName(request.getParameter("flag"));	
		request.setAttribute("bbdsalesstatue", bbdsalesstatue);
		
		return SUCCESS;
	}

	/**
	 * 停用品种
	 */
	public String brandEnbledUpdate() throws Exception {
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
		String bbdsupplierid = Utility.getName(request.getParameter("bbdsupplierid"));
		String bbdsalesstatue = Utility.getName(request.getParameter("bbdsalesstatue"));
		brandPo = new BrandPo();

		brandPo.setBbdid(id);
		brandPo.setBbdsupplierid(bbdsupplierid);
		brandPo.setBbdsalesstatue(bbdsalesstatue);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		if (bbdsalesstatue.equals("1")){
			logPo.setsLogOpID("38");    // 表示启用
			logPo.setsLogContent("品种:" + brandPo.getBbdsupplierid()+"."+brandPo.getBbdid() + "启用!");
		}else{
			logPo.setsLogOpID("39");    // 表示停用
			logPo.setsLogContent("品种:" + brandPo.getBbdsupplierid()+"."+brandPo.getBbdid() + "停用!");
		}		
		
		brandMgr.updateBrandEnbled(brandPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	private void setRequest() {
		request.setAttribute("selbbdid", request.getParameter("selbbdid"));
		request.setAttribute("selbbdbrandname", request
				.getParameter("selbbdbrandname"));
		request.setAttribute("selbspcategoryid", request
				.getParameter("selbspcategoryid"));
		request.setAttribute("selbbdsupplierid", request
				.getParameter("selbbdsupplierid"));
		request.setAttribute("selbspsuppliername", request
				.getParameter("selbspsuppliername"));
		request.setAttribute("bbdmnemoniccode", request
				.getParameter("bbdmnemoniccode"));
		
		request.setAttribute("isClosed", Utility.getName(request.getParameter("isClosed")));

	}

	/**
	 * 初始化批量导入
	 * 
	 * @return
	 */
	public String initBrandExcelInsert() {

		return SUCCESS;
	}

	public String insertBrandExcel() throws Exception {
		// 创建工作簿
		HSSFWorkbook wb = new HSSFWorkbook(
				new FileInputStream(this.getMyFile()));
		// 创建sheet页
		HSSFSheet sheet = wb.getSheetAt(0);
		// 创建行
		HSSFRow row = null;
		HSSFCell cell = null;

		List<BrandPo> brandExcel = new ArrayList<BrandPo>();

		int i = 0;
		//循环得出Excel数据
		while (true) {
			i++;

			brandPo = new BrandPo();

			row = sheet.getRow(i);

			if ("".equals(row.getCell(0).getStringCellValue())) {
				break;
			}

			brandPo.setBbdid(row.getCell(0).getStringCellValue());
			brandPo.setBbdbrandname(row.getCell(1).getStringCellValue());
			brandPo.setBbdsupplierid(row.getCell(2).getStringCellValue());
			
			brandExcel.add(brandPo);
		}
		//调用插入方法 
		brandMgr.insertBrandExcel(brandExcel);		

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.import.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	
	/**
	 * 初始化查询商品树
	 * @return
	 * @throws Exception
	 */
	public String initGoodsTree() throws Exception {
		
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

		return SUCCESS;
	}
	
	/**
	 * 查询商品树
	 * @return
	 * @throws Exception
	 */
	public String loadGoodsTree() throws Exception {
		
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String nodeId = Utility.getName(request.getParameter("pid"));		
		String hrefTarget = Utility.getName(request.getParameter("hrefTarget"));
		String isClosed = Utility.getName(request.getParameter("isClosed"));
		if("1".equals(systemParameterPo.getFspshowsupplier())){
			menusList = brandMgr.getGoodsTree(nodeId,hrefTarget,moduleID,isClosed,systemParameterPo.getFspshowsupplier());
		}else{
			menusList = brandMgr.getGoodsTreeNOSupplier(nodeId,hrefTarget,moduleID,isClosed,systemParameterPo.getFspshowsupplier());
		}
		return SUCCESS;
	}
	
	/**
	 * 查询商品树
	 * @return
	 * @throws Exception
	 */
	public String goodsTree() throws Exception {
		
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String hrefTarget = Utility.getName(request.getParameter("hrefTarget"));
		String isClosed = Utility.getName(request.getParameter("isClosed"));
		request.setAttribute("hrefTarget",hrefTarget);
		request.setAttribute("isClosed",isClosed);
		
		return SUCCESS;
	}
	
	/**
	 * 查询页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selBrandTree() throws Exception {
		
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

		BrandPo brandPo = new BrandPo();
		brandPo.setBbdid(request.getParameter("selbbdid"));
		brandPo.setBbdbrandname(request.getParameter("selbbdbrandname"));
		brandPo.setBspcategoryid(request.getParameter("selbspcategoryid"));
		brandPo.setBspsuppliername(request.getParameter("selbspsuppliername"));
		brandPo.setBbdsupplierid(request.getParameter("selbbdsupplierid"));
		brandPo.setBbdmnemoniccode(Utility.getName(request.getParameter("bbdmnemoniccode")));
		brandPo.setBbdsalesstatue(Utility.getName(request.getParameter("isClosed")));
		String goodsCategoryID = Utility.getName(request.getParameter("selbspcategoryid"));
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
		GoodsInfoPo goods=new GoodsInfoPo();
		goods.setBgisupplierid(request.getParameter("selbbdsupplierid"));
		goods.setBgibrandid(request.getParameter("selbbdid"));
		goods.setBgiiscustomize(request.getParameter("iscustomize"));
		request.setAttribute("iscustomize", request.getParameter("iscustomize"));
		//获取品种总数
		int count = brandMgr.getGoodsTreeCount(goods);
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
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, count, perPage);
			//获取品种信息并分页
			BrandPo brandPos = brandMgr.getBrandPo(brandPo);
			brands = brandMgr.getBrands(brandPo, 0,300);
			goodsInfoList=brandMgr.getGoodsTree(goods, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
			request.setAttribute("brandPos", brandPos);
		}
		//得到商品类型
		goodsCategorys = brandMgr.getGoodsCategorys();		
		setRequest();
		String cateid= Utility.getName(request.getParameter("cateid"));
		
		if("".equals(cateid))
		{
			cateid=goodsCategoryID;
		}
		request.setAttribute("cateid", cateid);
		//加载树中制造商
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		request.setAttribute("goodsTree", goodsTree);
		String parent = Utility.getName(request.getParameter("parent"));
		request.setAttribute("parent", parent);
		if (goodsTree.equals("1")){
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(brandPo.getBbdsupplierid());
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("selbspsuppliername",Utility.getName(supplierPo.getBspsuppliername()));
		}
		return SUCCESS;
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

}
