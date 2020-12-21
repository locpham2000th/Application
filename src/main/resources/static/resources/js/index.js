$(document).ready(
    function(){
        // sticky navigation
        $('.family-section').waypoint(
            function(direction){
                if(direction == "down"){
                    $('nav').addClass("sticky");
                }
                else{
                    $('nav').removeClass('sticky');
                }
            },{
                offset: '600px'
            }
        )

        // scroll
        $('a').click(function(event){
            $('html, body').animate({
                scrollTop: $( $.attr(this, 'href') ).offset().top
            }, 1000);
            event.preventDefault();
        });

        $(".addDonate").click(function (){
            let id = $(".idDonate").val();
            let name = $(".nameDonate").val();
            let purpose = $(".purposeDonate").val();
            let note = $(".noteDonate").val();

            $.ajax({
                type:"Post",
                url:"/input",
                dataType:"json",
                data:{
                    id: id,
                    tenDongGop: name,
                    mucDich: purpose,
                    note:note,
                },
                success: function (response) {
                    alert("da them thanh cong");
                },
                error: function () {
                    alert("da xay ra loi");
                }
            })

        })

        $(".addFee").click( function (){
            let id = $(".idFee").val();
            let name = $(".nameFee").val();
            let amount = $(".amountFee").val();
            let purpose = $(".purposeFee").val();
            console.error("ddddddddddd")
            $.ajax({
                type:"Post",
                url:"/addfee",
                dataType:"json",
                data:{
                    code: id,
                    name: name,
                    amount:amount,
                    purpose :purpose,
                },
                success: function (response) {
                    if(response.result === "Success"){
                        alert("Success")
                    }
                    // console.error(response)
                },
            })
        })
    }
)
