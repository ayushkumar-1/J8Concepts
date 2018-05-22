package com.concepts.overview;

//A Java program to demonstrate that both super class
//and subclass constructors refer to same object

//super class
class Fruit
{
 public Fruit()
 {
     System.out.println("Super class constructor");
     System.out.println("Super class object hashcode :" +
                        this.hashCode());
     System.out.println(this.getClass().getName());
 }
 int test() {
		System.out.println("in fruit");
		return 0; 
 }
}

//sub class
class Apple extends Fruit
{
 public Apple()
 {
     System.out.println("Subclass constructor invoked");
     System.out.println("Sub class object hashcode :" +
                        this.hashCode());
     System.out.println(this.hashCode() + "   " +
                        super.hashCode());

     System.out.println(this.getClass().getName() + "  " +
                        super.getClass().getName());
 }
 String test(int a) {
	System.out.println("in apples");
	return "0"; 
 }
}

//driver class
public class Test
{
 public static void main(String[] args)
 {
     Apple myApple = new Apple();
     Fruit f = new Apple();
     myApple.test();
     System.out.println(f.test());

     main("test");
 }
 
 public static void main(String data) {
	 System.out.println("where are you??");
 }
}
