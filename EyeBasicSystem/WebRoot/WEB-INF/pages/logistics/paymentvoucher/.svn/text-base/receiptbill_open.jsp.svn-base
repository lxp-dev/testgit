<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>收款单管理</title>		
<script type="text/javascript">
	
   /**
    *  查询收款单详细信息
    */ 
	function detail(billID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selReceiptMentBillDetail.action?receiptMentBillID="+billID+"&moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("selReceiptMentBillDetail.action?receiptMentBillID="+billID+"&moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【收款单详细】";
	}

   /**
    *  重置
    */        
	function clean(){
	    $('#clear').find("input[clean=clean]").each(function(){
			$(this).val('');
		});
		$('#clear').find("select[clean=clean]").each(function(){
			$(this).val('');
		});
	}
	
   /**
    *  根据条件查询相关收款单
    */        
	function search(){
		receiptMentBillSelFrm.action = "selReceiptMentBillOpen.action";
		receiptMentBillSelFrm.submit();
		showLoadingBar();
	}

   $(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 

	
	/**
	 *  checkbox全选
	 */	
	function chkAll(){	
       var chks=document.all.chks;
       $('input[id=chk]').each(function(){ 
           $(this).attr("checked",chks.checked);
       }); 
       if(chks.checked){
         setValue();
       }else{
         setDelValue();
       }        
   }
   
	$(document).ready(function (){
		setCheckValue();
	});
	
	/**
	 *  初始化判断checkbox的状态
	 */
   function setCheckValue(){
       var chktext="";
       $("input[id=chk]",window.parent.document).each(function(){
			chktext=chktext+","+$(this).val();
		});

       $("input[id=chk]").each(function(){
        	if(chktext.indexOf($(this).attr("receiptMentBillID"))>=0){
             $(this).attr("checked","checked");
          }
		});
   }
	/**
	 *  调用单个页面赋值添加
	 */
   function setSingleValue(obj){
       var objValue="["+obj.value+"]";;
       if(obj.checked==true){
          window.parent.openGoodSingleValues(objValue);
       }else if(obj.checked==false){
          window.parent.openGoodSingleDeleteValues(objValue);
       }

   }
   
	/**
	 *  调用页面赋值删除
	 */
	function setDelValue(){ 	         

       var objValue="";
       var count=0;

       $("input[id=chk]").each(function(){
        	if($(this).attr("checked")==false){
          	 if(objValue==""){
	           objValue=$(this).val();
	         }else{
	           objValue=objValue+","+$(this).val();
	         }
	         count++;  
	         }  
		});
       
        if(count==0){
         alert('请选择商品!');
         return false;
       }
       objValue="["+objValue+"]";
       window.parent.openGoodSingleDeleteValues(objValue);
       
	}	
		
	/**
	 *  调用页面赋值
	 */
	function setValue(){
       var objValue="";
       var count=0;
       $("input[id=chk]").each(function(){
        	if($(this).attr("checked")==true){
          	 if(objValue==""){
	           objValue=$(this).val();
	         }else{
	           objValue=objValue+","+$(this).val();
	         }
	         count++;    
		     }
		});
        if(count==0){
         alert('请选择商品!');
         return false;
       }
       objValue="["+objValue+"]";
       window.parent.openGoodSingleValues(objValue);     
	}
	   
</script>
	</head>
	<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<DIV>
<form method="post" id="receiptMentBillSelFrm" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0 id="clear">
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR height="26px">
                          <TD width="9%" class="table_body">收款单号</TD>
                          <TD width="28%" class="table_none"><input clean=clean class="text_input160" id="receiptMentBillID" name="receiptMentBillID" type="text" value="${receiptMentBillID}" maxlength="30"></TD>
                          <TD width="9%" class="table_body">客户名称</TD>
                          <TD class="table_none" width="28%">
	                           ${franchiseeName }
	                           <input type="hidden" name="franchiseeID" value="${franchiseeID }" readonly="readonly">
	                           <input type="hidden" name="franchiseeName" value="${franchiseeName }" readonly="readonly">
                          </TD>
                          <TD width="9%" class="table_body" >审核状态</TD>
                           <TD class="table_none" width="24%">
						   <select clean=clean name="auditStatue">
                            <option value="">----请选择----</option>
                            <option value='0' ${auditStatue == '0' ? 'selected="selected"' : '' }>未审核</option>
                            <option value='1' ${auditStatue == '1' ? 'selected="selected"' : '' }>已审核</option>
                          </select>						   
                          </TD>
                        </TR>
                        <TR height="26px">
						  <TD class="table_body">制单日期</TD>
                          <TD class="table_none">
                         <li class="horizontal_onlyRight">
                           <input clean=clean id="billStartTime"
					       name="billStartTime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'billEndTime\')}'})"
					       value="${billStartTime }" /> 至 
					       <input clean=clean id="billEndTime"
					       name="billEndTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'billStartTime\')}'})" 
					        value="${billEndTime }" />
					        
					     </li><li class="horizontal_onlyRight">
                             <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('billStartTime','billEndTime')" >
                            </li>
					        
					      </TD>
                          <TD class="table_body">审核日期</TD>
                          <TD class="table_none">
                          <li class="horizontal_onlyRight">
                           <input clean=clean id="auditStartTime"
					       name="auditStartTime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'auditEndTime\')}'})"
					       value="${auditStartTime }" /> 至 
					       <input clean=clean id="auditEndTime"
					       name="auditEndTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'auditStartTime\')}'})" 
					        value="${auditEndTime }" />
					        
					      </li><li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('auditStartTime','auditEndTime')" >
                            </li>
					        
					         </TD>    
                          <TD class="table_body">制单人</TD>
                          <TD class="table_none">
                            <input clean=clean type="text" class="text_input160" id="createPersonID" name="createPersonID" value="${createPersonID}">
                          </TD> 
                        </TR>                    
                        </TBODY>
                    </TABLE>
					<table id="title2" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left">
							<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >			
							<img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >							
						  </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
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
                    <c:if test="${not empty(receiptMentBillList)}">
					 <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                     </TABLE>
					 <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TD width="3%"><input onclick="chkAll()" id="chks" type="checkbox">选择</TD>
                          <TH scope=col width="3%">操作</TH>
                          <TH scope=col width="15%" height="26">收款单号</TH>
                          <TH scope=col width="10%">客户名称</TH>
						  <TH scope=col width="12%">制单日期</TH>						
                          <TH scope=col width="8%">制单人</TH>
                          <TH scope=col width="12%">审核日期</TH>						  
						  <TH scope=col width="8%">审核人</TH>
						  <TH scope=col width="8%">已收款金额</TH>                         
                        </TR>
                      <s:iterator value="receiptMentBillList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><input id="chk" name="chk" type="checkbox" receiptMentBillID="${sLrbrbID}" onClick="setSingleValue(this);" value="{'payMentBillID':'${sLrbrbID}','payedMentDate':'${sLrbrbDate}','payedMentAmount':'${sLrbrbCurrentReceiptMentAmount}'}" ></TD>
                          <TD width="3%">
                             <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:detail('${sLrbrbID}')" >                             
		                  </TD>               
                          <TD>${sLrbrbID}</TD>
                          <TD>${sLrbrbFranchiseeName}</TD>
                          <TD>${sLrbrbDate}</TD>
                          <TD>${sLrbrbCreatePersonName}</TD>    
                          <TD>${sLrbrbAuditDate}</TD>
                          <TD>${sLrbrbAuditPersonName}</TD>
                          <TD>${sLrbrbCurrentReceiptMentAmount}</TD>
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
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></form></DIV></BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp"%>