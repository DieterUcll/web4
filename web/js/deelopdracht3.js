
window.onload = getBackgroundColor();

function startChatWithFriend(friend) {
    console.log(friend);
    $("#receiverId").html(friend);
    $("#chatMessages").empty();
    $("#chatPop").css("display", "block");
}



$(document).ready(function () {
    $("#sendMessage").click(function () {
        let $senderId = $("#senderId").val();
        let $receiverId = $("#receiverId").text() ;
        let $message = $("#message").val();

        // console.log($senderId + "(you) send to :" + $receiverId + " -> " + $message);

        $.ajax({
            type: "POST",
            url: "Controller?action=SendOneOnOne&sender=" + $senderId + "&receiver=" + $receiverId + "&message=" + $message,
            dataType: "text",
            success: function(data){
                console.log("post returned data: " + data);
                let newParagraph = $('<p />').text(data);
                $('#chatMessages').append(newParagraph);
            },
            error: function() {
                console.log("could not process messages");
            }
        });
        //to clear input field after submit
        $("#message").val('')
    });
});


function getMessages() {
    // console.log("im inside getmessages function");

    let $receiverId = $("#receiverId").text() ;

    $.ajax({
        type: "GET",
        url: "Controller?action=GetOneOnOne&receiver=" + $receiverId,
        dataType: "json",
        success: function(json){
            // console.log(JSON.parse(json));
            $("#chatMessages").empty();
            for(var i = 0; i < json.length; i++) {
                var text = json[i];

                // console.log(text);
                let newParagraph = $('<p />').text(text);
                $('#chatMessages').append(newParagraph);
            }

            setTimeout(getMessages, 5000);
        },
        error: function() {
            console.log("could not load messages");
            setTimeout(getMessages, 5000);
        }
    });

}

//collapse of chat
$(document).ready(function () {
    $("#cycleChatWindow").click(function () {
        console.log("clicked the chat pop");
        let $Pop = $("#chatPop");
        if($Pop == null || $Pop.css("display") === "none") {
            $Pop.css("display", "block");
        } else {
            $Pop.css("display", "none");
        }

    });
});



$(document).ready(function () {
    $("#changeColorBtn").click(function () {
        let $colorCode = $("#color").val();
        console.log($colorCode);


        $.post("Controller?action=ChangeBackground", {colorCode : $colorCode}, function( data ) {
            console.log("data:"+ data)
            $("body").css("background-color", data);
        });
    });
});

function getBackgroundColor() {
    $.get("Controller?action=getBackground", function( data ) {
        $("body").css("background-color", data);
    });
}