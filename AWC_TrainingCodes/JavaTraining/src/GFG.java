



// Java code to explain cloning
// issue with singleton

class SuperClass implements Cloneable {

    int i = 10;

    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        return super.clone();
    }
}

// Singleton class
class Singleton1 extends SuperClass {
    // public instance initialized when loading the class
    public static Singleton1 instance = new Singleton1();

    private Singleton1()
    {
        // private constructor
    }

    public static Singleton1 getInstance(){
        return instance;
    }

}

public class GFG {
    public static void main(String[] args)
            throws CloneNotSupportedException
    {
        Singleton1 instance1 = Singleton1.instance;
//        Singleton1 instance1 = Singleton1.getInstance();
        Singleton1 instance2 = (Singleton1)instance1.clone();
        System.out.println("instance1 hashCode:- "
                + instance1.hashCode());
        System.out.println("instance2 hashCode:- "
                + instance2.hashCode());
    }
}

