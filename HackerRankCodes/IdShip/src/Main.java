import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream =System.in;

        InputReader in =new InputReader(inputStream);

        // read no of test cases
        int loop = in.nextInt();
        String str = null;

        while(loop-- != 0){
            String ch = in.next();
            switch(ch){
                case "B":
                case "b":
                    System.out.println("BattleShip");
                    break;
                case "C":
                    case "c":
                        System.out.println("Cruiser");
                        break;
                case "D":
                case "d":
                    System.out.println("Destroyer");
                    break;
                case "F":
                case "f":
                    System.out.println("Frigate");
                    break;
            }
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