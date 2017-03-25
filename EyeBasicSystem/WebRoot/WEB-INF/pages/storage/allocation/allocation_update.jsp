<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/printBarcode.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>商品调拨管理</title>
</head>
<script>
//-----------向下复制数量-------------------------
var indexBasic=1;
var status = 1;
function goodsquantityAdd(obj){
	var table = document.getElementById('addTable');
	var index = table.rows.length-1;
	var id = obj.getAttribute('goodsquantity');

	if(confirm("是否向下复制数量?")){
		for(var i=parseInt(id.substring(13,id.length));i<parseInt(indexBasic);i++){
			if($('input[goodsquantity=goodsquantity'+i+']')){
				$('input[goodsquantity=goodsquantity'+i+']').val(obj.value);
			}
		}
		 return true;
	}else{
		return false;
	} 			
}
//-----------向下复制数量-------------------------

	//条码批量打印
	function batPrintGoodsBarCode(){
		var type = $("#cshaaindepartmentid").find("[selected]").attr("retailtype");
		
		if(type != '' && type != '1'){
			alert("当前打印条码商品不是标准零售价，请审核后再详细页进行打印！");
			return;
		}
	
		var flag = false;
		
		if(confirm("条码打印确认！")){
			var ids = document.getElementsByName("chk");
			var persons = $("input[id=person]");
			var barCodes = $("input[pid=pcbarcode]");
			var goodsQuantitys = $("input[id=quantity]");
			var brandnames = $("input[id=brandname]");
			var sources = $("input[id=source]");
			var specs = $("input[id=spec]");
			var colors = $("input[id=color]");
			var retailprices = $("input[id=retailprice]");
			var guaranteeperiods = $("input[id=guaranteeperiod]");
			var batchs = $("input[id=batch]");
			
			var suffix;
			var barCount = 0;
			
			var barCode = new Array();
			var quantity = new Array();
			var brandname = new Array();
			var source = new Array();
			var spec = new Array();
			var color = new Array();
			var retailprice = new Array();
			var person = new Array();
			var guaranteeperiod = new Array();
			var batch = new Array();
			
			for(var i=0 ; i< barCodes.length; i++){
				if(ids[i].checked == true){
					person[person.length] = persons.val();
					barCode[barCode.length] = barCodes[i].value;
					quantity[quantity.length] = goodsQuantitys[i].value;
					
					brandname[brandname.length] = brandnames[i].value;
					source[source.length] = sources[i].value;
					spec[spec.length] = specs[i].value;
					color[color.length] = colors[i].value;
					retailprice[retailprice.length] = retailprices[i].value;
					guaranteeperiod[guaranteeperiod.length] = guaranteeperiods[i].value;
					batch[batch.length] = batchs[i].value;
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
					 
				/*alert("条码："+barCode);
				alert("数量："+quantity);
				alert("品种："+brandname);
				alert("产地："+source);
				alert("规格："+spec);
				alert("色号："+color);
				alert("零售价："+retailprice);
				alert("定价员："+person);
				alert("打印样式："+printtype);
				alert("效期："+guaranteeperiod);
				alert("批号："+batch);*/	 
				
				try {
					printBarCode(barCode,quantity,brandname,source,spec,color,retailprice,person,printtype,guaranteeperiod,batch);
				} catch(e) {
					alert("打印失败!请检查条码打印机是否正确连接!");
					return;
				}
			}
		}
	}

	var index = 0;
	function getCallAbleNum(goodsid,index){
		var goodsbarcode = $('#selectGbc'+index).val();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;	
		if(is_iPad()){
			showPopWin("selGoodsSingleZTOpen.action?goodsID="+goodsid+"&goodscode="+index+"&stockid="+$('#cshaaoutstockid').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selGoodsSingleZTOpen.action?goodsID="+goodsid+"&goodscode="+index+"&stockid="+$('#cshaaoutstockid').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【商品可调用数量详细】";
	}

	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

		setCompanyNature($('#companyNature').val());
	});

	/*
	需求数量合计
	*/
	function needAmount(){
		var total=0;
		$('input[name=needNumber]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#needTotal').text(total);
	}
	
	function showSubMenu1(obj,id) {  
    	$('#cshaaoutstockid').load("getAjaxStock.action?id="+ id);
    }

	/**
	 * 开窗赋值实现方法
	 */
	function openValues21(objValue,isShowBarcode){
		document.getElementById('cshaabillassociation').value=objValue;
		allocationForm.action="selGoodsAllocationBills.action?billID="+objValue+"&isShowBarcode="+isShowBarcode;
		allocationForm.submit();
	}
	
	function openGoodAllocation(flag){
		if ($('#cshaaindepartmentid').val() == ''){
			alert("请选择接收部门！");
			$('#cshaaindepartmentid').focus();
			return;
	    }
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initAllocationGoods.action?categoryID_open=${allocationPo.cshaacategoryid}&allflag="+flag,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initAllocationGoods.action?categoryID_open=${allocationPo.cshaacategoryid}&allflag="+flag,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【调拨单查询】";
	}
	
	function OnKeyDownEnter(obj){
		if(event.keyCode == 13){
			var index = $("input[name=goodsInfoTempPo.goodsquantity]").index(obj)+1;
		    $("input[name=goodsInfoTempPo.goodsquantity]").eq(index).focus();
		}
	}

  	/*
	调拨数量合计
	*/
	function amount2(item){
  		if('${person.departmenttype}'=='3'){ //仓储调拨数量关联条码数量
	  		if($(item).parent().parent().find('.gbc option').size()!=0){
	  			$(item).parent().find('.number')[0].value=$(item).parent().parent().find('.gbc option').size();  			
	  		}
  		
	  		amount1();
		}else{
			amount1();
		}
  	}
  	
	//页面内扫码，并将条码付到对应的条码框中
	function onBlurBarCode(barCodeInputObj,goodsId){
		var goodsId = goodsId.replace(/\./g,  "").toUpperCase();
		var barCode = barCodeInputObj.val().toUpperCase().substring(0,18);
		if(goodsId != barCode){
			alert("商品代码与商品条码不符！");
			barCodeInputObj.val('');
			return;
		} 
		if(barCodeInputObj.val().length<26)
		{
			alert("商品条码位数不符！");
			barCodeInputObj.val('');
			return;
		}
		$(barCodeInputObj).parent().find('.gbc').get(0).options.add(new Option(barCodeInputObj.val().toUpperCase(),barCodeInputObj.val().toUpperCase()));
		barCodeInputObj.val('');
		barCodeInputObj.focus();
		if($(barCodeInputObj).parent().parent().find('.number')[0].value == ''){
			$(barCodeInputObj).parent().parent().find('.number')[0].value = 0;
		}
		$(barCodeInputObj).parent().parent().find('.number')[0].value=$(barCodeInputObj).parent().find('.gbc option').size();

		$(barCodeInputObj).parent().parent().find('.priceamount')[0].value=accMul($(barCodeInputObj).parent().parent().find('.number')[0].value,$(barCodeInputObj).parent().parent().find('.price')[0].value)
		
        amount1();
	}

	/*
	移除条码
	*/
	function removeOption(item){
		$(item).parent().parent().find('.gbc').find('option:selected').remove();
		$(item).parent().parent().parent().find('.number')[0].value=$(item).parent().parent().find('.gbc option').size();
		var total=0;
			$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
				total=accAdd(total,$(this).val());
			});
			$('#goodsquantityTotal').text(total);
		
	}
	function save(){
		if($('.row').size()==0){
			alert('请先选择商品!');
			return;
		}
		var isgoon='';
		var goodsQuantities = $("input[name=goodsInfoTempPo.goodsquantity]");

		for(var i = 0; i < goodsQuantities.length; i++) {
			if(($("#cshaaauditstate").attr("checked")) && (goodsQuantities[i].value <= 0)){
				alert("请正确填写商品数量！");
				goodsQuantities[i].focus();
				goodsQuantities[i].select();
				isgoon='1';
				return;
			}
			if(goodsQuantities[i].value < 0){
				alert("请正确填写商品数量！");
				goodsQuantities[i].focus();
				goodsQuantities[i].select();
				isgoon='1';
				return;
			}
		}

		if(isgoon!=''){
			return;
		}
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
			//验证商品类别和制造商是否与添加商品一样
			var chk=document.getElementsByName("chk");
			var length = chk.length;
			
			var checkbarcode = 0;
			$('select[id=selectGbc]').each(function(){
				for(i=0;i<$(this).find("option").length;i++){
					$(this).find("option")[i].selected='selected';
				}
	
				if($(this).find("option").length == 0){
					checkbarcode = checkbarcode + 1;
				}
			});
	
			$("[id=selectGbc]").each(function (){
				if($(this).val() == ''){
					checkbarcode = checkbarcode + 1;
				}
			});
	
			if(checkbarcode != 0){
				alert("请扫描条码！");
				return;
			}

	        // 判断商品条码与商品代码是否一致 
	        var goodsIDs = $("input[name=goodsInfoTempPo.goodsid]");
	        var goodsBarcodes = $("input[name=goodsInfoTempPo.goodsbarcode]");
	        for(var i = 0; i < goodsIDs.length; i++) {
                if (goodsIDs[i].value.replace(/[.]/g, "").toUpperCase() != goodsBarcodes[i].value.substring(0,18).toUpperCase()){
                    alert('商品代码与商品条码不一致，请重新扫码!');
                    goodsBarcodes[i].focus();
                    return;
                }
		    }
		    
		</c:if>
	if(checkForm(document.all.allocationForm)){ 
		var table = document.getElementById('addTable');
		var index = table.rows.length-1;
		if(index==0){
		  alert('请选择商品!');
		  return false;
		}
		
        var cshaainstockid=document.all.cshaainstockid.value;
        var cshaaoutstockid=document.all.cshaaoutstockid.value;
        if(cshaainstockid==cshaaoutstockid){
          alert('发出仓位和接受仓位不能一致!');
		  return false;
        } 

        var strMessage = "";
        $("input[name=goodsInfoTempPo.goodsquantity]").each(function (){
        	if(parseFloat($(this).val())>parseFloat($(this).parent().parent().find("#maxquantity").val())){
        		strMessage = strMessage+$(this).parent().parent().find("input[name=goodsInfoTempPo.goodsid]").val()+"\n";
			}
        });

        if('${systemParameterPo.fspsalestype }' == '1'){
            if(strMessage != ""){
            	//strMessage = "以下商品：\n"+strMessage+"商品数量大于可用库存数，是否确认提交？"
            	strMessage = "以下商品中存在商品数量大于可用库存数，是否确认提交？"
            	if(confirm(strMessage)){
            	}else{
					return;
               	}
            }
	 	}else{
	 		if(strMessage != ""){
            	strMessage = "以下商品中存在商品数量大于可用库存数，会产生负库存！"
            	alert(strMessage);
            }
		}

        if (document.all.cshaainstockid.options[document.all.cshaainstockid.selectedIndex].getAttribute("dptid") != $('#cshaaindepartmentid').val()){
        	alert("调拨单的接收仓位所属部门与接收部门不一致，请重新选取!");
        	return;
        }
        
		$("img").removeAttr("onclick");
		allocationForm.action = "updateAllocation.action";
		allocationForm.submit();
		}
	}

	function redToBlack(obj){
		if(Number(obj.parent().parent().find("input[name=goodsInfoTempPo.goodsquantity]").val()) <= Number(obj.parent().parent().find("input[name=goodsInfoTempPo.cshaaemaxquantity]").val()) && obj.val()!=''){
			obj.parent().parent().attr("style","color: black;");
		}else{
			obj.parent().parent().attr("style","color: red;");
		}
	}

	function blackToRed(obj){
		if(Number($(obj).val()) > Number($(obj).parent().parent().find("input[name=goodsInfoTempPo.cshaaemaxquantity]").val()) || $(obj).val() == '' ){
			$(obj).parent().parent().attr("style","color: red;");
		}else{
			$(obj).parent().parent().attr("style","color: black;");
	    }
	}
	
    function getRequirequantity(barcode){
    	var chk = document.getElementsByName("goodsInfoTempPo.goodsbarcode");
    	var requirequantity = document.getElementsByName("goodsInfoTempPo.cshaaerequirequantity");
    	var count = 0;
    	
		for(var i = 0; i < chk.length; i++){
			if (chk[i].getAttribute('goodsID').toUpperCase() == barcode.substring(0,18).toUpperCase()){
				if (Number(requirequantity[i].value) > 1 ){
					requirequantity[i].value = accSub(requirequantity[i].value,1);
					$('span[name=requirenumSpan]').get(i).innerHTML = requirequantity[i].value;
					count = 1;
					break;					
			    }
			}			
		}
				
		if (count == 0){
			return "";
	    }		

		return '1';
    }
    
	var stat=1;

    function getMaxQuantity(obj,goodInfo){
    	$(obj).parent().parent().find('input[name=goodsInfoTempPo.cshaaemaxquantity]')[0].value = goodInfo.cshaaemaxquantity;
    	$(obj).parent().parent().find('span[name=maxquantitySpan]')[0].innerHTML = goodInfo.cshaaemaxquantity;
    	$(obj).parent().parent().find('#guaranteeperiod').val(goodInfo.guaranteeperiod);
    	$(obj).parent().parent().find('#batch').val(goodInfo.batch);
    }
    
    function addRow(goodInfo){
		var table = document.getElementById('addTable');
		var index = 0;
		if(indexBasic==1){
			index = table.rows.length - 1;
		}
		else{
			index = indexBasic;
		}
		
		// 商品id去重
		var chk=document.getElementsByName("goodsInfoTempPo.goodsbarcode");
		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");
		for(var i = 0; i < chk.length; i++){
			if (chk[i].value != '' && chk[i].value.toUpperCase() == goodInfo.bgigoodsbarcode.toUpperCase()){
				if((goodInfo.bgigoodsid.substring(0,1)=='4' || goodInfo.bgigoodsid.substring(0,1)=='5') && ('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2')){
					getMaxQuantity(chk[i],goodInfo);
				}
				return;
			}		
			if (chk[i].value == '' && chk[i].getAttribute('goodsID').toUpperCase() == goodInfo.bgigoodsbarcode.substring(0,18).toUpperCase()){
				if((goodInfo.bgigoodsid.substring(0,1)=='4' || goodInfo.bgigoodsid.substring(0,1)=='5') && ('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2')){
					getMaxQuantity(chk[i],goodInfo);
				}
				return;
			}
			
		}

		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);

		<c:if test="${permissionPo.keyi eq '1'}"> 
		    var c8 = row.insertCell(7);
		    var c9 = row.insertCell(8);
	
			<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		        var c10 = row.insertCell(9);
		    </c:if>		
	    </c:if>

	    <c:if test="${permissionPo.keyi ne '1'}"> 
			<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		        var c10 = row.insertCell(7);
		    </c:if>		
        </c:if>		

		var requirequantity = '';
		if(typeof(goodInfo.requirequantity) != "undefined"){
			requirequantity = goodInfo.requirequantity;
		}
		if((goodInfo.bgigoodsid.substring(0,1)=='4' || goodInfo.bgigoodsid.substring(0,1)=='5') && ('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2')){
            requirequantity = getRequirequantity(goodInfo.bgigoodsbarcode);
		}
       		
		row.className = 'row';
		row.height="26";
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.bgigoodsbarcode + '"><input type="hidden" id="maxquantity" value="' + accAdd(Number(goodInfo.bgigoodsquantitys),Number(goodInfo.bgiintransitgoodsnum))  +'" />';
        c2.innerHTML = goodInfo.bgigoodsid.toUpperCase() + '<input type="hidden" id="goodsid" index="'+goodInfo.bgigoodsid+'" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid.toUpperCase() +'" />';
        c3.innerHTML = goodInfo.bgigoodsname + '<input type="hidden" id="bgigoodsname" name="goodsInfoTempPo.goodsname" value="' + goodInfo.bgigoodsname +'" />';
		c4.innerHTML = goodInfo.bgispec + '<input type="hidden" id="bgispec" name="goodsInfoTempPo.spec" value="' + goodInfo.bgispec +'" />'; 
		c5.innerHTML = '<span name="requirenumSpan">'+ requirequantity + '</span><input type="hidden" id="requirequantity" name="goodsInfoTempPo.cshaaerequirequantity" value="'+requirequantity+'" />';
		c6.innerHTML = '<a href=\'javascript:getCallAbleNum("'+goodInfo.bgigoodsid+'","'+goodInfo.bgigoodsbarcode+'");\'><span name="maxquantitySpan">'+goodInfo.cshaaemaxquantity+'</span></a><input type="hidden" id="maxquantity" name="goodsInfoTempPo.cshaaemaxquantity" value="' + goodInfo.cshaaemaxquantity +'" />';
		var htmlStr = '';
		var goodsnumber = '';
		var goodsprice = '';
        var c7str = '';
        
        if ($('#companyNature').val() == '1'){
            if ('${fquartzSwitchPo.fqscbjs}' == '1'){
            	goodsprice = goodInfo.bginottaxrate;
            }else{
            	goodsprice = goodInfo.bgicostprice;
            }
        }else{
        	goodsprice = goodInfo.bgiwholesaleprice;
        }
        
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
			if(goodsnumber == '' && goodInfo.bgigoodsquantity != 0 && typeof(goodInfo.bgigoodsquantity) != "undefined"){
				goodsnumber = goodInfo.bgigoodsquantity;
			}		
			
			if(goodInfo.bgigoodsid.substring(0,1)=='2'||goodInfo.bgigoodsid.substring(0,1)=='5'||goodInfo.bgigoodsid.substring(0,1)=='7'||goodInfo.bgigoodsid.substring(0,1)=='9'){
				c7str = '<input type="text" class="text_input60 number" id="quantity" style="text-align:center;" goodsquantity="goodsquantity'+ index +'" ondblclick="goodsquantityAdd(this)" maxlength="18" name="goodsInfoTempPo.goodsquantity" onkeydown="OnKeyDownEnter(this)" value="'+goodsnumber+'" dbs="dbs'+index+'" onblur="jshj('+index+');amount1();blackToRed(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';
			}else{
				c7str = '<input type="text" class="text_input60 number" id="quantity" style="text-align:center;" goodsquantity="goodsquantity'+ index +'" ondblclick="goodsquantityAdd(this)" value="'+goodsnumber+'" maxlength="18" name="goodsInfoTempPo.goodsquantity" onkeydown="OnKeyDownEnter(this)" value="" dbs="dbs'+index+'" onblur="jshj('+index+');amount1();compareQuantity(this);blackToRed(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';
			}
		</c:if>
		<c:if test="${systemParameterPo.fspbarcodetype==3}"> 
		    c7str = '<input type="text" class="text_input60 number" id="quantity" style="text-align:center;" goodsquantity="goodsquantity'+ index +'" ondblclick="goodsquantityAdd(this)" maxlength="18" name="goodsInfoTempPo.goodsquantity" onkeydown="OnKeyDownEnter(this)" value="" onblur="amount1();blackToRed(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>'+
							'<input type="hidden" id="selectGbc'+index+'" pid="pcbarcode" name="goodsInfoTempPo.goodsbarcode" value="'+goodInfo.bgigoodsbarcode+'"/>';
		</c:if>


		<c:if test="${permissionPo.keyi ne '1'}"> 
	        c7str = c7str + '<input type="hidden" id="taxrate" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" /><input type="hidden" class="text_input60 price" dj="dj'+index+'" maxlength="10" name="goodsInfoTempPo.allinstoargeprice" value="'+goodsprice+'" />';
	        c7str = c7str + '<input type="hidden" class="text_input60 priceamount" hj="hj'+index+'" maxlength="10" name="goodsInfoTempPo.allinstoargepriceamount" value="'+accMul(goodsprice,goodsnumber)+'" />';
        </c:if>

        c7.innerHTML = c7str;
    
		<c:if test="${permissionPo.keyi eq '1'}"> 
		    c8.innerHTML = '<input type="hidden" id="taxrate" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" /><input type="text" class="text_input60 price" dj="dj'+index+'" maxlength="10" name="goodsInfoTempPo.allinstoargeprice" value="'+goodsprice+'" onblur="jshj('+index+');amount1();" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写调入单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的调入单价！\'}]"/>';
		    c9.innerHTML = '<input type="text" class="text_input60 priceamount" hj="hj'+index+'" maxlength="10" name="goodsInfoTempPo.allinstoargepriceamount" value="'+accMul(goodsprice,goodsnumber)+'" onblur="jsdj('+index+');amount1();" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写调入价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的调入价！\'}]"/>';
		</c:if>
		
		indexBasic++;
		
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
		if(htmlStr == ''){
			htmlStr = '<input id="selectGbc'+index+'" pid="pcbarcode" name="goodsInfoTempPo.goodsbarcode" readonly="readonly" multiple="multiple" class="text_input200 gbc" value="'+goodInfo.bgigoodsbarcode+'" goodsID="'+goodInfo.bgigoodsid.replace(/\./g,'')+'">'; 
		}
		htmlStr =  htmlStr+
					   	'<input type="hidden" id="spec" value="' + goodInfo.bgispec +'" />'+
					   	'<input type="hidden" id="color" value="' + goodInfo.bgicolor +'" />'+
					   	'<input type="hidden" id="retailprice" value="' + goodInfo.bgiretailprice +'" />'+
					   	'<input type="hidden" id="person" value="' + '${person.id}' +'" />'+
					   	'<input type="hidden" id="brandname" value="' + goodInfo.bgibrandname +'" />'+
					   	'<input type="hidden" id="source" value="' + goodInfo.bgisource +'" />';
					   	if(goodInfo.guaranteeperiod && goodInfo.batch){
						   	c10.innerHTML = htmlStr + '<input type="hidden" id="guaranteeperiod" value="' + goodInfo.guaranteeperiod +'" />'+
						   	'<input type="hidden" id="batch" value="' + goodInfo.batch +'" />';
					   	}else{
					   		c10.innerHTML = htmlStr + '<input type="hidden" id="guaranteeperiod" value="" />'+
						   	'<input type="hidden" id="batch" value="" />';
						}
		c10.align="left";
		</c:if>
		status=status+1;
    }

	function loadBarUpdateNumber(obj){
		var indexval = null;
		var goodidval = null;
		$('input[name=goodsInfoTempPo.goodsbarcode]').each(function (){
			if(obj.toUpperCase()==$(this).val().toUpperCase()){
				indexval = $(this).val();
				goodidval = $(this).val();
			}
		});
		if(indexval==null){
			alert("该商品条码没有匹配的商品！");
			return;
		}
		$('input[value='+indexval+']').val(obj);
		var getinput = $('input[value='+indexval+']');
		loadBarCodeUpdateNumber(getinput,goodidval);
		redToBlack(getinput);
	}

	function loadBarCodeUpdateNumber(barCodeInputObj,goodsId){ 
		if(!barCodeInputObj.size > 0){
			alert("商品代码与商品条码不符！");
			barCodeInputObj.val('');
			return;
		} 
		if(barCodeInputObj.val().length<26)
		{
			alert("商品条码位数不符！");
			barCodeInputObj.val('');
			return;
		}
		$(barCodeInputObj).parent().find('.gbc').val(barCodeInputObj.val().toUpperCase());
		if($(barCodeInputObj).parent().parent().find('.number')[0].value == ''){
			$(barCodeInputObj).parent().parent().find('.number')[0].value = 0;
		}
		$(barCodeInputObj).parent().parent().find('.number')[0].value=parseFloat($(barCodeInputObj).parent().parent().find('.number')[0].value) + 1;
		$(barCodeInputObj).parent().parent().find('.priceamount')[0].value=accMul($(barCodeInputObj).parent().parent().find('.number')[0].value,$(barCodeInputObj).parent().parent().find('.price')[0].value)
		
        amount1();	
	}

    function addRowUpdateNumber(goodInfo){
		var table = document.getElementById('addTable');
		var index = 0;
		if(indexBasic==1){
			index = table.rows.length - 1;
		}
		else{
			index = indexBasic;
		}

        if (goodInfo.bgigoodsbarcode.length == 18){
        	goodInfo.bgigoodsbarcode = goodInfo.bgigoodsbarcode + '00000000';
        }
        
		// 商品id去重
		var chk=document.getElementsByName("chk");
		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsbarcode");
		for(var i = 0; i < chk.length; i++){
			if (chk[i].value != '' && chk[i].value.toUpperCase() == goodInfo.bgigoodsbarcode.toUpperCase()){
				if((goodInfo.bgigoodsid.substring(0,1)=='4' || goodInfo.bgigoodsid.substring(0,1)=='5') && ('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2')){
					getMaxQuantity(chk[i],goodInfo);
				}
				return;
			}		
			if (chk[i].value == '' && chk[i].getAttribute('goodsID').toUpperCase() == goodInfo.bgigoodsbarcode.substring(0,18).toUpperCase()){
				if((goodInfo.bgigoodsid.substring(0,1)=='4' || goodInfo.bgigoodsid.substring(0,1)=='5') && ('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2')){
					getMaxQuantity(chk[i],goodInfo);
				}
				return;
			}
		}
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);
		
		<c:if test="${permissionPo.keyi eq '1'}"> 
		    var c8 = row.insertCell(7);
		    var c9 = row.insertCell(8);

			<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		        var c10 = row.insertCell(9);
		    </c:if>		
		</c:if>

		<c:if test="${permissionPo.keyi ne '1'}"> 
			<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		        var c10 = row.insertCell(7);
		    </c:if>		
	    </c:if>

		var requirequantity = '';
		if(typeof(goodInfo.requirequantity) != "undefined"){
			requirequantity = goodInfo.requirequantity;
		}
		
		row.className = 'row';
		row.height="26";
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.bgigoodsbarcode + '"><input type="hidden" id="maxquantity" value="' + (parseFloat(goodInfo.bgigoodsquantitys)+parseFloat(goodInfo.bgiintransitgoodsnum))  +'" />';
        c2.innerHTML = goodInfo.bgigoodsid.toUpperCase() + '<input type="hidden" id="goodsid" index="'+goodInfo.bgigoodsid+'" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid.toUpperCase() +'" />';
        c3.innerHTML = goodInfo.bgigoodsname + '<input type="hidden" id="bgigoodsname" name="goodsInfoTempPo.goodsname" value="' + goodInfo.bgigoodsname +'" />';
		c4.innerHTML = goodInfo.bgispec + '<input type="hidden" id="bgispec" name="goodsInfoTempPo.spec" value="' + goodInfo.bgispec +'" />'; 
		c5.innerHTML = '<span name="requirenumSpan">' + requirequantity + '</span><input type="hidden" id="requirequantity" name="goodsInfoTempPo.cshaaerequirequantity" value="' + requirequantity +'" />'; 
		c6.innerHTML = '<a href=\'javascript:getCallAbleNum("'+goodInfo.bgigoodsid+'","'+goodInfo.bgigoodsbarcode+'");\'><span name="maxquantitySpan">'+goodInfo.cshaaemaxquantity+'</span></a><input type="hidden" id="maxquantity" name="goodsInfoTempPo.cshaaemaxquantity" value="' + goodInfo.cshaaemaxquantity +'" />';
		var htmlStr = '';
		var goodsnumber = '';
		var goodsprice = '';
        var c7str = '';
        
        if ($('#companyNature').val() == '1'){
            if ('${fquartzSwitchPo.fqscbjs}' == '1'){
            	goodsprice = goodInfo.bginottaxrate;
            }else{
            	goodsprice = goodInfo.bgicostprice;
            }
        }else{
        	goodsprice = goodInfo.bgiwholesaleprice;
        }
        
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 

			if(goodsnumber == '' && goodInfo.bgigoodsquantity != 0 && typeof(goodInfo.bgigoodsquantity) != "undefined"){
				goodsnumber = goodInfo.bgigoodsquantity;
			}
			
			<c:if test="${systemParameterPo.fspstealtheffective==1 || systemParameterPo.fspstealtheffective==2}">
				if(goodInfo.bgigoodsid.substring(0,1) == '4' || goodInfo.bgigoodsid.substring(0,1) == '5'){
					goodsnumber = 0;
				}
			</c:if>
	
			var isShowBarcode = '';
			if(goodInfo.isShowBarcode != 'n' &&  typeof(goodInfo.isShowBarcode) != "undefined"){
				isShowBarcode = goodInfo.bgigoodsbarcode.toUpperCase();
			}

			c7str = '<input type="text" class="text_input60 number" id="quantity" style="text-align:center;" goodsquantity="goodsquantity'+ index +'" ondblclick="goodsquantityAdd(this)" maxlength="18" name="goodsInfoTempPo.goodsquantity" onkeydown="OnKeyDownEnter(this)" value="'+goodsnumber+'" dbs="dbs'+index+'" onblur="jshj('+index+');amount1();blackToRed(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';
		</c:if>
		
		<c:if test="${systemParameterPo.fspbarcodetype==3}"> 
		    c7str = '<input type="text" class="text_input60 number" id="quantity" style="text-align:center;" goodsquantity="goodsquantity'+ index +'" ondblclick="goodsquantityAdd(this)" maxlength="18" name="goodsInfoTempPo.goodsquantity" onkeydown="OnKeyDownEnter(this)" value="'+goodInfo.bgigoodsquantity+'" dbs="dbs'+index+'" onblur="jshj('+index+');amount1();blackToRed(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>'+
							'<input type="hidden" id="selectGbc'+index+'" pid="pcbarcode" name="goodsInfoTempPo.goodsbarcode" value="'+goodInfo.bgigoodsbarcode+'"/>';
		</c:if>

		<c:if test="${permissionPo.keyi ne '1'}"> 
		    c7str = c7str + '<input type="hidden" id="taxrate" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" /><input type="hidden" class="text_input60 price" dj="dj'+index+'" maxlength="10" name="goodsInfoTempPo.allinstoargeprice" value="'+goodsprice+'" />';
		    c7str = c7str + '<input type="hidden" class="text_input60 priceamount" hj="hj'+index+'" maxlength="10" name="goodsInfoTempPo.allinstoargepriceamount" value="'+accMul(goodsprice,goodsnumber)+'" />';
	    </c:if>

	    c7.innerHTML = c7str;
	
		<c:if test="${permissionPo.keyi eq '1'}"> 
		    c8.innerHTML = '<input type="hidden" id="taxrate" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" /><input type="text" class="text_input60 price" dj="dj'+index+'" maxlength="10" name="goodsInfoTempPo.allinstoargeprice" value="'+goodsprice+'" onblur="jshj('+index+');amount1();" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写调入单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的调入单价！\'}]"/>';
		    c9.innerHTML = '<input type="text" class="text_input60 priceamount" hj="hj'+index+'" maxlength="10" name="goodsInfoTempPo.allinstoargepriceamount" value="'+accMul(goodsprice,goodsnumber)+'" onblur="jsdj('+index+');amount1();" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写调入价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的调入价！\'}]"/>';
		</c:if>

		
		indexBasic++;
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
		if(htmlStr == ''){
			<c:if test="${systemParameterPo.fspstealtheffective==1 || systemParameterPo.fspstealtheffective==2}">
				if(goodInfo.bgigoodsid.substring(0,1) == '4' || goodInfo.bgigoodsid.substring(0,1) == '5'){
					htmlStr = '<input id="selectGbc'+index+'" pid="pcbarcode" name="goodsInfoTempPo.goodsbarcode"  multiple="multiple" maxlength="26" class="text_input200 gbc" value="" goodsID="'+goodInfo.bgigoodsid.toUpperCase().replace(/\./g,'')+'">'; 
				}else{
					htmlStr = '<input id="selectGbc'+index+'" pid="pcbarcode" name="goodsInfoTempPo.goodsbarcode"  multiple="multiple" maxlength="26" class="text_input200 gbc" value="'+goodInfo.bgigoodsbarcode.toUpperCase()+'" goodsID="'+goodInfo.bgigoodsid.toUpperCase().replace(/\./g,'')+'">';
				}
			</c:if>
			<c:if test="${systemParameterPo.fspstealtheffective==0 }">
				htmlStr = '<input id="selectGbc'+index+'" pid="pcbarcode" name="goodsInfoTempPo.goodsbarcode"  multiple="multiple" maxlength="26" class="text_input200 gbc" value="'+goodInfo.bgigoodsbarcode.toUpperCase()+'" goodsID="'+goodInfo.bgigoodsid.toUpperCase().replace(/\./g,'')+'">';
			</c:if>
		}
		htmlStr =  htmlStr+
					   	'<input type="hidden" id="spec" value="' + goodInfo.bgispec +'" />'+
					   	'<input type="hidden" id="color" value="' + goodInfo.bgicolor +'" />'+
					   	'<input type="hidden" id="retailprice" value="' + goodInfo.bgiretailprice +'" />'+
					   	'<input type="hidden" id="person" value="' + '${person.id}' +'" />'+
					   	'<input type="hidden" id="brandname" value="' + goodInfo.bgibrandname +'" />'+
					   	'<input type="hidden" id="source" value="' + goodInfo.bgisource +'" />';
					   	if(goodInfo.guaranteeperiod && goodInfo.batch){
						   	c10.innerHTML = htmlStr + '<input type="hidden" id="guaranteeperiod" value="' + goodInfo.guaranteeperiod +'" />'+
						   	'<input type="hidden" id="batch" value="' + goodInfo.batch +'" />';
					   	}else{
					   		c10.innerHTML = htmlStr + '<input type="hidden" id="guaranteeperiod" value="" />'+
						   	'<input type="hidden" id="batch" value="" />';
						}
		c10.align="left";
		</c:if>
		status=status+1;
    }

    function addRowUpdateNumber2(goodInfo){
		var table = document.getElementById('addTable');
		var index = 0;
		if(indexBasic==1){
			index = table.rows.length - 1;
		}
		else{
			index = indexBasic;
		}

        if (goodInfo.bgigoodsbarcode.length == 18){
        	goodInfo.bgigoodsbarcode = goodInfo.bgigoodsbarcode + '00000000';
        }
        
		// 商品id去重
		var chk=document.getElementsByName("chk");
		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsbarcode");
		for(var i = 0; i < chk.length; i++){
			if (chk[i].value != '' && chk[i].value.toUpperCase() == goodInfo.bgigoodsbarcode.toUpperCase()){
				if((goodInfo.bgigoodsid.substring(0,1)=='4' || goodInfo.bgigoodsid.substring(0,1)=='5') && ('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2')){
					getMaxQuantity(chk[i],goodInfo);
				}
				return;
			}		
			if (chk[i].value == '' && chk[i].getAttribute('goodsID').toUpperCase() == goodInfo.bgigoodsbarcode.substring(0,18).toUpperCase()){
				if((goodInfo.bgigoodsid.substring(0,1)=='4' || goodInfo.bgigoodsid.substring(0,1)=='5') && ('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2')){
					getMaxQuantity(chk[i],goodInfo);
				}
				return;
			}
		}
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);
		
		<c:if test="${permissionPo.keyi eq '1'}"> 
		    var c8 = row.insertCell(7);
		    var c9 = row.insertCell(8);

			<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		        var c10 = row.insertCell(9);
		    </c:if>		
		</c:if>

		<c:if test="${permissionPo.keyi ne '1'}"> 
			<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		        var c10 = row.insertCell(7);
		    </c:if>		
	    </c:if>

		var requirequantity = '';
		if(typeof(goodInfo.requirequantity) != "undefined"){
			requirequantity = goodInfo.requirequantity;
		}
		
		row.className = 'row';
		row.height="26";
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.bgigoodsbarcode + '"><input type="hidden" id="maxquantity" value="' + (parseFloat(goodInfo.bgigoodsquantitys)+parseFloat(goodInfo.bgiintransitgoodsnum))  +'" />';
        c2.innerHTML = goodInfo.bgigoodsid.toUpperCase() + '<input type="hidden" id="goodsid" index="'+goodInfo.bgigoodsid+'" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid.toUpperCase() +'" />';
        c3.innerHTML = goodInfo.bgigoodsname + '<input type="hidden" id="bgigoodsname" name="goodsInfoTempPo.goodsname" value="' + goodInfo.bgigoodsname +'" />';
		c4.innerHTML = goodInfo.bgispec + '<input type="hidden" id="bgispec" name="goodsInfoTempPo.spec" value="' + goodInfo.bgispec +'" />'; 
		c5.innerHTML = '<span name="requirenumSpan">' + requirequantity + '</span><input type="hidden" id="requirequantity" name="goodsInfoTempPo.cshaaerequirequantity" value="' + requirequantity +'" />'; 
		c6.innerHTML = '<a href=\'javascript:getCallAbleNum("'+goodInfo.bgigoodsid+'","'+goodInfo.bgigoodsbarcode+'");\'><span name="maxquantitySpan">'+goodInfo.cshaaemaxquantity+'</span></a><input type="hidden" id="maxquantity" name="goodsInfoTempPo.cshaaemaxquantity" value="' + goodInfo.cshaaemaxquantity +'" />';
		var htmlStr = '';
		var goodsnumber = '';
		var goodsprice = '';
		var goodspriceamount = '';
        var c7str = '';
        
        if ($('#companyNature').val() == '1'){
            if ('${fquartzSwitchPo.fqscbjs}' == '1'){
            	goodsprice = goodInfo.bginottaxrate;
            	goodspriceamount = goodInfo.cshaaenottaxrateamount;
            }else{
            	goodsprice = goodInfo.bgicostprice;
            	goodspriceamount = goodInfo.cshaaecostpriceamount;
            }
        }else{
        	goodsprice = goodInfo.bgiwholesaleprice;
        	goodspriceamount = goodInfo.cshaaewholesalepriceamount;
        }
        
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 

			if(goodsnumber == '' && goodInfo.bgigoodsquantity != 0 && typeof(goodInfo.bgigoodsquantity) != "undefined"){
				goodsnumber = goodInfo.bgigoodsquantity;
			}
	
			var isShowBarcode = '';
			if(goodInfo.isShowBarcode != 'n' &&  typeof(goodInfo.isShowBarcode) != "undefined"){
				isShowBarcode = goodInfo.bgigoodsbarcode.toUpperCase();
			}

			c7str = '<input type="text" class="text_input60 number" id="quantity" style="text-align:center;" goodsquantity="goodsquantity'+ index +'" ondblclick="goodsquantityAdd(this)" maxlength="18" name="goodsInfoTempPo.goodsquantity" onkeydown="OnKeyDownEnter(this)" value="'+goodsnumber+'" dbs="dbs'+index+'" onblur="jshj('+index+');amount1();blackToRed(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';
		</c:if>
		
		<c:if test="${systemParameterPo.fspbarcodetype==3}"> 
		    c7str = '<input type="text" class="text_input60 number" id="quantity" style="text-align:center;" goodsquantity="goodsquantity'+ index +'" ondblclick="goodsquantityAdd(this)" maxlength="18" name="goodsInfoTempPo.goodsquantity" onkeydown="OnKeyDownEnter(this)" value="'+goodInfo.bgigoodsquantity+'" dbs="dbs'+index+'" onblur="jshj('+index+');amount1();blackToRed(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>'+
							'<input type="hidden" id="selectGbc'+index+'" pid="pcbarcode" name="goodsInfoTempPo.goodsbarcode" value="'+goodInfo.bgigoodsbarcode+'"/>';
		</c:if>

		<c:if test="${permissionPo.keyi ne '1'}"> 
			
		    c7str = c7str + '<input type="hidden" id="taxrate" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" /><input type="hidden" class="text_input60 price" dj="dj'+index+'" maxlength="10" name="goodsInfoTempPo.allinstoargeprice" value="'+goodsprice+'" />';
		    c7str = c7str + '<input type="hidden" class="text_input60 priceamount" hj="hj'+index+'" maxlength="10" name="goodsInfoTempPo.allinstoargepriceamount" value="'+goodspriceamount+'" />';
	    </c:if>

	    c7.innerHTML = c7str;
		
		<c:if test="${permissionPo.keyi eq '1'}"> 
		    c8.innerHTML = '<input type="hidden" id="taxrate" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" /><input type="text" class="text_input60 price" dj="dj'+index+'" maxlength="10" name="goodsInfoTempPo.allinstoargeprice" value="'+goodsprice+'" onblur="jshj('+index+');amount1();" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写调入单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的调入单价！\'}]"/>';
		    c9.innerHTML = '<input type="text" class="text_input60 priceamount" hj="hj'+index+'" maxlength="10" name="goodsInfoTempPo.allinstoargepriceamount" value="'+goodspriceamount+'" onblur="jsdj('+index+');amount1();" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写调入价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的调入价！\'}]"/>';
		</c:if>

		
		indexBasic++;
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
		if(htmlStr == ''){
			//if((goodInfo.bgigoodsid.substring(0,1)=='4' || goodInfo.bgigoodsid.substring(0,1)=='5') && ('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2')){
			//	htmlStr = '<input id="selectGbc'+index+'" pid="pcbarcode" name="goodsInfoTempPo.goodsbarcode" readonly="readonly" multiple="multiple" class="text_input200 gbc" value="'+isShowBarcode+'" goodsID="'+goodInfo.bgigoodsid.toUpperCase().replace(/\./g,'')+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]" goodsID="'+goodInfo.bgigoodsbarcode.toUpperCase()+'">'; 
			//}else{
				htmlStr = '<input id="selectGbc'+index+'" pid="pcbarcode" name="goodsInfoTempPo.goodsbarcode" readonly="readonly" multiple="multiple" class="text_input200 gbc" value="'+goodInfo.bgigoodsbarcode.toUpperCase()+'" goodsID="'+goodInfo.bgigoodsid.toUpperCase().replace(/\./g,'')+'">'; 
			//}			
		}
		htmlStr =  htmlStr+
					   	'<input type="hidden" id="spec" value="' + goodInfo.bgispec +'" />'+
					   	'<input type="hidden" id="color" value="' + goodInfo.bgicolor +'" />'+
					   	'<input type="hidden" id="retailprice" value="' + goodInfo.bgiretailprice +'" />'+
					   	'<input type="hidden" id="person" value="' + '${person.id}' +'" />'+
					   	'<input type="hidden" id="brandname" value="' + goodInfo.bgibrandname +'" />'+
					   	'<input type="hidden" id="source" value="' + goodInfo.bgisource +'" />';
					   	if(goodInfo.guaranteeperiod && goodInfo.batch){
						   	c10.innerHTML = htmlStr + '<input type="hidden" id="guaranteeperiod" value="' + goodInfo.guaranteeperiod +'" />'+
						   	'<input type="hidden" id="batch" value="' + goodInfo.batch +'" />';
					   	}else{
					   		c10.innerHTML = htmlStr + '<input type="hidden" id="guaranteeperiod" value="" />'+
						   	'<input type="hidden" id="batch" value="" />';
						}
		c10.align="left";
		</c:if>
		status=status+1;
    }
	
	function loadBar(obj){
		var indexval = null;
		var goodidval = null;
		var count = 0;
		$('input[name=goodsInfoTempPo.goodsbarcode]').each(function (){
			//alert($(this).attr('goodsID').toUpperCase().substring(0,18) == obj.toUpperCase().substring(0,18))
			if($(this).val() != '' && obj.toUpperCase() == $(this).val().toUpperCase()){
				indexval = $(this).val();
				goodidval = $(this).val();
				count = 1;
			}
			if($(this).val() == '' && $(this).attr('goodsID').toUpperCase().substring(0,18) == obj.toUpperCase().substring(0,18)){
				indexval = $(this).attr('goodsID');
				goodidval = $(this).attr('goodsID');
				count = 0;
			}
		});
		if(indexval==null){
			alert("该商品条码没有匹配的商品！");
			return;
		}

		var getinput = null;
		if (count == 1){
			$('input[value='+indexval+']').val(obj.toUpperCase());
			getinput = $('input[value='+indexval+']');			
		}else{
			$('input[name=goodsInfoTempPo.goodsbarcode][goodsID='+indexval+']').val(obj.toUpperCase());
			getinput = $('input[name=goodsInfoTempPo.goodsbarcode][goodsID='+indexval+']');
		}

		loadBarCodeUpdateNumber(getinput,goodidval);
		redToBlack(getinput);
	}
	
	function loadBarCode(barCodeInputObj,goodsId){ 
		var goodsId = goodsId.replace(/\./g,  "").toUpperCase();
		var barCode = barCodeInputObj.val().toUpperCase().substring(0,18);
		if(goodsId != barCode){
			alert("商品代码与商品条码不符！");
			barCodeInputObj.val('');
			return;
		} 
		if(barCodeInputObj.val().length<26)
		{
			alert("商品条码位数不符！");
			barCodeInputObj.val('');
			return;
		}
		$(barCodeInputObj).parent().find('.gbc').get(0).options.add(new Option(barCodeInputObj.val().toUpperCase(),barCodeInputObj.val().toUpperCase()));
		if($(barCodeInputObj).parent().parent().find('.number')[0].value == ''){
			$(barCodeInputObj).parent().parent().find('.number')[0].value = 0;
		}
		$(barCodeInputObj).parent().parent().find('.number')[0].value=$(barCodeInputObj).parent().find('.gbc option').size();

		$(barCodeInputObj).parent().parent().find('.priceamount')[0].value=accMul($(barCodeInputObj).parent().parent().find('.number')[0].value,$(barCodeInputObj).parent().parent().find('.price')[0].value)
		
        amount1();
		
	}
    
	function openGoodSingle(){
		if ($('#cshaaindepartmentid').val() == ''){
			alert("请选择接收部门！");
			$('#cshaaindepartmentid').focus();
			return;
	    }
		var supplierID = '';
		var categoryID_open='';	
		var stockid = $("#cshaaoutstockid").val();

		if(!stockid){
			alert("请选择发出仓位！");
			$("#cshaaoutstockid").focus();
			return;
		}
		
		if(!categoryID_open){
			categoryID_open = '';
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsSingleSelZT.action?categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID + "&stockid="+stockid+"&isshowstealth=1"+"&indptid=" + $('#cshaaindepartmentid').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSelZT.action?categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID + "&stockid="+stockid+"&isshowstealth=1"+"&indptid=" + $('#cshaaindepartmentid').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}
	
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		for(goodsI = 0; goodsI < goodInfos.length; goodsI++){
			addRowUpdateNumber(goodInfos[goodsI]);
		}
		
		$("input[name='goodsInfoTempPo.goodsquantity']").each(function(){
			if('${permissionPo.keyf}'!='1'){
				$(this).attr("readonly","readonly");
			}
			$(this).bind("keyup",function(){
				$(this).val($(this).val().replace(/[^0-9.][0-9]*/g,''));
			});
			$(this).bind("blur",function(){
				if(!isNaN($(this).val())){
					$(this).val($(this).val().replace(/[^0-9.][0-9]*/g,''));
				}else{
					$(this).val('');
				}
			});
		});

	    $("input[name=goodsInfoTempPo.goodsquantity]").each(function (){
			if(parseFloat($(this).val()) > parseFloat($(this).parent().parent().find("input[name=goodsInfoTempPo.cshaaemaxquantity]").val()) || $(this).val()==''){
				$(this).parent().parent().attr("style","color: red;");
			}
		});
		
	}

	/**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID='';
		
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
		document.getElementById('chaasupplier').value = json.id;
		document.getElementById('bspsuppliername').value = json.value;
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
		amount1();
		needAmount();
    }
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('chaasupplier').value = json.id;
		document.getElementById('bspsuppliername').value = json.value;
		
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

	function showSubMenu(obj,id) {  
    	$('#' + 'cshaainstockid').load("getAjaxStock.action?id="+ id +"&instockid="+'${allocationPo.cshaainstockid}');

    	setCompanyNature(obj.options[obj.selectedIndex].getAttribute("companyNature"));
        $('#companyNature').val(obj.options[obj.selectedIndex].getAttribute("companyNature"));  
    }
    
	function searchBar(obj){
		var indexval = null;
		var goodidval = null;
		$('input[name=goodsInfoTempPo.goodsid]').each(function (){
			if(obj.toUpperCase().substring(0,18)==$(this).val().replace(/\./g,  "").toUpperCase()){
				indexval = $(this).attr("index");
				goodidval = $(this).val();
			}
		});
		if(indexval==null){
			$('select[id=selectGbc]').each(function(){
				for(i=0;i<$(this).find("option").length;i++){
					$(this).find("option")[i].selected='selected';
				}
			});
			allocationForm.action="addGoodsInfoForTable.action";
			allocationForm.submit();
			return;
		}
		$('input[index=index'+indexval+']').val(obj);
		var getinput = $('input[index=index'+indexval+']')
		onBlurBarCode(getinput,goodidval);
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	 
	function openValues2(objValue,chaasupplier,bspsuppliername,did,isShowBarcode){
		document.getElementById('cshaabillassociation').value=objValue;
		allocationForm.action="selReceiptBillsUpdate.action?billID="+objValue+"&isShowBarcode="+isShowBarcode;
		allocationForm.submit();
	}
	
	$(document).ready(function(){
		showSubMenu(document.getElementById('cshaaindepartmentid'),document.getElementById("cshaaindepartmentid").value);
		//StatusID：0代表申请调拨，1代表采购收货
		var StatusID='${StatusID}';
		<s:iterator value="allocationEntryList">
			if('${cshaaegoodsid}'!='' && '${cshaaegoodsid}'!=null){
			     var json = {	'bgigoodsid':'${cshaaegoodsid}','bgigoodsbarcode':'${cshaaegoodsBarCode}',
			     				'bgigoodsname':'${cshaaegoodsname}','bgiunitname':'${bgiunitname}','bgicostprice':'${empty(bgicostprice) ? cshaaecostprice : bgicostprice }',
			     				'bgiretailprice':'${empty(bgiretailprice) ? cshaaebgiretailprice : bgiretailprice }','bgitaxrate':'${bgitaxrate}','bginottaxrate':'${empty(bginottaxrate) ? cshaaenottaxrate : bginottaxrate }','bgiwholesaleprice':'${empty(bgiwholesaleprice) ? cshaaewholesaleprice : bgiwholesaleprice }',
			     				'bgispec':'${cshaaespec}','bgicolor':'${empty(cshaaecolor) ? bgicolor : cshaaecolor }','bgisph':'${bgisph}','bgicyl':'${bgicyl}',
			     				'bgiaxis':'${bgiaxis}','bgicurvature1':'${bgicurvature1}','bgidia':'${bgidia}',
			     				'bgigoodsquantity':'${cshaaeallocationquantity}','bgipcbarcode':'${cshaaegoodsBarCode }','cshaaemaxquantity':(('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2') && ('${cshaaegoodsid}'.substring(0,1) == '4' || '${cshaaegoodsid}'.substring(0,1) == '5' ) ? '${cshaaemaxquantity}' : '${cshaaemaxquantity}'),'requirequantity':'${cshaaerequirementquantity}',
			     				'bgisource':'${cshaaesource}','guaranteeperiod':'${cshaaeguaranteeperiod}','batch':'${cshaaebatch}','bgibrandname':'${cshaaebrandname}'
			     			};
		    	 if(json.bgigoodsid.substring(0,1) == '4' || json.bgigoodsid.substring(0,1) == '5'){
			     	addRow(json);
				 }else{
					addRowUpdateNumber(json);
				 }
			}
		</s:iterator>
		
			
			<c:forEach var="po" items="${barcodes}" varStatus="idxStatus">
				if(json.bgigoodsid.substring(0,1) == '4' || json.bgigoodsid.substring(0,1) == '5'){
					loadBar('${po.cshaaegoodsBarCode}');
				}else{
					loadBarUpdateNumber('${po.cshaaegoodsBarCode}');
				}
			</c:forEach>
			var indpartid = $('#indpartid').val();
			if($.trim(indpartid) != null && $.trim(indpartid) != ''){
				var count = $('#cshaaindepartmentid option').size();    
	 			
				var i = 0;
				
	    		for( i; i < $('#cshaaindepartmentid option').size(); i++){
	    			if($.trim($('#cshaaindepartmentid option')[i].value) == $.trim(indpartid)){
	    				break;
	    			}
	    		}
	    	 	document.getElementById("cshaaindepartmentid").selectedIndex=i;
			} 

			if (document.getElementById("cshaaindepartmentid").options[document.getElementById("cshaaindepartmentid").selectedIndex].getAttribute("companyNature") == '1'){
				$('#companyNatureDes').text('直营');
		    }else if (document.getElementById("cshaaindepartmentid").options[document.getElementById("cshaaindepartmentid").selectedIndex].getAttribute("companyNature") == '2'){
				$('#companyNatureDes').text('加盟');
		    }

			if(StatusID!=null)
			{
				$('[name=goodsInfoTempPo.goodsquantity]').each(function (){
					amount2(this);
				});
			}

			amount1();
			needAmount();
			
		    $('#scancode').focus();

			$("input[name=goodsInfoTempPo.goodsquantity]").each(function (){
				if(parseFloat($(this).val()) > parseFloat($(this).parent().parent().find("input[name=goodsInfoTempPo.cshaaemaxquantity]").val()) || $(this).val()==''){
					$(this).parent().parent().attr("style","color: red;");
				}

				if('${permissionPo.keyf}'!='1'){
					$(this).attr("readonly","readonly");
				}
				$(this).bind("keyup",function(){
					$(this).val($(this).val().replace(/[^0-9.][0-9]*/g,''));
				});
				$(this).bind("blur",function(){
					if(!isNaN($(this).val())){
						$(this).val($(this).val().replace(/[^0-9.][0-9]*/g,''));
					}else{
						$(this).val('');
					}
				});
			});
		});
		
		
	function scanbarcode(){
		if ($('#cshaaindepartmentid').val() == ''){
			alert("请选择接收部门！");
			$('#cshaaindepartmentid').focus();
			return;
	    }
		if(!$("#cshaaoutstockid").val()){
			alert("请选择发出仓位！");
			$("#cshaaoutstockid").focus();
			$("#cshaaoutstockid").select();
			return;
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initScanBarcode.action?outstockid="+$("#cshaaoutstockid").val()+"&indptid=" + $('#cshaaindepartmentid').val(),350,55,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initScanBarcode.action?outstockid="+$("#cshaaoutstockid").val()+"&indptid=" + $('#cshaaindepartmentid').val(),350,55,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【条码扫描】";
	}
		
	function openGoodSingleAll(){
		var supplierID = "";
	    var cstpgoodscategory = '';
	    
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsSingleSelAlls.action?categoryID_open=" + cstpgoodscategory + "&supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSelAlls.action?categoryID_open=" + cstpgoodscategory + "&supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【调拨申请单查询】";
	}
	
	function openGoodReceipt(){
		if ($('#cshaaindepartmentid').val() == ''){
			alert("请选择接收部门！");
			$('#cshaaindepartmentid').focus();
			return;
	    }
		var supplierID = "";
	    var categoryID_open = $("#goodscategoryID").val();
		if(!categoryID_open){
			categoryID_open = '';
		}
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsReceipt.action?categoryID_open=" + categoryID_open + "&supplierID_open=" + supplierID+"&isShowBarcode=n",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsReceipt.action?categoryID_open=" + categoryID_open + "&supplierID_open=" + supplierID+"&isShowBarcode=n",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【收货单查询】";
	}
	
	
	function amount1(){
			var total=0;
			$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
				total=accAdd(total,$(this).val());
			});
			$('#goodsquantityTotal').text(total);


			total=0;
			$('input[name=goodsInfoTempPo\\.allinstoargepriceamount]').each(function(){
				total = accAdd(total,$(this).val());
			});
			$('#goodsAmountTotal').text(parseFloat(total).toFixed(2));
  	}
  	
  	 function check()
    {
      if(document.all.cshaaauditstate1.checked==true)
      {
      	document.all.cshaaauditstate.checked = true;	
      }else
      {
      	document.all.cshaaauditstate.checked = false;	
      }
    }
    
     function check1()
    {
      if(document.all.cshaaauditstate.checked==true)
      {
      	document.all.cshaaauditstate1.checked = true;	
      }else
      {
      	document.all.cshaaauditstate1.checked = false;	
      }
    }

   //子页面删除单行
  	function openGoodSingleDeleteValues(objValue){
  		var goodInfos = eval('(' + objValue + ')');
  		
  		for(var i = 0; i < goodInfos.length; i++){
  			deleterow(goodInfos[i]);
  			
  		}
  		amount1();
  	}
  	
  	function deleterow(goodInfo){
 		var table = document.getElementById('addTable');
 		
 		$("input[id=chk]").each(function(){
           	if($(this).val().substring(0,18) == goodInfo.bgigoodsbarcode.substring(0,18)){
   				$(this).parent().parent().remove();
            }
 		});
    }

  	function compareQuantity(obj){
  		if('${systemParameterPo.fspsalestype }' != '1'){
 	 	}
    }

  	function checkGoodsNumber(obj){
		if(parseFloat(obj.val()) > parseFloat(obj.parent().parent().find("input[name=goodsInfoTempPo.cshaaemaxquantity]").val()) || obj.val()==''){
			obj.parent().parent().attr("style","color: red;");
		}else{
			obj.parent().parent().attr("style","color: black;");
		}
    }

	function openGoodsInfoForSOUT(){
		if ($('#cshaaindepartmentid').val() == ''){
			alert("请选择接收部门！");
			$('#cshaaindepartmentid').focus();
			return;
	    }
	    
		var categoryID_open = $("#goodscategoryID").val();
		
		if(!categoryID_open){
			categoryID_open = '';
		}
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelGoodsInfoForSOUT.action?app=app&whichretail=1&select_retail=1&categoryID_open="+categoryID_open+"&indptid=" + $('#cshaaindepartmentid').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelGoodsInfoForSOUT.action?app=app&whichretail=1&select_retail=1&categoryID_open="+categoryID_open+"&indptid=" + $('#cshaaindepartmentid').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【销售商品查询】";
	}

	function openGoodSingleAllForApp(){
		if ($('#cshaaindepartmentid').val() == ''){
			alert("请选择接收部门！");
			$('#cshaaindepartmentid').focus();
			return;
	    }
		var categoryID_open = $("#goodscategoryID").val();
		
		if(!categoryID_open){
			categoryID_open = '';
		}
		
		<c:if test="${systemParameterPo.fspstealtheffective || systemParameterPo.fspstealtheffective==2}">
			if(categoryID_open == '4' || categoryID_open == '5'){
				alert("启用效期后，带批号商品无法通过调拨申请单添加！");
				return;
			}
		</c:if>
		
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsSingleSelAllForApp.action?isShowBarcode=n&dptID=${person.departmentID}&categoryID_open="+categoryID_open,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSelAllForApp.action?isShowBarcode=n&dptID=${person.departmentID}&categoryID_open="+categoryID_open,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【调拨申请单查询】";
	}

	/**
	 * 开窗赋值实现方法
	 */
	function openValues1(objValue,isShowBarcode){
		document.getElementById('cshaabillassociation').value=objValue;
		allocationForm.action="selApplyAllocationBillsUpdate.action?billID="+objValue+"&isShowBarcode="+isShowBarcode;
		allocationForm.submit();
	}
	/**
	 * 开窗赋值实现方法
	 */
	function openValues21(objValue,isShowBarcode){
		allocationForm.action="selAllocationBillsUpdate.action?billID="+objValue+"&isShowBarcode="+isShowBarcode;
		allocationForm.submit();
	}

    function deleteAllItem(obj){
        if (obj.options[obj.selectedIndex].getAttribute("companyID") != $('#indptcompanyid').val()){
    		var chk=document.getElementsByName("chk");
    		var table = document.getElementById('addTable');
    		for(i = 0; i < chk.length; i++){
    			var curRow = chk[i].parentNode.parentNode;		
    			table.deleteRow(curRow.rowIndex);
    			i = -1;
    		}
    		document.all.chks.checked = false;
    		
    		amount1();
    		needAmount();
    		
    		if($("table[id=addTable]").find("tr").size() == 2){
    			$("#goodscategoryname").text("");
    			$("#goodscategoryID").show();
    		}
        }

        $('#indptcompanyid').val(obj.options[obj.selectedIndex].getAttribute("companyID"));
    }

    function setCompanyNature(v){
    	if (v == '1'){
            $('#companyNatureDes').text('直营');

            if ('${fquartzSwitchPo.fqscbjs}' == '1'){
                $('#dj').text('单位成本');
                $('#hj').text('成本合计');
                $('#amounttype').val('2');
            }else{
                $('#dj').text('含税单价');
                $('#hj').text('价税合计');
                $('#amounttype').val('1');
            }
        }else if (v == '2'){
        	$('#companyNatureDes').text('加盟');
            $('#dj').text('批发单价');
            $('#hj').text('批发合计');
            $('#amounttype').val('3');
        }
    } 
    
	function jshj(index){
		$('input[hj = hj' + index + ']').val(parseFloat(accMul($('input[dj = dj' + index + ']').val(),$('input[dbs = dbs' + index + ']').val())).toFixed(2));
    }

	function jsdj(index){
		$('input[dj = dj' + index + ']').val(parseFloat(accDiv($('input[hj = hj' + index + ']').val(),$('input[dbs = dbs' + index + ']').val())).toFixed(6));
    }
    
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="allocationForm" method="post" action="">
<input type="hidden" name="smsFlag"  value="${smsFlag }" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="StatusID" name="StatusID" value="${StatusID}">
<input type="hidden" id="jumptype" name="jumptype" value="u">
<input type="hidden" id="hid" name="hid" value="${allocationPo.cshaabillid}">
<input type="hidden" id="cstpgoodscategory" name="cstpgoodscategory" value="">
<input type="hidden" id="cstpsupplierid" name="cstpsupplierid" value="">
<input type="hidden" id="brandID" name="brandID" value="">
<input type="hidden" name="allocation" id="allocation" value="allocation" />
<input type="hidden" id="companyNature" name="allocationPo.cshaacompanynature" value="${allocationPo.cshaacompanynature}">
<input type="hidden" id="amounttype" name="allocationPo.cshaaamounttype" value="${allocationPo.cshaaamounttype}">
<input type="hidden" id="indptcompanyid" name="allocationPo.cshaaindptcompanyid" value="${allocationPo.cshaaindptcompanyid}">
<input type="hidden" id="indpartid" name="indpartid" value="${allocationEntryList[0].cshaaeindepartmentid } ">

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
                    <TABLE class="privateBorder" cellSpacing=1 cellPadding=0 width="100%" align=center 
                  border=0 style='TABLE-LAYOUT: fixed'>
                      <TBODY>
                        <TR>
                          <TD width="9%"  class="table_body">调拨单号</TD>
                          <TD width="24%" class="table_none"><input class="text_input160" id="cshaabillid" name="allocationPo.cshaabillid" value="${allocationPo.cshaabillid}" readonly="readonly"></TD>
                          <TD width="9%"  class="table_body" height="26">关联单号</TD>
                          <TD width="24%" class="table_none"><input class="text_input160" id="cshaabillassociation" name="allocationPo.cshaabillassociation" value="${allocationPo.cshaabillassociation}" readonly="readonly"></TD>    
                          <TD width="9%"  class="table_body">发出部门</TD>
                          <TD class="table_none">
	                           	${allocationPo.cshaaoutdepartmentname}<input name="allocationPo.cshaaoutdepartmentname" type="hidden" value="${allocationPo.cshaaoutdepartmentname}"/>
                          		<input name="allocationPo.cshaaoutdepartmentid" type="hidden" value="${allocationPo.cshaaoutdepartmentid}"/>
		                      
		                      <!--<c:if test="${person.departmenttype eq '3' }" >
		                         <select id="cshaaoutdepartmentid" name="allocationPo.cshaaoutdepartmentid" onchange="showSubMenu1(this,this.options[this.options.selectedIndex].value);deleteAllItem(this);" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '发出部门不能为空！'}]">
	      		                 <option value="" retailtype=''>----请选择----</option>
	      		                 <s:iterator value="indepartmentsList">
					               <option value="${bdpdepartmentid}" ${allocationPo.cshaaoutdepartmentid== bdpdepartmentid  ? 'selected="selected"' : '' } retailtype='${bdpwhichretail }' companyNature='${bdpcompanynature}' companyID='${bdpcompanysid}'>(${bdpdepartmentid})${bdpdepartmentname}</option>
		     	                 </s:iterator>
	      	                   	</select>
		      	              </c:if>-->
                          </TD>			       
                        </tr>
                        <tr>
                          <TD class="table_body">发出仓位</TD>
						  <TD class="table_none">
							   <select id="cshaaoutstockid" name="allocationPo.cshaaoutstockid">
	      		                 <s:iterator value="outwarehouselist">
					               <c:if test="${allocationEntryList[0].cshaaoutstockid != null && allocationEntryList[0].cshaaoutstockid != ''}">
	      		                   	<option value="${bwhid}" ${allocationEntryList[0].cshaaoutstockid == bwhid  ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	      		                   </c:if>
	      		                   <c:if test="${allocationEntryList[0].cshaaoutstockid == null || allocationEntryList[0].cshaaoutstockid == ''}">
	      		                   	<option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid9==  bwhid  ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	      		                   </c:if>	     	                 
	      		                 </s:iterator>
	      	                   </select>
						   <!--<c:if test="${person.departmenttype eq '3' }" >
							   	<select id="cshaaoutstockid" name="allocationPo.cshaaoutstockid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '发出仓位不能为空！'}]">
                              		<option value="${allocationPo.cshaaoutstockid}">${allocationPo.cshaaoutstockname}</option>
      	                    	</select>
	      	               </c:if>-->
                           </TD>
						 <TD class="table_body">接收部门</TD>
                          <TD class="table_none">
                            <select id="cshaaindepartmentid" name="allocationPo.cshaaindepartmentid" onchange="showSubMenu(this,this.options[this.options.selectedIndex].value);" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '接收部门不能为空！'}]">
      		                 <s:iterator value="indepartmentsList">
				               <option value="${bdpdepartmentid}" ${allocationPo.cshaaindepartmentid!= bdpdepartmentid  ? '' : 'selected="selected"' } retailtype='${bdpwhichretail }'  companyNature='${bdpcompanynature}' companyID='${bdpcompanysid}'>(${bdpdepartmentid})${bdpdepartmentname}</option>
	     	                 </s:iterator>
      	                   </select>
      	                   <span id="companyNatureDes"></span>
                          </TD>
                          <TD class="table_body">接收仓位</TD>
                          <TD class="table_none">
                            <select id="cshaainstockid" name="allocationPo.cshaainstockid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '接收仓位不能为空！'}]">
                              	<option value="${allocationPo.cshaainstockid}">${allocationPo.cshaainstockname}</option>
      	                    </select>
                          </TD>
						</TR>
						<TR>
                          <TD class="table_body" height="26">制单人</TD>
                          <TD class="table_none" height="26">${allocationPo.cshaacreatepersonname}<input type="hidden" name="allocationPo.cshaacreatepersonname" value="${allocationPo.cshaacreatepersonname}"></TD>
						  <c:if test="${systemParameterPo.fspisallocationcategory ne '1'}">
						  <TD class="table_body" height="26">单据日期</TD>
                          <TD class="table_none" height="26" colspan="3">
                          ${fn:substring(allocationPo.cshaabilldate,0,10)}
                           <input name="allocationPo.cshaabilldate" type="hidden" value="${allocationPo.cshaabilldate}"/></TD>	
                          </c:if>
                          <c:if test="${systemParameterPo.fspisallocationcategory eq '1'}">
                          <TD class="table_body" height="26">单据日期</TD>
                          <TD class="table_none" height="26">
                          ${fn:substring(allocationPo.cshaabilldate,0,10)}
                          <input name="allocationPo.cshaabilldate" type="hidden" value="${allocationPo.cshaabilldate}"/></TD>
                          <TD width="9%" height="26" class="table_body">商品类别</TD>
                          <TD width="24%" height="26" class="table_none">
                              ${allocationPo.goodscategoryname }
                              <input id="goodscategoryID" name="allocationPo.goodscategoryid" type="hidden" value="${allocationPo.cshaacategoryid}"/>
                          </TD>
                          </c:if>		       	
                        </TR>
                        <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=5 style='word-WRAP: break-word'><label>
                          <textarea id="textarea" name="allocationPo.cshaaremark">${allocationPo.cshaaremark}</textarea>
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left" width="60%">
                          <c:if test="${person.departmenttype==3}">
                          <img src="${ctx }/img/newbtn/btn_receiptadd_0.png" btn=btn title="按收货单添加商品" onClick="javascript:openGoodReceipt();">
						  <img src="${ctx }/img/newbtn/btn_addgoodsbysales_0.png" btn=btn title="按销售数量添加商品" id="2D" onClick="javascript:openGoodsInfoForSOUT();"> 
						  </c:if>
						  <c:if test="${person.departmenttype==3 || (person.departmenttype == '1' && systemParameterPo.fspshoptoshop == '1')}">
						  <img src="${ctx }/img/newbtn/button_dj_0.png" btn=btn title="按调拨申请单添加商品" onClick="javascript:openGoodSingleAllForApp();">
						  <img src="${ctx }/img/newbtn/btn_ALLadd_0.png" btn=btn title="按调拨单添加商品" onclick="openGoodAllocation('');">
						  	  <c:if test="${permissionPo.keyg == '1'}">
	 						      <img src="${ctx }/img/newbtn/btn_ReALLadd_0.png" btn=btn title="按负调拨单添加商品" onclick="openGoodAllocation('2');">
	 						  </c:if>
				          </c:if>
						    <c:if test="${systemParameterPo.fspbarcodetype==3||systemParameterPo.fspbarcodetype==2}">
						    <img src="${ctx }/img/newbtn/btn_goodsadd_0.png" btn=btn title="单品添加商品" onClick="javascript:openGoodSingle();">
						    </c:if>
						     <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
						    <img src="${ctx}/img/newbtn/btn_scanbarcode_0.png" btn=btn title="条码扫描" onClick="javascript:scanbarcode();">
						    </c:if>
						    						
						   <img id="del" src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title="删除" onClick="deleteitem();" >
						   <img src="${ctx}/img/newbtn/btn_printbarcode_0.png" btn=btn title="打印条码" id="addGodos"
					      onClick="javascript:batPrintGoodsBarCode();">
						  </td>
                        </TR>
                        <tr>
                        <td align="right"><font color="red" size="2"><b>
                        <c:choose>
                        	<c:when test="${systemParameterPo.fspsalestype eq '0'}">
                        		*当商品调拨的数据大于可调用数量的时候，商品信息变为红色字体，不能正常调拨!
                        	</c:when>
                        	<c:when test="${systemParameterPo.fspsalestype eq '1'}">
                        		*当商品调拨的数据大于可调用数量的时候，商品信息变为红色字体!
                        	</c:when>     
                        </c:choose>                           
                        </b></font></td>
                        </tr>                        
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR >
                        	<TD align="left">
                        		<li class="horizontal_onlyRight">
                        			<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="button1" title='保存' onclick="save()">
                        		</li>
                        		<li class="horizontal_onlyRight">	                        	
	                          		<input type="checkbox" id="cshaaauditstate1" value="1" onclick="check()">保存并审核	                           	
	                           	</li>
                           	</TD>
                          <td align="right"><font color="red" size="2"><b>*双击商品数量可向下复制</b></font></td>
                        </TR>                     
                    </TABLE>
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </TABLE>
					<table id="addTable" width="100%" border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                        
                          <TH width="20%" scope=col>商品代码</TH>
                          <TH width="30%" scope=col>商品名称</TH>
                          <TH width="10%" scope=col>型号</TH>
                          <TH width="10%" scope=col>需求数量</TH>
                          <TH width="10%" scope=col>可调用数量</TH>
                          <TH width="10%" scope=col>调拨数量</TH> 
                        <c:if test="${permissionPo.keyi eq '1'}">
                            <c:if test="${allocationPo.cshaaamounttype eq '1'}">
                                <TH width="8%" scope=col id="dj">含税单价</TH>
                                <TH width="8%" scope=col id="hj">价税合计</TH> 
                            </c:if>
                            <c:if test="${allocationPo.cshaaamounttype eq '2'}">
                                <TH width="8%" scope=col id="dj">单位成本</TH>
                                <TH width="8%" scope=col id="hj">成本合计</TH> 
                            </c:if>
                            <c:if test="${allocationPo.cshaaamounttype eq '3'}">
                                <TH width="8%" scope=col id="dj">批发单价</TH>
                                <TH width="8%" scope=col id="hj">批发合计</TH> 
                            </c:if>
                        </c:if>
                           <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">                               
                          <TH width="25%" scope=col>商品条码</TH>
                          </c:if>                      
                        </TR>
                        <TR class=table_title align=middle> 
					  	  <TH width="40%" height="26" colSpan=6 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
				    	  <TH scope=col width="10%" id="goodsquantityTotal">0</TH>
				    	    <c:if test="${permissionPo.keyi eq '1'}">
					    		<TH scope=col width="10%">&nbsp;</TH> 
					    		<TH scope=col width="10%" id="goodsAmountTotal">0</TH>  
					    	</c:if>
				    	  <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">  
				    	  <TH  scope=col width="10%" >&nbsp;</TH>
				    	  </c:if> 
				   		</TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR >
                        	<TD align="left">
	                        	<li class="horizontal_onlyRight">
	                        		<img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn title='保存' onclick="save()">
	                        	</li>
	                        	<li class="horizontal_onlyRight">
	                          		<input type="checkbox" id="cshaaauditstate" onclick="check1()" name="allocationPo.cshaaauditstate" value="1">保存并审核
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
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR>
                    <tr><td></td></tr>    
            </TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>