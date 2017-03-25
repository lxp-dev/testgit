<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>验光</title>
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

	function details(id,sopecid){
		document.all.hid.value = id;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("detailEyesCheckHydsy.action?hid="+id+"&sopecid="+sopecid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("detailEyesCheckHydsy.action?hid="+id+"&sopecid="+sopecid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【验光信息详细】";
	}
	
	function search(optometryID,optometryBasicID,flag,chuyanfuyan,personid,sopoyoneormany){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;

		if(flag=='0'){
			if($('#personid').val()==personid){
				if(is_iPad()){
					showPopWin("initRefractiveUpdateHydsy.action?isfresh="+ document.getElementById("isfresh").value +"&optometryID="+optometryID+"&customerID="+'${customerInfoPo.smecicustomerid }'+"&source=inspectioniou&optometryBasicID="+optometryBasicID+"&moduleID="+'${moduleID}'+"&chuyanfuyan="+sopoyoneormany,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}else{
					showPopWin("initRefractiveUpdateHydsy.action?isfresh="+ document.getElementById("isfresh").value +"&optometryID="+optometryID+"&customerID="+'${customerInfoPo.smecicustomerid }'+"&source=inspectioniou&optometryBasicID="+optometryBasicID+"&moduleID="+'${moduleID}'+"&chuyanfuyan="+sopoyoneormany,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}
				document.getElementById('popupTitle').innerHTML="【验光信息更新】";
			}else{
				if(is_iPad()){
					showPopWin("initRefractiveSelectHydsy.action?isfresh="+ document.getElementById("isfresh").value +"&optometryID="+optometryID+"&customerID="+'${customerInfoPo.smecicustomerid }'+"&optometryBasicID="+optometryBasicID+"&moduleID="+'${moduleID}'+"&chuyanfuyan="+sopoyoneormany,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}else{
					showPopWin("initRefractiveSelectHydsy.action?isfresh="+ document.getElementById("isfresh").value +"&optometryID="+optometryID+"&customerID="+'${customerInfoPo.smecicustomerid }'+"&optometryBasicID="+optometryBasicID+"&moduleID="+'${moduleID}'+"&chuyanfuyan="+sopoyoneormany,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}
				document.getElementById('popupTitle').innerHTML="【验光信息详细】";
			}
		}else{
			if(is_iPad()){
				showPopWin("initRefractiveSelectHydsy.action?isfresh="+ document.getElementById("isfresh").value +"&optometryID="+optometryID+"&customerID="+'${customerInfoPo.smecicustomerid }'+"&optometryBasicID="+optometryBasicID+"&moduleID="+'${moduleID}'+"&chuyanfuyan="+sopoyoneormany,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("initRefractiveSelectHydsy.action?isfresh="+ document.getElementById("isfresh").value +"&optometryID="+optometryID+"&customerID="+'${customerInfoPo.smecicustomerid }'+"&optometryBasicID="+optometryBasicID+"&moduleID="+'${moduleID}'+"&chuyanfuyan="+sopoyoneormany,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【验光信息详细】";
		}
	}
	function printReport(id){
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("report.action?reportlet=sales_DoubleEyeFunRpt.cpt&OptometryID="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("report.action?reportlet=sales_DoubleEyeFunRpt.cpt&OptometryID="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【顾客验光记录】";
    }
	function inspectionCopy(){
		if('${customerInfoPo.smecicustomerid }'==''){
			alert('请输入顾客卡号!');
			return;
		}
		
		if('${optometryBasics[0].sopoboptometrybasicid}'==''){
				alert('未找到此顾客验光记录,请选择初验!');
				return;
		}
		
		showPopWin("","inspectionCopyHydsy.action?oldOptometryID="+'${optometryBasics[0].optometrys[0].sopoyoptometryid}'+"&customerID="+'${customerInfoPo.smecicustomerid }'+"&optometryBasicID="+'${optometryBasics[0].sopoboptometrybasicid}',screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	function insert(chuyanfuyan){
		if('${customerInfoPo.smecicustomerid }'==''){
			alert('请输入顾客卡号!');
			return;
		}
		
		optometryID=$('input[name=optometryPo\\.sopoyoptometryid]').val();
		if(chuyanfuyan=='0'){
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			if(is_iPad()){
				showPopWin("initRefractiveInsertHydsy.action?moduleID="+'${moduleID}'+"&customerID="+'${customerInfoPo.smecicustomerid}'+"&chuyanfuyan="+chuyanfuyan+"&optometryID="+optometryID+"&isfresh="+'${customerInfoPo.smecimemberid}',970,screen.height-200,topRows,topCols,returnRefresh(true),true);
			}else{
				showPopWin("initRefractiveInsertHydsy.action?moduleID="+'${moduleID}'+"&customerID="+'${customerInfoPo.smecicustomerid}'+"&chuyanfuyan="+chuyanfuyan+"&optometryID="+optometryID+"&isfresh="+'${customerInfoPo.smecimemberid}',screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
			}
			document.getElementById('popupTitle').innerHTML="【初验】";
			document.getElementById('isfresh').value='';
		}
		else{
			if('${optometryBasics[0].sopoboptometrybasicid}'==''){
				alert('未找到此顾客验光记录,请选择初验!');
				return;
			}
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			if(is_iPad()){
				showPopWin("initRefractiveInsertHydsy.action?moduleID="+'${moduleID}'+"&oldOptometryID="+'${optometryBasics[0].optometrys[0].sopoyoptometryid}'+"&customerID="+'${customerInfoPo.smecicustomerid}'+"&chuyanfuyan="+chuyanfuyan+"&optometryID="+optometryID+"&optometryBasicID="+'${optometryBasics[0].sopoboptometrybasicid}'+"&isfresh="+'${customerInfoPo.smecimemberid}',970,screen.height-200,topRows,topCols,returnRefresh(true),true);
			}else{
				showPopWin("initRefractiveInsertHydsy.action?moduleID="+'${moduleID}'+"&oldOptometryID="+'${optometryBasics[0].optometrys[0].sopoyoptometryid}'+"&customerID="+'${customerInfoPo.smecicustomerid}'+"&chuyanfuyan="+chuyanfuyan+"&optometryID="+optometryID+"&optometryBasicID="+'${optometryBasics[0].sopoboptometrybasicid}'+"&isfresh="+'${customerInfoPo.smecimemberid}',screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
			}
			document.getElementById('popupTitle').innerHTML="【复验】";
			document.getElementById('isfresh').value='';
		}
	}
	function clean(){
	    document.all.memberid.value="";
	    document.all.customername.value="";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	
	
	function del(optometryID,basicID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initOptometryBasicDeleteHydsy.action?basicID=" + basicID + "&optometryID="+optometryID+"&moduleID="+'${requestScope.moduleID}',400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initOptometryBasicDeleteHydsy.action?basicID=" + basicID + "&optometryID="+optometryID+"&moduleID="+'${requestScope.moduleID}',400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【验光信息删除】";
	}
	
	function glassHistory(){
		if('${customerInfoPo.smecicustomerid }'==''){
			alert('请输入顾客卡号!');
			return;
		}
		optometryBasicForm.action="selectGlassesHistoryHydsy.action?customerID="+'${customerInfoPo.smecicustomerid }';
		optometryBasicForm.submit();
	}
	
	
	window.onload=function(){
	
	}

	function update(optometryID,optometryBasicID,sopoyoneormany){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSpecialCheckUpdateHydsy2.action?optometryID="+optometryID+"&optometryBasicID="+optometryBasicID+"&moduleID="+'${moduleID}'+"&chuyanfuyan="+sopoyoneormany+"&customerID="+'${customerInfoPo.smecicustomerid }',970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSpecialCheckUpdateHydsy2.action?optometryID="+optometryID+"&optometryBasicID="+optometryBasicID+"&moduleID="+'${moduleID}'+"&chuyanfuyan="+sopoyoneormany+"&customerID="+'${customerInfoPo.smecicustomerid }',screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【相关检查更新】";
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="optometryBasicForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="customerID" value="${customerID}">
<input type="hidden" id="personid" name="personid" value="${createPerson }">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>验光管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：验光</TD>
            <td align="right" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keyb==1)}">
	            	<img src="${ctx }/img/newbtn/btn_firstoptometry_0.png" btn=btn title="初验" onclick="insert('0');"/>
	            	<img src="${ctx }/img/newbtn/btn_againoptometry_0.png" btn=btn title="复验" onclick="insert('1');" />
            	</c:if>
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr><td height="20px">&nbsp;</td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
				</TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                  <%--
                  <input type="hidden" id="customerReadonly" name="customerReadonly" value="readOnly" />  --%>
                  <s:action name="initCustomerOptometryTitleHydsy" executeResult="true" />
                  
                  <br/>
                  <c:if test="${not empty(optometryBasics)}">
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
                          <TH width="8%" height="26" scope=col colspan="11">顾客验光记录</TH>
                        </TR>
                        <c:forEach var="basicPo" items="${optometryBasics}" varStatus="basicIndex">
                        <TR  class=table_title align=middle>
                          <th width="12%" colspan="4">操作</th>
                          <TH height="26" colspan="7">验光号：${basicPo.sopoboptometrybasicid }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          							     初验时间：${fn:substring(basicPo.sopobmedicalstarttime, 0, 10) }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          							     复验结束时间：${fn:substring(basicPo.sopobmedicalendtime, 0, 10) }</TD>
                        </TR>
                        <c:forEach var="optometry" items="${basicPo.optometrys}" varStatus="optometryIndex">
                       	<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                       		<td width="3%">
                       			<c:if test="${(permissionPo.keyc==1)}">
                       			<img src="${ctx }/img/newbtn/search_0.png" btn=btn title='查看' onClick="search('${optometry.sopoyoptometryid }','${ basicPo.sopoboptometrybasicid}','${optometry.sopoyflag}','','${optometry.sopoypersonid }','${optometry.sopoyoneormany}')">
                       			</c:if>
                       		</td>
                       		<td width="3%">
                       			<c:if test="${(permissionPo.keyc==1)}">
                       			<img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="update('${optometry.sopoyoptometryid }','${ basicPo.sopoboptometrybasicid}','${optometry.sopoyoneormany}')">
                       			</c:if>
                       		</td>
                       		<td width="3%">
                       			<c:if test="${(permissionPo.keyd==1)}"> 
                       				<c:if test="${(optometry.sopoyflag!='1')}"> 
                       					<img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="del('${optometry.sopoyoptometryid }','${ basicPo.sopoboptometrybasicid}')">
                       				</c:if>
                       				<c:if test="${(optometry.sopoyflag=='1')}"> 
                       					<img src="${ctx }/img/newbtn/delete_2.png" btn=btn title='删除'>
                       				</c:if>
                       			</c:if>
                       		</td>
                       		<td width="3%">
                       			<c:if test="${(permissionPo.keyc==1)}">
                       			<img src="${ctx }/img/newbtn/print_0.png" btn=btn title='打印' onclick="printReport('${optometry.sopoyoptometryid }')">
                       			</c:if>
                       		</td>
                       		<TD height="26">${optometry.sopoyoptometryid }</TD>
                       		<input type="hidden" name="optometryPo.sopoyoptometryid" value="${optometry.sopoyoptometryid }"/>
                       		<TD>${optometry.sopoydepartmentname }</TD>
                       		<TD>${optometry.sopoypersonname }</TD>
                       		<TD>${fn:substring(optometry.sopoytime, 0, 16) }</TD> 
                       		<TD>${optometry.sopoyisinternal=='N'?'内方':'外方' }</TD>                    		
                       		<TD>${optometry.sopoyoneormany == '0' ? '初验':'复验'}</TD>
                       		<TD>${optometry.sopoyflag == '0' ? '非正式提交' : '正式提交' }</TD>
                       	</TR>
                        </c:forEach>
                        
                        </c:forEach>
                      </TBODY>
                    </TABLE>
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
					</c:if>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></HTML>
