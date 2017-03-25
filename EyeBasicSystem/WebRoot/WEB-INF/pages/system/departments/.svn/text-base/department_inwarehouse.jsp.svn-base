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
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
	
	function save(){
		if(checkForm(departmentsForm)){
			$("img").removeAttr("onclick");
			departmentsForm.action = "updateInWarehouseConfiguration.action";
			departmentsForm.submit();
		}
	}
	
	//下属仓位配置
    function setPuisneWarehouse(){
    	departmentsForm.action = "initPuisneWarehouse.action";
	    departmentsForm.submit();
    }    
    
    //仓位列表默认值配置
    function setDefaultWarehouse(){
        departmentsForm.action = "initDefaultWarehouse.action";
	    departmentsForm.submit();
    }
    
    //部门修改
    function departmentsUpdate(){
        departmentsForm.action = "initDepartmentsUpdate.action";
	    departmentsForm.submit();
    }
    
    //门店销售商品出仓配置
    function setGoodsOutWarehouse(){
        departmentsForm.action = "initGoodsOutWarehouse.action";
	    departmentsForm.submit();
    }

    function search()
    {
    	document.all.bwcstockid1.value =document.all.warehouse.value;
    	document.all.bwcstockid2.value =document.all.warehouse.value;
    	document.all.bwcstockid3.value =document.all.warehouse1.value;
    	document.all.bwcstockid4.value =document.all.warehouse1.value;
    	document.all.bwcstockid5.value =document.all.warehouse1.value;
    	document.all.bwcstockid6.value =document.all.warehouse1.value;
    	document.all.bwcstockid7.value =document.all.warehouse.value;
    	document.all.bwcstockid8.value =document.all.warehouse.value;
    	document.all.bwcstockid9.value =document.all.warehouse.value;
    	document.all.bwcstockid10.value =document.all.warehouse.value;
    	document.all.bwcstockid11.value =document.all.warehouse.value;
    	document.all.bwcstockid12.value =document.all.warehouse.value;
    	document.all.bwcstockid13.value =document.all.warehouse.value;
    }
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="departmentsForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="warehouse" value="${warehousePo.bwhid}">
<input type="hidden" name="warehouse1" value="${warehousePo1.bwhid}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      onclick="departmentsUpdate();"
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">部门修改</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3 ></TD></TR></TBODY></TABLE></TD>                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 

                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="setPuisneWarehouse();"
                      UNSELECTABLE="on">下属仓位配置</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                      
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3 ></TD></TR></TBODY></TABLE></TD>
			<c:if test="${departmentsPo.bdptype=='3'}">		
					<TD class=tab id=tabLabel__1 onclick="setDefaultWarehouse();"                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">仓位列表默认值配置</TD>	
            </c:if>          				
					<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                                                            
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="setGoodsOutWarehouse();"
                      UNSELECTABLE="on">门店销售商品出仓配置</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3 ></TD></TR></TBODY></TABLE></TD>
                  
                                 <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <c:if test="${departmentsPo.bdptype=='1'}">
                        <TD width=3><IMG id=tabImgLeft__0 height=22                                                             
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                        
                        <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif                       
                      UNSELECTABLE="on">门店销售商品退款配置</TD>
                      </c:if>
                        <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3 ></TD>
                    
					</TR></TBODY></TABLE></TD>	
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
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
                          <TD width="8%" height="26" class="table_body">部门编码</TD>
                          <TD width="23%" class="table_none">${departmentsPo.bdpdepartmentid }<input type="hidden" name="departmentsPo.bdpdepartmentid" value="${departmentsPo.bdpdepartmentid }">
                          <input type="hidden" name="warehouseConfigurationPo.bwcdeptid" value="${departmentsPo.bdpdepartmentid }">
                          </TD>
                          <TD width="8%" height="26" class="table_body">部门名称</TD>
                          <TD width="23%" height="26" class="table_none">${departmentsPo.bdpdepartmentname }</TD>
                          <TD width="8%" height="26" class="table_body">部门类型</TD>
                          <TD class="table_none">
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
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
		                     <img src="${ctx }/img/newbtn/btn_tjpz_0.png" btn=btn title='推荐配置' onClick="javascript:search()">
							</td>
						</tr>
					</table>
                   
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="30%"  height="26" align="center" scope=col>商品类别</TH>
                          <TH scope=col width="70%">出库仓位</TH>
                        </TR>
                        <TR class="row">
                          <TD  height="26" align="center">镜架</TD>
                          <TD><SELECT  id="bwcstockid1" name="warehouseConfigurationPo.bwcstockid1" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '镜架出仓仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid1 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
                        </TR>
                        <TR class="row">
                          <TD  height="26" align="center">配件</TD>
                          <TD><SELECT  id="bwcstockid2" name="warehouseConfigurationPo.bwcstockid2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '配件出仓仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid2 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
                        </TR>
                        <TR class="row">
                          <TD  height="26" align="center">成品镜片</TD>
                          <TD><SELECT  id="bwcstockid3" name="warehouseConfigurationPo.bwcstockid3" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '成品镜片出仓仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid3 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
                        </TR>
                        <TR class="row">
                          <TD  height="26" align="center">订做镜片</TD>
                          <TD><SELECT  id="bwcstockid4" name="warehouseConfigurationPo.bwcstockid4" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '订做镜片出仓仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid4 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
                        </TR>
                        <TR class="row">
                          <TD  height="26" align="center">隐形成品镜片</TD>
                          <TD><SELECT  id="bwcstockid5" name="warehouseConfigurationPo.bwcstockid5" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '隐形成品镜片出仓仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid5 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
                        </TR>
                        <TR class="row">
                          <TD  height="26" align="center">隐形订做镜片</TD>
                          <TD><SELECT  id="bwcstockid6" name="warehouseConfigurationPo.bwcstockid6" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '隐形订做镜片出仓仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid6 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
                        </TR>
                        <TR class="row">
                          <TD  height="26" align="center">隐形护理液</TD>
                          <TD><SELECT  id="bwcstockid7" name="warehouseConfigurationPo.bwcstockid7" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '隐形护理液出仓仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid7 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
                        </TR>
                        <TR class="row">
                          <TD  height="26" align="center">太阳镜</TD>
                          <TD><SELECT  id="bwcstockid8" name="warehouseConfigurationPo.bwcstockid8" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '太阳镜出仓仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid8 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
                        </TR>
                         <TR class="row">
                          <TD  height="26" align="center">老花镜</TD>
                          <TD><SELECT  id="bwcstockid11" name="warehouseConfigurationPo.bwcstockid11" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '老花镜出仓仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid11 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
                        </TR>
                        <TR class="row">
                          <TD  height="26" align="center">耗材</TD>
                          <TD><SELECT  id="bwcstockid9" name="warehouseConfigurationPo.bwcstockid9" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '耗材出仓仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid9 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
                        </TR>
                         <TR class="row">
                          <TD  height="26" align="center">视光</TD>
                          <TD><SELECT  id="bwcstockid12" name="warehouseConfigurationPo.bwcstockid12" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '视光出仓仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid12 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
                        </TR>
                        <TR class="row">
                          <TD  height="26" align="center">赠品类</TD>
                          <TD><SELECT  id="bwcstockid10" name="warehouseConfigurationPo.bwcstockid10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '赠品类出仓仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid10 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
                        </TR>
                       <TR class="row">
                          <TD  height="26" align="center">积分兑换类</TD>
                          <TD><SELECT  id="bwcstockid13" name="warehouseConfigurationPo.bwcstockid13" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '积分兑换类出仓仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid13 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
                        </TR>
                        <TR class="row">
                          <TD  height="26" colspan="2" align="center"><strong id="１">×温馨提示：商品将会在关联的仓库增加库存。 </strong></TD>
                          </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                        <c:if test="${(permissionPo.keyk==1)}">  
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save();">
						 <!-- <input icon='icon-reload' type="reset" value="清空" > -->						  
                          </TD>
                        </c:if>	
                        </TR>
                      </TBODY>
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
  

