<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/js/orderItem.js" ></script>
<script type="text/javascript" src="${ctx}/js/priceCount.js" ></script>
<title>不合格品单管理</title>
</head>

<script>	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

		amount();
	});

	function save(){
		if(checkForm(document.all.nonconformingForm)){ 
			var table = document.getElementById('addTable');
			var index = table.rows.length-1;
			
			var goodsquantityArray = document.getElementsByName("nonconformingEntryArrayPo.cshanegoodsid");
			var goodsquantityCount=0;
			for(i=0;i<goodsquantityArray.length;i++){
				goodsquantityCount++;
			}
			if(goodsquantityArray==null||goodsquantityArray.length==0){
	          alert('请选择商品!');
	          return false;
	        }
	        
	        if(confirm('您确定要如此处理此不合格品单吗?')){
	        	document.all.submitButton.disabled="true";
				nonconformingForm.action = "doNonconforming.action";
				nonconformingForm.submit();
	        }
		}
	}
 
    function showSubMenu(goodsid,obj) {  
    	if(obj==""){
    		$('#' + goodsid).load("getAjaxDate.action?id="+ goodsid);
    	}else{  
    		$('#' + goodsid).load("getAjaxDate.action?id="+ goodsid +"&fnpid="+obj);
    	}
    }

	function amount(){
		var total=0;
		$('input[name=nonconformingEntryArrayPo\\.cshanesgoodsquantity]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#goodsquantityTotal').text(total);
    }
    
</script>

<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="nonconformingForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <tr height="20"><td></td></tr>
  <TR>
    <TD><!-- ?? Start -->
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
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="9%" height="26" class="table_body">单据编号</TD>
			               <TD class="table_none" width="24%">${nonconformingPo.cshanbillid}<input type="hidden" name="nonconformingPo.cshanbillid" value="${nonconformingPo.cshanbillid}" /></TD>
			               <TD width="9%" height="26" class="table_body">单据日期</TD>
			               <TD width="24%" class="table_none">${fn:substring(nonconformingPo.cshancreatedate,0,10)}
			               <input type="hidden" name="nonconformingPo.cshancreatedate" value="${nonconformingPo.cshancreatedate }">
			               </TD>
			               <TD width="9%" height="26" class="table_body">申报部门</TD>
			               <TD class="table_none">                             
			               ${nonconformingPo.cshandepartmentname}<input type="hidden" name="nonconformingPo.cshandepartmentid" value="${nonconformingPo.cshandepartmentid}"/>
			               <input type="hidden" name="nonconformingPo.cshanoutstockid" value="${nonconformingPo.cshanoutstockid}"/>
			               </TD>
			               </TR>
			               <tr>
			                <TD width="10%" height="26" class="table_body">制单人</TD>
			                <TD class="table_none" colspan="5">${nonconformingPo.cshancreatepersonname }
			                <input type="hidden" name="nonconformingPo.cshancreateperson" value="${nonconformingPo.cshancreateperson }">
			                <input type="hidden" name="nonconformingPo.cshanauditperson" value="${nonconformingPo.cshanauditperson }">
			                </TD>
                           </TR>                        
                      </TBODY>
                    </TABLE>
   
                    <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </TABLE>
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                        <TR class=table_title align=middle>                     
                         
                          <TH scope=col width="10%" height="26">商品代码</TH>
						  <TH scope=col width="15%">商品名称</TH>						
                          <TH scope=col width="30%" colSpan=2>不合格品原因</TH>                          
 						  <TH scope=col width="25%">备注</TH>
 						  <TH scope=col width="10%">
 						  		<c:if test="${nonconformingPo.cshanwhichretail == '1' || empty(nonconformingPo.cshanwhichretail)}">
 						  			标准零售价
								</c:if>
								<c:if test="${nonconformingPo.cshanwhichretail=='2' }">
									零售价1
								</c:if>
								<c:if test="${nonconformingPo.cshanwhichretail=='3' }">
									零售价2
								</c:if>
								<c:if test="${nonconformingPo.cshanwhichretail=='4' }">
									零售价3
								</c:if>
								<c:if test="${nonconformingPo.cshanwhichretail=='5' }">
									零售价4
								</c:if>
								<c:if test="${nonconformingPo.cshanwhichretail=='6' }">
									零售价5
								</c:if>
								<c:if test="${nonconformingPo.cshanwhichretail=='7' }">
									零售价6
								</c:if>
								<c:if test="${nonconformingPo.cshanwhichretail=='8' }">
									零售价7
								</c:if>
								<c:if test="${nonconformingPo.cshanwhichretail=='9' }">
									零售价8
								</c:if>
								<c:if test="${nonconformingPo.cshanwhichretail=='10' }">
									零售价9
								</c:if>
 						  </TH>
 						  <TH scope=col width="10%">数量</TH>		
 						  <TH scope=col width="10%">处理方式</TH>	
                        </TR>
                        <TR class=table_title align=middle>                     
                          <TH height="26" colspan="6" align="right">合计：</TH>
 						  <TH scope=col width="7%" id="goodsquantityTotal">0</TH>
 						  <TH></TH>	
                        </TR>
                       <s:iterator value="nonconformingEntryList" status="idx">
                        <TR class="row">
                       
                        <TD height="26">${cshanegoodsid}<input type="hidden" name="nonconformingEntryArrayPo.cshanegoodsid" value="${cshanegoodsid}" />
                            <input type="hidden" name="nonconformingEntryArrayPo.cshanebarcode" value="${cshanebarcode}" />
                        	<input type="hidden" name="nonconformingEntryArrayPo.cshanesalesdetailid" value="${cshanesalesdetailid}"/>
                        
                        </TD>
                        <TD>${cshanegoodsname}<input type="hidden" name="nonconformingEntryArrayPo.cshanegoodsname" value="${cshanegoodsname}" /></TD>
                      
                        <TD>                          
						<select name="nonconformingEntryArrayPo.cshanereasons1" onchange="showSubMenu('${cshanebarcode}',this.options[this.options.selectedIndex].value)" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择所属原因！'}]">
						<option value="">请选择所属原因</option>
				 		<c:if test="${not empty(nonconformingProductMaxList)}">
				    	  <s:iterator value="nonconformingProductMaxList">
				           <OPTION value="${fnpid}" ${cshanereasons1!= fnpid ? '' : 'selected="selected"' } >${fnpcontent}</OPTION>
				          </s:iterator>				         
				        </c:if>
				        </select>
						</TD>
                        <TD>
						<select id="${cshanebarcode}" name="nonconformingEntryArrayPo.cshanereasons2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择所属现象！'}]">
				           <option value="">请选择所属现象(0)</option>
				           <OPTION value="${cshanereasons2}" selected>${cshanereasons2name}</OPTION>
				        </select>
						</TD>                        
                        <TD><input type="text" style="width:100%" name="nonconformingEntryArrayPo.cshaneremark" value="${cshaneremark}"/></TD>
                        <TD>${cshaneretailprice}</TD>
                        <TD>
                            ${cshanegoodsquantity}<input type="hidden" class="text_input60 number" name="nonconformingEntryArrayPo.cshanesgoodsquantity" value="${cshanegoodsquantity}" validate="[{'Type' : Type.String, 'Formula' : Formula.ZINT, 'Message' : '请重新填写数量！'}]" maxlength="10" onBlur="amount();"/>
                        </TD>
                        
                        <td>
                        <select id="cshaneconsignmode" name="nonconformingEntryArrayPo.cshaneconsignmode" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '处置方式不能为空！'}]">
      		                 	<option value="0" ${cshaneconsignmode == '0' ? 'selected="selected"' : '' }>报残</option>
      		                 	<option value="1" ${cshaneconsignmode == '1' ? 'selected="selected"' : '' }>退回</option>
      	                 </select></td>
                        </TR>
                       </s:iterator>
                       
				   	</TABLE>
                    
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                     <TR>
						
                        </TR>  
					   <TR>
						  <TD align="left">
						  	<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">
						  </TD>
                        </TR>                     
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