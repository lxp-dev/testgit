<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在途查询</title>
</head>
<script>	
	
	function showMailDetails(salesID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("toMailDetails.action?hid="+salesID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("toMailDetails.action?hid="+salesID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【邮寄信息】";
	}

	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	function refundSales(){
		var ids = '';
		var count = 0;
		var goodsnum = 0;
		var amount = 0;
		var goodsnum1 = 0;
		var amount1 = 0;
        $('input[name=chk]').each(function (){
            if ($(this).attr('checked') == true){
                ids = ids + ',' + $(this).val();
                count = accAdd(count,1);
                amount = accAdd(amount,Number($(this).attr('amount')));
                goodsnum = accAdd(goodsnum,Number($(this).attr('goodsnum')));
            }
        });

        if (count == 0){
            alert('请选择已消费的商品!');
            return;
        }
        count = 0;
        $('input[name=salesDetailPo.iscustomizes]').each(function (){
            if ($(this).val() == 'D' || $(this).val() == 'd'){
                count = accAdd(count,1);
            }
        });
        if (count > 0){
            alert('请选择隐形成品镜片!');
            return;
        }

        $('input[name=salesDetailPo.ssesdsalesvalues]').each(function (){
        	amount1 = accAdd(amount1,Number($(this).val()));
        });
        $('input[name=salesDetailPo.ssesdnumbers]').each(function (){
        	goodsnum1 = accAdd(goodsnum1,Number($(this).val()));
        });

        if (Number(goodsnum) != Number(goodsnum1) || Number(amount) > Number(amount1)){
            alert('换取商品的数量或金额有误,请重新换取!');
            return;
        }
        if (Number(amount) == Number(amount1)){
            $('#ssesbcheckoutflag').val('0');
        }else{
        	$('#ssesbcheckoutflag').val('1');
        }        
        if ($('input[name=salesDetailPo.iscustomizes]').size() == 0){
            alert('请选择换取的商品!');
            return;
        }

		$("img").removeAttr("onclick");
		gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
		arrearsForm.action="partSwapGoodsSales.action?salesID="+'${ssesbsalesid}'+"&ids="+ids;
		arrearsForm.submit();
        
	}

	/*
	*  商品选择开窗
	*
	*  参数： goodscategory  商品类别
	*        direction      左右眼描述
	*        materialType   镜片种类
	*        accessoryType  配件型        1：镜架辅料      2：隐形辅料
    *        oneselfframe   自架                  ZZ：是                  空串：否
    *        iscustomize    定制标志       0：成品                 D：定制                         ZZ：自片
	*/	
	function addSalesGoods(goodscategory,direction, materialType,accessoryType,oneselfframe,iscustomize){				

		var path = "";
		path = getGlassOptometryDate(direction,materialType);
	    if(path == ''){
	        return;
	    }

		$("input[id=inputscanbarcode]").val('');
		
		//销售类型
		var salestype = '4'; 
	    path = getGlassOptometryDate("R","");
	    path = path+getGlassOptometryDate("L","");
	    if (path == ''){
	        return;
	    }

	    var isemptyoptometry = "";
	    if('${systemParameterPo.fspsalesstealthother}' == '1'){
			$("input[id=salesitemid]").each(function (){
				if($(this).val().substring(0,1) == '4'){
					isemptyoptometry = "1";
				}
			});
		}

		if(isemptyoptometry == '1'){
			path = "";
		}
			    
		if ((goodscategory == '3' || goodscategory == '4') && iscustomize != 'ZZ'){
			if ($('input[name=salestype]:checked').val() == '2' || $('input[name=salestype]:checked').val() == '4'){
			    iscustomize='D';
			}
			if ($('input[name=salestype]:checked').val() == '1' || $('input[name=salestype]:checked').val() == '3'){
			    iscustomize='0';
			}
		}

		var other = '';
		if(goodscategory == 'other'){
			goodscategory = '1';
			other = '1';
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2') && (goodscategory=="4" || goodscategory=="5")){
			if(is_iPad()){
				showPopWin("selectSellMirrorFrameBatch.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&accessoryType="+accessoryType+"&oneselfframe="+oneselfframe+"&iscustomize="+iscustomize+path+"&other="+other+"&kucun=1&whichretail=1&select_retail=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("selectSellMirrorFrameBatch.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&accessoryType="+accessoryType+"&oneselfframe="+oneselfframe+"&iscustomize="+iscustomize+path+"&other="+other+"&kucun=1&whichretail=1&select_retail=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}				
		}else{
			if(is_iPad()){
				showPopWin("selectSellMirrorFrameAll.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&accessoryType="+accessoryType+"&oneselfframe="+oneselfframe+"&iscustomize="+iscustomize+path+"&other="+other+"&kucun=1&ismutiluminosity=0&whichretail=1&select_retail=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("selectSellMirrorFrameAll.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&accessoryType="+accessoryType+"&oneselfframe="+oneselfframe+"&iscustomize="+iscustomize+path+"&other="+other+"&kucun=1&ismutiluminosity=0&whichretail=1&select_retail=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
		}
		
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}	

	   /*
	*   扫描商品开窗
	*/
	function scanGoods(obj){  
	    if (event.keyCode==13){
		
			var goodscategory="";
		    var iscustomize="";
		    var mm=obj.value.substring(0,1);
		    
        	if(mm != '4'){
        		alert("请扫描隐形成品镜片!");
        		return;
        	}else{
    			goodscategory="4";
    			iscustomize="0";

        		if(obj.value.trim().length != 26){
					alert("隐形镜片商品扫描商品条码有误!");
					return;
		 	    }
        	}
	     							
			var framesize = 0;
			var odsize = 0;
			var ossize = 0;
			$("input[id=ssesdglassflags]").each(function (){
				if($(this).val() == 'F'){
					framesize = framesize + 1;
				}else if($(this).val() == 'R'){
					odsize = odsize + 1;
				}else if($(this).val() == 'L'){
					ossize = odsize + 1;
				}
			});
			
			var path = "";
			var direction = "";
			if(odsize == 0 && goodscategory == '3'){
				direction = "R";
			}else if(ossize == 0 && goodscategory == '3'){
				direction = "L";
			}
			
			if (goodscategory == '3' || goodscategory == '4' || goodscategory == '8'){
			    path = getGlassOptometryDate("R","");
			    if (path == ''){
			        return;
			    }
			    path = path+getGlassOptometryDate("L","");
			    if (path == ''){
			        return;
			    }
			}

		    var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;	
			if('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2'){
				if(obj.value.substring(0,1) == '4' || obj.value.substring(0,1) == '5'){
					if(is_iPad()){
						showPopWin("scanGoodsSelAllBatch.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&iscustomize="+iscustomize+"&goodsbar=" + obj.value.trim()+path+"&direction="+direction+"&rl="+direction+'&kucun=1',970,screen.height-200,topRows,topCols,returnRefresh(true),false);
					}else{
						showPopWin("scanGoodsSelAllBatch.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&iscustomize="+iscustomize+"&goodsbar=" + obj.value.trim()+path+"&direction="+direction+"&rl="+direction+'&kucun=1',screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
					}
				}else{
					if(is_iPad()){
						showPopWin("scanGoodsSelAll.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&iscustomize="+iscustomize+"&goodsbar=" + obj.value.trim()+path+"&direction="+direction+"&rl="+direction+'&kucun=1',970,screen.height-200,topRows,topCols,returnRefresh(true),false);
					}else{
						showPopWin("scanGoodsSelAll.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&iscustomize="+iscustomize+"&goodsbar=" + obj.value.trim()+path+"&direction="+direction+"&rl="+direction+'&kucun=1',screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
					}
				}
			}else{
				if(is_iPad()){
					showPopWin("scanGoodsSelAll.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&iscustomize="+iscustomize+"&goodsbar=" + obj.value.trim()+path+"&direction="+direction+"&rl="+direction+'&kucun=1',970,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}else{
					showPopWin("scanGoodsSelAll.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&iscustomize="+iscustomize+"&goodsbar=" + obj.value.trim()+path+"&direction="+direction+"&rl="+direction+'&kucun=1',screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}
			}
			document.getElementById('popupTitle').innerHTML="【商品查询】";
			$("#inputscanbarcode").val('');
	    }
	}

	//球镜、柱镜
	var re1 = /^[\+\-]?[0-9]{1,2}([.]{1}[0-9]{1,2})?$/;
	
	//视力
	var re2 = /^[0-9]{1}([.]{1}[0-9]{1})?$/;
	
	//棱镜、下加
	var re3 = /^[0-9]{1,2}([.]{1}[0-9]{1,2})?$/;
	
	//瞳距
	var re4 = /^[0-9][0-9](\.[0-9])?$/;
	
	//直径
	var re5 = /^[0-9]*([.]{0,1}[0-9])$/;
	
	var orderCycle = '0'; //委外加工周期
	
	//验证棱镜、下加
	function checkLjXj(obj) {
		if (obj.value == null || obj.value == '') {
			return;
		}
		if (!(re3.test(obj.value))) {
			alert("请输入正确格式！");
			obj.select();
		} else {
			addZero(obj);
		}
	}
	
	//验证瞳距
	function checkPupilDistance(obj) {
		if (obj.value == null || obj.value == '') {
			return;
		}
		if (!(re4.test(obj.value))) {
			alert("请输入正确格式！");
			obj.select();
		}
		
		vaAddZero(obj);
	}
	
	//验证视力
	function checkVA(obj) {
		if (obj.value == null || obj.value == '') {
			return;
		}
		if (!(re2.test(obj.value))) {
			alert("请输入正确格式！");
			obj.select();
		} else {
			vaAddZero(obj);
		}
	}

	function salesout(item){
		$(item).addClass('salesout');
	}
	function salesover(item){
		$(item).removeClass('salesout');
	}
	
	//验证球镜、柱镜
	function checkData(obj) {
		if (obj.value == null || obj.value == '') {
			return;
		}
		
		if(parseFloat(obj.value)%0.25!=0){
			alert("球镜、柱镜、ADD应为 0.25的倍数！");
			obj.select();
			return;
		}
		
		if (!(re1.test(obj.value))) {
			alert("请输入正确格式！");
			obj.select();
		} else {
			obj.value = obj.value.replace("+", "");
			addZero(obj);
			if(obj.value > 0){
				obj.value = '+' + obj.value;
			}
		}
	}
	
	//验证轴向
	function checkAxiss(obj) {
		if (obj.value == null || obj.value == '') {
			return;
		}

		if (isNaN(obj.value)) {
			
			alert("输入错误！");
			obj.select();
			return;
		}
		
		var axis = parseInt(obj.value);
		
		if (axis > 180){
			obj.value = axis - 180;
		}else if (axis < 0 ){
			obj.value = axis + 180;
		}
	}
	
	//补零
	function addZero(obj) {
		if (obj.value.indexOf(".") == -1) {
			obj.value += ".00";
		} else if (obj.value.indexOf(".") == obj.value.length - 2) {
			obj.value += "0";
		}
	}
	
	//视力补零
	function vaAddZero(obj) {
		if (obj.value.indexOf(".") == -1) {
			obj.value += ".0";
		}
	}

	/*
	添加商品
	*/
	var glassOD='';
	var glassOS='';
	var frame='';
	var bgiordercycle=0//订做周期
	function addGoods(json){
	
			//限制一单一副。
			if(json.glassflag!=undefined&&json.glassflag!=''){
				if(json.glassflag=='R'){
					glassOD="R";					
				}else{
					glassOS="L";
				}
			}else{
				if(category=='镜架辅料')
				{
					
				}else
				{
					frame="F";
				}
				
			}
			//克隆行
			$("#copyrow").show();
        	$("#copyrow").clone(true).appendTo($("#copyrow"));
        	$("#copyrow").hide();
        	
        	//取goods行索引
        	var tt=$('input[name=salesDetailPo\\.ssesdsalesitemids]').size()-2;
        	
        	var mm=$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(tt).attr('trindex');
        	var index=$('#copyrow+tr').size()+1;
        	var trindex=0;
        	if(typeof(mm) == 'undefined')
        	{
        		trindex=$('#copyrow+tr').size()+1;
            }else
            {
            	trindex=parseInt(mm+1);
            }
        	
        	//赋值
        	$('input[name=rownumber]')[index].value=index;
        	
        	for(var i=1;$('#copyrow+tr').size()>=i;i++)
        	{
        	  for(var j=1;i>=j;j++)
        	  {
        	    $('input[name=rownumber]')[j].value=j;
        	  }
        	}
        	
	        $('input[name=salesDetailPo\\.ssesdsalesitemids]').get(index).value=json.bgigoodsid;
	        $('input[name=salesDetailPo\\.ssesdsalesitemids]').get(index).title=json.bgigoodsid;
	        $('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(index).attr("trindex",trindex);
	        
	        $('input[name=salesDetailPo\\.ssesdsalesitemnames]').get(index).value=json.bgigoodsname;
	        $('input[name=salesDetailPo\\.ssesdsalesitemnames]').get(index).title=json.bgigoodsname;
	        $('input[name=salesDetailPo\\.ssesdsalesitemnames]').eq(index).attr("trindex",trindex);
	        
	        $('input[name=salesDetailPo\\.ssesdsprices]').get(index).value=json.bgiretailprice;
	        $('input[name=salesDetailPo\\.ssesdsprices]').eq(index).attr("trindex",trindex);
	        
	        $('input[name=salesDetailPo\\.ssesdrenums]').get(index).value="0.00";
	        $('input[name=salesDetailPo\\.ssesdrenums]').eq(index).attr("trindex",trindex);
	        
	        $('input[name=salesDetailPo\\.ssesdnumbers]').get(index).value="1";
	        $('input[name=salesDetailPo\\.ssesdnumbers]').eq(index).attr("trindex",trindex);
	        if( (json.glassflag=='R' || json.glassflag=='L' || json.glassflag=='') && $("input[name=salestype]:checked").val() == '1'){
	        	$('input[name=salesDetailPo\\.ssesdnumbers]').eq(index).attr("readonly","readonly");
		    }
	        
	        $('input[name=salesDetailPo\\.ssesdpricesums]').get(index).value=json.bgiretailprice;
	        $('input[name=salesDetailPo\\.ssesdpricesums]').eq(index).attr("trindex",trindex);
	        
	        $('input[name=salesDetailPo\\.ssesdcostsprives]').get(index).value=json.bgicostprice;
	        $('input[name=salesDetailPo\\.ssesdcostsprives]').eq(index).attr("trindex",trindex);
	        
	        $('input[name=salesDetailPo\\.ssesdunitprices]').get(index).value=json.bginottaxrate;
	        $('input[name=salesDetailPo\\.ssesdunitprices]').eq(index).attr("trindex",trindex);

	        $('input[name=salesDetailPo\\.ssesdstockids]').get(index).value=json.bgiwarehouseid;
	        $('input[name=salesDetailPo\\.ssesdstockids]').eq(index).attr("trindex",trindex);

	        $('input[name=salesDetailPo.ssesdfavorables]').get(index).value='0.00';
	        $('input[name=salesDetailPo.ssesdfavorables]').eq(index).attr("trindex",trindex);

			if(json.guaranteeperiod){
	        	$('input[name=salesDetailPo.ssesdguaranteeperiods]').get(index).value=json.guaranteeperiod;
			}else{
				$('input[name=salesDetailPo.ssesdguaranteeperiods]').get(index).value='';
			}
	        $('input[name=salesDetailPo.ssesdguaranteeperiods]').eq(index).attr("trindex",trindex);

	        if(json.batch){
	        	$('input[name=salesDetailPo.ssesdbatchs]').get(index).value=json.batch;
			}else{
				$('input[name=salesDetailPo.ssesdbatchs]').get(index).value='';
			}
	        $('input[name=salesDetailPo.ssesdbatchs]').eq(index).attr("trindex",trindex);
     		
	        var goodsdiscount;    
	        var titlediscounttmp = $('#titlediscount').val();
	        if (titlediscounttmp==null || $.trim(titlediscounttmp)=='' || isNaN(titlediscounttmp)){
	            titlediscounttmp="1.0";
	 	    }
	 	    if (Number(titlediscounttmp) < Number(json.maxdiscount)){
	 	    	titlediscounttmp=json.maxdiscount;        
		 	} 
        	$('input[name=salesDetailPo\\.ssesddiscountrates]').get(index).value=titlediscounttmp;
        	$('input[name=salesDetailPo\\.ssesddiscountrates]').eq(index).attr("trindex",trindex);
        	goodsdiscount=titlediscounttmp;
            
        	$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(index).attr("maxdiscount",json.maxdiscount);
        	if (json.maxdiscount != ''){
        		$("input[id=chk]").each(function (){
            		$(this).attr("checked","checked");
        		});
        		setDiscount1(titlediscounttmp,'1','','','');
        		$("input[id=chk]").each(function (){
            		$(this).attr("checked","");
        		});
            }
        	goodsdiscount = '1'
	        var ssje=getSumasd(accMul(goodsdiscount,json.bgiretailprice));
	       	var zkje=parseFloat(accSub(json.bgiretailprice,ssje)).toFixed(2);
	       	
			$('input[name=salesBasicPo.ssesbdiscountnum]')[0].value=zkje;
	        $('input[name=salesDetailPo\\.ssesddiscountnums]').get(index).value=getSumasd(zkje);
	        $('input[name=salesDetailPo\\.ssesddiscountnums]').eq(index).attr("trindex",trindex);
	        
	        $('input[name=salesBasicPo.ssesbsalesvalue]')[0].value=ssje;
	        $('input[name=salesDetailPo\\.ssesdsalesvalues]').get(index).value=ssje;
	        $('input[name=salesDetailPo\\.ssesdsalesvalues]').eq(index).attr("trindex",trindex);
	        
	        if(json.bgigoodsid.substring(0,1)=='4' && json.glassflag=='R'){
	        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="隐形右眼镜片";
	        	$('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="4";
	        	$('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="R";
	        	$('input[name=orderCycle]').get(index).value=json.bgiordercycle;
	        }else if(json.bgigoodsid.substring(0,1)=='4' && json.glassflag=='L'){
	        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="隐形左眼镜片";
	        	$('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="4";
	        	$('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="L";
	        	$('input[name=orderCycle]').get(index).value=json.bgiordercycle;
	        }else if(json.bgigoodsid.substring(0,1)=='3' && json.glassflag=='R'){
	        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="右眼镜片";
	        	$('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="3";
	        	$('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="R";
	        	$('input[name=orderCycle]').get(index).value=json.bgiordercycle;
	        }else if(json.bgigoodsid.substring(0,1)=='3' && json.glassflag=='L'){
	        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="左眼镜片";
	        	$('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="3";
	        	$('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="L";
	        	$('input[name=orderCycle]').get(index).value=json.bgiordercycle;
	        }else if(json.bgigoodsid.substring(0,1)=='1' && json.glassflag==''){
	        	 $('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="镜架";
	        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="1";
	        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="F";
	        }else if(json.glassflag=='A'){
	        	if(json.bgigoodsid.substring(0,1)=='6' && category=='太阳镜'){
		        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="太阳镜";
		        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="6";
		        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="";
		        }else if(json.bgigoodsid.substring(0,1)=='8' && category=='老花镜'){
		        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="老花镜";
		        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="8";
		        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="";
		        }else if(json.bgigoodsid.substring(0,1)=='9' && category=='视光商品'){
		        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="视光商品";
		        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="9";
		        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="";
		        }else if(json.bgigoodsid.substring(0,1)=='2' && category=='辅料'){
		        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="配件";
		        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="2";
		        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="";
		        }else if(json.bgigoodsid.substring(0,1)=='5' && category=='护理液'){
		        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="护理液";
		        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="5";
		        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="";
		        }else if(json.bgigoodsid.substring(0,1)=='7'){
		        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="耗材";
		        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="7";
		        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="";
		        }
		    }
	        
	        $('input[name=salesDetailPo\\.iscustomizes]').get(index).value=json.iscustomize;
	        if(json.bgigoodsid.substring(0,1) == '1' || json.bgigoodsid.substring(0,1) == '2' || json.bgigoodsid.substring(0,1) == '5' || json.bgigoodsid.substring(0,1) == '6' || json.bgigoodsid.substring(0,1) == '7' || json.bgigoodsid.substring(0,1) == '8' || json.bgigoodsid.substring(0,1) == '9'){
	        	$('input[name=salesDetailPo\\.ssesditemids]').get(index).value=json.bgigoodsbarcode;
			}else if(json.bgigoodsid.substring(0,1) == '4'){
				if(json.iscustomize == '0'){
					$('input[name=salesDetailPo\\.ssesditemids]').get(index).value=json.bgigoodsbarcode;
				}
			}else{
				$('input[name=salesDetailPo\\.ssesditemids]').get(index).value='';
			}

	}

	function setDiscount1(discount,discounttype,discountperson,ddiscounttype,ddiscountsource){//2012/2/2 零折
		if(discount != ''){
			$('input[name=salesBasicPo\\.ssesbdiscountrate]').val(discount);
		}
		if(discounttype != ''){
			$('input[name=salesBasicPo\\.ssesbdiscounttype]').val(discounttype);//2012/2/2 零折
		}
		if(discountperson != ''){
			$('input[name=salesBasicPo\\.ssesbdiscountperson]').val(discountperson);//2012/2/2 零折
		}
		//折扣率赋值
		for(var i = 0; i < $('input[name=salesDetailPo.ssesdsalesitemids]').size(); i++){
			if($('input[name=salesDetailPo.ssesdsalesitemids]').eq(i).parent().parent().parent().find("#chk").attr("checked")){
	            if($('input[name=salesDetailPo.ssesdsalesitemids]').eq(i).val() != ''){		
		            if(discounttype != '2'){									
			            var maxdiscount = $('input[name=salesDetailPo.ssesdsalesitemids]').eq(i).attr("maxdiscount");
						if(maxdiscount!='' && Number(maxdiscount) > Number(discount)){							
							$('input[name=salesDetailPo.ssesddiscountrates]').eq(i).val(parseFloat(maxdiscount).toFixed(2));
							var ssje=accMul(maxdiscount,$('input[name=salesDetailPo.ssesdpricesums]').eq(i).val());
	       	                var zkje=parseFloat(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val(),ssje)).toFixed(2);
							$('input[name=salesDetailPo.ssesddiscountnums]').eq(i).val(getSumasd(zkje));
						}else{
							$('input[name=salesDetailPo.ssesddiscountrates]').eq(i).val(parseFloat(discount).toFixed(2));
							var ssje=accMul(discount,$('input[name=salesDetailPo.ssesdpricesums]').eq(i).val());
	       	                var zkje=parseFloat(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val(),ssje)).toFixed(2);
							$('input[name=salesDetailPo.ssesddiscountnums]').eq(i).val(getSumasd(zkje));
						}
		            }else{			            
		            	$('input[name=salesDetailPo.ssesddiscountrates]').eq(i).val(parseFloat(discount).toFixed(2));
						var ssje=accMul(discount,$('input[name=salesDetailPo.ssesdpricesums]').eq(i).val());
	       	            var zkje=parseFloat(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val(),ssje)).toFixed(2);
						$('input[name=salesDetailPo.ssesddiscountnums]').eq(i).val(getSumasd(zkje));
						
			        }	
	            }
	            if(maxdiscount > 0){
		        	$('input[name=maxdiscount]').eq(i).val(parseFloat(maxdiscount).toFixed(2));
			    }
			}											
		}
	    									
			
		/*$('input[name=salesDetailPo\\.ssesddiscountrates]').each(function(){
			$(this).val(discount);
		});*/
		if(ddiscounttype != ''){
			$('input[name=salesDetailPo\\.ssesddiscounttypes]').each(function(){
				$(this).val(ddiscounttype);
			});
		}
		if(ddiscountsource != ''){
			$('input[name=salesDetailPo\\.ssesddiscountsources]').each(function(){
				$(this).val(ddiscountsource);
			});
		}
		$('input[name=salesDetailPo\\.ssesdsalesvalues]')[0].value="";
	}
	
	function getSumasd(mm){		
		var nn="";
		if('${systemParameterPo.fspsalescounttype}' == '1'){
			if('${systemParameterPo.fspretained}'==1)
			{
				nn=parseFloat(mm).toFixed(0)+'.00';
			}
			if('${systemParameterPo.fspretained}'==2)
			{				
				nn=parseFloat(mm).toFixed(1)+'0';
			}
			if('${systemParameterPo.fspretained}'==3)
			{				
				nn=parseFloat(mm).toFixed(2);
			}
		}else{
			if('${systemParameterPo.fspretained}'==1)
			{
				if (accSub(Number(mm),Number(Math.floor(mm))) >= 1 ){
					nn=parseFloat(mm).toFixed(2);
				}else{
					nn=parseFloat(Math.floor(mm)).toFixed(2);
			    }
			}
			if('${systemParameterPo.fspretained}'==2)
			{				
				if (accSub(Number(accMul(mm,10)),Number(Math.floor(accMul(mm,10)))) >= 1 ){
					nn=parseFloat(mm).toFixed(2);
				}else{
					nn=parseFloat(accDiv(Math.floor(accMul(mm,10)),10)).toFixed(2);
			    }
			}
			if('${systemParameterPo.fspretained}'==3)
			{				
				if (accSub(Number(accMul(mm,100)),Number(Math.floor(accMul(mm,100)))) >= 1 ){
					nn=parseFloat(mm).toFixed(2);
				}else{
					nn=parseFloat(accDiv(Math.floor(accMul(mm,100)),100)).toFixed(2);
			    }
			}
		}
		
		return nn;
	}

	function getGlassOptometryDate(direction, materialType){
		if($('#recipetype').val()=='0'&&$('#recipetype').attr('disabled')==false)
		{
			alert('请选择处方类型!');
			return '';
		}
		//球镜   sph
		//柱镜  cyl
	 	//下加 add
		var sph = '';
		var cyl = '';
		var add = '';
		var materialType = (direction == 'R') ? $('input[name=materialTypeR]:checked').val() : $('input[name=materialTypeL]:checked').val();
		var recipeType = $('#recipetype').val();
		
		// 翻方子
		if($("#salestype_input").val() != '5'){
			if($('input[glassType="yinxing"][name$="ssesbballglassod"]')[0].value==''){
				alert('请填写右眼球镜!');
				$('input[glassType="yinxing"][name$="ssesbballglassod"]')[0].focus();
				return '';
			}
			if($('input[glassType="yinxing"][name$="ssesbballglassos"]')[0].value==''){
				alert('请填写左眼球镜!');
				$('input[glassType="yinxing"][name$="ssesbballglassos"]')[0].focus();
				return '';
			}
		}
		if($('input[glassType="yinxing"][name$="ssesbpostglassod"]')[0].value==''){
			$('input[glassType="yinxing"][name$="ssesbpostglassod"]')[0].value='0.00';
		}
		if($('input[glassType="yinxing"][name$="ssesbpostglassos"]')[0].value==''){
			$('input[glassType="yinxing"][name$="ssesbpostglassos"]')[0].value='0.00';
		}
		if('${systemParameterPo.fspothernegative}'=='1'){
		turnPrescription($('input[glassType="yinxing"][name$="ssesbballglassod"]')[0]
			, $('input[glassType="yinxing"][name$="ssesbpostglassod"]')[0]
			, $('input[glassType="yinxing"][name$="ssesbaxesod"]')[0]);
		turnPrescription($('input[glassType="yinxing"][name$="ssesbballglassos"]')[0]
			, $('input[glassType="yinxing"][name$="ssesbpostglassos"]')[0]
			, $('input[glassType="yinxing"][name$="ssesbaxesos"]')[0]);
		}
		sph = (direction == 'R') ? 
			$('input[glassType="yinxing"][name$="ssesbballglassod"]')[0] : $('input[glassType="yinxing"][name$="ssesbballglassos"]')[0];
		cyl = (direction == 'R') ? 
			$('input[glassType="yinxing"][name$="ssesbpostglassod"]')[0] : $('input[glassType="yinxing"][name$="ssesbpostglassos"]')[0];
		
		return "&sph="+sph.value+"&cyl="+cyl.value+"&add="+ ((add != '') ? add.value : '') +"&glassFlag=" + direction+"&materialType="+materialType+"&recipeType="+recipeType;
	}

    function checkContactSales(goodsid,type){
        var checknum = 0;
        var cpp = 0;
        var djp = 0;
        for(var i = 1; i < $('input[name=salesDetailPo\\.ssesdsalesitemids]').size(); i++){
			if($('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).val().substring(8,9) == 'D' || $('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).val().substring(8,9) == 'd'){
				djp = djp + 1;
			}else{
				cpp = cpp + 1;
			}
		}

		if(djp > 0 && (goodsid.substring(8,9) != 'D' && goodsid.substring(8,9) != 'd')  ){
			alert("隐形成品片与订制片不可同时进行销售！");
			return;
		}

		if(cpp > 0 && (goodsid.substring(8,9) == 'D' || goodsid.substring(8,9) == 'd')  ){
			alert("隐形成品片与订制片不可同时进行销售！");
			return;
		}

        for(var i = 1; i < $('input[name=salesDetailPo\\.ssesdsalesitemids]').size(); i++){
			if(djp > 0 && ($('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).val().substring(2,4) != goodsid.substring(2,4))){
				alert("隐形订制片需要销售同一制造商的商品！");
				return;
			}
		}

		return true;
    }

	// 翻方子
	function turnPrescription(sph, cyl, axis){
		sph.value = sph.value.replace('+', '');
		cyl.value = cyl.value.replace('+', '');
		
		if(cyl.value > 0){
			sph.value = (new Number(sph.value) + new Number(cyl.value)).toFixed(2);
			
			cyl.value = -cyl.value;
			
			if(!isNaN(axis.value) && axis.value > 90){
				axis.value = (new Number(axis.value) - 90).toFixed(0);
			}else if(!isNaN(axis.value) && axis.value <= 90){
				axis.value = (new Number(axis.value) + 90).toFixed(0);
			}else {
				axis.value = 0;
			}
		}
		checkData(sph);
		checkData(cyl);
		checkAxiss(axis);
	}

	/*
	删除行
	*/
	function deleteItem(item){
		$(item).parent().parent().parent().remove();
	}

    function rowamount(obj){
        var trindex = $(obj).attr("trindex");
		var shuliangv = $("input[name=salesDetailPo.ssesdnumbers][trindex="+trindex+"]");
		var danjiav   = $("input[name=salesDetailPo.ssesdsprices][trindex="+trindex+"]");
		var yuanjias  = $("input[name=salesDetailPo.ssesdpricesums][trindex="+trindex+"]");
		var zhekoulv  = $("input[name=salesDetailPo.ssesddiscountrates][trindex="+trindex+"]");
		var zhekouv   = $("input[name=salesDetailPo.ssesddiscountnums][trindex="+trindex+"]");
		var molingv   = $("input[name=salesDetailPo.ssesdrenums][trindex="+trindex+"]");
		var yingshouv = $("input[name=salesDetailPo.ssesdsalesvalues][trindex="+trindex+"]");
		var youhuiv = $("input[name=salesDetailPo.ssesdfavorables][trindex="+trindex+"]");
		if((/^(\+|-)?\d+$/.test( shuliangv.val() ))&& shuliangv.val() > 0){  
			yuanjias.val(parseFloat(danjiav.val()*shuliangv.val()).toFixed(2));
		}else{
			alert("商品数量格式有误！");
			shuliangv.select();
			shuliangv.focus();
			return;
		}
		
		zhekouv.val(getSumasd(accMul(yuanjias.val(),accSub('1',zhekoulv.val()))));
		var mm=accSub(accSub(accSub(yuanjias.val(),zhekouv.val()),molingv.val()),youhuiv.val());
		yingshouv.val(getSumasd(mm));
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="arrearsForm" method="post" action="">
<input type="hidden" id="customerID" name="customerID" value="${requestScope.smecicustomerid }">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID }">
<input type="hidden" id="salesid" name="salesid" value="${requestScope.salesid }">
<input name="salesBasicPo.ssesbsalesvalue" type="hidden">
<input name="arrearssalesvalue" type="hidden" value="${salesBasicPo.ssesbsalesvalue }">
<input name="salesBasicPo.ssesbdiscountnum" type="hidden">
<input id="ssesbcheckoutflag" name="salesBasicPo.ssesbcheckoutflag" type="hidden">
<input id="shopcode" name="salesBasicPo.ssesbshopcode" type="hidden" value="${salesBasicPo.ssesbshopcode }">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
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
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                 
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
		             <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="8%" height="26" class="table_body">配镜单号</TD>
                          <TD width="25%" class="table_none">${salesBasicPo.ssesbsalesid }&nbsp;
                          </TD>
                          <TD width="8%" height="26" class="table_body">配镜门店</TD>
                          <TD width="25%" class="table_none">${salesBasicPo.ssesbshopName }&nbsp;
						  </TD>
						   <TD width="8%" height="26" class="table_body">顾客姓名</TD>
                          <TD width="25%" class="table_none">${salesBasicPo.ssesbpersonName }&nbsp;
						  </TD>
                        </TR> 
                        <TR>
                         
                          <TD width="8%" height="26" class="table_body">顾客电话</TD>
							<TD width="25%" class="table_none">${salesBasicPo.ssesbphone }&nbsp;
						  </TD>
						  <TD width="8%" height="26" class="table_body">顾客卡号</TD>
                          <TD width="25%" class="table_none">${salesBasicPo.ssesbMemberId}&nbsp;
						  </TD>
						   <TD width="8%" class="table_body">付款状态</TD>
							<TD width="25%" class="table_none">
								<c:choose>
									<c:when test="${salesBasicPo.ssesbvalueflag=='0'}">
										未收费
									</c:when>
									<c:when test="${salesBasicPo.ssesbvalueflag=='1'}">
										<c:choose>
											<c:when test="${salesBasicPo.ssesbcheckoutflag=='0'}">
												已收全款
											</c:when>
											<c:when test="${salesBasicPo.ssesbcheckoutflag=='1'}">
												欠费：${fn:substring(salesBasicPo.ssesbarrearsvalue,0,6)  }
											</c:when>
										</c:choose>
									</c:when>
								</c:choose>
	   					    </TD>
						 </tr>  						  
                        <TR> 
                          <TD width="8%" height="26" class="table_body">配镜日期</TD>
                          <TD width="25%" class="table_none">${fn:substring(salesBasicPo.ssesbsalesdatetime,0,19) }&nbsp;
						  </TD>
						  <TD width="8%" class="table_body">取镜门店</TD>
							<TD width="25%" class="table_none">${salesBasicPo.ssesbtakeshopname }
						  </TD>    
						   <TD width="8%" class="table_body">取镜日期</TD>
							<TD width="25%" class="table_none">${fn:substring(salesBasicPo.ssesbtakeglassdata,0,19) }&nbsp;
						  </TD>
                        </TR>
                        <TR> 
                          <TD width="8%" height="26" class="table_body">原价合计</TD>
                          <TD width="25%" class="table_none">${salesBasicPo.ssesbpricesum}&nbsp;
						  </TD>
                          <TD width="8%" height="26" class="table_body">折扣金额</TD>
							<TD width="25%" class="table_none">${salesBasicPo.ssesbdiscountnum}&nbsp;
						  </TD>
						    <TD width="8%" height="26" class="table_body">抹零金额</TD>
                          <TD width="25%" class="table_none">${salesBasicPo.ssesbrenums}&nbsp;
						  </TD>
                        </TR>
                        <TR> 
                          <TD width="8%" height="26" class="table_body">应收金额</TD>
                          <TD width="25%" class="table_none">${salesBasicPo.ssesbsalesvalue}&nbsp;
						  </TD>
						  <TD width="8%" height="26" class="table_body">实缴金额</TD>
							<TD width="25%" class="table_none">${salesBasicPo.ssesbpsalsvalue}&nbsp;
						  </TD>
						  <TD width="8%" height="26" class="table_body">邮寄状态</TD>
                          <TD width="25%" class="table_none">
                          	<c:choose>
                          		<c:when test="${salesBasicPo.isMail=='1'}"><a href="#" onClick="showMailDetails('${salesBasicPo.ssesbsalesid}');">已邮寄</a></c:when>
                          		<c:otherwise>未邮寄</c:otherwise>
                          	</c:choose>
                          </TD>
                        </TR>
                        <TR> 
                          <TD width="8%" height="26" class="table_body">配镜类型</TD>
                          <TD width="25%" class="table_none">
                          	<c:choose>
                          		<c:when test="${salesBasicPo.ssesborderstype=='1'}">框镜成品</c:when>
                          		<c:when test="${salesBasicPo.ssesborderstype=='2'}">框镜订做</c:when>
                          		<c:when test="${salesBasicPo.ssesborderstype=='3'}">隐形成品</c:when>
                          		<c:when test="${salesBasicPo.ssesborderstype=='4'}">隐形订做</c:when>
                          		<c:when test="${salesBasicPo.ssesborderstype=='5'}">辅料</c:when>
                          		<c:otherwise>&nbsp;</c:otherwise>
                          	</c:choose>
                          </TD>
                          <TD width="8%" height="26" class="table_body">退款状态</TD>
                          <TD width="25%" class="table_none" colspan="3">
                          	<c:choose>
                          		<c:when test="${salesBasicPo.ssesbwithdrawflag=='1'}"><font color="red">已退款</font></c:when>
                          		<c:otherwise>未退款</c:otherwise>
                          	</c:choose>
                          </TD>
                        </TR>
                      <c:if test="${not empty(specialPDetailList)}"> 
                        <TR> 
                          <TD width="15%" height="26" class="table_body">特殊加工要求</TD>
                          <TD width="15%" class="table_none" colspan="5" >
                          <font color="red" >
							<s:iterator value="specialPDetailList">
                              ${ssesdrequirement}&nbsp;&nbsp;&nbsp;&nbsp;
						    </s:iterator>	
						  </font>
						  </TD>
                        </TR>
                        </c:if>   
                        <tr>
                          <TD width="15%" height="26" class="table_body">销售备注</TD>
                          <TD class="table_none" colspan="5" width="85%">
                          	${salesBasicPo.ssesbsalesremark }&nbsp;
						  </TD>
                        </tr>
                    </TABLE>
                   <BR/>
                <c:if test="${not empty(salesODPo.ssesbballglassod)&&not empty(salesOSPo.ssesbballglassos)}">
                	 <fieldset>
					 <legend>处方信息</legend>     
                     <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                         <tr>
						 	<td width="9%" height="23" bgcolor="#F8E0F0" class="PrivateBorderPink">&nbsp;</td>
							<td width="10%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">球镜</div></td>
							<td width="10%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">柱镜</div></td>
							<td width="10%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">轴向</div></td>
							<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">曲率</div></td>
							<td width="10%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">直径</div></td>
							<td width="10%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">隐形VA</div></td>
						 </tr>
							 <tr>
							 	<td height="23" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">OD</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="1" needChange="needChange" sphcyl="sphcyl" name="salesBasicPo.ssesbballglassod" glassType="yinxing" class="text_input100" style="width:100%" value="${salesODPo.ssesbballglassod}">
								</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="2"  needChange="needChange" sphcyl="sphcyl" name="salesBasicPo.ssesbpostglassod" glassType="yinxing" class="text_input100" style="width:100%" value="${salesODPo.ssesbpostglassod}">
								</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="3" name="salesBasicPo.ssesbaxesod" axes="axes" glassType="yinxing" class="text_input100" style="width:100%" value="${salesODPo.ssesbaxesod}">
								</div></td>
								<td width="13%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="4" name="salesBasicPo.ssesbeyecurvatureod1" glassType="yinxing" class="text_input100" style="width:100%" value="${salesODPo.ssesbeyecurvatureod1}">
								  <input type="hidden" name="salesBasicPo.ssesbeyecurvatureod2" glassType="yinxing" class="text_input100" style="width:100%">
								</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="5" name="salesBasicPo.ssesbdiameterod" glassType="yinxing" class="text_input100" style="width:100%" value="${salesODPo.ssesbdiameterod}">
								</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="6" name="salesBasicPo.ssesbconlenvaod" va="va" glassType="yinxing" class="text_input100" style="width:100%" value="${salesODPo.ssesbconlenvaod}">
								</div></td>
							 </tr>
							 <tr>
						 	   <td height="23" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">OS</div></td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
							     <input yyorder="9"  needChange="needChange" sphcyl="sphcyl" name="salesBasicPo.ssesbballglassos" glassType="yinxing" class="text_input100" style="width:100%" value="${salesOSPo.ssesbballglassos}">
							   </div></td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
							     <input yyorder="10"  needChange="needChange" sphcyl="sphcyl" name="salesBasicPo.ssesbpostglassos" glassType="yinxing" class="text_input100" style="width:100%" value="${salesOSPo.ssesbpostglassos}">
							   </div></td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
							     <input yyorder="11" name="salesBasicPo.ssesbaxesos" axes="axes" glassType="yinxing" class="text_input100" style="width:100%" value="${salesOSPo.ssesbaxesos}">
							   </div></td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
							     <input yyorder="12" name="salesBasicPo.ssesbeyecurvatureos1" glassType="yinxing" class="text_input100" style="width:100%" value="${salesOSPo.ssesbeyecurvatureos1}">
							     <input type="hidden" name="salesBasicPo.ssesbeyecurvatureos2" glassType="yinxing" class="text_input100" style="width:100%">
							   </div></td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
							     <input yyorder="13" name="salesBasicPo.ssesbdiameteros" glassType="yinxing" class="text_input100" style="width:100%" value="${salesOSPo.ssesbdiameteros}">
							   </div></td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
							     <input yyorder="14" name="salesBasicPo.ssesbconlenvaos" va="va" glassType="yinxing" class="text_input100" style="width:100%" value="${salesOSPo.ssesbconlenvaos}">
							   </div></td>
							 </tr>				  
                      </TBODY>
                    </TABLE>
                    </fieldset>
				<br/>
			</c:if>	
				 <c:if test="${not empty(goodsInfoList)}"> 
				      <fieldset>
					  <legend>消费商品</legend>
					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="5%" height="26" scope=col>选择</TH>
                          <TH width="10%" height="26" scope=col>商品代码</TH>
						  <TH width="18%" scope=col>商品名称 </TH>						
						  <TH width="9%" scope=col>单价</TH>
						  <TH width="5%" scope=col>数量</TH>
						  <TH width="9%" scope=col>原价合计</TH>
						  <TH width="5%" scope=col>折扣率</TH>
						  <TH width="9%" scope=col>折扣金额</TH>
						  <TH width="8%" scope=col>抹零金额</TH>
						  <TH width="8%" scope=col>应收金额</TH>
						  <TH width="9%" scope=col>商品描述</TH>
						  <TH width="9%" scope=col>累计积分</TH>
						  </TR>
						<s:iterator value="goodsInfoList">
						  <c:choose>
                          	<c:when test="${goodsID==ssesdsalesitemid}">
	                    		<TR id="rowrow" class="row" style="background-color: red">
	                    	</c:when>
	                    	<c:otherwise>
	                    		<TR id="rowrow" class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
	                    	</c:otherwise>
                          </c:choose>
                          <c:choose>
                          	<c:when test="${fn:substring(ssesdsalesitemid,0,1) == '4' }">
	                    		<TD height="26"><input type="checkbox" id="chk" name="chk" value="${ssesdid}" amount="${ssesdsalesvalue}" goodsnum="${ssesdnumber}"></TD>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<TD height="26">&nbsp;</TD>
	                    	</c:otherwise>
                          </c:choose>
                          <TD>${ssesdsalesitemid}<input type="hidden" id="salesitemid" value="${ssesdsalesitemid}"/></TD>
                          <TD>${ssesdsalesitemname}</TD>
                          <TD>${ssesdsprice}</TD>
                          <TD>${ssesdnumber}</TD>
                          <TD>${ssesdpricesum}</TD>
                          <TD>${ssesddiscountrate}</TD>
                          <TD>${ssesddiscountnum}</TD>
                          <TD>${ssesdrenum}</TD>
                          <TD>${ssesdsalesvalue}</TD>
                          <TD>${ssesdgooddescribe}</TD>
                          <TD>
                            <fmt:formatNumber value="${ssesintegral*ssesdsalesvalue}" type="currency" pattern="0"/>
                          </TD>
						</TR>
						</s:iterator>						  
                      </TBODY>
                    </TABLE>
                    </fieldset>
                    </c:if>
                    <br/>
  				   <table width="100%" border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td width="25%" valign="top">
							<fieldset>
							<legend>销售类型</legend>
							<table width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                              <tr height="26">
                                <td width="33%" class="table_none">
                                	<input type="radio" name="salestype" value="1" disabled="disabled">框镜销售
                                </td>
                                <td width="33%" class="table_none">
                                	<input type="radio" name="salestype" value="3" checked="checked" >隐形销售
                                </td>
                                <td width="33%" class="table_none">
                                	<input type="radio" name="salestype" value="5" disabled="disabled">辅料销售
                                	<input type="hidden" value="1" id="salestype_input" name="salesBasicPo.ssesborderstype"/>
                                </td>
                              </tr>
                            </table>
							</fieldset>
							<c:if test="${systemParameterPo.fspbarcodetype != '3'}">
							<br/>
							<table width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                              <tr height="26">
                                <td width="25%" class="table_body">
                                	条码扫描
                                </td>
                                <td class="table_none">
                                	<input type="text" class="text_input200" id="inputscanbarcode" onkeypress="scanGoods(this)" maxlength="26">
                                </td>
                              </tr>
                            </table>
							</c:if>
							<c:if test="${systemParameterPo.fspbarcodetype == '3' || systemParameterPo.fspbarcodetype == '2'}">
							<br/>
                            <table id="yx" width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                              <tr>
                                <td width="25%" class="table_body">隐形镜片</td>
                                <td colspan="4" class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="javascript:addSalesGoods('4','R','','','','');"></td>
                              </tr>
                            </table>
                            </c:if>
							</td>
							<td width="1%"></td>
                            <td width="75%" valign="top">
							<fieldset>
							<legend>换取商品</legend>
							<table id="goodsInfo" width="100%" height="74" border="0" cellpadding="1" cellspacing="1">
                              <tr>
                                <td valign="top">
                                <table id="goodstable" width="100%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                                  <tr>
                                    <!-- <td width="10%" class="table_body" height="26"><div align="center">商品代码</div></td>  -->
                                    <td width="10%" class="table_body"><div align="center">商品代码</div></td>
                                    <td width="10%" class="table_body"><div align="center">商品名称</div></td>
                                    <td width="5%"  class="table_body"><div align="center">单价</div></td>
                                    <td width="3%"  class="table_body"><div align="center">数量</div></td>
                                    <td width="5%"  class="table_body"><div align="center">原价合计</div></td>                                  
                                    <td width="5%"  class="table_body"><div align="center">应收金额</div></td>
                                    <td width="3%"  class="table_body"><div align="center">删除</div></td>
                                  </tr>
                                  <tr id="copyrow" style="display:none" trsl=trsl>
                             		<td   class="Privateborder"><div align="center"><input  type="text" style="width: 100%;background:transparent;border:0px;" name="salesDetailPo.ssesdsalesitemids" maxdiscount=""/></div></td>
                                    <td   class="Privateborder"><input  style="width: 100%;background:transparent;border:0px;" title=""  name="salesDetailPo.ssesdsalesitemnames" readonly="readonly"   class="text_inputhidden"></td>
                                    <td   class="Privateborder"><input  style="width: 100%;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesdsprices"        readonly="readonly"   class="text_inputhidden yjje"></td>
                                    <td   class="Privateborder"><input  style="width: 100%;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesdnumbers"    maxlength="2"    class="text_inputhidden" onblur="rowamount(this)"></td>
                                    <td   class="Privateborder">
                                         <input style="width: 100%;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesdpricesums"    readonly="readonly"   class="text_inputhidden pricesum"/>
	                                     <input type="hidden" readonly="readonly" name="salesDetailPo.ssesddiscountrates"  readonly="readonly"/>
	                                     <input type="hidden" name="rownumber" readonly="readonly" />
	                                     <input type="hidden" id="ssesddiscounttypes" name="salesDetailPo.ssesddiscounttypes" readonly="readonly" />
	                                     <input type="hidden" id="ssesddiscountsources" name="salesDetailPo.ssesddiscountsources" readonly="readonly" />
	                                     <input type="hidden" name="maxdiscount" readonly="readonly"/>
	                                     <input type="hidden" name="salesDetailPo.ssesddiscountnums" readonly="readonly" />
	                                     <input type="hidden" value="0.00" name="salesDetailPo.ssesdfavorables" readonly="readonly" />
	                                     <input type="hidden" name="salesDetailPo.ssesdguaranteeperiods" readonly="readonly" />
	                                     <input type="hidden" name="salesDetailPo.ssesdbatchs" readonly="readonly" />
	                                     <input type="hidden" name="salesDetailPo.ssesdrenums" readonly="readonly" />
                                     </td>
                                    <td   class="Privateborder"><input type="text" style="width: 100%;" name="salesDetailPo.ssesdsalesvalues" class="text_inputhidden yssum">
                                    <input type="hidden" style="width: 100%;" title="" name="salesDetailPo.ssesdgooddescribes"  class="text_inputhidden salesout"><input type="hidden" name="salesDetailPo.ssesdcostsprives"/><input type="hidden" name="salesDetailPo.ssesditemids"/><input type="hidden" name="salesDetailPo.ssesdunitprices"/><input type="hidden" name="salesDetailPo.iscustomizes"/><input type="hidden" name="salesDetailPo.ssesdcommoditiesflags"/><input type="hidden" name="orderCycle"/></td>
                                    <td   class="Privateborder"><div  align="center"><input type="hidden" class="cccc" id="ssesdglassflags" name="salesDetailPo.ssesdglassflags"/><img src="${ctx }/img/newbtn/delete_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/delete_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/delete_0.png');" btn=btn title='删除' onclick="deleteItem(this);"><input type="hidden" class="cccc" id="ssesdstockids" name="salesDetailPo.ssesdstockids"/></div></td>
                                   </tr>
                                </table>
                                </td>
                              </tr>
                            </table>
							</fieldset>
						   </td>
                          </tr>
                        </table>
							<br/>
                    <c:if test="${not empty(addititonalCDetailList)}"> 
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="25%" height="26" scope=col>附加费用名称</TH>
						  <TH width="25%" scope=col>附加费用金额 </TH>	
						  <TH width="25%" scope=col>数量 </TH>	
						  <TH width="25%" scope=col>附加费合计 </TH>					
						  </TR>
						<s:iterator value="addititonalCDetailList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">${ssecostsname}</TD>
                          <TD>${sseamount}</TD>
                          <TD>${ssenumber}</TD>
                          <TD><fmt:formatNumber value="${ssesum}" type="currency" pattern="0.00"/></TD>
						</TR>
						</s:iterator>						  
                      </TBODY>
                    </TABLE>
                    </c:if>
                    <br/>
             <c:if test="${not empty(goodsInfoList)}">        
                    <TABLE>
                    </TBODY>
                        <TR>
                        	<TD width="100%" height="26" colspan="2" align="center" ><img src="${ctx }/img/newbtn/btn_count_0.png" btn=btn id="saveButton" name="button3223" title='结算' onclick="refundSales()"/></TD>
                        </TR>                
                      </TBODY>
                    </TABLE>
              </c:if>      
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