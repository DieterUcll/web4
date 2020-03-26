//PUSH ASSIGNMENT
window.onload = openSocket;
var webSocket;
var reactions = document.getElementById("reactions");

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

function send() {
    //grab all data and send it to socket
    var name = document.getElementById("nameInput").value;
    var opinion = document.getElementById("opinionInput").value;
    var rating = document.getElementById("ratingInput").value;
    console.log(name + " thinks " + opinion + " gives it a " + rating);
    webSocket.send(name);
    webSocket.send(opinion);
    webSocket.send(rating);
}

function closeSocket() {
    webSocket.close();
}


function writeResponse(String) {
    reactions.innerHTML += "<br/>" + String;
}