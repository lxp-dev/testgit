<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报表中心</title>
</head>
<script>
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });

	    var category = '${goodscategoryID}';
		if(category == '' || category == '5' || category == '9'){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=yj]").hide();
			$("tr[id=hc]").hide();
			$("tr[id=lh]").hide();
			$("tr[id=pj]").hide();
		}
		
		if(category == '1'){
			$("tr[id=jj]").show();
			$("tr[id=jp]").hide();
			$("tr[id=yj]").hide();
			$("tr[id=hc]").hide();
			$("tr[id=lh]").hide();
			$("tr[id=pj]").hide();
		}

		if(category == '6'){
			$("tr[id=jj]").show();
			$("tr[id=jp]").hide();
			$("tr[id=yj]").hide();
			$("tr[id=hc]").hide();
			$("tr[id=lh]").hide();
			$("tr[id=pj]").hide();
			$("tr[nolh=nolh]").hide();
		}

		if(category == '2'){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=yj]").hide();
			$("tr[id=hc]").hide();
			$("tr[id=lh]").hide();
			$("tr[id=pj]").show();
		}
		
		if(category == '3'){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").show();
			$("tr[id=yj]").hide();
			$("tr[id=hc]").hide();
			$("tr[id=lh]").hide();
			$("tr[id=pj]").hide();
		}
		
		if(category == '4'){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=yj]").show();
			$("tr[id=hc]").hide();
			$("tr[id=lh]").hide();
			$("tr[id=pj]").hide();
		}

		if(category == '7'){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=yj]").hide();
			$("tr[id=hc]").show();
			$("tr[id=lh]").hide();
			$("tr[id=pj]").hide();
		}

		if(category == '8'){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=yj]").hide();
			$("tr[id=hc]").hide();
			$("tr[id=lh]").show();
			$("tr[id=pj]").hide();
		}
		
		if('${person.personcompanytype}' == '2'){
        	loadDepartmentids('${person.personcompanyid}');
        }
	});

	function search(){
		createForm();

		var formAction = 'sskuhzb';
		if(checkForm(goodsForm)){       		
			var BeginDate = document.all.startTime2.value;
			var End = document.all.endTime2.value;
			var BeginDate2 = document.all.startTime3.value;
			var End2 = document.all.endTime3.value;
			if(BeginDate==""){
				alert('请选择开始日期!');
				document.getElementById("startTime2").focus();
				return false;
			}
			if(End==""){
				alert('请选择截止日期!');
				document.getElementById("endTime2").focus();
				return false;
			}

			var supplierID = $("input[id=supplierID2]").val();
			var goodscategoryID = $("input[id=goodscategoryID2]:checked").val();
			var warehouseID=$("input[id=warehouseID2]").val();
			
			$('input[name=logincompanyid]').get(0).value = '${person.personcompanyid}';
			
			if(warehouseID == ''){
				warehouseID = $("#dids").val()
			}
			
			var brandID=$("input[id=brandID2]").val(); 
			var warehouseNames = EncodeUtf8($("#ds").val());
			
			if (warehouseNames == ''){
				if($("#dnames").val() == ''){
					warehouseNames = '所有仓位';
				}else{
					warehouseNames =  EncodeUtf8($("#dnames").val());
				}
			}

			var supplierName=EncodeUtf8($("input[id=supplierName2]").val());
			var brandName=EncodeUtf8($("input[id=brandName2]").val());
			var bgispecjj=$('#bgispecjj2').val();              //型号
	    	var bgicolorjj=$('#bgicolorjj2').val();            //色号
	    	var bgispeclh=$('#bgispeclh2').val();              //型号
	    	var bgicolorlh=$('#bgicolorlh2').val();            //色号
	    	if(!bgispecjj){
	    		bgispecjj = bgispeclh;
	        }
	    	if(!bgicolorjj){
	    		bgicolorjj = bgicolorlh;
	        }
	    	var bgiframesizejj=$('#bgiframesizejj2').val();         //尺寸 
	    	var bgieyeglassmaterialtypejp=$('#bgieyeglassmaterialtypejp2').val(); //镜片材料分类
	    	var bgirefractivejp=$('#bgirefractivejp2').val(); //镜片折射率
	    	var bgiismutiluminosityjp=$('#bgiismutiluminosityjp2').val(); //镜片光度分类
	    	var minSphjp=$('#minSphjp2').val(); //镜片球镜范围
	    	var maxSphjp=$('#maxSphjp2').val(); //镜片球镜范围
	    	var minCyljp=$('#minCyljp2').val(); //镜片柱镜范围
	    	var maxCyljp=$('#maxCyljp2').val(); //镜片柱镜范围
	    	var bgiusetypeyj=$('#bgiusetypeyj2').val(); //隐形使用类型
	    	var bgistealthclassyj=$('#bgistealthclassyj2').val(); //抛弃型分类
	    	var minSphyj=$('#minSphyj2').val(); //隐形球镜范围
	    	var maxSphyj=$('#maxSphyj2').val(); //隐形球镜范围
	    	var minCylyj=$('#minCylyj2').val(); //隐形柱镜范围
	    	var maxCylyj=$('#maxCylyj2').val(); //隐形柱镜范围
	    	var bgiothergoodsbigclass=$('#bgiothergoodsbigclass2').val();
	    	var bgiothergoodssmallclass=""; 
	    	var minSphlh=$('#minSphlh2').val(); 
	    	var maxSphlh=$('#maxSphlh2').val();
	    	var pjlx = $("#pjlx2").val();
		    var gylx = $('#bgitechnologytypeid2').val();
		    var czjj = $('#bgiframematerialtype2').val();
	    	
			$("input[name=bgnDate]").val(BeginDate);
		    $("input[name=endDate]").val(End);
			$("input[name=bgnDate2]").val(BeginDate2);
		    $("input[name=endDate2]").val(End2);
		    $("input[name=goodsCategoryID]").val(goodscategoryID);
		    $("input[name=supplierID]").val(supplierID);
		    $("input[name=bandID]").val(brandID);
		    $("input[name=warehouseID]").val(warehouseID);
		    /*
		    $("input[name=warehouseName]").val(warehouseNames);
		    $("input[name=supplierName]").val(supplierName);
		    $("input[name=brandName]").val(brandName);
		    */
		    $("input[name=bgispecjj]").val(bgispecjj);
		    $("input[name=bgicolorjj]").val(bgicolorjj);
		    $("input[name=bgispeclh]").val(bgispeclh);
		    $("input[name=bgicolorlh]").val(bgicolorlh);
		    $("input[name=bgiframesizejj]").val(bgiframesizejj);
		    $("input[name=bgieyeglassmaterialtypejp]").val(bgieyeglassmaterialtypejp);
		    $("input[name=bgirefractivejp]").val(bgirefractivejp);
		    $("input[name=bgiismutiluminosityjp]").val(bgiismutiluminosityjp);
		    $("input[name=minSphjp]").val(minSphjp);
		    $("input[name=maxSphjp]").val(maxSphjp);
		    $("input[name=minCyljp]").val(minCyljp);
		    $("input[name=maxCyljp]").val(maxCyljp);
		    $("input[name=bgiusetypeyj]").val(bgiusetypeyj);
		    $("input[name=bgistealthclassyj]").val(bgistealthclassyj);
		    $("input[name=minSphyj]").val(minSphyj);
		    $("input[name=maxSphyj]").val(maxSphyj);
		    $("input[name=minCylyj]").val(minCylyj);
		    $("input[name=maxCylyj]").val(maxCylyj);
		    $("input[name=bgiothergoodsbigclass]").val(bgiothergoodsbigclass);
		    //$("input[name=bgiothergoodssmallclass]").val(bgiothergoodssmallclass);
		    $("input[name=minSphlh]").val(minSphlh);
		    $("input[name=maxSphlh]").val(maxSphlh);
		    $("input[name=pjlx]").val(pjlx);
		    $("input[name=bgispectyj]").val(bgispecjj);
		    $("input[name=bgicolortyj]").val(bgicolorjj);
		    $("input[name=bgiframesizetyj]").val(bgiframesizejj);
		    $("input[name=gylx]").val(gylx);
		    $("input[name=czjj]").val(czjj);
		    
			var isShow = "";
			$("input[id=isShow2]").each(function() {
				if($(this).attr("checked") == true) {
					isShow = $(this).val();
				}
			});
			
			$("input[name=isShow]").val(isShow);
			
			var showCompanyName = "";
			$("input[id=showCompanyName2]").each(function() {
				if($(this).attr("checked") == true) {
					showCompanyName = $(this).val();
				}
			});
			$("input[name=showCompanyName]").val(showCompanyName);
			
			var DataURL = '';
			var reportName = 'sales_sskchzb.cpt';

			DataURL = "report.action?reportlet="+reportName+"&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&goodsCategoryID="+goodscategoryID+"&bgnDate2="+BeginDate2+"&endDate2="+End2
					    +"&supplierID="+supplierID+"&bandID="+brandID+"&warehouseID="+warehouseID+"&warehouseNames="+warehouseNames
						+'&supplierName='+supplierName+'&brandName='+brandName+'&isShow='+isShow
						+"&bgispecjj="+bgispecjj+"&bgicolorjj="+bgicolorjj+"&bgiframesizejj="+bgiframesizejj
					    +"&bgieyeglassmaterialtypejp="+bgieyeglassmaterialtypejp+"&bgirefractivejp="+bgirefractivejp+"&bgiismutiluminosityjp="+bgiismutiluminosityjp
                        +"&minSphjp="+minSphjp+"&maxSphjp="+maxSphjp+"&minCyljp="+minCyljp
                        +"&maxCyljp="+maxCyljp+"&bgiusetypeyj="+bgiusetypeyj+"&bgistealthclassyj="+bgistealthclassyj
                        +"&minSphyj="+minSphyj+"&maxSphyj="+maxSphyj+"&minCylyj="+minCylyj
                        +"&maxCylyj="+maxCylyj+"&bgiothergoodsbigclass="+bgiothergoodsbigclass+"&bgiothergoodssmallclass="+bgiothergoodssmallclass
                        +"&minSphlh="+minSphlh+"&maxSphlh="+maxSphlh+"&pjlx="+pjlx
						+"&bgispectyj="+bgispecjj+"&bgicolortyj="+bgicolorjj+"&bgiframesizetyj="+bgiframesizejj
						+"&gylx="+gylx+"&czjj="+czjj						
                        +"&showCompanyName="+showCompanyName;

			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;		
			if(is_iPad()){
				showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				DataURL = "report.action?reportlet=" + reportName + "&__bypagesize__=false";
				queryReport(DataURL,formAction);
			}
			document.getElementById('popupTitle').innerHTML="【销售库存汇总表 】";
		}

	}
	
	function createForm(){
		var rptFrm = document.createElement("form"); 
		rptFrm.id = "rptFrm";
		rptFrm.method = "post";
		
		var isShow = document.createElement("input");	     
	    isShow.type = "hidden";
	    isShow.name = "isShow";
	    isShow.value = '';	  
	    rptFrm.appendChild(isShow); 
		
	    var bgnDate = document.createElement("input");	     
	    bgnDate.type = "hidden";
	    bgnDate.name = "bgnDate";
	    bgnDate.value = '';	  
	    rptFrm.appendChild(bgnDate); 

	    var endDate = document.createElement("input");	     
	    endDate.type = "hidden";
	    endDate.name = "endDate";
	    endDate.value = '';	  
	    rptFrm.appendChild(endDate);  

	    var bgnDate = document.createElement("input");	     
	    bgnDate.type = "hidden";
	    bgnDate.name = "bgnDate2";
	    bgnDate.value = '';	  
	    rptFrm.appendChild(bgnDate); 

	    var endDate = document.createElement("input");	     
	    endDate.type = "hidden";
	    endDate.name = "endDate2";
	    endDate.value = '';	  
	    rptFrm.appendChild(endDate); 

	    var goodsCategoryID = document.createElement("input");	     
	    goodsCategoryID.type = "hidden";
	    goodsCategoryID.name = "goodsCategoryID";
	    goodsCategoryID.value = '';	  
	    rptFrm.appendChild(goodsCategoryID);  

	    var supplierID = document.createElement("input");	     
	    supplierID.type = "hidden";
	    supplierID.name = "supplierID";
	    supplierID.value = '';	  
	    rptFrm.appendChild(supplierID); 

	    var bandID = document.createElement("input");	     
	    bandID.type = "hidden";
	    bandID.name = "bandID";
	    bandID.value = '';	  
	    rptFrm.appendChild(bandID);  
	    
	    var logincompanyid = document.createElement("input");	     
	    logincompanyid.type = "hidden";
	    logincompanyid.name = "logincompanyid";
	    logincompanyid.value = '';	  
	    rptFrm.appendChild(logincompanyid);  
	    
	    var warehouseID = document.createElement("input");	     
	    warehouseID.type = "hidden";
	    warehouseID.name = "warehouseID";
	    warehouseID.value = '';	  
	    rptFrm.appendChild(warehouseID);    
/*
	    var warehouseNames = document.createElement("input");	     
	    warehouseNames.type = "hidden";
	    warehouseNames.name = "warehouseNames";
	    warehouseNames.value = '';	  
	    rptFrm.appendChild(warehouseNames);  

	    var supplierName = document.createElement("input");	     
	    supplierName.type = "hidden";
	    supplierName.name = "supplierName";
	    supplierName.value = '';	  
	    rptFrm.appendChild(supplierName);    

	    var brandName = document.createElement("input");	     
	    brandName.type = "hidden";
	    brandName.name = "brandName";
	    brandName.value = '';	  
	    rptFrm.appendChild(brandName);  
	*/    
	    var bgispecjj = document.createElement("input");	     
	    bgispecjj.type = "hidden";
	    bgispecjj.name = "bgispecjj";
	    bgispecjj.value = '';	  
	    rptFrm.appendChild(bgispecjj);  
	    
	    var bgicolorjj = document.createElement("input");	     
	    bgicolorjj.type = "hidden";
	    bgicolorjj.name = "bgicolorjj";
	    bgicolorjj.value = '';	  
	    rptFrm.appendChild(bgicolorjj);
	    
	    var bgispeclh = document.createElement("input");	     
	    bgispeclh.type = "hidden";
	    bgispeclh.name = "bgispeclh";
	    bgispeclh.value = '';	  
	    rptFrm.appendChild(bgispeclh);
	    
	    var bgicolorlh = document.createElement("input");	     
	    bgicolorlh.type = "hidden";
	    bgicolorlh.name = "bgicolorlh";
	    bgicolorlh.value = '';	  
	    rptFrm.appendChild(bgicolorlh);
	    
	    var bgiframesizejj = document.createElement("input");	     
	    bgiframesizejj.type = "hidden";
	    bgiframesizejj.name = "bgiframesizejj";
	    bgiframesizejj.value = '';	  
	    rptFrm.appendChild(bgiframesizejj);
	    
	    var bgieyeglassmaterialtypejp = document.createElement("input");	     
	    bgieyeglassmaterialtypejp.type = "hidden";
	    bgieyeglassmaterialtypejp.name = "bgieyeglassmaterialtypejp";
	    bgieyeglassmaterialtypejp.value = '';	  
	    rptFrm.appendChild(bgieyeglassmaterialtypejp);
	    
	    var bgirefractivejp = document.createElement("input");	     
	    bgirefractivejp.type = "hidden";
	    bgirefractivejp.name = "bgirefractivejp";
	    bgirefractivejp.value = '';	  
	    rptFrm.appendChild(bgirefractivejp);
	    
	    var bgiismutiluminosityjp = document.createElement("input");	     
	    bgiismutiluminosityjp.type = "hidden";
	    bgiismutiluminosityjp.name = "bgiismutiluminosityjp";
	    bgiismutiluminosityjp.value = '';	  
	    rptFrm.appendChild(bgiismutiluminosityjp);
	    
	    var minSphjp = document.createElement("input");	     
	    minSphjp.type = "hidden";
	    minSphjp.name = "minSphjp";
	    minSphjp.value = '';	  
	    rptFrm.appendChild(minSphjp);
	    
	    var maxSphjp = document.createElement("input");	     
	    maxSphjp.type = "hidden";
	    maxSphjp.name = "maxSphjp";
	    maxSphjp.value = '';	  
	    rptFrm.appendChild(maxSphjp);
	    
	    var minCyljp = document.createElement("input");	     
	    minCyljp.type = "hidden";
	    minCyljp.name = "minCyljp";
	    minCyljp.value = '';	  
	    rptFrm.appendChild(minCyljp);
	    
	    var maxCyljp = document.createElement("input");	     
	    maxCyljp.type = "hidden";
	    maxCyljp.name = "maxCyljp";
	    maxCyljp.value = '';	  
	    rptFrm.appendChild(maxCyljp);
	    
	    var bgiusetypeyj = document.createElement("input");	     
	    bgiusetypeyj.type = "hidden";
	    bgiusetypeyj.name = "bgiusetypeyj";
	    bgiusetypeyj.value = '';	  
	    rptFrm.appendChild(bgiusetypeyj);
	    
	    var bgistealthclassyj = document.createElement("input");	     
	    bgistealthclassyj.type = "hidden";
	    bgistealthclassyj.name = "bgistealthclassyj";
	    bgistealthclassyj.value = '';	  
	    rptFrm.appendChild(bgistealthclassyj);
	    
	    var minSphyj = document.createElement("input");	     
	    minSphyj.type = "hidden";
	    minSphyj.name = "minSphyj";
	    minSphyj.value = '';	  
	    rptFrm.appendChild(minSphyj);
	    
	    var maxSphyj = document.createElement("input");	     
	    maxSphyj.type = "hidden";
	    maxSphyj.name = "maxSphyj";
	    maxSphyj.value = '';	  
	    rptFrm.appendChild(maxSphyj);
	    
	    var minCylyj = document.createElement("input");	     
	    minCylyj.type = "hidden";
	    minCylyj.name = "minCylyj";
	    minCylyj.value = '';	  
	    rptFrm.appendChild(minCylyj);
	    
	    var maxCylyj = document.createElement("input");	     
	    maxCylyj.type = "hidden";
	    maxCylyj.name = "maxCylyj";
	    maxCylyj.value = '';	  
	    rptFrm.appendChild(maxCylyj);
	    
	    var bgiothergoodsbigclass = document.createElement("input");	     
	    bgiothergoodsbigclass.type = "hidden";
	    bgiothergoodsbigclass.name = "bgiothergoodsbigclass";
	    bgiothergoodsbigclass.value = '';	  
	    rptFrm.appendChild(bgiothergoodsbigclass);
	    /*
	    var bgiothergoodssmallclass = document.createElement("input");	     
	    bgiothergoodssmallclass.type = "hidden";
	    bgiothergoodssmallclass.name = "bgiothergoodssmallclass";
	    bgiothergoodssmallclass.value = '';	  
	    rptFrm.appendChild(bgiothergoodssmallclass);
	    */
	    var minSphlh = document.createElement("input");	     
	    minSphlh.type = "hidden";
	    minSphlh.name = "minSphlh";
	    minSphlh.value = '';	  
	    rptFrm.appendChild(minSphlh);
	    
	    var maxSphlh = document.createElement("input");	     
	    maxSphlh.type = "hidden";
	    maxSphlh.name = "maxSphlh";
	    maxSphlh.value = '';	  
	    rptFrm.appendChild(maxSphlh);
	    
	    var pjlx = document.createElement("input");	     
	    pjlx.type = "hidden";
	    pjlx.name = "pjlx";
	    pjlx.value = '';	  
	    rptFrm.appendChild(pjlx);
	    
	    var showCompanyName = document.createElement("input");	     
	    showCompanyName.type = "hidden";
	    showCompanyName.name = "showCompanyName";
	    showCompanyName.value = '';
	    rptFrm.appendChild(showCompanyName);

	    var bgispectyj = document.createElement("input");	     
	    bgispectyj.type = "hidden";
	    bgispectyj.name = "bgispectyj";
	    bgispectyj.value = '';	  
	    rptFrm.appendChild(bgispectyj);
	    
	    var bgicolortyj = document.createElement("input");	     
	    bgicolortyj.type = "hidden";
	    bgicolortyj.name = "bgicolortyj";
	    bgicolortyj.value = '';	  
	    rptFrm.appendChild(bgicolortyj);
	    
	    var bgiframesizettyj = document.createElement("input");	     
	    bgiframesizettyj.type = "hidden";
	    bgiframesizettyj.name = "bgiframesizettyj";
	    bgiframesizettyj.value = '';	  
	    rptFrm.appendChild(bgiframesizettyj);

	    var gylx = document.createElement("input");	     
	    gylx.type = "hidden";
	    gylx.name = "gylx";
	    gylx.value = '';	  
	    rptFrm.appendChild(gylx);
	    
	    var czjj = document.createElement("input");	     
	    czjj.type = "hidden";
	    czjj.name = "czjj";
	    czjj.value = '';	  
	    rptFrm.appendChild(czjj);
	    
	    document.body.appendChild(rptFrm);
    }
	
	function queryReport(DataURL,formAction){
		var rptFrm = document.getElementById('rptFrm');
		rptFrm.action = DataURL;    
		rptFrm.target = formAction;    

		if (rptFrm.attachEvent){
			rptFrm.attachEvent("onsubmit",function(){ window.open('',formAction,'toolbar=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-50));}); 		  
		}else{
			rptFrm.addEventListener("onsubmit",function(){ window.open('',formAction,'toolbar=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-50));}); 		  
		}
	
		if (rptFrm.fireEvent){
			rptFrm.fireEvent("onsubmit");	
		}else{
			//rptFrm.removeEventListener("onsubmit");	
		}         

	    rptFrm.submit();  
	  
	    document.body.removeChild(rptFrm); 
    }
    
    function showterm(){
		var category = $("input[name=goodscategoryID2]:checked").val();   
		if(category == '' || category == '5' || category == '9'){
			$("tr[id=jj]").hide();
			$("#bgispecjj2").val('');
			$("#bgicolorjj2").val('');
			$("#bgiframesizejj2").val('');
			$("tr[id=jp]").hide();
			$("#bgimaterialclassjp2").val('');
			$("#bgirefractivejp2").val('');
			$("#bgieyeglassmaterialtypejp2").val('');
			$("#maxSphjp2").val('');
			$("#minSphjp2").val('');
			$("#maxCyljp2").val('');
			$("#minCyljp2").val('');
			$("tr[id=yj]").hide();
			$("#bgiusetypeyj2").val('');
			$("#bgistealthclassyj2").val('');
			$("#maxSphyj2").val('');
			$("#minSphyj2").val('');
			$("#maxCylyj2").val('');
			$("#minCylyj2").val('');
			$("tr[id=hc]").hide();
			$("#bgiothergoodsbigclass2").val('');
			$("#bgiothergoodssmallclass2").val('');
			$("tr[id=lh]").hide();
			$("#minSphlh2").val('');
			$("#maxSphlh2").val('');
			$("#bgispeclh2").val('');
			$("#bgicolorlh2").val('');
			$("tr[id=pj]").hide();
			$("#pjlx2").val('');
		}
		
		if(category == '1' || category == '6'){
			$("tr[id=jj]").show();
			$("tr[id=jp]").hide();
			$("#bgimaterialclassjp2").val('');
			$("#bgirefractivejp2").val('');
			$("#bgieyeglassmaterialtypejp2").val('');
			$("#maxSphjp2").val('');
			$("#minSphjp2").val('');
			$("#maxCyljp2").val('');
			$("#minCyljp2").val('');
			$("tr[id=yj]").hide();
			$("#bgiusetypeyj2").val('');
			$("#bgistealthclassyj2").val('');
			$("#maxSphyj2").val('');
			$("#minSphyj2").val('');
			$("#maxCylyj2").val('');
			$("#minCylyj2").val('');
			if(category == '6' || category == '8'){
				$("tr[nolh=nolh]").hide();
				$("tr[nolh=nolh]").find("select").val('');
			}
			$("#bgispecjj2").val('');
			$("#bgicolorjj2").val('');
			$("#bgiframesizejj2").val('');
			$("tr[id=hc]").hide();
			$("#bgiothergoodsbigclass2").val('');
			$("#bgiothergoodssmallclass2").val('');
			$("tr[id=lh]").hide();
			$("#minSphlh2").val('');
			$("#maxSphlh2").val('');
			$("#bgispeclh2").val('');
			$("#bgicolorlh2").val('');
			$("tr[id=pj]").hide();
			$("#pjlx2").val('');
		}
		
		if(category == '3'){
			$("tr[id=jj]").hide();
			$("#bgispecjj2").val('');
			$("#bgicolorjj2").val('');
			$("#bgiframesizejj2").val('');
			$("tr[id=jp]").show();
			$("tr[id=yj]").hide();
			$("#bgiusetypeyj2").val('');
			$("#bgistealthclassyj2").val('');
			$("#maxSphyj2").val('');
			$("#minSphyj2").val('');
			$("#maxCylyj2").val('');
			$("#minCylyj2").val('');
			$("tr[id=hc]").hide();
			$("#bgiothergoodsbigclass2").val('');
			$("#bgiothergoodssmallclass2").val('');
			$("tr[id=lh]").hide();
			$("#minSphlh2").val('');
			$("#maxSphlh2").val('');
			$("#bgispeclh2").val('');
			$("#bgicolorlh2").val('');
			$("tr[id=pj]").hide();
			$("#pjlx2").val('');
		}
		
		if(category == '4'){
			$("tr[id=jj]").hide();
			$("#bgispecjj2").val('');
			$("#bgicolorjj2").val('');
			$("#bgiframesizejj2").val('');
			$("tr[id=jp]").hide();
			$("#bgimaterialclassjp2").val('');
			$("#bgirefractivejp2").val('');
			$("#bgieyeglassmaterialtypejp2").val('');
			$("#maxSphjp2").val('');
			$("#minSphjp2").val('');
			$("#maxCyljp2").val('');
			$("#minCyljp2").val('');
			$("tr[id=hc]").hide();
			$("#bgiothergoodsbigclass2").val('');
			$("#bgiothergoodssmallclass2").val('');
			$("tr[id=lh]").hide();
			$("#minSphlh2").val('');
			$("#maxSphlh2").val('');
			$("#bgispeclh2").val('');
			$("#bgicolorlh2").val('');
			$("tr[id=pj]").hide();
			$("#pjlx2").val('');
			$("tr[id=yj]").show();
		}

		if(category == '7'){
			$("tr[id=jj]").hide();
			$("#bgispecjj2").val('');
			$("#bgicolorjj2").val('');
			$("#bgiframesizejj2").val('');
			$("tr[id=jp]").hide();
			$("#bgimaterialclassjp2").val('');
			$("#bgirefractivejp2").val('');
			$("#bgieyeglassmaterialtypejp2").val('');
			$("#maxSphjp2").val('');
			$("#minSphjp2").val('');
			$("#maxCyljp2").val('');
			$("#minCyljp2").val('');
			$("tr[id=yj]").hide();
			$("#bgiusetypeyj2").val('');
			$("#bgistealthclassyj2").val('');
			$("#maxSphyj2").val('');
			$("#minSphyj2").val('');
			$("#maxCylyj2").val('');
			$("#minCylyj2").val('');
			$("tr[id=lh]").hide();
			$("#minSphlh2").val('');
			$("#maxSphlh2").val('');
			$("#bgispeclh2").val('');
			$("#bgicolorlh2").val('');
			$("tr[id=pj]").hide();
			$("#pjlx2").val('');
			$("tr[id=hc]").show();
		}

		if(category == '8'){
			$("tr[id=jj]").hide();
			$("#bgispecjj2").val('');
			$("#bgicolorjj2").val('');
			$("#bgiframesizejj2").val('');
			$("tr[id=jp]").hide();
			$("#bgimaterialclassjp2").val('');
			$("#bgirefractivejp2").val('');
			$("#bgieyeglassmaterialtypejp2").val('');
			$("#maxSphjp2").val('');
			$("#minSphjp2").val('');
			$("#maxCyljp2").val('');
			$("#minCyljp2").val('');
			$("tr[id=yj]").hide();
			$("#bgiusetypeyj2").val('');
			$("#bgistealthclassyj2").val('');
			$("#maxSphyj2").val('');
			$("#minSphyj2").val('');
			$("#maxCylyj2").val('');
			$("#minCylyj2").val('');
			$("tr[id=hc]").hide();
			$("#bgiothergoodsbigclass2").val('');
			$("#bgiothergoodssmallclass2").val('');
			$("tr[id=pj]").hide();
			$("#pjlx2").val('');
			$("tr[id=lh]").show();
		}

		if(category == '2'){
			$("tr[id=jj]").hide();
			$("#bgispecjj2").val('');
			$("#bgicolorjj2").val('');
			$("#bgiframesizejj2").val('');
			$("tr[id=jp]").hide();
			$("#bgimaterialclassjp2").val('');
			$("#bgirefractivejp2").val('');
			$("#bgieyeglassmaterialtypejp2").val('');
			$("#maxSphjp2").val('');
			$("#minSphjp2").val('');
			$("#maxCyljp2").val('');
			$("#minCyljp2").val('');
			$("tr[id=yj]").hide();
			$("#bgiusetypeyj2").val('');
			$("#bgistealthclassyj2").val('');
			$("#maxSphyj2").val('');
			$("#minSphyj2").val('');
			$("#maxCylyj2").val('');
			$("#minCylyj2").val('');
			$("tr[id=hc]").hide();
			$("#bgiothergoodsbigclass2").val('');
			$("#bgiothergoodssmallclass2").val('');
			$("tr[id=lh]").hide();
			$("#minSphlh2").val('');
			$("#maxSphlh2").val('');
			$("#bgispeclh2").val('');
			$("#bgicolorlh2").val('');
			$("tr[id=pj]").show();
		}

		document.getElementById('supplierID2').value = "";
		document.getElementById('supplierName2').value = "";
		document.getElementById('dssupplierName2').value = "";

		document.getElementById('brandID2').value = "";
		document.getElementById('brandName2').value = "";
		document.getElementById('dsbrandName2').value = "";
	}
	
	function clean(){
		goodsForm.reset();

		$('select[id=goodscategoryID2]').val("");
		$('input[id=startTime2]').val("");
		$('input[id=endTime2]').val("");
		$('input[id=startTime3]').val("");
		$('input[id=endTime3]').val("");
		$('input[id=supplierID2]').val("");
		$('input[id=supplierName2]').val("");
		$('input[id=dssupplierName2]').val("");
		$('input[id=brandName2]').val("");
		$('input[id=brandID2]').val("");
		$('input[id=dsbrandName2]').val("");	
		$('input[id=ds]').val("");
		$('input[id=warehouseName2]').val("");
		$('input[id=warehouseID2]').val("");
		
		$("tr[id=jj]").hide();
		$("#bgispecjj").val('');
		$("#bgicolorjj").val('');
		$("#bgiframesizejj").val('');
		$("tr[id=jp]").hide();
		$("#bgimaterialclassjp").val('');
		$("#bgirefractivejp").val('');
		$("#bgieyeglassmaterialtypejp").val('');
		$("#maxSphjp").val('');
		$("#minSphjp").val('');
		$("#maxCyljp").val('');
		$("#minCyljp").val('');
	    $("tr[id=yj]").hide();
		$("#bgiusetypeyj").val('');
		$("#bgistealthclassyj").val('');
		$("#maxSphyj").val('');
		$("#minSphyj").val('');
		$("#maxCylyj").val('');
		$("#minCylyj").val('');
	    $("tr[id=hc]").hide();
		$("#bgiothergoodsbigclass").val('');
		$("#bgiothergoodssmallclass").val('');
	    $("tr[id=lh]").hide();
		$("#minSphlh").val('');
		$("#maxSphlh").val('');
		$("#bgispeclh").val('');
		$("#bgicolorlh").val('');
	    $("tr[id=pj]").hide();
		$("#pjlx").val('');
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var goodscategoryID= $('input[id=goodscategoryID2]:checked').val();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;

		if(is_iPad()){
			showPopWin("selManySupplierOpen.action?categoryID_open="+goodscategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selManySupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(objValue){
		var arrayID = new Array();
		var arrayName = new Array();
		var suppliers = eval('(' + objValue + ')');
		for(var i = 0; i < suppliers.length; i++){	
			arrayID[i] = suppliers[i].supplierID;
			arrayName[i] = suppliers[i].supplierName;
		}

		document.getElementById('supplierID2').value = arrayID.join(",");
		document.getElementById('supplierName2').value = arrayName.join(",");
		document.getElementById('dssupplierName2').value = document.getElementById('supplierName2').value;

		document.getElementById('brandID2').value = "";
		document.getElementById('brandName2').value = "";
		document.getElementById('dsbrandName2').value = document.getElementById('brandName2').value;
	}

	function openBrand(){
		var goodscategoryID= $('input[id=goodscategoryID2]:checked').val();
		var supplierID=$('input[id=supplierID2]').val();

	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selManyBrandOpen.action?goodscategoryID="+goodscategoryID+"&supplierID=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selManyBrandOpen.action?goodscategoryID="+goodscategoryID+"&supplierID=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}

	function openBrandValues(objValue){
		var arrayID = new Array();
		var arrayName = new Array();
		var brands = eval('(' + objValue + ')');
		for(var i = 0; i < brands.length; i++){	
			arrayID[i] = brands[i].brandID;
			arrayName[i] = brands[i].brandName;
		}

		document.getElementById('brandID2').value = arrayID.join(",");
		document.getElementById('brandName2').value = arrayName.join(",");
		document.getElementById('dsbrandName2').value = document.getElementById('brandName2').value;
	}

	function openWarehouse(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selManyWarehouseOpen.action?isclosed=0&companyid="+$("#companysid").val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selManyWarehouseOpen.action?isclosed=0&companyid="+$("#companysid").val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}	
		document.getElementById('popupTitle').innerHTML="【仓位查询】";
	}

	function openWarehouseValues(objValue){
		var arrayID = new Array();
		var arrayName = new Array();
		var warehouses = eval('(' + objValue + ')');
		for(var i = 0; i < warehouses.length; i++){	
			arrayID[i] = warehouses[i].warehouseID;
			arrayName[i] = warehouses[i].warehouseName;
		}
		
		document.getElementById('warehouseID2').value = arrayID.join(",");
		document.getElementById('warehouseName2').value = arrayName.join(",");
		document.getElementById('ds').value = document.getElementById('warehouseName2').value;
	}

    function loadDepartmentids(cid) {  
		$("#warehouseID2").val('');
   		$("#warehouseName2").val('');
   		$("#ds").val('');
   		$("#dids").val('');
		$("#dnames").val('');

		$.ajax({           
	   	 	type: "POST",          
   	   	    url: "getAjaxWarehouseForCompanyID.action",          
   	   	    async: true, 
   	   	    data: "companysid="+cid+"&type=1",     
   	   	    success: function(msg){
   	   	    	var item = msg.split("/");
                <c:if test="${person.departmenttype!=1}">
                	$("#warehouseID2").val(item[0]);
   	   	    		$("#warehouseName2").val(item[1]);
   	   	    		$("#ds").val(item[1]);
				    $("#dids").val(item[0]);
				    $("#dnames").val(item[1]);
				</c:if>  
   	   	    }
		});
    }
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="dids" name="dids" value="">
<input type="hidden" id="dnames" name="dnames" value="">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>决策分析类报表</TD>
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：销售库存汇总表 </TD>
            <TD>&nbsp;</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
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
                        <TR goods=goods>
                           <TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none" colspan="5">
			               	   <input type="radio" name="goodscategoryID2" onclick="showterm();" id ="goodscategoryID2" value="" checked/>全部&nbsp;&nbsp;
	      	                   <s:iterator value="goodsCategorys">
	      	                   <input type="radio" name="goodscategoryID2" onclick="showterm();" id ="goodscategoryID2" value="${bgcid}"/>${bgcgoodscategoryname}&nbsp;&nbsp;
	      	                   </s:iterator>
	      	               </TD>
                        </TR>
                        <TR shopshow="shopshow">
			               <TD width="12%" height="26" class="table_body" >库存日期</TD>
			               <TD class="table_none">
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime2"/> 
                                    <jsp:param name="toDate" value="endTime2"/>             
                               </jsp:include>
			               </TD>

			               <TD width="12%" height="26" class="table_body" >销售日期</TD>
			               <TD class="table_none" colspan="3" >
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime3"/> 
                                    <jsp:param name="toDate" value="endTime3"/>             
                               </jsp:include>
			               </TD>
			               			               
			             </TR>			               
			             <TR>
						   <TD width="10%" height="26" class="table_body">所属公司</TD>
			               <TD height="26" class="table_none">
			                <c:if test="${person.personcompanytype eq '2'}">
			                	${person.personcompanyname }
	                        	<input type="hidden" id="companysid" name="companysid" value="${person.personcompanyid }">
	                        </c:if>
	                        
	                        <c:if test="${person.personcompanytype ne '2'}">
	                        	<c:if test="${person.departmenttype!=1}">
							   		<select clean="clean" id="companysid" name="companysid" onchange="loadDepartmentids(this.options[this.options.selectedIndex].value)" >
		                              <option value="">----请选择----</option>
		                              <s:iterator value="companyNamePos">
		                              <option value="${fcnId}" ctype="${fcnmasterorvice }" ${companysid == fcnId ? 'selected="selected"':''}>${fcnName}</option>
		                              </s:iterator>
		                            </select>
								</c:if>  
							    <c:if test="${person.departmenttype==1}">
		                            ${person.personcompanyname }
		                        	<input type="hidden" id="companysid" name="companysid" value="${person.personcompanyid }">
	                        	</c:if>
	                        </c:if>
                           </TD>
                           
                          <TD width="12%" height="26" class="table_body">仓位名称</TD>
			               <TD class="table_none" width="27%" colspan="3">

			               <li class="horizontal_onlyRight">
						   		<input class="text_input300" id="warehouseName2" type="hidden"/>
						   		<textarea class="text_input200" id="ds"  name="d" value=""  style='height:50px;' readonly="readonly" ></textarea>
						   		
						   		<input type="hidden" id="warehouseID2" value="" />
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onClick="openWarehouse();"></li>
						  </TD>
						  
                        </TR>
                     
                        <tr goods=goods>
                           <TD height="26" class="table_body">制造商</TD>
			               <TD  class="table_none">
				   
						   <li class="horizontal_onlyRight">
						   		<input type="hidden" class="text_input160" id="supplierName2" name="supplierName2" value="" readonly="readonly">
						   		<textarea class="text_input200" id="dssupplierName2"  name="dsupplierName2" value=""  style='height:50px;' readonly="readonly" ></textarea>
						   		
						   		<input type="hidden" id="supplierID2" name="supplierID2" value=""/>
						   </li>
						   
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();"></li>
					  		
			               </TD>
			               <TD height="26" class="table_body">商品品种</TD>
			               	<TD class="table_none" colspan="3">
	                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="hidden"  id="brandName2" name="brandName2" value="" readonly="readonly">
						   		<input type="hidden" id="brandID2" name="brandID2" value=""/>
						   		
						   		<textarea class="text_input200" id="dsbrandName2"  name="dbrandName2" value=""  style='height:50px;' readonly="readonly" ></textarea>
							   </li>
							   <li class="horizontal_onlyRight">
							  	<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openBrand();">
							   </li>
			               </TD>

						</tr>

                        <tr id="jj" goodsAttr=goodsAttr>
                           <TD height="26" class="table_none">型号</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="bgispecjj2" name="bgispecjj2" value="${requestScope.bgispecjj}" maxlength="30">
			               </TD>
						   <TD height="26" class="table_none" >色号</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="bgicolorjj2" name="bgicolorjj2" value="${bgicolorjj}" maxlength="10">
			               </TD>
			               <TD height="26" class="table_none">尺寸</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="bgiframesizejj2" name="bgiframesizejj2" value="${requestScope.bgiframesizejj}" maxlength="10">
			               </TD>
                        </tr>
                        
                        <tr id="jj" nolh=nolh goodsAttr=goodsAttr>
                        	<TD height="26" class="table_none">工艺类型</TD>
			               <TD class="table_none">
                            <select id="bgitechnologytypeid2" name="bgitechnologytypeid2">
                            	<option value="">----请选择----</option>
                            	<s:iterator value="teachnologyList">
                            		<option ${bgitechnologytypeid eq fttid ? 'selected="selected"' : '' } value="${fttid }">${fttname }</option>
                            	</s:iterator>
                            </select>
			               </TD>
						   <TD height="26" class="table_none" >镜架材质</TD>
			               <TD class="table_none">
                            <select id="bgiframematerialtype2" name="bgiframematerialtype2" >
                            	<option value="">----请选择----</option>
                            	<s:iterator value="frameMaterialList">
                            		<option ${bgiframematerialtype eq bfmid ? 'selected="selected"' : '' } value="${bfmid }">${bfmname }</option>
                            	</s:iterator>
                            </select>
			               </TD>
			               <TD height="26" class="table_none">&nbsp;</TD>
			               <TD class="table_none">
                            &nbsp;
			               </TD>
                        </tr>
                        <tr id="jp" goodsAttr=goodsAttr>
                        	<TD height="26" class="table_none">镜片材料分类</TD>
			                <TD class="table_none">
                            	<select id="bgieyeglassmaterialtypejp2" name="bgieyeglassmaterialtypejp2"}>
      		                 		<option value="">----请选择----</option>
				               		<option value="1" ${bgieyeglassmaterialtypejp == '1' ? 'selected="selected"' : '' }>树脂</option>
				               		<option value="2" ${bgieyeglassmaterialtypejp == '2' ? 'selected="selected"' : '' }>玻璃</option>
				               		<option value="3" ${bgieyeglassmaterialtypejp == '3' ? 'selected="selected"' : '' }>PC</option>
      	                   		</select>
			                </TD>
						    <TD height="26" class="table_none">镜片折射率</TD>
			                <TD class="table_none">
                            	<select id="bgirefractivejp2" name="bgirefractivejp2"}>
      		                 	<option value="">----请选择----</option>
			               		 <s:iterator value="refractiveSetPos">
				                   <option value="${brfname}" ${bgirefractivejp == brfname ? 'selected="selected"' : '' }>${brfname}</option>
		     	                 </s:iterator>
      	                   		</select>
			                </TD>
			                <TD height="26" class="table_none">镜片光度分类</TD>
			                <TD class="table_none">
                            	<select id="bgiismutiluminosityjp2" name="bgiismutiluminosityjp2"}>
      		                 		<option value="">----请选择----</option>
				               		<option value="0" ${bgiismutiluminosityjp == '0' ? 'selected="selected"' : '' }>单光片</option>
				               		<option value="M" ${bgiismutiluminosityjp == 'M' ? 'selected="selected"' : '' }>多光片</option>
				               		<option value="J" ${bgiismutiluminosityjp == 'J' ? 'selected="selected"' : '' }>渐进片</option>
				               		<option value="Q" ${bgiismutiluminosityjp == 'Q' ? 'selected="selected"' : '' }>其他</option>
      	                   		</select>
			               </TD>
                        </tr>
                        <tr id="jp" goodsAttr=goodsAttr>
                        	<TD height="26" class="table_none">镜片球镜范围</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text" onchange="checkNumberType(this);"  id="minSphjp2" name="minSphjp2" value="${requestScope.minSphjp}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写镜片柱镜度数！'}]">
                            	至
                            <input class="text_input80" type="text" onchange="checkNumberType(this);" id="maxSphjp2" name="maxSphjp2" value="${requestScope.maxSphjp}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写镜片柱镜度数！'}]">
			               </TD>
						   <TD height="26" class="table_none" >镜片柱镜范围</TD>
			               <TD class="table_none" colspan="3">
                            <input class="text_input80" type="text" onchange="checkNumberType(this);" id="minCyljp2" name="minCyljp2" value="${requestScope.minCyljp}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写镜片柱镜度数！'}]">
                            	至
                            <input class="text_input80" type="text" onchange="checkNumberType(this);" id="maxCyljp2" name="maxCyljp2" value="${requestScope.maxCyljp}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写镜片柱镜度数！'}]">
			               </TD>
                        </tr>
                        
                        <tr id="yj" goodsAttr=goodsAttr>
                        	<TD height="26" class="table_none">隐形使用类型</TD>
			                <TD class="table_none">
                            	<select id="bgiusetypeyj2" name="bgiusetypeyj2"}>
      		                 		<option value="">----请选择----</option>
				               		<option value="1" ${bgiusetypeyj == '1' ? 'selected="selected"' : '' }>常带型</option>
				               		<option value="2" ${bgiusetypeyj == '2' ? 'selected="selected"' : '' }>抛弃型</option>
				               		<option value="3" ${bgiusetypeyj == '3' ? 'selected="selected"' : '' }>塑形镜</option>
      	                   		</select>
			                </TD>
						    <TD height="26" class="table_none">抛弃型分类</TD>
			                <TD class="table_none" colspan="3">
                            	<select id="bgistealthclassyj2" name="bgistealthclassyj2"}>
      		                 		<option value="">----请选择----</option>
				               		<option value="1" ${bgistealthclassyj == '1' ? 'selected="selected"' : '' }>日抛</option>
				               		<option value="2" ${bgistealthclassyj == '2' ? 'selected="selected"' : '' }>周抛</option>
				               		<option value="9" ${bgistealthclassyj == '9' ? 'selected="selected"' : '' }>双周抛</option>
				               		<option value="3" ${bgistealthclassyj == '3' ? 'selected="selected"' : '' }>月抛</option>
				               		<option value="4" ${bgistealthclassyj == '4' ? 'selected="selected"' : '' }>季抛</option>
				               		<option value="5" ${bgistealthclassyj == '5' ? 'selected="selected"' : '' }>半年抛</option>
				               		<option value="6" ${bgistealthclassyj == '6' ? 'selected="selected"' : '' }>年抛</option>
				               		<option value="7" ${bgistealthclassyj == '7' ? 'selected="selected"' : '' }>RGP</option>
				               		<option value="8" ${bgistealthclassyj == '8' ? 'selected="selected"' : '' }>塑形镜</option>
      	                   		</select>
			                </TD>
                        </tr>
                        <tr id="yj" goodsAttr=goodsAttr>
                           <TD height="26" class="table_none">隐形球镜范围</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text"  id="minSphyj2" name="minSphyj2" value="${requestScope.minSphyj}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写隐形球镜度数！'}]">
                            	至
                            <input class="text_input80" type="text"  id="maxSphyj2" name="maxSphyj2" value="${requestScope.maxSphyj}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写隐形球镜度数！'}]">
			               </TD>
						   <TD height="26" class="table_none" >隐形柱镜范围</TD>
			               <TD class="table_none" colspan="3">
                            <input class="text_input80" type="text" onchange="checkNumberType(this);" id="minCylyj2" name="minCylyj2" value="${requestScope.minCylyj}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写隐形柱镜度数！'}]">
                            	至
                            <input class="text_input80" type="text" onchange="checkNumberType(this);" id="maxCylyj2" name="maxCylyj2" value="${requestScope.maxCylyj}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写隐形柱镜度数！'}]">
			               </TD>
                        </tr>
                        <tr id="pj" goodsAttr=goodsAttr>
                           <TD height="26" class="table_none">配件型</TD>
			               <TD class="table_none" colspan="5">
                             <select id="pjlx2" name="pjlx2">
      		                   <option value="">----请选择----</option>
				               <option ${pjlx eq "1" ? 'selected="selected"' : '' } value="1" >框镜</option>
				               <option ${pjlx eq "2" ? 'selected="selected"' : '' } value="2" >隐形</option>
      	                     </select>
			               </TD>
                        </tr>
                        <tr id="hc" goodsAttr=goodsAttr>
                           <TD  height="26" class="table_none">其它商品大类</TD>
			               <TD class="table_none" colspan="5">
                             <select id="bgiothergoodsbigclass2" name="bgiothergoodsbigclass2">
      		                   <option value="">----请选择----</option>
				               <option ${bgiothergoodsbigclass eq "Q" ? 'selected="selected"' : '' } value="Q" >其它材料</option>
				               <option ${bgiothergoodsbigclass eq "D" ? 'selected="selected"' : '' } value="D" >低值易耗品</option>
      	                     </select>
			               </TD>
                        </tr>
                        <tr id="lh" goodsAttr=goodsAttr>
                        	<TD height="26" class="table_none">老花球镜范围</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text"  id="minSphlh2" name="minSphlh2" value="${requestScope.minSphlh}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写老花镜度数！'}]">
                            	至
                            <input class="text_input80" type="text"  id="maxSphlh2" name="maxSphlh2" value="${requestScope.maxSphlh}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写老花镜度数！'}]">
			               </TD>
			               <TD height="26" class="table_none">型号</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="bgispeclh2" name="bgispeclh2" value="${requestScope.bgispeclh}" maxlength="30">
			               </TD>
						   <TD height="26" class="table_none" >色号</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="bgicolorlh2" name="bgicolorlh2" value="${requestScope.bgicolorlh}" maxlength="10">
			               </TD>
                        </tr>
                        <tr>
						   <TD class="table_body"  width="12%">是否显示查询条件</TD>
			               <TD class="table_none"  width="27%">
                               <input type="radio" id="isShow2" name="isShow2" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow2" name="isShow2" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
			               </TD>
			               <TD class="table_body" height="26" width="12%">显示公司名称</TD>
			               <TD class="table_none" colspan="3">
                               <input type="radio" id="showCompanyName2" name="showCompanyName2" value="1" checked="checked"/>是
                               <input type="radio" id="showCompanyName2" name="showCompanyName2" value="2"/>否
			               </TD>
                        </tr>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >
								<img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >	
							</td>
						</tr>
					</table>
		    <c:if test="${systemParameterPo.fspreporthelpshow eq '1'}">		
					<br/><br/>
					<div class="reportHelp">												
                       1.查看报表时，如果需要重新汇总数据，可以进入【定时任务维护】模块，通过【日销售商品明细】和【商品库存周转率】这两个定时任务重新汇总数据。<br/>
					</div>										
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
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>

