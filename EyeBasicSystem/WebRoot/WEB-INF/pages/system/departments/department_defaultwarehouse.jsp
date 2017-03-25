<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
#１ {
	color: #F00;
}
#tabContent__1 div .privateBorder tbody .row td #１ {
	font-size: 14px;
}
#tabContent__1 div .privateBorder tbody .row td #１ {
	font-size: 18px;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门维护</title>
</head>
<script>	

	function save(){
		if(checkForm(departmentsForm)){ 
			$("img").removeAttr("onclick");
			departmentsForm.action = "defaultWarehouse.action?hid="+$('#departmentid').val();
			departmentsForm.submit();
		}
	}

	//下属仓位配置
    function setPuisneWarehouse(){
    	departmentsForm.action = "initPuisneWarehouse.action";
	    departmentsForm.submit();
    }    
    
    //门店销售商品出仓配置
    function setGoodsOutWarehouse(){
        departmentsForm.action = "initGoodsOutWarehouse.action";
	    departmentsForm.submit();
    }
    
    //部门修改
    function departmentsUpdate(){
        departmentsForm.action = "initDepartmentsUpdate.action";
	    departmentsForm.submit();
    }
    
    //门店销售商品入仓配置
    function setGoodsInWarehouse(){
        departmentsForm.action = "initGoodsInWarehouse.action";
	    departmentsForm.submit();
    }

    //门店单据模版配置
    function setBillTemplate(){
        departmentsForm.action = "initBillTemplate.action";
	    departmentsForm.submit();
    }     
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="departmentsForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif><TABLE cellSpacing=0 cellPadding=0 border=0>
            <TBODY>
              <TR>
                <!--?Start-->
                <TD><TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                  <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 

                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD width="100" align="center" class=tab id=tabLabel__0 
                      onclick="departmentsUpdate();"
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">部门修改</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3 ></TD>
                    </TR>
                  </TBODY>
                </TABLE></TD>
                <TD><TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                      <TR>
                        <TD width=3><IMG id=tabImgLeft__0 height=22 

                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        <TD width="100" align="center" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="setPuisneWarehouse();"
                      UNSELECTABLE="on">下属仓位配置</TD>
                        <TD width=3><IMG id=tabImgRight__0 height=22 
                      
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3 ></TD>
                      </TR>
                    </TBODY>
                </TABLE></TD>
                <TD width=3><IMG id=tabImgLeft__0 height=22 

                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD width="120" align="center" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">仓位列表默认值配置</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22                       
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3 ></TD>
                    
                <TD><TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                      <TR>
                      <c:if test="${departmentsPo.bdptype=='1'}">
                        <TD width=3><IMG id=tabImgLeft__0 height=22                                                             
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        
                        <TD width="100" align="center" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="setGoodsOutWarehouse();"
                      UNSELECTABLE="on">门店仓位配置</TD>
                      
                        <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3 ></TD>
                     </c:if>
                      </TR>
                    </TBODY>
                </TABLE></TD>
  				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                        <TD width=3><IMG id=tabImgLeft__0 height=22                                                             
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>                        
                        <TD width="100" align="center" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="setBillTemplate();"
                      UNSELECTABLE="on">单据模版配置</TD>
                        <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3 ></TD>                   
                    </TR>
                    </TBODY>
                  </TABLE>
                 </TD>
					</TR></TBODY></TABLE></TD>	
					</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="10%" height="30" class="table_body">部门编码</TD>
                          <TD width="23%" class="table_none">${departmentsPo.bdpdepartmentid }<input type="hidden" id="departmentid" name="departmentsPo.bdpdepartmentid" value="${departmentsPo.bdpdepartmentid }"></TD>
                          <TD width="10%" height="30" class="table_body">部门名称</TD>
                          <TD width="23%" height="30" class="table_none">${departmentsPo.bdpdepartmentname }</TD>
                          <TD width="10%" height="30" class="table_body">部门类型</TD>
                          <TD width="24%" class="table_none">
                            <c:choose>
                          			<c:when test="${departmentsPo.bdptype == '1' }">销售门店</c:when>
                          			<c:when test="${departmentsPo.bdptype == '2' }">加工中心</c:when>
                          			<c:when test="${departmentsPo.bdptype == '3' }">总仓库房</c:when>
                          			<c:when test="${departmentsPo.bdptype == '4' }">财务</c:when>
                          			<c:when test="${departmentsPo.bdptype == '5' }">其他</c:when>
                          			<c:when test="${departmentsPo.bdptype == '6' }">人事部门 </c:when>
                            </c:choose>
                            <input type="hidden" name="departmentsPo.bdptype" value="${departmentsPo.bdptype }">
                          </TD>
                        </TR>
                      <div name="cwxz"> </div>
                    </TABLE>
                    </br>
                    <c:if test="${departmentsPo.bdptype=='1' || departmentsPo.bdptype=='2' || departmentsPo.bdptype=='3'}">
                    <table width="100%" id="title2"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    </c:if>
                    <c:if test="${departmentsPo.bdptype=='1' || departmentsPo.bdptype=='2'}">
					<table id="table1" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="30%"  height="30" align="center" scope=col>仓位列表类型</TH>
                          <TH scope=col width="70%">默认仓位</TH>
                        </TR>
                        <TR class="row">
                          <TD  height="28" align="center">商品调拨接收仓位</TD>
                          <TD><SELECT  id="bwcstockid1" name="warehouseConfigurationPo.bwcstockid1" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取商品调拨接收仓位！'}]">
                              <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid1 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
                        </TR>
                        <TR class="row">
                          <TD  height="28" align="center">商品负调拨发出仓位</TD>
                          <TD><SELECT  id="bwcstockid2" name="warehouseConfigurationPo.bwcstockid2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取商品负调拨发出仓位！'}]">
                              <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid2 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
                        </TR>
                        <TR class="row">
                          <TD  height="28" colspan="2" align="center"><strong id="１">×温馨提示：设置仓位列表默认值。 </strong></TD>
                          </TR>
                      </TBODY>
                    </TABLE>
                    </c:if>
                    <c:if test="${departmentsPo.bdptype=='3'}">
                    <table  id="table2" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="30%"  height="30" align="center" scope=col>仓位列表类型</TH>
                          <TH scope=col width="70%">默认仓位</TH>
                        </TR>
                        <TR class="row">
                          <TD  height="28" align="center">采购收货收入仓位</TD>
                          <TD><SELECT  id="bwcstockid3" name="warehouseConfigurationPo.bwcstockid3">
                            <option value="">----请选择----</option>
                           <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid3 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
                        </TR>
                        <TR class="row">
                          <TD  height="28" align="center">委外收货收入仓位</TD>
                          <TD><SELECT  id="bwcstockid4" name="warehouseConfigurationPo.bwcstockid4">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid4 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
                        </TR>
                        <TR class="row">
                          <TD  height="28" align="center">其他入库收入仓位</TD>
                          <TD><SELECT  id="bwcstockid5" name="warehouseConfigurationPo.bwcstockid5">
                            <option value="">----请选择----</option>
                           <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid5 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>                            
                          </SELECT></TD>
                        </TR>
                        <TR class="row">
                          <TD  height="28" align="center">其他出库发出仓位</TD>
                          <TD><SELECT  id="bwcstockid6" name="warehouseConfigurationPo.bwcstockid6" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取其他出库发出仓位！'}]">
                            <option value="">----请选择----</option>
                           <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid6 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>                           
                          </SELECT></TD>
                        </TR>
                        <TR class="row">
                          <TD  height="28" align="center">商品退货发出仓位</TD>
                          <TD><SELECT  id="bwcstockid7" name="warehouseConfigurationPo.bwcstockid7" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取商品退货发出仓位！'}]">
                            <option value="">----请选择----</option>
                           <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid7 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>                          
                          </SELECT></TD>
                        </TR>
                        <TR class="row">
                          <TD  height="28" align="center">销售出库发出仓位</TD>
                          <TD><SELECT  id="bwcstockid8" name="warehouseConfigurationPo.bwcstockid8" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取销售出库发出仓位！'}]">
                            <option value="">----请选择----</option>
                           <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid8 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>                           
                          </SELECT></TD>
                        </TR>
                        <TR class="row">
                          <TD  height="28" align="center">商品调拨发出仓位</TD>
                          <TD><SELECT  id="bwcstockid9" name="warehouseConfigurationPo.bwcstockid9" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取商品调拨发出仓位！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid9 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
                        </TR>
                        <TR class="row">
                          <TD  height="28" align="center">客户批发调拨发出仓位</TD>
                          <TD>
                          <SELECT  id="bwcstockid10" name="warehouseConfigurationPo.bwcstockid10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取客户批发调拨发出仓位！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid10 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT>
                          </TD>
                        </TR>
                        <TR class="row">
                          <TD  height="28" align="center">不合格品调拨接收仓位</TD>
                          <TD>
                          <SELECT  id="bwcstockid11" name="warehouseConfigurationPo.bwcstockid11" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取不合格品调拨接收仓位！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid11 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT>
                          </TD>
                        </TR>
                        <TR class="row">
                          <TD  height="28" colspan="2" align="center"><strong id="１">×温馨提示：设置仓位列表默认值。 </strong></TD>
                          </TR>
                      </TBODY>
                    </TABLE>
                    </c:if>
                    <c:if test="${departmentsPo.bdptype=='1' || departmentsPo.bdptype=='2' || departmentsPo.bdptype=='3'}">
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                        <c:if test="${(permissionPo.keyj==1)}">  
                          <TD><input icon='icon-save' id="submitButton" type='button' value='保存' onclick="save();">
						 <input icon='icon-reload' type="reset" value="清空">
                          </TD>
                          </c:if>
                        </TR>
                      </TBODY>
                   </c:if>
              </TABLE>
                
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
  

