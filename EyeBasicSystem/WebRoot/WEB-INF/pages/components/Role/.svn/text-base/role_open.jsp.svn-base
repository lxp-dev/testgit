<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择客户</title>
</head>
<script>	
	
	function search(){
		$("img").removeAttr("onclick");
		supplierOpenForm.action = "selectRoleList.action";
		supplierOpenForm.submit();
		showLoadingBar();
	}
	
	function clean(){
		document.getElementById('bctcustomername').value = "";
	    
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	function chkAll(){
		if($("input[id=chks]").attr("checked")){
			$("input[id=chk]").attr("checked",true);
		}else{
			$("input[id=chk]").attr("checked",false);
		}
		setVlue();
	}
	function setVlue(){
		var rolI="";
		var rolN="";
		$("input[id=chk]:checked").each(function (){
			if(rolI==""){
				rolI=$(this).attr("roleid")
			}else{
				rolI=rolI+","+$(this).attr("roleid");
			}
			if(rolN==""){
				rolN=$(this).attr("rolename")
			}else{
				rolN=rolN+","+$(this).attr("rolename");
			}
		});
		 window.parent.$("#rolID").val(rolI);
		 window.parent.$("#rolNAME").val(rolN);
	}

	 function setCheckValue()
	    {
	        var chktext= "";
			chktext	=$("input[id=rolID]",window.parent.document).val();
	          $("input[id=chk]").each(function(){	
	          	var temp=chktext.split(",");
	          	if(temp!="")
	          	{
	          		for(var i=0;i<temp.length;i++)
	          		{	
	          			if(temp[i]==$(this).attr("roleid"))
	          			{
			              $(this).attr("checked","checked");
			            }
	          		}
	          	}
	         	
			});
	    }
	 $(document).ready(function (){
			setCheckValue();
		});

		$(document).ready(function() {
			$("img[btn=btn]").attr("style","cursor: hand");
			$("img[btn=btn]").mouseover(function () {
		    	$(this).attr("src",$(this).attr("src").replace("0","1"));
			}).mouseout(function () {
				$(this).attr("src",$(this).attr("src").replace("1","0"));
			});
		});
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="supplierOpenForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<input type="hidden" name="categoryID_open" value="${categoryID_open }" />

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20">
         <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" background=${ctx }/img/pic/tab_top_bg.gif></TD>        
        </tr>   
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
					<c:if test="${not empty(roleList)}"> 
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
                          <TH width="4%" height="30" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>  
                         <!--  <TH width="30%" height="30" scope=col>角色编码</TH> -->
                          <TH width="15%" scope=col>角色名称</TH>
                          <TH width="15%" scope=col>角色描述</TH>
						  </TR>
						<s:iterator value="roleList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                     	  <TD height="28"> <input type="checkbox" id="chk" roleid="${roleid}" rolename="${rolename}"  onclick="setVlue();" /></TD>
                         <!-- <TD height="28">${roleid}</TD> -->
                          <TD>${rolename}</TD>
                          <TD>${roledescription}</TD>
						</TR>
						</s:iterator>
                      </TBODY>
                    </TABLE>
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