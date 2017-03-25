<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成品镜片维护</title>
</head>
<script>
	function trim(str){ //删除左右两端的空格
　　 	return str.replace(/(^\s*)|(\s*$)/g, "");
　　 }

    function getGoodsID(name,value){
      value=trim(value);
      var spec="";
      var goodsID=document.all.bgigoodsid.value;
      if('${systemParameterPo.fspnegative}'=='1'){
	      if(name=='supplier'){
	         var goodsID1=goodsID.substring(0,2);
	         var goodsID2=goodsID.substring(4,22);
	         goodsID=goodsID1+value+goodsID2;
	      }else if(name=='brand'){
	         var goodsID1=goodsID.substring(0,5);
	         var goodsID2=goodsID.substring(7,22);
	         goodsID=goodsID1+value+goodsID2;
	      }else if(name=='bgisph'){
	    	  var goodsID1=goodsID.substring(0,8);
	   	   var goodsID2=goodsID.substring(9,10);
	          var goodsID4=goodsID.substring(14,22);
	 		
	 		 var value1 = 0;
	 		var value2="A";
	 		 if(value == 0){
	 		 	value1 = value.replace('.' , '');
	 			value1 = Math.abs(value1);
	 			value1 = "0000";
	 			var value2="A";
	 		 }else if(value < 0 && value > -1){
	 		 	value1 = value.replace('.' , '');
	 			value1 = Math.abs(value1);
	 			value1 = "00"+ value1;
	 			var value2="A";
	 		 }else if(value <= -1 && value > -10){
	 			value1 = value.replace('.' , '');
	 			value1 = Math.abs(value1);
	 			value1 = "0"+ value1;
	 			var value2="A";
	 		 }else if(value <= -10 ){
	 			value1 = value.replace('.' , '');
	 			value1 = Math.abs(value1);
	 			value1 =  value1;
	 			var value2="A";
	 		 }else if(value > 0 && value < 1){
	 		 	value1 = value.replace('.' , '');
	 			value1 = Math.abs(value1);
	 			value1 = "00"+ value1;
	 			var value2="B";
	 		 }else if(value >= 1 && value < 10){
	 			value1 = value.replace('.' , '');
	 			value1 = Math.abs(value1);
	 			value1 = "0"+ value1;
	 			var value2="B";
	 		 }else if(value >= 10 ){
	 			value1 = value.replace('.' , '');
	 			value1 = Math.abs(value1);
	 			value1 = value1;
	 			var value2="B";
	 		 }
	 		 goodsID=goodsID1+value2+goodsID2+value1+goodsID4;
	      }else if(name=='bgicyl'){
	         var goodsID1=goodsID.substring(0,9);
	         var goodsID2=goodsID.substring(10,14);
	         var goodsID3=goodsID.substring(17,22);
			 var value2="";
			 var value1 = 0;
			 
			 if(value == 0){
			 	value1 = value.replace('.' , '');
				value1 = Math.abs(value1);
				value1 = "000";
				value2="A";
			 }else if(value <= 0 && value > -1){
			 	value1 = value.replace('.' , '');
				value1 = Math.abs(value1);
				value1 = "0"+ value1;
				value2="A";
			 }else if(value <= -1 && value > -10){
				value1 = value.replace('.' , '');
				value1 = Math.abs(value1);
				value2="A";
			 }else if(value > 0 && value < 1){
				value1 = value.replace('.' , '');
				value1 = Math.abs(value1);
				value1 = "0"+ value1;
				value2="B";
			}else if(value >= 1 && value < 10){
				value1 = value.replace('.' , '');
				value1 = Math.abs(value1);
				value1 =  value1;
				value2="B";
			}
			
			goodsID=goodsID1+value2+goodsID2+value1+goodsID3;
	      }else if(name=='color'){
	         if(value.length>10){
	           alert('商品编码不能大于10字符');
	           document.getElementById('bgicolor').value='';
	           return false;
	         }
	         var goodsID1=goodsID.substring(0,18);
	         var length=4-value.length;
	         if(length>0){
	           for(var i=0;i<length;i++){
	             value='0'+value;
	           }
	         }else{
	           value = value.substring(value.length-4,value.length);
	         }
	         goodsID=goodsID1+value;
	      }
      }else{
    	  if(name=='supplier'){
    	         var goodsID1=goodsID.substring(0,2);
    	         var goodsID2=goodsID.substring(4,22);
    	         goodsID=goodsID1+value+goodsID2;
    	      }else if(name=='brand'){
    	         var goodsID1=goodsID.substring(0,5);
    	         var goodsID2=goodsID.substring(7,22);
    	         goodsID=goodsID1+value+goodsID2;
    	      }else if(name=='bgisph'){
    			 
    	         var goodsID1=goodsID.substring(0,8);
    	         var goodsID2=goodsID.substring(14,22);
    			 
    			 var value1 = 0;
    			 
    			 if(value == 0){
    			 	value1 = value.replace('.' , '');
    				value1 = Math.abs(value1);
    				value1 = "CA0000";
    			 }else if(value < 0 && value > -1){
    			 	value1 = value.replace('.' , '');
    				value1 = Math.abs(value1);
    				value1 = "CA00"+ value1;
    			 }else if(value <= -1 && value > -10){
    				value1 = value.replace('.' , '');
    				value1 = Math.abs(value1);
    				value1 = "CA0"+ value1;
    			 }else if(value <= -10 ){
    				value1 = value.replace('.' , '');
    				value1 = Math.abs(value1);
    				value1 = "CA"+ value1;
    			 }
    			 
    			 else if(value > 0 && value < 1){
    			 	value1 = value.replace('.' , '');
    				value1 = Math.abs(value1);
    				value1 = "CB00"+ value1;
    			 }else if(value >= 1 && value < 10){
    				value1 = value.replace('.' , '');
    				value1 = Math.abs(value1);
    				value1 = "CB0"+ value1;
    			 }else if(value >= 10 ){
    				value1 = value.replace('.' , '');
    				value1 = Math.abs(value1);
    				value1 = "CB"+ value1;
    			 }
    			 
    	         goodsID=goodsID1+value1+goodsID2;
    	      }else if(name=='bgicyl'){
    			 
    	         var goodsID1=goodsID.substring(0,14);
    	         var goodsID2=goodsID.substring(17,22);
    			 
    			 var value1 = 0;
    			 
    			 if(value == 0){
    			 	value1 = value.replace('.' , '');
    				value1 = Math.abs(value1);
    				value1 = "000";
    			 }else if(value <= 0 && value > -1){
    			 	value1 = value.replace('.' , '');
    				value1 = Math.abs(value1);
    				value1 = "0"+ value1;
    			 }else if(value <= -1 && value > -10){
    				value1 = value.replace('.' , '');
    				value1 = Math.abs(value1);
    			 }

    			 goodsID=goodsID1+value1+goodsID2;
    	      }else if(name=='color'){
    	         if(value.length>10){
    	           alert('商品编码不能大于10字符');
    	           document.getElementById('bgicolor').value='';
    	           return false;
    	         }
    	         var goodsID1=goodsID.substring(0,18);
    	         var length=4-value.length;
    	         if(length>0){
    	           for(var i=0;i<length;i++){
    	             value='0'+value;
    	           }
    	         }else{
    	           value = value.substring(value.length-4,value.length);
    	         }
    	         goodsID=goodsID1+value;
    	      }
      }
      var goodscode = goodsID.split(".").join("") ;   
      document.all.bgigoodsid.value=goodsID.toUpperCase();
      document.all.bgigoodsbarcode.value=goodscode.toUpperCase(); 
      document.getElementById('bgispec').value=goodsID.substring(8,17);
	}
	function save(){
		if(checkForm(document.all.lensFinishedForm)){  
			var axgrid = document.getElementById('axgrid');
			var goodInfos = eval('(' + axgrid.content + ')');
			if (goodInfos == null || goodInfos == ""){
			    alert("请先选取商品!");
			    return;
			}
			var y = "";
			var x = "";
			var coordinate="";
			for(var i = 0; i < goodInfos.length; i++){
			  	if(goodInfos[i].v!=''){
			  		y = y + goodInfos[i].y + ",";
			  		x = x + goodInfos[i].x + ",";
			  	}		
			}
			
			$("#sphs").val(x);
			$("#cyls").val(y);
			
			if($("#bgiismutiluminosity").val() == 'J'){
				if($("#bgigradualclass").val() == ""){
					alert("请选择渐进片分类！");
					$("#bgigradualclass").focus();
					return;
				}
			}
			
		    var bgitaxrate= parseInt(document.all.bgitaxrate.value);

		    if(bgitaxrate>100||bgitaxrate<0){
		      alert('税率必须在0-100之间');
		      document.all.bgitaxrate.focus();
		      return false;
		    } 
		    
		    $("img").removeAttr("onclick");
			lensFinishedForm.action = "insertLensFinished2D.action";
			lensFinishedForm.submit();
			showLoadingBar();
		}
	}
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var dimensiionalFlag = document.getElementById('dimensiionalFlag');
	    dimensiionalFlag.style.display = 'none';
	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=3",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=3",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('bgisupplierid').value = json.id;
		document.getElementById('bgisuppliername').value = json.value;
		
		document.getElementById('bgibrandid').value = "";
		document.getElementById('bgibrandname').value = "";
		document.getElementById('bgigoodsname').value = "";
		
        $('#bgiunitid').val("");
        $('#bgirefractive').val("");
        $('#bgieyeglassmaterialtype').val("");
        $('#bgiismutiluminosity').val("");
        $('#bgigradualclass').val("");
        $('#bgifunctionclass').val("");
	}
	/**
	 * 品种开窗
	 */
	function openBrand(){
		var dimensiionalFlag = document.getElementById('dimensiionalFlag');
	    dimensiionalFlag.style.display = 'none';
	
	    var bgisupplierid=document.getElementById('bgisupplierid').value;
	    if(bgisupplierid==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open=3&supplierID_open=" + document.getElementById('bgisupplierid').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open=3&supplierID_open=" + document.getElementById('bgisupplierid').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('bgibrandid').value = json.brandID;
		document.getElementById('bgibrandname').value = json.brandName;
		document.getElementById('bgigoodsname').value = json.brandName;
		
        $('#bgiunitid').val(json.unit);
        $('#bgirefractive').val(json.refractive);
        $('#bgieyeglassmaterialtype').val(json.bbdmaterialclass);
        $('#bgiismutiluminosity').val(json.bbdluminosityclass);
        $('#bgipayfeeid').val(json.bbdpayfeeid);
        if (json.bbdluminosityclass == 'J'){
        	$('#bgigradualclass').show();
        }else{
        	$('#bgigradualclass').hide();
        	$('#bgigradualclass').val('');
        }
        $('#bgigradualclass').val(json.bbdgradualclass);
        $('#bgifunctionclass').val(json.bbdfunctionclass);
        $('#bgidefaultdiscountvalue').val(json.bbddefaultdiscount);

		if(json.bbdbarcodeflag=="1"){
			document.getElementById('bgibarcodeflagid1').checked="checked";
		}else{
			document.getElementById('bgibarcodeflagid2').checked="checked";
		}
		
		var dimensiionalFlag = document.getElementById('dimensiionalFlag');
	    dimensiionalFlag.style.display = '';
	}
	
	function clean(){
		$("input[clean=clean]").val('');
		$("input[cleans=cleans]").val('17');
		$("input[cleanbm=cleanbm]").val('0000');
		if('${systemParameterPo.fspnegative}'=='1'){
			$("input[goodsid=goodsid]").val('3.00.00.AA0000000.0000');	
		}else{
			$("input[goodsid=goodsid]").val('3.00.00.CA0000000.0000');
		}
		$("input[goodscode=goodscode]").val('300000000000000000');
		$("select[clean=clean]").val('');
		$("select[sph=sph]").val('0.00');
		$("select[cyl=cyl]").val('0.00');
		$('#sph').val('');
		$('#cyl').val('');
		
		if('${person.syspsupplierid}' != ''){
			getGoodsID('supplier','${person.syspsupplierid}');
		}
	}

	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		});
		if('${goodsInfoPo.bgivsph}'==''){
			$('#sph').val('0.00');
		}
		if('${goodsInfoPo.bgivcyl}'==''){
			$('#cyl').val('0.00');
		}
		if($("#bgiismutiluminosity").val() == 'J'){
			$("#bgigradualclass").show();
		}else{
			$("#bgigradualclass").hide();
		}
		
		if('${person.syspsupplierid}' != ''){
			getGoodsID('supplier','${person.syspsupplierid}');
		}
		
		if('${goodsInfoPo.bgibrandid}' != ''){
			var dimensiionalFlag = document.getElementById('dimensiionalFlag');
	    	dimensiionalFlag.style.display = '';
		}
	});

	function changeMutiluminosity(){
		if($("#bgiismutiluminosity").val() == 'J'){
			$("#bgigradualclass").show();
			$("#bgigradualclass").val("");
		}else{
			$("#bgigradualclass").hide();
			$("#bgigradualclass").val("");
		}
	}

//反方后的id
	 function getGoodsIDNegative(name,value){
	      value=trim(value);
	         var spec="";
	      var goodsID=document.all.goodsIdNegative.value;
	      if(name=='supplier'){
	         var goodsID1=goodsID.substring(0,2);
	         var goodsID2=goodsID.substring(4,22);
	         goodsID=goodsID1+value+goodsID2;
	      }else if(name=='brand'){
	         var goodsID1=goodsID.substring(0,5);
	         var goodsID2=goodsID.substring(7,22);
	         goodsID=goodsID1+value+goodsID2;
	      }else if(name=='bgisph'){
	    	  var goodsID1=goodsID.substring(0,8);
	   	   var goodsID2=goodsID.substring(9,10);
	          var goodsID4=goodsID.substring(14,22);
	 		
	 		 var value1 = 0;
	 		var value2="A";
	 		 if(value == 0){
	 		 	value1 = value.replace('.' , '');
	 			value1 = Math.abs(value1);
	 			value1 = "0000";
	 			var value2="A";
	 		 }else if(value < 0 && value > -1){
	 		 	value1 = value.replace('.' , '');
	 			value1 = Math.abs(value1);
	 			value1 = "00"+ value1;
	 			var value2="A";
	 		 }else if(value <= -1 && value > -10){
	 			value1 = value.replace('.' , '');
	 			value1 = Math.abs(value1);
	 			value1 = "0"+ value1;
	 			var value2="A";
	 		 }else if(value <= -10 ){
	 			value1 = value.replace('.' , '');
	 			value1 = Math.abs(value1);
	 			value1 =  value1;
	 			var value2="A";
	 		 }
	 		 
	 		 else if(value > 0 && value < 1){
	 		 	value1 = value.replace('.' , '');
	 			value1 = Math.abs(value1);
	 			value1 = "00"+ value1;
	 			var value2="B";
	 		 }else if(value >= 1 && value < 10){
	 			value1 = value.replace('.' , '');
	 			value1 = Math.abs(value1);
	 			value1 = "0"+ value1;
	 			var value2="B";
	 		 }else if(value >= 10 ){
	 			value1 = value.replace('.' , '');
	 			value1 = Math.abs(value1);
	 			value1 = value1;
	 			var value2="B";
	 		 }
	 		 //alert( goodsID1+"||"+value2+"||"+goodsID2+"||"+value1+"||"+goodsID4);
	 		 goodsID=goodsID1+value2+goodsID2+value1+goodsID4;
	      }else if(name=='bgicyl'){
	         var goodsID1=goodsID.substring(0,9);
	         var goodsID2=goodsID.substring(10,14);
	         var goodsID3=goodsID.substring(17,22);
			 var value2="";
			 var value1 = 0;
			 if(value>0){
				 if(value == 0){
				 	value1 = value.replace('.' , '');
					value1 = Math.abs(value1);
					value1 = "000";
					value2="A";
					
				 }else if(value <= 0 && value > -1){
				 	value1 = value.replace('.' , '');
					value1 = Math.abs(value1);
					value1 = "0"+ value1;
					value2="B";
				 }else if(value <= -1 && value > -10){
					value1 = value.replace('.' , '');
					value1 = Math.abs(value1);
					value2="B";
				 }else if(value > 0 && value < 1){
					value1 = value.replace('.' , '');
					value1 = Math.abs(value1);
					value1 = "0"+ value1;
					value2="A";
				}else if(value >= 1 && value < 10){
					value1 = value.replace('.' , '');
					value1 = Math.abs(value1);
					value1 =  value1;
					value2="A";
				}
			 }else{
				 
				 if(value == 0){
				 	value1 = value.replace('.' , '');
					value1 = Math.abs(value1);
					value1 = "000";
					value2="A";
					
				 }else if(value <= 0 && value > -1){
				 	value1 = value.replace('.' , '');
					value1 = Math.abs(value1);
					value1 = "0"+ value1;
					value2="A";
				 }else if(value <= -1 && value > -10){
					value1 = value.replace('.' , '');
					value1 = Math.abs(value1);
					value2="A";
				 }else if(value > 0 && value < 1){
					value1 = value.replace('.' , '');
					value1 = Math.abs(value1);
					value1 = "0"+ value1;
					value2="B";
				}else if(value >= 1 && value < 10){
					value1 = value.replace('.' , '');
					value1 = Math.abs(value1);
					value1 =  value1;
					value2="B";
				}
			 }
			 goodsID=goodsID1+value2+goodsID2+value1+goodsID3;
	      }else if(name=='color'){
	         if(value.length>10){
	           alert('商品编码不能大于10字符');
	           document.getElementById('bgicolor').value='';
	           return false;
	         }
	         var goodsID1=goodsID.substring(0,18);
	         var length=4-value.length;
	         if(length>0){
	           for(var i=0;i<length;i++){
	             value='0'+value;
	           }
	         }else{
	           value = value.substring(value.length-4,value.length);
	         }
	         goodsID=goodsID1+value;
	      }
	        
	      $('#goodsIdNegative').val(goodsID.toUpperCase());
		}
		function checkNegative(){
			 var goodsID=document.all.goodsIdNegative.value;
			var cyl=$('#bgicyl').val();
			var sph=$('#bgisph').val();
			var checkVlueVsph="";
			var checkVlueVcyl="";
			if(cyl>0){
				checkVlueVsph=accAdd(cyl,sph);
			}else{
				checkVlueVsph=sph;
			}
			if(cyl>0){
				checkVlueVcyl=accMul(cyl,-1);
			}else{
				checkVlueVcyl=cyl;
			}
			$('#sph').val(parseFloat(checkVlueVsph).toFixed(2));
			$('#cyl').val(parseFloat(checkVlueVcyl).toFixed(2));
			 var goodsID1=goodsID.substring(0,8);
		   	 var goodsID2=goodsID.substring(9,10);
		     var goodsID4=goodsID.substring(14,22);
     
		    var value=$('#sph').val();
		   // alert(value)
		 	var value1 = 0;
		 	var value2="A";
		 		 if(value == 0){
		 		 	value1 = value.replace('.' , '');
		 			value1 = Math.abs(value1);
		 			value1 = "0000";
		 		 }else if(value < 0 && value > -1){
		 		 	value1 = value.replace('.' , '');
		 			value1 = Math.abs(value1);
		 			value1 = "00"+ value1;
		 			//alert(value1)
		 			var value2="A";
		 		 }else if(value <= -1 && value > -10){
		 			value1 = value.replace('.' , '');
		 			value1 = Math.abs(value1);
		 			value1 = "0"+ value1;
		 			var value2="A";
		 		 }else if(value <= -10 ){
		 			value1 = value.replace('.' , '');
		 			value1 = Math.abs(value1);
		 			value1 =  value1;
		 			var value2="A";
		 		 }
		 		 
		 		 else if(value > 0 && value < 1){
		 		 	value1 = value.replace('.' , '');
		 			value1 = Math.abs(value1);
		 			value1 = "00"+ value1;
		 			var value2="B";
		 		 }else if(value >= 1 && value < 10){
		 			value1 = value.replace('.' , '');
		 			value1 = Math.abs(value1);
		 			value1 = "0"+ value1;
		 			var value2="B";
		 		 }else if(value >= 10 ){
		 			value1 = value.replace('.' , '');
		 			value1 = Math.abs(value1);
		 			value1 = value1;
		 			var value2="B";
		 		 }
		 		 //alert( goodsID1+"||"+value2+"||"+goodsID2+"||"+value1+"||"+goodsID4);
		 		 goodsID=goodsID1+value2+goodsID2+value1+goodsID4;
		 		$('#goodsIdNegative').val(goodsID.toUpperCase());
		}
		
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="lensFinishedForm" method="post" action="">

<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" /> 
<input type="hidden" name="parent" id="parent" value="${parent}" >
<input type="hidden" name="goodsTree" id="goodsTree" value="${goodsTree}" >
<input type="hidden" goodsid=goodsid name="goodsIdNegative" id="goodsIdNegative" value="${goodsIdNegative}" >
<input type="hidden" name="goodsInfoPo.bgivsph" id="sph" value="${goodsInfoPo.bgivsph }" >
<input type="hidden" name="goodsInfoPo.bgivcyl" id="cyl" value="${goodsInfoPo.bgivcyl }" >
<input type="hidden" name="sphs" id="sphs" value="" />
<input type="hidden" name="cyls" id="cyls" value="" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><br/>
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                    <fieldset>
					<legend><font style="font-size: 14;font: bold">&nbsp;&nbsp;必&nbsp;填&nbsp;项&nbsp;&nbsp;</font></legend>
                    <table width="99%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
			               <TD width="9%" class="table_body">商品名称</TD>
			               <TD class="table_none">
                             <input class="text_input160" clean=clean type="text" id="bgigoodsname" value="${goodsInfoPo.bgigoodsname}" name="goodsInfoPo.bgigoodsname" maxlength="100" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品名称不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [101]}, 'Message' : '商品名称不能大于100字符'}]"><label style="color:red;">&nbsp;*</label>
			             	 <input type="hidden" id="bgispec"  clean=clean value="000000000" name="goodsInfoPo.bgispec" />
			               </TD>
                           <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">                             
			               		<c:if test="${person.syspsupplierid ne ''}">
							   		<li class="horizontal_onlyRight">
							   		${person.syspsuppliername }
							   		<input type="hidden" id="bgisupplierid" name="goodsInfoPo.bgisupplierid" value="${person.syspsupplierid }" />
							   	</li>
							   	</c:if>
							   	<c:if test="${person.syspsupplierid eq ''}">
							   		<li class="horizontal_onlyRight">
								   		<input id="bgisuppliername" clean=clean class="text_input160"  value="${goodsInfoPo.bgisuppliername}" name="goodsInfoPo.bgisuppliername"  readonly="readonly" />
								   		<input type="hidden" id="bgisupplierid" clean=clean  value="${goodsInfoPo.bgisupplierid}" name="goodsInfoPo.bgisupplierid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
								   	</li>
								   	<li class="horizontal_onlyRight">
								    <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier();" >
								    </li><label style="color:red;">&nbsp;*</label>
							   	</c:if>

			               </TD>
                           <TD class="table_body">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input clean=clean id="bgibrandname" class="text_input160" value="${goodsInfoPo.bgibrandname}" name="goodsInfoPo.bgibrandname" readonly="readonly"/>
						   		<input clean=clean type="hidden" id="bgibrandid" value="${goodsInfoPo.bgibrandid}" name="goodsInfoPo.bgibrandid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属品种不能为空！'}]"/>
						   </li>
						   <li class="horizontal_onlyRight">
						   <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();" >
						   </li><label style="color:red;">&nbsp;*</label>
			               </TD>
			            </TR>
                        <TR>
			               <TD class="table_body">商品编号</TD>
			               <TD class="table_none">
                             <input cleanbm=cleanbm class="text_input100" type="text" id="bgicolor" value="${goodsInfoPo.bgicolor}" name="goodsInfoPo.bgicolor" onkeyup="value=value.replace(/[^\w\d]/g,'');getGoodsID('color',document.all.bgicolor.value);getGoodsIDNegative('color',document.all.bgicolor.value);" onchange="getGoodsID('color',document.all.bgicolor.value);getGoodsIDNegative('color',document.all.bgicolor.value);" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品编号不能为空！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '商品编号只允许输入整数和字母！'},{'Type' : Type.String, 'Formula' : Formula.NO_CN, 'Message' : '商品编号不能包含中文！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>  
                           <TD height="26" class="table_body">计量单位</TD>
			               <TD class="table_none" colspan="3">
                           <select clean=clean id="bgiunitid" name="goodsInfoPo.bgiunitid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '计量单位不能为空！'}]" >
      		                 <option value="">----请选择----</option>
      		               <s:iterator value="unitList">
				               <option value="${butid}" ${goodsInfoPo.bgiunitid == butid ? 'selected="selected"' : '' }>${butunitname}</option>
	     	               </s:iterator>
      	                   </select>
      	                    <label style="color:red;">&nbsp;*</label>
			               </TD>
			            </TR>
			            <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
                        <TR>
                        	<TD height="26" class="table_body">下加光</TD>
			               	<TD class="table_none">
			               		<select clean=clean id="bgibelowplusluminosity" name="goodsInfoPo.bgibelowplusluminosity">
                             		<option value="">----请选择----</option>
									<c:forEach var="x" begin="1" end="41" step="1" varStatus="index">
		               					<c:set var="lens1" value="${0.00 + (0.25 * (index.index - 1))}" />
										<option value="<fmt:formatNumber value="${lens1 }" pattern="0.00"/>" ${goodsInfoPo.bgibelowplusluminosity + 0 != lens1 ? '' : 'selected="selected"' }><fmt:formatNumber value="${lens1 }" pattern="0.00"/></option>
		               				</c:forEach>			               			
      	                   		</select><label style="color:red;">&nbsp;*</label>
                              </TD>
			                <TD class="table_body">材料分类</TD>
			                 <TD class="table_none">
			               		<select clean=clean id="bgieyeglassmaterialtype"  name="goodsInfoPo.bgieyeglassmaterialtype">
			               			<option value="">----请选择----</option>
			               			<option value="1" ${goodsInfoPo.bgieyeglassmaterialtype != "1" ? '' : 'selected="selected"' }>树脂</option>
			               			<option value="2" ${goodsInfoPo.bgieyeglassmaterialtype != "2" ? '' : 'selected="selected"' }>玻璃</option>
			               			<option value="3" ${goodsInfoPo.bgieyeglassmaterialtype != "3" ? '' : 'selected="selected"' }>PC</option>
			               		</select><label style="color:red;">&nbsp;*</label>
			                 </TD>
			                 <TD class="table_body">商品级别</TD>
			                 <td align="left" class="table_none">
			                	<select id="bgidefaultdiscountvalue" name="goodsInfoPo.bgidefaultdiscountvalue">
			                		<option value="">---请选择---</option>
			                		<s:iterator value="selectGoodsLevelList">
						               	<option value="${bgluuid}" ${goodsInfoPo.bgidefaultdiscountvalue eq bgluuid ? 'selected="selected"' : '' }>${bglname}</option>
			     	                </s:iterator>
			                	</select>
                             </td>
							</TR>
							<TR>
	      	               	<TD height="26" class="table_body">批号管理</TD>
			               	<td align="left" class="table_none" colspan="5">
			               		<input type="radio" id="bgibarcodeflagid1" name="goodsInfoPo.bgibarcodeflag" value="1" ${goodsInfoPo.bgibarcodeflag eq '1' ? 'checked="checked"' : '' } />是<input type="radio" id="bgibarcodeflagid2" name="goodsInfoPo.bgibarcodeflag" value="0" ${goodsInfoPo.bgibarcodeflag ne '1' ? 'checked="checked"' : '' } />否<label style="color:red;">&nbsp;*</label>
                           	</td> 
							</TR>							
						</c:if>
						<c:if test="${systemParameterPo.fspisusegoodslevel ne '1'}">
                        <TR>
                        	<TD  height="26" class="table_body">下加光</TD>
			               	<TD  class="table_none">
			               <select clean=clean id="bgibelowplusluminosity" name="goodsInfoPo.bgibelowplusluminosity">
                             <option value="">----请选择----</option>
									<c:forEach var="x" begin="1" end="41" step="1" varStatus="index">
		               				<c:set var="lens1" value="${0.00 + (0.25 * (index.index - 1))}" />
									<option value="<fmt:formatNumber value="${lens1 }" pattern="0.00"/>" ${goodsInfoPo.bgibelowplusluminosity + 0 != lens1 ? '' : 'selected="selected"' }><fmt:formatNumber value="${lens1 }" pattern="0.00"/></option>
		               			</c:forEach>
			               			
      	                   </select><label style="color:red;">&nbsp;*</label>
                              </TD>
			                <TD  height="26" class="table_body">材料分类</TD>
			                 <TD  class="table_none">
			               		<select clean=clean id="bgieyeglassmaterialtype"  name="goodsInfoPo.bgieyeglassmaterialtype">
			               			<option value="">----请选择----</option>
			               			<option value="1" ${goodsInfoPo.bgieyeglassmaterialtype != "1" ? '' : 'selected="selected"' }>树脂</option>
			               			<option value="2" ${goodsInfoPo.bgieyeglassmaterialtype != "2" ? '' : 'selected="selected"' }>玻璃</option>
			               			<option value="3" ${goodsInfoPo.bgieyeglassmaterialtype != "3" ? '' : 'selected="selected"' }>PC</option>
			               		</select><label style="color:red;">&nbsp;*</label>
			               		<input type="hidden" class="text_input100" maxlength="10" name="goodsInfoPo.bgidefaultdiscountvalue" value="${defaultdiscountvalue }">
			                 </TD>
      	               			<TD height="26" class="table_body">批号管理</TD>
			               		<td align="left" class="table_none">
			               		<input type="radio" id="bgibarcodeflagid1" name="goodsInfoPo.bgibarcodeflag" value="1" ${goodsInfoPo.bgibarcodeflag eq '1' ? 'checked="checked"' : '' } />是<input type="radio" id="bgibarcodeflagid2" name="goodsInfoPo.bgibarcodeflag" value="0" ${goodsInfoPo.bgibarcodeflag ne '1' ? 'checked="checked"' : '' } />否<label style="color:red;">&nbsp;*</label>
                          		</td> 			                 
							</TR>
						</c:if>
						<c:if test="${systemParameterPo.fsphisflag == '2'}">
	                      <TR> 
				            <TD height="26" class="table_body">收费项目</TD>
				            <TD class="table_none" colspan="5">
								   <li class="horizontal_onlyRight">
								     <select id="bgipayfeeid" name="goodsInfoPo.bgipayfeeid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择收费项目！'}]">
	                                   <option value="">---请选择---</option>
	                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                              <c:if test="${optionParamPoTmp.fopparentid=='his_payfee'}">
			                               <option value="${optionParamPoTmp.fopparamid }" ${(goodsInfoPo.bgipayfeeid == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
			                              </c:if>	                                      	
		                               </c:forEach> 
	                            	 </select>
		                           </li>
		                           <label style="color:red;">&nbsp;*</label>
		      	             </TD>                
	                      </TR>
                      	</c:if>
                      </TBODY>
                    </TABLE>
                    <br/>
                    <table width="99%"  border=0 align=center id="title1">
                      <TBODY>
                        <TR>
                        	<td>
		                	<div id="dimensiionalFlag" style="display:none">
								<object classid="clsid:5F019427-2649-4468-BD28-F6FBD96E1B51"  width="100%" height="500" id="axgrid" codebase="<%=request.getContextPath()%>/AxGrid.ocx#version=1,0,0,0" name="axgrid">
								<param name="RowStart" value="-20.00"/>		<!--行起始值-->
								<param name="RowEnd" value="31.00"/>		<!--行终止值-->
								<param name="RowStep" value="0.25"/>	    <!--行步长-->
								<c:if test="${systemParameterPo.fspnegative eq 1}">
								<param name="ColStart" value="-6.00"/>		<!--列起始值-->
								<param name="ColEnd" value="6.00"/>		<!--列终止值-->
								</c:if>
								<c:if test="${systemParameterPo.fspnegative ne 1}">
								<param name="ColStart" value="-6.00"/>		<!--列起始值-->
								<param name="ColEnd" value="0.00"/>		<!--列终止值-->
								</c:if>
								<param name="ColStep" value="0.25"/>		<!--列步长-->
								<param name="ColPrecision" value="2"/>		<!--列表头的精度-->
								<param name="RowPrecision" value="2"/>		<!--行表头的精度-->
								<param name="InputPrecision" value="0"/>	<!--内容的精度。小数点后几个0-->
								<param name="ColWidth" value="44"/>			<!--列宽-->
								<param name="RowHeight" value="22"/>		<!--行高-->
								<param name="Title" value="球镜/柱镜"/>
								<param name="RowHeaderColor" value="236, 245, 251"/>	<!--行表头的颜色-->
								<param name="ColHeaderColor" value="236, 245, 251"/>	<!--列表头的颜色-->
								<param name="GridLineColor"  value="140, 140, 140"/>		<!--网格线的颜色-->
								<param name="OddLineColor"   value="255, 255, 255"/>		<!--奇数行的背景颜色-->
								<param name="EvenLineColor"  value="255, 255, 255"/>		<!--偶数行的背景颜色-->
								<param name="SelectedColor"  value="217, 234, 247"/>		<!--选择项的颜色-->
								<param name="DisableColor"   value="192, 192, 192"/>		<!--不可用单元格的颜色-->
								</object>
							</div>
							</td>
						</tr>
                      </TBODY>
                    </TABLE>
                    </fieldset>
                    <br/>
                    <fieldset>
					<legend><font style="font-size: 14;font: bold">&nbsp;&nbsp;非&nbsp;必&nbsp;填&nbsp;项&nbsp;&nbsp;</font></legend>
                    <table width="99%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
			               <TD  height="26" class="table_body" width="9%">光度分类</TD>
			               <TD  class="table_none" width="24%">
	                          <select clean=clean id="bgiismutiluminosity" name="goodsInfoPo.bgiismutiluminosity" onchange="changeMutiluminosity();">
	                          <option value="">----请选择----</option>
                              <option value="0" ${goodsInfoPo.bgiismutiluminosity != "0" ? '' : 'selected="selected"' }>单光</option>
                              <option value="M" ${goodsInfoPo.bgiismutiluminosity != "M" ? '' : 'selected="selected"' }>多光</option>
                              <option value="J" ${goodsInfoPo.bgiismutiluminosity != "J" ? '' : 'selected="selected"' }>渐进</option>
                              <option value="K" ${goodsInfoPo.bgiismutiluminosity != "K" ? '' : 'selected="selected"' }>抗疲劳</option>
                              <option value="Q" ${goodsInfoPo.bgiismutiluminosity != "Q" ? '' : 'selected="selected"' }>其它</option>
                           </select>
			               </TD>
			               <TD class="table_body" width="9%">渐进片分类</TD>
			               <TD class="table_none" width="24%">
			               		<select clean=clean id="bgigradualclass"  name="goodsInfoPo.bgigradualclass">
			               			<option value="" >----请选择----</option>
			               			<option value="1" ${goodsInfoPo.bgigradualclass != "1" ? '' : 'selected="selected"' }>青少年渐进</option>
			               			<option value="2" ${goodsInfoPo.bgigradualclass != "2" ? '' : 'selected="selected"' }>成人渐进</option>
			               		</select>
			               </TD>
			               <TD class="table_body" width="9%">折射率</TD>
                           <TD class="table_none">
                            <select clean=clean id="bgirefractive"  name="goodsInfoPo.bgirefractive">
      		                 <option value="">----请选择----</option>
      		                    <s:iterator value="refractiveSetList">
				               <option value="${brfname}" ${goodsInfoPo.bgirefractive == brfname ? 'selected="selected"' : '' }>${brfname}</option>
	     	                    </s:iterator>
      	                   </select>
      	                   </TD>	  
			            </TR>
                        <TR>
                             <TD height="26" class="table_body">镜片功能</TD>
			                 <TD class="table_none" colspan="5">
		                     	<select id="bgifunctionclass" clean=clean name="goodsInfoPo.bgifunctionclass">
                                   <option value="" selected>---请选择---</option>
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='gn'}">
		                               <option value="${optionParamPoTmp.fopparamid }" ${(goodsInfoPo.bgifunctionclass == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                              </c:if>	                                      	
	                               </c:forEach> 
                             	</select>
			                 </TD>
			                </TR>
                      </TBODY>
                    </TABLE>
                    </fieldset>
                    <br/>
                    <fieldset>
					<legend><font style="font-size: 14;font: bold">&nbsp;&nbsp;价&nbsp;格&nbsp;项&nbsp;&nbsp;</font></legend>
                    <table width="99%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
              <c:if test="${(permissionPo.keyf==1)}">
                        <TR>
					<c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}">
                           <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" width="24%">
                             <input cleans=cleans class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body" width="9%">含税单价</TD>
			                 <TD  class="table_none" width="24%">
                             <input clean=clean class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" value="${goodsInfoPo.bgicostprice}" id="bgicostprice" name="goodsInfoPo.bgicostprice"  maxlength="10" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '成本价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]">
                             	<label style="color:red;">&nbsp;*</label>
			                 </TD>
			               <TD class="table_body" width="9%">批发价格</TD>
			               <TD class="table_none">
                             <input clean=clean class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgiwholesaleprice" value="${goodsInfoPo.bgiwholesaleprice}" name="goodsInfoPo.bgiwholesaleprice" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="10"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '批发价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			         </c:if>
					<c:if test="${systemParameterPo.fspwholesalepriceset eq '1'}">
                           <TD  height="26" class="table_body" width="9%">税率</TD>
			               <TD  class="table_none"  width="24%">
                             <input cleans=cleans class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body" width="9%">含税单价</TD>
			                 <TD  class="table_none" colspan="3" >
                             <input clean=clean class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" value="${goodsInfoPo.bgicostprice}" id="bgicostprice" name="goodsInfoPo.bgicostprice"  maxlength="10" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '成本价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]">
                             	<label style="color:red;">&nbsp;*</label>
			                 </TD>
                             <input class="text_input100" type="hidden" value='0.00' id="bgiwholesaleprice" name="goodsInfoPo.bgiwholesaleprice" />
			         </c:if>
                        </TR>
                        <%--<TR>
                           <TD height="26" class="table_body" width="9%">加权平均成本</TD>
			               <TD class="table_none" colspan="5">
                             <input class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" value="${goodsInfoPo.bgiaveragenotnaxrate}" id="bgiaveragenotnaxrate" name="goodsInfoPo.bgiaveragenotnaxrate" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(6);}"  maxlength="10" ><label style="color:red;">&nbsp;*</label>
			               </TD>
                        </TR>--%>
              </c:if>
                 <c:if test="${(permissionPo.keyf != 1)}">
					<c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}">
                      <input class="text_input100" type="hidden" value='0.00' id="bgicostprice" name="goodsInfoPo.bgicostprice" />
                        <TR>
                           <TD  height="26" class="table_body" width="9%">税率</TD>
			               <TD  class="table_none" width="24%">
                             <input cleans=cleans class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body" width="9%">批发价格</TD>
			               <TD class="table_none" colspan="3">
                             <input clean=clean class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgiwholesaleprice" value="${goodsInfoPo.bgiwholesaleprice}" name="goodsInfoPo.bgiwholesaleprice" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="10"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '批发价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
                        </TR>
                     </c:if>
					<c:if test="${systemParameterPo.fspwholesalepriceset eq '1'}">
                      <input class="text_input100" type="hidden" value='0.00' id="bgicostprice" name="goodsInfoPo.bgicostprice" />
                      <input class="text_input100" type="hidden" value='0.00' id="bgiwholesaleprice" name="goodsInfoPo.bgiwholesaleprice" />
                        <TR>
                           <TD  height="26" class="table_body" width="9%">税率</TD>
			               <TD  class="table_none" colspan="5">
                             <input cleans=cleans class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
                        </TR>
                     </c:if>
                 </c:if>

                      </TBODY>
                    </TABLE>
                    <%@ include file="/commons/basic_retailPrices_insert.jsp" %>
                    </fieldset>
                    <!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行数据插入，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->	
					
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          <img id="submitButton" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                        	  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
                          </TD>
						</TR>
						
						<tr>
						  	<td>
								<br>
								<br>
								成品镜片:<br>
								商品代码组成说明：<br>
								 <c:if test="${systemParameterPo.fspnegative==1}">
									<IMG src="${ctx}/img/pic/jinpianfanfang.png" ><br>
								</c:if>
								<c:if test="${systemParameterPo.fspnegative!=1}">
									<IMG src="${ctx}/img/pic/jingpian.png" ><br>
								</c:if>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">商品条码会根据商品代码自动生成。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">商品名称默认为选择的品种的名称，可以自行调整。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">计量单位、光度分类、折射率、镜片功能等选项是直接从品种信息中带入，同时可以自行调整。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">成本价格为含税单价。</font><br>
							</td>
						</tr>
                      </TBODY>
                    </TABLE>
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
	
	
	




