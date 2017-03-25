var errmsg = {
    createNew: function () {
        var obj = {};
        obj.account = [
            '未知错误' //0
            , '登入成功' //1
            , '请求异常' //2
        , '用户名和密码不能为空'//3
        , '验证码为空或者已过期'//4
        , '验证码输入不正确'//5
        , '验证码格式错误'//6
        , '两次输入密码不一致'//7
        , '密码请设为8-20位字母和数字！'//8
        , '账号格式错误（手机号/邮箱地址）'//9
        , '验证码不能为空'//10
        , '注册成功'//11
        , ''//12
        , ''//13
        , ''//14
        , ''//15
        , ''//16
        , ''//17
        , ''//18
        , ''//19
        , ''//20
        , ''//21
        ];

        obj.unknow = obj.account[0];
        obj.username = obj.account[9];
        obj.pwd = obj.account[8];
        obj.verify = obj.account[6];
        obj.unmatch = obj.account[7];

        return obj;
    }
}

function goback() {
    if (referrenIsCurrentHost() == 1) {
        history.go(-1);
    } else {
        location.href = '/';
    }
}

function referrenIsCurrentHost() {
    var refer = document.referrer;
    var isCurrentHost = 0;
    if (refer != undefined && refer != null && refer != "") {
        if (domainURI(refer) == domainURI(window.location.href)) {
            isCurrentHost = 1;
        }
    }
    return isCurrentHost;
}

function domainURI(str) {
    var durl = /http:\/\/([^\/]+)\//i;
    domain = str.match(durl);
    return domain[1];
}

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}

function _showmsg(msg, timeout)
{
    showmsg(msg);
    setTimeout(function () {
        $('#message').remove();
    }, timeout);
}

function showmsg(msg) {
    if (msg == null || msg == undefined) {
        msg = errmsg.createNew().account[0];
    }
    var err = $('#message');
    if (err == null || err == undefined || err.length == 0) {
        $('body').prepend('<div id="message" style="z-index: 99;opacity: .8;position:fixed;background:none repeat scroll 0 0 #d90077;border:1px solid #C9C9C9;color:white;margin:6px;padding:6px;border-radius:2px;text-align:center;"></div>');
        err = $('#message');
        err.width($('#main').width()-20);
    };

    msg = '<span class="close_msg" style="float: left;color:black;font-weight: bolder;">x</span>' + msg;

    err.html(msg);
    err.show();

    $('.close_msg').on('click', function () {
        $('#message').remove()
    })
}

function clearmsg()
{
    $('#message').remove();
}