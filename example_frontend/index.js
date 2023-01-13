let url = "https://0qhn27ddqe.execute-api.us-west-2.amazonaws.com/stage/users/";
let entry = document.getElementById("entry")
let get = document.getElementById("get");

get.addEventListener("click", getEntryClick);

function getEntryClick(event) {
   let date = document.getElementById("date").value;
   let userId = localStorage.getItem("userId");
   axios.get(url + userId + "/" + date).then((res) => {
      console.log(res);
      entry.innerHTML = (res.data.entry)
    })
    event.preventDefault();
}
