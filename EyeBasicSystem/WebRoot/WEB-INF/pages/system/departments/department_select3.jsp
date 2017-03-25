<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门维护</title>
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

	function search(){
		$("img").removeAttr("onclick");
		departmentstForm.action = "departmentDateSel.action";
		departmentstForm.submit();
		showLoadingBar();
	}

	function detail(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDepartmentDetail.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDepartmentDetail.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【部门详细】";
		
	}
	
	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initDepartmentDateUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",600,400,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【部门期初日期/上线日期修改】";
	}	

	function update1(){
		var id = '';
		if($('input[id=chk]:checked').length == 0){
			alert("请选择部门!");
			return;
		}	

		$('input[id=chk]:checked').each(function(){
			id = id+$(this).val()+",";
		})
				
		update(id);
	}	
	
	function clean(){
		$('#departmentstForm').find("input[clean=clean]").each(function(){
			$(this).val('');
		});
		$('#departmentstForm').find("select[clean=clean]").each(function(){
			$(this).val('');
		});
	}

	function chkAll(){
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        for(var i=0;i<chk.length;i++){
           chk[i].checked = chks.checked;
        }
    }
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="departmentstForm" name="departmentstForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>基础信息 </TD>
            <TD align="left" width="30%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：部门期初维护 </TD>
            <td align="right" width="55%" valign="bottom">&nbsp;
				<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
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
                        <TR>
                          <TD width="10%" height="26" class="table_body">部门编号</TD>
                          <TD width="23%" class="table_none"><input clean="clean" class="text_input200" id="departmentID" name="departmentID" value="${departmentID}" maxlength="50"/></TD>
                          
                          <TD width="10%" height="26" class="table_body">部门名称</TD>
                          <TD width="23%" class="table_none"><input clean="clean" class="text_input200" id="departmentName" name="departmentName" value="${departmentName}" maxlength="50"/></TD>
                          
                          <TD width="10%" height="26" class="table_body">部门类型</TD>
                          <TD width="23%" class="table_none"><select clean="clean" id="departmentType" name="departmentType"">
                            <option value="">----请选择----</option>
                            <s:iterator value="departmentTypeList">
                                 <option value="${bdtid }" ${departmentType == bdtid ?'selected="selected"':''}>${bdtname}</option>
                            </s:iterator>
                          </select></TD>

                        </TR>
                        <TR>
                          <TD width="10%" height="26" class="table_body">所属加工中心</TD>
                          <TD width="24%" class="table_none"><select clean="clean" id="processDpt" name="processDpt" >
							  <option value="">----请选择----</option>
							<s:iterator value="processDptList">
                        	  <option value="${bdpdepartmentid }" ${processDpt == bdpdepartmentid ?'selected="selected"':''}>${bdpdepartmentname }</option>
                            </s:iterator>

                      	  </select></TD>
                          <TD height="26" class="table_body">部门状态</TD>
                          <TD height="26" class="table_none"><select clean="clean" id="departmentFlag" name="departmentFlag">
                            <option value="">----请选择----</option>
                            <option value="0" ${departmentFlag == '0' ?'selected="selected"':''}>启用</option>
                            <option value="1" ${departmentFlag == '1' ?'selected="selected"':''}>停用</option>
                          </select></TD>
                          <TD height="26" class="table_body">所属公司</TD>
                        	<TD height="26" class="table_none"  colspan="5">
                        	
                        	    <c:if test="${person.personcompanytype == '1'}">
	                        	    <select clean="clean" id="companysid" name="companysid">
		                              <option value="">----请选择----</option>
		                              <s:iterator value="companyNamePos">
		                              <option value="${fcnId}" ctype="${fcnmasterorvice }" ${companysid == fcnId ? 'selected="selected"':''}>${fcnName}</option>
		                              </s:iterator>
		                            </select>
                        	    </c:if>
                        	    
                        	    <c:if test="${person.personcompanytype == '2'}">
		                            ${person.personcompanyname}<input type="hidden" id="companysid" name="companysid" value="${person.personcompanyid }" readonly="readonly">
                        	    </c:if>
                        	</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    
                    <table id="title2" cellspacing="2">
						<tr height="26">
							<td><img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();" >
							    <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" >
							    <img src="${ctx }/img/newbtn/btn_szrq_0.png" btn=btn title='设置日期' onclick="update1();" >
							</td>
							<td>
							    <label style="color:red;"><b>&nbsp;&nbsp;各部门的期初日期和上线日期的修改可能会对当月的成本计算和报表产生影响，修改时要注意和做期初操作同一天完成！</b></label>
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
                    
                    <c:if test="${not empty(departmentList)}">
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
                          <TH width="12%" scope=col colspan="3">全选<input type="checkbox" id="chks" name="chks" onclick="chkAll()"></TH>
                          <TH width="8%" height="26" scope=col>编号</TH>
                          <TH width="10%" scope=col>部门名称</TH>
                          <TH width="8%" scope=col>部门类型</TH>
                          <TH width="10%" scope=col>所属加工中心</TH>
                          <TH width="15%" scope=col>所属公司</TH>
                          <TH width="10%" scope=col>期初日期</TH>
                          <TH width="10%" scope=col>上线日期</TH>
						  </TR>
						  						  
							<s:iterator value="departmentList">	
								<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
								  <TD width="3%">
		                              <input type="checkbox" id="chk" name="chk" value="${bdpdepartmentid}">
		                          </TD>
		                          <TD width="3%">
		                              <img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="javascript:detail('${bdpdepartmentid}')">
		                          </TD>
				                  <TD width="3%">
				                     <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${bdpdepartmentid}')">
				                  </TD>
		                          <TD height="26">${bdpdepartmentid}</TD>
		                          <TD>${bdpdepartmentname}</TD>
                                  <TD>${bdptypename}</TD>
		                          <TD>${bdpregname}</TD>
		                          <TD>${bdpcompanysname}</TD>		                          
		                          <TD>${bdpqcdate == '' ? '未设置' : bdpqcdate}</TD>
		                          <TD>${bdponlinedatre == '' ? '未设置' : bdponlinedatre}</TD>
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