var loginElement = document.querySelector("#login");
var userElement = document.querySelector("#user");
var greetingElement = document.querySelector("#greeting");

function doOnLoad() {
	if (this.status == 200) {
		loginElement.style.display = "none";
		userElement.style.display = "block";
		greetingElement.innerHTML = this.responseText;
	} else {
		greetingElement.innerHTML = "";
		loginElement.style.display = "block";
		userElement.style.display = "none";
	}
}

var xhr = new XMLHttpRequest();
xhr.open("GET", "rest/user");
xhr.onload = doOnLoad;
xhr.send();

function login() {
	var xhr = new XMLHttpRequest();
	var user = document.querySelector("#name").value;
	xhr.open("POST", "rest/user");
	xhr.onload = doOnLoad;
	xhr.send(user);
}

function logout() {
	var xhr = new XMLHttpRequest();
	var user = document.querySelector("#name").value;
	xhr.open("DELETE", "rest/user");
	xhr.onload = doOnLoad;
	xhr.send();
}