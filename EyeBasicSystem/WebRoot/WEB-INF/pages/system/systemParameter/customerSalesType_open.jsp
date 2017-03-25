<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>银行维护</title>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
	
	function showLoadingBar(){
	}

	function setValue(){ 	         
        var chk=$('input[id=chk]');
        var objValue="";
        var count=0;
        var chktext=$("input[id=departmentID]",window.parent.document).val();
		var chkname=$("input[id=bdpdepartmentname]",window.parent.document).val();
		var temp=chktext.split(",");
        var t1=	chkname.split(",");
          	if(temp!="")
          	{         		
          		for(var i=0;i<temp.length;i++)
          		{	
          			var mm=true;	
          			$("input[id=chk]").each(function()
          			{
	          			if(temp[i]==$(this).attr("departmentid"))
	          			{
			              mm=false;
			           }
		           });
		           if(mm)
		           {
		           		if(objValue=="")
		           	 	{
			           		objValue="{'bdpdepartmentid':'"+temp[i]+"','bdpdepartmentname':'"+t1[i]+"'}";
			         	}else
			         	{
			           		objValue=objValue+","+"{'bdpdepartmentid':'"+temp[i]+"','bdpdepartmentname':'"+t1[i]+"'}";
			         	}  
			        }
          		}
		}
        for(var i=0;i<chk.length;i++)
        {
           if(chk[i].checked==true)
           {
           	 if(objValue=="")
           	 {
	           objValue=chk[i].value;
	         }else
	         {
	           objValue=objValue+","+chk[i].value;
	         }  
	         count++;          
           }
        }   
        objValue="["+objValue+"]";
        
        window.parent.openDepartmentValues(objValue);
        
	}

    function setCheckValue(){
        var chktext= "";
		chktext	=$("input[id=departmentID]",window.parent.document).val();
          $("input[id=chk]").each(function(){	
          	var temp=chktext.split(",");
          	if(temp!="")
          	{
          		for(var i=0;i<temp.length;i++)
          		{	
          			if(temp[i]==$(this).attr("departmentid"))
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
	
</script>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form action="" method="post" name="mpostForm">
<input type="hidden" value="${moduleID }" name="moduleID" id="moduleID" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>      
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
				</TD></TR>
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
		                      <TBODY>
		                        <TR class=table_title align=middle>
		                          <TH width="8%" scope=col>操作</TH>
		                          <TH width="16%" height="26" scope=col>类型编号</TH>
		                          <TH width="22%" scope=col>类型名称</TH>
		                          <TH width="22%" scope=col>所属类型</TH>
		                          <!-- <TH width="22%" scope=col>参与业绩统计</TH> -->
		                        </TR>
		                        <c:if test="${not empty(BankPos)}">
		                        <c:forEach items="${bankPos}" var="item" varStatus="lineNum"> 
		                        	<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
			                          <TD width="4%">
			                             <input type="checkbox" id="chk" departmentid="${item.bbuuid}" onClick="setValue();" value="{'bdpdepartmentid':'${item.bbuuid}','bdpdepartmentname':'${item.bbname}'}">
			                          </TD>
			                          <TD height="26">${item.bbnumber}</TD>
			                          <TD>${item.bbname}</TD>
			                          <TD>
			                              <c:if test="${item.bbtype eq '2'}">银行卡</c:if>
			                              <c:if test="${item.bbtype eq '9'}">其他</c:if>	&nbsp;		                          
			                          </TD>
			                        </TR>
		                        </c:forEach>
		                        </c:if>
	                      </TBODY>
	                    </TABLE>
	                    <c:if test="${not empty(bankPos)}">
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
    </BODY>
</html>