import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Question05 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("source.txt");
             FileWriter writer = new FileWriter("backup.txt")) {
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }
            System.out.println("File copied from source.txt to backup.txt successfully.");
        } catch (IOException e) {
            System.out.println("Copy failed. Make sure source.txt exists. " + e.getMessage());
        }
    }
}
