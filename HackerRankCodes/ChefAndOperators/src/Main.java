
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

//        BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));

//        Scanner input = new Scanner(System.in);

        InputStream inputStream =System.in;

        ReaderClass.InputReader in =new ReaderClass.InputReader(inputStream);

        // read no of test cases
        int loop = in.nextInt();
        String str = null;

        while(loop-- != 0){
            //reading two numbers for comparison
            int num1 = in.nextInt();
            int num2 = in.nextInt();

            str = (num1 == num2 ? "=" : (num1 < num2 ? "<" : ">"));
            System.out.println(str);
        }
    }
}