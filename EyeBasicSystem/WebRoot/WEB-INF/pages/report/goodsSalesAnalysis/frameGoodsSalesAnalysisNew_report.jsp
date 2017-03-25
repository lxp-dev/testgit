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
	    $('#searchtypeGoods').attr("checked",true);
	    $("tr[id=category]").show();
	    
	    var category = '1';
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
		if($("input[name=searchtype]:checked").val() == '1'){
			$("[id=showtype]").show();
		}else{
			$("[id=showtype]").hide();
			$("select[id=xory]").val("x");
		}
		
		if('${person.personcompanytype}' == '2'){
        	loadDepartmentids('${person.personcompanyid}');
        }
	});

	function search(){
		createForm();
		var arrDetails=new Array(); 
		 arrDetails[1]="商品类别";
		 arrDetails[2]="制造商";
	     arrDetails[3]="产品品种";
	     arrDetails[4]="产品名称";
		 arrDetails[5]="营业员";
		 arrDetails[6]="收银员";
		 arrDetails[7]="配镜单";
		 arrDetails[8]="销售门店 ";
		var formAction = '';
		if(checkForm(goodsForm)){       		
			var BeginDate = document.all.startTime2.value;
			var End = document.all.endTime2.value;
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
			
			if(parseFloat($("#bgnretailamount2").val()) > parseFloat($("#endretailamount2").val())){
				alert("销售区间上限不得大于下限！");
				$("#bgnretailamount2").focus();
				return;
			}
			
	        var searchtype = '4';       
			var GoodsName = $('input[id=goodsName2]').val();		
			var GoodsCode=$("input[id=goodsCode2]").val();
			var supplierID = $("input[id=supplierID2]").val();
			var goodscategoryID = $("input[id=goodscategoryID2]:checked").val();
			var ShopCode=$("input[id=departmentID]").val();
			if(ShopCode == ''){
				ShopCode = $("#dids").val();
			}
			
			var brandID=$("input[id=brandID2]").val();
			var departmentNames = EncodeUtf8($("#ds").val());
			if(departmentNames == ''){
				departmentNames = EncodeUtf8($("#dnames").val());
			}
			
			var querySystematics = EncodeUtf8(arrDetails[searchtype]);
			var supplierName=EncodeUtf8($("input[id=supplierName2]").val());
			var brandName=EncodeUtf8($("input[id=brandName2]").val());
			$('input[name=logincompanyid]').get(0).value = '${person.personcompanyid}';
			
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
	    	var xory = $("#xory").val();
	    	
	    	var shopcol = $("#shopcol2:checked").val();
	    	var salesnumcol = $("#salesnumcol2:checked").val();
	    	var salesmoneycol = $("#salesmoneycol2:checked").val();
	    	var moneyratecol = $("#moneyratecol2:checked").val();
	    	var costmoneycol = $("#costmoneycol2:checked").val();
	    	var costmoneyratecol = $("#costmoneyratecol2:checked").val();
	    	var zmoneycol = $("#zmoneycol2:checked").val();
	    	var zmoneyratecol = $("#zmoneyratecol2:checked").val();
	    	var salesnumtype = $("#salesnumtype2").val();
	    	var bgnretailamount = $("#bgnretailamount2").val();
	    	var endretailamount = $("#endretailamount2").val();
	    	
			$("input[name=bgnDate]").val(BeginDate);
		    $("input[name=endDate]").val(End);
		    $("input[name=goodsCategoryID]").val(goodscategoryID);
		    $("input[name=supplierID]").val(supplierID);
		    $("input[name=bandID]").val(brandID);
		    $("input[name=goodsName]").val(GoodsName);
		    $("input[name=goodsID]").val(GoodsCode);
		    $("input[name=shopCode]").val(ShopCode);
		    $("input[name=departmentNames]").val(departmentNames);
		    $("input[name=querySystematics]").val(querySystematics);
		    $("input[name=supplierName]").val(supplierName);
		    $("input[name=brandName]").val(brandName);
		    
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
		    $("input[name=bgiothergoodssmallclass]").val(bgiothergoodssmallclass);
		    $("input[name=minSphlh]").val(minSphlh);
		    $("input[name=maxSphlh]").val(maxSphlh);
		    $("input[name=pjlx]").val(pjlx);
		    
		    $("input[name=shopcol]").val(shopcol);
		    $("input[name=salesnumcol]").val(salesnumcol);
		    $("input[name=salesmoneycol]").val(salesmoneycol);
		    $("input[name=moneyratecol]").val(moneyratecol);
		    $("input[name=costmoneycol]").val(costmoneycol);
		    $("input[name=costmoneyratecol]").val(costmoneyratecol);
		    $("input[name=zmoneycol]").val(zmoneycol);
		    $("input[name=zmoneyratecol]").val(zmoneyratecol);
		    $("input[name=salesnumtype]").val(salesnumtype);
		    $("input[name=bgnretailamount]").val(bgnretailamount);
		    $("input[name=endretailamount]").val(endretailamount);
		    
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
			var reportName = '';
			if(searchtype == '4'){ // 产品名称
				if(goodscategoryID == '3'){
					formAction = 'goods';
					reportName = 'sales_frameGoodsSalesAnalysisNew_goods.cpt';
					DataURL = "report.action?reportlet="+reportName+"&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&goodsCategoryID="+goodscategoryID
							    +"&supplierID="+supplierID+"&bandID="+brandID+"&goodsName="+GoodsName+"&goodsID="+GoodsCode+"&shopCode="+ShopCode+"&departmentNames="+departmentNames
								+"&querySystematics="+querySystematics+'&supplierName='+supplierName+'&brandName='+brandName+'&isShow='+isShow
								+"&bgispecjj="+bgispecjj+"&bgicolorjj="+bgicolorjj+"&bgiframesizejj="+bgiframesizejj
							    +"&bgieyeglassmaterialtypejp="+bgieyeglassmaterialtypejp+"&bgirefractivejp="+bgirefractivejp+"&bgiismutiluminosityjp="+bgiismutiluminosityjp
		                        +"&minSphjp="+minSphjp+"&maxSphjp="+maxSphjp+"&minCyljp="+minCyljp
		                        +"&maxCyljp="+maxCyljp+"&bgiusetypeyj="+bgiusetypeyj+"&bgistealthclassyj="+bgistealthclassyj
		                        +"&minSphyj="+minSphyj+"&maxSphyj="+maxSphyj+"&minCylyj="+minCylyj
		                        +"&maxCylyj="+maxCylyj+"&bgiothergoodsbigclass="+bgiothergoodsbigclass+"&bgiothergoodssmallclass="+bgiothergoodssmallclass
		                        +"&minSphlh="+minSphlh+"&maxSphlh="+maxSphlh+"&pjlx="+pjlx
		                        +"&shopcol="+shopcol+"&salesnumcol="+salesnumcol+"&showCompanyName="+showCompanyName
	                      		+"&salesmoneycol="+salesmoneycol+"&moneyratecol="+moneyratecol+"&costmoneycol="+costmoneycol
	                      		+"&zmoneycol="+zmoneycol+"&zmoneyratecol="+zmoneyratecol+"&costmoneyratecol="+costmoneyratecol
	                      		+"&salesnumtype="+salesnumtype+"&bgnretailamount="+bgnretailamount+"&endretailamount="+endretailamount;
                }else{
                	formAction = 'brand';
					reportName = 'sales_frameGoodsSalesAnalysisNew_brand.cpt';
					DataURL = "report.action?reportlet="+reportName+"&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&goodsCategoryID="+goodscategoryID
							    +"&supplierID="+supplierID+"&bandID="+brandID+"&goodsName="+GoodsName+"&goodsID="+GoodsCode+"&shopCode="+ShopCode+"&departmentNames="+departmentNames
								+"&querySystematics="+querySystematics+'&supplierName='+supplierName+'&brandName='+brandName+'&isShow='+isShow
								+"&bgispecjj="+bgispecjj+"&bgicolorjj="+bgicolorjj+"&bgiframesizejj="+bgiframesizejj
							    +"&bgieyeglassmaterialtypejp="+bgieyeglassmaterialtypejp+"&bgirefractivejp="+bgirefractivejp+"&bgiismutiluminosityjp="+bgiismutiluminosityjp
		                        +"&minSphjp="+minSphjp+"&maxSphjp="+maxSphjp+"&minCyljp="+minCyljp
		                        +"&maxCyljp="+maxCyljp+"&bgiusetypeyj="+bgiusetypeyj+"&bgistealthclassyj="+bgistealthclassyj
		                        +"&minSphyj="+minSphyj+"&maxSphyj="+maxSphyj+"&minCylyj="+minCylyj
		                        +"&maxCylyj="+maxCylyj+"&bgiothergoodsbigclass="+bgiothergoodsbigclass+"&bgiothergoodssmallclass="+bgiothergoodssmallclass
		                        +"&minSphlh="+minSphlh+"&maxSphlh="+maxSphlh+"&pjlx="+pjlx
		                        +"&shopcol="+shopcol+"&salesnumcol="+salesnumcol+"&showCompanyName="+showCompanyName
	                      		+"&salesmoneycol="+salesmoneycol+"&moneyratecol="+moneyratecol+"&costmoneycol="+costmoneycol
	                      		+"&zmoneycol="+zmoneycol+"&zmoneyratecol="+zmoneyratecol+"&costmoneyratecol="+costmoneyratecol
	                      		+"&salesnumtype="+salesnumtype+"&bgnretailamount="+bgnretailamount+"&endretailamount="+endretailamount;
                }
			}

			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;		
			if(is_iPad()){
				showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				DataURL = "report.action?reportlet=" + reportName + "&__bypagesize__=false";
				queryReport(DataURL,formAction);
			}
			document.getElementById('popupTitle').innerHTML="【框镜商品销售分析表 】";
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

	    var goodsName = document.createElement("input");	     
	    goodsName.type = "hidden";
	    goodsName.id = "goodsName";
	    goodsName.name = "goodsName";
	    goodsName.value = '';
	    rptFrm.appendChild(goodsName);

	    var goodsID = document.createElement("input");	     
	    goodsID.type = "hidden";
	    goodsID.id = "goodsID";
	    goodsID.name = "goodsID";
	    goodsID.value = '';	  
	    rptFrm.appendChild(goodsID); 
	    
	    var logincompanyid = document.createElement("input");	     
	    logincompanyid.type = "hidden";
	    logincompanyid.name = "logincompanyid";
	    logincompanyid.value = '';	  
	    rptFrm.appendChild(logincompanyid);
	    
	    var shopCode = document.createElement("input");	     
	    shopCode.type = "hidden";
	    shopCode.name = "shopCode";
	    shopCode.value = '';	  
	    rptFrm.appendChild(shopCode);    

	    var departmentNames = document.createElement("input");	     
	    departmentNames.type = "hidden";
	    departmentNames.name = "departmentNames";
	    departmentNames.value = '';	  
	    rptFrm.appendChild(departmentNames);  

	    var querySystematics = document.createElement("input");	     
	    querySystematics.type = "hidden";
	    querySystematics.name = "querySystematics";
	    querySystematics.value = '';	  
	    rptFrm.appendChild(querySystematics); 

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
	    
	    var bgiothergoodssmallclass = document.createElement("input");	     
	    bgiothergoodssmallclass.type = "hidden";
	    bgiothergoodssmallclass.name = "bgiothergoodssmallclass";
	    bgiothergoodssmallclass.value = '';	  
	    rptFrm.appendChild(bgiothergoodssmallclass);
	    
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
	    
	    var shopcol = document.createElement("input");	     
	    shopcol.type = "hidden";
	    shopcol.name = "shopcol";
	    shopcol.value = '';	  
	    rptFrm.appendChild(shopcol);
	    
	    var salesnumcol = document.createElement("input");	     
	    salesnumcol.type = "hidden";
	    salesnumcol.name = "salesnumcol";
	    salesnumcol.value = '';	  
	    rptFrm.appendChild(salesnumcol);
	    
	    var salesmoneycol = document.createElement("input");	     
	    salesmoneycol.type = "hidden";
	    salesmoneycol.name = "salesmoneycol";
	    salesmoneycol.value = '';	  
	    rptFrm.appendChild(salesmoneycol);
	    
	    var moneyratecol = document.createElement("input");	     
	    moneyratecol.type = "hidden";
	    moneyratecol.name = "moneyratecol";
	    moneyratecol.value = '';	  
	    rptFrm.appendChild(moneyratecol);
	    
	    var costmoneycol = document.createElement("input");	     
	    costmoneycol.type = "hidden";
	    costmoneycol.name = "costmoneycol";
	    costmoneycol.value = '';	  
	    rptFrm.appendChild(costmoneycol);
	    
	    var costmoneyratecol = document.createElement("input");	     
	    costmoneyratecol.type = "hidden";
	    costmoneyratecol.name = "costmoneyratecol";
	    costmoneyratecol.value = '';	  
	    rptFrm.appendChild(costmoneyratecol);
	    
	    var zmoneycol = document.createElement("input");	     
	    zmoneycol.type = "hidden";
	    zmoneycol.name = "zmoneycol";
	    zmoneycol.value = '';	  
	    rptFrm.appendChild(zmoneycol);
	    
	    var zmoneyratecol = document.createElement("input");	     
	    zmoneyratecol.type = "hidden";
	    zmoneyratecol.name = "zmoneyratecol";
	    zmoneyratecol.value = '';	  
	    rptFrm.appendChild(zmoneyratecol);
	    
	    var salesnumtype = document.createElement("input");	     
	    salesnumtype.type = "hidden";
	    salesnumtype.name = "salesnumtype";
	    salesnumtype.value = '';	  
	    rptFrm.appendChild(salesnumtype);
	    
	    var bgnretailamount = document.createElement("input");	     
	    bgnretailamount.type = "hidden";
	    bgnretailamount.name = "bgnretailamount";
	    bgnretailamount.value = '';	  
	    rptFrm.appendChild(bgnretailamount);
	    
	    var endretailamount = document.createElement("input");	     
	    endretailamount.type = "hidden";
	    endretailamount.name = "endretailamount";
	    endretailamount.value = '';
	    rptFrm.appendChild(endretailamount);
	    
	    var showCompanyName = document.createElement("input");	     
	    showCompanyName.type = "hidden";
	    showCompanyName.name = "showCompanyName";
	    showCompanyName.value = '';
	    rptFrm.appendChild(showCompanyName);
	    
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
	}

	function openBrand(){
		var searchtype = $("input[name=searchtype]:checked").val();
		var goodscategoryID= $('input[id=goodscategoryID2]:checked').val();
		var supplierID=$('input[id=supplierID2]').val();
		
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		var searchtype = $("input[name=searchtype]:checked").val();
		$('input[id=brandID2]').val(json.brandID);
		$('input[id=brandName2]').val(json.brandName);
	}
	
	function clean(){
		goodsForm.reset();
		$('input[id=startTime2]').val("");
		$('input[id=endTime2]').val("");
		$('input[id=goodsName2]').val("");
		$('input[id=supplierID2]').val("");
		$('input[id=supplierName2]').val("");
		$('input[id=bdpdepartmentname2]').val("");
		$('input[id=departmentID2]').val("");
		$('input[name=searchtype][value=1]').attr("checked","checked");
		$('select[id=goodscategoryID2]').val("");
		$('input[id=brandName2]').val("");
		$('input[id=brandID2]').val("");
		$('input[id=goodsCode2]').val("");
		$('input[id=bgnretailamount2]').val("");
		$('input[id=endretailamount2]').val("");
		$('select[id=salesnumtype2]').val("1");
		
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
			
		today('startTime2','endTime2');
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var searchtype = $("input[name=searchtype]:checked").val();
		var goodscategoryID= $('input[id=goodscategoryID2]:checked').val();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		/*if(goodscategoryID==''){
			alert("请选择商品类别！");
			return;
		}*/
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
		var searchtype = $("input[name=searchtype]:checked").val();
		$('input[id=supplierID2]').val(json.id);
		$('input[id=supplierName2]').val(json.value);
		$('input[id=brandID2]').val('');
		$('input[id=brandName2]').val('');
	}
	
	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0&companyid="+$("#companysid").val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0&companyid="+$("#companysid").val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}	
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}

	/**
	 * 部门开窗赋值实现方法
	 */
	function openDepartmentValues(objValue){
		var arrayID = new Array();
		var arrayName = new Array();
		var departments = eval('(' + objValue + ')');
		for(var i = 0; i < departments.length; i++){	
			arrayID[i] = departments[i].bdpdepartmentid;
			arrayName[i] = departments[i].bdpdepartmentname;
		}
		
		document.getElementById('departmentID').value = arrayID.join(",");
		document.getElementById('bdpdepartmentname').value = arrayName.join(",");
		document.getElementById('ds').value = document.getElementById('bdpdepartmentname').value;
	}

	/**
	 * 获取select标签Text
	 */
	function getSelectText(selectId,defaultValue){
		if(!selectId) {
			alert("未找到select标签");
		} else {
			var selectObj = document.getElementById(selectId);
			var userSelectedIndex = selectObj.selectedIndex;
			var selectText = selectObj.options[userSelectedIndex].text
			if(userSelectedIndex == 0) {
					selectText = "";
			}
			return selectText;
		}
	}	
	
	$(document).ready(function() { 
		today('startTime2','endTime2');
    	$('#personTab').show();
	});
	
	function isShowShowType(obj){
		if($(obj).val() == '1'){
			$("[id=showtype]").show();
		}else{
			$("[id=showtype]").hide();
			$("select[id=xory]").val("x");
		}
	}
	
	function loadDepartmentids(cid) {  
		if(cid == ''){
			$("#departmentID").val('');
	   		$("#bdpdepartmentname").val('');
	   		$("#ds").val('');
	   		$("#dids").val('');
			$("#dnames").val('');
		}else{
			$.ajax({           
		   	 	type: "POST",          
	   	   	    url: "getAjaxDepartmentForCompanyID.action",          
	   	   	    async: true, 
	   	   	    data: "companysid="+cid+"&type=1",     
	   	   	    success: function(msg){
	   	   	    	var item = msg.split("/");
	                <c:if test="${person.departmenttype!=1}">
	                	$("#departmentID").val(item[0]);
	   	   	    		$("#bdpdepartmentname").val(item[1]);
	   	   	    		$("#ds").val(item[1]);
					$("#dids").val(item[0]);
					$("#dnames").val(item[1]);
					</c:if>  
	   	   	    }
			});
		}
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
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：框镜销售分析表 </TD>
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
                      	<TR>
						   <TD width="10%" height="26" class="table_body">所属公司</TD>
			               <TD height="26" class="table_none" colspan="5">
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
                        </TR>
					  	<TR>
					  	   <TD width="12%" height="26" class="table_body">销售门店</TD>
			               <TD class="table_none" width="27%">
			               
			               <input type="hidden" name="nnd" id="nnd" value="${person.departmenttype}"/>
		               <c:if test="${person.departmenttype!=1}">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input300" id="bdpdepartmentname" type="hidden"/>
						   		<textarea class="text_input200" id="ds"  name="d" value=""  style='height:50px;' readonly="readonly" >${personInfoPo.bdpdepartmentname}</textarea>
						   		
						   		<input type="hidden" id="departmentID" value="${personInfoPo.departmentID }" />
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" name=ctl00$PageBody$Button1 onClick="openDepartment();"></li>
						</c:if>  
						   <c:if test="${person.departmenttype==1}">
                            ${person.bdpdepartmentname}<input type="hidden" id="departmentID" value="${person.departmentID}" name="departmentID"/>
                            <input type="hidden" id="ds" value='${person.bdpdepartmentname}'/>
						   		<input id="bdpdepartmentname" type="hidden" value="${person.bdpdepartmentname}"  />
      	                   </c:if>
						  </TD>
			               <TD width="12%" height="26" class="table_body">查询日期</TD>
			               <TD class="table_none" colspan="3">
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime2"/> 
                                    <jsp:param name="toDate" value="endTime2"/>             
                               </jsp:include>
			               </TD>
			            </TR>
                        <TR>
                           <TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none" colspan="5">
	      	                   <s:iterator value="goodsCategorys">
	      	                   <c:if test="${bgcid eq '1' || bgcid eq '3'}">
	      	                   <input type="radio" ${bgcid eq '1' ? 'checked=checked' : ''} name="goodscategoryID2" onclick="showterm();" id ="goodscategoryID2" value="${bgcid}"/>${bgcgoodscategoryname}&nbsp;&nbsp;
	      	                   </c:if>
	      	                   </s:iterator>
	      	               </TD>
                        </TR>
                        <TR>
                           <TD class="table_body">是否显示门店明细</TD>
			               <TD class="table_none">
                               <input type="radio" id="shopcol2" name="shopcol2"  value="1"/>是
                               <input type="radio" id="shopcol2" name="shopcol2" checked value=""/>否
			               </TD>
						   <TD height="26" class="table_body">查看样式</TD>
			               <TD class="table_none" colspan="3">
			                 <a style="display: none;" id="showtype">
			               	 <select id="xory" name="xory">
      		                   <option value="x">横向</option>
				               <option value="y">纵向</option>
      	                     </select>
      	                     </a>&nbsp;
			               </TD>
                        </TR>
                        <tr>
                           <TD height="26" class="table_body">制造商</TD>
			               <TD  class="table_none">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="supplierName2" name="supplierName2" value="" readonly="readonly">
						   		<input type="hidden" id="supplierID2" name="supplierID2" value=""/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();"></li>
			               </TD>
			               <TD height="26" class="table_body">商品品种</TD>
			               	<TD class="table_none">
	                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName2" name="brandName2" value="" readonly="readonly">
						   		<input type="hidden" id="brandID2" name="brandID2" value=""/>
							   </li>
							   <li class="horizontal_onlyRight">
							  	<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openBrand();">
							   </li>
			               </TD>
                           <TD class="table_body">商品代码</TD>
			               <TD class="table_none"><input sid="4" type="text" class="text_input160" maxlength="20" id="goodsCode2" name="goodsCode2"/></TD>
						</tr>
						<tr>
						   <TD height="26" class="table_body">商品名称</TD>
			               <TD class="table_none"><input type="text" class="text_input160" maxlength="20" id="goodsName2" name="goodsName2"/></TD>
			               <TD height="26" class="table_body">销售区间</TD>
			               <TD class="table_none" colspan="3">
								<input class="text_input60" type="text" id="bgnretailamount2" name="bgnretailamount2" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写销售金额！'}]"/> 至 
								<input class="text_input60" type="text" id="endretailamount2" name="endretailamount2" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写销售金额！'}]"/>
			               </TD>
                        </tr>
                        <tr id="jj">
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
                        <tr id="jj" nolh=nolh>
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
                        <tr id="jp">
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
                        <tr id="jp">
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
                        
                        <tr id="yj">
                        	<TD height="26" class="table_none">隐形使用类型</TD>
			                <TD class="table_none">
                            	<select id="bgiusetypeyj2" name="bgiusetypeyj2"}>
      		                 		<option value="">----请选择----</option>
				               		<option value="1" ${bgiusetypeyj == '1' ? 'selected="selected"' : '' }>常带型</option>
				               		<option value="2" ${bgiusetypeyj == '2' ? 'selected="selected"' : '' }>抛弃型</option>
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
      	                   		</select>
			                </TD>
                        </tr>
                        <tr id="yj">
                           <TD height="26" class="table_none">隐形球镜范围</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text"  id="minSphyj2" name="minSphyj2" value="${requestScope.minSphyj}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写隐形球镜度数！'}]">
                            	至
                            <input class="text_input80" type="text"  id="maxSphyj2" name="maxSphyj2" value="${requestScope.maxSphyj}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写隐形球镜度数！'}]">
			               </TD>
						   <TD height="26" class="table_none" >隐形柱镜范围</TD>
			               <TD class="table_none" colspan="3">
                            <input class="text_input80" type="text"  id="minCylyj2" name="minCylyj2" value="${requestScope.minCylyj}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写隐形柱镜度数！'}]">
                            	至
                            <input class="text_input80" type="text"  id="maxCylyj2" name="maxCylyj2" value="${requestScope.maxCylyj}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写隐形柱镜度数！'}]">
			               </TD>
                        </tr>
                        <tr id="pj">
                           <TD height="26" class="table_none">配件型</TD>
			               <TD class="table_none" colspan="5">
                             <select id="pjlx2" name="pjlx2">
      		                   <option value="">----请选择----</option>
				               <option ${pjlx eq "1" ? 'selected="selected"' : '' } value="1" >框镜</option>
				               <option ${pjlx eq "2" ? 'selected="selected"' : '' } value="2" >隐形</option>
      	                     </select>
			               </TD>
                        </tr>
                        <tr id="hc">
                           <TD  height="26" class="table_none">其它商品大类</TD>
			               <TD class="table_none" colspan="5">
                             <select id="bgiothergoodsbigclass2" name="bgiothergoodsbigclass2">
      		                   <option value="">----请选择----</option>
				               <option ${bgiothergoodsbigclass eq "Q" ? 'selected="selected"' : '' } value="Q" >其它材料</option>
				               <option ${bgiothergoodsbigclass eq "D" ? 'selected="selected"' : '' } value="D" >低值易耗品</option>
      	                     </select>
			               </TD>
                        </tr>
                        <tr id="lh">
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
						   <TD class="table_body">是否显示查询条件</TD>
			               <TD class="table_none">
                               <input type="radio" id="isShow2" name="isShow2" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow2" name="isShow2" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
			               </TD>
			               <TD class="table_body" height="26">显示公司名称</TD>
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
						     &nbsp;&nbsp;&nbsp;销售数量：统计销售数量不包含退货数量。<br/>
						     &nbsp;&nbsp;&nbsp;退货数量：统计退货数量。<br/>
						     &nbsp;&nbsp;&nbsp;实售数量：销售数量减去退货数量。<br/>
						     &nbsp;&nbsp;&nbsp;销售金额：统计销售金额不包含退货金额。<br/>
						     &nbsp;&nbsp;&nbsp;退款金额：统计退货金额。<br/>
						     &nbsp;&nbsp;&nbsp;实售金额：销售金额减去退货金额。<br/>
						     &nbsp;&nbsp;&nbsp;金额占比：实售金额占总实售金额的比率。<br/>
						     &nbsp;&nbsp;&nbsp;成本金额：成本金额指收银时商品的不含税成本。<br/>
						     &nbsp;&nbsp;&nbsp;成本占比：成本金额占总成本金额的比率。<br/>
						     &nbsp;&nbsp;&nbsp;毛利金额：实售金额减去成本金额。<br/>
						     &nbsp;&nbsp;&nbsp;销售毛利率 ：毛利金额除以实售金额。<br/>
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

