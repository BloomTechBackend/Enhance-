let userId = localStorage.getItem("userId");
let url = "https://0qhn27ddqe.execute-api.us-west-2.amazonaws.com/stage/users/" + userId + "/";
let next = document.getElementById("next");
let tempEntry = document.getElementById("entry");
let prompt = document.getElementById("prompt");
let prompts = ["morning (6-10am)", "noon (10-2pm)", "afternoon (2-6pm)", "evening (6-10pm)"]

let date = new Date();
let dd = String(date.getDate()).padStart(2, '0');
let mm = String(date.getMonth() + 1).padStart(2, '0'); //January is 0!
let yyyy = date.getFullYear();
date = mm + dd + yyyy;

let entry = "";

next.addEventListener("click", nextClick);

let count = 0;

function nextClick(event) {
    if (count < 3) {
        prompt.innerText = prompts[count+1];
        entry += prompts[count] + "\n\n" + tempEntry.value + "\n\n\n";
        tempEntry.value = "";
        tempEntry.focus();
        count += 1;
    }
    if (count == 3) {
    prompt.innerText = prompts[count];
    tempEntry.value = "";
    tempEntry.focus();
    next.innerText = "submit";
    next.removeEventListener("click", nextClick);
    next.addEventListener("click", submitEntryClick);
    }
}

function submitEntryClick(event) {
  entry += prompts[count] + "\n\n" + tempEntry.value + "\n\n\n";
 next.removeEventListener("click", submitEntryClick)
  tempEntry.setAttribute("readonly", "");
  tempEntry.value = "please wait for up to 15 seconds";


  let entryObj = {
    "userId": userId,
    "date": date,
    "entry": entry
  }
   axios.post(url + date, entryObj).then((res) => {
         console.log(res);
         tempEntry.value = "entry saved!"
         next.innerText = "return home";
         next.addEventListener("click", returnHomeClick);
    })
    event.preventDefault();
}

function returnHomeClick(event) {
    window.location.href = "index.html";
}