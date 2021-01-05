$(document).ready(function (){

    $("#submit").click(function (){
        let id = $("#code").val();
        let hotenchuho = $("#name").val();
        let street = $("#street").val();
        // $.ajax({
        //         type:"POST",
        //         dataType:"json",
        //         url:"/findhogiadinh?id="+id+"&hotenchuho="+hotenchuho+"&street="+street,
        //         success: function (response) {
        //             console.error(response);
        //             $(".body-section").append(response);
        //         }
        //     })
    })
})