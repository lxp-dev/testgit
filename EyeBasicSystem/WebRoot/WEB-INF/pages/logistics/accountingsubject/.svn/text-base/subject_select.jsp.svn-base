<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>科目管理</title>		
<script type="text/javascript">

   /**
    *  新增科目
    */ 
	function insert(parentSubjectID,parentSubjectName,parentID,parent){
		$('#parentID').val(parentID);
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		
		if(is_iPad()){
			showPopWin("initSubjectInsert.action?moduleID=${moduleID}&parent="+EncodeUtf8(parent)+"&parentSubjectID="+EncodeUtf8(parentSubjectID)+"&parentSubjectName="+EncodeUtf8(parentSubjectName)+"&parentID="+EncodeUtf8(parentID),970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initSubjectInsert.action?moduleID=${moduleID}&parent="+EncodeUtf8(parent)+"&parentSubjectID="+EncodeUtf8(parentSubjectID)+"&parentSubjectName="+EncodeUtf8(parentSubjectName)+"&parentID="+EncodeUtf8(parentID),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【会计科目新增】";
	}
	
   /**
    *  初始化修改科目
    */ 
	function update(subjectID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		var parent=document.getElementById("parent").value;
		if(is_iPad()){
			showPopWin("initSubjectUpdate.action?subjectID="+subjectID+"&parent="+parent+"&moduleID=${moduleID}&parentID="+$('#parentID').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initSubjectUpdate.action?subjectID="+subjectID+"&parent="+parent+"&moduleID=${moduleID}&parentID="+$('#parentID').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【会计科目修改】";
	}
	
   /**
    *  初始化删除科目
    */ 
	function del(hid,subjectID,subjectName){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		showPopWin("initSubjectDelete.action?hid="+hid+"&parent="+parent+"&subjectID="+subjectID+"&subjectName="+EncodeUtf8(subjectName)+"&moduleID=${moduleID}&parentID="+$('#parentID').val() ,450,140,topRows,topCols,returnRefresh(true),true);
		
		document.getElementById('popupTitle').innerHTML="【会计科目删除】";
	}
	
   /**
    *  重置
    */        
	function clean(){
	    $('input[clean=clean]').each(function(){
			$(this).val('');
		});
	}
	
   /**
    *  根据条件查询相关科目
    */        
	function search(){
	    subjectSelFrm.action = "selSubjectSet.action";
	    subjectSelFrm.submit();
		showLoadingBar();
	 }

   /**
    *  科目批量导入
    */        
	function batchInsert(){	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initBatchInsertSubject.action?moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initBatchInsertSubject.action?moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【会计科目批量导入】";
	 }
	 
	 $(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });     
    }); 

    /**
	 * 科目开窗
	 */ 
     function openSubject(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSubjectOpenTree.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSubjectOpenTree.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会计科目查询】";
     }
     
    /**
	 * 科目开窗赋值
	 */ 
     function openSubjectValue(json){
         document.getElementById("parentSubjectName").value=json.subject;
         document.getElementById("parentSubjectID").value=json.subjectID;
     }
</script>
	</head>
	<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<DIV>
<form method="post" id="subjectSelFrm" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="parentID" name="parentID" value="${requestScope.parentID}">
<input type="hidden" name="parent" id="parent" value="${parent}" >

<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;科目管理</TD>
          <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：会计科目查询</TD>
          <td align="right" width="40%" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keye==1)}">
            		<img btn=btn src="${ctx }/img/newbtn/btn_kmplxz_0.png"  title="科目批量新增" onClick="batchInsert()">
            	</c:if>
            	<c:if test="${(permissionPo.keya==1)}">
            		<img btn=btn src="${ctx }/img/newbtn/btn_kmxz_0.png" title="科目新增" onClick="insert('','','')">
            	</c:if>
				<img btn=btn src="${ctx }/img/newbtn/btn_isshowsearch_0.png" title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
          </td>
        </TR>
    
          <TR>
            <TD class=menubar_function_text colspan="4">
            	<table></table>
            </TD>
          </TR>
      </TBODY></TABLE><!-- ͷ˵ End --><!-- ѡ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR height="26px">
                          <TD width="9%" class="table_body">科目代码</TD>
                          <TD width="24%" class="table_none"><input clean="clean" class="text_input160" id="subjectID" name="subjectID" type="text" value="${subjectID}" maxlength="19"></TD>
                          <TD width="9%" class="table_body">科目名称</TD>
                          <TD width="24%" class="table_none">
                             <input clean="clean" class="text_input160" id="subjectName" name="subjectName" type="text" value="${subjectName}" maxlength="19">
                          </TD>
                          <TD width="9%" class="table_body">隶属科目</TD>
                          <TD width="24%" class="table_none">
                             <li class="horizontal_onlyRight">
                                 <input clean=clean type="text" id="parentSubjectName" name="parentSubjectName" readonly="readonly" value="${parentSubjectName}"><input clean=clean type="hidden" id="parentSubjectID" name="parentSubjectID" value="${parentSubjectID}">
                             </li>
                             <li class="horizontal_onlyRight">
                                 <img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onclick="openSubject();" >
                             </li>    
                          </TD>
                        </TR>
                       
                        </TBODY>
                    </TABLE>
					<table id="title2" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left">
                          <c:if test="${permissionPo.keyd=='1'}">							
							<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >			
                            <img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >	
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
                    <c:if test="${not empty(subjectList)}">
					 <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                     </TABLE>
					 <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH scope=col width="8%" colspan="2">操作</TH>
                          <TH scope=col width="15%" height="26">科目代码</TH>
						  <TH scope=col width="16%">科目名称</TH>  
                        </TR>
                      <s:iterator value="subjectList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">                      
                          <c:if test="${sLssFlag=='0'}">
		                  <TD width="4%">
		                   <c:if test="${permissionPo.keyc=='1'}"> 
                             <img src="${ctx }/img/newbtn/edit_2.png" title='修改'>
                             </c:if>
		                  </TD>
                          <TD width="4%">
                          <c:if test="${permissionPo.keyb=='1'}">  
                            <img src="${ctx }/img/newbtn/delete_2.png" title='删除'>
                            </c:if>
		                  </TD>
		                  </c:if>		                  
		                  <c:if test="${sLssFlag=='1'}">
		                  <TD width="4%">
		                  <c:if test="${permissionPo.keyc=='1'}"> 
                             <img btn=btn src="${ctx }/img/newbtn/edit_0.png" title='修改' onClick="javascript:update('${sLssID}')">
                             </c:if> 
		                  </TD>
		                  <TD width="4%">
		                  <c:if test="${permissionPo.keyb=='1'}">
                             <img btn=btn src="${ctx }/img/newbtn/delete_0.png" title='删除' onClick="javascript:del('${sLssID}','${sLssSubjectID}','${sLssSubjectName}')">
		                  </c:if> 
		                  </TD>
		                  </c:if>
		                  <TD height="26">${sLssSubjectID}</TD>
                          <TD>${sLssSubjectName}</TD>  
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
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></form></DIV></BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp"%>