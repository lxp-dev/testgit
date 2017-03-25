<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css"> 
a:link {
	text-decoration: none;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>邮寄管理</title>
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
		if(checkForm(document.all.customerComplainForm)){ 
		
			if($('#smecccustomermemberid').val()==''){
				alert("请选择会员！");
				var topRows = top.document.getElementById("total").rows;
				var topCols = top.document.getElementById("btmframe").cols;
				if(is_iPad()){
					showPopWin("initSelCustomerInfoWin.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}else{
					showPopWin("initSelCustomerInfoWin.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}
				document.getElementById('popupTitle').innerHTML="【会员查询】";
				return;
			}
		
			if($('#smecccomplaintype').val()==''){
				alert("请选择投诉类型！");
				$('#smecccomplaintype').focus();
				return;
			}
			
			if($('#taday1').val()==''){
				alert("请填写预计处理日期！");
				$('#taday1').focus();
				return;
			}
			
			if($('#smecccomplaincontent').val()==''){
				alert("请填写投诉内容！");
				$('#smecccomplaincontent').focus();
				return;
			}
			
			if($('#handletype').is(":checked")){
				if($('#smechhandlestate').val()==''){
					alert("请选择处理状态！");
					$('#smechhandlestate').focus();
					return;
				}
				
				if($('#smechhandlecontent').val()==''){
					alert("请填写处理结果！");
					$('#smechhandlecontent').focus();
					return;
				}
			}
			$("img").removeAttr("onclick");
			customerComplainForm.action = "insertRefunComplain.action";
			customerComplainForm.submit();
		}
	}
 
	function clean(){
	    document.customerComplainForm.reset(); 
	    $('#showtr1').hide();
	}	

	/** 
     * 时间对象的格式化
     */  
    Date.prototype.format = function(format) {  
        /* 
         * eg:format="YYYY-MM-dd hh:mm:ss"; 
         */  
        var o = {  
            "M+" :this.getMonth() + 1, // month  
            "d+" :this.getDate(), // day  
            "h+" :this.getHours(), // hour  
            "m+" :this.getMinutes(), // minute  
            "s+" :this.getSeconds(), // second  
            "q+" :Math.floor((this.getMonth() + 3) / 3), // quarter  
            "S" :this.getMilliseconds()  
        // millisecond  
        }  
      
        if (/(y+)/.test(format)) {  
            format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
        }  
      
        for ( var k in o) {  
            if (new RegExp("(" + k + ")").test(format)) {  
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));  
            }  
        }  
        return format;  
    }
	
	function today(){
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式		
		document.getElementById('taday1').value = now;	
	}
	
	function show(){
		if($('#handletype').attr('checked')){
			$('#showtr1').show();
		}else{
			$('#showtr1').hide();
		}
	}
	
</script>
<body>
<form name="customerComplainForm" id="customerComplainForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${moduleID }">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                    	  <TD height="26" class="table_body">投诉单号</TD>
                    	  <TD class="table_none">
                    	  	${customerComplainPo.smeccuuid }<input type="hidden" class="text_input160" name="customerComplainPo.smeccuuid" value="${customerComplainPo.smeccuuid }"/>
                    	  </TD>
                    	  <TD height="26" class="table_body">投诉类型</TD>
                    	  <TD class="table_none" colspan="3">
                    	  	<select id="smecccomplaintype" name="customerComplainPo.smecccomplaintype">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(complaintsTypeList)}">
				               	  <s:iterator value="complaintsTypeList">
                    	           <OPTION value="${bctid}" ${customerComplainPo.smecccomplaintype != bctid  ? '' : 'selected="selected"' } >${bctname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                    </select>
                    	  </TD>
                    	</TR>	
					  	<TR>
                          <TD width="8%" height="26" class="table_body">会员卡号</TD>
					  	  <TD width="24%" class="table_none">
					  	  <li class="horizontal_onlyRight">
					  	    ${customerComplainPo.smecccustomermemberid }&nbsp;
					  	  	<input type="hidden" readonly="readonly" class="text_input160" id="smecccustomermemberid" name="customerComplainPo.smecccustomermemberid" value="${customerComplainPo.smecccustomermemberid }" />

					  	  </TD>
					  	  <TD width="8%" height="26" class="table_body">会员姓名</TD>
                    	  <TD width="24%" class="table_none">
                    	     ${customerComplainPo.smecccustomername }&nbsp;
                    	  </TD>
                    	  <TD width="8%" height="26" class="table_body">会员电话</TD>
                    	  <TD class="table_none">
                    	     ${customerComplainPo.smecccustomerphone }&nbsp;
                    	  </TD>
					  	</TR>
                    	<TR>
                    	  <TD width="8%" height="26" class="table_body">配镜单号</TD>
					  	  <TD width="23%" class="table_none">
					  	      ${customerComplainPo.smecclinksalesid }&nbsp;
					  	      <input type="hidden" class="text_input160" readonly="readonly" id="ssetmlinksalesid" name="customerComplainPo.smecclinksalesid" value="${customerComplainPo.smecclinksalesid }"/>
					  	  </TD>
                    	  <TD height="26" class="table_body">记录人</TD>
                    	  <TD class="table_none">
                    	  	${personname }
			              </TD>
			              <TD height="26" class="table_body">预计处理日期</TD>
                    	  <TD class="table_none">
                    	  	<li class="horizontal_onlyRight">
                    	  	<input class="text_input100"
				               id="taday1"
						       name="customerComplainPo.smeccintendhandledate" value="${customerComplainPo.smeccintendhandledate }"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true,minDate:'%y-%M-%d'})" 
						       readonly="readonly" />
						       </li>
						       <li class="horizontal_onlyRight">
					  				  <img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onclick="today()"></li>
                    	  </TD>
                    	</TR>					  
                        <TR>
                          <TD height="26" class="table_body">投诉内容</TD>
                          <TD class="table_none" colspan="5">
                            <textarea name="customerComplainPo.smecccomplaincontent" id="smecccomplaincontent" 
                          	validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '投诉内容不能大于100字！'}]">${customerComplainPo.smecccomplaincontent }</textarea>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    
                    <c:if test="${permissionPo.keyg eq '1'}">
                    <table cellspacing="2" width="100%">
                    	<TR>
	                        <TD align="left"><input type="checkbox" id="handletype" name="customerComplainPo.handletype" value="1" onclick="show()">处理投诉</TD>
					  	</TR>
					</table>
					</c:if>
					
					<div style="display:none" id="showtr1">
	                    <table border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" cellspacing="2" width="100%">
	                       <TBODY>
	                        <TR>
	                    	  <TD width="8%" height="26" class="table_body">处理状态</TD>
	                    	  <TD class="table_none" colspan="5">
	                    	  	<select id="smechhandlestate" name="customerComplainPo.smechhandlestate">
	      		                 	<option value="">----请选择----</option>
	                    	        <OPTION value="1" ${customerComplainPo.smechhandlestate != "1"  ? '' : 'selected="selected"' } >处理中</OPTION>
	                    	        <OPTION value="2" ${customerComplainPo.smechhandlestate != "2"  ? '' : 'selected="selected"' } >已处理</OPTION>
	      	                    </select>
	                    	  </TD>
	                    	</TR>
	                    	<TR>
	                          <TD height="26" class="table_body">处理结果</TD>
	                          <TD class="table_none" colspan="5">
	                            <textarea name="customerComplainPo.smechhandlecontent" id="smechhandlecontent" 
	                          	validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '处理结果不能大于100字！'}]">${customerComplainPo.smechhandlecontent }</textarea>
	                          </TD>
	                        </TR>
	                        
	                       </TBODY>
	                    </table>
                    </div>
                    
                     <!--<c:if test="${first==1}" >   
	                     <table border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" cellspacing="2" width="100%">
		                       <TBODY>
		                       <TR>
		                          <TD height="26" width="8%" class="table_body">短信内容</TD>
		                          <TD class="table_none" colspan="5">                         
		                            <textarea name="content" readonly="readonly" id="content" >${content }</textarea>
		                          </TD>
		                        </TR>                 		                        
		                       </TBODY>
		                    </table>                   
	                        
                        </c:if>
                    -->
	                 <input type="hidden" name="content" id="content" value="${content}">   
                    <table id="title2" cellspacing="2">
                    
                    	<!--<c:if test="${first==1}" >  
                       <TR>                       
                          <TD>                                                    
								<c:choose>
									<c:when test="${second==1}">
										<input type=checkbox id="isSend" name="isSend" value="1" checked="checked" >发送短信 &nbsp;&nbsp;
									</c:when>
									<c:otherwise>
										<input type=checkbox id="isSend" name="isSend" value="1" >发送短信 &nbsp;&nbsp;
									</c:otherwise>
								</c:choose>
								
							
                            </TD>
                              </TR>
                         </c:if>
                         -->
                         <c:if test="${first==1}" >   
                            
								<c:choose>
									<c:when test="${second==1}">
										<input type="hidden" id="isSend" name="isSend" value="1" >
										
									</c:when>
									<c:otherwise>
										<input type="hidden" id="isSend" name="isSend" value="0" >
									</c:otherwise>
								</c:choose>
                         </c:if>  
						<tr height="10">
							<td>
							
								<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()" >
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空'  onClick="clean()" >
							</td>
						</tr>
					</table>
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

