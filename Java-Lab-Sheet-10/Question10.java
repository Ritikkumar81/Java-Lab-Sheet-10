import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Question10 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            File file = new File("employees.txt");

            try (FileWriter writer = new FileWriter(file, true)) {
                System.out.print("Enter Employee ID: ");
                String id = sc.nextLine();
                System.out.print("Enter Employee Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Department: ");
                String department = sc.nextLine();
                System.out.print("Enter Salary: ");
                String salary = sc.nextLine();

                writer.write(id + "|" + name + "|" + department + "|" + salary
                        + System.lineSeparator());
            }

            System.out.print("Enter Employee ID to search: ");
            String searchId = sc.nextLine();
            boolean found = false;

            if (!file.exists()) {
                System.out.println("Employee file does not exist.");
                return;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] details = line.split("\\\\|", -1);
                    if (details.length == 4 && details[0].equals(searchId)) {
                        System.out.println("Employee record found:");
                        System.out.println("Employee ID: " + details[0]);
                        System.out.println("Employee Name: " + details[1]);
                        System.out.println("Department: " + details[2]);
                        System.out.println("Salary: " + details[3]);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("Employee record not found.");
            }
        } catch (IOException e) {
            System.out.println("File operation failed: " + e.getMessage());
        }
    }
}
