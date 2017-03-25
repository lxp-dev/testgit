<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发票管理</title>
</head>
<script>   	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	selectBill.action=link;
	  	selectBill.submit();
		showLoadingBar();
	}
	
	function search(){
		// document.all.submitButton.disabled="true";
		selectBill.action = "invoiceSelectGoods.action";
		selectBill.submit();
		showLoadingBar();
	}

	function clean(){
	    $('#clear').find("input").each(function(){
			$(this).val('');
		});
		$('#clear').find("select").each(function(){
			$(this).val('');
		});	
	}	
	
	function toFixAndNan(obj){
		obj.value=obj.value.replace('，',',');
	}
	
	$(document).ready(function(){
		$("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	    
		 <s:iterator value="inventoryEntryList" status="idx">
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
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
		
		// 商品id去重
		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == '${cstieid}')  return;
		}
		
		row.className = 'row';
	        
        c1.height="26";
        c1.innerHTML = '<input type="checkbox" id="chk" name="chk" onClick="setSingleValue(this);" cstieid=${cstieid} value="{\'cstieid\':\'${cstieid}\',\'cstiebillid\':\'${cstiebillid}\','
                          + '\'cstiegoodsid\':\'${cstiegoodsid}\',\'cstiegoodsname\':\'${cstiegoodsname}\',\'cstiespec\':\'${cstiespec}\','
                          + '\'cstiegoodsquantity\':\'${cstiegoodsquantity}\',\'cstiecheckgoodsquantity\':\'${cstiecheckgoodsquantity}\',\'cstienottaxrate\':\'${cstienottaxrate}\',\'cstienottaxrateamount\':\'${cstienottaxrateamount}\','
                          + '\'cstiegoodsid\':\'${cstiegoodsid}\',\'cstiegoodsname\':\'${cstiegoodsname}\',\'cstiespec\':\'${cstiespec}\','
                          + '\'cstietaxrate\':\'${cstietaxrate}\',\'cstiecostprice\':\'${cstiecostprice}\',\'cstietaxamount\':\'${cstietaxamount}\',\'cstiebilltypeid\':\'${cstiebilltypeid}\','
                          + '\'cstiecostpriceamount\':\'${cstiecostpriceamount}\' }" /><input type="hidden" name="invoiceEntryPo.lieieid" value="${cstieid}" /><input name="invoiceEntryPo.cstiebilltypeid" type="hidden" value="${cstiebilltypeid}">';
                
        c2.innerHTML = '${cstiebillid}'+ '<input type="hidden" name="invoiceEntryPo.lieiebillid" value="${cstiebillid}" />';
        c3.innerHTML = '${cstiegoodsid}'+ '<input type="hidden" name="invoiceEntryPo.lieiegoodsid" value="${cstiegoodsid}" />';
		c4.innerHTML = '${cstiegoodsname}'+ '<input type="hidden" name="invoiceEntryPo.lieiegoodsname" value="${cstiegoodsname}" />';
		c5.innerHTML = '${cstiespec}'+ '<input type="hidden" name="invoiceEntryPo.lieiespec" value="${cstiespec}" />';
		c6.innerHTML = '${cstiegoodsquantity}'+ '<input type="hidden" name="invoiceEntryPo.lieiegoodsquantity" value="${cstiegoodsquantity}" />';
		c6.id="td1";
		c7.id="td2";		
		c9.id="td3";
		c12.id="td4";
		c13.id="td5";
		c7.innerHTML = '${cstiecheckgoodsquantity}';	
		c8.innerHTML = '${cstienottaxrate}';		
		c9.innerHTML =  '${cstienottaxrateamount}';	
		c10.innerHTML = '${cstietaxrate}';	
		c11.innerHTML = '${cstiecostprice}';		
		c12.innerHTML = '${cstietaxamount}';
		c13.innerHTML = '${cstiecostpriceamount}';		
		
		$('#del' + index).btn().init();
		 </s:iterator>
		 
		 amount();

		$('#td3t').each(function(){
			$(this).text(parseFloat($(this).text()).toFixed(2));
		});
		
		$("#btn1").checked = true;
	});	
	
	function amount(){
		for(var i=1;i<=2;i++){
			var total=0;
			$('td[id=td'+i+']').each(function(){
				if($(this).text()==''){
					total=accAdd(total,$(this).find("input").val());
				}else{
					total=accAdd(total,$(this).text());
				}
			});
			$('#td'+i+'t').text(total);
		}
		for(i=3;i<=5;i++){
			var total=0;
			$('td[id=td'+i+']').each(function(){
				if($(this).text()==''){
					total=parseFloat(accAdd(total,$(this).find("input").val())).toFixed(2);
				}else{
					total=parseFloat(accAdd(total,$(this).text())).toFixed(2);
				}
			});
			$('#td'+i+'t').text(parseFloat(total).toFixed(2));
		}
	}
	
	function deleteItem(){
	    if($('.row').size()==0){
			alert('请选择要删除的单据!');
			return;
		}
		$('input[name=chk]:checked').each(function(){
			$(this).parent().parent().remove();		
		});
		document.all.chks.checked = false;
		amount();
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
         	if(chktext.indexOf($(this).attr("cstieid"))>=0){
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
        window.parent.openGoodSingleValues2(objValue);     
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="selectBill" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input class="text_input200" type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}">
<input class="text_input200" type="hidden" id="invoiceType" name="invoiceType" value="${requestScope.invoiceType}">
<input class="text_input200" type="hidden" id="supplierName" name="supplierName" value="${requestScope.supplierName}">
<DIV>
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
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0 id="clear">
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="8%" height="26" class="table_body" align="center">单据编号</TD>
			               <TD class="table_none" width="20%" >
                            <input class="text_input160" type="text" id="billid" name="billid" value="${requestScope.billID}">

                          <TD width="8%" height="26" class="table_body" align="center">制造商简称</TD>
			               <TD class="table_none" width="20%" colspan="5">
                            ${requestScope.supplierName}
			               </TD>
                        </TR>
                                           
                      </TBODY>
                    </TABLE> 
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>							
								<img btn=btn src="${ctx}/img/newbtn/btn_search_0.png" title='查询' onClick="javascript:search()">
								<img btn=btn src="${ctx}/img/newbtn/btn_empty_0.png" title="清空" onClick="clean()">
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
				<c:if test="${not empty(inventoryEntryList)}">	
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
					  <table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                        <TR height="26" class=table_title align="center" >
                          <TH width="7%" align="center" ><li class="horizontal_onlyRight"><input onclick="chkAll()" id="chks" type="checkbox"></li><li class="horizontal_onlyRight">选择</li></TH>
                          <TH scope=col width="11%" >单据号</TH>
                          <TH width="12%" scope=col>商品代码</TH>
                          <TH width="13%" scope=col>商品名称</TH>
                          <TH scope=col width="6%">型号</TH>
                          <TH scope=col width="4%">数量</TH>
                          <TH scope=col width="5%">核销数量</TH>
                          <TH scope=col width="7%">单位成本</TH>
						  <TH scope=col width="8%">成本合计</TH>
                          <TH scope=col width="6%">税率(%)</TH>
						  <TH scope=col width="6%">含税单价</TH>
                          <TH scope=col width="8%">税额合计</TH>
						  <TH scope=col width="12%">价税合计</TH>
                        </TR>
                        <TR class="table_title" align=middle height="26" >
						  <TD>合计：</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
                          <TD><div align="center" id="td1t"></div></TD>
                          <TD><div align="center" id="td2t"></div></TD>
                          <TD>&nbsp;</TD>
                          <TD><div align="center" id="td3t"></div></TD>
                          <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
                          <TD><div align="center" id="td4t"></div></TD>
                          <TD><div align="center" id="td5t"></div></TD>
                          </TR>
                      </table>
                    <div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
					</div>
                      </c:if>
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