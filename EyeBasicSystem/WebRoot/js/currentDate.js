﻿    /** 
     * 时间对象的格式化
     */  
    Date.prototype.format = function(format) {  
        /* 
         * eg:format="YYYY-MM-dd hh:mm:ss"; 
         */  
        var o = {  
            "M+" :this.getMonth() + 1, // month  
            "d+" :this.getDate(), // day  
            "h+" :this.getHours(), // hour  
            "m+" :this.getMinutes(), // minute  
            "s+" :this.getSeconds(), // second  
            "q+" :Math.floor((this.getMonth() + 3) / 3), // quarter  
            "S" :this.getMilliseconds()  
        // millisecond  
        }  
      
        if (/(y+)/.test(format)) {  
            format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
        }  
      
        for ( var k in o) {  
            if (new RegExp("(" + k + ")").test(format)) {  
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));  
            }  
        }  
        return format;  
    }
	
    /** 
     * 取当天日期
     */ 
	function today(startTime,endTime){		
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById(startTime).value = now;
		document.getElementById(endTime).value = now;
	}
    /** 
     * 取昨天日期
     */ 
	function yesterday(startTime,endTime){		
		//获取系统时间 
		var LSTR_ndate=new Date(); 
		var LSTR_Year=LSTR_ndate.getFullYear();
		var LSTR_Month=LSTR_ndate.getMonth(); 
		var LSTR_Date=LSTR_ndate.getDate(); 
		//处理 
		var uom = new Date(LSTR_Year,LSTR_Month,LSTR_Date); 
		uom.setDate(uom.getDate()-1);//取得系统时间的前一天,重点在这里,负数是前几天,正数是后几天 
		var LINT_MM=uom.getMonth(); 
		LINT_MM++; 
		var LSTR_MM=LINT_MM >= 10?LINT_MM:("0"+LINT_MM) 
		var LINT_DD=uom.getDate(); 
		var LSTR_DD=LINT_DD >= 10?LINT_DD:("0"+LINT_DD) 
		//得到最终结果 
		uom = uom.getFullYear() + "-" + LSTR_MM + "-" + LSTR_DD; 
		document.getElementById(startTime).value = uom;
		document.getElementById(endTime).value = uom;
	}
	
    /** 
     * 取当月日期
     */ 
	function currtMonth(startTime,endTime){		
	    var date = new Date().format("yyyy-MM-dd");
	    var currDate = new Date(date.substring(0,4),date.substring(5,7),0);
        $('#'+startTime).val(date.substring(0,4)+"-"+date.substring(5,7) + '-01');
        $('#'+endTime).val(date.substring(0,4)+"-"+date.substring(5,7) + '-' + currDate.getDate());	    
	}