let a = 10;
const b = 20;

let result = (a, b) => a + b;


document.getElementById("demo").addEventListener("click", function() {
    let ans = result(a, b);  
    document.getElementById("result").textContent = "The sum is: " + ans;
});
