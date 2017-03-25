<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>采购收货管理</title>
</head>
<script>
	
	function save(){
	if(checkForm(document.all.consignProcessWaitForm)){ 
		
		document.all.button1.disabled="true";
		consignProcessWaitForm.action = "updateConsignProcessWait.action";
		consignProcessWaitForm.submit();
		}
	}
		
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(i = 0; i < goodInfos.length; i++){
			addRow(goodInfos[i]);			
		}
	}
	
	function addRow(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
		// 商品id去重
		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.cstcpodid) return;
		}
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);
		var c8 = row.insertCell(7);
		var c9 = row.insertCell(8);
		var c10 = row.insertCell(9);
		var c11 = row.insertCell(10);
		row.className = 'row';
		row.height="28";
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.cstcpodid + '" goodsid="'+ goodInfo.bgigoodsid +'" ><input type="hidden" name="goodsInfoTempPo.cstcpodid" value="' + goodInfo.cstcpodid +'" />';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" name="goodsInfoTempPo.goodsbarcode" value="' + goodInfo.bgigoodsbarcode +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
		c4.innerHTML = goodInfo.bgispec;
		c5.innerHTML = goodInfo.bgicolor;
		c6.innerHTML = goodInfo.bgisph;		
		c7.innerHTML = goodInfo.bgicyl;				
		c8.innerHTML = goodInfo.bgiaxis;
		c9.innerHTML = goodInfo.bgicurvature1;
		c10.innerHTML = goodInfo.bgidia;
		c11.innerHTML = '<input type="text" class="text_input40" maxlength="18" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';

    }
    
	function openProcurementOrdersValues(objValue,poID){
		
		document.all.cstisourcebillid.value=poID;
		
		var goodInfos = eval('(' + objValue + ')');
		
		for(i = 0; i < goodInfos.length; i++){
			addRow2(goodInfos[i]);			
		}	
	
	}
	
	function addRow2(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
		// 商品id去重
		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.cstcpodid) return;
		}
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);
		var c8 = row.insertCell(7);
		var c9 = row.insertCell(8);
		var c10 = row.insertCell(9);
		var c11 = row.insertCell(10);
		row.className = 'row';
		row.height="28";
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.cstcpodid + '" goodsid="'+ goodInfo.bgigoodsid +'" ><input type="hidden" name="goodsInfoTempPo.cstcpodid" value="' + goodInfo.cstcpodid +'" />';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" name="goodsInfoTempPo.goodsbarcode" value="' + goodInfo.bgigoodsbarcode +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
		c4.innerHTML = goodInfo.bgispec;
		c5.innerHTML = goodInfo.bgicolor;
		c6.innerHTML = goodInfo.bgisph;		
		c7.innerHTML = goodInfo.bgicyl;				
		c8.innerHTML = goodInfo.bgiaxis;
		c9.innerHTML = goodInfo.bgicurvature1;
		c10.innerHTML = goodInfo.bgidia;
		c11.innerHTML = '<input type="text" class="text_input40" maxlength="18" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="' + goodInfo.bgigoodsquantity +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
		
    }          
    
    function deleteitem(){
    
    	
		var chk=document.getElementsByName("chk");
		var table = document.getElementById('addTable');
		for(i = 0; i < chk.length; i++){
			if (chk[i].checked ) {
				var curRow = chk[i].parentNode.parentNode;		
				table.deleteRow(curRow.rowIndex);
				i = -1;
			}
		}
		
		document.all.chks.checked = false;		
		amount();
    }
    /**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID='';

		//showPopWin("","selSupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
		
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('cstisupplierid').value = json.id;
		document.getElementById('cstisuppliername').value = json.value;
		
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
    
    function amount(){
    	var goodsquantityTotal = 0;
		var goodsquantity = document.getElementsByName("goodsInfoTempPo.goodsquantity");
		
		for(i=0;i<goodsquantity.length;i++){
			if(goodsquantity[i].value == '') continue;
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(0);
		}
		
		document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
	}
	
	window.onload = function(){
		amount();
	};
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="consignProcessWaitForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="cstcprsupplierid" id="cstcprsupplierid" value="${requestScope.cstcprsupplierid}" />
<input type="hidden" name="consignProcessReceiptPo.cstcprgoodscategory" id="cstcprgoodscategory" value="${requestScope.cstcpoordergoodscategory}" /> 
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>委外收货管理</TD>
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
          </TD></TR>
        <TR>
          <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：待委外收货订单转委外收货订单</TD>
                      <TD class=menubar_function_text align=right>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
			</TD></TR>
        <TR>
          <TD colSpan=2 height=5></TD></TR></TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">待委外收货修改</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>

					</TR></TBODY></TABLE></TD>
					
					</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
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
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center 
                  border=0>
                      <TBODY>
                        <TR>
                          <TD width="10%" class="table_body" height="30">委外收货单编号</TD>
                          <TD width="40%" class="table_none">
                          <input class="text_input200" id="cstcprreceiptbillid" name="cstcprreceiptbillid" value="${consignProcessReceiptPo.cstcprreceiptbillid}" readonly="readonly">
                          <input type="hidden" id="cstcprreceiptbillid" name="consignProcessReceiptPo.cstcprreceiptbillid" value="${consignProcessReceiptPo.cstcprreceiptbillid}">
                          </TD>
                          <TD width="10%" class="table_body">委外订单编号</TD>
                          <TD width="40%" class="table_none">
                          <input class="text_input200" id="prsourcebillid" name="prsourcebillid" value="${consignProcessReceiptPo.cstcprsourcebillid}" readonly="readonly">
                          <input type="hidden" name="consignProcessReceiptPo.cstcprsourcebillid" id="cstcprsourcebillid" value="${consignProcessReceiptPo.cstcprsourcebillid}" /> 
						  </TD>
                        </TR>
                        <TR>
                        
						  <TD width="10%" class="table_body" height="30">单据日期</TD>
                          <TD width="40%" class="table_none">
                          <jsp:useBean id="now" class="java.util.Date" />
                          <fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />
                          <input id="cstibilldate" name="inventoryPo.cstibilldate" type="hidden" value="<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />"/>
                          </TD>					       
                          <TD width="10%" class="table_body">入库类型</TD>
                               <TD width="40%" class="table_none">委外收货<input type="hidden" name="inventoryPo.cstibilltypeid" id="cstibilltypeid" value="9" />
                         			 <input type="hidden" name="cstibilltypeid" id="cstibilltypeid" value="${ConsignProcessOrderDetailsPo.cstcpobilltypeid}" /> 
						   		</TD>
						</TR>
						<TR>
                          <TD class="table_body" height="30">收入仓位</TD>
                          <TD class="table_none" >
                            <select id="cstcprinstockid" name="consignProcessReceiptPo.cstcprinstockid">
      		                 <s:iterator value="warehouselist">
				               <option value="${bwhid}" ${consignProcessReceiptPo.cstcprinstockid == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
                          </TD>
                          <TD class="table_body">制单人</TD>
                          <TD class="table_none" >${person.personName}</TD>

                        </TR>
                        <TR>
                        	<TD class="table_body"> 所属制造商 </TD>
                        	<TD class="table_none" colspan="3">
                        		${supplierPo.bspsuppliername}
						   		<input type="hidden" id="cstcprsupplierid" name="consignProcessReceiptPo.cstcprsupplierid" value="${supplierPo.bspid}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
                        	</TD>
                        </TR>
                        <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=3><label>
                          <textarea id="textarea" name="consignProcessReceiptPo.cstcprremark">${ConsignProcessOrderDetailsPo.cstcporemark}</textarea>
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
						  <input id="del" icon="icon-delete" type="button" value="删除" onClick="deleteitem();" >
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
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="8%" height="30" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                        
                          <TH width="15%" scope=col>商品代码</TH>
                          <TH width="15%" scope=col>商品名称</TH>
                          <TH width="8%" scope=col>型号</TH>
                          <TH width="6%" scope=col>颜色</TH>                          
                          <TH width="7%" scope=col>球镜</TH>
                          <TH width="7%" scope=col>柱镜</TH>
                          <TH width="7%" scope=col>轴向</TH>
                          <TH width="7%" scope=col>曲率</TH>
                          <TH width="7%" scope=col>直径</TH> 
                          <TH width="12%" scope=col>数量</TH>                           
                        </TR>
                        <TR class=table_title align=middle> 
						  	<TH width="40%" height="30"  colSpan=10 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
				   		</TR>
                        <c:forEach var="i" items="${consignProcessOrderDetailsList}" varStatus="index"> 
                        <TR class="row">
                        <TD height="28"><input id="chk" type="checkbox" value="${cstcpoorderbillid}" ></TD>
                        <TD>${i.cstcpodgoodsid}
                        <input type="hidden" name="goodsInfoTempPo.goodsid" value="${i.cstcpodgoodsid}" />
                        <input type="hidden" name="goodsInfoTempPo.goodsbarcode" value="${i.cstcpodgoodsbarcode}" />
                        <input type="hidden" name="goodsInfoTempPo.costprice" value="${i.cstcporetailprice}" />
                        <input type="hidden" name="goodsInfoTempPo.nottaxrate" value="${i.cstcponottaxrate}" />
                        <input type="hidden" name="goodsInfoTempPo.taxrate" value="${i.cstcpotaxrate}" />
                        </TD>
                        <TD>${i.cstcpodgoodsname}</TD>
                        <TD>${i.cstcpobgispec}</TD>
                        <TD>&nbsp;</TD>                        
                        <TD>${i.cstcpodballglass}</TD>
                        <TD>${i.cstcpodpostglass}</TD>
                        <TD>${i.cstcpodaxes}</TD>
                        <TD>${i.cstcpodeyecurvature}</TD>
                        <TD>${i.cstcpoddiameter}</TD>
                        <TD><input type="text" class="text_input40" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="${i.cstcpodnum}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品数量！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '商品数量应为整数！'}]"/></TD>                                                                        
                        </TR>
                        </c:forEach>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          <TD align="left"><input type="checkbox" id="cstcprauditstate" name="consignProcessReceiptPo.cstcprauditstate" value="1" >保存并审核
                           </TD>
					   </TR>
					   <TR>
						  <TD align="left"><input id="button1" icon='icon-save' type='button' value='保存' onclick="save()"></TD>
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