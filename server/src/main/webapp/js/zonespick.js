/**
 * Created with IntelliJ IDEA.
 * User: cairne
 * Date: 13-5-12
 * Time: 下午7:52
 * To change this template use File | Settings | File Templates.
 */
$(function () {
    bindSlideUp($("a#fold-button"));
    bindAcitve($("a#active-button"));
    bindNew($("a#button-new"));
    bindAdd($("a#button-do-add"));
    bindDelete($("a#delete-button"))
    bindCandidate();
    $('#addModal').bind("keypress", function (e) {
        if ($(e)[0].charCode == 13) {
            doAdd();
        }
    })
    $("#button-clear-domain").bind("click", function () {
        $('#input-domain').val("")
    })
    $("#button-clear-ip").bind("click", function () {
        $('#input-ip').val("")
    })
    $("#button-clear-comment").bind("click", function () {
        $('#input-comment').val("")
    })
    $("#button-share").bind("click",function (){
        var reg = /_zones=([^;]+)/;
        var zones = reg.exec(document.cookie)
        $("#config-share-url").val(window.location.origin+"/z?z="+zones[1])
        $('#shareModal').modal('show');
    });

});

function getConfigHtml(config) {
    var innerHTML = "";
    if (config.active) {
        innerHTML += '<i style="color: #46a546" class="icon-ok"></i>&nbsp;' + config.ip;
    }
    else {
        innerHTML += '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' + config.ip;
    }
    if (config.comment != undefined && config.comment != "") {
        innerHTML += '<span style="color: #93a1a1">&nbsp;&nbsp;&nbsp;('+config.comment+')</span>';
    }
    return innerHTML;
}

function bindCandidate() {
    domainCandidate = domainCandidateDefault;
    ipCandidate = ipCandidateDefault;
    buildCandidate()
    $('#input-domain').typeahead({
        source: domainCandidate,
        items: 4
    })
    $('#input-ip').typeahead({
        source: ipCandidate,
        items: 4
    })
}

function buildCandidate() {
    BHzones.forEach(function (e) {
        var domain = e.domain;
        if (domainCandidate.indexOf(domain) == -1) {
            domainCandidate.push(domain)
        }
        e.config.forEach(function (config) {
            if (ipCandidate.indexOf(config.ip) == -1) {
                ipCandidate.push(config.ip)
            }
        })
    });
}

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

function bindDelete(e) {
    e.bind("click", function () {
        var li = $(this).parent().parent();
        var domainIndex = li.attr("domain-index");
        var configIndex = li.attr("config-index");
        var aa = BHzones[domainIndex].config.splice(configIndex, 1);
        if (BHzones[domainIndex].config.length == 0) {

            var ul = li.parent().parent().parent();
            ul.remove()
        } else {
            li.remove()
        }
        pick(JSON.stringify(BHzones));
    });
}

function bindNew(e) {
    e.bind("click", function () {
        var li = $(this).parent().parent();
        $("input#input-domain").val(li.attr("data-domain"));
        $('#addModal').modal('show');
    });
}

function doAdd() {
    var domain = $("#input-domain").val();
    var ip = $("#input-ip").val();
    var comment = $("#input-comment").val();
    var data = BHzones;
    var domainIndex = data.length;
    for (var i = 0; i < data.length; i++) {
        if (data[i].domain == domain) {
            domainIndex = i;
            break;
        }
    }

    var config = {
        active: false,
        domain: domain,
        ip: ip,
        comment: comment
    };

    if (domainIndex < data.length) {
        var exist = false;
        data[i].config.forEach(function (e) {
            if (e.ip == ip) {
                exist = true;
            }
        })
        if (!exist) {
            var ul = $("ul[data-index=" + domainIndex + "]");
            var configId = ul.children("li").length;
            data[i].config.push(config);
            var newLi = '<li class="ui-btn-up-a ui-btn-inner" data="' + ip + '" domain-index="' + domainIndex + '" config-index="' + configId + '">';
            newLi += '\n<a class="ui-link-inherit" id="active-button" href="javascript:void(0)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' + ip;
            if (comment != "") {
                newLi += '<span style="color: #93a1a1">&nbsp;&nbsp;(' + comment + ')</span>';
            }
            newLi += '</a><span style="float:right;"><a class="ui-link-inherit" href="javascript:void(0)" id="delete-button">Delete<i class="icon-trash"></i></a></span></li>';
            ul.children("li#configs").children("ul").append(newLi);
            bindAcitve(ul.find("li[config-index=" + configId + "]").children("a#active-button"))
            bindDelete(ul.find("li[config-index=" + configId + "]").find("a#delete-button"))
        }
    } else {
        var zone = {
            domain: domain,
            config: [config]
        }
        BHzones.push(zone);
        var bt = baidu.template;
        var data = {
            i: domainIndex,
            zone: zone
        }
        var html = bt("config-template", data);
        $("div#configs-container").append(html);
        var ul = $("ul[data-index=" + domainIndex + "]");
        bindSlideUp(ul.find("a#fold-button"));
        bindAcitve(ul.find("a#active-button"));
        bindNew(ul.find("a#button-new"));
        bindAdd(ul.find("a#button-do-add"));
        bindDelete(ul.find("a#delete-button"))
    }
    $('#addModal').modal("hide");
    $("#empty-tip").remove();
    buildCandidate()
    pick(JSON.stringify(BHzones));
};

function bindAdd(e) {
    e.bind("click", doAdd);
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

function bindAcitve(e) {
    e.bind("click", function () {
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
                    li.parent("ul").children("[config-index=" + k + "]").children("a")[0].innerHTML=getConfigHtml(config);
                }
            }
        }
        configs[j].active = finalStat;
        $(this)[0].innerHTML= getConfigHtml(configs[j])
        pick(JSON.stringify(BHzones));
    });
}
