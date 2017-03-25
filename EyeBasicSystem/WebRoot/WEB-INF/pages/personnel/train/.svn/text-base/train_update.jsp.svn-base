<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css"> 
<!--
.STYLE1 {color: #FF0000;
	font-weight: bold;
}
-->
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工培训信息修改</title>
</head>
<script>	
	function trim(str){ //删除左右两端的空格
	    return str.replace(/(^\s*)|(\s*$)/g, "");
	}
	
	function save(){
		if(checkForm(personInfoForm)){
			if(!$("#mttraincontent").text()){
				alert("请填写培训内容！");
				return;
			}

			if($("#addTable tr").length == '1'){
				alert("请添加培训人员！");
				return;
			}
			
			document.all.submitButton.disabled="true";
			personInfoForm.action = "updateTrainPo.action";
			personInfoForm.submit();
		}
	}
	function openPersonInfo(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initWagePersonInfoSel.action?isOpen=1&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initWagePersonInfoSel.action?isOpen=1&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【人员查询】";
	}
	
	function openPersonInfos(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelTrainPersonInfo.action?isOpen=1&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelTrainPersonInfo.action?isOpen=1&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【人员查询】";
	}
	
	function openCustomerValues(json){
		document.getElementById('mttrainpersonid').value = json.id;
		document.getElementById('mrppersonname').value = json.value;
	}

	function addRow(obj){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		
		row.className = 'row';
		row.height="26";
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + obj.id + '" >';
        c2.innerHTML = obj.id + '<input type="hidden" id="goodsid" index="'+obj.id+'" name="trainPo.mtppersonids" value="' + obj.id +'" />';
        c3.innerHTML = obj.personname;
		c4.innerHTML = '<input type="text" class="text_input100" id="mtpresultss" name="trainPo.mtpresultss" value="" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'成绩应为整数！\'}]"/>'; 
    }

	function openGoodSingleDeleteValues(objValue){
 		var objs = eval('(' + objValue + ')');
 		
 		for(var i = 0; i < objs.length; i++){
 			deleterow(objs[i]);
 		}
 	}

	function openGoodSingleValues(objValue){
		var objs = eval('(' + objValue + ')');
		
		for(var i=0; i < objs.length; i++){
			addRow(objs[i]);
		}
	}

	function deleterow(obj){
 		var table = document.getElementById('addTable');
 		$("input[id=chk]").each(function(){
          	if($(this).val()== obj.id){
 			    $(this).parent().parent().remove();
            }
 		});
    }

	function deleterow1(obj){
 		var table = document.getElementById('addTable');
 		$("input[id=chk]").each(function(){
          	if($(this).attr("checked")){
 			   $(this).parent().parent().remove();
            }
 		});
    }

	function chkAll(){
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        for(var i=0;i<chk.length;i++){
           chk[i].checked = chks.checked;
        }
    }

	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});

</script>
<body onkeydown="KeyDown()"    onhelp="Showhelp();return false;">
<form name="personInfoForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" name="moduleID" value="${moduleID }">
<input type="hidden" name="trainPo.mttrainid" value="${trainPo.mttrainid }">

<DIV>
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
				    <TABLE width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx }/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						  <TD width="10%" height="26" class="table_body">培训标题</TD>
						  <TD class="table_none"><input class="text_input200" id="mttraintittle" name="trainPo.mttraintittle" value="${trainPo.mttraintittle }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '培训标题不能为空！'}]"></TD>
                          <TD width="10%" height="26" class="table_body">培训人姓名</TD>
			              <TD width="23%" class="table_none"><input id="mttrainpersonid" class="text_input100" name="trainPo.mttrainpersonid" value="${trainPo.mttrainpersonid }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '培训人姓名不能为空！'}]" /></TD>
						   <TD width="10%" height="26" class="table_body">创建日期</TD>
                           <TD class="table_none">
                           <li class="horizontal_onlyRight"><input id="mttraindate"
					       name="trainPo.mttraindate" 
					       type="text" class="text_input120" 
					       onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm'})"
					       value="${trainPo.mttraindate }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '创建日期不能为空！'}]"/>
					       </TD>
                        </TR>
      	                <tr>
                          <TD class="table_body">培训内容</TD>
                          <TD class="table_none" colspan="5"><label>
                          <textarea name="trainPo.mttraincontent" id="mttraincontent"
                          	validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [2001]}, 'Message' : '培训内容不能大于2000字！'}]">${trainPo.mttraincontent }</textarea>
                          </label></TD>
                        </TR>
                        
                        <tr>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colspan="5"><label>
                          <textarea name="trainPo.mtremark" id="mtremark"
                          	validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [2001]}, 'Message' : '备注不能大于2000字！'}]">${trainPo.mtremark }</textarea>
                          </label></TD>
                        </TR>
                       </TBODY>
                     </TABLE> 
                     
                     <table width="100%">
                      <TBODY>
                        <tr>
                        	<TD>
                             	<li class="horizontal_onlyRight"><img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openPersonInfos();"></li>
                          		<li class="horizontal_onlyRight"><img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn id="del" title="删除" onClick="deleterow1();"></li>
                          	</TD>
                        </tr>
                       </TBODY>
                     </TABLE>
                     <c:if test="${not empty(trainPos)}">
                     <table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                        
                          <TH width="20%" scope=col>ID号</TH>
                          <TH width="30%" scope=col>员工姓名</TH>
                          <TH width="10%" scope=col>成绩</TH>
                        </TR>
                        <s:iterator value="trainPos" status="idx">
                        <TR id="row" class="row" height="26px">
	                       	<td><input id="chk" name="chk" type="checkbox" value="${mtppersonid }" ></td>
       				   		<td>${mtppersonid }<input type="hidden" id="goodsid" index="${mtppersonid }" name="trainPo.mtppersonids" value="${mtppersonid }" /></td>
        				   	<td>${mtppersonName }</td>
							<td><input type="text" class="text_input100" id="mtpresultss" name="trainPo.mtpresultss" value="${mtpresults }" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '成绩应为整数！'}]"/></td>
                      	</TR>
                      	</s:iterator>
                      </TBODY>
                     </TABLE>
                     </c:if>
                     <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">
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
