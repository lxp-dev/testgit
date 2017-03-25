String.prototype.trim = function(){
	re = /^[ ]+|[ ]+$/g;
	return this.replace(re, "");
};

//例子：
//调用：checkForm(fTest);fTest:表单对象
//验证标签增加属性validate <input type="text" id="custName" name="custName" value="2009-01-01 12:12:00" validate="..." />
//validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '消息！'}]"
//多验证例子：validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '消息！'},{'Type' : Type.String, 'Formula' : Formula.CN, 'Message' : '消息！'}]"


// 验证值类型
var Type = {"Number" : 0, "String" : 1, "Date" : 2, "Other" : 3};

// 扩展验证
// 例： Expansion ： {Type : Expansion.EQLength, Params : [9...]}
var Expansion = {
				"EQLength" : 0, // Type.String 等于长度 例：validate="[{'Type' : Type.String, 'Expansion' : {Type : Expansion.EQLength, Params : [9]}, 'Message' : '等于长度！'}]"
				"ThanLength" : 1, // Type.String 大于长度 例：validate="[{'Type' : Type.String, 'Expansion' : {Type : Expansion.ThanLength, Params : [9]}, 'Message' : '大于长度！'}]"
				"LessThanLength" : 2, // Type.String 小于长度 例：validate="[{'Type' : Type.String, 'Expansion' : {Type : Expansion.LessThanLength, Params : [9]}, 'Message' : '小于长度！'}]"
				
				"EQLengthORNULL" : 3, // Type.String 等于长度 例：validate="[{'Type' : Type.String, 'Expansion' : {Type : Expansion.EQLength, Params : [9]}, 'Message' : '等于长度！'}]"
				"ThanLengthORNULL" : 4, // Type.String 大于长度 例：validate="[{'Type' : Type.String, 'Expansion' : {Type : Expansion.ThanLength, Params : [9]}, 'Message' : '大于长度！'}]"
				"LessThanLengthORNULL" : 5, // Type.String 小于长度 例：validate="[{'Type' : Type.String, 'Expansion' : {Type : Expansion.LessThanLength, Params : [9]}, 'Message' : '小于长度！'}]"
				"DecimalValidation" : 6 //小数点验证
				}
//验证公式
var Formula = 
	{
		//中文字符 
		"CN" : /[\u4E00-\uFA29]/,
		//全中文字符串
		"ALL_CN" : /^[\u4E00-\uFA29]+$/,
		//不包含中文
		"NO_CN" : /^[^\u4E00-\uFA29]+$/,
		//整数
		"INT" : /^-?\d+$/,
		//正整数
		"ZINT" : /^[1-9]*[1-9][0-9]*$/,			
		//正整数+0
		"UINT" :  /^\d+$/,	
		//(正整数+0)或允许空
		"UINTOrNULL" :  /(^\d+)|^$/,
		//不为空
		"notNull" : /^.+$/,
		//邮件
		"email" : /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/,
		//浮点数（正浮点数 + 0）
		"Float" : /^[-]?\d+(\.\d+)?$/,
		//正浮点数
		"UFloat" : /^\d+(\.\d+)?$/,
		//电话　
		"Phone" : /^(\d{3}-)?\d{8}|(\d{4}-)?\d{7}$/, //电话 匹配形式如 0511-4405222 或 021-87888822 或 87888822 或 4405222
		//手机　
		"TelePhone" : /^(1(([35][0-9])|(47)|[8][01236789]))\d{8}$/, 
		//身份证
		"IdentityCard" : /^\d{15}|\d{18}$|^$/,
		//邮编
		"Postalcode" : /[1-9]\d{5}(?!\d)|^$/,

		//验证日期格式 yyyy-MM-dd
		"DateFormat" : /^\d{4}-\d{2}-\d{2}$/,
		//验证时间格式 12:12:00
		"TimeFormat" : /^(\d{2})(:)?(\d{2}):\d{2}$/,
		//验证长日期 yyyy-MM-dd 12:12:00
		"LongDateFormat" : /^\d{4}-\d{2}-\d{2}[ ](\d{2})(:)?(\d{2}):\d{2}$/,
		//验证英文和数字
		"Word" : /^[\w]+$/,
		"Positive_number" :/^[\+]?\d+(\.d+)?$/,
		"Positive_all":/^(([1-9]+[0-9]*.{1}[0-9]+)|([0].{1}[1-9]+[0-9]*)|([1-9][0-9]*)|([0][.][0-9]+[1-9]*))$/,
		"Positive" :/(^(([1-9]+[0-9]*.{1}[0-9]+)|([0].{1}[1-9]+[0-9]*)|([1-9][0-9]*)|([0][.][0-9]+[1-9]*))$)|^$/,
		//允许空或中文字符 
		"CNORNULL" : /([\u4E00-\uFA29])|^$/,
		//允许空或全中文字符串
		"ALL_CNORNULL" : /(^[\u4E00-\uFA29]+$)|^$/,
		//允许空或不包含中文
		"NO_CNORNULL" : /(^[^\u4E00-\uFA29]+$)|^$/,
		//允许空或整形
		"INTORNULL" : /(^-?\d+$)|^$/,
		//允许空或邮件
		"emailORNULL" : /(^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$)|^$/,
		//允许空或浮点数（正浮点数 + 0）
		"FloatORNULL" : /(^[-]?\d+(\.\d+)?$)|^$/,
		//允许空或电话　
		"PhoneORNULL" : /(^(\d{3}-)?\d{8}|(\d{4}-)?\d{7}$)|^$/, //电话 匹配形式如 0511-4405222 或 021-87888822 或 87888822 或 4405222
		//允许空或身份证
		"IdentityCardORNULL" : /(^\d{15}|\d{18}$)|^$/,
		//允许空或验证日期格式 yyyy-MM-dd
		"DateFormatORNULL" : /(^\d{4}-\d{2}-\d{2}$)|^$/,
		//允许空或验证时间格式 12:12:00
		"TimeFormatORNULL" : /(^(\d{2})(:)?(\d{2}):\d{2}$)|^$/,
		//允许空或验证长日期 yyyy-MM-dd 12:12:00
		"LongDateFormatORNULL" : /(^\d{4}-\d{2}-\d{2}[ ](\d{2})(:)?(\d{2}):\d{2}$)|^$/,
		"NULLValidate" :　/^[.]{0,}$/,
		//验证姓名或允许空
		"PersonNameOrNULL" :　/^([0-9a-zA-Z\u4E00-\uFA29\-]+$)|^$/,
		//验证名称\地址:如制造商名称,品种名称
		"ObjectNameOrNULL" :　/^([0-9a-zA-Z\u4E00-\uFA29\-\[\]\（\）\【\】\(\)\ *]+$)|^$/,
		//验证英文、数字、允许空
		"WordNull" : /^([\w]+$)|^$/,
		//验证球镜、柱镜或允许空
		"SphCylOrNull" : /^[\+\-]?[0-9]{1,2}([.]{1}[0-9]{1,2})?$|^$/,
		//折扣
		"UDiscount" : /^(?:0\.\d+|[1]|[1][.][0]|[1][.][0][0]|[1][.])$/,
		//折扣或允许空
		"UDiscountOrNull" : /^[0](\.\d+)?$|^$/,
		//验证英文、数字、允许空、下划线
		"ReportNameOrNull" : /^([\w_]+.cpt$)|^$/,
		//允许座机和手机
		"TelPhone" : /^((1[3|4|5|7|8][0-9]\d{4,8})|((0{1,1}[1-9]{2,3}-)?[1-9]{1,1}[0-9]{6,7}))$/,	
		//允许座机和手机、空
		"TelPhoneOrNull" : /(^((1[3|5|7|8][0-9]\d{4,8})|((0{1,1}[1-9]{2,3}-)?[1-9]{1,1}[0-9]{6,7}))$)|^$/,
		//允许手机、空
		"PhoneOrNull" : /(^((1[3|5|7|8][0-9]\d{8}))$)|^$/,
		//正浮点数或空
		"UFloatORNULL" : /(^\d+(\.\d+)?$)|^$/
	};

function checkForm(formObj){
	
	for(var i=0;i < formObj.length; i++){
		var obj = formObj[i];
		if($(obj).attr("validate") == null || $(obj).attr("validate") == '' || $(obj).attr("noValidate") == 'noValidate' ){
			continue;
		}
		var vkeyWords = /[\%\&\/\*\(\)\|\\\[\]']+/;

		/*if(obj.value.trim() != '' && vkeyWords.test(obj.value.trim())){
		    alert("特殊字符不允许输入！");
		    obj.select();
		    return false;
	   	}*/
		var jsonV = eval('(' + $(obj).attr("validate") + ')');
		var flag = false; // 提示消息开关 true打开消息

		for(j = 0; j < jsonV.length; j++ ){
			var vFormat = jsonV[j];
			if(vFormat.Type == Type.String ){// 匹配字符串
				//alert(vFormat.Formula);
				//alert(vFormat.Formula.test(obj.value.trim()));
				if(vFormat.Expansion == null && !vFormat.Formula.test(obj.value.trim())){
					//alert(vFormat.Formula);
					flag = true;
					break;
				}else if(vFormat.Expansion != null){
					var ExpansionType = vFormat.Expansion.Type;// 扩展类型
					var ExpansionParams = vFormat.Expansion.Params;// 扩展类型
					//alert(ExpansionType);
					//alert(ExpansionParams[0]);
					if(ExpansionType == Expansion.EQLength && obj.value.trim().length != ExpansionParams[0]){//等于字符串长度
						flag = true;
						break;
					}else if(ExpansionType == Expansion.ThanLength && obj.value.trim().length <= ExpansionParams[0]){//大于字符串长度
						flag = true;
						break;
					}else if(ExpansionType == Expansion.LessThanLength && obj.value.trim().length >= ExpansionParams[0]){//小于字符串长度
						flag = true;
						break;
					}else if(obj.value.trim() != '' && ExpansionType == Expansion.EQLengthORNULL && obj.value.trim().length != ExpansionParams[0]){//等于字符串长度
						flag = true;
						break;
					}else if(obj.value.trim() != '' && ExpansionType == Expansion.ThanLengthORNULL && obj.value.trim().length <= ExpansionParams[0]){//大于字符串长度
						flag = true;
						break;
					}else if(obj.value.trim() != '' && ExpansionType == Expansion.LessThanLengthORNULL && obj.value.trim().length >= ExpansionParams[0]){//小于字符串长度
						flag = true;
						break;
					}
				}
			}else if(vFormat.Type == Type.Date ){// 匹配日期
				//alert(vFormat.Formula);
				//alert(vFormat.Formula.test(obj.value.trim()));
				if(vFormat.Expansion == null && !vFormat.Formula.test(obj.value.trim())){
					flag = true;
						break;
				}
			}else if(vFormat.Type == Type.Number ){// 匹配数字
				//alert(vFormat.Formula);
				//alert(vFormat.Formula.test(obj.value.trim()));
				if(vFormat.Expansion == null && !vFormat.Formula.test(obj.value.trim())){
					flag = true;
						break;
				} else if(vFormat.Expansion != null){
					var ExpansionType = vFormat.Expansion.Type;// 扩展类型
					var ExpansionParams = vFormat.Expansion.Params;// 扩展类型
					//alert(ExpansionType);
					//alert(ExpansionParams[0]);
					if(ExpansionType == Expansion.DecimalValidation){//验证小数点位数
						var re = new RegExp("^[-]?[0-9]+\\.[0-9]{"+ExpansionParams[0]+"}$");

						if(!re.test(obj.value.trim())){//小数点位数
							flag = true;
							break;
						}
					}
				}
			}else if(vFormat.Type == Type.Other ){// 匹配其他类型
			
				if(vFormat.Expansion == null && !vFormat.Formula.test(obj.value.trim())){
					//alert(vFormat.Formula);
					
				}
			}	
		}		

		if(flag){
			alert(vFormat.Message);
			try{
				obj.select();
			}
			catch(exception){
				obj.focus();
			}
			return false;
		}		

	}
	return true;
}

// 计算公休日和工作日
function weekendBetween(dtStart, dtEnd, flag){
	if (typeof dtEnd == 'string' )  
        dtEnd = StringToDate(dtEnd);  
    if (typeof dtStart == 'string' )  
        dtStart = StringToDate(dtStart);  
	
	var workDay = 0;//工作日
	var restDay = 0;//休息日

	do{
		if(flag == 2){
			if(/^[06]$/.test(dtStart.getDay())){// 双休日
				restDay++;
			}else{
				workDay++;
			}
		}else if(flag == 1){
			if(/^[0]$/.test(dtStart.getDay())){// 单休日
				restDay++;
			}else{
				workDay++;
			}
		}else{
		    workDay++;
		}
		
	}while(dtStart.toString() != dtEnd.toString() && DateAdd("d",1,dtStart) != null);
	
	return {'workDay' : workDay, 'restDay' : restDay};
}

function StringToDate(DateStr)  
{  
    var converted = Date.parse(DateStr);  
    var myDate = new Date(converted);  
    if (isNaN(myDate))  
    {  
        var arys= DateStr.split('-');  
        myDate = new Date(arys[0],arys[1]-1,arys[2]);  
    }  
    return myDate;  
}
function   DateAdd(interval,number,date)   
  {   
  /*   
    *---------------   DateAdd(interval,number,date)   -----------------   
    *   DateAdd(interval,number,date)     
    *   功能:实现VBScript的DateAdd功能.   
    *   参数:interval,字符串表达式，表示要添加的时间间隔.   
    *   参数:number,数值表达式，表示要添加的时间间隔的个数.   
    *   参数:date,时间对象.   
    *   返回:新的时间对象.   
    *   var   now   =   new   Date();   
    *   var   newDate   =   DateAdd("d",5,now);   
    *   author:wanghr100(灰豆宝宝.net)   
    *   update:2004-5-28   11:46   
    *---------------   DateAdd(interval,number,date)   -----------------   
    */   
          switch(interval)   
          {   
                  case   "y"   :   {   
                          date.setFullYear(date.getFullYear()+number);   
                          return   date;   
                          break;   
                  }   
                  case   "q"   :   {   
                          date.setMonth(date.getMonth()+number*3);   
                          return   date;   
                          break;   
                  }   
                  case   "m"   :   {   
                          date.setMonth(date.getMonth()+number);   
                          return   date;   
                          break;   
                  }   
                  case   "w"   :   {   
                          date.setDate(date.getDate()+number*7);   
                          return   date;   
                          break;   
                  }   
                  case   "d"   :   {   
                          date.setDate(date.getDate()+number);   
                          return   date;   
                          break;   
                  }   
                  case   "h"   :   {   
                          date.setHours(date.getHours()+number);   
                          return   date;   
                          break;   
                  }   
                  case   "m"   :   {   
                          date.setMinutes(date.getMinutes()+number);   
                          return   date;   
                          break;   
                  }   
                  case   "s"   :   {   
                          date.setSeconds(date.getSeconds()+number);   
                          return   date;   
                          break;   
                  }   
                  default   :   {   
                          date.setDate(d.getDate()+number);   
                          return   date;   
                          break;   
                  }   
          }   
  } 
  
Date.prototype.dateDiff = function(interval,objDate2) 
{ 
    var d=this, i={}, t=d.getTime(), t2=objDate2.getTime(); 
    i['y']=objDate2.getFullYear()-d.getFullYear();
    i['q']=i['y']*4+Math.floor(objDate2.getMonth()/4)-Math.floor(d.getMonth()/4); 
    i['m']=i['y']*12+objDate2.getMonth()-d.getMonth(); 
    i['ms']=objDate2.getTime()-d.getTime(); 
    i['w']=Math.floor((t2+345600000)/(604800000))-Math.floor((t+345600000)/(604800000)); 
    i['d']=Math.floor(t2/86400000)-Math.floor(t/86400000); 
    i['h']=Math.floor(t2/3600000)-Math.floor(t/3600000); 
    i['n']=Math.floor(t2/60000)-Math.floor(t/60000); 
    i['s']=Math.floor(t2/1000)-Math.floor(t/1000); 
    return i[interval]; 
}

  
//alert(weekendBetween('2009-10-19', '2009-11-4', 1).workDay); // 工作日
//alert(weekendBetween('2009-10-01', '2009-10-21', 0).restDay); // 休息日

// 中文转UTF-8
function EncodeUtf8(s1) {
   
   var stringArray = new Array();
   for(var j=0; j < $.trim(s1).length; j++){  //
       stringArray[j] = escape(s1.charAt(j)).replace("%",""); 
   }
   
   var sa = stringArray;   
   var retV = "";

   for (var i = 0; i < sa.length; i++) {       
       if ($.trim(sa[i]).length > 1 && sa[i].substring(0, 1) == "u") {
           retV += Hex2Utf8(Str2Hex(sa[i].substring(1, 5)));
       }else if($.trim(sa[i]).length == 2){
           //转义字符和标点符号
           retV += "%" + sa[i];
       } else {
           retV += sa[i];
       }
   }
   
   return retV;
}

function Str2Hex(s) {
	var c = "";
	var n;
	var ss = "0123456789ABCDEF";
	var digS = "";
	for (var i = 0; i < s.length; i++) {
	   c = s.charAt(i);
	   n = ss.indexOf(c);
	   digS += Dec2Dig(eval(n));
	}
	//return value;
	return digS;
}
function Dec2Dig(n1) {
	var s = "";
	var n2 = 0;
	for (var i = 0; i < 4; i++) {
	   n2 = Math.pow(2, 3 - i);
	   if (n1 >= n2) {
	       s += "1";
	       n1 = n1 - n2;
	   } else {
	       s += "0";
	   }
	}
	return s;
}

function Dig2Dec(s) {
	var retV = 0;
	if (s.length == 4) {
	   for (var i = 0; i < 4; i++) {
	       retV += eval(s.charAt(i)) * Math.pow(2, 3 - i);
	   }
	   return retV;
	}
	return -1;
	}

function Hex2Utf8(s) {
	var retS = "";
	var tempS = "";
	var ss = "";
	
	if (s.length == 16) {
	   tempS = "1110" + s.substring(0, 4);
	   tempS += "10" + s.substring(4, 10);
	   tempS += "10" + s.substring(10, 16);
	   var sss = "0123456789ABCDEF";
	   for (var i = 0; i < 3; i++) {
	       retS += "%";
	       ss = tempS.substring(i * 8, (eval(i) + 1) * 8);
	       retS += sss.charAt(Dig2Dec(ss.substring(0, 4)));
	       retS += sss.charAt(Dig2Dec(ss.substring(4, 8)));
	   }
	   return retS;
	}
	return "";
}
//公用的图片预览方法
//在<img 中调用需要加入： width2="600" height2="400" onclick="imgclick(this)" style="cursor: hand;"
function imgclick(src){
	var id = src.src;
	var width = $(src).attr("width2");
	var height = $(src).attr("height2");
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	
	if(is_iPad()){
		showPopWin("lookimage.action?id="+EncodeUtf8(id)+"&width="+width+"&height="+height,600,300,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin("lookimage.action?id="+EncodeUtf8(id)+"&width="+width+"&height="+height,900,500,topRows,topCols,returnRefresh(true),false);
	}
	
	document.getElementById('popupTitle').innerHTML="【模版预览--鼠标滚轮可以对图片进行放大和缩小】";
}