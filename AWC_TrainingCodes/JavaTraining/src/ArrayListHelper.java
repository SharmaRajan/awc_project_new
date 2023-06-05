import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class ArrayListHelper {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(12);

        getArrayListCapacity(list);
    }

    static final Field field;

    static {
        try {
            field = ArrayList.class.getDeclaredField("elementData");
            field.setAccessible(true);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <E> int getArrayListCapacity(ArrayList<E> arrayList) {
        try {
            final E[] elementData = (E[]) field.get(arrayList);
            return elementData.length;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
