let url = "https://0qhn27ddqe.execute-api.us-west-2.amazonaws.com/stage/users/";
let signIn = document.getElementById("sign in");
let create = document.getElementById("create");
let id = document.getElementById("id");

window.onload = function(e){
  if (localStorage.getItem("userId") != null) {
        window.location.href = "index.html";
  }
}

signIn.addEventListener("click", signInClick);

create.addEventListener("click", createClick);

function signInClick(event) {
    id.innerText = "please wait for up to 15 seconds";
  let userId = document.getElementById("userId").value;
  localStorage.setItem("userId", userId);
  axios.get(url + userId).then((res) => {
    console.log(res);
    if (res.data.errorMessage != "Could not find User with provided userId") {
        window.location.href = "index.html";
    } else {
    id.innerText = "invalid ID";
    }

  })
  event.preventDefault();
}

function createClick(event) {
    id.innerText = "please wait for up to 15 seconds";
  let userId = "non";
  axios.post(url + userId).then((res) => {
    console.log(res);
    let userId = JSON.parse(JSON.stringify(res.data.userId));
    id.innerText = "new user ID: " + userId;
    })
}

