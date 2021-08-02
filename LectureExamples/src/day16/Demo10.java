package day16;

interface Hello {
	public String greeting();
}

interface Welcome {
	public String greeting(String name);
}

interface Calculator {
	public int addNumber(int a, int b);
}

interface Say {
	public void sayHello(String name);
}

public class Demo10 {
	public static void main(String[] args) {
		Hello hello = () -> {
			return "Welcome";
		};
		
		System.out.println(hello.greeting());		
	
		// with one param
		Welcome welcome = (name) -> {
			return "Welcome " + name;
		};
		System.out.println(welcome.greeting("Mark"));
		
		// with multiple params
		Calculator calculator = (a, b) -> {
			return a + b;
		};
		System.out.println(calculator.addNumber(10, 5));
	
	
		// without return
		Say say = (name) -> {
			System.out.println("Hello " + name);
		};
		say.sayHello("Watson");
	}
}
