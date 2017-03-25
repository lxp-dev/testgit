<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
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
		if($("#firIntegralCount").val() < 0){
			alert("请正确填写积分！");
			$("#firIntegralCount").focus();
			$("#firIntegralCount").select();
			return;
		}

		if(checkForm(integralFrm)){		    
			$("img").removeAttr("onclick");
			integralFrm.action = "updateIntegralExchangeSet.action";
		    integralFrm.submit();
		}
	}

	function chkAll(obj){
		if ($(obj).attr('checked')){
			document.getElementById('departmentID').value = '${allDepartmentID}';
			document.getElementById('bdpdepartmentname').value = '${allDepartmentName}';
			document.getElementById('ds').value = '${allDepartmentName}';
		}else{
			document.getElementById('departmentID').value = '';
			document.getElementById('bdpdepartmentname').value = '';
			document.getElementById('ds').value = '';
		}
	}

	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【兑换门店查询】";
	}

	function cleanDepartment(){
		document.getElementById('departmentID').value = '';
		document.getElementById('bdpdepartmentname').value = '';
		document.getElementById('ds').value = '';
		$('#chks').attr('checked',false);
	}

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
		document.getElementById('ds').value = document.getElementById('bdpdepartmentname').value;
	}
</script>
<%@ include file="/commons/uploadFile.jsp" %>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="integralFrm" method="post" action="">
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
               <c:if test="${permissionPo.keyh == 1}">   
                    <fieldset style="border-color:#FF0000">
					<legend style="font-size: 14;color: red">
					<li class="horizontal_onlyRight"><b>[基础配置]</b></li>
					</legend>
					<table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
				        <TR>                             
			                <TD height="30" class="table_body" width="10%" align="right">兑换门店<br/>
			                	<input type="checkbox" id="chks" name="chks" onclick="chkAll(this)">所有门店
			                </TD>
			             	<TD class="table_none" colspan="5">
								<li class="horizontal_onlyRight">
								    <input clean=clean class="text_input300" id="bdpdepartmentname" value="" type="hidden" />
								    <textarea clean=clean id="ds"  name="ds" readonly="readonly" style="width:1000" value="">${integralPo.firdepartmentname }</textarea>&nbsp;<span class="STYLE1">*</span>
								    <input clean=clean type="hidden" id="departmentID" name="integralPo.firdepartmentid" value="${integralPo.firdepartmentid }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取兑换门店！'}]"/>
								    
								</li>
								<li class="horizontal_onlyRight">						  		
									<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openDepartment();">
								    <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn name="reset" title='清空' onclick="cleanDepartment();" >
							    </li>  	 	            	
			               </TD>
				        </TR>
                        <tr>
                           <TD width="9%" height="26" class="table_body">商品代码</TD>
			               <TD width="24%" class="table_none">
						   		${integralPo.firGoodsID}<input type="hidden" id="firGoodsID" name="integralPo.firGoodsID" value="${integralPo.firGoodsID}" />
			               </TD>
			               <TD width="9%" class="table_body">商品名称</TD>
			               <TD width="24%" class="table_none">
                              ${integralPo.firGoodsName}
						   	  <input class="text_input160" type="hidden" id="firGoodsName" name="integralPo.firGoodsName" value="${integralPo.firGoodsName}" readonly="readonly">
			               </TD>
							<TD width="9%"  height="26" class="table_body">兑换积分</TD>
                          	<TD width="24%" class="table_none">
                          	   <input class="text_input100" id="firIntegralCount" name="integralPo.firIntegralCount" value="${integralPo.firIntegralCount }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写积分数！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写正确的积分数！'}]" maxlength="20" >&nbsp;个积分
                          	</TD>
						
                        </tr>
                        <tr>
                           <TD height="30" class="table_body">每人最多兑换数量</TD>
			               <TD class="table_none">
						   		<input class="text_input120" type="text" id="firpersonnum" name="integralPo.firpersonnum" value="${integralPo.firpersonnum}" />
			               </TD>
			               <TD class="table_body">商品总数量</TD>
			               <TD class="table_none">
						   	  <input class="text_input120" type="text" id="firgoodssumnum" name="integralPo.firgoodssumnum" value="${integralPo.firgoodssumnum}" >
			               </TD>
							<TD class="table_body">商品简称</TD>
                          	<TD class="table_none">
                          	   <input class="text_input120" id="firgoodseasyname" name="integralPo.firgoodseasyname" value="${integralPo.firgoodseasyname }"  >&nbsp;
                          	</TD>
                        </tr>
                      </TBODY>
                    </TABLE>
                     </fieldset>
                     </br>
					<fieldset style="border-color:#FF0000">
					<legend style="font-size: 14;color: red">
					<li class="horizontal_onlyRight"><b>[微信积分兑换商品信息配置]</b></li>
					</legend>
					<table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						  <TD class="table_body" height="26">图片</TD>
						  <td class="table_none">
                            <input type="text" class="text_input300" name="integralPo.firpicurl" id="firpicurl" value="${integralPo.firpicurl2}" readonly="readonly"/>
                            <input type="button" onclick="startLoad('/upload/weixin','1','firpicurl','firpicurlDiv','320','160','update')" value="图片上传"/>
                            <label style="color:red;">(图片大小建议为640*320)&nbsp;</label>
                          </td>
                        </TR> 
                        <TR>
						  <TD class="table_body" height="26">图片预览</TD>
						  <td class="table_none">
                            <div id="firpicurlDiv">
				               	<c:if test="${integralPo.firpicurl ne ''}" >
				               		<p><img src="${ctx}${integralPo.firpicurl}" width="300" height="200" border="0" title='点击查看大图' width2="600" height2="400" onclick="imgclick(this)" style="cursor: hand;" /><a style='cursor:hand' onclick=deleteServerFile(this,"${integralPo.firpicurl}","firpicurl");>删除</a></p>
				               	</c:if>
			               	</div>                            
                          </td>
                        </TR>                        
                        <TR>
			              <TD height="50" class="table_body">商品简介</TD>
			              <TD class="table_none">
		               		<FCK:editor  instanceName="content" height="300px" width="100%">
								<jsp:attribute name="value">
									${integralPo.fircontent}
								</jsp:attribute>
							</FCK:editor>
                          </TD>
                        </TR> 
                      </TBODY>
                    </TABLE>
                     </fieldset>                     
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          <img id="submitButton" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          </TD>
						  </TR>
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