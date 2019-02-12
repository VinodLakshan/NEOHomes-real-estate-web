/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$("#btReg").click(function () {

    event.preventDefault();
    var form = $('#frmRegister')[0];
    var data = new FormData(form);
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "saveUser",
        data: data,
        processData: false,
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (response) {
            if (response !== "true") {
                $("#txtErrorMsg").text(response);
                $("#errorNotify").addClass("errorNotifyShow");

            } else {
                window.location.href = "my-profile";
            }
        },
        error: function (x) {
            $("#txtErrorMsg").text("Profile picture should be less than 5MB");
            $("#errorNotify").addClass("errorNotifyShow");
        }
    });

});

$("#btClose").click(function () {
    $("#errorNotify").removeClass("errorNotifyShow");
});

$("#btClose1").click(function () {
    $("#errorNotifyLogin").removeClass("errorNotifyShow");
});

$("#btCloseUpdateUser").click(function () {
    $("#errorNotifyUpdateUser").removeClass("errorNotifyShow");
});

$("#btLogin").click(function () {
    event.preventDefault();
    $.post("checkLogin", $("#frmLogin").serialize(), loginCheckResponse);
});

function loginCheckResponse(response) {
    if (response == "true") {
        window.location.href = "my-profile";
    } else {
        $("#txtErrorMsgLogin").text("Username or Password incorrect");
        $("#errorNotifyLogin").addClass("errorNotifyShow");
    }
}

$("#imgInput").change(function () {
    if (this.files && this.files[0]) {
        var reader = new FileReader();
        reader.onload = function (data) {
            var img = document.getElementById("imgProPic");
            img.src = data.target.result;
        }
        reader.readAsDataURL(this.files[0]);
    }
});

$("#txtUpdateProImg").change(function () {
    if (this.files && this.files[0]) {
        var reader = new FileReader();
        reader.onload = function (data) {
            var img = document.getElementById("imgProPicUpdate");
            img.src = data.target.result;
        }
        reader.readAsDataURL(this.files[0]);
    }
});

$("#btPassChange").click(function () {
    event.preventDefault();
    $.post("changePass", $("#frm-changePass").serialize(), changePwResponse);
});

function changePwResponse(response) {
    if (response == "passChanged") {
        $("#txtErrorMsgChangePass").text("Password Changed");
        $("#errorNotifyChangePass").addClass("success");
    } else {
        $("#txtErrorMsgChangePass").text(response);
    }
    $("#errorNotifyChangePass").addClass("errorNotifyShow");
}

$("#btCloseChangePass").click(function () {
    $("#errorNotifyChangePass").removeClass("errorNotifyShow");
});

$("#btnSaveChanges").click(function () {

    event.preventDefault();
    var form = $('#frmSaveChanges')[0];
    var data = new FormData(form);
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "updateUser",
        data: data,
        processData: false,
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (response) {
            if (response !== "true") {
                $("#txtErrorMsgUpdateUser").text(response);
                $("#errorNotifyUpdateUser").addClass("success");
                $("#errorNotifyUpdateUser").addClass("errorNotifyShow");

            } else {
                window.location.href = "my-profile";
            }
        },
        error: function (x) {
            $("#txtErrorMsgUpdateUser").text("Profile picture should be less tham 5MB");
            $("#errorNotifyUpdateUser").addClass("errorNotifyShow");
        }
    });

});

function previewProImg() {
    $.post("previewProImg", "hh", loadImg);
}

function loadImg(res) {
    if (res !== "") {
        $("#imgProPicUpdate").attr("src", "data:image/jpg;base64," + res);
    }
}