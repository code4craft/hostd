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
    $("a#apply-a").bind("click", function () {
        apply(BHzones[$(this).attr("file-id")].text)
    });
}
