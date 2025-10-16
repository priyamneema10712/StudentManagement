import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student (Optional)");
            System.out.println("5. Delete Student (Optional)");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }

    public static void addStudent() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter course: ");
        String course = sc.nextLine();

        students.add(new Student(id, name, age, course));
        System.out.println("Student added successfully!");
    }

    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("\n--- All Students ---");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    public static void searchStudent() {
        System.out.print("Enter ID to search: ");
        String id = sc.nextLine();

        for (Student s : students) {
            if (s.getId().equals(id)) {
                System.out.println("Student Found: " + s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void updateStudent() {
        System.out.print("Enter ID to update: ");
        String id = sc.nextLine();

        for (Student s : students) {
            if (s.getId().equals(id)) {
                System.out.print("Enter new name: ");
                s.setName(sc.nextLine());

                System.out.print("Enter new age: ");
                s.setAge(sc.nextInt());
                sc.nextLine();

                System.out.print("Enter new course: ");
                s.setCourse(sc.nextLine());

                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        String id = sc.nextLine();

        for (Student s : students) {
            if (s.getId().equals(id)) {
                students.remove(s);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
