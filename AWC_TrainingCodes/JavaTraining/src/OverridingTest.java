import java.io.IOException;
import java.sql.SQLException;

class GrandParent{

}

class Parent{
    void show() throws SQLException {
        System.out.println("Parent without args");
    }
    void show(String str){
        System.out.println("Parent");
    }
}

class Child extends Parent{

    @Override
    void show() throws NumberFormatException {
//        super.show();
    }

    void show(String str){
        super.show("Parent12234");
        System.out.println("Child");
    }
}





public class OverridingTest {


    public static void main(String[] args) {
//        Parent p = new Parent();
//        p.show("rajan");

        Parent c = new Child();
        c.show("rajan");
    }
}
















