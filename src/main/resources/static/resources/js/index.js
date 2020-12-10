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
    }
)
