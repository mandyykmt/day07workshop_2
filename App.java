package day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    @FunctionalInterface
    interface Operator<T> {
        T process(T a, T b);
    }

    public static void main(String[] args) {
        
        if (args[0].equalsIgnoreCase("kill")) {
            System.exit(0);
        }

        List<Employee> employees = getEmployees(); 

        // stream and filter
        List<Employee> filterEmployees = employees.stream().filter(e -> e.getLastName().equalsIgnoreCase("ng")).collect(Collectors.toList());
        System.out.println(filterEmployees);

        Employee emp = employees.stream().filter(e -> e.getLastName().equalsIgnoreCase("ng")).findFirst().get();
        System.out.println(emp);

        // sort by firstname in ascending order
        employees.sort(Comparator.comparing(e -> e.getFirstName()));
        System.out.println(employees);

        // sort by firstname in descending order
        Comparator<Employee> comparator = Comparator.comparing(e -> e.getFirstName());
        employees.sort(comparator.reversed()); // will sort based on reverse order
        System.out.println(employees);

        List<Integer> integers = Arrays.asList(3,6,8,2,9,0,5,4,7,1);
        integers.sort(Comparator.naturalOrder());
        System.out.println(integers);

        // functional interface 
        Operator<Integer> addOperations = (a, b) -> {
            return a + b;
        };
        
        Operator<Integer> minusOperations = (a, b) -> {
            return a - b;
        };

        Operator<String> ConcatOperations = (a, b) -> {
            return a.concat(b);
        };

        System.out.println("Add Operation: " + addOperations.process(5, 2));
        System.out.println("Minus Operation: " + minusOperations.process(10, 2));
        System.out.println("Concat Operation: " + ConcatOperations.process("Let's go ", "home"));
    }

    public static List<Employee> getEmployees() {

        List<Employee> employees = new ArrayList<Employee>();
        
        employees.add(new Employee(1, "Hsien Loong", "Lee", 70));
        employees.add(new Employee(2, "Chee Hean", "Ng", 71));
        employees.add(new Employee(3, "Swee Keat", "Heng", 65));
        employees.add(new Employee(4, "Pritnam", "Singh", 55));
        employees.add(new Employee(5, "Eng Hen", "Ng", 70));
        employees.add(new Employee(6, "Lawrence", "Wong", 50));
        employees.add(new Employee(7, "Ye Kung", "Ong", 50));
        employees.add(new Employee(8, "Darryl", "Ng", 30));
        return employees; 
    }
}
