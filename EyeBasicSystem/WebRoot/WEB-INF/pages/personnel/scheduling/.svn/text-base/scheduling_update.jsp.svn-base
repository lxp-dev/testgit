<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>排班维护</title>
<script type="text/javascript">



function save()
{
	if(checkForm(document.all.personInfoForm))
	{    
        $("img").removeAttr("onclick");
		personInfoForm.action = "updateSchedulingDayPo.action";
		personInfoForm.submit();
	}
}   
    
</script>
</head>
  
 <body   onhelp="Showhelp();return false;" >
<form name="personInfoForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="tj" id="tj" value="" /> 
<input type="hidden" name="spersonPo.mspuuid"  value="${spersonPo.mspuuid }" /> 
<input type="hidden" name="spersonPo.mspsmuuid"  value="${spersonPo.mspsmuuid }" /> 

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>排班管理</TD>
                    <TD class=menubar_readme_text vAlign=bottom>
          				
          </TD></TR>
        <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">排班修改</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE></TD>
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
					               
                   
                  
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx }/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </TABLE>
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>						 
						  <TH scope=col width="20%" height="30px">人员编号</TH>
						  <TH scope=col width="20%">姓名</TH>
                          <c:if test="${not empty schedulingDayPos }">
                        	<c:forEach var="sday" items="${schedulingDayPos}" >
                        		<TH scope=col>${sday.msdmonth}月${sday.msdschedulingdate }号 </TH>
                        	</c:forEach>
                          </c:if>
                        </TR>
                        	
                        		<tr class=row  align=middle>
                        			<td height="30px">
                        				<input class="row"  style="border:1px;border-bottom-style:none;border-top-style:none;border-left-style:none;border-right-style:none;" id="msppersonid" name="spersonPo.msppersonid" value="${spersonPo.msppersonid }" readonly="readonly"/>
                        			</td>
                        			<td>
                        				<input class="row"  style="border:1px;border-bottom-style:none;border-top-style:none;border-left-style:none;border-right-style:none;" id="msppersonname" name="msppersonname" value="${spersonPo.msppersonname }" readonly="readonly"/>
                        			</td>
                        			<c:set value="" var="sid"/>
	                        			<c:if test="${not empty schedulingDayPos }">
			                        	<c:forEach var="sday" items="${schedulingDayPos}" >
			                        		<td>		                        		
											<c:set value="" var="sid"/>
				                        	<c:if test="${not empty schedulingPersonDayPos }">
					                        	<c:forEach var="shifts" items="${schedulingPersonDayPos}" >
					                        		<c:if test="${shifts.mspdsduuid==sday.msduuid  }">
					                        			<c:set value="${shifts.mspdshiftuuid }" var="sid"/>	
					                        		</c:if>
					                        	</c:forEach>
				                        	</c:if>	
				                        	
				                        	<input type="hidden" name="kk${sday.msdschedulingdate}" value="${sday.msduuid }"/>
				                        		<c:if test="${!empty sid}">
				                        			<table>
						                        	<c:forEach var="sm" items="${shiftMaintainPos}" >  
						                        	<tr>                   					
				                        				<td nowrap >	<input type="checkbox" name="sm${sday.msdschedulingdate}" ${fn:contains(sid,sm.msmuuid)?'checked="checked"':''}   value="${ sm.msmuuid}" >${sm.msmshiftName }</td>
				                        			</tr>  
				                        			</c:forEach>	
					                        		</table>
				                        		</c:if>	
				                        			
				                        		<c:if test="${empty sid}">
				                        			<table>
						                        	<c:forEach var="sm" items="${shiftMaintainPos}" >  
						                        	<tr>                    					
				                        				<td nowrap >	<input type="checkbox" name="sm${sday.msdschedulingdate}"   value="${ sm.msmuuid}" >${sm.msmshiftName }</td>
				                        			</tr>  
				                        			</c:forEach>	
					                        		</table>
				                        		</c:if>                        	
					                        		                        	
											</td>	                        				                        		                        									
			                        	</c:forEach>
			                        	</c:if>	
                        			
                        		</tr>
                        	
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        
					   <TR>
						  <TD align="left"><input id="submitButton" icon='icon-save' type='button' value='修 改' onClick="save();"></TD>
                        </TR>                     
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
