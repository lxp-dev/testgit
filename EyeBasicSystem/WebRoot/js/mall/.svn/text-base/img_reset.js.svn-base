//顶部大图自适应
$(document).ready(function(){
	if($(window).width() > 640){
		$(".homeFouce").find("img").width(640/1.8);
		$(".homeFouce").find("img").height(640/1.8);
		$(".homeFouce,.homeList,.homeImg,.homeList .leftmask, .homeList .rightmask").height(640/1.8);
		$(".homeList .leftmask, .homeList .rightmask").width((640 - 640/1.8)/2);
		$(".homeList .homeImg").css({marginLeft:(640 - 640/1.8)/2});
	}else if($(window).width() < 320){
		$(".homeFouce").find("img").width(320/1.8);
		$(".homeFouce").find("img").height(320/1.8);
		$(".homeFouce,.homeList,.homeImg,.homeList .leftmask, .homeList .rightmask").height(320/1.8);
		$(".homeList .leftmask, .homeList .rightmask").width((320 - 320/1.8)/2);
		$(".homeList .homeImg").css({marginLeft:(320 - 320/1.8)/2});
	} else{
		$(".homeFouce").find("img").width($(window).width()/1.8);
		$(".homeFouce").find("img").height($(window).width()/1.8);
		$(".homeFouce,.homeList,.homeImg,.homeList .leftmask, .homeList .rightmask").height($(window).width()/1.8);
		$(".homeList .leftmask, .homeList .rightmask").width(($(window).width() - $(window).width()/1.8)/2);
		$(".homeList .homeImg").css({marginLeft:($(window).width() - $(window).width()/1.8)/2});
	}
});