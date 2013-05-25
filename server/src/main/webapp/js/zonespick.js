/**
 * Created with IntelliJ IDEA.
 * User: cairne
 * Date: 13-5-12
 * Time: 下午7:52
 * To change this template use File | Settings | File Templates.
 */
$(function () {
    bindDashboardApply();
});

function bindDashboardApply() {
    $("a#link").bind("click", function () {
        $("#hiden").slideDown("fast");
        $("a#link").unbind("click");
        $("a#link").bind("click", function () {
            $("#hiden").slideUp("fast");
            $("a#link").unbind("click");
            bindDashboardApply();
        });
    });
}
