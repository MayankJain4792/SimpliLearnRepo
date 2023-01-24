package LockedMeApplication;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMeApplication {
    private static final String FILE_PATH = "C:\\FSD8PMTO11PM\\LockedMeApplication";

    public static void main(String[] args) {
        while (true) {
            displayWelcomeScreen();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    try {
                        displayFilesInAscendingOrder();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        addFile();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        deleteFile();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        searchFile();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    // Navigate back to the main context
                    break;
                case 6:
                    // Close the application
                    System.out.println("Closing the application...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
                    break;
            }
        }
    }

    private static void displayWelcomeScreen() {
        System.out.println("\n\nWelcome to LockedMeApplication");
        System.out.println("Developer - Mayank Jain\n");
        System.out.println("1. Display files in ascending order");
        System.out.println("2. Add a file to the existing directory list");
        System.out.println("3. Delete a user specified file from the existing directory list");
        System.out.println("4. Search a user specified file from the main directory");
        System.out.println("5. Navigate back to the main context");
        System.out.println("6. Close the application\n------------------------------------------------------------------\n");
    }

    private static void displayFilesInAscendingOrder() throws IOException {
        File directory = new File(FILE_PATH);
        if (!directory.exists()) {
            throw new IOException("Directory not found at the specified file path.");
        }

        String[] fileNames = directory.list();
        Arrays.sort(fileNames);
        System.out.println("Files in ascending order:");
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }

    private static void addFile() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name to add: ");
        String fileName = scanner.nextLine();
        File file = new File(FILE_PATH + "\\" + fileName);
        if (!file.createNewFile()) {
            throw new IOException("Failed to add file. File already exists.");
        }
        System.out.println("File added successfully.");
    }

    private static void deleteFile() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name to delete: ");
        String fileName = scanner.nextLine();
        File directory = new File(FILE_PATH);
        File fileToDelete = new File(directory, fileName);
        if (!fileToDelete.exists()) {
            throw new IOException("File not found.");
        }
        if (!fileToDelete.delete()) {
            throw new IOException("Error deleting file.");
        }
        System.out.println("File " + fileName + " has been deleted.");
    }
    
    private static void searchFile() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name to search: ");
        String fileName = scanner.nextLine();
        File directory = new File(FILE_PATH);
        boolean fileExists = false;
        for (String file : directory.list()) {
            if (file.equalsIgnoreCase(fileName)) {
                System.out.println("File found: " + file);
                fileExists = true;
                break;
            }
        }
        if (!fileExists) {
            throw new IOException("File not found.");
        }
    }

    private static void navigateBackToMainContext() {
        // Code to navigate back to main context
    }

    private static void closeApplication() {
        System.out.println("Closing the application...");
        System.exit(0);
    }
}


