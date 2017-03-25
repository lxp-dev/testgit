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
			if($('select[id=bwcstockid1]').val() == $('select[id=bwcstockid13]').val()){
				alert("镜架出仓配置不能配置相同仓位！");
				return;
			}
			
			$("img").removeAttr("onclick");
			departmentsForm.action = "updateGoodsOutWarehouse.action";
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

    function search(){
    	document.all.bwcstockid1.value =document.all.warehouse.value;
    	document.all.bwcstockid2.value =document.all.warehouse.value;
    	document.all.bwcstockid3.value =document.all.warehouse1.value;
    	document.all.bwcstockid4.value =document.all.warehouse1.value;
    	document.all.bwcstockid5.value =document.all.warehouse.value;
    	document.all.bwcstockid6.value =document.all.warehouse.value;
    	document.all.bwcstockid7.value =document.all.warehouse.value;
    	document.all.bwcstockid8.value =document.all.warehouse.value;
    	document.all.bwcstockid9.value =document.all.warehouse.value;
    	document.all.bwcstockid10.value =document.all.warehouse.value;
    	document.all.bwcstockid11.value =document.all.warehouse.value;
    	document.all.bwcstockid12.value =document.all.warehouse.value;
    	document.all.bwcstockid13.value ='';
    	document.all.bwcstockid14.value =document.all.warehouse.value;
    	document.all.bwcstockid15.value =document.all.warehouse.value;
    	
    	document.all.tbwcstockid1.value =document.all.warehouse.value;
    	document.all.tbwcstockid2.value =document.all.warehouse.value;
    	document.all.tbwcstockid3.value =document.all.warehouse.value;
    	document.all.tbwcstockid4.value =document.all.warehouse.value;
    	document.all.tbwcstockid5.value =document.all.warehouse.value;
    	document.all.tbwcstockid6.value =document.all.warehouse.value;
    	document.all.tbwcstockid7.value =document.all.warehouse.value;
    	document.all.tbwcstockid8.value =document.all.warehouse.value;
    	document.all.tbwcstockid9.value =document.all.warehouse.value;
    	document.all.tbwcstockid10.value =document.all.warehouse.value;
    	document.all.tbwcstockid11.value =document.all.warehouse.value;
    	document.all.tbwcstockid12.value =document.all.warehouse.value;
    	document.all.tbwcstockid13.value =document.all.warehouse.value;
    	document.all.tbwcstockid15.value =document.all.warehouse.value;
    	
    	document.getElementById("bwcxiaocangzp").value = "1";
    	document.getElementById("bwcxiaocangzp2").value = "1";

    	document.getElementById("bwcxiaocangww").value = "2";
    }

    //HIS配置
    function setHis(){
        departmentsForm.action = "initHisSet.action";
	    departmentsForm.submit();
    }
    
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="departmentsForm" method="post" action="">
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
                      <TD width="100" align="center" class=tab id=tabLabel__0 
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
                      <TD width="100" align="center" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="setPuisneWarehouse();"
                      UNSELECTABLE="on">下属仓位配置</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                      
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3 ></TD></TR></TBODY></TABLE></TD>
			<c:if test="${departmentsPo.bdptype=='3'}">		
					<TD width="120" align="center" class=tab id=tabLabel__1 onclick="setDefaultWarehouse();"                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">仓位列表默认值配置</TD>	
            </c:if>          				
					<TD>
					
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                                                            
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD width="100" align="center" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">门店仓位配置</TD>
                     <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3 ></TD></TR></TBODY></TABLE></TD>
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
                 
              <c:if test="${departmentsPo.bdptype == '1' && systemParameterPo.fsphisflag == '2'}">  
                 <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                        <TD width=3><IMG id=tabImgLeft__0 height=22                                                             
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>                        
                        <TD width="100" align="center" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="setHis();"
                      UNSELECTABLE="on">HIS系统配置</TD>
                        <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3 ></TD>                   
                    </TR>
                    </TBODY>
                  </TABLE>
                 </TD> 
              </c:if>
              
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
                          <input type="hidden" name="inWarehouseConfigurationPo.bwcdeptid" value="${departmentsPo.bdpdepartmentid }">
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
                       <TR class=table_title>
						  <TH scope=col width="10%" height="26">商品类别</TH>
                          <TH scope=col width="40%" >销售仓位</TH>
                          <TH scope=col width="35%" >退款仓位</TH>
                          <TH scope=col width="15%" >消仓点</TH>
                          </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD height="26">镜架</TD>
                          <TD align="center">
                                <SELECT  id="bwcstockid1" name="warehouseConfigurationPo.bwcstockid1" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '镜架销售仓位不能为空！'}]"> 
                             		<OPTION value="">----请选择----</OPTION>
	                             	<c:if test="${not empty(warehouseList)}">
					               	  <s:iterator value="warehouseList">
	                    	           <OPTION value="${bwhid}" ${warehouseConfigurationPo.bwcstockid1 != bwhid ? '' : 'selected="selected"' } >${bwhwarehouseName}</OPTION>
	                    	          </s:iterator>
	                    	        </c:if>
									</SELECT><label style="color:red;">&nbsp;*</label>
									<SELECT  id="bwcstockid13" name="warehouseConfigurationPo.bwcstockid13">
	                            <option value="">----请选择----</option>
	                            <s:iterator value="warehouseList">
	                                <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid13 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	                            </s:iterator>
	                          </SELECT><label style="color:red;">第二项配置为备用仓位（非必填项）。</label>
                          </TD>
                          <TD>
                           <SELECT  id="tbwcstockid1" name="inWarehouseConfigurationPo.bwcstockid1" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '镜架退款仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${inWarehouseConfigurationPo.bwcstockid1 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
	                      <TD align="center">&nbsp;</TD>                          
                          </TR>
                         <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD  height="26">配件</TD>
                          <TD align="center">
                                  <SELECT  id="bwcstockid2" name="warehouseConfigurationPo.bwcstockid2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '配件销售仓位不能为空！'}]"> 
                             		<OPTION value="">----请选择----</OPTION>
	                             	<c:if test="${not empty(warehouseList)}">
					               	  <s:iterator value="warehouseList">
	                    	           <OPTION value="${bwhid}" ${warehouseConfigurationPo.bwcstockid2 != bwhid ? '' : 'selected="selected"' } >${bwhwarehouseName}</OPTION>
	                    	          </s:iterator>
	                    	        </c:if>
									</SELECT><label style="color:red;">&nbsp;*</label>
                          </TD>                   
                          <TD><SELECT  id="tbwcstockid2" name="inWarehouseConfigurationPo.bwcstockid2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '配件退款仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${inWarehouseConfigurationPo.bwcstockid2 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>   
	                      <TD align="center">&nbsp;</TD>                                                
                          </TR>
						  <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD  height="26">成品镜片</TD>
                          <TD align="center">
                                  <SELECT  id="bwcstockid3" name="warehouseConfigurationPo.bwcstockid3" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '成品镜片销售仓位不能为空！'}]"> 
                             		<OPTION value="">----请选择----</OPTION>
	                             	<c:if test="${not empty(warehouseList)}">
					               	  <s:iterator value="warehouseList">
	                    	           <OPTION value="${bwhid}" ${warehouseConfigurationPo.bwcstockid3 != bwhid ? '' : 'selected="selected"' } >${bwhwarehouseName}</OPTION>
	                    	          </s:iterator>
	                    	        </c:if>
									</SELECT><label style="color:red;">&nbsp;*</label>
                          </TD>                      
                          <TD><SELECT  id="tbwcstockid3" name="inWarehouseConfigurationPo.bwcstockid3" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '成品镜片退款仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${inWarehouseConfigurationPo.bwcstockid3 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD> 
	                      <TD align="center">&nbsp;</TD>                          
                          </TR>
						  <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD  height="26">订做镜片</TD>
                          <TD align="center">
                                  <SELECT  id="bwcstockid4" name="warehouseConfigurationPo.bwcstockid4" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '订做镜片销售仓位不能为空！'}]"> 
                             		<OPTION value="">----请选择----</OPTION>
	                             	<c:if test="${not empty(warehouseList)}">
					               	  <s:iterator value="warehouseList">
	                    	           <OPTION value="${bwhid}" ${warehouseConfigurationPo.bwcstockid4 != bwhid ? '' : 'selected="selected"' } >${bwhwarehouseName}</OPTION>
	                    	          </s:iterator>
	                    	        </c:if>
									</SELECT><label style="color:red;">&nbsp;*</label>
                          </TD>
                          <TD><SELECT  id="tbwcstockid4" name="inWarehouseConfigurationPo.bwcstockid4" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '订做镜片退款仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${inWarehouseConfigurationPo.bwcstockid4 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>  
	                      <TD align="center">
                          	<SELECT  id="bwcxiaocangww" name="warehouseConfigurationPo.bwcxiaocangww" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '订做镜片出仓点不能为空！'}]">
	                            <option value="">----请选择----</option>
	                            <option value="1" ${warehouseConfigurationPo.bwcxiaocangww == '1' ? 'selected="selected"' : '' }>委外收货</option>
	                            <option value="2" ${warehouseConfigurationPo.bwcxiaocangww == '2' ? 'selected="selected"' : '' }>库房发料</option>
                            </SELECT><label style="color:red;">&nbsp;*</label>
                          </TD>                                                  
                          </TR>
						  <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD  height="26">隐形成品镜片</TD>
                          <TD align="center">
                               <SELECT  id="bwcstockid5" name="warehouseConfigurationPo.bwcstockid5" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '隐形成品镜片销售仓位不能为空！'}]"> 
                             		<OPTION value="">----请选择----</OPTION>
	                             	<c:if test="${not empty(warehouseList)}">
					               	  <s:iterator value="warehouseList">
	                    	           <OPTION value="${bwhid}" ${warehouseConfigurationPo.bwcstockid5 != bwhid ? '' : 'selected="selected"' } >${bwhwarehouseName}</OPTION>
	                    	          </s:iterator>
	                    	        </c:if>
									</SELECT><label style="color:red;">&nbsp;*</label>
                          </TD>
                          <TD><SELECT  id="tbwcstockid5" name="inWarehouseConfigurationPo.bwcstockid5" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '隐形成品镜片退款仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${inWarehouseConfigurationPo.bwcstockid5 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
	                      <TD align="center">&nbsp;</TD>                                                   
                          </TR>
						  <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD  height="26">隐形订做镜片</TD>
						  <TD align="center">
						  	<SELECT  id="bwcstockid6" name="warehouseConfigurationPo.bwcstockid6" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '隐形订做镜片销售仓位不能为空！'}]"> 
                             		<OPTION value="">----请选择----</OPTION>
	                             	<c:if test="${not empty(warehouseList)}">
					               	  <s:iterator value="warehouseList">
	                    	           <OPTION value="${bwhid}" ${warehouseConfigurationPo.bwcstockid6 != bwhid ? '' : 'selected="selected"' } >${bwhwarehouseName}</OPTION>
	                    	          </s:iterator>
	                    	        </c:if>
									</SELECT><label style="color:red;">&nbsp;*</label>
                           </TD>
                          <TD><SELECT  id="tbwcstockid6" name="inWarehouseConfigurationPo.bwcstockid6" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '隐形订做镜片退款仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${inWarehouseConfigurationPo.bwcstockid6 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD> 
	                      <TD align="center">&nbsp;</TD>                                                    
                          </TR>
						  <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26">隐形护理液</TD>
						  <TD align="center">
						  	<SELECT  id="bwcstockid7" name="warehouseConfigurationPo.bwcstockid7" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '隐形护理液销售仓位不能为空！'}]"> 
                             		<OPTION value="">----请选择----</OPTION>
	                             	<c:if test="${not empty(warehouseList)}">
					               	  <s:iterator value="warehouseList">
	                    	           <OPTION value="${bwhid}" ${warehouseConfigurationPo.bwcstockid7 != bwhid ? '' : 'selected="selected"' } >${bwhwarehouseName}</OPTION>
	                    	          </s:iterator>
	                    	        </c:if>
									</SELECT><label style="color:red;">&nbsp;*</label>
                              </TD>
                          <TD><SELECT  id="tbwcstockid7" name="inWarehouseConfigurationPo.bwcstockid7" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '隐形护理液退款仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${inWarehouseConfigurationPo.bwcstockid7 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>  
	                      <TD align="center">&nbsp;</TD>                             
		                  </TR>
						  <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD  height="26">太阳镜</TD>
                          <TD align="center">
                          	<SELECT  id="bwcstockid8" name="warehouseConfigurationPo.bwcstockid8" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '太阳镜销售仓位不能为空！'}]"> 
                             		<OPTION value="">----请选择----</OPTION>
	                             	<c:if test="${not empty(warehouseList)}">
					               	  <s:iterator value="warehouseList">
	                    	           <OPTION value="${bwhid}" ${warehouseConfigurationPo.bwcstockid8 != bwhid ? '' : 'selected="selected"' } >${bwhwarehouseName}</OPTION>
	                    	          </s:iterator>
	                    	        </c:if>
									</SELECT><label style="color:red;">&nbsp;*</label>
                          </TD>
                          <TD><SELECT  id="tbwcstockid8" name="inWarehouseConfigurationPo.bwcstockid8" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '太阳镜退款仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${inWarehouseConfigurationPo.bwcstockid8 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>   
	                      <TD align="center">&nbsp;</TD>                                                 
                          </TR>
                          <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD  height="26">老花镜</TD>
                          <TD align="center">
                          	<SELECT  id="bwcstockid11" name="warehouseConfigurationPo.bwcstockid11" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '老花镜销售仓位不能为空！'}]"> 
                             		<OPTION value="">----请选择----</OPTION>
	                             	<c:if test="${not empty(warehouseList)}">
					               	  <s:iterator value="warehouseList">
	                    	           <OPTION value="${bwhid}" ${warehouseConfigurationPo.bwcstockid11 != bwhid ? '' : 'selected="selected"' } >${bwhwarehouseName}</OPTION>
	                    	          </s:iterator>
	                    	        </c:if>
									</SELECT><label style="color:red;">&nbsp;*</label>
                          </TD>
                          <TD><SELECT  id="tbwcstockid11" name="inWarehouseConfigurationPo.bwcstockid11" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '老花镜退款仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${inWarehouseConfigurationPo.bwcstockid11 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
	                      <TD align="center">&nbsp;</TD>                                                    
                          </TR>
                          <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD  height="26">耗材</TD>
                          <TD align="center">
                          	<SELECT  id="bwcstockid9" name="warehouseConfigurationPo.bwcstockid9" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '耗材销售仓位不能为空！'}]"> 
                             		<OPTION value="">----请选择----</OPTION>
	                             	<c:if test="${not empty(warehouseList)}">
					               	  <s:iterator value="warehouseList">
	                    	           <OPTION value="${bwhid}" ${warehouseConfigurationPo.bwcstockid9 != bwhid ? '' : 'selected="selected"' } >${bwhwarehouseName}</OPTION>
	                    	          </s:iterator>
	                    	        </c:if>
									</SELECT><label style="color:red;">&nbsp;*</label>
                          </TD>
                          <TD><SELECT  id="tbwcstockid9" name="inWarehouseConfigurationPo.bwcstockid9" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '耗材退款仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${inWarehouseConfigurationPo.bwcstockid9 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>   
	                      <TD align="center">&nbsp;</TD>                                                 
                          </TR>
                          <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD  height="26">视光</TD>
                          <TD align="center">
                          	<SELECT  id="bwcstockid12" name="warehouseConfigurationPo.bwcstockid12" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '视光销售仓位不能为空！'}]"> 
                             		<OPTION value="">----请选择----</OPTION>
	                             	<c:if test="${not empty(warehouseList)}">
					               	  <s:iterator value="warehouseList">
	                    	           <OPTION value="${bwhid}" ${warehouseConfigurationPo.bwcstockid12 != bwhid ? '' : 'selected="selected"' } >${bwhwarehouseName}</OPTION>
	                    	          </s:iterator>
	                    	        </c:if>
									</SELECT><label style="color:red;">&nbsp;*</label>
                          </TD>
                          <TD><SELECT  id="tbwcstockid12" name="inWarehouseConfigurationPo.bwcstockid12" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '视光退款仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${inWarehouseConfigurationPo.bwcstockid12 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
	                      <TD align="center">&nbsp;</TD>                                                    
                          </TR>
                          <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD  height="26">门店赠品类</TD>
                          <TD align="center">
                          	<SELECT  id="bwcstockid10" name="warehouseConfigurationPo.bwcstockid10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '赠品类销售仓位不能为空！'}]"> 
                             		<OPTION value="">----请选择----</OPTION>
	                             	<c:if test="${not empty(warehouseList)}">
					               	  <s:iterator value="warehouseList">
	                    	           <OPTION value="${bwhid}" ${warehouseConfigurationPo.bwcstockid10 != bwhid ? '' : 'selected="selected"' } >${bwhwarehouseName}</OPTION>
	                    	          </s:iterator>
	                    	        </c:if>
									</SELECT><label style="color:red;">&nbsp;*</label>
                          </TD>
                          <TD><SELECT  id="tbwcstockid10" name="inWarehouseConfigurationPo.bwcstockid10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '赠品类退款仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${inWarehouseConfigurationPo.bwcstockid10 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
	                      <TD align="center">
							<SELECT  id="bwcxiaocangzp" name="warehouseConfigurationPo.bwcxiaocangzp" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '赠品类出仓点不能为空！'}]">
	                            <option value="1" ${warehouseConfigurationPo.bwcxiaocangzp == '1' ? 'selected="selected"' : '' }>门店结款</option>
                            </SELECT><label style="color:red;">&nbsp;*</label>
						  </TD>                                                    
                          </TR>
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD  height="26">通用赠品类</TD>
                          <TD align="center">
                          	<SELECT  id="bwcstockid15" name="warehouseConfigurationPo.bwcstockid15" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '赠品类销售仓位不能为空！'}]"> 
                             		<OPTION value="">----请选择----</OPTION>
	                             	<c:if test="${not empty(warehouseList)}">
					               	  <s:iterator value="warehouseList">
	                    	           <OPTION value="${bwhid}" ${warehouseConfigurationPo.bwcstockid15 != bwhid ? '' : 'selected="selected"' } >${bwhwarehouseName}</OPTION>
	                    	          </s:iterator>
	                    	        </c:if>
									</SELECT><label style="color:red;">&nbsp;*</label>
                          </TD>
                          <TD><SELECT  id="tbwcstockid15" name="inWarehouseConfigurationPo.bwcstockid15" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '赠品类退款仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${inWarehouseConfigurationPo.bwcstockid15 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
	                      <TD align="center">
							<SELECT  id="bwcxiaocangzp2" name="warehouseConfigurationPo.bwcxiaocangzp2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '赠品类出仓点不能为空！'}]">
	                            <option value="1" ${warehouseConfigurationPo.bwcxiaocangzp2 == '1' ? 'selected="selected"' : '' }>门店结款</option>
	                            <option value="2" ${warehouseConfigurationPo.bwcxiaocangzp2 == '2' ? 'selected="selected"' : '' }>库房发料</option>
                            </SELECT><label style="color:red;">&nbsp;*</label>
						  </TD>                                                    
                          </TR>                          
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD  height="26">积分兑换类</TD>
                          <TD align="center">
                          	<SELECT  id="bwcstockid14" name="warehouseConfigurationPo.bwcstockid14" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '积分兑换类出仓仓位不能为空！'}]"> 
                             		<OPTION value="">----请选择----</OPTION>
	                             	<c:if test="${not empty(warehouseList)}">
					               	  <s:iterator value="warehouseList">
	                    	           <OPTION value="${bwhid}" ${warehouseConfigurationPo.bwcstockid14 != bwhid ? '' : 'selected="selected"' } >${bwhwarehouseName}</OPTION>
	                    	          </s:iterator>
	                    	        </c:if>
									</SELECT><label style="color:red;">&nbsp;*</label>
                          </TD>
                          <TD><SELECT  id="tbwcstockid13" name="inWarehouseConfigurationPo.bwcstockid13" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '积分兑换类销售仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${inWarehouseConfigurationPo.bwcstockid13 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD> 
	                      <TD align="center">&nbsp;</TD>                                                   
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD  height="26">不合格品调拨</TD>
                          <TD align="center">
                          	&nbsp;
                          </TD>
                          <TD><SELECT  id="tbwcstockid14" name="inWarehouseConfigurationPo.bwcstockid14" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '不合格品调拨出仓仓位不能为空！'}]">
                            <option value="">----请选择----</option>
                            <s:iterator value="warehouseList">
                                <option value="${bwhid}" ${inWarehouseConfigurationPo.bwcstockid14 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
                            </s:iterator>
                          </SELECT></TD>
	                      <TD align="center">&nbsp;</TD>                                                    
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26" align="center"></TD>
                          <TD align="center"><strong id="１">×温馨提示：商品将会在关联的仓库消减库存。 </strong></TD>
                          <TD align="center"><strong id="１">×温馨提示：商品将会在关联的仓库增加库存。 </strong></TD>
	                      <TD align="center">&nbsp;</TD>                          
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                        <c:if test="${(permissionPo.keyk==1)}">  
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save();">
						 <!-- <input icon='icon-reload' type="reset" value="清空" >	 -->					  
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
  

