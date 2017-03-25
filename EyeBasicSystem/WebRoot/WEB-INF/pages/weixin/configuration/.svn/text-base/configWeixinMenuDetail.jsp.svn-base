<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport"
		content="initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>微信菜单参数配置</title>
</head>
<script>
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;");
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });
	    document.getElementById('tr2').style.display="none";
	    <c:choose>
			<c:when test="${menuType eq '1'}">
				document.getElementById('tr1').style.display="block";
				document.getElementById('departmentID').style.display="block";
				document.getElementById('td1').innerHTML="外部网址";

				document.getElementById('tr2').style.display="block";
				<c:if test="${fn:substring(weburl, 0, 2) eq '2|'}">
					document.getElementById('webtypeselect').style.display="block";
				</c:if>
				
			</c:when>
			<c:when test="${menuType eq '2'}">
				document.getElementById('tr1').style.display="block";
				document.getElementById('ds').style.display="block";
				document.getElementById('imgChooseSingle').style.display="block";				
				document.getElementById('td1').innerHTML="文章列表";
				setDivName('${weburlName}');
			</c:when>			
			<c:when test="${menuType eq '3'}">
				document.getElementById('tr1').style.display="block";
				document.getElementById('ds').style.display="block";
				document.getElementById('imgChoose').style.display="block";
				document.getElementById('td1').innerHTML="文章列表";
				setDivName('${weburlName}');
			</c:when>
			<c:when test="${menuType eq '4'}">
				document.getElementById('tr1').style.display="block";
				document.getElementById('ds').style.display="block";
				document.getElementById('imgChooseType').style.display="block";
				document.getElementById('td1').innerHTML="文章类型";
				setDivName('${weburlName}');
			</c:when>	
	    </c:choose>

		<c:choose>
			<c:when test="${fn:substring(weburl, 2, 4) eq '01'}">
				$("#webtypename").val("个人中心");
			</c:when>
			<c:when test="${fn:substring(weburl, 2, 4) eq '02'}">
				$("#webtypename").val("专家团队");
			</c:when>		
			<c:when test="${fn:substring(weburl, 2, 4) eq '03'}">
				$("#webtypename").val("附近门店");
			</c:when>
			<c:when test="${fn:substring(weburl, 2, 4) eq '04'}">
				$("#webtypename").val("我的预约");
			</c:when>	
		</c:choose>
    }); 

	function setDivName(strArr){
   		if( strArr != ''){
   			var str= new Array();   
   	   		str=strArr.split(","); 
   	   		document.getElementById('ds').innerHTML = "<p>&nbsp;&nbsp;您选择了"+ str.length +"条数据.</p>"
   		    for (i=0;i<str.length ;i++ )   
   		    {   
   		    	document.getElementById('ds').innerHTML = document.getElementById('ds').innerHTML + "&nbsp;&nbsp; ● " + str[i]+"&nbsp;&nbsp;<br/>";
   		    }   	
   	   		document.getElementById('ds').innerHTML = document.getElementById('ds').innerHTML + "</br>";
   		}else{
   			document.getElementById('ds').innerHTML = "";
   		}

   		document.getElementById('ds').style.display="block";

	}
	
    function save(){
    	if(checkForm(configWeixinMenuDetailForm)){
    		var str = document.getElementById('departmentID').value;
    		var menuTypeidValue = document.getElementById('menuTypeid').value;
        	if(menuTypeidValue=='1'){
            	if(str==''){
            		alert("请填写外部网址！");
            		document.getElementById('departmentID').focus();
            		return;
            	}else{
                	if(str.substring(0,7) =='http://' || str.substring(0,8) =='https://'){
                	}else{
            			alert("请填写以http://开头的外部网址！");
            			document.getElementById('departmentID').focus();
						return;
                	}
            	}
        	}else if((menuTypeidValue=='2'||menuTypeidValue=='3')&&str==''){
        		alert("请选择文章内容！");
        		return;
        	}else if(menuTypeidValue=='4'&&str==''){
        		alert("请选择文章类型！");
        		return;
        	}
    		$("img").removeAttr("onclick");
    		configWeixinMenuDetailForm.action = "insertConfigWeixinMenuDetail.action";
    		configWeixinMenuDetailForm.submit();
        }
    }

	/**
	 * 文章开窗，选择一篇文章
	 */
	function openCmsContentSingle(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initCmsContentOpen.action?isOpen=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initCmsContentOpen.action?isOpen=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【选择文章】";
	}
	
	/**
	 * 文章开窗，多选文章
	 */
	function openCmsContent(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initCmsContentOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initCmsContentOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【选择文章】";
	}

	/**
	 * 文章类型开窗，选择一个类型
	 */
	function openCmsType(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initCmsTypeOpen.action?isOpen=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initCmsTypeOpen.action?isOpen=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【选择文章类型】";
	}

	
	/**
	 * 开窗赋值实现方法
	 */
		function openDepartmentValues(objValue,arg1,arg2){
			var arrayID = new Array();
			var arrayName = new Array();
			var departments = eval('(' + objValue + ')');
			for(var i = 0; i < departments.length; i++){	
				arrayID[i] = departments[i].bdpdepartmentid;
				arrayName[i] = departments[i].bdpdepartmentname;
			}

			$('#'+arg1).val(arrayID.join(","));
			$('#bdpdepartmentname').val(arrayName.join(","));
			var str= new Array();   
	   		str=arrayName.join(",").split(",");      
	   		document.getElementById(arg2).innerHTML = "<p>&nbsp;&nbsp;您选择了"+ str.length +"条数据.</p>"
		    for (i=0;i<str.length ;i++ )   
		    {   
		    	document.getElementById(arg2).innerHTML = document.getElementById(arg2).innerHTML + "&nbsp;&nbsp; ● " + str[i]+"&nbsp;&nbsp;<br/>";
		    }   	
		    document.getElementById(arg2).innerHTML = document.getElementById(arg2).innerHTML + "</br>";

		    document.getElementById(arg2).style.display="block";
		}
	
   	function changeSelect(obj){
   		document.getElementById('tr1').style.display="none";
		document.getElementById('ds').style.display="none";
	  	document.getElementById('departmentID').style.display="none";
   		document.getElementById('imgChoose').style.display="none";
		document.getElementById('imgChooseSingle').style.display="none";
		document.getElementById('imgChooseType').style.display="none";	
   		document.getElementById('departmentID').value="";
   		document.getElementById('ds').innerHTML="";
   		document.getElementById('tr2').style.display="none";
   		document.getElementById('tr3').style.display="none";
   		switch(obj.value)
   		{
   		case '1':
   	   		document.getElementById('tr1').style.display="block";
   		  	document.getElementById('departmentID').style.display="block";
   	   		document.getElementById('td1').innerHTML="外部网址";
   	   		
			document.getElementById('tr2').style.display="block";
			document.getElementById('tr3').style.display="block";
   		  	break;
   		case '2':
   	   		document.getElementById('tr1').style.display="block";
   	   		document.getElementById('imgChooseSingle').style.display="block";
   	   		document.getElementById('td1').innerHTML="文章列表";
			
   		  break;
   		case '3':
   	   		document.getElementById('tr1').style.display="block";
   	   		document.getElementById('imgChoose').style.display="block";
   	   		document.getElementById('td1').innerHTML="文章列表";
   		  break;
   		case '4':
   	   		document.getElementById('tr1').style.display="block";
   	   		document.getElementById('imgChooseType').style.display="block";
   	   		document.getElementById('td1').innerHTML="文章类型";
   		  break;  		     		     		  
   		default:
   	   		document.getElementById('tr1').style.display="none";
   		}
   	}

   	function changeRadioType(obj){    
    	var objValue=obj.value;
    	if(objValue=="2"){  
    		document.getElementById("webtypeselect").style.display="";
    		document.getElementById("webtypeselect").validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'不能为空！\'}]";
    	}else{
    		document.getElementById("webtypeselect").style.display="none"; 
    		document.getElementById("webtypeselect").validate="";  		
    	}
    }

    function getText(obj){
    	$("#departmentID").val($("#webtypeselect").val());
    	$("#webtypename").val(obj.options[obj.selectedIndex].text);
    }
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="configWeixinMenuDetailForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="webtypename" name="webtypename" value="${fn:substring(weburl, 2, 4)}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>微信管理</TD>
          <td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：配置参数配置 </td>
          </TR>
        <TR>
          <TD class=menubar_function_text colspan="3"><table></table></TD>
          <TD class=menubar_function_text align=right>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
	      </TD>
        </TR>
        </TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
                        <TD width="5%""><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                        <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                      </TR>
                    </TBODY>
                  </TABLE>
                  <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                    <TBODY> 
                       <TR valign="middle">
                      	<TD height="30" width="25%" class="table_body" align="center">菜单名称</TD>
                      	<TD class="table_none">
                      		&nbsp;${menuName }
                      		<input type="hidden" class="text_input100" name="menuID" value="${menuID }">
                      		<label style="color:red;">
                      	</TD>
                      </TR> 
                       <TR valign="middle">
                      	<TD height="30" class="table_body" align="center">链接类型</TD>
                      	<TD class="table_none">
                      		<li class="horizontal_onlyRight">
                      		<select id="menuTypeid" name="menuTypeid" onchange="changeSelect(this);">
                      			<option value=""></option>
								<s:iterator value="weiXinMenuTypeList">									  
	                        	  <option value="${wmtid }" ${wmtid == menuType ?'selected="selected"':''}>${wmtname }</option>
	                            </s:iterator>			
						    </select>
						    </li>
						   <li class="horizontal_onlyRight" id="imgChooseSingle" style="display:none;">
						  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openCmsContentSingle();">
						   </li>						    
						   <li class="horizontal_onlyRight" id="imgChoose" style="display:none;">
						  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openCmsContent();">
						   </li>
						   <li class="horizontal_onlyRight" id="imgChooseType" style="display:none;">
						  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openCmsType();">
						   </li>						   						   						    
                      	</TD>
                      </TR>    
 					 <TR valign="middle" id="tr2" style="display:none;">
                      	<TD height="30" class="table_body" align="center" id="td2">跳转配置</TD>
                      	<TD class="table_none">
                      	   <input name="webtype" id="webtype" type="radio" value="1" ${(fn:substring(weburl, 0, 2) eq '1|' ? 'checked=checked':'')} checked="checked" onClick="changeRadioType(this)"/>直接跳转到一个网站
                      	   <input name="webtype" id="webtype" type="radio" value="2" ${(fn:substring(weburl, 0, 2) eq '2|' ? 'checked=checked':'')} onClick="changeRadioType(this)"/>直接跳转到内部菜单
								<select id="webtypeselect" name="webtypeselect" style="display:none;" onchange="getText(this)">
					               		<option value="">----请选择----</option>
								  		<option value="${eims_url}/oauth2Servlet?key=8&toUserName=WEIXIN_TOUSERNAME" ${(fn:substring(weburl, 2, 4) eq '01' ? ' selected':'')}>个人中心</option>
								  		<option value="${eims_url}/oauth2Servlet?key=16&toUserName=WEIXIN_TOUSERNAME&zhenliao=" ${(fn:substring(weburl, 2, 4) eq '02' ? ' selected':'')}>专家团队</option>
								  		<option value="${eims_url}/initWeiXinUserDepartmentsList.action" ${(fn:substring(weburl, 2, 4) eq '03' ? ' selected':'')}>附近门店(左右结构)</option>
								  		<option value="${eims_url}/initWeiXinUserDepartmentsList2.action" ${(fn:substring(weburl, 2, 4) eq '05' ? ' selected':'')}>附近门店(上下结构)</option>
								  		<option value="${eims_url}/oauth2Servlet?key=14&toUserName=WEIXIN_TOUSERNAME" ${(fn:substring(weburl, 2, 4) eq '04' ? ' selected':'')}>我的预约</option>
									</select>						    
                      	</TD>
                      </TR>                                         
                      <TR valign="middle" id="tr1" style="display:none;">
                      	<TD height="30" class="table_body" align="center" id="td1">参数内容</TD>
                      	<TD class="table_none">
                      	   <input type="hidden" size="120" id="bdpdepartmentname" name="weburlname" readonly="readonly" value="${weburlName}"/>
						   <input size="120" type="text" id="departmentID" name="weburl" value="${fn:substring(weburl, 5, fn:length(weburl))}"/>
						   <div id="ds" style="display:none;border:solid 1px red;font-size:12px">${weburlname }</div>						    
                      	</TD>
                      </TR>
                        
                      <TR valign="middle" id="tr3" style="display:none;">
                      	<TD height="30" class="table_body" align="center" id="td2">说明</TD>
                      	<TD class="table_none">
						   <div id="ds2" style="border:solid 0px red;font-size:14px">
						   	跳转到一个网站，如跳转到百度首页，那输入：http://www.baidu.com
						   </div>						    
                      	</TD>
                      </TR>                                                                                           		                               					   
                    </TBODY>
                  </TABLE>
                  <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                    <TBODY>
                    	<tr><td height="10">&nbsp;</td></tr>
                      <TR>
                        <TD>
                        	<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save();">
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
    </BODY>
    </html>
<%@ include file="/WEB-INF/inc/message.jsp" %>