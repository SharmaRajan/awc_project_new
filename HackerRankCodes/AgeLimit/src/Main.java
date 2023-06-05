import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;

        InputReader in = new InputReader(inputStream);

        // read no of test cases
        int loop = in.nextInt();
        String str = null;

        while (loop-- != 0) {
            //reading three numbers for allowing user to take exam
            int minAgeLimitX = in.nextInt();
            int y = in.nextInt();
            int ageA = in.nextInt();

           str = (ageA >= minAgeLimitX && ageA <y) ? "YES": "NO";

            System.out.println(str);
        }
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