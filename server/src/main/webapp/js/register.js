/**
 * Created with IntelliJ IDEA.
 * User: cairne
 * Date: 13-5-12
 * Time: 下午7:52
 * To change this template use File | Settings | File Templates.
 */
function bindRegister() {
    $("#register-button").bind("click", function () {
        if ($("#password").val() != $("#repassword").val()) {
            alert("两次密码输入不一致，请重新输入！");
        } else {
            register($("#username").val(), $("#password").val());
        }
    });
}

$(function () {
    bindRegister();
});

function register(username, password) {
    $.ajax({
            url: "/register",
            method: "post",
            data: {
                username: username,
                password: password
            }
        }
    ).
        done(function (data) {
            if (data["code"] == 200) {
                alert(data["msg"]);
                setTimeout("window.location.href=\"/\"", 1000);
            } else {
                alert(data["msg"])
            }
        });
}
