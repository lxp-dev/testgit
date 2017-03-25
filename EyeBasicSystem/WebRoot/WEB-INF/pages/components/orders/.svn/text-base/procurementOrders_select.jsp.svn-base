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
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	goodsForm.action=link;
	  	goodsForm.submit();
		showLoadingBar();
	}
	function search(){
		if(checkForm(document.all.goodsForm)){  
			$("img").removeAttr("onclick");
			goodsForm.action = "openProcurementOrders.action";
			goodsForm.submit();
			showLoadingBar();
		}
	}	
	function search2(){
		if(event.keyCode==13){
		 if(checkForm(document.all.goodsForm)){  
				goodsForm.action = "openProcurementOrders.action";
				goodsForm.submit();
				showLoadingBar();
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
        if(checkForm(document.all.goodsForm)){         
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
        var poID=document.all.poID.value;
		var id = $('input[id=supplierID]').val();
		var name = $('input[id=supplierName]').val();
        window.parent.openProcurementOrdersValues(objValue,poID,id,name);
        alert('您选择的商品信息已添加到商品列表中！');
  }      
	}

	/**
	 *  调用页面赋值
	 */
	function setValue(){ 
        if(checkForm(document.all.goodsForm)){         
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
        var poID=document.all.poID.value;
		var id = $('input[id=supplierID]').val();
		var name = $('input[id=supplierName]').val();
        window.parent.openProcurementOrdersValues(objValue,poID,id,name);
        alert('您选择的商品信息已添加到商品列表中！');
  }      
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
    /**
	 * 订单开窗
	 */
	function openPo(){
	    var poType=document.all.poType.value;
	    var supplierID=document.all.supplierID.value;

		//showPopWin("","initProcurementOrdersForOpen.action?supplierID="+supplierID+"&poType="+poType,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initProcurementOrdersForOpen.action?supplierID="+supplierID+"&poType="+poType,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initProcurementOrdersForOpen.action?supplierID="+supplierID+"&poType="+poType,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【订单查询】";
	}
	
	function openPoValues(poID,id,name){
	    document.all.poID.value=poID; 
	    $('#supplierID').val(id);
	    $('td[id=supplierName]').val(name);
		$('input[id=supplierName]').val(name);
	  	goodsForm.action = "openProcurementOrders.action";
		goodsForm.submit();
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
    <TD><br/>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx }/img/pic/tab_bg.gif>
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
						   <TD width="60" height="26" class="table_body">订单编号</TD>
			               <TD class="table_none" width="40%">
			               <li class="horizontal_onlyRight">
                            <input class="text_input200" type="text"  id="poID" name="poID" value="${requestScope.poID}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '订单编号不能为空！'}]" onkeydown="search2()">
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openPo();" >
						  
						  </li>
			               
			               </TD>
			               <TD width="10%" height="26" class="table_body">所属制造商</TD>
			               <TD class="table_none" width="40%" id="supplierName">${requestScope.supplierName}
                            <input type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID }" />
                            <input type="hidden" id="supplierName" name="supplierName" value="${requestScope.supplierName}" />
			               </TD>
			               
                        </TR>
                      </TBODY>
                    </table>
                    <table id="searchBar" cellspacing="2">
						<tr height="10">
							<td>
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
								<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="setValue();" >
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
                          <TH width="8%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                        
                          <TH width="15%" scope=col>商品代码</TH>
                          <TH width="15%" scope=col>商品名称</TH>
                          <TH width="5%" scope=col>单位</TH>
                          <TH width="8%" scope=col>零售价格</TH>
                          <TH width="8%" scope=col>型号</TH>
                          <TH width="5%" scope=col>颜色</TH>                          
                          <TH width="6%" scope=col>球镜</TH>
                          <TH width="6%" scope=col>柱镜</TH>
                          <TH width="6%" scope=col>轴向</TH>
                          <TH width="6%" scope=col>曲率</TH>
                          <TH width="6%" scope=col>直径</TH>   
                          <TH width="6%" scope=col>采购数量</TH>                                                                                                                                

						  </TR>
						<s:iterator value="goodsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">                         
                          <TD height="26">
                          <input type="checkbox" id="chk" 
                           value="{'bgigoodsid':'${bgigoodsid}','bgigoodsbarcode':'${bgigoodsbarcode}','bgigoodsname':'${bgigoodsname}','bgiunitname':'${bgiunitname}','bgicostprice':'${bgicostprice}','bgiretailprice':'${bgiretailprice}','bgitaxrate':'${bgitaxrate}',
                           'bginottaxrate':'${bginottaxrate}','bgispec':'${bgispec}','bgicolor':'${bgicolor}','bgisph':'${bgisph}','bgicyl':'${bgicyl}','bgiaxis':'${bgiaxis}','bgicurvature1':'${bgicurvature1}','bgidia':'${bgidia}','bgigoodsquantity':'${bgigoodsquantity}','bgipcbarcode':'${bgipcbarcode }'}">
                          </TD>
                          <TD>${bgigoodsid}</TD>
                          <TD>${bgigoodsname}</TD>
                          <TD>${bgiunitname}</TD>
                          <TD>${bgiretailprice}</TD>
                          <TD>${bgispec}</TD>
                          <TD>${bgicolor}</TD>                          
                          <TD>${bgisph}</TD>
                          <TD>${bgicyl}</TD>
                          <TD>${bgiaxis}</TD>
                          <TD>${bgicurvature1}</TD>
                          <TD>${bgidia}</TD> 
                          <TD>${bgigoodsquantity}</TD>                       
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
