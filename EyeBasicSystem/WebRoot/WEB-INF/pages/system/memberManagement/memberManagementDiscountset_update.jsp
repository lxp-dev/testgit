<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>积分管理</title>
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

	function save(){
		if(checkForm(MaxDiscountFrm)){		
			 var fmdmaxdiscount= parseFloat(document.getElementById("fmdmaxdiscount").value);
			    if(fmdmaxdiscount>1||fmdmaxdiscount<0){
			      alert('折扣必须在0-1之间');
			      document.getElementById("fmdmaxdiscount").focus();
			      return false;
			    }    
			$("img").removeAttr("onclick");
			MaxDiscountFrm.action = "updateMemberManagementDiscountSet.action";
		    MaxDiscountFrm.submit();
		}
	}
	
	function clean(){
        $('input[clean=clean]').each(function(){
            $(this).val('');
        });
        $('textarea[clean=clean]').each(function(){
            $(this).val('');
        });
	}

	$(document).ready(function(){
		
	});
	function yzZheKou(){
		var vl=$('#fmdmaxdiscount').val();
		if((vl>1||isNaN(vl))&&vl){
			alert("折扣有问题,请重新输入！");
			$('#fmdmaxdiscount').focus();
			$('#fmdmaxdiscount').select();
			return;
		}

		if(vl){
			$('#fmdmaxdiscount').val(parseFloat(vl).toFixed(2))
		}
	}
 	function ReplaceDemo(ss){ 
		   var r, re;   
		   var strlength = ss.length; 
		   //alert(strlength); 
		   re = /\./;        // 创建正则表达式模式。 
		   while(re.test(ss)){ 
		  	ss = ss.replace(re, "");   
		   }  
		return (strlength-ss.length); 
	} 

	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openDepartmentValues(objValue){
		var arrayID = new Array();
		var arrayName = new Array();
		var departments = eval('(' + objValue + ')');
		for(var i = 0; i < departments.length; i++){	
			arrayID[i] = departments[i].bdpdepartmentid;
			arrayName[i] = departments[i].bdpdepartmentname;
		}

		$('#departmentID').val(arrayID.join(","));
		document.getElementById('bdpdepartmentname').value = arrayName.join(",");
		document.getElementById('ds').value = document.getElementById('bdpdepartmentname').value;
	}
	
</script>

<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="MaxDiscountFrm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

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
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
				   <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="9%" height="26" class="table_body">商品类别</TD>
	                          <TD width="24%" class="table_none"> ${memberManagementDiscountPo.fmdgoodscategoryname}<input type="hidden" id="fmdid" class="text_input160" name="memberManagementDiscountPo.fmdid" value="${memberManagementDiscountPo.fmdid }" maxlength="50"/>
                               <input type="hidden" id="fmdgoodscategoryid" class="text_input160" name="memberManagementDiscountPo.fmdgoodscategoryid" value="${memberManagementDiscountPo.fmdgoodscategoryid }" maxlength="50"/>
                               <input type="hidden" id="fmdsuppliername" class="text_input160" name="memberManagementDiscountPo.fmdsuppliername" value="${memberManagementDiscountPo.fmdsuppliername }" maxlength="50"/>
                               <input type="hidden" id="fmdsupplierid" class="text_input160" name="memberManagementDiscountPo.fmdsupplierid" value="${memberManagementDiscountPo.fmdsupplierid }" maxlength="50"/>
                               <input type="hidden" id="fmdbrandname" class="text_input160" name="memberManagementDiscountPo.fmdbrandname" value="${memberManagementDiscountPo.fmdbrandname }" maxlength="50"/>
                               <input type="hidden" id="fmdbrandid" class="text_input160" name="memberManagementDiscountPo.fmdbrandid" value="${memberManagementDiscountPo.fmdbrandid }" maxlength="50"/>
                               <input type="hidden" id="fmdgoodsname" class="text_input160" name="memberManagementDiscountPo.fmdgoodsname" value="${memberManagementDiscountPo.fmdgoodsname}" maxlength="50"/>
                               <input type="hidden" id="fmdgoodsid" class="text_input160" name="memberManagementDiscountPo.fmdgoodsid" value="${memberManagementDiscountPo.fmdgoodsid}" maxlength="50"/>
                               <input type="hidden" id="fmdgoodscategoryname" class="text_input160" name="memberManagementDiscountPo.fmdgoodscategoryname" value="${memberManagementDiscountPo.fmdgoodscategoryname}" maxlength="50"/>
						   	   <input type="hidden" id="fmdmembermanagementid" class="text_input160" name="memberManagementDiscountPo.fmdmembermanagementid" value="${memberManagementDiscountPo.fmdmembermanagementid}" maxlength="50"/>
						   	   <input type="hidden" id="fmdiscustomize" class="text_input160" name="memberManagementDiscountPo.fmdiscustomize" value="${memberManagementDiscountPo.fmdiscustomize}" maxlength="50"/>
							  	
                              </TD>
						   <TD width="9%" class="table_body">制造商</TD>
						   	<TD width="24%" height="26" align="left" class="table_none">${memberManagementDiscountPo.fmdsuppliername }&nbsp;</TD>
						    <TD class="table_body" width="9%">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">${memberManagementDiscountPo.fmdbrandname}&nbsp;</TD>
                        </tr>
                        <tr>
			               <TD class="table_body">商品名称</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">${memberManagementDiscountPo.fmdgoodsname}&nbsp;</TD>
			               <TD height="26" class="table_body">商品级别</TD>
			               <td align="left" class="table_none">${memberManagementDiscountPo.fmdgoodslevelname }&nbsp;</td>
							<TD  height="26" class="table_body">折扣</TD>
                          	<TD class="table_none">
                          	   <input class="text_input100" onblur="yzZheKou();" id="fmdmaxdiscount" name="memberManagementDiscountPo.fmddiscount" value="${memberManagementDiscountPo.fmddiscount}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写折扣数！'}]" maxlength="4" >&nbsp;折&nbsp;&nbsp;&nbsp;<font color="red">&nbsp;折扣在0-1之间</font>
                          	</TD>
                        </tr>
                        <tr>
			               <TD class="table_body">门店名称</TD>
			               <TD class="table_none" colspan="5">
				               <li class="horizontal_onlyRight">
							   		<input clean=clean class="text_input300" id="bdpdepartmentname" name="bdpdepartmentname" value="${memberManagementDiscountPo.fmmisshopcodename }" type="hidden" />
							   		<textarea clean=clean class="text_input200" id="ds"  name="ds" style='height:50px;width: 600px' readonly="readonly" >${memberManagementDiscountPo.fmmisshopcodename}</textarea>
							   		
							   		<input clean=clean type="hidden" id="departmentID" name="bdpdepartmentID" value="${memberManagementDiscountPo.fmmisshopcode }" />
							   </li>
							   <li class="horizontal_onlyRight">						  		
							  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openDepartment();">
							   </li>
							   <li class="horizontal_onlyRight">	
							  		<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空门店" onclick="clean();">
							   </li>
			               </TD>
                        </tr>
                    </TABLE>
                    <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
                    <br/>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                      <s:iterator value="memberManagementDiscountSetUpDetailsPos">
                      	<tr>
                    	  <TD height="26" class="table_body" width="8%">商品级别</TD>
			              <TD align="left" class="table_none" width="23%">
				               	<input type="hidden" value="${fmddgoodslevel }" name="memberManagementDiscountSetUpDetailsPo.fmddgoodslevels">${fmddgoodslevelname}
                          </TD>
                          <TD height="26" class="table_body" width="8%">折扣率</TD>
			              <TD align="left" class="table_none">
				               	<input type="text" class="text_input100" value="${fmdddiscount }" name="memberManagementDiscountSetUpDetailsPo.fmdddiscounts" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写折扣！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请正确填写折扣！'}]">
                          </TD>
                        </tr>
                      </s:iterator>
                      </TBODY>
                    </table>
                    </c:if>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          <img id="submitButton" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          </TD>
						  </TR>
                      </TBODY>
                    </TABLE>
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