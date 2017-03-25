<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>发票管理</title>
</head>
<script>
    var isAuto = 1;
    function updateAuto(obj){
       isAuto = obj;
       if(obj==0){
       $(':input').removeAttr("readonly");
       $(':input').removeAttr("style");}
       if(obj==1){
        $('input[name=invoiceEntryPo.lieienottaxrateamount]').each(function(){
			$(this).attr({readonly:"readonly"});
			$(this).attr({style:"background-color:#ACA899"});
		});
		$('input[name=invoiceEntryPo.lieietaxamount]').each(function(){
			$(this).attr({readonly:"readonly"});
			$(this).attr({style:"background-color:#ACA899"});
		});	
		$('input[name=invoiceEntryPo.lieiecostpriceamount]').each(function(){
			$(this).attr({readonly:"readonly"});
			$(this).attr({style:"background-color:#ACA899"});
		});

       }

    }   
    
	function amount(){
		for(var i=1;i<=6;i++){
			var total=0;
			$('td[id=td'+i+']').each(function(){
				if($(this).text()==''){
					total=accAdd(total,$(this).find("input").val());
				}else{
					total=accAdd(total,$(this).text());
				}
			});
			$('#td'+i+'t').text(total.toFixed(2));
		}
	}

	/**
	 * 输入核销数量
	 */
	function shuliangCal(obj){		
		var jiashuiheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').attr("value");
		var chengbenheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').attr("value");
		var hexiaoshuliang=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecheckgoodsquantity]').attr("value");
		var weihexiaoshuliang=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiegoodsquantity]').attr("value");				
		if(parseFloat(hexiaoshuliang)>parseFloat(weihexiaoshuliang) || parseFloat(hexiaoshuliang)<=0 || hexiaoshuliang == '' || hexiaoshuliang == null){
			alert('核销数量输入有误!');
			$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecheckgoodsquantity]').val(weihexiaoshuliang);
			$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecheckgoodsquantity]').focus();
			return;
		}
				
		if (isAuto == 0){
			amount();	
		    return;
		}
		
		//反填单位成本
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrate]').val(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(2));
		$(obj).parent().parent().find('span[id=lieienottaxrate]').text(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(2));
			
		//反填含税单价
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').val(parseFloat(accDiv(jiashuiheji,hexiaoshuliang)).toFixed(2));
		
		amount();		
	}
		
	/**
	 * 输入成本合计
	 */
	function chengbenCal(obj){
		var chengbenheji = $(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').attr("value");
		var hexiaoshuliang = $(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecheckgoodsquantity]').attr("value");
		if (chengbenheji == '' || chengbenheji == null){
		    alert("成本合计数据有误!");
		    obj.focus();
		    var danweichengben = $(obj).parent().parent().find('span[id=lieienottaxrate]').text();//attr("value")
		    $(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').val(parseFloat(accMul(danweichengben,hexiaoshuliang)).toFixed(2));
		    return;	
		}		
		var cstietaxrate = $(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxrate]').attr("value");		
		
		if (isAuto == 0){
		    return;
		}
		
		//反填单位成本
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrate]').val(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(2));
		$(obj).parent().parent().find('span[id=lieienottaxrate]').text(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(2));
			
		//反填税额合计
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxamount]').val(parseFloat(accMul(chengbenheji,eval(cstietaxrate*0.01))).toFixed(2));
			
		//反填价税合计
		var shuieheji = $(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxamount]').val();			
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').val(parseFloat(accAdd(chengbenheji,shuieheji)).toFixed(2));
			
		//反填含税单价
		var jiashuiheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').attr("value");
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').val(parseFloat(accDiv(jiashuiheji,hexiaoshuliang)).toFixed(2));
		
		amount();
	}
			
	/**
	 * 输入税额合计
	 */
	function shuieCal(obj){		
		var hexiaoshuliang=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecheckgoodsquantity]').attr("value");
		var cstietaxrate=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxrate]').attr("value");
		var chengbenheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').attr("value");
		var shuieheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxamount]').attr("value");
		if(shuieheji == '' || shuieheji == null){
		    alert("税额合计数据有误!");
		    obj.focus();		    
		    $(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxamount]').val(parseFloat(accMul(chengbenheji,eval(cstietaxrate*0.01))).toFixed(2));
		    return;
		}		
		
		if (isAuto == 0){
		    return;
		}
		
		//反填成本合计		
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').val(parseFloat(accDiv(shuieheji,parseFloat(cstietaxrate*0.01))).toFixed(2));
		var chengbenheji2=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').attr("value");
		//反填单位成本		
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrate]').val(parseFloat(accDiv(chengbenheji2,hexiaoshuliang)).toFixed(2));
		$(obj).parent().parent().find('span[id=lieienottaxrate]').text(parseFloat(accDiv(chengbenheji2,hexiaoshuliang)).toFixed(2));		
						
		//反填价税合计					
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').val(parseFloat(accAdd(chengbenheji2,shuieheji)).toFixed(2));
			
		//反填含税单价
		var jiashuiheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').attr("value");
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').val(parseFloat(accDiv(jiashuiheji,hexiaoshuliang)).toFixed(2));
		
		amount();
	}
	
	/**
	 * 输入单位成本
	 */
	function danweiCal(obj){	
		//var jiashuiheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').attr("value");
		var hexiaoshuliang=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecheckgoodsquantity]').attr("value");
		var cstietaxrate=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxrate]').attr("value");	
		var danweichengben=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrate]').attr("value");
		//var hanshuidanjia=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').attr("value");
		if(cstietaxrate=="NaN")
		{
		  cstietaxrate=17;
		}	
		if(danweichengben == '' || danweichengben == null){
		    alert("单位成本数据有误!");
		    obj.focus();
		    //var danweichengben = $(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrate]').attr("value");	    
		    //$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').val(parseFloat(accMul(hexiaoshuliang,hanshuidanjia)).toFixed(2));
		    return;
		}	
		
		if (isAuto == 0){
		    return;
		}
		
		//反填成本合计		
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').val(parseFloat(accMul(danweichengben,hexiaoshuliang)).toFixed(2));		
		 var chengbenheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').attr("value");
		
		//价税合计
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').val(parseFloat(accMul(chengbenheji,1+parseFloat(cstietaxrate*0.01))).toFixed(2));
		
		//反填含税单价		
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').val(parseFloat(accMul(danweichengben,1+parseFloat(cstietaxrate*0.01))).toFixed(2));			

	    //反填税额合计
	   
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxamount]').val(parseFloat(accMul(chengbenheji,parseFloat(cstietaxrate*0.01))).toFixed(2));
		
		//反填单位成本
		//$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrate]').val(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(2));
		//$(obj).parent().parent().find('span[id=lieienottaxrate]').text(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(2));	
		amount();
	}
				
	/**
	 * 输入价税合计
	 */
	function jiashuiCal(obj){	
		var jiashuiheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').attr("value");
		var hexiaoshuliang=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecheckgoodsquantity]').attr("value");
		var cstietaxrate=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxrate]').attr("value");		
		if(jiashuiheji == '' || jiashuiheji == null){
		    alert("价税合计数据有误!");
		    obj.focus();
		    var hanshuidanjia = $(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').attr("value");	    
		    $(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').val(parseFloat(accMul(hexiaoshuliang,hanshuidanjia)).toFixed(2));
		    return;
		}	
		
		if (isAuto == 0){
		    return;
		}	
		
		//反填含税单价		
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').val(parseFloat(accDiv(jiashuiheji,hexiaoshuliang)).toFixed(2));			
		//反填成本合计		
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').val(parseFloat(accDiv(jiashuiheji,parseFloat(1+parseFloat(cstietaxrate*0.01)))).toFixed(2));	
		
	    //反填税额合计
	    var chengbenheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').attr("value");
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxamount]').val(parseFloat(accMul(chengbenheji,parseFloat(cstietaxrate*0.01))).toFixed(2));
		
		//反填单位成本
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrate]').val(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(2));
		$(obj).parent().parent().find('span[id=lieienottaxrate]').text(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(2));	
		
		amount();
	}
					
	/**
	 * 输入含税单价
	 */
	function hanshuiCal(obj){		
		var hexiaoshuliang=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecheckgoodsquantity]').attr("value");	
		var hanshuidanjia=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').attr("value");
		var cstietaxrate=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxrate]').attr("value");
		var jiashuiheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').attr("value");
	    if(hanshuidanjia == '' || hanshuidanjia == null){
		    alert("含税单价数据有误!");
		    obj.focus();		    
		    $(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').val(parseFloat(accDiv(jiashuiheji,hexiaoshuliang)).toFixed(2));
		    return;
		}	
	   	
	    if (isAuto == 0){
	    	
		    return;
		}
		
		//反填价税合计
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').val(parseFloat(accMul(hexiaoshuliang,hanshuidanjia)).toFixed(2));
		//反填成本合计
		var jiashuiheji2 = $(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').attr("value");	
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').val(parseFloat(accDiv(jiashuiheji2,parseFloat(1+parseFloat(cstietaxrate*0.01)))).toFixed(2));
			
	    //反填税额合计
	    var chengbenheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').attr("value");
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxamount]').val(parseFloat(accMul(chengbenheji,parseFloat(cstietaxrate *0.01))).toFixed(2));
		
		//反填单位成本
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrate]').val(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(2));
		$(obj).parent().parent().find('span[id=lieienottaxrate]').text(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(2));	
		 amount();
	}
	
	$(document).ready(function(){	
		$("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	     	 
		amount();
		
		$('span[id=lieienottaxrate]').each(function(){
			$(this).text(parseFloat($(this).text()).toFixed(2));
		});
		$('input[name=invoiceEntryPo.lieienottaxrateamount]').each(function(){
			$(this).val(parseFloat($(this).val()).toFixed(2));
		});	
		$('span[id=cstietaxrate]').each(function(){
			$(this).text(parseFloat($(this).text()).toFixed(0));
		});
		$('input[name=invoiceEntryPo.lieienottaxrate]').each(function(){
			$(this).val(parseFloat($(this).val()).toFixed(2));
		});		
		$('#td3t').each(function(){
			$(this).text(parseFloat($(this).text()).toFixed(2));
		});
		$(document).keydown(function(event){
            if(event.keyCode==118){ //F7
			    if (isAuto == 1){ //自动
			        $("#btn1").checked = false;
			        $("#btn0").checked = true;
			        isAuto = 0;
			    }else{
			        $("#btn0").checked = false;
			        $("#btn1").checked = true;
			        isAuto = 1;
			    }
		    }
        });
	});
	function save(){	
		if($('.row').size()==0){
			alert('请选择单据!');
			return;
		}
		if (vailAmount()){
			alert('金额填写有误,请重新填写!');
			return;
		}
		
		var auditState = document.getElementsByName("auditState");
	    if (auditState != null && auditState.length != 0){
		    if (!auditState[0].checked){
	            invoiceForm.action = "invoiceByBillUpdate.action?auditState=0";
	        }else{
	            invoiceForm.action = "invoiceByBillUpdate.action?auditState=1";
	        }
	    }else{
	        invoiceForm.action = "invoiceByBillUpdate.action?auditState=0";
	    }
		$("img").removeAttr("onclick");
		invoiceForm.submit();

	}
	
	function toFixAndNan(obj){
		obj.value=obj.value.replace(/[^0-9.][0-9]*/g,'');
		
	}
	function toFixAndNans(obj){
		obj.value=obj.value.replace(/[^0-9.][0-9]*/g,'');
		
		
	}
	function toFixAndNum(obj){
		obj.value=obj.value.replace(/[^0-9][0-9]*/g,'');
	}
	
	function toFix(obj){
		if(obj.value!=''){
			obj.value=parseFloat(obj.value).toFixed(2);
		}
	}
	//向下事件含税单价
	function hanshuiDown(thisnum){
		var x=0;
			$('td[id=td1]').each(function(){
					x=++x;
			});
		if(event.keyCode == 40){

			var i = thisnum.id.substr(14);
			i=++i;
			if(i>=x){
			}else{
			document.getElementById("lieiecostprice"+i).focus();
			document.getElementById("lieiecostprice"+i).select();	
			}
		}
	}
	//向下事件核销数量
	function chengbenDown(thisnum){
		var x=0;
			$('td[id=td1]').each(function(){
					x=++x;
			});
		if(event.keyCode == 40){

			var i = thisnum.id.substr(8);
			i=++i;
			if(i>=x){
			}else{
			document.getElementById("chengben"+i).focus();
			document.getElementById("chengben"+i).select();	
			}
		}
	}
	//向下事件成本合计
	function shuieDown(thisnum){

		if(event.keyCode == 40){

			var i = thisnum.id.substr(5);
			i=++i;
			document.getElementById("shuie"+i).focus();
			document.getElementById("shuie"+i).select();	
		}
	}
	//向下事件税额合计
	function jiashuiDown(thisnum){

		if(event.keyCode == 40){

			var i = thisnum.id.substr(7);
			i=++i;
			document.getElementById("jiashui"+i).focus();
			document.getElementById("jiashui"+i).select();	
		}
	}
		//向下事件单位成本
	function danweiDown(thisnum){
		var x=0;
			$('td[id=td1]').each(function(){
					x=++x;
			});
			

		if(event.keyCode == 40){
			
			var i = thisnum.id.substr(6);
			
			i=++i;
			if(i>=x){
			}else{
			document.getElementById("danwei"+i).focus();
			document.getElementById("danwei"+i).select();
			}
				
		}
	}
	//向下事件价税合计
	function hexiaoDown(thisnum){

		if(event.keyCode == 40){

			var i = thisnum.id.substr(6);
			i=++i;
			document.getElementById("hexiao"+i).focus();
			document.getElementById("hexiao"+i).select();	
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

    function vailAmount(){
        var scb = document.getElementsByName('invoiceEntryPo.lieiesourcenottaxrateamount');
        var sse = document.getElementsByName('invoiceEntryPo.lieiesourcetaxamount');
        var sjs = document.getElementsByName('invoiceEntryPo.lieiesourcecostpriceamount');
        var dcb = document.getElementsByName('invoiceEntryPo.lieienottaxrateamount');
        var dse = document.getElementsByName('invoiceEntryPo.lieietaxamount');
        var djs = document.getElementsByName('invoiceEntryPo.lieiecostpriceamount');

        for (var i = 0 ; i < scb.length ; i++){
            if ((Number(scb[i].value) < Number(dcb[i].value)) || (Number(sse[i].value) < Number(dse[i].value)) || (Number(sjs[i].value) < Number(djs[i].value))){
                return true;
            }
            if (Number(accAdd(Number(dcb[i].value),Number(dse[i].value))) != Number(djs[i].value)){
                return true;
            }
        }

        return false;
    }
    
</script>
<BODY bgColor=#ffffff topMargin=5  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<form name="invoiceForm" action="" method="post">
<input type="hidden" name="invoiceID" value="${invoicePo.liiid }"/>
<input type="hidden" name="billID" id="billID" value=""/>
<input type="hidden" name="supplierID" value="${invoicePo.liisupplierid}"/>
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
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
                        <TR height="26" >
                          <TD width="9%" class="table_body">发票号</TD>
                          <TD width="24%" class="table_none">${invoicePo.liiid }</TD>
                          <TD width="9%" class="table_body">制单日期</TD>
                          <TD width="24%" class="table_none">
                           ${fn:substring(invoicePo.liidate,0,10)}<input type="hidden" name="liidate" value="${invoicePo.liidate}" />
                          </TD>
                         <TD class="table_body" width="9%">制造商</TD>
			             <TD class="table_none" width="30%">
						   	<li class="horizontal_onlyRight">
							   ${invoicePo.liisuppliername}
							</li>
						 </TD>

                          </TR>
                        <TR height="26px">
                        <TD class="table_body" >制单部门</TD>
                          <TD class="table_none" >${invoicePo.liidepartmentname }</TD>
                          <TD class="table_body" >制单人</TD>
                          <TD class="table_none" >${invoicePo.liicreatepersonname}<input type="hidden" id="liicreatepersonid" name="liicreatepersonid" value="${invoicePo.liicreatepersonid}" /></TD>
                          <TD class="table_body">审核人</TD>
                          <TD class="table_none">${invoicePo.liiauditpersonName}</TD>
                          </TR>
                        <TR height="26px">
                          <TD class="table_body">审核日期</TD>
                          <TD class="table_none">${fn:substring(invoicePo.liiauditdate,0,10)}</TD>
                          <TD class="table_body">发票类型</TD>
                          <TD class="table_none" colspan="3">${invoicePo.liitypeName}<input type="hidden" name="liitypeID" value="${invoicePo.liitypeID}" /></TD>
                          </TR>
                        <TR height="62px">
                        	<TD class="table_body">备注</TD>
                            <TD class="table_none" colSpan=8>
                            <label>
                              <textarea name="remark" id="remark" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [2001]}, 'Message' : '备注不能大于2000字！'}]">${invoicePo.liiremark }</textarea>
                            </label>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                     <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>  
                          <TD align="left">
                            <img btn=btn src="${ctx }/img/newbtn/btn_delete_0.png" title="删除" onclick="deleteItem()" >
                          </TD>                        
                        </TR>
                        <TR>
                          <TD align="left" colspan="2">
                             <font color="red">发票审核后,退货单成本合计、税额合计、价税合计变为负值!</font>
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
                        <TH scope=col width="5%" height="26"><li class="horizontal_onlyRight"><input onclick="chkAll()" id="chks" type="checkbox"></li><li class="horizontal_onlyRight">选择</li></TH>
                          <TH scope=col width="14%" height="26">单据编号</TH>
						  <TH scope=col width="8%">单据成本合计</TH>
                          <TH scope=col width="8%">单据税额合计</TH>
						  <TH scope=col width="8%">单据价税合计</TH>
						  <TH scope=col width="8%">来票成本合计</TH>
                          <TH scope=col width="8%">来票税额合计</TH>
						  <TH scope=col width="8%">来票价税合计</TH>
                        </TR>
                        <TR class="table_title" align=middle height="26">
						  <TD align="right" colspan="2">合计：</TD>   
                          <TD><div align="center" id="td1t"></div></TD>
                          <TD><div align="center" id="td2t"></div></TD>
                          <TD><div align="center" id="td3t"></div></TD>
                          <TD><div align="center" id="td4t"></div></TD>
                          <TD><div align="center" id="td5t"></div></TD>
                          <TD><div align="center" id="td6t"></div></TD>
                        </TR>                       
                        <s:iterator value="invoiceEntryList" status="idx">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><input  id="chk" name="chk" type="checkbox" value="${lieiebillid}" ><input type="hidden" name="invoiceEntryPo.lieieid" value="${lieieid}" /></TD>
						  <TD height="26"><input type="hidden" name="invoiceEntryPo.lieiebillid" value="${lieiebillid}" />${lieiebillid }</TD>
						  <TD id="td1">${lieiesourcenottaxrateamount}<input type="hidden" name="invoiceEntryPo.lieiesourcenottaxrateamount" value="${lieiesourcenottaxrateamount }" class="text_input60" ></TD>
                          <TD id="td2">${lieiesourcetaxamount}<input type="hidden" name="invoiceEntryPo.lieiesourcetaxamount" value="${ lieiesourcetaxamount}" class="text_input60"></TD>
                          <TD id="td3">${lieiesourcecostpriceamount}<input type="hidden" name="invoiceEntryPo.lieiesourcecostpriceamount" value="${ lieiesourcecostpriceamount}" class="text_input60"></TD>
                          <TD id="td4"><input onkeyup="toFixAndNan(this);amount();" onblur="toFix(this);" type="text" name="invoiceEntryPo.lieienottaxrateamount" value="${lieienottaxrateamount }" id="chengben${idx.index}" class="text_input60" ></TD>
                          <TD id="td5"><input type="text" onblur="toFix(this);" name="invoiceEntryPo.lieietaxamount" onkeyup="toFixAndNan(this);amount();" value="${ lieietaxamount}" id="shuie${idx.index}" class="text_input60"></TD>
                          <TD id="td6"><input type="text" onblur="toFix(this);" name="invoiceEntryPo.lieiecostpriceamount" onkeyup="toFixAndNan(this);amount();" value="${ lieiecostpriceamount}" id="jiashui${idx.index}" class="text_input60"></TD>
                        </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
                     <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                        <TD align="left">
                          <li class="horizontal_onlyRight"><img btn=btn id="saveBtn" name="saveBtn" src="${ctx}/img/newbtn/btn_save_0.png" title='保存' onclick="save()"></li>
                          <li class="horizontal_onlyRight">
                          <c:if test="${permissionPo.keyf=='1'}"><input type="checkbox" id="auditState" name="auditState" value="1">保存并审核</c:if> </li>
                          </TD>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>