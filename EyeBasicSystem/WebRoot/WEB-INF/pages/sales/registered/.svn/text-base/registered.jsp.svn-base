<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
	<TITLE>FrameWork</TITLE>
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
	});

	function openMember(){
        if ('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2'){
            alert('此门店已经连接HIS系统，不能新增会员!');
            return;
        }
        
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInsertCustomerInfo.action?arg0=registered",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertCustomerInfo.action?arg0=registered",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【会员新增】";
	}
	
	

	
	function changeRegistered(){
		if($("#registeredType").val() == '1'){
    		$("#return").val("1");
    	}else{
    		$("#return").val("");
    	}
		
		$('#payment').val('');
		$('#refunds').val('');
		
		if(registeredForm.registeredType.value == '0'){ //挂号
			$('#payment').attr("disabled", false);
			$('#refunds').attr("disabled",true); 
			$('#payment').show();
			$('#refunds').hide();
			$('#paymentSpan').show();
			$('id=refundsSpan').hide();
		}else if(registeredForm.registeredType.value == '1'){
			$('#payment').attr("disabled",true);
			$('#refunds').attr("disabled",false); 
			$('#payment').hide();
			$('#refunds').show();
			$('#paymentSpan').hide();
			$('[id=refundsSpan]').show();
		}
	}
	
	function addRegistered(){
		var payment = document.getElementById('payment');
		var refunds = document.getElementById('refunds');
		var option;
		var ttype = "";
		if($("#payment").find("option[value="+$("#payment").val()+"]").attr("ttype") == '1' || $("#refunds").find("option[value="+$("#refunds").val()+"]").attr("ttype") == '1'){
			
			if($("#registeredType").val() == "0"){
				ttype = $("#payment").find("option[value="+$("#payment").val()+"]").attr("ttype");
			}else{
				ttype = $("#refunds").find("option[value="+$("#refunds").val()+"]").attr("ttype");
			}
			
			if(!$("#optometryPerson").val()){
				alert("请选择验光师！");
				$("#optometryPerson").select();
				return;
			}
		}
		
		if(payment != null && !payment.disabled){
			if(payment.value == ''){
				return;
			}
			option = payment.options[payment.selectedIndex];
			
		}else{
			if(refunds == null || refunds.value == ''){
				return;
			}
			option = refunds.options[refunds.selectedIndex];
		}
			
		var json = {'scrrdid' : '', 
					'scrrdregisterid' : option.value, 
					'scrrdregistername' : option.innerHTML,
					'scrrdmoney' : option.getAttribute("money"),
					'ttype' : ttype,
					'optometryPersonname' :  $("#optometryPerson").find("option:selected").text(),
					'optometryPerson' : $("#optometryPerson").val()};
		addRow(json);
		$("#retype").show();
		$("#retype").text($("#registeredType").find("option:selected").html());
		$("#registeredType").hide();
		
		if('${systemParameterPo.fspxianjindefault}' == '1'){
			$("#xjv").val($("#salseValue").val());
			$("#jf").val($("#salseValue").val());
		}
	}
	
	function init(){
		var json = {};
		<c:if test="${not empty(registeredDetailsPoList)}">
		
		<c:forEach items="${registeredDetailsPoList }" var="po" >
		json = {'scrrdid' : '${po.scrrdid }', 
					'scrrdregisterid' : '${po.scrrdregisterid }', 
					'scrrdregistername' : '${po.scrrdregistername }' + '&nbsp;&nbsp;&nbsp;&nbsp;￥' + '${po.scrrdmoney }',
					'scrrdmoney' : '${po.scrrdmoney }',
					'ttype' : '${po.scrrdamounttype }',
					'optometryPersonname' : '${po.scrrdcheckpersonname }',
					'optometryPerson' : '${po.scrrdcheckperson }'};
		addRow(json);
		</c:forEach>
		</c:if>

		jfSum();

		if(document.getElementById('smecicustomerid').value ==''){
			$("#shoufeidiv").hide();
		}
		if('${systemParameterPo.fspxianjindefault}' == '1'){
			$("#xjv").val($("#salseValue").val());
			$("#jf").val($("#salseValue").val());
		}
	}
	
	function addRow(json){
		var table = document.getElementById('addRegisteredTable');
		var row = table.insertRow(table.rows.length);
		var rowNum = table.rows.length - 2;
		
		row.className = 'row';
		row.onMouseOver="mover(this,'#a2c1eb')"
		row.onMouseOut="mout(this,'#cadee8')"
		
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		
		var ttypename = '';
		if(json.ttype == '1'){
			ttypename = '验光师('+json.optometryPersonname+')';
		}
		
		c1.innerHTML = json.scrrdregistername + '<input type="hidden" name="registeredDetailsPo.scrrdids" value="'+json.scrrdid+'" /><input type="hidden" name="registeredDetailsPo.scrrdregisterids" value="'+json.scrrdregisterid+'" />'
		c2.innerHTML = '￥' + json.scrrdmoney + '<input type="hidden" id="moneyFee" name="moneyFee" value="'+json.scrrdmoney+'" />';
		c3.innerHTML = ttypename + '<input type="hidden" name="registeredDetailsPo.scrrdamounttypes" value="'+json.ttype+'" /><input type="hidden" name="registeredDetailsPo.scrrdcheckpersons" value="'+ json.optometryPerson +'" />';
		c4.innerHTML = '<img src=\"${ctx }/img/newbtn/btn_delete_0.png\" onmouseover=\"JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/btn_delete_1.png\');\" onmouseout=\"JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/btn_delete_0.png\');\" title=\'删除\' style=\"cursor:hand\" onclick=\"$(this).parent().parent().remove();numMoey()\" />';
		
		numMoey();
	}
	
	function numMoey(){
		$('#moneySum').val('0.00');
		$('input[id="moneyFee"]').each(function(){
			$('#moneySum').val(accAdd($('#moneySum').val(), this.value));
		});
		var moneySum = document.getElementById('moneySum');
		moneySum.value = new Number(moneySum.value).toFixed(2);
		$("#salseValue").val(moneySum.value);
		$("#salesValue").val(moneySum.value);
		var table = document.getElementById('addRegisteredTable');
		var row = table.rows.length;
		if(row > 1){
		}else{
			$("#retype").hide();
			$("#retype").text($("#registeredType").find("option:selected").html());
			$("#registeredType").show();
		}
	}
	
	function insertRegistered(){
		if($('input[id="moneyFee"]').size() == 0){
			alert('请选择挂号类别！');
			return ;
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
	  	registeredForm.action='insertRegistered.action';
	  	registeredForm.submit();
	}
	
	$(document).ready(function(){
		if('${systemParameterPo.fsphisflag}' == '0' || '${person.bdplinkhisflag}' == '0'){
			document.getElementById('smecimemberid').focus(); 
        }
		init();
		if('${arg0}'=='registered'){//打印会员卡
			if('${systemParameterPo.fspshowcustomertable}'=='1'){
	            var memberID = '${regMemberID}';
	            setReportEvent_HYK(memberID);
	            printGSL_HYK(memberID,'${departmentID}');
    		}
    		
			$('#smecimemberid').val('${regMemberID}');
			registeredForm.action = 'initRegisteredSel.action';
			registeredForm.submit();
		}
		//打印挂号费
		<c:if test="${not empty(param.DetailsID) }">
			initPopUp();
			setReportEvent_GHF('${param.DetailsID}','${param.caicer}','${param.customer}')
			printGSL_GHF('${departmentID}','${param.DetailsID}');
		</c:if>

		if(parseFloat('${customerInfoPo.fmmage }') < 70){
			$("#payment option[value=07][text*=￥0.00]").remove();
		}
	});

	/**
	 * 会员卡打印主程序入口
	 * @memberID	会员卡号；
	 */
	function setReportEvent_HYK(memberID){
		var reportFileName = '${fittingTemplateTypePo.bftfilename}';	//报表文件名
		var bftserver = '${fittingTemplateTypePo.bftserver}';		//报表服务器
		var showtype = '${fittingTemplateTypePo.bfttshowtype}';	//报表显示方式
		
		switch(bftserver)
		{
		case "1":
		  fineReportEvent_HYK(reportFileName,showtype,memberID);
		  break;
		case "2":
		  reportingServiceEvent_HYK(reportFileName,showtype,memberID);
		  break;
		default:
		  alert("单据配置异常！");
		}		
		printGSL_HYK(memberID,'${departmentIDgsl}');	//天津眼科弹出的第二个报表
	}

    function fineReportEvent_HYK(reportFileName,showtype,memberID){
    	DataURL="report.action?reportlet="+ reportFileName +"&MemberId="+memberID;
		switch(showtype)
		{
		case "1":
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;		
			if(is_iPad()){
				showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin(DataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【会员卡打印 】";
		  break;
		case "2":
			window.open (DataURL, '会员卡打印', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
		  break;
		default:
		  alert("单据配置异常！");
		}	
    }

    function reportingServiceEvent_HYK(reportFileName,showtype,memberID){
    	var DataURL = '<%= getServletContext().getInitParameter("rptUrl")%>';
    	DataURL+="eims_reporting/"+ reportFileName +"&memberID="+memberID+"&rs:Command=Render";

		switch(showtype)
		{
		case "1":
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;		
			if(is_iPad()){
				showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin(DataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【会员卡打印 】";
		  break;
		case "2":
			window.open (DataURL, '会员卡打印', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
		  break;
		default:
		  alert("单据配置异常！");
		}	
    }

	/**
	 * 挂号单打印主程序入口
	 * @salseID	会员卡号；
	 */
	function setReportEvent_GHF(billID,personName,customerName){
		var DataURL='';

		if ($.trim('${systemParameterPo.fspregisterbillname}') == ''){
            alert('请先配置挂号单样式!');
            return;
        }else{
    		if($.trim('${systemParameterPo.fspregisterbillserver}') =="1"){
    			DataURL="report.action?reportlet=${systemParameterPo.fspregisterbillname}&salseID="+billID;
    		}else if($.trim('${systemParameterPo.fspregisterbillserver}') =="2"){
    			DataURL = '<%= getServletContext().getInitParameter("pjdUrl")%>';

    			DataURL+="eims_reporting/${systemParameterPo.fspregisterbillname}&salseID="+billID;
    			DataURL+="&personName=EncodeUtf8("+ personName +")";
    			DataURL+="&customerName="+customerName;
    			DataURL+="&rs:Command=Render";    			
    		}
        } 		
        
	    window.open (DataURL, '挂号单', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');      
	}
    
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

	 function setCustomer(memberid){
		document.getElementById('smecimemberid').value = memberid;
		$("img").removeAttr("onclick");
		registeredForm.action = "initRegisteredSel.action";
		registeredForm.submit();
	 }

	 function jfSum(){
	    	var sum = 0;
	    	var checknum = "";
	    	var salseValue = $("#salseValue").val();
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
				if(salseValue >= 0){
					if ($(this).val()>=0){
					}else{
						alert('挂号金额有误！');
						$(this).val("");
						$(this).select();
						$(this).focus();
						checknum = "1";
						return false;
					}
				}else if(salseValue <= 0){
					if ($(this).val()<=0){
					}else{
						$(this).value="";
						alert('挂号金额有误！');
						$(this).select();
						$(this).focus();
						$(this).val("");
						checknum = "1";
						return false;
					}
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
				showPopWin("initCzkOpen.action?indexid="+indexid,500,200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("initCzkOpen.action?indexid="+indexid,500,200,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【储值卡查询】";
	    }
	    function djqOpen(obj){
	    	var indexid = $("input[djqv=djqv]").index(obj);
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			var registeredType=$("#registeredType").val();

			var customerid=$("input[id=smecicustomerid]").val();

			if(is_iPad()){
				if(registeredType =='0'){
				    showPopWin("initDjqOpen.action?indexid="+indexid,500,200,topRows,topCols,returnRefresh(true),false);
				}else{
					showPopWin("initDjqOpen3.action?indexid="+indexid+"&customerid="+customerid,500,200,topRows,topCols,returnRefresh(true),false);
				}
			}else{
				if(registeredType =='0'){
				    showPopWin("initDjqOpen.action?indexid="+indexid,500,200,topRows,topCols,returnRefresh(true),false);
				}else{
					showPopWin("initDjqOpen3.action?indexid="+indexid+"&customerid="+customerid,500,200,topRows,topCols,returnRefresh(true),false);
			    }
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
			htmltd2.innerHTML = " <input type=\"hidden\" style=\"border: none;font-family: 黑体;font-size: 14;background: ;text-align:center;\" readonly=\"readonly\" class=\"text_input100\" czkid=czkid name=\"czkid\" value=\"0\" />&nbsp;&nbsp; <input type=\"text\" czkv=czkv class=\"text_input100\" onclick=\"czkOpen(this)\" leixing=\"leixing\" name=\"czkv\" readonly=\"readonly\" onblur=\"jfSum()\" value=\"0.00\"/><input type=\"hidden\" czkye=czkye  name=\"czkye\"/>";
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
	    
	    
	    function changeType(obj){
	    	if($(obj).attr("name") == "registeredType"){
		    
	    		$("#amounttype").hide();
	    		$("#optometryPerson").val("");

	    		var tb = document.getElementById('addRegisteredTable');
	    		 var rowNum=tb.rows.length;
	    	     for (i=1;i<rowNum;i++)
	    	     {
		    	     
	    	         tb.deleteRow(i);
	    	         rowNum=rowNum-1;
	    	         i=i-1;
	    	     }
	    		
	    		var json = {};
				if(obj.value=='0'){
					<c:if test="${not empty(registeredDetailsPoList)}">
		    		<c:forEach items="${registeredDetailsPoList }" var="po" >
		    		json = {'scrrdid' : '${po.scrrdid }', 
		    					'scrrdregisterid' : '${po.scrrdregisterid }', 
		    					'scrrdregistername' : '${po.scrrdregistername }' + '&nbsp;&nbsp;&nbsp;&nbsp;￥' + '${po.scrrdmoney }',
		    					'scrrdmoney' : '${po.scrrdmoney }',
		    					'ttype' : '${po.scrrdamounttype }',
		    					'optometryPersonname' : '${po.scrrdcheckpersonname }',
		    					'optometryPerson' : '${po.scrrdcheckperson }'};
		    		addRow(json);
		    		</c:forEach>
		    		</c:if>
		    		jfSum();
				}else if(obj.value == '1'){
					<c:if test="${not empty(registeredDetailsPoRefundsList)}">
		    		<c:forEach items="${registeredDetailsPoRefundsList }" var="po" >
		    		json = {'scrrdid' : '${po.scrrdid }', 
		    					'scrrdregisterid' : '${po.scrrdregisterid }', 
		    					'scrrdregistername' : '${po.scrrdregistername }' + '&nbsp;&nbsp;&nbsp;&nbsp;￥' + '${po.scrrdmoney }',
		    					'scrrdmoney' : '${po.scrrdmoney }',
		    					'ttype' : '${po.scrrdamounttype }',
		    					'optometryPersonname' : '${po.scrrdcheckpersonname }',
		    					'optometryPerson' : '${po.scrrdcheckperson }'};
		    		addRow(json);
		    		</c:forEach>
		    		</c:if>
		    		jfSum();
				}
	    		
	    		
	    		return;
	    	}
	    
	    	var type = $(obj).find("option[value="+$(obj).val()+"]").attr("ttype");
	    	if(type == '1'){
	    		$("#amounttype").show();
	    	}else{
	    		$("#amounttype").hide();
	    		$("#optometryPerson").val("");
	    	}
	    	
	    }


		function Print(code){

	        if ('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2'){
	            alert('此门店已经连接HIS系统，不能打印!');
	            return;
	        }
	        
			var num=1; 
			var fso,f1,ts,s; 
			var ForReading = 1; 
			fso = new ActiveXObject("Scripting.FileSystemObject"); 
			if(fso==null){ 
				alert("请检查条码打印机！"); 
				return false; 
			} 
		
			var str = "\x1B\x40";
			f1 = fso.CreateTextFile("lpt1:",true,true); 
			
			str = str + "^XA";
			str = str + "^MD21";
			str = str + "^CWX,E:MSUNG24.FNT^FS";
			str = str + "^AI26";
			str = str + "^BY3,2.0,100";
			str = str + "^FO20,60^B3^FD" + code + "^FS";
			str = str + "^PQ1^FS";
			str = str + "^XZ";
			
			f1.write(str);
			f1.close();
		}

	    function showArrearsValues(tid,tdptid) {  
		    $('#drljje').load("getRegisteredValuesToo.action?tid="+tid+"&tdptid="+tdptid);
		}
		
function selectCust(flag){
    if(flag){
	    $("img").removeAttr("onclick");
		registeredForm.action = 'initRegisteredSel.action';
		registeredForm.submit();
    }
}
function selectCustomer(){
    if('${person.bdplinkhisflag}' == '1'){
            alert('此门店已经连接HIS系统，不能使用此功能!');
         return ;
	}
	if(document.getElementById('smecimemberid').value.trim() != ''){
		if(event.keyCode == 13){
				$("img").removeAttr("onclick");
				registeredForm.action = 'initRegisteredSel.action';
				registeredForm.submit();
		}
	}
}		
</script>
<jsp:include page="/hisCusWin_js.jsp" flush="true" />
<BODY bgColor="#ffffff" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="registeredForm" method="post" >
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="return" id="return" value="">
<input type="hidden" name="registeredDetailsPo.scrrddetailsid" id="scrrddetailsid" value="${registeredDetailsPoList[0].scrrddetailsid }">
<DIV>

<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>银台</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：中心挂号</TD>
            <TD align="right"><font color="black" size="3" id="drljje"><img src="${ctx }/img/newbtn/btn_hudrsyzje_0.png" name="button22" title='获取当日收银总金额' btn=btn onclick="showArrearsValues('${tid}','${departmentID}');" ></font></TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY> 
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx }/img/pic/tab_bg.gif></TD></TR>
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
                    <table width="100%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                      <tr>
                        <td height="30" class="table_body"><div align="right">会员卡号</div></td>
                        <td height="30" class="table_none">
                        <li style="float:left;list-style:none;margin-right:5px;margin-top:5px;margin-bottom:5px;">
                        	<input type="text" id="smecimemberid" name="customerInfoPo.smecimemberid" class="text_input100" value="${customerInfoPo.smecimemberid }" 
                        	onkeydown="selectCustomer();" ${person.bdplinkhisflag=='1' && systemParameterPo.fsphisflag == '2'  ? 'readonly=readonly':'' }>
                			<input type="hidden" id="smecicustomerid" name="customerInfoPo.smecicustomerid" class="text_input100" value="${customerInfoPo.smecicustomerid }">
                        </li>
                        <li class="horizontal">
                            <img src="${ctx }/img/newbtn/btn_hydq_0.png" btn=btn hisn=hisn title='查找' >
                        	<img src="${ctx }/img/newbtn/btn_search_0.png" name="button22" title='查找' btn=btn onclick="selCustomerInfo();" >
					    </li>
                        <li class="horizontal">顾客姓名：<input name="customerInfoPo.smeciname" value="${customerInfoPo.smeciname }" class="text_input60" disabled="disabled"></li>                   
						<li class="horizontal"><img name="userName4" src="${ctx }/img/newbtn/btn_customerinsert_0.png" btn=btn title="会员新增" onclick="openMember()"></li>
						<li class="horizontal"><img src="${ctx }/img/newbtn/btn_dygkm_0.png" btn=btn title="打印顾客码" onclick="Print($('#smecimemberid').val())"></li></td>
                      </tr>
                      <tr>
                        <td width="45%" height="30" class="table_body"><div align="right">挂号类型</div></td>
                        <td width="55%" class="table_none">
                          <select id="registeredType" name="registeredType" onchange="changeRegistered();changeType(this);" >
                            <option value="0" ${registeredType == '0' ? 'selected="selected"' : ''} >挂号</option>
                            <option value="1" ${registeredType == '1' ? 'selected="selected"' : ''} >退款</option>
                          </select>
                          <div id="retype" style="display: none"></div>
                        </td>
                      </tr>
                      <tr>
                        <td height="30" class="table_body"><div align="right">检查类别</div></td>
                        <td class="table_none">
                        	<c:if test="${not empty(registeredPayments)}">
                        	<span id="paymentSpan">
                        		<select id="payment" name="payment" onchange="$('#money').val(this.options[this.selectedIndex].money);changeType(this);">
                        			<option value="" money="">----请选择----</option>
                              	<c:forEach var="po" items="${registeredPayments}">
                              		<option value="${po.frcid }" money="${po.frcmoney }" ttype="${empty(po.frcamounttype) ? '' : po.frcamounttype }">${po.frcregisteredname }&nbsp;&nbsp;&nbsp;&nbsp;￥${po.frcmoney }</option>                     
                                </c:forEach>
                                </select>
                            </span>
                            </c:if>
                            <c:if test="${not empty(registeredRefunds)}">
                            <span id="refundsSpan" style="display:none;">
                        		<select id="refunds" name="refunds" onchange="$('#money').val(this.options[this.selectedIndex].money);changeType(this);">
                        			<option value="" money="">请选择检查类别</option>
                              	<c:forEach var="po" items="${registeredRefunds}">
                              		<option value="${po.frcid }" money="${po.frcmoney }" ttype="${empty(po.frcamounttype) ? '' : po.frcamounttype }">${po.frcregisteredname }&nbsp;&nbsp;&nbsp;&nbsp;￥${po.frcmoney }</option>                      
                                </c:forEach>
                                </select>
                            </span>
                            </c:if>
                            <span id="amounttype" style="display:none;">
                            	<select id="optometryPerson" name="optometryPerson">
								    <option value="" selected="selected">---请选择---</option>
									<c:forEach var="opo" items="${optometryPersonInfoPos}">
										<option value="${opo.id }">${opo.personName }</option>
									</c:forEach>
								</select>
							</span>
                            
                            <span id="refundsSpan" style="display:none;">
                        </td>
                      </tr>
                    </table>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <div align="center">
                              <img name="button" src="${ctx }/img/newbtn/btn_change_0.png" title="选择" btn=btn onclick="addRegistered();"/>
                              </div></TD></TR>
                      </TBODY>
                    </TABLE>
					<fieldset id="shoufeidiv">
					<legend>待收费项目</legend>
                    <TABLE id="addRegisteredTable" width="99%" border=0 cellSpacing=1 class="Privateborder privateTable" id="ctl00_PageBody_GridView1">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH class="PrivateBorder" width="30%" scope=col>检查项目</TH>
                          <TH class="PrivateBorder" width="30%" scope=col>检查金额</TH>
                          <TH class="PrivateBorder" width="30%" scope=col>检查分类</TH>
                          <TH width="15%" height="30" class="PrivateBorder" scope=col>删除</TH>
                        </TR>
                      </TBODY>
                    </TABLE>
                    
                    <TABLE width="100%" border=0 align=center cellpadding=0 cellspacing=1>
        <tr>
        	<td class="qtCenterLine">
				<TABLE width="90%" align="center" cellpadding=0 cellspacing=1 class="privateTable privateBorder" id="jktable">
				  <tr style="display: block;" id="" leixing=leixing >
				    <td height="26" width="10%" class="table_body" align="center">实缴金额：</td>
				    <td width="30%" class="table_none">    	
						<input type="text" class="text_input100" style="border: none;font-family: 黑体;font-size: 14;background: " id="salseValue" name="salseValue" value="${salesBasicPos[0].ssesbpsalsvalue }" readonly="readonly" />
						<input type="hidden" id="salseID" name="salseID" value="${salesBasicPos[0].ssesbsalesid }" readonly="readonly" />
						<input type="hidden" id="salesValue" name="salesValue" value=""/>
						<input type="hidden" id="orderType" name="orderType" value="7"/>
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
				    	<img src="${ctx }/img/newbtn/btn_xianjin_0.png" btn=btn xjv=xjv title='现金' onClick="xjkaiqi()" >
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
					<img src="${ctx }/img/newbtn/btn_zengjia_0.png" btn=btn  title='增加' onClick="addRowY('jktable','','yhktr')" >
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
					<font color="red">会员当前积分为：${customerInfoPo.smeciintegral }</font>
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
				<TABLE width="100%" border=0 cellSpacing=1 class="table-box" id="ctl00_PageBody_GridView1">
                      <TBODY>
                        <TR>
                          <td width="100%" align="center">
	                          <input id="moneySum" name="moneySum" type="hidden" class="text_input100" readonly="readonly">
	                          <img name="button2" id='button2' src="${ctx }/img/newbtn/btn_pay_0.png" btn=btn title="缴费" onclick="insertRegistered()" >
                          </td>
                        </TBODY>
                    </TABLE>
		</td></tr>
</table>
                    </fieldset>
                  </DIV>
                </DIV>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
				</TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR align="right">
    <TD height=5><br></TD></TR></TBODY></TABLE></DIV></form>
    <form id="report" name="report" action="" method="post" target="_blank">
</form>
    </BODY></HTML>