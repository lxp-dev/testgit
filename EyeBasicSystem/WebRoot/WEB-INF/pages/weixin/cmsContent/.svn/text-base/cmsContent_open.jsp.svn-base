<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章查询</title>
</head>
<script>
$(document).ready(function (){
	setCheckValue();
});

$(document).ready(function() { 
    $("img[btn=btn]").attr("style","cursor: hand;"); 
    $("img[btn=btn]").mouseover(function () { 
    $(this).attr("src",$(this).attr("src").replace("0","1")); 
    }).mouseout(function () { 
      $(this).attr("src",$(this).attr("src").replace("1","0")); 
    }); 
});

function setValue(id,name)
{	
	var json = "[{'bdpdepartmentid' : '"+id+"','bdpdepartmentname' : '"+name+"'}]";
	window.parent.openDepartmentValues(json,'${arg1}','${arg2}');
	parent.hidePopWin();
}

/**
 *  调用页面赋值
 */
function setValues(){ 	         
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
    window.parent.openDepartmentValues(objValue,'${arg1}','${arg2}');
    
}
/**
 *  checkbox全选
 */	
function chkAll(){ 
    var chks=document.all.chks;
    $('input[id=chk]').each(function(){ 
        $(this).attr("checked",chks.checked);
    }); 
    
    setValues();
}

function clean(){	
	$('#title').val('');
	$('#typeid').val('');
	$('#flag').val('');
}

/**
 *  初始化判断checkbox的状态
 */
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
	
	function search(){
		$("img").removeAttr("onclick");
		cmsContentOpenForm.action = "initCmsContentOpen.action?isOpen=${param.isOpen}";
		cmsContentOpenForm.submit();		
		showLoadingBar();
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="cmsContentOpenForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="arg1" value="${arg1}">
<input type="hidden" name="arg2" value="${arg2}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>微信管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：文章管理</TD>
            <td align="right" valign="bottom">&nbsp;
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
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
                            </table>
					<table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						  <TD width="9%" height="26" class="table_body">文章标题</TD>
			              <TD class="table_none" width="23%"><input class="text_input200" id="title" name="title" value="${requestScope.title}"></TD>
                          <TD width="9%" height="26" class="table_body">文章类型</TD>
                          <TD class="table_none" width="23%">
                            <select id="typeid" name="typeid">
							<option value="">----请选择----</option>
							<c:if test="${not empty(weiXinCmsTypeList)}">
			               	  <s:iterator value="weiXinCmsTypeList" var="weiXinCmsTypePo">
                   	           <OPTION value="${weiXinCmsTypePo.wcmstid}" ${(weiXinCmsTypePo.wcmstid eq typeid)? ' selected':''}>${weiXinCmsTypePo.wcmstname}</OPTION>
                   	          </s:iterator>
                   	        </c:if>
							</select>
                          </TD>
                          <TD width="9%" height="26" class="table_body">启用状态</TD>
                          <TD class="table_none">
                            <select id="flag" name="flag">
							<option value="">全部</option>
							<option value="1" ${(flag eq '1')? ' selected':''}>启用</option>
							<option value="0" ${(flag ne '1')? ' selected':''}>停用</option>
							</select>
                          </TD>                          
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" id="submitButton" btn=btn title='查询' onClick="javascript:search()">
	                       		<img src="${ctx }/img/newbtn/btn_empty_0.png" title="清空" btn=btn onClick="clean()">
	                        </td>
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
                    <c:if test="${not empty(weiXinCmsContentList)}">		
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </table>
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="10%" height="30" scope=col>
                          	<c:choose>
				          		<c:when test="${param.isOpen=='1'}">
				          			选择	
				          		</c:when>
				          		<c:otherwise>
									全选<input type="checkbox" id="chks" onclick="chkAll()">  
				          		</c:otherwise>
				          	</c:choose>   
				          </TH>                       		
                          <TH width="20%" height="26" scope=col>类型</TH>
                          <TH scope=col>文章标题</TH>
                          <TH width="15%" scope=col>更新日期</TH>
                        </TR>
                        <s:iterator value="weiXinCmsContentList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">
				          	<c:choose>
				          		<c:when test="${param.isOpen=='1'}">
				          			<img src="${ctx }/img/newbtn/select_0.png" btn=btn title='选择' onClick="setValue('${wcmscid}', '${wcmsctitle}');">	
				          		</c:when>
				          		<c:otherwise>
									<input type="checkbox" id="chk" departmentid="${wcmscid}" onClick="setValues();" value="{'bdpdepartmentid':'${wcmscid}','bdpdepartmentname':'${wcmsctitle}'}">
				          		</c:otherwise>
				          	</c:choose>                          
                          </TD>						  
                          <TD height="26">${wcmsctypename}</TD>
                          <TD>${wcmsctitle}</TD>
                          <TD>${fn:substring(wcmsccreatedate,0,16)}</TD>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
