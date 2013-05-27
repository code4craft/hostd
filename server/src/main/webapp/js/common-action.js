/**
 * Created with IntelliJ IDEA.
 * User: cairne
 * Date: 13-5-12
 * Time: 下午9:14
 * To change this template use File | Settings | File Templates.
 */

function apply(text) {
    $.ajax({
            url: "/apply/",
            data: {
                text: text
            },
            method: "post"
        }
    ).done(function (data) {
            if (data["code"] == 200) {
                alert(data["msg"])
            } else {
                alert(data["msg"])
            }
        });
}

function pick(text) {
    console.log(text)
    $.ajax({
            url: "/pick",
            data: {
                json: text
            },
            method: "post"
        }
    ).done(function (data) {
            if (data["code"] == 200) {
                alert(data["msg"])
            } else {
                alert(data["msg"])
            }
        });
}

function save(id) {
    $.ajax({
            url: "/edit/save/" + id,
            method: "post",
            data: {
                text:myCodeMirror.getValue(),
                name:$("#zones-name").val()
            }
        }
    ).done(function (data) {
            if (data["code"] == 200) {
                alert("保存成功！")
            } else {
                alert("保存失败！")
            }
        });
}

function save(id) {
    $.ajax({
            url: "/edit/save/" + id,
            method: "post",
            data: {
                text:myCodeMirror.getValue(),
                name:$("#zones-name").val()
            }
        }
    ).done(function (data) {
            if (data["code"] == 200) {
                alert(data["msg"])
            } else {
                alert(data["msg"])
            }
        });
}

function del(id) {
    $.ajax({
            url: "/edit/delete/" + id
        }
    ).done(function (data) {
            if (data["code"] == 200) {
                alert(data["msg"])
            } else {
                alert(data["msg"])
            }
        });
}