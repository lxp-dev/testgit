<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择品种</title>
</head>
<script>	
	
	function search(){
		$("img").removeAttr("onclick");
		brandForm.action = "selBrandOpen.action";
		brandForm.submit();
		showLoadingBar();
	}	
	
	function permissionMessage(){
       alert('您无此操作权限');
	}

	function clean(){
	    document.all.selbbdid.value="";
	    document.all.selbbdbrandname.value="";
	    
	    ${not empty(categoryID_open) ? '': 'document.all.selbspcategoryid.value="";'}	
	    
	    <c:if test="${empty(supplierID_open) }">
	    document.all.selbspsuppliername.value="";
	    document.all.selbbdsupplierid.value="";
	    </c:if>
	    
	     
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=" + document.all.selbspcategoryid.value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=" + document.all.selbspcategoryid.value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('bbdsupplierid').value = json.id;
		document.getElementById('bspsuppliername').value = json.value;
	}
	
	/**
	 *  调用页面赋值
	 */
	function setValue(){
		var json = {'brandID' : arguments[0], 'brandName' :　arguments[1], 'supplierID': arguments[2],'retailPrice': arguments[3],'costPrice': arguments[4],'processcraftType': arguments[5],'taxRate': arguments[6],'unit': arguments[7],'refractive': arguments[8],'bbdframematerialtype': arguments[9],'bbdmaterialclass': arguments[10],'bbdluminosityclass': arguments[11],'bbdgradualclass': arguments[12],'bbdfunctionclass': arguments[13],'bbdusetype': arguments[14],'bbdstealthclass': arguments[15],'bbdvaliddateUL':arguments[16],'bbdvaliddateUP':arguments[17],'bbddefaultdiscount':arguments[18],'bbdpayfeeid':arguments[19]};
		window.parent.openBrandValues(json);
		
		if(arguments[18]){
			var defaultdiscount = arguments[18];
			
			window.parent.$("input[name=goodsInfoPo.bgidefaultdiscountvalue]").val(defaultdiscount);
		}
		
		parent.hidePopWin();

	}
	function selectContact(obj){
		if(event.keyCode==13){
			search();
		}
	}
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="brandForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="arg0"  value="${arg0 }" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<input type="hidden" name="categoryID_open" value="${categoryID_open }" />
<input type="hidden" name="supplierID_open" value="${supplierID_open }" />
<input type="hidden" name="isclosed" value="${isclosed }" />

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" background=${ctx }/img/pic/tab_bg.gif>
		  </TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
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
					  		<TD width="8%" height="26" class="table_body">商品类别</TD>
	                        <TD width="23%" class="table_none">
							  	<select name="selbspcategoryid" ${!empty(categoryID_open) ? 'disabled="disabled"' : '' }>
							  		<option value="">----请选择----</option>
							  		<s:iterator value="goodsCategorys">
									<option value="${bgcid}" ${selbspcategoryid == bgcid ? 'selected="selected"' : '' } >${bgcgoodscategoryname}</option>
		     	               		</s:iterator>
								</select></TD>
						   <TD width="8%" class="table_body">制造商</TD>
						   	<TD width="23%" height="26" align="left" class="table_none">
					   			<li class="horizontal_onlyRight">
						   			<input id="bspsuppliername" class="text_input160" name="selbspsuppliername" value="${selbspsuppliername }"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } />
						   			<input type="hidden" id="bbdsupplierid" name="selbbdsupplierid" value="${selbbdsupplierid }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
								</li>
					   			<li class="horizontal_onlyRight">
					  				<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onClick="openSupplier();" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }></li>
						   	</TD>
                            <TD width="8%" height="26" class="table_body">品种</TD>
                          	<TD class="table_none"><input class="text_input160" name="selbbdbrandname" value="${selbbdbrandname }"></TD>
                      
                        </TR>
                        <tr>
                        	<TD width="8%" height="26" class="table_body">品种代码</TD>
			               	<TD width="23%" class="table_none" colspan="5"><input class="text_input100" type="text" name="selbbdid" value="${selbbdid }" onkeydown="selectContact(this)"/></TD>
                        </tr>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img id="submitimg" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title="查询" onclick="search();" >
							  	<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onclick="clean();" >
							</td>
						</tr>
					</table>
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<c:if test="${not empty(brands)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="4%" height="26" scope=col>操作</TH>
                          <TH width="8%" scope=col>品种代码</TH>
                          <TH width="23%" scope=col>品种名称</TH>
						  <th width="22%">商品类别</th>
                          <TH width="15%" scope=col>制造商简称</TH>
                        </TR>
                        <c:forEach var="po" items="${brands}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD>
		                     <img src="${ctx }/img/newbtn/select_0.png" btn=btn title="选择" onClick="setValue('${po.bbdid}', '${po.bbdbrandname}', '${po.bbdsupplierid }', '${po.bbdretailprice}', '${po.bbdcostprice}', '${po.bbdframeprocesscrafttype}', '${po.bbdtaxrate}', '${po.bbdunit}','${po.bbdrefractive}','${po.bbdframematerialtype}','${po.bbdmaterialclass}','${po.bbdluminosityclass}','${po.bbdgradualclass}','${po.bbdfunctionclass}','${po.bbdusetype}','${po.bbdstealthclass}','${po.bbdvaliddateUL}','${po.bbdvaliddateUP}','${po.bbddefaultdiscount }','${po.bbddefaultdiscount}','${po.bbdpayfeeid }');">
		                  </TD>
                          <TD height="26">${po.bbdid }</TD>
                          <TD>${po.bbdbrandname }</TD>
						  <td>${po.bgcgoodscategoryname }</td>
                          <TD>${po.bspsuppliername }</TD>
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
