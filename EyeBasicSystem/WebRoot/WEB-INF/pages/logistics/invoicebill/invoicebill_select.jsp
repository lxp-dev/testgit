<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>发票管理</title>		
<script type="text/javascript">

   /**
    *  重置
    */        
	function clean(){
	    $('input[clean=clean]').each(function(){
			$(this).val('');
		});
	}
	
   /**
    *  根据条件查询相关付款单
    */        
	function search(){
		invoiceSelFrm.action = "dealingBillByInvoiceOpenSel.action";
		invoiceSelFrm.submit();
		showLoadingBar();
	}
    
    $(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	    
	    setCheckValue();
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
	
	/**
	 *  初始化判断checkbox的状态
	 */
    function setCheckValue(){
        var chktext="";
        $("input[id=chk]",window.parent.document).each(function(){
			chktext=chktext+","+$(this).val();
		});

        $("input[id=chk]").each(function(){
         	if(chktext.indexOf($(this).attr("billID"))>=0){
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
           window.parent.openGoodSingleValues2(objValue);
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
<form method="post" id="invoiceSelFrm" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR height="30px">
                          <TD width="8%" class="table_body">单据编号</TD>
                          <TD width="26%" class="table_none"><input clean="clean" class="text_input160" id="billID" name="billID" type="text" value="${billID}" maxlength="30"></TD>
                          <TD width="10%" class="table_body">制造商</TD>
                          <TD class="table_none" width="30%">
                            ${supplierName}
                            <input type="hidden" id="supplierName" name="supplierName" class="text_input160" readonly="readonly" value="${supplierName}">
                            <input type="hidden" id="supplierID" name="supplierID" class="text_input160" readonly="readonly" value="${supplierID}">

                          </TD>
                        </TR>
                        <TR height="30px">
						  <TD class="table_body">制单日期</TD>
                          <TD class="table_none">
                          <li class="horizontal_onlyRight">
                           <input id="createBgnDate"
					       name="createBgnDate" clean="clean" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'createEndDate\')}'})"
					       value="${createBgnDate }" /> 至 
					       <input id="createEndDate"
					       name="createEndDate" clean="clean" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'createBgnDate\')}'})" 
					        value="${createEndDate }" />
					        
					      </li><li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('createBgnDate','createEndDate')"></li>
                           <li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_month_0.png" title="当月" onClick="currtMonth('createBgnDate','createEndDate')"></li> 
					      </TD>
                          <TD class="table_body">结算日期</TD>
                          <TD class="table_none">
                          <li class="horizontal_onlyRight">
                           <input id="auditBgnDate"
					       name="auditBgnDate" clean="clean" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'auditEndDate\')}'})"
					       value="${auditBgnDate }" /> 至 
					       <input id="auditEndDate"
					       name="auditEndDate" clean="clean" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'auditBgnDate\')}'})" 
					        value="${auditEndDate }" />  
					      </li><li class="horizontal_onlyRight">
                           <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('auditBgnDate','auditEndDate')"></li>
                          <li class="horizontal_onlyRight">
                           <img btn=btn src="${ctx }/img/newbtn/btn_month_0.png" title="当月" onClick="currtMonth('auditBgnDate','auditEndDate')"></li>      
                           </TD>
                        </TR>
                     <!-- 
                        <TR height="30px">
                          <TD width="8%" class="table_body">单据类型</TD>
                          <TD width="26%" class="table_none" colspan="5">
                             <c:if test="${typeid eq ''}">
	                              <select id="billType" name="billType" >
	                                  <option value="1" ${billType eq '1' ? 'selected="selected"' : '' }>采购收货</option>
	                                  <option value="2" ${billType eq '1' ? 'selected="selected"' : '' }>采购退货</option>                                  
	                              </select>
                             </c:if>
                             <c:if test="${typeid ne ''}">
                                  <c:if test="${typeid eq '1'}">采购收货</c:if>
                                  <c:if test="${typeid eq '2'}">采购退货</c:if>
                                  <input type="hidden" id="billType" name="billType" readonly="readonly" value="${billType}">
                             </c:if>
                             <input type="hidden" id="typeid" name="typeid" readonly="readonly" value="${typeid}">
                          </TD>                         
                        </TR> 
                      -->                         
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
                    <c:if test="${not empty(invoiceEntryList)}">
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
                          <TH scope=col width="5%" height="26"><input type="checkbox" id="chks" name="chks" onclick="chkAll()">选择</TH>
                          <TH scope=col width="15%" >单据编号</TH>
                          <TH scope=col width="16%">单据类型</TH>
						  <TH scope=col width="16%">结算日期</TH>
						  <TH scope=col width="8%">成本合计</TH>
						  <TH scope=col width="8%">税额合计</TH>
						  <TH scope=col width="8%">价税合计</TH>
                        </TR>
                      <s:iterator value="invoiceEntryList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">
						       <input type="checkbox" id="chk" name="chk" billID="${lieiebillid}" onClick="setSingleValue(this);"  value="{'billid':'${lieiebillid}','billdate':'${invoiceDate}','billcb':'${lieienottaxrateamount}','billse':'${lieietaxamount}','billjs':'${lieiecostpriceamount}','billtypeid':'${cstiebilltypeid eq '2' ? '采购退货单' : '采购收货单'}'}" />
						  </TD>
                          <TD>${lieiebillid}</TD>
                          <TD>
                              <c:if test="${cstiebilltypeid eq '2'}">采购退货单</c:if>
                              <c:if test="${cstiebilltypeid ne '2'}">采购收货单</c:if>
                          </TD>
                          <TD>${invoiceDate}</TD>
                          <TD>${lieienottaxrateamount}</TD>
                          <TD>${lieietaxamount}</TD>
                          <TD>${lieiecostpriceamount}</TD>
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
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
					   <TR>
						  <TD align="left"></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
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