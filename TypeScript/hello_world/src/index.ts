// let courseName:string="typescript";
// let numbers:number =12345;

// let isAdmin:boolean=true;

// let value;
// value=1;

//array

// let arr = ["y", "d", "s"];
// // arr[0];
// // arr[1];
// // arr[2];

// // arr[0]=20;
// // console.log(arr)

// arr.forEach(n=>n.)

//tuple

// let user:[number,string]=[1,"sam"];



//enum

// const amar=1;
// const akbar=2;
// const sam=3;

// enum movie{hindi=3,english=4,marathi=5}

// let movielang:movie=movie.marathi;
// console.log(movielang);

//function /////////////////////////////////////////////////

// function sum(a:number,b:number): number {
//   if(a>10){
//     return a*2;

//   }
//   return a+b;
// }
// sum(13,10);

//objects////

//type alisases

// type Student={
//     name:string,
//     age:number,
//     course:string
//     printName:(name:string)=>void
// }

// let student:Student={
// name:"samarth",
// age:22,
// course:"java",

// printName:function(name:string){
//    console.log(name);
// }
// }

// console.log(student);  //{ name: 'samarth', age: 22, course: 'java' }
// student.name="amar";

//type union

// function kgtogm(weight: number | string):number {
//    //return weight*200;donts know string or integer pass
//    //narrowing concept
//    if(typeof weight === "number"){
//        return weight*200;
//    }else{
//     return Number(weight.replace("kg",""))*200 ;
//    }

// }

// kgtogm(10);
// kgtogm('10');

// //intersection

// type Draggable={
//     drag:()=>void
// };

// type Resizeable={
//     resize:()=>void
// };

// type UIWidget=Draggable & Resizeable

// let textbox:UIWidget={
//     drag:()=>{},
//     resize:()=>{}
// }

// //litral type

// type Quantity = 100 | 200;
// type metric ="cm" | "m"


//nullabe type

// function hello(name:string | null){
// if(name){
//     console.log(name.toLowerCase());
// }else{
//     console.log("no null is being given !!");
// }

// }

// hello(null);


//nullish oprator

// let speed :number |null =null;
// let ride ={
//     //speed :speed != null ? speed :30
//     speed :speed ??30
// }



// //assertaion 

// let car=document.getElementById("car") as HTMLInputElement;
// car.value




// //imp Unknown type 


// function render(document:unknown){
//     if(typeof document ==="string"){
//    document.endsWith();
//     }else if(typeof document === "number"){
//       document.toPrecision
// }
// }




//never

// function infiniteloop():never{
//     while(true){
     
//     }
// }

//     infiniteloop();
//     console.log("hello world");



//

