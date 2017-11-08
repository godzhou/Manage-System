/**
 * Created by pengxiang on 11/06 0006.
 */
$(document).ready(function () {
    $('.fo_ur').focus(
        function () {
            if (this.value == "请输入登录账户"){
                this.value = "";
            }
        }
    )
    $('.fo_ur').blur(
        function () {
            if (this.value == ""){
                this.value = "请输入登陆账户";
            }
        }
    )
});