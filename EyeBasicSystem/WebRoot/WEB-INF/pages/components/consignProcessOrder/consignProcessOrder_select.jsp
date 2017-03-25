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
	}
	function search(){
		if(checkForm(document.all.goodsForm)){  
			$("img").removeAttr("onclick");
			goodsForm.action = "openConsignProcessReceipt.action";
			goodsForm.submit();
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

        window.parent.openConsignProcessReceiptValues(objValue,poID);
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
	    var supplierID=document.all.supplierID.value;

		showPopWin("","initConsignProcessReceiptForOpen.action?supplierID="+supplierID,screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	function openPoValues(poID){
	  document.all.poID.value=poID; 
	  	goodsForm.action = "openConsignProcessReceipt.action";
		goodsForm.submit();
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>选择商品</TD>
            <TD class=menubar_readme_text vAlign=bottom>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
			</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：按委外订单添加商品</TD>
            <TD class=menubar_function_text align=right>&nbsp;</TD>
          </TR>
          <TR>
            <TD colSpan=2 height=5></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">按委外订单添加商品</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
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
						   <TD width="60" height="30" class="table_body">订单编号</TD>
			               <TD class="table_none" width="40%">
			               <li class="horizontal_onlyRight">
                            <input class="text_input200" type="text"  id="poID" name="poID" value="${requestScope.poID}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '订单编号不能为空！'}]">
						   </li>
						   <li class="horizontal_onlyRight">
						  <INPUT icon="icon-zoom" type=button value="选 择"  onClick="openPo();"></li>
			               
			               </TD>
			               <TD width="10%" height="30" class="table_body">所属制造商</TD>
			               <TD class="table_none" width="40%">${requestScope.supplierName}
                            <input type="hidden" name="supplierID" value="${requestScope.supplierID }" />
                            <input type="hidden" name="supplierName" value="${requestScope.supplierName}" />
			               </TD>
			               
                        </TR>
                      </TBODY>
                    </table>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<input id="submitButton" icon='icon-search' type='button' value='查询' onClick="javascript:search()">
								<input icon='icon-retry' type='button' value="清空" onClick="clean()">
								<input icon="icon-apply" type='button' value='选择' onClick="setValue();">
							</td>
						</tr>
					</table>
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
                          <TH width="8%" height="30" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                        
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
                          <TH width="6%" scope=col>委外数量</TH>                                                

						  </TR>
						<s:iterator value="goodsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">                         
                          <TD height="28">
                          <input type="checkbox" id="chk" 
                           value="{'bgigoodsid':'${bgigoodsid}','bgigoodsbarcode':'${bgigoodsbarcode}','bgigoodsname':'${bgigoodsname}','bgiunitname':'${bgiunitname}','bgicostprice':'${bgicostprice}','bgiretailprice':'${bgiretailprice}','bgitaxrate':'${bgitaxrate}',
                           'bginottaxrate':'${bginottaxrate}','bgispec':'${bgispec}','bgicolor':'${bgicolor}','bgisph':'${bgisph}','bgicyl':'${bgicyl}','bgiaxis':'${bgiaxis}','bgicurvature1':'${bgicurvature1}','bgidia':'${bgidia}',
                           'bgigoodsquantity':'${bgigoodsquantity}','cstcpodid':'${cstcpodid }'}">
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
