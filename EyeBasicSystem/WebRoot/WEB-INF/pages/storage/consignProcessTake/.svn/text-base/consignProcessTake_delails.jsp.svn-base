<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/printBarcode.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx}/js/orderItem.js"></script>

<title>委外收货管理</title>
</head>
<script>
	
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
		
		if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2'){
			if((${systemParameterPo.fspstealtheffective} == '1' || ${systemParameterPo.fspstealtheffective} == '2') && ${consignProcessReceiptPo.cstcprgoodscategory}=='4'){
				var c10 = row.insertCell(9);
				var c11 = row.insertCell(10);
				var c12 = row.insertCell(11);

				var c13 = row.insertCell(12);
				var c14 = row.insertCell(13);
			}else{
			    var c13 = row.insertCell(9);
				var c14 = row.insertCell(10);
		    }
		}
		
		if(${systemParameterPo.fspbarcodetype}=='3'){
			var c13 = row.insertCell(9);
		}
		
		
		row.className = 'row';
		row.height="26";
		c1.height="26";
		c1.innerHTML = '<input id="chk" type="checkbox" value="'+goodInfo.bgigoodsid+'" >';
		c2.innerHTML = goodInfo.bgigoodsid;
        c3.innerHTML = goodInfo.bgigoodsname;
		c4.innerHTML = goodInfo.bgispec;
		c5.innerHTML = goodInfo.bgisph;		
		c6.innerHTML = goodInfo.bgicyl;				
		c7.innerHTML = goodInfo.bgiaxis;
		c8.innerHTML = goodInfo.bgicurvature1;
		c9.innerHTML = goodInfo.bgidia;
		
		if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2'){

			if((${systemParameterPo.fspstealtheffective} == '1' || ${systemParameterPo.fspstealtheffective} == '2') && ${consignProcessReceiptPo.cstcprgoodscategory}=='4'){
				c10.innerHTML = goodInfo.bgiguaranteeperiod;
				c11.innerHTML = goodInfo.bgibatch;
				c12.innerHTML = goodInfo.bgiregistrationnum;
			}
			
			c13.innerHTML = goodInfo.bgigoodsbarcode+'<input type="hidden" name="goodsInfoTempPo.pcbarcode" barcode=barcode value="'+goodInfo.bgigoodsbarcode+'"/>';
			c14.innerHTML = goodInfo.bgigoodsquantity + '<input type="hidden" name="goodsInfoTempPo.goodsquantity" value="'+goodInfo.bgigoodsquantity+'"/><input type="hidden" id="retailprice" name="retailprice" value="'+goodInfo.bgiretailprice+'"/>';
		}
		
		if(${systemParameterPo.fspbarcodetype}=='3'){
			c13.innerHTML = goodInfo.bgigoodsquantity + '<input type="hidden" name="goodsInfoTempPo.goodsquantity" value="'+goodInfo.bgigoodsquantity+'"/>';
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
    
	$(document).ready(function (){
	   	<c:forEach var="po" items="${consignProcessReceiptDetailsList}">
	   	addRow({'bgigoodsid':'${po.cstcprdgoodsid}',
	   			'bgigoodsbarcode':'${po.cstcprdbarcode}',
	   			'bgigoodsname':'${po.cstcprdgoodsname}',
	   			'bgicostprice':'${po.cstcprdcostprice}',
	   			'bgitaxrate':'${po.cstcprdtaxrate}',
				'bginottaxrate':'${po.cstcprdnottaxrate}',
				'bgispec':'${po.cstcprdspec}',
				'bgicolor':'${po.cstcprdcolor}',
				'bgisph':'${po.cstcprdsph}',
				'bgicyl':'${po.cstcprdcyl}',
				'bgiaxis':'${po.cstcprdaxis}',
				'bgicurvature1':'${po.cstcprdcurvature}',
				'bgidia':'${po.cstcprddia}',
				'bgigoodsquantity':'${po.cstcprdnum}',
				'bgiretailprice':'${po.cstcpretailprice}',
				'bgiguaranteeperiod':'${po.cstcpguaranteeperiod}',
				'bgibatch':'${po.cstcpbatch}',
				'bgiregistrationnum':'${po.cstcpregistrationnum}',				
				'cstcpodid':'${po.cstcprdorderdetailsid}'});
	   	</c:forEach>
	   	amount();
    });
    
    function amount(){
    	var goodsquantityTotal = 0;
		var goodsquantity = document.getElementsByName("goodsInfoTempPo.goodsquantity");
		
		for(i=0;i<goodsquantity.length;i++){
			if(goodsquantity[i].value == '') continue;
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(0);
		}
		
		document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
	}
	
    function batPrintGoodsBarCode(){
    	var flag = false;
		if(confirm("条码打印确认！")){
			var ids = document.getElementsByName("chk");
			
			if(ids !=0){
				var barCodes = $('input[barcode=barcode]');
				var retailprices = $("input[id=retailprice]");
				var barCode = new Array();
				var quantity = new Array();
				var retailprice = new Array();
				for(var i=0 ; i< barCodes.length; i++){
					if(ids[i].checked == true){
						barCode[barCode.length] = barCodes[i].value;
						quantity[quantity.length] = 1;
						retailprice[retailprice.length] = retailprices[i].value;
						flag = true;
					}
				}
				if(flag == false){
					alert("请钩选要打印的商品条码！");
				}else{
					var printtype = {"1":"${systemParameterPo.fspframebarcodetype}"
						 ,"2":"${systemParameterPo.fsppartsbarcodetype}"
						 ,"3":"${systemParameterPo.fspglassbarcodetype}"
						 ,"4":"${systemParameterPo.fspstealthbarcodetype}"
						 ,"5":"${systemParameterPo.fspsolutionbarcodetype}"
						 ,"6":"${systemParameterPo.fspsunglassesbarcodetype}"
						 ,"7":"${systemParameterPo.fspconsumebarcodetype}"
						 ,"8":"${systemParameterPo.fspoldglassesbarcodetype}"
						 ,"9":"${systemParameterPo.fspmetropiabarcodetype}"};
					try{
						printBarCode(barCode, quantity,'','','','',retailprice,'',printtype,'','');
					} catch(e) {
						alert("打印失败!请检查条码打印机是否正确连接!");
					}
				}
			}
		}
	}
    
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="consignProcessReceiptForm" method="post" action="">
<input type="hidden" name="consignProcessReceiptPo.cstcprsourcebillid" id="cstcprsourcebillid" value="${consignProcessReceiptPo.cstcprsourcebillid}" />
 
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD align="right" colspan="3">
               	<s:action name="getFittingTemplateTypeInfo" executeResult="true">
					<s:param name="actionTypeID">12</s:param>
               		<s:param name="actionImgUrl">${ctx}/img/newbtn/btn_print_0.png</s:param>
               		<s:param name="actionFinereportRequestString">&logincompanyid=${person.personcompanyid}&cstcpodglassesbillid=${consignProcessReceiptPo.cstcprreceiptbillid}</s:param>
               		<s:param name="actionReportingServiceRequestString"></s:param>
               		<s:param name="actionReportTitle">委外收货单打印</s:param>
               	</s:action>	          	
          </TD>
        </TR>
       </TBODY></TABLE>
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
                          <TD width="9%"  height="26"class="table_body">单据编号</TD>
                          <TD width="24%" class="table_none">&nbsp;${consignProcessReceiptPo.cstcprreceiptbillid}</TD>
                          <TD width="9%" class="table_body">配镜单号</TD>
                          <TD width="24%" class="table_none">&nbsp;${consignProcessReceiptPo.cstcprsalesid}</TD>
                          <TD width="9%" class="table_body" height="26">所属制造商</TD>
                          <TD class="table_none" >&nbsp;${consignProcessReceiptPo.cstcprsuppliername}</TD>
                        </TR>
                        <TR>
                          <TD class="table_body">收入仓位</TD>
                          <TD class="table_none" >&nbsp;${consignProcessReceiptPo.cstcprinstockname }</TD>
                          <TD class="table_body" height="26">订做类型</TD>
                          <TD class="table_none" >
	                          <c:choose>
	                          	<c:when test="${consignProcessReceiptPo.cstcprgoodscategory=='2'}">
	                          		&nbsp;框镜订做片
	                          	</c:when>
	                          	<c:when test="${consignProcessReceiptPo.cstcprgoodscategory=='4'}">
	                          		&nbsp;隐形订做片
	                          	</c:when>
	                          	<c:otherwise>
	                          		&nbsp;
	                          	</c:otherwise>
	                          </c:choose>
                          </TD>
                          <TD class="table_body">运单号</TD>
                          <TD class="table_none" >&nbsp;${consignProcessReceiptPo.cstcprwaybillid}</TD>
                        </TR>                        
                        <TR>
                          <TD class="table_body" height="26">审核人</TD>
                          <TD class="table_none" >&nbsp;${consignProcessReceiptPo.cstcprauditpersonname}</TD>
                          <TD class="table_body">审核日期</TD>
                          <TD class="table_none">&nbsp;${fn:substring(consignProcessReceiptPo.cstcprauditdate,0,16)}</TD>
						  <TD class="table_body" height="26">顾客姓名</TD>
                          <TD class="table_none" >&nbsp;${consignProcessReceiptPo.cstcprcustomername}【卡号：${consignProcessReceiptPo.cstcprcustomercardnumber}】</TD>
                        </TR>                       
                        <TR>
                          <TD class="table_body" height="26">销售门店</TD>
                          <TD class="table_none">${consignProcessReceiptPo.cstcprshopcodename}&nbsp;</TD>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" height="26" colSpan=3><label>
                          	&nbsp;${consignProcessReceiptPo.cstcprremark}
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                     <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
					<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
						  <img src="${ctx}/img/newbtn/btn_printbarcode_0.png" btn=btn title="打印条码" id="addGodos" onClick="javascript:batPrintGoodsBarCode();">
                         </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    </c:if>
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                        <TH width="8%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>
                          <TH width="13%" height="26" scope=col>商品代码</TH>
                          <TH width="18%" scope=col>商品名称</TH>
                          <TH width="10%" scope=col>型号</TH>                       
                          <TH width="7%" scope=col>球镜</TH>
                          <TH width="7%" scope=col>柱镜</TH>
                          <TH width="7%" scope=col>轴向</TH>
                          <TH width="7%" scope=col>曲率</TH>
                          <TH width="7%" scope=col>直径</TH>
                     <c:if test="${(systemParameterPo.fspbarcodetype == '1' || systemParameterPo.fspbarcodetype == '2') && (systemParameterPo.fspstealtheffective == '1' || systemParameterPo.fspstealtheffective == '2') && (consignProcessReceiptPo.cstcprgoodscategory == '4')}">
                          <TH width="7%" scope=col>效期</TH> 
                          <TH width="7%" scope=col>批号</TH> 
                          <TH width="7%" scope=col>注册证号</TH>  
                     </c:if>     
                     <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
                          <TH width="10%" scope=col>商品条码</TH> 
                     </c:if>
                          <TH width="5%" scope=col>数量</TH>                           
                        </TR>
                        <TR class=table_title align=middle>
                        <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                             <c:choose>
                                 <c:when test="${(systemParameterPo.fspstealtheffective == '1' || systemParameterPo.fspstealtheffective == '2') && (consignProcessReceiptPo.cstcprgoodscategory==4)}">
                                     <TH width="40%" height="26"  colSpan=13 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH> 
                                 </c:when>
                                 <c:otherwise>
                                     <TH width="40%" height="26"  colSpan=10 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
                                 </c:otherwise>
                             </c:choose>
						</c:if>
						<c:if test="${systemParameterPo.fspbarcodetype==3}"> 
                             <TH width="40%" height="26"  colSpan=9 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
						</c:if>
					    	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
				   		</TR>
                      </TBODY>
                    </TABLE>
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1>
             </TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>