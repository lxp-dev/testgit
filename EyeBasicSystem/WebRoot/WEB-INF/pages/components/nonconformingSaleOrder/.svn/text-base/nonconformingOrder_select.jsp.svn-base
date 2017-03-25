<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择商品</title>
</head>
<script>	

	function search(){
		if(checkForm(document.all.goodsForm)){ 
		$("img").removeAttr("onclick"); 
			goodsForm.action = "selectWindowNonformingOrder.action";
			goodsForm.submit();
			showLoadingBar();
		}
	}
	
	function keysearch(){
		if(event.keyCode==13){
			if(checkForm(document.all.goodsForm)){  
				goodsForm.action = "selectWindowNonformingOrder.action";
				goodsForm.submit();
			}
		}
	}
	
	function clean(){
		document.getElementById('poID').value = "";
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
          alert('请选择商品!');
          return false;
        }
        objValue="["+objValue+"]";
        window.parent.openGoodSingleValues1(objValue);
       parent.hidePopWin();
        
	}

	/**
	 *  调用单个页面赋值添加
	 */
    function setSingleValue(obj){
        var objValue="["+obj.value+"]";
        if(obj.checked==true){
           window.parent.openGoodSingleValues1(objValue);
        }else if(obj.checked==false){
           window.parent.openGoodSingleDeleteValues(objValue);
        }

    }

	
	
	
	/**
	 *  checkbox全选
	 */	
	function chkAll1(){
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        for(var i=0;i<chk.length;i++){
           chk[i].checked = chks.checked;
        }
    }


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
	 * 订单开窗
	 */
	function openPo(){
	    var cshandepartmentid=document.all.cshandepartmentid.value;
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initWindowNonformingSaleOrderSel.action?cshandepartmentid=" + cshandepartmentid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initWindowNonformingSaleOrderSel.action?cshandepartmentid=" + cshandepartmentid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【配镜单查询】";

		//showPopWin("","initWindowNonformingSaleOrderSel.action?cshandepartmentid=" + cshandepartmentid,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
	}
	function openPoValues(poID){
	  document.all.poID.value=poID; 
	  	goodsForm.action = "selectWindowNonformingOrder.action";
		goodsForm.submit();
	}
	
	function selectContact(obj){
		if(event.keyCode==13){
			search();
		}
	}
	
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } onkeyup="selectContact(this)">
<form name="goodsForm" method="post" action="">

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="cshandepartmentid" value="${requestScope.cshandepartmentid }" />


<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          
          <TR>
            <TD colspan="3"><br/></TD>
	        </TD>
          </TR>
        </TBODY>
      </TABLE>
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
			               <TD class="table_none" width="90%" colspan="3">
			               <li class="horizontal_onlyRight">
                            <input class="text_input200" type="text"  id="poID" name="poID" onkeydown="keysearch()" value="${requestScope.ssesbsalesid}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '配镜单号不能为空！'}]">
						   </li>
						   <li class="horizontal_onlyRight">
						   <img id="del" src="${ctx }/img/newbtn/btn_search_0.png"  btn=btn title="查询" onClick="javascript:openPo();">
						  </li>
                        </TR>
                      </TBODY>
                    </table>
                    <table id="searchBar" cellspacing="2">
						<tr height="10">
							<td>
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
								<!-- <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="setValue();" > -->
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
								document.getElementById("searchBar").style.display="none";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<c:if test="${not empty(getSaleList)}"> 
					<table id="info" width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
						<tr>
							<td width="10%" height="26" class="table_body">顾客姓名</td>
							<td class="table_none" width="23%">${salesBasicPo.ssesbpersonName}</td>
							<td width="10%" height="26" class="table_body">顾客电话</td>
							<td class="table_none" width="23%">${salesBasicPo.ssesbphone}</td>
							<td width="10%" height="26" class="table_body">顾客地址</td>
							<td class="table_none" width="24%">${salesBasicPo.ssesbaddress}</td>
						</tr>
						<tr>
							<td width="10%" height="26" class="table_body">销售门店</td>
							<td class="table_none" width="23%">${salesBasicPo.ssesbshopName}</td>
							<td width="10%" height="26" class="table_body">销售人员</td>
							<td class="table_none" width="23%">${salesBasicPo.ssesbsalerName}</td>
							<td width="10%" height="26" class="table_body">应收金额</td>
							<td class="table_none" width="24%">${salesBasicPo.ssesbsalesvalue}</td>
						</tr>
						<tr>
							<td width="10%" height="26" class="table_body">取镜日期</td>
							<td class="table_none" width="23%">${fn:substring(salesBasicPo.ssesbtakeglassdata,0,10)}</td>
							<td width="10%" height="26" class="table_body">销售日期</td>
							<td class="table_none" width="47%" colspan="3" >${fn:substring(salesBasicPo.ssesbsalesdatetime,0,10)}</td>
						</tr>
					</table>
					<br>
					</c:if>
					<c:if test="${not empty(getSaleList)}"> 
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
                          <TH width="8%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                        
                          <TH width="20%" scope=col>商品代码</TH>
                           <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                          <TH width="20%" scope=col>商品条码</TH>
                          </c:if>
                          <TH width="30%" scope=col>商品名称</TH>
                          <TH width="6%" scope=col>商品标识</TH>                        
                          <TH width="6%" scope=col>销售数量</TH>                                                                                                                               

						  </TR>
						<s:iterator value="getSaleList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">                         
                          <TD height="26">
                          <c:if test="${((systemParameterPo.fspbarcodetype == '1' || systemParameterPo.fspbarcodetype == '2') && ssesditemid != '') || systemParameterPo.fspbarcodetype == '3'}"> 
	                          <input type="checkbox" id="chk" name="chk" onClick="setSingleValue(this);"
	                           value="{'bgigoodsid':'${ssesdsalesitemid}','bgigoodsbarcode':'${ssesditemid}','bgigoodsname':'${ssesdsalesitemname}','bsalesid':'${requestScope.ssesbsalesid}','bsdetailsid':'${requestScope.ssesdid}','bgigoodsNum':'${ssesdnumber}'}">
                          </c:if>
                          </TD>
                          <input type="hidden" name="ssesdcommoditiesflag" value="${ssesdcommoditiesflag}">
                          <TD>${ssesdsalesitemid}</TD>
                           <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                         	 <TD>${ssesditemid}</TD>
                          </c:if>
                          <TD>${ssesdsalesitemname}</TD>
                          <TD>${ssesdglassflag}</TD>                        
                          <TD>${ssesdnumber}</TD>                       
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
