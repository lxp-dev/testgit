<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/js/orderItem.js" ></script>
<script type="text/javascript" src="${ctx}/js/priceCount.js" ></script>
<title>无配镜单退款管理</title>
</head>

<script>
	function save(){
		var salerid=document.getElementById("ssesbsalerid").value;
		var stealthEffective='${systemParameterPo.fspstealtheffective}';
		var smecimemberid=document.getElementById("smecimemberid").value;
		var guaranteeperiod = document.getElementsByName("goodsInfoTempPo.guaranteeperiod");
		var batch = document.getElementsByName("goodsInfoTempPo.batch");
		var eyeleftorright = document.getElementsByName('eyeLeftOrRight');
		if($('#smecicustomerid').val()==''){
			alert("请先选择会员！");
			$("#smecimemberid").focus();
			$("#smecimemberid").select();
			$('#cstpgoodscategoryKJ').attr("checked","checked");
			return;
		}
		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");		
		var goodsid=document.getElementsByName("goodsInfoTempPo.goodsid");
		var categoryID_open = document.getElementsByName('cstpgoodscategory');
		var goodscategory=0;
		var defaultSalesType=$('#salesType').val();
		
		for(var i=0;i<categoryID_open.length;i++){
			if($(categoryID_open[i]).attr("checked")==true){
				goodscategory=categoryID_open[i].value;
			}
		}
		var recipetype=document.getElementById("recipetype").value;
		if(goodscategory==2){
			if(recipetype==4){
				alert("处方类型选择有误！");
				$("#recipetype").focus();
				$("#recipetype").select();
				
				return;
			}
			if(recipetype==0){
				alert("请选择处方！");
				$("#recipetype").focus();
				$("#recipetype").select();
				
				return;
			}
		}
		//算出整单合计（附加费+商品合计）begin
		var FJamountsum=0;
		var FJsizesum=0;
		$("input[name=amountMoney]").each(function (){
        	if($(this).val() != ""){
        		FJamountsum = accAdd(FJamountsum,$(this).val()).toFixed(2);
        		FJsizesum = FJsizesum + 1;
        	}
        });
        var rpriceamountTotal=document.getElementById("rpriceamountTotal").innerHTML;
		var rpriceOrFjSum=accAdd(FJamountsum,rpriceamountTotal).toFixed(2);
		
		if($("#addTable tr").length > 2 || FJsizesum > 0){
		}else{
			alert("请选择商品或附加费！");
			return;
		}
		
		//算出整单合计（附加费+商品合计）end
		//初始化镜架，镜片值(得到镜架、镜片总数)begin--判断选择的商品必须是1个镜架对应2个镜片
		var goodsquantityJP=0;//镜片合计
		var goodsquantityJJ=0;//镜架合计
		var eyeleftsum=0;//左眼片数合计
		var eyerightsum=0;//右眼片数合计
		for(var i=0;i<goodsid.length;i++){
			if(goodsid[i].value.substring(0,1)==1||goodsid[i].value.substring(0,1)==6||goodsid[i].value.substring(0,1)==8){
				goodsquantityJJ =(parseFloat(goodsquantityJJ).add(parseFloat(goodsquantity[i].value))).toFixed(0);
				//alert('a'+goodsquantityJJ);
			}
			if(goodsid[i].value.substring(0,1)==3){
				goodsquantityJP = (parseFloat(goodsquantityJP).add(parseFloat(goodsquantity[i].value))).toFixed(0);
				//alert('c'+goodsquantityJP);
			}
			if(goodsid[i].value.substring(0,1)==3&&eyeleftorright[i].value=='L'){
				eyeleftsum=(parseFloat(eyeleftsum).add(parseFloat(goodsquantity[i].value))).toFixed(0);
				//alert('L'+eyeleftsum);
			}
			if(goodsid[i].value.substring(0,1)==3&&eyeleftorright[i].value=='R'){
				eyerightsum=(parseFloat(eyerightsum).add(parseFloat(goodsquantity[i].value))).toFixed(0);
				//alert('R'+eyerightsum);
			}
			
		}
		var goodsquantityJJSum=parseFloat(accMul(parseFloat(goodsquantityJJ),parseFloat(2))).toFixed(0);
		var goodsquantityJJAgv=parseFloat(accDiv(parseFloat(goodsquantityJJ),parseFloat(2))).toFixed(0);
		//初始化镜架，镜片值(得到镜架、镜片总数)end
		for(var i=0;i<goodsid.length;i++){
			if(goodsid[i].value.substring(0,1)==4||goodsid[i].value.substring(0,1)==5){
				if(stealthEffective==2||stealthEffective==1){
					if(guaranteeperiod[i].value==""){
						alert("请填写商品效期！");
						guaranteeperiod[i].focus();
						return;	
					}
					if(batch[i].value==""){
						alert("请填写商品批号！");
						batch[i].focus();
						return;	
					}
				}
			}
			if(goodscategory==1){
				if(goodsid[i].value.substring(0,1)!=4&&goodsid[i].value.substring(0,1)!=5){
						alert("商品："+goodsid[i].value+"不属于隐形销售类型");
						return;
					}
			}
			if(goodscategory==2){
				if(goodsid[i].value.substring(0,1)==4){
					alert("商品："+goodsid[i].value+"不属于框架销售类型");
					return;
			}
				//alert(goodsquantityJP);
				//alert(goodsquantityJJ);
			if(goodsid[i].value.substring(0,1)==1||goodsid[i].value.substring(0,1)==3||goodsid[i].value.substring(0,1)==6||goodsid[i].value.substring(0,1)==8){
					if(goodsquantityJJSum!=goodsquantityJP){
						alert('每个镜架需对应两个镜片！');
						return;
					}
				}
			}
			if(goodscategory==3){
				if(goodsid[i].value.substring(0,1)==3||goodsid[i].value.substring(0,1)==4){
						alert("商品："+goodsid[i].value+"不属于隐形类型");
						return;
					}
				}
		}

		var isornull=false;
		for(var i=0;i<goodsid.length;i++){
			if(goodsid[i].value.substring(0,1)==3&&goodsid[i].value.substring(0,1)==4){
				if(eyeleftorright[i].value==''){
					alert("请先选择左/右眼！");
					eyeleftorright[i].focus();
					eyeleftorright[i].select();
					return;
				}
			}
			
		}
		if(goodscategory==2){
			//判断左右眼镜片begin
			var isOrNull=false;
			for(var i=0;i<goodsid.length;i++){
				if(goodsid[i].value.substring(0,1)==1||goodsid[i].value.substring(0,1)==3||goodsid[i].value.substring(0,1)==6||goodsid[i].value.substring(0,1)==8){
					isOrNull=true;
					break;
				}
			}
			if(isOrNull){
				if(0==eyeleftsum||eyeleftsum==''){
					alert("左/右眼选择有误！");
					return
				}
				if(0==eyerightsum||eyerightsum==''){
					alert("左/右眼选择有误！");
					return
				}
				if(goodsquantityJJAgv!=eyeleftsum||goodsquantityJJAgv!=eyerightsum){
					alert("左/右眼选择有误！");
					return
				}
			}
			//判断左右眼镜片end
		}

		//判断商品数量是否为空	
		var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
		var goodsquantityCount=0;
		for(i=0;i<goodsquantityArray.length;i++){
			if(goodsquantityArray[i].value=="0"){
				alert("商品数量不能为0！");
				goodsquantityArray[i].focus();
				
				return;	
			}
			goodsquantityCount++;
		}
		
		var categoryID_open = document.getElementsByName('cstpgoodscategory');
		var goodscategory=0;
		for(var i=0;i<categoryID_open.length;i++){
			if($(categoryID_open[i]).attr("checked")==true){
				goodscategory=categoryID_open[i].value;
			}
		}

		var sum = 0;
    	$('input[leixing=leixing]').each(function (){
    		sum = Number(accAdd($(this).val(),sum)).toFixed(2);	
    	});
    	
    	if(Number($('#salseValue').val()) != sum){
    		alert("缴费金额与应收金额不等!");
    		return;
    	}

		var yhktcheck = '';
		<c:if test="${fn:contains(systemParameterPo.fspcollecttype,'3')}">
		if(document.getElementById('yhktr').style.display != 'none'){
			$('select[name=yhkt]').each(function (){
				if($(this).val() == ''){
					alert("请选择银行卡！");
					$(this).focus();
					yhktcheck = '1';
					return false;
				}
	        });
			if(yhktcheck == '1'){
				return;
	        }

	    	$('input[name=yhkv]').each(function (){
				if($(this).val() == ''){
					alert("请填写金额！");
					$(this).focus();
					yhktcheck = '1';
					return false;
				}
	        });

	        if(yhktcheck == '1'){
				return;
	        }
		}
		</c:if>
		<c:if test="${fn:contains(systemParameterPo.fspcollecttype,'4')}">	
		if(document.getElementById('czktr').style.display != 'none'){
	        $('input[name=czkv]').each(function (){
				if($(this).val() == ''){
					alert("请填写金额！");
					$(this).focus();
					yhktcheck = '1';
					return false;
				}
	        });
	
	        if(yhktcheck == '1'){
				return;
	        }
		}
		</c:if>

		<c:if test="${fn:contains(systemParameterPo.fspcollecttype,'2') && not empty(systemParameterPo.fspexchangeintegral) && systemParameterPo.fspexchangeintegral != '' }"> 
            if(document.getElementById('dhjf').style.display != 'none'){
                if ($.trim($('input[id=dhjf2]').val()) == ''){
                    alert("请填写消费积分!");
                    $('input[id=dhjf2]').val($.trim($('input[id=dhjf2]').val()));
                    $('input[id=dhjf2]').focus();
                    return;
                }
                $('input[id=dhjf2]').val($.trim($('input[id=dhjf2]').val()));
			}		
		</c:if>
		var qttcheck = '';
		<c:if test="${fn:contains(systemParameterPo.fspcollecttype,'6')}">
		if(document.getElementById('qttr').style.display != 'none'){
			$('select[name=qtt]').each(function (){
				if($(this).val() == ''){
					alert("请选择其他！");
					$(this).focus();
					qttcheck = '1';
					return false;
				}
	        });
			if(qttcheck == '1'){
				return;
	        }

	    	$('input[name=qtv]').each(function (){
				if($(this).val() == ''){
					alert("请填写金额！");
					$(this).focus();
					qttcheck = '1';
					return false;
				}
	        });

	        if(qttcheck == '1'){
				return;
	        }
		}
		</c:if>

   		//收银方式验证
   		var yhkv = 0;	//银行卡
		var czkv = 0;	//储值卡
		var salseValue = parseFloat($('#salseValue').val());//应收金额

		$('input[name=yhkv]').each(function (){
			yhkv = accAdd(yhkv,$(this).val());
		});

		$('input[name=czkv]').each(function (){
			czkv = accAdd(czkv,$(this).val());
		});
   
		if(!confirm('请确认提交！')){
			return;
		}
		
		if(checkForm(document.all.salesReturnForm)){ 
			$("img").removeAttr("onclick");
			gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
			salesReturnForm.action = "insertSalesReturnGoods.action?ssesbsalerid="+salerid+"&rpriceOrFjSum="+rpriceOrFjSum;
			salesReturnForm.submit();
		}
			
	}
	var goodscategoryKJ=false;
	
	function openGoodSingle(){
		if($('#smecicustomerid').val()==''){
			alert("请先选择会员！");
			$("#smecimemberid").focus();
			$("#smecimemberid").select();
			return;
		}
		var categoryID_open = document.getElementsByName('cstpgoodscategory');
		var goodscategory=0;
		for(var i=0;i<categoryID_open.length;i++){
			if($(categoryID_open[i]).attr("checked")==true){
				goodscategory=categoryID_open[i].value;
			}
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsSingleSelWP.action?select_retail=1&storebatch="+goodscategory,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSelWP.action?select_retail=1&storebatch="+goodscategory,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}
	
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(i = 0; i < goodInfos.length; i++){
					addRow(goodInfos[i]);		
		}
		amount();
		pricesum();
		price();
		shouorhidebutton();
		salesvalueamount();
	}	
	function shouorhidebutton(){
		var table = document.getElementById('addTable');
		var index = table.rows.length;
		if(index>2){
		  $("#ctl01_PageBody_PostButton").show();
		}else{
			$("#ctl01_PageBody_PostButton").hide();
		}
	}
    
   function deleteitem(){
		var chk=document.getElementsByName("chk");
		var table = document.getElementById('addTable');
		var count=0;
		for(i = 0; i < chk.length; i++){
			if (chk[i].checked ) {
				var curRow = chk[i].parentNode.parentNode;		
				table.deleteRow(curRow.rowIndex);
				i = -1;
				count++; 
			}
			  
		}
		if(count==0){
          alert('请选择商品!');
          return false;
        }
		document.all.chks.checked = false;
		amount();
		pricesum();
		shouorhidebutton();
    }
    
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	

	/**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        for(var i=0;i<chk.length;i++){
           chk[i].checked = chks.checked;
        }
    }
    
    /**
	*	设定价格调试各Input元素的变化属性；
	*	goodsquantityStateArray 	：商品数量数组；
	*	nottaxrateStateArray		：单位成本数组；
	*	nottaxrateamountStateArray 	：成本合计数组；
	*	taxrateStateArray 			：税率数组；
	*	costpriceStateArray 		：含税单价数组；
	*	costpriceamountStateArray 	：价税合计数组；		
	*	taxamountStateArray 		：税额合计数组；			
	*	例子：goodsquantityStateArray =new Array(arg0,arg1,arg2,arg3);
	*	arg0：当自动计算时，是否只读；true表示只读；false表示非只读；
	*	arg1：当自动计算时，是否对onchange方法进行方法转换；"add"表示添加方法；"remove"表示移除方法；""空表示不进行操作；
	*	arg2：当手动计算时，是否只读；true表示只读；false表示非只读；
	*	arg3：当手动计算时，是否对onchange方法进行方法转换；"add"表示添加方法；"remove"表示移除方法；""空表示不进行操作；
	**/
	function getInputState(){	
		var goodsquantityStateArray =new Array(false,"autoCountOnlyOne",false,"totalCount");
		var nottaxrateStateArray =new Array(true,"",false,"totalCount");
		var nottaxrateamountStateArray =new Array(true,"",false,"totalCount");
		var taxrateStateArray =new Array(false,"autoCountOnlyOne",false,"totalCount");
		var costpriceStateArray =new Array(false,"autoCountOnlyOne",false,"totalCount");
		var costpriceamountStateArray =new Array(true,"",false,"totalCount");
		var taxamountStateArray =new Array(true,"",false,"totalCount");
		var stateArray=new Array(goodsquantityStateArray,nottaxrateStateArray,nottaxrateamountStateArray,taxrateStateArray,costpriceStateArray,costpriceamountStateArray,taxamountStateArray);
		return stateArray;
	}
	function barcode(goodsid,goodsbarcode){
		if(goodsbarcode.value==''){
			return;
		}
		var tmp = goodsid.replace(/\./g,  "").toUpperCase();
		var tmp1 = goodsbarcode.value.substring(0,18);
		tmp1 = tmp1.toUpperCase();
		//alert(tmp1);
		if(tmp != tmp1){
			alert("商品不符！");
			goodsbarcode.value="";
			return;
		}
		if(goodsbarcode.value.length<26)
		{
			alert("商品位数不符！");
			goodsbarcode.value="";
			return;
		}
		if(goodsbarcode.value.length>26)
		{
			alert("商品位数不符！");
			goodsbarcode.value="";
			return;
		}
	}

	var index = 0;
	function addRow(goodInfo,stateArray){		
		var table = document.getElementById('addTable');
		index = accAdd(index,table.rows.length - 1);
		// 商品id去重
		var chk=document.getElementsByName("chk");
		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");		

		var addtype="";
		for (var i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.chkgoodis) {
				addtype="1";
				return;
			}
		}		
		
		// 添加商品到列表 begin
    	var readonlyFlg=document.getElementById("autoCount");

		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);	
		var c8 = row.insertCell(7);
		var c9 = row.insertCell(8);	
		var c10 = row.insertCell(9);
		var c11 = row.insertCell(10);
		 c8.id="xiaoqi"; 		    
		 c9.id="pici";
		row.className = 'row';
		row.height="26";
		// 添加商品到列表 end	
	   		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.bgigoodsid +goodInfo.rl + '" >';
	        c2.innerHTML = goodInfo.bgigoodsid+ '<input type="hidden" index="'+index+'" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />';
	        c3.innerHTML = goodInfo.bgigoodsname+'<input type="hidden"  name="goodsInfoTempPo.goodsname" value="' + goodInfo.bgigoodsname +'" />';
			c4.innerHTML = goodInfo.bgispec;
			c5.innerHTML = '<input type="text" onblur="amount();price();" class="text_input60 number" value="1" style="width:100%"  name="goodsInfoTempPo.goodsquantity"  onKeyUp="value=value.replace(\/[\^\\d\\.]\/g,\'\')"  validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
			c6.innerHTML = '<input type="text"  style="background-color:#ACA899" readOnly="readonly"   style="width:100%" name="goodsInfoTempPo.retailprice" value="' + goodInfo.bgiretailprice +'" />'

			if(goodInfo.bgigoodsid.substring(2,4).toUpperCase() != 'ZZ'){
				if('${permissionPo.keyb}' == '1'){
					c7.innerHTML = '<input type="text"  onblur="price();pricesum();"  onKeyUp="value=value.replace(\/[\^\\d\\.]\/g,\'\')" style="width:100%" name="goodsInfoTempPo.retailpriceamount" value="'+goodInfo.bgiretailprice+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写销售金额！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的销售金额！\'}]" />';
				}
				if('${permissionPo.keyb}' != '1'){
					c7.innerHTML = '<input type="text"  onblur="price();pricesum();" style="background-color:#ACA899" readOnly="readonly"  onKeyUp="value=value.replace(\/[\^\\d\\.]\/g,\'\')" style="width:100%" name="goodsInfoTempPo.retailpriceamount" value="'+goodInfo.bgiretailprice+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写销售金额！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的销售金额！\'}]" />';
				}
			}else {
				c7.innerHTML = '<input type="text"  onblur="price();pricesum();" style="background-color:#ACA899" readOnly="readonly"  onKeyUp="value=value.replace(\/[\^\\d\\.]\/g,\'\')" style="width:100%" name="goodsInfoTempPo.retailpriceamount" value="'+goodInfo.bgiretailprice+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写销售金额！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的销售金额！\'}]" />';
			}
			
			c8.innerHTML = '<input type="text"   style="width:80px;" id="xq"  class="text_input60" name="goodsInfoTempPo.guaranteeperiod" onblur="changebarcode('+index+',$(this));loadSimpleBatch($(this).parent().parent().find(\'#pcbarcode\').val(),$(this).parent().parent().find(\'#batch\').val(),this);" value=""  />';
			c9.innerHTML = '<input type="text"  style="width:80px;" id="pc" maxlength="20" class="text_input60"  name="goodsInfoTempPo.batch" onblur="loadSimpleBatch($(this).parent().parent().find(\'#pcbarcode\').val(),$(this).val(),this);"  value="" />';

            var tmpbatch = '00';
            <c:if test="${((systemParameterPo.fspbarcodetype == 1) || (systemParameterPo.fspbarcodetype == 2)) && (systemParameterPo.fspstealtheffective == 1) || (systemParameterPo.fspstealtheffective == 2)}">
                tmpbatch = 'A0';
            </c:if>

			if(goodInfo.bgigoodsid.substring(2,4).toUpperCase() != 'ZZ'){
				c10.innerHTML ='<input type="text"  value="'+(goodInfo.bgigoodsbarcode.substring(0,1)!=4&&goodInfo.bgigoodsbarcode.substring(0,1)!=5?goodInfo.bgigoodsbarcode.substring(0,24)+'00':goodInfo.bgigoodsbarcode.substring(0,24)+tmpbatch)+'" style="width: 200px;" id="pcbarcode" onBlur="barcode(\''+goodInfo.bgigoodsid+'\',this);"   class="text_input100" maxlength="26" name="goodsInfoTempPo.pcbarcode"  />';				
			}else {
				c10.innerHTML ='<input type="text" style="background-color:#ACA899" readOnly="readonly" value="'+(goodInfo.bgigoodsbarcode.substring(0,24)+'00')+'" style="width: 200px;" id="pcbarcode" class="text_input100" maxlength="26" name="goodsInfoTempPo.pcbarcode"  />';		
			}

			c10.innerHTML =	c10.innerHTML + '<input type="hidden"  style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'"  />'
							+'<input type="hidden"  style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'"  />'
							+'<select id="selectGbc"  name="goodsInfoTempPo.goodsbarcode"  multiple="multiple" class="text_input200 gbc" style="height:30px" ></select>'
							+'<input index="index'+index+'" onkeyup="this.value=this.value.toUpperCase()"   onblur="this.value=this.value.toUpperCase()" maxlength="26" type="hidden" class="text_input200" name="barCodeInput" onfocus="this.select();" onkeydown="onBlurBarCode($(this),\''+goodInfo.bgigoodsid+'\');"/>';
			var c11String='';
			var lorR=goodInfo.rl;
			var left="L";
			var right="R";
			var jjFrame="F";
			c11String=c11String+'<select  id="eyeLeftOrRight" name="eyeLeftOrRight" disabled="disabled" >';
			c11String=c11String+'<option value="">----请选择----</option>';
			c11String=c11String+'<option value="L" '+(left==lorR?'selected="selected"':"") +'>左眼</option>';
			c11String=c11String+'<option value="R" '+(right==lorR?'selected="selected"':"") +'>右眼</option>';
			c11String=c11String+'<option value="F" '+(jjFrame==lorR?'selected="selected"':"") +'>镜架</option>';
			c11String=c11String+'</select>&nbsp;<input type="hidden" name="eyeLeftOrRights" value="'+goodInfo.rl+'">';
			c11.innerHTML =c11String;
							
			shouorhidebutton();
			var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
	    	var nottaxrateArray = document.getElementsByName("goodsInfoTempPo.nottaxrate");
	    	var nottaxrateamountArray = document.getElementsByName("goodsInfoTempPo.nottaxrateamount");
	    	var taxrateArray = document.getElementsByName("goodsInfoTempPo.taxrate");
	    	var costpriceArray = document.getElementsByName("goodsInfoTempPo.costprice");
	    	var costpriceamountArray = document.getElementsByName("goodsInfoTempPo.costpriceamount");
	    	var taxamountArray = document.getElementsByName("goodsInfoTempPo.taxamount");
	    		
	    	isshow();
    	// 初始化添加的每行商品信息的Input标签readonly属性以及onchange方法 end
    }

	function addRowUpdateNumber(goodInfo,stateArray){		
		var table = document.getElementById('addTable');
		index = accAdd(index,table.rows.length - 1);
		// 商品id去重
		var chk=document.getElementsByName("chk");
		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");		

		var addtype="";
		for (var i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsid) {
				addtype="1";
				return;
			}
		}
		
		
		// 添加商品到列表 begin
    	var readonlyFlg=document.getElementById("autoCount");

		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);	
		var c8 = row.insertCell(7);	
		var c9 = row.insertCell(8);	
		var c10 = row.insertCell(9);
		var c11 = row.insertCell(10);
		row.className = 'row';
		row.height="26";
		 c8.id="xq"; 		    
		 c9.id="pc";
		// 添加商品到列表 end	
   		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.bgigoodsid + goodInfo.rl + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" index="'+index+'" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />';
        c3.innerHTML = goodInfo.bgigoodsname+'<input type="hidden"  name="goodsInfoTempPo.goodsname" value="' + goodInfo.bgigoodsname +'" />';
		c4.innerHTML = goodInfo.bgispec;
	
		var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
    	var nottaxrateArray = document.getElementsByName("goodsInfoTempPo.nottaxrate");
    	var nottaxrateamountArray = document.getElementsByName("goodsInfoTempPo.nottaxrateamount");
    	var taxrateArray = document.getElementsByName("goodsInfoTempPo.taxrate");
    	var costpriceArray = document.getElementsByName("goodsInfoTempPo.costprice");
    	var costpriceamountArray = document.getElementsByName("goodsInfoTempPo.costpriceamount");
    	var taxamountArray = document.getElementsByName("goodsInfoTempPo.taxamount");
    	
    	c5.innerHTML = '<input type="text" onblur="amount();price();" class="text_input60 number" value="0" style="width:100%" name="goodsInfoTempPo.goodsquantity"  onKeyUp="value=value.replace(\/[\^\\d\\.]\/g,\'\')"  validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
		c6.innerHTML = '<input type="text" style="background-color:#ACA899" readOnly="readonly"   style="width:100%" name="goodsInfoTempPo.retailprice" value="' + goodInfo.bgiretailprice +'"  />'
		c7.innerHTML = '<input type="text" onblur="price();pricesum();"  onKeyUp="value=value.replace(\/[\^\\d\\.]\/g,\'\')"  style="width:100%" name="goodsInfoTempPo.retailpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写销售金额！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的销售金额！\'}]"/>';
		c8.innerHTML = '<input   style="width:80px;" id="xq" readOnly="readonly"  class="text_input60" name="goodsInfoTempPo.guaranteeperiod" onblur="changebarcode('+index+',$(this));loadSimpleBatch($(this).parent().parent().find(\'#pcbarcode\').val(),$(this).parent().parent().find(\'#batch\').val(),this);"  />';
		c9.innerHTML = '<input type="text"  style="width:80px;" id="pc" maxlength="8" class="text_input60"   name="goodsInfoTempPo.batch" onblur="loadSimpleBatch($(this).parent().parent().find(\'#pcbarcode\').val(),$(this).val(),this);"  value="' +(goodInfo.bgigoodsbarcode.substring(goodInfo.bgigoodsbarcode.length-8,goodInfo.bgigoodsbarcode.length)!='00000000'?goodInfo.bgigoodsbarcode.substring(goodInfo.bgigoodsbarcode.length-8,goodInfo.bgigoodsbarcode.length):'')+'" />';
		c10.innerHTML ='<input type="text"  value="'+goodInfo.bgigoodsbarcode+'" style="width: 200px;" onBlur="barcode(\''+goodInfo.bgigoodsid+'\',this);" readOnly="readonly"   class="text_input100" maxlength="26" name="goodsInfoTempPo.pcbarcode"  />'
						+'<input type="hidden"  style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'"  />'
						+'<input type="hidden"  style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'"  />'
						+'<select style="disaply:none"  id="selectGbc" name="goodsInfoTempPo.goodsbarcode"  multiple="multiple" class="text_input200 gbc" style="height:30px" ></select>'
						+'<input index="index'+index+'" onkeyup="this.value=this.value.toUpperCase()"   onblur="this.value=this.value.toUpperCase()" maxlength="26" type="hidden" class="text_input200" name="barCodeInput" onfocus="this.select();" onkeydown="onBlurBarCode($(this),\''+goodInfo.bgigoodsid+'\');"/>';
		var c11String='';
		c11String=c11String+'<select  id="eyeLeftOrRight" name="eyeLeftOrRight" >';
		c11String=c11String+'<option value="">----请选择----</option>';
		c11String=c11String+'<option value="L">左眼</option>';
		c11String=c11String+'<option value="R">右眼</option>';
		c11String=c11String+'<option value="F">镜架</option>';
		c11.innerHTML =c11String;
		shouorhidebutton();
		isshow();
    }
	function isshow(){
		var goodsid = document.getElementsByName('goodsInfoTempPo.goodsid');
		var guaranteeperiod = document.getElementsByName('goodsInfoTempPo.guaranteeperiod');
		var batch = document.getElementsByName('goodsInfoTempPo.batch');
		var eyeleftorright = document.getElementsByName('eyeLeftOrRight');
		for(var i=0;i<goodsid.length;i++){
			if(goodsid[i].value.substring(0,1)!=3&&goodsid[i].value.substring(0,1)!=4){
				eyeleftorright[i].style.display="none";
				
			}
			if(goodsid[i].value.substring(0,1)!=4&&goodsid[i].value.substring(0,1)!=5){
				guaranteeperiod[i].setAttribute("id",i+1);
				csan(guaranteeperiod[i],'none');
				batch[i].setAttribute("id",i+1);
				csan(batch[i],'none');
				
			}
		}
		var stealthEffective='${systemParameterPo.fspstealtheffective}';
			if(stealthEffective==2||stealthEffective==1){
				$('[id=xiaoqi]').show();
				$('[id=pici]').show();
			}else{
				$('[id=xiaoqi]').hide();
				$('[id=pici]').hide();
			}
			$('[id=selectGbc]').hide();
	}
    
    //子页面删除单行
	function openGoodSingleDeleteValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		for(var i = 0; i < goodInfos.length; i++){
			deleterow(goodInfos[i]);
		}
		amount();
		pricesum();
		shouorhidebutton();
	}
	
	function deleterow(goodInfo){
    	// 商品id去重
		var table = document.getElementById('addTable');
		
		$("input[id=chk]").each(function(){
         	if($(this).val()== goodInfo.chkgoodis){
			   	$(this).parent().parent().remove();
           	}
		});

		amount();
		shouorhidebutton();
    }
    function scanbarcode(){
		if($('#smecicustomerid').val()==''){
			alert("请先选择会员！");
			$("#smecimemberid").focus();
			$("#smecimemberid").select();
			return;
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;

		if(is_iPad()){
			showPopWin("initScanBarcode.action",350,55,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initScanBarcode.action",350,55,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【条码扫描】";
	}
    
    function loadBar(obj)
    {
		var indexval = null;
		var goodidval = null;
		$('input[name=goodsInfoTempPo.goodsid]').each(function (){
			if(obj.toUpperCase().substring(0,18)==$(this).val().replace(/\./g,  "").toUpperCase()){
				indexval = $(this).attr("index");
				goodidval = $(this).val();
			}
			
		});
		if(indexval==null){
			alert("该商品条码没有匹配的商品！");
			return;
		}
		$('input[index=index'+indexval+']').val(obj);
		var getinput = $('input[index=index'+indexval+']')
		loadBarCode(getinput,goodidval);
	}

    function loadBarUpdateNumber(obj)
    {
		var indexval = null;
		var goodidval = null;
		
		$('input[name=goodsInfoTempPo.goodsid]').each(function (){
			if(obj.toUpperCase().substring(0,18)==$(this).val().replace(/\./g,  "").toUpperCase()){
				indexval = $(this).attr("index");
				goodidval = $(this).val();
			}
		});
		
		if(indexval==null){
			alert("该商品条码没有匹配的商品！");
			return;
		}
		
		$('input[index=index'+indexval+']').val(obj);
		var getinput = $('input[index=index'+indexval+']')
		loadBarCodeUpdateNumber(getinput,goodidval);
	}
	function loadBarCode(barCodeInputObj,goodsId){
		var goodsId = goodsId.replace(/\./g,  "").toUpperCase();
		var barCode = barCodeInputObj.val().toUpperCase().substring(0,18);
		if(goodsId != barCode){
			alert("商品代码与商品条码不符！");
			barCodeInputObj.val('');
			return;
		} 
		if(barCodeInputObj.val().length<26)
		{
			alert("商品条码位数不符！");
			barCodeInputObj.val('');
			return;
		}
		$(barCodeInputObj).parent().parent().find('.gbc').get(0).options.add(new Option(barCodeInputObj.val().toUpperCase(),barCodeInputObj.val().toUpperCase()));
		barCodeInputObj.val('');
		barCodeInputObj.focus();
		$(barCodeInputObj).parent().parent().parent().find('.number')[0].value=$(barCodeInputObj).parent().parent().find('.gbc option').size();
		amount();pricesum();price();
	}

	function loadBarCodeUpdateNumber(barCodeInputObj,goodsId){
		var goodsId = goodsId.replace(/\./g,  "").toUpperCase();
		var barCode = barCodeInputObj.val().toUpperCase().substring(0,18);
		if(goodsId != barCode){
			alert("商品代码与商品条码不符！");
			barCodeInputObj.val('');
			return;
		} 
		if(barCodeInputObj.val().length<26)
		{
			alert("商品条码位数不符！");
			barCodeInputObj.val('');
			return;
		}
		$(barCodeInputObj).parent().find('.gbc').val(barCodeInputObj.val().toUpperCase());
		barCodeInputObj.val('');
		barCodeInputObj.focus();
		$(barCodeInputObj).parent().parent().find('.number')[0].value=parseFloat($(barCodeInputObj).parent().parent().find('.number')[0].value) + 1;
		amount();pricesum();price();
		
	}
    
    function amount(){
    	var goodsquantityTotal = 0;
		var goodsquantity = document.getElementsByName("goodsInfoTempPo.goodsquantity");
		
		for(i=0;i<goodsquantity.length;i++){
			if(goodsquantity[i].value == ''){ goodsquantity[i].value=0;continue;}
			goodsquantity[i].value=new Number(goodsquantity[i].value);
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(0);
		}
		document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
	}
    function pricesum(){
    	var goodsquantityTotal = 0;
		var goodsquantity = document.getElementsByName("goodsInfoTempPo.retailpriceamount");
		
		for(i=0;i<goodsquantity.length;i++){
			if(goodsquantity[i].value == ''){ goodsquantity[i].value=0.00;continue;}
			goodsquantity[i].value=parseFloat(goodsquantity[i].value).toFixed(2);
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(2);
		}
		document.getElementById("rpriceamountTotal").innerText=goodsquantityTotal;
		if(goodsquantityTotal!=0){
		document.getElementById("rpriceamountTotals").innerText=goodsquantityTotal;
		}
		salesvalueamount();
	}
    function price(){
		var outgoodsquantityTotalss = 0;
		
		var outgoodsquantityss = document.getElementsByName("goodsInfoTempPo.goodsquantity");
		var outgoodsquantitypricess =document.getElementsByName("goodsInfoTempPo.retailprice");
		var goodssumprice=document.getElementsByName("goodsInfoTempPo.retailpriceamount");
		
		for(goodsIs=0;goodsIs<outgoodsquantityss.length;goodsIs++){
			if(outgoodsquantityss[goodsIs].value==0||goodssumprice[goodsIs].value==0){outgoodsquantitypricess[goodsIs].value=0.00; continue;}
			outgoodsquantityTotalss=parseFloat(accDiv(parseFloat(goodssumprice[goodsIs].value),parseFloat(outgoodsquantityss[goodsIs].value))).toFixed(2);	
			outgoodsquantitypricess[goodsIs].value=outgoodsquantityTotalss;
			
		}
	}
    function removeOption(item){
		$(item).parent().parent().find('.gbc').find('option:selected').remove();
		$(item).parent().parent().parent().find('.number')[0].value=$(item).parent().parent().find('.gbc option').size();
		autoCountOnlyOne($(item).parent().parent().parent().find('.number')[0]);		
		var total=0;
		$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#goodsquantityTotal').text(total);
	}
    
    function onBlurBarCode(barCodeInputObj,goodsId)
    {
		if(event.keyCode==13){
			var goodsId = goodsId.replace(/\./g,  "").toUpperCase();
			var barCode = barCodeInputObj.val().toUpperCase().substring(0,18);
			if(goodsId != barCode){
				alert("商品代码与商品条码不符！");
				barCodeInputObj.val('');
				return;
			} 
			
			if(barCodeInputObj.val().length<26)
			{
				alert("商品条码位数不符！");
				barCodeInputObj.val('');
				return;
			}
			
			$(barCodeInputObj).parent().find('.gbc').get(0).options.add(new Option(barCodeInputObj.val().toUpperCase(),barCodeInputObj.val().toUpperCase()));
			barCodeInputObj.val('');
			barCodeInputObj.focus();
			
			$(barCodeInputObj).parent().parent().find('.number')[0].value=$(barCodeInputObj).parent().find('.gbc option').size();
			autoCountOnlyOne($(barCodeInputObj).parent().parent().find('.number')[0]);			
			var total=0;
			$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
				total=accAdd(total,$(this).val());
			});
			$('#goodsquantityTotal').text(total);
		}
	}
    
     $(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
		$('#recipetype').attr("value","0");
		amount();
		pricesum();
		shouorhidebutton();
		isshow();
	});

 	$(document).ready(function(){
 		xjkaiqi();
 		if('${systemParameterPo.fsphisflag}' == '0' || '${person.bdplinkhisflag}' == '0'){
			document.getElementById('smecimemberid').focus(); 
        }	
		if('${print}'=='1'){
			setReportEvent('${salseID}','${ssesborderstype}','0',"-1");
		}
	});

	/**
	 * 配镜单打印主程序入口
	 * @id	配镜单号；
	 * @billType	配镜单销售类型；1：框架成品；2：框架定制；3:隐形成品；4：隐形定制；5：辅料；
	 * @dingjinFlag	是否欠款；1：欠款；
	 * @wflag	打印类型；1：销售；-1：退款；（为''空时，表示1)
	 */
	function setReportEvent(id,billType,dingjinFlag,wflag){	
		var DataURL='';
		
		//1、打印定金单
		if(dingjinFlag=='1'){//需要进行订金单打印
	    	if ($.trim('${systemParameterPo.fspsubscriptionbillname}') == ''){//没有配置订金单样式
	            alert('请先配置订金单样式!');
	            return;
	        }else{
				if($.trim('${systemParameterPo.fspsubscriptionbillserver}') =="1"){
					DataURL="report.action?reportlet=${systemParameterPo.fspsubscriptionbillname}&__bypagesize__=false&salesid="+id;
				}else if($.trim('${systemParameterPo.fspsubscriptionbillserver}') =="2"){
	    			DataURL = '<%= getServletContext().getInitParameter("rptUrl")%>';
	    			DataURL+="eims_reporting/${systemParameterPo.fspsubscriptionbillname}&salesID="+id+"&rs:Command=Render";	
	    		}
				window.open (DataURL, '订金单', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
	        }				
		}

		//2、打印配镜单
    	if(billType=='1' || billType=='2'){
    		if (wflag == '' || wflag=='1'){
    			if ($.trim('${systemParameterPo.fspsalesbillname1}') == ''){
    	            alert('请先配置框架配镜单样式!');
    	            return;
    	        }else{
    	    		if($.trim('${systemParameterPo.fspsalesbillserver1}') =="1"){
    	    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname1}&__bypagesize__=false&wflag="+ wflag +"&salesid="+id;
    	    		}else if($.trim('${systemParameterPo.fspsalesbillserver1}') =="2"){
    	    			DataURL = '<%= getServletContext().getInitParameter("rptUrl")%>';
    	    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname1}&salesID="+id+"&rs:Command=Render";	
    	    		}
    	        }
	        }else if(wflag=='-1'){
	        	if ($.trim('${systemParameterPo.fspsalesbillname1tui}') == ''){
		            alert('请先配置框架退款配镜单样式!');
		            return;
		        }else{
		    		if($.trim('${systemParameterPo.fspsalesbillserver1tui}') =="1"){
		    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname1tui}&__bypagesize__=false&wflag="+ wflag +"&salesid="+id;
		    		}else if($.trim('${systemParameterPo.fspsalesbillserver1tui}') =="2"){
		    			DataURL = '<%= getServletContext().getInitParameter("rptUrl")%>';
		    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname1tui}&salesID="+id+"&rs:Command=Render";	
		    		}
		        }
	        }   			
    	}else if(billType=='3' || billType=='4'){
    		if (wflag == '' || wflag=='1'){
        		if ($.trim('${systemParameterPo.fspsalesbillname3}') == ''){
    	            alert('请先配置隐形配镜单样式!');
    	            return;
    	        }else{
    	    		if($.trim('${systemParameterPo.fspsalesbillserver3}') =="1"){
    	    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname3}&__bypagesize__=false&wflag="+ wflag +"&salesid="+id;
    	    		}else if($.trim('${systemParameterPo.fspsalesbillserver3}') =="2"){
    	    			DataURL = '<%= getServletContext().getInitParameter("rptUrl")%>';
    	    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname3}&salesID="+id+"&rs:Command=Render";	
    	    		}
    	        }
	        }else if(wflag=='-1'){
	    		if ($.trim('${systemParameterPo.fspsalesbillname3tui}') == ''){
		            alert('请先配置隐形退款配镜单样式!');
		            return;
		        }else{
		    		if($.trim('${systemParameterPo.fspsalesbillserver3tui}') =="1"){
		    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname3tui}&__bypagesize__=false&wflag="+ wflag +"&salesid="+id;
		    		}else if($.trim('${systemParameterPo.fspsalesbillserver3tui}') =="2"){
		    			DataURL = '<%= getServletContext().getInitParameter("rptUrl")%>';
		    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname3tui}&salesID="+id+"&rs:Command=Render";	
		    		}
		        }
	        } 
	    }else if(billType=='5'){
    		if (wflag == '' || wflag=='1'){
        		if ($.trim('${systemParameterPo.fspsalesbillname5}') == ''){
    	            alert('请先配置辅料配镜单样式!');
    	            return;
    	        }else{
    	    		if($.trim('${systemParameterPo.fspsalesbillserver5}') =="1"){
    	    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname5}&__bypagesize__=false&wflag="+ wflag +"&salesid="+id;
    	    		}else if($.trim('${systemParameterPo.fspsalesbillserver5}') =="2"){
    	    			DataURL = '<%= getServletContext().getInitParameter("rptUrl")%>';
    	    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname5}&salesID="+id+"&rs:Command=Render";	
    	    		}
    	        } 
	        }else if(wflag=='-1'){
	    		if ($.trim('${systemParameterPo.fspsalesbillname5tui}') == ''){;		    		
		            alert('请先配置辅料退款配镜单样式!');
		            return;
		        }else{
		    		if($.trim('${systemParameterPo.fspsalesbillserver5tui}') =="1"){
		    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname5tui}&__bypagesize__=false&wflag="+ wflag +"&salesid="+id;
		    		}else if($.trim('${systemParameterPo.fspsalesbillserver5tui}') =="2"){
		    			DataURL = '<%= getServletContext().getInitParameter("rptUrl")%>';
		    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname5tui}&salesID="+id+"&rs:Command=Render";	
		    		}
		        } 
	        }		    		    
		}else{
			alert("单据类型异常！");
			return;
		}
	    window.open (DataURL, '配镜单', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');      
	}
   	
   
     /**
 	 *查看
 	 */
 	function selCustomerInfo(){
 	 	
 		if ('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2'){
            alert('此门店已经连接HIS系统，不能查询会员!');
            return;
        }
 		var topRows = top.document.getElementById("total").rows;
 		var topCols = top.document.getElementById("btmframe").cols;
 		if(is_iPad()){
 			showPopWin("initSelCustomerInfoWin.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
 		}else{
 			showPopWin("initSelCustomerInfoWin.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
 		}
 		document.getElementById('popupTitle').innerHTML="【会员查询】";
     }

	function details(id){
		if($('#smecicustomerid').val()==''){
			alert("请先选择顾客！");
			return;
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDetailsCustomerInfo.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDetailsCustomerInfo.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【顾客信息】";
	}
	function setCustomer(memberid){
		document.getElementById('smecimemberid').value = memberid;
		$("img").removeAttr("onclick");
		salesReturnForm.action = "selSalesReturnManagement.action";
		salesReturnForm.submit()
	}
	function changeSaleser(){
		$('#ssesbsalerid').attr("disabled","");
	}
	function disabledSelect(){
		$('#ssesbsalerid').attr("disabled","disabled");
		$('[name=salesBasicPo.ssesbsalerid]').val($('#ssesbsalerid').val());
	}
	 function cleanGoods(){
		// addTable
	        $('input[id=chk]').each(function(){ 
	           $(this).parent().parent().remove(); 
	        }); 

			document.all.chks.checked = false;
			amount();
			pricesum();

	    }
	function checkSalesType(){
		if($('#smecicustomerid').val()==''){
			alert("请先选择会员！");
			$("#smecimemberid").focus();
			$("#smecimemberid").select();
			$('#cstpgoodscategoryKJ').attr("checked","checked");
			return;
		}else{
			var table = document.getElementById('addTable');
			var categoryID_open = document.getElementsByName('cstpgoodscategory');
			var goodscategory=0;
			var defaultSalesType=$('#salesType').val()
			for(var i=0;i<categoryID_open.length;i++){
				if($(categoryID_open[i]).attr("checked")==true){
					goodscategory=categoryID_open[i].value;
				}
			}
			if(table.rows.length>2&&(defaultSalesType!=goodscategory)){
				if(confirm("更改 销售类型 将会清空已添加商品,是否更改?")){
					cleanGoods();
					$('#salesType').val(goodscategory);
					if(goodscategory==3){
						$('#recipetype').attr("value","0");
						$('#recipetype').attr("disabled",true);
						$('#ZZ').hide();
					}else if(goodscategory==2){
						$('#recipetype').attr("value","0");
						$('#recipetype').attr("disabled",false);
						$('#ZZ').show();
					}else if(goodscategory==1){
						$('#recipetype').attr("value","4");
						$('#recipetype').attr("disabled",true);
						$('#ZZ').hide();
					}
				}
				else{
					if(defaultSalesType==1){
						$('#cstpgoodscategorysJP').attr("checked","checked");
						$('#recipetype').attr("value","4");
						$('#recipetype').attr("disabled",true);
						$('#ZZ').hide();
					}else if(defaultSalesType==2){
						$('#cstpgoodscategoryKJ').attr("checked","checked");
						$('#recipetype').attr("value","0");
						$('#recipetype').attr("disabled",true);
						$('#ZZ').show();
					}else if(defaultSalesType==3){
						$('#cstpgoodscategoryFL').attr("checked","checked");
						$('#recipetype').attr("value","0");
						$('#recipetype').attr("disabled",true);
						$('#ZZ').hide();
					}
				}
			}
			else{
				$('#salesType').val(goodscategory);
				if(goodscategory==3){
					$('#recipetype').attr("value","0");
					$('#recipetype').attr("disabled",true);
					$('#ZZ').hide();
				}else if(goodscategory==2){
					$('#recipetype').attr("value","0");
					$('#recipetype').attr("disabled",false);
					$('#ZZ').show();
				}else if(goodscategory==1){
					$('#recipetype').attr("value","4");
					$('#recipetype').attr("disabled",true);
					$('#ZZ').hide();
				}
			}
		}
	}
	function checkPrice(thiz, fixed) {
		if(!isNaN(thiz.value)) { 
			if(!thiz.value){
				thiz.value = '';
			}else{
				thiz.value=parseFloat(thiz.value).toFixed(parseInt(fixed));
			}
		} else {
			thiz.value=parseFloat(0).toFixed(parseInt(fixed));
		}
	}
	/*
	添加附加费
	*/
	var fujiafei=0;//附加费全局变量
	function addCosts(obj){
		if($('#smecicustomerid').val()==''){
			alert('请先输入会员卡号!');
			return;
		}
		if($('#additionalCosts')[0].selectedIndex==0)
		{
			alert('请选择附加费用!');
			return;
		}
		if(!$(obj).attr("id")){
			var isadd = '';
			$("input[name=additionalCDetailPo.ssenumber]").each(function (){
				if($('#additionalCosts').val().split(',')[0] == $(this).attr("id")){
					$(this).val(parseFloat($(this).val())+1);
					$(this).parent().parent().find('span[id=amountMoney]').text("￥"+accMul($(this).parent().parent().find('input[name=additionalCostsPo.facamount]').val(),parseFloat(this.value)).toFixed(2));
					$(this).parent().parent().find('input[id=amountMoney]').val(accMul($(this).parent().parent().find('input[name=additionalCostsPo.facamount]').val(),parseFloat(this.value)).toFixed(2));
					isadd = '1';
				}
			});
			if(isadd=='1'){
				var famount = 0;
	       		$('input[id=amountMoney]').each(function (){
	       			famount1 = accAdd(famount, $(this).val());
	       		});
	       		fujiafei = famount;
	       		totalamount();
	      		salesvalueamount();
				return;
			}
		}
	       	//各种金额计算
  		if((/^(\+|-)?\d+$/.test( obj.value ))&& obj.value > 0){  
  			$(obj).parent().parent().find('span[id=amountMoney]').text("￥"+accMul($(obj).parent().parent().find('input[name=additionalCostsPo.facamount]').val(),parseFloat(obj.value)).toFixed(2));
			$(obj).parent().parent().find('input[id=amountMoney]').val(accMul($(obj).parent().parent().find('input[name=additionalCostsPo.facamount]').val(),parseFloat(obj.value)).toFixed(2));
       		var famount = 0;
       		$('input[id=amountMoney]').each(function (){
       			famount = accAdd(famount, $(this).val());
       		});
       		fujiafei = famount;
	    }else if(typeof(obj.value)=='undefined'){
       		$("#copyrowCosts").show();
        	$("#copyrowCosts").clone(true).removeAttr("id=copyrowCosts").appendTo($("#copyrowCosts"));
        	$("#copyrowCosts").hide();
        	var index=$('#copyrowCosts+tr').size()+1;
        	$('input[name=additionalCDetailPo\\.sseadditionalid]').get(index).value=$('#additionalCosts').val().split(',')[0];
        	$('input[name=additionalCostsPo\\.facname]').get(index).value=$('#additionalCosts').val().split(',')[0];	
        	$('input[name=additionalCostsPo\\.facamount]').get(index).value=$('#additionalCosts').val().split(',')[1];	
        	$('input[name=additionalCDetailPo\\.ssenumber]').get(index).validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写附加费数量！'},{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '附加费数量应为正整数！'}]";
        	$('input[name=additionalCDetailPo\\.ssenumber]').get(index).value="1";
        	$('input[name=additionalCDetailPo\\.ssenumber]').get(index).id=index;
        	$('span[id=costs]').get(index).innerText=$('#additionalCosts :selected').text();	
        	$('span[id=costsMoney]').get(index).innerText="￥"+$('#additionalCosts').val().split(',')[1];	
        	$('span[id=amountMoney]').get(index).innerText="￥"+$('#additionalCosts').val().split(',')[1];
        	$('input[id=amountMoney]').get(index).value=$('#additionalCosts').val().split(',')[1];
       		fujiafei=accAdd(fujiafei,$('#additionalCosts').val().split(',')[1]);
       		$('input[name=additionalCDetailPo\\.ssenumber]').eq(index).attr("id",$('#additionalCosts').val().split(',')[0]);
		}else{
   			alert("附加费数量格式有误！");
   			obj.focus();
   			obj.select();
   			return;
		}
  		totalamount();
  		salesvalueamount();
	}
	/*
	删除行
	*/
	function deleteItem(item){
		
		var cycle=0;
		$('input[name=orderCycle]').each(function(){
			if($(this).val()!=''){
				if(parseFloat($(this).val())>parseFloat(cycle)){
					cycle=$(this).val();
				}
			}
		});
		if(cycle!=0&&cycle==$(item).parent().parent().parent().find('input[name=orderCycle]').val()){
			var d = new Date();
			var vHour=d.getHours();
			var vMin=d.getMinutes();
	
			if(vHour.toString().length==1){
				vHour='0'+vHour;
			}
			if(vMin<10){
				vMin='0'+vMin;
			}
			$('#ssesbtakeglassdata').val(PlusDay($('#ssesbtakeglassdata').val(),parseFloat('-'+cycle))+' '+vHour+':'+vMin);
		}
		bgiordercycle=0;
		
		$(item).parent().parent().parent().remove();		
			//委外周期删除
		
		var cycle1=0;
		$('input[name=orderCycle]').each(function(){
			if($(this).val()!=''){
				if(parseFloat($(this).val())>parseFloat(cycle1)){
					cycle1=$(this).val();
				}
			}
		});
		if(cycle1!=''&&cycle1!=0){
			calculate(cycle1);
		}
		
		
		var supplierids="";
        $('input[name=salesDetailPo.ssesdsalesitemids]').each(function (){
			if($(this).val().substring(2,4)){
				supplierids = supplierids + $(this).val().substring(2,4)+",";
			}
        });
       
			
	}
	/*
	删除附加费重新计算
	*/
	function deleteVar2(item){
		totalamount();
  		salesvalueamount();
	}
	
	function parseData(arg0){
		arg0=arg0.toString();
		 if(param==1){
				if(arg0.indexOf('.')!=-1){
					arg0=arg0.substring(0,arg0.indexOf('.'));
				}
				arg0=arg0+".00";
		}else if(param==2){
				if(arg0.indexOf('.')!=-1){
					arg0=arg0.substring(0,arg0.indexOf('.')+2);
					arg0=arg0+"0";
				}else {
					arg0=arg0+".00";
				}
		}
		return arg0;
	}
	function totalamount(){
        var fujiatotal = 0;
        $("input[name=amountMoney]").each(function (){
        	if($(this).val() != ""){
        		fujiatotal = accAdd(fujiatotal,$(this).val()).toFixed(2);
        	}
        });
        
    }

 	function changebarcode(index,obj){
 		if(!obj.val()){
			return;
		}
   	   	
   	   	if(!/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})/.test(obj.val())&&obj.val()){
			alert("日期格式不正确！\n例如：2013-04-01");
			obj.val("");
			obj.focus();
			return;
   	   	}
   	 	var str =obj.val();
   		str = str.replace(/-/g,"/");
   		var monthpart = str.split("/")[1];
   		if(monthpart == 0){
			alert("日期月份格式不正确！");
			obj.val("");
			obj.focus();
			return;
   	   	}
   		var daypart = str.split("/")[2];
   		if(daypart == 0){
			alert("日期天格式不正确！");
			obj.val("");
			obj.focus();
			return;
   	   	}
   		var date = new Date(str );
   		obj.val(ChangeDateToString(date));

		if(isNaN(obj.val().substring(0,4))){
			alert("日期格式不正确！\n例如：2013-04-01");
			obj.val("");
			obj.focus();
			return;
		}

		if(obj.val().substring(0,4) < new Date().getYear()){
			alert("日期格式不正确，失效日期不得小于当前年份！");
			obj.val("");
			obj.focus();
			return;
		}
   		
   	   	if(obj.val().length==10){
	   		var pclength = obj.val().length;
	   		var pcvalue = obj.val();
	   		
	   		if(pclength < 8){
	   			for(pclength ; pclength < 8; pclength++){
	   				pcvalue = pcvalue + '0';
	   			}
	   		}else if(pclength > 8){
	   			pcvalue=pcvalue.substring(pclength-8,pclength);
	   		}	
	   		
	   		var tmvalue = $(obj).parent().parent().find("#pcbarcode").val().substring(0,18);
	   		var xqvalue = $(obj).val().replace(/\-/g,"").substring(2);
	   		var bcvalue = $(obj).parent().parent().find("#pcbarcode").val().substring(24,26);
	   		$(obj).parent().parent().find("#pcbarcode").val(tmvalue+xqvalue+bcvalue);
   	   	}
   	}

   	function loadSimpleBatch(barcode,batch,obj){
   	   	//alert($(obj).attr("id"));
   	// alert($(obj).parent().parent().find("#pc").val());
   	   	if(($(obj).attr("id") == "pc"&&$(obj).parent().parent().find("#xq").val() != "")||($(obj).attr("id") == "xq"&&$(obj).parent().parent().find("#pc").val() != "")){
	   	   	$.ajax({           
		   	 	type: "POST",          
	   	   	    url: "getAjaxSimpleBatch.action",          
	   	   	    async: true, 
	   	   	    data: "barcode="+barcode+"&batch="+batch,     
	   	   	    success: function(msg){
		   	   		var barcodestr = $(obj).parent().parent().find("#pcbarcode").val();   
		   	   		$(obj).parent().parent().find("#pcbarcode").val(barcodestr.substring(0,24)+msg);                       
	   	   	    }    
		   	});
   	   	}
    }
    
   function ChangeDateToString(DateIn){
   var Year=0;
   var Month= 0;
   var Day =0;
   var CurrentDate = "";
 
   //初始化时间
     
       Year  =DateIn.getYear();
    
       Month =DateIn.getMonth()+1;
    
       Day =DateIn.getDate();
    
       CurrentDate =Year +"-";
    
       
   if(Month >=10)
   {
     CurrentDate  =CurrentDate +Month + "-";
   }else{
     CurrentDate =CurrentDate+"0"+Month +"-";
   }
   if(Day >=10){
     CurrentDate=CurrentDate +Day;
   }else{
     CurrentDate =CurrentDate +"0"+Day;
   }
     
   return CurrentDate;
    
   }

   function jfSum(){
   	var sum = 0;
   	var checknum = "";
   	$('input[leixing=leixing]').each(function (){
   		if($(this).val() == ''){
   			$(this).val('0.00');
   		}
   		if ($(this).val()>=0){
   		}else{
			alert('数字格式输入错误！');
			$(this).select();
			$(this).focus();
			checknum = "1";
			return false;
		}
   		sum = accAdd($(this).val(),sum).toFixed(2);	
   	});
   	
   	if(checknum == "1"){
   		return;
   	}
   	$('#jf').val(sum);

   }
   
   function czkOpen(obj){
   	var indexid = $("input[czkv=czkv]").index(obj);
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initCzkOpen.action?returntype=1&indexid="+indexid,500,200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initCzkOpen.action?returntype=1&indexid="+indexid,500,200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【储值卡查询】";
   }
   
   function toRound(czkv,czkye,czkid,fpddiscount,indexid){
   	$('input[czkv=czkv]').eq(indexid).val(czkv);
   	$('input[czkye=czkye]').eq(indexid).val(czkye);
   	$('input[czkid=czkid]').eq(indexid).val(czkid);
   	$('input[name=fpddiscount]').val(fpddiscount);
   	jfSum();
   }
   function toRound2(djqv,djqye,djqid,fpddiscount,indexid){

   	$('input[djqv=djqv]').eq(indexid).val(djqv);
   	$('input[djqye=djqye]').eq(indexid).val(djqye);
   	$('input[djqid=djqid]').eq(indexid).val(djqid);
   	$('input[name=fpddiscount]').val(fpddiscount);
   	jfSum();
   }
   function djqOpen(obj){
   	var indexid = $("input[djqv=djqv]").index(obj);
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDjqOpen2.action?indexid="+indexid,500,200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDjqOpen2.action?indexid="+indexid,500,200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【代金券查询】";
   }
   function clean(){
   	$('input[leixing=leixing]').each(function (){
   		$(this).val('0.00');
   	});
   	jfSum();
   }
   
   //现金
	function xjkaiqi(){
		if (document.getElementById('trxj') != null){
			document.getElementById('trxj').style.display = "";
		}
		if (document.getElementById('xjkaiqi') != null){
			document.getElementById('xjkaiqi').style.display = "none";
		}
	}
	
	function xjguanbi(){
		document.getElementById('trxj').style.display = "none";
		document.getElementById('xjkaiqi').style.display = "";
		$('input[xjv=xjv]').val('0.00');
		jfSum();
	}
	
	//银行卡
	function yhkkaiqi(){
		document.getElementById('yhktr').style.display = "";
		document.getElementById('yhkkaiqi').style.display = "none";
	}
	
	function yhkguanbi(){
		document.getElementById('yhktr').style.display = "none";
		document.getElementById('yhkkaiqi').style.display = "";
		$('input[yhkv=yhkv]').val('0.00');
		$('select[name=yhkt]').val('');
		jfSum();
	}
	//其他
	function qtkaiqi(){
		document.getElementById('qttr').style.display = "";
		document.getElementById('qtkaiqi').style.display = "none";
	}
	
	function qtguanbi(){
		document.getElementById('qttr').style.display = "none";
		document.getElementById('qtkaiqi').style.display = "";
		$('input[qtv=qtv]').val('0.00');
		$('select[name=qtt]').val('');
		jfSum();
	}
	//代金券
	function djqkaiqi(){
		document.getElementById('djqtr').style.display = "";
		document.getElementById('djqkaiqi').style.display = "none";
	}
	
	function djqguanbi(){
		document.getElementById('djqtr').style.display = "none";
		document.getElementById('djqkaiqi').style.display = "";
		$('input[djqv=djqv]').val('0.00');
		$('input[djqid=djqid]').val('');
		jfSum();
	}
	
	//兑换积分
	function dhjfkaiqi(){
		document.getElementById('dhjf').style.display = "";
		document.getElementById('dhjfkaiqi').style.display = "none";
	}
	
	function dhjfguanbi(){
		document.getElementById('dhjf').style.display = "none";
		document.getElementById('dhjfkaiqi').style.display = "";
		
		$('input[name=jfdhv]').val('0');
		$('input[jfv=jfv]').val('0');
		jfSum();
	}
	
	function czkkaiqi(){
		document.getElementById('czktr').style.display = "";
		document.getElementById('czkkaiqi').style.display = "none";
	}
	
	function czkguanbi(){
		document.getElementById('czktr').style.display = "none";
		document.getElementById('czkkaiqi').style.display = "";
		$('input[czkv=czkv]').val('0.00');
		$('input[czkid=czkid]').val('');
		jfSum();
	}
	
	//银行卡
	function yhkxinzeng(){
		document.getElementById('yhkxinzeng').style.display = "";
	}
	
	function yhkshanchu(){
		document.getElementById('yhkxinzeng').style.display = "none";
	}
	
	//储值卡
	function czkxinzeng(){
		document.getElementById('czkxinzeng').style.display = "";
	}
	
	function czkshanchu(){
		document.getElementById('czkxinzeng').style.display = "none";
	}
	
	/***********************************************
	'函数名：insertAfter()
	'作  用：将一个新元素插入另一个元素后面
	'参  数：newElement - 新元素; targetElement - 目标元素
	'返回值：
	'eg   : insertAfter(p1,p0)
	'***********************************************/

	function insertAfter(newElement,targetElement)
	{
		var parent = targetElement.parentNode;
		if(parent.lastChild == targetElement)
		{
			parent.insertBefore(newElement);
		}
		else
		{
			parent.insertBefore(newElement,targetElement.nextSibling);  // insertBefore
		}
	} 
	
	function addRowY(tableName,args,trid) {
		document.getElementById('yhkdelete').style.display = "none";
		document.getElementById('yhknbsp').style.display = "";
		var txtName = document.getElementById(trid);
		var htmltr  = document.createElement("tr");
		var htmltd1 = document.createElement("td");
		var htmltd2 = document.createElement("td");
		var htmltd3 = document.createElement("td");
		var htmltd4 = document.createElement("td");
		
		htmltd1.innerHTML = "银行卡：";
		htmltd1.className = "table_body";
		$(htmltd1).attr("align","center");
		$(htmltd1).attr("height","26");
		var options = "";
		<c:forEach var="po" items="${bankPos}" varStatus="idxStatus">
			options = options + "<option value="+'${po.bbnumber}'+"  >"+'${po.bbname}'+"</option>";
		</c:forEach>
		htmltd2.innerHTML = "<select id=\"yhkt\" name=\"yhkt\">"+
							"<option value=\"\"  >----请选择----</option>"+
							options+
							"</select>"+
							" <input type=\"text\" class=\"text_input100\"  onblur=\"$(this).val($.trim($(this).val()));jfSum();\" id=\"yhkv\" name=\"yhkv\" leixing=\"leixing\" maxlength=\"10\" value=\"0\" validate=\"[{\'Type\' : Type.String, \'Formula\' : Formula.FloatORNULL, \'Message\' : \'填写的金额不正确！\'}]\"/>";
		htmltd2.className = "table_none";
		
		htmltd3.innerHTML = "<img src=\"${ctx }/img/newbtn/btn_delete_0.png\" onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" btn=btn style=\"cursor: hand;\" title='删除' onClick=\"javascript:dele(this,'yhk')\">";
		htmltd3.className = "table_body";
		$(htmltd3).attr("align","center");
		
		htmltd4.className = "table_none";
		htmltd4.innerHTML = "&nbsp;";
		
		htmltr.appendChild(htmltd1);
		htmltr.appendChild(htmltd2);
		htmltr.appendChild(htmltd3);
		htmltr.appendChild(htmltd4);
		
		insertAfter(htmltr,txtName);

   }
	function addRowqt(tableName,args,trid) {
		document.getElementById('qtdelete').style.display = "none";
		document.getElementById('qtnbsp').style.display = "";
		var txtName = document.getElementById(trid);
		var htmltr  = document.createElement("tr");
		var htmltd1 = document.createElement("td");
		var htmltd2 = document.createElement("td");
		var htmltd3 = document.createElement("td");
		var htmltd4 = document.createElement("td");
		
		htmltd1.innerHTML = "其他：";
		htmltd1.className = "table_body";
		$(htmltd1).attr("align","center");
		$(htmltd1).attr("height","26");
		var options = "";
		<c:forEach var="po" items="${otherbankPos}" varStatus="idxStatus">
			options = options + "<option value="+'${po.bbnumber}'+"  >"+'${po.bbname}'+"</option>";
		</c:forEach>
		htmltd2.innerHTML = "<select id=\"qtt\" name=\"qtt\">"+
							"<option value=\"\"  >----请选择----</option>"+
							options+
							"</select>"+
							" <input type=\"text\" class=\"text_input100\"  onblur=\"$(this).val($.trim($(this).val()));jfSum();\" id=\"qtv\" name=\"qtv\" leixing=\"leixing\" maxlength=\"10\" value=\"0\" validate=\"[{\'Type\' : Type.String, \'Formula\' : Formula.FloatORNULL, \'Message\' : \'填写的金额不正确！\'}]\"/>";
		htmltd2.className = "table_none";
		
		htmltd3.innerHTML = "<img src=\"${ctx }/img/newbtn/btn_delete_0.png\" onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" btn=btn style=\"cursor: hand;\" title='删除' onClick=\"javascript:dele(this,'qt')\">";
		htmltd3.className = "table_body";
		$(htmltd3).attr("align","center");
		
		htmltd4.className = "table_none";
		htmltd4.innerHTML = "&nbsp;";
		
		htmltr.appendChild(htmltd1);
		htmltr.appendChild(htmltd2);
		htmltr.appendChild(htmltd3);
		htmltr.appendChild(htmltd4);
		
		insertAfter(htmltr,txtName);

    }
    function addRowdjq(tableName,args,trid) {
    	document.getElementById('djqdelete').style.display = "none";
		document.getElementById('djqnbsp').style.display = "";
        
		var txtName = document.getElementById(trid);
		var htmltr = document.createElement("tr");
		var htmltd1 = document.createElement("td");
		var htmltd2 = document.createElement("td");
		var htmltd3 = document.createElement("td");
		var htmltd4 = document.createElement("td");
		
		htmltd1.innerHTML = "代金券：";
		htmltd1.className = "table_body";
		$(htmltd1).attr("align","center");
		$(htmltd1).attr("height","26");
		htmltd2.innerHTML = " <input type=\"text\" style=\"border: none;font-family: 黑体;font-size: 14;background: ;text-align:center;\" readonly=\"readonly\" class=\"text_input100\" djqid=djqid name=\"djqid\"  />&nbsp;&nbsp; <input type=\"text\" djqv=djqv class=\"text_input100\" onclick=\"djqOpen(this)\" leixing=\"leixing\" name=\"djqv\" readonly=\"readonly\" onblur=\"jfSum()\" value=\"0.00\"/><input type=\"hidden\" djqye=djqye  name=\"djqye\"/>";
		htmltd2.className = "table_none";
		
		htmltd3.innerHTML = "<img src=\"${ctx }/img/newbtn/btn_delete_0.png\" onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" btn=btn style=\"cursor: hand;\" title='删除' onClick=\"javascript:dele(this,'djq')\">";
		htmltd3.className = "table_body";
		$(htmltd3).attr("align","center");
		
		htmltd4.className = "table_none";
		htmltd4.innerHTML = "&nbsp;";
		
		htmltr.appendChild(htmltd1);
		htmltr.appendChild(htmltd2);
		htmltr.appendChild(htmltd3);
		htmltr.appendChild(htmltd4);
		
		insertAfter(htmltr,txtName);

    }
   function addRow1(tableName,args,trid) {
   	document.getElementById('czkdelete').style.display = "none";
		document.getElementById('czknbsp').style.display = "";
       
		var txtName = document.getElementById(trid);
		var htmltr = document.createElement("tr");
		var htmltd1 = document.createElement("td");
		var htmltd2 = document.createElement("td");
		var htmltd3 = document.createElement("td");
		var htmltd4 = document.createElement("td");
		
		htmltd1.innerHTML = "储值卡：";
		htmltd1.className = "table_body";
		$(htmltd1).attr("align","center");
		$(htmltd1).attr("height","26");
		htmltd2.innerHTML = " <input type=\"hidden\" style=\"border: none;font-family: 黑体;font-size: 14;background: ;text-align:center;\" readonly=\"readonly\" class=\"text_input100\" czkid=czkid name=\"czkid\" value=\"0\" />&nbsp;&nbsp; <input type=\"text\" czkv=czkv class=\"text_input100\" onclick=\"czkOpen(this)\" leixing=\"leixing\" name=\"czkv\" readonly=\"readonly\" onblur=\"jfSum()\" value=\"0.00\"/><input type=\"hidden\" czkye=czkye  name=\"czkye\"/>";
		htmltd2.className = "table_none";
		
		htmltd3.innerHTML = "<img src=\"${ctx }/img/newbtn/btn_delete_0.png\" onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" btn=btn style=\"cursor: hand;\" title='删除' onClick=\"javascript:dele(this,'czk')\">";
		htmltd3.className = "table_body";
		$(htmltd3).attr("align","center");
		
		htmltd4.className = "table_none";
		htmltd4.innerHTML = "&nbsp;";
		
		htmltr.appendChild(htmltd1);
		htmltr.appendChild(htmltd2);
		htmltr.appendChild(htmltd3);
		htmltr.appendChild(htmltd4);
		
		insertAfter(htmltr,txtName);

   }
   
   function dele(obj,type){
   		$(obj).parent().parent().remove();
   	
   		if(type == 'yhk'){
	   		var yhksize = 0;
			$('input[name=yhkv]').each(function (){
				yhksize = yhksize + 1;
			});
			
			if(yhksize == 1){
	        	document.getElementById('yhkdelete').style.display = "";
	    		document.getElementById('yhknbsp').style.display = "none";
	        }
      	}

   		if(type == 'czk'){
	   		var czksize = 0;
				$('input[name=czkv]').each(function (){
				czksize = czksize + 1;
			});
			
			if(czksize == 1){
	        	document.getElementById('czkdelete').style.display = "";
	    		document.getElementById('czknbsp').style.display = "none";
	        }
       	}
    	if(type == 'djq'){
    		var djqsize = 0;
			$('input[name=djqv]').each(function (){
				djqsize = djqsize + 1;
			});
			
			if(djqsize == 1){
	        	document.getElementById('djqdelete').style.display = "";
	    		document.getElementById('djqnbsp').style.display = "none";
	        }
        }
    	if(type == 'qt'){
    		var qtsize = 0;
			$('input[name=qtv]').each(function (){
				qtsize = qtsize + 1;
			});
			
			if(qtsize == 1){
	        	document.getElementById('qtdelete').style.display = "";
	    		document.getElementById('qtnbsp').style.display = "none";
	        }
        }
   		jfSum();
   }

   function jfcheck(obj){
   	if(parseFloat($(obj).val()) > parseFloat('${customerInfoPo.smeciintegral }')){
			alert("可用积分不足！");
			$(obj).val('');
			$(obj).focus();
			return;
       }

   	$("input[name=jfdhv]").val($(obj).val()*'${systemParameterPo.fspexchangeintegral }');
   }

   function salesvalueamount(){
	   var fujiatotal = 0;
       $("input[name=amountMoney]").each(function (){
       	if($(this).val() != ""){
       		fujiatotal = accAdd(fujiatotal,$(this).val()).toFixed(2);
       	}
       });

       var retailpriceamount = 0;
       $("input[name=goodsInfoTempPo.retailpriceamount]").each(function (){
          if($(this).val() != ""){
          	retailpriceamount = accAdd(retailpriceamount,$(this).val()).toFixed(2);
          }
       });
		$("#salseValue").val(accAdd(fujiatotal,retailpriceamount).toFixed(2));
   }
   function addSalesGoods(goodscategory,direction, materialType,accessoryType,oneselfframe,iscustomize){	
		if($('#smecicustomerid').val()==''){
			alert("请先选择会员！");
			$("#smecimemberid").focus();
			$("#smecimemberid").select();
			return;
		}			
	    path = '&sph=+3.75&cyl=0.00&add=&glassFlag=R&materialType=1&recipeType=2&sph=+3.50&cyl=0.00&add=&glassFlag=L&materialType=undefined&recipeType=2';

		var other = '';
		if(goodscategory == 'other'){
			goodscategory = '1';
			other = '1';
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
			if(is_iPad()){
				showPopWin("selectSellMirrorFrameAlls.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&accessoryType="+accessoryType+"&oneselfframe="+oneselfframe+"&iscustomize="+iscustomize+path+"&other="+other+"&kucun=1&whichretail=1&select_retail=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("selectSellMirrorFrameAlls.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&accessoryType="+accessoryType+"&oneselfframe="+oneselfframe+"&iscustomize="+iscustomize+path+"&other="+other+"&kucun=1&whichretail=1&select_retail=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
	
		
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}	
	
	  /**
 	 *回车事件
 	 */
    
function selectCust(flag){
		if(flag){
				$("img").removeAttr("onclick");
	 			salesReturnForm.action = "selSalesReturnManagement.action";
	 			salesReturnForm.submit();
		}
	}
function selectCustomer(){
    if('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2'){
            alert('此门店已经连接HIS系统，不能查询会员!');
         return ;
	}
	if(document.getElementById('smecimemberid').value.trim() != ''){
		if(event.keyCode == 13){
			$("img").removeAttr("onclick");
			salesReturnForm.action = "selSalesReturnManagement.action";
 			salesReturnForm.submit();
		}
	}
}	

</script>
<jsp:include page="/hisCusWin_js.jsp" flush="true" />
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="salesReturnForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<input type="hidden" name="cstisourcebillid" id="cstisourcebillid" value="${cstisourcebillid}" /> 
<input type="hidden" name="justType" id="justType" value="salesReturn">
<input type="hidden" name="salesType" id="salesType" >
<input type="hidden" name="return" id="return" value="1">
<DIV><TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>无配镜单退款管理</TD>
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：无配镜单退款</TD>
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
                  <!-- 信息提示框 -->
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                     <TBODY>
                       <TR>
                         <TD width="5%"></TD>
                       </TR>
                     </TBODY>
                   </TABLE>
					
					<fieldset>
						<legend>顾客资料</legend>
						<TABLE width="98%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
					      <tr height="26">
					        <td bgcolor="#cadee8">
					          
					          <li class="horizontal">卡号&nbsp;
					                <input type="text" id="smecimemberid" name="smecimemberid" class="text_input100" ${ systemParameterPo.fsphisflag == '2' && person.bdplinkhisflag == '1' ? 'readonly=readonly':'' }
					                	value="${customerInfoPo.smecimemberid }" onkeyup="selectCustomer();" >
					                <input type="hidden" id="smecicustomerid" name="smecicustomerid" class="text_input100" 
					                	value="${customerInfoPo.smecicustomerid }">	
					          </li>
					            <li class="horizontal">
					              <img src="${ctx }/img/newbtn/btn_hydq_0.png" btn=btn hisn=hisn title='查找' >
					              <img src="${ctx }/img/newbtn/btn_search_0.png" name="button22" title='查找' btn=btn onclick="selCustomerInfo();" >
					            </li>
					          <li class="horizontal">姓名&nbsp;
					                <input class="text_input60" readOnly="readOnly"  value="${customerInfoPo.smeciname }">
					          </li>
					          <li class="horizontal">性别&nbsp;
					                <input value="${not empty(customerInfoPo.smecisex) ? (customerInfoPo.smecisex == '0' ? '男' : '女') : ''}" class="text_input40" readOnly="readOnly">
					          </li>
					          <li class="horizontal">年龄&nbsp;
					                <input  value="${customerInfoPo.fmmage }" class="text_input40" readOnly="readOnly">
					          </li>
					          <li class="horizontal">&nbsp;
					            <img src="${ctx }/img/newbtn/btn_details_0.png" btn=btn name="button32" title='详情' onClick="javascript:details('${customerInfoPo.smecicustomerid }');" >
					          </li>
					          <li id="saleserDiv" class="horizontal"><img name="button32" btn=btn id='saleser' src="${ctx}/img/newbtn/btn_changesaleser_0.png" title="更换销售员" align="left" onclick="changeSaleser()">
								</li>
								<li id="saleserDiv" class="horizontal">
									<SELECT id="ssesbsalerid" name="ssesbsalerid" disabled="disabled" onchange="disabledSelect()">
										<c:forEach var="po" items="${personInfoPos}">
											<option value="${po.id }" ${person.id != po.id ? '':'selected=selected'}>${po.personName }</option>
										</c:forEach>
									</SELECT>
									<input name="salesBasicPo.ssesbsalerid" type="hidden" value=''> 
								</li>
					      </tr>
					    </table>
					</fieldset>  <br/> 
					
					<table width="100%" border=0  cellpadding=1 cellspacing=1 >
					<tr height="26">
					<td width="49%">
					<fieldset>
						<legend>销售类型</legend>
						<TABLE width="98%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
					      <tr height="26">
					        <td bgcolor="#cadee8" width="30%" align="center">
					        <input type="radio" id="cstpgoodscategoryKJ" onclick="checkSalesType();" name="cstpgoodscategory" value="2" checked="checked" >
					          镜框销售&nbsp;
					              <input type="radio" id="cstpgoodscategorysJP" onclick="checkSalesType();" name="cstpgoodscategory" value="1"  >
					            隐形销售&nbsp;
					                <input type="radio" id="cstpgoodscategoryFL" onclick="checkSalesType();" name="cstpgoodscategory" value="3"  >
					           辅料销售&nbsp;
					          </td>
					          
							</tr>
					    </table>
					</fieldset>  
					</td>
						<td width="49%">
							<fieldset>
								<legend>处方类型</legend>
								<TABLE width="98%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
							      <tr height="26">
							        <td bgcolor="#cadee8" width="30%" >
							        	<li class="horizontal">&nbsp;
											<select id="recipetype" name="recipetype"  >
												<option value="0">---请选择---</option>
												<option value="1" selected="selected">远用</option>
												<option value="2">近用</option>
												<option value="3">渐进/双光</option>
												<option value="5">中用</option>
												<option value="4">隐形</option>
											</select>
											</li>
							          </td>  
									</tr>
							    </table>
							</fieldset> 
						</td>
					</tr>
					<tr height="26" id="ZZ">
						<td>
							<table id="ourframeorglass" width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">  
	                              <tr>
	                                <td width="50%" class="table_none" align="center"><img btn=btn title="自架" src="${ctx }/img/newbtn/btn_zj_0.png" onclick="addSalesGoods('1','','','','ZZ','');"/></td>
	                                <td width="50%" class="table_none" align="center"><img btn=btn title="自片" src="${ctx }/img/newbtn/btn_zp_0.png" onclick="addSalesGoods('3','','','','ZZ','');"/></td>
	                              </tr>
	                            </table>
	                    </td>
					</tr>
					</table> 
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left" width="80%"> 
 							<img src="${ctx}/img/newbtn/btn_addgoods_0.png" btn=btn title="单品添加商品" onClick="javascript:openGoodSingle();">
					     	<%--<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
						   <img src="${ctx}/img/newbtn/btn_scanbarcode_0.png" btn=btn title="条码扫描" onClick="javascript:scanbarcode();">
						   </c:if>--%>
                          <img id="del" src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title='删除' onClick="deleteitem();"></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </TABLE>
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                        <TR class=table_title align=middle>                     
                          <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" name="chks" onclick="chkAll()"></TH>
                          <TH scope=col width="13%" height="26">商品代码</TH>
						  <TH scope=col width="13%">商品名称</TH>						
                          <TH scope=col width="5%">型号</TH>                          
 						  <TH scope=col width="5%">数量</TH>	
						  <TH scope=col width="6%">销售单价</TH>
						  <TH scope=col width="6%">销售金额</TH>	
						  <c:if test="${systemParameterPo.fspstealtheffective==1||systemParameterPo.fspstealtheffective==2}">
						  <TH scope=col id="xiaoqi" width="6%">效期</TH>
						  <TH scope=col id="pici" width="6%">批号</TH>	
						  </c:if>			  
                          <TH scope=col width="20%">商品条码</TH>
                          <TH scope=col width="8%">左/右眼</TH>
                        </TR>
						<tr class=table_title align=middle> 
						  	<th height="26" colSpan=4 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</th>
					    	<th scope=col id="goodsquantityTotal">&nbsp;</th>
					    	<th scope=col>&nbsp;</th>
					    	<th scope=col id="rpriceamountTotal">&nbsp;</th><input type="hidden" id="rpriceamountTotals" name="rpriceamountTotals" value="0.00" />
					    	<c:if test="${systemParameterPo.fspstealtheffective==1||systemParameterPo.fspstealtheffective==2}">
							<TH scope=col id="xiaoqis"></TH>
							<TH scope=col id="picis"></TH>	
							</c:if>
					    	<th scope=col>&nbsp;</th>
					    	<th scope=col>&nbsp;</th>
				   		</tr>
				   	</TABLE>
				   	<%-- 附加费 --%>
                    <table width="100%" border="0" cellpadding="1" cellspacing="1" class="privateTable privateBorder">  
		                    <TR class=table_title align=middle>
		                    <TH scope=col width="13%" height="26" colspan="8">附加费</TH>
		                    </TR>
                              <tr>
                               <td width="16%" class="table_body">附加费用</td>
                                <td width="15%"  class="table_none">
								<select id="additionalCosts" name="additionalCosts">
								  <option>---请选择---</option>
								  <s:iterator value="additionalCostsList">
								  <option value="${facid},${facamount}">${facname}</option>
								  </s:iterator>
								</select></td>
                                <td class="table_none"><img name="button22332" src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onclick="addCosts(this)"></td>
	                              <td width="16%" height="26" bgcolor="#CADEE8" class="Privateborder">附加费名称</td>
	                              <td width="12%" bgcolor="#CADEE8" class="Privateborder">金额</td>
	                              <td width="10%" bgcolor="#CADEE8" class="Privateborder">数量</td>
	                              <td width="10%" bgcolor="#CADEE8" class="Privateborder">合计</td>
	                              <td width="8%" bgcolor="#CADEE8" class="Privateborder">删除</td>
                              </tr>
                             	<tr style="display:none" id="copyrowCosts" trfjf=trfjf >
                             	<td ></td>
                             	<td ></td>
                             	<td ></td>
                              	<td class="table_none"><span id="costs"></span><input type="hidden" name="additionalCostsPo.facname">
                              	<input type="hidden" name="additionalCDetailPo.sseadditionalid"><BR></td>
                              	<td class="table_none"><span id="costsMoney"></span><input class="fjfy" type="hidden" name="additionalCostsPo.facamount"><BR></td>
                              	<td class="table_none"><input type="text" size="8" class="text_input60 number" id="0" maxlength="2" name="additionalCDetailPo.ssenumber" onblur="addCosts(this)" validate=""><BR></td>
                              	<td class="table_none"><span id="amountMoney"></span><input class="fjfya" type="hidden" id="amountMoney" name="amountMoney"></td>
                              	<td class="table_none"><div align="center">
                                 <img src="${ctx }/img/newbtn/delete_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/delete_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/delete_0.png');" btn=btn title='删除' name="button22432" onclick="deleteItem(this);deleteVar2(this)">
                              </div></td>
                            </tr>
                     </table>
                     <TABLE width="100%" border=0 align=center cellpadding=0 cellspacing=1>
        <tr>
        	<td class="qtCenterLine">
				<TABLE width="90%" align="center" cellpadding=0 cellspacing=1 class="privateTable privateBorder" id="jktable">
				  <tr style="display: block;" id="" leixing=leixing >
				    <td height="26" width="10%" class="table_body" align="center">实缴金额：</td>
				    <td width="30%" class="table_none">    	
						<input type="text" class="text_input100" style="border: none;font-family: 黑体;font-size: 14;background: " return=1 id="salseValue" name="salseValue" value="${salesBasicPos[0].ssesbpsalsvalue }" readonly="readonly" />
						<input type="hidden" id="salseID" name="salseID" value="${salesBasicPos[0].ssesbsalesid }" readonly="readonly" />
				    </td>
				    <td width="10%" class="table_body" align="center">缴费金额：</td>
				    <td width="50%" class="table_none" colspan="5">
				    	<input type="text" value="0.00" style="border: none;font-family: 黑体;font-size: 14;background: " readonly="readonly" class="text_input100" id="jf"/>&nbsp;&nbsp;				    	
				  	</td>
				  </tr>
				  </table>
			<TABLE width="90%" align="center" cellpadding=0 cellspacing=1 class="privateTable privateBorder" id="jktable">
			<c:if test="${fn:contains(systemParameterPo.fspcollecttype,'1')}">	  
				  <tr style="display: none;" id="trxj" leixing=leixing>
				  	<td height="26" class="table_body" align="center" width="10%">现金：</td>
				  	<td class="table_none" width="30%">
					<input type="text" class="text_input100" xjv=xjv onblur="$(this).val($.trim($(this).val()));jfSum();" id="xjv" name="xjv" value="0.00" leixing=leixing maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '填写的金额不正确！'}]"/>
					</td>
					<td class="table_body" align="center" width="10%">
					<img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title='删除' onClick="xjguanbi()" >
					</td>
					<td class="table_none">&nbsp;&nbsp;</td>
				  </tr>
				  <tr style="display: block;" id="xjkaiqi" leixing=leixing height="26">
				    <td class="table_body" align="center" width="10%">
				    	<img src="${ctx }/img/newbtn/btn_xianjin_0.png" btn=btn xjv=xjv type='button' title='现金' onClick="xjkaiqi()" >
				    </td>
					<td class="table_none" colspan="3">&nbsp;&nbsp;</td>
				  </tr>
			</c:if>	  

			<c:if test="${fn:contains(systemParameterPo.fspcollecttype,'3')}">	
				  <tr style="display: none;" id="yhktr" leixing=leixing height="26">
				    <td class="table_body" align="center"  width="10%">银行卡：</td>
				  	<td class="table_none" width="30%">
                    <select id="yhkt" name="yhkt">
                            <option value=""  >----请选择----</option>
	                        <c:forEach var="po" items="${bankPos}" varStatus="idxStatus">
						 		<option value="${po.bbnumber}">${po.bbname}</option>
							</c:forEach>
					</select>
                    <input type="text" class="text_input100"  onblur="$(this).val($.trim($(this).val()));jfSum();" yhkv=yhkv id="yhkv" name="yhkv" leixing=leixing maxlength="10" value="0" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '填写的金额不正确！'}]"/>
					</td>
					<td class="table_body" align="center" width="10%">
						<div id="yhkdelete"><img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title='删除' onClick="yhkguanbi()"></div><div id="yhknbsp" style="display: none;">&nbsp;</div> 
					</td>
					<td class="table_none" align="center">
					<img src="${ctx }/img/newbtn/btn_zengjia_0.png" btn=btn title='增加' onClick="addRowY('jktable','','yhktr')" >
					</td>
				  </tr>
				  
				  <tr style="display: block;" id="yhkkaiqi" leixing=leixing height="26">
				    <td class="table_body" align="center">
				    	<img src="${ctx }/img/newbtn/btn_yinhangka_0.png" btn=btn title='银行卡' onClick="yhkkaiqi()" >
				    </td>
					<td class="table_none" colspan="3">&nbsp;&nbsp;</td>
				  </tr>
			</c:if>
						<c:if test="${fn:contains(systemParameterPo.fspcollecttype,'2') && not empty(systemParameterPo.fspexchangeintegral) && systemParameterPo.fspexchangeintegral != '' }">
				  <tr style="display: none;" id="dhjf" leixing=leixing height="26">
				    <td class="table_body" align="center"  width="10%">积分：</td>
				  	<td class="table_none"  width="30%">
					<input type="text" class="text_input100" jfv=jfv id="dhjf2" name="jfv" onblur="$(this).val($.trim($(this).val()));jfcheck(this);jfSum();" maxlength="10" value="0" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '填写的积分不正确！'}]"/>
					<input type="hidden" id="jfdhv" name="jfdhv" leixing=leixing value="0"/>
					<font color="red">会员当前积分为：${customerInfoPo.smeciintegral }</font>
					</td>
					<td class="table_body" align="center" width="10%">
					<img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title='删除' onClick="dhjfguanbi()" >
					</td>
					<td class="table_none"><font color="red">1积分=${systemParameterPo.fspexchangeintegral}元现金</font></td>
				  </tr>
				  
				  <tr style="display: block;" id="dhjfkaiqi" leixing=leixing height="26">
				    <td class="table_body" align="center">
				    	<img src="${ctx }/img/newbtn/btn_jifen_0.png" btn=btn title='积分' onClick="dhjfkaiqi()" >
				    </td>
					<td class="table_none" colspan="3">&nbsp;&nbsp;</td>
				  </tr>
			</c:if>
			<c:if test="${fn:contains(systemParameterPo.fspcollecttype,'4')}">		  
				  <tr style="display: none;" id="czktr" leixing=leixing height="26">
				  	<td class="table_body" align="center"  width="10%">储值卡：</td>
				  	<td class="table_none" width="30%">
				  	<input type="hidden" style="border: none;font-family: 黑体;font-size: 14;background: ;text-align:center;" readonly="readonly" class="text_input100" czkid="czkid" name="czkid" value="0"/>&nbsp;&nbsp;<input type="hidden" czkye=czkye name="czkye"/>
					<input type="text" class="text_input100" czkv=czkv onclick="czkOpen(this)" id="czkv" name="czkv" readonly="readonly" leixing=leixing onblur="$(this).val($.trim($(this).val()));jfSum();"/>
					</td>
					<td class="table_body" align="center" width="10%">
					<div id="czkdelete"><img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title='删除' onClick="czkguanbi()" ></div><div id="czknbsp" style="display: none;">&nbsp;</div>
					</td>
					<td class="table_none" align="center">
					<img src="${ctx }/img/newbtn/btn_zengjia_0.png" btn=btn title='增加' onClick="addRow1('jktable','','czktr')" >
					</td>
				  </tr>
				  
				  <tr style="display: block;" id="czkkaiqi" leixing=leixing height="26">
				  	<td class="table_body" align="center">
				    <img src="${ctx }/img/newbtn/btn_chuzhika_0.png" btn=btn title='储值卡' onClick="czkkaiqi(this)" >
				    </td>
					<td class="table_none" colspan="3">&nbsp;&nbsp;</td>
				  </tr>
			</c:if>	 
			<c:if test="${fn:contains(systemParameterPo.fspcollecttype,'6')}">	
				  <tr style="display: none;" id="qttr" leixing=leixing height="26">
				    <td class="table_body" align="center"  width="10%">其他：</td>
				  	<td class="table_none" width="30%">
                    <select id="qtt" name="qtt">
                            <option value=""  >----请选择----</option>
	                        <c:forEach var="po" items="${otherbankPos}" varStatus="idxStatus">
						 		<option value="${po.bbnumber}">${po.bbname}</option>
							</c:forEach>
					</select>
                    <input type="text" class="text_input100"  onblur="$(this).val($.trim($(this).val()));jfSum();" qtv=qtv id="qtv" name="qtv" leixing=leixing maxlength="10" value="0" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '填写的金额不正确！'}]"/>
					</td>
					<td class="table_body" align="center" width="10%">
						<div id="qtdelete"><img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title='删除' onClick="qtguanbi()"></div><div id="qtnbsp" style="display: none;">&nbsp;</div> 
					</td>
					<td class="table_none" align="center">
					<img src="${ctx }/img/newbtn/btn_zengjia_0.png" btn=btn title='增加' onClick="addRowqt('jktable','','qttr')" >
					</td>
				  </tr>
				  
				  <tr style="display: block;" id="qtkaiqi" leixing=leixing height="26">
				    <td class="table_body" align="center">
				    	<img src="${ctx }/img/newbtn/btn_qita_0.png" btn=btn  title='其他' onClick="qtkaiqi()" >
				    </td>
					<td class="table_none" colspan="3">&nbsp;&nbsp;</td>
				  </tr>
			</c:if> 
                        <input type="hidden" name="content" id="content" value="${content}">
				</table>
		</td></tr>
</table>
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
					   <TR>
						  <TD align="center">
						  <img  id="submitButton" src="${ctx}/img/newbtn/btn_refund_0.png" btn=btn  title='退款' onclick="save();">
						  </TD>
                        </TR>                     
                    </TABLE>
            
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
</body>
<script type="text/javascript">

function csan(obj,sta){
	eval("obj.style.display=\""+sta+"\"");
}

</script>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>