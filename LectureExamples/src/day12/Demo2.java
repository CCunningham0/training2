package day12;



class Counter {
	int count = 0;
	
	public Counter() {
		count++;
		System.out.println(count);
	}
}

// Non-static count var: output is 3 1s (new instance/variable created each time)
// Static count var: output is 1 2 3 (same instance/memory location used for each Counter instance)
public class Demo2 {
	public static void main(String[] args) {
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		Counter c3 = new Counter();
	}
}