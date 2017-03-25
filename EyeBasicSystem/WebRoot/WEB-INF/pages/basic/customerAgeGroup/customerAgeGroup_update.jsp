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
<title>顾客年龄区间维护</title>
</head>
<script>	
	function trim(str){ //删除左右两端的空格
	    return str.replace(/(^\s*)|(\s*$)/g, "");
	}
	
	function save(){
		if(checkForm(personInfoForm)){
			if(!$("#goodscategoryID").val()){
				alert("请选择商品类别！");
				$("#goodscategoryID").focus();
				return;
			}
			var table = document.getElementById('addTable');
			var index = table.rows.length - 1;
			if(index == 0){
				alert("未添加年龄区间不可以保存！");
				return;
			}
			document.all.submitButton.disabled="true";
			personInfoForm.action = "insertCustomerAgeGroupPo.action";
			personInfoForm.submit();
		}
	}

	function addRow(){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		if(!$("input[id=max"+(index-1)+"]").val() && index > 0){
			alert("请填写年龄上限！");
			$("input[id=max"+(index-1)+"]").select();
			return;
		}
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(5);

		var size = $("input[name=customerAgeGroupPo.bcgagesmins]").length;
		row.className = 'row';
		row.height="26";
		c1.innerHTML = '<img src="${ctx }/img/newbtn/delete_0.png" value="'+size+'" btn=btn id="del" title="删除" onClick="deleterow(this);">';
		c2.innerHTML = '区间'+(size+1);
		if($("input[id=max"+(size-1)+"]").val()){
			c3.innerHTML = '<div id="min'+size+'">'+accAdd($("input[id=max"+(size-1)+"]").val(),1)+'</div><input type="hidden" index="'+size+'" id="min'+size+'" name="customerAgeGroupPo.bcgagesmins" value="'+accAdd($("input[id=max"+(size-1)+"]").val(),1)+'" />';
			$("div[id=max"+(size-1)+"]").text($("input[id=max"+(size-1)+"]").val());
			$("div[id=max"+(size-1)+"]").show();
			$("input[id=max"+(size-1)+"]").hide();
		}else{
			c3.innerHTML = '<div id="min'+size+'">1</div><input class="text_input80" index="'+size+'" type="hidden" id="min'+size+'" name="customerAgeGroupPo.bcgagesmins" value="1" />';
		}
        
        c4.innerHTML = '<div style="display: none;" id="max'+size+'"></div><input class="text_input80" index="'+size+'" onblur="checkAge(this)" type="text" id="max'+size+'" name="customerAgeGroupPo.bcgagesmaxs" value="" />';
		c5.innerHTML = '&nbsp;';
		$("input[id=max"+size+"]").focus();
	}

	function deleterow(obj){
		var index = $(obj).val();
		$("img[id=del]").each(function (){
			if($(this).val()>= index){
				$(this).parent().parent().remove();
			}
		});
		var size = $("input[name=customerAgeGroupPo.bcgagesmins]").length;
		$("div[id=max"+(size-1)+"]").hide();
		$("input[id=max"+(size-1)+"]").show();
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

	function checkAge(obj){
		var id = $(obj).attr("index");
		if($("input[id=max"+id+"]").val() < $("input[id=min"+id+"]").val()){
			alert("年龄上限不能小于下限！");
			$("input[id=max"+id+"]").select();
		}
	}
</script>
<body onkeydown="KeyDown()" onhelp="Showhelp();return false;">
<form name="personInfoForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" name="moduleID" value="${moduleID }">
 
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
                          <TD width="9%" height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">${customerAgeGroupPos[0].bcggoodscategoryname }
			               </TD>
                        </TR>
                       </TBODY>
                     </TABLE> 
                     <table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="10%">区间编号</TH>
                          <TH height="26" width="15%" scope=col>年龄下限</TH>
                          <TH width="15%" scope=col>年龄上限</TH>
                          <TH width="60%" scope=col>&nbsp;</TH>
                        </TR>
                        <c:forEach var="po" items="${customerAgeGroupPos}" varStatus="status">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <td>区间<c:out value="${status.index+1}"/></td>
                          <TD>${po.bcgagesmin }</TD>
                          <TD height="26">${po.bcgagesmax }</TD>
                          <TD height="26">&nbsp;</TD>
                        </TR>
                        </c:forEach>
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
