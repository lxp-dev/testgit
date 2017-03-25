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
		setCheckValue();
	});

	function setCheckValue(){
        $("input[id=chk]").each(function(){
      	  for(var i = 0; i < parent.$('input[name=salesDetailPo.ssesditemids]').size(); i++){
          	  if(parent.$('input[name=salesDetailPo.ssesditemids]').eq(i).val() != ''){
          		if(parent.$('input[name=salesDetailPo.ssesditemids]').eq(i).val().substring(0,1) == '3' || parent.$('input[name=salesDetailPo.ssesditemids]').eq(i).val().substring(0,1) == '4'){
						if($(this).attr("goodsbarcode") == parent.$('input[name=salesDetailPo.ssesditemids]').eq(i).val() && '${rl}' == parent.$('input[name=salesDetailPo.ssesdglassflags]').eq(i).val()&& $(this).attr("stockid") == parent.$('input[name=salesDetailPo.ssesdstockids]').eq(i).val()){
							$(this).attr("checked","checked");
						}
          	  	}else{
          	  		if($(this).attr("goodsbarcode") == parent.$('input[name=salesDetailPo.ssesditemids]').eq(i).val()&& $(this).attr("stockid") == parent.$('input[name=salesDetailPo.ssesdstockids]').eq(i).val()){
							$(this).attr("checked","checked");
						}
              	}
                }
         	  }
		});
  	}

	function setSingleValue1(goodsid,goodsbarcode,stockid){
		var obj = $("input[id=chk][goodsid="+ goodsid +"][goodsbarcode="+ goodsbarcode +"][stockid="+ stockid +"]");
		obj.click();
		parent.hidePopWin();
		parent.$("#inputscanbarcode").focus();
	}
	
	function setSingleValue(obj){
		//alert(obj.checked);
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
        	for(var i = 0; i < parent.$('input[name=salesDetailPo.ssesditemids]').size(); i++){
        		if(parent.$('input[name=salesDetailPo.ssesditemids]').eq(i).val() == objValue.bgigoodsbarcode && parent.$('input[name=salesDetailPo.ssesdglassflags]').eq(i).val()==objValue.glassflag){
        			window.parent.deleteItem(parent.$('input[name=salesDetailPo.ssesditemids]').eq(i),'1');
			        window.parent.totalamount();
	        	}
	    	}
      	  }else{
        		window.parent.deleteItem(parent.$('input[value='+objValue.bgigoodsbarcode+']'),'1');
		        window.parent.totalamount();
          }
      }
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
		    if (json.bgigoodscategoryid == '8'){
		        parent.setCategory('老花镜');
		        json.glassflag = 'A';
		    }
		    if (json.bgigoodscategoryid == '9'){
		        parent.setCategory('视光商品');
		        json.glassflag = 'A';
		    }
		    if (json.bgigoodscategoryid != '1' && json.bgigoodscategoryid != '2' && json.bgigoodscategoryid != '6' && json.bgigoodscategoryid != '8'&& json.bgigoodscategoryid != '9'){
		        parent.setCategory('耗材');
		        json.glassflag = 'A';
		    }
		}
		
		json.maxgoodsquantity = accSub(Number(json.bgigoodsquantity),Number(json.bgiintransitgoodsnum));
		
	    if (parent.$('input[name=salestype][checked]').val() == '1'){
		    if(!parent.checkFrameSales(json.glassflag)){
		    	$("input[goodsbarcode="+json.bgigoodsbarcode+"][stockid="+json.bgiwarehouseid+"]").attr("checked","");
			    return;
		    }
	    }
	    if (parent.$('input[name=salestype][checked]').val() == '3'){
		    if(!parent.checkContactSales(json.bgigoodsid,json.glassflag)){
		    	$("input[goodsbarcode="+json.bgigoodsbarcode+"]").attr("checked","");
			    return;
		    }
	    }
	    if('${systemParameterPo.fspsalestype}' == '1'){
	    	parent.addGoods(json);
	    	/*
	    	if (json.bgigoodscategoryid == '1'||json.bgigoodscategoryid == '2'||json.bgigoodscategoryid == '5'||json.bgigoodscategoryid == '6'||json.bgigoodscategoryid == '8'||json.bgigoodscategoryid == '7' && parent.$("input[id=salestype_input]").val() == '1'){
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
							if(accAdd(1,parseFloat(parent.$('input[name=salesDetailPo.ssesditemids][value='+json.bgigoodsbarcode+']').parent().parent().parent().find("input[name=salesDetailPo.ssesdnumbers]").val())) > parseFloat(json.maxgoodsquantity)){
								alert("该商品库存不足！");
								$("input[goodsbarcode="+json.bgigoodsbarcode+"]").attr("checked","");
								return;
							}
						}else{
							alert("该商品库存不足！");
							$("input[goodsbarcode="+json.bgigoodsbarcode+"]").attr("checked","");
							return;
						}
					}
				}else if($('#iscustomize').val() != 'D'){
					if(accAdd(1,parseFloat(parent.$('input[name=salesDetailPo.ssesditemids][value='+json.bgigoodsbarcode+']').parent().parent().parent().find("input[name=salesDetailPo.ssesdnumbers]").val())) > parseFloat(json.maxgoodsquantity)){
						alert("该商品库存不足！");
						$("input[goodsbarcode="+json.bgigoodsbarcode+"]").attr("checked","");
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
				$("input[goodsbarcode="+json.bgigoodsbarcode+"]").attr("checked","");
				return;
			}
		}
	}

	function RorL(obj){
		var kucun = $('#kucun').val();
		if (obj.value == 'D'){
			kucun = '0';
		}
		goodsForm.action="scanGoodsSelAllNew.action?rl="+$("input[name=rightOrleft][checked]").val()+'&kucun='+kucun;
		goodsForm.submit();
	}
	
	function changeKun(){
		goodsForm.action="scanGoodsSelAllNew.action?kucun="+$('#kucun').val()+"&rl="+$("input[name=rightOrleft][checked]").val();
		goodsForm.submit();
	}
</script>
<!-- oncontextmenu="event.returnValue=false"  onhelp="Showhelp();return false;"-->
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="goodscategory" name="goodscategory" value="${goodscategory }" />
<input type="hidden" name="rsph" value="${rsph}"/>
<input type="hidden" name="rcyl" value="${rcyl}"/>
<input type="hidden" name="radd" value="${radd}"/>
<input type="hidden" name="lsph" value="${lsph}"/>
<input type="hidden" name="lcyl" value="${lcyl}"/>
<input type="hidden" name="ladd" value="${ladd}"/>
<input type="hidden" name="goodsbar" value="${goodsbar}"/>
<input type="hidden" name="recipeType" value="${recipeType}"/>
<input type="hidden" name="lrecipeType" value="${lrecipeType}"/>
<input type="hidden" name="lglassFlag" value="${lglassFlag}"/>
<input type="hidden" name="lsyjp" value="${lsyjp}"/>
<input type="hidden" name="glassFlag" value="${glassFlag}"/>
<input type="hidden" name="syjp" value="${syjp}"/>
<input type="hidden" name="direction" value="${direction}"/>
<input type="hidden" id="customertype" name="customertype" value="${customertype }" />
<input type="hidden" id="runionsphcyl" name="runionsphcyl" value="${runionsphcyl }" />
<input type="hidden" id="lunionsphcyl" name="lunionsphcyl" value="${lunionsphcyl }" />

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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>	
					  <table width="100%" border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder">
                      <TBODY>
                      	<c:if test="${goodscategory == '3' || goodscategory == '4'}">
                        <tr class=table_title align=left height="26">
              				<td colspan="20">
              					<input type="radio" name="rightOrleft" value="R" onclick="RorL(this)" ${rl == 'R' ? 'checked=checked':'' }/>右眼镜片&nbsp;&nbsp;&nbsp;<input type="radio" name="rightOrleft" value="L" onclick="RorL(this)" ${rl == 'L' ? 'checked=checked':'' }/>左眼镜片
              					<select id="iscustomize" name="iscustomize" onchange="RorL(this)">
              						<option value="0" ${iscustomize != '0' ? '':'selected=selected'}>成品片</option>
              						<option value="D" ${iscustomize != 'D' ? '':'selected=selected'}>订制片</option>
              					</select>
              				</td>
              			</tr>
              			</c:if>
              		<c:if test="${systemParameterPo.fspsalestype == '1' && iscustomize ne 'D' && systemParameterPo.fspquerygoodsstorage == '2'}">	
              			<TR class=table_title align=middle>
              			   <TH scope=col width="6%" height="26">库存状态</TH>
              			   <TH scope=col colspan="20" align="left">
              			   	<SELECT id="kucun" name="kucun" onchange="changeKun();">
              			        <option value="1" ${kucun=='1'?'selected="selected"':''}>大于0</option>
                           	    <option value="0" ${kucun=='0'?'selected="selected"':''}>全部</option>                           	
                            </SELECT>
              			   </TH>
              			</TR>
              		</c:if>
              		<c:if test="${systemParameterPo.fspsalestype != '1'}">	
              			<input type="hidden" id="kucun" name="kucun" value="${kucun}">
              		</c:if>
              		
                        <TR class=table_title align=middle>
                          <TH scope=col height="26" colspan="2">
						    操作</TH>
                           <c:choose>
                          	<c:when test="${goodscategory == '1' }">
                          	<TH scope=col width="13%">商品代码</TH>
                          	<TH scope=col width="15%">商品条码</TH>
	                          <TH scope=col>商品名称</TH>
	                          <TH scope=col width="8%">销售价格</TH>
                          	   <TH scope=col width="10%">型号</TH>
	                           <TH scope=col width="10%">色号 </TH>
	                           <TH scope=col width="7%">镜架材质 </TH>
	                           <TH scope=col width="7%">镜架尺寸</TH> 
	                           <TH scope=col width="13%">仓位</TH>
	                           <c:if test="${systemParameterPo.fspsalestype == '0' || (systemParameterPo.fspsalestype == '1' && systemParameterPo.fspquerygoodsstorage == '2')}"> 
	                           <TH scope=col width="5%">数量</TH>
	                           </c:if>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                           <TH scope=col width="5%">在途数量</TH> 
	                           </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '2' }">
                          		<TH scope=col>商品代码</TH>
                          		<TH scope=col>商品条码</TH>
	                         	<TH scope=col>商品名称</TH>
	                          	<TH scope=col>销售价格</TH>
                          		<TH scope=col>型号</TH>
	                           	<TH scope=col>配件型 </TH>
	                           	<TH scope=col>仓位</TH>
	                           	<c:if test="${systemParameterPo.fspsalestype == '0' || (systemParameterPo.fspsalestype == '1' && systemParameterPo.fspquerygoodsstorage == '2')}"> 
                          	    <TH scope=col>数量</TH>
                          	    </c:if>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                           <TH scope=col width="5%">在途数量</TH> 
	                           </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '3' && iscustomize=='0' }">
                          		<TH scope=col>商品代码</TH>
	                          	<TH scope=col>商品名称</TH>
	                          	<TH scope=col>销售价格</TH>
	                          	<TH scope=col>球镜</TH>
	                           	<TH scope=col>柱镜 </TH>
	                           	<TH scope=col>下加光 </TH>
	                           	<TH scope=col>折射率</TH> 
	                           	<TH scope=col>光度分类 </TH>
	                           	<TH scope=col>材料分类</TH> 
	                           	<TH scope=col>仓位</TH>
	                           	<c:if test="${systemParameterPo.fspsalestype == '0' || (systemParameterPo.fspsalestype == '1' && systemParameterPo.fspquerygoodsstorage == '2')}"> 
	                            <TH scope=col>数量</TH>
	                            </c:if>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                           <TH scope=col width="5%">在途数量</TH> 
	                           </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '3' && iscustomize=='D' }">
                          		<TH scope=col>商品代码</TH>
	                          	<TH scope=col>商品名称</TH>
	                          	<TH scope=col>销售价格</TH>
	                          	<TH scope=col>球镜区间</TH>
	                           	<TH scope=col>柱镜区间 </TH>
	                           	<TH scope=col>下加光区间</TH> 
	                           	<TH scope=col>折射率 </TH>
                          		<TH scope=col>光度分类</TH> 
                          		<TH scope=col>材料分类</TH> 
                          		<TH scope=col>渐进片分类</TH> 
                          		<TH scope=col>镜片功能</TH> 
                          		<TH scope=col>订做周期</TH> 
                          		<TH scope=col>仓位</TH>
                          	</c:when>
                          	<c:when test="${goodscategory == '4' && iscustomize=='0' }">
                          		<TH scope=col width="14%">商品代码</TH>
                          		<TH scope=col width="14%">商品条码</TH>
	                          	<TH scope=col>商品名称</TH>
	                          	<TH scope=col width="8%">销售价格</TH>
	                          	<TH scope=col width="7%">球镜</TH>
	                           	<TH scope=col width="7%">柱镜 </TH>
	                           	<TH scope=col width="7%">曲率 </TH>
	                           	<TH scope=col width="7%">直径</TH> 
	                           	<TH scope=col width="7%">使用类型 </TH>
	                           	<TH scope=col width="7%">抛弃型分类</TH>         
	                           	<TH scope=col width="8%">仓位</TH>
	                           	<c:if test="${systemParameterPo.fspsalestype == '0' || (systemParameterPo.fspsalestype == '1' && systemParameterPo.fspquerygoodsstorage == '2')}"> 
	                            <TH scope=col width="5%">数量</TH>
	                            </c:if>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                           <TH scope=col width="5%">在途数量</TH> 
	                           </c:if>               	
                          	</c:when>
                          	<c:when test="${goodscategory == '4' && iscustomize=='D' }">
                          		<TH scope=col width="14%">商品代码</TH>
	                          	<TH scope=col>商品名称</TH>
	                          	<TH scope=col width="8%">销售价格</TH>
	                          	<TH scope=col width="6%">球镜区间</TH>
	                           	<TH scope=col width="6%">柱镜区间 </TH>
	                           	<TH scope=col width="6%">轴位区间 </TH>
	                           	<TH scope=col width="6%">曲率1区间</TH> 
                          		<TH scope=col width="5%">使用类型</TH> 
                          		<TH scope=col width="5%">抛弃型分类</TH> 
                          		<TH scope=col width="5%">订做周期</TH> 
                          		<TH scope=col width="8%">仓位</TH>
                          	</c:when>
                          	<c:when test="${goodscategory == '5' }">
                          		<TH scope=col>商品代码</TH>
                          		<TH scope=col>商品条码</TH>
	                         	<TH scope=col>商品名称</TH>
	                          	<TH scope=col>销售价格</TH>
                          		<TH scope=col>型号</TH>
	                           	<TH scope=col>主容量 </TH>
	                           	<TH scope=col>次容量 </TH>
	                           	<TH scope=col>仓位</TH>
	                           	<c:if test="${systemParameterPo.fspsalestype == '0' || (systemParameterPo.fspsalestype == '1' && systemParameterPo.fspquerygoodsstorage == '2')}"> 
	                            <TH scope=col>数量</TH>
	                            </c:if>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                           <TH scope=col width="5%">在途数量</TH> 
	                           </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '6' }">
                          		<TH scope=col>商品代码</TH>
                          		<TH scope=col>商品条码</TH>
	                         	<TH scope=col>商品名称</TH>
	                          	<TH scope=col>销售价格</TH>	                          
                          		<TH scope=col>型号</TH>
	                           	<TH scope=col>颜色 </TH>
	                           	<TH scope=col>镜架尺寸 </TH>
	                           	<TH scope=col>仓位</TH>
	                           	<c:if test="${systemParameterPo.fspsalestype == '0' || (systemParameterPo.fspsalestype == '1' && systemParameterPo.fspquerygoodsstorage == '2')}"> 
	                            <TH scope=col>数量</TH>
	                            </c:if>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                           <TH scope=col width="5%">在途数量</TH> 
	                           </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '8' }">
                          		<TH scope=col>商品代码</TH>
                          		<TH scope=col>商品条码</TH>
	                         	<TH scope=col>商品名称</TH>
	                          	<TH scope=col>销售价格</TH>	                          
                          		<TH scope=col>老花镜度数</TH>
	                           	<TH scope=col>型号 </TH>
	                           	<TH scope=col>镜架尺寸 </TH>  
	                           	<TH scope=col>厂家色号 </TH> 
	                           	<TH scope=col>仓位</TH>
	                           	<c:if test="${systemParameterPo.fspsalestype == '0' || (systemParameterPo.fspsalestype == '1' && systemParameterPo.fspquerygoodsstorage == '2')}"> 
	                            <TH scope=col>数量</TH>
	                            </c:if>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                           <TH scope=col width="5%">在途数量</TH> 
	                           </c:if>                    		
                          	</c:when>
                          	<c:when test="${goodscategory == '9' }">
                          		<TH scope=col>商品代码</TH>
                          		<TH scope=col>商品条码</TH>
	                         	<TH scope=col>商品名称</TH>
	                          	<TH scope=col>销售价格</TH>
                          		<TH scope=col>型号</TH>
                          		<TH scope=col>仓位</TH>
                          		<c:if test="${systemParameterPo.fspsalestype == '0' || (systemParameterPo.fspsalestype == '1' && systemParameterPo.fspquerygoodsstorage == '2')}"> 
	                            <TH scope=col>数量</TH>
	                            </c:if>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                           <TH scope=col width="5%">在途数量</TH> 
	                           </c:if> 
                          	</c:when>
                          	<c:otherwise>
                          		<TH scope=col>商品代码</TH>
                          		<TH scope=col>商品条码</TH>
	                         	<TH scope=col>商品名称</TH>
	                          	<TH scope=col>销售价格</TH>
	                          	<c:if test="${systemParameterPo.fspsalestype == '0' || (systemParameterPo.fspsalestype == '1' && systemParameterPo.fspquerygoodsstorage == '2')}"> 
	                          	<TH scope=col>数量</TH>
	                          	</c:if>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                           <TH scope=col width="5%">在途数量</TH> 
	                           </c:if>
                          	</c:otherwise>
						 </c:choose>                                                                                                             
						  </TR>
						<s:iterator value="goodsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD  height="26"><input id=chk type="checkbox" goodsid="${bgigoodsid}" goodsbarcode="${bgigoodsbarcode}" stockid="${bgiwarehouseid }" onClick="setSingleValue(this);"  value="{'bgiismutiluminosity':'${bgiismutiluminosity }','bgisungglassesfun':'${bgisungglassesfun }','bgistealthclass':'${bgistealthclass }','bgiusetype':'${bgiusetype }','bgiframematerialtype':'${bgiframematerialtype }','bgifunctionclass':'${bgifunctionclass }','bgirefractive':'${bgirefractive }','bgieyeglassmaterialtype':'${bgieyeglassmaterialtype }','bgisphul':'${bgisphul }','bgisphup':'${bgisphup }','bgicylul':'${bgicylul }','bgicylup':'${bgicylup }','bgisph':'${bgisph }','bgicyl':'${bgicyl }','bgiordercycle':'${bgiordercycle }','bgigoodsid':'${bgigoodsid}','bgigoodsname':'${bgigoodsname}','bgiretailprice':'${bgiretailprice }','bgigoodsbarcode':'${bgigoodsbarcode }','bgicostprice':'${bgicostprice }','bginottaxrate':'${bginottaxrate }','glassflag':'${rl}','iscustomize':'${ bgiiscustomize}','bgiwarehouseid':'${ bgiwarehouseid}','bgigoodsquantity':'${empty(bgigoodsquantity) ? '0':bgigoodsquantity}','bgigoodscategoryid':'${bgigoodscategoryid }','bgigoodsquantity':'${bgigoodsquantity }','maxdiscount':'${maxdiscount }','bgiishavestock':'${bgiishavestock }','bgiintransitgoodsnum':'${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}','customerdiscount':'${customerdiscount}','maxgoodsquantity':'','bgidefaultdiscountvalue':'${bgidefaultdiscountvalue}'}"></TD>
						  <TD  height="26"><img src="${ctx }/img/newbtn/select_0.png" btn=btn title='选择并关闭页面' onClick="javascript:setSingleValue1('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid }')"></TD>
                          <TD>${bgigoodsid}</TD>
                      <c:if test="${goodscategory == '1' || goodscategory == '2' || goodscategory == '5' || goodscategory == '6' || goodscategory == '7' || goodscategory == '8' || goodscategory == '9' || (goodscategory == '4' && iscustomize=='0')}">        
                          <TD>${bgigoodsbarcode}</TD>
                      </c:if>    
                          <TD>${bgiviewgoodsname}${systemParameterPo.fspisusegoodslevel eq '1' ? bgidefaultdiscountvaluename : '' }</TD>
                          <TD>${bgiretailprice}</TD>
                         <c:choose>
                          	<c:when test="${goodscategory == '1' }">
                          	   <TD scope=col >${bgispec}</TD>
	                           <TD scope=col >${bgicolor} </TD>
	                           <TD scope=col >${bgieyeglassmaterialtypename }</TD>
	                           <TD scope=col >${bgiframesize}</TD> 
	                           <TD scope=col >${bgiwarehousename}</TD>
	                           <c:if test="${systemParameterPo.fspsalestype == '0' || (systemParameterPo.fspsalestype == '1' && systemParameterPo.fspquerygoodsstorage == '2')}"> 
	                           <TD scope=col id="goodsquantity">${empty(bgigoodsquantity) ? '0':bgigoodsquantity}</TD>
	                           </c:if>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                             <TD scope=col id="goodsquantity2">${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}</TD>
	                           </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '2' }">
                          		<TD scope=col >${bgispec}</TD>
	                        	<TD scope=col >
		                          	<c:if test="${bgiaccessoriestype=='1'}">框镜</c:if>
		                          	<c:if test="${bgiaccessoriestype=='2'}">隐形</c:if>
	                           </TD>
	                           <TD scope=col >${bgiwarehousename}</TD>
	                           <c:if test="${systemParameterPo.fspsalestype == '0' || (systemParameterPo.fspsalestype == '1' && systemParameterPo.fspquerygoodsstorage == '2')}"> 
						 	   <TD scope=col id='goodsquantity'>${bgigoodsquantity == '' ? '0':bgigoodsquantity}</TD>
						 	   </c:if>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                             <TD scope=col id="goodsquantity2"><a href="javascript:inTransitDetail('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid}','0');">${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}</a></TD>
	                           </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '3' && iscustomize=='0'  }">
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
		                          	<c:if test="${bgieyeglassmaterialtype=='1'}"> 树脂</c:if>
		                          	<c:if test="${bgieyeglassmaterialtype=='2'}"> 玻璃</c:if>
		                          	<c:if test="${bgieyeglassmaterialtype=='3'}"> PC</c:if>		                          	
	                           </TD>
                          	   <TD scope=col >${bgiwarehousename}</TD>
                          	   <c:if test="${systemParameterPo.fspsalestype == '0' || (systemParameterPo.fspsalestype == '1' && systemParameterPo.fspquerygoodsstorage == '2')}"> 
	                           <TD scope=col id="goodsquantity">${empty(bgigoodsquantity) ? '0':bgigoodsquantity}</TD>
	                           </c:if>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                             <TD scope=col id="goodsquantity2"><a href="javascript:inTransitDetail('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid}','0');">${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}</a></TD>
	                           </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '3' && iscustomize=='D' }">
                          		<TD scope=col >${bgisphul} <c:if test="${not empty bgisphul}">/</c:if>   ${bgisphup } </TD>
                          		<TD scope=col >${bgicylul}<c:if test="${not empty bgicylul}">/</c:if>  ${bgicylup } </TD>
                          		<TD scope=col >${bgiaxis} </TD>
                          		<TD scope=col >${bgirefractive} </TD>
	                        	<TD scope=col >
		                          	<c:if test="${bgiismutiluminosity=='M'}">  多光</c:if>
		                          	<c:if test="${bgiismutiluminosity=='0'}"> 单光</c:if>
		                          	<c:if test="${bgiismutiluminosity=='Q'}"> 其它</c:if>
		                          	<c:if test="${bgiismutiluminosity=='K'}"> 抗疲劳</c:if>
		                          	<c:if test="${bgiismutiluminosity=='J'}"> 渐近</c:if>
	                           </TD>
	                           <TD scope=col >
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
                          	<c:when test="${goodscategory == '4' && iscustomize=='0' }">
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
                          	   <c:if test="${systemParameterPo.fspsalestype == '0' || (systemParameterPo.fspsalestype == '1' && systemParameterPo.fspquerygoodsstorage == '2')}"> 
	                           <TD scope=col id="goodsquantity">${empty(bgigoodsquantity) ? '0':bgigoodsquantity}</TD>
	                           </c:if>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                             <TD scope=col id="goodsquantity2"><a href="javascript:inTransitDetail('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid}','0');">${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}</a></TD>
	                           </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '4' && iscustomize=='D'  }">
                          		<TD scope=col >${bgisphul} <c:if test="${not empty bgisphul}">/</c:if> ${bgisphup } </TD>
                          		<TD scope=col >${bgicylul} <c:if test="${not empty bgicylul}">/</c:if>  ${bgicylup } </TD>
                          		<TD scope=col >${bgiaxisul} <c:if test="${not empty bgiaxisul}">/</c:if> ${bgiaxisup } </TD>
                          		<TD scope=col >${bgicurvature1ul} <c:if test="${not empty bgicurvature1ul}">/</c:if> ${bgicurvature1up } </TD>
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
                          		<TD scope=col >${bgiordercycle} <c:if test="${not empty bgiordercycle}">天</c:if> </TD>
                          		<TD scope=col >${bgiwarehousename}</TD>
                          	</c:when>
                          	<c:when test="${goodscategory == '5' }">
                          		<TD scope=col >${bgispec} </TD>
                          		<TD scope=col >${bgicapacity} </TD>
                          		<TD scope=col >${bgicapacityentry} </TD>
                          		<TD scope=col >${bgiwarehousename}</TD>
                          		<c:if test="${systemParameterPo.fspsalestype == '0' || (systemParameterPo.fspsalestype == '1' && systemParameterPo.fspquerygoodsstorage == '2')}"> 
	                           <TD scope=col id="goodsquantity">${empty(bgigoodsquantity) ? '0':bgigoodsquantity}</TD>
	                           </c:if>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                             <TD scope=col id="goodsquantity2"><a href="javascript:inTransitDetail('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid}','0');">${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}</a></TD>
	                           </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '6' }">
                          		<TD scope=col >${bgispec} </TD>
                          		<TD scope=col >${bgicolor} </TD>
                          		<TD scope=col >${bgiframesize} </TD>
                          		<TD scope=col >${bgiwarehousename}</TD>
                          		<c:if test="${systemParameterPo.fspsalestype == '0' || (systemParameterPo.fspsalestype == '1' && systemParameterPo.fspquerygoodsstorage == '2')}"> 
	                            <TD scope=col id="goodsquantity">${empty(bgigoodsquantity) ? '0':bgigoodsquantity}</TD>
	                            </c:if>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                             <TD scope=col id="goodsquantity2"><a href="javascript:inTransitDetail('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid}','0');">${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}</a></TD>
	                           </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '8' }">
                          		<TD scope=col >${bgisph} </TD>
                          		<TD scope=col >${bgispec} </TD>
                          		<TD scope=col >${bgiframesize} </TD>
                          		<TD scope=col >${bgisuppliercolor} </TD>
                          		<TD scope=col >${bgiwarehousename}</TD>
                          		<c:if test="${systemParameterPo.fspsalestype == '0' || (systemParameterPo.fspsalestype == '1' && systemParameterPo.fspquerygoodsstorage == '2')}"> 
	                            <TD scope=col id="goodsquantity">${empty(bgigoodsquantity) ? '0':bgigoodsquantity}</TD>
	                            </c:if>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                             <TD scope=col id="goodsquantity2"><a href="javascript:inTransitDetail('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid}','0');">${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}</a></TD>
	                           </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '9' }">
                          		<TD scope=col >${bgispec}</TD>
                          		<TD scope=col >${bgiwarehousename}</TD>
                          		<c:if test="${systemParameterPo.fspsalestype == '0' || (systemParameterPo.fspsalestype == '1' && systemParameterPo.fspquerygoodsstorage == '2')}"> 
	                            <TD scope=col id="goodsquantity">${empty(bgigoodsquantity) ? '0':bgigoodsquantity}</TD>
	                            </c:if>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                             <TD scope=col id="goodsquantity2"><a href="javascript:inTransitDetail('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid}','0');">${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}</a></TD>
	                           </c:if>
                          	</c:when>
                          	<c:when test="${goodscategory == '7' }">
                          		<c:if test="${systemParameterPo.fspsalestype == '0' || (systemParameterPo.fspsalestype == '1' && systemParameterPo.fspquerygoodsstorage == '2')}"> 
	                            <TD scope=col id="goodsquantity">${empty(bgigoodsquantity) ? '0':bgigoodsquantity}</TD>
	                            </c:if>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
	                             <TD scope=col id="goodsquantity2"><a href="javascript:inTransitDetail('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid}','0');">${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}</a></TD>
	                           </c:if>
                          	</c:when>
						 </c:choose>
                       </TR>
                          </s:iterator>
                      </TBODY>
                    </TABLE>
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