import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        InputStream inputStream =System.in;
        InputReader in =new InputReader(inputStream);

        // read no of test cases
        int loop = in.nextInt();

        while(loop-- != 0){
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            int num3 = in.nextInt();

            int sum = num1 + num2 + num3;

            String str = (sum == 180) ? "YES" : "NO";
            System.out.println(str);
        }


        /*InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        String t = br.readLine();

        for(int i=0; i < Integer.parseInt(t); i++) {
            String[] n = br.readLine().split(" ");

            Integer num1 = Integer.valueOf(n[0]);
            Integer num2 = Integer.valueOf(n[1]);
            Integer num3 = Integer.valueOf(n[2]);

            int sum = num1 + num2 + num3;

            if(sum == 180){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }*/


    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}