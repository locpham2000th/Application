$(document).ready(function (){
    $("#submit").click(function (){
        let code = $("#code").val();
        let name = $("#name").val();
        let number = $("#number").val();
        let address = $("#address").val();
        console.error("đã nhận sự kiện");

        $.ajax({
            type:"Post",
            url:"http://localhost:8080/addhogiadinh",
            dataType:"json",
            data:{
                id:code,
                hotenchuho:name,
                sonhankhau:number,
                diachi: address,
                trangthai: 1
            },
            success: function (response) {
                // console.error("response", response);
                console.error(response.result);
                if (response.result === "error"){
                    alert("đã có hộ gia đinh này xin mời nhập lại");
                    code = $("#code").val("");
                    name = $("#name").val("");
                    number = $("#number").val("");
                    address = $("#address").val("");
                }else {
                    alert("Đã thêm thành công");
                    code = $("#code").val("");
                    name = $("#name").val("");
                    number = $("#number").val("");
                    address = $("#address").val("");
                }
            }
        })
    })
    $(".showAll").click(function (){

    })
})