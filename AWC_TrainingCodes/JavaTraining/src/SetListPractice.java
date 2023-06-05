import java.util.*;

public class SetListPractice {


    public static void main(String[] args) {
        Employee employee = new Employee(1,"Rajan");
        Employee employee1 = employee;

        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(employee);
        employeeList.add(employee1);

        System.out.println(employeeList);

        Set<Employee> employeeSet = new HashSet<>();

        employeeSet.add(employee);
        employeeSet.add(employee1);

        for(Employee emp: employeeSet){
            System.out.println(emp);
        }

        for(int i = 0; i < employeeSet.size(); i++){
            System.out.println(i + " " + Arrays.asList(employeeSet));
        }

    }

}
