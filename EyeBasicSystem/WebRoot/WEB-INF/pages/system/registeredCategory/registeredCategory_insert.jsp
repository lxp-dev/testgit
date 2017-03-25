<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="<%=request.getContextPath()%>/js/selectTransferValue.js" type="text/javascript" charset="utf-8"></script>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	
        $('#frcid').focus();
	});
	
	function showSelect(obj){
		if (obj.value==1) {
			document.getElementById('menus').style.display = 'none';
			document.getElementById('enumsFunction').style.display = 'none'; 
			document.getElementById('pageFunction').style.display = '';
		}else{
			document.getElementById('menus').style.display = '';
			document.getElementById('enumsFunction').style.display = ''
			document.getElementById('pageFunction').style.display = 'none';
		}
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
	
	function addRow(details){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);
		
		row.className = 'row';
		row.height="28";
		
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="" />';
        c2.innerHTML = '<input type="text" class="text_input220" name="details['+ index +'].frpdprojectname" value="' + details.frpdprojectname +'" maxlength="50" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'项目名称不能为空！\'}, {\'Type\' : Type.String, \'Formula\' : Formula.ObjectNameOrNULL, \'Message\' : \'项目名称只能输入中文或英文！\'}]" /><label style="color:red;">&nbsp;*</label>';
        c3.innerHTML = '<input type="text" class="text_input100" name="details['+ index +'].frpdspec" value="' + details.frpdspec +'" maxlength="10" />';
		c4.innerHTML = '<input type="text" class="text_input100" name="details['+ index +'].frpdunit" value="' + details.frpdunit +'" maxlength="10" />';
		c5.innerHTML = '<input type="text" class="text_input100" name="details['+ index +'].frpdprice" value="' + details.frpdprice +'" maxlength="10" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'金额不能为空！\'}, {\'Type\' : Type.Number, \'Formula\' : \'\', \'Expansion\' : {Type : Expansion.DecimalValidation, Params : [2]}, \'Message\' : \'金额格式错误！\'}]" /><label style="color:red;">&nbsp;*</label>';
		c6.innerHTML = '<input type="text" class="text_input100" name="details['+ index +'].frpdnumber" value="' + details.frpdnumber +'" maxlength="5" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'数量不能为空！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'数量格式错误！\'}]" /><label style="color:red;">&nbsp;*</label>';
		c7.innerHTML = '<input type="text" class="text_input100" name="details['+ index +'].frpdamount" value="' + details.frpdamount +'" maxlength="10" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'合计不能为空！\'},{\'Type\' : Type.Number, \'Formula\' : \'\', \'Expansion\' : {\'Type\' : Expansion.DecimalValidation, Params : [2]}, \'Message\' : \'合计格式不正确！\'}]" /><label style="color:red;">&nbsp;*</label>';
    }	
    
    function initRow(){
    	var json = {'frpdprojectname' : '',
    				'frpdspec' : '',
    				'frpdunit' : '',
    				'frpdprice' : '',
    				'frpdnumber' : '',
    				'frpdamount' : ''};
    	addRow(json);
    }
    
    function deleteitem(){
    
		var chk=document.getElementsByName("chk");
		var table = document.getElementById('addTable');
		for(i = 0; i < chk.length; i++){
			if (chk[i].checked ) {
				var curRow = chk[i].parentNode.parentNode;		

				table.deleteRow(curRow.rowIndex);
				i = -1;
			}
		}
		
		document.all.chks.checked = false;
    }

	function cleanAddTable() {
		var addTable = $("#addTable tr");
		$("input[id=chk]").each(function(index) {
			$(this).parent().parent().remove();
		});
	}
	
	function save(){
		if(checkForm(registeredCategoryForm)){
			if($("#frcfeetype").val() == '1'){
				if(parseFloat($("#frcmoney").val()) < 0){
					alert("收费项不得小于0！");
					$("#frcmoney").focus();
					$("#frcmoney").select();
					return;
				}
			}else{
				if(parseFloat($("#frcmoney").val()) > 0){
					alert("退费项不得大于0！");
					$("#frcmoney").focus();
					$("#frcmoney").select();
					return;
				}
			}
		
			$("img").removeAttr("onclick");
			registeredCategoryForm.action = "insertRegisteredCategory.action";
			registeredCategoryForm.submit();
		}
	}
	
	function resetObj(){
		document.getElementById('frcid').value = "";
		document.getElementById('frcregisteredname').value = "";
		document.getElementById('frcmoney').value = "";
		document.getElementById('frcregisteredtype').selectedIndex = 0;
		document.getElementById('frcfeetype').selectedIndex = 0;
		cleanAddTable();
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>挂号类别维护</title>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="registeredCategoryForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <tr height="20"><td></td></tr>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="10%" height="26" class="table_body">编码</TD>
			               <TD width="23%" class="table_none"><input class="text_input100" id="frcid" value="${registeredCategoryPo.frcid }" name="registeredCategoryPo.frcid" maxlength="5" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '编码不能为空！'}, {'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '编码只允许输入整数和字母！'}]"><label style="color:red;">&nbsp;*</label></TD>
						
						  <TD width="10%" height="26" class="table_body">检查项名称</TD>
                          <TD width="23%" class="table_none"><input class="text_input240" id="frcregisteredname" value="${registeredCategoryPo.frcregisteredname }" name="registeredCategoryPo.frcregisteredname" maxlength="20" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '检查项名称不能为空！'},{'Type' : Type.String, 'Formula' : Formula.ObjectNameOrNULL, 'Message' : '检查项名称只能输入中文或英文！'}]"><label style="color:red;">&nbsp;*</label></TD>
			            
                          
						  <TD width="10%" height="26" class="table_body">金额</TD>
                          <TD width="23%" class="table_none"><input class="text_input100" id="frcmoney" value="${registeredCategoryPo.frcmoney }" name="registeredCategoryPo.frcmoney" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '金额不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误（精确到分）！'}]"><label style="color:red;">&nbsp;*金额精确到分</label></TD>
			            </TR>
						<TR>
                          
						  <TD width="10%" height="26" class="table_body">挂号类型</TD>
                          <TD width="23%" class="table_none">
						  <select id="frcregisteredtype" name="registeredCategoryPo.frcregisteredtype">
								<option value="1">检查费</option>
								<option value="2">西药费</option>
							</select>
						  </TD>
			            
						  <TD width="10%" height="26" class="table_body">收费类型</TD>
                          <TD width="23%" class="table_none">
						  <select id="frcfeetype" name="registeredCategoryPo.frcfeetype">
								<option value="1">收费</option>
								<option value="2">退费</option>
						  </select>
						  </TD>
						  <TD width="10%" height="26" class="table_body">统计类型</TD>
                          <TD width="23%" class="table_none">
						  <select id="frcamounttype" name="registeredCategoryPo.frcamounttype">
								<option value="">---请选择---</option>
								<option value="1">验光师</option>
						  </select>
						  </TD>
			            </TR>
			            
			           <c:if test="${systemParameterPo.fsphisflag == '2'}">
	                      <TR> 
				            <TD height="26" class="table_body">收费项目</TD>
				            <TD class="table_none" colspan="5">
								   <li class="horizontal_onlyRight">
								     <select id="frcpayfeeid" name="registeredCategoryPo.frcpayfeeid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择收费项目！'}]">
	                                   <option value="">---请选择---</option>
	                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                              <c:if test="${optionParamPoTmp.fopparentid=='his_payfee'}">
			                               <option value="${optionParamPoTmp.fopparamid }" ${(registeredCategoryPo.frcpayfeeid == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
			                              </c:if>	                                      	
		                               </c:forEach> 
	                            	 </select>
		                           </li>
		                           <label style="color:red;">&nbsp;*</label>
		      	             </TD>                
	                      </TR>
                       </c:if>
                      
                      </TBODY>
                    </TABLE>
                    
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>                        
						<TR>
                          <TD align="left">
                          	<img src="${ctx }/img/newbtn/btn_ybtypeinsert_0.png" btn=btn title="添加医保明细" onClick="initRow();">
                          </TD>
                          <td align="right" width="60%"><img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title="删除" onClick="deleteitem();" ></td>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="3%" height="26" scope=col><input type="checkbox" id="chks" name="chks" onclick="chkAll();">全选</TH>                        
                          <TH width="20%" scope=col>项目</TH>
                          <TH width="8%" scope=col>型号</TH>
                          <TH width="8%" scope=col>单位</TH>
                          <TH width="6%" scope=col>金额</TH>
                          <TH width="7%" scope=col>数量</TH>
                          <TH width="7%" scope=col>合计</TH>
                        </TR>
                      </TBODY>
                    </TABLE>
					<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>                        
						<TR>
                          <TD align="left">
							<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">  
							<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="resetObj()">  
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>