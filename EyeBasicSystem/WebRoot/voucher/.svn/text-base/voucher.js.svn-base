var Cursor = {
    getCurPos: function (ctrl) {
        var CaretPos = 0;
        if (document.selection && "undefined" != typeof document.selection) {
            ctrl.focus();
            var Sel = document.selection.createRange();
            Sel.moveStart('character', -ctrl.value.length);
            CaretPos = Sel.text.length;
        }else if (ctrl.selectionStart || ctrl.selectionStart == '0')
            CaretPos = ctrl.selectionStart;
        return (CaretPos);
    },
    setCurPos: function (ctrl, index) {
        if (ctrl.createTextRange && "undefined" != typeof ctrl.createTextRange) {
            var range = ctrl.createTextRange();
            range.collapse(true);
            range.moveEnd('character', index);
            range.moveStart('character', index);
            range.select();
        } else if (ctrl.setSelectionRange) {
            ctrl.focus();
            ctrl.setSelectionRange(index, index);
        }
    }
}

KeyCode = {
	    BackSpace: 8,
	    Tab: 9,
	    Enter: 13,
	    Shift: 16,
	    Ctrl: 17,
	    Alt: 18,
	    Pause: 19,
	    Caps_Lock: 20,
	    Escape: 27,
	    Space: 32,
	    PageUp: 33,
	    Next: 34,
	    End: 35,
	    Home: 36,
	    Left: 37,
	    Up: 38,
	    Right: 39,
	    Down: 40,

	    Select: 41,
	    Print: 42,
	    Execute: 43,
	    Insert: 45,
	    Delete: 46,
	    Help: 47,

	    A: 65,
	    B: 66,
	    C: 67,
	    D: 68,
	    E: 69,
	    F: 70,
	    G: 71,
	    H: 72,
	    I: 73,
	    J: 74,
	    K: 75,
	    L: 76,
	    M: 77,
	    N: 78,
	    O: 79,
	    P: 80,
	    Q: 81,
	    R: 82,
	    S: 83,
	    T: 84,
	    U: 85,
	    V: 86,
	    W: 87,
	    X: 88,
	    Y: 89,
	    Z: 90,

	    Zero:48,
	    One:49,
	    Two:50,
	    Three:51,
	    Four:52,
	    Five:53,
	    Six:54,
	    Seven:55,
	    Eight:56,
	    Nine:57,

	    //小键盘
	    KP_0: 96,
	    KP_1: 97,
	    KP_2: 98,
	    KP_3: 99,
	    KP_4: 100,
	    KP_5: 101,
	    KP_6: 102,
	    KP_7: 103,
	    KP_8: 104,
	    KP_9: 105,
	    KP_Multiply: 106,
	    KP_Add: 107,
	    KP_Separator: 108,
	    KP_Subtract: 109,
	    KP_Decimal_Point: 110, //小数点
	    KP_Decimal_PointKeyEn: 190, //小数点非小键盘区域
	    KP_Decimal_PointKeyCn: 229, //小数点非小键盘区域
	    KP_Divide: 111, //小键盘“/”

	    F1: 112,
	    F2: 113,
	    F3: 114,
	    F4: 115,
	    F5: 116,
	    F6: 117,
	    F7: 118,
	    F8: 119,
	    F9: 120,
	    F10: 121,
	    F11: 122,
	    F12: 123,

	    Subtract:189
	};

var vchHelper = {};

vchHelper.IsAmountGTZero = function ($currInput) {
	return $currInput.css("color") == "#000000" || $currInput.css("color") == "rgb(0, 0, 0)";
}

function parseString(charCode) {
    if (charCode >= KeyCode.Zero && charCode <= KeyCode.Nine) {
        return (charCode - KeyCode.Zero).toString();
    }
    if (charCode >= KeyCode.KP_0 && charCode <= KeyCode.KP_9) {
        return (charCode - KeyCode.KP_0).toString();
    }
    if (charCode === 110) {
        return ".";
    }
    return "";
}

$(document).ready(function () { 
	bindFun();
});

function unBindFun() { 
	$("#tb_voucher > tbody input.debite, #tb_voucher > tbody input.credit").unbind('focus');
	$("#tb_voucher > tbody input.debite, #tb_voucher > tbody input.credit").unbind('blur');	
	$("#tb_voucher > tbody input.debite, #tb_voucher > tbody input.credit").unbind('mouseup');
	$("#tb_voucher > tbody input.debite, #tb_voucher > tbody input.credit").unbind('keydown');	
	$("#tb_voucher > tbody input.debite, #tb_voucher > tbody input.credit").unbind('keyup');
}

function bindFun() {    
    //----------------------------借方贷方begin------------------------------ 
	vchHelper.CalTotalAmount();
	
    //借方贷方事件
    $("#tb_voucher > tbody input.debite, #tb_voucher > tbody input.credit").bind('focus', function () {
        var $val = $(this).val();
        if (!$val) {
            $(this).val("000");
            Cursor.setCurPos($(this)[0], 0);
            $(this).data("cursorIndex", 0);
        }
        else {
            var cusorIndex = $(this).data("cursorIndex");
            Cursor.setCurPos($(this)[0], cusorIndex == null ? 0 : cusorIndex);
        }
        return false;
    }).bind('blur', function () {
        var $val = $(this).val();
        if ($val == "000") {
            $(this).val("000");
        }
    }).bind("mouseup", function () {
        $(this).data("cursorIndex", Cursor.getCurPos($(this)[0]));
    })
    .bind("keydown", function (e) {
        var $currInput = $(this);    
        switch (e.keyCode) {
            case KeyCode.Subtract: //"-"号显示红色
            case KeyCode.KP_Subtract: //"-"号显示红色
           
                if (vchHelper.IsAmountGTZero($currInput)) {
                    $currInput.css("color", "#ff0000");
                }
                else {
                    $currInput.css("color", "#000000");
                }
                return false;
                break;
            case KeyCode.BackSpace:
                var o;
                var word = ''; //选中值
                var count = 0;
                if ("undefined" == typeof document.selection ) {
                    o = window.getSelection().toString(); 
                    if (o.length > 0){
                    	word = o;
                    }
                    count = o.length;
                }
                if (document.selection && "undefined" != typeof document.selection ) {
                    o = document.selection.createRange();
                    if (o.text.length > 0){
                    	word = o.text;
                    } 
                    count = o.text.length;
                }
                
                var cursorIndex = $currInput.data("cursorIndex");
                var currValue = $currInput.val();
                var valueLen = currValue.length;

                if (count == 0) {
                    if (cursorIndex == null) cursorIndex = 0;
                    if (cursorIndex < (currValue.length - 2)) {//光标在整数位有效
                        if (cursorIndex != 0) {
                            $currInput.val(currValue.substring(0, cursorIndex - 1) + currValue.substring(cursorIndex, valueLen));

                            Cursor.setCurPos($currInput[0], (cursorIndex - 1));
                            $(this).data("cursorIndex", cursorIndex - 1);
                        }
                        else {
                            if (currValue.length == 3) {
                                $currInput.val("0" + currValue.substring(1, valueLen));
                            }
                            else {
                                $currInput.val(currValue.substring(1, valueLen));
                            }

                            Cursor.setCurPos($currInput[0], 1);
                            $(this).data("cursorIndex", 1);
                        }
                    }
                    else {
                        //光标在小数位
                        if (currValue.length == 3 && currValue.substring(0, 1) == "0") {
                            if (currValue.substr(0, 2) == "00") {
                                $currInput.val("000");

                                Cursor.setCurPos($currInput[0], 0);
                                $(this).data("cursorIndex", 0);
                            }
                            else {
                                $currInput.val("00" + currValue.substr(2, 1));
                                Cursor.setCurPos($currInput[0], 2);
                                $(this).data("cursorIndex", 2);
                            }

                        }
                        else {
                            if (currValue.length == 3 && currValue.substring(0, 1) != "0") {
                                if (cursorIndex == 1) {
                                    $currInput.val("0" + currValue.substr(1, 2));
                                    Cursor.setCurPos($currInput[0], 1);
                                }
                                else if (cursorIndex == 2) {
                                    $currInput.val("0" + currValue.substr(1, 2));
                                    Cursor.setCurPos($currInput[0], 2);
                                }
                            }
                            else {
                                $currInput.val(currValue.substring(0, cursorIndex - 1) + currValue.substring(cursorIndex, valueLen));
                                Cursor.setCurPos($currInput[0], (cursorIndex - 1));
                                $(this).data("cursorIndex", cursorIndex - 1);
                            }
                        }
                    }
                }
                else {
                    if (count == valueLen) {
                        $currInput.val("000");
                    }
                    else {
                        if ((valueLen - count) > 2) {
                            $currInput.val(currValue.substring(0, (valueLen - count)));
                        }
                        else {
                            if ((valueLen - count) == 2)
                                $currInput.val("0" + currValue.substring(0, 2));
                            if ((valueLen - count) == 1)
                                $currInput.val("00" + currValue.substring(0, 1));
                        }
                    }
                    Cursor.setCurPos($currInput[0], 0);
                }
                return false;
                break;
            case KeyCode.Escape: //esc快速删除
                $currInput.val("000");
                Cursor.setCurPos($currInput[0], 0);
                $(this).data("cursorIndex", 0);
                vchHelper.CalTotalAmount();
                return false;
                break;
            case KeyCode.Delete:
                var word = ''; //选中值
                var o;
                var count = 0;
                if ("undefined" == typeof document.selection ) {
                    o = window.getSelection().toString(); 
                    if (o.length > 0){
                    	word = o;
                    }
                    count = o.length;
                }
                if (document.selection && "undefined" != typeof document.selection ) {
                    o = document.selection.createRange();
                    if (o.text.length > 0){
                    	word = o.text;
                    } 
                    count = o.text.length;
                }

                var cursorIndex = $currInput.data("cursorIndex"); //当前光标位置
                var currValue = $currInput.val(); //当前输入值（按键前）
                var valueLen = currValue.length; //当前输入值长度（按键前） 

                if (count == 0) {
                    if (cursorIndex == null) cursorIndex = 0;

                    if (cursorIndex < (valueLen - 2)) {
                    	//光标在整数位
                        if (valueLen == 3) {
                            $currInput.val("0" + currValue.substring(1, 3));
                            Cursor.setCurPos($currInput[0], 0);
                            $(this).data("cursorIndex", 0);
                        }
                        else {
                            $currInput.val(currValue.substring(0, cursorIndex) + currValue.substring(cursorIndex + 1, valueLen));
                            cursorIndex = cursorIndex - 1;
                            if (cursorIndex < 0) cursorIndex = 0;
                            Cursor.setCurPos($currInput[0], cursorIndex);
                            $(this).data("cursorIndex", cursorIndex);
                        }

                    }
                    else {
                        if (cursorIndex == (valueLen - 2)) {
                            $currInput.val(currValue.substring(0, cursorIndex) + currValue.charAt(valueLen - 1) + "0");
                            Cursor.setCurPos($currInput[0], cursorIndex);
                        }
                        else {
                            $currInput.val(currValue.substring(0, valueLen - 1) + "0");
                            Cursor.setCurPos($currInput[0], cursorIndex);
                        }

                    }
                }
                else {
                    if (count == valueLen) {
                        $currInput.val("000");
                    }
                    else {
                        if ((valueLen - count) > 2) {
                            $currInput.val(currValue.substring(0, (valueLen - count)));
                        }
                        else {
                            if ((valueLen - count) == 2){
                            	$currInput.val("0" + currValue.substring(0, 2));
                            }                                
                            if ((valueLen - count) == 1){
                            	$currInput.val("00" + currValue.substring(0, 1));
                            } 
                        }
                    }
                    Cursor.setCurPos($currInput[0], 0);
                    $(this).data("cursorIndex", 0);
                }

                return false;
                break;
            default: break;
        }

        if (e.keyCode == KeyCode.KP_Decimal_Point || e.keyCode == KeyCode.KP_Decimal_PointKeyEn || e.keyCode == KeyCode.KP_Decimal_PointKeyCn) {
            //光标设为倒数第二个位置（小数位第一位前面）
            var index = $currInput.val().length - 2
            Cursor.setCurPos($currInput[0], index);
            $(this).data("cursorIndex", index);

            return false;
        } else if ((e.keyCode >= KeyCode.Zero && e.keyCode <= KeyCode.Nine) || (e.keyCode >= KeyCode.KP_0 && e.keyCode <= KeyCode.KP_9)) {

            var cursorIndex = $currInput.data("cursorIndex"); //当前光标位置  
            currValue = $currInput.val(); //当前输入值（按键前）
            valueLen = currValue.length; //当前输入值长度（按键前） 
            if (cursorIndex == null || cursorIndex == undefined) cursorIndex = 0;
            if (cursorIndex < (valueLen - 2)) {
                //光标在整数位

                if (currValue.length > 13) return false; //输入过长

                if (cursorIndex == 0 && currValue.charAt(0) == '0') {//第一次输入
                    $currInput.val(parseString(e.keyCode) + currValue.substring(valueLen - 2, valueLen));
                    Cursor.setCurPos($currInput[0], 0);
                }
                else {
                    if (cursorIndex == 0) {
                        //光标在最前面，则把往第一位后插入输入的字符
                        $currInput.val(currValue.substring(0, 1) + parseString(e.keyCode) + currValue.substring(cursorIndex+1, valueLen));
                        Cursor.setCurPos($currInput[0], cursorIndex + 1);
                        $(this).data("cursorIndex", cursorIndex + 1);
                    } else {
                        //光标非最前面，则把往光标所在数字位（如千、百、十为，非当前光标位置）插入输入的字符 
                        $currInput.val(currValue.substring(0, cursorIndex + 1) + parseString(e.keyCode) + currValue.substring(cursorIndex + 1, valueLen));
                        Cursor.setCurPos($currInput[0], cursorIndex + 1);
                        $(this).data("cursorIndex", cursorIndex + 1);

                    }
                }

            }
            else {
                //光标在小数位  
                if ($currInput.val() == "000") {
                    if (currValue.length > 13) return false; //输入过长 

                    var currInput = $currInput.val();
                    if ($currInput.data("cursorIndex") == 1) {
                        $(this).data("cursorIndex", 2);
                        Cursor.setCurPos($currInput[0], 2);
                        $currInput.val('0' + parseString(e.keyCode) + currInput.substring(1, 2));
                    }
                    else {

                        $currInput.val($currInput.val().substring(0, 2) + parseString(e.keyCode));
                        Cursor.setCurPos($currInput[0], 2);
                    }

                }
                else {
                    if ($currInput.val().substring(0, 1) == "0") {
                        var currInput = $currInput.val();
                        if (cursorIndex == 1) {
                            $currInput.val('0' + parseString(e.keyCode) + currInput.substring(1, 2));
                            Cursor.setCurPos($currInput[0], 2);
                            $(this).data("cursorIndex", 2);
                        }
                        else {
                            $currInput.val($currInput.val().substring(0, 2) + parseString(e.keyCode));
                            Cursor.setCurPos($currInput[0], 2);
                        }

                    }
                    else {
                        if (cursorIndex == (valueLen - 2)) {
                            $currInput.val(currValue.substring(0, valueLen - 2) + parseString(e.keyCode) + currValue.charAt(valueLen - 1));
                            Cursor.setCurPos($currInput[0], valueLen - 1);
                            $(this).data("cursorIndex", valueLen - 1);
                        }
                        else if (cursorIndex == (valueLen - 1)) {
                            $currInput.val(currValue.substring(0, valueLen - 1) + parseString(e.keyCode));
                            Cursor.setCurPos($currInput[0], valueLen - 1);
                            //$(this).data("cursorIndex", valueLen);不必移到最后位置
                        }
                        else {
                            $currInput.val(currValue.substring(0, valueLen - 1) + parseString(e.keyCode));
                            //return false; //光标在最后位置，不录入
                        }
                    }
                }

            }


            vchHelper.CalTotalAmount();
            return false;
        }

        //非数字键 方向键
        if (!((e.keyCode > 32 && e.keyCode < 41)
                    )) { return false; }

    }).bind('keyup', function (e) {

        $currInput = $(this);
        var cursorIndex = Cursor.getCurPos($(this)[0]);     
        if (e.keyCode >= KeyCode.PageUp && e.keyCode <= KeyCode.Down && cursorIndex <= $currInput.val().length) {
            $currInput.data("cursorIndex", cursorIndex);
        }
        if (e.keyCode >= KeyCode.PageUp && e.keyCode <= KeyCode.Down && cursorIndex >= 0) {
            $currInput.data("cursorIndex", cursorIndex);
        }

        if (e.keyCode == 109 || e.keyCode == 187 || e.keyCode == 189 || e.keyCode == KeyCode.Space || e.keyCode == KeyCode.Delete || e.keyCode == KeyCode.BackSpace) {
            vchHelper.CalTotalAmount();
        }
    });

    //----------------------------借方贷方end------------------------------

}


//计算合计金额
vchHelper.CalTotalAmount = function () {
	
//	amount();
	
    //计算借方金额总和
    var TotalDebite = vchHelper.CalculateTotalAccountAmount($("#tb_voucher > tbody input.debite"));
    if (TotalDebite < 0) {
        $("#debitMoneyTotal").val(0 - TotalDebite).css("color", "#ff0000");
    } else {
        $("#debitMoneyTotal").val(TotalDebite).css("color", "#000000");
    }
    
    //计算贷方金额总和
    var TotalCredit = vchHelper.CalculateTotalAccountAmount($("#tb_voucher > tbody input.credit"));
    if (TotalCredit < 0) {
        $("#lenderMoneyTotal").val(0 - TotalCredit).css("color", "#ff0000");
    } else {
        $("#lenderMoneyTotal").val(TotalCredit).css("color", "#000000");
    }

//    var arr_num = ["零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"];
//    var arr_unit = ["分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟"];
//    //显示合计项
//    if (TotalDebite === TotalCredit) {
//        var $ValTemp = $("#lenderMoneyTotal").val();
//        var $LenTemp = $("#lenderMoneyTotal").val().length;
//        var $LenOk = $("#lenderMoneyTotal").val().length;
//        var AmountWords = "";
//
//        if ($ValTemp.slice(-2) == "00") {
//            for (var i = 0; i < $LenTemp - 2; i++) {
//                var temp = arr_num[$ValTemp.charAt(i)] + arr_unit[--$LenOk];               
//                AmountWords += temp;
//            }
//            AmountWords = AmountWords + "整";
//        } else {
//            for (var i = 0; i < $LenTemp; i++) {
//                var temp = arr_num[$ValTemp.charAt(i)] + arr_unit[--$LenOk];
//                AmountWords += temp;
//            }
//        }
//        if (TotalDebite >= 0)
//            $("#AmountWords").val(AmountWords).css("color", "#000000");
//        else
//            $("#AmountWords").val("负" + AmountWords).css("color", "#ff0000");
//    } else {
//        $("#AmountWords").val("")
//    }
    
};

//计算借方or贷方总数
vchHelper.CalculateTotalAccountAmount = function ($inputs) {
    var total = 0, value, $currInput;
    for (var index = 0; index < $inputs.length; index++) {
        $currInput = $($inputs[index]);
        value = $currInput.val();

        if (value == null || value.length < 1) continue;
        //注意负数
        if (vchHelper.IsAmountGTZero($currInput)) {
            if (value || value != "") {
                total += parseFloat(value);
            }
        }
        else {
            total -= parseFloat(value);
        }
    }
    return total
}

