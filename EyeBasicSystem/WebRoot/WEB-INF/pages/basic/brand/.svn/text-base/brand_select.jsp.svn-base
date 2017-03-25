<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>品种维护</title>
<script src="${ctx}/js/jquery/jquery.autocomplete.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<script>

$(document).ready(function() {	
	/**Ajax----------读取项目列表-------------**/
	var url = "ajaxSelBrandList.action";
	var options = {
		width : 260,
		selectFirst : false,
		autoFill : false,
		dataType : 'json',
		selectFirst : true,
		parse : function(data) {
			var json = data.personAjax;
			for (i = 0; i < json.length; i++) {					
				json[i] = {
					data : [ json[i].split("(")[0] ],
					resulet : json[i],
					value : json[i]
				};
			}
			
			return json;
		}
	};
	// 项目
	$("#selbbdbrandname").autocomplete(url, options);
	$("#selbbdbrandname").result(
			function(event, data, formatted) {
				
				if (data) {
					
					$(this).val($.trim(formatted.split("(")[0]));
					$("#selbbdbrandid").val(
					formatted.replace(/(^.* )|[\\(\\)]/g, ""));
				}
			});
	/**Ajax----------读取项目列表-------------**/

	$("#selbbdbrandname").focus();
	
});
	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	
		if('${bbdissetflag}' == ''){
			$('#radioBtn_1').attr('checked',true);
		}
		if('${bbdissetflag}' != '3'){
			$('#bbdpayfeeid').attr("disabled","disabled");
		}
		$('#radioBtn_3').click(function(){
			$('#bbdpayfeeid').attr("disabled","");
		});
		$('#radioBtn_1').click(function(){
			$('#bbdpayfeeid').val("");
			$('#bbdpayfeeid').attr("disabled","disabled");
		})
		$('#radioBtn_2').click(function(){
			$('#bbdpayfeeid').val("");
			$('#bbdpayfeeid').attr("disabled","disabled");
		})
	});

	function search(){
		brandForm.action = "selBrand.action";
		brandForm.submit();		
		showLoadingBar();
	}	
	function detail(id, supplierID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("brandDetail.action?hid="+id + '&bbdsupplierid=' + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("brandDetail.action?hid="+id + '&bbdsupplierid=' + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【品种详细】";
	}
	function update(id, supplierID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var goodsTree=document.getElementById("goodsTree").value;
		var parent=document.getElementById("parent").value;
		if(is_iPad()){
			showPopWin("initBrandUpdate.action?hid="+id + "&parent="+parent+"&goodsTree="+goodsTree+"&bbdsupplierid=" + supplierID+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initBrandUpdate.action?hid="+id + "&parent="+parent+"&goodsTree="+goodsTree+"&bbdsupplierid=" + supplierID+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【品种更新】";
	}
	
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var goodsTree=document.getElementById("goodsTree").value;
		var parent=document.getElementById("parent").value;
		if(is_iPad()){
			showPopWin("initBrandInsert.action?goodsTree="+goodsTree+"&parent="+parent+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initBrandInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【品种新增】";
	}

	function del(id, supplierID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var goodsTree=document.getElementById("goodsTree").value;
		var parent=document.getElementById("parent").value;

		if(is_iPad()){
			showPopWin("initBrandDelete.action?hid="+id + "&parent="+parent+"&goodsTree="+goodsTree+"&bbdsupplierid="+ supplierID+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initBrandDelete.action?hid="+id + "&parent="+parent+"&goodsTree="+goodsTree+"&bbdsupplierid=" + supplierID+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【品种删除】";
	}	
	function enbled(id, supplierID, flag){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initBrandEnbled.action?hid="+id + '&bbdsupplierid=' + supplierID+"&moduleID=${requestScope.moduleID}" + '&flag=' + flag,400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initBrandEnbled.action?hid="+id + '&bbdsupplierid=' + supplierID+"&moduleID=${requestScope.moduleID}" + '&flag=' + flag,400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【品种启用/停用】";
	}
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function clean(){
		document.getElementById('selbbdid').value = "";
		document.getElementById('selbbdbrandname').value = "";
		document.getElementById('selbspcategoryid').value = "";
		$('#bspsuppliername').val("");
		$('#bbdsupplierid').val("");
		document.getElementById('isClosed').value = "";
		document.getElementById('settlement').value = "";		
		document.getElementById('bbdpayfeeid').value = "";		 
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		// 开窗条件 categoryID_open
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=" + document.all.selbspcategoryid.value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=" + document.all.selbspcategoryid.value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('bbdsupplierid').value = json.id;
		document.getElementById('bspsuppliername').value = json.value;
	}
	function changeflag(str){
		document.getElementById('bbdissetflag').value = str;
	}	

</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }> 
<form name="brandForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" />
<input type="hidden" name="goodsTree" id="goodsTree" value="${goodsTree }" />
<input type="hidden" name="cateid" id="cateid" value="${cateid }" />
<input type="hidden" name="parent" id="parent" value="${parent}" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>基础信息</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：品种维护</TD>
            <Td align="right" valign="bottom">&nbsp;
            	<img btn=btn src="${ctx }/img/newbtn/btn_brandinsert_0.png" title="品种新增" onClick="insert()">
				<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </Td>
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
          background=${ctx }/img/pic/tab_bg.gif>
				</TD></TR>
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
					  		<TD width="8%" height="26" class="table_body">商品类别</TD>
	                          <TD width="20%" class="table_none">
							  	<select id="selbspcategoryid" name="selbspcategoryid">
							  		<option value="">----请选择----</option>
							  		<s:iterator value="goodsCategorys">
									<option value="${bgcid}" ${selbspcategoryid == bgcid ? 'selected="selected"' : '' } >${bgcgoodscategoryname}</option>
		     	               		</s:iterator>
								</select></TD>
						   <TD width="8%" class="table_body">制造商</TD>
						   	<TD width="24%" height="26" align="left" class="table_none">
						   	<c:if test="${person.syspsupplierid ne ''}">
						   		<li class="horizontal_onlyRight">
						   		${person.syspsuppliername }
						   		<input type="hidden" name="selbbdsupplierid" value="${person.syspsupplierid }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
							   	</li>
						   	</c:if>
						   	<c:if test="${person.syspsupplierid eq ''}">
						   		<li class="horizontal_onlyRight">
						   		<input id="bspsuppliername" class="text_input160" name="selbspsuppliername" value="${selbspsuppliername }" readonly="readonly" />
						   		<input type="hidden" id="bbdsupplierid" name="selbbdsupplierid" value="${selbbdsupplierid }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
							   	</li>
							   	<li class="horizontal_onlyRight">
							  	<img id=ctl00_PageBody_Button1 src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" name=ctl00$PageBody$Button1 onClick="openSupplier();">
							  	</li>
						   	</c:if>
						  	</TD>
                        	<TD width="8%" height="26" class="table_body">品种代码</TD>
			               	<TD class="table_none"><input class="text_input100" type="text" id="selbbdid" name="selbbdid" value="${selbbdid }" /></TD>
                        </tr>
                        <tr>
							<TD  height="26" class="table_body">品种名称</TD>
                          	<TD class="table_none">
                          	<input class="text_input160" id="selbbdbrandname" name="selbbdbrandname" value="${selbbdbrandname }">
                          	</TD>
							<TD height="26" class="table_body">
						                     启用状态
							</TD>
							<TD class="table_none">
								<select id="isClosed" name="isClosed">
                            	<option value="">----请选择----</option>
                            	<option value="1" ${requestScope.isClosed eq 1 ? 'selected="selected"' : '' }>启用</option>
                            	<option value="0" ${requestScope.isClosed eq 0 ? 'selected="selected"' : '' }>停用</option>
								</select>
							</TD>
							
							<TD height="26" class="table_body">
						                     采购结算方式
							</TD>
							<TD class="table_none" colspan="3">
                                <select id="settlement" name="settlement">
                                    <option value="">----请选择----</option>
									<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                <c:if test="${optionParamPoTmp.fopparentid == 'jxfs'}">
		                                    <option value="${optionParamPoTmp.fopparamid }" ${(settlement == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                </c:if>	                                      	
	                                </c:forEach>
	                                <option value="empty" ${(settlement eq 'empty')? 'selected=selected' :'' }>未设置</option>
                                 </select>
							</TD>
							
                        </tr>
                        <c:if test="${systemParameterPo.fsphisflag eq '2'}">
                        <TR> 
				            <TD height="26" class="table_body">收费项目</TD>
				            <TD class="table_none" colspan="5">
								   <li class="horizontal_onlyRight">
								   <input type="hidden" id="bbdissetflag" name="bbdissetflag" value="${bbdissetflag}">
                                   <input type="radio" id="radioBtn_1" name="radioBtn" value="1" onclick="changeflag('1')" ${bbdissetflag == '1' ? 'checked' : '' }>全部
      	                           <input type="radio" id="radioBtn_2" name="radioBtn" value="2" onclick="changeflag('2')" ${bbdissetflag == '2' ? 'checked' : '' }>未设置
      	                           <input type="radio" id="radioBtn_3" name="radioBtn" value="3" onclick="changeflag('3')" ${bbdissetflag == '3' ? 'checked' : '' }>已设置
		                           </li>
								   <li class="horizontal_onlyRight">
								     <select id="bbdpayfeeid" name="bbdpayfeeid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择收费项目！'}]">
	                                   <option value="">---请选择---</option>
	                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                              <c:if test="${optionParamPoTmp.fopparentid=='his_payfee'}">
			                               <option value="${optionParamPoTmp.fopparamid }" ${(bbdpayfeeid == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
			                              </c:if>	                                      	
		                               </c:forEach> 
	                            	 </select>
		                           </li>
		      	             </TD>                
	                      </TR>
	                      	</c:if>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
						<c:if test="${(permissionPo.keyd==1)}">
							  <td>
								  <img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();" >
								  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn name="reset" title='清空' onclick="clean();" >
							  </td>
						</c:if>
							  
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
							gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
							document.getElementById("loadingBar").style.display="";
						}
					</script>                            
				    </td>
				</tr>
				</table>                      
				<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<c:if test="${not empty(brands)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="12%" scope=col colspan="4">操作</TH>
                          <TH width="10%" height="26" scope=col>品种代码</TH>
                          <TH width="45%" scope=col>品种名称</TH>
						  <th width="10%">商品类别</th>
                          <TH scope=col>制造商简称</TH>
                        </TR>
                        <c:forEach var="po" items="${brands}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="3%">
                          	<c:if test="${(permissionPo.keyg==1)}">
                          		<img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="detail('${po.bbdid }', '${po.bbdsupplierid }')">
                          	</c:if>
                          </TD>
                          <TD width="3%">
                          	<c:if test="${(permissionPo.keyb==1)}">
                          		<img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="update('${po.bbdid }', '${po.bbdsupplierid }')">
                          	</c:if>
                          </TD>
                          <TD width="3%">
                          	<c:if test="${(permissionPo.keyc==1)}">
                          		<img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="del('${po.bbdid }', '${po.bbdsupplierid }')" >
                          	</c:if>		
                          </TD>
	                   		<TD width="3%">
	                   			<c:if test="${(permissionPo.keye==1)}">
	                    			<c:if test="${po.bbdsalesstatue ne '1'}">
	                    				<img src="${ctx }/img/newbtn/unenabled_0.png" btn=btn title='启用' onClick="enbled('${po.bbdid }', '${po.bbdsupplierid }', '1')" >
	                    			</c:if>
	                    			<c:if test="${po.bbdsalesstatue eq '1'}">
	                    				<img src="${ctx }/img/newbtn/enabled_0.png" btn=btn title='停用' onClick="enbled('${po.bbdid }', '${po.bbdsupplierid }', '0')" >
	                    			</c:if>
	                   			</c:if>
	                   		</TD>
                          <TD height="26">${po.bbdid }</TD>
                          <TD>${po.bbdbrandname }</TD>
						  <td>${po.bgcgoodscategoryname } </td>
                          <TD>${po.bspsuppliername }</TD>
                        </TR>
                        </c:forEach>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
