/**
 * Created with IntelliJ IDEA.
 * User: cairne
 * Date: 13-5-12
 * Time: 下午7:52
 * To change this template use File | Settings | File Templates.
 */
$(function () {
    bindSlideUp($("a#fold-button"));
    bindAcitve();
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

function bindAcitve() {
    $("a#active-button").bind("click", function () {
        var li = $(this).parent("li");
        var i = li.attr("domain-index");
        var j = li.attr("config-index");
        var configs = BHzones[i].config;
        var finalStat = !configs[j].active;
        //unselect others
        if (finalStat) {
            for (var k = 0; k < configs.length; k++) {
                var config = configs[k];
                if (config.active) {
                    config.active = false;
                    changeSelect(li.parent("ul").children("[config-index=" + k + "]").children("a")[0], false, config.ip);
                }
            }
        }
        configs[j].active = finalStat;
        changeSelect($(this)[0],finalStat,configs[j].ip);
    });
}

function changeSelect(e, active, ip) {
    if (active) {
        e.innerHTML = '<i style="color: #46a546" class="icon-ok"></i>&nbsp;' + ip;
    }
    else {
        e.innerHTML = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' + ip;

    }
}
