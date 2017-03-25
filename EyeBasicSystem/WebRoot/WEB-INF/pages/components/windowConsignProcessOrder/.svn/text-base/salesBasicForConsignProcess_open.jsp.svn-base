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
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 

	    window.parent.$("input[name=chk]").each(function (){
	    	for(var i=0; i<$("input[name=chk]").size(); i++){
				if($("input[name=chk]").eq(i).attr("bill") == $(this).attr("glassesbillid") && $("input[name=chk]").eq(i).attr("rl") == $(this).attr("cstcpodglassflag")){
					$("input[name=chk]").eq(i).attr("checked","checked");
				}
		    }
		});
	}); 
	function search(){
		$("img").removeAttr("onclick");
		goodsForm.action = "openSalesBasicForConsignProcess.action";
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
		$('#ssesbdragstype').val('');
	    	    	    	    	    	    
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}	

	/**
	 *  调用页面赋值
	 */
	function setValue(){        
        var chk=document.getElementsByName("chk");
        var objValue="";
        var count=0;
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
          return false;
        }
        objValue="["+objValue+"]";
        
        window.parent.openConsignProcessOrdersValues(objValue);
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

        var chk=document.getElementsByName("chk");
	    for(var i=0;i<chk.length;i++){
            if(!chk[i].checked){
          	  window.parent.$("input[name=chk][glassesbillid="+$("input[name=chk]").eq(i).attr("bill")+"][cstcpodglassflag="+$("input[name=chk]").eq(i).attr("rl")+"]").attr("checked","checked");
          	  window.parent.deleteitem();
            }
        }
        setValue();
    }
    
    function check(salesInfo)
    {	
	    var ss=	salesInfo.value.substring(25,44);
	    var objValue = "";
    	var chk=document.getElementsByName("chk");
	    for(var i=0;i<chk.length;i++){
           if(chk[i].value.substring(25,44)==ss){
              chk[i].checked = salesInfo.checked;
              if(!chk[i].checked){
            	  window.parent.$("input[name=chk][glassesbillid="+$("input[name=chk]").eq(i).attr("bill")+"][cstcpodglassflag="+$("input[name=chk]").eq(i).attr("rl")+"]").attr("checked","checked");
            	  window.parent.deleteitem();
            	  continue;
              }

              objValue="["+chk[i].value+"]";              
              window.parent.openConsignProcessOrdersValues(objValue);
           }           
        }
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
            <TD align="right" colspan="3"><br/>
            	 </TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
						   <TD width="9%" height="26" class="table_body">配镜单号</TD>
			               <TD class="table_none" width="24%">
                            <input class="text_input160" type="text"  id="salesID" name="salesID" value="${requestScope.salesID}">			               
			               </TD>
			               <TD width="9%" height="26" class="table_body">制造商</TD>
			               <TD class="table_none" width="24%">${requestScope.supplierName}
                            <input type="hidden" name="supplierID" value="${requestScope.supplierID }" />
                            <input type="hidden" name="supplierName" value="${requestScope.supplierName}" />
                            <input type="hidden" name="ordersType" value="${requestScope.ordersType}" />
			               </TD>
						   <TD width="9%" height="26" class="table_body">所属门店</TD>
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
			               <TD height="26" class="table_body">委外方式</TD>
			               <TD class="table_none" >
			               <select id="ssesbdragstype" name="ssesbdragstype">
                           	  <option value="">----请选择----</option>
                           	  <option value="1" ${requestScope.ssesbdragstype == '1' ? 'selected="selected"' : '' }>委外订单</option> 
                           	  <option value="2" ${requestScope.ssesbdragstype == '2' ? 'selected="selected"' : '' }>委外加工</option>   
                           	  </select>          
			               </TD>
                        </TR>
                      </TBODY>
                    </table>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn  title='查询' onclick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean()" >
								<%--<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" name=ctl00$PageBody$Button1 onClick="setValue();"> --%>
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
                          <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                        
                          <TH width="9%" scope=col>配镜单号</TH>
                          <TH width="5%" scope=col>顾客姓名</TH>
                          <TH width="7%" scope=col>配镜单类型</TH>
                          <TH width="6%" scope=col>取镜时间</TH>
                          <TH width="8%" scope=col>商品名称</TH>
                          <TH width="3%" scope=col>R/L</TH> 
                          <TH width="4%" scope=col>数量</TH>                                                   
                          <TH width="4%" scope=col>球镜</TH>
                          <TH width="4%" scope=col>柱镜</TH>
                          <TH width="4%" scope=col>轴向</TH>
                          <TH width="4%" scope=col>下加</TH>
                          <TH width="4%" scope=col>棱镜</TH> 
                          <TH width="4%" scope=col>基底</TH> 
                          <TH width="4%" scope=col>曲率</TH>
                          <TH width="4%" scope=col>直径</TH>
                          <TH width="4%" scope=col>瞳距(远)</TH>
                          <TH width="4%" scope=col>瞳距(近)</TH>   
                          <TH width="9%" scope=col>加工要求</TH> 
                          <TH width="9%" scope=col>特殊加工要求</TH>                                                                                                                                

						  </TR>
						<s:iterator value="goodsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">                         
                          <TD height="26">
                          <input type="checkbox" id="chk" name="chk" onclick="check(this)" bill="${cstcpodglassesbillid}" rl="${cstcpodglassflag}"
                           value="{'cstcpodglassesbillid':'${cstcpodglassesbillid}','cstcpodgoodsid':'${cstcpodgoodsid}','cstcpodcustomername':'${cstcpodcustomername}','cstcpodbilltype':'${cstcpodbilltype}',
                           'cstcpodarriveddate':'${fn:substring(cstcpodarriveddate,0,10)}','cstcpodgoodsname':'${cstcpodgoodsname}','cstcpodglassflag':'${cstcpodglassflag}',
                           'cstcpodnum':'${cstcpodnum}','cstcpodballglass':'${cstcpodballglass}','cstcpodpostglass':'${cstcpodpostglass}',
                           'cstcpodaxes':'${cstcpodaxes}','cstcpodadd':'${cstcpodadd}','cstcpodarriseglass':'${cstcpodarriseglass}',
                           'cstcpodbasis':'${cstcpodbasis}','cstcpodeyecurvature':'${cstcpodeyecurvature}','cstcpoddiameter':'${cstcpoddiameter}','cstcpodinter':'${cstcpodinter }','cstcpodinterdistance':'${cstcpodinterdistance}',
                           'cstcpodrequirement':'${cstcpodrequirement}','cstcpodrequirement1':'${cstcpodrequirement1}','cstcpodrequirement2':'${cstcpodrequirement2}','cstcpodcustomerid':'${cstcpodcustomerid}','cstcpodordertype':'N','cstcpoddragstype':'${cstcpoddragstype}','cstcpodsalesbillid':'','cstcpodsalesid':'${cstcpodsalesid}','cstcpodid':''}">
                          </TD>
                          <TD>${cstcpodglassesbillid}</TD>
                          <TD>${cstcpodcustomername}</TD>
                          <TD>
                          <c:if test="${cstcpodbilltype==2}">
                                框镜订做片
                          </c:if>
                          <c:if test="${cstcpodbilltype==4}">
                                隐形订做片
                          </c:if>
                          </TD>
                          <TD>${fn:substring(cstcpodarriveddate,0,10)}</TD>
                          <TD>${cstcpodgoodsname}</TD>
                          <TD>${cstcpodglassflag}</TD>                          
                          <TD>${cstcpodnum}</TD>
                          <TD>${cstcpodballglass}</TD>
                          <TD>${cstcpodpostglass}</TD>
                          <TD>${cstcpodaxes}</TD>
                          <TD>${cstcpodadd}</TD> 
                          <TD>${cstcpodarriseglass}</TD>    
                          <TD>${cstcpodbasis}</TD>
                          <TD>${cstcpodeyecurvature}</TD>
                          <TD>${cstcpoddiameter}</TD>
                          <TD>${cstcpodinter}</TD> 
                          <TD>${cstcpodinterdistance}</TD>  
                          <TD>${cstcpodrequirement}</TD>  
                          <td>${cstcpodrequirement1}</td>                
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
