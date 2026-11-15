import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Question08 {
    public static void main(String[] args) {
        File file = new File("input.txt");

        // Create sample content if input.txt is not present.
        if (!file.exists()) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("Java Lab 2026\n");
                writer.write("File handling is useful!");
            } catch (IOException e) {
                System.out.println("Could not create input.txt: " + e.getMessage());
                return;
            }
        }

        int vowels = 0, consonants = 0, digits = 0, spaces = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int value;
            while ((value = reader.read()) != -1) {
                char ch = (char) value;
                if (Character.isLetter(ch)) {
                    if ("aeiouAEIOU".indexOf(ch) >= 0) {
                        vowels++;
                    } else {
                        consonants++;
                    }
                } else if (Character.isDigit(ch)) {
                    digits++;
                } else if (ch == ' ') {
                    spaces++;
                }
            }

            System.out.println("Vowels: " + vowels);
            System.out.println("Consonants: " + consonants);
            System.out.println("Digits: " + digits);
            System.out.println("Spaces: " + spaces);
        } catch (IOException e) {
            System.out.println("Error reading input.txt: " + e.getMessage());
        }
    }
}
