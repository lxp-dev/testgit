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
		$("tr[id=isCustomize2]").hide();
    	$("input[id=isCustomize2][type=radio][value='']").attr('checked','checked');
		$("tr[shopshow=shopshow]").show();
		$("tr[shopshow2=shopshow2]").hide();
		$("tr[shopshow22=shopshow22]").hide();
		$("tr[goods4=goods4]").hide();
		$("tr[goods5=goods5]").hide();
		$("tr[goods44=goods44]").hide();
		$("tr[goodsss=goodsss]").show();
		$("tr[shopshow5=shopshow5]").hide();
		$("tr[shopshow222=shopshow222]").hide();
		$("tr[shopshow333=shopshow333]").hide();
		$("tr[showtype1=showtype1]").hide();
		$("tr[showtype2=showtype2]").hide();
		$("tr[showtype3=showtype3]").hide();
		$("tr[showtype4=showtype4]").hide();
		$("tr[showtype5=showtype5]").hide();
		$("tr[showtype6=showtype6]").hide();
		$("tr[showtype7=showtype7]").hide();
		
	    $('#shTqmonth').hide();
	    $('#shBqmonth').hide();
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
		if($("input[name=searchtype]:checked").val() == '1'){
			$("[id=showtype]").show();
		}else{
			$("[id=showtype]").hide();
			$("select[id=xory]").val("x");
		}
		
		setQueryType($("input[name=queryType]:checked"));
		showQuartzInfo('1');
		
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
			
	        var searchtype = $("input[name=searchtype]:checked").val();       
			var GoodsName = $('input[id=goodsName2]').val();		
			var GoodsCode=$("input[id=goodsCode2]").val();
			var supplierID = $("input[id=supplierID2]").val();
			var goodscategoryID = $("input[id=goodscategoryID2]:checked").val();
			var ShopCode=$("input[id=departmentID]").val();
			
			$('input[name=logincompanyid]').get(0).value = '${person.personcompanyid}';
			
			if(ShopCode == ''){
				ShopCode = $("#dids").val()
			}
			
			var brandID=$("input[id=brandID2]").val(); 
			var departmentNames = EncodeUtf8($("#ds").val());
			
			if (departmentNames == ''){
				if($("#dnames").val() == ''){
					departmentNames = '所有部门';
				}else{
					departmentNames =  EncodeUtf8($("#dnames").val());
				}
			}
			
			var querySystematics = EncodeUtf8(arrDetails[searchtype]);
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
	    	var salesCost = $("input[name=salesCost]:checked").val();
	    	
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

    		var isCustomize =  $('input[name=isCustomize2]:checked').val();
            $('input[name=isCustomize]').get(0).value = isCustomize;
		    
		    if(shopcol == '1'){
			    var ShopCodeNum = ShopCode.split(",");

			    var departmentcount=$("#departmentcount").val();

			    if(ShopCode == ""){
		            alert("按门店明细查看,所选门店不能为空!");
		            return; 
				}
				
			    //if(ShopCodeNum.length > 10){
	             //   alert("按门店明细查看,不能超过10家门店!");
	                //  return; 
				//}
			}
		    
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
			
			var queryTypeVal = $("input[name=queryType]:checked").val();
			
			var DataURL = '';
			var reportName = '';
		if(queryTypeVal == "1") {
			if(searchtype == '1'){   // 商品类别
				if(shopcol != '1'){
					formAction = 'categor';
					reportName = 'sales_goodsSalesAnalysisNew_category2.cpt';
				}else{
					formAction = 'category';
					reportName = 'sales_goodsSalesAnalysisNew_category.cpt';
				}
				if(xory == 'y'){
					formAction = 'categoryy';
					reportName = 'sales_goodsSalesAnalysisNewY_category.cpt';
				}
				if(xory == 'z'){
					formAction = 'categoryz';
					reportName = 'sales_goodsSalesAnalysisNew_category3.cpt';
				}
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
                      		+"&salesnumtype="+salesnumtype+"&bgnretailamount="+bgnretailamount+"&endretailamount="+endretailamount+"&isCustomize="+isCustomize;
			}else if(searchtype == '3'){ // 产品品种
				formAction = 'brand';
				if(shopcol != '1'){
					if(goodscategoryID == '3' || goodscategoryID == '4'){
						reportName = 'sales_goodsSalesAnalysisNew_brand4.cpt';
					}else{
						reportName = 'sales_goodsSalesAnalysisNew_brand2.cpt';
					}
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
	                      		+"&salesnumtype="+salesnumtype+"&bgnretailamount="+bgnretailamount+"&endretailamount="+endretailamount+"&isCustomize="+isCustomize;
				}else{
					if(goodscategoryID == '3' || goodscategoryID == '4'){
						reportName = 'sales_goodsSalesAnalysisNew_brand3.cpt';
					}else{
						reportName = 'sales_goodsSalesAnalysisNew_brand.cpt';
					}
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
	                      		+"&salesnumtype="+salesnumtype+"&bgnretailamount="+bgnretailamount+"&endretailamount="+endretailamount+"&isCustomize="+isCustomize;
					}
			}else if(searchtype == '4'){ // 产品名称
				formAction = 'goods';
				reportName = 'sales_goodsSalesAnalysisNew_goods.cpt';
				DataURL = "report.action?reportlet=sales_goodsSalesAnalysisNew_goods.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&goodsCategoryID="+goodscategoryID
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
                      		+"&salesnumtype="+salesnumtype+"&bgnretailamount="+bgnretailamount+"&endretailamount="+endretailamount+"&isCustomize="+isCustomize;
			}else if(searchtype == '2'){ // 制造商


				if(shopcol != '1'){
					formAction = 'supplier';
					reportName = 'sales_goodsSalesAnalysisNew_supplier2.cpt';
					DataURL = "report.action?reportlet=sales_goodsSalesAnalysisNew_supplier2.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&goodsCategoryID="+goodscategoryID+
							    "&supplierID="+supplierID+"&bandID="+brandID+"&goodsName="+GoodsName+"&goodsID="+GoodsCode+"&shopCode="+ShopCode+"&departmentNames="+departmentNames
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
	                      		+"&salesnumtype="+salesnumtype+"&bgnretailamount="+bgnretailamount+"&endretailamount="+endretailamount+"&isCustomize="+isCustomize;
					}else{
						formAction = 'supplier2';
				reportName = 'sales_goodsSalesAnalysisNew_supplier.cpt';
				DataURL = "report.action?reportlet=sales_goodsSalesAnalysisNew_supplier.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&goodsCategoryID="+goodscategoryID+
						    "&supplierID="+supplierID+"&bandID="+brandID+"&goodsName="+GoodsName+"&goodsID="+GoodsCode+"&shopCode="+ShopCode+"&departmentNames="+departmentNames
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
                      		+"&salesnumtype="+salesnumtype+"&bgnretailamount="+bgnretailamount+"&endretailamount="+endretailamount+"&isCustomize="+isCustomize;
					}
			  }
		  }else if(queryTypeVal == "2") {
		    	var ClassifyID = $('input[name=ClassifyID2]:checked').val();

		    	var MealID=$('#MealID2').val();
		    	var MealName=$('#MealName2').val();
				var departmentName = EncodeUtf8($("#ds").val());		    	
				$("input[name=ClassifyID]").val(ClassifyID);
				$("input[name=MealID]").val(MealID);
				$("input[name=MealName]").val(MealName);
				$("input[name=departmentName]").val(departmentName);
				$("input[name=departmentID]").val(ShopCode);
				

				var typeIDVal = $("input[name=typeID]:checked").val();
				if(typeIDVal == "1") {
					  formAction = 'SetMeal1';
					reportName = "sales_salesSetMealBySum.cpt";
					DataURL = "report.action?reportlet=sales_salesSetMealBySum.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&departmentID="+ShopCode+"&ClassifyID="+ClassifyID+"&MealID="+MealID+'&MealName='+EncodeUtf8(MealName)+'&departmentName='+EncodeUtf8(departmentNames)+'&isShow='+isShow;
				} else if(typeIDVal == "2") {
					  formAction = 'SetMeal2';
					reportName = "sales_salesSetMealSumByPersondetail.cpt";
					DataURL = "report.action?reportlet=sales_salesSetMealSumByPersondetail.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&departmentID="+ShopCode+"&ClassifyID="+ClassifyID+"&MealID="+MealID+'&MealName='+EncodeUtf8(MealName)+'&departmentName='+EncodeUtf8(departmentNames)+'&isShow='+isShow;
					
				}
			} else if(queryTypeVal == "3") {

		    	var searchtype5=$("input[name=searchtype5]:checked").val();
		    	if(searchtype5 =='1'){
			    	var begindate = $("#begindate").val();
			    	var begindate2 = $("#begindate2").val();
			    	var enddate = $("#enddate").val();
			    	var enddate2 = $("#enddate2").val();

					if(begindate==""){
						alert("本期日期1不能为空!");
						document.getElementById("begindate").focus();
						return false;
					}
					if(enddate==""){
						alert("本期日期2不能为空!");
						document.getElementById("enddate").focus();
						return false;
					}
					if(begindate2==""){
						alert("同期日期1不能为空!");
						document.getElementById("begindate2").focus();
						return false;
					}
					if(enddate2==""){
						alert("本期日期2不能为空!");
						document.getElementById("enddate2").focus();
						return false;
					}
			    	
					$("input[name=begintime]").val(begindate);
					$("input[name=endtime]").val(enddate);
					$("input[name=begintime2]").val(begindate2);
					$("input[name=endtime2]").val(enddate2);
					$("input[name=year]").val(begindate.substr(0,4));
					
				}else{
					
				var bqyear=$('#bqyear').val();
				if('${nowYear}'==bqyear){
					var bqmonth=$('#bqmonth11').val();
					var bqmonth2=$('#bqmonth22').val();
				}else{
					var bqmonth=$('#bqmonth').val();
					var bqmonth2=$('#bqmonth2').val();
				}
				var tqyear=$('#tqyear').val();
				if('${nowYear}'==tqyear){
					var tqmonth=$('#tqmonth11').val();
					var tqmonth2=$('#tqmonth22').val();
				}else{
					var tqmonth=$('#tqmonth').val();
					var tqmonth2=$('#tqmonth2').val();
				}
				if(bqyear==""){
					alert("本期年份不能为空!");
					document.getElementById("bqyear").focus();
					return false;
				}
				if(bqmonth==""){
					alert("本期月份不能为空!");
					if('${nowYear}'==bqyear){
						document.getElementById("bqmonth11").focus();
					}else{
						document.getElementById("bqmonth").focus();
					}
					
					return false;
				}
				if(bqmonth2==""){
					bqmonth2=bqmonth;
				}else if (parseInt(bqmonth2)<parseInt(bqmonth)){
					alert("本期月份2不能小于本期月份1!");
					if('${nowYear}'==bqyear){
						document.getElementById("bqmonth22").focus();
					}else{
						document.getElementById("bqmonth2").focus();
					}
					
					return false;
				}
				if(tqyear==""){
					alert("同期年份不能为空!");
					document.getElementById("tqyear").focus();
					return false;
				}
				if(tqmonth==""){
					alert("同期月份不能为空!");
					if('${nowYear}'==tqyear){
						document.getElementById("tqmonth11").focus();
					}else{
						document.getElementById("tqmonth").focus();
					}
					
					return false;
				}
				if(tqmonth2==""){
					tqmonth2=tqmonth;
				}else if (parseInt(tqmonth2)<parseInt(tqmonth)){
					alert("同期月份2不能小于同期月份1!");
					if('${nowYear}'==tqyear){
						document.getElementById("tqmonth22").focus();
					}else{
						document.getElementById("tqmonth2").focus();
					}
					
					return false;
				}
       			var bqday2=dayCount(bqyear,bqmonth2);
				var tqday2=dayCount(tqyear,tqmonth2);
				var begintime=bqyear+"-"+bqmonth+"-"+"01";
				var endtime=bqyear+"-"+bqmonth2+"-"+bqday2;
				var begintime2=tqyear+"-"+tqmonth+"-"+"01";
				var endtime2=tqyear+"-"+tqmonth2+"-"+tqday2;
				$("input[name=begintime]").val(begintime);
				$("input[name=endtime]").val(endtime);
				$("input[name=begintime2]").val(begintime2);
				$("input[name=endtime2]").val(endtime2);
				$("input[name=year]").val(tqyear);
				
				}
				
				$("input[name=departmentsID]").val(ShopCode);
				$("input[name=ShopCodeName]").val(departmentNames);

					
				var seltype=$("input[name=seltype]:checked").val();  

				var ygs=$("input[name=ygs2]:checked").val(); 


				var sss=$("input[name=sss2]:checked").val();


				var sse=$("input[name=sse2]:checked").val();


				var cb=$("input[name=cb2]:checked").val();
				var ml=$("input[name=ml2]:checked").val();
				var mll=$("input[name=mll2]:checked").val();


				$("input[name=ygs]").val(ygs);


				$("input[name=sss]").val(sss);


				$("input[name=sse]").val(sse);


				$("input[name=cb]").val(cb);
				$("input[name=ml]").val(ml);
				$("input[name=mll]").val(mll);

				
                if(seltype == "1")
                {	formAction = 'tongqi';
                    reportName = "sales_goodsSametimeAnalysis.cpt";
    				DataURL= "report.action?reportlet=sales_goodsSametimeAnalysis.cpt&__bypagesize__=false&departmentsID="+ShopCode+"&begintime="+begintime+"&endtime="+endtime+"&begintime2="+begintime2+"&endtime2="+endtime2+"&ShopCodeName="+EncodeUtf8(departmentNames)+"&year="+tqyear+"&isShow="+isShow;			
                    
                }else if(seltype == "2"){
    				formAction = 'tongqi2';
    				reportName = "sales_salesShopSametimeAnalysis.cpt";
    				DataURL = "report.action?reportlet=sales_salesShopSametimeAnalysis.cpt&__bypagesize__=false&departmentsID="+ShopCode+"&begintime="+begintime+"&endtime="+endtime+"&begintime2="+begintime2+"&endtime2="+endtime2+"&ShopCodeName="+EncodeUtf8(departmentNames)+"&year="+tqyear+"&isShow="+isShow;
    				DataURL=DataURL+"&ygs="+ygs+"&sss="+sss;
    				DataURL=DataURL+"&sse="+sse+"&cb="+cb+"&ml="+ml+"&mll="+mll+"&salesCost="+salesCost;			
                }						
			}else if(queryTypeVal == "4") {
		    	var xory2 = $("#xory2").val();

				var searchtype4=$("input[name=searchtype4]:checked").val();  

                if(searchtype4 == "1")
                {	
                    var shopcol22 =$("input[id=shopcol22]:checked").val();
    		        $("input[name=shopcol]").val(shopcol22);
                	var goodscategoryID22 = $("input[id=goodscategoryID22]:checked").val();
                	var categoryArea=$('#salesArea').val();
                	$("input[name=categoryArea]").val(categoryArea);
                	$("input[name=goodsCategoryID]").val(goodscategoryID22);
                	var isShowType2 = $("input[id=isShowType2]:checked").val();

                	if(isShowType2 == "1"){
                	
                  if(xory2 == "x"){

                    formAction = 'categoryarea1';
                    reportName = "sales_goodsSalesAnalysisNew_categoryarea.cpt";
    				DataURL= "report.action?reportlet=sales_goodsSalesAnalysisNew_categoryarea.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&goodsCategoryID="+goodscategoryID22+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&salesCost="+salesCost+"&categoryArea="+categoryArea;			
    				DataURL=DataURL+"&shopcol="+shopcol22+"&salesnumcol="+salesnumcol+"&showCompanyName="+showCompanyName
              		+"&salesmoneycol="+salesmoneycol+"&moneyratecol="+moneyratecol+"&costmoneycol="+costmoneycol
              		+"&zmoneycol="+zmoneycol+"&zmoneyratecol="+zmoneyratecol+"&costmoneyratecol="+costmoneyratecol;
                  }else if(xory2 == "y"){

                    formAction = 'categoryarea2';
                    reportName = "sales_goodsSalesAnalysisNew_categoryarea2.cpt";
      				DataURL= "report.action?reportlet=sales_goodsSalesAnalysisNew_categoryarea2.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&goodsCategoryID="+goodscategoryID22+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&salesCost="+salesCost+"&categoryArea="+categoryArea;			
      				DataURL=DataURL+"&shopcol="+shopcol22+"&salesnumcol="+salesnumcol+"&showCompanyName="+showCompanyName
                		+"&salesmoneycol="+salesmoneycol+"&moneyratecol="+moneyratecol+"&costmoneycol="+costmoneycol
                		+"&zmoneycol="+zmoneycol+"&zmoneyratecol="+zmoneyratecol+"&costmoneyratecol="+costmoneyratecol;
                  }else if(xory2 == "xx"){

                      formAction = 'categoryarea3';
                      reportName = "sales_goodsSalesAnalysisNew_categoryarea3.cpt";
        				DataURL= "report.action?reportlet=sales_goodsSalesAnalysisNew_categoryarea3.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&goodsCategoryID="+goodscategoryID22+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&salesCost="+salesCost+"&categoryArea="+categoryArea;			
        				DataURL=DataURL+"&shopcol="+shopcol22+"&salesnumcol="+salesnumcol+"&showCompanyName="+showCompanyName
                  		+"&salesmoneycol="+salesmoneycol+"&moneyratecol="+moneyratecol+"&costmoneycol="+costmoneycol
                  		+"&zmoneycol="+zmoneycol+"&zmoneyratecol="+zmoneyratecol+"&costmoneyratecol="+costmoneyratecol;

                  }else if(xory2 == "yy"){

                      formAction = 'categoryarea4';
                      reportName = "sales_goodsSalesAnalysisNew_categoryarea4.cpt";
        				DataURL= "report.action?reportlet=sales_goodsSalesAnalysisNew_categoryarea4.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&goodsCategoryID="+goodscategoryID22+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&salesCost="+salesCost+"&categoryArea="+categoryArea;			
        				DataURL=DataURL+"&shopcol="+shopcol22+"&salesnumcol="+salesnumcol+"&showCompanyName="+showCompanyName
                  		+"&salesmoneycol="+salesmoneycol+"&moneyratecol="+moneyratecol+"&costmoneycol="+costmoneycol
                  		+"&zmoneycol="+zmoneycol+"&zmoneyratecol="+zmoneyratecol+"&costmoneyratecol="+costmoneyratecol;

                  } 
                	}else if(isShowType2 == "2"){
                        if(xory2 == "x"){

                            formAction = 'categoryareat1';
                            reportName = "sales_goodsSalesAnalysisNew_categoryareat.cpt";
            				DataURL= "report.action?reportlet=sales_goodsSalesAnalysisNew_categoryareat.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&goodsCategoryID="+goodscategoryID22+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&salesCost="+salesCost+"&categoryArea="+categoryArea;			
            				DataURL=DataURL+"&shopcol="+shopcol22+"&salesnumcol="+salesnumcol+"&showCompanyName="+showCompanyName
                      		+"&salesmoneycol="+salesmoneycol+"&moneyratecol="+moneyratecol+"&costmoneycol="+costmoneycol
                      		+"&zmoneycol="+zmoneycol+"&zmoneyratecol="+zmoneyratecol+"&costmoneyratecol="+costmoneyratecol;
                          }else if(xory2 == "y"){

                            formAction = 'categoryareat2';
                            reportName = "sales_goodsSalesAnalysisNew_categoryareat2.cpt";
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysisNew_categoryareat2.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&goodsCategoryID="+goodscategoryID22+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&salesCost="+salesCost+"&categoryArea="+categoryArea;			
              				DataURL=DataURL+"&shopcol="+shopcol22+"&salesnumcol="+salesnumcol+"&showCompanyName="+showCompanyName
                        		+"&salesmoneycol="+salesmoneycol+"&moneyratecol="+moneyratecol+"&costmoneycol="+costmoneycol
                        		+"&zmoneycol="+zmoneycol+"&zmoneyratecol="+zmoneyratecol+"&costmoneyratecol="+costmoneyratecol;
                          }else if(xory2 == "xx"){

                              formAction = 'categoryareat3';
                              reportName = "sales_goodsSalesAnalysisNew_categoryareat3.cpt";
                				DataURL= "report.action?reportlet=sales_goodsSalesAnalysisNew_categoryareat3.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&goodsCategoryID="+goodscategoryID22+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&salesCost="+salesCost+"&categoryArea="+categoryArea;			
                				DataURL=DataURL+"&shopcol="+shopcol22+"&salesnumcol="+salesnumcol+"&showCompanyName="+showCompanyName
                          		+"&salesmoneycol="+salesmoneycol+"&moneyratecol="+moneyratecol+"&costmoneycol="+costmoneycol
                          		+"&zmoneycol="+zmoneycol+"&zmoneyratecol="+zmoneyratecol+"&costmoneyratecol="+costmoneyratecol;

                          }else if(xory2 == "yy"){

                              formAction = 'categoryareat4';
                              reportName = "sales_goodsSalesAnalysisNew_categoryareat4.cpt";
                				DataURL= "report.action?reportlet=sales_goodsSalesAnalysisNew_categoryareat4.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&goodsCategoryID="+goodscategoryID22+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&salesCost="+salesCost+"&categoryArea="+categoryArea;			
                				DataURL=DataURL+"&shopcol="+shopcol22+"&salesnumcol="+salesnumcol+"&showCompanyName="+showCompanyName
                          		+"&salesmoneycol="+salesmoneycol+"&moneyratecol="+moneyratecol+"&costmoneycol="+costmoneycol
                          		+"&zmoneycol="+zmoneycol+"&zmoneyratecol="+zmoneyratecol+"&costmoneyratecol="+costmoneyratecol;

                          } 

                    }
                }else if(searchtype4 == "2"){

                    var shopcol22 =$("input[id=shopcol22]:checked").val();
    		        $("input[name=shopcol]").val(shopcol22);
    		        var salesTypeID = $('input[name=salrsType]:checked').val();
                	var categoryArea=$('#salesArea').val();
                	$("input[name=categoryArea]").val(categoryArea);
                	$("input[name=salesTypeID]").val(salesTypeID);

                	var salesTypeName='';
                	if(salesTypeID =="1"){
                		salesTypeName="框镜成品";
                    }else if(salesTypeID =="2"){
                		salesTypeName="框镜订做";
                    }else if(salesTypeID =="3"){
                		salesTypeName="隐形成品";
                    }else if(salesTypeID =="4"){
                		salesTypeName="隐形订做";
                    }else if(salesTypeID =="5"){
                		salesTypeName="辅料";
                    }
                	$("input[name=salesTypeName]").val(EncodeUtf8(salesTypeName));
                    
                    if(xory2 == "x"){

                        formAction = 'salesTypearea1';
                        reportName = "sales_goodsSalesAnalysisNew_salesTypearea.cpt";
        				DataURL= "report.action?reportlet=sales_goodsSalesAnalysisNew_categoryarea.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&salesTypeID="+salesTypeID+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&salesCost="+salesCost+"&categoryArea="+categoryArea;			
        				DataURL=DataURL+"&shopcol="+shopcol22+"&salesnumcol="+salesnumcol+"&showCompanyName="+showCompanyName
                  		+"&salesmoneycol="+salesmoneycol+"&moneyratecol="+moneyratecol+"&costmoneycol="+costmoneycol
                  		+"&zmoneycol="+zmoneycol+"&zmoneyratecol="+zmoneyratecol+"&costmoneyratecol="+costmoneyratecol+"&salesTypeName="+EncodeUtf8(salesTypeName);
                      }else if(xory2 == "y"){

                        formAction = 'salesTypearea2';
                        reportName = "sales_goodsSalesAnalysisNew_salesTypearea2.cpt";
          				DataURL= "report.action?reportlet=sales_goodsSalesAnalysisNew_categoryarea2.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&salesTypeID="+salesTypeID+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&salesCost="+salesCost+"&categoryArea="+categoryArea;			
          				DataURL=DataURL+"&shopcol="+shopcol22+"&salesnumcol="+salesnumcol+"&showCompanyName="+showCompanyName
                    		+"&salesmoneycol="+salesmoneycol+"&moneyratecol="+moneyratecol+"&costmoneycol="+costmoneycol
                    		+"&zmoneycol="+zmoneycol+"&zmoneyratecol="+zmoneyratecol+"&costmoneyratecol="+costmoneyratecol+"&salesTypeName="+EncodeUtf8(salesTypeName);
                      }else if(xory2 == "xx"){

                          formAction = 'salesTypearea3';
                          reportName = "sales_goodsSalesAnalysisNew_salesTypearea3.cpt";
            				DataURL= "report.action?reportlet=sales_goodsSalesAnalysisNew_categoryarea3.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&salesTypeID="+salesTypeID+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&salesCost="+salesCost+"&categoryArea="+categoryArea;			
            				DataURL=DataURL+"&shopcol="+shopcol22+"&salesnumcol="+salesnumcol+"&showCompanyName="+showCompanyName
                      		+"&salesmoneycol="+salesmoneycol+"&moneyratecol="+moneyratecol+"&costmoneycol="+costmoneycol
                      		+"&zmoneycol="+zmoneycol+"&zmoneyratecol="+zmoneyratecol+"&costmoneyratecol="+costmoneyratecol+"&salesTypeName="+EncodeUtf8(salesTypeName);

                      }else if(xory2 == "yy"){

                          formAction = 'salesTypearea4';
                          reportName = "sales_goodsSalesAnalysisNew_salesTypearea4.cpt";
            				DataURL= "report.action?reportlet=sales_goodsSalesAnalysisNew_categoryarea4.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&salesTypeID="+salesTypeID+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&salesCost="+salesCost+"&categoryArea="+categoryArea;			
            				DataURL=DataURL+"&shopcol="+shopcol22+"&salesnumcol="+salesnumcol+"&showCompanyName="+showCompanyName
                      		+"&salesmoneycol="+salesmoneycol+"&moneyratecol="+moneyratecol+"&costmoneycol="+costmoneycol
                      		+"&zmoneycol="+zmoneycol+"&zmoneyratecol="+zmoneyratecol+"&costmoneyratecol="+costmoneyratecol+"&salesTypeName="+EncodeUtf8(salesTypeName);

                      } 
    			  }                 	
                }else if(queryTypeVal == "5") {
                	var optometryID=$('#optometryID2').val();
                	var optometryName=$('#optometryName2').val();
                	var salerID=$('#salerID2').val();
                	var salerName=$('#salerName2').val();

                	$("input[name=optometryID]").val(optometryID);
                	$("input[name=optometryName]").val(optometryName);
                	$("input[name=salerID]").val(salerID);
                	$("input[name=salerName]").val(salerName);

                	var seltype55=$("input[id=seltype55]:checked").val();
                	
                	var seltype5=$("input[id=seltype5]:checked").val();
                	var seltype555=$("input[id=seltype555]:checked").val(); 
                    switch(seltype55){
        	        case '1':// 按门店
    	            	
                        if(seltype555 =="1"){
                            formAction = 'salesFrame';
                            reportName = "sales_goodsSalesAnalysis_frame.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_frame.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="2"){
                            formAction = 'salesLen';
                            reportName = "sales_goodsSalesAnalysis_len.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_len.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="3"){
                            formAction = 'salesLenGdfl';
                            reportName = "sales_goodsSalesAnalysis_len_gdfl.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_len_gdfl.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="4"){
                            formAction = 'salesLenJpgn';
                            reportName = "sales_goodsSalesAnalysis_len_jpgn.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_len_jpgn.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="5"){
                            formAction = 'salesLenJjfl';
                            reportName = "sales_goodsSalesAnalysis_len_jjfl.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_len_jjfl.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="6"){
                            formAction = 'salesStealthsylx';
                            reportName = "sales_goodsSalesAnalysis_stealth_sylx.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_stealth_sylx.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="7"){
                            formAction = 'salesStealth';
                            reportName = "sales_goodsSalesAnalysis_stealth.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_stealth.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="8"){
                            formAction = 'sunGlass';
                            reportName = "sales_goodsSalesAnalysis_sunGlass.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_sunGlass.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="9"){
                            formAction = 'accessoriesType';
                            reportName = "sales_goodsSalesAnalysis_accessoriesType.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_accessoriesType.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }
                        
        	            break;
        	        case '2':      // 按营业员
            	        
                        if(seltype555 =="1"){
                            formAction = 'salesFrame2';
                            reportName = "sales_goodsSalesAnalysis_frame2.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_frame2.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="2"){
                            formAction = 'salesLen2';
                            reportName = "sales_goodsSalesAnalysis_len2.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_len2.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="3"){
                            formAction = 'salesLenGdfl2';
                            reportName = "sales_goodsSalesAnalysis_len_gdfl2.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_len_gdfl2.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="4"){
                            formAction = 'salesLenJpgn2';
                            reportName = "sales_goodsSalesAnalysis_len_jpgn2.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_len_jpgn2.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="5"){
                            formAction = 'salesLenJjfl2';
                            reportName = "sales_goodsSalesAnalysis_len_jjfl2.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_len_jjfl2.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="6"){
                            formAction = 'salesStealthsylx2';
                            reportName = "sales_goodsSalesAnalysis_stealth_sylx2.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_stealth_sylx2.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="7"){
                            formAction = 'salesStealth2';
                            reportName = "sales_goodsSalesAnalysis_stealth2.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_stealth2.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="8"){
                            formAction = 'sunGlass2';
                            reportName = "sales_goodsSalesAnalysis_sunGlass2.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_sunGlass2.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="9"){
                            formAction = 'accessoriesType2';
                            reportName = "sales_goodsSalesAnalysis_accessoriesType2.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_accessoriesType2.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }
                        
        	            break;
        	        case '3':      // 按验光师

                        if(seltype555 =="1"){
                            formAction = 'salesFrame3';
                            reportName = "sales_goodsSalesAnalysis_frame3.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_frame3.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="2"){
                            formAction = 'salesLen3';
                            reportName = "sales_goodsSalesAnalysis_len3.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_len3.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="3"){
                            formAction = 'salesLenGdfl3';
                            reportName = "sales_goodsSalesAnalysis_len_gdfl3.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_len_gdfl3.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="4"){
                            formAction = 'salesLenJpgn3';
                            reportName = "sales_goodsSalesAnalysis_len_jpgn3.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_len_jpgn3.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="5"){
                            formAction = 'salesLenJjfl3';
                            reportName = "sales_goodsSalesAnalysis_len_jjfl3.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_len_jjfl3.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="6"){
                            formAction = 'salesStealthsylx3';
                            reportName = "sales_goodsSalesAnalysis_stealth_sylx3.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_stealth_sylx3.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="7"){
                            formAction = 'salesStealth3';
                            reportName = "sales_goodsSalesAnalysis_stealth3.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_stealth3.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="8"){
                            formAction = 'sunGlass3';
                            reportName = "sales_goodsSalesAnalysis_sunGlass3.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_sunGlass3.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }else if(seltype555 =="9"){
                            formAction = 'accessoriesType3';
                            reportName = "sales_goodsSalesAnalysis_accessoriesType3.cpt"; 
              				DataURL= "report.action?reportlet=sales_goodsSalesAnalysis_accessoriesType3.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName;			
                        }
                        
        	            break;	                                                                      
        	        default:
        		        return;
                    }

		      }else if(queryTypeVal == "6") {
			      
		    	var salesTypeID = $('input[name=salrsType2]:checked').val();
		    	$("input[name=salesTypeID]").val(salesTypeID);
		    	  
              	var salesTypeName='';
            	if(salesTypeID =="1"){
            		salesTypeName="框镜成品";
                }else if(salesTypeID =="2"){
            		salesTypeName="框镜订做";
                }else if(salesTypeID =="3"){
            		salesTypeName="隐形成品";
                }else if(salesTypeID =="4"){
            		salesTypeName="隐形订做";
                }else if(salesTypeID =="5"){
            		salesTypeName="辅料";
                }else{
                	salesTypeName="全部";
                }
            	$("input[name=salesTypeName]").val(EncodeUtf8(salesTypeName));
                  formAction = 'saleskdj';
                  reportName = "sales_salesForkdjRpt.cpt"; 
    			  DataURL= "report.action?reportlet=sales_salesForkdjRpt.cpt&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&isShow="+isShow+"&showCompanyName="+showCompanyName+"&salesTypeID="+salesTypeID+"&salesTypeName="+EncodeUtf8(salesTypeName);			
  	  
			  }


			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;		
			if(is_iPad()){
				showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				DataURL = "report.action?reportlet=" + reportName + "&__bypagesize__=false";
				queryReport(DataURL,formAction);
			}
			document.getElementById('popupTitle').innerHTML="【商品销售分析表 】";
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
	    
	    var logincompanyid = document.createElement("input");	     
	    logincompanyid.type = "hidden";
	    logincompanyid.name = "logincompanyid";
	    logincompanyid.value = '';	  
	    rptFrm.appendChild(logincompanyid);  

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
	    
	    var salesCost = document.createElement("input");
	    var salesCostVal = $("input[name=salesCost]:checked").val();
	    salesCost.type = "hidden";
	    salesCost.name = "salesCost";
	    salesCost.value = (!salesCostVal ? "" : salesCostVal);
	    rptFrm.appendChild(salesCost);
	    //alert(salesCost.value);
	    
	    var packageQueryType = document.createElement("input");
	    var packageQueryTypeVal = $("input[name=packageQueryType]:checked").val();
	    packageQueryType.type = "hidden";
	    packageQueryType.name = "packageQueryType";
	    packageQueryType.value = (!packageQueryTypeVal ? "" : packageQueryTypeVal);
	    rptFrm.appendChild(packageQueryType);
	    //alert(packageQueryType.value);
	    
	    var MealName = document.createElement("input");
	    var MealNameVal = $("input[name=MealName]").val();
	    MealName.type = "hidden";
	    MealName.name = "MealName";
	    MealName.value = (!MealNameVal ? "" : MealNameVal);
	    rptFrm.appendChild(MealName);
	    //alert(packageName.value);
	    
	    var MealID = document.createElement("input");
	    var MealIDVal = $("input[name=MealID]").val();
	    MealID.type = "hidden";
	    MealID.name = "MealID";
	    MealID.value = (!MealIDVal ? "" : MealIDVal);
	    rptFrm.appendChild(MealID);
	    //alert(packageId.value);
	    
	    var ClassifyID = document.createElement("input");
	    var ClassifyIDVal =  $("input[name=ClassifyID]:checked").val()
	    ClassifyID.type = "hidden";
	    ClassifyID.name = "ClassifyID";
	    ClassifyID.value = (!ClassifyIDVal ? "" : ClassifyIDVal);
	    rptFrm.appendChild(ClassifyID);
	    //alert(ClassifyID.value);
	    
	    var queryType = document.createElement("input");
	    var queryTypeVal =  $("input[name=queryType]:checked").val()
	    queryType.type = "hidden";
	    queryType.name = "queryType";
	    queryType.value = (!queryTypeVal ? "" : queryTypeVal);
	    rptFrm.appendChild(queryType);
	    //alert(packageType.value);
	    
	    var isCustomize = document.createElement("input");	     
	    isCustomize.type = "hidden";
	    isCustomize.name = "isCustomize";
	    isCustomize.value = '';	  
	    rptFrm.appendChild(isCustomize);

	    var departmentsID = document.createElement("input");	     
	    departmentsID.type = "hidden";
	    departmentsID.name = "departmentsID";
	    departmentsID.value = '';	  
	    rptFrm.appendChild(departmentsID);

	    var ShopCodeName = document.createElement("input");	     
	    ShopCodeName.type = "hidden";
	    ShopCodeName.name = "ShopCodeName";
	    ShopCodeName.value = '';	  
	    rptFrm.appendChild(ShopCodeName);

	    var begintime = document.createElement("input");	     
	    begintime.type = "hidden";
	    begintime.name = "begintime";
	    begintime.value = '';	  
	    rptFrm.appendChild(begintime);

	    var endtime = document.createElement("input");	     
	    endtime.type = "hidden";
	    endtime.name = "endtime";
	    endtime.value = '';	  
	    rptFrm.appendChild(endtime);

	    var begintime2 = document.createElement("input");	     
	    begintime2.type = "hidden";
	    begintime2.name = "begintime2";
	    begintime2.value = '';	  
	    rptFrm.appendChild(begintime2);

	    var endtime2 = document.createElement("input");	     
	    endtime2.type = "hidden";
	    endtime2.name = "endtime2";
	    endtime2.value = '';	  
	    rptFrm.appendChild(endtime2);

	    var year = document.createElement("input");	     
	    year.type = "hidden";
	    year.name = "year";
	    year.value = '';	  
	    rptFrm.appendChild(year);

	    var ygs = document.createElement("input");	     
	    ygs.type = "hidden";
	    ygs.name = "ygs";
	    ygs.value = '';	  
	    rptFrm.appendChild(ygs);

	    var ygsb = document.createElement("input");	     
	    ygsb.type = "hidden";
	    ygsb.name = "ygsb";
	    ygsb.value = '';	  
	    rptFrm.appendChild(ygsb);

	    var ygszz = document.createElement("input");	     
	    ygszz.type = "hidden";
	    ygszz.name = "ygszz";
	    ygszz.value = '';	  
	    rptFrm.appendChild(ygszz);

	    var ygszzl = document.createElement("input");	     
	    ygszzl.type = "hidden";
	    ygszzl.name = "ygszzl";
	    ygszzl.value = '';	  
	    rptFrm.appendChild(ygszzl);

	    var sss = document.createElement("input");	     
	    sss.type = "hidden";
	    sss.name = "sss";
	    sss.value = '';	  
	    rptFrm.appendChild(sss);
	    
	    var sssb = document.createElement("input");	     
	    sssb.type = "hidden";
	    sssb.name = "sssb";
	    sssb.value = '';	  
	    rptFrm.appendChild(sssb);

	    var ssszz = document.createElement("input");	     
	    ssszz.type = "hidden";
	    ssszz.name = "ssszz";
	    ssszz.value = '';	  
	    rptFrm.appendChild(ssszz);

	    var ssszzl = document.createElement("input");	     
	    ssszzl.type = "hidden";
	    ssszzl.name = "ssszzl";
	    ssszzl.value = '';	  
	    rptFrm.appendChild(ssszzl);

	    var sse = document.createElement("input");	     
	    sse.type = "hidden";
	    sse.name = "sse";
	    sse.value = '';	  
	    rptFrm.appendChild(sse);

	    var sseb = document.createElement("input");	     
	    sseb.type = "hidden";
	    sseb.name = "sseb";
	    sseb.value = '';	  
	    rptFrm.appendChild(sseb);
	    
	    var ssezz = document.createElement("input");	     
	    ssezz.type = "hidden";
	    ssezz.name = "ssezz";
	    ssezz.value = '';	  
	    rptFrm.appendChild(ssezz);

	    var ssezzl = document.createElement("input");	     
	    ssezzl.type = "hidden";
	    ssezzl.name = "ssezzl";
	    ssezzl.value = '';	  
	    rptFrm.appendChild(ssezzl);

	    var cb = document.createElement("input");	     
	    cb.type = "hidden";
	    cb.name = "cb";
	    cb.value = '';	  
	    rptFrm.appendChild(cb);

	    var ml = document.createElement("input");	     
	    ml.type = "hidden";
	    ml.name = "ml";
	    ml.value = '';	  
	    rptFrm.appendChild(ml);

	    var mll = document.createElement("input");	     
	    mll.type = "hidden";
	    mll.name = "mll";
	    mll.value = '';	  
	    rptFrm.appendChild(mll);

	    var categoryArea = document.createElement("input");	     
	    categoryArea.type = "hidden";
	    categoryArea.name = "categoryArea";
	    categoryArea.value = '';	  
	    rptFrm.appendChild(categoryArea); 

	    var salesTypeID = document.createElement("input");	     
	    salesTypeID.type = "hidden";
	    salesTypeID.name = "salesTypeID";
	    salesTypeID.value = '';	  
	    rptFrm.appendChild(salesTypeID);


	    var salesTypeName = document.createElement("input");	     
	    salesTypeName.type = "hidden";
	    salesTypeName.name = "salesTypeName";
	    salesTypeName.value = '';	  
	    rptFrm.appendChild(salesTypeName);

	    var optometryID = document.createElement("input");	     
	    optometryID.type = "hidden";
	    optometryID.name = "optometryID";
	    optometryID.value = '';	  
	    rptFrm.appendChild(optometryID);

	    var optometryName = document.createElement("input");	     
	    optometryName.type = "hidden";
	    optometryName.name = "optometryName";
	    optometryName.value = '';	  
	    rptFrm.appendChild(optometryName);

	    var salerID = document.createElement("input");	     
	    salerID.type = "hidden";
	    salerID.name = "salerID";
	    salerID.value = '';	  
	    rptFrm.appendChild(salerID);

	    var salerName = document.createElement("input");	     
	    salerName.type = "hidden";
	    salerName.name = "salerName";
	    salerName.value = '';	  
	    rptFrm.appendChild(salerName);
	    
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
			$("tr[id=isCustomize2]").hide();
		    	$("input[id=isCustomize2][type=radio][value='']").attr('checked','checked');
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
				$("tr[id=isCustomize2]").hide();
		    	$("input[id=isCustomize2][type=radio][value='']").attr('checked','checked');
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
				$("tr[id=isCustomize2]").show();
		    	$("input[id=isCustomize2][type=radio][value='']").attr('checked','checked');
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
			$("tr[id=isCustomize2]").show();
	    	$("input[id=isCustomize2][type=radio][value='']").attr('checked','checked');
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
			$("tr[id=isCustomize2]").hide();
	    	$("input[id=isCustomize2][type=radio][value='']").attr('checked','checked');
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
			$("tr[id=isCustomize2]").hide();
	    	$("input[id=isCustomize2][type=radio][value='']").attr('checked','checked');
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
			$("tr[id=isCustomize2]").hide();
	    	$("input[id=isCustomize2][type=radio][value='']").attr('checked','checked');
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
		$("tr[shopshow222=shopshow222]").hide();
		$("tr[shopshow333=shopshow333]").hide();
		$("tr[id=isCustomize2]").hide();
		
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
		setQueryType($("input[name=queryType]:checked"));

		$("tr[shopshow=shopshow]").show();
		$("tr[shopshow2=shopshow2]").hide();
		$("tr[shopshow22=shopshow22]").hide();
		$("tr[goods4=goods4]").hide();

		$("tr[showtype1=showtype1]").hide();
		$("tr[showtype2=showtype2]").hide();
		$("tr[showtype3=showtype3]").hide();
		$("tr[showtype4=showtype4]").hide();
		$("tr[showtype5=showtype5]").hide();
		$("tr[showtype6=showtype6]").hide();
		$("tr[showtype7=showtype7]").hide();
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
	function isShowShowType2(obj){
		if($(obj).val() == '1'){
			$("tr[goods=goods]").hide();
			$("tr[goodsAttr=goodsAttr]").hide();
			$("tr[package=package]").hide();
			$("tr[shopshow=shopshow]").show();
			$("tr[shopshow2=shopshow2]").hide();
			$("tr[shopshow22=shopshow22]").hide();
			$("tr[goodss=goodss]").hide();
			$("tr[goods4=goods4]").show();
			$("tr[goods5=goods5]").hide();
			$("tr[goodss=goodss]").show();
			$("tr[goodsss=goodsss]").show();
			$("input[id=goodscategoryID22][type=radio][value=1]").attr('checked','checked');
		}else if($(obj).val() == '2'){
			$("tr[goods=goods]").hide();
			$("tr[goodsAttr=goodsAttr]").hide();
			$("tr[package=package]").hide();
			$("tr[shopshow=shopshow]").show();
			$("tr[shopshow2=shopshow2]").hide();
			$("tr[shopshow22=shopshow22]").hide();
			$("tr[goodss=goodss]").hide();
			$("tr[goods4=goods4]").hide();
			$("tr[goods5=goods5]").show();
			$("tr[goodss=goodss]").show();
			$("tr[goodsss=goodsss]").show();
			$("input[name=salrsType][type=radio][value=1]").attr('checked','checked');
			
			
		}else{

			}
	}
	function setQueryType(obj) {
		
		if($(obj).val() == '1') {//按商品
			$("tr[goods=goods]").show();
			$("tr[package=package]").hide();
			$("tr[shopshow=shopshow]").show();
			$("tr[shopshow2=shopshow2]").hide();
			$("tr[shopshow22=shopshow22]").hide();
			$("tr[goodss=goodss]").show();
			$("tr[goods4=goods4]").hide();
			$("tr[goods44=goods44]").hide();
			$("tr[goodsss=goodsss]").show();
			$("tr[goods5=goods5]").hide();
			$("tr[shopshow5=shopshow5]").hide();
			$("tr[shopshow222=shopshow222]").hide();
			$("tr[shopshow333=shopshow333]").hide();
			$("tr[showtype1=showtype1]").hide();
			$("tr[showtype2=showtype2]").hide();
			$("tr[showtype3=showtype3]").hide();
			$("tr[showtype4=showtype4]").hide();
			$("tr[showtype5=showtype5]").hide();
			$("tr[goods8=goods8]").hide();
			
		
		
		} if($(obj).val() == '2') {//按套餐
			$("tr[package=package]").show();
			$("tr[goods=goods]").hide();
			$("tr[goodsAttr=goodsAttr]").hide();
			$("tr[id=isCustomize2]").hide();
	    	$("input[id=isCustomize2][type=radio][value='']").attr('checked','checked');
	    	$("input[id=goodscategoryID2][type=radio][value='']").attr('checked','checked');
			$("tr[shopshow=shopshow]").show();
			$("tr[shopshow2=shopshow2]").hide();
			$("tr[shopshow22=shopshow22]").hide();
			$("tr[goodss=goodss]").hide();
			$("tr[goods4=goods4]").hide();
			$("tr[goods44=goods44]").hide();
			$("tr[goodsss=goodsss]").hide();
			$("tr[goods5=goods5]").hide();
			$("tr[shopshow5=shopshow5]").hide();
			$("tr[shopshow222=shopshow222]").hide();
			$("tr[shopshow333=shopshow333]").hide();
			$("tr[showtype1=showtype1]").hide();
			$("tr[showtype2=showtype2]").hide();
			$("tr[showtype3=showtype3]").hide();
			$("tr[showtype4=showtype4]").hide();
			$("tr[showtype5=showtype5]").hide();
			$("tr[goods8=goods8]").hide();
			$("tr[id=isCustomize2]").hide();
		} if($(obj).val() == '3') {//按销售同期
			$("tr[goods=goods]").hide();
			$("tr[goodsAttr=goodsAttr]").hide();
			$("tr[package=package]").hide();
			$("tr[shopshow=shopshow]").hide();
			$("tr[shopshow2=shopshow2]").show();
			$("tr[shopshow22=shopshow22]").hide();
			$("tr[goodss=goodss]").hide();
			$("tr[goods4=goods4]").hide();
			$("tr[goods44=goods44]").hide();
			$("input[id=seltype][type=radio][value=1]").attr('checked','checked');
			$("tr[goodsss=goodsss]").hide();
			$("tr[goods5=goods5]").hide();
			$("tr[shopshow5=shopshow5]").hide();
			$("tr[shopshow222=shopshow222]").hide();
			$("tr[shopshow333=shopshow333]").show();
			$("tr[showtype1=showtype1]").hide();
			$("tr[showtype2=showtype2]").hide();
			$("tr[showtype3=showtype3]").hide();
			$("tr[showtype4=showtype4]").hide();
			$("tr[showtype5=showtype5]").hide();
			$("tr[goods8=goods8]").hide();
			$("tr[id=isCustomize2]").hide();	
						
		}if($(obj).val() == '4') {//按价格段
			$("tr[goods=goods]").hide();
			$("tr[goodsAttr=goodsAttr]").hide();
			$("tr[package=package]").hide();
			$("tr[shopshow=shopshow]").show();
			$("tr[shopshow2=shopshow2]").hide();
			$("tr[shopshow22=shopshow22]").hide();
			$("tr[goodss=goodss]").hide();
			$("tr[goods44=goods44]").show();
			$("tr[goods4=goods4]").show();
			$("tr[goodss=goodss]").show();
			$("tr[goodsss=goodsss]").show();
			$("tr[goods5=goods5]").hide();
			$("tr[shopshow5=shopshow5]").hide();
			$("input[id=searchtype4][type=radio][value=1]").attr('checked','checked');
			$("input[id=goodscategoryID22][type=radio][value=1]").attr('checked','checked');
			$("tr[shopshow222=shopshow222]").hide();
			$("tr[shopshow333=shopshow333]").hide();
			$("tr[showtype1=showtype1]").hide();
			$("tr[showtype2=showtype2]").hide();
			$("tr[showtype3=showtype3]").hide();
			$("tr[showtype4=showtype4]").hide();
			$("tr[showtype5=showtype5]").hide();
			$("tr[goods8=goods8]").hide();
			$("tr[id=isCustomize2]").hide();
		
		}if($(obj).val() == '5') {//按商品属性
			$("tr[goods=goods]").hide();
			$("tr[goodsAttr=goodsAttr]").hide();
			$("tr[package=package]").hide();
			$("tr[shopshow=shopshow]").show();
			$("tr[shopshow2=shopshow2]").hide();
			$("tr[shopshow22=shopshow22]").hide();
			$("tr[goodss=goodss]").hide();
			$("tr[goods44=goods44]").hide();
			$("tr[goods4=goods4]").hide();
			$("tr[goodss=goodss]").hide();
			$("tr[goodsss=goodsss]").hide();
			$("tr[goods5=goods5]").hide();
			$("tr[shopshow5=shopshow5]").show();
			$("input[id=seltype5][type=radio][value=1]").attr('checked','checked');
			$("input[id=seltype555][type=radio][value='1']").attr('checked','checked');
			$("tr[shopshow222=shopshow222]").hide();
			$("tr[shopshow333=shopshow333]").hide();
			$("tr[showtype1=showtype1]").show();
			$("tr[showtype2=showtype2]").hide();
			$("tr[showtype3=showtype3]").hide();
			$("tr[showtype4=showtype4]").hide();
			$("tr[showtype5=showtype5]").hide();
			$("tr[goods8=goods8]").hide();
			$("tr[id=isCustomize2]").hide();
		
		}if($(obj).val() == '6') {//按客单价

			$("tr[goods=goods]").hide();
			$("tr[package=package]").hide();
			$("tr[shopshow=shopshow]").show();
			$("tr[shopshow2=shopshow2]").hide();
			$("tr[shopshow22=shopshow22]").hide();
			$("tr[goodss=goodss]").hide();
			$("tr[goods4=goods4]").hide();
			$("tr[goods44=goods44]").hide();
			$("tr[goodsss=goodsss]").hide();
			$("tr[goods5=goods5]").hide();
			$("tr[shopshow5=shopshow5]").hide();
			$("tr[shopshow222=shopshow222]").hide();
			$("tr[shopshow333=shopshow333]").hide();
			$("tr[showtype1=showtype1]").hide();
			$("tr[showtype2=showtype2]").hide();
			$("tr[showtype3=showtype3]").hide();
			$("tr[showtype4=showtype4]").hide();
			$("tr[showtype5=showtype5]").hide();
			$("tr[goods8=goods8]").show();
			$("tr[id=isCustomize2]").hide();
		}

		showQuartzInfo($(obj).val());
	}
	function setQueryType2(obj) {
		
		if($(obj).val() == '1') {//按类别

			$("tr[shopshow22=shopshow22]").hide();
			$("tr[goodss=goodss]").hide();
		
		
		} if($(obj).val() == '2') {//按门店

			$("tr[shopshow22=shopshow22]").show();
			$("tr[goodss=goodss]").show();

			
		} 
	}
	function setshowtype(obj) {
		
		if($(obj).val() == '1') {//按镜架
			$("tr[showtype1=showtype1]").show();
			$("tr[showtype2=showtype2]").hide();
			$("tr[showtype3=showtype3]").hide();
			$("tr[showtype4=showtype4]").hide();
			$("tr[showtype5=showtype5]").hide();
			$("input[id=seltype555][type=radio][value='1']").attr('checked','checked');
			
		}else if($(obj).val() == '2') {//按镜片
			$("tr[showtype1=showtype1]").hide();
			$("tr[showtype2=showtype2]").show();
			$("tr[showtype3=showtype3]").hide();
			$("tr[showtype4=showtype4]").hide();
			$("tr[showtype5=showtype5]").hide();
			$("input[id=seltype555][type=radio][value='2']").attr('checked','checked');	
		}else if($(obj).val() == '3') {//按隐形
			$("tr[showtype1=showtype1]").hide();
			$("tr[showtype2=showtype2]").hide();
			$("tr[showtype3=showtype3]").show();
			$("tr[showtype4=showtype4]").hide();
			$("tr[showtype5=showtype5]").hide();
			$("input[id=seltype555][type=radio][value='6']").attr('checked','checked');	
		}else if($(obj).val() == '4') {//按太阳镜
			$("tr[showtype1=showtype1]").hide();
			$("tr[showtype2=showtype2]").hide();
			$("tr[showtype3=showtype3]").hide();
			$("tr[showtype4=showtype4]").show();
			$("tr[showtype5=showtype5]").hide();
			$("input[id=seltype555][type=radio][value='8']").attr('checked','checked');	
		}else if($(obj).val() == '5') {//按配件
			$("tr[showtype1=showtype1]").hide();
			$("tr[showtype2=showtype2]").hide();
			$("tr[showtype3=showtype3]").hide();
			$("tr[showtype4=showtype4]").hide();
			$("tr[showtype5=showtype5]").show();
			$("input[id=seltype555][type=radio][value='9']").attr('checked','checked');
		}
	}
	function setshowtype2(obj) {
		
		if($(obj).val() == '1') {//按门店 

			$("tr[showtype6=showtype6]").hide();
			$("tr[showtype7=showtype7]").hide();

			
		}else if($(obj).val() == '2') {//按销售人员

			$("tr[showtype6=showtype6]").show();
			$("tr[showtype7=showtype7]").hide();

		}else if($(obj).val() == '3') {//按验光师
			$("tr[showtype6=showtype6]").hide();
			$("tr[showtype7=showtype7]").show();
		}
	}
	function isShowShowType5(obj) {
		
		if($(obj).val() == '1') {//按时间段

			$("tr[shopshow222=shopshow222]").hide();
			$("tr[shopshow333=shopshow333]").show();
		
		
		} if($(obj).val() == '2') {//按年月选择

			$("tr[shopshow222=shopshow222]").show();
			$("tr[shopshow333=shopshow333]").hide();

			
		} 
	}
	function defOptionV(obj) {
		$(obj).each(function() {
			$("input", $(this)).val("");
			try {
				$("input[type=radio]", $(this)).get(0).click();
			} catch(e) {
				
			}
			$("select", $(this)).val("");
		});
	}
	/**
	 * 套餐开窗
	 */
	function openSetMeal(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelSetMealReportOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelSetMealReportOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【套餐查询】";
	}
	
	/**
	 * 套餐开窗赋值实现方法
	 */
	function openSetMealValues(objValue){
		var arrayID = new Array();
		var arrayName = new Array();
		var departments = eval('(' + objValue + ')');
		for(var i = 0; i < departments.length; i++){	
			arrayID[i] = departments[i].MealID;
			arrayName[i] = departments[i].MealName;
		}
		
		$('#MealID2').val(arrayID.join(","));
		$('#MealName2').val(arrayName.join(","));
		//$('#mealds').val($('#MealName').val());
	}
	
	function checkNumberType(thiz){
		if($(thiz).val()!=''){
			if(parseFloat($(thiz).val())>0){
				var str='+'+parseFloat($(thiz).val().replace('+','')).toFixed(2);
				$(thiz).val(str);
			}else if(parseFloat($(thiz).val())<0){
				$(thiz).val(parseFloat($(thiz).val()).toFixed(2));
			}else if(parseFloat($(thiz).val())==0){
				$(thiz).val('0.00');
			}
		}
	}
	function dayCount(y, m) {                  
	    var yy = parseInt(y, 10);            
	    var mm = parseInt(m, 10);            
	    var result = 0;            
	    if (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12) {                
		    result = 31;            
	    }            
	    else if (mm == 4 || mm == 6 || mm == 9 || mm == 11) {                
		    result = 30;            
	    } else if (mm == 2) {                
	        if ((yy % 4 == 0 && yy % 100 != 0) || yy % 400 == 0) {                    
		        result = 29;                
	        } else {                    
		        result = 28;                
	        }            
	    }            
	    return result;        
	}
	/**
	 * 价格区间开窗
	 */
	function openAmount(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var salesTypeID="";


		var searchtype4=$("input[name=searchtype4]:checked").val();  

    if(searchtype4 == "1"){
    		salesTypeID = $("input[id=goodscategoryID22]:checked").val();
		if(!salesTypeID) {
			alert("请选择商品类型!");
			return;
		}
		if(is_iPad()){
			showPopWin("salesAreaOpen.action?reportID=${moduleID}&goodsCategoryID="+salesTypeID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("salesAreaOpen.action?reportID=${moduleID}&goodsCategoryID="+salesTypeID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
    }	
	else if(searchtype4 == "2"){
		salesTypeID = $('input[name=salrsType]:checked').val();
		if(!salesTypeID) {
			alert("请选择商品类型!");
			return;
		}
		if(is_iPad()){
			showPopWin("salesAreaOpen.action?reportID=${moduleID}&salesTypeID="+salesTypeID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("salesAreaOpen.action?reportID=${moduleID}&salesTypeID="+salesTypeID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
	 }
		document.getElementById('popupTitle').innerHTML="【价格区间查询】";
	}
	
	/**
	 * 价格区间开窗赋值实现方法
	 */
	function openAmountValues(objValue){
		var arrayID = new Array();
		var departments = eval('(' + objValue + ')');
		for(var i = 0; i < departments.length; i++){	
			arrayID[i] = departments[i].areaid;
		}
		
		document.getElementById('salesArea').value = arrayID.join(",");
		document.getElementById('ds2').value = arrayID.join(",");
	}

	function cleanSalesArea(){
        $('#ds2').val('');
        $('#salesArea').val('');
	}
	function selectBqYear(thiz){
		var bqyear=$(thiz).val();
		if(''!=bqyear){
			$('#shBqmonth').show();
			if('${nowYear}'==bqyear){
				$("select[id=bqmonth11]").show();
				$("select[id=bqmonth22]").show();
				$("select[id=bqmonth]").hide();
				$("select[id=bqmonth2]").hide();
			}else{
				$("select[id=bqmonth11]").hide();
				$("select[id=bqmonth22]").hide();
				$("select[id=bqmonth]").show();
				$("select[id=bqmonth2]").show();
			}
		}else{
			$('#shBqmonth').hide();
		}
	}
	function selectTqYear(thiz){
		var tqyear=$(thiz).val();
		if(''!=tqyear){
			$('#shTqmonth').show();
			if('${nowYear}'==tqyear){
				$("select[id=tqmonth11]").show();
				$("select[id=tqmonth22]").show();
				$("select[id=tqmonth]").hide();
				$("select[id=tqmonth2]").hide();
			}else{
				$("select[id=tqmonth11]").hide();
				$("select[id=tqmonth22]").hide();
				$("select[id=tqmonth]").show();
				$("select[id=tqmonth2]").show();
			}
		}else{
			$('#shTqmonth').hide();
		}
	}

	function showQuartzInfo(flag){
		$('div[class=reportHelp]').hide(); 
		
        if (flag == '1'){
        	$('div[class=reportHelp][id=goods]').show();      
        }
        if (flag == '3'){
        	$('div[class=reportHelp][id=xsdb]').show();      
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
<input type="hidden" id="departmentcount" name="departmentcount" value="${requestScope.departmentcount}">
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
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：商品销售分析表 </TD>
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
                        <tr>
                           <TD width="7%" class="table_body">分析角度</TD>
			               <TD class="table_none" width="25%" colspan="5">
	      	                   <input type="radio" name="queryType" value="1" onclick="setQueryType(this)"  checked=checked/><a title="可查询实时数据">按商品&nbsp;&nbsp;</a>
	      	                   <input type="radio" name="queryType" value="2" onclick="setQueryType(this)"/><a title="可查询实时数据">按套餐    &nbsp;&nbsp;</a>    	                    
	      	                   <input type="radio" name="queryType" value="3" onclick="setQueryType(this)"/><a title="可查询到前一天数据">按销售同期&nbsp;&nbsp;</a>	
	      	                   <input type="radio" name="queryType" value="4" onclick="setQueryType(this)"/><a title="可查询实时数据">按价格区间&nbsp;&nbsp;</a> 
	      	                   <input type="radio" name="queryType" value="5" onclick="setQueryType(this)"/><a title="可查询实时数据">按商品属性&nbsp;&nbsp;</a> 
	      	                   <input type="radio" name="queryType" value="6" onclick="setQueryType(this)"/><a title="可查询实时数据">按客单价&nbsp;&nbsp;</a>      	                   
			               </TD>
                        </tr>
                        <tr goods=goods>
                           <TD width="7%" class="table_body">查询分类</TD>
			               <TD class="table_none" width="25%" colspan="5">
	      	                   <input type="radio" name="searchtype" value="1" onclick="isShowShowType(this)" checked/>商品类别&nbsp;&nbsp;
	      	                   <input type="radio" name="searchtype" value="2" onclick="isShowShowType(this)"/>按制造商     &nbsp;&nbsp;
	      	                   <input type="radio" name="searchtype" value="3" onclick="isShowShowType(this)"/>按商品品种&nbsp;&nbsp;
	      	                   <!-- <input type="radio" name="searchtype" value="4" onclick="isShowShowType(this)"/>按产品名称&nbsp;&nbsp; -->
			               </TD>
                        </tr>
                        <TR shopshow2="shopshow2">
			               <TD width="12%" height="26" class="table_body" >查询分类</TD>
			               <TD class="table_none" colspan="5" >
	      	                   <input type="radio" id="seltype" name="seltype" value="1" onclick="setQueryType2(this)"  checked/>按商品类别&nbsp;&nbsp;
	      	                   <input type="radio" id="seltype" name="seltype" value="2" onclick="setQueryType2(this)" />按门店     &nbsp;&nbsp;
			               </TD>
			            </TR>
			            
			            <TR shopshow5="shopshow5">
			               <TD width="12%" height="26" class="table_body" >查询角度</TD>
			               <TD class="table_none" colspan="5" >
	      	                   <input type="radio" id="seltype55" name="seltype55" value="1" onclick="setshowtype2(this)"   checked/>按门店&nbsp;&nbsp;
	      	                   <input type="radio" id="seltype55" name="seltype55" value="2" onclick="setshowtype2(this)" />按营业员     &nbsp;&nbsp;
	      	                   <input type="radio" id="seltype55" name="seltype55" value="3" onclick="setshowtype2(this)" />按验光师&nbsp;&nbsp;
			               </TD>
			            </TR>
			            <TR shopshow5="shopshow5">
			               <TD width="12%" height="26" class="table_body" >查询分类</TD>
			               <TD class="table_none" colspan="5" >
	      	                   <input type="radio" id="seltype5" name="seltype5" value="1" onclick="setshowtype(this)"   checked/>镜架&nbsp;&nbsp;
	      	                   <input type="radio" id="seltype5" name="seltype5" value="2" onclick="setshowtype(this)" />镜片&nbsp;&nbsp;
	      	                   <input type="radio" id="seltype5" name="seltype5" value="3" onclick="setshowtype(this)" />隐形&nbsp;&nbsp;
	      	                   <input type="radio" id="seltype5" name="seltype5" value="4" onclick="setshowtype(this)"/>太阳镜&nbsp;&nbsp;
	      	                   <input type="radio" id="seltype5" name="seltype5" value="5" onclick="setshowtype(this)"/>配件&nbsp;&nbsp;
			               </TD>
			            </TR>
			            <TR showtype1="showtype1">
			               <TD width="12%" height="26" class="table_body" >查询分类2</TD>
			               <TD class="table_none" colspan="5" >
	      	                   <input type="radio" id="seltype555" name="seltype555" value="1"   checked/>按镜架材质&nbsp;&nbsp;
			               </TD>
			            </TR>
			            <TR showtype2="showtype2">
			               <TD width="12%" height="26" class="table_body" >查询分类2</TD>
			               <TD class="table_none" colspan="5" >
	      	                   <input type="radio" id="seltype555" name="seltype555" value="2"   />按镜片折射率&nbsp;&nbsp;
	      	                   <input type="radio" id="seltype555" name="seltype555" value="3"   />按镜片光度分类&nbsp;&nbsp;
	      	                   <input type="radio" id="seltype555" name="seltype555" value="4"   />按镜片镜片功能&nbsp;&nbsp;
	      	                   <input type="radio" id="seltype555" name="seltype555" value="5"   />按镜片渐进片分类&nbsp;&nbsp;
			               </TD>
			            </TR>
			            <TR showtype3="showtype3">
			               <TD width="12%" height="26" class="table_body" >查询分类2</TD>
			               <TD class="table_none" colspan="5" >
	      	                   <input type="radio" id="seltype555" name="seltype555" value="6"   />按隐形使用类型&nbsp;&nbsp;
	      	                   <input type="radio" id="seltype555" name="seltype555" value="7"  />按隐形抛弃型分类&nbsp;&nbsp;
			               </TD>
			            </TR>
			            <TR showtype4="showtype4">
			               <TD width="12%" height="26" class="table_body" >查询分类2</TD>
			               <TD class="table_none" colspan="5" >
	      	                   <input type="radio" id="seltype555" name="seltype555" value="8"   />按太阳镜功能&nbsp;&nbsp;
			               </TD>
			            </TR>
			            <TR showtype5="showtype5">
			               <TD width="12%" height="26" class="table_body" >查询分类2</TD>
			               <TD class="table_none" colspan="5" >
	      	                   <input type="radio" id="seltype555" name="seltype555" value="9"   />按配件类型&nbsp;&nbsp;
			               </TD>
			            </TR>
                        <tr goods44=goods44>
                           <TD width="7%" class="table_body">查询分类</TD>
			               <TD class="table_none" width="25%" colspan="5">
	      	                   <input type="radio" id="searchtype4"  name="searchtype4" value="1" onclick="isShowShowType2(this)" checked/>按商品类别&nbsp;&nbsp;
	      	                   <input type="radio" id="searchtype4"  name="searchtype4" value="2" onclick="isShowShowType2(this)"/>按销售类型     &nbsp;&nbsp;
			               </TD>
                        </tr>
                        <TR goods=goods>
                           <TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none" colspan="5">
			               	   <input type="radio" name="goodscategoryID2" onclick="showterm();" id ="goodscategoryID2" value="" checked/>全部&nbsp;&nbsp;
	      	                   <s:iterator value="goodsCategorys">
	      	                   <input type="radio" name="goodscategoryID2" onclick="showterm();" id ="goodscategoryID2" value="${bgcid}"/>${bgcgoodscategoryname}&nbsp;&nbsp;
	      	                   </s:iterator>
	      	               </TD>
                        </TR>
                        <TR goods4=goods4>
                           <TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none" colspan="5">
	      	                   <s:iterator value="goodsCategorys">
	      	                   <input type="radio" name="goodscategoryID22" id ="goodscategoryID22" value="${bgcid}" onclick="cleanSalesArea();"/>${bgcgoodscategoryname}&nbsp;&nbsp;
	      	                   </s:iterator>
	      	               </TD>
                        </TR>
                        <TR goods5=goods5>
                           <TD height="26" class="table_body">销售类型</TD>
			               <TD class="table_none" colspan="5">
	      	                   <input type="radio" checked="checked" name="salrsType" value="1" onclick="cleanSalesArea();">框镜成品&nbsp;&nbsp;
	      	                   <input type="radio" name="salrsType" value="2" onclick="cleanSalesArea();">框镜订做&nbsp;&nbsp;
	      	                   <input type="radio" name="salrsType" value="3" onclick="cleanSalesArea();">隐形成品&nbsp;&nbsp;
	      	                   <input type="radio" name="salrsType" value="4" onclick="cleanSalesArea();">隐形订做&nbsp;&nbsp;
	      	                   <input type="radio" name="salrsType" value="5" onclick="cleanSalesArea();">辅料&nbsp;&nbsp;
	      	               </TD>
                        </TR>
                        <TR goods8=goods8>
                           <TD height="26" class="table_body">销售类型</TD>
			               <TD class="table_none" colspan="5">
			                   <input type="radio" name="salrsType2" value="" checked="checked" >全部&nbsp;&nbsp;
	      	                   <input type="radio" name="salrsType2" value="1" >框镜成品&nbsp;&nbsp;
	      	                   <input type="radio" name="salrsType2" value="2" >框镜订做&nbsp;&nbsp;
	      	                   <input type="radio" name="salrsType2" value="3" >隐形成品&nbsp;&nbsp;
	      	                   <input type="radio" name="salrsType2" value="4" >隐形订做&nbsp;&nbsp;
	      	                   <input type="radio" name="salrsType2" value="5" >辅料&nbsp;&nbsp;
	      	               </TD>
                        </TR>
                        <TR   id="isCustomize2"  inithide=inithide>
                           <TD height="26" class="table_body">镜片分类</TD>
			               <TD class="table_none" colspan="5">
			               	   <input type="radio" id="isCustomize2" name="isCustomize2" value=""  checked/>全部&nbsp;
			               	   <input type="radio" id="isCustomize2" name="isCustomize2" value="0"/>成品&nbsp;
			               	   <input type="radio" id="isCustomize2" name="isCustomize2" value="D"/>订做&nbsp;
	      	               </TD>
                        </TR>
                        <TR shopshow="shopshow">
			               <TD width="12%" height="26" class="table_body" >查询日期</TD>
			               <TD class="table_none" colspan="5" >
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime2"/> 
                                    <jsp:param name="toDate" value="endTime2"/>             
                               </jsp:include>
			               </TD>
			               </TR>
			               <TR shopshow2="shopshow2">
			               <TD width="12%" height="26" class="table_body" >日期查看方式</TD>
			               <TD class="table_none" colspan="5">
			               	   <input type="radio" id="searchtype5"  name="searchtype5" value="1" onclick="isShowShowType5(this)" checked/>按时间段选择&nbsp;&nbsp;
	      	                   <input type="radio" id="searchtype5"  name="searchtype5" value="2" onclick="isShowShowType5(this)"/>按年月选择&nbsp;&nbsp;
			               </TD>
			               </TR>
			               <TR shopshow333="shopshow333">
			               <TD width="12%" height="26" class="table_body" >本期日期</TD>
			               <TD class="table_none" colspan="5">
                                <jsp:include page="/commons/report_date4.jsp" flush="true">
                                    <jsp:param name="fromDate" value="begindate"/> 
                                    <jsp:param name="toDate" value="enddate"/>             
                               </jsp:include>
			               </TD>
			               </TR>
			               <TR shopshow333="shopshow333">
			               <TD width="12%" height="26" class="table_body" >同期日期</TD>
			               <TD class="table_none" colspan="5">
                               <jsp:include page="/commons/report_date4.jsp" flush="true">
                                    <jsp:param name="fromDate" value="begindate2"/> 
                                    <jsp:param name="toDate" value="enddate2"/>             
                               </jsp:include>
			               </TD>
			               </TR>
			               <TR shopshow222="shopshow222">
			               <TD width="12%" height="26" class="table_body" >本期日期</TD>
			               <TD class="table_none" colspan="5">
                           <select id="bqyear" name="bqyear" onchange="selectBqYear(this)">
                            	<option value="">----请选择----</option>
                            	<c:forEach var="po" items="${yearList}">
                            		<option  value="${po.year }">${po.year }</option>
                            	</c:forEach>

                            </select>年&nbsp;&nbsp;&nbsp;&nbsp;
                            <span id="shBqmonth">
                            <select id="bqmonth" name="bqmonth">
                            	<option value="">----请选择----</option>
                            	    <option  value="01">1</option>
                            		<option  value="02">2</option>
                            		<option  value="03">3</option>
                            		<option  value="04">4</option>
                            		<option  value="05">5</option>
                            		<option  value="06">6</option>
                            		<option  value="07">7</option>
                            		<option  value="08">8</option>
                            		<option  value="09">9</option>
                            		<option  value="10">10</option>
                            		<option  value="11">11</option>
                            		<option  value="12">12</option>
                            </select><select id="bqmonth11" name="bqmonth11">
                            <option value="">----请选择----</option>
	                            <c:forEach var="po" items="${monthList}">
	                            		<option  value="${po.month }">${po.month1 }</option>
	                            	</c:forEach>
                            </select> 
                                                                       月&nbsp;&nbsp;&nbsp;&nbsp;
                                                                           至&nbsp;&nbsp;&nbsp;&nbsp;
                            <select id="bqmonth2" name="bqmonth2">
                            	<option value="">----请选择----</option>
                            	    <option  value="01">1</option>
                            		<option  value="02">2</option>
                            		<option  value="03">3</option>
                            		<option  value="04">4</option>
                            		<option  value="05">5</option>
                            		<option  value="06">6</option>
                            		<option  value="07">7</option>
                            		<option  value="08">8</option>
                            		<option  value="09">9</option>
                            		<option  value="10">10</option>
                            		<option  value="11">11</option>
                            		<option  value="12">12</option>
                            </select><select id="bqmonth22" name="bqmonth22">
                             <option value="">----请选择----</option>
	                            <c:forEach var="po" items="${monthList}">
	                            		<option  value="${po.month }">${po.month1 }</option>
	                            	</c:forEach>
                            </select> 
                            	月</span>
			               </TD>
			               </TR>
			               <TR shopshow222="shopshow222">
			               <TD width="12%" height="26" class="table_body" >同期日期</TD>
			               <TD class="table_none" colspan="5">
                           <select id="tqyear" name="tqyear" onchange="selectTqYear(this)">
                            	<option value="">----请选择----</option>
                            	<c:forEach var="po" items="${yearList}">
                            		<option  value="${po.year }">${po.year }</option>
                            	</c:forEach>

                            </select>年&nbsp;&nbsp;&nbsp;&nbsp;
                            <span id="shTqmonth">
                            <select id="tqmonth" name="tqmonth">
                            	<option value="">----请选择----</option>
                            	    <option  value="01">1</option>
                            		<option  value="02">2</option>
                            		<option  value="03">3</option>
                            		<option  value="04">4</option>
                            		<option  value="05">5</option>
                            		<option  value="06">6</option>
                            		<option  value="07">7</option>
                            		<option  value="08">8</option>
                            		<option  value="09">9</option>
                            		<option  value="10">10</option>
                            		<option  value="11">11</option>
                            		<option  value="12">12</option>
                            </select><select id="tqmonth11" name="tqmonth11">
                             <option value="">----请选择----</option>
	                            <c:forEach var="po" items="${monthList}">
	                            		<option  value="${po.month }">${po.month1 }</option>
	                            	</c:forEach>
                            </select>
                            	月&nbsp;&nbsp;&nbsp;&nbsp;
                                                                            至&nbsp;&nbsp;&nbsp;&nbsp;
                            <select id="tqmonth2" name="tqmonth2">
                            	<option value="">----请选择----</option>
                            	    <option  value="01">1</option>
                            		<option  value="02">2</option>
                            		<option  value="03">3</option>
                            		<option  value="04">4</option>
                            		<option  value="05">5</option>
                            		<option  value="06">6</option>
                            		<option  value="07">7</option>
                            		<option  value="08">8</option>
                            		<option  value="09">9</option>
                            		<option  value="10">10</option>
                            		<option  value="11">11</option>
                            		<option  value="12">12</option>
                            </select><select id="tqmonth22" name="tqmonth22">
                             <option value="">----请选择----</option>
	                            <c:forEach var="po" items="${monthList}">
	                            		<option  value="${po.month }">${po.month1 }</option>
	                            	</c:forEach>
                            </select>月</span>
			               </TD>
			               </TR>
			               
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
					  	<TR >
					  	   <TD width="12%" height="26" class="table_body">销售门店</TD>
			               <TD class="table_none" width="27%" colspan="5">
			               
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
						  </TR>
		            <TR showtype6="showtype6">
			               <TD width="12%" height="26" class="table_body" >营业员工号</TD>
			               <TD class="table_none" >
                              <input id="salerID2" type="text" name="salerID2"  />
			               </TD>
			               <TD width="12%" height="26" class="table_body" >营业员姓名</TD>
			               <TD class="table_none" colspan="3">
                              <input id="salerName2" type="text" name="salerName2"  />
			               </TD>
			            </TR>
			            <TR showtype7="showtype7">
			               <TD width="12%" height="26" class="table_body" >验光师工号</TD>
			               <TD class="table_none" >
                              <input id="optometryID2" type="text" name="optometryID2"  />
			               </TD>
			               <TD width="12%" height="26" class="table_body" >验光师姓名</TD>
			               <TD class="table_none" colspan="3">
                              <input id="optometryName2" type="text" name="optometryName2"  />
			               </TD>
			            </TR>

			               <TR shopshow22="shopshow22">
			               <TD width="12%" height="26" class="table_body" >显示信息</TD>
			               <TD class="table_none" colspan="5">
			               	   <input type="checkbox" name="ygs2" id ="ygs2" value="1" checked/>验光数&nbsp;&nbsp;

			               	   <input type="checkbox" name="sss2" id ="sss2" value="1" checked/>销售数&nbsp;&nbsp;

			               	   <input type="checkbox" name="sse2" id ="sse2" value="1" checked/>销售额&nbsp;&nbsp;
                             <c:if test="${permissionPo.keyc=='1'}">
			               	   <input type="checkbox" name="cb2" id ="cb2" value="1" checked/>成本&nbsp;&nbsp;
			               	   <input type="checkbox" name="ml2" id ="ml2" value="1" checked/>毛利&nbsp;&nbsp;
			               	    <input type="checkbox" name="mll2" id ="mll2" value="1" checked/>毛利率&nbsp;&nbsp;
                             </c:if>
			               </TD>
			               </TR>  
			               
			            <TR goods44=goods44>
			               <TD width="12%" height="26" class="table_body" >价格区间</TD>
			               <TD class="table_none" colspan="5" >
				               <li class="horizontal_onlyRight">
							   		<textarea class="text_input200" id="ds2"  name="ds2" style='height:50px;width: 300px' readonly="readonly" value=""></textarea>							   		
							   		<input class="text_input100" type="hidden" id="salesArea" name="salesArea" value=""/>
							   </li>
							   <li class="horizontal_onlyRight">						  		
							  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openAmount();">
							   </li>
			               </TD>
			               </TR>   
                        <TR goods=goods>
                           <TD class="table_body">显示门店明细</TD>
			               <TD class="table_none">
                               <input type="radio" id="shopcol2" name="shopcol2"  value="1"/>显示
                               <input type="radio" id="shopcol2" name="shopcol2" checked value=""/>不显示
			               </TD>
						   <TD height="26" class="table_body">查看样式</TD>
			               <TD class="table_none" colspan="3">
			                 <a style="display: none;" id="showtype">
			               	 <select id="xory" name="xory">
      		                   <option value="x">按门店横向方式</option>
				               <option value="y">按门店纵向方式</option>
				               <option value="z">按门店分组方式</option>
      	                     </select>
      	                     </a>&nbsp;
			               </TD>
                        </TR>
                       <TR goods44=goods44>
                           <TD class="table_body">显示门店/区间明细</TD>
			               <TD class="table_none">
                               <input type="radio" id="shopcol22" name="shopcol22"  value="1"/>显示
                               <input type="radio" id="shopcol22" name="shopcol22" checked value=""/>不显示
			               </TD>
						   <TD height="26" class="table_body">查看样式</TD>
			               <TD class="table_none" colspan="3">
			               	 <select id="xory2" name="xory2">
      		                   <option value="x">按门店横向方式</option>
				               <option value="y">按门店纵向方式</option>
				               <option value="xx">按日期横向方式</option>
				               <option value="yy">按日期纵向方式</option>
      	                     </select>
      	                     </a>&nbsp;
			               </TD>
                        </TR>
                        <TR goods4=goods4>
                           <TD class="table_body">查看方式</TD>
			               <TD class="table_none" colspan="5">
                               <input type="radio" id="isShowType2" name="isShowType2"  value="1" checked/>按零售价格区间
                               <input type="radio" id="isShowType2" name="isShowType2"  value="2"/>按实际销售价格区间
			               </TD>
                        </TR>
                        <TR goodsss=goodsss>
                           <TD height="26" class="table_body">显示信息</TD>
			               <TD class="table_none" colspan="5">
			               	   <input type="checkbox" name="salesnumcol2" id ="salesnumcol2" value="1" />销退数量&nbsp;&nbsp;
			               	   <input type="checkbox" name="salesmoneycol2" id ="salesmoneycol2" value="1" />销退金额&nbsp;&nbsp;
			               	   <input type="checkbox" name="moneyratecol2" id ="moneyratecol2" value="1" />数量/金额占比&nbsp;&nbsp;
			               	   <c:if test="${permissionPo.keyc=='1'}">
			               	   <input type="checkbox" name="costmoneycol2" id ="costmoneycol2" value="1" />成本金额&nbsp;&nbsp;
			               	   <input type="checkbox" name="costmoneyratecol2" id ="costmoneyratecol2" value="1" />成本占比&nbsp;&nbsp;
			               	   <input type="checkbox" name="zmoneycol2" id ="zmoneycol2" value="1" checked/>毛利金额&nbsp;&nbsp;
			               	   <input type="checkbox" name="zmoneyratecol2" id ="zmoneyratecol2" value="1" checked/>销售毛利率&nbsp;&nbsp;
			               	   </c:if>
	      	               </TD>
                        </TR>
                        <c:if test="${permissionPo.keyc=='1'}">
                        <tr goodss=goodss>
                           <TD height="26" class="table_body">销售成本</TD>
			               <TD  class="table_none" colspan="5">
			                 <input type="radio" name="salesCost" value="1" checked/>含税成本
			                 <input type="radio" name="salesCost" value="2"/>不含税成本
			                 <input type="radio" name="salesCost" value="3"/>加权平均成本
			               </TD>
						</tr>
						</c:if>
                        <tr package=package>
                           <TD height="26" class="table_body">套餐查看方式</TD>
			               <TD  class="table_none" colspan="5">
			                 <input type="radio" name="typeID" value="1" checked/>按商品
			                 <input type="radio" name="typeID" value="2"/>按人次
			               </TD>
						</tr>
                        <tr package=package>
                           <TD height="26" class="table_body">套餐名称</TD>
			               <TD  class="table_none">
				               <li class="horizontal_onlyRight">
							   	 <input class="text_input160" id="MealName2" name="MealName2" type="text" />
							   	 <input class="text_input100" type="hidden" id="MealID2" name="MealID2" value=""/>
							   </li>
							   <li class="horizontal_onlyRight">
							  	 <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openSetMeal();">
							   </li>
			               </TD>
                           <TD class="table_body">套餐分类</TD>
			               <TD class="table_none" colspan="3">
			                 <input type="radio" id="ClassifyID2" name="ClassifyID2" value="" checked/>全部
			                 <input type="radio" id="ClassifyID2" name="ClassifyID2" value="1"/>框镜销售
			                 <input type="radio" id="ClassifyID2" name="ClassifyID2" value="2"/>隐形销售
			                 <input type="radio" id="ClassifyID2" name="ClassifyID2" value="3"/>辅料销售
			               </TD>
						</tr>
                        
                        <tr goods=goods>
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
			               <TD class="table_none"><input sid="4" type="text" class="text_input160" maxlength="22" id="goodsCode2" name="goodsCode2"/></TD>
						</tr>
						<tr goods=goods>
						   <TD height="26" class="table_body">商品名称</TD>
			               <TD class="table_none"><input type="text" class="text_input160" maxlength="20" id="goodsName2" name="goodsName2"/></TD>
			               <TD height="26" class="table_body">标准零售价区间</TD>
			               <TD class="table_none" colspan=3>
								<input class="text_input60" type="text" id="bgnretailamount2" name="bgnretailamount2" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写销售金额！'}]"/> 至 
								<input class="text_input60" type="text" id="endretailamount2" name="endretailamount2" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写销售金额！'}]"/>
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
					<div class="reportHelp" id="goods">												
                       1.查询分类选取【按制造商】或【按商品品种】查看报表时，如果需要重新汇总数据，可以进入【定时任务维护】模块，通过【日销售商品明细】这个定时任务重新汇总数据。<br/>
					</div>
					<div class="reportHelp" id="xsdb">
                       1.查询分类选取【按商品类别】查看报表时，如果需要重新汇总数据，可以进入【定时任务维护】模块，通过【日销售汇总(商品类型)】这个定时任务重新汇总数据。<br/>
                       2.查询分类选取【按门店】查看报表时，如果需要重新汇总数据，可以进入【定时任务维护】模块，通过【日销售汇总】这个定时任务重新汇总数据。<br/>
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

