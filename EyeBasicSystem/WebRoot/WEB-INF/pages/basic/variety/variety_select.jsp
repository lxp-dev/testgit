<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>品种</title>
</head>
<script>
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	 var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	varietyForm.action=link;
	  	varietyForm.submit();
	}
	function search(){
		varietyForm.action = "selVariety.action";
		varietyForm.submit();
	}	
	function update(id, brandid, bvysupplierid,bvygcid){
		showPopWin("","initVarietyUpdate.action?hid="+id+"&brandid" + brandid + "&bvysupplierid=" + bvysupplierid + "&bvygcid=" + bvygcid,screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	function insert(){
		showPopWin("","initVarietyInsert.action",screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	function del(id, brandid, bvysupplierid, bvygcid){
		showPopWin("","initVarietyDelete.action?hid="+id+"&brandid" + brandid + "&bvysupplierid=" + bvysupplierid + "&bvygcid=" + bvygcid,400,250, '',null,true);
		selectHidden();
	}	
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function clean(){
		document.getElementById('selbvyid').value = "";
		document.getElementById('selbvyvarietyname').value = "";
		document.getElementById('selbvybrandid').value = "";
		document.getElementById('selsupplierID').value = "";
		document.getElementById('selbrandName').value = "";
		document.getElementById('selbvygcid').value = "";
	}
	
	/**
	 * 品种开窗
	 */
	function openBrand(){
		// 开窗条件 categoryID_open, supplierID_open
		showPopWin("","selBrandOpen.action?categoryID_open=" + document.all.selbvygcid.value + "&supplierID_open=" + "" ,screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		//{'brandID' : arguments[0], 'brandName' :　arguments[1], 'supplierID': arguments[2]};
		document.getElementById('selbvybrandid').value = json.brandID;
		document.getElementById('selbrandName').value = json.brandName;
		document.getElementById('selsupplierID').value = json.supplierID;
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="varietyForm" method="post" action="">
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
            <TD class=menubar_title><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>品种维护</TD>
            <TD class=menubar_readme_text vAlign=bottom>&nbsp;</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：查询品种</TD>
            <TD class=menubar_function_text align=right>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
                <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                onclick="insert();" 
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/img/sys/New.gif" align=textTop 
                  border=0>&nbsp;品种新增</TD>
                  </TR></TBODY></TABLE></TD>
          </TR>
          <TR>
            <TD colSpan=2 height=5></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">品种查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>		
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="10%" height="30" class="table_body">品种代码</TD>
			               <TD width="40%" class="table_none"><input class="text_input100" type="text" name="selbvyid" value="${selbvyid }" /></TD>
					
						   <TD width="10%" height="30" class="table_body">品种名称</TD>
                          <TD width="40%" class="table_none"><input class="text_input200" name="selbvyvarietyname" value="${selbvyvarietyname }"></TD>
                        </TR>
                        <TR>
                          <TD height="30" class="table_body">所属品种</TD>
						  <TD align="left" class="table_none">
						   <li class="horizontal_onlyRight">
						   		<input id="selbrandName" class="text_input200" id="selbrandName" name="selbrandName" readonly="readonly" value="${selbrandName }" />
						   		<input type="hidden" id="selbvybrandid" name="selbvybrandid" value="${selbvybrandid }" />
						   		<input type="hidden" id="selsupplierID" name="selsupplierID" value="${selsupplierID }" />
						   </li>
						   <li class="horizontal_onlyRight">
						  <INPUT class=button_bak id=ctl00_PageBody_Button1 icon="icon-zoom" type=button value="选 择" name=ctl00$PageBody$Button1 onClick="openBrand();"></li></TD>
                        	<TD height="30" class="table_body">商品类别</TD>
                          	<TD class="table_none" colspan="7">
						  	<select name="selbvygcid">
						  		<option value="">请选择商品类别</option>
						  		<s:iterator value="goodsCategorys">
								<option value="${bgcid}" ${selbvygcid == bgcid ? 'selected="selected"' : '' } >${bgcgoodscategoryname}</option>
	     	               		</s:iterator>
							</select></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td><input icon='icon-search' type='button' value='查询' onclick="search();" >
							  <input name="reset" type='button' value='清空' icon='icon-retry' onclick="clean();" ></td>
						</tr>
					</table>
					<c:if test="${not empty(varietys)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                           <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                     </TABLE>
                    
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="8%" height="30" scope=col>品种代码</TH>
                          <TH width="32%" scope=col>品种名称</TH>
                          <TH width="15%" scope=col>所属品种</TH>
						  <TH width="22%">商品类别</TH>
                          <TH width="8%" scope=col>修改</TH>
                          <TH width="10%" scope=col>删除</TH>
                        </TR>
                        <c:forEach var="po" items="${varietys}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="28">${po.bvyid }</TD>
                          <TD>${po.bvyvarietyname }</TD>
						  <td>${po.bbdbrandname }</td>
                          <TD>${po.bgcgoodscategoryname }</TD>
                          <TD><input icon='icon-edit' type='button' value='修改' onClick="update('${po.bvyid }', '${po.bvybrandid }', '${po.bvysupplierid }', '${po.bvygcid }')"></TD>
                          <TD><input icon='icon-delete' type='button' value='删除' onClick="del('${po.bvyid }', '${po.bvybrandid }', '${po.bvysupplierid }', '${po.bvygcid }')" ></TD>
                        </TR>
                        </c:forEach>
                      </TBODY>
                    </TABLE>
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
                    </c:if>
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
         <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
