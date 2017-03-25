<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>散瞳信息查询</title>
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

	function doList(link,perPage_Select,perPage_Text_Hidden){
     	 var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	mydriasisForm.action=link;
	  	mydriasisForm.submit();
	}
	
	function save(){
	
		if(checkForm(document.all.mydriasisForm)){
			var i = 0;
			$("input[id='chk']").each(function (){
				if (this.checked){
					i++;
				}
			});
			
			if(i == 0) {
				alert("请选择费用！");
				return ;
			}
		    var notollcount = '${notollcount}';
            if(notollcount > 0 && '${systemParameterPo.fsphisflag}' == '2' && '${person.bdplinkhisflag}' == '1'){
				alert("有"+notollcount+"项费用未维护，保存失败!");
				return ;
            }		   
	        $("img").removeAttr("onclick");
			mydriasisForm.action = "updateChargePut.action";
			mydriasisForm.submit();
		}
	}
	function getCustomer(){ 
	    if(event.keyCode==13){   
	    $("img").removeAttr("onclick");  
		mydriasisForm.action = "selMydriasisForCustomer.action";
		mydriasisForm.submit();
		}
	}
	function selChargePut(){
		var feeType = document.all.feeType;
	    var obj = document.all.frcfeetypename;
		if(feeType.value == ""){
			feeType.value = obj.options[obj.selectedIndex].value;
		}
		mydriasisForm.action = "selChargePut.action";
		$("img").removeAttr("onclick");
	    mydriasisForm.submit();
	}
	
	function details(id){
		showPopWin("","initDetailsCustomerInfo.action?hid="+id,screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	
	/*   单个汉字的宽度,根据你的字体大小自行设定   */   
  var   wordWidth   =   '14';   
  function   setWidth()   
  {   
	  obj   =   event.srcElement;   
	  obj.style.width   =   obj.value.replace(/[^\x00-\xff]/g,"**").length*wordWidth/2+5;   
  }
  /* 查询下拉列表第一个  */
  function changeValue(obj){
		var feeType = document.all.feeType;
		feeType.value = obj.options[obj.selectedIndex].value;
	}
	
	function cancelChk(){
		$("input[id='chk']").each(function (){
			this.checked = false;
		});
		document.getElementById('chks').checked = false;
	}
	
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="mydriasisForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="customerID" value="${customerID }">
<input type="hidden" name="memberid" value="${requestScope.smecimemberid}">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
 

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
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
                       <TD width="20%" height="30" class="table_body">缴费类型</TD>
			               <TD width="10%" class="table_body">
                             <select id="feeType" name="feeType" onChange="changeValue(this)">
      		                    <option value="1" ${feeType == '1' ? 'selected="selected"' : '' }>缴费</option>
      		                    <option value="2" ${feeType == '2' ? 'selected="selected"' : '' }>退费</option>
      	                     </select>
      	                   </TD>
      	                   <TD class="table_body">
      	                     <img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:selChargePut()">
			               </TD>
                      </TR>
                      </TABLE>  
                       <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
		                      <TD><img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn title='保存' onClick="save()" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '不能为空！'}]"></TD>
							</td>
						</tr>
					</table>            
<!--                   <br/>-->
                     <c:if test="${not empty(frcmoneyList)}"> 
                     <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
                      <TABLE width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title2">

                      <TR class=table_title align=middle>
                      <TH height="30" scope=col>取消 <input type="checkbox" id="chks" onclick="cancelChk()">
                      </th>
                      <TH width="90%" height="30" scope=col>费用金额</th>
                      </TR>
                      <s:iterator value="frcmoneyList">
                        <TR>
	                        <TD height="30" class="table_none" align="center"><input type="checkbox" name="chk" id="chk" value="${frcid }"></TD>
				            <TD class="table_none" >${frcregisteredname }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${frcmoney }</TD>
                        </TR>
                        </s:iterator>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      
                    </TABLE>
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
	               </c:if>
	                </TABLE>
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
            </TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>