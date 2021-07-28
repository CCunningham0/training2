package day13;

import java.io.FileOutputStream;

public class Demo9 {
	/*
	 * Try with resources
	 * Automatically disposes resource after try catch block
	 */
	public static void main(String[] args) {
		// Creates resource (object of FileOutputStream) *data.txt is placed in project directory 
		try (FileOutputStream stream = new FileOutputStream("data.txt")) { 
			System.out.println("Writing data");
			
			String data = "Hello World";
			
			// Converts string into bytes
			byte[] arr = data.getBytes();
			
			// Writes text into the file
			stream.write(arr);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		
		System.out.println("Resource has been closed");
		
	}
}
