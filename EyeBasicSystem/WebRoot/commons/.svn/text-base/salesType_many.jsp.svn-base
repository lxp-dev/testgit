<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp"%>
<script src="<%=request.getContextPath()%>/js/seleteor/jquery.bgiframe.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/seleteor/jquery.multiSelectCop.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/js/seleteor/jquery.multiSelect.css" rel="stylesheet" type="text/css" />

<script>
$(document).ready(function() {
	
	$("#salesType").multiSelect();
	
	setSalesTypeList('${salestypeid}');
});

function setSalesTypeList(obj){
    var strs = obj.split(',');
    var count = 0;
    for (var i = 0; i < strs.length; i++ ){
        if (strs[i] != '' || strs[i] != 'on'){
           $('input[type=checkbox][salestype=salestype][name=option'+strs[i]+']').attr('checked','checked');
        }
    }

    var stock_obj = $('input[type=checkbox][salestype=salestype]');
    $('input[type=checkbox][salestype=salestype]').each(function(){
        if ($(this).attr('checked') == true){                
            count = accAdd(count,1);
        }
    });
    
    $('.multiSelect').find("span").html((obj == '' || count == 0) ? '----请选择----' : ('已选中(%个)'.replace('%',count)));
}

function resetSalesTypeList(){
    $('input[type=checkbox][salestype=salestype]').attr('checked',false);
    $('input[type=checkbox][class=selectAll]').attr('checked',false);
    $('.multiSelect').find("span").html('----请选择----');
    $('label[doption=doption]').removeClass('checked');
}

function getSalesTypeValue(){
    var salestypeid = '';
    var len = $('input[type=checkbox][salestype=salestype]:checked').size();
    for (var i = 0; i < len; i++){
	    if ($('input[type=checkbox][salestype=salestype]:checked')[i].value != ''){
	    	salestypeid = salestypeid + $('input[type=checkbox][salestype=salestype]:checked')[i].value + ',';
		}
    }
    alert(salestypeid)
    $('input[name=salestypeid]').val(salestypeid); 	
}



</script>