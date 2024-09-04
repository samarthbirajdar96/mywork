let map=new Map<string,number>();
map.set("sam",24);
map.set("santosh",38);
map.set("sanjay",29);
map.set("shekhar",34);

for(let[key,value] of map){
    console.log(` ${key}= ${value}`);
}

console.log(map.get("sam"));