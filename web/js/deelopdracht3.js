function startChatWithFriend(friend) {
    console.log(friend);
    $("#receiverName").innerText = friend;
}



$(document).ready(function () {
    $("#sendMessage").click(function () {

        console.log("you send to :" + $("#receiverName").innerHTML + " -> " + $("#message").val());
        // $.post("Controller?action=OneOnOneChat", {message: $message}, function (data) {
        //     var newParagraph = $('<p />').text(data);
        //     $('#chatMessages').append(newParagraph);
        // });
    });
});

