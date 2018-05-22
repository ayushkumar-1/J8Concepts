package com.concepts.java8.lambdaFunctional;

import java.util.function.Function;

public class FunctionalInterfaceTest {
	
	public static void main(String[] args) {
		
		/*Person p1 = new Person("Test", "User", 1);
		Person p2 = new Person("Where", "Waldo", 10);*/
		
		ComparatorFn<Person> cmpAge = (p1,p2) -> p2.getAge() - p1.getAge();
		
		ComparatorFn<Person> cmpFirstName = (p1,p2) -> p2.getFirstName().compareTo(p1.getFirstName());
		ComparatorFn<Person> cmpLastName = (p1,p2) -> p2.getLastName().compareTo(p1.getLastName());
		
		//Writing a function<Object as input, type as output>
		Function<Person, Integer> fnAge = p -> p.getAge();
		Function<Person, String> fnFName = p -> p.getFirstName();
		Function<Person, String> fnLName = p -> p.getLastName();
		
		ComparatorFn<Person> cmpPerson = ComparatorFn.comparing(Person::getAge)
				.thenComparing(Person::getFirstName)
				.thenComparing(Person::getLastName);
		//ComparatorFn<Person> cmpPerson = ComparatorFn.comparing(fnAge);
		
		ComparatorFn<Person> cmpPersonOnFN = ComparatorFn.comparing(Person::getFirstName);
		
		ComparatorFn<Person> cmpPersonOnLN = ComparatorFn.comparing(Person::getLastName);
		
	}

}
