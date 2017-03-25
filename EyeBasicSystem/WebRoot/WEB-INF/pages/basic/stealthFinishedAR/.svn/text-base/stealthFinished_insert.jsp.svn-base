<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>软性接触镜成品维护</title>
</head>
<script>
	function trim(str){ //删除左右两端的空格
　　  	return str.replace(/(^\s*)|(\s*$)/g, "");
　　 }

	function getGoodsID(name,value){
		value=trim(value);
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
	 		 var value2="A";
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
	}
	function save(){
		if(checkForm(document.all.stealthFinishedForm)){  
		    var bgitaxrate= parseInt(document.all.bgitaxrate.value);
		    if(bgitaxrate>100||bgitaxrate<0){
		      alert('税率必须在0-100之间');
		      document.all.bgitaxrate.focus();
		      return false;
		    } 

		    var bgicyl = $("#bgicyl").val();
			var bgiaxis = $("#bgiaxis").val();
		    if(parseFloat(bgicyl) != 0){
				if(!bgiaxis){
					alert("当柱径不等于0.00时，轴向不能为空！");
					$("#bgiaxis").focus();
					return;
				}
				if(bgiaxis > 0){
				}else{
					alert("轴向不能为负值或等于0！");
					$("#bgiaxis").focus();
					return;
				}
				if(parseFloat(bgiaxis) < 0 || parseFloat(bgiaxis) > 180 ){
					alert("轴向范围在0-180之间的数字！");
					$("#bgiaxis").focus();
					return;
				}
		    }
		    
		    var bbdvaliddateUL = Number(document.getElementById('bgireturnmax').value);
			var bbdvaliddateUP = Number(document.getElementById('bgireturnmin').value);

			    if(bbdvaliddateUL<0){
			      alert('上限效期不能小于0');
			      document.all.bgireturnmax.focus();
			      return false;
			    } 
			    if(bbdvaliddateUP<0){
			      alert('下限效期不能小于0');
			      document.all.bgireturnmin.focus();
			      return false;
				} 
		
			if (bbdvaliddateUL < bbdvaliddateUP) {
				alert("上限效期不能小于下限效期！");
				document.getElementById('bgireturnmax').select();
				return false;
			}
		    
		    $("img").removeAttr("onclick");
			stealthFinishedForm.action = "insertStealthFinishedAR.action";
			stealthFinishedForm.submit();
			
		}
	}
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=4",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=4",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('bgisupplierid').value = json.id;
		document.getElementById('bgisuppliername').value = json.value;
		
		document.getElementById('bgireturnmax').value = "";
		document.getElementById('bgireturnmin').value = "";
		document.getElementById('bgibrandid').value = "";
		document.getElementById('bgibrandname').value = "";
		document.getElementById('bgigoodsname').value = "";
	
		$('#bgiunitid').val("");
		$('#bgiusetype').val("");
		$('#bgistealthclass').val("");
		getGoodsID('supplier',document.getElementById('bgisupplierid').value);

		getGoodsIDNegative('supplier',document.getElementById('bgisupplierid').value);
		
	}
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var bgisupplierid=document.getElementById('bgisupplierid').value;
	    if(bgisupplierid==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open=4&supplierID_open=" + document.getElementById('bgisupplierid').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open=4&supplierID_open=" + document.getElementById('bgisupplierid').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('bgireturnmax').value = json.bbdvaliddateUL;
		document.getElementById('bgireturnmin').value = json.bbdvaliddateUP;
		document.getElementById('bgibrandid').value = json.brandID;
		document.getElementById('bgibrandname').value = json.brandName;
		document.getElementById('bgigoodsname').value = json.brandName;
		$('#bgidefaultdiscountvalue').val(json.bbddefaultdiscount);
		$('#bgiunitid').val(json.unit);
		$('#bgiusetype').val(json.bbdusetype);
		$('#bgistealthclass').val(json.bbdstealthclass);
		$('#bgipayfeeid').val(json.bbdpayfeeid);
		getGoodsID('brand',document.getElementById('bgibrandid').value);
		getGoodsIDNegative('brand',document.getElementById('bgibrandid').value);
	}
		
	$(document).ready(function(){
		$('#bgicurvature1').bind("keyup",function(){	
			$('#bgicurvature1').val(
				$('#bgicurvature1').val().replace(/[^0-9.][0-9]*/g,'')
				);
		});
		if('${goodsInfoPo.bgivsph}'==''){
			$('#sph').val('0.00');
		}
		if('${goodsInfoPo.bgivcyl}'==''){
			$('#cyl').val('0.00');
		}
		$('#bgicurvature1').bind("blur",function(){	
			if($('#bgicurvature1').val()!='')
			$('#bgicurvature1').val(parseFloat($('#bgicurvature1').val()).toFixed(2));
		});
		$('#bgidia').bind("keyup",function(){	
			$('#bgidia').val(
				$('#bgidia').val().replace(/[^0-9.][0-9]*/g,'')
				);
		});
		$('#bgidia').bind("blur",function(){	
			if($('#bgidia').val()!='')
			$('#bgidia').val(parseFloat($('#bgidia').val()).toFixed(1));
		});
		
		if('${person.syspsupplierid}' != ''){
			getGoodsID('supplier','${person.syspsupplierid}');
		}
	});
	
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});
	
	function clean(){
		$("input[clean=clean]").val('');
		$("input[cleans=cleans]").val('17');
		$("input[cleanbm=cleanbm]").val('0000');
		if('${systemParameterPo.fspnegative}'=='1'){
			$("input[goodsid=goodsid]").val('4.00.00.AA0000000.0000');	
		}else{
			$("input[goodsid=goodsid]").val('4.00.00.CA0000000.0000');
		}
		$("input[goodscode=goodscode]").val('400000000000000000');
		$("select[clean=clean]").val('');
		$("select[sph=sph]").val('0.00');
		$("select[cyl=cyl]").val('0.00');
		$('#sph').val('');
		$('#cyl').val('');
		
		if('${person.syspsupplierid}' != ''){
			getGoodsID('supplier','${person.syspsupplierid}');
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
			checkVlueVsph=accAdd(cyl,sph);
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
		 			var value2="A";
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
<form name="stealthFinishedForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />

<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="parent" id="parent" value="${parent}" >
<input type="hidden" name="goodsTree" id="goodsTree" value="${goodsTree}" >
<input type="hidden" name="goodsIdNegative" id="goodsIdNegative" value="${goodsIdNegative}" >
<input type="hidden" name="goodsInfoPo.bgivsph" id="sph" value="${goodsInfoPo.bgivsph }" >
<input type="hidden" name="goodsInfoPo.bgivcyl" id="cyl" value="${goodsInfoPo.bgivcyl }" >
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                    <br/>
                    <fieldset>
					<legend><font style="font-size: 14;font: bold">&nbsp;&nbsp;必&nbsp;填&nbsp;项&nbsp;&nbsp;</font></legend>
                    <table width="99%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="9%" height="26" class="table_body">商品代码</TD>
			               <TD width="24%" class="table_none">
                             <c:if test="${!empty goodsInfoPo.bgigoodsid}">
                            <input class="text_input160" type="text" goodsid=goodsid id="bgigoodsid" value="${goodsInfoPo.bgigoodsid}" name="goodsInfoPo.bgigoodsid" readonly="readonly">
			               </c:if>
			                <c:if test="${empty goodsInfoPo.bgigoodsid}">
                            <input class="text_input160" type="text" goodsid=goodsid id="bgigoodsid" name="goodsInfoPo.bgigoodsid" value="${goodsIdNegative }" readonly="readonly">
			               </c:if>
			               </TD>
			               <TD width="9%" class="table_body">商品条码</TD>
			               <TD width="24%" class="table_none">
			               <c:if test="${!empty goodsInfoPo.bgigoodsbarcode}">
                            <input class="text_input160" type="text" id="bgigoodsbarcode" goodscode=goodscode readonly="readonly" value="${goodsInfoPo.bgigoodsbarcode}" name="goodsInfoPo.bgigoodsbarcode"  maxlength="18" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品条码不能为空！'}]"><label style="color:red;">&nbsp;*</label>
			               </c:if>
			                <c:if test="${empty goodsInfoPo.bgigoodsbarcode}">
                            <input class="text_input160" type="text" id="bgigoodsbarcode" goodscode=goodscode readonly="readonly" name="goodsInfoPo.bgigoodsbarcode" value="400000000000000000" maxlength="18" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品条码不能为空！'}]"><label style="color:red;">&nbsp;*</label>
			               </c:if>
			               </TD>
			               <TD width="9%" height="26" class="table_body">商品名称</TD>
			               <TD class="table_none">
                             <input class="text_input160" clean=clean type="text" value="${goodsInfoPo.bgigoodsname}" id="bgigoodsname" name="goodsInfoPo.bgigoodsname" maxlength="100" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品名称不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [101]}, 'Message' : '商品名称不能大于100字符'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>		              
                        </TR>
                        <TR>
                         <TD width="9%" height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
			               		<c:if test="${person.syspsupplierid ne ''}">
							   		<li class="horizontal_onlyRight">
							   		${person.syspsuppliername }
							   		<input type="hidden" id="bgisupplierid" name="goodsInfoPo.bgisupplierid" value="${person.syspsupplierid }" />
							   	</li>
							   	</c:if>
							   	<c:if test="${person.syspsupplierid eq ''}">
							   		<li class="horizontal_onlyRight">
								   		<input id="bgisuppliername" clean=clean class="text_input160" value="${goodsInfoPo.bgisuppliername}" name="goodsInfoPo.bgisuppliername"  readonly="readonly" />
								   		<input type="hidden" clean=clean id="bgisupplierid" value="${goodsInfoPo.bgisupplierid}" name="goodsInfoPo.bgisupplierid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
								   	</li>
								   	<li class="horizontal_onlyRight">
								    <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier();" ></li><label style="color:red;">&nbsp;*</label>  
							   	</c:if>
			               </TD>
                           <TD class="table_body">商品品种</TD>
			               <TD class="table_none">
	                           <li class="horizontal_onlyRight">
							   		<input id="bgibrandname" clean=clean class="text_input160" value="${goodsInfoPo.bgibrandname}" name="goodsInfoPo.bgibrandname" readonly="readonly"/>
							   		<input type="hidden" clean=clean id="bgibrandid" value="${goodsInfoPo.bgibrandid}" name="goodsInfoPo.bgibrandid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属品种不能为空！'}]"/>
							   </li>
							   <li class="horizontal_onlyRight">
							  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();" >
							   </li><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <!-- <TD height="26" class="table_body">型号</TD>
			               <TD class="table_none">
                             <input class="text_input100" type="text" id="bgispec" value="${goodsInfoPo.bgispec}" name="goodsInfoPo.bgispec" onchange="this.value = this.value.toUpperCase();getGoodsID('spec',document.all.bgispec.value);"  maxlength="30"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '型号不能为空！'},{'Type' : Type.String, 'Formula' : Formula.NO_CN, 'Message' : '型号不能包含中文！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD> -->
			               <TD class="table_body">商品编号</TD>
			               <TD class="table_none">
                             <input class="text_input100" clean=clean type="text" id="bgicolor" value="${goodsInfoPo.bgicolor}" name="goodsInfoPo.bgicolor" onkeyup="value=value.replace(/[^\w\d]/g,'');getGoodsID('color',document.all.bgicolor.value);getGoodsIDNegative('color',document.all.bgicolor.value);" onchange="getGoodsID('color',document.all.bgicolor.value);getGoodsIDNegative('color',document.all.bgicolor.value);" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品编号不能为空！'},{'Type' : Type.String, 'Formula' : Formula.NO_CN, 'Message' : '商品编号不能包含中文！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '商品编号只允许输入整数和字母！'}]"><label style="color:red;">
                             &nbsp;*&nbsp;</label>
			               </TD>
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">计量单位</TD>
			               <TD class="table_none">
                           <select id="bgiunitid" clean=clean name="goodsInfoPo.bgiunitid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '计量单位不能为空！'}]">
      		                 <option value="">----请选择----</option>
      		               <s:iterator value="unitList">
				               <option value="${butid}" ${goodsInfoPo.bgiunitid == butid ? 'selected="selected"' : '' }>${butunitname}</option>
	     	               </s:iterator>
      	                   </select>
      	                    <label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body">球镜</TD>
			               <TD class="table_none">
                           <select sph=sph id="bgisph" name="goodsInfoPo.bgisph" onChange="getGoodsID('bgisph',document.all.bgisph.value);getGoodsIDNegative('bgisph',document.all.bgisph.value);checkNegative();" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '球镜不能为空！'}]">
      		                 		<option value="">----请选择----</option>
									<c:forEach var="x" begin="1" end="209" step="1" varStatus="index">
			               				<c:set var="lens" value="${-26.00 + (0.25 * (index.index - 1))}" />
										<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgisph + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
      	                   </select><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body">柱镜</TD>
			               <TD class="table_none">
                            <c:if test="${systemParameterPo.fspnegative==1}">
                           <select cyl=cyl id="bgicyl" name="goodsInfoPo.bgicyl" onChange="getGoodsID('bgicyl',document.all.bgicyl.value);getGoodsIDNegative('bgicyl',document.all.bgicyl.value);checkNegative();" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜不能为空！'}]">
									<option value="">----请选择----</option>
      		                 		<c:forEach var="x" begin="1" end="209" step="1" varStatus="index">
		               				<c:set var="lens" value="${-26.00 + (0.25 * (index.index - 1))}" />
									<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgicyl + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
		               			</c:forEach>
      	                   </select><label style="color:red;">&nbsp;*</label>
      	                   </c:if>
      	                   <c:if test="${systemParameterPo.fspnegative!=1}">
                           <select cyl=cyl id="bgicyl" name="goodsInfoPo.bgicyl" onChange="getGoodsID('bgicyl',document.all.bgicyl.value);getGoodsIDNegative('bgicyl',document.all.bgicyl.value);checkNegative();" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜不能为空！'}]">
									<option value="">----请选择----</option>
      		                 		<c:forEach var="x" begin="1" end="209" step="1" varStatus="index">
		               				<c:set var="lens" value="${0.00 - (0.25 * (index.index - 1))}" />
									<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgicyl + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
		               			</c:forEach>
      	                   </select><label style="color:red;">&nbsp;*</label>
      	                   </c:if>
			               </TD>
			            </TR>
                        <TR>
			               <TD height="26" class="table_body">轴向</TD>
			               <TD class="table_none">
                             <input clean=clean class="text_input100" type="text" value="${goodsInfoPo.bgiaxis}" id="bgiaxis" name="goodsInfoPo.bgiaxis" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '轴向不能为空！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body">曲率</TD>
			               <TD class="table_none">
                             <input clean=clean class="text_input100" type="text" value="${goodsInfoPo.bgicurvature1}" id="bgicurvature1" name="goodsInfoPo.bgicurvature1" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '曲率不能为空！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body">直径</TD>
			               <TD class="table_none">
                             <input clean=clean class="text_input100" type="text" id="bgidia" value="${goodsInfoPo.bgidia}" name="goodsInfoPo.bgidia" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '直径不能为空！'}]"><label style="color:red;">&nbsp;*</label>
			               	 <c:if test="${systemParameterPo.fspisusegoodslevel ne '1'}">
	                              <input type="hidden" class="text_input100" maxlength="10" name="goodsInfoPo.bgidefaultdiscountvalue" value="1.00" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品默认折扣！'},{'Type' : Type.String, 'Formula' : Formula.UDiscount, 'Message' : '请重新填写的商品默认折扣！'}]">
	                         </c:if>	
			               </TD>
                        </TR>
                        <TR>
                        	<TD height="26" class="table_body">接触镜类别</TD> 
			                <TD class="table_none" colspan="5">
      	                   		<select id="bgicontacttype" clean=clean name="goodsInfoPo.bgicontacttype" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择接触镜类别！'}]">
                                   <option value="" selected>---请选择---</option>
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='GCType'}">
		                               <option value="${optionParamPoTmp.fopparamid }" ${(goodsInfoPo.bgicontacttype == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                              </c:if>	                                      	
	                               </c:forEach> 
                             	</select>
			               	</TD>
			            </TR>
                        <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
                        <TR>
						   <TD height="26" class="table_body">商品级别</TD>
			               <td align="left" class="table_none" colspan="5">
			                	<select id="bgidefaultdiscountvalue" name="goodsInfoPo.bgidefaultdiscountvalue">
			                		<option value="">---请选择---</option>
			                		<s:iterator value="selectGoodsLevelList">
						               	<option value="${bgluuid}" ${goodsInfoPo.bgidefaultdiscountvalue eq bgluuid ? 'selected="selected"' : '' } >${bglname}</option>
			     	                </s:iterator>
			                	</select>
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
                    </fieldset>
                    <br/>
                    <fieldset>
					<legend><font style="font-size: 14;font: bold">&nbsp;&nbsp;非&nbsp;必&nbsp;填&nbsp;项&nbsp;&nbsp;</font></legend>
                    <table width="99%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
			               <TD height="26" class="table_body" width="9%">使用类型</TD>
			               <TD class="table_none" width="24%">
                           <select clean=clean id="bgiusetype"  name="goodsInfoPo.bgiusetype" >
      		                 <option value="">----请选择----</option>
      		                 <option value="1" ${goodsInfoPo.bgiusetype != "1" ? '' : 'selected="selected"' }>常戴型</option>
      		                 <option value="2" ${goodsInfoPo.bgiusetype != "2" ? '' : 'selected="selected"' }>抛弃型</option>
      		                  <option value="3" ${goodsInfoPo.bgiusetype != "3" ? '' : 'selected="selected"' }>塑形镜</option>
      	                   </select>
			               </TD>
                           <TD class="table_body" width="9%">抛弃型分类</TD>
			               <TD class="table_none" width="24%">
                           <select clean=clean id="bgistealthclass"  name="goodsInfoPo.bgistealthclass"> 
      		                 <option value="">----请选择----</option>
                             <option value="1" ${goodsInfoPo.bgistealthclass != "1" ? '' : 'selected="selected"' }>日抛</option>
                             <option value="2" ${goodsInfoPo.bgistealthclass != "2" ? '' : 'selected="selected"' }>周抛</option>
                             <option value="9" ${goodsInfoPo.bgistealthclass != "9" ? '' : 'selected="selected"' }>双周抛</option>
                             <option value="3" ${goodsInfoPo.bgistealthclass != "3" ? '' : 'selected="selected"' }>月抛</option>
                             <option value="4" ${goodsInfoPo.bgistealthclass != "4" ? '' : 'selected="selected"' }>季抛</option>
                             <option value="5" ${goodsInfoPo.bgistealthclass != "5" ? '' : 'selected="selected"' }>半年抛</option>
                             <option value="6" ${goodsInfoPo.bgistealthclass != "6" ? '' : 'selected="selected"' }>年抛</option>
                             <option value="7" ${goodsInfoPo.bgistealthclass != "7" ? '' : 'selected="selected"' }>RGP</option>
                             <option value="8" ${goodsInfoPo.bgistealthclass != "8" ? '' : 'selected="selected"' }>塑形镜</option>
      	                   </select>
			               </TD>               
			               <TD class="table_body" width="9%">产品可使用天数</TD>
			               <TD class="table_none" colspan="3">
                            <input clean=clean class="text_input100" type="text" value="${goodsInfoPo.bginumberofdays}" id="bginumberofdays" name="goodsInfoPo.bginumberofdays" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.UINTOrNULL, 'Message' : '产品可使用天数必须为数字！'}]">
			               </TD>
                         </TR>
                         <TR>	
                           <TD height="26" class="table_body">效期提醒上限</TD>
			               <TD class="table_none">
                           	有效期前&nbsp;<input clean=clean class="text_input60" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgireturnmax" name="goodsInfoPo.bgireturnmax" value="${goodsInfoPo.bgireturnmax }" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(0);}"  maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '效期提醒上限应为数字！'}]">&nbsp;天提醒进入滞销状态
                           </td>
                           <TD class="table_body">效期提醒下限</TD>
			               <TD class="table_none" >
                           	有效期前&nbsp;<input clean=clean class="text_input60" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgireturnmin" name="goodsInfoPo.bgireturnmin" value="${goodsInfoPo.bgireturnmin }" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(0);}"  maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '效期提醒下限应为数字！'}]">&nbsp;天提醒进入即将失效状态
                           </TD>
                           <TD class="table_body" width="9%">颜色</TD>
			               	<TD class="table_none">
			               	<select clean=clean id="bgichinesecolor"  name="goodsInfoPo.bgichinesecolor" >
			               	 <option value="">----请选择----</option>
			                 <s:iterator value="colorList">
				               <option value="${bcid}" ${goodsInfoPo.bgichinesecolor == bcid ? 'selected="selected"' : '' }>${bccolorname}</option>
	     	               	 </s:iterator>
	     	               	</select>
	     	               	<input id="bgistealthtype" type="hidden" name="goodsInfoPo.bgistealthtype" value="">
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
					  <c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}">     
                        <TR>
                          <TD height="26" class="table_body" width="9%">税率</TD>
			              <TD class="table_none" width="24%">
                             <input cleans=cleans class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			              </TD>
			              <TD class="table_body" width="9%">爱尔结算价</TD>
			              <TD class="table_none" width="24%">                            
                             <input clean=clean class="text_input100" type="text" value="${goodsInfoPo.bgicostprice}" id="bgicostprice" name="goodsInfoPo.bgicostprice"  maxlength="10" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '成本价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]">
                             	<label style="color:red;">*</label>
			              </TD>
			              <TD class="table_body" width="9%">批发价格</TD>
			              <TD class="table_none">
                             <input clean=clean class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgiwholesaleprice" value="${goodsInfoPo.bgiwholesaleprice}" name="goodsInfoPo.bgiwholesaleprice" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="10"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '批发价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]"><label style="color:red;">&nbsp;*</label>
			              </TD>
                        </TR>
                       </c:if> 
					  <c:if test="${systemParameterPo.fspwholesalepriceset eq '1'}">     
                        <TR>
                          <TD height="26" class="table_body" width="9%">税率</TD>
			              <TD class="table_none" width="24%">
                             <input cleans=cleans class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			              </TD>
			              <TD height="26" class="table_body" width="9%">爱尔结算价</TD>
			              <TD class="table_none" colspan="3">                            
                             <input clean=clean class="text_input100" type="text" value="${goodsInfoPo.bgicostprice}" id="bgicostprice" name="goodsInfoPo.bgicostprice"  maxlength="10" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '成本价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]">
                             	<label style="color:red;">*</label>
			              </TD>
                             <input class="text_input100" type="hidden" value='0.00' id="bgiwholesaleprice" name="goodsInfoPo.bgiwholesaleprice" />
                        </TR>
                       </c:if>
                        <%--<TR>
                           <TD height="26" class="table_body">加权平均成本</TD>
			               <TD class="table_none" colspan="5">
                             <input class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" value="${goodsInfoPo.bgiaveragenotnaxrate}" id="bgiaveragenotnaxrate" name="goodsInfoPo.bgiaveragenotnaxrate" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(6);}"  maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '加权平均成本不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [6]}, 'Message' : '金额格式错误！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
                        </TR>--%>
                     </c:if> 
                  <c:if test="${(permissionPo.keyf != 1)}">
					  <c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}"> 
                        <input class="text_input100" type="hidden" value='0.00' id="bgicostprice" name="goodsInfoPo.bgicostprice" />
                        <TR>
                           <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" width="24%">
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
                           <TD class="table_body" width="9%">税率</TD>
			               <TD class="table_none" colspan="5">
                             <input cleans=cleans class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
                        </TR>
                        </c:if>
                  </c:if>       
                      </TBODY>
                    </TABLE>
                    <%@ include file="/commons/basic_retailPrices_insert.jsp" %>
                    </fieldset>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          <img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                        	 <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
                          </TD>
						</TR>
						
						<tr>
						  	<td>
								<br>
								<br>
								接触镜镜片：<br>
								商品代码组成说明：<br>
								
								<c:if test="${systemParameterPo.fspnegative==1}">
									<IMG src="${ctx}/img/pic/yinxiangfanfang.png" ><br>
								</c:if>
								<c:if test="${systemParameterPo.fspnegative!=1}">
									<IMG src="${ctx}/img/pic/yinxingjingpian.png" ><br>
								</c:if>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">商品条码会根据商品代码自动生成。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">商品名称默认为选择的品种的名称，可以自行调整。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">商品编号用于区分相同制造商、品种、型号的商品。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">接触镜效期大于效期提醒上限。 （正常贮备期）</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">接触镜效期小于效期提醒上限并且大于下限。 （滞销退货期）</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">接触镜效期小于效期提醒下限并且大于过期时间。（即将失效期）</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">接触镜效期小于过期时间。（报废）  </font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">计量单位、使用种类、抛弃型分类、等选项是直接从品种信息中带入，同时可以填选。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">成本价格为爱尔结算价。</font><br>
							</td>
						</tr>
                      </TBODY>
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