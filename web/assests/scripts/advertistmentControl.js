/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(".dropzone").dropzone({
    dictDefaultMessage: "<i class='sl sl-icon-plus'></i> Click here or drop files to upload"
});

function loadFeatures() {
    $.get("getAllFeatures");
}

$("#addConSt1").click(function () {
    if (fieldsok1()) {
        $.post("postAddStep1", $("#frmAddSt1").serialize(), postAddStp1);
    } else {
        alert("Complete all Fields");
    }
});

function postAddStp1(res) {
    if (res == "true") {
        window.location.href = "submit-property2";
    } else {
        $("#txtErrorMsgSubProp1").text("Something Wrong")
        $("#errorNotifySubProp1").addClass("errorNotifyShow");
    }
}

$("#btCloseSubProp1").click(function () {
    $("#errorNotifySubProp1").removeClass("errorNotifyShow");
});

$("#addPartition").click(function () {
    $.post("getAllPartition", "hh", loadPartitions);
});

function loadPartitions(resList) {
    var parts = JSON.parse(resList);
    var code = '<div class="row"><div class="col-md-3"><select id="opt1" name="txtPartitionType" class="chosen-select-no-single"><option selected disabled >Select an Option</option>';

    for (var i = 2; i < parts.length; i++) {
        code += '<option>' + parts[i][1] + '</option>';
    }
    code += '</select></div><div class="col-md-3"><select name="txtPartitionCount" class="chosen-select-no-single"><option disabled selected>Select an Option</option><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option></select></div><div class="col-md-5"><input name="txtPartitionDesc" type="text" placeholder="description  ( Max 20 Letters - Optional )" /></div></div>';
    $("#containDiv").append(code);
    $("#removePartition").addClass("chosen-select-no-single");
    $("#removePartition").addClass("removeShow");
}

$("#addConSt2").click(function () {

    event.preventDefault();
    if (fieldsok2()) {
        var form = $('#frmAddSt2')[0];
        var data = new FormData(form);
        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "postAddStep2",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (res) {
                if (res == "true") {
                    window.location.href = "pay";
                } else {
                    $("#txtErrorMsgSubProp1").text(res)
                    $("#errorNotifySubProp1").addClass("errorNotifyShow");
                }
            },
            error: function (x) {
                $("#txtErrorMsg").text("Profile picture should be less than 5MB");
                $("#errorNotifySubProp1").addClass("errorNotifyShow");
            }
        });
    } else {
        alert("Complete all the Fields");
    }

});


$("#removePartition").click(function () {
    $("#containDiv").children("div:last").remove();
});

$("#imgInput1").change(function () {
    if (this.files && this.files[0]) {
        var reader = new FileReader();
        reader.onload = function (data) {
            var img = document.getElementById("imgProPic1");
            img.src = data.target.result;
        }
        reader.readAsDataURL(this.files[0]);
    }
});

$("#imgInput2").change(function () {
    if (this.files && this.files[0]) {
        var reader = new FileReader();
        reader.onload = function (data) {
            var img = document.getElementById("imgProPic2");
            img.src = data.target.result;
        }
        reader.readAsDataURL(this.files[0]);
    }
});

$("#imgInput3").change(function () {
    if (this.files && this.files[0]) {
        var reader = new FileReader();
        reader.onload = function (data) {
            var img = document.getElementById("imgProPic3");
            img.src = data.target.result;
        }
        reader.readAsDataURL(this.files[0]);
    }
});


$("#imgInput4").change(function () {
    if (this.files && this.files[0]) {
        var reader = new FileReader();
        reader.onload = function (data) {
            var img = document.getElementById("imgProPic4");
            img.src = data.target.result;
        }
        reader.readAsDataURL(this.files[0]);
    }
});


function x() {
    $.get("loadAdvs");
    setTimeout(function () {
        window.location.href = "home";
    }, 500);
}

// validation -------------------------------------------

$("#txtPrice,#txtArea,#txtZip").keydown(function (eventData) {
    if (!((eventData.which >= 96 && eventData.which <= 105) ||
            (eventData.which >= 48 && eventData.which <= 57))) {
        eventData.preventDefault();
    }
});

function fieldsok1() {
    var isOK = true;

    var title = $("#txtPropertyTitle").val();
    var saleType = $("#txtSaleType option:selected").val();
    var type = $("#txtPropertyType option:selected").val();
    var price = $("#txtPrice").val();
    var area = $("#txtArea").val();
    var address = $("#txtAddress").val();
    var cty = $("#txtCity").val();
    var state = $("#txtState").val();
    var zip = $("#txtZip").val();

    if (title.trim().length === 0) {
        isOK = false;
        $("#txtPropertyTitle").addClass("errorField");
    } else {
        $("#txtPropertyTitle").removeClass("errorField");
    }

    if (saleType.trim().length === 0) {
        isOK = false;
        $("#txtSaleType").addClass("errorField");
    } else {
        $("#txtSaleType").removeClass("errorField");
    }

    if (type.trim().length === 0) {
        isOK = false;
        $("#txtPropertyType").addClass("errorField");
    } else {
        $("#txtPropertyType").removeClass("errorField");
    }

    if (address.trim().length === 0) {
        isOK = false;
        $("#txtAddress").addClass("errorField");
    } else {
        $("#txtAddress").removeClass("errorField");
    }

    if (price.trim().length === 0) {
        isOK = false;
        $("#txtPrice").addClass("errorField");
    } else {
        $("#txtPrice").removeClass("errorField");
    }

    if (area.trim().length === 0) {
        isOK = false;
        $("#txtArea").addClass("errorField");
    } else {
        $("#txtArea").removeClass("errorField");
    }

    if (cty.trim().length === 0) {
        isOK = false;
        $("#txtCity").addClass("errorField");
    } else {
        $("#txtCity").removeClass("errorField");
    }

    if (cty.trim().length === 0) {
        isOK = false;
        $("#txtCity").addClass("errorField");
    } else {
        $("#txtCity").removeClass("errorField");
    }

    if (state.trim().length === 0) {
        isOK = false;
        $("#txtState").addClass("errorField");
    } else {

        $("#txtState").removeClass("errorField");
    }

    if (zip.trim().length === 0) {
        isOK = false;
        $("#txtZip").addClass("errorField");
    } else {
        $("#txtZip").removeClass("errorField");
    }


    return isOK;
}

function fieldsok2() {
    var isOK = true;

    var desc = $("#txtDesc").val();
    var bAge = $("#txtBAge").val();

    if (desc.trim().length === 0) {
        isOK = false;
        $("#txtDesc").addClass("errorField");
    } else {
        $("#txtDesc").removeClass("errorField");
    }

    if (bAge.trim().length === 0) {
        isOK = false;
        $("#txtBAge").addClass("errorField");
    } else {
        $("#txtBAge").removeClass("errorField");
    }

    return isOK;
}


//btSearchAdvanced ========================================
$("#btSearch").click(function () {
    event.preventDefault();
    $.post("searchAdd", $("#searchForm").serialize(), setAds);
});

function setAds(res) {
    window.location.href = "search-results";
}

function viewAdv(id){
    event.preventDefault();
    $.post("viewAdd","id="+id,viewRes);
}

function viewRes(res){
    window.location.href = "single-property";
}

function LoadAllAds(){
    event.preventDefault();
    $.post("searchAdd", $("#searchForm").serialize(), setAds);
}


