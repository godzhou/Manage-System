/**
 * Created by pengxiang on 11/08 0008.
 */
function ajax() {
    $("#btn").onclick(function () {
        $.ajax({
            type:"post",
            dateType:"json"
        })
    })
}