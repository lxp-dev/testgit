<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/select_many_checked.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>

<title>仓库管理</title>
</head> 
<script>

	$(document).ready(function() {	
	/**Ajax----------读取项目列表-------------**/
	var url = "ajaxSelBrandList.action";
	var options = {
		width : 300,				 //下拉框的宽度，default：input元素的宽度
		scrollHeight: 350,　　　　　　 // 下拉框的高度， Default: 180
		minChars: 0, 　　　　　　　　      //至少输入的字符数，default：1；如果设为0，在输入框内双击或者删除内容时显示列表。  
		max:100000,					 //下拉项目的个数，default：10
		selectFirst : false,		 // 如果设置成true,下拉列表的第一个值将被自动选择, Default: true
		autoFill : false,			 // 是否自动填充. Default: false
		dataType : 'json',
		cacheLength : 0, 			 //缓存的长度.即缓存多少条记录.设成1为不缓存.Default: 10
		delay: 400,    　　　　　　　　      //击键后的延迟时间(单位毫秒).Default: 远程为400 本地10
		multiple: false, 　　　　　　　    //是否允许输入多个值. Default: false
		extraParams: {goodscategoryID: function() { return $('#goodscategoryID').val(); }, supplierID: function() { return $('#supplierID').val(); }},
		parse : function(data) {
			var json = data.personAjax;
			if($('#goodscategoryID').val()=='' && json==''){
				alert("请选择商品类别！");
				$('#goodscategoryID').focus();
			}else{
				for (i = 0; i < json.length; i++) {			
					json[i] = {
						data : [ json[i].split("(")[0] ],
						resulet : json[i],
						value : json[i]
					};
				}				
			}
			return json;
		}
	};
	// 项目
	$("#brandName").autocomplete(url, options);
	$("#brandName").result(
			function(event, data, formatted) {
				if (data) {					
					$(this).val($.trim(formatted.split("(")[0]));
					$("#allBrandID").val(
					formatted.replace(/(^.* )|[\\(\\)]/g, ""));
				}
			});
	/**Ajax----------读取项目列表-------------**/
	
});

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
    	var jxfs=$("#page_jxfss").val();
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
    	var czjj=$('#bgiframematerialtype').val();              //镜架材质
    	var gylxjj=$('#bgitechnologytypeid').val();            //工艺类型
    	var cgyearjj=$('#cgyear').val();                  //采购年份
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

		var companyID = '';
		if ('${person.personcompanytype}' == '2'){
			companyID = '${person.personcompanyid}';
		}
        
        var DataURL = "report.action?reportlet=StorageSearchSelRpt.cpt&logincompanyid="+'${person.personcompanyid}'+"&goodsID="+goodsID+"&goodsBarcode="+goodsBarcode+"&goodscategoryID="
                      +goodscategoryID+"&goodsName="+EncodeUtf8(goodsName)+"&supplierID="+supplierID+"&brandID="+brandID+"&allBrandID="+$('#allBrandID').val()+"&usingWarehouse="+usingWarehouse
                      +"&warehouseID="+warehouseID+"&warehouseStatus="+warehouseStatus+"&bgiretailbeginprice="+bgiretailbeginprice+"&bgiretailendprice="
                      +bgiretailendprice+"&departmenttype="+departmenttype+"&departmentID="+departmentID+"&bgispecjj="+bgispecjj+"&bgicolorjj="
                      +bgicolorjj+"&bgiframesizejj="+bgiframesizejj+"&bgieyeglassmaterialtypejp="+bgieyeglassmaterialtypejp+"&bgirefractivejp="+bgirefractivejp+"&bgiismutiluminosityjp="+bgiismutiluminosityjp
                      +"&minSphjp="+minSphjp+"&maxSphjp="+maxSphjp+"&minCyljp="+minCyljp+"&maxCyljp="+maxCyljp
                      +"&bgiusetypeyj="+bgiusetypeyj+"&bgistealthclassyj="+bgistealthclassyj+"&minSphyj="+minSphyj+"&maxSphyj="+maxSphyj
                      +"&minCylyj="+minCylyj+"&maxCylyj="+maxCylyj+"&isClosed="+isClosed+"&shareInfo="+shareInfo+"&whichretail="+whichretail+"&bgiothergoodsbigclass="+bgiothergoodsbigclass+"&bgiothergoodssmallclass="+bgiothergoodssmallclass
                      +"&minSphlh="+minSphlh+"&maxSphlh="+maxSphlh+"&pjlx="+pjlx+"&talerttype="+talerttype+"&isCustomize="+isCustomize+"&jxfs="+jxfs+"&companyID="+companyID+"&cgyearjj="+cgyearjj+"&czjj="+czjj+"&gylxjj="+gylxjj;
      
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
    	var jxfs=$("#page_jxfss").val();
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
    	var czjj=$('#bgiframematerialtype').val();              //镜架材质
    	var gylxjj=$('#bgitechnologytypeid').val();            //工艺类型
    	var cgyearjj=$('#cgyear').val();            //采购年份
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

		var companyID = '';
		if ('${person.personcompanytype}' == '2'){
			companyID = '${person.personcompanyid}';
		}
		
        var DataURL = "report.action?reportlet=StorageBrandSearchSelRpt.cpt&logincompanyid="+'${person.personcompanyid}'+"&goodsID="+goodsID+"&goodsBarcode="+goodsBarcode+"&goodscategoryID="
                      +goodscategoryID+"&goodsName="+EncodeUtf8(goodsName)+"&supplierID="+supplierID+"&brandID="+brandID+"&allBrandID="+$('#allBrandID').val()+"&usingWarehouse="+usingWarehouse
                      +"&warehouseID="+warehouseID+"&warehouseStatus="+warehouseStatus+"&bgiretailbeginprice="+bgiretailbeginprice+"&bgiretailendprice="
                      +bgiretailendprice+"&departmenttype="+departmenttype+"&departmentID="+departmentID+"&bgispecjj="+bgispecjj+"&bgicolorjj="
                      +bgicolorjj+"&bgiframesizejj="+bgiframesizejj+"&bgieyeglassmaterialtypejp="+bgieyeglassmaterialtypejp+"&bgirefractivejp="+bgirefractivejp+"&bgiismutiluminosityjp="+bgiismutiluminosityjp
                      +"&minSphjp="+minSphjp+"&maxSphjp="+maxSphjp+"&minCyljp="+minCyljp+"&maxCyljp="+maxCyljp
                      +"&bgiusetypeyj="+bgiusetypeyj+"&bgistealthclassyj="+bgistealthclassyj+"&minSphyj="+minSphyj+"&maxSphyj="+maxSphyj
                      +"&minCylyj="+minCylyj+"&maxCylyj="+maxCylyj+"&isClosed="+isClosed+"&shareInfo="+shareInfo+"&price_group="+price_group+"&bgiothergoodsbigclass="+bgiothergoodsbigclass+"&bgiothergoodssmallclass="+bgiothergoodssmallclass
                      +"&minSphlh="+minSphlh+"&maxSphlh="+maxSphlh+"&pjlx="+pjlx+"&isCustomize="+isCustomize+"&jxfs="+jxfs+"&companyID="+companyID+"&cgyearjj="+cgyearjj+"&czjj="+czjj+"&gylxjj="+gylxjj;

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

        if ('${wCount}' == '0') {
            alert('系统中未设置仓位，请先建立仓位之后再查询库存！');
            return
        }
		
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

		if($("input[name=radio_type]:checked").val() == "code" ){
			if($("#goodscategoryID").val() == ""){
				alert("您查询角度选择的是条码，请选择商品类别！");
				$("#goodscategoryID").focus();
				return;
			}			
		}
		
	    if (document.getElementById("usingWarehouse").value=='0'){
	    	getSelectValue('warehouseID','warehouseIDs');
	    }else if (document.getElementById("usingWarehouse").value=='1'){
	    	getSelectValue('warehouseID3','warehouseIDs');  		
	    }else if (document.getElementById("usingWarehouse").value=='2'){
	    	document.getElementById("warehouseIDs").value="";
	    }

	    getSelectValue('page_jxfs','page_jxfss');

	    if($("#brandID").val()=='' && $("#allBrandID").val()==''){
	    	$("#brandName").val("");
	    }

	    	    
    	if(checkForm(procurementReceiptForm)){  
    		$("img").removeAttr("onclick");
    		procurementReceiptForm.action = "selStockSearch.action";
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
		$("#allBrandID").val('');
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
			$("#cgyear").val('');
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

		changeWarehouse('0');

        resetSelectList('warehouseID');
        resetSelectList('warehouseID3');
        resetSelectList('page_jxfs');
        $("#talerttype").attr("disabled","");		

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
		$("#supplierID").val(json.id);
		$("#supplierName").val(json.value);
		$("#brandID").val("");
		$("#allBrandID").val("");
		$("#brandName").val("");
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

		$("#supplierID").val("");
		$("#supplierName").val("");
		$("#brandID").val("");
		$("#allBrandID").val("");
		$("#brandName").val("");
		cleanTwo();
		
		if(category == '' || category == '5' || category == '9'){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=yj]").hide();
			$("tr[id=hc]").hide();
			$("tr[id=lh]").hide();
			$("tr[id=pj]").hide();
		}
		
		if(category == '1' || category == '6'){
			$("tr[id=jj]").show();
			$("tr[id=jp]").hide();
			$("tr[id=yj]").hide();
			if(category == '6' || category == '8'){
				$("tr[nolh=nolh]").hide();
			}
			$("tr[id=hc]").hide();
			$("tr[id=lh]").hide();
			$("tr[id=pj]").hide();
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
			$("tr[id=hc]").hide();
			$("tr[id=lh]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yj]").show();
		}

		if(category == '7'){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=yj]").hide();
			$("tr[id=lh]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=hc]").show();
		}

		if(category == '8'){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=yj]").hide();
			$("tr[id=hc]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=lh]").show();
		}

		if(category == '2'){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=yj]").hide();
			$("tr[id=hc]").hide();
			$("tr[id=lh]").hide();
			$("tr[id=pj]").show();
		}
	}

	function cleanTwo(){
		//镜架、太阳镜
		$("#bgispecjj").val('');					//型号
		$("#bgicolorjj").val('');					//颜色
		$("#bgiframesizejj").val('');				//尺寸
		$("#bgitechnologytypeid").val('');			//工艺类型
		$("#bgiframematerialtype").val('');			//镜架材质
		$("#cgyear").val('');			            //镜架采购年份

		//配件
		$("#pjlx").val('');							//配件型

		//镜片
		$("#bgieyeglassmaterialtypejp").val('');	//配件型
		$("#bgirefractivejp").val('');				//配件型
		$("#bgiismutiluminosityjp").val('');		//配件型
		$("#minSphjp").val('');						//镜片球镜范围min
		$("#maxSphjp").val('');						//镜片球镜范围max
		$("#minCyljp").val('');						//镜片柱镜范围min
		$("#maxCyljp").val('');						//镜片柱镜范围max
		$("#isCustomizejp").val('');				//订做状态

		//隐形
		$("#bgiusetypeyj").val('');					//隐形使用类型
		$("#bgistealthclassyj").val('');			//抛弃型分类
		$("#minSphyj").val('');						//隐形球镜范围min
		$("#maxSphyj").val('');						//隐形球镜范围max
		$("#minCylyj").val('');						//隐形柱镜范围min
		$("#maxCylyj").val('');						//隐形柱镜范围max
		$("#isCustomizeyx").val('');				//订做状态

		//老花球
		$("#minSphlh").val('');						//老花球镜范围min
		$("#maxSphlh").val('');						//老花球镜范围max

		//耗材
		$("#bgiothergoodsbigclass").val('');		//其它商品大类
	}

	function showStockDetails(bgigoodsid,bgiwarehouseid,goodsBarcode){
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selectStockGoodsinfoPo.action?moduleID=${requestScope.moduleID}&bgigoodsid="+bgigoodsid+"&bgiwarehouseid=" + bgiwarehouseid+"&goodsBarcode="+goodsBarcode,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectStockGoodsinfoPo.action?moduleID=${requestScope.moduleID}&bgigoodsid="+bgigoodsid+"&bgiwarehouseid=" + bgiwarehouseid+"&goodsBarcode="+goodsBarcode,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品详细】";
	}
	function showStockDetails2(bgigoodsid,bgiwarehouseid,goodsBarcode){
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
		if($("input[name=radio_type]:checked").val() == "code" ){
			$("#barCodeTitle").css('display','block'); 
			$("#goodsBarcode").attr("maxlength","26");
			//$("#goodsBarcode").val('');
		}else{
			$("#barCodeTitle").css('display','none'); 
			$("#goodsBarcode").attr("maxlength","18");
			//$("#goodsBarcode").val('');
		}
	}

	function changeBrandName(){
		$("#brandID").val("");
		$("#allBrandID").val("");
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
<input type=hidden id="page_jxfss" name="page_jxfs" value="${page_jxfs}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>库存管理</TD>
            <td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：库存综合查询</td>
            <TD align="right" valign="bottom">&nbsp;
                <c:if test="${permissionPo.keyc == '1'}">       
	                                         点击【查询】按钮之后，出现查询结果后在打印
	            	<c:if test="${requestScope.radio_type eq 'goods' && empty(searchKey)}">
	            	    <img src="${ctx }/img/newbtn/btn_printstock_0.png" btn=btn title="打印库存" onClick="storagefxSel();">
	            	</c:if>
	            	<c:if test="${requestScope.radio_type eq 'brand' && empty(searchKey)}">
	            	    <img src="${ctx }/img/newbtn/btn_printstock_0.png" btn=btn title="打印库存" onClick="storagebrandfxSel();">	            	
	            	</c:if>
            	</c:if>
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
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
                      UNSELECTABLE="on">商品库存实时查询</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                         
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onClick="JavaScript:window.location.href='initStockSearch_2D.action?moduleID=${requestScope.moduleID}' ;"
                      UNSELECTABLE="on">库存综合查询(二维)</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>                   
        <c:if test="${departmenttype eq '3'}"> 
                 <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onClick="JavaScript:window.location.href='initSelectStockSearchWarehouse.action?moduleID=${requestScope.moduleID}' ;"
                      UNSELECTABLE="on">库存综合查询(仓位)</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
        </c:if>      
                   
                 <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onClick="JavaScript:window.location.href='initSelectStockSearchAnyTimeSel.action?moduleID=${requestScope.moduleID}' ;"
                      UNSELECTABLE="on">任意时段商品库存查询(任意时段)</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
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
						   <TD width="10%" height="26" class="table_body">查询角度</TD>
			               <TD class="table_none" width="17%">
			                <input type="radio" id="radio_code" value="code" name="radio_type" ${(requestScope.radio_type eq 'code' || empty(requestScope.radio_type)) ? 'checked' : ''} onclick="checkalerttype()">条码
			                <input type="radio" id="radio_goods" value="goods" name="radio_type" ${(requestScope.radio_type eq 'goods' || empty(requestScope.radio_type)) ? 'checked' : ''} onclick="checkalerttype()">商品
                            <input type="radio" id="radio_brand" value="brand" name="radio_type" ${requestScope.radio_type eq 'brand' ? 'checked' : '' } onclick="checkalerttype()">品种
			               </TD>
						   <TD width="10%" class="table_body" >品种零售价</TD>
			               <TD width="20%" class="table_none">
                            <input type="radio" id="price_group_no" value="no" name="price_group" ${price_group eq 'no' ? 'checked' : '' }>不分组
      	                    <input type="radio" id="price_group_yes" value="yes" name="price_group" ${price_group eq 'yes' || empty(price_group) ? 'checked' : '' }>分组
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
					  	<TR>
						   <TD height="26" class="table_body">商品代码</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="goodsID" name="goodsID" value="${requestScope.goodsID}" maxlength="22">
			               </TD>
						   <TD height="26" class="table_body">商品条码</TD>
			               <TD class="table_none">
                            <input class="text_input200" type="text" id="goodsBarcode" name="goodsBarcode" value="${requestScope.goodsBarcode}" maxlength="18">
			               </TD>
			               <TD height="26" class="table_body">商品名称</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="goodsName" name="goodsName" value="${requestScope.goodsName}" maxlength="32">
			               </TD>
                        </TR>
                      
                        <TR>
                           <TD height="26" class="table_body">商品类型</TD>
			               <TD class="table_none">
                            <select id="goodscategoryID" name="goodscategoryID"} onchange="showterm();">
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="goodsCategorys">
				               <option value="${bgcid}" ${goodscategoryID == bgcid ? 'selected="selected"' : '' }>${bgcgoodscategoryname}</option>
	     	                 </s:iterator>
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
			               </c:if>
			               <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none" ${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1' ? '':'colspan="3"'}>
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text" id="brandName" placeholder="可直接输入品种名称" name="brandName" value="${requestScope.brandName}" onclick="$(this).click();" onchange="changeBrandName();">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   		<input type="hidden" id="allBrandID" name="allBrandID" value="${requestScope.allBrandID}"/>
						   </li>
						   <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1'}">
						   		<li class="horizontal_onlyRight">
						   		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openBrand();"></li>
						   </c:if>
			               </TD>
                        </TR>
                        <tr id="jj">
                           <TD height="26" class="table_none">厂家型号</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="bgispecjj" name="bgispecjj" value="${requestScope.bgispecjj}" maxlength="50">
			               </TD>
						   <TD height="26" class="table_none" >厂家色号</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="bgicolorjj" name="bgicolorjj" value="${bgicolorjj}" maxlength="30">
			               </TD>
			               <TD height="26" class="table_none">尺寸</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="bgiframesizejj" name="bgiframesizejj" value="${requestScope.bgiframesizejj}" maxlength="10">
			               </TD>
                        </tr>
                        <tr id="jj" nolh=nolh>
                        	<TD height="26" class="table_none">工艺类型</TD>
			               <TD class="table_none">
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
			               <TD height="26" class="table_none">采购年份</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="cgyear" name="cgyear" value="${cgyear}" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.UINTOrNULL, 'Message' : '请重新输入采购年份！'}]">（年份后两位+两位月份）
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
			               <TD width="9%" height="26" class="table_none">厂家型号</TD>
			               <TD class="table_none" width="24%">
                            <input class="text_input160" type="text"  id="bgispeclh" name="bgispeclh" value="${requestScope.bgispeclh}" maxlength="50">
			               </TD>
						   <TD width="9%" height="26" class="table_none" >厂家色号</TD>
			               <TD width="24%" class="table_none">
                            <input class="text_input160" type="text"  id="bgicolorlh" name="bgicolorlh" value="${requestScope.bgicolorlh}" maxlength="30">
			               </TD>
                        </tr>
                           <TR>
					      <TD height="27" class="table_body">仓位名称</TD>
			               <TD class="table_none" colspan="3">
			               <li class="horizontal_onlyRight">
							<input type="hidden" id="usingWarehouse" name="usingWarehouse" value="${usingWarehouse}">
							<input type="radio" id="radioBtn_2" name="radioBtn" value="2" onclick="changeWarehouse('2');checkalerttype();" ${usingWarehouse == '2' ? 'checked' : '' }>不分仓
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
			               <TD height="26" class="table_body">库存预警状态</TD>
			               <TD class="table_none">
                           <select id="talerttype" name="talerttype">
                             <option value="">----请选择----</option>
                             <option value="4" ${talerttype == '4' ? 'selected="selected"' : '' }>小于等于红色预警</option>
			                 <option value="3" ${talerttype == '3' ? 'selected="selected"' : '' }>大于红色预警并小于等于库存量下限</option>
			                 <option value="2" ${talerttype == '2' ? 'selected="selected"' : '' }>大于库存量下限并小于等于库存量上限</option>
			                 <option value="1" ${talerttype == '1' ? 'selected="selected"' : '' }>大于库存量上限</option>
      	                   </select>
			               </TD>
			               <TD height="26" class="table_body">经销方式</TD>
			               <TD class="table_none">
			               <select id="page_jxfs" name="page_jxfs" multiple="multiple" size="20">
                                   <option value="" selected></option>
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='jxfs'}">
		                               <option value="${optionParamPoTmp.fopparamid }" ${(page_jxfs == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                              </c:if>	                                      	
	                               </c:forEach> 
                           </select>
			               </TD>			               
                        </TR>
                        <c:if test="${fquartzSwitchPo.fqswzhzstd==2}">  
                        <TR>  
                          <TD height="26" class="table_body">是否开票</TD>
                          <TD class="table_none" colspan="5">
                               <select id="makeinvoiceflag" name="makeinvoiceflag" value="${requestScope.makeinvoiceflag}">
                                    <option value="" ${requestScope.makeinvoiceflag!= ""  ? '' : 'selected="selected"' }>----请选择----</option>
							  		<option value="1"  ${requestScope.makeinvoiceflag!= "1"  ? '' : 'selected="selected"' } >开票</option>
							  		<option value="0" ${requestScope.makeinvoiceflag!= "0"  ? '' : 'selected="selected"' }>不开票</option>
	                          </select>
                          </TD>
                        </TR>  
                        </c:if>   
                      </TBODY>
                    </table>
                    <c:if test="${permissionPo.keya=='1'}">
                    <table id="title2" cellspacing="2">
						<tr height="20">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn id="submitButton" title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
							</td>
							<td>
							<label id="barCodeTitle" style="display: none;"><font color="red" size="3"><b>&nbsp;*&nbsp;当查询角度为条码时,商品类型必须输入。</b></font></label>
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
					 
                     <c:if test="${not empty(brandsList)}">
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
                          <TH width="8%" height="26" scope=col>品种代码</TH>
                          <TH width="15%" scope=col>品种名称</TH>
						  <TH width="10%" scope=col>数量</TH>                          
                          <TH width="7%" scope=col>商品类别</TH>
                          <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1'}">
                          <TH width="25%" scope=col>所属制造商</TH> 
                          </c:if>
                          <TH width="20%" scope=col>仓位</TH>
						  <TH width="15%" scope=col>
                          		<c:if test="${whichretail=='1'}">
                        			标准零售价格
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
						</TR>
						<TR class=table_title align=middle> 
						  	<TH height="26" colspan="2" scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col id="goodsquantityTotal">0</TH>
						    <TH ${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1' ? 'colspan="4"':'colspan="3"'}>&nbsp;</TH>					    	
				   		</TR>  
						<s:iterator value="brandsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">                         
                          <TD height="28"><U style="cursor: hand;" onclick="showBrandDetails('${bgibrandid }','${bgiwarehouseid }','${bgiretailprice }')">${bgibrandid}</U></TD>
                          <TD>${bgibrandname}</TD>
						  <TD>${bgigoodsquantity}<input type="hidden" name="goodsquantity" value="${bgigoodsquantity}"/></TD>                          
                          <TD>${bgigoodscategoryname}</TD>
                          <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1'}">
                          <TD>${bgisuppliername}</TD>   
                          </c:if>
                          <TD>${bgiwarehousename}</TD>
                          <TD>${bgiretailprice}</TD>  
						</TR>
						</s:iterator>
						<TR class=table_title align=middle> 
						  	<TH height="26" colspan="2" scope=col align="right">库存合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH>${requestScope.titlenum}</TH>
						  	<TH ${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1' ? 'colspan="4"':'colspan="3"'}>&nbsp;</TH>					    	
				   		</TR>  
                      </TBODY>
                    </table>
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
	               </c:if>    
                                  
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
                          <TH width="15%" height="26" scope=col>商品代码</TH>
                          <TH width="30%" scope=col>商品名称</TH>
                          <TH width="7%" scope=col>数量</TH>                          
                          <TH width="6%" scope=col>商品类别</TH>
                          <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1'}">
                          <TH width="18%" scope=col>制造商</TH>
                          </c:if>
                          <TH width="8%" scope=col>
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
                          <TH width="15%" scope=col>仓位</TH>
						</TR> 
						<TR class=table_title align=middle> 
						  	<TH height="26" colspan="2"  scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col id="goodsquantityTotal">0</TH>
						    <TH ${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1' ? 'colspan="4"':'colspan="3"'}>&nbsp;</TH>					    	
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
                        <c:if test="${goodscategoryID ne '4' && goodscategoryID ne '5' }">                        
                          <TD height="26"><U style="cursor: hand;" onclick="showStockDetails('${bgigoodsid }','${bgiwarehouseid }','')">${bgigoodsid}</U></TD>
                        </c:if>
                        <c:if test="${goodscategoryID eq '4' || goodscategoryID eq '5' }">                        
                          <TD height="26"><U style="cursor: hand;" onclick="showStockDetails('${bgigoodsid }','${bgiwarehouseid }','${empty(goodsBarcode) ? '': goodsBarcode}')">${bgigoodsid}</U></TD>
                        </c:if>
                          <TD>${bgiviewgoodsname}</TD>
                          <TD>${bgigoodsquantity}<input type="hidden" name="goodsquantity" value="${bgigoodsquantity}"/></TD>                          
                          <TD>${bgigoodscategoryname}</TD>
                          <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1'}">
                          <TD>${bgisuppliername}</TD>
                          </c:if>
                          <TD>${bgiretailprice}</TD>
                          <TD>${bgiwarehousename}</TD> 
						</TR>
						</s:iterator>
						<TR class=table_title align=middle> 
						  	<TH height="26" colspan="2" scope=col align="right">库存合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH>${requestScope.titlenum}</TH>
						  	<TH ${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1' ? 'colspan="4"':'colspan="3"'}>&nbsp;</TH>					    	
				   		</TR>  
                      </TBODY>
                    </table>
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
	               </c:if>
	               
	               <c:if test="${not empty(codesList)}"> 
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
                          <TH width="15%" height="26" scope=col>商品代码</TH>
                          <TH width="15%" height="26" scope=col>商品条码</TH>
                          <TH width="25%" scope=col>商品名称</TH>
                          <TH width="7%" scope=col>数量</TH>                          
                          <TH width="7%" scope=col>商品类别</TH>
                          <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1'}">
                          <TH width="15%" scope=col>制造商</TH>
                          </c:if>
                          <TH width="8%" scope=col>
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
                          <TH width="15%" scope=col>仓位</TH>
						</TR>
						<TR class=table_title align=middle> 
						  	<TH height="26" colspan="3"  scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col id="goodsquantityTotal">0</TH>
						    <TH ${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1' ? 'colspan="4"':'colspan="3"'}>&nbsp;</TH>					    	
				   		</TR> 				   		  
						<s:iterator value="codesList">
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
	                          	<U style="cursor: hand;" onclick="showStockDetails2('${bgigoodsid }','${bgiwarehouseid }','${bgigoodsbarcode}')">${bgigoodsbarcode}</U>
	                          </TD>
	                          <TD>${bgiviewgoodsname}</TD>
                          	  <TD>${bgigoodsquantity}<input type="hidden" name="goodsquantity" value="${bgigoodsquantity}"/></TD>	                          
	                          <TD>${bgigoodscategoryname}</TD>
	                          <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1'}">
	                          <TD>${bgisuppliername}</TD>
	                          </c:if>
                          <TD>${bgiretailprice}</TD>
                          <TD>${bgiwarehousename}</TD> 
						</TR>
						</s:iterator>
						<TR class=table_title align=middle> 
						  	<TH height="26" colspan="3" scope=col align="right">库存合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH>${requestScope.titlenum}</TH>
						  	<TH ${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1' ? 'colspan="4"':'colspan="3"'}>&nbsp;</TH>					    	
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
<div id="help" class="reportHelp" style="color: red;">
<br/>&nbsp;&nbsp;*&nbsp;1、在选择了商品类别后，点击商品品种出现该类别下所有品种，也可直接输入品种助记码、品种名称模糊检索!
<br/>&nbsp;&nbsp;*&nbsp;2、当使用库存打印功能时，建议指定商品类别，否则严重影响查询性能!
<br/>&nbsp;&nbsp;*&nbsp;3、库存预警状态&nbsp;&nbsp;&nbsp;1、当前库存量大于预警上限时蓝色显示。（库存充裕）	<br/>												
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2、当前库存小于库存预警上限并大于库存预警下限时黑色显示。（库存正常）<br/>		
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3、当前库存小于库存预警下限并大于库存红色预警时紫色显示。（库存不足）<br/>		
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4、当前库存小于红色预警时红色显示。（库存严重不足，接近断货）<br/>
</div>
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
	initSelectList('page_jxfs','page_jxfss'); 
</script>
<%@ include file="/WEB-INF/inc/message.jsp" %>