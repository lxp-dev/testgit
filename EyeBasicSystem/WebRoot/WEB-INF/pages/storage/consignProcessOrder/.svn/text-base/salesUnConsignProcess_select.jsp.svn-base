<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择配镜单</title>
</head>
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	goodsForm.action=link;
	  	goodsForm.submit();
		showLoadingBar();
	}

	function selectContact(obj){
		var act = document.activeElement.id; 
		
		if(act == "pageNos"){
			$('#'+act).onkeyup();
		}else{
			if(event.keyCode==13){
				search();
			}
		}
	}
	
	function search(){
		$("img").removeAttr("onclick");
		goodsForm.action = "selUnConsignProcessOrder.action";
		goodsForm.submit();
		showLoadingBar();
	}
	function clean(){
		document.getElementById('salesID').value = "";
		document.getElementById('deptID').value = "";
		document.getElementById('ssesbsalesdatestarttime').value = "";
		document.getElementById('ssesbsalesdateendtime').value = "";
		document.getElementById('ssesbtakeglassstartdata').value = "";
		document.getElementById('ssesbtakeglassenddata').value = "";
		document.getElementById('cstcpoordergoodscategory').value = "";
		document.getElementById('supplierID').value = "";
		document.getElementById('goodsName').value = "";
        <c:if test="${systemParameterPo.fspdjsbm == '1'}">
        document.getElementById('djsbm').value = "";
        </c:if> 			
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}	

	/**
	 *  调用页面赋值
	 */
	function setValue(){        
        var chk=document.getElementsByName("chk");
        var cstcposupplierid=document.getElementsByName("cstcposupplierid");
        var cstcpodbilltype=document.getElementsByName("cstcpodbilltype");
        var objValue="";
        var count=0;   
        var count1=0;  
        var count2=0; 
        var supplierid= "";
          for(var i=0;i<chk.length;i++){
          if(chk[i].checked==true){
           	 if(supplierid==""){
	          supplierid=cstcposupplierid[i].value;
	         }else{
	           if(supplierid!=cstcposupplierid[i].value)
	           {
	          	 count1++; 
	           }
	         }  
	         }
        }
       
         var type= "";
          for(var i=0;i<chk.length;i++){
          if(chk[i].checked==true){
           	 if(type==""){
	          type=cstcpodbilltype[i].value;
	         }else{
	           if(type!=cstcpodbilltype[i].value)
	           {
	          	 count2++; 
	           }
	         }  
	         }
        }
        
         if(count1!=0){
          alert('请选择相同的制造商进行批量生成委外订单!');
          return false;
        }
         if(count2!=0){
          alert('请选择相同的配镜类型进行批量生成委外订单!');
          return false;
        }
        for(var i=0;i<chk.length;i++){
           if(chk[i].checked==true){
           	 if(objValue==""){
	           objValue=chk[i].value;
	         }else{
	           objValue=objValue+","+chk[i].value;
	         }  
	         count++;          
           }
        }
        
        if(count==0){
          alert('请选择配镜单!');
          return false;
        }
     	var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initConsignProcessOrderBatchInserts.action?selesid="+objValue+"&ordertype="+type+"&supplierid="+supplierid+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initConsignProcessOrderBatchInserts.action?selesid="+objValue+"&ordertype="+type+"&supplierid="+supplierid+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【委外订单新增】";
	}
	
	/**
	 *  checkbox全选
	 */
	function chkAll(){
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        for(var i=0;i<chk.length;i++){
           chk[i].checked = chks.checked;
        }
    }
    
    function setValueSeles(selesid,type,supplierid,suppliername){
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initConsignProcessOrderInserts.action?selesid="+selesid+"&ordertype="+type+"&supplierid="+supplierid+"&suppliername="+EncodeUtf8(suppliername)+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initConsignProcessOrderInserts.action?selesid="+selesid+"&ordertype="+type+"&supplierid="+supplierid+"&suppliername="+EncodeUtf8(suppliername)+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【委外订单新增】";
	}

    $(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});

	function printBillID(salesid){ //点击打印的时候调用
		var reportURL = "report.action?reportlet=print_peijingdan_weiwaidingdan.cpt&salesid=" + salesid +"&__bypagesize__=false";  //拼接最终的报表路径
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin(url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(reportURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}			
		document.getElementById('popupTitle').innerHTML="【配镜单打印】";	
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="poType" value="${requestScope.poType }" />

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%" ><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>采购管理</TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：委外订单管理</TD>
            
            <TD align="right" width="40%" valign="bottom" >&nbsp;
            	<img src="${ctx }/img/newbtn/btn_blscwwdd_0.png" btn=btn title="批量生成委外订单" name=ctl00$PageBody$Button1 onClick="setValue();">
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
          
            </TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="4">
            <table></table>
            	</TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR><TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
          <!--?Start-->
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                       
                      UNSELECTABLE="on">未生成委外订单</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD>
                   
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initConsignProcessOrderSel.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">已生成委外订单</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>
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
						   <TD width="9%" height="26" class="table_body">配镜单号</TD>
			               <TD class="table_none" width="24%">
                            <input class="text_input160" type="text"  id="salesID" name="salesID" value="${requestScope.salesID}">			               
			               </TD>
			               <TD width="9%" height="26" class="table_body">制造商</TD>
			               <TD class="table_none" width="24%">
			                <select id="supplierID" name="supplierID">
                             <option value="">----请选择----</option>
      		                 <s:iterator value="supplierList">
				               <option value="${bspid}" ${supplierID == bspid ? 'selected="selected"' : '' }>${bspsuppliername}</option>
	     	                 </s:iterator></select>
			               </TD>
						   <TD width="9%" height="26" class="table_body">销售门店</TD>
			               <TD class="table_none">
                            <select id="deptID" name="deptID">
                             <option value="">----请选择----</option>
      		                 <s:iterator value="deptList">
				               <option value="${bdpdepartmentid}" ${requestScope.deptID == bdpdepartmentid ? 'selected="selected"' : '' }>${bdpdepartmentname}</option>
	     	                 </s:iterator>
      	                   </select>		               
			               </TD>
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">配镜时间</TD>
			               <TD class="table_none">
                           <input id="ssesbsalesdatestarttime"
					       name="ssesbsalesdatestarttime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'ssesbsalesdateendtime\')}'})"
					       value="${ssesbsalesdatestarttime}" /> 至 
					       <input id="ssesbsalesdateendtime"
					       name="ssesbsalesdateendtime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'ssesbsalesdatestarttime\')}'})" 
					        value="${ssesbsalesdateendtime}" /></TD>	
						   <TD height="26" class="table_body">取镜时间</TD>
			               <TD class="table_none" >
                            <input id="ssesbtakeglassstartdata"
					       name="ssesbtakeglassstartdata" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'ssesbtakeglassenddata\')}'})"
					       value="${ssesbtakeglassstartdata}" /> 至 
					       <input id="ssesbtakeglassenddata"
					       name="ssesbtakeglassenddata" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'ssesbtakeglassstartdata\')}'})" 
					        value="${ssesbtakeglassenddata}" />			               
			               </TD>
			               <TD height="26" class="table_body">配镜类型</TD>
			               <TD class="table_none" >
			               <select id="cstcpoordergoodscategory" name="cstcpoordergoodscategory">
                           	  <option value="">----请选择----</option>
								    <option value="2" ${cstcpoordergoodscategory == 2 ? 'selected="selected"' : '' }>框镜订做片</option>
								    <option value="4" ${cstcpoordergoodscategory == 4 ? 'selected="selected"' : '' }>隐形订做片</option>
                           	  </select>          
			               </TD>
                        </TR>
                        <TR>
						<c:choose>
							<c:when test="${systemParameterPo.fspdjsbm == '1'}">
								<TD height="26" class="table_body">商品名称</TD>
	                          	<TD class="table_none">
	                              <input class="text_input200" id="goodsName" name="goodsName" value="${goodsName }" maxlength="100">
	                          	</TD>                                                                   
				               	<TD height="26" class="table_body">单据识别码</TD>
				               	<TD class="table_none" colspan="3">
	                              <input class="text_input160" type="text" id="djsbm" name="djsbm" value="${requestScope.djsbm}" onkeyup="selectContact(this)"/>
				               	</TD>							
							</c:when>
							<c:otherwise>
								<TD height="26" class="table_body">商品名称</TD>
	                          	<TD class="table_none" colspan="5">
	                              <input class="text_input200" id="goodsName" name="goodsName" value="${goodsName }" maxlength="100">
	                          	</TD> 							
							</c:otherwise>
						</c:choose>     
						</TR>                  
                      </TBODY>
                    </table>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png"  btn=btn  title='查询' onclick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean()" >
								
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
					<c:if test="${not empty(goodsList)}"> 
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
                          <TH width="3%" height="26" scope=col><input type="checkbox" name="chks"  id="chks" onclick="chkAll()"></TH>     
                          <c:choose>
							<c:when test="${systemParameterPo.fspdjsbm == '1'}">
								<TH width="6%" scope=col colspan="2">操作</TH>
							</c:when>
							<c:otherwise>
								<TH width="3%" scope=col>操作</TH>
							</c:otherwise>
						  </c:choose>                 
                          <TH width="15%" scope=col>配镜单号</TH>
                          <TH width="7%" scope=col>顾客姓名</TH>
                          <TH scope=col>销售部门</TH>
                          <TH width="20%" scope=col>制造商名称</TH>
                          <TH width="9%" scope=col>配镜类型</TH>
                          <TH width="13%" scope=col>配镜时间</TH>
                          <TH width="13%" scope=col>取镜时间</TH>
						  </TR>
						<s:iterator value="goodsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">                         
                          <TD height="26">
                          <input type="checkbox" id="chk" name="chk" value="${cstcpodglassesbillid}">
                          </TD>
						<c:if test="${systemParameterPo.fspdjsbm == '1'}">
							<TD>
	                    		<img src="${ctx }/img/newbtn/print_0.png" btn=btn title="打印" style="cursor: hand;" onClick="printBillID('${cstcpodglassesbillid }')"/>
	                  		</TD>
						</c:if>                        
                          <TD>
		                    <img src="${ctx }/img/newbtn/cgsh_0.png" btn=btn title='生成委外订单' onClick="setValueSeles('${cstcpodglassesbillid}','${cstcpodbilltype}','${cstcposupplierid}','${cstcposuppliername}')">
		                  </TD>
                          <TD>${cstcpodglassesbillid} <input type="hidden" id="cstcpodglassesbillid" name="cstcpodglassesbillid" value="${cstcpodglassesbillid}" /> </TD>
                          <TD>${cstcpodcustomername} <input type="hidden" id="cstcposupplierid" name="cstcposupplierid" value="${cstcposupplierid}" /></TD>
                          <TD>${cstcpoddepartmentname}<input type="hidden" id="cstcpodbilltype" name="cstcpodbilltype" value="${cstcpodbilltype}" /></TD>
                           <TD>${cstcposuppliername}</TD>
                          <TD>
                          <c:if test="${cstcpodbilltype==2}">
                             		   框镜订做片
                          </c:if>
                          <c:if test="${cstcpodbilltype==4}">
                              		  隐形订做片
                          </c:if>
                          </TD>
                          <TD>${fn:substring(cstcpodsalesdatetime,0,16)}</TD>
                          <TD>${fn:substring(cstcpodarriveddate,0,16)}</TD>
						</TR>
						</s:iterator>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
