<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>制造商维护</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	function save(){
		if(checkForm(document.all.supplierForm)){ 
			var goodsCategoryID=$("input[id=chk]");
	    	var check=0; 
        	for(var i=0;i <goodsCategoryID.length;i++){ 
         		if(goodsCategoryID[i].checked){ 
          			check=1; 
         		} 
        	} 
       		if(check == 0){ 
          		alert("请选择下载品牌!"); 
       			return false; 
       		}

        	$("img").removeAttr("onclick");
			supplierForm.action = "setDownloadBrand.action";
			supplierForm.submit();
			showLoadingBar()
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
        }
    }

	function downloadGoodSingle(categoryid,supperid,brandid){

	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("downloadGoodsSingleSel.action?categoryid="+categoryid+"&supperid="+supperid+"&brandid="+brandid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("downloadGoodsSingleSel.action?categoryid="+categoryid+"&supperid="+supperid+"&brandid="+brandid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【商品下传】";
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="supplierForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<input type="hidden" name="goodsTree" id="goodsTree" value="${goodsTree }" /> 
<input type="hidden" name="parent" id="parent" value="${parent }" /> 
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR height="20">&nbsp;</TR>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
            </TD>
					</TR></TBODY></TABLE></TD>
					
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
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="9%" height="26" class="table_body">制造商代码</TD>
			               <TD width="19%" class="table_none">${supplierPo.bspid}
                            <input type="hidden" id="bspid" name="brandPo.bbdsupplierid" value="${supplierPo.bspid}">
			               </TD>
			               <TD width="9%" height="26" class="table_body">制造商简称</TD>
			               <TD width="22%" class="table_none">
                             ${supplierPo.bspsuppliername}
			               </TD>
			               <TD height="26" class="table_body">制造商全称</TD>
			               <TD class="table_none">
                             ${supplierPo.bspfroshort }
			               </TD>
                        </TR>
                        <TR>
						   <TD height="26" class="table_body">商品类别</TD>
			               <TD  class="table_none" colspan="5">
                             <c:forEach items="${goodsCategoryList}" var="goodsCategoryList" varStatus="linerole">
                             	${goodsCategoryList.flag == '1' ? goodsCategoryList.bgcgoodscategoryname : ''}
                             </c:forEach>
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <br/>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>  
                          <TH width="10%" height="26" scope=col>品种代码</TH>
                          <TH width="50%" scope=col>品种名称</TH>
                          <th width="10%">商品类别</th>
                        </TR>
                        <c:forEach var="po" items="${brands}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">
                          	<c:choose>
                          			<c:when test="${po.bspcategoryid eq '1' }">
                          				<img src="${ctx}/img/newbtn/btn_downloadgoods_0.png" btn=btn onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_downloadgoods_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_downloadgoods_0.png');" title="商品下载" 
							  onClick="javascript:downloadGoodSingle('${po.bspcategoryid }','${supplierPo.bspid}','${po.bbdid }');">
                          			</c:when>
                          			<c:when test="${po.bspcategoryid eq '6' }">
                          				<img src="${ctx}/img/newbtn/btn_downloadgoods_0.png" btn=btn onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_downloadgoods_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_downloadgoods_0.png');" title="商品下载" 
							  onClick="javascript:downloadGoodSingle('${po.bspcategoryid }','${supplierPo.bspid}','${po.bbdid }');">
                          			</c:when>
                          			<c:otherwise>
                          				<input type="checkbox" id="chk" name="brandPo.bbdids" value="${po.bbdid }">
                          			</c:otherwise>
                          		</c:choose>
                          </TD>
                          <TD height="26">${po.bbdid }
                          		<c:choose>
                          			<c:when test="${po.bspcategoryid eq '1' }">
                          				
                          			</c:when>
                          			<c:when test="${po.bspcategoryid eq '6' }">
                          				
                          			</c:when>
                          			<c:otherwise>
                          			（${po.bbddownloadflag }）
                          			</c:otherwise>
                          		</c:choose>
                          		</TD>
                          <TD>${po.bbdbrandname }</TD>
                          <td>${po.bgcgoodscategoryname } </td>
                        </TR>
                        </c:forEach>
                      </TBODY>
                    </TABLE>
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
                    <TABLE id="title2" cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          	<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="button1" title='保存' onClick="save()">
                          </TD>
						  </TR>
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