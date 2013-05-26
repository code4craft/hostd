/**
 * Created with IntelliJ IDEA.
 * User: cairne
 * Date: 13-5-12
 * Time: 下午7:52
 * To change this template use File | Settings | File Templates.
 */
$(function () {
    bindSlideUp($("a#fold-button"));
});

function bindSlideDown(e) {
    e.bind("click", function () {
        var ul = $(this).parent().parent();
        var foldUl = ul.children("#configs").children("ul");
        foldUl.slideDown("fast");
        var i = $(this).children("i#fold-icon");
        i.removeClass("icon-double-angle-down");
        i.addClass("icon-double-angle-up")
        $(this).unbind("click");
        bindSlideUp($(this));

    });
}

function bindSlideUp(e) {
    e.bind("click", function () {
        var ul = $(this).parent().parent();
        var foldUl = ul.children("#configs").children("ul");
        foldUl.slideUp("fast");
        var i = $(this).children("i#fold-icon");
        i.removeClass("icon-double-angle-up");
        i.addClass("icon-double-angle-down")
        $(this).unbind("click");
        bindSlideDown($(this));
    });
}
