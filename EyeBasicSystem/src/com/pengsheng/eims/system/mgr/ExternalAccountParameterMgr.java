package com.pengsheng.eims.system.mgr;

import java.util.List;

import com.pengsheng.eims.system.persistence.ExternalAccountParameterPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface ExternalAccountParameterMgr {
	public List<PersonInfoPo> exportPersonInfo(PersonInfoPo personInfoPo);
	public void insertExternalAccountParameter(ExternalAccountParameterPo po);
	public ExternalAccountParameterPo getExternalAccountParameterPo(ExternalAccountParameterPo po);
	public void deleteExternalAccountParameter(ExternalAccountParameterPo po);
}
