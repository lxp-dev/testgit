<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FrameTitle</title>
</head>

<script>
	function trim(str){ //删除左右两端的空格
　　 	return str.replace(/(^\s*)|(\s*$)/g, "");
　　 }

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
		$('#jf').val(parseFloat(0).toFixed(2));
		
	});
	
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
    
	var json={${arg0}};
	$(document).ready(function(){
		$('#ssesbarrearsvalue').text(json.ssesbarrearsvalue);

		$('#ssesbsalesid').text(json.ssesbsalesid);
		$('#ssesbsalesid').bind('click',function(){
			winPopUpS(json.ssesbsalesid);
	    });			
	    
		$('#ssesbpersonName').text(json.ssesbpersonName);
		$('#ssesbsalesdatetime').text(json.ssesbsalesdatetime);
		$('#ssesbpricesum').text(json.ssesbpricesum);
		$('#ssesbsalesvalue').text(json.ssesbsalesvalue);
		$('#ssesbdiscountnum').text(json.ssesbdiscountnum);
		$('#ssesbpsalsvalue').text(json.ssesbpsalsvalue);
		$('#ssesbrenums').text(json.ssesbrenums);
		$('input[id=ssesbjfamount]').val(json.ssesbjfamount);
		$('span[id=ssesbjfamount]').text(json.ssesbjfamount);
		$('input[id=orderType]').val(json.ssesborderstype);
		$('input[id=salesValue]').val(json.ssesbsalesvalue);
		
		
		$('input[name=salseValue]').val(parseFloat(Math.abs(json.ssesbarrearsvalue)).toFixed(2));
		if('${systemParameterPo.fspxianjindefault}' == '1'){
			$('input[name=xjv]').val(parseFloat(Math.abs(json.ssesbarrearsvalue)).toFixed(2));
		}
		
		$('input[leixing=leixing]').each(function (){
    		if($(this).val() == ''){
    			$(this).val('0.00');
    		}
    	});
    	
		if(parseFloat('${allsalesvalues}') + parseFloat('${salesBasicPos[0].ssesbpsalsvalue }') < parseFloat('${systemParameterPo.fspminintegral}') || parseFloat($("#ssesbjfamount").text()) < parseFloat('${systemParameterPo.fspminintegral}')){
			$("tr[id=dhjf]").hide();
			$("tr[id=dhjfkaiqi]").hide();
		}
	});
	
	function arrearsPay(){
		
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
		
		if(accAdd(yhkv,czkv)>$("span[id=ssesbarrearsvalue]").text()){
			alert("刷卡金额不得大于应收金额！");
			return;
		}
		if(!confirm('你确定补齐欠款吗?')){
			return;
		}
		if(checkForm(arrearsForm)){ 
			$("img").removeAttr("onclick");
			gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
			arrearsForm.action="arrearsPay.action?salesID="+json.ssesbsalesid;
			arrearsForm.submit();
		}
	}

	function jfSum(){
    	var sum = 0;
    	$('input[leixing=leixing]').each(function (){
    		if (parseFloat($(this).val())>=0){
				
			}else{
				alert('数字格式输入错误！');
				$(this).select();
				return false;
			}
			
    		if($(this).val() == ''){
    			$(this).val('0.00');
    		}
    		sum = accAdd($(this).val(),sum).toFixed(2);
    	});	

    	$('#jf').val(sum);
    }
    
    function czkOpen(obj){
    	var indexid = $("input[czkv=czkv]").index(obj);
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initCzkOpen.action?indexid="+indexid,500,240,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initCzkOpen.action?indexid="+indexid,500,240,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【储值卡查询】";
    }
    function djqOpen(obj){
    	var indexid = $("input[djqv=djqv]").index(obj);
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDjqOpen.action?indexid="+indexid,500,200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDjqOpen.action?indexid="+indexid,500,200,topRows,topCols,returnRefresh(true),false);
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
		document.getElementById('trxj').style.display = "";
		document.getElementById('xjkaiqi').style.display = "none";
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
			parent.insertBefore(newElement,targetElement.nextSibling);
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
							" <input type=\"text\" class=\"text_input100\"  onblur=\"$(this).val($.trim($(this).val()));jfSum();\"  id=\"yhkv\" name=\"yhkv\" value=\"0\" leixing=\"leixing\" maxlength=\"10\" validate=\"[{\'Type\' : Type.String, \'Formula\' : Formula.FloatORNULL, \'Message\' : \'填写的金额不正确！\'}]\"/>";
		htmltd2.className = "table_none";
		
		htmltd3.innerHTML = "<img src=\"${ctx }/img/newbtn/btn_delete_0.png\" onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" btn=btn title='删除' onClick=\"javascript:del(this,'yhk')\">";
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
		htmltd2.innerHTML = " <input type=\"hidden\" style=\"border: none;font-family: 黑体;font-size: 14;background: ;text-align:center;\" readonly=\"readonly\" class=\"text_input100\" czkid=czkid value=\"\" name=\"czkid\"/>&nbsp;&nbsp; <input type=\"text\" value=\"0.00\" czkv=czkv class=\"text_input100\" onclick=\"czkOpen(this)\" leixing=\"leixing\" name=\"czkv\"/><input type=\"hidden\" value=\"0.00\" czkye=czkye  name=\"czkye\"/>";
		htmltd2.className = "table_none";
		
		htmltd3.innerHTML = "<img src=\"${ctx }/img/newbtn/btn_delete_0.png\" onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" btn=btn title='删除' onClick=\"javascript:del(this,'czk')\">";
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
    
    function changeYcredit(obj){
    	var ycredit = $(obj).parent().parent().find("input[id=ycredit]").val().trim();
    	if(isNaN($(obj).val().trim())&&$(obj).val().trim()){
    		alert("抵用积分应为数字！");
    		$(obj).val("");
    		$(obj).focus();
    		return;
    	}
    	
    	var r = /^[0-9]*[1-9][0-9]*$/;
    	if(!r.test($(obj).val().trim())&&$(obj).val().trim()&&$(obj).val().trim()!=0){
    		alert("抵用积分应为非负整数!");
    		$(obj).val("");
    		$(obj).focus();
    		return;
    	}
    	
    	if(isNaN($(obj).val().trim())&&$(obj).val().trim()){
    		alert("抵用积分应为数字！");
    		$(obj).val("");
    		$(obj).focus();
    		return;
    	}
    	
    	if(parseFloat($(obj).val()) > ycredit){
    		alert("抵用积分不能大于累计积分！");
    		$(obj).val("");
    		$(obj).focus();
    		return;
    	}
    	
    	//当前行积分计算
    	if($(obj).val().trim()){
    		$(obj).parent().parent().find("td[id=ycredit]").text(parseFloat(ycredit) - parseFloat($(obj).val().trim()));
    	}else{
    		$(obj).parent().parent().find("td[id=ycredit]").text(parseFloat(ycredit));
    	}
    	
    	//积分合计计算
    	var credittotal = 0;
    	$("td[id=ycredit]").each(function(){
    		credittotal = credittotal + parseFloat($(this).text().trim());
    	});
    	$("span[id=ssesbjfamount]").text(credittotal);
    	$("input[id=ssesbjfamount]").val(credittotal);
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
							" <input type=\"text\" class=\"text_input100\" onblur=\"$(this).val($.trim($(this).val()));jfSum();\" id=\"qtv\" name=\"qtv\" leixing=\"leixing\" maxlength=\"10\" value=\"0\" validate=\"[{\'Type\' : Type.String, \'Formula\' : Formula.FloatORNULL, \'Message\' : \'填写的金额不正确！\'}]\"/>";
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
    
</script>
<body >
<form name="arrearsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="return" id="return" value="">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <tr height="20"><td></td></tr>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
                <TD style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top>
                <DIV id=tabContent__1>
                  <DIV>
                       <table width="100%" border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
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
                          <TH width="16%" height="30" scope=col>销售单号</TH>
                          <TH width="8%" scope=col>顾客姓名</TH>
                          <TH width="10%" scope=col>销售日期</TH>
                          <TH width="8%" scope=col>原价合计</TH>
                          <TH width="8%" scope=col>折扣金额</TH>
                          <TH width="8%" scope=col>抹零金额</TH>
                          <TH width="8%" scope=col>应收金额</TH>
                          <TH width="8%" scope=col>实缴金额</TH>
                          <TH width="8%" scope=col>欠费金额</TH>
                          <TH width="12%" scope=col>获取积分</TH>
                        </TR>
                        
                        <TR class="row" height="28" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD><span id="ssesbsalesid" title="单击查看配镜单信息"></span><input type="hidden" id="orderType" name="orderType" value=""/></TD>
                          <TD><span id="ssesbpersonName"></span><input type="hidden" id="smecimemberid" name="smecimemberid" value="${customerInfoPo.smecimemberid}"/>
                          	<input class="text_input60" name="cname" type="hidden" value="${customerInfoPo.smeciname }">
							<input class="text_input60" name="cphone" type="hidden" value="${customerInfoPo.smeciphone }">
                          </TD>
                          <td><span id="ssesbsalesdatetime"></span></td>
                          <TD><span id="ssesbpricesum"></span></TD>
                          <TD><span id="ssesbdiscountnum"></span></TD>
                          <TD><span id="ssesbrenums"></span></TD>
                          <TD><span id="ssesbsalesvalue"></span><input type="hidden" id="salesValue" name="salesValue" value=""/></TD>
                          <TD><span id="ssesbpsalsvalue"></span></TD>
                          <TD><font color="red"><span id="ssesbarrearsvalue"></span></font></TD>
                          <c:if test="${systemParameterPo.fspupdatecredittype ne '2'}">
	                          <TD><span id="ssesbjfamount"></span>&nbsp;<input type="hidden" class="text_input100" id="ssesbjfamount" name="ssesbjfamount" value="${po.ssesbjfamount }" onKeyUp="value=value.replace(/[^\d\.]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="10"/></TD>
                          </c:if>
                          
                          <c:if test="${systemParameterPo.fspupdatecredittype eq '2'}">
	                          <TD><span id="ssesbjfamount"><fmt:formatNumber value="${empty(po.ssesbjfamount) ? 0: po.ssesbjfamount }" type="currency" pattern="0"/></span><input type="hidden" class="text_input100" id="ssesbjfamount" name="ssesbjfamount" value="${empty(po.ssesbjfamount) ? 0 : po.ssesbjfamount }" onKeyUp="value=value.replace(/[^\d\.]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="10"/></TD>
	                      </c:if>
                        </TR>
                      </TBODY>
                   </TABLE>    
			       <br/>
    <div id="queryInfo" align="center">		
	  <TABLE width="100%" border=0 align=center cellpadding=0 cellspacing=1>
        <tr>
        	<td class="qtCenterLine">
				<TABLE width="90%" align="center" cellpadding=0 cellspacing=1 class="privateTable privateBorder" id="jktable">
				  <tr style="display: block;" id="" leixing="leixing" height="26">
				  
				    <td width="12%" class="table_body" align="center">实缴金额：</td>
				    <td width="30%" class="table_none">    	
						<input type="text" class="text_input100" style="border: none;font-family: 黑体;font-size: 14;background: " id="salseValue" name="salseValue" value="${salesBasicPos[0].ssesbpsalsvalue }" readonly="readonly" />
						<input type="hidden" id="salseID" name="salseID" value="${salesBasicPos[0].ssesbsalesid }" readonly="readonly" />
				    </td>
				    <td width="12%" class="table_body" align="center">缴费金额：</td>
				    <td class="table_none" colspan="3">
				    	<input type="text" style="border: none;font-family: 黑体;font-size: 14;background: " readonly="readonly" class="text_input100" id="jf" value=""/>&nbsp;&nbsp;
				  	</td>
				  </tr>
				</TABLE>
			<TABLE width="90%" align="center" cellpadding=0 cellspacing=1 class="privateTable privateBorder" id="jktable">  
			<c:if test="${fn:contains(systemParameterPo.fspcollecttype,'1')}">	  	  
				  <tr style="display: none;" id="trxj" leixing="leixing" height="26">
				  	<td class="table_body" align="center" width="12%">现金：${salesBasicPos[0].ssesbpsalsvalue}</td>
				  	<td class="table_none" width="30%">
					<input type="text" class="text_input100" xjv=xjv value="${(systemParameterPo.fspxianjindefault eq '1') ? salesBasicPos[0].ssesbpsalsvalue : ''}" onblur="$(this).val($.trim($(this).val()));jfSum();"  id="xjv" name="xjv"  leixing="leixing" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '填写的金额不正确！'}]"/>
					</td>
					<td class="table_body" align="center" width="12%">
					<img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title='删除' onClick="xjguanbi()" >
					</td>
					<td class="table_none">&nbsp;&nbsp;</td>
				  </tr>
				  <tr style="display: block;" id="xjkaiqi" leixing="leixing" height="26">
				    <td class="table_body" align="center" width="10%">
				    	<img src="${ctx }/img/newbtn/btn_xianjin_0.png" btn=btn  xjv=xjv type='button' title='现金' onClick="xjkaiqi()" >
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
				  <tr style="display: none;" id="dhjf" leixing="leixing" height="26">
				  <td class="table_body" align="center" width="10%">积分：</td>
				  	<td class="table_none" width="30%">
					<input type="text" class="text_input100" jfv=jfv id="dhjf2" name="jfv" value="0" maxlength="10" onblur="$(this).val($.trim($(this).val()));jfcheck(this);jfSum();" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '填写的积分不正确！'}]"/>
					<input type="hidden" id="jfdhv" name="jfdhv" value="0" leixing="leixing"/>
					<font color="red">会员当前积分为：${customerInfoPo.smeciintegral }</font>
					</td>
					<td class="table_body" align="center" width="10%">
					<img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title='删除' onClick="dhjfguanbi()" >
					</td>
					<td class="table_none"><font color="red">1积分=${systemParameterPo.fspexchangeintegral}元现金</font></td>
				  </tr>
				  
				  <tr style="display: block;" id="dhjfkaiqi" leixing="leixing" height="26">
				    <td class="table_body" align="center" width="10%">
				    	<img src="${ctx }/img/newbtn/btn_jifen_0.png" btn=btn  title='积分' onClick="dhjfkaiqi()" >
				    </td>
					<td class="table_none" colspan="3">&nbsp;&nbsp;</td>
				  </tr>
			</c:if>
			<c:if test="${fn:contains(systemParameterPo.fspcollecttype,'4')}">		  
				  <tr style="display: none;" id="czktr" leixing="leixing" height="26">
				  	<td class="table_body" align="center" width="10%">储值卡：</td>
				  	<td class="table_none" width="30%">
				  	<input type="hidden" style="border: none;font-family: 黑体;font-size: 14;background: ;text-align:center;" readonly="readonly" class="text_input100" czkid="czkid" value="" name="czkid"/>&nbsp;&nbsp;<input type="hidden" value="0.00" czkye=czkye name="czkye"/>
					<input type="text" class="text_input100" czkv=czkv onclick="czkOpen(this)" id="czkv" name="czkv" onblur="$(this).val($.trim($(this).val()));jfSum();" 
					readonly="readonly" value="0.00" leixing="leixing"/>
					</td>
					<td class="table_body" align="center" width="10%">
					<div id="czkdelete"><img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title='删除' onClick="czkguanbi()" ></div><div id="czknbsp" style="display: none;">&nbsp;</div>
					</td>
					<td class="table_none" align="center">
					<img src="${ctx }/img/newbtn/btn_zengjia_0.png" btn=btn  title='增加' onClick="addRow1('jktable','','czktr')" >
					</td>
				  </tr>
				  
				  <tr style="display: block;" id="czkkaiqi" leixing="leixing" height="26">
				  	<td class="table_body" align="center" width="10%">
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
				</table>
		</td></tr>
</table>
</div>					
					<table width="99%"  border=0 align=center id="title1">
                        <TR>
                        	<TD width="100%" height="26" colspan="2" align="center" >
                        		<img name="button3223" src="${ctx }/img/newbtn/btn_pay_0.png" btn=btn id="saveButton" title='补齐欠款' onclick="arrearsPay()"/>
                        	</TD>
                        </TR>  
                    </TABLE>
					    
                                
                    </TABLE>
                    </tr> 
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