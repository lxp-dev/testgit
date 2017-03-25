<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手动选择配镜单</title>
</head>
<script>
	function trim(str){ //删除左右两端的空格
　　  	return str.replace(/(^\s*)|(\s*$)/g, "");
　　 }
	
    function openSalesForConsignProcessValues(salesID,deptID){
    	procurementOrdersForm.action="initGlassForConsignProcessOpen.action?salesID="+salesID+"&deptID="+deptID;
		procurementOrdersForm.submit();
    }

	function openCustomer(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initCustomerOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initCustomerOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【客户查询】";
	}
	/**
	 * 开窗赋值实现方法
	 */
	function openCustomerValues(json){
		document.getElementById('cstcpodcustomerid').value = json.id;
		document.getElementById('cstcpodcustomername').value = json.value;
		
	}

	function openGoodsConsignProcessOrders(goodscategory,glassflag){
	    var supplierID=document.all.supplierID.value;
	    var sph="";
	    var cyl="";
	    var axis="";
	    var belowplusluminosity="";	
	    var materialType="";
	    var arriseglass="";  
	    var basis=""  
	    if(glassflag=='R'){
	      if(document.all.ballglassod.value==''){
            alert('右眼球镜不能为空');
            return false;
            }
          if(document.all.postglassod.value==''){
            alert('右眼柱镜不能为空');
            return false;
            }
	       sph=document.all.ballglassod.value;
	       cyl=document.all.postglassod.value;
	       if(cyl>0){
	    	   sph=parseFloat(accAdd(sph,cyl)).toFixed(2);
	    	   if(sph>0){
	    		   sph="+"+sph;
	    	   }
	    	   cyl=parseFloat(accMul(cyl, -1)).toFixed(2);
	       }
	       axis=document.all.axesod.value;
	       belowplusluminosity=document.all.addod.value;
	       materialType=document.all.materialTypeod.value;
	       arriseglass=document.all.arriseglassod1.value;
	       basis=document.all.basisod1.value;
	    }else if(glassflag=='L'){
	      if(document.all.ballglassos.value==''){
            alert('左眼球镜不能为空');
            return false;
            }
          if(document.all.postglassos.value==''){
            alert('左眼柱镜不能为空');
            return false;
            }
	       sph=document.all.ballglassos.value;
	       cyl=document.all.postglassos.value;
	       if(cyl>0){
	    	   sph=parseFloat(accAdd(sph,cyl)).toFixed(2);
	    	   if(sph>0){
	    		   sph="+"+sph;
	    	   }
	    	   cyl=parseFloat(accMul(cyl, -1)).toFixed(2);
	       }
	       axis=document.all.axesos.value;
	       belowplusluminosity=document.all.addos.value;
	       materialType=document.all.materialTypeos.value;
	       arriseglass=document.all.arriseglassos1.value;
	       basis=document.all.basisos1.value;
	    }
	    
	     var posts=document.getElementsByName('postglassod');
	     if('${systemParameterPo.fspothernegative}'!='1'){
	       for(var i=0;i<posts.length;i++){
	       		if(parseFloat(posts[i].value)>0){
	       			alert('柱镜不能为正!');
	       			posts[i].focus();
	       			return;
	       		}
	       }
	     }
        var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initGoodsForConsignProcessOpen.action?goodscategory="+goodscategory+"&supplierID="+supplierID+"&glassflag="+glassflag+"&sph="+sph+"&cyl="+cyl+"&axis="+axis+"&belowplusluminosity="+belowplusluminosity+"&materialType="+materialType+"&arriseglass="+arriseglass+"&basis="+basis,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsForConsignProcessOpen.action?goodscategory="+goodscategory+"&supplierID="+supplierID+"&glassflag="+glassflag+"&sph="+sph+"&cyl="+cyl+"&axis="+axis+"&belowplusluminosity="+belowplusluminosity+"&materialType="+materialType+"&arriseglass="+arriseglass+"&basis="+basis,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【添加商品】";
		//showPopWin("","initGoodsForConsignProcessOpen.action?goodscategory="+goodscategory+"&supplierID="+supplierID+"&glassflag="+glassflag+"&sph="+sph+"&cyl="+cyl+"&axis="+axis+"&belowplusluminosity="+belowplusluminosity+"&materialType="+materialType+"&arriseglass="+arriseglass+"&basis="+basis,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
	}
	function openGoodsForConsignProcessValues(objValue){
           var goodInfo=eval('(' + objValue + ')');
           if(goodInfo.cstcpodglassflag=='R' && goodInfo.cstcpodgoodsid != ''){
           document.all.cstcpodgoodsidod.value=goodInfo.cstcpodgoodsid;
           document.all.cstcpodgoodsnameod.value=goodInfo.cstcpodgoodsname;
           document.all.cstcpodglassflagod.value=goodInfo.cstcpodglassflag;
           document.all.cstcpodballglassod.value=goodInfo.cstcpodballglass;
           document.all.cstcpodpostglassod.value=goodInfo.cstcpodpostglass;
           document.all.cstcpodaxesod.value=goodInfo.cstcpodaxes;
           document.all.cstcpodaddod.value=goodInfo.cstcpodadd;
           document.all.cstcpodarriseglassod.value=goodInfo.cstcpodarriseglass;
           document.all.cstcpodbasisod.value=goodInfo.cstcpodbasis;
           document.all.cstcpodnumod.value="1";                                          
           }else if(goodInfo.cstcpodglassflag=='L' && goodInfo.cstcpodgoodsid != ''){
           document.all.cstcpodgoodsidos.value=goodInfo.cstcpodgoodsid;
           document.all.cstcpodgoodsnameos.value=goodInfo.cstcpodgoodsname;
           document.all.cstcpodglassflagos.value=goodInfo.cstcpodglassflag;
           document.all.cstcpodballglassos.value=goodInfo.cstcpodballglass;
           document.all.cstcpodpostglassos.value=goodInfo.cstcpodpostglass;
           document.all.cstcpodaxesos.value=goodInfo.cstcpodaxes;
           document.all.cstcpodaddos.value=goodInfo.cstcpodadd;
           document.all.cstcpodarriseglassos.value=goodInfo.cstcpodarriseglass;
           document.all.cstcpodbasisos.value=goodInfo.cstcpodbasis; 
           document.all.cstcpodnumos.value="1"; 
           }	
	}
	function clean(flag){
       if(flag=='R'){
           document.all.cstcpodgoodsidod.value="";
           document.all.cstcpodgoodsnameod.value="";
           document.all.cstcpodglassflagod.value="";
           document.all.cstcpodballglassod.value="";
           document.all.cstcpodpostglassod.value="";
           document.all.cstcpodaxesod.value="";
           document.all.cstcpodaddod.value="";
           document.all.cstcpodarriseglassod.value="";
           document.all.cstcpodbasisod.value="";
           document.all.cstcpodnumod.value="";
           document.all.cstcpodrequirementod.value="";  
       }else if(flag=='L'){
           document.all.cstcpodgoodsidos.value="";
           document.all.cstcpodgoodsnameos.value="";
           document.all.cstcpodglassflagos.value="";
           document.all.cstcpodballglassos.value="";
           document.all.cstcpodpostglassos.value="";
           document.all.cstcpodaxesos.value="";
           document.all.cstcpodaddos.value="";
           document.all.cstcpodarriseglassos.value="";
           document.all.cstcpodbasisos.value="";
           document.all.cstcpodnumos.value="";
           document.all.cstcpodrequirementos.value="";         
       }
	}
	function setValue(){ 
		 if(document.all.cstcpodglassesbillid.value.substring(0,1)=='R' && document.all.cstcpodsalesbillid.value==''){
		    alert("重订配镜单，原单号不能为空");
		    return false;
		 } 	
        var cstcpodgoodsidod=document.all.cstcpodgoodsidod.value;
        var cstcpodgoodsnameod=document.all.cstcpodgoodsnameod.value;
        var cstcpodglassflagod=document.all.cstcpodglassflagod.value;
        var cstcpodballglassod=document.all.cstcpodballglassod.value;
        var cstcpodpostglassod=document.all.cstcpodpostglassod.value;
        var cstcpodaxesod=document.all.cstcpodaxesod.value;
        var cstcpodaddod=document.all.cstcpodaddod.value;
        var cstcpodarriseglassod=document.all.cstcpodarriseglassod.value;
        var cstcpodbasisod=document.all.cstcpodbasisod.value;
        var cstcpodnumod=document.all.cstcpodnumod.value;
        var cstcpodrequirementod=document.all.cstcpodrequirementod.value;
        
        var cstcpodgoodsidos=document.all.cstcpodgoodsidos.value;
        var cstcpodgoodsnameos=document.all.cstcpodgoodsnameos.value;
        var cstcpodglassflagos=document.all.cstcpodglassflagos.value;
        var cstcpodballglassos=document.all.cstcpodballglassos.value;
        var cstcpodpostglassos=document.all.cstcpodpostglassos.value;
        var cstcpodaxesos=document.all.cstcpodaxesos.value;
        var cstcpodaddos=document.all.cstcpodaddos.value;
        var cstcpodarriseglassos=document.all.cstcpodarriseglassos.value;
        var cstcpodbasisos=document.all.cstcpodbasisos.value; 
        var cstcpodnumos=document.all.cstcpodnumos.value;
        var cstcpodrequirementos=document.all.cstcpodrequirementos.value;
        
        var cstcpodglassesbillid=document.all.cstcpodglassesbillid.value;
        var cstcpodarriveddate=document.all.cstcpodarriveddate.value;
        var cstcpodcustomerid=$("#cstcpodcustomerid").val();
        var cstcpodcustomername=$("#cstcpodcustomername").val();   
        var cstcpodsalesbillid= document.all.cstcpodsalesbillid.value; 
        var cstcpoddragstype= document.all.dragsType.value; 
        var ssesbinterhighod= document.all.interod1.value;
        var ssesbinterhighos= document.all.interos1.value; 
        var ssesbinterdistanceod= document.all.interdistanceod1.value; 
        var ssesbinterdistanceos= document.all.interdistanceos1.value;   

        var objValueOD="{'cstcpodglassesbillid':'"+cstcpodglassesbillid+"','cstcpodarriveddate':'"+cstcpodarriveddate+"',";
        objValueOD=objValueOD+"'cstcpodbilltype':'2','cstcpodcustomerid':'"+cstcpodcustomerid+"','cstcpodcustomername':'"+cstcpodcustomername+"',";
        objValueOD=objValueOD+"'cstcpodgoodsid':'"+cstcpodgoodsidod+"','cstcpodgoodsname':'"+cstcpodgoodsnameod+"','cstcpodglassflag':'"+cstcpodglassflagod+"',";    
        objValueOD=objValueOD+"'cstcpodnum':'"+cstcpodnumod+"','cstcpodrequirement':'"+cstcpodrequirementod+"','cstcpodrequirement1':'',";
        objValueOD=objValueOD+"'cstcpodballglass':'"+cstcpodballglassod+"','cstcpodpostglass':'"+cstcpodpostglassod+"',";
        objValueOD=objValueOD+"'cstcpodaxes':'"+cstcpodaxesod+"','cstcpodadd':'"+cstcpodaddod+"','cstcpodarriseglass':'"+cstcpodarriseglassod+"','cstcpodinter':'"+ssesbinterhighod+"','cstcpodinterdistance':'"+ssesbinterdistanceod+"',";
        objValueOD=objValueOD+"'cstcpodbasis':'"+cstcpodbasisod+"','cstcpodeyecurvature':'','cstcpoddiameter':'','cstcpodordertype':'W','cstcpodsalesbillid':'"+cstcpodsalesbillid+"','cstcpoddragstype':'"+cstcpoddragstype+"'}";  

        var objValueOS="{'cstcpodglassesbillid':'"+cstcpodglassesbillid+"','cstcpodarriveddate':'"+cstcpodarriveddate+"',";
        objValueOS=objValueOS+"'cstcpodbilltype':'2','cstcpodcustomerid':'"+cstcpodcustomerid+"','cstcpodcustomername':'"+cstcpodcustomername+"',";
        objValueOS=objValueOS+"'cstcpodgoodsid':'"+cstcpodgoodsidos+"','cstcpodgoodsname':'"+cstcpodgoodsnameos+"','cstcpodglassflag':'"+cstcpodglassflagos+"',";    
        objValueOS=objValueOS+"'cstcpodnum':'"+cstcpodnumos+"','cstcpodrequirement':'"+cstcpodrequirementos+"','cstcpodrequirement1':'',";
        objValueOS=objValueOS+"'cstcpodballglass':'"+cstcpodballglassos+"','cstcpodpostglass':'"+cstcpodpostglassos+"',";
        objValueOS=objValueOS+"'cstcpodaxes':'"+cstcpodaxesos+"','cstcpodadd':'"+cstcpodaddos+"','cstcpodarriseglass':'"+cstcpodarriseglassos+"','cstcpodinter':'"+ssesbinterhighos+"','cstcpodinterdistance':'"+ssesbinterdistanceos+"',";
        objValueOS=objValueOS+"'cstcpodbasis':'"+cstcpodbasisos+"','cstcpodeyecurvature':'','cstcpoddiameter':'','cstcpodordertype':'W','cstcpodsalesbillid':'"+cstcpodsalesbillid+"','cstcpoddragstype':'"+cstcpoddragstype+"'}"; 
       
       var objValue="";      
       if(cstcpodgoodsidod!=''&&cstcpodgoodsidos!=''){
         objValue="["+objValueOD+","+objValueOS+"]";
       }else if(cstcpodgoodsidod==''&&cstcpodgoodsidos!=''){
         objValue="["+objValueOS+"]";
       }else if(cstcpodgoodsidod!=''&&cstcpodgoodsidos==''){
         objValue="["+objValueOD+"]";
       }else if(cstcpodgoodsidod==''&&cstcpodgoodsidos==''){
         alert('请选择商品');
         return false;
       }
       
      
	if(checkForm(document.all.procurementOrdersForm)){
		$('#resalesremark', parent.document).val($('#reRemark').val());
        window.parent.openConsignProcessOrdersValues(objValue);
        alert('您选择的商品信息已添加到商品列表中！'); 
        parent.hidePopWin();
        }    
	}
	
	var validate={
		num : function(obj){	
			var	valueO = obj.value;
			obj.value = obj.value.replace(/^[^1-9][0-9]*/g, '');
		},
		dotNum : function(obj){
			obj.value = obj.value.replace(/[^\+0-9\.][0-9]*/g, '');
			
			if(obj.value != '' && isNaN(obj.value.replace('+', ''))){
				obj.value = '';
			}
		}, 
		bcc : function(obj){
			obj.value = obj.value.replace(/[^-0-9\.][0-9]*/g, '');
		},
		level : function(obj){
			if(/^[\+\-]/.test(obj.value)){
				obj.value = obj.value.substring(0,1) + obj.value.replace(/[^0-9]/g,'');
			}else{
				obj.value = obj.value.replace(/[^0-9]/g,'');
			}
		}
	};

	//补零
	function addZero(obj) {	
		if(isNaN(obj.value))return;
		
		if (obj.value > 0){
			obj.value = '+' + new Number(obj.value).toFixed(2);
		}else{
			obj.value = new Number(obj.value).toFixed(2);
		}
	}

	$(document).ready(function() {
		$('input[valNum="validatedotNum"]').each(function(index){
			this.size = 10;
			this.maxlength="7";
			//给id=validatedotNum的所有对象加keyup事件		
			$(this).bind('keyup', function(){
				validate.dotNum(this);
			});
			
			$(this).bind('blur', function(){
				validate.dotNum(this);
				if(this.value != ''){
					addZero(this);
				}
			});
			
			
			
		});
		
		
		$('input[sphcyl]').each(function(){
			if($(this).attr('sphcyl')=='sph'){
				$(this).blur(function(){
					if(isNaN($(this).val())){
						alert('格式错误!');
						$(this).focus();
						$(this).val('');
						return;
					}else{
						if(parseFloat($(this).val())>0){
							var str='+'+parseFloat($(this).val().replace('+','')).toFixed(2);
							$(this).val(str);
						}else if(parseFloat($(this).val())<=0){
							$(this).val(parseFloat($(this).val()).toFixed(2));
						}
					}
				});
			}else{
				$(this).blur(function(){
					if(isNaN($(this).val())){
						alert('格式错误!');
						$(this).focus();
						$(this).val('');
						return;
					}else{
						if(parseFloat($(this).val())>0){
							if('${systemParameterPo.fspothernegative}'!='1'){
								alert('柱镜不能为正!');
							$(this).focus();
							$(this).val('');
							return;
						}else{
							var str='+'+parseFloat($(this).val().replace('+','')).toFixed(2);
							$(this).val(str);
						}
						}else if(parseFloat($(this).val())<=0){
							$(this).val(parseFloat($(this).val()).toFixed(2));
						}
					}
				});
			}
		});
	});
	
	function move(){ //近用回车一动
		$(':input[moveorder]').each(function(){
				$(this).keydown(function(){
					if(event.keyCode == 13){
						var index=$(this).attr('moveorder');
						$(':input[moveorder='+accAdd(index,1)+']').focus();
					}
				});
			});
	}
	
	$(document).ready(function(){
	move();
	$('input[moveorder=1]').focus();
	// 球镜、柱镜
	
	
});
	//处理单据变换
	function billIdUpdate(){	
       var billtype=document.all.billtype.value;
       var cstcpodglassesbillid=document.all.cstcpodglassesbillid.value;
       cstcpodglassesbillid=cstcpodglassesbillid.substring(1,19);
       cstcpodglassesbillid=billtype+cstcpodglassesbillid;
       document.all.cstcpodglassesbillid.value=cstcpodglassesbillid;
       
	}
	//查询原配镜单
	function openSales(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initSelSalesConsignProcessReceiptOpen.action?ordersType="+document.all.ordersType.value+"&deptID="+document.all.deptID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelSalesConsignProcessReceiptOpen.action?ordersType="+document.all.ordersType.value+"&deptID="+document.all.deptID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【原配镜单查询】";	
	}

	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 

	function checkadd(obj){
		if(parseFloat(obj.value)<0&&obj.value!=''){
			alert('下加光不能为负!');
			obj.value='';
			obj.focus();
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="procurementOrdersForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden"  id="ordersType" name="ordersType" value="${requestScope.ordersType}">	
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
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <TABLE cellSpacing=1 cellPadding=0 width="100%" align=center class="privateBorder"
                  border=0>
                      <TBODY>
                        <TR>
                          <TD height="26" width="9%" class="table_body">销售单号</TD>
                          <TD width="24%" class="table_none"><input class="text_input160" type="text" id="cstcpodglassesbillid" name="cstcpodglassesbillid" value="${cstcpodglassesbillid}" readonly="readonly"/></TD>

						  <TD width="9%" class="table_body">单据日期</TD>
                          <TD width="24%" class="table_none">
                          <jsp:useBean id="now" class="java.util.Date" />
                          <fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />
                          
                          <input class="text_input100" type="hidden"
					       name="cstcpobilldate" id="cstcpobilldate"
					       value="<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />"/></TD>
					       <input type="hidden" id="supplierID" name="supplierID" value="${supplierID}" />
						   		<input type="hidden" id="cstcpodcustomername" class="text_input160" name="cstcpodcustomername"  value="${salesTempPo.ssesbcustomername}" readonly="readonly" />
						   		<input type="hidden" id="cstcpodcustomerid" name="cstcpodcustomerid" value="${salesTempPo.ssesbcustomerid}"/>
						  <TD class="table_body" height="26">所属部门</TD>
						  <TD class="table_none" colspan="5">
                            <select id="deptID" name="deptID">
                             <option value="">----请选择----</option>
      		                 <s:iterator value="deptList">
				               <option value="${bdpdepartmentid}" ${requestScope.deptID == bdpdepartmentid ? 'selected="selected"' : '' }>${bdpdepartmentname}</option>
	     	                 </s:iterator>
      	                   </select>
						  </TD>
                        </TR>
                        <TR>
                          <TD class="table_body">制单人</TD>
                          <TD class="table_none">${person.personName}</TD>
                          <TD class="table_body" height="26">镜片型</TD>
                          <TD class="table_none">
                          <c:if test="${ordersType==2}">
                                框镜订做片
                          </c:if>
                          <c:if test="${ordersType==4}">
                                隐形订做片
                          </c:if>
						  </TD>
						  <TD class="table_body">预计取镜时间</TD>
                          <TD class="table_none">
                            <input id="cstcpodarriveddate"
					       name="cstcpodarriveddate" 
					       type="text" class="text_input160" 
                           validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '预计取镜时间不能为空！'}]"
					       onFocus="WdatePicker({readOnly:true})" value="${cstcpodarriveddate}"
					       /> 
						  </TD>
						  </TR>
						  <TR>
                          <TD class="table_body" height="26">单据类型</TD>
                          <TD class="table_none" >
	                          <select id="billtype" name="billtype" onChange="billIdUpdate();">
							  		<option value="W" ${requestScope.billtype == 'W' ? 'selected="selected"' : '' }>外部配镜单</option>
							  		<option value="R" ${requestScope.billtype == 'R' ? 'selected="selected"' : '' }>回修配镜单</option>
								    <option value="B" ${requestScope.billtype == 'B' ? 'selected="selected"' : '' }>报残配镜单</option>
	                          </select>
						  </TD>		       
					      <TD width="10%" class="table_body">原配镜单</TD>
						   <TD height="26" align="left" class="table_none">
						   <li class="horizontal_onlyRight">
                             <input type="text" class="text_input160" id="cstcpodsalesbillid" name="cstcpodsalesbillid" value="${salesTempPo.ssesbsalesid}" readonly="readonly"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onClick="openSales();" />
						  
						  </li></TD>
						  <TD class="table_body" height="26">委外类型</TD>
                          <TD class="table_none" >
	                          <select id="dragsType" name="dragsType">
	                          		<option value="1" ${requestScope.dragsType == 1 ? 'selected="selected"' : '' }>外订单</option>
							  		<option value="2" ${requestScope.dragsType == 2 ? 'selected="selected"' : '' }>外加工</option>
	                          </select>
						  </TD>
						  </TR>
						  <TR>
                           <TD height="26" class="table_body">备注</TD>
			               <TD class="table_none" colspan="5">
			              	<textarea id="reRemark" name="reRemark"></textarea> 	
                    	 </TD>
                        </TR>
						  <%--<TR >
                          
						  <TD class="table_body" height="26">所属门店</TD>
						  <TD class="table_none" colspan="5">
                            <select id="deptID" name="deptID">
                             <option value="">----请选择----</option>
      		                 <s:iterator value="deptList">
				               <option value="${bdpdepartmentid}" ${requestScope.deptID == bdpdepartmentid ? 'selected="selected"' : '' }>${bdpdepartmentname}</option>
	     	                 </s:iterator>
      	                   </select>
						  </TD>
					      </TR>--%>
                      </TBODY>
                    </TABLE>
                    <BR>
                    		<fieldset>
							<legend>度数录入</legend>
						    <table width="100%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
                              <tr>
                                <td><table width="100%" style="margin-bottom:3px;"  border=0 align=center cellpadding=1 cellspacing=1 class="Privateborder" id="title2">
                                  <tr>
                                    <td width="9%" height="25" bgcolor="dfffdf" class="Privateborder"><div align="center">&nbsp;</div></td>
                                    <td width="9%" height="25" bgcolor="dfffdf" class="Privateborder"><div align="center">球镜</div></td>
                                    <td width="9%" bgcolor="dfffdf" class="Privateborder"><div align="center">柱镜</div></td>
                                    <td width="9%" bgcolor="dfffdf" class="Privateborder"><div align="center">轴向</div></td>
                                    <td width="9%" bgcolor="dfffdf" class="Privateborder"><div align="center">Add</div></td>
                                    <td width="9%" bgcolor="dfffdf" class="Privateborder"><div align="center">三棱镜</div></td>
                                    <td width="9%" bgcolor="dfffdf" class="Privateborder"><div align="center">基底</div></td>
                                    <td width="9%" bgcolor="dfffdf" class="Privateborder"><div align="center">瞳距(远)</div></td>
                                    <td width="9%" bgcolor="dfffdf" class="Privateborder"><div align="center">瞳距(近)</div></td>
                                    <td width="9%" bgcolor="dfffdf" class="Privateborder"><div align="center">镜片材质</div></td>
                                    <td width="10%" bgcolor="dfffdf" class="Privateborder"><div align="center">选择</div></td>

                                  </tr>
                                  <tr>
                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                      OD
                                    </div></td>
                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                      <input moveorder="1" id="ballglassod" sphcyl="sph" name="ballglassod" class="text_input60" value="${salesTempPo.ssesbballglassod}"/>
                                    </div></td>
                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                      <input moveorder="2" id="postglassod" sphcyl="cyl"  name="postglassod" class="text_input60" value="${salesTempPo.ssesbpostglassod}"/>
                                    </div></td>
                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                      <input moveorder="3" id="axesod" name="axesod" class="text_input60" value="${salesTempPo.ssesbaxesod}"/>
                                    </div></td>
                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                      <input moveorder="4" id="addod" onBlur="checkadd(this);" sphcyl="sph" name="addod" class="text_input60" value="${salesTempPo.ssesbaddod}"/>
                                    </div></td>
                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                      <input moveorder="5" id="arriseglassod1" name="arriseglassod1" class="text_input60" value="${salesTempPo.ssesbarriseglassod1}"/>
                                    </div></td>
                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                      <input moveorder="6" id="basisod1" name="basisod1" class="text_input60" value="${salesTempPo.ssesbbasisod1}"/>
                                    </div></td>
                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                      <input moveorder="7" id="interod1" name="interod1" class="text_input60" value="${salesTempPo.ssesbinterhighod}"/>
                                    </div></td>
                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                      <input moveorder="8" id="interdistanceod1" name="interdistanceod1" class="text_input60" value="${salesTempPo.ssesbinterdistanceod}"/>                                    </div></td>
                                    </div></td>

                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                       <select id="materialTypeod" name="materialTypeod" moveorder="9">
                                         <option value="1" ${salesTempPo.bgieyeglassmaterialtypeod == '1' ? 'selected="selected"' : '' }>树脂</option>
                                         <option value="2" ${salesTempPo.bgieyeglassmaterialtypeod == '2' ? 'selected="selected"' : '' }>玻璃</option>
                                         <option value="3" ${salesTempPo.bgieyeglassmaterialtypeod == '3' ? 'selected="selected"' : '' }>PC</option>
                                       </select>
                                    </div></td>
                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
						             <img src="${ctx}/img/newbtn/btn_addgoods_0.png" btn=btn title="添加商品" onClick="javascript:openGoodsConsignProcessOrders('3','R');"/>
                                    
                                    </div></td>
                                  </tr>
                                  <tr>
                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                      OS
                                    </div></td>
                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                      <input moveorder="10" id="ballglassos" sphcyl="sph" name="ballglassos" class="text_input60" value="${salesTempPo.ssesbballglassos}"/>
                                    </div></td>
                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                      <input moveorder="11" id="postglassos" sphcyl="cyl" name="postglassos" class="text_input60" value="${salesTempPo.ssesbpostglassos}"/>
                                    </div></td>
                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                      <input moveorder="12" id="axesos" name="axesos" class="text_input60" value="${salesTempPo.ssesbaxesos}"/>
                                    </div></td>
                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                      <input moveorder="13" id="addos" onBlur="checkadd(this);" sphcyl="sph" name="addos" class="text_input60" value="${salesTempPo.ssesbaddos}"/>
                                    </div></td>
                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                      <input moveorder="14" id="arriseglassos1" name="arriseglassos1" class="text_input60" value="${salesTempPo.ssesbarriseglassos1}"/>
                                    </div></td>
                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                      <input moveorder="15" id="basisos1" name="basisos1" class="text_input60" value="${salesTempPo.ssesbbasisos1}"/>
                                    </div></td>
                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                      <input moveorder="16" id="interos1" name="interos1" class="text_input60" value="${salesTempPo.ssesbinterhighos}"/>
                                    </div></td>
                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                      <input moveorder="17" id="interdistanceos1" name="interdistanceos1" class="text_input60" value="${salesTempPo.ssesbinterdistanceos}"/>                                    </div></td>
                                    </div></td>

                                     <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                       <select id="materialTypeos" name="materialTypeos" moveorder="18">
                                         <option value="1" ${salesTempPo.bgieyeglassmaterialtypeos == '1' ? 'selected="selected"' : '' }>树脂</option>
                                         <option value="2" ${salesTempPo.bgieyeglassmaterialtypeos == '2' ? 'selected="selected"' : '' }>玻璃</option>
                                         <option value="3" ${salesTempPo.bgieyeglassmaterialtypeos == '3' ? 'selected="selected"' : '' }>PC</option>
                                       </select>
                                    </div></td>
                                    <td bgcolor="dfffdf" class="Privateborder"><div align="center">
                                   
                                      <img src="${ctx}/img/newbtn/btn_addgoods_0.png" btn=btn title="添加商品" onClick="javascript:openGoodsConsignProcessOrders('3','L');"/>
                                    </div></td>
                                  </tr>
                                </table></td>
                              </tr>
                            </table>
					      </fieldset>	
<BR>
					<fieldset>
							<legend>商品列表</legend>			
                        <TABLE width="100%" border=0 align=center cellPadding=3 cellSpacing=1 class="privateTable Privateborder" id=ctl00_PageBody_PostButton>
                          <TBODY>
                            <tr><td width="15%" height="26" class="table_body"><div align="center">商品代码</div></td>
                              <td width="18%" height="26" class="table_body"><div align="center">商品名称</div></td>
                              <td width="7%" class="table_body"><div align="center">镜片型</div></td>
                              <td width="5%" class="table_body"><div align="center">球镜</div></td>
                              <td width="5%" class="table_body"><div align="center">柱镜</div></td>
                              <td width="5%" class="table_body"><div align="center">轴向</div></td>
                              <td width="5%" class="table_body"><div align="center">下加</div></td>
                              <td width="5%" class="table_body"><div align="center">棱镜</div></td>
                              <td width="5%" class="table_body"><div align="center">基底</div></td>
                              <td width="5%" class="table_body"><div align="center">数量</div></td>
                              <td width="20%" class="table_body"><div align="center">加工要求</div></td>
                              <td width="5%" class="table_body"><div align="center">操作</div></td>
                              </tr>
                            <TR>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodgoodsidod" name="cstcpodgoodsidod" class="text_input160" readonly="readonly" value="${salesTempPo.ssesdsalesitemidod}">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodgoodsnameod" name="cstcpodgoodsnameod" class="text_input160" readonly="readonly" value="${salesTempPo.ssesdsalesitemnameod}">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodglassflagod" name="cstcpodglassflagod" class="text_input40" readonly="readonly" value="${salesTempPo.glassmaterialtypeod}">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodballglassod" name="cstcpodballglassod" class="text_input40" readonly="readonly" value="${not empty(salesTempPo.ssesdsalesitemidod) ?  (salesTempPo.ssesbballglassod):'' }">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodpostglassod" name="cstcpodpostglassod" class="text_input40" readonly="readonly" value="${not empty(salesTempPo.ssesdsalesitemidod) ?  (salesTempPo.ssesbpostglassod):'' }">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodaxesod" name="cstcpodaxesod" class="text_input40" readonly="readonly" value="${not empty(salesTempPo.ssesdsalesitemidod) ?  (salesTempPo.ssesbaxesod):'' }">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodaddod" name="cstcpodaddod" class="text_input40" readonly="readonly" value="${not empty(salesTempPo.ssesdsalesitemidod) ?  (salesTempPo.ssesbaddod):'' }">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodarriseglassod" name="cstcpodarriseglassod" class="text_input40" readonly="readonly" value="${not empty(salesTempPo.ssesdsalesitemidod) ?  (salesTempPo.ssesbarriseglassod1):'' }">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodbasisod" name="cstcpodbasisod" class="text_input40" readonly="readonly" value="${not empty(salesTempPo.ssesdsalesitemidod) ?  (salesTempPo.ssesbbasisod1):'' }">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodnumod" name="cstcpodnumod" class="text_input40" onKeyUp="value=value.replace(/[^\d]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(0);}" value="${not empty(salesTempPo.ssesdsalesitemidod) ?  (salesTempPo.ssesdnumberod):'' }">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodrequirementod" name="cstcpodrequirementod" class="text_input160" value="${not empty(salesTempPo.ssesdsalesitemidod) ?  (salesTempPo.requirement):'' }">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean('R')" >
                                 
                              </div></TD>
                            </TR>
                            <TR>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodgoodsidos" name="cstcpodgoodsidos" class="text_input160" readonly="readonly" value="${salesTempPo.ssesdsalesitemidos}">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodgoodsnameos" name="cstcpodgoodsnameos" class="text_input160" readonly="readonly" value="${salesTempPo.ssesdsalesitemnameos}">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodglassflagos" name="cstcpodglassflagos" class="text_input40" readonly="readonly" value="${salesTempPo.glassmaterialtypeos}">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodballglassos" name="cstcpodballglassos" class="text_input40" readonly="readonly" value="${not empty(salesTempPo.ssesdsalesitemidos) ?  (salesTempPo.ssesbballglassos):'' }">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodpostglassos" name="cstcpodpostglassos" class="text_input40" readonly="readonly" value="${not empty(salesTempPo.ssesdsalesitemidos) ?  (salesTempPo.ssesbpostglassos):'' }">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodaxesos" name="cstcpodaxesos" class="text_input40" readonly="readonly" value="${not empty(salesTempPo.ssesdsalesitemidos) ?  (salesTempPo.ssesbaxesos):'' }">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodaddos" name="cstcpodaddos" class="text_input40" readonly="readonly" value="${not empty(salesTempPo.ssesdsalesitemidos) ?  (salesTempPo.ssesbaddos):'' }">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodarriseglassos" name="cstcpodarriseglassos" class="text_input40" readonly="readonly" value="${not empty(salesTempPo.ssesdsalesitemidos) ?  (salesTempPo.ssesbarriseglassos1):'' }">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodbasisos" name="cstcpodbasisos" class="text_input40" readonly="readonly" value="${not empty(salesTempPo.ssesdsalesitemidos) ?  (salesTempPo.ssesbbasisos1):'' }">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodnumos" name="cstcpodnumos" class="text_input40" onKeyUp="value=value.replace(/[^\d]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(0);}" value="${not empty(salesTempPo.ssesdsalesitemidos) ?  (salesTempPo.ssesdnumberos):'' }">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                  <input id="cstcpodrequirementos" name="cstcpodrequirementos" class="text_input160" value="${not empty(salesTempPo.ssesdsalesitemidos) ?  (salesTempPo.requirement):'' }">
                              </div></TD>
                              <TD align="left" class="Privateborder"><div align="center">
                                 <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean('L')" >
                              </div></TD>
                            </TR>
                        </TABLE>
						</fieldset>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								 <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onClick="setValue();" />
						  
							</td>
						</tr>
					</table>

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
<br><br>
<%@ include file="/WEB-INF/inc/message.jsp" %>