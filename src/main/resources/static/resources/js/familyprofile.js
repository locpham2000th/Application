$(document).ready(
    function(){
        $("input[value='Edit']").click(
            function(){
                var a =  $("#test").text();
                $(".information-section .span-2-of-3").html("");
                $(this).attr("value", "Confirm");
                $(this).addClass("chosen");
                
                var element = 
                `
                    <input type="text" placeholder=` + a + `>`
                $(".information-section .span-2-of-3").append(element);
            }
        );

        $(".chosen").click(
            function(){
                alert("Confirmed");
            }
        )
    }
);

