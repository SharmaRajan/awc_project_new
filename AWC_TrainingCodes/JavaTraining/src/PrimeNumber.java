public class PrimeNumber {

    public static void main(String[] args) {
        int n = 15;

        if (isPrime(n, 2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public boolean isPrime(int num){

        for(int i = 2; i <  num/2; i++){ // optimzed code i < Math.sqrt(num)
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    // Checks whether x is prime or composite
    public int ifnotPrime(int prime[], int x)
    {
        // checking whether the value of element
        // is set or not. Using prime[x/64],
        // we find the slot in prime array.
        // To find the bit number, we divide x
        // by 2 and take its mod with 32.
        return (prime[x/64] & (1 << ((x >> 1) & 31)));
    }

    // Marks x composite in prime[]
    public void makeComposite(int prime[], int x)
    {
        // Set a bit corresponding to given element.
        // Using prime[x/64], we find the slot
        // in prime array. To find the bit number,
        // we divide x by 2 and take its mod with 32.
        prime[x/64] |= (1 << ((x >> 1) & 31));
    }

    // Prints all prime numbers smaller than n.
    public void bitWiseSieve(int n)
    {
        // Assuming that n takes 32 bits,
        // we reduce size to n/64 from n/2.
        int prime[] = new int[n/64 + 1];


        // 2 is the only even prime so we
        // can ignore that loop starts from
        // 3 as we have used in sieve of
        // Eratosthenes .
        for (int i = 3; i * i <= n; i += 2) {

            // If i is prime, mark all its
            // multiples as composite
            if (ifnotPrime(prime, i)==0)
                for (int j = i * i, k = i << 1;
                     j < n; j += k)
                    makeComposite(prime, j);
        }

        // writing 2 separately
        System.out.printf("2 ");

        // Printing other primes
        for (int i = 3; i <= n; i += 2)
            if (ifnotPrime(prime, i) == 0)
                System.out.printf("%d ", i);
    }


    static boolean isPrime(int n, int i)
    {

        // Base cases
        if (n <= 2)
            return (n == 2) ? true : false;
        if (n % i == 0)
            return false;
        if (i * i > n)
            return true;

        // Check for next divisor
        return isPrime(n, i + 1);
    }




}
