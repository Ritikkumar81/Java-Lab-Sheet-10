import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Question02 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("student.txt"))) {
            String line;
            System.out.println("Contents of student.txt:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Unable to read student.txt. Make sure the file exists.");
        }
    }
}
