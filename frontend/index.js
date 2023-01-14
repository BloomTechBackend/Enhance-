let url = "https://0qhn27ddqe.execute-api.us-west-2.amazonaws.com/stage/users/";
let entry = document.getElementById("entry");
let get = document.getElementById("get");

get.addEventListener("click", getEntryClick);

function getEntryClick(event) {
    entry.value = "please wait for up to 15 seconds";
   let date = document.getElementById("date").value;
   let userId = localStorage.getItem("userId");
   axios.get(url + userId + "/" + date).then((res) => {
      console.log(res);
      if (res.data.errorMessage != "Could not find journal entry with date " + date) {
            entry.value = res.data.entry;
            entry.setAttribute("readonly", "");
       } else {
       entry.value = "Could not find journal entry with date " + date;
       }
    })
    event.preventDefault();
}
