<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>盘点管理</title>
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
		if(checkForm(document.all.checkStorageForm)){
		    $("img").removeAttr("onclick");
			checkStorageForm.action = "insertCheckBarcode.action";
			checkStorageForm.submit();
		}
	}
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        for(var i=0;i<chk.length;i++){
           chk[i].checked = chks.checked;
        }
    }
    
    function search(){
		if(checkForm(document.all.checkStorageForm)){  
			checkStorageForm.action = "selInsertCheckStorage.action";
			checkStorageForm.submit();
			showLoadingBar();
		}
	}
	
	function del(id, supplierID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initCheckStorageDelete.action?hid="+id + "&bbdsupplierid=" + supplierID,400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initCheckStorageDelete.action?hid="+id + "&bbdsupplierid=" + supplierID,400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【盘点单删除】";
	}
	
	function audit(id, supplierID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initCheckStorageAudit.action?hid="+id + '&bbdsupplierid=' + supplierID,400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initCheckStorageAudit.action?hid="+id + '&bbdsupplierid=' + supplierID,400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【盘点单审核】";
	}
	
	function view(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initCheckStorageView.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initCheckStorageView.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【盘点单详细】";
	}
	
	function importInit(){
		var stockid = document.getElementById("cshcsstockid").value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInsertCheckBarcode.action?stockid="+stockid,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertCheckBarcode.action?stockid="+stockid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【盘点单导入】";
	}
	
	function build(){
		var my_array = new Array();
		
		var chk=document.getElementsByName("chk");
        for(var i=0;i<chk.length;i++){
           if (chk[i].checked){
           		my_array[i] = chk[i].value;
           }
        }

		<c:if test="${systemParameterPo.fspcheckstorageflag eq '1'}">
		if('${goodscategoryID }' == ''){
			alert("请选择商品类别进行查询，再进行汇总！");
			return;
		}
		</c:if>	

        
        if(my_array.length == 0){
        	alert("请选择临时盘点单！");
        	return;
        }
        var con = confirm("确定要汇总盘点单吗？");
			if(con == true){
			document.all.huizong.disabled="true";
			document.all.checkid.value=my_array.join(",");

			checkStorageForm.action = "buildCheckStorage.action";
		    checkStorageForm.submit();
		 	
		}else{
			return;
			
		}
	}
	function selectContact(obj){
		if(event.keyCode==13){
			search();
		}
	}
	
	function clean(){
		$("#goodscategoryID").val("");
		//document.getElementById('cshcsstockid').value = "";
		document.getElementById('cshcsauditstate').value = "";
		document.getElementById('cshcsbillid').value = "";
	}
</script>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } onkeyup="selectContact(this)">
<form name="checkStorageForm" method="post" action="" >
<!--  <input type="hidden" id="checkStorageid" name="checkStorageid" value="" /> -->
<input type="hidden" id="checkid" name="checkid" value="" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
          </TD>
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
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <TABLE width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="addTable">
                      <TBODY>
                        <TR>
						   <TD class="table_body">盘点仓位</TD>
						   <TD height="26" align="left" class="table_none">
							   <select id="cshcsstockid" name="checkStoragePo.cshcsstockid" 
							   		validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择盘点仓位！'}]">
	      		                 <s:iterator value="warehouselist">
					               <option value="${bwhid}" ${checkStoragePo.cshcsstockid == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
		     	                 </s:iterator>
	      	                   </select>
      	                   </TD>
      	                   <TD class="table_body">盘点单号</TD>
						   <TD height="26" align="left" class="table_none">
							   <input class="text_input160" type="text" id="cshcsbillid" name="checkStoragePo.cshcsbillid" value="${checkStoragePo.cshcsbillid }">
      	                   </TD>
      	                   <TD class="table_body">审核状态</TD>
						   <TD height="26" align="left" class="table_none">
							   <select id="cshcsauditstate" name="checkStoragePo.cshcsauditstate">
							   	   <option value="" >----请选择----</option>
					               <option value="1" ${checkStoragePo.cshcsauditstate!= "1"  ? '' : 'selected="selected"'}>审核</option>
					               <option value="0" ${checkStoragePo.cshcsauditstate!= "0"  ? '' : 'selected="selected"'}>未审核</option>
	      	                   </select>
      	                   </TD>
      	                </TR>
      	                <tr>
      	                	<td class="table_body">商品类型</td>
      	                	<td class="table_none" colspan="5" height="26">
     	                	<c:choose>
     	                		<c:when test="${systemParameterPo.fspcheckstorageflag eq '1'}">
	      	                	<select id="goodscategoryID" name="goodscategoryID">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategorys">
					               <option value="${bgcid}" ${goodscategoryID == bgcid ? 'selected="selected"' : '' }>${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                    </select>
								</c:when>
								<c:otherwise>
									<input type="hidden" value=""  id="goodscategoryID" name="goodscategoryID" />不限定商品类别	
								</c:otherwise>
							</c:choose>      	                	
							</td>
      	                </tr>
                      </TBODY>
                    </TABLE>
                    <table id="searchBar"  cellspacing="2" width="100%">
                      <TBODY>
                        <TR>
                          <TD align="left">
							<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询'  onclick="search();">&nbsp;<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">&nbsp;<img src="${ctx }/img/newbtn/btn_importcheckpage_0.png" btn=btn title="导入盘点文件..." onClick="importInit();"></TD>
							<TD align="right" width="7%"><img src="${ctx }/img/newbtn/btn_totalcheckpage_0.png" btn=btn id='huizong' title='汇总盘点单' onclick="build();"></TD>
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
								document.getElementById("searchBar").style.display="none";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
                    <c:if test="${not empty(checkStorages)}">
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
                          <TH scope=col width="5%" height="26">全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>
                          <TH width="12%" scope=col colspan="3">操作</TH>
                          <TH width="25%" scope=col>盘点单编号</TH>
                          <TH scope=col>盘点单名称</TH>
                          <TH scope=col>盘点类型</TH>
						  <TH width="10%">盘点日期</TH>
                          <TH width="10%">盘点仓位</TH>
                          <TH width="7%" scope=col>盘点人</TH>
                        </TR>
                        <c:forEach var="po" items="${checkStorages}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                        <TD>
                        <c:choose>
                        	<c:when test="${po.cshcsauditstate == 1 }">
                        	<input type="checkbox" id="chk" name="checkStorageid" value="${po.cshcsbillid }"></TD>
                        	</c:when>
                        	<c:otherwise>--</c:otherwise>
                        </c:choose>
                          <TD>
		                      <img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="javascript:view('${po.cshcsbillid}')">
		                  </TD>
                          <TD>
                          	<c:if test="${po.cshcsauditstate == 1}">
                          		<img src="${ctx }/img/newbtn/audit_2.png" title='审核'>
							</c:if> 
							<c:if test="${po.cshcsauditstate != 1}">
                          		<img src="${ctx }/img/newbtn/audit_0.png" btn=btn title='审核' onClick="audit('${po.cshcsbillid }')">
							</c:if>                          
                          </TD>
                          <TD><img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="del('${po.cshcsbillid }')" ></TD>
                          <TD height="26">${po.cshcsbillid }</TD>
						  <td>${po.cshcscheckname }</td>
						  <td>${po.cshccategoryname }</td>
                          <TD>${fn:substring(po.cshcscheckdate,0,10)}</TD>
						  <td>${po.cshcsstockname }</td>
                          <TD>${po.cshcscheckstockpersonname }</TD>
                        </TR>
                        </c:forEach>
                       
                      </TBODY>
                    </TABLE>
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
