import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CharacterCount {

    public void findRepititor(String str){
//        String s="mmababctamantlslmag";
        int distinct = 0 ;

        for (int i = 0; i < str.length(); i++) {

            for (int j = 0; j < str.length(); j++) {

                if(str.charAt(i)==str.charAt(j))
                {
                    distinct++;

                }
            }
            System.out.println(str.charAt(i)+"--"+distinct);
            String d=String.valueOf(str.charAt(i)).trim();
            str=str.replaceAll(d,"");
            distinct = 0;

        }

    }

    public void usingStreamForCount(String str){
        str
                .chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Object::toString, Collectors.counting()));
    }

    public void usingMapForCounting(String str){
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                int cnt = map.get(c);
                map.put(c, ++cnt);
            } else {
                map.put(c, 1);
            }
        }

        for(Map.Entry<Character,Integer> mapValue : map.entrySet()){
            System.out.println("Character: " + mapValue.getKey() + " count: " + mapValue.getValue());
        }
    }

    public void characterCount2(String str){
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        char[] arr = str.toCharArray();

        for (char value: arr) {
            if (Character.isAlphabetic(value)) {
                if (charMap.containsKey(value)) {
//                    System.out.println("Char MAp value: " + charMap.get(value) + "charmap key: ");
                    charMap.put(value, charMap.get(value) + 1);
                } else {
                    charMap.put(value, 1);
                }
            }
        }

        System.out.println(charMap);
    }

    public void example(String string1){
//        String string1= "Great responsibility";
        int count;

        //Converts given string into character array
        char string[] = string1.toCharArray();
        char[] charArr = new char[string.length];
        int[] countArr = new int[string.length];

        System.out.println("Duplicate characters in a given string: ");
        //Counts each character present in the string
        for(int i = 0; i <string.length; i++) {
            count = 1;
            for(int j = i+1; j <string.length; j++) {
                if(string[i] == string[j] && string[i] != ' ') {
                    count++;
                    //Set string[j] to 0 to avoid printing visited character
                    string[j] = '0';
                }
            }
            //A character is considered as duplicate if count is greater than 1
            if(count > 1 && string[i] != '0')
                System.out.println(string[i]);
        }
    }

    public void iterativeCountChar(String str){

        int count=0,len=0;
        do{
            char name[]=str.toCharArray();
            len=name.length;
            count=0;
            for(int j=0;j<len;j++)
            {
                if((name[0]==name[j])&&((name[0]>=65&&name[0]<=91)||(name[0]>=97&&name[0]<=123) )) // || ( // special characters)
                    count++;
            }
            if(count!=0)
                System.out.println(name[0]+" "+count+" Times");
            str=str.replace(""+name[0],"");
        }while(len != 1);
    }



    public int countChar(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){

            // ASCII a = 97 & z = 122, A = 65 & Z = 90

            if((str.charAt(i) >= 97 && str.charAt(i) <= 122)
                    || (str.charAt(i) >= 65 && str.charAt(i) <= 90)){
                count++;
            }
        }
        return count;
    }


}
