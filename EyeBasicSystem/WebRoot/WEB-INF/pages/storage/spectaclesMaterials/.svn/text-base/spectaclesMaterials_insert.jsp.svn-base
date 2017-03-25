<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>配镜发料管理</title>

<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<!--<link rel="stylesheet" type="text/css" href="${ctx }/css/module/thickbox.css" /> -->
</head>
<script>	
 	var isAuto = 1;
    function updateAuto(obj){
       isAuto = obj;
       if(obj==0){
           $(':input').removeAttr("disabled");
       }
       if(obj==1){
           $('select[name=ssesdstockid]').each(function(){
		       $(this).attr({disabled:"disabled"});
		       $('input[name=ssesdstockid]').attr({disabled:"disabled"});
		   });
           $('#processDpt').attr({disabled:"disabled"});
	   }
    }

	function changeProcessDpt(){
		$('#processDpt').attr("disabled","");
	}

	function disabledProcessDpt(){
		$('#ssesbprocessdepartment').val($('#processDpt').val());
	}
    
    function tohedd(obj)
    {
      		var i = obj.id.substr(12);
			document.getElementById("ss"+i).value = obj.value;
    }
	
	function barcode(goodsid,goodsbarcode){
		if(event.keyCode==13){
			var tmp = goodsid.replace(/\./g,  "").toUpperCase();
			var tmp1 = goodsbarcode.value;
			tmp1=tmp1.substring(0,tmp1.length-8);
			tmp1 = tmp1.toUpperCase();
			if(goodsbarcode.value.lengh<26)
			{
				alert("商品位数不符！");
				goodsbarcode.value="";
				goodsbarcode.focus();
				return;
			}
			if(tmp != tmp1){
				alert("商品不符！");
				goodsbarcode.value="";
				goodsbarcode.focus();
				return;
			}
			event.keyCode=9;
		}
	}
	
	function insert(){
		for(var i=0;i<document.getElementsByName('goodsItemId').length;i++){
			if(document.getElementsByName('goodsItemId')[i].value==''){
				alert('商品条码不能为空!');
				return;
			}
		}
		
		var goodsids = document.getElementsByName('goodssalesid');
		var goodsbarcodes = document.getElementsByName('goodsItemId');
		
		var size = goodsids.length;
		
		var submittype = 'a';
		for(var i = 0; i < size; i++){
			if(goodsids[i].value.replace(/\./g,"").toUpperCase()!=goodsbarcodes[i].value.substring(0,18).toUpperCase()){
				submittype = i;
				break;
			}
			if(goodsbarcodes[i].value.length != 26){
				submittype = i;
				break;
			}
		}

		if(parseFloat(submittype) >= 0){
			goodsbarcodes[submittype].focus();
			goodsbarcodes[submittype].select();
			alert("条码不符");
			return;
		}

		if($('#processDpt').val() == ''){ 
            alert('请选取加工部门!');
            return;
		}

		$("img").removeAttr("onclick");
		spectaclesMaterialsForm.action = "insertSpectaclesMaterials.action";
		spectaclesMaterialsForm.submit();

	}	
	
	function permissionMessage(){
       alert('您无此操作权限');
	}

	function unRefresh()
	{
		window.parent.setInterval('search()','${systemParameterPo.fspallocationatuotime}'*1000);
	}

	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 

		for(var i=0;i<document.getElementsByName('goodsItemId').length;i++){
			document.getElementsByName('goodsItemId')[0].focus();
		}
	    
    }); 

    function toUpper(obj){
		$(obj).val($(obj).val().toUpperCase());
    }
</script>
<body onUnload="unRefresh()" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="spectaclesMaterialsForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="salesid" name="salesid" value="${requestScope.ssesbsalesid}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" background=${ctx}/img/pic/tab_bg.gif>
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 0px" 
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
			               <TD class="table_none" width="23%">${salesBasicPo.ssesbsalesid}</TD>
			               <TD width="8%" height="26" class="table_body">所属门店</TD>
			               <TD class="table_none" width="23%">${salesBasicPo.ssesbshopName}</TD>
			               <TD height="26" width="8%" class="table_body">配镜类型</TD>
			               <c:if test="${(salesBasicPo.ssesborderstype)==1}"> 
			               <TD class="table_none">镜架成品</TD>
			               </c:if>
			               <c:if test="${(salesBasicPo.ssesborderstype)==2}"> 
			               <TD class="table_none" >镜架订做</TD>
			               </c:if>
                        </TR> 
                        <TR>
			               <TD height="26" class="table_body">配镜日期</TD>
			               <TD class="table_none">${fn:substring(salesBasicPo.ssesbsalesdatetime,0,16)}</TD>
                           <TD height="26" class="table_body">取镜日期</TD>
			               <TD class="table_none">${fn:substring(salesBasicPo.ssesbtakeglassdata,0,16)}</TD>
			               <TD height="26" class="table_body">顾客姓名</TD>
			               <TD class="table_none">${salesBasicPo.ssesbpersonName}</TD>
                        </TR>  
                        <TR>
						   <TD height="26" class="table_body">联系电话</TD>
			               <TD class="table_none">${salesBasicPo.ssesbphone}</TD>
			               <TD height="26" class="table_body">发料人</TD>
			               <TD class="table_none">${sessionScope.person.personName}</TD>
			               <TD height="26" class="table_body">发料时间</TD>
			               <TD class="table_none"> 
			               <jsp:useBean id="now" class="java.util.Date" />
                          <fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd HH:mm" />
                          </TD>
                        </TR>                       
                        <TR>
						   <TD height="26" class="table_body">加工部门</TD>
			               <TD class="table_none" colspan="5">
			                   <select id="processDpt" name="processDpt" onchange="disabledProcessDpt()" disabled="true" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取加工部门!'}]">
					               	  <OPTION value="" ${'' == bdpdepartmentid  ? 'selected="selected"' : '' } >----请选择----</OPTION> 
					               	  <s:iterator value="departmentsList">
	                    	           <OPTION value="${bdpdepartmentid}" ${bdpregid == bdpdepartmentid  ? 'selected="selected"' : '' } >${bdpdepartmentname}</OPTION>  
	                    	          </s:iterator>
	                 	       </select>
	                 	       <input type="hidden" name="ssesbprocessdepartment" id="ssesbprocessdepartment"/>
			               </TD>
			            </TD>
                        </TR>                   
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img id="buttonsave" src="${ctx }/img/newbtn/btn_sendmaterial_0.png" btn=btn title="发料" onClick="javascript:insert()">
							</td>
				<c:if test="${(permissionPo.keyc==1)}">	 		                         
                          <TD align="right">
                            <input id="btn1" name="radbtn" type="radio" value="1" onClick="updateAuto(1);" checked="checked">锁定发出仓位&nbsp;&nbsp;&nbsp;&nbsp;
                            <input id="btn0" name="radbtn" type="radio" value="0" onclick="updateAuto(0);">修改发出仓位
                          </TD>
               </c:if>     
                    
                         <TD align="left">
	                          <c:if test="${systemParameterPo.fspsalestype eq '0' && hid != ''}">
	                             <font color="red" style="font-family: 微软雅黑">商品信息如果为红色,则表示该商品库存不足,不能完成商品出库操作!</font>
	                          </c:if>   
                         </TD>
                    
                        </TR>
					</table>
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
                     
                     <table width="100%" border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH height="26" width="10%" scope=col>镜片种类</TH>
						  <TH width="10%" scope=col>右眼(R)/左眼(L)</TH>						
						  <TH width="8%" scope=col>球镜</TH>
						  <TH width="8%" scope=col>柱镜</TH>
						  <TH width="8%" scope=col>轴向</TH>
						  <TH width="7%" scope=col>add</TH>
						  <TH width="7%" scope=col>三棱镜</TH>
						  <TH width="7%" scope=col>基底</TH>
						  <TH width="7%" scope=col>棱镜</TH>
						  <TH width="7%" scope=col>远用瞳距</TH>
						  <TH width="7%" scope=col>近用瞳距</TH>
						  <TH width="7%" scope=col>远用VA</TH>
						  <TH width="7%" scope=col>近用VA</TH>
						  </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <c:if test="${(oDPo.ssesborderstype)==1}"> 
			               <TD height="26">镜架成品</TD>
			               </c:if>
			               <c:if test="${(oDPo.ssesborderstype)==2}"> 
			               <TD height="26">镜架订做</TD>
			               </c:if>
                          <TD align="center">R</TD>
                          <TD>${oDPo.ssesbballglassod}</TD>
                          <TD>${oDPo.ssesbpostglassod}</TD>
                          <TD>${oDPo.ssesbaxesod}</TD>
                          <TD>${oDPo.ssesbaddod}</TD>
                          <TD>${oDPo.ssesbarriseglassod}</TD>
                          <TD>${oDPo.ssesbbasisod}</TD>
                          <TD>${oDPo.ssesbprismod}</TD>
                          <TD>${oDPo.ssesbinterhighod}</TD>
                          <TD>${oDPo.ssesbinterdistanceod}</TD>
                          <TD>${oDPo.ssesbfarvaod}</TD>
                          <TD>${oDPo.ssesbclosevaod}</TD>
						</TR>
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <c:if test="${(oSPo.ssesborderstype)==1}"> 
			               <TD height="26">镜架成品</TD>
			               </c:if>
			               <c:if test="${(oSPo.ssesborderstype)==2}"> 
			               <TD height="26">镜架订做</TD>
			               </c:if>
                          <TD align="center">L</TD>
                          <TD>${oSPo.ssesbballglassos}</TD>
                          <TD>${oSPo.ssesbpostglassos}</TD>
                          <TD>${oSPo.ssesbaxesos}</TD>
                          <TD>${oSPo.ssesbaddos}</TD>
                          <TD>${oSPo.ssesbarriseglassos}</TD>
                          <TD>${oSPo.ssesbbasisos}</TD>
                          <TD>${oSPo.ssesbprismos}</TD>
                          <TD>${oSPo.ssesbinterhighos}</TD>
                          <TD>${oSPo.ssesbinterdistanceos}</TD>
                          <TD>${oSPo.ssesbfarvaos}</TD>
                          <TD>${oSPo.ssesbclosevaos}</TD>
						</TR>					  
                      </TBODY>
                    </TABLE>

					  <table name="rows" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="20%" height="26" scope=col>商品代码</TH>
						  <TH width="15%" scope=col>商品名称 </TH>						
						  <TH width="15%" scope=col>右眼(R)/左眼(L)</TH>
						   <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
						  <TH width="20%" scope=col>商品条码</TH>
						  </c:if>
						  <TH width="20%" scope=col>发出仓位</TH>
						  </TR>
						  
						<s:iterator value="goodsInfoList" status="a">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" ${systemParameterPo.fspsalestype eq '0' && hid eq ssesdid ? 'style="color: red"' : '' }>
                          <TD height="26" id="goodsid">${ssesdsalesitemid}</TD>
                          <TD>${ssesdsalesitemname}</TD>
                          <TD>${ssesdglassflag}
                          <c:if test="${systemParameterPo.fspbarcodetype==3}"> 
                            <c:choose>
                          		<c:when test="${empty(ssesditemid) && fn:substring(ssesdsalesitemid, 2, 4) != 'ZZ'}">
                          			 <input class="text_input200" type="hidden" id="goodsItemId" name="goodsItemId" maxlength="26" value="${goodscode}">                          		
	                          		 <input type="hidden" name="goodssalesid" id="goodssalesid" value="${ssesdsalesitemid}" /> 
	                          		 <input type="hidden" name="ssesdid" id="ssesdid" value="${ssesdid}" /> 
		                         	 <input type="hidden" name="ssesdnumber" id="ssesdnumber" value="${ssesdnumber}" /> 
		                         	 <input type="hidden" name="ssesdcostsprive" id="ssesdcostsprive" value="${ssesdcostsprive}" /> 
		                          	 <input type="hidden" name="ssesdunitprice" id="ssesdunitprice" value="${ssesdunitprice}" /> 
                          		</c:when>
                          		<c:when test="${not empty(ssesditemid) || fn:substring(ssesdsalesitemid, 2, 4) == 'ZZ'}"> 
                          		</c:when>
                          	</c:choose>	
							</c:if>
                          </TD>
                          <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                          <TD>
                          	<c:choose>
                          		<c:when test="${empty(ssesditemid) && fn:substring(ssesdsalesitemid, 2, 4) != 'ZZ'}">
                          		    <c:if test="${ssesdlargessflag==1}">
                          			 <input class="text_input200" type="text"  id="goodsItemId" name="goodsItemId" onblur="toUpper(this);" onkeydown="barcode('${ssesdsalesitemid}',this)" maxlength="26" value="${systemParameterPo.fspoutmaterialsflag == '1' && rksj!='1' ? goodscode : goodscode}" >                          		
	                          		</c:if> 
	                          		<c:if test="${ssesdlargessflag!=1}">
	                          		 <input class="text_input200" type="text"  id="goodsItemId" name="goodsItemId" onblur="toUpper(this);" onkeydown="barcode('${ssesdsalesitemid}',this)" maxlength="26" value="${systemParameterPo.fspoutmaterialsflag == '1' && rksj!='1' ? goodscode : ssesditemid}" ${systemParameterPo.fspoutmaterialsflag == '1' && rksj!='1'? 'readonly="readonly"' : '' }>                          		
	                          		</c:if>                           			 
	                          		 <input type="hidden" name="goodssalesid" id="goodssalesid" value="${ssesdsalesitemid}" /> 
	                          		 <input type="hidden" name="ssesdid" id="ssesdid" value="${ssesdid}" /> 
		                         	 <input type="hidden" name="ssesdnumber" id="ssesdnumber" value="${ssesdnumber}" /> 
		                         	 <input type="hidden" name="ssesdcostsprive" id="ssesdcostsprive" value="${ssesdcostsprive}" /> 
		                          	 <input type="hidden" name="ssesdunitprice" id="ssesdunitprice" value="${ssesdunitprice}" /> 
                          		</c:when>
                          		<c:when test="${not empty(ssesditemid) || fn:substring(ssesdsalesitemid, 2, 4) == 'ZZ'}"> 
                          			${ssesditemid}
                          		</c:when>
                          	</c:choose>
                          </TD>
                          </c:if>
                           
                          <TD>
                          <c:choose>
                          		<c:when test="${empty(ssesditemid) && fn:substring(ssesdsalesitemid, 2, 4) != 'ZZ'}">
                                    <select id="ssesdstockid${a.index}" name="ssesdstockid" onblur="tohedd(this);" disabled="true" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '发出仓位不能为空！'}]">
					               	  <s:iterator value="warehouseList">
	                    	           <OPTION value="${bwhid}" ${ssesdstockid!= bwhid  ? '' : 'selected="selected" ' } >${bwhwarehouseName}</OPTION>  
	                    	          </s:iterator>
	                 	       		</select>
	                 	       		<input type="hidden" name="ss" id="ss${a.index}" value="${ssesdstockid}" />
                          		</c:when>
                          		<c:when test="${not empty(ssesditemid) || fn:substring(ssesdsalesitemid, 2, 4) == 'ZZ'}"> 
                          			${ssesdstockname}
                          		</c:when>
                          	</c:choose>
                               
                          </TD>
						</TR>
						</s:iterator>						  
                      </TBODY>
                    </TABLE>
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