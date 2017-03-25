<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员开窗</title>
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
		personInfoForm.action = "selPersonOpen.action";
		personInfoForm.submit();
		showLoadingBar();
	}
	
	
	function setValue(personid,personname,departmentname)
	{	
		var json = "[{'personid' : '"+personid+"','personname' : '"+personname+"','departmentname' : '"+departmentname+"'}]";
		window.parent.openPersonValues(json);
		window.parent.hidePopWin();
	}
	
	
		/**
	 *  调用页面赋值
	 */
	function setValues(){ 	        
        var chk=$('input[id=chk]');
        var objValue="";
        var count=0;
        var chktext=$("input[id=personid]",window.parent.document).val();
		var chkname=$("input[id=personname]",window.parent.document).val();
		var temp=chktext.split(",");
        var t1=	chkname.split(",");
          	if(temp!="")
          	{         		
          		for(var i=0;i<temp.length;i++)
          		{	
          			var mm=true;	
          			$("input[id=chk]").each(function()
          			{
	          			if(temp[i]==$(this).attr("personid"))
	          			{
			              mm=false;
			           }
		           });
		           if(mm)
		           {
		           		if(objValue=="")
		           	 	{
			           		objValue="{'personid':'"+temp[i]+"','personname':'"+t1[i]+"','departmentname':''}";
			         	}else
			         	{
			           		objValue=objValue+","+"{'personid':'"+temp[i]+"','personname':'"+t1[i]+"','departmentname':''}";
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
        window.parent.openPersonValues(objValue);
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
		$('#departmentstForm').find("input[clean=clean]").each(function(){
			$(this).val('');
		});
		$('#departmentstForm').find("select[clean=clean]").each(function(){
			$(this).val('');
		});
	}
	
/**
	 *  初始化判断checkbox的状态
	 */
    function setCheckValue(){
        var chktext= "";
		chktext	=$("input[id=personid]",window.parent.document).val();
          $("input[id=chk]").each(function(){	
          	var temp=chktext.split(",");
          	if(temp!="")
          	{
          		for(var i=0;i<temp.length;i++)
          		{	
          			if(temp[i]==$(this).attr("personid"))
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
	
		
	
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function clean(){
	    document.all.selId.value="";
	    document.all.selPersonName.value="";
	    document.all.selDepartmentID.value="";
	    document.all.selRoleid.value="";
	    document.all.isinvocation.value="";
	}
	

	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var companyid = '';
		if ('${person.personcompanytype}' == '2'){
			companyid = '${person.personcompanyid}';
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDepartmentOpen.action?companyid="+companyid,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDepartmentOpen.action?companyid="+companyid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
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
	}
</script>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="personInfoForm" method="post" action="">
<input  id="moduleID" type="hidden" name="moduleID" value="${requestScope.moduleID}" />

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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>		
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                     
                      <TBODY>
					  	<TR>
						   <TD width="8%" height="26" class="table_body">员工编号</TD>
			               <TD width="24%" class="table_none"><input class="text_input100" name="selId" value="${selId }" /></TD>
					
						   <TD width="8%" height="26" class="table_body">员工姓名</TD>
                          <TD width="24%" class="table_none"><input class="text_input100" name="selPersonName" value="${selPersonName }"></TD>
                      
                      <TD width="8%" height="26" class="table_body">员工角色</TD>
			           <TD height="26" class="table_none">
					   <select name="selRoleid">
					  		<option value="">----请选择----</option>
					  		<c:forEach var="po" items="${roles}">
					  		<option value="${po.roleid }" ${selRoleid != po.roleid ? '' : 'selected="selected"' }>${po.rolename }</option>
					  		</c:forEach>							
						</select></TD>
						
                     </TR>
												
					<TR>
                          <TD height="26" class="table_body">所属部门</TD>
                          <TD class="table_none" colspan="3">

                           <li class="horizontal_onlyRight">
						   		<input class="text_input240" id="bdpdepartmentname" name="selDepartmentName" readonly="readonly" value="${selDepartmentName}"/>
						   		<input type="hidden" id="departmentID" name="selDepartmentID" value="${selDepartmentID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openDepartment();">
						   </li>
						  </TD>
					   <TD height="26" class="table_body">在职状态</TD>
				           <TD height="26" class="table_none" >
						   <select name="isinvocation">
						   		<option value="">----请选择----</option>
						  		<option value="0" ${isinvocation == 0 ? 'selected="selected"':''}>在职</option>
						  		<option value="1" ${isinvocation == 1 ? 'selected="selected"':''}>离职</option>							
							</select></TD>
				   </TR>
                      </TBODY>
                    </TABLE>
               		<c:if test="${(permissionPo.keyb==1)}">  
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();" >
							  	<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" >	
							</td>
						</tr>
					</table>
			 		</c:if>  
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
					<c:if test="${not empty(persons)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="addTable">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="10%" height="30" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>
                          <TH width="10%" height="26" scope=col>员工编号</TH>
                          <TH width="20%" scope=col>员工姓名</TH>
						  <!--  <th>所属部门</th>      -->
                          <TH width="20%" scope=col>员工角色</TH>
                        </TR>
                        <c:forEach var="po" items="${persons}" >
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD>
                          	<c:choose>
                          		<c:when test="${param.isOpen=='1'}">
                          			<img src="${ctx }/img/newbtn/select_0.png" btn=btn title='选择' onClick="setValue('${po.id}', '${po.personName}', '${po.bdpdepartmentname}');">	
                          		</c:when>
                          		<c:otherwise>
                          		<input type="checkbox" id="chk" personid="${po.id}" onClick="setValues();" value="{'personid':'${po.id}','personname':'${po.personName}'}">
                          		</c:otherwise>
                          	</c:choose>
                         	
                          </TD>						  
                          <TD height="26">${po.id }</TD>
                          <TD>${po.personName }</TD>
						 <!--  <td>${po.bdpdepartmentname }</td>  -->
                          <TD>${po.rolename }</TD>
                        </TR>
                        </c:forEach>
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
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
