<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员维护</title>
<script language="javascript" src="${ctx }/js/zone.js"></script>

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

function setAge(){
	document.getElementById("tableage").innerHTML =jsGetAge('${fn:substring(personInfoPo.birthday,0,10)}');
	if(document.getElementById("memberPicID")!=null){
		document.getElementById("memberPicID").src=document.getElementById("memberPicID").src+"?t="+Math.random();
	}
}

function jsGetAge(strBirthday){       
    var returnAge;
    var strBirthdayArr=strBirthday.split("-");
    var birthYear = strBirthdayArr[0];
    var birthMonth = strBirthdayArr[1];
    var birthDay = strBirthdayArr[2];
    
    d = new Date();
    var nowYear = d.getFullYear();
    var nowMonth = d.getMonth() + 1;
    var nowDay = d.getDate();
    //alert(nowYear + "  " + birthYear);
    if(nowYear == birthYear)
    {
        //returnAge = 0;//同年 则为0岁
        returnAge = 1;//同年 则为0岁
    }
    else
    {
        var ageDiff = nowYear - birthYear ; //年之差
        
        returnAge = ageDiff;
    }    
return returnAge;//返回周岁年龄    
}

function showSubMenu(obj){ 
	//alert(obj);
	$('#titleoftechnicalpost').load("getPostAjax.action?mtpid="+obj);
}
	function openDepartment(){
		var companyid = $("#companysid").val();
		
		if(companyid == ''){
			alert("请选择公司！");
			$("#companysid").focus();
			return;
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDepartmentOpen.action?companyid="+companyid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDepartmentOpen.action?companyid="+companyid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}
	
	var s = '';
	var opt0 = ["省份","地级市","市、县级市、县"];
	
	window.onload=function() {
		setAge();
		s = new Array();
		s[0] = document.getElementById("zone1");
		s[1] = document.getElementById("zone2");
		s[2] = document.getElementById("zone3");
		
		
		
		
		for(i=0;i<s.length-1;i++){
			s[i].onchange=new Function("change("+(i+1)+")");
		}
		
		change(0);
		document.getElementById("zone1").selectedIndex = 26;
		change(1);
		document.getElementById("zone3").selectedIndex = 2;
		
		
				//回车
		$(':input[yyorder]').each(function(){
				$(this).unbind("keydown");
				$(this).keydown(function(){
					if(event.keyCode == 13){
						var index=$(this).attr('yyorder');
						$(':input[yyorder='+accAdd(index,1)+']').focus();
					}
				});
			});
		
		
	//区域赋值 Begin	

		<c:if test="${fn:length(zones) > 0}">

			var options = document.getElementById("zone1").options;
			<c:if test="${fn:length(zones) >= 1}">
			var zone1 = '${zones[0]}';
			for(i = 0;i < options.length;i++){
				
				if(options[i].value.trim() == zone1){
					document.getElementById("zone1").selectedIndex = i;
					change(1);
					break;
				}
			}
			</c:if>
			<c:if test="${fn:length(zones) >= 2}" >
			var zone2 = '${zones[1]}';
			options = document.getElementById("zone2").options;
			for(i = 0;i < options.length;i++){				
				if(options[i].value == zone2){ 
					document.getElementById("zone2").selectedIndex = i;
					change(2);
					break;
				}
			}
			</c:if>
			<c:if test="${fn:length(zones) >= 3}" >
			var zone3 = '${zones[2]}';
			options = document.getElementById("zone3").options;
			
			for(i = 0;i < options.length;i++){
				if(options[i].value == zone3){
					document.getElementById("zone3").selectedIndex = i;
					change(3);
					break;
				}
			}
			</c:if>
		</c:if>
	//区域赋值 End		
		
	};
	
	
	
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
	}
	
	 function addRow(tableName,args) {;
		var table = document.getElementById(tableName);
		var row = table.insertRow(table.rows.length);
		var rowNum = table.rows.length - 1;	
		var txtName = args.split(",");	
		var innerHTMLName = new Array(txtName.length); 

		for (var i = 0; i < txtName.length; i++) {
			innerHTMLName[i] =  row.insertCell(i);
			innerHTMLName[i].bgcolor="#000000";
			if(i==txtName.length-1){
				innerHTMLName[i].innerHTML= '<input type="text" value="删除" onclick="deleteRow(\''+ tableName +'\',this)" style="text-align:center;border:0px;cursor: hand;">'; 	
			}else{
				
				if(i==0){
					innerHTMLName[i].innerHTML= '<input id="' +txtName[i] +  rowNum + '" '
							+ 'name="'+ txtName[i] +'" '
							+ 'style="text-align:center;width:100%;border:0px;" maxlength="50" />';
				}else{
					innerHTMLName[i].innerHTML= '<input id="' +txtName[i] +  rowNum + '" '
						+ 'name="'+ txtName[i] +'" '
						+ 'style="text-align:center;width:100%;border:0px;" maxlength="50" />';
				}
			}
		}	
    }
    
  
    function deleteRow(tableName,index) {       
       $(index).parent().parent().remove();
    }
	 



	var ImgObj = new Image(); 	// 建立一个图像对象
	var AllImgExt = ".jpg|.jpeg|.gif|.bmp|.png|";	// 全部图片格式类型
	var FileObj,ImgFileSize,ImgWidth,ImgHeight,FileExt,ErrMsg,FileMsg,IsImg; // 全局变量图片相关属性
	// 以下为限制变量
	var AllowExt = ".jpg|.jpeg|.gif|.bmp|.png|"; 	// 允许上传的文件类型 &#320;为无限制每个扩展名后边要加一个"|" 小写字母表示
	
	var AllowImgFileSize = 30; 	// 允许上传图片文件的大小 0为无限制 单位：KB
	var AllowImgWidth = 800; 		// 允许上传的图片的宽度 &#385;为无限制　单位：px(像素)
	var AllowImgHeight = 800; 	// 允许上传的图片的高度 &#441;为无限制　单位：px(像素)
	
	ImgObj.onerror = function(){ErrMsg = '\n图片格式不正确或者图片已损坏!';}	
	function CheckExt(obj){	    
	    ErrMsg = "";
		FileMsg = "";
		IsImg = false;
		if(obj.value == ""){
			return false;
		}
		FileExt = obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();		
		if(AllImgExt.indexOf(FileExt+"|") == -1){ 
			alert("该文件类型不允许上传。请上传 " + AllImgExt + " 类型的文件，\n当前文件类型为" + FileExt);
			return false;
		}
	}
	
	 
	
	function save(){
		if(checkForm(personInfoForm))
		{
			var FileExt;
			var AllImgExt = ".jpg|.jpeg|.gif|.bmp|.png|"	// 全部图片格式类型 		
       		var flag = false;
       		$('input[name=upload]').each(function(i){
           		var bbdlogo = $(this).val(); 
           		var tem=  $(this).attr("id")+"id";
	       		if(bbdlogo != "" && bbdlogo != null){ 
	       			 document.getElementById(tem).value=1;
       		        FileExt = bbdlogo.substr(bbdlogo.lastIndexOf(".")).toLowerCase();    
			        if(AllImgExt.indexOf(FileExt+"|") == -1){ // 如果不是图片文件，则提示
				        alert("该文件类型不允许上传,请上传 " + AllImgExt + " 类型的文件\n当前文件类型为" + FileExt);
				        flag = true;
				        return false;
			        }
       		    }
            });       		
       		if (flag){
       		    return;
       		}
		
			
			$("img").removeAttr("onclick");
			personInfoForm.action = "updateMPersonInfo.action";
			personInfoForm.submit();
		}
	}
</script>
<BODY  leftMargin=2 topMargin=0 marginheight="0" marginwidth="0">


<form id="personInfoForm" name="personInfoForm" action="" method="post" ENCTYPE="multipart/form-data">
<input id="picturepathid" name="picturepathid" value=" " type="hidden"/>
<input id="positivecardpathid" name="positivecardpathid" value=" " type="hidden"/>
<input id="backcardpathid" name="backcardpathid" value=" " type="hidden"/>

<input id="personInfoPo.picturepath" name="personInfoPo.picturepath" value="${personInfoPo.picturepath } " type="hidden"/>
<input id="personInfoPo.positivecardpath" name="personInfoPo.positivecardpath" value=" ${ personInfoPo.positivecardpath}" type="hidden"/>
<input id="personInfoPo.backcardpath" name="personInfoPo.backcardpath" value="${ personInfoPo.backcardpath} " type="hidden"/>
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><img border='0' src='${ctx }/img/pic/msgbg.png' align='absmiddle' hspace='3' vspace='3'>员工档案管理</TD>
        </TR></TBODY></TABLE>

<TABLE width="90%" 
border=0 align=center cellPadding=0 cellSpacing=0>
  <TR class=tdbg>
    <TD height="40" align="center" bgcolor="#FFFFFF"><span class="STYLE1"><font ><strong> 员 工 登 记 表</strong></font></span></TD>
    </TR>
</TABLE>
<TABLE width="90%" 
border=0 align=center cellPadding=0 cellSpacing=0>
          <tr>
            <td height="30"><strong>1、信息现状</strong></td>
          </tr>
        </table>
        <table width="90%" align=center border="0" cellpadding="0" cellspacing="1" bgcolor="#000000">
          <tr>
            <td  width="10%" height="30" align="center" valign="middle" bgcolor="#FFFFFF">ID号</td>
            <td width="18%" align="left" valign="middle" bgcolor="#FFFFFF"><input type="hidden" id="id" name="personInfoPo.id" value="${personInfoPo.id }" >${personInfoPo.id }</td>
            <td width="10%" align="center" valign="middle" bgcolor="#FFFFFF">入司日期</td>
            <td width="18%" align="left" valign="middle" bgcolor="#FFFFFF">
		    <input id="entrytime" name="personInfoPo.entrytime"  type="text" class="text_input100"  onFocus="WdatePicker({readOnly:true})" value="${personInfoPo.entrytime }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '入司日期不能为空！'}]"><label style="color:red;">&nbsp;*</label>
		    </td>
           <td align="center" valign="middle" bgcolor="#FFFFFF">是否在职</td>
            <td align="left" valign="middle" bgcolor="#FFFFFF">
            <select name="personInfoPo.isinvocation">
            <option value="0" ${personInfoPo.isinvocation == 0 ? 'selected="selected"':''}>是</option>
            <option value="1" ${personInfoPo.isinvocation == 1 ? 'selected="selected"':''}>否</option>
            
          </select></td>
          </tr>
          <tr>
            <td width="9%" height="30" align="center" valign="middle" bgcolor="#FFFFFF">劳动合同签订日期</td>
            <td width="24%" align="left" valign="middle" bgcolor="#FFFFFF">
            	<input id="laodonghetongdate" name="personInfoPo.laodonghetongdate"  type="text" class="text_input100"  onFocus="WdatePicker({readOnly:true})" value="${personInfoPo.laodonghetongdate }" >
            </td>
            <td width="9%" align="center" valign="middle" bgcolor="#FFFFFF">试用日期</td>
            <td width="18%" align="left" valign="middle" bgcolor="#FFFFFF">
		    <input id="shiyongriqi" name="personInfoPo.shiyongriqi"  type="text" class="text_input100"  onFocus="WdatePicker({readOnly:true})" value="${personInfoPo.shiyongriqi }" >
		    </td>
            <td width="9%" align="center" valign="middle" bgcolor="#FFFFFF">转正日期</td>
            <td align="left" valign="middle" bgcolor="#FFFFFF">
            <input id="zhuanzhengriqi" name="personInfoPo.zhuanzhengriqi"  type="text" class="text_input100"  onFocus="WdatePicker({readOnly:true})" value="${personInfoPo.zhuanzhengriqi }">
			</td>
          </tr> 
          <tr>
            <td width="9%" height="30" align="center" valign="middle" bgcolor="#FFFFFF">职工类别</td>
            <td width="24%" align="left" valign="middle" bgcolor="#FFFFFF">
            	<select name="personInfoPo.zhigongtype" id="zhigongtype">
		            <option value="" selected="selected">--请选择--</option>
		            <option value="原职" ${personInfoPo.zhigongtype != '原职' ? '' : 'selected="selected"' }>原职</option>
		            <option value="合同" ${personInfoPo.zhigongtype != '合同' ? '' : 'selected="selected"' }>合同</option>
		            <option value="返聘" ${personInfoPo.zhigongtype != '返聘' ? '' : 'selected="selected"' }>返聘</option>
		            <option value="临时" ${personInfoPo.zhigongtype != '临时' ? '' : 'selected="selected"' }>临时</option>
		            <option value="协议" ${personInfoPo.zhigongtype != '协议' ? '' : 'selected="selected"' }>协议</option>
		            <option value="特殊" ${personInfoPo.zhigongtype != '特殊' ? '' : 'selected="selected"' }>特殊</option>
		            <option value="试用" ${personInfoPo.zhigongtype != '试用' ? '' : 'selected="selected"' }>试用</option>		            
		        </select>
            </td>
            <td width="9%" align="center" valign="middle" bgcolor="#FFFFFF">离职日期</td>
            <td width="18%" align="left" valign="middle" bgcolor="#FFFFFF">
		    <input id="lizhidate" name="personInfoPo.lizhidate"  type="text" class="text_input100"  onFocus="WdatePicker({readOnly:true})" value="${personInfoPo.lizhidate }" >
		    </td>
            <td width="9%" align="center" valign="middle" bgcolor="#FFFFFF">续签日期</td>
            <td align="left" valign="middle" bgcolor="#FFFFFF">
			<input id="xuqiandate" name="personInfoPo.xuqiandate"  type="text" class="text_input100"  onFocus="WdatePicker({readOnly:true})" value="${personInfoPo.xuqiandate }" >
			</td>
          </tr>            
          <tr>
            <td align="center" valign="middle" bgcolor="#FFFFFF">工龄</td>
            <td align="left" valign="middle" bgcolor="#FFFFFF">${personInfoPo.lengthwork }</td>

            <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">人员角色</td>
            <td align="left" valign="middle" bgcolor="#FFFFFF">
            <select id="roleid" name="personInfoPo.roleid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择人员角色！'}]">
						   		<option value="">----请选择----</option>
					  			<c:forEach var="po" items="${roles}">
					  			<option value="${po.roleid }" ${personInfoPo.roleid != po.roleid ? '' : 'selected="selected"' }>${po.rolename }</option>
					  			</c:forEach>							
								</select><label style="color:red;">&nbsp;*</label>
			</td>
            <td align="center" valign="middle" bgcolor="#FFFFFF">密       码</td>
            <td align="left" valign="middle" bgcolor="#FFFFFF">
            <c:if test="${permissionPo.keyf == '1'}">
                <input id="password" name="personInfoPo.password" type="text"   value="${personInfoPo.password}" class="text_input100" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '人员密码不能为空！'}]"/><label style="color:red;">&nbsp;*</label>
            </c:if>
            <c:if test="${permissionPo.keyf != '1'}">
                <input id="password" name="personInfoPo.password" type="password"   value="${personInfoPo.password}" class="text_input100" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '人员密码不能为空！'}]"/><label style="color:red;">&nbsp;*</label>
            </c:if>
            &nbsp;            
            </td>
          </tr>
          <tr>
          	<td height="30" align="center" valign="middle" bgcolor="#FFFFFF">所属公司</td>
            <TD height="26" bgcolor="#FFFFFF">
	   			<select id="companysid" name="personInfoPo.personcompanyid">
                    <option value="">----请选择----</option>
                    <s:iterator value="companyNamePos">
                    <option value="${fcnId}" ${personInfoPo.personcompanyid == fcnId ? 'selected="selected"':''}>${fcnName}</option>
                    </s:iterator>
                </select>
            </TD>
            <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">部       门</td>
            <td align="left" valign="middle" bgcolor="#FFFFFF">
	        	<li class="horizontal_onlyRight">
					<input id="bdpdepartmentname" name="personInfoPo.bdpdepartmentname" value="${personInfoPo.bdpdepartmentname }" readonly="readonly" />
					<input type="hidden" id="departmentID" name="personInfoPo.departmentID" value="${personInfoPo.departmentID }"
						   		validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '部门名称不能为空！'}]"/>
				</li>
				 <li class="horizontal_onlyRight">
				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" name=ctl00$PageBody$Button1 onClick="openDepartment();"></li><label style="color:red;">&nbsp;*</label>
            </td>
            <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">职       务</td>
            <td align="left" valign="middle" bgcolor="#FFFFFF">
	        <select id="postid" name="personInfoPo.postid" onchange="showSubMenu(this.options[this.options.selectedIndex].value)" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择职务！'}]">
						   		<option value="">----请选择----</option>
					  			<c:forEach var="postPo" items="${postPos}">
					  			<option value="${postPo.mptid }" ${personInfoPo.postid != postPo.mptid ? '' : 'selected="selected"' }>${postPo.mptcontent }</option>
					  			</c:forEach>							
								</select><label style="color:red;">&nbsp;*</label>
            </td>
          </tr>
          <tr>
            <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">职       称</TD>
			               <td align="left" valign="middle" bgcolor="#FFFFFF" colspan="5">
			               <select id="titleoftechnicalpost" name="personInfoPo.titleoftechnicalpost" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择职称！'}]">
						   		<option value="">----请选择(0)----</option>	
						   		<c:forEach var="postPo" items="${postPos2}">
					  			<option value="${postPo.mptid }" ${personInfoPo.titleoftechnicalpost != postPo.mptid ? '' : 'selected="selected"' }>${postPo.mptcontent }</option>
					  			</c:forEach>
								</select><label style="color:red;">&nbsp;*
						   </TD>
          </tr>
           <tr>
            <td height="109" align="center" valign="middle" bgcolor="#FFFFFF">特长</td>
            <td colspan="5" align="left" valign="middle" bgcolor="#FFFFFF"><textarea name="personInfoPo.techang" maxlength="200" style="width:100%" id="remark" cols="80" rows="7">${personInfoPo.techang}</textarea></td>
          </tr>           
          <tr>
            <td height="109" align="center" valign="middle" bgcolor="#FFFFFF">备       注</td>
            <td colspan="5" align="left" valign="middle" bgcolor="#FFFFFF"><textarea name="personInfoPo.remark" maxlength="200" style="width:90%" id="remark" cols="80" rows="7">${personInfoPo.remark}</textarea></td>
          </tr>
        </table>
<TABLE width="90%" 
border=0 align=center cellPadding=0 cellSpacing=0>
  <TR>
    <TD bgcolor="#FFFFFF">
	    <table width="100%" border="0" cellpadding="0" cellspacing="0">
	      <tr>
	        <td height="30"><strong>2、<span class="STYLE2">员工基本情况</span></strong></td>
	      </tr>
	    </table>
	    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#000000">
	    <tr>
          <td width="10%" height="30" align="center" valign="middle" bgcolor="#FFFFFF">姓        名</td>
          <td width="18%" align="left" valign="middle" bgcolor="#FFFFFF"><input name="personInfoPo.personName" id="personName" type="text" value="${personInfoPo.personName}" maxlength="10" style="width:80%" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '人员姓名不能为空！'},{'Type' : Type.String, 'Formula' : Formula.ALL_CN, 'Message' : '姓名为全中文！'}]"><label style="color:red;">&nbsp;*</label></td>
          <td width="10%" align="center" valign="middle" bgcolor="#FFFFFF">性       别</td>
          <td width="18%" align="left" valign="middle" bgcolor="#FFFFFF"><label>
          <select name="personInfoPo.sex">
            <option value="1" ${personInfoPo.sex == 1 ? 'selected="selected"':'' } >男</option>
            <option value="2" ${personInfoPo.sex == 2 ? 'selected="selected"':''} >女</option>
          </select>
          </label></td>
          <td width="10%" align="center" valign="middle" bgcolor="#FFFFFF">出生日期</td>
          <td width="18%" align="left" valign="middle" bgcolor="#FFFFFF">
		  	<input id="birthday" name="personInfoPo.birthday"  type="text" class="text_input100"  onFocus="WdatePicker({readOnly:true})" value="${personInfoPo.birthday }"  validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '出生日期不能为空！'}]"/>
		  </td>
          <td width="10%" rowspan="5" align="center" valign="middle" bgcolor="#FFFFFF">
          	<c:if test="${not empty personInfoPo.picturepath}">
         	 	<img src="${ctx}/${personInfoPo.picturepath}" name="pic0" height="140">
         	 </c:if>
          </td>
        </tr>
    <tr>
      <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">籍    贯</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">
          <select name="personInfoPo.nativeplace" id="nativeplace">
          	<option value="重庆市">重庆市</option>
			<option value="天津市">天津市</option>
			<option value="北京市">北京市</option>
			<option value="河北省">河北省</option>
			<option value="山西省">山西省</option>
			<option value="内蒙古自治区">内蒙古自治区</option>
			<option value="辽宁省" >辽宁省</option>
			<option value="吉林省" >吉林省</option>
			<option value="黑龙江省" >黑龙江省</option>
			<option value="上海市" >上海市</option>
			<option value="江苏省" >江苏省</option>
			<option value="浙江省" >浙江省</option>
			<option value="安徽省" >安徽省</option>
			<option value="福建省" >福建省</option>
			<option value="江西省" >江西省</option>
			<option value="山东省" >山东省</option>
			<option value="河南省" >河南省</option>
			<option value="湖北省" >湖北省</option>
			<option value="湖南省" >湖南省</option>
			<option value="广东省" >广东省</option>
			<option value="广西壮族自治区" >广西壮族自治区</option>
			<option value="海南省" >海南省</option>
			<option value="四川省" >四川省</option>
			<option value="贵州省" >贵州省</option>
			<option value="云南省" >云南省</option>
			<option value="西藏自治区" >西藏自治区</option>
			<option value="陕西省" >陕西省</option>
			<option value="甘肃省" >甘肃省</option>
			<option value="青海省" >青海省</option>
			<option value="宁夏回族自治区"  >宁夏回族自治区</option>
			<option value="新疆" >新疆</option>
			<option value="台湾省" >台湾省</option>
			<option value="国外" >国外</option>
		  </select></td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">民       族</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">
          <select name="personInfoPo.nation" id="nation">
          <option value="汉族" >汉族</option>
<option value="蒙古族">蒙古族</option>
<option value="回族">回族</option>
<option value="藏族">藏族</option>
<option value="维吾尔">维吾尔</option>
<option value="苗族">苗族</option>
<option value="彝族">彝族</option>
<option value="壮族">壮族</option>
<option value="布依族">布依族</option>
<option value="朝鲜族">朝鲜族</option>
<option value="满族">满族</option>
<option value="侗族">侗族</option>
<option value="瑶族">瑶族</option>
<option value="白族">白族</option>
<option value="土家族">土家族</option>
<option value="哈尼族">哈尼族</option>
<option value="哈萨克族">哈萨克族</option>
<option value="傣族">傣族</option>
<option value="黎族">黎族</option>
<option value="傈傈族">傈傈族</option>
<option value="佤族">佤族</option>
<option value="畲族">畲族</option>
<option value="高山族">高山族</option>
<option value="拉祜族">拉祜族</option>
<option value="水族">水族</option>
<option value="东乡族">东乡族</option>
<option value="纳西族">纳西族</option>
<option value="景颇族">景颇族</option>
<option value="柯尔克孜族">柯尔克孜族</option>
<option value="土族">土族</option>
<option value="达斡尔族">达斡尔族</option>
<option value="仫佬族">仫佬族</option>
<option value="羌族">羌族</option>
<option value="布朗族">布朗族</option>
<option value="撒拉族">撒拉族</option>
<option value="毛难族">毛难族</option>
<option value="仡佬族">仡佬族</option>
<option value="锡伯族">锡伯族</option>
<option value="阿昌族">阿昌族</option>
<option value="普米族">普米族</option>
<option value="塔吉克族">塔吉克族</option>
<option value="怒族">怒族</option>
<option value="乌孜别克族">乌孜别克族</option>
<option value="俄罗斯族">俄罗斯族</option>
<option value="鄂温克族">鄂温克族</option>
<option value="崩龙族">崩龙族</option>
<option value="保安族">保安族</option>
<option value="裕固族">裕固族</option>
<option value="京族">京族</option>
<option value="塔塔尔族">塔塔尔族</option>
<option value="独龙族">独龙族</option>
<option value="鄂伦春族">鄂伦春族</option>
<option value="赫哲族">赫哲族</option>
<option value="门巴族">门巴族</option>
<option value="珞巴族">珞巴族</option>
<option value="基诺族">基诺族</option>
</select></td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">婚姻状况</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">
          <select name="personInfoPo.ismarriage">
            <option value="1" ${personInfoPo.ismarriage == "1" ? 'selected="selected"':''}>未婚</option>
			<option value="2" ${personInfoPo.ismarriage == "2" ? 'selected="selected"':''}>已婚</option>
			<option value="3" ${personInfoPo.ismarriage == "3" ? 'selected="selected"':''}>离婚</option>
			<option value="4" ${personInfoPo.ismarriage == "4" ? 'selected="selected"':''}>丧偶</option>
			<option value="5" ${personInfoPo.ismarriage == "5" ? 'selected="selected"':''}>再婚</option>
		  </select></td>
          </tr>
    <tr>
      <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">政治面目</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">
          <select name="personInfoPo.politicslevel">
            <option value="1" ${personInfoPo.politicslevel == "1" ? 'selected="selected"':''}>群众</option>
            <option value="2" ${personInfoPo.politicslevel == "2" ? 'selected="selected"':''}>团员</option>
            <option value="3" ${personInfoPo.politicslevel == "3" ? 'selected="selected"':''}>党员</option>
            <option value="4" ${personInfoPo.politicslevel == "4" ? 'selected="selected"':''}>其它</option>
          </select></td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">户口所在地</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">
           <select yyorder="9" id="zone1" yyorder="5" style="width:150px;"  name="personInfoPo.rpraddress" value="${personInfoPo.rpraddress}"></select></br>
                          <select yyorder="10" id="zone2" yyorder="6" style="width:150px;"  name="personInfoPo.rpraddress"></select></br>
                          <select yyorder="11" id="zone3" yyorder="7" style="width:150px;" name="personInfoPo.rpraddress"></select>
          
          
                    
          </td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">户口类型</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">
 	      <select name="personInfoPo.rprtype" id="rprtype">
 	      <option value="1" ${personInfoPo.rprtype == "1" ? 'selected="selected"':''}>非农业</option>
          <option value="2" ${personInfoPo.rprtype == "2" ? 'selected="selected"':''}>农业</option>
		  <option value="3" ${personInfoPo.rprtype == "3" ? 'selected="selected"':''}>其他</option>
		  </select>         
          </td>
    </tr>
    <tr>
      <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">毕业院校</td>
          <td colspan="3" align="left" valign="middle" bgcolor="#FFFFFF"><input name="personInfoPo.graduateschool" maxlength="20" id="graduateschool" type="text" value="${personInfoPo.graduateschool}" style="width:90%"></td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">所学专业</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF"><input name="personInfoPo.learnspeciality" id="learnspeciality" type="text" maxlength="20"  value="${personInfoPo.learnspeciality}" style="width:90%"></td>
    </tr>
    <tr>
      <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">专业技术职称</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF"><input name="personInfoPo.specialitylevel" id="specialitylevel" type="text" maxlength="20" value="${personInfoPo.specialitylevel}" style="width:90%"></td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">专业执业资格</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF"><input name="personInfoPo.specialitycompetence" id="specialitycompetence" type="text" maxlength="20" value="${personInfoPo.specialitycompetence}" style="width:90%"></td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">参加工作时间</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">
          <input id="startworkdate" name="personInfoPo.startworkdate" type="text" class="text_input100"  onFocus="WdatePicker({readOnly:true})"  value="${personInfoPo.startworkdate }" >
          </td>
    </tr>
    <tr>
      <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">最高学历</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">
	        <select id="maxschoollevel" name="personInfoPo.maxschoollevel"  validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择学历！'}]">
						   		<option value="">----请选择----</option>
					  			<c:forEach var="educationPo" items="${educationList}">
					  			<option value="${educationPo.metid}" ${personInfoPo.maxschoollevel != educationPo.metid ? '' : 'selected="selected"' }>${educationPo.metname }</option>
					  			</c:forEach>							
								</select><label style="color:red;">&nbsp;*</label>			  
		  </td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">学习形式</td>
          <td colspan="4" align="left" valign="middle" bgcolor="#FFFFFF">
	          <select name="personInfoPo.learnformat" id="learnformat">
	          <option value="1" ${personInfoPo.learnformat == "1" ? 'selected="selected"':''}>正规高等教育</option>
			  <option value="2" ${personInfoPo.learnformat == "2" ? 'selected="selected"':''}>高自考</option>
			  <option value="3" ${personInfoPo.learnformat == "3" ? 'selected="selected"':''}>成人高考</option>
			  <option value="4" ${personInfoPo.learnformat == "4" ? 'selected="selected"':''}>其他</option>
	          </select>
          </td>
    </tr>
    <tr>
          <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">身份证号</td>
          <td colspan="3" align="left" valign="middle" bgcolor="#FFFFFF"><input name="personInfoPo.idcardnum" id="idcardnum" type="text" value="${personInfoPo.idcardnum}"  style="width:90%" validate="[{'Type' : Type.String, 'Formula' : Formula.IdentityCard, 'Message' : '身份证号码不对！'}]"/></td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">手机号码</td>
          <td colspan="2" align="left" valign="middle" bgcolor="#FFFFFF"><input name="personInfoPo.phone" id="phone" type="text" value="${personInfoPo.phone}" style="width:90%" validate="[{'Type' : Type.String, 'Formula' : Formula.TelPhoneOrNull, 'Message' : '手机号码不对！'}]"/></td>
    </tr>
    <tr>
          <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">现 住 址</td>
          <td colspan="3" align="left" valign="middle" bgcolor="#FFFFFF"><input name="personInfoPo.address" maxlength="50" id="address" type="text" value="${personInfoPo.address}" style="width:90%"></td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">邮政编码</td>
          <td colspan="2" align="left" valign="middle" bgcolor="#FFFFFF"><input name="personInfoPo.postalcode" id="postalcode" maxlength="6" type="text" value="${personInfoPo.postalcode}" style="width:90%" validate="[{'Type' : Type.String, 'Formula' : Formula.Postalcode, 'Message' : '邮政编码不对！'}]" /></td>
    </tr>
        <tr>
      <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">邮箱</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">
		<input class="text_input200" type="text" yyorder="15" value="${personInfoPo.email}"  
                           id="email" name="personInfoPo.email" validate="[{'Type' : Type.String, 'Formula' : Formula.emailORNULL, 'Message' : '请填写正确的E-Mail格式！'}]">
		</td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">QQ</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">
          	<input class="text_input200" type="text" yyorder="14" value="${personInfoPo.qq}" 
                          id="qq" name="personInfoPo.qq" maxlength="12" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : 'QQ号码应为整形！'}]">
		  </td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">微信</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF" colspan="2">
		<input class="text_input200" type="text" yyorder="15" value="${personInfoPo.weixin}"   id="weixin" name="personInfoPo.weixin">
		</td>
    </tr>    
    <tr>
          <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">照 片 上 传</td>
          <td colspan="3" align="left" valign="middle" bgcolor="#FFFFFF"><input name="upload" id="picturepath" type="file" value="" style="width:90%" onChange="javascript:document.forms[0].picturepath.src=document.forms[0].picturepath.value;" onchange="CheckExt(this)"></td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">年       龄</td>
          <td colspan="2" align="left" valign="middle" bgcolor="#FFFFFF" id="tableage">&nbsp;</td>
    </tr>
    <tr>
          <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">身份证正面上传</td>
          <td colspan="3" align="left" valign="middle" bgcolor="#FFFFFF"><input name="upload" type="file"  id="positivecardpath" style="width:90%" onChange="javascript:document.forms[0].positivecardpath.src=document.forms[0].positivecardpath.value;" onchange="CheckExt(this)"></td>
          <td colspan="3" align="center" valign="middle" bgcolor="#FFFFFF">
      	  	<c:if test="${not empty personInfoPo.positivecardpath}">
      			<img src="${ctx}/${personInfoPo.positivecardpath}" name="pic1"  width="190" height="90">
      	    </c:if>
          </td>
    </tr>
    <tr>
          <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">身份证背面上传</td>
          <td colspan="3" align="left" valign="middle" bgcolor="#FFFFFF"><input name="upload" type="file" id="backcardpath" style="width:90%" onChange="javascript:document.forms[0].backcardpath.src=document.forms[0].backcardpath.value;" onchange="CheckExt(this)"></td>
          <td colspan="3" align="center" valign="middle" bgcolor="#FFFFFF">
		      <c:if test="${not empty personInfoPo.backcardpath}">
		      	<img src="${ctx}/${personInfoPo.backcardpath}" name="pic2" width="190" height="90">
		      </c:if>
          </td>
    </tr>	  	  
   </table>
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="30"><strong>3、教育培训背景(自高中开始填写)</strong></td>
          </tr>
          </table>
          
          <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#000000" id="jypx">
          <tr >
            <td   width="20%" height="30" align="center" class="myBorderBegin" bgcolor="#FFFFFF">起止时间</td>
            <td   width="35%" align="center"  bgcolor="#FFFFFF">院校名称</td>
            <td   width="30%" align="center"  bgcolor="#FFFFFF">专业</td>
            <td   width="10%" align="center"  bgcolor="#FFFFFF">学历</td>
            <td   width="5%" align="center"  valign="middle" bgcolor="#FFFFFF">
            	<input type="text" style="text-align:center;width:100%;border:0px;cursor: hand;" name="Submit" value="增加" onClick="blur();addRow('jypx','personEducationPo.mpestartstoptime,personEducationPo.mpeuniverstity,personEducationPo.mpeprofessional,personEducationPo.mpeeducation,txtdelete1');" >
            </td>
           </tr>
            <c:if test="${not empty personEducationPos}">
            <c:forEach var="educations" items="${personEducationPos}">
	             <tr>
	             	<td   bgcolor="#FFFFFF" >
	             		<input name="personEducationPo.mpestartstoptime" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${educations.mpestartstoptime }"/>
	             	</td>
	             	<td   bgcolor="#FFFFFF" >
	             		<input name="personEducationPo.mpeuniverstity" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${educations.mpeuniverstity }"/>
	             	</td>
	             	<td  bgcolor="#FFFFFF" >
	             		<input name="personEducationPo.mpeprofessional" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${educations.mpeprofessional }"/>
	             	</td>
	             	<td  bgcolor="#FFFFFF" >
	             		<input name="personEducationPo.mpeeducation" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${educations.mpeeducation }"/>
	             	</td>
	             	 <td bgcolor="#FFFFFF" >
	             	 	<input type="text" value="删除" onclick="deleteRow('jypx',this)" style="text-align:center;width:100%;border:0px;" />
	             	 </td>
	             </tr>           
            </c:forEach>
            </c:if>
          </table>
          
          
        
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="30"><strong>4、工作背景</strong></td>
          </tr>
          </table>
        <table id="gzbj" width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#000000">
          <tr>
            <td width="20%" height="30" align="center" class="myBorderBegin" bgcolor="#FFFFFF">起止时间</td>
            <td width="30%" align="center"  bgcolor="#FFFFFF">单       位</td>
            <td width="10%" align="center"  bgcolor="#FFFFFF">部     门</td>
            <td width="20%" align="center"  bgcolor="#FFFFFF">岗位</td>
            <td width="10%" align="center"  bgcolor="#FFFFFF">职务</td>
            <td width="10%" align="center"  bgcolor="#FFFFFF">
            	<input type="text" style="text-align:center;border:0px;cursor: hand;" name="Submit2" value="增加" onClick="blur();addRow('gzbj','personWorkPo.mpwstartstoptime,personWorkPo.mpwcompany,personWorkPo.mpwdepartment,personWorkPo.mpwpost,personWorkPo.mpwposition,txtdelete2');" >
            </td>
          </tr>
           <c:if test="${not empty personWorkPos}">
            <c:forEach var="works" items="${personWorkPos}">
	             <tr>
	             	<td  bgcolor="#FFFFFF" >
	             		<input name="personWorkPo.mpwstartstoptime" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${works.mpwstartstoptime }"/> 
	             	</td>
	             	<td  bgcolor="#FFFFFF" >
	             		<input name="personWorkPo.mpwcompany" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${works.mpwcompany }"/>
	             	</td>
	             	<td  bgcolor="#FFFFFF" >
	             		<input name="personWorkPo.mpwdepartment" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${works.mpwdepartment}"/>
	             	</td>
	             	<td  bgcolor="#FFFFFF" >
	             		<input name="personWorkPo.mpwpost" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${works.mpwpost }"/>
	             	</td>
	             	<td  bgcolor="#FFFFFF" >
	             		<input name="personWorkPo.mpwposition" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${works.mpwposition }"/>
	             	</td>
	             	 <td bgcolor="#FFFFFF"  ><input type="text" value="删除" onclick="deleteRow('gzbj',this)" style="text-align:center;width:100%;border:0px;"></td>
	             </tr>           
            </c:forEach>
            </c:if>
        </table>
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="30"><strong>5、家庭成员</strong></td>
          </tr>
          </table>
        <table id="jtcy" width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#000000">
          <tr>
            <td width="10%" height="30" align="center" class="myBorderBegin" bgcolor="#FFFFFF">与本人关系</td>
            <td width="10%" align="center"  bgcolor="#FFFFFF">姓名</td>
            <td width="35%" align="center"  bgcolor="#FFFFFF">居住地</td>
            <td width="10%" align="center"  bgcolor="#FFFFFF">职业</td>
            <td width="15%" align="center"  bgcolor="#FFFFFF">联系电话</td>
            <td width="10%" align="center"  bgcolor="#FFFFFF">
            	<input type="text" style="text-align:center;width:100%;border:0px;cursor: hand;" name="Submit22" value="增加" onClick="blur();addRow('jtcy','personFamilyPo.mpfrelation,personFamilyPo.mpfname,personFamilyPo.mpfaddress,personFamilyPo.mpfoccupation,personFamilyPo.mpfphone,txtdelete3');" >
            </td>
          </tr>
          <c:if test="${not empty personFamilyPos}">
            <c:forEach var="fams" items="${personFamilyPos}">
	             <tr>
	             	<td  bgcolor="#FFFFFF"  >
	             		<input name="personFamilyPo.mpfrelation" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${fams.mpfrelation }"/>
	             	</td>
	             	<td  bgcolor="#FFFFFF" >
	             		<input name="personFamilyPo.mpfname" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${fams.mpfname }"/>
	             	</td>
	             	<td  bgcolor="#FFFFFF" >
	             		<input name="personFamilyPo.mpfaddress" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${fams.mpfaddress}"/>
	             	</td>
	             	<td  bgcolor="#FFFFFF" >
	             		<input name="personFamilyPo.mpfoccupation" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${fams.mpfoccupation }"/>
	             	</td>
	             	<td  bgcolor="#FFFFFF" >
	             		<input name="personFamilyPo.mpfphone" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${fams.mpfphone }"/>
	             	</td>
	             	<td bgcolor="#FFFFFF" ><input type="text" value="删除" onclick="deleteRow('jtcy',this)" style="text-align:center" style="text-align:center;width:100%;border:0px;"></td>
	             </tr>           
            </c:forEach>
            </c:if>
          </table>
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="30"><strong>6、遇紧急情况通知人</strong></td>
          </tr>
        </table>
        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#000000">
        <tr>
            <td width="20%" height="30" align="center" valign="middle" bgcolor="#FFFFFF">姓        名</td>
            <td width="35%" align="left" valign="middle" bgcolor="#FFFFFF"><input name="emergencyContactPo.mecname"  id="mecname" type="text" value="${emergencyContactPo.mecname}" maxlength="10" style="width:100%"></td>
            <td width="15%" align="center" valign="middle" bgcolor="#FFFFFF">与本人关系</td>
            <td width="24%" align="left" valign="middle" bgcolor="#FFFFFF"><input name="emergencyContactPo.mecrelation" id="mecrelation" type="text" value="${emergencyContactPo.mecrelation}" maxlength="10" style="width:100%"></td>
        </tr>
        <tr>
            <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">工作单位</td>
            <td colspan="3" align="left" valign="middle" bgcolor="#FFFFFF"><input name="emergencyContactPo.meccompanyname" id="meccompanyname" type="text" maxlength="10" value="${emergencyContactPo.meccompanyname}" maxlength="20" style="width:100%"></td>
        </tr>
        <tr>
            <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">单位地址</td>
            <td colspan="3" align="left" valign="middle" bgcolor="#FFFFFF"><input name="emergencyContactPo.meccompanyaddress" id="meccompanyaddress" type="text" maxlength="10" value="${emergencyContactPo.meccompanyaddress}"  maxlength="20" style="width:100%"></td>
        </tr>
        <tr>
            <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">联系电话</td>
            <td colspan="3" align="left" valign="middle" bgcolor="#FFFFFF"><input name="emergencyContactPo.mecphone" id="mecphone" maxlength="20" type="text" value="${emergencyContactPo.mecphone}" style="width:100%" validate="[{'Type' : Type.String, 'Formula' : Formula.TelPhoneOrNull, 'Message' : '请重新填写联系电话！'}]"></td>
        </tr>
      </table>
     </TD>
  </TR>
  <TR>
    <TD height="40" align="center" bgcolor="#FFFFFF">
    	<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save();" >
    </TD>
    </TR>	
 </TABLE>
</form>

    
    </BODY></html>
 <script>

	var index_nativeplace = 0;
	var arr = document.all.nativeplace.options.length;
	for(i=0;i<arr;i++){
		if(document.all.nativeplace.options[i].value == '<c:out value="${personInfoPo.nativeplace}"/>')
		{
			document.all.nativeplace.selectedIndex = index_nativeplace;
			break;
		}
		index_nativeplace++;
	}

	var index_nation = 0;
	var arr = document.all.nation.options.length;
	for(i=0;i<arr;i++){
		if(document.all.nation.options[i].value == '<c:out value="${personInfoPo.nation}"/>')
		{
			document.all.nation.selectedIndex = index_nation;
			break;
		}
		index_nation++;
	}
	
	
	
	var index_maxschoollevel = 0;
	var arr = document.all.maxschoollevel.options.length;
	for(i=0;i<arr;i++){
		if(document.all.maxschoollevel.options[i].value == '<c:out value="${personInfoPo.maxschoollevel}"/>')
		{
			document.all.maxschoollevel.selectedIndex = index_maxschoollevel;
			break;
		}
		index_maxschoollevel++;
	}
	
</script>   
<%@ include file="/WEB-INF/inc/message.jsp" %>
