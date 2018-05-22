package com.practice.lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
	
	/**
	 * 
	 * 1. Classic Comparator example.

	Comparator<Developer> byName = new Comparator<Developer>() {
		@Override
		public int compare(Developer o1, Developer o2) {
			return o1.getName().compareTo(o2.getName());
		}
	};
	
	2. Lambda expression equivalent.

	Comparator<Developer> byName = 
		(Developer o1, Developer o2)->o1.getName().compareTo(o2.getName());
	 * 
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		
		List<Employee> list = getListOfEmployees();
		System.out.println("Original List: "+list);
		//Sort Using normal Comparator method
		//sortUsingNormalComparator(list);
		
		//Sort Using Lambda Expression
		sortUsingLambdaExpression(list);
	}

	private static void sortUsingLambdaExpression(List<Employee> list) {
		
		//List has its own sort method
		/*list.sort(new Comparator<Employee>() {
			
			public int compare(Employee e1, Employee e2) {
				return e1.getAge() - e2.getAge();
			}
		});*/
		
		//using lambda--> natural sort applied directly on list
		list.sort((Employee e1, Employee e2) -> e1.getAge() -e2.getAge());
		
		//reversed
		Comparator<Employee> compareWithAge = (Employee e1, Employee e2) -> e1.getAge() -e2.getAge();
		list.sort(compareWithAge.reversed());
		
		//forEach for a list
		list.forEach((employee)->System.out.println(employee));
		
		
	}

	private static void sortUsingNormalComparator(List<Employee> list) {
		//sort by age
		Collections.sort(list, new Comparator<Employee>() {
			
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getAge() - e2.getAge();	
			}
		});
		
		System.out.println("Sorted List on Age: "+list);
		System.out.println("=============================================================");
		//Sort by fname
		Collections.sort(list, new Comparator<Employee>() {
			
			public int compare(Employee e1, Employee e2) {
				return e1.getFname().compareTo(e2.getFname());
			}
		});
		
		System.out.println("Sorted List on First Name: "+list);
		
	}

	private static List<Employee> getListOfEmployees() {
		
		List<Employee> list = new ArrayList<>();
		
		list.add(new Employee("Rajesh", "Kumar", 27, new BigDecimal("50000")));
		list.add(new Employee("Harish", "Malhotra", 25, new BigDecimal("45000")));
		list.add(new Employee("Arun", "Jain", 25, new BigDecimal("85000")));
		list.add(new Employee("Rakesh", "Malhotra", 28, new BigDecimal("75000")));
		list.add(new Employee("Ayush", "Kumar", 28, new BigDecimal("120000")));
				
		return list;
	}
	
	

}

class Employee{
	
	private String fname;
	private String lname;
	private int age;
	private BigDecimal salary;
	
	//Constructor to create the initialized objects
	public Employee(String fname, String lname, int age, BigDecimal salary) {
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.salary = salary;
	}
	
	//Getters and Setters
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	public String toString() {
		
		return "[Employee: "
				+ "{\"fname: \""+this.fname
				+ ",\" lname: \""+this.lname
				+ ",\" age: \""+this.age
				+ ",\" salary: \""+this.salary
				+ "\"}]";
		
	}
	
}
