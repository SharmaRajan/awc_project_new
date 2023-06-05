public class Main {
    public static void main(String[] args) {

        String str2 = " Hello there how are you rajan,            rajan rajan rajan how how are";

        StringReverse reverse = new StringReverse();

        System.out.println("Reversed string: " + reverse.reversedString("rajan"));

        CharacterCount characterCount = new CharacterCount();

        System.out.println("character count: " + characterCount.countChar("rajan"));

        characterCount.iterativeCountChar("Hello there");

        characterCount.characterCount2(str2);

//        count.usingMapForCounting("hello there");

//        count.example("Great responsibility");

//        count.usingStreamForCount("The quick brown fox jumped over the lazy dog.");

//        count.findRepititor("The quick brown fox jumped over the lazy dog.");

//        count.findRepititor("hello there");

        WordCount wordCount = new WordCount();

        System.out.println("Word count: " + wordCount.wordCount(str2));

        wordCount.duplicateWordCount(str2);



        String str = "nitin";
        int num = 171;

        Palindrome palindrome = new Palindrome();

        System.out.println( num + (palindrome.isPalindrome(num) == true ? " is" : " is not ")  + " a palindrome");
        System.out.println( str + (palindrome.isPalindrome(str) == true ? " is" : " is not ")  + " a palindrome");

        Fibonacci fibonacci = new Fibonacci();

        System.out.println("Fibonacci Series: " + fibonacci.isNumFibonacci(6));

        System.out.println("Recursive Fibonacci Series: ");
        fibonacci.recursiveFibo(6);

        PrimeNumber primeNumber = new PrimeNumber();

        int num2 = 171;

        System.out.println(num2 + (primeNumber.isPrime(num2) == true ? " is" : " is not") + " a prime number");

    }
}