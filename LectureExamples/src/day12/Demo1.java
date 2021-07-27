package day12;

class Student {
	public int rollNumber; // unique per student
	public String name; // unique per student
	static public String schoolName = " ABC School"; // memory allocated only once, not unique per student
}



public class Demo1 {
	public static void main(String[] arg) {
		
	
	Student student1 = new Student();
	student1.rollNumber = 1;
	student1.name = "mark";
	
	Student student2 = new Student();
	student2.rollNumber = 2;
	student2.name = "Steve";
	
	}
}
