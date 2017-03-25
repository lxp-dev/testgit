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
		xjkaiqi();
	});

	function refundSales(){
		var ids = '';
		var goodtype = '';
		var count = 0;
        $('input[name=chk]').each(function (){
            if ($(this).attr('checked') == true){
                ids = ids + ',' + $(this).val();
                goodtype = goodtype + ',' + $(this).attr("goodtype");
                
                count = accAdd(count,1);
            }
        });
        
        if (count == 0){
            alert('请选择需要退款的商品!');
            return;
        }
        
        var goodssize = '${fn:length(goodsInfoList) }';
        
        if(count == goodssize){
        	alert("当前商品全部被勾选，请使用整单退款，该模块不支持此操作！");
        	return;
        }

        var sum = 0;
    	$('input[leixing=leixing]').each(function (){
    		sum = Number(accAdd($(this).val(),sum)).toFixed(2);	
    	});
    	
    	if(Number($('#salseValue').val()) != sum){
    		alert("退费金额与应收金额不等!");
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

		if(!confirm('请确认提交！')){
			return;
		}
        
		$("img").removeAttr("onclick");
		gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
		arrearsForm.action="partRefundSales.action?salesID="+'${ssesbsalesid}'+"&ids="+ids+"&goodtype="+goodtype;
		arrearsForm.submit();
	}

	function jfSum(){
    	var sum = 0;
    	var checknum = "";
    	$('input[leixing=leixing]').each(function (){
    		if($(this).val() == ''){
    			$(this).val('0.00');
    		}
    		if (isNaN($(this).val())){
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
    function clean(){
    	$('input[leixing=leixing]').each(function (){
    		$(this).val('0.00');
    	});
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
	
	function addRowY(tableName,args,trid) {
		document.getElementById('yhkdelete').style.display = "none";
		document.getElementById('yhknbsp').style.display = "";
		var txtName = document.getElementById(trid);
		var htmltr  = document.createElement("tr");
		var htmltd1 = document.createElement("td");
		var htmltd2 = document.createElement("td");
		var htmltd3 = document.createElement("td");
		var htmltd4 = document.createElement("td");
		
		htmltd1.innerHTML = "银行卡 ：";
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
    function addPrice(){
        var sum = 0;
		$("input[id=chk]").each(function (){
			if($(this).attr("checked")){
				sum = accAdd(sum,$(this).attr("price"));
			}
		});
		$("#salseValue").val(parseFloat(sum).toFixed(2));
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
    
    function checkTogether(type,obj){
    	if((type == '1' || type == '3') && ($('#ssesborderstype').val() == '1' || $('#ssesborderstype').val() == '2')){
    		$("input[id=chk][goodtype=1]").attr("checked",$(obj).attr("checked"));
    		$("input[id=chk][goodtype=3]").attr("checked",$(obj).attr("checked"));
    	}
    }
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="arrearsForm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID }">
<input type="hidden" id="salesid" name="salesid" value="${ssesbsalesid }">
<input type="hidden" id="psalsvalue" name="psalsvalue" value="${salesBasicPo.ssesbpsalsvalue }">
<input type="hidden" id="salesvalue" name="salesvalue" value="${salesBasicPo.ssesbsalesvalue }">
<input type="hidden" name="return" id="return" value="1">
<input type="hidden" name="ssesborderstype" id="ssesborderstype" value="${salesBasicPo.ssesborderstype }">
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
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
							<TD width="25%" class="table_none"><input type="hidden" name="checkoutFlag" value="${salesBasicPo.ssesbcheckoutflag }"/>
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
							<TD width="25%" class="table_none">${salesBasicPo.ssesbpsalsvalue}<input type="hidden" return=1 value="${salesBasicPo.ssesbpsalsvalue}"/>&nbsp;
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
					 <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
                <c:if test="${not empty(salesODPo.ssesbballglassod)&&not empty(salesOSPo.ssesbballglassos)}">     
                     <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
						  <TH width="10%" scope=col height="26">右眼(R)/左眼(L)</TH>						
						  <TH width="8%" scope=col>球镜</TH>
						  <TH width="8%" scope=col>柱镜</TH>
						  <TH width="8%" scope=col>轴向</TH>
						  <TH width="8%" scope=col>曲率</TH>
						  <TH width="8%" scope=col>直径</TH>
						  <TH width="8%" scope=col>隐形VA</TH>
						  </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD align="center" height="26">R</TD>
                          <TD height="26">${salesODPo.ssesbballglassod}</TD>
                          <TD height="26">${salesODPo.ssesbpostglassod}</TD>
                          <TD height="26">${salesODPo.ssesbaxesod}</TD>
                          <TD height="26">${salesODPo.ssesbeyecurvatureod1}</TD>
                          <TD height="26">${salesODPo.ssesbdiameterod}</TD>
                          <TD height="26">${salesODPo.ssesbclosevaod}</TD>
						</TR>
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD align="center" height="26">L</TD>
                          <TD height="26">${salesOSPo.ssesbballglassos}</TD>
                          <TD height="26">${salesOSPo.ssesbpostglassos}</TD>
                          <TD height="26">${salesOSPo.ssesbaxesos}</TD>
                          <TD height="26">${salesODPo.ssesbeyecurvatureos1}</TD>
                          <TD height="26">${salesODPo.ssesbdiameteros}</TD>
                          <TD height="26">${salesODPo.ssesbclosevaos}</TD>
						</TR>					  
                      </TBODY>
                    </TABLE>
			</c:if>	
				 <c:if test="${not empty(goodsInfoList)}"> 
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
                          <TD height="26"><input type="checkbox" id="chk" name="chk" onclick="checkTogether(${ssesdcommoditiesflag},this)" goodtype="${ssesdcommoditiesflag}" value="${ssesdid}" price="${ssesdsalesvalue}"/></TD>
                          <TD>${ssesdsalesitemid}</TD>
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
                    </c:if>
                    <br/>
                    <c:forEach var="po" items="${salesdjq}">
<input type="hidden" id="djqSourceID" name="djqSourceID" value="${po.sseslsourceid }"/> 
                          <input type="hidden" id="djqprice" name="djqprice" value="${po.sseslprice }"/>

                        </c:forEach>
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
                    <TABLE width="100%" border=0 align=center cellpadding=0 cellspacing=1>
        <tr>
        	<td class="qtCenterLine">
				<TABLE width="90%" align="center" cellpadding=0 cellspacing=1 class="privateTable privateBorder" id="jktable">
				  <tr style="display: block;" id="" leixing=leixing >
				    <td height="26" width="10%" class="table_body" align="center">实缴金额：</td>
				    <td width="30%" class="table_none">    	
						<input type="text" class="text_input100" style="border: none;font-family: 黑体;font-size: 14;background: " id="salseValue" name="salseValue" value="${salesBasicPo.ssesbpsalsvalue}" readonly="readonly" />
						<input type="hidden" id="salseID" name="salseID" value="${salesBasicPos[0].ssesbsalesid }" readonly="readonly" />
				    </td>
				    <td width="10%" class="table_body" align="center">缴费金额：</td>
				    <td width="50%" class="table_none" colspan="5">
				    	<input type="text" style="border: none;font-family: 黑体;font-size: 14;background: " readonly="readonly" class="text_input100" id="jf"/>&nbsp;&nbsp;				    	
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
				    	<img src="${ctx }/img/newbtn/btn_xianjin_0.png" btn=btn title='现金' xjv=xjv type='button'  onClick="xjkaiqi()" >
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
				    	<img src="${ctx }/img/newbtn/btn_yinhangka_0.png" btn=btn title='银行卡' icon="icon-add-row" onClick="yhkkaiqi()" >
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
				    	<img src="${ctx }/img/newbtn/btn_jifen_0.png" btn=btn title='积分' icon="icon-add-row" onClick="dhjfkaiqi()" >
				    </td>
					<td class="table_none" colspan="3">&nbsp;&nbsp;</td>
				  </tr>
			</c:if>
			<c:if test="${fn:contains(systemParameterPo.fspcollecttype,'4')}">		  
				  <tr style="display: none;" id="czktr" leixing=leixing height="26">
				  	<td class="table_body" align="center"  width="10%">储值卡：</td>
				  	<td class="table_none" width="30%">
				  	<input type="text" style="border: none;font-family: 黑体;font-size: 14;background: ;text-align:center;" readonly="readonly" class="text_input100" czkid="czkid" name="czkid" value="0"/>&nbsp;&nbsp;<input type="hidden" czkye=czkye name="czkye"/>
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
				    <img src="${ctx }/img/newbtn/btn_chuzhika_0.png" btn=btn title='储值卡' icon="icon-add-row" onClick="czkkaiqi(this)" >
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
					<img src="${ctx }/img/newbtn/btn_zengjia_0.png" btn=btn title='增加' onClick="addRowdjq('jktable','','djqtr')" >
					</td>
				  </tr>
				  
				  <tr style="display: block;" id="djqkaiqi" leixing=leixing height="26">
				  	<td class="table_body" align="center">
				    <img src="${ctx }/img/newbtn/btn_daijinquan_0.png" btn=btn title='代金券' icon="icon-add-row" onClick="djqkaiqi()" >
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
				    	<img src="${ctx }/img/newbtn/btn_qita_0.png" btn=btn title='其他' icon="icon-add-row" onClick="qtkaiqi()" >
				    </td>
					<td class="table_none" colspan="3">&nbsp;&nbsp;</td>
				  </tr>
			</c:if>  	 
                        <input type="hidden" name="content" id="content" value="${content}">
				</table>
		</td></tr>
</table>
             <c:if test="${not empty(goodsInfoList)}">        
                   <TABLE width="100%">
                   <TBODY>
                       <TR>
                       	<TD width="100%" height="26" colspan="2" align="center" ><img src="${ctx }/img/newbtn/btn_refund_0.png" btn=btn id="saveButton" name="button3223" title='退款' onclick="refundSales()"/></TD>
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