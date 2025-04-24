import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SmartShiftManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShiftScheduler scheduler = new ShiftScheduler();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Smart Management Shift Scheduling System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Assign Shift");
            System.out.println("3. View Shift Schedule");
            System.out.println("4. Update Shift");
            System.out.println("5. Remove Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();
                    scheduler.addEmployee(id, name);
                    break;

                case 2:
                    System.out.print("Enter Employee ID to Assign Shift: ");
                    int idAssign = sc.nextInt();
                    sc.nextLine();
                    scheduler.assignShift(idAssign, "Morning");
                    break;

                case 3:
                    scheduler.viewSchedule();
                    break;

                case 4:
                    System.out.println("Update Shift feature coming soon!");
                    break;

                case 5:
                    System.out.print("Enter Employee ID to Remove: ");
                    int idRemove = sc.nextInt();
                    scheduler.removeEmployee(idRemove);
                    break;

                case 6:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}

class Employee {
    private int id;
    private String name;
    private String shift;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        this.shift = "Not Assigned";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}

class ShiftScheduler {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(int id, String name) {
        employees.add(new Employee(id, name));
        System.out.println("Employee added!");
    }

    public void assignShift(int id, String shift) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.setShift(shift);
                System.out.println("Default shift assigned (Morning)!");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void viewSchedule() {
        System.out.println("\n--- Shift Schedule ---");
        if (employees.isEmpty()) {
            System.out.println("No employees yet.");
        } else {
            for (Employee emp : employees) {
                System.out.println("ID: " + emp.getId() + ", Name: " + emp.getName() + ", Shift: " + emp.getShift());
            }
        }
    }

    public void updateShift(int id, String newShift) {
        System.out.println("Update Shift functionality not implemented yet.");
    }

    public void removeEmployee(int id) {
        employees.removeIf(emp -> emp.getId() == id);
        System.out.println("Employee removed!");
    }
}