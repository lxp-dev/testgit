<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员维护</title>
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

	//查询时，如果在工号处按回车键直接提交
	function EnterPress(e){ //传入 event 
		var e = e || window.event; 
		if(e.keyCode == 13){ 
			search(); 
		} 
	} 
		
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	personInfoForm.action=link;
	  	personInfoForm.submit();
		showLoadingBar();
	}
	function search()
	{
		if(checkForm(personInfoForm))
		{
			personInfoForm.action = "selMPersonInfo.action";
			personInfoForm.submit();
			showLoadingBar();
		}
	}

	
	function viewGonglingChange(){
		personInfoForm.action = "selMPersonInfoGonglingChange.action";
		personInfoForm.submit();
		showLoadingBar();
	}
	
	function invocation(invocation,cid){
		var moduleID = document.getElementById("moduleID").value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdatePersonInfoInvocation.action?invocation="+invocation+"&cid="+cid+"&moduleID="+moduleID,400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initUpdatePersonInfoInvocation.action?invocation="+invocation+"&cid="+cid+"&moduleID="+moduleID,400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【人员启用/停用】";
	}
	
	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initMPersonInfoUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initMPersonInfoUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【人员更新】";
	}
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initMPersonInfoInsert.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initMPersonInfoInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【人员新增】";
	}
	function del(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initMPersonInfoDelete.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initMPersonInfoDelete.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【人员删除】";
	}	
		
	function detail(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initMPersonInfoDetail.action?selId="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initMPersonInfoDetail.action?selId="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【人员详细】";
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function clean()
	{
		document.all.selId.value="";
		document.all.selPersonName.value="";
		document.all.bdpdepartmentname.value="";
		document.all.departmentID.value="";
		document.all.selRoleid.value="";
		document.all.isinvocation.value="";
		document.all.begintime.value="";
		document.all.endtime.value="";
		
		document.all.seleducation.value="";
		document.all.beginlizhi.value="";
		document.all.endlizhi.value="";
		document.all.beginhetong.value="";
		document.all.endhetong.value="";
		document.all.selsex.value="";
		document.all.selzhigongtype.value="";
		document.all.begage.value="";
		document.all.endage.value="";
		document.all.beglengthwork.value="";
		document.all.endlengthwork.value="";	
		document.all.hetongmanyear.value="";
		document.all.xuqianmanyear.value="";

		document.all.beghetongyear.value="";
		document.all.endhetongyear.value="";
		document.all.hetongmonth.value="";
	}
	
	//导出人员
	function exportCashCoupon(){
	    if ('${confirmSwitch}' == '1'){
	        if (confirm("此功能将根据您在查询条件中输入的数据导出人员信息，是否确认导出？")){
	    	    if ($('#addTable').size() == 0){
		            alert("请先查询出需要导出的人员信息！");
		            return;
		        }else{
		            personInfoForm.action="exportMPersonInfo.action";
		            personInfoForm.submit();
		            personInfoForm.action="selMPersonInfo.action";
		        }	
	       }
	    }
	}
	
	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDepartmentOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDepartmentOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}
	
	/**
	 * 部门开窗赋值实现方法
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
	}
</script>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="personInfoForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input  id="moduleID" type="hidden" name="moduleID" value="${requestScope.moduleID}" />

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>      
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>人事管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：员工档案管理</TD>
            <td align="right" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keya==1)}"> 
            		<img src="${ctx }/img/newbtn/btn_personinsert_0.png" btn=btn title="人员新增" onclick="insert()"/>
            	</c:if>
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
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
        <tr height="20">
        
         <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
           
				</TD>
        
        </tr>
      
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
						   <TD width="8%" height="26" class="table_body">ID号</TD>
			               <TD width="18%" class="table_none"><input class="text_input100" id="selId" name="selId" value="${selId }"  onkeypress="EnterPress(event)" onkeydown="EnterPress()" /></TD>
					
						   <TD width="8%" height="26" class="table_body">员工姓名</TD>
                          <TD width="24%" class="table_none"><input class="text_input100" name="selPersonName" id="selPersonName" value="${selPersonName }"></TD>
                      
                       <TD height="26" class="table_body">所属部门</TD>
                          <TD class="table_none" colspan="3">
                          <li class="horizontal_onlyRight">
							<input class="text_input200" id="bdpdepartmentname" name="selDepartmentName" readonly="readonly" value="${selDepartmentName}"/>
						   		<input type="hidden" id="departmentID" name="selDepartmentID" value="${selDepartmentID}"/>
                          </li>
						   <li class="horizontal_onlyRight">
						  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openDepartment();">
						   </li>
						  </TD>
						
                     </TR>
												
					<TR>
						<TD height="26" class="table_body">员工角色</TD>
			           <TD class="table_none">
					   <select name="selRoleid" id="selRoleid" class="text_input100">
					  		<option value="">----请选择----</option>
					  		<c:forEach var="po" items="${roles}">
					  		<option value="${po.roleid }" ${selRoleid != po.roleid ? '' : 'selected="selected"' }>${po.rolename }</option>
					  		</c:forEach>							
						</select></TD>
					   <TD  class="table_body">在职状态</TD>
				           <TD class="table_none" >
						   <select name="isinvocation" id="isinvocation" class="text_input100">
						   		<option value="">----请选择----</option>
						  		<option value="0" ${isinvocation == 0 ? 'selected="selected"':''}>在职</option>
						  		<option value="1" ${isinvocation == 1 ? 'selected="selected"':''}>离职</option>							
							</select></TD>
							
						<TD class="table_body">入司时间</TD>
			           	<TD class="table_none" colspan="3">
			           		<input id="begintime" name="begintime"  type="text" class="text_input100"  onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endtime\')}'})" value="${begintime }" />  至
							<input id="endtime"  name="endtime" type="text" class="text_input100"   onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'begintime\')}'})"  value="${endtime }" />
						</TD>
				   </TR>
												
					<TR>
					   <TD height="26" class="table_body">性别</TD>
			           <TD class="table_none">
				              <select name="selsex" id="selsex">
				              	<option value="">----请选择----</option>
					            <option value="1" ${selsex == 1 ? 'selected="selected"':'' } >男</option>
					            <option value="2" ${selsex == 2 ? 'selected="selected"':''} >女</option>
					          </select>
					   </TD>
					   <TD class="table_body">职工类别</TD>
			           <TD class="table_none" >
		               	<select name="selzhigongtype" id="selzhigongtype">
				            <option value="" selected="selected">--请选择--</option>
				            <option value="原职" ${selzhigongtype != '原职' ? '' : 'selected="selected"' }>原职</option>
				            <option value="合同" ${selzhigongtype != '合同' ? '' : 'selected="selected"' }>合同</option>
				            <option value="返聘" ${selzhigongtype != '返聘' ? '' : 'selected="selected"' }>返聘</option>
				            <option value="临时" ${selzhigongtype != '临时' ? '' : 'selected="selected"' }>临时</option>
				            <option value="协议" ${selzhigongtype != '协议' ? '' : 'selected="selected"' }>协议</option>
				            <option value="特殊" ${selzhigongtype != '特殊' ? '' : 'selected="selected"' }>特殊</option>
				            <option value="试用" ${selzhigongtype != '试用' ? '' : 'selected="selected"' }>试用</option>		            
				        </select>
				       </TD>							
						<TD class="table_body">年龄</TD>
			           	<TD class="table_none">
			           		<input id="begage" name="begage"  type="text" value="${begage}" class="text_input40" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '只能是整数！'}]"/>  至
							<input id="endage"  name="endage" type="text" value="${endage}" class="text_input40" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '只能是整数！'}]"/>
						</TD>
						<TD class="table_body">工龄</TD>
			           	<TD class="table_none">
			           		<input id="beglengthwork" name="beglengthwork"  type="text" value="${beglengthwork}" class="text_input40" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '只能是整数！'}]"/>  至
							<input id="endlengthwork"  name="endlengthwork" type="text" value="${endlengthwork}" class="text_input40" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '只能是整数！'}]"/>
							
						</TD>						
				   </TR>				   
					<TR>
						<TD height="26" class="table_body">学历</TD>
			           <TD class="table_none">
					   <select id="seleducation" name="seleducation">
						   		<option value="">----请选择----</option>
					  			<c:forEach var="educationPo" items="${educationList}">
					  			<option value="${educationPo.metid}" ${seleducation != educationPo.metid ? '' : 'selected="selected"' }>${educationPo.metname }</option>
					  			</c:forEach>							
					   </select>
					   </TD>
					   <TD class="table_body">离职时间</TD>
			           <TD class="table_none" >
			            <input id="beginlizhi" name="beginlizhi"  type="text" class="text_input100"  onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endlizhi\')}'})" value="${beginlizhi }">  至
						<input id="endlizhi"  name="endlizhi" type="text" class="text_input100"   onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'beginlizhi\')}'})"  value="${endlizhi }" />
					   </TD>							
						<TD class="table_body">合同时间</TD>
			           	<TD class="table_none" colspan="3">
			           		<input id="beginhetong" name="beginhetong"  type="text" class="text_input100"  onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endhetong\')}'})" value="${beginhetong }" />  至
							<input id="endhetong"  name="endhetong" type="text" class="text_input100"   onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'beginhetong\')}'})"  value="${endhetong }" />
						</TD>
				   </TR>
				   <TR>
						<TD height="26" class="table_body">合同满</TD>
			            <TD class="table_none">
			            	<input id="hetongmanyear" name="hetongmanyear"  type="text" value="${hetongmanyear}" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '只能是整数！'}]"/> 年员工
					    </TD>  
					    <TD class="table_body">续签满</TD>
			            <TD class="table_none" >
							<input id="xuqianmanyear" name="xuqianmanyear"  type="text" value="${xuqianmanyear}" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '只能是整数！'}]"/> 年员工			            
					    </TD>	
						<TD class="table_body">签署合同</TD>
			           	<TD class="table_none" colspan="3">
							<input id="beghetongyear" name="beghetongyear"  type="text" class="text_input60" onFocus="WdatePicker({readOnly:true,maxDate:'#F{$dp.$D(\'endhetongyear\')}',dateFmt:'yyyy'})" value="${beghetongyear}" />
			            	~
			            	<input id="endhetongyear" name="endhetongyear"  type="text" class="text_input60" onFocus="WdatePicker({readOnly:true,minDate:'#F{$dp.$D(\'beghetongyear\')}',dateFmt:'yyyy'})" value="${endhetongyear}" />
			            	年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			            	<input id="hetongmonth" name="hetongmonth"  type="text" class="text_input40"  onFocus="WdatePicker({readOnly:true, dateFmt:'MM'})" value="${hetongmonth}" />月			           	
						</TD>
				   </TR>				   				   				   				   
                      </TBODY>
                    </TABLE>
               		
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
							<c:if test="${(permissionPo.keyd==1)}">  
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();" >
							  	<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" >		
								<c:if test="${(permissionPo.keyf==1)}">  	
							  		<img src="${ctx }/img/newbtn/btn_exportexecl_0.png" btn=btn title='导出EXCEL' onclick="exportCashCoupon()">	  	
								</c:if> 		
								<a href="#"  onclick="viewGonglingChange()">查看本月工龄变化人员</a>
							</c:if> 
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
					<c:if test="${not empty(persons)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>

					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="addTable">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="12%" scope=col colspan="4">操作</TH>
                          <TH width="10%" height="26" scope=col>ID号</TH>
                          <TH width="10%" scope=col>员工姓名</TH>
                          <TH width="10%" scope=col>入司日期</TH>
                          <TH width="15%" scope=col>合同签署日期</TH>
						  <th scope=col>所属部门</th>
                          <TH width="10%" scope=col>员工角色</TH>
                        </TR>
                        <c:forEach var="po" items="${persons}" >
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="3%">                          	
                          		<img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="detail('${po.id }')">                        
                          </TD>
                          <TD width="3%">
                          	<c:if test="${(permissionPo.keyb==1)}">
                          		<img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="update('${po.id }')">
                          	</c:if>		
                          </TD>                          
                          <TD width="3%">
                          	<c:if test="${(permissionPo.keyc==1)}">
	                          	<c:if test="${sessionScope.person.id!=po.id }">
	                          		<img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="del('${po.id }')" >
	                          	</c:if>	
                          	</c:if>
                          </TD>
                          <TD width="3%">
						  <c:if test="${(permissionPo.keyb==1)}">
							<c:if test="${po.isinvocation==0}">
								<c:if test="${sessionScope.person.id!=po.id }">
									<img src="${ctx }/img/newbtn/inservice_0.png" btn=btn title='在职' onClick="javascript:invocation('${po.isinvocation }','${po.id}')">
								</c:if>
							</c:if>
							<c:if test="${po.isinvocation==1}">
								<c:if test="${sessionScope.person.id!=po.id }">
									<img src="${ctx }/img/newbtn/quit_0.png" btn=btn title='离职' onClick="javascript:invocation('${po.isinvocation }','${po.id}')">
								</c:if>
							</c:if>
						  </c:if>						 
						  </TD>
                          <TD height="26">${po.id }</TD>
                          <TD>${po.personName }</TD>
                          <td>${po.entrytime }</td>
                          <td>${po.laodonghetongdate }</td>
						  <td>${po.bdpdepartmentname }</td>
                          <TD>${po.rolename }</TD>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
