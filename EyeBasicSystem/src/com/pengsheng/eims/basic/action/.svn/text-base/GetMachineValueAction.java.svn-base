package com.pengsheng.eims.basic.action;

import com.pengsheng.eims.basic.mgr.GetMachineValuesMgr;
import com.pengsheng.eims.basic.persistence.ApparatusPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class GetMachineValueAction extends BaseAction{
	private ApparatusPo apparatusPo;
	private GetMachineValuesMgr getMachineValuesMgr;
	
	public String initGetMachineValue() throws Exception{
		apparatusPo = getMachineValuesMgr.selectGetMachineValues(null);
		return SUCCESS;
	}
	
	public String updateGetMachineValue() throws Exception{
		getMachineValuesMgr.updateGetMachineValues(apparatusPo);
		if(Utility.getName(apparatusPo.getNidekortopcon()).equals("t")){
			apparatusPo = getMachineValuesMgr.getTOPCON(Utility.getName(apparatusPo.getNidekortopconstr()), apparatusPo);
		}else if(Utility.getName(apparatusPo.getNidekortopcon()).equals("n")){
			apparatusPo = getMachineValuesMgr.getNIDEK(Utility.getName(apparatusPo.getNidekortopconstr()), apparatusPo);
		}
		
		String nidekortopcon = Utility.getName(request.getParameter("apparatusPo.nidekortopcon"));
		String nidek = Utility.getName(request.getParameter("apparatusPo.nidek"));
		String topcon = Utility.getName(request.getParameter("apparatusPo.topcon"));
		String nidekortopconstr = Utility.getName(request.getParameter("apparatusPo.nidekortopconstr"));
		
		apparatusPo.setNidekortopcon(nidekortopcon);
		apparatusPo.setNidekortopconstr(nidekortopconstr);
		
		return SUCCESS;
	}

	public ApparatusPo getApparatusPo() {
		return apparatusPo;
	}

	public void setApparatusPo(ApparatusPo apparatusPo) {
		this.apparatusPo = apparatusPo;
	}

	public GetMachineValuesMgr getGetMachineValuesMgr() {
		return getMachineValuesMgr;
	}

	public void setGetMachineValuesMgr(GetMachineValuesMgr getMachineValuesMgr) {
		this.getMachineValuesMgr = getMachineValuesMgr;
	}
	
}
