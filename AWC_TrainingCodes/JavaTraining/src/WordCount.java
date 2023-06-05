import java.util.HashMap;
import java.util.Map;

public class WordCount {

    // optimized code
    public int optimizedCount(String str){
        String[] charArr = str.split(" ");
        return charArr.length;
    }

    public int wordCount(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                count++;
            }
        }
        return count;
    }

    public void duplicateWordCount(String str){
        Map<String,Integer> map = new HashMap<String,Integer>();

        String[] c = str.split(" ");

        for (int i = 0; i < c.length; i++) {
            String str1 = c[i];
            if (map.containsKey(str1)) {
                int cnt = map.get(str1);
                map.put(str1, ++cnt);
            } else {
                map.put(str1, 1);
            }
        }

        for(Map.Entry<String,Integer> mapValue : map.entrySet()){
            System.out.println("String: " + mapValue.getKey() + " count: " + mapValue.getValue());
        }
    }



}
