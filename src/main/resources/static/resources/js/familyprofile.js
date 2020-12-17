$(document).ready(function() {
    $('body').on('click', '.btnEdit', function () {
        let id =  $(".code").text();
        let name = $(".name").text();
        let member =  $(".member").text();
        let address = $(".address").text();
        console.error(id + name + member + address);

        $(".edit").html("");
        $(this).attr("value", "Confirm");
        // $(this).attr("id", "chosen");

        var element =
            `<input type="text">`;
        $(".edit").append(element);
        $(".edit").children("input").eq(0).val(name);
        $(".edit").children("input").eq(1).val(member);
        $(".edit").children("input").eq(2).val(address);
        // $(this).removeClass("btn");
        // $(this).removeClass("submit");
        $(this).addClass("btnconfirm");
        $(this).removeClass("btnEdit");
    })
        $('body').on('click',".btnconfirm",function(){
                let id = $(".code").text();
                let hotenchuho = $(".edit").children("input").eq(0).val();
                let member = $(".edit").children("input").eq(1).val();
                let address = $(".edit").children("input").eq(2).val();
                console.error(id);
                $.ajax({
                    type:"PUT",
                    url:"/edithogiadinh",
                    dataType: "json",
                    data: {
                        id: id,
                        hotenchuho:hotenchuho,
                        sonhanhkhau:member,
                        diachi:address,
                    },
                    success: function (response){
                        $(".edit").html("");
                        $(".name").text(response.hoTenChuHo);
                        $(".member").text(response.soNhanKhau);
                        $(".address").text(response.diachi);
                        $(".nametitle").text(response.hoTenChuHo);
                        $("#edit").addClass("btnEdit");
                        $(".btnconfirm").attr("value","Edit");
                        $(".btnconfirm").removeClass("btnconfirm");

                    }
                })
            }
        );

        $("#remove").click(function (){
            let id = $(".code").text();
            console.error("nhạn xóa")
            $.ajax({
                type:"PUT",
                url:"/deletehogiadinh",
                data:{
                    id:id,
                },
                dataType:"json",
                success: function (response){
                    console.error(response);
                },
                error: function (response){
                    console.error(response);
                }
            })
        })
    }
);

