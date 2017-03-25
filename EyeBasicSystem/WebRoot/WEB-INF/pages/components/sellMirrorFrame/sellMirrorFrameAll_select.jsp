<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>

<title>销售镜片</title>
</head>
<script>

	function inTransitDetail(goodsid,goodsbarcode,warehouseid,flag){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;	
		if(is_iPad()){
			showPopWin("getGoodsInTransitDetail.action?goodsID="+goodsid+"&goodsBarCode="+goodsbarcode+"&warehouseID="+warehouseid+"&flag="+flag,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("getGoodsInTransitDetail.action?goodsID="+goodsid+"&goodsBarCode="+goodsbarcode+"&warehouseID="+warehouseid+"&flag="+flag,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【商品在途库存详细】";
	}

	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
		
		if($("select[name=othergoodscategory]").val() == '2'){
			$("select[name=accessoriestype]").show();
		}

		setCheckValue();

		if ('${iscustomize}' == 'D'){
        	$('#kucun').val('0');
        	$('#kucun').hide();
        	$('#kucuninfo').hide();
		}
		
	});

	function setCheckValue(){
        $("input[id=chk]").each(function(){
        	  for(var i = 0; i < parent.$('input[name=salesDetailPo.ssesdsalesitemids]').size(); i++){
            	  if(parent.$('input[name=salesDetailPo.ssesdsalesitemids]').eq(i).val() != ''){
            		if(parent.$('input[name=salesDetailPo.ssesdsalesitemids]').eq(i).val().substring(0,1) == '3' || parent.$('input[name=salesDetailPo.ssesdsalesitemids]').eq(i).val().substring(0,1) == '4'){
						if($(this).attr("goodsid") == parent.$('input[name=salesDetailPo.ssesdsalesitemids]').eq(i).val() && '${rl}' == parent.$('input[name=salesDetailPo.ssesdglassflags]').eq(i).val()&& $(this).attr("stockid") == parent.$('input[name=salesDetailPo.ssesdstockids]').eq(i).val()){
							$(this).attr("checked","checked");
						}
            	  	}else{
            	  		if($(this).attr("goodsid") == parent.$('input[name=salesDetailPo.ssesdsalesitemids]').eq(i).val()&& $(this).attr("stockid") == parent.$('input[name=salesDetailPo.ssesdstockids]').eq(i).val()){
							$(this).attr("checked","checked");
						}
                	}
                  }
           	  }
		});
    }

	function setSingleValue(obj){
		var objValue=eval('(' + obj.value + ')');
        if(obj.checked==true){
        	if(!objValue.bgiretailprice){
        		obj.checked=false;
    			alert("该商品未设置零售价格！");
    			return;
    		}
        	setValue(objValue);
        }else if(obj.checked==false){
            if(objValue.bgigoodscategoryid == "3" || objValue.bgigoodscategoryid == "4"){
	        	for(var i = 0; i < parent.$('input[name=salesDetailPo.ssesdsalesitemids]').size(); i++){
	        		if(parent.$('input[name=salesDetailPo.ssesdsalesitemids]').eq(i).val() == objValue.bgigoodsid && parent.$('input[name=salesDetailPo.ssesdglassflags]').eq(i).val()==objValue.glassflag){
	        			window.parent.deleteItem(parent.$('input[name=salesDetailPo.ssesdsalesitemids]').eq(i));
				        window.parent.totalamount();
		        	}
		    	}
        	}else{
        		window.parent.deleteItem(parent.$('input[value='+objValue.bgigoodsid+']'));
		        window.parent.totalamount();
            }
           
        }

    }
	
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;

		var goodscategory = $("select[id=othergoodscategory]").val();
		if(goodscategory != ''){
			if('${other}' != null && '${other}' != ''){
				if(is_iPad()){
					showPopWin("selSupplierOpen.action?categoryID_open="+$("select[name=othergoodscategory]").val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}else{
					showPopWin("selSupplierOpen.action?categoryID_open="+$("select[name=othergoodscategory]").val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}
			}else{
				if(is_iPad()){
					showPopWin("selSupplierOpen.action?categoryID_open=${goodscategory}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}else{
					showPopWin("selSupplierOpen.action?categoryID_open=${goodscategory}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}	
			}

			document.getElementById('popupTitle').innerHTML="【制造商查询】";
		}else{
			alert("请选择商品类别！");
			return;
		}
		
		
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
	    var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;

		var goodscategory = $("select[id=othergoodscategory]").val();

		if(goodscategory != ''){
			if('${other}' != null && '${other}' != ''){
				if(is_iPad()){
					showPopWin("selBrandOpen.action?categoryID_open="+$("select[name=othergoodscategory]").val()+"&supplierID_open="+supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}else{
					showPopWin("selBrandOpen.action?categoryID_open="+$("select[name=othergoodscategory]").val()+"&supplierID_open="+supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}
			}else{
				if(is_iPad()){
					showPopWin("selBrandOpen.action?categoryID_open=${goodscategory}&supplierID_open="+supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}else{
					showPopWin("selBrandOpen.action?categoryID_open=${goodscategory}&supplierID_open="+supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}	
			}

			document.getElementById('popupTitle').innerHTML="【品种查询】";
		}else{
			alert("请选择商品类别！");
			return;
		}
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
	}
	
	function search(){
		var orderstype = window.parent.$('input[name=salesBasicPo.ssesborderstype]').val();
		if('${other}' != ''&&$("select[id=othergoodscategory]").val()==''){
			alert("请选择商品类别！");
			return;
		}

		if(orderstype != '1'){
			if('${systemParameterPo.fspoldglasssalestype}'=='1'){
				if($("select[id=othergoodscategory]").val()=='8'){
					if(window.parent.$('input[glassType="jinyong"][name$="ssesbballglassod"]')[0].value==''&&window.parent.$('input[glassType="yuanyong"][name$="ssesbballglassod"]')[0].value==''){
						alert('请填写右眼球镜!');
						return;
					}
					
					if(window.parent.$('input[glassType="jinyong"][name$="ssesbballglassos"]')[0].value==''&&window.parent.$('input[glassType="yuanyong"][name$="ssesbballglassos"]')[0].value==''){
						alert('请填写左眼球镜!');
						return;
					}
					
					if((window.parent.$('input[glassType="jinyong"][name$="ssesbballglassod"]')[0].value != window.parent.$('input[glassType="jinyong"][name$="ssesbballglassos"]')[0].value)||(window.parent.$('input[glassType="yuanyong"][name$="ssesbballglassod"]')[0].value != window.parent.$('input[glassType="yuanyong"][name$="ssesbballglassos"]')[0].value)){
						alert("右眼球镜与左眼球镜不等！");
						return;
					}
					
					if(window.parent.$('input[glassType="jinyong"][name$="ssesbballglassod"]')[0].value!=''&&window.parent.$('input[glassType="jinyong"][name$="ssesbpostglassod"]')[0].value==''){
						window.parent.$('input[glassType="jinyong"][name$="ssesbpostglassod"]')[0].value='0.00';
					}
		
					if(window.parent.$('input[glassType="yuanyong"][name$="ssesbballglassod"]')[0].value!=''&&window.parent.$('input[glassType="yuanyong"][name$="ssesbpostglassod"]')[0].value==''){
						window.parent.$('input[glassType="yuanyong"][name$="ssesbpostglassod"]')[0].value='0.00';
					}
		
					if(window.parent.$('input[glassType="jinyong"][name$="ssesbpostglassod"]')[0].value < 0){
						alert("右眼柱径应等于0.00！");
						return;
					}
		
					if(window.parent.$('input[glassType="yuanyong"][name$="ssesbpostglassod"]')[0].value < 0){
						alert("右眼柱径应等于0.00！");
						return;
					}
					
					if(window.parent.$('input[glassType="jinyong"][name$="ssesbballglassos"]')[0].value!=''&&window.parent.$('input[glassType="jinyong"][name$="ssesbpostglassos"]')[0].value!=''){
						window.parent.$('input[glassType="jinyong"][name$="ssesbpostglassos"]')[0].value='0.00';
					}
		
					if(window.parent.$('input[glassType="yuanyong"][name$="ssesbballglassos"]')[0].value!=''&&window.parent.$('input[glassType="yuanyong"][name$="ssesbpostglassos"]')[0].value!=''){
						window.parent.$('input[glassType="yuanyong"][name$="ssesbpostglassos"]')[0].value='0.00';
					}
		
					if(window.parent.$('input[glassType="jinyong"][name$="ssesbpostglassos"]')[0].value < 0){
						alert("左眼柱径应等于0.00！");
						return;
					}
		
					if(window.parent.$('input[glassType="yuanyong"][name$="ssesbpostglassos"]')[0].value < 0){
						alert("左眼柱径应等于0.00！");
						return;
					}
				}
			}
		}
		
		$("img").removeAttr("onclick");
		
		if(('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2')){
			if($("select[id=othergoodscategory]").val() == '5' || $("select[id=othergoodscategory]").val() == '4' || $("input[id=goodscategory]").val() == '4' || $("input[id=goodscategory]").val() == '5'){
				goodsForm.action="selectSellMirrorFrameBatch.action";
			}else{
				goodsForm.action="selectSellMirrorFrameAll.action?orderstype="+orderstype;
			}
		}else{
			goodsForm.action="selectSellMirrorFrameAll.action?orderstype="+orderstype;
		}
		goodsForm.submit();
		showLoadingBar();
	}
	
	$(document).ready(function(){
		if('${iscustomize}'!=''){
			$('#iscustomize').attr("value",'${iscustomize}');
		}
	});
	
	function clean(){
		$(':input[type!=button][type!=hidden]').val('');
		$('select').each(function(){
			$(this)[0].selectedIndex=0;
		});
		$('#supplierID').val('');
		$('#brandID').val('');
    	$('#kucun').val('1');
    	$('#kucun').show();
    	$('#kucuninfo').show();
	}
	
	function setValue(json){
		if(json.bgigoodscategoryid != '3' && json.bgigoodscategoryid != '4'){
		    if (json.bgigoodscategoryid == '1'){
		        parent.setCategory('镜架');
		        json.glassflag = '';
		    }
		    if (json.bgigoodscategoryid == '2'){
		        parent.setCategory('辅料');
		        json.glassflag = 'A';
		    }
		    if (json.bgigoodscategoryid == '5'){
		        parent.setCategory('护理液');
		        json.glassflag = 'A';
		    }
		    if (json.bgigoodscategoryid == '6'){
		        parent.setCategory('太阳镜');
		        json.glassflag = 'A';
		    }
		    if (json.bgigoodscategoryid == '7'){
		        parent.setCategory('耗材');
		        json.glassflag = 'A';
		    }
		    if (json.bgigoodscategoryid == '8'){
		        parent.setCategory('老花镜');
		        json.glassflag = 'A';
		    }
		    if (json.bgigoodscategoryid == '9'){
		        parent.setCategory('视光商品');
		        json.glassflag = 'A';
		    }
		}
		
		json.maxgoodsquantity = accSub(Number(json.bgigoodsquantity),Number(json.bgiintransitgoodsnum));

	    if (parent.$('input[name=salestype][checked]').val() == '1'){
		    if(!parent.checkFrameSales(json.glassflag)){
		    	$("input[goodsid="+json.bgigoodsid+"][stockid="+json.bgiwarehouseid+"]").attr("checked","");
			    return;
		    }
	    }
	    if (parent.$('input[name=salestype][checked]').val() == '3'){
		    if( json.bgigoodscategoryid == '4' && !parent.checkContactSales(json.bgigoodsid,json.glassflag)){
		    	$("input[goodsid="+json.bgigoodsid+"]").attr("checked","");
			    return;
		    }
	    }

	    if('${systemParameterPo.fspsalestype}' == '1'){
	    	parent.addGoods(json);
	    	/*
	    	if (json.bgigoodscategoryid == '1' && parent.$("input[id=salestype_input]").val() == '1'){
	    		parent.hidePopWin();parent.toRound();
	    	}
	    	*/
		}else{
			var num = accSub(Number(json.bgigoodsquantity),Number(json.bgiintransitgoodsnum));
			if(Number(num) > 0 || $('#iscustomize').val()=='D' || '${oneselfframe}'=='ZZ' || json.bgigoodscategoryid == '3'){
				if(json.bgigoodscategoryid == '3' && $('#iscustomize').val() != 'D' && '${oneselfframe}' != 'ZZ'){
					if('${systemParameterPo.fspglassischecknumber}' == '1'){
					}else{
						if(Number(num) > 0){
							if(accAdd(1,parseFloat(parent.$('input[name=salesDetailPo.ssesdsalesitemids][value='+json.bgigoodsid+']').parent().parent().parent().find("input[name=salesDetailPo.ssesdnumbers]").val())) > parseFloat(json.maxgoodsquantity)){
								alert("该商品库存不足！");
								$("input[goodsid="+json.bgigoodsid+"]").attr("checked","");
								return;
							}
						}else{
							alert("该商品库存不足！");
							$("input[goodsid="+json.bgigoodsid+"]").attr("checked","");
							return;
						}
					}
				}else if($('#iscustomize').val() != 'D' && '${oneselfframe}' != 'ZZ'){
					if(accAdd(1,parseFloat(parent.$('input[name=salesDetailPo.ssesdsalesitemids][value='+json.bgigoodsid+']').parent().parent().parent().find("input[name=salesDetailPo.ssesdnumbers]").val())) > parseFloat(json.maxgoodsquantity)){
						alert("该商品库存不足！");
						$("input[goodsid="+json.bgigoodsid+"]").attr("checked","");
						return;
					}
				}
				parent.addGoods(json);	
				/*		
				if (json.bgigoodscategoryid == '1' && parent.$("input[id=salestype_input]").val() == '1'){
		    		parent.hidePopWin();parent.toRound();
		    	}
		    	*/    	
			}else{
				alert("该商品库存不足！");
				$("input[goodsid="+json.bgigoodsid+"]").attr("checked","");
				return;
			}
		}
		
	}
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	goodsForm.action=link;
	  	goodsForm.submit();
		showLoadingBar();
	}

	function isshowaccessoriestype(obj){
		if($(obj).val() == '2'){
			$("select[name=accessoriestype]").show();
		}else{
			$("select[name=accessoriestype]").hide();
			$("select[name=accessoriestype]").val('');
		}
		$("input[name=brandName]").val('');  
		$("input[name=brandID]").val('');
		$("input[name=supplierName]").val('');
		$("input[name=supplierID]").val('');
	}

	function RorL(obj){
		goodsForm.action="selectSellMirrorFrameAll.action?rl="+$(obj).val();
		goodsForm.submit();
	}

    function changeCustomize(obj){
        if (obj.value == 'D'){
        	$('#kucun').val('0');
        	$('#kucun').hide();
        	$('#kucuninfo').hide();
        }else{
        	$('#kucun').val('1');
        	$('#kucun').show();
        	$('#kucuninfo').show();
        }
    }
	
</script>
<!-- oncontextmenu="event.returnValue=false"  onhelp="Showhelp();return false;"-->
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="categoryID_open" value="${categoryID_open }" />
<input type="hidden" name="supplierID_open" value="${supplierID_open }" />

<input type="hidden" name="rsph" value="${rsph}"/>
<input type="hidden" name="rcyl" value="${rcyl}"/>
<input type="hidden" name="radd" value="${radd}"/>
<input type="hidden" name="lsph" value="${lsph}"/>
<input type="hidden" name="lcyl" value="${lcyl}"/>
<input type="hidden" name="ladd" value="${ladd}"/>
<input type="hidden" name="glassFlag" value="${glassFlag }" />
<input type="hidden" name="recipeType" value="${recipeType }" />

<input type="hidden" id="goodscategory" name="goodscategory" value="${goodscategory }" />
<input type="hidden" id="accessoryType" name="accessoryType" value="${accessoryType }" />
<input type="hidden" id="oneselfframe" name="oneselfframe" value="${oneselfframe }" />
<input type="hidden" id="other" name="other" value="${other }" />
<input type="hidden" id="customertype" name="customertype" value="${customertype }" />
<c:if test="${systemParameterPo.fspsalestype ne '1'}"> 
 	<input type="hidden" id="kucun" name="kucun" value="1"/>
</c:if>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
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
                  <c:if test="${oneselfframe != 'ZZ'}">	
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
						   <TD width="8%" height="26" class="table_body">商品代码</TD>
			               <TD width="25%" class="table_none">
                            <input class="text_input160" type="text"  id="goodsID" name="goodsid" value="${goodsid}">
			               </TD>
			               <TD width="8%" height="26" class="table_body">商品名称</TD>
			               <TD width="25%" class="table_none">
                            <input class="text_input160" type="text"  id="goodsName" name="goodsname" value="${goodsname}">
			               </TD>
                           <TD width="8%" height="26" class="table_body">零售价区间</TD>
			               <TD width="25%" class="table_none">
                            <input class="text_input80" type="text"  id="pricedown" name="pricedown" value="${pricedown}">至
                            <input class="text_input80" type="text"  id="priceup" name="priceup" value="${priceup}">
			               </TD>
                        </TR>
                        <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1'}"> 
                        <TR>
                           <TD width="8%" height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
				   			<li class="horizontal_onlyRight">
					   			<input id="supplierName" class="text_input160" name="supplierName" readonly="readonly" value="${supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } />
					   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
							</li>																					
				   			<li class="horizontal_onlyRight">
				  				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openSupplier();" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }></li>
						   	</TD>
						   <TD height="26" class="table_body">品种</TD>
			               <TD class="table_none" colspan="3">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openBrand();"></li>
			               </TD>
			            </TR>
			            </c:if>
			               <c:if test="${goodscategory == '1'}"> 
				               <c:if test="${systemParameterPo.fspsalestype == '1'}"> 
				               <tr>
					               <TD height="26" class="table_body">库存状态</TD>
					               <td class="table_none" colspan="5">
					               	<SELECT id="kucun" name="kucun">
			                           	<option value="0" ${kucun=='0'?'selected="selected"':''}>全部</option>
			                           	<option value="1" ${kucun=='1'?'selected="selected"':''}>大于0</option>
		                            </SELECT>
					               </td>
				               </tr>
				       		   </c:if>
			       		   </c:if>
			       		   <c:if test="${goodscategory == '2'}"> 
				               <c:if test="${systemParameterPo.fspsalestype == '1'}"> 
				               <tr>
					               <TD height="26" class="table_body">库存状态</TD>
					               <td class="table_none" colspan="5">
					               	<SELECT id="kucun" name="kucun">
			                           	<option value="0" ${kucun=='0'?'selected="selected"':''}>全部</option>
			                           	<option value="1" ${kucun=='1'?'selected="selected"':''}>大于0</option>
		                            </SELECT>
					               </td>
				               </tr>
				       		   </c:if>
			       		   </c:if>
                   <c:if test="${goodscategory == '3'}">       
                       <TR>
			               <TD width="8%" height="26" class="table_body">镜片型</TD>
			               <TD class="table_none">
			                <SELECT id="iscustomize" name="iscustomize" onchange="changeCustomize(this);">
                           	<option value="0" ${iscustomize=='0'?'selected="selected"':''}>成品片</option>
                           	<option value="D" ${iscustomize=='D'?'selected="selected"':''}>订做片</option>
                           	<!-- <option value="ZZ" ${iscustomize=='ZZ'?'selected="selected"':''}>自带片</option> -->
                           </SELECT>
			               </TD>   
			               <TD width="8%" height="26" class="table_body">镜片材质</TD>
			               <TD class="table_none">
			                <SELECT id="materialType" name="materialType">
			                <option value="">---请选择---</option>
                           	<option value="1" ${materialType == '1' ? 'selected="selected"':''}>树脂</option>
                           	<option value="2" ${materialType == '2' ? 'selected="selected"':''}>玻璃</option>
                           	<option value="3" ${materialType == '3' ? 'selected="selected"':''}>PC</option>
                           </SELECT>
			               </TD>  
			               <TD height="26" class="table_body">镜片种类</TD>
			               <TD class="table_none" >
	                            <SELECT id="ismutiluminosity" name="ismutiluminosity">
		                            <option value="" ${ismutiluminosity != "" ? "":"selected='selected'" }>---请选择---</option>
		                            <option value="M" ${ismutiluminosity != "M" ? "":"selected='selected'" }>多光</option>
		                           	<option value="0" ${ismutiluminosity != "0" ? "":"selected='selected'" } >单光</option>
		                           	<option value="J" ${ismutiluminosity != "J" ? "":"selected='selected'" }>渐进</option>
		                           	<option value="K" ${ismutiluminosity != "K" ? "":"selected='selected'" }>抗疲劳</option>
		                           	<option value="Q" ${ismutiluminosity != "Q" ? "":"selected='selected'" }>其他</option>
	                           </SELECT>
			               </TD>
			               </TR>
			               <TR>
			               <TD height="26" class="table_body">折射率</TD>
			               <TD class="table_none" ${systemParameterPo.fspsalestype == '1' ? '':'colspan="5"'}>
	                            <SELECT id="refractive" name="refractive">
		                            <option value="" ${refractive != "" ? "":"selected='selected'" }>---请选择---</option>
		                            <s:iterator value="refractiveSetPos">
		                            <option value="${brfname }" ${refractive != brfname  ? "":"selected='selected'" }>${brfname }</option>
		                            </s:iterator>
	                           </SELECT>
			               </TD>
			               <c:if test="${systemParameterPo.fspsalestype == '1'}"> 
			               <TD height="26" class="table_body">库存状态</TD>
			               <td class="table_none" colspan="3">
			               	<SELECT id="kucun" name="kucun">
                           	<option value="0" ${kucun=='0'?'selected="selected"':''}>全部</option>
                           	<option value="1" ${kucun=='1'?'selected="selected"':''}>大于0</option>
                           </SELECT>
			               </td>
			       		   </c:if>
                        </TR>
                  </c:if>     
                  <c:if test="${goodscategory == '4'}">        
                        <TR>
			               <TD width="8%" height="26" class="table_body">镜片型</TD>
			               <TD class="table_none" ${systemParameterPo.fspsalestype == '0' ? 'colspan="5"' : ''}>
			                <SELECT id="iscustomize" name="iscustomize" onchange="changeCustomize(this);">
	                           	<option value="0" ${iscustomize=='0'?'selected="selected"':''}>成品片</option>
	                           	<option value="D" ${iscustomize=='D'?'selected="selected"':''}>订做片</option>
                            </SELECT>
			               </TD>
			               <c:if test="${systemParameterPo.fspsalestype == '1'}"> 
			               <TD height="26" class="table_body">库存状态</TD>
			               <td class="table_none" colspan="3">
			               	<SELECT id="kucun" name="kucun">
                           	<option value="0" ${kucun=='0'?'selected="selected"':''}>全部</option>
                           	<option value="1" ${kucun=='1'?'selected="selected"':''}>大于0</option>
                           </SELECT>
			               </td>
			       		   </c:if>
                        </TR>
                  </c:if>
                  			<c:if test="${goodscategory == '5'}"> 
				               <c:if test="${systemParameterPo.fspsalestype == '1'}"> 
				               <tr>
					               <TD height="26" class="table_body">库存状态</TD>
					               <td class="table_none" colspan="5">
					               	<SELECT id="kucun" name="kucun">
			                           	<option value="0" ${kucun=='0'?'selected="selected"':''}>全部</option>
			                           	<option value="1" ${kucun=='1'?'selected="selected"':''}>大于0</option>
		                            </SELECT>
					               </td>
				               </tr>
				       		   </c:if>
			       		   </c:if>
                  <c:if test="${not empty(other) && (empty(oneselfframe) || oneselfframe=='')}">            
                        <TR>
                           <TD width="8%" height="26" class="table_body">商品类型</TD>
			               <TD class="table_none" ${systemParameterPo.fspsalestype == '0' ? 'colspan="5"' : ''}>
                           <SELECT id="othergoodscategory" name="othergoodscategory" onchange="isshowaccessoriestype(this)">
                           	<option value=""}>---请选择---</option>
                           	<option value="1" ${othergoodscategory=='1' ?'selected="selected"':''}>镜架</option>
                           	<option value="2" ${othergoodscategory=='2' ?'selected="selected"':''}>配件</option>
                           	<option value="5" ${othergoodscategory=='5' ?'selected="selected"':''}>护理液</option>
                           	<option value="6" ${othergoodscategory=='6' ?'selected="selected"':''}>太阳镜</option>
                           	<option value="7" ${othergoodscategory=='7' ?'selected="selected"':''}>耗材</option>
                           	<option value="8" ${othergoodscategory=='8' ?'selected="selected"':''}>老花镜</option>
                           	<option value="9" ${othergoodscategory=='9' ?'selected="selected"':''}>视光</option>
                           </SELECT>
                           <SELECT id="accessoriestype" name="accessoriestype" style="display: none;">
                           	<option value=""}>---请选择---</option>
                           	<option value="1" ${accessoriestype=='1' ?'selected="selected"':''}>框镜配件</option>
                           	<option value="2" ${accessoriestype=='2' ?'selected="selected"':''}>隐形配件</option>
                           </SELECT>
			               </TD>
			               <c:if test="${systemParameterPo.fspsalestype == '1'}"> 
			               <TD height="26" class="table_body">库存状态</TD>
			               <td class="table_none" colspan="3">
			               	<SELECT id="kucun" name="kucun">
                           	<option value="0" ${kucun=='0'?'selected="selected"':''}>全部</option>
                           	<option value="1" ${kucun=='1'?'selected="selected"':''}>大于0</option>
                           </SELECT>
			               </td>
			       		   </c:if>
                        </TR>
                  </c:if>
			       		<c:if test="${goodscategory == '3'||goodscategory == '4'}"> 
                  		<tr align=left height="26">
		   					<td class="table_none" colspan="20" colspan="5"><input type="radio" name="rl" value="R" onclick="RorL(this)" ${rl == 'R' ? 'checked=checked':'' }/>右眼镜片&nbsp;&nbsp;&nbsp;<input type="radio" name="rl" value="L" onclick="RorL(this)" ${rl == 'L' ? 'checked=checked':'' }/>左眼镜片</td>
		   			    </tr>
		   			    </c:if>     
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn id="submitButton" title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
							</td>
						</tr>
					</table>
					</c:if>
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
                     
                     <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
                     
					  <table width="100%" border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <c:if test="${oneselfframe == 'ZZ' && goodscategory == '3'}">
                        <tr align=left height="26" class=table_title>
	   					<TH scope=col colspan="20"><input type="radio" name="rl" value="R" onclick="RorL(this)" ${rl == 'R' ? 'checked=checked':'' }/>右眼镜片&nbsp;&nbsp;&nbsp;<input type="radio" name="rl" value="L" onclick="RorL(this)" ${rl == 'L' ? 'checked=checked':'' }/>左眼镜片</th>
	   			   		<input name="iscustomize" type="hidden" value="0"/>
	   			   		</tr>
	   			   		</c:if>
                        <TR class=table_title align=middle>
                          <TH scope=col width="4%" height="26">操作</TH>
                          <TH scope=col>商品代码</TH>
                          <TH scope=col>商品名称</TH>
                          <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1'}"> 
                          <TH scope=col>品种</TH>
                          </c:if>
                          <c:if test="${othergoodscategory == '8'}">
                      	    <TH scope=col>老花镜度数</TH>
                      	  </c:if>
                          <TH scope=col>销售价格</TH>
                          <c:choose>
                          	<c:when test="${goodscategory == '1' && empty(other) && oneselfframe != 'ZZ'}">
                          	   <TH scope=col>型号</TH>
	                           <TH scope=col>色号 </TH>
	                           <TH scope=col>镜架材质 </TH>
	                           <TH scope=col>镜架尺寸</TH> 
	                           <TH scope=col>仓位</TH>
                          	   <TH scope=col>数量</TH>
                          	   <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
                          	   <TH scope=col>在途数量</TH>
                          	   </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '1' && empty(other) && oneselfframe == 'ZZ'}">
                          	   <TH scope=col>型号</TH>
	                           <TH scope=col>色号 </TH>
	                           <TH scope=col>镜架材质 </TH>
	                           <TH scope=col>镜架尺寸</TH> 
                          	</c:when>
                          	<c:when test="${goodscategory == '2' && empty(other)}">
                          		<TH scope=col>型号</TH>
	                           	<TH scope=col>配件型 </TH>
	                           	<TH scope=col>仓位</TH>
                          	    <TH scope=col>数量</TH>
                          	   <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
                          	   <TH scope=col>在途数量</TH>
                          	   </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '3' && iscustomize=='0' && empty(other) && oneselfframe != 'ZZ'}">
	                          	<TH scope=col>球镜</TH>
	                           	<TH scope=col>柱镜 </TH>
	                           	<TH scope=col>下加光 </TH>
	                           	<TH scope=col>折射率</TH> 
	                           	<TH scope=col>光度分类 </TH>
	                           	<TH scope=col>材料分类</TH> 
	                           	<TH scope=col>仓位</TH>
                          	    <TH scope=col>数量</TH>
                          	   <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
                          	   <TH scope=col>在途数量</TH>
                          	   </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '3' && iscustomize=='0' && empty(other) && oneselfframe == 'ZZ'}">
	                          	<TH scope=col>球镜</TH>
	                           	<TH scope=col>柱镜 </TH>
	                           	<TH scope=col>下加光 </TH>
	                           	<TH scope=col>折射率</TH> 
	                           	<TH scope=col>光度分类 </TH>
	                           	<TH scope=col>材料分类</TH> 
                          	</c:when>
                          	<c:when test="${goodscategory == '3' && iscustomize=='D' && empty(other)}">
	                          	<TH scope=col>球镜区间</TH>
	                           	<TH scope=col>柱镜区间 </TH>
	                           	<TH scope=col>轴位 </TH>
	                           	<TH scope=col>下加光区间</TH> 
	                           	<TH scope=col>折射率 </TH>
	                           	<TH scope=col>型号</TH> 
                          		<TH scope=col>光度分类</TH> 
                          		<TH scope=col>材料分类</TH> 
                          		<TH scope=col>渐进片分类</TH> 
                          		<TH scope=col>镜片功能</TH> 
                          		<TH scope=col>订做周期</TH> 
                          		<TH scope=col>仓位</TH>
                          	</c:when>
                          	<c:when test="${goodscategory == '4' && iscustomize=='0' && empty(other)}">
	                          	<TH scope=col>球镜</TH>
	                           	<TH scope=col>柱镜 </TH>
	                           	<TH scope=col>曲率 </TH>
	                           	<TH scope=col>直径</TH> 
	                           	<TH scope=col>使用类型 </TH>
	                           	<TH scope=col>抛弃型分类</TH> 
	                           	<TH scope=col>仓位</TH>
                          	    <TH scope=col>数量</TH>
                           	   <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
                          	   <TH scope=col>在途数量</TH>
                          	   </c:if> 
                          	</c:when>
                          	<c:when test="${goodscategory == '4' && iscustomize=='D' && empty(other)}">
	                          	<TH scope=col>球镜区间</TH>
	                           	<TH scope=col>柱镜区间 </TH>
	                           	<TH scope=col>轴位区间 </TH>
	                           	<TH scope=col>曲率1区间</TH> 
	                           	<TH scope=col>曲率2区间 </TH>
	                           	<TH scope=col>型号</TH> 
                          		<TH scope=col>使用类型</TH> 
                          		<TH scope=col>抛弃型分类</TH> 
                          		<TH scope=col>订做周期</TH> 
                          		<TH scope=col>仓位</TH>
                          	</c:when>
                          	<c:when test="${goodscategory == '5' && empty(other)}">
                          		<TH scope=col>型号</TH>
	                           	<TH scope=col>主容量 </TH>
	                           	<TH scope=col>次容量 </TH>
	                           	<TH scope=col>仓位</TH>
                          	    <TH scope=col>数量</TH> 
                          	   <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
                          	   <TH scope=col>在途数量</TH>
                          	   </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '6' && empty(other)}">
                          		<TH scope=col>型号</TH>
	                           	<TH scope=col>颜色 </TH>
	                           	<TH scope=col>镜架尺寸 </TH>
	                           	<TH scope=col>仓位</TH>
                          	    <TH scope=col>数量</TH>
                          	   <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
                          	   <TH scope=col>在途数量</TH>
                          	   </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '8' && empty(other)}">
                          		<TH scope=col>老花镜度数</TH>
	                           	<TH scope=col>型号 </TH>
	                           	<TH scope=col>镜架尺寸 </TH>  
	                           	<TH scope=col>厂家色号 </TH> 
	                           	<TH scope=col>仓位</TH>
                          	    <TH scope=col>数量</TH>
                          	   <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
                          	   <TH scope=col>在途数量</TH>
                          	   </c:if> 
                          	</c:when>
                          	<c:when test="${goodscategory == '9' && empty(other)}">
                          		<TH scope=col>型号</TH>
                          		<TH scope=col>仓位</TH>
                          	    <TH scope=col>数量</TH>
                          	   <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
                          	   <TH scope=col>在途数量</TH>
                          	   </c:if>
                          	</c:when>
                          	<c:otherwise>
	                          	<TH scope=col>仓位</TH>
	                          	<TH scope=col>数量</TH>
                          	   <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
                          	   <TH scope=col>在途数量</TH>
                          	   </c:if>
                          	</c:otherwise>
						 </c:choose>
						  </TR>
						<s:iterator value="goodsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD  height="26"><input id=chk type="checkbox" goodsid="${bgigoodsid}" stockid="${bgiwarehouseid }" onClick="setSingleValue(this);"  value="{'bgiismutiluminosity':'${bgiismutiluminosity }','bgisungglassesfun':'${bgisungglassesfun }','bgistealthclass':'${bgistealthclass }','bgiusetype':'${bgiusetype }','bgiframematerialtype':'${bgiframematerialtype }','bgifunctionclass':'${bgifunctionclass }','bgirefractive':'${bgirefractive }','bgieyeglassmaterialtype':'${bgieyeglassmaterialtype }','bgisphul':'${bgisphul }','bgisphup':'${bgisphup }','bgicylul':'${bgicylul }','bgicylup':'${bgicylup }','bgisph':'${bgisph }','bgicyl':'${bgicyl }','bgiordercycle':'${bgiordercycle }','bgigoodsid':'${bgigoodsid}','bgigoodsname':'${bgigoodsname}','bgiretailprice':'${bgiretailprice }','bgigoodsbarcode':'${bgigoodsbarcode }','bgicostprice':'${bgicostprice }','bginottaxrate':'${bginottaxrate }','glassflag':'${rl}','iscustomize':'${ bgiiscustomize}','bgiwarehouseid':'${ bgiwarehouseid}','bgigoodscategoryid':'${bgigoodscategoryid }','bgigoodsquantity':'${bgigoodsquantity }','bgiishavestock':'${bgiishavestock }','maxdiscount':'${maxdiscount }','bgiintransitgoodsnum':'${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}','customerdiscount':'${customerdiscount}','maxgoodsquantity':'','bgidefaultdiscountvalue':'${bgidefaultdiscountvalue}'}"></TD>
                          <TD>${bgigoodsid}</TD>
                          <TD>${bgiviewgoodsname}${systemParameterPo.fspisusegoodslevel eq '1' ? bgidefaultdiscountvaluename : '' }</TD>
                          <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1'}"> 
                          <TD>${bgibrandname}</TD>
                          </c:if>
                          <c:if test="${othergoodscategory == '8'}">
                      	   		<td scope=col>${bgisph }</td>
                      	  </c:if>
                          <TD>${bgiretailprice}</TD>
                           <c:choose>
                            <c:when test="${goodscategory == '1' && not empty(other)}">
                               <TD scope=col >${bgiwarehousename}</TD>
						 	   <TD scope=col id='goodsquantity'>${bgigoodsquantity == '' ? '0':bgigoodsquantity}</TD>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                             <TD scope=col id="goodsquantity2"><a href="javascript:inTransitDetail('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid}','0');">${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}</a></TD>
	                           </c:if>
                            </c:when>
                          	<c:when test="${goodscategory == '1' && empty(other) && oneselfframe != 'ZZ'}">
                          	   <TD scope=col >${bgispec}</TD>
	                           <TD scope=col >${bgicolor}</TD>
	                           <TD scope=col >${bgieyeglassmaterialtypename}</TD>
	                           <TD scope=col >${bgiframesize}</TD>
	                           <TD scope=col >${bgiwarehousename}</TD>
						 	   <TD scope=col id='goodsquantity'>${bgigoodsquantity == '' ? '0':bgigoodsquantity}</TD>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                             <TD scope=col id="goodsquantity2"><a href="javascript:inTransitDetail('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid}','0');">${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}</a></TD>
	                           </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '1' && empty(other) && oneselfframe == 'ZZ'}">
                          	   <TD scope=col >${bgispec}</TD>
	                           <TD scope=col >${bgicolor} </TD>
	                           <TD scope=col >${bgieyeglassmaterialtypename}</TD>
	                           <TD scope=col >${bgiframesize}</TD>
                          	</c:when>
                          	<c:when test="${goodscategory == '2' && empty(other)}">
                          		<TD scope=col >${bgispec}</TD>
	                        	<TD scope=col >
		                          	<c:if test="${bgiaccessoriestype=='1'}">框镜</c:if>
		                          	<c:if test="${bgiaccessoriestype=='2'}">隐形</c:if>
	                           </TD>
	                           <TD scope=col >${bgiwarehousename}</TD>
						 	   <TD scope=col id='goodsquantity'>${bgigoodsquantity == '' ? '0':bgigoodsquantity}</TD>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                             <TD scope=col id="goodsquantity2"><a href="javascript:inTransitDetail('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid}','0');">${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}</a></TD>
	                           </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '3' && iscustomize=='0'  && empty(other) && oneselfframe != 'ZZ'}">
                          		<TD scope=col >${bgisph} </TD>
                          		<TD scope=col >${bgicyl} </TD>
                          		<TD scope=col >${bgibelowplusluminosity} </TD>
                          		<TD scope=col >${bgirefractive} </TD>
	                        	<TD scope=col >
		                          	<c:if test="${bgiismutiluminosity=='M'}">多光</c:if>
		                          	<c:if test="${bgiismutiluminosity=='0'}">单光</c:if>
		                          	<c:if test="${bgiismutiluminosity=='Q'}">其它</c:if>
		                          	<c:if test="${bgiismutiluminosity=='K'}">抗疲劳</c:if>
		                          	<c:if test="${bgiismutiluminosity=='J'}">渐近</c:if>
	                           </TD>
	                           <TD scope=col >
		                          	<c:if test="${bgieyeglassmaterialtype=='1'}">树脂</c:if>
		                          	<c:if test="${bgieyeglassmaterialtype=='2'}">玻璃</c:if>
		                          	<c:if test="${bgieyeglassmaterialtype=='3'}">PC</c:if>		                          	
	                           </TD>
	                           <TD scope=col >${bgiwarehousename}</TD>
						 	   <TD scope=col id='goodsquantity'>${bgigoodsquantity == '' ? '0':bgigoodsquantity}</TD>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                             <TD scope=col id="goodsquantity2"><a href="javascript:inTransitDetail('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid}','0');">${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}</a></TD>
	                           </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '3' && iscustomize=='0' && empty(other) && oneselfframe == 'ZZ'}">
                          		<TD scope=col >${bgisph} </TD>
                          		<TD scope=col >${bgicyl} </TD>
                          		<TD scope=col >${bgibelowplusluminosity} </TD>
                          		<TD scope=col >${bgirefractive} </TD>
	                        	<TD scope=col >
		                          	<c:if test="${bgiismutiluminosity=='M'}">多光</c:if>
		                          	<c:if test="${bgiismutiluminosity=='0'}">单光</c:if>
		                          	<c:if test="${bgiismutiluminosity=='Q'}">其它</c:if>
		                          	<c:if test="${bgiismutiluminosity=='K'}">抗疲劳</c:if>
		                          	<c:if test="${bgiismutiluminosity=='J'}">渐近</c:if>
	                           </TD>
	                           <TD scope=col >
		                          	<c:if test="${bgieyeglassmaterialtype=='1'}">树脂</c:if>
		                          	<c:if test="${bgieyeglassmaterialtype=='2'}">玻璃</c:if>
		                          	<c:if test="${bgieyeglassmaterialtype=='3'}">PC</c:if>		                          	
	                           </TD>
                          	</c:when>
                          	<c:when test="${goodscategory == '3' && iscustomize=='D'&& empty(other) }">
                          		<TD scope=col>${bgisphul} <c:if test="${not empty bgisphul}">/</c:if>   ${bgisphup } </TD>
                          		<TD scope=col>${bgicylul}<c:if test="${not empty bgicylul}">/</c:if>  ${bgicylup } </TD>
                          		<TD scope=col>${bgiaxis} </TD>
                          		<TD scope=col>${bgibelowplusluminosityul} <c:if test="${not empty bgibelowplusluminosityul}">/</c:if> ${bgibelowplusluminosityup } </TD>
                          		<TD scope=col>${bgirefractive}</TD>
                          		<TD scope=col>${bgispec} </TD>
	                        	<TD scope=col>
		                          	<c:if test="${bgiismutiluminosity=='M'}">多光</c:if>
		                          	<c:if test="${bgiismutiluminosity=='0'}">单光</c:if>
		                          	<c:if test="${bgiismutiluminosity=='Q'}">其它</c:if>
		                          	<c:if test="${bgiismutiluminosity=='K'}">抗疲劳</c:if>
		                          	<c:if test="${bgiismutiluminosity=='J'}">渐近</c:if>
	                            </TD>
	                            <TD scope=col>
		                          	<c:if test="${bgieyeglassmaterialtype=='1'}"> 树脂</c:if>
		                          	<c:if test="${bgieyeglassmaterialtype=='2'}"> 玻璃</c:if>
		                          	<c:if test="${bgieyeglassmaterialtype=='3'}"> PC</c:if>		                          	
	                            </TD>
                          		
                          		<TD scope=col >
		                          	<c:if test="${bgigradualclass=='1'}">青少年渐进</c:if>
		                          	<c:if test="${bgigradualclass=='2'}"> 成人渐进</c:if>	                          	
	                           </TD>
	                           
	                           <TD scope=col >
		                          	<c:if test="${bgifunctionclass=='1'}">白色片</c:if>
		                          	<c:if test="${bgifunctionclass=='2'}">变色片</c:if>	 
		                          	<c:if test="${bgifunctionclass=='3'}">偏光片</c:if>
		                          	<c:if test="${bgifunctionclass=='4'}"> 变色偏光片</c:if>	
		                          	<c:if test="${bgifunctionclass=='5'}">染色片</c:if>
		                          	<c:if test="${bgifunctionclass=='6'}"> 抗疲劳片</c:if>
		                          	<c:if test="${bgifunctionclass=='7'}"> 抗疲劳变色片</c:if>
		                          	<c:if test="${bgifunctionclass=='8'}"> 偏光抗疲劳片</c:if>	                         	
	                           </TD>
                          	   <TD scope=col >${bgiordercycle}<c:if test="${not empty bgiordercycle}">天</c:if> </TD>
                          	   <TD scope=col >${bgiwarehousename}</TD>
                          	</c:when>
                          	<c:when test="${goodscategory == '4' && iscustomize=='0' && empty(other)}">
                          		<TD scope=col >${bgisph} </TD>
                          		<TD scope=col >${bgicyl} </TD>
                          		<TD scope=col >${bgicurvature1} </TD>
                          		<TD scope=col >${bgidia} </TD>
	                        	<TD scope=col >
		                          	<c:if test="${bgiusetype=='1'}"> 常带型</c:if>
		                          	<c:if test="${bgiusetype=='2'}">抛弃型</c:if>
		                          	<c:if test="${bgiusetype=='3'}">塑形镜</c:if>		                          	
	                           </TD>
	                           <TD scope=col >
		                          	<c:if test="${bgistealthclass=='1'}"> 日抛</c:if>
		                          	<c:if test="${bgistealthclass=='2'}"> 周抛</c:if>
		                          	<c:if test="${bgistealthclass=='9'}"> 双周抛</c:if>
		                          	<c:if test="${bgistealthclass=='3'}"> 月抛</c:if>		
		                          	<c:if test="${bgistealthclass=='4'}"> 季抛</c:if>
		                          	<c:if test="${bgistealthclass=='5'}"> 半年抛</c:if>
		                          	<c:if test="${bgistealthclass=='6'}"> 年抛</c:if>	  
		                          	<c:if test="${bgistealthclass=='7'}"> RGP</c:if>	                         	
	                           </TD>
	                           <TD scope=col >${bgiwarehousename}</TD>
						 	   <TD scope=col id='goodsquantity'>${bgigoodsquantity == '' ? '0':bgigoodsquantity}</TD>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                             <TD scope=col id="goodsquantity2"><a href="javascript:inTransitDetail('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid}','0');">${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}</a></TD>
	                           </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '4' && iscustomize=='D'  && empty(other)}">
                          		<TD scope=col >${bgisphul} <c:if test="${not empty bgisphul}">/</c:if> ${bgisphup } </TD>
                          		<TD scope=col >${bgicylul} <c:if test="${not empty bgicylul}">/</c:if>  ${bgicylup } </TD>
                          		<TD scope=col >${bgiaxisul} <c:if test="${not empty bgiaxisul}">/</c:if> ${bgiaxisup } </TD>
                          		<TD scope=col >${bgicurvature1ul} <c:if test="${not empty bgicurvature1ul}">/</c:if> ${bgicurvature1up } </TD>
                          		<TD scope=col >${bgicurvature2ul} <c:if test="${not empty bgicurvature2ul}">/</c:if>  ${bgicurvature2up } </TD>
                          		<TD scope=col >${bgispec} </TD>
	                        	<TD scope=col >
		                          	<c:if test="${bgiusetype=='1'}">  常带型</c:if>
		                          	<c:if test="${bgiusetype=='2'}"> 抛弃型</c:if>
		                          	<c:if test="${bgiusetype=='3'}"> 塑形镜</c:if>
	                           </TD>
	                           <TD scope=col >
		                          <c:if test="${bgistealthclass=='1'}"> 日抛</c:if>
		                          	<c:if test="${bgistealthclass=='2'}"> 周抛</c:if>
		                          	<c:if test="${bgistealthclass=='9'}"> 双周抛</c:if>
		                          	<c:if test="${bgistealthclass=='3'}"> 月抛</c:if>		
		                          	<c:if test="${bgistealthclass=='4'}"> 季抛</c:if>
		                          	<c:if test="${bgistealthclass=='5'}"> 半年抛</c:if>
		                          	<c:if test="${bgistealthclass=='6'}"> 年抛</c:if>	  
		                          	<c:if test="${bgistealthclass=='7'}"> RGP</c:if>	                          	
	                           </TD>
                          		<TD scope=col >${bgiordercycle}<c:if test="${not empty bgiordercycle}">天</c:if> </TD>
                          		<TD scope=col >${bgiwarehousename}</TD>
                          	</c:when>
                          	<c:when test="${goodscategory == '5' && empty(other)}">
                          		<TD scope=col >${bgispec} </TD>
                          		<TD scope=col >${bgicapacity} </TD>
                          		<TD scope=col >${bgicapacityentry} </TD>
                          		<TD scope=col >${bgiwarehousename}</TD>
						 	    <TD scope=col id='goodsquantity'>${bgigoodsquantity == '' ? '0':bgigoodsquantity}</TD>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                             <TD scope=col id="goodsquantity2"><a href="javascript:inTransitDetail('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid}','0');">${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}</a></TD>
	                           </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '6' && empty(other)}">
                          		<TD scope=col >${bgispec} </TD>
                          		<TD scope=col >${bgicolor} </TD>
                          		<TD scope=col >${bgiframesize} </TD>
                          		<TD scope=col >${bgiwarehousename}</TD>
						 	    <TD scope=col id='goodsquantity'>${bgigoodsquantity == '' ? '0':bgigoodsquantity}</TD>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                             <TD scope=col id="goodsquantity2"><a href="javascript:inTransitDetail('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid}','0');">${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}</a></TD>
	                           </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '8' && empty(other)}">
                          		<TD scope=col >${bgisph} </TD>
                          		<TD scope=col >${bgispec} </TD>
                          		<TD scope=col >${bgiframesize} </TD>
                          		<TD scope=col >${bgisuppliercolor} </TD>
                          		<TD scope=col >${bgiwarehousename}</TD>
						 	    <TD scope=col id='goodsquantity'>${bgigoodsquantity == '' ? '0':bgigoodsquantity}</TD>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                             <TD scope=col id="goodsquantity2"><a href="javascript:inTransitDetail('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid}','0');">${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}</a></TD>
	                           </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '9' && empty(other)}">
                          		<TD scope=col >${bgispec} </TD>
                          		<TD scope=col >${bgiwarehousename}</TD>
						 	    <TD scope=col id='goodsquantity'>${bgigoodsquantity == '' ? '0':bgigoodsquantity}</TD>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                             <TD scope=col id="goodsquantity2"><a href="javascript:inTransitDetail('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid}','0');">${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}</a></TD>
	                           </c:if>
                          	</c:when>
                          	<c:otherwise>
                          		<TD scope=col >${bgiwarehousename}</TD>
						 	    <TD scope=col id='goodsquantity'>${bgigoodsquantity == '' ? '0':bgigoodsquantity}</TD>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                             <TD scope=col id="goodsquantity2"><a href="javascript:inTransitDetail('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid}','0');">${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}</a></TD>
	                           </c:if>
                          	</c:otherwise>                	
						 </c:choose>
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
</body>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>