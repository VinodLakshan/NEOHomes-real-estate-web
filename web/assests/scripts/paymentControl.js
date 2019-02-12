/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $('[data-toggle="popover"]').popover();

    $('#cvc').on('click', function () {
        if ($('.cvc-preview-container').hasClass('hide')) {
            $('.cvc-preview-container').removeClass('hide');
        } else {
            $('.cvc-preview-container').addClass('hide');
        }
    });

    $('.cvc-preview-container').on('click', function () {
        $(this).addClass('hide');
    });
});

$("#PayButton").click(function (){
    event.preventDefault();
    $.post("advPayment","hh", paymentResponse);
});

function paymentResponse(res){
    if (res == "true") {
        window.location.href = "single-property";
    }else{
        alert(res);
    }
}