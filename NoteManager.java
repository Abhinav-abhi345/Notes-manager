import java.io.*;
import java.util.Scanner;

public class NotesManager {
    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to Notes Manager!");

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNote(scanner);
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    System.out.println("Closing...");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose 1-3.");
            }
        } while (choice != 3);

        scanner.close();
    }

 
    private static void addNote(Scanner scanner) {
        System.out.print("Enter your note: ");
        String note = scanner.nextLine();

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) { 
            writer.write(note + "\n");
            System.out.println("Note saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the note.");
        }
    }

    
    private static void viewNotes() {
        System.out.println("\n--- Your Notes ---");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int count = 1;

            while ((line = reader.readLine()) != null) {
                System.out.println(count++ + ". " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No notes found. Add some notes first.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading notes.");
        }
    }
}
