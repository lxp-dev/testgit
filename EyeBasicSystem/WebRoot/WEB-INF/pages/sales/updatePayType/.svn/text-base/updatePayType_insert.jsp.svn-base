<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
	<TITLE>FrameWork</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    </HEAD>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
   		});
		xjkaiqi();
		$("#xjv").select();
		$("#xjv").focus();

		$('input[leixing=leixing]').each(function (){
    		if($(this).val() == ''){
    			$(this).val(parseFloat(0).toFixed(2)); 
    		}
    	});
    	$('#zl').hide();
    	$('#zl').val(parseFloat('-'+$('#salseValue').val()).toFixed(2));
		$('#jf').val(parseFloat(0).toFixed(2));
	});
	/**
	 *详情
	 */
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDetailsCustomerInfo.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDetailsCustomerInfo.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员详细】";
	}
	
    function setCustomer(memberid){
		document.getElementById('smecimemberid').value = memberid;
		$("img").removeAttr("onclick");
		guitarMangermentForm.action = "selGuitarManagement.action";
		guitarMangermentForm.submit()
	}
	
	/**
	 *回车事件
	 */
	function selectCustomer(){
		if(event.keyCode==13){
		var salesId=document.getElementById('fmmsalesid').value;
			if(memberId=='' && salesId==''){
				return false;
			}
			$("img").removeAttr("onclick");
			guitarMangermentForm.action = "selGuitarManagement.action";
			guitarMangermentForm.submit();
		}
   }
   
   function setSalesValue(json){
   		$('#salseID').val(json.ssesbsalesid );// salesID
   		$('#priceSum').val(json.ssesbpricesum );// 原价合计
   		$('#discountNum').val(json.ssesbdiscountnum );// 折扣金额
   		$('#salseValue').val(json.ssesbsalesvalue );// 应收金额
   		$('#psalsvalue').val(json.ssesbpsalsvalue );// 实缴金额
   		$('#ssesborderstype').val(json.ssesborderstype);//订单类型
   		$('#ssesbarrearsvalue').val(json.ssesbarrearsvalue);//欠款
   		$('#checkoutFlag').val(json.ssesbcheckoutflag);
   		document.getElementById('jfButton').disabled = false;
   }
    
   function validate(){
   		var sum = 0;
    	$('input[leixing=leixing]').each(function (){
    		sum = parseFloat(accAdd($(this).val(),sum)).toFixed(2);	
    	});
    	if(parseFloat($('#salseValue').val())!=sum){
    		alert("缴费金额不足或过大!");
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
		<c:if test="${fn:contains(systemParameterPo.fspcollecttype,'7')}">	
		if(document.getElementById('djqtr').style.display != 'none'){
	        $('input[name=djqv]').each(function (){
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

		if(accAdd(yhkv,czkv)>salseValue){
			alert("刷卡金额不足或过大!！");
			return;
		}
   
   		if($('#salseID').val() == ''){
   			return;
   		}
   		
		if(!confirm('请确认提交！')){
			return;
		}

		if(checkForm(guitarMangermentForm)){ 
			$("img").removeAttr("onclick");	
			gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
			guitarMangermentForm.action = 'insertUpdatePayType.action';
		    guitarMangermentForm.submit();
		}
	 
	}
	
	function validateSales(obj){
		if(obj.value.trim() == ''){
			$('#zl').val('0.00');
			return ;
		}
		
		if(!isNaN(obj.value.trim())){
			$('#zl').val((obj.value.trim()-$('#salseValue').val().trim()).toFixed(2));
		}
	}
	
	function validateSalesFocus(obj){
		if(obj.value.trim() == ''){
			$('#zl').val('0.00');
			return ;
		}
		if (obj.value.trim() == '' || !(/^[0-9]*([.][0-9]{1,2})?$/.test(obj.value.trim()))){
			alert('数字格式输入错误！');
			obj.select();
			return false;
		}
		obj.value = parseFloat(obj.value).toFixed(2);
		$('#zl').val((obj.value.trim()-$('#salseValue').val().trim()).toFixed(2));
	}
	
	//方法暂留	
	function changeCash(obj){
		var type = obj.value;
		var xjv  =  $('input[name=xjv]').val();
		var yhkv = $('input[name=yhkv]').val();
		var czkv = $('input[name=czkv]').val();
		var trdisplay = $('tr[leixing=leixing]');
		var i = 0;
		$('input[leixing=leixing]').each(function (){
			if($(this).val()!=''||$(this).val()>0){
				trdisplay.get(i).style.display="block";
			}else{
				trdisplay.get(i).style.display="none";
			}
			i=i+1;
		});	
		
		if(type == '1'){	
			$('tr[id=xj]').get(0).style.display="block";
		}else if(type == '2'){
			$('tr[id=yhk]').get(0).style.display="block";	
		}else if(type == '3'){
			$('tr[id=czk]').get(0).style.display="block";	
		}
	}

	function winPopUpS(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectInTransitDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectInTransitDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【配镜单详细】";
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
    		$('#zl').val(accAdd(sum,'-'+$('#salseValue').val()).toFixed(2));
    	});
    	
    	if(checknum == "1"){
    		return;
    	}
    	$('#jf').val(sum);
    	if(accAdd(sum,'-'+$('#salseValue').val()).toFixed(2) > 0){
    		$('#zl').show();
    	}else{
    		$('#zl').hide();
    	}
    	$('#zl').val(accAdd(sum,'-'+$('#salseValue').val()).toFixed(2));
    }
    
    function czkOpen(obj){
    	var indexid = $("input[czkv=czkv]").index(obj);
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initCzkOpen2.action?indexid="+indexid,500,200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initCzkOpen2.action?indexid="+indexid,500,200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【储值卡查询】";
    }
    function djqOpen(obj){
    	var indexid = $("input[djqv=djqv]").index(obj);
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDjqOpen5.action?indexid="+indexid,500,200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDjqOpen5.action?indexid="+indexid,500,200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【代金券查询】";
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
	
	function addRow(tableName,args,trid) {
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
		
		htmltd3.innerHTML = "<img src=\"${ctx }/img/newbtn/btn_delete_0.png\" onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" btn=btn style=\"cursor: hand;\" title='删除' onClick=\"javascript:del(this,'yhk')\">";
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
		htmltd2.innerHTML = " <input type=\"text\" style=\"border: none;font-family: 黑体;font-size: 14;background: ;text-align:center;\" readonly=\"readonly\" class=\"text_input100\" czkid=czkid name=\"czkid\" value=\"0\" />&nbsp;&nbsp; <input type=\"text\" czkv=czkv class=\"text_input100\" onclick=\"czkOpen(this)\" leixing=\"leixing\" name=\"czkv\" readonly=\"readonly\" onblur=\"jfSum()\" value=\"0.00\"/><input type=\"hidden\" czkye=czkye  name=\"czkye\"/>";
		htmltd2.className = "table_none";
		
		htmltd3.innerHTML = "<img src=\"${ctx }/img/newbtn/btn_delete_0.png\" onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" btn=btn style=\"cursor: hand;\" title='删除' onClick=\"javascript:del(this,'czk')\">";
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
		
		htmltd3.innerHTML = "<img src=\"${ctx }/img/newbtn/btn_delete_0.png\" onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" btn=btn style=\"cursor: hand;\" title='删除' onClick=\"javascript:del(this,'djq')\">";
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
		
		htmltd3.innerHTML = "<img src=\"${ctx }/img/newbtn/btn_delete_0.png\" onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" btn=btn style=\"cursor: hand;\" title='删除' onClick=\"javascript:del(this,'qt')\">";
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
    function del(obj,type){
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

    function updatesalesvalue(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdateSalesValueOpen.action?salesid="+id+"&moduleID="+'${requestScope.moduleID}',500,200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initUpdateSalesValueOpen.action?salesid="+id+"&moduleID="+'${requestScope.moduleID}',500,200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【储值卡查询】";
    }
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="guitarMangermentForm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">

<input type="hidden" id="ssesborderstype" name="ssesborderstype" value="${requestScope.ssesborderstype }">
<input type="hidden" id="fpddiscount" name="fpddiscount">
<input type="hidden" name="autopay" value="${autopay }"/>
<input type="hidden" name="sseslpaymenttype" value="${sseslpaymenttype }"/>
<input type="hidden" name="return" id="return" value="">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV style="width: 99%">
                  	<fieldset>
						<legend>顾客资料</legend>
						<TABLE width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
					      <TR>
                          <TD width="15%" height="26" class="table_body">顾客卡号</TD>
                          <TD width="26%" class="table_none" style="vertical-align: middle;"><li class="horizontal_onlyRight">${customerInfoPo.smecimemberid }<input type="hidden" id="smecimemberid" name="smecimemberid" class="text_input100" 
					                	value="${customerInfoPo.smecimemberid }" onblur="selectCustomer()" ></li>&nbsp;&nbsp;
					            <li class="horizontal_onlyRight"><img name="button32" btn=btn src="${ctx }/img/newbtn/btn_details_0.png" title='详细 ' onClick="javascript:details('${customerInfoPo.smecicustomerid }');" ${empty(customerInfoPo.smecicustomerid) ? 'disabled="disabled"': ''  }></li>
	                         
					      </TD>
                          <TD width="15%" height="26" class="table_body">顾客姓名</TD>
                          <TD width="26%" class="table_none">&nbsp;${customerInfoPo.smeciname }<input class="text_input60" readOnly="readOnly" type="hidden" value="${customerInfoPo.smeciname }">
						  </TD>
                        </TR> 
					    </table>
					 </fieldset>
                    <TABLE id=ctl00_PageBody_PostButton  cellSpacing=0 cellPadding=0 width="100%" border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
							<div align="right">
							  &nbsp;
							</div>
						  </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <c:if test="${not empty(salesBasicPos)}"> 
                    <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle >
                          <TH height="26" scope=col>销售单号</TH>
                          <TH width="9%" scope=col>缴费类型</TH>
                          <TH width="8%" scope=col>销售人员</TH>
                          <TH width="9%" scope=col>原价合计</TH>
                          <TH width="7%" scope=col>折扣金额</TH>
                          <TH width="7%" scope=col>抹零金额</TH>
                          <TH width="9%" scope=col>应收金额</TH>
                          <TH width="9%" scope=col>缴费金额</TH>
                          <TH width="16%" scope=col>缴费日期</TH>
                        </TR>
                        <c:forEach var="po" items="${salesBasicPos}">
                        <TR class="row" height="28" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD><a href="#" onclick="javascript:winPopUpS('${po.ssesbsalesid }')">${po.ssesbsalesid }</a>
                          </TD><input type="hidden" name="checkoutFlag" value="${po.ssesbcheckoutflag }"/>
                          <input type="hidden" id="orderType" name="orderType" value="${po.ssesborderstype}"/>
                          <input type="hidden" id="salesid" name="salesid" value="${po.ssesbsalesid}"/>
                          <TD>${po.sseslpaymenttypename }</TD>
                          <TD>${po.ssesbsalerName }</TD>
                          <TD>${po.ssesbpricesum }</TD>
                          <TD>${po.ssesbdiscountnum }</TD>
                          <TD>${po.ssesbrenums }</TD>
                          <TD>${po.ssesbsalesvalue }<input type="hidden" id="salesValue" name="salesValue" value="${po.ssesbsalesvalue}"/></TD>
                          <TD>${po.sseslprice }</TD>
                          <TD>${po.ssesldatetime }</TD>
                        </TR>
                        </c:forEach>
                      </TBODY>
                    </TABLE>
                    </c:if>
                    <br/>
                    <div id="queryInfo" align="center">
	<TABLE width="100%" border=0 align=center cellpadding=0 cellspacing=1>
        <tr>
        	<td class="qtCenterLine">
				<TABLE width="90%" align="center" cellpadding=0 cellspacing=1 class="privateTable privateBorder" id="jktable">
				  <tr style="display: block;" id="" leixing=leixing >
				    <td height="26" width="10%" class="table_body" align="center">实缴金额：</td>
				    <td width="30%" class="table_none">    	
						<input type="text" class="text_input100" style="border: none;font-family: 黑体;font-size: 14;background: " id="salseValue" name="salseValue" value="${salesBasicPos[0].sseslprice }" readonly="readonly" />
						<input type="hidden" id="salseID" name="salseID" value="${salesBasicPos[0].ssesbsalesid }" readonly="readonly" />
				    </td>
				    <td width="10%" class="table_body" align="center">缴费金额：</td>
				    <td width="50%" class="table_none">
				    	<input type="text" style="border: none;font-family: 黑体;font-size: 14;background: " readonly="readonly" class="text_input100" id="jf"/>&nbsp;&nbsp;
				    	<input type="hidden" style="border: none;font-family: 黑体;font-size: 14;background: " class="text_input100" id="zl" name="zl" style="color:red" value="" readonly="readonly" />
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
					<img src="${ctx }/img/newbtn/btn_zengjia_0.png" btn=btn  title='增加' onClick="addRow('jktable','','yhktr')" >
					</td>
				  </tr>
				  
				  <tr style="display: block;" id="yhkkaiqi" leixing=leixing height="26">
				    <td class="table_body" align="center">
				    	<img src="${ctx }/img/newbtn/btn_yinhangka_0.png" btn=btn  title='银行卡' onClick="yhkkaiqi()" >
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
					
					</td>
					<td class="table_body" align="center" width="10%">
					<img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title='删除' onClick="dhjfguanbi()" >
					</td>
					<td class="table_none"><font color="red">1积分=${systemParameterPo.fspexchangeintegral}元现金</font></td>
				  </tr>
				  
				  <tr style="display: block;" id="dhjfkaiqi" leixing=leixing height="26">
				    <td class="table_body" align="center">
				    	<img src="${ctx }/img/newbtn/btn_jifen_0.png" btn=btn  title='积分' onClick="dhjfkaiqi()" >
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
					<img src="${ctx }/img/newbtn/btn_zengjia_0.png" btn=btn  title='增加' onClick="addRow1('jktable','','czktr')" >
					</td>
				  </tr>
				  
				  <tr style="display: block;" id="czkkaiqi" leixing=leixing height="26">
				  	<td class="table_body" align="center">
				    <img src="${ctx }/img/newbtn/btn_chuzhika_0.png" btn=btn  title='储值卡' onClick="czkkaiqi(this)" >
				    </td>
					<td class="table_none" colspan="3">&nbsp;&nbsp;</td>
				  </tr>
			</c:if>	 
			
			<c:if test="${fn:contains(systemParameterPo.fspcollecttype,'7')}">		  
				  <tr style="display: none;" id="djqtr" leixing=leixing height="26">
				  	<td class="table_body" align="center"  width="10%">代金券：</td>
				  	<td class="table_none" width="30%">
				  	<input type="text" style="border: none;font-family: 黑体;font-size: 14;background: ;text-align:center;" readonly="readonly" class="text_input100" djqid="djqid" name="djqid" />&nbsp;&nbsp;<input type="hidden" djqye=djqye name="djqye"/>
					<input type="text" class="text_input100" djqv=djqv onclick="djqOpen(this)" id="djqv" name="djqv" readonly="readonly" leixing=leixing onblur="$(this).val($.trim($(this).val()));jfSum();"/>
					</td>
					<td class="table_body" align="center" width="10%">
					<div id="djqdelete"><img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title='删除' onClick="djqguanbi()" ></div><div id="djqnbsp" style="display: none;">&nbsp;</div>
					</td>
					<td class="table_none" align="center">
					<img src="${ctx }/img/newbtn/btn_zengjia_0.png" btn=btn  title='增加' onClick="addRowdjq('jktable','','djqtr')" >
					</td>
				  </tr>
				  
				  <tr style="display: block;" id="djqkaiqi" leixing=leixing height="26">
				  	<td class="table_body" align="center">
				    <img src="${ctx }/img/newbtn/btn_daijinquan_0.png" btn=btn  title='代金券' onClick="djqkaiqi()" >
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
					<img src="${ctx }/img/newbtn/btn_zengjia_0.png" btn=btn  title='增加' onClick="addRowqt('jktable','','qttr')" >
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
</div>

<div id="queryInfo" align="center">
	<table class="queryInfoTable">
                         <c:if test="${first==1}" >   
                            
								<c:choose>
									<c:when test="${second==1}">
										<input type="hidden" id="isSend" name="isSend" value="1" >
										
									</c:when>
									<c:otherwise>
										<input type="hidden" id="isSend" name="isSend" value="0" >
									</c:otherwise>
								</c:choose>
                         </c:if>  
                         
		<tr>
			<td align="center" height="26">
				
				<img src="${ctx }/img/newbtn/btn_pay_0.png" btn=btn id="jfButton" name="jfButton" title='缴费' onClick="validate();">
			</td>
			<td>
				<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
			</td>
		</tr>
		</table>
</div>


                  </DIV>
                </DIV>
                  <!--ݿEnd--></TD> 
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
