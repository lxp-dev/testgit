<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事考勤</title>
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
	
	function clean1(){
		document.getElementById('personid').value = "";
		document.getElementById('personname').value = "";
		document.getElementById('ds').value = "";
		
	}
	 function clean(){
		document.getElementById('ds').value = "";
		document.getElementById('personid').value = "";
		document.getElementById('personname').value = "";
		document.getElementById('typemain').value = "";
		document.getElementById('typezi').value = "";
		document.getElementById('timeb').value = "";		
		document.getElementById('timee').value = "";
		document.getElementById('sumxs').value = "";
		document.getElementById('typesay').value = "";
		
	}
    function showSubMenu(obj) {  
        
    	if(obj==""){
    		$('#typezi').load("getAjaxQjccDate.action");
    	}else{  
    		$('#typezi').load("getAjaxQjccDate.action?fnpid="+obj);
    	}
    }
	
	function save(){
		if(checkForm(personInfoForm)){
			
			document.all.submitButton.disabled="true";
			personInfoForm.action = "insertQjcc.action";
			personInfoForm.submit();
		}
	}
	/**
	 * 人员开窗
	 */
	function openPerson(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selPersonOpen.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selPersonOpen.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【人员开窗】";
	}

	/**
	 * 人员开窗赋值实现方法
	 */
			 
	function openPersonValues(objValue){
		var arrayID = new Array();
		var arrayName = new Array();
		var persons = eval('(' + objValue + ')');
		for(var i = 0; i < persons.length; i++){	
			arrayID[i] = persons[i].personid;
			arrayName[i] = persons[i].personname;
		}
		
		document.getElementById('personid').value = arrayID.join(",");
		document.getElementById('personname').value = arrayName.join(",");
		document.getElementById('ds').value = document.getElementById('personname').value;
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="personInfoForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>请假出差管理</TD>
          
          <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：请假出差新增</TD>
          <TD align=right>&nbsp;</TD>
          </TR>
        <TR>         
<TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR></TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
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
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="10%" height="30" class="table_body">登记日期</TD>
			               <TD width="40%" class="table_none">${createDate }<input type="hidden" class="text_input200" id="dateb" name="qjccPo.dateb" value="${createDate}" maxlength="20" readonly="readonly"></TD>
						  <TD width="10%" height="30" class="table_body">请假出差类型</TD>
                          <TD width="40%" class="table_none">
                          	<select id="typemain" name="qjccPo.typemain" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取请假出差类型！'}]" onchange="showSubMenu(this.options[this.options.selectedIndex].value)">
						  		<option value="">请选择请假出差类型</option>
						  		<c:forEach var="po" items="${qjccTypePos}">
						  		<option value="${po.bqjid}" ${seljbtypeid != po.bqjid ? '' : 'selected="selected"' } >${po.bqjname}</option>
						  		</c:forEach>							
							</select>
							<select id="typezi" name="qjccPo.typezi" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取请假出差原因！'}]">
						  		<option value="">请选择请假出差原因</option>							
							</select>
                          </TD>
						</TR>
						<TR>
						   <TD width="10%" height="30" class="table_body">人员</TD>
			               <TD class="table_none" colspan="3">
									<li class="horizontal_onlyRight">
									    <input clean=clean class="text_input300" id="personname" name="qjccPo.personname" value="${qjccPo.personname}" type="hidden" />
									    <textarea clean=clean id="ds"  name="ds" readonly="readonly"  value="${qjccPo.personname}">${qjccPo.personname}</textarea>&nbsp;<span class="STYLE1">*</span>
									    <input clean=clean class="text_input100" type="hidden" id="personid" name="qjccPo.personid" value="${qjccPo.personid}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取人员！'}]"/>									    
									</li>
									<li class="horizontal_onlyRight">	
										<img src="${ctx}/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" name=ctl00$PageBody$Button1 onClick="openPerson();">					  		
									    <img src="${ctx}/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean1()">
								    </li>  
                          </TD>
						</TR>
						<TR>
						  <TD width="10%" height="30" class="table_body">发生时间</TD>
                          <TD width="40%" class="table_none">
                          <input id="timeb"
					       name="qjccPo.timeb" clean="clean" 
					       type="text" class="text_input120" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'timee\')}',dateFmt:'yyyy-MM-dd HH:mm'})"
					       value="${qjccPo.timeb}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取发生时间！'}]"/> 
					                  至 
					       <input id="timee" clean="clean" 
					       name="qjccPo.timee" 
					       type="text" class="text_input120" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'timeb\')}',dateFmt:'yyyy-MM-dd HH:mm'})" 
					        value="${qjccPo.timee}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取发生时间！'}]"/> 
                          </TD>
                          <TD width="10%" height="30" class="table_body">合计小时数</TD>
                          <TD width="40%" class="table_none">
                           <input clean=clean class="text_input100" id="sumxs" name="qjccPo.sumxs" value="${qjccPo.sumxs}" type="text" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写合计小时数！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '合计小时数应为整数！'}]"/>              
                          </TD>
                        </TR>
						<TR>
						  <TD width="10%" height="30" class="table_body">备注</TD>
                          <TD colspan="3" class="table_none">
                             <textarea clean=clean id="typesay"  name="qjccPo.typesay" >${qjccPo.typesay}</textarea>
                          </TD>
                        </TR>                

                      </TBODY>
                    </TABLE>
					
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          	<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">
                          	<img src="${ctx}/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean()">
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
