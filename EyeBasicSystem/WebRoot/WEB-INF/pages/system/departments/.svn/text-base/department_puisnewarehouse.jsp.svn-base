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
		
	function update(id){
		document.all.hid.value = id;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdateWarehouse.action?hid="+id+"&moduleID=${requestScope.moduleID}&departmentID=${departmentsPo.bdpdepartmentid }",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initUpdateWarehouse.action?hid="+id+"&moduleID=${requestScope.moduleID}&departmentID=${departmentsPo.bdpdepartmentid }",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【仓位更新】";
	}
	
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInsertWarehouse.action?moduleID=${requestScope.moduleID}&departmentID=${departmentsPo.bdpdepartmentid }",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertWarehouse.action?moduleID=${requestScope.moduleID}&departmentID=${departmentsPo.bdpdepartmentid }",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【仓位新增】";
	}
	
	function del(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDeleteWarehouse.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDeleteWarehouse.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【仓位删除】";
	}
	   
    //仓位列表默认值配置
    function setDefaultWarehouse(){
        departmentsForm.action = "initDefaultWarehouse.action";
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

    //HIS配置
    function setHis(){
        departmentsForm.action = "initHisSet.action";
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
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0 >
              <TBODY>
              <TR>
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

                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD width="100" align="center" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif
                      UNSELECTABLE="on">下属仓位配置</TD>
                 <c:if test="${departmentsPo.bdptype=='3'}">     
                      <TD width=3><IMG id=tabImgRight__0 height=22                       
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3 ></TD>
                 </c:if>   
                    </TR></TBODY></TABLE></TD>
				<c:if test="${departmentsPo.bdptype=='3'}">	
					<TD width="120" align="center" class=tab id=tabLabel__1 onclick="setDefaultWarehouse();"                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">仓位列表默认值配置</TD>
               </c:if>       		
					<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                    <c:if test="${departmentsPo.bdptype=='1'}">
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                                                            
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD width="100" align="center" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="setGoodsOutWarehouse();"
                      UNSELECTABLE="on">门店仓位配置</TD>
                      </c:if>
                        <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3 ></TD>
                    </TR></TBODY></TABLE></TD>   
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
					<TD width="auto" align="right" style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
						<img src="${ctx }/img/newbtn/btn_warehouseinsert_0.png" btn=btn onclick="insert();"/>
                  	</TD>				
				</TR>
        <TR>
          <TD bgColor=#ffffff colspan="2">
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
                          <TD width="8%" height="26" class="table_body">部门编码</TD>
                          <TD width="23%" class="table_none">${departmentsPo.bdpdepartmentid }<input type="hidden" name="departmentsPo.bdpdepartmentid" value="${departmentsPo.bdpdepartmentid }"></TD>
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
                    <c:if test="${not empty(warehouseList)}">
                    <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </table>
                    
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="8%" scope=col colspan="2">操作</TH>
                          <TH width="20%" height="26" scope=col>仓位编码</TH>
                          <TH width="35%" scope=col>仓位名称</TH>
                          <TH  scope=col>所属部门</TH>
                        </TR>
                      <s:iterator value="warehouseList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD>
                           	<c:if test="${(permissionPo.keyh==1)}">
		                     <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${bwhid}')">	
		                   	</c:if>
		                   </TD>
		                   <TD>
		                   	<c:if test="${(permissionPo.keyi==1)}"> 
                             <img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${bwhid}')">
                           	</c:if>
                           </TD>
                          <TD height="26">${bwhid}</TD>
                          <TD>${bwhwarehouseName}</TD>
                          <TD>${bdpdepartmentname}</TD>
                        </TR>
                      </s:iterator>  
  </TBODY>
  </table>             
  </c:if> 
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif colspan="2"><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff colspan="2"><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
  

