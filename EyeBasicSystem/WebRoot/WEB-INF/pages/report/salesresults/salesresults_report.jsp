<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售业绩表</title>
<script type='text/javascript' src='${ctx }/js/currentDate.js'></script>
</head>
<script>
	function search(){
		createForm();
		var companyid=$('#companysid').val();
				
		$('input[name=companyid]').get(0).value = companyid;
		$('input[name=logincompanyid]').get(0).value = '${person.personcompanyid}';
		var ShopCode = $('#departmentID').val();
		if(ShopCode == ''){
			ShopCode = $("#dids").val();
		}
		
		var beginTime = document.all.startTime2.value;
		var endTime = document.all.endTime2.value;
		var isShow = $('input[name=isShow2]:checked').val();
		var queryClassify = $('input[name=queryClassify]:checked').val();
		var departmentNames = EncodeUtf8($("#ds").val());
		if(departmentNames == ''){
			departmentNames = EncodeUtf8($("#dnames").val());
		}
		
		var customAmountForm = $('input[name=customAmountForm]:checked').val();
		var salesType = $('input[name=salesType2]:checked').val();
		var showCompanyName = $('input[name=showCompanyName2]:checked').val();
		
		if(queryClassify == "" || queryClassify == null){
			alert('请选择查询分类!');
			return false;
		}
		var salesID2 =  $('#salesID2').val();      
		if(beginTime==""){
			if(salesID2!='' && queryClassify=='2'){
				}else{
					alert('请选择开始日期!');
					document.getElementById("startTime2").focus();
					return false;
				}

		}
		if(endTime==""){
			if(salesID2!='' && queryClassify=='2'){
			}else{
			alert('请选择截止日期!');
			document.getElementById("endTime2").focus();
			return false;
			}
		}

		var customAmountText = '';
        switch(customAmountForm){
        case '1':
        	customAmountText = '订金按应收金额计入结款日收入,商品金额计入结款日收入';
            break;
        case '2':
        	customAmountText = '订金按应收金额计入补齐日收入,商品金额计入补齐日收入';
            break;
        case '3':
        	customAmountText = '订金结款日收入,补齐金额计入补齐日收入,商品金额计入结款日收入';
            break;  
        default:
	        return;
        }

        var salesTypeText = '';
        switch(salesType){
        case '':
        	salesTypeText = '全部';
            break;
        case '1':
        	salesTypeText = '销售';
            break;
        case '2':
        	salesTypeText = '退货';
            break;  
        default:
	        return;
        }        
        
		if (departmentNames == ''){
			departmentNames = '所有部门'
		}
		
        var reportUrl = "&ShopCode="+ShopCode+"&departmentNames="+EncodeUtf8(departmentNames)+"&beginTime="+beginTime+"&endTime="+endTime+"&isShow="+isShow+"&showCompanyName="+showCompanyName;

        $('input[id=ShopCode]').get(0).value = ShopCode;
        $('input[name=departmentNames]').get(0).value = departmentNames;
        $('input[id=beginTime]').get(0).value = beginTime;
        $('input[id=endTime]').get(0).value = endTime;
        $('input[name=isShow]').get(0).value = isShow;
        $('input[name=showCompanyName]').get(0).value = showCompanyName;
        $('input[name=salesType]').get(0).value = salesType;
		var salesGoodsType = $('input[name=salesGoodsType2]:checked').val();
		
		var reportName = '';
		var reportParem = '';
		var formAction = '';
        switch(queryClassify){
	        case '1':// 按商品
	        	reportParem = "&customAmountText="+EncodeUtf8(customAmountText)+"&salesTypeText="+EncodeUtf8(salesTypeText);
	        	var fxjd = $('input[name=fxjd]:checked').val();
	        	var fztj = $('input[name=fztj]:checked').val();
	        	
	            $('input[name=customAmountText]').get(0).value = customAmountText;  
	            $('input[name=salesTypeText]').get(0).value = salesTypeText; 

	            if(fxjd == '1'){
		            if (fztj == '1'){
			            if (customAmountForm == '1'){ 
				            if(salesType == '1'){
				            	reportName = "sales_dayMonthNotTuiQTRpt.cpt";
				            	formAction = "sp11";
					         }else if(salesType == '2'){
					            reportName = "sales_dayMonthTuiQTRpt.cpt";
					            formAction = "sp12";
						     }else if(salesType == ''){
					            reportName = "sales_dayMonthQTRpt.cpt";
					            formAction = "sp13";  
							 } 
			            }else if (customAmountForm == '2'){
				            if(salesType == '1'){
				            	reportName = "sales_dayMonthNotTuiQTByArrearsRpt.cpt";
				            	formAction = "sp21";
					         }else if(salesType == '2'){
					            reportName = "sales_dayMonthTuiQTRpt.cpt";
					            formAction = "sp22";
						     }else if(salesType == ''){
					            reportName = "sales_dayMonthArrearsAppendByQTRpt.cpt";
					            formAction = "sp23";  
							 } 
			            }else if (customAmountForm == '3'){
				            if(salesType == '1'){
				            	reportName = "sales_dayMonthNotTuiQT2Rpt.cpt";
				            	formAction = "sp31";
					         }else if(salesType == '2'){
					            reportName = "sales_dayMonthTuiQTRpt.cpt";
					            formAction = "sp32";
						     }else if(salesType == ''){
					            reportName = "sales_dayMonthQT2Rpt.cpt";
					            formAction = "sp33";  
							 } 
			            }
			        }else{
			            if (customAmountForm == '1'){ 
				            if(salesType == '1'){
				            	reportName = "dayMonth_nosupplier/sales_dayMonthNotTuiQTRpt.cpt";
				            	formAction = "sp111";
					         }else if(salesType == '2'){
					            reportName = "dayMonth_nosupplier/sales_dayMonthTuiQTRpt.cpt";
					            formAction = "sp112";
						     }else if(salesType == ''){
					            reportName = "dayMonth_nosupplier/sales_dayMonthQTRpt.cpt";
					            formAction = "sp113";  
							 } 
			            }else if (customAmountForm == '2'){
				            if(salesType == '1'){
				            	reportName = "dayMonth_nosupplier/sales_dayMonthNotTuiQTByArrearsRpt.cpt";
				            	formAction = "sp121";
					         }else if(salesType == '2'){
					            reportName = "dayMonth_nosupplier/sales_dayMonthTuiQTRpt.cpt";
					            formAction = "sp122";
						     }else if(salesType == ''){
					            reportName = "dayMonth_nosupplier/sales_dayMonthArrearsAppendByQTRpt.cpt";
					            formAction = "sp123";  
							 } 
			            }else if (customAmountForm == '3'){
				            if(salesType == '1'){
				            	reportName = "dayMonth_nosupplier/sales_dayMonthNotTuiQT2Rpt.cpt";
				            	formAction = "sp131";
					         }else if(salesType == '2'){
					            reportName = "dayMonth_nosupplier/sales_dayMonthTuiQTRpt.cpt";
					            formAction = "sp132";
						     }else if(salesType == ''){
					            reportName = "dayMonth_nosupplier/sales_dayMonthQT2Rpt.cpt";
					            formAction = "sp133";  
							 } 
			            }
				    }
		        }else{
		        	if (fztj == '1'){
			            if (customAmountForm == '1'){ 
				            if(salesType == '1'){
				            	reportName = "sales_dayMonthNotTuiQTRpt2.cpt";
				            	formAction = "sp112";
					         }else if(salesType == '2'){
					            reportName = "sales_dayMonthTuiQTRpt2.cpt";
					            formAction = "sp122";
						     }else if(salesType == ''){
					            reportName = "sales_dayMonthQTRpt2.cpt";
					            formAction = "sp132";  
							 } 
			            }else if (customAmountForm == '2'){
				            if(salesType == '1'){
				            	reportName = "sales_dayMonthNotTuiQTByArrearsRpt2.cpt";
				            	formAction = "sp212";
					         }else if(salesType == '2'){
					            reportName = "sales_dayMonthTuiQTRpt2.cpt";
					            formAction = "sp222";
						     }else if(salesType == ''){
					            reportName = "sales_dayMonthArrearsAppendByQTRpt2.cpt";
					            formAction = "sp232";  
							 } 
			            }else if (customAmountForm == '3'){
				            if(salesType == '1'){
				            	reportName = "sales_dayMonthNotTuiQT2Rpt2.cpt";
				            	formAction = "sp312";
					         }else if(salesType == '2'){
					            reportName = "sales_dayMonthTuiQTRpt2.cpt";
					            formAction = "sp322";
						     }else if(salesType == ''){
					            reportName = "sales_dayMonthQT2Rpt2.cpt";
					            formAction = "sp332";  
							 } 
			            }
			        }else{
			            if (customAmountForm == '1'){ 
				            if(salesType == '1'){
				            	reportName = "dayMonth_nosupplier/sales_dayMonthNotTuiQTRpt2.cpt";
				            	formAction = "sp1122";
					         }else if(salesType == '2'){
					            reportName = "dayMonth_nosupplier/sales_dayMonthTuiQTRpt2.cpt";
					            formAction = "sp1222";
						     }else if(salesType == ''){
					            reportName = "dayMonth_nosupplier/sales_dayMonthQTRpt2.cpt";
					            formAction = "sp1322";  
							 } 
			            }else if (customAmountForm == '2'){
				            if(salesType == '1'){
				            	reportName = "dayMonth_nosupplier/sales_dayMonthNotTuiQTByArrearsRpt2.cpt";
				            	formAction = "sp2122";
					         }else if(salesType == '2'){
					            reportName = "dayMonth_nosupplier/sales_dayMonthTuiQTRpt2.cpt";
					            formAction = "sp2222";
						     }else if(salesType == ''){
					            reportName = "dayMonth_nosupplier/sales_dayMonthArrearsAppendByQTRpt2.cpt";
					            formAction = "sp2322";  
							 } 
			            }else if (customAmountForm == '3'){
				            if(salesType == '1'){
				            	reportName = "dayMonth_nosupplier/sales_dayMonthNotTuiQT2Rpt2.cpt";
				            	formAction = "sp3122";
					         }else if(salesType == '2'){
					            reportName = "dayMonth_nosupplier/sales_dayMonthTuiQTRpt2.cpt";
					            formAction = "sp3222";
						     }else if(salesType == ''){
					            reportName = "dayMonth_nosupplier/sales_dayMonthQT2Rpt2.cpt";
					            formAction = "sp3322";  
							 } 
			            }
				    }
			    }
      
	            break;
	        case '2':      // 按配镜单
	        	reportParem = "&customAmountText="+EncodeUtf8(customAmountText)+"&salesTypeText="+EncodeUtf8(salesTypeText);

	            $('input[name=customAmountText]').get(0).value = customAmountText;  
	            $('input[name=salesTypeText]').get(0).value = salesTypeText; 

	    		var intransittype =  $('#intransittypet').val();
	    		var intransit =  $('#intransitt').val();
	    		var intransittype2 =  $('#intransittypet2').val();
	    		var intransit2 =  $('#intransitt2').val();
	    		var salesID =  $('#salesID2').val();
	    		var isCustomize =  $('input[name=isCustomize2]:checked').val();
	    		var paystatus =  $('input[name=paystatus2]:checked').val();
	    		//var billType =  $('input[name=billType2]:checked').val();
	            var billType =[];    
	            $('input[name="billType2"]:checked').each(function(){    
	            	billType.push($(this).val());    
	            });
	            if(billType ==''){
	            	billType='1,2,3,4,5';
			    }

	    		var customerID =  $('#customerID2').val();
	    		var customerName =  $('#customerName2').val();
	    		var customerPhone =  $('#customerPhone2').val();
	    		var bgnamount =  $('#bgnamount2').val();
	    		var endamount =  $('#endamount2').val();
	    		var bgnzkamount =  $('#bgnzkamount2').val();
	    		var endzkamount =  $('#endzkamount2').val();
	    		var salerID =  $('#salerID2').val();
	    		var posID =  $('#posID2').val();
	    		var goodsCategoryID =  $('input[id=goodscategoryID2]:checked').val();
	    		//var supplierID =  $('#supplierID2').val();
	    		//var bandID =  $('#brandID2').val();
	    		var goodsID =  $('#goodsID2').val();
	    		var goodsName =  $('#goodsName2').val();
	    		var bgispecjj =  $('#bgispecjj2').val();
	    		var bgicolorjj =  $('#bgicolorjj2').val();
	    		var bgiframesizejj =  $('#bgiframesizejj2').val();
	    		var bgieyeglassmaterialtypejp =  $('#bgieyeglassmaterialtypejp2').val();
	    		var bgirefractivejp =  $('#bgirefractivejp2').val();
	    		var bgiismutiluminosityjp =  $('#bgiismutiluminosityjp2').val();
	    		var minSphjp =  $('#minSphjp2').val();
	    		var maxSphjp =  $('#maxSphjp2').val();
	    		var minCyljp =  $('#minCyljp2').val();
	    		var maxCyljp =  $('#maxCyljp2').val();
	    		var bgiusetypeyj =  $('#bgiusetypeyj2').val();
	    		var bgistealthclassyj =  $('#bgistealthclassyj2').val();
	    		var minSphyj =  $('#minSphyj2').val();
	    		var maxSphyj =  $('#maxSphyj2').val();
	    		var minCylyj =  $('#minCylyj2').val();
	    		var maxCylyj =  $('#maxCylyj2').val();
	    		var minSphlh =  $('#minSphlh2').val();
	    		var maxSphlh =  $('#maxSphlh2').val();
	    		var bgiothergoodsbigclass =  $('#bgiothergoodsbigclass2').val();
	    		var setmealType = $('input[id=setmealType2]:checked').val(); 
	    		var setmealName = $('#setmealName2').val();
	    		var issetmeal = $('input[id=issetmeal2]:checked').val(); 

	    		var ordersTypeFlag = $("#ordersTypeFlag2:checked").val();
	    		var priceSumFlag = $("#priceSumFlag2:checked").val();
	    		var discountNumFlag = $("#discountNumFlag2:checked").val();
	    		var salesValueFlag = $("#salesValueFlag2:checked").val();
	    		var psalsvalueFlag = $("#psalsvalueFlag2:checked").val();
	    		var integralFlag = $("#integralFlag2:checked").val();
	    		var arrearsValueFlag = $("#arrearsValueFlag2:checked").val();
	    		var xjFlag = $("#xjFlag2:checked").val();
	    		var czkFlag = $("#czkFlag2:checked").val();
	    		var jfFlag = $("#jfFlag2:checked").val();
	    		var yhkFlag = $("#yhkFlag2:checked").val();
	    		var djqFlag = $("#djqFlag2:checked").val();
	    		var setMealNameFlag = $("#setMealNameFlag2:checked").val();
	    		var memberNameFlag = $("#memberNameFlag2:checked").val();
	    		var customerNameFlag = $("#customerNameFlag2:checked").val();
	    		var phoneFlag = $("#phoneFlag2:checked").val();
	    		var ygpersonFlag = $("#ygpersonFlag2:checked").val();
	    		var salerIDFlag = $("#salerIDFlag2:checked").val();
	    		var posIDFlag = $("#posIDFlag2:checked").val();
	    		var posDateFlag = $("#posDateFlag2:checked").val();
	    		var tpersonFlag = $("#tpersonFlag2:checked").val();
	    		var tDateFlag = $("#tDateFlag2:checked").val();
	    		var djValueFlag = $("#djValueFlag2:checked").val();
	    		var bgnzk = $('#bgnzk2').val();
	    		var endzk = $('#endzk2').val();
	    		var zklFlag = $("#zklFlag2:checked").val();
	    		var lyFlag = $("#lyFlag2:checked").val();
	    		var iscontain=$('input[name=iscontain2]:checked').val();
	    		var isShowType=$('input[name=isShowType2]:checked').val();
	    		var isSalesPrice=$('input[name=isSalesPrice2]:checked').val();
	    		
	            $('input[name=intransittype]').get(0).value = intransittype; 
	            $('input[name=intransit]').get(0).value = intransit; 
	            $('input[name=intransittype2]').get(0).value = intransittype2; 
	            $('input[name=intransit2]').get(0).value = intransit2; 
	            $('input[name=salesID]').get(0).value = salesID; 
	            $('input[name=paystatus]').get(0).value = paystatus; 
	            $('input[name=billType]').get(0).value = billType; 
	            $('input[name=customerID]').get(0).value = customerID; 
	            $('input[name=customerName]').get(0).value = customerName; 
	            $('input[name=customerPhone]').get(0).value = customerPhone; 
	            $('input[name=bgnamount]').get(0).value = bgnamount; 
	            $('input[name=endamount]').get(0).value = endamount; 
	            $('input[name=bgnzkamount]').get(0).value = bgnzkamount; 
	            $('input[name=endzkamount]').get(0).value = endzkamount; 
	            $('input[name=salerID]').get(0).value = salerID; 
	            $('input[name=posID]').get(0).value = posID; 
	            $('input[name=goodsCategoryID]').get(0).value = goodsCategoryID; 
	            //$('input[name=supplierID]').get(0).value = supplierID; 
	            //$('input[name=bandID]').get(0).value = bandID; 
	            $('input[name=goodsID]').get(0).value = goodsID; 
	            $('input[name=goodsName]').get(0).value = goodsName; 
	            $('input[name=bgispecjj]').get(0).value = bgispecjj; 
	            $('input[name=bgicolorjj]').get(0).value = bgicolorjj; 
	            $('input[name=bgiframesizejj]').get(0).value = bgiframesizejj; 
	            $('input[name=bgieyeglassmaterialtypejp]').get(0).value = bgieyeglassmaterialtypejp; 
	            $('input[name=bgirefractivejp]').get(0).value = bgirefractivejp; 
	            $('input[name=bgiismutiluminosityjp]').get(0).value = bgiismutiluminosityjp; 
	            $('input[name=minSphjp]').get(0).value = minSphjp; 
	            $('input[name=maxSphjp]').get(0).value = maxSphjp; 
	            $('input[name=minCyljp]').get(0).value = minCyljp; 
	            $('input[name=maxCyljp]').get(0).value = maxCyljp; 
	            $('input[name=bgiusetypeyj]').get(0).value = bgiusetypeyj; 
	            $('input[name=bgistealthclassyj]').get(0).value = bgistealthclassyj; 
	            $('input[name=minSphyj]').get(0).value = minSphyj; 
	            $('input[name=maxSphyj]').get(0).value = maxSphyj; 
	            $('input[name=minCylyj]').get(0).value = minCylyj; 
	            $('input[name=maxCylyj]').get(0).value = maxCylyj; 
	            $('input[name=minSphlh]').get(0).value = minSphlh; 
	            $('input[name=maxSphlh]').get(0).value = maxSphlh; 
	            $('input[name=bgiothergoodsbigclass]').get(0).value = bgiothergoodsbigclass;
	            $('input[name=setmealType]').get(0).value = setmealType;
	            $('input[name=setmealName]').get(0).value = setmealName;
	            $('input[name=issetmeal]').get(0).value = issetmeal;

	            $('input[name=ordersTypeFlag]').get(0).value = ordersTypeFlag;
	            $('input[name=priceSumFlag]').get(0).value = priceSumFlag;
	            $('input[name=discountNumFlag]').get(0).value = discountNumFlag;
	            $('input[name=salesValueFlag]').get(0).value = salesValueFlag;
	            $('input[name=psalsvalueFlag]').get(0).value = psalsvalueFlag;
	            $('input[name=integralFlag]').get(0).value = integralFlag;
	            $('input[name=arrearsValueFlag]').get(0).value = arrearsValueFlag;
	            $('input[name=xjFlag]').get(0).value = xjFlag;
	            $('input[name=czkFlag]').get(0).value = czkFlag;
	            $('input[name=jfFlag]').get(0).value = jfFlag;
	            $('input[name=yhkFlag]').get(0).value = yhkFlag;
	            $('input[name=djqFlag]').get(0).value = djqFlag;
	            $('input[name=setMealNameFlag]').get(0).value = setMealNameFlag;
	            $('input[name=memberNameFlag]').get(0).value = memberNameFlag;
	            $('input[name=customerNameFlag]').get(0).value = customerNameFlag;
	            $('input[name=phoneFlag]').get(0).value = phoneFlag;
	            $('input[name=ygpersonFlag]').get(0).value = ygpersonFlag;
	            $('input[name=salerIDFlag]').get(0).value = salerIDFlag;
	            $('input[name=posIDFlag]').get(0).value = posIDFlag;
	            $('input[name=posDateFlag]').get(0).value = posDateFlag;
	            $('input[name=tpersonFlag]').get(0).value = tpersonFlag;
	            $('input[name=tDateFlag]').get(0).value = tDateFlag;
	            $('input[name=djValueFlag]').get(0).value = djValueFlag;
	            $('input[name=bgnzk]').get(0).value = bgnzk;
	            $('input[name=endzk]').get(0).value = endzk;
	            $('input[name=isCustomize]').get(0).value = isCustomize;
	            
	            $('input[name=zklFlag]').get(0).value = zklFlag;
	            $('input[name=lyFlag]').get(0).value = lyFlag;
	            $('input[name=iscontain]').get(0).value = iscontain;
	            $('input[name=isShowType]').get(0).value = isShowType;
	            $('input[name=isSalesPrice]').get(0).value = isSalesPrice;


	            if(intransit==''){
	            	$('input[name=intransittype]').get(0).value=''; 
	            	intransittype=''; 
		        }
	            if(intransit2==''){
	            	$('input[name=intransittype2]').get(0).value=''; 
	            	intransittype2=''; 
		        }
	    		
	            reportParem=reportParem+"&salesType="+salesType+"&paystatus="+paystatus+"&billType="+billType+"&goodsCategoryID="+goodsCategoryID+"&intransittype="+intransittype+"&intransit="+intransit+"&intransittype2="+intransittype2+"&intransit2="+intransit2; 	    		
	            reportParem=reportParem+"&salesID="+salesID+"&customerID="+customerID+"&customerName="+EncodeUtf8(customerName)+"&customerPhone="+customerPhone+"&bgnamount="+bgnamount+"&endamount="+endamount+"&bgnzkamount="+bgnzkamount+"&endzkamount="+endzkamount;
	            reportParem=reportParem+"&salerID="+salerID+"&posID="+posID+"&goodsID="+goodsID+"&goodsName="+EncodeUtf8(goodsName)+"&isCustomize="+isCustomize;
	            reportParem=reportParem+"&bgispecjj="+bgispecjj+"&bgicolorjj="+bgicolorjj+"&bgiframesizejj="+bgiframesizejj+"&bgieyeglassmaterialtypejp="+bgieyeglassmaterialtypejp;
	            reportParem=reportParem+"&bgirefractivejp="+bgirefractivejp+"&bgiismutiluminosityjp="+bgiismutiluminosityjp+"&minSphjp="+minSphjp+"&maxSphjp="+maxSphjp+"&minCyljp="+minCyljp+"&maxCyljp="+maxCyljp;
	            reportParem=reportParem+"&minSphlh="+minSphlh+"&maxSphlh="+maxSphlh+"&bgiothergoodsbigclass="+bgiothergoodsbigclass+"&setmealType="+setmealType+"&setmealName="+EncodeUtf8(setmealName)+"&issetmeal="+issetmeal;
	            reportParem=reportParem+"&ordersTypeFlag="+ordersTypeFlag+"&priceSumFlag="+priceSumFlag+"&discountNumFlag="+discountNumFlag+"&salesValueFlag="+salesValueFlag+"&psalsvalueFlag="+psalsvalueFlag+"&integralFlag="+integralFlag;
	            reportParem=reportParem+"&arrearsValueFlag="+arrearsValueFlag+"&xjFlag="+xjFlag+"&czkFlag="+czkFlag+"&jfFlag="+jfFlag+"&yhkFlag="+yhkFlag+"&djqFlag="+djqFlag+"&setMealNameFlag="+setMealNameFlag;
	            reportParem=reportParem+"&memberNameFlag="+memberNameFlag+"&customerNameFlag="+customerNameFlag+"&phoneFlag="+phoneFlag+"&ygpersonFlag="+ygpersonFlag+"&salerIDFlag="+salerIDFlag+"&posIDFlag="+posIDFlag;
	            reportParem=reportParem+"&posDateFlag="+posDateFlag+"&tpersonFlag="+tpersonFlag+"&tDateFlag="+tDateFlag+"&djValueFlag="+djValueFlag+"&bgnzk="+bgnzk+"&endzk="+endzk+"&zklFlag="+zklFlag+"&lyFlag="+lyFlag+"&iscontain="+iscontain;
	            
	            if (customAmountForm == '1'){
	            	if (isShowType == '1' && (salesType==''||salesType=='1')&&paystatus==''){ 
		            	reportName = "sales_salesForYJsumRpt.cpt";
		            	formAction = "pjd11s";
	            	}else{
		            	reportName = "sales_salesForYJRpt.cpt";
		            	formAction = "pjd11";
		            }

	            }else if (customAmountForm == '2'){
	            	if (isShowType == '1' && (salesType==''||salesType=='1')&&paystatus==''){ 
		            	reportName = "sales_salesForYJsumRpt2.cpt";
		            	formAction = "pjd21s";
	            	}else{
		            	reportName = "sales_salesForYJRpt2.cpt";
		            	formAction = "pjd21";
		            }

	            }else if (customAmountForm == '3'){
		            
		            if(paystatus == ''){
		            	if (isShowType == '1' && (salesType==''||salesType=='1')&&paystatus==''){ 
			            	reportName = "sales_salesForYJsumRpt3.cpt";
			            	formAction = "pjd3s";
		            	}else{
			            	reportName = "sales_salesForYJRpt3.cpt";
			            	formAction = "pjd3";
			            }

				    }else if(paystatus == '2'){
		            	reportName = "sales_salesForYJRpt31.cpt";
		            	formAction = "pjd31";
				    }else if(paystatus == '3'){
		            	reportName = "sales_salesForYJRpt32.cpt";
		            	formAction = "pjd312";

				    }else if(paystatus == '4'){
		            	reportName = "sales_salesForYJRpt33.cpt";
		            	formAction = "pjd313";

				    }else if(paystatus == '0'){
		            	reportName = "sales_salesForYJRpt34.cpt";
		            	formAction = "pjd314";

				    }else if(paystatus == '1'){
		            	reportName = "sales_salesForYJRpt34.cpt";
		            	formAction = "pjd315";
				    }



	            }      
	            break; 
	        case '3':     //  销售结款方式
	        	reportParem = "&customAmountText="+EncodeUtf8(customAmountText)+"&salesTypeText="+EncodeUtf8(salesTypeText);

	            $('input[name=customAmountText]').get(0).value = customAmountText;  
	            $('input[name=salesTypeText]').get(0).value = salesTypeText; 
	            
	    		var isTongJi = $('input[id=isTongJi2]:checked').val(); 
	    		$('input[name=isTongJi]').get(0).value = isTongJi;
	            //$('input[id=shopCode]').get(0).value = ShopCode;
	            
	            var jsxjFlag = $("#jsxjFlag2:checked").val();
	            var jsczFlag = $("#jsczFlag2:checked").val();
	            var jsjfFlag = $("#jsjfFlag2:checked").val();
	            var jsyhkFlag = $("#jsyhkFlag2:checked").val();
	            var jsdjqFlag = $("#jsdjqFlag2:checked").val();

	            var fxjFlag = $("#fxjFlag2:checked").val();
	            var countperfrom=$("#countperfrom2").val();

	            $('input[name=jsxjFlag]').get(0).value = jsxjFlag;
	            $('input[name=jsczFlag]').get(0).value = jsczFlag;
	            $('input[name=jsjfFlag]').get(0).value = jsjfFlag;
	            $('input[name=jsyhkFlag]').get(0).value = jsyhkFlag;
	            $('input[name=jsdjqFlag]').get(0).value = jsdjqFlag;
	            $('input[name=fxjFlag]').get(0).value = fxjFlag;
	            $('input[name=countperfrom]').get(0).value = countperfrom;

	            //alert($('input[name=countperfrom]').get(0).value);

	            reportParem=reportParem+"&shopCode="+ShopCode+"&isTongJi="+isTongJi+"&jsxjFlag="+jsxjFlag+"&jsczFlag="+jsczFlag+"&jsjfFlag="+jsjfFlag;
	            reportParem=reportParem+"&jsyhkFlag="+jsyhkFlag+"&jsdjqFlag="+jsdjqFlag+"&fxjFlag="+fxjFlag+"&countperfrom="+countperfrom;
	            
            	reportName = "sales_salesForTypeDetails.cpt";
            	formAction = "js11";
	        	
	            
	            break;	                                                                      
	        default:
		        return;
        }

		var DataURL = "report.action?reportlet=" + reportName +"&__bypagesize__=false" + reportUrl + reportParem ;
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{

			DataURL = "report.action?reportlet=" + reportName+"&__bypagesize__=false";
			queryReport(DataURL,formAction);

			return;
		}	

		document.getElementById('popupTitle').innerHTML="【 销售业绩表 】";
	}

	function createForm(){
		
		var rptFrm = document.createElement("form"); 
		rptFrm.id = "rptFrm";  
		rptFrm.method = "post"; 

	    var isTongJi = document.createElement("input");	     
	    isTongJi.type = "hidden";
	    isTongJi.name = "isTongJi";
	    isTongJi.value = '';	  
	    rptFrm.appendChild(isTongJi);    

	    var ShopCode = document.createElement("input");	     
	    ShopCode.type = "hidden";
	    ShopCode.id = "ShopCode";
	    ShopCode.name = "ShopCode";
	    ShopCode.value = '';	  
	    rptFrm.appendChild(ShopCode); 
	    
	    var beginTime = document.createElement("input");	     
	    beginTime.type = "hidden";
	    beginTime.id = "beginTime";
	    beginTime.name = "beginTime";
	    beginTime.value = '';	  
	    rptFrm.appendChild(beginTime); 
	    
	    var endTime = document.createElement("input");	     
	    endTime.type = "hidden";
	    endTime.id = "endTime";
	    endTime.name = "endTime";
	    endTime.value = '';	  
	    rptFrm.appendChild(endTime); 

	    var departmentNames = document.createElement("input");	     
	    departmentNames.type = "hidden";
	    departmentNames.name = "departmentNames";
	    departmentNames.value = '';	  
	    rptFrm.appendChild(departmentNames);  

	    var salesTypeText = document.createElement("input");	     
	    salesTypeText.type = "hidden";
	    salesTypeText.name = "salesTypeText";
	    salesTypeText.value = '';	  
	    rptFrm.appendChild(salesTypeText); 

	    var salesType = document.createElement("input");	     
	    salesType.type = "hidden";
	    salesType.name = "salesType";
	    salesType.value = '';	  
	    rptFrm.appendChild(salesType); 

	    var customAmountText = document.createElement("input");	     
	    customAmountText.type = "hidden";
	    customAmountText.name = "customAmountText";
	    customAmountText.value = '';	  
	    rptFrm.appendChild(customAmountText);    

	    var isShow = document.createElement("input");	     
	    isShow.type = "hidden";
	    isShow.name = "isShow";
	    isShow.value = '';	  
	    rptFrm.appendChild(isShow); 

	    var intransittype = document.createElement("input");	     
	    intransittype.type = "hidden";
	    intransittype.name = "intransittype";
	    intransittype.value = '';	  
	    rptFrm.appendChild(intransittype);

	    var intransittype2 = document.createElement("input");	     
	    intransittype2.type = "hidden";
	    intransittype2.name = "intransittype2";
	    intransittype2.value = '';	  
	    rptFrm.appendChild(intransittype2);

	    var intransit = document.createElement("input");	     
	    intransit.type = "hidden";
	    intransit.name = "intransit";
	    intransit.value = '';	  
	    rptFrm.appendChild(intransit);

	    var intransit2 = document.createElement("input");	     
	    intransit2.type = "hidden";
	    intransit2.name = "intransit2";
	    intransit2.value = '';	  
	    rptFrm.appendChild(intransit2);

	    var salesID = document.createElement("input");	     
	    salesID.type = "hidden";
	    salesID.name = "salesID";
	    salesID.value = '';	  
	    rptFrm.appendChild(salesID);

	    var paystatus = document.createElement("input");	     
	    paystatus.type = "hidden";
	    paystatus.name = "paystatus";
	    paystatus.value = '';	  
	    rptFrm.appendChild(paystatus); 

	    var billType = document.createElement("input");	     
	    billType.type = "hidden";
	    billType.name = "billType";
	    billType.value = '';	  
	    rptFrm.appendChild(billType);

	    var customerID = document.createElement("input");	     
	    customerID.type = "hidden";
	    customerID.name = "customerID";
	    customerID.value = '';	  
	    rptFrm.appendChild(customerID);

	    var customerName = document.createElement("input");	     
	    customerName.type = "hidden";
	    customerName.name = "customerName";
	    customerName.value = '';	  
	    rptFrm.appendChild(customerName);

	    var customerPhone = document.createElement("input");	     
	    customerPhone.type = "hidden";
	    customerPhone.name = "customerPhone";
	    customerPhone.value = '';	  
	    rptFrm.appendChild(customerPhone);

	    var bgnamount = document.createElement("input");	     
	    bgnamount.type = "hidden";
	    bgnamount.name = "bgnamount";
	    bgnamount.value = '';	  
	    rptFrm.appendChild(bgnamount);

	    var endamount = document.createElement("input");	     
	    endamount.type = "hidden";
	    endamount.name = "endamount";
	    endamount.value = '';	  
	    rptFrm.appendChild(endamount);

	    var bgnzkamount = document.createElement("input");	     
	    bgnzkamount.type = "hidden";
	    bgnzkamount.name = "bgnzkamount";
	    bgnzkamount.value = '';	  
	    rptFrm.appendChild(bgnzkamount);

	    var endzkamount = document.createElement("input");	     
	    endzkamount.type = "hidden";
	    endzkamount.name = "endzkamount";
	    endzkamount.value = '';	  
	    rptFrm.appendChild(endzkamount);

	    var salerID = document.createElement("input");	     
	    salerID.type = "hidden";
	    salerID.name = "salerID";
	    salerID.value = '';	  
	    rptFrm.appendChild(salerID);

	    var posID = document.createElement("input");	     
	    posID.type = "hidden";
	    posID.name = "posID";
	    posID.value = '';	  
	    rptFrm.appendChild(posID);

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

	    var goodsID = document.createElement("input");	     
	    goodsID.type = "hidden";
	    goodsID.name = "goodsID";
	    goodsID.value = '';	  
	    rptFrm.appendChild(goodsID);

	    var goodsName = document.createElement("input");	     
	    goodsName.type = "hidden";
	    goodsName.name = "goodsName";
	    goodsName.value = '';	  
	    rptFrm.appendChild(goodsName);

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

	    var bgiothergoodsbigclass = document.createElement("input");	     
	    bgiothergoodsbigclass.type = "hidden";
	    bgiothergoodsbigclass.name = "bgiothergoodsbigclass";
	    bgiothergoodsbigclass.value = '';	  
	    rptFrm.appendChild(bgiothergoodsbigclass);

	    var isCustomize = document.createElement("input");	     
	    isCustomize.type = "hidden";
	    isCustomize.name = "isCustomize";
	    isCustomize.value = '';	  
	    rptFrm.appendChild(isCustomize);
	    
	    var setmealName = document.createElement("input");	     
	    setmealName.type = "hidden";
	    setmealName.name = "setmealName";
	    setmealName.value = '';	  
	    rptFrm.appendChild(setmealName);
	    	    
	    var setmealType = document.createElement("input");	     
	    setmealType.type = "hidden";
	    setmealType.name = "setmealType";
	    setmealType.value = '';	  
	    rptFrm.appendChild(setmealType);	

	    var issetmeal = document.createElement("input");	     
	    issetmeal.type = "hidden";
	    issetmeal.name = "issetmeal";
	    issetmeal.value = '';	  
	    rptFrm.appendChild(issetmeal);

	    var showCompanyName = document.createElement("input");	     
	    showCompanyName.type = "hidden";
	    showCompanyName.name = "showCompanyName";
	    showCompanyName.value = '';	  
	    rptFrm.appendChild(showCompanyName);

	    var ordersTypeFlag = document.createElement("input");	     
	    ordersTypeFlag.type = "hidden";
	    ordersTypeFlag.name = "ordersTypeFlag";
	    ordersTypeFlag.value = '';	  
	    rptFrm.appendChild(ordersTypeFlag);

	    var priceSumFlag = document.createElement("input");	     
	    priceSumFlag.type = "hidden";
	    priceSumFlag.name = "priceSumFlag";
	    priceSumFlag.value = '';	  
	    rptFrm.appendChild(priceSumFlag);

	    var discountNumFlag = document.createElement("input");	     
	    discountNumFlag.type = "hidden";
	    discountNumFlag.name = "discountNumFlag";
	    discountNumFlag.value = '';	  
	    rptFrm.appendChild(discountNumFlag);

	    var salesValueFlag = document.createElement("input");	     
	    salesValueFlag.type = "hidden";
	    salesValueFlag.name = "salesValueFlag";
	    salesValueFlag.value = '';	  
	    rptFrm.appendChild(salesValueFlag);

	    var psalsvalueFlag = document.createElement("input");	     
	    psalsvalueFlag.type = "hidden";
	    psalsvalueFlag.name = "psalsvalueFlag";
	    psalsvalueFlag.value = '';	  
	    rptFrm.appendChild(psalsvalueFlag);

	    var integralFlag = document.createElement("input");	     
	    integralFlag.type = "hidden";
	    integralFlag.name = "integralFlag";
	    integralFlag.value = '';	  
	    rptFrm.appendChild(integralFlag);

	    var arrearsValueFlag = document.createElement("input");	     
	    arrearsValueFlag.type = "hidden";
	    arrearsValueFlag.name = "arrearsValueFlag";
	    arrearsValueFlag.value = '';	  
	    rptFrm.appendChild(arrearsValueFlag);

	    var xjFlag = document.createElement("input");	     
	    xjFlag.type = "hidden";
	    xjFlag.name = "xjFlag";
	    xjFlag.value = '';	  
	    rptFrm.appendChild(xjFlag);

	    var czkFlag = document.createElement("input");	     
	    czkFlag.type = "hidden";
	    czkFlag.name = "czkFlag";
	    czkFlag.value = '';	  
	    rptFrm.appendChild(czkFlag);

	    var jfFlag = document.createElement("input");	     
	    jfFlag.type = "hidden";
	    jfFlag.name = "jfFlag";
	    jfFlag.value = '';	  
	    rptFrm.appendChild(jfFlag);

	    var yhkFlag = document.createElement("input");	     
	    yhkFlag.type = "hidden";
	    yhkFlag.name = "yhkFlag";
	    yhkFlag.value = '';	  
	    rptFrm.appendChild(yhkFlag);

	    var djqFlag = document.createElement("input");	     
	    djqFlag.type = "hidden";
	    djqFlag.name = "djqFlag";
	    djqFlag.value = '';	  
	    rptFrm.appendChild(djqFlag);

	    var setMealNameFlag = document.createElement("input");	     
	    setMealNameFlag.type = "hidden";
	    setMealNameFlag.name = "setMealNameFlag";
	    setMealNameFlag.value = '';	  
	    rptFrm.appendChild(setMealNameFlag);

	    var memberNameFlag = document.createElement("input");	     
	    memberNameFlag.type = "hidden";
	    memberNameFlag.name = "memberNameFlag";
	    memberNameFlag.value = '';	  
	    rptFrm.appendChild(memberNameFlag);

	    var customerNameFlag = document.createElement("input");	     
	    customerNameFlag.type = "hidden";
	    customerNameFlag.name = "customerNameFlag";
	    customerNameFlag.value = '';	  
	    rptFrm.appendChild(customerNameFlag);

	    var phoneFlag = document.createElement("input");	     
	    phoneFlag.type = "hidden";
	    phoneFlag.name = "phoneFlag";
	    phoneFlag.value = '';	  
	    rptFrm.appendChild(phoneFlag);

	    var ygpersonFlag = document.createElement("input");	     
	    ygpersonFlag.type = "hidden";
	    ygpersonFlag.name = "ygpersonFlag";
	    ygpersonFlag.value = '';	  
	    rptFrm.appendChild(ygpersonFlag);

	    var salerIDFlag = document.createElement("input");	     
	    salerIDFlag.type = "hidden";
	    salerIDFlag.name = "salerIDFlag";
	    salerIDFlag.value = '';	  
	    rptFrm.appendChild(salerIDFlag);

	    var posIDFlag = document.createElement("input");	     
	    posIDFlag.type = "hidden";
	    posIDFlag.name = "posIDFlag";
	    posIDFlag.value = '';	  
	    rptFrm.appendChild(posIDFlag);

	    var posDateFlag = document.createElement("input");	     
	    posDateFlag.type = "hidden";
	    posDateFlag.name = "posDateFlag";
	    posDateFlag.value = '';	  
	    rptFrm.appendChild(posDateFlag);

	    var tpersonFlag = document.createElement("input");	     
	    tpersonFlag.type = "hidden";
	    tpersonFlag.name = "tpersonFlag";
	    tpersonFlag.value = '';	  
	    rptFrm.appendChild(tpersonFlag);

	    var tDateFlag = document.createElement("input");	     
	    tDateFlag.type = "hidden";
	    tDateFlag.name = "tDateFlag";
	    tDateFlag.value = '';	  
	    rptFrm.appendChild(tDateFlag);

	    var djValueFlag = document.createElement("input");	     
	    djValueFlag.type = "hidden";
	    djValueFlag.name = "djValueFlag";
	    djValueFlag.value = '';	  
	    rptFrm.appendChild(djValueFlag);

	    var bgnzk = document.createElement("input");	     
	    bgnzk.type = "hidden";
	    bgnzk.name = "bgnzk";
	    bgnzk.value = '';	  
	    rptFrm.appendChild(bgnzk);

	    var endzk = document.createElement("input");	     
	    endzk.type = "hidden";
	    endzk.name = "endzk";
	    endzk.value = '';	  
	    rptFrm.appendChild(endzk);

	    var jsxjFlag = document.createElement("input");	     
	    jsxjFlag.type = "hidden";
	    jsxjFlag.name = "jsxjFlag";
	    jsxjFlag.value = '';	  
	    rptFrm.appendChild(jsxjFlag);

	    var jsczFlag = document.createElement("input");	     
	    jsczFlag.type = "hidden";
	    jsczFlag.name = "jsczFlag";
	    jsczFlag.value = '';	  
	    rptFrm.appendChild(jsczFlag);

	    var jsjfFlag = document.createElement("input");	     
	    jsjfFlag.type = "hidden";
	    jsjfFlag.name = "jsjfFlag";
	    jsjfFlag.value = '';	  
	    rptFrm.appendChild(jsjfFlag);

	    var jsyhkFlag = document.createElement("input");	     
	    jsyhkFlag.type = "hidden";
	    jsyhkFlag.name = "jsyhkFlag";
	    jsyhkFlag.value = '';	  
	    rptFrm.appendChild(jsyhkFlag);

	    var jsdjqFlag = document.createElement("input");	     
	    jsdjqFlag.type = "hidden";
	    jsdjqFlag.name = "jsdjqFlag";
	    jsdjqFlag.value = '';	  
	    rptFrm.appendChild(jsdjqFlag);

	    var fxjFlag = document.createElement("input");	     
	    fxjFlag.type = "hidden";
	    fxjFlag.name = "fxjFlag";
	    fxjFlag.value = '';	  
	    rptFrm.appendChild(fxjFlag);

	    var fxjFlag = document.createElement("input");	     
	    fxjFlag.type = "hidden";
	    fxjFlag.name = "fxjFlag";
	    fxjFlag.value = '';	  
	    rptFrm.appendChild(fxjFlag);

	    var zklFlag = document.createElement("input");	     
	    zklFlag.type = "hidden";
	    zklFlag.name = "zklFlag";
	    zklFlag.value = '';	  
	    rptFrm.appendChild(zklFlag);

	    var lyFlag = document.createElement("input");	     
	    lyFlag.type = "hidden";
	    lyFlag.name = "lyFlag";
	    lyFlag.value = '';	  
	    rptFrm.appendChild(lyFlag);

	    var countperfrom = document.createElement("input");	     
	    countperfrom.type = "hidden";
	    countperfrom.name = "countperfrom";
	    countperfrom.value = '';	  
	    rptFrm.appendChild(countperfrom);

	    var iscontain = document.createElement("input");	     
	    iscontain.type = "hidden";
	    iscontain.name = "iscontain";
	    iscontain.value = '';	  
	    rptFrm.appendChild(iscontain);

	    var isShowType = document.createElement("input");	     
	    isShowType.type = "hidden";
	    isShowType.name = "isShowType";
	    isShowType.value = '';	  
	    rptFrm.appendChild(isShowType);

	    var isSalesPrice = document.createElement("input");	     
	    isSalesPrice.type = "hidden";
	    isSalesPrice.name = "isSalesPrice";
	    isSalesPrice.value = '';	  
	    rptFrm.appendChild(isSalesPrice);

	    var isShowSupplier = document.createElement("input");	     
	    isShowSupplier.type = "hidden";
	    isShowSupplier.name = "isShowSupplier";
	    isShowSupplier.value = '${systemParameterPo.fspisshowsupplierandbrand}';	  
	    rptFrm.appendChild(isShowSupplier);   

	    var departmentType = document.createElement("input");	     
	    departmentType.type = "hidden";
	    departmentType.name = "departmentType";
	    departmentType.value = '${person.departmenttype}';	  
	    rptFrm.appendChild(departmentType); 
	    
	    var companyid = document.createElement("input");	     
	    companyid.type = "hidden";
	    companyid.name = "companyid";
	    companyid.value = '';	  
	    rptFrm.appendChild(companyid);  
	    
	    var logincompanyid = document.createElement("input");	     
	    logincompanyid.type = "hidden";
	    logincompanyid.name = "logincompanyid";
	    logincompanyid.value = '';	  
	    rptFrm.appendChild(logincompanyid);  
	    
	    document.body.appendChild(rptFrm);
    }
    
	function queryReport(DataURL,formAction){
		
		var rptFrm = document.getElementById('rptFrm');
		var reporturl="${reporturl}";
		rptFrm.action = reporturl+DataURL;    
		rptFrm.target = formAction;    

		if (rptFrm.attachEvent){
			rptFrm.attachEvent("onsubmit",function(){ window.open('',formAction,'toolbar=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-100));}); 		  
		}else{
			rptFrm.addEventListener("onsubmit",function(){ window.open('',formAction,'toolbar=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-100));}); 		  
		}
	
		if (rptFrm.fireEvent){
			rptFrm.fireEvent("onsubmit");	
		}else{
			//rptFrm.removeEventListener("onsubmit");	
		}         
	    rptFrm.submit();  
	  	
	    document.body.removeChild(rptFrm); 
    }	
	function clean(){

		cleanControlValue();

		
	    if ('${systemParameterPo.fspshowrptcondition}' == '0'){
	    	$("input[id=isShow2][type=radio][value=0]").attr('checked','checked');
		}else{
			$("input[id=isShow2][type=radio][value=1]").attr('checked','checked');
	    }
	        
	    goodsForm.reset();
		$("input[id=queryClassify]").eq(0).attr("checked","checked");
		queryClass();
	}

    function cleanControlValue(){
        $('input[clean=clean][type!=radio]').each(function(){
            $(this).val('');
        });
        $('select[clean=clean]').each(function(){
            $(this).val('');
        });
        $('input[clean=clean][type=radio][value=1]').attr('checked','checked');
        initShowTab();
        
    }

    function initShowTab(){
        $('tr[inithide=inithide]').each(function(){
            $(this).hide();
        });
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
	
	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var companyid = $("#companysid").val();
		var queryClassify = $('input[name=queryClassify]:checked').val();
		if(queryClassify == "" || queryClassify == null){
			alert('请选择查询分类!');
			return false;
		}
		  
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0&companyid="+companyid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0&companyid="+companyid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openDepartmentValues(objValue){
		var arrayID = new Array();
		var arrayName = new Array();
		var departments = eval('(' + objValue + ')');
		for(var i = 0; i < departments.length; i++){	
			arrayID[i] = departments[i].bdpdepartmentid;
			arrayName[i] = departments[i].bdpdepartmentname;
		}

		$('#departmentID').val(arrayID.join(","));
		document.getElementById('bdpdepartmentname').value = arrayName.join(",");
		document.getElementById('ds').value = document.getElementById('bdpdepartmentname').value;
	}

	$(document).ready(function() { 

	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
		cleanControlValue();
		
	    if ('${systemParameterPo.fspshowrptcondition}' == '0'){
	    	$("input[id=isShow2][type=radio][value=0]").attr('checked','checked');
		}else{
			$("input[id=isShow2][type=radio][value=1]").attr('checked','checked');
	    }
	        
	    goodsForm.reset();

		$("input[id=queryClassify]").eq(0).attr("checked","checked");
		queryClass();
		
		if('${person.personcompanytype}' == '2'){
        	loadDepartmentids('${person.personcompanyid}');
        }
    }); 

	function queryClass(){
		cleanControlValue();
		
		var queryClassify = $('input[name=queryClassify]:checked').val();
        if (queryClassify == '1'){        	
        	$('tr[id=subscriptionTab]').show(); 
        	$('tr[id=subscriptionTab2]').show(); 
        	$('tr[id=salesbillstatusTab]').show();  

        	$('div[class=reportHelp]').show();    
        }
        if (queryClassify == '2'){ 
        	$('tr[id=subscriptionTab]').show(); 
        	$('tr[id=subscriptionTab2]').hide();       	
        	$('tr[group=type]').show();
        	$('tr[group=type2]').hide();

        	$('div[class=reportHelp]').hide();    
        }
        if (queryClassify == '3'){
        	$('tr[group=type2]').show();
        	$('tr[group=type]').hide();       	
        	$('tr[id=subscriptionTab]').hide();
        	$('tr[id=subscriptionTab2]').hide(); 
        	$('tr[id=salesbillstatusTab]').hide();  

        	$('div[class=reportHelp]').hide();    
        }        
    }
    
	function queryClasss(){
		
		
		var customAmountForm = $('input[name=customAmountForm]:checked').val();
        if (customAmountForm == '1'){        	
        	$('span[id=salesbillstatusTab3]').hide();   
        }
        if (customAmountForm == '2'){ 
        	$('span[id=salesbillstatusTab3]').hide(); 
        }
        if (customAmountForm == '3'){
        	$('span[id=salesbillstatusTab3]').show();  
        }
    }

    function help(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSalesResultsReportHelpSel.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			window.open('initSalesResultsReportHelpSel.action?moduleID=${requestScope.moduleID}','','toolbar=0,directories=0,status=0,menubar=0,scrollbars=yes,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-100));
		}
		document.getElementById('popupTitle').innerHTML="【报表使用说明 】";
    }

	function intransitselect(){
		
     if($("#intransittypet").val()==2 || $("#intransittypet").val()==3){
    	 $("#intransittypet2").show();
    	 $("#intransitt2").show();
    	 $("#intransittypet2").val('');
    	 $("#intransitt2").val('');
     }else{
    	 $("#intransittypet2").hide();
    	 $("#intransitt2").hide();
    	 $("#intransittypet2").val('');
    	 $("#intransitt2").val('');
         }
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
			$("tr[id=lh]").hide();
				$("#minSphlh2").val('');
				$("#maxSphlh2").val('');
				$("#bgispeclh2").val('');
				$("#bgicolorlh2").val('');
			$("tr[id=pj]").hide();
				$("#pjlx2").val('');
			$("tr[id=category2]").hide();
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
			$("tr[id=lh]").hide();
				$("#minSphlh2").val('');
				$("#maxSphlh2").val('');
				$("#bgispeclh2").val('');
				$("#bgicolorlh2").val('');
			$("tr[id=pj]").hide();
				$("#pjlx2").val('');
			$("tr[id=category2]").hide();
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
			$("tr[id=lh]").hide();
				$("#minSphlh2").val('');
				$("#maxSphlh2").val('');
				$("#bgispeclh2").val('');
				$("#bgicolorlh2").val('');
			$("tr[id=pj]").hide();
				$("#pjlx2").val('');
			$("tr[id=category2]").show();
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
			$("tr[id=lh]").hide();
				$("#minSphlh2").val('');
				$("#maxSphlh2").val('');
				$("#bgispeclh2").val('');
				$("#bgicolorlh2").val('');
			$("tr[id=pj]").hide();
				$("#pjlx2").val('');
			$("tr[id=yj]").show();
			$("tr[id=category2]").show();
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
			$("tr[id=category2]").hide();
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
			$("tr[id=pj]").hide();
				$("#pjlx2").val('');
			$("tr[id=lh]").show();
			$("tr[id=category2]").hide();
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
			$("tr[id=lh]").hide();
				$("#minSphlh2").val('');
				$("#maxSphlh2").val('');
				$("#bgispeclh2").val('');
				$("#bgicolorlh2").val('');
			$("tr[id=pj]").show();
			$("tr[id=category2]").hide();
	    	$("input[id=isCustomize2][type=radio][value='']").attr('checked','checked');
		}
	}

	function openBrand(){
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
		$('input[id=brandID2]').val(json.brandID);
		$('input[id=brandName2]').val(json.brandName);
	}

	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		
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
		$('input[id=supplierID2]').val(json.id);
		$('input[id=supplierName2]').val(json.value);
		$('input[id=brandID2]').val('');
		$('input[id=brandName2]').val('');
		
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
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="goodsForm" name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="searchKey" value="${searchKey}">
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>日常业务类报表</TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：销售业绩表</TD>
            <TD align=right>
                <img src="${ctx }/img/newbtn/reporthelp_0.png" btn=btn title='帮助' onclick="help();">	
            </TD>
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
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
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
			               <TD class="table_body" height="26">查询分类</TD>
			               <TD class="table_none" colspan="3">
			               <c:if test="${permissionPo.keyc == '1'}">
                               <input type="radio" id="queryClassify" name="queryClassify" value="1" onclick="queryClass();" /><a title="可查询实时数据">商品</a>&nbsp;
                           </c:if>
                           <c:if test="${permissionPo.keyd == '1'}">

                               <input type="radio" id="queryClassify" name="queryClassify" value="2" onclick="queryClass();"/><a title="可查询实时数据">配镜单</a>&nbsp;

                           </c:if>
                           <c:if test="${permissionPo.keye == '1'}">
                               <input type="radio" id="queryClassify" name="queryClassify" value="3" onclick="queryClass();"/><a title="可查询实时数据">结款方式</a>&nbsp;
                           </c:if>                              
                           <label style="color:red;">&nbsp;*&nbsp;</label>                                                     
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
							   		<select id="companysid" name="companysid" onchange="loadDepartmentids(this.options[this.options.selectedIndex].value)" >
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
						   <TD width="10%" height="26" class="table_body">查询部门</TD>
			               <TD class="table_none" width="40%">
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
						  <TD class="table_body">查询日期</TD>
			               <TD class="table_none">
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime2"/> 
                                    <jsp:param name="toDate" value="endTime2"/>             
                               </jsp:include>
			               </TD>
                        </TR>
                        <TR id="subscriptionTab2" inithide=inithide>
                           <TD height="30" class="table_body">分析角度</TD>
			               <TD class="table_none">
                               <input  type="radio" name="fxjd" id="fxjd"  value="1" checked="checked">按品种
                               <input  type="radio" name="fxjd" id="fxjd"  value="2" >按商品<br/>
			               </TD>
			               <TD height="30" class="table_body">分组角度</TD>
			               <TD class="table_none" colspan="3">
                               <input  type="radio" name="fztj" id="fztj"  value="1" >按制造商和商品类型分组
                               <input  type="radio" name="fztj" id="fztj"  value="2" checked="checked">按商品类型分组
			               </TD>
                        </TR>
                        <TR id="subscriptionTab" inithide=inithide>
                           <TD height="78" class="table_body">订金方式</TD>
			               <TD class="table_none" colspan="3">
                               <input  type="radio" name="customAmountForm" id="customAmountForm" onclick="queryClasss();" value="1" ${systemParameterPo.fspcustomamount eq '1' ? "checked" : "" }>订金按应收金额计入结款日收入,商品金额计入结款日收入<br/>
                               <input  type="radio" name="customAmountForm" id="customAmountForm" onclick="queryClasss();" value="2" ${systemParameterPo.fspcustomamount eq '2' ? "checked" : "" }>订金按应收金额计入补齐日收入,商品金额计入补齐日收入<br/>
                               <input  type="radio" name="customAmountForm" id="customAmountForm" onclick="queryClasss();" value="3" ${systemParameterPo.fspcustomamount eq '3' ? "checked" : "" }>订金结款日收入,补齐金额计入补齐日收入,商品金额计入结款日收入<br/>
			               </TD>
                        </TR>
                        <TR group="type" id="salesbillstatusTab" inithide=inithide>
			               <TD class="table_body" height="26">配镜单状态</TD>
			               <TD class="table_none" colspan="3">
                               <input  type="radio" id="salesType2" name="salesType2" value="" checked="checked"/>全部
                               <input  type="radio" id="salesType2" name="salesType2" value="1" />销售 
                               <input  type="radio" id="salesType2" name="salesType2" value="2" />退款
			               </TD>
			            </TR>
			            <TR group="type" id="salesbillstatusTab2" inithide=inithide>
			               <TD class="table_body" height="26">配镜单订金补齐状态</TD>
			               <TD class="table_none" colspan="3"> 
			               
			               <input type="radio" name="paystatus2" id ="paystatus2" value="" checked/>全部&nbsp;
			               <input type="radio" name="paystatus2" id ="paystatus2" value="0" />欠款&nbsp;			               			               
			               <input type="radio" name="paystatus2" id ="paystatus2" value="1" />未欠款&nbsp;
			               <span id="salesbillstatusTab3">
			               <input type="radio" name="paystatus2" id ="paystatus2" value="2" />全款&nbsp;
			               <input type="radio" name="paystatus2" id ="paystatus2" value="3" />订金&nbsp;
			               <input type="radio" name="paystatus2" id ="paystatus2" value="4" />补齐&nbsp;
                           </span>
                           
			               </TD>
                        </TR>
                       <tr group="type" id="salestypeTab"  inithide=inithide>
                           <TD height="26" class="table_body">销售类型</TD>
			               <TD class="table_none" colspan="3">
			               <input type="checkbox" name="billType2" id ="billType2" value="1" checked/>框镜成品&nbsp;
			               <input type="checkbox" name="billType2" id ="billType2" value="2" checked/>框镜订做&nbsp;
			               <input type="checkbox" name="billType2" id ="billType2" value="3" checked/>隐形成品&nbsp;
			               <input type="checkbox" name="billType2" id ="billType2" value="4" checked/>隐形订做&nbsp;
			               <input type="checkbox" name="billType2" id ="billType2" value="5" checked/>辅料&nbsp;
			               </TD>                        
                        </tr>
                        <tr group="type" id="salestypeTab"  inithide=inithide>
                           <TD height="26" class="table_body">自架自片</TD>
			               <TD class="table_none" colspan="3">
			               <input type="radio" name="iscontain2" id ="iscontain2" value="1" checked/>包含&nbsp;
			               <input type="radio" name="iscontain2" id ="iscontain2" value="2" />不包含&nbsp;
			               </TD>                        
                        </tr>
                        <tr group="type" id="salestypeTab"  inithide=inithide>
                           <TD height="26" class="table_body">查看方式</TD>
			               <TD class="table_none" colspan="3">
			               <input type="radio" name="isShowType2" id ="isShowType2" value="1" checked/>汇总&nbsp;
			               <input type="radio" name="isShowType2" id ="isShowType2" value="2" />流水&nbsp;
			               </TD>                        
                        </tr>
                        <tr group="type" id="salestypeTab"  inithide=inithide>
                           <TD height="26" class="table_body">配镜单金额为0是否显示</TD>
			               <TD class="table_none" colspan="3">
			               <input type="radio" name="isSalesPrice2" id ="isSalesPrice2" value="1" checked/>显示&nbsp;
			               <input type="radio" name="isSalesPrice2" id ="isSalesPrice2" value="2" />不显示&nbsp;
			               </TD>                        
                        </tr>
                        <TR group="type" id="salesbillTab" inithide=inithide>
			               <TD class="table_body" height="26">配镜单号</TD>
			               <TD class="table_none" >
                                <input clean=clean type="text" name="salesID2" id="salesID2"/>
			               </TD>
			               <TD class="table_body" height="26">折扣率</TD>
		                   <TD class="table_none"><input clean=clean type="text" class="text_input60" maxlength="20" id="bgnzk2" name="bgnzk2" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写折扣率！'}]"/>&nbsp;至&nbsp;
		                   <input clean=clean type="text" class="text_input60" maxlength="20" id="endzk2" name="endzk2" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写折扣率！'}]"/></TD>
                        </TR>
                        <tr group="type" id="setmealTab"  inithide=inithide>  
                           <TD height="26" class="table_body">是否使用套餐</TD>
		                   <TD class="table_none">
		                   	   <input type="radio" id="issetmeal2" name="issetmeal2" value="" checked/>全部&nbsp;
			               	   <input type="radio" id="issetmeal2" name="issetmeal2" value="1" />是&nbsp;
			               	   <input type="radio" id="issetmeal2" name="issetmeal2" value="0" />否&nbsp;

                           </TD> 
                           <TD height="26" class="table_body">套餐名称</TD>
		                   <TD class="table_none"><input clean=clean sid="4" type="text" class="text_input160" maxlength="20" id="setmealName2" name="setmealName2"/></TD>                       
                       
                        </tr>
                        <tr group="type" id="setmealTab"  inithide=inithide>   
                           
                           <TD height="26" class="table_body">套餐分类</TD>
		                   <TD class="table_none" colspan="3">
		                   	   <input type="radio" id="setmealType2" name="setmealType2" value="" checked/>全部&nbsp;
			               	   <input type="radio" id="setmealType2" name="setmealType2" value="1" />框镜&nbsp;
			               	   <input type="radio" id="setmealType2" name="setmealType2" value="3" />隐形&nbsp;
			               	   <input type="radio" id="setmealType2" name="setmealType2" value="5" />辅料&nbsp;
                           </TD>                       
                        </tr>
                        <tr group="type" id="intransittypeTab"  inithide=inithide>   
                           <TD height="26" class="table_body">顾客卡号</TD>
		                   <TD class="table_none" colspan="3"><input clean=clean sid="4" type="text" class="text_input160" maxlength="20" id="customerID2" name="customerID2"/>		                   
		                   </TD> 
                        </tr>
                        <tr group="type" id="customerTab"  inithide=inithide>   
                           <TD height="26" class="table_body">顾客姓名</TD>
		                   <TD class="table_none"><input clean=clean sid="4" type="text" class="text_input160" maxlength="20" id="customerName2" name="customerName2"/></TD>                       
                           <TD height="26" class="table_body">顾客电话</TD>
		                   <TD class="table_none"><input clean=clean sid="4" type="text" class="text_input160" maxlength="20" id="customerPhone2" name="customerPhone2"/>		                   
		                   </TD>                       
                        </tr>
                        <tr group="type" id="salesamountTab"  inithide=inithide>
                           <TD height="26" class="table_body">销售金额</TD>
			               <TD class="table_none">
			               <input clean=clean type="text" class="text_input60" maxlength="20" id="bgnamount2" name="bgnamount2" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写销售金额！'}]"/>&nbsp;至&nbsp;
			               <input clean=clean type="text" class="text_input60" maxlength="20" id="endamount2" name="endamount2" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写销售金额！'}]"/>
			               </TD>
                           <TD height="26" class="table_body">优惠金额</TD>
		                   <TD class="table_none"><input clean=clean type="text" class="text_input60" maxlength="20" id="bgnzkamount2" name="bgnzkamount2" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写折扣金额！'}]"/>&nbsp;至&nbsp;
		                   <input clean=clean type="text" class="text_input60" maxlength="20" id="endzkamount2" name="endzkamount2" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写折扣金额！'}]"/></TD>
                        
                        </tr>
                        <tr group="type" id="personTab"  inithide=inithide>
                           <TD height="26" class="table_body">营业员工号</TD>
			               <TD class="table_none">
			               <input clean=clean type="text" class="text_input160" maxlength="20" id="salerID2" name="salerID2" />&nbsp;
			               
			               </TD>
                           <TD height="26" class="table_body">收银员工号</TD>
		                   <TD class="table_none"><input clean=clean type="text" class="text_input160" maxlength="20" id="posID2" name="posID2" />&nbsp;
                        
                        </tr>
                       <TR  group="type" id="salesshowTab"  inithide=inithide>
                           <TD height="26" class="table_body">配镜单显示信息</TD>
			               <TD class="table_none" colspan="3">
			               	   <input type="checkbox" name="ordersTypeFlag2" id ="ordersTypeFlag2" value="1" checked/>销售类型&nbsp;&nbsp;
			               	   <input type="checkbox" name="priceSumFlag2" id ="priceSumFlag2" value="1" checked/>原价合计&nbsp;&nbsp;
			               	   <input type="checkbox" name="discountNumFlag2" id ="discountNumFlag2" value="1" checked/>优惠金额&nbsp;&nbsp;
			               	   <input type="checkbox" name="salesValueFlag2" id ="salesValueFlag2" value="1" checked/>应收金额&nbsp;&nbsp;
			               	   <input type="checkbox" name="psalsvalueFlag2" id ="psalsvalueFlag2" value="1" checked/>实收金额&nbsp;&nbsp;
			               	   <input type="checkbox" name="integralFlag2" id ="integralFlag2" value="1" checked/>积分&nbsp;&nbsp;
			               	   <input type="checkbox" name="zklFlag2" id ="zklFlag2" value="1" checked/>折扣率&nbsp;&nbsp;
			               	   <input type="checkbox" name="lyFlag2" id ="lyFlag2" value="1" />来源&nbsp;&nbsp;
			               	   <input type="checkbox" name="setMealNameFlag2" id ="setMealNameFlag2" value="1" checked/>套餐名称&nbsp;&nbsp;
			               	   <input type="checkbox" name="memberNameFlag2" id ="memberNameFlag2" value="1" checked/>会员卡号&nbsp;&nbsp;
			               	   <input type="checkbox" name="customerNameFlag2" id ="customerNameFlag2" value="1" checked/>顾客姓名&nbsp;&nbsp;
			               	   <input type="checkbox" name="phoneFlag2" id ="phoneFlag2" value="1" checked/>顾客电话&nbsp;&nbsp;
			               	   <input type="checkbox" name="ygpersonFlag2" id ="ygpersonFlag2" value="1" checked/>验光师&nbsp;&nbsp;
			               	   <input type="checkbox" name="salerIDFlag2" id ="salerIDFlag2" value="1" checked/>收银员&nbsp;&nbsp;
			               	   <input type="checkbox" name="posIDFlag2" id ="posIDFlag2" value="1" checked/>营业员&nbsp;&nbsp;
			               	   <input type="checkbox" name="posDateFlag2" id ="posDateFlag2" value="1" checked/>收银日期&nbsp;&nbsp;
			               	   <input type="checkbox" name="tpersonFlag2" id ="tpersonFlag2" value="1" />退款人&nbsp;&nbsp;
			               	   <input type="checkbox" name="tDateFlag2" id ="tDateFlag2" value="1" />退款时间&nbsp;&nbsp;
	      	               </TD>
                        </TR>
                        <TR  group="type" id="category"  inithide=inithide>
                           <TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none" colspan="3">
			               	   <input type="radio" name="goodscategoryID2" onclick="showterm();" id ="goodscategoryID2" value="" checked/>全部&nbsp;&nbsp;
	      	                   <s:iterator value="goodsCategorys">
	      	                   <input type="radio" name="goodscategoryID2" onclick="showterm();" id ="goodscategoryID2" value="${bgcid}"/>${bgcgoodscategoryname}&nbsp;&nbsp;
	      	                   </s:iterator>
	      	               </TD>
                        </TR>
                        <TR   id="category2"  inithide=inithide>
                           <TD height="26" class="table_body">镜片分类</TD>
			               <TD class="table_none" colspan="3">
			               	   <input type="radio" id="isCustomize2" name="isCustomize2" value=""  checked/>全部&nbsp;
			               	   <input type="radio" id="isCustomize2" name="isCustomize2" value="0"/>成品&nbsp;
			               	   <input type="radio" id="isCustomize2" name="isCustomize2" value="D"/>订做&nbsp;
	      	               </TD>
                        </TR>
                        <TR group="type" id="goods"  inithide=inithide>
			               <TD class="table_body">商品代码</TD>
			               <TD class="table_none"><input clean=clean sid="4" type="text" class="text_input160" maxlength="26" id="goodsID2" name="goodsID2"/></TD>
			               <TD class="table_body">商品名称</TD>
			               <TD class="table_none"><input clean=clean sid="4" type="text" class="text_input160" maxlength="40" id="goodsName2" name="goodsName2"/></TD>						  
                        </TR>

                        <TR  group="type2" id="accountTab"  inithide=inithide>
                           <TD height="26" class="table_body">结算方式显示</TD>
			               <TD class="table_none" >
			               <input type="hidden" name="countperfrom2" id="countperfrom2" value="${systemParameterPo.fspiscountperfrom}">
			               	   <input type="checkbox" name="jsxjFlag2" id ="jsxjFlag2" value="1" checked/>现金&nbsp;&nbsp;
			               	   <input type="checkbox" name="jsyhkFlag2" id ="jsyhkFlag2" value="1" checked/>银行卡&nbsp;&nbsp;
			               	   <input type="checkbox" name="jsjfFlag2" id ="jsjfFlag2" value="1" checked/>积分消费&nbsp;&nbsp;
			               	   <input type="checkbox" name="jsczFlag2" id ="jsczFlag2" value="1" checked/>储值卡&nbsp;&nbsp;
			               	   <input type="checkbox" name="jsdjqFlag2" id ="jsdjqFlag2" value="1" checked/>代金券&nbsp;&nbsp;
			               	   <input type="checkbox" name="fxjFlag2" id ="fxjFlag2" value="1" checked/>其他&nbsp;&nbsp;
	      	               </TD>
	      	               <TD height="26" class="table_body">银行卡和其他是否展开</TD>
			               <TD class="table_none" >
		                   	   <input type="radio" id="isTongJi2" name="isTongJi2" value="1" checked/>是&nbsp;
			               	   <input type="radio" id="isTongJi2" name="isTongJi2" value="0" />否&nbsp;
	      	               </TD>
                        </TR>
                        <tr id="jj" nolh=nolh inithide=inithide>
                        	<TD height="26" class="table_none">工艺类型</TD>
			               <TD class="table_none" >
                            <select clean=clean id="bgitechnologytypeid2" name="bgitechnologytypeid2">
                            	<option value="">----请选择----</option>
                            	<s:iterator value="teachnologyList">
                            		<option ${bgitechnologytypeid eq fttid ? 'selected="selected"' : '' } value="${fttid }">${fttname }</option>
                            	</s:iterator>
                            </select>
			               </TD>
						   <TD height="26" class="table_none" >镜架材质</TD>
			               <TD class="table_none">
                            <select clean=clean id="bgiframematerialtype2" name="bgiframematerialtype2" >
                            	<option value="">----请选择----</option>
                            	<s:iterator value="frameMaterialList">
                            		<option ${bgiframematerialtype eq bfmid ? 'selected="selected"' : '' } value="${bfmid }">${bfmname }</option>
                            	</s:iterator>
                            </select>
			               </TD>
                        </tr>
                        <tr id="jj" inithide=inithide>
                           <TD height="26" class="table_none">型号</TD>
			               <TD class="table_none" >
                            <input clean=clean class="text_input160" type="text"  id="bgispecjj2" name="bgispecjj2" value="${requestScope.bgispecjj}" maxlength="30">
			               </TD>
						   <TD height="26" class="table_none" >色号</TD>
			               <TD class="table_none">
                            <input clean=clean class="text_input160" type="text"  id="bgicolorjj2" name="bgicolorjj2" value="${bgicolorjj}" maxlength="10">
			               </TD>
                        </tr>
                        <tr id="jj" inithide=inithide>
			               <TD height="26" class="table_none">尺寸</TD>
			               <TD class="table_none" colspan="3">
                            <input clean=clean class="text_input160" type="text"  id="bgiframesizejj2" name="bgiframesizejj2" value="${requestScope.bgiframesizejj}" maxlength="10">
			               </TD>
                        </tr>
                        <tr id="jp" inithide=inithide>
                        	<TD height="26" class="table_none">镜片球镜范围</TD>
			               <TD class="table_none">
                            <input clean=clean class="text_input80" type="text" onchange="checkNumberType(this);"  id="minSphjp2" name="minSphjp2" value="${requestScope.minSphjp}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写镜片柱镜度数！'}]">
                            	至
                            <input clean=clean class="text_input80" type="text" onchange="checkNumberType(this);" id="maxSphjp2" name="maxSphjp2" value="${requestScope.maxSphjp}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写镜片柱镜度数！'}]">
			               </TD>
						   <TD height="26" class="table_none" >镜片柱镜范围</TD>
			               <TD class="table_none">
                            <input clean=clean class="text_input80" type="text" onchange="checkNumberType(this);" id="minCyljp2" name="minCyljp2" value="${requestScope.minCyljp}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写镜片柱镜度数！'}]">
                            	至
                            <input clean=clean class="text_input80" type="text" onchange="checkNumberType(this);" id="maxCyljp2" name="maxCyljp2" value="${requestScope.maxCyljp}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写镜片柱镜度数！'}]">
			               </TD>
                        </tr>
                        <tr id="jp" inithide=inithide>
                        	<TD height="26" class="table_none">镜片材料分类</TD>
			                <TD class="table_none">
                            	<select clean=clean id="bgieyeglassmaterialtypejp2" name="bgieyeglassmaterialtypejp2"}>
      		                 		<option value="">----请选择----</option>
				               		<option value="1" ${bgieyeglassmaterialtypejp == '1' ? 'selected="selected"' : '' }>树脂</option>
				               		<option value="2" ${bgieyeglassmaterialtypejp == '2' ? 'selected="selected"' : '' }>玻璃</option>
				               		<option value="3" ${bgieyeglassmaterialtypejp == '3' ? 'selected="selected"' : '' }>PC</option>
      	                   		</select>
			                </TD>
						    <TD height="26" class="table_none">镜片折射率</TD>
			                <TD class="table_none">
                            	<select clean=clean id="bgirefractivejp2" name="bgirefractivejp2"}>
      		                 	<option value="">----请选择----</option>
			               		 <s:iterator value="refractiveSetPos">
				                   <option value="${brfname}" ${bgirefractivejp == brfname ? 'selected="selected"' : '' }>${brfname}</option>
		     	                 </s:iterator>
      	                   		</select>
			                </TD>
                        </tr>
                        <tr id="jp" inithide=inithide> 
			                <TD height="26" class="table_none">镜片光度分类</TD>
			                <TD class="table_none" colspan="3">
                            	<select clean=clean id="bgiismutiluminosityjp2" name="bgiismutiluminosityjp2"}>
      		                 		<option value="">----请选择----</option>
				               		<option value="0" ${bgiismutiluminosityjp == '0' ? 'selected="selected"' : '' }>单光片</option>
				               		<option value="M" ${bgiismutiluminosityjp == 'M' ? 'selected="selected"' : '' }>多光片</option>
				               		<option value="J" ${bgiismutiluminosityjp == 'J' ? 'selected="selected"' : '' }>渐进片</option>
				               		<option value="Q" ${bgiismutiluminosityjp == 'Q' ? 'selected="selected"' : '' }>其他</option>
      	                   		</select>
			               </TD>
                        </tr>
                        
                        <tr id="yj" inithide=inithide>
                        	<TD height="26" class="table_none">隐形使用类型</TD>
			                <TD class="table_none">
                            	<select clean=clean id="bgiusetypeyj2" name="bgiusetypeyj2"}>
      		                 		<option value="">----请选择----</option>
				               		<option value="1" ${bgiusetypeyj == '1' ? 'selected="selected"' : '' }>常带型</option>
				               		<option value="2" ${bgiusetypeyj == '2' ? 'selected="selected"' : '' }>抛弃型</option>
				               		<option value="3" ${bgiusetypeyj == '3' ? 'selected="selected"' : '' }>塑形镜</option>
      	                   		</select>
			                </TD> 
						    <TD height="26" class="table_none">抛弃型分类</TD>
			                <TD class="table_none">
                            	<select clean=clean id="bgistealthclassyj2" name="bgistealthclassyj2"}>
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
                        <tr id="yj" inithide=inithide>
                           <TD height="26" class="table_none">隐形球镜范围</TD>
			               <TD class="table_none">
                            <input clean=clean class="text_input80" type="text" onchange="checkNumberType(this);" id="minSphyj2" name="minSphyj2" value="${requestScope.minSphyj}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写隐形球镜度数！'}]">
                            	至
                            <input clean=clean class="text_input80" type="text" onchange="checkNumberType(this);" id="maxSphyj2" name="maxSphyj2" value="${requestScope.maxSphyj}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写隐形球镜度数！'}]">
			               </TD>
						   <TD height="26" class="table_none" >隐形柱镜范围</TD>
			               <TD class="table_none">
                            <input clean=clean class="text_input80" type="text" onchange="checkNumberType(this);" id="minCylyj2" name="minCylyj2" value="${requestScope.minCylyj}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写隐形柱镜度数！'}]">
                            	至
                            <input clean=clean class="text_input80" type="text" onchange="checkNumberType(this);" id="maxCylyj2" name="maxCylyj2" value="${requestScope.maxCylyj}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写隐形柱镜度数！'}]">
			               </TD>
                        </tr>
                        <tr id="pj" inithide=inithide>
                           <TD height="26" class="table_none">配件型</TD>
			               <TD class="table_none" colspan="3">
                             <select clean=clean id="pjlx2" name="pjlx2">
      		                   <option value="">----请选择----</option>
				               <option ${pjlx eq "1" ? 'selected="selected"' : '' } value="1" >框镜</option>
				               <option ${pjlx eq "2" ? 'selected="selected"' : '' } value="2" >隐形</option>
      	                     </select>
			               </TD>
                        </tr>
                        <tr id="hc" inithide=inithide>
                           <TD  height="26" class="table_none">其它商品大类</TD>
			               <TD class="table_none" colspan="3">
                             <select clean=clean id="bgiothergoodsbigclass2" name="bgiothergoodsbigclass2">
      		                   <option value="">----请选择----</option>
				               <option ${bgiothergoodsbigclass eq "Q" ? 'selected="selected"' : '' } value="Q" >其它材料</option>
				               <option ${bgiothergoodsbigclass eq "D" ? 'selected="selected"' : '' } value="D" >低值易耗品</option>
      	                     </select>
			               </TD>
                        </tr>
                        <tr id="lh" inithide=inithide>
                        	<TD height="26" class="table_none">老花球镜范围</TD>
			               <TD class="table_none">
                            <input clean=clean class="text_input80" type="text"  id="minSphlh2" name="minSphlh2" value="${requestScope.minSphlh}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写老花镜度数！'}]">
                            	至
                            <input clean=clean class="text_input80" type="text"  id="maxSphlh2" name="maxSphlh2" value="${requestScope.maxSphlh}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写老花镜度数！'}]">
			               </TD>
			               <TD  height="26" class="table_none">型号</TD>
			               <TD class="table_none" >
                            <input clean=clean class="text_input160" type="text"  id="bgispeclh2" name="bgispeclh2" value="${requestScope.bgispeclh}" maxlength="30">
			               </TD>
                        </tr>
                        <tr id="lh" inithide=inithide>
						   <TD width="9%" height="26" class="table_none" >色号</TD>
			               <TD  class="table_none" colspan="3">
                            <input clean=clean class="text_input160" type="text"  id="bgicolorlh2" name="bgicolorlh2" value="${requestScope.bgicolorlh}" maxlength="10">
			               </TD>
                        </tr>
                        
                        <TR>
			               <TD class="table_body" height="26">显示查询条件</TD>
			               <TD class="table_none">
                               <input type="radio" id="isShow2" name="isShow2" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow2" name="isShow2" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
			               </TD>
			               <TD class="table_body" height="26">显示公司名称</TD>
			               <TD class="table_none">
                               <input clean=clean type="radio" id="showCompanyName2" name="showCompanyName2" value="1" checked="checked"/>是
                               <input clean=clean type="radio" id="showCompanyName2" name="showCompanyName2" value="0"/>否
			               </TD>
                        </TR>

                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr>
							<td height="26">
							<c:if test="${permissionPo.keya == '1'}">  
							<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();">
							<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" >	
							</c:if>						
							</td>
						</tr>
					</table>
		    <c:if test="${systemParameterPo.fspreporthelpshow eq '1'}">		
					<br/><br/>
					<div class="reportHelp">												
                      如果需要重新汇总数据，可以进入【定时任务维护】模块，通过【日销售商品明细】这个定时任务重新汇总数据。<br/>
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
