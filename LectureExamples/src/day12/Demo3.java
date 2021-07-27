package day12;

 // Example 1
class Calculator {
	// non-static method
	public void addNumber(int num1, int num2) {
		System.out.println(num1 + num2);
	}
	
	// static method
	public static void subNumber(int num1, int num2) {
		System.out.println(num1 - num2);
	}
}

public class Demo3 {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.addNumber(20, 10); // called by instance of class
		
		Calculator.subNumber(20, 10); // called by class
	}
}

// Example 2
class Employee {
	public int empId;
	public String name;
	public static String companyName = "Place";

	public Employee(int empId, String name) {
		this.empId = empId;
		this.name = name;
	}
	
	public void printInfo() {
		System.out.println("Id: " + empId + ", Name: " + name + ", company name: " + companyName);
	}
}


class Demo4 {
	public static void main(String[] args) {
		//Employee emp1 = new Employee();
		
	}
}


