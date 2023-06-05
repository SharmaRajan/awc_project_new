import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapPractice {


    public static void main(String[] args) {
        HashMapPractice practice = new HashMapPractice();
//        practice.hashMapIterate();
//        practice.hashMapNullTest();
//        practice.hashMapRemoveTest();
        practice.hashMapUsingIterator();
    }

    public void hashMapIterate(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "baeldung");
        map.put(2, "HashMap");
        map.put(3,"geek for geeks");

        System.out.println(map);

        /*for(Map.Entry<Integer, String> mapVal : map.entrySet()){
            System.out.printf("Key: %d, Value: %s \n",mapVal.getKey(),mapVal.getValue());
        }*/

    }

    // can store null values
    // print in sorted order
    public void hashMapNullTest(){
        HashMap<Integer, String> interviewBitMap = new HashMap<>();

        // hash function = index % 16
        // There is no ordering in a HashMap

        interviewBitMap.put(1,null);
        interviewBitMap.put(7,null);
        interviewBitMap.put(5,null);
        interviewBitMap.put(2,null);
        interviewBitMap.put(4,null);
        interviewBitMap.put(17,null);

        /*for(int i = 0; i < interviewBitMap.size(); i++){
            if(interviewBitMap.containsKey(i)){
                String keyVal = interviewBitMap.get(i);
                System.out.println("Val: " + keyVal);
            }
        }*/

        for(Map.Entry<Integer, String> mapVal : interviewBitMap.entrySet()){
            System.out.println("Key: " + mapVal.getKey() + " Value: " + mapVal.getValue());
        }
//        System.out.println(interviewBitMap);
    }

    public void hashMapRemoveTest(){
        Map<Integer, String> map = new HashMap<>();
        map.put(101,"Red");
        map.put(103,"Green");
        map.put(102,"Yellow");

//        map.remove(103);

        // update the key 103
        map.put(103,"Pink");

        map.remove(106,"Pink");
        System.out.println(map);
    }

    public void hashMapUsingIterator(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "baeldung");
        map.put(2, "HashMap");
        map.put(3,"geek for geeks");
        map.put(4,"Token nahi hai");

        Iterator<Integer> iterator = map.keySet().iterator();

        while(iterator.hasNext()){
            int key = (int) iterator.next();
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }
    }

}
