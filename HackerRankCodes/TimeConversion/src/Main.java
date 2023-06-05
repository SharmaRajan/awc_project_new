import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\Desktop\\HackerRankCodes\\TimeConversion/OUTPUT_PATH.txt"));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}



class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here

        String str = null;
        int hour = 12;
        if(s.contains("PM")){
            str = s.substring(0,2);
            if(str.contains("12")){
                str = s.substring(0, 8);
                System.out.println(str);
            }else {
                hour += Integer.parseInt(str);
                str = s.substring(2, 8);
                str = hour + str;
            }
        }else{
            if(s.contains("12")){
                str = s.substring(0,2);
                hour -= Integer.parseInt(str);
                str = s.substring(2,8);
                str = "0" + hour + str;
                System.out.println(str + " fdg");
            }else{
                str = s.substring(0,8);
            }
        }
        return str;
    }

}
