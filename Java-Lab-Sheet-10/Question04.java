import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Question04 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter roll number: ");
            String roll = sc.nextLine();
            System.out.print("Enter marks: ");
            String marks = sc.nextLine();

            try (FileWriter writer = new FileWriter("students.txt", true)) {
                writer.write("Student Name: " + name + System.lineSeparator());
                writer.write("Roll Number: " + roll + System.lineSeparator());
                writer.write("Marks: " + marks + System.lineSeparator());
                writer.write("--------------------" + System.lineSeparator());
            }
            System.out.println("Student record appended successfully.");
        } catch (IOException e) {
            System.out.println("Error while appending data: " + e.getMessage());
        }
    }
}
