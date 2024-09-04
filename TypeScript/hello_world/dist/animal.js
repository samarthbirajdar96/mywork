"use strict";
class Animal {
    makesound() {
    }
}
class Cat extends Animal {
    makesound() {
        console.log("Meow");
    }
}
let cat = new Cat;
cat.makesound();
