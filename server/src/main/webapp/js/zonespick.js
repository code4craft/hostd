/**
 * Created with IntelliJ IDEA.
 * User: cairne
 * Date: 13-5-12
 * Time: 下午7:52
 * To change this template use File | Settings | File Templates.
 */
$(function () {
    bindSlideDown();
});

function bindSlideDown() {
    $("a#link").bind("click", function () {
        $("#hiden").slideDown("fast");
        $("i#link-icon").removeClass("icon-double-angle-down");
        $("i#link-icon").addClass("icon-double-angle-up")
        $("a#link").unbind("click");
        bindSlideUp();

    });
}

function bindSlideUp() {
    $("a#link").bind("click", function () {
        $("#hiden").slideUp("fast");
        $("i#link-icon").removeClass("icon-double-angle-up");
        $("i#link-icon").addClass("icon-double-angle-down")
        $("a#link").unbind("click");
        bindSlideDown();
    });
}
