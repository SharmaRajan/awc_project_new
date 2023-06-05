import java.util.LinkedList;
import java.util.List;

public class ConvertListToArray {


    public static void main(String[] args) {
        ConvertListToArray conv = new ConvertListToArray();
//        conv.listToArray();
        conv.list2Array();
    }

    public void listToArray(){
        // Creating a LinkedList of string type by
        // declaring object of List
        List<String> list = new LinkedList<String>();

        // Adding custom element to LinkedList
        // using add() method
        list.add("Geeks");
        list.add("for");
        list.add("Geeks");
        list.add("Practice");

        // Storing it inside array of strings
        String[] arr = new String[list.size()];

        // Converting ArrayList to Array
        // using get() method
        for (int i = 0; i < list.size(); i++)
            arr[i] = list.get(i);

        // Printing elements of array on console
        for (String x : arr)
            System.out.print(x + " ");
    }

    public void list2Array(){
        // Creating an empty LinkedList of string type
        // by declaring object of List
        List<String> list = new LinkedList<String>();

        // Adding elements to above LinkedList
        // using add() method
        list.add("Geeks");
        list.add("for");
        list.add("Geeks");
        list.add("Practice");

        // Converting List to array
        // using toArray() method
        // 1st method
//        String[] arr = list.toArray(new String[0]);

        // 2nd method
        String[] arr = list.stream().toArray(String[] ::new);

        // Printing elements of array
        // using for-each loop
        for (String x : arr)
            System.out.print(x + " ");
    }

}
