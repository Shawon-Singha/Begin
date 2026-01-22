import java.io.*;
import java.nio.file.*;
import java.util.*;

public class NoteApp {

    private static final String NOTES_DIR = "notes";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createNotesDirectory();

        while (true) {
            showMenu();
            int choice = getIntInput("Choose an option: ");

            switch (choice) {
                case 1 -> createNote();
                case 2 -> viewAllNotes();
                case 3 -> updateNote();
                case 4 -> deleteNote();
                case 5 -> resetNotes();
                case 6 -> exitApp();
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /* -------------------- MENU -------------------- */

    private static void showMenu() {
        System.out.println("\n===== Note Taking Application =====");
        System.out.println("1. Create New Note");
        System.out.println("2. View All Notes");
        System.out.println("3. Update Note");
        System.out.println("4. Delete Note");
        System.out.println("5. Reset (Delete All Notes)");
        System.out.println("6. Exit");
    }

    /* -------------------- CREATE -------------------- */

    private static void createNote() {
        System.out.println("\nEnter note content:");
        String content = scanner.nextLine();

        if (content.isBlank()) {
            System.out.println("Note cannot be empty.");
            return;
        }

        int nextId = getNextNoteId();
        File noteFile = new File(NOTES_DIR, "note-" + nextId + ".txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(noteFile))) {
            writer.write(content);
            System.out.println("Note created successfully with ID: " + nextId);
        } catch (IOException e) {
            System.out.println("Error creating note.");
        }
    }

    /* -------------------- READ -------------------- */

    private static void viewAllNotes() {
        File[] files = getNoteFiles();

        if (files.length == 0) {
            System.out.println("No notes found.");
            return;
        }

        for (File file : files) {
            System.out.println("\nID: " + extractId(file.getName()));
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                reader.lines().forEach(System.out::println);
            } catch (IOException e) {
                System.out.println("Error reading note.");
            }
        }
    }

    /* -------------------- UPDATE -------------------- */

    private static void updateNote() {
        File[] files = getNoteFiles();
        if (files.length == 0) {
            System.out.println("No notes available to update.");
            return;
        }

        viewAllNotes();
        int id = getIntInput("\nEnter note ID to update: ");
        File noteFile = new File(NOTES_DIR, "note-" + id + ".txt");

        if (!noteFile.exists()) {
            System.out.println("Note not found.");
            return;
        }

        System.out.println("1. Replace note");
        System.out.println("2. Append to note");
        int option = getIntInput("Choose update option: ");

        System.out.println("Enter new content:");
        String newContent = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(noteFile, option == 2))) {

            if (option == 2) writer.newLine();
            writer.write(newContent);
            System.out.println("Note updated successfully.");

        } catch (IOException e) {
            System.out.println("Error updating note.");
        }
    }

    /* -------------------- DELETE -------------------- */

    private static void deleteNote() {
        File[] files = getNoteFiles();
        if (files.length == 0) {
            System.out.println("No notes available to delete.");
            return;
        }

        viewAllNotes();
        int id = getIntInput("\nEnter note ID to delete: ");
        File noteFile = new File(NOTES_DIR, "note-" + id + ".txt");

        if (noteFile.exists() && noteFile.delete()) {
            System.out.println("Note deleted successfully.");
        } else {
            System.out.println("Note not found or could not be deleted.");
        }
    }

    /* -------------------- RESET -------------------- */

    private static void resetNotes() {
        File[] files = getNoteFiles();

        for (File file : files) {
            file.delete();
        }
        System.out.println("All notes deleted successfully.");
    }

    /* -------------------- EXIT -------------------- */

    private static void exitApp() {
        scanner.close();
        System.out.println("Goodbye! Application terminated.");
        System.exit(0);
    }

    /* -------------------- UTILITIES -------------------- */

    private static void createNotesDirectory() {
        File dir = new File(NOTES_DIR);
        if (!dir.exists()) dir.mkdir();
    }

    private static File[] getNoteFiles() {
        File dir = new File(NOTES_DIR);
        return dir.listFiles((d, name) -> name.startsWith("note-") && name.endsWith(".txt"));
    }

    private static int getNextNoteId() {
        int maxId = 0;
        for (File file : getNoteFiles()) {
            maxId = Math.max(maxId, extractId(file.getName()));
        }
        return maxId + 1;
    }

    private static int extractId(String filename) {
        return Integer.parseInt(filename.replaceAll("\\D+", ""));
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }
}
