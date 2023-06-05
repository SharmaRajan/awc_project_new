import java.util.Arrays;

public class StringReverse {



    public String reversedString(String str){
        char[] chars = new char[str.length()];


        // method 1
        String revString = "";

        for(int i = str.length() - 1; i >= 0; i--){
            revString+=str.charAt(i);
        }

        // method 2
        String revString2 = "";
        for(int i = str.length() - 1,j = 0; i >= 0; i--,j++){
            chars[j] = str.charAt(i);
            revString2 +=chars[j];
        }

        // method 3
//        String reversed = Arrays.toString(chars);
//        return reversed;

//        return revString2;

        return revString;
    }

}
