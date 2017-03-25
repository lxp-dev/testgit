<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>库存管理</title>
</head>
<script>
		
	function search(){
		var count = 0;	
		if ($('input[name=billtypel]').attr('checked')){			
	        $('input[id=chk3]').each(function(){ 
	            if ($(this).attr('checked') == true){
	                count = accAdd(count,1);
	            }
	        });
	        if (count == 0){
	            alert('请先选择需要查看的配镜单在途信息!');
	            return;
	        }
		}
		count = 0;
        $('input[id=chk2]').each(function(){ 
            if ($(this).attr('checked') == true){
                count = accAdd(count,1);
            }
        });
        if (count == 0){
            alert('请先选择需要查看的单据类型!');
            return;
        }
        
	    $("img").removeAttr("onclick");
	    correctingErrorsFrm.action = "notAuditBillSel.action";
	    correctingErrorsFrm.submit();		
		showLoadingBar();
	}

	function clean(){
	    $('input[clean=clean]').each(function(){
            $(this).val('');
		});
	    $('input[type=checkbox][clean=clean]').each(function(){
            $(this).attr('checked',false);
		});
	    $('select[clean=clean]').each(function(){
            $(this).val('');
		});
	    $('textarea[clean=clean]').each(function(){
            $(this).val('');
		});

	    chkAll2();
	    chkAll3();
	    
    	$('#showtr').hide();
    	$('#chk3s').attr('checked',false);
	}	
	
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
			$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
			$(this).attr("src",$(this).attr("src").replace("1","0")); 
		});

		if ('${billtypel}' != ''){
			$('#showtr').show();
		}else{
			$('#showtr').hide();
		}
		
	});

	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var companyid = '';
		if ('${person.personcompanytype}' == '2'){
			companyid = '${person.personcompanyid}';
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selDepartmentOpen.action?companyid=" + companyid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentOpen.action?companyid=" + companyid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}

	/**
	 * 部门开窗赋值实现方法
	 */
	function openDepartmentValues(objValue){
		var arrayID = new Array();
		var arrayName = new Array();
		var departments = eval('(' + objValue + ')');
		for(var i = 0; i < departments.length; i++){	
			arrayID[i] = departments[i].bdpdepartmentid;
			arrayName[i] = departments[i].bdpdepartmentname;
		}
		
		document.getElementById('departmentID').value = arrayID.join(",");
		document.getElementById('bdpdepartmentname').value = arrayName.join(",");
		document.getElementById('ds').value = document.getElementById('bdpdepartmentname').value;
	}

	function batchDetele(){
		var count = 0;
		var id = '';
        $('input[id=chk]').each(function(){ 
            if ($(this).attr('checked') == true){
                count = accAdd(count,1);
                id = id + $(this).val() + ',';
            }
        });
        if (count == 0){
            alert('请先选择需要删除的单据!');
            return;
        }

        del(id.substring(0,id.length-1));
    }

	function chkAll(){  
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
    }

	function chkAll2(){  
        var chks=document.all.chk2s;
        $('input[id=chk2]').each(function(){ 
            $(this).attr("checked",chks.checked);
        });

        showSalesType(chks);
    }

	function chkAll3(){  
        var chks=document.all.chk3s;
        $('input[id=chk3]').each(function(){ 
            $(this).attr("checked",chks.checked);
        });
    }

	function showSalesType2(obj){
        if (obj.checked){
    		var count = 0;
            $('input[id=chk2]').each(function(){ 
                if ($(this).attr('checked') == false){
                    count = accAdd(count,1);
                }
            });
            if (count == 0){
            	chkOnAll2();
            }        	
        }else{
        	chkUnAll2();
        }
    }

	function showSalesType3(obj){
        if (obj.checked){
    		var count = 0;
            $('input[id=chk3]').each(function(){ 
                if ($(this).attr('checked') == false){
                    count = accAdd(count,1);
                }
            });
            if (count == 0){
            	chkOnAll3();
            }        	
        }else{
        	chkUnAll3();
        }
    }
    
	function chkUnAll2(){  
		$('#chk2s').attr('checked',false);
    }

	function chkUnAll3(){  
		$('#chk3s').attr('checked',false);
    }

	function chkOnAll2(){  
		$('#chk2s').attr('checked',true);
    }

	function chkOnAll3(){  
		$('#chk3s').attr('checked',true);
    }

    function showSalesType(obj){
        if (obj.checked){
            $('#showtr').show();
            chkOnAll3();
        	chkAll3();
        	showSalesType2(obj);
        }else{
        	$('#showtr').hide();
        	chkUnAll2();
        	chkUnAll3();
        	chkAll3();
        }
    }

	function detail(type,id){
		var DataUrl = '';
		switch(type){
			case '1':
				DataUrl = "procurementReceiptDetails.action?hid="+id+"&moduleID="+$('#moduleID').val();
				break;
			case '2':
				DataUrl = "initProcurementReturnStorageDetails.action?hid="+id+"&moduleID="+$('#moduleID').val();
				break;
			case '3':
				DataUrl = "initSalesOutDetails.action?hid="+id+"&moduleID="+$('#moduleID').val();
				break;
			case '4':
				DataUrl = "allocationDetails.action?hid="+id+"&moduleID="+$('#moduleID').val();
				break;
			case '5':
			case '6':
				DataUrl = "initOveragelossesDetails.action?hid="+id+"&moduleID="+$('#moduleID').val();
				break;
			case '7':
				DataUrl = "otherReceiptDetails.action?hid="+id+"&moduleID="+$('#moduleID').val();
				break;
			case '8':
				DataUrl = "returnOtherDatabaseManagementDetails.action?hid="+id+"&moduleID="+$('#moduleID').val();
				break;
			case '10':
				DataUrl = "initTakeOutDetails.action?hid="+id+"&moduleID="+$('#moduleID').val();
				break;
			case '11':
				DataUrl = "initStoreGoodsDetails.action?hid="+id+"&moduleID="+$('#moduleID').val();
				break;
			case '12':
				DataUrl = "initStoreReturnGoodsDetails.action?hid="+id+"&moduleID="+$('#moduleID').val();
				break;
			case '13':
				DataUrl = "selectInTransitDetails.action?hid="+id+"&moduleID="+$('#moduleID').val();
				break;
			default:
				return;
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin(DataUrl,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(DataUrl,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【未完结单据明细】";
	}

	function del(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		showPopWin("initNotAuditBillDetele.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),false);		
		document.getElementById('popupTitle').innerHTML="【未完结单据删除】";
	}

	function doit(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		showPopWin("initSalesBillInTransitUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),false);		
		document.getElementById('popupTitle').innerHTML="【配镜单处理】"; 
	}
    
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="correctingErrorsFrm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>库存管理 </TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：未完结单据查询 </TD>
            <td align="right" valign="bottom">&nbsp;
				<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
			<TD class=menubar_function_text colspan="3">
				<table></table></TD>
		  </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
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
							<TD height="26" class="table_body">查看单据</TD>
							<TD class="table_none">
                                <input class="text_input160" type="text" clean=clean id="changeBillID" name="changeBillID" value="${changeBillID}">
							</TD>
							<TD height="26" class="table_body">查看日期</TD>
			               <TD class="table_none">
                            <li class="horizontal_onlyRight"><input id="startTime"
					       name="startTime" 
					       type="text" class="text_input80" clean=clean  
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${startTime }" /> 至 
					       <input id="endTime" clean=clean 
					       name="endTime" 
					       type="text" class="text_input80" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime }" /> 
					        </li>
					        <li class="horizontal_onlyRight">
							<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today('startTime','endTime')"></li>
							<li class="horizontal_onlyRight">
							<img src="${ctx }/img/newbtn/btn_month_0.png" btn=btn title="当月" onClick="currtMonth('startTime','endTime')"></li>								
							</TD>
							<TD height="26" class="table_body">查看部门</TD>
							<TD class="table_none">
				               <c:if test="${person.departmenttype!=1}">
					               <li class="horizontal_onlyRight">
								   		<input class="text_input300" clean=clean id="bdpdepartmentname" name="bdpdepartmentname" type="hidden" value="${bdpdepartmentname }"  />
								   		<textarea class="text_input200" clean=clean id="ds"  name="ds" value="${bdpdepartmentname}"   style='height:50px' readonly="readonly" >${bdpdepartmentname}</textarea>								   		
								   		<input type="hidden" clean=clean id="departmentID" name="departmentID" value="${departmentID }" />
								   </li>
								   <li class="horizontal_onlyRight">
								  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onClick="openDepartment();">
								   </li>
								</c:if>  
							   <c:if test="${person.departmenttype==1}">
		                            ${person.bdpdepartmentname}<input type="hidden" id="departmentID" value="${person.departmentID}" name="departmentID"/>
		                            <input type="hidden" id="bdpdepartmentname" value="${person.bdpdepartmentname}" name="bdpdepartmentname"/>
		      	               </c:if>
							</TD>
			            </tr>
			            <TR>
							<TD height="26" class="table_body">查看类型</TD>
							<TD class="table_none" colspan="3">
                                <input type="checkbox" clean=clean id="chk2s" name="chk2s" onclick="chkAll2();" ${chk2s eq '' ? '' : 'checked="checked"' }>全部单据
                                <br/>
                                <input type="checkbox" id="chk2" name="billtypea" ${billtypea eq '' ? '' : 'checked="checked"' } onclick="showSalesType2(this);">采购收货单
                                <input type="checkbox" id="chk2" name="billtypeb" ${billtypeb eq '' ? '' : 'checked="checked"' } onclick="showSalesType2(this);">采购退货单
                                <input type="checkbox" id="chk2" name="billtypec" ${billtypec eq '' ? '' : 'checked="checked"' } onclick="showSalesType2(this);">销售出库单
                                <input type="checkbox" id="chk2" name="billtyped" ${billtyped eq '' ? '' : 'checked="checked"' } onclick="showSalesType2(this);">调拨单
                                <input type="checkbox" id="chk2" name="billtypee" ${billtypee eq '' ? '' : 'checked="checked"' } onclick="showSalesType2(this);">盘盈单
                                <input type="checkbox" id="chk2"  name="billtypef" ${billtypef eq '' ? '' : 'checked="checked"' } onclick="showSalesType2(this);">盘亏单
                                <br/>
                                <input type="checkbox" id="chk2" name="billtypeg" ${billtypeg eq '' ? '' : 'checked="checked"' } onclick="showSalesType2(this);">其他入库单
                                <input type="checkbox" id="chk2" name="billtypeh" ${billtypeh eq '' ? '' : 'checked="checked"' } onclick="showSalesType2(this);">其他出库单
                             <!--    <input type="checkbox" id="chk2" name="billtypei" ${billtypei eq '' ? '' : 'checked="checked"' } onclick="showSalesType2(this);">委外收货单  -->
                                <input type="checkbox" id="chk2" name="billtypej" ${billtypej eq '' ? '' : 'checked="checked"' } onclick="showSalesType2(this);">客户调货单
                                <input type="checkbox" id="chk2" name="billtypek" ${billtypek eq '' ? '' : 'checked="checked"' } onclick="showSalesType2(this);">客户退货单
                                <input type="checkbox" id="chk2" name="billtypel" ${billtypel eq '' ? '' : 'checked="checked"' } onclick="showSalesType(this);">配镜单
                                <input type="checkbox" id="chk2" name="billtypem" ${billtypem eq '' ? '' : 'checked="checked"' } onclick="showSalesType2(this);">领用出库单
							</TD>
							<TD height="26" class="table_body">制单人</TD>
							<TD class="table_none">
                                <input class="text_input120" type="text" clean=clean id="createPersonID" name="createPersonID" value="${createPersonID}">
							</TD>
			            </tr>
			            <TR id="showtr">
							<TD height="26" class="table_body">配镜单在途</TD>
							<TD class="table_none" colspan="5">
                                <input type="checkbox" clean=clean id="chk3s" name="chk3s" onclick="chkAll3();" ${chk3s eq '' ? '' : 'checked="checked"' }>全部配镜单
                                <br/>
                                <input type="checkbox" id="chk3" name="salesbilltypea" ${salesbilltypea eq '' ? '' : 'checked="checked"' } onclick="showSalesType3(this);">销售完成
                                <input type="checkbox" id="chk3" name="salesbilltypeb" ${salesbilltypeb eq '' ? '' : 'checked="checked"' } onclick="showSalesType3(this);">发料之前
                                <input type="checkbox" id="chk3" name="salesbilltypec" ${salesbilltypec eq '' ? '' : 'checked="checked"' } onclick="showSalesType3(this);">隐形配送
							</TD>
			            </tr>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
							<c:if test="${(permissionPo.keya==1)}">
							 <img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
							 <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">							 
							</c:if>
							<c:if test="${(permissionPo.keyc==1)}">
							<img src="${ctx }/img/newbtn/btn_plsc_0.png" btn=btn title='批量删除' onClick="batchDetele()">
							</c:if>
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
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->	
					<c:if test="${not empty(correctingErrorsList)}"> 
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
                          <TH width="4%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>
                          <TH width="15%" height="26" scope=col colspan="3">操作</TH>
                          <TH width="18%" height="26" scope=col>单据编号</TH>
                           <TH width="8%" scope=col>单据类型</TH>
                          <TH width="15%" height="26" scope=col>制单部门/接收部门</TH>
                          <TH width="8%" scope=col>制单人</TH>
                          <TH width="15%" scope=col>制单日期</TH>
						  </TR>
						<s:iterator value="correctingErrorsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD>
                              <c:if test="${cerrisdispose ne '1'}">
                                  <input type="checkbox" id="chk" value="${cerrchangeid}">
                              </c:if>
                          </TD>
                          <TD width="3%">
	                          <c:if test="${(permissionPo.keyd==1)}">
			                      <img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="javascript:detail('${cerrbilltype}','${cerrchangeid}')">
				              </c:if>
			              </TD>
			              <TD width="3%">
			                  <c:if test="${(permissionPo.keyb==1)}">
				                  <c:if test="${cerrisdelete eq '1'}">
			                          <img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除'  onClick="javascript:del('${cerrchangeid}')">
			                      </c:if>
		                      </c:if>
			              </TD>
			              <TD width="3%">
			                  <c:if test="${(permissionPo.keye==1)}">
				                  <c:if test="${cerrisdispose eq '1'}">
			                          <img src="${ctx }/img/newbtn/doit_0.png" btn=btn title='处理' onClick="javascript:doit('${cerrchangeid}')">
			                      </c:if>
		                      </c:if>
			              </TD>
                          <TD height="26">${cerrchangeid}</TD>                          
                          <TD>
                              <c:choose>
                                  <c:when test="${cerrbilltype eq '1'}">采购收货单</c:when>
                                  <c:when test="${cerrbilltype eq '2'}">采购退货单</c:when>
                                  <c:when test="${cerrbilltype eq '3'}">销售出库单</c:when>
                                  <c:when test="${cerrbilltype eq '4'}">调拨单</c:when>
                                  <c:when test="${cerrbilltype eq '5'}">盘盈单</c:when>
                                  <c:when test="${cerrbilltype eq '6'}">盘亏单</c:when>
                                  <c:when test="${cerrbilltype eq '7'}">其他入库单单</c:when>
                                  <c:when test="${cerrbilltype eq '8'}">其他出库单单</c:when>
                                  <c:when test="${cerrbilltype eq '9'}">委外收货单</c:when>
                                  <c:when test="${cerrbilltype eq '10'}">领用出库单</c:when>
                                  <c:when test="${cerrbilltype eq '11'}">客户调货单</c:when>
                                  <c:when test="${cerrbilltype eq '12'}">客户退货单</c:when>
                                  <c:when test="${cerrbilltype eq '13'}">配镜单</c:when>
                                  <c:otherwise>&nbsp;</c:otherwise>
                              </c:choose>
                          </TD>
                          <TD>${cerrdepartmentname}</TD>
                          <TD>${cerrpersonname}</TD>
                          <TD>${cerrdate}</TD>
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
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>