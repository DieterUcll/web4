function startChatWithFriend(friend) {
    console.log(friend);
    $("#receiverId").html(friend);

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
            $('#chatMessages').text(JSON.stringify(json));
            setTimeout(getMessages, 5000);
        },
        error: function() {
            console.log("could not load messages");
            setTimeout(getMessages, 5000);
        }
    });

}

