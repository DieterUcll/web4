//PUSH ASSIGNMENT
window.onload = openSocket;
var webSocket;
var reactions;

    function openSocket() {
    webSocket = new WebSocket("ws://localhost:8081/reaction");

    webSocket.onopen = function (event) {
        writeResponse("Connection open");
    };

    webSocket.onmessage = function (event) {
        writeResponse(event.data);
    };

    webSocket.onclose = function (event) {
        writeResponse("connection closed");
    };
}

function send(numberOfPost) {
    //grab all data and send it to socket
    var name = document.getElementById("nameInput" +numberOfPost).value;
    var opinion = document.getElementById("opinionInput" + numberOfPost).value;
    var rating = document.getElementById("ratingInput" + numberOfPost).value;
    // console.log(name + " thinks " + opinion + " gives it a " + rating);
    webSocket.send(name + " thinks " + opinion + ", gives it a "+ rating + " out of 10" + "|" + numberOfPost);

}

function closeSocket() {
    webSocket.close();
}


function writeResponse(string) {
    var message = string.split('|')[0];
    var id = string.split('|')[1];

    reactions = document.getElementById("reactions" + id).innerHTML  += "<br> - "+message;
}