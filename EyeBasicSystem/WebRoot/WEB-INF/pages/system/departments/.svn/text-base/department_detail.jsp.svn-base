<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
#１ {
	color: #F00;
}
#tabContent__1 div .privateBorder tbody .row td #１ {
	font-size: 14px;
}
#tabContent__1 div .privateBorder tbody .row td #１ {
	font-size: 18px;
}
.STYLE1 {color: #FF0000;
	font-weight: bold;
}
</style>
<head>
<script language="javascript">
function imgclick(src){
	var id = src.src;
	var width = $(src).attr("width2");
	var height = $(src).attr("height2");
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	
	if(is_iPad()){
		showPopWin("lookimage.action?id="+EncodeUtf8(id)+"&width="+width+"&height="+height,600,300,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin("lookimage.action?id="+EncodeUtf8(id)+"&width="+width+"&height="+height,900,500,topRows,topCols,returnRefresh(true),false);
	}
	
	document.getElementById('popupTitle').innerHTML="【打印样式预览】";
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门维护</title>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="departmentsForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
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
                                  <TD width="5%"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="12%" height="26" class="table_body">部门编码</TD>
                          <TD width="24%" class="table_none">${departmentsPo.bdpdepartmentid }&nbsp;</TD>
                          <TD width="12%" height="26" class="table_body">部门名称</TD>
                          <TD width="24%" class="table_none">${departmentsPo.bdpdepartmentname }&nbsp;</TD>
                          <TD width="12%" height="26" class="table_body">部门电话</TD>
                          <TD width="24%" class="table_none">${departmentsPo.bdpphone }&nbsp;</TD>
                        </TR>
                        <TR>
                          <TD height="26" class="table_body">部门状态</TD>
                          <TD class="table_none">${departmentsPo.bdpisclosed == '0'? '启用' : '停用' }</TD>
                          <TD height="26" class="table_body">部门类型</TD>
                          <TD height="26" class="table_none" >${departmentsPo.bdptypename}&nbsp;</TD>
                          <TD height="26" class="table_body">关联加工中心</TD>
                          <TD height="26" class="table_none" >${departmentsPo.bdpregname}&nbsp;</TD>
                        </TR>
                        <TR>
                          <TD height="26" class="table_body">负责人</TD>
                          <TD  class="table_none" colspan="5">${departmentsPo.bdpperson }&nbsp;</TD>
                        </TR>
               <c:if test="${departmentsPo.bdptype == '1'}"> 	  
			            <TR>                             
                            <TD height="26" class="table_body"><li class="horizontal_onlyRight">默认成品镜片取镜时间</li>
                            </TD>
                        	<TD height="26" class="table_none" >
                        	<li class="horizontal_onlyRight">
                        	${departmentsPo.bdptakeglassdate} 小时&nbsp;
			            	  </li>
                      	    </TD>
                            <TD height="26" class="table_body"><li class="horizontal_onlyRight">存入银行</li>
                            </TD>
                            <TD height="26" class="table_none" >
                                ${departmentsPo.bdpbankcardname}&nbsp;
                      	  </TD>
                      	  <TD height="26" class="table_body"><li class="horizontal_onlyRight">销售方式</li>
                            </TD>
                            <TD height="26" class="table_none" >
                        	<li class="horizontal_onlyRight">
                                 ${departmentsPo.bdpsalestype == '1' ? '验光+销售+收银' : '验光+销售' }
			            	  </li>
                      	  </TD>
			              </TR>
			              <TR>
                            <TD width="10%" height="26" class="table_body">隐形和护理液同单销售</TD>
                            <TD width="23%" class="table_none" ${systemParameterPo.fspprintmedicalhistory == '2' ? '' : 'colspan="5"'  }>
	                          <c:choose>
	                          			<c:when test="${departmentsPo.bdpstealthflag == '1' }">可以同单销售</c:when>
	                          			<c:when test="${departmentsPo.bdpstealthflag == '0' }">不能同单销售</c:when>
	                          			<c:otherwise>未设置</c:otherwise>
	                          </c:choose>
                            </TD>
			            	<c:if test="${systemParameterPo.fspprintmedicalhistory == '2'}">
				            	<TD height="26" class="table_body">打印病历</TD>
	                        	<TD width="23%" class="table_none" colspan="3">
				            		<c:choose>
	                          			<c:when test="${departmentsPo.bdpprintmedicalhistory == '1' }">打印</c:when>
	                          			<c:when test="${departmentsPo.bdpprintmedicalhistory == '0' }">不打印</c:when>
	                          			<c:otherwise>未设置</c:otherwise>
	                                 </c:choose>
				            	</TD>
			            	</c:if>                          
                          </TR>
                        <TR>
                         <TD width="10%" height="26" class="table_body">闭店时间</TD>
                         <TD width="23%" class="table_none">${departmentsPo.bdpclosedate } 点</TD>
                         <TD width="10%" height="26" class="table_body">读取会员卡方式</TD>
                         <TD width="23%" class="table_none" colspan="3">
		            	     <c:choose>
                         	     <c:when test="${departmentsPo.bdpreadcardform == 'initSCIHISsaomaWin.action' }">扫码枪</c:when>
                         	     <c:when test="${departmentsPo.bdpreadcardform == 'initSCIHISdukaWin.action' }">长城读卡器</c:when>
                         		 <c:otherwise>未设置</c:otherwise>
                             </c:choose>                             
                         </TD>
                       	</TR>                          
			    </c:if>  
                        <TR>
                            <TD width="10%" height="26" class="table_body">部门全称</TD>
                            <TD width="23%" class="table_none" colspan="5" >${departmentsPo.bdpfullname }&nbsp;
                            </TD>

                          </TR>
                          <TR>
                            <TD width="10%" height="26" class="table_body">部门电话</TD>
                            <TD width="23%" class="table_none" colspan="5" >${departmentsPo.bdpphone }&nbsp;
                            </TD>

                          </TR>
                           <TR>
                            <TD width="10%" height="26" class="table_body">部门地址</TD>
                            <TD width="23%" class="table_none" colspan="5" >${departmentsPo.bdpaddress}&nbsp;
                            </TD>

                          </TR>
                          <TR>
                            <TD width="10%" height="26" class="table_body">公司名称</TD>
                            <TD width="23%" class="table_none" colspan="5" >${departmentsPo.bdpcompanyname}
                                <span class="STYLE1"></span>
                            </TD>
                          </TR> 
                          <TR>
                            <TD width="10%" height="26" class="table_body">所属公司</TD>
                            <TD width="23%" class="table_none" colspan="5" >${departmentsPo.bdpcompanysname}
                                <span class="STYLE1"></span>
                            </TD>
                          </TR>
                      <c:if test="${systemParameterPo.fspkqsystem == '2'}">    
                          <TR>
                            <TD width="10%" height="26" class="table_body">考勤系统部门编码</TD>
                            <TD width="23%" class="table_none" colspan="5" >${departmentsPo.bdpkqDptID}
                            </TD>
                          </TR>
                      </c:if>                           
						<TR>
                          <TD width="10%" height="26" class="table_body">下属仓位</TD>
                          <TD height="26" colspan="5" class="table_none">${departmentsPo.warehouseName }&nbsp;</TD>
                        </TR>						
                              </TABLE>
                    <c:if test="${departmentsPo.bdptype == '1'}">			
					<table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                    </TABLE>                    							
					<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
						  <TH scope=col width="10%" height="26">商品类别</TH>
                          <TH scope=col width="40%" >销售仓位</TH>
                          <TH scope=col width="35%" >退款仓位</TH>
                          <TH scope=col width="15%" >消仓点</TH>                          
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">镜架</TD>
                          <TD>${warehouseConfigurationPo2.bwcstockname1 }${warehouseConfigurationPo2.bwcstockname13 eq '' ? '' : '、'}${warehouseConfigurationPo2.bwcstockname13 }</TD>
                          <TD>${warehouseConfigurationPo1.bwcstockname1 }</TD>
                          <TD>&nbsp;</TD>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">配件</TD>
                          <TD>${warehouseConfigurationPo2.bwcstockname2 }</TD>
                          <TD>${warehouseConfigurationPo1.bwcstockname2 }</TD>
                          <TD>&nbsp;</TD>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">成品镜片</TD>
                          <TD>${warehouseConfigurationPo2.bwcstockname3 }</TD>
                          <TD>${warehouseConfigurationPo1.bwcstockname3 }</TD>
                          <TD>&nbsp;</TD>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">订做镜片</TD>
                          <TD>${warehouseConfigurationPo2.bwcstockname4 }</TD>
                          <TD>${warehouseConfigurationPo1.bwcstockname4 }</TD>
                          <TD>
						  	<c:choose>
						  		<c:when test="${warehouseConfigurationPo2.bwcxiaocangww=='1' }">
						  			委外收货
						  		</c:when>
						  		<c:when test="${warehouseConfigurationPo2.bwcxiaocangww=='2' }">
						  			库房发料
						  		</c:when>	
						  		<c:otherwise>
						  			&nbsp;
						  		</c:otherwise>
						  	</c:choose>
						  </TD>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">隐形成品镜片</TD>
                          <TD>${warehouseConfigurationPo2.bwcstockname5 }</TD>
                          <TD>${warehouseConfigurationPo1.bwcstockname5 }</TD>
                          <TD>&nbsp;</TD>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">隐形订做镜片</TD>
                          <TD>${warehouseConfigurationPo2.bwcstockname6 }</TD>
                          <TD>${warehouseConfigurationPo1.bwcstockname6 }</TD>
                          <TD>&nbsp;</TD>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">护理液</TD>
                          <TD>${warehouseConfigurationPo2.bwcstockname7}</TD>
                          <TD>${warehouseConfigurationPo1.bwcstockname7}</TD>
                          <TD>&nbsp;</TD>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">太阳镜</TD>
                          <TD>${warehouseConfigurationPo2.bwcstockname8}</TD>
                          <TD>${warehouseConfigurationPo1.bwcstockname8}</TD>
                          <TD>&nbsp;</TD>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">老花镜</TD>
                          <TD>${warehouseConfigurationPo2.bwcstockname11}</TD>
                          <TD>${warehouseConfigurationPo1.bwcstockname11}</TD>
                          <TD>&nbsp;</TD>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">耗材</TD>
                          <TD>${warehouseConfigurationPo2.bwcstockname9}</TD>
                          <TD>${warehouseConfigurationPo1.bwcstockname9}</TD>
                          <TD>&nbsp;</TD>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">视光</TD>
                          <TD>${warehouseConfigurationPo2.bwcstockname12}</TD>
                          <TD>${warehouseConfigurationPo1.bwcstockname12}</TD>
                          <TD>&nbsp;</TD>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">赠品类</TD>
                          <TD>${warehouseConfigurationPo2.bwcstockname10 }</TD>
                          <TD>${warehouseConfigurationPo1.bwcstockname10 }</TD>
                          <TD>
						  	<c:choose>
						  		<c:when test="${warehouseConfigurationPo2.bwcxiaocangzp=='1' }">
						  			门店结款
						  		</c:when>
						  		<c:when test="${warehouseConfigurationPo2.bwcxiaocangzp=='2' }">
						  			库房发料
						  		</c:when>	
						  		<c:otherwise>
						  			&nbsp;
						  		</c:otherwise>
						  	</c:choose>
						  </TD>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">积分兑换类</TD>
                          <TD>${warehouseConfigurationPo2.bwcstockname14 }</TD>
                          <TD>${warehouseConfigurationPo1.bwcstockname13 }</TD>
                          <TD>&nbsp;</TD>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">不合格品调拨</TD>
                          <TD>&nbsp;</TD>
                          <TD>${warehouseConfigurationPo1.bwcstockname14 }</TD>
                          <TD>&nbsp;</TD>
                        </TR>                        
                      </TBODY>
                    </TABLE>
                    </c:if>
                   <c:if test="${departmentsPo.bdptype=='3'}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                    </TABLE> 
                    <table  id="table2" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="30%"  height="26" align="center" scope=col>仓位列表类型</TH>
                          <TH scope=col width="70%">默认仓位</TH>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">采购收货收入仓位</TD>
                          <TD>${warehouseConfigurationPo3.bwcstockname3 }</TD>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">委外收货收入仓位</TD>
                          <TD>${warehouseConfigurationPo3.bwcstockname4 }</TD>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">其他入库收入仓位</TD>
                          <TD>${warehouseConfigurationPo3.bwcstockname5 }</TD>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">其他出库发出仓位</TD>
                          <TD>${warehouseConfigurationPo3.bwcstockname6}</TD>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">商品退货发出仓位</TD>
                          <TD>${warehouseConfigurationPo3.bwcstockname7 }</TD>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">销售出库发出仓位</TD>
                          <TD>${warehouseConfigurationPo3.bwcstockname8 }</TD>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">商品调拨发出仓位</TD>
                          <TD>${warehouseConfigurationPo3.bwcstockname9 }</TD>
                        </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  height="26" align="center">客户批发调拨发出仓位</TD>
                          <TD>${warehouseConfigurationPo3.bwcstockname10 }</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    </c:if>	
                    <c:if test="${departmentsPo.bdptype == '1'}">			
					<table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                    </TABLE>  
                      <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                        <TBODY>
					   <TR>
                          <TD height="26" class="table_body " align="right">配镜单样式</TD>
                          <TD class="table_none" colspan="5">
                          		<li class="horizontal_onlyRight">
								    框架
								</li>
								<li class="horizontal_onlyRight">
								    <img src="${ctx}${departmentsPoBill.bdpkjurl}" width="160" height="100" width2="400" height2="300" onclick="imgclick(this)" style="cursor: hand;">
								</li>
                          		<li class="horizontal_onlyRight">
								   隐形
								</li>								
								<li class="horizontal_onlyRight">
								    <img src="${ctx}${departmentsPoBill.bdpyxurl}" width="160" height="100" width2="400" height2="300" onclick="imgclick(this)" style="cursor: hand;">
								</li>
                          		<li class="horizontal_onlyRight">
								    辅料
								</li>								
								<li class="horizontal_onlyRight">
								    <img src="${ctx}${departmentsPoBill.bdpflurl}" width="160" height="100" width2="400" height2="300" onclick="imgclick(this)" style="cursor: hand;">
								</li>
                          </TD>
					   </TR>
					   <TR>
                          <TD height="26" class="table_body " align="right">退配镜单样式</TD>
                          <TD class="table_none" colspan="5">
                          		<li class="horizontal_onlyRight">
								    框架
								</li>
								<li class="horizontal_onlyRight">
								    <img src="${ctx}${departmentsPoBill.bdptkjurl}" width="160" height="100" width2="400" height2="300" onclick="imgclick(this)" style="cursor: hand;">
								</li>
                          		<li class="horizontal_onlyRight">
								   隐形
								</li>								
								<li class="horizontal_onlyRight">
								    <img src="${ctx}${departmentsPoBill.bdptyxurl}" width="160" height="100" width2="400" height2="300" onclick="imgclick(this)" style="cursor: hand;">
								</li>
                          		<li class="horizontal_onlyRight">
								    辅料
								</li>								
								<li class="horizontal_onlyRight">
								    <img src="${ctx}${departmentsPoBill.bdptflurl}" width="160" height="100" width2="400" height2="300" onclick="imgclick(this)" style="cursor: hand;">
								</li>
                          </TD>
					   </TR>					   
					   <TR>
                          <TD height="26" class="table_body " align="right">订金单样式</TD>
                          <TD class="table_none" colspan="5">
								<li class="horizontal_onlyRight">
								    <img src="${ctx}${departmentsPoBill.bdpdjdurl}" id="bdpdjdurl" width="160" height="100" width2="400" height2="300" onclick="imgclick(this)" style="cursor: hand;">
								</li>
                          </TD>
					   </TR>
					   <TR>
                          <TD height="26" class="table_body " align="right">挂号单样式</TD>
                          <TD class="table_none" colspan="5">
								<li class="horizontal_onlyRight">
								    <img src="${ctx}${departmentsPoBill.bdpghdurl}" id="bdpghdurl" width="160" height="100"  width2="400" height2="300" onclick="imgclick(this)" style="cursor: hand;">
								</li>
                          </TD>
					   </TR>
                      </TABLE> 
                      
                      <c:if test="${departmentsPo.bdplinkhisflag == '1' && systemParameterPo.fsphisflag == '2'}">
	                      <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
	                        <TBODY>
	                          <TR>
	                            <TD width="10%" height="26" class="table_body">连接HIS系统</TD>
	                            <TD width="23%" class="table_none" colspan="5">
	                              <c:if test="${departmentsPo.bdplinkhisflag == '1'}">连接</c:if>
	                              <c:if test="${departmentsPo.bdplinkhisflag != '1'}">不连接</c:if>
	                            </TD>
	                          </TR>
	                          <TR id="histr1">
	                            <TD width="10%" height="26" class="table_body">医院HIS系统</TD>
	                            <TD width="23%" class="table_none">${departmentsPo.bdplinkhisname }                       
	                            </TD>
	                            <TD width="10%" class="table_body">待收费记录向HIS传递方式</TD>
	                            <TD width="23%" class="table_none" colspan="3">                           
	                              <c:if test="${departmentsPo.bdpnotpayfeeform == '1'}">按商品明细传递</c:if>
	                              <c:if test="${departmentsPo.bdpnotpayfeeform != '1'}">按整单传递</c:if>
	                            </TD>
	                          </TR>
		                          
	                          <c:if test="${departmentsPo.bdpnotpayfeeform == '2'}">		  
		                          <TR id="histr2">
		                            <TD width="10%" height="26" class="table_body">收费项目编号</TD>
		                            <TD width="23%" class="table_none" colspan="5">${departmentsPo.bdpchargingitemid }
		                            </TD>
		                          </TR> 
	                          </c:if>                
	                      </TABLE>                      
                      </c:if>
                      
                                         
                    </c:if> 
					<c:if test="${departmentsPo.bdptype == '3'}">			
					<table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                    </TABLE>  
                      <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                        <TBODY>
					   <TR>
                          <TD height="26" class="table_body " align="right">配镜单样式</TD>
                          <TD class="table_none" colspan="5">
                          		<li class="horizontal_onlyRight">
								    框架
								</li>
								<li class="horizontal_onlyRight">
								    <img src="${ctx}${departmentsPoBill.bdpkjurl}" width="160" height="100" width2="400" height2="300" onclick="imgclick(this)" style="cursor: hand;">
								</li>
                          </TD>
					   </TR>
                      </TABLE>                    
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>