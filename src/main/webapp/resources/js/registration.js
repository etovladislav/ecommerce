/**
 * Created by etovladislav on 06.04.16.
 */
$("#registration-form").submit(function(){
    var $login = $("#login");
    var $password = $("#password").val();
    var $confirmPassword = $("#confirm-password").val();
    var passwordEq = true;
    if($password != $confirmPassword) {
        $("#passwordNotEqual").css("display", "block");
        passwordEq = false;
    }
    var login = $login.val();
    if (login.length == 0) {
        return;
    }
    $.ajax({
        url: "/checkLogin",
        type: "POST",
        data: {
            login: login
        },
        success: function (data) {
            if(data == "true"){
                $('#loginExists').css("display","block");
                return false;
            }else {
                $('#loginExists').css("display","none");
            }
            if(!passwordEq){
                return false;
            }else{
                $("#passwordNotEqual").css("display", "none");
            }
            return true;
        }
    })

})