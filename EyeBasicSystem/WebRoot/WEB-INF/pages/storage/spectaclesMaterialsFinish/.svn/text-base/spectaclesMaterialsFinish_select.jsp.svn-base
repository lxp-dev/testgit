<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>配镜已发料管理</title>

<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<!--<link rel="stylesheet" type="text/css" href="${ctx }/css/module/thickbox.css" /> -->
</head>
<script>	
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	});
	
	function search(){
		$("img").removeAttr("onclick");	
		spectaclesMaterialsFinishForm.action = "selectSpectaclesMaterialsFinish.action";
		spectaclesMaterialsFinishForm.submit();
		showLoadingBar();
	}	

	function clean(){
	    document.all.salesid.value="";
	    document.all.salesStartTime.value="";
	    document.all.salesEndTime.value="";
	    document.all.personName.value="";
	    document.all.orderstype.value="";
	    document.all.shopcode.value="";
	    document.all.brandID.value="";
	    document.all.brandName.value="";
	    document.all.supplierID.value="";
	    document.all.supplierName.value="";
	    document.all.worrytype.value="";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	function detail(ssesbsalesid){
		document.all.hid.value = ssesbsalesid;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectSpectaclesMaterialsFinishDetail.action?hid="+ssesbsalesid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectSpectaclesMaterialsFinishDetail.action?hid="+ssesbsalesid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
	}
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
	
		//showPopWin("","selSupplierOpen.action",screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
	}
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
	    
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
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
		
		document.getElementById('salesStartTime').value = now;
		document.getElementById('salesEndTime').value = now;		
	}

	function winPopUp(id){
		document.all.hid.value = id;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectInTransitDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectInTransitDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【配镜单详细】";
	}

	/**
	 * 打印主程序入口
	 * @id	配镜单号；
	 * @billType	配镜单销售类型；1：框架成品；2：框架定制；3:隐形成品；4：隐形定制；5：辅料；
	 * @dingjinFlag	是否欠款；1：欠款；
	 * @wflag	打印类型；1：销售；-1：退款；（为''空时，表示1)
	 */
	function setReportEvent(id,billType,dingjinFlag,wflag){	
		var DataURL='';
		
		//1、打印定金单
		if(dingjinFlag=='1'){//需要进行订金单打印
	    	if ($.trim('${systemParameterPo.fspsubscriptionbillname}') == ''){//没有配置订金单样式
	            alert('请先配置订金单样式!');
	            return;
	        }else{
				if($.trim('${systemParameterPo.fspsubscriptionbillserver}') =="1"){
					DataURL="report.action?reportlet=${systemParameterPo.fspsubscriptionbillname}&salesid="+id;
				}else if($.trim('${systemParameterPo.fspsubscriptionbillserver}') =="2"){
	    			DataURL = '<%= getServletContext().getInitParameter("rptUrl")%>';
	    			DataURL+="eims_reporting/${systemParameterPo.fspsubscriptionbillname}&salesID="+id+"&rs:Command=Render";	
	    		}
				window.open (DataURL, '订金单', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
	        }				
		}

		//2、打印配镜单
    	if(billType=='1' || billType=='2'){
    		if ($.trim('${systemParameterPo.fspsalesbillname1}') == ''){
	            alert('请先配置框架配镜单样式!');
	            return;
	        }else{
	    		if($.trim('${systemParameterPo.fspsalesbillserver1}') =="1"){
	    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname1}&wflag="+ wflag +"&salesid="+id;
	    		}else if($.trim('${systemParameterPo.fspsalesbillserver1}') =="2"){
	    			DataURL = '<%= getServletContext().getInitParameter("rptUrl")%>';
	    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname1}&wflag="+ wflag +"&salesID="+id+"&rs:Command=Render";	
	    		}
	        }    			
    	}else if(billType=='3' || billType=='4'){
    		if ($.trim('${systemParameterPo.fspsalesbillname3}') == ''){
	            alert('请先配置隐形配镜单样式!');
	            return;
	        }else{
	    		if($.trim('${systemParameterPo.fspsalesbillserver3}') =="1"){
	    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname3}&wflag="+ wflag +"&salesid="+id;
	    		}else if($.trim('${systemParameterPo.fspsalesbillserver3}') =="2"){
	    			DataURL = '<%= getServletContext().getInitParameter("rptUrl")%>';
	    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname3}&wflag="+ wflag +"&salesID="+id+"&rs:Command=Render";	
	    		}
	        }       	
	    }else if(billType=='5'){
    		if ($.trim('${systemParameterPo.fspsalesbillname5}') == ''){
	            alert('请先配置辅料配镜单样式!');
	            return;
	        }else{
	    		if($.trim('${systemParameterPo.fspsalesbillserver5}') =="1"){
	    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname5}&wflag="+ wflag +"&salesid="+id;
	    		}else if($.trim('${systemParameterPo.fspsalesbillserver5}') =="2"){
	    			DataURL = '<%= getServletContext().getInitParameter("rptUrl")%>';
	    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname5}&wflag="+ wflag +"&salesID="+id+"&rs:Command=Render";	
	    		}
	        } 		    
		}else{
			alert("单据类型异常！");
			return;
		}
	    window.open (DataURL, '结款单', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');

	    //3、天津眼科弹出的第二个报表
	    if(wflag=='1' || wflag == ''){
	    	printGSL('${departmentID}',id,dingjinFlag); 
	    }else if(wflag=='-1'){
	    	printGSL_TH('${departmentID}',id);
	    }	      
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="spectaclesMaterialsFinishForm" method="post" action="">
<input type="hidden" name="hid">
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>配镜管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：配镜发料 </TD>
            <td align="right" valign="bottom">
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_isshowsearch_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_isshowsearch_0.png');" title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text align="right" colspan="3" valign="bottom">
             <table></table>
            </TD>
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
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initSpectaclesMaterialsSel.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">配镜发料</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='selectSpectaclesMaterialsAuto.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">配镜发料(自动刷新)</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                      width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">配镜已发料</TD>
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
							<table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="8%" height="26" class="table_body">配镜单号</TD>
			               <TD class="table_none" width="23%">
                            <input class="text_input160" type="text"  id="salesid" name="salesid" value="${requestScope.salesid}">
			               </TD>
			               <TD width="8%" height="26" class="table_body">配镜日期</TD>
			               <TD class="table_none" width="29%">
                           <li class="horizontal_onlyRight">  <input id="salesStartTime"
					       name="salesStartTime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'salesEndTime\')}'})"
					       value="${salesStartTime }" /> 至 
					       <input id="salesEndTime"
					       name="salesEndTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'salesStartTime\')}'})" 
					        value="${salesEndTime }" /> </li><li class="horizontal_onlyRight">
<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today()"></li>
			               </TD>
			               <TD width="8%" height="26" class="table_body">顾客姓名</TD>
			               <TD class="table_none">
                           <input class="text_input160" type="text"  id="personName" name="personName" value="${requestScope.personName}">
                           </TD>
                        </TR>
                    	<TR>
                    	   
						   <TD height="26" class="table_body">配镜类型</TD>
			               <TD class="table_none">
                              <select id="orderstype" name="orderstype" value="${requestScope.auditState}">
                                    <option value="">----请选择----</option>
							  		<option value="1" ${requestScope.orderstype!= "1"  ? '' : 'selected="selected"' }>镜架成品</option>
							  		<option value="2" ${requestScope.orderstype!= "2"  ? '' : 'selected="selected"' }>镜架订做</option>
	                          </select>
			               </TD>
			               <TD height="26" class="table_body">销售门店</TD>
			               <TD class="table_none">
                            <select id="shopcode" name="shopcode">
                             <option value="">----请选择----</option>
      		                 <c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.shopcode!= bdpdepartmentid  ? '' : 'selected="selected"' } >${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
			               </TD>
			              <TD height="26" class="table_body">加急状态</TD>
                          <TD class="table_none">
                          <select name="worrytype" id="worrytype"  >
                            <option value="">----请选择----</option>
                            <option value="1" ${requestScope.worrytype == '1' ? 'selected="selected"' : '' }>正常</option>
                            <option value="2" ${requestScope.worrytype == '2' ? 'selected="selected"' : '' }>加急</option>                           
                            </select><b><font color="red">*数据呈红色</font></b>
			               </TD>
                        </TR>
                        
                        <TR>
			               <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   		<input type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择"  onClick="openSupplier();"></li>
			               </TD>
						   <TD height="26" class="table_body">商品品种</TD>
			               <TD  class="table_none" colspan="3">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onClick="openBrand();"></li>
			               </TD>
                        </TR>                     
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
						<c:if test="${(permissionPo.keya==1)}"> 
							<td>
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
							</td>
						</c:if>
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
					<c:if test="${not empty(spectaclesMaterialsFinishList)}"> 
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>

					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="6%" scope=col colspan="2">操作</TH>
                          <TH width="13%" height="26" scope=col>配镜单号</TH>
                          <TH width="7%" scope=col>顾客姓名</TH>
						  <TH scope=col>销售门店</TH>						
						  <TH width="7%" scope=col>配镜类型</TH>
						  <TH width="13%" scope=col>配镜日期</TH>
						  <TH width="13%" scope=col>取镜日期</TH>
						  <TH width="7%" scope=col>发料人</TH>
						  <TH width="13%" scope=col>发料时间</TH>
						</TR>
						<s:iterator value="spectaclesMaterialsFinishList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" ${ssesbworrytype == '2' ? 'style="color: red;font:bold"' : '' }>
                          <TD width="3%"><img src="${ctx }/img/newbtn/search_0.png" title='详细' btn=btn onClick="javascript:detail('${ssesbsalesid}')"></TD>
                          <TD width="3%"><img src="${ctx }/img/newbtn/print_0.png" title='打印' btn=btn onClick="javascript:setReportEvent('${ssesbsalesid}','${ssesborderstype}','${ssesbcheckoutflag }','1')"></TD>
                          <TD height="26"><U style="cursor: hand;" onclick="winPopUp('${ssesbsalesid}')">${ssesbsalesid}</U></TD>
                          <TD>${ssesbpersonName}</TD>
                          <TD>${ssesbshopName}</TD>
                          <c:if test="${ssesborderstype==1}">
                          <TD>镜架成品</TD>
                          </c:if>
                          <c:if test="${ssesborderstype==2}"> 
                          <TD>镜架订做</TD>
                          </c:if>
                          <TD>${fn:substring(ssesbsalesdatetime,0,16)}</TD>
                          <TD>${fn:substring(ssesbtakeglassdata,0,16)}</TD>
                          <TD>${ssesbmaterialsperson}</TD>
                          <TD>${fn:substring(ssesbmaterialsdate,0,16)}</TD>
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