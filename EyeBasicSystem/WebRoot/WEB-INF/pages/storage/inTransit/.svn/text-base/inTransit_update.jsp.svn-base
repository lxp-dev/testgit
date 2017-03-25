<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>配镜管理</title>
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
	function clean(){
        $('input[clean=clean]').each(function(){
            $(this).val('');
        });
        $('select[clean=clean]').each(function(){
            $(this).val('');
        });
        $('#newIntransit option[value != \'\']').remove();
        document.getElementById('tt').innerText="";
	}
	function update(id){
	  if(checkForm(document.all.inTransitForm)){
	      $("img").removeAttr("onclick");
		  inTransitForm.action = "inTransitUpdate.action";
		  inTransitForm.submit();
	  }
	}
	
	/*查看*/
	function search(){
	  if(document.getElementById('salesID').value==""){
	      alert("请输入配镜单号!")
	      document.getElementById('salesID').focus();
	  }else{ 
		  $("img").removeAttr("onclick");
		  inTransitForm.action = "selectInTransitUpdate.action";
		  inTransitForm.submit();
	  }
	}	

</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } >
<form name="inTransitForm" method="post" action="" >
<input type="hidden" name="customerID" value="${requestScope.smecicustomerid }">
<input type="hidden" name="moduleID" value="${requestScope.moduleID }">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>配镜管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：在途状态调整</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
          <TR>
            <TD colSpan=2 height=20></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
          </TD>
					</TR></TBODY></TABLE>
			</TD></TR>
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
                  <DIV>
		            <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="10%" height="26" class="table_body">配镜单号</TD>
                          <TD width="26%" class="table_none">
                            <li class="horizontal_onlyRight">
                          	<input clean=clean class="text_input200" type="text"  id="salesID" name="salesID" value="${salesBasicPo.ssesbsalesid}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请输入配镜单号!'}]">
                          	</li><li class="horizontal_onlyRight"><img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title="查询" onclick="search()"></li>
                          	
                          </TD>
                          <TD width="10%" class="table_body">原在途状态</TD>
                          <TD width="26%" class="table_none" id="tt">&nbsp;
                          <input type="hidden"   id="orderType" name="orderType" value="${salesBasicPo.ssesborderstype}">
                          <input type="hidden"  id="intransit" name="intransit" value="${salesBasicPo.ssesbintransit}">
                          <c:choose>
								<c:when test="${salesBasicPo.ssesbintransit == 1 }">
									 销售完成
			                    </c:when> 
			                    <c:when test="${salesBasicPo.ssesbintransit == 2 }">
			                   		 银台结款
			                    </c:when>      
			                    <c:when test="${salesBasicPo.ssesbintransit == 3 }">
			                   		 门店配送
			                    </c:when>      
			                    <c:when test="${salesBasicPo.ssesbintransit == 4 }">
			                    	 委外订单
			                    </c:when>
			                    <c:when test="${salesBasicPo.ssesbintransit == 5 }">
			                   		 委外收货
			                    </c:when>      
			                    <c:when test="${salesBasicPo.ssesbintransit == 6 }">
			                   		 配镜发料
			                    </c:when> 
			                    <c:when test="${salesBasicPo.ssesbintransit == 7 }">
			                   		 加工初验
			                    </c:when>     
			                    <c:when test="${salesBasicPo.ssesbintransit == 8 }">
			                   		 加工师加工
			                    </c:when>      
			                    <c:when test="${salesBasicPo.ssesbintransit == 9 }">
			                   		 加工检验
			                    </c:when>      
			                    <c:when test="${salesBasicPo.ssesbintransit == 10 }">
			                   		加工配送
			                    </c:when>   
			                    <c:when test="${salesBasicPo.ssesbintransit == 11 }">
			                   		 隐形配送
			                    </c:when>    
			                    <c:when test="${salesBasicPo.ssesbintransit == 12 }">
			                   		 取镜处收货
			                    </c:when>      
			                    <c:when test="${salesBasicPo.ssesbintransit == 13 }">
			                   		 顾客取镜
			                    </c:when>      
			                    <c:when test="${salesBasicPo.ssesbintransit == 14 }">
			                   		 顾客退货
			                    </c:when>      
			                  </c:choose>  
						  </TD>
						  <TD width="10%" height="26" class="table_body">在途状态修改为</TD>
                          <TD width="26%" class="table_none" colspan="3">                                              
	                           <select clean=clean id="newIntransit" name="newIntransit" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择修改后的配镜单在途状态!'}]">
	                                <option value="">----请选择----</option>	                             	
					             <s:iterator value="inTransitList">
					               <c:if test="${sseitstate == '12' || (sseitstate == '13' && salesBasicPo.ssesbcheckoutflag == '0')}">
	                    	        <OPTION value="${sseitstate}">${sseitintransitname}</OPTION>
	                    	       </c:if>
	                    	     </s:iterator>

	      	                   </select>
						  </TD>
                        </TR> 
                        </TBODY>
                    </TABLE>
                   	<c:if test="${(permissionPo.keya==1)}"> 
					<table id="searchBar" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left">
							<img src="${ctx }/img/newbtn/btn_save_0.png" btn=btn title='保存' onclick="update()">
							<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean()">
						  </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                  	</c:if>
                 <br/>
                 <div>
                    <table cellspacing="2">
						<tr height="26">
							<td><b>在途状态调整功能用于调整配镜单的在途状态，不影响实际库存，影响在途库存 。</b></td>
						</tr>
						
						<tr height="26">
							<td><b>在当前登录人拥有特殊权限的情况下：<b/></td>
						</tr>
						
						<tr height="26">
							<td>框镜成品：配镜单在配镜发料之后，顾客取镜之前才能调整配镜单在途状态。</td>
						</tr>
						
						<tr height="26">
							<td>框镜定制：配镜单在委外订单之后，顾客取镜之前才能调整配镜单在途状态。</td>
						</tr>
						
						<tr height="26">
							<td>隐形定制：配镜单在银台结款之后，委外收货之前才能调整配镜单在途状态。</td>
						</tr>
						
						<tr height="26">
							<td><b>在当前登录人没有特殊权限的情况下：<b/></td>
						</tr>
						
						<tr height="26">
							<td>框镜成品：配镜单在配镜发料之后，顾客取镜之前才能调整配镜单在途状态。</td>
						</tr>
						
						<tr height="26">
							<td>框镜定制：配镜单在配镜发料之后，顾客取镜之前才能调整配镜单在途状态。</td>
						</tr>
						
						<tr height="26">
							<td>隐形定制：配镜单在银台结款之后，委外订单之前才能调整配镜单在途状态。</td>
						</tr>						
						
					</table>

                 </div> 	  
                  </DIV>
                </DIV>
           <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
</TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
        
<!--        <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 -->
<!--                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>-->
        </TR></TBODY></TABLE>
            <!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
