package day16;

/*
 * Lambda demo
 */

interface IRectangle {
	public void draw();
}

// first way
class Test implements IRectangle {
	@Override
	public void draw() {
		System.out.println("Drawing...");
	}
}


interface Rectangle {
	void draw();
}


public class Demo9 {
	public static void main(String[] args) {
		// first way
		Test test = new Test();
		test.draw();
	
		// second way - NOT using lambda, have to declare anonymous class
		Rectangle rectangle = new Rectangle() {
			@Override
			public void draw() {
				System.out.println("Drawing...");
			}
		};
		
		
		// third way - using lambda
		Rectangle rectangles = () -> {
			System.out.println("Drawing...");
		};
		rectangles.draw();
	}
}
