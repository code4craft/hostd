/**
 * Created with IntelliJ IDEA.
 * User: cairne
 * Date: 13-5-12
 * Time: 下午7:52
 * To change this template use File | Settings | File Templates.
 */
function bindLogin() {
    $("#login-button").bind("click", function () {
        login($("#username").val(), $("#password").val());
    });
}

function bindRegister() {
    $("#register-button").bind("click", function () {
        window.location.href="/register";
    });
}

$(function () {
    bindLogin();
    bindRegister();
});

function login(username, password) {
    $.ajax({
            url: "/login",
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
