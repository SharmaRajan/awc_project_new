import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {

        Collections.sort(arr);

        Long result = 0L;

        for(int i = 0; i < arr.size() -1; i++){
            result += arr.get(i);
        }

        System.out.print(result + " ");

        Collections.sort(arr,Collections.reverseOrder());
        result = 0L;
        for(int i = 0; i < arr.size() -1; i++){
            result += arr.get(i);
        }

        System.out.print(result);
    }

}