import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Question09 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            try (FileWriter writer = new FileWriter("student_records.txt")) {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("\\nEnter details for student " + i + ":");
                    System.out.print("Roll Number: ");
                    String roll = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();
                    System.out.print("Marks: ");
                    String marks = sc.nextLine();

                    writer.write("Roll Number: " + roll + System.lineSeparator());
                    writer.write("Name: " + name + System.lineSeparator());
                    writer.write("Course: " + course + System.lineSeparator());
                    writer.write("Marks: " + marks + System.lineSeparator());
                    writer.write("--------------------" + System.lineSeparator());
                }
            }

            System.out.println("\\nAll student records saved. Reading records:");
            try (BufferedReader reader = new BufferedReader(new FileReader("student_records.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("File operation failed: " + e.getMessage());
        }
    }
}
