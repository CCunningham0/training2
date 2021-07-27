package day12;

interface I1 {
	public String name = "";
	
	//private void display() {} causes error because interface methods are default public and abstract
	
	public static void display() {} // Can have static methods in interface as of Java 8
	
	default void printThis() {
		System.out.println("print");
	}
}


// Implementing interface
interface Drawable {
	void draw();
	static void area() {
		System.out.println("getting area...");
	}
}

class Circle implements Drawable {
	@Override
	public void draw() {
		System.out.println("drawing...");
	}
}


// Nested interface
interface X {
	void print();
	
	interface Y {
		void display();
	}
}

class Z implements X, X.Y{
	@Override
	public void print() {
		// must implement this method
	}
	
	@Override
	public void display() {
		// must implement this method
	}
}

public class Demo6 {
	public static void main(String[] args) {
		// Implementing interface example
		Circle circleObj = new Circle();
		circleObj.draw();
		Drawable.area();
	}
}
