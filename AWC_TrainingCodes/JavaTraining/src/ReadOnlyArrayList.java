import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadOnlyArrayList {

    public static void main(String[] args) {
        ReadOnlyArrayList readOnly = new ReadOnlyArrayList();
        readOnly.arrayListReadOnly();
    }

    public void arrayListReadOnly(){
        List<String> lists = new ArrayList<>();

        lists.add("Bahut din se observe kar raha tha");
        lists.add("Code share karna pade to dekh ke ghabrana nhi");
        lists.add("Main change nhi kar raha code");
        lists.add("Krishna ka idea hai ye maine kuch nhi kiya");


        List<String> readOnlyList = Collections.unmodifiableList(lists);
//        List<String> readOnlyList = List.of("Rajan","Hi there", "sirf element leta hai");

        // throw java.lang.UnsupportedOperationException
//        readOnlyList.add("change karna chahe to exception throw karega");

//        System.out.println("ReadOnlyList: " + readOnlyList.toString());
        System.out.println("ReadOnlyList: " + readOnlyList);

    }

}
