<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告维护</title>
<style type="text/css">
    img
    {
        filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);
    }
</style>
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
        supplierForm.reset();
	}
	
	function save(){
		if(checkForm(document.all.supplierForm)){
        	$("img").removeAttr("onclick");
			supplierForm.action = "updateNotice.action";
			supplierForm.submit();
		}
	}
	
	function addtr(){
		$('#addtable').append("<tr><td><img btn=btn src=\"${ctx }/img/newbtn/delete_0.png\" title='删除' onclick='removetr(this)' onmouseover=\"JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_1.png\');\" onmouseout=\"JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_0.png\');\" style=\"cursor: hand;\"/>&nbsp;<input type='file' id='file' name='upload'><br/></td></tr>");
	}
	
	function removetr(obj){
		$(obj).parent().parent().remove();
	}
	
	$(document).ready(function (){
		clickcheckbox();
	});
	
	function clickcheckbox(){
		var bnedepartmentids = '${noticePo.bnedepartmentid}'.split(',');
		for(var i=0; i<bnedepartmentids.length; i++){
			$('input[id='+bnedepartmentids[i].trim()+"][type=checkbox]").attr("checked","checked");
		}
	}

	function hshow(){
        var chks=document.all.chks;

        $('input[name=noticePo.bnedepartmentid]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
        
    }
    
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
			showPopWin("selDepartmentOpen.action?isclosed=0&companyid="+companyid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentOpen.action?isclosed=0&companyid="+companyid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}
	
	/**
	 * 开窗赋值实现方法
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
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="supplierForm" method="post" action="" enctype="multipart/form-data">

<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<input type="hidden" name=noticePo.bneuuid value="${noticePo.bneuuid}" />
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
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="8%" height="26" class="table_body">公告标题</TD>
			               <TD width="25%" class="table_none">
                            <input class="text_input200" maxlength="100" type="text" id="bspid" name="noticePo.bnetitle" value="${noticePo.bnetitle }"
                            validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '公告标题不能为空！'}]"><label style="color:red;">&nbsp;*&nbsp;</label>
                            	是否置顶<select name="noticePo.bneissticky" id="bneissticky">
									 	      <option value="0" >否</option>
									          <option value="1"  ${noticePo.bneissticky == "1" ? 'selected="selected"':''} >是</option>									
											 </select>  
			               </TD>
			               <TD width="8%" height="26" class="table_body">创建日期</TD>
			               <TD width="25%" class="table_none">
			               	${noticePo.bnepublishdate}
			               </TD>
			               <TD width="8%" height="26" class="table_body">制单人</TD>
			               <TD class="table_none">
                             ${noticePo.bnepublishpersonname }
			               </TD>
                        </TR>
                        <TR>
                       	  <TD height="26" class="table_body">公告部门    <!--<input type="checkbox" id="chks" value="1" name="chks" onclick="hshow()"/>全选  --></TD>
			              <TD class="table_none" colspan="3" id="tdaddcheckbox">
		              
			      		   <li class="horizontal_onlyRight">
						   		<input class="text_input300" id="bdpdepartmentname" name="selDepartmentName" value="${noticePo.bnedepartmentname }" type="hidden" />
						   		<textarea class="text_input200" id="ds"  name="ds" style='height:50px;width:600px' readonly="readonly" value="${noticePo.bnedepartmentname}">${noticePo.bnedepartmentname }</textarea>
						   		
						   		<input class="text_input100" type="hidden" id="departmentID" name="noticePo.bnedepartmentid" value="${noticePo.bnedepartmentid }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取部门！'}]"/>
						   </li>
						   <li class="horizontal_onlyRight">						  		
						  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openDepartment();">
						   </li>  
			              
			               </TD>
			               <TD width="8%" height="26" class="table_body">公告类型</TD>
			               <TD class="table_none">
                             <select id="noticeTypeID" name="noticePo.bnetypeid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取公告类型!'}]">
                                 <option value="">----请选择----</option>
                                 <s:iterator value="noticePos">
                                     <option value="${bnetypeid }" ${noticePo.bnetypeid eq bnetypeid ? 'selected="selected"' : '' }>${bnetypename}</option>
                                 </s:iterator>
                             </select>
			               </TD>
                        </TR>
                        <TR>			               
			               <TD width="8%" height="26" class="table_body">附件上传</TD>
			               <TD class="table_none" colspan="5">
			               	<img src="${ctx }/img/newbtn/btn_tianjia_0.png" btn=btn title="添加" onclick="addtr()"/>
			               	<table id="addtable">
			               	</table>
			               </TD>
                        </TR>
                        <TR>
			               <TD width="12%" class="table_body">公告内容</TD>
			               <TD width="38%" class="table_none" colspan="5">
	                            <FCK:editor instanceName="content" height="800" width="90%">
										<jsp:attribute name="value">	
										${noticePo.bneaddhtml}	
										</jsp:attribute>
								</FCK:editor>
							</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx }/img/newbtn/btn_save_0.png" btn=btn id="button1" title='保存' onClick="save()">
                        	  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
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
	
	
	




