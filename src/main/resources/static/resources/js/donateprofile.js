$(document).ready(function (){
    $("body").on("click",".edit",function (){
        let element = `<input type="text">`;
        $(".editer").html("");
        $(".editer").append(element);

        $(".edit").addClass("Comfirm");
        $(".edit").attr("value","Comfirm");
        $(".edit").removeClass("edit");

        // let name = $(".editer").children("input").eq(0).val();
        // let purpose = $(".editer").children("input").eq(2).val();
        // let note = $(".editer").children("input").eq(1).val();
        //
        // console.error(name, purpose, note);

    })

    $("body").on("click", ".Comfirm", function (){
        let id = $(".idDonate").text();
        let name = $(".editer").children("input").eq(0).val();
        let purpose = $(".editer").children("input").eq(2).val();
        let note = $(".editer").children("input").eq(1).val();
        console.error(id);
        $.ajax({
            type:"PUT",
            url:"/editDonate",
            dataType:"json",
            data:{
                id:id,
                name: name,
                purpose:purpose,
                note:note,
            },
            success: function (response){
                $(".editer").html("");
                $(".name").text(response.tenDongGop);
                $(".purpose").text(response.mucdich);
                $(".note").text(response.note);

                $(".Comfirm").addClass("edit");
                $(".Comfirm").attr("value","Edit");
                $(".Comfirm").removeClass("Comfirm");
            }
        })
    })

})