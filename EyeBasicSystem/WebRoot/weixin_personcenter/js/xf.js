$(document).ready(function () {
	var xf_winwidth = $(window).width();
	var xf_winheight = $(window).height();
	$("html").css("fontSize",xf_winwidth/160*7+"px");
	
});
$(window).on('resize',function(){
	var xf_winwidth = $(window).width();
	var xf_winheight = $(window).height();
	$("html").css("fontSize",xf_winwidth/160*7+"px");
});
window.onload=function(){
    $(".loading").hide();
}