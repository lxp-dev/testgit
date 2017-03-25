<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>委外订单管理</title>
</head>

<!-- jquery.autocomplete -->
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<!--<link rel="stylesheet" type="text/css" href="${ctx }/css/module/thickbox.css" /> -->
<!-- jquery.autocomplete end -->

<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	brandForm.action=link;
	  	brandForm.submit();
		showLoadingBar();
	}
	
	function search(){
		$("img").removeAttr("onclick");
		brandForm.action = "selConsignProcessOrder.action";
		brandForm.submit();
		showLoadingBar();
	}	
	function update(id){
		//showPopWin("","initConsignProcessOrderUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}", screen.width-100,screen.height-200, '',null,true);
		//selectHidden();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initConsignProcessOrderUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initConsignProcessOrderUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【委外订单修改】";
	}
	function insert(){
		//showPopWin("","initConsignProcessOrderInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200, '',null,true);
		//selectHidden();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initConsignProcessOrderInsert.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initConsignProcessOrderInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【委外订单新增】";
	}
	function del(id, supplierID){
		//showPopWin("","initConsignProcessOrderDelete.action?hid="+id+'&bbdsupplierid='+supplierID+"&moduleID=${requestScope.moduleID}",400,220, '',null,true);
		//selectHidden();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initConsignProcessOrderDelete.action?hid="+id + '&bbdsupplierid='+supplierID+"&moduleID=${requestScope.moduleID}",450,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【委外订单删除】";
	}
	function view(id){
			var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initConsignProcessOrderView.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initConsignProcessOrderView.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【委外订单详细】";
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function clean(){
		document.getElementById('billID').value = "";
		document.getElementById('endTime').value = "";
		document.getElementById('auditState').value = "";
		document.getElementById('startTime').value = "";
		document.getElementById('createPersonName').value = "";
		document.getElementById('auditPersonName').value = "";
		document.getElementById('selcategoryid').value = "";
		document.getElementById('selsupplierid').value = "";
		document.getElementById('selsuppliername').value = "";
		document.getElementById('salesid').value = "";	
		document.getElementById('goodsName').value = "";			
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		// 开窗条件 categoryID_open
		var id=document.getElementById("selcategoryid").value=='2'?'3':document.getElementById("selcategoryid").value;
		
		//var id=document.all.selcategoryid.value=='2'?'3':document.all.selcategoryid.value;
		//showPopWin("","selSupplierOpen.action?categoryID_open=" + id,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=" + id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=" + id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('selsupplierid').value = json.id;
		document.getElementById('selsuppliername').value = json.value;
	}
	
	/** 
     * 时间对象的格式化
     */  
    Date.prototype.format = function(format) {  
        /* 
         * eg:format="YYYY-MM-dd hh:mm:ss"; 
         */  
        var o = {  
            "M+" :this.getMonth() + 1, // month  
            "d+" :this.getDate(), // day  
            "h+" :this.getHours(), // hour  
            "m+" :this.getMinutes(), // minute  
            "s+" :this.getSeconds(), // second  
            "q+" :Math.floor((this.getMonth() + 3) / 3), // quarter  
            "S" :this.getMilliseconds()  
        // millisecond  
        }  
      
        if (/(y+)/.test(format)) {  
            format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
        }  
      
        for ( var k in o) {  
            if (new RegExp("(" + k + ")").test(format)) {  
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));  
            }  
        }  
        return format;  
    }
	
	function today(){
		
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('startTime').value = now;
		document.getElementById('endTime').value = now;		
	}
	  $(document).ready(function() { 
			$("img[btn=btn]").attr("style","cursor: hand"); 
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
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%" ><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>采购管理</TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：委外订单管理</TD>
            
            <TD align="right" width="40%" valign="bottom" >&nbsp;
            <c:if test="${(permissionPo.keya==1)}">
            	<img src="${ctx }/img/newbtn/btn_wwddadd_0.png" btn=btn  title="委外订单新增" onClick="insert()">
            	</c:if>
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
          
            </TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="4">
            <table></table>
            	</TD>
          </TR>
        </TBODY>
      </TABLE><TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR><TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
          <!--?Start-->
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                       onclick="JavaScript:window.location.href='initUnConsignProcessOrderSel.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">未生成委外订单</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                   
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">已生成委外订单</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    </TR></TBODY></TABLE></TD>
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
                          <TD class="table_body" width="9%" height="26">单据编号</TD>
                          <TD class="table_none" width="32%"><input class="text_input160" id="billID" name="billID" value="${billID }"></TD>
                          <TD class="table_body" width="9%">配镜单号</TD>
                          <TD class="table_none" width="20%">
						  	<input class="text_input160" type="text"  id="salesid" name="salesid" value="${salesid}">
						  </TD>
                          <TD class="table_body" width="9%">制单人</TD>
                          <TD class="table_none"><input class="text_input160" id="createPersonName" name="createPersonName" value="${createPersonName }">
                          </TD>
                        </TR>  
                        <TR>
                          <TD class="table_body">制造商</TD>
						   	<TD height="26" align="left" class="table_none">
						   	<li class="horizontal_onlyRight">
						   		<input id="bspsuppliername" class="text_input160" name="selsuppliername" value="${selsuppliername }" readonly="readonly" />
						   		<input type="hidden" id="selsupplierid" name="selsupplierid" value="${selsupplierid }" />
						   	</li>
						   	<li class="horizontal_onlyRight">
						   <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" name=ctl00$PageBody$Button1 onClick="openSupplier();"></li>
						  </TD>
                          <TD class="table_body">审核人</TD>
                          <TD class="table_none"><input class="text_input160" id="auditPersonName" name="auditPersonName" value="${auditPersonName }">
                          </TD>
                          <TD class="table_body table_body_NoWidth" height="26">审核状态</TD>
                          <TD class="table_none table_none_NoWidth">
                          <select name="auditState" id="auditState" >
                            <option value="" selected>----请选择----</option>
                            <option value='1' ${auditState == 1 ? 'selected="selected"' : '' }>已审核</option>
                            <option value='0' ${auditState == 0 ? 'selected="selected"' : '' }>未审核</option>
                          </select></TD>
                        </TR>                      
                        <TR>
                          <TD class="table_body" width="10%">单据日期</TD>
                          <TD class="table_none"> <li class="horizontal_onlyRight"><input id="startTime"
					       name="startTime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${startTime }" /> 至 <input id="endTime"
					       name="endTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime }" /></li><li class="horizontal_onlyRight">
<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today()">
</li>
					      </TD>
                          <TD class="table_body" height="26">订单类型</TD>
                          <TD class="table_none">
						  <select name="selcategoryid" id="selcategoryid">
						  		<option value="">----请选择----</option>
				  				<option value="2" ${selcategoryid == 2 ? 'selected="selected"' : '' }>框镜订做片</option>
				  				<option value="4" ${selcategoryid == 4 ? 'selected="selected"' : '' }>隐形订做片</option>
						  </select>
						  </TD>
                          <TD height="26" class="table_body">商品名称</TD>
                          <TD class="table_none">
                              <input class="text_input200" id="goodsName" name="goodsName" value="${goodsName}" maxlength="100">
                          </TD> 
						  </TD>
                        </TR>                                   
                      </TBODY>
                    </TABLE>
					<table id="title2" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left">
                          <c:if test="${(permissionPo.keyb==1)}">
							<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="javascript:search()">
<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean()" >

							</c:if>	
						</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
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
					<c:if test="${not empty(consignProcessOrders)}">
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
                        <TH width="9%" scope=col colspan="3">操作</TH>
                          <TH width="15%" height="26" scope=col>单据编号</TH>
                          <TH width="8%" height="26" scope=col>订做类型</TH>                          
						  <th width="28%">制造商</th>
						  <TH width="7%" scope=col>制单人</TH>
						  <TH width="13%" scope=col>单据日期</TH>    
						  <TH width="7%" scope=col>审核人</TH>                      
                          <TH width="13%" scope=col>审核日期</TH>
                        </TR>
                        <c:forEach var="po" items="${consignProcessOrders}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                        
                        <TD width="3%">
	                          <c:if test="${(permissionPo.keye==1)}">
			                     <img src="${ctx }/img/newbtn/search_0.png" title='详细'  btn=btn onClick="javascript:view('${po.cstcpoorderbillid}')">
			                  </c:if>
			                   </TD>
			                   <TD width="3%">
			                  <c:if test="${(permissionPo.keyc==1)}">
	                          
	                          	<c:if test="${po.cstcpoauditstate != 1}">
	                          		<img src="${ctx }/img/newbtn/edit_0.png" title='修改'  btn=btn  onClick="update('${po.cstcpoorderbillid }')">
	                          	</c:if>
	                          	<c:if test="${po.cstcpoauditstate == 1}">
	                          		<img src="${ctx }/img/newbtn/edit_2.png" title='修改'>
	                          	</c:if>
	                          </c:if>
	                          </TD>
	                          <TD width="3%">
	                          <c:if test="${(permissionPo.keyd==1)}">
	                          	<c:if test="${po.cstcpoauditstate != 1}">
	                          		<img src="${ctx }/img/newbtn/delete_0.png" title='删除'  btn=btn onClick="del('${po.cstcpoorderbillid }')" >
	                          	</c:if>
	                          	<c:if test="${po.cstcpoauditstate == 1}">
	                          		<img src="${ctx }/img/newbtn/delete_2.png" title='删除'>
	                          	</c:if>
	                          </c:if>
                          </TD>
                        
                          <TD height="26">${po.cstcpoorderbillid }</TD>
                          <TD>
                          <c:choose>
                          	<c:when test="${po.cstcpoordergoodscategory=='2'}">
                          		框镜订做片
                          	</c:when>
                          	<c:when test="${po.cstcpoordergoodscategory=='4'}">
                          		隐形订做片
                          	</c:when>
                          	<c:otherwise>
                          		错误类型
                          	</c:otherwise>
                          </c:choose>
                          </TD>
						  <td>${po.bspsuppliername }</td>   
						  <TD>${po.createPersonName }</TD>                       
                          <TD>${fn:substring(po.cstcpobilldate,0,16)}</TD>
                          <TD>${po.auditPersonName }</TD>                          
                          <TD>${fn:substring(po.cstcpoauditdate,0,16)}</TD>
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
    <TD height=5><br><br></TD></TR></TBODY></TABLE></DIV></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
