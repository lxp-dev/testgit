<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员维护</title>

</head>
<style type="text/css"> 
.myBorderBegin1 {
	border-left-width: 1px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-style: solid;
	border-right-style: solid;
	border-bottom-style: solid;
	border-left-color: #000000;
	border-right-color: #000000;
	border-bottom-color: #000000;
}
 
.myBorderOther1 {
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-right-style: solid;
	border-bottom-style: solid;
	border-right-color: #000000;
	border-bottom-color: #000000;
}
.myBorderBegin {
	border: 1px solid #000000;
}
 
.myBorderOther {
	border-top-width: 1px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: solid;
	border-top-color: #000000;
	border-right-color: #000000;
	border-bottom-color: #000000;
}
</style>

<script type="text/javascript">
function setAge(){
	document.getElementById("tableage").innerHTML =jsGetAge('${fn:substring(personInfoPo.birthday,0,10)}');
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

function print(){
	var DataURL = "report.action?reportlet=M_PersoninfoDetails.cpt&personid="+'${personInfoPo.id}'+"&reportGongling="+EncodeUtf8('${personInfoPo.lengthwork}'); 
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;		
	if(is_iPad()){
		showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin(DataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}		
	document.getElementById('popupTitle').innerHTML="【员工登记表】";
}
$(document).ready(function() {
	$("img[btn=btn]").attr("style","cursor: hand");
	$("img[btn=btn]").mouseover(function () {
    	$(this).attr("src",$(this).attr("src").replace("0","1"));
	}).mouseout(function () {
		$(this).attr("src",$(this).attr("src").replace("1","0"));
	});
});
</script>

<BODY onload="setAge()" leftMargin=2 topMargin=0 marginheight="0" marginwidth="0">


<form id="personInfoForm" name="personInfoForm" action="" method="post" ENCTYPE="multipart/form-data">
<input id="picturepathid" name="picturepathid" value=" " type="hidden"/>
<input id="positivecardpathid" name="positivecardpathid" value=" " type="hidden"/>
<input id="backcardpathid" name="backcardpathid" value=" " type="hidden"/>

<input id="personInfoPo.picturepath" name="personInfoPo.picturepath" value="${personInfoPo.picturepath } " type="hidden"/>
<input id="personInfoPo.positivecardpath" name="personInfoPo.positivecardpath" value=" ${ personInfoPo.positivecardpath}" type="hidden"/>
<input id="personInfoPo.backcardpath" name="personInfoPo.backcardpath" value="${ personInfoPo.backcardpath} " type="hidden"/>

<input id="reportGongling" name="personInfoPo.lengthwork" value="${ personInfoPo.lengthwork} " type="hidden" />
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><img border='0' src='${ctx }/img/pic/msgbg.png' align='absmiddle' hspace='3' vspace='3'>员工档案管理</TD>
          <TD height="40" align="right" bgcolor="#FFFFFF"><img btn=btn src="${ctx}/img/newbtn/btn_printfile_0.png" onclick="print()"/></TD>
        </TR></TBODY></TABLE>

<TABLE width="90%" 
border=0 align=center cellPadding=0 cellSpacing=0>
  <TR class=tdbg>
    <TD height="40" align="center" bgcolor="#FFFFFF"><span class="STYLE1"><font><strong>员 工 登 记 表</strong></font></span></TD>
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
            <td width="10%" height="30" align="center" valign="middle" bgcolor="#FFFFFF">ID号</td>
            <td width="18%" align="left" valign="middle" bgcolor="#FFFFFF">${personInfoPo.id }</td>
            <td width="10%" align="center" valign="middle" bgcolor="#FFFFFF">入司日期</td>
            <td width="18%" align="left" valign="middle" bgcolor="#FFFFFF">
		    ${personInfoPo.entrytime }
		    </td>
           <td align="center" valign="middle" bgcolor="#FFFFFF">是否在职</td>
            <td align="left" valign="middle" bgcolor="#FFFFFF">

            <c:if test="${personInfoPo.isinvocation == 0}">
           			 是
            </c:if>
            <c:if test="${personInfoPo.isinvocation == 1}">
           			否
            </c:if>
		</td>
          </tr>
          <tr>
            <td width="9%" height="30" align="center" valign="middle" bgcolor="#FFFFFF">劳动合同签订日期</td>
            <td width="24%" align="left" valign="middle" bgcolor="#FFFFFF">
            	${personInfoPo.laodonghetongdate }
            </td>
            <td width="9%" align="center" valign="middle" bgcolor="#FFFFFF">试用日期</td>
            <td width="18%" align="left" valign="middle" bgcolor="#FFFFFF">
		    ${personInfoPo.shiyongriqi }
		    </td>
            <td width="9%" align="center" valign="middle" bgcolor="#FFFFFF">转正日期</td>
            <td align="left" valign="middle" bgcolor="#FFFFFF">
            ${personInfoPo.zhuanzhengriqi }
			</td>
          </tr>     
          <tr>
            <td width="9%" height="30" align="center" valign="middle" bgcolor="#FFFFFF">职工类别</td>
            <td width="24%" align="left" valign="middle" bgcolor="#FFFFFF">
            	${personInfoPo.zhigongtype}
            </td>
            <td width="9%" align="center" valign="middle" bgcolor="#FFFFFF">离职时间</td>
            <td width="18%" align="left" valign="middle" bgcolor="#FFFFFF">
		    ${personInfoPo.lizhidate }
		    </td>
            <td width="9%" align="center" valign="middle" bgcolor="#FFFFFF">续签日期</td>
            <td align="left" valign="middle" bgcolor="#FFFFFF">${personInfoPo.xuqiandate }</td>
          </tr>                  
          <tr>
            <td align="center" valign="middle" bgcolor="#FFFFFF">工龄</td>
            <td align="left" valign="middle" bgcolor="#FFFFFF">
           	${personInfoPo.lengthwork }
            </td>
            <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">人员角色</TD>
			               <td align="left" valign="middle" bgcolor="#FFFFFF">
						  ${personInfoPo.rolename}
						   </TD>

            <td align="center" valign="middle" bgcolor="#FFFFFF">密       码</td>
            <td align="left" valign="middle" bgcolor="#FFFFFF">
            <c:if test="${permissionPo.keyf == '1'}">
               ${personInfoPo.password}
            </c:if>
            &nbsp;
            </td>
          </tr>
          <tr>
            <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">部       门</td>
            <td align="left" valign="middle" bgcolor="#FFFFFF">
	        	<li class="horizontal_onlyRight">
					${personInfoPo.bdpdepartmentname }
					
				</li>
				 
            </td>
            <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">职       务</td>
            <td align="left" valign="middle" bgcolor="#FFFFFF">
            ${personInfoPo.postname}
	       
            </td>
            <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">职       称</td>
            <td align="left" valign="middle" bgcolor="#FFFFFF">${personInfoPo.postname2}</td>
          </tr>
             <tr>
            <td height="50" align="center" valign="middle" bgcolor="#FFFFFF">特长</td>
            <td colspan="5" align="left" valign="middle" bgcolor="#FFFFFF">${personInfoPo.techang}</td>
          </tr>         
          <tr>
            <td height="70" align="center" valign="middle" bgcolor="#FFFFFF">备       注</td>
            <td colspan="5" align="left" valign="middle" bgcolor="#FFFFFF">${personInfoPo.remark}</td>
          </tr>
        </table>
<TABLE width="90%" 
border=0 align=center cellPadding=0 cellSpacing=0>
  <TR class=tdbg>
    <TD bgcolor="#FFFFFF"><table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="30"><strong>2、<span class="STYLE2">员工基本情况</span></strong></td>
      </tr>
    </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#000000">
    <tr>
      
          <td width="10%" height="30" align="center" valign="middle" bgcolor="#FFFFFF">姓        名</td>
          <td width="18%" align="left" valign="middle" bgcolor="#FFFFFF">${personInfoPo.personName}</td>
          <td width="10%" align="center" valign="middle" bgcolor="#FFFFFF">性       别</td>
          <td width="18%" align="left" valign="middle" bgcolor="#FFFFFF"><label>
           <c:if test="${personInfoPo.sex == 1}">
           			男
            </c:if>
            <c:if test="${personInfoPo.sex == 2}">
           			女
            </c:if>
          
          </label></td>
          <td width="10%" align="center" valign="middle" bgcolor="#FFFFFF">出生日期</td>
          <td width="18%" align="left" valign="middle" bgcolor="#FFFFFF">
		  ${personInfoPo.birthday }
		  </td>
          <td width="10%" rowspan="5" align="center" valign="middle" bgcolor="#FFFFFF">
          <c:if test="${not empty personInfoPo.picturepath}">
          	<img src="${ctx}/${personInfoPo.picturepath}" name="pic0" height="140">
          </c:if>
          &nbsp;
          </td>
        </tr>
    <tr>
      <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">籍    贯</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">
          ${ personInfoPo.nativeplace}
</td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">民       族</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">
         ${personInfoPo.nation } 
</td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">婚姻状况</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">
          
           <c:if test="${personInfoPo.ismarriage == 1}">
           			 未婚
            </c:if>
            <c:if test="${personInfoPo.ismarriage == 2}">
           			已婚
            </c:if>
            <c:if test="${personInfoPo.ismarriage == 3}">
           			离婚
            </c:if>
            <c:if test="${personInfoPo.ismarriage == 4}">
           			丧偶
            </c:if>
             <c:if test="${personInfoPo.ismarriage == 5}">
           			再婚
            </c:if>         
          </td>
          </tr>
    <tr>
      <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">政治面目</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">
          
          <c:if test="${personInfoPo.politicslevel == 1}">
           			 群众
            </c:if>
            <c:if test="${personInfoPo.politicslevel == 2}">
           			团员
            </c:if>
            <c:if test="${personInfoPo.politicslevel == 3}">
           			党员
            </c:if>
            <c:if test="${personInfoPo.politicslevel == 4}">
           			其它
            </c:if>
          
         </td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">户口所在地</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">
                   ${personInfoPo.rpraddress }
          </td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">户口类型</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">
          
          <c:if test="${personInfoPo.rprtype == 1}">
           			 非农业
            </c:if>
            <c:if test="${personInfoPo.rprtype == 2}">
           			农业
            </c:if>
            <c:if test="${personInfoPo.rprtype == 3}">
           			其他
            </c:if>
        
 	           
          </td>
    </tr>
    <tr>
      <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">毕业院校</td>
          <td colspan="3" align="left" valign="middle" bgcolor="#FFFFFF">${personInfoPo.graduateschool}</td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">所学专业</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">${personInfoPo.learnspeciality}</td>
    </tr>
    <tr>
      <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">专业技术职称</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">${personInfoPo.specialitylevel}</td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">专业执业资格</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">${personInfoPo.specialitycompetence}</td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">参加工作时间</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">
          
          ${personInfoPo.startworkdate }
          </td>
    </tr>
    <tr>
      <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">最高学历</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">${personInfoPo.maxschoollevelname}</td>      
          <td align="center" valign="middle" bgcolor="#FFFFFF">学习形式</td>
          <td colspan="4" align="left" valign="middle" bgcolor="#FFFFFF">
          
          <c:if test="${personInfoPo.learnformat == 1}">
           			 正规高等教育
            </c:if>
            <c:if test="${personInfoPo.learnformat == 2}">
           			高自考
            </c:if>
            <c:if test="${personInfoPo.learnformat == 3}">
           			成人高考
            </c:if>
            <c:if test="${personInfoPo.learnformat == 4}">
           			其他
            </c:if>
       
          </td>
    </tr>
    <tr>
      <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">身份证号</td>
          <td colspan="3" align="left" valign="middle" bgcolor="#FFFFFF">${personInfoPo.idcardnum}</td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">手机号码</td>
          <td colspan="2" align="left" valign="middle" bgcolor="#FFFFFF">${personInfoPo.phone}</td>
    </tr>
    <tr>
      <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">现 住 址</td>
          <td colspan="3" align="left" valign="middle" bgcolor="#FFFFFF">${personInfoPo.address}</td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">邮政编码</td>
          <td colspan="2" align="left" valign="middle" bgcolor="#FFFFFF">${personInfoPo.postalcode}</td>
    </tr>
        <tr>
      <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">邮箱</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">${personInfoPo.email}</td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">QQ</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF">${personInfoPo.qq}</td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">微信</td>
          <td align="left" valign="middle" bgcolor="#FFFFFF" colspan="2">${personInfoPo.weixin}</td>
    </tr>     
    <tr>
      <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">照 片 </td>
      <td colspan="3" align="left" valign="middle" bgcolor="#FFFFFF"></td>
          <td align="center" valign="middle" bgcolor="#FFFFFF">年       龄</td>
          <td colspan="2" align="left" valign="middle" bgcolor="#FFFFFF" id="tableage">&nbsp;</td>
      </tr>
 <tr>
      <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">身份证正面</td>
      <td colspan="3" align="left" valign="middle" bgcolor="#FFFFFF"></td>
      <td colspan="3" align="center" valign="middle" bgcolor="#FFFFFF">
      <c:if test="${not empty personInfoPo.positivecardpath}">
      	<img src="${ctx}/${personInfoPo.positivecardpath}" name="pic1"  width="190" height="90">
      </c:if>
      &nbsp;
      </td>
      </tr>
 <tr>
      <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">身份证背面</td>
      <td colspan="3" align="left" valign="middle" bgcolor="#FFFFFF"></td>
      <td colspan="3" align="center" valign="middle" bgcolor="#FFFFFF">
      <c:if test="${not empty personInfoPo.backcardpath}">
     	<img src="${ctx}/${personInfoPo.backcardpath}" name="pic2" width="190" height="90">
      </c:if>
       &nbsp;
      </td>
      </tr>	  	  
    </table>
       <table width="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="30"><strong>3、教育培训背景(自高中开始填写)</strong></td>
          </tr>
          </table>
          
          <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#000000" id="jypx">
          <tr>
            <td   width="20%" height="30" align="center" class="myBorderBegin" bgcolor="#FFFFFF">起止时间</td>
            <td   width="35%" align="center" class="myBorderOther" bgcolor="#FFFFFF">院校名称</td>
            <td   width="30%" align="center" class="myBorderOther" bgcolor="#FFFFFF">专业</td>
            <td   width="10%" align="center" class="myBorderOther" bgcolor="#FFFFFF">学历</td>
            
           </tr>
            <c:if test="${not empty personEducationPos}">
            <c:forEach var="educations" items="${personEducationPos}">
	             <tr>
	             	<td   bgcolor="#FFFFFF" class="myBorderBegin1">
	             		<input name="personEducationPo.mpestartstoptime" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${educations.mpestartstoptime }"/>
	             	</td>
	             	<td   bgcolor="#FFFFFF" class="myBorderOther1">
	             		<input name="personEducationPo.mpeuniverstity" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${educations.mpeuniverstity }"/>
	             	</td>
	             	<td  bgcolor="#FFFFFF" class="myBorderOther1">
	             		<input name="personEducationPo.mpeprofessional" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${educations.mpeprofessional }"/>
	             	</td>
	             	<td  bgcolor="#FFFFFF" class="myBorderOther1">
	             		<input name="personEducationPo.mpeeducation" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${educations.mpeeducation }"/>
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
            <td   width="20%" height="30" align="center" class="myBorderBegin" bgcolor="#FFFFFF">起止时间</td>
            <td   width="35%" align="center" class="myBorderOther" bgcolor="#FFFFFF">单       位</td>
            <td   width="15%" align="center" class="myBorderOther" bgcolor="#FFFFFF">部     门</td>
            <td   width="20%" align="center" class="myBorderOther" bgcolor="#FFFFFF">岗位</td>
            <td   width="20%" align="center" class="myBorderOther" bgcolor="#FFFFFF">职务</td>
            
          </tr>
           <c:if test="${not empty personWorkPos}">
            <c:forEach var="works" items="${personWorkPos}">
	             <tr>
	             	<td  bgcolor="#FFFFFF" class="myBorderBegin1">
	             		<input name="personWorkPo.mpwstartstoptime" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${works.mpwstartstoptime }"/> 
	             	</td>
	             	<td  bgcolor="#FFFFFF" class="myBorderOther1">
	             		<input name="personWorkPo.mpwcompany" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${works.mpwcompany }"/>
	             	</td>
	             	<td  bgcolor="#FFFFFF" class="myBorderOther1">
	             		<input name="personWorkPo.mpwdepartment" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${works.mpwdepartment}"/>
	             	</td>
	             	<td  bgcolor="#FFFFFF" class="myBorderOther1">
	             		<input name="personWorkPo.mpwpost" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${works.mpwpost }"/>
	             	</td>
	             	<td  bgcolor="#FFFFFF" class="myBorderOther1">
	             		<input name="personWorkPo.mpwposition" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${works.mpwposition }"/>
	             	</td>
	             	
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
            <td   width="10%" height="30" align="center" class="myBorderBegin" bgcolor="#FFFFFF">与本人关系</td>
            <td   width="10%" align="center" class="myBorderOther" bgcolor="#FFFFFF">姓名</td>
            <td   width="35%" align="center" class="myBorderOther" bgcolor="#FFFFFF">居住地</td>
            <td   width="10%" align="center" class="myBorderOther" bgcolor="#FFFFFF">职业</td>
            <td   width="15%" align="center" class="myBorderOther" bgcolor="#FFFFFF">联系电话</td>
           
          </tr>
          <c:if test="${not empty personFamilyPos}">
            <c:forEach var="fams" items="${personFamilyPos}">
	             <tr>
	             	<td  bgcolor="#FFFFFF" class="myBorderBegin1" >
	             		<input name="personFamilyPo.mpfrelation" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${fams.mpfrelation }"/>
	             	</td>
	             	<td  bgcolor="#FFFFFF" class="myBorderOther1">
	             		<input name="personFamilyPo.mpfname" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${fams.mpfname }"/>
	             	</td>
	             	<td  bgcolor="#FFFFFF" class="myBorderOther1">
	             		<input name="personFamilyPo.mpfaddress" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${fams.mpfaddress}"/>
	             	</td>
	             	<td  bgcolor="#FFFFFF" class="myBorderOther1">
	             		<input name="personFamilyPo.mpfoccupation" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${fams.mpfoccupation }"/>
	             	</td>
	             	<td  bgcolor="#FFFFFF" class="myBorderOther1">
	             		<input name="personFamilyPo.mpfphone" style="text-align:center;width:100%;border:0px;" maxlength="20" value="${fams.mpfphone }"/>
	             	</td>
	             	
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
            <td width="35%" align="left" valign="middle" bgcolor="#FFFFFF">${emergencyContactPo.mecname}</td>
          <td width="15%" align="center" valign="middle" bgcolor="#FFFFFF">与本人关系</td>
            <td width="24%" align="left" valign="middle" bgcolor="#FFFFFF">${emergencyContactPo.mecrelation}</td>
        </tr>
          <tr>
            <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">工作单位</td>
            <td colspan="3" align="left" valign="middle" bgcolor="#FFFFFF">${emergencyContactPo.meccompanyname}</td>
            </tr>
          <tr>
            <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">单位地址</td>
            <td colspan="3" align="left" valign="middle" bgcolor="#FFFFFF">${emergencyContactPo.meccompanyaddress}</td>
            </tr>
          <tr>
            <td height="30" align="center" valign="middle" bgcolor="#FFFFFF">联系电话</td>
            <td colspan="3" align="left" valign="middle" bgcolor="#FFFFFF">${emergencyContactPo.mecphone}</td>
            </tr>
        </table>
        </TD>
  </TR>
 
 </TABLE>
</form>

    
    </BODY></html>

    
    

