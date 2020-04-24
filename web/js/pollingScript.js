//PULL ASSIGNMENT

//CODE FUCKER \/
// window.onload = loadFriends;
window.addEventListener("load", startup,false)
// document.getElementById("currentStatus").innerHTML = "Online";

function startup() {
    getStatus();
    loadFriends();
}

var getStatusRequest = new XMLHttpRequest();
var changeStatusRequest = new XMLHttpRequest();
var getFriendsRequest = new XMLHttpRequest();
var addFriendsRequest = new XMLHttpRequest();

// global shit i need
var copyOfServerResponse = null;


function getStatus() {
    getStatusRequest.open("GET", "Controller?action=GetStatus", true);
    getStatusRequest.onreadystatechange = getDataStatus;
    getStatusRequest.send(null);
}

function getDataStatus() {
    if (getStatusRequest.status === 200) {
        if (getStatusRequest.readyState === 4) {
            document.getElementById("currentStatus").innerHTML = getStatusRequest.responseText;
            document.getElementById("statusInput").value = " "
        }
    }
}


function changeStatus() {
    let statusParam = document.getElementById("statusInput").value;
    changeStatusRequest.open("POST", "Controller?action=ChangeStatus&status=" + statusParam, true);
    changeStatusRequest.send();
    getStatus();
}


function loadFriends() {
    getFriendsRequest.open("GET", "Controller?action=GetFriends", true);
    getFriendsRequest.onreadystatechange = getFriends;
    getFriendsRequest.send(null);
}

function getFriends() {
    if (getFriendsRequest.status === 200) {
        if (getFriendsRequest.readyState === 4) {
            let serverResponse = JSON.parse(getFriendsRequest.responseText);
            let tablebody = document.getElementById("friendsTable").lastChild;

            if (copyOfServerResponse == null || JSON.stringify(serverResponse) !== JSON.stringify(copyOfServerResponse)) {
                copyOfServerResponse = serverResponse;
                $("#friendsTable > tbody").empty();
                for (let i = 0; i < serverResponse.length; i++) {

                    let tr = document.createElement("tr");
                    let td1 = document.createElement("td");
                    let td2 = document.createElement("td");

                    let btnName = document.createElement('button');
                    btnName.type = "submit";
                    btnName.id = "startChatBtn";
                    btnName.innerHTML = serverResponse[i].firstName;
                    btnName.onclick = function() {
                        startChatWithFriend(serverResponse[i].userId);
                        getMessages();
                    };
                    td1.appendChild(btnName);

                    td2.innerHTML = serverResponse[i].status;
                    tr.appendChild(td1);
                    tr.appendChild(td2);
                    tablebody.appendChild(tr);
                }
            }
            setTimeout(loadFriends, 5000);
        }
    }
}

function addFriends() {
    let friendId = document.getElementById("friendId").value;

    console.log("id: " + friendId);
    addFriendsRequest.open("POST", "Controller?action=AddFriend&friendId=" + friendId, true);
    // changeStatusRequest.onreadystatechange;
    friendId.value = '';
    addFriendsRequest.send();
}
