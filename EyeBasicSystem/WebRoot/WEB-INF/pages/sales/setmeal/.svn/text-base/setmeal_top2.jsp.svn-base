<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>

<script type="text/javascript">
	
/**
 * 添加一行购买商品（消费商品）
 */	
function updateRow(json){
	
	var propertyCount = 0;
	
    if ($('#ssmsmclassify').val() == ''){
        alert("请先选择套餐分类!");
        return;
    }
    var table = document.getElementById('addTablebangding');
    if (document.getElementById('addTablesong2') == null){
    	index = accAdd(index,table.rows.length - 1);
    }else{
    	index = accAdd(document.getElementById('addTablesong2').rows.length - 1,accAdd(index,table.rows.length - 1));
    }
    
	var row = table.insertRow(table.rows.length);
	var c1 = row.insertCell(0);
	var c2 = row.insertCell(1);
	var c3 = row.insertCell(2);
	var c4 = row.insertCell(3);
	var c5 = row.insertCell(4);
	var c6 = row.insertCell(5);
	var c7 = row.insertCell(6);
	var c8 = row.insertCell(7);
	var c9 = row.insertCell(8);
	var c10 = row.insertCell(9);
	var c11 = row.insertCell(10);
							
	row.className = 'row';		
	c1.height="26";
	c1.innerHTML = '<input type="checkbox" id="chk1" name="chk1"/>';		

	var data = '<table border=\'0\' width=\'100%\'><tr><td width=\'20%\'>'
		
	var ssmsmclassify = $('#ssmsmclassify').val();
    if (ssmsmclassify == '1'){
    	data = data + '<li class="horizontal_onlyRight"><select style="width:100%" clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change3(this,'+index+')" xiaofei=xiaofei xf0="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'1\',\'6\')">'
    		             +'<option value="1_0"' + (json.ssmsggoodscategory == "1" ? "selected='selected'" : "") + '>镜架</option>'
  		                 +'<option value="3"' + ((json.ssmsggoodscategory == "3" && json.ssmsgiscustomize != "0" && json.ssmsgiscustomize != "D") ? "selected='selected'" : "") + '>镜片</option>'
  		                 +'<option value="3_0"' + ((json.ssmsggoodscategory == "3" && json.ssmsgiscustomize == "0") ? "selected='selected'" : "") + '>成品片</option>'
  		                 +'<option value="3_D"' + ((json.ssmsggoodscategory == "3" && json.ssmsgiscustomize == "D") ? "selected='selected'" : "") + '>订做片</option>'
  		                 +'<option value="6_6"' + (json.ssmsggoodscategory == "6" ? "selected='selected'" : "") + '>太阳镜</option>'
  		                 +'<option value="6_8"' + (json.ssmsggoodscategory == "8" ? "selected='selected'" : "") + '>老花镜</option>'
  		                 +'<option value="7_0"' + (json.ssmsggoodscategory == "7" ? "selected='selected'" : "") + '>耗材</option>'
  		                 +'<option value="9_0"' + (json.ssmsggoodscategory == "9" ? "selected='selected'" : "") + '>视光</option>'
  		                 +'<option value="5_0"' + (json.ssmsggoodscategory == "5" ? "selected='selected'" : "") + '>隐形护理液</option>'
  		                 +'<option value="2_0"' + (json.ssmsggoodscategory == "2" ? "selected='selected'" : "") + '>配件</option>'
  	                     + '</select></li></td><td colspan=\'3\'>'	
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID301'+index+'"><select clean=clean id="goodscategoryID301'+index+'" name="goodscategoryID301" onchange="change31(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
  		                 +'<option value="">----请选择----</option>'
                         +'<option value="1">材料分类</option>'
                  		 +'<option value="2">折射率</option>'     
  		                 +'<option value="3">光度分类</option>' 	
  		                 +'<option value="4">镜片功能</option>'
  		                 +'<option value="5">球镜区间</option>'
  		                 +'<option value="6">柱镜区间</option>'			            
  	                     +'</select></li>'	   
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID302'+index+'"><select clean=clean id="goodscategoryID302'+index+'" name="goodscategoryID302" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  	                     +'<option value="">----请选择----</option>'
                         +'<option value="1">树脂</option>'
                  		 +'<option value="2">玻璃</option>'     
  		                 +'<option value="3">PC</option>' 			            
  	                     +'</select></li>'	      
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID303'+index+'"><select clean=clean id="goodscategoryID303'+index+'" name="goodscategoryID303" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  	                      +'<option value="">----请选择----</option>'
                         +'<s:iterator value="refractiveSetList">'
                         +'<option value="${brfname}">${brfname}</option>'
                         +'</s:iterator>'                      			            
  	                     +'</select></li>'	   
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID304'+index+'"><select clean=clean id="goodscategoryID304'+index+'" name="goodscategoryID304" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  	                     +'<option value="">----请选择----</option>'
                         +'<option value="0">单光</option>'
                  		 +'<option value="m">多光</option>'     
  		                 +'<option value="j_1">青少年渐进</option>'
                  		 +'<option value="j_2">成人渐进</option>' 
  		                 +'<option value="k">抗疲劳</option>' 	
  		                 +'<option value="q">其他</option>' 			            
  	                     +'</select></li>'	   
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID305'+index+'"><select clean=clean id="goodscategoryID305'+index+'" name="goodscategoryID305" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  	                     +'<option value="">----请选择----</option>'
                         +'<option value="1">白色片</option>'
                  		 +'<option value="2">变色片</option>'     
  		                 +'<option value="3">偏光片</option>'
  		                 +'<option value="4">变色偏光片</option>' 	
  		                 +'<option value="5">染色片</option>' 	
  		                 +'<option value="6">抗疲劳片</option>'
  		                 +'<option value="7">抗疲劳变色片</option>' 
  		                 +'<option value="8">偏光抗疲劳片</option>' 		  			            
  	                     + '</select></li>'
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
  		                 +'<option value="">----请选择----</option>'
                         +'<option value="1">材质</option>'	            
  	                     +'</select></li>'	        	     
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  	                     +'<option value="">----请选择----</option>'
                         +'<s:iterator value="frameMateriallist">'
                         +'<option value="${bfmid}">${bfmname}</option>'
                         +'</s:iterator>'
  	                     +'</select></li>'

  	               	   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID310'+index+'"><select clean=clean id="goodscategoryID312'+index+'" name="goodscategoryID312" onchange="change51(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
		                 +'<option value="">----请选择----</option>'
                         +'<option value="1">功能</option>'	            
	                     +'</select></li>'	        	     
	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID311'+index+'"><select clean=clean id="goodscategoryID313'+index+'" name="goodscategoryID313" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
			             +'<option value="">----请选择----</option>'
			             +'<option value="2">偏光</option>'
			             +'<option value="1">遮阳</option>'	            
			             +'</select></li>'	
		           
    	               data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID308'+index+'"><input class="text_input60" style="width:50" maxlength="20" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID308'+index+'" name="goodscategoryID308" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'61\',\'\')" onblur="checkData(this)">至<input maxlength="20" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" onblur="checkData(this)" clean=clean id="goodscategoryID309'+index+'" name="goodscategoryID309" xf61="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
                           +'</li>'	  

        	           data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID309'+index+'"><input class="text_input60" style="width:50" maxlength="20" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID310'+index+'" name="goodscategoryID310" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'61\',\'\')" onblur="checkDataz(this)">至<input maxlength="20" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID311'+index+'" name="goodscategoryID311" xf61="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')" onblur="checkDataz(this)">'
                           +'</li>'	         	          	                     
    }

    if (ssmsmclassify == '3'){
    	data = data + '<li class="horizontal_onlyRight"><select style="width:100%" clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change4(this,'+index+')" xiaofei=xiaofei xf0="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'1\',\'6\')">'       
             			 +'<option value="4"' + ((json.ssmsggoodscategory == "4" && json.ssmsgiscustomize != "0" && json.ssmsgiscustomize != "D") ? "selected='selected'" : "") + '>隐形镜片</option>'
                         +'<option value="4_0"' + ((json.ssmsggoodscategory == "4" && json.ssmsgiscustomize == "0") ? "selected='selected'" : "") + '>隐形成品片</option>'
  		                 +'<option value="4_D"' + ((json.ssmsggoodscategory == "4" && json.ssmsgiscustomize == "D") ? "selected='selected'" : "") + '>隐形订做片</option>'
  		                 +'<option value="5_0"' + (json.ssmsggoodscategory == "5" ? "selected='selected'" : "") + '>隐形护理液</option>'
  		                 +'<option value="6_6"' + (json.ssmsggoodscategory == "6" ? "selected='selected'" : "") + '>太阳镜</option>'
  		                 +'<option value="6_8"' + (json.ssmsggoodscategory == "8" ? "selected='selected'" : "") + '>老花镜</option>'
  		                 +'<option value="1_0"' + (json.ssmsggoodscategory == "1" ? "selected='selected'" : "") + '>镜架</option>'
  		                 +'<option value="7_0"' + (json.ssmsggoodscategory == "7" ? "selected='selected'" : "") + '>耗材</option>'
  		                 +'<option value="9_0"' + (json.ssmsggoodscategory == "9" ? "selected='selected'" : "") + '>视光</option>'
  		                 +'<option value="2_0"' + (json.ssmsggoodscategory == "2" ? "selected='selected'" : "") + '>配件</option>'
  	                     +'</select></li></td><td colspan=\'3\'>'
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID401'+index+'"><select clean=clean id="goodscategoryID401'+index+'" name="goodscategoryID401" onchange="change41(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'       
  		                 +'<option value="">----请选择----</option>'
  		                 +'<option value="1">使用类型</option>'
  		                 +'<option value="2">抛弃型分类</option>'
  		                 +'<option value="5">球镜区间</option>'
  		                 +'<option value="6">柱镜区间</option>'
  	                     +'</select></li>'	         
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID402'+index+'"><select clean=clean id="goodscategoryID402'+index+'" name="goodscategoryID402" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'       
  	                     +'<option value="">----请选择----</option>'
		                 +'<option value="1">常带型</option>'
  		                 +'<option value="2">抛弃型</option>'
  		               +'<option value="3">塑形镜</option>'
  	                     +'</select></li>'	
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID403'+index+'"><select clean=clean id="goodscategoryID403'+index+'" name="goodscategoryID403" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'       
  	                     +'<option value="">----请选择----</option>'
		                 +'<option value="1">日抛</option>'
  		                 +'<option value="2">周抛</option>'
  		                 +'<option value="9">双周抛</option>'
  		                 +'<option value="3">月抛</option>'
  		                 +'<option value="4">季抛</option>'
  		                 +'<option value="5">半年抛</option>'
  		                 +'<option value="6">年抛</option>'
  		                 +'<option value="7">RGP</option>'      		                 
  	                     +'</select></li>'   

  	               	   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
	                     +'<option value="">----请选择----</option>'
                         +'<option value="1">材质</option>'	            
                         +'</select></li>'	        	     
					   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
			             +'<option value="">----请选择----</option>'
			             +'<s:iterator value="frameMateriallist">'
			             +'<option value="${bfmid}">${bfmname}</option>'
			             +'</s:iterator>'
                         +'</select></li>'	
                       data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID310'+index+'"><select clean=clean id="goodscategoryID312'+index+'" name="goodscategoryID312" onchange="change51(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
		                 +'<option value="">----请选择----</option>'
                         +'<option value="1">功能</option>'	            
	                     +'</select></li>'	        	     
	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID311'+index+'"><select clean=clean id="goodscategoryID313'+index+'" name="goodscategoryID313" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
			             +'<option value="">----请选择----</option>'
			             +'<option value="2">偏光</option>'
			             +'<option value="1">遮阳</option>'	            
			             +'</select></li>'
		           
      	               data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID408'+index+'"><input class="text_input60" style="width:50" maxlength="20" id="ssmsgsphul'+index+'" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID408'+index+'" name="goodscategoryID408" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'61\',\'\')" onblur="checkData(this)">至<input maxlength="20" id="ssmsgsphup'+index+'" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" onblur="checkData(this)" clean=clean id="goodscategoryID409'+index+'" name="goodscategoryID409" xf61="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
                       +'</li>'	  

    	               data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID409'+index+'"><input class="text_input60" style="width:50" maxlength="20" id="ssmsgcylul'+index+'" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID410'+index+'" name="goodscategoryID410"  xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'61\',\'\')" onblur="checkDataz(this)">至<input maxlength="20" id="ssmsgcylup'+index+'" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID411'+index+'" name="goodscategoryID411" xf61="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')" onblur="checkDataz(this)">'
                       +'</li>'	               	         
    }
    if (ssmsmclassify == '5'){
    	data = data + '<li class="horizontal_onlyRight"><select style="width:100%" clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" xiaofei=xiaofei xf0="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')" onchange="change5(this,'+index+')">'
  		                 +'<option value="6_6"' + (json.ssmsggoodscategory == "6" ? "selected='selected'" : "") + '>太阳镜</option>'
  		                 +'<option value="6_8"' + (json.ssmsggoodscategory == "8" ? "selected='selected'" : "") + '>老花镜</option>'
  		                 +'<option value="1_0"' + (json.ssmsggoodscategory == "1" ? "selected='selected'" : "") + '>镜架</option>'
  		                 +'<option value="7_0"' + (json.ssmsggoodscategory == "7" ? "selected='selected'" : "") + '>耗材</option>'
  		                 +'<option value="9_0"' + (json.ssmsggoodscategory == "9" ? "selected='selected'" : "") + '>视光</option>'
  		                 +'<option value="5_0"' + (json.ssmsggoodscategory == "5" ? "selected='selected'" : "") + '>隐形护理液</option>'
  		                 +'<option value="2_0"' + (json.ssmsggoodscategory == "2" ? "selected='selected'" : "") + '>配件</option>'
  		                 +'</select></li></td><td colspan=\'3\'>'	

    	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
    		                 +'<option value="">----请选择----</option>'
                           +'<option value="1">材质</option>'	            
    	                     +'</select></li>'	        	     
    	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
    	             +'<option value="">----请选择----</option>'
                     +'<s:iterator value="frameMateriallist">'
                     +'<option value="${bfmid}">${bfmname}</option>'
                     +'</s:iterator>'
    	                     +'</select></li>'	
    	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID310'+index+'"><select clean=clean id="goodscategoryID312'+index+'" name="goodscategoryID312" onchange="change51(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
      		                 +'<option value="">----请选择----</option>'
                             +'<option value="1">功能</option>'	            
      	                     +'</select></li>'	        	     
      	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID311'+index+'"><select clean=clean id="goodscategoryID313'+index+'" name="goodscategoryID313" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
   			           +'<option value="">----请选择----</option>'
   			           +'<option value="2">偏光</option>'
   			           +'<option value="1">遮阳</option>'	            
   			           +'</select></li>'	                        
    }

    data = data + '<img id="propertyImg'+index+'" src="${ctx }/img/newbtn/audit_0.png" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_0.png\');" btn=btn title=\"选择\" onclick="addGoodsProperty(this,'+index+');" style="cursor: hand;"/>'
    
    data = data +'<input id="goodsName'+index+'" name="salesGoodsArray.ssmsggoodsname" value="' + json.ssmsggoodsname + '" class="text_input120" type="text" readonly="readonly"><img src="${ctx }/img/newbtn/audit_0.png" title="选择" onclick="openGoods('+index+');" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_0.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_0.png\');" style="cursor: hand;">'
                   +'<input id="supplier'+index+'" class="text_input60" name="salesGoodsArray.ssmsgsupplier" value="' + json.ssmsgsupplier + '" type="hidden"><input id="brand'+index+'" class="text_input60" name="salesGoodsArray.ssmsgbrand" value="' + json.ssmsgbrand + '" type="hidden"><input id="iscustomize'+index+'" name="salesGoodsArray.ssmsgiscustomize" value="' + json.ssmsgiscustomize + '" class="text_input60" type="hidden"><input id="goods'+index+'" name="salesGoodsArray.ssmsggoodsid" value="' + json.ssmsggoodsid + '" class="text_input60" type="hidden">'
                   +'<input id="goodscategory2id'+index+'" name="salesGoodsArray.ssmsggoodscategory" value="' + json.ssmsggoodscategory + '" class="text_input60" type="hidden"><input id="ssmsgoodsclass'+index+'" name="salesGoodsArray.ssmsgoodsclass" value="' + json.ssmsggoodsclass + '" class="text_input60" type="hidden"><input id="minCostPrice'+index+'" class="text_input60" type="hidden"><input id="maxCostPrice'+index+'" class="text_input60" type="hidden"><input id="bigClass'+index+'" name="salesGoodsArray.ssmsgbigclass" value="' + json.ssmsgbigclass + '" class="text_input60" type="hidden"><input id="smallClass'+index+'" name="salesGoodsArray.ssmsgsmallclass" value="' + json.ssmsgsmallclass + '" class="text_input60" type="hidden">'

    data = data + '</td></tr><tr hide=hide id="hide'+index+'"><td>&nbsp;</td><td width=\'20%\'>'                   
                   +'<select multiple="multiple" class="text_input200 gbc" style="height:100px;width:250px" name="goodspropertyarray" id="goodspropertyarray'+index+'" onclick="changePropertyValue(this,'+index+');">'
                   +'<optgroup label="(按住ctrl键,可同时选中多项)">'

                   if (json.ssmsgbigclass.indexOf(',') > 0){
                	   var perprotyValueArray = json.ssmsgbigclass.split(',');
                	   var perprotyTextArray = json.ssmsgsmallclass.split(',');

                       if (perprotyValueArray.length > 0){
                    	   propertyCount = 1;
                       }
                	   
                	   for (var i = 0; i < perprotyValueArray.length; i++){
                		   data = data + '<option value="'+ perprotyValueArray[i] +'" parentID="'+perprotyValueArray[i].split(';')[0]+'">'+ perprotyTextArray[i] +'</option>'                		   
                       }
                   }else{

                       if ($.trim(json.ssmsgbigclass) != ''){
                    	   data = data + '<option value="'+ json.ssmsgbigclass +'" parentID="'+json.ssmsgbigclass.split(';')[0]+'">'+ json.ssmsgsmallclass +'</option>'
                    	   propertyCount = 1
                       }
                	   
                   }
                                     
    data = data +'</optgroup></select>'   
    data = data + '</td><td width=\'20%\'><img src="${ctx }/img/newbtn/delete_0.png" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_0.png\');" btn=btn title=\'删除\' onclick="removeOption(this,'+index+');" style="cursor: hand;" idx="'+index+'"/></td></tr></table>'      
                +'<input type="hidden" id="ssmspropertyvaluearray'+index+'" name="salesGoodsArray.ssmspropertyvaluearray" readonly="readonly" value="' + json.ssmsgbigclass + '"><input type="hidden" id="ssmsgoodspropertyarray'+index+'" name="salesGoodsArray.ssmsgoodspropertyarray" readonly="readonly" value="' + json.ssmsgsmallclass + '">';
 
    c2.innerHTML = data;
    
    c3.innerHTML = '<span id="spanminCostPriceAmount'+index+'">' + json.ssmsgmincostPrice + '</span><input class="text_input60 noneInput" id="minCostPriceAmount'+index+'" value="' + json.ssmsgmincostPrice + '" type="hidden" name="salesGoodsArray.ssmsgmincostPrice" readonly="readonly">至<span id="spanmaxCostPriceAmount'+index+'">' + json.ssmsgmaxcostPrice + '</span><input id="maxCostPriceAmount'+index+'" value="' + json.ssmsgmaxcostPrice + '" class="text_input60 noneInput" type="hidden" readonly="readonly" name="salesGoodsArray.ssmsgmaxcostPrice">';
    c4.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" value="' + json.ssmsgbeginAmount + '" id="ssmsgbeginAmount'+index+'" type="text" name="salesGoodsArray.ssmsgbeginAmount" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.UFloatORNULL, \'Message\' : \'套餐价格区间填写有误,请重新填写!\'}]" onblur="validationGoodsCostPriceMin(this,'+index+');" xf6="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'7\',\'\')">至<input maxlength="15" id="ssmsgendAmount'+index+'" class="text_input60" style="width:50" type="text" name="salesGoodsArray.ssmsgendAmount" value="' + json.ssmsgendAmount + '" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.UFloatORNULL, \'Message\' : \'套餐价格区间填写有误,请重新填写!\'}]" onblur="validationGoodsCostPriceMax(this,'+index+');" xf7="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'8\',\'\')">';
	c5.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" value="' + json.ssmsggoodsquantity + '" id="goodsquantity'+index+'" type="text" name="salesGoodsArray.ssmsggoodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'商品数量填写有误,请重新填写!\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number($.trim(this.value) == \'\' ? 1 : this.value).toFixed(0);}else{this.value = \'1\';}getSetMealAmount3(this);computeUnitCost('+index+',\'3\');" value="1" xf8="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'9\',\'\')">';

	c6.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="ssmsgexpensespendup'+index+'" type="text" name="salesGoodsArray.ssmsgexpensespendup" value="' + json.ssmsgexpensespendup + '" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.UFloatORNULL, \'Message\' : \'消费满金额区间填写有误,请重新填写!\'}]" xf9="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'10\',\'\')" onblur="amoumtAddZero(this)">至<input class="text_input60" style="width:50" maxlength="15" id="ssmsgexpensespendul'+index+'" type="text" name="salesGoodsArray.ssmsgexpensespendul" value="' + json.ssmsgexpensespendul + '" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.UFloatORNULL, \'Message\' : \'消费满金额区间填写有误,请重新填写!\'}]" xf10="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'11\',\'\')" onblur="amoumtAddZero(this)">';

	c7.innerHTML = '<table id="hideHeight'+index+'" border=\'0\' width=\'100%\' height=\'43%\'><tr><td>&nbsp;</td></tr></table><select clean=clean id="ssmsgfavorableflag'+index+'" name="salesGoodsArray.ssmsgfavorableflag" onchange="salesGoodsFavorableflagForm(this);this.blur();">'
			          +'<option value="1" ' + (json.ssmsgfavorableflag == "1" ? "selected='selected'" : "") + '>原价</option>'
			          +'<option value="2" ' + (json.ssmsgfavorableflag == "2" ? "selected='selected'" : "") + '>打折</option>'
			          +'<option value="3" ' + (json.ssmsgfavorableflag == "3" ? "selected='selected'" : "") + '>返现</option>'
			          +'<option value="4" ' + (json.ssmsgfavorableflag == "4" ? "selected='selected'" : "") + '>特价</option>'
			          +'</select>';
	
	c8.innerHTML = '<input class="text_input60 inInput readyonlyInput" noValidate="noValidate" readonly="readonly" style="width:50" maxlength="10" value="' + json.ssmsgretailPrice + '" id="ssmsgretailPrice'+index+'" type="text" name="salesGoodsArray.ssmsgretailPrice" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写套餐单价!\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'填写的零售价不正确！\'}]" onblur="getSetMealAmount(this)" xf11="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'12\',\'\')" onblur="amoumtAddZero(this)">';
	c9.innerHTML = '<input ' + (json.ssmsgfavorableflag == '4' ? "class='text_input60'" : "class='text_input60 inInput readyonlyInput' readonly='readonly' noValidate='noValidate' ") + ' style="width:50" maxlength="10" value="' + json.ssmsgspecialoffer + '" id="specialoffer'+index+'" type="text" name="salesGoodsArray.ssmsgspecialoffer" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写特价金额！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'特价金额填写有误,请重新填写!\'}]" xf12="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'13\',\'\')" onblur="amoumtAddZero(this);computeUnitCost('+index+',\'1\');">';
    
    c10.innerHTML = '<input ' + (json.ssmsgfavorableflag == '3' ? "class='text_input60'" : "class='text_input60 inInput readyonlyInput' readonly='readonly' noValidate='noValidate' ") + ' style="width:50" maxlength="10" value="' + json.ssmsgexpensecredit + '" id="ssmsgexpensecredit'+index+'" type="text" name="salesGoodsArray.ssmsgexpensecredit" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写优惠金额！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'优惠金额填写有误,请重新填写!\'}]"  xf13="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'14\',\'\')" onblur="amoumtAddZero(this);computeUnitCost('+index+',\'2\');">';

    c11.innerHTML = '<input ' + (json.ssmsgfavorableflag == '2' ? "class='text_input60'" : "class='text_input60 inInput readyonlyInput' readonly='readonly' noValidate='noValidate' ") + ' style="width:50" maxlength="10" value="' + json.ssmsgdiscountrate + '" id="ssmsgdiscountrate'+index+'" type="text" name="salesGoodsArray.ssmsgdiscountrate" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写优惠折扣！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UDiscount, \'Message\' : \'优惠折扣填写有误,请重新填写!\'}]" xf14="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'15\',\'0\')">';
    
	if (ssmsmclassify == '5'){
		 $('#goodscategoryID301'+index).hide();
	     $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();
         $('#goodscategoryID306'+index).hide();
            
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).hide();
         $('#goodscategoryID309'+index).hide();
         $('#goodscategoryID310'+index).hide();
         $('#goodscategoryID311'+index).hide();
         $('#goodscategoryID312'+index).hide();
         
         $('#goodscategoryID313'+index).hide();         
         $('#ligoodscategoryID301'+index).hide();
	     $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();
         $('#ligoodscategoryID306'+index).show();
           
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide();
         $('#ligoodscategoryID310'+index).show();      
         $('#ligoodscategoryID311'+index).hide();       

         change5_son(document.getElementById('goodscategoryID'+index),index);
	}
	if (ssmsmclassify == '3'){
	     $('#goodscategoryID402'+index).hide();
         $('#goodscategoryID403'+index).hide();
	     $('#goodscategoryID408'+index).hide();
         $('#goodscategoryID409'+index).hide();
	     $('#goodscategoryID410'+index).hide();
         $('#goodscategoryID411'+index).hide();
         $('#goodscategoryID306'+index).hide();
         $('#goodscategoryID307'+index).hide();        
         $('#goodscategoryID312'+index).hide();
         $('#goodscategoryID313'+index).hide();
         
	     $('#ligoodscategoryID402'+index).hide();
         $('#ligoodscategoryID403'+index).hide();
	     $('#ligoodscategoryID408'+index).hide();
         $('#ligoodscategoryID409'+index).hide();
         $('#ligoodscategoryID306'+index).hide();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID310'+index).hide();
         $('#ligoodscategoryID311'+index).hide();

         change4_son(document.getElementById('goodscategoryID'+index),index);
	}
	if (ssmsmclassify == '1'){
	     $('#goodscategoryID301'+index).hide();
	     $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();             
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).hide();
         $('#goodscategoryID309'+index).hide();
         $('#goodscategoryID310'+index).hide();
         $('#goodscategoryID311'+index).hide();
         $('#goodscategoryID312'+index).hide();
         $('#goodscategoryID313'+index).hide();

	     $('#ligoodscategoryID301'+index).hide();
	     $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();             
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide();
         $('#ligoodscategoryID310'+index).hide();
         $('#ligoodscategoryID311'+index).hide();

         change3_son(document.getElementById('goodscategoryID'+index),index);
	}

	$('#propertyImg'+index).hide();

	if (propertyCount == 0){
		$('tr[id=hide'+index+']').hide();
		$('table[id="hideHeight'+index+'"]').hide();
	}
    
}

/**
 * 添加一行购买商品（消费商品）
 */	
function updateRow3(json){
	
	var propertyCount = 0;
	
    if ($('#ssmsmclassify').val() == ''){
        alert("请先选择套餐分类!");
        return;
    }
    var table = document.getElementById('addTablebangding');
    if (document.getElementById('addTablesong2') == null){
    	index = accAdd(index,table.rows.length - 1);
    }else{
    	index = accAdd(document.getElementById('addTablesong2').rows.length - 1,accAdd(index,table.rows.length - 1));
    }
    
	var row = table.insertRow(table.rows.length);
	var c1 = row.insertCell(0);
	var c2 = row.insertCell(1);
	var c3 = row.insertCell(2);
	var c4 = row.insertCell(3);
	var c5 = row.insertCell(4);
	var c6 = row.insertCell(5);
							
	row.className = 'row';		
	c1.height="26";
	c1.innerHTML = '<input type="checkbox" id="chk1" name="chk1"/>';		

	var data = '<table border=\'0\' width=\'100%\'><tr><td width=\'20%\'>'
		
	var ssmsmclassify = $('#ssmsmclassify').val();
    if (ssmsmclassify == '1'){
    	data = data + '<li class="horizontal_onlyRight"><select style="width:100%" clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change3(this,'+index+')" xiaofei=xiaofei xf0="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'1\',\'6\')">'
    		             +'<option value="1_0"' + (json.ssmsggoodscategory == "1" ? "selected='selected'" : "") + '>镜架</option>'
  		                 +'<option value="3"' + ((json.ssmsggoodscategory == "3" && json.ssmsgiscustomize != "0" && json.ssmsgiscustomize != "D") ? "selected='selected'" : "") + '>镜片</option>'
  		                 +'<option value="3_0"' + ((json.ssmsggoodscategory == "3" && json.ssmsgiscustomize == "0") ? "selected='selected'" : "") + '>成品片</option>'
  		                 +'<option value="3_D"' + ((json.ssmsggoodscategory == "3" && json.ssmsgiscustomize == "D") ? "selected='selected'" : "") + '>订做片</option>'
  		                 +'<option value="6_6"' + (json.ssmsggoodscategory == "6" ? "selected='selected'" : "") + '>太阳镜</option>'
  		                 +'<option value="6_8"' + (json.ssmsggoodscategory == "8" ? "selected='selected'" : "") + '>老花镜</option>'
  		                 +'<option value="7_0"' + (json.ssmsggoodscategory == "7" ? "selected='selected'" : "") + '>耗材</option>'
  		                 +'<option value="9_0"' + (json.ssmsggoodscategory == "9" ? "selected='selected'" : "") + '>视光</option>'
  		                 +'<option value="5_0"' + (json.ssmsggoodscategory == "5" ? "selected='selected'" : "") + '>隐形护理液</option>'
  		                 +'<option value="2_0"' + (json.ssmsggoodscategory == "2" ? "selected='selected'" : "") + '>配件</option>'
  	                     + '</select></li></td><td colspan=\'3\'>'	
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID301'+index+'"><select clean=clean id="goodscategoryID301'+index+'" name="goodscategoryID301" onchange="change31(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
  		                 +'<option value="">----请选择----</option>'
                         +'<option value="1">材料分类</option>'
                  		 +'<option value="2">折射率</option>'     
  		                 +'<option value="3">光度分类</option>' 	
  		                 +'<option value="4">镜片功能</option>'
  		                 +'<option value="5">球镜区间</option>'
  		                 +'<option value="6">柱镜区间</option>'			            
  	                     +'</select></li>'	   
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID302'+index+'"><select clean=clean id="goodscategoryID302'+index+'" name="goodscategoryID302" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  	                     +'<option value="">----请选择----</option>'
                         +'<option value="1">树脂</option>'
                  		 +'<option value="2">玻璃</option>'     
  		                 +'<option value="3">PC</option>' 			            
  	                     +'</select></li>'	      
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID303'+index+'"><select clean=clean id="goodscategoryID303'+index+'" name="goodscategoryID303" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  	                      +'<option value="">----请选择----</option>'
                         +'<s:iterator value="refractiveSetList">'
                         +'<option value="${brfname}">${brfname}</option>'
                         +'</s:iterator>'                      			            
  	                     +'</select></li>'	   
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID304'+index+'"><select clean=clean id="goodscategoryID304'+index+'" name="goodscategoryID304" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  	                     +'<option value="">----请选择----</option>'
                         +'<option value="0">单光</option>'
                  		 +'<option value="m">多光</option>'     
  		                 +'<option value="j_1">青少年渐进</option>'
                  		 +'<option value="j_2">成人渐进</option>' 
  		                 +'<option value="k">抗疲劳</option>' 	
  		                 +'<option value="q">其他</option>' 			            
  	                     +'</select></li>'	   
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID305'+index+'"><select clean=clean id="goodscategoryID305'+index+'" name="goodscategoryID305" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  	                     +'<option value="">----请选择----</option>'
                         +'<option value="1">白色片</option>'
                  		 +'<option value="2">变色片</option>'     
  		                 +'<option value="3">偏光片</option>'
  		                 +'<option value="4">变色偏光片</option>' 	
  		                 +'<option value="5">染色片</option>' 	
  		                 +'<option value="6">抗疲劳片</option>' 
  		                 +'<option value="7">抗疲劳变色片</option>'
  		                 +'<option value="8">偏光抗疲劳片</option>' 		  			            
  	                     + '</select></li>'
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
  		                 +'<option value="">----请选择----</option>'
                         +'<option value="1">材质</option>'	            
  	                     +'</select></li>'	        	     
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
		  	               +'<option value="">----请选择----</option>'
		                   +'<s:iterator value="frameMateriallist">'
		                   +'<option value="${bfmid}">${bfmname}</option>'
		                   +'</s:iterator>'
		  	                     +'</select></li>'

  	               	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID310'+index+'"><select clean=clean id="goodscategoryID312'+index+'" name="goodscategoryID312" onchange="change51(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
		                 +'<option value="">----请选择----</option>'
                         +'<option value="1">功能</option>'	            
	                     +'</select></li>'	        	     
	                data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID311'+index+'"><select clean=clean id="goodscategoryID313'+index+'" name="goodscategoryID313" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
			           +'<option value="">----请选择----</option>'
			           +'<option value="2">偏光</option>'
			           +'<option value="1">遮阳</option>'	            
			           +'</select></li>'	
		           
    	               data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID308'+index+'"><input class="text_input60" style="width:50" maxlength="20" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID308'+index+'" name="goodscategoryID308" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'61\',\'\')" onblur="checkData(this)">至<input maxlength="20" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" onblur="checkData(this)" clean=clean id="goodscategoryID309'+index+'" name="goodscategoryID309" xf61="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
                           +'</li>'	  

        	           data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID309'+index+'"><input class="text_input60" style="width:50" maxlength="20" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID310'+index+'" name="goodscategoryID310" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'61\',\'\')" onblur="checkDataz(this)">至<input maxlength="20" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID311'+index+'" name="goodscategoryID311" xf61="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')" onblur="checkDataz(this)">'
                           +'</li>'	         	          	                     
    }

    if (ssmsmclassify == '3'){
    	data = data + '<li class="horizontal_onlyRight"><select style="width:100%" clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change4(this,'+index+')" xiaofei=xiaofei xf0="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'1\',\'6\')">'       
             			 +'<option value="4"' + ((json.ssmsggoodscategory == "4" && json.ssmsgiscustomize != "0" && json.ssmsgiscustomize != "D") ? "selected='selected'" : "") + '>隐形镜片</option>'
                         +'<option value="4_0"' + ((json.ssmsggoodscategory == "4" && json.ssmsgiscustomize == "0") ? "selected='selected'" : "") + '>隐形成品片</option>'
  		                 +'<option value="4_D"' + ((json.ssmsggoodscategory == "4" && json.ssmsgiscustomize == "D") ? "selected='selected'" : "") + '>隐形订做片</option>'
  		                 +'<option value="5_0"' + (json.ssmsggoodscategory == "5" ? "selected='selected'" : "") + '>隐形护理液</option>'
  		                 +'<option value="6_6"' + (json.ssmsggoodscategory == "6" ? "selected='selected'" : "") + '>太阳镜</option>'
  		                 +'<option value="6_8"' + (json.ssmsggoodscategory == "8" ? "selected='selected'" : "") + '>老花镜</option>'
  		                 +'<option value="1_0"' + (json.ssmsggoodscategory == "1" ? "selected='selected'" : "") + '>镜架</option>'
  		                 +'<option value="7_0"' + (json.ssmsggoodscategory == "7" ? "selected='selected'" : "") + '>耗材</option>'
  		                 +'<option value="9_0"' + (json.ssmsggoodscategory == "9" ? "selected='selected'" : "") + '>视光</option>'
  		                 +'<option value="2_0"' + (json.ssmsggoodscategory == "2" ? "selected='selected'" : "") + '>配件</option>'
  	                     +'</select></li></td><td colspan=\'3\'>'
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID401'+index+'"><select clean=clean id="goodscategoryID401'+index+'" name="goodscategoryID401" onchange="change41(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'       
  		                 +'<option value="">----请选择----</option>'
  		                 +'<option value="1">使用类型</option>'
  		                 +'<option value="2">抛弃型分类</option>'
  		                 +'<option value="5">球镜区间</option>'
  		                 +'<option value="6">柱镜区间</option>'
  	                     +'</select></li>'	         
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID402'+index+'"><select clean=clean id="goodscategoryID402'+index+'" name="goodscategoryID402" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'       
  	                     +'<option value="">----请选择----</option>'
		                 +'<option value="1">常带型</option>'
  		                 +'<option value="2">抛弃型</option>'
  		               +'<option value="3">塑形镜</option>'
  	                     +'</select></li>'	
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID403'+index+'"><select clean=clean id="goodscategoryID403'+index+'" name="goodscategoryID403" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'       
  	                     +'<option value="">----请选择----</option>'
		                 +'<option value="1">日抛</option>'
  		                 +'<option value="2">周抛</option>'
  		                 +'<option value="9">双周抛</option>'
  		                 +'<option value="3">月抛</option>'
  		                 +'<option value="4">季抛</option>'
  		                 +'<option value="5">半年抛</option>'
  		                 +'<option value="6">年抛</option>'
  		                 +'<option value="7">RGP</option>'      		                 
  	                     +'</select></li>'   

  	               	   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
						 +'<option value="">----请选择----</option>'
					     +'<option value="1">材质</option>'	            
					     +'</select></li>'	        	     
					   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
					     +'<option value="">----请选择----</option>'
					     +'<s:iterator value="frameMateriallist">'
					     +'<option value="${bfmid}">${bfmname}</option>'
					     +'</s:iterator>'
					     +'</select></li>'	
					   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID310'+index+'"><select clean=clean id="goodscategoryID312'+index+'" name="goodscategoryID312" onchange="change51(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
						 +'<option value="">----请选择----</option>'
					     +'<option value="1">功能</option>'	            
						 +'</select></li>'	        	     
					   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID311'+index+'"><select clean=clean id="goodscategoryID313'+index+'" name="goodscategoryID313" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
						 +'<option value="">----请选择----</option>'
						 +'<option value="2">偏光</option>'
						 +'<option value="1">遮阳</option>'	            
					     +'</select></li>'
							           
      	               data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID408'+index+'"><input class="text_input60" style="width:50" maxlength="20" id="ssmsgsphul'+index+'" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写!\'}]" clean=clean id="goodscategoryID408'+index+'" name="goodscategoryID408" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'61\',\'\')" onblur="checkData(this)">至<input maxlength="20" id="ssmsgsphup'+index+'" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写!\'}]" onblur="checkData(this)" clean=clean id="goodscategoryID409'+index+'" name="goodscategoryID409" xf61="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
                         +'</li>'	  

    	               data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID409'+index+'"><input class="text_input60" style="width:50" maxlength="20" id="ssmsgcylul'+index+'" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写!\'}]" clean=clean id="goodscategoryID410'+index+'" name="goodscategoryID410"  xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'61\',\'\')" onblur="checkDataz(this)">至<input maxlength="20" id="ssmsgcylup'+index+'" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写!\'}]" clean=clean id="goodscategoryID411'+index+'" name="goodscategoryID411" xf61="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')" onblur="checkDataz(this)">'
                         +'</li>'	               	         
    }
    if (ssmsmclassify == '5'){
    	data = data + '<li class="horizontal_onlyRight"><select style="width:100%" clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" xiaofei=xiaofei xf0="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')" onchange="change5(this,'+index+')">'
  		                 +'<option value="6_6"' + (json.ssmsggoodscategory == "6" ? "selected='selected'" : "") + '>太阳镜</option>'
  		                 +'<option value="6_8"' + (json.ssmsggoodscategory == "8" ? "selected='selected'" : "") + '>老花镜</option>'
  		                 +'<option value="1_0"' + (json.ssmsggoodscategory == "1" ? "selected='selected'" : "") + '>镜架</option>'
  		                 +'<option value="7_0"' + (json.ssmsggoodscategory == "7" ? "selected='selected'" : "") + '>耗材</option>'
  		                 +'<option value="9_0"' + (json.ssmsggoodscategory == "9" ? "selected='selected'" : "") + '>视光</option>'
  		                 +'<option value="5_0"' + (json.ssmsggoodscategory == "5" ? "selected='selected'" : "") + '>隐形护理液</option>'
  		                 +'<option value="2_0"' + (json.ssmsggoodscategory == "2" ? "selected='selected'" : "") + '>配件</option>'
  		                 +'</select></li></td><td colspan=\'3\'>'	

    	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
    		                 +'<option value="">----请选择----</option>'
                           +'<option value="1">材质</option>'	            
    	                     +'</select></li>'	        	     
    	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
    	             +'<option value="">----请选择----</option>'
                     +'<s:iterator value="frameMateriallist">'
                     +'<option value="${bfmid}">${bfmname}</option>'
                     +'</s:iterator>'
    	                     +'</select></li>'	
    	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID310'+index+'"><select clean=clean id="goodscategoryID312'+index+'" name="goodscategoryID312" onchange="change51(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
      		                 +'<option value="">----请选择----</option>'
                             +'<option value="1">功能</option>'	            
      	                     +'</select></li>'	        	     
      	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID311'+index+'"><select clean=clean id="goodscategoryID313'+index+'" name="goodscategoryID313" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
   			           +'<option value="">----请选择----</option>'
   			           +'<option value="2">偏光</option>'
   			           +'<option value="1">遮阳</option>'	            
   			           +'</select></li>'	                        
    }

    data = data + '<img id="propertyImg'+index+'" src="${ctx }/img/newbtn/audit_0.png" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_0.png\');" btn=btn title=\"选择\" onclick="addGoodsProperty(this,'+index+');" style="cursor: hand;"/>'
    
    data = data +'<input id="goodsName'+index+'" name="salesGoodsArray.ssmsggoodsname" value="' + json.ssmsggoodsname + '" class="text_input120" type="text" readonly="readonly"><img src="${ctx }/img/newbtn/audit_0.png" title="选择" onclick="openGoods('+index+');" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_0.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_0.png\');" style="cursor: hand;">'
                   +'<input id="supplier'+index+'" class="text_input60" name="salesGoodsArray.ssmsgsupplier" value="' + json.ssmsgsupplier + '" type="hidden"><input id="brand'+index+'" class="text_input60" name="salesGoodsArray.ssmsgbrand" value="' + json.ssmsgbrand + '" type="hidden"><input id="iscustomize'+index+'" name="salesGoodsArray.ssmsgiscustomize" value="' + json.ssmsgiscustomize + '" class="text_input60" type="hidden"><input id="goods'+index+'" name="salesGoodsArray.ssmsggoodsid" value="' + json.ssmsggoodsid + '" class="text_input60" type="hidden">'
                   +'<input id="goodscategory2id'+index+'" name="salesGoodsArray.ssmsggoodscategory" value="' + json.ssmsggoodscategory + '" class="text_input60" type="hidden"><input id="ssmsgoodsclass'+index+'" name="salesGoodsArray.ssmsgoodsclass" value="' + json.ssmsggoodsclass + '" class="text_input60" type="hidden"><input id="minCostPrice'+index+'" class="text_input60" type="hidden"><input id="maxCostPrice'+index+'" class="text_input60" type="hidden"><input id="bigClass'+index+'" name="salesGoodsArray.ssmsgbigclass" value="' + json.ssmsgbigclass + '" class="text_input60" type="hidden"><input id="smallClass'+index+'" name="salesGoodsArray.ssmsgsmallclass" value="' + json.ssmsgsmallclass + '" class="text_input60" type="hidden">'

    data = data + '</td></tr><tr hide=hide id="hide'+index+'"><td>&nbsp;</td><td width=\'20%\'>'                   
                   +'<select multiple="multiple" class="text_input200 gbc" style="height:100px;width:250px" name="goodspropertyarray" id="goodspropertyarray'+index+'" onclick="changePropertyValue(this,'+index+');">'
                   +'<optgroup label="(按住ctrl键,可同时选中多项)">'

                   if (json.ssmsgbigclass.indexOf(',') > 0){
                	   var perprotyValueArray = json.ssmsgbigclass.split(',');
                	   var perprotyTextArray = json.ssmsgsmallclass.split(',');

                       if (perprotyValueArray.length > 0){
                    	   propertyCount = 1;
                       }
                	   
                	   for (var i = 0; i < perprotyValueArray.length; i++){
                		   data = data + '<option value="'+ perprotyValueArray[i] +'" parentID="'+perprotyValueArray[i].split(';')[0]+'">'+ perprotyTextArray[i] +'</option>'                		   
                       }
                   }else{

                       if ($.trim(json.ssmsgbigclass) != ''){
                    	   data = data + '<option value="'+ json.ssmsgbigclass +'" parentID="'+json.ssmsgbigclass.split(';')[0]+'">'+ json.ssmsgsmallclass +'</option>'
                    	   propertyCount = 1
                       }
                	   
                   }
                                     
    data = data +'</optgroup></select>'
    data = data + '</td><td width=\'20%\'><img src="${ctx }/img/newbtn/delete_0.png" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_0.png\');" btn=btn title=\'删除\' onclick="removeOption(this,'+index+');" style="cursor: hand;" idx="'+index+'"/></td></tr></table>'
                + '<input type="hidden" id="ssmspropertyvaluearray'+index+'" name="salesGoodsArray.ssmspropertyvaluearray" readonly="readonly" value="' + json.ssmsgbigclass + '"><input type="hidden" id="ssmsgoodspropertyarray'+index+'" name="salesGoodsArray.ssmsgoodspropertyarray" readonly="readonly" value="' + json.ssmsgsmallclass + '">';

   
    c2.innerHTML = data;
    
    c3.innerHTML = '<span id="spanminCostPriceAmount'+index+'">' + json.ssmsgmincostPrice + '</span><input class="text_input60 noneInput" id="minCostPriceAmount'+index+'" value="' + json.ssmsgmincostPrice + '" type="hidden" name="salesGoodsArray.ssmsgmincostPrice" readonly="readonly">至<span id="spanmaxCostPriceAmount'+index+'">' + json.ssmsgmaxcostPrice + '</span><input id="maxCostPriceAmount'+index+'" value="' + json.ssmsgmaxcostPrice + '" class="text_input60 noneInput" type="hidden" readonly="readonly" name="salesGoodsArray.ssmsgmaxcostPrice">';
    c4.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" value="' + json.ssmsgbeginAmount + '" id="ssmsgbeginAmount'+index+'" type="text" name="salesGoodsArray.ssmsgbeginAmount" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.UFloatORNULL, \'Message\' : \'套餐价格区间填写有误.请重新填写!\'}]" onblur="validationGoodsCostPriceMin(this,'+index+');" xf6="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'7\',\'\')">至<input maxlength="15" id="ssmsgendAmount'+index+'" class="text_input60" style="width:50" type="text" name="salesGoodsArray.ssmsgendAmount" value="' + json.ssmsgendAmount + '" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.UFloatORNULL, \'Message\' : \'套餐价格区间填写有误.请重新填写!\'}]" onblur="validationGoodsCostPriceMax(this,'+index+');" xf7="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'8\',\'\')">';
	c5.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" value="' + json.ssmsggoodsquantity + '" id="goodsquantity'+index+'" type="text" name="salesGoodsArray.ssmsggoodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量!\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'商品数量填写有误.请重新填写!\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number($.trim(this.value) == \'\' ? 1 : this.value).toFixed(0);}else{this.value = \'1\';}getSetMealAmount3(this);" value="1" xf8="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'9\',\'\')">';

	c6.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="ssmsgexpensespendup'+index+'" type="text" name="salesGoodsArray.ssmsgexpensespendup" value="' + json.ssmsgexpensespendup + '" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.UFloatORNULL, \'Message\' : \'消费满金额区间填写有误.请重新填写!\'}]" xf9="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'10\',\'\')" onblur="amoumtAddZero(this)">至<input class="text_input60" style="width:50" maxlength="15" id="ssmsgexpensespendul'+index+'" type="text" name="salesGoodsArray.ssmsgexpensespendul" value="' + json.ssmsgexpensespendul + '" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.UFloatORNULL, \'Message\' : \'消费满金额区间填写有误.请重新填写!\'}]" xf10="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'11\',\'\')" onblur="amoumtAddZero(this)">';

	if (ssmsmclassify == '5'){
		 $('#goodscategoryID301'+index).hide();
	     $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();
         $('#goodscategoryID306'+index).hide();
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).hide();
         $('#goodscategoryID309'+index).hide();
         $('#goodscategoryID310'+index).hide();
         $('#goodscategoryID311'+index).hide();
         $('#goodscategoryID312'+index).show();
         $('#goodscategoryID313'+index).hide();
         
         $('#ligoodscategoryID301'+index).hide();
	     $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();
         $('#ligoodscategoryID306'+index).hide();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide();
         $('#ligoodscategoryID310'+index).show();
         $('#ligoodscategoryID311'+index).hide();

         change5_son(document.getElementById('goodscategoryID'+index),index);
	}
	if (ssmsmclassify == '3'){
	    $('#goodscategoryID402'+index).hide();
        $('#goodscategoryID403'+index).hide();
	    $('#goodscategoryID408'+index).hide();
        $('#goodscategoryID409'+index).hide();
	    $('#goodscategoryID410'+index).hide();
        $('#goodscategoryID411'+index).hide();
        $('#goodscategoryID306'+index).hide();
        $('#goodscategoryID307'+index).hide();        
        $('#goodscategoryID312'+index).hide();
        $('#goodscategoryID313'+index).hide();
        
	    $('#ligoodscategoryID402'+index).hide();
        $('#ligoodscategoryID403'+index).hide();
	    $('#ligoodscategoryID408'+index).hide();
        $('#ligoodscategoryID409'+index).hide();
        $('#ligoodscategoryID306'+index).hide();
        $('#ligoodscategoryID307'+index).hide();
        $('#ligoodscategoryID310'+index).hide();
        $('#ligoodscategoryID311'+index).hide();

        change4_son(document.getElementById('goodscategoryID'+index),index);
	}
	if (ssmsmclassify == '1'){
	    $('#goodscategoryID301'+index).hide();
	    $('#goodscategoryID302'+index).hide();
        $('#goodscategoryID303'+index).hide();
        $('#goodscategoryID304'+index).hide();
        $('#goodscategoryID305'+index).hide();             
        $('#goodscategoryID307'+index).hide();
        $('#goodscategoryID308'+index).hide();
        $('#goodscategoryID309'+index).hide();
        $('#goodscategoryID310'+index).hide();
        $('#goodscategoryID311'+index).hide();
        $('#goodscategoryID312'+index).hide();
        $('#goodscategoryID313'+index).hide();

	    $('#ligoodscategoryID301'+index).hide();
	    $('#ligoodscategoryID302'+index).hide();
        $('#ligoodscategoryID303'+index).hide();
        $('#ligoodscategoryID304'+index).hide();
        $('#ligoodscategoryID305'+index).hide();             
        $('#ligoodscategoryID307'+index).hide();
        $('#ligoodscategoryID308'+index).hide();
        $('#ligoodscategoryID309'+index).hide();
        $('#ligoodscategoryID310'+index).hide();
        $('#ligoodscategoryID311'+index).hide();

        change3_son(document.getElementById('goodscategoryID'+index),index);
	}

	$('#propertyImg'+index).hide();

	if (propertyCount == 0){
		$('tr[id=hide'+index+']').hide();
	}
    
}


function updateRow2(json){

    var propertyCount = 0;
	
    if ($('#ssmsmclassify').val() == ''){
        alert("请先选择套餐分类!");
        return;
    }
    var table = document.getElementById('addTablesong2');
    index = accAdd(document.getElementById('addTablebangding').rows.length - 1,accAdd(index,table.rows.length - 1));
	var row = table.insertRow(table.rows.length);
	var c1 = row.insertCell(0);
	var c2 = row.insertCell(1);
	var c3 = row.insertCell(2);
	var c4 = row.insertCell(3);
	var c5 = row.insertCell(4);
	var c7 = row.insertCell(5);
	var c8 = row.insertCell(6);
	var c9 = row.insertCell(7);
	var c10 = row.insertCell(8);
	var c11 = row.insertCell(9);
							
	row.className = 'row';		
	c1.height="26";
	c1.innerHTML = '<input type="checkbox" id="chk2" name="chk2"/>';		

	var data = '<table border=\'0\' width=\'100%\'><tr><td width=\'20%\'>'
		
	var ssmsmclassify = $('#ssmsmclassify').val();
    if (ssmsmclassify == '1'){
    	data = data + '<li class="horizontal_onlyRight"><select style="width:100%" clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change3(this,'+index+')" dk0="dk'+index+'" youhui=youhui onKeyPress="dkEnterDown('+index+',\'1\',\'6\')">'
    		             +'<option value="1_0" ' + ((json.ssmsggoodscategory == "1") ? "selected='selected'" : "") + '>镜架</option>'
  		                 +'<option value="3"' + ((json.ssmsggoodscategory == "3" && json.ssmsgiscustomize != "0" && json.ssmsgiscustomize != "D") ? "selected='selected'" : "") + '>镜片</option>'
  		                 +'<option value="3_0"' + ((json.ssmsggoodscategory == "3" && json.ssmsgiscustomize == "0") ? "selected='selected'" : "") + '>成品片</option>'
  		                 +'<option value="3_D"' + ((json.ssmsggoodscategory == "3" && json.ssmsgiscustomize == "D") ? "selected='selected'" : "") + '>订做片</option>'
  		                 +'<option value="6_6"' + (json.ssmsggoodscategory == "6" ? "selected='selected'" : "") + '>太阳镜</option>'
  		                 +'<option value="6_8"' + (json.ssmsggoodscategory == "8" ? "selected='selected'" : "") + '>老花镜</option>'
  		                 +'<option value="7_0"' + (json.ssmsggoodscategory == "7" ? "selected='selected'" : "") + '>耗材</option>'
  		                 +'<option value="9_0"' + (json.ssmsggoodscategory == "9" ? "selected='selected'" : "") + '>视光</option>'
  		                 +'<option value="5_0"' + (json.ssmsggoodscategory == "5" ? "selected='selected'" : "") + '>隐形护理液</option>'
  		                 +'<option value="2_0"' + (json.ssmsggoodscategory == "2" ? "selected='selected'" : "") + '>配件</option>'
  	                     + '</select></li></td><td colspan=\'3\'>'	
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID301'+index+'"><select clean=clean id="goodscategoryID301'+index+'" name="goodscategoryID301" onchange="change31(this,'+index+')" dk1="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'2\',\'6\')">'
  		                 +'<option value="">----请选择----</option>'
                         +'<option value="1">材料分类</option>'
                  		 +'<option value="2">折射率</option>'     
  		                 +'<option value="3">光度分类</option>' 	
  		                 +'<option value="4">镜片功能</option>'
  		                 +'<option value="5">球镜区间</option>'
  		                 +'<option value="6">柱镜区间</option>'			            
  	                     +'</select></li>'	   
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID302'+index+'"><select clean=clean id="goodscategoryID302'+index+'" name="goodscategoryID302" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
  	                     +'<option value="">----请选择----</option>'
                         +'<option value="1">树脂</option>'
                  		 +'<option value="2">玻璃</option>'     
  		                 +'<option value="3">PC</option>' 			            
  	                     +'</select></li>'	      
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID303'+index+'"><select clean=clean id="goodscategoryID303'+index+'" name="goodscategoryID303" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
  	                      +'<option value="">----请选择----</option>'
                         +'<s:iterator value="refractiveSetList">'
                         +'<option value="${brfname}">${brfname}</option>'
                         +'</s:iterator>'                      			            
  	                     +'</select></li>'	   
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID304'+index+'"><select clean=clean id="goodscategoryID304'+index+'" name="goodscategoryID304" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
  	                     +'<option value="">----请选择----</option>'
                         +'<option value="0">单光</option>'
                  		 +'<option value="m">多光</option>'     
  		                 +'<option value="j_1">青少年渐进</option>'
                  		 +'<option value="j_2">成人渐进</option>' 
  		                 +'<option value="k">抗疲劳</option>' 	
  		                 +'<option value="q">其他</option>' 			            
  	                     +'</select></li>'	   
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID305'+index+'"><select clean=clean id="goodscategoryID305'+index+'" name="goodscategoryID305" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
  	                     +'<option value="">----请选择----</option>'
                         +'<option value="1">白色片</option>'
                  		 +'<option value="2">变色片</option>'     
  		                 +'<option value="3">偏光片</option>'
  		                 +'<option value="4">变色偏光片</option>' 	
  		                 +'<option value="5">染色片</option>' 	
  		                 +'<option value="6">抗疲劳片</option>' 	
  		                 +'<option value="7">抗疲劳变色片</option>'
  		                 +'<option value="8">偏光抗疲劳片</option>' 		  		            
  	                     + '</select></li>'
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" dk1="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'2\',\'6\')">'
  		                 +'<option value="">----请选择----</option>'
                         +'<option value="1">材质</option>'	            
  	                     +'</select></li>'	        	     
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
  	               +'<option value="">----请选择----</option>'
                   +'<s:iterator value="frameMateriallist">'
                   +'<option value="${bfmid}">${bfmname}</option>'
                   +'</s:iterator>'
  	                     +'</select></li>'

  	               	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID310'+index+'"><select clean=clean id="goodscategoryID312'+index+'" name="goodscategoryID312" onchange="change51(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
		                 +'<option value="">----请选择----</option>'
                    +'<option value="1">功能</option>'	            
	                     +'</select></li>'	        	     
	                data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID311'+index+'"><select clean=clean id="goodscategoryID313'+index+'" name="goodscategoryID313" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
		           +'<option value="">----请选择----</option>'
		           +'<option value="2">偏光</option>'
		           +'<option value="1">遮阳</option>'	            
		           +'</select></li>'	
		           
    	               data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID308'+index+'"><input class="text_input60" style="width:50" maxlength="20" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写!\'}]" clean=clean id="goodscategoryID308'+index+'" name="goodscategoryID308" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'14\',\'\')" onblur="checkData(this)">至<input maxlength="20" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写!\'}]" onblur="checkData(this)" clean=clean id="goodscategoryID309'+index+'" name="goodscategoryID309" dk14="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
                           +'</li>'	  

        	           data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID309'+index+'"><input class="text_input60" style="width:50" maxlength="20" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写!\'}]" clean=clean id="goodscategoryID310'+index+'" name="goodscategoryID310"  dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'14\',\'\')" onblur="checkDataz(this)">至<input maxlength="20" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写!\'}]" clean=clean id="goodscategoryID311'+index+'" name="goodscategoryID311" dk14="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')" onblur="checkDataz(this)">'
                           +'</li>'	         	          	                     
    }

    if (ssmsmclassify == '3'){
    	data = data + '<li class="horizontal_onlyRight"><select style="width:100%" clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change4(this,'+index+')" dk0="dk'+index+'" youhui=youhui onKeyPress="dkEnterDown('+index+',\'1\',\'6\')">'       
             			 +'<option value="4"' + ((json.ssmsggoodscategory == "4" && json.ssmsgiscustomize != "0" && json.ssmsgiscustomize != "D") ? "selected='selected'" : "") + '>隐形镜片</option>'
                         +'<option value="4_0"' + ((json.ssmsggoodscategory == "4" && json.ssmsgiscustomize == "0" ) ? "selected='selected'" : "") + '>隐形成品片</option>'
  		                 +'<option value="4_D"' + ((json.ssmsggoodscategory == "4" && json.ssmsgiscustomize == "D") ? "selected='selected'" : "") + '>隐形订做片</option>'
  		                 +'<option value="5_0"' + ((json.ssmsggoodscategory == "5") ? "selected='selected'" : "") + '>隐形护理液</option>'
  		                 +'<option value="6_6"' + (json.ssmsggoodscategory == "6" ? "selected='selected'" : "") + '>太阳镜</option>'
  		                 +'<option value="6_8"' + (json.ssmsggoodscategory == "8" ? "selected='selected'" : "") + '>老花镜</option>'
  		                 +'<option value="1_0"' + (json.ssmsggoodscategory == "1" ? "selected='selected'" : "") + '>镜架</option>'
  		                 +'<option value="7_0"' + (json.ssmsggoodscategory == "7" ? "selected='selected'" : "") + '>耗材</option>'
  		                 +'<option value="9_0"' + (json.ssmsggoodscategory == "9" ? "selected='selected'" : "") + '>视光</option>'
  		                 +'<option value="2_0"' + (json.ssmsggoodscategory == "2" ? "selected='selected'" : "") + '>配件</option>'
  	                     +'</select></li></td><td colspan=\'3\'>'
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID401'+index+'"><select clean=clean id="goodscategoryID401'+index+'" name="goodscategoryID401" onchange="change41(this,'+index+')" dk1="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'2\',\'6\')">'       
  		                 +'<option value="">----请选择----</option>'
  		                 +'<option value="1">使用类型</option>'
  		                 +'<option value="2">抛弃型分类</option>'
  		                 +'<option value="5">球镜区间</option>'
  		                 +'<option value="6">柱镜区间</option>'
  	                     +'</select></li>'	         
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID402'+index+'"><select clean=clean id="goodscategoryID402'+index+'" name="goodscategoryID402" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'       
  	                     +'<option value="">----请选择----</option>'
		                 +'<option value="1">常带型</option>'
  		                 +'<option value="2">抛弃型</option>'
  		               +'<option value="3">塑形镜</option>'
  	                     +'</select></li>'	
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID403'+index+'"><select clean=clean id="goodscategoryID403'+index+'" name="goodscategoryID403" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'       
  	                     +'<option value="">----请选择----</option>'
		                 +'<option value="1">日抛</option>'
  		                 +'<option value="2">周抛</option>'
  		                 +'<option value="9">双周抛</option>'
  		                 +'<option value="3">月抛</option>'
  		                 +'<option value="4">季抛</option>'
  		                 +'<option value="5">半年抛</option>'
  		                 +'<option value="6">年抛</option>'
  		                 +'<option value="7">RGP</option>'      		                 
  	                     +'</select></li>'   

  	               	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
	                 +'<option value="">----请选择----</option>'
                  +'<option value="1">材质</option>'	            
                    +'</select></li>'	        	     
data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
            +'<option value="">----请选择----</option>'
            +'<s:iterator value="frameMateriallist">'
            +'<option value="${bfmid}">${bfmname}</option>'
            +'</s:iterator>'
                    +'</select></li>'	
data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID310'+index+'"><select clean=clean id="goodscategoryID312'+index+'" name="goodscategoryID312" onchange="change51(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
		                 +'<option value="">----请选择----</option>'
                    +'<option value="1">功能</option>'	            
	                     +'</select></li>'	        	     
	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID311'+index+'"><select clean=clean id="goodscategoryID313'+index+'" name="goodscategoryID313" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
		           +'<option value="">----请选择----</option>'
		           +'<option value="2">偏光</option>'
		           +'<option value="1">遮阳</option>'	            
		           +'</select></li>'
		           
      	               data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID408'+index+'"><input class="text_input60" style="width:50" maxlength="20" id="ssmsgsphul'+index+'" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写!\'}]" clean=clean id="goodscategoryID408'+index+'" name="goodscategoryID408" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'14\',\'\')" onblur="checkData(this)">至<input maxlength="20" id="ssmsgsphup'+index+'" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写!\'}]" onblur="checkData(this)" clean=clean id="goodscategoryID409'+index+'" name="goodscategoryID409" dk14="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
                       +'</li>'	  

    	               data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID409'+index+'"><input class="text_input60" style="width:50" maxlength="20" id="ssmsgcylul'+index+'" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写!\'}]" clean=clean id="goodscategoryID410'+index+'" name="goodscategoryID410"  dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'14\',\'\')" onblur="checkDataz(this)">至<input maxlength="20" id="ssmsgcylup'+index+'" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写!\'}]" clean=clean id="goodscategoryID411'+index+'" name="goodscategoryID411" dk14="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')" onblur="checkDataz(this)">'
                       +'</li>'	               	         
    }
    if (ssmsmclassify == '5'){
    	data = data + '<li class="horizontal_onlyRight"><select style="width:100%" clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" dk0="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')" youhui=youhui onchange="change5(this,'+index+')">'
  		                 +'<option value="6_6"' + ((json.ssmsggoodscategory == "6") ? "selected='selected'" : "") + '>太阳镜</option>'
  		                 +'<option value="6_8"' + ((json.ssmsggoodscategory == "8" ) ? "selected='selected'" : "") + '>老花镜</option>'
  		                 +'<option value="1_0"' + ((json.ssmsggoodscategory == "1" ) ? "selected='selected'" : "") + '>镜架</option>'
  		                 +'<option value="7_0"' + ((json.ssmsggoodscategory == "7" ) ? "selected='selected'" : "") + '>耗材</option>'
  		                 +'<option value="9_0"' + ((json.ssmsggoodscategory == "9" ) ? "selected='selected'" : "") + '>视光</option>'
  		                 +'<option value="5_0"' + ((json.ssmsggoodscategory == "5" ) ? "selected='selected'" : "") + '>隐形护理液</option>'
  		                 +'<option value="2_0"' + ((json.ssmsggoodscategory == "2" ) ? "selected='selected'" : "") + '>配件</option>'
  		                 +'</select></li></td><td colspan=\'3\'>'	

    	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" dk1="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'2\',\'6\')">'
    		                 +'<option value="">----请选择----</option>'
                           +'<option value="1">材质</option>'	            
    	                     +'</select></li>'	        	     
    	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
    	             +'<option value="">----请选择----</option>'
                     +'<s:iterator value="frameMateriallist">'
                     +'<option value="${bfmid}">${bfmname}</option>'
                     +'</s:iterator>'
    	             +'</select></li>'	

    	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID310'+index+'"><select clean=clean id="goodscategoryID312'+index+'" name="goodscategoryID312" onchange="change51(this,'+index+')" dk1="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'2\',\'6\')">'
   		                 +'<option value="">----请选择----</option>'
                          +'<option value="1">功能</option>'	            
   	                     +'</select></li>'	        	     
   	    data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID311'+index+'"><select clean=clean id="goodscategoryID313'+index+'" name="goodscategoryID313" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
			           +'<option value="">----请选择----</option>'
			           +'<option value="2">偏光</option>'
			           +'<option value="1">遮阳</option>'	            
			           +'</select></li>'	                         
    }

    data = data + '<img id="propertyImg'+index+'" src="${ctx }/img/newbtn/audit_0.png" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_0.png\');" btn=btn title=\"选择\" onclick="addGoodsProperty(this,'+index+');" style="cursor: hand;"/>'
    
    data = data +'<input id="goodsName'+index+'" name="creditGoodsArray.ssmsggoodsname" class="text_input120" value="'+json.ssmsggoodsname+'" type="text" readonly="readonly"><img src="${ctx }/img/newbtn/audit_0.png" title="选择" onclick="openGoods('+index+');" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_0.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_0.png\');" style="cursor: hand;">'
                   +'<input id="supplier'+index+'" class="text_input60" name="creditGoodsArray.ssmsgsupplier" value="'+json.ssmsgsupplier+'" type="hidden"><input id="brand'+index+'" class="text_input60" value="'+json.ssmsgbrand+'" name="creditGoodsArray.ssmsgbrand" type="hidden"><input id="iscustomize'+index+'" value="'+json.ssmsgiscustomize+'" name="creditGoodsArray.ssmsgiscustomize" class="text_input60" type="hidden"><input id="goods'+index+'" value="'+json.ssmsggoodsid+'" name="creditGoodsArray.ssmsggoodsid" class="text_input60" type="hidden">'
                   +'<input id="goodscategory2id'+index+'" name="creditGoodsArray.ssmsggoodscategory" class="text_input60" value="'+json.ssmsggoodscategory+'" type="hidden"><input id="ssmsgoodsclass'+index+'" value="'+json.ssmsggoodsclass+'" name="creditGoodsArray.ssmsgoodsclass" class="text_input60" type="hidden"><input id="minCostPrice'+index+'" class="text_input60" type="hidden"><input id="maxCostPrice'+index+'" class="text_input60" type="hidden"><input id="bigClass'+index+'" value="'+json.ssmsgbigclass+'" name="creditGoodsArray.ssmsgbigclass" class="text_input60" type="hidden"><input id="smallClass'+index+'" value="'+json.ssmsgsmallclass+'" name="creditGoodsArray.ssmsgsmallclass" class="text_input60" type="hidden">'

    data = data + '</td></tr><tr hide=hide id="hide'+index+'"><td>&nbsp;</td><td width=\'20%\'>'
                   
                   +'<select multiple="multiple" class="text_input200 gbc" style="height:100px;width:250px" name="goodspropertyarray" id="goodspropertyarray'+index+'" onclick="changePropertyValue(this,'+index+');">'
                   +'<optgroup label="(按住ctrl键,可同时选中多项)">'

                   if (json.ssmsgbigclass.indexOf(',') > 0){
                	   var perprotyValueArray = json.ssmsgbigclass.split(',');
                	   var perprotyTextArray = json.ssmsgsmallclass.split(',');

                       if (perprotyValueArray.length > 0){
                    	   propertyCount = 1;
                       }
                	   
                	   for (var i = 0; i < perprotyValueArray.length; i++){
                		   data = data + '<option value="'+ perprotyValueArray[i] +'" parentID="'+perprotyValueArray[i].split(';')[0]+'">'+ perprotyTextArray[i] +'</option>'                		   
                       }
                   }else{

                       if ($.trim(json.ssmsgbigclass) != ''){
                    	   data = data + '<option value="'+ json.ssmsgbigclass +'" parentID="'+json.ssmsgbigclass.split(';')[0]+'">'+ json.ssmsgsmallclass +'</option>'
                    	   propertyCount = 1
                       }
                	   
                   }
                   
                   +'</optgroup></select>'

    data = data + '</td><td width=\'20%\'><img src="${ctx }/img/newbtn/delete_0.png" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_0.png\');" btn=btn title=\'删除\' onclick="removeOption(this,'+index+');" style="cursor: hand;"/></td></tr></table>'
                  +'<input type="hidden" id="ssmspropertyvaluearray'+index+'" name="creditGoodsArray.ssmspropertyvaluearray" value="'+json.ssmsgbigclass+'" readonly="readonly"><input type="hidden" id="ssmsgoodspropertyarray'+index+'" name="creditGoodsArray.ssmsgoodspropertyarray" value="'+json.ssmsgsmallclass+'" readonly="readonly">';

    c2.innerHTML = data;
    
    c3.innerHTML = '<span id="spanminCostPriceAmount'+index+'">'+json.ssmsgmincostPrice+'</span><input class="text_input60 noneInput" id="minCostPriceAmount'+index+'" value="'+json.ssmsgmincostPrice+'" type="hidden" name="creditGoodsArray.ssmsgmincostPrice" readonly="readonly">至<span id="spanmaxCostPriceAmount'+index+'">'+json.ssmsgmaxcostPrice+'</span><input id="maxCostPriceAmount'+index+'" value="'+json.ssmsgmaxcostPrice+'" class="text_input60 noneInput" type="hidden" readonly="readonly" name="creditGoodsArray.ssmsgmaxcostPrice">';
    c4.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="ssmsgbeginAmount'+index+'" value="'+json.ssmsgbeginAmount+'" type="text" name="creditGoodsArray.ssmsgbeginAmount" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.UFloatORNULL, \'Message\' : \'套餐价格区间填写有误.请重新填写!\'}]" onblur="validationGoodsCostPriceMin(this,'+index+');" dk6="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'7\',\'\')">至<input maxlength="15" id="ssmsgendAmount'+index+'" value="'+json.ssmsgendAmount+'" class="text_input60" style="width:50" type="text" name="creditGoodsArray.ssmsgendAmount" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.UFloatORNULL, \'Message\' : \'套餐价格区间填写有误.请重新填写!\'}]" onblur="validationGoodsCostPriceMax(this,'+index+');" dk7="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'8\',\'\')">';
	c5.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="goodsquantity'+index+'" value="'+json.ssmsggoodsquantity+'" type="text" name="creditGoodsArray.ssmsggoodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'商品数量填写有误.请重新填写!\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number($.trim(this.value) == \'\' ? 1 : this.value).toFixed(0);}else{this.value = \'1\';}getSetMealAmount3(this);computeUnitCost('+index+',\'3\');" value="1" dk8="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'9\',\'\')">';

    c7.innerHTML = '<table id="hideHeight'+index+'" border=\'0\' width=\'100%\' height=\'43%\'><tr><td>&nbsp;</td></tr></table><select clean=clean id="ssmsgfavorableflag'+index+'" name="creditGoodsArray.ssmsgfavorableflag" onchange="favorableForm(this);this.blur();" >'
			          +'<option value="1"' + (json.ssmsgfavorableflag == "1" ? "selected='selected'" : "") + '>原价</option>'
			          +'<option value="2"' + (json.ssmsgfavorableflag == "2" ? "selected='selected'" : "") + '>打折</option>'
			          +'<option value="3"' + (json.ssmsgfavorableflag == "3" ? "selected='selected'" : "") + '>返现</option>'
			          +'<option value="4"' + (json.ssmsgfavorableflag == "4" ? "selected='selected'" : "") + '>特价</option>'
			          +'</select>';
	
	c8.innerHTML = '<input class="text_input60 inInput readyonlyInput" noValidate="noValidate" readonly="readonly" style="width:50" maxlength="10" id="ssmsgretailPrice'+index+'" value="'+json.ssmsgretailPrice+'" type="text" name="creditGoodsArray.ssmsgretailPrice" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写套餐单价!\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'套餐单价填写有误.请重新填写!\'}]" onblur="getSetMealAmount(this)" dk9="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'10\',\'\')" onblur="amoumtAddZero(this)">';
	c9.innerHTML = '<input ' + (json.ssmsgfavorableflag == '4' ? "class='text_input60'" : "class='text_input60 inInput readyonlyInput' readonly='readonly' noValidate='noValidate' ") + ' maxlength="10" id="specialoffer'+index+'" value="'+json.ssmsgspecialoffer+'" type="text" style="width:50" name="creditGoodsArray.ssmsgspecialoffer" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写特价金额!\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'特价金额填写有误.请重新填写!\'}]" dk10="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'11\',\'12\')" onblur="amoumtAddZero(this);computeUnitCost('+index+',\'1\');">';
    
    c10.innerHTML = '<input ' + (json.ssmsgfavorableflag == '3' ? "class='text_input60'" : "class='text_input60 inInput readyonlyInput' readonly='readonly' noValidate='noValidate' ") + ' maxlength="10" id="ssmsgexpensecredit'+index+'" value="'+json.ssmsgexpensecredit+'" type="text" style="width:50" name="creditGoodsArray.ssmsgexpensecredit" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写优惠金额!\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'优惠金额填写有误.请重新填写!\'}]"  dk11="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'12\',\'\')" onblur="amoumtAddZero(this);computeUnitCost('+index+',\'2\');">';

    c11.innerHTML = '<input ' + (json.ssmsgfavorableflag == '2' ? "class='text_input60'" : "class='text_input60 inInput readyonlyInput' readonly='readonly' noValidate='noValidate' ") + ' maxlength="10" id="ssmsgdiscountrate'+index+'" value="'+json.ssmsgdiscountrate+'" type="text" style="width:50" name="creditGoodsArray.ssmsgdiscountrate" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写优惠折扣!\'},{\'Type\' : Type.String, \'Formula\' : Formula.UDiscount, \'Message\' : \'优惠折扣填写有误.请重新填写!\'}]" dk12="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'13\',\'0\')">';
    
	if (ssmsmclassify == '5'){
		 $('#goodscategoryID301'+index).hide();
	     $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();
         $('#goodscategoryID306'+index).hide();
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).hide();
         $('#goodscategoryID309'+index).hide();
         $('#goodscategoryID310'+index).hide();
         $('#goodscategoryID311'+index).hide();
         $('#goodscategoryID312'+index).show();
         $('#goodscategoryID313'+index).hide();
         
         $('#ligoodscategoryID301'+index).hide();
	     $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();
         $('#ligoodscategoryID306'+index).hide();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide();
         $('#ligoodscategoryID310'+index).show();
         $('#ligoodscategoryID311'+index).hide();

         change5_son(document.getElementById('goodscategoryID'+index),index);
	}
	if (ssmsmclassify == '3'){
	    $('#goodscategoryID402'+index).hide();
        $('#goodscategoryID403'+index).hide();
	    $('#goodscategoryID408'+index).hide();
        $('#goodscategoryID409'+index).hide();
	    $('#goodscategoryID410'+index).hide();
        $('#goodscategoryID411'+index).hide();
        $('#goodscategoryID306'+index).hide();
        $('#goodscategoryID307'+index).hide();        
        $('#goodscategoryID312'+index).hide();
        $('#goodscategoryID313'+index).hide();
        
	    $('#ligoodscategoryID402'+index).hide();
        $('#ligoodscategoryID403'+index).hide();
	    $('#ligoodscategoryID408'+index).hide();
        $('#ligoodscategoryID409'+index).hide();
        $('#ligoodscategoryID306'+index).hide();
        $('#ligoodscategoryID307'+index).hide();
        $('#ligoodscategoryID310'+index).hide();
        $('#ligoodscategoryID311'+index).hide();

        change4_son(document.getElementById('goodscategoryID'+index),index);
	}
	if (ssmsmclassify == '1'){
	    $('#goodscategoryID301'+index).hide();
	    $('#goodscategoryID302'+index).hide();
        $('#goodscategoryID303'+index).hide();
        $('#goodscategoryID304'+index).hide();
        $('#goodscategoryID305'+index).hide();             
        $('#goodscategoryID307'+index).hide();
        $('#goodscategoryID308'+index).hide();
        $('#goodscategoryID309'+index).hide();
        $('#goodscategoryID310'+index).hide();
        $('#goodscategoryID311'+index).hide();
        $('#goodscategoryID312'+index).hide();
        $('#goodscategoryID313'+index).hide();

	    $('#ligoodscategoryID301'+index).hide();
	    $('#ligoodscategoryID302'+index).hide();
        $('#ligoodscategoryID303'+index).hide();
        $('#ligoodscategoryID304'+index).hide();
        $('#ligoodscategoryID305'+index).hide();             
        $('#ligoodscategoryID307'+index).hide();
        $('#ligoodscategoryID308'+index).hide();
        $('#ligoodscategoryID309'+index).hide();
        $('#ligoodscategoryID310'+index).hide();
        $('#ligoodscategoryID311'+index).hide();

        change3_son(document.getElementById('goodscategoryID'+index),index);
	}

	$('#propertyImg'+index).hide();

	if (propertyCount == 0){
		$('tr[id=hide'+index+']').hide();
		$('table[id="hideHeight'+index+'"]').hide();
	}
	
 }

</script>