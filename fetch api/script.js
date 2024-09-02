const data=document.getElementById("demo");
const result = document.getElementById("result");
data.addEventListener("click",function(){
     function fetchData() {
        fetch("https://reqres.in/api/users/3")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Response not appropriate");
                }
                return response.json(); 
            })
            .then(data => {
                // Display the fetched data in the result div
                result.innerHTML = `
                    <p>ID: ${data.data.id}</p>
                    <p>Name: ${data.data.first_name} ${data.data.last_name}</p>
                    <p>Email: ${data.data.email}</p>
                    <img src="${data.data.avatar}" alt="Avatar" />
                `;
            })
             .catch(err => {
                console.log(err);
            })
    }
    fetchData();
});





