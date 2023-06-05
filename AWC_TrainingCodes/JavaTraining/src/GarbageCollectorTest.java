import java.util.ArrayList;

public class GarbageCollectorTest {


    private static long outputMem(String pre, long last) {
        Runtime.getRuntime().gc();
        String pre2 = "                    " + pre;
        System.out.print(pre2.substring(pre2.length()-20) + "  ");

        long tv = Runtime.getRuntime().freeMemory();

        System.out.print(tv);

        if (last!=0) {
            System.out.print(" " + (last - tv));
        }

        System.out.println("");

        return tv;
    }

    public static void main(String[] args) {

        long lm = outputMem("Before:",0);

        ArrayList<String> lis = new ArrayList<String>();
        lis.ensureCapacity(10000);

        lm = outputMem("After Aloc:", lm);

        for (int c=0;c<10000;c++) {
            lis.add(new String("ABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABC"));
        };

        lm = outputMem("After Insert:", lm);

        lis.clear();

        lm = outputMem("After Clear:", lm);

        lis.trimToSize();

        lm = outputMem("After trim:", lm);

        lis = null;

        lm = outputMem("After nullify:", lm);

    }

}
