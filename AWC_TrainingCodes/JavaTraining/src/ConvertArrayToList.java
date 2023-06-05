import java.util.ArrayList;
import java.util.List;

public class ConvertArrayToList {


    public static void main(String[] args) {
        ConvertArrayToList conv = new ConvertArrayToList();
        conv.arrayToList();
    }

    public void arrayToList(){

        String[] strArr = new String[]{"Rajan","Hello","There","how", "are","you"};

        List<String> stringList = new ArrayList<String>();

        for(int i = 0; i < strArr.length; i++){
            stringList.add(strArr[i]);
        }

        for(String str : stringList)
            System.out.print(str + " ");
        System.out.println();
    }

}
