<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择商品</title>
<style type="text/css">
#１ {
	color: #F00;
}
#tabContent__1 div .privateBorder tbody .row td #１ {
	font-size: 14px;
}
#tabContent__1 div .privateBorder tbody .row td #１ {
	font-size: 18px;
}
.STYLE1 {	color: #FF0000;
	font-weight: bold;
}
</style>
</head>
<script>	

	function search(){
	    $("img").removeAttr("onclick");
		goodsForm.action = "selSetMealGoodsOpen.action";
		goodsForm.submit();
		showLoadingBar();
	}
	
	function clean(){
        $('input[clean=clean]').each(function(){
            $(this).val('');
        });
        $('select[clean=clean]').each(function(){
            $(this).val('');
        });	
	}	

    /**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID= document.all.goodscategoryID.value;
	    var goodscategorys = goodscategoryID.split('_');
	    if (goodscategorys[0] == '6'){
	        goodscategoryID = goodscategorys[1];
	    }else{
	        goodscategoryID = goodscategorys[0];
	    }
	    	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID+"&isclosed=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID+"&isclosed=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
	}
	
	/**
	 * 品种开窗
	 */
	function openBrand(){
		var goodscategoryID= document.all.goodscategoryID.value;
	    var goodscategorys = goodscategoryID.split('_');
	    if (goodscategorys[0] == '6'){
	        goodscategoryID = goodscategorys[1];
	    }else{
	        goodscategoryID = goodscategorys[0];
	    }	    
	    var supplierID=document.getElementById('supplierID').value;
	    if (supplierID == ''){
            alert('请先选择制造商!');
            return;
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value+"&isclosed=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value+"&isclosed=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
	}

	/*	
	* 单个添加商品
	*/
	function setValue(goods, goodsName, minCostPrice,maxCostPrice,brand,minCostPriceAmount,maxCostPriceAmount,supplier,iscustomize,brand,goodscategoryid,goodsclass){	
       var json = {'goods':goods,'goodsName':goodsName,'minCostPrice':minCostPrice,'maxCostPrice':maxCostPrice,'brand':brand,'minCostPriceAmount':minCostPriceAmount,'maxCostPriceAmount':maxCostPriceAmount
                  ,'supplier':supplier,'iscustomize':iscustomize,'bigClass':'','smallClass':'','goodsquantity':1,'goodscategoryid':goodscategoryid,'goodsclass':goodsclass};

 	   window.parent.openGoodsValue(json);
 	   parent.hidePopWin();
	}
	
	/*	
	* 批量添加商品
	*/
	function setSingleValue(obj,goods, goodsName, minCostPrice,maxCostPrice,brand,minCostPriceAmount,maxCostPriceAmount,supplier,iscustomize,brand,goodscategoryid,goodsclass){
        if(obj.checked==true){
		     var json = {'ssmsggoodscategory':goodscategoryid,'ssmsgiscustomize':iscustomize,
	     				'ssmsgsmallclass':'','ssmsgbigclass':'','ssmsggoodsname':goodsName,
	     				'ssmsgmincostPrice':minCostPrice,'ssmsgmaxcostPrice':maxCostPrice,	     				
	     				'ssmsggoodsquantity':1,
	     				'ssmsgfavorableflag':'','ssmsgretailPrice':'',
	     				'ssmsgspecialoffer':'','ssmsgexpensecredit':'',
	     				'ssmsgdiscountrate':'','ssmsgexpensespendup':'',
	     				'ssmsgexpensespendul':'','ssmsgbeginAmount':'','ssmsgendAmount':'',
	     				'ssmsggoodsclass':goodsclass,'ssmsggoodsid':goods,'ssmsgsupplier':supplier,'ssmsgbrand':brand
	     				};

			if ($('#goodsflag').val() == '1'){
	        	window.parent.updateRow(json);
			}

			if ($('#goodsflag').val() == '2'){
				window.parent.updateRow2(json);
			}

			if ($('#goodsflag').val() == '3'){
				window.parent.updateRow3(json);
			}
        	
        }else if(obj.checked==false){
			if ($('#goodsflag').val() == '1' || $('#goodsflag').val() == '3'){
				window.parent.$('input[name=salesGoodsArray.ssmsggoodsid][value='+goods+']').parent().parent().parent().parent().parent().parent().remove();
			}

			if ($('#goodsflag').val() == '2'){
				window.parent.$('input[name=creditGoodsArray.ssmsggoodsid][value='+goods+']').parent().parent().parent().parent().parent().parent().remove();
			}
        }
    }
	
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	    
	    if ('${queryType}' == ''){
		 	$('#suppliershow').hide();
		    $('#suppliershow2').hide();	
	    	$('#brandshow').hide();
			$('#brandName2').hide(); 
			$('#goodsID').hide();
	        $('#goodsName').hide();	        		
			$('#goodsID').val('');
	        $('#goodsName').val('');
	        $('#brandName').val('');
		    $('#brandID').val('');
		    $('#supplierName').val('');
		    $('#supplierID').val('');       
	    }	    
	    if ('${queryType}' == '1'){
		 	$('#suppliershow').show();
		    $('#suppliershow2').hide();	
	    	$('#brandshow').hide();
			$('#brandName2').hide();
						
			$('#goodsID').hide();
	        $('#goodsName').hide();	        		
			$('#goodsID').val('');
	        $('#goodsName').val('');
	        $('#brandName').val('');
		    $('#brandID').val('');     
	    }	    
	    if ('${queryType}' == '2'){
		 	$('#suppliershow').show();
		    $('#suppliershow2').hide();	
	    	$('#brandshow').show();
			$('#brandName2').show(); 
			$('#goodsID').hide();
	        $('#goodsName').hide();	        		
			$('#goodsID').val('');
	        $('#goodsName').val('');    
	    }

		if ($('#goodsflag').val() == '1' || $('#goodsflag').val() == '3'){
			setCheckValue();
		}

		if ($('#goodsflag').val() == '2'){
			setCheckValue2();
		}

    }); 
	
	function chageQueryType(obj){
	    if (obj.value == '1'){   //制造商
	    	$('#suppliershow').show();
	        $('#suppliershow2').hide();
	        $('#brandshow').hide();
		    $('#brandName2').hide();     
		    
		    $('#goodsID').val('');
	        $('#goodsName').val('');
	        $('#brandName').val('');
		    $('#brandID').val('');
		    $('#supplierName').val('');
		    $('#supplierID').val('');           
	    }
	    if (obj.value == '2'){   //品种
	    	$('#suppliershow').show();
	        $('#brandshow').show();
	        $('#brandName2').show();
	    	$('#suppliershow2').hide();
	    	
	    	$('#goodsID').val('');
	        $('#goodsName').val('');
	        $('#brandName').val('');
		    $('#brandID').val('');
		    $('#supplierName').val('');
		    $('#supplierID').val('');   
	    }
	    if (obj.value == '3'){   //商品
	        $('#suppliershow').show();
	        $('#suppliershow2').show();
	        $('#brandshow').show();
	        $('#brandName2').show();
	        $('#goodsID').show();
	        $('#goodsName').show();
	        	        
	        $('#goodsID').val('');
	        $('#goodsName').val('');
	        $('#brandName').val('');
		    $('#brandID').val('');
		    $('#supplierName').val('');
		    $('#supplierID').val(''); 
	    }
	    if (obj.value == ''){   
		    $('#suppliershow').hide();
		    $('#suppliershow2').hide();	
		    $('#brandshow').hide();
		    $('#brandName2').hide();
	        
	    	$('#goodsID').val('');
	        $('#goodsName').val('');
	        $('#brandName').val('');
		    $('#brandID').val('');
		    $('#supplierName').val('');
		    $('#supplierID').val(''); 		    
	    }
	}

	function setCheckValue(){
        $("input[id=chk]").each(function(){
        	  for(var i = 0; i < parent.$('input[name=salesGoodsArray.ssmsggoodsid]').size(); i++){
            	  if(parent.$('input[name=salesGoodsArray.ssmsggoodsid]').eq(i).val() == $(this).attr('goodsid')){
            		  $(this).attr("checked","checked");
                  }
           	  }
		});
    }

	function setCheckValue2(){
        $("input[id=chk]").each(function(){
        	  for(var i = 0; i < parent.$('input[name=creditGoodsArray.ssmsggoodsid]').size(); i++){
            	  if(parent.$('input[name=creditGoodsArray.ssmsggoodsid]').eq(i).val() == $(this).attr('goodsid')){
            		  $(this).attr("checked","checked");
                  }
           	  }
		});
    }

    function chkAll(){
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        for(var i=0;i < chk.length;i++){
           chk[i].checked = chks.checked;
        }

        if(chks.checked){
        	setAllValue();
        }else{
            setDelValue();
        }
        
    }

	function setAllValue(){ 
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
		var goodInfos = eval('(' + objValue + ')');
		
		for(goodsI = 0; goodsI < goodInfos.length; goodsI++){			
		     var json = {'ssmsggoodscategory':goodInfos[goodsI].goodscategoryid,'ssmsgiscustomize':goodInfos[goodsI].iscustomize,
	     				'ssmsgsmallclass':'','ssmsgbigclass':'','ssmsggoodsname':goodInfos[goodsI].goodsName,
	     				'ssmsgmincostPrice':goodInfos[goodsI].minCostPrice,'ssmsgmaxcostPrice':goodInfos[goodsI].maxCostPrice,	     				
	     				'ssmsggoodsquantity':1,
	     				'ssmsgfavorableflag':'','ssmsgretailPrice':'',
	     				'ssmsgspecialoffer':'','ssmsgexpensecredit':'',
	     				'ssmsgdiscountrate':'','ssmsgexpensespendup':'',
	     				'ssmsgexpensespendul':'','ssmsgbeginAmount':'','ssmsgendAmount':'',
	     				'ssmsggoodsclass':goodInfos[goodsI].goodsclass,'ssmsggoodsid':goodInfos[goodsI].goods,'ssmsgsupplier':goodInfos[goodsI].supplier,'ssmsgbrand':goodInfos[goodsI].brand
	     				};

			if ($('#goodsflag').val() == '1' || $('#goodsflag').val() == '3'){
			    window.parent.$('input[name=salesGoodsArray.ssmsggoodsid][value='+goodInfos[goodsI].goods+']').parent().parent().parent().parent().parent().parent().remove();
			}

			if ($('#goodsflag').val() == '2'){
				window.parent.$('input[name=creditGoodsArray.ssmsggoodsid][value='+goodInfos[goodsI].goods+']').parent().parent().parent().parent().parent().parent().remove();
			}
					
			if ($('#goodsflag').val() == '1'){
	        	window.parent.updateRow(json);
			}

			if ($('#goodsflag').val() == '2'){
				window.parent.updateRow2(json);
			}

			if ($('#goodsflag').val() == '3'){
				window.parent.updateRow3(json);
			}
		}
		
	}

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
		var goodInfos = eval('(' + objValue + ')');
		
		for(goodsI = 0; goodsI < goodInfos.length; goodsI++){

			if ($('#goodsflag').val() == '1' || $('#goodsflag').val() == '3'){
			   window.parent.$('input[name=salesGoodsArray.ssmsggoodsid][value='+goodInfos[goodsI].goods+']').parent().parent().parent().parent().parent().parent().remove();
			}

			if ($('#goodsflag').val() == '2'){
			   window.parent.$('input[name=creditGoodsArray.ssmsggoodsid][value='+goodInfos[goodsI].goods+']').parent().parent().parent().parent().parent().parent().remove();
			}
		}
        
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<c:if test="${goodsflag ne '1' && goodsflag ne '2' && goodsflag ne '3'}">
<input type="hidden" id="goodscategoryID" name="goodscategoryID" value="${goodscategoryID }" />
</c:if>
<input type="hidden" id="pertyvaluearray" name="pertyvaluearray" value="${pertyvaluearray }" />

<input type="hidden" id="jjcz" name="jjcz" value="${jjcz }" />
<input type="hidden" id="sphul" name="sphul" value="${sphul }" />
<input type="hidden" id="sphup" name="sphup" value="${sphup }" />
<input type="hidden" id="cylul" name="cylul" value="${cylul }" />
<input type="hidden" id="cylup" name="cylup" value="${cylup }" />
<input type="hidden" id="clfl" name="clfl" value="${clfl }" />
<input type="hidden" id="zsl" name="zsl" value="${zsl }" />
<input type="hidden" id="gdfl" name="gdfl" value="${gdfl }" />
<input type="hidden" id="gndl" name="gndl" value="${gndl }" />
<input type="hidden" id="sylx" name="sylx" value="${sylx }" />
<input type="hidden" id="pqlx" name="pqlx" value="${pqlx }" />
<input type="hidden" id="tyjgn" name="tyjgn" value="${tyjgn }" />
<input type="hidden" id="goodsflag" name="goodsflag" value="${goodsflag }" />
<input type="hidden" id="salestype" name="salestype" value="${salestype }" />

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD colspan="3" align="right">
            	<br/></TD>
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

                           <TD width="9%" height="26" class="table_body">查询方式</TD>
				           <TD width="24%" class="table_none">
	                            <select clean=clean id="queryType" name="queryType" onchange="chageQueryType(this)">
	      		                 <option value="" ${queryType eq '' ? 'selected="selected"' : '' }>----请选择----</option>
	      		                 <option value="1" ${queryType eq '1' ? 'selected="selected"' : '' }>制造商</option>	                             
	                             <option value="2" ${queryType eq '2' ? 'selected="selected"' : '' }>品种</option>
	                             <option value="3" ${queryType eq '3' ? 'selected="selected"' : '' }>商品</option>	                             
	      	                   </select>&nbsp;<span class="STYLE1">* 默认为按商品查询</span>
	      	                </TD> 
	      	               <TD width="9%" height="26" class="table_body">商品类别</TD>
			               <TD width="24%" class="table_none">
			               <c:if test="${goodsflag ne '1' && goodsflag ne '2' && goodsflag ne '3'}">
	                            <select id="goodscategoryID2" name="goodscategoryID2" disabled="disabled">
	      		                 <option value="">----请选择----</option>
	      		                 <option value="1_0" ${goodscategoryID eq '1_0' ? 'selected="selected"' : '' }>镜架</option>
	      		                 <option value="2_1" ${goodscategoryID eq '2_1' ? 'selected="selected"' : '' }>镜架辅料</option>
	      		                 <option value="3" ${goodscategoryID eq '3' ? 'selected="selected"' : '' }>镜片</option>
	      		                 <option value="3_0" ${goodscategoryID eq '3_0' ? 'selected="selected"' : '' }>成品片</option>
	      		                 <option value="3_D" ${goodscategoryID eq '3_D' ? 'selected="selected"' : '' }>订做片</option>
	      		                 <option value="2_2" ${goodscategoryID eq '2_2' ? 'selected="selected"' : '' }>隐形辅料</option>
	      		                 <option value="4" ${goodscategoryID eq '4' ? 'selected="selected"' : '' }>隐形</option>
	      		                 <option value="4_0" ${goodscategoryID eq '4_0' ? 'selected="selected"' : '' }>隐形成品片</option>
	      		                 <option value="4_D" ${goodscategoryID eq '4_D' ? 'selected="selected"' : '' }>隐形订做片</option>
	      		                 <option value="5_0" ${goodscategoryID eq '5_0' ? 'selected="selected"' : '' }>护理液</option>
	      		                 <option value="6_6" ${goodscategoryID eq '6_6' ? 'selected="selected"' : '' }>太阳镜</option>
	      		                 <option value="6_8" ${goodscategoryID eq '6_8' ? 'selected="selected"' : '' }>老花镜</option>
	      		                 <option value="7_0" ${goodscategoryID eq '7_0' ? 'selected="selected"' : '' }>耗材</option>
	      		                 <option value="9_0" ${goodscategoryID eq '9_0' ? 'selected="selected"' : '' }>视光</option>
	      		                 <option value="2_0" ${goodscategoryID eq '2_0' ? 'selected="selected"' : '' }>配件</option>
	      	                    </select>
      	                    </c:if>
      	                          	                    
      	                    <c:if test="${goodsflag eq '1' || goodsflag eq '2' || goodsflag eq '3'}">
	                            <select id="goodscategoryID" name="goodscategoryID">
                                  <c:if test="${salestype eq '1'}">
		      		                 <option value="1_0" ${goodscategoryID eq '1_0' ? 'selected="selected"' : '' }>镜架</option>
		      		                 <option value="2_1" ${goodscategoryID eq '2_1' ? 'selected="selected"' : '' }>镜架辅料</option>
		      		                 <option value="3" ${goodscategoryID eq '3' ? 'selected="selected"' : '' }>镜片</option>
		      		                 <option value="3_0" ${goodscategoryID eq '3_0' ? 'selected="selected"' : '' }>成品片</option>
		      		                 <option value="3_D" ${goodscategoryID eq '3_D' ? 'selected="selected"' : '' }>订做片</option>
		      		                 
		      		                 <c:if test="${systemParameterPo.fspcheckaccessories eq '0'}">
			      		                 <option value="2_2" ${goodscategoryID eq '2_2' ? 'selected="selected"' : '' }>隐形辅料</option>
			      		                 <option value="5_0" ${goodscategoryID eq '5_0' ? 'selected="selected"' : '' }>护理液</option>
			      		                 <option value="6_6" ${goodscategoryID eq '6_6' ? 'selected="selected"' : '' }>太阳镜</option>
			      		                 <option value="6_8" ${goodscategoryID eq '6_8' ? 'selected="selected"' : '' }>老花镜</option>
			      		                 <option value="7_0" ${goodscategoryID eq '7_0' ? 'selected="selected"' : '' }>耗材</option>
			      		                 <option value="9_0" ${goodscategoryID eq '9_0' ? 'selected="selected"' : '' }>视光</option>
			      		                 <option value="2_0" ${goodscategoryID eq '2_0' ? 'selected="selected"' : '' }>配件</option>     		      		                 
		      		                 </c:if>                             
                                  </c:if>
                                  <c:if test="${salestype eq '3'}">

		      		                 <option value="4" ${goodscategoryID eq '4' ? 'selected="selected"' : '' }>隐形</option>
		      		                 <option value="4_0" ${goodscategoryID eq '4_0' ? 'selected="selected"' : '' }>隐形成品片</option>
		      		                 <option value="4_D" ${goodscategoryID eq '4_D' ? 'selected="selected"' : '' }>隐形订做片</option>
		      		                 <option value="5_0" ${goodscategoryID eq '5_0' ? 'selected="selected"' : '' }>护理液</option>
		      		                 <option value="2_2" ${goodscategoryID eq '2_2' ? 'selected="selected"' : '' }>隐形辅料</option>
		      		                 
		      		                 <c:if test="${systemParameterPo.fspcheckaccessories eq '0'}">		      		                 
				      		             <option value="1_0" ${goodscategoryID eq '1_0' ? 'selected="selected"' : '' }>镜架</option>
			      		                 <option value="2_1" ${goodscategoryID eq '2_1' ? 'selected="selected"' : '' }>镜架辅料</option>
			      		                 <option value="6_6" ${goodscategoryID eq '6_6' ? 'selected="selected"' : '' }>太阳镜</option>
			      		                 <option value="6_8" ${goodscategoryID eq '6_8' ? 'selected="selected"' : '' }>老花镜</option>
			      		                 <option value="7_0" ${goodscategoryID eq '7_0' ? 'selected="selected"' : '' }>耗材</option>
			      		                 <option value="9_0" ${goodscategoryID eq '9_0' ? 'selected="selected"' : '' }>视光</option>
			      		                 <option value="2_0" ${goodscategoryID eq '2_0' ? 'selected="selected"' : '' }>配件</option>
                                     </c:if>
                                  </c:if>
                                  <c:if test="${salestype eq '5'}">
		      		                 <option value="1_0" ${goodscategoryID eq '1_0' ? 'selected="selected"' : '' }>镜架</option>
		      		                 <option value="2_1" ${goodscategoryID eq '2_1' ? 'selected="selected"' : '' }>镜架辅料</option>
		      		                 <option value="2_2" ${goodscategoryID eq '2_2' ? 'selected="selected"' : '' }>隐形辅料</option>
		      		                 <option value="5_0" ${goodscategoryID eq '5_0' ? 'selected="selected"' : '' }>护理液</option>
		      		                 <option value="6_6" ${goodscategoryID eq '6_6' ? 'selected="selected"' : '' }>太阳镜</option>
		      		                 <option value="6_8" ${goodscategoryID eq '6_8' ? 'selected="selected"' : '' }>老花镜</option>
		      		                 <option value="7_0" ${goodscategoryID eq '7_0' ? 'selected="selected"' : '' }>耗材</option>
		      		                 <option value="9_0" ${goodscategoryID eq '9_0' ? 'selected="selected"' : '' }>视光</option>
		      		                 <option value="2_0" ${goodscategoryID eq '2_0' ? 'selected="selected"' : '' }>配件</option>                                  
                                  </c:if>
	      	                    </select>
      	                    </c:if>
      	                    
			               </TD> 
						   <TD width="9%" height="26" class="table_body">零售价</TD>
			               <TD width="24%" class="table_none">
			               <input clean=clean class="text_input100" type="text" id="retailbeginprice" name="retailbeginprice" value="${requestScope.retailbeginprice}" onKeyUp="value=value.replace(/[^\d\.]/g,'')" maxlength="15"> ~ <input clean=clean class="text_input100" type="text"  id="retailendprice" name="retailendprice" value="${requestScope.retailendprice}" onKeyUp="value=value.replace(/[^\d\.]/g,'')" maxlength="15"></TD>
                           
                        </TR>
                        <TR id="suppliershow">

                         <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input clean=clean id="supplierName" class="text_input160" name="supplierName" value="${supplierName}" readonly="readonly"/>
							   			<input clean=clean type="hidden" id="supplierID" name="supplierID" value="${supplierID }" />
									</li>
						   			<li class="horizontal_onlyRight">
						   				<c:if test="${empty(supplierID_open)}">
						  				<img src="${ctx }/img/newbtn/btn_change_0.png" id="querySupplier" btn=btn title="选择" onClick="openSupplier();" ></li>
						   				</c:if>
						   	</TD>			               
						   <TD height="26" class="table_body"><span id="brandshow">商品品种</span>&nbsp;</TD>
			               <TD class="table_none" colspan="3">
			               <span id="brandName2">
                           <li class="horizontal_onlyRight">
						   		<input clean=clean class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input clean=clean type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id="queryBrand" title="选择" onclick="openBrand();"></li>
						  </span>&nbsp;
			              </TD>
                        </TR>
                        <TR id="suppliershow2">
                           <TD height="26" class="table_body">商品代码</TD>
			               <TD class="table_none">
                            <input clean=clean width="24%" class="text_input160" type="text"  id="goodsID" name="goodsID" value="${requestScope.goodsID}">
			               </TD>
			               <TD height="26" class="table_body">商品名称</TD>
			               <TD class="table_none" >
                            <input clean=clean class="text_input160" type="text"  id="goodsName" name="goodsName" value="${requestScope.goodsName}">
			               </TD>
			                <TD height="26" class="table_body">商品条码</TD>
			               <TD class="table_none" >
                            <input clean=clean class="text_input200" type="text" maxlength="26" id="goodsBar" name="goodsBar" value="${requestScope.goodsBar}">
			               </TD>
                         </TR> 
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">

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
                          <TH width="4%" height="26" scope=col colspan="2">全选<c:if test="${goodsflag eq '1' || goodsflag eq '2' || goodsflag eq '3'}"><input type="checkbox" name="chks" id="chks" onclick="chkAll()"/></c:if></TH>                        
                          <TH width="12%" scope=col>商品代码</TH>
                          <TH width="15%" scope=col>商品名称</TH>
                          <TH width="6%" scope=col>商品类别</TH>
                          <TH width="15%" scope=col>制造商简称</TH>
                          <TH width="15%" scope=col>商品品种</TH>
                          <TH width="10%" scope=col>零售价</TH>
						  </TR>
						<s:iterator value="goodsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">  
                          <TD height="26" width="2%">                
                            <c:if test="${goodsflag eq '1' || goodsflag eq '2' || goodsflag eq '3'}">
	                              <input type="checkbox" name="chk" id="chk" goodsid='${bgigoodsid}' value="{'goods':'${bgigoodsid}','goodsName':'${bgigoodsname} ${bgigoodsid}','minCostPrice':'${bgiretailbeginprice}','maxCostPrice':'${bgiretailendprice}','brand':'${bgibrandid }','minCostPriceAmount':'${bgiretailbeginprice}','maxCostPriceAmount':'${bgiretailendprice}'
	                           ,'supplier':'${bgisupplierid }','iscustomize':'${bgiiscustomize }','brand':'${bgibrandid }','goodscategoryid':'${bgigoodscategoryid }','goodsclass':'${bgisalestype }'}" onclick="setSingleValue(this,'${bgigoodsid}','${bgigoodsname} ${bgigoodsid}','${bgiretailbeginprice}','${bgiretailendprice}','${bgibrandid }','${bgiretailbeginprice}','${bgiretailendprice}'
	                           ,'${bgisupplierid }','${bgiiscustomize }','${bgibrandid }','${bgigoodscategoryid }','${bgisalestype }');"/>
                            </c:if>
                          </TD>
                          <TD height="26" width="2%">
                          <c:if test="${goodsflag ne '1' && goodsflag ne '2' && goodsflag ne '3'}">
	                          <img btn=btn src="${ctx }/img/newbtn/select_0.png" title="选择并关闭页面" onclick="setValue('${bgigoodsid}','${bgigoodsname} ${bgigoodsid}','${bgiretailbeginprice}','${bgiretailendprice}','${bgibrandid }','${bgiretailbeginprice}','${bgiretailendprice}'
	                           ,'${bgisupplierid }','${bgiiscustomize }','${bgibrandid }','${bgigoodscategoryid }','${bgisalestype }');"/>
                           </c:if>
                          </TD>
                          <TD>${bgigoodsid}</TD>
                          <TD>${bgiviewgoodsname}</TD>
                          <TD>${bgigoodscategoryname}</TD>
                          <TD>${bgisuppliername}</TD>
                          <TD>${bgibrandname}</TD>
                          <TD>${bgiretailbeginprice}至${bgiretailendprice}</TD>
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
    <TD height=5>&nbsp;</TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
