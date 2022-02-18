let container = document.getElementById('container')

toggle = () => {
	container.classList.toggle('sign-in')
	container.classList.toggle('sign-up')
}

setTimeout(() => {
	container.classList.add('sign-up')
}, 200)


function reset(){

	let name=document.getElementById("uname").value;
	let email=document.getElementById("email").value;
	let mobile=document.getElementById("mobile").value;
	let password=document.getElementById("newpassword").value;
	

	let data={
        "id":name,
		"email":email,
		"mobile":mobile,
		"password":password
	}


	postData("http://localhost:2022/User/update",data).then(res=>{
		console.log(res)
	
	
	});



}



