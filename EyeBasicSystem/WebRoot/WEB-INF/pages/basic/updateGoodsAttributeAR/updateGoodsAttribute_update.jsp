<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品属性修改</title>
<script type='text/javascript' src='${ctx }/js/currentDate.js'></script>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
		
		hideGoodsAttributes();
	});
	
	function hideGoodsAttributes(){
	
		$("input[type=checkbox]").attr("checked",false);
		$("input[at=at]").val('');
		$("input[at=at]").attr("disabled",true);
		$("select[at=at]").val('');
		$("select[at=at]").attr("disabled",true);
		
		$("#gcDiv1").hide();
		$("#gcDiv2").hide();
		$("#gcDiv3").hide();
		$("#gcDiv4").hide();
		$("#gcDiv5").hide();
		$("#gcDiv6").hide();
		$("#gcDiv7").hide();
		$("#gcDiv8").hide();
		$("#gcDiv9").hide();
		$("#gcDiv3D").hide();
		$("#gcDiv4D").hide();
		$("#gca").hide();
		$("#gca_1").hide();				
		$("tr[id=gca1]").hide();
		$("#gca2").hide();
		$("#gca3").hide();
		$("#gca3_1").hide();
		$("#gca3_3d").hide();
		$("#gca4").hide();
		$("#gca4_1").hide();
		$("#gca4_2").hide();
		$("#gca4_4d").hide();
		$("#gca4_4d1").hide();
		$("#gca4_4d2").hide();
		$("#gca5").hide();
		$("#gca5_1").hide();
		$("#gca6").hide();
		$("#gca7").hide();
		$("#gca8").hide();
		$("#gcDiv4R").hide();
		$("#gca4_4R").hide();
		$("#gca4_4R1").hide();
		$("#gca4_4R2").hide();
	}
	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	customerForm.action=link;
	  	customerForm.submit();
		showLoadingBar();
	}
	function clean(){
		document.getElementById('pid').value = "";
		document.getElementById('pnm').value = "";
		document.getElementById('bid').value = "";
		document.getElementById('startTime').value = "";
		document.getElementById('endTime').value = "";
		document.getElementById('sLogResult').value = "";
	}
	/**
	 * 品种开窗
	 */
	function openBrand(){
		var goodscategoryID= document.all.goodscategoryID.value;
		 if(goodscategoryID==''){
			    alert("请选择商品类型！");
			    return;
		 }
	    var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
		    alert("请选择商品制造商！");
		    return;
	    }
	    if(goodscategoryID=='3D'){
	    	goodscategoryID='3'
	    }
	    if(goodscategoryID=='4D'){
	    	goodscategoryID='4'
	    }  
	    if(goodscategoryID=='4R'){
	    	goodscategoryID='4'
	    }   
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID= document.all.goodscategoryID.value;
	    if(goodscategoryID==''){
		    alert("请选择商品类型！");
		    return;
	    }
	    if(goodscategoryID=='3D'){
	    	goodscategoryID='3'
	    }
	    if(goodscategoryID=='4D'){
	    	goodscategoryID='4'
	    }                	    
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
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
	}
	function hideGoodsAttribute(){
		$("span[id=gc]").hide();
	}
	function  showAndHideGoodsAttribute(){

		$("input[type=checkbox]").attr("checked",false);
		$("input[at=at]").val('');
		$("input[at=at]").attr("disabled",true);
		$("select[at=at]").val('');
		$("select[at=at]").attr("disabled",true);
		var goodscategory=$("#goodscategoryID").val();
		if(goodscategory==''){
			$("span[id=gc]").hide();
			hideGoodsAttributes();
		}else{
			$("span[id=gc]").show();
		}
		
		
		if("${person.syspsupplierid eq ''}"){
			$("#supplierName").val("");
			$("#supplierID").val("");
		}
		
		$("#brandName").val("");
		$("#brandID").val("");
		
		if(goodscategory==1){
			$("#gcDiv1").show();
			$("#gcDiv2").hide();
			$("#gcDiv3").hide();
			$("#gcDiv4").hide();
			$("#gcDiv5").hide();
			$("#gcDiv6").hide();
			$("#gcDiv7").hide();
			$("#gcDiv8").hide();
			$("#gcDiv9").hide();
			$("#gcDiv3D").hide();
			$("#gcDiv4D").hide();

			$("#gca").show();
			$("#gca_1").show();
			$("#gca1").show();
			$("#gca2").hide();
			$("#gca3").hide();
			$("#gca3_1").hide();
			$("#gca3_3d").hide();
			$("#gca4").hide();
			$("#gca4_1").hide();
			$("#gca4_2").hide();
			$("#gca4_4d").hide();
			$("#gca4_4d1").hide();
			$("#gca4_4d2").hide();
			$("#gca5").hide();
			$("#gca5_1").hide();
			$("#gca6").hide();
			$("#gca7").hide();
			$("#gca8").hide();
			
			$("#gcDiv4R").hide();
			$("#gca4_4R").hide();
			$("#gca4_4R1").hide();
			$("#gca4_4R2").hide();
		}
		if(goodscategory==2){
			$("#gcDiv1").hide();
			$("#gcDiv2").show();
			$("#gcDiv3").hide();
			$("#gcDiv4").hide();
			$("#gcDiv5").hide();
			$("#gcDiv6").hide();
			$("#gcDiv7").hide();
			$("#gcDiv8").hide();
			$("#gcDiv9").hide();
			$("#gcDiv3D").hide();
			$("#gcDiv4D").hide();
			
			$("#gca").show();
			$("#gca_1").show();			
			$("tr[id=gca1]").hide();
			$("#gca2").show();
			$("#gca3").hide();
			$("#gca3_1").hide();
			$("#gca3_3d").hide();
			$("#gca4").hide();
			$("#gca4_1").hide();
			$("#gca4_2").hide();
			$("#gca4_4d").hide();
			$("#gca4_4d1").hide();
			$("#gca4_4d2").hide();
			$("#gca5").hide();
			$("#gca5_1").hide();
			$("#gca6").hide();
			$("#gca7").hide();
			$("#gca8").hide();
			
			$("#gcDiv4R").hide();
			$("#gca4_4R").hide();
			$("#gca4_4R1").hide();
			$("#gca4_4R2").hide();
		}
		if(goodscategory==3){
			$("#gcDiv1").hide();
			$("#gcDiv2").hide();
			$("#gcDiv3").show();
			$("#gcDiv4").hide();
			$("#gcDiv5").hide();
			$("#gcDiv6").hide();
			$("#gcDiv7").hide();
			$("#gcDiv8").hide();
			$("#gcDiv9").hide();
			$("#gcDiv3D").hide();
			$("#gcDiv4D").hide();

			$("#gca").show();
			$("#gca_1").show();			
			$("tr[id=gca1]").hide();
			$("#gca2").hide();
			$("#gca3").show();
			$("#gca3_1").show();
			$("#gca3_3d").hide();
			$("#gca4").hide();
			$("#gca4_1").hide();
			$("#gca4_2").hide();
			$("#gca4_4d").hide();
			$("#gca4_4d1").hide();
			$("#gca4_4d2").hide();
			$("#gca5").hide();
			$("#gca5_1").hide();
			$("#gca6").hide();
			$("#gca7").hide();
			$("#gca8").hide();
			
			$("#gcDiv4R").hide();
			$("#gca4_4R").hide();
			$("#gca4_4R1").hide();
			$("#gca4_4R2").hide();
		}
		if(goodscategory==4){
			$("#gcDiv1").hide();
			$("#gcDiv2").hide();
			$("#gcDiv3").hide();
			$("#gcDiv4").show();
			$("#gcDiv5").hide();
			$("#gcDiv6").hide();
			$("#gcDiv7").hide();
			$("#gcDiv8").hide();
			$("#gcDiv9").hide();
			$("#gcDiv3D").hide();
			$("#gcDiv4D").hide();

			$("#gca").show();
			$("#gca_1").hide();			
			$("tr[id=gca1]").hide();
			$("#gca2").hide();
			$("#gca3").hide();
			$("#gca3_1").hide();
			$("#gca3_3d").hide();
			$("#gca4").show();
			$("#gca4_1").show();
			$("#gca4_2").show();
			$("#gca4_4d").hide();
			$("#gca4_4d1").hide();
			$("#gca4_4d2").hide();
			$("#gca5").hide();
			$("#gca5_1").hide();
			$("#gca6").hide();
			$("#gca7").hide();
			$("#gca8").hide();
			
			$("#gcDiv4R").hide();
			$("#gca4_4R").hide();
			$("#gca4_4R1").hide();
			$("#gca4_4R2").hide();
		}
		if(goodscategory==5){
			$("#gcDiv1").hide();
			$("#gcDiv2").hide();
			$("#gcDiv3").hide();
			$("#gcDiv4").hide();
			$("#gcDiv5").show();
			$("#gcDiv6").hide();
			$("#gcDiv7").hide();
			$("#gcDiv8").hide();
			$("#gcDiv9").hide();
			$("#gcDiv3D").hide();
			$("#gcDiv4D").hide();

			$("#gca").show();
			$("#gca_1").hide();			
			$("tr[id=gca1]").hide();
			$("#gca2").hide();
			$("#gca3").hide();
			$("#gca3_1").hide();
			$("#gca3_3d").hide();
			$("#gca4").hide();
			$("#gca4_1").hide();
			$("#gca4_2").hide();
			$("#gca5").show();
			$("#gca5_1").show();
			$("#gca6").hide();
			$("#gca7").hide();
			$("#gca8").hide();
			
			$("#gcDiv4R").hide();
			$("#gca4_4R").hide();
			$("#gca4_4R1").hide();
			$("#gca4_4R2").hide();
		}
		if(goodscategory==6){
			$("#gcDiv1").hide();
			$("#gcDiv2").hide();
			$("#gcDiv3").hide();
			$("#gcDiv4").hide();
			$("#gcDiv5").hide();
			$("#gcDiv6").show();
			$("#gcDiv7").hide();
			$("#gcDiv8").hide();
			$("#gcDiv9").hide();
			$("#gcDiv3D").hide();
			$("#gcDiv4D").hide();

			$("#gca").show();
			$("#gca_1").show();			
			$("tr[id=gca1]").hide();
			$("#gca2").hide();
			$("#gca3").hide();
			$("#gca3_1").hide();
			$("#gca3_3d").hide();
			$("#gca4").hide();
			$("#gca4_1").hide();
			$("#gca4_2").hide();
			$("#gca4_4d").hide();
			$("#gca4_4d1").hide();
			$("#gca4_4d2").hide();
			$("#gca5").hide();
			$("#gca5_1").hide();
			$("#gca6").show();
			$("#gca7").hide();
			$("#gca8").hide();
			
			$("#gcDiv4R").hide();
			$("#gca4_4R").hide();
			$("#gca4_4R1").hide();
			$("#gca4_4R2").hide();
		}
		if(goodscategory==7){
			$("#gcDiv1").hide();
			$("#gcDiv2").hide();
			$("#gcDiv3").hide();
			$("#gcDiv4").hide();
			$("#gcDiv5").hide();
			$("#gcDiv6").hide();
			$("#gcDiv7").show();
			$("#gcDiv8").hide();
			$("#gcDiv9").hide();
			$("#gcDiv3D").hide();
			$("#gcDiv4D").hide();

			$("#gca").show();
			$("#gca_1").show();			
			$("tr[id=gca1]").hide();
			$("#gca2").hide();
			$("#gca3").hide();
			$("#gca3_1").hide();
			$("#gca3_3d").hide();
			$("#gca4").hide();
			$("#gca4_1").hide();
			$("#gca4_2").hide();
			$("#gca4_4d").hide();
			$("#gca4_4d1").hide();
			$("#gca4_4d2").hide();
			$("#gca5").hide();
			$("#gca5_1").hide();
			$("#gca6").hide();
			$("#gca7").show();
			$("#gca8").hide();
			
			$("#gcDiv4R").hide();
			$("#gca4_4R").hide();
			$("#gca4_4R1").hide();
			$("#gca4_4R2").hide();
		}
		if(goodscategory==8){
			$("#gcDiv1").hide();
			$("#gcDiv2").hide();
			$("#gcDiv3").hide();
			$("#gcDiv4").hide();
			$("#gcDiv5").hide();
			$("#gcDiv6").hide();
			$("#gcDiv7").hide();
			$("#gcDiv8").show();
			$("#gcDiv9").hide();
			$("#gcDiv3D").hide();
			$("#gcDiv4D").hide();

			$("#gca").show();
			$("#gca_1").show();			
			$("tr[id=gca1]").hide();
			$("#gca2").hide();
			$("#gca3").hide();
			$("#gca3_1").hide();
			$("#gca3_3d").hide();
			$("#gca4").hide();
			$("#gca4_1").hide();
			$("#gca4_2").hide();
			$("#gca4_4d").hide();
			$("#gca4_4d1").hide();
			$("#gca4_4d2").hide();
			$("#gca5").hide();
			$("#gca5_1").hide();
			$("#gca6").hide();
			$("#gca7").hide();
			$("#gca8").show();
			
			$("#gcDiv4R").hide();
			$("#gca4_4R").hide();
			$("#gca4_4R1").hide();
			$("#gca4_4R2").hide();
		}
		if(goodscategory==9){
			$("#gcDiv1").hide();
			$("#gcDiv2").hide();
			$("#gcDiv3").hide();
			$("#gcDiv4").hide();
			$("#gcDiv5").hide();
			$("#gcDiv6").hide();
			$("#gcDiv7").hide();
			$("#gcDiv8").hide();
			$("#gcDiv9").show();
			$("#gcDiv3D").hide();
			$("#gcDiv4D").hide();


			$("#gca").show();
			$("#gca_1").show();			
			$("tr[id=gca1]").hide();
			$("#gca2").hide();
			$("#gca3").hide();
			$("#gca3_1").hide();
			$("#gca3_3d").hide();
			$("#gca4").hide();
			$("#gca4_1").hide();
			$("#gca4_2").hide();
			$("#gca4_4d").hide();
			$("#gca4_4d1").hide();
			$("#gca4_4d2").hide();
			$("#gca5").hide();
			$("#gca5_1").hide();
			$("#gca6").hide();
			$("#gca7").hide();
			$("#gca8").hide();
			
			$("#gcDiv4R").hide();
			$("#gca4_4R").hide();
			$("#gca4_4R1").hide();
			$("#gca4_4R2").hide();
		}
		if(goodscategory=='3D'){
			$("#gcDiv1").hide();
			$("#gcDiv2").hide();
			$("#gcDiv3").hide();
			$("#gcDiv4").hide();
			$("#gcDiv5").hide();
			$("#gcDiv6").hide();
			$("#gcDiv7").hide();
			$("#gcDiv8").hide();
			$("#gcDiv9").hide();
			$("#gcDiv3D").show();
			$("#gcDiv4D").hide();


			$("#gca").show();
			$("#gca_1").hide();				
			$("tr[id=gca1]").hide();
			$("#gca2").hide();
			$("#gca3").show();
			$("#gca3_1").show();
			$("#gca3_3d").show();
			$("#gca4").hide();
			$("#gca4_1").hide();
			$("#gca4_2").hide();
			$("#gca4_4d").hide();
			$("#gca4_4d1").hide();
			$("#gca4_4d2").hide();
			$("#gca5").hide();
			$("#gca5_1").hide();
			$("#gca6").hide();
			$("#gca7").hide();
			$("#gca8").hide();
			
			$("#gcDiv4R").hide();
			$("#gca4_4R").hide();
			$("#gca4_4R1").hide();
			$("#gca4_4R2").hide();
		}
		
		if(goodscategory=='4R'){
			$("#gcDiv1").hide();
			$("#gcDiv2").hide();
			$("#gcDiv3").hide();
			$("#gcDiv4").hide();
			$("#gcDiv5").hide();
			$("#gcDiv6").hide();
			$("#gcDiv7").hide();
			$("#gcDiv8").hide();
			$("#gcDiv9").hide();
			$("#gcDiv3D").hide();
			$("#gcDiv4D").hide();
			$("#gcDiv4R").show();


			$("#gca").show();
			$("#gca_1").hide();				
			$("tr[id=gca1]").hide();
			$("#gca2").hide();
			$("#gca3").hide();
			$("#gca3_1").hide();
			$("#gca3_3d").hide();
			$("#gca4").show();
			$("#gca4_1").hide();
			$("#gca4_2").hide();
			$("#gca4_4d").hide();
			$("#gca4_4d1").hide();
			$("#gca4_4d2").hide();
			$("#gcDiv4D").hide();
			$("#gca4_4R").show();
			$("#gca4_4R1").show();
			$("#gca4_4R2").show();
			
			$("#gca5").hide();
			$("#gca5_1").hide();
			$("#gca6").hide();
			$("#gca7").hide();
			$("#gca8").hide();
		}
		
		if(goodscategory=='4D'){
			$("#gcDiv1").hide();
			$("#gcDiv2").hide();
			$("#gcDiv3").hide();
			$("#gcDiv4").hide();
			$("#gcDiv5").hide();
			$("#gcDiv6").hide();
			$("#gcDiv7").hide();
			$("#gcDiv8").hide();
			$("#gcDiv9").hide();
			$("#gcDiv3D").hide();
			$("#gcDiv4D").show();


			$("#gca").show();
			$("#gca_1").hide();				
			$("tr[id=gca1]").hide();
			$("#gca2").hide();
			$("#gca3").hide();
			$("#gca3_1").hide();
			$("#gca3_3d").hide();
			$("#gca4").show();
			$("#gca4_1").hide();
			$("#gca4_2").hide();
			$("#gca4_4d").show();
			$("#gca4_4d1").show();
			$("#gca4_4d2").show();
			$("#gca5").hide();
			$("#gca5_1").hide();
			$("#gca6").hide();
			$("#gca7").hide();
			$("#gca8").hide();
			
			$("#gcDiv4R").hide();
			$("#gca4_4R").hide();
			$("#gca4_4R1").hide();
			$("#gca4_4R2").hide();
		}
	}
	function addGoodsAttribute(thiz){
		var goodscategory=$("#goodscategoryID").val();
		var checkOrNo=true;
		if($(thiz).attr("checked")){
			checkOrNo=false;
		}else{
			checkOrNo=true;
		}
			if($(thiz).attr("name")=='unitid'){
				$("#bgiunitid").attr("disabled",checkOrNo);
			}
			if($(thiz).attr("name")=='barcodeflag'){
				$("#bgibarcodeflagid").attr("disabled",checkOrNo);
			}			
						
			if($(thiz).attr("name")=='defaultdiscountvalue'){
				$("#bgidefaultdiscountvalue").attr("disabled",checkOrNo);
			}
			if($(thiz).attr("name")=='taxrate'){
				$("#bgitaxrate").attr("disabled",checkOrNo);
			}
			if($(thiz).attr("name")=='frameprocesscrafttype'){
				$("#bgiframeprocesscrafttype"+goodscategory).attr("disabled",checkOrNo);
			}
			if($(thiz).attr("name")=='framematerialtype'){
				$("#bgiframematerialtype"+goodscategory).attr("disabled",checkOrNo);
			}
			if($(thiz).attr("name")=='framesize'){
				$("#bgiframesize"+goodscategory).attr("disabled",checkOrNo);
			}
			if($(thiz).attr("name")=='refractive'){
				if(goodscategory!='3D'){
					$("#bgirefractive"+goodscategory).attr("disabled",checkOrNo);
				}else{
					$("#bgirefractive3").attr("disabled",checkOrNo);
				}
			}
			if($(thiz).attr("name")=='eyeglassmaterialtype'){
				if(goodscategory!='3D'){
					$("#bgieyeglassmaterialtype"+goodscategory).attr("disabled",checkOrNo);
				}else{
					$("#bgieyeglassmaterialtype3").attr("disabled",checkOrNo);
				}
			}
			if($(thiz).attr("name")=='ismutiluminosity'){
				if(goodscategory!='3D'){
					$("#bgiismutiluminosity"+goodscategory).attr("disabled",checkOrNo);
				}else{
					$("#bgiismutiluminosity3").attr("disabled",checkOrNo);
				}
			}
			if($(thiz).attr("name")=='gradualclass'){
				if(goodscategory!='3D'){
					$("#bgigradualclass"+goodscategory).attr("disabled",checkOrNo);
				}else{
					$("#bgigradualclass3").attr("disabled",false);
				}
			}
			if($(thiz).attr("name")=='functionclass'){
				if(goodscategory!='3D'){
					$("#bgifunctionclass"+goodscategory).attr("disabled",checkOrNo);
				}else{
					$("#bgifunctionclass3").attr("disabled",checkOrNo);
				}
			}
			
			if($(thiz).attr("name")=='curvature'){
				$("#bgicurvature"+goodscategory).attr("disabled",checkOrNo);
			}
			
			if($(thiz).attr("name")=='dia'){
				$("#bgidia"+goodscategory).attr("disabled",checkOrNo);
			}
			if($(thiz).attr("name")=='usetype'){
				if(goodscategory!='4D'){
					$("#bgiusetype"+goodscategory).attr("disabled",checkOrNo);
				}else{
					$("#bgiusetype4").attr("disabled",checkOrNo);
				}
			}
			if($(thiz).attr("name")=='returnmax'){
				if(goodscategory!='4D'){
					$("#bgireturnmax"+goodscategory).attr("disabled",checkOrNo);
				}else{
					$("#bgireturnmax4").attr("disabled",checkOrNo);
				}
			}
			if($(thiz).attr("name")=='returnmin'){
				if(goodscategory!='4D'){
					$("#bgireturnmin"+goodscategory).attr("disabled",checkOrNo);
				}else{
					$("#bgireturnmin4").attr("disabled",checkOrNo);
				}
			}
			if($(thiz).attr("name")=='stealthclass'){
				$("#bgistealthclass"+goodscategory).attr("disabled",checkOrNo);
			}
			
			if($(thiz).attr("name")=='numberofdays'){
				$("#bginumberofdays"+goodscategory).attr("disabled",checkOrNo);
			}
			
			if($(thiz).attr("name")=='capacity'){
				$("#bgicapacity"+goodscategory).attr("disabled",checkOrNo);
			}
			if($(thiz).attr("name")=='framematerialtype'){
				$("#bgiframematerialtype"+goodscategory).attr("disabled",checkOrNo);
			}
			if($(thiz).attr("name")=='othergoodssmallclass'){
				$("#bgiothergoodssmallclass"+goodscategory).attr("disabled",checkOrNo);
			}
			if($(thiz).attr("name")=='othergoodsbigclass'){
				$("#bgiothergoodsbigclass"+goodscategory).attr("disabled",checkOrNo);
			}
			if($(thiz).attr("name")=='ordercycle'){
				$("#bgiordercycle"+goodscategory).attr("disabled",checkOrNo);
			}
			if($(thiz).attr("name")=='curvature1'){
				$("#bgicurvature1up"+goodscategory).attr("disabled",checkOrNo);
				$("#bgicurvature1ul"+goodscategory).attr("disabled",checkOrNo);
			}
			if($(thiz).attr("name")=='curvature2'){
				$("#bgicurvature2up"+goodscategory).attr("disabled",checkOrNo);
				$("#bgicurvature2ul"+goodscategory).attr("disabled",checkOrNo);
			}
			if($(thiz).attr("name")=='dia1'){
				$("#bgidia1up"+goodscategory).attr("disabled",checkOrNo);
				$("#bgidia1ul"+goodscategory).attr("disabled",checkOrNo);
			}
			
			if($(thiz).attr("name")=='capacityentry'){
				$("#bgicapacityentry"+goodscategory).attr("disabled",checkOrNo);
			}

			if($(thiz).attr("name")=='stealthType'){
				$("#bgicontacttype"+goodscategory).attr("disabled",checkOrNo);
			}
			
			if($(thiz).attr("name")=='stealthTypeR'){
				$("#bgicontacttype4R").attr("disabled",checkOrNo);
			}
			
			if($(thiz).attr("name")=='framestyle'){
				$("#bgiframestyle"+goodscategory).attr("disabled",checkOrNo);
			}
		
	}
	function changeMutiluminosity(){
		if($("#bgiismutiluminosity").val() == 'J'){
			$("#bgigradualclass3").show();
			$("#bgigradualclass3").val("");
		}else{
			$("#bgigradualclass3").hide();
			$("#bgigradualclass3").val("");
		}
	}
	function bgiothergoodsbigclassOnChange(){
		var selectedOption = "${goodsInfoPo.bgiothergoodssmallclass}";
		var obj;
		if(customerForm.bgiothergoodsbigclass7.value=="Q"){//其它材料
			customerForm.bgiothergoodssmallclass7.options.length=0;
			customerForm.bgiothergoodssmallclass7.options.add(new Option("----请选择----",""));
			
			obj = new Option("办公用品","001");
			obj.setAttribute("selected", (selectedOption == "001"));
			customerForm.bgiothergoodssmallclass7.options.add(obj); 

			obj = new Option("印刷品","002");
			obj.setAttribute("selected", (selectedOption == "002"));
			customerForm.bgiothergoodssmallclass7.options.add(obj);

			obj = new Option("眼镜用具","003");
			obj.setAttribute("selected", (selectedOption == "003"));
			customerForm.bgiothergoodssmallclass7.options.add(obj);

			obj = new Option("其它","004");
			obj.setAttribute("selected", (selectedOption == "004"));
			customerForm.bgiothergoodssmallclass7.options.add(obj);
			
		}else if(customerForm.bgiothergoodsbigclass7.value=="D"){//低值易耗品
			customerForm.bgiothergoodssmallclass7.options.length=0;
			customerForm.bgiothergoodssmallclass7.options.add(new Option("----请选择----","")); 

			obj = new Option("加工工具","001");
			obj.setAttribute("selected", (selectedOption == "001"));
			customerForm.bgiothergoodssmallclass7.options.add(obj);

			obj = new Option("办公工具","002"); 
			obj.setAttribute("selected", (selectedOption == "002"));
			customerForm.bgiothergoodssmallclass7.options.add(obj);

			obj = new Option("验配工具","003");
			obj.setAttribute("selected", (selectedOption == "003"));
			customerForm.bgiothergoodssmallclass7.options.add(obj);

			obj = new Option("其它","004");
			obj.setAttribute("selected", (selectedOption == "004"));
			customerForm.bgiothergoodssmallclass7.options.add(obj);
		}		
	}


	function openGoodSingle(){
		var categoryID_open =  document.all.goodscategoryID.value;

	    var chaasupplier =document.getElementById('supplierID').value;
	    var brandID=$('#brandID').val();
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		    
		if(is_iPad()){
			showPopWin("initGoodsSingleSelUpdateAttribute.action?categoryID_open="+categoryID_open+"&supplierID_open="+chaasupplier+"&app=app"+"&brandID_open="+brandID+"&whichretail=1&select_retail=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			 if(categoryID_open=='3D'){
				  categoryID_open='3'
				showPopWin("initGoodsSingleSelUpdateAttribute.action?categoryID_open="+categoryID_open+"&supplierID_open="+chaasupplier+"&app=app"+"&brandID_open="+brandID+"&whichretail=1&select_retail=1&iscustomizekj=D",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);		  
			  }else if(categoryID_open=='4D'){
				  categoryID_open='4'
					showPopWin("initGoodsSingleSelUpdateAttribute.action?categoryID_open="+categoryID_open+"&supplierID_open="+chaasupplier+"&app=app1"+"&brandID_open="+brandID+"&whichretail=1&select_retail=1&iscustomizeyx=D",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);		     	 
			  }else{ 
				showPopWin("initGoodsSingleSelUpdateAttribute.action?categoryID_open="+categoryID_open+"&supplierID_open="+chaasupplier+"&app=app"+"&brandID_open="+brandID+"&whichretail=1&select_retail=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			  }
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}
	function save(){
		var goodscategoryID= document.all.goodscategoryID.value;
	    var brandID=document.getElementById('brandID').value;
		var updategoodsid=$("#updateGoodsID").val();
	    if(goodscategoryID==''){
		    alert("请选择商品类型！");
		    return;
	    }
		$("img").removeAttr("onclick");
		customerForm.action = "updateGoodsAttributeAR.action";
		customerForm.submit();
	}
	
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="customerForm" method="post" action="">
<input type="hidden" class="text_input160"  value="" id="updateGoodsID" name="updateGoodsID">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>商品属性修改</TD>
            <TD align="left" id="addtd"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：商品属性修改 </TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
				</TD></TR>
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
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </table>
					<input type="hidden" name="hid">
					<input type="hidden" name="type" id="type" value="" /> 
					<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
                         <TD class="table_body" height="26">商品类型</TD>
                          <TD class="table_none">
						  <select name="goodscategoryID" id="goodscategoryID" onchange="showAndHideGoodsAttribute();">
						  		<option value="">----请选择----</option>
						  		<s:iterator value="goodsCategorys">
						  			<c:if test="${bgcid ne '3' && bgcid ne '4'}">
									<option value="${bgcid}">${bgcgoodscategoryname}</option>
									</c:if>
									<c:if test="${bgcid eq '3' }">
										<option value="3">成品镜片</option>
										<option value="3D">车房镜片</option>
									</c:if>
									<c:if test="${bgcid eq '4' }">
										<option value="4" >软性接触镜成品</option>
										<option value="4R">软性接触镜订制</option>
										<option value="4D">硬性接触镜</option>
									</c:if>
	     	               		</s:iterator>
	     	              </select>
						  </TD>
                           <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
			               		<c:if test="${person.syspsupplierid ne ''}">
							   		<li class="horizontal_onlyRight">
							   			${person.syspsuppliername }
							   			<input type="hidden" id="supplierID" name="supplierID" value="${person.syspsupplierid }" />
									</li>
							   	</c:if>
							   	<c:if test="${person.syspsupplierid eq ''}">
							   		<li class="horizontal_onlyRight">
							   			<input id="supplierName" class="text_input160" name="supplierName" value="${supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } readonly="readonly"/>
							   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
									</li>
						   			<li class="horizontal_onlyRight">
						   				<c:if test="${empty(supplierID_open)}">
						  				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openSupplier();" >
						  				</c:if>
					  				</li>
							   	</c:if>
						   </TD>			               
						   <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none" colspan="3">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="${brandName}" ${not empty(brandID_open) ? 'disabled="disabled"' : 'clean=clean' } readonly="readonly">
						   		<input type="hidden" id="brandID" clean=clean name="brandID" value="${brandID}" ${not empty(brandID_open) ? 'disabled="disabled"' : 'clean=clean' }/>
						   </li>
						   <li class="horizontal_onlyRight">
						   <c:if test="${empty(brandID_open)}">
						   	<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openBrand();">
						   </c:if>
						   </li>
			              </TD>
                        </TR>
                       <tr><td colspan="6" ><img src="${ctx}/img/newbtn/btn_addgoods_0.png" btn=btn title="单品添加商品" 
						  onClick="javascript:openGoodSingle();"></td></tr>
                      </TBODY>
                    </table>
                    <fieldset id="goodsattribute">
					<legend><font style="font-size: 14;font: bold">&nbsp;&nbsp;选&nbsp;择&nbsp;商&nbsp;品&nbsp;属&nbsp;性&nbsp;&nbsp;</font></legend>
					<div id="gcDiv1" style="display: NONE">
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="unitid" value="计量单位" > 计量单位</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="taxrate" value="税率"> 税率</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="barcodeflag" value="批号"> 批号</SPAN>&nbsp;						
						<c:if test="${systemParameterPo.fspisusegoodslevel == '1'}"><SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="defaultdiscountvalue" value="商品级别"> 商品级别</SPAN>&nbsp;</c:if>
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="frameprocesscrafttype" value="工艺类型"> 工艺类型</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="framematerialtype" value="镜架材质"> 镜架材质</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="framesize" value="镜架尺寸"> 镜架尺寸</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="framestyle" value="镜架款式"> 镜架款式</SPAN>&nbsp;
					</div>
					<div id="gcDiv2" style="display: NONE">
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="unitid" value="计量单位"> 计量单位</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="taxrate" value="税率"> 税率</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="barcodeflag" value="批号"> 批号</SPAN>&nbsp;						
						<c:if test="${systemParameterPo.fspisusegoodslevel == '1'}"><SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="defaultdiscountvalue" value="商品级别"> 商品级别</SPAN>&nbsp;</c:if>
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="refractive" value="折射率"> 折射率</SPAN> &nbsp;<!--配件中含有  -->
					</div>
					<div id="gcDiv3" style="display: NONE">
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="unitid" value="计量单位"> 计量单位</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="taxrate" value="税率"> 税率</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="barcodeflag" value="批号"> 批号</SPAN>&nbsp;						
						<c:if test="${systemParameterPo.fspisusegoodslevel == '1'}"><SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="defaultdiscountvalue" value="商品级别"> 商品级别</SPAN>&nbsp;</c:if>
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="eyeglassmaterialtype" value="材料分类"> 材料分类</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="refractive" value="折射率"> 折射率</SPAN> &nbsp;<!--配件中含有  -->
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="ismutiluminosity" value="光度分类"> 光度分类</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="gradualclass" value="渐进片分类"> 渐进片分类</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="functionclass" value="镜片功能"> 镜片功能</SPAN>&nbsp;
					</div>
					<div id="gcDiv4" style="display: NONE">
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="unitid" value="计量单位"> 计量单位</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="taxrate" value="税率"> 税率</SPAN>&nbsp;
						<c:if test="${systemParameterPo.fspisusegoodslevel == '1'}"><SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="defaultdiscountvalue" value="商品级别"> 商品级别</SPAN>&nbsp;</c:if>
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="curvature" value=""> 曲率</SPAN> &nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="dia" value=""> 直径</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="usetype" value="使用类型"> 使用类型</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="returnmax" value="效期提醒上限"> 效期提醒上限</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);"  name="returnmin" value="效期提醒下限"> 效期提醒下限</SPAN>	&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="stealthclass" value="抛弃型分类"> 抛弃型分类</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="numberofdays" value="产品可使用天数"> 产品可使用天数</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="stealthType" value="接触镜类别"> 接触镜类别</SPAN>&nbsp;
					</div>
					<div id="gcDiv5" style="display: NONE">
						<SPAN id="gc" ><input type="checkbox"  onclick="addGoodsAttribute(this);" name="unitid" value="计量单位"> 计量单位</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="taxrate" value="税率"> 税率</SPAN>&nbsp;
						<c:if test="${systemParameterPo.fspisusegoodslevel == '1'}"><SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="defaultdiscountvalue" value="商品级别"> 商品级别</SPAN>&nbsp;</c:if>
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="capacity" value="主容量"> 主容量</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="capacityentry" value="次容量"> 次容量</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="returnmax" value="效期提醒上限"> 效期提醒上限</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="returnmin" value="效期提醒下限"> 效期提醒下限</SPAN>	&nbsp;
					</div>
					<div id="gcDiv6" style="display: NONE">
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="unitid" value="计量单位"> 计量单位</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="taxrate" value="税率"> 税率</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="barcodeflag" value="批号"> 批号</SPAN>&nbsp;						
						<c:if test="${systemParameterPo.fspisusegoodslevel == '1'}"><SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="defaultdiscountvalue" value="商品级别"> 商品级别</SPAN>&nbsp;</c:if>
						<SPAN id="gc" ><input type="checkbox"  onclick="addGoodsAttribute(this);" name="framesize" value="镜架尺寸"> 镜架尺寸</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="framematerialtype" value="功能"> 功能</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="framestyle" value="镜架款式"> 镜架款式</SPAN>&nbsp;
					</div>
					<div id="gcDiv7" style="display: NONE">
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="unitid" value="计量单位"> 计量单位</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="taxrate" value="税率"> 税率</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="barcodeflag" value="批号"> 批号</SPAN>&nbsp;						
						<c:if test="${systemParameterPo.fspisusegoodslevel == '1'}"><SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="defaultdiscountvalue" value="商品级别"> 商品级别</SPAN>&nbsp;</c:if>
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="othergoodssmallclass" value="其它商品小类"> 其它商品小类</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="othergoodsbigclass" value="其它商品大类"> 其它商品大类</SPAN>&nbsp;
					</div>
					<div id="gcDiv8" style="display: NONE">
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);"  name="unitid" value="计量单位"> 计量单位</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="taxrate" value="税率"> 税率</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="barcodeflag" value="批号"> 批号</SPAN>&nbsp;						
						<c:if test="${systemParameterPo.fspisusegoodslevel == '1'}"><SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="defaultdiscountvalue" value="商品级别"> 商品级别</SPAN>&nbsp;</c:if>
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="framesize" value="镜架尺寸"> 镜架尺寸</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="framestyle" value="镜架款式"> 镜架款式</SPAN>&nbsp;
					</div>
					<div id="gcDiv9" style="display: NONE">
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="unitid" value="计量单位"> 计量单位</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="taxrate" value="税率"> 税率</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="barcodeflag" value="批号"> 批号</SPAN>&nbsp;						
						<c:if test="${systemParameterPo.fspisusegoodslevel == '1'}"><SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="defaultdiscountvalue" value="商品级别"> 商品级别</SPAN>&nbsp;</c:if>
					</div>	
					<div id="gcDiv3D" style="display: NONE">
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="unitid" value="计量单位"> 计量单位</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="taxrate" value="税率"> 税率</SPAN>&nbsp;
						<c:if test="${systemParameterPo.fspisusegoodslevel == '1'}"><SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="defaultdiscountvalue" value="商品级别"> 商品级别</SPAN>&nbsp;</c:if>
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="eyeglassmaterialtype" value="材料分类"> 材料分类</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="refractive" value="折射率"> 折射率</SPAN> &nbsp;<!--配件中含有  -->
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="ismutiluminosity" value="光度分类"> 光度分类</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="gradualclass" value="渐进片分类"> 渐进片分类</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="functionclass" value="镜片功能"> 镜片功能</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);"  name="ordercycle" value=""> 车房周期</SPAN>&nbsp;
					</div>
					<div id="gcDiv4D" style="display: NONE">
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="unitid" value="计量单位"> 计量单位</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="taxrate" value="税率"> 税率</SPAN>&nbsp;
						<c:if test="${systemParameterPo.fspisusegoodslevel == '1'}"><SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="defaultdiscountvalue" value="商品级别"> 商品级别</SPAN>&nbsp;</c:if>
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="ordercycle" value="车房周期"> 车房周期</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="curvature1" value="曲率1"> 曲率1</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="curvature2" value="曲率2"> 曲率2</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="usetype" value="使用类型"> 使用类型</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="returnmax" value="效期提醒上限"> 效期提醒上限</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="returnmin" value="效期提醒下限"> 效期提醒下限</SPAN>	&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="stealthclass" value="抛弃型分类"> 抛弃型分类</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="dia1" value="直径"> 直径</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="numberofdays" value="产品可使用天数"> 产品可使用天数</SPAN>&nbsp;
					</div>
					
					<div id="gcDiv4R" style="display: NONE">
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="unitid" value="计量单位"> 计量单位</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="taxrate" value="税率"> 税率</SPAN>&nbsp;
						<c:if test="${systemParameterPo.fspisusegoodslevel == '1'}"><SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="defaultdiscountvalue" value="商品级别"> 商品级别</SPAN>&nbsp;</c:if>
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="ordercycle" value="车房周期"> 车房周期</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="curvature1" value="曲率1"> 曲率1</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="curvature2" value="曲率2"> 曲率2</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="usetype" value="使用类型"> 使用类型</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="returnmax" value="效期提醒上限"> 效期提醒上限</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="returnmin" value="效期提醒下限"> 效期提醒下限</SPAN>	&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="stealthclass" value="抛弃型分类"> 抛弃型分类</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="dia1" value="直径"> 直径</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="numberofdays" value="产品可使用天数"> 产品可使用天数</SPAN>&nbsp;
						<SPAN id="gc" ><input type="checkbox" onclick="addGoodsAttribute(this);" name="stealthTypeR" value="接触镜类别"> 接触镜类别</SPAN>&nbsp;
					</div>
						
					</fieldset>
					
					
                    <table id="addTable"  width="100%" border=0 align=center cellpadding=1 cellspacing=1 >
                      <tbody>
                     	 <TR height="26PX;" id="gca">
	                     	 <TD width="9%" class="table_body" >计量单位</TD>
	                     	 <TD class="table_none" width="24%">
	                     	 	<select id="bgiunitid" name="bgiunitid" clean=clean disabled="disabled"  at=at  validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '计量单位不能为空！'}]">
      		                 <option value="">----请选择----</option>
      		               <s:iterator value="unitList">
				               <option value="${butid}" >${butunitname}</option>
	     	               </s:iterator>
      	                   </select>
							</TD>
	                     	 <TD width="9%" class="table_body" >税率</TD>
	                     	 <TD class="table_none">
	                     	 	<input class="text_input100" at=at disabled="disabled" cleans=cleans type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" value="" id="bgitaxrate" name="bgitaxrate" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]">
							</TD>
	                     	 <TD width="9%" class="table_body" ><c:if test="${systemParameterPo.fspisusegoodslevel == '1'  }">商品级别</c:if>&nbsp;</TD>
	                     	 <TD class="table_none" width="24%">
	                     	 	<c:if test="${systemParameterPo.fspisusegoodslevel == '1'  }">
				                	<select at=at id="bgidefaultdiscountvalue" name="bgidefaultdiscountvalue" disabled="disabled">
				                		<option value="">---请选择---</option>
				                		<s:iterator value="selectGoodsLevelList">
							               	<option value="${bgluuid}">${bglname}</option>
				     	                </s:iterator>
				                	</select>
				                </c:if>
	                     	 </TD>
                     	 </TR>
                     	 <TR height="26PX;" id="gca1">
	                     	 <TD width="9%" class="table_body" >工艺类型</TD>
	                     	 <TD class="table_none"><select at=at disabled="disabled" id="bgiframeprocesscrafttype1" name="bgiframeprocesscrafttype1">
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="teachnologyTypeList">
				               <option value="${fttid}" >${fttname}</option>
	     	                 </s:iterator>
      	                   </select></TD>
	                     	 <TD width="9%" class="table_body" >镜架材质</TD>
	                     	 <TD class="table_none"><select at=at disabled="disabled" id="bgiframematerialtype1" name="bgiframematerialtype1">
                                 <option value="">----请选择----</option>
                                <s:iterator value="frameMateriallist">
				               <option value="${bfmid}" >${bfmname}</option>
	     	                 </s:iterator>
                             </select></TD>
	                     	 <TD width="9%" class="table_body" >镜架尺寸  </TD>
	                     	 <TD class="table_none"><input at=at disabled="disabled" clean=clean class="text_input100" type="text" id="bgiframesize1" name="bgiframesize1" onKeyUp="value=value.replace(/[^\w\d]/g,'')" value=""   maxlength="10" ></TD>
                     	 </TR>
                     	 <TR height="26PX;" id="gca1">
	                     	 <TD width="9%" class="table_body" >镜架款式</TD>
	                     	 <TD class="table_none" colspan="5">
		                     	 <select at=at disabled="disabled" id="bgiframestyle1" name="bgiframestyle1">
	      		                 	<option value="">----请选择----</option>
					               	<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='ks'}">
		                               <option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                              </c:if>	                                      	
		                            </c:forEach>
	      	                   	  </select>
      	                   	  </TD>
                     	  </TR>
                     	 <TR height="26PX;" id="gca2">
	                     	 <TD width="9%" class="table_body" >折射率</TD>
	                     	 <TD class="table_none" colspan="5">
	                     	 <select  at=at disabled="disabled" clean=clean id="bgirefractive2"  name="bgirefractive2" >
	      		                 <option value="">----请选择----</option>
	      		                    <s:iterator value="refractiveSetList">
					               <option value="${brfname}" >${brfname}</option>
		     	                    </s:iterator>
	      	                    </select>
	      	                 </TD>
                     	 </TR>
                     	 <TR height="26PX;" id="gca3">
	                     	 <TD width="9%" class="table_body" >材料分类</TD>
	                     	 <TD class="table_none"><select at=at disabled="disabled" clean=clean id="bgieyeglassmaterialtype3" name="bgieyeglassmaterialtype3" >
			               			<option value="">----请选择----</option>
			               			<option value="1" >树脂</option>
			               			<option value="2" >玻璃</option>
			               			<option value="3" >PC</option>
			               		</select></TD>
	                     	 <TD width="9%" class="table_body" >折射率</TD>
	                     	 <TD class="table_none">
	                     	 <select clean=clean at=at  disabled="disabled" id="bgirefractive3" name="bgirefractive3" >
	      		                 <option value="">----请选择----</option>
	      		                    <s:iterator value="refractiveSetList">
					               <option value="${brfname}" >${brfname}</option>
		     	                    </s:iterator>
	      	                    </select>
	      	                 </TD>
	                     	 <TD width="9%" class="table_body" >光度分类  </TD>
	                     	 <TD class="table_none"><select at=at disabled="disabled" clean=clean id="bgiismutiluminosity3"  name="bgiismutiluminosity3" >
	                          <option value="">----请选择----</option>
                              <option value="0" >单光</option>
                              <option value="M" >多光</option>
                              <option value="J" >渐进</option>
                              <option value="K" >抗疲劳</option>
                              <option value="Q" >其它</option>
                           </select></TD>
                     	 </TR>
                     	 <TR height="26PX;" id="gca3_1">
	                     	 <TD width="9%" class="table_body" >渐进片分类</TD>
	                     	 <TD class="table_none"><select at=at disabled="disabled" clean=clean id="bgigradualclass3" name="bgigradualclass3" >
			               			<option value="" >----请选择----</option>
			               			<option value="1" >青少年渐进</option>
			               			<option value="2" >成人渐进</option>
			               		</select></TD>
	                     	 <TD width="9%" class="table_body" >镜片功能</TD>
	                     	 <TD class="table_none" colspan="3">
 							<select at=at disabled="disabled" clean=clean id="bgifunctionclass3" name="bgifunctionclass3" >
	               			  <option value="">----请选择----</option>
                              <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
	                              <c:if test="${optionParamPoTmp.fopparentid=='gn'}">
	                               <option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
	                              </c:if>	                                      	
                              </c:forEach> 
		                      </select>
							</TD>
                     	 </TR>
                     	 <TR height="26PX;" id="gca4">
	                     	 <TD width="9%" class="table_body" >效期提醒下限</TD>
	                     	 <TD class="table_none">有效期前&nbsp;<input at=at disabled="disabled" clean=clean class="text_input60" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgireturnmax4" name="bgireturnmax4" value="" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(0);}"  maxlength="10" >&nbsp;天提醒进入滞销状态</TD>
	                     	 <TD width="9%" class="table_body" >效期提醒上限</TD>
	                     	 <TD class="table_none">有效期前&nbsp;<input at=at disabled="disabled" clean=clean class="text_input60" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgireturnmin4" name="bgireturnmin4" value="" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(0);}"  maxlength="10" >&nbsp;天提醒进入即将失效状态</TD>
	                     	 <TD width="9%" class="table_body" >使用类型</TD>
	                     	 <TD class="table_none"><select at=at disabled="disabled" clean=clean id="bgiusetype4"  name="bgiusetype4">
      		                 <option value="">----请选择----</option>
      		                <option value="1" >常戴型</option>
      		                 <option value="2" >抛弃型</option>
      		                 <option value="3" >塑形镜</option>
      	                   </select></TD>
                     	 </TR>
                     	 <TR height="26PX;" id="gca4_1">
	                     	 <TD width="9%" class="table_body" >抛弃型分类</TD>
	                     	 <TD class="table_none"><select at=at disabled="disabled" clean=clean id="bgistealthclass4" name="bgistealthclass4"  >
      		                 <option value="">----请选择----</option>
                             <option value="1" >日抛</option>
                             <option value="2" >周抛</option>
                             <option value="9" >双周抛</option>
                             <option value="3" >月抛</option>
                             <option value="4" >季抛</option>
                             <option value="5" >半年抛</option>
                             <option value="6" >年抛</option>
                             <option value="7" >RGP</option>
      	                   </select></TD>
	                     	 <TD width="9%" class="table_body" >直径 </TD>
	                     	 <TD class="table_none"><input at=at disabled="disabled" clean=clean class="text_input100" type="text" id="bgidia4" name="bgidia4" value=""  maxlength="10" ></TD>
	                     	 <TD width="9%" class="table_body" >曲率</TD>
	                     	 <TD class="table_none"><input at=at disabled="disabled" clean=clean class="text_input100" type="text" value="" id="bgicurvature4" name="bgicurvature4" maxlength="10" ></TD>
                     	 </TR>
                     	 
                     	 <TR height="26PX;" id="gca4_2">
	                     	
	                     	 <TD width="9%" class="table_body" >产品可使用天数</TD>
	                     	 <TD class="table_none"><input at=at disabled="disabled" clean=clean class="text_input100" type="text" value="" id="bginumberofdays4" name="bginumberofdays4" maxlength="10" ></TD>
	                     	 
	                       <TD height="26" class="table_body">软性接触镜成品类别</TD>
			               <TD class="table_none" colspan="3">
			               	 <select id="bgicontacttype4" name="bgicontacttype4" disabled="disabled">
      		                 <option value="">----请选择----</option>
                             <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
                              <c:if test="${optionParamPoTmp.fopparentid=='GCType'}">
                               <option value="${optionParamPoTmp.fopparamid }" ${(goodsInfoPo.bgicontacttype == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
                              </c:if>	                                      	
                             </c:forEach>
    	                     </select>
			               </TD>
                     	 </TR>
                     	 
                     	 <TR height="26PX;" id="gca5">
	                     	 <TD width="9%" class="table_body" >主容量</TD>
	                     	 <TD class="table_none"><input at=at disabled="disabled" clean=clean class="text_input100" type="text" id="bgicapacity5" name="bgicapacity5" value=""  maxlength="30"></TD>
	                     	 <TD width="9%" class="table_body" >次容量 </TD>
	                     	 <TD class="table_none"><input at=at disabled="disabled" clean=clean class="text_input100" type="text" id="bgicapacityentry5" name="bgicapacityentry5" value="" maxlength="30"></TD>
	                     	 <TD width="9%" class="table_body" >效期提醒上限</TD>
	                     	 <TD class="table_none">有效期前&nbsp;<input at=at disabled="disabled" clean=clean class="text_input60" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgireturnmax5" value="" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(0);}"  maxlength="10" >&nbsp;天提醒进入滞销状态</TD>
                     	 </TR>
                     	 <TR height="26PX;" id="gca5_1">
	                     	 <TD width="9%" class="table_body" >效期提醒下限</TD>
	                     	 <TD class="table_none" colspan="5">有效期前&nbsp;<input at=at disabled="disabled" clean=clean class="text_input60" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgireturnmin5" value="" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(0);}"  maxlength="10" >&nbsp;天提醒进入即将失效状态</TD>
                     	 </TR>
                     	 <TR height="26PX;" id="gca6">
	                     	 <TD width="9%" class="table_body" >镜架尺寸</TD>
	                     	 <TD class="table_none" ><input clean=clean at=at disabled="disabled" class="text_input100" type="text" id="bgiframesize6" name="bgiframesize6" onKeyUp="value=value.replace(/[^\w\d]/g,'')" value=""   maxlength="10" ></TD>
	                     	 <TD width="9%" class="table_body">功能 </TD>
	                     	 <TD class="table_none">
	                     	 	<select clean=clean at=at disabled="disabled" id="bgiframematerialtype6" name="bgiframematerialtype6" >
                                 <option value="" >----请选择----</option>
                                 <option value="1" >遮阳</option>
                                 <option value="2" >偏光</option>
                             </select>
	                     	 </TD>
	                     	 <TD width="9%" class="table_body" >镜架款式</TD>
	                     	 <TD class="table_none">
	                     	 	<select at=at disabled="disabled" id="bgiframestyle6" name="bgiframestyle6">
	      		                 	<option value="">----请选择----</option>
					               	<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='ks'}">
		                               <option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                              </c:if>	                                      	
		                            </c:forEach>
      	                   		</select>
      	                  	 </TD>
                     	  </TR>
                     	  <TR height="26PX;" id="gca8">
	                     	 <TD width="9%" class="table_body" >镜架尺寸</TD>
	                     	 <TD class="table_none"><input at=at disabled="disabled" clean=clean class="text_input100" type="text" id="bgiframesize8" name="bgiframesize8" onKeyUp="value=value.replace(/[^\w\d]/g,'')" value=""   maxlength="10" ></TD>
	                     	 <TD width="9%" class="table_body" >镜架款式</TD>
	                     	 <TD class="table_none" colspan="3">
	                     	 	<select at=at disabled="disabled" id="bgiframestyle8" name="bgiframestyle8">
	      		                 	<option value="">----请选择----</option>
					               	<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='ks'}">
		                               <option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                              </c:if>	                                      	
		                            </c:forEach>
      	                   		</select>
      	                  	 </TD>
                     	  </TR>
                     	  <TR height="26PX;" id="gca7">
	                     	 <TD width="9%" class="table_body" >其它商品小类</TD>
	                     	 <TD class="table_none" > <select at=at disabled="disabled" clean=clean id="bgiothergoodssmallclass7"  name="bgiothergoodssmallclass7">
      		                   <option value="">----请选择----</option>
      	                    </select></TD>
	                     	  <TD width="9%" class="table_body" >其它商品大类  </TD>
	                     	 <TD class="table_none" colspan="3"><select at=at disabled="disabled" clean=clean  id="bgiothergoodsbigclass7" name="bgiothergoodsbigclass7"  onChange="bgiothergoodsbigclassOnChange()">
      		                   <option value="">----请选择----</option>
				               <option value="Q" >其它材料</option>
				               <option value="D" >低值易耗品</option>
      	                     </select></TD>
                     	 </TR>
                     	 <TR height="26PX;" id="gca4_4d">
	                     	 <TD width="9%" class="table_body" >曲率1</TD>
	                     	 <TD class="table_none"><input at=at class="text_input100"  clean=clean toValidate=toValidate value="" type="text" id="bgicurvature1up4D" disabled="disabled" name="bgicurvature1up4D" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [11]}, 'Message' : '曲率2下限不能大于10字符'}]"> -
	                          <input class="text_input100" at=at clean=clean toValidate=toValidate value="" type="text" id="bgicurvature1ul4D" name="bgicurvature1ul4D" disabled="disabled" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [11]}, 'Message' : '曲率2上限不能大于10字符'}]"></TD>
	                     	 <TD width="9%" class="table_body" >曲率2 </TD>
	                     	 <TD class="table_none"><input at=at class="text_input100" clean=clean toValidate=toValidate value="" type="text" disabled="disabled" id="bgicurvature2up4D" name="bgicurvature2up4D" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [11]}, 'Message' : '曲率2下限不能大于10字符'}]"> -
	                          <input class="text_input100" at=at clean=clean toValidate=toValidate value="" type="text" id="bgicurvature2ul4D" disabled="disabled" name="bgicurvature2ul4D" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [11]}, 'Message' : '曲率2上限不能大于10字符'}]"></TD>
	                     	 <TD width="9%" class="table_body" >直径</TD>
	                     	 <TD class="table_none"><input at=at class="text_input100" clean=clean disabled="disabled"  value="" type="text" id="bgidia1up4D" name="bgidia1up4D" maxlength="10" > -
	                          <input class="text_input100" at=at clean=clean  value="" type="text" disabled="disabled" id="bgidia1ul4D" name="bgidia1ul4D"  maxlength="10" ></TD>
                     	 </TR>
                     	 <TR height="26PX;" id="gca4_4d1">
	                     	 <TD width="9%" class="table_body" >抛弃型分类</TD>
	                     	 <TD class="table_none"><select at=at disabled="disabled" clean=clean id="bgistealthclass4D"   >
      		                 <option value="">----请选择----</option>
                             <option value="1" >日抛</option>
                             <option value="2" >周抛</option>
                             <option value="9" >双周抛</option>
                             <option value="3" >月抛</option>
                             <option value="4" >季抛</option>
                             <option value="5" >半年抛</option>
                             <option value="6" >年抛</option>
                             <option value="7" >RGP</option>
      	                   </select></TD>
	                     	 <TD width="9%" class="table_body" >车房周期</TD>
	                     	 <TD class="table_none" ><input at=at clean=clean disabled="disabled" class="text_input80" type="text" id="bgiordercycle4D" value="" maxlength="5" >天</TD>
	                     	 <TD width="9%" class="table_body" >产品可使用天数</TD>
	                     	 <TD class="table_none" ><input at=at disabled="disabled" clean=clean class="text_input100" type="text" value="" id="bginumberofdays4D" name="bginumberofdays4D" maxlength="10" ></TD>
                     	 </TR>
                     	 
                     	 <TR height="26PX;" id="gca4_4R">
	                     	 <TD width="9%" class="table_body" >曲率1</TD>
	                     	 <TD class="table_none"><input at=at class="text_input100"  clean=clean toValidate=toValidate value="" type="text" id="bgicurvature1up4D" disabled="disabled" name="bgicurvature1up4D" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [11]}, 'Message' : '曲率2下限不能大于10字符'}]"> -
	                          <input class="text_input100" at=at clean=clean toValidate=toValidate value="" type="text" id="bgicurvature1ul4D" name="bgicurvature1ul4D" disabled="disabled" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [11]}, 'Message' : '曲率2上限不能大于10字符'}]"></TD>
	                     	 <TD width="9%" class="table_body" >曲率2 </TD>
	                     	 <TD class="table_none"><input at=at class="text_input100" clean=clean toValidate=toValidate value="" type="text" disabled="disabled" id="bgicurvature2up4D" name="bgicurvature2up4D" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [11]}, 'Message' : '曲率2下限不能大于10字符'}]"> -
	                          <input class="text_input100" at=at clean=clean toValidate=toValidate value="" type="text" id="bgicurvature2ul4D" disabled="disabled" name="bgicurvature2ul4D" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [11]}, 'Message' : '曲率2上限不能大于10字符'}]"></TD>
	                     	 <TD width="9%" class="table_body" >直径</TD>
	                     	 <TD class="table_none"><input at=at class="text_input100" clean=clean disabled="disabled"  value="" type="text" id="bgidia1up4D" name="bgidia1up4D" maxlength="10" > -
	                          <input class="text_input100" at=at clean=clean  value="" type="text" disabled="disabled" id="bgidia1ul4D" name="bgidia1ul4D"  maxlength="10" ></TD>
                     	 </TR>
                     	 <TR height="26PX;" id="gca4_4R1">
	                     	 <TD width="9%" class="table_body" >抛弃型分类</TD>
	                     	 <TD class="table_none"><select at=at disabled="disabled" clean=clean id="bgistealthclass4D"   >
      		                 <option value="">----请选择----</option>
                             <option value="1" >日抛</option>
                             <option value="2" >周抛</option>
                             <option value="9" >双周抛</option>
                             <option value="3" >月抛</option>
                             <option value="4" >季抛</option>
                             <option value="5" >半年抛</option>
                             <option value="6" >年抛</option>
                             <option value="7" >RGP</option>
      	                   </select></TD>
	                     	 <TD width="9%" class="table_body" >车房周期</TD>
	                     	 <TD class="table_none" ><input at=at clean=clean disabled="disabled" class="text_input80" type="text" id="bgiordercycle4D" value="" maxlength="5" >天</TD>
	                     	 <TD width="9%" class="table_body" >产品可使用天数</TD>
	                     	 <TD class="table_none" ><input at=at disabled="disabled" clean=clean class="text_input100" type="text" value="" id="bginumberofdays4D" name="bginumberofdays4D" maxlength="10" ></TD>
                     	 </TR>
                     	 <TR height="26PX;" id="gca4_4R2">
	                       <TD height="26" class="table_body">软性接触镜订制类别</TD>
			               <TD class="table_none" colspan="5">
			               	 <select id="bgicontacttype4R" name="bgicontacttype4R" disabled="disabled">
      		                 <option value="">----请选择----</option>
                             <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
                              <c:if test="${optionParamPoTmp.fopparentid=='GRType'}">
                               <option value="${optionParamPoTmp.fopparamid }" ${(goodsInfoPo.bgicontacttyped == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
                              </c:if>	                                      	
                             </c:forEach>
      	                   </select>
			               </TD>
                     	 </TR>
                     	 
                     	 <TR height="26PX;" id="gca3_3d">
	                     	 <TD width="9%" class="table_body" >车房周期</TD>
	                     	 <TD class="table_none" colspan="5"> <input at=at clean=clean disabled="disabled" class="text_input80" type="text" id="bgiordercycle3D" name="bgiordercycle3D"  value="" maxlength="5" >天</TD>
                     	 </TR>
                     	  <TR height="26PX;" id="gca_1">
	      	               <TD width="9%" class="table_body">批号管理</TD>
			               <td align="left" class="table_none" colspan="5">
			               		<select id="bgibarcodeflagid" name="bgibarcodeflag" at=at disabled="disabled">
			               			<option value="">----请选择----</option>
			               			<option value="0">不使用批号</option>
			               			<option value="1">使用批号</option>
			               		</select>
                           </td>                     	  
                     	 </TR>                     	 
                      </tbody>
                    </TABLE>
                  </DIV>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
	                          <c:if test="${(permissionPo.keya==1)}">
	                         	 <img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
	                          </c:if>
                          </TD>
						</TR>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY>
   
    </HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>