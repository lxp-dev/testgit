<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择商品</title>
</head>
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	 var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	contactAccessoriesForm.action=link;
	  	contactAccessoriesForm.submit();
	}
	function search(){
		if(checkForm(document.all.contactAccessoriesForm)){  
			$("img").removeAttr("onclick");
			contactAccessoriesForm.action = "selectContactAccessories.action";
			contactAccessoriesForm.submit();
		}
	}
	
	function selectContact(obj){
		if(event.keyCode==13){
			if (obj.value === ''||obj.value.length<26) {
				alert('条码位数不符!');
				obj.value='';
				obj.focus();
				return;
			}else {
				$("img").removeAttr("onclick");
				contactAccessoriesForm.action = "selectContactByGoodsbarcode.action";
				contactAccessoriesForm.submit();
			}
			
		}
	}
	function clean(){
		document.getElementById('goodsId').value = "";
		document.getElementById('goodsName').value = "";
		document.getElementById('supplierName').value = "";
		document.getElementById('supplierId').value = "";
		document.getElementById('brandName').value = "";
		document.getElementById('brandId').value = "";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function choose(json){
		try{
		parent.setCategory('隐形辅料');
		}catch(e){
		
		}
		
		parent.addGoods(json);
		//parent.hidePopWin();
		parent.toRound();
		window.location.href='initContactAccessoriesSel.action';
	}
	
	
	
	$(document).ready(function(){
		$('#bgigoodsbarcode').focus();
	});
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="contactAccessoriesForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input name="" type="text" style="display:none">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>柜台销售管理</TD>
            <TD class=menubar_readme_text vAlign=bottom>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();parent.toRound();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
			</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：选择隐形辅料商品</TD>
            <TD class=menubar_function_text align=right>&nbsp;</TD>
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
                      UNSELECTABLE="on">选择辅料商品选择</TD>
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
                      	<TD width="%15" height="30" class="table_body">商品条码</TD>
                      	<TD width="%35" class="table_none" colspan="3" >
                            <input class="text_input200" type="text" onkeydown="selectContact(this)" id="bgigoodsbarcode" name="bgigoodsbarcode" value="" style="ime-mode:disabled">
                            <font color="red">按回车查询商品</font>
			               </TD>
                      </TR>
                      </TBODY>
                    </table>
					<c:if test="${not empty(contactList)}"> 
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
						<br/>
					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="10%" height="30" scope=col>选择</TH>                        
                          <TH width="20%" scope=col>商品代码</TH>
                          <TH width="20%" scope=col>商品名称</TH>
                          <TH width="20%" scope=col>品种</TH>
                          <TH width="10%" scope=col>型号</TH>                        
                          <TH width="10%" scope=col>销售金额</TH>                                                                                                                               
						  <TH width="10%" scope=col>商品数量</TH> 
						  </TR>
						<c:forEach var="i" items="${contactList}" varStatus="index"> 
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">                         
                          <TD height="28">
                          <input icon='icon-apply' type='button' value='选 择' onClick="choose({'bgigoodsid':'${i.bgigoodsid}','bgigoodsname':'${i.bgigoodsname}','bgibrandname':'${i.bgibrandname}','bgiretailprice':'${i.bgiretailprice}','bgicostprice':'${i.bgicostprice}','bginottaxrate':'${i.bginottaxrate}','bgigoodsbarcode':'${pcBarcode}'})">
                          </TD>
                          <TD>${i.bgigoodsid}</TD>
                          <TD>${i.bgigoodsname}</TD>
                          <TD>${i.bgibrandname}</TD>
                          <TD>${i.bgispec}</TD>
                          <TD>${i.bgiretailprice}</TD>  
                          <TD>${i.bgigoodsquantity}</TD>  
                          <input type="hidden" name="bgicostprice" id="bgicostprice" value="${i.bgicostprice}" /> 
                          <input type="hidden" name="bginottaxrate" id="bginottaxrate" value="${i.bginottaxrate}" />                     
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
