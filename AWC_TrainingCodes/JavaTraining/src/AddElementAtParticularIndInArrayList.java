import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AddElementAtParticularIndInArrayList {

    public static void main(String[] args) throws Exception{
        AddElementAtParticularIndInArrayList element = new AddElementAtParticularIndInArrayList();
//        element.addElementInArrayList(3);

        element.addElementInArrayList(4);

//        List<Integer> numbers = new ArrayList<>(12);
//        numbers.add(1);
//        System.out.println(element.checkInitialCapacity(numbers));


    }

    public int checkInitialCapacity(List<Integer> al) throws Exception {
            Field field = ArrayList.class.getDeclaredField("elementData");
            field.setAccessible(true);
            return ((Object[]) field.get(al)).length;
    }

    public void addElementInArrayList(int index){

//        List<String> stringList = new ArrayList<String>(index + 1);
        ArrayList<String> stringList = new ArrayList<String>(index + 1);

//        long c = stringList.stream().count();

//        stringList.ensureCapacity(index);

//        System.out.println(stringList.size());

//        stringList.stream().iterator().forEachRemaining(x-> System.out.println(x.length()));
//        stringList.add("rishabh");
        stringList.add("Rajan");

//        if(index < 0 || index > stringList.size())
//            return;

        stringList.add(index,"ArrayList Added at index " + index);
        for(String str: stringList)
            System.out.println(str);
    }
}
