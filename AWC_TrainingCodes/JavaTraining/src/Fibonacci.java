public class Fibonacci {


    /*public boolean isFibonacci(Integer num){
        return false;
    }*/

    public String isNumFibonacci(Integer nElement){

        int num1 = 0;
        int num2 = 1;

        int sum = 0;
        String str = num1 + " " + num2 + " ";

        while(nElement >= 2){
            sum = num1 + num2;
            str += sum + " ";
            num1 = num2;
            num2 = sum;
            nElement--;
        }

        return str;
    }

    public void recursiveFibo(int n){
        for(int i = 0; i < n; i++){
            System.out.print(recursiveFibonacci(i) + " ");
        }
        System.out.println();
    }

    private int recursiveFibonacci(int nElement){
        int num1 = 0, num2 = 1, num3;

        if(nElement == 0)
            return nElement;
        if(nElement == 1)
            return nElement;

        return recursiveFibonacci(nElement - 1) + recursiveFibonacci(nElement - 2);
    }


}
