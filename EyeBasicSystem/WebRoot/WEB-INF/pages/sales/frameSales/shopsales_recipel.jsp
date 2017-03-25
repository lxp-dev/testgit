<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>

<script language="javascript">

/*
 * 选中验光处方后，当前行变为红色
 */
function defineSalesRecipel(obj){
	$('tr[recipel=recipel]').bind("mouseover",function(){
		mover2($(this),'#a2c1eb');
	});
	$('tr[recipel=recipel]').bind("mouseout",function(){
		mout2($(this),'#cadee8');
	});
	$('tr[recipel=recipel]').attr('style','cursor:hand');
	
	$(obj).unbind();
	$(obj).attr('style','background-color:red');

}

function mover2(src,clrin){ 	
	$(src).attr('style','background-color:' + clrin);
}

function mout2(src,clrout)  { 
	$(src).attr('style','background-color:' + clrout);
}

</script>

<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 height="100%" class="table_none">
	<tr height="25" align="center" optometry=optometry>
		<td class="table_title" width="26%">
		   处方类型
		</td>
		<td class="table_title" width="25%">
		   验光师
		</td>
		<td class="table_title" width="49%">
		   验光时间
		</td>
	</tr>
	<c:if test="${empty(inspectionPos)}">
        <c:forEach begin="1" end="4" step="1" >
                <tr recipel=recipel height="26" align="center" class="row">
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>        
        </c:forEach>
    </c:if>
    
    <c:if test="${not empty(inspectionPos)}">
					            
	   <c:set value="0" var="currTrCount" />   <!-- 当前tr数 -->
				               
        <c:forEach var="po" items="${inspectionPos}">
            <tr recipel=recipel height="26" align="center" class="row" style="cursor: hand;" 
                onclick="window.parent.selectOptometryPerson('${po.sopipersonname }','${po.sopipusername}');window.parent.selGlassTime('${fn:substring(po.sopiptime, 0, 16)}');window.parent.printblRport('${po.sopipglasstype}','${po.sopipoptometryid}','${po.sopiponeormany }');window.parent.inspection({'sopipinspectionid':'${po.sopipid}','sopipcustomerid':'${po.sopipcustomerid}',
						'sopipoptometrybasicid':'${po.sopipoptometrybasicid}','sopipoptometryid':'${po.sopipoptometryid}','sopipersonname':'${po.sopipersonname }',
						'sopipglasstype':'${po.sopipglasstype}','sopipballglassod':'${po.sopipballglassod}',
						'sopipballglassos':'${po.sopipballglassos}','sopippostglassod':'${po.sopippostglassod}',
						'sopippostglassos':'${po.sopippostglassos}','sopipaxesod':'${po.sopipaxesod}',
						'sopipaxesos':'${po.sopipaxesos}','sopipaddod':'${po.sopipaddod}',
						'sopipaddos':'${po.sopipaddos}','sopiparriseglassod1':'${po.sopiparriseglassod1}',
						'sopiparriseglassos1':'${po.sopiparriseglassos1}','sopipbasisod1':'${po.sopipbasisod1}',
						'sopipbasisos1':'${po.sopipbasisos1}','sopipprismod':'${po.sopipprismod}',
						'sopipprismos':'${po.sopipprismos}','sopipinterhighod':'${po.sopipinterhighod}',
						'sopipinterhighos':'${po.sopipinterhighos}','sopipinterdistanceod':'${po.sopipinterdistanceod}',
						'sopipinterdistanceos':'${po.sopipinterdistanceos}','sopipfarvaod':'${po.sopipfarvaod}',
						'sopipfarvaos':'${po.sopipfarvaos}','sopipclosevaod':'${po.sopipclosevaod}',
						'sopipclosevaos':'${po.sopipclosevaos}','sopipeyecurvatureod1':'${po.sopipeyecurvatureod1}',
						'sopipeyecurvatureod2':'${po.sopipeyecurvatureod2}','sopipeyecurvatureos1':'${po.sopipeyecurvatureos1}',
						'sopipeyecurvatureos2':'${po.sopipeyecurvatureos2}','sopipdiameterod':'${po.sopipdiameterod}',
						'sopipdiameteros':'${po.sopipdiameteros}','sopipconlenvaod':'${po.sopipconlenvaod}',
						'sopipconlenvaos':'${po.sopipconlenvaos}',
						'sopipsuggestframe':'${po.sopipsuggestframe}','sopipframeheight':'${po.sopipframeheight}',
						'sopipglassmaterial':'${po.sopipglassmaterial}','sopiprecipetype':'${po.sopiprecipetype}',
						'sopipdisposemanner':'${po.sopipdisposemanner}','sopipdignosisre':'${po.sopipdignosisre}',
						'sopipconrecipetype':'${po.sopipconrecipetype}','sopipseccheckdate':'${po.sopipseccheckdate}',
						'sopipusername':'${po.sopipusername}','sopippupilheightod':'${po.sopippupilheightod}','sopippupilheightos':'${po.sopippupilheightos}',
						'sopipflag':'${po.sopipflag}','sopipconlenosnum':'${po.sopipconlenosnum}',
						'sopipconlenodnum':'${po.sopipconlenodnum}','sopipmiddledistance':'${po.sopipmiddledistance}',
						'sopipcommendcardwater':'${po.sopipcommendcardwater}','sopipeyecurvatureod1':'${po.sopipeyecurvatureod1}',
						'sopipeyecurvatureod2':'${po.sopipeyecurvatureod2}','sopipeyecurvatureos1':'${po.sopipeyecurvatureos1}',
						'sopipeyecurvatureos2':'${po.sopipeyecurvatureos2}','sopipconlenvaod':'${po.sopipconlenvaod}',
						'sopipconlenvaos':'${po.sopipconlenvaos}','sopipdiameterod':'${po.sopipdiameterod}',
						'sopipdiameteros':'${po.sopipdiameteros}',					
						'sopipcommendglassesos':'${po.sopipcommendglassesos}',
	                    'sopipcommendglassesod':'${po.sopipcommendglassesod}',	                    			
						'sopipconlenodnum':'${po.sopipconlenodnum}','sopipconlenosnum':'${po.sopipconlenosnum}',
						'sopipupkod':'${po.sopipupkod}',
						'sopipupkos':'${po.sopipupkos}',
						'sopipdownkod':'${po.sopipdownkod}',
						'sopipdownkos':'${po.sopipdownkos}',
						'sopipeod':'${po.sopipeod}',
						'sopipeos':'${po.sopipeos}',
						'sopipcornealdiameterod':'${po.sopipcornealdiameterod}',
						'sopipcornealdiameteros':'${po.sopipcornealdiameteros}',
						'sopipk0od':'${po.sopipk0od}',
						'sopipk0os':'${po.sopipk0os}',
						'sopipk1od':'${po.sopipk1od}',
						'sopipk1os':'${po.sopipk1os}',
						'sopipk2od':'${po.sopipk2od}',
						'sopipk2os':'${po.sopipk2os}',
						'sopipupcod':'${po.sopipupcod}',
						'sopipupcos':'${po.sopipupcos}',
						'sopipdowncod':'${po.sopipdowncod}',
						'sopipdowncos':'${po.sopipdowncos}',
						'sopiphlytype':'${po.sopiphlytype}',						
						'sopipfamilytrain':'${po.sopipfamilytrain}',
						'sopiptrainroom':'${po.sopiptrainroom}',																		
						'sopipconlenosnum':'${po.sopipconlenosnum}'},'${po.sopipglasstype}');$('#recipetype',parent.document).attr('disabled', true);$('#nwtype',parent.document).val('1');window.parent.lockOptometryPerson();window.parent.wlControl();window.parent.clearGoods();$('#opdate',parent.document).hide();window.parent.clearTC();window.parent.checkCylZero();defineSalesRecipel(this);"             
                >
				<td>
					<c:choose>
						<c:when test="${po.sopipglasstype == '1' }">远用</c:when>
						<c:when test="${po.sopipglasstype == '2' }">近用</c:when>
						<c:when test="${po.sopipglasstype == '3' }">双光/渐进</c:when>
						<c:when test="${po.sopipglasstype == '5' }">中用</c:when>
						<c:when test="${po.sopipglasstype == '4' }">隐形</c:when>
						<c:when test="${po.sopipglasstype == '6' }">角膜塑形</c:when>
						<c:when test="${po.sopipglasstype == '7' }">视觉训练</c:when>
					</c:choose>
				</td>
                <td>${po.sopipersonname }</td>
                <td>${fn:substring(po.sopiptime, 0, 16)} </td>
            </tr>
            <c:set value="${currTrCount + 1}" var="currTrCount" />
        </c:forEach>
        
        <c:if test="${currTrCount < 5}">
	        <c:forEach begin="${currTrCount}" end="4" step="1" >
	                <tr recipel=recipel height="26" align="center" class="row">
	                    <td>&nbsp;</td>
	                    <td>&nbsp;</td>
	                    <td>&nbsp;</td>
	                </tr>        
	        </c:forEach>
        </c:if> 
              
    </c:if>
	
</table>

<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
<table id="loadingBar" width="100%" STYLE="display:none">
  <tr><td height="10">&nbsp;</td></tr>
  <tr>                         
    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
	<script>
		function showLoadingBar(){
			document.getElementById("loadingBar").style.display="";
		}
	</script>                            
    </td>
</tr>
</table>                      
<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					
