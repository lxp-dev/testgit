<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>外批送货管理</title>
</head>
<script>
$(document).ready(function() {
	$("img[btn=btn]").attr("style","cursor: hand");
	$("img[btn=btn]").mouseover(function () {
    	$(this).attr("src",$(this).attr("src").replace("0","1"));
	}).mouseout(function () {
		$(this).attr("src",$(this).attr("src").replace("1","0"));
	});
});

	function save(){
	if(checkForm(document.all.consignProcessDeliverForm)){ 
		var table = document.getElementById('addTable');
		var index = table.rows.length-1;
		//判断商品数量是否为空	
		var goodsquantityArray = document.getElementsByName("consignProcessOrderDetailsTempPo.cstcpodnum");
		var goodsquantityCount=0;
		for(i=0;i<goodsquantityArray.length;i++){
			if(goodsquantityArray[i].value=="0"){
				alert("商品数量不能为0！");
				goodsquantityArray[i].focus();
				return;	
			}
			goodsquantityCount++;
		}
		if(goodsquantityCount==0){
          alert('请选择商品!');
          return false;
        }
        
		$("img").removeAttr("onclick");
		consignProcessDeliverForm.action = "updateConsignProcessDeliver.action";
		consignProcessDeliverForm.submit();
		}
	}

	function openConsignProcessOrders(){	
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsForConsignProcessReceiptOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsForConsignProcessReceiptOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【按委外收货单添加商品】";
	}	
    
	function openConsignProcessOrdersValues(objValue){
		
		var goodInfos = eval('(' + objValue + ')');
		
		for(i = 0; i < goodInfos.length; i++){
			addRow(goodInfos[i]);			
		}
		amount();
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
		var c12 = row.insertCell(11);
		var c13 = row.insertCell(12);
		var c14 = row.insertCell(13);
		var c15 = row.insertCell(14);
		row.className = 'row';
		row.height="26";
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.cstcpodid + '" >';
        c2.innerHTML = goodInfo.cstcpodglassesbillid + '<input type="hidden" name="consignProcessOrderDetailsTempPo.cstcpodglassesbillid" value="' + goodInfo.cstcpodglassesbillid+'" /><input type="hidden" name="consignProcessOrderDetailsTempPo.cstcprdreceiptbilld" value="' + goodInfo.cstcprdreceiptbilld +'" /><input type="hidden" name="consignProcessOrderDetailsTempPo.cstcpodgoodsid" value="' + goodInfo.cstcpodgoodsid +'" /><input type="hidden" name="consignProcessOrderDetailsTempPo.cstcpodgoodsbarcode" value="' + goodInfo.cstcpodgoodsbarcode +'" /><input type="hidden" name="consignProcessOrderDetailsTempPo.cstcpodnum" value="' + goodInfo.cstcpodnum +'" /><input type="hidden" name="consignProcessOrderDetailsTempPo.cstcpodid" value="' + goodInfo.cstcpodid +'" />';
        c3.innerHTML = goodInfo.cstcpodcustomername;
		c4.innerHTML = goodInfo.cstcpodgoodsname;
		c5.innerHTML = goodInfo.cstcpodglassflag;
		c6.innerHTML = goodInfo.cstcpodballglass;		
		c7.innerHTML = goodInfo.cstcpodpostglass;				
		c8.innerHTML = goodInfo.cstcpodaxes;
		c9.innerHTML = goodInfo.cstcpodadd;
		c10.innerHTML = goodInfo.cstcpodarriseglass;
		c11.innerHTML = goodInfo.cstcpodbasis;
		c12.innerHTML = goodInfo.cstcpodeyecurvature;				
		c13.innerHTML = goodInfo.cstcpoddiameter;
		c14.innerHTML = goodInfo.cstcpodrequirement;
		c15.innerHTML = goodInfo.cstcpodnum;

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

	//子页面删除单行
	function openGoodSingleDeleteValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			deleterow(goodInfos[i]);			
		}		
		amount();
	}

    function deleterow(goodInfo){
        
    	// 商品id去重
		var table = document.getElementById('addTable');
		
		$("input[id=chk]").each(function(){
         	if($(this).val()== goodInfo.cstcpodid){
			   $(this).parent().parent().remove();	
           }
		});
		amount();
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
		var goodsquantity = document.getElementsByName("consignProcessOrderDetailsTempPo.cstcpodnum");

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
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="consignProcessDeliverForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
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
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center class="privateBorder"
                  border=0>
                      <TBODY>
                        <TR>
                          <TD width="9%" class="table_body" height="26">单据编号</TD>
                          <TD width="24%" class="table_none">${deliverPo.cstddeliverbillid}<input type="hidden" id="cstddeliverbillid" name="deliverPo.cstddeliverbillid" value="${deliverPo.cstddeliverbillid}"></TD>
                         
						  <TD width="9%" class="table_body">单据日期</TD>
                          <TD width="24%" class="table_none">
						  ${fn:substring(deliverPo.cstddeliverdate,0,10)}
                          <input class="text_input200" name="deliverPo.cstddeliverdate" type="hidden" value="${fn:substring(deliverPo.cstddeliverdate,0,10)}"/>
						  </TD>
                          <TD width="9%" class="table_body" height="26">制单人</TD>
                          <TD class="table_none" >
                          ${deliverPo.cstdcreatepersonname}<input type="hidden" name="deliverPo.cstdcreateperson" value="${deliverPo.cstdcreateperson}">
                          </TD>				       
						</TR>
						<tr>
							<TD class="table_body">送货单位</TD>
                          	<TD class="table_none" colspan="5">${deliverPo.cstddeliverdept}<input type="hidden" id="cstddeliverdept" name="deliverPo.cstddeliverdept" value="${deliverPo.cstddeliverdept}"></TD>
						</tr>
                        <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=5><label>
                          <textarea id="textarea" name="deliverPo.cstdremark" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [51]}, 'Message' : '备注不能大于50字！'}]">${deliverPo.cstdremark}</textarea>
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
						  <img src="${ctx }/img/newbtn/btn_xzwwpjd_0.png" btn=btn title="选择委外配镜单"
					      onClick="javascript:openConsignProcessOrders();">
						  <img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title="删除" onClick="deleteitem();" >
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
                          <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                        
                          <TH width="15%" scope=col>配镜单号</TH>
                          <TH width="8%" scope=col>顾客名称</TH>
                          <TH width="20%" scope=col>商品名称</TH>
                          <TH width="3%" scope=col>R/L</TH>
                          <TH width="5%" scope=col>球镜</TH>
                          <TH width="5%" scope=col>柱镜</TH>
                          <TH width="3%" scope=col>轴向</TH>
                          <TH width="3%" scope=col>下加</TH> 
                          <TH width="3%" scope=col>棱镜</TH>
                          <TH width="3%" scope=col>基底</TH>
                          <TH width="3%" scope=col>曲率</TH>
                          <TH width="3%" scope=col>直径</TH> 
                          <TH width="16%" scope=col>特殊加工要求</TH>                            
                          <TH width="5%" scope=col>数量</TH>    
                      
                        </TR>
                    	<TR class=table_title align=middle> 
						  	<TH width="40%" height="26"  colSpan=14 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
				   		</TR>
				   		<s:iterator value="consignProcessOrderDetailsList" status="idx">
                        <TR class="row">
                        <TD height="26"><input id="chk" type="checkbox" value="${cstcpodid}" ></TD>
                        <TD>${cstcpodglassesbillid}
                        <input type="hidden" name="consignProcessOrderDetailsTempPo.cstcprdreceiptbilld" value="${cstcprdreceiptbilld}" />
                        <input type="hidden" name="consignProcessOrderDetailsTempPo.cstcpodid" value="${cstcpodid}" />
                        <input type="hidden" name="consignProcessOrderDetailsTempPo.cstcpodglassesbillid" value="${cstcpodglassesbillid}" />
                        <input type="hidden" name="consignProcessOrderDetailsTempPo.cstcpodgoodsid" value="${cstcpodgoodsid}" />
                        <input type="hidden" name="consignProcessOrderDetailsTempPo.cstcpodgoodsbarcode" value="${cstcpodgoodsbarcode}" />
                        <input type="hidden" name="consignProcessOrderDetailsTempPo.cstcpodnum" value="${cstcpodnum}" />
                        </TD>
                        <TD>${cstcpodcustomername}</TD>
                        <TD>${cstcpodgoodsname}</TD>
                        <TD>${cstcpodglassflag}</TD>                        
                        <TD>${cstcpodballglass}</TD>
                        <TD>${cstcpodpostglass}</TD>
                        <TD>${cstcpodaxes}</TD>
                        <TD>${cstcpodadd}</TD>
                        <TD>${cstcpodarriseglass}</TD>
                        <TD>${cstcpodbasis}</TD>
                        <TD>${cstcpodeyecurvature}</TD>
                        <TD>${cstcpoddiameter}</TD>
                        <TD>${cstcpodrequirement}</TD>                          
                        <TD>${cstcpodnum}</TD>    
                                                                                                                                                 
                        </TR>
                        </s:iterator>                        
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          <TD align="left">
                          	<li class="horizontal_onlyRight">
                          		<img id="savebtn" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn title='保存' onclick="save();">
                          	</li>
                          	<li class="horizontal_onlyRight">
                          		<input name="stateFlag" type="checkbox" value="1" value="保存并审核">保存并审核
                          	</li>
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