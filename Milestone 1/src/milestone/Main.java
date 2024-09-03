package milestone;


abstract class Shape {
 
 public abstract double calculateArea();
 public abstract double calculatePerimeter();
}


class Circle extends Shape {
 private double radius;


 public Circle(double radius) {
     this.radius = radius;
 }


 public double getRadius() {
     return radius;
 }

 public void setRadius(double radius) {
     this.radius = radius;
 }

 @Override
 public double calculateArea() {
     return Math.PI * radius * radius;
 }

 @Override
 public double calculatePerimeter() {
     return 2 * Math.PI * radius;
 }
}


class Rectangle extends Shape {
 private double length;
 private double width;


 public Rectangle(double length, double width) {
     this.length = length;
     this.width = width;
 }


 public double getLength() {
     return length;
 }

 public void setLength(double length) {
     this.length = length;
 }

 public double getWidth() {
     return width;
 }

 public void setWidth(double width) {
     this.width = width;
 }

 @Override
 public double calculateArea() {
     return length * width;
 }

 @Override
 public double calculatePerimeter() {
     return 2 * (length + width);
 }
}


class Triangle extends Shape {
 private double side1;
 private double side2;
 private double side3;


 public Triangle(double side1, double side2, double side3) {
     this.side1 = side1;
     this.side2 = side2;
     this.side3 = side3;
 }


 public double getSide1() {
     return side1;
 }

 public void setSide1(double side1) {
     this.side1 = side1;
 }

 public double getSide2() {
     return side2;
 }

 public void setSide2(double side2) {
     this.side2 = side2;
 }

 public double getSide3() {
     return side3;
 }

 public void setSide3(double side3) {
     this.side3 = side3;
 }

 @Override
 public double calculateArea() {
    
     double s = (side1 + side2 + side3) / 2;
     return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
 }

 @Override
 public double calculatePerimeter() {
     return side1 + side2 + side3;
 }
}


public class Main {
 public static void main(String[] args) {
     Shape circle = new Circle(5);
     Shape rectangle = new Rectangle(4, 6);
     Shape triangle = new Triangle(3, 4, 5);

     System.out.println("Circle Area: " + circle.calculateArea());
     System.out.println("Circle Perimeter: " + circle.calculatePerimeter());

     System.out.println("Rectangle Area: " + rectangle.calculateArea());
     System.out.println("Rectangle Perimeter: " + rectangle.calculatePerimeter());

     System.out.println("Triangle Area: " + triangle.calculateArea());
     System.out.println("Triangle Perimeter: " + triangle.calculatePerimeter());
 }
}
