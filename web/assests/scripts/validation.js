/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$("#txtName").keydown(function (eventData) {
    if ((eventData.which >= 96 && eventData.which <= 105) ||
            (eventData.which >= 48 && eventData.which <= 57)) {
        eventData.preventDefault();
    }
});

$("#txtNic").keydown(function (eventData) {
    
    var accept = [8,46,33,34,35,36,37,38,39,40];
    for(var index in accept){
        if (accept[index] === eventData.which){
            return;
        }
    }
    
    if (!((eventData.which >= 96 && eventData.which <= 105) ||
            (eventData.which >= 48 && eventData.which <= 57))) {
        eventData.preventDefault();
    }
    
    var nic = $("#txtNic").val();
    
    if (nic.length === 10) {
        eventData.preventDefault();
    }
});

$("#txtNic").keyup(function (eventData) {
    var nic = $("#txtNic").val();
    if (nic.length === 9) {
        if (nic.includes("V")) {
        }else{
            $("#txtNic").val(nic + "V");
            $("#txtNic").removeClass('errorText');
        }
    }
    
});

$("#txtNic").focusout(function (){
    var nic = $("#txtNic").val();
    
    if (nic.length < 10 && nic.length > 0) {
        $("#txtNic").addClass('errorText');
        $("#txtNic").focus();
    }else{
        $("#txtNic").removeClass('errorText');
    }
    
    if (nic.length !== 0) {
        
        if (nic.slice(2,5) > 500) {
            $("#txtGender").val("Female");
        }else{
            $("#txtGender").val("Male");
        }
    }
    
});

$("#txtTelephone").keydown(function (eventData) {
    
    var accept = [8,46,33,34,35,36,37,38,39,40];
    for(var index in accept){
        if (accept[index] === eventData.which){
            return;
        }
    }
    
    var tp = $("#txtTelephone").val();
    
    if (!((eventData.which >= 96 && eventData.which <= 105) ||
            (eventData.which >= 48 && eventData.which <= 57))) {
        eventData.preventDefault();
    }
    
    if (tp.length === 10) {
        eventData.preventDefault();
        $("#txtTelephone").removeClass('errorText');
    }
});

$("#txtTelephone").focusout(function (){
    var nic = $("#txtTelephone").val();
    
    if (nic.length < 10 && nic.length > 0) {
        $("#txtTelephone").addClass('errorText');
        $("#txtTelephone").focus();
    }else{
        $("#txtTelephone").removeClass('errorText');
    }
    
});

$("#txtPassCon").focusout(function (){
    var pass1 = $("#txtPass1").val();
    var pass2 = $("#txtPassCon").val();
    
    if (pass1 !== pass2  && pass2.length > 0) {
        $("#txtPassCon").addClass('errorText');
        $("#txtPassCon").focus();
    }else{
        $("#txtPassCon").removeClass('errorText');
        $("#btReg").removeAttr("disabled");
    }
    
});

$("#txtPassCon").keyup(function (){
    var pass1 = $("#txtPass1").val();
    var pass2 = $("#txtPassCon").val();
    
    if (pass1 !== pass2) {
        $("#btReg").attr("disabled", true);
        $("#txtPassCon").addClass('errorText');
    }else{
        $("#btReg").removeAttr("disabled");
        $("#txtPassCon").removeClass('errorText');
    }
    
});