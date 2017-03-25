<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员管理</title>
</head>
<script>	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	$('#memberid').focus();
	});
	
	function search(){
		if(checkForm(memberUpGradeForm)){
			$("img").removeAttr("onclick");
			memberUpGradeForm.action = "selectMemberUpGrade.action";
			memberUpGradeForm.submit();
			showLoadingBar();
		}
	}	
	function update(id)
	{
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initupdateMemberUpGrade.action?mid=" +id+"&only=1&moduleID="+document.all.moduleID.value,450,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initupdateMemberUpGrade.action?mid=" +id+"&only=1&moduleID="+document.all.moduleID.value,450,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【会员卡升级】";
	}
	
	function updateAll()
	{
		if($('input[name=smecimemberid]:checked').length==0)
		{
				alert("请选择需要升级的会员卡!");
				return;
		}
		var mid="";
		var nb=$('input[name=smecimemberid]:checked').length;
		for(var i=0;i<nb;i++)
		{
			mid+=$('input[name=smecimemberid]:checked').eq(i).val()+",";
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initupdateMemberUpGrade.action?mid=" +mid+"&moduleID="+document.all.moduleID.value,450,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initupdateMemberUpGrade.action?mid=" +mid+"&moduleID="+document.all.moduleID.value,450,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【会员卡升级】";
	}
	function upGrade(smecimemberid){
		document.all.memberUpGradeID.value=smecimemberid;
		if (confirm("会员卡号：" + smecimemberid + " 是否确认升级?")){
			memberUpGradeForm.action = "updateMemberUpGrade.action?memberUpGradeID="+smecimemberid;
			memberUpGradeForm.submit();
	    }
	}

	function clean(){
	    document.all.memberid.value="";
	    document.all.membername.value="";
	    document.all.smecicardtype.value="";
	    document.all.fmmup.value="";
	    document.all.fmmdown.value="";
	}	
	
	function permissionMessage(){
       alert('您无此操作权限');
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
    
    /*判断保存按钮是否为空 */
	function allUpGrade(id){
		if(checkForm(document.all.memberUpGradeForm)){
				if($('input[name=smecimemberid]:checked').length==0){
					alert("请选择需要升级的会员卡!");
					return;
				}
				if (confirm("所选会员卡号是否确认升级?")){
					document.all.hid.value = id;
					memberUpGradeForm.action = "updateAllMemberUpGrade.action";
					memberUpGradeForm.submit();	
				}
		}
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="memberUpGradeForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="memberUpGradeID" name="memberUpGradeID" value="${ssesbsalesid}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>会员信息</TD>
            <td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：会员积分升级</td>
            <td align="right" valign="bottom">&nbsp;
            <%--<c:if test="${permissionPo.keya=='1'}">
            	<img name="button" src="${ctx }/img/newbtn/btn_levelup_0.png" btn=btn title='升级选中的会员卡' onclick="updateAll()"/>
            </c:if>--%>
            	<img name="button" src="${ctx }/img/newbtn/btn_levelup_0.png" btn=btn title='升级选中的会员卡' onclick="updateAll()"/>
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn  title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
              	<c:if test="${permissionPo.keyc eq '1' }">
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                        <TD class=tab id=tabLabel__1                    
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">会员积分升级</TD>
                        <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
                </c:if>      
              	<c:if test="${permissionPo.keyd eq '1' }">
                      <TD width=3><IMG id=tabImgLeft__0 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif onclick="JavaScript:window.location.href='initMemberHandUpGradeSel.action?moduleID=${requestScope.moduleID}'"
                      UNSELECTABLE="on">会员卡升级</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 src="${ctx}/img/pic/tab_unactive_right.gif" width=3 ></TD>
                </c:if>                       
              	<c:if test="${permissionPo.keye eq '1' }">
                      <TD width=3><IMG id=tabImgLeft__0 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif onclick="JavaScript:window.location.href='initUpGradeRecordSel.action?moduleID=${requestScope.moduleID}'"
                      UNSELECTABLE="on">会员升级记录</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 src="${ctx}/img/pic/tab_unactive_right.gif" width=3 ></TD>
                </c:if>                       
					</TR></TBODY></TABLE></TD>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   	<TD width="8%" height="26" class="table_body">会员卡号</TD>
			               	<TD class="table_none" width="25%">
                            <input class="text_input160" type="text" id="memberid" name="memberid" value="${requestScope.memberid}">
			               	</TD>
			               	<TD width="8%" height="26" class="table_body">会员姓名</TD>
                      		<TD class="table_none" width="25%">
                      		<input class="text_input160" type="text"  id="membername" name="membername" value="${requestScope.membername}">
                      		</TD>
                      		<TD width="8%" height="26" class="table_body">会员卡类型</TD>
                            <TD class="table_none">
                          		<select id="smecicardtype" name="smecicardtype">
                          		<option value="">----请选择----</option>
                              		<c:if test="${not empty(memberManageMentList)}">
                                 	<c:forEach var="i" items="${memberManageMentList}" varStatus="index">
                                    	<OPTION value="${i.fmmid}" ${requestScope.smecicardtype == i.fmmid ? 'selected="selected"' : '' }>${i.fmmmembername}</OPTION>
                                 	</c:forEach>
                                </c:if>
                            	</select> 
			               	</TD>
                        </TR>
                    	<TR>
			               	<TD height="26" class="table_body">积分</TD>
                        	<TD class="table_none" colspan="5">
                        		<input class="text_input100" id="fmmup" name="fmmup" value="${requestScope.fmmup}"
                        		validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '积分只能填写数字！'}]" >
						   		 至
						      	<input class="text_input100" id="fmmdown" name="fmmdown" value="${requestScope.fmmdown}"
						      	validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '积分只能填写数字！'}]" >
                        	</TD>
                        </TR>                         
                      </TBODY>
                    </TABLE>
                    <%--<c:if test="${permissionPo.keya=='1'}">
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" id="submitButton" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" title="清空" btn=btn onClick="clean()">
								
							</td>
						</tr>
					</table>
					</c:if>--%>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" id="submitButton" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" title="清空" btn=btn onClick="clean()">
								
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
					<c:if test="${not empty(memberUpGradeList)}"> 
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
                          <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>
						  <TH width="3%" scope=col>操作</TH>
						  <TH width="20%" scope=col>会员卡号</TH>						
						  <TH width="15%" scope=col>会员卡类型</TH>
						  <TH width="15%" scope=col>会员积分</TH>
						  <TH width="15%" scope=col>姓名</TH>
						  <TH width="15%" scope=col>性别</TH>
						  </TR>
						<s:iterator value="memberUpGradeList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><input type="checkbox" id="chk" name="smecimemberid" value="${smecimemberid}"></TD>
                          <TD width="3%">
		                     <img src="${ctx }/img/newbtn/levelup_0.png" title='升级' btn=btn onClick="javascript:update('${smecimemberid}')">
		                  </TD>
                          <TD>${smecimemberid}</TD>
                          <TD>${fmmmembername}</TD>
                          <TD>${smeciintegral}</TD>
                          <TD>${smeciname}</TD>
                          <c:if test="${smecisex==1}">
                          <TD>女</TD>
                          </c:if>
                          <c:if test="${smecisex==0}">
                          <TD>男</TD>
                          </c:if>
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
<script type="text/javascript">

	permissionCheck();
	function permissionCheck() {
		if("${permissionPo.keyc}" == 0 && "${permissionPo.keyd}" == 0 && "${permissionPo.keye}" == 0) {
	    	$("body").hide();
	    	alert("没有访问权限,请联系管理员!");
	    	//window.history.go(-1);
		}
	}
</script>
<%@ include file="/WEB-INF/inc/message.jsp" %>