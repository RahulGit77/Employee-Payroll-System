import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem {
    private List<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        FullTimeEmployee emp1 = new FullTimeEmployee("Rahul Ranjan", 101, 50000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("Ranjan Kumar", 102, 30, 1500.0);
        FullTimeEmployee emp3 = new FullTimeEmployee("Gulshan patel", 103, 50000.0);
        PartTimeEmployee emp4 = new PartTimeEmployee("Ashutosh Kumar", 104, 30, 1500.0);
        FullTimeEmployee emp5 = new FullTimeEmployee("Ankit kumar", 105, 50000.0);
        PartTimeEmployee emp6 = new PartTimeEmployee("Suraj Kumar", 106, 30, 1500.0);
        FullTimeEmployee emp7 = new FullTimeEmployee("Sumit Kumar", 107, 50000.0);
        PartTimeEmployee emp8 = new PartTimeEmployee("Shubham Kumar", 108, 30, 1500.0);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        payrollSystem.addEmployee(emp4);
        payrollSystem.addEmployee(emp5);
        payrollSystem.addEmployee(emp6);
        payrollSystem.addEmployee(emp7);
        payrollSystem.addEmployee(emp8);
        
        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmployees();

        System.out.println("\nRemoving Employee...");
        payrollSystem.removeEmployee(101);
        payrollSystem.removeEmployee(104);
        payrollSystem.removeEmployee(106);


        System.out.println("\nRemaining Employee Details:");
        payrollSystem.displayEmployees();
    }
}