class Animal {

    makesound():void{

    }

}

class Cat extends Animal{
    makesound():void{
        console.log("Meow");
    }
}

let cat=new Cat;
cat.makesound();