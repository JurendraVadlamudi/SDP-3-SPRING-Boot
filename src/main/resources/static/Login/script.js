let container = document.getElementById('container')

toggle = () => {
	container.classList.toggle('sign-in')
	container.classList.toggle('sign-up')
}

setTimeout(() => {
	container.classList.add('sign-in')
}, 200)

function signUp(){

	let name=document.getElementById("name").value;
	let age=document.getElementById("age").value;
	let stdid=document.getElementById("stdid").value;
	let email=document.getElementById("email").value;
	let mobile=document.getElementById("mobile").value;
	let gender;
	let password=document.getElementById("password").value;
	
	var ele = document.getElementsByName('gender');
              
	for(i = 0; i < ele.length; i++) {
		if(ele[i].checked)
		gender=ele[i].value;
	}

	let data={
		"stdid":stdid,
		"name":name,
		"age":age,
		"email":email,
		"mobile":mobile,
		"gender":gender,
		"password":password
	}


	postData("http://localhost:2022/User/add",data).then(res=>{
		console.log(res)
	
	
	});



}



function reset(){

	let name=document.getElementById("uname").value;
	let email=document.getElementById("email").value;
	let mobile=document.getElementById("mobile").value;
	let gender;
	let password=document.getElementById("newpassword").value;
	

	let data={
		"name":name,
		"email":email,
		"mobile":mobile,
		"password":password
	}


	postData("http://localhost:2022/User/add",data).then(res=>{
		console.log(res)
	
	
	});



}











function login() {
  let uname=document.getElementById("uname").value;
  let pass=document.getElementById("pass").value;
  let data={ "id": uname,
    "password": pass}
console.log(uname);
console.log(pass);
	postData("http://localhost:2022/User/login",data).then(res=>{
		console.log(res)
	if(res.res!="NotFound"){
		localStorage.setItem("id",res.res)
		window.location.replace("../Home/index.html");

	}

	else{
		alert("Wrong Credentials")
	}
	
	});



	}
	
	async function postData(url = '', data = {}) {
		const response = await fetch(url, {
			method: 'POST', // *GET, POST, PUT, DELETE, etc.
			headers: {
			  'Content-Type': 'application/json'
			},
			body: JSON.stringify(data) // body data type must match "Content-Type" header
		  });
		return response.json(); // parses JSON response into native JavaScript objects
	  }