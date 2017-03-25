$(document).ready(function(){
	
	funcfoucs();
	
	$(".pict").hover(function(){
		$(this).addClass("jhover");
	},function(){
		$(this).removeClass("jhover");
	});
	
});

/*----- EASING ------*/
jQuery.extend( jQuery.easing,{
	def: 'easeOutQuint',
	swing: function (x, t, b, c, d) {
		return jQuery.easing[jQuery.easing.def](x, t, b, c, d);
	},
	easeOutQuint: function (x, t, b, c, d) {
		return c*((t=t/d-1)*t*t*t*t + 1) + b;
	}
});

function funcfoucs(){
	
	var _imgArray = new Array();
	
	$("#foucs").find(".main").css({
		"position":"absolute"
	});
	for(var i = 0 ; i < $("#foucs").find(".element").length ;i++){
		if($("#foucs").find(".element").eq(i).find("img").attr("src")){
			_imgArray.push($("#foucs").find(".element").eq(i).find("img").attr("src"));
		}
	}
	if(/*@cc_on!@*/false){
		//IE
		setTimeout(startslide,400);
	}else{
		//Non IE
		if(_imgArray.length){
			loopImageLoader(0);
		}else{
			setTimeout(startslide,400);
		}
	}
	
	function loopImageLoader(i){
	  var image1 = new Image();
	  image1.src = _imgArray[i];
	  image1.onload = function(){
		i++;
		if(_imgArray.length != i){
		  loopImageLoader(i);
		}else{
			startslide();
		}
	  }
	}
	
	
	var _maxpage = 0;
	var _currentpage = 0;
	
	function startslide(){
		$("#foucs").find(".element").css("display","inline-block");
		
		$("#foucs").find(".right").hide();
		$("#foucs").find(".left").hide();
		
		$("#foucs").find(".right").fadeIn(600);
		$("#foucs").find(".left").fadeIn(600);
		

		_maxpage = $("#foucs").find(".pict").length;
		
		for(var i = 0 ; i < _maxpage ; i++){
			var _pos = Math.round(800*(i-_currentpage)+$(window).width()/2-400);
			var _opa = 0.5;
			if(i == _currentpage)_opa = 1;
			if(_pos > $(window).width()){
				_pos -= _maxpage*800
			}else if(_pos < -800){
				_pos += _maxpage*800
			}
			$("#foucs").find(".pict").eq(i).css({
				left:_pos,
				opacity:0
			})
			.animate({
				opacity:_opa
			},{
				duration:400 ,
				easing:'linear'
			})
		}
		$("#foucs").stop().find(".main").removeClass("main");
		$("#foucs").stop().find(".pict").eq(_currentpage).addClass("main").css({"position":"absolute"});
		
		
		window.onresize = function(){
			for(var i = 0 ; i < _maxpage ; i++){
				var _pos = Math.round(800*(i-_currentpage)+$(window).width()/2-400);
				var _opa = 0.5;
				if(i == _currentpage)_opa = 1;
				if(_pos > $(window).width()){
					_pos -= _maxpage*800
				}
				$("#foucs").stop().find(".pict").eq(i).css({
					left:_pos,
					opacity:_opa
				})
			}
		}
		$("#foucs").find(".right").click(nextPage);
		$("#foucs").find(".left").click(prevPage);
	}

	
	function nextPage(){
		_currentpage++;
		if(_currentpage >  _maxpage-1)_currentpage = 0;
		$("#foucs").stop().find(".main").removeClass("main");
		$("#foucs").stop().find(".pict").eq(_currentpage).addClass("main").css({"position":"absolute"});;
		_pict = $("#foucs").find(".pict");
		for(var i = 0 ; i < _maxpage ; i++){
			var _pos = Math.round(800*(i-_currentpage)+$(window).width()/2-400);
			var _opa = 0.5;
			if(i == _currentpage)_opa = 1;
			if(_pos > $(window).width()){
				_pos -= _maxpage*800
			}else if(_pos < -800*2){
				_pos += _maxpage*800
			}
			_pict.eq(i)
			.stop()
			.css({
				left:_pos+800
			})
			.animate({
				left:_pos,
				opacity:_opa
			},{
				duration:700 ,
				easing:'easeOutQuint'
			})
		}
	}
	
	function prevPage(){
		_currentpage--;
		if(_currentpage< 0)_currentpage = _maxpage -1;
		$("#foucs").stop().find(".main").removeClass("main");
		$("#foucs").stop().find(".pict").eq(_currentpage).addClass("main").css({"position":"absolute"});;
		for(var i = 0 ; i < _maxpage ; i++){
			var _pos = Math.round(800*(i-_currentpage)+$(window).width()/2-400);
			var _opa = 0.5;
			if(i == _currentpage)_opa = 1;
			if(_pos < -800){
				_pos += _maxpage*800
			}else if(_pos > $(window).width()+800){
				_pos -= _maxpage*800
			}
			$("#foucs").find(".pict").eq(i)
			.stop()
			.css({
				left:_pos-800
			})
			.animate({
				left:_pos,
				opacity:_opa
			},{
				duration:700 ,
				easing:'easeOutQuint'
			})
		}
	}
	
	
}