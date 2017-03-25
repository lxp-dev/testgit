package com.pengsheng.eims.basic.action;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.mgr.ColorMgr;
import com.pengsheng.eims.basic.mgr.GlassesFrameManyMgr;
import com.pengsheng.eims.basic.mgr.GlassesFrameMgr;
import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.persistence.ColorPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoManyPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsLevelPo;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
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
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class GlassesFrameManyAction extends BaseAction{
	private File myFile;
	private File[] upload;
	private String[] uploadContentType;
	private String[] uploadFileName;
	private String savePath;
	private String fileName;
	private String contentType;
	private InputStream inputStream;
	
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private GoodsInfoPo goodsInfoPo;
	private List<UnitPo> unitList;
	private UnitMgr unitMgr;
	private List<ColorPo> colorList;
	private ColorMgr colorMgr;
	private List<FrameMaterialPo> frameMateriallist;
	private FrameMaterialMgr frameMaterialMgr;
	private List<TeachnologyTypePo> teachnologyTypeList;
	private TeachnologyTypeMgr teachnologyTypeMgr;
	private SupplierMgr supplierMgr;
	private List<GoodsLevelPo> selectGoodsLevelList;
	private BrandMgr brandMgr;
	private GlassesFrameManyMgr glassesFrameManyMgr;
	private List<GoodsInfoManyPo> goodsInfoManyPos;
	private GoodsInfoManyPo goodsInfoManyPo;
	private GlassesFrameMgr glassesFrameMgr;
	private List<GoodsInfoPo> goodsInfoPos;
	private List<OptionParamPo> optionParamPolist;
	private OptionParamMgr optionParamMgr;
	
	/**
	 * 初始化镜架类批量新增
	 */
	public String initGlassesFrameManyInsert() throws Exception {

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
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
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
		
		return SUCCESS;
	}
	
	/**
	 * 初始化太阳镜批量新增
	 */
	public String initGlassesFinishManyInsert() throws Exception {

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
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
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
		
		return SUCCESS;
	}
	
	/**
	 * 初始化老花镜批量新增
	 */
	public String initGlassesPresbyopicManyInsert() throws Exception {

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
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
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
		
		return SUCCESS;
	}
	
	/**
	 * 导入镜架类商品
	 * 
	 * @return
	 * @throws Exception
	 */
	public String importGlassesFrameManyExcel() throws Exception {
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
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		
		goodsInfoManyPos = glassesFrameManyMgr.insertImportGlassesFrameManyExcel(goodsInfoPo,upload,ServletActionContext.getServletContext().getRealPath(this.getSavePath()), this.getUploadFileName(), this.getUploadContentType(),logPo);
		
		String goodsid = "1";
		goodsid = goodsid+"."+goodsInfoPo.getBgisupplierid()+"."+goodsInfoPo.getBgibrandid()+".";
		
		String tempgoodsid = goodsid;
		
		String isinsert = "";
		goodsInfoPos = new ArrayList<GoodsInfoPo>();
		for(int i=0; i<goodsInfoManyPos.size(); i++){
			String spec = goodsInfoManyPos.get(i).getBgispec();
			String forspec = goodsInfoManyPos.get(i).getBgispec();
			int speclength = Utility.getName(goodsInfoManyPos.get(i).getBgispec()).length();
			String addzerospec = "";
			if(speclength < 9){
				for(int j=speclength; j<9; j++){
					addzerospec = addzerospec + "0";
				}
			}
			spec = addzerospec + spec;
			
			goodsid = goodsid+spec+".";
			
			String color = goodsInfoManyPos.get(i).getBgicolor();
			String forcolor = goodsInfoManyPos.get(i).getBgicolor();
			int colorlength = Utility.getName(goodsInfoManyPos.get(i).getBgicolor()).length();
			String addzerocolor = "";
			if(colorlength < 9){
				for(int j=colorlength; j<4; j++){
					addzerocolor = addzerocolor + "0";
				}
			}
			color = addzerocolor + color;
			
			goodsid = goodsid+color;
			
			for(int g=0; g<goodsInfoManyPos.size(); g++){
				if(Utility.getName(goodsInfoManyPos.get(g).getBgispec()).equals(forspec)&&Utility.getName(goodsInfoManyPos.get(g).getBgicolor()).equals(forcolor)&&g != i){
					goodsInfoManyPos.get(g).setBgiisinserted("1");
				}
			}
			
			goodsid = tempgoodsid;
		}
		
		unitList = unitMgr.getUnitList();
		colorList = colorMgr.getColorList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		teachnologyTypeList = teachnologyTypeMgr.getTeachnologyTypeList();
		
		List<OptionParamPo> frameStyleList1 = glassesFrameManyMgr.getFrameStyleList("ks");
		request.setAttribute("frameStyleList1", frameStyleList1);

		return SUCCESS;
	}
	
	/**
	 * 导入太阳镜类商品
	 * 
	 * @return
	 * @throws Exception
	 */
	public String importGlassesFinishManyExcel() throws Exception {
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
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		
		goodsInfoManyPos = glassesFrameManyMgr.insertImportGlassesFinishManyExcel(goodsInfoPo,upload,ServletActionContext.getServletContext().getRealPath(this.getSavePath()), this.getUploadFileName(), this.getUploadContentType(),logPo);
		
		String goodsid = "1";
		goodsid = goodsid+"."+goodsInfoPo.getBgisupplierid()+"."+goodsInfoPo.getBgibrandid()+".";
		
		String tempgoodsid = goodsid;
		
		String isinsert = "";
		goodsInfoPos = new ArrayList<GoodsInfoPo>();
		for(int i=0; i<goodsInfoManyPos.size(); i++){
			String spec = goodsInfoManyPos.get(i).getBgispec();
			String forspec = goodsInfoManyPos.get(i).getBgispec();
			int speclength = Utility.getName(goodsInfoManyPos.get(i).getBgispec()).length();
			String addzerospec = "";
			if(speclength < 9){
				for(int j=speclength; j<9; j++){
					addzerospec = addzerospec + "0";
				}
			}
			spec = addzerospec + spec;
			
			goodsid = goodsid+spec+".";
			
			String color = goodsInfoManyPos.get(i).getBgicolor();
			String forcolor = goodsInfoManyPos.get(i).getBgicolor();
			int colorlength = Utility.getName(goodsInfoManyPos.get(i).getBgicolor()).length();
			String addzerocolor = "";
			if(colorlength < 9){
				for(int j=colorlength; j<4; j++){
					addzerocolor = addzerocolor + "0";
				}
			}
			color = addzerocolor + color;
			
			goodsid = goodsid+color;
			
			for(int g=0; g<goodsInfoManyPos.size(); g++){
				if(Utility.getName(goodsInfoManyPos.get(g).getBgispec()).equals(forspec)&&Utility.getName(goodsInfoManyPos.get(g).getBgicolor()).equals(forcolor)&&g != i){
					goodsInfoManyPos.get(g).setBgiisinserted("1");
				}
			}
			
			goodsid = tempgoodsid;
		}
		
		unitList = unitMgr.getUnitList();
		colorList = colorMgr.getColorList();

		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		teachnologyTypeList = teachnologyTypeMgr.getTeachnologyTypeList();
		
		List<OptionParamPo> frameStyleList1 = glassesFrameManyMgr.getFrameStyleList("ks");
		request.setAttribute("frameStyleList1", frameStyleList1);
		
		return SUCCESS;
	}
	
	/**
	 * 导入老花镜类商品
	 * 
	 * @return
	 * @throws Exception
	 */
	public String importGlassesPresbyopicManyExcel() throws Exception {
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
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		
		goodsInfoManyPos = glassesFrameManyMgr.insertImportGlassesPresbyopicManyExcel(goodsInfoPo,upload,ServletActionContext.getServletContext().getRealPath(this.getSavePath()), this.getUploadFileName(), this.getUploadContentType(),logPo);
		
		String goodsid = "8";
		goodsid = goodsid+"."+goodsInfoPo.getBgisupplierid()+"."+goodsInfoPo.getBgibrandid()+".";
		
		String tempgoodsid = goodsid;
		
		String isinsert = "";
		goodsInfoPos = new ArrayList<GoodsInfoPo>();
		for(int i=0; i<goodsInfoManyPos.size(); i++){
			String spec = goodsInfoManyPos.get(i).getBgispec();
			String forspec = goodsInfoManyPos.get(i).getBgispec();
			int speclength = Utility.getName(goodsInfoManyPos.get(i).getBgispec()).length();
			String addzerospec = "";
			if(speclength < 9){
				for(int j=speclength; j<9; j++){
					addzerospec = addzerospec + "0";
				}
			}
			spec = addzerospec + spec;
			
			goodsid = goodsid+spec+".";
			
			String color = goodsInfoManyPos.get(i).getBgicolor();
			String forcolor = goodsInfoManyPos.get(i).getBgicolor();
			int colorlength = Utility.getName(goodsInfoManyPos.get(i).getBgicolor()).length();
			String addzerocolor = "";
			if(colorlength < 9){
				for(int j=colorlength; j<4; j++){
					addzerocolor = addzerocolor + "0";
				}
			}
			color = addzerocolor + color;
			
			goodsid = goodsid+color;
			
			for(int g=0; g<goodsInfoManyPos.size(); g++){
				if(Utility.getName(goodsInfoManyPos.get(g).getBgispec()).equals(forspec)&&Utility.getName(goodsInfoManyPos.get(g).getBgicolor()).equals(forcolor)&&g != i){
					goodsInfoManyPos.get(g).setBgiisinserted("1");
				}
			}
			
			goodsid = tempgoodsid;
		}
		
		unitList = unitMgr.getUnitList();
		colorList = colorMgr.getColorList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		teachnologyTypeList = teachnologyTypeMgr.getTeachnologyTypeList();
		
		List<OptionParamPo> frameStyleList1 = glassesFrameManyMgr.getFrameStyleList("ks");
		request.setAttribute("frameStyleList1", frameStyleList1);
		return SUCCESS;
	}
	
	/**
	 * 新增镜架类
	 */
	public String insertGlassesManyFrame() throws Exception {
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
		
		unitList = unitMgr.getUnitList();
		colorList = colorMgr.getColorList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		teachnologyTypeList = teachnologyTypeMgr.getTeachnologyTypeList();
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		if(!"".equals(Utility.getName(personInfoPo.getSyspsupplierid()))){
			goodsInfoPo.setBgisupplierid(Utility.getName(personInfoPo.getSyspsupplierid()));
			goodsInfoPo.setBgisuppliername(Utility.getName(personInfoPo.getSyspsuppliername()));
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("镜架:" + goodsInfoPo.getBgigoodsid() + "新增!");
		
		String goodsid = "1";
		goodsid = goodsid+"."+goodsInfoPo.getBgisupplierid()+"."+goodsInfoPo.getBgibrandid()+".";
		
		String tempgoodsid = goodsid;
		
		String isinsert = "";
		goodsInfoManyPos = new ArrayList<GoodsInfoManyPo>();
		goodsInfoPos = new ArrayList<GoodsInfoPo>();
		for(int i=0; i<goodsInfoManyPo.getBgisupplierspecs().length; i++){
			String spec = goodsInfoManyPo.getBgispecs()[i];
			int speclength = goodsInfoManyPo.getBgispecs()[i].length();
			String addzerospec = "";
			if(speclength < 9){
				for(int j=speclength; j<9; j++){
					addzerospec = addzerospec + "0";
				}
			}
			spec = addzerospec + spec;
			
			goodsid = goodsid+spec+".";
			
			String color = goodsInfoManyPo.getBgicolors()[i];
			int colorlength = goodsInfoManyPo.getBgicolors()[i].length();
			String addzerocolor = "";
			if(colorlength < 4){
				for(int j=colorlength; j<4; j++){
					addzerocolor = addzerocolor + "0";
				}
			}
			color = addzerocolor + color;
			
			goodsid = goodsid+color;
			
			GoodsInfoPo tpo = new GoodsInfoPo();
			tpo.setBgigoodsbarcode(goodsid.replace(".", ""));
			GoodsInfoPo checkpo = glassesFrameMgr.getGlassesFrameCode(tpo);
			
			String inserted = "";
			if(!"".equals(Utility.getName(checkpo.getBgigoodsbarcode()))){
				inserted = "1";
				isinsert = "1";
			}else{
				inserted = "0";
			}
			
			GoodsInfoManyPo mpo = new GoodsInfoManyPo();
			mpo.setBgisupplierspec(goodsInfoManyPo.getBgisupplierspecs()[i]);
			mpo.setBgispec(goodsInfoManyPo.getBgispecs()[i]);
			mpo.setBgisuppliercolor(goodsInfoManyPo.getBgisuppliercolors()[i]);				
			mpo.setBgicolor(goodsInfoManyPo.getBgicolors()[i]);	
			mpo.setBgiframematerialtype(goodsInfoManyPo.getBgiframematerialtypes()[i]);			
			mpo.setBgichinesecolor(goodsInfoManyPo.getBgichinesecolors()[i]);		
			mpo.setBgiframestyle(goodsInfoManyPo.getBgiframestyles()[i]);		
			mpo.setBgiframesize(goodsInfoManyPo.getBgiframesizes()[i]);
			mpo.setBgiframeprocesscrafttype(goodsInfoManyPo.getBgiframeprocesscrafttypes()[i]);
			mpo.setBgicostprice(goodsInfoManyPo.getBgicostprices()[i]);			
			mpo.setBgiretailprice(goodsInfoManyPo.getBgiretailprices()[i]);		
			mpo.setBgiwholesaleprice(goodsInfoManyPo.getBgiwholesaleprices()[i]);	
			mpo.setBgiisinserted(inserted);
			goodsInfoManyPos.add(mpo);
			
			GoodsInfoPo gpo = new GoodsInfoPo();
			gpo.setBgigoodsid(goodsid);
			gpo.setBgigoodsbarcode(goodsid.replace(".", ""));
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			String[] goodsnametype = systemParameterPo.getFspcjj().trim().split(",");
			String viewgoodsname = goodsInfoPo.getBgigoodsname();
			for(int k=0; k<goodsnametype.length; k++){
				if(goodsnametype[k].trim().equals("B_GI_SupplierSpec")){
					viewgoodsname = viewgoodsname + "-厂家型号:"+goodsInfoManyPo.getBgisupplierspecs()[i];
				} else if(goodsnametype[k].trim().equals("B_GI_Spec")){
					viewgoodsname = viewgoodsname + "-型号:"+goodsInfoManyPo.getBgispecs()[i];
				} else if(goodsnametype[k].trim().equals("B_GI_SupplierColor")){
					viewgoodsname = viewgoodsname + "-厂家色号:"+goodsInfoManyPo.getBgisuppliercolors()[i];
				} else if(goodsnametype[k].trim().equals("B_GI_Color1")){
					viewgoodsname = viewgoodsname + "-色号:"+goodsInfoManyPo.getBgicolors()[i];
				} else if(goodsnametype[k].trim().equals("B_GI_Color")){
					if(!"".equals(Utility.getName(goodsInfoManyPo.getBgichinesecolors()[i]))){
						ColorPo tcolorPo = new ColorPo();
						if(goodsInfoManyPo.getBgichinesecolors() != null){
							tcolorPo.setBccolorname(goodsInfoManyPo.getBgichinesecolors()[i].trim());
							ColorPo colorPo = colorMgr.getColor(tcolorPo);
							viewgoodsname = viewgoodsname + "-颜色："+colorPo.getBccolorname();
						}
					}
				}else if(goodsnametype[k].trim().equals("B_GI_FrameMaterialType")){
					FrameMaterialPo param = new FrameMaterialPo();
					if(goodsInfoManyPo.getBgiframematerialtypes() != null){
						param.setBfmname(goodsInfoManyPo.getBgiframematerialtypes()[i]);
						if(!"".equals(Utility.getName(frameMaterialMgr.getFrameMaterialPo(param).getBfmname()))){
							viewgoodsname = viewgoodsname + "-材质："+ frameMaterialMgr.getFrameMaterialPo(param).getBfmname();
						}
					}
				}else if(goodsnametype[k].trim().equals("B_GI_Sph")){
					viewgoodsname = viewgoodsname + "-球镜：";
				} else if(goodsnametype[k].trim().equals("B_GI_Cyl")){
					viewgoodsname = viewgoodsname + "-柱镜：";
				}else if(goodsnametype[k].trim().equals("B_GI_RetailPrice")){
					viewgoodsname = viewgoodsname + "-标价："+goodsInfoManyPo.getBgiretailprices()[i];
				}else if(goodsnametype[k].trim().equals("B_GI_FrameSize")){
					viewgoodsname = viewgoodsname + "-尺寸："+goodsInfoManyPo.getBgiframesizes()[i];
				}
			}
			
			gpo.setBgigoodsname(goodsInfoPo.getBgigoodsname());
			gpo.setBgiviewgoodsname(viewgoodsname);
			gpo.setBgigoodscategoryid("1");
			gpo.setBgisupplierid(goodsInfoPo.getBgisupplierid());
			gpo.setBgibrandid(goodsInfoPo.getBgibrandid());
			gpo.setBgispec(goodsInfoManyPo.getBgispecs()[i]);
			gpo.setBgiunitid(goodsInfoPo.getBgiunitid());
			gpo.setBgicolor(goodsInfoManyPo.getBgicolors()[i]);
			gpo.setBgicostprice(goodsInfoManyPo.getBgicostprices()[i]);
			gpo.setBgitaxrate(goodsInfoPo.getBgitaxrate());
			gpo.setBginottaxrate(getNottaxrate(goodsInfoManyPo.getBgicostprices()[i], goodsInfoPo.getBgitaxrate()));
			gpo.setBgiflag("1");
			gpo.setBgiretailprice(goodsInfoManyPo.getBgiretailprices()[i]);
			
			FrameMaterialPo frameMaterial = new FrameMaterialPo();
			frameMaterial.setBfmname(goodsInfoManyPo.getBgiframematerialtypes()[i].trim());
			FrameMaterialPo framepo = frameMaterialMgr.getFrameMaterialPo(frameMaterial);
			gpo.setBgiframematerialtype(framepo.getBfmid());
			
			gpo.setBgiwholesaleprice(goodsInfoManyPo.getBgiwholesaleprices()[i]);
			gpo.setBgiframesize(goodsInfoManyPo.getBgiframesizes()[i]);
			gpo.setBgisuppliercolor(goodsInfoManyPo.getBgisuppliercolors()[i]);
			
			ColorPo colorpo = new ColorPo();
			colorpo.setBccolorname(goodsInfoManyPo.getBgichinesecolors()[i].trim());
			ColorPo cpo = colorMgr.getColor(colorpo);
			gpo.setBgichinesecolor(cpo.getBcid());
			
			gpo.setBgisupplierspec(goodsInfoManyPo.getBgisupplierspecs()[i]);
			gpo.setBgiwholegoodsisable("1");
			
			ColorPo frameStyle = new ColorPo();
			frameStyle.setBfsname(goodsInfoManyPo.getBgiframestyles()[i].trim());
			ColorPo fpo = colorMgr.getFrameStyle(frameStyle);
			gpo.setBgiframestyle(fpo.getBfsid());
			gpo.setBgibrandyear(goodsInfoPo.getBgibrandyear());
			gpo.setBgiframeprocesscrafttype(goodsInfoPo.getBgiframeprocesscrafttype());
			
			TeachnologyTypePo teachnologyType = new TeachnologyTypePo();
			teachnologyType.setFttname(goodsInfoManyPo.getBgiframeprocesscrafttypes()[i].trim());
			TeachnologyTypePo tepo = teachnologyTypeMgr.getTeachnologyTypePo(teachnologyType);
			gpo.setBgiframeprocesscrafttype(tepo.getFttid());
			gpo.setBgibarcodeflag(goodsInfoPo.getBgibarcodeflag());   // 批次管理
			
			goodsInfoPos.add(gpo);
			
			goodsid = tempgoodsid;
		}
		
		if(!"1".equals(isinsert)) {
			glassesFrameManyMgr.insertGlassesManyFrame(goodsInfoPos,logPo);
			this.addActionMessage(getText("struts.messages.insert.sucess"));
		} else {
			this.addActionMessage(getText("商品条码重复"));
		}
		
		return SUCCESS;
	}
	
	/**
	 * 新增太阳镜类
	 */
	public String insertGlassesManyFinish() throws Exception {
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
		
		unitList = unitMgr.getUnitList();
		colorList = colorMgr.getColorList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		teachnologyTypeList = teachnologyTypeMgr.getTeachnologyTypeList();
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		if(!"".equals(Utility.getName(personInfoPo.getSyspsupplierid()))){
			goodsInfoPo.setBgisupplierid(Utility.getName(personInfoPo.getSyspsupplierid()));
			goodsInfoPo.setBgisuppliername(Utility.getName(personInfoPo.getSyspsuppliername()));
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("太阳镜:" + goodsInfoPo.getBgigoodsid() + "新增!");
		
		String goodsid = "6";
		goodsid = goodsid+"."+goodsInfoPo.getBgisupplierid()+"."+goodsInfoPo.getBgibrandid()+".";
		
		String tempgoodsid = goodsid;
		
		String isinsert = "";
		goodsInfoManyPos = new ArrayList<GoodsInfoManyPo>();
		goodsInfoPos = new ArrayList<GoodsInfoPo>();
		for(int i=0; i<goodsInfoManyPo.getBgisupplierspecs().length; i++){
			String spec = goodsInfoManyPo.getBgispecs()[i];
			int speclength = goodsInfoManyPo.getBgispecs()[i].length();
			String addzerospec = "";
			if(speclength < 9){
				for(int j=speclength; j<9; j++){
					addzerospec = addzerospec + "0";
				}
			}
			spec = addzerospec + spec;
			
			goodsid = goodsid+spec+".";
			
			String color = goodsInfoManyPo.getBgicolors()[i];
			int colorlength = goodsInfoManyPo.getBgicolors()[i].length();
			String addzerocolor = "";
			if(colorlength < 4){
				for(int j=colorlength; j<4; j++){
					addzerocolor = addzerocolor + "0";
				}
			}
			color = addzerocolor + color;
			
			goodsid = goodsid+color;
			
			GoodsInfoPo tpo = new GoodsInfoPo();
			tpo.setBgigoodsbarcode(goodsid.replace(".", ""));
			GoodsInfoPo checkpo = glassesFrameMgr.getGlassesFrameCode(tpo);
			
			String inserted = "";
			if(!"".equals(Utility.getName(checkpo.getBgigoodsbarcode()))){
				inserted = "1";
				isinsert = "1";
			}else{
				inserted = "0";
			}
			
			GoodsInfoManyPo mpo = new GoodsInfoManyPo();
			mpo.setBgisupplierspec(goodsInfoManyPo.getBgisupplierspecs()[i]);
			mpo.setBgispec(goodsInfoManyPo.getBgispecs()[i]);
			mpo.setBgisuppliercolor(goodsInfoManyPo.getBgisuppliercolors()[i]);				
			mpo.setBgicolor(goodsInfoManyPo.getBgicolors()[i]);	
			mpo.setBgiframestyle(goodsInfoManyPo.getBgiframestyles()[i]);		
			mpo.setBgiframesize(goodsInfoManyPo.getBgiframesizes()[i]);		
			mpo.setBgicostprice(goodsInfoManyPo.getBgicostprices()[i]);			
			mpo.setBgiretailprice(goodsInfoManyPo.getBgiretailprices()[i]);		
			mpo.setBgiwholesaleprice(goodsInfoManyPo.getBgiwholesaleprices()[i]);	
			mpo.setBgiisinserted(inserted);
			goodsInfoManyPos.add(mpo);
			
			GoodsInfoPo gpo = new GoodsInfoPo();
			gpo.setBgigoodsid(goodsid);
			gpo.setBgigoodsbarcode(goodsid.replace(".", ""));
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			String[] goodsnametype = systemParameterPo.getFspcjj().trim().split(",");
			String viewgoodsname = goodsInfoPo.getBgigoodsname();
			for(int k=0; k<goodsnametype.length; k++){
				if(goodsnametype[k].trim().equals("B_GI_SupplierSpec")){
					viewgoodsname = viewgoodsname + "-厂家型号:"+goodsInfoManyPo.getBgisupplierspecs()[i];
				} else if(goodsnametype[k].trim().equals("B_GI_Spec")){
					viewgoodsname = viewgoodsname + "-型号:"+goodsInfoManyPo.getBgispecs()[i];
				} else if(goodsnametype[k].trim().equals("B_GI_SupplierColor")){
					viewgoodsname = viewgoodsname + "-厂家色号:"+goodsInfoManyPo.getBgisuppliercolors()[i];
				} else if(goodsnametype[k].trim().equals("B_GI_Color1")){
					viewgoodsname = viewgoodsname + "-色号:"+goodsInfoManyPo.getBgicolors()[i];
				} else if(goodsnametype[k].trim().equals("B_GI_Color")){
					if(!"".equals(Utility.getName(goodsInfoManyPo.getBgichinesecolors()[i]))){
						ColorPo tcolorPo = new ColorPo();
						tcolorPo.setBccolorname(goodsInfoManyPo.getBgichinesecolors()[i].trim());
						ColorPo colorPo = colorMgr.getColor(tcolorPo);
						if(!"".equals(Utility.getName(colorPo.getBccolorname()))){
							viewgoodsname = viewgoodsname + "-颜色："+colorPo.getBccolorname();
						}
					}
				}else if(goodsnametype[k].trim().equals("B_GI_FrameMaterialType")){
					FrameMaterialPo param = new FrameMaterialPo();
					if(goodsInfoManyPo.getBgiframematerialtypes() != null){
						param.setBfmname(goodsInfoManyPo.getBgiframematerialtypes()[i]);
						if(!"".equals(Utility.getName(frameMaterialMgr.getFrameMaterialPo(param).getBfmname()))){
							viewgoodsname = viewgoodsname + "-材质："+ frameMaterialMgr.getFrameMaterialPo(param).getBfmname();
						}
					}
				}else if(goodsnametype[k].trim().equals("B_GI_Sph")){
					viewgoodsname = viewgoodsname + "-球镜：";
				} else if(goodsnametype[k].trim().equals("B_GI_Cyl")){
					viewgoodsname = viewgoodsname + "-柱镜：";
				}else if(goodsnametype[k].trim().equals("B_GI_RetailPrice")){
					viewgoodsname = viewgoodsname + "-标价："+goodsInfoManyPo.getBgiretailprices()[i];
				}else if(goodsnametype[k].trim().equals("B_GI_FrameSize")){
					viewgoodsname = viewgoodsname + "-尺寸："+goodsInfoManyPo.getBgiframesizes()[i];
				}
			}
			
			gpo.setBgigoodsname(goodsInfoPo.getBgigoodsname());
			gpo.setBgiviewgoodsname(viewgoodsname);
			gpo.setBgigoodscategoryid("6");
			gpo.setBgisupplierid(goodsInfoPo.getBgisupplierid());
			gpo.setBgibrandid(goodsInfoPo.getBgibrandid());
			gpo.setBgispec(goodsInfoManyPo.getBgispecs()[i]);
			gpo.setBgiunitid(goodsInfoPo.getBgiunitid());
			gpo.setBgicolor(goodsInfoManyPo.getBgicolors()[i]);
			gpo.setBgicostprice(goodsInfoManyPo.getBgicostprices()[i]);
			gpo.setBgitaxrate(goodsInfoPo.getBgitaxrate());
			gpo.setBginottaxrate(getNottaxrate(goodsInfoManyPo.getBgicostprices()[i], goodsInfoPo.getBgitaxrate()));
			gpo.setBgiflag("1");
			gpo.setBgiretailprice(goodsInfoManyPo.getBgiretailprices()[i]);
			
			gpo.setBgiwholesaleprice(goodsInfoManyPo.getBgiwholesaleprices()[i]);
			gpo.setBgiframesize(goodsInfoManyPo.getBgiframesizes()[i]);
			gpo.setBgisuppliercolor(goodsInfoManyPo.getBgisuppliercolors()[i]);
			
			ColorPo colorpo = new ColorPo();
			colorpo.setBccolorname(goodsInfoManyPo.getBgichinesecolors()[i].trim());
			ColorPo cpo = colorMgr.getColor(colorpo);
			gpo.setBgichinesecolor(cpo.getBcid());
			
			gpo.setBgisupplierspec(goodsInfoManyPo.getBgisupplierspecs()[i]);
			gpo.setBgiwholegoodsisable("1");
			
			ColorPo frameStyle = new ColorPo();
			frameStyle.setBfsname(goodsInfoManyPo.getBgiframestyles()[i].trim());
			ColorPo fpo = colorMgr.getFrameStyle(frameStyle);
			gpo.setBgiframestyle(fpo.getBfsid());
			gpo.setBgibrandyear(goodsInfoPo.getBgibrandyear());
			gpo.setBgiframeprocesscrafttype(goodsInfoPo.getBgiframeprocesscrafttype());
			gpo.setBgiframematerialtype(goodsInfoPo.getBgiframematerialtype());
			gpo.setBgibarcodeflag(goodsInfoPo.getBgibarcodeflag());   // 批次管理
			gpo.setBgipayfeeid(goodsInfoPo.getBgipayfeeid());
			
			goodsInfoPos.add(gpo);
			
			goodsid = tempgoodsid;
		}
		
		if(!"1".equals(isinsert)) {
			glassesFrameManyMgr.insertGlassesFinishFrame(goodsInfoPos,logPo);
			this.addActionMessage(getText("struts.messages.insert.sucess"));
		} else {
			this.addActionMessage(getText("商品条码重复"));
		}
		
		return SUCCESS;
	}
	
	/**
	 * 新增太阳镜类
	 */
	public String insertGlassesManyPresbyopic() throws Exception {
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
		
		unitList = unitMgr.getUnitList();
		colorList = colorMgr.getColorList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		teachnologyTypeList = teachnologyTypeMgr.getTeachnologyTypeList();
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		if(!"".equals(Utility.getName(personInfoPo.getSyspsupplierid()))){
			goodsInfoPo.setBgisupplierid(Utility.getName(personInfoPo.getSyspsupplierid()));
			goodsInfoPo.setBgisuppliername(Utility.getName(personInfoPo.getSyspsuppliername()));
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("8");    // 表示状态
		logPo.setsLogContent("老花镜:" + goodsInfoPo.getBgigoodsid() + "新增!");
		
		String goodsid = "8";
		goodsid = goodsid+"."+goodsInfoPo.getBgisupplierid()+"."+goodsInfoPo.getBgibrandid()+".";
		
		String tempgoodsid = goodsid;
		
		String isinsert = "";
		goodsInfoManyPos = new ArrayList<GoodsInfoManyPo>();
		goodsInfoPos = new ArrayList<GoodsInfoPo>();
		for(int i=0; i<goodsInfoManyPo.getBgisupplierspecs().length; i++){
			String spec = goodsInfoManyPo.getBgispecs()[i];
			int speclength = goodsInfoManyPo.getBgispecs()[i].length();
			String addzerospec = "";
			if(speclength < 9){
				for(int j=speclength; j<9; j++){
					addzerospec = addzerospec + "0";
				}
			}
			spec = addzerospec + spec;
			
			goodsid = goodsid+spec+".";
			
			String color = goodsInfoManyPo.getBgicolors()[i];
			color = (int)(Double.parseDouble(color)*100)+"";
			int colorlength = color.length();
			String addzerocolor = "";
			if(colorlength < 4){
				for(int j=colorlength; j<4; j++){
					addzerocolor = addzerocolor + "0";
				}
			}
			color = addzerocolor + color;
			
			goodsid = goodsid+color;
			
			GoodsInfoPo tpo = new GoodsInfoPo();
			tpo.setBgigoodsbarcode(goodsid.replace(".", ""));
			GoodsInfoPo checkpo = glassesFrameMgr.getGlassesFrameCode(tpo);
			
			String inserted = "";
			if(!"".equals(Utility.getName(checkpo.getBgigoodsbarcode()))){
				inserted = "1";
				isinsert = "1";
			}else{
				inserted = "0";
			}
			
			GoodsInfoManyPo mpo = new GoodsInfoManyPo();
			mpo.setBgisupplierspec(goodsInfoManyPo.getBgisupplierspecs()[i]);
			mpo.setBgispec(goodsInfoManyPo.getBgispecs()[i]);
			mpo.setBgisuppliercolor(goodsInfoManyPo.getBgisuppliercolors()[i]);				
			mpo.setBgicolor(goodsInfoManyPo.getBgicolors()[i]);	
			mpo.setBgichinesecolor(goodsInfoManyPo.getBgichinesecolors()[i]);		
			mpo.setBgiframestyle(goodsInfoManyPo.getBgiframestyles()[i]);		
			mpo.setBgiframesize(goodsInfoManyPo.getBgiframesizes()[i]);		
			mpo.setBgicostprice(goodsInfoManyPo.getBgicostprices()[i]);			
			mpo.setBgiretailprice(goodsInfoManyPo.getBgiretailprices()[i]);		
			mpo.setBgiwholesaleprice(goodsInfoManyPo.getBgiwholesaleprices()[i]);	
			mpo.setBgiisinserted(inserted);
			goodsInfoManyPos.add(mpo);
			
			GoodsInfoPo gpo = new GoodsInfoPo();
			gpo.setBgigoodsid(goodsid);
			gpo.setBgigoodsbarcode(goodsid.replace(".", ""));
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			String[] goodsnametype = systemParameterPo.getFspcjj().trim().split(",");
			String viewgoodsname = goodsInfoPo.getBgigoodsname();
			for(int k=0; k<goodsnametype.length; k++){
				if(goodsnametype[k].trim().equals("B_GI_Spec")){
					viewgoodsname = viewgoodsname + "-型号："+goodsInfoManyPo.getBgispecs()[i];
				} else if(goodsnametype[k].trim().equals("B_GI_Color")){
					if(!"".equals(Utility.getName(goodsInfoManyPo.getBgichinesecolors()[i]))){
						ColorPo tcolorPo = new ColorPo();
						if(goodsInfoManyPo.getBgichinesecolors() != null){
							tcolorPo.setBccolorname(goodsInfoManyPo.getBgichinesecolors()[i].trim());
							ColorPo colorPo = colorMgr.getColor(tcolorPo);
							viewgoodsname = viewgoodsname + "-颜色："+colorPo.getBccolorname();
						}
					}
				}else if(goodsnametype[k].trim().equals("B_GI_FrameMaterialType")){
					FrameMaterialPo param = new FrameMaterialPo();
					if(goodsInfoManyPo.getBgiframematerialtypes() != null){
						if(!"".equals(Utility.getName(frameMaterialMgr.getFrameMaterialPo(param).getBfmname()))){
							param.setBfmname(goodsInfoManyPo.getBgiframematerialtypes()[i]);
							viewgoodsname = viewgoodsname + "-材质："+ frameMaterialMgr.getFrameMaterialPo(param).getBfmname();
						}
					}
				}else if(goodsnametype[k].trim().equals("B_GI_Sph")){
					viewgoodsname = viewgoodsname + "-球镜：";
				} else if(goodsnametype[k].trim().equals("B_GI_Cyl")){
					viewgoodsname = viewgoodsname + "-柱镜：";
				}else if(goodsnametype[k].trim().equals("B_GI_RetailPrice")){
					viewgoodsname = viewgoodsname + "-标价："+goodsInfoManyPo.getBgiretailprices()[i];
				}else if(goodsnametype[k].trim().equals("B_GI_FrameSize")){
					viewgoodsname = viewgoodsname + "-尺寸："+goodsInfoManyPo.getBgiframesizes()[i];
				}
			}
			
			gpo.setBgigoodsname(goodsInfoPo.getBgigoodsname());
			gpo.setBgiviewgoodsname(viewgoodsname);
			gpo.setBgigoodscategoryid("8");
			gpo.setBgisupplierid(goodsInfoPo.getBgisupplierid());
			gpo.setBgibrandid(goodsInfoPo.getBgibrandid());
			gpo.setBgispec(goodsInfoManyPo.getBgispecs()[i]);
			gpo.setBgiunitid(goodsInfoPo.getBgiunitid());
			gpo.setBgisph(goodsInfoManyPo.getBgicolors()[i]);
			gpo.setBgicostprice(goodsInfoManyPo.getBgicostprices()[i]);
			gpo.setBgitaxrate(goodsInfoPo.getBgitaxrate());
			gpo.setBginottaxrate(getNottaxrate(goodsInfoManyPo.getBgicostprices()[i], goodsInfoPo.getBgitaxrate()));
			gpo.setBgiflag("1");
			gpo.setBgiretailprice(goodsInfoManyPo.getBgiretailprices()[i]);
			
			gpo.setBgiwholesaleprice(goodsInfoManyPo.getBgiwholesaleprices()[i]);
			gpo.setBgiframesize(goodsInfoManyPo.getBgiframesizes()[i]);
			gpo.setBgisuppliercolor(goodsInfoManyPo.getBgisuppliercolors()[i]);
			
			ColorPo colorpo = new ColorPo();
			colorpo.setBccolorname(goodsInfoManyPo.getBgichinesecolors()[i].trim());
			ColorPo cpo = colorMgr.getColor(colorpo);
			gpo.setBgichinesecolor(cpo.getBcid());
			
			gpo.setBgisupplierspec(goodsInfoManyPo.getBgisupplierspecs()[i]);
			gpo.setBgiwholegoodsisable("1");
			
			ColorPo frameStyle = new ColorPo();
			frameStyle.setBfsname(goodsInfoManyPo.getBgiframestyles()[i].trim());
			ColorPo fpo = colorMgr.getFrameStyle(frameStyle);
			gpo.setBgiframestyle(fpo.getBfsid());
			gpo.setBgibrandyear(goodsInfoPo.getBgibrandyear());
			gpo.setBgiframeprocesscrafttype(goodsInfoPo.getBgiframeprocesscrafttype());
			gpo.setBgibarcodeflag(goodsInfoPo.getBgibarcodeflag());   // 批次管理
			gpo.setBgipayfeeid(goodsInfoPo.getBgipayfeeid());
			
			goodsInfoPos.add(gpo);
			
			goodsid = tempgoodsid;
		}
		
		if(!"1".equals(isinsert)) {
			glassesFrameManyMgr.insertGlassesPresbyopicFrame(goodsInfoPos,logPo);
			this.addActionMessage(getText("struts.messages.insert.sucess"));
		} else {
			this.addActionMessage(getText("商品条码重复"));
		}
		
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

	public String getFileName()throws Exception  {
		return new String(fileName.getBytes(), "ISO8859-1");
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

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public GoodsInfoPo getGoodsInfoPo() {
		return goodsInfoPo;
	}

	public void setGoodsInfoPo(GoodsInfoPo goodsInfoPo) {
		this.goodsInfoPo = goodsInfoPo;
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

	public List<ColorPo> getColorList() {
		return colorList;
	}

	public void setColorList(List<ColorPo> colorList) {
		this.colorList = colorList;
	}

	public ColorMgr getColorMgr() {
		return colorMgr;
	}

	public void setColorMgr(ColorMgr colorMgr) {
		this.colorMgr = colorMgr;
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

	public List<TeachnologyTypePo> getTeachnologyTypeList() {
		return teachnologyTypeList;
	}

	public void setTeachnologyTypeList(List<TeachnologyTypePo> teachnologyTypeList) {
		this.teachnologyTypeList = teachnologyTypeList;
	}

	public TeachnologyTypeMgr getTeachnologyTypeMgr() {
		return teachnologyTypeMgr;
	}

	public void setTeachnologyTypeMgr(TeachnologyTypeMgr teachnologyTypeMgr) {
		this.teachnologyTypeMgr = teachnologyTypeMgr;
	}

	public SupplierMgr getSupplierMgr() {
		return supplierMgr;
	}

	public void setSupplierMgr(SupplierMgr supplierMgr) {
		this.supplierMgr = supplierMgr;
	}

	public List<GoodsLevelPo> getSelectGoodsLevelList() {
		return selectGoodsLevelList;
	}

	public void setSelectGoodsLevelList(List<GoodsLevelPo> selectGoodsLevelList) {
		this.selectGoodsLevelList = selectGoodsLevelList;
	}

	public BrandMgr getBrandMgr() {
		return brandMgr;
	}

	public void setBrandMgr(BrandMgr brandMgr) {
		this.brandMgr = brandMgr;
	}

	public GlassesFrameManyMgr getGlassesFrameManyMgr() {
		return glassesFrameManyMgr;
	}

	public void setGlassesFrameManyMgr(GlassesFrameManyMgr glassesFrameManyMgr) {
		this.glassesFrameManyMgr = glassesFrameManyMgr;
	}

	public List<GoodsInfoManyPo> getGoodsInfoManyPos() {
		return goodsInfoManyPos;
	}

	public void setGoodsInfoManyPos(List<GoodsInfoManyPo> goodsInfoManyPos) {
		this.goodsInfoManyPos = goodsInfoManyPos;
	}

	public GoodsInfoManyPo getGoodsInfoManyPo() {
		return goodsInfoManyPo;
	}

	public void setGoodsInfoManyPo(GoodsInfoManyPo goodsInfoManyPo) {
		this.goodsInfoManyPo = goodsInfoManyPo;
	}

	public GlassesFrameMgr getGlassesFrameMgr() {
		return glassesFrameMgr;
	}

	public void setGlassesFrameMgr(GlassesFrameMgr glassesFrameMgr) {
		this.glassesFrameMgr = glassesFrameMgr;
	}

	public List<GoodsInfoPo> getGoodsInfoPos() {
		return goodsInfoPos;
	}

	public void setGoodsInfoPos(List<GoodsInfoPo> goodsInfoPos) {
		this.goodsInfoPos = goodsInfoPos;
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
