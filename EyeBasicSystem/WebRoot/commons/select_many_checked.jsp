<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp"%>
<script src="<%=request.getContextPath()%>/js/jquery/jquery.bgiframe.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/seleteor/jquery.multiSelect.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/js/seleteor/jquery.multiSelect.css" rel="stylesheet" type="text/css" />

<script>

//初始化赋值
//listID:Select 控件ID
//hiddenID:hiddenID 控件ID
function initSelectList(listID,hiddenID){
	$("#"+listID).multiSelect();
	setSelectList(listID,document.getElementById(hiddenID).value);
}

function setSelectList(listID,obj){
    var strs = obj.split(',');
    var count = 0;
    for (var i = 0; i < strs.length; i++ ){
        if (strs[i] != '' || strs[i] != 'on'){
           $('input[type=checkbox][id='+listID+'][name=option'+strs[i]+']').attr('checked','checked');
        }
    }

    var stock_obj = $('input[type=checkbox][id='+listID+']');
    $('input[type=checkbox][id='+listID+']').each(function(){
        if ($(this).attr('checked') == true){                
            count = accAdd(count,1);
        }
    });
 
    if(strs.length==2){
    	$('[id='+listID+']').find("span").html((obj == '' || count == 0) ? '----请选择----' : $('#'+strs[0]).val());
    }else{
        //$('.multiSelect').find("span").html((obj == '' || count == 0) ? '----请选择----' : ('已选中(%个)'.replace('%',count)));
        $('[id='+listID+']').find("span").html((obj == '' || count == 0) ? '----请选择----' : ('已选中(%个)'.replace('%',count)));
    }
}

function resetSelectList(listID){
    $('input[type=checkbox][id='+listID+']').attr('checked',false);
    $('input[type=checkbox][id='+listID+'][class=selectAll]').attr('checked',false);
    $('[id='+listID+']').find("span").html('----请选择----');
    $('label[doption=doption][id='+listID+']').removeClass('checked');
}

//赋值select 控件里面checked的value到hiddenID控件中
//listID:Select 控件ID
//hiddenID:hiddenID 控件ID
function getSelectValue(listID,hiddenID){
	
    var hiddenValue = '';
    var len = $('input[type=checkbox][id='+listID+']:checked').size();
    //alert($('input[type=checkbox][id='+listID+']:checked').size());
    for (var i = 0; i < len; i++){
	    if ($('input[type=checkbox][id='+listID+']:checked')[i].value != ''){
	    	hiddenValue = hiddenValue + $('input[type=checkbox][id='+listID+']:checked')[i].value + ',';
		}
    }
    document.getElementById(hiddenID).value=hiddenValue; 		
}



</script>