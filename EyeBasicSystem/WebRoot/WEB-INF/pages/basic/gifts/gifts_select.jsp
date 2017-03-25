<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>赠品查询</title>
</head>
<script>
	function insert(){//新增
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGiftsInsert.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initGiftsInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【赠品新增】";
	}
	function update(bgsuuid){//修改
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGiftsUpdate.action?bgsuuid="+bgsuuid+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initGiftsUpdate.action?bgsuuid="+bgsuuid+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【赠品修改】";
	}
	function del(bgsuuid){//删除
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		showPopWin("initGiftsDelete.action?bgsuuid="+bgsuuid+"&moduleID=${requestScope.moduleID}",400,150, topRows,topCols,returnRefresh(true),true); 
		document.getElementById('popupTitle').innerHTML="【赠品删除】";
	}
	function able(bgsuuid){//启用
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGiftsAble.action?bgsuuid="+bgsuuid+"&moduleID=${requestScope.moduleID}",400,150, topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initGiftsAble.action?bgsuuid="+bgsuuid+"&moduleID=${requestScope.moduleID}",400,150, topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【赠品启用】";
	}
	function disable(bgsuuid){//停用
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGiftsDisable.action?bgsuuid="+bgsuuid+"&moduleID=${requestScope.moduleID}",400,150, topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initGiftsDisable.action?bgsuuid="+bgsuuid+"&moduleID=${requestScope.moduleID}",400,150, topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【赠品停用】";
	}
	
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});

	function clean(){
		document.getElementById('goodsName').value = "";
		document.getElementById('goodsID').value = "";
		document.getElementById('departmentID').value = "";		
		document.getElementById('bdpdepartmentname').value = "";
		document.getElementById('ds').value = "";
		document.getElementById('typeid').value = "";
	}

	function search(){
		$("img").removeAttr("onclick");
		giftsForm.action = "giftsSel.action";
		giftsForm.submit();
		showLoadingBar();
	}
	
	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selDepartmentOpen.action?departmentType=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentOpen.action?departmentType=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openDepartmentValues(objValue){
		var arrayID = new Array();
		var arrayName = new Array();
		var departments = eval('(' + objValue + ')');
		for(var i = 0; i < departments.length; i++){	
			arrayID[i] = departments[i].bdpdepartmentid;
			arrayName[i] = departments[i].bdpdepartmentname;
		}
		
		document.getElementById('departmentID').value = arrayID.join(",");
		document.getElementById('bdpdepartmentname').value = arrayName.join(",");
		document.getElementById('ds').value = document.getElementById('bdpdepartmentname').value;
	}

	function audit(bgsuuid){//审核
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGiftsAudit.action?bgsuuid="+bgsuuid+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initGiftsAudit.action?bgsuuid="+bgsuuid+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【赠品审核】";
	}

	function updateDepartment(bgsuuid){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGiftsUpdateDpt.action?bgsuuid="+bgsuuid+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initGiftsUpdateDpt.action?bgsuuid="+bgsuuid+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【修改赠品活动门店】";
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="giftsForm" action="" method="post">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>营销管理</TD>
          <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：赠品管理</TD>
          <TD align="right" valign="bottom">&nbsp;
          <c:if test="${(permissionPo.keya==1)}">
          <img src="${ctx }/img/newbtn/btn_zpadd_0.png" btn=btn title='赠品新增' onClick="insert();" ></c:if>
          <img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
             </TD>
          </TR>
        <TR>
          <TD class=menubar_function_text colspan="3">
          	<table></table>
          </TD>
         </TR>
         </TBODY></TABLE><!-- ͷ˵ End --><!-- ѡ Start -->
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
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
				   <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
					  		<TD width="8%" height="26" class="table_body">商品名称</TD>
	                        <TD width="20%" class="table_none">
                                <input id="goodsName" class="text_input160" name="goodsName" value="${goodsName }" />
						    </TD>
						    <TD width="8%" class="table_body">商品代码</TD>
						   	<TD width="24%" height="26" align="left" class="table_none">
						   		<input id="goodsID" class="text_input160" name="goodsID" value="${goodsID }" />
                            </TD>
                        </tr>
                        <TR>
                        	<TD width="8%" height="26" class="table_body">活动门店</TD>
			               	<TD class="table_none">
				               <li class="horizontal_onlyRight">
							   		<input class="text_input300" id="bdpdepartmentname" name="bdpdepartmentname" value="${bdpdepartmentname }" type="hidden" />
							   		<textarea class="text_input200" id="ds"  name="ds" style='height:50px' readonly="readonly" value="${bdpdepartmentname}">${bdpdepartmentname }</textarea>
							   		
							   		<input class="text_input100" type="hidden" id="departmentID" name="departmentID" value="${departmentID }" />
							   </li>
							   <li class="horizontal_onlyRight">						  		
							  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openDepartment();">
							   </li>
			               	</TD>
			                <TD width="9%" class="table_body" height="26">赠品类型</TD>
                            <TD width="24%" class="table_none">
                          	  <select id="typeid" name="typeid">
                          	  <option value=""></option>
                          		<option value="1" ${typeid eq '1'? ' selected':''}>门店赠品类</option>
                          		<option value="2" ${typeid eq '2'? ' selected':''}>通用赠品类</option>
                          	  </select>
                            </TD>
                        </tr>
                      </TBODY>
                    </TABLE>
                    <c:if test="${(permissionPo.keyg==1)}">
                    <table id="title2" cellspacing="2">
						<tr height="10">						
							  <td>
								  <img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();" >
								  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn name="reset" title='清空' onclick="clean();" >
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
				<c:if test="${not empty(gifts)}">
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
                        <TH width="12%" height="26" scope=col colspan="4">操作</TH>
						  <TH scope=col>商品代码</TH>						
                          <TH scope=col width="20%">商品名称</TH>
                          <TH scope=col width="20%">商品简称</TH>
                          <TH scope=col width="13%">赠品类型</TH>
                          <TH scope=col width="8%">前台显示</TH>
                        </TR>
                        
                       <s:iterator value="gifts">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
			                		 <TD align="center" width="3%">
			                		  <c:if test="${(permissionPo.keyb==1)}">
		                          		  <img src="${ctx }/img/newbtn/edit_0.png" title='修改' btn=btn onClick="update('${bgsuuid}')">				                   
					                 </c:if>
					                  </TD>
					                  <TD align="center" width="3%">					                  
					                  <c:if test="${(permissionPo.keyc==1)}">
                                           <img src="${ctx }/img/newbtn/delete_0.png" title='删除' btn=btn onclick="del('${bgsuuid}')" >	
			                            </c:if>
					                  </TD>
					      			<TD align="center" width="3%">					                  
					                  <c:if test="${(permissionPo.keyd==1)}">
					                    <c:if test="${bgsauditstate != 1}">
		                          		  <img src="${ctx }/img/newbtn/audit_0.png" title='审核' btn=btn onclick="audit('${bgsuuid}')" >	
			                            </c:if>
			                           	<c:if test="${bgsauditstate == 1}">
		                          		<img src="${ctx }/img/newbtn/audit_2.png" title='审核'>
		                          		</c:if>
			                          </c:if>

					                  </TD>
								    <td width="3%" height="26" align="center">
						               <c:if test="${(permissionPo.keye==1 && bgsauditstate == 1 )}">
											<c:if test="${bgsflag==0}">
											   <img src="${ctx }/img/newbtn/unenabled_0.png" title='启用' btn=btn onclick="able('${bgsuuid}')">
											</c:if>
											<c:if test="${bgsflag==1}">
											   <img src="${ctx }/img/newbtn/enabled_0.png" title='停用' btn=btn onclick="disable('${bgsuuid}')">
											</c:if>
										</c:if>
						             </td>				                             
						  <TD>${bgsgoodsid } </TD>
                          <TD>${bgsgoodsname }</TD>
                          <TD>${bgsviewname }</TD>
						  <TD>
						      <c:choose>
						          <c:when test="${bgstype eq '1'}">门店赠品类</c:when>
						          <c:when test="${bgstype eq '2'}">通用赠品类</c:when>
						          <c:otherwise></c:otherwise>
						      </c:choose>
						  </TD>                          
						  <TD ${bdpisshow eq '1' ? 'style="color: red;"' : ''}>
						      <c:choose>
						          <c:when test="${bdpisshow eq '1'}">是</c:when>
						          <c:when test="${bdpisshow eq '0'}">否</c:when>
						          <c:otherwise></c:otherwise>
						      </c:choose>
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
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>

</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
	