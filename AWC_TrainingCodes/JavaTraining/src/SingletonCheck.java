
class Singleton implements Cloneable{
    private static Singleton instance = new Singleton();

    private Singleton(){}

    @Override
    protected Object clone()
        throws CloneNotSupportedException{
        // for cloning
//        return super.clone();

        // for stopping it from cloning
        throw new CloneNotSupportedException();
    }
    public static Singleton getInstance(){
        return instance;
    }
}



public class SingletonCheck{//} extends Singleton {

    // public instance initialized when loading the class
    public static SingletonCheck instance = new SingletonCheck();

    /*private SingletonCheck()
    {
        super();
        // private constructor
    }*/

    public static void main(String[] args) throws CloneNotSupportedException {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = (Singleton)instance1.clone();
        System.out.println("instance1 hashCode:- "
                + instance1.hashCode());
        System.out.println("instance2 hashCode:- "
                + instance2.hashCode());
    }
}
