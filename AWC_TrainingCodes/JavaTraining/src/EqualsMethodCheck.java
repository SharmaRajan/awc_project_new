public class EqualsMethodCheck {

    private String name;

    public EqualsMethodCheck(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean assignmentOperatorCheck(String str1, String str2){
        return str1 == str2;
    }

    public boolean equalsOperatorCheck(String str1, String str2){
        return str1.equals(str2);
    }

    public boolean assignmentOperatorCheckObject(Object obj1, Object obj2){
        return obj1 == obj2;
    }

    public boolean equalsOperatorCheckObject(Object obj1, Object obj2){
        return obj1.equals(obj2);
    }

    public static void main(String[] args) {

        EqualsMethodCheck equalsMethodCheck = new EqualsMethodCheck("rajan");
        EqualsMethodCheck equalsMethodCheck1 = new EqualsMethodCheck("nitin");

        EqualsMethodCheck equalsMethodCheck2 = new EqualsMethodCheck("nitin");

//        System.out.println(equalsMethodCheck.assignmentOperatorCheck("rajan", "rajan"));
//        System.out.println(equalsMethodCheck.equalsOperatorCheck("rajan", "rajan"));

        System.out.println(equalsMethodCheck.equalsOperatorCheckObject(equalsMethodCheck1,equalsMethodCheck2));

    }

}
