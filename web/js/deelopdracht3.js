function startChatWithFriend(friend) {
    alert(friend);
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
    let $receiverId = $("#receiverId").text() ;

    $.ajax({
        type: "GET",
        url: "Controller?action=GetOneOnOne&receiver=" + $receiverId,
        dataType: "json",
        success: function(json){
            $('#chatMessages').html(json.text);
            setTimeout(getMessages, 3000);
        },
        error: function() {
            alert("could not load messages");
        }
    });

}

