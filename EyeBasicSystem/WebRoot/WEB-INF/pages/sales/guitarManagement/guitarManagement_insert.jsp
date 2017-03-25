<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
	<TITLE>FrameWork</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    </HEAD>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
        if('${systemParameterPo.fsphisflag}' == '0' || '${person.bdplinkhisflag}' == '0'){
			document.getElementById('smecimemberid').focus(); 
        }
		var printflag = '${param.print}';
		if(printflag == '1'){
			printflag = '';
			setReportEvent('${param.salseID}','${param.ssesborderstype}','${param.checkoutFlag}','1');
		}
	});

	/**
	 *销售结款弹窗
	 */
	function cashOpen(id,ssesborderstype,flag,flag2,ssesbcheckoutflag){
        
        if ('${systemParameterPo.fsphisflag}' == '2' && '${person.bdplinkhisflag}' == '1' && (flag == '0' || flag2 != '0') && ssesbcheckoutflag == '0'){
            alert('此单收费项目未向HIS系统提交或已作废，不能结款!');
            return;
        }
		
		var moduleID = $('input[name=moduleID]').val();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selGuitarManagementOpen.action?hid="+id+"&moduleID="+moduleID+"&ssesborderstype="+ssesborderstype,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selGuitarManagementOpen.action?hid="+id+"&moduleID="+moduleID+"&ssesborderstype="+ssesborderstype,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【银台结款】";
    }
	
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDetailsCustomerInfo.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDetailsCustomerInfo.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【顾客信息】";
	}

	/**
	 * 配镜单打印主程序入口
	 * @id	配镜单号；
	 * @billType	配镜单销售类型；1：框架成品；2：框架定制；3:隐形成品；4：隐形定制；5：辅料；
	 * @dingjinFlag	是否欠款；1：欠款；
	 * @wflag	打印类型；1：销售；-1：退款；（为''空时，表示1)
	 */
	function setReportEvent(id,billType,dingjinFlag,wflag){	
		var DataURL='';
		
		//1、打印定金单
		if(dingjinFlag=='1'){//需要进行订金单打印
	    	if ($.trim('${systemParameterPo.fspsubscriptionbillname}') == ''){//没有配置订金单样式
	            alert('请先配置订金单样式!');
	            return;
	        }else{
				if($.trim('${systemParameterPo.fspsubscriptionbillserver}') =="1"){
					DataURL="report.action?reportlet=${systemParameterPo.fspsubscriptionbillname}&__bypagesize__=false&salesid="+id;
				}else if($.trim('${systemParameterPo.fspsubscriptionbillserver}') =="2"){
	    			DataURL = '<%= getServletContext().getInitParameter("pjdUrl")%>';
	    			DataURL+="eims_reporting/${systemParameterPo.fspsubscriptionbillname}&salesID="+id+"&rs:Command=Render";	
	    		}
				window.open (DataURL, '订金单', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
	        }				
		}

		//2、打印配镜单
    	if(billType=='1' || billType=='2'){
    		if (wflag == '' || wflag=='1'){
    			if ($.trim('${systemParameterPo.fspsalesbillname1}') == ''){
    	            alert('请先配置框架配镜单样式!');
    	            return;
    	        }else{
    	    		if($.trim('${systemParameterPo.fspsalesbillserver1}') =="1"){
    	    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname1}&__bypagesize__=false&wflag="+ wflag +"&salesid="+id;
    	    		}else if($.trim('${systemParameterPo.fspsalesbillserver1}') =="2"){
    	    			DataURL = '<%= getServletContext().getInitParameter("pjdUrl")%>';
    	    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname1}&salesID="+id+"&rs:Command=Render";	
    	    		}
    	        }
	        }else if(wflag=='-1'){
	        	if ($.trim('${systemParameterPo.fspsalesbillname1tui}') == ''){
		            alert('请先配置框架退款配镜单样式!');
		            return;
		        }else{
		    		if($.trim('${systemParameterPo.fspsalesbillserver1tui}') =="1"){
		    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname1tui}&__bypagesize__=false&wflag="+ wflag +"&salesid="+id;
		    		}else if($.trim('${systemParameterPo.fspsalesbillserver1tui}') =="2"){
		    			DataURL = '<%= getServletContext().getInitParameter("pjdUrl")%>';
		    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname1tui}&salesID="+id+"&rs:Command=Render";	
		    		}
		        }
	        }   			
    	}else if(billType=='3' || billType=='4'){
    		if (wflag == '' || wflag=='1'){
        		if ($.trim('${systemParameterPo.fspsalesbillname3}') == ''){
    	            alert('请先配置隐形配镜单样式!');
    	            return;
    	        }else{
    	    		if($.trim('${systemParameterPo.fspsalesbillserver3}') =="1"){
    	    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname3}&__bypagesize__=false&wflag="+ wflag +"&salesid="+id;
    	    		}else if($.trim('${systemParameterPo.fspsalesbillserver3}') =="2"){
    	    			DataURL = '<%= getServletContext().getInitParameter("pjdUrl")%>';
    	    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname3}&salesID="+id+"&rs:Command=Render";	
    	    		}
    	        }
	        }else if(wflag=='-1'){
	    		if ($.trim('${systemParameterPo.fspsalesbillname3tui}') == ''){
		            alert('请先配置隐形退款配镜单样式!');
		            return;
		        }else{
		    		if($.trim('${systemParameterPo.fspsalesbillserver3tui}') =="1"){
		    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname3tui}&__bypagesize__=false&wflag="+ wflag +"&salesid="+id;
		    		}else if($.trim('${systemParameterPo.fspsalesbillserver3tui}') =="2"){
		    			DataURL = '<%= getServletContext().getInitParameter("pjdUrl")%>';
		    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname3tui}&salesID="+id+"&rs:Command=Render";	
		    		}
		        }
	        } 
	    }else if(billType=='5'){
    		if (wflag == '' || wflag=='1'){
        		if ($.trim('${systemParameterPo.fspsalesbillname5}') == ''){
    	            alert('请先配置辅料配镜单样式!');
    	            return;
    	        }else{
    	    		if($.trim('${systemParameterPo.fspsalesbillserver5}') =="1"){
    	    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname5}&__bypagesize__=false&wflag="+ wflag +"&salesid="+id;
    	    		}else if($.trim('${systemParameterPo.fspsalesbillserver5}') =="2"){
    	    			DataURL = '<%= getServletContext().getInitParameter("pjdUrl")%>';
    	    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname5}&salesID="+id+"&rs:Command=Render";	
    	    		}
    	        } 
	        }else if(wflag=='-1'){
	    		if ($.trim('${systemParameterPo.fspsalesbillname5tui}') == ''){
		            alert('请先配置辅料退款配镜单样式!');
		            return;
		        }else{
		    		if($.trim('${systemParameterPo.fspsalesbillserver5tui}') =="1"){
		    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname5tui}&__bypagesize__=false&wflag="+ wflag +"&salesid="+id;
		    		}else if($.trim('${systemParameterPo.fspsalesbillserver5tui}') =="2"){
		    			DataURL = '<%= getServletContext().getInitParameter("pjdUrl")%>';
		    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname5tui}&salesID="+id+"&rs:Command=Render";	
		    		}
		        } 
	        }		    		    
		}else{
			alert("单据类型异常！");
			return;
		}
	    window.open (DataURL, '结款单', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');      
	}
		
	/**
	 *查看
	 */
	function selCustomerInfo(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelCustomerInfoWin.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelCustomerInfoWin.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员查询】";
    }
    
    function deleteSalesID(salesid,flag,flag1,flag2,flag3){
        if('${systemParameterPo.fsphisflag}' == '2' && '${person.bdplinkhisflag}' == '1'){
	        if (!(flag1 != '0' || (flag == '0' && flag1 == '0'&& flag2 == '0'&&flag3 == '0'))){
	            alert('此单收费项目已向HIS系统提交或未作废，不能删除!');
	            return;
            }
        }
                
    	var moduleID = $('input[name=moduleID]').val();
    	
    	var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initGuitarManagementDelete.action?salesid=" + salesid + "&moduleID="+moduleID,400,140,topRows,topCols,returnRefresh(true),false);
		document.getElementById('popupTitle').innerHTML="【配镜单删除】";
    }
    
    function setCustomer(memberid){
		document.getElementById('smecimemberid').value = memberid;
		$("img").removeAttr("onclick");
		guitarMangermentForm.action = "selGuitarManagement.action";
		guitarMangermentForm.submit()
	}
	
	
   function setSalesValue(json){
   		$('#salseID').val(json.ssesbsalesid );// salesID
   		$('#priceSum').val(json.ssesbpricesum );// 原价合计
   		$('#discountNum').val(json.ssesbdiscountnum );// 折扣金额
   		$('#salseValue').val(json.ssesbsalesvalue );// 应收金额
   		$('#psalsvalue').val(json.ssesbpsalsvalue );// 实缴金额
   		$('#ssesborderstype').val(json.ssesborderstype);//订单类型
   		$('#ssesbarrearsvalue').val(json.ssesbarrearsvalue);//欠款
   		$('#checkoutFlag').val(json.ssesbcheckoutflag);
   		document.getElementById('jfButton').disabled = false;
   }
    
   function validate(){
   		if($('#salseID').val() == ''){
   			return;
   		}
		if(!confirm('请确认提交！')){
			return;
		}
		$("img").removeAttr("onclick");
		guitarMangermentForm.action = 'insertGuitarManagement.action';
		guitarMangermentForm.submit();
	}
	
	function validateSales(obj){
		if(obj.value.trim() == ''){
			$('#zl').val('0.00');
			return ;
		}
		
		if(!isNaN(obj.value.trim())){
			$('#zl').val(($('#psalsvalue').val().trim() - obj.value.trim()).toFixed(2));
		}
	}
	
	function validateSalesFocus(obj){
		if(obj.value.trim() == ''){
			$('#zl').val('0.00');
			return ;
		}
		if (obj.value.trim() == '' || !(/^[0-9]*([.][0-9]{1,2})?$/.test(obj.value.trim()))){
			alert('数字格式输入错误！');
			obj.select();
			return false;
		}
		//alert(obj.value);
		obj.value = parseFloat(obj.value).toFixed(2);
		$('#zl').val(($('#psalsvalue').val().trim() - obj.value.trim()).toFixed(2));
	}
	
	/*配镜单信息*/
	function winPopUp(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectInTransitDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectInTransitDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【配镜单查询】";
	} 


   function showArrearsValues(tid,tdptid) {  
    	$('#drljje').load("getArrearsValuesToo.action?tid="+tid+"&tdptid="+tdptid);
   }

	function cashOpen2(id,flag,flag2){
        if ('${systemParameterPo.fsphisflag}' == '2' && '${person.bdplinkhisflag}' == '1' && flag == '1' && '${person.bdpnotpayfeeform}' == '1'){
            alert('此单收费项目未收全款，不能提交!');
            return;
        }
	    
		var moduleID = $('input[name=moduleID]').val();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initSalesNotChargeInfoToHisInsert.action?hid="+id+"&moduleID="+moduleID+"&checkoutflag="+flag,400,140,topRows,topCols,returnRefresh(true),false);
		document.getElementById('popupTitle').innerHTML="【提交收费项目】";
    }
    
   
function selectCust(flag){
    if(flag){
	    $("img").removeAttr("onclick");
		guitarMangermentForm.action = "selGuitarManagement.action";
		guitarMangermentForm.submit();
    }
}
 /**
	 *回车事件
	 */
function selectCustomer(){
    if('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2'){
            alert('此门店已经连接HIS系统，不能查询会员!');
         return ;
	}
	if(document.getElementById('smecimemberid').value.trim() != ''){
		if(event.keyCode == 13){
			var memberId=document.getElementById('smecimemberid').value;
			var salesId=document.getElementById('fmmsalesid').value;
				if(memberId=='' && salesId==''){
					return false;
				}
				$("img").removeAttr("onclick");
				guitarMangermentForm.action = "selGuitarManagement.action";
				guitarMangermentForm.submit();
		}
	}
}
function judgekey(){
     if(document.getElementById('smecimemberid').value.trim() != '' || document.getElementById('fmmsalesid').value.trim() != null){
	 	 if(event.keyCode == 13){
				$("img").removeAttr("onclick");
				guitarMangermentForm.action = "selGuitarManagement.action";
				guitarMangermentForm.submit();
          }
     }
}	
</script>
<jsp:include page="/hisCusWin_js.jsp" flush="true" />
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="guitarMangermentForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>银台</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：结款管理 </TD>
            <TD align="right"><font color="black" size="3" id="drljje"><img src="${ctx }/img/newbtn/btn_hudrsyzje_0.png" name="button22" title='获取当日收银总金额' btn=btn onclick="showArrearsValues('${tid}','${departmentID}');" ></font></TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3" align=right><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      
      
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">结款管理</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
                         <c:if test="${(permissionPo.keyb==1)}">  
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onClick="JavaScript:window.location.href='initPutOptometrySel.action?moduleID=${requestScope.moduleID}' ;"
                      UNSELECTABLE="on">打印配镜单</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></c:if>
                    </TR></TBODY></TABLE></TD>
					</TR>
					</TBODY>
					</TABLE>
				</TD>
				</TR>
        <TR>
          <TD bgColor=#ffffff colspan="2">
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif ><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
				  <fieldset>
						<legend>顾客资料</legend>
						<TABLE width="98%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
					      <tr height="26">
					        <td bgcolor="#cadee8">
					          <li class="horizontal">卡号&nbsp;
					                <input type="text" id="smecimemberid" name="smecimemberid" class="text_input100" value="${customerInfoPo.smecimemberid }"
					                 onkeydown="selectCustomer();" ${ systemParameterPo.fsphisflag == '2' && person.bdplinkhisflag == '1' ? 'readonly=readonly':'' }>
					          </li>
					            <li class="horizontal">
					              <img src="${ctx }/img/newbtn/btn_hydq_0.png" btn=btn his=his title='查找' >
					              <img src="${ctx }/img/newbtn/btn_search_0.png" name="button22" title='查找' btn=btn onclick="selCustomerInfo();" >
					            </li>
					 
					            <li class="horizontal">配镜单号&nbsp;
					                <input id="fmmsalesid" name="fmmsalesid" class="text_input160" onkeydown="judgekey()" value="${customerInfoPo.fmmsalesid }">
					          </li>
					          <li class="horizontal">姓名&nbsp;
					                <input class="text_input60" readOnly="readOnly" value="${customerInfoPo.smeciname }">
					          </li>
					          <li class="horizontal">性别&nbsp;
					                <input value="${not empty(customerInfoPo.smecisex) ? (customerInfoPo.smecisex == '0' ? '男' : '女') : ''}" class="text_input40" readOnly="readOnly">
					          </li>
					          <li class="horizontal">&nbsp;
					          <c:if test="${empty(customerInfoPo.smecicustomerid)}"></c:if>
					          <c:if test="${not empty(customerInfoPo.smecicustomerid)}">
					            <img src="${ctx }/img/newbtn/btn_details_0.png" btn=btn name="button32" title='详情' onClick="javascript:details('${customerInfoPo.smecicustomerid }');" >
					          </c:if>
					          </li>
					      </tr>
					    </table>
					</fieldset>
                    <TABLE id=ctl00_PageBody_PostButton  cellSpacing=0 cellPadding=0 width="100%" border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
							<div align="right">
							  &nbsp;
							</div>
						  </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <c:if test="${not empty(salesBasicPos)}"> 
                    <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateTable privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <c:choose>
                              <c:when test="${(permissionPo.keye==1) && systemParameterPo.fsphisflag==2 && person.bdplinkhisflag==1}">
                                  <TH width="12%" scope=col colspan="4">操作</TH>
                              </c:when>
                              <c:otherwise>
                                  <TH width="9%" scope=col colspan="3">操作</TH>
                              </c:otherwise>
                          </c:choose>
                          
                          <TH height="26" scope=col>销售单号</TH>
                          <TH width="10%" scope=col>销售人员</TH>
                          <TH width="10%" scope=col>原价合计</TH>
                          <TH width="10%" scope=col>折扣金额</TH>
                          <TH width="10%" scope=col>抹零金额</TH>
                          <TH width="10%" scope=col>应收金额</TH>
                          <TH width="10%" scope=col>实缴金额</TH>
                          <TH width="10%" scope=col>欠费金额</TH>
                        </TR>
                        
                        <c:forEach var="po" items="${salesBasicPos}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26" width="3%">
                            <img src="${ctx }/img/newbtn/search_0.png" name="button32234" title='详情' btn=btn onClick="winPopUp('${po.ssesbsalesid }')">
                          </TD>

                          <c:if test="${(permissionPo.keye==1) && systemParameterPo.fsphisflag==2 && person.bdplinkhisflag==1}">
	                          <TD width="3%">
	                              <c:if test="${po.ssesbnothisflag == 0 && po.ssesbcheckoutflag == '0'}">
	                                  <img src="${ctx }/img/newbtn/payfee_0.png" name="pay" btn=btn title='提交待收费信息' onclick="cashOpen2('${po.ssesbsalesid}','${po.ssesbcheckoutflag }','${po.ssesbhisflag}')">
	                              </c:if>
	                          </TD>
                          </c:if>
                             	                                                                           
                          <TD width="3%">
	                          <c:if test="${(permissionPo.keya==1)&&(po.ssesbhispayflag != '0'|| po.ssesbcheckoutflag == '1'|| systemParameterPo.fsphisflag==0 || person.bdplinkhisflag==0 )}">
	                          	<img src="${ctx }/img/newbtn/pay_0.png" name="pay" btn=btn title='缴费' onclick="cashOpen('${po.ssesbsalesid}','${po.ssesborderstype }','${po.ssesbhispayflag}','${po.ssesbhiscancelflag }','${po.ssesbcheckoutflag }')">
	                          </c:if>
	                          <c:if test="${(permissionPo.keya==1)&&(po.ssesbhispayflag == '0')&& (po.ssesbcheckoutflag != '1')&& (systemParameterPo.fsphisflag==2 && person.bdplinkhisflag==1)}">
	                          	<img src="${ctx }/img/newbtn/pay_2.png" name="pay" btn=btn title='HIS未收费'>
	                          </c:if>
	                          
                          </TD>
                          
                          <TD width="3%">
	                          <c:if test="${(permissionPo.keyd==1) && (po.ssesbhiscancelflag != '0' || ( po.ssesbnothisflag =='0' && po.ssesbhisflag == '0' && po.ssesbhiscancelflag=='0' && po.ssesbhispayflag=='0' ))|| systemParameterPo.fsphisflag==0 || person.bdplinkhisflag==0 }">
	                          	<img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onclick="deleteSalesID('${po.ssesbsalesid }','${po.ssesbhisflag }','${po.ssesbhiscancelflag}','${po.ssesbnothisflag}','${po.ssesbhispayflag}');">
	                          </c:if>
	                          <c:if test="${(permissionPo.keyd==1) && (po.ssesbhiscancelflag == '0' &&( po.ssesbnothisflag !='0' || po.ssesbhisflag != '0'|| po.ssesbhispayflag!='0' ))}">
	                          	<img src="${ctx }/img/newbtn/delete_2.png" btn=btn title='删除' onclick="deleteSalesID('${po.ssesbsalesid }','${po.ssesbhisflag }','${po.ssesbhiscancelflag}','${po.ssesbnothisflag}','${po.ssesbhispayflag}');">
	                          </c:if>
                          </TD>
                          
                          <TD>${po.ssesbsalesid }</TD>
                          <TD>${po.ssesbsalerName }</TD>
                          <TD>${po.ssesbpricesum }</TD>
                          <TD>${po.ssesbdiscountnum }</TD>
                          <TD>${po.ssesbrenums }</TD>
                          <TD>${po.ssesbsalesvalue }</TD>
                          <TD>${po.ssesbpsalsvalue }</TD>
                          <c:if test="${(po.ssesbcheckoutflag)==1}">
                          <TD><font color="red" ><fmt:formatNumber value='${po.ssesbarrearsvalue }' pattern="0.00"/></font></TD>
                          </c:if>
                          <c:if test="${(po.ssesbcheckoutflag)==0}">
                          <TD>&nbsp;</TD>
                          </c:if>
                        </TR>
                        </c:forEach>
                      </TBODY>
                    </TABLE>
                    </c:if>
                </DIV>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif colspan="2"><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff colspan="2"><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
