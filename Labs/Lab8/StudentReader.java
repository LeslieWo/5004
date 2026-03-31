import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentReader {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        readStudentsFromFile();
        printAllStudents();
        
        while (true) {
            System.out.println("\n1. Add a student");
            System.out.println("2. Remove a student by specifying the ID number");
            System.out.println("3. Search for a student by ID number");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1) {
                addStudent(scanner);
            } else if (choice == 2) {
                removeStudent(scanner);
            } else if (choice == 3) {
                searchStudent(scanner);
            }
        }
    }

    private static void readStudentsFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                Student student = new Student(parts[0], parts[1], parts[2], parts[3]);
                students.add(student);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printAllStudents() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println("Line " + (i + 1) + ": " + students.get(i));
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        Student student = new Student(firstName, lastName, studentId, email);
        students.add(student);
        
        updateFile();
        printAllStudents();
    }

    private static void removeStudent(Scanner scanner) {
        System.out.print("Enter student ID to remove: ");
        String studentId = scanner.nextLine();
        
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(studentId)) {
                students.remove(i);
                break;
            }
        }
        
        updateFile();
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter student ID to search: ");
        String studentId = scanner.nextLine();
        
        boolean found = false;
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                System.out.println(student);
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Error: Student does not exist");
        }
    }

    private static void updateFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"));
            for (Student student : students) {
                writer.write(student.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}