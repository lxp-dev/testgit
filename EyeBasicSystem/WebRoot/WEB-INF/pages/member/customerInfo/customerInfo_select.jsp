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
		$('#memberid').focus();
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
	
	 function details(id,dontshow){
		document.all.hid.value = id;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;

		if(is_iPad()){
			showPopWin("initDetailsCustomerInfo.action?hid="+id+"&dontshow="+dontshow,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDetailsCustomerInfo.action?hid="+id+"&dontshow="+dontshow,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【会员信息详细】";
	}
		
	function update(id){
		document.all.hid.value = id;
		var moduleID = document.getElementById("moduleID").value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;

		if(is_iPad()){
			showPopWin("initUpdateCustomerInfo.action?hid="+id+"&moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initUpdateCustomerInfo.action?hid="+id+"&moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【会员信息修改】";
	}
	
	function search(){
		$("img").removeAttr("onclick");
		customerInfoForm.action = "selCustomerInfo.action";
		customerInfoForm.submit();
		showLoadingBar();
	}
	
	function selectmember1(){
		if(event.keyCode==13){
			search();
		}
	}
	
	/*甘肃路店会员新增*/	
	function gslinsert(){
		showPopWin("","initCreditCardAccountFeesInsert.action",screen.width-200,screen.height-160, '',null,true);
		selectHidden();
	}
	
	function insert(){

        if ('${person.bdplinkhisflag}' == '1'&& '${systemParameterPo.fsphisflag}' == '2'){
            alert('此门店已经连接HIS系统，不能新增会员!');
            return;
        }
		
		var moduleID =document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initInsertCustomerInfo.action?moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertCustomerInfo.action?moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【会员信息新增】";
	}
	
	function del(id){
		var moduleID = document.getElementById("moduleID").value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initDeleteCustomerInfo.action?hid="+id+"&moduleID="+moduleID,450,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDeleteCustomerInfo.action?hid="+id+"&moduleID="+moduleID,450,140,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【会员信息删除】";
	}

	function clean(){
	    document.getElementById('memberid').value = "";
		document.getElementById('name').value = "";
		document.getElementById('phone').value = "";
		document.getElementById('sex').value = "";
		$('#departmentid').val('');
		$('#agemin').val('');
		$('#agemax').val('');
		$('#integralmin').val('');
		$('#integralmax').val('');
		$('#customerenable').val('');
		$('#openid').val('');
	}	
	
	function permissionMessage(){
       alert('您无此操作权限');
	}

	function setReportEvent_HYK(memberID){
		var reportFileName = '${fittingTemplateTypePo.bftfilename}';	//报表文件名
		var bftserver = '${fittingTemplateTypePo.bftserver}';		//报表服务器
		var showtype = '${fittingTemplateTypePo.bfttshowtype}';	//报表显示方式
		
		switch(bftserver)
		{
		case "1":
		  fineReportEvent_HYK(reportFileName,showtype,memberID);
		  break;
		case "2":
		  reportingServiceEvent_HYK(reportFileName,showtype,memberID);
		  break;
		default:
		  alert("单据配置异常！");
		}		
		//printGSL_HYK(memberID,'${departmentIDgsl}');	//天津眼科弹出的第二个报表
	}

    function fineReportEvent_HYK(reportFileName,showtype,memberID){
    	DataURL="report.action?reportlet="+ reportFileName +"&MemberId="+memberID;
		switch(showtype)
		{
		case "1":
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;		
			if(is_iPad()){
				showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin(DataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【会员卡打印 】";
		  break;
		case "2":
			window.open (DataURL, '会员卡打印', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
		  break;
		default:
		  alert("单据配置异常！");
		}	
    }

    function reportingServiceEvent_HYK(reportFileName,showtype,memberID){
    	var DataURL = '<%= getServletContext().getInitParameter("pjdUrl")%>';
    	DataURL+="eims_reporting/"+ reportFileName +"&memberID="+memberID+"&rs:Command=Render";

		switch(showtype)
		{
		case "1":
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;		
			if(is_iPad()){
				showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin(DataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【会员卡打印 】";
		  break;
		case "2":
			window.open (DataURL, '会员卡打印', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
		  break;
		default:
		  alert("单据配置异常！");
		}	
    }
	
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chks=$("#chks");
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.attr("checked"));
        });
    }

    function appointcredit(){
		var chksize = 0;        
    	$('input[id=chk]').each(function(){
        	if($(this).attr("checked")){
        		chksize = chksize + 1;
            }
        });

        if(chksize == 0){
			alert("请选择会员！");
			return;
        }

        if(confirm("是否清空指定会员积分？")){
        	$("img").removeAttr("onclick");
    		customerInfoForm.action = "updateCustomerInfoAppointCredit.action";
    		customerInfoForm.submit();
    		showLoadingBar();
        }
    }
	
    function allcredit(){
    	if(confirm("是否清空所有会员积分？")){
	    	$("img").removeAttr("onclick");
			customerInfoForm.action = "updateCustomerInfoAllCredit.action";
			customerInfoForm.submit();
			showLoadingBar();
    	}
    }

	function able(id,flag){
		var chkarray = '';
        
    	$('input[id=chk]').each(function(){
        	if($(this).attr("checked")){
        		chkarray = chkarray + ',' + $(this).val();
            }
        });

        if (id != ''){
        	chkarray = id;
        }

        if(id == '' && chkarray == ''){
			alert("请选择会员！");
			return;
        }

		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		showPopWin("initCustomerEnableUpdate.action?chkarray="+chkarray+"&enableflag="+flag+"&moduleID=${requestScope.moduleID}",400,160, topRows,topCols,returnRefresh(true),true); 
		document.getElementById('popupTitle').innerHTML="【启用/停用】";
	}
    
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="customerInfoForm" method="post" action="">

<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input id="moduleID" type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>会员信息</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：会员管理</TD>
            <td align="right" valign="bottom">&nbsp;
            <c:if test="${person.departmenttype=='1'}">
            	<c:if test="${(permissionPo.keya==1)}">
            	<img src="${ctx}/img/newbtn/btn_customerinsert_0.png" btn=btn title="会员新增" onClick="insert()">
            	</c:if>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="9%" height="26" class="table_body">会员卡号</TD>
			               <TD class="table_none" width="24%">
                            <input class="text_input160" type="text"  id="memberid" name="memberid" value="${requestScope.memberid}" onkeydown="selectmember1()" />
			               </TD>
			               <TD width="9%" height="26" class="table_body">会员姓名</TD>
			               <TD class="table_none" width="24%">
                             <input class="text_input160" type="text"  id="name" name="name" value="${requestScope.name}" onkeydown="selectmember1()" />
			               </TD>
						   <TD width="9%" height="26" class="table_body">联系电话</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="phone" name="phone" value="${requestScope.phone}" onkeydown="selectmember1()" />
			               </TD>
                        </TR>
                        <TR>
                           <TD width="60" height="26" class="table_body">会员性别</TD>
			               <TD class="table_none">
                            <select id="sex" name="sex">
                            	<option value="">----请选择----</option>
      		                 	<option value="0" ${requestScope.sex!= "0"  ? '' : 'selected="selected"' }>男</option>
      		                 	<option value="1" ${requestScope.sex!= "1"  ? '' : 'selected="selected"' }>女</option>
      	                    </select>
			               </TD>
						   <TD width="60" height="26" class="table_body">会员年龄</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text"  id="agemin" name="agemin" value="${requestScope.agemin}" maxlength="3"/>&nbsp;至
                            <input class="text_input80" type="text"  id="agemax" name="agemax" value="${requestScope.agemax}" maxlength="3"/>
			               </TD>
			                <TD width="60" height="26" class="table_body">部门</TD>
			               <TD class="table_none">
                           <select id="departmentid" name="departmentID">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.departmentID!= bdpdepartmentid  ? '' : 'selected="selected"' } >(${bdpdepartmentid})${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
			               </TD>
                        </TR>
                        <tr>
                           <TD  height="26" class="table_body">积分范围</TD>
			               <TD class="table_none" >
                           <input clean=clean class="text_input100" type="text"  id="integralmin" name="integralmin" value="${requestScope.integralmin}"/>&nbsp;至
                            <input clean=clean class="text_input100" type="text"  id="integralmax" name="integralmax" value="${requestScope.integralmax}"/>
			               </TD>
			               <TD  height="26" class="table_body">微信会员</TD>
			               <TD class="table_none">
			               	<select id="openid" name="openid">
                            	<option value="">----请选择----</option>
      		                 	<option value="1" ${requestScope.openid!= "1"  ? '' : 'selected="selected"' }>是</option>
      		                 	<option value="0" ${requestScope.openid!= "0"  ? '' : 'selected="selected"' }>否 </option>
      	                    </select>
			               </TD>
			               <TD  height="26" class="table_body">启用状态</TD>
			               <TD class="table_none">
			               	<select id="customerenable" name="customerenable">
								<option value="1" ${requestScope.customerenable == "1"  ? 'selected="selected"' : '' }>启用</option>			               	
                            	<option value="" ${requestScope.customerenable == ""  ? 'selected="selected"' : '' }>----全部----</option>
      		                 	<option value="0" ${requestScope.customerenable == "0"  ? 'selected="selected"' : '' }>停用 </option>
      	                    </select>
			               </TD>
			               
                        </tr>
                      </TBODY>
                    </TABLE>
                    <c:if test="${permissionPo.keyb=='1'}">
                    <table id="title2" cellspacing="2" width="100%">
						<tr height="10">
							<td width="50%" align="left">
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()" onkeydown="selectmember1()" >
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
							</td>
							<td width="50%" align="right">
							<c:if test="${person.departmenttype=='5'}">
								<c:if test="${permissionPo.keyg=='1'}">
									<img id="submitButton" src="${ctx }/img/newbtn/btn_emptyappointcredit_0.png" btn=btn title='清除指定会员积分' onClick="javascript:appointcredit();">
								</c:if>
								<c:if test="${permissionPo.keyh=='1'}">
									<img src="${ctx }/img/newbtn/btn_emptyallcredit_0.png" btn=btn title="清除所有会员积分" onClick="javascript:allcredit();">
								</c:if>
							</c:if>
							</td>
						    <td width="20%" align="right">
							   <c:if test="${permissionPo.keyi==1}">
								 <img btn=btn  src="${ctx }/img/newbtn/btn_plqy_0.png" title="批量启用" onClick="javascript:able('','1')">
							   </c:if>
							</td>
							<td width="20%" align="right">
							   <c:if test="${permissionPo.keyi==1}">
								 <img btn=btn  src="${ctx }/img/newbtn/btn_plty_0.png" title="批量停用" onClick="javascript:able('','0')">
							   </c:if>
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
					<c:if test="${not empty(customerInfoList)}"> 
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
                          <c:if test="${permissionPo.keyg=='1' || permissionPo.keyi=='1'}">
                          <TH width="3%" scope=col><input type="checkbox" id="chks" onclick="chkAll()"/></TH>
                          </c:if>
                          <TH width="12%" scope=col colspan="5">操作</TH>
                          <TH width="15%" height="26" scope=col>会员卡号</TH>
						  <TH width="10%" scope=col>会员姓名</TH>						
						  <TH width="15%" scope=col>会员积分</TH>
						  <TH width="15%" scope=col>会员类型</TH>
						  <TH width="5%" scope=col>性别</TH>
						  <TH width="5%" scope=col>年龄</TH>
						  <TH scope=col>联系电话</TH>
						  </TR>
						 <s:iterator value="customerInfoList">
	                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
	                          <c:if test="${permissionPo.keyg=='1' || permissionPo.keyi=='1'}">
	                          <td><input type="checkbox" id="chk" name="chk" value="${smecicustomerid}"/></td>
	                          </c:if>
	                          <TD width="3%">
			                  	<c:if test="${permissionPo.keyi=='1'}">
				                  <c:if test="${smeciflag=='1' || smeciflag == ''}">
				                     <img src="${ctx }/img/newbtn/enabled_0.png" title='停用' btn=btn onClick="javascript:able('${smecicustomerid}','0')">	
				                  </c:if>
				                  <c:if test="${smeciflag=='0'}">
				                     <img src="${ctx }/img/newbtn/unenabled_0.png" title='启用' btn=btn onClick="javascript:able('${smecicustomerid}','1')">	
				                  </c:if>
			                  	</c:if>
			                  </TD>
	                          <TD width="3%">
	                          	<c:if test="${permissionPo.keye=='1'}">
		                      	 <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:details('${smecicustomerid}','1')">
			                  	</c:if>
			                  </TD>
			                  <TD width="3%">
			                  	<c:if test="${permissionPo.keyc=='1'}">
	                             <img btn=btn src="${ctx }/img/newbtn/edit_0.png"  title='修改' onClick="javascript:update('${smecicustomerid}')">
			                  	</c:if>
			                  </TD>
			                  <TD width="3%">
			                  	<c:if test="${permissionPo.keyd=='1'}">
	                             <img btn=btn src="${ctx }/img/newbtn/delete_0.png"  title='删除' onClick="javascript:del('${smecicustomerid}')">
			                  	</c:if>
			                  </TD>
			                  <TD width="3%">	                  
		                      	 <img btn=btn src="${ctx }/img/newbtn/print_0.png" title='打印' onClick="javascript:setReportEvent_HYK('${smecimemberid}')">
			                  </TD>
	                          <TD height="26">${smecimemberid}</TD>
	                          <TD>${smeciname}</TD>
							  <td>${smeciintegral}</td>
	                          <TD>${fmmmembername}</TD>
	                          <TD>
	                          <c:if test="${smecisex==0}">
	                              	男
	                          </c:if>
	                          <c:if test="${smecisex==1}">
	                             	 女
	                          </c:if>
	                          </TD>
	                          <TD>${fmmage}</TD>
                          	  <TD>${smeciphone}</TD>
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