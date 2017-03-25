<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/select_many_checked.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<script type="text/javascript" src="/WebReport/ReportServer?op=emb&resource=finereport.js"></script>
<title>仓库管理</title>
</head>
<script>

	$(document).ready(function() {
		if ('${usingWarehouse}' == '2'){
			$("#warehouseID").hide();
			$("#warehouseID3").hide();        
		}

		if ('${usingWarehouse}' == '1'){
			$("#warehouseID").hide();      
		}

		if ('${usingWarehouse}' == '0'){
			$("#warehouseID3").hide();      
		}
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
		checkalerttype();
	});
	
	function ismendretail(){
		var isshow = $("#select_retail").val();
		if(isshow == '1'){
			$("#div_retail").show();
		}else{
			$("#div_retail").hide();
			$("#bgiretailbeginprice").val("");
			$("#bgiretailendprice").val("");
		}
	}
	
    function storagefxSel(id){
    	var goodsBarcode;
    	var goodsID=document.all.goodsID.value;
    	var goodsBarcode1=document.all.goodsBarcode.value;
    	if(goodsBarcode1!="")
    	{
    		goodsBarcode=goodsBarcode1;
    	}else
    	{
    		goodsBarcode="";
    	}
    	var goodscategoryID=document.all.goodscategoryID.value;
    	var goodsName=document.all.goodsName.value;
    	var supplierID=$("input[id=supplierID]").val();
    	if($("input[id=supplierID]").size() == 0){
    		supplierID='';
        }
        
    	var brandID=$("input[id=brandID]").val();
    	if($("input[id=brandID]").size() == 0){
    		brandID='';
        }
    	var usingWarehouse=document.all.usingWarehouse.value;
    	var warehouseID=$("#warehouseIDs").val();
    	var warehouseStatus=document.all.warehouseStatus.value;
    	var bgiretailbeginprice=document.all.bgiretailbeginprice.value;
    	if (bgiretailbeginprice != '' && bgiretailbeginprice != null){
    	    var str = bgiretailbeginprice.replace(/[^\.]/g,'');
    	    if (str.length > 1){
    	        alert("零售价格的金额格式不正确!");
    	        $('#bgiretailbeginprice').val('');
    	        return;
    	   }
    	}
    	var bgiretailendprice=document.all.bgiretailendprice.value;
    	if (bgiretailendprice != '' && bgiretailendprice != null){
    	    var str = bgiretailendprice.replace(/[^\.]/g,'');
    	    if (str.length > 1){
    	        alert("零售价格的金额格式不正确!");
    	        $('#bgiretailendprice').val('');
    	        return;
    	   }
    	}
    	
    	var departmenttype='${departmenttype}';  //部门类型
    	var departmentID='${departmentID}';      //部门ID  
    	var bgispecjj=$('#bgispecjj').val();              //型号
    	var bgicolorjj=$('#bgicolorjj').val();            //色号
    	var bgispeclh=$('#bgispeclh').val();              //型号
    	var bgicolorlh=$('#bgicolorlh').val();            //色号
    	if(!bgispecjj){
    		bgispecjj = bgispeclh;
        }
    	if(!bgicolorjj){
    		bgicolorjj = bgicolorlh;
        }
    	var bgiframesizejj=$('#bgiframesizejj').val();         //尺寸 
    	var bgieyeglassmaterialtypejp=$('#bgieyeglassmaterialtypejp').val(); //镜片材料分类
    	var bgirefractivejp=$('#bgirefractivejp').val(); //镜片折射率
    	var bgiismutiluminosityjp=$('#bgiismutiluminosityjp').val(); //镜片光度分类
    	var minSphjp=$('#minSphjp').val(); //镜片球镜范围
    	var maxSphjp=$('#maxSphjp').val(); //镜片球镜范围
    	var minCyljp=$('#minCyljp').val(); //镜片柱镜范围
    	var maxCyljp=$('#maxCyljp').val(); //镜片柱镜范围
    	var bgiusetypeyj=$('#bgiusetypeyj').val(); //隐形使用类型
    	var bgistealthclassyj=$('#bgistealthclassyj').val(); //抛弃型分类
    	var minSphyj=$('#minSphyj').val(); //隐形球镜范围
    	var maxSphyj=$('#maxSphyj').val(); //隐形球镜范围
    	var minCylyj=$('#minCylyj').val(); //隐形柱镜范围
    	var maxCylyj=$('#maxCylyj').val(); //隐形柱镜范围
    	var isClosed=$('#isClosed').val(); //商品状态
    	var bgiothergoodsbigclass=$('#bgiothergoodsbigclass').val();
    	var bgiothergoodssmallclass=""; 
    	var minSphlh=$('#minSphlh').val(); 
    	var maxSphlh=$('#maxSphlh').val(); 
    	var whichretail = $("#whichretail").val();
    	var shareInfo='${systemParameterPo.fspsharestockmessage}';  //是否共享库存信息    1:共享   0:不共享 
    	var pjlx = $("#pjlx").val();
    	var talerttype = $("#talerttype").val();
    	if(!talerttype){
    		talerttype = '';
        }

        var isCustomize = '';
        if (goodscategoryID == '3'){
        	isCustomize = $('#isCustomizejp').val();
        }
        if (goodscategoryID == '4'){
        	isCustomize = $('#isCustomizeyx').val();
        }
        
        var DataURL = "report.action?reportlet=StorageSearchSelRpt.cpt&goodsID="+goodsID+"&goodsBarcode="+goodsBarcode+"&goodscategoryID="
                      +goodscategoryID+"&goodsName="+EncodeUtf8(goodsName)+"&supplierID="+supplierID+"&brandID="+brandID+"&usingWarehouse="+usingWarehouse
                      +"&warehouseID="+warehouseID+"&warehouseStatus="+warehouseStatus+"&bgiretailbeginprice="+bgiretailbeginprice+"&bgiretailendprice="
                      +bgiretailendprice+"&departmenttype="+departmenttype+"&departmentID="+departmentID+"&bgispecjj="+bgispecjj+"&bgicolorjj="
                      +bgicolorjj+"&bgiframesizejj="+bgiframesizejj+"&bgieyeglassmaterialtypejp="+bgieyeglassmaterialtypejp+"&bgirefractivejp="+bgirefractivejp+"&bgiismutiluminosityjp="+bgiismutiluminosityjp
                      +"&minSphjp="+minSphjp+"&maxSphjp="+maxSphjp+"&minCyljp="+minCyljp+"&maxCyljp="+maxCyljp
                      +"&bgiusetypeyj="+bgiusetypeyj+"&bgistealthclassyj="+bgistealthclassyj+"&minSphyj="+minSphyj+"&maxSphyj="+maxSphyj
                      +"&minCylyj="+minCylyj+"&maxCylyj="+maxCylyj+"&isClosed="+isClosed+"&shareInfo="+shareInfo+"&whichretail="+whichretail+"&bgiothergoodsbigclass="+bgiothergoodsbigclass+"&bgiothergoodssmallclass="+bgiothergoodssmallclass
                      +"&minSphlh="+minSphlh+"&maxSphlh="+maxSphlh+"&pjlx="+pjlx+"&talerttype="+talerttype+"&isCustomize="+isCustomize;
      
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(DataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【商品库存明细表】";
    }

    function storagebrandfxSel(id){
    	var goodsBarcode;
    	var goodsID=document.all.goodsID.value;
    	var goodsBarcode1=document.all.goodsBarcode.value;
    	if(goodsBarcode1!="")
    	{
    		goodsBarcode=goodsBarcode1.substr(0,18);
    	}else{
    		goodsBarcode="";
    	}
    	var goodscategoryID=document.all.goodscategoryID.value;
    	var goodsName=document.all.goodsName.value;
    	var supplierID=$("input[id=supplierID]").val();
    	if($("input[id=supplierID]").size() == 0){
    		supplierID='';
        }
    	var brandID=$("input[id=brandID]").val();
    	if($("input[id=brandID]").size() == 0){
    		brandID='';
        }
    	var usingWarehouse=document.all.usingWarehouse.value;
    	var warehouseID=$("#warehouseIDs").val();
    	var warehouseStatus=document.all.warehouseStatus.value;
    	
    	var bgiretailbeginprice=document.all.bgiretailbeginprice.value;
    	if (bgiretailbeginprice != '' && bgiretailbeginprice != null){
    	    var str = bgiretailbeginprice.replace(/[^\.]/g,'');
    	    if (str.length > 1){
    	        alert("零售价格的金额格式不正确!");
    	        $('#bgiretailbeginprice').val('');
    	        return;
    	   }
    	}
    	var bgiretailendprice=document.all.bgiretailendprice.value;
    	if (bgiretailendprice != '' && bgiretailendprice != null){
    	    var str = bgiretailendprice.replace(/[^\.]/g,'');
    	    if (str.length > 1){
    	        alert("零售价格的金额格式不正确!");
    	        $('#bgiretailendprice').val('');
    	        return;
    	    }
    	}
    	
    	var departmenttype='${departmenttype}';  //部门类型
    	var departmentID='${departmentID}';      //部门ID  

    	var bgispecjj=$('#bgispecjj').val();              //型号
    	var bgicolorjj=$('#bgicolorjj').val();            //色号
    	var bgispeclh=$('#bgispeclh').val();              //型号
    	var bgicolorlh=$('#bgicolorlh').val();            //色号
    	if(!bgispecjj){
    		bgispecjj = bgispeclh;
        }
    	if(!bgicolorjj){
    		bgicolorjj = bgicolorlh;
        }
    	var bgiframesizejj=$('#bgiframesizejj').val();         //尺寸 
    	var bgieyeglassmaterialtypejp=$('#bgieyeglassmaterialtypejp').val(); //镜片材料分类
    	var bgirefractivejp=$('#bgirefractivejp').val(); //镜片折射率
    	var bgiismutiluminosityjp=$('#bgiismutiluminosityjp').val(); //镜片光度分类
    	var minSphjp=$('#minSphjp').val(); //镜片球镜范围
    	var maxSphjp=$('#maxSphjp').val(); //镜片球镜范围
    	var minCyljp=$('#minCyljp').val(); //镜片柱镜范围
    	var maxCyljp=$('#maxCyljp').val(); //镜片柱镜范围
    	var bgiusetypeyj=$('#bgiusetypeyj').val(); //隐形使用类型
    	var bgistealthclassyj=$('#bgistealthclassyj').val(); //抛弃型分类
    	var minSphyj=$('#minSphyj').val(); //隐形球镜范围
    	var maxSphyj=$('#maxSphyj').val(); //隐形球镜范围
    	var minCylyj=$('#minCylyj').val(); //隐形柱镜范围
    	var maxCylyj=$('#maxCylyj').val(); //隐形柱镜范围
    	var isClosed=$('#isClosed').val(); //商品状态
    	var bgiothergoodsbigclass=$('#bgiothergoodsbigclass').val();
    	var bgiothergoodssmallclass=""; 
    	var minSphlh=$('#minSphlh').val(); 
    	var maxSphlh=$('#maxSphlh').val();
    	var price_group = $("input[name=price_group]:checked").val();
    	var whichretail = $("#whichretail").val();
    	var shareInfo='${systemParameterPo.fspsharestockmessage}';  //是否共享库存信息    1:共享   0:不共享    	
    	var pjlx = $("#pjlx").val();	

        var isCustomize = '';
        if (goodscategoryID == '3'){
        	isCustomize = $('#isCustomizejp').val();
        }
        if (goodscategoryID == '4'){
        	isCustomize = $('#isCustomizeyx').val();
        }
        
        var DataURL = "report.action?reportlet=StorageBrandSearchSelRpt.cpt&goodsID="+goodsID+"&goodsBarcode="+goodsBarcode+"&goodscategoryID="
                      +goodscategoryID+"&goodsName="+EncodeUtf8(goodsName)+"&supplierID="+supplierID+"&brandID="+brandID+"&usingWarehouse="+usingWarehouse
                      +"&warehouseID="+warehouseID+"&warehouseStatus="+warehouseStatus+"&bgiretailbeginprice="+bgiretailbeginprice+"&bgiretailendprice="
                      +bgiretailendprice+"&departmenttype="+departmenttype+"&departmentID="+departmentID+"&bgispecjj="+bgispecjj+"&bgicolorjj="
                      +bgicolorjj+"&bgiframesizejj="+bgiframesizejj+"&bgieyeglassmaterialtypejp="+bgieyeglassmaterialtypejp+"&bgirefractivejp="+bgirefractivejp+"&bgiismutiluminosityjp="+bgiismutiluminosityjp
                      +"&minSphjp="+minSphjp+"&maxSphjp="+maxSphjp+"&minCyljp="+minCyljp+"&maxCyljp="+maxCyljp
                      +"&bgiusetypeyj="+bgiusetypeyj+"&bgistealthclassyj="+bgistealthclassyj+"&minSphyj="+minSphyj+"&maxSphyj="+maxSphyj
                      +"&minCylyj="+minCylyj+"&maxCylyj="+maxCylyj+"&isClosed="+isClosed+"&shareInfo="+shareInfo+"&price_group="+price_group+"&bgiothergoodsbigclass="+bgiothergoodsbigclass+"&bgiothergoodssmallclass="+bgiothergoodssmallclass
                      +"&minSphlh="+minSphlh+"&maxSphlh="+maxSphlh+"&pjlx="+pjlx+"&isCustomize="+isCustomize;
      
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(DataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【商品库存明细表】";
    }

	function search(){
		var StockQueryConditions= '${systemParameterPo.fspstockqueryconditions}'.split(',');
		if('${departmenttype}'==1){
			if('${systemParameterPo.fspsharestockmessage}'=='1'&&StockQueryConditions!='4'){
				for(var i=0;i<StockQueryConditions.length;i++){
					if(StockQueryConditions[i]=='1'){
						if($('#goodsID').val()==''){
							alert("请选择商品代码！");
							return;
						}
					}
					if(StockQueryConditions[i]=='2'){
						if($('#goodsBarcode').val()==''){
							alert("请选择商品条码！");
							return;
						}
					}
					if(StockQueryConditions[i]=='3'){
						if($('#goodsName').val()==''){
							alert("请选择商品名称！");
							return;
						}
					}
				}
				
			}
		}

	    if (document.getElementById("rksjend").value==''){
			alert("入库时间不能为空！");
			document.getElementById("rksjend").focus();
			return;
	    }		

	    if (document.getElementById("usingWarehouse").value=='0'){
	    	getSelectValue('warehouseID','warehouseIDs');
	    }else if (document.getElementById("usingWarehouse").value=='1'){
	    	getSelectValue('warehouseID3','warehouseIDs');  		
	    }else if (document.getElementById("usingWarehouse").value=='2'){
	    	document.getElementById("warehouseIDs").value="";
	    }
	    
    	if(checkForm(procurementReceiptForm)){  
    		$("img").removeAttr("onclick");
    		procurementReceiptForm.action = "stockAgeSearchSel.action";
    		procurementReceiptForm.submit();
    		showLoadingBar();
        }

	}	

	function clean(){
		$("#goodsID").val('');
		$("#goodsName").val('');
		$("#goodscategoryID").val('');
		$("#supplierID").val('');
		$("#supplierName").val('');
		$("#brandID").val('');
		$("#brandName").val('');		
		$("#goodsBarcode").val('');
		$("#warehouseStatus").val('1');
		$("#bgiretailbeginprice").val('');
		$("#bgiretailendprice").val('');
		$("#isClosed").val('');
		$('#whichretail').val('1');
		$('#radio_goods').attr('checked',true);
		$('#price_group_yes').attr('checked',true);
		document.getElementById('radioBtn_0').checked=true;
        $('#bgitechnologytypeid').val('');
        $('#bgiframematerialtype').val('');
        
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

		$("#talerttype").val('');
		$("#rksjbegin").val('');
		$("#rksjend").val('');

		changeWarehouse('0');

        resetSelectList('warehouseID');
        resetSelectList('warehouseID3');		
	}	
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
			/**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID= document.all.goodscategoryID.value;
		
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
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var supplierID=document.getElementById('supplierID').value;
	    var goodscategoryID= document.all.goodscategoryID.value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
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

	function amount(){
    	var goodsquantityTotal = 0;

		var goodsquantity = document.getElementsByName("goodsquantity");
		
		for(i=0;i<goodsquantity.length;i++){
			if(goodsquantity[i].value == '') continue;
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(0);
		}
		
		if(document.getElementById("goodsquantityTotal")!=null){
			document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
		}

	}

	function selectContact(obj){
		if(event.keyCode==13){
			//search();
		}
	}
	
	function changeWarehouse(val){
		$('#usingWarehouse').val(val);

	    if (val=='0'){
			$("#warehouseID").show();
			$("#warehouseID3").hide();
	    }else if (val=='1'){
			$("#warehouseID").hide();
			$("#warehouseID3").show();		
	    }else if (val=='2'){
			$("#warehouseID").hide();
			$("#warehouseID3").hide();
	    }
	}
	
	$(document).ready(function(){
		amount();
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
	});
	
	function showterm(){
		var category = $("select[id=goodscategoryID]").val();
		$("#isCustomizejp").val('');
		$("#isCustomizeyx").val('');
		if(category == '' || category == '5' || category == '9'){
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
		
		if(category == '1' || category == '6'){
				$("tr[id=jj]").show();
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
			if(category == '6' || category == '8'){
				$("tr[nolh=nolh]").hide();
				$("tr[nolh=nolh]").find("select").val('');
			}
			$("#bgispecjj").val('');
			$("#bgicolorjj").val('');
			$("#bgiframesizejj").val('');
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
		
		if(category == '3'){
			    $("tr[id=jj]").hide();
				$("#bgispecjj").val('');
				$("#bgicolorjj").val('');
				$("#bgiframesizejj").val('');
			    $("tr[id=jp]").show();
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
		
		if(category == '4'){
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
			$("tr[id=yj]").show();
		}

		if(category == '7'){
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
			$("tr[id=lh]").hide();
				$("#minSphlh").val('');
				$("#maxSphlh").val('');
				$("#bgispeclh").val('');
				$("#bgicolorlh").val('');
			$("tr[id=pj]").hide();
				$("#pjlx").val('');
			$("tr[id=hc]").show();
		}

		if(category == '8'){
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
			$("tr[id=pj]").hide();
				$("#pjlx").val('');
			$("tr[id=lh]").show();
		}

		if(category == '2'){
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
			$("tr[id=pj]").show();
		}
	}

	function showStockDetails(bgigoodsid,bgiwarehouseid,goodsBarcode){
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selectStockGoodsinfoPo2.action?moduleID=${requestScope.moduleID}&bgigoodsid="+bgigoodsid+"&bgiwarehouseid=" + bgiwarehouseid+"&goodsBarcode="+goodsBarcode,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectStockGoodsinfoPo2.action?moduleID=${requestScope.moduleID}&bgigoodsid="+bgigoodsid+"&bgiwarehouseid=" + bgiwarehouseid+"&goodsBarcode="+goodsBarcode,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品详细】";
	}

	function showBrandDetails(bgibrandsid,bgiwarehouseid,bgiretailprice){
		var bgispecjj=$('#bgispecjj').val();              //型号
    	var bgicolorjj=$('#bgicolorjj').val();            //色号
    	var bgiframesizejj=$('#bgiframesizejj').val();         //尺寸 
    	var bgieyeglassmaterialtypejp=$('#bgieyeglassmaterialtypejp').val(); //镜片材料分类
    	var bgirefractivejp=$('#bgirefractivejp').val(); //镜片折射率
    	var bgiismutiluminosityjp=$('#bgiismutiluminosityjp').val(); //镜片光度分类
    	var minSphjp=$('#minSphjp').val(); //镜片球镜范围
    	var maxSphjp=$('#maxSphjp').val(); //镜片球镜范围
    	var minCyljp=$('#minCyljp').val(); //镜片柱镜范围
    	var maxCyljp=$('#maxCyljp').val(); //镜片柱镜范围
    	var bgiusetypeyj=$('#bgiusetypeyj').val(); //隐形使用类型
    	var bgistealthclassyj=$('#bgistealthclassyj').val(); //抛弃型分类
    	var minSphyj=$('#minSphyj').val(); //隐形球镜范围
    	var maxSphyj=$('#maxSphyj').val(); //隐形球镜范围
    	var minCylyj=$('#minCylyj').val(); //隐形柱镜范围
    	var maxCylyj=$('#maxCylyj').val(); //隐形柱镜范围
    	var isClosed=$('#isClosed').val(); //商品状态
    	var bgitechnologytypeid = $('#bgitechnologytypeid').val() ; //工艺类型
    	var bgiframematerialtype = $('#bgiframematerialtype').val() ; //镜架材质
    	var warehouseStatus = $('#warehouseStatus').val() ;
	    var url = "&bgispecjj="+bgispecjj+"&bgicolorjj="+bgicolorjj+"&bgiframesizejj="+bgiframesizejj+"&bgieyeglassmaterialtypejp="+bgieyeglassmaterialtypejp+
	    		  "&bgirefractivejp="+bgirefractivejp+"&bgiismutiluminosityjp="+bgiismutiluminosityjp+"&minSphjp="+minSphjp+"&maxSphjp="+maxSphjp+
	    		  "&minCyljp="+minCyljp+"&maxCyljp="+maxCyljp+"&bgiusetypeyj="+bgiusetypeyj+"&bgistealthclassyj="+bgistealthclassyj+
	    		  "&minSphyj="+minSphyj+"&maxSphyj="+maxSphyj+"&minCylyj="+minCylyj+"&maxCylyj="+maxCylyj+"&isClosed="+isClosed+"&bgitechnologytypeid="+bgitechnologytypeid+"&bgiframematerialtype="+bgiframematerialtype+"&warehouseStatus="+warehouseStatus;
		
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selStockSearch.action?moduleID=${requestScope.moduleID}&searchKey=openwindow&radio_type=goods&price_group=yes&usingWarehouse=0&bgiretailbeginprice="+bgiretailprice+"&bgiretailendprice="+bgiretailprice+"&whichretail="+ ${whichretail} +"&goodsID="+bgibrandsid+"&warehouseID=" + bgiwarehouseid+url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selStockSearch.action?moduleID=${requestScope.moduleID}&searchKey=openwindow&radio_type=goods&price_group=yes&usingWarehouse=0&bgiretailbeginprice="+bgiretailprice+"&bgiretailendprice="+bgiretailprice+"&whichretail="+ ${whichretail} +"&goodsID="+bgibrandsid+"&warehouseID=" + bgiwarehouseid+url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品详细】";
	}

	function bgiothergoodsbigclassOnChange(){
		var selectedOption = "${goodsInfoPo.bgiothergoodssmallclass}";
		var obj;
		if(procurementReceiptForm.bgiothergoodsbigclass.value=="Q"){//其它材料
			procurementReceiptForm.bgiothergoodssmallclass.options.length=0;
			procurementReceiptForm.bgiothergoodssmallclass.options.add(new Option("----请选择----",""));
			
			obj = new Option("办公用品","001");
			obj.setAttribute("selected", (selectedOption == "001"));
			procurementReceiptForm.bgiothergoodssmallclass.options.add(obj); 

			obj = new Option("印刷品","002");
			obj.setAttribute("selected", (selectedOption == "002"));
			procurementReceiptForm.bgiothergoodssmallclass.options.add(obj);

			obj = new Option("眼镜用具","003");
			obj.setAttribute("selected", (selectedOption == "003"));
			procurementReceiptForm.bgiothergoodssmallclass.options.add(obj);

			obj = new Option("其它","004");
			obj.setAttribute("selected", (selectedOption == "004"));
			procurementReceiptForm.bgiothergoodssmallclass.options.add(obj);
			
		}else if(procurementReceiptForm.bgiothergoodsbigclass.value=="D"){//低值易耗品
			procurementReceiptForm.bgiothergoodssmallclass.options.length=0;
			procurementReceiptForm.bgiothergoodssmallclass.options.add(new Option("----请选择----","")); 

			obj = new Option("加工工具","001");
			obj.setAttribute("selected", (selectedOption == "001"));
			procurementReceiptForm.bgiothergoodssmallclass.options.add(obj);

			obj = new Option("办公工具","002"); 
			obj.setAttribute("selected", (selectedOption == "002"));
			procurementReceiptForm.bgiothergoodssmallclass.options.add(obj);

			obj = new Option("验配工具","003");
			obj.setAttribute("selected", (selectedOption == "003"));
			procurementReceiptForm.bgiothergoodssmallclass.options.add(obj);

			obj = new Option("其它","004");
			obj.setAttribute("selected", (selectedOption == "004"));
			procurementReceiptForm.bgiothergoodssmallclass.options.add(obj);
		}		
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

	function checkalerttype(){
		if($("input[name=radio_type]:checked").val() != "goods" || $("input[name=radioBtn]:checked").val() == "2"){
			$("#talerttype").attr("disabled","disabled");
			$("#talerttype").val("");
		}else{
			$("#talerttype").attr("disabled","");
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } onkeyup="selectContact(this)">
<form name="procurementReceiptForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="departmenttype" value="${departmenttype}">
<input type="hidden" name="departmentID" value="${departmentID}">
<input type="hidden" name="searchKey" value="${searchKey}">
<input type=hidden id="warehouseIDs" name="warehouseID" value="${warehouseID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>库存管理</TD>
            <td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：商品库龄查询</td>
            <TD align="right" valign="bottom">&nbsp;
              &nbsp;
            </TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                    <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                     <c:if test="${empty(searchKey)}">
                      <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">商品库龄查询</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>

                  
        </c:if>
                     </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                           <TD height="26" class="table_body">商品类型</TD>
			               <TD class="table_none" ${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1' ? '':'colspan="5"'}>
                            <select id="goodscategoryID" name="goodscategoryID"} onchange="showterm();">
      		                 <option value="">----请选择----</option>
      		                 <option value="1" ${goodscategoryID == '1' ? 'selected="selected"' : '' }>镜架</option>
      		                 <option value="2" ${goodscategoryID == '2' ? 'selected="selected"' : '' }>配件</option>
      		                 <option value="3" ${goodscategoryID == '3' ? 'selected="selected"' : '' }>成品片</option>
      		                 <option value="6" ${goodscategoryID == '6' ? 'selected="selected"' : '' }>太阳镜</option>
      		                 <option value="7" ${goodscategoryID == '7' ? 'selected="selected"' : '' }>耗材</option>
      		                 <option value="8" ${goodscategoryID == '8' ? 'selected="selected"' : '' }>老花镜</option>
      		                 <option value="9" ${goodscategoryID == '9' ? 'selected="selected"' : '' }>视光</option>

      	                   </select>
			               </TD>
			                <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1'}">
                           <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" class="text_input160" readonly="readonly" name="supplierName" value="${supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } />
							   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
									</li>
						   			<li class="horizontal_onlyRight">
						  				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openSupplier();"></li>
			               </TD>			               
						   <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						   	<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openBrand();"></li>
			               </TD>
			               </c:if>
                        </TR>
					  	<TR>
						   <TD height="26" class="table_body">商品代码</TD>
			               <TD class="table_none" width="24%">
                            <input class="text_input160" type="text"  id="goodsID" name="goodsID" value="${requestScope.goodsID}" maxlength="22">
			               </TD>
						   <TD height="26" class="table_body">商品条码</TD>
			               <TD class="table_none">
                            <input class="text_input200" type="text" id="goodsBarcode" name="goodsBarcode" value="${goodsBarcode}" maxlength="26">
			               </TD>
			               <TD height="26" class="table_body">商品名称</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="goodsName" name="goodsName" value="${requestScope.goodsName}" maxlength="32">
			               </TD>
                        </TR>
                      

                        <tr id="jj">
                           <TD height="26" class="table_none">型号</TD>
			               <TD class="table_none" width="24%">
                            <input class="text_input160" type="text"  id="bgispecjj" name="bgispecjj" value="${requestScope.bgispecjj}" maxlength="30">
			               </TD>
						   <TD height="26" class="table_none" >色号</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="bgicolorjj" name="bgicolorjj" value="${bgicolorjj}" maxlength="10">
			               </TD>
			               <TD height="26" class="table_none">尺寸</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="bgiframesizejj" name="bgiframesizejj" value="${requestScope.bgiframesizejj}" maxlength="10">
			               </TD>
                        </tr>
                        <tr id="jj" nolh=nolh>
                        	<TD height="26" class="table_none">工艺类型</TD>
			               <TD class="table_none" width="24%">
                            <select id="bgitechnologytypeid" name="bgitechnologytypeid">
                            	<option value="">----请选择----</option>
                            	<s:iterator value="teachnologyList">
                            		<option ${bgitechnologytypeid eq fttid ? 'selected="selected"' : '' } value="${fttid }">${fttname }</option>
                            	</s:iterator>
                            </select>
			               </TD>
						   <TD height="26" class="table_none" >镜架材质</TD>
			               <TD class="table_none">
                            <select id="bgiframematerialtype" name="bgiframematerialtype" >
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
                            	<select id="bgieyeglassmaterialtypejp" name="bgieyeglassmaterialtypejp"}>
      		                 		<option value="">----请选择----</option>
				               		<option value="1" ${bgieyeglassmaterialtypejp == '1' ? 'selected="selected"' : '' }>树脂</option>
				               		<option value="2" ${bgieyeglassmaterialtypejp == '2' ? 'selected="selected"' : '' }>玻璃</option>
				               		<option value="3" ${bgieyeglassmaterialtypejp == '3' ? 'selected="selected"' : '' }>PC</option>
      	                   		</select>
			                </TD>
						    <TD height="26" class="table_none">镜片折射率</TD>
			                <TD class="table_none">
                            	<select id="bgirefractivejp" name="bgirefractivejp"}>
      		                 	<option value="">----请选择----</option>
			               		 <s:iterator value="refractiveSetPos">
				                   <option value="${brfname}" ${bgirefractivejp == brfname ? 'selected="selected"' : '' }>${brfname}</option>
		     	                 </s:iterator>
      	                   		</select>
			                </TD>
			                <TD height="26" class="table_none">镜片光度分类</TD>
			                <TD class="table_none">
                            	<select id="bgiismutiluminosityjp" name="bgiismutiluminosityjp"}>
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
                            <input class="text_input80" type="text" onchange="checkNumberType(this);"  id="minSphjp" name="minSphjp" value="${requestScope.minSphjp}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写镜片柱镜度数！'}]">
                            	至
                            <input class="text_input80" type="text" onchange="checkNumberType(this);" id="maxSphjp" name="maxSphjp" value="${requestScope.maxSphjp}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写镜片柱镜度数！'}]">
			               </TD>
						   <TD height="26" class="table_none" >镜片柱镜范围</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text" onchange="checkNumberType(this);" id="minCyljp" name="minCyljp" value="${requestScope.minCyljp}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写镜片柱镜度数！'}]">
                            	至
                            <input class="text_input80" type="text" onchange="checkNumberType(this);" id="maxCyljp" name="maxCyljp" value="${requestScope.maxCyljp}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写镜片柱镜度数！'}]">
			               </TD>
			                <TD height="26" class="table_none">订做状态</TD>
			                <TD class="table_none">
                            	<select id="isCustomizejp" name="isCustomizejp"}>
      		                 		<option value="" ${isCustomizejp == '' ? 'selected="selected"' : '' }>----请选择----</option>
				               		<option value="0" ${isCustomizejp == '0' ? 'selected="selected"' : '' }>成品片</option>
				               		<option value="D" ${isCustomizejp == 'D' ? 'selected="selected"' : '' }>订做片</option>
      	                   		</select>
			               </TD>
                        </tr>
                        
                        <tr id="yj">
                        	<TD height="26" class="table_none">隐形使用类型</TD>
			                <TD class="table_none">
                            	<select id="bgiusetypeyj" name="bgiusetypeyj"}>
      		                 		<option value="">----请选择----</option>
				               		<option value="1" ${bgiusetypeyj == '1' ? 'selected="selected"' : '' }>常带型</option>
				               		<option value="2" ${bgiusetypeyj == '2' ? 'selected="selected"' : '' }>抛弃型</option>
				               		<option value="3" ${bgiusetypeyj == '3' ? 'selected="selected"' : '' }>塑形镜</option>
      	                   		</select>
			                </TD>
						    <TD height="26" class="table_none">抛弃型分类</TD>
			                <TD class="table_none" colspan="3">
                            	<select id="bgistealthclassyj" name="bgistealthclassyj"}>
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
                            <input class="text_input80" type="text"  id="minSphyj" name="minSphyj" value="${requestScope.minSphyj}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写隐形球镜度数！'}]">
                            	至
                            <input class="text_input80" type="text"  id="maxSphyj" name="maxSphyj" value="${requestScope.maxSphyj}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写隐形球镜度数！'}]">
			               </TD>
						   <TD height="26" class="table_none" >隐形柱镜范围</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text"  id="minCylyj" name="minCylyj" value="${requestScope.minCylyj}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写隐形柱镜度数！'}]">
                            	至
                            <input class="text_input80" type="text"  id="maxCylyj" name="maxCylyj" value="${requestScope.maxCylyj}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写隐形柱镜度数！'}]">
			               </TD>
			               <TD height="26" class="table_none">订做状态</TD>
			                <TD class="table_none">
                            	<select id="isCustomizeyx" name="isCustomizeyx"}>
      		                 		<option value="" ${isCustomizeyx == '' ? 'selected="selected"' : '' }>----请选择----</option>
				               		<option value="0" ${isCustomizeyx == '0' ? 'selected="selected"' : '' }>成品片</option>
				               		<option value="D" ${isCustomizeyx == 'D' ? 'selected="selected"' : '' }>订做片</option>
      	                   		</select>
			               </TD>
                        </tr>
                        <tr id="pj">
                           <TD height="26" class="table_none">配件型</TD>
			               <TD class="table_none" colspan="5">
                             <select id="pjlx" name="pjlx">
      		                   <option value="">----请选择----</option>
				               <option ${pjlx eq "1" ? 'selected="selected"' : '' } value="1" >框镜</option>
				               <option ${pjlx eq "2" ? 'selected="selected"' : '' } value="2" >隐形</option>
      	                     </select>
			               </TD>
                        </tr>
                        <tr id="hc">
                           <TD  height="26" class="table_none">其它商品大类</TD>
			               <TD class="table_none" colspan="5">
                             <select id="bgiothergoodsbigclass" name="bgiothergoodsbigclass">
      		                   <option value="">----请选择----</option>
				               <option ${bgiothergoodsbigclass eq "Q" ? 'selected="selected"' : '' } value="Q" >其它材料</option>
				               <option ${bgiothergoodsbigclass eq "D" ? 'selected="selected"' : '' } value="D" >低值易耗品</option>
      	                     </select>
			               </TD>
			               <%--
			               <TD  class="table_body">其它商品小类</TD>
			               <TD class="table_none">
                             <select id="bgiothergoodssmallclass" name="bgiothergoodssmallclass">
      		                   <option value="">----请选择----</option>
      	                    </select><label style="color:red;">&nbsp;*</label>
			               </TD>--%>
                        </tr>
                        <tr id="lh">
                        	<TD height="26" class="table_none">老花球镜范围</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text"  id="minSphlh" name="minSphlh" value="${requestScope.minSphlh}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写老花镜度数！'}]">
                            	至
                            <input class="text_input80" type="text"  id="maxSphlh" name="maxSphlh" value="${requestScope.maxSphlh}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写老花镜度数！'}]">
			               </TD>
			               <TD width="9%" height="26" class="table_none">型号</TD>
			               <TD class="table_none" width="24%">
                            <input class="text_input160" type="text"  id="bgispeclh" name="bgispeclh" value="${requestScope.bgispeclh}" maxlength="30">
			               </TD>
						   <TD width="9%" height="26" class="table_none" >色号</TD>
			               <TD width="24%" class="table_none">
                            <input class="text_input160" type="text"  id="bgicolorlh" name="bgicolorlh" value="${requestScope.bgicolorlh}" maxlength="10">
			               </TD>
                        </tr>
                           <TR>
					      <TD height="27" class="table_body">仓位名称</TD>
			               <TD class="table_none" colspan="3">
			               <li class="horizontal_onlyRight">
							<input type="hidden" id="usingWarehouse" name="usingWarehouse" value="${usingWarehouse}">
      	                    <input type="radio" id="radioBtn_0" name="radioBtn" value="0" onclick="changeWarehouse('0');checkalerttype();" ${usingWarehouse == '0' ? 'checked' : '' }>启用仓
      	                    <input type="radio" id="radioBtn_1" name="radioBtn" value="1" onclick="changeWarehouse('1');checkalerttype();" ${usingWarehouse == '1' ? 'checked' : '' }>停用仓
	      	                </li>&nbsp;&nbsp;&nbsp;
	      	                   <li class="horizontal_onlyRight">
	      	                   <select id="warehouseID" name="warehouseID2" multiple="multiple" size="20">
	                           	<option value="">----请选择----</option>
	      		                 <s:iterator value="warehouselist">
					               <c:if test="${bwhisclosed == '0'}">
					                   <option value="${bwhid}" >${bwhwarehouseName}</option><!--${warehouseID == bwhid ? 'selected="selected"' : '' }  -->
					               </c:if>
		     	                 </s:iterator>
	      	                   </select>
	      	                   
	      	                   <select id="warehouseID3" name="warehouseID3" multiple="multiple" size="20">
	                           	<option value="">----请选择----</option>
	      		                 <s:iterator value="warehouselist">
					               <c:if test="${bwhisclosed == '1'}">
					                   <option value="${bwhid}">${bwhwarehouseName}</option><!--${warehouseID == bwhid ? 'selected="selected"' : '' }  -->
					               </c:if>
		     	                 </s:iterator>
	      	                   </select>
	      	                   </li>
			               </TD>
			               <TD  height="26" class="table_body">商品状态</TD>
			               <TD  class="table_none"> 
								<select id="isClosed" name="isClosed">
                            	<option value="">----请选择----</option>
                            	<option value="1" ${requestScope.isClosed eq 1 ? 'selected="selected"' : '' }>启用</option>
                            	<option value="0" ${requestScope.isClosed eq 0 ? 'selected="selected"' : '' }>停用</option>
								</select>
			               </TD>
                        </TR>
                        <TR>
                           <c:if test="${departmenttype == '1' }">
			               <TD  height="26" class="table_body">零售价格${whichretail }</TD>
			               <TD  class="table_none"><input class="text_input60" type="text"  id="bgiretailbeginprice" name="bgiretailbeginprice" value="${requestScope.bgiretailbeginprice}" onKeyUp="value=value.replace(/[^\d\.]/g,'')" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写零售价!'}]" maxlength="10"> ~ <input class="text_input60" type="text"  id="bgiretailendprice" name="bgiretailendprice" value="${requestScope.bgiretailendprice}" onKeyUp="value=value.replace(/[^\d\.]/g,'')" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写零售价!'}]" maxlength="10">
			               <input type="hidden" value="${whichretail }" name="whichretail" id="whichretail"/>
			               </TD>
			               </c:if>
			               <c:if test="${departmenttype != '1' }">
			               <TD  height="26" class="table_body"><select id="whichretail" name="whichretail">
	                            <c:if test="${systemParameterPo.fspretailprice=='1' }">
									<option value="1" ${whichretail == '1' ? 'selected':'' }>标准零售价格</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricea=='1' }">
									<option value="2" ${whichretail == '2' ? 'selected':'' }>零售价格2</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceb=='1' }">
									<option value="3" ${whichretail == '3' ? 'selected':'' }>零售价格3</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricec=='1' }">
									<option value="4" ${whichretail == '4' ? 'selected':'' }>零售价格4</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriced=='1' }">
									<option value="5" ${whichretail == '5' ? 'selected':'' }>零售价格5</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricee=='1' }">
									<option value="6" ${whichretail == '6' ? 'selected':'' }>零售价格6</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricef=='1' }">
									<option value="7" ${whichretail == '7' ? 'selected':'' }>零售价格7</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceg=='1' }">
									<option value="8" ${whichretail == '8' ? 'selected':'' }>零售价格8</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceh=='1' }">
									<option value="9" ${whichretail == '9' ? 'selected':'' }>零售价格9</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricei=='1' }">
									<option value="10" ${whichretail == '10' ? 'selected':'' }>零售价格10</option>
								</c:if>
	                      	  </select></TD>
			               <TD  class="table_none">
			               <input class="text_input60" type="text"  id="bgiretailbeginprice" name="bgiretailbeginprice" value="${requestScope.bgiretailbeginprice}" onKeyUp="value=value.replace(/[^\d\.]/g,'')" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写零售价!'}]" maxlength="10"> ~ <input class="text_input60" type="text"  id="bgiretailendprice" name="bgiretailendprice" value="${requestScope.bgiretailendprice}" onKeyUp="value=value.replace(/[^\d\.]/g,'')" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写零售价!'}]" maxlength="10">
			               </TD>
			               </c:if>
			               <TD height="26" class="table_body">入库时间</TD>
			               <TD class="table_none">
			               <li class="horizontal_onlyRight"><input id="rksjbegin"
					       name="rksjbegin" 
					       type="text" class="text_input80" clean=clean  
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'rksjend\')}'})"
					       value="${rksjbegin }" /> 至 
					       <input id="rksjend" clean=clean 
					       name="rksjend" 
					       type="text" class="text_input80" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'rksjbegin\')}'})" 
					        value="${rksjend }" /> </li><li class="horizontal_onlyRight">
							</li>

			               </TD>
			               <TD  width="10%" class="table_body">筛选库存信息</TD>
			               <TD class="table_none">
                            <select id="warehouseStatus" name="warehouseStatus">
				               <option value="1" ${warehouseStatus == '1' ? 'selected="selected"' : '' }>忽略库存为0的商品</option>
	     	                   <option value="0" ${warehouseStatus == '0' ? 'selected="selected"' : '' }>显示库存所有的商品</option>
	     	                   <option value="4" ${warehouseStatus == '4' ? 'selected="selected"' : '' }>显示库存=0的商品</option>
	     	                   <option value="3" ${warehouseStatus == '3' ? 'selected="selected"' : '' }>显示库存>0的商品</option>
	     	                   <option value="2" ${warehouseStatus == '2' ? 'selected="selected"' : '' }>显示库存<0的商品</option>
      	                    </select>
			               </TD>
                        </TR>
  
                      </TBODY>
                    </table>
                    <c:if test="${permissionPo.keya=='1'}">
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn id="submitButton" title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
							</td>
						</tr>
					</table>
					</c:if>
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					 
 
                                  
					<c:if test="${not empty(goodsList)}"> 
					   <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
	                     <TBODY>
	                       <TR>
	                         <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
	                         <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
	                       </TR>
	                     </TBODY>
	                   </table>
					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>                      
                          <TH width="13%" height="26" scope=col>商品代码</TH>
                          <TH width="15%" scope=col>商品条码</TH>
                          <TH scope=col>商品名称</TH>
                          <TH width="7%" scope=col>商品类别</TH>
                          <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1'}">
                          <TH width="10%" scope=col>制造商</TH>
                          </c:if>
                          <TH width="7%" scope=col>
                          		<c:if test="${whichretail=='1'}">
                        			标准零售价
								</c:if>
								<c:if test="${whichretail=='2'}">
                        			零售价格2
								</c:if>
								<c:if test="${whichretail=='3'}">
                        			零售价格3
								</c:if>
								<c:if test="${whichretail=='4'}">
                        			零售价格4
								</c:if>
								<c:if test="${whichretail=='5'}">
                        			零售价格5
								</c:if>
								<c:if test="${whichretail=='6'}">
                        			零售价格6
								</c:if>
								<c:if test="${whichretail=='7'}">
                        			零售价格7
								</c:if>
								<c:if test="${whichretail=='8'}">
                        			零售价格8
								</c:if>
								<c:if test="${whichretail=='9'}">
                        			零售价格9
								</c:if>
								<c:if test="${whichretail=='10'}">
                        			零售价格10
								</c:if>
						  </TH>
                          <TH width="10%" scope=col>仓位</TH>
                          <TH width="8%" scope=col>入库时间</TH>
                          <TH width="4%" scope=col>数量</TH>
						</TR>
						<TR class=table_title align=middle> 
						  <TH width="40%" height="26" ${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1' ? 'colspan="8"':'colspan="7"'} scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					      <TH scope=col width="5%" id="goodsquantityTotal">0</TH>
				   		</TR>  
						<s:iterator value="goodsList">
						<c:if test="${empty(alerttype)}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">   
                        </c:if>
                        <c:if test="${alerttype eq '4' }">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" style="color: red;">   
                        </c:if>
						<c:if test="${alerttype eq '3' }">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" style="color: #9F0050;">   
                        </c:if>
                        <c:if test="${alerttype eq '2' || alerttype eq '5'}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">   
                        </c:if>
                        <c:if test="${alerttype eq '1' }">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" style="color: blue;">   
                        </c:if>
                          <TD height="26">${bgigoodsid}</TD>
                        
                        	  <TD>
	                          	<U style="cursor: hand;" onclick="showStockDetails('${bgigoodsid }','${bgiwarehouseid }','${bgigoodsbarcode}')">${bgigoodsbarcode}</U>
	                          </TD>
	                          <TD>
	                          	${bgiviewgoodsname}
	                          </TD>

	                          <TD>
	                          	${bgigoodscategoryname}
	                          </TD>
	                          <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1'}">
	                          <TD>
	                          	${bgisuppliername}
	                          </TD>
	                          </c:if>
                          <TD>${bgiretailprice}</TD>
                          <TD>${bgiwarehousename}</TD>
                          <TD>${bgirksj}</TD>
                          <TD>${bgigoodsquantity}<input type="hidden" name="goodsquantity" value="${bgigoodsquantity}"/></TD> 
						</TR>
						</s:iterator>
						<TR class=table_title align=middle> 
						    <TH width="40%" height="26"  ${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1' ? 'colspan="8"':'colspan="7"'} scope=col align="right">库存合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%">${requestScope.titlenum}</TH>
				   		</TR>  
                      </TBODY>
                    </table>
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
	               </c:if>
                  </DIV>
                </DIV>

                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE>
</TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<script>
	initSelectList('warehouseID','warehouseIDs');
	initSelectList('warehouseID3','warehouseIDs'); 
</script>
<%@ include file="/WEB-INF/inc/message.jsp" %>