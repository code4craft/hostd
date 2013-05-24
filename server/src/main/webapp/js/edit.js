/**
 * Created with IntelliJ IDEA.
 * User: cairne
 * Date: 13-5-12
 * Time: 下午7:52
 * To change this template use File | Settings | File Templates.
 */

function bindApply() {
    $("a#apply-a").bind("click", function () {
        apply(myCodeMirror.getValue());
    });
}

function bindEdit() {
    $("a#save").bind("click", function () {
        save($(this).attr("file-id"))
    });
}

function bindDel() {
    $("a#del").bind("click", function () {
        del($(this).attr("file-id"));
        setTimeout("window.location.href=\"/\"",1000);
    });
}

$(function () {
    myCodeMirror = CodeMirror.fromTextArea($("#code").get(0), {
        mode: "javascript",
        theme: "solarized"
    });
    bindApply();
    bindEdit();
    bindDel();
});
