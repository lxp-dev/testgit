<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商效期查询</title>
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

	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	roleDiscountForm.action=link;
	  	roleDiscountForm.submit();
		showLoadingBar();
	}
	function search(){
		roleDiscountForm.action = "selSupplierAgentDate.action";
		roleDiscountForm.submit();
		showLoadingBar();
	}
	function clean(){
	    $('[clean=clean]').val('');
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	function yzTSZheKou(){
		var vl=$('#begPrice').val();
		b=".";
		if(ReplaceDemo(vl)>1){
			alert("折扣输入错误！");
			$('#begPrice').focus();
			$('#begPrice').select();
			return;
		}
		if(vl>1){
			alert("折扣应小于1！");
			$('#begPrice').focus();
			$('#begPrice').select();
			return;
		}
		var indexNum=vl.indexOf(".");
		if(indexNum==0){
			vl=0+vl;
			$('#begPrice').val(vl)
		}
		
	}
	function yzTSZheKouend(){
		var vl=$('#endPrice').val();
		b=".";
		if(vl>1){
			alert("折扣应小于1！");
			$('#begPrice').focus();
			$('#begPrice').select();
			return;
		}
		if(ReplaceDemo(vl)>1||vl>1){
			alert("折扣输入错误！");
			$('#endPrice').focus();
			$('#endPrice').select();
			return;
		}
		var indexNum=vl.indexOf(".");
		if(indexNum==0){
			vl=0+vl;
			$('#endPrice').val(vl)
		}
		
	}
	function ReplaceDemo(ss){ 
	   var r, re;   
	   var strlength = ss.length; 
	   re = /\./;        // 创建正则表达式模式。 
	   while(re.test(ss)){ 
	  		ss = ss.replace(re, "");   
	   }  
	   return (strlength-ss.length); 
	}
	
	/**
	 * 供应商开窗
	 */
	function openSupplier(){
		// 开窗条件 categoryID_open
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=" + $("#goodsCategoryID").val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=" + $("#goodsCategoryID").val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【供应商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('bbdsupplierid').value = json.id;
		document.getElementById('bspsuppliername').value = json.value;
	}
	
	function detail(id){
		document.all.hid.value = id;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("supplierAgentDetail.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("supplierAgentDetail.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【供应商详细】";
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="roleDiscountForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>基础信息</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：供应商效期查询</TD>
            <td align="right" valign="bottom">&nbsp;
            	<img btn=btn src="${ctx }/img/newbtn/btn_isshowsearch_0.png" title='显隐查询条件' onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
            
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
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
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1   
                       onclick="JavaScript:window.location.href='selSupplierDate.action?bsplicencetype=1&moduleID=${requestScope.moduleID}';"                    
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">制造商效期查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                    
                    <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">供应商效期查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>	
                      	<TR>
                      		<TD width="9%" height="26" class="table_body">
								商品类别
							</TD>
							<TD class="table_none">
								<select id="goodsCategoryID" name="goodsCategoryID" clean=clean>
									<option value="">----请选择----</option>
									<s:iterator value="goodsCategoryList">
										<option value="${bgcid}" ${bgcid ==goodsCategoryID ? 'selected="selected"' : '' }>
											${bgcgoodscategoryname}
										</option>
									</s:iterator>
								</select>
							</TD>
                      		<TD width="8%" class="table_body">制造商</TD>
						   	<TD width="24%" height="26" align="left" class="table_none">
						   		<li class="horizontal_onlyRight">
						   		<input id="bspsuppliername" class="text_input160" clean=clean name="selbspsuppliername" value="${selbspsuppliername }" readonly="readonly" />
						   		<input type="hidden" id="bbdsupplierid" clean=clean name="selbbdsupplierid" value="${selbbdsupplierid }"/>
							   	</li>
							   	<li class="horizontal_onlyRight">
							  	<img id=ctl00_PageBody_Button1 src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" name=ctl00$PageBody$Button1 onClick="openSupplier();">
							  	</li>
						  	</TD>
						  	<TD width="9%" height="26" class="table_body">
								供应商代码
							</TD>
							<TD width="24%" class="table_none">
								<input class="text_input100" type="text" clean=clean
									id="supplierID" name="supplierID"
									value="${requestScope.supplierID}" maxlength="4" onkeyup="selectContact(this)">
							</TD>
						</TR>
                        <TR>
							<TD width="9%" height="26" class="table_body">
								供应商简称
							</TD>
							<TD width="24%" class="table_none">
								<input class="text_input160" type="text" clean=clean
									id="supplierName" name="supplierName"
									value="${requestScope.supplierName}" onkeyup="selectContact(this)">
							</TD>
						   <TD height="26" class="table_body">许可证类型</TD>
			               <TD class="table_none">
			               <select id="bsplicencetype" name="bsplicencetype">
	      		               <option value="1" ${bsplicencetype == '1' ? 'selected="selected"' : '' }>三证</option>
	      		               <option value="2" ${bsplicencetype == '2' ? 'selected="selected"' : '' }>医疗器械经营许可证</option>
	      		               <option value="3" ${bsplicencetype == '3' ? 'selected="selected"' : '' }>全国工业品生产许可证</option>
      	                   </select>
			               </TD>
			               <TD height="26" class="table_body">过期状态</TD>
			               <TD class="table_none">
			               <select id="bsplicencestate" name="bsplicencestate" clean=clean>
			               	   <option value="" ${bsplicencestate == '' ? 'selected="selected"' : '' }>全部</option>
	      		               <option value="0" ${bsplicencestate == '0' ? 'selected="selected"' : '' }>未过期</option>
	      		               <option value="1" ${bsplicencestate == '1' ? 'selected="selected"' : '' }>已过期</option>
	      		               <option value="2" ${bsplicencestate == '2' ? 'selected="selected"' : '' }>未设置</option>
      	                   </select>
			               </TD>
                          </TR>

                      </TBODY>
                    </TABLE>
                    <c:if test="${permissionPo.keya == 1}">
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
		                      <img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
							  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
							</td>
						</tr>
					</table>
					</c:if>
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
					<c:if test="${not empty(supplierList)}"> 
					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="3%" height="26" scope=col>操作</TH>
                          <TH width="10%" height="26" scope=col>供应商ID</TH>
                          <TH width="20%" scope=col>供应商名称</TH>
                          <TH width="10%" scope=col>有效日期</TH>
                          <TH width="10%" scope=col>有效天数</TH>
                          <TH width="10%" scope=col>过期状态</TH>
						</TR>
						<s:iterator value="supplierList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" ${bsplicencedays > 0 ? '' : 'style="color: red"'}>
                          <TD height="26">
                          	<img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="detail('${bspid}')">
                          </TD>
                          <TD height="26">${bspid}</TD>
                          <TD>${bspsuppliername}</TD>
                          <TD>${bsplicencevalidity}</TD>
                          <TD>${bsplicencevalidity ne '' ? bsplicencedays : '未设置'}</TD>
                          <TD>
                          	<c:if test="bsplicencevalidity ne ''">
                          		${bsplicencedays > 0 ? '未过期' : ''}
                          	</c:if>
                          </TD>
						</TR>
						</s:iterator>
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
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
<script>

	var index_role = 0;
	var arr = document.all.role.options.length;
	for(i=0;i<arr;i++){
		if(document.all.role.options.options[i].value == '<c:out value="${requestScope.role}"/>'){
			document.all.role.options.selectedIndex = index_role;
			break;
		}
		index_role++;
	}
</script>