public class SwapingNumbers {

    public static void main(String[] args) {
        SwapingNumbers swap = new SwapingNumbers();
//        swap.swapTwoNumbers(3,4);
//        swap.swapNumbersByDivision(3,4);
        swap.swapNumbersByAddSub(3,4);
    }

    public void swapTwoNumbers(int num1, int num2){
        num1 ^= num2;
        num2 ^= num1;
        num1 ^= num2;

        System.out.println("num1: " + num1 + " num2: " +num2);
    }

    public void swapNumbersByDivision(int num1, int num2){

        num1 *= num2;
        num2 = num1 /num2;
        num1 = num1 / num2;

        System.out.println("num1: " + num1 + " num2: " + num2);

    }

    public void swapNumbersByAddSub(int num1, int num2){

        num1 += num2;
        num2 = num1 - num2;
        num1 = num1 - num2;

        System.out.println("num1: " + num1 + " num2: " + num2);
    }


}
