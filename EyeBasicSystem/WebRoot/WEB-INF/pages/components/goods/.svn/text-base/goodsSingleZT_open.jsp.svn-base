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
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});

	function inTransitDetail(goodsid,goodsbarcode,warehouseid,flag){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;	
		if(is_iPad()){
			showPopWin("getGoodsInTransitDetail.action?goodsID="+goodsid+"&goodsBarCode="+goodsbarcode+"&warehouseID="+warehouseid+"&flag="+flag,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("getGoodsInTransitDetail.action?goodsID="+goodsid+"&goodsBarCode="+goodsbarcode+"&warehouseID="+warehouseid+"&flag="+flag,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【商品在途库存详细】";
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="app" value="${app}">
<input type="hidden" id='categoryID_open' name="categoryID_open" value="${categoryID_open }" />
<input type="hidden" id='categoryID' name="categoryID" value="${goodscategoryID}" />
<input type="hidden" id='supplierID_open' name="supplierID_open" value="${supplierID_open }" />
<input type="hidden" id='brandID_open' name="brandID_open" value="${brandID_open }" />
<input type="hidden" id='stockid' name="stockid" value="${stockid }" />
<input type="hidden" id="isrefresh" value="1" />
<input type="hidden" id="isguaranteeperiod" name="isguaranteeperiod" value="${systemParameterPo.fspstealtheffective }" />
<input type="hidden" name="jm" value="${jm }"/>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD colspan="3" align="right">
            	<br/></TD>
          </TR>
        </TBODY>
      </TABLE>
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
                     </TABLE>
                <!--    
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
				 -->
					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>                     
                          <c:choose>
                          	<c:when test="${goodscategoryID == '1' }">
                          	<TH scope=col width="15%" height="26">商品代码</TH>
                          	<TH scope=col width="15%">商品条码</TH>
	                          <TH scope=col width="15%">商品名称</TH>
	                          <TH scope=col width="6%">型号</TH>
	                          <TH scope=col width="6%">单位</TH>
	                           <TH scope=col width="8%">厂家色号 </TH>
	                           <TH scope=col width="8%">镜架材质 </TH>
	                           <TH scope=col width="8%">镜架尺寸</TH> 
                          	</c:when>
                          	<c:when test="${goodscategoryID == '2' }">
                          		<TH scope=col width="15%" height="26">商品代码</TH>
                          		<TH scope=col width="15%">商品条码</TH>
	                         	<TH scope=col width="15%">商品名称</TH>
	                         	<TH scope=col width="6%">型号</TH>
	                          	<TH scope=col width="5%">单位</TH>
	                           	<TH scope=col width="8%">配件型 </TH>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '3'}">
                          		<TH scope=col width="15%" height="26">商品代码</TH>
                          		<TH scope=col width="15%">商品条码</TH>
	                          	<TH scope=col width="15%">商品名称</TH>
	                          	<TH scope=col width="5%">单位</TH>
	                          	<TH scope=col width="5%">球镜</TH>
	                           	<TH scope=col width="5%">柱镜 </TH>
	                           	<TH scope=col width="5%">下加光 </TH>
	                           	<TH scope=col width="5%">折射率</TH> 
	                           	<TH scope=col width="5%">光度分类 </TH>
	                           	<TH scope=col width="5%">材料分类</TH> 
	                           	<TH scope=col width="5%">渐进片分类</TH> 
                          		<TH scope=col width="5%">镜片功能</TH> 
                          	</c:when>
                          	<c:when test="${goodscategoryID == '4'}">
                          		<TH scope=col width="15%" height="26">商品代码</TH>
                          		<TH scope=col width="15%">商品条码</TH>
	                          	<TH scope=col width="15%">商品名称</TH>
	                          	<TH scope=col width="5%">单位</TH>
	                          	<TH scope=col width="6%">球镜</TH>
	                           	<TH scope=col width="6%">柱镜 </TH>
	                           	<TH scope=col width="6%">曲率 </TH>
	                           	<TH scope=col width="6%">直径</TH> 
	                           	<TH scope=col width="6%">使用类型 </TH>
	                           	<TH scope=col width="6%">抛弃型分类</TH>                          	
                          	</c:when>
                          	<c:when test="${goodscategoryID == '5' }">
                          		<TH scope=col width="15%" height="26">商品代码</TH>
                          		<TH scope=col width="15%">商品条码</TH>
	                         	<TH scope=col width="15%">商品名称</TH>
	                         	<TH scope=col width="6%">型号</TH>
	                          	<TH scope=col width="5%">单位</TH>
	                           	<TH scope=col width="15%">主容量 </TH>
	                           	<TH scope=col width="15%">次容量 </TH>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '6' }">
                          		<TH scope=col width="15%" height="26">商品代码</TH>
                          		<TH scope=col width="15%">商品条码</TH>
	                         	<TH scope=col width="15%">商品名称</TH>
	                         	<TH scope=col width="6%">型号</TH>
	                          	<TH scope=col width="5%">单位</TH>
	                           	<TH scope=col width="15%">厂家色号 </TH>
	                           	<TH scope=col width="15%">镜架尺寸 </TH>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '8' }">
                          		<TH scope=col width="15%" height="26">商品代码</TH>
                          		<TH scope=col width="15%">商品条码</TH>
	                         	<TH scope=col width="15%">商品名称</TH>
	                         	<TH scope=col width="6%">型号 </TH>
	                          	<TH scope=col width="5%">单位</TH>
                          		<TH scope=col width="7%">老花镜度数</TH>
	                           	<TH scope=col width="7%">镜架尺寸 </TH>  
	                           	<TH scope=col width="7%">厂家色号 </TH>                        		
                          	</c:when>
                          	<c:when test="${goodscategoryID == '9' }">
                          		<TH scope=col width="15%" height="26">商品代码</TH>
                          		<TH scope=col width="15%">商品条码</TH>
	                         	<TH scope=col width="15%">商品名称</TH>
	                         	<TH scope=col width="6%">型号</TH>
	                          	<TH scope=col width="5%">单位</TH>
                          	</c:when>
                          	<c:otherwise>
                          		<TH scope=col width="15%">商品代码</TH>
                          		<TH scope=col width="15%">商品条码</TH>
	                         	<TH scope=col width="15%" height="26">商品名称</TH>
	                         	<TH scope=col width="6%">型号</TH>
	                          	<TH scope=col width="5%">单位</TH>
                          	</c:otherwise>
						 </c:choose>  
						        <TH scope=col width="7%">零售价</TH> 
						        <c:if test="${not empty(jm)}">
						        <TH scope=col width="7%">批发价</TH>
						        </c:if>
						        <TH scope=col width="7%">仓位</TH>
	                          	<TH scope=col width="7%">库存数量</TH>
	                         <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 	 
	                          	<TH scope=col width="7%">在途数量</TH>
	                         </c:if> 	                                                                               
						  </TR>
						<s:iterator value="goodsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">                         
                           <c:choose>
                          	<c:when test="${goodscategoryID == '1' }">
	                          	 <TD>${bgigoodsid}</TD>
	                          	 <TD>${bgigoodsbarcode}</TD>
	                         	 <TD>${bgiviewgoodsname}</TD>
	                         	 <TD >${bgispec}</TD>
	                          	 <TD>${bgiunitname}</TD>
	                             <TD scope=col >${bgisuppliercolor} </TD>
	                             <TD scope=col >${bgiframematerialtypename}</TD>
	                             <TD scope=col >${bgiframesize}</TD> 
                          	</c:when>
                          	<c:when test="${goodscategoryID == '2' }">
                          	 	<TD>${bgigoodsid}</TD>
                          	 	<TD>${bgigoodsbarcode}</TD>
	                         	 <TD>${bgiviewgoodsname}</TD>
	                          	 <TD>${bgispec}</TD>
                          		 <TD scope=col >${bgiunitname} </TD>
	                        	 <TD scope=col >
		                          	<c:if test="${bgiaccessoriestype=='1'}"> 框镜</c:if>
		                          	<c:if test="${bgiaccessoriestype=='2'}"> 隐形</c:if>
	                           </TD>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '3'}">
                          		 <TD>${bgigoodsid}</TD>
                          		 <TD>${bgigoodsbarcode}</TD>
	                         	 <TD>${bgiviewgoodsname}</TD>
	                          	 <TD>${bgiunitname}</TD>
                          		 <TD scope=col >
                          		<c:choose>
                          			<c:when test="${not empty bgisph}">${bgisph}</c:when>
		                          	<c:otherwise>${bgisphul} <c:if test="${not empty bgisphul}">/</c:if>${bgisphup }</c:otherwise>
	                          	</c:choose>
                          		</TD>
                          		<TD scope=col >
                          		<c:choose>
		                          	<c:when test="${not empty bgicyl}">${bgicyl}</c:when>
		                          	<c:otherwise>${bgicylul} <c:if test="${not empty bgisphul}">/</c:if>${bgicylup}</c:otherwise>
	                          	</c:choose>
                          		</TD>
                          		<TD scope=col >
                          		<c:choose>
		                          	<c:when test="${not empty bgibelowplusluminosity}">${bgibelowplusluminosity}</c:when>
		                          	<c:otherwise>${bgibelowplusluminosityul} <c:if test="${not empty bgibelowplusluminosityul}">/</c:if>${bgibelowplusluminosityup}</c:otherwise>
	                          	</c:choose>
                          		</TD>
                          		<TD scope=col >${bgirefractive} </TD>
	                        	<TD scope=col >
		                          	<c:if test="${bgiismutiluminosity=='M'}"> 多光</c:if>
		                          	<c:if test="${bgiismutiluminosity=='0'}"> 单光</c:if>
		                          	<c:if test="${bgiismutiluminosity=='Q'}"> 其它</c:if>
		                          	<c:if test="${bgiismutiluminosity=='K'}"> 抗疲劳</c:if>
		                          	<c:if test="${bgiismutiluminosity=='J'}"> 渐近</c:if>
	                           </TD>
	                           <TD scope=col>
		                          	<c:if test="${bgieyeglassmaterialtype=='1'}"> 树脂</c:if>
		                          	<c:if test="${bgieyeglassmaterialtype=='2'}"> 玻璃</c:if>
		                          	<c:if test="${bgieyeglassmaterialtype=='3'}"> PC</c:if>		                          	
	                           </TD>
	                           <TD scope=col >
		                          	<c:if test="${bgigradualclass=='1'}">青少年渐进</c:if>
		                          	<c:if test="${bgigradualclass=='2'}"> 成人渐进</c:if>	                          	
	                           </TD>
	                           <TD scope=col >
		                          	<c:if test="${bgifunctionclass=='1'}">白色片</c:if>
		                          	<c:if test="${bgifunctionclass=='2'}">变色片</c:if>	 
		                          	<c:if test="${bgifunctionclass=='3'}">偏光片</c:if>
		                          	<c:if test="${bgifunctionclass=='4'}"> 变色偏光片</c:if>	
		                          	<c:if test="${bgifunctionclass=='5'}">染色片</c:if>
		                          	<c:if test="${bgifunctionclass=='6'}"> 抗疲劳片</c:if>
		                          	<c:if test="${bgifunctionclass=='7'}"> 抗疲劳变色片</c:if>
		                          	<c:if test="${bgifunctionclass=='8'}"> 偏光抗疲劳片</c:if>	                         	
	                           </TD>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '4'}">
                          	 <TD>${bgigoodsid}</TD>
                          	 <TD>${bgigoodsbarcode}</TD>
	                         	 <TD>${bgiviewgoodsname}</TD>
	                          	 <TD>${bgiunitname}</TD>
                          		 <TD scope=col >
                          		<c:choose>
                          			<c:when test="${not empty bgisph}">${bgisph}</c:when>
		                          	<c:otherwise>${bgisphul} <c:if test="${not empty bgisphul}">/</c:if>${bgisphup}</c:otherwise>
	                          	</c:choose>
                          		</TD>
                          		<TD scope=col >
                          		<c:choose>
		                          	<c:when test="${not empty bgicyl}">${bgicyl}</c:when>
		                          	<c:otherwise>${bgicylul} <c:if test="${not empty bgisphul}">/</c:if>${bgicylup}</c:otherwise>
	                          	</c:choose> 
	                          	</TD>
                          		<TD scope=col >
                          		<c:choose>
		                          	<c:when test="${not empty bgicurvature1}">${bgicurvature1}</c:when>
		                          	<c:otherwise>${bgicurvature1ul} <c:if test="${not empty bgicurvature1ul}">/</c:if>${bgicurvature1up}</c:otherwise>
	                          	</c:choose> 
                          		</TD>
                          		<TD scope=col >
                          		<c:choose>
		                          	<c:when test="${not empty bgidia}">${bgidia}</c:when>
		                          	<c:otherwise>${bgidiaul} <c:if test="${not empty bgidiaul}">/</c:if>${bgidiaup}</c:otherwise>
	                          	</c:choose> 
                          		</TD>
	                        	<TD scope=col >
		                          	<c:if test="${bgiusetype=='1'}"> 常带型</c:if>
		                          	<c:if test="${bgiusetype=='2'}">抛弃型</c:if>		                          	
	                           </TD>
	                           <TD scope=col >
		                          	<c:if test="${bgistealthclass=='1'}"> 日抛</c:if>
		                          	<c:if test="${bgistealthclass=='2'}"> 周抛</c:if>
		                          	<c:if test="${bgistealthclass=='9'}"> 双周抛</c:if>
		                          	<c:if test="${bgistealthclass=='3'}"> 月抛</c:if>		
		                          	<c:if test="${bgistealthclass=='4'}"> 季抛</c:if>
		                          	<c:if test="${bgistealthclass=='5'}"> 半年抛</c:if>
		                          	<c:if test="${bgistealthclass=='6'}"> 年抛</c:if>	  
		                          	<c:if test="${bgistealthclass=='7'}"> RGP</c:if>	                         	
	                           </TD>
                          		
                          		
                          	</c:when>
                          
                          	<c:when test="${goodscategoryID == '5' }">
                          	 <TD>${bgigoodsid}</TD>
                          	 <TD>${bgigoodsbarcode}</TD>
	                         	 <TD>${bgiviewgoodsname}</TD>
	                         	 <TD scope=col >${bgispec} </TD>
	                          	 <TD>${bgiunitname}</TD>
                          		 <TD scope=col >${bgicapacity} </TD>
                          		 <TD scope=col >${bgicapacityentry} </TD>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '6' }">
                          	 <TD>${bgigoodsid}</TD>
                          	 <TD>${bgigoodsbarcode}</TD>
	                         	 <TD>${bgiviewgoodsname}</TD>
	                         	 <TD scope=col >${bgispec} </TD>
	                          	 <TD>${bgiunitname}</TD>
                          		 <TD scope=col >${bgisuppliercolor} </TD>
                          		 <TD scope=col >${bgiframesize} </TD>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '8' }">
                          	 	 <TD>${bgigoodsid}</TD>
                          	 	 <TD>${bgigoodsbarcode}</TD>
	                         	 <TD>${bgiviewgoodsname}</TD>
	                         	 <TD scope=col >${bgispec} </TD>
	                          	 <TD>${bgiunitname}</TD>
                          		 <TD scope=col >${bgisph} </TD>
                          		 <TD scope=col >${bgiframesize} </TD>
                          		 <TD scope=col >${bgisuppliercolor} </TD>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '9' }">
                          	 	 <TD>${bgigoodsid}</TD>
                          	 	 <TD>${bgigoodsbarcode}</TD>
	                         	 <TD>${bgiviewgoodsname}</TD>
	                         	 <TD scope=col >${bgispec} </TD>
	                          	 <TD>${bgiunitname}</TD>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '7' }">
                          	 	<TD>${bgigoodsid}</TD>
                          	 	<TD>${bgigoodsbarcode}</TD>
	                         	 <TD>${bgiviewgoodsname}</TD>
	                         	 	<TD scope=col >${bgispec} </TD>
	                          	 <TD>${bgiunitname}</TD>
                          	</c:when>
                          	<c:otherwise>
                         		 <TD>${bgigoodsid}</TD>
                         		 <TD>${bgigoodsbarcode}</TD>
	                         	 <TD>${bgiviewgoodsname}</TD>
	                         	 <TD>${bgispec}</TD>
	                          	 <TD>${bgiunitname}</TD>
                            </c:otherwise>
						 </c:choose>
						 		 <TD height="26">${bgiretailprice}</TD>
						 		 <c:if test="${not empty(jm)}">
						 		 <TD>${bgiwholesaleprice }</TD>
						 		 </c:if>
						 		 <TD>${bgiwarehousename}</TD>
	                          	 <TD>${bgigoodsquantity}</TD>
	                           <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 	 
	                          	 <TD><a href="javascript:inTransitDetail('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid}','0');">${bgiintransitgoodsnum}</a></TD>
	                           </c:if>
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
    <TD height=5>&nbsp;</TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>