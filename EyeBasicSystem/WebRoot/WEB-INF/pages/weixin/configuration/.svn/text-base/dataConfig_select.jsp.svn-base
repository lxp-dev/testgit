<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/zone.js"></script>
<title>微信数据配置</title>
</head>
<script>
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;");
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });

		setDivName('${weiXinDataConfigPo.wdcregistagreementname}',"div1");
		setDivName('${weiXinDataConfigPo.wdcintegralagreementname}',"div2");
		setDivName('${weiXinDataConfigPo.wdcoptometryappointmentname}',"div3");
		setDivName('${weiXinDataConfigPo.wdcnewcmstypename}',"div4");
		setDivName('${weiXinDataConfigPo.wdccontactuslxfstitle}',"div5");
		setDivName('${weiXinDataConfigPo.wdccontactusldlxtitle}',"div6");
		setDivName('${weiXinDataConfigPo.wdcnewactivityname}',"div7");
		setDivName('${weiXinDataConfigPo.wdcyqhytitle}',"div8");
		setDivName('${weiXinDataConfigPo.wdclxhxtitle}',"div9");
		setDivName('${weiXinDataConfigPo.wdcyqhysuccesstitle}',"div10");
    }); 

	function setDivName(strArr,arg2){
   		if( strArr != ''){
   			var str= new Array();   
   	   		str=strArr.split(","); 
   	   		document.getElementById(arg2).innerHTML = "<p>&nbsp;&nbsp;您选择了"+ str.length +"条数据.</p>"
   		    for (i=0;i<str.length ;i++ )   
   		    {   
   		    	document.getElementById(arg2).innerHTML = document.getElementById(arg2).innerHTML + "&nbsp;&nbsp; ● " + str[i]+"&nbsp;&nbsp;<br/>";
   		    }   	
   	   		document.getElementById(arg2).innerHTML = document.getElementById(arg2).innerHTML + "</br>";
   	   		document.getElementById(arg2).style.display="block";
   		}else{
   			document.getElementById(arg2).innerHTML = "";
   		}
	}
	
	/**
	 * 文章开窗，选择一篇文章
	 */
	function openCmsContentSingle(arg1,arg2){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initCmsContentOpen.action?isOpen=1&arg1="+arg1+"&arg2="+arg2,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initCmsContentOpen.action?isOpen=1&arg1="+arg1+"&arg2="+arg2,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【选择文章】";
	}

	/**
	 * 文章类型开窗，选择一个类型
	 */
	function openCmsType(arg1,arg2){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initCmsTypeOpen.action?isOpen=1&arg1="+arg1+"&arg2="+arg2,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initCmsTypeOpen.action?isOpen=1&arg1="+arg1+"&arg2="+arg2,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【选择文章类型】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openDepartmentValues(objValue,arg1,arg2){
		var arrayID = new Array();
		var arrayName = new Array();
		var departments = eval('(' + objValue + ')');
		for(var i = 0; i < departments.length; i++){	
			arrayID[i] = departments[i].bdpdepartmentid;
			arrayName[i] = departments[i].bdpdepartmentname;
		}

		$('#'+arg1).val(arrayID.join(","));
		var str= new Array();   
   		str=arrayName.join(",").split(",");      
   		document.getElementById(arg2).innerHTML = "<p>&nbsp;&nbsp;您选择了"+ str.length +"条数据.</p>"
	    for (i=0;i<str.length ;i++ )   
	    {   
	    	document.getElementById(arg2).innerHTML = document.getElementById(arg2).innerHTML + "&nbsp;&nbsp; ● " + str[i]+"&nbsp;&nbsp;<br/>";
	    }   	
	    document.getElementById(arg2).innerHTML = document.getElementById(arg2).innerHTML + "</br>";

	    document.getElementById(arg2).style.display="block";
	}
	
    function save(){
    	if(checkForm(dataConfigForm)){
    		$("img").removeAttr("onclick");
    		dataConfigForm.action = "insertWeixinDataConfig.action";
    		dataConfigForm.submit();
        }
    }
</script>
<%@ include file="/commons/uploadFile.jsp" %>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="dataConfigForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="98%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>微信数据配置</TD>
          <td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：数据配置 </td>
          <td align="right" valign="bottom">&nbsp;</td>
        </TR>
        <TR>
          <TD class=menubar_function_text colspan="3"><table></table></TD>
          <TD class=menubar_function_text align=right>
			<TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
                <TR>
                  <TD class=menubar_button></TD>
                </TR>
              </TBODY>
            </TABLE>
	      </TD>
        </TR>
      </TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="98%" align=center border=0>
        <TBODY>
        <TR>
          <TD bgColor=#ffffff>
          <DIV>
                  <fieldset style="border-color:#FF0000">
					<legend style="font-size: 14;color: red">
					<li class="horizontal_onlyRight"><b>[默认图片配置]</b></li>
					</legend>
            		<table width="99%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY> 
						<TR valign="middle">
                        	<TD  width="20%" height="30" class="table_body" align="center">
                        		<input type="hidden" class="text_input300" name="weiXinDataConfigPo.wdcdepartmentpicurl" id="wdcdepartmentpicurl" value="${weiXinDataConfigPo.wdcdepartmentpicurl2}" readonly="readonly"/>
                            	<input type="button" onclick="startLoad('/upload/weixin','1','wdcdepartmentpicurl','wdcdepartmentpicurlDiv','320','160','update')" value="图片上传"/>
                        	</TD>
                        	<TD class="table_none" colspan="5">
								<label style="color:red;">&nbsp;*&nbsp;<b>此项目用于设定门店列表图文中的第一张默认大图，建议尺寸（640*320）</b></label>	
                        	</TD>
                        </TR>     
                        <TR valign="middle">
                        	<TD height="30" class="table_body" align="center">预览</TD>
                        	<TD class="table_none" colspan="5">
                        		<div id="wdcdepartmentpicurlDiv">
                        			<c:choose>
						               	<c:when test="${weiXinDataConfigPo.wdcdepartmentpicurl ne ''}" >
						               		<p><img src="${ctx}${weiXinDataConfigPo.wdcdepartmentpicurl}" width="320" height="160" border="0" title='点击查看大图' width2="640" height2="320" onclick="imgclick(this)" style="cursor: hand;" /><a style='cursor:hand' onclick=deleteServerFile(this,"${weiXinDataConfigPo.wdcdepartmentpicurl}","wdcdepartmentpicurl");>删除</a></p>
						               	</c:when>
						               	<c:otherwise>
						               		<p><img src="${ctx}/weixin_personcenter/default_images/mendianliebiao.jpg" width="320" height="160" border="0" title='点击查看大图' width2="640" height2="320" onclick="imgclick(this)" style="cursor: hand;" /></p>	
						               	</c:otherwise>                        				
                        			</c:choose>
				               	</div>
                        	</TD>
                        </TR>
						<TR valign="middle">
                        	<TD  width="10%" height="30" class="table_body" align="center">
                        		<input type="hidden" class="text_input300" name="weiXinDataConfigPo.wdccmslargepicurl" id="wdccmslargepicurl" value="${weiXinDataConfigPo.wdccmslargepicurl2}" readonly="readonly"/>
                            	<input type="button" onclick="startLoad('/upload/weixin','1','wdccmslargepicurl','wdccmslargepicurlDiv','320','160','update')" value="图片上传"/>
                        	</TD>
                        	<TD class="table_none" colspan="5">
								<label style="color:red;"><b>&nbsp;*&nbsp;此项目用于设定文章列表图文中的第一张默认大图，建议尺寸（640*320）</b></label>	
                        	</TD>
                        </TR>     
                        <TR valign="middle">
                        	<TD  width="10%" height="30" class="table_body" align="center">预览</TD>
                        	<TD class="table_none" colspan="5">
                        		<div id="wdccmslargepicurlDiv">
                        			<c:choose>
						               	<c:when test="${weiXinDataConfigPo.wdccmslargepicurl ne ''}" >
						               		<p><img src="${ctx}${weiXinDataConfigPo.wdccmslargepicurl}" width="320" height="160" border="0" title='点击查看大图' width2="640" height2="320" onclick="imgclick(this)" style="cursor: hand;" /><a style='cursor:hand' onclick=deleteServerFile(this,"${weiXinDataConfigPo.wdccmslargepicurl}","wdccmslargepicurl");>删除</a></p>
						               	</c:when>
						               	<c:otherwise>
						               		<p><img src="${ctx}/weixin_personcenter/default_images/personcenter.png" width="320" height="160" border="0" title='点击查看大图' width2="640" height2="320" onclick="imgclick(this)" style="cursor: hand;" /></p>	
						               	</c:otherwise>                        				
                        			</c:choose>

				               	</div>
                        	</TD>
                        </TR>    
                        <TR valign="middle">
                        	<TD  width="10%" height="30" class="table_body" align="center">
                        		<input type="hidden" class="text_input300" name="weiXinDataConfigPo.wdccmssmallpicurl" id="wdccmssmallpicurl" value="${weiXinDataConfigPo.wdccmssmallpicurl2}" readonly="readonly"/>
                            	<input type="button" onclick="startLoad('/upload/weixin','1','wdccmssmallpicurl','wdccmssmallpicurlDiv','80','80','update')" value="图片上传"/>
                        	</TD>
                        	<TD class="table_none" colspan="5">
								<label style="color:red;"><b>&nbsp;*&nbsp;此项目用于设定文章列表图文中的非一张默认小图，建议尺寸（80*80）</b></label>	
                        	</TD>
                        </TR>     
                        <TR valign="middle">
                        	<TD  width="10%" height="30" class="table_body" align="center">预览</TD>
                        	<TD class="table_none" colspan="5">
                        		<div id="wdccmssmallpicurlDiv">
                        			<c:choose>
						               	<c:when test="${weiXinDataConfigPo.wdccmssmallpicurl ne ''}" >
						               		<p><img src="${ctx}${weiXinDataConfigPo.wdccmssmallpicurl}" width="80" height="80" border="0" title='点击查看大图' width2="160" height2="160" onclick="imgclick(this)" style="cursor: hand;" /><a style='cursor:hand' onclick=deleteServerFile(this,"${weiXinDataConfigPo.wdccmssmallpicurl}","wdccmssmallpicurl");>删除</a></p>
						               	</c:when>
						               	<c:otherwise>
						               		<p><img src="${ctx}/weixin_personcenter/default_images/weixin_small.png" width="80" height="80" border="0" title='点击查看大图' width2="160" height2="160" onclick="imgclick(this)" style="cursor: hand;" /></p>	
						               	</c:otherwise>                        				
                        			</c:choose>
				               	</div>
                        	</TD>
                        </TR>
                        <TR valign="middle">
                        	<TD  width="10%" height="30" class="table_body" align="center">
                        		<input type="hidden" class="text_input300" name="weiXinDataConfigPo.wdcpersoncenterpicurl" id="wdcpersoncenterpicurl" value="${weiXinDataConfigPo.wdcpersoncenterpicurl2}" readonly="readonly"/>
                            	<input type="button" onclick="startLoad('/upload/weixin','1','wdcpersoncenterpicurl','wdcpersoncenterpicurlDiv','320','160','update')" value="图片上传"/>
                        	</TD>
                        	<TD class="table_none" colspan="5">
								<label style="color:red;"><b>&nbsp;*&nbsp;此项目用于设定个人中心中的企业Logo，建议尺寸（640*320）</b></label>	
                        	</TD>
                        </TR>     
                        <TR valign="middle">
                        	<TD  width="10%" height="30" class="table_body" align="center">预览</TD>
                        	<TD class="table_none" colspan="5">
                        		<div id="wdcpersoncenterpicurlDiv">
                        			<c:choose>
						               	<c:when test="${weiXinDataConfigPo.wdcpersoncenterpicurl ne ''}" >
						               		<p><img src="${ctx}${weiXinDataConfigPo.wdcpersoncenterpicurl}" width="320" height="160" border="0" title='点击查看大图' width2="640" height2="320" onclick="imgclick(this)" style="cursor: hand;" /><a style='cursor:hand' onclick=deleteServerFile(this,"${weiXinDataConfigPo.wdcpersoncenterpicurl}","wdcpersoncenterpicurl");>删除</a></p>
						               	</c:when>
						               	<c:otherwise>
						               		<p><img src="${ctx}/weixin_personcenter/default_images/company.png" width="320" height="160" border="0" title='点击查看大图' width2="640" height2="320" onclick="imgclick(this)" style="cursor: hand;" /></p>	
						               	</c:otherwise>                        				
                        			</c:choose>
				               	</div>
                        	</TD>
                        </TR> 
                        </TBODY>
                        </table> 
                        </fieldset> 
                         </br>
                  <fieldset style="border-color:#FF0000">
					<legend style="font-size: 14;color: red">
					<li class="horizontal_onlyRight"><b>[其他配置信息]</b></li>
					</legend>  
					<table width="99%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title2">                   
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">注册协议对应文章内容</TD>
                       	<TD class="table_none" colspan="5">
                       		<input  class="text_input400" type="hidden" id="newContentD1" name="weiXinDataConfigPo.wdcregistagreement" value="${weiXinDataConfigPo.wdcregistagreement}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]"/>
						  	<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openCmsContentSingle('newContentD1','div1');">
						  	<div id="div1" style="display:none;border:solid 1px red;font-size:12px"></div>	
                       	</TD>
                      </TR>
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">积分兑换协议对应文章内容</TD>
                       	<TD class="table_none" colspan="5">
                       		<input  class="text_input400" type="hidden" id="newContentD2" name="weiXinDataConfigPo.wdcintegralagreement" value="${weiXinDataConfigPo.wdcintegralagreement}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]"/>
						  	<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openCmsContentSingle('newContentD2','div2');">
						  	<div id="div2" style="display:none;border:solid 1px red;font-size:12px"></div>	
                       	</TD>
                      </TR>   
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">预约说明对应对应文章内容</TD>
                       	<TD class="table_none" colspan="5">
                       		<input  class="text_input400" type="hidden" id="newContentD3" name="weiXinDataConfigPo.wdcoptometryappointment" value="${weiXinDataConfigPo.wdcoptometryappointment}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]"/>
						  	<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openCmsContentSingle('newContentD3','div3');">
						  	<div id="div3" style="display:none;border:solid 1px red;font-size:12px"></div>	
                       	</TD>
                      </TR>
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">最新技术分享</TD>
                       	<TD class="table_none" colspan="5">
                       		<input  class="text_input400" type="hidden" id="newContentD4" name="weiXinDataConfigPo.wdcnewcmstype" value="${weiXinDataConfigPo.wdcnewcmstype}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]"/>
						  	<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openCmsType('newContentD4','div4');">
						  	<div id="div4" style="display:none;border:solid 1px red;font-size:12px"></div>	
                       	</TD>
                      </TR>                       
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">联系我们中的联系方式对应文章内容</TD>
                       	<TD class="table_none" colspan="5">
                       		<input  class="text_input400" type="hidden" id="newContentD5" name="weiXinDataConfigPo.wdccontactuslxfs" value="${weiXinDataConfigPo.wdccontactuslxfs}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]"/>
						  	<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openCmsContentSingle('newContentD5','div5');">
						  	<div id="div5" style="display:none;border:solid 1px red;font-size:12px"></div>	
                       	</TD>
                      </TR>
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">联系我们中的来店路线对应文章内容</TD>
                       	<TD class="table_none" colspan="5">
                       		<input  class="text_input400" type="hidden" id="newContentD6" name="weiXinDataConfigPo.wdccontactusldlx" value="${weiXinDataConfigPo.wdccontactusldlx}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]"/>
						  	<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openCmsContentSingle('newContentD6','div6');">
						  	<div id="div6" style="display:none;border:solid 1px red;font-size:12px"></div>	
                       	</TD>
                      </TR>  
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">最新活动</TD>
                       	<TD class="table_none" colspan="5">
                       		<input  class="text_input400" type="hidden" id="newContentD7" name="weiXinDataConfigPo.wdcnewactivity" value="${weiXinDataConfigPo.wdcnewactivity}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]"/>
						  	<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openCmsType('newContentD7','div7');">
						  	<div id="div7" style="display:none;border:solid 1px red;font-size:12px"></div>	
                       	</TD>
                      </TR>   
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">邀请好友中的说明对应文章内容</TD>
                       	<TD class="table_none" colspan="5">
                       		<input  class="text_input400" type="hidden" id="newContentD8" name="weiXinDataConfigPo.wdcyqhy" value="${weiXinDataConfigPo.wdcyqhy}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]"/>
						  	<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openCmsContentSingle('newContentD8','div8');">
						  	<div id="div8" style="display:none;border:solid 1px red;font-size:12px"></div>	
                       	</TD>
                      </TR>  
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">邀请好友成功分享页面中的说明对应文章内容</TD>
                       	<TD class="table_none" colspan="5">
                       		<input  class="text_input400" type="hidden" id="newContentD10" name="weiXinDataConfigPo.wdcyqhysuccess" value="${weiXinDataConfigPo.wdcyqhysuccess}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]"/>
						  	<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openCmsContentSingle('newContentD10','div10');">
						  	<div id="div10" style="display:none;border:solid 1px red;font-size:12px"></div>	
                       	</TD>
                      </TR>                       
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">蓝星、红星会员区别说明对应文章内容</TD>
                       	<TD class="table_none" colspan="5">
                       		<input  class="text_input400" type="hidden" id="newContentD9" name="weiXinDataConfigPo.wdclxhx" value="${weiXinDataConfigPo.wdclxhx}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]"/>
						  	<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openCmsContentSingle('newContentD9','div9');">
						  	<div id="div9" style="display:none;border:solid 1px red;font-size:12px"></div>	
                       	</TD>
                      </TR>                                                                                                                                                                                                 		                               					   
                      </TBODY>
                    </TABLE>
                    </fieldset> 
                    </div>
                  </br>
                  <fieldset style="border-color:#FF0000">
					<legend style="font-size: 14;color: red">
					<li class="horizontal_onlyRight"><b>[提示语配置]</b></li>
					</legend>  
					<table width="99%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title2">                   
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">会员注册成功页面弹出信息</TD>
                       	<TD class="table_none" colspan="5">
                       		<input clean=clean class="text_input800" id="wdcalertregistersuccess" name="weiXinDataConfigPo.wdcalertregistersuccess" maxlength="1000" value="${weiXinDataConfigPo.wdcalertregistersuccess }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]">
                       		<label style="color:red;"><b>&nbsp;*&nbsp;</b></label>
                       	</TD>
                      </TR>
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">邀请好友成功页面弹出信息</TD>
                       	<TD class="table_none" colspan="5">
                       		<input clean=clean class="text_input800" id="wdcalertyaoqingsuccess" name="weiXinDataConfigPo.wdcalertyaoqingsuccess" maxlength="1000" value="${weiXinDataConfigPo.wdcalertyaoqingsuccess }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]">
                       		<label style="color:red;"><b>&nbsp;*&nbsp;</b></label>
                       	</TD>
                      </TR> 
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">邀请好友失败页面弹出信息</TD>
                       	<TD class="table_none" colspan="5">
                       		<input clean=clean class="text_input600" id="wdcalertyaoqingerror1" name="weiXinDataConfigPo.wdcalertyaoqingerror1" maxlength="1000" value="${weiXinDataConfigPo.wdcalertyaoqingerror1 }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]">
                       		<label style="color:red;"><b>&nbsp;*&nbsp;邀请的好友已经是有消费记录的会员</b></label>
                       	</TD>
                      </TR> 
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">邀请好友失败页面弹出信息</TD>
                       	<TD class="table_none" colspan="5">
                       		<input clean=clean class="text_input600" id="wdcalertyaoqingerror2" name="weiXinDataConfigPo.wdcalertyaoqingerror2" maxlength="1000" value="${weiXinDataConfigPo.wdcalertyaoqingerror2 }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]">
                       		<label style="color:red;"><b>&nbsp;*&nbsp;没有消费记录的会员不能邀请好友</b></label>
                       	</TD>
                      </TR>                           
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">积分商城兑换成功弹出信息</TD>
                       	<TD class="table_none" colspan="5">
                       		<input clean=clean class="text_input800" id="wdcalertjifenduihuansuccess" name="weiXinDataConfigPo.wdcalertjifenduihuansuccess" maxlength="1000" value="${weiXinDataConfigPo.wdcalertjifenduihuansuccess }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]">
                       		<label style="color:red;"><b>&nbsp;*&nbsp;</b></label>
                       	</TD>
                      </TR>
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">积分商城兑换确认弹出信息</TD>
                       	<TD class="table_none" colspan="5">
                       		<input clean=clean class="text_input800" id="wdcalertjifenduihuanconfirm" name="weiXinDataConfigPo.wdcalertjifenduihuanconfirm" maxlength="1000" value="${weiXinDataConfigPo.wdcalertjifenduihuanconfirm }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]">
                       		<label style="color:red;"><b>&nbsp;*&nbsp;</b></label>
                       	</TD>
                      </TR> 
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">微信预约成功页面弹出信息</TD>
                       	<TD class="table_none" colspan="5">
                       		<input clean=clean class="text_input800" id="wdcalertyuyuesuccess" name="weiXinDataConfigPo.wdcalertyuyuesuccess" maxlength="1000" value="${weiXinDataConfigPo.wdcalertyuyuesuccess }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]">
                       		<label style="color:red;"><b>&nbsp;*&nbsp;</b></label>
                       	</TD>
                      </TR>   
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">微信预约失败页面弹出信息</TD>
                       	<TD class="table_none" colspan="5">
                       		<input clean=clean class="text_input800" id="wdcalertyuyueerror" name="weiXinDataConfigPo.wdcalertyuyueerror" maxlength="1000" value="${weiXinDataConfigPo.wdcalertyuyueerror }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]">
                       		<label style="color:red;"><b>&nbsp;*&nbsp;</b></label>
                       	</TD>
                      </TR>                                                                                                                                                                                                                                                                                                                              		                               					   
                      </TBODY>
                    </TABLE>
                    </fieldset>
                    </br>
                  <fieldset style="border-color:#FF0000">
					<legend style="font-size: 14;color: red">
					<li class="horizontal_onlyRight"><b>[名词配置]</b></li>
					</legend>  
					<table width="99%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title2">                   
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">积分在系统中显示为</TD>
                       	<TD class="table_none" colspan="5">
                       		<input clean=clean class="text_input100" id="wdcintroductionjifen" name="weiXinDataConfigPo.wdcintroductionjifen" maxlength="10" value="${weiXinDataConfigPo.wdcintroductionjifen }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]">
                       		<label style="color:red;"><b>&nbsp;*&nbsp;</b></label>
                       	</TD>
                      </TR>
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">个人中心主页面剩余积分在系统中显示为</TD>
                       	<TD class="table_none" colspan="5">
                       		<input clean=clean class="text_input100" id="wdcintroductionchuzhi" name="weiXinDataConfigPo.wdcintroductionchuzhi" maxlength="10" value="${weiXinDataConfigPo.wdcintroductionchuzhi }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]">
                       		<label style="color:red;"><b>&nbsp;*&nbsp;</b></label>
                       	</TD>
                      </TR> 
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">个人中心主页面我的病例在系统中显示为</TD>
                       	<TD class="table_none" colspan="5">
                       		<input clean=clean class="text_input100" id="wdcintroductionwodebingli" name="weiXinDataConfigPo.wdcintroductionwodebingli" maxlength="10" value="${weiXinDataConfigPo.wdcintroductionwodebingli }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]">
                       		<label style="color:red;"><b>&nbsp;*&nbsp;</b></label>
                       	</TD>
                      </TR> 
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">消息中心的最新医嘱在系统中显示为</TD>
                       	<TD class="table_none" colspan="5">
                       		<input clean=clean class="text_input100" id="wdcintroductionzuixinyizhu" name="weiXinDataConfigPo.wdcintroductionzuixinyizhu" maxlength="10" value="${weiXinDataConfigPo.wdcintroductionzuixinyizhu }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]">
                       		<label style="color:red;"><b>&nbsp;*&nbsp;</b></label>
                       	</TD>
                      </TR>                           
                      <TR valign="middle">
                       	<TD height="30" width="20%" class="table_body" align="right">消息中心的最新诊疗信息在系统中显示为</TD>
                       	<TD class="table_none" colspan="5">
                       		<input clean=clean class="text_input100" id="wdcintroductionzuixinzhenliao" name="weiXinDataConfigPo.wdcintroductionzuixinzhenliao" maxlength="10" value="${weiXinDataConfigPo.wdcintroductionzuixinzhenliao }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]">
                       		<label style="color:red;"><b>&nbsp;*&nbsp;</b></label>
                       	</TD>
                      </TR>
                      </TBODY>
                    </TABLE>
                    </fieldset> 
                    </div>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                    <TBODY>
                        <TD>
                        	<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save();">
                        </TD>
                      </TR>
                    </TBODY>
                  </TABLE>
                    </TD></TR>
        </TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY>

    </html>
<%@ include file="/WEB-INF/inc/message.jsp" %>