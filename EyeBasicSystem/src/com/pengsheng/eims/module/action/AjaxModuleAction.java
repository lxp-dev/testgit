package com.pengsheng.eims.module.action;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.jsonplugin.annotations.JSON;
import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class AjaxModuleAction extends BaseAction {

	private PersonInfoMgr personInfoMgr;
	private BrandMgr brandMgr;
	private List<String> personAjax;
	private String result;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}

	public void setBrandMgr(BrandMgr brandMgr) {
		this.brandMgr = brandMgr;
	}
	
	@JSON(name = "personAjax")
	public List<String> getPersonAjax() {
		return personAjax;
	}

	public void setPersonAjax(List<String> personAjax) {
		this.personAjax = personAjax;
	}

	
	/**
	 * 查询会员人群列表
	 */
	public String selPersonInfoAll() throws Exception {
		
		String selResult = request.getParameter("q");

		List<PersonInfoPo> peronInfoPos = personInfoMgr.getPersonList(selResult);

		personAjax = new ArrayList<String>();

		for (int i = 0; i < peronInfoPos.size(); i++) {
			personAjax.add(peronInfoPos.get(i).getPersonName() + " ("
					+ peronInfoPos.get(i).getId() + ")");
		}

		return SUCCESS;
	}

	public String getPersonRepeat() throws Exception
	{

		String id = Utility.getName(request.getParameter("id"));
		PersonInfoPo personInfoPo=new PersonInfoPo();
		personInfoPo.setId(id);
		PersonInfoPo personInfoPo1=personInfoMgr.getPersonInfo(personInfoPo);
//		int temp=mPersonInfoMgr.getPersonRepeat(id);

		if(personInfoPo1.getId()==null)
		{
			result="false";
		}else
		{
			result="true";
		}
		
		return SUCCESS;
	}

	/**
	 * 查询制造商列表
	 */
	public String selSupplierInfoAll() throws Exception {
		
		String selResult = Utility.getName(request.getParameter("q"));

		List<SupplierPo> supplierPos = personInfoMgr.getSupplierList(selResult);

		personAjax = new ArrayList<String>();

		for (int i = 0; i < supplierPos.size(); i++) {
			personAjax.add(supplierPos.get(i).getBspsuppliername() + " ("+ supplierPos.get(i).getBspid() + ")");
		}

		return SUCCESS;
	}
	
	/**
	 * 查询品种列表
	 */
	public String ajaxSelBrandList() throws Exception {
		
		String selResult = Utility.getName(request.getParameter("q"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		personAjax = new ArrayList<String>();
		
		if(!goodscategoryID.equals("")){
			BrandPo brandPo = new BrandPo();
			brandPo.setBspcategoryid(goodscategoryID);
			brandPo.setBbdsupplierid(supplierID);
			brandPo.setBbdbrandname(selResult);
			
			List<BrandPo> brandPos = brandMgr.getAjaxBrands_ByName(brandPo);

			

			for (int i = 0; i < brandPos.size(); i++) {
				personAjax.add(brandPos.get(i).getBbdbrandname() + " ("+ brandPos.get(i).getBbdid() + ")");
			}
		}
		

		return SUCCESS;
	}

}
