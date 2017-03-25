<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>门店列表</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<style class="cp-pen-styles">
	body,html,h1,h2,h3,h4,h5,h6,big,small,sub,sup,input,select,textarea{font-size:14px; color:#333; font-family:微软雅黑, Arial, 宋体; -webkit-text-size-adjust:none;}
header,footer,section,aside,nav,hgroup,figure,figcaption{display:block; margin:0; padding:0; border:none;}
body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,textarea,blockquote{padding:0; margin:0;}
h1,h2,h3,h4,h5,h6{font-weight:normal;}
li{list-style-type:none;}
img{border:none;}
input[type='text'],input[type='number'],input[type='password'],input[type='reset'],input[type='submit'],input[type='button'],input[type='tel'],button,textarea{-webkit-appearance:none; border-radius:0; border:1px solid #ddd;}
textarea{resize:none;}

/*文字大小，颜色，行距定义*/
.fz_12px{font-size:12px;}
.fz_14px{font-size:14px;}
.fz_16px{font-size:16px;}
.fc_red{color:#ff0000;}
.fc_gory{color:#666;}
.fc_white{color:#fff;}
.fc_yellow{color:#ff6600;}
.flh_150{line-height:150%;}
.flh_180{line-height:180%;}

/*float*/
.fl{float:left;}
.fr{float:right;}

/*form*/
.form_input{color:#333; height:20px; line-height:20px; text-indent:5px}
.form_area{color:#333; line-height:180%; resize:none; overflow:auto;}
.form_button{border:none; background:#505050; color:#fff; height:22px; line-height:22px; padding:0 5px; overflow:hidden; width:80px;}
.form_focus{border-color:red;}

/*padding*/
.clear{margin:0px auto; clear:both; height:0px; font-size:0px; overflow:hidden;}
.blank3{margin:0px auto; clear:both; height:3px; font-size:1px; overflow:hidden;}
.blank6{margin:0px auto; clear:both; height:6px; font-size:1px; overflow:hidden;}
.blank9{margin:0px auto; clear:both; height:9px; font-size:1px; overflow:hidden;}
.blank12{margin:0px auto; clear:both; height:12px; font-size:1px; overflow:hidden;}
.blank15{margin:0px auto; clear:both; height:15px; font-size:1px; overflow:hidden;}
.blank20{margin:0px auto; clear:both; height:20px; font-size:1px; overflow:hidden;}
.blank25{margin:0px auto; clear:both; height:25px; font-size:1px; overflow:hidden;}

/*a*/
a{color:#333; text-decoration:none;}
a:hover{color:#ff6600; text-decoration:underline;}
a.red{color:red; text-decoration:none;}
a.red:hover{color:red; text-decoration:underline;}

/*turn page*/
#turn_page{text-align:center; height:30px; line-height:30px; clear:both;}
#turn_page *{text-decoration:none;}
#turn_page .page_button{background:#fff; border:1px solid #ccc; padding:4px 8px; margin:0 2px;}
#turn_page .page_item{background:#fff; border:1px solid #ccc; padding:4px 8px; margin:0 2px;}
#turn_page .page_item_current{background:#f0f0f0; border:1px solid #ccc; padding:4px 8px; margin:0 2px; color:red;}
#turn_page .page_noclick{background:#fff; border:1px solid #ccc; color:#AAA; padding:4px 8px; margin:0 2px;}

body,html{ background:#ebebed}
#your_address{ background:#fff; height:78px; position:relative; padding-left:76px}
#your_address .lbar{ width:41px; height:53px; position:absolute; left:19px; top:13px}
#your_address .lbar img{ width:100%; height:auto}
#your_address .rbar{ width:98%; color:#000}
#your_address .rbar .title{ padding:15px 0 8px 0px; font-weight:bold}
#your_address .rbar .address{}

#stores_cont .store{ width:96%; margin:5px auto; background:#fff; border:1px solid #e1e1e1; border-radius:3px}
#stores_cont .store .cont{ position:relative; padding-left:105px; min-height:80px}
#stores_cont .store .cont .lbar{ width:90px; height:65px; overflow:hidden; position:absolute; left:5px; top:8px}
#stores_cont .store .cont .lbar img{ width:100%; }
#stores_cont .store .cont .rbar{ width:98%}
#stores_cont .store .cont h3{ padding:8px 0px 5px 0; font-weight:bold}
#stores_cont .dis{ margin-left:5px;font-weight:bold;}
#stores_cont li{ float:left;height:25px; line-height:25px;box-sizing:border-box; -moz-box-sizing:border-box;-webkit-box-sizing:border-box; }
#stores_cont li.lbs{ width:25%; background:url(weixin_personcenter/images/stores/lbs_icon.png)  left center no-repeat; background-size:14px auto;padding-left:18px}
#stores_cont li.tel{ width:50%; background:url(weixin_personcenter/images/stores/tel_icon.png)  left center no-repeat; background-size:18px auto;padding-left:22px;}
#stores_cont li.wait{ width:50%;}
#stores_cont li.wait span{ color:#F00;}
#stores_cont li.number{ width:25%; background:url(weixin_personcenter/images/stores/number_icon.png)  left center no-repeat; background-size:16px auto;padding-left:20px}
#stores_cont .store .tool{ margin-top:5px}
#stores_cont li a:hover{ text-decoration:none}
#stores_cont .tel_list{ display:none}



#tel_box{ width:94%; background:#fff; border-radius:3px; position:fixed; left:0; top:100px; min-height:110px; z-index:1000000; padding:10px 0; display:none}
#tel_box a{ display:block; width:94%; margin:0 auto; background:url(weixin_personcenter/images/stores/tel_label.jpg) no-repeat #f6f6f6; background-size:auto 35px; border:1px solid #e0e0e0; height:35px; margin-bottom:10px; line-height:35px; padding-left:55px; box-sizing:border-box; -moz-box-sizing:border-box; /* Firefox */ -webkit-box-sizing:border-box;border-radius:3px; font-size:16px}
#tel_box h3{ font-size:16px; padding:0 0 5px 0; color:#000;width:94%; margin:0 auto; font-weight:bold}
#tel_box .cancel_btn{ width:94%; height:36px; line-height:36px; text-align:center; color:#fff; background:#8e8e8e; margin:0 auto;border-radius:3px; font-size:16px}

.devices{ margin-top:5px}
.devices li{ }
.devices li,.devices li span{ float:left; line-height:15px;margin-right:3px}
.devices li img{ width:15px; height:15px;}
</style>
</head>
<script>
	function selectView(id){
		location.href = "initUserDepartmentPics.action?hid="+id;
	}
</script>

<script type="text/javascript" src="weixin_personcenter/images/stores/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="weixin_personcenter/images/stores/stores.js"></script>
<script type="text/javascript" src="weixin_personcenter/images/stores/getscript"></script>
<script language="javascript">var baidu_map_ak='051f0cde2360f3c64aa6e7eda6314814'; $(document).ready(function(){stores_obj.stores_init();});</script>
<body data-role="page">
<div id="tel_box">
	<h3>拨打电话</h3>
	<div id="tel_list"></div>
	<div class="cancel_btn">取消</div>
</div>
<div id="your_address">
	<div class="lbar"><img src="weixin_personcenter/images/stores/location_icon.png"></div>
	<div class="rbar">
		<div class="title">我的当前位置:</div>
		<div class="address" id="address_cont">无法获取地理位置！</div>
	</div>
	<div class="clear"></div>
</div>
<div id="stores_ext" style="display:none">
<s:iterator value="departmentsList">
<div class="store" lng="${bdplocationy}" lat="${bdplocationx}">
		<div class="cont">
			<div class="lbar" onclick="selectView('${bdpdepartmentid }')">
				<c:choose>
       				<c:when test="${bdppicurl ne ''}">
       					<img src="${ctx }${bdppicurl}">
       				</c:when>
       				<c:otherwise>
       					<img src="${ctx }/weixin/images/departmentDefault.png">
       				</c:otherwise>
       			</c:choose>
			</div>
			<div class="rbar">
				<h3 onclick="selectView('${bdpdepartmentid }')">${bdpdepartmentname}</h3>
				<div onclick="selectView('${bdpdepartmentid }')">${bdpaddress}<span class="dis">0m</span></div>
				<div class="tool">
					<ul>
						<li class="tel"><a href="tel:${bdpphone}">联系电话</a></li>
						<li class="lbs"><a href="http://api.map.baidu.com/marker?location=${bdplocationx},${bdplocationy}&title=${bdpdepartmentname}&content=${bdpaddress}&output=html" target="_blank">导航</a></li>
					</ul>
					<div class="clear"></div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
</div>
</s:iterator>  
</div>
<div id="stores_cont"></div>
</body></html>