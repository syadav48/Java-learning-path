package stream.collectors;

import java.util.List;
import java.util.stream.Stream;

public class InterviewClass {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("runtime total memory " + runtime.totalMemory()/1024);

        Department department1 = new Department("HR", 101);
        Department department2 = new Department("ADMIN", 102);
        Department department3 = new Department("IT", 103);
        EmployeeIntv employeeIntv1 = new EmployeeIntv(department1, 114, "Rahul");
        EmployeeIntv employeeIntv2 = new EmployeeIntv(department2, 115, "Ravi");
        EmployeeIntv employeeIntv3 = new EmployeeIntv(department3, 116, "Ram");
        List<EmployeeIntv> intv1 = List.of(employeeIntv1, employeeIntv2, employeeIntv3);
        //
        List<String> hr = intv1.stream().filter(x -> x.department.deptName.equals("HR")).map(x -> x.employeeName).toList();
        System.out.println(hr);

        System.out.println("runtime Free memory " + runtime.freeMemory()/1024);
        System.out.println("runtime Max memory " + runtime.maxMemory()/1024);
        System.gc();


    }
}
