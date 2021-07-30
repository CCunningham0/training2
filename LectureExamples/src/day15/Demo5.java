package day15;

import java.io.FileWriter;
import java.io.IOException;

public class Demo5 {
    public static void main(String[] args) throws IOException {
        // it will first check do we have a file by this name
        // or it will create a new file if none found
        FileWriter fw = new FileWriter("data2.txt", true);
        
        fw.write(10);
        fw.write(100);  // single character
        fw.write("This is some message222111");
        fw.write("\n");;
        
        char[] c1 = { 'a', 'b', 'c' };
        
        fw.write(c1);
        fw.write("\n");

        fw.flush();
        fw.close();
    }
}
