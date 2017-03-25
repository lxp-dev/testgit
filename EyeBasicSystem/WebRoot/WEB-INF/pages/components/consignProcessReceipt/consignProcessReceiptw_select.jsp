<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择商品</title>
</head>
<script>	
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	    
	    setCheckValue();
	});

	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	goodsForm.action=link;
	  	goodsForm.submit();
		showLoadingBar();
	}
	function search(){
		if(checkForm(document.all.goodsForm)){
			$("img").removeAttr("onclick");  
			goodsForm.action = "selGoodsForConsignProcessReceiptOpen.action";
			goodsForm.submit();
			showLoadingBar();
		}
	}
	function clean(){
		document.getElementById('billID').value = "";
		document.getElementById('startTime').value = "";
		document.getElementById('endTime').value = "";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}	

	/**
	 *  初始化判断checkbox的状态
	 */
    function setCheckValue(){
        var chktext="";
        $("input[id=chk]",window.parent.document).each(function(){
			chktext=chktext+","+$(this).val();
		});

        $("input[id=chk]").each(function(){
         	if(chktext.indexOf($(this).attr("cstcpodid"))>=0){
              $(this).attr("checked","checked");
           }
		});
    }
    	
	/**
	 *  调用单个页面赋值添加
	 */
    function setSingleValue(obj){
        var objValue="["+obj.value+"]";;
        if(obj.checked==true){       
        	window.parent.openConsignProcessOrdersValues(objValue);
        }else if(obj.checked==false){
           window.parent.openGoodSingleDeleteValues(objValue);
        }
    }
    
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        for(var i=0;i<chk.length;i++){
           chk[i].checked = chks.checked;
           setSingleValue(chk[i]);
        }
    }
    /**
	 * 委外收货单开窗
	 */
	function openBill(){

		showPopWin("","initConsignProcessReceiptwOpen.action",screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
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
          background=${ctx }/img/pic/tab_bg.gif>
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
						   <TD width="9%" height="26" class="table_body">配镜单号</TD>
			               <TD width="24%" class="table_none" >
                            	<input class="text_input200" type="text"  id="billID" name="billID" value="${requestScope.billID}" >
                           </TD>
                           <TD class="table_body" width="9%">单据日期</TD>
                           <TD width="24%" class="table_none" colspan="3"><input id="startTime"
					       name="startTime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${startTime}" /> 至 <input id="endTime"
					       name="endTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime}" /></TD>
                        </TR>
                      </TBODY>
                    </table>
                    <table id="searchBar" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">	
							</td>
						</tr>
					</table>
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								document.getElementById("searchBar").style.display="none";
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
                     </TABLE>

					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                        
                          <TH width="15%" scope=col>配镜单号</TH>
                          <TH width="10%" scope=col>顾客名称</TH>
                          <TH width="20%" scope=col>商品名称</TH>
                          <TH width="3%" scope=col>R/L</TH>
                          <TH width="3%" scope=col>球镜</TH>
                          <TH width="3%" scope=col>柱镜</TH>
                          <TH width="3%" scope=col>轴向</TH>
                          <TH width="3%" scope=col>下加</TH> 
                          <TH width="3%" scope=col>棱镜</TH>
                          <TH width="3%" scope=col>基底</TH>
                          <TH width="3%" scope=col>曲率</TH>
                          <TH width="3%" scope=col>直径</TH> 
                          <TH width="5%" scope=col>数量</TH>    
                          <TH width="15%" scope=col>特殊加工要求</TH>                         
                        </TR>
						<s:iterator value="goodsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">                         
                          <TD height="26">
                          <input type="checkbox" id="chk" cstcpodid="${cstcpodid}" onClick="setSingleValue(this);"
                           value="{'cstcpodglassesbillid':'${cstcpodglassesbillid}','cstcprdreceiptbilld':'${cstcprdreceiptbilld}','cstcpodid':'${cstcpodid}','cstcpodglassflag':'${cstcpodglassflag}','cstcpodgoodsid':'${cstcpodgoodsid}','cstcpodgoodsbarcode':'${cstcpodgoodsbarcode}','cstcpodgoodsname':'${cstcpodgoodsname}',
                           'cstcpodballglass':'${cstcpodballglass}','cstcpodpostglass':'${cstcpodpostglass}','cstcpodaxes':'${cstcpodaxes}','cstcpodadd':'${cstcpodadd}','cstcpodarriseglass':'${cstcpodarriseglass}','cstcpodbasis':'${cstcpodbasis}','cstcpodeyecurvature':'${cstcpodeyecurvature}','cstcpoddiameter':'${cstcpoddiameter}',
                           'cstcpodrequirement':'${cstcpodrequirement}','cstcpodcustomername':'${cstcpodcustomername}','cstcpodnum':'${cstcpodnum}'}">
                          </TD>
                          <TD>${cstcpodglassesbillid}</TD>
                          <TD>${cstcpodcustomername}</TD>
                          <TD>${cstcpodgoodsname}</TD>
                          <TD>${cstcpodglassflag}</TD>
                          <TD>${cstcpodballglass}</TD>
                          <TD>${cstcpodpostglass}</TD>                          
                          <TD>${cstcpodaxes}</TD>
                          <TD>${cstcpodadd}</TD>
                          <TD>${cstcpodarriseglass}</TD>
                          <TD>${cstcpodbasis}</TD>
                          <TD>${cstcpodeyecurvature}</TD> 
                          <TD>${cstcpoddiameter}</TD>  
                          <TD>${cstcpodnum}</TD> 
                          <TD>${cstcpodrequirement}</TD>                       
						</TR>
						</s:iterator>
                      </TBODY>
                    </TABLE>
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
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
