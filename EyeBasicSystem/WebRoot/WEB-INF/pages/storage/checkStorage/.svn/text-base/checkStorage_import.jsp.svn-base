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

    	if('${errorBarcode}'){
			alert('${errorBarcode}');
        }
	});

	function save(){
		<c:if test="${systemParameterPo.fspcheckstorageflag eq '1'}">
		if(!$("#goodscategoryID").val()){
			alert("请选择商品类别！");
			return;
		}
		</c:if>		
		
		if(checkForm(document.all.checkStorageForm)){
			if(document.getElementById('fileUpload').value == ''){
				alert('请添加盘点文件！');
				return;
			}
			showLoadingBar();
		    $("img").removeAttr("onclick");
			checkStorageForm.action = "insertCheckBarcode.action";
			checkStorageForm.submit();
		}
	}
	
	function ck(obj){
		if(obj.value.length>0){
			var af="txt";
			if(eval("with(obj.value)if(!/"+af.split(",").join("|")+"/ig.test(substring(lastIndexOf('.')+1,length)))1;")){
				alert("文件类型默认txt");
				obj.select(); 
				document.execCommand("delete");
			}
		}
	}

</script>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="checkStorageForm" method="post" action="${requestScope.url}" enctype ="multipart/form-data">
<input type="hidden" name="type" id="type" value="" /> 

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
                    <TABLE cellSpacing=1 cellPadding=0 width="100%" align=center class="privateBorder"
                  border=0>
                      <TBODY>
                        <TR>
                          <TD width="9%" class="table_body">单据编号</TD>
                          <TD width="24%" class="table_none"><input class="text_input200" name="checkStoragePo.cshcsbillid" readonly="readonly" value="${checkStoragePo.cshcsbillid }"></TD>
                          <TD width="9%" class="table_body">单据日期</TD>
                          <TD width="24%" class="table_none">&nbsp;<jsp:useBean id="now" class="java.util.Date" /><fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />
                          <input class="text_input100" type="hidden"
					       name="checkStoragePo.cshcscheckdate" type="text" readonly="readonly" value="<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />"/></TD>
                          <TD width="9%" class="table_body">盘点单名称</TD>
						  <TD height="26" align="left" class="table_none"><input class="text_input160" name="checkStoragePo.cshcscheckname" maxlength="50" value=""
						   		validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请输入盘点单名称！'}]"/>
						   </TD>
      	                </TR>
                        <TR> 
                          <TD class="table_body">盘点仓位</TD>
						   <TD height="26" align="left" class="table_none">
						   <select id="cshcsstockid" name="checkStoragePo.cshcsstockid">
      		                 <s:iterator value="warehouselist">
				               <option value="${bwhid}" ${stockid == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
      	                   </TD>
                          <TD class="table_body" height="26">盘点人</TD>
                          <TD class="table_none">${person.personName }<input class="text_input100" type="hidden" name="checkStoragePo.cshcscheckstockperson" value="${person.id }"></TD>
                          <td class="table_body">盘点类型</td>
      	                	<td class="table_none">
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
									<input type="hidden" value="" name="goodscategoryID" />不限定商品类别	
								</c:otherwise>
							</c:choose>
      	                	</td>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <br/>
                    <TABLE width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="addTable">
                        <TR>
						   	<TD height="26" colspan="4" align="left" valign="middle" class="table_none">
						   		<INPUT class="text" id="fileUpload" name="checkBarcode" style="WIDTH: 500px;cursor:hand" type="file" name="fileUpload" 
								UNSELECTABLE="on" onpropertychange="ck(this)"/>
					       </TD>
					    </TR>
					</TABLE>
                    <TABLE id=title2 cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
					   <TR>
						  <TD align="left">
						  	<img id="submitButton" name="submitButton" src="${ctx }/img/newbtn/btn_importcheckpage_0.png" btn=btn title='导入盘点文件...' onClick="save();">
						  </TD>
                        </TR>                     
                    </TABLE>
                    <!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>系统操作中，请耐心等候...</div>
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
