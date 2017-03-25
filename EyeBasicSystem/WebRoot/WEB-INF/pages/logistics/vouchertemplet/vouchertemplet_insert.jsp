<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>其他付款单管理</title>
<script type="text/javascript">
       
	/**
	 *  清除表格中所有行
	 */        
	 function delRows(){
	    var chk = document.getElementsByName("chk");
		var table = document.getElementById('addTable');
		for(i = 0; i < chk.length; i++){
			var curRow = chk[i].parentNode.parentNode;		
			table.deleteRow(curRow.rowIndex);
			i = -1;
		}
        amount();
     }
	
	/**
	 *  增加其他付款单
	 */        
	 function save(){	
	    if (checkForm(insertPayMentFrm)){
        	var direction = document.getElementsByName("voucherTempletTempPo.sLvtvtBalanceDirection");
        	var jcount = 0;
        	var dcount = 0;
	        for (var i = 0; i < direction.length; i++){
	            if (direction[i].value == 'j'){
	            	jcount = accAdd(jcount,1);
	            }
	            if (direction[i].value == 'd'){
	            	dcount = accAdd(dcount,1);
	            }
	        }
            if (jcount == 0 || dcount == 0 ){
                alert('借方和贷方金额不等!');
                return;
            }
            
		    var chk = document.getElementsByName("chk").length;	     
	        if (chk != 0){ 
	        	var obj = document.getElementsByName("voucherTempletTempPo.sLvtvtSubjectID");
		        for (var i = 0; i < obj.length; i++){
		            if (obj[i].value == '' || obj[i].value == null){
		                alert("请选择科目!");
		                return;
		            }
		        }
		        insertPayMentFrm.action = "voucherTempletInsert.action";
	            $("img").removeAttr("onclick");   
		        insertPayMentFrm.submit();  

		            
	        } else{
	            alert('请先选择数据!');
	        }
	        return; 
	    }    

	 }

    var index = 0;
	function addRow(){
		var table = document.getElementById('addTable');
		index = accAdd(index,table.rows.length - 1);

		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		
		row.className = 'row';
		c1.height="26";
		
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" >';
        c2.innerHTML = '<select id="balanceDirection" name="voucherTempletTempPo.sLvtvtBalanceDirection">'
                        +'<option value="j" selected="selected"}>借</option><option value="d">贷</option></select>';
    
		c3.innerHTML = '<li class="horizontal_onlyRight"><input id=InOrOutComeType'+index+' readonly="readonly" class="text_input200" />'
		               +'<input type="hidden" id=InOrOutComeTypeID'+index+' name="voucherTempletTempPo.sLvtvtSubjectID" /></li>'
		              +'<li class="horizontal_onlyRight"><img btn=btn src="${ctx}/img/newbtn/btn_change_0.png" onClick="openSubject('+index+');" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/btn_change_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/btn_change_0.png\');" style="cursor: hand;"/></li>';          		
		       
		c4.innerHTML = '<select id="hbExpressions" name="voucherTempletTempPo.sLvtvtHExpressions">'
                      +'<option value="select @subjectID,isnull(sum(L_PB_PBE_PayMentAmount),0.00) from L_PB_PBE_PaymentBillEntry where L_PB_PBE_BillID in (select distinct L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=@voucherID)">付款金额</option>'
                      +'<option value="select @subjectID,isnull(sum(L_FA_ME_ReceiptMentAmount),0.00) from L_FA_ME_ReceiptMentEntry where L_FA_ME_ReceiptMentBillID in (select distinct L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=@voucherID)">收款金额</option>'
                      +'<option value="select @subjectID,isnull(sum(L_VE_VE_CostPriceAmount),0.00) from L_VE_VoucherEntry where L_VE_VE_VoucherID=@voucherID">预付款及冲账金额</option>' 
    }
   
    /**
	 *  删除表格中选中的行
	 */	       
	 function del(){
	    var chk = document.getElementsByName("chk");
		var table = document.getElementById('addTable');
		for(var i = 0; i < chk.length; i++){
			if (chk[i].checked) {
				var curRow = chk[i].parentNode.parentNode;		
				table.deleteRow(curRow.rowIndex);
				i = -1;
			}
		}				
		document.all.chks.checked = false;
	 }

	/**
	 *  checkbox全选
	 */	
	function chkAll(){  
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
    }
   
    /**
	 * 科目开窗
	 */ 
     function openSubject(value){
        document.getElementById("indexs").value = value;
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selSubjectOpenTree.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSubjectOpenTree.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【会计科目查询】";
     }
     
    /**
	 * 科目开窗赋值
	 */ 
     function openSubjectValue(json){         
         var indes= document.getElementById("indexs").value;
         document.getElementById("InOrOutComeType"+indes).value=json.subject;        
         document.getElementById("InOrOutComeTypeID"+indes).value=json.subjectID;
     }
     
     $(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 
     
</script>
	</head>
	<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
	<form action="" method="post" id="insertPayMentFrm" name="insertPayMentFrm">
	<input type="hidden" id="indexs" name="indexs">
	<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
	
	<input type="hidden" id="voucherTempletID" name="voucherTempletID" value="${voucherTempletID}">
	<input type="hidden" id="voucherTempletName" name="voucherTempletName" value="${voucherTempletName}">
			
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <li class="horizontal_onlyRight">
                              <img btn=btn id="searchBtn2" src="${ctx }/img/newbtn/btn_tjkm_0.png" title="添加科目" onClick="addRow();" >	
                            </li>
                            <li class="horizontal_onlyRight">
                             <img btn=btn id="delBtn" src="${ctx }/img/newbtn/btn_delete_0.png" title="删除" onClick="del()">
                            </li>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>                   

              		<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align='middle'>
                          <TH scope=col width="4%" height="26"><input type="checkbox" id="chks" onclick="chkAll()">选择</TH>
                          <TH scope=col width="4%" >方向</TH>
                          <TH scope=col width="18%" >科目名称</TH>
                          <TH scope=col width="12%">计算公式</TH>
                        </TR>
                        <s:iterator value="voucherTempletList" status="index">
	                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" id="invoiceRow">
							  <TD height="26">
							       <input type="checkbox" id="chk" name="chk"/>
							  </TD>
	                          <TD height="26" align="center">
	                            <select id="balanceDirection" name="voucherTempletTempPo.sLvtvtBalanceDirection">                                
	                                <option value='j' ${sLvtvtBalanceDirection == 'j' ? 'selected="selected"' : '' }>借</option>
	                                <option value='d' ${sLvtvtBalanceDirection == 'd' ? 'selected="selected"' : '' }>贷</option>
	                            </select>
	                          </TD>
						      <TD>
						      <li class="horizontal_onlyRight"><input type="text" value="${sLssSubjectID}&nbsp;${sLssSubjectName}" id="InOrOutComeType${index.index}" readonly="readonly" class="text_input200"></li>
						      <input type="hidden" id="InOrOutComeTypeID${index.index}" name="voucherTempletTempPo.sLvtvtSubjectID" value="${sLvtvtSubjectID}">
						      <li class="horizontal_onlyRight"><img btn=btn src="${ctx}/img/newbtn/btn_change_0.png" onClick="openSubject('${index.index}');"/></li>
						      </TD>
							  <TD>
							  		<select id="hbExpressions" name="voucherTempletTempPo.sLvtvtHExpressions">'
				                      <option value="select @subjectID,isnull(sum(L_PB_PBE_PayMentAmount),0.00) from L_PB_PBE_PaymentBillEntry where L_PB_PBE_BillID in (select distinct L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=@voucherID)" ${sLvtvtHExpressions eq 'select @subjectID,isnull(sum(L_PB_PBE_PayMentAmount),0.00) from L_PB_PBE_PaymentBillEntry where L_PB_PBE_BillID in (select distinct L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=@voucherID)' ? 'selected="selected"' : '' }>付款金额</option>
				                      <option value="select @subjectID,isnull(sum(L_FA_ME_ReceiptMentAmount),0.00) from L_FA_ME_ReceiptMentEntry where L_FA_ME_ReceiptMentBillID in (select distinct L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=@voucherID)" ${sLvtvtHExpressions eq 'select @subjectID,isnull(sum(L_FA_ME_ReceiptMentAmount),0.00) from L_FA_ME_ReceiptMentEntry where L_FA_ME_ReceiptMentBillID in (select distinct L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=@voucherID)' ? 'selected="selected"' : '' }>收款金额</option>
				                      <option value="select @subjectID,isnull(sum(L_VE_VE_CostPriceAmount),0.00) from L_VE_VoucherEntry where L_VE_VE_VoucherID=@voucherID" ${sLvtvtHExpressions eq 'select @subjectID,isnull(sum(L_VE_VE_CostPriceAmount),0.00) from L_VE_VoucherEntry where L_VE_VE_VoucherID=@voucherID' ? 'selected="selected"' : '' }>预付款、厂商减账及调帐金额</option>
				                    </select>  
							  </TD>
							 
			                 </TR>
                      </s:iterator>
                      </TBODY>
                    </TABLE>
              
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                       <TR>                         
                          <TD align="left">
                          <img btn=btn src="${ctx}/img/newbtn/btn_save_0.png" title='保存' onclick="save()">
                          </TD>
					   </TR>
                      </TBODY>
                    </TABLE>
                  </DIV>
               </div>
                </TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>