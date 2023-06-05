import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapClassTest {

    public static void main(String[] args) {
        ConcurrentHashMapClassTest test = new ConcurrentHashMapClassTest();
//        test.concurrentHashMapTest();
//        test.concurrentTest();
        test.traversingConcurrentHashMap();
    }

    public void concurrentHashMapTest(){
        // create an instance of
        // ConcurrentHashMap
        ConcurrentHashMap<Integer, String> m = new ConcurrentHashMap<>();

        // Insert mappings using
        // put method
        m.put(100, "Hello");
        m.put(101, "Geeks");
        m.put(102, "Geeks");

        // Here we cant add Hello because 101 key
        // is already present in ConcurrentHashMap object
        m.putIfAbsent(101, "Hello");

        // We can remove entry because 101 key
        // is associated with For value
        m.remove(101, "Geeks");

        // Now we can add Hello
        m.putIfAbsent(103, "Hello");

        // We cant replace Hello with For
        m.replace(101, "Hello", "For");
        System.out.println(m);
    }

    public void concurrentTest(){
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Adding elements to the map
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        System.out.println("Map size: " + map.size());

        // Getting values from the map
        int valueA = map.get("A");
        System.out.println("Value of A: " + valueA);

        // Removing elements from the map
        map.remove("B");
        System.out.println("Map size: " + map.size());
    }

    public void traversingConcurrentHashMap() {
        // create an instance of ConcurrentHashMap
        ConcurrentHashMap<Integer, String> chmap = new ConcurrentHashMap<Integer, String>();

        // Add elements using put()
        chmap.put(8, "Third");
        chmap.put(6, "Second");
        chmap.put(3, "First");
        chmap.put(11, "Fourth");

        // Create an Iterator over the
        // ConcurrentHashMap
        Iterator<ConcurrentHashMap.Entry<Integer, String>> itr = chmap.entrySet().iterator();
//        Iterator<Map.Entry<Integer,String>> itr = chmap.entrySet().iterator();

        // The hasNext() method is used to check if there is
        // a next element The next() method is used to
        // retrieve the next element
        while (itr.hasNext()) {
            ConcurrentHashMap.Entry<Integer, String> entry = itr.next();
            System.out.println("Key = " + entry.getKey()
                    + ", Value = "
                    + entry.getValue());
        }
    }
}
