$(document).ready(function (){
    $("body").on("click",".edit",function (){
        let element =
            `<input type="text">`;
        $(".editer").html("");
        $(".editer").append(element);
        $(this).addClass("Comfirm");
        $(this).removeClass("edit");
        $(this).attr("value","Comfirm");
    })

    $("body").on("click",".Comfirm",function (){
        let id = $(".idFee").text();
        let name = $(".editer").children("input").eq(0).val();
        let amount = $(".editer").children("input").eq(1).val();
        let purpose = $(".editer").children("input").eq(2).val();
        console.error(id);
        $.ajax({
            type:"PUT",
            url: "/editfee",
            dataType:"json",
            data:{
                code: id,
                newName: name,
                newAmount: amount,
                newPurpose: purpose,
            },
            success: function (response){
                $(".editer").html("");
                $(".name").text(response.tenPhi);
                $(".amount").text(response.donGia);
                $(".purpose").text(response.mucDich);
                $(".Comfirm").attr("value","Edit");
                $(".Comfirm").addClass("edit");
                $(".Comfirm").removeClass("Comfirm");
            }
        })

    })

    $("body").on("click",".add", function (){
        $(".addGiaDinh").html("");
        let element = `<input class="idHoGiaDinh" type="text" >
                       <input class="btn add1" type="button" value="Add">`;
        $(".addGiaDinh").append(element);

    })

    $("body").on("click",".add1", function (){
        let idFamily = $(".idHoGiaDinh").val();
        let idFee = $(".idFee").text();
        console.error(idFamily);

        $.ajax({
            type: "POST",
            url:"/addFamilyIntoFee",
            dataType: "json",
            data: {
                idFamily: idFamily,
                idFee: idFee,
            },
            success: function (response){
                console.error(response);
                if(response.result == "success"){
                    alert("Thành Công");
                }else {
                    alert("Thất bại");
                }
                $(".addGiaDinh").html("");
                let element2 = `<input class="btn edit" type="submit" value="Edit">
                            <input class="btn add" type="submit" value="Add">`;
                $(".addGiaDinh").append(element2);
            }
        })


    })

})