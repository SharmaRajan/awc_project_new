public class Palindrome {


    public boolean isPalindrome(Integer num){

        int sum = 0,rem = 0, temp = num;

        while(num > 0){
            rem = num % 10;
            sum = (sum * 10) + rem;
            num /= 10;
        }

        if(sum == temp){
            return true;
        }
        return false;
    }

    /*public Integer isIntegerPalindrome(Integer num){

    }*/

    public boolean isPalindrome(String str){

//        char[] charArr = new char[str.length()];

        String compareString = "";

        for(int i = str.length() - 1; i >= 0; i--) {
            compareString += str.charAt(i);
        }
//        System.out.println("Compare string: " + compareString);
        if(str.equals(compareString)){
            return true;
        }

        return false;
    }

    /*public String isStringPalindrome(String str){

    }*/
}
