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

    $("body").on("click",".add", function (){
        $(".addHoGiaDinh").html("");
        let element = `
                        <div class='row'>
                            <div class="col span-1-of-2">
                                  <input class="idHoGiaDinh" type="text" placeholder="Family ID" >
                                  <input class="amount" type="text" placeholder="Amount">
                             </div>
                            <div class="col span-1-of-2">
                                  <input class="btn add1 cfbtn" type="button" value="Comfirm">
                            </div>
                        </div>
                        `;

        $(".addHoGiaDinh").append(element);
        // console.error($(".addHoGiaDinh").html())
    })

    $("body").on("click",".add1", function (){
        let idHoGiaDinh = $(".idHoGiaDinh").val();
        let idDonate = $(".idDonate").text();
        let amount = $(".amount").val();
        console.error(idHoGiaDinh + idDonate + amount);
        $.ajax({
            type: "POST",
            url: "/addFamilyintoDonate",
            dataType: "json",
            data: {
                idFamily: idHoGiaDinh,
                idDonate: idDonate,
                amount: amount,
            },
            success: function (response){
                console.error(response);
                $(".addHoGiaDinh").html("");
                let element2 = `<input class="btn edit" type="submit" value="Edit">
                            <input class="btn add" type="submit" value="Add">`;
                $(".addHoGiaDinh").append(element2);
            }
        })
    })

})