<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>品种维护</title>
</head>
<script>	
	function save(){
		if(checkForm(brandForm)){
			$("img").removeAttr("onclick");
			brandForm.action = "updateVariety.action";
			brandForm.submit();
		}
	}
	
	/**
	 * 品种开窗
	 */
	function openBrand(){
		showPopWin("","selBrandOpen.action",screen.width-200,screen.height-200, '', null, true);
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
<form name="brandForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>品种维护</TD>
          <TD class=menubar_readme_text vAlign=bottom>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
			</TD></TR>
        <TR>
          <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：品种修改</TD>
          <TD class=menubar_function_text align=right>&nbsp;</TD></TR>
        <TR>
          <TD colSpan=2 height=5></TD></TR></TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
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
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">品种修改</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE></TD>
					
					</TR>
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
                            <TD width="5%"><div align="left"><img src="${ctx }/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                            <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                          </TR>
                        </TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="10%" height="30" class="table_body">品种代码</TD>
			               <TD width="40%" class="table_none">&nbsp;${varietyPo.bvyid }<input type="hidden" name="varietyPo.bvyid" maxlength="2" value="${varietyPo.bvyid }"></TD>
					   
						   <TD width="10%" height="30" class="table_body">品种名称</TD>
			               <TD width="40%"  class="table_none"><input class="text_input200" name="varietyPo.bvyvarietyname" maxlength="15" value="${varietyPo.bvyvarietyname }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '品种名称不能为空！'}]"></TD>
			            </TR>
						<TR>   					   
						   <TD class="table_body">所属品种</TD>
						   <TD height="30" align="left" class="table_none">
						   		&nbsp;${varietyPo.bbdbrandname }
						   		<input type="hidden" id="selbvybrandid" name="varietyPo.bvybrandid" value="${varietyPo.bvybrandid }" />
						   		<input type="hidden" id="selsupplierID" name="varietyPo.bvysupplierid" value="${varietyPo.bvysupplierid }" />
						
                        	<TD height="30" class="table_body">商品类别</TD>
                          	<TD class="table_none" colspan="7">
                          	<input type="hidden" name="varietyPo.bvygcid" value="${varietyPo.bvygcid }" />
                          	<c:choose>
                          		<c:when test="${varietyPo.bvygcid == 1 }">镜架</c:when>
                          		<c:when test="${varietyPo.bvygcid == 2 }">配件</c:when>
                          		<c:when test="${varietyPo.bvygcid == 3 }">镜片</c:when>
                          		<c:when test="${varietyPo.bvygcid == 4 }">隐形镜片</c:when>
                          		<c:when test="${varietyPo.bvygcid == 5 }">隐形护理液</c:when>
                          		<c:when test="${varietyPo.bvygcid == 6 }">太阳镜</c:when>
                          		<c:when test="${varietyPo.bvygcid == 8 }">老花镜</c:when>
                          		<c:when test="${varietyPo.bvygcid == 7 }">耗材</c:when>
                          		<c:when test="${varietyPo.bvygcid == 9 }">视光</c:when>
                          	</c:choose></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
 		
					<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><input icon='icon-save' id="submitButton" type='button' value='保存' onclick="save();" >
                        	<input icon='icon-reload' type="reset" value='重置' >
                          </TD>
						  </TR>
                      </TBODY>
                    </TABLE>
                
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
