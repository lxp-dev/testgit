//乘法函数，用来得到精确的乘法结果
//说明：javascript的乘法结果会有误差，在两个浮点数相乘的时候会比较明显。这个函数返回较为精确的乘法结果。
//调用：accMul(arg1,arg2)
//返回值：arg1乘以arg2的精确结果
function accMul(arg1,arg2)
{
	var m=0,s1=arg1.toString(),s2=arg2.toString();
	try{m+=s1.split(".")[1].length}catch(e){}
	try{m+=s2.split(".")[1].length}catch(e){}
	return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m)
}
// 给Number类型增加一个mul方法，调用起来更加方便。
Number.prototype.mul = function (arg){
	return accMul(arg, this);
}

// 除法函数，用来得到精确的除法结果
// 说明：javascript的除法结果会有误差，在两个浮点数相除的时候会比较明显。这个函数返回较为精确的除法结果。
// 调用：accDiv(arg1,arg2)
// 返回值：arg1除以arg2的精确结果
function accDiv(arg1,arg2){
	var t1=0,t2=0,r1,r2;
	try{t1=arg1.toString().split(".")[1].length}catch(e){}
	try{t2=arg2.toString().split(".")[1].length}catch(e){}
	with(Math){
	r1=Number(arg1.toString().replace(".",""))
	r2=Number(arg2.toString().replace(".",""))
	return (r1/r2)*pow(10,t2-t1);
	}
}
// 给Number类型增加一个div方法，调用起来更加方便。
Number.prototype.div = function (arg){
	return accDiv(this, arg);
}

// 加法函数，用来得到精确的加法结果
// 说明：javascript的加法结果会有误差，在两个浮点数相加的时候会比较明显。这个函数返回较为精确的加法结果。
// 调用：accAdd(arg1,arg2)
// 返回值：arg1加上arg2的精确结果
function accAdd(arg1,arg2){
    var r1,r2,m;
    try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
    try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
    m=Math.pow(10,Math.max(r1,r2))
    return (accMul(arg1,m)+accMul(arg2,m))/m;
}

// 给Number类型增加一个add方法，调用起来更加方便。
Number.prototype.add = function (arg){
    return accAdd(arg,this);
}

// 说明：javascript的减法结果会有误差，在两个浮点数相加的时候会比较明显。这个函数返回较为精确的减法结果。
// 调用：accSub(arg1,arg2)
// 返回值：arg1减上arg2的精确结果
function accSub(arg1,arg2){ 
	return accAdd(arg1,-arg2); 
} 
// 给Number类型增加一个sub方法，调用起来更加方便。
Number.prototype.sub = function (arg){ 
	return accSub(this,arg); 
}

Number.prototype.toFixed = function(d) 
{ 
var s=this+"";
if(!d)d=0; 
if(s.indexOf(".")==-1)
	s+=".";
	s+=new Array(d+1).join("0"); 
if (new RegExp("^(-|\\+)?(\\d+(\\.\\d{0,"+ (d+1) +"})?)\\d*$").test(s)){ 
	var s="0"+ RegExp.$2, pm=RegExp.$1, a=RegExp.$3.length, b=true; 
if (a==d+2){a=s.match(/\d/g); if (parseInt(a[a.length-1])>4){ 
	for(var i=a.length-2; i>=0; i--) {
		a[i] = parseInt(a[i])+1; 
	if(a[i]==10){
		a[i]=0; 
		b=i!=1;
	} else break;} 
} 
s=a.join("").replace(new RegExp("(\\d+)(\\d{"+d+"})\\d$"),"$1.$2"); 
}if(b)s=s.substr(1);return (pm+s).replace(/\.$/, "");} return this+""; 
};

//减法
function Subtr(arg1,arg2){
	 var r1,r2,m,n;
	 try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
	 try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
	 m=Math.pow(10,Math.max(r1,r2));
	 //last modify by deeka
	 //动态控制精度长度
	 n=(r1>=r2)?r1:r2;
	 return -((arg1*m-arg2*m)/m).toFixed(n);
}

//给Number类型增加一个Subtr方法，调用起来更加方便。 
Number.prototype.minus = function (arg){ 
	return Subtr(arg,this); 
}