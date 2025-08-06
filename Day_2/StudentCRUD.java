import java.util.ArrayList;
import java.util.Scanner;
public class StudentCRUD {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        System.out.println("---- Welcome to Student Record System ----");

        while (choice != 5) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        studentList.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("\n---- Student List ----");
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    private static void updateStudent() {
        System.out.print("Enter ID of student to update: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Student s : studentList) {
            if (s.getId() == id) {
                sc.nextLine(); // consume newline
                System.out.print("Enter new name: ");
                String newName = sc.nextLine();
                System.out.print("Enter new marks: ");
                double newMarks = sc.nextDouble();

                s.setName(newName);
                s.setMarks(newMarks);
                System.out.println("Student updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found with ID: " + id);
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter ID of student to delete: ");
        int id = sc.nextInt();
        boolean removed = false;

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                System.out.println("Student deleted successfully!");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Student not found with ID: " + id);
        }
    }
}

