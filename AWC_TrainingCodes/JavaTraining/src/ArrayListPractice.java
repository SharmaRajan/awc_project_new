import java.util.ArrayList;
import java.util.Collections;

public class ArrayListPractice {


    public void practice(){
        // ArrayList storing Heterogeneous objects
        ArrayList  list = new ArrayList();
        list.add("Rajan");
        list.add(10);
        list.add('A');
        list.add(Collections.EMPTY_LIST);

        // making arrays as Heterogeneous objects
        Object[] obj = new Object[10];
        obj[0] = new Student[12];
        obj[1] = new int[12];
        obj[2] = new ArrayList[32];


    }

}
