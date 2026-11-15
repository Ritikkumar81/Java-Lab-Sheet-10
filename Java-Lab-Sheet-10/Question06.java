import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question06 {
    public static void main(String[] args) {
        File file = new File("notes.txt");

        // Add sample text if the file does not exist.
        if (!file.exists()) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("Java file handling makes it possible to read and write files.\n");
                writer.write("Practice Java to improve your programming skills.\n");
            } catch (IOException e) {
                System.out.println("Could not create notes.txt: " + e.getMessage());
                return;
            }
        }

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the word to search: ");
            String word = sc.nextLine().trim();
            if (word.isEmpty()) {
                System.out.println("Please enter a valid word.");
                return;
            }

            int count = 0;
            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(word) + "\\b",
                    Pattern.CASE_INSENSITIVE);
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        count++;
                    }
                }
            }

            if (count > 0) {
                System.out.println("Word found. Occurrences: " + count);
            } else {
                System.out.println("Word not found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading notes.txt: " + e.getMessage());
        }
    }
}
