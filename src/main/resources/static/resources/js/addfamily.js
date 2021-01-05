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
                    alert("Family already exists!!!");
                    code = $("#code").val("");
                    name = $("#name").val("");
                    number = $("#number").val("");
                    address = $("#address").val("");
                }else {
                    alert("Add successfully :)");
                    code = $("#code").val("");
                    name = $("#name").val("");
                    number = $("#number").val("");
                    address = $("#address").val("");
                }
            },
            error: function(response){
                alert("Add failed :(")
            }
        })
    })
    $(".showAll").click(function (){

    })
})