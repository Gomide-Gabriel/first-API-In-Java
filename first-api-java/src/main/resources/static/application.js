
var userContainer = document.getElementById("user-info");


function getUserById(){
    	         
    var id = document.getElementById(id).value;
    var xhr = new XMLHttpRequest();

    var url = 'http://localhost:3306/Usuario/' + id; 
    xhr.open("GET", url, true);

    xhr.onreadystatechange = function () {
		if (this.readyState==4 && this.status == 200){
			var data = JSON.parse(xhr.responseText);
			renderHTML(data);
		}
	}
	xhr.send(); 
}

document.getElementById('getUserBtn').addEventListener("click", getAllUsers ());

function getAllUsers(){
	
	var xhr = new XMLHttpRequest();
	var url = 'http://localhost:8080/Usuario';

	console.log("OOO");
	 
	// body...		
	
	xhr.open("GET", url, true);

	xhr.onreadystatechange = function () {
		if (this.readyState==4 && this.status == 200){
			var data = JSON.parse(xhr.responseText);
			renderHTML(data);
			console.log("AAA");
		}
	}

	xhr.send(); 
	

}


function criarUsuario(){

}


function renderHTML(data){

	var textHtml = "";

	for (var i = 0; i < data.length; i++) {
		textHtml += "<p>" + data[i].userName + " e email é " + data[i].email + ".</p> </br>";
	}

	userContainer.insertAdjacentHTML('beforeend', textHtml)
}