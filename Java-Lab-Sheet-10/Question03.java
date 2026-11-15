import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Question03 {
    public static void main(String[] args) {
        String fileName = "data.txt";

        // Create sample content when data.txt is not present.
        try {
            java.io.File file = new java.io.File(fileName);
            if (!file.exists()) {
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write("Java is a programming language.\n");
                    writer.write("File handling is an important Java concept.\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Could not create data.txt: " + e.getMessage());
            return;
        }

        int lines = 0, words = 0, characters = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines++;
                characters += line.length();
                String trimmed = line.trim();
                if (!trimmed.isEmpty()) {
                    words += trimmed.split("\\s+").length;
                }
            }
            System.out.println("Lines: " + lines);
            System.out.println("Words: " + words);
            System.out.println("Characters (excluding line breaks): " + characters);
        } catch (IOException e) {
            System.out.println("Error reading data.txt: " + e.getMessage());
        }
    }
}
