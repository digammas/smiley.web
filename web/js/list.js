var panel = document.querySelector("#smiley-panel");

function reload() {
	reset();
	let table = document.querySelector("#smiley-table");
	for(let tr = null; tr = table.querySelector("tr.smiley-row");) table.removeChild(tr);
	let template = document.querySelector("#show-row");
	let xhr = new XMLHttpRequest();
	xhr.open("GET", "rest/smiley");
	xhr.onload = function(data) {
		let list = JSON.parse(data.target.responseText);
		for (let smiley of list) {
			let tr = template.content.querySelector("tr").cloneNode(true);
			tr.id = `row-${smiley.id}`;
			tr.querySelector(".smiley-face").innerHTML = smiley.face;
			tr.querySelector(".smiley-shortcut").innerHTML = smiley.shortcut;
			tr.querySelector(".smiley-actions").dataset.id = smiley.id;
			table.appendChild(tr);
		}
	}
	xhr.send();
}

function fetchAndPopulate(el, name) {
	let id = el.parentElement.dataset.id;
	let xhr = new XMLHttpRequest();
	xhr.open("GET", `rest/smiley/${id}`);
	xhr.onload = function(data) {
		let smiley = JSON.parse(data.target.responseText);
		populateFromTemplate(name, smiley);
	}
	xhr.send();
}

function populateFromTemplate(name, smiley) {
	let template = document.querySelector(name);
	let div = template.content.querySelector("div").cloneNode(true);
	div.querySelector(".smiley-face").value = smiley.face;
	div.querySelector(".smiley-shortcut").value = smiley.shortcut;
	div.querySelector(".smiley-description").value = smiley.description;
	if (smiley.id != null) {
		div.querySelector(".smiley-action").dataset.id = smiley.id;
	}
	reset();
	panel.appendChild(div);
}

function view(element) {
	fetchAndPopulate(element, "#view-panel");
}

function edit(element) {
	fetchAndPopulate(element, "#edit-panel");
}

function add() {
	populateFromTemplate("#edit-panel", {
		face: "",
		shortcut: "",
		description: ""
	});
}

function drop(element) {
	let id = element.parentElement.dataset.id;
	if (window.confirm("Are you sure you want to delete smiley?")) {
		let xhr = new XMLHttpRequest();
		xhr.open("DELETE", `rest/smiley/${id}`);
		xhr.onload = reload;
		xhr.send();
	}
}

function send(element) {
	let id = element.dataset.id;
	let xhr = new XMLHttpRequest();
	let div = element.parentElement;
	let smiley = {
		"face": div.querySelector(".smiley-face").value,
		"shortcut": div.querySelector(".smiley-shortcut").value,
		"description": div.querySelector(".smiley-description").value
	}
	if (id != null) {
		xhr.open("PUT", `rest/smiley/${id}`);
	} else {
		xhr.open("POST", "rest/smiley");
	}
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.onload = reload;
	xhr.send(JSON.stringify(smiley));
}

function reset() {
	while (panel.firstChild != null) panel.removeChild(panel.firstChild);
}

reload();