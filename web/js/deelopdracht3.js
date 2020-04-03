function startChatWithFriend(friend) {
    alert(friend);
    console.log(friend);
    $("#receiverName").html(friend);

}



$(document).ready(function () {
    $("#sendMessage").click(function () {

        console.log("you send to :" + $("#receiverName").text() + " -> " + $("#message").val());
        // $.post("Controller?action=OneOnOneChat", {message: $message}, function (data) {
        //     var newParagraph = $('<p />').text(data);
        //     $('#chatMessages').append(newParagraph);
        // });
    });
});

