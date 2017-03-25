<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员回访管理</title>

<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<!--<link rel="stylesheet" type="text/css" href="${ctx }/css/module/thickbox.css" /> -->
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
	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	returnVisitForm.action=link;
	  	returnVisitForm.submit();
	}
	
	function insert(){
		if(checkForm(document.all.returnVisitForm)){ 
			
			$("img").removeAttr("onclick");
			returnVisitForm.action = "insertCustomerReturnVisit.action";
			returnVisitForm.submit();
		}
		
	}	
	
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	$(document).ready(function(){
		$('#smecvfeedbackcontent').attr("value","${visitPo.smecvfeedbackcontent}");
	});
	
	function send(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initCustomerReturnVisitSms.action?salesid=${requestScope.smecvsalesid}",400,300,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initCustomerReturnVisitSms.action?salesid=${requestScope.smecvsalesid}",400,300,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【短信发送】";
	}

	function isshow(ReturnVisits){
		var obj = document.getElementById("showdiv");//该层控制短信回访
		var obj2= document.getElementById("showdiv1");//该层控制电话回访
		if(ReturnVisits.value=="1"){
			obj.style.display = "Block";
			obj2.style.display="None";
		}else if(ReturnVisits.value=="2"){
			obj.style.display = "None";
			obj2.style.display="Block";
		}
	}
		

</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="returnVisitForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="salesid" name="salesid" value="${requestScope.smecvsalesid}">

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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="8%" height="26" class="table_body">配镜单号</TD>
			               <TD class="table_none" width="24%">${salesBasicPo.ssesbsalesid}</TD>
			               <TD width="8%" height="26" class="table_body">所属门店</TD>
			               <TD class="table_none" width="24%">${salesBasicPo.ssesbshopName}</TD>
						   <TD width="8%" height="26" class="table_body">会员姓名</TD>
			               <TD class="table_none">${salesBasicPo.ssesbpersonName}</TD>
                        </TR> 
                        <TR>
                           <TD height="26" class="table_body">联系电话</TD>
			               <TD class="table_none">${salesBasicPo.ssesbphone}</TD>
						   <TD height="26" class="table_body">配镜时间</TD>
			               <TD class="table_none">${fn:substring(salesBasicPo.ssesbsalesdatetime,0,19)}</TD>
			               <TD height="26" class="table_body">取镜时间</TD>
			               <TD class="table_none">${fn:substring(salesBasicPo.ssesbtakeglassdata,0,19)}</TD>
                        </TR> 
                        <TR>
						   <TD height="26" class="table_body">原价金额</TD>
			               <TD class="table_none"><fmt:formatNumber value='${salesBasicPo.ssesbpricesum}' pattern="0.00"/></TD>
			               <TD height="26" class="table_body">折扣金额</TD>
			               <TD class="table_none"><fmt:formatNumber value='${salesBasicPo.ssesbdiscountnum}' pattern="0.00"/></TD>
						   <TD height="26" class="table_body">应收金额</TD>
			               <TD class="table_none"><fmt:formatNumber value='${salesBasicPo.ssesbsalesvalue}' pattern="0.00"/></TD>
                        </TR>  
                        <TR>
                           <TD height="26" class="table_body">实缴金额</TD>
			               <TD class="table_none"><fmt:formatNumber value='${salesBasicPo.ssesbpsalsvalue}' pattern="0.00"/></TD>
						   <TD height="26" class="table_body">特殊加工要求</TD>
			               <TD class="table_none" colspan="3">
			               <font color="red">
			               		<c:if test="${not empty(specialPDetailList)}"> 
			               			<s:iterator value="specialPDetailList">
			               				${ssesdrequirement}&nbsp;&nbsp;&nbsp;&nbsp;
			               			</s:iterator>
			               		</c:if>
			               	</font>
			               </TD>
                        </TR>                  
                      </TBODY>
                    </TABLE>
                     <c:if test="${not empty(salesODPo.ssesbballglassod)}">
                     <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH height="26" width="10%" scope=col>镜片种类</TH>
						  <TH width="10%" scope=col>右眼(R)/左眼(L)</TH>						
						  <TH width="8%" scope=col>球镜</TH>
						  <TH width="8%" scope=col>柱镜</TH>
						  <TH width="8%" scope=col>轴向</TH>
						  <TH width="7%" scope=col>add</TH>
						  <TH width="7%" scope=col>三棱镜</TH>
						  <TH width="7%" scope=col>基底</TH>
						  <TH width="7%" scope=col>棱镜</TH>
						  <TH width="7%" scope=col>远用瞳距</TH>
						  <TH width="7%" scope=col>近用瞳距</TH>
						  <TH width="7%" scope=col>远用VA</TH>
						  <TH width="7%" scope=col>近用VA</TH>
						  </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                        <TD height="26">
                          <c:if test="${(salesODPo.ssesborderstype)==1}"> 
			               	镜架成品
			               </c:if>
			               <c:if test="${(salesODPo.ssesborderstype)==2}"> 
			               	镜架订做
			               </c:if>
			               <c:if test="${(salesOSPo.ssesborderstype)==3}"> 
			               	隐形成品
			               </c:if>
			               <c:if test="${(salesOSPo.ssesborderstype)==4}"> 
			               	隐形订做
			               </c:if>
			             </TD>
                          <TD align="center">R</TD>
                          <TD>${salesODPo.ssesbballglassod}</TD>
                          <TD>${salesODPo.ssesbpostglassod}</TD>
                          <TD>${salesODPo.ssesbaxesod}</TD>
                          <TD>${salesODPo.ssesbaddod}</TD>
                          <TD>${salesODPo.ssesbarriseglassod}</TD>
                          <TD>${salesODPo.ssesbbasisod}</TD>
                          <TD>${salesODPo.ssesbprismod}</TD>
                          <TD>${salesODPo.ssesbinterhighod}</TD>
                          <TD>${salesODPo.ssesbinterdistanceod}</TD>
                          <TD>${salesODPo.ssesbfarvaod}</TD>
                          <TD>${salesODPo.ssesbclosevaod}</TD>
						</TR>
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						<TD height="26">
                          <c:if test="${(salesOSPo.ssesborderstype)==1}"> 
			              	 镜架成品
			               </c:if>
			               <c:if test="${(salesOSPo.ssesborderstype)==2}"> 
			               	镜架订做
			               </c:if>
			               <c:if test="${(salesOSPo.ssesborderstype)==3}"> 
			               	隐形成品
			               </c:if>
			               <c:if test="${(salesOSPo.ssesborderstype)==4}"> 
			               	隐形订做
			               </c:if>
			               </TD>
                          <TD align="center">L</TD>
                          <TD>${salesOSPo.ssesbballglassos}</TD>
                          <TD>${salesOSPo.ssesbpostglassos}</TD>
                          <TD>${salesOSPo.ssesbaxesos}</TD>
                          <TD>${salesOSPo.ssesbaddos}</TD>
                          <TD>${salesOSPo.ssesbarriseglassos}</TD>
                          <TD>${salesOSPo.ssesbbasisos}</TD>
                          <TD>${salesOSPo.ssesbprismos}</TD>
                          <TD>${salesOSPo.ssesbinterhighos}</TD>
                          <TD>${salesOSPo.ssesbinterdistanceos}</TD>
                          <TD>${salesOSPo.ssesbfarvaos}</TD>
                          <TD>${salesOSPo.ssesbclosevaos}</TD>
						</TR>					  
                      </TBODY>
                    </TABLE>
					</c:if>
					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="15%" height="26" scope=col>商品代码</TH>
						  <TH width="15%" scope=col>商品名称 </TH>						
						  <TH width="10%" scope=col>单价</TH>
						  <TH width="10%" scope=col>数量</TH>
						  <TH width="10%" scope=col>原价合计</TH>
						  <TH width="10%" scope=col>折扣率</TH>
						  <TH width="10%" scope=col>折扣金额</TH>
						  <TH width="10%" scope=col>应收金额</TH>
						  <TH width="10%" scope=col>商品描述</TH>
						  </TR>
						  
						<s:iterator value="goodsInfoList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">${ssesdsalesitemid}</TD>
                          <TD>${ssesdsalesitemname}</TD>
                          <TD>${ssesdsprice}</TD>
                          <TD>${ssesdnumber}</TD>
                          <TD>${ssesdpricesum}</TD>
                          <TD>${ssesddiscountrate}</TD>
                          <TD>${ssesddiscountnum}</TD>
                          <TD>${ssesdsalesvalue}</TD>
                          <TD>${ssesdgooddescribe}</TD>
						</TR>
						</s:iterator>						  
                      </TBODY>
                    </TABLE>
                    <c:if test="${not empty(addititonalCDetailList)}"> 
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="40%" height="26" scope=col>附加费用名称</TH>
						  <TH width="60%" scope=col>附加费用金额 </TH>						
						  </TR>
						  
						<s:iterator value="addititonalCDetailList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">${ssecostsname}</TD>
                          <TD>${sseamount}</TD>
						</TR>
						</s:iterator>						  
                      </TBODY>
                    </TABLE>
                    </c:if>
                    <TABLE width="100%" border=0 align=center cellPadding=0 cellSpacing=0 class="Privateborder">
                      <TBODY>
                      	<TR class=table_title align=middle>
                         	<TH height="26" align="left" scope=col colspan="6">会员回访信息</TH>						
						</TR></TBODY></TABLE>
						<TABLE width="100%" border=0 align=center cellPadding=0 cellSpacing=0 class="Privateborder">
                      <TBODY>
						<TR>
                    	    <TD width="11%" height="26" class="table_body">回访方式</TD>
                    	    <TD width="89%" class="table_none">
                        	<input type="radio" name="ReturnVisits" value="2" onClick="isshow(this)" checked>&nbsp; 电话回访
                           <!--   <c:if test="${systemParameterPo.fspshortmessage == '1'}">
                            <input type="radio" name="ReturnVisits"  value="1"  onClick="isshow(this)"> &nbsp; 短信回访
                            </c:if>
                            -->
                            </TD>
                        	 </TD>					
						</TR></TBODY></TABLE>
						<div id="showdiv1" >
						<TABLE width="100%" border=0 align=center cellPadding=0 cellSpacing=0 class="Privateborder">
                      <TBODY>
                        <TR>
                          <TD width="11%" height="26" class="table_body">会员卡号</TD>
                          <TD width="23%" class="table_none">
                          <input class="text_input100" id="memberId" name="memberId" disabled="disabled" value="${salesBasicPo.ssesbMemberId}" >
                          </TD>
                          <TD width="11%" class="table_body">姓名</TD>
                          <TD width="23%" class="table_none">
                          <input class="text_input100" id="personName1" name="personName1" disabled="disabled" value="${salesBasicPo.ssesbpersonName}" >
                          <input type="hidden" name="personName" id="personName" value="${salesBasicPo.ssesbpersonName}" />
                          </TD>
                          <TD width="11%" class="table_body" >人群类型</TD>
						  <TD width="21%" class="table_none" >
      	                   <select id="smecvcustomertype" name="smecvcustomertype" >
                            	<option value="">----请选择----</option>
      		                 	<option value="1">普通</option>
      		                 	<option value="2">高档</option>
      		                 	<option value="3">青少年渐进</option>
      		                 	<option value="4">成人渐进</option>
      	                    </select>
                          </TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">回访日期</TD>
                          <TD class="table_none">
                          <jsp:useBean id="now" class="java.util.Date" />
                          <fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />
                          </TD>
                          <TD class="table_body">回访满意度</TD>
                          <TD class="table_none">
                          <select id="smecvcontentment" name="smecvcontentment" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '回访满意度不能为空!'}]">
                             <option value="">----请选择----</option>
      		                 <c:if test="${not empty(satisfactionList)}">
				               	  <s:iterator value="satisfactionList">
                    	           <OPTION value="${fcsid}">${fcsname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select><label style="color:red;">&nbsp;*</label>
                          </TD>
                          <TD class="table_body">反馈内容</TD>
                          <TD class="table_none">
                          <select id="smecvfeedbackcontent" name="smecvfeedbackcontent" >
                          	<option value="">----请选择----</option>
                            <option value="度数不适">度数不适</option>
							<option value="松紧不适">松紧不适</option>
							<option value="配戴中">配戴中</option>
							<option value="未戴未取">未戴未取</option>
							<option value="自身原因">自身原因</option>
							<option value="眼镜本身">眼镜本身</option>
							<option value="其他">其他</option>
                           </select>
                           </TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">配适度</TD>
                          <TD class="table_none">
                          <select id="smecvssd" name="smecvssd" >
                          	<option value="">----请选择----</option>
                            <option value="1">良好</option>
							<option value="2">一般</option>
                          </select>
                          </TD>
                          <TD class="table_body">产品认知度</TD>
                          <TD class="table_none">
                          <select id="smecvcprzd" name="smecvcprzd" >
                          	<option value="">----请选择----</option>
                            <option value="1">了解</option>
							<option value="2">不了解</option>
                          </select>
                          </TD>
                          <TD class="table_body">再次选择</TD>
                          <TD class="table_none">
                          <select id="smecvzcxz" name="smecvzcxz" >
                          	<option value="">----请选择----</option>
                            <option value="1">会</option>
							<option value="2">不会</option>
                          </select>
                          </TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="60">解决方法</TD>
                          <TD colspan="5" class="table_none">
                              <textarea id="smecvresolvent" name="smecvresolvent"></textarea>
                          </TD>
                        </TR>
                        
                         <!--<c:if test="${first==1}" >                      
	                        <TR>
	                          <TD height="26" class="table_body">短信内容</TD>
	                          <TD class="table_none" colspan="5">                         
	                            <textarea name="content" readonly="readonly" id="content" >${content }</textarea>
	                          </TD>
	                        </TR>
                        </c:if>-->
                        <input type="hidden" name="content" id="content" value="${content}">
                        
						<!-- <TR>
                          <TD class="table_body" height="60">备注</TD>
                          <TD colspan="5" class="table_none">
                          	<textarea id="smecvremark" name="smecvremark"></textarea>
                          </TD>
                         </TR>
                         -->
                      </TBODY>
                    </TABLE>    </div>
                    
                      <div id="showdiv" style="display:none">				
                      <TABLE width="100%" border=0 align=center cellPadding=0 cellSpacing=0 class="Privateborder">
                      <TBODY>	
                        <TR height="26">
                          <TD width="11%" class="table_body">会员电话</TD>
                          <TD width="23%" class="table_none">
                          <input class="text_input100" id="ssesbphone" name="ssesbphone" readonly="readonly" value="${salesBasicPo.ssesbphone}" >
                          </TD>
                          <TD width="11%" class="table_body">回访日期</TD>
                          <TD width="23%" class="table_none"><jsp:useBean id="nows" class="java.util.Date" />
                          <fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />
                          </TD>
                          <TD width="11%" class="table_body" >短信类型</TD>
						  <TD width="21%" class="table_none" >
      	                   <select id="smecvcustomertype" name="smecvcustomertype">
                            	<option value="">----请选择----</option>
      		                 	<option value="1" selected>回访</option>
      		                 	<option value="2" >会员卡升级</option>
      		                 	<option value="3" >会员高级查询</option>
      		                 	<option value="4" >积分增减</option>
                                <option value="5" >验光</option>
                                <option value="6" >取镜</option>
                                <option value="7" >取镜完毕</option>
                                <option value="8" >误期预委外管理</option>
                                <option value="9" >结款管理</option>
      	                    </select>
                          </TD>
                        </TR>       
                        <TR height="26">
                          <TD class="table_body">短信内容</TD>
                          <TD colspan="5" class="table_none">
                              <textarea id="smecvcontent" name="smecvcontent">${requestScope.smecvcontent}</textarea>
                          </TD>
                        </TR>
					</TBODY>	
                    </TABLE>
                    </DIV>
                    
                    
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                      <!--
                      <c:if test="${first==1}" >  
                       <TR>
                        
                          <TD align="left">
                            <div align="left">
                            
								<c:choose>
									<c:when test="${second==1}">
										<input type=checkbox id="isSend" name="isSend" value="1" checked="checked" >发送短信 &nbsp;&nbsp;
									</c:when>
									<c:otherwise>
										<input type=checkbox id="isSend" name="isSend" value="1" >发送短信 &nbsp;&nbsp;
									</c:otherwise>
								</c:choose>
								
							
                              </div></TD>
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
                         
                        <TR>
                        
                          <TD align="left">
                            <div align="left">
                           
                              <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn title="保存" onClick="javascript:insert()">&nbsp;
                              <!--  
                              <c:if test="${smsSetPo.fssvisitflag == '1' || systemParameterPo.fspshortmessage == '1'}">
                              <img src="${ctx}/img/newbtn/btn_sendmessage_0.png" btn=btn title="发送短信" onClick="javascript:send()">
                              </c:if>
                              -->
                              </div></TD></TR>
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