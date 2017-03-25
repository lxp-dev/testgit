<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>验光检查</title>
</head>
<script>	
	function cleanTable(){
	}
	
	function notdisplayTable(obj){
		var yy = document.all.yy;
		var jy = document.all.jy;
		var jj = document.all.jj;
		var yx = document.all.yx;
		cleanTable();
		var ctl00_PageBody_PostButton = document.all.ctl00_PageBody_PostButton;
		var fz = document.all.fz;
		ctl00_PageBody_PostButton.style.display = '';
		fz.style.display = '';		
		
		
		var myValue = obj.value;
		//1 远用
		//2 近用
		//3 渐进/双光
		//4 隐形
		//5 远用+近用
		//6 远用+隐形
		//7 近用+隐形
		//8 渐进/双光+隐形
		//9 渐进/双光+远用
		//10 渐进/双光+近用
		//11 远用+近用+隐形
		//12 远用+近用+渐进/双光
		if(myValue == "1"){
			yy.style.display = '';
		}else if(myValue == "2"){
			jy.style.display = '';
		}else if(myValue == "3"){
			jj.style.display = '';
		}else if(myValue == "4"){
			yx.style.display = '';
		}else if(myValue == "5"){
			yy.style.display = '';
			jy.style.display = '';
		}else if(myValue == "6"){
			yy.style.display = '';
			yx.style.display = '';
		}else if(myValue == "7"){
			jy.style.display = '';
			yx.style.display = '';
		}else if(myValue == "8"){
			jj.style.display = '';
			yx.style.display = '';
		}else if(myValue == "9"){
			jj.style.display = '';
			yy.style.display = '';
		}else if(myValue == "10"){
			jj.style.display = '';
			jy.style.display = '';
		}else if(myValue == "11"){
			yy.style.display = '';
			jy.style.display = '';
			yx.style.display = '';
		}else if(myValue == "12"){
			yy.style.display = '';
			jy.style.display = '';
			jj.style.display = '';
		}
	}
	
	function displayTable2(myValue){
		var yy = document.all.yy;
		var jy = document.all.jy;
		var jj = document.all.jj;
		var yx = document.all.yx;
		cleanTable();
		var ctl00_PageBody_PostButton = document.all.ctl00_PageBody_PostButton;
		var fz = document.all.fz;
		ctl00_PageBody_PostButton.style.display = '';
		fz.style.display = '';		

		//1 远用
		//2 近用
		//3 渐进/双光
		//4 隐形
		//5 远用+近用
		//6 远用+隐形
		//7 近用+隐形
		//8 渐进/双光+隐形
		//9 渐进/双光+远用
		//10 渐进/双光+近用
		//11 远用+近用+隐形
		//12 远用+近用+渐进/双光
		if(myValue == "1"){
			yy.style.display = '';
		}else if(myValue == "2"){
			jy.style.display = '';
		}else if(myValue == "3"){
			jj.style.display = '';
		}else if(myValue == "4"){
			yx.style.display = '';
		}else if(myValue == "5"){
			yy.style.display = '';
			jy.style.display = '';
		}else if(myValue == "6"){
			yy.style.display = '';
			yx.style.display = '';
		}else if(myValue == "7"){
			jy.style.display = '';
			yx.style.display = '';
		}else if(myValue == "8"){
			jj.style.display = '';
			yx.style.display = '';
		}else if(myValue == "9"){
			jj.style.display = '';
			yy.style.display = '';
		}else if(myValue == "10"){
			jj.style.display = '';
			jy.style.display = '';
		}else if(myValue == "11"){
			yy.style.display = '';
			jy.style.display = '';
			yx.style.display = '';
		}else if(myValue == "12"){
			yy.style.display = '';
			jy.style.display = '';
			jj.style.display = '';
		}
	}
	function cleanTableAll(){
		var yy = document.all.yy;
		var jy = document.all.jy;
		var jj = document.all.jj;
		var yx = document.all.yx;
		
		var ctl00_PageBody_PostButton = document.all.ctl00_PageBody_PostButton;
		var fz = document.all.fz;
		
		yy.style.display = 'none';
		jy.style.display = 'none';
		jj.style.display = 'none';
		yx.style.display = 'none';
		ctl00_PageBody_PostButton.style.display = 'none';
		fz.style.display = 'none';
	}
	
	$(document).ready(function(){
		searchButton();
		$('#glassType').attr('value','${glassType}');
		displayTable2('${glassType}');
		if('${readOnly}'=='readOnly'){
			$('#smecimemberid').attr("readonly","readonly");
		}
		displayTable('');
		
	});
	
	//嵌入页查找按钮锁死sxh
	function searchButton(){
		var customerID = document.all.customerID.value;
		if(customerID != null){
			document.getElementById('searchbutton').disabled = 'disabled';
		}
	}
	function doubleEyeFun(){
		var dontshow = $('#dontshow').val();
		inspectionForm.action="selectDoubleEyeFunAier.action?dontshow="+dontshow;
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
	
	function specialCheck(){
		var dontshow = $('#dontshow').val();
		inspectionForm.action="selectSpecialCheckAier.action?dontshow="+dontshow;
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
	
	function refractive(){
		var dontshow = $('#dontshow').val();
		inspectionForm.action="initRefractiveSelectAier.action?dontshow="+dontshow;
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
	
	function glassHistory(){
		inspectionForm.action="selectGlassesHistoryAier.action?viewDetail=true";
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
	
  allTrafficCount=1   
  allCount=1  
  var xzindex = 0;
  function   displayTable(myValue)   //增加一行   
  {   
      newRow=trafficeList.insertRow(trafficeList.rows.length);   
      newRow.id="tradt";   
      newRow.ln=allTrafficCount;   
         
      c1=newRow.insertCell(0);
      c1.id="tradtRow";
      c1.ln=allCount;
	  var listindex = allTrafficCount;
	  <c:forEach var="po" items="${inspectionPos}" varStatus="idxStatus">
	  if("${po.sopipglasstype }" == "1"){
		  
	        c1.innerHTML=c1.innerHTML+"<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='1'/><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='yy'><TR><TD colspan='14' style='height:20px' class='PrivateBorderGreen' bgcolor='dfffdf'><p>框架--远用&nbsp;&nbsp;&nbsp;<br></p></TD>	</TR><TR><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'>&nbsp;</TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>球镜</div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>柱镜</div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>轴向</div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>三棱镜</div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>基底</div></TD>"
	        							+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>远用瞳距(mm)</div></TD>"
	        							+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>瞳高(mm)</div></TD>"
	        							+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>远用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#DFFFDF' class='PrivateBorderGreen'>OD</TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyneedChange='needChange' yyorder='1'  sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' class='text_input' size='4' value="+"${po.sopipballglassod}"+"></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonly needChange='needChange' yyorder='2' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' value='"+"${po.sopippostglassod}"+"' class='text_input cyl' size='4'></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonly  axes='axes' yyorder='3' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' value='"+"${po.sopipaxesod}"+"' class='text_input axes' size='4'></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='4' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' value='"+"${po.sopiparriseglassod1}"+"' class='text_input' size='4' value=''></div></TD><TD width='6%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><select disabled=disabled  yyorder='5' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1'><option value='' selected='selected'>----请选择----</option>"
										+"<s:iterator value='optionParamPolist'>"
									    +"   <c:if test='${fopparentid == \'24\'}'>"
									    +"       <option value='${fopparamid}'  ${po.sopipbasisod1  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
									    +"   </c:if>"
									    +"</s:iterator>"	
	        							+"</select></div></TD>"
	        							+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='6' tongju='tongju' value='${po.sopipinterhighod}' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' class='text_input' size='4' value=''></div></TD>"
	        							+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='6' tongju='tongju' value='${po.sopippupilheightod}' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' class='text_input' size='4' value=''></div></TD>"
	        							+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='7' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' class='text_input' size='4' value='${po.sopipfarvaod  }'></div></TD></TR><TR><TD width='11%' bgcolor='#DFFFDF' class='PrivateBorderGreen'>OS</TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyneedChange='needChange' yyorder='8' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' class='text_input' size='4' value='${po.sopipballglassos }'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyneedChange='needChange' yyorder='9' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' class='text_input' size='4' value='${po.sopippostglassos }'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyaxes='axes' yyorder='10' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' value='${po.sopipaxesos }' class='text_input' size='4'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyljxj='ljxj' yyorder='11' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' value='${po.sopiparriseglassos1 }' class='text_input' size='4'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><select disabled=disabled  yyorder='12' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1'><option value='' selected='selected'>----请选择----</option>"
										+"<s:iterator value='optionParamPolist'>"
									    +"   <c:if test='${fopparentid == \'24\'}'>"
									    +"       <option value='${fopparamid}'  ${po.sopipbasisos1  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
									    +"   </c:if>"
									    +"</s:iterator>"	
	        							+"</select></div></TD>"
	        							+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' class='text_input' size='4' value='${po.sopipinterhighos }'></div></TD>"
	        							+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' class='text_input' size='4' value='${po.sopippupilheightos }'></div></TD>"
	        							+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='14' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos' class='text_input' size='4' value='${po.sopipfarvaos  }'></div></TD></TR><TR><TD colspan='6' bgcolor='#DFFFDF' class='PrivateBorderGreen'><li class='horizontal'><div align='center'></div></li><li class='horizontal'><div align='center'></div></li></TD><TD colspan='4' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>中距离：<input readonly=readonly type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance' ${po.sopipmiddledistance != '1' ? '':'checked=checked'}>建议镜框：<select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'>"
	        							+"<OPTION value='' selected>----请选择----</OPTION>"
										+"<s:iterator value='optionParamPolist'>"
									    +"   <c:if test='${fopparentid == \'52\'}'>"
									    +"       <option value='${fopparamid}'  ${po.sopipsuggestframe  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
									    +"   </c:if>"
									    +"</s:iterator>"        							
	        							+"</SELECT><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' value='${po.sopipframeheight}' size='12'></div></TD></TR><TR><TD colspan='2' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='right'>建议镜片材质:<TD colspan='1' bgcolor='#DFFFDF' class='PrivateBorderGreen'>"
	        							+"<select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'>"
	        							+"<OPTION value='' selected>----请选择----</OPTION>"
									    +"<s:iterator value='optionParamPolist'>"
									    +"   <c:if test='${fopparentid == \'53\'}'>"
									    +"       <option value='${fopparamid}'  ${po.sopipglassmaterial  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
									    +"   </c:if>"
									    +"</s:iterator>"  								    
	        							+"</SELECT></TD><TD bgcolor='#DFFFDF' class='PrivateBorderBlue'><div align='right'>处理方式： </div></TD><TD colspan='2' bgcolor='#DFFFDF' class='PrivateBorderGreen'><select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'><option value='' selected>----请选择----</option>"
									    +"<s:iterator value='optionParamPolist'>"
									    +"   <c:if test='${fopparentid == \'54\'}'>"
									    +"       <option value='${fopparamid}'  ${po.sopipdisposemanner  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
									    +"   </c:if>"
									    +"</s:iterator>" 
	        							
	        							+"</select></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='right'>备注:</div></TD><TD colspan='3' bgcolor='#DFFFDF' class='PrivateBorderGreen'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'>${po.sopipdignosisre}</textarea></TD></TR></TBODY></TABLE>";
		     					
		  }
		  
		  if("${po.sopipglasstype }" == "2"){
			  
			c1.innerHTML=c1.innerHTML+"<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='2'/><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='jy'><TR><TD colspan='14' style='height:20px' class='PrivateBorderBlue' bgcolor='#E1EBFD'><p>框架--近用&nbsp;&nbsp;&nbsp;<br></p></TD></TR><TR><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'>&nbsp;</TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>球镜</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>柱镜</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>轴向</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>三棱镜</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>基底</div></TD>"
										+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>近用瞳距(mm)</div></TD>"
										+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>瞳高(mm)</div></TD>"
										+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>近用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#E1EBFD' class='PrivateBorderBlue'>OD</TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='1' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' value='${po.sopipballglassod }' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='2' needChange='needChange' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' value='${po.sopippostglassod }' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='3' axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' value='${po.sopipaxesod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='5' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' class='text_input' size='4' value='${po.sopiparriseglassod1 }'></div></TD><TD width='6%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><select disabled=disabled  jjorder='6' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1'><option value='' selected='selected'>----请选择----</option>"

										+"<s:iterator value='optionParamPolist'>"
									    +"   <c:if test='${fopparentid == \'24\'}'>"
									    +"       <option value='${fopparamid}'  ${po.sopipbasisod1  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
									    +"   </c:if>"
									    +"</s:iterator>"	
									    
	                                    +"</select></div></TD>"
										+"<TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='7' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceod' class='text_input' size='4' value='${po.sopipinterdistanceod }'></div></TD>"
										+"<TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='7' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' class='text_input' size='4' value='${po.sopippupilheightod }'></div></TD>"
										+"<TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='8' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaod' class='text_input' size='4' value='${po.sopipclosevaod}'></div></TD></TR><TR><TD width='11%' bgcolor='#E1EBFD' class='PrivateBorderBlue'>OS</TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='9' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' value='${po.sopipballglassos }' class='text_input' size='4'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='10' needChange='needChange' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' value='${po.sopippostglassos }' class='text_input' size='4'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='11' axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' value='${po.sopipaxesos }' class='text_input' size='4'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='13' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' class='text_input' size='4' value='${po.sopiparriseglassos1 }'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><select disabled=disabled  jjorder='14' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1'><option value='' selected='selected'>----请选择----</option>"

										+"<s:iterator value='optionParamPolist'>"
									    +"   <c:if test='${fopparentid == \'24\'}'>"
									    +"       <option value='${fopparamid}'  ${po.sopipbasisos1  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
									    +"   </c:if>"
									    +"</s:iterator>"
									    
										+"</select></div></TD>"
										+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='15' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceos' class='text_input' size='4' value='${po.sopipinterdistanceos }'></div></TD>"
										+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='15' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' class='text_input' size='4' value='${po.sopippupilheightos }'></div></TD>"
										+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='16' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaos' class='text_input' size='4' value='${po.sopipclosevaos }'></div></TD></TR><TR><TD colspan='7' bgcolor='#E1EBFD' class='PrivateBorderBlue'><li class='horizontal'><div align='center'></div></li><li class='horizontal'><div align='center'></div></li></TD><TD colspan='5' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>中距离：<input readonly=readonly type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance' ${po.sopipmiddledistance != '1' ? '':'checked=checked'}>建议镜框：<select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'><OPTION value=''>----请选择----</OPTION>"

										+"<s:iterator value='optionParamPolist'>"
									    +"   <c:if test='${fopparentid == \'52\'}'>"
									    +"       <option value='${fopparamid}'  ${po.sopipsuggestframe  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
									    +"   </c:if>"
									    +"</s:iterator>" 

										+"</SELECT><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' value='${po.sopipframeheight}' size='12'></div></TD></TR><TR><TD colspan='2' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='right'>建议镜片材质:</div></TD><TD colspan='2' bgcolor='#E1EBFD' class='PrivateBorderBlue'><select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'><OPTION value='' selected>----请选择----</OPTION>"

										+"<s:iterator value='optionParamPolist'>"
									    +"   <c:if test='${fopparentid == \'53\'}'>"
									    +"       <option value='${fopparamid}'  ${po.sopipglassmaterial  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
									    +"   </c:if>"
									    +"</s:iterator>" 

										+"</SELECT></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='right'>处理方式： </div></TD><TD colspan='2' bgcolor='#E1EBFD' class='PrivateBorderBlue'><select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'><option value='' selected>----请选择----</option>"

										+"<s:iterator value='optionParamPolist'>"
									    +"   <c:if test='${fopparentid == \'54\'}'>"
									    +"       <option value='${fopparamid}'  ${po.sopipdisposemanner  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
									    +"   </c:if>"
									    +"</s:iterator>" 
									    
										+"</select></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='right'>备注： </div></TD><TD colspan='4' bgcolor='#E1EBFD' class='PrivateBorderBlue'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'>${po.sopipdignosisre}</textarea></TD></TR></TBODY></TABLE>";
			
		  }
		  
		  if("${po.sopipglasstype }" == "3"){
			  
			c1.innerHTML=c1.innerHTML+"<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='3'/><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='jj'><TR><TD colspan='12' style='height:20px' class='PrivateBorderYellow' bgcolor='#FBF3BD'>框架--双光/渐进&nbsp;&nbsp;&nbsp;</TD></TR><TR><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'>&nbsp;</TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>球镜</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>柱镜</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>轴向</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>Add</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>三棱镜</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>基底</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>远用瞳距(mm)</div></TD>"
										+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>近用瞳距(mm)</div></TD>"
										+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>瞳高(mm)</div></TD>"
										+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>远用VA</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>近用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#FBF3BD' class='PrivateBorderYellow'>OD</TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='1' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' value='${po.sopipballglassod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='2' needChange='needChange' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' value='${po.sopippostglassod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='3' axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' value='${po.sopipaxesod}' class='text_input' size='4'></div></TD> <TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='4'  needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipaddod' value='${po.sopipaddod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='5' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' class='text_input' size='4' value='${po.sopiparriseglassod1 }'></div></TD><TD width='6%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><select disabled=disabled  jjsgorder='6' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1'><option value='' selected='selected'>----请选择----</option>"

										+"<s:iterator value='optionParamPolist'>"
									    +"   <c:if test='${fopparentid == \'24\'}'>"
									    +"       <option value='${fopparamid}'  ${po.sopipbasisod1  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
									    +"   </c:if>"
									    +"</s:iterator>"	
									    
										+"</select></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='7' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' class='text_input' size='4' value='${po.sopipinterhighod}'></div></TD>"
										+"<TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='8' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceod' class='text_input' size='4' value='${po.sopipinterdistanceod}'></div></TD>"
										+"<TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='8' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' class='text_input' size='4' value='${po.sopippupilheightod}'></div></TD>"
										+"<TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='9' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' class='text_input' size='4' value='${po.sopipfarvaod}'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='10' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaod' class='text_input' size='4' value='${po.sopipclosevaod}'></div></TD></TR><TR><TD width='11%' bgcolor='#FBF3BD' class='PrivateBorderYellow'>OS</TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='11' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' value='${po.sopipballglassos}' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='12' needChange='needChange' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' value='${po.sopippostglassos}' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='13' axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' value='${po.sopipaxesos}' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='14'  needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipaddos' value='${po.sopipaddos}' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='15' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' value='${po.sopiparriseglassos1}' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><select disabled=disabled  jjsgorder='16' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1'><option value='' selected='selected'>----请选择----</option>"

		                                +"<s:iterator value='optionParamPolist'>"
									    +"   <c:if test='${fopparentid == \'24\'}'>"
									    +"       <option value='${fopparamid}'  ${po.sopipbasisos1  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
									    +"   </c:if>"
									    +"</s:iterator>"
									    
										+"</select></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='17' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' class='text_input' size='4' value='${po.sopipinterhighos}'></div></TD>"
										+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='18' tongju='tongju'  name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceos' class='text_input' size='4' value='${po.sopipinterdistanceos}'></div></TD>"
										+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='18' tongju='tongju'  name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' class='text_input' size='4' value='${po.sopippupilheightos}'></div></TD>"
										+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='19' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos' class='text_input' size='4' value='${po.sopipfarvaos}'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='20' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaos' class='text_input' size='4' value='${po.sopipclosevaos}'></div></TD></TR><TR><TD colspan='7' bgcolor='#FBF3BD' class='PrivateBorderYellow'></TD><TD colspan='5' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>中距离：<input readonly=readonly type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance' ${po.sopipmiddledistance != '1' ? '':'checked=checked'}>建议镜框：<select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'><OPTION value='' selected>----请选择----</OPTION>"

										+"<s:iterator value='optionParamPolist'>"
									    +"   <c:if test='${fopparentid == \'52\'}'>"
									    +"       <option value='${fopparamid}'  ${po.sopipsuggestframe  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
									    +"   </c:if>"
									    +"</s:iterator>"
									    
										+"</SELECT><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' size='12' value='${po.sopipframeheight}'></div></TD></TR><TR><TD colspan='2' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='right'>建议镜片材质： </div></TD><TD colspan='2' bgcolor='#FBF3BD' class='PrivateBorderYellow'><select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'><OPTION value='' selected>----请选择----</OPTION>"

										+"<s:iterator value='optionParamPolist'>"
									    +"   <c:if test='${fopparentid == \'53\'}'>"
									    +"       <option value='${fopparamid}'  ${po.sopipglassmaterial  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
									    +"   </c:if>"
									    +"</s:iterator>"
									    
										+"</SELECT></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='right'>处理方式： </div></TD><TD colspan='2' bgcolor='#FBF3BD' class='PrivateBorderYellow'><select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'><option value='' selected>----请选择----</option>"

										+"<s:iterator value='optionParamPolist'>"
									    +"   <c:if test='${fopparentid == \'54\'}'>"
									    +"       <option value='${fopparamid}'  ${po.sopipdisposemanner  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
									    +"   </c:if>"
									    +"</s:iterator>"
									    
										+"</select></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='right'>备注： </div></TD><TD colspan='4' bgcolor='#FBF3BD' class='PrivateBorderYellow'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'>${po.sopipdignosisre}</textarea></TD></TR></TBODY></TABLE>";
			
		  }
		  
		  if("${po.sopipglasstype }" == "4"){
			  
			c1.innerHTML=c1.innerHTML+"<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='4'/><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='yx'><TR><TD colspan='11' style='height:20px' class='PrivateBorderPink' bgcolor='#F8E0F0'>隐形&nbsp;&nbsp;&nbsp;</TD></TR><TR><TD width='3%' bgcolor='#F8E0F0' class='PrivateBorderPink'>&nbsp;</TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>球镜</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>柱镜</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>轴向</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>曲率1</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>曲率2</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>直径</div></TD><TD width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形VA</div></TD><TD width='44%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形镜片</div></TD><TD width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>片/盒数</div></TD><TD width='11%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形处理方式</div></TD></TR><TR><TD bgcolor='#F8E0F0' class='PrivateBorderPink'>OD</TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyneedChange='needChange' sph='sph' id='sopipballglassod' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' value='${po.sopipballglassod}' class='text_input' size='2'  enter='enter1'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyneedChange='needChange' cyl='cyl' id='sopippostglassod' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' value='${po.sopippostglassod}' class='text_input' size='2'  enter='enter2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyaxes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' value='${po.sopipaxesod}' class='text_input' size='2'  enter='enter3'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonly name='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureod1' value='${po.sopipeyecurvatureod1}' class='text_input' size='2'   enter='enter4'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureod2' value='${po.sopipeyecurvatureod2}' class='text_input' size='2'  enter='enter5'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipdiameterod' value='${po.sopipdiameterod}' class='text_input' size='2'  enter='enter6'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipconlenvaod' value='${po.sopipconlenvaod}' class='text_input' size='2'  enter='enter7'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><li class='horizontal'>适用镜片：<input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglassesod' value='${po.sopipcommendglassesod}' syjpod='"+allTrafficCount+"' id='cc1.commendglasses22' size='8' readOnly></li><li class='horizontal'></li><li class='horizontal'></li></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipconlenodnum' value='${po.sopipconlenodnum}' class='text_input' size='1'></div></TD><TD rowspan='2' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><div align='center'><select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipconrecipetype'><option value='' selected='selected'>----请选择----</option>"

			+"<s:iterator value='optionParamPolist'>"
		    +"   <c:if test='${fopparentid == \'55\'}'>"
		    +"       <option value='${fopparamid}'  ${po.sopipconrecipetype  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
		    +"   </c:if>"
		    +"</s:iterator>"
		    
			+"</select></div></div></TD></TR><TR><TD bgcolor='#F8E0F0' class='PrivateBorderPink'>OS</TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyneedChange='needChange' sph='sph' id='sopipballglassos' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' value='${po.sopipballglassos}' class='text_input' size='2'  enter='enter8'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyneedChange='needChange' cyl='cyl' id='sopippostglassos' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' value='${po.sopippostglassos}' class='text_input' size='2'  enter='enter9'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyaxes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' value='${po.sopipaxesos}' class='text_input' size='2'  enter='enter10'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureos1' value='${po.sopipeyecurvatureos1}' class='text_input' size='2'  enter='enter11'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureos2' value='${po.sopipeyecurvatureos2}' class='text_input' size='2'  enter='enter12'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipdiameteros' value='${po.sopipdiameteros}' class='text_input' size='2'  enter='enter13'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipconlenvaos' value='${po.sopipconlenvaos}' class='text_input' size='2'  enter='enter14'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><li class='horizontal'>适用镜片：<input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglassesos' value='${po.sopipcommendglassesos}' id='cc1.commendglasses22' size='8' readOnly></li><li class='horizontal'></li><li class='horizontal'></li></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipconlenosnum' value='${po.sopipconlenosnum}' class='text_input' size='1'></div></TD></TR><TBODY><TR><TD colspan='2' bgcolor='#F8E0F0' class='PrivateBorderPink'>护理液品种:</TD><TD colspan='9' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='left'><textarea readonly='readonly'  id='sopipcommendcardwater' name='inspectionPos["+Subtr(1,listindex)+"].sopipcommendcardwater'>${po.sopipcommendcardwater}</textarea></div></TD></TR></TBODY></TABLE></td></tr></table>";
			
		  }
		  
		  if("${po.sopipglasstype }" == "5"){
			  
			c1.innerHTML=c1.innerHTML+"<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='5'/><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='zy'><TR><TD colspan='14' style='height:20px' class='PrivateBorderGreen' bgcolor='00bbff'><p>框架--中用&nbsp;&nbsp;&nbsp;<br></p></TD>	</TR><TR><TD bgcolor='#00bbff' class='PrivateBorderGreen'>&nbsp;</TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>球镜</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>柱镜</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>轴向</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>三棱镜</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>基底</div></TD>"
										+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>中用瞳距(mm)</div></TD>"
										+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>瞳高(mm)</div></TD>"
										+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>中用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#00bbff' class='PrivateBorderGreen'>OD</TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyneedChange='needChange' yyorder='1' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' value='${po.sopipballglassod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonly needChange='needChange' yyorder='2' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' value='${po.sopippostglassod}' class='text_input cyl' size='4'></div></TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonly  axes='axes' yyorder='3' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' value='${po.sopipaxesod}' class='text_input axes' size='4'></div></TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='4' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' value='${po.sopiparriseglassod1}' class='text_input' size='4'></div></TD><TD width='6%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><select disabled=disabled  yyorder='5' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1'><option value=''>----请选择----</option>"

		                                +"<s:iterator value='optionParamPolist'>"
									    +"   <c:if test='${fopparentid == \'24\'}'>"
									    +"       <option value='${fopparamid}'  ${po.sopipbasisod1  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
									    +"   </c:if>"
									    +"</s:iterator>"
									    
										+"</select></div></TD>"
										+"<TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='6' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' class='text_input' size='4' value='${po.sopipinterhighod}'></div></TD>"
										+"<TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='6' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' class='text_input' size='4' value='${po.sopippupilheightod}'></div></TD>"
										+"<TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='7' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' class='text_input' size='4' value='${po.sopipfarvaod}'></div></TD></TR><TR><TD width='11%' bgcolor='#00bbff' class='PrivateBorderGreen'>OS</TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyneedChange='needChange' yyorder='8' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' value='${po.sopipballglassos}' class='text_input' size='4'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyneedChange='needChange' yyorder='9' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' value='${po.sopippostglassos}' class='text_input' size='4'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyaxes='axes' yyorder='10' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' value='${po.sopipaxesos}' class='text_input' size='4'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyljxj='ljxj' yyorder='11' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' class='text_input' size='4' value='${po.sopiparriseglassos1 }'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><select disabled=disabled  yyorder='12' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1'><option value='' selected='selected'>----请选择----</option>"

		                                +"<s:iterator value='optionParamPolist'>"
									    +"   <c:if test='${fopparentid == \'24\'}'>"
									    +"       <option value='${fopparamid}'  ${po.sopipbasisos1  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
									    +"   </c:if>"
									    +"</s:iterator>"
									    
										+"</select></div></TD>"
										+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' class='text_input' size='4' value='${po.sopipinterhighos }'></div></TD>"
										+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' class='text_input' size='4' value='${po.sopippupilheightos }'></div></TD>"
										+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyva='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos' readonly='readonly' class='text_input' size='4' value='${po.sopipfarvaos}'></div></TD></TR><TR><TD colspan='6' bgcolor='#00bbff' class='PrivateBorderGreen'><li class='horizontal'><div align='center'></div></li></TD><TD colspan='4' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>中距离：<input readonly=readonly type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance' ${po.sopipmiddledistance != '1' ? '':'checked=checked'}>建议镜框：<select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'><OPTION value='' selected>----请选择----</OPTION>"

		                                +"<s:iterator value='optionParamPolist'>"
									    +"   <c:if test='${fopparentid == \'52\'}'>"
									    +"       <option value='${fopparamid}'  ${po.sopipsuggestframe  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
									    +"   </c:if>"
									    +"</s:iterator>"
									    
										+"</SELECT><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' value='${po.sopipframeheight}' size='12'></div></TD></TR><TR><TD colspan='2' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='right'>建议镜片材质:<TD colspan='2' bgcolor='#00bbff' class='PrivateBorderGreen'><select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'><OPTION value='' selected>----请选择----</OPTION>"

		                                +"<s:iterator value='optionParamPolist'>"
									    +"   <c:if test='${fopparentid == \'53\'}'>"
									    +"       <option value='${fopparamid}'  ${po.sopipglassmaterial  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
									    +"   </c:if>"
									    +"</s:iterator>"
									    
										+"</SELECT></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'><option value='' selected>----请选择----</option>"

		                                +"<s:iterator value='optionParamPolist'>"
									    +"   <c:if test='${fopparentid == \'54\'}'>"
									    +"       <option value='${fopparamid}'  ${po.sopipdisposemanner  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
									    +"   </c:if>"
									    +"</s:iterator>"
									    
										+"</select></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='left'>备注:</div></TD><TD colspan='3' bgcolor='#00bbff' class='PrivateBorderGreen'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'>${po.sopipdignosisre}</textarea></TD></TR></TBODY></TABLE>";
		  }
		  
		  if("${po.sopipglasstype }" == "6"){
		  
				c1.innerHTML=c1.innerHTML+"<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='6'/>"
			  								+"<TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='yx'><TR>"
			  								+"<TD id='yxs' colspan='17' style='height:20px' class='PrivateBorderPink' bgcolor='#F8E0F0'>"
			  								+"<p>角膜塑形镜&nbsp;&nbsp;&nbsp;</p></TD></TR>"
			  								+"<tr>"
			  								+"<td rowspan='2'  width='5%' su=lxd bgcolor='#F8E0F0' class='PrivateBorderPink'></td>"
			  								+"<td bgcolor='#F8E0F0' class='PrivateBorderPink' style='height:20px' colspan='7'><div align='center'>屈光处方及角膜参数</div></td>"
			  								+"<td su=lxd bgcolor='#F8E0F0' class='PrivateBorderPink' align='center'>试戴片</td>"
			  								+"<td bgcolor='#F8E0F0' class='PrivateBorderPink' colspan='5'><div align='center'>订片参数</div></td>"
			  								+"<td su=lxd bgcolor='#F8E0F0' class='PrivateBorderPink'></td>"
			  								+"</tr><TR>"
			  								+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>球镜</div></TD>"
			  								+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>柱镜</div></TD>"
			  								+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>轴向</div></TD>"
			  								+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>平K</div></TD>"
			  								+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>陡K</div></TD>"
			  								+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>e值</div></TD>"
			  								+"<TD width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>角膜直径</div></TD>"
			  								+"<TD su=eae width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>K</div></TD>"
			  								+"<TD su=eae width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>K1</div></TD>"
			  								+"<TD su=eae width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>K2</div></TD>"
			  								+"<TD su=eae width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>光度</div></TD>"
			  								+"<TD su=eae width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>降度</div></TD>"
			  								+"<TD su=lxd width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>直径</div></td>"
			  								+"<TD width='44%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形镜片</div></TD>"
			  								+"</TR><TR>"
			  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'>OD</TD>"
			  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input needChange='needChange' sph='sph' id='sopipballglassod' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' value='${po.sopipballglassod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter1'></div></TD>"
			  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input needChange='needChange' cyl='cyl' id='sopippostglassod' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' value='${po.sopippostglassod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter2'></div></TD>"
			  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' value='${po.sopipaxesod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter6'></div></TD>"
			  								+"<TD su=lxd bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipupkod' value='${po.sopipupkod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
			  								+"<TD su=lxd bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipdownkod' value='${po.sopipdownkod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
			  								+"<TD su=lxd bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipeod' value='${po.sopipeod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
			  								+"<TD su=ht bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipcornealdiameterod' value='${po.sopipcornealdiameterod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
			  								+"<TD su=ht bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipk0od' value='${po.sopipk0od}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
			  								+"<TD su=ht bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipk1od' value='${po.sopipk1od}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
			  								+"<TD su=ht bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipk2od' value='${po.sopipk2od}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
			  								+"<TD su=ht bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipupcod' value='${po.sopipupcod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
			  								+"<TD su=rb bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipdowncod' value='${po.sopipdowncod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
			  								+"<TD su=rb bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipdiameterod' value='${po.sopipdiameterod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
			  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><li class='horizontal'>适用镜片："
			  								+"<INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglassesod' value='${po.sopipcommendglassesod}' id='cc1.commendglasses22' size='8' readOnly></li>"
			  								+"</TD>"
			  								+"</TR><TR><TD bgcolor='#F8E0F0' class='PrivateBorderPink'>OS</TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input needChange='needChange' sph='sph' id='sopipballglassos' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' value='${po.sopipballglassos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter8'></div></TD>"
			  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input needChange='needChange' cyl='cyl' id='sopippostglassos' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' value='${po.sopippostglassos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter9'></div></TD>"
			  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' value='${po.sopipaxesos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter10'></div></TD>"
			  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipupkos' value='${po.sopipupkos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter11'></div></TD>"
			  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipdownkos' value='${po.sopipdownkos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter12'></div></TD>"
			  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipeos' value='${po.sopipeos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter13'></div></TD>"
			  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipcornealdiameteros' value='${po.sopipcornealdiameteros}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter14'></div></TD>"
			  								+"<TD su=eae bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipk0os' value='${po.sopipk0os}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
			  								+"<TD su=eae bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipk1os' value='${po.sopipk1os}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
			  								+"<TD su=eae bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipk2os' value='${po.sopipk2os}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
			  								+"<TD su=eae bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipupcos' value='${po.sopipupcos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
			  								+"<TD su=eae bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipdowncos' value='${po.sopipdowncos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
			  								+"<TD su=rb bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
			  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipdiameteros' value='${po.sopipdiameteros}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
			  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><li class='horizontal'>适用镜片："
			  								+"<INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglassesos' value='${po.sopipcommendglassesos}' id='cc1.commendglasses22' size='8' readOnly></li>"
			  								+"</div></TD>"
			  								+"</TR></TBODY></TABLE></td></tr></table>";
		  }
		  		
		  if("${po.sopipglasstype }" == "7"){
		  
			  c1.innerHTML=c1.innerHTML+"<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='7'/>"
			  								+"<TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='yy'><TR>"
			  								+"<TD colspan='14' style='height:20px' class='PrivateBorderGreen' bgcolor='dfffdf'><p>视觉训练&nbsp;&nbsp;&nbsp;"
			  								+"</p></TD>	</TR><TR>"
			  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'>&nbsp;</TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>球镜</div></TD>"
			  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>柱镜</div></TD>"
			  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>轴向</div></TD>"
			  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>三棱镜</div></TD>"
			  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>基底</div></TD>"
			  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>远用瞳距(mm)</div></TD>"
			  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>近用瞳距(mm)</div></TD>"
			  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>远用VA</div></TD>"
			  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>近用VA</div></TD>"
			  								+"</TR><TBODY><TR><TD width='11%' bgcolor='#DFFFDF' class='PrivateBorderGreen'>OD</TD>"
			  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
			  								+"<input needChange='needChange' yyorder='1' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' value='${po.sopipballglassod}' class='text_input' size='4'></div></TD>"
			  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
			  								+"<input  needChange='needChange' yyorder='2' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' value='${po.sopippostglassod}' class='text_input cyl' size='4'></div></TD>"
			  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
			  								+"<input axes='axes' yyorder='3' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' value='${po.sopipaxesod}' class='text_input axes' size='4'></div></TD>"
			  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
			  								+"<input yyorder='4' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' value='${po.sopiparriseglassod1}' class='text_input' size='4'></div></TD>"
			  								+"<TD width='6%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
			  								+"<select yyorder='5' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1'>"
			  								+"<option value='' selected='selected'>请选择</option>"
											+"<s:iterator value='optionParamPolist'>"
										    +"   <c:if test='${fopparentid == \'24\'}'>"
										    +"       <option value='${fopparamid}'  ${po.sopipbasisod1  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
										    +"   </c:if>"
										    +"</s:iterator>"		  								
			  								+"</select></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
			  								+"<input yyorder='6' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' class='text_input' size='4' value='${po.sopipinterhighod}'></div></TD>"
			  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
			  								+"<input tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceod' value='${po.sopipinterdistanceod}' class='text_input' size='4'></div></TD>"
			  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
			  								+"<input yyorder='7' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' value='${po.sopipfarvaod}' class='text_input' size='4'></div></TD>"
			  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
			  								+"<input va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaod' value='${po.sopipclosevaod}' class='text_input' size='4'></div></TD>"
			  								+"</TR><TR>"
			  								+"<TD width='11%' bgcolor='#DFFFDF' class='PrivateBorderGreen'>OS</TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
			  								+"<input needChange='needChange' yyorder='8' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' value='${po.sopipballglassos}' class='text_input' size='4'></div></TD>"
			  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
			  								+"<input needChange='needChange' yyorder='9' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' value='${po.sopippostglassos}' class='text_input' size='4'></div></TD>"
			  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
			  								+"<input axes='axes' yyorder='10' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' value='${po.sopipaxesos}' class='text_input' size='4'></div></TD>"
			  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
			  								+"<input ljxj='ljxj' yyorder='11' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' value='${po.sopiparriseglassos1}' class='text_input' size='4'></div></TD>"
			  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
			  								+"<select yyorder='12' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1'>"
			  								+"<option value='' selected='selected'>请选择</option>"
											+"<s:iterator value='optionParamPolist'>"
										    +"   <c:if test='${fopparentid == \'24\'}'>"
										    +"       <option value='${fopparamid}'  ${po.sopipbasisos1  == fopparamid ? 'selected=selected' : '' }>${fopparamname}</option>"
										    +"   </c:if>"
										    +"</s:iterator>"
			  								+"</select></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
			  								+"<input yyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' class='text_input' size='4' value='${po.sopipinterhighos}'></div></TD>"
			  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
			  								+"<input tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceos' value='${po.sopipinterdistanceos}' class='text_input' size='4'></div></TD>"
			  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
			  								+"<input yyorder='14' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos' class='text_input' size='4' value='${po.sopipfarvaos}'></div></TD>"
			  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
			  								+"<input va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaos' class='text_input' size='4' value='${po.sopipclosevaos}'></div></TD></TR><TR>"
			  								+"<TD colspan='6' bgcolor='#DFFFDF' class='PrivateBorderGreen'><li class='horizontal'><div align='center'>家庭训练："
			  								+"<INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipfamilytrain' id='cc1.commendglasses' size='12' readOnly value='${po.sopipfamilytrain}'></div></li><li class='horizontal'>"
			  								+"<div align='center'>训练室训练："
			  								+"<INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopiptrainroom' id='cc1.commendglasses' size='12' readOnly value='${po.sopiptrainroom}'></div></li>"
			  								+"</TD>"
			  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><div align='right'>备注:</div></TD>"
			  								+"<TD colspan='3' bgcolor='#DFFFDF' class='PrivateBorderGreen'>"
			  								+"<textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'>${po.sopipdignosisre}</textarea></TD></TR></TBODY></TABLE>"
		  }		
	  		
	  if(myValue == "4"){
	  	xzindex = xzindex+2;
	  }else{
	  	xzindex++;
	  }
	  </c:forEach>
      allTrafficCount++;   //总计多少行   
      inspectionForm.trafficCount.value = allTrafficCount;  
      $('input[type=checkbox]').attr("disabled","disabled"); 
      $('select').attr("disabled","disabled"); 
  }
  
  	function cornealContactlLens(){
		var dontshow = $('#dontshow').val();
		$("img").removeAttr("onclick");
		inspectionForm.action="initCornealContactlLensSelectAier.action?dontshow="+dontshow;
		inspectionForm.submit();
	}
	
	function contactGlass(){
		var dontshow = $('#dontshow').val();
		inspectionForm.action="initContactGlassSelectAier.action?dontshow="+dontshow;
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}

	function fixingInterface(){
		$("img").removeAttr("onclick");
		inspectionForm.action="selectFixingInterfaceAier.action";
		inspectionForm.submit();
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="inspectionForm" method="post" action="">
<input type="hidden" name="moduleID" value="${moduleID }"/>
<input type="hidden" name="customerID" id="customerID" value="${requestScope.customerID}" /> 
<input type="hidden" name="optometryBasicID" id="optometryBasicID" value="${requestScope.optometryBasicID}" /> 
<input type="hidden" name="optometryID" id="optometryID" value="${requestScope.optometryID}" /> 
<input type="hidden" name="dontshow" id="dontshow" value="${dontshow}" /> 
<input type="hidden" id="chuyanfuyan" name="chuyanfuyan" value="${chuyanfuyan }"/>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD>
					<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
						<TBODY>
						<TR><!--ťStart-->
						  <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" background=${ctx}/img/pic/tab_top_bg.gif colspan="2">
							<TABLE cellSpacing=0 cellPadding=0 border=0>
							  <TBODY>
							  <TR><!--ťStart-->
				 					<TD>
									  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
										<TBODY>
										<TR>
					                      <TD width=3><IMG id=tabImgLeft__1 height=22 
					                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					                      <TD class=tab id=tabLabel__1                       
					                      background=${ctx}/img/pic/tab_unactive_bg.gif 
					                      onclick="glassHistory()"
					                      UNSELECTABLE="on">戴镜史</TD>
					                      <TD width=3><IMG id=tabImgRight__1 height=22 
					                        src="${ctx}/img/pic/tab_unactive_right.gif" 
					                    width=3></TD>
					                </TR>
									</TBODY>
								  </TABLE>
								  </TD>
							                 <TD>
								 			  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
									          <TBODY>
										      <TR>
											    <TD width=3><IMG id=tabImgLeft__1 height=22 
												src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
												<TD class=tab id=tabLabel__1 
												onclick="refractive();" 
												background=${ctx }/img/pic/tab_unactive_bg.gif 
												UNSELECTABLE="on">屈光检查</TD>
												<TD width=3><IMG id=tabImgRight__1 height=22 
												src="${ctx }/img/pic/tab_unactive_right.gif" 
												width=3></TD>
											  </TR>
											  </TBODY>
											  </TABLE>
										    </TD>
											
											<TD>
											  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
												<TBODY>
												<TR>
												  <TD width=3><IMG id=tabImgLeft__1 height=22 
													src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__1 
												  onclick="doubleEyeFun()" 
												  background=${ctx}/img/pic/tab_unactive_bg.gif 
												  UNSELECTABLE="on">双眼视功能检查</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx}/img/pic/tab_unactive_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
										  </TD>
										  <TD>
											  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
												<TBODY>
												<TR>
												  <TD width=3><IMG id=tabImgLeft__1 height=22 
													src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__1 
												  onclick="specialCheck()" 
												  background=${ctx}/img/pic/tab_unactive_bg.gif 
												  UNSELECTABLE="on">相关检查</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx}/img/pic/tab_unactive_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
										  </TD>
										  
										  <TD>
											  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
												<TBODY>
												<TR>
												  <TD width=3><IMG id=tabImgLeft__1 height=22 
													src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__1 
												  onclick="contactGlass();" 
												  background=${ctx}/img/pic/tab_unactive_bg.gif 
												  UNSELECTABLE="on">接触镜评估</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx}/img/pic/tab_unactive_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
										  </TD>
										  
										  <TD>
											  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
												<TBODY>
												<TR>
												  <TD width=3><IMG id=tabImgLeft__0 height=22 
													src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__0 
												  onclick="JavaScript:void(0);"
												  background=${ctx}/img/pic/tab_active_bg.gif 
												  UNSELECTABLE="on">检查结论</TD>
												  <TD width=3><IMG id=tabImgRight__0 height=22 
													src="${ctx}/img/pic/tab_active_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
											</TD>

								    <c:if test="${permissionPo.keyh == '1'}">	  
										  <TD>
									 		<TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
											<TBODY>
												<TR>
												  <TD width=3><IMG id=tabImgLeft__1 height=22 
														src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__1 
													  onclick="fixingInterface()" 
													  background=${ctx }/img/pic/tab_unactive_bg.gif
													  UNSELECTABLE="on">验光设备接口</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx }/img/pic/tab_unactive_right.gif" 
													width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
										  </TD>
									</c:if>
																			  
										  <c:if test="${requestScope.chuyanfuyan == '1'}">
										  <TD>
											  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
												<TBODY>
												<TR>
												  <TD width=3><IMG id=tabImgLeft__1 height=22 
													src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__1 
												  onclick="cornealContactlLens()" 
												  background=${ctx}/img/pic/tab_unactive_bg.gif 
												  UNSELECTABLE="on">角膜接触镜复查</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx}/img/pic/tab_unactive_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
										  </TD>
										  </c:if>
									</TR>
								</TBODY>
							</TABLE>
							</TD>
						</TR>
        <TR>
          <TD bgColor=#ffffff colspan="2">
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top>
                		<input type="hidden" id="customerReadonly" name="customerReadonly" value="readOnly" />
						<s:action name="initCustomerOptometryTitleN" executeResult="true" />
						<br/>	
						<fieldset>
							<legend>眼睛健康评估</legend>
                            							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><table width="99%" 
                  border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                  <tbody>
									<tr>
								  	<td height="30" bgcolor="#CADEE8" valign="bottom"><li class="horizontal">
								  	 屈光不正：【近视眼】
									    <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
	                                      	<c:if test="${(fn:trim(inspectionPos[0].sopipneareye) == fn:trim(optionParamPoTmp.fopparamid)) && (optionParamPoTmp.fopparentid=='44')}">
	                                      		${optionParamPoTmp.fopparamname} 
	                                      	</c:if>	                                      	
                                     	</c:forEach> 
									  &nbsp;
									【远视眼】
									 	<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
	                                      	<c:if test="${(fn:trim(inspectionPos[0].sopipfareye) == fn:trim(optionParamPoTmp.fopparamid)) && (optionParamPoTmp.fopparentid=='45')}">
	                                      		${optionParamPoTmp.fopparamname} 
	                                      	</c:if>	                                      	
                                     	</c:forEach> 
									  &nbsp;
									【散光】
									 	<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
	                                      	<c:if test="${(fn:trim(inspectionPos[0].sopipastigmia) == fn:trim(optionParamPoTmp.fopparamid)) && (optionParamPoTmp.fopparentid=='46')}">
	                                      		${optionParamPoTmp.fopparamname} 
	                                      	</c:if>	                                      	
                                     	</c:forEach> 									 
									  &nbsp;</li>
									</td>
								  </tr>
                                  							  <tr>
								  	<td height="30" bgcolor="#CADEE8" valign="bottom"><li class="horizontal">
									 双眼视功能评估：
								  	<c:set value="${ fn:split(inspectionPos[0].sopipestimate, ',') }" var="str" />                                      	
                                      <c:forEach items="${ str }" var="s">
       									<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
	                                      	<c:if test="${(fn:trim(s) == fn:trim(optionParamPoTmp.fopparamid)) && (optionParamPoTmp.fopparentid=='47')}">
	                                      		${optionParamPoTmp.fopparamname} 
	                                      	</c:if>	                                      	
                                     	</c:forEach> 
									  </c:forEach>
									 &nbsp;</li>
									</td>
								  </tr>
                                  </tbody>
                                  </table>
								</td>
								</tr>
								</table>
								</fieldset>
								<br>
                        						<fieldset>
							<legend>建议矫正方案</legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><table width="99%" 
                  border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                  <tbody>
								  <tr>
								  	<td height="30" bgcolor="#CADEE8" valign="bottom"><li class="horizontal">
									框架眼镜：
								  	<c:set value="${ fn:split(inspectionPos[0].sopipglasstypes, ',') }" var="str" />                                      	
                                      <c:forEach items="${ str }" var="s">
       									<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
	                                      	<c:if test="${(fn:trim(s) == fn:trim(optionParamPoTmp.fopparamid)) && (optionParamPoTmp.fopparentid=='48')}">
	                                      		${optionParamPoTmp.fopparamname} 
	                                      	</c:if>	                                      	
                                     	</c:forEach> 
									  </c:forEach>  									
									</td>
								  </tr>
								  <tr>
								  	<td height="30" bgcolor="#CADEE8" valign="bottom"><li class="horizontal">
									 	角膜接触镜：
								  	<c:set value="${ fn:split(inspectionPos[0].sopiptouchglass, ',') }" var="str" />                                      	
                                      <c:forEach items="${ str }" var="s">
       									<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
	                                      	<c:if test="${(fn:trim(s) == fn:trim(optionParamPoTmp.fopparamid)) && (optionParamPoTmp.fopparentid=='49')}">
	                                      		${optionParamPoTmp.fopparamname} 
	                                      	</c:if>	                                      	
                                     	</c:forEach> 
									  </c:forEach>
									</td>
								  </tr>
								  								  <tr>
								  	<td height="30" bgcolor="#CADEE8" valign="bottom"><li class="horizontal">
 										视觉训练：
								  	<c:set value="${ fn:split(inspectionPos[0].sopiptraintypes, ',') }" var="str" />                                      	
                                      <c:forEach items="${ str }" var="s">
       									<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
	                                      	<c:if test="${(fn:trim(s) == fn:trim(optionParamPoTmp.fopparamid)) && (optionParamPoTmp.fopparentid=='50')}">
	                                      		${optionParamPoTmp.fopparamname} 
	                                      	</c:if>	                                      	
                                     	</c:forEach> 
									  </c:forEach>
									</td>
								  </tr>
									</tbody>

                                </table>
								</td>
								</tr>
								</table>
								</fieldset>	
								<fieldset>
									<legend>医嘱</legend>
										<table width="99%" border=0 align=center cellpadding=1	cellspacing=1 class="privateTable privateBorder">
											<tbody>
												<tr bgcolor="#CADEE8" height="60px">
													<TD class="PrivateBorderBlue" width="10%">
													<div align="center">主诉</div>
													</TD>
													<TD>${fn:trim(inspectionPos[0].sopipdoctorsay) }</TD>
												</tr>
											</tbody>
										</table>
									</fieldset>									
						<br>
						<fieldset>
							<legend>双眼视功能检查</legend>
				<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
								<tr>
								<td>
								<table id=trafficeList  width="100%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateTable">
									<tr><td></td></tr>   
                 				</table>
                 				<input type="hidden" name=trafficCount>
                 				</td>
                 				</tr>
							</table>
						    <br>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><TABLE width="99%" 
                  border=0 align=center cellPadding=1 cellSpacing=1 class="privateTable PrivateBorderBlue" id="fz">
                                  <TBODY>

                                    <TR align="center">
                                    <TD height="30" bgcolor="#E8F8FF"><div align="right" class="PrivateBorder">
                                      	戴镜方式：
                                      	<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
	                                      	<c:if test="${(fn:trim(inspectionPos[0].sopiptaketype) == fn:trim(optionParamPoTmp.fopparamid)) && (optionParamPoTmp.fopparentid=='56')}">
	                                      		${optionParamPoTmp.fopparamname} 
	                                      	</c:if>	                                      	
                                     	</c:forEach> 
                                    </div>
                                    </TD>
                                      <TD height="30" bgcolor="#E8F8FF"><div align="left" class="PrivateBorder">
                                      	复诊时间：${inspectionPos[0].sopipseccheckdate }
                                          </div>
                                      </TD>
                                    </TR>
                                  </TBODY>
                                </TABLE></td>
							  </tr>
							</table>
						</fieldset>	
						<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                       
                      </TBODY>
                    </TABLE>		
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff  colspan="2"><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>