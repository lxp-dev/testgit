<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>散瞳信息查询</title>
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

	function doList(link,perPage_Select,perPage_Text_Hidden){
     	 var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	mydriasisForm.action=link;
	  	mydriasisForm.submit();
	}
	
	function save(){
	
		if(checkForm(document.all.mydriasisForm)){
			var i = 0;
			$("input[id='chk']").each(function (){
				if (this.checked){
					i++;
				}
			});
			
			if(i == 0) {
				alert("请选择费用！");
				return ;
			}
			
		    var notollcount = '${notollcount}'
            if(notollcount > 0){
				alert("有"+notollcount+"项费用未维护，保存失败!");
				return ;
            }		   
	        $("img").removeAttr("onclick");
			mydriasisForm.action = "updateChargePut.action";
			mydriasisForm.submit();
		}
	}
	function getCustomer(){ 
	    if(event.keyCode==13){   
	    $("img").removeAttr("onclick");  
		mydriasisForm.action = "selMydriasisForCustomer.action";
		mydriasisForm.submit();
		}
	}
	function selChargePut(){
		var feeType = document.all.feeType;
	    var obj = document.all.frcfeetypename;
		if(feeType.value == ""){
			feeType.value = obj.options[obj.selectedIndex].value;
		}
		mydriasisForm.action = "selChargePut.action";
		$("img").removeAttr("onclick");
	    mydriasisForm.submit();
	}
	
	function details(id){
		showPopWin("","initDetailsCustomerInfo.action?hid="+id,screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	
	/*   单个汉字的宽度,根据你的字体大小自行设定   */   
  var   wordWidth   =   '14';   
  function   setWidth()   
  {   
	  obj   =   event.srcElement;   
	  obj.style.width   =   obj.value.replace(/[^\x00-\xff]/g,"**").length*wordWidth/2+5;   
  }
  /* 查询下拉列表第一个  */
  function changeValue(obj){
		var feeType = document.all.feeType;
		feeType.value = obj.options[obj.selectedIndex].value;
	}
	
	function cancelChk(){
		$("input[id='chk']").each(function (){
			this.checked = false;
		});
		document.getElementById('chks').checked = false;
	}
	
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="mydriasisForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="customerID" value="${customerID }">
<input type="hidden" name="memberid" value="${requestScope.smecimemberid}">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
 

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
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
                       <TD width="10%" height="30" class="table_body">顾客姓名</TD>
			           <TD class="table_body">${registeredDetailsPo.scrrdcreatename }</TD>
                       <TD width="10%" height="30" class="table_body">费用单号</TD>
			           <TD class="table_body">${registeredDetailsPo.scrrddetailsid }</TD>
                      </TR>
                      </TABLE>  
                      
                     <c:if test="${not empty(registeredDetailsList)}"> 
                     <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
                     
                      <TABLE width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title2">

                      <TR class=table_title align=middle>
                      <TH height="30" scope=col>编号 
                      </th>
                      <TH width="90%" height="30" scope=col>费用金额</th>
                      </TR>
                      <s:iterator value="registeredDetailsList">
                        <TR>
	                        <TD height="30" class="table_none" align="center">
	                        	 ${scrrdpayfeeno}
	                        </TD>
				            <TD class="table_none" >${scrrdregistername }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${scrrdmoney }</TD>
                        </TR>
                        </s:iterator>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      
                    </TABLE>
                    
	               </c:if>
	               
	               
	                </TABLE>
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
            </TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>