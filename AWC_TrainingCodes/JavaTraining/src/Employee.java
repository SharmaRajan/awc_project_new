

// to resolve Comparable exception
// we implements Comparable interface
// because Java cannot sort our Employee Object in the way it sort primitive objects

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

    int roleId;
    String employeeName;

    public Employee(int roleId, String employeeName){
        this.roleId = roleId;
        this.employeeName = employeeName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this)
            return true;
        if(!(obj instanceof Employee)){
            return false;
        }
        Employee emp = (Employee) obj;
        return false;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "roleId=" + roleId +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.roleId - o.roleId;
    }

//    @Override
//    public int compareTo(T o) {
//        retur;
//    }
    public static Comparator<Employee> NameComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getEmployeeName().compareTo(o2.getEmployeeName());
        }
    };

}
