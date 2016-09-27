

function TestWebSocket() {

  this.open = function () {
    this.webSocket = new WebSocket('ws://localhost:8080/testsocket/websocket');

    this.webSocket.onerror = function (event) {
      alert(event.data);
    };

    this.webSocket.onopen = function () {
      document.getElementById('messages').innerHTML = 'Connection established';
    };

    this.webSocket.onmessage = function (event) {
      document.getElementById('messages').innerHTML += '<br />' + event.data;
    };

  };

  this.send = function () {
    this.webSocket.send('hello');
    return false;
  };

}

webSocket = new TestWebSocket();

function openConnection() {
  webSocket.open();
}

function sendMessage() {
  webSocket.send();
}

function startListenMessagesFromServer() {
  $.ajax({
    type: "GET",
    url: "webapi/jaxrs"
  });
}


