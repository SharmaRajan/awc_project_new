import java.util.Arrays;

public class ComparableComparatorInterfaceTest {

    public static void main(String[] args) {

        int[] intArr = {5,9,3,10,1};
        Arrays.sort(intArr);
        System.out.println(intArr);

        Employee[] employees = new Employee[4];
        employees[0] = new Employee(5,"John");
        employees[1] = new Employee(9,"Paul");
        employees[2] = new Employee(1,"Amit");
        employees[3] = new Employee(10,"Anne");

        System.out.println("Sorting by roleId");

        Arrays.sort(employees);
        System.out.println("sorted: " + Arrays.toString(employees));

        System.out.println("Sorting by name");

        Arrays.sort(employees,Employee.NameComparator);
        System.out.println("Sorted by name: " + Arrays.toString(employees));
    }
}
