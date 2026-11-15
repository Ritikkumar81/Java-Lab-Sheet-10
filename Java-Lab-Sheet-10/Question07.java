import java.io.File;
import java.util.Scanner;

public class Question07 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter file or directory name/path: ");
            File file = new File(sc.nextLine());

            System.out.println("Exists: " + file.exists());
            System.out.println("Name: " + file.getName());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Size: " + (file.exists() ? file.length() + " bytes" : "N/A"));
            System.out.println("Is a file: " + file.isFile());
            System.out.println("Is a directory: " + file.isDirectory());
            System.out.println("Readable: " + file.canRead());
            System.out.println("Writable: " + file.canWrite());
        }
    }
}
