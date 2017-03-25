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
	function save(){
		$("img").removeAttr("onclick");
		inspectionForm.action="inspectionUpdate.action";
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
	
	$(document).ready(function(){
		searchButton();
		$('#glassType').attr('value','${glassType}');
		displayTable2('${glassType}');
		if('${readOnly}'=='readOnly'){
			$('#smecimemberid').attr("readonly","readonly");
		}
		
		displayTable($(this).val());
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
		inspectionForm.action="selectDoubleEyeFun.action?dontshow="+dontshow;
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
	
	function specialCheck(){
		var dontshow = $('#dontshow').val();
		inspectionForm.action="selectSpecialCheck.action?dontshow="+dontshow;
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
	
	function refractive(){
		var dontshow = $('#dontshow').val();
		inspectionForm.action="initRefractiveSelect.action?dontshow="+dontshow;
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
        							+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>远用VA</div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>近用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#DFFFDF' class='PrivateBorderGreen'>OD</TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyneedChange='needChange' yyorder='1'  sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' class='text_input' size='4' value="+"${po.sopipballglassod}"+"></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonly needChange='needChange' yyorder='2' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' value='"+"${po.sopippostglassod}"+"' class='text_input cyl' size='4'></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonly  axes='axes' yyorder='3' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' value='"+"${po.sopipaxesod}"+"' class='text_input axes' size='4'></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='4' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' value='"+"${po.sopiparriseglassod1}"+"' class='text_input' size='4' value=''></div></TD><TD width='6%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><select disabled=disabled  yyorder='5' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1'><option value='' selected='selected'>----请选择----</option><option value='内' ${po.sopipbasisod1  != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${po.sopipbasisod1 != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${po.sopipbasisod1 != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${po.sopipbasisod1 != '下' ? '' : 'selected=selected' }>下</option></select></div></TD>"
        							+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='6' tongju='tongju' value='${po.sopipinterhighod}' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' class='text_input' size='4' value=''></div></TD>"
        							+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='6' tongju='tongju' value='${po.sopippupilheightod}' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' class='text_input' size='4' value=''></div></TD>"
        							+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='7' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' class='text_input' size='4' value='${po.sopipfarvaod  }'></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyva='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaod' readonly='readonly' class='text_input' size='4'></div></TD></TR><TR><TD width='11%' bgcolor='#DFFFDF' class='PrivateBorderGreen'>OS</TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyneedChange='needChange' yyorder='8' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' class='text_input' size='4' value='${po.sopipballglassos }'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyneedChange='needChange' yyorder='9' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' class='text_input' size='4' value='${po.sopippostglassos }'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyaxes='axes' yyorder='10' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' value='${po.sopipaxesos }' class='text_input' size='4'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyljxj='ljxj' yyorder='11' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' value='${po.sopiparriseglassos1 }' class='text_input' size='4'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><select disabled=disabled  yyorder='12' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1'><option value='' selected='selected'>----请选择----</option><option value='内' ${po.sopipbasisos1 != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${po.sopipbasisos1 != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${po.sopipbasisos1 != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${po.sopipbasisos1 != '下' ? '' : 'selected=selected' }>下</option></select></div></TD>"
        							+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' class='text_input' size='4' value='${po.sopipinterhighos }'></div></TD>"
        							+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' class='text_input' size='4' value='${po.sopippupilheightos }'></div></TD>"
        							+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='14' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos' class='text_input' size='4' value='${po.sopipfarvaos  }'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyva='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaos' readonly='readonly' class='text_input' size='4'></div></TD></TR><TR><TD colspan='6' bgcolor='#DFFFDF' class='PrivateBorderGreen'><li class='horizontal'><div align='center'>适用镜片：<input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglasses' value='${po.sopipcommendglasses}' syjp='"+allTrafficCount+"' id='cc1.commendglasses' size='12' readOnly></div></li><li class='horizontal'><div align='center'></div></li><li class='horizontal'><div align='center'></div></li></TD><TD colspan='4' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>中距离：<input readonly=readonly type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance' ${po.sopipmiddledistance != '1' ? '':'checked=checked'}>建议镜框：<select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'><OPTION value='' selected>----请选择----</OPTION><OPTION value='打孔' ${po.sopipsuggestframe != '打孔' ? '':'selected=selected'}>打孔</OPTION><OPTION value='拉丝' ${po.sopipsuggestframe != '拉丝' ? '':'selected=selected'}>拉丝</OPTION><OPTION value='板材' ${po.sopipsuggestframe != '板材' ? '':'selected=selected'}>板材</OPTION><OPTION value='框高' ${po.sopipsuggestframe != '框高' ? '':'selected=selected'}>框高</OPTION></SELECT><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' value='${po.sopipframeheight}' size='12'></div></TD></TR><TR><TD colspan='2' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='right'>建议镜片材质:<TD colspan='1' bgcolor='#DFFFDF' class='PrivateBorderGreen'><select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'><OPTION value='' selected>----请选择----</OPTION><OPTION value='老花渐进' ${po.sopipglassmaterial != '老花渐进' ? '' :'selected=selected'}>老花渐进</OPTION><OPTION value='青少年渐进' ${po.sopipglassmaterial != '青少年渐进' ? '' :'selected=selected'}>青少年渐进</OPTION><OPTION value='非球面树脂' ${po.sopipglassmaterial != '非球面树脂' ? '' :'selected=selected'}>非球面树脂</OPTION><OPTION value='抗辐射镜片' ${po.sopipglassmaterial != '抗辐射镜片' ? '' :'selected=selected'}>抗辐射镜片</OPTION><OPTION value='染色镜片' ${po.sopipglassmaterial != '染色镜片' ? '' :'selected=selected'}>染色镜片</OPTION><OPTION value='变色镜片' ${po.sopipglassmaterial != '变色镜片' ? '' :'selected=selected'}>变色镜片</OPTION><OPTION value='普通树脂' ${po.sopipglassmaterial != '普通树脂' ? '' :'selected=selected'}>普通树脂</OPTION><OPTION value='高折玻璃' ${po.sopipglassmaterial != '高折玻璃' ? '' :'selected=selected'}>高折玻璃</OPTION><OPTION value='玻璃片' ${po.sopipglassmaterial != '玻璃片' ? '' :'selected=selected'}>玻璃片</OPTION><OPTION value='树脂抗疲劳镜片' ${po.sopipglassmaterial != '树脂抗疲劳镜片' ? '' :'selected=selected'}>树脂抗疲劳镜片</OPTION><OPTION></OPTION></SELECT></TD><TD bgcolor='#DFFFDF' class='PrivateBorderBlue'><div align='right'>处理方式： </div></TD><TD colspan='2' bgcolor='#DFFFDF' class='PrivateBorderGreen'><select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'><option value='' selected>----请选择----</option><option value='足矫' ${po.sopipdisposemanner != '足矫' ? '' :'selected=selected'}>足矫</option><option value='欠矫' ${po.sopipdisposemanner != '欠矫' ? '' :'selected=selected'}>欠矫</option><option value='过矫' ${po.sopipdisposemanner != '过矫' ? '' :'selected=selected'}>过矫</option><option value='附加棱镜' ${po.sopipdisposemanner != '附加棱镜' ? '' :'selected=selected'}>附加棱镜</option><option value='调整' ${po.sopipdisposemanner != '调整' ? '' :'selected=selected'}>调整</option><option value='平衡' ${po.sopipdisposemanner != '平衡' ? '' :'selected=selected'}>平衡</option><option value='医嘱' ${po.sopipdisposemanner != '医嘱' ? '' :'selected=selected'}>医嘱</option><option value='全矫' ${po.sopipdisposemanner != '全矫' ? '' :'selected=selected'}>全矫</option><option value='患者要求减度' ${po.sopipdisposemanner != '患者要求减度' ? '' :'selected=selected'}>患者要求减度</option></select></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='right'>备注:</div></TD><TD colspan='3' bgcolor='#DFFFDF' class='PrivateBorderGreen'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'>${po.sopipdignosisre}</textarea></TD></TR></TBODY></TABLE>"
	     					
	  }if("${po.sopipglasstype }" == "2"){
		  
		c1.innerHTML=c1.innerHTML+"<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='2'/><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='jy'><TR><TD colspan='15' style='height:20px' class='PrivateBorderBlue' bgcolor='#E1EBFD'><p>框架--近用&nbsp;&nbsp;&nbsp;<br></p></TD></TR><TR><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'>&nbsp;</TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>球镜</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>柱镜</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>轴向</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>Add</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>三棱镜</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>基底</div></TD>"
									+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>远用瞳距(mm)</div></TD>"
									+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>近用瞳距(mm)</div></TD>"
									+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>瞳高(mm)</div></TD>"
									+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>远用VA</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>近用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#E1EBFD' class='PrivateBorderBlue'>OD</TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='1' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' value='${po.sopipballglassod }' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='2' needChange='needChange' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' value='${po.sopippostglassod }' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='3' axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' value='${po.sopipaxesod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='4' needChange='needChange' readonly='readonly' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipaddod' value='${po.sopipaddod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='5' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' class='text_input' size='4' value='${po.sopiparriseglassod1 }'></div></TD><TD width='6%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><select disabled=disabled  jjorder='6' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1'><option value='' selected='selected'>----请选择----</option><option value='内' ${po.sopipbasisod1 != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${po.sopipbasisod1  != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${po.sopipbasisod1  != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${po.sopipbasisod1  != '下' ? '' : 'selected=selected' }>下</option></select></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlytongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' readonly='readonly' class='text_input' size='4'></div></TD>"
									+"<TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='7' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceod' class='text_input' size='4' value='${po.sopipinterdistanceod }'></div></TD>"
									+"<TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='7' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' class='text_input' size='4' value='${po.sopippupilheightod }'></div></TD>"
									+"<TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyva='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' readonly='readonly' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='8' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaod' class='text_input' size='4' value='${po.sopipclosevaod}'></div></TD></TR><TR><TD width='11%' bgcolor='#E1EBFD' class='PrivateBorderBlue'>OS</TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='9' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' value='${po.sopipballglassos }' class='text_input' size='4'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='10' needChange='needChange' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' value='${po.sopippostglassos }' class='text_input' size='4'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='11' axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' value='${po.sopipaxesos }' class='text_input' size='4'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='12' readonly='readonly' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipaddos' value='${po.sopipaddos}' class='text_input' size='4'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='13' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' class='text_input' size='4' value='${po.sopiparriseglassos1 }'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><select disabled=disabled  jjorder='14' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1'><option value='' selected='selected'>----请选择----</option><option value='内' ${po.sopipbasisos1 != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${po.sopipbasisos1 != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${po.sopipbasisos1 != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${po.sopipbasisos1 != '下' ? '' : 'selected=selected' }>下</option></select></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlytongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' readonly='readonly' class='text_input' size='4'></div></TD>"
									+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='15' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceos' class='text_input' size='4' value='${po.sopipinterdistanceos }'></div></TD>"
									+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='15' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' class='text_input' size='4' value='${po.sopippupilheightos }'></div></TD>"
									+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyva='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos' readonly='readonly' class='text_input' size='4'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input readonly=readonlyjjorder='16' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaos' class='text_input' size='4' value='${po.sopipclosevaos }'></div></TD></TR><TR><TD colspan='7' bgcolor='#E1EBFD' class='PrivateBorderBlue'><li class='horizontal'><div align='center'>适用镜片:<input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglasses' value='${po.sopipcommendglasses}'  id='cc1.commendglasses2' size='12'></div></li><li class='horizontal'><div align='center'></div></li><li class='horizontal'><div align='center'></div></li></TD><TD colspan='5' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>中距离：<input readonly=readonly type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance' ${po.sopipmiddledistance != '1' ? '':'checked=checked'}>建议镜框：<select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'><OPTION value=''>----请选择----</OPTION><OPTION value='打孔' ${po.sopipsuggestframe != '打孔' ? '':'selected=selected'}>打孔</OPTION><OPTION value='拉丝' ${po.sopipsuggestframe != '拉丝' ? '':'selected=selected'}>拉丝</OPTION><OPTION value='板材' ${po.sopipsuggestframe != '板材' ? '':'selected=selected'}>板材</OPTION><OPTION value='框高' ${po.sopipsuggestframe != '框高' ? '':'selected=selected'}>框高</OPTION></SELECT><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' value='${po.sopipframeheight}' size='12'></div></TD></TR><TR><TD colspan='2' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='right'>建议镜片材质:</div></TD><TD colspan='2' bgcolor='#E1EBFD' class='PrivateBorderBlue'><select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'><OPTION value='' selected>----请选择----</OPTION><OPTION value='老花渐进' ${po.sopipglassmaterial != '老花渐进' ? '' :'selected=selected'}>老花渐进</OPTION><OPTION value='青少年渐进' ${po.sopipglassmaterial != '青少年渐进' ? '' :'selected=selected'}>青少年渐进</OPTION><OPTION value='非球面树脂' ${po.sopipglassmaterial != '非球面树脂' ? '' :'selected=selected'}>非球面树脂</OPTION><OPTION value='抗辐射镜片' ${po.sopipglassmaterial != '抗辐射镜片' ? '' :'selected=selected'}>抗辐射镜片</OPTION><OPTION value='染色镜片' ${po.sopipglassmaterial != '染色镜片' ? '' :'selected=selected'}>染色镜片</OPTION><OPTION value='变色镜片' ${po.sopipglassmaterial != '变色镜片' ? '' :'selected=selected'}>变色镜片</OPTION><OPTION value='普通树脂'>普通树脂</OPTION><OPTION value='高折玻璃' ${po.sopipglassmaterial != '高折玻璃' ? '' :'selected=selected'}>高折玻璃</OPTION><OPTION value='玻璃片' ${po.sopipglassmaterial != '玻璃片' ? '' :'selected=selected'}>玻璃片</OPTION><OPTION value='树脂偏光镜片（茶/灰）' ${po.sopipglassmaterial != '树脂偏光镜片（茶/灰）' ? '' :'selected=selected'}>树脂偏光镜片（茶/灰）</OPTION><OPTION value='树脂抗疲劳镜片' ${po.sopipglassmaterial != '树脂抗疲劳镜片' ? '' :'selected=selected'}>树脂抗疲劳镜片</OPTION><OPTION></OPTION></SELECT></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='right'>处理方式： </div></TD><TD colspan='2' bgcolor='#E1EBFD' class='PrivateBorderBlue'><select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'><option value='' selected>----请选择----</option><option value='足矫' ${po.sopipdisposemanner != '足矫' ? '' :'selected=selected'}>足矫</option><option value='欠矫' ${po.sopipdisposemanner != '欠矫' ? '' :'selected=selected'}>欠矫</option><option value='过矫' ${po.sopipdisposemanner != '过矫' ? '' :'selected=selected'}>过矫</option><option value='附加棱镜' ${po.sopipdisposemanner != '附加棱镜' ? '' :'selected=selected'}>附加棱镜</option><option value='调整' ${po.sopipdisposemanner != '调整' ? '' :'selected=selected'}>调整</option><option value='平衡' ${po.sopipdisposemanner != '平衡' ? '' :'selected=selected'}>平衡</option><option value='医嘱' ${po.sopipdisposemanner != '医嘱' ? '' :'selected=selected'}>医嘱</option><option value='全矫' ${po.sopipdisposemanner != '全矫' ? '' :'selected=selected'}>全矫</option><option value='患者要求减度' ${po.sopipdisposemanner != '患者要求减度' ? '' :'selected=selected'}>患者要求减度</option></select></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='right'>备注： </div></TD><TD colspan='4' bgcolor='#E1EBFD' class='PrivateBorderBlue'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'>${po.sopipdignosisre}</textarea></TD></TR></TBODY></TABLE>";
		
	  }if("${po.sopipglasstype }" == "3"){
		  
		c1.innerHTML=c1.innerHTML+"<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='3'/><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='jj'><TR><TD colspan='12' style='height:20px' class='PrivateBorderYellow' bgcolor='#FBF3BD'>框架--双光/渐进&nbsp;&nbsp;&nbsp;</TD></TR><TR><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'>&nbsp;</TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>球镜</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>柱镜</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>轴向</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>Add</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>三棱镜</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>基底</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>远用瞳距(mm)</div></TD>"
									+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>近用瞳距(mm)</div></TD>"
									+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>瞳高(mm)</div></TD>"
									+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>远用VA</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>近用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#FBF3BD' class='PrivateBorderYellow'>OD</TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='1' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' value='${po.sopipballglassod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='2' needChange='needChange' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' value='${po.sopippostglassod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='3' axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' value='${po.sopipaxesod}' class='text_input' size='4'></div></TD> <TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='4'  needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipaddod' value='${po.sopipaddod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='5' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' class='text_input' size='4' value='${po.sopiparriseglassod1 }'></div></TD><TD width='6%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><select disabled=disabled  jjsgorder='6' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1'><option value='' selected='selected'>----请选择----</option><option value='内' ${po.sopipbasisod1 != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${po.sopipbasisod1 != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${rpo.sopipbasisod1 != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${po.sopipbasisod1 != '下' ? '' : 'selected=selected' }>下</option></select></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='7' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' class='text_input' size='4' value='${po.sopipinterhighod}'></div></TD>"
									+"<TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='8' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceod' class='text_input' size='4' value='${po.sopipinterdistanceod}'></div></TD>"
									+"<TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='8' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' class='text_input' size='4' value='${po.sopippupilheightod}'></div></TD>"
									+"<TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='9' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' class='text_input' size='4' value='${po.sopipfarvaod}'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='10' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaod' class='text_input' size='4' value='${po.sopipclosevaod}'></div></TD></TR><TR><TD width='11%' bgcolor='#FBF3BD' class='PrivateBorderYellow'>OS</TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='11' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' value='${po.sopipballglassos}' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='12' needChange='needChange' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' value='${po.sopippostglassos}' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='13' axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' value='${po.sopipaxesos}' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='14'  needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipaddos' value='${po.sopipaddos}' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='15' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' value='${po.sopiparriseglassos1}' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><select disabled=disabled  jjsgorder='16' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1'><option value='' selected='selected'>----请选择----</option><option value='内' ${po.sopipbasisos1 != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${po.sopipbasisos1 != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${po.sopipbasisos1 != '上' ? '' : 'selected=selected' }>上</option><option value='下'  ${po.sopipbasisos1 != '下' ? '' : 'selected=selected' }>下</option></select></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='17' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' class='text_input' size='4' value='${po.sopipinterhighos}'></div></TD>"
									+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='18' tongju='tongju'  name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceos' class='text_input' size='4' value='${po.sopipinterdistanceos}'></div></TD>"
									+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='18' tongju='tongju'  name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' class='text_input' size='4' value='${po.sopippupilheightos}'></div></TD>"
									+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='19' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos' class='text_input' size='4' value='${po.sopipfarvaos}'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input readonly=readonlyjjsgorder='20' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaos' class='text_input' size='4' value='${po.sopipclosevaos}'></div></TD></TR><TR><TD colspan='7' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><li class='horizontal'>适用镜片：<input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglasses' value='${po.sopipcommendglasses}' id='cc1.commendglasses22' size='12' readOnly></li><li class='horizontal'></li><li class='horizontal'></li></div></TD><TD colspan='5' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>中距离：<input readonly=readonly type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance' ${po.sopipmiddledistance != '1' ? '':'checked=checked'}>建议镜框：<select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'><OPTION value='' selected>----请选择----</OPTION><OPTION value='打孔' ${po.sopipsuggestframe != '打孔' ? '':'selected=selected'}>打孔</OPTION><OPTION value='拉丝' ${po.sopipsuggestframe != '拉丝' ? '':'selected=selected'}>拉丝</OPTION><OPTION value='板材' ${po.sopipsuggestframe != '板材' ? '':'selected=selected'}>板材</OPTION><OPTION value='框高' ${po.sopipsuggestframe != '框高' ? '':'selected=selected'}>框高</OPTION></SELECT><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' size='12' value='${po.sopipframeheight}'></div></TD></TR><TR><TD colspan='2' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='right'>建议镜片材质： </div></TD><TD colspan='2' bgcolor='#FBF3BD' class='PrivateBorderYellow'><select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'><OPTION value='' selected>----请选择----</OPTION><OPTION value='老花渐进' ${po.sopipglassmaterial != '老花渐进' ? '' :'selected=selected'}>老花渐进</OPTION><OPTION value='青少年渐进' ${po.sopipglassmaterial != '青少年渐进' ? '' :'selected=selected'}>青少年渐进</OPTION><OPTION value='非球面树脂' ${po.sopipglassmaterial != '非球面树脂' ? '' :'selected=selected'}>非球面树脂</OPTION><OPTION value='抗辐射镜片' ${po.sopipglassmaterial != '抗辐射镜片' ? '' :'selected=selected'}>抗辐射镜片</OPTION><OPTION value='染色镜片' ${po.sopipglassmaterial != '染色镜片' ? '' :'selected=selected'}>染色镜片</OPTION><OPTION value='变色镜片' ${po.sopipglassmaterial != '变色镜片' ? '' :'selected=selected'}>变色镜片</OPTION><OPTION value='普通树脂' ${po.sopipglassmaterial != '普通树脂' ? '' :'selected=selected'}>普通树脂</OPTION><OPTION value='高折玻璃' ${po.sopipglassmaterial != '高折玻璃' ? '' :'selected=selected'}>高折玻璃</OPTION><OPTION value='玻璃片' ${po.sopipglassmaterial != '玻璃片' ? '' :'selected=selected'}>玻璃片</OPTION><OPTION value='树脂偏光镜片（茶/灰）' ${po.sopipglassmaterial != '树脂偏光镜片（茶/灰）' ? '' :'selected=selected'}>树脂偏光镜片（茶/灰）</OPTION><OPTION value='树脂抗疲劳镜片' ${po.sopipglassmaterial != '树脂抗疲劳镜片' ? '' :'selected=selected'}>树脂抗疲劳镜片</OPTION><OPTION></OPTION></SELECT></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='right'>处理方式： </div></TD><TD colspan='2' bgcolor='#FBF3BD' class='PrivateBorderYellow'><select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'><option value='' selected>----请选择----</option><option value='足矫' ${po.sopipdisposemanner != '足矫' ? '' :'selected=selected'}>足矫</option><option value='欠矫' ${po.sopipdisposemanner != '欠矫' ? '' :'selected=selected'}>欠矫</option><option value='过矫' ${po.sopipdisposemanner != '过矫' ? '' :'selected=selected'}>过矫</option><option value='附加棱镜' ${po.sopipdisposemanner != '附加棱镜' ? '' :'selected=selected'}>附加棱镜</option><option value='调整' ${po.sopipdisposemanner != '调整' ? '' :'selected=selected'}>调整</option><option value='平衡' ${po.sopipdisposemanner != '平衡' ? '' :'selected=selected'}>平衡</option><option value='医嘱' ${po.sopipdisposemanner != '医嘱' ? '' :'selected=selected'}>医嘱</option><option value='全矫' ${po.sopipdisposemanner != '全矫' ? '' :'selected=selected'}>全矫</option><option value='患者要求减度' ${po.sopipdisposemanner != '患者要求减度' ? '' :'selected=selected'}>患者要求减度</option></select></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='right'>备注： </div></TD><TD colspan='4' bgcolor='#FBF3BD' class='PrivateBorderYellow'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'>${po.sopipdignosisre}</textarea></TD></TR></TBODY></TABLE>";
		
	  }if("${po.sopipglasstype }" == "4"){
		  
		c1.innerHTML=c1.innerHTML+"<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='4'/><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='yx'><TR><TD colspan='11' style='height:20px' class='PrivateBorderPink' bgcolor='#F8E0F0'>隐形&nbsp;&nbsp;&nbsp;</TD></TR><TR><TD width='3%' bgcolor='#F8E0F0' class='PrivateBorderPink'>&nbsp;</TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>球镜</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>柱镜</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>轴向</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>曲率1</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>曲率2</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>直径</div></TD><TD width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形VA</div></TD><TD width='44%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形镜片</div></TD><TD width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>片/盒数</div></TD><TD width='11%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形处理方式</div></TD></TR><TR><TD bgcolor='#F8E0F0' class='PrivateBorderPink'>OD</TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyneedChange='needChange' sph='sph' id='sopipballglassod' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' value='${po.sopipballglassod}' class='text_input' size='2'  enter='enter1'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyneedChange='needChange' cyl='cyl' id='sopippostglassod' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' value='${po.sopippostglassod}' class='text_input' size='2'  enter='enter2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyaxes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' value='${po.sopipaxesod}' class='text_input' size='2'  enter='enter3'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonly name='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureod1' value='${po.sopipeyecurvatureod1}' class='text_input' size='2'   enter='enter4'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureod2' value='${po.sopipeyecurvatureod2}' class='text_input' size='2'  enter='enter5'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipdiameterod' value='${po.sopipdiameterod}' class='text_input' size='2'  enter='enter6'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipconlenvaod' value='${po.sopipconlenvaod}' class='text_input' size='2'  enter='enter7'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><li class='horizontal'>适用镜片：<input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglasses' value='${fn:split(po.sopipcommendglasses,',')[0]}' syjpod='"+allTrafficCount+"' id='cc1.commendglasses22' size='8' readOnly></li><li class='horizontal'></li><li class='horizontal'></li></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipconlenodnum' value='${po.sopipconlenodnum}' class='text_input' size='1'></div></TD><TD rowspan='2' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><div align='center'><select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipconrecipetype'><option value='' selected='selected'>----请选择----</option><option value='足矫' ${po.sopipconrecipetype != '足矫' ? '':'selected=selected'}>足矫</option><option value='欠矫' ${po.sopipconrecipetype != '欠矫' ? '':'selected=selected'}>欠矫</option><option value='过矫' ${po.sopipconrecipetype != '过矫' ? '':'selected=selected'}>过矫</option></select></div></div></TD></TR><TR><TD bgcolor='#F8E0F0' class='PrivateBorderPink'>OS</TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyneedChange='needChange' sph='sph' id='sopipballglassos' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' value='${po.sopipballglassos}' class='text_input' size='2'  enter='enter8'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyneedChange='needChange' cyl='cyl' id='sopippostglassos' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' value='${po.sopippostglassos}' class='text_input' size='2'  enter='enter9'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyaxes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' value='${po.sopipaxesos}' class='text_input' size='2'  enter='enter10'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureos1' value='${po.sopipeyecurvatureos1}' class='text_input' size='2'  enter='enter11'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureos2' value='${po.sopipeyecurvatureos2}' class='text_input' size='2'  enter='enter12'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipdiameteros' value='${po.sopipdiameteros}' class='text_input' size='2'  enter='enter13'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipconlenvaos' value='${po.sopipconlenvaos}' class='text_input' size='2'  enter='enter14'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><li class='horizontal'>适用镜片：<input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglasses' value='${fn:replace(fn:split(po.sopipcommendglasses,',')[1],' ','')}' id='cc1.commendglasses22' size='8' readOnly></li><li class='horizontal'></li><li class='horizontal'></li></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipconlenosnum' value='${po.sopipconlenosnum}' class='text_input' size='1'></div></TD></TR><TBODY><TR><TD colspan='2' bgcolor='#F8E0F0' class='PrivateBorderPink'>护理液品种:</TD><TD colspan='9' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='left'><textarea readonly='readonly'  id='sopipcommendcardwater' name='inspectionPos["+Subtr(1,listindex)+"].sopipcommendcardwater'>${po.sopipcommendcardwater}</textarea></div></TD></TR><TR><TD colspan='2' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='left'>备注： </div></TD><TD colspan='9' bgcolor='#F8E0F0' class='PrivateBorderYellow'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'>${po.sopipdignosisre}</textarea></TD></TR></TBODY></TABLE></td></tr></table>"
		
	  }if("${po.sopipglasstype }" == "5"){
		  
		c1.innerHTML=c1.innerHTML+"<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='5'/><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='zy'><TR><TD colspan='14' style='height:20px' class='PrivateBorderGreen' bgcolor='00bbff'><p>框架--中用&nbsp;&nbsp;&nbsp;<br></p></TD>	</TR><TR><TD bgcolor='#00bbff' class='PrivateBorderGreen'>&nbsp;</TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>球镜</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>柱镜</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>轴向</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>三棱镜</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>基底</div></TD>"
									+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>中用瞳距(mm)</div></TD>"
									+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>瞳高(mm)</div></TD>"
									+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>中用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#00bbff' class='PrivateBorderGreen'>OD</TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyneedChange='needChange' yyorder='1' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' value='${po.sopipballglassod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonly needChange='needChange' yyorder='2' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' value='${po.sopippostglassod}' class='text_input cyl' size='4'></div></TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonly  axes='axes' yyorder='3' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' value='${po.sopipaxesod}' class='text_input axes' size='4'></div></TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='4' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' value='${po.sopiparriseglassod1}' class='text_input' size='4'></div></TD><TD width='6%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><select disabled=disabled  yyorder='5' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1'><option value=''>----请选择----</option><option value='内' ${po.sopipbasisod1 != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${po.sopipbasisod1 != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${po.sopipbasisod1 != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${po.sopipbasisod1 != '下' ? '' : 'selected=selected' }>下</option></select></div></TD>"
									+"<TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='6' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' class='text_input' size='4' value='${po.sopipinterhighod}'></div></TD>"
									+"<TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='6' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' class='text_input' size='4' value='${po.sopippupilheightod}'></div></TD>"
									+"<TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='7' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' class='text_input' size='4' value='${po.sopipfarvaod}'></div></TD></TR><TR><TD width='11%' bgcolor='#00bbff' class='PrivateBorderGreen'>OS</TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyneedChange='needChange' yyorder='8' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' value='${po.sopipballglassos}' class='text_input' size='4'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyneedChange='needChange' yyorder='9' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' value='${po.sopippostglassos}' class='text_input' size='4'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyaxes='axes' yyorder='10' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' value='${po.sopipaxesos}' class='text_input' size='4'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyljxj='ljxj' yyorder='11' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' class='text_input' size='4' value='${po.sopiparriseglassos1 }'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><select disabled=disabled  yyorder='12' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1'><option value='' selected='selected'>----请选择----</option><option value='内' ${po.sopipbasisos1 != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${po.sopipbasisos1 != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${po.sopipbasisos1 != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${po.sopipbasisos1 != '下' ? '' : 'selected=selected' }>下</option></select></div></TD>"
									+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' class='text_input' size='4' value='${po.sopipinterhighos }'></div></TD>"
									+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyyyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' class='text_input' size='4' value='${po.sopippupilheightos }'></div></TD>"
									+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input readonly=readonlyva='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos' readonly='readonly' class='text_input' size='4' value='${po.sopipfarvaos}'></div></TD></TR><TR><TD colspan='6' bgcolor='#00bbff' class='PrivateBorderGreen'><li class='horizontal'><div align='center'>适用镜片：<input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglasses' value='${po.sopipcommendglasses}' id='cc1.commendglasses' size='12' readOnly></div></li><li class='horizontal'><div align='center'></div></li><li class='horizontal'><div align='center'></div></li></TD><TD colspan='4' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>中距离：<input readonly=readonly type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance' ${po.sopipmiddledistance != '1' ? '':'checked=checked'}>建议镜框：<select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'><OPTION value='' selected>----请选择----</OPTION><OPTION value='打孔' ${po.sopipsuggestframe != '打孔' ? '':'selected=selected'}>打孔</OPTION><OPTION value='拉丝' ${po.sopipsuggestframe != '拉丝' ? '':'selected=selected'}>拉丝</OPTION><OPTION value='板材' ${po.sopipsuggestframe != '板材' ? '':'selected=selected'}>板材</OPTION><OPTION value='框高' ${po.sopipsuggestframe != '框高' ? '':'selected=selected'}>框高</OPTION></SELECT><input readonly=readonlyname='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' value='${po.sopipframeheight}' size='12'></div></TD></TR><TR><TD colspan='2' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='right'>建议镜片材质:<TD colspan='2' bgcolor='#00bbff' class='PrivateBorderGreen'><select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'><OPTION value='' selected>----请选择----</OPTION><OPTION value='老花渐进' ${po.sopipglassmaterial != '老花渐进' ? '':'selected=selected'}>老花渐进</OPTION><OPTION value='青少年渐进' ${po.sopipglassmaterial != '青少年渐进' ? '':'selected=selected'}>青少年渐进</OPTION><OPTION value='非球面树脂' ${po.sopipglassmaterial != '非球面树脂' ? '':'selected=selected'}>非球面树脂</OPTION><OPTION value='抗辐射镜片' ${po.sopipglassmaterial != '抗辐射镜片' ? '':'selected=selected'}>抗辐射镜片</OPTION><OPTION value='染色镜片' ${po.sopipglassmaterial != '染色镜片' ? '':'selected=selected'}>染色镜片</OPTION><OPTION value='变色镜片' ${po.sopipglassmaterial != '变色镜片' ? '':'selected=selected'}>变色镜片</OPTION><OPTION value='普通树脂' ${po.sopipglassmaterial != '普通树脂' ? '':'selected=selected'}>普通树脂</OPTION><OPTION value='高折玻璃' ${po.sopipglassmaterial != '高折玻璃' ? '':'selected=selected'}>高折玻璃</OPTION><OPTION value='玻璃片' ${po.sopipglassmaterial != '玻璃片' ? '':'selected=selected'}>玻璃片</OPTION><OPTION value='树脂抗疲劳镜片' ${po.sopipglassmaterial != '树脂抗疲劳镜片' ? '':'selected=selected'}>树脂抗疲劳镜片</OPTION><OPTION></OPTION></SELECT></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><select disabled=disabled  name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'><option value='' selected>----请选择----</option><option value='足矫' ${po.sopipdisposemanner != '足矫' ? '':'selected=selected'}>足矫</option><option value='欠矫' ${po.sopipdisposemanner != '欠矫' ? '':'selected=selected'}>欠矫</option><option value='过矫' ${po.sopipdisposemanner != '过矫' ? '':'selected=selected'}>过矫</option><option value='附加棱镜' ${po.sopipdisposemanner != '附加棱镜' ? '':'selected=selected'}>附加棱镜</option><option value='调整' ${po.sopipdisposemanner != '调整' ? '':'selected=selected'}>调整</option><option value='平衡'>平衡</option><option value='医嘱' ${po.sopipdisposemanner != '医嘱' ? '':'selected=selected'}>医嘱</option><option value='全矫' ${po.sopipdisposemanner != '全矫' ? '':'selected=selected'}>全矫</option><option value='患者要求减度' ${po.sopipdisposemanner != '患者要求减度' ? '':'selected=selected'}>患者要求减度</option></select></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='left'>备注:</div></TD><TD colspan='3' bgcolor='#00bbff' class='PrivateBorderGreen'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'>${po.sopipdignosisre}</textarea></TD></TR></TBODY></TABLE>"
	  }
	  if(myValue == "4"){
	  	xzindex = xzindex+2;
	  }else{
	  	xzindex++;
	  }
	  </c:forEach>
      allTrafficCount++;   //总计多少行   
      inspectionForm.trafficCount.value   =   allTrafficCount;   
  }
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="inspectionForm" method="post" action="">
<input type="hidden" name="moduleID" value="${moduleID }"/>
<input type="hidden" name="customerID" id="customerID" value="${requestScope.customerID}" /> 
<input type="hidden" name="optometryBasicID" id="optometryBasicID" value="${requestScope.optometryBasicID}" /> 
<input type="hidden" name="optometryID" id="optometryID" value="${requestScope.optometryID}" /> 
<input type="hidden" name="dontshow" id="dontshow" value="${dontshow}" /> 

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
			<TR>
						  <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
						  background=${ctx}/img/pic/tab_top_bg.gif>
							<TABLE cellSpacing=0 cellPadding=0 border=0>
							  <TBODY>
							  <TR><!--ťStart-->
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
												  UNSELECTABLE="on">特殊功能检查</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx}/img/pic/tab_unactive_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
										  </TD>
									</TR>
								</TBODY>
							</TABLE>
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top>
						<s:action name="initCustomerOptometryTitle" executeResult="true" />									
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

                                    <TR>
                                      <TD height="30" bgcolor="#E8F8FF">
                                      <div align="center" class="PrivateBorder">复诊时间：
                                          ${inspectionPos[0].sopipseccheckdate }
                                          &nbsp;&nbsp;&nbsp;推荐医师：${inspectionPos[0].sopipexaminedoctorname}
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
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>