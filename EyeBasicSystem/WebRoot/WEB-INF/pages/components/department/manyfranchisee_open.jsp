<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户维护</title>
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

	function search(){
		$("img").removeAttr("onclick");
		departmentstForm.action = "selManyFranchiseeOpen.action";
		departmentstForm.submit();
		showLoadingBar();
	}
	
	function clean(){
		$('#departmentstForm').find("input[clean=clean]").each(function(){
			$(this).val('');
		});
		$('#departmentstForm').find("select[clean=clean]").each(function(){
			$(this).val('');
		});
	}
	
	/**
	 *  调用页面赋值
	 */
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
	
	/**
	 *  checkbox全选
	 */	
	function chkAll(){ 
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
        
        setValue();
    }

	/**
	 *  初始化判断checkbox的状态
	 */
    function setCheckValue()
    {
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
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="departmentstForm" name="departmentstForm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">

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
					      <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
					      <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
					      </TR>
					    </TBODY>
					  </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="10%" height="26" class="table_body">客户编号</TD>
                          <TD width="23%" class="table_none"><input clean="clean" class="text_input160" id="departmentID" name="departmentID" value="${departmentID}" maxlength="50"/></TD>
                          <TD width="10%" height="26" class="table_body">客户名称</TD>
                          <TD width="23%" class="table_none">
                          <input clean="clean" class="text_input160" id="departmentName" name="departmentName" value="${departmentName}" maxlength="50"/>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td><img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();" >
							    <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" ></td>
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
                    
                    <c:if test="${not empty(departmentList)}">
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
                          <TH width="4%" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>
                          <TH width="16%" height="26" scope=col>客户编号</TH>
                          <TH width="16%" scope=col>客户名称</TH>
                          <TH width="16%" scope=col>联系人</TH>
                          <TH width="16%" scope=col>电话</TH>                        
						  </TR>
					<s:iterator value="departmentList">	
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD height="26">
		                      <input type="checkbox" id="chk" departmentid="${bdpdepartmentid}" onClick="setValue();" value="{'bdpdepartmentid':'${bdpdepartmentid}','bdpdepartmentname':'${bdpdepartmentname}'}">
		                  </TD>
                          <TD height="26">${bdpdepartmentid}</TD>
                          <TD>${bdpdepartmentname}</TD>
                          <TD>${bdpperson}</TD>
                          <TD>${bdpphone}</TD>                      
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