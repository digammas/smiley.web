function submit() {
	var message = document.querySelector("#message").value;
	var errorElement = document.querySelector("#error");
	var messageElement = document.querySelector("#result");
	var xhr = new XMLHttpRequest();
	xhr.open("GET", `rest/substitute?msg=${encodeURI(message)}`);
	xhr.onload = function() {
		errorElement.innerHTML = "";
		messageElement.innerHTML = this.responseText;
	}
	xhr.onerror = function() {
		errorElement.innerHTML = "An error occured!";
		messageElement.innerHTML = "";
	}
	xhr.send();
}