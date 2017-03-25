<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>排班维护</title>
<script type="text/javascript">
/**
 * 部门开窗
 */
function openDepartment(){
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	if(is_iPad()){
		showPopWin("initDepartmentOpen.action?mm=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin("initDepartmentOpen.action?mm=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}
	document.getElementById('popupTitle').innerHTML="【部门查询】";
}

/**
 * 部门开窗赋值实现方法
 */
function openDepartmentValues(objValue){
	var arrayID = new Array();
	var arrayName = new Array();
	var departments = eval('(' + objValue + ')');
	for(var i = 0; i < departments.length; i++){	
		arrayID[i] = departments[i].bdpdepartmentid;
		arrayName[i] = departments[i].bdpdepartmentname;
	}
	document.getElementById('departmentID').value = arrayID.join(",");
	document.getElementById('bdpdepartmentname').value = arrayName.join(",");	
	document.getElementById('tj').value = "1";	
	personInfoForm.action="initSchedulingDayPoInsert.action";
	personInfoForm.submit();
}


function deleteRow(obj) 
{        
     $(obj).parent().parent().remove();
}
function save()
{
	if(checkForm(document.all.personInfoForm))
	{    
        $("img").removeAttr("onclick");
		personInfoForm.action = "insertSchedulingDayPo.action";
		personInfoForm.submit();
	}
}   
    
</script>
</head>
  
 <body   onhelp="Showhelp();return false;" >
<form name="personInfoForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="tj" id="tj" value="" /> 
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR height="20"><td></td></TR>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx }/img/pic/tab_bg.gif>
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
                          <TD width="5%"><div align="left"><img src="${ctx }/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <TABLE cellSpacing=1 width="100%" align=center class="privateBorder" border=0>
                      <TBODY>
                        <TR>
                          <TD width="8%" class="table_body" height="26">排班编号</TD>
                          <TD width="25%" class="table_none">${schedulingDayPo.msdnumber }</TD>
                          <TD width="8%" class="table_body">部门</TD>
                          <TD width="25%" class="table_none">
							 ${schedulingDayPo.msddepartmentname }
						  </TD>
                          <TD class="table_body">排班时间</TD>
                          <TD class="table_none">
	                         ${schedulingDayPo.msdschedulingdate }
                          </TD>
					    </TR>
                     
                        <TR>
                          <TD class="table_body">制单人</TD>
						   <TD height="26" align="left" class="table_none">
						  ${schedulingDayPo.msdcreatepersonname }	
						  <input type="hidden" id="msdcreatepersonname" name="schedulingDayPo.msdcreatepersonname" value="${schedulingDayPo.msdcreatepersonname }"/>		  
						   </TD>
                          
                           <TD class="table_body">制单日期</TD>
                           <TD height="26" align="left" class="table_none">
                           ${fn:substring(schedulingDayPo.msdcreatedate,0,16) }
                           <input type="hidden" id="msdcreatedate" name="schedulingDayPo.msdcreatedate" value="${schedulingDayPo.msdcreatedate }"/>
                           </TD>
                           <TD class="table_body">审核人</TD>
                           <TD height="26" align="left" class="table_none">
                           ${schedulingDayPo.msdexaminepersonname }
                           <input type="hidden" id="msdexaminepersonname" name="schedulingDayPo.msdexaminepersonname" value="${schedulingDayPo.msdexaminepersonname }"/>
                           &nbsp;
                           </TD>
                        </TR>
                        
                         <TR>
                          <TD class="table_body">审核日期</TD>
						   <TD height="26" align="left" class="table_none" colspan="5">
						   ${fn:substring(schedulingDayPo.msdexaminedate,0,16) }&nbsp;	
						    </TD>
                          
                        </TR>
                        <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colspan="5" height="40">
                          	${schedulingDayPo.msdremark }&nbsp;
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <br/>
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx }/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </TABLE>
					<table id="addTable" width="100%" border=0 align=center cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>						 
						  <TH scope=col width="20%" height="26px">人员编号</TH>
						  <TH scope=col width="20%">姓名</TH>
                          <TH scope=col width="15%">班次</TH>
                          <TH scope=col width="35%">备注</TH>
                        </TR>
                        <c:if test="${not empty schedulingPersonPos }">
                        	<c:forEach var="po" items="${schedulingPersonPos}" >
                        		<tr class=row  align=middle>
                        			<td height="26px">
                        				${po.msppersonid }
                        			</td>
                        			<td>
                        				${po.msppersonname }
                        			</td>
                        			<td>
                        				${po.mspshiftuuname }
                        			</td>
                        			<td>
                        				${po.mspremark }
                        			</td>
                        		</tr>
                        	</c:forEach>
                        </c:if>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
