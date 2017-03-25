package com.pengsheng.eims.components.action;

import java.math.BigDecimal;
import java.util.List;

import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.mgr.WarehouseConfigurationMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.RefractiveSetPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.components.mgr.SellMirrorFrameMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.TurnSphCyl;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class SellMirrorFrameAction extends BaseAction {

	private SellMirrorFrameMgr sellMirrorFrameMgr;
	private PersonPermissionMgr personPermissionMgr;
	private WarehouseConfigurationMgr warehouseConfigurationMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private UnitMgr unitMgr;
	private DepartmentsMgr departmentsMgr;
	private List<RefractiveSetPo> refractiveSetPos;
	
	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public List<RefractiveSetPo> getRefractiveSetPos() {
		return refractiveSetPos;
	}

	public void setRefractiveSetPos(List<RefractiveSetPo> refractiveSetPos) {
		this.refractiveSetPos = refractiveSetPos;
	}

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
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

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public WarehouseConfigurationMgr getWarehouseConfigurationMgr() {
		return warehouseConfigurationMgr;
	}

	public void setWarehouseConfigurationMgr(
			WarehouseConfigurationMgr warehouseConfigurationMgr) {
		this.warehouseConfigurationMgr = warehouseConfigurationMgr;
	}

	public SellMirrorFrameMgr getSellMirrorFrameMgr() {
		return sellMirrorFrameMgr;
	}

	public void setSellMirrorFrameMgr(SellMirrorFrameMgr sellMirrorFrameMgr) {
		this.sellMirrorFrameMgr = sellMirrorFrameMgr;
	}

	private List<GoodsInfoPo> goodsList;

	public List<GoodsInfoPo> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsInfoPo> goodsList) {
		this.goodsList = goodsList;
	}

	private GoodsInfoPo goodsInfoPo;

	public GoodsInfoPo getGoodsInfoPo() {
		return goodsInfoPo;
	}

	public void setGoodsInfoPo(GoodsInfoPo goodsInfoPo) {
		this.goodsInfoPo = goodsInfoPo;
	}

	/**
	 * 初始化销售镜架
	 */
	public String initSellMirrorFrameSel() throws Exception {

		return SUCCESS;
	}

	/**
	 * 初始化销售镜架(All)
	 */
	public String initSellMirrorFrameSelAll() throws Exception {
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
		
		String[] sphs = request.getParameterValues("sph");
		if(sphs == null){
			sphs = new String[2];
			sphs[0] = "n";
			sphs[1] = "n";
		}
		String[] cyls = request.getParameterValues("cyl");
		if(cyls == null){
			cyls = new String[2];
			cyls[0] = "n";
			cyls[1] = "n";
		}
		String[] adds = request.getParameterValues("add");	
		if(adds == null){
			adds = new String[2];
			adds[0] = "n";
			adds[1] = "n";
		}
		String rl = "".equals(Utility.getName(request.getParameter("rl"))) ? "R":Utility.getName(request.getParameter("rl"));
		
		String rsph = "n".equals(sphs[0]) ? request.getParameter("rsph"):sphs[0];
		String rcyl = "n".equals(cyls[0]) ? request.getParameter("rcyl"):cyls[0];
		String radd = "n".equals(adds[0]) ? request.getParameter("radd"):adds[0];	
		String lsph = "n".equals(sphs[1]) ? request.getParameter("lsph"):sphs[1];
		String lcyl = "n".equals(cyls[1]) ? request.getParameter("lcyl"):cyls[1];
		String ladd = "n".equals(adds[1]) ? request.getParameter("ladd"):adds[1];	
		String materialType = Utility.getName(request.getParameter("materialType"));// 镜片材质，玻璃树脂
		String glassFlag= Utility.getName(request.getParameter("glassFlag"));
		String recipeType= Utility.getName(request.getParameter("recipeType"));
		String ismutiluminosity = Utility.getName(request.getParameter("ismutiluminosity"));
		String other = Utility.getName(request.getParameter("other"));
		
		GoodsInfoPo po = new GoodsInfoPo();  
		
		if("R".equals(rl)||"".equals(rl)){
			if("".equals(other)){
        		if(Double.parseDouble(rcyl)>0){
        			BigDecimal rsphNew = new BigDecimal(Float.parseFloat(rcyl)).add(new BigDecimal(Float.parseFloat(rsph)));
        			BigDecimal rcylNew = new BigDecimal(Float.parseFloat(rcyl)).multiply(new BigDecimal("-1"));
        			po.setBgisph(rsphNew.toString());
        			po.setBgicyl(rcylNew.toString());
        		}else{
        			po.setBgisph(rsph);
        			po.setBgicyl(rcyl);
        		}
        	}else{
    			po.setBgisph(rsph);
    			po.setBgicyl(rcyl);
        	}
			po.setBgibelowplusluminosity(radd);
			po.setBgiflag("R");
		}else if("L".equals(rl)){
			if("0".equals(Utility.getName(systemParameterPo.getFspnegative()))&&"".equals(other)){
				if(Double.parseDouble(lcyl)>0){
					BigDecimal lsphNew = new BigDecimal(Float.parseFloat(lcyl)).add(new BigDecimal(Float.parseFloat(lsph)));
        			BigDecimal lcylNew = new BigDecimal(Float.parseFloat(lcyl)).multiply(new BigDecimal("-1"));
        			po.setBgisph(lsphNew.toString());
        			po.setBgicyl(lcylNew.toString());
				}else{
	    			po.setBgisph(lsph);
	    			po.setBgicyl(lcyl);
    			}
			}else{
    			po.setBgisph(lsph);
    			po.setBgicyl(lcyl);
			}
			po.setBgibelowplusluminosity(ladd);
			po.setBgiflag("L");
		}
		
		String goodscategory = Utility.getName(request.getParameter("goodscategory"));
		String accessoryType = Utility.getName(request.getParameter("accessoryType"));
		String oneselfframe = Utility.getName(request.getParameter("oneselfframe"));
		String iscustomize = Utility.getName(request.getParameter("iscustomize"));
		request.setAttribute("rl",rl);
		request.setAttribute("rsph",rsph);
		request.setAttribute("rcyl",rcyl);
		request.setAttribute("radd",radd);
		request.setAttribute("lsph",lsph);
		request.setAttribute("lcyl",lcyl);
		request.setAttribute("ladd",ladd);
		request.setAttribute("materialType",materialType );
		request.setAttribute("glassFlag",glassFlag );
		request.setAttribute("recipeType",recipeType );
		request.setAttribute("ismutiluminosity",ismutiluminosity);
		request.setAttribute("goodscategory",goodscategory);
		request.setAttribute("accessoryType",accessoryType);
		request.setAttribute("oneselfframe",oneselfframe);
		request.setAttribute("iscustomize",iscustomize);
		request.setAttribute("other",other);
		
		return SUCCESS;
	}
	
	/**
	 * 查询商品条码信息(All)
	 */
	public String selectSellMirrorFrameAll() throws Exception {
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
		String goodsname = Utility.getName(request.getParameter("goodsname"));
		String goodsid = Utility.getName(request.getParameter("goodsid"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String istakeframe = Utility.getName(request.getParameter("istakeframe"));		
		String goodscategory = Utility.getName(request.getParameter("goodscategory"));
		String kucun = Utility.getName(request.getParameter("kucun"));
		if("1".equals(systemParameterPo.getFspglassischecknumber()) && goodscategory.equals("3")){
			kucun = "0";
		}
		String accessoryType = Utility.getName(request.getParameter("accessoryType"));
		String oneselfframe = Utility.getName(request.getParameter("oneselfframe"));
		String iscustomize = Utility.getName(request.getParameter("iscustomize"));
		String materialType = Utility.getName(request.getParameter("materialType"));// 镜片材质，玻璃树脂
		String glassFlag= Utility.getName(request.getParameter("glassFlag"));
		String recipeType= Utility.getName(request.getParameter("recipeType"));
		String ismutiluminosity= Utility.getName(request.getParameter("ismutiluminosity"));
		String other = Utility.getName(request.getParameter("other"));
		String othergoodscategory = Utility.getName(request.getParameter("othergoodscategory"));
		String accessoriestype = Utility.getName(request.getParameter("accessoriestype")); 
		String pricedown = Utility.getName(request.getParameter("pricedown"));
		String priceup = Utility.getName(request.getParameter("priceup"));
		String refractive = Utility.getName(request.getParameter("refractive"));
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		String customertype = Utility.getName(request.getParameter("customertype"));
		request.setAttribute("customertype", customertype);
		
		refractiveSetPos = unitMgr.getRefractiveSetList();
		
		String[] sphs = request.getParameterValues("sph");
		String rsph = Utility.getName(request.getParameter("rsph"));
		String lsph = Utility.getName(request.getParameter("lsph"));
		
		if(sphs != null){
			if("".equals(rsph)){
				rsph = sphs[0];
			}
			if("".equals(lsph)){
				lsph = sphs[1];
			}
		}
		
		String[] cyls = request.getParameterValues("cyl");
		String rcyl = Utility.getName(request.getParameter("rcyl"));
		String lcyl = Utility.getName(request.getParameter("lcyl"));
		if(cyls != null){
			if("".equals(rcyl)&&"".equals(other)){
				if("".equals(Utility.getName(cyls[0]))){
					rcyl = "0.00";
				}else{
					rcyl = cyls[0];
				}
			}
			if("".equals(lcyl)&&"".equals(other)){
				if("".equals(Utility.getName(cyls[1]))){
					lcyl = "0.00";
				}else{
					lcyl = cyls[1];
				}
				
			}
		}
		String[] adds = request.getParameterValues("add");	
		String radd = Utility.getName(request.getParameter("radd"));
		String ladd = Utility.getName(request.getParameter("ladd"));
		if(adds != null){
			if("".equals(radd) && adds != null && "".equals(other)){
				radd = adds[0];
			}
			if("".equals(ladd) && adds != null && "".equals(other)){
				ladd = adds[1];
			}
		}
		String rl = "".equals(Utility.getName(request.getParameter("rl"))) ? "R":Utility.getName(request.getParameter("rl"));
		
		GoodsInfoPo po = new GoodsInfoPo();
		po.setBgirefractive(refractive);
		po.setBgigoodsname(goodsname);
		po.setBgigoodsname(goodsname);
		po.setBgiretailbeginprice(pricedown);
		po.setBgiretailendprice(priceup);
		po.setBgigoodsid(goodsid);
		po.setBgisupplierid("ZZ".equals(oneselfframe) ? oneselfframe:supplierID);
		po.setBgiunitid(oneselfframe);
		po.setBgibrandid(brandID);
		po.setCustomercardtype(customertype);
		po.setBgiwhichretail(whichretail);
		po.setBgiismendretail(select_retail);
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		
		po.setBgiwhichretail(dpo.getBdpwhichretail());
        if (goodscategory.equals("2")){
        	po.setBgiaccessoriestype(accessoryType);
        }
        if(!"".equals(other)){
        	if(!"".equals(goodscategory)){
        		goodscategory = "";
        	}
        	po.setBgigoodscategoryid(othergoodscategory);
        	po.setBgiaccessoriestype(accessoriestype);
        }else{
        	po.setBgigoodscategoryid(goodscategory);
        }
        po.setSystemparameterlevel(systemParameterPo.getFspisusegoodslevel());
        
        String orderstype = Utility.getName(request.getParameter("orderstype"));
        
        if(!"ZZ".equals(oneselfframe)){
        	po.setBgiother(other);
            po.setBgiiscustomize(iscustomize);        
            if("R".equals(rl)||"".equals(rl)){
            	if("".equals(other)){
            		po.setBgisph(TurnSphCyl.changeSph(rsph,rcyl));
	    			po.setBgicyl(TurnSphCyl.changeCyl(rsph,rcyl));
            	}else{
            		if(!"1".equals(orderstype)){
	        			po.setBgisph(rsph);
	        			po.setBgicyl(rcyl);
            		}
            	}
    			po.setBgibelowplusluminosity(radd);
    			po.setBgiflag("R");
    		}else if("L".equals(rl)){
    			if("".equals(other)){
    	    			po.setBgisph(TurnSphCyl.changeSph(lsph,lcyl));
    	    			po.setBgicyl(TurnSphCyl.changeCyl(lsph,lcyl));
    			}else{
    				if(!"1".equals(orderstype)){
		    			po.setBgisph(lsph);
		    			po.setBgicyl(lcyl);
    				}
    			}
    			po.setBgibelowplusluminosity(ladd);
    			po.setBgiflag("L");
    		}
    		po.setBgieyeglassmaterialtype(materialType);     
    		po.setBgiismutiluminosity(ismutiluminosity);
        }
        po.setBgigoodsquantity(kucun);
		po.setBgiwarehouseid(personInfoPo.getDepartmentID());
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		po.setQueryType(Utility.getName(systemParameterPo.getFspsalestype()));   //判断是否允许负库存
		
		int count = 0;
		if("".equals(othergoodscategory)&&!"".equals(other)){
			count = 0;
		}else{
			count = sellMirrorFrameMgr.getSellMirrorFrameCountAll(po);
		}
		
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
			goodsList = sellMirrorFrameMgr.getSellMirrorFrameListAll(po, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		
		request.setAttribute("refractive",refractive);
		request.setAttribute("kucun",kucun);
		request.setAttribute("oneselfframe",oneselfframe);
		request.setAttribute("accessoriestype", accessoriestype);
		request.setAttribute("othergoodscategory", othergoodscategory);
		request.setAttribute("goodscategory", goodscategory);
		request.setAttribute("accessoryType", accessoryType);
		request.setAttribute("goodsname", goodsname);
		request.setAttribute("goodsid", goodsid);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandName", brandName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("istakeframe", istakeframe);
		request.setAttribute("rl",rl);
		request.setAttribute("rsph",rsph);
		request.setAttribute("rcyl",rcyl);
		request.setAttribute("radd",radd);
		request.setAttribute("lsph",lsph);
		request.setAttribute("lcyl",lcyl);
		request.setAttribute("ladd",ladd);
		request.setAttribute("materialType",materialType );
		request.setAttribute("glassFlag",glassFlag );
		request.setAttribute("recipeType",recipeType );
		request.setAttribute("iscustomize",iscustomize);
		request.setAttribute("ismutiluminosity",ismutiluminosity);
		request.setAttribute("oneselfframe",oneselfframe );
		request.setAttribute("other",other);
		request.setAttribute("pricedown",pricedown);
		request.setAttribute("priceup",priceup);
		
		return SUCCESS;
	}
	
	/**
	 * 查询商品条码信息(All)
	 */
	public String selectSellMirrorFrameBatch() throws Exception {
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
		String goodsname = Utility.getName(request.getParameter("goodsname"));
		String goodsid = Utility.getName(request.getParameter("goodsid"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String istakeframe = Utility.getName(request.getParameter("istakeframe"));		
		String goodscategory = Utility.getName(request.getParameter("goodscategory"));
		String accessoryType = Utility.getName(request.getParameter("accessoryType"));
		String oneselfframe = Utility.getName(request.getParameter("oneselfframe"));
		String iscustomize = Utility.getName(request.getParameter("iscustomize"));
		String materialType = Utility.getName(request.getParameter("materialType"));// 镜片材质，玻璃树脂
		String glassFlag= Utility.getName(request.getParameter("glassFlag"));
		String recipeType= Utility.getName(request.getParameter("recipeType"));
		String ismutiluminosity= Utility.getName(request.getParameter("ismutiluminosity"));
		String other = Utility.getName(request.getParameter("other"));
		String othergoodscategory = Utility.getName(request.getParameter("othergoodscategory"));
		String accessoriestype = Utility.getName(request.getParameter("accessoriestype")); 
		String kucun = Utility.getName(request.getParameter("kucun"));
		String pricedown = Utility.getName(request.getParameter("pricedown"));
		String priceup = Utility.getName(request.getParameter("priceup"));
		refractiveSetPos = unitMgr.getRefractiveSetList();
		String[] sphs = request.getParameterValues("sph");
		String rsph = Utility.getName(request.getParameter("rsph"));
		String lsph = Utility.getName(request.getParameter("lsph"));
		String customertype = Utility.getName(request.getParameter("customertype"));
		request.setAttribute("customertype", customertype);
		
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		
		if(sphs != null){
			if("".equals(rsph)&&"".equals(other)){
				rsph = sphs[0];
			}
			if("".equals(lsph)&&"".equals(other)){
				lsph = sphs[1];
			}
		}
		String[] cyls = request.getParameterValues("cyl");
		String rcyl = Utility.getName(request.getParameter("rcyl"));
		String lcyl = Utility.getName(request.getParameter("lcyl"));
		if(cyls != null){
			if("".equals(rcyl)&&"".equals(other)){
				if("".equals(Utility.getName(cyls[0]))){
					rcyl = "0.00";
				}else{
					rcyl = cyls[0];
				}
			}
			if("".equals(lcyl)&&"".equals(other)){
				if("".equals(Utility.getName(cyls[1]))){
					lcyl = "0.00";
				}else{
					lcyl = cyls[1];
				}
				
			}
		}
		String[] adds = request.getParameterValues("add");	
		String radd = Utility.getName(request.getParameter("radd"));
		String ladd = Utility.getName(request.getParameter("ladd"));
		if("".equals(radd) && adds != null && "".equals(other)){
			radd = adds[0];
		}
		if("".equals(ladd) && adds != null && "".equals(other)){
			ladd = adds[1];
		}
		String rl = "".equals(Utility.getName(request.getParameter("rl"))) ? "R":Utility.getName(request.getParameter("rl"));
		
		GoodsInfoPo po = new GoodsInfoPo();
		po.setBgigoodsname(goodsname);
		po.setBgigoodsid(goodsid);
		po.setBgiretailbeginprice(pricedown);
		po.setBgiretailendprice(priceup);
		po.setBgisupplierid("ZZ".equals(oneselfframe) ? oneselfframe:supplierID);
		po.setBgibrandid(brandID);
		po.setCustomercardtype(customertype);
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		
		po.setBgiwhichretail(dpo.getBdpwhichretail());
		po.setBgiismendretail(select_retail);
		
        if (goodscategory.equals("2")){
        	po.setBgiaccessoriestype(accessoryType);
        }
        if(!"".equals(other)){
        	po.setBgigoodscategoryid(othergoodscategory);
        	po.setBgiaccessoriestype(accessoriestype);
        }else{
        	po.setBgigoodscategoryid(goodscategory);
        }
        if(!"ZZ".equals(oneselfframe)){
        	po.setBgiother(other);
            po.setBgiiscustomize(iscustomize);        
            if("R".equals(rl)||"".equals(rl)){
            	if("".equals(other)){
            		po.setBgisph(TurnSphCyl.changeSph(rsph,rcyl));
	    			po.setBgicyl(TurnSphCyl.changeCyl(rsph,rcyl));
            	}else{
        			po.setBgisph(rsph);
        			po.setBgicyl(rcyl);
            	}
    			po.setBgibelowplusluminosity(radd);
    			po.setBgiflag("R");
    		}else if("L".equals(rl)){
    			if("".equals(other)){
    				po.setBgisph(TurnSphCyl.changeSph(lsph,lcyl));
	    			po.setBgicyl(TurnSphCyl.changeCyl(lsph,lcyl));
    			}else{
	    			po.setBgisph(lsph);
	    			po.setBgicyl(lcyl);
    			}
    			po.setBgibelowplusluminosity(ladd);
    			po.setBgiflag("L");
    		}
    		po.setBgieyeglassmaterialtype(materialType);     
    		po.setBgiismutiluminosity(ismutiluminosity);
        }
        po.setBgigoodsquantity(kucun);
		po.setBgiwarehouseid(personInfoPo.getDepartmentID());
		po.setSystemparameterlevel(systemParameterPo.getFspisusegoodslevel());
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		po.setQueryType(Utility.getName(systemParameterPo.getFspsalestype()));   //判断是否允许负库存
		
		int count = sellMirrorFrameMgr.getSellMirrorFrameCountBatch(po);
		
		if("".equals(othergoodscategory)&&"1".equals(other)){
			count = 0;
		}
		
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
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
			goodsList = sellMirrorFrameMgr.getSellMirrorFrameListBatch(po, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		
		request.setAttribute("kucun",kucun);
		request.setAttribute("oneselfframe",oneselfframe);
		request.setAttribute("accessoriestype", accessoriestype);
		request.setAttribute("othergoodscategory", othergoodscategory);
		request.setAttribute("goodscategory", goodscategory);
		request.setAttribute("accessoryType", accessoryType);
		request.setAttribute("goodsname", goodsname);
		request.setAttribute("goodsid", goodsid);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandName", brandName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("istakeframe", istakeframe);
		request.setAttribute("rl",rl);
		request.setAttribute("rsph",rsph);
		request.setAttribute("rcyl",rcyl);
		request.setAttribute("radd",radd);
		request.setAttribute("lsph",lsph);
		request.setAttribute("lcyl",lcyl);
		request.setAttribute("ladd",ladd);
		request.setAttribute("materialType",materialType );
		request.setAttribute("glassFlag",glassFlag );
		request.setAttribute("recipeType",recipeType );
		request.setAttribute("iscustomize",iscustomize);
		request.setAttribute("ismutiluminosity",ismutiluminosity);
		request.setAttribute("oneselfframe",oneselfframe );
		request.setAttribute("other",other);
		request.setAttribute("pricedown",pricedown);
		request.setAttribute("priceup",priceup);
		
		return SUCCESS;
	}
	
	/**
	 * 查询商品条码信息
	 */
	public String selectSellMirrorFrame() throws Exception {
		// 接收页面传的信息

		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String departmentId = personInfoPo.getDepartmentID();

		WarehouseConfigurationPo warehouseConfigurationPo = new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(departmentId);

		warehouseConfigurationPo = warehouseConfigurationMgr
				.getWarehouseConfiguration(warehouseConfigurationPo);
		request.setAttribute("pcBarcode", Utility.getName(request.getParameter("goodsbarcode")));
		String goodsbarcode = Utility.getName(request.getParameter("goodsbarcode")).length()<18?Utility.getName(request.getParameter("goodsbarcode")):Utility.getName(request.getParameter("goodsbarcode")).substring(0,18);
		String goodsname = Utility.getName(request.getParameter("goodsname"));
		String goodsid = Utility.getName(request.getParameter("goodsid"));
		String supplierName = Utility.getName(request
				.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String istakeframe = Utility.getName(request.getParameter("istakeframe"));
		
		
		GoodsInfoPo po = new GoodsInfoPo();
		po.setBgigoodsbarcode(goodsbarcode);
		po.setBgigoodsname(goodsname);
		po.setBgigoodsname(goodsid);
		po.setBgisuppliername(supplierName);
		po.setBgisupplierid(istakeframe);
		po.setBgibrandname(brandName);
		po.setBgibrandid(brandID);
		
		WarehouseConfigurationPo tempWarehouseConfigurationPo = new WarehouseConfigurationPo();
		tempWarehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		WarehouseConfigurationPo warehouseConfigurationPo1=warehouseConfigurationMgr.getWarehouseConfiguration(tempWarehouseConfigurationPo);
		
		po.setOutstockidone(warehouseConfigurationPo1.getBwcstockid1());
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		// 获得查询镜架数量
		int count = sellMirrorFrameMgr.getSellMirrorFrameCount(po);
		// 分页
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
			// 遍历查询镜架信息
			goodsList = sellMirrorFrameMgr.getSellMirrorFrameList(po, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		request.setAttribute("goodsbarcode", goodsbarcode);
		request.setAttribute("goodsname", goodsname);
		request.setAttribute("goodsid", goodsid);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandName", brandName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("istakeframe", istakeframe);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化销售镜架
	 */
	public String initSellMirrorGoodsSel() throws Exception {

		return SUCCESS;
	}

	/**
	 * 查询商品条码信息
	 */
	public String selectSellMirrorGoods() throws Exception {
		// 接收页面传的信息

		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String departmentId = personInfoPo.getDepartmentID();

//		WarehouseConfigurationPo warehouseConfigurationPo = new WarehouseConfigurationPo();
//		warehouseConfigurationPo.setBwcdeptid(departmentId);
//
//		warehouseConfigurationPo = warehouseConfigurationMgr
//				.getWarehouseConfiguration(warehouseConfigurationPo);
		request.setAttribute("pcBarcode", Utility.getName(request.getParameter("goodsbarcode")));
		String goodsbarcode = Utility.getName(request.getParameter("goodsbarcode")).length()<18?"":Utility.getName(request.getParameter("goodsbarcode")).substring(0,18);
		String goodsname = Utility.getName(request.getParameter("goodsname"));
		String goodsid = Utility.getName(request.getParameter("goodsid"));
		String supplierName = Utility.getName(request
				.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));

		GoodsInfoPo po = new GoodsInfoPo();
		po.setBgigoodsbarcode(goodsbarcode);
		po.setBgigoodsname(goodsname);
		po.setBgigoodsname(goodsid);
		po.setBgisuppliername(supplierName);
		po.setBgisupplierid(supplierID);
		po.setBgibrandname(brandName);
		po.setBgibrandid(brandID);
		//po.setBgiwarehouseid(warehouseConfigurationPo.getBwcstockid1());
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		// 获得查询镜架数量
		int count = sellMirrorFrameMgr.getSellMirrorFrameCount1(po);
		// 分页
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
			// 遍历查询镜架信息
			goodsList = sellMirrorFrameMgr.getSellMirrorFrameList1(po, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		request.setAttribute("goodsbarcode", goodsbarcode);
		request.setAttribute("goodsname", goodsname);
		request.setAttribute("goodsid", goodsid);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandName", brandName);
		request.setAttribute("brandID", brandID);

		return SUCCESS;
	}
	
	/**
	 * 销售页面扫码开窗查询商品（All）
	 */
	public String scanGoodsSelAll() throws Exception {
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
		String goodsbar = Utility.getName(request.getParameter("goodsbar"));
		String[] sphs = request.getParameterValues("sph");
		if(sphs == null){
			sphs = new String[2];
			sphs[0] = "n";
			sphs[1] = "n";
		}
		String[] cyls = request.getParameterValues("cyl");
		if(cyls == null){
			cyls = new String[2];
			cyls[0] = "n";
			cyls[1] = "n";
		}
		String[] adds = request.getParameterValues("add");	
		if(adds == null){
			adds = new String[2];
			adds[0] = "n";
			adds[1] = "n";
		}
		String recipeType= Utility.getName(request.getParameter("recipeType"));
		String lrecipeType= Utility.getName(request.getParameter("lrecipeType"));
		String lglassFlag= Utility.getName(request.getParameter("lglassFlag"));
		String glassFlag= Utility.getName(request.getParameter("glassFlag"));
		String lsyjp= Utility.getName(request.getParameter("lsyjp"));
		String syjp= Utility.getName(request.getParameter("syjp"));
		String direction = Utility.getName(request.getParameter("direction"));
		String rl = "".equals(Utility.getName(request.getParameter("rl"))) ? "R":Utility.getName(request.getParameter("rl"));
		
		String rsph = "n".equals(sphs[0]) ? request.getParameter("rsph"):sphs[0];
		String rcyl = "n".equals(cyls[0]) ? request.getParameter("rcyl"):cyls[0];
		String radd = "n".equals(adds[0]) ? request.getParameter("radd"):adds[0];	
		String lsph = "n".equals(sphs[1]) ? request.getParameter("lsph"):sphs[1];
		String lcyl = "n".equals(cyls[1]) ? request.getParameter("lcyl"):cyls[1];
		String ladd = "n".equals(adds[1]) ? request.getParameter("ladd"):adds[1];	
		String customertype = Utility.getName(request.getParameter("customertype"));
		String ordertype = Utility.getName(request.getParameter("ordertype"));
		
		request.setAttribute("customertype", customertype);
		request.setAttribute("rl",rl);
		request.setAttribute("goodsbar",goodsbar);
		request.setAttribute("rsph",rsph);
		request.setAttribute("rcyl",rcyl);
		request.setAttribute("radd",radd);
		request.setAttribute("lsph",lsph);
		request.setAttribute("lcyl",lcyl);
		request.setAttribute("ladd",ladd);
		request.setAttribute("recipeType",recipeType );
		request.setAttribute("lrecipeType",lrecipeType );
		request.setAttribute("lglassFlag",lglassFlag );
		request.setAttribute("lsyjp",lsyjp );
		request.setAttribute("glassFlag",glassFlag );
		request.setAttribute("syjp",syjp );  //商品名称
		request.setAttribute("goodscategory",goodsbar.substring(0,1));  //商品名称
		request.setAttribute("direction",direction);
		
		//新增lvhz begin
		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		request.setAttribute("iscustomize",iscustomize);
		//新增lvhz end
		
		String kucun = Utility.getName(request.getParameter("kucun"));
		request.setAttribute("kucun",kucun);
		
		GoodsInfoPo po = new GoodsInfoPo(); 
		
		if(ordertype.equals("1")&&goodsbar.substring(0,1).equals("8")){
			
		}else{
			if("R".equals(rl)||"".equals(rl)){
				po.setBgisph(TurnSphCyl.changeSph(rsph,rcyl));
				po.setBgicyl(TurnSphCyl.changeCyl(rsph,rcyl));
				po.setBgibelowplusluminosity(radd);
				po.setBgiflag("R");
			}else if("L".equals(rl)){
				po.setBgisph(TurnSphCyl.changeSph(lsph,lcyl));
				po.setBgicyl(TurnSphCyl.changeCyl(lsph,lcyl));
				po.setBgibelowplusluminosity(ladd);
				po.setBgiflag("L");
			}else if("8".equals(goodsbar.substring(0,1))){
				po.setBgisph(rsph);
				po.setBgisph(lsph);
			}
		}
		
		po.setBgigoodscategoryid(goodsbar.substring(0,1));
		po.setBgigoodsbarcode(goodsbar);
		po.setBgiwarehouseid(personInfoPo.getDepartmentID());		
		po.setBgiiscustomize(iscustomize);
		po.setBgigoodsquantity(kucun);
		po.setCustomercardtype(customertype);
		
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		
		po.setBgiwhichretail(dpo.getBdpwhichretail());
		po.setSystemparameterlevel(systemParameterPo.getFspisusegoodslevel());		
		
		po.setQueryType(Utility.getName(systemParameterPo.getFspsalestype()));   //判断是否允许负库存
		
		goodsList = sellMirrorFrameMgr.getScanGoodsList(po);
				
		return SUCCESS;
	}
	
	/**
	 * 销售页面扫码开窗查询商品隐形效期专用（AllBatch）
	 */
	public String scanGoodsSelAllBatch() throws Exception {
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
		
		String goodsbar = Utility.getName(request.getParameter("goodsbar"));
		String[] sphs = request.getParameterValues("sph");
		if(sphs == null){
			sphs = new String[2];
			sphs[0] = "n";
			sphs[1] = "n";
		}
		String[] cyls = request.getParameterValues("cyl");
		if(cyls == null){
			cyls = new String[2];
			cyls[0] = "n";
			cyls[1] = "n";
		}
		String[] adds = request.getParameterValues("add");	
		if(adds == null){
			adds = new String[2];
			adds[0] = "n";
			adds[1] = "n";
		}
		String recipeType= Utility.getName(request.getParameter("recipeType"));
		String lrecipeType= Utility.getName(request.getParameter("lrecipeType"));
		String lglassFlag= Utility.getName(request.getParameter("lglassFlag"));
		String glassFlag= Utility.getName(request.getParameter("glassFlag"));
		String lsyjp= Utility.getName(request.getParameter("lsyjp"));
		String syjp= Utility.getName(request.getParameter("syjp"));
		String direction = Utility.getName(request.getParameter("direction"));
		String rl = "".equals(Utility.getName(request.getParameter("rl"))) ? "R":Utility.getName(request.getParameter("rl"));
		
		String rsph = "n".equals(sphs[0]) ? request.getParameter("rsph"):sphs[0];
		String rcyl = "n".equals(cyls[0]) ? request.getParameter("rcyl"):cyls[0];
		String radd = "n".equals(adds[0]) ? request.getParameter("radd"):adds[0];	
		String lsph = "n".equals(sphs[1]) ? request.getParameter("lsph"):sphs[1];
		String lcyl = "n".equals(cyls[1]) ? request.getParameter("lcyl"):cyls[1];
		String ladd = "n".equals(adds[1]) ? request.getParameter("ladd"):adds[1];
		String customertype = Utility.getName(request.getParameter("customertype"));
		request.setAttribute("customertype", customertype);
		
		request.setAttribute("rl",rl);
		request.setAttribute("goodsbar",goodsbar);
		request.setAttribute("rsph",rsph);
		request.setAttribute("rcyl",rcyl);
		request.setAttribute("radd",radd);
		request.setAttribute("lsph",lsph);
		request.setAttribute("lcyl",lcyl);
		request.setAttribute("ladd",ladd);
		request.setAttribute("recipeType",recipeType );
		request.setAttribute("lrecipeType",lrecipeType );
		request.setAttribute("lglassFlag",lglassFlag );
		request.setAttribute("lsyjp",lsyjp );
		request.setAttribute("glassFlag",glassFlag );
		request.setAttribute("syjp",syjp );  //商品名称
		request.setAttribute("goodscategory",goodsbar.substring(0,1));  //商品名称
		request.setAttribute("direction",direction);
     
		//新增lvhz begin
		String goodscategory=Utility.getName(request.getParameter("goodscategory"));
		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		request.setAttribute("goodscategory",goodscategory);
		request.setAttribute("iscustomize",iscustomize);
		//新增lvhz end
		
		String kucun = Utility.getName(request.getParameter("kucun"));
		request.setAttribute("kucun",kucun);
		
		GoodsInfoPo po = new GoodsInfoPo();  
		if (Utility.getName(systemParameterPo.getFspstealtheffective()).equals("1")){
			po.setGuaranteeperiod("1");
		}else{
			po.setGuaranteeperiod("0");
		}
		
		if("R".equals(rl)||"".equals(rl)){
			po.setBgisph(TurnSphCyl.changeSph(rsph,rcyl));
			po.setBgicyl(TurnSphCyl.changeCyl(rsph,rcyl));
			po.setBgibelowplusluminosity(radd);
			po.setBgiflag("R");
		}else if("L".equals(rl)){
			po.setBgisph(TurnSphCyl.changeSph(lsph,lcyl));
			po.setBgicyl(TurnSphCyl.changeCyl(lsph,lcyl));
			po.setBgibelowplusluminosity(ladd);
			po.setBgiflag("L");
		}
		
		po.setBgigoodscategoryid(goodsbar.substring(0,1));
		po.setBgigoodsbarcode(goodsbar);
		po.setBgiwarehouseid(personInfoPo.getDepartmentID());		
		po.setBgiiscustomize(iscustomize);
		po.setBgigoodsquantity(kucun);
		po.setCustomercardtype(customertype);
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		po.setSystemparameterlevel(systemParameterPo.getFspisusegoodslevel());
		
		po.setBgiwhichretail(dpo.getBdpwhichretail());
		if("D".equals(iscustomize)){
			goodsList = sellMirrorFrameMgr.getScanGoodsList(po);
		}else{
			goodsList = sellMirrorFrameMgr.getScanGoodsList1(po);
		}
		
		return SUCCESS;
	}
/*--------------------------------------------------------------------------------------------------------------------------------------------------*/	
	/**
	 * 查询商品条码信息(All)
	 */
	public String selectSellMirrorFrameBatchNew() throws Exception {
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
		String goodsname = Utility.getName(request.getParameter("goodsname"));
		String goodsid = Utility.getName(request.getParameter("goodsid"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String istakeframe = Utility.getName(request.getParameter("istakeframe"));		
		String goodscategory = Utility.getName(request.getParameter("goodscategory"));
		String accessoryType = Utility.getName(request.getParameter("accessoryType"));
		String oneselfframe = Utility.getName(request.getParameter("oneselfframe"));
		String iscustomize = Utility.getName(request.getParameter("iscustomize"));
		String materialType = Utility.getName(request.getParameter("materialType"));// 镜片材质，玻璃树脂
		String glassFlag= Utility.getName(request.getParameter("glassFlag"));
		String recipeType= Utility.getName(request.getParameter("recipeType"));
		String ismutiluminosity= Utility.getName(request.getParameter("ismutiluminosity"));
		String other = Utility.getName(request.getParameter("other"));
		String othergoodscategory = Utility.getName(request.getParameter("othergoodscategory"));
		String accessoriestype = Utility.getName(request.getParameter("accessoriestype")); 
		String kucun = Utility.getName(request.getParameter("kucun"));
		String pricedown = Utility.getName(request.getParameter("pricedown"));
		String priceup = Utility.getName(request.getParameter("priceup"));
		refractiveSetPos = unitMgr.getRefractiveSetList();
		String[] sphs = request.getParameterValues("sph");
		String rsph = Utility.getName(request.getParameter("rsph"));
		String lsph = Utility.getName(request.getParameter("lsph"));
		String customertype = Utility.getName(request.getParameter("customertype"));
		request.setAttribute("customertype", customertype);
		
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		
		String[] unionsphcyls = request.getParameterValues("unionsphcyl");	
		if(unionsphcyls == null){
			unionsphcyls = new String[2];
			unionsphcyls[0] = "n";
			unionsphcyls[1] = "n";
		}
		
		String runionsphcyl = "";
		String lunionsphcyl = "";
		if (unionsphcyls.length >= 1){
			runionsphcyl = "n".equals(unionsphcyls[0]) ? request.getParameter("runionsphcyl"):unionsphcyls[0];
		}
		if (unionsphcyls.length > 1){
			lunionsphcyl = "n".equals(unionsphcyls[1]) ? request.getParameter("lunionsphcyl"):unionsphcyls[1];
		}
		
		request.setAttribute("runionsphcyl",runionsphcyl);
		request.setAttribute("lunionsphcyl",lunionsphcyl);
		
		if(sphs != null){
			if("".equals(rsph)&&"".equals(other)){
				rsph = sphs[0];
			}
			if("".equals(lsph)&&"".equals(other)){
				lsph = sphs[1];
			}
		}
		String[] cyls = request.getParameterValues("cyl");
		String rcyl = Utility.getName(request.getParameter("rcyl"));
		String lcyl = Utility.getName(request.getParameter("lcyl"));
		if(cyls != null){
			if("".equals(rcyl)&&"".equals(other)){
				if("".equals(Utility.getName(cyls[0]))){
					rcyl = "0.00";
				}else{
					rcyl = cyls[0];
				}
			}
			if("".equals(lcyl)&&"".equals(other)){
				if("".equals(Utility.getName(cyls[1]))){
					lcyl = "0.00";
				}else{
					lcyl = cyls[1];
				}
				
			}
		}
		String[] adds = request.getParameterValues("add");	
		String radd = Utility.getName(request.getParameter("radd"));
		String ladd = Utility.getName(request.getParameter("ladd"));
		if("".equals(radd) && adds != null && "".equals(other)){
			radd = adds[0];
		}
		if("".equals(ladd) && adds != null && "".equals(other)){
			ladd = adds[1];
		}
		String rl = "".equals(Utility.getName(request.getParameter("rl"))) ? "R":Utility.getName(request.getParameter("rl"));
		
		GoodsInfoPo po = new GoodsInfoPo();
		po.setBgigoodsname(goodsname);
		po.setBgigoodsid(goodsid);
		po.setBgiretailbeginprice(pricedown);
		po.setBgiretailendprice(priceup);
		po.setBgisupplierid("ZZ".equals(oneselfframe) ? oneselfframe:supplierID);
		po.setBgibrandid(brandID);
		po.setCustomercardtype(customertype);
		po.setBgishopcode(personInfoPo.getDepartmentID());
		
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		
		po.setBgiwhichretail(dpo.getBdpwhichretail());
		po.setBgiismendretail(select_retail);
		
        if (goodscategory.equals("2")){
        	po.setBgiaccessoriestype(accessoryType);
        }
        if(!"".equals(other)){
        	othergoodscategory = othergoodscategory.equals("") ? goodscategory : othergoodscategory;
        	po.setBgigoodscategoryid(othergoodscategory);
        	po.setBgiaccessoriestype(accessoriestype);
        }else{
        	po.setBgigoodscategoryid(goodscategory);
        }
        if(!"ZZ".equals(oneselfframe)){
        	po.setBgiother(other);
            po.setBgiiscustomize(iscustomize);        
            if("R".equals(rl)||"".equals(rl)){
            	if("".equals(other)){
            		po.setBgisph(TurnSphCyl.changeSph(rsph,rcyl));
	    			po.setBgicyl(TurnSphCyl.changeCyl(rsph,rcyl));
            	}else{
        			po.setBgisph(rsph);
        			po.setBgicyl(rcyl);
            	}
    			po.setBgibelowplusluminosity(radd);
    			po.setBgiflag("R");
    			po.setBgiunionsphcyl(runionsphcyl);
    		}else if("L".equals(rl)){
    			if("".equals(other)){
    				po.setBgisph(TurnSphCyl.changeSph(lsph,lcyl));
	    			po.setBgicyl(TurnSphCyl.changeCyl(lsph,lcyl));
    			}else{
	    			po.setBgisph(lsph);
	    			po.setBgicyl(lcyl);
    			}
    			po.setBgibelowplusluminosity(ladd);
    			po.setBgiflag("L");
    			po.setBgiunionsphcyl(lunionsphcyl);
    		}
    		po.setBgieyeglassmaterialtype(materialType);     
    		po.setBgiismutiluminosity(ismutiluminosity);
        }
        po.setBgigoodsquantity(kucun);   // 库存状态
		po.setBgiwarehouseid(personInfoPo.getDepartmentID());
		po.setSystemparameterlevel(systemParameterPo.getFspisusegoodslevel());
		po.setQueryType(Utility.getName(systemParameterPo.getFspsalestype()));   //判断是否允许负库存		
		po.setBgicppquerytype(Utility.getName(systemParameterPo.getFspglassischecknumber()));   //判断成品片是否允许负库存
		
		if ((Utility.getName(systemParameterPo.getFspsalestype()).equals("1") && Utility.getName(systemParameterPo.getFspquerygoodsstorage()).equals("1")) || Utility.getName(po.getBgisupplierid()).equals("ZZ")){
			po.setBgiisselectstorage("1");  // 允许负库存的时候或是自架自片，判断查看的商品是否需要绑定库存
		}
		
		if("0".equals(Utility.getName(po.getQueryType()))){  // 不允许负库存
			if(iscustomize.equals("0") && "3".equals(Utility.getName(po.getBgigoodscategoryid())) && Utility.getName(systemParameterPo.getFspglassischecknumber()).equals("1")){   // 成品片是否允许负库存
				po.setBgiisleftorinner("2");  // 1. inner   2.left 
			}else{
				po.setBgiisleftorinner("1");  // 1. inner   2.left 
			}			
		}else{
			if (Utility.getName(po.getBgigoodsquantity()).equals("1")){
				po.setBgiisleftorinner("1");  // 1. inner   2.left 
			}else{
				po.setBgiisleftorinner("2");  // 1. inner   2.left 
			}			
		}	
		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		getExecTime("开始执行");
		int count = sellMirrorFrameMgr.getSellMirrorFrameCountBatchNew(po);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
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
			goodsList = sellMirrorFrameMgr.getSellMirrorFrameListBatchNew(po, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		getExecTime("执行结束");
		
		request.setAttribute("kucun",kucun);
		request.setAttribute("oneselfframe",oneselfframe);
		request.setAttribute("accessoriestype", accessoriestype);
		request.setAttribute("othergoodscategory", othergoodscategory);
		request.setAttribute("goodscategory", goodscategory);
		request.setAttribute("accessoryType", accessoryType);
		request.setAttribute("goodsname", goodsname);
		request.setAttribute("goodsid", goodsid);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandName", brandName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("istakeframe", istakeframe);
		request.setAttribute("rl",rl);
		request.setAttribute("rsph",rsph);
		request.setAttribute("rcyl",rcyl);
		request.setAttribute("radd",radd);
		request.setAttribute("lsph",lsph);
		request.setAttribute("lcyl",lcyl);
		request.setAttribute("ladd",ladd);
		request.setAttribute("materialType",materialType );
		request.setAttribute("glassFlag",glassFlag );
		request.setAttribute("recipeType",recipeType );
		request.setAttribute("iscustomize",iscustomize);
		request.setAttribute("ismutiluminosity",ismutiluminosity);
		request.setAttribute("oneselfframe",oneselfframe );
		request.setAttribute("other",other);
		request.setAttribute("pricedown",pricedown);
		request.setAttribute("priceup",priceup);
		
		return SUCCESS;
	}
	
	/**
	 * 查询商品条码信息(All)
	 */
	public String selectSellMirrorFrameAllNew() throws Exception {
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
		String goodsname = Utility.getName(request.getParameter("goodsname"));
		String goodsid = Utility.getName(request.getParameter("goodsid"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String istakeframe = Utility.getName(request.getParameter("istakeframe"));		
		String goodscategory = Utility.getName(request.getParameter("goodscategory"));
		String kucun = Utility.getName(request.getParameter("kucun"));
		if("1".equals(systemParameterPo.getFspglassischecknumber()) && goodscategory.equals("3")){
			kucun = "0";
		}
		String accessoryType = Utility.getName(request.getParameter("accessoryType"));
		String oneselfframe = Utility.getName(request.getParameter("oneselfframe"));
		String iscustomize = Utility.getName(request.getParameter("iscustomize"));
		String materialType = Utility.getName(request.getParameter("materialType"));// 镜片材质，玻璃树脂
		String glassFlag= Utility.getName(request.getParameter("glassFlag"));
		String recipeType= Utility.getName(request.getParameter("recipeType"));
		String ismutiluminosity= Utility.getName(request.getParameter("ismutiluminosity"));
		String other = Utility.getName(request.getParameter("other"));
		String othergoodscategory = Utility.getName(request.getParameter("othergoodscategory"));
		String accessoriestype = Utility.getName(request.getParameter("accessoriestype")); 
		String pricedown = Utility.getName(request.getParameter("pricedown"));
		String priceup = Utility.getName(request.getParameter("priceup"));
		String refractive = Utility.getName(request.getParameter("refractive"));
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		String customertype = Utility.getName(request.getParameter("customertype"));
		request.setAttribute("customertype", customertype);
		
		String[] unionsphcyls = request.getParameterValues("unionsphcyl");	
		if(unionsphcyls == null){
			unionsphcyls = new String[2];
			unionsphcyls[0] = "n";
			unionsphcyls[1] = "n";
		}
		
		String runionsphcyl = "";
		String lunionsphcyl = "";
		if (unionsphcyls.length >= 1){
			runionsphcyl = "n".equals(unionsphcyls[0]) ? request.getParameter("runionsphcyl"):unionsphcyls[0];
		}
		if (unionsphcyls.length > 1){
			lunionsphcyl = "n".equals(unionsphcyls[1]) ? request.getParameter("lunionsphcyl"):unionsphcyls[1];
		}
		
		request.setAttribute("runionsphcyl",runionsphcyl);
		request.setAttribute("lunionsphcyl",lunionsphcyl);
		
		refractiveSetPos = unitMgr.getRefractiveSetList();
		
		String[] sphs = request.getParameterValues("sph");
		String rsph = Utility.getName(request.getParameter("rsph"));
		String lsph = Utility.getName(request.getParameter("lsph"));
		
		if(sphs != null){
			if("".equals(rsph)){
				rsph = sphs[0];
			}
			if("".equals(lsph)){
				lsph = sphs[1];
			}
		}
		
		String[] cyls = request.getParameterValues("cyl");
		String rcyl = Utility.getName(request.getParameter("rcyl"));
		String lcyl = Utility.getName(request.getParameter("lcyl"));
		if(cyls != null){
			if("".equals(rcyl)&&"".equals(other)){
				if("".equals(Utility.getName(cyls[0]))){
					rcyl = "0.00";
				}else{
					rcyl = cyls[0];
				}
			}
			if("".equals(lcyl)&&"".equals(other)){
				if("".equals(Utility.getName(cyls[1]))){
					lcyl = "0.00";
				}else{
					lcyl = cyls[1];
				}
				
			}
		}
		String[] adds = request.getParameterValues("add");	
		String radd = Utility.getName(request.getParameter("radd"));
		String ladd = Utility.getName(request.getParameter("ladd"));
		if(adds != null){
			if("".equals(radd) && adds != null && "".equals(other)){
				radd = adds[0];
			}
			if("".equals(ladd) && adds != null && "".equals(other)){
				ladd = adds[1];
			}
		}
		String rl = "".equals(Utility.getName(request.getParameter("rl"))) ? "R":Utility.getName(request.getParameter("rl"));
		
		GoodsInfoPo po = new GoodsInfoPo();
		po.setBgirefractive(refractive);
		po.setBgigoodsname(goodsname);
		po.setBgigoodsname(goodsname);
		po.setBgiretailbeginprice(pricedown);
		po.setBgiretailendprice(priceup);
		po.setBgigoodsid(goodsid);
		po.setBgisupplierid("ZZ".equals(oneselfframe) ? oneselfframe:supplierID);
		po.setBgiunitid(oneselfframe);
		po.setBgibrandid(brandID);
		po.setCustomercardtype(customertype);
		po.setBgiwhichretail(whichretail);
		po.setBgiismendretail(select_retail);
		po.setBgishopcode(personInfoPo.getDepartmentID());
		
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		
		po.setBgiwhichretail(dpo.getBdpwhichretail());
        if (goodscategory.equals("2")){
        	po.setBgiaccessoriestype(accessoryType);
        }
        if(!"".equals(other)){
        	othergoodscategory = othergoodscategory.equals("") ? goodscategory : othergoodscategory;
        	accessoriestype = accessoriestype.equals("") ? accessoryType : accessoriestype;
        	po.setBgigoodscategoryid(othergoodscategory);
        	po.setBgiaccessoriestype(accessoriestype);
        }else{
        	po.setBgigoodscategoryid(goodscategory);
        }
        po.setSystemparameterlevel(systemParameterPo.getFspisusegoodslevel());
        
        String orderstype = Utility.getName(request.getParameter("orderstype"));
        
        if(!"ZZ".equals(oneselfframe)){
        	po.setBgiother(other);
            po.setBgiiscustomize(iscustomize);        
            if("R".equals(rl)||"".equals(rl)){
            	if("".equals(other)){
            		po.setBgisph(TurnSphCyl.changeSph(rsph,rcyl));
	    			po.setBgicyl(TurnSphCyl.changeCyl(rsph,rcyl));
            	}else{
            		if(!"1".equals(orderstype)){
	        			po.setBgisph(rsph);
	        			po.setBgicyl(rcyl);
            		}
            	}
    			po.setBgibelowplusluminosity(radd);
    			po.setBgiflag("R");
    			po.setBgiunionsphcyl(runionsphcyl);
    		}else if("L".equals(rl)){
    			if("".equals(other)){
    	    			po.setBgisph(TurnSphCyl.changeSph(lsph,lcyl));
    	    			po.setBgicyl(TurnSphCyl.changeCyl(lsph,lcyl));
    			}else{
    				if(!"1".equals(orderstype)){
		    			po.setBgisph(lsph);
		    			po.setBgicyl(lcyl);
    				}
    			}
    			po.setBgibelowplusluminosity(ladd);
    			po.setBgiflag("L");
    			po.setBgiunionsphcyl(lunionsphcyl);
    		}
    		po.setBgieyeglassmaterialtype(materialType);     
    		po.setBgiismutiluminosity(ismutiluminosity);
        }
        po.setBgigoodsquantity(kucun);
		po.setBgiwarehouseid(personInfoPo.getDepartmentID());
		po.setQueryType(Utility.getName(systemParameterPo.getFspsalestype()));   //判断是否允许负库存
		
		if (Utility.getName(po.getBgigoodscategoryid()).equals("8") && Utility.getName(systemParameterPo.getFspoldglasssalestype()).equals("0")){
			po.setBgisph("");
		}
		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		po.setBgicppquerytype(Utility.getName(systemParameterPo.getFspglassischecknumber()));   //判断成品片是否允许负库存
		
		if ((Utility.getName(systemParameterPo.getFspsalestype()).equals("1") && Utility.getName(systemParameterPo.getFspquerygoodsstorage()).equals("1")) || Utility.getName(po.getBgisupplierid()).equals("ZZ")){
			po.setBgiisselectstorage("1");  // 允许负库存的时候或是自架自片，判断查看的商品是否需要绑定库存
		}
		
		if("0".equals(Utility.getName(po.getQueryType()))){  // 不允许负库存
			if(iscustomize.equals("0") && "3".equals(Utility.getName(po.getBgigoodscategoryid())) && Utility.getName(systemParameterPo.getFspglassischecknumber()).equals("1")){   // 成品片是否允许负库存
				po.setBgiisleftorinner("2");  // 1. inner   2.left 
			}else{
				po.setBgiisleftorinner("1");  // 1. inner   2.left 
			}			
		}else{
			if (Utility.getName(po.getBgigoodsquantity()).equals("1")){
				po.setBgiisleftorinner("1");  // 1. inner   2.left 
			}else{
				po.setBgiisleftorinner("2");  // 1. inner   2.left 
			}			
		}	
		
		getExecTime("开始执行");		
		int count = sellMirrorFrameMgr.getSellMirrorFrameCountAllNew(po);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, count, perPage);			
			goodsList = sellMirrorFrameMgr.getSellMirrorFrameListAllNew(po, page.getStart(), page.getPageSize());			
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		getExecTime("执行结束");
		
		request.setAttribute("refractive",refractive);
		request.setAttribute("kucun",kucun);
		request.setAttribute("oneselfframe",oneselfframe);
		request.setAttribute("accessoriestype", accessoriestype);
		request.setAttribute("othergoodscategory", othergoodscategory);
		request.setAttribute("goodscategory", goodscategory);
		request.setAttribute("accessoryType", accessoryType);
		request.setAttribute("goodsname", goodsname);
		request.setAttribute("goodsid", goodsid);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandName", brandName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("istakeframe", istakeframe);
		request.setAttribute("rl",rl);
		request.setAttribute("rsph",rsph);
		request.setAttribute("rcyl",rcyl);
		request.setAttribute("radd",radd);
		request.setAttribute("lsph",lsph);
		request.setAttribute("lcyl",lcyl);
		request.setAttribute("ladd",ladd);
		request.setAttribute("materialType",materialType );
		request.setAttribute("glassFlag",glassFlag );
		request.setAttribute("recipeType",recipeType );
		request.setAttribute("iscustomize",iscustomize);
		request.setAttribute("ismutiluminosity",ismutiluminosity);
		request.setAttribute("oneselfframe",oneselfframe );
		request.setAttribute("other",other);
		request.setAttribute("pricedown",pricedown);
		request.setAttribute("priceup",priceup);
		
		return SUCCESS;
	}
	
	/**
	 * 销售页面扫码开窗查询商品隐形效期专用（AllBatch）
	 */
	public String scanGoodsSelAllBatchNew() throws Exception {
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
		
		String goodsbar = Utility.getName(request.getParameter("goodsbar"));
		String[] sphs = request.getParameterValues("sph");
		if(sphs == null){
			sphs = new String[2];
			sphs[0] = "n";
			sphs[1] = "n";
		}
		String[] cyls = request.getParameterValues("cyl");
		if(cyls == null){
			cyls = new String[2];
			cyls[0] = "n";
			cyls[1] = "n";
		}
		String[] adds = request.getParameterValues("add");	
		if(adds == null){
			adds = new String[2];
			adds[0] = "n";
			adds[1] = "n";
		}
		String recipeType= Utility.getName(request.getParameter("recipeType"));
		String lrecipeType= Utility.getName(request.getParameter("lrecipeType"));
		String lglassFlag= Utility.getName(request.getParameter("lglassFlag"));
		String glassFlag= Utility.getName(request.getParameter("glassFlag"));
		String lsyjp= Utility.getName(request.getParameter("lsyjp"));
		String syjp= Utility.getName(request.getParameter("syjp"));
		String direction = Utility.getName(request.getParameter("direction"));
		String rl = "".equals(Utility.getName(request.getParameter("rl"))) ? "R":Utility.getName(request.getParameter("rl"));
		
		String rsph = "n".equals(sphs[0]) ? request.getParameter("rsph"):sphs[0];
		String rcyl = "n".equals(cyls[0]) ? request.getParameter("rcyl"):cyls[0];
		String radd = "n".equals(adds[0]) ? request.getParameter("radd"):adds[0];	
		String lsph = "n".equals(sphs[1]) ? request.getParameter("lsph"):sphs[1];
		String lcyl = "n".equals(cyls[1]) ? request.getParameter("lcyl"):cyls[1];
		String ladd = "n".equals(adds[1]) ? request.getParameter("ladd"):adds[1];
		String customertype = Utility.getName(request.getParameter("customertype"));
		request.setAttribute("customertype", customertype);
		
		String[] unionsphcyls = request.getParameterValues("unionsphcyl");	
		if(unionsphcyls == null){
			unionsphcyls = new String[2];
			unionsphcyls[0] = "n";
			unionsphcyls[1] = "n";
		}
		
		String runionsphcyl = "";
		String lunionsphcyl = "";
		if (unionsphcyls.length >= 1){
			runionsphcyl = "n".equals(unionsphcyls[0]) ? request.getParameter("runionsphcyl"):unionsphcyls[0];
		}
		if (unionsphcyls.length > 1){
			lunionsphcyl = "n".equals(unionsphcyls[1]) ? request.getParameter("lunionsphcyl"):unionsphcyls[1];
		}
		
		request.setAttribute("rl",rl);
		request.setAttribute("goodsbar",goodsbar);
		request.setAttribute("rsph",rsph);
		request.setAttribute("rcyl",rcyl);
		request.setAttribute("radd",radd);
		request.setAttribute("lsph",lsph);
		request.setAttribute("lcyl",lcyl);
		request.setAttribute("ladd",ladd);
		request.setAttribute("recipeType",recipeType );
		request.setAttribute("lrecipeType",lrecipeType );
		request.setAttribute("lglassFlag",lglassFlag );
		request.setAttribute("lsyjp",lsyjp );
		request.setAttribute("glassFlag",glassFlag );
		request.setAttribute("syjp",syjp );  //商品名称
		request.setAttribute("goodscategory",goodsbar.substring(0,1));  //商品名称
		request.setAttribute("direction",direction);
		request.setAttribute("runionsphcyl",runionsphcyl);
		request.setAttribute("lunionsphcyl",lunionsphcyl);
     
		//新增lvhz begin
		String goodscategory=Utility.getName(request.getParameter("goodscategory"));
		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		request.setAttribute("goodscategory",goodscategory);
		request.setAttribute("iscustomize",iscustomize);
		//新增lvhz end
		
		String kucun = Utility.getName(request.getParameter("kucun"));
		request.setAttribute("kucun",kucun);
		
		GoodsInfoPo po = new GoodsInfoPo();  
		if (Utility.getName(systemParameterPo.getFspstealtheffective()).equals("1")){
			po.setGuaranteeperiod("1");
		}else{
			po.setGuaranteeperiod("0");
		}
		
		if("R".equals(rl)||"".equals(rl)){
			po.setBgisph(TurnSphCyl.changeSph(rsph,rcyl));
			po.setBgicyl(TurnSphCyl.changeCyl(rsph,rcyl));
			po.setBgibelowplusluminosity(radd);
			po.setBgiflag("R");
			po.setBgiunionsphcyl(runionsphcyl);
		}else if("L".equals(rl)){
			po.setBgisph(TurnSphCyl.changeSph(lsph,lcyl));
			po.setBgicyl(TurnSphCyl.changeCyl(lsph,lcyl));
			po.setBgibelowplusluminosity(ladd);
			po.setBgiflag("L");
			po.setBgiunionsphcyl(lunionsphcyl);
		}
		
		po.setBgigoodscategoryid(goodsbar.substring(0,1));
		po.setBgigoodsbarcode(goodsbar);
		po.setBgiwarehouseid(personInfoPo.getDepartmentID());		
		po.setBgiiscustomize((goodsbar.substring(0,1).equals("3") || goodsbar.substring(0,1).equals("4")) ? iscustomize : "");
		po.setBgigoodsquantity(kucun);
		po.setCustomercardtype(customertype);
		po.setBgishopcode(personInfoPo.getDepartmentID());
				
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		
		po.setSystemparameterlevel(systemParameterPo.getFspisusegoodslevel());		
		po.setBgiwhichretail(dpo.getBdpwhichretail());		
		po.setBgicppquerytype(Utility.getName(systemParameterPo.getFspglassischecknumber()));   //判断成品片是否允许负库存
		po.setQueryType(Utility.getName(systemParameterPo.getFspsalestype()));   //判断是否允许负库存
		
		if ((Utility.getName(systemParameterPo.getFspsalestype()).equals("1") && Utility.getName(systemParameterPo.getFspquerygoodsstorage()).equals("1")) || Utility.getName(po.getBgisupplierid()).equals("ZZ")){
			po.setBgiisselectstorage("1");  // 允许负库存的时候或是自架自片，判断查看的商品是否需要绑定库存
		}
		
		if("0".equals(Utility.getName(po.getQueryType()))){  // 不允许负库存
			if(iscustomize.equals("0") && "3".equals(Utility.getName(po.getBgigoodscategoryid())) && Utility.getName(systemParameterPo.getFspglassischecknumber()).equals("1")){   // 成品片是否允许负库存
				po.setBgiisleftorinner("2");  // 1. inner   2.left 
			}else{
				po.setBgiisleftorinner("1");  // 1. inner   2.left 
			}			
		}else{
			if (Utility.getName(po.getBgigoodsquantity()).equals("1")){
				po.setBgiisleftorinner("1");  // 1. inner   2.left 
			}else{
				po.setBgiisleftorinner("2");  // 1. inner   2.left 
			}			
		}	
		
		getExecTime("开始执行");
		if("D".equals(iscustomize)){
			goodsList = sellMirrorFrameMgr.getScanGoodsListNew(po);
		}else{
			goodsList = sellMirrorFrameMgr.getScanGoodsList1New(po);
		}
		getExecTime("执行结束");
		
		return SUCCESS;
	}
	
	/**
	 * 销售页面扫码开窗查询商品（All）
	 */
	public String scanGoodsSelAllNew() throws Exception {
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
		String goodsbar = Utility.getName(request.getParameter("goodsbar"));
		String[] sphs = request.getParameterValues("sph");
		if(sphs == null){
			sphs = new String[2];
			sphs[0] = "n";
			sphs[1] = "n";
		}
		String[] cyls = request.getParameterValues("cyl");
		if(cyls == null){
			cyls = new String[2];
			cyls[0] = "n";
			cyls[1] = "n";
		}
		String[] adds = request.getParameterValues("add");	
		if(adds == null){
			adds = new String[2];
			adds[0] = "n";
			adds[1] = "n";
		}
		String recipeType= Utility.getName(request.getParameter("recipeType"));
		String lrecipeType= Utility.getName(request.getParameter("lrecipeType"));
		String lglassFlag= Utility.getName(request.getParameter("lglassFlag"));
		String glassFlag= Utility.getName(request.getParameter("glassFlag"));
		String lsyjp= Utility.getName(request.getParameter("lsyjp"));
		String syjp= Utility.getName(request.getParameter("syjp"));
		String direction = Utility.getName(request.getParameter("direction"));
		String rl = "".equals(Utility.getName(request.getParameter("rl"))) ? "R":Utility.getName(request.getParameter("rl"));
		
		String rsph = "n".equals(sphs[0]) ? request.getParameter("rsph"):sphs[0];
		String rcyl = "n".equals(cyls[0]) ? request.getParameter("rcyl"):cyls[0];
		String radd = "n".equals(adds[0]) ? request.getParameter("radd"):adds[0];	
		String lsph = "n".equals(sphs[1]) ? request.getParameter("lsph"):sphs[1];
		String lcyl = "n".equals(cyls[1]) ? request.getParameter("lcyl"):cyls[1];
		String ladd = "n".equals(adds[1]) ? request.getParameter("ladd"):adds[1];	
		String customertype = Utility.getName(request.getParameter("customertype"));
		String ordertype = Utility.getName(request.getParameter("ordertype"));
	
		String[] unionsphcyls = request.getParameterValues("unionsphcyl");	
		if(unionsphcyls == null){
			unionsphcyls = new String[2];
			unionsphcyls[0] = "n";
			unionsphcyls[1] = "n";
		}
		
		String runionsphcyl = "";
		String lunionsphcyl = "";
		if (unionsphcyls.length >= 1){
			runionsphcyl = "n".equals(unionsphcyls[0]) ? request.getParameter("runionsphcyl"):unionsphcyls[0];
		}
		if (unionsphcyls.length > 1){
			lunionsphcyl = "n".equals(unionsphcyls[1]) ? request.getParameter("lunionsphcyl"):unionsphcyls[1];
		}
		
		request.setAttribute("customertype", customertype);
		request.setAttribute("rl",rl);
		request.setAttribute("goodsbar",goodsbar);
		request.setAttribute("rsph",rsph);
		request.setAttribute("rcyl",rcyl);
		request.setAttribute("radd",radd);
		request.setAttribute("lsph",lsph);
		request.setAttribute("lcyl",lcyl);
		request.setAttribute("ladd",ladd);
		request.setAttribute("recipeType",recipeType );
		request.setAttribute("lrecipeType",lrecipeType );
		request.setAttribute("lglassFlag",lglassFlag );
		request.setAttribute("lsyjp",lsyjp );
		request.setAttribute("glassFlag",glassFlag );
		request.setAttribute("syjp",syjp );  //商品名称
		request.setAttribute("goodscategory",goodsbar.substring(0,1));  //商品名称
		request.setAttribute("direction",direction);
		request.setAttribute("runionsphcyl",runionsphcyl);
		request.setAttribute("lunionsphcyl",lunionsphcyl);
		
		//新增lvhz begin
		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		request.setAttribute("iscustomize",iscustomize);
		//新增lvhz end
		
		String kucun = Utility.getName(request.getParameter("kucun"));
		request.setAttribute("kucun",kucun);
		
		GoodsInfoPo po = new GoodsInfoPo(); 
		
		if(ordertype.equals("1")&&goodsbar.substring(0,1).equals("8")){
			
		}else{
			if("R".equals(rl)||"".equals(rl)){
				po.setBgisph(TurnSphCyl.changeSph(rsph,rcyl));
				po.setBgicyl(TurnSphCyl.changeCyl(rsph,rcyl));
				po.setBgibelowplusluminosity(radd);
				po.setBgiflag("R");
				po.setBgiunionsphcyl(runionsphcyl);
			}else if("L".equals(rl)){
				po.setBgisph(TurnSphCyl.changeSph(lsph,lcyl));
				po.setBgicyl(TurnSphCyl.changeCyl(lsph,lcyl));
				po.setBgibelowplusluminosity(ladd);
				po.setBgiflag("L");
				po.setBgiunionsphcyl(lunionsphcyl);
			}else if("8".equals(goodsbar.substring(0,1))){
				po.setBgisph(rsph);
				po.setBgisph(lsph);
			}
		}
		
		po.setBgigoodscategoryid(goodsbar.substring(0,1));
		po.setBgigoodsbarcode(goodsbar);
		po.setBgiwarehouseid(personInfoPo.getDepartmentID());		
		po.setBgiiscustomize((goodsbar.substring(0,1).equals("3") || goodsbar.substring(0,1).equals("4")) ? iscustomize : "");
		po.setBgigoodsquantity(kucun);
		po.setCustomercardtype(customertype);
		po.setBgishopcode(personInfoPo.getDepartmentID());
				
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		
		po.setBgiwhichretail(dpo.getBdpwhichretail());
		po.setSystemparameterlevel(systemParameterPo.getFspisusegoodslevel());			
		po.setQueryType(Utility.getName(systemParameterPo.getFspsalestype()));   //判断是否允许负库存
		po.setBgicppquerytype(Utility.getName(systemParameterPo.getFspglassischecknumber()));   //判断成品片是否允许负库存
		
		if ((Utility.getName(systemParameterPo.getFspsalestype()).equals("1") && Utility.getName(systemParameterPo.getFspquerygoodsstorage()).equals("1")) || Utility.getName(po.getBgisupplierid()).equals("ZZ")){
			po.setBgiisselectstorage("1");  // 允许负库存的时候或是自架自片，判断查看的商品是否需要绑定库存
		}
		
		if("0".equals(Utility.getName(po.getQueryType()))){  // 不允许负库存
			if(iscustomize.equals("0") && "3".equals(Utility.getName(po.getBgigoodscategoryid())) && Utility.getName(systemParameterPo.getFspglassischecknumber()).equals("1")){   // 成品片是否允许负库存
				po.setBgiisleftorinner("2");  // 1. inner   2.left 
			}else{
				po.setBgiisleftorinner("1");  // 1. inner   2.left 
			}			
		}else{
			if (Utility.getName(po.getBgigoodsquantity()).equals("1")){
				po.setBgiisleftorinner("1");  // 1. inner   2.left 
			}else{
				po.setBgiisleftorinner("2");  // 1. inner   2.left 
			}			
		}	
				
		getExecTime("开始执行");
		goodsList = sellMirrorFrameMgr.getScanGoodsListNew(po);
		getExecTime("执行结束");
		
		return SUCCESS;
	}
	
	private void getExecTime(String msg){
		/*
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(msg + ":" + currMouthFirstDay.format(calendar.getTime()));
		*/
	}
	
}
