$(function () {
    /*单品页、套装页-产品图效果*/
    $('#homeFouce').slideLayer({ wrapEl: '.homeList', slideEl: '.homeList .homeImg', childEl: '.homeList li', prev: ".leftmask", next: ".rightmask" });

    /*购物车动画*/
    $(".inf_two .add .input1").click(function () {
        $(".animateCar").addClass("onanimateCar");
        $(".shopAnimate .animateLeft span a").addClass("on");
        $(".shopAnimate .animateLeft span a").addClass("off");
        setTimeout(autohidden, 1000);
        setTimeout(autoright, 2000);
    })
    function autohidden() {
        $(".animateCar").removeClass("onanimateCar");
        $(".shopAnimate .animateNum").show();
    }
    function autoright() {
        $(".shopAnimate .animateLeft span a").removeClass("on");
    }
})