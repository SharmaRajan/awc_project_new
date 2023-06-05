import java.util.LinkedHashMap;

public class HighestFrequency {

    public static void main(String[] args) {
        HighestFrequency freq = new HighestFrequency();
        freq.highestFreqCount("adadihyyyyyinikniiiiiiiiiiiii");
    }

    public void highestFreqCount(String str){
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();

        int count = 0;

        char high = str.charAt(0);

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(count < map.get(ch)){
                count = map.get(ch);
                high = ch;
            }
        }
        System.out.println("High: " + high);
    }


}
