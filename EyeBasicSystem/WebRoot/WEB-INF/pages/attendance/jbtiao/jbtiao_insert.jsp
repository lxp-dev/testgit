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
		document.getElementById('jbsbtime').value = "";
		document.getElementById('jbxbtime').value = "";
		document.getElementById('jbtime').value = "";		
		document.getElementById('jbtype').value = "";
		document.getElementById('jbsbtimeb').value = "";
		document.getElementById('jbsbtimee').value = "";
		document.getElementById('sbisdk').checked = "";
		document.getElementById('xbisdk').checked = "";
		document.getElementById('jbxbtimeb').value = "";
		document.getElementById('jbxbtimee').value = ""		
	}
	
	function save(){
		if(checkForm(personInfoForm)){

            if(document.getElementById('sbisdk').checked==true){
                if(document.getElementById('jbsbtimeb').value==''){
                	alert('上班打卡时间不能为空!');
                	document.getElementById('jbsbtimeb').focus();
                	return false;
                }
                if(document.getElementById('jbsbtimee').value==''){
                	alert('上班打卡时间不能为空!');
                	document.getElementById('jbsbtimee').focus();
                	return false;
                }
            	
            }
            if(document.getElementById('xbisdk').checked==true){
                if(document.getElementById('jbxbtimeb').value==''){
                	alert('下班打卡时间不能为空!');
                	document.getElementById('jbxbtimeb').focus();
                	return false;
                }
                if(document.getElementById('jbxbtimee').value==''){
                	alert('下班打卡时间不能为空!');
                	document.getElementById('jbxbtimee').focus();
                	return false;
                }
            }
			
			document.all.submitButton.disabled="true";
			personInfoForm.action = "insertJBTiao.action";
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
	function showdiv(objValue){

	     if(objValue=='1'){
	    	 if(document.getElementById('sbisdk').checked==true){
	    		 document.getElementById("div1").style.display=""
	         }else{
	        	 document.getElementById("div1").style.display="none";
	         }
	    }else{
	    	 if(document.getElementById('xbisdk').checked==true){
	    		 document.getElementById("div2").style.display=""
	         }else{
	        	 document.getElementById("div2").style.display="none";
	         }
	    }
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
          <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>加班管理</TD>
          
          <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：加班新增</TD>
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
						   <TD width="10%" height="30" class="table_body">考勤日期</TD>
			               <TD width="40%" class="table_none">${createDate }<input type="hidden" class="text_input200" id="kqdt" name="jbtiaoPo.kqdt" value="${createDate}" maxlength="20" readonly="readonly"></TD>
						  <TD width="10%" height="30" class="table_body">加班类型</TD>
                          <TD width="40%" class="table_none">
                          	<select id="jbtype" name="jbtiaoPo.jbtype" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取加班类型！'}]">
						  		<option value="">请选择加班类型</option>
						  		<c:forEach var="po" items="${jbtiaoTypeList}">
						  		<option value="${po.bjbid}" ${seljbtypeid != po.bjbid ? '' : 'selected="selected"' }>${po.bjbname}</option>
						  		</c:forEach>							
							</select>
                          </TD>
						</TR>
						<TR>
						   <TD width="10%" height="30" class="table_body">人员</TD>
			               <TD class="table_none" colspan="3">
									<li class="horizontal_onlyRight">
									    <input clean=clean class="text_input300" id="personname" name="jbtiaoPo.personname" value="${jbtiaoPo.personname}" type="hidden" />
									    <textarea clean=clean id="ds"  name="ds" readonly="readonly"  value="${jbtiaoPo.personname}">${jbtiaoPo.personname}</textarea>&nbsp;<span class="STYLE1">*</span>
									    <input clean=clean class="text_input100" type="hidden" id="personid" name="jbtiaoPo.personid" value="${jbtiaoPo.personid}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取人员！'}]"/>									    
									</li>
									<li class="horizontal_onlyRight">	
										<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openPerson();">
										<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean1();" >						  		
								    </li>  
                          </TD>
						</TR>
						<TR>
						  <TD width="10%" height="30" class="table_body">加班时间</TD>
                          <TD width="40%" class="table_none">
                          <input id="jbsbtime"
					       name="jbtiaoPo.jbsbtime" clean="clean" 
					       type="text" class="text_input120" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'jbxbtime\')}',dateFmt:'yyyy-MM-dd HH:mm'})"
					       value="${jbtiaoPo.jbsbtime}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取加班时间！'}]"/> 
					                  至 
					       <input id="jbxbtime" clean="clean" 
					       name="jbtiaoPo.jbxbtime" 
					       type="text" class="text_input120" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'jbsbtime\')}',dateFmt:'yyyy-MM-dd HH:mm'})" 
					        value="${jbtiaoPo.jbxbtime}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取加班时间！'}]"/> 
                          </TD>
                          <TD width="10%" height="30" class="table_body">加班合计小时数</TD>
                          <TD width="40%" class="table_none">
                           <input clean=clean class="text_input100" id="jbtime" name="jbtiaoPo.jbtime" value="${jbtiaoPo.jbtime}" type="text" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写加班合计小时数！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '合计小时数应为整数！'}]"/>              
                          </TD>
                        </TR>
						<TR>
						  <TD width="10%" height="30" class="table_body">上班要打卡</TD>
                          <TD width="40%" class="table_none"><input id="sbisdk" name="jbtiaoPo.sbisdk" type="checkbox" value="1" onclick="showdiv('1');"></TD>
                          <TD width="10%" height="30" class="table_body">上班打卡时间</TD>
                          <TD width="40%" class="table_none"> 
                          <div id="div1" style="display: none" >                     	
                          <input id="jbsbtimeb"
					       name="jbtiaoPo.jbsbtimeb" clean="clean" 
					       type="text" class="text_input120" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'jbsbtimee\')}',dateFmt:'yyyy-MM-dd HH:mm'})"
					       value="${jbtiaoPo.jbsbtimeb}" /> 
					                  至 
					       <input id="jbsbtimee" clean="clean" 
					       name="jbtiaoPo.jbsbtimee" 
					       type="text" class="text_input120" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'jbsbtimeb\')}',dateFmt:'yyyy-MM-dd HH:mm'})" 
					        value="${jbtiaoPo.jbsbtimee}" /> 
					        </div> 
					      </TD>                      
					    </TR>
						<TR>
						  <TD width="10%" height="30" class="table_body">下班要打卡</TD>
                          <TD width="40%" class="table_none"><input id="xbisdk" name="jbtiaoPo.xbisdk" type="checkbox" value="1" onclick="showdiv('2');"></TD>
                          <TD width="10%" height="30" class="table_body">下班打卡时间</TD>
                          <TD width="40%" class="table_none">  
                          <div id="div2" style="display: none" >                       	
                          <input id="jbxbtimeb"
					       name="jbtiaoPo.jbxbtimeb" clean="clean" 
					       type="text" class="text_input120" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'jbxbtimee\')}',dateFmt:'yyyy-MM-dd HH:mm'})"
					       value="${jbtiaoPo.jbxbtimeb}" /> 
					                  至 
					       <input id="jbxbtimee" clean="clean" 
					       name="jbtiaoPo.jbxbtimee" 
					       type="text" class="text_input120" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'jbxbtimeb\')}',dateFmt:'yyyy-MM-dd HH:mm'})" 
					        value="${jbtiaoPo.jbxbtimee}" /> 
					        </div>
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
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
