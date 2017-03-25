<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>采购订单管理</title>
</head>
<script>
//-----------向下复制数量-------------------------
var indexBasic=1;
function goodsquantityAdd(obj){
	//alert(indexID.substring(13,indexID.length));
	
	var table = document.getElementById('addTable');
	var index = table.rows.length-1;

	if(confirm("是否向下复制数量?")){
		for(var i=parseInt(obj.id.substring(13,obj.id.length));i<parseInt(indexBasic);i++){
			if(document.getElementById('goodsquantity'+i)){
				document.getElementById('goodsquantity'+i).value = obj.value;
			}
		}
		 return true;
	}else{
		return false;
	} 			
}
//-----------向下复制数量-------------------------

	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	function addtdgoods(){
		procurementOrdersForm.action = "addProcurementOrderDimension.action";
		procurementOrdersForm.submit();
	}

	/**
	*  二维表开窗事件
	*/
	function open2D(){
		if ($('#cstpgoodscategory').val() != '3' && $('#cstpgoodscategory').val() != '4'){
	        alert("请选择镜片商品或隐性镜片商品!");
	        return;
	    }

		var chaasupplier =document.getElementById('cstpsupplierid').value;
	    if(chaasupplier==''){
		      alert('请选择制造商');
		      return false;
	    }

	    var goodsIdNew='';
	    var goodsNumNew='';
	    $("input[name=goodsInfoTempPo.goodsid]").each(function(){
	    	goodsIdNew=goodsIdNew+$(this).val()+",";
		});
	    $("input[name=goodsInfoTempPo.goodsquantity]").each(function(){
	    	goodsNumNew=goodsNumNew+$(this).val()+",";
		});
	    $('#tdgoodsids').val(goodsIdNew);
	    $('#tdvs').val(goodsNumNew);

	    if(checkForm(document.all.procurementOrdersForm)){
		    var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;			
			if(is_iPad()){
				showPopWin("initGoodsOpen_dimensional.action?tdgoodsids="+$('#tdgoodsids').val()+"&tdvs="+$('#tdvs').val()+"&cstpgoodscategory="+$('#cstpgoodscategory').val()+"&bspsuppliername="+EncodeUtf8($('#bspsuppliername').val())+"&cstpsupplierid="+$('#cstpsupplierid').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("initGoodsOpen_dimensional.action?tdgoodsids="+$('#tdgoodsids').val()+"&tdvs="+$('#tdvs').val()+"&cstpgoodscategory="+$('#cstpgoodscategory').val()+"&bspsuppliername="+EncodeUtf8($('#bspsuppliername').val())+"&cstpsupplierid="+$('#cstpsupplierid').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}			
			document.getElementById('popupTitle').innerHTML="【按二维表添加商品】";
		}

	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openValues1(objValue,supplierID,supplierName,goodscategoryID,departmentid){
		document.getElementById('cshaaabillid').value=objValue;
		document.getElementById('cstpsupplierid').value=supplierID;
		document.getElementById('bspsuppliername').value=supplierName;
		document.getElementById('cstpgoodscategory').value=goodscategoryID;
		document.getElementById('cshaaadepartmentid').value=departmentid;
		procurementOrdersForm.action="selApplyBills.action?billID="+objValue;
		procurementOrdersForm.submit();
	}
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var cstpgoodscategory = document.getElementById('cstpgoodscategory').value;
	    if(cstpgoodscategory == ''){
		    alert('请选择采购类型');
		    return false;
	    }
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=" + cstpgoodscategory,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=" + cstpgoodscategory,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商添加】";
	}
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		if(document.getElementById('cstpsupplierid').value != json.id){
			document.getElementById('cstpsupplierid').value = json.id;
			document.getElementById('bspsuppliername').value = json.value;
			$("#cshaaabillid").val("");
			deleteROW('2');
		}
	}
	
	function save(){
		var count=0;
		if(checkForm(document.all.procurementOrdersForm)){
			$("input[name=goodsInfoTempPo.goodsid]").each(function(){
				if($(this).val().substring(8,9)=='D'){
					count=parseFloat(accAdd(count,1)).toFixed(0);
				}
			});
			if($('#cstpgoodscategory').val()==3||$('#cstpgoodscategory').val()==4){
				if(count!=parseFloat("0").toFixed(0)&&count!=document.getElementsByName('goodsInfoTempPo.goodsid').length){
					alert("成品片和定制片不允许出现在同一张订单中！");
					return;
				}
			}
			if (document.getElementById('addTable').rows.length == 2){
				alert("请选择商品！");
				return;
			}
			
			//验证商品类别和制造商是否与添加商品一样
			var goodsCategory = document.getElementById('cstpgoodscategory').value;
			var supplierID = document.getElementById('cstpsupplierid').value;
			var chk=document.getElementsByName("chk");
			var length = chk.length;

			var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
			var goodsquantityCount=0;
			for(i=0;i<goodsquantityArray.length;i++)
			{
				if(goodsquantityArray[i].value=="0"){
					alert("商品数量不能为0！");
					goodsquantityArray[i].focus();
					return;	
				}
				if(isNaN(goodsquantityArray[i].value)||goodsquantityArray[i].value<0){
					alert("商品数量格式不正确！");
					goodsquantityArray[i].focus();
					return;	
				}
			}
				
			
			var re = new RegExp();
			re.compile("^" + goodsCategory + "\." + supplierID);
			
			var issubmit = '0';
			$('input[id=chk]').each(function(){ 
			 	if(!re.test($(this).val().toUpperCase())){
					issubmit='1';
				}
	
	        });
	        
	        if(issubmit == '1'){
	        	alert("制造商与添加的商品不匹配！");
	        	return;
	        }
		   $("img").removeAttr("onclick");
			procurementOrdersForm.action = "updateProcurementOrders.action";
			procurementOrdersForm.submit();
		}
	}
	
	function openGoodSingle(){
		var categoryID_open = document.getElementById('cstpgoodscategory').value;
	    if(categoryID_open==''){
		    alert('请选择商品类型');
		    return false;
	    }

	    var chaasupplier =document.getElementById('cstpsupplierid').value;
	    if(chaasupplier==''){
		    alert('请选择制造商');
		    return false;
	    }
	   	
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsSingleSel.action?categoryID_open="+categoryID_open+"&supplierID_open="+chaasupplier+"&app=app"+"&whichretail=1&select_retail=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSel.action?categoryID_open="+categoryID_open+"&supplierID_open="+chaasupplier+"&app=app"+"&whichretail=1&select_retail=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}
	
	function openGoodSingleAll(){
		var supplierID = document.getElementById('cstpsupplierid').value;
	    if(supplierID==''){
	    }	
	    
	    var cstpgoodscategory = document.getElementById('cstpgoodscategory').value;
	    if(cstpgoodscategory == ''){
	    }
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initGoodsSingleSelAll.action?categoryID_open=" + cstpgoodscategory + "&supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSelAll.action?categoryID_open=" + cstpgoodscategory + "&supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【选择调拨商品】";
	}
	//子页面添加单行	
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			addRow(goodInfos[i]);
			var ordertype = goodInfos[0].bgigoodsid.substring(0,1);
			$('#goodstype').val(ordertype);
			isshow(ordertype);
		}
		
		amount();
	}
	//子页面删除单行
	function openGoodSingleDeleteValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			deleterow(goodInfos[i]);
			
		}
		var tablelength = $('#addTable tr').length;
   		if(tablelength == 2){
   			$('#cstpsupplierid').val("");
   			$('#cstpgoodscategory').val("");
   			$('#bspsuppliername').val("");
		}
		amount();
	}
     function deleterow(goodInfo){
    	// 商品id去重
		var table = document.getElementById('addTable');
		
		$("input[id=chk]").each(function(){
         	if($(this).val()== goodInfo.bgigoodsid){
			   $(this).parent().parent().remove();	
           }
		});
		
		amount();
    }	

    function deleteROWss(){
        $('input[id=chk]').each(function(){ 
              $(this).parent().parent().remove(); 
         }); 
 		amount();
 	}
     	
	function openGoodAlert(){
		var cstpgoodscategory = document.getElementById('cstpgoodscategory').value;
	    if(cstpgoodscategory == ''){
	      alert('请选择采购类型');
	      return false;
	    }

	    var supplierID = document.getElementById('cstpsupplierid').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }
	    
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsAlertSel.action?categoryID_open=" + cstpgoodscategory + "&supplierID_open=" + supplierID+"&app=app&permissionPokeyg="+'${permissionPo.keyg}',970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsAlertSel.action?categoryID_open=" + cstpgoodscategory + "&supplierID_open=" + supplierID+"&app=app&permissionPokeyg="+'${permissionPo.keyg}',screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【预警商品查询】";
	}

	function addCSB(goodInfo){
		$('#cstpsupplierid').val(goodInfo.bgisupplierid);
		$('#cstpgoodscategory').val(goodInfo.bgigoodscategoryid);
		$('#bspsuppliername').val(goodInfo.bgisuppliername);
	}
	
	function addRow(goodInfo){
		addCSB(goodInfo);
		var table = document.getElementById('addTable');
		var index = 0;
		if(indexBasic==1){
			index = table.rows.length - 1;
		}
		else{
			index = indexBasic;
		}
				
		// 商品id去重
		var issubmit = '0';
		$("input[id=chk]").each(function(){
         	if($(this).val()== goodInfo.bgigoodsid){
					issubmit='1';
           }
		});
		if(issubmit == '1'){
	        return;
	    }
		if(goodInfo.goodsquantity<="0")
		{
			return;
		}
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);		//色号
		var c6 = row.insertCell(5);		//球径
		var c7 = row.insertCell(6);		//柱径
		var c8 = row.insertCell(7);		//下加光
		var c9 = row.insertCell(8);		//折射率
		var c10 = row.insertCell(9);	//光度分类
		var c11 = row.insertCell(10);	//材料分类
		var c12 = row.insertCell(11);	//曲率
		var c13 = row.insertCell(12);	//直径
		var c14 = row.insertCell(13);	//框架材质
		var c15 = row.insertCell(14);	//框架尺寸
		var c16 = row.insertCell(15);	//配件型
		var c17 = row.insertCell(16);	//使用类型 
		var c18 = row.insertCell(17);	//抛弃型分类
		var c19 = row.insertCell(18);	//老花镜度数
		var c20 = row.insertCell(19);	//厂家色号 
		var c21 = row.insertCell(20);	//主容量
		var c22 = row.insertCell(21);	//次容量
		var c23 = row.insertCell(22);
		var c24 = row.insertCell(23);
		
		row.className = 'row';
		row.height="26";
		c5.id="ys";		//色号
		  c6.id="qj";		//球径
		  c7.id="zj"; 		//柱径
		  c8.id="xjg"; 		//下加光
		  c9.id="zsl"; 		//折射率
		  c10.id="gdfl"; 		//光度分类
		  c11.id="clfl";		//材料分类
		  c12.id="ql"; 		//曲率
		  c13.id="zhj"; 		//直径
		  c14.id="kjcz"; 		//框架材质
		  c15.id="kjcc"; 		//框架尺寸
		  c16.id="pjlx"; 		//配件型
		  c17.id="sylx"; 		//使用类型 
		  c18.id="pqxfl";		//抛弃型分类
		  c19.id="lhjds";		//老花镜度数
		  c20.id="cjsh"; 		//厂家色号 
		  c21.id="zrl"; 		//主容量
		  c22.id="crl"; 		//次容量
		
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
		c4.innerHTML = goodInfo.bgispec;
		c5.innerHTML = goodInfo.bgisuppliercolor;
		c6.innerHTML = goodInfo.bgisph;		
		c7.innerHTML = goodInfo.bgicyl;				
		c8.innerHTML = goodInfo.bgibelowplusluminosity;
		c9.innerHTML = goodInfo.bgirefractive;
		var string1='';
		var string2='';
		var string3='';
		var string4='';
		var string5='';
		var string6='';
		 if(goodInfo.bgiismutiluminosity=="M"){string1='多光';}
		else if(goodInfo.bgiismutiluminosity=="0"){string1='单光';}
		else if(goodInfo.bgiismutiluminosity=="Q"){string1='其它';}
		else if(goodInfo.bgiismutiluminosity=="K"){string1='抗疲劳';}
		else if(goodInfo.bgiismutiluminosity=="J"){string1='渐近';}
		else {string1='';}
		 c10.innerHTML =string1;
		if(goodInfo.bgieyeglassmaterialtype=="1"){string2='树脂';}
			else if(goodInfo.bgieyeglassmaterialtype=="2"){string2='玻璃';}
			else if(goodInfo.bgieyeglassmaterialtype=="3"){string2='PC';}
			else{string2='';}
		c11.innerHTML = string2;
		
		c12.innerHTML = goodInfo.bgicurvature1;
		c13.innerHTML = goodInfo.bgidia;
		
		c14.innerHTML = goodInfo.bgiframematerialtypename;
		c15.innerHTML = goodInfo.bgiframesize;
		if(goodInfo.bgiframematerialtype=="1"){string4='框镜';}
		else if(goodInfo.bgiframematerialtype=="2"){string4='隐形';}
		else{string4='';}
		c16.innerHTML = string4;
		if(goodInfo.bgiusetype=="1"){string5='常带型';}
		else if(goodInfo.bgiusetype=="2"){string5='抛弃型';} 
		else if(goodInfo.bgiusetype=="3"){string5='塑形镜';} 
		else{string5='';}
		 c17.innerHTML = string5;
		if(goodInfo.bgistealthclass=="1"){string6 = '日抛';}
						else if(goodInfo.bgistealthclass=="2"){string6='周抛';}
						else if(goodInfo.bgistealthclass=="9"){string6='双周抛';}   
						else if(goodInfo.bgistealthclass=="3"){string6='月抛';}
						else if(goodInfo.bgistealthclass=="4"){string6='季抛';}
						else if(goodInfo.bgistealthclass=="5"){string6='半年抛';}
						else if(goodInfo.bgistealthclass=="6"){string6='年抛';}
						else if(goodInfo.bgistealthclass=="7"){string6='RGP';}
						else if(goodInfo.bgistealthclass=="8"){string6='塑形镜';}
						else{string6='';}
		c18.innerHTML = string6;
		c19.innerHTML = goodInfo.bgisph;
		c20.innerHTML = goodInfo.bgisuppliercolor;
		c21.innerHTML = goodInfo.bgicapacity;
		c22.innerHTML = goodInfo.bgicapacityentry;
		c23.innerHTML = '<input type="text" style="text-align:center;" onkeydown="OnKeyDownEnter(this)" id="goodsquantity'+ index +'" ondblclick="goodsquantityAdd(this)" onKeyUp="value=value.replace(/[^\\d\\.]/g,\'\')" name="goodsInfoTempPo.goodsquantity" onblur="amount();"  value="' + ((goodInfo.goodsquantity != "" && goodInfo.goodsquantity != null) ?  goodInfo.goodsquantity : "") + '" maxlength="18" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写订购商品数量！\'}, {\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写订购商品数量！\'}]"/>';
		c24.innerHTML = '<input type="text" style="margin-left:0;margin-right:0" name="goodsInfoTempPo.remark" value="" maxlength="50" />';
		indexBasic++;		
    }

	function changeGoodsCategory(){
  		 $('#cstpsupplierid').val('');
  		 $('#bspsuppliername').val('');
  		 $("#cshaaabillid").val("");
  		 deleteROW('1');
     }

	function OnKeyDownEnter(obj){
		if(event.keyCode == 13){
			var index = $("input[name=goodsInfoTempPo.goodsquantity]").index(obj)+1;
		    $("input[name=goodsInfoTempPo.goodsquantity]").eq(index).focus();
		}
	}

	function addRowX(goodInfo){
		var table = document.getElementById('addTable');
		var index = 0;
		if(indexBasic==1){
			index = table.rows.length - 1;
		}
		else{
			index = indexBasic;
		}
				
		// 商品id去重
		var issubmit = '0';
		$("input[id=chk]").each(function(){
         	if($(this).val()== goodInfo.bgigoodsid){
					issubmit='1';
           }
		});
		if(issubmit == '1'){
	        return;
	    }
		if(goodInfo.goodsquantity<="0")
		{
			return;
		}
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);		//色号
		var c6 = row.insertCell(5);		//球径
		var c7 = row.insertCell(6);		//柱径
		var c8 = row.insertCell(7);		//下加光
		var c9 = row.insertCell(8);		//折射率
		var c10 = row.insertCell(9);	//光度分类
		var c11 = row.insertCell(10);	//材料分类
		var c12 = row.insertCell(11);	//曲率
		var c13 = row.insertCell(12);	//直径
		var c14 = row.insertCell(13);	//框架材质
		var c15 = row.insertCell(14);	//框架尺寸
		var c16 = row.insertCell(15);	//配件型
		var c17 = row.insertCell(16);	//使用类型 
		var c18 = row.insertCell(17);	//抛弃型分类
		var c19 = row.insertCell(18);	//老花镜度数
		var c20 = row.insertCell(19);	//厂家色号 
		var c21 = row.insertCell(20);	//主容量
		var c22 = row.insertCell(21);	//次容量
		var c23 = row.insertCell(22);
		var c24 = row.insertCell(23);
		
		row.className = 'row';
		row.height="26";
		c5.id="ys";		//色号
		  c6.id="qj";		//球径
		  c7.id="zj"; 		//柱径
		  c8.id="xjg"; 		//下加光
		  c9.id="zsl"; 		//折射率
		  c10.id="gdfl"; 		//光度分类
		  c11.id="clfl";		//材料分类
		  c12.id="ql"; 		//曲率
		  c13.id="zhj"; 		//直径
		  c14.id="kjcz"; 		//框架材质
		  c15.id="kjcc"; 		//框架尺寸
		  c16.id="pjlx"; 		//配件型
		  c17.id="sylx"; 		//使用类型 
		  c18.id="pqxfl";		//抛弃型分类
		  c19.id="lhjds";		//老花镜度数
		  c20.id="cjsh"; 		//厂家色号 
		  c21.id="zrl"; 		//主容量
		  c22.id="crl"; 		//次容量
		
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
		c4.innerHTML = goodInfo.bgispec;
		c5.innerHTML = goodInfo.bgisuppliercolor;
		c6.innerHTML = goodInfo.bgisph;		
		c7.innerHTML = goodInfo.bgicyl;				
		c8.innerHTML = goodInfo.bgibelowplusluminosity;
		c9.innerHTML = goodInfo.bgirefractive;
		var string1='';
		var string2='';
		var string3='';
		var string4='';
		var string5='';
		var string6='';
		 if(goodInfo.bgiismutiluminosity=="M"){string1='多光';}
		else if(goodInfo.bgiismutiluminosity=="0"){string1='单光';}
		else if(goodInfo.bgiismutiluminosity=="Q"){string1='其它';}
		else if(goodInfo.bgiismutiluminosity=="K"){string1='抗疲劳';}
		else if(goodInfo.bgiismutiluminosity=="J"){string1='渐近';}
		else {string1='';}
		 c10.innerHTML =string1;
		if(goodInfo.bgieyeglassmaterialtype=="1"){string2='树脂';}
			else if(goodInfo.bgieyeglassmaterialtype=="2"){string2='玻璃';}
			else if(goodInfo.bgieyeglassmaterialtype=="3"){string2='PC';}
			else{string2='';}
		c11.innerHTML = string2;
		
		c12.innerHTML = goodInfo.bgicurvature1;
		c13.innerHTML = goodInfo.bgidia;
		
		c14.innerHTML = goodInfo.bgiframematerialtypename;
		c15.innerHTML = goodInfo.bgiframesize;
		if(goodInfo.bgiframematerialtype=="1"){string4='框镜';}
		else if(goodInfo.bgiframematerialtype=="2"){string4='隐形';}
		else{string4='';}
		c16.innerHTML = string4;
		if(goodInfo.bgiusetype=="1"){string5='常带型';}
		else if(goodInfo.bgiusetype=="2"){string5='抛弃型';} 
		else if(goodInfo.bgiusetype=="3"){string5='塑形镜';} 
		else{string5='';}
		 c17.innerHTML = string5;

		if(goodInfo.bgistealthclass=="1"){string6 = '日抛';}
		else if(goodInfo.bgistealthclass=="2"){string6='周抛';}
		else if(goodInfo.bgistealthclass=="9"){string6='双周抛';}   
		else if(goodInfo.bgistealthclass=="3"){string6='月抛';}
		else if(goodInfo.bgistealthclass=="4"){string6='季抛';}
		else if(goodInfo.bgistealthclass=="5"){string6='半年抛';}
		else if(goodInfo.bgistealthclass=="6"){string6='年抛';}
		else if(goodInfo.bgistealthclass=="7"){string6='RGP';}
		else if(goodInfo.bgistealthclass=="8"){string6='塑形镜';}
		else{string6='';}
		
		c18.innerHTML = string6;
		c19.innerHTML = goodInfo.bgisph;
		c20.innerHTML = goodInfo.bgisuppliercolor;
		c21.innerHTML = goodInfo.bgicapacity;
		c22.innerHTML = goodInfo.bgicapacityentry;
		c23.innerHTML = '<input type="text" style="text-align:center;" onkeydown="OnKeyDownEnter(this)" id="goodsquantity'+ index +'" ondblclick="goodsquantityAdd(this)" onKeyUp="value=value.replace(/[^\\d\\.]/g,\'\')" name="goodsInfoTempPo.goodsquantity" onblur="amount();"  value="' + ((goodInfo.bgigoodsquantity != "" && goodInfo.bgigoodsquantity != null) ?  goodInfo.bgigoodsquantity : "") + '" maxlength="18" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写订购商品数量！\'}, {\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写订购商品数量！\'}]"/>';
		c24.innerHTML = '<input type="text" style="margin-left:0;margin-right:0" name="goodsInfoTempPo.remark" value="'+goodInfo.CSTPERemark+'" maxlength="50"/>';
		indexBasic++;		
    }
	
	$(document).ready(function(){
		<s:iterator value="procurementOrdersEntrys">
		
	    var json = {'bgigoodsid':'${cstpegoodsid}','bgigoodsbarcode':'${bgiGoodsBarCode}','bgigoodsname':'${bgigoodsname}',
	    				'bgicostprice':'${bgicostprice}','bgiretailprice':'${bgiretailprice}','bgitaxrate':'${bgitaxrate}','bginottaxrate':'${bginottaxrate}',
	    				'bgispec':'${bgispec}','bgicolor':'${bgicolor}','bgisph':'${bgisph}','bgicyl':'${bgicyl}',
	    				'bgiaxis':'${bgiaxis}','bgicurvature1':'${bgicurvature1}','bgidia':'${bgidia}',
	    				'bgigoodsquantity':'${cstpeordernumber}','bgipcbarcode':'${bgiGoodsBarCode }'+'00000000',
	    				'bgiframematerialtype':'${bgiframematerialtype }','bgiframesize':'${bgiframesize}','bgiaccessoriestype':'${bgiaccessoriestype}',
	                    'bgibelowplusluminosity':'${bgibelowplusluminosity }','bgirefractive':'${bgirefractive}','bgiismutiluminosity':'${bgiismutiluminosity}',
	                    'bgieyeglassmaterialtype':'${bgieyeglassmaterialtype }','bgiusetype':'${bgiusetype}','bgistealthclass':'${bgistealthclass}',
	                    'bgicapacity':'${bgicapacity }','bgicapacityentry':'${bgicapacityentry}','bgisuppliercolor':'${bgisuppliercolor}','bgiframematerialtypename':'${bgiframematerialtypename}',
	    				'bgisource':'${bgisource}','CSTPERemark':'${cstperemark}'};
		
	    addRowX(json)                
		</s:iterator>
		
		isshow($('#goodstype').val());
		amount();
		});

    
    function deleteitem(){
        $('input[id=chk]').each(function(){ 
           if($(this).is(":checked")){ 
             $(this).parent().parent().remove(); 
           } 
        }); 

		document.all.chks.checked = false;
		amount();

    }
    
    
     function check()
    {
      if(document.all.cstiauditstate1.checked==true)
      {
      	document.all.cstiauditstate.checked = true;	
      }else
      {
      	document.all.cstiauditstate.checked = false;	
      }
    }
    
     function check1()
    {
      if(document.all.cstiauditstate.checked==true)
      {
      	document.all.cstiauditstate1.checked = true;	
      }else
      {
      	document.all.cstiauditstate1.checked = false;	
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
    
    function amount(){
    	var goodsquantityTotal = 0;
		var goodsquantity = document.getElementsByName("goodsInfoTempPo.goodsquantity");
		
		for(goodsI=0;goodsI<goodsquantity.length;goodsI++){
			if(goodsquantity[goodsI].value == '' || isNaN(goodsquantity[goodsI].value)) continue;
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[goodsI].value))).toFixed(0);
		}	
		document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
	}

	  function isshow(ordertype){
	    	if(ordertype==""){
	    		type = $('#cstpgoodscategory').val();
	    	}else{
	    		type = ordertype;
	    		$('#cstpgoodscategory').val(ordertype);
	    	}
	    	
	    	if(type == ""){
	    		$('#div_goodslist').attr("style","display: none;");
	    	}else{
	    		if(type == "1"){
	    		
	    			$('[id=ys]').show();
	    			$('[id=qj]').hide();
	    			$('[id=zj]').hide();
	    			$('[id=ql]').hide();
	    			$('[id=zhj]').hide();
	    			$('[id=xjg]').hide();
	    			$('[id=zsl]').hide();
	    			$('[id=gdfl]').hide();
	    			$('[id=clfl]').hide();
	    			$('[id=kjcz]').show();
	    			$('[id=kjcc]').show();
	    			$('[id=pjlx]').hide();
	    			$('[id=sylx]').hide();
	    			$('[id=pqxfl]').hide();
	    			$('[id=lhjds]').hide();
	    			$('[id=cjsh]').hide();
	    			$('[id=zrl]').hide();
	    			$('[id=crl]').hide();
	    			
	    	$('#heji').attr("colSpan","7");

	    		}else if(type == "2"){
	    			$('[id=ys]').hide();
	    			$('[id=qj]').hide();
	    			$('[id=zj]').hide();
	    			$('[id=ql]').hide();
	    			$('[id=zhj]').hide();
	    			$('[id=xjg]').hide();
	    			$('[id=zsl]').hide();
	    			$('[id=gdfl]').hide();
	    			$('[id=clfl]').hide();
	    			$('[id=kjcz]').hide();
	    			$('[id=kjcc]').hide();
	    			$('[id=pjlx]').show();
	    			$('[id=sylx]').hide();
	    			$('[id=pqxfl]').hide();
	    			$('[id=lhjds]').hide();
	    			$('[id=cjsh]').hide();
	    			$('[id=zrl]').hide();
	    			$('[id=crl]').hide();
	    			
	    			$('#heji').attr("colSpan","5");
				
	    		}else if(type == "3"){
	    			$('[id=ys]').hide();
	    			$('[id=qj]').show();
	    			$('[id=zj]').show();
	    			$('[id=ql]').hide();
	    			$('[id=zhj]').hide();
	    			$('[id=xjg]').show();
	    			$('[id=zsl]').show();
	    			$('[id=gdfl]').show();
	    			$('[id=clfl]').show();
	    			$('[id=kjcz]').hide();
	    			$('[id=kjcc]').hide();
	    			$('[id=pjlx]').hide();
	    			$('[id=sylx]').hide();
	    			$('[id=pqxfl]').hide();
	    			$('[id=lhjds]').hide();
	    			$('[id=cjsh]').hide();
	    			$('[id=zrl]').hide();
	    			$('[id=crl]').hide();	
					$('#heji').attr("colSpan","10");
	    		}else if(type == "4"){
	    			$('[id=ys]').hide();
	    			$('[id=qj]').show();
	    			$('[id=zj]').show();
	    			$('[id=ql]').show();
	    			$('[id=zhj]').show();
	    			$('[id=xjg]').hide();
	    			$('[id=zsl]').hide();
	    			$('[id=gdfl]').hide();
	    			$('[id=clfl]').hide();
	    			$('[id=kjcz]').hide();
	    			$('[id=kjcc]').hide();
	    			$('[id=pjlx]').hide();
	    			$('[id=sylx]').show();
	    			$('[id=pqxfl]').show();
	    			$('[id=lhjds]').hide();
	    			$('[id=cjsh]').hide();
	    			$('[id=zrl]').hide();
	    			$('[id=crl]').hide();
	    			
						$('#heji').attr("colSpan","10");
					
					
	    			
	    		}else if(type == "5"){
	    		
	    			$('[id=ys]').hide();
	    			$('[id=qj]').hide();
	    			$('[id=zj]').hide();
	    			$('[id=ql]').hide();
	    			$('[id=zhj]').hide();
	    			$('[id=xjg]').hide();
	    			$('[id=zsl]').hide();
	    			$('[id=gdfl]').hide();
	    			$('[id=clfl]').hide();
	    			$('[id=kjcz]').hide();
	    			$('[id=kjcc]').hide();
	    			$('[id=pjlx]').hide();
	    			$('[id=sylx]').hide();
	    			$('[id=pqxfl]').hide();
	    			$('[id=lhjds]').hide();
	    			$('[id=cjsh]').hide();
	    			$('[id=zrl]').show();
	    			$('[id=crl]').show();
	    				$('#heji').attr("colSpan","6");
					
	    			
	    		}else if(type == "6"){
	    		
	    			$('[id=ys]').show();
	    			$('[id=qj]').hide();
	    			$('[id=zj]').hide();
	    			$('[id=ql]').hide();
	    			$('[id=zhj]').hide();
	    			$('[id=xjg]').hide();
	    			$('[id=zsl]').hide();
	    			$('[id=gdfl]').hide();
	    			$('[id=clfl]').hide();
	    			$('[id=kjcz]').hide();
	    			$('[id=kjcc]').show();
	    			$('[id=pjlx]').hide();
	    			$('[id=sylx]').hide();
	    			$('[id=pqxfl]').hide();
	    			$('[id=lhjds]').hide();
	    			$('[id=cjsh]').hide();
	    			$('[id=zrl]').hide();
	    			$('[id=crl]').hide();
	    			
						$('#heji').attr("colSpan","6");
					
	    			
	    		}else if(type == "8"){
	    		
	    			$('[id=ys]').hide();
	    			$('[id=qj]').hide();
	    			$('[id=zj]').hide();
	    			$('[id=ql]').hide();
	    			$('[id=zhj]').hide();
	    			$('[id=xjg]').hide();
	    			$('[id=zsl]').hide();
	    			$('[id=gdfl]').hide();
	    			$('[id=clfl]').hide();
	    			$('[id=kjcz]').hide();
	    			$('[id=kjcc]').show();
	    			$('[id=pjlx]').hide();
	    			$('[id=sylx]').hide();
	    			$('[id=pqxfl]').hide();
	    			$('[id=lhjds]').show();
	    			$('[id=cjsh]').show();
	    			$('[id=zrl]').hide();
	    			$('[id=crl]').hide();
	    			
						$('#heji').attr("colSpan","7");
					
	    			
	    		}else if(type == "7"){
	    		
	    			$('[id=ys]').hide();
	    			$('[id=qj]').hide();
	    			$('[id=zj]').hide();
	    			$('[id=ql]').hide();
	    			$('[id=zhj]').hide();
	    			$('[id=xjg]').hide();
	    			$('[id=zsl]').hide();
	    			$('[id=gdfl]').hide();
	    			$('[id=clfl]').hide();
	    			$('[id=kjcz]').hide();
	    			$('[id=kjcc]').hide();
	    			$('[id=pjlx]').hide();
	    			$('[id=sylx]').hide();
	    			$('[id=pqxfl]').hide();
	    			$('[id=lhjds]').hide();
	    			$('[id=cjsh]').hide();
	    			$('[id=zrl]').hide();
	    			$('[id=crl]').hide();
	    			
						$('#heji').attr("colSpan","4");
					
	    			
	    		}else if(type == "9"){
	    		
	    			$('[id=ys]').hide();
	    			$('[id=qj]').hide();
	    			$('[id=zj]').hide();
	    			$('[id=ql]').hide();
	    			$('[id=zhj]').hide();
	    			$('[id=xjg]').hide();
	    			$('[id=zsl]').hide();
	    			$('[id=gdfl]').hide();
	    			$('[id=clfl]').hide();
	    			$('[id=kjcz]').hide();
	    			$('[id=kjcc]').hide();
	    			$('[id=pjlx]').hide();
	    			$('[id=sylx]').hide();
	    			$('[id=pqxfl]').hide();
	    			$('[id=lhjds]').hide();
	    			$('[id=cjsh]').hide();
	    			$('[id=zrl]').hide();
	    			$('[id=crl]').hide();
	    			$('#heji').attr("colSpan","4");
					
	    		}

	    		$('#div_goodslist').attr("style","display:");
	    	}
	    }  

	  function deleteROW(id){
	   		var tablelength = $('#addTable tr').length;
	   		type = $('#cstpgoodscategory').val();
	   		
	   		if(tablelength > 2){
	   			if(confirm('更改 采购类型 或 制造商 会清空现有商品信息，是否进行更改？')){
	   				if(id=="1"){
	   					var i = 0;
		    		
						$('#addTable tr').each(function (){
							i++;
							if(i > 2){
								$(this).remove();
							}
						});
						
						$('#div_goodslist').attr("style","display: none;");
						
						$('#cshaaabillid').val('');
						$('#cstpsupplierid').val('');
						$('#bspsuppliername').val('');

						amount();
	   				}
		    		
		    		if(id=="2"){

		    			var i = 0;
		    		
						$('#addTable tr').each(function (){
							i++;
							if(i > 2){
								$(this).remove();
							}
						});
						
						$('#div_goodslist').attr("style","display: none;");
						amount();
		    			openSupplier();
		    		}
				}else{
					if(id=="1"){
						$('#cstpgoodscategory').val($('#goodstype').val());
						isshow($('#goodstype').val());
					}
					
				}
				
				
			}else if(id=="2"){
				openSupplier();
			}
			
	   	} 
	  function openGoodsInfoForSOUT(){
		var categoryID_open = document.getElementById('cstpgoodscategory').value;
	    var chaasupplier =document.getElementById('cstpsupplierid').value;
	
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelGoodsInfoForSOUT.action?categoryID_open="+categoryID_open+"&supplierID_open="+chaasupplier+"&app=app",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelGoodsInfoForSOUT.action?categoryID_open="+categoryID_open+"&supplierID_open="+chaasupplier+"&app=app",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【销售商品查询】";
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="procurementOrdersForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="goodstype" id="goodstype" value="${procurementOrdersPo.cstpgoodscategory}" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="tdgoodsids" name="tdgoodsids" value="${tdgoodsids }" />
<input type="hidden" id="tdvs" name="tdvs" value="${tdvs }" />
<input type="hidden" id="ioru" name="ioru" value="u" />

<DIV>
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
                    <TABLE class="privateBorder" cellSpacing=1 cellPadding=0 width="100%" align=center 
                  border=0>
                      <TBODY>
                        <TR>
                          <TD width="9%" class="table_body" height="26">单据编号</TD>
                          <TD width="24%" class="table_none" height="26">${procurementOrdersPo.cstpid }<input class="text_input200" type="hidden" name="procurementOrdersPo.cstpid" readonly="readonly" value="${procurementOrdersPo.cstpid }"></TD>
                          <TD width="9%" class="table_body" height="26">调拨申请单号</TD>
                          <TD width="24%" class="table_none" height="26">${procurementOrdersPo.cshaaabillid }<input class="text_input200" type="hidden" id='cshaaabillid' name="procurementOrdersPo.cshaaabillid" readonly="readonly" value="${procurementOrdersPo.cshaaabillid }"></TD>
                          <TD width="9%" class="table_body">采购类型</TD>
	                      <TD class="table_none">
	                          <select id="cstpgoodscategory" name="procurementOrdersPo.cstpgoodscategory" onchange="changeGoodsCategory();isshow('');">
						  		<option value="">----请选择----</option>
						  		<s:iterator value="goodsCategorys">
								<option value="${bgcid}" ${procurementOrdersPo.cstpgoodscategory== bgcid  ? 'selected="selected"' : '' } >${bgcgoodscategoryname}</option>
	     	               		</s:iterator>
	                          </select>
                          </TD>
                          </TR>
                      	  <TR>
                      	  <TD class="table_body">制造商</TD>
						  <TD height="26" align="left" class="table_none">
						   <li class="horizontal_onlyRight">
						   		<input id="bspsuppliername" class="text_input160" name="procurementOrdersPo.bspsuppliername" value="${procurementOrdersPo.bspsuppliername}" readonly="readonly" />
						   		<input type="hidden" id="cstpsupplierid" name="procurementOrdersPo.cstpsupplierid" value="${procurementOrdersPo.cstpsupplierid}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" name=ctl00$PageBody$Button1 onClick="openSupplier();"></li></TD>
                          </TD>
                          <TD class="table_body" height="26">制单人</TD>
                          <TD class="table_none" >${procurementOrdersPo.createPersonName }<input class="text_input100" type="hidden" name="procurementOrdersPo.cstpcreateperson" value="${procurementOrdersPo.cstpcreateperson }">
                          <input class="text_input100" type="hidden" name="procurementOrdersPo.createPersonName" value="${procurementOrdersPo.createPersonName }">
                          </TD>
                          <TD class="table_body">单据日期</TD>
                          <TD class="table_none">${fn:substring(procurementOrdersPo.cstpcreatedate,0,10)}
                          <input class="text_input100" type="hidden" name="procurementOrdersPo.cstpbilldate" type="hidden" value="${procurementOrdersPo.cstpcreatedate }"/></TD>
                          </tr>
                        <TR>
                          <TD class="table_body" height="26">收货联系人</TD>
                          <TD class="table_none"><input id="deliveryperson" class="text_input160" maxlength="20" type="text" name="procurementOrdersPo.cstpordersdeliveryperson" value="${procurementOrdersPo.cstpordersdeliveryperson}" validate="[{'Type' : Type.String, 'Formula' : Formula.PersonNameOrNULL, 'Message' : '请重新填写收货联系人!'}]"/></TD>
                          <TD class="table_body">收货联系电话</TD>
                          <TD class="table_none"><input id="deliveryphone" class="text_input160" maxlength="20" type="text" name="procurementOrdersPo.cstpordersdeliveryphone" value="${procurementOrdersPo.cstpordersdeliveryphone}" validate="[{'Type' : Type.String, 'Formula' : Formula.PhoneORNULL, 'Message' : '请重新填写收货联系电话!'}]"/></TD>
                          <TD class="table_body">收货联系传真</TD>
                          <TD class="table_none"><input id="deliveryfax" class="text_input160" maxlength="20" type="text" name="procurementOrdersPo.cstpordersdeliveryfax" value="${procurementOrdersPo.cstpordersdeliveryfax}" validate="[{'Type' : Type.String, 'Formula' : Formula.PhoneORNULL, 'Message' : '请重新填写收货联系传真!'}]"/></TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">收货地址</TD>
                          <TD class="table_none" colspan="5"><input id="deliveryaddress" class="text_input200" maxlength="100" type="text" name="procurementOrdersPo.cstpordersdeliveryaddress" value="${procurementOrdersPo.cstpordersdeliveryaddress}" style="width: 600" validate="[{'Type' : Type.String, 'Formula' : Formula.ObjectNameOrNULL, 'Message' : '请重新填写收货地址!'}]"/></TD>
                        </TR>
                        <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=5><label>
                          <textarea name="procurementOrdersPo.cstpremark" id="textarea"
                          	validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [2001]}, 'Message' : '备注不能大于2000字！'}]">${procurementOrdersPo.cstpremark }</textarea>
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left" width="60%">
						  <span style="vertical-align:middle;" mce_style="vertical-align:middle;"><img src="${ctx}/img/newbtn/btn_addgoods_0.png" btn=btn title="单品添加商品" onClick="javascript:openGoodSingle();">
						  <img src="${ctx}/img/newbtn/btn_addredgoods_0.png" btn=btn title="选择预警商品"  id="alertGoods"
					      onClick="javascript:openGoodAlert();">
					      <img src="${ctx}/img/newbtn/btn_addtwogoods_0.png" btn=btn title="二维表添加商品" id="2D"
					      onClick="javascript:open2D();"> 
					      <img src="${ctx }/img/newbtn/btn_addgoodsbysales_0.png" btn=btn title="按销售数量添加商品" id="2D"
					      onClick="javascript:openGoodsInfoForSOUT();"></span>
					      </TD>
					      <td align="right" width="60%"><img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title="删除" onClick="deleteitem();" ></td>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
                        <TR>
                          <TD align="left">
                          <li class="horizontal_onlyRight"><img id="savebtn1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn title="保存" onclick="save();"></li>
                          <li class="horizontal_onlyRight"><input id="cstiauditstate1" type="checkbox" value="1" onclick="check()">保存并审核</li>
                          </TD>
                          <td align="right"><font color="red" size="2"><b>*除通过二维表新增的商品外，双击商品数量可向下复制</b></font></td>
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
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
						  <TH scope=col width="5%">全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>
						  <TH scope=col width="20%" height="26">商品代码</TH>
						  <TH scope=col width="15%">商品名称</TH>
                          <TH scope=col width="10%">型号</TH>
                          <TH width="6%" scope=col id=ys>厂家色号</TH>
                          <TH width="6%" scope=col id=qj>球镜</TH>
                          <TH width="6%" scope=col id=zj>柱镜</TH>
                          <TH width="6%" scope=col id=xjg>下加光</TH>
                          <TH width="6%" scope=col id=zsl>折射率</TH>
                          <TH width="6%" scope=col id=gdfl>光度分类</TH>
                          <TH width="6%" scope=col id=clfl>材料分类</TH>
                          <TH width="6%" scope=col id=ql>曲率</TH>
                          <TH width="6%" scope=col id=zhj>直径</TH> 
                          <TH width="6%" scope=col id=kjcz>框架材质</TH>
                          <TH width="6%" scope=col id=kjcc>框架尺寸</TH>
                          <TH width="6%" scope=col id=pjlx>配件型 </TH>
                          <TH width="6%" scope=col id=sylx>使用类型  </TH>
                          <TH width="6%" scope=col id=pqxfl>抛弃型分类  </TH>
                          <TH width="6%" scope=col id=lhjds>老花镜度数 </TH>
                          <TH width="6%" scope=col id=cjsh>厂家色号 </TH>
                          <TH width="6%" scope=col id=zrl>主容量 </TH>
                          <TH width="6%" scope=col id=crl>次容量 </TH>
                          <TH scope=col width="3%">采购数量</TH>
                          <TH scope=col width="7%">备注</TH>
                        </TR>
                        <TR class=table_title align=middle> 
						  	<TH width="40%" height="26" id="heji"  colSpan=10 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
					    	<TH scope=col width="10%" >&nbsp;</TH>
				   		</TR>
				   		<c:forEach var="po" items="${goodsInfoPos}">    		
				   		<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
				   			<Td><input id="chk" type="checkbox" value="${po.bgigoodsid}" ></Td>
				   			<Td>${po.bgigoodsid}<input type="hidden" name="goodsInfoTempPo.goodsid" value="${po.bgigoodsid}" /></Td>
				   			<Td>${po.bgigoodsname}</Td>
				   			<Td>${po.bgispec }</Td>
				   			<Td id=ys>${po.bgisuppliercolor }</Td>
				   			<Td id=qj>${po.bgisph }</Td>
				   			<Td id=zj>${po.bgicyl }</Td>
				   			<Td id=xjg>${po.bgibelowplusluminosity }</Td>
				   			<Td id=zsl>${po.bgirefractive }</Td>
				   			<Td id=gdfl>
				   			    <c:if test="${po.bgiismutiluminosity eq 'M' }">多光</c:if>
				   			    <c:if test="${po.bgiismutiluminosity eq '0' }">单光</c:if>
				   			    <c:if test="${po.bgiismutiluminosity eq 'Q' }">其它</c:if>
				   			    <c:if test="${po.bgiismutiluminosity eq 'K' }">抗疲劳</c:if>
				   			    <c:if test="${po.bgiismutiluminosity eq 'J' }">渐近</c:if>
				   			</Td>
				   			<Td id=clfl>
				   			    <c:if test="${po.bgieyeglassmaterialtype eq '1' }">树脂</c:if>
				   			    <c:if test="${po.bgieyeglassmaterialtype eq '2' }">玻璃</c:if>
				   			    <c:if test="${po.bgieyeglassmaterialtype eq '3' }">PC</c:if>
				   			</Td>
				   			<Td id=ql>${po.bgicurvature1 }</Td>
				   			<Td id=zhj>${po.bgidia }</Td>
				   			<Td id=kjcz>${po.bgiframematerialtypename }</Td>
				   			<Td id=kjcc>${po.bgiframesize}</Td>
				   			<Td id=pjlx>
				   			    <c:if test="${po.bgiframematerialtype eq '1' }">框镜</c:if>
				   			    <c:if test="${po.bgiframematerialtype eq '2' }">隐形</c:if>
				   			</Td>
				   			<Td id=sylx>
				   			    <c:if test="${po.bgiusetype eq '1' }">常带型</c:if>
				   			    <c:if test="${po.bgiusetype eq '2' }">抛弃型</c:if>
				   			    <c:if test="${po.bgiusetype eq '3' }">塑形镜</c:if>
				   			</Td>
				   			<Td id=pqxfl>
				   			    <c:if test="${po.bgistealthclass eq '1' }">日抛</c:if>
				   			    <c:if test="${po.bgistealthclass eq '2' }">周抛</c:if>
				   			    <c:if test="${po.bgistealthclass eq '9' }">双周抛</c:if>
				   			    <c:if test="${po.bgistealthclass eq '3' }">月抛</c:if>
				   			    <c:if test="${po.bgistealthclass eq '4' }">季抛</c:if>
				   			    <c:if test="${po.bgistealthclass eq '5' }">半年抛</c:if>
				   			    <c:if test="${po.bgistealthclass eq '6' }">年抛</c:if>
				   			    <c:if test="${po.bgistealthclass eq '7' }">RGP</c:if>
				   			    <c:if test="${po.bgistealthclass eq '8' }">塑形镜</c:if>
				   			</Td>
				   			<Td id=lhjds>${po.bgisph}</Td>
				   			<Td id=cjsh>${po.bgisuppliercolor}</Td>
				   			<Td id=zrl>${po.bgicapacity}</Td>
				   			<Td id=crl>${po.bgicapacityentry}</Td>
				   			<Td><input type="text" class="text_input40"  name="goodsInfoTempPo.goodsquantity" onblur="amount();"  value="${po.bgigoodsquantity }" maxlength="18" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写订购商品数量！'}, {'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写订购商品数量！'}]"/></Td>
							<Td><input type="text" class="text_input60" name="goodsInfoTempPo.remark" value="" maxlength="50" /></Td>
				   		  </tr>				   		
				   	     </c:forEach>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
                        <TR>
                          <TD align="left"><li class="horizontal_onlyRight"><img id="savebtn" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn title='保存' onclick="save();"></li>
                          				   <li class="horizontal_onlyRight"><input id="cstiauditstate" name="stateFlag" type="checkbox" value="1" onclick="check1()">保存并审核</li></TD>
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