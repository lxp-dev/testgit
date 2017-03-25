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
		supplierOpenForm.action = "selectPersonList.action";
		supplierOpenForm.submit();
		showLoadingBar();
	}
	
	function clean(){
		$("input[clean=clean]").val('');
	    
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
		var perI= "";
		var perN="";
		var perIs= window.parent.$("#perID").val();
		var perNs=window.parent.$("#perNAME").val();
		var checkperIs=perIs.split(",");
		var checkperNs=perNs.split(",");
			if(checkperIs!=""){         		
	      		for(var i=0;i<checkperIs.length;i++){	
	      			var mm=true;	
	      			$("input[id=chk]").each(function(){
	          			if(checkperIs[i]==$(this).attr("personid")){
			              mm=false;
			           }
		           });
		           if(mm){
		           		if(perI==""){
		           			perI=checkperIs[i];
			         	}else{
			         		perI=perI+","+checkperIs[i];
			         	}  
		           		if(perN==""){
		           			perN=checkperNs[i];
			         	}else{
			         		perN=perN+","+checkperNs[i];
			         	}  
			        }
	      		}
			}
		$("input[id=chk]:checked").each(function (){
			if(perI==""){
				perI=$(this).attr("personid")
			}else{
				perI=perI+","+$(this).attr("personid");
			}
			if(perN==""){
				perN=$(this).attr("personname")
			}else{
				perN=perN+","+$(this).attr("personname");
			}
		});
		window.parent.$("#perID").val(perI);
		window.parent.$("#perNAME").val(perN);
	}

	 function setCheckValue()
	    {
	        var chktext= "";
			chktext	=$("input[id=perID]",window.parent.document).val();
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
						   <TD width="10%" height="30" class="table_body">人员编号</TD>
			               <TD  class="table_none">
                            <input class="text_input100" clean=clean type="text"  id="id" name="id" value="${personInfoPo.id}">
			               </TD>
			                <TD width="10%" height="30" class="table_body">人员名称</TD>
			               <TD colspan="3" class="table_none">
                            <input class="text_input100" clean=clean type="text"  id="personName" name="personName" value="${personInfoPo.personName}">
			               </TD>
			               </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
							    <img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();" >
							    <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" >	
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
					<c:if test="${not empty(personInfoList)}"> 
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
                          <TH width="8%" height="30" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>  
                          <TH width="15%" height="30" scope=col>人员编码</TH>
                          <TH width="30%" scope=col>人员姓名</TH>
                          <TH width="15%" scope=col>所属部门</TH>
						  </TR>
						<s:iterator value="personInfoList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                     	  <TD height="28"> <input type="checkbox" id="chk" personid="${id}" personname="${personName}"  onclick="setVlue();" /></TD>
                          <TD height="28">${id}</TD>
                          <TD>${personName}</TD>
                          <TD>${bdpdepartmentname}</TD>
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